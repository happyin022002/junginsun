/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1186.js
*@FileTitle : B/L(Manifest) Clearance Cross-Check List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* 2011.05.31 변종건 [CHM-201111165-01] BL Data Input Cross-check기능추가보완-Sailing Date 및 Multi-VVD Base검색조건 추가
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
* 2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
* 2012.04.09 채창호 [CHM-201217004-01]:컨테이너별 중량 표기 보완 요청
* 2013.04.16 김진주 [CHM-201324119] [BKG] 통합로그 Error 복구
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
     * @class esm_bkg_1186  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1186() {
    	this.processButtonClick = tprocessButtonClick;
    	this.setSheetObject = setSheetObject;
    	this.loadPage = loadPage;
    	this.initSheet = initSheet;
    	this.doActionIBSheet = doActionIBSheet;
    	this.setComboObject = setComboObject;
    	this.validateForm = validateForm;
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
 var rowsPerPage = 999999;
 
 var prefix = "sheet1_";//IBSheet 구분자
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	var p_no_goodMultiComboDataAdded = false;
	var p_eq_typeMultiComboDataAdded = false;
	var p_rcv_term_cdMultiComboDataAdded = false;
	var p_de_term_cdMultiComboDataAdded = false;
	var p_bkg_sts_cdMultiComboDataAdded = false;
	var p_cnmv_sts_cdMultiComboDataAdded = false;
	var p_bkg_cust_tp_cdMultiComboDataAdded = false;
	var p_del_contiMultiComboDataAdded = false;
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	
 	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
 	    if(comboId == "p_vvd" ){
 	    	comboObj.MultiSelect = true;
 	    	comboObj.UseEdit = false;
 	    	comboObj.BackColor = "#CCFFFD";
 	    } 
 	}
 	 
	
/*############################# combo onchage start ########################*/
	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject = document.form;  
        
		// 사용자 입력값을 uppercase로 변경  
   	 	var comboText =  comboObj.Text.toUpperCase();
   	 
   	 	// 이전에 등록되었으면 삭제 
   	 	if (multiComboDataAddedFlag) { 
	 		comboObj.DeleteItem(0); 
	 		multiComboDataAddedFlag = false; 
   	 	} 
   	 	
   	 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
   	 	if (comboObj.FindIndex(comboText, 0) != -1) { 
   	 		return; 
   	 	 
   	 	} 
   	 	
   	 	comboObj.InsertItem(0, comboText, comboText); 
	 	multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수) 
	 	comboObj.Text2 = comboText;  // 입력값이 선택되게 한다. 

	 }	 
	 
