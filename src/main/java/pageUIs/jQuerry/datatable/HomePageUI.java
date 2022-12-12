package pageUIs.jQuerry.datatable;

public class HomePageUI {
	public static final String PAGING_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGING_PAGE_ACTIVED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";

	// Index cua cot ma minh can enter/ click/ select vao
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String INSERT_BY_ROW_INDEX = "xpath=//tbody/tr/td[@class='ui-widget-content last']/button[@id='tblAppendGrid_Insert_%s']";
	public static final String DELETE_BY_ROW_INDEX = "xpath=//tbody/tr/td[@class='ui-widget-content last']/button[@id='tblAppendGrid_Delete_%s']";
	public static final String MOVEUP_BY_ROW_INDEX = "xpath=//tbody/tr/td[@class='ui-widget-content last']/button[@id='tblAppendGrid_MoveUp_%s']";
	public static final String MOVEDOWN_BY_ROW_INDEX = "xpath=//tbody/tr/td[@class='ui-widget-content last']/button[@id='tblAppendGrid_MoveDown_%s']";
	public static final String ICON_BY_ROW_INDEX = "xpath=//tbody/tr[%s]/td[@class='ui-widget-content last']/button[@title='%s']";

	public static final String LOAD_BUTTON = "css=button#btnLoad";

}
