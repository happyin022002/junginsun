/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0224.js
*@FileTitle : EAS Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
/****************************************************************************************
이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
				[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
				기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	* @extends 
	* @class ESD_EAS_0224 : 0224EAS_0224 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	*/
	function ESD_EAS_0224() {
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
	
	//공통전역변수
	var frm = null;
	var eacSaveObj ="";  // eac_no 값을 저장한다.
	var usdRt ="";  // 환율
	var btnNewFlag = ""; // new 버튼 클릭 이벤트 발생 저장
	var combosXml = ""; // 최초화면 로드시 조회한 combo 셋팅 값을 가지고 있는다.
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	// tab 관련
	var tabObjects = new Array();
	var beforetab = 1;
	var openTabIndex = 0;	
	var tabCnt = 0 ;

	
	// offce_level 설정
	// H : 본부, R:RQH, O: 기타
	var ofcLevel="";
	
	// RW_AUTH_CD 설정
	// R : 읽기만 가능, W:수정가능
	var rwAuthCd ="";

	// offce_level 설정시 사용되는 변수
	var ofcLvlFalg = "N"
	
	/**
	IS	Saved	최초 저장
	AC	Auditor confirm	심사자 확정시
	RC	RHQ Confirm	지역본부 확정
	HC	HQ Confirm	본사 확정
	CP	Pending	지역본부 또는 본사에서 Pending
	ER	EAC Reject	지역본부 또는 본사에서 Reject
	*/
	
	var eacSts = "";
	
	/** 
	* IBTab Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
	* IBMultiCombo Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
	
	
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;    
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/	
		var sheetObject = sheetObjects[0]; 
		/*******************************************************/
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				/* [1.1.조회로직] */
				case "btn_retrieve":
						doActionIBSheet(sheetObject,frm,'btn_retrieve');
				break;
				case "btn_save":
						doActionIBSheet(sheetObject,frm,IBSAVE);
				break;
				
				/* [2.1.엑셀다운로드 버튼] */
				case "btng_downexcel":
						doActionIBSheet(sheetObject,frm,IBDOWNEXCEL);
				break;
				
				case "btn_vndr_seq":
						rep_OnPopupClick();
				break;
				
				case "btn_location":
						location_OnPopupClick();
				break;
				case "btn_audit_month":
					var cal = new ComCalendar();
						cal.setDisplayType('month');
						cal.select(frm.eac_yrmon, 'yyyy-MM');
				break;      			
				
				case "btng_RowAdd":
			 		  doActionIBSheet(sheetObject,frm,IBINSERT);
				break;
				
				case "btng_RowDel":
					if(sheetObject.FindCheckedRow("chk") == ""){
						ComShowCodeMessage("EAS90073");
					}else if(ComShowCodeConfirm("COM12171","")){
						doActionIBSheet(sheetObject, frm, IBDELETE);
					}
				break;
				case "btn_party_val":
					open3rdParty(frm.vndr_cust_div_cd.Code);
                break;
				case "btn_n3pty_no":
					if(frm.n3pty_no.value !=""){
						open3rdPtyNo(frm.n3pty_no.value);
					}
				break;
				case "btng_tpb_if":
					doActionIBSheet(sheetObject, frm, "btng_tpb_if");
					break;
				case "btn_issue":
					doActionIBSheet(sheetObjects[2],frm,"btn_issue");
					break;
				case "btng_preview":
					doActionIBSheet(sheetObjects[1],frm,"btng_preview");
					break;
				case "btn_attach":
					openEacFileAttach(frm.eac_no.value, frm.eac_cmpl_cd.Code);
					break;
				case "btn_close":
					window.close();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				//ComShowCodeMessage('EAS90098');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	
	function unLoadEnt(){
		if(frm.eac_no.value == "") return;
		var parentObj = window.dialogArguments;
		var eac_no  = frm.eac_no.value; 
			parentObj.fn_setEacNo(eac_no);
	}
	/** 
	* body 태그의 onLoad 이벤트핸들러 구현 <br>
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	* <br><b>Example :</b>
	* <pre>
	* </pre>
	* @param  없음
	* @return 없음
	* @see #
	* @author Choi Do Soon
	* @version 2009.11.16
	*/
	function loadPage() {
		frm = document.form;
		// 텝설정
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1,0);
		}	
		
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// 로그인한 오피스정보로 사용자의 권한을 조회한다.
		doActionIBSheet(sheetObjects[0], frm,"offce_level");
		ofcLvlFalg = "Y";
		//화면 초기 로딩시 콤보셋팅에서 시간이 많이 걸려 일괄처리로 로직을 변경함
		comboLoding();
		initPage();
		
		
		initControl();

		frm.vndr_seq.focus();
		frm.inv_amt.focus();
		frm.eac_inp_dt.focus();
		exchange_Rate();
		
		
		// Interface 된 Type 별 환경 설정
		setEnviromentPerInterfacedSystem();
	}
	
	function setEnviromentPerInterfacedSystem(){
		
		var sysIfType = frm.eac_sys_if_cd.value;
		
		// TR1 : Special SO for Transportation  - ESD_EAS_0304, TR2 : Surcharge Report  - ESD_EAS_0305
		// TR3 : Un-Matched  - ESD_EAS_0307, TR4 : Drop Off Charge  - ESD_EAS_0308
		if ( sysIfType == "TR1" ||sysIfType == "TR2"||sysIfType == "TR3" ||sysIfType == "TR4"||sysIfType == "TE2" ||sysIfType == "MR1"||sysIfType == "TRS") {
			var eqNo = frm.eq_no.value.split(',');
			var tpSz = frm.tp_sz.value.split(',');
			
			for( var i = 0 ; i < eqNo.length; i++){
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].CellValue2(i + 1,'eq_no') = eqNo[i];
				sheetObjects[0].CellValue2(i + 1,'eq_tpsz_cd') = tpSz[i];
				sheetObjects[0].CellValue2(i + 1,'eq_knd_cd') = frm.eq_knd.value;
			}
			if ( ComTrim(frm.eac_cost_desc.value) == "/" ) {
				frm.eac_cost_desc.value = "";
			} 
		}
	}
	
	function initPage(){
		if(eacSaveObj =="" && btnNewFlag == "1"){ // new 버튼 클릭으로 재조회 해야할 경우
			frm.eac_no.value = eacSaveObj;
			btnNewFlag = "";
		}else if(eacSaveObj !="" && btnNewFlag == ""){ // 저장후 재 조회 해야할경우
			// 로그인한 오피스정보로 사용자의 권한을 조회한다.
			frm.eac_no.value = eacSaveObj;
		}
		
		// loadPage에 있는 권한조회문(offce_level)을 탈경우 initPage 에서 안태우기 위해(화면 최초 로딩시 시간이 오래 걸리는 문제 해결을 위해)
		if(ofcLvlFalg=="N"){
			doActionIBSheet(sheetObjects[0], frm,"offce_level");
		}else{
			ofcLvlFalg = "N";
		}
		
		// 콤보셋팅
		comboSetting();
		frm.curr_cd.Code2 = frm.p_cur_cd.value; 
		
		//IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		
		
		frm.eac_inp_dt.value = ComGetNowInfo("ymd");	    // Entered Date 현재일자 셋팅
		//frm.audr_ofc_cd.value = ComTrim(frm.ofc_cd);     // 로그인한자의 offcd
		frm.eac_reg_usr_nm.value = ComTrim(frm.session_usr_nm.value);     // 로그인 한자의 이름
		
		//5일까지는 Audit Month를 전월로 셋팅한다.
		var toYmd = removeBar(ComGetNowInfo("ymd"));
		frm.eac_yrmon.value = toYmd.substring(0,6);
		frm.eac_yrmon.value = ComGetMaskedValue(frm.eac_yrmon,   "ym");		
//		var toDay = toYmd.substring(6,8);		
//		if (toDay > '05') {
//			frm.eac_yrmon.value = toYmd.substring(0,6);
//			frm.eac_yrmon.value = ComGetMaskedValue(frm.eac_yrmon,   "ym");
//		}else{
//			frm.eac_yrmon.value = ComGetDateAdd(toYmd,"D", -6, "-").substring(0,7);
//		}

		frm.btn_audit_month.style.display = "none"; // Audit Month 비활성화 (심사팀만 권한로직에서 활성화 시킨다.)
		
		if(frm.eac_no.value != ""){
			doActionIBSheet(sheetObjects[0],frm,'btn_retrieve');
		}else{
//			ComBtnDisable("btng_tpb_if"); // TPB I/F 저장전 데이터라 비활성화
			ComBtnDisable("btn_issue"); // issue 저장전 데이터라 비활성화
//			ComBtnDisable("btn_delete"); // delete 저장전 데이터라 비활성화
			ComBtnDisable("btng_preview"); // Rejection Notice 비활성화(조회전엔 비활성화 한다.)
			ComBtnDisable("btng_history"); // Rejection Notice History 비활성화(조회전엔 비활성화 한다.)		
		}

		frm.vndr_seq.focus();
		frm.inv_amt.focus();
		frm.eac_inp_dt.focus();
		exchange_Rate();		
	}
	

	// 화면 초기 로딩시 콤보조회
	function comboLoding(){
		var sheetObj = sheetObjects[0]; 
			frm.f_cmd.value = SEARCHLIST01;
		    combosXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	}
	
	// 콤보셋팅 일괄처리
	function comboSetting(){
		var arrXml = combosXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], frm.eac_expn_tp_cd,   "code_cd", "code_nm");	// Expense Type
		ComXml2ComboItem(arrXml[1], frm.eac_tp_cd,        "code_cd", "code_nm");	// EAC Type
		ComXml2ComboItem(arrXml[2], frm.eac_rsn_cd,       "code_cd", "code_nm");	// Action Type
		ComXml2ComboItem(arrXml[3], frm.eac_cmpl_cd,      "code_cd", "code_nm");	// Completion
		ComXml2ComboItem(arrXml[4], frm.vndr_cust_div_cd, "code_cd", "code_nm");	// 3RD Party
		ComXml2ComboItem(arrXml[5], frm.curr_cd, "bil_curr_cd", "bil_curr_cd1");
		ComXml2ComboItem(arrXml[7], frm.n3pty_expn_tp_cd, "code_cd", "code_nm");	// TPB Exp.Type

		
		// TPB Grid - EQ Kind
		var eqKndCd = ComXml2ComboString(arrXml[6],  "code_cd", "code_nm");
		sheetObjects[0].InitDataCombo(0, "eq_knd_cd", "|" + eqKndCd[1]+"|Vessel", "|" + eqKndCd[0]+"|V");    // IBSheet내 Combo 초기화
		
		

