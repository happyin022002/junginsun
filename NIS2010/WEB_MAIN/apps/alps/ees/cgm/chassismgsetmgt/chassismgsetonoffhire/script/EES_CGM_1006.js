/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1006.js
 *@FileTitle : Chassis Registration Inquiry/Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.05.29 박의수
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2012.07.10 김창헌 [CHM-201218594-01] Enter나 Retrieve 하지 않고 자동적으로 조회되게 수정
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
 * @class ees_cgm_1006 : ees_cgm_1006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1006() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	
	//sheet
	this.OnPopupClick = OnPopupClick;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var curYear = "";
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var Row = 0;
		switch (srcName) {

		case "btn_add":
			var iRow = sheetObj.rowCount;
			//alert("iRow : " + iRow);
			Row = sheetObject.DataInsert();

			// 추가된 행의 상태값을 Inert 가 아닌 Update 상태로 변경(조회후 업데이트 임.)

			// chungpa 20100408 remove performance
			//for(i=1; i<sheetObj.rowCount+1; i++){
			//	sheetObj.RowStatus(i)="U";
			//}

		  	// 행추가시 날짜 컬럼 Editable > False
			
			/* chungpa 20100409 disable
			sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = false;
			*/
			
			//chungpa 20100409 "I" flag는 처리가 안되는 문제점 fix.
			sheetObj.RowStatus(Row) = "U";
			break;

		case "btn_del":
			// 화면에서만 삭제(DB에서는 삭제되면 안됨.)
			sheet_delete(sheetObj);
			//ComRowHideDelete(sheetObj, "del_chk");
			break;

		case "btn_downexcel":
			// 엑셀파일을 IBSheet 로 다운
			doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
			break;
			
		case "btn_loadexcel":
			// 엑셀파일을 IBSheet 로 로딩
			doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
			
			// 추가된 행의 상태값을 INSERT 가 아닌 UPDATE 상태로 변경(조회후 업데이트 임.)
			for(i=1; i<sheetObj.rowCount+1; i++){
				sheetObj.RowStatus(i)="U";
			}
			break;

		case "btn_retrieve":
			// From 값은 없고 To 값만 있을때 
			if( formObj.eq_no_to.value != ""){
				if( formObj.eq_no_fm.value == ""){
					//alert("앞에 값을 넣어주세요");
					ComShowCodeMessage("CGM10004", "Chassis No");
					formObj.eq_no_fm.focus();
					return;
				}
			}
			if( formObj.chss_rgst_lic_noa.value != ""){
				if( formObj.chss_rgst_lic_no.value == ""){
					ComShowCodeMessage("CGM10004", "License No");
					//alert("앞에 값을 넣어주세요");
					formObj.chss_rgst_lic_no.focus();
					return;
				}
			}
			// 검색 파라메타 필수 입력 값 체크
			if (formObj.chss_veh_id_no.value == ""){
				if(formObj.chss_rgst_lic_no.value == ""){
					if(formObj.chss_rgst_exp_dt.value == ""){ // chungpa 20100217 chss_rgst_exp만 있어도 검색이 되도록.
						if( formObj.eq_no_fm.value == ""){
							ComShowCodeMessage("CGM10004", "Chassis No");
							formObj.eq_no_fm.focus();
							return;
						}
					}
				}
			}
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			
			// STATE CODE 조회
			doActionIBSheet(sheetObject, formObj, SEARCH08);
			// IBSHEET 조회
			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			
			
			ComOpenWait(false);
			break;

		case "btn_new":
			sheetObject.RemoveAll();
			
			//초기화 함수 호출
			objectClear();
			break;

		case "btn_save":
			//선택된 항목만 SAVE Logic을 태움.
			
			doActionIBSheet(sheetObject,formObj,IBSAVE);
			break;

		} // end switch
		tRoleApply();
  }catch(e) {
    if( e == "[object Error]") {
     ComShowMessage(OBJECT_ERROR);
    } else {
     ComShowMessage(e);
    }
  }
}


