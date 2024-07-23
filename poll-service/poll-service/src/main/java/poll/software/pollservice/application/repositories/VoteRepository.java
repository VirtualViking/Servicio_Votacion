package poll.software.pollservice.application.repositories;

import poll.software.pollservice.domain.models.Candidate;

import java.util.Map;

public interface VoteRepository {
  void saveVote(String studentDocument, Long candidateId);
  boolean existsVoteByStudentDocument(String studentDocument);
  Map<Candidate, Integer> getVoteStatistics();
}
