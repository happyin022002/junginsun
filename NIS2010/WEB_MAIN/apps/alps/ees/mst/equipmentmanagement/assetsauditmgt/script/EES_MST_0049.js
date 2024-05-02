/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0049.js
*@FileTitle : Container No Management Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.03.21 남궁진호
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
     * @class ees_mst_0048 : ees_mst_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0048() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;  
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0 ;
 
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
				case "btn_retrieve":
				    if (formObject.pln_yr.value.length < 4) {
			    	   ComShowCodeMessage("MST00001","Year");
			    	   ComSetFocus(formObject.pln_yr);
			      	   return;
			    	}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
					ComSetObjValue(document.form.pln_yr,ComGetNowInfo("yy")); // Plan Year);
				    ComSetObjValue(document.form.pln_yr2,ComGetNowInfo("yy")); // Plan Year);
					comboObjects[0].Code = "U";
					comboObjects[1].Code="";
					comboObjects[2].Code="";
					comboObjects[3].Code="";
					document.getElementById("cntr_hngr_rck_cd").value = "";
					document.getElementById("plst_flr_flg").value = "";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
					formObject.pln_yr.focus();
				break;
				case "btn_downexcel":
					sheetObject1.Down2Excel();
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
      
      /**
       * Combo Object를 배열로 등록
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
    }
    
      /**
       * 초기 이벤트 등록 
       */
      function initControl() {
    	 axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
  	     axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
  		 axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
  		 axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
  		 axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때	
      }
      
    function sheet1_OnLoadFinish(sheetObj) {
	     ComSetObjValue(document.form.pln_yr,ComGetNowInfo("yy")); // Plan Year);
	     ComSetObjValue(document.form.pln_yr2,ComGetNowInfo("yy")); // Plan Year);
	     // IBSheet내 Combo 초기화
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	     document.form.pln_yr.focus();    	
    }

  	//Axon 이벤트 처리2. 이벤트처리함수
  	function obj_deactivate(){
  	    ComChkObjValid(event.srcElement);
  	}
  	
  	function obj_activate(){
  	    ComClearSeparator(event.srcElement);
  	}
  	
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "yyyy":
	            if(obj.name=="pln_yr"){
	            	ComKeyOnlyNumber(this);
	            }else if(obj.name=="pln_yr2"){
	            	ComKeyOnlyNumber(this);
	            }
	            break;
	    }        
	}
 	
 	function obj_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;
 		if (obj.name == "pln_yr") {
	  		if ( vKeyCode == 9 || vKeyCode == 13) {
			    if (formObj.pln_yr.value.length < 4) {
			    	   ComShowCodeMessage("MST00001","Year");
			    	   ComSetFocus(formObj.pln_yr);
			      	   return;
			    }
			    ComKey
	  		}
 		} 
 		if (obj.name == "pln_yr2") {
	  		if ( vKeyCode == 9 || vKeyCode == 13) {
			    if (formObj.pln_yr.value.length < 4) {
			    	   ComShowCodeMessage("MST00001","Year");
			    	   ComSetFocus(formObj.pln_yr);
			      	   return;
			    }
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	  		}
 		} 
 	}
 	
 	
 	/**  
	 * combo_eq_kind Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function eq_tp_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form; 
		if (comboObjects[0].Code !="U"){
//			comboObjects[1].Enable = false;
			comboObjects[3].Enable = false;
			ComEnableObject(formObj.cntr_hngr_rck_cd,false);
			ComEnableObject(formObj.cntr_flr_mtrl_cd,false);
			
		}else{
//			comboObjects[1].Enable = true;
			comboObjects[3].Enable = true;
			ComEnableObject(formObj.cntr_hngr_rck_cd,true);
			ComEnableObject(formObj.cntr_flr_mtrl_cd,true);
		}
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);    		 
	} 
	 
	 /**  
		 * combo_eq_kind Change 이벤트      
		 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
		 * @param  {String}    Index_Code   Index 나 코드
		 * @param  {String}    Text   텍스트
		 */  
	function eq_tpsz_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form; 
		if (comboObjects[0].Code =="U"){
			if (comboObjects[1].Code.substring(0, 1) == "R") {
				comboObjects[3].Enable = true;
            } else {
            	comboObjects[3].Enable = false;
            }
		}
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
                 style.height = 440;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(11, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, false, true, false,false);

                 var HeadTitle1 = "|Year|TP/SZ|Serial Range|Serial Range|Serial Range|Serial Range|Qty|Hanger Rack|Kind of Floor|Kind of Unit";

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 	 30,  	daCenter, 	false, 	  "ibflag");
                 InitDataProperty(0, cnt++ , dtData,     	 	 80, 	daCenter,   true,     "pln_yr",    			false,      "",      dfNone, 		0,     false,       false, 4);//