/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(year) {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

 /**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
 function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.WaitImageVisible = false;

 	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];     
     
	 axon_event.addListener		("change",		"sheet1_OnChange",	"chss_rgst_prd_cd");
	 axon_event.addListenerFormat("keypress",	"obj_keypress",		form);
	 axon_event.addListenerFormat("keyup", 		"search_keyup",		form);

	 /*
	 //Reg. State 콤보호출
	 doActionIBSheet(sheetObj, formObj, SEARCH08);
	 */
     doActionIBSheet(sheetObjects[0], document.form, IBRESET);
     tRoleApply();
     
     sheetObj.WaitImageVisible = true; 
 }
 
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 440;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			//var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 9, 0, true);

			var HeadTitle = "Status||Seq.|Chassis No.|Type/Size|Manufacture Date|Weight(lbs)|Reg. State|Reg. Year|Expiry Date|Expiry Date|License No.|Vehicle ID No.|Title No.|Alias No.1|Alias No.2|On-hire Yard|On-hire Office|On-hire Date|On-hire By|Update Date|Update By|eq_knd_cd";

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [	 ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,SAVENAME,				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"Seq");
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"eq_no",				false,	"",	dfNone,			0,	true,	true,	11);
			InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"eq_tpsz_cd",			false,	"",	dfNone,			0,	false,	true);
	
			InitDataProperty(0,	cnt++,	dtPopupEdit,	120,	daCenter,	true,	"mft_dt",				false,	"",	dfDateYmd,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,			75,		daRight,	false,	"chss_tare_wgt",		false,	"",	dfInteger,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtCombo,		115,	daCenter,	false,	"chss_rgst_ste_cd",		false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"chss_rgst_yr",			false,	"",	dfNone,			0,	true,	true,	4);
			InitDataProperty(0,	cnt++,	dtCombo,		70,		daCenter,	false,	"chss_rgst_prd_cd",		false,	"",	dfNone,			0,	true,	true);

			InitDataProperty(0,	cnt++,	dtPopupEdit,	100,	daCenter,	false,	"chss_rgst_exp_dt",		false,	"",	dfDateYmd,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	false,	"chss_rgst_lic_no",		false,	"",	dfNone,			0,	true,	true,	12);
			InitDataProperty(0,	cnt++,	dtData,			130,	daCenter,	false,	"chss_veh_id_no",		false,	"",	dfNone,			0,	true,	true,	20);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"chss_tit_no",			false,	"",	dfNone,			0,	true,	true,	15);
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"chss_als_no",			false,	"",	dfNone,			0,	true,	true,	11);

			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"n2nd_chss_als_no",		false,	"",	dfNone,			0,	true,	true,	11);
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"onh_yd_cd",			false,	"",	dfNone,			0,	false,	true);

			//chungpa 20090826 On_Hire_xxxx start
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"onh_ofc_cd",			false,	"",	dfNone,			0,	false,	true);
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"cre_dt",				false,	"",	dfDateYmd,		0,	false,	true);
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"cre_usr_id",			false,	"",	dfNone,			0,	false,	true);
			InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"chss_rgst_upd_dt",		false,	"",	dfDateYmd,		0,	false,	true);
			InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	false,	"chss_rgst_upd_id",		false,	"",	dfNone,			0,	false,	true);
			//InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	false,	"upd_dt",		false,	"",	dfDateYmd,		0,	false,	true);
			//InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	false,	"upd_usr_id",			false,	"",	dfNone,			0,	false,	true);
			//chungpa 20090826 On_Hire_xxxx end
			
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	false,	"eq_knd_cd",			false,	"",	dfNone,			0,	true,	true);

			//CountPosition = 0;
			// 해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
			InitHeadColumn("col1", "Initial Plan|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|", daCenter);
			InitHeadColumn("col2", ""+curYear+"|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC", daCenter);
			PopupImage = "img/btns_calendar.gif";
			ShowButtonImage = 2;

            InitDataCombo(0, "chss_rgst_prd_cd" , "PMNT|Fixed", "P|F");	// 콤보
            InitDataValid(0, "chss_rgst_yr", vtNumericOnly);			// 입력값 제한
		}
		sheetObj.InitDataValid(0, "eq_no", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = true;
	//sheetObj.ShowDebugMsg = false;
	//var formObj = document.form;
	//var sheetObj = sheetObjects[0];
	
	switch (sAction) {

	case IBSEARCH: // 조회
		if(validateForm(sheetObj,formObj,sAction)){
			
			var Row = 0;
			formObj.f_cmd.value = SEARCH;
			formObj.eq_no_tmp.value = ""; // chungpa 20100409 전체 search의 경우 eq_no_tmp데이터가 있으면 단일 데이터만 Query해오는 문제점 patch.
										  // ex) 데이터 add후 처리 save한 후 다시 재 쿼리 해오는 경우 eq_no_tmp때문에 전체 데이터를 못불러 온다. fixed.
			sheetObj.DoSearch("EES_CGM_1006GS.do", FormQueryString(formObj));

			// Expiry Date 가 PMNT인 경우 Date Disable
			if(sheetObj.rowCount < 1) 
			{
				return; //chungpa 20090826 On_Hire_xxxx
			}
			
			/* chungpa 20100409 disable
			for(i=1; i<sheetObj.rowCount+1; i++){
				if(sheetObj.CellValue(i, "chss_rgst_prd_cd") == 'P'){
					sheetObj.CellEditable(i, "chss_rgst_exp_dt") = false;
				} else {
					sheetObj.CellEditable(i, "chss_rgst_exp_dt") = true;
				}
				
			}
			
			for(var i=1; i<sheetObj.rowCount+1; i++){
			// 조회후 셀을 해당 셀을 활성화시켜준다
				sheetObj.CellEditable(i, "mft_dt")           = true;
				sheetObj.CellEditable(i, "chss_tare_wgt")    = true;
				sheetObj.CellEditable(i, "chss_rgst_ste_cd") = true;
				sheetObj.CellEditable(i, "chss_rgst_yr")     = true;
				sheetObj.CellEditable(i, "chss_rgst_prd_cd") = true;
		
				sheetObj.CellEditable(i, "chss_rgst_lic_no") = true;
				sheetObj.CellEditable(i, "chss_veh_id_no")   = true;
				sheetObj.CellEditable(i, "chss_tit_no")      = true;
				sheetObj.CellEditable(i, "chss_als_no")      = true;
				sheetObj.CellEditable(i, "n2nd_chss_als_no") = true;
			}
			chungpa 20100409 disable */
			formObj.eq_no_tmp.value = "";
			
		}
		break;

	case IBSAVE: // 저장(체크박스에 선택된 행만 SAVE 로직을 태움.)

		/* chungpa 20100409 disable
		with(sheetObjects[0]) {
		    // 체크된 행번 가져오기, 결과:"3|4|5"
		    var chkRows = FindCheckedRow("del_chk")
		    
		    // alert("chkRows : " + chkRows);
		    // 전체 행만큼 루프를 돌면서 체크된 행번 목록에 i가 없을 경우 i값의 RowStatus를 비운다.
		    for (i=1; i<LastRow+1; i++) {
		        if (chkRows.indexOf(i) < 0) {
		            RowStatus(i) = "";
		        }
		    }
		}
		chungpa 20100409 disable */
	
		if(validateForm(sheetObj,formObj,sAction)){ //chungpa 20090720 Row Add 후 Chassis No를 입력하지 않았는데 체크하고 Save 를 누르면 실행됨.
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);				
			formObj.f_cmd.value = MULTI;
			if(sheetObj.DoSave("EES_CGM_1006GS.do", FormQueryString(formObj)))
 			{
 				ComShowCodeMessage("CGM00003");
 			}else
 			{
 				
 			}
 			
			ComOpenWait(false);	
		}
		break;

	case SEARCH08:
		//그리드내  다중콤보
		formObj.f_cmd.value = SEARCH08;
		var xml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
 	  	var cols = ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
 	  	sheetObj.InitDataCombo(0, "chss_rgst_ste_cd", " |" + cols[1], " |" + cols[0], "", "", 0);
 	  	
 	  	break;

	case IBLOADEXCEL:		// EXCEL UPLOAD
		
		if(sheetObj.rowcount >= 1)
		{
			sheetObj.RemoveAll();
		}
		sheetObj.LoadExcel(); 
		break;

	case IBDOWNEXCEL:     	// EXCEL DOWNLOAD
		sheetObj.SpeedDown2Excel(-1,false,true,"","",false,false,"",true,"");
    	break;		

	case IBRESET:
		var idx = 0
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");

		
		//그리드내  다중콤보
		if ( arrXml[idx] == null ) {return;}
 	  	var cols = ComCgmXml2ComboString(arrXml[idx], "code1", "code1|desc1", "\t");
 	  	sheetObj.InitDataCombo(0, "chss_rgst_ste_cd", " |" + cols[1], " |" + cols[0], "", "", 0);
 	  	idx++; 
 	  	
		break;    	
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	  with(formObj){
	  		 switch(sAction) {
	  		 	case IBSEARCH: // chungpa 20100210 Expire Year add
	  		 		if(chss_rgst_exp_dt.value != '' && chss_rgst_exp_dt.value.length != 4)
	  		 		{
	  		 			ComShowCodeMessage('CGM10044','Expire Year')
	  		 			chss_rgst_exp_dt.focus();
	  		 			return false;
	  		 		}
	  		 		break;
	  		 	case IBSAVE: //chungpa 20090720 Row Add 후 Chassis No를 입력하지 않았는데 체크하고 Save 를 누르면 실행됨.
	  		 		
	  		 		// 체크박스가 선택된 행만을 대상으로 SAVE 로직을 태운다. chungpa
	  				var chkRows = sheetObj.FindCheckedRow("del_chk");
	  				var arrChkRows = chkRows.split("|");
	  				
	  				// 체크된 행만큼 루프를 돌면서 chss_pool_cdw 가  선택되지 않은 항목이 있으면 CGM10009 메시지 띄운다.
	  				var cellText;
	  				for(k=0; k < arrChkRows.length-1; k++){
	  					cellText = sheetObj.CellValue(arrChkRows[k], "eq_no");
	  					if(cellText == ""){
	  						ComShowCodeMessage("CGM10009", " Chassis No.");
	  						return false;
	  					}
	  				}
	  				if(arrChkRows.length-1 <= 0)
	  				{
	  					ComShowCodeMessage("CGM10009", " Chassis No.");
	  					return false;
	  				}	  		 		
	       			break;
	  		 }      
	  	 }
	return true;
}


