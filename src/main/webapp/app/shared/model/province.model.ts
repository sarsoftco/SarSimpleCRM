export interface IProvince {
  id?: number;
  title?: string;
}

export class Province implements IProvince {
  constructor(public id?: number, public title?: string) {}
}