//		ComXml2ComboItem(sXml, frm.vndr_cntc_pnt_nm, "vndr_cntc_pnt_seq", "vndr_cntc_pnt_nm");		
		
		
	}
	
	
	/**
	* Combo 기본 설정 
	* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	*/ 
	function initCombo(comboObj, comboNo) {
	
		switch(comboObj.id) {
			case "eac_apro_tp_cd":  
				comboObj.RemoveAll();
				if(ofcLevel=="H"){
					comboObj.InsertItem(0, "1st Audit", "1");
					comboObj.InsertItem(1, "2nd Audit", "2");
					comboObj.InsertItem(2, "3rd Audit", "3");
					comboObj.Index=2;
					comboObj.Enable=false;
				}else if(ofcLevel=="R"){
					comboObj.InsertItem(0, "1st Audit", "1");
					comboObj.InsertItem(1, "2nd Audit", "2");
					comboObj.Index=0;
				}else if(ofcLevel=="O"){
					comboObj.InsertItem(0, "1st Audit", "1");
					comboObj.Index=0;
					comboObj.Enable=false;
					
					var lgin_ofc_cd = ComTrim(frm.ofc_cd);
					// NYCNAG, NYCNOG, HAMUAG, HAMUOG, SHAAAG, SHAAOG, SINWAG, SINWOG 일 경우 Audit Type 1, 2 선택 가능
					var arr_expt_ofc =  s_expt_ofc_cdCode.split("|");
					
					for (i = 0; i < arr_expt_ofc.length; i++) {
						if (lgin_ofc_cd == arr_expt_ofc[i]) {
							comboObj.RemoveAll();
							comboObj.InsertItem(0, "1st Audit", "1");
							comboObj.InsertItem(1, "2nd Audit", "2");
							comboObj.Index=0;
							comboObj.Enable=true;			
						}
					}
				}

			break;  
			case "eac_expn_tp_cd":  
				//호출한 업무영역 별로 셋팅
				if(frm.eac_sys_div_cd.value !=""){
					frm.eac_expn_tp_cd.Code2 = frm.eac_sys_div_cd.value; 
					frm.n3pty_expn_tp_cd.Code2 = frm.eac_sys_div_cd.value;
					
					frm.eac_expn_tp_cd.Enable  = false; // TPB Exp.Type
				}else{
					comboObj.Index=0;
					frm.n3pty_expn_tp_cd.Index=0;
				}												
			break;  
			case "eac_tp_cd":  
				comboObj.Index=0;
			break;  
			case "vndr_cust_div_cd":
				
				comboObj.Index=0;
			break;  
			case "eac_cmpl_cd":  
				comboObj.Index=0;
				break;  
			case "n3pty_expn_tp_cd":  
				comboObj.Enable=false;
			break;  
		}
	
	}	
	
	
	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
	}
	
	
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {
		case "eac_inp_dt":
		case "n3pty_src_dt":
		case "eac_yrmon":
			ComClearSeparator(obj);
			obj.select();
			break;			
			
		}		
	}
	
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "eac_inp_dt":
				ComChkObjValid(obj);
			break;
			case "vndr_seq":
				vender_change();
			break;
			case "n3pty_src_dt":
				ComChkObjValid(event.srcElement);
				var n3ptySrcDt=ComGetMaskedValue(frm.n3pty_src_dt, "ymd", "-");
				frm.n3pty_src_dt.value=n3ptySrcDt
				
				exchange_Rate();
			break;
			case "respb_ofc_cd":
				responsible_office_change();
			break;
			case "yd_cd":
				yd_cd_change();
			break;
			case "inv_amt":
				foramtComma(obj)
				inv_Change();
			break;
			case "inv_cng_amt": 
				foramtComma(obj)
				inv_Change();
			break;			
			case "inv_aud_amt":
				foramtComma(obj)
				inv_aud_amt_Change();
			break;			
			case "inv_aud_usd_amt":
				foramtComma(obj)
				var usdAmt = parseInt(ComReplaceStr(frm.inv_aud_usd_amt.value,",","")) ;
				if(usdAmt>=2000){
					frm.atch_file_id.className="input1"
				}else{
					frm.atch_file_id.className="input2"
				}
				frm.stl_amt.value = frm.inv_aud_usd_amt.value;
			break;			
			case "eac_yrmon":
				if(!ComChkObjValid(obj))obj.value="" ;
			break;			
			case "bkg_no":
				bkg_no_change();
			break;		

			case "trd_party_val":
				tpb3rdPartyChk();
			break;		
				
			case "stl_amt":
				foramtComma(frm.stl_amt);
			break;		
		}
	} 	
	
	// 입력한 3rdParty Value 값이 유효한지 체크한다.
	function tpb3rdPartyChk(){
		
		if(frm.trd_party_val.value==""){
				frm.s_trd_party_val.value   = ""; 
				frm.tpb_vndr_cnt_cd.value   = "";
				frm.tpb_vndr_seq.value      = "";
				frm.n3pty_ofc_cd.value      = "";
				frm.cust_cnt_cd.value       = "";
				frm.cust_seq.value          = "";
				
				frm.trd_party_val.value     = ""; 
				frm.trd_party_nm.value      = ""; 
			
			return;
		}
		
		/*
		 * 1. 3RD Party Code 입력 값이 사용가능 한지 체크 한다.
		 * */		
		
		var vpValue = frm.trd_party_val.value;
		if(frm.vndr_cust_div_cd.Code == "V"){
			// 첫번재 숫자의 위치를 찾아 그앞의 문자는 삭제한다.
			frm.s_trd_party_val.value = vpValue.substring(chkChars(vpValue,"0123456789"));
		}else{
			frm.s_trd_party_val.value = vpValue;
		}
		
		frm.f_cmd.value = COMMAND06;
		
		var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		var chkData = EasXmlString(sXml,"val");
		var vdData = "";
		
		if(chkData == ""){
			ComShowCodeMessage('COM132202', frm.vndr_cust_div_cd.Text); //사용할수 없는 S/P Code
			frm.s_trd_party_val.value =""; 
			frm.trd_party_val.value =""; 
			frm.trd_party_nm.value =""; 			
		}else{
			vdData = chkData.split("|$|");
			
			if(frm.vndr_cust_div_cd.Code  =="V"){
				frm.s_trd_party_val.value = vdData[1]; 
				frm.tpb_vndr_cnt_cd.value   = vdData[2];  // 국가 코드
				frm.tpb_vndr_seq.value      = vdData[1];  // 코드
			
				frm.trd_party_val.value =vdData[1]; 
				frm.trd_party_nm.value =vdData[3]; 
				
			}else if(frm.vndr_cust_div_cd.Code  =="S"){
				frm.s_trd_party_val.value = vdData[2];
				frm.n3pty_ofc_cd.value = vdData[2];
				
				frm.trd_party_val.value     = vdData[2];
				frm.trd_party_nm.value      = vdData[2];
				
			}else if(frm.vndr_cust_div_cd.Code  =="C"){
				frm.s_trd_party_val.value = vdData[2]+vdData[1]			
				
				frm.cust_cnt_cd.value       = vdData[2];  // 국가 코드
				frm.cust_seq.value          = vdData[1];  // 코드
				
				frm.trd_party_val.value     = vdData[2]+vdData[1];  // 국가 코드 + 코드
				frm.trd_party_nm.value      = vdData[3];  // 명칭
			}			
		}
		
	}
	
	function chkChars(input,chars) {
	    for (var inx = 0; inx < input.length; inx++) {
	       if (chars.indexOf(input.charAt(inx)) > -1) return inx;
	    }
	    return 0;
	}
	
	
	function foramtComma(obj){
		if(obj.value==0||obj.value==null) {
			obj.value="";
		return;
		}
		
		if( obj.value.indexOf('.')==-1||obj.value.indexOf('.')==0){
			obj.value = obj.value+".00";
		}else{
			var inVal = ComReplaceStr(obj.value,",","") // 입력한값
			var intVal = inVal.substring(0,inVal.indexOf('.')) //소수점 제외한 값
			var subVal = inVal.substring(inVal.indexOf('.')+1,inVal.length)     //  소수점 이하값
		
		
		if(subVal.length==2){ //  잘입력된 케이스
			obj.value = inVal;
		}else if(subVal.length==1){
			obj.value = intVal+"."+subVal+"0";
		}else{
			obj.value = intVal+"."+subVal.substring(0,2);
			}
		}
		
		ComAddSeparator(obj);		
	}
	
	/**
	* HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
	*/
	function obj_keypress(){
		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		
		switch(event.srcElement.dataformat){
			case "engup":		//영문대문자
				ComKeyOnlyAlphabet('upper');
			break;
			
			case "engupnum":	//숫자+영문대분자 입력하기
				ComKeyOnlyAlphabet('uppernum');
			break;
			
			case "engnum":		//숫자+영문대소 입력하기
				ComKeyOnlyAlphabet('num'); 
			break;
			case "float":       //실수 입력하기
				ComKeyOnlyNumber(event.srcElement, "-.");
			break;			
			
			case "engupcomma":	//영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
			break;
			
			case "engupnumcomma":	//숫자+영문대분자+Comma
				ComKeyOnlyAlphabet('upper', '44|48|49|50|51|52|53|54|55|56|57');
			break;
			
			//			case "ymd":
			//				ComKeyOnlyNumber(event.srcElement);
			//				if (srcValue.length == 4) {
			//					document.form.elements[srcName].value = srcValue.substring(0, 4) + "-"
			//				}
			//				if (srcValue.length == 7) {
			//					document.form.elements[srcName].value = srcValue.substring(0, 7) + "-"
			//				}
			//				break;
			default:
		}
	}	
	/**
	* Tab 기본 설정
	* 탭의 항목을 설정한다.
	*/
	function initTab(tabObj , tabNo,isauthority) {
		switch(tabNo) {
			case 1:
			   with (tabObj) {
				   tabObj.RemoveAll()
			       var cnt  = 0 ;
			       InsertTab( cnt++ , "Audit Detail" , -1 );
				   InsertTab( cnt++ , "Rejection Notice" , -1 );
				   InsertTab( cnt++ , "TPB I/F" , -1 );
			   }
			break;
		}
	}	
	
	/**
	* Tab 클릭시 이벤트 관련
	* 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}
	
	function tab1_OnClick(tabObj , nItem){
		if (openTabIndex != nItem) {
			openTabIndex = nItem;
		}
		
		if ( nItem == 0 ) {
		}else if ( nItem == 1 ) {
			//rejection_Notice_Search();
		}else if ( nItem == 2 ) {
			doActionIBCombo(frm.n3pty_bil_tp_cd); // TPB Code
		}		
	}
	
	function rejection_Notice_Search(){
		doActionIBCombo(frm.vndr_cntc_pnt_nm); // Contact Point
		doActionIBSheet(sheetObjects[1],frm,"IBSEARCH02");		
	}
	
	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init 3번째 탭 데이타
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(8);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;
					
					var HeadTitle1 = "||EQ Kind|EQ No. or VVD|EQ Type/Size|TPB Amount|eac_dtl_seq|eac_no";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,   true,    "ibflag");
//					InitDataProperty(0, cnt++ , dtStatus,	30,     daCenter,   true,    "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   true,   "chk",         	        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtComboEdit,    90,  	daCenter,   true,   "eq_knd_cd",            true);
					InitDataProperty(0, cnt++ , dtData,         120,  	daCenter,   true,   "eq_no",            	true,     "",      dfNone,          0,          true,        true,   15,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,   "eq_tpsz_cd",        	false,    "",      dfNone,          0,          true,        true,   4,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,   "diff_inv_amt",       	true,     "",      dfNullFloat,     2,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daRight,    true,   "eac_dtl_seq",       	false,     "",      dfNone,     2,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daRight,    true,   "eac_no",     	  	    false,     "",      dfNone,     2,          true,        true,   20,  false, true,  "", false);
					
					InitDataValid(0, 4, vtEngUpOther, "1234567890");
				}
			break;
			case 2:      //sheet2 init 2번째 탭
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;
					
					var HeadTitle1 = "||EQ Kind|EQ No. or VVD|EQ Type/Size|TPB Amount";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag",         	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_seq",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_lgl_eng_nm",  false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "zip_cd",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eng_addr",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cty_nm",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "ste_nm",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_eml",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "phn_no",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "fax_no",       	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,      100,  	daCenter,   true,   "eac_eml_use_flg", 	false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,      100,  	daCenter,   true,   "eac_fax_use_flg",  false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtHidden,      100,  	daCenter,   true,   "ntc_cc_rcv_eml",  false,    "",      dfNone,          0,          true,        true,   20,  false, true,  "", false);
							
				}
			break;
			case 3:      //sheet3 init 폼 데이타 
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
//				style.height = GetSheetHeight(8);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(69, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;
				
				var HeadTitle1 = "|EAC_NO|EAC_INP_DT|AUDR_USR_ID|AUDR_OFC_CD|EAC_APRO_TP_CD|EAC_STS_NM|EAC_STS_CD|EAC_EXPN_TP_CD|EAC_TP_CD|EAC_BIL_TP_CD|EAC_COST_DESC|RESPB_OFC_CD|VNDR_SEQ|VNDR_NM|N3PTY_SRC_NO|N3PTY_SRC_DT|YD_CD|VVD_CD_CTNT|CURR_CD|INV_AMT|INV_CNG_AMT|INV_AUD_AMT|INV_AUD_USD_AMT|STL_AMT|EXPN_EVID_DESC|EAC_YRMON|EAC_RSN_CD|EAC_DESC|EAC_INTER_RMK|EAC_RSN_DESC|EAC_CMPL_CD|EAC_CMPL_DT|NTC_HIS_SEQ|VNDR_CNTC_PNT_SEQ|EML_SUBJ_CTNT|EML_CTNT|EML_SND_DT|EAC_SYS_IF_CD|DELT_FLG|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|WO_NO_CTNT";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_no",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_inp_dt",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "audr_usr_id",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "audr_ofc_cd",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_apro_tp_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_sts_nm",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_sts_cd",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_expn_tp_cd",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_tp_cd",           false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_bil_tp_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_cost_desc",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "respb_ofc_cd",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_seq",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_nm",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_src_no",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_src_dt",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "yd_cd",               false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vvd_cd_ctnt",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "curr_cd",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "inv_amt",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "inv_cng_amt",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "inv_aud_amt",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "inv_aud_usd_amt",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "stl_amt",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "expn_evid_desc",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_yrmon",           false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_rsn_cd",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_desc",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_inter_rmk",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_rsn_desc",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_cmpl_cd",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_cmpl_dt",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "ntc_his_seq",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_cntc_pnt_seq",   false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eml_subj_ctnt",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eml_ctnt",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eml_snd_dt",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_sys_if_cd",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "delt_flg",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cre_usr_id",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cre_dt",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "upd_usr_id",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "upd_dt",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "wo_no_ctnt",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_expn_tp_cd",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_bil_tp_cd",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "bkg_no",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "bl_no",               false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "vndr_cust_div_cd",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "tpb_vndr_cnt_cd",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "tpb_vndr_seq",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cust_cnt_cd",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cust_seq",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_ofc_cd",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "n3pty_no",            false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "tpb_ofc_cd",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "ots_sts_nm",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "tpb_vndr_nm",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "cust_lgl_eng_nm",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "ofc_eng_nm",          false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "tpb_inv_amt",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_reg_usr_nm",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_rjct_ofc_cd",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_rjct_usr_nm",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_rjct_rsn",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "isflag",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "fileflag",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "kpi_ofc_cd",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

			}
				break;
			case 4:      //sheet3 init 프로그래스 안생기게 할려고 
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
//				style.height = GetSheetHeight(8);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(2, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;
				
				var HeadTitle1 = "|EAC_NO";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        100,  	daCenter,   true,   "eac_no",              false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				
				
			}
				break;
		}
	}	
	
	/**
	* Sheet 로딩 후 이벤트 <br>
	* body 태그의 onLoadFinish 이벤트핸들러 구현 <br>
	* @param  sheetObj
	* @return 없음
	* @author 
	* @version 2013.03.21
	*/ 
	function sheet1_OnLoadFinishLoad(sheetObj) {
		frm.f_cmd.value = SEARCH01;
		// 공통 테이블에서 조회할 키
		frm.code_key.value = "CD01132"
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		var eqKndCd = ComXml2ComboString(sXml,  "code_cd", "code_nm");
		sheetObj.InitDataCombo(0, "eq_knd_cd", "|" + eqKndCd[1]+"|Vessel", "|" + eqKndCd[0]+"|V");    // IBSheet내 Combo 초기화
	}

	
	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetObj3 = sheetObjects[3];
		
		switch (sAction) {
		
			// SEARCH LOGIC
			case "btn_retrieve":
				    // eac_no 가 없을때 조회가 되면 안된다.
					if(frm.eac_no.value =="") return;
					sheetObjects[2].RemoveAll();
					frm.f_cmd.value = SEARCH11;
					var sParam = FormQueryString(frm);
					var sXml = sheetObjects[2].GetSearchXml("ESD_EAS_0201GS.do", sParam);
					var arrXml = sXml.split("|$$|");
					sheetObjects[2].loadSearchXml(arrXml[0]);
					sheetObjects[0].loadSearchXml(arrXml[1]);
					
  						document.tab1.SelectedIndex = openTabIndex;
			break;
			case "IBSEARCH02":

				sheetObj.RemoveAll();
				frm.f_cmd.value = SEARCH12;
				var sParam = FormQueryString(frm);
				var sXml = sheetObjects[3].GetSearchXml("ESD_EAS_0201GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
			
			break;
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,frm,sAction)) return false;
				
				ComOpenWait(true);
				
				frm.f_cmd.value = MULTI01;
		
	         	var params = sheetObjects[0].GetSaveString(false, true)  + "&" + FormQueryString(frm);
	         	
	         	var sXml = sheetObjects[0].GetSaveXml("ESD_EAS_0201GS.do", params);				
				
				var eacNo = ComGetEtcData(sXml,"eac_no");
				frm.eac_no.value = eacNo;
				eacSaveObj = eacNo;
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('EAS90053');
				}
				authorityUiAllBlock();
				doActionIBSheet(sheetObj,frm,'btn_retrieve');
			break;	
			case "btn_downexcel":	// EXCEL DOWNLOAD
				//					sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
			break;
			case "offce_level":    
				
				frm.f_cmd.value = COMMAND04;
				
				var sXml = sheetObj3.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				ofcLevel = EasXmlString(sXml,"ofc_tp_cd");
				rwAuthCd = EasXmlString(sXml,"rw_auth_cd");
				frm.eml_subj_ctnt.value = EasXmlString(sXml,"eml_subj_ctnt"); // Mail Subject
				frm.eml_ctnt.value = EasXmlString(sXml,"eml_ctnt"); // Body of mail
				frm.offce_lvl.value =ofcLevel;
				frm.audr_ofc_cd.value = EasXmlString(sXml,"usr_ofc_cd"); // 로그인 유저 오피스 코드
				frm.kpi_ofc_cd.value = EasXmlString(sXml,"kpi_ofc_cd"); // KPI 오피스 코드
			break;
			case IBDELETE :
				if (sheetObj.id == 'sheet1') {  
					if(sheetObj.FindCheckedRow("chk") != ""){
						ComRowHideDelete(sheetObj,"chk"); 
					}
				}
			break;		
  			case IBINSERT:	  //입력
  				var intV = 0;
  				var bkgNo = frm.bkg_no.value;
  				var eacExpnTpCd =  frm.eac_expn_tp_cd.Code;
  				if( eacExpnTpCd == "TES" || eacExpnTpCd == "TRS" ){
  					if (bkgNo != "") {
  						//* TPB Manual Registration(ESD_TPB_0103) 화면에서 사용로직 가지고옴
  						var resultArr = openBkgContainerPopup(bkgNo);
  						if( resultArr.length > 0 ){
  							var tempArr;
  							for( i=0 ; i<resultArr.length ; i++ ){
  								tempArr = resultArr[i].split('|$|');
  								intV = sheetObj.DataInsert(i);
  								
//  							s_tpb_seq(sheetObj, i+1);
  								sheetObj.CellValue2(intV,'eq_no') = tempArr[0];
  								if(tempArr[0]!=''){
  									sheetObj.CellValue2(intV,'eq_knd_cd') = 'U';
  								}
  								sheetObj.CellValue2(intV,'eq_tpsz_cd') = tempArr[1];
  								
  								if(frm.eac_no.value != "") {
  									sheetObj.CellValue2(intV,"eac_no") = frm.eac_no.value
  								}
  								
  							}
  						}
  					}else{
  						ComShowCodeMessage('COM12138', 'Booking No'); // Booking No 값을 입력하셔야 합니다;
  					}
  				}else{
  					    intV = sheetObj.DataInsert(-1);
						if(frm.eac.value.value != "") sheetObj.CellValue2(intV,"eac_no") = frm.eac_no.value
				}
  				
  			break;			
  			case "btng_tpb_if":
  				
  				/*
  				 * 1. Resp. Office 가 TPB 에 등록된 office 인지 확인한다.
  				 * 2. TPB 인터페이스(I/F) 했던 데이터 인지 확인한다.
  				 * */
      			
				frm.f_cmd.value = COMMAND05; 
	         	var params = FormQueryString(frm);
	         	var sXml = sheetObj3.GetSaveXml("ESD_EAS_0201GS.do", params);
	         	
		        if(EasXmlString(sXml,"ofc_cd")==""){
		        	ComShowCodeMessage('EAS90059'); // Missing TPB Office.\nPlease proceed after registration TPB office.
		        	return;
		        }
	         	
	         	
		        if(EasXmlString(sXml,"n3pty_no")!=""){
		        	ComShowCodeMessage('EAS90060'); // TPB I/F has been already completed.(이미 I/F 하였습니다.)
		        	return;
		        }


	         	
  				if(!validateForm(sheetObj,frm,sAction)) return false;				
  				
  				
  				/**
  				 * 인터페이스전 저장을 해야한다.
  				 **/
  				if(!savechkValidate())return false;	
				frm.f_cmd.value = MULTI01;
	         	
            	var params = sheetObjects[0].GetSaveString(false, true)  + "&" + FormQueryString(frm);
	         	var sXml = sheetObjects[0].GetSaveXml("ESD_EAS_0201GS.do", params);				
