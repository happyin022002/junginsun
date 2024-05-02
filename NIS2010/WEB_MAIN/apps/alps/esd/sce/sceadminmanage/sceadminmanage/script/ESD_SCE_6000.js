/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_SCE_6000.js
 *@FileTitle : SCE Admin
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.02
 *@LastModifier : 김인수
 *@LastVersion : 1.0
 * 2010.12.02 김인수
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
 * @class ESD_SCE_6000 : ESD_SCE_6000 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_SCE_6000() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	 for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
     }
	 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");	 
}

function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btns_calendar1":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.tml_fm_dt, formObj.tml_to_dt, 'yyyy-MM-dd');						
			  break;
			  
			case "btns_calendar2":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.rpln_fm_dt, formObj.rpln_to_dt, 'yyyy-MM-dd');						
			break;
			
			case "btns_calendar3":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.mst_fm_dt, formObj.mst_to_dt, 'yyyy-MM-dd');						
			break;			
		
			case "btn_retrieve":
				
				var ibtask = "";
				if (beforetab == 0) { // terminal change
					ComClearSeparator(document.form.tml_fm_dt);
					ComClearSeparator(document.form.tml_to_dt);
					
					ibtask = IBSEARCH_ASYNC01;
				} else if (beforetab == 1) { // Cop Replan Fail
					ComClearSeparator(document.form.rpln_fm_dt);
					ComClearSeparator(document.form.rpln_to_dt);
					
					ibtask = IBSEARCH_ASYNC03;
				} else if (beforetab === 2) { // mst cop no diff
					ComClearSeparator(document.form.mst_fm_dt);
					ComClearSeparator(document.form.mst_to_dt);
					
					ibtask = IBSEARCH_ASYNC05;
				} else if (beforetab == 3) { // cntrDiff
					ComClearSeparator(document.form.cdiff_fm_dt);
					ComClearSeparator(document.form.cdiff_to_dt);
					
					ibtask = IBSEARCH_ASYNC06;
				} else if (beforetab == 4) { //tro val
					ibtask = IBSEARCH_ASYNC07;
				} else if (beforetab == 5) { //tro val
					ComClearSeparator(document.form.act_fm_dt);
					ComClearSeparator(document.form.act_to_dt);
					
					ibtask = IBSEARCH_ASYNC08;
				} 
				
				doActionIBSheet(sheetObjects[beforetab],formObj,ibtask);
				break;

			case "btn_new":
				sheetObjects[beforetab].RemoveAll();
				formObj.reset();
				break;
			
			case "btn_diff":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC09)
				break;
			
			case "btn_terminalChange":
				ComClearSeparator(document.form.fm_dt);
				ComClearSeparator(document.form.to_dt);
				
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC02)
				break;
			case "btn_manualReplan":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC04)
				break;
			
			case "btn_batchManualReplan":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC14)
				break;	
				
			case "btn_RowAdd":
				if (formObj.row_add_cnt.value=='') formObj.row_add_cnt.value=1;
				for(var i=1; i<=formObj.row_add_cnt.value; i++ ) {
					sheetObjects[beforetab].DataInsert(-1);
				}
				break;
			
			case "btn_RowDelete":
				if (formObj.row_del_cnt.value=='') formObj.row_add_cnt.value=1;
				for(var i=1; i<=formObj.row_del_cnt.value; i++ ) {
					sheetObjects[beforetab].RowDelete(sheetObjects[beforetab].RowCount, false);
				}
			break;
			
            case "btn_leaSearch":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC10);
				break;

            case "btn_LeaToAlpsIF":
                var yr = document.form.leaAccMon.value.substring(0,4)+'/';
                var mn = document.form.leaAccMon.value.substring(4,6);
                if(!confirm(ComGetMsg('COM130501', 'LEA account candidate data at '+yr+mn ))){
                    return;
                }
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC11);
				break;

            case "btn_mnrReplanAdd":
                if(!confirm(ComGetMsg('COM130501','SCE_MNL_RPLN table'))) {
                    return;
                }
				doActionIBSheet(sheetObjects[7], formObj, IBSEARCH_ASYNC12);
				break;

            case "btn_mnrReplanSearch":
				doActionIBSheet(sheetObjects[7], formObj, IBSEARCH_ASYNC13);
				break;

            case "btn_leadownload":
                sheetObjects[7].SpeedDown2Excel();
                break;

			case "btn_download":
				sheetObjects[beforetab].SpeedDown2Excel();
                break;
			
			case "btn_leaAuto":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC10);
				doActionIBSheet(sheetObjects[7], formObj, IBSEARCH_ASYNC15);
				break;
				
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
	}

}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'sce6000_obj_deactivate', formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate',   'sce6000_activate', formObject); //- 포커스 들어갈때
}

