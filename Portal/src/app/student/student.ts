export interface IStudent {
  id: number;
  firstName: string;
  lastName: string;
  birthDate: string;
  joinDate: string;
  email: string;
  phoneNumber: string;
  skill: number;
  teamId: number;
  availability: {
    day: number;
    hour: string;
  };
}