//				var eacNo = ComGetEtcData(sXml,"eac_no");
//				frm.eac_no.value = eacNo;
				
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					return false;
				}
				
				
				
				
				
  				/**
  				 * 인터페이스 시작한다.
  				 **/				
				ComOpenWait(true);
				frm.f_cmd.value = MULTI02;
				var sXml = sheetObj3.GetSaveXml("ESD_EAS_0201GS.do", FormQueryString(frm));
  				
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if (State != "S") {
					ComShowCodeMessage('COM12150', 'TPB I/F'); // TPB I/F 등록 을 실패 하였습니다.
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM12149', 'TPB I/F'); // TPB I/F 등록 을 완료 하였습니다.
					authorityUiAllBlock();
				}
				
//				doActionIBSheet(sheetObj,frm,'btn_retrieve');
				
  				break;			
  			case "btn_issue":	  //issue
  				if(!savechkValidate())return false;	
  				if(!window.confirm("Do you want to issue? ")){ // Issued 하시겠습니까?
					return false;
				}
  				
  				
  				/**
  				 * Issued 저장을 해야한다.
  				 **/
  				
				frm.f_cmd.value = MULTI01;
	         		

            	var params = sheetObjects[0].GetSaveString(false, true)  + "&" + FormQueryString(frm);
	         	var sXml = sheetObj3.GetSaveXml("ESD_EAS_0201GS.do", params);				
