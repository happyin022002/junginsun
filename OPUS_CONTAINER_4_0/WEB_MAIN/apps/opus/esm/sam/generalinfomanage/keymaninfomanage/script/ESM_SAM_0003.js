	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : ESM_SAM_0003.js
	*@FileTitle  : KeyMan Info Management
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/06/23
	=========================================================*/
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND0x`1=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var isBtn1=false;
	var isBtn2=false;
	var isBtn3=false;
	var deleteFlg = false;
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_Retrieve":			
	//			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			doActionIBSheet(sheetObject1, formObject, IBCLEAR);
			break;
		case "btn_New":
			clearAllData(sheetObject1, formObject);
			ComBtnDisable("btn_Save");
			form_disable();
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_RowAdd":
			addKeyManInfo();
			form_enable();
			if(formObject.cust_nm.value != ""){
				formObject.cust_cd1.value=formObject.cust_cd.value;
				formObject.cust_lgl_eng_nm.value=formObject.cust_nm.value;
			}
			ComBtnEnable("btn_Save");
			break;
		case "btn_Delete":
			if(deleteKeyManInfo()){
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;
		case "btns_search1":
			ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 500, 'getCustCd', "1,0,1", true);
			break;
		case "btn_cal1_kmanbd":
			if (isBtn1) {
				var cal=new ComCalendar();
				cal.select(formObject.kman_brdy_dt, 'yyyy-MM-dd');
			}
			break;
		case "btn_cal1_spbd":
			if (isBtn2) {
				var cal=new ComCalendar();
				cal.select(formObject.kman_sps_brdy_dt, 'yyyy-MM-dd');
			}
			break;
		case "btn_cal1_wedt":
			if (isBtn3) {
				var cal=new ComCalendar();
				cal.select(formObject.kman_wedd_anv_dt, 'yyyy-MM-dd');
			}
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function getCustCd(aryPopupData) {
		var form=document.form;
		form.cust_cd.value=aryPopupData[0][3];
	} 
	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	* IBCombo Object를 배열로 등록
	* param : combo_obj ==> 콤보오브젝트
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/ 
	function setComboObject(combo_obj) {  
		comboObjects[comboCnt++]=combo_obj;  
	}
	/**
	* Sheet 기본 설정 및 초기화 <br>
	* body 태그의 onLoad 이벤트핸들러 구현 <br>
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	* <br><b>Example :</b>
	* <pre>
	*     loadPage();
	* </pre>
	* @return 없음	
	* @author 이창원
	* @version 2011.05.21
	*/
	 function loadPage() {
		 for(i=0;i<sheetObjects.length;i++){
			 //khlee-시작 환경 설정 함수 이름 변경
		 ComConfigSheet (sheetObjects[i] );
		 initSheet(sheetObjects[i],i+1);
		 //khlee-마지막 환경 설정 함수 추가
		 ComEndConfigSheet(sheetObjects[i]);
	 }
	 document.form.ibflag.value="I";
	 ComBtnDisable("btn_RowAdd");
	 ComBtnDisable("btn_Delete");
	 ComBtnDisable("btn_Save");
	 form_disable();
	 doActionIBCombo(sheetObjects[0], document.form, SEARCH);
	 if(document.form.cust_cd.value != ""){
			 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		 }
		 initControl();
		 ComSetFocus(document.form.cust_cd);
	 }
	 
	 function initControl() {
		 axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);  	// Enter key 처리	
		 axon_event.addListenerForm('change', 'obj_change', document.form); // change
		 axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  document.form);     //- 포커스 나갈때
	 }
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var formObj=document.form;
		switch(sheetID) {
		case "sheet1":      //sheet1 init
	with (sheetObj) {
		var HeadTitle="|Sel|SEQ|First Name|Last Name|Female/Male|Job Title|Customer|Customer Code|S. Rep.|Country Phone|Work Fax#|Key Man Sequence";
	    var headCount=ComCountHeadTitle(HeadTitle);
	
	    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1, NewRowDeleteMode:1 } );
	
	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    InitHeaders(headers, info);
	    
	    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                {Type:"DelCheck",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
						{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"kman_n1st_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"kman_lst_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"kman_gnd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"jb_tit_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1,  Width:20,  Align:"Center",  ColMerge:0,   SaveName:"cust_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"intl_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"kman_ofc_fax_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cust_kman_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          
	         InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(200);
		}
		break;
		}
	 }
	 /**
	  * 모든 콤보 박스 조회
	  * 공통 부분 완성되면 추가 작업 요
	  */
	 function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
		 switch (sAction) {
		 case SEARCH: // load page 시
	 var param="f_cmd="+SEARCH+"&scr_no="+"0003";
	 var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do",param);
	 var arrXml=sXml.split("|$$|");
	 if (arrXml.length > 0) {
		 ComXml2ComboItem(arrXml[0], kman_gnd_cd, "cd", "cd_desc");
		 ComXml2ComboItem(arrXml[1], kman_sgnf_ind_cd, "cd", "cd_desc");
		 ComXml2ComboItem(arrXml[2], kman_edu_cate_cd, "cd", "cd_desc");
		 ComXml2ComboItem(arrXml[3], kman_marr_flg, "cd", "cd_desc");
		 var comboXml=ComXml2ComboString(arrXml[0], "cd_desc", "cd");
		 var cdName=comboXml[0].split("|");
		 var cdValue=comboXml[1].split("|");
		 sheetObj.SetColProperty("kman_gnd_cd", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
		 }
		 break;
		 }
	 }
	/**
	 * Sheet관련 프로세스 처리
	 * 공통 부분 완성되면 추가 작업 요
	 */ 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
		case IBSEARCH:   //조회
		sheetObjects[0].RemoveAll();
		var formObj=document.form;
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(false);
			formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("ESM_SAM_0003GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			var rtnValue=sXml.split("|$$|");
			var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
			if(sav != "S" ){
				ComOpenWait(false);
				return;
			}
		}
		break;
	case SEARCH01:	  //조회
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		formObj.f_cmd.value=SEARCH01;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sParam=FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("ESM_SAM_0003GS.do", sParam);
		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		if(sav != "S" ){
			ComOpenWait(false);
			return;
		}
		// 입력 박스 데이터 채우기
		formObj.ibflag.value="U";							//조회 후 조회 건에 대해 insert 아닌 update 되도록
		formObj.kman_n1st_nm.value=toString(ComXmlString(sXml, "kman_n1st_nm"));                             
		formObj.kman_lst_nm.value=toString(ComXmlString(sXml, "kman_lst_nm"));                              
		kman_gnd_cd.SetSelectCode(toString(ComXmlString(sXml, "kman_gnd_cd")));
		formObj.jb_tit_rmk.value=toString(ComXmlString(sXml, "jb_tit_rmk")); 
		formObj.kman_dept_desc.value=toString(ComXmlString(sXml, "kman_dept_desc"));   
		formObj.kman_brdy_dt.value=toString(ComXmlString(sXml, "kman_brdy_dt") );
		formObj.kman_hby_desc.value=toString(ComXmlString(sXml, "kman_hby_desc"));                            
		formObj.kman_sps_nm.value=toString(ComXmlString(sXml, "kman_sps_nm"));                              
		formObj.kman_ofc_addr.value=toString(ComXmlString(sXml, "kman_ofc_addr"));                            
		formObj.kman_hm_addr.value=toString(ComXmlString(sXml, "kman_hm_addr"));                             
		formObj.biz_iss_desc.value=toString(ComXmlString(sXml, "biz_iss_desc"));                             
		formObj.kman_rmk_desc.value=toString(ComXmlString(sXml, "kman_rmk_desc"));                            
		formObj.cust_cd1.value=toString(ComXmlString(sXml, "cust_cd"));
		formObj.cust_lgl_eng_nm.value=toString(ComXmlString(sXml, "cust_lgl_eng_nm"));                          
		formObj.kman_eml.value=toString(ComXmlString(sXml, "kman_eml"));                                 
		formObj.chg_desc.value=toString(ComXmlString(sXml, "chg_desc"));                                 
		kman_sgnf_ind_cd.SetSelectCode(toString(ComXmlString(sXml, "kman_sgnf_ind_cd")));
		formObj.kman_nknm_nm.value=toString(ComXmlString(sXml, "kman_nknm_nm"));                             
		kman_edu_cate_cd.SetSelectCode(toString(ComXmlString(sXml, "kman_edu_cate_cd")));
		formObj.kman_mjr_desc.value=toString(ComXmlString(sXml, "kman_mjr_desc"));                            
		kman_marr_flg.SetSelectCode(toString(ComXmlString(sXml, "kman_marr_flg")));
		formObj.kman_sps_brdy_dt.value=toString(ComXmlString(sXml, "kman_sps_brdy_dt"));
		formObj.kman_wedd_anv_dt.value=toString(ComXmlString(sXml, "kman_wedd_anv_dt"));
		formObj.intl_phn_no.value=toString(ComXmlString(sXml, "intl_phn_no") );
		formObj.kman_ofc_fax_no.value=toString(ComXmlString(sXml, "kman_ofc_fax_no"));
		formObj.kman_brdy_dt.value=ComGetMaskedValue(formObj.kman_brdy_dt.value, "ymd");
		formObj.kman_sps_brdy_dt.value=ComGetMaskedValue(formObj.kman_sps_brdy_dt.value, "ymd");
		formObj.kman_wedd_anv_dt.value=ComGetMaskedValue(formObj.kman_wedd_anv_dt.value, "ymd");
		ComOpenWait(false);
		formObj.cust_cd1.readOnly=true;		//내용 수정 시 조회 건에 대한 update를 하므로 key 값 변경 못하도록 disable
		formObj.cust_lgl_eng_nm.readOnly=true;
	break;
	case IBCLEAR:      //OPEN			
		formObj.ibflag.value="I";
		ComClearObject(formObj.cust_cd1);
		ComClearObject(formObj.cust_lgl_eng_nm);		  
		ComClearObject(formObj.kman_n1st_nm);
		ComClearObject(formObj.kman_lst_nm);
		ComClearObject(formObj.jb_tit_rmk);
		ComClearObject(formObj.kman_dept_desc);
		ComClearObject(formObj.kman_brdy_dt);
		ComClearObject(formObj.kman_hby_desc);
		ComClearObject(formObj.kman_sps_nm);
		ComClearObject(formObj.kman_ofc_addr);
		ComClearObject(formObj.kman_hm_addr);
		ComClearObject(formObj.kman_eml);
		ComClearObject(formObj.chg_desc);
		ComClearObject(formObj.kman_nknm_nm);
		ComClearObject(formObj.kman_mjr_desc);
		ComClearObject(formObj.kman_sps_brdy_dt);
		ComClearObject(formObj.kman_ofc_addr);
		ComClearObject(formObj.kman_wedd_anv_dt);
		ComClearObject(formObj.biz_iss_desc);
		ComClearObject(formObj.kman_rmk_desc);
		ComClearObject(formObj.intl_phn_no);
		ComClearObject(formObj.kman_ofc_fax_no);
		
		kman_gnd_cd.SetSelectText("");
		kman_edu_cate_cd.SetSelectText("");
		kman_marr_flg.SetSelectText("");
		kman_sgnf_ind_cd.SetSelectText("");			
		break;
	case IBDELETE:
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value=MULTI01;
			var params=""
			if(sheetObj.FindCheckedRow("chk")!="" && sheetObj.FindCheckedRow("chk")!=undefined){
				params = sheetObjects[0].GetSaveString(0)+"&f_cmd="+formObj.f_cmd.value;
			}
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_SAM_0003GS.do", params);
			ComOpenWait(false);
			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			if(result != "F"){
				ComShowCodeMessage("COM130102", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				doActionIBSheet(sheetObj, formObj, IBCLEAR);
			}else{
				ComShowCodeMessage("COM130103", "Data");
			}
		}
		break;
	case IBSAVE:
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value=MULTI;
			var params=FormQueryString(formObj);
			if(ComShowCodeConfirm("COM130101", "data")){
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_SAM_0003GS.do", params);
				ComOpenWait(false);
				var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result != "F"){
					ComShowCodeMessage("COM130102", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
				}else{
					ComShowCodeMessage("COM130103", "data");
					}
				}
			}
			break;
		}
	 }
	
	
	function clearAllData(sheetObj, formObj){
		formObj.reset();
		formObj.cust_cd.text="";
	formObj.ibflag.value="R";
	sheetObjects[0].RemoveAll();
	
	//	formObj.kman_gnd_cd.text="";
	//	formObj.kman_edu_cate_cd.text="";
	//	formObj.kman_marr_flg.text="";
	//	formObj.kman_sgnf_ind_cd.text="";
	kman_gnd_cd.SetSelectText("");
	kman_edu_cate_cd.SetSelectText("");
	kman_marr_flg.SetSelectText("");
	kman_sgnf_ind_cd.SetSelectText("");
	ComBtnDisable("btn_RowAdd");
	ComBtnDisable("btn_Delete");
	ComBtnDisable("btn_Save");
	} 
	
	/**
	* 시트를 더블클릭했을 때 처리
	 **/
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj=document.form;
		form_enable();
		formObj.cust_kman_seq.value=sheetObj.GetCellValue(Row, "cust_kman_seq");
	doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
	ComBtnEnable("btn_RowAdd");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_Save");
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
	function obj_Keypress(){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	var srcValue=event.srcElement.getAttribute("value");
	switch(event.srcElement.dataformat) {
	case "number"://숫자,-입력하기
		ComKeyOnlyNumber('number', "-");
		break;
	case "engupnum"://숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('uppernum'); 
		break;
	case "ymd":
		ComKeyOnlyNumber();
		break;
	default:     //영문 + 숫자
		ComKeyOnlyAlphabet('uppernum'); 
		break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 **/
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
		 case IBSEARCH:
			 if(formObj.cust_cd.value == "" || formObj.cust_cd.value == null){
			 ComShowCodeMessage("COM130403", "Customer Code");
	//			 formObj.cust_cd.focus();
			 return false;
		 }
		 break;
	 case IBSAVE:		//저장
		 if(formObj.cust_cd.value == ""){
			 ComShowCodeMessage("SAM00017", "Customer Code");
	//				 formObj.kman_n1st_nm.focus();
			 return false;
		 }if(formObj.kman_n1st_nm.value == ""){
			 ComShowCodeMessage("SAM00017", "First Name");
	//				 formObj.kman_n1st_nm.focus();
			 return false;
		 }if(kman_gnd_cd.GetSelectCode()== ""){
			 ComShowCodeMessage("SAM00017", "Female/Male");
	//				 formObj.kman_gnd_cd.focus();
			 return false;
		 }if(formObj.kman_eml.value == ""){
			 ComShowCodeMessage("SAM00017", "Email");
	//				 formObj.kman_eml.focus();
			 return false;
		 }if(!ComIsEmailAddr(formObj.kman_eml.value)){
			 ComShowCodeMessage("COM132201","E-mail Address");
			 return false;
		 }if(formObj.jb_tit_rmk.value == ""){
			 ComShowCodeMessage("SAM00017", "Job Title");
	//				 formObj.jb_tit_rmk.focus();
			 return false;
		 }if(formObj.chg_desc.value == ""){
			 ComShowCodeMessage("SAM00017", "In Charge of");
	//				 formObj.chg_desc.focus();
			 return false;
		 }if(formObj.kman_brdy_dt.value == ""){
			 ComShowCodeMessage("SAM00017", "Birth Day");
	//				 formObj.kman_brdy_dt.focus();
			 return false;
		 }
		 if(formObj.kman_brdy_dt.value != ""){
			 //날짜형식에 맞는지 체크
			 if (!ComIsDate(formObj.kman_brdy_dt.value)) {
				 ComShowCodeMessage("COM12179");
				 formObj.kman_brdy_dt.value="";
	//					 formObj.kman_brdy_dt.focus();
				 return false;
			 }
		 }
		 if(formObj.kman_sps_brdy_dt.value != ""){
			 //날짜형식에 맞는지 체크
			 if (!ComIsDate(formObj.kman_sps_brdy_dt.value)){
				 ComShowCodeMessage("COM12179");
				 formObj.kman_sps_brdy_dt.value="";
	//					 formObj.kman_sps_brdy_dt.focus();
				 return false;
			 }
		 }
		 if(formObj.kman_wedd_anv_dt.value != ""){
			 //날짜형식에 맞는지 체크
			 if (!ComIsDate(formObj.kman_wedd_anv_dt.value)){
				 ComShowCodeMessage("COM12179");
				 formObj.kman_wedd_anv_dt.value="";
	//					 formObj.kman_wedd_anv_dt.focus();
				 return false;
			 }
		 }
		 var delRow =sheetObj.FindCheckedRow("chk");
			if(delRow!="" && delRow!=undefined){
				sheetObjects[0].CheckAll(1, 0);
				for(var i=1; i<=sheetObjects[0].LastRow(); i++){
					if(formObj.cust_kman_seq.value == sheetObjects[0].GetCellValue(i, "cust_kman_seq")){
						sheetObjects[0].SelectCell(i, "cust_kman_seq");
						}
					}
					return true;
				}
			 break;
		 }
		 return true;
	}
	
	
	/**
	 * Focus 처리
	 */
	  function obj_focus() {
	      	if(event.srcElement.options){
	//      		event.srcElement.focus();
	      	}else{
	      		event.srcElement.select();
	      	}
	      }
	 
	  /**
	   * OnKeyDown event를 처리한다. <br>
	   * <br><b>Example :</b>
	   * <pre>
	   *
	   * </pre>
	   * @param 없음
	   * @return 없음
	   * @author 서미진
	   * @version 2010.11.03
	   */
	  function obj_keydown(){
		  var formObject=document.form;
		  var eleName=event.srcElement.name;
	      if (event.keyCode == 13){
	    	  if(formObject.cust_cd.value=="" || formObject.cust_cd.value==undefined){
			  formObject.cust_cd.value = "";
			  formObject.cust_cd.focus();
			  return false;
		  }
		  formObject.f_cmd.value=SEARCH02;
		  var sXml=sheetObjects[0].GetSearchData("ESM_SAM_0003GS.do", FormQueryString(formObject));
		  formObject.cust_cd.value=ComGetEtcData(sXml, "cust_cd") ;
			  sheetObjects[0].RemoveAll();
			  doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			  if(formObject.cust_cd1.value == undefined){
				  ComClearObject(formObj.cust_cd1);
				  ComClearObject(formObj.cust_lgl_eng_nm);
				  }
	      }
	  }
	  
	  /**
	   * Row Add 버튼 클릭 시 수행 
	   */
	  function addKeyManInfo(){
		  sheetObjects[0].CheckAll(1, 0);
		  sheetObjects[0].SetSelectRow(1);
		  var formObj=document.form;
		  formObj.ibflag.value="I";
	  ComClearObject(formObj.kman_n1st_nm);
	  ComClearObject(formObj.kman_lst_nm);
	  ComClearObject(formObj.jb_tit_rmk);
	  ComClearObject(formObj.kman_dept_desc);
	  ComClearObject(formObj.kman_brdy_dt);
	  ComClearObject(formObj.kman_hby_desc);
	  ComClearObject(formObj.kman_sps_nm);
	  ComClearObject(formObj.kman_ofc_addr);
	  ComClearObject(formObj.kman_hm_addr);
	  ComClearObject(formObj.kman_eml);
	  ComClearObject(formObj.chg_desc);
	  ComClearObject(formObj.kman_nknm_nm);
	  ComClearObject(formObj.kman_mjr_desc);
	  ComClearObject(formObj.kman_sps_brdy_dt);
	  ComClearObject(formObj.kman_ofc_addr);
	  ComClearObject(formObj.kman_wedd_anv_dt);
	  ComClearObject(formObj.biz_iss_desc);
	  ComClearObject(formObj.kman_rmk_desc);
	  ComClearObject(formObj.intl_phn_no);
	  ComClearObject(formObj.kman_ofc_fax_no);
	  kman_gnd_cd.SetSelectText("");
	  kman_edu_cate_cd.SetSelectText("");
	  kman_marr_flg.SetSelectText("");
	  kman_sgnf_ind_cd.SetSelectText("");
	  getKmanSeq();
	  ComBtnEnable("btn_Save");
	  ComBtnEnable("btn_RowAdd");
	  ComBtnEnable("btn_RowDelete");
	  }
	  
	  /**
	   * Delete 버튼 클릭 시 수행 <br>
	   * @version 2015.07.01
	   */
	  function deleteKeyManInfo(){
		  var formObj = document.form;
		  var cust_cd = formObj.cust_cd.value;
		  var sheetObj = sheetObjects[0];
		  var delRow =sheetObj.FindCheckedRow("chk");
		if(delRow!="" && delRow!=undefined){
			 if(formObj.cust_cd1.value!="" && formObj.cust_lgl_eng_nm.value!=""){
				 if(ComShowCodeConfirm("SAM00015")){
					 deleteFlg = true;
				 }
				 else{
					 sheetObjects[0].CheckAll(1, 0);
					 for(var i=1; i<=sheetObjects[0].LastRow(); i++){
							if(formObj.cust_kman_seq.value == sheetObjects[0].GetCellValue(i, "cust_kman_seq")){
								sheetObjects[0].SelectCell(i, "cust_kman_seq");
							}
						}
					 return false;  
				 }
			  }
			 if(deleteFlg || ComShowCodeConfirm("SAM00014")){
				 var delArr = delRow.split("|");
				 for(var i=0; i<delArr.length; i++){
					sheetObj.SetCellValue(delArr[i], "cust_cd", cust_cd);
					sheetObj.SetRowStatus(delArr[i], "D");
					sheetObj.SetRowHidden(delArr[i], 1);
				}
				 deleteFlg = false;
				return true;
			 }
		}else{
			ComShowCodeMessage("COM12114", "row(s) to delete.");
			}
	  }
	  
	  function getKmanSeq(){
		  var formObj=document.form;
			var sheetObj=sheetObjects[0];
			if(sheetObj.SearchRows()> 0){
				formObj.cust_kman_seq.value=Number(sheetObj.GetCellValue(sheetObj.LastRow(), "cust_kman_seq"))+1;
		}else{
			formObj.cust_kman_seq.value=1;
		}
		sheetObj.SetCellValue(formObj.cust_kman_seq.value, "cust_kman_seq");
	  }
	  
	  
	  /**
	   * 필드 데이타가 CHANGE될 경우 이벤트
	   */
	  function obj_change(){
		  var formObj=document.form;
		  var sheetObj=sheetObjects[0];
		  /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	  /*******************************************************/
	  try {
		  var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		  switch(srcName) {
		  case "cust_cd":
			  if(formObj.cust_cd.value.length>0){
				  ComBtnDisable("btn_Save");
				  ComBtnDisable("btn_RowAdd");
				  ComBtnDisable("btn_RowDelete");
				  sheetObjects[0].SetWaitImageVisible(0);
				  if (!(ComIsNumber(formObj.cust_cd.value.substring(2,6)) && ComIsAlphabet(formObj.cust_cd.value.substring(0,2)))){
					  ComShowCodeMessage("SAM00018", "Customer Code");
					  formObj.cust_cd.value="";
					  formObj.cust_lgl_eng_nm.value="";
					  formObj.cust_cd1.value="";
					  return;
				  }
				  formObj.f_cmd.value=SEARCH02;
				  var sXml=sheetObj.GetSearchData("ESM_SAM_0003GS.do", FormQueryString(formObj));
				  if(ComGetEtcData(sXml,"cust_cd") == undefined){
					  ComShowCodeMessage("SAM00017", "Customer Code");
					  formObj.cust_cd.value="";
					  formObj.cust_lgl_eng_nm.value="";
					  formObj.cust_cd1.value="";
					  formObj.cust_cd.focus();
					  return;
				  }
				  else{ 
					  // 입력 박스 데이터 채우기
					  formObj.cust_cd.value=ComGetEtcData(sXml, "cust_cd") ;
					  formObj.cust_nm.value=ComGetEtcData(sXml, "cust_nm") ;
					  sheetObjects[0].RemoveAll();
					  form_disable();
					  doActionIBSheet(sheetObj, formObj, IBCLEAR);
				  }
			  }
			  break;
		  }	   // end switch
	  }catch(e) {
		  if( e == "[object Error]") {
				  ComShowMessage(OBJECT_ERROR);
			  } else {
				  ComShowMessage(e.message);
			  }
		  }
	   }
	  
		function obj_deactivate(){
		    ComChkObjValid(document.form.kman_brdy_dt);
		    ComChkObjValid(document.form.kman_sps_brdy_dt);
		    ComChkObjValid(document.form.kman_wedd_anv_dt);
		}
		function form_disable(){
			isBtn1=isBtn2=isBtn3=false;
			document.form.kman_n1st_nm.disabled=true;
			document.form.kman_lst_nm.disabled=true;
			document.form.jb_tit_rmk.disabled=true;
			document.form.kman_dept_desc.disabled=true;
			document.form.kman_brdy_dt.disabled=true;
			document.form.kman_hby_desc.disabled=true;
			document.form.kman_sps_nm.disabled=true;
			document.form.kman_ofc_addr.disabled=true;
			document.form.kman_hm_addr.disabled=true;
			document.form.kman_eml.disabled=true;
			document.form.chg_desc.disabled=true;
			document.form.kman_nknm_nm.disabled=true;
			document.form.kman_mjr_desc.disabled=true;
			document.form.kman_sps_brdy_dt.disabled=true;
			document.form.kman_ofc_addr.disabled=true;
			document.form.kman_wedd_anv_dt.disabled=true;
			document.form.biz_iss_desc.disabled=true;
			document.form.kman_rmk_desc.disabled=true;
			document.form.intl_phn_no.disabled=true;
			document.form.kman_ofc_fax_no.disabled=true;
			document.form.cust_cd1.readOnly=true;
			document.form.cust_lgl_eng_nm.readOnly=true;
			comboObjects[0].SetEnable(0);
			comboObjects[1].SetEnable(0);
			comboObjects[2].SetEnable(0);
			comboObjects[3].SetEnable(0);
		}
		function form_enable(){
			isBtn1=isBtn2=isBtn3=true;
			document.form.kman_n1st_nm.disabled=false;
			document.form.kman_lst_nm.disabled=false;
			document.form.jb_tit_rmk.disabled=false;
			document.form.kman_dept_desc.disabled=false;
			document.form.kman_brdy_dt.disabled=false;
			document.form.kman_hby_desc.disabled=false;
			document.form.kman_sps_nm.disabled=false;
			document.form.kman_ofc_addr.disabled=false;
			document.form.kman_hm_addr.disabled=false;
			document.form.kman_eml.disabled=false;
			document.form.chg_desc.disabled=false;
			document.form.kman_nknm_nm.disabled=false;
			document.form.kman_mjr_desc.disabled=false;
			document.form.kman_sps_brdy_dt.disabled=false;
			document.form.kman_ofc_addr.disabled=false;
			document.form.kman_wedd_anv_dt.disabled=false;
			document.form.biz_iss_desc.disabled=false;
			document.form.kman_rmk_desc.disabled=false;
			document.form.intl_phn_no.disabled=false;
			document.form.kman_ofc_fax_no.disabled=false;
			comboObjects[0].SetEnable(1);
			comboObjects[1].SetEnable(1);
			comboObjects[2].SetEnable(1);
			comboObjects[3].SetEnable(1);
			ComSetFocus(document.form.kman_n1st_nm);
		}
		
	function toString(obj) {
		if (obj == null || obj == undefined || obj == "")
			return "";
		if (typeof obj == "string")
			return obj;
		if (Object.prototype.toString.call(obj) === '[object Array]') {
			if (obj.length == 0)
				return "";
			return obj[0].replace('|', '');
		}
	}
	
	//2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
	function sheet1_OnSort(Col, SortArrow){
		sheet1.ReNumberSeq();
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code){
		if(Code==0){
			form_disable();
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_Delete");
			if(sheetObj.RowCount()<=0){
				ComBtnDisable("btn_Delete");
			}
			formCngCnt = 0;
	    }
	}
	 
	    