/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0066.js
*@FileTitle : Slot Price Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.15 서창열
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
     * @class VOP_VSK_0066 : VOP_VSK_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0066() {
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
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var ydCdsArr = new Array();
 


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      
      var sheetObject1 = sheetObjects[0];
      var sheetObject2 = sheetObjects[1];
      var sheetObject3 = sheetObjects[2];
      var sheetObject4 = sheetObjects[3];
      var sheetObject5 = sheetObjects[4];
      
      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");
 		
         switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
			case "btn_Calculation":
				doActionIBSheet(sheetObject1,formObject,COMMAND01);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
				
			case "btn_New":
				clearAllData(sheetObject1,sheetObject2,sheetObject3,sheetObject4,sheetObject5,formObject);
				break;
				
			case "btns_back":
				with(formObject){
					slt_prc_wrk_yr.value = parseInt(slt_prc_wrk_yr.value)-1;
					sheetObjects[0].CellValue(1,"sheet1_slt_prc_wrk_yr") = slt_prc_wrk_yr.value;
					clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
    			}
				break;
				
			case "btns_next":
				with(formObject){
					slt_prc_wrk_yr.value = parseInt(slt_prc_wrk_yr.value)+1;
					sheetObjects[0].CellValue(1,"sheet1_slt_prc_wrk_yr") = slt_prc_wrk_yr.value;
					clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
    			}
				break;
				
			case "btns_search":
				openLandCdHelp(sheetObject1);
				break;	
				
			case "btns_search02":
				openPfLandTypeCdHelp(sheetObject1);
				break;		
			
			case "btn_Excel":
				sheetObject2.Down2Excel(-1,false);
				sheetObject3.Down2Excel(-1,true);
				sheetObject4.Down2Excel(-1,true);
				sheetObject5.Down2Excel(-1,true);
				break;
				
			case "btn_RowAdd":
				var prefix = "sheet2_";
				var rowIdx2 = 0;

				rowIdx2 = sheetObject2.DataInsert(-1);
				
				sheetObject2.CellEditable(rowIdx2, prefix+"sum_class01") = false;
				sheetObject2.CellEditable(rowIdx2, prefix+"sum_class02") = false;
				sheetObject2.CellEditable(rowIdx2, prefix+"sum_class03") = false;
				sheetObject2.CellEditable(rowIdx2, prefix+"class_avg") = false;
				
				sheetObject2.SelectCell(rowIdx2, prefix+"port_cd", true);
				
				break;
				
			case "btn_RowInsert":
				var prefix = "sheet2_";
				var rowIdx = sheetObject2.SelectRow + sheetObject2.HeaderRows - 1;

				if(rowIdx){
					if(rowIdx > sheetObject2.HeaderRows){
						sheetObject2.DataInsert(sheetObject2.SelectRow);
						sheetObject2.CellEditable(sheetObject2.SelectRow, prefix+"sum_class01") = false;
						sheetObject2.CellEditable(sheetObject2.SelectRow, prefix+"sum_class02") = false;
						sheetObject2.CellEditable(sheetObject2.SelectRow, prefix+"sum_class03") = false;
						sheetObject2.CellEditable(sheetObject2.SelectRow, prefix+"class_avg") = false;
						sheetObject2.SelectCell(sheetObject2.SelectRow, prefix+"port_cd", true);
					}
				}
				
				
				break;
				
			case "btn_RowDelete":
				var rowIdx = sheetObject2.SelectRow + sheetObject2.HeaderRows - 1;
				
				if(rowIdx){
					if(rowIdx > sheetObject2.HeaderRows){
						ComShowCodeMessage('VSK00005');
						ComRowHideDelete(sheetObject2,"sheet2_Sel");
					}
				}
				break	

         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
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
  * IBCombo Object를 배열로 등록
  * param : combo_obj ==> 콤보오브젝트
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */ 
 function setComboObject(combo_obj) {  
     comboObjects[comboCnt++] = combo_obj;  
 }



 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
	 var formObj = document.form;
	 
     for(i=0;i<sheetObjects.length;i++){

         ComConfigSheet(sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);

         ComEndConfigSheet(sheetObjects[i]);

     }
     
     for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k],k+1);
     }
     
     doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0],SEARCH02);
    
  // 현재년도설정
    var today = new Date();
    with(formObj){
    	slt_prc_wrk_yr.value = today.getFullYear();
    	vsl_slan_cd.focus();
    }
    initControl();
    
 }
 
 /**
  * Combo 기본 설정 
  * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  */ 
 function initCombo(comboObj, comboNo) {
     var formObject = document.form
     switch(comboNo) {  
           case 1: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("50");
 				BackColor = "#CCFFFD";
 				FontColor = "#000000";
 				ColBackColor(0) = "#CCFFFD";
 				ColFontColor(0) = "#000000";

  				DropHeight = 160;
  		    	}

  			break;
           case 2: 
               with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left");        
    				SetColWidth("50");
    				BackColor = "#FFFFFF";
    				FontColor = "#000000";
    				ColBackColor(0) = "#FFFFFF";
    				ColFontColor(0) = "#000000";

 				DropHeight = 160;
 		    	}

     		break;
     	
           case 3: 
               with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left");        
    				SetColWidth("50");
    				BackColor = "#FFFFFF";
    				FontColor = "#000000";
    				ColBackColor(0) = "#FFFFFF";
    				ColFontColor(0) = "#000000";

 				DropHeight = 160;
 		    	}

     		break;
  	     }
  	}
 
//조회조건필드인 Lane SVC Type 데이터 조회
 function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction) {

     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

        case IBSEARCH:      // 조회

 			if (sheetObj.id == "sheet1") {				
 				//콤보필드를 초기화시킨다.
 				sComboObj.RemoveAll();
 									
 				formObj.f_cmd.value = SEARCH02;
 				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", FormQueryString(formObj));
 				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));

 				var comboItems = ComGetEtcData(sXml, "vslCls").split("|");
 				formObj.dzndCls.value = " |"+ComGetEtcData(sXml, "dznCls");
 				
 				addComboItem(comboObjects[0],comboItems);
 				addComboItem(comboObjects[1],comboItems);	
				addComboItem(comboObjects[2],comboItems);

 			}
 										
             break;
     }
 }
 
 /**
  * 콤보필드에 데이터를 추가해준다.
  */	
 function addComboItem(comboObj,comboItems) {
	 comboObj.InsertItem(0,"","");
 	for (var i = 0 ; i < comboItems.length ; i++) {
 		var comboItem = comboItems[i].split(",");
 		comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[1]);
 	}   		
 }

 /**
  * 이벤트 컨드롤 정의
  */
function initControl() {
	var formObj = document.form;
 	axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
 	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
 	axon_event.addListenerForm  ('change', 'obj_change' , form);
 	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form);
 	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

 function combo1_OnBlur(comboObj){
    var formObj = document.form;
	var val = comboObjects[0].Text;
	var cnt = comboObjects[0].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[0].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[0].Text = "";
	}else{
		formObj.n1st_vsl_clss_knt.focus();
	}
}

function combo2_OnBlur(comboObj){
	var formObj = document.form;
	var val = comboObjects[1].Text;
	var cnt = comboObjects[1].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[1].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[1].Text = "";
	}else{
		formObj.n2nd_vsl_clss_knt.focus();
	}
}