//				var eacNo = ComGetEtcData(sXml,"eac_no");
//				frm.eac_no.value = eacNo;
				
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					return false;
				}
				
  				if(!validateForm(sheetObj,frm,sAction)) return false;
  				
  				frm.f_cmd.value = MODIFY01;
				var eacAtpCdVal = frm.eac_apro_tp_cd.Code
				if(eacAtpCdVal == 1){
					sheetObjects[2].CellValue2(1,"eac_sts_cd") = "AC"; 
  				}else if(eacAtpCdVal == 2){
  					sheetObjects[2].CellValue2(1,"eac_sts_cd") = "RC";
  				}else if(eacAtpCdVal == 3){
  					sheetObjects[2].CellValue2(1,"eac_sts_cd") = "HC";
  				}
				
				var sParam = sheetObjects[2].GetSaveString(false, true) + "&" + FormQueryString(frm);
  				var sXml = sheetObj3.GetSaveXml("ESD_EAS_0201GS.do", sParam);
  				
  				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
  				if (State != "S") {
  					ComShowCodeMessage('EAS90065'); //issued Fail
  					ComOpenWait(false);
  					return false;
  				} else if (State == "S") {
  					ComShowCodeMessage('EAS90066'); // EAC has been issued
  					authorityUiAllBlock();
//  					doActionIBSheet(sheetObjects[0],frm,'btn_retrieve');
  				}				
  				
  				
  				break;			
  			case "btng_preview":	  //preview
  				
  				if(!validateForm(sheetObj,frm,sAction)) return false;
  				/**
  				 * preview전 저장을 해야한다.
  				 **/
  				if(!savechkValidate())return false;
				frm.f_cmd.value = MULTI01;
	         	
            	var params = sheetObjects[0].GetSaveString(false, true)  + "&" + FormQueryString(frm);
	         	var sXml = sheetObj3.GetSaveXml("ESD_EAS_0201GS.do", params);				
				
				
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					return false;
				}
				
				
  				var eacNo = frm.eac_no.value;
  				var pgmUrl = 'ESD_EAS_0211.do?';
  				var param = "&EAC_NO=" + eacNo+"&EAC_EML_USE_FLG="+sheetObj.CellValue(1,"eac_eml_use_flg")+"&EAC_FAX_USE_FLG="+sheetObj.CellValue(1,"eac_fax_use_flg")+
  						    "&NTC_CC_RCV_EML="+sheetObj.CellValue(1,"ntc_cc_rcv_eml")+"&VNDR_EML="+frm.vndr_eml.value+"&FAX_NO="+frm.fax_no.value;	
  				var src = "&pgmUrl=" + pgmUrl + param;
  				
  				ComOpenPopup(pgmUrl + src, 1024, 700, "", "1,0,1,1,1", true);  
