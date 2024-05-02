/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_0240.js
*@FileTitle : HJL HANDLING  FEE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
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
     * @class ESD_TRS_0240 : esd_trs_3016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_0240() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObj = sheetObjects[0];
         var form = document.form;
         
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObj,form,IBSEARCH);
					break;
					
					case "btn_excel":
						if( sheetObj.RowCount < 1 ){
							ComShowCodeMessage("TRS90390");
							return ;
						}else{
							sheetObj.Down2Excel(-1);
						}
					break;
					
					case "btn_save":
						doActionIBSheet(sheetObj,form,MULTI01);
						
					break;
					
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
    	var form = document.form;
    	var sheetObj = sheetObjects[0];
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
		initControl();
		//화면 로딩시 기본 조회
		doActionIBSheet(sheetObj,form,IBSEARCH);
    }



	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||HJL\nOffice|SML\nS/P Code|Handling Fee|Handling Fee|Handling Fee|Handling Fee|Effective\nFrom|Creation\nTime|Creation\nUser|Update\nTime|Update\nUser|||||||||";
					var HeadTitle2 = "||HJL\nOffice|SML\nS/P Code|Currency|Cost\nRecovery|Commission|Total|Effective\nFrom|Creation\nTime|Creation\nUser|Update\nTime|Update\nUser|||||||||";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtHidden, 		30, daCenter, 	true,	"chk",				false, "", dfNone, 	0, true, true);			
					InitDataProperty(0, cnt++, dtData, 		   100, daCenter, 	true,	"hjl_ofc_cd", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 		   100, daCenter, 	true,	"vndr_seq", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 	   100, daCenter, 	true,	"curr_cd", 			false, "", dfNone, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		   100, daRight, 	true,	"cost_rcvr_amt", 	false, "", dfInteger, 0, true, true,	3);
					InitDataProperty(0, cnt++, dtData, 		   100, daRight, 	true,	"comm_amt",			false, "", dfInteger, 0, true, true,	3);
					InitDataProperty(0, cnt++, dtData, 		   100, daRight, 	true,	"ttl_amt", 			false, "|cost_rcvr_amt|+|comm_amt|", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 		   100, daCenter, 	true,	"eff_fm_dt", 		false, "", dfUserFormat2, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		   110, daCenter, 	true,	"cre_dt", 			false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 		   150, daLeft, 	true,	"cre_usr_nm", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	   110, daCenter, 	true,	"upd_dt", 			false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 	   100, daLeft, 	true,	"upd_usr_nm", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		75, daCenter, 	true,	"eff_to_dt", 		false, "", dfNone, 	0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		75, daLeft, 	true,	"cre_usr_id", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		75, daLeft, 	true,	"upd_usr_id", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"org_curr_cd", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"org_cost_rcvr_amt",false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"org_comm_amt", 	false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"org_ttl_amt", 		false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"org_eff_fm_dt", 	false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++, dtHidden,		75, daCenter, 	true,	"hndl_fee_his_seq", false, "", dfNone, 	0, false, false);
					InitDataCombo(0, 'curr_cd', " |"+default_currText, " |"+default_currCode);
					InitUserFormat2(0, "eff_fm_dt", "####-##-##", "-" );

				}
				break;

        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:		//조회
			    sheetObj.RemoveAll();
				
				if(formObj.flg_his.checked){
					formObj.f_cmd.value = SEARCH02;
				}else{
					formObj.f_cmd.value = SEARCH01;	
				}
			
	        	var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0240GS.do", sParam);
				if(sXml.length>0){
					sheetObj.LoadSearchXml(sXml);
				}
			break;
			
			case MULTI01:		//저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI01;
					//var sParam =  sheetObj.GetSaveString(false, true, "chk");
					var sParam =  ComGetSaveString(sheetObj, true, false);
					if( sParam == ""){ return;}
					var sXml = sheetObj.GetSaveXml("ESD_TRS_0240GS.do", FormQueryString(formObj) + "&" + sParam, true);	
	    			var vCnt = ComGetEtcData(sXml, "cnt");
					if(vCnt > 0){
						ComShowCodeMessage("TRS90419");
					}else{
						sheetObj.LoadSaveXml(sXml);
					}
					//저장 후 재조회
					doActionIBSheet(sheetObj,form,IBSEARCH);
				}
			break;
				
        }
    }
	
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
   function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case MULTI01:
				if( sheetObj.RowCount("U") < 1 ){
					ComShowCodeMessage("COM130503");
					return false;
				}
				
				//가져온 행을 배열로 반든다.
				var rowCnt = sheetObj.RowCount;
				for (i=0; i<rowCnt; i++){
					if(sheetObj.CellValue(i+2, "hjl_ofc_cd")==""){
						ComShowCodeMessage("COM130201", "HJL Office");
						return false;
					}
					
					if(sheetObj.CellValue(i+2, "eff_fm_dt")==""){
						ComShowCodeMessage("COM130201", "Effective From");
						return false;
					}
					
					if(sheetObj.CellValue(i+2, "eff_fm_dt") < sheetObj.CellValue(i+2, "org_eff_fm_dt")){
						ComShowCodeMessage("TRS90424");
						return false;
					}
				}
			break;
		}
       return true;
	}
    
    
    /* initControl() */
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	axon_event.addListener('keydown',  'ComKeyEnter',   'form');
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);
    }
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
     	    case "engup":
     	        ComKeyOnlyAlphabet('uppernum');
     	        break;
     	}
    }    
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keyup(){
    	
    	var formObj = document.form;
     	obj = event.srcElement;
     	
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
     	    case "engup":
     	    	
     	    break;
     	}
    }     
    
	
    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
     	var elementObj = event.srcElement;
		var formObj = document.form;
		
        //입력Validation 확인 및 마스킹 처리
        //ComChkObjValid(event.srcElement);
    	switch(elementObj.name){ 	    	
    		case "vsl_cd":
    			if(!isNull(elementObj.value)){
    				if(elementObj.maxLength != elementObj.value.length){
    					ComShowCodeMessage("VSK50022");
    					ComAlertFocus(formObj.vsl_cd, "");
    				}
    			}
    		break;
    			
    	}	
    }
	
  //Grid 조회 완료 후 비지니스 로직 정의
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			for(var i=0; i<sheetObj.RowCount;i++){
				if(sheetObj.CellValue(i+2,"hndl_fee_his_seq") != "9999"){
					sheetObj.RowEditable(i+2) = false;
				}
			}
		}
	} 
	
	//Grid 데이터 변경시 비지니스 로직 정의
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var col_nm = sheetObj.ColSaveName(Col);
		
		if (col_nm == "eff_fm_dt") {
			if(isValidDateGrid(Value)){
				if( Value.length == 8 ) {
					return;
				} else {
					sheetObj.CellValue2(Row, "eff_fm_dt") = "";
					return;
				}
			}else{
				sheetObj.CellValue2(Row, "eff_fm_dt") = "";
				return;
			}
		}	
	}

    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }	

   //Office의 Text 변경시
     function fun_officeText() {
     	document.form.ofc_cd.value = document.form.ofc_cd.value.toUpperCase();
     }
     
   //control s/o office code return value.
     function rtn_office_code(obj) {
     	document.form.ofc_cd.value = obj;
     }
     
     /**
     * 유효 날짜 체크(2)
     */
     function isValidDateGrid(date) {
    	var dt = removeBar(date);
     	var year = dt.substring(0,4);
     	var month = dt.substring(4,6);
     	var day = dt.substring(6,8);
     	
 		if(dt.length !=8){
 			ComShowCodeMessage("TRS90070");
     		return false;
 		}

     	if (isDatecheck(year, month, day) ) {
     		return true;
     	} else {
			ComShowCodeMessage("TRS90070");
     		return false;
     	}
     }
     
     /**
     * FORM 날짜 객체의 유효성 체크(2)
     */
     function isValidDateForm(obj) {

    	var dt = removeBar(obj.value);
     	var year = dt.substring(0,4);
     	var month = dt.substring(4,6);
     	var day = dt.substring(6,8);
     	
     	if(dt != ""){
     		if(dt.length !=8){
     			ComShowCodeMessage("TRS90070");
     			obj.value="";
	     		return false;
     		}
     		
	     	if (isDatecheck(year, month, day) ) {
	     		return true;
	     	} else {
	     		obj.value="";
	     		obj.focus();
				ComShowCodeMessage("TRS90070");
	     		return false;
	     	}
     	}
     }
     	 
     /**
     * 유효 날짜 체크(1)
     */
     function isDatecheck( year,month,day ) {
     	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
     		return true;
     	} else {
     		return false;
     	}
     }

     /**
     * 월 체크
     */
     function checkMonth( month ) {
     	var intmonth = parseInt( month , 10 )
     	if( intmonth >= 1  && intmonth <= 12 ) {
     		return true;
     	} else {
     		return false;
     	}
     }

     /**
     * 유효 날짜 체크
     */
     function checkDay( yyyy, mm, dd ) {
     	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
     	var im = parseInt(mm,10) - 1;
     	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
     		monthDD[1] = 29;
     	}
     	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
     		return false;
     	} else {
     		return true;
     	}
     }
     
     /*
     * string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
     */
     function removeBar(str) {
     	var value = "";
     	for ( var i = 0; i < str.length; i++ ) {
     		var ch = str.charAt(i);
     		if ( ch != '-' ) value = value + ch;
     	}
     	return value;
     }
   
     /* 개발자 작업  끝 */