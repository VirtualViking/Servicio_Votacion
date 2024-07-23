package poll.software.pollservice.infrastructure.persistence.repositories;

import poll.software.pollservice.application.repositories.CandidateRepository;
import poll.software.pollservice.application.repositories.VoteRepository;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.infrastructure.persistence.MySQLConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VoteRepositoryJdbcAdapter implements VoteRepository {
  private final Connection connection;
  private final CandidateRepository candidateRepository;
  public VoteRepositoryJdbcAdapter(CandidateRepository candidateRepository) {
    MySQLConnection mySQLConnection = new MySQLConnection();
    this.connection = mySQLConnection.getConnection();
    this.candidateRepository = candidateRepository;
  }

  @Override
  public void saveVote(String studentDocument, Long candidateId) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO votes (student_document, candidate_id) VALUES (?, ?)")) {
      preparedStatement.setString(1, studentDocument);
      preparedStatement.setLong(2, candidateId);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException("Error saving vote", e);
    }

  }

  @Override
  public boolean existsVoteByStudentDocument(String studentDocument) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM votes WHERE student_document = ?")) {
      preparedStatement.setString(1, studentDocument);
      return preparedStatement.executeQuery().next();
    } catch (Exception e) {
      throw new RuntimeException("Error checking if vote exists", e);
    }
  }

  @Override
  public Map<Candidate, Integer> getVoteStatistics() {
    Map<Candidate, Integer> statistics = new HashMap<>();
    String query = "SELECT candidate_id, COUNT(*) AS vote_count FROM votes GROUP BY candidate_id";

    try (Statement statement  = connection.prepareStatement(query)){
         ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        Long candidateId = resultSet.getLong("candidate_id");
        Integer voteCount = resultSet.getInt("vote_count");

        Optional<Candidate> candidate = candidateRepository.getCandidateById(candidateId);

        if (candidate.isEmpty()) {
          throw new RuntimeException("Candidate not found");
        }

        statistics.put(candidate.get(), voteCount);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return statistics;
  }
}
