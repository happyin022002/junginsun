/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0304.js
*@FileTitle : esm_bkg_0304
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.07 경종윤
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
     * @class esm_bkg_0304 : esm_bkg_0304 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0304() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

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
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
				case "btn_new":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
				                      
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;  
				
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, REMOVE);
					break;   
					
				case "btn_popup1" :
	 	  	  		var sUrl = "/hanjin/ESM_BKG_0334_Q.do";
	 	  	  		//var params = "?otr_dchg_cd="+formObject.form1_port_cd.value;
	 	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 720, 450, true);
	 	  			if (rtnVal != null){
	 	  				formObject.form1_port_cd.value = rtnVal.cd;
	 	  			}
					break;

				case "btn_popup2" :
					
	 	  	  		var sUrl = "/hanjin/ESM_BKG_0305.do";
	 	  			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0305", 1010, 430, true);
	 	  			if (rtnVal != null){
	 	  				formObject.form1_ida_cfs_id.value = rtnVal.cd;
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
 	 * Sheet 기본 설정 및 초기화
 	 * body 태그의 onLoad 이벤트핸들러 구현
 	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 	 */
 	function loadPage() {
 		
 		var formObj = document.form;

 	    for(i=0;i<sheetObjects.length;i++){

 	        ComConfigSheet (sheetObjects[i] );

 	        initSheet(sheetObjects[i],i+1);

 	        ComEndConfigSheet(sheetObjects[i]);
 	         
 	    }
 	    
 	    //화면에서 필요한 이벤트
	   	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	   	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	   	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 	    
 	}
 	
	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
    	
		initSheetData(sheetObjects[0], formObj);
 	   
	   	ComSetFocus(formObj.form1_vvd_cd);
 
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

	    var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
			
			case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 302;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 3, 100);
						
						//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
						var HeadTitle1 = "| |vvd_cd|vsl_cd|skd_voy_no|skd_dir_cd|pod_cd|ida_decl_vsl_no|ida_yr_no|vsl_decl_dt|vsl_nm|call_sgn_no|ida_voy_no|ida_line_no|ida_agn_id|cnt_cd|port_cd|arr_dt|arr_dt2|ida_cfs_id|ib_area_cd|ibd_no|trns_opr_id|crr_agn_cd|ida_mrn_line_opr_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt|ida_vsl_imo_no|ida_cstms_hus_no|ida_tml_opr_no|ida_port_gnte_no|ida_port_gnte_dt";
						var headCount = ComCountHeadTitle(HeadTitle1);

						
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,	daCenter,		true,		"ibflag");
						InitDataProperty(0,		cnt++ , dtSeq,					50,	daCenter,		true,		"Seq");
						InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vvd_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daCenter,		true,		"vsl_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_voy_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"skd_dir_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"pod_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_decl_vsl_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_yr_no", false, "", dfNone, 0, false, false);
						
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_decl_dt", false, "",  dfDateYmd, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"vsl_nm", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"call_sgn_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_voy_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_line_no", false, "", dfNone, 0, false, false);
						
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_agn_id", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"cnt_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"port_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"arr_dt", false, "", dfDateYmd, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"arr_dt2", false, "", dfDateYmd, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_cfs_id", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"bd_area_cd", false, "", dfNone, 0, false, false);

						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ibd_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"trns_opr_id", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"crr_agn_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_mrn_line_opr_cd", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"cre_usr_id", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"cre_dt", false, "", dfNone, 0, false, false);

						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"upd_usr_id", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"upd_dt", false, "", dfNone, 0, false, false);

						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_vsl_imo_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_cstms_hus_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_tml_opr_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_port_gnte_no", false, "", dfNone, 0, false, false);
						InitDataProperty(0,		cnt++ , dtData,					50,	daLeft,			true,		"ida_port_gnte_dt", false, "", dfDateYmd, 0, false, false);
						
						InitViewFormat(0, "vsl_decl_dt", "yyyymmdd");
						InitViewFormat(0, "arr_dt", "yyyymmdd");
						InitViewFormat(0, "arr_dt2", "yyyymmdd");
						InitViewFormat(0, "ida_port_gnte_dt", "yyyymmdd");

						CountPosition = 0;

						WaitImageVisible=false;
				}
				break;


		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH :	//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				
				formObj.vvd_cd.value = formObj.form1_vvd_cd.value;
				formObj.pod_cd.value = formObj.form1_pod_cd.value;
				
				
				sheetObj.DoSearch("ESM_BKG_0304GS.do", FormQueryString(formObj) );

	            if(sheetObj.RowCount == 1){	
//					alert(sheetObj.CellValue(1,"ida_mrn_line_opr_cd"));
		            IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");

					formObj.form1_vsl_decl_dt.value	=ComGetMaskedValue(formObj.form1_vsl_decl_dt.value, "ymd");
					formObj.form1_arr_dt.value		=ComGetMaskedValue(formObj.form1_arr_dt.value, "ymd");
					formObj.form1_arr_dt2.value		=ComGetMaskedValue(formObj.form1_arr_dt2.value, "ymd");
					formObj.form1_ida_port_gnte_dt.value		=ComGetMaskedValue(formObj.form1_ida_port_gnte_dt.value, "ymd");
					
										
	            } else if(sheetObj.RowCount == 0){
	            	initSheetData(sheetObj, formObj);

					formObj.form1_vvd_cd.value = formObj.vvd_cd.value;
					formObj.form1_pod_cd.value = formObj.pod_cd.value;
					
	            }
	            	            
