/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0104_03.js
*@FileTitle : B/L Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2015.01.07 조정민
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
     * @extends 
     * @class esm_bkg_0104_03  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0104_03() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;    	
    }
    
   	/* 개발자 작업	*/
	/*
	 * 입력한 조건 값을 폼에 초기 값으로 처리하기 위한 변수
	 * */

	    var arrFormElementMap = {dura_opt:'multi',      dura_from_dt:'input',dura_to_dt:'input', bl_sts_cd:'multi',  		vvd_cd:'input',			pol_cd:'input', 
	    						 pod_cd:'input',		por_cd:'input',		 del_cd:'input',	 del_ofc_cd:'input',	 	obl_ofc_cd:'input',	
	    						 b_ofc_cd:'input', 		b_ofc_cd_1:'input',	 sal_ofc_cd:'input', bl_ofc_cd:'input',	 obl_rcv_ofc_cd:'input',	by_cd:'select',
	    						 staff_id:'input',	 	bkg_bl_cd:'radio',	 bkg_bl_no:'input',	 cust_tp_cd:'multi',		cust_cnt_cd:'input',
	    						 cust_seq:'input',		cust_nm:'input',	 sc_rfa_cd:'radio',	 sc_rfa_no:'input',	 		bl_type_ori:'check',	
	    						 bl_type_way:'check',	bl_type_web:'check'
	           					}
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var ofc_flg = "N";
 
 var prefix = "";//IBSheet 구분자
 
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt = 0;
 var comboObjects = new Array();
 var b_staff_idMultiComboDataAdded = false;
 var l_rep_idMultiComboDataAdded = false;
   /*********************** EDTITABLE MULIT COMBO END ********************/
 	
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
      * ComComboObject생성자 메소드에서 호출됨 
	 	 	* param : comboObj ==> 콤보오브젝트
	 	 	* 
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
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }
		    
		      //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    	
	 	    //setItemOptionHidden();//Item Option Hidden 처리
		    initControl();
		     if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
            	ComBtnDisable("btn_New");
		     }
		    
		    
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		     //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		    setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
		 		
     }


	/**
	 	 * Combo 기본 설정 
	 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject = document.form
 				initComboEditable(comboObj, comboId)
	 	}
	 	
	 	  //콤보 멀티 셀렉트 및 수정 여부 초기 설정
	 	 function initComboEditable(combo, comboId){
		 	 	with (combo) {
			 	 		MultiSelect = false;
			 	 		UseAutoComplete = true; 
				 	  UseEdit = false;
				 	  if(comboId == "cust_tp_cd" ){
				 	  	DropHeight = 300; 
					 	  ColCnt =2;
					 	  ColBackColor(1) = "255,255,255";
				 	  }
		 	 	}
	 	 } 	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
    
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	       
             
	      default:
	    }
	} 
	
	
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
				break;
				
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
				break;
				
				
			default:
				break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  

	

	  /**
	 * HTML Control의 change을 제어한다.
	 **/
	function bkg_change() {
		
		var formObj = document.form;
		    switch (event.srcElement.getAttribute("name")) {
		    	case "b_ofc_cd_1":
		  			document.form.b_ofc_cd.value = document.form.b_ofc_cd_1.value;	  					
		  			changeObjectColor("N", "Y", "btn_multi_ofc", "blue", "btn2");
		  			ofc_flg = "N";
					break;	    	   		
				default:
					break;
		    }
	}  
/*********************** KEY EVENT END ********************/
  

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;
		var tempSqlCon = "";
		var nullMultiComboStr = "<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_dura_date":
		 					var cal = new ComCalendarFromTo();
							cal.select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
					 	break;	
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 					
		 				case "btn_Save":
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 							 					
		 				case "btn_OK":
		 					opener.setSearchOption(getValidCondition(FormQueryString(formObject)));
		 					self.close();
		 					break;
		 				case "btn_New":
		 					initAll(formObject);
		 					//sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_multi_ofc":
//		 					bkgOfcListPopUp();
		 					comBkgCallPop1156('callBack1156', formObject.b_ofc_cd_1.value);
		 					break;
		 				case "btn_Close":
		 					self.close();
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



   // Sheet관련 프로세스 처리
     var arrMultiCombo;//멀티콤보 세팅할 변수
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case SEARCH01:      //조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0647GS.do", FormQueryString(formObj));
							arrMultiCombo = sXml.split("|$$|");	
							initAll(formObj);
							initReportType();
							setCondition(tempform.report_type.Code);
							if(form.dura_opt.Code==""){
								form.dura_opt.Code = "VE";
							}

						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
						  
							break;

 						case IBSEARCHAPPEND:  // 페이징 조회
						case IBINSERT:      // 입력					
							sheetObj.DataInsert(-1);
							break;
					
			
			    }
     }
     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	return true;
    	switch(sAction) {
    		case IBSEARCH:
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
     
	 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
   function initSheet(sheetObj,sheetNo) {}
	
/*############################# combo onchage start ########################*/
/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
	 * 입력값을 upper로 변경하여 재등록 한다.
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj) {
		initAll(document.form);
		setCondition(comboObj.Code); 
	}
	
	 