//                 InitDataProperty(0, cnt++ , dtHidden,		 	 80, 	daLeft,   	true,     "eq_tp_cd",       	false,      "",      dfEngUpKey, 	0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtComboEdit, 	 	 100, 	daCenter,   true,     "eq_tpsz_cd",         false,      "",      dfEngUpKey, 	0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtData,     		 40, 	daCenter,  	true,     "lot_cntr_pfx_cd",    false,      "",      dfNone,    		0,     true,       	true, 4);
                 InitDataProperty(0, cnt++ , dtData,     		 60, 	daCenter,  	true,     "fm_ser_no",        	false,      "",      dfNone,     	0,     true,       	true, 6);
                 InitDataProperty(0, cnt++ , dtData,     		 10, 	daCenter,  	true,     "ser_tmp",       		false,     "",      dfNone,     	0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,   			 60, 	daCenter,  	true,     "to_ser_no",          false,      "",      dfNone,     	0,     true,       	true, 6 );
                 InitDataProperty(0, cnt++ , dtData, 	  	     100,	daRight,  	true,     "cntr_qty",        	false,     "",      dfInteger,     	0,     true,       	true );
                 InitDataProperty(0, cnt++ , dtComboEdit, 	 	 120, 	daCenter,  	true,     "cntr_hngr_rck_cd",  	false,     "",      dfNone,	    	0,     true,      	true);//
                 InitDataProperty(0, cnt++ , dtComboEdit,     	 150, 	daLeft,  	true,     "cntr_flr_mtrl_cd",      	false,      "",      dfNone,     	0,     true,       	true);
                 InitDataProperty(0, cnt++ , dtComboEdit,    	 200, 	daLeft,   	true,     "rf_tp_cd",      		false,     "",      dfNone,     	0,     true,       	true);
                 
                 InitDataCombo(0, "cntr_hngr_rck_cd", "Y|N", "1|0");    			// IBSheet내 Combo 초기화
//                 InitDataCombo(0, "plst_flr_flg", "Plastic|Plywood", "Y|N");    // IBSheet내 Combo 초기화
                 InitDataValid(0, "lot_cntr_pfx_cd", vtEngUpOnly);
                 InitDataValid(0, "fm_ser_no", vtNumericOnly); 
                 InitDataValid(0, "to_ser_no", vtNumericOnly); 
                 SelectFontBold = false;
                 SelectHighLight = true;
                 EditEnterBehavior = "tab";
         }
         break;
             
      }
   }

   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
       case IBSEARCH:        //조회
          if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH;
			  sheetObj.DoSearch("EES_MST_0048GS.do", FormQueryString(formObj));
			  ComOpenWait(false);
          }
       break;
	   case IBSEARCH_ASYNC01://Sheet Combo 데이타 담아오기
	   	 	formObj.f_cmd.value = SEARCH09;
	       	var intgCdId ='CD01132';
			var intgCdVal ='';
			var param ="&intgCdId="+intgCdId+"&intgCdVal="+intgCdVal;
	   	  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+param);
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }	   	  	
			var cols = ComMstXml2ComboString(xml, "code", "code_nm", "\t");
			var strCd = cols[0].split("|");
			var strNm = cols[1].split("|");
			
			MstMakeComboObject(comboObjects[0], strNm, strCd);    // Combo 초기화
			comboObjects[0].Code="U";
       break;
       
       case IBSEARCH_ASYNC02://Sheet Combo 데이타 담아오기
		 	formObj.f_cmd.value = SEARCH02;
            var eqKndCd = comboObjects[0].Code;
            formObj.eq_tpsz_cd.removeAll();
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd="+eqKndCd);
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
			var cntr_tpsz_cd = ComGetEtcData(xml,"cntr_tpsz_cd");	   //TP/SZ 조회
		  	sheetObj.InitDataCombo(0, "eq_tpsz_cd", cntr_tpsz_cd, cntr_tpsz_cd);    // IBSheet내 Combo 초기화
		  	var strCd =cntr_tpsz_cd.split("|");
		  	MstMakeComboObject(comboObjects[1], strCd, strCd);    // Combo 초기화
		  	comboObjects[1].InsertItem(0, "", "");
		  	comboObjects[1].Text="";
       break;
      
       case IBSEARCH_ASYNC03://Sheet Combo 데이타 담아오기
		 	formObj.f_cmd.value = SEARCH08;
       		formObj.rf_tp_cd.removeAll();
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj));
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
		  	var cols = ComMstXml2ComboString(xml, "code", "code_nm", "\t");
		  	sheetObj.InitDataCombo(0, "rf_tp_cd", cols[1], cols[0]);    // IBSheet내 Combo 초기화
			var strCd = cols[0].split("|");
			var strNm = cols[1].split("|");
			
		  	MstMakeComboObject(comboObjects[3], strNm, strCd);    // Combo 초기화
		  	comboObjects[3].InsertItem(0, "All", "");
		  	comboObjects[3].Text="All";
		  	comboObjects[3].Enable=false;
	  break;
	  
      case IBSEARCH_ASYNC04://Sheet Combo 데이타 담아오기
		 	formObj.f_cmd.value = SEARCH09;
	   		var intgCdId ='CD03026';
			var intgCdVal ='';
			var param ="&intgCdId="+intgCdId+"&intgCdVal="+intgCdVal;
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+param);
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
		  	var cols = ComMstXml2ComboString(xml, "code", "code_nm", "\t");
		  	var strCd = cols[0].split("|");
			var strNm = cols[1].split("|");
		  	MstMakeComboObject(comboObjects[2], strNm, strCd);    // Combo 초기화
		  	comboObjects[2].InsertItem(0, "All", "");
		  	comboObjects[2].Text="All";
		  	
		  	cols[0]=" |"+cols[0];
		  	cols[1]=" |"+cols[1];		  	
		  	sheetObj.InitDataCombo(0, "cntr_flr_mtrl_cd", cols[1], cols[0]);    // IBSheet내 Combo 초기화
		  	break;
     }
   }
   
   
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  if(ComIsEmpty(formObj.pln_yr)){
				 ComShowCodeMessage("MST00001", "Year");
				 ComSetFocus(formObj.pln_yr);
				 return false;			
			  }        			  
         return true;
     }

     /**
     * Calendar Display
     */
     function popCalendar(type){
    	 var formObj = document.form;    	 
         var cal = new ComCalendar();
         cal.setDisplayType('year');
         if (type =='calendarPopup'){
        	 cal.select(formObj.pln_yr, "yyyy");
         }else{
        	 cal.select(formObj.pln_yr2, "yyyy");
         }
     }

      
	/* 개발자 작업  끝 */