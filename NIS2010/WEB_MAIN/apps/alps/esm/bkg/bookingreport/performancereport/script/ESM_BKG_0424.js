/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0424.js
*@FileTitle : Queue Report By Pol 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
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
     * @class esm_bkg_0424  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0424() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 //var rowsPerPage = 50;
 var rowsPerPage = 99999;
 
 var prefix = "sheet1_";//IBSheet 구분자
 
 
 var grp_cd ="";//Current Queue 조회를 위한 전역변수  
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	

 var bMultiComboDataAdded = false;
 var arrMultiCombo;//멀티콤보 세팅할 변수 
/**
	 * Total VVD MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
	 * 입력값을 upper로 변경하여 재등록 한다.
	 * @param comboObj
	 * @return
	 */
	function total_vvd_OnChange(comboObj) {
		var formObject = document.form;  
		
		// 사용자 입력값을 uppercase로 변경  
   	 	var comboText =  comboObj.Text.toUpperCase();
   	 	 
   	 	// 이전에 등록되었으면 삭제 
   	 	if (bMultiComboDataAdded) { 
	 			comboObj.DeleteItem(0); 
	 			bMultiComboDataAdded = false; 
   	 	} 
   	 	
   	 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
   	 	if (comboObj.FindIndex(comboText, 0) != -1) { 
   	 		return; 
   	 	} 

   	 	comboObj.InsertItem(0, comboText, comboText); 
	 		bMultiComboDataAdded = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수) 
	 		comboObj.Text2 = comboText;  // 입력값이 선택되게 한다. 

	 }  	
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
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
	 	    
		    initControl();
		 		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		    //form.p_vvd.focus();
		 	period_chk(); //기존에 radio 버튼  Click 외에 pageload 할때 부터 disable 하도록 함
		 		    
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
	 	 		if(comboId == "total_vvd" ){

		 	 		MultiSelect = false;
		 	 		UseAutoComplete = true; 
			 	  UseEdit = true;	 
			 	  DropHeight = 300;
			 	  //BackColor = "#ccfffd"; 
	 	 		}else if (comboId =="doc_part"){
	 	 			MultiSelect = true;
		 	 		UseAutoComplete = true; 
		 	 		UseEdit = true;
	 	 		}
	 	 		else{
		 	 		MultiSelect = false;
			 	  UseEdit = false;	 	 			
	 	 			
	 	 		}
	 	 	}
 	 }
 	      
   
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
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
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
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
	    	case "etd_from_dt":
	    		ComAddSeparator(event.srcElement);
	    		total_vvd_search();
					break;
	    	case "etd_to_dt":
	    		ComAddSeparator(event.srcElement);
	    		total_vvd_search();
					break;	    		
    		
	    	case "sr_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "sr_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
	    	case "pct_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "pct_to_dt":
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
				case "etd_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "etd_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;	    		
    		
	    	case "sr_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "sr_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;	    		
    		
	    	case "pct_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "pct_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;	
				default:
					break;
		}
	}  

/*********************** KEY EVENT END ********************/

function total_vvd_search(){
	//if(getRadioValue2(form.period_gubun) == "ETD" && !ComIsNull(form.etd_from_dt) && !ComIsNull(form.etd_to_dt)){
	if(!ComIsNull(form.etd_from_dt) && !ComIsNull(form.etd_to_dt)){
			doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	}
}

