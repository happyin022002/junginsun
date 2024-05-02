/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0928.js
*@FileTitle : IRG Adjust Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends Bkg
 * @class ESD_TRS_0928 : IRG Adjust
 */
function ESD_TRS_0928() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var sheetObjects = new Array();
var sheetCnt = 0;
var initFlag=1;
var opener_obj = window.dialogArguments;
var docObjcheck = opener_obj.docObjsep;  // OPEN 한 소스 화면
var opensheetObject = opener_obj.openObjSheet(); //PARENT GRID

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}
	
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	IBS_Sheet2SheetStatus2(opensheetObject, "chk1");
}

/** 
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				style.height = 350; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(40, 7, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

//				var HeadTitle = "R/D Term|From Node|From Node|To Node|To Node|IRG|Route Plan|Reference No|Remark|Altematives";
				var HeadTitle  = "Seq|R/D Term|POL/POD|From Node|From Node|To Node|To Node|IRG|Route Plan|Reference No|Remark|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives";
				var HeadTitle1 = "Seq|R/D Term|POL/POD|Loc|Node|Loc|Node|IRG|Route Plan|Reference No|Remark|Alt|rout_org|rout_dest|rout_seq|Prio|IRG|From Node|From Node|To Node|To Node|Plan|Ref No|Remark|NEW_RAIL_CMB_THRU_TP";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++,	dtSeq,   28, daCenter, true, "seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  57, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  60, daCenter, true, "polpod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  50, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,	 35, daCenter, true, "fm_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  50, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  35, daCenter, true, "to_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData, 350, daLeft,   true, "irg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData,  65, daCenter, true, "rout_pln_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData, 100, daCenter, true, "ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++,	dtData, 130, daLeft,   true, "inlnd_rout_rmk", false, "", dfNone, 0, false, false);

//				InitDataProperty(0, cnt++, dtPopup, 50, daCenter, true, "altematives", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtComboEdit, 30, daCenter, true, "irg_dropdownlist", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "new_rout_org",  false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "new_rout_dest", false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "new_rout_seq",  false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,   30, daCenter, true, "new_prio_seq",  false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,  280, daLeft,   true, "new_irg",       false, "", dfNone, 0, false, false);    // 변경될 IRG 값

				InitDataProperty(0, cnt++, dtData,   45, daCenter, true, "new_fm_nod_cd", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,   25, daCenter, true, "new_fm_nod_yard", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,   45, daCenter, true, "new_to_nod_cd", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,   25, daCenter, true, "new_to_nod_yard", false, "", dfNone, 0, false, false);		// 변경될 IRG 값

				InitDataProperty(0, cnt++, dtData,  40, daCenter, true, "new_rout_pln_cd", false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,  80, daLeft,   true, "new_ref_no", false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				InitDataProperty(0, cnt++, dtData,  30, daLeft,   true, "new_inlnd_rout_rmk", false, "", dfNone, 0, false, false);    // 변경될 IRG 값
				
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "new_rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);
				


				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "from_node", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "to_node", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rout_org_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rout_dest_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rout_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "prio_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "key_org", false, "", dfNone, 0, false, false);      //  OB: POR,  IB: POD 
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "key_dest", false, "", dfNone, 0, false, false);     //  OB: POL,  IB: DEL 


				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "interchange1_loc", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtHidden,  20, daCenter, true, "interchange1_nod", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "interchange2_loc", false, "", dfNone, 0, false, false);		// 변경될 IRG 값
				InitDataProperty(0, cnt++, dtHidden,  20, daCenter, true, "interchange2_nod", false, "", dfNone, 0, false, false);		// 변경될 IRG 값



//				InitDataCombo(0, "altddl", "!USSEAR1-(BURL20)-USCHIY1-(NORF01)-USCVGR3|A|B", "1|2|3");


//				InitDataCombo(0, "irg_dropdownlist", "1촌|2촌|3촌","01|02|03")


			}
		break;

	
		case 2:      //sheet1 init
			with (sheetObj) {
				style.height = 320; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(16, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "seq|s_SEQ|Priority|IRG|Route Plan|Reference No|Remark|ROUT_ORG_NOD|ROUT_DEST_NOD|ROUT_SEQ|RAIL_CMB_THRU_TP|RTR";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "key_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "alt_sub_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "prio_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rout_pln_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daLeft,   true, "inlnd_rout_rmk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rout_org_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rout_dest_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rout_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rtr", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData,320, daLeft,   true, "irg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "fm_nod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "to_nod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ic_1", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ic_2", false, "", dfNone, 0, false, false);
				
			}
		break;

	

	
	
	
	
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_ok":
				IBS_Sheet3SheetStatus2(sheetObject, opensheetObject, formObject, "chk1");
			break;

			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, chk) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회

		if (chk =='M')
		{
			formObj.f_cmd.value = SEARCH04;
			sheetObj.DoSearch4Post("ESD_TRS_0928GS.do", TrsFrmQryString(formObj));
		} else if ( chk =='D')	{
			formObj.f_cmd.value = SEARCH15;
			sheetObj.DoSearch4Post("ESD_TRS_0928GS_1.do", TrsFrmQryString(formObj) + "&"+ sheetObjects[0].GetSaveString(true)    );
		}

		break;

	}
}

//부모에 있는 쉬트의 From Node와 To Node를 가지고 오기 위하여 사용함.opensheetObject, "chk1"
function IBS_Sheet2SheetStatus2(fromSheet, sStatus) {

	objInit();
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;

	var docSeperate = "";
	var docParameter = "";

	var key_org = "";
	var key_dest = "";
	var doc_cgo_tp_cd = "";
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	var trsp_bnd_cd = "";
	var bkg_rcvde_term_cd = "";

	var i=0,j=0;	
	
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
		if( docObjcheck == "I" ) {
			key_org  = fromSheet.CellValue(arrRow[ir], "pod_cd")+fromSheet.CellValue(arrRow[ir], "pod_cd_yard");
			key_dest = fromSheet.CellValue(arrRow[ir], "del_nod_cd")+fromSheet.CellValue(arrRow[ir], "del_nod_cd_yard");
			if( key_org == "" ) key_org = "M";
			if( key_dest == "" ) key_dest = "M";
		    trsp_bnd_cd = fromSheet.CellValue(arrRow[ir],"trsp_bnd_cd");                /* IRG 조회시 TERM 구분하기위해 BND,RCVDE_TERM 넘김 */
		    bkg_rcvde_term_cd = fromSheet.CellValue(arrRow[ir],"bkg_rcvde_term_cd");    /* IRG 조회시 TERM 구분하기위해 BND,RCVDE_TERM 넘김 */
			
		} else if( docObjcheck == "O" ) {
			key_org = fromSheet.CellValue(arrRow[ir], "por_nod_cd")+fromSheet.CellValue(arrRow[ir], "por_nod_cd_yard");
			key_dest = fromSheet.CellValue(arrRow[ir], "pol_cd")+fromSheet.CellValue(arrRow[ir], "pol_cd_yard");
		    trsp_bnd_cd = fromSheet.CellValue(arrRow[ir],"trsp_bnd_cd");
		    bkg_rcvde_term_cd = fromSheet.CellValue(arrRow[ir],"bkg_rcvde_term_cd");
			
		} else if( docObjcheck == "C" ) {
			doc_cgo_tp_cd = fromSheet.CellValue(arrRow[0], "cgo_tp_cd");
			if( doc_cgo_tp_cd == "M" ) {
				key_org = "M"; //가짜 데이터 차후에 사용 가능성 있음.
				key_dest = "M"; //가짜 데이터 차후에 사용 가능성 있음.
    		    trsp_bnd_cd ='M';
    		    bkg_rcvde_term_cd = 'M'
			} else {
				key_org = fromSheet.CellValue(arrRow[ir], "podpor_cd") +fromSheet.CellValue(arrRow[ir], "podpor_yard")  ;
				key_dest = fromSheet.CellValue(arrRow[ir], "poldel_cd") + fromSheet.CellValue(arrRow[ir], "poldel_yard");
    		    trsp_bnd_cd = fromSheet.CellValue(arrRow[ir],"trsp_bnd_cd");
    		    bkg_rcvde_term_cd = fromSheet.CellValue(arrRow[ir],"bkg_rcvde_term_cd");
				
			}
		} else {
			doc_cgo_tp_cd = "M";
			key_org = "M"; //가짜 데이터 차후에 사용 가능성 있음.
			key_dest = "M"; //가짜 데이터 차후에 사용 가능성 있음.
   		    trsp_bnd_cd ='M';
   		    bkg_rcvde_term_cd = 'M'			
		}
		
		docSeperate =  trsp_bnd_cd +","+bkg_rcvde_term_cd +","+ fromSheet.CellValue(arrRow[ir], "fm_nod_cd") + fromSheet.CellValue(arrRow[ir], "fm_nod_yard") +","+ fromSheet.CellValue(arrRow[ir], "to_nod_cd") + fromSheet.CellValue(arrRow[ir], "to_nod_yard") +","+ fromSheet.CellValue(arrRow[ir], "rout_org_nod_cd") +","+ fromSheet.CellValue(arrRow[ir], "rout_dest_nod_cd") +","+ fromSheet.CellValue(arrRow[ir], "rout_seq") +","+ fromSheet.CellValue(arrRow[ir], "cgo_tp_cd") +","+ key_org +","+ key_dest;
		
		HPut(ir, docSeperate);
	}

	//아래의 로직은 일한 데이터가 있는지 없는지를 체크하는 로직임.
	for( var y = 0; y < nodeCount; y++ ) {
		for( var x = y+1; x < nodeCount; x++ ) {
			if( HGet(y) == HGet(x) ) {
				HDel(x);
			}
		}
	}
	for( var y = 0; y < nodeCount; y++ ) {
		if( HGet(y) != null ) {
			docParameter = docParameter + HGet(y) + "|";
		}
	}
	docParameter = docParameter.substring(0,docParameter.length-1);

	document.form.hid_parameter.value = docParameter;
	document.form.empty_yn.value = doc_cgo_tp_cd;

	// IRG MAIN Listing
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH,'M');    
	
	// IRG 리스트에 있으면, 각 정보를 Candidate drop down list 에 추가하여준다.
	if( sheetObjects[0].rowcount > 0 ){
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH,'D');	// IRG Candidate listing.

		// 각 row 별로 IRG 리스팅된것을 Dropdown 화 시킨다.
		for ( i = 1; i < sheetObjects[0].RowCount+1 ; i++ ) {
			var alt_list = "";
			var alt_code = "";

			for ( j = 0; j < sheetObjects[1].RowCount; j++ ) {
				if(  sheetObjects[0].CellValue(i+1, "seq") ==  sheetObjects[1].CellValue(j+1, "key_seq") )   {
					alt_list  = alt_list + " " + "\t" + sheetObjects[1].CellValue(j+1, "prio_seq") + "\t" + sheetObjects[1].CellValue(j+1, "irg") + "\t" +  sheetObjects[1].CellValue(j+1, "rout_pln_cd") + "\t" + sheetObjects[1].CellValue(j+1, "ref_no") + "\t" + sheetObjects[1].CellValue(j+1, "inlnd_rout_rmk") + "\t" + sheetObjects[1].CellValue(j+1, "rtr") + "|"    ;
					alt_code  = alt_code + sheetObjects[1].CellValue(j+1, "alt_sub_seq")+ "|";
				}

				var selected_rout_org  = sheetObjects[1].CellValue(j+1, "rout_org_nod_cd");
				var selected_rout_dest = sheetObjects[1].CellValue(j+1, "rout_dest_nod_cd");
				var selected_rout_seq  = sheetObjects[1].CellValue(j+1, "rout_seq");
				
				// 원 IRG 와 IRG Candidate 중 같은 것을 찾는다.   drop down list 에서 기본값 설정을 위함.
				if (   sheetObjects[0].CellValue(i+1, "rout_org_nod_cd")  == selected_rout_org  
					 & sheetObjects[0].CellValue(i+1, "rout_dest_nod_cd") == selected_rout_dest  	
					 & sheetObjects[0].CellValue(i+1, "rout_seq")		  == selected_rout_seq	)
				{
					var rowIrgrout = j+1;
				}
			}

 		sheetObjects[0].CellComboItem(i+1 , "irg_dropdownlist", alt_list, alt_code   );
		initFlag = 0;  // 초기에 CHANGE EVENT 발생하지 않는 조치.

		//초기값을 초기 IRG 데이터로 셋팅
		if (rowIrgrout ==0  )		// 원 IRG 값이 후보 LIST 에 없을때..
		{
			showerr('No IRG candidates.');
			return;
		}
		
		sheetObjects[0].CellValue(i+1 , "irg_dropdownlist") =  sheetObjects[1].CellValue( rowIrgrout, "alt_sub_seq") ;  // DROPDOWN LIST 초기값 할당.
		
		}
	}
}

