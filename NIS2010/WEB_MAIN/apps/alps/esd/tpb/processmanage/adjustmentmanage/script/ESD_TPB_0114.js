/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0114.js
*@FileTitle : TPB Write-Off
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-05
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2008-08-12 O Wan-Ki  1.0 최초 생성
* 2009-10-05 Sun, Choi 1.1 ALPS Migration
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
     * @class ESD_TPB_0104 : ESD_TPB_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0104() {
    	this.processButtonClick		= tprocessButtonClick;
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

	var final_retrieve_querystrings = ""; /// 최종 retrieve 조건 query string 저장 
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0]; 
	
		/* 조회방식에 따른 속성변경 이벤트처리 */
		if(window.event.srcElement.getAttribute("name") == "c_date_kind_flag"){
			if(window.event.srcElement.getAttribute("value") == "R"){
				document.getElementById("date_type").innerHTML = "Confirmed Date";
				document.all.s_date_kind_flag.value = "R";
				for(ir=1;ir<=sheetObjects[0].RowCount ;ir++ ){
					sheetObjects[0].CellEditable(ir, "wrtf_rsn_cd") = true;
				}
			}else if(window.event.srcElement.getAttribute("value") == "I"){
				document.getElementById("date_type").innerHTML = "W/O Request Date";
				document.all.s_date_kind_flag.value = "I";
				//w/o reason cell read only
			    for(ir=1;ir<=sheetObjects[0].RowCount ;ir++ ){
					sheetObjects[0].CellEditable(ir, "wrtf_rsn_cd") = false;
				}
			    
			}
		}	
	
		

		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObj,IBSAVE);
					doActionIBSheet(sheetObject,formObj,IBSEARCH); // Added By Sun, CHOI In 2009-11-23
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObject,formObj,REMOVELIST);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
					break;
				case "btng_detail":
					break;
				case "btn_3rdParty":
				    get3rdPartyToSearch( formObj.s_vndr_cust_div_cd.value ); 
					break;
