import { SettingEnum } from 'app/shared/model/enumerations/setting-enum.model';

export interface ISetting {
  id?: number;
  title?: SettingEnum;
  value?: string;
}

export class Setting implements ISetting {
  constructor(public id?: number, public title?: SettingEnum, public value?: string) {}
}
