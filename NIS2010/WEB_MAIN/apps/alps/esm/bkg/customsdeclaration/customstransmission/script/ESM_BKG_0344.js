/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0344.js
*@FileTitle : Korea Manifest Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.02 박상훈
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.04.13 김영철 [CHM-201109147-01] 1) Save 이벤트에서 화면 Receiver항목 저장  2) 화면 조회 항목 추가: Send Date/Time 뒤에 Receiver 표기
* 2012.02.23 채창호 [CHM-201216259-01]:광양항, 경인항+인천항 MANIFEST 정보 변경사항 반영
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/

/**
 * JSDOC 을 위한 함수 정의
 */
function esm_bkg_0344()
{
	this.processButtonClick		= processButtonClick;
	this.checkBoundCd			= checkBoundCd;
	this.setSheetobject			= setSheetObject;
	this.loadPage				= loadPage;
	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
	this.call_knt_change		= call_knt_change;
	this.validateForm			= validateForm;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.funcChange				= funcChange;
	this.funcNewAction			= funcNewAction;
	this.initCombo				= initCombo;
	this.combo1_OnChange		= combo1_OnChange;
	this.combo2_OnChange		= combo2_OnChange;
	this.combo3_OnChange		= combo3_OnChange;
	this.setComboObject			= setComboObject;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick()
{
	var formObj = document.form;
	var sheetObject = sheetObjects[0];
	try 
	{
		var srcName = window.event.srcElement.getAttribute("name");
		// 공공VVD 처리를 위한 inType값 세팅.
		formObj.none_bl_in_type.value = formObj.in_type.value;
		
		switch(srcName) 
		{
			case "btn_Retrieve":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, IBSEARCH);				
				break;
			case "btn_New":
				funcNewAction(formObj, false);
				break;
			case "btn_Save":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MODIFY);
				break;
			case "btn_TransManifest":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI05);
				break;
			case "btn_DeleteManifest":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, REMOVE);
				break;
			case "btn_TransperBL":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_CancelperBL":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI07);
				break;
			case "btn_TransAmendToPA":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;
			case "btn_TransCancellationToPA":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI03);
				break;
			case "pol_cd":
				formObj.io_bnd_cd[1].checked = true;
				checkBoundCd(formObj);
				formObj.pol_cd.focus();
				break;
			case "pod_cd":
				formObj.io_bnd_cd[0].checked = true;
				checkBoundCd(formObj);
				formObj.pod_cd.focus();
				break;
			case "io_bnd_cd":
				checkBoundCd(formObj);
				break;
			case "btn_searchBondArea":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				if (formObj.io_bnd_cd[1].checked) {
					sUrl = "ESM_BKG_0334_Q.do?pgmNo=ESM_BKG_0334_Q";
					var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0334", 700, 400, true);
	      			if (rtnVal != null) formObj.bd_area_cd.value = rtnVal.cd;
				}
      			break;
			case "btn_searchTmlLoc":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				sUrl = "ESM_BKG_0416.do?pgmNo=EMS_BKG_0416";
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0416", 1024, 650, true);
				if (rtnVal != null) formObj.io_tml_loc_cd.value = rtnVal.cd;
				break;
			case "btn_TransEmptyAmend":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				doActionIBSheet(sheetObject, formObj, MULTI06);
				break;
			case "btn_trans_cancell_popup":
				if(formObj.io_bnd_cd[0].checked == true){
					formObj.tml_cd.value = formObj.pod_tml_cd.value;
				}else{
					formObj.tml_cd.value = formObj.pol_tml_cd.value;
				}
				  formObj.f_cmd.value = INIT;
				  var sndDate = formObj.f_date.value + " " + formObj.t_date.value; 
				  sUrl = "ESM_BKG_0346.do?pgmNo=ESM_BKG_0346&" + FormQueryString(formObj) + "&snd_date="+sndDate;
				  var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0346", 1024, 300, true);
				break;
			case "btn_searchDischCo":
				var sendPortCd = "";
				if(formObj.io_bnd_cd[0].checked == true){
					sendPortCd = formObj.pod_cd.value;
				}else{
					sendPortCd = formObj.pol_cd.value;
				}
				
				sUrl = "ESM_BKG_0347.do?pgmNo=ESM_BKG_0347"+"&port_cd=" + sendPortCd ;
				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0347", 600, 450, true);
	      		if (rtnVal != null) formObj.cstms_dchg_cd.value = rtnVal.cd;
					
					
      			break;
		} // end switch
	}
	catch(e) 
	{
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else 					   ComShowMessage(e);
	}
}

