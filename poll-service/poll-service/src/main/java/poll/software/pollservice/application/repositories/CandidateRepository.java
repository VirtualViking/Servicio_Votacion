package poll.software.pollservice.application.repositories;

import poll.software.pollservice.domain.enums.ShiftTime;
import poll.software.pollservice.domain.models.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository {

  List<Candidate> getCandidatesByShiftTime(ShiftTime shiftTime);
  Optional<Candidate> getCandidateById(Long id);

}
