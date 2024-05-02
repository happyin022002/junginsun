/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0103.js
*@FileTitle : CPR Download History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
     * @class FNS_INV_0103 : FNS_INV_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0103() {
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
	
	//IBMultiCombo
		var comboObjects = new Array();
		var combo1 = null;
		var comboCnt = 0;
	 
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

                                           
            switch(srcName) {
                 case "btn1_Retrieve":
                	 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                 break; 

 				case "btn1_New":
 					ComResetAll();		
 					document.form.cust_rpt_id_arr.RemoveAll();
                 break;

 				case "btn1_Down_Excel":
 					sheetObjects[0].SpeedDown2Excel(1);
 					//sheetObjects[0].Down2Excel(1);
                 break;

 				case "btn_close":
 					window.close();
                 break;
                 
 				case "btns_report": //report id 조회버튼
 					var v_cust_rpt_id = formObject.cust_rpt_id.value;
 					var classId = "FNS_INV_0104";
 					var param = '?cust_rpt_id='+v_cust_rpt_id+'&pop_yn=Y&classId='+classId;
 			
 					ComOpenPopup('/hanjin/FNS_INV_0104.do' + param, 700, 460, 'getFNS_INV_0104', '1,0,1,1,1', false, false,0,0,0,"104pop");
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     /** 
    	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	 * 배열은 소스 상단에 정의
    	 * </pre>
    	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
    	 * @return 없음
    	 * @see #
    	 * @author 한동훈
    	 * @version 2009.10.19
    	 */
    	function setComboObject(combo_obj){
    		comboObjects[comboCnt++] = combo_obj;
    	}
     
     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
 			//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
 			//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
       //IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
    		
         document.form.cust_rpt_id_arr.focus();
     }
     
     /** 
    	 * 콤보 초기설정값<br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * 
    	 * </pre>
    	 * @param {IBMultiCombo} comboObj  comboObj
    	 * @return 없음
    	 * @see #
    	 * @author 박정진
    	 * @version 2009.10.19
    	 */
      	function initCombo(comboObj, comboNo) {
    		switch (comboObj.id) {
    			case "cust_rpt_id_arr":
    				with (comboObj) {
    					ValidChar(2,1);
    					MaxLength = 30;
    				}
    				break;   			
    			}
      	}
     
     /** 
      * Sheet 기본 설정 및 초기화 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {IBSheet} sheetObj : 시트오브젝트
      * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {
 					// 높이 설정
 					style.height = 440;
 										
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 15, 100);

 					var HeadTitle1 = "|Report ID|Creation Date|B/L No.|POR|POL|POD|DEL|Trunk VVD|S/C No.|RFA No.|PPD(USD TTL)|CCT(USD TTL)|3RD(USD TTL)";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 										
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false);

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);

 					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ib");
 										
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cust_rpt_id",				false,		"",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"cre_dt",					false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bl_src_no",				false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"por_cd",					false,		"",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pol_cd",					false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pod_cd",					false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"del_cd",					false,		"",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"trnk_vvd",					false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"sc_no",					false,      "",				dfNone,			0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"rfa_no",					false,		"",				dfNone,			0,			false,		false);
 					                                                                                                                                                               
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"ppd_usd_ttl_amt",			false,      "",				dfNullFloat,	2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"clt_usd_ttl_amt",			false,		"",				dfNullFloat,	2,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"n3rd_payr_usd_ttl_amt",	false,		"",				dfNullFloat,	2,			false,		false);
 					/*
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);

 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,		"",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"",			false,      "",				dfNone,		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"",			false,		"",				dfNone,		0,			true,		true);
 					*/
 					//CountPosition = 0;
 				}
                 break;


         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj,formObj,sAction) == false) return false;  
 				//cust_rpt_id_text();
 				formObj.f_cmd.value = SEARCH;					
				var sXml = sheetObj.GetSearchXml("FNS_INV_0103GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				sheetObjects[0].LoadSearchXml(arrXml[0], false);
				
 			break;

 			case IBSAVE:        //저장
           		if(validateForm(sheetObj,formObj,sAction))
                   alert (" Save .. ");
 			break;

 			case IBINSERT:      // 입력

 			break;
         }
     }

     /** 
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @return true, false
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
			case IBSEARCH: //조회
				if (formObj.cust_rpt_id_arr.GetCount()<= 0){					
					ComShowCodeMessage('INV00004');
					ComSetFocus(formObj.cust_rpt_id_arr);
					return false;
				}							
			break;
	 	 }
	 	 return true;
     }
     
     /** 
      * Report ID 변경시 해당 아이템을 대문자로 변경한다. <br>
      * 신규 Report ID 입력시 대문자변경
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} comboObj : Template Name 따른 폼 오브젝트
      * @param  {String} Index_Code : 선택한 Template Name의 value 값
      * @param  {String} Text : 선택한 Template Name의 text 값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function cust_rpt_id_arr_OnChange(comboObj,Index_Code, Text){
    	 if(Text != ""){
    		 var upperText = comboObj.Text.toUpperCase();
    		 var itemindex = comboObj.FindIndex ( upperText, 0);
    		 if(itemindex==-1){
    			 var cust_rpt_id = document.form.cust_rpt_id.value;
    			 if(comboObj.GetCount() == 0){
    				 document.form.cust_rpt_id.value = upperText;
    			 }else{
    				 document.form.cust_rpt_id.value = cust_rpt_id + "','"+upperText;
    			 }
    			 comboObj.InsertItem(0,upperText,upperText);    			 
    		 }
    		 comboObj.Text2 = upperText;
    	 }
     }
     
     /** 
      * 조회시 Report ID 에 있는 값을 text로 변경하여 조회한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function cust_rpt_id_text(){
    	 var cmbObj = document.form.cust_rpt_id_arr;
    	 for(var i=1;i<=cmbObj.GetCount(); i++){
    		 //var itemindex = comboObj.FindIndex ( , i);
    		 //alert(cmbObj.GetText(i,1));
    	 }
    	 alert(cmbObj.Index);
    	 alert(cmbObj.GetText("TEST",0));
    	 alert(cmbObj.GetText(1,1));
    	 alert(cmbObj.GetText(0,1));
    	 alert(cmbObj.GetText(1,0));
    	 alert(cmbObj.GetText(2,1));
    	 alert(cmbObj.GetText(0,1));
    	 alert(cmbObj.GetText(2,0));
    	 
     }
     
     /** 
      * 팝업창(FNS_INV_0104)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
    function getFNS_INV_0104(rowArray) {    	
    	var cmbObj = document.form.cust_rpt_id_arr;
    	cmbObj.RemoveAll();
    	
    	document.form.cust_rpt_id.value = "";
 		var cust_rpt_id = "";
 		
    	for(var i=0;i<rowArray.length; i++){
    		var colArray = rowArray[i];
    		//alert(colArray);
    		cmbObj.InsertItem(i, colArray[3], colArray[3]);
    		if(i==0){
    			cmbObj.text = colArray[3];
    		}
    		if(rowArray.length == 1){
    			cust_rpt_id = colArray[3];
    		}else{
	    		if(i==0){
	    			cust_rpt_id += colArray[3]+"',";
	    		}else if(i==rowArray.length-1){
	    			cust_rpt_id += "'"+colArray[3];
	    		}else{
	    			cust_rpt_id += "'"+colArray[3]+"',";
	    		}
    		}
    	}
    	if(cust_rpt_id != ""){
    		document.form.cust_rpt_id.value = cust_rpt_id;
    	}
    	
 	}
    /*
     function getFNS_INV_0104(rowArray) {
    	var targetE = document.form.cust_rpt_id_arr; 		
 		removeCombo(targetE);

 		document.form.cust_rpt_id.value = "";
 		var cust_rpt_id = "";

    	for(var i=0;i<rowArray.length; i++){
    		var colArray = rowArray[i];
    		//alert(colArray[3]);
    		addOption(colArray[3],colArray[3], targetE);
    		if(rowArray.length == 1){
    			cust_rpt_id = colArray[3];
    		}else{
	    		if(i==0){
	    			cust_rpt_id += colArray[3]+"',";
	    		}else if(i==rowArray.length-1){
	    			cust_rpt_id += "'"+colArray[3];
	    		}else{
	    			cust_rpt_id += "'"+colArray[3]+"',";
	    		}
    		}	
    	}
    	if(cust_rpt_id != ""){
    		document.form.cust_rpt_id.value = cust_rpt_id;
    	}
 	}
     */
    
    /** 
     * 해당 콤보박스에 값을 세팅함. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {String} text : 콤보박스의 text 값
     * @param  {String} value : 콤보박스의 value 값
     * @param  {object} e : 콤보박스의 오브젝트 값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function addOption(text,value, e){
 	    var o = new Option(text,value);
 	    try{
 	        e.add(o);
 	    }catch(ee){
 	        e.add(o, null);
 	    }
 	}
     
    /** 
     * 해당 콤보박스에 값을 모두 삭제함. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} e : 콤보박스의 오브젝트 값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
     function removeCombo(e){   
 	    for(var i = 0, limit = e.options.length; i < limit; ++i){
 	       e.remove(0);
 	    }
 	}
	/* 개발자 작업  끝 */