/**
 * IN, Out Bound 선택에 따른 폼 처리
 * @param formObj
 * @return
 */
function checkBoundCd(formObj) { 
	if (formObj.io_bnd_cd[0].checked) {
		// IN-BOUND
		formObj.pol_cd.value='';
		formObj.pol_tml_cd.value='';
		formObj.pol_cd.disabled = true;	
		formObj.pol_tml_cd.disabled = true;	
		formObj.pol_cd.className="input2";
		formObj.pol_tml_cd.className="input2";
		formObj.pod_cd.disabled = false;
		formObj.pod_cd.className="input1";
		initCombo(comboObjects[0], 2);
		// Type E와 공백만을 추가
//		comboObjects[0].DeleteItem("A");
//		comboObjects[0].DeleteItem("B");
//		comboObjects[0].DeleteItem("C");
//		comboObjects[0].DeleteItem("D");
		//comboObjects[0].DeleteItem("M");
//		if(comboObjects[0].getCount() == 3){
//			comboObjects[0].InsertItem(-1, " | ", " ");
//		}
		
		comboObjects[0].Code2= ' ';
		comboObjects[0].Enable=true;
		formObj.bd_area_cd.disabled = true;
		formObj.bd_area_cd.className="input2";
		formObj.pod_tml_cd.disabled= false;
		formObj.pod_tml_cd.className="input";
		formObj.eta_dt.disabled = false;
		formObj.eta_dt.className = "input";
		ComShowObject(formObj.dwell, false);
		ComShowObject(document.all.dwell_txt, false);
		ComShowObject(formObj.ib_vvd, false);
		ComShowObject(document.all.ib_vvd_txt, false);
		ComShowObject(formObj.whf_notice, false);
		ComShowObject(document.all.whf_notice_txt, false);
		ComShowObject(formObj.ib_bl_cnt, false);
		ComShowObject(document.all.ib_bl_cnt_txt, false);
		ComShowObject(document.all.emptyAmend_line, false);
		ComShowObject(document.all.emptyAmend_btn, false);
		ComShowObject(document.all.span_trans, true);
	}else {
		// OUT-BOUND
		formObj.pod_cd.value='';
		formObj.pod_tml_cd.value='';
		formObj.pod_cd.disabled = true;
		formObj.pod_cd.className="input2";
		formObj.pol_tml_cd.disabled= false;
		formObj.pol_tml_cd.className="input";
		formObj.pol_cd.disabled = false;
		formObj.pol_cd.className="input1";
		//if(comboObjects[0].GetCount() == 4){
			
			initCombo(comboObjects[0], 2);
		//}
		comboObjects[0].Enable = true;
		comboObjects[0].Code2 = formObj.in_type.value;
		formObj.bd_area_cd.disabled = false;
		formObj.bd_area_cd.className="input1";
		formObj.pod_tml_cd.disabled= true;
		formObj.pod_tml_cd.className="input2";
		formObj.eta_dt.disabled = true;
		formObj.eta_dt.className ="input2";
		ComShowObject(formObj.dwell, true);
		ComShowObject(document.all.dwell_txt, true);
		ComShowObject(formObj.ib_vvd, true);
		ComShowObject(document.all.ib_vvd_txt, true);
		ComShowObject(formObj.whf_notice, true);
		ComShowObject(document.all.whf_notice_txt, true);
		ComShowObject(formObj.ib_bl_cnt, true);
		ComShowObject(document.all.ib_bl_cnt_txt, true);
		ComShowObject(document.all.emptyAmend_line, true);
		ComShowObject(document.all.emptyAmend_btn, true);
		ComShowObject(document.all.span_trans, false);		
		formObj.trans_target.value = "A";
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() 
{
	for(i=0;i<sheetObjects.length;i++)
	{
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
}

/**
 * Sheet1 로드 완료후 처리 
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	checkBoundCd(document.form);    
    if(document.form.vvd.value != '')
    {
    	if(document.form.io_bnd_cd[0].checked == true){
    		document.form.tml_cd.value = document.form.pod_tml_cd.value;
		}else{
			document.form.tml_cd.value = document.form.pol_tml_cd.value;
		}
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }else {
    	funcNewAction(document.form, false);
    }
    
    // Empty Amend 버튼 상태 처리
    if (document.form.dwell.value > 29 || document.form.whf_notice.value.trim().length > 0) {
    	ComBtnDisable("btn_TransEmptyAmend");
    }else {
    	ComBtnEnable("btn_TransEmptyAmend");
    }
  // [CHM-201216259-01]:광양항, 경인항+인천항 MANIFEST 정보 변경사항 반영  
  //값을 강제로 셋팅을 한다.
	if(form.pod_cd.value == "KRGIN" || form.pod_cd.value == "KRINC" ){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}else if (form.pol_cd.value  == "KRGIN" || form.pod_cd.value == "KRINC"){
		form.tax_code1.value ="020";
		form.tax_code2.value = "10";
	}
}

/**
  * 입항횟수 change 시3자리 0 표시 추가
  * @return
 */
function call_knt_change()
{
	var formObj = document.form;
	formObj.call_knt.value = ComLpad(formObj.call_knt.value, 3, "0");
}

/**************************************************************************************************
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 **************************************************************************************************/
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
    	if (formObj.vvd.value.length < 9) {
    		ComShowCodeMessage('BKG00103');
    		formObj.vvd.focus();
    		return false;
    	}
    	
    	if (formObj.io_bnd_cd[1].checked && formObj.pol_cd.value.length < 5) {
    		ComShowCodeMessage('BKG00103');
    		formObj.pol_cd.focus();
    		return false;
    	}
    	
    	if (formObj.io_bnd_cd[0].checked && formObj.pod_cd.value.length < 5) {
    		ComShowCodeMessage('BKG00103');
    		formObj.pod_cd.focus();
    		return false;
    	}
    	switch (sAction) {
    	case MULTI05:
	    	if(formObj.bd_area_chk.value == "N" && formObj.pod_cd.value == "KRPUS" ){
	    		ComShowCodeMessage('BKG95073');
	    		return false;
	    	}
	    	// Inbound 의 경우 하선신고서(CUSAGD)상 Disch. CY(하역장소) 필수 전송
			if (formObj.crr_in_cy_chk.value == "N"
				&& (formObj.trans_target.value=="A" || formObj.trans_target.value=="D") 
				&& formObj.io_bnd_cd[0].checked){
	    		ComShowCodeMessage('BKG95111');  // 전송 B/L 중에 Disch. CY Code가 정확하게 입력 되지 않은 B/L이 존재합니다.
	    		return false;				
			}
	    	break;
    	}
    }
    return true;
}

/**************************************************************************************************
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 **************************************************************************************************/
function initSheet(sheetObj,sheetNo) 
{
	var cnt = 0;
	switch(sheetNo) 
	{
	case 1:      //sheet1 init
		with (sheetObj) 
		{
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
			InitRowInfo( 1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			var HeadTitle = "|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false, prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,   	40,   		daCenter,  	true,  prefix + "Seq");
			InitDataProperty(0, cnt++ , dtData,  	   170,  		daCenter,	false, prefix + "mrn",      false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	   110,  		daCenter,	false, prefix + "vvd",      false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	   100,  		daCenter,  	false, prefix + "pol",      false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		80,   		daCenter,  	false, prefix + "pod",      false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		75,   		daCenter,	false, prefix + "office",   false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		75,   		daCenter,  	false, prefix + "userid",   false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		90,   		daRight,  	false, prefix + "blcount",  false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		60,   		daCenter,	false, prefix + "ac",       false, "",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		90,   		daCenter,  	false, prefix + "dt",       false, "",	dfNone,	0, true, true);
			InitDataProperty(0, cnt++ , dtData,  		80,   		daCenter,  	false, prefix + "dt2",      false, "",	dfNone,	0, true, true);

			CountPosition = 0;
		}
		break;
	}
}

/**************************************************************************************************
 * Sheet관련 프로세스 처리
 **************************************************************************************************/
function doActionIBSheet(sheetObj,formObj,sAction) 
{
    sheetObj.ShowDebugMsg = false;

    switch(sAction) 
    {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			if(validateForm(sheetObj, formObj, sAction))
			{
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.EtcData('mrn_no')= ' ';
				sheetObj.DoSearch("ESM_BKG_0344GS.do", FormQueryString(formObj));
				ComOpenWait(false);

				if (sheetObj.EtcData('mrn_no')==' ') {
					funcNewAction(formObj, false);
				}else {
					// 조회 값들은 임시로 저장해서 원상태로 돌리기 위함
					var podTml = formObj.pod_tml_cd.value;	
					var inType = formObj.in_type.value;
					ComEtcDataToForm(formObj, sheetObj);
					formObj.old_eta_dt.value = sheetObj.EtcData("eta_dt");
					// 조회값 원복
					formObj.pod_tml_cd.value = podTml;
					formObj.in_type.value = inType;
					comboObjects[0].Code2 = inType;
					// 하역 방법 콤보 처리
					comboObjects[2].Code = sheetObj.EtcData("dchg_mzd_cd");
					call_knt_change();
				    funcNewAction(formObj, true);
				    // 변경파라메터 초기화
				    formObj.cancel_flg.value="";
				    formObj.in_chg_meth.value="";
				    formObj.in_chg_comp.value="";
				    formObj.in_chg_port.value="";
				}
				// 수량 콤마 찍기
				formObj.ttl_wgt.value = ComAddComma(formObj.ttl_wgt.value);
				formObj.ttl_pck_qty.value = ComAddComma(formObj.ttl_pck_qty.value);
				formObj.ttl_meas_qty.value = ComAddComma(formObj.ttl_meas_qty.value);
				if(formObj.io_bnd_cd[0].checked){
					comboObjects[0].Enable = formObj.io_bnd_cd[0].checked;
				}else{
					comboObjects[0].Enable = formObj.io_bnd_cd[1].checked;					
				}
			}		    
		    break;
		case MODIFY:
			if(ComShowCodeConfirm('BKG95003', 'save')) {
				formObj.f_cmd.value = MODIFY;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
		case REMOVE:
			var delCfm=false;
			// 전송여부가 Y 이면 메시지 띄움
			if (formObj.old_snd_chk.value=="Y") {
				delCfm = ComShowConfirm('Already Transmitted !!\nDo you want to delete ?');
			}else {
				delCfm = ComShowCodeConfirm('BKG95003', 'delete'); 
			}
			if(delCfm) {
				formObj.f_cmd.value = REMOVE;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				funcNewAction(formObj, false);
				ComOpenWait(false);
			}
			break;
		case MULTI01:
			var doProcess= false;
			// B/L NO CHECK
			if (formObj.bl_no.value.length < 11) {
				ComShowCodeMessage('BKG00266');
				formObj.bl_no.focus();
				doProcess = false;
			}else if (formObj.in_type.value=="A" || formObj.in_type.value=="B") {
				// A,B TYPE의 경우 C TYPE 기록이 있으면 확인
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}else {
					doProcess = true;
				}
			}else {
				doProcess = true;
			}
			if (doProcess) {
				//  입항횟수 체크
				if (formObj.call_knt.value.length < 3 || formObj.call_knt.value=="000") {
					ComShowCodeMessage("COM130201", "입항횟수");
					formObj.call_knt.focus();
				}else if (formObj.io_tml_loc_cd.value.trim().length < 2) { 
					ComShowCodeMessage('BKG50482');
					formObj.io_tml_loc_cd.focus();
				}else{
					formObj.f_cmd.value = MULTI05;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					ComOpenWait(false);
				}
			}
			break;
		case MULTI07:
			// Cancel Per B/L 
			var doProcess= false;
			// B/L NO CHECK
			if (formObj.bl_no.value.length < 11) {
				ComShowCodeMessage('BKG00266');
				formObj.bl_no.focus();
				doProcess = false;
			}else if (formObj.in_type.value=="A" || formObj.in_type.value=="B") {
				// A,B TYPE의 경우 C TYPE 기록이 있으면 확인
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}else {
					doProcess = true;
				}
			}else {
				doProcess = true;
			}
			if (doProcess) {
				formObj.f_cmd.value = MULTI07;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
		case MULTI02:
			// Trans Amendment to PA
			var doProcess= true;
			// A,B TYPE의 경우 C TYPE 기록이 있으면 확인
			if (formObj.in_type.value=="A" || formObj.in_type.value=="B") {
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}
			}
			if (doProcess) {
				formObj.f_cmd.value = MULTI02;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
		case MULTI03:
			// Trans Cancellation to PA
			var doProcess= true;
			// A,B TYPE의 경우 C TYPE 기록이 있으면 확인
			if (formObj.in_type.value=="A" || formObj.in_type.value=="B") {
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}
			}
			if (doProcess) {
				formObj.f_cmd.value = MULTI02;
				// 변경파라메터 초기화
			    formObj.cancel_flg.value="ZD";
			    formObj.in_chg_meth.value="";
			    formObj.in_chg_comp.value="";
			    formObj.in_chg_port.value="";
			    sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
		case MULTI04: // Discharge (Inbound 의 경우 Target이 discharge 인경우만 전송)
			formObj.f_cmd.value = MULTI04;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			break;
		case MULTI05:
			if(validateForm(sheetObj, formObj, sAction)){
				
			
				var doProcess= true;
				var transResult = true;
				var sXml;
				// A,B TYPE의 경우 C TYPE 기록이 있으면 확인
				if (formObj.in_type.value=="A" || formObj.in_type.value=="B") {
					if (formObj.trans_pre_cnt.value!="0") {
						doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
					}
				}
				if (doProcess) {
					// Inbound 의 경우 Discharge 전송 (Trans 가 A 이거나 D 인 경우만)
					if (formObj.io_bnd_cd[0].checked && 
							(formObj.trans_target.value=="A" || formObj.trans_target.value=="D") ) {
						formObj.f_cmd.value = MULTI04;
						ComOpenWait(true);
						sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
						transResult = ComBkgErrMessage(sheetObj, sXml);
						ComOpenWait(false);
					}
					
					// Manifest 는 TransTarget 이 D 이면 전송하지 않음
					if (transResult==true && formObj.trans_target.value!="D") {
						//  입항횟수 체크
						if (formObj.call_knt.value.length < 3 || formObj.call_knt.value=="000") {
							ComShowCodeMessage("COM130201", "입항횟수");
							formObj.call_knt.focus();
							return false;
						}else if (formObj.io_tml_loc_cd.value.trim().length < 2) { 
							ComShowCodeMessage('BKG50482');
							formObj.io_tml_loc_cd.focus();
							return false;
						}else {
							formObj.f_cmd.value = MULTI05;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
							transResult = ComBkgErrMessage(sheetObj, sXml);
							var key = ComGetEtcData(sXml, "KEY");
							//ComShowMessage(key);
							intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
							//ComOpenWait(false);
						}
					}
				
				}
				
//				if (transResult) {
//					ComShowCodeMessage("BKG00204");
//				}
			}
			break;
		case MULTI06:
			if (formObj.ib_bl_cnt.value < 1) {
				ComShowCodeMessage("BKG01096");
			} else {
				formObj.f_cmd.value = MULTI06;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.receiver.value = formObj.in_receiver.value;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
			}
			break;
		case IBDOWNEXCEL:      // 입력
			sheetObj.SpeedDown2Excel(1);
	        break;
    }
}
 
 /**
  * BackEndJob 실행결과조회<br>
  * 
  * @param sheetObj
  * @param sKey
  */
function doActionValidationResult(sheetObj, sKey) {
 	//ComShowMessage("1");
 	var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
 	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

 	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
 	
 	// 에러가 발생했을 경우 대기사항을 종료한다.
 	if (!ComBkgErrMessage(sheetObj, sXml)) {
 		clearInterval(intervalId);
 		ComOpenWait(false);
 		return;
 	}
 	if (sJbStsFlg == "SUCCESS") {
 		clearInterval(intervalId);
 		ComOpenWait(false);
 		// 성공메시지 보여주고
 		//ComShowCodeMessage('BKG00101');
 		ComShowCodeMessage("BKG00204");
 		return;
 	} else if (sJbStsFlg == "FAIL") {
 		//에러
 		clearInterval(intervalId);
 		ComOpenWait(false);
 		// 에러메시지 보여주고
 		ComShowMessage(ComResultMessage(sXml));
 	}
}

//*************************************************************************************************
// 일괄정정부호 처리를 위한 이벤트 함수
//*************************************************************************************************
function funcChange(changeCode)
{
	var form = document.form;
	if(changeCode == 'ZH3')
	{
		form.in_chg_comp.value = changeCode;
	}
	else if(changeCode == 'ZH2')
	{
		form.in_chg_port.value = changeCode;
	}
	else if(changeCode == 'ZH1')
	{
		form.in_chg_meth.value = changeCode;
	}else if (changeCode == 'AI')
	{
		form.in_chg_eta.value = changeCode;
	}
}

/**
 * 초기화 처리 
 * @param formObj
 * @param op
 * @return
 */
function funcNewAction(formObj, op)
{	
	if(op)
	{
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_TransManifest");
		ComBtnEnable("btn_DeleteManifest");
		ComBtnEnable("btn_TransperBL");
		ComBtnEnable("btn_CancelperBL");
		ComBtnEnable("btn_TransAmendToPA");
		ComBtnEnable("btn_TransCancellationToPA");
		ComBtnEnable("btn_trans_cancell_popup");
	}
	else
	{
		// Combo 초기화
		comboObjects[0].Code = 'D';
		comboObjects[1].Code = '0';
		comboObjects[2].Code = '';				
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_TransManifest");
		ComBtnDisable("btn_DeleteManifest");
		ComBtnDisable("btn_TransperBL");
		ComBtnDisable("btn_CancelperBL");
		ComBtnDisable("btn_TransAmendToPA");
		ComBtnDisable("btn_TransCancellationToPA");
		ComBtnDisable("btn_trans_cancell_popup");
		formObj.reset();
		//comboObjects[0].Code = "A";
		checkBoundCd(formObj);
	}
}

/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch(comboObj.id) {
	case "combo1":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|130");
			DropHeight = 200;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "All|관세청 + 해양항만청", "0");
			InsertItem(cnt ++, "PA|해양항만청", "1");
			Code = "0";
		}
		break;
	case "combo2":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|90");
			DropHeight = 200;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			if(document.form.io_bnd_cd[0].checked){
				DeleteItem(" ");
				DeleteItem("E");
				DeleteItem("A");
				DeleteItem("R");
				DeleteItem("M");
				DeleteItem("T");
				DeleteItem("A");
				DeleteItem("B");
				DeleteItem("C");
				DeleteItem("D");
				InsertItem(cnt ++, " ", " ");
				InsertItem(cnt ++, "E| 운항정보 Only", "E");
				InsertItem(cnt ++, "A| Local", "A");
				InsertItem(cnt ++, "R| T/S", "R");
				InsertItem(cnt ++, "M| eMpty Local", "M");
				InsertItem(cnt ++, "T| eMpty T/S", "T");
			}else{
				DeleteItem(" ");
				DeleteItem("E");
				DeleteItem("A");
				DeleteItem("R");
				DeleteItem("M");
				DeleteItem("T");
				DeleteItem("A");
				DeleteItem("B");
				DeleteItem("C");
				DeleteItem("D");
				InsertItem(cnt ++, "A|미주 Local", "A");
				InsertItem(cnt ++, "B|아/구주 Local", "B");
				InsertItem(cnt ++, "C|T/S", "C");
				InsertItem(cnt ++, "D|A+B+C+M", "D");
				InsertItem(cnt ++, "E| 운항정보 Only", "E");
				InsertItem(cnt ++, "M| eMpty Local", "M");
			}
//			InsertItem(cnt ++, "A|미주 Local", "A");
//			InsertItem(cnt ++, "B|아/구주 Local", "B");
//			InsertItem(cnt ++, "C|T/S", "C");
//			InsertItem(cnt ++, "D|A+B+C+M", "D");
//			InsertItem(cnt ++, "E| 운항정보 Only", "E");
//			InsertItem(cnt ++, "M| eMpty Local", "M");
//			InsertItem(cnt ++, "T| eMpty T/S", "T");
			
		}
		break;    	            
	case "combo3":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|90");
			DropHeight = 200;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "1|일반하역", "1");
			InsertItem(cnt ++, "2|기계하역", "2");
			InsertItem(cnt ++, "3|송유관 하역", "3");
			InsertItem(cnt ++, "4|무연탄 하역", "4");
			Code = "2";
		}
		break;    	            
	}
}

/**
 * 콤보1 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo1_OnChange(comboObj,value,text) {
	 var form = document.form;
	 form.in_receiver.value = value;
}

/**
 * 콤보2 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo2_OnChange(comboObj,value,text) {
	  var form = document.form;
	  form.in_type.value = value;
 }

/**
 * 콤보3 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo3_OnChange(comboObj,value,text) {
	var form = document.form;
	form.dchg_mzd_cd.value = value;
	funcChange('ZH1');
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function transTargetChange()
{
	var form = document.form;
	
	if (form.trans_target.value=="D") {
		document.all.btn_TransManifest.innerHTML = "Trans Discharge";
	}else {
		document.all.btn_TransManifest.innerHTML = "Trans Manifest";
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