function initAll(formObj){
		formObj.reset();
		
		form.total_vvd.RemoveAll();
		formObj.list_by_queue.Code="";
		
	}
	  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick  = processButtonClick;

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
		 				case "btn_etd_dt":
							var cal = new ComCalendarFromTo();
							cal.select(formObject.etd_from_dt, formObject.etd_to_dt,'yyyy-MM-dd');
							break; 								
		 				case "btn_sr_dt":
							var cal = new ComCalendarFromTo();
							cal.select(formObject.sr_from_dt, formObject.sr_to_dt,'yyyy-MM-dd');
							break; 								
		 				case "btn_pct_dt":
							var cal = new ComCalendarFromTo();
							cal.select(formObject.pct_from_dt, formObject.pct_to_dt,'yyyy-MM-dd');
							break; 								
		 				case "btn_Retrieve":
		 					//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0421_DATA.html"); 
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "period_gubun":
		 						period_chk();						
							break; 
		 				case "btn_New":
		 					initAll(formObject);
		 					sheetObject1.RemoveAll();
		 					/* 모든 조건 까지 Clear 추후 삭제 될수 있음 */
			 					formObject.etd_from_dt.value ="";
			 					formObject.etd_to_dt.value ="";
			 					formObject.pol_cd.value ="";
			 					formObject.sr_from_dt.value ="";
			 					formObject.sr_to_dt.value ="";
			 					formObject.pct_from_dt.value ="";
			 					formObject.pct_to_dt.value ="";
		 					
		 					break;
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
 	   * List by Queue 멀티 콤보 조회 xml
 	   * */
		var list_by_Queue_xml = "";
		
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0422_DATA.html"); 
			 				if(!validateForm(sheetObj,formObj,sAction)) return;

			 				formObj.f_cmd.value = SEARCH;
			 				formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
							formObj.rows_per_page.value = rowsPerPage;
							
							ComAddSeparator(form.etd_from_dt);
							ComAddSeparator(form.etd_to_dt);
							ComAddSeparator(form.sr_from_dt);
							ComAddSeparator(form.sr_to_dt);
							ComAddSeparator(form.pct_from_dt);
							ComAddSeparator(form.pct_to_dt);
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0424GS.do", FormQueryString(formObj)+ "&" +  ComGetPrefixParam(prefix));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true; 
							if(ComGetEtcData(sXml, "ttl_bkg")== undefined){
								break;
							}
							formObj.ttl_bkg.value	            =   ComGetEtcData(sXml, "ttl_bkg");          
							formObj.inputter_queue.value	    =   ComGetEtcData(sXml, "inputter_queue");   
							formObj.sr_transferred.value	    =   ComGetEtcData(sXml, "sr_transferred");   
							formObj.inputting.value	          =   ComGetEtcData(sXml, "inputting");        
																								                                             
							formObj.sr_y.value	              =   ComGetEtcData(sXml, "sr_y");             
							formObj.rater_queue.value	        =   ComGetEtcData(sXml, "rater_queue");      
							formObj.inputted.value	          =   ComGetEtcData(sXml, "inputted");         
							formObj.rating.value	            =   ComGetEtcData(sXml, "rating");           
																								                                             
							formObj.sr_n.value	              =   ComGetEtcData(sXml, "sr_n");             
							formObj.auditor_queue.value	      =   ComGetEtcData(sXml, "auditor_queue");    
							formObj.rated.value	              =   ComGetEtcData(sXml, "rated");            
							formObj.auditing.value	          =   ComGetEtcData(sXml, "auditing");         
							formObj.audited.value	            =   ComGetEtcData(sXml, "audited");          
																								                                             
							formObj.stopped_queue.value	      =   ComGetEtcData(sXml, "stopped_queue");    
							formObj.fofc_returned.value	      =   ComGetEtcData(sXml, "fofc_returned");    
																								                                             
							formObj.queue_total.value	        =   ComGetEtcData(sXml, "queue_total");      								                                             
							
							formObj.BKG_matched_q.value	      =   ComGetEtcData(sXml, "bst_matched_q");
							formObj.bst_unmatched_q.value	    =   ComGetEtcData(sXml, "bst_unmatched_q");  
			 				break;
			 			case SEARCH01:      // List by Queue조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0424GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");
							ComXml2ComboItem(arrXml[0], formObj.list_by_queue, "val", "desc");
							//doc part
							ComXml2ComboItem(arrXml[1], formObj.doc_part, "val","desc");
							
							//formObj.list_by_queue.Code = '%';
							list_by_Queue_xml = sXml;
							
							break;
			 			case SEARCH02:      //Total VVD조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH02;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0424GS.do", FormQueryString(formObj));
							ComXml2ComboItem(sXml, formObj.total_vvd, "vvd_cd", "vvd_cd");
							break;
						case IBSEARCHAPPEND:  // 페이징 조회
							formObj.f_cmd.value = SEARCH;
              formObj.curr_page.value = PageNo;
              selectVal = FormQueryString(formObj);
              sheetObj.DoSearch4Post("ESM_BKG_0424GS.do", selectVal+ "&" + ComGetPrefixParam(prefix), "iPage=" + PageNo, true); 
           		break;  
						case IBDOWNEXCEL:   // 엑셀다운로드
							//sheetObj.Down2Excel();
							sheetObj.SpeedDown2Excel()
							break;							
						}
     }
     
     
     
	 /**
     * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
     */ 
	  function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	  }      

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
      switch(sAction) {
    		case IBSEARCH:
					if ( getRadioValue2(form.period_gubun) == "ETD"  && (ComIsNull(formObj.etd_from_dt) ||  ComIsNull(formObj.etd_to_dt)) ) {
	     					ComShowCodeMessage('BKG00626','ETD Period');
	     					if(ComIsNull(formObj.etd_from_dt))formObj.etd_from_dt.focus();
	     					else if(ComIsNull(formObj.etd_to_dt))formObj.etd_to_dt.focus();
	     					return false;
					}
					
					if(getRadioValue2(form.period_gubun) == "ETD" && ComIsNull(formObj.pol_cd)){
							ComShowCodeMessage('BKG00626','POL');
	     				formObj.dura_to_dt.focus();
							return false;
			  	}
			  	
					if ( getRadioValue2(form.period_gubun) == "SR"  && (ComIsNull(formObj.sr_from_dt) ||  ComIsNull(formObj.sr_to_dt)) ) {
	     					ComShowCodeMessage('BKG00626','SI Period');
	     					if(ComIsNull(formObj.sr_from_dt))formObj.sr_from_dt.focus();
	     					else if(ComIsNull(formObj.sr_to_dt))formObj.sr_to_dt.focus();
	     					return false;
					}
					if ( getRadioValue2(form.period_gubun) == "PCT"  && (ComIsNull(formObj.pct_from_dt) ||  ComIsNull(formObj.pct_to_dt)) ) {
	     					ComShowCodeMessage('BKG00626','PCT Period');
	     					if(ComIsNull(formObj.pct_from_dt))formObj.pct_from_dt.focus();
	     					else if(ComIsNull(formObj.pct_to_dt))formObj.pct_to_dt.focus();
	     					return false;
					}
					
	  			break;
     }
     
     return true;
    }
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    

 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // 높이 설정
                 style.height = 180;
                 
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(2, 1, 3, rowsPerPage);

                var HeadTitle1 = "Seq.|Booking Status|Booking Status|Queue List|Queue List|Queue List|Queue List|Queue List|Queue List|Shipper Code|Shipper Name|Consignee Name";
                var HeadTitle2 = "Seq.|Booking No.|SI|VVD|POL|POD|SI Kind|Status|Last Updated|Shipper Code|Shipper Name|Consignee Name";


                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);


                
								//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtDataSeq,			50,			daCenter,	true,	prefix + "seq"          	);
                InitDataProperty(0, cnt++ , dtData,			    120,		daCenter,	true,	prefix + "bkg_no",	  		false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,			    40,			daCenter,	true,	prefix + "sr",						false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,			    100,		daCenter,	true,	prefix + "vvd_cd",				false,   "",      dfNone,			0,     false,       false);

                InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,	prefix + "pol_cd",				false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,	prefix + "pod_cd",				false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,	prefix + "sr_knd_cd",			false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					130,		daCenter,	true,	prefix + "status",				false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,	prefix + "last_upd_dt", 	false,   "",      dfNone,			0,     false,       false);

                InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,	prefix + "shipper_code",	false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					200,		daLeft,		true,	prefix + "shipper_nm",		false,   "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,					200,		daLeft,		true,	prefix + "consignee_nm",	false,   "",      dfNone,			0,     false,       false);

								CountPosition = 0;
									
 						}
 				
 					break;
         
         }
     }
     function period_chk(){
    	 
     
    	 if(form.period_gubun[0].checked){
				form.etd_from_dt.disabled = false;
				form.etd_to_dt.disabled = false;
				form.pol_cd.disabled = false;
				form.etd_from_dt.className = "input1";
				form.etd_to_dt.className = "input1";
				form.pol_cd.className = "input1";
				
				form.sr_from_dt.value = "";
				form.sr_to_dt.value = "";
				form.pct_from_dt.value = "";
				form.pct_to_dt.value = "";
				
				form.sr_from_dt.className = "input2";
				form.sr_to_dt.className = "input2";
				form.pct_from_dt.className = "input2";
				form.pct_to_dt.className = "input2";
				
				form.sr_from_dt.disabled = true;
				form.sr_to_dt.disabled = true;
				form.pct_from_dt.disabled = true;
				form.pct_to_dt.disabled = true;
												
			}else if(form.period_gubun[1].checked){
				form.sr_from_dt.disabled = false;
				form.sr_to_dt.disabled = false;
				form.sr_from_dt.className = "input1";
				form.sr_to_dt.className = "input1";
				
				form.etd_from_dt.className= "input2";
				
				
				form.etd_from_dt.value = "";
				form.etd_to_dt.value = "";
				form.pol_cd.value = "";
				form.pct_from_dt.value = "";
				form.pct_to_dt.value = "";
				
				form.etd_from_dt.className = "input2";
				form.etd_to_dt.className = "input2";
				form.pol_cd.className = "input2";
				form.pct_from_dt.className = "input2";
				form.pct_to_dt.className = "input2";
				
				form.etd_from_dt.disabled = true;
				form.etd_to_dt.disabled = true;
				form.pol_cd.disabled = true;
				form.pct_from_dt.disabled = true;
				form.pct_to_dt.disabled = true;
				
			}else if(form.period_gubun[2].checked){
				form.pct_from_dt.disabled = false;
				form.pct_to_dt.disabled = false;
				
				form.pct_from_dt.className = "input1";
				form.pct_to_dt.className = "input1";
				
				form.etd_from_dt.value = "";
				form.etd_to_dt.value = "";
				form.pol_cd.value = "";
				form.sr_from_dt.value = "";
				form.sr_to_dt.value = "";
				
				form.etd_from_dt.className = "input2";
				form.etd_to_dt.className = "input2";
				form.pol_cd.className = "input2";
				form.sr_from_dt.className = "input2";
				form.sr_to_dt.className = "input2";
				
				form.etd_from_dt.disabled = true;
				form.etd_to_dt.disabled = true;
				form.pol_cd.disabled = true;
				form.sr_from_dt.disabled = true;
				form.sr_to_dt.disabled = true;
			} 
     }
     
    

	/* 개발자 작업  끝 */    