//  				ComPostOpenWindow(pgmUrl + src,  "", "ESD_EAS_0211","width=1024,height=780");  				
  				break;			
		}
	}
	
	
	
	// Combo관련 프로세스 처리
	function doActionIBCombo(comboObj) {
		var sheetObj = sheetObjects[3];
		
		sheetObj.ShowDebugMsg = false;
		switch(comboObj.id) {
			case "eac_expn_tp_cd":    
//				searchCommonCombo("CD00904",frm.eac_expn_tp_cd);
//				searchCommonCombo("CD00904",frm.n3pty_expn_tp_cd);
				searchCommonCombo("CD03352",frm.eac_expn_tp_cd);
				searchCommonCombo("CD03352",frm.n3pty_expn_tp_cd);
			break;  
			case "eac_tp_cd":    
				searchCommonCombo("CD00587",frm.eac_tp_cd);
			break;  
			case "eac_bil_tp_cd":    
				var eacCode = form.eac_tp_cd.Code;
				
				if(eacCode=="I"){
					//Internal Error
					frm.f_cmd.value = SEARCH01;
					frm.code_key.value = "CD03340";
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				}else if(eacCode=="M"){
					//Misbilling
					frm.f_cmd.value = SEARCH01;
					frm.code_key.value = "CD03339";
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				}else if(eacCode=="T"){
					// Missing 3rd Party Billing
					frm.f_cmd.value = SEARCH02;
					var frmStr = "f_cmd="+SEARCH02+"&n3pty_expn_tp_cd="+frm.eac_expn_tp_cd.Code;
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", frmStr);
				}
				// 공통 테이블에서 조회할 키
				
				frm.eac_bil_tp_cd.RemoveAll();
				ComXml2ComboItem(sXml, frm.eac_bil_tp_cd, "code_cd", "code_nm");
				comboObj.Index=0;
			break;  
			case "curr_cd":  
				var eacCode = form.curr_cd.Code;
					frm.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
					frm.curr_cd.RemoveAll();
					ComXml2ComboItem(sXml, frm.curr_cd, "bil_curr_cd", "bil_curr_cd1");
					comboObj.Index=0;
			break;  
			case "eac_rsn_cd":  
				searchCommonCombo("CD03338",frm.eac_rsn_cd)
			break;  
			case "eac_cmpl_cd":  
				searchCommonCombo("CD03342",frm.eac_cmpl_cd)
			break;  
			
			case "vndr_cust_div_cd":  
				searchCommonCombo("CD00583",frm.vndr_cust_div_cd)
			break;
			case "vndr_cntc_pnt_nm":
				
				frm.f_cmd.value = SEARCH08;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
				
				frm.vndr_cntc_pnt_nm.RemoveAll();
				ComXml2ComboItem(sXml, frm.vndr_cntc_pnt_nm, "vndr_cntc_pnt_seq", "vndr_cntc_pnt_nm");
				if(frm.vndr_cntc_pnt_seq.value !=""){
					frm.vndr_cntc_pnt_nm.Code2 = frm.vndr_cntc_pnt_seq.value;
				}else{
					frm.vndr_cntc_pnt_nm.Index2=0
					frm.vndr_cntc_pnt_seq.value = frm.vndr_cntc_pnt_nm.Code;
				}
				
			break;
			case "n3pty_bil_tp_cd":  
					frm.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
					frm.n3pty_bil_tp_cd.RemoveAll();
					ComXml2ComboItem(sXml, frm.n3pty_bil_tp_cd, "code_cd", "code_nm");
					comboObj.Index=0;
				break;
		}
	}		
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,frm,sAction){
		 switch(sAction) {
			 case "btn_retrieve" : break;
			 case "btn_issue" : 
					var usdAmt = parseInt(ComReplaceStr(frm.inv_aud_usd_amt.value,",",""));
  					if(usdAmt >= 2000 && frm.atch_file_id.value !="Y"){
  						ComShowCodeMessage('COM130201', 'Attach'); //2000 불 이상 입력시 Attach 값을 입력하셔야 합니다
  						document.tab1.SelectedIndex = 0;
  						openTabIndex = 0;  	
  						return false;
  					}	  	
				 break;
			 case "btng_tpb_if" : 
	  				var bkgNo = frm.bkg_no.value;
	  				var vndrSeq = frm.vndr_seq.value;
	  				var n3ptySrcNo = frm.n3pty_src_no.value;
	  				var eacExpnTpCd = frm.eac_expn_tp_cd.Code;
	  				var trdPartyVal = frm.trd_party_val.value;
	  				
	  				if( eacExpnTpCd == "EXT"){
  						return true;
	  				}
	  				
	  				if( eacExpnTpCd == "PSO"){
	  					for(var i=1; i<=sheetObjects[0].RowCount; i++){
	  						if(sheetObjects[0].CellValue(i,"eq_knd_cd") !="V"){
	  							ComShowCodeMessage('EAS90067'); // If expense type code is PSO,  vessel code(VVD) should be chosen by you(Expense Type Code 가 PSO 일경우는 Vessel 을 선택하셔야 합니다)
	  							return false;
	  						}
	  						
	  					}
	  				}
	  				
	  				if( eacExpnTpCd != "PSO"){
	  					for(var i=1; i<=sheetObjects[0].RowCount; i++){
	  						if(sheetObjects[0].CellValue(i,"eq_knd_cd") =="V"){
	  							ComShowCodeMessage('EAS90068'); // If expense type code is not PSO, you can't choose vessel code (VVD) Expense Type Code 가 PSO가 아닐경우는 Vessel 을 선택할수 없습니다.
	  							return false;
	  						}
	  						
	  					}
	  				}
	  				
	  				if (vndrSeq == "") {
	  					ComShowCodeMessage('COM130201', 'S/P Code'); // S/P Code 값을 입력하셔야 합니다.
	  					frm.vndr_seq.focus()	
	  					return false;
	  				}
	  				if (n3ptySrcNo == "") {
	  					ComShowCodeMessage('COM130201', 'Invoice No'); // Invoice No 값을 입력하셔야 합니다.
	  					frm.n3pty_src_no.focus()	
	  					return false;
	  				}
	  				
	  				if (trdPartyVal == "") {
	  					ComShowCodeMessage('COM130201', '3RD Party Item'); // 3RD Party 명에 값을 입력하셔야 합니다.
	  					frm.trd_party_val.focus()	
	  					return false;
	  				}
	  				
	  				
	  				
  					var usdAmt = parseInt(ComReplaceStr(frm.inv_aud_usd_amt.value,",",""));
  					if(usdAmt >= 2000 && frm.atch_file_id.value !="Y"){
  						ComShowCodeMessage('COM130201', 'Attach'); //2000 불 이상 입력시 Attach 값을 입력하셔야 합니다
  						document.tab1.SelectedIndex = 0;
  						openTabIndex = 0;
  						return false;
  					}	  				
	  					
	  					  			
	  				
	  				if( eacExpnTpCd == "TES" || eacExpnTpCd == "TRS" ){
	  					if (bkgNo == "") {
	  						ComShowCodeMessage('COM130201', 'Booking No'); // Booking No 값을 입력하셔야 합니다;
	  						return false;
	  					}
	  					if(""== frm.bl_no.value){
	  						ComShowCodeMessage('COM130201', 'B/L No'); // B/L No 값을 입력하셔야 합니다;
	  						return false;
	  					}
	  				}
	  				
	  				if(sheetObj.RowCount<1){
	  					ComShowCodeMessage('COM130201', 'Grid'); // Grid에 값을 입력하셔야 합니다;
	  					return false;
	  				}
	  				
	  				if(""== frm.trd_party_val.value){
	  					ComShowCodeMessage('EAS90069');// Please interface after input 3RD Party Item.
	  					return false;
	  				}
	  				
					frm.f_cmd.value = SEARCH15;
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
					
					var eacExpnTpCd =  frm.eac_expn_tp_cd.Code;
					var n3ptyNo = EasXmlString(sXml,"n3pty_no").split("|");
					var cnt     = EasXmlString(sXml,"cnt").split("|");
					
	  				if( eacExpnTpCd == "TES" || eacExpnTpCd == "TRS" ){
	  					if(cnt[0] != 0){ // 중복된 데이터가 있다면
	  						if(ComShowCodeConfirm("EAS90070",n3ptyNo[0])){// Same S/P Code and Invoice number \nalready exist on 3rd Party Billing
	  							return true;
	  						}else {
	  							return false;
	  						}  					
	  					}else{
		  					// Do you want to progress TPB I/F? TPB I/F 를 실행 하시겠습니까?
	  		  				if(!ComShowCodeConfirm("EAS90071")) return false;
	  					}
	  				}else{
	  					if(cnt[1] != 0){ // 중복된 데이터가 있다면
	  						if(ComShowCodeConfirm("EAS90070",n3ptyNo[1])){// Same S/P Code and Invoice number \nalready exist on 3rd Party Billing
	  							return true;
	  						}else {
	  							return false;
	  						}  					
	  					}else{
		  					// Do you want to progress TPB I/F? TPB I/F 를 실행 하시겠습니까?
	  		  				if(!ComShowCodeConfirm("EAS90071")) return false;
	  					}
	  					
	  				}
	  				return true;
				 break;
			 case IBSAVE : 				 
				 
					var vndrSeq      = frm.vndr_seq.value;
					// 저장이 여러 곳에 발생하여 공통처리를 위해 메소드로 정의함
					if(!savechkValidate())return false;	
	  				if(rwAuthCd != 'R' ){
	  					frm.f_cmd.value = SEARCH09;
	  					var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	  					var saveFlag = EasXmlString(sXml,"cnt");
	  					var saveFlagEacNo = EasXmlString(sXml,"eac_no");
	  					if(saveFlag>0){
	  						if(ComShowCodeConfirm("EAS90070",saveFlagEacNo)){ // is the duplicate data. Do you want to save? 는 중복된 데이터 입니다. 저장 하시겠습니까?
	  							return true;
	  						}else {
	  							return false;
	  						}
	  					}else if (!ComShowCodeConfirm("EAS90099", "EAC Transfer")){// Do you want to EAC Transfer?
	  						return false; 
	  					}
	  				}else{
	  					return false;
	  				}
			 break;
		 } // end switch()
	 return true;
	}
	

	function savechkValidate(){
		   var sheetObj     = sheetObjects[0];
			var bkgNo        = frm.bkg_no.value;
			var vndrSeq      = frm.vndr_seq.value;
			var n3ptySrcNo   = frm.n3pty_src_no.value;
			var eacExpnTpCd  = frm.eac_expn_tp_cd.Code;
			var trdPartyVal  = frm.trd_party_val.value;	
			var eacTpCd      = frm.eac_tp_cd.Code;
			

			if (frm.eac_bil_tp_cd.Code == "") {
				ComShowCodeMessage('COM130201', 'EAC Type'); // EAC Type 값을 입력하셔야 합니다
				frm.eac_bil_tp_cd.focus()	
				return false;
			}
			if (vndrSeq == "") {
				ComShowCodeMessage('COM130201', 'S/P Code'); // S/P Code 값을 입력하셔야 합니다
				frm.vndr_seq.focus()	
				return false;
			}
			
			if (n3ptySrcNo == "") {
				ComShowCodeMessage('COM130201', 'Invoice No'); //Invoice No 값을 입력하셔야 합니다
				frm.n3pty_src_no.focus()	
				return false;
			}
			
			
			if (frm.respb_ofc_cd.value == "") {
				ComShowCodeMessage('COM130201', 'Resp. Office'); // Resp. Office 값을 입력하셔야 합니다
				frm.respb_ofc_cd.focus()	
				return false;
			}
			

			// vvd 필수 제어
			if( eacExpnTpCd == "PSO"){
				if (frm.vvd_cd_ctnt.value == "") {
					ComShowCodeMessage('COM130201', 'VVD'); // VVD 값을 입력하셔야 합니다
					frm.vvd_cd_ctnt.focus()	
					return false;
				}
			}
			
			//  Work Order No 필수 제어
			if( eacExpnTpCd == "TRS"){
				if (frm.wo_no_ctnt.value == "") {
					ComShowCodeMessage('COM130201', 'Work order No'); //  Work Order No 값을 입력하셔야 합니다
					frm.wo_no_ctnt.focus()	
					return false;
				}
			}
			
			
			//  Audit Month 필수 제어
			if (frm.eac_yrmon.value == "") {
				ComShowCodeMessage('COM130201', 'Audit Month'); // Audit Month 값을 입력하셔야 합니다
				document.tab1.SelectedIndex = 0;
				frm.eac_yrmon.focus();
				return false;
			}
			
			//  Action Type 필수 제어
			if (frm.eac_rsn_cd.Code == "") {
				ComShowCodeMessage('COM130201', 'Action Type'); // Action Type 값을 입력하셔야 합니다
				document.tab1.SelectedIndex = 0;
				frm.eac_rsn_cd.focus();
				return false;
			}
			
			//  Audit Detail (Reason) 필수 제어
			if (frm.eac_desc.value == "") {
				ComShowCodeMessage('COM130201', 'Audit Detail (Reason)'); // Audit Detail (Reason) 값을 입력하셔야 합니다
				document.tab1.SelectedIndex = 0;
				frm.eac_desc.focus()	;
				return false;
			}
			
			//  Action taken 필수 제어
			if (frm.eac_rsn_desc.value == "") {
				ComShowCodeMessage('COM130201', 'Action taken'); // Action taken 값을 입력하셔야 합니다
				document.tab1.SelectedIndex = 0;
				frm.eac_rsn_desc.focus();
				return false;
			}
		
			
			
			if (frm.inv_aud_amt.value == "") {
				ComShowCodeMessage('COM130201', 'Audit Amount '); // Audit Amount 값을 입력하셔야 합니다
				frm.inv_aud_amt.focus()	
				return false;
			}
			

			
			if (frm.inv_aud_usd_amt.value == "") {
				ComShowCodeMessage('COM130201', 'USD Amount'); //USD Amount 값을 입력하셔야 합니다
				frm.inv_aud_usd_amt.focus();
				return false;
			}
			
			// EAC Type 이 Missing 3rd Party Billing 일경우
			if(eacTpCd == "T"){
				if( eacExpnTpCd == "TES" || eacExpnTpCd == "TRS" ){
					if (bkgNo == "") {
						ComShowCodeMessage('COM130201', 'Booking No'); //Booking No 값을 입력하셔야 합니다
						document.tab1.SelectedIndex = 2;
						openTabIndex = 2;
						frm.bkg_no.focus();	  						
						return false;
					}
					if(frm.bl_no.value==""){
						ComShowCodeMessage('COM130201', 'B/L No'); //B/L No 값을 입력하셔야 합니다
						frm.bl_no.focus()
						document.tab1.SelectedIndex = 2;
						openTabIndex = 2;
						frm.bl_no.focus()	;			 
						return false;
					}
					
				}
				if(sheetObj.RowCount<1){
					ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
					document.tab1.SelectedIndex = 2;
					openTabIndex = 2;
					return false;
				}				
			}

			//장비를 입력 할 경우엔 EQ Kind, EQ No. or VVD, TPB Amount를 모두 입력하여야 한다.
			if(sheetObj.RowCount>0){
				for(var i=0; i<=sheetObj.RowCount; i++){
					if(sheetObj.CellValue(i,"eq_knd_cd") ==""){
						document.tab1.SelectedIndex = 2;
						ComShowCodeMessage('COM130201', 'EQ Kind');
						return false;
					}else if(sheetObj.CellValue(i,"eq_no") ==""){
						document.tab1.SelectedIndex = 2;
						ComShowCodeMessage('COM130201', 'EQ No. or VVD');
						return false;
					}else if(sheetObj.CellValue(i,"diff_inv_amt") ==""){	
						document.tab1.SelectedIndex = 2;
						ComShowCodeMessage('COM130201', 'TPB Amount');
						return false;
					}
				}
			}

			return true;
	}	
	
	// 공통테이블에 등록된 코드값을 조회 한다.    
	function searchCommonCombo(codeKey,comboObj){
		var sheetObj = sheetObjects[3];
			frm.f_cmd.value = SEARCH01;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = codeKey
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
			ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
	}

	function eac_tp_cd_OnChange(comboObj,Index_Code, Text){   
		doActionIBCombo(frm.eac_bil_tp_cd); // EAC Type
		
	}	
	
	function eac_expn_tp_cd_OnChange(comboObj,Index_Code, Text){   
		if(form.eac_tp_cd.Code=="T"){
			doActionIBCombo(frm.eac_bil_tp_cd); // EAC Type2
		}
		
		// vvd 필수 제어
		if(frm.eac_expn_tp_cd.Code=="PSO"){
			frm.vvd_cd_ctnt.className = "input1"
		}else{
			frm.vvd_cd_ctnt.className = "input"
		}
		
		// Work Order No 필수 제어
		if(frm.eac_expn_tp_cd.Code=="TRS"){
			frm.wo_no_ctnt.className = "input1"
		}else{
			frm.wo_no_ctnt.className = "input"
		}
		
		if(frm.eac_expn_tp_cd.Code == "ACM"){
			frm.n3pty_expn_tp_cd.Code = "EXT";
		}else{
			frm.n3pty_expn_tp_cd.Code = frm.eac_expn_tp_cd.Code;
		}
		doActionIBCombo(frm.n3pty_bil_tp_cd); // TPB Code
		
		if(frm.eac_expn_tp_cd.Code=="TRS" || frm.eac_expn_tp_cd.Code=="TES"){
			frm.bkg_no.className = "input1"
		}else{
			frm.bkg_no.className = "input"
		}

	}

	function n3pty_expn_tp_cd_OnChange(comboObj,Index_Code, Text){   
		if(rwAuthCd != 'R' && frm.n3pty_expn_tp_cd.Code=="EXT"){
			ComBtnDisable("btng_tpb_if");//TPB I/F 비활성화
		}else{
			ComBtnEnable("btng_tpb_if"); //TPB I/F 활성화
		}
		
	}
	
	function eac_bil_tp_cd_OnChange(comboObj,Index_Code, Text){   
		if(form.eac_tp_cd.Code=="T"){
			frm.n3pty_bil_tp_cd.Code = Index_Code;
		}
	}
	
	function vndr_cust_div_cd_OnChange(comboObj,Index_Code, Text){   

		frm.tpb_vndr_cnt_cd.value   = "";
		frm.tpb_vndr_seq.value      = "";
		frm.cust_cnt_cd.value       = "";
		frm.cust_seq.value          = "";
		frm.n3pty_ofc_cd.value      = "";
		frm.trd_party_val.value     = "";
		frm.trd_party_nm.value      = "";
		
		//tpb i/f 여부 체크에 사용될 변수 초기화
		frm.s_vndr_cust_div_cd.value  = frm.vndr_cust_div_cd.Code; 
		frm.s_trd_party_val.value      = "";
		
	}		
	
	/*
	* rep_commodity팝업호출
	*/
	function rep_OnPopupClick() {
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1',true);
	}	  
	/*
	* Location 팝업호출
	*/
	function location_OnPopupClick() {
		var param = "";
			ComOpenPopup('/hanjin/COM_ENS_051.do'+ param, 770, 410, 'getLocation', '1,0,1,1,1',true);
	}	  
	
	/**
	* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	*/
	function getCOM_ENS_rep(rowArray) {
		for(var i=0; i<rowArray.length; i++) 
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			frm.s_vndr_seq.value =colArray2;
			frm.vndr_seq.value =colArray2;
			frm.vndr_nm.value =colArray4;
		}
		vender_change();
	}	  
	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function vender_change(){
		// s/p 코드값이 변경되면 기존 저장값을 초기화 해야한다.
		frm.vndr_cntc_pnt_seq.value = "";
		if(frm.vndr_seq.value =="" ){
			frm.vndr_seq.value="";
			frm.vndr_nm.value="";
			
			frm.ntc_his_seq.value="";     // No. of notice
			frm.vndr_lgl_eng_nm.value=""; // S/P Name
			frm.eng_addr.value="";        // Address
			frm.zip_cd.value="";          // ZIP Code
			frm.vndr_eml.value="";        // E-mail
			frm.phn_no.value="";         // Phone
			frm.fax_no.value="";          // FAX
			frm.vndr_cntc_pnt_nm.RemoveAll();
//			doActionIBCombo(frm.vndr_cntc_pnt_nm); // Contact Point
			return;
		}else {
			frm.s_vndr_seq.value = frm.vndr_seq.value
			frm.f_cmd.value = SEARCH05;
			var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
			var vndrNm = EasXmlString(sXml,"vndr_nm");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.vndr_seq.value="";
				frm.vndr_nm.value="";
				
				frm.ntc_his_seq.value="";     // No. of notice
				frm.vndr_lgl_eng_nm.value=""; // S/P Name
				frm.eng_addr.value="";        // Address
				frm.zip_cd.value="";          // ZIP Code
				frm.vndr_eml.value="";        // E-mail
				frm.phn_no.value="";         // Phone
				frm.fax_no.value="";          // FAX
	//			doActionIBCombo(frm.vndr_cntc_pnt_nm); // Contact Point
				frm.vndr_cntc_pnt_nm.RemoveAll();
				return;
			}else{
				frm.vndr_nm.value = vndrNm;
				rejection_Notice_Search();
			}
		}
	
	}
	
	/**
	* Location 팝업호출 : 팝업에서 단일 선택을 한경우..
	*/
	function getLocation(rowArray) {
		for(var i=0; i<rowArray.length; i++){
			var colArray = rowArray[0];
			frm.yd_cd.value =colArray[3];
		}
	}	  
	   
	
	/**
	* Resp. Office 에 값이 존재하는지 체크 한다.
	*/
	function  responsible_office_change(){
	   var respbOfcCd = frm.respb_ofc_cd.value;
	   if(respbOfcCd ==""){
		   return;
	   }
	   frm.f_cmd.value = SEARCH07;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   var isflag = EasXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Resp. Office'); //사용할수 없는 Resp. Office 
		   frm.respb_ofc_cd.value="";
	   }
	}	  
	
	
	/**
	* Location 에 값이 존재하는지 체크 한다.
	*/
	function yd_cd_change(){
	   var lvobj = frm.yd_cd.value;
	   if(lvobj ==""){
	   return;
	   }
	   frm.f_cmd.value = SEARCH06;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   var isflag = EasXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Location'); //사용할수 없는 Location 
		   frm.yd_cd.value="";
	   }
	   
	}	  
	   
	/**
	* curr_cd 값이 변경되면 USD Amount 값을 재설정한다.
	*/
	function  curr_cd_OnChange(){
	   exchange_Rate();
	}	
	
	/**
	* curr_cd, n3pty_src_dt 값이 변경되면 환율 값을 재 조회 한다.
	*/
	function exchange_Rate(){
	    var invoiceDate = frm.n3pty_src_dt.value;
	    var currency = frm.curr_cd.value;
	    	frm.f_cmd.value = SEARCH04;
	
	    var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	        usdRt = EasXmlString(sXml,"usd_locl_xch_rt");
	        if(ComGetTotalRows(sXml)==0){
	        	usdRt = 0;
	        }else{
	        	usdRt = EasXmlString(sXml,"usd_locl_xch_rt");
	        }
		    if(frm.inv_aud_amt.value!=null||frm.inv_aud_amt.value!=""){
		    	usd_Amount();
		    }
	}
	
	/**
	* USD Amount 를 계산한다.
	*/
	function usd_Amount(){
	    var invAudAmt = ComReplaceStr(frm.inv_aud_amt.value,",","");  // Audit Amount
	
		if(invAudAmt == null || invAudAmt == "" || invAudAmt == "0"){
			frm.inv_aud_usd_amt.value="";
			frm.stl_amt.value = "";
		    return;
		}
		if(usdRt == 0){
			frm.inv_aud_usd_amt.value=0;
		}else{
			frm.inv_aud_usd_amt.value=round(invAudAmt/usdRt,2);
			foramtComma(frm.inv_aud_usd_amt);
		}
		frm.stl_amt.value = frm.inv_aud_usd_amt.value;
	}
	
	function round(num,ja) { 

	    ja=Math.pow(10,ja) 

	    return Math.round(num * ja) / ja; 

	} 
	
	/**
	* Inv.Amount 변경시 Audit Amount 를 계산한다.
	*/
	function inv_Change(){
		var invAmtVal = frm.inv_amt.value;  // Inv.Amount 
		var invCngAmtVal = frm.inv_cng_amt.value; // Should be Amount
		var invAudAmt = frm.inv_aud_amt.value; // USD Amount
		if(invAmtVal==null||invAmtVal==""||invAmtVal == 0){
		   invAmtVal = 0;
		}
		if(invCngAmtVal==null||invCngAmtVal==""||invCngAmtVal == 0){
		   invCngAmtVal = 0;
		}
		invAudAmt = parseFloat(ComReplaceStr(invAmtVal,",","")) - parseFloat(ComReplaceStr(invCngAmtVal,",",""));
		if(invAudAmt<0){
			   invAudAmt = invAudAmt*-1
		}
		frm.inv_aud_amt.value = invAudAmt;
	   foramtComma(frm.inv_aud_amt)
	   inv_aud_amt_Change();
	}
	
	/**
	* Audit Amount 변경시 USD Amount 를 계산한다.
	*/
	function inv_aud_amt_Change(){
	   usd_Amount();
	}
	
	
	//   TPB I/F 텝 메소드
	/**
	* vndr_cust_div_cd 값에 따라 3rd Party를 조회하는 함수
	*
	* @param : val - vndr_cust_div_cd
	*/
	function open3rdParty(val) {
		var strTrd_party = val;
		
		if(strTrd_party=='C') { // Customer
			ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 420, 'openCustomer', '1,0,1,1,1',true);
		} else if(strTrd_party=='S') { // Staff
			openPopup3rdParty(val);
		} else if(strTrd_party=='V') { // Vendor
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 410, 'openVendor', '1,0,1,1,1',true);
		} 
		
	}
	
	
	/**
	* 3rd Party Staff 팝업창을 여는 함수
	*/
	function openPopup3rdParty(val) {
		var theURL = "ESD_TPB_0813.do?title=Select Staff";
		var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:510px";
		var rtnValue = window.showModalDialog(theURL, window, features);
			frm.s_trd_party_val.value = rtnValue;
			frm.trd_party_val.value = rtnValue;
			frm.trd_party_nm.value = rtnValue;
			frm.n3pty_ofc_cd.value = rtnValue;
			
			frm.cust_cnt_cd.value = "";
			frm.cust_seq.value = "";
			frm.tpb_vndr_cnt_cd.value = "";
			frm.tpb_vndr_seq.value = "";
			tpb3rdPartyChk();
			
		
	}
	
	/**
	* 3rd Party Customer popup close시 호출되는 함수
	*/
	function openCustomer(rArray) {
		var cArray = rArray[0];
		
		var parVal = cArray[3]
		var parNm = cArray[4]
			frm.s_trd_party_val.value = parVal;
			frm.trd_party_val.value = parVal;
			frm.trd_party_nm.value = parNm;
			frm.cust_cnt_cd.value = parVal.substring(0,2)
			frm.cust_seq.value = parVal.substring(2,8)
			
			frm.n3pty_ofc_cd.value = "";
			frm.tpb_vndr_cnt_cd.value = "";
			frm.tpb_vndr_seq.value = "";
			tpb3rdPartyChk();
	}   
	
	
	/**
	* 3rd Party Vendor popup close시 호출되는 함수
	*
	*/
	function openVendor(rArray) {
		var cArray = rArray[0];
		
		var parVal = cArray[7]+cArray[2];
		var parNm = cArray[4];
	    	frm.s_trd_party_val.value = cArray[2];
			frm.trd_party_val.value = cArray[2];
			frm.trd_party_nm.value = cArray[4];
				
			frm.tpb_vndr_cnt_cd.value = cArray[7] // 국가코드
			frm.tpb_vndr_seq.value = cArray[2]    // 국가코드 SEQ
			
			frm.n3pty_ofc_cd.value = "";
			frm.cust_cnt_cd.value = "";
			frm.cust_seq.value = "";
			tpb3rdPartyChk();
	}	   
	
	
	//   TPB I/F 텝 메소드
	/**
	* TPB No.값으로 팝업을 호출
	*
	* @param : val - vndr_cust_div_cd
	*/
	function open3rdPtyNo(val) {
		ComOpenPopup("/hanjin/ESD_TPB_0115.do?pgmNo=ESD_TPB_0115&s_direct_tpb_no="+val, 1024, 600, 'callBack3rdPtyNo', '1,0,1,1,1,1,1,1,1,1,1,1');
		
	}
	
	function callBack3rdPtyNo(){
		
	}
	
	
	/**
	* Sheet2 의 OnSearchEnd 이벤트처리 <br>
	* @param  {object} sheetObj	필수	 Sheet Object
	* @param  {string} ErrMsg		필수 String
	* @return 없음
	* @version 2014.11.18
	*/ 
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		frm.vndr_lgl_eng_nm.value = sheetObj.CellValue(1, 'vndr_lgl_eng_nm');
		frm.eng_addr.value        = sheetObj.CellValue(1, 'eng_addr');
		frm.zip_cd.value          = sheetObj.CellValue(1, 'zip_cd');
		frm.vndr_eml.value        = sheetObj.CellValue(1, 'vndr_eml');
		frm.phn_no.value          = sheetObj.CellValue(1, 'phn_no');
		frm.fax_no.value          = sheetObj.CellValue(1, 'fax_no');
	}
	
	function vndr_cntc_pnt_nm_OnChange(comboObj,Index_Code, Text){
		frm.vndr_cntc_pnt_seq.value = frm.vndr_cntc_pnt_nm.Code
		doActionIBSheet(sheetObjects[1],document.form,"IBSEARCH02");
	}				

	
	/**
	* BKG_NO 가 존재하는지 확인하고 존재하는 BKG_NO 이면 BL_NO 를 조회한다.
	*/
	function  bkg_no_change(){
	
		if(frm.bkg_no.value =="" ){
			return;
		}
			frm.f_cmd.value = SEARCH14;
		var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
		var blNo = EasXmlString(sXml,"bl_no");
		if(blNo==0){
			
			ComShowCodeMessage('COM132202', 'Booking No'); //사용할수 없는 Booking No
			frm.bkg_no.value="";
			frm.bl_no.value="";
				return;
		}
		frm.bl_no.value = blNo;
	}	  	
	
	//* TPB Manual Registration(ESD_TPB_0103) 화면에서 사용로직 가지고옴
    function openBkgContainerPopup(s_bkg_no){
    	var theURL = "ESD_TPB_0811.do";
    	theURL += "?s_bkg_no=" + s_bkg_no;
    	var features = "scroll:no;status:no;help:no;dialogWidth:340px;dialogHeight:350px";
    	var rtnValue = window.showModalDialog(theURL, window, features);

   	return rtnValue;
    }	
    
	/**
	* Sheet3 의 OnSearchEnd 이벤트처리 <br>
	* @param  {object} sheetObj	필수	 Sheet Object
	* @param  {string} ErrMsg		필수 String
	* @return 없음
	* @version 2014.11.18
	*/ 
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		frm.eac_no.value            = sheetObj.CellValue(1,"eac_no"           );
		frm.eac_inp_dt.value        = sheetObj.CellValue(1,"eac_inp_dt"       );