function combo3_OnBlur(comboObj){
	var formObj = document.form;
	var val = comboObjects[2].Text;
	var cnt = comboObjects[2].GetCount;
	var chkCnt = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObjects[2].GetIndexText(i,0) == val){
			chkCnt++;
		}
	}
	
	if(chkCnt == 0){
		comboObjects[2].Text = "";
	}else{
		formObj.n3rd_vsl_clss_knt.focus();
	}
}
 
 /**
  * KEY PRESS 이벤트
  */
 function obj_keypress() {
     switch(event.srcElement.dataformat){
         case "float":
             //숫자+"."입력하기
             ComKeyOnlyNumber(event.srcElement, ".,");
             break;
         case "eng":
             //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
             ComKeyOnlyAlphabet();
             break;
         case "engdn":
             //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
             ComKeyOnlyAlphabet('lower');
             break;
         case "engup":
             //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
             ComKeyOnlyAlphabet('upper');
             break;
         case "uppernum":
             //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
             ComKeyOnlyAlphabet('uppernum');
             break;    
         default:
             //숫자만입력하기(정수,날짜,시간)
             ComKeyOnlyNumber(event.srcElement);
     }
 } 

 /**
  * 필드 데이타가 CHANGE될 경우 이벤트
  */
 function obj_change(){
 	
 	var formObject = document.form;
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
     var sheetObject1 = sheetObjects[0];
     var prefix1 = "sheet1_";
     /*******************************************************/
 	try {
 		var srcName = window.event.srcElement.getAttribute("name");
         switch(srcName) {
             
         	case "vsl_slan_cd":
         		clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
 	        	var cnt = formObject.vsl_slan_cd.value;
 				cnt = cnt.length;
 	
 				if(cnt == 3){
 					doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
 				}
 				sheetObjects[0].CellValue(1,prefix1+"vsl_slan_cd") = formObject.vsl_slan_cd.value;
         	break;
         	
         	case "pf_svc_tp_cd":
         		clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
 	        	var cnt = formObject.pf_svc_tp_cd.value;
 				cnt = cnt.length;
 	
 				if(cnt == 4){
 					formObject.slt_prc_wrk_yr.focus();
 				}
 				sheetObjects[0].CellValue(1,prefix1+"pf_svc_tp_cd") = formObject.pf_svc_tp_cd.value;

         	break;
         	
         	case "slt_prc_wrk_yr":
         		clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
         		var cnt = formObject.slt_prc_wrk_yr.value;
 				cnt = cnt.length;
 	
 				if(cnt == 4){
 					formObject.bse_qtr_cd.focus();
 				}
 				sheetObjects[0].CellValue(1,prefix1+"slt_prc_wrk_yr") = formObject.slt_prc_wrk_yr.value;
         	break;
         	
         	case "bse_qtr_cd":
         		clearDescData(sheetObjects[0],sheetObjects[1],sheetObjects[2],sheetObjects[3],sheetObjects[4],formObject);
         		formObject.bnk_prc.focus();
         		sheetObjects[0].CellValue(1,prefix1+"bse_qtr_cd") = formObject.bse_qtr_cd.value;
         	break;
         	
         	case "bnk_prc":
         		var cnt = formObject.bnk_prc.value;
 				cnt = cnt.length;
 	
 				if(cnt == 10){
 					comboObjects[0].focus();
 				}
 				sheetObjects[0].CellValue(1,prefix1+"bnk_prc") = formObject.bnk_prc.value;
         	break;
        	
        	case "n1st_vsl_clss_knt":
        		var tempVal = formObject.n1st_vsl_clss_knt.value;
        		var cnt = tempVal.length;
        		
        		if(cnt == 2){
        			comboObjects[1].focus();
        		}
        		sheetObjects[0].CellValue(1,prefix1+"n1st_vsl_clss_knt") = formObject.n1st_vsl_clss_knt.value;
        	break;
        	
        	case "n2nd_vsl_clss_knt":
        		var tempVal = formObject.n2nd_vsl_clss_knt.value;
        		var cnt = tempVal.length;
        		
        		if(cnt == 2){
        			comboObjects[2].focus();
        		}
        		sheetObjects[0].CellValue(1,prefix1+"n2nd_vsl_clss_knt") = formObject.n2nd_vsl_clss_knt.value;

        	break;
        	
        	case "n3rd_vsl_clss_knt":
        		sheetObjects[0].CellValue(1,prefix1+"n3rd_vsl_clss_knt") = formObject.n3rd_vsl_clss_knt.value;

        	break;
                 
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e);
 		}
 	}
 } 
 
 /**
  * onBlur처리 
  * @return
  */
 function obj_blur(){
	 var formObj = document.form;
   	 obj = event.srcElement;
   	 var val = "";
   	 
   	with(formObj){
   		if(obj.name=="seaHrs"){
   			val = obj.value;
   			var rtnVal = Number(calHrsToDay(val));
   			formObj.seaDay.value = Math.round(rtnVal*10)/10;
   			setVoyage(formObj);
   		}else if(obj.name=="maneHrs"){
   			val = obj.value;
   			var rtnVal = Number(calHrsToDay(val));
   			formObj.maneDay.value = Math.round(rtnVal*10)/10;
   			setVoyage(formObj);
   		}else if(obj.name=="portHrs"){
   			val = obj.value;
   			var rtnVal = Number(calHrsToDay(val));
   			formObj.portDay.value = Math.round(rtnVal*10)/10;
   			setVoyage(formObj);
   		}
   	}
 }
 
 /**
  * Duration,Sea Time,Maneuvering,Port Time 시간을 날짜로 변화 
  * @return rtnVal
  */
function calHrsToDay(val){
	var time = Number(val);
	var rtnVal = 0;
	
	rtnVal = time / 24;
	
	return rtnVal;
}

/**
 * Duration,Sea Time,Maneuvering,Port Time의 시간이 바뀌면 해당하는 시간을 R/Voyage에 반영한다 
 * @return rtnVal
 */
