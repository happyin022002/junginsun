/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1184.js
*@FileTitle : Manage Interface
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 조창우
*@LastVersion : 1.0
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
     * @class esm_bkg_1184 : esm_bkg_1184 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1184() {
        this.processButtonClick   = processButtonClick;
        this.setSheetObject       = setSheetObject;
        this.loadPage             = loadPage;
        this.initSheet            = initSheet;
        this.initControl          = initControl;
        this.doActionIBSheet      = doActionIBSheet;
        this.setTabObject         = setTabObject;
        this.validateForm         = validateForm;
    }

    /* 개발자 작업    */

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefix ="";
	var intervalId;
	var intervalTime = 3000;
	var processCnt = 0;
	//var eurFlg = "Y";
	
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    
    
    function processButtonClick(){
    	 var sheetObject = sheetObjects[0];
    	 var formObject  = document.form;

    	try{
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    		
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_history":
    				alert("개발중");
    				break;
    			
    			case "btn_upload":
    				doActionIBSheet(sheetObject,formObject,MULTI);
					break;
    			
    			case "btn_calendar": //calender button
    				var cal = new ComCalendarFromTo();
    				cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt, 'yyyy-MM-dd');
    				break;
    			case "btn_DownExcel":
					if ( sheetObject.TotalRows > 0 ) {
						sheetObject.SpeedDown2Excel(-1);
						//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL,"","");
					}
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
    	initControl();
    	sheetObjects[0].SelectCell(1,"vgm_wgt");
    	ComBtnDisable("btn_history");
    }
     

    function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
		axon_event.addListenerForm('beforedeactivate', 'bkg1184_obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',   'bkg1184_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	}

    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;
    	
    	switch(sheetID) {
    		case "t2sheet1":	  //IBSheet1 init
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
    				InitRowInfo( 2, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(29, 5, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);


    				var HeadTitle1 = "|Sel.|Seq.|Booking no.|Container no.|Request|Request|Request|Request|Request|Upload|Upload|Upload|Upload|VGM|VGM|VGM|VGM|VGM|VGM|Submitter|Submitter|Submitter|Reference No.|Reference No.|Reject Reason|Update User|Update Date|xter_sndr_id" ;
    				var HeadTitle2 = "|Sel.|Seq.|Booking no.|Container no.|Seq.|Date|No.|Via|Customer ID|Status|Upload User|Date|Date(GMT)|VGM |Unit|Signature|Method|Verified Date|Determination Date|Name|e-Mail|Phone no.|Booking|S/I|Reject Reason|Update User|Update Date|xter_sndr_id"
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
    				//데이터속성	[	ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,   30,	daCenter,  true,	"ibflag",				false,		  "",	   dfNone,   	0,	 		false ,	   false);
    				InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,  true,	"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
    				InitDataProperty(0, cnt++ , dtSeq,      40,	    daCenter,  true,	"seq",				false,		  "",	   dfNone,   	0,	 		false ,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cntr_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,	"xter_vgm_seq",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"rqst_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"xter_vgm_rqst_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,	"xter_rqst_via_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cust_id",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"vgm_upld_sts_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"upld_usr_id",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"upld_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"upld_gdt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"vgm_wgt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,	"vgm_wgt_ut_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"vgm_vrfy_sig_ctnt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"vgm_mzd_tp_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"vgm_vrfy_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		120,		daCenter,	true,	"vgm_dtmn_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"smt_nm",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		200,		daCenter,	true,	"smt_eml",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"smt_phn_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"xter_bkg_rqst_ref_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"xter_si_ref_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		200,		daLeft,	true,	"rjct_rsn_rmk",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"upd_usr_id",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	true,	"upd_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	true,	"xter_sndr_id",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				
    				style.height = GetSheetHeight(20) ;
    		   }
    			break;
    	}
    }

     
  
    function validateForm(sheetObj,formObj,sAction){
   	 	switch(sAction) {

			case IBSEARCH:// 조회
				if( formObj.bkg_no.value == "" && formObj.f_vvd.value == "" ){
					
						if( formObj.rqst_from_dt.value == "" ){
							ComShowCodeMessage( "COM12114", "Request Date" );
							formObj.rqst_from_dt.focus();
							return false;
						}
						if( formObj.rqst_to_dt.value == "" ){
							ComShowCodeMessage( "COM12114", "Request Date" );
							formObj.rqst_to_dt.focus();
							return false;
						}
						if(!ComIsDate(formObj.rqst_from_dt.value)){
							ComShowCodeMessage( "BKG00651", formObj.rqst_from_dt.value);			
							return false;
						}
						if(!ComIsDate(formObj.rqst_to_dt.value)){
							ComShowCodeMessage( "BKG00651", formObj.rqst_to_dt.value);
							return false;
							
						}
						if (formObj.rqst_from_dt.value != "" && formObj.rqst_to_dt.value != "") {
							if (ComGetDaysBetween(formObj.rqst_from_dt,formObj.rqst_to_dt) < 0) {
								ComShowMessage(msgs['BKG00112']);
								return false;
							} 		
							if (ComGetDaysBetween(formObj.rqst_from_dt.value, formObj.rqst_to_dt.value)>31){
								ComShowMessage(msgs['BKG50469']);
								return false;
							}
						}				 
					
				}
			break;
   	 	}
   	 	return true;
    }
    
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false ;
    	
    	switch (sAction) {
 
	    	case IBSEARCH: // 조회
	    		if(validateForm(sheetObj,formObj,sAction)){
	    		    formObj.f_cmd.value = SEARCHLIST;
	    		    sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
	    		    sheetObj.DoSearch("ESM_BKG_1184GS.do", FormQueryString(formObj));
	    		    ComOpenWait(false);
	    		    
	    		    var bColor = sheetObjects[0].RgbColor(0, 0, 255);
	    			var rColor = sheetObjects[0].RgbColor(255, 0, 0);
	    			var sColor = sheetObjects[0].RgbColor(187, 14, 216);
	    			for ( var i = 2; i < sheetObjects[0].RowCount + 2; i++) {
	    				if (sheetObjects[0].CellValue(i, "vgm_upld_sts_cd") == "R"
	    						|| sheetObjects[0].CellValue(i, "vgm_upld_sts_cd") == "D") {
	    					sheetObjects[0].RowFontColor(i) = rColor;
	    				} else if (sheetObjects[0].CellValue(i, "vgm_upld_sts_cd") == "N"
	    						|| sheetObjects[0].CellValue(i, "vgm_upld_sts_cd") == "P") {
	    					sheetObjects[0].RowFontColor(i) = bColor;
	    				}
	    			}
	    		}
	    		break;
	    	case MULTI:
	    		if(validateForm(sheetObj,formObj,sAction)){
	    		    formObj.f_cmd.value = MULTI;
	    		    sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
						
					var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
					sheetObj.DoSave("ESM_BKG_1184GS.do", "f_cmd=" + MULTI);
					
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					ComOpenWait(false);
	    		}
	    		break;
			
    	}
    	
	}

    
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
//		if ( col == 3 ) {
//			var param = "";
//			var chkBkgNo = sheetObjects[0].CellValue(row, "bkg_no");
//	
//			if ( chkBkgNo != "" ) {					
//				if(ComGetObjValue(document.form.isInquiry) == "Y"){
//					comBkgCallPopBkgDetail(chkBkgNo); 
//				}else
//					ComBkgCall0079(chkBkgNo);				  
//			}
//		}
    }

	function bkg0614_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "rqst_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "rqst_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				event.srcElement.onfocus = new Function("this.select()");
				break;
		}
	}   
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    
    // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    var multi_input_gubun = "";
    function openAddPaste(gubun){
    	multi_input_gubun = gubun;
    	var formObj = document.form;
    	var values = "";
    	if(multi_input_gubun == "bkg_no"){
    		values = formObj.bkg_no.value;
		}else if(multi_input_gubun == "cntr_no"){
			values = formObj.cntr_no.value;
		}
    	var _Width = '400';
		var _Height = '420';
    	var newWin = ComOpenWindow("ESM_BKG_9457.do?bkg_no="+values, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
    }
    
    // Pop UP 에서 입력된 No 를 전달 받는다.
    function addValueNo(multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
    	if(multi_value != ''){
    		if(multi_input_gubun == 'bkg_no'){
    			document.getElementById('bkg_no').value = multi_value;	
    		}else if(multi_input_gubun == 'cntr_no'){
    			document.getElementById('cntr_no').value = multi_value;	
    		}
    	}
	}	
    