//부모창에 변경된 Node정보를 넣는다.
function IBS_Sheet3SheetStatus2(fromSheet, toSheet, formObj, sStatus) {

	objInit();
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	//함수 인자 유효성 확인
	if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	var sRow = toSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");

	var docSeperate = "";
	var docSeperate1 = "";

	var docInterchange1 = "";
	var docInterchange2 = "";
	
	var rcvde_term = "";

	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
		HPut(ir, arrRow[ir]);
	}

	/*  GROUP 된 KEY 값을 비교하여 Main 창에 IRG 변경분 적용.
	TERM,  FROM_NODE,  TO_NODE,  ROUT_ORG,  ROUT_DEST,  ROUT_SEQ
	*/

	for( var i = 0; i < fromSheet.RowCount; i++ ) {

		var bnd = fromSheet.CellValue(i+2, "trsp_bnd_cd");
		var cgo_tp = fromSheet.CellValue(i+2, "cgo_tp_cd");

		if (cgo_tp =='M'  )	{
			docSeperate = fromSheet.CellValue(i+2, "bkg_rcvde_term_cd") + fromSheet.CellValue(i+2, "from_node") + fromSheet.CellValue(i+2, "to_node") + fromSheet.CellValue(i+2, "rout_org_nod_cd") + fromSheet.CellValue(i+2, "rout_dest_nod_cd") + fromSheet.CellValue(i+2, "rout_seq");
		} else {
			docSeperate = fromSheet.CellValue(i+2, "bkg_rcvde_term_cd") + fromSheet.CellValue(i+2, "from_node") + fromSheet.CellValue(i+2, "to_node") + fromSheet.CellValue(i+2, "rout_org_nod_cd") + fromSheet.CellValue(i+2, "rout_dest_nod_cd") + fromSheet.CellValue(i+2, "rout_seq") + fromSheet.CellValue(i+2, "polpod");
		}
		
		if( fromSheet.CellValue(i+2, "new_fm_nod_cd") != "" && fromSheet.CellValue(i+2, "new_to_nod_cd") != "" ) {
			for( var v = 0; v < nodeCount; v++ ) {
				if( HGet(v) != null ) {
				    
				    if (toSheet.CellValue(HGet(v), "bkg_rcvde_term_cd") == 'D') rcvde_term = 'DOOR'
				     else rcvde_term = "CY";

					if (docObjcheck == 'C')	{   // correction 에서 열릴때

						if (  bnd =='I' ) {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq") + toSheet.CellValue(HGet(v), "podpor_cd") + toSheet.CellValue(HGet(v), "podpor_yard");
						} else if (  bnd =='O' ) {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq") + toSheet.CellValue(HGet(v), "poldel_cd") + toSheet.CellValue(HGet(v), "poldel_yard");
						} else {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq");
						}

					} else {  // 다른 화면에서 열때.

						if (  bnd =='I' ) {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq") + toSheet.CellValue(HGet(v), "pod_cd") + toSheet.CellValue(HGet(v), "pod_cd_yard");
						} else if (  bnd =='O' ) {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq") + toSheet.CellValue(HGet(v), "pol_cd") + toSheet.CellValue(HGet(v), "pol_cd_yard");
						} else {
							docSeperate1 = rcvde_term + toSheet.CellValue(HGet(v), "fm_nod_cd") + toSheet.CellValue(HGet(v), "fm_nod_yard") + toSheet.CellValue(HGet(v), "to_nod_cd") + toSheet.CellValue(HGet(v), "to_nod_yard") + toSheet.CellValue(HGet(v), "rout_org_nod_cd") + toSheet.CellValue(HGet(v), "rout_dest_nod_cd") + toSheet.CellValue(HGet(v), "rout_seq");
						}					
					}


					if( docSeperate == docSeperate1 ) {
						toSheet.CellValue2(HGet(v), "fm_nod_cd") = fromSheet.CellValue(i+2, "new_fm_nod_cd");
						toSheet.CellValue2(HGet(v), "fm_nod_yard") = fromSheet.CellValue(i+2, "new_fm_nod_yard");
						toSheet.CellValue2(HGet(v), "to_nod_cd") = fromSheet.CellValue(i+2, "new_to_nod_cd");
						toSheet.CellValue2(HGet(v), "to_nod_yard") = fromSheet.CellValue(i+2, "new_to_nod_yard");
						toSheet.CellValue2(HGet(v), "rout_org_nod_cd") = fromSheet.CellValue(i+2, "new_rout_org");
						toSheet.CellValue2(HGet(v), "rout_dest_nod_cd") = fromSheet.CellValue(i+2, "new_rout_dest");
						toSheet.CellValue2(HGet(v), "rout_seq") = fromSheet.CellValue(i+2, "new_rout_seq");
						toSheet.CellValue2(HGet(v), "rout_pln_cd") = fromSheet.CellValue(i+2, "new_rout_pln_cd");
						toSheet.CellValue2(HGet(v), "ref_no") = fromSheet.CellValue(i+2, "new_ref_no");
						toSheet.CellValue2(HGet(v), "inlnd_rout_rmk") = fromSheet.CellValue(i+2, "new_inlnd_rout_rmk");
						toSheet.CellValue2(HGet(v), "rail_cmb_thru_tp_cd") = fromSheet.CellValue(i+2, "new_rail_cmb_thru_tp_cd");
						

						toSheet.CellValue2(HGet(v), "interchange1_loc") = fromSheet.CellValue(i+2, "interchange1_loc");
						toSheet.CellValue2(HGet(v), "interchange1_nod") = fromSheet.CellValue(i+2, "interchange1_nod");
						toSheet.CellValue2(HGet(v), "interchange2_loc") = fromSheet.CellValue(i+2, "interchange2_loc");
						toSheet.CellValue2(HGet(v), "interchange2_nod") = fromSheet.CellValue(i+2, "interchange2_nod");
						
						HDel(v);
					}
				}
			}
		}
	}
	window.close();
}