function setVoyage(formObj){
	var seaTime = Number(formObj.seaHrs.value);
	var maneTime = Number(formObj.maneHrs.value);
	var portTime = Number(formObj.portHrs.value);
	var voyageTime = 0;
	
	
	voyageTime = seaTime+maneTime+portTime;
	
	var rtnVal = Number(calHrsToDay(voyageTime));
	formObj.durHrs.value = voyageTime;
	formObj.durDay.value = Math.round(rtnVal*10)/10;
	
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
     case "sheet1":      // sheet1 init
         with (sheetObj) {
             // 높이 설정
             style.height = 0;
             // 전체 너비 설정
             SheetWidth = 0;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msNone;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = false;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 1, 1, 10, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(5, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, false, false, true, false, false);

             var HeadTitle1 = "ibflag|vsl_slan_cd|pf_svc_tp_cd|slt_prc_wrk_yr|bse_qtr_cd|bnk_prc|n1st_vsl_clss_cd|n1st_vsl_clss_knt|n2nd_vsl_clss_cd|n2nd_vsl_clss_knt|n3rd_vsl_clss_cd|n3rd_vsl_clss_knt|eventNav";
             var headCount = ComCountHeadTitle(HeadTitle1);
             
             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(headCount, 0, 0, true);

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true);
             
             var prefix = "sheet1_";
             //데이터속성         [ROW, 	COL,  	DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  					KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, 	cnt++ , dtHiddenStatus, 30,  	daCenter, 		false, 		prefix+"ibflag");
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daCenter,  		false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daLeft,  		false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daCenter,  		false,    	prefix+"slt_prc_wrk_yr",    	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daLeft,  		false,    	prefix+"bse_qtr_cd",    		false,          "",      dfNone);
             
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daLeft,  		false,    	prefix+"bnk_prc",    			false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daLeft,  		false,    	prefix+"n1st_vsl_clss_cd",   	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,    		80,    	daLeft,  		false,    	prefix+"n1st_vsl_clss_knt",  	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,   		80,    	daCenter,  		false,    	prefix+"n2nd_vsl_clss_cd",     	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,   		80,    	daCenter,  		false,    	prefix+"n2nd_vsl_clss_knt",     false,          "",      dfNone);
             
             InitDataProperty(0, 	cnt++ , dtData,   		80,    	daCenter,  		false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,   		80,    	daCenter,  		false,    	prefix+"n3rd_vsl_clss_knt",     false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , dtData,   		80,    	daCenter,  		false,    	prefix+"eventNav",     false,          "",      dfNone);
             
             WaitImageVisible = false;

		}
         break;
         
     case "sheet2":      // sheet1 init
         with (sheetObj) {
             // 높이 설정
             //style.height = 300;
             style.height = 0;
             // 전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = true;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 3, 1, 10, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(10, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, false, true, true, false, false);


             var HeadTitle1 = "Port Expense|Port Expense|Port Expense|Port Expense|Port Expense|Port Expense|Port Expense|Port Expense|Port Expense|Port Expense";
             var HeadTitle2 = "|Sel.|VSL Class|VSL Class||||Average||";
             var HeadTitle3 = "||Port Code|TMNL Code||||Average||";

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true);
             InitHeadRow(1, HeadTitle2, true);
             InitHeadRow(2, HeadTitle3, false);

             var prefix = "sheet2_";
             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 			DATAALIGN, COLMERGE, 	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, 	cnt++ , 	dtHiddenStatus, 	30,  		daCenter, 		false, 		prefix+"ibflag");
             InitDataProperty(0, 	cnt++ , 	dtCheckBox,			50,			daCenter,		true,		prefix+"Sel");
             InitDataProperty(0, 	cnt++ , 	dtData,    			120,    	daCenter,  		true,    	prefix+"port_cd",    		false,          "",      dfEngUpKey,		0, 		true,		true,		5,			false,		false);
             InitDataProperty(0, 	cnt++ , 	dtCombo,			80,			daCenter,		true,		prefix+"yd_cd",				false,			"",		 dfNone,			0,      true,      true);
             InitDataProperty(0, 	cnt++ , 	dtAutoSum,    		150,    	daRight,  		false,    	prefix+"sum_class01",    	false,          "",      dfInteger);
             
             InitDataProperty(0, 	cnt++ , 	dtAutoSum,    		150,    	daRight,  		false,    	prefix+"sum_class02",    	false,          "",      dfInteger);
             InitDataProperty(0, 	cnt++ , 	dtAutoSum,    		150,    	daRight,  		false,    	prefix+"sum_class03",    	false,          "",      dfInteger);
             InitDataProperty(0, 	cnt++ , 	dtAutoSum,    		120,    	daRight,  		true,    	prefix+"class_avg",    		false,          "",      dfInteger);
             InitDataProperty(0, 	cnt++ , 	dtHidden,    		0,    		daRight,  		false,    	prefix+"skd_dir_cd",    	false,          "",      dfNone);
             InitDataProperty(0, 	cnt++ , 	dtHidden,    		0,    		daRight,  		false,    	prefix+"clpt_seq",    		false,          "",      dfNone);
             
             CountPosition = "0";
             
             WaitImageVisible = false;

		}
         break;
         
         case "sheet3":      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 //style.height = 180;
            	 style.height = 0;
                 // 전체 너비 설정
                 //SheetWidth = mainTable.clientWidth;
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;
                 
                 var HeadTitle1 = "|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost";
                 var HeadTitle2 = "|Vessel Class||||Total Average";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 8, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false, false);
                 //var LeftHeadTitle = "MFO(Sea)|MFO(MAN)|MFO(Port)|Total MFO|Total Bunker/charge";

                 
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, false);

                 var prefix = "sheet3_";
                 //데이터속성    	[ROW, 	COL,  DATATYPE,   			WIDTH, 		DATAALIGN, 		COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, 	cnt++ , dtHiddenStatus, 	30,  		daCenter, 		false, 		prefix+"ibflag");
                 InitDataProperty(0, 	cnt++ , dtData,    			150,    	daCenter,  		true,    	prefix+"left_header",   false,          "",      dfNone,				0,			true,		true);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		true,    	prefix+"vsl_csl1",   	false,          "",      dfInteger);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		true,    	prefix+"vsl_csl2",   	false,          "",      dfInteger);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		true,    	prefix+"vsl_csl3",    	false,          "",      dfInteger);
                 
                 InitDataProperty(0, 	cnt++ , dtData,    			100,    	daRight,  		true,    	prefix+"ttl_avg",  		false,          "",      dfInteger);
                 
                 
                 CountPosition = "0";
                 
                 WaitImageVisible = false;

			}
             break;
         
         case "sheet4":      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 //style.height = 160;
            	 style.height = 0;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;
                 
                 var HeadTitle1 = "Hire Base|Hire Base|Hire Base|Hire Base|Hire Base|Hire Base";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 10, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false, false);
                 //var LeftHeadTitle = "Declared Capacity|Hire/TEU(Owner)|Hire/TEU(Charter)";

                 

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 //InitHeadColumn(0, LeftHeadTitle);
                 
                 var prefix = "sheet4_";
                 //데이터속성    [   ROW,   COL,  DATATYPE,            WIDTH,     DATAALIGN,    COLMERGE,       SAVENAME,                 KEYFIELD, 	CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, 	cnt++ , dtHiddenStatus, 	30,  		daCenter, 		false, 		prefix+"ibflag");
                 InitDataProperty(0, 	cnt++ , dtData,    			150,    	daCenter,  		true,    	prefix+"left_header",     	false,          "",      dfNone,				0,			true,		true);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl1",  		 false,          "",      dfFloat);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl2",   		false,          "",      dfFloat);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl3",    		false,          "",      dfFloat);
                 
                 InitDataProperty(0, 	cnt++ , dtRadioCheck,    	100,    		daRight,  		false,    	prefix+"vsl_ownr_flg",  	 false,         "",      dfNone);
                 

				 CountPosition = 0;
				 
				 WaitImageVisible = false;
			}
             break;    
              
         case "sheet5":      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 //style.height = 160;
            	 style.height = 0;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;
                 
                 var HeadTitle1 = "Slot Price|Slot Price|Slot Price|Slot Price|Slot Price|Slot Price";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 4, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false, false);
                 //var LeftHeadTitle = "Sub Total|Slot Price(Round)|Slot Price(LEG)";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 //InitHeadColumn(0, LeftHeadTitle);
                 
                 var prefix = "sheet5_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, 	cnt++ , 	dtHiddenStatus, 	30,  		daCenter, 		false, 		prefix+"ibflag");
                 InitDataProperty(0, 	cnt++ , dtData,    			150,    	daCenter,  		true,    	prefix+"left_header",     	false,          "",      dfNone,				0,			true,		true);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl1",   false,          "",      dfFloat, 2);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl2",   false,          "",      dfFloat, 2);
                 InitDataProperty(0, 	cnt++ , dtData,    			200,    	daRight,  		false,    	prefix+"vsl_csl3",    	false,          "",      dfFloat, 2);
                 
                 InitDataProperty(0, 	cnt++ , dtData,    			100,    	daRight,  		false,    	prefix+"slot_sum",   false,          "",      dfFloat,2);
                 

				CountPosition = 0;
				
				WaitImageVisible = false;
			}
             break;
     }
 }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
     	
     	case SEARCH01:
     		
     		formObj.f_cmd.value = SEARCH03;
			var sParam = FormQueryString(formObj);
			var vslSlanCd  = formObj.vsl_slan_cd.value;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);

  		  	var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
  		  	var vslSvcTpCd = ComGetEtcData(sXml, "checkLaneTpCd");
			
			if(vslSlanNm == ""){
				ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
				formObj.vsl_slan_cd.value = "";	
			}else{
				if(vslSvcTpCd == "O"){
					ComShowCodeMessage('VSK00051');
					formObj.vsl_slan_cd.value = "";
					formObj.vsl_slan_cd.focus();
					
				}else{
					formObj.pf_svc_tp_cd.focus();
				}
			}
			
			formObj.pf_svc_tp_cd.value = "";
			

		break;
		
        case IBSEARCH:      //조회
        	if(validateForm(sheetObj,formObj,sAction)){
        		ComOpenWait(true);
	        	formObj.f_cmd.value = SEARCH;
	        	var aryPrefix = new Array("sheet1_", "sheet2_","sheet3_","sheet4_","sheet5_");	//prefix 문자열 배열
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0066GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));				 
				var arrXml = sXml.split("|$$|");
				
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.loadXML(arrXml[0]);
				var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
				
				if(dataNode){
					var totValue = dataNode.value;
					if(totValue > 0){
						
				     	for(var inx=0; inx<arrXml.length; inx++){
							showSheetData(sheetObjects[inx],formObj,arrXml[inx]);
						}
					}
			   }else{
					sheetObj.LoadSearchXml(sXml);
				}
				
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;
				ComOpenWait(false);
        	}
        	 break;
		 case IBSAVE:        //저장
             if(validateForm(sheetObj,formObj,sAction)){
            	 
				//Master Data
            	 var prefix = "sheet1_"
//				sheetObjects[0].CellValue(1,prefix+"ibflag") = "I";
            	sheetObjects[0].RowStatus(1) = "I";
				sheetObjects[0].CellValue(1,prefix+"vsl_slan_cd") = formObj.vsl_slan_cd.value;
				sheetObjects[0].CellValue(1,prefix+"pf_svc_tp_cd") = formObj.pf_svc_tp_cd.value;
				sheetObjects[0].CellValue(1,prefix+"slt_prc_wrk_yr") = formObj.slt_prc_wrk_yr.value;
				sheetObjects[0].CellValue(1,prefix+"bse_qtr_cd") = formObj.bse_qtr_cd.value;
				sheetObjects[0].CellValue(1,prefix+"bnk_prc") = formObj.bnk_prc.value;
				sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd") = comboObjects[0].Text;
				sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
				sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd") = comboObjects[1].Text;
				sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
				sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd") = comboObjects[2].Text;
				sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;
				

				//Port Expense
				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//						sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//					}
					if(sheetObjects[1].RowStatus(i) == "R"){
						sheetObjects[1].RowStatus(i) = "U";
					}
				}
				
				//Bunker Cost
				for(var i=2; i<=sheetObjects[2].RowCount+1; i++){
//					sheetObjects[2].CellValue(i,"sheet3_ibflag") = "U";
					sheetObjects[2].RowStatus(i) = "U";
				}
				
				if(comboObjects[0].Text != ""){
					if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl1") == "0"){
						ComShowCodeMessage('VSK00027', "1st Vessel Class");
						sheetObjects[2].SelectCell(2, "sheet3_vsl_csl1", true);
						return false;
					}
				}
				
				if(comboObjects[1].Text != ""){
					if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl2") == "0"){
						ComShowCodeMessage('VSK00027', "2nd Vessel Class");
						sheetObjects[2].SelectCell(2, "sheet3_vsl_csl2", true);
						return false;
					}
				}
				
				if(comboObjects[2].Text != ""){
					if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl3") == "0"){
						ComShowCodeMessage('VSK00027', "2rd Vessel Class");
						sheetObjects[2].SelectCell(2, "sheet3_vsl_csl3", true);
						return false;
					}
				}

				//Hire/TEU(OWNER) Hire/TEU(Charter) 셋팅
				//sheet4_vsl_ownr_flg
				if(sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") == "1"){
					sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "Y";
					sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "N";
				}else{
					sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "N";
					sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "Y";
				}
				
				//Hire Base
				for(var i=1; i<=sheetObjects[3].RowCount; i++){
//					sheetObjects[3].CellValue(i,"sheet4_ibflag") = "U";
					sheetObjects[3].RowStatus(i) = "U";
				}
				
				//Slot Price
				for(var i=1; i<=sheetObjects[4].RowCount; i++){
//					sheetObjects[4].CellValue(i,"sheet5_ibflag") = "U";
					sheetObjects[4].RowStatus(i) = "U";
				}
				
				formObj.f_cmd.value = COMMAND01;
				var SaveStr = ComGetSaveString(sheetObjects);
	        	var aryPrefix = new Array("sheet1_", "sheet2_","sheet3_","sheet4_","sheet5_");	//prefix 문자열 배열
	        	var sXml = sheetObj.GetSaveXml("VOP_VSK_0066GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				
				
				//Calculation 이후 다시 Save를 하기 위해 
				//모든 그리드의 flag를 재 조정한다
				for(var inx=0; inx<arrXml.length; inx++){
					calShowSheetData(sheetObjects[inx],formObj,arrXml[inx],vslClsCnt);
				}
				
				//Port Expense
				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//						sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//					}
					if(sheetObjects[1].RowStatus(i) == "R"){
						sheetObjects[1].RowStatus(i) = "U";
					}
				}
				
				//Bunker Cost
				for(var i=2; i<=sheetObjects[2].RowCount+1; i++){
//					sheetObjects[2].CellValue(i,"sheet3_ibflag") = "U";
					sheetObjects[2].RowStatus(i) = "U";
				}
				
				//Hire/TEU(OWNER) Hire/TEU(Charter) 셋팅
				//sheet4_vsl_ownr_flg
				if(sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") == "1"){
					sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "Y";
					sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "N";
				}else{
					sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "N";
					sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "Y";
				}
				
				//Hire Base
				for(var i=1; i<=sheetObjects[3].RowCount; i++){
//					sheetObjects[3].CellValue(i,"sheet4_ibflag") = "U";
					sheetObjects[3].RowStatus(i) = "U";
				}
				
				//Slot Price
				for(var i=1; i<=sheetObjects[4].RowCount; i++){
//					sheetObjects[4].CellValue(i,"sheet5_ibflag") = "U";
					sheetObjects[4].RowStatus(i) = "U";
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
	     	   	var SaveStr = ComGetSaveString(sheetObjects);
	     	   	var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
	     	   	var sXml = sheetObj.GetSaveXml("VOP_VSK_0066GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   	
	     	   	if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
	     	    ComOpenWait(false);
             }
             break;

		 case COMMAND01:      // Calculation
				if(validateForm(sheetObj,formObj,sAction)){
					
					//Calculation 클릭시 Vessel Class의 갯수 만큼  출력시
					//화면 조정
					//예)첫번째,두번째  Vessel Class만 입력 시  세번째 Vessel Class에 해당하는 
					//모든 그리드의 헤더만 데이타를 초기화 한다
					var vslClsCnt = 1;
					if(comboObjects[1].Text == ""){
						vslClsCnt = 2;
					}else if(comboObjects[2].Text == ""){
						vslClsCnt = 3;
					}	
					formObj.vslClsCnt.value = vslClsCnt;
					//Master Data
					sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_cd") = comboObjects[0].Text;
					sheetObjects[0].CellValue(1,"sheet1_n1st_vsl_clss_knt") = formObj.n1st_vsl_clss_knt.value;
					sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_cd") = comboObjects[1].Text;
					sheetObjects[0].CellValue(1,"sheet1_n2nd_vsl_clss_knt") = formObj.n2nd_vsl_clss_knt.value;
					sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_cd") = comboObjects[2].Text;
					sheetObjects[0].CellValue(1,"sheet1_n3rd_vsl_clss_knt") = formObj.n3rd_vsl_clss_knt.value;
					
					for(var i=1; i<=sheetObjects[0].RowCount; i++){
//						sheetObjects[0].CellValue(i,"sheet1_ibflag") = "I";
						sheetObjects[0].RowStatus(i) = "I";
					}
					
					//Port Expense
					for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//						if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//							sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//						}
						if(sheetObjects[1].RowStatus(i) == "R"){
							sheetObjects[1].RowStatus(i) = "U";
						}
					}
					
					//Bunker Cost
					//Daily Com.Bunker - 유저가 입력 가능한 Daily Com.Bunker 데이타만 서버 전송
//					sheetObjects[2].CellValue(2,"sheet3_ibflag") = "U";
					sheetObjects[2].RowStatus(2) = "U";
					if(comboObjects[0].Text != ""){
						if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl1") == "0"){
							ComShowCodeMessage('VSK00027', "3rd Vessel Class");
							sheetObjects[2].SelectCell(2, "sheet3_vsl_csl1", true);
							return false;
						}
					}
					
					if(comboObjects[1].Text != ""){
						if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl2") == "0"){
							ComShowCodeMessage('VSK00027', "2nd Vessel Class");
							sheetObjects[2].SelectCell(2, "sheet3_vsl_csl2", true);
							return false;
						}
					}
					
					if(comboObjects[2].Text != ""){
						if(sheetObjects[2].CellValue(2,"sheet3_vsl_csl3") == "0"){
							ComShowCodeMessage('VSK00027', "3rd Vessel Class");
							sheetObjects[2].SelectCell(2, "sheet3_vsl_csl3", true);
							return false;
						}
					}
					
					//Hire/TEU(OWNER) Hire/TEU(Charter) 셋팅
					//sheet4_vsl_ownr_flg
					if(sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") == "1"){
						sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "Y";
						sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "N";
					}else{
						sheetObjects[3].CellValue(2,"sheet4_vsl_ownr_flg") = "N";
						sheetObjects[3].CellValue(3,"sheet4_vsl_ownr_flg") = "Y";
					}
					
					//Hire Base
					for(var i=1; i<=sheetObjects[3].RowCount; i++){
//						sheetObjects[3].CellValue(i,"sheet4_ibflag") = "U";
						sheetObjects[3].RowStatus(i) = "U";
					}
					
					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND01;
					var SaveStr = ComGetSaveString(sheetObjects);
		        	var aryPrefix = new Array("sheet1_", "sheet2_","sheet3_","sheet4_","sheet5_");	//prefix 문자열 배열
		        	var sXml = sheetObj.GetSaveXml("VOP_VSK_0066GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
					
					for(var inx=0; inx<arrXml.length; inx++){
						calShowSheetData(sheetObjects[inx],formObj,arrXml[inx],vslClsCnt);
					}
					ComOpenWait(false);
					
					
				}
				break;
		//TML Code Search	
		case SEARCH03: 
			ComOpenWait(true);
			var loc_cd = formObj.port_cd.value
			formObj.f_cmd.value = SEARCH03;
            var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0066GS.do?loc_cd="+loc_cd, sParam);
			ComOpenWait(false);
			
			return sXml;
			
			break;
     }
 }

 /**
  * Lane Code Help 파일을 오픈한다
  */
 function openLandCdHelp(sheetObj){
 	var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display = "0,0";
    var laneCd = document.form.vsl_slan_cd.value;
 	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);

 }
 
 /**
  * P/F Lane Type Code Help 파일을 오픈한다  
  */
 function openPfLandTypeCdHelp(sheetObj){
 	 var targetObjList = "sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display = "0,0";
	 var laneCd = document.form.vsl_slan_cd.value;
	 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 620, 490, targetObjList, v_display, true);
 }

