/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_7005.js
*@FileTitle : Tariff Type Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.19 황효근
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
     * @class ees_dmt_7005 : ees_dmt_7005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_7005() {
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
 
 var COMMON_TARIFF_CD = "common_tariff_cd";
 var USER_TARIFF_TYPE = "user_tariff_type"; 
 var ROWMARK = "|";
 var FIELDMARK = "=";
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
		  /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
		  /*******************************************************/
		  var formObject = document.form;

		  try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
         
     			case "btn_Save":
     				doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
     
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
     
     
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
		for(var i=0;i<sheetObjects.length;i++){
			initSheet(sheetObjects[i],i+1);
		}
		
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		
		doActionIBCombo(sheetObjects[0], document.form, IBROWSEARCH, comboObjects[0]);
 	}
     
     
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
	function initSheet(sheetObj,sheetNo) {

    	  var cnt = 0;
    	  
    	  switch(sheetNo) {
             case 1:
            	 with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 2, 100);
	
	                var HeadTitle = "";
					//var headCount = ComCountHeadTitle(HeadTitle);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(1, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,daCenter,	true,	"ibflag");
					//CountPosition = 0;
            	 }
            	 
                 break;
         }
     }


	/**
	* 저장후 처리
	*/
	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
	  if(ErrMsg != '') return;
 	
	  ComShowCodeMessage('DMT00007');
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
   					MultiSelect = true;
   					DropHeight = 160;
   					SetColWidth("50|310");
   		    	}
   				break; 
   	     }
   	}

   	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
	        case IBSAVE:	//저장
		 		if(!validateForm(sheetObj,formObj,sAction)) return;
		 		
		 		setFormDataTrfTp(formObj);
		 		formObj.f_cmd.value = MULTI;
	            var sXml = sheetObj.GetSaveXml("EES_DMT_7005GS.do", FormQueryString(formObj));
	            sheetObj.LoadSaveXml(sXml);
	            break;
        }
        
        sheetObj.WaitImageVisible = true;
    }
   	
   	
   	function doActionIBCombo(sheetObj,formObj,sAction, comboObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
	        case IBROWSEARCH:      
		 		//1. Tariff type comboList
				formObj.f_cmd.value = SEARCHLIST;
				var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				var data = ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
				}
				
				var data2 = ComGetEtcData(xmlStr, USER_TARIFF_TYPE);
				if(data2 == 'All') {
					for(var i=0; i < comboObj.GetCount(); i++) {
		    			comboObj.CheckIndex(i) = true;
			    	}
				} else
					comboObj.Code2 = data2;
				
				break;
        }
		sheetObj.WaitImageVisible = true;
    }
	
    /**
    * 콤보필드에 데이터를 추가해준다.
    */	
	function addComboItem(comboObj,comboItems) {
		comboObj.InsertItem(0, "All|All", "All");
	   	
		for (var i = 0 ; i < comboItems.length ; i++) {
	   		var comboItem = comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
	   	}
	}
	
	
	//멀티콤보 클릭 이벤트
	function combo1_OnCheckClick(comboObj, index, code) {
	    if(index==0) {
	    	//checked
	    	var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
    		comboObj.CheckIndex(0) = false;
	    }
	}
   	

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
        	 
        	 if( ComIsEmpty(comboObjects[0].Code) ) {
				 ComShowCodeMessage('COM12113', "Tariff Type in Charge");
				 return false;
			 }
         }

         return true;
     }
     
     
     
     var trfTpfldNm = new Array();
     var trfTp = new Array('DMIF', 'DMOF', 'DTIC', 'DTOC', 'CTIC', 'CTOC', 'All');
     
     trfTpfldNm['DMIF'] = 'dem_ib_flg';
     trfTpfldNm['DMOF'] = 'dem_ob_flg';
     trfTpfldNm['DTIC'] = 'det_ib_flg';
     trfTpfldNm['DTOC'] = 'det_ob_flg';
     trfTpfldNm['CTIC'] = 'cmb_ib_flg';
     trfTpfldNm['CTOC'] = 'cmb_ob_flg';
     trfTpfldNm['All']  = 'all_trf_tp_flg';
     
     
     function setFormDataTrfTp(formObj) {
    	 with(formObj) {
    		 for(var i=0; i < trfTp.length; i++) {
	    		 var obj = eval(trfTpfldNm[trfTp[i]]);
	    		 obj.value = 'N';
	    	 }
    		 
	    	 var selTrpTp = comboObjects[0].Code;
	    	 var arrSelTrpTp = selTrpTp.split(",");
	    	 
	    	 if(arrSelTrpTp.length >= 6) { // 전체 선택
	    		 formObj.all_trf_tp_flg.value = 'Y';
	    	 } else {
	    		 for(var i=0; i < arrSelTrpTp.length; i++) {
		    		 var obj = eval(trfTpfldNm[arrSelTrpTp[i]]);
		    		 obj.value = 'Y';
		    	 }
	    	 }
    	 }
     }



	/* 개발자 작업  끝 */