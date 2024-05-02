/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0953.js
*@FileTitle : O/B & T/S Loading Report by Location
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
     * @class esm_bkg_0953  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0953() {
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
 var rowsPerPage = 50;
 
 var prefix = "";//IBSheet 구분자
 
 
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
		    //sheetObjects[0].DoSearch("apps/alps/esm/bkg/bookingreport/statusreport/jsp/UI_BKG_0953_DATA.html");
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		 		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		    //form.p_vvd.focus();
		 		    
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
	 	 		if(comboId == "order_by" ){
	 	 			//alert(comboId);
		 	 		MultiSelect = true;
		 	 		UseAutoComplete = true; 
			 	  UseEdit = false;	 
			 	  DropHeight = 150;
	 	 		}
	 	 		else{
	 	 			DropHeight = 150;
		 	 		MultiSelect = false;
			 	  UseEdit = false;	 	 			
	 	 			
	 	 		}
	 	 	}
 	 }
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
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
    function bkg_deactivate() {
    	
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
	function bkg_activate(){
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

/*********************** KEY EVENT END ********************/

  
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
		 				case "btn_Retrieve":
			 				if(form.order_by.Code == ""){
			 					form.order_by.Code = "POL_CD";
			 				}
		 				  var arrSort = form.order_by.Code.split(",");
		 				  var arrTitle = form.order_by.Text.split(",");
		 				  
		 				  var orderbyTitleSql = "";
							var cnt = 0;
							for(var i=0; i < arrSort.length; i++){
									if(i==0){
										orderbyTitleSql = "'"+arrTitle[i]+":'||"+arrSort[i];
									}else{
										orderbyTitleSql += "'"+arrTitle[i]+":'||"+arrSort[i];
									}
									
									if(arrSort.length > 1 && i < arrSort.length-1){
										orderbyTitleSql += "||'     '||";
									}			
							}
							
							form.order_by_title.value =orderbyTitleSql;
		 					//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0953_DATA.html"); 
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
						case "btn_New":
		 					initAll(formObject);
		 					break;		 					
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "btn_period_date":
		 					var cal = new ComCalendarFromTo();
							cal.select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
		 					break;
		 					
						case "btn_shipper_pop":
	 						ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 450, 'setShipper', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"shipper_pop");
							break;		 				
						case "btn_0083LocPop":
						ComOpenPopup("ESM_BKG_0083.do", 830, 450, "callBack0083","1,0,1,1,1", true);
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
 
 
	function initAll(formObj){
			formObj.reset();
	} 

	/*
		 * Shipper 조회 결과를 세팅하는 콜백 메소드
		 * */
		function setShipper(val){
				var c_cd = val[0][3];
				form.shipper_cd.value=c_cd;
//				var c_name = val[0][4];
//				form.cust_cnt_cd.value=c_cd.substring(0,2);
//				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
//				form.cust_nm.value=c_name;
		} 
	
	
	
    /**
     * Customer Inquiry 팝업에서 전달받은 값 저장 <br>
     */
    function callBack0083(locTp, rArray){    	
    	var formObj = document.form;
    	if(rArray != null){
	    		formObj.location_cd.value    = rArray[0][4].substring(0,5);
	    		formObj.location_yd_cd.value = rArray[0][4].substring(5,7);
    	}
    } 
    	
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0953_DATA.html"); 
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
//			 				debug.innerHTML=FormQueryString(formObj);
			 				//alert(FormQueryString(formObj));
			 				//break;
			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0953_1GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							//alert(ComGetEtcData(sXml, "total_40t"));
							if(ComGetEtcData(sXml, "total_40t") == undefined){
								form.total_40t.value	= "";
								form.total_20t.value	= "";
								break;
							}
							
							form.total_40t.value	= ComGetEtcData(sXml, "total_40t");
							form.total_20t.value	= ComGetEtcData(sXml, "total_20t");
							
							break;
						case SEARCH01:      // List by Queue조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0953GS.do", FormQueryString(formObj));
							ComXml2ComboItem(sXml, formObj.order_by, "val", "desc");
//							list_by_Queue_xml = sXml;
							break;								
						case IBDOWNEXCEL:   // 엑셀다운로드
							sheetObj.Down2Excel();
							break;			
														
			    }
     }
     
     
     
     

     /*
      *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
      * 초기값은 쉬트 헤더 개수
      */ 
      var pagedMaxCnt=2; 
			/**
       * 조회후  이벤트 처리
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
   

			/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
     }	   

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if ( ComIsNull(formObj.location_cd)) {
		     					ComShowCodeMessage('BKG00626','Location');
		     					formObj.location_cd.focus();
		     					return false;	
	    		}else if ( ComIsNull(formObj.dura_from_dt) ||  ComIsNull(formObj.dura_to_dt)) {
	     					ComShowCodeMessage('BKG00626','Duration');
	     					if(ComIsNull(formObj.period_from_dt))formObj.dura_from_dt.focus();
	     					else if(ComIsNull(formObj.period_to_dt))formObj.dura_to_dt.focus();
	     					return false;
//					}else if ( ComGetDaysBetween(formObj.eta_from_dt.value,formObj.eta_to_dt.value) > 90) {
//						   ComShowCodeMessage('COM132001','Duration(ETA)','90Days')
//	     				 formObj.eta_to_dt.focus();
//	     					return false;	
					}else if ( ComIsNull(formObj.location_cd)) {
	     					ComShowCodeMessage('BKG00626','Location');
	     					formObj.location_cd.focus();
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
                 style.height = 382;
                 
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 //MergeSheet =  msHeaderOnly + msPrevColumnMerge ;
                 MergeSheet =  msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(2, 2, 3, rowsPerPage);

								var HeadTitle1 = "Seq.|BKG No.|Shipper Code|POL|POD|In-VVD|Out-VVD|FEU|TEU";
								var HeadTitle2 = "Seq.|B/L No.|Shipper Name|In-Lane|Out-Lane|In-TMNL|Out-TMNL|In-Zone|Out-Zone";
                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(false, false, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                
								//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		  "seq_no");
								InitDataProperty(0, cnt++ , dtData,			  120,	daCenter,	false,		"bkg_no",				false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,			  420,	daCenter,	false,		"shipper_cd",		false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pol_cd",				false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pod_cd",				false,		"",		dfNone,			0,		true,		true);
			
								InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	false,		"in_vvd",				false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	false,		"out_vvd",			false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		"feu",				  false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		"teu",				  false,		"",		dfNone,			0,		true,		true);
								
								cnt = 0;
								InitDataProperty(1, cnt++ , dtData,				60,		daCenter,	true,		  "seq_no");
								InitDataProperty(1, cnt++ , dtData,			  120,	daCenter,	false,		"bl_no",				false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,			  420,	daCenter,	false,		"shipper_nm",		false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,				60,		daCenter,	false,		"in_lane",			false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,				60,		daCenter,	false,		"out_lane",			false,		"",		dfNone,			0,		true,		true);
			                                    
								InitDataProperty(1, cnt++ , dtData,				100,		daCenter,	false,		"in_tmnl",			false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,				100,		daCenter,	false,		"out_tmnl",			false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,				70,		daCenter,	false,		"in_zone",			false,		"",		dfNone,			0,		true,		true);
								InitDataProperty(1, cnt++ , dtData,				70,		daCenter,	false,		"out_zone",			false,		"",		dfNone,			0,		true,		true);


//								SetMergeCell (0, 0, 2, 1); //lane								
//								SetMergeCell (0, 1, 2, 2); //pod
//								SetMergeCell (0, 3, 2, 1); //del
//								SetMergeCell (0, 4, 2, 1); //staff id
//								SetMergeCell (0, 5, 2, 1); //staff nm
//								SetMergeCell (0, 6, 2, 2); //vvd
//								SetMergeCell (0, 8, 2, 2); //ata
//								//   
//								SetMergeCell (0, 6, 2, 2); //ata  
//								
//								  
//								SetMergeCell (0, 10, 2, 1);  
//								SetMergeCell (0, 25, 2, 1);  
								
								CountPosition = 0;
								
								//MessageText("Sum") = "1st WEEK";
								
 						}
 				
 					break;
         
         }
     }
    

	/* 개발자 작업  끝 */    