/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml){
	var prefix = sheetObj.id + "_";
	
	document.all.item("buttonLayer").style.display = "Inline";
	document.all.item("tableLayer").style.display = "Inline";
	document.all.item("excelLayer").style.display = "Inline";
	
	sheetObjects[1].style.height = 302;
	sheetObjects[2].style.height = 180;
	sheetObjects[3].style.height = 82;
	sheetObjects[4].style.height = 82;
	
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);
			
			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

			if(dataNode){
				var totValue = dataNode.value;

				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					
					
					formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					formObj.pf_svc_tp_cd.value = sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
					formObj.slt_prc_wrk_yr.value = sheetObj.CellValue(1,prefix+"slt_prc_wrk_yr");
					formObj.bse_qtr_cd.value = sheetObj.CellValue(1,prefix+"bse_qtr_cd");
					formObj.bnk_prc.value = sheetObj.CellValue(1,prefix+"bnk_prc");
					//formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					setValCls(comboObjects[0],sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd"));
					if(Number(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt")) == 0){
						formObj.n1st_vsl_clss_knt.value = "";
					}else{
						formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					}
					//formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					setValCls(comboObjects[1],sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd"));
					
					if(Number(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt")) == 0){
						formObj.n2nd_vsl_clss_knt.value = "";
					}else{
						formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					}
					//formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					setValCls(comboObjects[2],sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd"));
					
					if(Number(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knta")) == 0){
						formObj.n3rd_vsl_clss_knt.value = "";
					}else{
						formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					}
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					
					var etcdts = ComGetEtcData(sXml, "pfSkd").split("|");
					formObj.durHrs.value = etcdts[0];
					formObj.durDay.value = etcdts[1];
					formObj.seaHrs.value = etcdts[2];
					formObj.seaDay.value = etcdts[3];
					formObj.maneHrs.value = etcdts[4];
					formObj.maneDay.value = etcdts[5];
					formObj.portHrs.value = etcdts[6];
					formObj.portDay.value = etcdts[7];
					//formObj.serviceSpd.value = etcdts[8];
				}
			}

		break;

		case "sheet2":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.InitHeadRow(1, '|Sel.|VSL Class|VSL Class|'+comboObjects[0].Text+'|'+comboObjects[1].Text+'|'+comboObjects[2].Text+'|Average||', true);
			sheetObj.InitHeadRow(2, '||Port Code|TMNL Code|'+formObj.n1st_vsl_clss_knt.value+'|'+formObj.n2nd_vsl_clss_knt.value+'|'+formObj.n3rd_vsl_clss_knt.value+'|Average||', false);
			
			sheetObj.Redraw = true;
			
			sheetObj.style.height = 300;
			document.all.item("buttonLayer").style.display = "Inline";
			document.all.item("tableLayer").style.display = "Inline";
			
			var headCnt = sheetObj.HeaderRows;
			var rowCnt = sheetObj.RowCount;
			var totalCnt = headCnt+rowCnt;
			var idx = 0;
			var rtnIdx = 0;
			var prefix = "sheet2_";
			
			for(var i=headCnt; i<totalCnt; i++){
				sheetObj.CellEditable(i, prefix+"sum_class01") = false;
				sheetObj.CellEditable(i, prefix+"sum_class02") = false;
				sheetObj.CellEditable(i, prefix+"sum_class03") = false;
				sheetObj.CellEditable(i, prefix+"class_avg") = false;
				
			}
			
			for(var i=0; i<sheetObj.RowCount; i++){
				sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
				sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//	    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
				sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
			}
			
		break;
		
		case "sheet3":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.InitHeadRow(0, "|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost", true);
			sheetObj.InitHeadRow(1, '|Vessel Class|'+comboObjects[0].Text+'|'+comboObjects[1].Text+'|'+comboObjects[2].Text+'|Total Average', false);

			sheetObj.Redraw = true;
			
			sheet3Setting();
			
		break;
		
		case "sheet4":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			
			sheetObj.InitCellProperty(1, 2, dtCombo, daCenter, "sheet4_vsl_csl1" , "", dfNone);
			sheetObj.InitCellProperty(1, 3, dtCombo, daCenter, "sheet4_vsl_csl2" , "", dfNone);
			sheetObj.InitCellProperty(1, 4, dtCombo, daCenter, "sheet4_vsl_csl3" , "", dfNone);
			sheetObj.InitCellProperty(1, 5, dtData,  daCenter, "sheet4_vsl_ownr_flg" , "", dfNone);
 			
 			var dzndCls = formObj.dzndCls.value;
			sheetObj.CellComboItem(1, "sheet4_vsl_csl1", dzndCls, dzndCls);
			sheetObj.CellComboItem(1, "sheet4_vsl_csl2", dzndCls, dzndCls);
			sheetObj.CellComboItem(1, "sheet4_vsl_csl3", dzndCls, dzndCls);
			
//			sheetObj.CellValue(1,"sheet4_vsl_csl1") = "";
//			sheetObj.CellValue(1,"sheet4_vsl_csl2") = "";
//			sheetObj.CellValue(1,"sheet4_vsl_csl3") = "";
			
			for(var k=sheetObj.HeaderRows; k<=sheetObj.RowCount; k++){
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl1") = false;
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl2") = false;
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl3") = false;
				
       	 	}
			sheetObj.CellEditable(1, "sheet4_vsl_ownr_flg") = false;
			sheetObj.RowHidden(4) = true;
			sheetObj.RowHidden(5) = true;
			
			sheet4Setting();
			
			
		break;
		
		case "sheet5":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);

			sheetObj.Redraw = true;
			
			 if(parent!=null && typeof parent.syncHeight != 'undefined')
				 parent.syncHeight();//부모프레임에 높이 Sync함수 콜 
			 
			 sheet5Setting();
		break;
		
	}
} 