/**
 * 기본 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	var sheetObject  = sheetObjects[0];

	//IBMultiCombo 초기화
	formObj.reset();
}

/** 
* 달력 팝업
*/
function sheet1_OnPopupClick(sheetObj, row, col){
	switch (sheetObj.ColSaveName(col)) {
       	case "mft_dt" :
		    if (sheetObj.ColSaveName(col) != "mft_dt") return;//chss_rgst_exp_dt
		    var cal = new ComCalendarGrid("myCal");
		    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		    break;

       	case "chss_rgst_exp_dt" :
		    if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt") return;
		    var cal = new ComCalendarGrid("myCal");
		    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		    break;
	}
}


/**
 * sheet 삭제 
 * @param sheetObj
 * @return
 */
function sheet_delete(sheetObj)
{
	  for(i=sheetObj.rowCount; i>0; i--){
		if(sheetObj.CellValue(i, "ibflag") != ""   &&  sheetObj.CellValue(i, "del_chk")=="1") {
			sheetObj.RowDelete(i, false);
		}
	 }
}


/**
 * 1. Xml 데이타를 해당행에 컬럼별로 나눠서 넣어줌.
 * 2. Expiry Date Code 변경시 날짜 선택 여부 Enable Disable
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var prefix   = "";
	var chk      = true;
	// Expiry 코드값 P/F에 따라  Date Cell Enable, Disable
	with (sheetObj) {
		var colName = ColSaveName(Col);
		switch (colName) {
		case "chss_rgst_prd_cd":
			
			/* chungpa 20100409 disable
			if (CellValue(Row, "chss_rgst_prd_cd") == "F") {
				CellEditable(Row, "chss_rgst_exp_dt") = true;
			} else {
				// 셀 값을 삭제하고 읽기 속성을 부여한다.
				CellValue2(Row, "chss_rgst_exp_dt") = "";
				CellEditable(Row, "chss_rgst_exp_dt") = false;
			}
			*/
			
			if (CellValue(Row, "chss_rgst_prd_cd") == "F") {
			} else {
				// 셀 값을 삭제하고 읽기 속성을 부여한다.
				CellValue2(Row, "chss_rgst_exp_dt") = "";
			}
			break;
		case "chss_rgst_exp_dt":
			if (CellValue(Row, "chss_rgst_exp_dt") != "")
			{
				CellValue2(Row, "chss_rgst_prd_cd") = "F";
			}else
			{
				CellValue2(Row, "chss_rgst_prd_cd") = "P";
			}
			break;
		case "chss_als_no":
		case "n2nd_chss_als_no":
			// Alias No 중복 체크(조회된 데이타에 한해서 중복체크)
	 		var CellValue = sheetObj.cellValue(Row, Col);
	 		var Col1 = sheetObj.cellValue(Row, "chss_als_no");
	 		var Col2 = sheetObj.cellValue(Row, "n2nd_chss_als_no");
	 		
	 		var tmpCnt = 0;
	 		var preI   = 0;
	 		var preJ   = 0;
	 		var rowcnt = sheetObj.rowCount;
	 		
	 		// chungpa 20100408 performance start
	 		var DUP = false;
	 		var check1 = sheetObj.FindText("chss_als_no", Value);
	 		var check2 = sheetObj.FindText("n2nd_chss_als_no", Value);
	 		if(Col == 14) //"chss_als_no"
	 		{
	 			if(check2==-1 && check1 == Row)
	 			{
 					if(sheetObj.FindText("chss_als_no", Value, Row+1) == -1) // 자신이후의 열도 체크해본다
 					{
 						//Unique
 					}else
 					{
 						DUP = true;
 					}
	 			}else
	 			{
	 				DUP = true;
	 			}
	 		}else if(Col == 15) //"n2nd_chss_als_no"
	 		{
	 			if(check1==-1 && check2 == Row)
	 			{
 					if(sheetObj.FindText("n2nd_chss_als_no", Value, Row+1) == -1) // 자신이후의 열도 체크해본다
 					{
 						//Unique
 					}else
 					{
 						DUP = true;
 					}
	 			}else
	 			{
	 				DUP = true;
	 			}
	 		}
	 		if(DUP == true)
	 		{
				ComShowCodeMessage("CGM10031",Value);
				// 해당 Cell 값을 Null로 설정
	 			sheetObj.cellValue2(Row, Col) = "";
	 			// 그리드에 포커스 이동
	 			sheetObj.SelectCell(Row, Col, true);
	 		}
	 		// chungpa 20100408 performance end

	 		
	 		var chssAlsNo;
	 		// Alias No 중복 체크(DB에 저장되어 있는 데이타에 한해서 중복체크)
	 		if (colName == "chss_als_no") {
		 		chssAlsNo = CellValue(Row, "chss_als_no");
	 		} else {
		 		chssAlsNo = CellValue(Row, "n2nd_chss_als_no");
	 		}
			if(chssAlsNo.length > 0) {
				formObj.f_cmd.value = SEARCH01;
				document.form.chss_als_no.value = chssAlsNo;
				
				// sheetObj - eq_no 값을 뽑아와서 넘겨주어야 함
				document.form.eq_no_tmp.value = CellValue(Row, "eq_no")
				var sXml = sheetObj.GetSearchXml("EES_CGM_1006GS.do", FormQueryString(formObj));

				if (DomXml2String(sXml, "eq_no")) {
					if (DomXml2String(sXml, "eq_no").length > 0) {

						// 데이타 있을 경우 메세지
						alert("CGM10031\n\n" + DomXml2String(sXml, "eq_no"));
						sheetObj.cellValue2(Row, Col) = "";
						SelectCell(Row, colName, true);
						return;
					}
				}
			}
			break;

		case "eq_no":
