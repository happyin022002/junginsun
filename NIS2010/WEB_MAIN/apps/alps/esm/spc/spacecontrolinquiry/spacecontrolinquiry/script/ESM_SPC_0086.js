/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0086.js
*@FileTitle : Quota Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.19 KSJ
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
     * @class ESM_SPC_0106 : ESM_SPC_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0086() {
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var searchParams = "";
    var rtn; 
    var updDt;
    var vvd;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

    	    case "btn_retrieve":
    	    	
	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
	            
			case "btn_new":
				if(checkModifiedSheet(sheetObjects)) {
					if(ComShowConfirm (getMsg("SPC90001")) != 1) {
						return;
					}
				}
            	//공통함수사용: 화면을 초기화
				resetAll();
				
				SpcSearchOptionTrade("trade", true, true, "", false, true);
		    	initSheetCombo();
				break;
				
    	    case "btn_save":
    	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
    	        break;
    	        
    	    case "btn_rowadd":
   	    		sheetObject.DataInsert();
    	    	break;
    	    	
    	    case "btn_close":
    	    	window.returnValue = "CLOSE";
    	    	self.close();
    	        break;

		} // end switch
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	SpcSearchOptionTrade("trade", true, true, '', false, true);
    	
        var tdisp = "block";
        
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
   
        var sheetResizeFull = true;
		document_onresize();
		
		// Sheet ComboBox 초기화
		initSheetCombo();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
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
	            	// 높이 설정
		    	    //style.height = 100 ;
		    	    style.height = getSheetHeight(17) ;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
					
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 9, 100);
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(5, 0, 0, false);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(false, true, true, true, false,false) ;
		            
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, "DEL|STS|Trade|Lane|VVD", true);
		            
					var cnt = 0;
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   true,    "del",     	false,          "",       dfNone,       0,     true,        true, -1, false, false, "", false);
					InitDataProperty(0, cnt++ , dtHiddenStatus,  50,    daCenter,   true,    "ibflag",  	false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtComboEdit ,    70,    daCenter,   true,    "trd_cd",  	true ,          "",       dfNone,       0,     false,       true );
		            InitDataProperty(0, cnt++ , dtComboEdit ,    90,    daCenter,   true,    "rlane_cd",    true ,          "",       dfNone,       0,     false,       true );
		            InitDataProperty(0, cnt++ , dtData      ,    80,    daCenter,   true,    "vvd",         false,          "",       dfNone,       0,     true,        true );
		            
	                HeadRowHeight  = 10;
	                InitDataValid(0, "vvd", vtEngUpOther, "0123456789");
	            }
                break;
        }
    }
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
			
           case IBSEARCH:      //조회
        	   
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.ReDraw=false;
				sheetObj.RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,trade");
				rtn = sheetObj.GetSearchXml("ESM_SPC_0086GS.do", param);
				
				updDt = getEtcDataFromXml(rtn, "bseDt");
				formObj.upd_dt.value = updDt;
				
				sheetObj.LoadSearchXml(rtn);
				sheetObj.ReDraw=true;
    			
				break;

            case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
				if(ComShowConfirm (getMsg("SPC90030")) != 1) {
					return;
				}
				
				formObj.f_cmd.value = MULTI;
				
				for(i=1; i<sheetObj.RowCount+1; i++){
					if(sheetObj.CellValue(i, "ibflag") != "D")
						sheetObj.CellValue(i, "ibflag") = "I";
				}
				
				var param = SpcFormString(formObj,"f_cmd");				
                var rtn = sheetObj.DoSave("ESM_SPC_0086GS.do",param, -1, false);
                break;
                
           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
              
           case SEARCHLIST01:      //입력된 항차 - 부산 기항여부 확인

        	   formObj.f_cmd.value = SEARCHLIST01;
				
				var param = SpcFormString(formObj,"f_cmd");
				rtn = sheetObj.GetSearchXml("ESM_SPC_0086GS1.do", param + "&vvd=" + vvd);
				var chkVvd = ComGetEtcData(rtn,"isExist");
				
				if(chkVvd == "N"){
					ComShowMessage(getMsg("SPC90136", vvd));
					
					sheetObj.CellValue2(sheetObj.SelectRow, "vvd") = "";
					sheetObj.SelectCell(sheetObj.SelectRow, "vvd");
				}
   			
				break;
        }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction) {
			
		    case IBSAVE:
		    	for(i=1; i<sheetObj.RowCount; i++){
		    		
		    		if(sheetObj.CellValue(i, "trd_cd") == ""){
		    			ComShowMessage(getMsg("SPC90117", "Trade"));
		    			sheetObj.SelectCell(i, "trd_cd");
		    			return false;
		    		}
		    		if(sheetObj.CellValue(i, "rlane_cd") == ""){
		    			ComShowMessage(getMsg("SPC90117", "Lane"));
		    			sheetObj.SelectCell(i, "rlane_cd");
		    			return false;
		    		}
		    		if(sheetObj.CellValue(i, "vvd") == "" && sheetObj.CellValue(i, "ibflag") != "D"){
		    			ComShowMessage(getMsg("SPC90117", "VVD"));
		    			sheetObj.SelectCell(i, "vvd");
		    			return false;
		    		}
		    		
		    		for(j=i+1; j<sheetObj.RowCount + 1; j++){
		    			if(   sheetObj.CellValue(i, "trd_cd")   == sheetObj.CellValue(j, "trd_cd") 
		    			   && sheetObj.CellValue(i, "rlane_cd") == sheetObj.CellValue(j, "rlane_cd") 
		    			   && sheetObj.CellValue(i, "vvd")      == sheetObj.CellValue(j, "vvd") ){
		    				ComShowMessage(getMsg("SPC90135"));
		    				return false;
		    			}
		    		}
		    	}
		    	return true;
		    	break;
		}
		return true;
    }
    
    /**
     * Sheet1 Onchange Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var sName = sheetObj.ColSaveName(Col);
    	var qta_sub = 0;
    	var qta_ttl = 0;

    	switch(sName){
	    	// 노선 변경시 해당하는 Trade / Sub Trade Code 셋팅
	    	case "rlane_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 0, "rlane_cd", Value);
	    		sheetObj.CellValue2(Row, "trd_cd") = text;
	    		break;

	    	// Trade 변경시 Sub Trade / 노선 초기화
	    	case "trd_cd":
//	    		initDataValue_lane();
                break;
                
            // VVD - 부산 기항여부 확인
	    	case "vvd":
	    		if(Value != "" && Value.length < 9){
					ComShowCodeMessage("COM12174", "VVD", "9");
					sheetObj.SelectCell(Row, Col);
					return false;
				}
	    		
	    		vvd = Value;
	    		doActionIBSheet(sheetObj, document.form, SEARCHLIST01);
	    		
	    		break;
    	}
    }
	
	/**
	 * Combo 초기화
	 */
	function initSheetCombo() {
		initSheetCombo_trade();
		initSheetCombo_lane();
	}
	
	/**
	 * Trade Combo 셋팅
	 */
	function initSheetCombo_trade() {
		var sheetObject  = sheetObjects[0];
        
        var rtn = getCodeXmlList("TradeCombo", "isRepTrade=true&del=&isPus=true");
        
        var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
        
        if (arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }
            arrData[1] = conData;
        }
        arrData[0] = " |" + arrData[0];
        arrData[1] = " |" + arrData[1];
        
        sheetObject.InitDataCombo(0, "trd_cd", arrData[1], arrData[0]);
	}
	
	/**
	 * Lane Combo 셋팅
	 */
	function initSheetCombo_lane() {
		var sheetObject  = sheetObjects[0];
        var rtn;
        
       	rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&isPus=true");
        var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t\t|" + arrData[1];
        
       	sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
	}

	/**
	 * Trade 초기값 셋팅
	 */
    function initDataValue_trade(){
     	var sheetObj = document.getElementById("trade");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }

     /**
      * Lane 초기값 셋팅
      */
     function initDataValue_lane(){
     	var sheetObj = document.getElementById("lane");
     	with(sheetObj){
     		Index2 = 0;
     	}
     } 
     
     function getEtcDataFromXml(xml, str){
     	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
     	if(pos < 0) return "";
 		pos = xml.indexOf(">", pos + 1);
 		if(pos < 0) return "";
 		var epos = xml.indexOf("</ETC>", pos + 1);
 		var rtn = "";
 		if(epos < 0){
 			rtn = xml.substring(pos + 1);
 		}
 		else{
 			rtn = xml.substring(pos + 1, epos);
 		}
 		return rtn;
 	}
	/* 개발자 작업  끝 */