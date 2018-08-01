import {IDateTime} from '../shared/datetime';
import {IStudent} from '../student/student';

export interface ITeam {

  id: number;
  dateTime: IDateTime;
  students: IStudent[];
  coachId: number;
}