//			/* 기존 chungpa 20091022 delete
//			formObj.eq_no_tmp.value = sheetObj.cellValue(Row, "eq_no");
//
//	 		var CellValue = sheetObj.cellValue(Row, Col);
//	 		var Row2 = sheetObj.FindText(Col, CellValue, -1);
//		
//	 		if(Row2 > 0){
//	 			Row2 = sheetObj.FindText(Col, CellValue, Row2+1);
//	       
//	 			if (Row2 > 0) {
//	 				ComShowCodeMessage("CGM10017", "Chassis No");
//					// 해당 Cell 값을 Null로 설정
//					sheetObj.cellValue2(Row, Col) = '';
//					// 그리드에 포커스 이동
//					sheetObj.SelectCell(Row, Col, true);
//	 			}
//			}
//	 		*/
		 	//서버 중복 체크
		 	var eqNoTmp = Value;
			if(Row >1){
				// chassis no 체크
				for(i=1; i<sheetObj.rowCount; i++){
					if(sheetObj.CellValue(i, "eq_no")== Value && Row != i  && sheetObj.CellValue(i, "eq_no")!='')
 					{
						// 체크 메시지 출력
			        	// ComShowMessage('CGM20007');

						//ComShowMessage("Chassis No :" +sheetObj.CellValue(i, "eq_no") +" is duplicated.");
						
			        	ComShowCodeMessage("CGM10017", "Chassis No");
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue(Row, "eq_no") = "";
			        	return false;
 					}
				}
			} 
			
			// XML에 담긴 값을 해당컬럼에 값을 넣어줌
			if(eqNoTmp.length > 0) {
				formObj.f_cmd.value = SEARCH;
				document.form.eq_no_tmp.value = eqNoTmp;

				var sXml = GetSearchXml("EES_CGM_1006GS.do", FormQueryString(formObj));

				if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
					// 데이타가 없으므로 해당셀을 지워주고 포커스 이동 한다

					//alert("CGM10031");
					// 서버에 메세지 등록되면 교체해 준다
					ComShowCodeMessage("CGM10012");
					
					// 해당 Cell 값을 Null로 설정
					sheetObj.cellValue2(Row, Col) = "";
					// 그리드에 포커스 이동
					sheetObj.SelectCell(Row, Col, true);
					
					
					//해당row 초기화
					sheetObj.CellValue2(Row, "eq_no")                = "";
					sheetObj.CellValue2(Row, "eq_tpsz_cd")           = "";
					sheetObj.CellValue2(Row, "mft_dt")               = "";
					sheetObj.CellValue2(Row, "chss_tare_wgt")        = "";
					sheetObj.CellValue2(Row, "chss_rgst_ste_cd")     = "";
	
					sheetObj.CellValue2(Row, "chss_rgst_yr")         = "";
					sheetObj.CellValue2(Row, "chss_rgst_exp_dt")     = "";
					sheetObj.CellValue2(Row, "chss_rgst_lic_no")     = "";
					sheetObj.CellValue2(Row, "chss_veh_id_no")       = "";
					sheetObj.CellValue2(Row, "chss_tit_no")          = "";
	
					sheetObj.CellValue2(Row, "chss_als_no")          = "";
					sheetObj.CellValue2(Row, "n2nd_chss_als_no")     = "";
					sheetObj.CellValue2(Row, "onh_yd_cd")            = "";
					sheetObj.CellValue2(Row, "onh_ofc_cd")           = "";
					sheetObj.CellValue2(Row, "cre_dt")               = "";
	
					sheetObj.CellValue2(Row, "cre_usr_id")           = "";
					sheetObj.CellValue2(Row, "chss_rgst_upd_dt")     = "";
					sheetObj.CellValue2(Row, "chss_rgst_upd_id")     = "";
	
					sheetObj.CellValue2(Row, "eq_knd_cd")            = "";
					cellDisable(sheetObj, Row);
					
					return;
				} else {
					// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
					CellValue2(Row, "eq_no")                = DomXml2String(sXml, "eq_no");
					CellValue2(Row, "eq_tpsz_cd")           = DomXml2String(sXml, "eq_tpsz_cd");
					CellValue2(Row, "mft_dt")               = DomXml2String(sXml, "mft_dt");
					CellValue2(Row, "chss_tare_wgt")        = DomXml2String(sXml, "chss_tare_wgt");
					CellValue2(Row, "chss_rgst_ste_cd")     = DomXml2String(sXml, "chss_rgst_ste_cd");
	
					CellValue2(Row, "chss_rgst_yr")         = DomXml2String(sXml, "chss_rgst_yr");
					CellValue2(Row, "chss_rgst_exp_dt")     = DomXml2String(sXml, "chss_rgst_exp_dt");
					CellValue2(Row, "chss_rgst_lic_no")     = DomXml2String(sXml, "chss_rgst_lic_no");
					CellValue2(Row, "chss_veh_id_no")       = DomXml2String(sXml, "chss_veh_id_no");
					CellValue2(Row, "chss_tit_no")          = DomXml2String(sXml, "chss_tit_no");
	
					CellValue2(Row, "chss_als_no")          = DomXml2String(sXml, "chss_als_no");
					CellValue2(Row, "n2nd_chss_als_no")     = DomXml2String(sXml, "n2nd_chss_als_no");
					CellValue2(Row, "onh_yd_cd")            = DomXml2String(sXml, "onh_yd_cd");
					
					//chungpa 20090826 On_Hire_xxxx START
					CellValue2(Row, "onh_ofc_cd")           = DomXml2String(sXml, "onh_ofc_cd");
					CellValue2(Row, "cre_dt")               = DomXml2String(sXml, "cre_dt");
					CellValue2(Row, "cre_usr_id")           = DomXml2String(sXml, "cre_usr_id");
				
					CellValue2(Row, "chss_rgst_upd_dt")     = DomXml2String(sXml, "chss_rgst_upd_dt");
					CellValue2(Row, "chss_rgst_upd_id")     = DomXml2String(sXml, "chss_rgst_upd_id");
					//chungpa 20090826 On_Hire_xxxx END						
					
					// Hidden
					CellValue2(Row, "eq_knd_cd")            = DomXml2String(sXml, "eq_knd_cd");
					
					// 해당 컬럼 Enable 함수 호출한다 //sheetObj, Row, Col
					var tmpRow = Row;
					cellEnable(sheetObj, Row);

				}
			}
			break;
		}
	}
}

 /**
  * 엑셀 업로드시 체크
  * @param sheetObj
  * @author Chae-Shung Cho
  * @version 2009.10.22
  */
