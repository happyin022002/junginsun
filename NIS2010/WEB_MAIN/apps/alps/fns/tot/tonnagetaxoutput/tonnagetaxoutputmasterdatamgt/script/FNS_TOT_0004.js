/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_004.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.27 장창수
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
     * @class fns_tot_004 : fns_tot_004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0004() {
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
	var closing_yn = "N";
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetTrdComboByLane = new Array();
	var sheetByClicks = "";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	     var sheetObject1 = sheetObjects[0];
	     /*******************************************************/
	     var formObject = document.form;
	     var prefix = "sheet1_";
	
	     try {
	         var srcName = window.event.srcElement.getAttribute("name");
	
	         switch(srcName) {
	             case "btn2_Row":
	
	                 var inx = sheetObject1.DataInsert(-1);
	                 
	                 formObject.stl_yrmon.value = ComReplaceStr(formObject.c_stl_yrmon,"-","");
	                 
	                 sheetObject1.CellValue(inx, prefix+"delt_flg") = "N";
	                 sheetObject1.CellValue(inx, prefix+"stl_yrmon") = formObject.stl_yrmon.value;
	                 sheetObject1.CellValue(inx, prefix+"sts_flg") = "I";
	                 sheetObject1.CellComboItem(inx, prefix+"trd_cd1", "", "");	
	                 sheetObject1.CellComboItem(inx, prefix+"trd_cd2", "", "");	
	                 sheetObject1.CellComboItem(inx, prefix+"trd_cd3", "", "");	
	                 
	                 sheetObject1.SelectCell(inx, prefix+"vsl_slan_cd", true);
	                 break;
	
				 case "btn2_Delete":
	                
	                 ComRowHideDelete(sheetObject1, prefix+"del_chk");
	                 break;
	
				 case "btn1_Retrieve":
					 formObject.stl_yrmon.value = ComReplaceStr(formObject.c_stl_yrmon,"-","");
	                 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	                 break;
	
				 case "btn1_New":
	                 
					 setDate();
	    			 formObject.rc_dt.value = "";
	    			 
	         		 sheetObject1.RemoveAll();
	         		 
	                 break;
	
				 case "btn1_Copy":
					 formObject.stl_yrmon.value = ComReplaceStr(formObject.c_stl_yrmon,"-","");   
	                 doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
	                 break;
	                 
				 case "btn1_Save":
					 formObject.stl_yrmon.value = ComReplaceStr(formObject.c_stl_yrmon,"-","");
	                 doActionIBSheet(sheetObject1,formObject,IBSAVE);
	                 break;
	
				 case "btn1_Down_Excel":
	                 
					 sheetObject1.SpeedDown2Excel(-1);
	                 break;
	
					case "btns_back":
	
		                 if(formObject.c_stl_yrmon.value == null || formObject.c_stl_yrmon.value == ""){
		                	 
		                	 ComShowCodeMessage('TOT00003');
		                	 return;
		                 }
		                 formObject.c_stl_yrmon.value = ComGetDateAdd(formObject.c_stl_yrmon.value+"-01","M",-1).substring(0,7);
		                 document.form.rc_dt.value = "";
		                 setCloseYn();
	
						break;
	
					case "btns_next":
						
		                 if(formObject.c_stl_yrmon.value == null || formObject.c_stl_yrmon.value == ""){
		                	 
		                	 ComShowCodeMessage('TOT00003');
		                	 return;
		                 }
		                 formObject.c_stl_yrmon.value = ComGetDateAdd(formObject.c_stl_yrmon.value+"-01","M", 1).substring(0,7);
		                 document.form.rc_dt.value = "";
		                 setCloseYn();
		                 
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
	  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	  * @param {ibsheet} sheetObj    IBSheet Object
	  * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
    function initControl() {
	 	//** Date 구분자 **/
	 	DATE_SEPARATOR = "-";
	 	var formObject = document.form;
	 	
	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress','obj_keypress', form);    
	    axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    
	
		axon_event.addListener  ('blur'  , 'c_stl_yrmon_onblur', 'c_stl_yrmon');//- customer code 입력 후 name 가져오기
	    axon_event.addListenerFormat('click'           , 'obj_onclick'  , 	form);
    }


	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	}
	
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	
	//stl_yr 변경시 조회 
	function c_stl_yrmon_onblur(){
	 	//alert("c_stl_yrmon_onblur");
	 	var formObject = document.form;
	
			if (formObject.c_stl_yrmon.value ==null || formObject.c_stl_yrmon.value ==""){
				
				ComShowCodeMessage('TOT00003');
				ComSetFocus(formObject.c_stl_yrmon);
				
				return false;
			}
	
	     setCloseYn();
	     formObject.stl_yrmon.value = ComReplaceStr(formObject.c_stl_yrmon,"-","");
	     
	         
	}
   
	function sheet1_OnChange(sheetObj,Row, Col, Value){     

	 	 if(Col == 3){
	 		//alert("sheet1_OnChange ");
	 		var prefix = "sheet1_";
	 		var laneCheck = setLaneCheck(sheetObj, Row, Col);
	 		//alert("laneCheck ::: "+laneCheck);
	 		
	 		if(laneCheck){
	 			
	 			setTradeCdByLane(sheetObj, Row, Col);
	 			
	 		}else{
	 			
	 			 sheetObj.CellComboItem(Row, prefix+"trd_cd1", "", "");	
	 			 sheetObj.CellComboItem(Row, prefix+"trd_cd2", "", "");	
	 			 sheetObj.CellComboItem(Row, prefix+"trd_cd3", "", "");	
	 			
	 		}
	
	   		if(sheetObj.CellValue(Row, prefix+"sts_flg") == "I" && sheetObj.CellValue(Row, prefix+"erp_slan_cd") != ""){
	    			
	    			//alert("전 : "+sheetObj.RowStatus(Row));
	    			sheetObj.RowStatus(Row) = "I";
	    		
	    			//alert("후 : "+sheetObj.RowStatus(Row));
	
	    	}
	   	
	 	  }
	}   
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		    case "ym":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		    break;
		}
	}

	function form_keyup(){
			ComKeyEnter('lengthnextfocus');
	}   
	
	function sheet1_OnClick(sheetObj,Row, Col, Value){     
		  var prefix = "sheet1_";
		 	 if(Col == 5 || Col == 6 || Col == 7){
		 		//alert("nClick ");
		 		 setTradeCdByLane(sheetObj, Row, Col);
		 		 
		 	 }else if(Col == 1){
		 		
		 		 if(sheetObj.CellValue(Row,Col) == 0 && sheetObj.CellValue(Row, prefix+"sts_flg") == "I"){
		 			
		 			sheetObj.RowStatus(Row) = "I";
		 			
		 		 }else if(sheetObj.CellValue(Row,Col) == 1 && sheetObj.CellValue(Row, prefix+"sts_flg") == "I"){
			 		
			 			sheetObj.RowStatus(Row) = "R";
			 			
			 	}	
		 	 }
	}
	
	function setDate(){
		var today=new Date();
		var y = today.getFullYear().toString();
		var m = today.getMonth();
			
		if(m<10){
			m = "0"+m;
		}
		
		document.form.c_stl_yrmon.value = y+"-"+m;    	
	}

	/*
	 * 팝업으로 LANE코드 입력시 해당 LANE코드의 LANE코드가 있는지 확인한다. <br>
	 */
 
	function setLaneCheck(sheetObj, row, col){
		// alert("setLaneCheck");
		 var formObj = document.form;
		 formObj.f_cmd.value = SEARCHLIST04;
		 
		 var prefix = "sheet1_";	//prefix 문자열 배열
	
		 formObj.vsl_slan_cd.value = sheetObj.CellText(row, prefix+"vsl_slan_cd");
		 var sXml = sheetObj.GetSearchXml("TOTCommonGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	
		 if(ComGetEtcData(sXml,"laneCd") == ""){
			    ComShowCodeMessage('TOT00020');
				sheetObj.CellValue2(row,prefix+"vsl_slan_cd") = "";
				sheetObj.SelectCell(row,prefix+"vsl_slan_cd",true);
	            return false;
		 }
	    // alert(ComGetEtcData(sXml,"laneCd"));
	     sheetObj.CellValue2(row,col) = ComGetEtcData(sXml,"laneCd");
	
	     return true;
	}    
 
    /*
     * 팝업으로 lane 셑팅시 lane에 해당하는 trade code를 콤보에 셑팅한다. 
     */
   
    function setTradeCdByLane(sheetObj, row, col){
  	 
	  	 var formObj = document.form;
	  	 var prefix = "sheet1_";
	  	 
	  	 var laneCd = sheetObjects[0].CellValue(row,prefix+"vsl_slan_cd");
	  	 var trdComboItem = "";
	  	 var trdComboList = "| ";
	  	 var comboItem = sheetByClicks.split("|");
	
	  	
	  	 for(var i=1; i<comboItem.length; i++){
	  		//alert("comboItems ::");
	  		
	  		trdComboItem = comboItem[i].split(",");
	  		//alert("trdComboItem ::: "+trdComboItem);
	  		
	  		if(laneCd == trdComboItem[0]){
	  			//alert("trdComboItem[1] ::: "+trdComboItem[1]);
	  			trdComboList = trdComboList +"|"+trdComboItem[1];
	  		}
	  	 }
	 
		 sheetObj.CellComboItem(row, prefix+"trd_cd1", trdComboList, trdComboList);	
		 sheetObj.CellComboItem(row, prefix+"trd_cd2", trdComboList, trdComboList);	
		 sheetObj.CellComboItem(row, prefix+"trd_cd3", trdComboList, trdComboList);	
	
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
    function loadPage(trdSheetByOnload,trdSheetByClick,stlClzFlg) {

     	 var formObj = document.form;
         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1, trdSheetByOnload);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         sheetByClicks = trdSheetByClick;

         formObj.stl_yrmon.value = ComReplaceStr(formObj.c_stl_yrmon.value,"-","");

          initControl();

        // alert(stlClzFlg);
         closing_yn = stlClzFlg;
     	 if(closing_yn == "Y"){
     		ComBtnDisable("btn1_Save");
     	 }else{
     		ComBtnEnable("btn1_Save");
     	 }

    }

    function sheet1_OnPopupClick(sheetObj,Row,Col){
      	ComOpenPopup("/hanjin/COM_ENS_081.do", 1018, 590, "setLaneName", "1,0,1,1,1", false, false, Row, "sheet1_vsl_slan_cd", 0);
    }

    /*
     * 팝업에서 전달된 선박코드와 명을 해당 sheet에 셋팅한다. 
     */
  	 
    function setLaneName(aryPopupData, row, col, sheetIdx){

     	sheetObjects[sheetIdx].CellValue2(row,col) = aryPopupData[0][3];
    	
    }

     
    /*
     * 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.
     */

    function setCloseYn(){
     	
     	var formObj = document.form;

     	var stlYr = formObj.c_stl_yrmon.value;

     	formObj.f_cmd.value = SEARCHLIST02;
     	formObj.stl_yr.value = stlYr.substr(0,4);
 		var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj));

 		closing_yn = ComGetEtcData(sXml,"stlClzFlg");
 		
 		if(closing_yn == "Y"){
 			
 			ComBtnDisable("btn1_Save");
 		}else{
 			ComBtnEnable("btn1_Save");
 		}
 		
 		sheetObjects[0].RemoveAll(); 
    }  
    
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo,trdSheetByOnload) {
         
         var cnt = 0;

         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 424;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "|Sel|Erp Lane|Lane|Bsa Lane|Trade1|Trade2|Trade3|Description|||||||||";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     var prefix = "sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
         			 InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true , prefix+"del_chk"  );                   
                     InitDataProperty(0, cnt++, dtData,			100,		daCenter,	true,	prefix+"erp_slan_cd",			false,		"",       dfNone, -1, false ,false, 3);
         			 InitDataProperty(0, cnt++, dtPopupEdit,			100,		daCenter,	true,	prefix+"vsl_slan_cd",			true,		"",       dfEngUpKey, -1, false ,true, 3);
                     InitDataProperty(0, cnt++, dtData,			100,		daCenter,	true,	prefix+"bsa_slan_cd",			false,		"",       dfNone, -1, false ,false, 3);
         			 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd1",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd2",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd3",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtData,			0,			daLeft,		true,	prefix+"lane_rmk",	false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,			daLeft,		true,	prefix+"stl_yrmon",	false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,			daLeft,		true,	prefix+"delt_flg",	false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd1_seq",	false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd2_seq",	false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd3_seq",	false,		"",       dfNone);
                     InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd1",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd2",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd3",		false,		"",       dfNone);
					 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"sts_flg",		false,		"",       dfNone);

	                 InitDataValid(0, prefix+"vsl_slan_cd"     , vtEngUpOther , "1234567890" );//영문대문자
                     //InitDataValid(0, prefix+"lane_rmk" , vtEngOther,"1234567890!@#$%^&*()-=_+|\?\",.':;~`" );

					 trdSheetByOnload = " |"+trdSheetByOnload
					 InitDataCombo(0, prefix+"trd_cd1"     , trdSheetByOnload, trdSheetByOnload);	
					 InitDataCombo(0, prefix+"trd_cd2"     , trdSheetByOnload, trdSheetByOnload);
					 InitDataCombo(0, prefix+"trd_cd3"     , trdSheetByOnload, trdSheetByOnload);

					 
             }
                 break;
             case 2:      // t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
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
                 InitRowInfo( 1, 1, 10, 100);

                 var HeadTitle1 = "|Sel|Lane|Trade1|Trade2|Trade3|Description||||||||";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 
                 var prefix = "sheet2_";
                 
                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     			 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
     			 InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true , prefix+"del_chk"  );                   
                 InitDataProperty(0, cnt++, dtPopupEdit,			100,		daCenter,	true,	prefix+"vsl_slan_cd",			false,		"",       dfEngUpKey, -1, false ,true, 3);
                 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd1",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd2",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtCombo,			100,		daCenter,	true,	prefix+"trd_cd3",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtData,			0,			daLeft,		true,	prefix+"lane_rmk",	false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,			daLeft,		true,	prefix+"stl_yrmon",	false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,			daLeft,		true,	prefix+"delt_flg",	false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd1_seq",	false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd2_seq",	false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,			daCenter,		true,	prefix+"trd_cd3_seq",	false,		"",       dfNone);
                 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd1",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd2",		false,		"",       dfNone);
				 InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,	true,	prefix+"old_trd_cd3",		false,		"",       dfNone);

                 InitDataValid(0, prefix+"vsl_slan_cd"     , vtEngUpOnly  );//영문대문자
                 //InitDataValid(0, prefix+"lane_rmk" , vtEngOther,"1234567890!@#$%^&*()-=_+|\?\",.':;~`" );

				 trdSheetByOnload = " |"+trdSheetByOnload
				 InitDataCombo(0, prefix+"trd_cd1"     , trdSheetByOnload, trdSheetByOnload);	
				 InitDataCombo(0, prefix+"trd_cd2"     , trdSheetByOnload, trdSheetByOnload);
				 InitDataCombo(0, prefix+"trd_cd3"     , trdSheetByOnload, trdSheetByOnload);

				 
         }
             break;
                 
       }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
             case IBSEARCH:      //조회
		             if (validateForm(sheetObj, formObj, sAction)){
		             	
		                 if ( sheetObj.id == "sheet1"){
		     				formObj.f_cmd.value = SEARCH;
		     				 var prefix = "sheet1_";	//prefix 문자열 배열
		
			    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0004GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		
			    			sheetObjects[0].LoadSearchXml(sXml);
			    			
			    			formObj.rc_dt.value = ComGetEtcData(sXml,"recentDt");

					    	for(var i=1; i<=sheetObjects[0].RowCount; i++){
					    		
					    		if(sheetObjects[0].CellValue(i, prefix+"vsl_slan_cd") == null || sheetObjects[0].CellValue(i, prefix+"vsl_slan_cd") == ""){
					    			sheetObjects[0].CellEditable(i,prefix+"vsl_slan_cd") = true;
					    		//	sheetObjects[0].CellEditable(i,prefix+"del_chk") = false;
					    		}
				            }
					 
		                 }
		                 
		             }


                 break;

              case IBSAVE:        //저장
     
	              if(closing_yn == "N"){
			     		if (validateForm(sheetObj, formObj, sAction)){
			     			var prefix = "sheet1_";
			    			var SaveStr = ComGetSaveString(sheetObjects);
			    			if (SaveStr == ""){
			    				ComShowCodeMessage('TOT00011');
			    				return;
			    			}
			    			
			    			if (!ComShowCodeConfirm('TOT00004')){
			    				return;
			    			}

		                	sheetObj.WaitImageVisible=false;
		                	ComOpenWait(true);
		                	
			    			formObj.f_cmd.value = MULTI;
			    		
			    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
			    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0004GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			sheetObj.LoadSaveXml(sXml);
			    			ComOpenWait(false);
			    			
			    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			    		}
	              }

                 break;

              case IBSEARCH_ASYNC01:        //copy
              
              if(closing_yn == "N"){
		     		if (validateForm(sheetObj, formObj, sAction)){
		     			var prefix = "sheet1_";
		    			
		    			if (!ComShowCodeConfirm('TOT00085')){
		    				return;
		    			}
	                	sheetObj.WaitImageVisible=false;
	                	ComOpenWait(true);
	                	
		    			formObj.f_cmd.value = MULTI01;
		    		
		    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
		    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0004GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		    			//sheetObj.LoadSaveXml(sXml);
		    			ComOpenWait(false);
		    			
		    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    		}
              }

             break;                 
         }
    }



    /**
     * 아이비시트 팝업 클릭시 이벤트
     */
    function t1sheet1_OnPopupClick(sheetObj, Row,Col,Value)
    {
         switch(sheetObj.ColSaveName(Col)) {
             case "MDate":
                 alert("MDate_popup_click");
                 break;
         }
    }

    /*
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    		sheetObj.ShowDebugMsg = false;
    		var formObject = document.form;
    		var prefix="sheet1_";
    		switch (sAction) {

			
			   case IBSEARCH: //조회
					if (formObject.c_stl_yrmon.value ==null || formObject.c_stl_yrmon.value ==""){
						ComShowCodeMessage('TOT00001');
						ComSetFocus(formObject.c_stl_yrmon);
						return false;
					}
		
				break;
				
    			case IBSAVE:   //저장
    				for(var inx=1; inx<=sheetObj.LastRow; inx++){
    					//수정되지 않은 값은 skip
    					if (sheetObj.CellValue(inx,prefix+"ibflag")=="R"){
    						continue;
    					}
    					if (sheetObj.CellValue(inx,prefix+"vsl_slan_cd").length < 3){
    						ComShowCodeMessage('TOT00021');
    						sheetObj.SelectCell(inx,prefix+"vsl_slan_cd",true);
    						return false;
    					}
                        if(!(sheetObj.CellValue(inx,prefix+"trd_cd1")== "" || sheetObj.CellValue(inx,prefix+"trd_cd2") == "")){
	    					if (sheetObj.CellValue(inx,prefix+"trd_cd1")== sheetObj.CellValue(inx,prefix+"trd_cd2")){
	    						ComShowCodeMessage('TOT00022');
	    						sheetObj.SelectCell(inx,prefix+"trd_cd1",true);
	    						return false;
	    					}
    				    }
                        if(!(sheetObj.CellValue(inx,prefix+"trd_cd1")== "" || sheetObj.CellValue(inx,prefix+"trd_cd3") == "")){

		    			        if (sheetObj.CellValue(inx,prefix+"trd_cd1")== sheetObj.CellValue(inx,prefix+"trd_cd3")){
		    			        	ComShowCodeMessage('TOT00023');
		    						sheetObj.SelectCell(inx,prefix+"trd_cd1",true);
		    						return false;
		    					}
    					}
                        if(!(sheetObj.CellValue(inx,prefix+"trd_cd2")== "" || sheetObj.CellValue(inx,prefix+"trd_cd3") == "")){
		    					if (sheetObj.CellValue(inx,prefix+"trd_cd2")== sheetObj.CellValue(inx,prefix+"trd_cd3")){
		    						ComShowCodeMessage('TOT00024');
		    						sheetObj.SelectCell(inx,prefix+"trd_cd2",true);
		    						return false;
		    					}
                        } 
                        
    					if (sheetObj.CellValue(inx,prefix+"ibflag")=="I"){
                            for(var j=1; j<=sheetObj.LastRow; j++){
                            	if(j != inx){
   	        						if (sheetObj.CellValue(j,prefix+"vsl_slan_cd") == sheetObj.CellValue(inx,prefix+"vsl_slan_cd")){
   	        							//alert(inx+"와 "+j);
   	        							ComShowCodeMessage('TOT00081',sheetObj.CellValue(inx,prefix+"vsl_slan_cd"));
   	        							sheetObj.SelectCell(inx,prefix+"vsl_slan_cd",true);
    	        						return false;
    	        					}	
    	        					
                            	}
                            }
    						
    					}                        

    					
    				}
    				break;
    				
    			default:
    				break;
    		}
    		return true;

    }
	