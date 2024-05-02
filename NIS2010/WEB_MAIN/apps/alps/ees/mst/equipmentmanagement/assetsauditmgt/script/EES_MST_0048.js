/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0048.js
*@FileTitle : Container No Management Creation
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
		this.sheet1_OnMouseMove 	= sheet1_OnMouseMove;
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
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
					if (sheetObjects[0].RowCount > 0){
						comboObjects[0].Enable = false;
					}else{
						comboObjects[0].Enable = true;
					}
					sheetObject1.HeadCheck(0,"cntr_hngr_rck_cd") = false;
					ComBtnEnable_u("btn_save");
			        ComBtnEnable_u("btn_add");
				    ComBtnEnable_u("btn_del");	
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
					comboObjects[0].Enable = true;
					comboObjects[0].Code = "U";
					ComSetObjValue(document.form.pln_yr,ComGetNowInfo("yy")); // Plan Year);
				    ComBtnDisable_u("btn_save");
					ComBtnDisable_u("btn_add");
					ComBtnDisable_u("btn_del");
					sheetObject1.HeadCheck(0,"del_chk") = false;
					formObject.pln_yr.focus();
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					
				break; 
				
				case "btn_add":
					comboObjects[0].Enable = false;
					sheetObject1.DataInsert();
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;

				case "btn_del":
   					if(sheetObject1.FindCheckedRow("del_chk")==""){
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")){ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
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
	     ComBtnDisable_u("btn_save");
	     ComBtnDisable_u("btn_add");
	     ComBtnDisable_u("btn_del");
	     // IBSheet내 Combo 초기화
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	  
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
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
	            if(obj.name=="pln_yr") ComKeyOnlyNumber(this);
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
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				formObj.eq_tp_cd.disabled = true;
				ComBtnEnable_u("btn_save");
		        ComBtnEnable_u("btn_add");
			    ComBtnEnable_u("btn_del");
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
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(15, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, false, true, true, false,false);

                 var HeadTitle1 = "||Year||TP/SZ||Hanger Rack|Kind of Floor|Kind of Unit|Serial Range|Serial Range|Serial Range|Serial Range|Qty|";

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus, 	 30,  	daCenter, 	false, 	  "ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck, 		 40,  	daCenter, 	true,     "del_chk");
                 InitDataProperty(0, cnt++ , dtData,     	 	 80, 	daCenter,   true,     "pln_yr",    			true,      "",      dfNone, 		0,     false,       false, 4);//
                 InitDataProperty(0, cnt++ , dtHidden,		 	 80, 	daLeft,   	true,     "eq_tp_cd",       	true,      "",      dfEngUpKey, 	0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtComboEdit, 	 	 100, 	daCenter,   true,     "eq_tpsz_cd",         true,      "",      dfEngUpKey, 	0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtHidden, 	 	 	 100, 	daCenter,   true,     "pln_seq",         	true,      "",      dfNone, 		0,     false,       true);//
                 InitDataProperty(0, cnt++ , dtCheckBox, 	 	 120, 	daCenter,  	true,     "cntr_hngr_rck_cd",  	false,     "",      dfNone,	    	0,     true,      	true);//
                 InitDataProperty(0, cnt++ , dtComboEdit,     	 150, 	daLeft,  	true,     "cntr_flr_mtrl_cd",      	false,     "",      dfNone,     	0,     true,       	true);
                 InitDataProperty(0, cnt++ , dtComboEdit,    	 200, 	daLeft,   	true,     "rf_tp_cd",      		false,     "",      dfNone,     	0,     true,       	true);
                 InitDataProperty(0, cnt++ , dtData,     		 40, 	daCenter,  	true,     "lot_cntr_pfx_cd",    true,      "",      dfNone,    		0,     true,       	true, 4);
                 InitDataProperty(0, cnt++ , dtData,     		 60, 	daCenter,  	true,     "fm_ser_no",        	true,      "",      dfNone,     	0,     true,       	true, 6);
                 InitDataProperty(0, cnt++ , dtData,     		 10, 	daCenter,  	true,     "ser_tmp",       		false,     "",      dfNone,     	0,     false,       false);
                 InitDataProperty(0, cnt++ , dtData,   			 60, 	daCenter,  	true,     "to_ser_no",          true,      "",      dfNone,     	0,     true,       	true, 6 );
                 InitDataProperty(0, cnt++ , dtData, 	  	     100,	daRight,  	true,     "cntr_qty",        	true,     "",      dfInteger,     	0,     true,       	true );
                 InitDataProperty(0, cnt++ , dtHidden, 	  	     300,	daLeft,  	true,     "rmk",        		true,     "",      dfNone,     		0,     false,       false );
                 
//                 InitDataCombo(0, "cntr_hngr_rck_cd", "Y|N", "O|");    // IBSheet내 Combo 초기화
//                 InitDataCombo(0, "plst_flr_flg", "Plastic|Plywood", "Y|N");    // IBSheet내 Combo 초기화
                 InitDataValid(0, "lot_cntr_pfx_cd", vtEngUpOnly);
                 InitDataValid(0, "fm_ser_no", vtNumericOnly); 
                 InitDataValid(0, "to_ser_no", vtNumericOnly); 
                 SelectFontBold = false;
                 SelectHighLight = true;
                 EditEnterBehavior = "tab";
                 ToolTipOption="balloon:true;width:320;backcolor:#EBF5FF;forecolor:#28288C;icon:1;title:Data duplication";
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
			  var param ="f_cmd="+SEARCH+"&pln_yr="+ComGetObjValue(formObj.pln_yr)+"&eq_tp_cd="+ComGetObjValue(comboObjects[0]);
			 
			  sheetObj.DoSearch("EES_MST_0048GS.do", param);
			  ComOpenWait(false);
          }
       break;

	   case IBSAVE:          //저장
	        if (!sheetObj.IsDataModified ) return;
		    if(validateForm(sheetObj,formObj,sAction)){
			   for (var i = 1; i < sheetObj.RowCount+1; i++){
//	                if (sheetObj.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R"){ 
//	            	    if (sheetObj.CellValue(i,"rf_tp_cd")==""){
//		            		ComShowCodeMessage("MST01019", "Kind of Unit");
//		            		sheetObj.SelectCell(i,"rf_tp_cd");
//		            		return;
//	            	    }	 
//	                }	 
		            if (parseInt(sheetObj.CellValue(i,"cntr_qty")) < 1){
		            	 ComShowCodeMessage("MST01019", "Qty");
		            	 sheetObj.SelectCell(i,"cntr_qty");
		            	 return;
		            }
			   }
			   
	        sheetObj.WaitImageVisible=false;
	        ComOpenWait(true);			
			formObj.f_cmd.value = MULTI;
 	       var sParam = ComGetSaveString(sheetObj);
	        sParam += "&f_cmd="+MULTI;
            
	        var sXml = sheetObj.GetSaveXml("EES_MST_0048GS.do",sParam);
	        ComOpenWait(false);
	        //저장XML 표현하기
	        var cnt =ComGetTotalRows(sXml);
	        if (cnt > 0){
	        	sheetObj.LoadSaveXml(sXml);
	        	for (var t = 1; t < sheetObj.RowCount+1; t++){
	        		sheetObj.CellBackColor(t,"fm_ser_no") = sheetObj.RgbColor(255, 0, 0)
	        		sheetObj.CellBackColor(t,"to_ser_no") = sheetObj.RgbColor(255, 0, 0)

	        	}
	        	ComShowCodeMessage("MST01027");
	        }else{
	        	doActionIBSheet(sheetObj,document.form,IBSEARCH);
	        }
 	        
		}
       break;
       
	   case IBINSERT:        // 입력
	        sheetObj.CellValue2(sheetObj.SelectRow,"pln_yr") = ComGetObjValue(formObj.pln_yr);
        	sheetObj.CellValue2(sheetObj.SelectRow,"eq_tp_cd") = ComGetObjValue(comboObjects[0]);
        	sheetObj.CellValue2(sheetObj.SelectRow,"eq_tpsz_cd") = "";
        	sheetObj.CellValue2(sheetObj.SelectRow,"cntr_hngr_rck_cd") = "";
        	if(ComGetObjValue(comboObjects[0]) =='U'){
        	sheetObj.CellValue2(sheetObj.SelectRow,"plst_flr_flg") = "N";
        	}else{
        		sheetObj.CellValue2(sheetObj.SelectRow,"plst_flr_flg") = "";
        	}
        	sheetObj.CellValue2(sheetObj.SelectRow,"rf_tp_cd") = "";
        	if(ComGetObjValue(comboObjects[0]) !='U'){
        		sheetObj.CellEditable(sheetObj.SelectRow,"cntr_hngr_rck_cd") = false;
        		sheetObj.CellEditable(sheetObj.SelectRow,"plst_flr_flg") = false;
        	}
        	sheetObj.CellEditable(sheetObj.SelectRow,"rf_tp_cd") = false;
        	sheetObj.CellValue2(sheetObj.SelectRow,"ser_tmp") = "-";	               
            sheetObj.MinimumValue (sheetObj.SelectRow, "cntr_qty") = 0;
       break;
       
		case IBDELETE:      // 삭제
   		if (sheetObj.id == 'sheet1') {  
   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
				ComRowHideDelete(sheetObj,"del_chk"); 
			} 
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
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd="+eqKndCd);
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
			var cntr_tpsz_cd = ComGetEtcData(xml,"cntr_tpsz_cd");	   //TP/SZ 조회
		  	sheetObj.InitDataCombo(0, "eq_tpsz_cd", cntr_tpsz_cd, cntr_tpsz_cd);    // IBSheet내 Combo 초기화
       break;
      
       case IBSEARCH_ASYNC03://Sheet Combo 데이타 담아오기
		 	formObj.f_cmd.value = SEARCH08;
		  	var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj));
		    var chk = xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchXml(xml);
			   return;
		    }		  	
		  	var cols = ComMstXml2ComboString(xml, "code", "code_nm", "\t");
		  	cols[0]=" |"+cols[0];
		  	cols[1]=" |"+cols[1];		  	
		  	sheetObj.InitDataCombo(0, "rf_tp_cd", cols[1], cols[0]);    // IBSheet내 Combo 초기화
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
//	  	cols[0]=" |"+cols[0];
//	  	cols[1]=" |"+cols[1];		  	
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
         cal.select(formObj.pln_yr, "yyyy");
     }

     /**
     * Button style change (disable)
     */     
     function ComBtnDisable_u(name){ 
    	 var tds = document.getElementsByTagName("td"); 
	    	 for(var i = 0; i < tds.length; i++) { 
		    	 var td=tds[i]; 
		    	 if (td.className.length > 0 && td.name == name){ 
		    	 if(td.className.indexOf('_1') == -1) 
		    	 td.className += "_1"; 
		    	 td.name="no_"+name; 
	    	 } 
    	 } 
     }
     
     /**
     * Button style change (Enable)
     */      
     function ComBtnEnable_u(name) { 

    	 var tds = document.getElementsByTagName("td"); 
    	 for ( var i = 0; i < tds.length; i++) { 
	    	 var td = tds[i]; 
	    	 if (td.className.length > 0 && td.name == "no_"+name) { 
		    	 if (td.className.indexOf('_1') > 0) 
		    	 td.className = td.className.replace(/_1/i, ""); 
		    	 td.name=name; 
	    	 } 
    	 } 
     }
      
     function sheet1_OnChange(SheetObj, Row, Col, Value){
    	 var formObj = document.form; 
    	 var sName = SheetObj.ColSaveName(Col); 	
         if (sName == "eq_tpsz_cd"){
             if (Value.substring(0, 1) == "R") {
            	 SheetObj.CellEditable(Row,"rf_tp_cd") = true;
             } else {
            	 SheetObj.CellEditable(Row,"rf_tp_cd") = false;
            	 SheetObj.CellValue(Row,"rf_tp_cd") = "";
             }
         }else if(sName == "lot_cntr_pfx_cd"){
        	 var pfxCd = ComTrimAll(SheetObj.CellValue(Row,"lot_cntr_pfx_cd"));
        	 if(pfxCd.trim().length != 4){
   				ComShowCodeMessage("MST01020", pfxCd);
   				SheetObj.SelectCell(Row,"lot_cntr_pfx_cd");     				
   				return;
   			}
        	 
         }else if(sName == "fm_ser_no"){
        	 var fmSerNo = ComTrimAll(SheetObj.CellValue(Row,"fm_ser_no"));
        	 var toSerNo = ComTrimAll(SheetObj.CellValue(Row,"to_ser_no"));
        	 if(fmSerNo.length > 0){
      			if(fmSerNo.trim().length != 6){
      				ComShowCodeMessage("MST01021", fmSerNo);
      				SheetObj.SelectCell(Row,"fm_ser_no");     				
      				return;
      			}

      			if(!ComIsNumber(fmSerNo)){
      				ComShowCodeMessage("MST01019", fmSerNo);
      				SheetObj.SelectCell(Row,"fm_ser_no");  
      				return;
      			}
      			
      			if(fmSerNo.length != 6) return;
         		if(toSerNo.length != 6) return;

         		var change_count = String(toSerNo - fmSerNo + 1);
         		SheetObj.CellValue2(Row,"cntr_qty") = change_count;

         		if(eval(change_count) < 1 ){
         			ComShowCodeMessage("MST01022");
         			SheetObj.CellValue2(Row,"fm_ser_no") = "";
         			SheetObj.CellValue2(Row,"cntr_qty") = "";
         			SheetObj.SelectCell(Row,"fm_ser_no"); 
         			return;
         		}
        	 }
         }else if(sName == "to_ser_no"){
        	 var fmSerNo = ComTrimAll(SheetObj.CellValue(Row,"fm_ser_no"));
        	 var toSerNo = ComTrimAll(SheetObj.CellValue(Row,"to_ser_no"));
        	 
        	 if(toSerNo.length > 0){
     			if(toSerNo.length != 6){
     				ComShowCodeMessage("MST01021", toSerNo);
     				SheetObj.SelectCell(Row,"to_ser_no");     				
     				return;
     			}

     			if(!ComIsNumber(toSerNo)){
     				ComShowCodeMessage("MST01019", toSerNo);
     				SheetObj.SelectCell(Row,"to_ser_no");  
     				return;
     			}
     		}

     		if(fmSerNo.length != 6) return;
     		if(toSerNo.length != 6) return;

     		var change_count = String(toSerNo - fmSerNo + 1);
     		SheetObj.CellValue2(Row,"cntr_qty") = change_count;

     		if(eval(change_count) < 1 ){
     			ComShowCodeMessage("MST01022");
     			SheetObj.CellValue2(Row,"to_ser_no") = "";
     			SheetObj.CellValue2(Row,"cntr_qty") = "";
     			SheetObj.SelectCell(Row,"to_ser_no"); 
     			return;
     		}
        	 
         }
     }
     
 	  
     /**
 	 * sheet1_OnMouseMove
 	 */ 
 	function sheet1_OnMouseMove( sheetObj, Button, Shift, X, Y) {
 		var formObj = document.form;
 		with(sheetObj) {
	 		var Row = MouseRow;
	   	    var Col = MouseCol;      
	   	    var sTxt = CellText(Row,"rmk")
	        if (Row <=0 ||  sTxt =="")return;
	 		
 			switch(ColSaveName(Col)) {
 				case "fm_ser_no":
 					ToolTipText(Row, Col) =  CellText(Row,"rmk") + "Please check data again.";
 					break;
 				case "to_ser_no":
 					ToolTipText(Row, Col) =  CellText(Row,"rmk") + "Please check data again.";
 				break;
 			} 
 		}
 	}
     
  // 조회 후 설정
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		for (var i = 1; i <= sheetObj.RowCount+1; i++){
 		  if (sheetObj.CellValue(i,"eq_tp_cd") != "U") {
 			 sheetObj.CellEditable(i,"cntr_hngr_rck_cd") = false;
 			 sheetObj.CellEditable(i,"plst_flr_flg") = false;
 		  }else{
 			 sheetObj.CellEditable(i,"cntr_hngr_rck_cd") = true;
 			 sheetObj.CellEditable(i,"plst_flr_flg") = true;
 		  }
 			  
          if (sheetObj.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R") {
         	 sheetObj.CellEditable(i,"rf_tp_cd") = true;
          } else {
         	 sheetObj.CellEditable(i,"rf_tp_cd") = false;
          }
          sheetObj.MinimumValue (i, "cntr_qty") = 1;
 		}
 	 }
  
//조회 후 설정
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		for (var i = 1; i <= sheetObj.RowCount+1; i++){
		  if (sheetObj.CellValue(i,"eq_tp_cd") != "U") {
			 sheetObj.CellEditable(i,"cntr_hngr_rck_cd") = false;
			 sheetObj.CellEditable(i,"plst_flr_flg") = false;
		  }else{
			 sheetObj.CellEditable(i,"cntr_hngr_rck_cd") = true;
			 sheetObj.CellEditable(i,"plst_flr_flg") = true;
		  }
			  
        if (sheetObj.CellValue(i,"eq_tpsz_cd").substring(0, 1) == "R") {
       	 sheetObj.CellEditable(i,"rf_tp_cd") = true;
        } else {
       	 sheetObj.CellEditable(i,"rf_tp_cd") = false;
        }
        sheetObj.MinimumValue (i, "cntr_qty") = 1;
		}
	 }
     
	/* 개발자 작업  끝 */