function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "  |  |Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|BKG NO|CNTR NO|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  20,	daCenter,  true,	"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtCheckBox,  20,	daCenter,  true,	"chk_cd",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
			
		case 2:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);


				var HeadTitle0 = "  |By BKG INFO|RegenPC|COP NO|BKG NO|MST COP NO|PCTL NO|RESULT";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  20,	daCenter,  true,	"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtCheckBox,  100,	daCenter,  true,	"bkg_info",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtCheckBox,  80,	daCenter,  true,	"regen_pc",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"cop_no",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"bkg_no",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"mst_cop_no",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,  	140,	daCenter,	true,	"pctl_no",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"rpln_rslt",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
//				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
				for(var i=0; i<1; i++){
					DataInsert(-1);
				}
		   }
			break;
			
		case 3:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(18, 4, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "BKG No|CNTR No|TPSZ|CNMV YR|COP NO|COP STS|PCTL NO|MST COP NO|Vsl|Voy|Dir|POR|POL|POD|DEL|IB TRO|OB TRO|COP UPD RMK";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"bkg_no",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cntr_tpsz_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cnmv_yr",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cop_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cop_sts_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"pctl_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"mst_cop_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"trnk_vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"trnk_skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"trnk_skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"por_nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"pol_nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"pod_nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"del_nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"ib_tro_flg",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"ob_tro_flg",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_upd_rmk",			false,		  "",	   dfNone,	 	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
		   }
			break;
			
		case 4:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 4, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "  |  |Evnt Rmk|Evnt Tp|BKG No|Cntr No|TPSZ|BKG_CRE_DT(KOR)|CNTR_CRE_DT(KOR)|SI FLG|XTER SI CD"

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  20,	daCenter,  true,	"ibflag",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtCheckBox,  20,	daCenter,  true,	"chk_cd",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"bkg_evnt_rmk",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"bkg_evnt_tp_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	100,	daCenter,	true,	"bkg_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	100,	daCenter,	true,	"cntr_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"cntr_tpsz_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"bkg_cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	50,	daCenter,	true,	"si_flg",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	90,	daCenter,	true,	"xter_si_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
				
			//	DataLinkMouse = true;
		   }
			break;
			
		case 5:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,	daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,	daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"vps_port_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,	daCenter,	true,	"clpt_ind_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,	daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,	true,	"cop_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"tml_if_dtl_sts_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"cre_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"upd_usr_id",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"upd_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
			}
			break;
		case 6:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "Act Rcv Dt|Act Rcv No|BKG No.|CNTR No.|Act Dt|Sts|Node|Rcv Tp|Umch Tp Cd|Umch Chk Dt|Vsl|Voy No|Dir|Err Message|Event Seq";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"act_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"act_rcv_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,  	100,	daCenter,	true,	"bkg_no",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"act_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"act_sts_mapg_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	80,		daCenter,	true,	"nod_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"act_rcv_tp_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"act_umch_tp_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	100,	daCenter,	true,	"umch_chk_dt",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	70,		daCenter,	true,	"vsl_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	60,		daCenter,	true,	"skd_voy_no",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,		daCenter,	true,	"skd_dir_cd",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		110,	daLeft	,	true,	"err_msg",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	40,		daCenter,	true,	"cop_evnt_seq",			false,		  "",	   dfNone,	 	0,	 		false,	   false);

				style.height = GetSheetHeight(20) ;
			//	DataLinkMouse = true;
				
		   }
			break;

            case 7:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = 800;
                style.height = GetSheetHeight(10) ;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "BKG No|CNTR No|Cost Act Group|Cost Act Group Seq|Create User|Create Date|Update User|Update Date";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	120,	daCenter,	true,	"bkg_no",		        false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,  	120,	daCenter,	true,	"cost_act_grp_cd",		false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"cost_act_grp_seq",		false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	120,	daCenter,	true,	"cre_usr_id",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"cre_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,		daCenter,	true,	"upd_usr_id",			false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"upd_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				
		   }
			break;

            case 8:	  //IBSheet1 init
			with (sheetObj) {

				//전체 너비 설정
                SheetWidth = 800;
                style.height = GetSheetHeight(10) ;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);


				var HeadTitle0 = "COP No|BKG No|Master Cop No|Pctl No|Bound|Replan Success|Coa If|Create User|Create Date|Update User|Update Date|Replan Job Type";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	120,	daCenter,	true,	"cop_no",           false,		  "",	   dfNone,   	0,	 		false ,	   false );
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"bkg_no",        	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,  	120,	daCenter,	true,	"mst_cop_no",    	false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"pctl_no",       	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  	120,	daCenter,	true,	"io_bnd_cd",     	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"rpln_scs_flg",  	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,		daCenter,	true,	"coa_if_flg",    	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"cre_usr_id",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"cre_dt",        	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"upd_usr_id",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"upd_dt",        	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"rpln_jb_tp_cd", 	false,		  "",	   dfNone,   	0,	 		false,	   false);
				

		   }
			break;
	}
}


