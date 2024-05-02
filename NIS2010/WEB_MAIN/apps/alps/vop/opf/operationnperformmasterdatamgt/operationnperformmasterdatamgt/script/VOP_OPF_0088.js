/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0087.js
 *@FileTitle : Reason for Excluding from TPR (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.14
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.14 우지석
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class vop_opf_0087 : vop_opf_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function vop_opf_0087() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0]; // t1sheet1

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn_RowAdd":
			doActionIBSheet(sheetObject1, formObject, COMMAND02);
			break;

		case "btn_RowInsert":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;

		case "btn_RowCopy":
			doActionIBSheet(sheetObject1, formObject, COMMAND01);
			break;

		case "btn_Delete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;
			
		case "btn_DownExcel":
			//sheetObject1.Down2Excel(1);
            var paramObj = new Object();
            paramObj.title = "";
            paramObj.orientation = "Portrait";
            paramObj.columnwidth = "1:5|2:6|3:65";
            var url = ComOpfGetExcelSet(sheetObject1, paramObj);
            sheetObject1.Down2Excel(-1, false,false, true, "", url);			
			break;

		case "btn_close":
			window.close();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object�� �迭�� ��� ���� �ٸ� �׸��; �ϰ�ó���� �ʿ䰡 ��; �� �迭�� ��� �wμ����� �߰��� �� �ִ� �迭: �ҽ�
 * ��ܿ� d��
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet �⺻ ��d �� �ʱ�ȭ body �±��� onLoad �̺�Ʈ�ڵ鷯 ���� ȭ��; ������ �ε��� �Ŀ� ��ó���ؾ� �ϴ� ���;
 * �߰��Ѵ�
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

}

/**
 * ��Ʈ �ʱ⼳d��, ��� d�� param : sheetObj ==> ��Ʈ�:�gƮ, sheetNo ==> ��Ʈ�:�gƮ �±��� ���̵� ����
 * �Ϸù�ȣ ��Ʈ�� �ټ��� ��� ��Ʈ ��ŭ case�� �߰��Ͽ� ��Ʈ �ʱ�ȭ���; �����Ѵ�
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {
			// ���� ��d
			style.height = 482;
			// ��ü �ʺ� ��d
			SheetWidth = mainTable.clientWidth;

			// Hostd�� ��d[�ʼ�][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// ��üMerge ~�� [����, Default msNone]
			MergeSheet = msHeaderOnly;

			// ��üEdit ��� ���� [����, Default false]
			Editable = false;

			// ��d����d[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|No.|Code|Reason for Excluding from TPR";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// �÷�d����d[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// �ش�� ó���� �� �ִ� ��~ ���; ��d�Ѵ�
			InitHeadMode(true, true, false, true, false, false);

			// �ش���d��[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// �����ͼӼ� [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "Seq",	false,  "", dfInteger);			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		"tml_prod_rpt_rsn_cd", true, "", dfNone, 0, false, true, 3,	true);
			InitDataProperty(0, cnt++, dtData, 300, daLeft, false,		"tml_prod_rpt_rsn_desc", false, "", dfNone, 0, true, true);

            InitDataValid(0, "tml_prod_rpt_rsn_cd",  vtEngUpOther, "1,2,3,4,5,6,7,8,9,0,/,-,~,!,@,#,$,%,^,&,*,(,),=,{,},[,],|,:,");
		}
	}
}

// Sheet��� �wμ��� ó��
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // vȸ
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("VOP_OPF_0087GS.do", FormQueryString(formObj));
			}
		}
		break;

	case IBSAVE: // ����
		if(!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
	    formObj.f_cmd.value = MULTI;
	    if(sheetObj.DoSave("VOP_OPF_0087GS.do", FormQueryString(formObj))) {
//			ComShowCodeMessage("OPF50006", 'Data');	//'{?msg1} was saved successfully.'		           		    	
	    }
	    break;

	case IBINSERT: // �Է�
		var row = sheetObj.DataInsert();
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;

	case COMMAND01: // ī��
		var row = sheetObj.DataCopy();
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;

	case COMMAND02: // �߰�
		var row = sheetObj.DataInsert(-1); // -1: ���� �ؿ� �ٿ� row �߰�
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;

	case IBDELETE: // ��f
		ComRowHideDelete(sheetObj, "del_chk");
		break;

	}
}

/**
 * ȭ�� ���Է°��� ���� /ȿ������ �wμ��� ó��
 */
function validateForm(sheetObj, formObj, sAction) {
	if (sAction == IBSAVE) {
		var row = sheetObj.ColValueDupRows("tml_prod_rpt_rsn_cd");
		if (row.length > 0)  {
			ComShowCodeMessage("OPF50005", 'Data');	//'{?msg1} is duplicated.'
			var arrRows = row.split(",");
			sheetObj.SelectCell(arrRows[0],3,true);
			return false;
		}
			
	}

	return true;
}

/* ������ �۾� �� */