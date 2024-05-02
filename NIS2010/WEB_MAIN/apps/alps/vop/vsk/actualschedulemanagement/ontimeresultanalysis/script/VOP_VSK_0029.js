/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0029.js
*@FileTitle : Delay&Skip Status
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.10 서창열
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 - Vessel Code Inquiry의 서버로직을 호출하는 부분을 분리함
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
     * @class VOP_VSK_0029 : VOP_VSK_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0029() {
    	this.processButtonClick	= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl; 
    	this.doActionIBSheet 	= doActionIBSheet;
    	this.setTabObject 		= setTabObject;
    	this.validateForm 		= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var tabObjects = new Array();
 var tabClicks  = new Array(3);//해당 탭이 클릭되 었는가 셋팅.
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
var comboCnt = 0;

 var tabLoad = new Array();
 tabLoad[0]= 0;
 tabLoad[1]= 0;
 tabLoad[2]= 0;
 
 //첫번째 탭의 헤더 코드
 var tab1HeadArr2 = new Array();
 // 첫번째 탭의 헤더 코드 갯수
 var tab1HeadArr2Cnt = 0;
 //첫번째 탭의 헤더 타이틀
 var tab1HeaderNm = "";
 var tab2HeaderNm = "";
 var tab3HeaderNm = "";
 
 //User_Condition Tab Setting  
 var delayConData = null;
 var skipConData = null;
 var skipChangeConData = null;




 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

  var sheetObject1 = sheetObjects[0];
  var sheetObject2 = sheetObjects[1];
  var sheetObject3 = sheetObjects[2];

  /*******************************************************/
  var formObject = document.form;

  try {
	var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

				case "btn_Retrieve":
					if(checkPeriod(formObject)){
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					}else{
						ComShowCodeMessage("VSK00105", "1 year");
					}
					break;

				case "btn_VVDRMKs":
//					doActionIBSheet(sheetObject1, formObject, COMMAND01);
					var sUrl = "/hanjin/VOP_VSK_0232.do?vps_port_cd="+formObject.vps_port_cd.value;
                	ComOpenPopup(sUrl, 600, 380, "getVvdRemark()", "0,0", true);
					break;

				case "btn_DelayRSN":
					var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD01830";
					ComOpenPopupWithTarget(sUrl, 600, 406, "", "0,0", true);
					break;

				case "btn_GroupRegister":
						var sUrl = "/hanjin/VOP_VSK_0228.do";
						ComOpenPopupWithTarget(sUrl, 406, 465, "", "0,0", true);
						break;

				case "btns_search":
					openLandCdHelp(sheetObject1);
					break;
				case "btns_search2":
					openVslCdHelp(sheetObject1);
					break;
				case "btns_search3":
					openPortCdHelp(sheetObject1);
					break;
				case "btns_search4":
					openCrrCdHelp(sheetObject1);
					break;	
				case "btns_calendar_s":
	            	var cal = new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.setEndFunction("setActInpFmDt");
		            cal.select(formObject.act_inp_fm_dt, "yyyy-MM");
	            	break;
	            case "btns_calendar_e":
	            	var cal = new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.setEndFunction("setActInpToDt");
	            	cal.select(formObject.act_inp_to_dt, "yyyy-MM");
	            	break;	
	            case "lane_grp":
					eventNav(formObject);
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
 * 
 * @param rtnObjs
 * @return
 */
function setActInpFmDt(rtnObjs){
	var formObj = document.form;
	
	if(beforetab == 0){
		delayConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
	else if(beforetab == 1){
		skipConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
	else if(beforetab == 2){
		skipChangeConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
	}
}

/**
 * 
 * @param rtnObjs
 * @return
 */
function setActInpToDt(rtnObjs){
	var formObj = document.form;
	
	if(beforetab == 0){
		delayConData.setActInpToDt(formObj.act_inp_to_dt.value);
	}
	else if(beforetab == 1){
		skipConData.setActInpToDt(formObj.act_inp_to_dt.value);
	}
	else if(beforetab == 2){
		skipChangeConData.setActInpToDt(formObj.act_inp_to_dt.value);
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
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

         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[2],3);

         ComEndConfigSheet(sheetObjects[i]);
     }

     for(k=0;k<tabObjects.length;k++){

         initTab(tabObjects[k],k+1);
     }
     
     for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
	 }
    
     var tab1HeadCol = formObj.headerVal.value;
     var tab1HeadCol1 = "";
     var tab1HeadCol2 = "";
     var tab1HeadArr = new Array();
     
     tab1HeadArr = tab1HeadCol.split("|");
     var tab1HeadCnt = tab1HeadArr.length;

     for(var i=0; i<tab1HeadCnt; i++){
    	 tab1HeadCol1 += "Exclusive Delay Reason (Ratio)"+"|";
    	 tab1HeadCol2 += tab1HeadArr[i]+"|";
     }
      
     //Total 첫번째로우의 Total 헤더
    // tab1HeadCol1 += "Exclusive Delay Reason (Ratio)"+"|";
     var obj = document.form.grp_flg[0].options;
     tab1HeaderNm = obj[0].text;

     var obj2 = document.form.grp_flg[1].options;
     tab2HeaderNm = obj2[0].text;
     
     var obj3 = document.form.grp_flg[2].options;
     tab3HeaderNm = obj3[0].text;

     sheetObjects[0].Reset();
     ComConfigSheet (sheetObjects[0]);
     initSheet(sheetObjects[0], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[0]);

     sheetObjects[1].Reset();
     ComConfigSheet (sheetObjects[1]);
     initSheet(sheetObjects[1], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[1]);

     sheetObjects[2].Reset();
     ComConfigSheet (sheetObjects[2]);
     initSheet(sheetObjects[2], 1, tab1HeadCol1,tab1HeadCol2);
     ComEndConfigSheet(sheetObjects[2]);

     formObj.vsl_slan_cd.focus();
     
 	 ComEnableObject(formObj.vsl_slan_cd, true);
 	 formObj.lane_grp_nm.Enable = false;
 	 
 	 delayConData = new Usr_Condi_FormData();
 	 skipConData = new Usr_Condi_FormData();
 	 skipChangeConData = new Usr_Condi_FormData();
 	 
 	 initControl();
 }
  
 /**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
    
    switch(comboObj.id) {
    	case "lane_grp_nm":
    		with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("100");
				BackColor = "#CCFFFD";
				FontColor = "#000000";
				ColBackColor(0) = "#CCFFFD";
				ColFontColor(0) = "#000000";
				DropHeight = 160;
	    	}
    		break;
     }
}

 /**
  * 이벤트 컨드롤 정의
  */
 function initControl() {
 	//Axon 이벤트 처리1. 이벤트catch
	var formObj = document.form;
	axon_event.addListenerForm('focus', "obj_activate", formObj);
	
	axon_event.addListenerForm('keyup', 'obj_change', formObj); 			// - 변경데이타 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
 	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	formObj); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	axon_event.addListenerForm('keypress', 'enter_keypress', formObj); 	// - Enter키 처리
 	
 	setToday(document.form.act_inp_fm_dt, "ym");//올해 설정
	setToday(document.form.act_inp_to_dt, "ym");//올해 설정
 }
 
 function obj_activate() {
	ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
 }

 /**
  * 필드 데이타가 CHANGE될 경우 이벤트
  */
 

 function obj_change(){
 	var formObj = document.form;
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    var prefix1 = "sheet1_";
    var obj = event.srcElement;
     /*******************************************************/

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
        	case "vsl_slan_cd":
	        	var cnt = formObj.vsl_slan_cd.value;
				cnt = cnt.length;
	
				if(cnt == 3){
					
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH02);

					var checkLane = ComGetEtcData(sXml, "checkLane");
					
					if(checkLane == undefined){
						sheetObject1.LoadSearchXml(sXml);
						formObj.vsl_slan_cd.value = "";	
						formObj.vsl_slan_cd.focus();
					}else{
						if(beforetab == 0){
							delayConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVslSlanCd(formObj.vsl_slan_cd.value);
						}
					}
				}
        	break;
        	
        	case "vsl_cd":
        		var cnt = formObj.vsl_cd.value;
				cnt = cnt.length;

				if(cnt == 4){
					
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
					var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
		    		if(!vsl_eng_nm){
		    			ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
		    			formObj.vsl_cd.value = '';
		    			formObj.vsl_cd.focus();
		    		}else{
		    			if(beforetab == 0){
							delayConData.setVslCd(formObj.vsl_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVslCd(formObj.vsl_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVslCd(formObj.vsl_cd.value);
						}
		    			
		    			ComSetNextFocus();
		    		}
				}
        		
       		break;
        	
        	case "vps_port_cd":
        		var cnt = formObj.vps_port_cd.value;
				cnt = cnt.length;
	
				if(cnt == 5){
					
					var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
					var portNm = ComGetEtcData(sXml, "port_name");
					
					if(portNm != ""){
						if(beforetab == 0){
							delayConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						else if(beforetab == 1){
							skipConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						else if(beforetab == 2){
							skipChangeConData.setVpsPortCd(formObj.vps_port_cd.value);
						}
						
						formObj.act_inp_fm_dt.focus();
					}else{
						//해당 Port({?msg1})가 존재하지 않습니다.
						ComShowCodeMessage("VSK00029", formObj.vps_port_cd.value);
						
						formObj.vps_port_cd.value = "";
					}
				}
        	break;

        	case "crr_cd":
        		if(ComChkLen(obj.value, 3)==2){
    				var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
    				var crr_cd = ComGetEtcData(sXml, "crr_cd");
    				if(crr_cd==null){
    					ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
    					formObj.crr_cd.value = "";
    					formObj.crr_cd.focus();
    				}else{
    					if(beforetab == 0){
    						delayConData.setCrrCd(formObj.crr_cd.value);
    					}
    					else if(beforetab == 1){
    						skipConData.setCrrCd(formObj.crr_cd.value);
    					}
    					else if(beforetab == 2){
    						skipChangeConData.setCrrCd(formObj.crr_cd.value);
    					}
    				}
    			}
       		break;

        }
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e);
 		}
 	}
 } 
 
 /**
  * KEY PRESS 이벤트
  */
 function obj_keypress() {
     switch(event.srcElement.dataformat){
         case "float":
             //숫자+"."입력하기
             ComKeyOnlyNumber(event.srcElement, ".");
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
  * onBlur처리 
  * @return
  */
 function obj_blur(){

	 var formObj = document.form;
   	 obj = event.srcElement;      	
   	 
   	 with(formObj){
   		 if(obj.name=="act_inp_fm_dt" || obj.name=="act_inp_to_dt"){
   			 var creDtFr = ComReplaceStr(act_inp_fm_dt.value,"-","");
   			 var creDtTo = ComReplaceStr(act_inp_to_dt.value,"-","");
   			 
   			 switch(obj.name) {
	    	    	case "act_inp_fm_dt":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				act_inp_fm_dt.value='';
	    	    				document.form.act_inp_fm_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.act_inp_fm_dt.value = ComGetMaskedValue(formObj.act_inp_fm_dt.value, "ym");
	    	            break;
	    	            
	    	    	case "act_inp_to_dt":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				act_inp_to_dt.value='';
	    	    				act_inp_to_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.act_inp_to_dt.value = ComGetMaskedValue(formObj.act_inp_to_dt.value, "ym");
	    	           	break;	
	        	}
   			 
	   			if(beforetab == 0){
					delayConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					delayConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
				else if(beforetab == 1){
					skipConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					skipConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
				else if(beforetab == 2){
					skipChangeConData.setActInpFmDt(formObj.act_inp_fm_dt.value);
					skipChangeConData.setActInpToDt(formObj.act_inp_to_dt.value);
				}
   		 	}
       }
       return true;	
 } 

 function enter_keypress(){
		VskKeyEnter();
}
 
function delayChange(){

	var formObj = document.form;
	var obj = formObj.grp_flg[0].options;
	var currPos = 0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos = i;
		}
	}
	
	sheetObjects[0].RemoveAll();
	
	var delayHeaderNm = obj[currPos].text;

	sheetObjects[0].CellValue(0,"sheet1_lane") = delayHeaderNm;
	sheetObjects[0].CellValue(1,"sheet1_lane") = delayHeaderNm;
	sheetObjects[0].CellValue(2,"sheet1_lane") = delayHeaderNm;
}

function skipChange(){
	var formObj = document.form;
	var obj = formObj.grp_flg[1].options;
	var currPos = 0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos = i;
		}
	}
	
	sheetObjects[1].RemoveAll();
	
	var skipHeaderNm = obj[currPos].text;

    sheetObjects[1].CellValue(0,"sheet2_lane") = skipHeaderNm;
	sheetObjects[1].CellValue(1,"sheet2_lane") = skipHeaderNm;
	sheetObjects[1].CellValue(2,"sheet2_lane") = skipHeaderNm;
	 
}