function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch (sAction) {
		case IBCLEAR:      //조회		  
			formObj.tml_fm_dt.value = ComGetNowInfo();
			formObj.tml_to_dt.value = ComGetNowInfo();
			
			formObj.rpln_fm_dt.value = ComGetNowInfo();
			formObj.rpln_to_dt.value = ComGetNowInfo();

			formObj.mst_fm_dt.value = ComGetNowInfo();
			formObj.mst_to_dt.value = ComGetNowInfo();
			
			formObj.cdiff_fm_dt.value = ComGetNowInfo();
			formObj.cdiff_to_dt.value = ComGetNowInfo();
			
			formObj.act_fm_dt.value = ComGetNowInfo();
			formObj.act_to_dt.value = ComGetNowInfo();
			
			sheetObj.RemoveAll();
			break;
		case IBSEARCH: // 조회
		// formObj.f_cmd.value = MULTI01 ;
		// sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
	
			break;
		case IBSEARCH_ASYNC01: // tmlChgRslt
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value = MODIFY01;
			sheetObj.DoSave("ESD_SCE_6000GS.do",FormQueryString(formObj));
		case IBSEARCH_ASYNC03: // CopReplan Fail 에서 cop replan list 조회
			formObj.f_cmd.value = SEARCH02;
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			}
			ComAddSeparator(formObj.rpln_fm_dt);
			ComAddSeparator(formObj.rpln_to_dt);
			break;
		case IBSEARCH_ASYNC04: // CopReplan Fail 에서 cop replan
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MODIFY02; 
			sheetObj.DoSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
		}
			break;
		case IBSEARCH_ASYNC05: // Mst cop no
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;

		case IBSEARCH_ASYNC06: // Cntr Diff
			ComClearSeparator(formObj.cdiff_fm_dt);
			ComClearSeparator(formObj.cdiff_to_dt);
			
			formObj.f_cmd.value = SEARCH04;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;	
			
		case IBSEARCH_ASYNC07: // tro
			formObj.f_cmd.value = SEARCH05;
//			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		case IBSEARCH_ASYNC08: // act rcv if
			formObj.f_cmd.value = SEARCH06;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;		
		case IBSEARCH_ASYNC09: // Cntr diff 처리
			formObj.f_cmd.value = MODIFY03; 
			sheetObj.DoSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
            
        case IBSEARCH_ASYNC10: // LEA 대상 Retrieve
			formObj.f_cmd.value = SEARCH07; 
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
        
        case IBSEARCH_ASYNC11: // LEA->ALPS IF
			formObj.f_cmd.value = MODIFY04; 
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;

        case IBSEARCH_ASYNC12: // MNR Replan Add
			formObj.f_cmd.value = SEARCH08;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;

        case IBSEARCH_ASYNC13: // MNR Replan Retrieve
        	formObj.f_cmd.value = SEARCH09;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		
        case IBSEARCH_ASYNC14: // Batch MNR Replan Add
        if (validateForm(sheetObj, formObj, sAction)) {
	        formObj.f_cmd.value = MODIFY05;
			sheetObj.DoSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
        }
		break;
		
        case IBSEARCH_ASYNC15:
        	formObj.f_cmd.value = SEARCH10;
			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
        break;
	}
}