function sheet1_OnLoadExcel(sheetObj){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var prefix   = "";
	var chk      = true;
	
	// chassis no 체크
	for(iChk=1; iChk<sheetObj.rowCount+1; iChk++){
		
		var cellValue = sheetObj.cellValue(iChk, "eq_no"); 
			//alert(cellValue);
			if (cellValue != ''){

				formObj.f_cmd.value = SEARCH;
				document.form.eq_no_tmp.value = cellValue;
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_1006GS.do", FormQueryString(formObj));

				if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {

					//해당row 초기화
					sheetObj.CellValue2(iChk, "eq_no")                = "";
					sheetObj.CellValue2(iChk, "eq_tpsz_cd")           = "";
					sheetObj.CellValue2(iChk, "mft_dt")               = "";
					sheetObj.CellValue2(iChk, "chss_tare_wgt")        = "";
					sheetObj.CellValue2(iChk, "chss_rgst_ste_cd")     = "";
	
					sheetObj.CellValue2(iChk, "chss_rgst_yr")         = "";
					sheetObj.CellValue2(iChk, "chss_rgst_exp_dt")     = "";
					sheetObj.CellValue2(iChk, "chss_rgst_lic_no")     = "";
					sheetObj.CellValue2(iChk, "chss_veh_id_no")       = "";
					sheetObj.CellValue2(iChk, "chss_tit_no")          = "";
	
					sheetObj.CellValue2(iChk, "chss_als_no")          = "";
					sheetObj.CellValue2(iChk, "n2nd_chss_als_no")     = "";
					sheetObj.CellValue2(iChk, "onh_yd_cd")            = "";
					sheetObj.CellValue2(iChk, "onh_ofc_cd")           = "";
					sheetObj.CellValue2(iChk, "cre_dt")               = "";
	
					sheetObj.CellValue2(iChk, "cre_usr_id")           = "";
					sheetObj.CellValue2(iChk, "chss_rgst_upd_dt")     = "";
					sheetObj.CellValue2(iChk, "chss_rgst_upd_id")     = "";
	
					sheetObj.CellValue2(iChk, "eq_knd_cd")            = "";
					cellDisable(sheetObj, iChk);
				} else {
					// 데이타가 있으므로 해당 셀에 값을 세팅해 준다
					sheetObj.CellValue2(iChk, "eq_no")                = DomXml2String(sXml, "eq_no");
					sheetObj.CellValue2(iChk, "eq_tpsz_cd")           = DomXml2String(sXml, "eq_tpsz_cd");
					sheetObj.CellValue2(iChk, "mft_dt")               = DomXml2String(sXml, "mft_dt");
					sheetObj.CellValue2(iChk, "chss_tare_wgt")        = DomXml2String(sXml, "chss_tare_wgt");
					sheetObj.CellValue2(iChk, "chss_rgst_ste_cd")     = DomXml2String(sXml, "chss_rgst_ste_cd");
	
					sheetObj.CellValue2(iChk, "chss_rgst_yr")         = DomXml2String(sXml, "chss_rgst_yr");
					sheetObj.CellValue2(iChk, "chss_rgst_exp_dt")     = DomXml2String(sXml, "chss_rgst_exp_dt");
					sheetObj.CellValue2(iChk, "chss_rgst_lic_no")     = DomXml2String(sXml, "chss_rgst_lic_no");
					sheetObj.CellValue2(iChk, "chss_veh_id_no")       = DomXml2String(sXml, "chss_veh_id_no");
					sheetObj.CellValue2(iChk, "chss_tit_no")          = DomXml2String(sXml, "chss_tit_no");
	
					sheetObj.CellValue2(iChk, "chss_als_no")          = DomXml2String(sXml, "chss_als_no");
					sheetObj.CellValue2(iChk, "n2nd_chss_als_no")     = DomXml2String(sXml, "n2nd_chss_als_no");
					sheetObj.CellValue2(iChk, "onh_yd_cd")            = DomXml2String(sXml, "onh_yd_cd");
					
					//chungpa 20090826 On_Hire_xxxx START
					sheetObj.CellValue2(iChk, "onh_ofc_cd")           = DomXml2String(sXml, "onh_ofc_cd");
					sheetObj.CellValue2(iChk, "cre_dt")               = DomXml2String(sXml, "cre_dt");
					sheetObj.CellValue2(iChk, "cre_usr_id")           = DomXml2String(sXml, "cre_usr_id");
				
					sheetObj.CellValue2(iChk, "chss_rgst_upd_dt")     = DomXml2String(sXml, "chss_rgst_upd_dt");
					sheetObj.CellValue2(iChk, "chss_rgst_upd_id")     = DomXml2String(sXml, "chss_rgst_upd_id");
					//chungpa 20090826 On_Hire_xxxx END						
					
					// Hidden
					sheetObj.CellValue2(iChk, "eq_knd_cd")            = DomXml2String(sXml, "eq_knd_cd");
					
					// 해당 컬럼 Enable 함수 호출한다 //sheetObj, iChk, Col
					var tmpiChk = iChk;
					cellEnable(sheetObj, iChk);
				}	 		
	 		
		}
	}
}