//				case "btns_calendar1": 
//					var cal = new calendarPopup();
//					cal.select(formObj.s_calendar_date1, 's_calendar_date1', 'yyyy-MM-dd');
//					break;
//				case "btns_calendar2":
//					var cal = new calendarPopupFromTo();
//					cal.displayType = "date";
//					cal.select(formObj.s_calendar_date1, 's_calendar_date1',formObj.s_calendar_date2, 's_calendar_date2', 'yyyy-MM-dd');
//					break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.displayType = "date";
  					cal.select(formObj.s_calendar_date1, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendarFromTo();
  					cal.displayType = "date";
  					cal.select(formObj.s_calendar_date1, formObj.s_calendar_date2,'yyyy-MM-dd');
  					break;
				case "btn_rocto": // Added By Kim Jin-seung In 2007-08-31
				    openRocToOfficePopup(); 
					break;
				case "btn_close":
				     window.returnValue = "Y";
				     window.close();
			   break;	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				//ComShowMessage(getMsg('COM12111'));
				ComShowMessage(ComGetMsg("COM12111"));
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(n3pty_no_strs) {
		
		if( document.form.s_office_level.value == 'H' ||
			document.form.s_office_level.value == 'G' ){
			document.all.date_type.value = "W/O Request Date";
			document.all.s_date_kind_flag.value = "I";
		}
			
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
  		if ( document.form.pop_yn.value == 'Y' ){
    		  ComSetDisplay('btnCloseLayer', true);
  		}
  		
		// 검색일의 기준이 되는 select박스 2개를 선택변경할 경우 일어나는 이벤트  => 선택변경에 의한 결과값 착오를 방지.		
		document.form.s_date_flag_r.onchange = date_flag_OnChange
		document.form.s_date_flag_i.onchange = date_flag_OnChange
		document.form.s_calendar_date1.value = ComGetDateAdd(null, "D", -6, "-");
		document.form.s_calendar_date2.value = ComGetDateAdd(null, "D", 0, "-");
		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
		document.form.s_n3pty_no_strs.value = n3pty_no_strs;
		if ( n3pty_no_strs.length > 0 ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
		//document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
		document.form.s_vndr_cust_div_cd.onchange = s_trd_party_val_OnFocus;
		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
		//document.form.s_office_level.value = 'H';
		func_rhq_ctrl_ofc_list();

		if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
			case 1 :      //sheet1 init
				with (sheetObj) {

					/// 데이터 행의 페이지 링크 여부 확인/설정
					DataLinkMouse = true;

					// 높이 설정
					style.height = 350;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly; // msPrevColumnMerge; // msAll // msHeaderOnly

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(40, 7, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "Cancel|STS|approval|Request|Approve|Reject|Res.Office|TPB No.|Req.Date|Req.Office|Req.ID|App.Date|App.Office|App.ID|Rej.Date|Rej.Office|Rej.ID|Exp.Type|Invoice No.||W/O Status|W/O Reason|BKG No.|B/L No.|EQ No.|RHQ|Office|3rd Party|Currency|Confirmed Amount|Confirmed Date|Invoice|ERP I/F|Approval|Balance|Request|Activity|W/O Request Date|W/O Approved Date|Review Step";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성            [ROW ,COL   ,DATATYPE    ,WIDTH ,DATAALIGN   ,COLMERGE,SAVENAME                ,KEYFIELD,CALCULOGIC,DATAFORMAT  ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
					InitDataProperty(  0 ,cnt++ ,dtDelCheck  ,70    ,daCenter    ,true    ,""                      ,false   ,""        ,dfNone      ,0         ,false     ,false     );
//					InitDataProperty(  0 ,cnt++ ,dtHidden    ,50    ,daCenter    ,true    ,""                      );
					InitDataProperty(  0 ,cnt++ ,dtStatus    ,30    ,daCenter    ,true    ,"ibflag"                );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,50    ,daCenter    ,true    ,"approval"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					InitDataProperty(  0 ,cnt++ ,dtRadioCheck  ,53    ,daCenter    ,true    ,"chk_req"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtCheckBox  ,53    ,daCenter    ,true    ,"chk_app"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtCheckBox  ,53    ,daCenter    ,true    ,"chk_rej"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtPopupEdit ,80    ,daCenter    ,true    ,"stl_to_clt_cng_ofc_cd" ,false   ,""        ,dfNone      ,0         ,true      ,false     ,8);
					InitDataProperty(  0 ,cnt++ ,dtData      ,100   ,daCenter    ,true    ,"n3pty_no"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"req_date"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"req_ofc"               ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"req_id"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"app_date"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"app_ofc"               ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"app_id"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"rej_date"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"rej_ofc"               ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"rej_id"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					
					InitDataProperty(  0 ,cnt++ ,dtData      ,70    ,daCenter    ,true    ,"n3pty_src_sub_sys_cd"  ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					// go Hidden
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"n3pty_inv_no"          ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					InitDataProperty(  0 ,cnt++ ,dtData      ,30    ,daCenter    ,true    ,"ots_sts_cd"            ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daCenter    ,true    ,"ots_sts_cd_val"        ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtCombo      ,230  ,daLeft    ,true      ,"wrtf_rsn_cd"         ,false   ,""        ,dfNone      ,0         ,true     ,true     );
					//InitDataProperty(0, cnt++, dtCombo,      130,   daLeft,      true,    "wrtf_rsn_cd",            false,          "",       dfNone,       0,       true,         true,     3);
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"bkg_no"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"bl_no"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"eq_no"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,55    ,daCenter    ,true    ,"if_rhq_cd"             ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,55    ,daCenter    ,true    ,"if_ofc_cd"             ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,60    ,daCenter    ,true    ,"n3pty"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,60    ,daCenter    ,true    ,"curr_cd"               ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daRight     ,true    ,"ots_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,100   ,daCenter    ,true    ,"cfm_dt"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					// go Hidden
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"inv_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"clt_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"stl_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"bal_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"stl_clt_ofc_cng_amt"   ,false   ,""        ,dfNullFloat ,2         ,false     ,false     );

					InitDataProperty(  0 ,cnt++ ,dtImage     ,130   ,daCenter    ,true    ,"clt_act_yn"            ,false   ,""        ,dfNone      ,0         ,false     ,false     );

//					InitDataProperty(  0 ,cnt++ ,dtData      ,100   ,daCenter    ,true    ,"svr_id_valid_yn"       ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daCenter    ,true    ,"stl_rqst_dt"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daCenter    ,true    ,"stl_apro_dt"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,70    ,daCenter    ,true    ,"review_step"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					ColHidden(0) = true;
					ColHidden("ots_sts_cd") = true;
					ColHidden("chk_req") = true;
					ColHidden("chk_app") = true;
					ColHidden("chk_rej") = true;
					ColHidden("ibflag") = true;
					ColHidden("stl_to_clt_cng_ofc_cd") = true;					
					ColHidden("review_step") = true;
					
					ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
					ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";

					InitDataCombo (0, "wrtf_rsn_cd", combo01Text, combo01Code);
					DataLinkMouse("clt_act_yn") = true;
					//InitDataProperty2(0, 11, dtData, "update-edit=true");
					
				}
				break;
		}
	}



	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		//sheetObj.ShowDebugMsg = true;

		switch(sAction) {

		
				
			case IBSEARCH:      //조회
				/// 검색처리 
				if(document.form.s_date_kind_flag.value=="R"){
					formObj.f_cmd.value = SEARCH;
				}else if(document.form.s_date_kind_flag.value=="I"){
					formObj.f_cmd.value = SEARCHLIST;
				}			
				final_retrieve_querystrings = tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0114GS.do", final_retrieve_querystrings );
				break;
			
			case REMOVELIST:
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESD_TPB_0114GS.do", tpbFrmQryStr(formObj));
				formObj.f_cmd.value = SEARCHLIST;
				final_retrieve_querystrings = tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0114GS.do", final_retrieve_querystrings );
				break;
					
			case IBSAVE:        //저장
				// 체크된 대상이 없으면 저장불가.
				if( sheetObj.CheckedRows('chk_req') < 1 && sheetObj.CheckedRows('chk_app') < 1 && sheetObj.CheckedRows('chk_rej') < 1){
					ComShowCodeMessage("TPB90080");
					break;					
				}

				// 승인할 값이 체크되지 않았거나, Res.Office 값이 없을 때.wonjoo- 20120511 하나만 체크해서 request 할 수 있도록 수정
//				if( curr_action == "REQUEST" ){
//					var bugs = "";
//					for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
//						//alert(sheetObj.RowStatus(i));
//						if(sheetObj.RowStatus(i) != 'R'){
//							if(sheetObj.CellValue(i,"chk_req")==0){
//								if(bugs!=""){bugs += ",";}
//								bugs += i;
//							}
//						}
//					}
//					if( bugs != "" ){
//						ComShowCodeMessage("TPB90096",bugs);
//						return;
//					}
//				}
        		document.form.s_file_no.value = "";
        		document.form.s_ra_rmk1.value = "";
        		document.form.s_ra_rmk2.value = "";
        		//alert(curr_action);			
//				if(validateForm(sheetObj,formObj,sAction)) {	        
					if( curr_action == "REQUEST" ){
    					formObj.f_cmd.value = MULTI01;	// ROC Request -> Create ROC
						var reasonCheckResult = openReasonToSavePopup();
    				}else if( curr_action == "APPROVAL" ){
    					formObj.f_cmd.value = MULTI02;	// ROC Approve-Reject -> Modify ROC
						var reasonCheckResult = openReviewResultPopup();
    				}
					//alert("reasonCheckResult==>"+reasonCheckResult)
					// CALL POPUP ... 
					if ( reasonCheckResult ) {
						if( curr_action == "REQUEST" ){
						sheetObj.DoSave("ESD_TPB_0114GS.do", tpbFrmQryStr(formObj),"chk_req"); //check 된 한개의 request 만 저장
						}else if( curr_action == "APPROVAL" ){
							sheetObj.DoSave("ESD_TPB_0114GS.do", tpbFrmQryStr(formObj));
						}
						}
//				}

				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){

		/// Checking Adjustment Type 
		if ( formObj.n3pty_stl_tp_cd.value.length == 0 ){
			//ComShowMessage( getMsg('COM12113', 'Adjustment Type') ); 
			ComShowMessage(ComGetMsg("COM12113", 'Adjustment Type'));
			formObj.n3pty_stl_tp_cd.focus();
			return false;
		}

		/// Checking R.O.C To. 
		formObj.stl_to_clt_cng_ofc_cd.value = ComTrim(formObj.stl_to_clt_cng_ofc_cd.value); 
		if ( formObj.n3pty_stl_tp_cd.value == "O" && formObj.stl_to_clt_cng_ofc_cd.value.length < 5 ){ /// R.O.C To 
			//ComShowMessage( getMsg('COM12114', 'R.O.C To') ); 
			ComShowMessage(ComGetMsg("COM12114", 'R.O.C To'));
			formObj.btn_rocto.style.display = ""; // Added By Kim Jin-seung In 2007-08-31
			formObj.stl_to_clt_cng_ofc_cd.select();
			return false;
		}

		/// Remarks 
		//formObj.stl_rqst_rmk.value = trim(formObj.stl_rqst_rmk.value); 
		//if ( formObj.stl_rqst_rmk.value.length == 0 ){ ///
		//	ComShowMessage( getMsg('COM12114', 'Remarks') ); 
		//	formObj.stl_rqst_rmk.focus();
		//	return false;
		//} 
		
		/// Sheets R.O.C Amounts, MNR estm_svr_id Validation Check
		var chk_req = 0; 
		var roc_amt = 0;
		var ots_amt = 0;
		var svr_id_valid_yn = "";  // For MNR svr_id must be valid
		if ( formObj.n3pty_stl_tp_cd.value == "O" ){
			for(i=1;i<=sheetObjects[0].RowCount; i++) {
				chk_req = sheetObjects[0].CellValue(i, "chk_req");
				roc_amt = sheetObjects[0].CellValue(i, "stl_clt_ofc_cng_amt");
				ots_amt = sheetObjects[0].CellValue(i, "ots_amt");
				svr_id_valid_yn = sheetObjects[0].CellValue(i, "svr_id_valid_yn");
				if ( chk_req==1 && (roc_amt <= 0.0 || roc_amt - ots_amt > 0) ) {
					//ComShowMessage( getMsg('COM12114', 'R.O.C AMT') ); 
					ComShowMessage(ComGetMsg("COM12114", 'R.O.C AMT'));
					sheetObjects[0].SelectCell(i, "stl_clt_ofc_cng_amt");
					return false; 
				}
				// 2007-04-26 필요없다는 요구사항에 의해 주석처리 By Kim Jin-seung
				// if ( chk_req==1 && svr_id_valid_yn != "Y" ) {
				// 	ComShowMessage( getMsg('TPB90019', sheetObjects[0].CellValue(i, "n3pty_no")) ); 
				// 	sheetObjects[0].SelectCell(i, "chk_req");
				// 	/// sheetObjects[0].CellValue2(i, "chk_req") = 0;
				// 	return false; 
				// }				
			}
		}

		return true;
	}

	/**
	 * sheet1 on click 이벤트 
	 */
	function sheet1_OnClick(sheetObj, Row,Col){ 
	
		var colNm = sheetObj.ColSaveName(Col);
		
		/// Collection Activity 버튼 클릭시 팝업
		if ( colNm == "clt_act_yn" ) { 
  			var r_n3pty_no = sheetObj.CellValue(Row, "n3pty_no");
  			var r_n3pty_inv_no = sheetObj.CellValue(Row, "n3pty_inv_no");
  			
			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
		}
		
		if( colNm == "chk_app" || colNm == "chk_rej" ){
			sheetObj.CheckAll2("chk_app")=false;
			sheetObj.CheckAll2("chk_rej")=false;
			sheetObj.CheckAll2("chk_req")=false;
		}
	}

	/**
	 * sheet1 cell의 값에 변경이 있을 경우 이벤트 
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value){

		_sheet_onchange( sheetObj,Row,Col,Value );
		
		var colNm = sheetObj.ColSaveName(Col);
		
		// Approve - Reject 동작. -- 요청에 의한 주석처리 : 2008-11-03
//		if( colNm=="chk_app"==1){
//			sheetObj.CellValue2(Row,"chk_rej") = 0;
//		}
//		if( colNm=="chk_rej"==1){
//			sheetObj.CellValue2(Row,"chk_app") = 0;
//		}

		// on checkBox change : 체크하면 ROC대상 입력가능.
//		if( colNm == 'chk_req' ){
//			if(sheetObj.CellValue(Row, 'chk_req') == '0'){
//				sheetObj.CellEditable(Row,'trd_party_val') = false;
//			}else if(sheetObj.CellValue(Row, 'chk_req') == '1'){
//				sheetObj.CellEditable(Row,'trd_party_val') = true;			
//			}
//		}
		
		//stl_to_clt_cng_ofc_cd과  check 입력값이 존재시에만 UDP
		if( colNm=='chk_req' ){
			if( sheetObj.CellValue( Row, 'stl_to_clt_cng_ofc_cd')=='' ){
				sheetObj.RowStatus( Row ) = 'R';
			}
		}

		// 3rd Party Input directly ...
		if(colNm == 'stl_to_clt_cng_ofc_cd'){
			var stl_to_clt_cng_ofc_cd = sheetObj.CellValue(Row, "stl_to_clt_cng_ofc_cd");
			stl_to_clt_cng_ofc_cd = ComTrim(stl_to_clt_cng_ofc_cd).toUpperCase(); // TRIM & UPPER CASE 
			sheetObj.CellValue2(Row, "stl_to_clt_cng_ofc_cd") = stl_to_clt_cng_ofc_cd;
			
            if ( stl_to_clt_cng_ofc_cd.length == 0 ){ // 3rd party value가 없으면 
            
//				sheetObj.CellValue2(Row, "trd_party_val") = "";
//				sheetObj.CellValue2(Row, "vndr_cnt_cd") = "";
//				sheetObj.CellValue2(Row, "vndr_seq") = "";
//				sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
//				sheetObj.CellValue2(Row, "cust_seq") = "";
//				sheetObj.CellValue2(Row, "n3pty_ofc_cd") = "";
				
            } else { // 있을 경우 유효성 체크 
				/* search option과의 중복현상에 의한 주석처리.
				// server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
				document.all.s_vndr_cust_div_cd.value = "S"; // input type hidden 이용 
				document.all.s_trd_party_val.value = stl_to_clt_cng_ofc_cd; // input type hidden 이용 
				// ComShowMessage(" .. " +Row);
				getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); 
				*/
            }
		}
		

		var val = document.form.n3pty_stl_tp_cd.value; // C / D / O / W  // O, L, J, K, M 
		// ComShowMessage(val);
		var ots_sts_cd = "";

		if ( sheetObj.ColSaveName(Col) == "chk_req" ) {  // chk_req on checking or unchecking
			if ( Value == 0 ) { // on unckecking 
				sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = "";
			} else { // on checking
				ots_sts_cd = sheetObj.CellValue(Row, "ots_sts_cd");  
				// ComShowMessage(ots_sts_cd);
				if ( val == "C" || val == "D" ) { //  L, K 
					if ( ots_sts_cd == "L" || ots_sts_cd == "K" ) {
						sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = sheetObj.CellValue(Row, "bal_amt"); 
					} else {
						ComShowMessage(ComGetMsg("TPB90022", sheetObj.CellValue(Row, "n3pty_no")));
						sheetObj.CellValue2(Row, "chk_req") = 0;
					} 
				} else if ( val == "O" || val == "W" ) { // O, J, M 
					if ( ots_sts_cd == "O" || ots_sts_cd == "J" || ots_sts_cd == "M" ) {
						sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = sheetObj.CellValue(Row, "bal_amt"); 
					} else {
						ComShowMessage(ComGetMsg("TPB90022", sheetObj.CellValue(Row, "n3pty_no")));
						sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = "";
						sheetObj.CellValue2(Row, "chk_req") = 0;
					} 
				} else { // none selected
					sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = sheetObj.CellValue(Row, "bal_amt"); 
				}
				chk_req = sheetObj.CellValue(Row, "chk_req"); //wonjoo
				if(chk_req == 1){	
					sheetObj.SelectCell(Row, "wrtf_rsn_cd");
					
				}
				
			}
		} else if ( sheetObj.ColSaveName(Col) == "stl_clt_ofc_cng_amt" ) { // request amount on changing
			if ( Value != "" ) {
				sheetObj.CellValue2(Row, "chk_req") = 1;
			} else {
				sheetObj.CellValue2(Row, "chk_req") = 0;
			}
		} 

//		if ( document.form.n3pty_stl_tp_cd.value != "O" ) { /// R.O.C가 아닌 경우 
//			return;
//		}
//		if ( sheetObj.ColSaveName(Col) == "chk_req" ) { 
//			if ( Value == 0 ) { // on unckecking 
//				sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = "";
//			} else { // on checking
//				//ComShowMessage( sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") );
//				if ( sheetObj.CellValue(Row, "stl_clt_ofc_cng_amt") == "" ){
//					// sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = 0; // comment marked in 2007-03-22 by Kim Jin-seung
//					sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = sheetObj.CellValue(Row, "bal_amt"); // change original outstanding amount in 2007-03-22 by Kim Jin-seung
//				}
//			}
//		} else if ( sheetObj.ColSaveName(Col) == "stl_clt_ofc_cng_amt" ) { 
//			if ( Value != "" ) {
//				sheetObj.CellValue2(Row, "chk_req") = 1;
//			} else {
//				sheetObj.CellValue2(Row, "chk_req") = 0;
//			}
//		} 
				
	}//OnChange

	/**
	 * 조회 후 작동하는 이벤트 핸들러 : OnSearchEnd
	 */
	var curr_action = "";
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	
		//조건초기화
//		document.form.stl_to_clt_cng_ofc_cd.value = '';
		document.form.s_ra_rmk1.value = '';
		document.form.s_ra_rmk2.value = '';
//		document.form.stl_rqst_rmk.value = '';
		
		var s_date_kind_flag = document.form.s_date_kind_flag.value;
		var s_date_flag_r = document.form.s_date_flag_r.value;
		var s_date_flag_i = document.form.s_date_flag_i.value;
		
		if( s_date_kind_flag == "R" ){
			
			for(ir=1;ir<=sheetObjects[0].RowCount ;ir++ ){
				sheetObjects[0].CellEditable(ir, "wrtf_rsn_cd") = true;
			}
			
			// 현 조회 결과값에서 선택할 수 있는 액션에 대한 정보를 curr_action 에저장.
			if(s_date_flag_r == "IN"){
				curr_action = "APPROVAL";
			}else if(s_date_flag_r == "OT"){
				curr_action = "REQUEST";
			}
			
			for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){

				// s_date_kind_flag에 따른 IBSheet컬럼변경.
				if( s_date_flag_r == "AL" ){
	 				sheetObj.ColHidden("chk_req") = true;
					sheetObj.ColHidden("chk_app") = true;
					sheetObj.ColHidden("chk_rej") = true;
					sheetObj.ColHidden("ibflag") = true;
					sheetObj.ColHidden(0) = true;
				}else if( s_date_flag_r == "IN" ){
					if( sheetObj.CellValue(i,"approval") == 'Y' ){
						sheetObj.CellEditable(i,"chk_app") = true;
						sheetObj.CellEditable(i,"chk_rej") = true;
						sheetObj.ColHidden("chk_rej") = false;
						sheetObj.ColHidden("chk_app") = false;
						sheetObj.ColHidden("chk_req") = true;
						sheetObj.ColHidden("ibflag") = false;
						sheetObj.ColHidden(0) = true;
						sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
					}
				}else if( s_date_flag_r == "OT" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = true;
					sheetObj.CellEditable(i,"chk_req") = true;
					sheetObj.ColHidden("chk_req") = false;
					sheetObj.ColHidden("chk_rej") = true;
					sheetObj.ColHidden("chk_app") = true;
					sheetObj.ColHidden("ibflag") = false;
					sheetObj.ColHidden(0) = true;
					sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
				}
				
				// s_date_flag_kind 가 R 일때는 자신의 점소의 것만이 조작가능 ==> 위의 조작과의 순서 주의.
				if( document.form.s_office_level.value == "T" || document.form.priv_cd.value == "T"){
					if( curr_action == "APPROVAL" ){
						if( document.form.s_user_ofc_cd.value != sheetObj.CellValue(i,"review_step") 
							|| sheetObj.CellValue(i,"review_step") == "" ){
							sheetObj.CellEditable(i,"chk_req") = false;
							sheetObj.CellEditable(i,"chk_rej") = false;
							sheetObj.CellEditable(i,"chk_app") = false;
							sheetObj.CellBackColor(i,"chk_rej") = sheetObj.CellBackColor(i,"n3pty_no");
							sheetObj.CellBackColor(i,"chk_app") = sheetObj.CellBackColor(i,"n3pty_no");
						}
					}else if( curr_action == "REQUEST" ){
						if( document.form.s_user_ofc_cd.value != sheetObj.CellValue(i,"if_ofc_cd") ){
							sheetObj.CellEditable(i,"chk_req") = false;
						}
					}
				}
				/*if( document.form.s_user_ofc_cd.value != sheetObj.CellValue(i,"review_step") 
					|| sheetObj.CellValue(i,"review_step") == "" ){
					if(curr_action == "REQUEST"){
						sheetObj.CellEditable(i,"chk_req") = true;
					}else{
						sheetObj.CellEditable(i,"chk_req") = false;
						sheetObj.CellBackColor(i,"chk_req") = sheetObj.CellBackColor(i,"n3pty_no");
					}
					if( document.form.s_office_level.value != "R" ){
						sheetObj.CellEditable(i,"chk_rej") = false;
						sheetObj.CellEditable(i,"chk_app") = false;
						sheetObj.CellBackColor(i,"chk_rej") = sheetObj.CellBackColor(i,"n3pty_no");
						sheetObj.CellBackColor(i,"chk_app") = sheetObj.CellBackColor(i,"n3pty_no");
					}
						
				}*/
				
			}//for
			
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
				
		}else if( s_date_kind_flag == "I" ){
			
			   for(ir=1;ir<=sheetObjects[0].RowCount ;ir++ ){
					sheetObjects[0].CellEditable(ir, "wrtf_rsn_cd") = false;
				}
			
			sheetObj.ColHidden("chk_req") = true;
			sheetObj.ColHidden("chk_rej") = true;
			sheetObj.ColHidden("chk_app") = true;
			sheetObj.ColHidden("ibflag")  = true;
			
			if(s_date_flag_i=="OL"){
				
				//* 2008-12-18 O Wan-Ki 1.1 Cancel, Approval 권한제한에 의한 보완 - TPB Office 만 Cancel 가능
				if( document.form.s_office_level.value == 'T' ){
					document.all.btn_cancel_left.style.display="";
					document.all.btn_cancel.style.display="";
					document.all.btn_cancel_right.style.display="";
					sheetObj.ColHidden(0)  = false;
				}else{
					document.all.btn_cancel_left.style.display="none";
					document.all.btn_cancel.style.display="none";
					document.all.btn_cancel_right.style.display="none";
					sheetObj.ColHidden(0)  = true;
				}

				for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){			

					//* 2008-12-18 O Wan-Ki 1.1 Cancel, Approval 권한제한에 의한 보완
					if( sheetObj.CellValue(i,"ots_sts_cd_val") == "Requested" &&
						sheetObj.CellValue(i,"if_ofc_cd") == document.form.s_user_ofc_cd.value ){
						sheetObj.CellEditable(i,0) = true;
						sheetObj.CellBackColor(i,0) = sheetObj.RgbColor(0, 0, 0);
					}else{
						sheetObj.CellBackColor(i,0) = sheetObj.CellBackColor(i,"n3pty_no");
					}
				}//for
			}else{
				document.all.btn_cancel_left.style.display="none";
				document.all.btn_cancel.style.display="none";
				document.all.btn_cancel_right.style.display="none";
				sheetObj.ColHidden(0) = true;
			}
			

			/*// Inquiry of ROC Request 의 ROC-out All인 상태에서, Requested된 항목을 선택할 경우.	
			// 칼럼 선택시 작동.				
			if( colNm=="ots_sts_cd_val" 
				&& sheetObj.CellValue(NewRow,"ots_sts_cd_val") == "Requested" ){
				document.all.btn_cancel_left.style.display="";
				document.all.btn_cancel.style.display="";
				document.all.btn_cancel_right.style.display="";
			} 
			// ROW 선택시 작동.
			if( sheetObj.CellValue(NewRow,"ots_sts_cd_val") == "Requested" 
				&& document.form.s_date_kind_flag.value=="I"
				&& document.form.s_date_flag_i.value=="OL"){
				document.all.btn_cancel_left.style.display="";
				document.all.btn_cancel.style.display="";
				document.all.btn_cancel_right.style.display="";
			}else{
				document.all.btn_cancel_left.style.display="";
				document.all.btn_cancel.style.display="";
				document.all.btn_cancel_right.style.display="";
			}*/
		}

		//bug성 checkBox align=center 로 수정.
		for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
			sheetObj.CellAlign(i,"chk_app") = daCenter;
			sheetObj.CellAlign(i,"chk_rej") = daCenter;
			sheetObj.CellAlign(i,"chk_req") = daCenter;
			sheetObj.CellAlign(i,0) = daCenter;
		}
	}//OnSearchEnd
	
	/**
	 * 조회결과에 오류가 발생하지 않았을 경우 정상메세지 함수
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
	
		// SAVE후 Request기능 활성화.
		if( curr_action == "REQUEST" &&
			document.form.s_date_kind_flag.value == "R" &&
			document.form.s_date_flag_r.value == "OT" &&
			document.form.s_office_level.value == "T" ||
			document.form.s_office_level.value == "C"){
			for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
				sheetObj.CellEditable(i,"chk_req") = true;
				sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = true;
			}
		}
	
		//조건초기화
		document.form.stl_to_clt_cng_ofc_cd.value = '';
		document.form.s_ra_rmk1.value = '';
		document.form.s_ra_rmk2.value = '';
//		document.form.stl_rqst_rmk.value = '';
	
		if(errMsg==null || errMsg == ''){
			//ComShowMessage(getMsg('COM12149','Data'));
			ComShowMessage(ComGetMsg("COM12149",'Data'));
			sheetObj.DoSearch("ESD_TPB_0114GS.do", final_retrieve_querystrings ); /// sheet data reload
		}
	}
	
	// 검색일의 기준이 되는 select박스 2개를 선택변경할 경우 일어나는 이벤트  => 선택변경에 의한 결과값 착오를 방지.
	function date_flag_OnChange(){
		var sheetObj = sheetObjects[0];
		if( window.event.srcElement.getAttribute("name")=="s_date_flag_r" &&
			document.form.s_date_kind_flag.value=="R"){
			document.all.btn_cancel_left.style.display="";
			document.all.btn_cancel.style.display="";
			document.all.btn_cancel_right.style.display="";
			sheetObj.RemoveAll();
		}else if( window.event.srcElement.getAttribute("name")=="s_date_flag_i" &&
			document.form.s_date_kind_flag.value=="I"){
			//document.form.btn_cancel.style.display="none";
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
			sheetObj.RemoveAll();
		}
	}

	function stl_to_clt_cng_ofc_cd_OnBlur(){
	    var user_ofc_cd = document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd = document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value = "";
		    //ComShowMessage(getMsg("TPB90051"));
		    ComShowMessage(ComGetMsg("TPB90051"));
		    return ; 
		}
		checkROCToOffice(document.form, document.form.stl_to_clt_cng_ofc_cd);
	}

    function openRocToOfficePopup(){
    	var theURL = "ESD_TPB_0804.do";
    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:450px";
    	var rtnValue = window.showModalDialog(theURL, window, features);
    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
    	}
	    var user_ofc_cd = document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd = document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value = "";
		    //ComShowMessage(getMsg("TPB90051"));
		    ComShowMessage(ComGetMsg("TPB90051"));
		    document.form.stl_to_clt_cng_ofc_cd.focus();
		    return ; 
		}
    }	

    function openReasonToSavePopup(){

    	
	    var iCheckRow = sheetObjects[0].FindCheckedRow("chk_req").split("|");
		
	    var sText = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "Text");
  	    var sCode = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "Code");
  	  var arrText = sText.split("|");
  	  var arrCode = sCode.split("|");
  	var idx   = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "SelectedIndex");
  	
  	var wrtfRsnCd = arrCode[idx];
  	var wrtfRsnText = arrText [idx];
  	
    	var theURL = "ESD_TPB_0805.do?wrtf_rsn_cd=" + wrtfRsnCd + "&wrtf_rsn_text=" + wrtfRsnText;

    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:430px";
    	var rtnValue = window.showModalDialog(theURL, window, features);

    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value = rtnValue[0];
    		document.form.s_ra_rmk1.value = rtnValue[1];
    		document.form.s_ra_rmk2.value = rtnValue[2];
    		document.form.s_wrtf_rsn_cd.value = rtnValue[3];
    		//2012.05.17  WO 화면이니까 두번째만 입력해도 저장 - 장병용 부장님
//    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
//    		    //ComShowMessage(getMsg("TPB90060"));
//    		    ComShowMessage(ComGetMsg("TPB90060"));//Reason must be input.
//                return false;
//    		}
            if ( document.form.n3pty_stl_tp_cd.value=="W" && ComTrim(rtnValue[2]).length == 0 ){ 
    		    //ComShowMessage(getMsg("TPB90060"));
    		    ComShowMessage(ComGetMsg("TPB90106"));//Preventive measure is not inputted
                return false;
            }
            
            //2012.09.24 [CHM-201220286-01] [TPB-W/O] Reason
//            if ( ComTrim(rtnValue[3]).length == 0 ){ 
//    		    //ComShowMessage(getMsg("TPB90105"));
//    		    ComShowMessage(ComGetMsg("TPB90105"));//Write-off Reason is not inputted
//                return false;
//            }
            
    		return true;
    	} else {
    	    return false;
    	}
	}
	
    function openReviewResultPopup(){
    	//approval check 된 경우
    	if(sheetObjects[0].CheckedRows('chk_rej') < 1 && sheetObjects[0].CheckedRows('chk_req') < 1){
    	   var iCheckRow = sheetObjects[0].FindCheckedRow("chk_app").split("|");
    	   var sText = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "Text");
    	   var sCode = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "Code");
    	   var arrText = sText.split("|");
      	   var arrCode = sCode.split("|");
      	   var idx   = sheetObjects[0].GetComboInfo(iCheckRow,"wrtf_rsn_cd", "SelectedIndex");
      	 
    	 //reject check 된 경우
    	}else if (sheetObjects[0].CheckedRows('chk_app') < 1 && sheetObjects[0].CheckedRows('chk_req') < 1){
    		 var iCheckRow1 = sheetObjects[0].FindCheckedRow("chk_rej").split("|");
    		 var sText = sheetObjects[0].GetComboInfo(iCheckRow1,"wrtf_rsn_cd", "Text");
       	     var sCode = sheetObjects[0].GetComboInfo(iCheckRow1,"wrtf_rsn_cd", "Code");
	      	 var arrText = sText.split("|");
	      	 var arrCode = sCode.split("|");
	      	 var idx   = sheetObjects[0].GetComboInfo(iCheckRow1,"wrtf_rsn_cd", "SelectedIndex");
	      	
       	    
    	}
   	  
     	  
    	   var wrtfRsnCd = arrCode[idx];
     	   var wrtfRsnText = arrText [idx];
     	   
    	
    	
    	var theURL = "ESD_TPB_0806.do?wrtf_rsn_cd=" + wrtfRsnCd + "&wrtf_rsn_text=" + wrtfRsnText;
    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:340px";
    	var rtnValue = window.showModalDialog(theURL, window, features);

    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value = rtnValue[0];
    		document.form.s_ra_rmk1.value = rtnValue[1];
    		document.form.s_wrtf_rsn_cd.value = rtnValue[2];
    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
                // ComShowMessage("Review Result must be input.");
    		    //ComShowMessage(getMsg("TPB90062"));
    		    ComShowMessage(ComGetMsg("TPB90062"));
                return false;
    		}
    		return true;
    		
    	} else {
    	    return false;
    	}
    }	
	
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		get3rdPartyTarget_sheet( "S", Row,Col,sheetObj, "s_s_vndr_cust_div_cd", "s_s_trd_party_val" );
	}
	/* 개발자 작업  끝 */