/**
 * Sheet1에서 이벤트를 발생시킴.
 */
function sheet1_OnChange(sheetObj, row , col, value) {

	var irglist_sheet = sheetObj;
	var altlist_sheet = sheetObjects[1];
	var selectedRow = 0;
	if( initFlag ==0 &&  sheetObj.ColSaveName(col) == "irg_dropdownlist" ) {
		for( var i=0 ; i<altlist_sheet.RowCount ;i++  )	{
			if( altlist_sheet.CellValue( i+1 , "key_seq") == irglist_sheet.CellValue( row, "seq")  && altlist_sheet.CellValue( i+1 , "alt_sub_seq") == value ) {
				selectedRow = i+1;
				break;
			}
		}

		var prio_seq		= altlist_sheet.CellValue( selectedRow, "prio_seq")    ;
		var irg				= altlist_sheet.CellValue( selectedRow, "irg");
		var rout_pln_cd		= altlist_sheet.CellValue( selectedRow, "rout_pln_cd");
		var ref_no			= altlist_sheet.CellValue( selectedRow, "ref_no");
		var inlnd_rout_rmk	= altlist_sheet.CellValue( selectedRow, "inlnd_rout_rmk");
		var rout_org_nod_cd = altlist_sheet.CellValue( selectedRow, "rout_org_nod_cd");
		var rout_dest_nod_cd= altlist_sheet.CellValue( selectedRow, "rout_dest_nod_cd");
		var rout_seq		= altlist_sheet.CellValue( selectedRow, "rout_seq");
		var rail_cmb_thru_tp_cd = altlist_sheet.CellValue( selectedRow, "rail_cmb_thru_tp_cd");
		var rtr_flag = altlist_sheet.CellValue( selectedRow, "rtr");
		
		var fm_nod_cd		= altlist_sheet.CellValue( selectedRow, "fm_nod").substring(0, 5);
		var fm_nod_yard		= altlist_sheet.CellValue( selectedRow, "fm_nod").substring(5);
		var to_nod_cd		= altlist_sheet.CellValue( selectedRow, "to_nod").substring(0, 5);
		var to_nod_yard		= altlist_sheet.CellValue( selectedRow, "to_nod").substring(5);
		
		var ic1_cd		= altlist_sheet.CellValue( selectedRow, "ic_1").substring(0, 5);
		var ic1_nod		= altlist_sheet.CellValue( selectedRow, "ic_1").substring(5);
		var ic2_cd		= altlist_sheet.CellValue( selectedRow, "ic_2").substring(0, 5);
		var ic2_nod		= altlist_sheet.CellValue( selectedRow, "ic_2").substring(5);


		if ( selectedRow == 0 )  
		{
			ComShowMessage('No IRG selected.' + rail_cmb_thru_tp_cd );
			irglist_sheet.CellValue2( row , "irg_dropdownlist") = "No IRG";
			return;
		} else if (  rtr_flag == "NRD" || rail_cmb_thru_tp_cd.length < 1 ) {
			ComShowMessage("Please do COP Change for all motor transportation instead of doing IRG Adjust.");
			return;
		} else if ( rtr_flag =="RTR" ) {
			errMsg = ComGetMsg("TRS90363");
			ComShowMessage(errMsg);
			return;
		}

		irglist_sheet.CellValue2( row , "new_prio_seq")				= prio_seq;
		irglist_sheet.CellValue2( row , "new_irg")					= irg;
		irglist_sheet.CellValue2( row , "new_rout_pln_cd")			= rout_pln_cd;
		irglist_sheet.CellValue2( row , "new_ref_no")				= ref_no;
		irglist_sheet.CellValue2( row , "new_inlnd_rout_rmk")		= inlnd_rout_rmk;
		irglist_sheet.CellValue2( row , "new_rout_org")				= rout_org_nod_cd;
		irglist_sheet.CellValue2( row , "new_rout_dest")			= rout_dest_nod_cd;
		irglist_sheet.CellValue2( row , "new_rout_seq")				= rout_seq;

		irglist_sheet.CellValue2( row , "new_rail_cmb_thru_tp_cd")	= rail_cmb_thru_tp_cd;
		irglist_sheet.CellValue2( row , "new_fm_nod_cd")			= fm_nod_cd;
		irglist_sheet.CellValue2( row , "new_fm_nod_yard")			= fm_nod_yard;
		irglist_sheet.CellValue2( row , "new_to_nod_cd")			= to_nod_cd;
		irglist_sheet.CellValue2( row , "new_to_nod_yard")			= to_nod_yard;

		irglist_sheet.CellValue2( row , "interchange1_loc")			= ic1_cd;
		irglist_sheet.CellValue2( row , "interchange1_nod")			= ic1_nod;
		irglist_sheet.CellValue2( row , "interchange2_loc")			= ic2_cd;
		irglist_sheet.CellValue2( row , "interchange2_nod")			= ic2_nod;


		var docParameter =   irg;
		var doc_irg = "";
		var doc_count = 2; //rd의 index는 배열이기 때문에 하나 더 증가한다.
		var arrParameter = docParameter.split("-");
		var arr_rd_param = docParameter.split("RD/");	
	
		for( var ir = 0; ir < arrParameter.length; ir++ ) {
	
			if( arrParameter[ir].indexOf("RD/") > 0 ) {
				if( doc_count == arr_rd_param.length ) {
					doc_irg = doc_irg + arrParameter[ir-1]+"-"+arrParameter[ir]+"-"+arrParameter[ir+1];
				} else {
					doc_irg = doc_irg + arrParameter[ir-1]+"-"+arrParameter[ir]+"-";
				}
				doc_count++;
			}
		}
	
		irglist_sheet.CellValue2( row , "new_irg")					= doc_irg;
	}
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {

	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
	}
}
