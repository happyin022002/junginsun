/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0047.js
*@FileTitle : Reefer Unit Info Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.18 남궁진호 1.0 Creation [CHM-201006507-01]
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
     * @class ees_mst_0047 : ees_mst_0047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0047() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;    
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet1_OnAfterEdit     = sheet1_OnAfterEdit;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var comboObjects = new Array();
 var sheetCnt = 0;
 var tcnt = 0;
 var comboCnt = 0 ;
 var blurflg = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
	 /**
	  * Sheet 기본 설정 및 초기화
	  * body 태그의 onLoad 이벤트핸들러 구현
	  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	  */
	 function loadPage() {
	
	     //IBSheet 초기화하기
	     for(i=0;i<sheetObjects.length;i++){
	
	         //khlee-시작 환경 설정 함수 이름 변경
	         ComConfigSheet (sheetObjects[i] );
	
	         initSheet(sheetObjects[i],i+1);
	         
	         //khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
	     }
	     initControl();
	     /* IBMultiCombo 초기화 */
	 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	 		initCombo(comboObjects[k], k+1);
	 	}
	 }
	 
	 /**
	     * MultiCombo object initial property //LHS
	     * @param comboObj
	     * @param comboNo
	     * @return
	     */
	    function initCombo (comboObj, comboNo) {
	   	 switch(comboObj.id) {
		   	 case "combo1":
				with(comboObj) {
					//BackColor = "cyan";
					DropHeight = 150;
					MultiSelect = true;
					UseAutoComplete = true;
					MultiSeparator = ",";
					Style = 0;
					ValidChar(2,3);
				}
			break;
		
			case "combo2":
				with(comboObj) {
					//BackColor = "cyan";
					DropHeight = 150;
					MultiSelect = true;
					UseAutoComplete = true;
					MultiSeparator = ",";
					Style = 0;
					ValidChar(2,3);
				}
			break;
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
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	*/
     function setComboObject(combo_obj){
         comboObjects[comboCnt++] = combo_obj;
     }

     
      
     function sheet1_OnLoadFinish(sheetObj) {
    	 var formObject = document.form;     	
     
         doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	 doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	 comboObjects[0].CheckIndex(0) = true;
    	 comboObjects[1].CheckIndex(0) = true;
     }      
      
 	 // Axon 이벤트 처리
 	 // 1. 이벤트catch
 	 function initControl() {
 		var formObj = document.form;
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	    axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- 키 눌렸을때
 	    axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- 키 눌렸을때
  	}

 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    var vKeyCode = event.keyCode;

	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
	            break;
	        case "ymd":
	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
	        	break;
	    }
	}
 	
     
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){

	    }
	    else {
            //Validation 전체 체크(길이,format,최대,최소 등등)
            ComChkObjValid(obj);
	    }
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }	
	}

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
	     		case "btns_vndr":	// Lessor Code 가져오기 팝업
	     			ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 480, "vndr_seq:vndr_seq|vndr_abbr_nm:vndr_abbr_nm|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "0,0,1,1,1,1", true);
				break;	           	
             
				case "btn_retrieve":
					if (formObject.vndr_seq.value == "") {
						ComShowCodeMessage("MST00001", "Lessor");
					} else {
						formObject.cntr_nos.value = "";
						sheetObject1.RemoveAll();
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
				break;
				
				case "btn_loadexcel" :
					sheetObject1.RemoveAll();
					var ccheck = sheetObject1.LoadExcel(-1,1,"",-1,-1,"",false);
					formObject.cntr_nos.value = "";

					if (sheetObject1.RowCount > 0){
						formObject.cntr_nos.value = sheetObject1.CellValue(1,"cntr_no");
					    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					} else {
	            		//ComShowCodeMessage("MST00001","Row");
	            		return;							
					}					
				break;
				
				case "btn_downexcel" :
					sheetObject1.SpeedDown2Excel(-1);
				break;	
				
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.vndr_seq.value = "";
					formObject.vndr_abbr_nm.value = "";
					formObject.vndr_lgl_eng_nm.value = "";
					formObject.cntr_nos.value = "";
					formObject.sts_flg[1].checked = true;
					formObject.mi_flg[1].checked = true;
					formObject.agmt_seq.value = "";
					formObject.agmt_cty_cd.value = "HHO";
					
					for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
						comboObjects[0].CheckIndex(i)=false;
					}
					comboObjects[0].CheckIndex(0) = true;
					formObject.lstm_cd.value = "";
					
					for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
						comboObjects[1].CheckIndex(i)=false;
					}
					comboObjects[1].CheckIndex(0) = true;
					formObject.cntr_tpsz_cd.value = "";
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
				break;
				
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                if (formObject.agmt_seq.readOnly == false)
   			       ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true); 			                	
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 410;
                     
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

                     var HeadTitle1 = "|CNTR No.|TP/SZ|Term|On Hire Date|AGMT No|Maker Name|Maker Code|Model No|Refrigerant|Min Temp(℃)|Max Temp(℃)|a|b|c|d|e|f";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,0,   daCenter,  true,   "ibflag");
                     InitDataProperty(0, cnt++, dtData,        100, daCenter,  false,  "cntr_no",       false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        70,  daCenter,  false,  "cntr_tpsz_cd",  false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        50,  daCenter,  false,  "lstm_cd",       false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        90, 	daCenter,  false,  "onh_dt",        false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        80, 	daCenter,  false,  "agmt_no",       false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        150, daLeft,    false,  "rf_mkr_nm",     false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        90, 	daCenter,  false,  "rf_mkr_seq",    false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        100, daLeft,    false,  "rf_mdl_nm", 	false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        100, daLeft,    false,  "rf_rfr_no", 	false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        90, 	daRight,   false,  "min_temp",  	false,  "",     dfNone,      0,     false,		false);
                     InitDataProperty(0, cnt++, dtData,        90, 	daRight,   false,  "max_temp",  	false,  "",     dfNone,      0,     false,		false);                     
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "aeflg",       	false,  "",     dfNone,      0,     true,       true);
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "beflg",       	false,  "",     dfNone,      0,     true,       true);
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "ceflg",       	false,  "",     dfNone,      0,     true,       true);                     
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "deflg",       	false,  "",     dfNone,      0,     true,       true);
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "eeflg",       	false,  "",     dfNone,      0,     true,       true);  
                     InitDataProperty(0, cnt++, dtHidden,  	   85, 	daCenter,  true,   "feflg",       	false,  "",     dfNone,      0,     true,       true);  
                     
                     PopupImage  =  "img/btns_search.gif";
                     ShowButtonImage = 1;
                     SelectFontBold = true;
                     SelectHighLight = false;
                     FrozenCols = 6;
                 }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
            if(validateForm(sheetObj,formObj,sAction)){
            	
				 var aecnt = 0;
				 var becnt = 0;
				 var cecnt = 0;
				 var decnt = 0;
				 var eecnt = 0;    
				 var fecnt = 0; 
				 var tmpCntrNo ="";
				 
				 if (formObj.cntr_nos.value != ""){
					 
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);				
					formObj.f_cmd.value = SEARCH;
		     	    var sParam = ComGetSaveString(sheetObjects[0]);
		     	    sParam += "&" + FormQueryString(formObj);
		     	    var sXml = sheetObj.GetSearchXml("EES_MST_0047GS.do", sParam);
		     	    ComOpenWait(false);
		     	    var chk = sXml.indexOf("ERROR");
		     	    
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					} else {
					   sheetObj.LoadSearchXml(sXml);
					} 	
					
					// 동일한  cntr_no 있으면  첫번째 중복행에 대해서  메세지 출력
	        		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
	        		 var arrRow = dupRows.split(",");
					
				    for (var i = 1; i <= sheetObj.RowCount; i++){
				    	sheetObj.RowStatus(i) = "U";
						if (sheetObj.CellValue(i,"aeflg") == "E"){ //Term Error
							sheetObj.CellFontColor(i,"lstm_cd") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";           //대상이아닌경우 Status를 R로 변경
						    aecnt++;
						}
						if (sheetObj.CellValue(i,"beflg") == "E"){ //CNTR_Tp_SZ Code Error
							sheetObj.CellFontColor(i,"cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";	  //대상이아닌경우 Status를 R로 변경
						    becnt++;
						}
						if (sheetObj.CellValue(i,"ceflg") == "E"){ //RF_MKR_SEQ Code Error
							sheetObj.CellFontColor(i,"rf_mkr_seq") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";	  //대상이아닌경우 Status를 R로 변경
						    cecnt++;
						}  
						var tmpMinTemp =  sheetObj.CellValue(i,"min_temp");
						if (!ComIsNumber(tmpMinTemp, "-") && !ComIsNull(tmpMinTemp)){
							sheetObj.CellValue(i,"deflg") = "E";
							sheetObj.CellFontColor(i,"min_temp") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";		   //대상이아닌경우 Status를 R로 변경
						    decnt++;
						}
						
						var tmpMaxTemp =  sheetObj.CellValue(i,"max_temp");
						if (!ComIsNumber(tmpMaxTemp, "-") && !ComIsNull(tmpMaxTemp)){
							sheetObj.CellValue(i,"eeflg") = "E";
							sheetObj.CellFontColor(i,"max_temp") = sheetObj.RgbColor(255, 0, 0);
							sheetObj.RowStatus(i) = "R";		   //대상이아닌경우 Status를 R로 변경
						    eecnt++;
						}    
						
						if (!ComIsNull(tmpMinTemp) && !ComIsNull(tmpMaxTemp)) {
							if (tmpMinTemp > tmpMaxTemp){
								sheetObj.CellValue(i,"deflg") = "E";
								sheetObj.CellValue(i,"eeflg") = "E";
								sheetObj.CellFontColor(i,"min_temp") = sheetObj.RgbColor(255, 0, 0);
								sheetObj.CellFontColor(i,"max_temp") = sheetObj.RgbColor(255, 0, 0);
								decnt++;
								eecnt++;
							}
						}
						
						if (sheetObj.CellValue(i,"cntr_tpsz_cd") == ""){ //존재하지않는 컨테이너
							sheetObj.CellBackColor(i,"cntr_no") = sheetObj.RgbColor(255, 60, 60);
							sheetObj.RowStatus(i) = "R";
							fecnt++;
						}
					}
				    
				 // 동일한  cntr_no 있으면  첫번째 중복행에 대해서  메세지 출력
	        		 var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
	        		 var arrRow = dupRows.split(",");
	        		
			         if (dupRows != ""){
			        	 //오류메시지 : 데이터가 중복됩니다.	       			 
			             for( var t=0; t<arrRow.length; t++){
			            	 tmpCntrNo = tmpCntrNo + sheetObj.CellValue(arrRow[t],"cntr_no")+",";
				            	 if (sheetObj.CellValue(arrRow[t],"cntr_no")   == sheetObj.CellValue(arrRow[t],"cntr_no") ){
				       			     sheetObj.SelectCell(arrRow[t], "cntr_no", true);
				       			     sheetObj.CellFontColor(arrRow[t],"cntr_no") = sheetObj.RgbColor(255, 0, 0);
				       			     sheetObj.CellValue2(arrRow[t],"feflg") = "E";
				       			     sheetObj.RowStatus(arrRow[t]) = "R";
				       			     fecnt++;
				            	 }
			             }
			             ComShowCodeMessage("MST00002", tmpCntrNo);
			         }

				    if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0 || eecnt > 0 || fecnt > 0){
				    	ComShowCodeMessage("MST01026");
				    }
				 } else {
	                 sheetObj.WaitImageVisible=false;
	                 ComOpenWait(true); 						
					 formObj.f_cmd.value = SEARCH01;
		     	     var sParam = ComGetSaveString(sheetObjects[0]);
		     	     sParam += "&" + FormQueryString(formObj);
		     	     var sXml = sheetObj.GetSearchXml("EES_MST_0047GS.do", sParam);

		     	     ComOpenWait(false);
		     	     var chk = sXml.indexOf("ERROR");
					 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					 } else {
					   sheetObj.LoadSearchXml(sXml);
					 } 					 
				 }
             }
			break;
			
			case IBSEARCH_ASYNC01:
				/* Lease Term Form Combo Item Setting */
				sheetObj.WaitImageVisible = false;
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
				var chk = sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchXml(sXml);
					 return;
				 }	  
				 
				 //Lease Term 조회
		         var lstmCd = ComGetEtcData(sXml,"lease_term_cd");
		         var strLstmCd  = lstmCd.split("|");
		         
		         with (form.combo1) {		        
		        	 InsertItem(0 , 'ALL','ALL'); 
		        	 var t=1;
		        	 for ( var i=1; i<=strLstmCd.length; i++) {
		        		 if (strLstmCd[i-1]=="LT" ||strLstmCd[i-1]=="ST"){ 
		        			 InsertItem(t, strLstmCd[i-1], strLstmCd[i-1]);
		        			 t++;
		        		 }
		        	 }		        	 
		         }
				break;
				
		     case IBSEARCH_ASYNC02:
		    	 sheetObj.WaitImageVisible=false;
		         form.f_cmd.value = SEARCH02;
		         var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do" , FormQueryString(formObj));
				 var chk = sXml.indexOf("ERROR");
				 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					 sheetObj.LoadSearchXml(sXml);
					 return;
				 }	             
		         
		         //TP/SZ 조회
		         var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");
		         tot_cntr_tpsz_cd = cntr_tpsz_cd;
		         var strCntrTpszCd  = cntr_tpsz_cd.split("|");
		         
		         with (form.combo2) {		        
		        	 InsertItem(0 , 'ALL','ALL'); 
		        	 var t=1;
		        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
		        		 if (strCntrTpszCd[i-1].substring(0,1)=="R"){ 
		        			 InsertItem(t, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
		        			 t++;
		        		 }
		        	 }		        	 
		         }
			break;
			
			case IBSAVE:
				//dup 체크
	        
		        var chkUpdate = false;
		        for (var i = 1; i <= sheetObj.RowCount; i++){
		        	if (sheetObj.RowStatus(i) == "U"){
		        		chkUpdate = true;
		        		break;
		        	}	
		        }
		        if (!chkUpdate){
		        	ComShowCodeMessage("MST00012");
		        	return;
		        }
		        
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);				
		    	formObj.f_cmd.value = MULTI;
     	        var sParam = ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml = sheetObj.GetSaveXml("EES_MST_0047GS.do", sParam);
     	        ComOpenWait(false);
     	        
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					sheetObj.LoadSearchXml(sXml);
					return;
				} else {  	     	        
					ComShowCodeMessage("MST01025");
				}
				
				for(var i = sheetObj.RowCount; i >= 1; i--){
					if (sheetObj.CellValue(i,"aeflg") != "E" && 
						sheetObj.CellValue(i,"beflg") != "E" &&
						sheetObj.CellValue(i,"ceflg") != "E" &&
						sheetObj.CellValue(i,"deflg") != "E" &&
						sheetObj.CellValue(i,"eeflg") != "E" &&
						sheetObj.CellValue(i,"feflg") != "E"){
						sheetObj.RowDelete(i,false);
					}
				}				
			break;
         }
     }
     
     /**
      * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
      * @return
      */
     function combo1_OnCheckClick(comboObj, index, code) {
     	if(index==0) {
     		var bChk = comboObj.CheckIndex(index);
     		if(bChk){
     			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     				comboObj.CheckIndex(i) = false;
     			}
     		}
     	} else {
     		comboObj.CheckIndex(0) = false;
     	}
     }


     /**
      * combo1_OnBlur
      */
     function combo1_OnBlur(comboObj, Index_Code, Text) {
     	var formObj = document.form;
     	if( comboObj.CheckIndex(0)){
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = false;
     		}
     		formObj.lstm_cd.value = "";
     	}else if(comboObj.Text == ""){
     		comboObj.CheckIndex(0) = true;
     		formObj.lstm_cd.value = "";
     	}else{
     	    formObj.lstm_cd.value = ComGetObjValue(comboObj);
     	}
     }


     /**
      * combo1_OnKeyDown
      */
     function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
     	with(comboObj) {
     		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
     			comboObj.Text = "";
     		}else if(KeyCode == 13){
      		    sheetObjects[0].RemoveAll();
      			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		}
     	}
     }

     /**
      * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
      * @return
      */
     function combo2_OnCheckClick(comboObj, index, code) {
     	if(index==0) {
     		var bChk = comboObj.CheckIndex(index);
     		if(bChk){
     			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     				comboObj.CheckIndex(i) = false;
     			}
     		}
     	} else {
     		comboObj.CheckIndex(0) = false;
     	}
     }

     /**
      * combo2_OnBlur
      */
     function combo2_OnBlur(comboObj, Index_Code, Text) {
     	var formObj = document.form;
     	if( comboObj.CheckIndex(0)){
     		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
     			comboObj.CheckIndex(i) = false;
     		}
     		formObj.cntr_tpsz_cd.value = "";
     	}else if(comboObj.Text == ""){
     		comboObj.CheckIndex(0) = true;
     		formObj.cntr_tpsz_cd.value = "";
     	}else{
     	    formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
     	}
     }

     /**
      * combo2_OnKeyDown
      */
     function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
     	with(comboObj) {
     		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
     			comboObj.Text = "";
     		}else if(KeyCode == 13){
      		    sheetObjects[0].RemoveAll();
      			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		}
     	}
     }
     
       
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
     
   	/**
   	 * Currency Pop-up Return Value 처리 부분<br>
   	 * @param {arry} returnedValues Pop-up 화면의 Return value array
   	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
   	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
   	 * @param 대상IBSheet의 Sheet Array index
   	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj  = document.form;
  	    var sheetObj = sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	  	    if (aryPopupData[0][6] != "ST" && aryPopupData[0][6] != "LT"){
  	  	    		formObj.agmt_cty_cd.value = "";
  	  	    		formObj.agmt_seq.value = ""; 	    		   		
  	  	    		ComShowCodeMessage("MST01003");
  	  	    		ComSetFocus(formObj.agmt_seq);
  	  	    		return;
  	  	    }
  	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][3]);
  	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
  	    }
  	} 	     
	/* 개발자 작업  끝 */