/**
 * 해당 컬럼을 Enable 시켜준다.
 */
function cellEnable(sheetObj, Row){

	/* chungpa 20100409 disable cellEnable start
	 * 
	// 데이타가 존재하므로 활성화시켜준다
	sheetObj.CellEditable(Row, "mft_dt")           = true;
	sheetObj.CellEditable(Row, "chss_tare_wgt")    = true;
	sheetObj.CellEditable(Row, "chss_rgst_ste_cd") = true;
	sheetObj.CellEditable(Row, "chss_rgst_yr")     = true;
	sheetObj.CellEditable(Row, "chss_rgst_prd_cd") = true;

	if( sheetObj.Cellvalue(Row,"chss_rgst_prd_cd") == "P" ){
		sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = false;
	} else {
		sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = true;
	}
	
	sheetObj.CellEditable(Row, "chss_rgst_lic_no") = true;
	sheetObj.CellEditable(Row, "chss_veh_id_no")   = true;
	sheetObj.CellEditable(Row, "chss_tit_no")      = true;
	sheetObj.CellEditable(Row, "chss_als_no")      = true;
	sheetObj.CellEditable(Row, "n2nd_chss_als_no") = true;
	
	chungpa 20100409 disable cellEnable start */
}

/**
 * 해당 컬럼을 Enable 시켜준다.
 */
