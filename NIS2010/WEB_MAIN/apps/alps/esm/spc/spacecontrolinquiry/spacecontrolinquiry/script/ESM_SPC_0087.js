/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0087.js
*@FileTitle : T/S Plan & Guide
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2016.03.17 이혜민
* 2016.07.14 [CHM-201642304] 이혜민 T/S Plan & Guide 기능 Logic 수정 
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
     * @class ESM_SPC_0087 : ESM_SPC_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0087() {
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

    // 공통전역변수
    var sheetObjects = new Array();
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObj  = sheetObjects[0];
    	var sheetObj1 = sheetObjects[1];
    	var formObj   = document.form;
    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				break;
    			
				case "btn_save":
					doActionIBSheet(sheetObj, formObj, IBSAVE);					
					break;	
    				
				case "btn_new":
					var today = new	Date();
					var year  = today.getFullYear();
					formObj.year.value = year;
					SpcSearchOptionWeek("week");
					formObj.duration.value = "5";
					formObj.trade.Code 			= "";
					formObj.bound.value 		= "";
					formObj.vvd.value 			= "";
			    	formObj.txtVVD.value 		= "";
			    	formObj.txtWeek.value 		= "";
			    	formObj.txtRepTrd.value 	= "";
			    	formObj.txtRepSubTrd.value 	= "";
			    	formObj.txtRlane.value 		= "";
			    	formObj.txtDir.value 		= "";
			    	formObj.txtIrrPort.value 	= "";
			    	formObj.txtIrrYd.value 		= "";
			    	
					sheetObj.RemoveAll();
	    			sheetObj1.RemoveAll();
					break;	
				
				case "btn_downexcel":
					doActionIBSheet(sheetObj1, formObj, IBDOWNEXCEL);
					break;
					
				case "btng_main_rowAdd":
					sheetObj.DataInsert(-1);
					sheetObj.CellValue2(sheetObj.SelectRow, "ts_pln_gid_dtl")= "N";
					setSkdChangeReason(sheetObj, sheetObj.SelectRow);
					break;
					
				case "btng_save":
					doActionIBSheet(sheetObj1, formObj, "dtlSave");					
					break;
					
				case "btng_rowAdd":
					doActionIBSheet(sheetObj1, formObj, "rowAdd");
					break;
				
				case "btng_rowCopy":
					doActionIBSheet(sheetObj1, formObj, "rowCopy");
					break;	
					
				case "btng_tsAdd":
					doActionIBSheet(sheetObj1, formObj, "tsAdd");
					break;
					
				case "btng_tsDel":
					doActionIBSheet(sheetObj1, formObj, "tsDel");
					break;	
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    
    function loadPage(){
    	var formObj = document.form;
		SpcSearchOptionYear("year");
		SpcSearchOptionWeek("week");
		SpcSearchOptionDuration("duration", 5, 5);
		SpcSearchOptionTrade("trade", true, true);
		SpcSearchOptionSubTrade("subtrade", true, true);
		SpcSearchOptionLane("lane");
		SpcSearchOptionBound("bound",false,true,false,true);
    	loadingMode = true;
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	loadingMode = false;
    	hideSheet2Col(sheetObjects[1]);
    }
    
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			with (sheetObj) {
    				// 높이 설정
    				style.height = getSheetHeight(10) ;
    				// 전체 너비 설정
    				SheetWidth = mainTable1.clientWidth;
    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;
    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;
    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 9, 100);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false) ;
    				var HeadTitle0 = "STS|Seq.|Del|Rep.\nTrade|Sub\nTrade|Lane|Bound|Week|VVD|Operator|F/M|IRRE Port|IRRE Port|exist_flg|Type|T/S Plan|RS Code|Reason|Remark|CTY Remark|Create\nUser ID|Update\nUser ID|Update Date";				
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(ComCountHeadTitle(HeadTitle0), 0 , 0, true);
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);
    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtDataSeq,		50,	daCenter,	true,	"seq",				false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++,	dtDelCheck,		45,	daCenter,	true,	"del",				false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rep_trd_cd",		true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rep_sub_trd_cd",	true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rlane_cd",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"dir_cd",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"cost_wk",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80, daCenter,	true,	"vvd_cd",			true,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"crr_cd",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtCombo,		50,	daCenter,	true,	"port_skp_tp_cd",	false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtPopup,		60,	daCenter,	true,	"irr_port_cd",		true,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"irr_yd_cd",		true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		50, daCenter,	true,	"exist_flg",		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtCombo,		80, daCenter,	true,	"skd_cng_sts_cd",	false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			60, daCenter,	true,	"ts_pln_gid_dtl",	false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		50, daCenter,	true,	"skd_cng_rsn_cd",	false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			170, daLeft,	true,	"skd_cng_rsn_nm",	false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			170, daLeft,	true,	"ts_rmk",			false,	"",	dfNone,			0,	false,	false, 4000);  				
    				InitDataProperty(0,	cnt++ ,	dtData,			170, daLeft,	true,	"usr_rmk",			false,	"",	dfNone,			0,	true,	true, 4000);
    				InitDataProperty(0,	cnt++ ,	dtData,			80, daCenter,	true,	"cre_usr_id",		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80, daCenter,	true,	"upd_usr_id",		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80, daCenter,	true,	"upd_dt",			false,	"",	dfNone,			0,	false,	false);
    				
    				InitDataCombo (0, "port_skp_tp_cd", "Y|N", "Y|N");
    				InitDataCombo (0, "skd_cng_sts_cd", "Skip|Phase Out|Phase In", "S|O|I ");
    				InitDataValid (0, "vvd_cd", vtEngUpOther, "0123456789");
    			}
    			break;
    		
    		case 2:      //sheet2 init
    			with (sheetObj) {
    				// 높이 설정
    				style.height = getSheetHeight(15) ;
    				// 전체 너비 설정
    				SheetWidth = mainTable2.clientWidth;
    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;
    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 9, 100);
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false) ;
    				var HeadTitle0 = "STS|Seq.|DEL|pln_seq|Rep Trade|Sub Trade|Lane|Bound|Week|VVD|Operator|F/M|IRRE Port|IRRE Yard|Type|Reason|Remark|CTY Remark|Create\nUser ID|Update\nUser ID|Update Date|I/O|Full|MTY|Cargo\nOwner|POL|ETD|Lane|VVD|ETB|1st TS Port|1st TS Port|1st TS Port|1st TS Port|ETD|Lane|VVD|ETB|2nd TS Port|2nd TS Port|2nd TS Port|2nd TS Port|ETD|Lane|VVD|ETB|3rd TS Port|3rd TS Port|3rd TS Port|3rd TS Port|ETD|Lane|VVD|ETB|4th TS Port|4th TS Port|4th TS Port|4th TS Port|ETD|Lane|VVD|ETB|POD|Plan\nConfirm|Remark|Attachment|User ID|Update Date";
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(ComCountHeadTitle(HeadTitle0), 0 , 0, true);
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);

    				
    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",				false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtSeq,			30,	daCenter,	true,	"seq",					false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++,	dtDelCheck,		45,	daCenter,	true,	"del",					false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		80,	daCenter,	true,	"pln_seq",				false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"rep_trd_cd",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"rep_sub_trd_cd",		true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"rlane_cd",				true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"dir_cd",				true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"cost_wk",				true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		80, daCenter,	true,	"vvd_cd",				true,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		70,	daCenter,	true,	"crr_cd",				true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		50,	daCenter,	true,	"port_skp_tp_cd",		false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60,	daCenter,	true,	"irr_port_cd",			true,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		30,	daCenter,	true,	"irr_yd_cd",			true,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		60, daCenter,	true,	"skd_cng_sts_cd",		false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		170, daLeft,	true,	"skd_cng_rsn_nm",		false,	"",	dfNone,			0,	false,	true);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		170, daLeft,	true,	"mn_ts_rmk",			false,	"",	dfNone,			0,	false,	false, 4000);  				
    				InitDataProperty(0,	cnt++ ,	dtHidden,		170, daLeft,	true,	"usr_rmk",				false,	"",	dfNone,			0,	true,	true, 4000);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		80, daCenter,	true,	"mn_cre_usr_id",		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		80, daCenter,	true,	"mn_upd_usr_id",		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtHidden,		80, daCenter,	true,	"mn_upd_dt",			false,	"",	dfNone,			0,	false,	false);    				
    				
    				InitDataProperty(0,	cnt++ ,	dtCombo,		40,	daCenter,	true,	"ioc_cd",				false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtCheckBox,		40,	daCenter,	true,	"cntr_full_flg",		false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtCheckBox,		40,	daCenter,	true,	"cntr_mty_flg",			false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtPopup,		70,	daCenter,	true,	"mlt_crr_list_ctnt",	true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtPopup,		100,daCenter,	true,	"mlt_pol_list_ctnt",	true,	"",	dfNone,			0,	true,	true);
    				
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n1st_port_etd_dt",		false,	"",	dfDateYmd,		0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n1st_rlane_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"n1st_vvd_cd", 			false,	"",	dfNone,			0,	true,	true, 9);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n1st_port_etb_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				
    				//여기서부터 hidden. TS add/del로 컨트롤
    				InitDataProperty(0,	cnt++ ,	dtPopup,		60,	daCenter,	true,	"n1st_pod_cd", 			false,	"",	dfNone,			0,	true,	true); 
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n1st_pod_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n2nd_pol_cd", 			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n2nd_pol_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n2nd_port_etd_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n2nd_rlane_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"n2nd_vvd_cd", 			false,	"",	dfNone,			0,	true,	true, 9);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n2nd_port_etb_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				
    				InitDataProperty(0,	cnt++ ,	dtPopup,		60,	daCenter,	true,	"n2nd_pod_cd", 			false,	"",	dfNone,			0,	true,	true); 
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n2nd_pod_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n3rd_pol_cd", 			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n3rd_pol_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n3rd_port_etd_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n3rd_rlane_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"n3rd_vvd_cd", 			false,	"",	dfNone,			0,	true,	true, 9);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n3rd_port_etb_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				
    				InitDataProperty(0,	cnt++ ,	dtPopup,		60,	daCenter,	true,	"n3rd_pod_cd", 			false,	"",	dfNone,			0,	true,	true); 
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n3rd_pod_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n4th_pol_cd", 			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n4th_pol_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n4th_port_etd_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n4th_rlane_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"n4th_vvd_cd", 			false,	"",	dfNone,			0,	true,	true, 9);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n4th_port_etb_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				
    				InitDataProperty(0,	cnt++ ,	dtPopup,		60,	daCenter,	true,	"n4th_pod_cd", 			false,	"",	dfNone,			0,	true,	true); 
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n4th_pod_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n5th_pol_cd", 			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	"n5th_pol_yd_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n5th_port_etd_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"n5th_rlane_cd", 		false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"n5th_vvd_cd", 			false,	"",	dfNone,			0,	true,	true, 9);
    				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"n5th_port_etb_dt", 	false,	"",	dfDateYmd,		0,	false,	false);        
    				
    				InitDataProperty(0,	cnt++ ,	dtPopup,		100,daCenter,	true,	"mlt_pod_list_ctnt",	true,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtCombo,		70,	daCenter,	true,	"ts_pln_cfm_sts_cd",	false,	"",	dfNone,			0,	true,	true);
    				InitDataProperty(0,	cnt++ ,	dtData,			150,daLeft,		true,	"ts_rmk",				false,	"",	dfNone,			0,	true,	true, 4000);

    				InitDataProperty(0,	cnt++ ,	dtPopup,		90,	daCenter,	true,	"pln_atch",				false,	"",	dfNone,			0,	true,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			90,	daCenter,	true,	"upd_usr_id",			false,	"",	dfNone,			0,	false,	false);
    				InitDataProperty(0,	cnt++ ,	dtData,			90,	daCenter,	true,	"upd_dt",				false,	"",	dfNone,			0,	false,	false);
    		
					InitDataCombo (0, "ioc_cd", "IN|OUT", "I|O");
					InitDataCombo (0, "ts_pln_cfm_sts_cd", "NO|YES|CANCEL", "N|Y|X");
			        InitDataValid (0, "n1st_vvd_cd", vtEngUpOther, "0123456789");
					InitDataValid (0, "n2nd_vvd_cd", vtEngUpOther, "0123456789");
					InitDataValid (0, "n3rd_vvd_cd", vtEngUpOther, "0123456789");
					InitDataValid (0, "n4th_vvd_cd", vtEngUpOther, "0123456789");
					InitDataValid (0, "n5th_vvd_cd", vtEngUpOther, "0123456789");
    		}
    			break;
    	}
    } 
    
    function sheet1_OnDblClick(sheetObj, row, col){
    	var formObj   = document.form;
    	//조회된 것만 아래시트 조회
    	if(sheetObj.CellValue(row, "ibflag") == "I" || sheetObj.CellValue(row, "ibflag") == "U"){
    		return false;
    	}
    	//sheet2 col hidden
    	hideSheet2Col(sheetObjects[1]);
    	//text 박스에 조회하는 vvd, wk 삽입
    	formObj.txtVVD.value 		= sheetObj.CellValue(row, "vvd_cd");
    	formObj.txtWeek.value 		= formObj.year.value+sheetObj.CellValue(row, "cost_wk");
    	formObj.txtRepTrd.value 	= sheetObj.CellValue(row, "rep_trd_cd");
    	formObj.txtRepSubTrd.value 	= sheetObj.CellValue(row, "rep_sub_trd_cd");
    	formObj.txtRlane.value 		= sheetObj.CellValue(row, "rlane_cd");
    	formObj.txtDir.value 		= sheetObj.CellValue(row, "dir_cd");
    	formObj.txtIrrPort.value 	= sheetObj.CellValue(row, "irr_port_cd");
    	formObj.txtIrrYd.value 		= sheetObj.CellValue(row, "irr_yd_cd");

    	//Detail 시트 조회
    	doActionIBSheet(sheetObj,formObj,SEARCHLIST02);

    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {  
    	var formObj = document.form;
        switch(sheetObj.ColSaveName(Col)) {	               
        	case "vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "rep_trd_cd")   	= "";
					sheetObj.CellValue2(Row, "rep_sub_trd_cd") 	= "";
					sheetObj.CellValue2(Row, "rlane_cd")    	= "";
					sheetObj.CellValue2(Row, "dir_cd")   		= "";
					sheetObj.CellValue2(Row, "cost_wk") 		= "";
					sheetObj.CellValue2(Row, "crr_cd")    		= "";
					sheetObj.CellValue2(Row, "irr_port_cd")    	= "";
					sheetObj.CellValue2(Row, "irr_yd_cd")    	= "";
        		}else if(Value != ""){
            		if (sheetObj.CellValue(Row, "vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
						return false;
        			}
            		//유효한 vvd인지 체크
            		var param = "f_cmd="    + SEARCHLIST05
				      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "vvd_cd");
			    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
		        	var rlaneCdList = ComXml2ComboString( sXml , "rlane_cd" , "rlane_cd" );

					if(rlaneCdList == null || rlaneCdList == "undefined" || rlaneCdList == ""){
    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
    					sheetObj.CellValue2(Row, "rep_trd_cd")   	= "";
    					sheetObj.CellValue2(Row, "rep_sub_trd_cd") 	= "";
    					sheetObj.CellValue2(Row, "rlane_cd")    	= "";
    					sheetObj.CellValue2(Row, "dir_cd")   		= "";
    					sheetObj.CellValue2(Row, "cost_wk") 		= "";
    					sheetObj.CellValue2(Row, "crr_cd")    		= "";
    					sheetObj.CellValue2(Row, "irr_port_cd")    	= "";
    					sheetObj.CellValue2(Row, "irr_yd_cd")    	= "";
    					
    					sheetObj.SelectCell(Row, Col, true, "");
					}else{
						sheetObj.CellEditable(Row, "rlane_cd")  = true;
						sheetObj.InitCellProperty ( Row , "rlane_cd", dtCombo , daCenter , "rlane_cd" , "" , dfNone );
	    	    		sheetObj.InitDataCombo( 0 ,  "rlane_cd" , rlaneCdList[0] , rlaneCdList[1]);
	    	    		sheetObj.SelectCell(Row, "rlane_cd", true, "");
					}
        		}
        		break;
        		
        	case "rlane_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "rep_trd_cd")   	= "";
					sheetObj.CellValue2(Row, "rep_sub_trd_cd") 	= "";
					sheetObj.CellValue2(Row, "dir_cd")   		= "";
					sheetObj.CellValue2(Row, "cost_wk") 		= "";
					sheetObj.CellValue2(Row, "crr_cd")    		= "";
        		}else{
	        		var param = "f_cmd="    + SEARCHLIST03
		      		  + "&vvd_cd="     + sheetObj.CellValue(Row, "vvd_cd")
		      		  + "&rlane_cd=" + sheetObj.CellValue(Row, "rlane_cd") 
		      		  + "&search_tp=1"; //search_tp=1 : rep_trd_cd, rep_sub_trd_cd, dir_cd, cost_wk, crr_cd 조회
				  	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
	                if(sXml != null && sXml != ""){ 
					  	var repTrdCd    = ComGetEtcData(sXml, "rep_trd_cd");
					  	var repSubTrdCd = ComGetEtcData(sXml, "rep_sub_trd_cd");
					  	var dirCd 	 	= ComGetEtcData(sXml, "dir_cd");
					  	var costWk   	= ComGetEtcData(sXml, "cost_wk");
					  	var crrCd 	 	= ComGetEtcData(sXml, "crr_cd");
						sheetObj.CellValue2(Row, "rep_trd_cd") 	 	= repTrdCd;
						sheetObj.CellValue2(Row, "rep_sub_trd_cd") 	= repSubTrdCd;
						sheetObj.CellValue2(Row, "dir_cd") 	 		= dirCd;
						sheetObj.CellValue2(Row, "cost_wk") 		= costWk;
						sheetObj.CellValue2(Row, "crr_cd") 	 		= crrCd;
	                }
        		}
        		break;
        		
        	case "skd_cng_sts_cd":
        		setSkdChangeReason(sheetObj, Row);
        		break;
        	
        		
        	case "del":
        		if(Value == 1){ //삭제 체크하면
        			var dtlSheet = sheetObjects[1];
        			//Plan detail 데이터가 있는데 조회전에 Main row를 지우려고 할 경우
        			if(sheetObj.CellValue(Row, "ts_pln_gid_dtl") == "Y" && dtlSheet.SearchRows < 1){ 
    					ComShowMessage(getMsg("SPC90408"));
    					sheetObj.CellValue(Row, "del") = "0";
        			}else{
            			//Plan detail 데이터 중 Confirm=YES가 남아있는경우
            			for(var i=dtlSheet.HeaderRows; i<dtlSheet.HeaderRows+dtlSheet.RowCount; i++){
            				if(dtlSheet.CellValue(i, "ts_pln_cfm_sts_cd") == "Y"){
            					ComShowMessage(getMsg("SPC90409"));
            					dtlSheet.SelectCell(i, "ts_pln_cfm_sts_cd", true, "");
            					sheetObj.CellValue(Row, "del") = "0";
            					break;
            				}
            			}
        			}
        		}
        		break;
        		
        	case "skd_cng_rsn_nm":
				sheetObj.CellValue(Row, "skd_cng_rsn_cd") = sheetObj.CellValue(Row, "skd_cng_rsn_nm");
        		break;
        	}	
    }
    
    function sheet1_OnClick(sheetObj, row, col) {
    	var colSaveName = sheetObj.ColSaveName(col);
    	switch (colSaveName) {
    	case "usr_rmk":
			sheetObj.CellEditable(row, col) = false;
			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
			sheetObj.CellEditable(row, col) = true;
    		break;	
    	}
    }
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	var formObj   = document.form;
    	//TS Plan 아예 없을 때 Row 추가
    	if(sheetObj.RowCount == 0){
			var mainSheet = sheetObjects[0];
			var selRow = mainSheet.SelectRow;
			var row = sheetObj.DataInsert(-1);
			
			sheetObj.CellValue2(row, "rep_trd_cd") 		= mainSheet.CellValue(selRow, "rep_trd_cd");
			sheetObj.CellValue2(row, "rep_sub_trd_cd") 	= mainSheet.CellValue(selRow, "rep_sub_trd_cd");
			sheetObj.CellValue2(row, "rlane_cd") 		= mainSheet.CellValue(selRow, "rlane_cd");
			sheetObj.CellValue2(row, "dir_cd") 			= mainSheet.CellValue(selRow, "dir_cd");
			sheetObj.CellValue2(row, "vvd_cd") 			= mainSheet.CellValue(selRow, "vvd_cd");
			sheetObj.CellValue2(row, "irr_port_cd") 	= mainSheet.CellValue(selRow, "irr_port_cd");
			sheetObj.CellValue2(row, "irr_yd_cd") 		= mainSheet.CellValue(selRow, "irr_yd_cd");
    	}
    	//Confirm Yes Row는 Cancel만 할 수 있도록
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "ts_pln_cfm_sts_cd") == "Y"){
				sheetObj.CellEditable(i, "del") 			  = false;
				sheetObj.CellEditable(i, "ioc_cd") 			  = false;
				sheetObj.CellEditable(i, "cntr_full_flg") 	  = false;
				sheetObj.CellEditable(i, "cntr_mty_flg") 	  = false;
				sheetObj.CellEditable(i, "mlt_crr_list_ctnt") = false;
				sheetObj.CellEditable(i, "mlt_pol_list_ctnt") = false;
				sheetObj.CellEditable(i, "n1st_vvd_cd") 	  = false;
				sheetObj.CellEditable(i, "n1st_pod_cd") 	  = false;
				sheetObj.CellEditable(i, "n2nd_vvd_cd") 	  = false;
				sheetObj.CellEditable(i, "n2nd_pod_cd") 	  = false;
				sheetObj.CellEditable(i, "n3rd_vvd_cd") 	  = false;
				sheetObj.CellEditable(i, "n3rd_pod_cd") 	  = false;
				sheetObj.CellEditable(i, "n4th_vvd_cd") 	  = false;
				sheetObj.CellEditable(i, "n4th_pod_cd") 	  = false;				
				sheetObj.CellEditable(i, "n5th_vvd_cd") 	  = false;
				sheetObj.CellEditable(i, "mlt_pod_list_ctnt") = false;
				//Confirm이 Y일 때 Plan Confirm Status를 Y,X밖에 선택할 수 없음. 
				sheetObj.CellComboItem(i, "ts_pln_cfm_sts_cd", "YES|CANCEL", "Y|X");

			}
		}
		//조회 해온 데이터에 따라 ColHidden 설정
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "n2nd_port_etb_dt") != ""){ //1번째 TS Port 보임 
				sheetObj.ColHidden("n1st_pod_cd") 		= false;
				sheetObj.ColHidden("n1st_pod_yd_cd") 	= false;
				sheetObj.ColHidden("n2nd_pol_cd") 		= false;
				sheetObj.ColHidden("n2nd_pol_yd_cd") 	= false;
				sheetObj.ColHidden("n2nd_port_etd_dt") 	= false;
				sheetObj.ColHidden("n2nd_rlane_cd") 	= false;
				sheetObj.ColHidden("n2nd_vvd_cd") 		= false;
			}
			if(sheetObj.CellValue(i, "n3rd_port_etb_dt") != ""){ //2번째 TS Port 보임
				sheetObj.ColHidden("n2nd_pod_cd") 		= false;
				sheetObj.ColHidden("n2nd_pod_yd_cd") 	= false;
				sheetObj.ColHidden("n3rd_pol_cd") 		= false;
				sheetObj.ColHidden("n3rd_pol_yd_cd") 	= false;
				sheetObj.ColHidden("n3rd_port_etd_dt") 	= false;
				sheetObj.ColHidden("n3rd_rlane_cd") 	= false;
				sheetObj.ColHidden("n3rd_vvd_cd") 		= false;
			}
			if(sheetObj.CellValue(i, "n4th_port_etb_dt") != ""){ //3번째 TS Port 보임
				sheetObj.ColHidden("n3rd_pod_cd") 		= false;
				sheetObj.ColHidden("n3rd_pod_yd_cd") 	= false;
				sheetObj.ColHidden("n4th_pol_cd") 		= false;
				sheetObj.ColHidden("n4th_pol_yd_cd") 	= false;
				sheetObj.ColHidden("n4th_port_etd_dt") 	= false;
				sheetObj.ColHidden("n4th_rlane_cd") 	= false;
				sheetObj.ColHidden("n4th_vvd_cd") 		= false;
			}
			if(sheetObj.CellValue(i, "n5th_port_etb_dt") != ""){ //4번째 TS Port 보임
				sheetObj.ColHidden("n4th_pod_cd") 		= false;
				sheetObj.ColHidden("n4th_pod_yd_cd") 	= false;
				sheetObj.ColHidden("n5th_pol_cd") 		= false;
				sheetObj.ColHidden("n5th_pol_yd_cd") 	= false;
				sheetObj.ColHidden("n5th_port_etd_dt") 	= false;
				sheetObj.ColHidden("n5th_rlane_cd") 	= false;
				sheetObj.ColHidden("n5th_vvd_cd") 		= false;
			}
		}
		
    }
    
    
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	var formObj   = document.form;
    	//매뉴얼 입력 후 VSK에서 들어왔을 때 파랑색으로 보여줌
    	checkDupRow(sheetObj);
    	//Auto 인것은 삭제 못하도록 함
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "upd_usr_id") == "AUTO"){
				sheetObj.CellEditable(i, "del") = false;
			}
		}
		//Auto로 들어온 것을 저장했다가 VSK에서 삭제했을 때 빨강색으로 보여줌
		for(var j=sheetObj.HeaderRows; j<sheetObj.HeaderRows+sheetObj.RowCount; j++){
			if(sheetObj.CellValue(j, "exist_flg") == "N"){
				sheetObj.RowFontColor(j) = sheetObj.RgbColor(255, 0, 0);
			}
		}
    }
    
    function sheet2_OnChange(sheetObj, Row, Col, Value) {  
    	var formObj = document.form;
    	var colSaveName = sheetObj.ColSaveName(Col);
        switch(sheetObj.ColSaveName(Col)) {	               
        	case "n1st_vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "mlt_pol_list_ctnt")   = "";
					sheetObj.CellValue2(Row, "n1st_port_etd_dt") 	= "";
					sheetObj.CellValue2(Row, "n1st_rlane_cd")    	= "";
					sheetObj.CellValue2(Row, "n1st_port_etb_dt")   	= "";
					sheetObj.CellValue2(Row, "n1st_pod_cd") 		= "";
					sheetObj.CellValue2(Row, "n1st_pod_yd_cd")    	= "";
					sheetObj.CellValue2(Row, "n2nd_pol_cd")    		= "";
        		}else if(Value != ""){
            		if (sheetObj.CellValue(Row, "n1st_vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
						return false;
        			}
            		//유효한 vvd인지 체크
            		var param = "f_cmd="    + SEARCHLIST03
				      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "n1st_vvd_cd")
				      		  + "&search_tp=2"; //search_tp=2 : yd_cd, slan_cd, etd_dt 조회
			    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
	                if(sXml != null && sXml != ""){ 
				    	var ydCd   = ComGetEtcData(sXml, "yd_cd");
				    	var etdDt  = ComGetEtcData(sXml, "etd_dt");
				    	var slanCd = ComGetEtcData(sXml, "slan_cd");
						if(ydCd == "null" || etdDt == "null" || slanCd == "null"){
	    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
	    					sheetObj.CellValue2(Row, "mlt_pol_list_ctnt")   = "";
	    					sheetObj.CellValue2(Row, "n1st_port_etd_dt") 	= "";
	    					sheetObj.CellValue2(Row, "n1st_rlane_cd")    	= "";
	    					sheetObj.CellValue2(Row, "n1st_port_etb_dt")   	= "";
	    					sheetObj.CellValue2(Row, "n1st_pod_cd") 		= "";
	    					sheetObj.CellValue2(Row, "n1st_pod_yd_cd")    	= "";
	    					sheetObj.CellValue2(Row, "n2nd_pol_cd")    		= "";
	    					
	    					sheetObj.SelectCell(Row, Col, true, "");
						}
	                }
        		}
        		break; 
        		
        	case "n2nd_vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "n2nd_pol_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n2nd_port_etd_dt") = "";
					sheetObj.CellValue2(Row, "n2nd_rlane_cd")    = "";
					sheetObj.CellValue2(Row, "n2nd_port_etb_dt") = "";
					
        		}else if(Value != ""){
        			
            		if (sheetObj.CellValue(Row, "n2nd_vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
        				return false;
        			}
            		
            		var polCd = sheetObj.CellValue(Row, "n2nd_pol_cd"); 
    			 	if(polCd == ""){
    					ComShowMessage(getMsg("SPC90405", "1st Port"));
    					sheetObj.SelectCell(Row, Col, true, "");
    					return false;
    			 	}
    			 	//유효한 vvd인지 체크 & 유효한 vvd일때 etd_dt, slan_cd, yd_cd 가져옴
    		    	var param = "f_cmd="    + SEARCHLIST03
    			      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "n2nd_vvd_cd")
    			      		  + "&pol_cd=" 	+ sheetObj.CellValue(Row, "n2nd_pol_cd")
    			      		  + "&search_tp=2"; //search_tp=2 : yd_cd, slan_cd, etd_dt 조회
    		    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
                    if(sXml != null && sXml != ""){ 
	    		    	var ydCd   = ComGetEtcData(sXml, "yd_cd");
	    		    	var etdDt  = ComGetEtcData(sXml, "etd_dt");
	    		    	var slanCd = ComGetEtcData(sXml, "slan_cd");
	    				if(ydCd == "null" || etdDt == "null" || slanCd == "null"){
	    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
	    					sheetObj.CellValue2(Row, "n2nd_pol_yd_cd")   = "";
	    					sheetObj.CellValue2(Row, "n2nd_port_etd_dt") = "";
	    					sheetObj.CellValue2(Row, "n2nd_rlane_cd")    = "";
	    					
	    					sheetObj.SelectCell(Row, Col, true, "");
	    				}else{
	    					var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+Value
							       +"&pol_cd="+sheetObj.CellValue(Row, "n2nd_pol_cd");
	    					window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
	    					
//	    					sheetObj.CellValue2(Row, "n2nd_pol_yd_cd") 	 = ydCd;
//	    					sheetObj.CellValue2(Row, "n2nd_port_etd_dt") = etdDt;
//	    					sheetObj.CellValue2(Row, "n2nd_rlane_cd") 	 = slanCd;
	    				}
                    }
        		}
        		break; 
        	case "n3rd_vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "n3rd_pol_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n3rd_port_etd_dt") = "";
					sheetObj.CellValue2(Row, "n3rd_rlane_cd")    = "";
					sheetObj.CellValue2(Row, "n3rd_port_etb_dt") = "";

					
        		}else if(Value != ""){
        			
            		if (sheetObj.CellValue(Row, "n3rd_vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
        				return false;
        			}
            		
            		var polCd = sheetObj.CellValue(Row, "n3rd_pol_cd"); 
    			 	if(polCd == ""){
    					ComShowMessage(getMsg("SPC90405", "2nd Port"));
    					sheetObj.SelectCell(Row, Col, true, "");
    					return false;
    			 	}
    			 	//유효한 vvd인지 체크 & 유효한 vvd일때 etd_dt, slan_cd, yd_cd 가져옴
    		    	var param = "f_cmd="    + SEARCHLIST03
    			      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "n3rd_vvd_cd")
    			      		  + "&pol_cd=" 	+ sheetObj.CellValue(Row, "n3rd_pol_cd")
    			      		  + "&search_tp=2"; //search_tp=2 : yd_cd, slan_cd, etd_dt 조회
    		    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
                    if(sXml != null && sXml != ""){ 
	    		    	var ydCd   = ComGetEtcData(sXml, "yd_cd");
	    		    	var etdDt  = ComGetEtcData(sXml, "etd_dt");
	    		    	var slanCd = ComGetEtcData(sXml, "slan_cd");
	    				if(ydCd == "null" || etdDt == "null" || slanCd == "null"){
	    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
	    					sheetObj.CellValue2(Row, "n3rd_pol_yd_cd")   = "";
	    					sheetObj.CellValue2(Row, "n3rd_port_etd_dt") = "";
	    					sheetObj.CellValue2(Row, "n3rd_rlane_cd")    = "";
	    					
	    					sheetObj.SelectCell(Row, Col, true, "");
	    				}else{
	    					var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+Value
							       +"&pol_cd="+sheetObj.CellValue(Row, "n3rd_pol_cd");
	    					window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
//	    					sheetObj.CellValue2(Row, "n3rd_pol_yd_cd") 	 = ydCd;
//	    					sheetObj.CellValue2(Row, "n3rd_port_etd_dt") = etdDt;
//	    					sheetObj.CellValue2(Row, "n3rd_rlane_cd") 	 = slanCd;
	    				}
                    }
        		}
        		break; 
        	case "n4th_vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "n4th_pol_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n4th_port_etd_dt") = "";
					sheetObj.CellValue2(Row, "n4th_rlane_cd")    = "";
					sheetObj.CellValue2(Row, "n4th_port_etb_dt") = "";

					
        		}else if(Value != ""){
        			
            		if (sheetObj.CellValue(Row, "n4th_vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
        				return false;
        			}
            		
            		var polCd = sheetObj.CellValue(Row, "n4th_pol_cd"); 
    			 	if(polCd == ""){
    					ComShowMessage(getMsg("SPC90405", "3rd Port"));
    					sheetObj.SelectCell(Row, Col, true, "");
    					return false;
    			 	}
    			 	//유효한 vvd인지 체크 & 유효한 vvd일때 etd_dt, slan_cd, yd_cd 가져옴
    		    	var param = "f_cmd="    + SEARCHLIST03
    			      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "n4th_vvd_cd")
    			      		  + "&pol_cd=" 	+ sheetObj.CellValue(Row, "n4th_pol_cd")
    			      		  + "&search_tp=2"; //search_tp=2 : yd_cd, slan_cd, etd_dt 조회
    		    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
    		    	var ydCd   = ComGetEtcData(sXml, "yd_cd");
    		    	var etdDt  = ComGetEtcData(sXml, "etd_dt");
    		    	var slanCd = ComGetEtcData(sXml, "slan_cd");
                    if(sXml != null && sXml != ""){ 
	    				if(ydCd == "null" || etdDt == "null" || slanCd == "null"){
	    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
	    					sheetObj.CellValue2(Row, "n4th_pol_yd_cd")   = "";
	    					sheetObj.CellValue2(Row, "n4th_port_etd_dt") = "";
	    					sheetObj.CellValue2(Row, "n4th_rlane_cd")    = "";
	    					
	    					sheetObj.SelectCell(Row, Col, true, "");
	    				}else{
	    					var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+Value
							       +"&pol_cd="+sheetObj.CellValue(Row, "n4th_pol_cd");
	    					window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
//	    					sheetObj.CellValue2(Row, "n4th_pol_yd_cd") 	 = ydCd;
//	    					sheetObj.CellValue2(Row, "n4th_port_etd_dt") = etdDt;
//	    					sheetObj.CellValue2(Row, "n4th_rlane_cd") 	 = slanCd;
	    				}
                    }
        		}
        		break; 
        	case "n5th_vvd_cd":
        		if(Value == ""){
					sheetObj.CellValue2(Row, "n5th_pol_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n5th_port_etd_dt") = "";
					sheetObj.CellValue2(Row, "n5th_rlane_cd")    = "";
					sheetObj.CellValue2(Row, "n5th_port_etb_dt") = "";

					
        		}else if(Value != ""){
        			
            		if (sheetObj.CellValue(Row, "n5th_vvd_cd").length != 9) {
        				ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
        				sheetObj.SelectCell(Row, Col, true, "");
        				return false;
        			}
            		
            		var polCd = sheetObj.CellValue(Row, "n5th_pol_cd"); 
    			 	if(polCd == ""){
    					ComShowMessage(getMsg("SPC90405", "4th Port"));
    					sheetObj.SelectCell(Row, Col, true, "");
    					return false;
    			 	}
    			 	//유효한 vvd인지 체크 & 유효한 vvd일때 etd_dt, slan_cd, yd_cd 가져옴
    		    	var param = "f_cmd="    + SEARCHLIST03
    			      		  + "&vvd_cd="  + sheetObj.CellValue(Row, "n5th_vvd_cd")
    			      		  + "&pol_cd=" 	+ sheetObj.CellValue(Row, "n5th_pol_cd")
    			      		  + "&search_tp=2"; //search_tp=2 : yd_cd, slan_cd, etd_dt 조회
    		    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
                    if(sXml != null && sXml != ""){ 
	    		    	var ydCd   = ComGetEtcData(sXml, "yd_cd");
	    		    	var etdDt  = ComGetEtcData(sXml, "etd_dt");
	    		    	var slanCd = ComGetEtcData(sXml, "slan_cd");
	    				if(ydCd == "null" || etdDt == "null" || slanCd == "null"){
	    					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
	    					sheetObj.CellValue2(Row, "n5th_pol_yd_cd")   = "";
	    					sheetObj.CellValue2(Row, "n5th_port_etd_dt") = "";
	    					sheetObj.CellValue2(Row, "n5th_rlane_cd")    = "";
	    					
	    					sheetObj.SelectCell(Row, Col, true, "");
	    				}else{
	    					var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+Value
							       +"&pol_cd="+sheetObj.CellValue(Row, "n5th_pol_cd");
	    					window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
//	    					sheetObj.CellValue2(Row, "n5th_pol_yd_cd") 	 = ydCd;
//	    					sheetObj.CellValue2(Row, "n5th_port_etd_dt") = etdDt;
//	    					sheetObj.CellValue2(Row, "n5th_rlane_cd") 	 = slanCd;
	    				}
                    }
        		}
        		break; 
        	case "mlt_pol_list_ctnt":
        		if(Value == ""){
        			sheetObj.CellValue2(Row, "n1st_port_etd_dt") = "";
					sheetObj.CellValue2(Row, "n1st_rlane_cd") 	 = "";
        		}
        		break;
        	case "n1st_pod_cd":
        		if(Value == ""){
        			sheetObj.CellValue2(Row, "n1st_port_etb_dt") = "";
					sheetObj.CellValue2(Row, "n1st_pod_yd_cd") 	 = "";
					sheetObj.CellValue2(Row, "n2nd_pol_cd") 	 = "";
        		}
        		break;
        	case "n2nd_pod_cd":
        		if(Value == ""){
        			sheetObj.CellValue2(Row, "n2nd_port_etb_dt") = "";
					sheetObj.CellValue2(Row, "n2nd_pod_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n3rd_pol_cd")      = "";
        		}
        		break;
        	case "n3rd_pod_cd":
        		if(Value == ""){
        			sheetObj.CellValue2(Row, "n3rd_port_etb_dt") = "";
					sheetObj.CellValue2(Row, "n3rd_pod_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n4th_pol_cd")      = "";
        		}
        		break;
        	case "n4th_pod_cd":
        		if(Value == ""){
        			sheetObj.CellValue2(Row, "n4th_port_etb_dt") = "";
					sheetObj.CellValue2(Row, "n4th_pod_yd_cd")   = "";
					sheetObj.CellValue2(Row, "n5th_pol_cd")      = "";
        		}
        		break;
        	case "mlt_pod_list_ctnt":
        		if(Value == ""){
    			 	if(sheetObj.CellValue(Row, "n5th_port_etb_dt") != ""){
    			 		sheetObj.CellValue2(Row, "n5th_port_etb_dt") = "";
    			 	}else if(sheetObj.CellValue(Row, "n4th_port_etb_dt") != ""){
    			 		sheetObj.CellValue2(Row, "n4th_port_etb_dt") = "";
    			 	}else if(sheetObj.CellValue(Row, "n3rd_port_etb_dt") != ""){
    			 		sheetObj.CellValue2(Row, "n3rd_port_etb_dt") = "";
    			 	}else if(sheetObj.CellValue(Row, "n2nd_port_etb_dt") != ""){
    			 		sheetObj.CellValue2(Row, "n2nd_port_etb_dt") = "";
    			 	}else if(sheetObj.CellValue(Row, "n1st_port_etb_dt") != ""){
    			 		sheetObj.CellValue2(Row, "n1st_port_etb_dt") = "";
    			 	}
        		}
        		break;	
        }
    }
    
    function sheet2_OnClick(sheetObj, row, col) {
    	var colSaveName = sheetObj.ColSaveName(col);
    	switch (colSaveName) {
    	case "ts_rmk":
			sheetObj.CellEditable(row, col) = false;
			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
			sheetObj.CellEditable(row, col) = true;
    		break;
    	case "pln_atch":
			if(sheetObj.CellValue(row, "ibflag") == "I"){
				ComShowMessage(getMsg("SPC90406"));
			}
    		break;	
    	}
    }
    
    function sheet1_OnPopupClick(sheetObj, Row, Col){
		var colSaveName = sheetObj.ColSaveName(Col);
	 	 switch(colSaveName) {
			 case "irr_port_cd":
				 	var vvd = sheetObj.CellValue(Row, "vvd_cd"); 
				 	if(vvd == ""){
						ComShowMessage(getMsg("SPC13057"));
				 	}else{
		    			var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+vvd;
		    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
				 	}
				 break;
				 
	 	 } 
    }  
    
    function sheet2_OnPopupClick(sheetObj, Row, Col){
		var colSaveName = sheetObj.ColSaveName(Col);
	 	 switch(colSaveName) {
			 case "mlt_pol_list_ctnt":
			 	var vvd = sheetObj.CellValue(Row, "n1st_vvd_cd"); 
			 	if(vvd == ""){
					ComShowMessage(getMsg("SPC13057"));
			 	}else{
	    			var param = "?ui_id=ESM_SPC_0087"
						       +"&targetColume="+colSaveName
						       +"&vvd="+vvd;
	    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
			 		
			 	}
    		  break;
					
			 case "mlt_pod_list_ctnt":
			 	var vvd = ""; 
			 	//마지막 vvd 찾기
			 	if(sheetObj.CellValue(Row, "n5th_vvd_cd") !=  ""){
			 		vvd = sheetObj.CellValue(Row, "n5th_vvd_cd");
			 	}else if(sheetObj.CellValue(Row, "n4th_vvd_cd") != ""){
			 		vvd = sheetObj.CellValue(Row, "n4th_vvd_cd");
			 	}else if(sheetObj.CellValue(Row, "n3rd_vvd_cd") != ""){
			 		vvd = sheetObj.CellValue(Row, "n3rd_vvd_cd");
			 	}else if(sheetObj.CellValue(Row, "n2nd_vvd_cd") != ""){
			 		vvd = sheetObj.CellValue(Row, "n2nd_vvd_cd");
			 	}else if(sheetObj.CellValue(Row, "n1st_vvd_cd") != ""){
			 		vvd = sheetObj.CellValue(Row, "n1st_vvd_cd");
			 	}
			 	if(vvd == ""){
					ComShowMessage(getMsg("SPC13057"));
			 	}else{
	    			var param = "?ui_id=ESM_SPC_0087"
						       +"&targetColume="+colSaveName
						       +"&vvd="+vvd;
					window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
			 	}
				break;
				
			 case "n1st_pod_cd":
				 	var vvd = sheetObj.CellValue(Row, "n1st_vvd_cd"); 
				 	if(vvd == ""){
						ComShowMessage(getMsg("SPC13057"));
				 	}else{
		    			var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+vvd;
		    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
				 		
				 	}
				 break;
				 
			 case "n2nd_pod_cd":
				 	var vvd = sheetObj.CellValue(Row, "n2nd_vvd_cd"); 
				 	if(vvd == ""){
						ComShowMessage(getMsg("SPC13057"));
				 	}else{
		    			var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+vvd;
		    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
				 		
				 	}
				 break;
				 
			 case "n3rd_pod_cd":
				 	var vvd = sheetObj.CellValue(Row, "n3rd_vvd_cd"); 
				 	if(vvd == ""){
						ComShowMessage(getMsg("SPC13057"));
				 	}else{
		    			var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+vvd;
		    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
				 		
				 	}
				 break;
				 
			 case "n4th_pod_cd":
				 	var vvd = sheetObj.CellValue(Row, "n4th_vvd_cd"); 
				 	if(vvd == ""){
						ComShowMessage(getMsg("SPC13057"));
				 	}else{
		    			var param = "?ui_id=ESM_SPC_0087"
							       +"&targetColume="+colSaveName
							       +"&vvd="+vvd;
		    			window.showModalDialog('/hanjin/ESM_SPC_0071.do' + param, window, "scroll:no;status:no;help:no;dialogWidth:"+750+"px;dialogHeight:"+450+"px");
				 		
				 	}
				 break;
				 
			 case "mlt_crr_list_ctnt":
				var param = "?org_ui_id=ESM_SPC_0087"
					       +"&targetColume="+colSaveName
					       +"&loc_cd_tp=R"
					       +"&crr_cd="+sheetObj.CellValue(Row, "mlt_crr_list_ctnt");
				
				ComOpenPopup('/hanjin/ESM_SPC_0121.do' + param, 340,420,"", '1,0,1,1,1,1,1,1', true);
			  break;
			  
			case "pln_atch":
				var repTrdCd 	= sheetObj.CellValue(Row, "rep_trd_cd");
				var repSubTrdCd = sheetObj.CellValue(Row, "rep_sub_trd_cd");
				var rlaneCd	 	= sheetObj.CellValue(Row, "rlane_cd");
				var vvdCd 		= sheetObj.CellValue(Row, "vvd_cd");
				var irrPortCd 	= sheetObj.CellValue(Row, "irr_port_cd");
				var irrYdCd 	= sheetObj.CellValue(Row, "irr_yd_cd");
				var plnSeq 		= sheetObj.CellValue(Row, "pln_seq");

				var url = "ESM_SPC_0088.do?rep_trd_cd="		+repTrdCd
				                        +"&rep_sub_trd_cd="	+repSubTrdCd
				                        +"&rlane_cd="		+rlaneCd
										+"&vvd_cd="			+vvdCd
										+"&irr_port_cd="	+irrPortCd
										+"&irr_yd_cd="		+irrYdCd
										+"&pln_seq="		+plnSeq;
				ComOpenWindowCenter(url, "ESM_SPC_0088", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
			break;
	 	 } 
    }  
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	var sheetObj1 = sheetObjects[1];
    	switch(sAction) {
    		case IBSEARCH:      //조회   
    			if(!validateForm(sheetObj,formObj,sAction))return false;   
    			sheetObj1.RemoveAll();
		    	formObj.txtVVD.value 		= "";
		    	formObj.txtWeek.value 		= "";
		    	formObj.txtRepTrd.value 	= "";
		    	formObj.txtRepSubTrd.value 	= "";
		    	formObj.txtRlane.value 		= "";
		    	formObj.txtDir.value 		= "";
		    	formObj.txtIrrPort.value 	= "";
		    	formObj.txtIrrYd.value 		= "";
		    	
		    	formObj.ts_pln_cfm_sts_cd.value = "All";
		    	
    			formObj.f_cmd.value = SEARCHLIST01;
            	var param = FormQueryString(formObj);
            	var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
				sheetObj.LoadSearchXml(sXml);
				
    			break;
    			
			case IBSAVE:        //위시트 저장
			    if (sheetObj.isDataModified == false){ //수정된 row가 없다면
					   ComShowMessage(getMsg("SPC90142"));
					   return false;
				    }
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(!doActionIBSheet(sheetObj, formObj, "dupVvd")) return false;
				sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
	            formObj.f_cmd.value = MULTI01;
	                                  	
                var sXml = sheetObj.GetSaveXml("ESM_SPC_0087GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj));                    	
                sheetObj.LoadSaveXml( sXml );
                if(sXml != null && sXml != ""){ 
	                if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
	            		ComShowMessage(getMsg("SPC90149"));
	    				doActionIBSheet(sheetObj, formObj, IBSEARCH);
	    			}
                }
                    ComOpenWait(false);
                break; 	
    		
			case "dupVvd":        //위시트 저장 전. User가 매뉴얼 입력하고 저장하기전 이미 AUTO 전송되어온 내역이 있으면 팝업을 띄움
	            formObj.f_cmd.value = SEARCHLIST06;
                var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj));
                if(sXml != null && sXml != ""){ 
	                if(ComGetEtcData(sXml, "vvd_cd") != "null" && ComGetEtcData(sXml, "vvd_cd") != null && ComGetEtcData(sXml, "vvd_cd") != ""){
	    			  	var vvdCd    	= ComGetEtcData(sXml, "vvd_cd");
	    			  	var irrPortCd 	= ComGetEtcData(sXml, "irr_port_cd");
	    			  	var irrYdCd 	= ComGetEtcData(sXml, "irr_yd_cd");
	    			  	var crrCd 	 	= ComGetEtcData(sXml, "crr_cd");
	    			  	
						for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
							if( sheetObj.CellValue(i, "upd_usr_id") != "AUTO" &&
								vvdCd 	  == sheetObj.CellValue(i, "vvd_cd") && 
							    irrPortCd == sheetObj.CellValue(i, "irr_port_cd") && 
							    irrYdCd   == sheetObj.CellValue(i, "irr_yd_cd") && 
							    crrCd     == sheetObj.CellValue(i, "crr_cd")){
								sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
							}
						}
						ComShowMessage(getMsg("SPC90407"));
	    			  	return false;
	                }
                }
                return true;
                break;  
                
			case "dtlSave":        //아래시트 저장
			    if (sheetObj.isDataModified == false){ //수정된 row가 없다면
					   ComShowMessage(getMsg("SPC90142"));
					   return false;
				}
			    
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
	            formObj.f_cmd.value = MULTI02;
	                                  	
                var sXml = sheetObj.GetSaveXml("ESM_SPC_0087GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj));                    	
                sheetObj.LoadSaveXml(sXml);
                if(sXml != null && sXml != ""){ 
	                if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
                		ComShowMessage(getMsg("SPC90149"));
    					doActionIBSheet(sheetObj, formObj, SEARCHLIST02);
	    			}
                }
                    ComOpenWait(false);
                break;  
                
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
			
			case SEARCHLIST02:
		    	var sheetObj1 = sheetObjects[1];
		    	var param = "f_cmd="    		 + SEARCHLIST02
			      		  + "&rep_trd_cd="     	 + formObj.txtRepTrd.value
			      		  + "&rep_sub_trd_cd="   + formObj.txtRepSubTrd.value 
			      		  + "&rlane_cd="      	 + formObj.txtRlane.value 
			      		  + "&vvd_cd="    		 + formObj.txtVVD.value
			      		  + "&irr_port_cd=" 	 + formObj.txtIrrPort.value
			      		  + "&irr_yd_cd="     	 + formObj.txtIrrYd.value
			      		  + "&ts_pln_cfm_sts_cd="+ formObj.ts_pln_cfm_sts_cd.value;
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
				sheetObj1.LoadSearchXml(sXml);
				break;
				
			case "tsAdd":
				if(sheetObj.ColHidden("n1st_pod_cd") == true){ //1번째 TS Port를 추가할 때 
					sheetObj.ColHidden("n1st_pod_cd") 		= false;
					sheetObj.ColHidden("n1st_pod_yd_cd") 	= false;
					sheetObj.ColHidden("n2nd_pol_cd") 		= false;
					sheetObj.ColHidden("n2nd_pol_yd_cd") 	= false;
					sheetObj.ColHidden("n2nd_port_etd_dt") 	= false;
					sheetObj.ColHidden("n2nd_rlane_cd") 	= false;
					sheetObj.ColHidden("n2nd_vvd_cd") 		= false;
					sheetObj.ColHidden("n2nd_port_etb_dt") 	= false;
				}else if(sheetObj.ColHidden("n2nd_pod_cd") == true){ //2번째 TS Port를 추가할 때 
					sheetObj.ColHidden("n2nd_pod_cd") 		= false;
					sheetObj.ColHidden("n2nd_pod_yd_cd") 	= false;
					sheetObj.ColHidden("n3rd_pol_cd") 		= false;
					sheetObj.ColHidden("n3rd_pol_yd_cd") 	= false;
					sheetObj.ColHidden("n3rd_port_etd_dt") 	= false;
					sheetObj.ColHidden("n3rd_rlane_cd") 	= false;
					sheetObj.ColHidden("n3rd_vvd_cd") 		= false;
					sheetObj.ColHidden("n3rd_port_etb_dt") 	= false;
				}else if(sheetObj.ColHidden("n3rd_pod_cd") == true){ //3번째 TS Port를 추가할 때
					sheetObj.ColHidden("n3rd_pod_cd") 		= false;
					sheetObj.ColHidden("n3rd_pod_yd_cd") 	= false;
					sheetObj.ColHidden("n4th_pol_cd") 		= false;
					sheetObj.ColHidden("n4th_pol_yd_cd") 	= false;
					sheetObj.ColHidden("n4th_port_etd_dt") 	= false;
					sheetObj.ColHidden("n4th_rlane_cd") 	= false;
					sheetObj.ColHidden("n4th_vvd_cd") 		= false;
					sheetObj.ColHidden("n4th_port_etb_dt") 	= false;
				}else if(sheetObj.ColHidden("n4th_pod_cd") == true){ //4번째 TS Port를 추가할 때
					sheetObj.ColHidden("n4th_pod_cd") 		= false;
					sheetObj.ColHidden("n4th_pod_yd_cd") 	= false;
					sheetObj.ColHidden("n5th_pol_cd") 		= false;
					sheetObj.ColHidden("n5th_pol_yd_cd") 	= false;
					sheetObj.ColHidden("n5th_port_etd_dt") 	= false;
					sheetObj.ColHidden("n5th_rlane_cd") 	= false;
					sheetObj.ColHidden("n5th_vvd_cd") 		= false;
					sheetObj.ColHidden("n5th_port_etb_dt") 	= false;
				}
				break;
				
			case "tsDel":        
				if(sheetObj.ColHidden("n4th_pod_cd") == false){ //4번째 TS Port를 삭제할 때
					for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
						sheetObj.CellValue2(i, "n4th_pod_cd") 		= "";
						sheetObj.CellValue2(i, "n4th_pod_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n5th_pol_cd") 		= "";
						sheetObj.CellValue2(i, "n5th_pol_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n5th_port_etd_dt") 	= "";
						sheetObj.CellValue2(i, "n5th_rlane_cd") 	= "";
						sheetObj.CellValue2(i, "n5th_vvd_cd") 		= "";
						sheetObj.CellValue2(i, "n5th_port_etb_dt") 	= "";
					}
					sheetObj.ColHidden("n4th_pod_cd") 		= true;
					sheetObj.ColHidden("n4th_pod_yd_cd") 	= true;
					sheetObj.ColHidden("n5th_pol_cd") 		= true;
					sheetObj.ColHidden("n5th_pol_yd_cd") 	= true;
					sheetObj.ColHidden("n5th_port_etd_dt") 	= true;
					sheetObj.ColHidden("n5th_rlane_cd") 	= true;
					sheetObj.ColHidden("n5th_vvd_cd") 		= true;
					sheetObj.ColHidden("n5th_port_etb_dt") 	= true;
				}else if(sheetObj.ColHidden("n3rd_pod_cd") == false){ //3번째 TS Port를 삭제할 때
					for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
						sheetObj.CellValue2(i, "n3rd_pod_cd") 		= "";
						sheetObj.CellValue2(i, "n3rd_pod_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n4th_pol_cd") 		= "";
						sheetObj.CellValue2(i, "n4th_pol_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n4th_port_etd_dt") 	= "";
						sheetObj.CellValue2(i, "n4th_rlane_cd") 	= "";
						sheetObj.CellValue2(i, "n4th_vvd_cd") 		= "";
						sheetObj.CellValue2(i, "n4th_port_etb_dt") 	= "";
					}
					sheetObj.ColHidden("n3rd_pod_cd") 		= true;
					sheetObj.ColHidden("n3rd_pod_yd_cd") 	= true;
					sheetObj.ColHidden("n4th_pol_cd") 		= true;
					sheetObj.ColHidden("n4th_pol_yd_cd") 	= true;
					sheetObj.ColHidden("n4th_port_etd_dt") 	= true;
					sheetObj.ColHidden("n4th_rlane_cd") 	= true;
					sheetObj.ColHidden("n4th_vvd_cd") 		= true;
					sheetObj.ColHidden("n4th_port_etb_dt") 	= true;
					
				}else if(sheetObj.ColHidden("n2nd_pod_cd") == false){ //2번째 TS Port를 삭제할 때
					for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
						sheetObj.CellValue2(i, "n2nd_pod_cd") 		= "";
						sheetObj.CellValue2(i, "n2nd_pod_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n3rd_pol_cd") 		= "";
						sheetObj.CellValue2(i, "n3rd_pol_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n3rd_port_etd_dt") 	= "";
						sheetObj.CellValue2(i, "n3rd_rlane_cd") 	= "";
						sheetObj.CellValue2(i, "n3rd_vvd_cd") 		= "";
						sheetObj.CellValue2(i, "n3rd_port_etb_dt") 	= "";
					}
					sheetObj.ColHidden("n2nd_pod_cd") 		= true;
					sheetObj.ColHidden("n2nd_pod_yd_cd") 	= true;
					sheetObj.ColHidden("n3rd_pol_cd") 		= true;
					sheetObj.ColHidden("n3rd_pol_yd_cd") 	= true;
					sheetObj.ColHidden("n3rd_port_etd_dt") 	= true;
					sheetObj.ColHidden("n3rd_rlane_cd") 	= true;
					sheetObj.ColHidden("n3rd_vvd_cd") 		= true;
					sheetObj.ColHidden("n3rd_port_etb_dt") 	= true;
					
				}else if(sheetObj.ColHidden("n1st_pod_cd") == false){ //1번째 TS Port를 삭제할 때
					for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
						sheetObj.CellValue2(i, "n1st_pod_cd") 		= "";
						sheetObj.CellValue2(i, "n1st_pod_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n2nd_pol_cd") 		= "";
						sheetObj.CellValue2(i, "n2nd_pol_yd_cd") 	= "";
						sheetObj.CellValue2(i, "n2nd_port_etd_dt") 	= "";
						sheetObj.CellValue2(i, "n2nd_rlane_cd") 	= "";
						sheetObj.CellValue2(i, "n2nd_vvd_cd") 		= "";
						sheetObj.CellValue2(i, "n2nd_port_etb_dt") 	= "";
					}
					sheetObj.ColHidden("n1st_pod_cd") 		= true;
					sheetObj.ColHidden("n1st_pod_yd_cd") 	= true;
					sheetObj.ColHidden("n2nd_pol_cd") 		= true;
					sheetObj.ColHidden("n2nd_pol_yd_cd") 	= true;
					sheetObj.ColHidden("n2nd_port_etd_dt") 	= true;
					sheetObj.ColHidden("n2nd_rlane_cd") 	= true;
					sheetObj.ColHidden("n2nd_vvd_cd") 		= true;
					sheetObj.ColHidden("n2nd_port_etb_dt") 	= true;
				}
				
				break;	
			case "rowAdd":
				var mainSheet = sheetObjects[0];
				var selRow = mainSheet.SelectRow;
				var row = sheetObj.DataInsert(-1);
				
				sheetObj.CellValue2(row, "rep_trd_cd") 		= mainSheet.CellValue(selRow, "rep_trd_cd");
				sheetObj.CellValue2(row, "rep_sub_trd_cd") 	= mainSheet.CellValue(selRow, "rep_sub_trd_cd");
				sheetObj.CellValue2(row, "rlane_cd") 		= mainSheet.CellValue(selRow, "rlane_cd");
				sheetObj.CellValue2(row, "dir_cd") 			= mainSheet.CellValue(selRow, "dir_cd");
				sheetObj.CellValue2(row, "vvd_cd") 			= mainSheet.CellValue(selRow, "vvd_cd");
				sheetObj.CellValue2(row, "irr_port_cd") 	= mainSheet.CellValue(selRow, "irr_port_cd");
				sheetObj.CellValue2(row, "irr_yd_cd") 		= mainSheet.CellValue(selRow, "irr_yd_cd");
				
				break;
			case "rowCopy": 	
				//선택한 Row 복사
				var selRow = sheetObj.SelectRow;
				var row = sheetObj.DataInsert();
				
				sheetObj.CellValue2(row, "rep_trd_cd") 			= sheetObj.CellValue(selRow, "rep_trd_cd");
				sheetObj.CellValue2(row, "rep_sub_trd_cd") 		= sheetObj.CellValue(selRow, "rep_sub_trd_cd");
				sheetObj.CellValue2(row, "rlane_cd") 			= sheetObj.CellValue(selRow, "rlane_cd");
				sheetObj.CellValue2(row, "dir_cd") 				= sheetObj.CellValue(selRow, "dir_cd");
				sheetObj.CellValue2(row, "vvd_cd") 				= sheetObj.CellValue(selRow, "vvd_cd");
				sheetObj.CellValue2(row, "irr_port_cd") 		= sheetObj.CellValue(selRow, "irr_port_cd");
				sheetObj.CellValue2(row, "irr_yd_cd") 			= sheetObj.CellValue(selRow, "irr_yd_cd");
				sheetObj.CellValue2(row, "ioc_cd") 				= sheetObj.CellValue(selRow, "ioc_cd");
				sheetObj.CellValue2(row, "cntr_full_flg") 		= sheetObj.CellValue(selRow, "cntr_full_flg");
				sheetObj.CellValue2(row, "cntr_mty_flg") 		= sheetObj.CellValue(selRow, "cntr_mty_flg");
				sheetObj.CellValue2(row, "mlt_pol_list_ctnt") 	= sheetObj.CellValue(selRow, "mlt_pol_list_ctnt");
				
				sheetObj.CellValue2(row, "n1st_port_etd_dt")	= sheetObj.CellValue(selRow, "n1st_port_etd_dt");
				sheetObj.CellValue2(row, "n1st_rlane_cd") 		= sheetObj.CellValue(selRow, "n1st_rlane_cd");
				sheetObj.CellValue2(row, "n1st_vvd_cd") 		= sheetObj.CellValue(selRow, "n1st_vvd_cd");
				sheetObj.CellValue2(row, "n1st_port_etb_dt")	= sheetObj.CellValue(selRow, "n1st_port_etb_dt");
				sheetObj.CellValue2(row, "n1st_pod_cd") 		= sheetObj.CellValue(selRow, "n1st_pod_cd");
				sheetObj.CellValue2(row, "n1st_pod_yd_cd") 		= sheetObj.CellValue(selRow, "n1st_pod_yd_cd");
				sheetObj.CellValue2(row, "n2nd_pol_cd") 		= sheetObj.CellValue(selRow, "n2nd_pol_cd");
				sheetObj.CellValue2(row, "n2nd_pol_yd_cd") 		= sheetObj.CellValue(selRow, "n2nd_pol_yd_cd");
			
				sheetObj.CellValue2(row, "n2nd_port_etd_dt")	= sheetObj.CellValue(selRow, "n2nd_port_etd_dt");
				sheetObj.CellValue2(row, "n2nd_rlane_cd") 		= sheetObj.CellValue(selRow, "n2nd_rlane_cd");
				sheetObj.CellValue2(row, "n2nd_vvd_cd") 		= sheetObj.CellValue(selRow, "n2nd_vvd_cd");
				sheetObj.CellValue2(row, "n2nd_port_etb_dt")	= sheetObj.CellValue(selRow, "n2nd_port_etb_dt");
				sheetObj.CellValue2(row, "n2nd_pod_cd") 		= sheetObj.CellValue(selRow, "n2nd_pod_cd");
				sheetObj.CellValue2(row, "n2nd_pod_yd_cd") 		= sheetObj.CellValue(selRow, "n2nd_pod_yd_cd");
				sheetObj.CellValue2(row, "n3rd_pol_cd") 		= sheetObj.CellValue(selRow, "n3rd_pol_cd");
				sheetObj.CellValue2(row, "n3rd_pol_yd_cd") 		= sheetObj.CellValue(selRow, "n3rd_pol_yd_cd");
				
				sheetObj.CellValue2(row, "n3rd_port_etd_dt")	= sheetObj.CellValue(selRow, "n3rd_port_etd_dt");
				sheetObj.CellValue2(row, "n3rd_rlane_cd") 		= sheetObj.CellValue(selRow, "n3rd_rlane_cd");
				sheetObj.CellValue2(row, "n3rd_vvd_cd") 		= sheetObj.CellValue(selRow, "n3rd_vvd_cd");
				sheetObj.CellValue2(row, "n3rd_port_etb_dt")	= sheetObj.CellValue(selRow, "n3rd_port_etb_dt");
				sheetObj.CellValue2(row, "n3rd_pod_cd") 		= sheetObj.CellValue(selRow, "n3rd_pod_cd");
				sheetObj.CellValue2(row, "n3rd_pod_yd_cd") 		= sheetObj.CellValue(selRow, "n3rd_pod_yd_cd");
				sheetObj.CellValue2(row, "n4th_pol_cd") 		= sheetObj.CellValue(selRow, "n4th_pol_cd");
				sheetObj.CellValue2(row, "n4th_pol_yd_cd") 		= sheetObj.CellValue(selRow, "n4th_pol_yd_cd");
				
				sheetObj.CellValue2(row, "n4th_port_etd_dt")	= sheetObj.CellValue(selRow, "n4th_port_etd_dt");
				sheetObj.CellValue2(row, "n4th_rlane_cd") 		= sheetObj.CellValue(selRow, "n4th_rlane_cd");
				sheetObj.CellValue2(row, "n4th_vvd_cd") 		= sheetObj.CellValue(selRow, "n4th_vvd_cd");
				sheetObj.CellValue2(row, "n4th_port_etb_dt")	= sheetObj.CellValue(selRow, "n4th_port_etb_dt");
				sheetObj.CellValue2(row, "n4th_pod_cd") 		= sheetObj.CellValue(selRow, "n4th_pod_cd");
				sheetObj.CellValue2(row, "n4th_pod_yd_cd") 		= sheetObj.CellValue(selRow, "n4th_pod_yd_cd");
				sheetObj.CellValue2(row, "n5th_pol_cd") 		= sheetObj.CellValue(selRow, "n5th_pol_cd");
				sheetObj.CellValue2(row, "n5th_pol_yd_cd") 		= sheetObj.CellValue(selRow, "n5th_pol_yd_cd");
				
				sheetObj.CellValue2(row, "n5th_port_etd_dt")	= sheetObj.CellValue(selRow, "n5th_port_etd_dt");
				sheetObj.CellValue2(row, "n5th_rlane_cd") 		= sheetObj.CellValue(selRow, "n5th_rlane_cd");
				sheetObj.CellValue2(row, "n5th_vvd_cd") 		= sheetObj.CellValue(selRow, "n5th_vvd_cd");
				sheetObj.CellValue2(row, "n5th_port_etb_dt")	= sheetObj.CellValue(selRow, "n5th_port_etb_dt");
				
				sheetObj.CellValue2(row, "mlt_pod_list_ctnt") 	= sheetObj.CellValue(selRow, "mlt_pod_list_ctnt");
				
				break;
    	}
    }  
   
     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) { 
				case IBSEARCH:      //조회
					if(formObj.vvd.value == "" && formObj.trade.Code == ""){
						ComShowMessage(getMsg("SPC90114", "Trade"));
						formObj.trade.focus();
						return false;
					}
					
					if(formObj.vvd.value == "" && formObj.subtrade.Code == ""){
						ComShowMessage(getMsg("SPC90114", "Sub Trade"));
						formObj.subtrade.focus();
						return false;
					}
					
					if(formObj.vvd.value != "" && formObj.vvd.value.length < 9){
						ComShowCodeMessage("COM12174", "VVD", "9");
						formObj.vvd.focus();
						return false;
					}
					break;
					
                case IBSAVE:
                	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                		if(sheetObj.CellValue(i, "vvd_cd") == ""){
                			ComShowMessage(getMsg("SPC90139", "VVD")); 
                			return false;
                		}
                		if(sheetObj.CellValue(i, "rlane_cd") == ""){
                			ComShowMessage(getMsg("SPC90139", "Lane")); 
                			return false;
                		}
                		if(sheetObj.CellValue(i, "irr_port_cd") == ""){
                			ComShowMessage(getMsg("SPC90139", "IRRE Port")); 
                			return false;
                		}
                	}
                    break;
                    
                case "dtlSave":
                	//plan confirm이 X인데 rmk 없는경우
                	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                		if(sheetObj.CellValue(i, "ts_pln_cfm_sts_cd") == "X" && sheetObj.CellValue(i, "ts_rmk") == ""){
    						ComShowMessage(getMsg("SPC90404")); //In case of Cancel Status, Remark is mandatory item.
                			return false;
                		}
                		if(sheetObj.CellValue(i, "mlt_crr_list_ctnt") == ""){
                			ComShowMessage(getMsg("SPC90139", "Cargo Owner")); 
                			return false;
                		}
                		if(sheetObj.CellValue(i, "mlt_pol_list_ctnt") == ""){
                			ComShowMessage(getMsg("SPC90139", "POL")); 
                			return false;
                		}
                		if(sheetObj.CellValue(i, "mlt_pod_list_ctnt") == ""){
                			ComShowMessage(getMsg("SPC90139", "POD")); 
                			return false;
                		}
                		
                		if(sheetObj.CellValue(i, "n5th_vvd_cd") != ""){
                			if(sheetObj.CellValue(i, "n5th_rlane_cd") == ""){
                    			ComShowMessage(getMsg("SPC90139", "Lane")); 
                    			return false;
                			}
                		}
                		
                		if(sheetObj.CellValue(i, "n4th_vvd_cd") != ""){
                			if(sheetObj.CellValue(i, "n4th_rlane_cd") == ""){
                    			ComShowMessage(getMsg("SPC90139", "Lane")); 
                    			return false;
                			}
                		}
                		
                		if(sheetObj.CellValue(i, "n3rd_vvd_cd") != ""){
                			if(sheetObj.CellValue(i, "n3rd_rlane_cd") == ""){
                    			ComShowMessage(getMsg("SPC90139", "Lane")); 
                    			return false;
                			}
                		}
                		
                		if(sheetObj.CellValue(i, "n2nd_vvd_cd") != ""){
                			if(sheetObj.CellValue(i, "n2nd_rlane_cd") == ""){
                    			ComShowMessage(getMsg("SPC90139", "Lane")); 
                    			return false;
                			}
                		}
                		
                		if(sheetObj.CellValue(i, "n1st_vvd_cd") != ""){
                			if(sheetObj.CellValue(i, "n1st_rlane_cd") == ""){
                    			ComShowMessage(getMsg("SPC90139", "Lane")); 
                    			return false;
                			}
                		}
                	}
                	
                    break;
                    
            } // end switch
        }
        return true;
    }  
    
    function trade_OnChange(comObj,value,text ){
    	var formObj = document.form;
    	if(value == ""){
    		SpcSearchOptionSubTrade("subtrade", true, true);
    		SpcSearchOptionLane("lane");
    	}
		SpcSearchOptionSubTrade("subtrade", true, false, "", "", formObj.trade.Code);		
		SpcSearchOptionLane("lane", true ,true, "", formObj.trade.Code, "", true);	
    }

    function subtrade_OnChange(comObj,value,text ){
    	var formObj = document.form;
    	if(value == ""){
    		SpcSearchOptionLane("lane");
    	}
    	SpcSearchOptionLane("lane", true, false, "" ,formObj.trade.Code, value, true);
    }
    
    function lane_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	
    	var repTrade = comObj.GetText(value,0);
    	var subTrade = comObj.GetText(value,1);
    	comboObjects[0].Code2 = repTrade;
    	comboObjects[1].Code2 = subTrade;
    }
    
    function ts_pln_cfm_sts_cd_OnChange(){
    	var formObj   = document.form;
    	var sheetObj  = sheetObjects[0];
    	//Detail 시트 조회
    	doActionIBSheet(sheetObj,formObj,SEARCHLIST02);
    }  
    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week", false, document.form.year.value);
    }
    
    function hideSheet2Col(sheetObj){
		sheetObj.ColHidden("n2nd_pod_cd") 		= true;
		sheetObj.ColHidden("n2nd_pod_yd_cd") 	= true;
		sheetObj.ColHidden("n3rd_pol_cd") 		= true;
		sheetObj.ColHidden("n3rd_pol_yd_cd") 	= true;
		sheetObj.ColHidden("n3rd_port_etd_dt") 	= true;
		sheetObj.ColHidden("n3rd_rlane_cd") 	= true;
		sheetObj.ColHidden("n3rd_vvd_cd") 		= true;
		sheetObj.ColHidden("n3rd_port_etb_dt") 	= true;
		sheetObj.ColHidden("n3rd_pod_cd") 		= true;
		sheetObj.ColHidden("n3rd_pod_yd_cd") 	= true;
		sheetObj.ColHidden("n4th_pol_cd") 		= true;
		sheetObj.ColHidden("n4th_pol_yd_cd") 	= true;
		sheetObj.ColHidden("n4th_port_etd_dt") 	= true;
		sheetObj.ColHidden("n4th_rlane_cd") 	= true;
		sheetObj.ColHidden("n4th_vvd_cd") 		= true;
		sheetObj.ColHidden("n4th_port_etb_dt") 	= true;
		sheetObj.ColHidden("n4th_pod_cd") 		= true;
		sheetObj.ColHidden("n4th_pod_yd_cd") 	= true;
		sheetObj.ColHidden("n5th_pol_cd") 		= true;
		sheetObj.ColHidden("n5th_pol_yd_cd") 	= true;
		sheetObj.ColHidden("n5th_port_etd_dt") 	= true;
		sheetObj.ColHidden("n5th_rlane_cd") 	= true;
		sheetObj.ColHidden("n5th_vvd_cd") 		= true;
		sheetObj.ColHidden("n5th_port_etb_dt") 	= true;
    }
    
    function setSkdChangeReason(sheetObj, Row){
   		var param = "f_cmd="         + SEARCHLIST04
	  		 	  + "&skd_cng_sts_cd="+sheetObj.CellValue(Row, "skd_cng_sts_cd");
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0087GS.do", param);
        if(sXml != null && sXml != ""){ 
			var code      = " |" + ComGetEtcData(sXml, "code");
			var code_desc = " |" + ComGetEtcData(sXml, "code_desc");
    		sheetObj.InitCellProperty ( Row , "skd_cng_rsn_nm" , dtCombo , daLeft , "skd_cng_rsn_nm" , "" , dfNone );
			sheetObj.CellComboItem(Row, "skd_cng_rsn_nm", code_desc, code);
        }
    }
    
	function checkDupRow(sheetObj){
		sheetObj.SpaceDupCheck = true;
		var cmprCol = "rep_trd_cd|rep_sub_trd_cd|rlane_cd|dir_cd|cost_wk|vvd_cd|crr_cd|irr_port_cd|irr_yd_cd";
		var rtn = sheetObj.ColValueDup(cmprCol, false);
		
		if(rtn != "-1"){
			sheetObj.RowFontColor(rtn) = sheetObj.RgbColor(0, 0, 255);
			ComShowMessage("There are duplicated rows on the sheet.");
		}
	}
	/* 개발자 작업  끝 */