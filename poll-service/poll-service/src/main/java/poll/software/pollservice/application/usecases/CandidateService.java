package poll.software.pollservice.application.usecases;

import poll.software.pollservice.domain.models.Candidate;

import java.util.List;

public interface CandidateService {
  List<Candidate> getCandidates();
}