function cellDisable(sheetObj, Row, sXml){
	
	/* chungpa 20100409 disable cellDisable start
	 * 

	// 데이타가 존재하므로 활성화시켜준다
	sheetObj.CellEditable(Row, "mft_dt")           = false;
	sheetObj.CellEditable(Row, "chss_tare_wgt")    = false;
	sheetObj.CellEditable(Row, "chss_rgst_ste_cd") = false;
	sheetObj.CellEditable(Row, "chss_rgst_yr")     = false;
	sheetObj.CellEditable(Row, "chss_rgst_prd_cd") = false;

	if( sheetObj.Cellvalue(Row,"chss_rgst_prd_cd") == "P" ){
		sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = false;
	} else {
		sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = true;
	}
	
	sheetObj.CellEditable(Row, "chss_rgst_lic_no") = false;
	sheetObj.CellEditable(Row, "chss_veh_id_no")   = false;
	sheetObj.CellEditable(Row, "chss_tit_no")      = false;
	sheetObj.CellEditable(Row, "chss_als_no")      = false;
	sheetObj.CellEditable(Row, "n2nd_chss_als_no") = false;
	
	chungpa 20100409 disable cellDisable end	 */
}


/**
 * 키 입력 제한
 * (JSP 파일  해당 텍스트 필드에 dataformat에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;
	 
	 switch(obj.dataformat) {
  	    case "engup":
	        if(obj.name == "eq_no_fm"){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
   	 	case "int":
   	 		ComKeyOnlyNumber(obj);
   	        break;	    	
	 }
 }
 
// 아래 공통에서 퍼온 소스이므로 그대로 사용(수정할 사항 없슴)//////////////////////////////////

/** 
 * 기본조건 입력 후 ENTER키 적용 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.26
 */ 
 function search_keyup() {
	   var formObj = document.form;
	   if(formObj.eq_no_fm.value != '')
	   {
		   if(event.keyCode == 13) {
			   ComKeyEnter('search');
			   return;
		   }
	   }
        
	    var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		//var formObj  = document.form;

		switch (obj.name) {
			case "eq_no_fm": 
				ComKeyEnter('LengthNextFocus');
		  		break;

			case "eq_no_to": 
				ComKeyEnter('LengthNextFocus');
		  		break;

			case "chss_rgst_lic_no": 
				ComKeyEnter('LengthNextFocus');
		  		break;

			case "chss_veh_id_no": 
				ComKeyEnter('LengthNextFocus');
		  		break;

			case "chss_rgst_exp_dt": 
		  		if (formObj.chss_rgst_exp_dt.value.length == 4) {
	                if (!((vKeyCode>=8   && vKeyCode<=40)  ||  //BackSpace~아래방향키키
		                      (vKeyCode>=45  && vKeyCode<=46)  ||  //Insert,Delete키
		                      (vKeyCode>=91  && vKeyCode<=93)  ||  //기능키
		                      (vKeyCode>=112 && vKeyCode<=123) ||  //F1~F12키
		                      (vKeyCode>=144 && vKeyCode<=145) )) {//NumLock,ScrollLock
	            		var obj = document.getElementById("btn_Retrieve");
	            		if (obj==null) obj = document.getElementById("btn_retrieve");
	            		if (obj) obj.fireEvent("onclick");
		  			}
		  		}
		  		break;
		}
 }  

 /**
 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2010.03.05
 */     
 function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_add");
		  ComBtnDisable("btn_del");
		  ComBtnDisable("btn_save");
	  }
 } 
/* 개발자 작업 끝 */
