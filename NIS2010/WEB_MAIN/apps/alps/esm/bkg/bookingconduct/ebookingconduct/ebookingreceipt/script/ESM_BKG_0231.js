/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0231.js
 *@FileTitle : e-Booking & SI Process - Copy Option
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.03
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.07.03 전용진
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
 * @author SM LINE
 */

/**
 * @extends 
 * @class esm_bkg_0231 : esm_bkg_0231 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0231() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var tabNameAll = "Customer|Container|M&D|C/M|TRO/O|Reefer|Danger|Awkward|Break Bulk|House B/L 1|House B/L 2";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_ok":
			if(!validateForm(sheetObject,formObject,"btn_ok")) {
				return false;
			}
			doActionIBSheet(sheetObject,formObject,"btn_ok");
			break;
		case "btn_uncheckall":
			document.all.chk.style.display="";
			document.all.unchk.style.display="none";
			sheetObjects[0].CheckAll("checkbox") = 0;
			break;
		case "btn_checkall":
			document.all.chk.style.display="none";
			document.all.unchk.style.display="";
			sheetObjects[0].CheckAll("checkbox") = 1;
			break;
		case "btn_close":
			window.close();
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch(sheetId) {

	case "sheet1":
		//with (sheetObj) {

			// 높이 설정
		sheetObj.style.height = 270;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "|Tab|Data|Data|Copy Select";
			var HeadTitle2 = "|Tab|ALPS|e-Service|Copy Select";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
			sheetObj.InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,		"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	true,		"tab_nm",		false,		"",		dfNone,			0,		true,		true, 0, 0, false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,		"nis_sel",		false,		"",		dfNone,			0,		true,		true, 0, 0, false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,		"esvc_sel",		false,		"",		dfNone,			0,		true,		true, 0, 0, false);
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter,	true,		"checkbox",		false,		"",		dfNone,			0,		true,		true, 0, 0, false);
			sheetObj.CountPosition = 0;
		//}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	if(!opener) opener = window.dialogArguments;

	switch(sAction) {

	case IBCLEAR:      //초기화
		if(!validateForm(sheetObj,formObj,sAction)) return;
		var t1=opener.document.frames("t1frame").form;

		//doc type이 'S'이면 기본 check에서 제거
		var includeTroRfDgAk = true;
		if (t1.doc_tp_cd.value == "S" &&
				(t1.save_tro_flag.value == "Y" ||
				 t1.save_rf_flag.value  == "Y" ||
				 t1.save_dg_flag.value  == "Y"||
				 t1.save_ak_flag.value  == "Y")) {
			includeTroRfDgAk = false;
		}
	
		var nisDataAll = t1.alps_data_yn_flag.value;
		var esvcDataAll = t1.xter_data_yn_flag.value;
	
		var tabName  = tabNameAll.split("|");
		var nisData  = nisDataAll.split("|");
		var esvcData = esvcDataAll.split("|");
	
		var insertXml =  "<?xml version='1.0'  ?>\n";
		insertXml += "<SHEET>\n";
		insertXml += "  <DATA TOTAL='"+tabName.length+"'>\n";
	
		for (var i=0;i<tabName.length;i++) {
			insertXml += " <TR>\n";
			insertXml += "   <TD>R</TD>\n";
			insertXml += "   <TD><![CDATA[" + tabName[i] + "]]></TD>\n";	

			if(includeTroRfDgAk == false){
				if(tabName[i]=="TRO/O"||tabName[i]=="Reefer"||tabName[i]=="Danger"||tabName[i]=="Awkward"){
					if ( nisData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
					if ( esvcData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
					if ( esvcData[i] == "Y" ) insertXml += "   <TD>0</TD>\n";
					insertXml += " </TR>\n";
					continue;
				}
			}
			if ( nisData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
			if ( esvcData[i] == "Y" ) insertXml += "   <TD>Yes</TD>\n"; else insertXml += "   <TD>No</TD>\n";
			if ( esvcData[i] == "Y" ) insertXml += "   <TD>1</TD>\n"; else insertXml += "   <TD>0</TD>\n";
			insertXml += " </TR>\n";
		}
	
		insertXml += "  </DATA>\n";
		insertXml += "</SHEET>";
		sheetObjects[0].LoadSearchXml(insertXml);
		sheetObjects[0].Redraw = true;
		break;

	case "btn_ok":      // OK
		var callFunc = formObj.callFunc.value;

		var t2=opener.document.frames("t2frame");
		var t3=opener.document.frames("t3frame");
		var t4=opener.document.frames("t4frame");
		var t5=opener.document.frames("t5frame");
		var t6=opener.document.frames("t6frame");
		var t7=opener.document.frames("t7frame");
		var t8=opener.document.frames("t8frame");
		var t9=opener.document.frames("t9frame");
		var t10=opener.document.frames("t10frame");
		var t11=opener.document.frames("t11frame");
		var t12=opener.document.frames("t12frame");
		
		var t1frame_form = opener.document.frames("t1frame").form;

		var copyTabStr = new Array();
		if ( sheetObjects[0].CellValue(2, "checkbox") == 1 
				&& t1frame_form.save_cust_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(1)="#fff270";
			copyTabStr[0] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(1)="#96c792";	
			copyTabStr[0] = "N/A";		
		}

		if ( sheetObjects[0].CellValue(3, "checkbox") == 1 
				&& t1frame_form.save_cntr_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(2)="#fff270";
			copyTabStr[1] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(2)="#96c792";
			copyTabStr[1] = "N/A";
		}				

		if ( sheetObjects[0].CellValue(4, "checkbox") == 1  
				&&  t1frame_form.save_mnd_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(3)="#fff270";
			copyTabStr[2] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(3)="#96c792";
			copyTabStr[2] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(5, "checkbox") == 1  
				&&  t1frame_form.save_cm_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(4)="#fff270";
			copyTabStr[3] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(4)="#96c792";
			copyTabStr[3] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(6, "checkbox") == 1  
				&&  t1frame_form.save_tro_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(5)="#fff270";
			copyTabStr[4] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(5)="#96c792";
			copyTabStr[4] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(7, "checkbox") == 1  
				&&  t1frame_form.save_rf_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(6)="#fff270";
			copyTabStr[5] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(6)="#96c792";
			copyTabStr[5] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(8, "checkbox") == 1  
				&&  t1frame_form.save_dg_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(7)="#fff270";
			copyTabStr[6] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(7)="#96c792";
			copyTabStr[6] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(9, "checkbox") == 1  
				&&  t1frame_form.save_ak_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(8)="#fff270";
			copyTabStr[7] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(8)="#96c792";
			copyTabStr[7] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(10, "checkbox") == 1  
				&&  t1frame_form.save_bb_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(9)="#fff270";
			copyTabStr[10] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(9)="#96c792";
			copyTabStr[10] = "N/A";
		}		
		
		if ( sheetObjects[0].CellValue(11, "checkbox") == 1  
				&&  t1frame_form.save_hbl_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(10)="#fff270";
			copyTabStr[8] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(10)="#96c792";
			copyTabStr[8] = "N/A";
		}		

		if ( sheetObjects[0].CellValue(12, "checkbox") == 1 
				&& t1frame_form.save_hbl2_flag.value == "Y" ) {
			opener.parent.tabObjects[0].TabBackColor(11)="#fff270";
			copyTabStr[9] = "COPY"; 
		} else {
			opener.parent.tabObjects[0].TabBackColor(11)="#96c792";
			copyTabStr[9] = "N/A";
		}
			
		eval('window.dialogArguments.'+callFunc)(copyTabStr);
		window.close();
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {

//		case "btn_Delete":
//			if (sheetObj.CheckedRows("checkbox") == 0) {
//				ComShowMessage(msgs['COM12189']);
//				return false;
//			} else if (sheetObj.CheckedRows("checkbox") > 0) {
//				ComShowMessage(msgs['COM12188']);
//				return true;
//			}
//			break;
		}
	}

	return true;
}