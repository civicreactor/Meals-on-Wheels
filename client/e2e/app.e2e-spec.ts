import { MealsOnWheelsPage } from './app.po';

describe('meals-on-wheels App', () => {
  let page: MealsOnWheelsPage;

  beforeEach(() => {
    page = new MealsOnWheelsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
