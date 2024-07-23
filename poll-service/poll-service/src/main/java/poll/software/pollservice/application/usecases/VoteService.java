package poll.software.pollservice.application.usecases;

import poll.software.pollservice.domain.models.Candidate;

import java.util.Map;

public interface VoteService {
  void vote(String studentDocument, Long candidateId);
  Map<Candidate, Integer>  getVoteStatistics();
}