//		frm.eac_reg_usr_nm.value    = sheetObj.CellValue(1,"audr_usr_id"      );
		frm.eac_reg_usr_nm.value    = sheetObj.CellValue(1,"eac_reg_usr_nm"   );
		frm.audr_ofc_cd.value       = sheetObj.CellValue(1,"audr_ofc_cd"      );
		frm.eac_apro_tp_cd.Code     = sheetObj.CellValue(1,"eac_apro_tp_cd"   );
		frm.eac_sts_nm.value        = sheetObj.CellValue(1,"eac_sts_nm"       );
		frm.eac_sts_cd.value        = sheetObj.CellValue(1,"eac_sts_cd"       );
		frm.kpi_ofc_cd.value        = sheetObj.CellValue(1,"kpi_ofc_cd"       );
		
		if(frm.eac_sts_cd.value != 'IS'){
			frm.eac_apro_tp_cd.Enable    = false;  // Type
		}
		
		frm.eac_expn_tp_cd.Code     = sheetObj.CellValue(1,"eac_expn_tp_cd"   );
		frm.eac_tp_cd.Code          = sheetObj.CellValue(1,"eac_tp_cd"        );
		frm.eac_bil_tp_cd.Code      = sheetObj.CellValue(1,"eac_bil_tp_cd"    );
		
		frm.eac_cost_desc.value     = sheetObj.CellValue(1,"eac_cost_desc"    );
		frm.respb_ofc_cd.value      = sheetObj.CellValue(1,"respb_ofc_cd"     );
		frm.vndr_seq.value          = sheetObj.CellValue(1,"vndr_seq"         );
		frm.vndr_nm.value           = sheetObj.CellValue(1,"vndr_nm"         );
		frm.n3pty_src_no.value      = sheetObj.CellValue(1,"n3pty_src_no"     );
		frm.n3pty_src_dt.value      = sheetObj.CellValue(1,"n3pty_src_dt"     );
		frm.yd_cd.value             = sheetObj.CellValue(1,"yd_cd"            );
		frm.vvd_cd_ctnt.value       = sheetObj.CellValue(1,"vvd_cd_ctnt"      );
		frm.curr_cd.value            = sheetObj.CellValue(1,"curr_cd"          );
		frm.inv_amt.value           = sheetObj.CellValue(1,"inv_amt"          );
		frm.inv_cng_amt.value       = sheetObj.CellValue(1,"inv_cng_amt"      );
		frm.inv_aud_amt.value       = sheetObj.CellValue(1,"inv_aud_amt"      );
		frm.inv_aud_usd_amt.value   = sheetObj.CellValue(1,"inv_aud_usd_amt"  );
		
		frm.stl_amt.value           = sheetObj.CellValue(1,"stl_amt"          );
		frm.expn_evid_desc.value    = sheetObj.CellValue(1,"expn_evid_desc"   );
		frm.eac_yrmon.value         = sheetObj.CellValue(1,"eac_yrmon"        );
		frm.eac_rsn_cd.Code         = sheetObj.CellValue(1,"eac_rsn_cd"       );
		frm.eac_desc.value          = sheetObj.CellValue(1,"eac_desc"         );
		frm.eac_rjct_desc.value     = sheetObj.CellValue(1,"eac_desc"         );
		frm.eac_inter_rmk.value     = sheetObj.CellValue(1,"eac_inter_rmk"    );
		frm.eac_rsn_desc.value      = sheetObj.CellValue(1,"eac_rsn_desc"     );
		frm.eac_rjct_ofc_cd.value   = sheetObj.CellValue(1,"eac_rjct_ofc_cd"  );
		
		frm.atch_file_id.value      = sheetObj.CellValue(1,"fileflag"  );
		
		// 삭제상태가 아니면 언제나 활성 화 되어야 한다. 
		if(frm.eac_sts_cd.value == "SC"){
			ComBtnDisable("btng_preview"); // Rejection Notice 비활성화
		}else{
			ComBtnEnable("btng_preview"); // Rejection Notice 활성화
		}
		
		
		// 리젝메일을 발송한적이 없다면 비활성화
		if(sheetObj.CellValue(1,"isflag")!=""){
			ComBtnEnable("btng_history"); // 활성화
		}else{
			ComBtnDisable("btng_history"); // 비활성화
		}
		
		
		frm.eac_rjct_usr_nm.value   = sheetObj.CellValue(1,"eac_rjct_usr_nm"  );
		frm.eac_rjct_rsn.value      = sheetObj.CellValue(1,"eac_rjct_rsn"     );
		
		
		
		frm.eac_cmpl_cd.Code        = sheetObj.CellValue(1,"eac_cmpl_cd"      );
		frm.ntc_his_seq.value       = sheetObj.CellValue(1,"ntc_his_seq"      );
		frm.vndr_cntc_pnt_seq.value = sheetObj.CellValue(1,"vndr_cntc_pnt_seq");