function skipChangeStatus(){
	var formObj = document.form;
	var obj = formObj.grp_flg[2].options;
	var currPos = 0;
	for(var i=0; i<obj.length; i++){
		if(obj[i].selected == true){
			currPos = i;
		}
	}
	sheetObjects[2].RemoveAll();
	
	var skipChangeHeaderNm = obj[currPos].text;

	sheetObjects[2].CellValue(0,"sheet3_group_flg") = skipChangeHeaderNm;
}

   /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo, tab1HeadCol1,tab1HeadCol2) {
	
     var cnt = 0;
	 var sheetID = sheetObj.id;
     switch(sheetID) {

         case "t1sheet1":
             with (sheetObj) {
            	 tab1HeadArr2 = tab1HeadCol2.split("|");
  				 tab1HeadArr2Cnt = tab1HeadArr2.length-1;
  				 
                 // 높이 설정
                 style.height = 362;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(3, 1, 13, 100);                 
                 
                 var HeadTitle1 = "|"+tab1HeaderNm+"|CNT|"+tab1HeadCol1+"Total|On-time Ratio|On-time Ratio|On-time Ratio";
                 var HeadTitle2 = "|"+tab1HeaderNm+"|HRS|"+tab1HeadCol2+"Total|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay";
                 var HeadTitle3 = "|"+tab1HeaderNm+"|S.TTL|"+tab1HeadCol2+"Total||Calling|On-time";

                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFT HEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);
				 InitHeadRow(2, HeadTitle3, true);
				
				var prefix = "sheet1_";
				//데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,			prefix+"ibflag");
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,		true,    		prefix+"lane",     		false,           "",      dfNone, 			0,     		false,      true);
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,		true,    		prefix+"cnt_hrs",     	false,           "",      dfNone, 			0,     		false,      true);

				for(var i=0; i<tab1HeadArr2Cnt; i++){
					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,	true,			prefix+tab1HeadArr2[i].toLowerCase(), 			false,           "",      dfNone, 			0,     		false,       true);
				}
				
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,		true,   		prefix+"ttl",     	false,           "",      dfNone, 			0,     		false,      true);				
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,		false,   		prefix+"arr_dep",     	false,           "",      dfNone, 			0,     		false,      true);
				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,		false,   		prefix+"call_cnt",   	false,           "",      dfNone, 			0,     		true,       true);
				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,		false,   		prefix+"ontm_cnt",   	false,           "",      dfNone, 			0,     		true,       true);				

				//SetMergeCell(0,1,3,2);
				//SetMergeCell(0,3,2,48);
				 //SetMergeCell(0,0,2,53);
				CountPosition = 0;
				
				WaitImageVisible = false;

			}
             break;


         case "t2sheet1":
             with (sheetObj) {
                 // 높이 설정
                 style.height = 362;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;msNone

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(3, 1, 13, 100);

                 var HeadTitle1 = "|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol1+"Total|On-time Ratio|On-time Ratio|On-time Ratio";
                 var HeadTitle2 = "|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol2+"Total|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay";
                 var HeadTitle3 = "|"+tab2HeaderNm+"|"+tab2HeaderNm+"|"+tab1HeadCol2+"Total||Calling|On-time";
                 
                 //var HeadTitle1 = "|"+tab1HeaderNm+"|CNT|"+tab1HeadCol1+"Total|On-Time Ratio|On-Time Ratio|On-Time Ratio";
                 //var HeadTitle2 = "|"+tab1HeaderNm+"|HRS|"+tab1HeadCol2+"Total|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay|Inclusive of Consecutive Delay";
                 //var HeadTitle3 = "|"+tab1HeaderNm+"|S.TTL|"+tab1HeadCol2+"Total||Calling|On-Time";

                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);
                 InitHeadRow(2, HeadTitle3, true);

                 var prefix = "sheet2_";

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
               //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,			prefix+"ibflag");
 				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,		true,    		prefix+"lane",     		false,           "",      dfNone, 			0,     		false,      true);
 				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,		true,    		prefix+"cnt_hrs",     	false,           "",      dfNone, 			0,     		false,      true);

  				tab1HeadArr2 = tab1HeadCol2.split("|");
  				tab1HeadArr2Cnt = tab1HeadArr2.length-1;

 				for(var i=0; i<tab1HeadArr2Cnt; i++){
 				
 					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,	true,			prefix+tab1HeadArr2[i].toLowerCase(), 			false,           "",      dfNone, 			0,     		false,       true);
 				}
 				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,		true,   		prefix+"ttl",     	false,           "",      dfNone, 			0,     		false,      true);
 				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,		false,   		prefix+"arr_dep",     	false,           "",      dfNone, 			0,     		false,      true);
 				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,		false,   		prefix+"call_cnt",   	false,           "",      dfNone, 			0,     		true,       true);
 				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,		false,   		prefix+"ontm_cnt",   	false,           "",      dfNone, 			0,     		true,       true);

 				SetMergeCell(0,1,3,2);
				//SetSumColMerge();
				//WordWrap = true;
				CountPosition = 0;
				
				WaitImageVisible = false;

			}
             break;

         case "t3sheet1":
             with (sheetObj) {
            	 
                 // 높이 설정
                 style.height = 370;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 13, 100);

                 var HeadTitle1 = "|"+tab3HeaderNm+"|VVD|Port1|State|Port2|State|Port3|State|Port4|State|Port5|State|Port6|State|Port7|State|Port8|State|Port9|State|Port10|State|Port11|State|Port12|State|Port13|State|Port14|State|Port15|State|Port16|State|Port17|State|Port18|State|Port19|State|Port20|State";

                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, false, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                var prefix = "sheet3_"; 
				var rowCnt = 0;
                 //데이터속성    [ROW, 			COL,  	DATATYPE,   		WIDTH, 		DATAALIGN, 		COLMERGE,	 SAVENAME,  						KEYFIELD, 	CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,			30,		daCenter,		true,    	prefix+"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		true,    	prefix+"group_flg",     			false,           "",      dfNone, 				0,     false,      	true,    -1,         false,    true);
				InitDataProperty(rowCnt,	cnt++,	dtData,					80,		daCenter,		false,    	prefix+"vvd",     					false,           "",      dfNone, 				0,     false,      	true,    -1,         false,    true);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port1",     				false,           "",      dfNone, 				0,     false,      	true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state1",    				false,           "",      dfNone, 				0,     false,      	true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port2",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state2",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port3",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state3",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port4",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state4",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port5",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state5",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port6",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state6",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port7",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state7",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port8",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state8",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port9",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state9",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port10",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state10",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port11",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state11",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port12",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state12",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port13",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state13",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port14",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state14",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port15",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state15",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port16",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state16",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port17",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state17",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port18",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state18",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port19",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state19",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,    	prefix+"port20",     				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daCenter,		false,    	prefix+"state20",    				false,           "",      dfNone, 				0,     true,    	 true,    -1,         false,    false);

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

        case IBSEARCH:      //조회
        	/*
        	if ( sheetObj.id == "t1sheet1"){
        		formObj.f_cmd.value = SEARCH;
		     	sheetObj.DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		     
		     	if(sheetObjects[0].RowCount > 0){
		     		showSheetData(sheetObj,formObj);
		     	}
        	}else if(sheetObj.id == "t2sheet1"){
        		formObj.f_cmd.value = SEARCH03;
	     		sheetObj.DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
	     		
	     		if(sheetObjects[1].RowCount > 0){
	     			alert(sheetObjects[1].RowCount);
		     		//showSheetData(sheetObj,formObj);
		     	}
        	}else if(sheetObj.id == "t3sheet1"){
        		
        	}
        	*/
        	if(validateForm(sheetObj,formObj,sAction)){
	        	var curPos = 0;
	        	for(var i =0; i<tabClicks.length; i++){
	        		if(tabClicks[i] == true){
	        			curPos = i;
	        		}
	        	}
	        	
	        	ComOpenWait(true);
	        	if(curPos == "0"){
	        		formObj.f_cmd.value = SEARCH;
	        		formObj.grp_flg_cd.value = formObj.grp_flg[0].value;
	        		sheetObjects[0].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			     
			     	if(sheetObjects[0].RowCount > 0){
			     		showSheetData(sheetObj,formObj);
			     	}
			     	
	        	}else if(curPos == "1"){
	        		formObj.f_cmd.value = SEARCH03;
	        		formObj.grp_flg_cd.value = formObj.grp_flg[1].value;
	        		sheetObjects[1].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
		     		
	        		
	        	}else{
	        		formObj.f_cmd.value = SEARCH04;
	        		formObj.grp_flg_cd.value = formObj.grp_flg[2].value;
	        		sheetObjects[2].DoSearch("VOP_VSK_0029GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
	        	}
	        	ComOpenWait(false);

        	}
             break;
             
        case SEARCH02: //Lane Code
			//formObj.f_cmd.value = SEARCH02;
        	ComOpenWait(true);
        	formObj.f_cmd.value = COMMAND12;
			var sParam = FormQueryString(formObj);
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do", sParam);
			ComOpenWait(false);
			return sXml;
			
			break;
		
        case SEARCH03: // Vessel Code 조회
        	ComOpenWait(true);
    		formObj.f_cmd.value = COMMAND21;
    		var sParam = FormQueryString(formObj);
    		var sXml = sheetObj.GetSearchXml("VSK_GLOGS.do", sParam); //0044 로직분리 위해, VSK_GLOGS 호출
    		ComOpenWait(false);
    		
    		return sXml;
    		break;
    		
        case SEARCH04: // Port Code 조회
    		
        	//formObj.f_cmd.value = SEARCH;
        	ComOpenWait(true);
        	formObj.f_cmd.value = COMMAND13;
			var sParam = FormQueryString(formObj);
			var locCd = formObj.vps_port_cd.value;
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op_=0043&loc_cd="+locCd, sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?loc_cd="+locCd, sParam);
			ComOpenWait(false);
			
			return sXml;
    		break;	
    		
        case SEARCH05: // Group Code
        	formObj.lane_grp_nm.RemoveAll();
        	
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0029GS.do", sParam);
			var comboItems = ComGetEtcData(sXml, "grp_nm").split("|");
			addComboItem(formObj.lane_grp_nm,comboItems);	
			ComOpenWait(false);
			
    		break;		
    		
        case SEARCH06: //CHECK CARRIER CD
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			var code = formObj.crr_cd.value;
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0252GS.do?op_=0252&grd_nm=CD0XXXX&code="+code, sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0252GS.do?grd_nm=CD0XXXX&code="+code, sParam);
			ComOpenWait(false);
			
			return sXml;
			
        	break;		

     }
 }
 