/*############################# combo onchage end ########################*/		

	 /*
	  * 파라메터로 넘겨받은 Report Template의 이름
	  * 초기 Report Type을 세팅함.
	  */
	var paramReportName="";
	
	/*
	 * 모든 조건 값들을 초기화 한다.
	 * */
	function initAll(formObject){
 		var formObj = document.form;
		form.reset();
		/*CUSTOMER TYPE*/								
		ComXml2ComboItem(arrMultiCombo[0], formObj.cust_tp_cd, "val", "name");
		/*BL Status*/								
		ComXml2ComboItem(arrMultiCombo[1], formObj.bl_sts_cd, "val", "name");
		/*Duration*/								
		ComXml2ComboItem(arrMultiCombo[2], formObj.dura_opt, "val", "name");
		
		if(form.dura_opt.Code==""){
			form.dura_opt.Code = "VE";
		}
	}
	
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[3], tempform.report_type, "sql_ctnt_col_nm", "rpt_nm");
		var arr = ComBkgXml2Array(arrMultiCombo[3], "rpt_nm");
		var chkRptTypeFlg = false;
		for(var index=0; index<arr.length; index++) {
			if(arr[index] == paramReportName){
				chkRptTypeFlg  = true;
				tempform.report_type.Index = index;
			}
		}
		if(!chkRptTypeFlg){
			tempform.report_type.Text2 = arr[0];
		}
	}

    /**
     * condition setting
     */ 
  function setCondition(sqlCtnt){
  	var arrSqlCtnt = sqlCtnt.URLDecode().split("|");
   	var formNameValue ; 
  	var field;
  	try{
	   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
	   			formNameValue = arrSqlCtnt[i].split("=");
	   			if(formNameValue[1] =="") continue;
	   			if(arrFormElementMap[formNameValue[0]] == "check"){
						eval("form."+formNameValue[0]).checked = true;
						
					}else if(arrFormElementMap[formNameValue[0]] == "radio"){
						field = eval("form."+formNameValue[0]);
							for(var j = 0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].checked = true;
									break;
								}
									
							}
							
					}else if(arrFormElementMap[formNameValue[0]] == "select"){
						field = eval("form."+formNameValue[0]);
							for(var j = 0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].selected = true;
									break;
								}
							}
							
					}else if(arrFormElementMap[formNameValue[0]] == "combo"){
						eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
					}else if(arrFormElementMap[formNameValue[0]] == "multi"){
						eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
					}else{
						field = eval("form."+formNameValue[0]);
						field.value=formNameValue[1];
						if(field.name == "b_ofc_cd"){
							if(field.value!=null&&field.value!=""&&field.value.length>5){
								ofc_flg = "Y";
								changeObjectColor("Y", "Y", "btn_multi_ofc", "blue", "btn2");
							}
						}
	   			}
	   	}//end for
  	}catch(e){}

			
  }


	/**
  * 조건 중 값이 없는 것은 제거한다. 
  */ 
  function getValidCondition(sql){
  	
  	var arrSqlCtnt = sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql = ""; 
   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue = arrSqlCtnt[i].split("=");
   			if(formNameValue[1] == undefined || formNameValue[1] == "") continue;
   			
   			returnSql += formNameValue[0]+"="+formNameValue[1].URLEncode()+"|";
   			
   	}//end for
   	
   	return returnSql;
  }
   
  
  function comBkgCallPop1156(callback_func, bkg_ofc) {
		var param = "?bkg_ofc=" + bkg_ofc;
		ComOpenPopup('ESM_BKG_1156.do' + param, 230, 345, callback_func, "0,1,1,1,1", true);
	}
  
  
  function callBack1156(rArray) {
		var formObj = document.form;
		var bkgOfcList = "";
		for(i = 0 ; i < rArray.length ; i++){
			if(rArray[i][0] != "D"){
   			bkgOfcList = bkgOfcList + ',' + rArray[i][2];    				
			}
		} 

		if(bkgOfcList.substring(0,1) == ",")
			bkgOfcList = bkgOfcList.substring(1);
		if(bkgOfcList != "")
			changeObjectColor("Y", "Y", "btn_multi_ofc", "blue", "btn2");	 
		
		formObj.b_ofc_cd.value = bkgOfcList;
		formObj.b_ofc_cd_1.value = rArray[0][2];
		ofc_flg = "Y";
	}
  
  
  function setSchKey(val){ // Radio Click 시 data clear
 	 var formObj = document.form;
 	 
 	 if (val == "BKG"){
 		 
 		 formObj.vvd_cd.value ="";
 		 formObj.pol_cd.value ="";
 	 }
 	 if (val == "BL"){

 		 formObj.vvd_cd.value ="";
 		 formObj.pol_cd.value ="";
 	 }
 	 
  }
	/* 개발자 작업  끝 */    
										
		