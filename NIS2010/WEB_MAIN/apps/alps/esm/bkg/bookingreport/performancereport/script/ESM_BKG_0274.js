/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0274.js
*@FileTitle : O/B & T/S Loading Report by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.11.18 김보배 [CHM-201327122] [RFS Lane] Double calling logic 적용 요청 (1) Print by VVD /Port
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
     * @class esm_bkg_0274  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0274() {
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
		    //sheetObjects[0].DoSearch("apps/alps/esm/bkg/bookingreport/statusreport/jsp/UI_BKG_0274_DATA.html");
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
          var sheetObject2 = sheetObjects[1];
		  var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					//alert(document.form.ofc_cd.value);
		 					//sheetObject1.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html"); 
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
						case "btn_New":
		 					initAll(formObject);
		 					break;		 					
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
						case "btn_DownCntr":
							doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
							break;
						case "btn_Print":
							var selArr = getCheckedRowsByName(sheetObject1,"check","bkg_no");
							var selArr2 = getCheckedRowsByName(sheetObject1,"check","group_pol_pod");
							var bkg_nos = "";
							if(selArr == null){
		 						ComShowCodeMessage("COM12189");
		 						return;
							}
							for(var i=0;i < selArr.length;i++){
	        					bkg_nos += selArr[i]+"@"+selArr2[i];
	        					if( i < selArr.length -1 ) bkg_nos +="|";
						    }	
			                //ComOpenPopup("/hanjin/ESM_BKG_0064.do", 300, 200, "", "1,0,1,1,1,1,1,1,1,1", false,false, 0, 0, 0,"print_option");
							var form3 = document.form3;
							form3.bkg_no   .value = bkg_nos;
							form3.mode_type.value = getRadioValue2(formObject.mode_type);
							form3.vvd_cd   .value = formObject.vvd_cd.value;
							form3.pol_cd   .value = formObject.pol_cd.value;
							form3.pol_yd_cd.value = formObject.pol_yd_cd.value;
							form3.pod_cd   .value = formObject.pod_cd.value;
							form3.pod_yd_cd.value = formObject.pod_yd_cd.value;
			                ComOpenWindowCenter2("", "EsmBkg0064", 300,200,false,"scrollbars=no,resizable=no");
			                form3.target = "EsmBkg0064";
			                form3.action = "/hanjin/ESM_BKG_0064.do";
			                form3.submit();
		 					break;
		 					 
						case "btn_Sort":
			 				ComOpenWindowCenter2("/hanjin/ESM_BKG_0161.do?codeGubun=CD02377&isPop=Y", "OrderBy", 400,230,false,"scrollbars=no,resizable=yes");
		 				  break;  		 					
        		    
						case "btn_check_all":
							CellCheckAll(sheetObject1,true,"check");
							break;
							
						case "btn_uncheck_all":
							CellCheckAll(sheetObject1,false,"check");
	        		break;    
        		
        		case "mode_type":
							if(form.mode_type[0].checked){
								form.pol_cd.className = "input1";
								form.pod_cd.className = "input";
								for(var i=0;i < div_pre_post.length;i++){
        					div_pre_post[i].innerHTML = "Pre";
					    	}	
							}else if(form.mode_type[1].checked){
								form.pol_cd.className = "input";
								form.pod_cd.className = "input1";
								for(var i=0;i < div_pre_post.length;i++){
        					div_pre_post[i].innerHTML = "Post";
					    	}	
							} 
							
							break; 		
        		case "cargo_route":
							if(form.cargo_route[1].checked){
								form.fdr_vvd_cd.value = "";
								form.fdr_pol_cd.value = "";
								form.fdr_pol_yd_cd.value = "";
								form.fdr_pod_cd.value = "";
								form.fdr_pod_yd_cd.value = "";
								
								form.fdr_vvd_cd.disabled = true;
								form.fdr_pol_cd.disabled = true;
								form.fdr_pol_yd_cd.disabled = true;
								form.fdr_pod_cd.disabled = true;
								form.fdr_pod_yd_cd.disabled = true;
								
								form.fdr_vvd_cd.className = "input2";
								form.fdr_pol_cd.className = "input2";
								form.fdr_pol_yd_cd.className = "input2";
								form.fdr_pod_cd.className = "input2";
								form.fdr_pod_yd_cd.className = "input2";
							}else{
								form.fdr_vvd_cd.disabled = false;
								form.fdr_pol_cd.disabled = false;
								form.fdr_pol_yd_cd.disabled = false;
								form.fdr_pod_cd.disabled = false;
								form.fdr_pod_yd_cd.disabled = false;
								
								form.fdr_vvd_cd.className = "input";
								form.fdr_pol_cd.className = "input";
								form.fdr_pol_yd_cd.className = "input";
								form.fdr_pod_cd.className = "input";
								form.fdr_pod_yd_cd.className = "input";
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
	
	
	
/*
 * POP-UP에서 받는 Sort 세팅
 * */

function setOrderBy(val){
	form.order_by.value = val.split(",");
	//debug.innerHTML = form.order_by.value;
	
}
    	
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				if(form.order_by.value == ""){
		 						form.order_by.value = "POD_CD";
		 					}	
			 				//sheetObj.DoSearch("apps/alps/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html"); 
			 				if(!validateForm(sheetObj,formObj,sAction)) return;

			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0274_1GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							
							changeHeader();
							
							//alert(ComGetEtcData(sXml, "total_40t"));
							if(ComGetEtcData(sXml, "hd_vvd_cd") == undefined){
								if(form.mode_type[0].checked){
									form.hd_vvd_cd.value	   = form.vvd_cd.value;
									hd_pol_pod.innerHTML     = "POL";
									form.hd_pol_pod_cd.value = form.pol_cd.value;
									hd_eta_etd.innerHTML     = "ETD";
									form.hd_eta_etd_cd.value = "";
									form.hd_mode_type.value	 = "Outbound";									
								}else{
									form.hd_vvd_cd.value	   = form.vvd_cd.value;
									hd_pol_pod.innerHTML     = "POD";
									form.hd_pol_pod_cd.value = form.pod_cd.value;
									hd_eta_etd.innerHTML     = "ETA";
									form.hd_eta_etd_cd.value = "";
									form.hd_mode_type.value	 = "Inbound";
								}
								break;
							}
							
							form.hd_vvd_cd.value	   = ComGetEtcData(sXml, "hd_vvd_cd");
							hd_pol_pod.innerHTML     = ComGetEtcData(sXml, "hd_pol_pod");
							form.hd_pol_pod_cd.value = ComGetEtcData(sXml, "hd_pol_pod_cd");
							hd_eta_etd.innerHTML= ComGetEtcData(sXml, "hd_eta_etd");
							form.hd_eta_etd_cd.value = ComGetEtcData(sXml, "hd_eta_etd_cd");
							form.hd_mode_type.value	 = ComGetEtcData(sXml, "hd_mode_type");
							break;
						case SEARCH01:      // List by Queue조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0274GS.do", FormQueryString(formObj));
							ComXml2ComboItem(sXml, formObj.order_by, "val", "desc");
//							list_by_Queue_xml = sXml;
							break;								
						case IBDOWNEXCEL:   // 엑셀다운로드
							sheetObj.Down2Excel();
							break;			
						case IBSEARCH_ASYNC01:   // 엑셀다운로드(by CNTR)
							
							var ofc_cd = form.ofc_cd.value;
							if(form.order_by.value == ""){
		 						form.order_by.value = "POD_CD";
		 					}	
			 				if(!validateForm(sheetObj,formObj,sAction)) return;

			 				formObj.f_cmd.value = SEARCH01;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							ComOpenWait(true);
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0274GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true;
							if(ofc_cd == "CMBBA"||ofc_cd == "BOMBA"||ofc_cd == "BOMSC"){
								changeHeader2(sheetObj);
								sheetObj.Down2Excel();
							}else{
								sheetObj.Down2Excel(-1);
							}
							
							ComOpenWait(false);
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
	    		if ( ComIsNull(formObj.vvd_cd)) {
		     					ComShowCodeMessage('BKG00626','VVD');
		     					formObj.vvd_cd.focus();
		     					return false;	
		     				
	    		}else if ( formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
	     					ComShowCodeMessage('BKG00626','POL');
	     					formObj.pol_cd.focus();
	     					return false;
	    		}else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
	     					ComShowCodeMessage('BKG00626','POD');
	     					formObj.pod_cd.focus();
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
    
		var cHeadTitle1 = "||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Pre VVD|Pre POL|Pre POL|Pre POD|Pre POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA";
		var cHeadTitle2 = "||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Post VVD|Post POL|Post POL|Post POD|Post POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA";

		/**
      * Mode값에 따른 시트 초기설정값, 헤더 정의
      */
	 function changeHeader(){
	 	if(form.mode_type[0].checked){
		 	sheetObjects[0].InitHeadRow(0, cHeadTitle1, true);
		}else{
		 	sheetObjects[0].InitHeadRow(0, cHeadTitle2, true);
		}
	 }
	 
	 
	 function changeHeader2(sheetObj){
		 sheetObj.ColHidden("mk_desc") = false;
		 sheetObj.ColHidden("cmdt_desc") = false;
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
            	style.height = 326;
                 
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
								InitRowInfo(1, 1, 3, rowsPerPage);
								
								var HeadTitle1 = "||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Pre VVD|Pre POL|Pre POL|Pre POD|Pre POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA| GROUP_POL_POD|lane";
								
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, false);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(false, false, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
				//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtData,	      20,		daCenter,	false,	  "check");
				InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		"seq",           false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		"bkg_no",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"bl_no",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"por_cd",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pol_cd",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"pol_yd_cd",	 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pod_cd",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"pod_yd_cd",	 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"del_cd",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"del_yd_cd",	 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				20,		daCenter,	false,		"rd_cd1",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				20,		daCenter,	false,		"rd_cd2",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		"pre_vvd",		 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pre_pol_cd",	 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pre_pol_yd_cd", false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pre_pod_cd",	 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"pre_pod_yd_cd", false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		"lt",			 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		"ef",			 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		"pkg1",			 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"pkg2",			 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"wgt1",			 false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"wgt2",			 false,		"",		dfNone,			0,		false,		false);
				
				InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	false,		"so_no",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"rep",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"as_cd",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"dg",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"rf ",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"aw",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"bb",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		"bdr",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"ca",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	false,		"group_pol_pod",false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	false,		"slan_cd",		false,		"",		dfNone,			0,		false,		false);
				

				CountPosition = 0;

				
 						}
 				
 					break;
         
            case "sheet2":
            	with (sheetObj) {
            	// 높이 설정
            	style.height = 0;
            	
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
            	InitRowInfo(1, 1, 3, rowsPerPage);
            	
            	var HeadTitle1 = "|B/L No.|BKG No.|B/L Type|CNTR No.|Type|Seal No.|PKG|PKG Type|Weight|Volume|Marks & Nos|Description|Description of Goods|POR|POL|POD|DEL|Shipper Code|Shipper Name|Shipper Addr.|Consignee Code|Consignee Name|Consignee Addr.|Notify|Notify Addr.|Pre/Post VVD|Pre/Post POL|Pre/Post POD";
            	//var HeadTitle1 = "|B/L No.|BKG No.|B/L Type|CNTR No.|Type|Seal No.|PKG|PKG Type|Weight|Volume|Description|POR|POL|POD|DEL|Shipper Code|Shipper Name|Shipper Addr.|Consignee Code|Consignee Name|Consignee Addr.|Notify|Notify Addr.|Pre/Post VVD|Pre/Post POL|Pre/Post POD";

            	var headCount = ComCountHeadTitle(HeadTitle1);
            	
            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 0, 0, false);

                
            	
            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
            	InitHeadMode(false, false, true, true, false,false)
            	
            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle1, true);
            	
            	//데이터속성    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtDataSeq,			40,		daCenter,	false,		"seq",           		 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"bl_no",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"bkg_no",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				150,	daCenter,	false,		"bl_tp",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"cntr_no",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"cntr_tpsz_cd",			 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"seal_no",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"pck_qty",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"pck_tp_cd",		     false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"cntr_wgt",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"meas_qty",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		"mk_desc",			     false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"cstms_desc",			 false,		"",		dfNone,			0,		false,		false);           	
            	InitDataProperty(0, cnt++ , dtHidden,			180,    daCenter,	false,		"cmdt_desc",			 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"por_cd",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pol_cd",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"pod_cd",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	false,		"del_cd",				 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"s_cd",				     false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"s_nm",				     false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				200,	daCenter,	false,		"s_ad",				 	 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"c_cd",				     false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"c_nm",				 	 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				200,	daCenter,	false,		"c_ad",				 	 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		"n_nm",				 	 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,				200,	daCenter,	false,		"n_ad",				 	 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"pre_post_vvd",			 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"pre_post_pol_cd",		 false,		"",		dfNone,			0,		false,		false);
            	InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"pre_post_pod_cd",		 false,		"",		dfNone,			0,		false,		false);
            	CountPosition = 0;
 	
            }
            	
            	break;
            	
         }
     }  

	/* 개발자 작업  끝 */    