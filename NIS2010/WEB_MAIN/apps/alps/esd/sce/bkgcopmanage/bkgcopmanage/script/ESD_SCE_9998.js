/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_9998.js
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-21
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');						
			  break;
		
			case "btn_retrieve":
				ComClearSeparator(document.form.fm_dt);
				ComClearSeparator(document.form.to_dt);
				alert("tabCnt = " + tabCnt);
				//if(validateForm(sheetObj, formObj, IBSEARCH)){
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC16);
				//}
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_create":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;	
				
			case "btn_update":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
				break;					
				
			case "btn_split":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03);
				break;
				
			case "btn_combine":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC04);
				break;
				
			case "btn_cntrAttach":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC09);
				break;
			case "btn_cntrDetach":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC10);
				break;
				
			case "btn_moveCntr":
				doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC11);
				break;
			case "btn_replan":
				doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC12);
				break;
			case "btn_confirmTro":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC13);				
				break;
			case "btn_cntrCnfm":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC15);
				break;
			case "btn_genPc" :
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC16);
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	 for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
     }
}

   /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
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
			
			
		case 2:	  //IBSheet1 init
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
			
		case 4:	  //IBSheet1 init
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
	}
}

 
    
  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {
		case IBSEARCH:	  //조회
//			formObj.f_cmd.value = MULTI01 ;
//			sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
	
			break;

	   case IBDOWNEXCEL:
//			  formObj.f_cmd.value = MULTI01 ;
//			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC01: // booking create
			  formObj.f_cmd.value = MULTI01 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
			  
	   case IBSEARCH_ASYNC02: // booking update
			  formObj.f_cmd.value = MULTI02 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			  
	   
	   case IBSEARCH_ASYNC03: // booking split
			  formObj.f_cmd.value = MULTI03 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC04: // booking combine
			  formObj.f_cmd.value = MULTI04 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC03: // booking cancel 
			  formObj.f_cmd.value = MULTI05 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;	
	   case IBSEARCH_ASYNC09: // attach container
			  formObj.f_cmd.value = MULTI09 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC10: // attach container
			  formObj.f_cmd.value = MULTI10 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC11: // move container
			  formObj.f_cmd.value = MULTI11 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			
	   case IBSEARCH_ASYNC12: // replan
			  formObj.f_cmd.value = MULTI12 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC13: // tro confirm
			  formObj.f_cmd.value = MULTI13 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC14: // tro unconfirm
			  formObj.f_cmd.value = MULTI14 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;
	   case IBSEARCH_ASYNC15: // tro unconfirm
			  formObj.f_cmd.value = MULTI15 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;	
	   case IBSEARCH_ASYNC16: // Terminal change 결과 조회
			  formObj.f_cmd.value = MULTI16 ;
			  sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", SceFrmQryString(formObj));
			  break;			  
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    var result = true;
	if(sAction == IBSEARCH) {
		// 검색 조건 입력 여부
		if( !isInputField(formObj) ) {
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no) && !ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No
	    } else if( !ComIsEmpty(formObj.bkg_no) && ! ComChkObjValid(formObj.bkg_no, 11, "BKG No")) { // BKG No		
			result = false ;
		//} else if( !ComIsEmpty(formObj.bkg_no_split) && !ComChkObjValid(formObj.bkg_no_split, 2, "BKG No Split") ) { // BKG NO Split
		//	result = false ;
		} else if( !ComIsEmpty(formObj.bl_no) && !ComChkObjValid(formObj.bl_no, 12, "BL No") ) { // BL No
			result = false ;
		} else if( !ComIsEmpty(formObj.cntr_no) && !ComChkObjValid(formObj.cntr_no, 11, "Container No") ) { // Container No
			result = false ;
		} else if( !ComIsEmpty(formObj.cop_no) && !ComChkObjValid(formObj.cop_no, 14, "COP No") ) { // Cop No
			result = false ;
		}
	}

	return result;
}

function isInputField(formObj){
	var result    = false ;
	var fieldType = null ;
	for(i=0; i<formObj.length; i++){
		fieldType = formObj[i].type

		if((fieldType=="checkbox" || fieldType=="radio")){
			if(formObj[i].checked){
				result = true ;
				break ;
			}
		}
		else if(fieldType!="hidden" && !formObj[i].readOnly){
			if(!ComIsEmpty(formObj[i])){
				result = true ;
				break ;
			}
		}
	}

	if(!result){
		ComShowMessage(ComGetMsg('SCE90016')) ;
        formObj.bkg_no.focus() ;
	}
	return result ;
}

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt = sheetObj.CellValue(3, "totcnt");
	
	if(sheetObj.TotalRows > 0){
		sheetObj.TotalRows = totalCnt;
	}
	ComAddSeparator(document.form.fm_dt, "-");
	ComAddSeparator(document.form.to_dt, "-");
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("ESD_SCE_9998GS.do", selectVal, "cur_page=" + PageNo, true);
}

function ComChkObjValid(obj, len, msg) {
	var result = true ;

	if(getLenByByte(obj.value)!==len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result = false ;
	}

	return result ;
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj = document.form;
		if( validateForm(formObj) ) {
			formObj.f_cmd.value = "" ;
	//		formObj.target = "_self" ;
	//		formObj.action = "ESD_SCE_0002.do" ;
	//		formObj.submit() ;
		}
	}
}

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}

// Container No. 의 CheckDigit 을 설정.
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

function openAddPaste(dist){
//	window.open ("ESD_SCE_0064.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=400,height=400");
	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
}

function addValueNo(dist, multi_value){
	var multis = multi_value.split('\n');
	multi_value = '';
	for(var i = 0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
	}
	if(multi_value != ''){
//    		if(document.getElementById(dist).value != ''){
//    			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//    		}else{
			document.getElementById(dist).value = multi_value;
//    		}
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){

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
            }
         break;

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