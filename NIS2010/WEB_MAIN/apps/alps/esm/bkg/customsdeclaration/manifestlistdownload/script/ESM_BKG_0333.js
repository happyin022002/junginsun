/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0333.js
*@FileTitle : Warehouse Assign by B/L
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
* 1.1 2015.06.30 [CHM-201535756] 한국 WHF 면제/조정 기능 간소화 
* 1.2 2015.07.15 [CHM-201536700] Menu : KOR MANIFEST => Warehouse Assign by B/L 화면: T/S save시 CNTR 정보(CNTR_WFG_EXPT_FLG) upadte 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수정의
 */
function esm_bkg_0333()
{
	this.processButtonClick		= processButtonClick;
	this.selectSearchType		= selectSearchType;
	this.loadPage				= loadPage;
	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
	this.validateForm			= validateForm;
	this.doActionIBSheet		= doActionIBSheet;
	this.setBkgRtWhfExptCd		= setBkgRtWhfExptCd;
	this.initSheet				= initSheet;
	this.setSheetObject			= setSheetObject;
	this.obj_keypress			= obj_keypress;
	this.sheet2_OnDblClick		= sheet2_OnDblClick;
	this.initCombo				= initCombo;
	this.combo1_OnChange		= combo1_OnChange;
	this.combo1_OnKeyDown		= combo1_OnKeyDown;
	this.combo2_OnChange		= combo2_OnChange;
	this.setComboObject			= setComboObject;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var afterRetrive = false;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var comboObject1 = comboObjects[0];
	var comboObject2 = comboObjects[1];

	/*******************************************************/
	var formObject = document.form;
	var layerWin = document.all.layer1;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_ARIF":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;

		case "btn_GotoInvoice":
			var classId = "FNS_INV_0009";
            var param = '?pgmNo=FNS_INV_0009-01&bl_src_no='+formObject.bl_no.value+'&ar_ofc_cd='+formObject.clt_ofc_cd.value+'&classId='+classId;			
			ComOpenWindowCenter('/hanjin/FNS_INV_0009.do'+param, 'FNS_INV_0009' ,1024,640, true);
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_Save":
			// 저장 
			if(ComShowCodeConfirm("BKG00350")) {
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			}
			break;

		case "btn_GroupMSN": // MRN 과 POL을 가지고 POPUP
			var param = "&type="+form.local_ts.value+"&vvd="+form.grp_vvd.value +
			            "&mrn_no="+form.grp_mrn.value+"&mrn_chk_no="+form.grp_mrn_chk.value+
			            "&pol="+form.grp_pol.value+"&pod="+form.grp_pod.value+"&yard="+form.yard.value+
			            "&bkg_no="+form.bkg_no.value+"&etd="+form.grp_etd.value+"&eta="+form.grp_eta.value;
			ComOpenWindowCenter('/hanjin/ESM_BKG_0338.do?pgmNo=ESM_BKG_0338'+param, 'GroupMSN' ,1024,640, false);
			break;

		case "btn_CargoRelease":
			ComOpenWindowCenter('/hanjin/ESM_BKG_0682.do?pgmNo=ESM_BKG_0682&bkg_no='+formObject.bkg_no.value, 'CargoRelase' ,1024,700, false);
			break;
		
		case "btn_SearchEntryType":	// EntryType 조회 POPUP
		 	var entryTypeVal = ComOpenWindowCenter('/hanjin/ESM_BKG_0335_Q.do?pgmNo=ESM_BKG_0335', 'entryTypePop' ,640,400, true);
			if (entryTypeVal) {
				form.cstms_clr_tp_cd.value = entryTypeVal;
			}
			break;
			
		case "btn_SearchDischCYCode":	// Discharging CY Code 조회 POPUP
			var params = "?otr_dchg_cd="+formObject.cstms_dchg_loc_wh_cd.value+"&pgmNo=ESM_BKG_0334";
			var cyCodeObject = ComOpenWindowCenter('/hanjin/ESM_BKG_0334_Q.do'+params, 'cyPop' ,700,450, true);
			if (cyCodeObject) {
				var cyCode = cyCodeObject.cd;
				var cyName = cyCodeObject.loc_nm;
				form.cstms_dchg_loc_wh_cd.value = cyCode;
				form.loc_nm.value = cyName;
			}
			break;
		case "btn_SearchWareHouse":	// WareHouse Code 조회 POPUP
			var whCodeObject = ComOpenWindowCenter('/hanjin/ESM_BKG_0345.do?pgmNo=ESM_BKG_0345&cnt_cd=KR', 'whPop' ,1024,580, true);
			if (whCodeObject) {
				var whCode = whCodeObject.cd;
				var whName = whCodeObject.wh_nm;
				var whLoc  = whCodeObject.loc_cd;
				form.cstms_clr_wh_cd.value = whCode;
				form.wh_nm.value = whName;
				form.loc_cd.value = whLoc;
			}
			break;
		case "bkg_no":
			formObject.search_type[1].checked=true;
			selectSearchType();
			break;
		case "bl_no":
			formObject.search_type[0].checked=true;
			selectSearchType();
			break;
		case "search_type":
			selectSearchType();
			break;
		case "btn_bizno":
			var bizNoObject = ComOpenWindowCenter('/hanjin/ESM_BKG_0738.do?pgmNo=ESM_BKG_0738&country=KR', 'SearchBizNo' ,600,400, true);
			if (bizNoObject) {
				form.whf_shpr_rgst_no.value = bizNoObject.vRgstNo;
			}
			break;
			
		case "wharfage_wave":  // Add. [CHM-201535756]
			seleteWhfWave();
			break;
		case "btn_deleteWhf":  // DELETE WHF // Add. [CHM-201535756]
			if(ComShowCodeConfirm("BKG06167")) {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			}
			
			break;
		case "btn_adjustWhf":  // Adjust WHF // Add. [CHM-201535756]
			ComOpenWindowCenter("/hanjin/ESM_BKG_0332.do?pgmNo=ESM_BKG_0332&vvd_no="+formObject.vvd.value
									+"&port_cd="+formObject.pod_cd.value+"&bkg_no="+formObject.bkg_no.value+ "&bdr_flg=" + formObject.bdr_flg.value, 'adjustWhf', 650, 190, true);
			
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

/*
 WHF Wave 에 대하여 값 및 버튼설정 하기
*/
function seleteWhfWave(){
	var formObject = document.form;
	
	if( (formObject.wharfage_wave[0].checked
			|| formObject.wharfage_wave[2].checked
			|| formObject.wharfage_wave[9].checked )
			&& afterRetrieve){
		
		ComBtnDisable("btn_deleteWhf");
		
		if(formObject.wharfage_wave[9].checked){
			ComBtnEnable("btn_adjustWhf");
		}else{
			ComBtnDisable("btn_adjustWhf");
		}
	}else{
		if(afterRetrieve){
		ComBtnEnable("btn_deleteWhf");
		ComBtnDisable("btn_adjustWhf");
		}
	}
	
	// wharfage wave값을 저장하여 VO에 담기 위해서
	for(var i=0; i<10; i++){

		if(formObject.wharfage_wave[i].checked){
			formObject.whf_wave.value =formObject.wharfage_wave[i].value;
			break;	
		}
	} 
}

/**
 * 조회 조건 변경시 처리
 * @return
 */
function selectSearchType()
{
	var formObject = document.form;
	if (formObject.search_type[0].checked) {
		formObject.bkg_no.className="input2";
		formObject.bl_no.className="input1";
		formObject.bl_no.focus();
	}else {
		formObject.bl_no.className="input2";
		formObject.bkg_no.className="input1";
		formObject.bkg_no.focus();
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
	    initCombo(comboObjects[k],k+1);
	}

}

/**
 * Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;
	
	// 버튼들 비활성화
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_ARIF");
	ComBtnDisable("btn_GotoInvoice");
	ComBtnDisable("btn_GroupMSN");
	ComBtnDisable("btn_CargoRelease");

	// Add. [CHM-201535756] 
	ComBtnDisable("btn_deleteWhf");
	ComBtnDisable("btn_adjustWhf");
	afterRetrieve = false;
	
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	selectSearchType();
	
	// BL_NO가 있으면 조회 처리
	if (document.form.bl_no.value.length > 1) doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.search_type[0].checked) {
			// BL_NO 조회
			if (formObj.bl_no.value.length < 1) {
				ComShowCodeMessage('BKG00786');
				formObj.bl_no.focus();
				return false;
			}
		}else {
			// BKG_NO 조회
			if (formObj.bkg_no.value.length < 1) {
				ComShowCodeMessage('BKG00786');
				formObj.bkg_no.focus();
				return false;
			}
		}
		switch (sAction){
			case IBSAVE:
				if(null != document.form.cstms_clr_tp_cd.value && "" != document.form.cstms_clr_tp_cd.value ){
					var input_text = document.form.cstms_clr_tp_cd.value;
					var param = "&f_cmd=" + SEARCH14 + "&input_text=" + input_text
					var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
				 	var output_text = ComGetEtcData(sXml, "output_text");
				 	
				 	if('N' == output_text){
				 		ComShowCodeMessage("BKG00044",'Entry Type'); 
				 		document.form.cstms_clr_tp_cd.focus();
				 		return false;
				 	}
				}
				break;
		}
	}

	return true;
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
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			
			if(validateForm(sheetObj,formObj,sAction)) {
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true); 
				
				formObj.bfr_whf_wave.value = ""; // Add. [CHM-201536700]
				
				sheetObj.DoSearch("ESM_BKG_0333GS.do", FormQueryString(formObj) );
				// FORM UPDATE
				IBS_EtcDataToForm(formObj,sheetObj);
				formObj.act_wgt.value =  ComGetMaskedValue(formObj.act_wgt.value, "float"); 
				formObj.pck_qty.value =  ComGetMaskedValue(formObj.pck_qty.value, "float");
				formObj.meas_qty.value =  ComGetMaskedValue(formObj.meas_qty.value, "float");
				
				comboObjects[1].Code = formObj.bd_tp_cd.value;
				comboObjects[0].Code = formObj.kr_cstms_bl_tp_cd.value;
				// WHARFAGE 조회 값이 있으면 처리
				if (sheetObj.EtcData('bkg_rt_whf_expt_cd')!=null && sheetObj.EtcData('bkg_rt_whf_expt_cd').length > 0) {
					var exptCd = sheetObj.EtcData('bkg_rt_whf_expt_cd');
					switch(exptCd) {
						case "B": formObj.wharfage_wave[9].checked=true; break;
						case "D": formObj.wharfage_wave[3].checked=true; break;
						case "I": formObj.wharfage_wave[5].checked=true; break;
						case "J": formObj.wharfage_wave[6].checked=true; break;
						case "K": formObj.wharfage_wave[7].checked=true; break;
						case "N": formObj.wharfage_wave[2].checked=true; break;
						case "S": formObj.wharfage_wave[1].checked=true; break;
						case "X": formObj.wharfage_wave[4].checked=true; break;
						case "C": formObj.wharfage_wave[8].checked=true; break;   // Add. [CHM-201535756]
						default : formObj.wharfage_wave[0].checked=true; break;
					}
				}else {		
				// 없으면 mrn_bl_ts_cd 값에 따른 RADIO 버튼 처리
					if (formObj.mrn_bl_ts_cd.value=='E') formObj.wharfage_wave[4].checked=true;
					if (formObj.bd_tp_cd.value=='O' || formObj.bd_tp_cd.value=='N') formObj.wharfage_wave[5].checked=true;
					if (formObj.cnee.value=='KR008142' || formObj.nfty.value=='KR008142') formObj.wharfage_wave[6].checked=true;
					if (formObj.cnee.value=='KR043734' || formObj.nfty.value=='KR043734') formObj.wharfage_wave[7].checked=true;
				}
				ComOpenWait(false);
				// 버튼 활성화
				ComBtnEnable("btn_Save");
				ComBtnEnable("btn_ARIF");
				ComBtnEnable("btn_GotoInvoice");
				ComBtnEnable("btn_GroupMSN");
				ComBtnEnable("btn_CargoRelease");
				
				var viaWebMsgVal = "";
				viaWebMsgVal = document.getElementById("viaWebMsg").value;
				//KorManifestListDownloadBCImpl.java 의 searchDiscCYBondInfo에서 
				//upd_usr_id가 WEB 일 때 viaWebMsg 값 세팅
				document.getElementById("viaWebMsgDiv").innerHTML = viaWebMsgVal;
				
				afterRetrieve = true; // Add.  [CHM-201535756]
				seleteWhfWave();
				
				// Add. [CHM-201536700]
				// 변경 전 WHF Wave 값을 저장하기 위해서 , search할 떄 미리 변수에 저장함
				for(var i=0; i<10; i++){
					if(formObj.wharfage_wave[i].checked){
						formObj.bfr_whf_wave.value =formObj.wharfage_wave[i].value;
						break;	
					}
				} 
				
			}
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			if(validateForm(sheetObj,formObj,sAction)) {
				setBkgRtWhfExptCd();
				sheetObj.RowStatus(1) = "U";
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0333GS.do", FormQueryString(formObj));
				sheetObj.DoSearch("ESM_BKG_0333GS.do", FormQueryString(formObj) );
				ComOpenWait(false);  						
				
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); // 2015.07.15
			}
			break;
		case COMMAND01:			
			if(validateForm(sheetObj,formObj,sAction)) {
				// 우선 저장함
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				setBkgRtWhfExptCd();
				sheetObj.RowStatus(1) = "U";				 
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0333GS.do", FormQueryString(formObj));
				// A/R I/F 처리
				formObj.f_cmd.value = COMMAND01;
				sheetObj.RowStatus(1) = "U";				 
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0333GS.do", FormQueryString(formObj));
				sheetObj.DoSearch("ESM_BKG_0333GS.do", FormQueryString(formObj) );				
				ComOpenWait(false);  						
			}
			break;
		case COMMAND02: // btn_deleteWhf
			formObj.f_cmd.value = COMMAND02;
			setBkgRtWhfExptCd();
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RowStatus(1) = "U";				 
			
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0333GS.do", FormQueryString(formObj));
			//sheetObj.DoSearch("ESM_BKG_0333GS.do", FormQueryString(formObj) );	

			var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	 	   	
			var resultVal = ComGetEtcData(sXml, "err_msg");
	 	    	
			if (state == "S") {
				
				if(resultVal == "SUCCESS"){
	 	    		ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!

 	    		}else{
 	    			ComShowCodeMessage(resultVal);	// WHF doesn't exist at the charge data.
				}
				
			}else{
				ComShowMessage(ComResultMessage(sXml));
			}
			
			ComOpenWait(false);  
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); // 2015.07.15
			
			break;
	} // END SWITCH
}
 
/**
 * bkg_rt_whf_expt_cd 값 설정
 * @return
 */
function setBkgRtWhfExptCd()
{
	var formObj = document.form;
	
	for(var i=0; i < formObj.wharfage_wave.length; i++) {
		if (formObj.wharfage_wave[i].checked) formObj.bkg_rt_whf_expt_cd.value = formObj.wharfage_wave[i].value;
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = 0;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Flag|Seq.";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);

			//데이터속성          [ROW, COL,    DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,			70,		daCenter,	true,	"SEQ");
			CountPosition = 0;
		}
		break;
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 130;
			//전체 너비 설정
			SheetWidth = 200;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "Kind|Bonded Type|usr_id";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			
			//데이터속성          [ROW, COL,    DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"kind");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"bonded_type");
			
			var Row = 1;
			var arrayKind = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' ];
			var arrayBondedType = [ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
			                       '부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
			                       'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
			                       '자선', '타소 장치', 'Empty 컨테이너' ];
			for (var i=0; i < arrayKind.length; i++) {
				sheetObj.DataInsert();
				sheetObjects[1].CellValue(i+1, 0) = arrayKind[i];
				sheetObjects[1].CellValue(i+1, 1) = arrayBondedType[i];
			}
			sheetObjects[1].SelectCell(1,1);
			CountPosition = 0;
		}
		break;
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
 * 키보드 입력 처리 
 * @return
 */
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "num":
		ComKeyOnlyNumber(obj);
		break;
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
		else ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet(); break;
	case "engup":
		ComKeyOnlyAlphabet('upper'); break;
	case "engupnum":
		ComKeyOnlyAlphabet('uppernum'); break;
	case "engdn":
		ComKeyOnlyAlphabet('lower'); break;
	}
}  

