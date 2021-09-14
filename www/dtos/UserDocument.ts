export default class UserDocument {
  country: string | undefined = undefined;
  type: string | undefined = undefined;
  documentNumber: string | undefined = undefined;
  expirationDate: Date | undefined = undefined;
  expeditionDate: Date | undefined = undefined;
  firstName: string | undefined = undefined;
  middleName: string | undefined = undefined;
  lastName: string | undefined = undefined;
  secondLastName: string | undefined = undefined;
  aditionalData: {} = {};
  gender: string | undefined = undefined;
  hasPicture: boolean = false;
}
