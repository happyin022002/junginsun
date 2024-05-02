/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0467.js
*@FileTitle : Multi Cntr No input
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : Choi Duk Woo
*@LastVersion : 1.0 
* 2014.03.11 Choi Duk Woo
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
     * @extends CTM   
     * @class ees_ctm_0467 : ees_ctm_0467 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0467() {    
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
	  
	/* 공통전역변수 */
    var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var err_msg_lst = new Array();
	err_msg_lst[0] = "All"; 
	err_msg_lst[1] = "POD is different";
	err_msg_lst[2] = "Container is not located in this area";
	err_msg_lst[3] = "Could not find split booking since container is not attached on split booking";
	err_msg_lst[4] = "Previous status is 'VL', You can create only 'VD'!";
	err_msg_lst[5] = "AFTER INPUT BKG NBR,RECOVERY THIS DATA";
	err_msg_lst[6] = "Could not find correct BKG No";
	err_msg_lst[7] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
	err_msg_lst[8] = "[VD] Previous status is not 'VL'. Please request origin office to create VL";
	err_msg_lst[9] = "Mis use in or SOC container";
	err_msg_lst[10] = "Others";
	err_msg_lst[11] = "VGM Updated";
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
				case "btn_Apply": 
					comPopupOK(sheetObject,formObject);
				break;
			  	
				case "btn_Close":  
					window.close();
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
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
		for(i=0;i<sheetObjects.length;i++) { 
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] ); 
			 
            initSheet(sheetObjects[i],i + 1); 
        	//khlee-마지막 환경 설정 함수 추가 
            ComEndConfigSheet(sheetObjects[i]);
		}
		
    	for(i=0; i < 12; i++) {
	      sheetObjects[0].DataInsert(i);
	      sheetObjects[0].CellValue2(i+1, "err_msg") = err_msg_lst[i];
 	    }
		sheetObjects[0].SelectRow = 1;		
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
			case "sheet1":      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 250;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(3, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false)
	
					var HeadTitle = "Seq.|Chk|Error Message";
					  
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,        CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,  false,    "",				false,      "",       dfNone,        0,       false,      false);
					InitDataProperty(0, cnt++ , dtCheckBox, 30,    daCenter,  false,    "check",		false,      "",       dfNone,        0,       true,       true);
					InitDataProperty(0, cnt++ , dtData,     200,   daLeft,  false,    "err_msg",  false,		"",       dfNone,        0,       true,       true);
						
				}
			break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBINSERT:      // 입력
				var lvcnt = 0;
				var lvrow = sheetObj.RowCount;
				if( !isNaN(formObj.row_count.value) ) {
					lvcnt = eval(formObj.row_count.value);
					if( !donumberheck(lvcnt) ) {
						for(i=lvrow; i < lvcnt+lvrow; i++){
							if(sheetObj.RowCount < 300){
								sheetObj.DataInsert(i);
							}else{
								ComShowCodeMessage("CTM30015"); //"Inquiry data exceeds maximum 300 containers."
								formObj.row_count.value = "0";
								break;
							}	
						}
					} else {  
						if(sheetObj.RowCount < 300){
							sheetObj.DataInsert(-1);
							formObj.row_count.value = "1";
						}else{
							ComShowCodeMessage("CTM30015"); //"Inquiry data exceeds maximum 300 containers."
							formObj.row_count.value = "0";
						}
					}
				} else { 
					if(sheetObj.RowCount < 300){
						formObj.row_count.value = "1";
					}else{
						formObj.row_count.value = "0";
					}
				}
			break;
		}
	}
			
	function comPopupOK(sheetObj,formObject) {
		var formObject = document.form;
		var checkRows;
		var rtn_err = "";
		var rows = sheetObj.Rows;
	
		var return_val = formObject.returnval.value;
	  
		checkRows = sheetObj.CheckedRows("check");

		if(checkRows == 0 && sheetObj.RowCount > 0 ) {
			ComShowCodeMessage("CTM30001"); 
			return;
		} else {	
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
					if(err_msg_lst[i-1] == "All"){
						err_msg_lst[i-1] = "";
					}else if(err_msg_lst[i-1] == "VGM Updated"){
						rtn_err = rtn_err + "%" + err_msg_lst[i-1] + "@";
					}else{
						rtn_err = rtn_err + err_msg_lst[i-1] + "@";						
					}
				}
			}
			rtn_err = rtn_err.substr(0, rtn_err.length-1);
		}
		
		if(opener != null) {
			// 일반 팝업인 경우
			opener.document.form.err_msg.value = rtn_err;
		} else {
			// Modal 팝업인 경우
			dialogArguments.document.form.err_msg.value = rtn_err;
		}
		
		window.close();    
	}   
	 	
	/* 개발자 작업  끝 */ 