function showSheetData(sheetObj,formObj){
	var colCnt = tab1HeadArr2Cnt;
	var prefix = "sheet1_";
	
	var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
	
	for(var k=3; k<=sheetObj.RowCount; k++){
		if(sheetObjects[0].CellValue(k,prefix+"cnt_hrs") == ""){
			
			sheetObjects[0].CellValue(k,prefix+"cnt_hrs") = "S.TTL";
			for(var i=1; i<=colCnt+2;i++){
				sheetObjects[0].CellBackColor(k, i) = grayColor;
			}
		}
	}
	
	var rdIdx = sheetObj.RowCount + sheetObj.HeaderRows -1;
	var pinkColor = sheetObj.RgbColor(eval("255"),eval("166"),eval("255"));
	for(var i=1; i<=colCnt+2;i++){
		sheetObjects[0].CellBackColor(rdIdx, i) = pinkColor;
	}
}


 /**
  * 콤보필드에 데이터를 추가해준다.
  */	
function addComboItem(comboObj, comboItems) {
	var selCode = "";
	if(comboItems){
		if(comboItems.length > 0){
			var comboCnt = comboItems.length;
			for (var i=0; i<comboCnt; i++) {
		 		var comboItem = comboItems[i].split("|");
		 		comboObj.InsertItem(i, comboItem[0], comboItem[0]);
		 	}
			selCode = comboItem[0];
		}else{
			comboObj.InsertItem(0, "","");
		}
	}else{
		comboObj.InsertItem(0, "","");
	}
	comboObj.Code2 = selCode;
}
 
 /*
 * =====================================================================
 * Combo Event
 * =====================================================================
 */