//		frm.vndr_cntc_pnt_nm.Code   = sheetObj.CellValue(1,"vndr_cntc_pnt_seq");
		frm.eml_subj_ctnt.value     = sheetObj.CellValue(1,"eml_subj_ctnt"    );
		frm.eml_ctnt.value          = sheetObj.CellValue(1,"eml_ctnt"         );
//		frm.eml_snd_dt.value        = sheetObj.CellValue(1,"eml_snd_dt"       );
		frm.eac_sys_div_cd.value     = sheetObj.CellValue(1,"eac_sys_if_cd"    );		// Sheet3 의 Column "eac_sys_if_cd" 을 "eac_sys_div_cd" 로 변경 하는 게 필요함 . VO, Query 포함 ( form.eac_sys_div_cd 와 혼동 할수 있을 )
		frm.wo_no_ctnt.value        = sheetObj.CellValue(1,"wo_no_ctnt"       );

		frm.n3pty_expn_tp_cd.Code   = sheetObj.CellValue(1,"n3pty_expn_tp_cd" );
		frm.n3pty_bil_tp_cd.Code    = sheetObj.CellValue(1,"n3pty_bil_tp_cd"  );
		frm.bkg_no.value            = sheetObj.CellValue(1,"bkg_no"           );
		frm.bl_no.value             = sheetObj.CellValue(1,"bl_no"            );
		
		frm.vndr_cust_div_cd.Code   = sheetObj.CellValue(1,"vndr_cust_div_cd" );
		frm.tpb_vndr_cnt_cd.value   = sheetObj.CellValue(1,"tpb_vndr_cnt_cd"  );
		frm.tpb_vndr_seq.value      = sheetObj.CellValue(1,"tpb_vndr_seq"     );
		frm.cust_cnt_cd.value       = sheetObj.CellValue(1,"cust_cnt_cd"      );
		frm.cust_seq.value          = sheetObj.CellValue(1,"cust_seq"         );
		frm.n3pty_ofc_cd.value      = sheetObj.CellValue(1,"n3pty_ofc_cd"     );
		
		if(sheetObj.CellValue(1,"vndr_cust_div_cd" ) =="V"){ // S/P
			//tpb i/f 여부 체크에 사용될 변수저장
			frm.s_vndr_cust_div_cd.value = "V"
			frm.s_trd_party_val.value = sheetObj.CellValue(1,"tpb_vndr_seq")
			
			frm.trd_party_val.value     = sheetObj.CellValue(1,"tpb_vndr_seq");
			frm.trd_party_nm.value      = sheetObj.CellValue(1,"tpb_vndr_nm"      );
			
		}else if(sheetObj.CellValue(1,"vndr_cust_div_cd" ) =="S"){ // STAFF
			//tpb i/f 여부 체크에 사용될 변수저장
			frm.s_vndr_cust_div_cd.value = "S"
			frm.s_trd_party_val.value = sheetObj.CellValue(1,"n3pty_ofc_cd")			
			
			frm.trd_party_val.value     = sheetObj.CellValue(1,"n3pty_ofc_cd"     );
			frm.trd_party_nm.value      = sheetObj.CellValue(1,"ofc_eng_nm"     );
			
		}else if(sheetObj.CellValue(1,"vndr_cust_div_cd" ) =="C"){//CUSTOMER
			//tpb i/f 여부 체크에 사용될 변수저장
			frm.s_vndr_cust_div_cd.value = "C"
			frm.s_trd_party_val.value = sheetObj.CellValue(1,"cust_cnt_cd")			
			
			frm.trd_party_val.value     = sheetObj.CellValue(1,"cust_cnt_cd"      )+sheetObj.CellValue(1,"cust_seq");
			frm.trd_party_nm.value      = sheetObj.CellValue(1,"cust_lgl_eng_nm");
		}
		
		frm.n3pty_no.value           = sheetObj.CellValue(1,"n3pty_no"         );
		frm.tpb_ofc_cd.value         = sheetObj.CellValue(1,"tpb_ofc_cd"       );
		frm.ots_sts_nm.value         = sheetObj.CellValue(1,"ots_sts_nm"       );
		
		frm.tpb_inv_amt.value        = sheetObj.CellValue(1,"tpb_inv_amt"      );
		
		// 금액 자릿수 설정
		foramtComma(frm.inv_amt);
		foramtComma(frm.inv_cng_amt);
		foramtComma(frm.inv_aud_amt);
		foramtComma(frm.inv_aud_usd_amt);
		foramtComma(frm.tpb_inv_amt);
		foramtComma(frm.stl_amt);
		
		
		rejection_Notice_Search();
		

		authorityUiAllBlock();
		// 저장상테에서만 이슈가 되어야한다. 
		if(frm.eac_sts_cd.value == "IS"){
			ComBtnEnable("btn_issue"); // 활성화
		}else{
			ComBtnDisable("btn_issue"); // 비활성화
		}
	}
	//권한에 따른 화면 제어(입력수정 안되게)
	function authorityUiControlBlock(){
		var inputArr = document.getElementsByTagName("input");
		var textareaArr = document.getElementsByTagName("textarea");
		var imgArr = document.getElementsByTagName("img");
		
		var i=0;
		for(i=0;i<inputArr.length ; i++){
//			inputArr[i].disabled = "disabled";
			inputArr[i].readOnly = true;
			inputArr[i].className = "input2";
			//inputArr[i].disabled = ""; //비활성화 해제
		}				

		for(i=0;i<textareaArr.length ; i++){
				textareaArr[i].readOnly = true;
				textareaArr[i].className = "textarea2";
		}
		for(i=0;i<imgArr.length ; i++){
			imgArr[i].style.display = "none";
		}
		frm.btn_n3pty_no.style.display = "";
		
		//콤보박스 비활성화
		frm.eac_apro_tp_cd.Enable    = false;  // Type
		frm.eac_expn_tp_cd.Enable    = false;  // Expense Type
		frm.eac_tp_cd.Enable         = false;  // EAC Type
		frm.eac_bil_tp_cd.Enable     = false;   // EAC Type Detail
		frm.eac_rsn_cd.Enable        = false;  // Action Type
		
		var stsVal = frm.eac_sts_cd.value;

		// Issue 이후 Completion은 활성화 되지만 Save버튼이 비 활성화 되어 있어 저장을 할 수 없음.
		if(stsVal != "SC"){
			frm.eac_cmpl_cd.Enable       = true;      // Completion
			ComBtnEnable("btn_save");                 // Save
			
			frm.eml_subj_ctnt.className = "textarea"; // Mail Subject
			frm.eml_ctnt.className = "textarea";      // Body of mail
			frm.eac_rsn_desc.className = "textarea1";  // Action taken
			frm.stl_amt.className = "input";          // Settled Amount(US$)
			frm.eac_desc.className = "textarea1";         // Audit Detail (Reason)
			frm.eac_rsn_cd.Enable = true;             // Action Type
			

			frm.eml_subj_ctnt.readOnly = false; // Mail Subject
			frm.eml_ctnt.readOnly = false;      // Body of mail			
			frm.eac_rsn_desc.readOnly = false;  // Action taken			
			frm.stl_amt.readOnly = false;       // Settled Amount(US$)		
			frm.eac_desc.readOnly = false;      // Audit Detail (Reason)		
		}
		
//		if(stsVal == "SC" || stsVal == "HR" || stsVal == "RR" ){
//			frm.eac_cmpl_cd.Enable       = false; // Completion
//			ComBtnDisable("btn_save"); // Save
//		}else{
//			ComBtnEnable("btn_save"); // Save
//		}		
		

		
		frm.vndr_cntc_pnt_nm.Enable  = false; // Contact Point
		frm.n3pty_expn_tp_cd.Enable  = false; // TPB Exp.Type
		frm.n3pty_bil_tp_cd.Enable   = false; // TPB Code
		frm.vndr_cust_div_cd.Enable  = false; // 3RD Party
		
		// 버튼 비활성화
		ComBtnDisable("btn_save"); // Save
//		ComBtnDisable("btn_delete"); // Delete
		ComBtnDisable("btn_issue"); // Issue
//		ComBtnDisable("btn_print"); // print
//		ComBtnDisable("btng_RowAdd"); // Row Add
//		ComBtnDisable("btng_RowDel"); // Row Delete
//		ComBtnDisable("btng_tpb_if"); // TPB I/F
		sheetObjects[0].Editable = false;
		
	}	

	
	//입력수정 안되게 설정
	function authorityUiAllBlock(){
		var inputArr = document.getElementsByTagName("input");
		var textareaArr = document.getElementsByTagName("textarea");
		var imgArr = document.getElementsByTagName("img");
		
		var i=0;
		for(i=0;i<inputArr.length ; i++){
//			inputArr[i].disabled = "disabled";
			inputArr[i].readOnly = true;
			inputArr[i].className = "input2";
			//inputArr[i].disabled = ""; //비활성화 해제
		}				
		
		for(i=0;i<textareaArr.length ; i++){
			textareaArr[i].readOnly = true;
			textareaArr[i].className = "textarea2";
		}
		for(i=0;i<imgArr.length ; i++){
			if(imgArr[i].name!="btn_attach"){
				imgArr[i].style.display = "none";
			}
		}
		
		
		//콤보박스 비활성화
		frm.eac_apro_tp_cd.Enable    = false;  // Type
		frm.eac_expn_tp_cd.Enable    = false;  // Expense Type
		frm.eac_tp_cd.Enable         = false;  // EAC Type
		frm.eac_bil_tp_cd.Enable     = false;   // EAC Type Detail
		frm.curr_cd.Enable           = false;   // Currency
		frm.eac_rsn_cd.Enable        = false;  // Action Type
		
		
		frm.eac_cmpl_cd.Enable       = false; // Completion
			
		
		frm.vndr_cntc_pnt_nm.Enable  = false; // Contact Point
		frm.n3pty_expn_tp_cd.Enable  = false; // TPB Exp.Type
		frm.n3pty_bil_tp_cd.Enable   = false; // TPB Code
		frm.vndr_cust_div_cd.Enable  = false; // 3RD Party
		
		// 버튼 비활성화
		ComBtnDisable("btn_save"); // Save
		ComBtnDisable("btn_delete"); // Delete
		ComBtnDisable("btn_new"); // Delete
		ComBtnDisable("btn_issue"); // Issue
		ComBtnDisable("btn_print"); // print
		ComBtnDisable("btng_RowAdd"); // Row Add
		ComBtnDisable("btng_RowDel"); // Row Delete
		ComBtnDisable("btng_tpb_if"); // TPB I/F
		ComBtnDisable("btng_preview"); // Rejection Notice 비활성화(조회전엔 비활성화 한다.)
		ComBtnDisable("btng_history"); // Rejection Notice History 비활성화(조회전엔 비활성화 한다.)				
//		ComBtnEnable("btn_save");// 저장
		
		sheetObjects[0].Editable = false;
		
	}	
	
	/**
	* EAC NO로 File Attach 팝업 호출
	*
	* @param : val - eac_no
	*/
	function openEacFileAttach(eacNo, eacCmplCd) {
		if (frm.eac_no.value == "") {
			ComShowCodeMessage('EAS90058');
			return;
		}
		
		var url = "/hanjin/ESD_EAS_0223.do?eac_no="+eacNo+"&eac_cmpl_cd="+eacCmplCd;
		ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
	}

/* 개발자 작업  끝 */
