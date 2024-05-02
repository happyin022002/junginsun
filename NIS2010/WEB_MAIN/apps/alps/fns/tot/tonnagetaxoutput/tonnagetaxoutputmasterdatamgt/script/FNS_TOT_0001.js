/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_001.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class fns_tot_001 : fns_tot_001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }

	 // 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var prefix="sheet1_";
	var closing_yn = "N";
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
                     //alert("btn2_Row");
                     var inx = sheetObject1.DataInsert(-1);
                    //sheetObject1.DataInsert(-1);
                     sheetObject1.CellValue(inx, prefix+"delt_flg") = "N";
                     sheetObject1.CellValue(inx, prefix+"stl_yr") = formObject.stl_yr.value;
                     //alert(formObject.tong_flet_tp_cd.Code);
                     sheetObject1.CellValue(inx, prefix+"tong_flet_tp_cd") = formObject.tong_flet_tp_cd.Code;
                     sheetObject1.SelectCell(inx,prefix+"vsl_cd",true);
                     break;

 				 case "btn2_Delete":
                     
                     ComRowHideDelete(sheetObject1, prefix+"del_chk");
                     break;

 				 case "btn1_Retrieve":
                     
                     doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                     break;

 				 case "btn1_New":
                    
	    			 formObject.tong_flet_tp_cd.value = "O";
	    			 setDate();
	    			 document.form.rc_dt.value = "";
	         		 sheetObject1.RemoveAll();
                     break;

 				 case "btn1_Save":
                    
                     doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;

 				 case "btn1_Down_Excel":
                    
 					sheetObject1.SpeedDown2Excel(-1);
                     break;
                     
 				 case "btns_back_yr":
                     if(document.form.stl_yr.value == null || document.form.stl_yr.value == ""){
                    	 ComShowCodeMessage('TOT00001');
                    	 return;
                     }
                     document.form.stl_yr.value = parseInt(document.form.stl_yr.value)-1;
                     document.form.rc_dt.value = "";
                     setCloseYn();
                     break;
 				 case "btns_next_yr":
                     if(document.form.stl_yr.value == null || document.form.stl_yr.value == ""){
                    	 ComShowCodeMessage('TOT00001');
                    	 return;
                     }
                     document.form.stl_yr.value = parseInt(document.form.stl_yr.value)+1;
                     document.form.rc_dt.value = "";
                     setCloseYn();
                     break;
				case "btn1_Create":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
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

     /*
     * 팝업으로 선박코드 입력시 해당 선박코드의 계약시작일자와 종료일자를 조회하여 
     * FMS_Del_date와 FMS_Re_Del_date에 셋팅한다. <br> 
     */
     
     function setVslDelivery(sheetObj, row, col){
    	 
    	 var formObj = document.form;
    	 formObj.f_cmd.value = SEARCHLIST01;
    	 
		 var prefix = "sheet1_";	//prefix 문자열 배열

		 formObj.vsl_cd.value = sheetObj.CellText(row, "sheet1_vsl_cd");
    	 var sXml = sheetObj.GetSearchXml("TOTCommonGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

    	 if(ComGetEtcData(sXml,"vslEngNm") == ""){
    		 ComShowCodeMessage('TOT00012',row);				
				sheetObj.CellValue2(row,prefix+"vsl_cd") = "";
				sheetObj.SelectCell(row,prefix+"vsl_cd",true);
                return;
    	 }
         
         sheetObj.CellValue2(row,col+2) = ComGetEtcData(sXml,"vslEngNm");
         sheetObj.CellValue2(row,col+5) = ComGetEtcData(sXml,"effDt");
         sheetObj.Cellvalue2(row,col+6) = ComGetEtcData(sXml,"expDt");
  
     }   
     
     /** 팝업에서 전달된 선박코드와 명을 해당 sheet에 셋팅한다. */
	 
     function setVslName(aryPopupData, row, col, sheetIdx){

    	sheetObjects[sheetIdx].CellValue2(row,col) = aryPopupData[0][3];
     	
     	setVslDelivery(sheetObjects[sheetIdx], row, 2);
     	
     }

     /*
     * 팝업이 아닌 선박코드 수기 입력시 호출하여 선박명, FMS_Del_date와 FMS_Re_Del_date에 셋팅한다. <br>
     */    
     function sheet1_OnChange(sheetObj,Row, Col, Value){  
    	 
    	 var prefix = "sheet1_";
    	 var sName = sheetObj.ColSaveName(Col);
    	 if(sName ==  (prefix+"vsl_cd")){
    		
    		 setVslDelivery(sheetObj, Row, Col);
    	 }else if(sName == (prefix+"ctrt_st_dt")){
    		
    		if (sheetObj.CellValue(Row,prefix+"ctrt_st_dt").length < 8){
				ComShowCodeMessage('TOT00013');
				sheetObj.SelectCell(Row,prefix+"ctrt_st_dt",true);
				return false;
			}
           	if (sheetObj.CellValue(Row,prefix+"ctrt_end_dt") != "" && (sheetObj.CellValue(Row,prefix+"ctrt_st_dt")> sheetObj.CellValue(Row,prefix+"ctrt_end_dt"))){
           		ComShowCodeMessage('TOT00015');
				sheetObj.CellValue2(Row,Col) = "";
				sheetObj.SelectCell(Row,prefix+"ctrt_st_dt",true);
				return false;
			}
    	 }else if(sName ==  (prefix+"ctrt_end_dt")){
            	if (sheetObj.CellValue(Row,prefix+"ctrt_end_dt") != "" && (sheetObj.CellValue(Row,prefix+"ctrt_st_dt")> sheetObj.CellValue(Row,prefix+"ctrt_end_dt"))){
            		ComShowCodeMessage('TOT00016');
    				sheetObj.CellValue2(Row,Col) = "";
    				sheetObj.SelectCell(Row,prefix+"ctrt_end_dt",true);
    				return false;
    			}    		 
    	 }
    		 
     }    
          
     function sheet1_OnPopupClick(sheetObj,Row,Col){
     	ComOpenPopup("/hanjin/COM_ENS_0A1.do", 618, 480, "setVslName", "1,0,1,1,1", false, false, Row, "sheet1_vsl_cd", 0);
     }
     
     function setDate(){
 		var today=new Date();
 		var y = today.getFullYear().toString();
 		document.form.stl_yr.value = y;    	
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
  	
    /*
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     */
    function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "/";
     	var formObject = document.form;
     	
     	setDate();

     	//Axon 이벤트 처리1. 이벤트catch
   	  	 axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   	  	 axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	 axon_event.addListener  ('keypress', 'stl_yr_keypress' , 'stl_yr');			//- Vessel Code 입력 시 영문 대문자만 입력하기
         axon_event.addListener  ('blur'  , 'stl_yr_onblur', 'stl_yr');//- customer code 입력 후 name 가져오기
         axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObject);    

         //  axon_event.addListener  ('blur'  , 'tong_flet_tp_cd_onChange', 'tong_flet_tp_cd');//- customer code 입력 후 name 가져오기

     }
      
    function form_keyup(){
    		ComKeyEnter('lengthnextfocus');
    }      
   
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
     
    /*
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
      
    function setSheetObject(sheet_obj){
         sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.*/

    function setCloseYn(){
    	
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCHLIST02;

		var sXml = sheetObjects[1].GetSearchXml("TOTCommonGS.do", FormQueryString(formObj));

		closing_yn = ComGetEtcData(sXml,"stlClzFlg");
		
		if(closing_yn == "Y"){
			
			ComBtnDisable("btn1_Save");
		}else{
			ComBtnEnable("btn1_Save");
		}
		
		sheetObjects[0].RemoveAll(); 
    }

    function stl_yr_keypress(){
    	ComKeyOnlyNumber(event.srcElement);
    }

 
    function tong_flet_tp_cd_OnChange(idx_cd, text){
    	
    	document.form.rc_dt.value = "";
    	sheetObjects[0].RemoveAll(); 
    }
 
    
    //stl_yr 변경시 조회 
    function stl_yr_onblur(){
    	
    	var formObject = document.form;

		if (formObject.stl_yr.value ==null || formObject.stl_yr.value ==""){
			
			ComShowCodeMessage('TOT00001');
			ComSetFocus(formObject.stl_yr);
			
			return false;
		}

        setCloseYn();
            
    }
    
    /*
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(codeinfoValue,codeinfoText,stlClzFlg) {

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);

             ComEndConfigSheet(sheetObjects[i]);
         }

         for(var k=0;k<comboObjects.length;k++){

             initCombo(comboObjects[k],k+1,codeinfoValue,codeinfoText);
         }


         initControl();
         //alert(stlClzFlg);
         closing_yn = stlClzFlg;
		 if(closing_yn == "Y"){
			ComBtnDisable("btn1_Save");
		 }else{
			ComBtnEnable("btn1_Save");
		 }
		 ComBtnDisable("btn1_Create");

         
    }

    /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo, codeinfoValue,codeinfoText) {
          var formObject = document.form
 
          switch(comboNo) {  
          	case 1: 
                 with (comboObj) { 
      				MultiSelect = false; 
      				UseAutoComplete = true;	
      				SetColAlign("left|left");        
      				SetColWidth("0|30");
  				
       				DropHeight = 160;
       		     }
           
                  var comboItemsValue = codeinfoValue.split("|");
                  var comboItemsText = codeinfoText.split("|");
                  
                  //addComboItem(comboObj, 0, "", ""); 
                  for (var i = 0; i<comboItemsValue.length; i++){
	                  //addComboItem(comboObj, i, comboItemsValue[i], comboItemsText[i]);    
	                  comboObj.InsertItem(i, comboItemsText[i] + "|" + comboItemsText[i], comboItemsValue[i]);
                  }
                  
                  comboObj.index = -1;
       			break; 
       			
          	case 2: 
                  with (comboObj) { 
       				MultiSelect = false; 
       				UseAutoComplete = true;	
       				SetColAlign("left|left");        
       				SetColWidth("0|30");
       				BackColor = "#CCFFFD";
       				FontColor = "#FB1901";
       				ColBackColor(0) = "#CCFFFD";
       				ColFontColor(0) = "#FB1901";
       				ColBackColor(1) = "#CCFFFD";
       				ColFontColor(1) = "#FB1901";					
        				DropHeight = 160;
        		    }
        			break;
        			
          	case 3: 
                  with (comboObj) { 
       				MultiSelect = false; 
       				UseAutoComplete = true;	
       				SetColAlign("left|left");        
       				SetColWidth("0|30");
       				BackColor = "#CCFFFD";
       				FontColor = "#FB1901";
       				ColBackColor(0) = "#CCFFFD";
       				ColFontColor(0) = "#FB1901";
       				ColBackColor(1) = "#CCFFFD";
       				ColFontColor(1) = "#FB1901";					
        			DropHeight = 160;
        		    }
        			break;
       	} 
    }

    /** 콤보필드에 데이터를 추가해준다. */	
    function addComboItem(comboObj, i, comboItemsValue, comboItemsText) {
      
      		//alert("addComboItem ::::: "+i+"번째  "+comboItemsValue+"        "+comboItemsText);

      		comboObj.InsertItem(i, comboItemsText + "|" + comboItemsText, comboItemsValue);
      		
    }
    
   /*
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
            
                  
                  case 1: // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 410;

                      //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "")  InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;


                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     var HeadTitle1 = "|Sel.|Vessel|Seq.|Vessel Name|TOT Del Date|TOT Re-Del Date|FMS and VOSI\nDel Date|FMS and VOSI\n Re-Del Date|Remark|||";
                     var headCount = ComCountHeadTitle(HeadTitle1); 

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     var prefix = "sheet1_";
                     
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
        			 InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true , prefix+"del_chk"  );
                     InitDataProperty(0, cnt++, dtPopupEdit,	    90,		daCenter,		false,	prefix+"vsl_cd",				true,		"",       dfEngUpKey, -1, false ,true, 4);  
                     InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	prefix+"vsl_seq",					false,		"",       dfNone, -1, false ,false);
                     InitDataProperty(0, cnt++, dtData,			135,		daLeft,			false,	prefix+"vsl_eng_nm",		false,		"",       dfNone, -1, false ,false);
                     InitDataProperty(0, cnt++, dtData,			100,		daCenter,		false,	prefix+"ctrt_st_dt",		true,		"", dfDateYmd);
                     InitDataProperty(0, cnt++, dtData,			120,		daCenter,		false,	prefix+"ctrt_end_dt",	false,		"",       dfDateYmd);
                     InitDataProperty(0, cnt++, dtData,			100,		daCenter,		false,	prefix+"eff_dt",		false,		"",       dfDateYmd, -1, false ,false);
                     InitDataProperty(0, cnt++, dtData,			120,		daCenter,		false,	prefix+"exp_dt",	false,		"",       dfDateYmd, -1, false ,false);
                     InitDataProperty(0, cnt++, dtData,			200,		daLeft,			false,	prefix+"vsl_rmk",				false,		"",       dfNone);
                     InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"stl_yr",	false,		"",       dfNone);
                     InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"tong_flet_tp_cd",	false,		"",       dfNone);
                     InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"delt_flg",	false,		"",       dfNone);
                     
                     //InitUserFormat2(0, prefix+"ctrt_st_dt" , "####-##-##", "-|:");
                    // InitUserFormat2(0, prefix+"ctrt_end_dt" , "####-##-##", "-|:");
                    // InitDataValid(0, prefix+"ctrt_st_dt"   , vtNumericOnly); //숫자만
                    // InitDataValid(0, prefix+"ctrt_end_dt"   , vtNumericOnly); //숫자만
                     InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOnly  );//영문대문자
                     //InitDataValid(0, prefix+"vsl_rmk"     , vtEngOther,"1234567890!@#$%^&*()-=_+|\?,.':;\"~`" );
        			 //ShowButtonImage = 2;
                     CountPosition = 0;
                 }
                 break;
                  case 2: // sheet1 init
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 0;

                       //전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "")  InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;


                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(1, 1, 3, 100);

                      var HeadTitle1 = "|Sel.|Vessel|Seq.|Vessel Name|TOT Del Date|TOT Re-Del Date|FMS and VOSI\nDel Date|FMS and VOSI\n Re-Del Date|Remark|||";
                      var headCount = ComCountHeadTitle(HeadTitle1); 

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false);

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);
                      
                      var prefix = "sheet2_";
                      
                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          			 InitDataProperty(0, cnt++, dtStatus,  0, daCenter, true, prefix+"ibflag"   );
         			 InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true , prefix+"del_chk"  );
                      InitDataProperty(0, cnt++, dtPopupEdit,	    90,		daCenter,		false,	prefix+"vsl_cd",				false,		"",       dfEngUpKey, -1, false ,true, 4);  
                      InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	prefix+"vsl_seq",					false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,			250,		daLeft,			false,	prefix+"vsl_eng_nm",		false,		"",       dfNone, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,			100,		daCenter,		false,	prefix+"ctrt_st_dt",		false,		"", dfDateYmd);
                      InitDataProperty(0, cnt++, dtData,			120,		daCenter,		false,	prefix+"ctrt_end_dt",	false,		"",       dfDateYmd);
                      InitDataProperty(0, cnt++, dtData,			100,		daCenter,		false,	prefix+"eff_dt",		false,		"",       dfDateYmd, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,			120,		daCenter,		false,	prefix+"exp_dt",	false,		"",       dfDateYmd, -1, false ,false);
                      InitDataProperty(0, cnt++, dtData,			100,		daLeft,			false,	prefix+"vsl_rmk",				false,		"",       dfNone);
                      InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"stl_yr",	false,		"",       dfNone);
                      InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"tong_flet_tp_cd",	false,		"",       dfNone);
                      InitDataProperty(0, cnt++, dtHidden,			0,		daCenter,		false,	prefix+"delt_flg",	false,		"",       dfNone);
                      
                      //InitUserFormat2(0, prefix+"ctrt_st_dt" , "####-##-##", "-|:");
                     // InitUserFormat2(0, prefix+"ctrt_end_dt" , "####-##-##", "-|:");
                     // InitDataValid(0, prefix+"ctrt_st_dt"   , vtNumericOnly); //숫자만
                     // InitDataValid(0, prefix+"ctrt_end_dt"   , vtNumericOnly); //숫자만
                      InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOnly  );//영문대문자
                      //InitDataValid(0, prefix+"vsl_rmk"     , vtEngOther,"1234567890!@#$%^&*()-=_+|\?,.':;\"~`" );
         			 //ShowButtonImage = 2;
                      CountPosition = 0;
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

		    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

		    			sheetObjects[0].LoadSearchXml(sXml);
		    			
		    			formObj.rc_dt.value = ComGetEtcData(sXml,"recentDt");
		    			

                     }
	                 
                 }

	         break;
                
             case IBSAVE:        //저장
                    if(closing_yn == "N"){
			     		if (validateForm(sheetObj, formObj, sAction)){
			     			
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
			    			var sXml = sheetObj.GetSaveXml("FNS_TOT_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			    			sheetObj.LoadSaveXml(sXml);
			    			ComOpenWait(false);
			    			
			    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			    		}
                    }
             break;

			 case IBSEARCH_ASYNC01:
				if (validateForm(sheetObj, formObj, sAction)) {
					if ( sheetObj.id == "sheet1"){
						sheetObj.WaitImageVisible=false;
		                ComOpenWait(true);
	     				
						formObj.f_cmd.value = MULTI01;
						var prefix = "sheet1_";	//prefix 문자열 배열
						var sXml = sheetObj.GetSaveXml("FNS_TOT_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						var sTrans = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
						sheetObj.LoadSaveXml(sXml);
						//sheetObj.DoSave("FNS_TOT_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						ComOpenWait(false);
						if( sTrans == "S" ) {
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
						} else {
							ComBtnDisable("btn1_Create");
						}
					}
				}
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
					if (formObject.tong_flet_tp_cd.CODE ==null || formObject.tong_flet_tp_cd.CODE ==""){
						ComShowCodeMessage('TOT00046');
						ComSetFocus(formObject.tong_flet_tp_cd);
						return false;
					}
					if (formObject.stl_yr.value ==null || formObject.stl_yr.value ==""){
						ComShowCodeMessage('TOT00001');
						ComSetFocus(formObject.stl_yr);
						return false;
					}		
				break;

				case IBSEARCH_ASYNC01: //Creation
					if (formObject.stl_yr.value ==null || formObject.stl_yr.value ==""){
						ComShowCodeMessage('TOT00001');
						ComSetFocus(formObject.stl_yr);
						return false;
					}
				break;
				
    			case IBSAVE:   //저장
    				for(var inx=1; inx<=sheetObj.LastRow; inx++){
    					//수정되지 않은 값은 skip
    					if (sheetObj.CellValue(inx,prefix+"ibflag")=="R"){
    						continue;
    					}
    					if (sheetObj.CellValue(inx,prefix+"vsl_cd").length < 4){
    						ComShowCodeMessage('TOT00009');
    						sheetObj.SelectCell(inx,prefix+"vsl_cd",true);
    						return false;
    					}

    					if (sheetObj.CellValue(inx,prefix+"vsl_eng_nm").length < 1){
    						ComShowCodeMessage('TOT00010');
    						sheetObj.SelectCell(inx,prefix+"vsl_eng_nm",true);
    						return false;
    					}
    					
    					if (sheetObj.CellValue(inx,prefix+"ctrt_st_dt").length < 8){
    						ComShowCodeMessage('TOT00013');
    						sheetObj.SelectCell(inx,prefix+"ctrt_st_dt",true);
    						return false;
    					}
    					
    				}
    				break;
    				
    			default:
    				break;
    		}
    		return true;

    }

    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
    		var sName = sheetObj.ColSaveName(Col);

    		var Value = sheetObj.EditValue;

    		//4자리 치면 NEXT로 이동
    		if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
    			sheetObj.SelectCell(Row, prefix+"ctrt_st_dt",true);
    		}

    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(ErrMsg!="" || ErrMsg.length > 0){
			ComShowMessage(errMsg);
		} else {
			if( sheetObj.TotalRows > 0 ) {
				ComBtnDisable("btn1_Create");
			} else {
				ComBtnEnable("btn1_Create");
			}
		}
    }