function lane_grp_nm_OnChange(comboObj, Index_Code, Text) {
	if(beforetab == 0){
		delayConData.setLaneGrpNm(Text);
	}
	else if(beforetab == 1){
		skipConData.setLaneGrpNm(Text);
	}
	else if(beforetab == 2){
		skipChangeConData.setLaneGrpNm(Text);
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
  * Vessel Code Help 파일을 오픈한다
  */  
  function openVslCdHelp(sheetObj){
	  var formObj = document.form;
	  var vsl_cd = document.form.vsl_cd.value;
	  
	  //var sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219&vsl_cd="+vsl_cd;
	  //var sUrl = "/hanjin/VOP_VSK_0219.do?f_cmd=" + COMMAND16 + "&vsl_cd="+vsl_cd;
	  var sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd="+vsl_cd + "&inc_del_vsl_pop=Y";
	  var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
	  if(rVal){
		  formObj.vsl_cd.value = rVal;
	  }
  }  
 
 /**
  * Port Code Help 파일을 오픈한다
  */  
  function openPortCdHelp(sheetObj){
	  var formObj = document.form;
	  var port_cd = formObj.vps_port_cd.value;
	  
	  //var sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043&port_cd="+port_cd;
	  var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+port_cd;
	  var rVal = ComOpenPopupWithTarget(sUrl, 428, 520, "", "0,0", true);
	  if(rVal){
		  formObj.vps_port_cd.value = rVal;
	  }
  }   

  
  /**
   * Carrier Code Help 파일을 오픈한다
   */  
   function openCrrCdHelp(sheetObj){
 	  var formObj = document.form;
 	  var crr_cd = formObj.crr_cd.value
 	  //var sUrl = "/hanjin/VOP_VSK_0252.do?op_=0252&code_type=CD0XXXX&code_value="+crr_cd;
 	 var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX&code_value="+crr_cd;
 	  var rVal = ComOpenPopupWithTarget(sUrl, 500, 420, "", "0,0", true);
 	  if(rVal){
 		  formObj.crr_cd.value = rVal;
 	  }
   }
   
function eventNav(formObj){
	if(formObj.lane_grp[0].checked){
		ComEnableObject(formObj.vsl_slan_cd, true);
		formObj.lane_grp_nm.Enable = false;
//		formObj.lane_grp_nm.value = "";
		getComboObject("lane_grp_nm").Code2 = "";
	}else{
		ComEnableObject(formObj.vsl_slan_cd, false);
		formObj.lane_grp_nm.Enable = true;
		formObj.vsl_slan_cd.value = "";
		
		if(beforetab == 0){
			delayConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		else if(beforetab == 1){
			skipConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		else if(beforetab == 2){
			skipChangeConData.setVslSlanCd(formObj.vsl_slan_cd.value);
		}
		   
		doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
	}

	if(beforetab == 0){
		delayConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
	}
	else if(beforetab == 1){
		skipConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
	}
	else if(beforetab == 2){
		skipChangeConData.setLaneGrp(ComGetObjValue(formObj.lane_grp));
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
      switch(tabNo) {
          case 1:
             with (tabObj) {

                 var cnt  = 0 ;
                 tabClicks[cnt]=false;
                 InsertTab( cnt++ , "Delay Status" , -1 );
                 tabClicks[cnt]=false;
                 InsertTab( cnt++ , "Skip Status" , -1 );
                 tabClicks[cnt]=false;
                 InsertTab( cnt++ , "Skip Change Status" , -1 );

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
	 var formObj = document.form;
     var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;

    	//alert('nItem:='+nItem);
    	//alert(tabClicks[nItem]);
    	//if( (nItem === 1 || nItem === 2) && tabClicks[nItem]==false )
    	//	doActionIBSheet(sheetObjects[nItem],document.form, IBSEARCH, nItem);
    	
    	
    
    	for(var i =0; i<tabClicks.length; i++){
    		if(nItem == i){
    			tabClicks[i] = true;
    		}else{
    			tabClicks[i] = false;
    		}
    	}
    	
    	if(nItem == 2){
    		ComBtnDisable("btn_VVDRMKs");
    		
    	}else{
    		ComBtnEnable("btn_VVDRMKs");
    	}
    	
    	setConditionData(formObj, nItem);
 }
 
 /**
 * Tab 변경 시 해당 Tab의 조회조건들을 Setting.
 * 
 * @param formObj
 * @param nItem
 * @return
 */
function setConditionData(formObj, nItem){

	switch(nItem) {
		case 0://tab1
			if(delayConData != null){
				delayConData.setAllFormData();
				
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//올해 설정
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//올해 설정
				}
				
				
			}

			break;
		case 1:      //tab2
			if(skipConData != null){
				skipConData.setAllFormData();
				
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//올해 설정
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//올해 설정
				}
				
				
			}
			break;
		case 2:      //tab3
			if(skipChangeConData != null){
				skipChangeConData.setAllFormData();
				if(ComIsNull(formObj.act_inp_fm_dt)){
					setToday(document.form.act_inp_fm_dt, "ym");//올해 설정
				}
				if(ComIsNull(formObj.act_inp_to_dt)){
					setToday(document.form.act_inp_to_dt, "ym");//올해 설정
				}
			}
			break;
	}
}



 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch(sAction) {
	 	case IBSEARCH:      //조회
	 		with(formObj){
	   			 var creDtFr = ComReplaceStr(act_inp_fm_dt.value,"-","");
	   			 var creDtTo = ComReplaceStr(act_inp_to_dt.value,"-","");
	   			 
	   			 if(creDtFr =="" || creDtTo == ""){
	   				ComShowCodeMessage('VSK00069');
	   			     return false;
	   			 }
		   			
		 		break;	
	 		}
     }

     return true;
 }


 		function t1sheet1_OnChangeSum(sheetObj, Row)
 		{
 			with(sheetObj)
 			{


 			}
 		}


 		function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 			with(sheetObj)
 			{
// 				for(var r = 0; r <= 3; r ++)
// 				{
// 					SumText(r, "Lane1") = "Total";
// 					SumText(r, "Blank") = "TTL";
// 					CellAlign(LastRow - 3, "Blank") = daCenter;
//
// 					for(var c = 0; c <= LastCol; c ++)
// 					{
// 						if (0 == SumText(r, c))
// 							SumText(r, c) = "";
// 					}
//
// 				}

// 				SumText(1, "Lane2") = "%";
// 				SumText(3, "Lane2") = "%";


 			}
 		}
 		
 		
 		function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
// 			with(sheetObj)
// 			{
// 				CellBackColor(1, "Lane1") = RgbColor(201, 202, 235);
// 				RowHidden(6) = true;
// 				RowHidden(LastRow) = true;
//
// 				for(var r = 0; r <= 3; r ++)
// 				{
// 					SumText(r, "Lane1") = "Total";
//
// 					for(var c = 0; c <= LastCol; c ++)
// 					{
// 						if (0 == SumText(r, c))
// 							SumText(r, c) = "";
// 					}
//
// 				}
//
//
// 			}
 		}
 		
 		
 		function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
// 			with(sheetObj)
// 			{
// 				var color1 = RgbColor(204, 255, 253);
// 				var color2 = RgbColor(201, 255, 185);
// 				
// 				ColBackColor("Lane") = color1;
// 				ColBackColor("VVD") = color1;
// 				ColBackColor("State1") = color2;
// 				
// 			}
 		}
 		
 		


 	    /**
 	     * VVD & Remark(s) Help (Pop-Up)에서 받은 데이타 세팅.
 	     * @param rtnObjs
 	     * @return
 	     */
 		function getVvdRemark(rtnObjs){
 	    	if(rtnObjs){
 				var rtnDatas = rtnObjs[0];
 				if(rtnDatas){
 					if(rtnDatas.length > 0){
// 						document.form.skd_voy_no.value = rtnDatas[2];
// 						document.form.skd_dir_cd.value = rtnDatas[3];
 					}
 				}
 	    	}
 	    }
 		
/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 */
function getComboObject(comboId){
	var cnt = comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].id == comboId){
				return comboObjects[i];
			}
		}
	}
	
	return null;
} 		
/*
 * =====================================================================
 * Form Condition Elements Getter/Setter
 * =====================================================================
 */