/*############################# combo onchage end ########################*/	
	
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
	     //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
	     setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
	    
	     form.vvd_sig.focus();	    
     }
	
   	
    
    function initControl() {
    	var formObject = document.form;

    	// 화면에서 필요한 이벤트
    	axon_event.addListenerForm("click", "obj_click", document.form);
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
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
	      case "engnum"://숫자+"영문대소"입력하기
  	  	  	ComKeyOnlyAlphabet('num'); 
	      	break;	    
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
/*********************** KEY EVENT END ********************/
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;

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
		 				case "btn_retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_new":
		 					location.reload(true);
		 					formObject.vvd_sig.focus();		 					
		 					break;		 					
		 				case "btn_downexcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "p_dt_type":
		 			    	if ( formObject.p_dt_type[0].checked ) {
		 			    		formObject.p_pol_lt.disabled = false;
		 			    	} else {
		 			    		formObject.p_pol_lt.selectedIndex = 1;
		 			    		formObject.p_pol_lt.disabled = true;
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
 

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			case SEARCH01:      //조회

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1186GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
			  	ComXml2ComboItem(arrXml[0], formObj.p_rhq_cd, "val", "desc");
			  	formObj.vvd_sig.focus();
				break;
			         
 			case IBSEARCH:      //조회
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				var sXml = "";
				formObj.f_cmd.value = SEARCH;
				sXml = sheetObj.GetSearchXml("ESM_BKG_1186GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "total_bkg") == undefined){
					formObj.total_bkg.value		   = 0;
					formObj.total_cntr_cnt.value   = 0;
					formObj.total_vgm_cnt.value	   = 0;
					formObj.total_no_vgm_cnt.value = 0;					
					break;
				}
				formObj.total_bkg.value		   = ComGetEtcData(sXml, "total_bkg");
				formObj.total_vgm_cnt.value	   = ComGetEtcData(sXml, "total_vgm_cnt");

				var preBkgNo = "";
				var nowBkgNo = "";
				var totalCntrCnt = 0;
				var totalVgmCnt = 0;
				var cntrCnt = 0;
				        	
				for( var i = 2; i < sheetObj.RowCount+2 ; i++){
					nowBkgNo = sheetObj.CellValue(i, prefix + "bkg_no");
					if ( preBkgNo != nowBkgNo) {
						cntrCnt = parseInt(sheetObj.CellValue(i, prefix + "total_cntr_cnt"),0);
						totalCntrCnt += cntrCnt;
						preBkgNo = nowBkgNo;
					}
				}
				totalVgmCnt = formObj.total_vgm_cnt.value;
				formObj.total_cntr_cnt.value = parseInt(totalCntrCnt,0);
				var temp = new Number( totalCntrCnt - totalVgmCnt ).toFixed(2)
				formObj.total_no_vgm_cnt.value  =  temp;
				
				if( formObj.p_pol_lt[1].selected ){
					sheetObj.ColHidden(prefix + "vps_etd_dt") = false;
					sheetObj.ColHidden(prefix + "vgm_set_dt") = false;					
				}else{
					sheetObj.ColHidden(prefix + "vps_etd_dt") = true;
					sheetObj.ColHidden(prefix + "vgm_set_dt") = true;
				}
				
				
				break;

			case IBDOWNEXCEL:   // 엑셀다운로드
				
				var columnSkipList = "";
				  
				sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");

				break;
					

         }
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    			
		    	var dtTypeText = "ETD";
		    	
		    	if ( formObj.p_dt_type[1].checked ) dtTypeText = "VGM Cut Off Time";
				
    			//VVD or ETD/VGM Cut Off Time Check
    			if(  ComIsNull(comboObjects[0].Code) && (ComIsNull(ComTrim(formObj.p_atd))||ComIsNull(ComTrim(formObj.p_etd))) )  {
    				ComShowCodeMessage('BKG40015','Multi-VVD or ETD / VGM Cut Off Time');
 					return false;    				
		  		}
    			//ETD / VGM Cut Off Time Check
    			else if ( !(ComIsNull(ComTrim(formObj.p_atd)) || ComIsNull(ComTrim(formObj.p_etd)))) {
    				
    				if(!ComIsNull(formObj.p_atd) && !ComIsDate(formObj.p_atd.value)){
    					ComShowCodeMessage( "BKG00651", formObj.p_atd.value);
    					return false;
    					
    				} else if(!ComIsNull(formObj.p_etd) && !ComIsDate(formObj.p_etd.value)){
    					ComShowCodeMessage( "BKG00651", formObj.p_etd.value);
    					return false;
    					
					} else if ( ComGetDaysBetween(formObj.p_atd.value, formObj.p_etd.value) +1 > 4 ){
	         			ComShowCodeMessage('COM132001',dtTypeText,'4Days');
	         			formObj.p_atd.focus();
	         			return false;
    				
					} else if(  (!ComIsNull(formObj.p_atd) && ComIsNull(formObj.p_etd)) ||  (ComIsNull(formObj.p_atd) && !ComIsNull(formObj.p_etd)) ){
    					ComShowCodeMessage( "BKG00714");
    					return false;

    				//ET , 	TS 선택했을 경우에는 POL 입력
    				} else if ( formObj.p_dt_type[0].checked && formObj.p_pol_lt[2].selected && ComIsNull(ComTrim(formObj.p_pol_cd))  ) {
    					ComShowCodeMessage('BKG00626','POL');
    					return false;
    					
    				}else if ( ComIsNull(ComTrim(formObj.p_pol_cd)) && ComIsNull(ComTrim(formObj.p_bkg_ofc_cd)) && formObj.p_rhq_cd.Index < 1  ) {
    					ComShowCodeMessage('BKG00626','POL or BKG OFC or RHQ');
    					return false;
    					
    				}
    				
   	    		//VVD    				
		  		}else if( !ComIsNull(comboObjects[0].Code) ) {
		    		if( comboObjects[0].Code.length < 9 ) {
	 					ComShowCodeMessage('BKG00538');
	 					formObj.vvd_sig.focus();
	 					return false;
			  		}
		  		}
		    	 formObj.multi_vvd.value = comboObjects[0].Code;
		    	  
		    	 var arVvds = formObj.multi_vvd.value.split(",");
		    	 
		    	 if (arVvds.length >  10){
		    		 ComShowCodeMessage("BKG02218");
		    		 return false;
		    	 }
	    	
	  			break;

    	}
         return true;
     }
     
     /**
      * 화면 yyyyMMd 날짜 체크
      */
     function dateCheck(dateobj){
     	if(dateobj.value =="") return true;//null이면 체크 안함
      return ComIsDate(dateobj.value);
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
                style.height = 400;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly +	msPrevColumnMerge;  

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, rowsPerPage);

				var HeadTitle1 = "No.|Booking No.|B/L No.|BKG.OFC|L.OFC|C.OFC|Status|Q'ty|Q'ty|Container|Container|Container|Container|Container|Container|Container|Container|Container|POR|POL|Terminal|POD|DEL|VVD|LANE|Booking\nReference No.|ETD|VGM Cut Off Time Date|Shipper|Shipper Name|QTY";
				var HeadTitle2 = "No.|Booking No.|B/L No.|BKG.OFC|L.OFC|C.OFC|Status|BKG|CNTR |No.|SZ|Weight|Weight|VGM|VGM|VGM|VGM|Vol|POR|POL|Terminal|POD|DEL|VVD|LANE|Booking\nReference No.|ETD|VGM Cut Off Time Date|Shipper|Shipper Name|QTY";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 10, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "dense_rank" ,     false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			86,	daCenter,	true,	prefix + "bkg_no",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			86,	daCenter,	true,	prefix + "bl_no",         	false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "bkg_ofc_cd",  	false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "ob_sls_ofc_cd",  	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "ctrt_ofc_cd",  	false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++ , dtData,			45,	daCenter,	true,	prefix + "bkg_sts_cd",     	false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "qty_bkg",        	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "qty_cntr",       	false,	"",	dfNone,	0,	false,	false);

				InitDataProperty(0,	cnt++ , dtData,			85,	daCenter,	false,	prefix + "cntr_no",       	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "sz",       	    false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_wgt",    	false,	"",	dfFloat,0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			35,	daCenter,	true,	prefix + "wgt_ut_cd",       false,	"",	dfNone,	0,	false,	false);

				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "vgm_wgt",    	    false,	"",	dfFloat,0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			35,	daCenter,	true,	prefix + "vgm_wgt_ut_cd",   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			99,	daLeft,		true,	prefix + "vgm_vrfy_sig_ctnt",   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "vgm_mzd_tp_cd",   false,	"",	dfNone,	0,	false,	false);

				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "vol",      	    false,	"",	dfNone,	0,	false,	false);
                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "por_cd",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60, daCenter,	true,	prefix + "pol_cd",     		false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtData,			60, daCenter,	true,	prefix + "pol_yd_cd",     	false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "pod_cd",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60, daCenter,	true,	prefix + "del_cd",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			70, daCenter,	true,	prefix + "vvd_cd",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			40, daCenter,	true,	prefix + "slan_cd",    		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			100, daCenter,	true,	prefix + "ref_no",		   	false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtHidden,		80, daCenter,	true,	prefix + "vps_etd_dt",      false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtHidden,		150, daCenter,	true,	prefix + "vgm_set_dt",   	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60, daCenter,	true,	prefix + "shipper",   	    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			200, daLeft,	true,	prefix + "shpr_name",       false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtHidden,		0,daLeft,		true,	prefix + "total_cntr_cnt",  false,	"",	dfNone,	0,	false,	false);

