export interface ICity {
  id?: number;
  title?: string;
  provinceId?: number;
}

export class City implements ICity {
  constructor(public id?: number, public title?: string, public provinceId?: number) {}
}