function Usr_Condi_FormData(){
	this.laneGrp = "";
	this.vslSlanCd = "";
	this.laneGrpNm = "";
	this.vslCd = "";
	this.vpsPortCd = "";
	this.actInpFmDt = "";
	this.actInpToDt = "";
	this.crrCd = "";
}

//Usr_Condi_FormData.Getter()
Usr_Condi_FormData.prototype.getLaneGrp = function(){
	return this.laneGrp;
}
Usr_Condi_FormData.prototype.getVslSlanCd = function(){
	return this.vslSlanCd;
}
Usr_Condi_FormData.prototype.getLaneGrpNm = function(){
	return this.laneGrpNm;
}
Usr_Condi_FormData.prototype.getVslCd = function(){
	return this.vslCd;
}
Usr_Condi_FormData.prototype.getVpsPortCd = function(){
	return this.vpsPortCd;
}
Usr_Condi_FormData.prototype.getActInpFmDt = function(){
	return this.actInpFmDt;
}
Usr_Condi_FormData.prototype.getActInpToDt = function(){
	return this.actInpToDt;
}
Usr_Condi_FormData.prototype.getCrrCd = function(){
	return this.crrCd;
}


//Usr_Condi_FormData.Setter()
Usr_Condi_FormData.prototype.setLaneGrp = function(sLaneGrp){
	this.laneGrp = sLaneGrp;
}
Usr_Condi_FormData.prototype.setVslSlanCd = function(sVslSlanCd){
	this.vslSlanCd = sVslSlanCd;
}
Usr_Condi_FormData.prototype.setLaneGrpNm = function(sLaneGrpNm){
	this.laneGrpNm = sLaneGrpNm;
}
Usr_Condi_FormData.prototype.setVslCd = function(sVslCd){
	this.vslCd = sVslCd;
}
Usr_Condi_FormData.prototype.setVpsPortCd = function(sVpsPortCd){
	this.vpsPortCd = sVpsPortCd;
}
Usr_Condi_FormData.prototype.setActInpFmDt = function(sActInpFmDt){
	this.actInpFmDt = sActInpFmDt;
}
Usr_Condi_FormData.prototype.setActInpToDt = function(sActInpToDt){
	this.actInpToDt = sActInpToDt;
}
Usr_Condi_FormData.prototype.setCrrCd = function(sCrrCd){
	this.crrCd = sCrrCd;
}

