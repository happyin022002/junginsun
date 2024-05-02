/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0410.js
*@FileTitle : Performance Report by Volume
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
     * @class esm_bkg_0410  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0410() {
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
		    //sheetObjects[0].DoSearch("apps/alps/esm/bkg/bookingreport/statusreport/jsp/UI_BKG_0410_DATA.html");
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
	 	 		if(comboId == "pfm_by_queue_cd" ){
	 	 			DropHeight = 150;
		 	 		MultiSelect = false;
		 	 		UseEdit = false;	 	 				
	 	 			BackColor = "#ccfffd";	 	 		
	 	 		}else if (comboId == "doc_part"){
	 	 			DropHeight = 150;
		 	 		MultiSelect = true;
		 	 		UseEdit = false;
	 	 		}else if (comboId == "dpcs_ofc_cd"){
	 	 			DropHeight = 150;
		 	 		MultiSelect = false;
		 	 		UseEdit = false;	 	 				
	 	 			BackColor = "#ccfffd";	 	 	
	 	 		}else{
	 	 			DropHeight = 150;
		 	 		MultiSelect = false;
		 	 		UseEdit = false;	 	 				 	 			
	 	 		}
	 	 	}
 	 }
    
    function initControl() {
    	var formObject = document.form;

        //axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        
        ComSetObjValue(formObject.from_dt,ComGetNowInfo());
     		ComSetObjValue(formObject.to_dt,ComGetNowInfo());
        
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
	    	case "from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "to_dt":
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
	    	case "from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "to_dt":
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
		 					//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0410_DATA.html"); 
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
						case "btn_New":
		 					initAll(formObject);
		 					break;		 					
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
						case "btn_Weight":
							ComOpenWindowCenter("ESM_BKG_0412.do?isPop=Y", "ESM_BKG_0412", 900, 490, false);
		 					break;		 					
						case "btn_Print":
		 					break;
						case "btn_period":
		 					var cal = new ComCalendarFromTo();
							cal.select(formObject.from_dt, formObject.to_dt,'yyyy-MM-dd');
		 			
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

	
	

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회

			 				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0410_DATA.html"); 
			 				if(!validateForm(sheetObj,formObj,sAction)) return;

			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0410GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
													
							//alert(ComGetEtcData(sXml, "total_40t"));
							if(ComGetEtcData(sXml, "tot_staffs") == undefined){
								form.tot_staffs.value	            =  "";
								form.tot_sr_vol.value	            =  "";
								form.tot_sr_kind.value	          =  "";
								form.tot_bkg_vol.value	          =  "";
																									   "";
								form.tot_staffs_inputter.value	  =  "";
								form.tot_sr_vol_inputter.value	  =  "";
								form.tot_sr_kind_new.value	      =  "";
																									   "";
								form.tot_staffs_rater.value	      =  "";
								form.tot_sr_vol_rater.value	      =  "";
								form.tot_sr_kind_amend.value	    =  "";
																									   "";
								form.tot_staffs_auditor.value	    =  "";
								form.tot_sr_vol_auditor.value	    =  "";
								form.tot_sr_kind_bl_cnfm.value	  =  "";
																									   "";
								form.tot_staffs_fofc.value	      =  "";
								form.tot_sr_vol_fofc.value	      =  "";
								form.tot_sr_kind_addition.value	  =  "";
								break;
							}
							form.tot_staffs.value	            = ComGetEtcData(sXml, "tot_staffs");          
							form.tot_sr_vol.value	            = ComGetEtcData(sXml, "tot_sr_vol");          
							form.tot_sr_kind.value	          = ComGetEtcData(sXml, "tot_sr_kind");         
							form.tot_bkg_vol.value	          = ComGetEtcData(sXml, "tot_bkg_vol");         
																								                                             
							form.tot_staffs_inputter.value	  = ComGetEtcData(sXml, "tot_staffs_inputter"); 
							form.tot_sr_vol_inputter.value	  = ComGetEtcData(sXml, "tot_sr_vol_inputter"); 
							form.tot_sr_kind_new.value	      = ComGetEtcData(sXml, "tot_sr_kind_new");     
																								                                             
							form.tot_staffs_rater.value	      = ComGetEtcData(sXml, "tot_staffs_rater");    
							form.tot_sr_vol_rater.value	      = ComGetEtcData(sXml, "tot_sr_vol_rater");    
							form.tot_sr_kind_amend.value	    = ComGetEtcData(sXml, "tot_sr_kind_amend");   
																								                                             
							form.tot_staffs_auditor.value	    = ComGetEtcData(sXml, "tot_staffs_auditor");  
							form.tot_sr_vol_auditor.value	    = ComGetEtcData(sXml, "tot_sr_vol_auditor");  
							form.tot_sr_kind_bl_cnfm.value	  = ComGetEtcData(sXml, "tot_sr_kind_bl_cnfm"); 
																								                                             
							form.tot_staffs_fofc.value	      = ComGetEtcData(sXml, "tot_staffs_fofc");     
							form.tot_sr_vol_fofc.value	      = ComGetEtcData(sXml, "tot_sr_vol_fofc");     
							form.tot_sr_kind_addition.value	  = ComGetEtcData(sXml, "tot_sr_kind_addition");

							break;
						case SEARCH01:      // List by Queue조회
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0410GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");
							/* doc part */
						  ComXml2ComboItem(arrXml[0], formObj.doc_part, "val", "name");
						    /*S/R Kind*/
						  ComXml2ComboItem(arrXml[1], formObj.sr_knd_cd, "val", "name");
						    /*Performance by Queue*/
						  ComXml2ComboItem(arrXml[2], formObj.pfm_by_queue_cd, "val", "name");
						    /* Doc OFC */
						  ComXml2ComboItem(arrXml[3], formObj.dpcs_ofc_cd, "val", "name");
						  
						  formObj.pfm_by_queue_cd.Code = '%';
						  formObj.sr_knd_cd.Code = 'L';
						  
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
	    		if ( ComIsNull(formObj.from_dt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.from_dt.focus();
		     					return false;	
		     				
	    		}else if ( ComIsNull(formObj.from_mt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.from_mt.focus();
		     					return false;	
					}else	if ( ComIsNull(formObj.to_dt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.to_dt.focus();
		     					return false;	
		     				
	    		}else if ( ComIsNull(formObj.to_mt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.to_mt.focus();
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
                style.height = 302;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet =  msHeaderOnly + msPrevColumnMerge ;
//                MergeSheet =  msAll;
                MergeSheet =  msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, rowsPerPage);

//				var HeadTitle1 = "Seq.|Queue|PIC|SI Kind|Booking No.|VVD|POL|POD|SR No.";
				var HeadTitle1 = "Seq.|PIC-User ID|User Name|User Group|Region|BKG Nbr.|S/I Nbr.|SI Kind|Urgent|SRC|RTN Freq.|Amend Freq.|VVD|POL|DEL|BKG OFC|Rider |Rider.P |C/M Count|C/M.P|CNTR Count|CNTR.P|House.P|Rate Type|Self Audit|Pre-Rate|RFA.P|TAA.P|S/C.P|Self.P|Pre-rate.P|I|R|Q|F|STS|Total Point|Input\n(Min.)|Rate\n(Min.)|QA\n(Min.)|Total\n(Min.)";
               
               var headCount = ComCountHeadTitle(HeadTitle1);

               //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
               InitColumnInfo(headCount, 0, 0, false);

               // 해더에서 처리할 수 있는 각종 기능을 설정한다
               //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
               InitHeadMode(true, false, true, true, false,false)

               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, HeadTitle1, true);
               
				//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,			50,			daCenter,	false,	"seq_no");
				InitDataProperty(0, cnt++ , dtData,			90,			daCenter,	false,	"cre_usr_id",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			90,			daLeft,  	false,	"name",			false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	"user_group",	false,          "",      dfNone,			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"region",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	"bkg_no",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	"si_no",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	true,	"si_kind",		false,          "",      dfNone,			0,     false,       false);
														
				InitDataProperty(0, cnt++ , dtData,			50,  		daCenter,	false,	"urgent",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			50,  		daCenter,	false,	"src",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"rtn_freq",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"amend_freq",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			90, 		daCenter,	false,	"vvd",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"pol_cd",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"del_cd",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"bkg_ofc_cd",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"rider_count",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"ri_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"cm_count",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"cm_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"cntr_cnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"cn_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"h_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"rate_type",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"self_audit",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"pre_rate",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"rfa_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"taa_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"sc_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"self_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"pre_pnt",		false,          "",      dfNone,			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,			30,		    daCenter,	false,	"i_flg",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			30,		    daCenter,	false,	"r_flg",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			30,		    daCenter,	false,	"q_flg",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			30,		    daCenter,	false,	"f_flg",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			50, 		daCenter,	false,	"sts",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70, 		daCenter,	false,	"tot_pnt",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"input_elapsed",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"rate_elapsed",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"qa_elapsed",		false,          "",      dfNone,			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80, 		daCenter,	false,	"tot_elapsed",		false,          "",      dfNone,			0,     false,       false);

				
				CountPosition = 0;

							
				}
		
			break;
        
        }
    }
    

	/* 개발자 작업  끝 */    