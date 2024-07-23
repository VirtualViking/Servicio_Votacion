package poll.software.pollservice.infrastructure.persistence.repositories;

import poll.software.pollservice.application.repositories.CandidateRepository;
import poll.software.pollservice.domain.enums.ShiftTime;
import poll.software.pollservice.domain.models.Candidate;
import poll.software.pollservice.infrastructure.persistence.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateRepositoryJdbcAdapter implements CandidateRepository {

  private final Connection connection;

  public CandidateRepositoryJdbcAdapter() {
    MySQLConnection mySQLConnection = new MySQLConnection();
    this.connection = mySQLConnection.getConnection();
  }
  @Override
  public List<Candidate> getCandidatesByShiftTime(ShiftTime shiftTime) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM candidates WHERE shift_time = ?")) {
      preparedStatement.setString(1, shiftTime.toString());
      ResultSet resultSet = preparedStatement.executeQuery();
      return mapResultSetToCandidates(resultSet);
    } catch (Exception e) {
      throw new RuntimeException("Error getting candidates", e);
    }
  }

  @Override
  public Optional<Candidate> getCandidateById(Long id) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM candidates WHERE id = ?")) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if(!resultSet.next()){
        return Optional.empty();
      }
      Candidate candidate = mapResultSetToCandidate(resultSet);
      return Optional.ofNullable(candidate);
    } catch (Exception e) {
      throw new RuntimeException("Error getting candidate", e);
    }
  }

  private List<Candidate> mapResultSetToCandidates(ResultSet resultSet) throws SQLException {
    List<Candidate> candidates = new ArrayList<>();
    while (resultSet.next()) {
      Candidate candidate = mapResultSetToCandidate(resultSet);
      candidates.add(candidate);
    }
    return candidates;
  }

  private Candidate mapResultSetToCandidate(ResultSet resultSet) throws SQLException {
      // map the result set to a candidate
      Long id = resultSet.getLong("id");
      String firstName = resultSet.getString("first_name");
      String lastName = resultSet.getString("last_name");
      String urlImage = resultSet.getString("url_image");
      String shiftTime = resultSet.getString("shift_time");
      ShiftTime shiftTimeEnum = ShiftTime.valueOf(shiftTime);
      return new Candidate(id,firstName, lastName, urlImage, shiftTimeEnum);

  }
}