//				CountPosition = 0;
				
 			}
			break;

         }
     }


	 /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	 var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
     
     /**
	  * VVD Name Upper Event
  	  */
  	 function insertItm(vvd) {
		 var formObj  = document.form;
		 
		 if (vvd.value.length != 9){
			 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
			 vvd.focus();
			 return;
		 }
		 
		 comboObjects[0].InsertItem(-1, vvd.value, vvd.value);
		 comboObjects[0].Index2 = comboObjects[0].GetCount()-1;

		 vvd.value = "";
		 vvd.focus();
	 }
	 
     function clearVvds(){
    	 document.form.p_vvd.RemoveAll();
     }
     
 	 /**
	  * VVD Selection Inquiry Popup Value Import
	  */
     function setVvds(vvds){
    	  
		 var formObj = document.form;
    	 var comboObj = comboObjects[0];
    	  
    	 vvds = vvds.replace(/\s/g,"");
    	 var arVvds = vvds.split(",");
    	  
    	 for( var i = 0 ; i < arVvds.length ; i++ ){
    		 if( vvds.length > 0 ){
    			 comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
    		 }
    	 }
    	  
    	 comboObj.Text2 = vvds;
    	 formObj.vvd_sig.value = "";

     }
	  
      /**
       * ETD,ETB 기간 선택 달력 띄우기
       */
    	function callDatePop(val){
    		var cal = new ComCalendarFromTo();
    		if (val == 'ETD'){
    			cal.select(form.p_atd,  form.p_etd,  'yyyy-MM-dd');
    		}
    	}	  
     
/* 개발자 작업  끝 */    