/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function calShowSheetData(sheetObj, formObj, sXml, vslClsCnt){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);
			
			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

			if(dataNode){
				var totValue = dataNode.value;

				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					
					
					formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					formObj.pf_svc_tp_cd.value = sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
					formObj.slt_prc_wrk_yr.value = sheetObj.CellValue(1,prefix+"slt_prc_wrk_yr");
					formObj.bse_qtr_cd.value = sheetObj.CellValue(1,prefix+"bse_qtr_cd");
					formObj.bnk_prc.value = sheetObj.CellValue(1,prefix+"bnk_prc");
					setValCls(comboObjects[0],sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd"));
					if(Number(sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt")) == 0){
						formObj.n1st_vsl_clss_knt.value = "";
					}else{
						formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					}
					setValCls(comboObjects[1],sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd"));
					
					if(Number(sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt")) == 0){
						formObj.n2nd_vsl_clss_knt.value = "";
					}else{
						formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					}
					setValCls(comboObjects[2],sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd"));
					
					if(Number(sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knta")) == 0){
						formObj.n3rd_vsl_clss_knt.value = "";
					}else{
						formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					}
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					
					var etcdts = ComGetEtcData(sXml, "pfSkd").split("|");
					formObj.durHrs.value = etcdts[0];
					formObj.durDay.value = etcdts[1];
					formObj.seaHrs.value = etcdts[2];
					formObj.seaDay.value = etcdts[3];
					formObj.maneHrs.value = etcdts[4];
					formObj.maneDay.value = etcdts[5];
					formObj.portHrs.value = etcdts[6];
					formObj.portDay.value = etcdts[7];

				}
			}

		break;

		case "sheet2":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.InitHeadRow(1, '|Sel.|VSL Class|VSL Class|'+comboObjects[0].Text+'|'+comboObjects[1].Text+'|'+comboObjects[2].Text+'|Average||', true);
			sheetObj.InitHeadRow(2, '||Port Code|TMNL Code|'+formObj.n1st_vsl_clss_knt.value+'|'+formObj.n2nd_vsl_clss_knt.value+'|'+formObj.n3rd_vsl_clss_knt.value+'|Average||', false);
			
			sheetObj.Redraw = true;
			
			var headCnt = sheetObj.HeaderRows;
			var rowCnt = sheetObj.RowCount;
			var totalCnt = headCnt+rowCnt;
			var idx = 0;
			var rtnIdx = 0;
			var prefix = "sheet2_";
			
			for(var i=headCnt; i<totalCnt; i++){
				sheetObj.CellEditable(i, prefix+"sum_class01") = false;
				sheetObj.CellEditable(i, prefix+"sum_class02") = false;
				sheetObj.CellEditable(i, prefix+"sum_class03") = false;
				sheetObj.CellEditable(i, prefix+"class_avg") = false;
				
			}
			
			for(var i=0; i<sheetObj.RowCount; i++){
				sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
				sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//	    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
				sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
			}
			
		break;
		
		case "sheet3":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.InitHeadRow(0, "|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost|Bunker Cost", true);
			sheetObj.InitHeadRow(1, '|Vessel Class|'+comboObjects[0].Text+'|'+comboObjects[1].Text+'|'+comboObjects[2].Text+'|Total Average', false);
			
			sheetObj.Redraw = true;
			
			sheet3Setting();
			
		break;
		
		case "sheet4":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			
			sheetObj.InitCellProperty(1, 2, dtCombo, daCenter, "sheet4_vsl_csl1" , "", dfNone);
			sheetObj.InitCellProperty(1, 3, dtCombo, daCenter, "sheet4_vsl_csl2" , "", dfNone);
			sheetObj.InitCellProperty(1, 4, dtCombo, daCenter, "sheet4_vsl_csl3" , "", dfNone);
			sheetObj.InitCellProperty(1, 5, dtData,  daCenter, "sheet4_vsl_ownr_flg" , "", dfNone);
 			
 			var dzndCls = formObj.dzndCls.value;
			sheetObj.CellComboItem(1, "sheet4_vsl_csl1", dzndCls, dzndCls);
			sheetObj.CellComboItem(1, "sheet4_vsl_csl2", dzndCls, dzndCls);
			sheetObj.CellComboItem(1, "sheet4_vsl_csl3", dzndCls, dzndCls);
			
			for(var k=sheetObj.HeaderRows; k<=sheetObj.RowCount; k++){
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl1") = false;
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl2") = false;
				sheetObj.CellEditable(k+1, "sheet4_vsl_csl3") = false;
				
       	 	}
			sheetObj.CellEditable(1, "sheet4_vsl_ownr_flg") = false;
			sheetObj.RowHidden(4) = true;
			sheetObj.RowHidden(5) = true;
			
			sheet4Setting();
			
			
		break;
		
		case "sheet5":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);

			sheetObj.Redraw = true;
			
			 sheet5Setting();
		break;
		
	}
} 

function sheet3Setting(){
	 var prefix = "sheet3_";
	 var headerColor = sheetObjects[2].RgbColor(eval("203"),eval("210"),eval("248"));
	 
	 sheetObjects[2].CellBackColor(2, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(2, prefix+"left_header") = false;
	 sheetObjects[2].CellEditable(2, prefix+"ttl_avg") = false;
	 
	 sheetObjects[2].CellBackColor(3, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(3, prefix+"left_header") = false;
	 
	 sheetObjects[2].CellBackColor(4, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(4, prefix+"left_header") = false;
	 
	 sheetObjects[2].CellBackColor(5, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(5, prefix+"left_header") = false;
	 
	 sheetObjects[2].CellBackColor(6, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(6, prefix+"left_header") = false;
	 
	 sheetObjects[2].CellBackColor(7, prefix+"left_header") = headerColor;
	 sheetObjects[2].CellEditable(7, prefix+"left_header") = false;
	 
	 for(var i=3; i<= 7; i++){
		 sheetObjects[2].CellEditable(i, prefix+"vsl_csl1") = false;
		 sheetObjects[2].CellEditable(i, prefix+"vsl_csl2") = false;
		 sheetObjects[2].CellEditable(i, prefix+"vsl_csl3") = false;
		 sheetObjects[2].CellEditable(i, prefix+"ttl_avg") = false;
	 }
	 
}

function sheet4Setting(){
	 var prefix = "sheet4_";
	 var headerColor = sheetObjects[3].RgbColor(eval("203"),eval("210"),eval("248"));
	 
	 sheetObjects[3].CellBackColor(1, prefix+"left_header") = headerColor;
	 sheetObjects[3].CellEditable(1, prefix+"left_header") = false;
	 
	 sheetObjects[3].CellBackColor(2, prefix+"left_header") = headerColor;
	 sheetObjects[3].CellEditable(2, prefix+"left_header") = false;
	 
	 sheetObjects[3].CellBackColor(3, prefix+"left_header") = headerColor;
	 sheetObjects[3].CellEditable(3, prefix+"left_header") = false;
	 
}

function sheet5Setting(){
	 var prefix = "sheet5_";
	 var headerColor = sheetObjects[4].RgbColor(eval("203"),eval("210"),eval("248"));
	 
	 sheetObjects[4].CellBackColor(1, prefix+"left_header") = headerColor;
	 sheetObjects[4].CellEditable(1, prefix+"left_header") = false;
	 
	 sheetObjects[4].CellBackColor(2, prefix+"left_header") = headerColor;
	 sheetObjects[4].CellEditable(2, prefix+"left_header") = false;
	 
	 sheetObjects[4].CellBackColor(3, prefix+"left_header") = headerColor;
	 sheetObjects[4].CellEditable(3, prefix+"left_header") = false;
	 
}

/**
 * SHEET4 그리드 Declared Capacity 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){

	var ydKindCode = ComGetEtcData(xmlStr, "yd_kind");
	var ydNm = ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt = "";
	
	
	if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
		var ydKindCodeArr = ydKindCode.split("|");
		var ydNmArr = ydNm.split("|");
		var ydCnt = ydKindCodeArr.length;
		
		ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		
		sheetObject.CellComboItem(Row, sheetObject.id+"_yd_cd", ydTxt, ydKindCode);

	}
}

/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1,sheetObj2,sheetObj3,sheetObj4,sheetObj5,formObj){
	formObj.vsl_slan_cd.value = "";
	formObj.pf_svc_tp_cd.value = "";
	var today = new Date();
	formObj.slt_prc_wrk_yr.value = today.getFullYear();
	formObj.bse_qtr_cd.value = "1Q";
	formObj.bnk_prc.value = "";
	comboObjects[0].Text = "";
	formObj.n1st_vsl_clss_knt.value = "";
	comboObjects[1].Text = "";
	formObj.n2nd_vsl_clss_knt.value = "";
	comboObjects[2].Text = "";
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.durHrs.value = "";
	formObj.durDay.value = "";
	formObj.seaHrs.value = "";
	formObj.seaDay.value = "";
	formObj.maneHrs.value = "";
	formObj.maneDay.value = "";
	formObj.portHrs.value = "";
	formObj.portDay.value = "";
	

	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	sheetObj3.RemoveAll();
	sheetObj4.RemoveAll();
	sheetObj5.RemoveAll();
	
	sheetObj2.InitHeadRow(1, '|Sel.|VSL Class|VSL Class|'+''+'|'+''+'|'+''+'|Average||', true);
	sheetObj2.InitHeadRow(2, '||Port Code|TMNL Code|'+''+'|'+''+'|'+''+'|Average||', false);
	
	sheetObj3.InitHeadRow(1, '|Vessel Class|'+''+'|'+''+'|'+''+'|Total Average', false);
	
}

/**
 * 조회 조건이 아닌 모든 데이타 초기화.
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearDescData(sheetObj1, sheetObj2, sheetObj3, sheetObj4, sheetObj5, formObj){

	formObj.bnk_prc.value = "";
	comboObjects[0].Text = "";
	formObj.n1st_vsl_clss_knt.value = "";
	comboObjects[1].Text = "";
	formObj.n2nd_vsl_clss_knt.value = "";
	comboObjects[2].Text = "";
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.durHrs.value = "";
	formObj.durDay.value = "";
	formObj.seaHrs.value = "";
	formObj.seaDay.value = "";
	formObj.maneHrs.value = "";
	formObj.maneDay.value = "";
	formObj.portHrs.value = "";
	formObj.portDay.value = "";
	

	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	sheetObj3.RemoveAll();
	sheetObj4.RemoveAll();
	sheetObj5.RemoveAll();
	
	sheetObj2.InitHeadRow(1, '|Sel.|VSL Class|VSL Class|'+''+'|'+''+'|'+''+'|Average||', true);
	sheetObj2.InitHeadRow(2, '||Port Code|TMNL Code|'+''+'|'+''+'|'+''+'|Average||', false);
	
	sheetObj3.InitHeadRow(1, '|Vessel Class|'+''+'|'+''+'|'+''+'|Total Average', false);
	
	//All Check 초기화
	sheetObj2.CheckAll(sheetObj2.id+"_Sel") = 0;
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch(sAction) {
	 	case IBSEARCH:      //조회
	 		if(ComIsNull(formObj.vsl_slan_cd.value)){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
	 		
	 		if(formObj.vsl_slan_cd.value.length < 3){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.pf_svc_tp_cd.value.length < 4){
				ComShowCodeMessage("VSK01018", "[P/F TYPE]");
				formObj.pf_svc_tp_cd.value = "";
				formObj.pf_svc_tp_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.slt_prc_wrk_yr.value)){
				ComShowCodeMessage('VSK00027', "Year");
				formObj.slt_prc_wrk_yr.focus()
				return false;
			}
			
			if(formObj.slt_prc_wrk_yr.value.length < 4){
				ComShowCodeMessage('VSK00027', "Year");
				var today = new Date();
				formObj.slt_prc_wrk_yr.value = today.getFullYear();
				formObj.slt_prc_wrk_yr.focus();
				
				return false;
			}
		break;
		
	 	case IBSAVE:
	 		if(ComIsNull(formObj.vsl_slan_cd.value)){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
	 		
	 		if(formObj.vsl_slan_cd.value.length < 3){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.pf_svc_tp_cd.value.length < 4){
				ComShowCodeMessage("VSK01018", "[P/F TYPE]");
				formObj.pf_svc_tp_cd.value = "";
				formObj.pf_svc_tp_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.slt_prc_wrk_yr.value)){
				ComShowCodeMessage('VSK00027', "Year");
				formObj.slt_prc_wrk_yr.focus()
				return false;
			}
			
			if(formObj.slt_prc_wrk_yr.value.length < 4){
				ComShowCodeMessage('VSK00027', "Year");
				var today = new Date();
				formObj.slt_prc_wrk_yr.value = today.getFullYear();
				formObj.slt_prc_wrk_yr.focus();
				
				return false;
			}
			
			var bnkPrc = formObj.bnk_prc.value;
			if(bnkPrc < 0){
				ComShowCodeMessage("VSK01018", "[Bunker Price]");
				formObj.bnk_prc.value = "0";
				formObj.bnk_prc.focus();
			}
			
			var vslCsl1 = comboObjects[0].Text;
			var vslCsl2 = comboObjects[1].Text;
			var vslCsl3 = comboObjects[2].Text;
			if((vslCsl1 == "" || vslCsl1 == "0")){
				ComShowCodeMessage('VSK00027', "1st Vessel Class");
				comboObjects[0].focus();
				return false;
			}
			
			var vslCslCnt1 = formObj.n1st_vsl_clss_knt.value;
			var vslCslCnt2 = formObj.n2nd_vsl_clss_knt.value;
			var vslCslCnt3 = formObj.n3rd_vsl_clss_knt.value;
			if(vslCsl1 != ""){
				if(vslCslCnt1 == "" || parseInt(vslCslCnt1) == 0){
					ComShowCodeMessage('VSK00027', "1st Vessel Class");
					formObj.n1st_vsl_clss_knt.focus();
					return false;
				}
			}
			
			if(vslCsl2 != ""){
				if(vslCslCnt2 == "" || parseInt(vslCslCnt2) == 0){
					ComShowCodeMessage("VSK01018", "[Vsl Class 2]");
					formObj.n2nd_vsl_clss_knt.focus();
					return false;
				}
			}
			
			if(vslCsl3 != ""){
				if(vslCslCnt3 == "" || parseInt(vslCslCnt3) == 0){
					ComShowCodeMessage("VSK01018", "[Vsl Class 3]");
					formObj.n3rd_vsl_clss_knt.focus();
					return false;
				}
			}
			
			//Hire Base 
			if(comboObjects[0].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl1") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 1]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl1", true);
					return false;
				}
			}
			
			if(comboObjects[1].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl2") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 2]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl2", true);
					return false;
				}
			}
			
			if(comboObjects[2].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl3") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 3]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl3", true);
					return false;
				}
			}
	 	break;
	 	
	 	case COMMAND01:
	 		if(ComIsNull(formObj.vsl_slan_cd.value)){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
	 		
	 		if(formObj.vsl_slan_cd.value.length < 3){
	 			ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			if(formObj.pf_svc_tp_cd.value.length < 4){
				ComShowCodeMessage("VSK01018", "[P/F TYPE]");
				formObj.pf_svc_tp_cd.value = "";
				formObj.pf_svc_tp_cd.focus();
				
				return false;
			}
			
			if(ComIsNull(formObj.slt_prc_wrk_yr.value)){
				ComShowCodeMessage('VSK00027', "Year");
				formObj.slt_prc_wrk_yr.focus()
				return false;
			}
			
			if(formObj.slt_prc_wrk_yr.value.length < 4){
				ComShowCodeMessage('VSK00027', "Year");
				var today = new Date();
				formObj.slt_prc_wrk_yr.value = today.getFullYear();
				formObj.slt_prc_wrk_yr.focus();
				
				return false;
			}
			
			//첫번째 Vessel Class Knt는 0 이상이어야 한다
			if(Number(formObj.n1st_vsl_clss_knt.value) == 0){
				ComShowCodeMessage("VSK01018", "[Vsl Class 1 KNT]");
				formObj.n1st_vsl_clss_knt.focus();
				return false;
			}
			
			//두번째 Vessel Class Knt가 0 이상을 입력하면 Vessel2 Class는 선택 되어져야 한다
			if(Number(formObj.n2nd_vsl_clss_knt.value) > 0){
				if(comboObjects[1].Text == ""){
					ComShowCodeMessage("VSK01018", "[Vsl Class 2]");
					comboObjects[1].focus();
					return false;
				}
			}
			
			//세번째 Vessel Class Knt가 0 이상을 입력하면 Vessel3 Class는 선택 되어져야 한다
			if(Number(formObj.n3rd_vsl_clss_knt.value) > 0){
				if(comboObjects[2].Text == ""){
					ComShowCodeMessage("VSK01018", "[Vsl Class 3]");
					comboObjects[2].focus();
					return false;
				}
			}
			
			//두번째 Vessel Class 와 Vessel Class Knt가 Null이고
			//세번재 Vessel Class , Vessel Class Knt가 Null 이 아니면서 0이상이면 
			//두번째 Vessel Class 와 Vessel Class Knt로 세팅한다
			if(comboObjects[1].Text == "" && (formObj.n2nd_vsl_clss_knt.value == "" || Number(formObj.n2nd_vsl_clss_knt.value) == 0)){
				if(comboObjects[2].Text != "" || Number(formObj.n3rd_vsl_clss_knt.value) > 0){
					var combo1Idx = 0;
					var combo2Val = comboObjects[2].Text;
					var cnt = comboObjects[2].GetCount;
					
					for(var i=0; i<cnt; i++){
						if(comboObjects[1].GetIndexText(i,0) == combo2Val){
							combo1Idx = i;
						}
					}
					
					comboObjects[1].index = combo1Idx;
					formObj.n2nd_vsl_clss_knt.value = formObj.n3rd_vsl_clss_knt.value;
					comboObjects[2].Text = "";
					formObj.n3rd_vsl_clss_knt.value = "";
					
					sheetObjects[2].CellValue(1,"sheet3_vsl_csl2") = comboObjects[1].Text;
				}
			}
			
			//Hire Base 
			if(comboObjects[0].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl1") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 1]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl1", true);
					return false;
				}
			}
			
			if(comboObjects[1].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl2") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 2]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl2", true);
					return false;
				}
			}
			
			if(comboObjects[2].Text != ""){
				if(sheetObjects[3].CellValue(1,"sheet4_vsl_csl3") == ""){
					ComShowCodeMessage("VSK01018", "[Declared Capacity 3]");
					sheetObjects[3].SelectCell(1, "sheet4_vsl_csl3", true);
					return false;
				}
			}
			
			
	 	break;
	 }

     return true;
 }

 /**
  * Enter키 이벤트
  * @param sheetObj
  * @param formObj
  * @return
  */
 function doSearch(){
 	var formObject = document.form;

 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
 }
 
 function setValCls(comboObj,val){
	var cnt = comboObj.GetCount;
	var comboPos = 0;
	
	for(var i=0; i<cnt; i++){
		if(comboObj.GetIndexText(i,0) == val){
			comboPos = i;
			break;
		}
	}
	
	if(comboPos > 0){
		comboObj.Index2 =  comboPos;
	}else{
		comboObj.Index2 =  -1;
	}
	
}
 
 /**
  * SHEET2 그리드 데이타 change 이벤트
  */
 function sheet2_OnChange(sheetObj, Row, Col, Value) {

 	var prefix = sheetObj.id + "_";
 	var cnt = sheetObj.RowCount + sheetObj.HeaderRows;
 	var formObj = document.form;


 	if(Row > 2){
 		if(Col == 2){
 //초기에 sheet2_OnKeyUp 이벤트에서 5자리로  이벤트를 잡았는데
 //후에 port_cd의 validtion 체트 (3자를 넣어도 체크를 할 수 있도록 요청)때문에
 //sheet2_OnChange로 이벤트를 바꿈 
 //그래서  sheet2_OnChange에서는 port_cd 사이즈로는 이벤트를 자동으로 발생시킬 수가 없음		
 			var headCnt = sheetObj.HeaderRows;
 			var rowCnt = sheetObj.RowCount;
 			var totalCnt = headCnt+rowCnt;
 			var currPos = (sheetObj.SelectRow - headCnt)+1;
 			var currRow = sheetObj.SelectRow;
 			var tempVal = sheetObj.EditValue;
 			
 			if(tempVal.length == 5){
 				formObj.port_cd.value = tempVal;		
 				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
 				
 				var chkPort = ComGetEtcData(sXml, "check_port");

 				if(chkPort == "X"){
 					if(sXml != null && sXml != undefined && sXml != ""){
 						var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
 						xmlDoc.loadXML(sXml);
 	
 						var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
 						if(dataNode){
 							var totValue = dataNode.value;
 	
 							if(totValue > 0){
 								setSheetComboSinc(sXml, sheetObj, Row, Col);
 							}else{
 								setSheetClearCombo(sheetObj, Row, Col);
 								sheetObj.CellValue2(Row, sheetObj.id+"_yd_cd") = "";
 							}
 						}
 					}
 					
 					sheetObj.SelectCell(Row, Col, true);
 				}else{
 					ComShowCodeMessage('VSK00029', Value);
 					sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
 					sheetObj.SelectCell(Row, Col-1, true);
 				}
 			}else{
 				ComShowCodeMessage('VSK00029', tempVal);
 				sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
 				sheetObj.SelectCell(Row, Col-1, true);
 			}
 		}
 	}
 } 
 
 /**
  * SHEET2 그리드를 Click 이벤트
  */

 function sheet2_OnClick(sheetObject, Row, Col) {
 	var formObj = document.form;
 	var sXml = null;
 	var prefix = sheetObject.id + "_";

 	if(Row > 1 && Col > 0){
 		if(sheetObject.ColSaveName(Col) == prefix+"yd_cd"){
 			
 			formObj.port_cd.value = sheetObject.CellValue(Row, prefix + "port_cd");	
 			var tempPortCd = formObj.port_cd.value;

 			if(tempPortCd.length == 5){
 				sXml = doActionIBSheet(sheetObject, formObj, SEARCH03);
 				
 				if(sXml != null && sXml != undefined && sXml != ""){
 					setSheetComboSinc(sXml, sheetObject, Row, Col);
 				}
 			}
 			
 		}
 	}
 }
 
 
 /**
  * Sheet의 Terminal Combo Data Clear...
  * @param sheetObj
  * @param Row
  * @param Col
  * @return
  */
 function setSheetClearCombo(sheetObj, Row, Col){
 	sheetObj.CellComboItem(Row, sheetObj.id+"_yd_cd", "", "");
 }

	/* 개발자 작업  끝 */