/**
 * 레이어 더블클릭시 처리 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnDblClick(sheetObj,Row,Col)
{
	document.form.bd_tp_cd.value = sheetObj.CellValue(Row,"kind");
	document.all.layer1.style.display='none';
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
			SetColWidth("40|300");
			DropHeight = 110;
			ShowCol = 0;
			SetTitle("Kind|Bonded Type");
			MultiSelect = false;
			UseAutoComplete = true;
			UseEdit = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "A|입항전 사전수입신고", "A");
			InsertItem(cnt ++, "B|차상반출", "B");
			InsertItem(cnt ++, "C|부두 직통관", "C");
			InsertItem(cnt ++, "D|부두 보운", "D");
			InsertItem(cnt ++, "E|해상 간이 운송", "E");
			InsertItem(cnt ++, "F|부두 경우 간이 보운", "F");
			InsertItem(cnt ++, "G|보세운송", "G");
			InsertItem(cnt ++, "H|의왕 ICD", "H");
			InsertItem(cnt ++, "I|CY경유 간이보운", "I");
			InsertItem(cnt ++, "J|내장 통관", "J");
			InsertItem(cnt ++, "K|CFS 경유 간이 보운", "K");
			InsertItem(cnt ++, "L|CFS", "L");
			InsertItem(cnt ++, "M|자가 보세장치장", "M");
			InsertItem(cnt ++, "N|T/S", "N");
			InsertItem(cnt ++, "O|내품 T/S", "O");
			InsertItem(cnt ++, "P|자선", "P");
			InsertItem(cnt ++, "Q|타소 장치", "Q");
			InsertItem(cnt ++, "R|Empty 컨테이너", "R");
			InsertItem(cnt ++, "S|부두창고", "S");

			Code = "";
		}
		break; 	                   
	case "combo2":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("60|90");
			DropHeight = 110;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "S|Simple", "S");
			InsertItem(cnt ++, "C|Console", "C");
			InsertItem(cnt ++, "E|Empty", "E");

			Code = "S";
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
	form.bd_tp_cd.value = value;
}

/**
 * 콤보 1 키 입력시 처리 
 * @param comboObj
 * @param KeyCode
 * @param Shift
 * @return
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode!=8 &&  ( KeyCode < 35 || KeyCode > 46 ) ) return false;
	if (comboObj.Text.length > 0) return false;
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
	form.kr_cstms_bl_tp_cd.value = value;
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}   