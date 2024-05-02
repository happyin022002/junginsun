/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0113.js
*@FileTitle : Response Office Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-27
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-27 Sun, Choi 1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.10.01 변종건 [CHM-201005566-01] [TPB] 지역본부/본사의 ROC 결정 후 2ND REVIEW를 위한 보완
* 2010.10.29 변종건 [CHM-201006738-01] [TPB] ROC 조회 결과의 Row count 오류
* 2011.05.09 변종건 [CHM-201110539-01] [TPB] ROC Inquiry Screen 변경
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
     * @class ESD_TPB_0113 : ESD_TPB_0113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0113() {
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
	
		/* 조회방식에 따른 속성변경 이벤트처리 */
		if(window.event.srcElement.getAttribute("name") == "c_date_kind_flag"){
			if(window.event.srcElement.getAttribute("value") == "R"){
				document.getElementById("date_type").innerHTML = "Confirmed Date";
				document.all.s_date_kind_flag.value = "R";
			}else if(window.event.srcElement.getAttribute("value") == "I"){
				document.getElementById("date_type").innerHTML = "ROC Request Date";
				document.all.s_date_kind_flag.value = "I";
			}
			obj_change();
		}	
	
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];

		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					document.form.n2nd_rvw_chk.value = "N";
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
					break;
				case "btn_new":
					formObj.reset();
					sheetObject.RemoveAll();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObj,IBSAVE);
					formObj.n2nd_rvw_chk.value = "N";
					doActionIBSheet(sheetObject,formObj,IBSEARCH);
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
				case "btn_review":
					if(document.form.s_n3pty_no.value.length == 14)
					{
						var tmp_n3pty_no = document.form.s_n3pty_no.value;
						formObj.reset();
						document.form.s_n3pty_no.value = tmp_n3pty_no;
						document.form.n2nd_rvw_chk.value = "Y";
						doActionIBSheet(sheetObject,formObj,IBSEARCH);
					}
					else
					{
						ComShowCodeMessage('TPB90102');
						document.form.s_n3pty_no.focus();
					}
					break;
				case "btn_close":
					     window.returnValue = "Y";
					     window.close();
				   break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("TPB90014"));
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
		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
		document.form.s_n3pty_no_strs.value = n3pty_no_strs;
		if ( n3pty_no_strs.length > 0 ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
		//document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
		document.form.s_vndr_cust_div_cd.onchange = s_trd_party_val_OnFocus;
		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;		
		//document.form.s_office_level.value = 'H';
		func_rhq_ctrl_ofc_list();
		
		if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
		axon_event.addListenerForm('change', 'obj_change', document.form); // change

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
					InitColumnInfo(41, 7, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "Cancel|STS|approval|Request|Accept|Reject|Res.Office|TPB No.|Req.Date|Req.Office|Req.ID|App.Date|App.Office|App.ID|Rej.Date|Rej.Office|Rej.ID|Exp.Type|Billing Case|Invoice No.||ROC Status|BKG No.|B/L No.|EQ No.|RHQ|Office|3rd Party|Currency|Confirmed Amount|Confirmed Date|Invoice|ERP I/F|Approval|Balance|Activity|ROC Date|Review Step|Sts Seq|N2nd Seq|N2nd Sts";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성            [ROW ,COL   ,DATATYPE    ,WIDTH ,DATAALIGN   ,COLMERGE,SAVENAME                ,KEYFIELD,CALCULOGIC,DATAFORMAT  ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
					InitDataProperty(  0 ,cnt++ ,dtDelCheck  ,70    ,daCenter    ,true    ,""                      ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtStatus    ,30    ,daCenter    ,true    ,"ibflag"                );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,50    ,daCenter    ,true    ,"approval"              ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtCheckBox  ,53    ,daCenter    ,true    ,"chk_req"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtCheckBox  ,53    ,daCenter    ,true    ,"chk_app"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtCheckBox  ,53    ,daCenter    ,true    ,"chk_rej"               ,false   ,""        ,dfNone      ,0         ,false     ,false     ,false  ,false    ,false     ,false  ,false   );
					InitDataProperty(  0 ,cnt++ ,dtPopupEdit ,80    ,daCenter    ,true    ,"stl_to_clt_cng_ofc_cd" ,false   ,""        ,dfNone      ,0         ,false      ,false     ,8);
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
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daCenter    ,true    ,"n3pty_bil_tp_nm"  	   ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daCenter    ,true    ,"n3pty_inv_no"          ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,30    ,daCenter    ,true    ,"ots_sts_cd"            ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daCenter    ,true    ,"ots_sts_cd_val"        ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"bkg_no"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"bl_no"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"eq_no"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"if_rhq_cd"             ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,90    ,daCenter    ,true    ,"if_ofc_cd"             ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,60    ,daCenter    ,true    ,"n3pty"                 ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,60    ,daCenter    ,true    ,"curr_cd"               ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,120   ,daRight     ,true    ,"ots_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,100   ,daCenter    ,true    ,"cfm_dt"                ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"inv_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"clt_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"stl_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,100   ,daRight     ,true    ,"bal_amt"               ,false   ,""        ,dfFloat     ,2         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtImage     ,130   ,daCenter    ,true    ,"clt_act_yn"            ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,100   ,daCenter    ,true    ,"stl_rqst_dt"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtData      ,70    ,daCenter    ,true    ,"review_step"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,70    ,daCenter    ,true    ,"adj_sts_seq"           ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,70    ,daCenter    ,true    ,"adj_n2nd_rvw_seq"      ,false   ,""        ,dfNone      ,0         ,false     ,false     );
					InitDataProperty(  0 ,cnt++ ,dtHidden    ,70    ,daCenter    ,true    ,"adj_n2nd_rvw_sts_cd"   ,false   ,""        ,dfNone      ,0         ,false     ,false     );

					ColHidden(0) = true;
					ColHidden("ots_sts_cd") = true;
					ColHidden("chk_req") = true;
					ColHidden("chk_app") = true;
					ColHidden("chk_rej") = true;
					ColHidden("ibflag") = true;
					
					ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
					ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";
					DataLinkMouse("clt_act_yn") = true;
				}
				break;
		}
	}



	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