//	            if(formObj.pod_cd.value == "INNAH"){
//	            	formObj.form1_ida_mrn_line_opr_cd2.value = formObj.form1_ida_mrn_line_opr_cd.value;
//	            	formObj.form1_ida_mrn_line_opr_cd.style.width = "180";
//	            	formObj.form1_ida_mrn_line_opr_cd.maxLength = 20;
//	            	formObj.form1_ida_mrn_line_opr_cd2.className = "input2";
//	            	formObj.form1_ida_mrn_line_opr_cd2.readOnly=true;
//	            }else {
//	            	formObj.form1_ida_mrn_line_opr_cd2.value = formObj.form1_ida_mrn_line_opr_cd.value;
//	            	formObj.form1_ida_mrn_line_opr_cd.value = formObj.form1_crr_agn_cd.value;
//	            	formObj.form1_ida_mrn_line_opr_cd.style.width = "80";
//	            	formObj.form1_ida_mrn_line_opr_cd.maxLength = 6;
//	            	formObj.form1_ida_mrn_line_opr_cd2.className = "input";
//	            	formObj.form1_ida_mrn_line_opr_cd2.readOnly=false;
//	            	
////						document.getElementById ("form1_ida_mrn_line_opr_cd").maxLength = 6;						
//	            }

	            	formObj.form1_ida_mrn_line_opr_cd2.value = formObj.form1_ida_mrn_line_opr_cd.value;
	            ComOpenWait(false);
	            

				break;
				
			
		    case IBINSERT :	// 초기화
		    	initSheetData(sheetObj, formObj);
				ComSetFocus(formObj.form1_vvd_cd);
		        break;
				
		    case IBSAVE :	// 저장,수정
		    	
		    	if(!validateForm(sheetObj,formObj,sAction))return;
		    	
		    	
		    	if(formObj.form1_ida_yr_no.value == "") {
		    		formObj.form1_ida_yr_no.value = ComGetNowInfo("yy").substr(2,2);
		    	}

		        IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		        
//		        if(formObj.form1_pod_cd.value != "INNAH"){
//		        	sheetObj.CellValue(1,"crr_agn_cd") = formObj.form1_ida_mrn_line_opr_cd.value;
//		        	sheetObj.CellValue(1,"ida_mrn_line_opr_cd") = formObj.form1_ida_mrn_line_opr_cd2.value;		        			       
//		        }
		        		        		       
//		        alert(sheetObj.CellValue(1,"ida_mrn_line_opr_cd"));
//		        alert(formObj.form1_ida_mrn_line_opr_cd.value);
//		        alert(formObj);		       
		        ComOpenWait(true);
		    	formObj.f_cmd.value = MULTI;
		        sheetObj.DoSave("ESM_BKG_0304GS.do", FormQueryString(formObj), -1, false);