Usr_Condi_FormData.prototype.setAllFormData = function(){
	var formObj = document.form;
	
	ComSetObjValue(formObj.lane_grp, this.getLaneGrp());
	formObj.vsl_slan_cd.value = this.getVslSlanCd();
	formObj.vsl_cd.value = this.getVslCd();
	formObj.vps_port_cd.value = this.getVpsPortCd();
	
	if(ComIsNull(this.getLaneGrpNm())){
		getComboObject("lane_grp_nm").Code2 = "";
	}else{
		getComboObject("lane_grp_nm").Code2 = this.getLaneGrpNm();
	}
	
	formObj.act_inp_fm_dt.value = this.getActInpFmDt();
	formObj.act_inp_to_dt.value = this.getActInpToDt();
	formObj.crr_cd.value = this.getCrrCd();
	
	
} 		

function checkPeriod(formObj){
	var fmDt = ComReplaceStr(formObj.act_inp_fm_dt.value, "-", "");
	var toDt = ComReplaceStr(formObj.act_inp_to_dt.value, "-", "");
	
	fmDt = fmDt + "01";
	toDt = toDt + ComGetLastDay(toDt.substring(0, 4).parseInt(), toDt.substring(4, 6).parseInt());
	
	var tmpDt = ComGetDateAdd(fmDt, "Y", 1);
	if(ComChkPeriod(toDt, tmpDt)==1){
		return true;
	}else{
		return false;
	}
}
	/* 개발자 작업  끝 */