//				alert(document.form.s_date_kind_flag[0].value);
//				alert(document.form.s_date_kind_flag[1].value);
//				if(document.form.s_date_kind_flag[0].value=="R"){
//					formObj.f_cmd.value = SEARCHLIST;
//				}else if(document.form.s_date_kind_flag[1].value=="I"){
//					formObj.f_cmd.value = SEARCH;
//				}
//				formObj.f_cmd.value = SEARCH;
//				alert(document.form.s_date_kind_flag.value);
				var s_date_flag_r = document.form.s_date_flag_r.value;	
//				alert(document.form.s_date_flag_r.value);
//				alert(document.form.s_date_kind_flag[0].value);
//				if(document.form.s_date_kind_flag.value=="R" && s_date_flag_r == "IN"){
//					formObj.f_cmd.value = SEARCH;
//				}else if(document.form.s_date_kind_flag.value=="R" && s_date_flag_r == "OT"){
//					formObj.f_cmd.value = SEARCHLIST;
//				}
				if(document.form.n2nd_rvw_chk.value=="Y"){
					formObj.f_cmd.value = SEARCH01;
				}else if(document.form.s_date_kind_flag.value=="R"){
					formObj.f_cmd.value = SEARCH;
				}else if(document.form.s_date_kind_flag.value=="I"){
					formObj.f_cmd.value = SEARCHLIST;
				}
				final_retrieve_querystrings = tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings );
				break;
			case REMOVELIST:
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESD_TPB_0113GS.do", tpbFrmQryStr(formObj));
				formObj.f_cmd.value = SEARCHLIST;
				final_retrieve_querystrings = tpbFrmQryStr(formObj); 
				sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings );
				break;
			case IBSAVE:        //저장
				if( sheetObj.CheckedRows('chk_req') < 1 && sheetObj.CheckedRows('chk_app') < 1 && sheetObj.CheckedRows('chk_rej') < 1){
					ComShowCodeMessage("TPB90080");
					break;					
				}

				if( curr_action == "REQUEST" ){
					var bugs = "";
					for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
						if(sheetObj.RowStatus(i) != 'R'){
//							alert("chk_req==>"+sheetObj.CellValue(i,"chk_req"));
//							alert("stl_to_clt_cng_ofc_cd==>"+sheetObj.CellValue(i,"stl_to_clt_cng_ofc_cd"));
							if(sheetObj.CellValue(i,"chk_req")==0||sheetObj.CellValue(i,"stl_to_clt_cng_ofc_cd")==""){
								if(bugs!=""){bugs += ",";}
								bugs += i;
							}
						}
					}
					if( bugs != "" ){
						ComShowCodeMessage("TPB90096", bugs);
						return;
					}
				}
        		document.form.s_file_no.value = "";
        		document.form.s_ra_rmk1.value = "";
        		document.form.s_ra_rmk2.value = "";
