/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0111.js
*@FileTitle : Load Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
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
     * @class ESM_SPC_0111 : ESM_SPC_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0111() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var comObjects   = new Array();
    var sheetCnt     = 0;
    var comboCnt     = 0;
    
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
				
				break;
				
    	    case "btn_save":
    	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
    	        break;
    	        
    	    case "btn_rowadd":
   	    		rowAdd();
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
    	for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
    	
        var sheetResizeFull = true;
		document_onresize();
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
	    
		//  화면 로드시 자동조회하되록함.
		//-----------------------------------------------------
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//-----------------------------------------------------
	    
	    sheetObjects[0].ColHidden("sc_no")  = document.form.sc_no.value==""?true:false;
	    sheetObjects[0].ColHidden("rfa_no") = document.form.trade.value!="AES"?true:false;
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
		            MergeSheet = msPrevColumnMerge;
		            
		            Editable = true;
		            
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 9, 100);
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(10, 0, 0, false);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(false, true, true, true, false,false) ;
		            
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, "Code|Name|SC No|RFA#|Flag|L.OFC|Lane|DEL|STS|Sub Trade", true);
		            
					var cnt = 0;
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData        ,  70,    daCenter,   true,    "cust_code"     ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData        ,  180,   daLeft  ,   true,    "cust_nm"       ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData        ,  80,    daCenter,   true,    "sc_no"         ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData        ,  80,    daCenter,   true,    "rfa_no"        ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden      ,  50,    daCenter,   true,    "flag"          ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData        ,  70,    daCenter,   true,    "sls_rgn_ofc_cd",	false,          "",       dfNone,       0,     false,       false, 5);
		            InitDataProperty(0, cnt++ , dtData        ,  70,    daCenter,   true,    "rlane_cd"      ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtDelCheck    ,  30,    daCenter,   true,    "del"           ,	false,          "",       dfNone,       0,     true,        true, -1, false, false, "", false);
					InitDataProperty(0, cnt++ , dtHiddenStatus,  50,    daCenter,   true,    "ibflag"        ,	false,          "",       dfNone,       0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden      ,  80,    daCenter,   true,    "sub_trd_cd"    ,	false,          "",       dfNone,       0,     false,       false);
		            
	                HeadRowHeight  = 10;
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
				
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.ReDraw=false;
				sheetObj.RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,trade,subTrade,lane,ioc,ofc_cd,custcntcd,custseq,fcast_seq,sc_no,rfa_no");
				var rtn = sheetObj.GetSearchXml("ESM_SPC_0111GS.do", param);
				
				sheetObj.LoadSearchXml(rtn);
				sheetObj.ReDraw=true;
    			
				break;

            case IBSAVE:        //저장
            	if (sheetObj.isDataModified == false){
 				   ComShowMessage(getMsg("SPC90142"));
 				   return false;
            	}
            	
            	if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
				if(ComShowConfirm (getMsg("SPC90030")) != 1) {
					return;
				}
				
				formObj.f_cmd.value = MULTI01;
				
				var param = SpcFormString(formObj,"f_cmd,trade,ioc,ofc_cd,custcntcd,custseq,fcast_seq,sc_flg");
				
                var rtn = sheetObj.DoSave("ESM_SPC_0111GS.do",param, -1, false);
                break;
                
           case IBDOWNEXCEL:        //엑셀 다운로드
        	   sheetObj.Down2Excel(-1, false, false, true);
        	   break;
        }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction) {
			
		    case IBSAVE:
		    	var sList = sheetObj.FindStatusRow("U|I");
				var sArr  = sList.split(";");
				
				for ( var i = 0; i < sArr.length - 1; i++) {
					
					if(sheetObj.CellValue(sArr[i], "sls_rgn_ofc_cd") == "") {
						ComShowMessage(getMsg("SPC90139", "L.OFC"));
						sheetObj.CellValue2(sArr[i], "sls_rgn_ofc_cd") = "";
						sheetObj.SelectCell(sArr[i], "sls_rgn_ofc_cd");
						return false;
					} else if(sheetObj.CellValue(sArr[i], "rlane_cd") == "") {
						ComShowMessage(getMsg("SPC90139", "Lane"));
						sheetObj.CellValue2(sArr[i], "rlane_cd") = "";
						sheetObj.SelectCell(sArr[i], "rlane_cd");
						return false;
					}
				}
				
				// 중복 Data 체크
        		// sls_rgn_ofc_cd | rlane_cd
				var dup = sheetObj.ColValueDup("sls_rgn_ofc_cd|rlane_cd");
				
				if(dup != -1) {
					ComShowMessage(getMsg("SPC90135"));
					sheetObj.SelectCell(dup, "sls_rgn_ofc_cd");		// 중복된 행의 Office 에 Focus
					return false;
				}
				
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

    	switch(sName){
	    	// 노선 변경시 해당하는 Sub Trade Code 셋팅
	    	case "rlane_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 1, "rlane_cd", Value);
	    		sheetObj.CellValue2(Row, "sub_trd_cd") = text;
	    		break;
	    	
	    	// 입력된 Office 유효성 검사
	    	case "sls_rgn_ofc_cd":
	    		var val = Value.toUpperCase();
	    		var rtn = getCodeList("Office", "ofc_cd=" + val);
	    		
	    		if(rtn[0] == ""){
	    			ComShowMessage(getMsg("SPC90106", val));
	    			sheetObj.CellValue2(Row, Col) = "";
	    			sheetObj.SelectCell(Row, Col);
	    			return;
	    		} else {
	    			sheetObj.CellValue2(Row, Col) = val;
	    		}
	    		break;
    	}
    }
    
    /**
     * Sheet 최하단에 새로운 Row 추가 및 기본 세팅
     */
    function rowAdd() {
    	var sheetObj = sheetObjects[0];
    	var formObject = document.form;
    	
    	var row = sheetObj.DataInsert(-1);
    	
    	sheetObj.CellValue2(row, "cust_code") = formObject.custcntcd.value+formObject.custseq.value; 
    	sheetObj.CellValue2(row, "cust_nm")   = formObject.cust_nm.value;
    	sheetObj.CellValue2(row, "sc_no")     = formObject.sc_no.value==""?" ":formObject.sc_no.value;
    	sheetObj.CellValue2(row, "rfa_no")    = formObject.rfa_no.value==""?" ":formObject.rfa_no.value;
    	sheetObj.CellValue2(row, "flag")      = "I";
    	
    	sheetObj.SelectCell(row, "sls_rgn_ofc_cd");
    	sheetObj.CellEditable(row, "sls_rgn_ofc_cd")  = true;
    	sheetObj.CellEditable(row, "rlane_cd")        = true;
    	sheetObj.CellBackColor(row, "sls_rgn_ofc_cd") = sheetObj.RgbColor(255,255,128);
    	sheetObj.CellBackColor(row, "rlane_cd")       = sheetObj.RgbColor(255,255,128);
    	
    	sheetObj.InitCellProperty(row, "rlane_cd", dtCombo);
    	
       	var rtn = getCodeXmlList("RevLaneCombo", "del=&ipc=&trdCd="+document.form.trade.value+"&subTrdCd=&isPus=");
       	var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
       	
       	arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t\t|" + arrData[1];
        
    	sheetObj.CellComboItem(row, "rlane_cd", arrData[1], arrData[0], 2);
    }
    
    /*
     * 저장후 호출
     */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    		
    		window.returnValue = "OK";
    		self.close();
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
	/* 개발자 작업  끝 */