function validateForm(sheetObj,formObj,sAction){
	var result = false;
	with(formObj){
		switch(sAction) {
			case IBSEARCH_ASYNC03:
				if (!ComIsEmpty(formObj.rpln_cntr_no) && ComIsEmpty(formObj.rpln_fm_dt) && ComIsEmpty(formObj.rpln_to_dt)) {
//					alert("When Cntr_no is not null, then from ~ to date must be filled in!");
					ComShowMessage(msgs['SCE60001']);
					return false;
				} else if (ComIsEmpty(formObj.rpln_bkg_no) && ComIsEmpty(formObj.rpln_bl_no) && ComIsEmpty(formObj.rpln_cntr_no) && ComIsEmpty(formObj.rpln_cop_no)) {
					ComShowMessage(msgs['SCE60002']); // At least one of following conditions should be filled in to retrieve. 
					return false;
				}
				break;
			case IBSEARCH_ASYNC04:
			case IBSEARCH_ASYNC14:
				for(var a=sheetObj.RowCount+1; a>0 ;a--){
					if(sheetObj.CellValue(a,"cop_no")=='')
						sheetObj.RowDelete(a, false);
				}
				return true;
				break;
		}
		return true;
	}
}

function sce6000_activate(){
	//입력Validation 확인하기
	switch(event.srcElement.name){	
    	case "tml_fm_dt":
    		ComClearSeparator(event.srcElement);
			break;
    	case "tml_to_dt":
    		ComClearSeparator(event.srcElement);
			break;
		default:
			event.srcElement.onfocus = new Function("this.select()");
			break;
	}
}
	
function sce6000_obj_deactivate(){
	switch(event.srcElement.name){
    	case "tml_fm_dt":
    	case "tml_to_dt":
    	case "rpln_fm_dt":
    	case "rpln_to_dt":
    	case "mst_fm_dt":
    	case "mst_to_dt":
    	case "cdiff_fm_dt":
    	case "cdiff_to_dt":
    		ComAddSeparator(event.srcElement);
			break;
		default:
			break; 
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
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
     var cnt  = 0 ;
     switch(tabNo) {
         case 1:
            with (tabObj) {
                InsertTab( cnt++, "TmlChgRslt" , -1 );
                InsertTab( cnt++, "CopReplan Fail" , -1 );
                InsertTab( cnt++, "MST_COP_NO Diff" , -1 );
                InsertTab( cnt++, "CntrDiff" , -1 );
                InsertTab( cnt++, "TRO Val" , -1 );
                InsertTab( cnt++, "Actual Mapping" , -1 );
                InsertTab( cnt++, "LEA Monthly Account" , -1 );
            }
         break;
    }
}
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.tml_fm_dt);
	ComAddSeparator(document.form.tml_to_dt);

}	

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.rpln_fm_dt);
	ComAddSeparator(document.form.rpln_to_dt);
}

function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.mst_fm_dt);
	ComAddSeparator(document.form.mst_to_dt);
}

function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.cdiff_fm_dt);
	ComAddSeparator(document.form.cdiff_to_dt);
}

function t6sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.act_fm_dt);
	ComAddSeparator(document.form.act_to_dt);
}

function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
    
    formObj = document.form;

    if(errMsg!=null){
        ComShowMessage(errMsg);
        return;
    }

    if(formObj.f_cmd.value == MODIFY04){
        ComShowMessage(ComGetMsg('COM12116', 'Data migration from LEA to SCE'));
    }
}

function t8sheet1_OnSearchEnd(sheetObj, ErrMsg){
    
    formObj = document.form;

    if(errMsg!=null){
        ComShowMessage(errMsg);
        return;
    }

    if(formObj.f_cmd.value == SEARCH08){
        ComShowMessage(ComGetMsg('COM130502', 'It'));
    }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}

//Container No. 의 CheckDigit 을 설정.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo = obj.value;

	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum = 0;
 	cntrNo = cntrNo.toUpperCase();

	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum = ComGetCntrChkDgt( cntrNo.substr(0,10));
//alert("  "+	cntrNo.substr(0,10));
//alert('sum:'+sum);		
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		obj.value = 	cntrNo.substr(0,10);
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}

}
/* 개발자 작업 끝 */