//        		alert("curr_action==>"+curr_action);
				if( curr_action == "REQUEST" ){
					formObj.f_cmd.value = MULTI01;	// ROC Request -> Create ROC
					var reasonCheckResult = openReasonToSavePopup();
				}else if( curr_action == "APPROVAL" ){
					formObj.f_cmd.value = MULTI02;	// ROC Approve-Reject -> Modify ROC
					var reasonCheckResult = openReviewResultPopup();
				}
//				alert("reasonCheckResult==>"+reasonCheckResult)
				if ( reasonCheckResult ) {
					sheetObj.DoSave("ESD_TPB_0113GS.do", tpbFrmQryStr(formObj));
				}
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
		 
		
		if ( formObj.n3pty_stl_tp_cd.value.length == 0 ){
			ComShowMessage(ComGetMsg("TPB90077", 'Adjustment Type'));
			formObj.n3pty_stl_tp_cd.focus();
			return false;
		}

		formObj.stl_to_clt_cng_ofc_cd.value = ComTrim(formObj.stl_to_clt_cng_ofc_cd.value);
		
		if ( formObj.n3pty_stl_tp_cd.value == "O" && formObj.stl_to_clt_cng_ofc_cd.value.length < 5 ){ /// R.O.C To 
			ComShowMessage(ComGetMsg("TPB90078", 'R.O.C To'));
			formObj.btn_rocto.style.display = ""; // Added By Kim Jin-seung In 2007-08-31
			formObj.stl_to_clt_cng_ofc_cd.select();
			return false;
		}
		//var rhq_ofc_cd = sheetObj.EtcData('OFC_CD');
   		
		
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
					ComShowMessage(ComGetMsg("TPB90078", 'R.O.C AMT'));
					sheetObjects[0].SelectCell(i, "stl_clt_ofc_cng_amt");
					return false; 
				}
			}
		}
		return true;
	}

	/**
	 * sheet1 on click 이벤트 
	 */
	function sheet1_OnClick(sheetObj, Row,Col){ 
		// Collection Activity 버튼 클릭시 팝업
//		alert(sheetObj.CellValue(Row, "chk_app"));
		var colNm = sheetObj.ColSaveName(Col);
		if ( colNm == "clt_act_yn" ) { 
//			alert(sheetObj.CellValue(Row, "n3pty_no"));
//  		alert(Col);
//  		alert(sheetObj.CellValue(Row,35));
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
			
            if ( stl_to_clt_cng_ofc_cd.length == 0 ){
            	// 3rd party value가 없으면 
            } else { // 있을 경우 유효성 체크            
            	
            	if(stl_to_clt_cng_ofc_cd == document.form.s_user_ofc_cd.value){
     
					sheetObj.CellValue2(Row, "stl_to_clt_cng_ofc_cd") = "";
					sheetObj.SelectCell(Row, Col, false);
					ComShowMessage(ComGetMsg("TPB90103"));
					sheetObj.FocusEditMode = -1;
    		  
					return ;
            	} else{
					//back-ROC 있을 경우 유효성 체크 
					document.form.f_cmd.value = COMMAND01;
					var sParam = FormQueryString(document.form);
					sParam = sParam + "&n3pty_no=" + sheetObj.CellValue(Row, "n3pty_no");
					var sXml = sheetObj.GetSearchXml("ESD_TPB_0113GS.do", sParam);
					if(ComGetEtcData(sXml,"r_ofc_cd")==sheetObj.CellValue(Row, "stl_to_clt_cng_ofc_cd")){
						ComShowMessage(ComGetMsg("TPB90107")+" ("+ComGetEtcData(sXml,"r_ofc_cd")+")");
						sheetObj.CellValue(Row, "stl_to_clt_cng_ofc_cd")="";
						return ;
					} else{
						var f = document.frames;
						var ifr = "frame_"+f.length;
						var o = document.createElement("DIV");
						o.style.display = "none";
						o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
						document.body.appendChild(o);
					
						eval("document."+ifr).location.href 
						= "TPBCommonCode.do?mode=T&id=stl_to_clt_cng_ofc_cd&method=checkTPBOffice&stl_to_clt_cng_ofc_cd="+stl_to_clt_cng_ofc_cd
							+ "&otherObjs=" + Row ;
					}
            	}
            }
		}
		
		

		var val = document.form.n3pty_stl_tp_cd.value; // C / D / O / W  // O, L, J, K, M 
		var ots_sts_cd = "";

		if ( sheetObj.ColSaveName(Col) == "chk_req" ) {  // chk_req on checking or unchecking
			if ( Value == 0 ) { // on unckecking 
				sheetObj.CellValue2(Row, "stl_clt_ofc_cng_amt") = "";
			} else { // on checking
				ots_sts_cd = sheetObj.CellValue(Row, "ots_sts_cd");  
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
			}
		} else if ( sheetObj.ColSaveName(Col) == "stl_clt_ofc_cng_amt" ) { // request amount on changing
			if ( Value != "" ) {
				sheetObj.CellValue2(Row, "chk_req") = 1;
			} else {
				sheetObj.CellValue2(Row, "chk_req") = 0;
			}
		} 
	}//OnChange
	


	/**
	 * 조회 후 작동하는 이벤트 핸들러 : OnSearchEnd
	 */
	var curr_action = "";
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		
		//조건초기화
		document.form.s_ra_rmk1.value = '';
		document.form.s_ra_rmk2.value = '';
		
		var s_date_kind_flag = document.form.s_date_kind_flag.value;
		var s_date_flag_r = document.form.s_date_flag_r.value;
		var s_date_flag_i = document.form.s_date_flag_i.value;
		
		if( s_date_kind_flag == "R" ){
		
			// 현 조회 결과값에서 선택할 수 있는 액션에 대한 정보를 curr_action 에저장.
			if(s_date_flag_r == "IN"){
				curr_action = "APPROVAL";
			}else if(s_date_flag_r == "OT"){
				curr_action = "REQUEST";
			}
			
			for( var i=sheetObj.RowCount ; i > 0 ; i-- ){
				// s_date_kind_flag에 따른 IBSheet컬럼변경.
				if( s_date_flag_r == "AL" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
					sheetObj.CellBackColor(i,"stl_to_clt_cng_ofc_cd") = sheetObj.CellBackColor(i,"n3pty_no");
				}else if( s_date_flag_r == "IN" ){
					if( sheetObj.CellValue(i,"approval") == 'Y' ){
						sheetObj.CellEditable(i,"chk_app") = true;
						sheetObj.CellEditable(i,"chk_rej") = true;
						sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
						sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
					}else{
						// approval 이 N 이더라도 review_step과 login id가 같으면 활성화.
						if( sheetObj.CellValue(i,"review_step") == document.form.s_user_ofc_cd.value ){
							sheetObj.CellEditable(i,"chk_app") = true;
							sheetObj.CellEditable(i,"chk_rej") = true;
							sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
							sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
						}
					}
					//'S'권한에 대한 approve/reject권한 처리
					if( document.form.s_office_level.value == "R" &&
					    document.form.s_rhq_cd_for_rhq.value == sheetObj.CellValue(i,"review_step")){
						sheetObj.CellEditable(i,"chk_rej") = true;
						sheetObj.CellEditable(i,"chk_app") = true;
					}
					
				}else if( s_date_flag_r == "OT" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = true;
					sheetObj.CellEditable(i,"chk_req") = true;
					sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
				}
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
				
				//RHQ에 의한 Request방지 
				if( document.form.s_office_level.value == "R" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
					sheetObj.CellEditable(i,"chk_req") = false;
					sheetObj.CellBackColor(i,"stl_to_clt_cng_ofc_cd") = sheetObj.CellBackColor(i,"n3pty_no");
					sheetObj.CellBackColor(i,"chk_req") = sheetObj.CellBackColor(i,"n3pty_no");
					//ROC-IN 조회시 R권한에서는 요청건만 display
					if( sheetObj.CellValue(i,"review_step")!= document.form.s_rhq_cd_for_rhq.value ){
						if( document.form.s_rhq_cd_for_rhq.value == "N" ){
							//sheetObj.RowHidden(i) = true;
							sheetObj.RowDelete(i,false);
						}
					}
				}else if(document.form.s_office_level.value == "H" ){
					//ROC-IN 조회시 H권한에서는 요청건만 display
					if( sheetObj.CellValue(i,"review_step")!= document.form.s_user_ofc_cd.value ){
						//sheetObj.RowHidden(i) = true;
						sheetObj.RowDelete(i,false);
					}
				} 
			}//for
			
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
		
		}else if( s_date_kind_flag == "I" ){

			for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
				sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
			}
			
			sheetObj.ColHidden("chk_req") = true;
			sheetObj.ColHidden("chk_rej") = true;
			sheetObj.ColHidden("chk_app") = true;
			sheetObj.ColHidden("ibflag")  = true;

			if(s_date_flag_i=="OL"){
				
				//* 2008-12-18 O Wan-Ki 1.1 Cancel, Approval 권한제한에 의한 보완  - TPB Office만이 cancel 할수있다.
				if( document.form.s_office_level.value == 'T' || document.form.priv_cd.value == 'T' ){
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
		}

		//Hidden 처리
		if( s_date_kind_flag == "R" ){

			if(s_date_flag_r == "AL"){
				sheetObj.ColHidden("stl_to_clt_cng_ofc_cd") = false;
				sheetObj.ColHidden("chk_req") = true;
				sheetObj.ColHidden("chk_app") = true;
				sheetObj.ColHidden("chk_rej") = true;
				sheetObj.ColHidden("ibflag") = true;
				sheetObj.ColHidden(0) = true;
			}else if(s_date_flag_r == "IN" ){
				sheetObj.ColHidden("chk_rej") = false;
				sheetObj.ColHidden("chk_app") = false;
				sheetObj.ColHidden("chk_req") = true;
				sheetObj.ColHidden("ibflag") = false;
				sheetObj.ColHidden(0) = true;
				//'S'권한에 대한 approve/reject권한 처리
				if( document.form.s_office_level.value == "R" &&
				    document.form.s_rhq_cd_for_rhq.value == sheetObj.CellValue(i,"review_step")){
					sheetObj.ColHidden("chk_rej") = false;
					sheetObj.ColHidden("chk_app") = false;
				}
			}else if(s_date_flag_r == "OT" ){
				if( document.form.s_office_level.value == 'T' || document.form.priv_cd.value == 'T' ){
					sheetObj.ColHidden("chk_req") = false;
				}else{
					sheetObj.ColHidden("chk_req") = true;
				}
				sheetObj.ColHidden("chk_rej") = true;
				sheetObj.ColHidden("chk_app") = true;
				sheetObj.ColHidden("ibflag") = false;
				sheetObj.ColHidden(0) = true;
				sheetObj.ColHidden("stl_to_clt_cng_ofc_cd") = false;
			}
		}else if( s_date_kind_flag == "I" ){

		}
	}
	
	/**
	 * 조회결과에 오류가 발생하지 않았을 경우 정상메세지 함수
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){

		//조건초기화
		document.form.s_ra_rmk1.value = '';
		document.form.s_ra_rmk2.value = '';
		
		var s_date_kind_flag = document.form.s_date_kind_flag.value;
		var s_date_flag_r = document.form.s_date_flag_r.value;
		var s_date_flag_i = document.form.s_date_flag_i.value;
		
		
		if( s_date_kind_flag == "R" ){
		
			// 현 조회 결과값에서 선택할 수 있는 액션에 대한 정보를 curr_action 에저장.
			if(s_date_flag_r == "IN"){
				curr_action = "APPROVAL";
			}else if(s_date_flag_r == "OT"){
				curr_action = "REQUEST";
			}
			
			for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
				// s_date_kind_flag에 따른 IBSheet컬럼변경.
				if( s_date_flag_r == "AL" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
					sheetObj.CellBackColor(i,"stl_to_clt_cng_ofc_cd") = sheetObj.CellBackColor(i,"n3pty_no");
				}else if( s_date_flag_r == "IN" ){
					if( sheetObj.CellValue(i,"approval") == 'Y' ){
						sheetObj.CellEditable(i,"chk_app") = true;
						sheetObj.CellEditable(i,"chk_rej") = true;
						sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
						sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
					}
					//'S'권한에 대한 approve/reject권한 처리
					if( document.form.s_office_level.value == "R" &&
					    document.form.s_rhq_cd_for_rhq.value == sheetObj.CellValue(i,"review_step")){
						sheetObj.CellEditable(i,"chk_rej") = true;
						sheetObj.CellEditable(i,"chk_app") = true;
					}
					
				}else if( s_date_flag_r == "OT" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = true;
					sheetObj.CellEditable(i,"chk_req") = true;
					sheetObj.CellBackColor(i,"ibflag") = sheetObj.CellBackColor(i,"n3pty_no");
				}
				// s_date_flag_kind 가 R 일때는 자신의 점소의 것만이 조작가능 ==> 위의 조작과의 순서 주의.
				if( document.form.s_office_level.value == "T" ){
					if( document.form.s_user_ofc_cd.value != sheetObj.CellValue(i,"review_step") 
						|| sheetObj.CellValue(i,"review_step") == "" ){
						if(curr_action == "REQUEST"){
							sheetObj.CellEditable(i,"chk_req") = true;
						}else{
							sheetObj.CellEditable(i,"chk_req") = false;
							sheetObj.CellBackColor(i,"chk_req") = sheetObj.CellBackColor(i,"n3pty_no");
						}
						sheetObj.CellEditable(i,"chk_rej") = false;
						sheetObj.CellEditable(i,"chk_app") = false;
						sheetObj.CellBackColor(i,"chk_rej") = sheetObj.CellBackColor(i,"n3pty_no");
						sheetObj.CellBackColor(i,"chk_app") = sheetObj.CellBackColor(i,"n3pty_no");
					}
				}
				
				//RHQ에 의한 Request방지 
				if( document.form.s_office_level.value == "R" ){
					sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
					sheetObj.CellEditable(i,"chk_req") = false;
					sheetObj.CellBackColor(i,"stl_to_clt_cng_ofc_cd") = sheetObj.CellBackColor(i,"n3pty_no");
					sheetObj.CellBackColor(i,"chk_req") = sheetObj.CellBackColor(i,"n3pty_no");
				}
			}//for
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
		}else if( s_date_kind_flag == "I" ){
			for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
				sheetObj.CellEditable(i,"stl_to_clt_cng_ofc_cd") = false;
			}
	
			sheetObj.ColHidden("chk_req") = true;
			sheetObj.ColHidden("chk_rej") = true;
			sheetObj.ColHidden("chk_app") = true;
			sheetObj.ColHidden("ibflag")  = true;
			
			if(s_date_flag_i=="OL"){
				document.all.btn_cancel_left.style.display="";
				document.all.btn_cancel.style.display="";
				document.all.btn_cancel_right.style.display="";
				sheetObj.ColHidden(0) = false;
				for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){			
					if( sheetObj.CellValue(i,"ots_sts_cd_val") != "Requested"){
						sheetObj.CellEditable(i,0) = false;
						sheetObj.CellBackColor(i,0) = sheetObj.CellBackColor(i,"n3pty_no");
					}
				}//for
			}else{
				document.all.btn_cancel_left.style.display="none";
				document.all.btn_cancel.style.display="none";
				document.all.btn_cancel_right.style.display="none";
				sheetObj.ColHidden(0) = true;
			}
		}
		
		//bug성 checkBox align=center 로 수정.
		for( var i=1 ; i<sheetObj.RowCount+1 ; i++ ){
			sheetObj.CellAlign(i,"chk_app") = daCenter;
			sheetObj.CellAlign(i,"chk_rej") = daCenter;
			sheetObj.CellAlign(i,"chk_req") = daCenter;
			sheetObj.CellAlign(i,0) = daCenter;
		}
	
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg("TPB90075", 'Data'));
			//sheetObj.DoSearch("ESD_TPB_0113GS.do", final_retrieve_querystrings ); /// sheet data reload
		}
	}
	
	// 검색일의 기준이 되는 select박스 2개를 선택변경할 경우 일어나는 이벤트  => 선택변경에 의한 결과값 착오를 방지.
	function date_flag_OnChange(){
		var sheetObj = sheetObjects[0];
		if( window.event.srcElement.getAttribute("name")=="s_date_flag_r" &&
			document.form.s_date_kind_flag.value=="R"){
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
			sheetObj.RemoveAll();
		}else if( window.event.srcElement.getAttribute("name")=="s_date_flag_i" &&
			document.form.s_date_kind_flag.value=="I"){
			document.all.btn_cancel_left.style.display="none";
			document.all.btn_cancel.style.display="none";
			document.all.btn_cancel_right.style.display="none";
			sheetObj.RemoveAll();
		}
	}
	
	/// R.O.C-To-Office Validation Check
	function stl_to_clt_cng_ofc_cd_OnBlur(){
		var user_ofc_cd = document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd = document.form.stl_to_clt_cng_ofc_cd.value;
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value = "";
		    ComShowMessage(ComGetMsg("TPB90051"));
		    return ; 
		}
		checkROCToOffice(document.form, document.form.stl_to_clt_cng_ofc_cd);
	}

    function openRocToOfficePopup(){
    	var theURL = "ESD_TPB_0804.do";
        // ComShowMessage( theURL );
    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:450px";
    
    	var rtnValue = window.showModalDialog(theURL, window, features);
    
    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.stl_to_clt_cng_ofc_cd.value = rtnValue;
    	}

	    var user_ofc_cd = document.form.s_user_ofc_cd.value;
	    var stl_to_clt_cng_ofc_cd = document.form.stl_to_clt_cng_ofc_cd.value;
	    //ComShowMessage(document.form.s_user_ofc_cd.value);
		//ComShowMessage(document.form.stl_to_clt_cng_ofc_cd.value);
		if ( stl_to_clt_cng_ofc_cd!="" && stl_to_clt_cng_ofc_cd == user_ofc_cd ){
		    document.form.stl_to_clt_cng_ofc_cd.value = "";
		    ComShowMessage(ComGetMsg("TPB90051"));
		    document.form.stl_to_clt_cng_ofc_cd.focus();
		    return ; 
		}
    }	

    function openReasonToSavePopup(){
    	var theURL = "ESD_TPB_0805.do";
        // ComShowMessage( theURL );
    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:330px";
    	var rtnValue = window.showModalDialog(theURL, window, features);

    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value = rtnValue[0];
    		document.form.s_ra_rmk1.value = rtnValue[1];
    		document.form.s_ra_rmk2.value = rtnValue[2];
    		
//    		if ( trim(rtnValue[0]).length == 0 ){ 
//                ComShowMessage("File must be attached.");
//                return false;
//            }
    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
    		    ComShowMessage(ComGetMsg("TPB90060"));
                return false;
    		}

            if ( document.form.n3pty_stl_tp_cd.value=="W" && ComTrim(rtnValue[2]).length == 0 ){ 
                // ComShowMessage("In Write-Off case Preventive Measures must be input.");
                ComShowMessage(ComGetMsg("TPB90060"));
                return false;
            }
    		return true;
    		
    	} else {
    	    return false;
    	}
	}
	
    function openReviewResultPopup(){
    	var theURL = "ESD_TPB_0806.do";
        // ComShowMessage( theURL );
    	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:340px";
    	var rtnValue = window.showModalDialog(theURL, window, features);

    	if(rtnValue != undefined && rtnValue != null ){
    		document.form.s_file_no.value = rtnValue[0];
    		document.form.s_ra_rmk1.value = rtnValue[1];
    		
    		if ( ComTrim(rtnValue[1]).length == 0 ){ 
                // ComShowMessage("Review Result must be input.");
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
		sheet1_OnChange(sheetObj, Row, Col);
		
	}
	
	/**
	 * 폼 필드 변경시 이벤트
	 * 
	 * @return
	 */
	function obj_change() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		var sheetObj = sheetObjects[0];
		
//		if(srcName == "s_date_flag_i") {
//			if(srcValue == "IL" || srcValue == "IA" || srcValue == "IR") {
//				sheetObj.CellValue2(0, "if_rhq_cd") = "ROC-out RHQ";
//				sheetObj.CellValue2(0, "if_ofc_cd") = "ROC-out Office";
//			} else {
//				sheetObj.CellValue2(0, "if_rhq_cd") = "ROC-in RHQ";
//				sheetObj.CellValue2(0, "if_ofc_cd") = "ROC-in Office";
//			}
//		}
		if(srcName == "c_date_kind_flag") {
			if(srcValue == "R")
			{
				sheetObj.CellValue2(0, "if_rhq_cd") = "RHQ";
				sheetObj.CellValue2(0, "if_ofc_cd") = "Office";
				formObject.s_date_flag_i.value = "IL";
			} else {
				sheetObj.CellValue2(0, "if_rhq_cd") = "ROC-out RHQ";
				sheetObj.CellValue2(0, "if_ofc_cd") = "ROC-out Office";				
			}	
			sheetObj.RemoveAll();
		}
	}
	

	/* 개발자 작업  끝 */