//		        
//		        if(formObj.form1_pod_cd.value == "INNAH"){
//		        formObj.form1_ida_mrn_line_opr_cd2.value = formObj.form1_ida_mrn_line_opr_cd.value;
//		        }
		        formObj.form1_ida_mrn_line_opr_cd2.value = formObj.form1_ida_mrn_line_opr_cd.value;
		        ComOpenWait(false);
		    	
		    	break;
		    	
		    case REMOVE: // 삭제	
		    	
		    	if(!validateForm(sheetObj,formObj,sAction))return;
		    	
		    	ComOpenWait(true);
		    	sheetObj.RowStatus(1) = "D";
		    	formObj.f_cmd.value = MULTI;
		    	formObj.f_cmd_detail.value = "D";
		        sheetObj.DoSave("ESM_BKG_0304GS.do", FormQueryString(formObj), -1, false);
		        ComOpenWait(false);
		        
		        initSheetData(sheetObj, formObj);
		    	break;
	    
		}
	}
	
	// 시트 데이터 초기화
	function initSheetData(sheetObj, formObj) {
		
		//formObj.vvd_cd.value = "";
		//formObj.pod_cd.value = "";
		
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);	
		formObj.form1_ida_mrn_line_opr_cd2.value = "";
		
//		formObj.form1_ida_mrn_line_opr_cd.style.width = "80";
//    	formObj.form1_ida_mrn_line_opr_cd.maxLength = 6;
//    	formObj.form1_ida_mrn_line_opr_cd2.className = "input";
//    	formObj.form1_ida_mrn_line_opr_cd2.readOnly=false;

		IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");		
	}

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 
  	    switch(sAction) {
			case IBSEARCH: { // 조회
			    
				//기본포멧체크
				//if (!ComChkValid(formObj)) return false;
				
				if(!ComChkObjValid(formObj.form1_vvd_cd) || !ComChkObjValid(formObj.form1_pod_cd)) return false; 
				
				break;
			}
			
			case IBSAVE: { // 입력
				
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				
				if (formObj.form1_call_sgn_no.value == "") {
					ComShowCodeMessage('BKG00715', "VSL Code(Call Sign)");
					ComSetFocus(formObj.form1_call_sgn_no);
					return false;
				}
	
				if (formObj.form1_ida_voy_no.value == "") {
					ComShowCodeMessage('BKG00715', "Voyage");
					ComSetFocus(formObj.form1_ida_voy_no);
					return false;
				}
	
				if (formObj.form1_ida_mrn_line_opr_cd.value == "") {
					ComShowCodeMessage('BKG00715', "Agent Code");
					ComSetFocus(formObj.form1_crr_agn_cd);
					return false;
				}
	
				if (formObj.form1_port_cd.value == "") {
					ComShowCodeMessage('BKG00715', "Port of Arrival");
					ComSetFocus(formObj.form1_port_cd);
					return false;
				}
	
				if (formObj.form1_ida_cfs_id.value == "") {
					ComShowCodeMessage('BKG00715', "CFS Code");
					ComSetFocus(formObj.form1_ida_cfs_id);
					return false;
				}
				
				if(formObj.form1_ida_yr_no.value != "") {
					var yy = parseInt(formObj.form1_ida_yr_no.value); 

					if(ComChkLen(formObj.form1_ida_yr_no.value, 2) != "2" || (yy <= 0 && yy >= 13 ) ) {
						//ComAlertFocus(formObj.form1_ida_yr_no, "IGM YEAR는 2자리 숫자[01 - 12] 입니다.");
						ComShowCodeMessage('BKG00651', "IGM YEAR");
						ComSetFocus(formObj.form1_ida_yr_no);
						return false;					
					}
					
				}
				
				
				break;
			}
			
	 	    case REMOVE : { // 삭제
	 	    	
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
	 	    	
				if(sheetObj.RowCount == 0) {
					ComShowCodeMessage('BKG00889');
					return false;
				}
				
				if(sheetObj.RowCount == 1) {
					
					if(sheetObj.CellValue(1,"vvd_cd") == "" || sheetObj.CellValue(1,"pod_cd") == "") {
						ComShowCodeMessage('BKG00889');
						return false;
					}
				}
				
	 	    	break;
	 	    }
			
	
  	    } // end switch

	    return true;
     }
     
	/**
	 * 저장 후 이벤트
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI && document.form.f_cmd_detail.value != "D") {
				ComShowCodeMessage('BKG00102');
				return false;
			} 
			
			if(document.form.f_cmd_detail.value == "D") {
				ComShowCodeMessage('BKG00593');
				return false;
			}
		} 
    }
    
    /**
     * 조회 후 이벤트
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		
		if (ErrMsg == "") {

			if(sheetObj.Rowcount == 0) {
				ComShowCodeMessage('BKG00800');
			}
			
		} 
	}
	
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	/*
    	if (srcName == "form1_vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	*/
    	
    }
	
   

	/* 개발자 작업  끝 */