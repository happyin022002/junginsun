/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0024.js
*@FileTitle : W/O Preview화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-2-3
*@LastModifier : Bong-jun
*@LastVersion : 1.72
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.72 N200901220021-[EDI] 구주 SK155153 IFTMIN 개발 요청
* 1.74 N200902270200 - [TRS] W/O ISS TP관련 보완 요청
* 1.75 N200903270090   [TRS EDI] AFTT 990 개발 및 204 보완 요청 
* 1.76 N200902090090 [TRS] 미주 W/O Form의 문구 삭제요청
* 1.77 N200904300130 - [EDI-TRS] DANSER (S/P # 175368) Work order EDI (IFTMIN) 개발 요청
* 1.19 N200904300130 - [EDI-TRS] VLCBB + (S/P # 120759,120852,121403,125140,166660,168242,172121,143046,166697,120849,181404) Work order EDI (IFTMIN) 개발 요청
* 1.21 2010.11.29 이재위 [CHM-201006281-01] [TRS] VLCBB EDI(IFTMIN) 개발 
* 1.26 2011.03.31 손은주 [CHM-201109814-01] [TRS] W/O EDI 사용을 위한 setting 요청 (115133)
* 1.29 2011.04.13 김영철 [CHM-201110137-01] [TRS] W/O EDI 환경 구현 요청 (114745)
* 1.31 2011.07.11 최종혁 [CHM-201112197] [TRS] 구주지역 W/O EDI setting 요청  (184332)
* 1.32 2011.11.17 민정호 [CHM-201114481] [TRS] W/O preview 상에 표현가능한 e-mail, fax 정보 room 확장요청
* 1.33 2011.11.29 민정호 [CHM-201114404] [TRS] 구주 S/P EDI F/F receiver ID coding 요청
* 2013.05.06 조인영 [CHM-201324442] [TRS] wo preview 화면에서 e-Mail default 처리 
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. 
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0024 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0024() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var confirmAllFlg = "N";
var confirmIndex = 0;
var confirmCount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];
	 var rdObject = rdObjects[0];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_reset":
				resetForm(formObject, sheetObject);
			break;

			case "btn_print":
				rdObjects[0].PrintDialog();
			break;

			case "btn_confirm":
				
				// CHM-201536387 ALPS Auth 사후 결재 기능 개발
				if(formObject.isInquiry.value == 'Y') return;
				
				var comboObj = document.wo_group_no;
				if(comboObj.Code == '') return;
				if(sheetObject.CellValue(comboObj.Text, 'ibcheck') == 1) {
					ComShowCodeMessage('TRS90136');
					return;
				}
				
				if(!chkEmailCount(formObject)){
					return;
				}

				var nego_flg = 0;
				var etc_addi_flg = 0;
				var authorization_flg = false;
				var spotBidFlg = false;

				var msg_auth = " SCG_GRP_SEQ :  "+formObject.SCG_GRP_SEQ.value+"      ROWCOUNT : " +sheetObjects[0].RowCount+ "\n ";
				for(var i=0; i<sheetObjects[0].RowCount; i++)
				{
					//alert(comboObj.Code + " : " + comboObj.Text + " : " + sheetObjects[0].CellValue(i+1,'wo_iss_no'));
					if(sheetObjects[0].CellValue(i+1,'wo_iss_no') == comboObj.Code) {
						//msg_auth += "WO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] SO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] NEGO_FLG ["+sheetObjects[0].CellValue(i+1,'nego_flg')+"] ADD_FLG ["+sheetObjects[0].CellValue(i+1,'addi_flg')+"] \n";
						msg_auth += "WO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] NEGO_FLG ["+sheetObjects[0].CellValue(i+1,'nego_flg')+"] ADD_FLG ["+sheetObjects[0].CellValue(i+1,'addi_flg')+"] \n";
						
						if(sheetObjects[0].CellValue(i+1,'nego_flg') == "Y"){
							nego_flg++;
						}
						
						if(sheetObjects[0].CellValue(i+1,'addi_flg') == "Y"){
							etc_addi_flg++;
						}
						
						if(sheetObjects[0].CellValue(i+1,'spot_bid_flg') == "Y"){
							spotBidFlg = true;
						}
					}
				}

				// authorization
				for(var i=0; i<sheetObjects[2].RowCount; i++)
				{
					//alert(sheetObjects[2].CellValue(i+1,'sub_sys_cd') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_no') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_btn_id') +" : "+ sheetObjects[2].CellValue(i+1,'btn_use_flg') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_fld_id') +" : "+ nego_flg +" : "+ etc_addi_flg)
					if(sheetObjects[2].CellValue(i+1,'sub_sys_cd') == "TRS" && sheetObjects[2].CellValue(i+1,'pgm_no') == "ESD_TRS_0024" && 
							sheetObjects[2].CellValue(i+1,'pgm_btn_id') == "btn_confirm" && sheetObjects[2].CellValue(i+1,'btn_use_flg') == "Y"){
						// nego_amt, Confirm, nego_flg
						if(sheetObjects[2].CellValue(i+1,'pgm_fld_id') == "nego_amt" && nego_flg > 0 && sheetObjects[2].CellValue(i+1,'fld_use_flg') == "Y"){
							authorization_flg = true;
						}
						
						// etc_add_amt, Confirm, etc_addi_flg
						if(sheetObjects[2].CellValue(i+1,'pgm_fld_id') == "etc_add_amt" && etc_addi_flg > 0 && sheetObjects[2].CellValue(i+1,'fld_use_flg') == "Y"){
							authorization_flg = true;
						}
					}
				}

				if(authorization_flg && !spotBidFlg){
					var param = "?ofc_cd="+formObject.FORM_USR_OFC_CD.value+"&sub_sys_cd=TRS&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no=ESD_TRS_0024&auth_apro_tp_cd=AF&auth_pgm_btn_seq=1";
					ComOpenPopup('/hanjin/COM_APR_0T1.do' + param, 915, 522, '', 'none', true);

					if(document.form.AUTH_APRO_RQST_NO.value == undefined || document.form.AUTH_APRO_RQST_NO.value == null ||
							ComTrim(document.form.AUTH_APRO_RQST_NO.value) == '' || ComTrim(document.form.AUTH_APRO_RQST_NO.value).length != 30) return;
				}

				if(formObject.isInquiry.value != 'Y'){
					
					if( !confirm(ComGetMsg('TRS90447', 'Confirm')) ) return false;

					sheetObject.WaitImageVisible = false;
					//ComOpenWait(true); //레이어형 대기 이미지 표시
					doActionIBSheet(sheetObject,formObject,IBSAVE);
				}
				
				// 멀티건의 Confirm 을 위해서 auth_apro_rqst_no 값 삭제
				document.form.AUTH_APRO_RQST_NO.value = '';
			break;
			
			case "btn_confirm_all":
				
				// CHM-201536387 ALPS Auth 사후 결재 기능 개발
				if(formObject.isInquiry.value == 'Y') return;
				
				var comboObj = document.wo_group_no;
				if(comboObj.Code == '') return;
				if(sheetObject.CellValue(comboObj.Text, 'ibcheck') == 1) {
					ComShowCodeMessage('TRS90136');
					return;
				}
				
				if(!chkEmailCount(formObject)){
					return;
				}
				
				var nego_flg = 0;
				var etc_addi_flg = 0;
				var authorization_flg = false;
				var comboObj = document.wo_group_no;

				var msg_auth = " SCG_GRP_SEQ :  "+formObject.SCG_GRP_SEQ.value+"      ROWCOUNT : " +sheetObjects[0].RowCount+ "\n ";
				for(var i=0; i<sheetObjects[0].RowCount; i++)
				{
					//msg_auth += "WO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] SO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] NEGO_FLG ["+sheetObjects[0].CellValue(i+1,'nego_flg')+"] ADD_FLG ["+sheetObjects[0].CellValue(i+1,'addi_flg')+"] \n";
					msg_auth += "WO ["+sheetObjects[0].CellValue(i+1,'trsp_wo_ofc_cty_cd')+sheetObjects[0].CellValue(i+1,'trsp_wo_seq')+"] NEGO_FLG ["+sheetObjects[0].CellValue(i+1,'nego_flg')+"] ADD_FLG ["+sheetObjects[0].CellValue(i+1,'addi_flg')+"] \n";
					
					if(sheetObjects[0].CellValue(i+1,'nego_flg') == "Y"){
						nego_flg++;
					}
					
					if(sheetObjects[0].CellValue(i+1,'addi_flg') == "Y"){
						etc_addi_flg++;
					}
					
					if(sheetObjects[0].CellValue(i+1,'spot_bid_flg') == "Y"){
						spotBidFlg = true;
					}
				}

				// authorization
				for(var i=0; i<sheetObjects[2].RowCount; i++)
				{
					//alert(sheetObjects[2].CellValue(i+1,'sub_sys_cd') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_no') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_btn_id') +" : "+ sheetObjects[2].CellValue(i+1,'btn_use_flg') +" : "+ sheetObjects[2].CellValue(i+1,'pgm_fld_id') +" : "+ nego_flg +" : "+ etc_addi_flg)
					if(sheetObjects[2].CellValue(i+1,'sub_sys_cd') == "TRS" && sheetObjects[2].CellValue(i+1,'pgm_no') == "ESD_TRS_0024" && 
							sheetObjects[2].CellValue(i+1,'pgm_btn_id') == "btn_confirm" && sheetObjects[2].CellValue(i+1,'btn_use_flg') == "Y"){
						// nego_amt, Confirm, nego_flg
						if(sheetObjects[2].CellValue(i+1,'pgm_fld_id') == "nego_amt" && nego_flg > 0 && sheetObjects[2].CellValue(i+1,'fld_use_flg') == "Y"){
							authorization_flg = true;
						}
						
						// etc_add_amt, Confirm, etc_addi_flg
						if(sheetObjects[2].CellValue(i+1,'pgm_fld_id') == "etc_add_amt" && etc_addi_flg > 0 && sheetObjects[2].CellValue(i+1,'fld_use_flg') == "Y"){
							authorization_flg = true;
						}
					}
				}

				if(authorization_flg && !spotBidFlg){
					var param = "?ofc_cd="+formObject.FORM_USR_OFC_CD.value+"&sub_sys_cd=TRS&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no=ESD_TRS_0024&auth_apro_tp_cd=AF&auth_pgm_btn_seq=2";
					param += "&auth_rqst_knt="+comboObj.GetCount();
					ComOpenPopup('/hanjin/COM_APR_0T1.do' + param, 915, 522, '', 'none', true);
					if(document.form.AUTH_APRO_RQST_NO.value == undefined || document.form.AUTH_APRO_RQST_NO.value == null ||
							ComTrim(document.form.AUTH_APRO_RQST_NO.value) == '') return;
				}

				if(formObject.isInquiry.value != 'Y'){
					sheetObject.WaitImageVisible = false;
//					var comboObj = document.wo_group_no;
					
					if(comboObj.GetCount() > 0){

						if( !confirm(ComGetMsg('TRS90447', 'Confirm')) ) return false;

						confirmAllFlg ="Y";
						confirmCount = comboObj.GetCount();
						
						/* 20140730. W/O Preview의 Print Out 기능 수정
						var prn_flg ="";
						if (formObject.WO_PRN_USE_FLG.checked){
							prn_flg = "Y";
						}else{
							prn_flg = "N";
						}
						*/
						
						// 해당건만 AUTH_APRO_RQST_NO 값 입력을위해서
						var authAproRqstNo = document.form.AUTH_APRO_RQST_NO.value;
	         	        var arrAuthAproRqstNo = authAproRqstNo.split("|");
						
						for(var i=0; i<comboObj.GetCount();i++){
							comboObj.index = i;	
							confirmIndex = i+1;
							
							/* 20140730. W/O Preview의 Print Out 기능 수정
							if(prn_flg=="Y"){
								formObject.WO_PRN_USE_FLG.checked =true;
							}else{
								formObject.WO_PRN_USE_FLG.checked =false;
							}
							*/
							
							// 해당건만 AUTH_APRO_RQST_NO 처리
							if(authorization_flg == true && sheetObjects[0].CellValue(i+1,'nego_flg') == "Y" || sheetObjects[0].CellValue(i+1,'addi_flg') == "Y"){
//								document.form.AUTH_APRO_RQST_NO.value = authAproRqstNo;
								document.form.AUTH_APRO_RQST_NO.value = arrAuthAproRqstNo[i];
								if(ComTrim(document.form.AUTH_APRO_RQST_NO.value).length != 30) return;
							}else{
								document.form.AUTH_APRO_RQST_NO.value = "";
							}
							doActionIBSheet(sheetObject,formObject,IBSAVE);
						}
						confirmAllFlg ="N";
						confirmCount = 0;
						confirmIndex = 0;
					}	

				}
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	   //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	if(init_searchStr != undefined && init_searchStr != ''){
		if(document.form.issued.value == 'N') document.form.f_cmd.value = SEARCH01;
		else document.form.f_cmd.value = SEARCH02;
		sheetObjects[0].DoSearch4Post("ESD_TRS_0024GS.do", init_searchStr+'&'+TrsFrmQryString(document.form));
	}else if(init_wo_searchStr != undefined && init_wo_searchStr != ''){
		sheetObjects[1].DoSearch4Post("ESD_TRS_0025GS.do", init_wo_searchStr+'&f_cmd='+SEARCH02);
		document.form.f_cmd.value = SEARCH02;
		var queryStr = sheetObjects[1].GetSaveString(true, false);
		sheetObjects[0].DoSearch4Post("ESD_TRS_0024GS.do", queryStr+'&'+TrsFrmQryString(document.form));
	}

	var comboObj = document.wo_group_no;

	comboObj.DropHeight = 200; 
	comboObj.SetColAlign("left");
	comboObj.RemoveAll();

	for(var i=0; i<sheetObjects[0].RowCount; i++)
	{
		comboObj.InsertItem(i, i+1, sheetObjects[0].CellValue(i+1,'wo_iss_no'));
	}
	document.getElementById("wo_group_no_cnt").innerHTML  = sheetObjects[0].RowCount;

	rdInit(rdObjects[0]);
	document.wo_group_no.Index = 0;

	//html컨트롤 이벤트초기화
	initControl();	

	sheetObjects[2].DoSearch4Post("COM_APR_0S1GS.do", 'f_cmd=&ofc_cd='+document.form.FORM_USR_OFC_CD.value+'&sub_sys_cd=TRS&pgm_no=ESD_TRS_0024&auth_apro_tp_cd=Atfer');
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	   case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
		   		style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(35, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "||";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,   30,   daCenter,  true,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "wo_prv_grp_seq", false,  "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "wo_iss_no",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "wo_fmt_tp_cd",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "wo_iss_sts_cd",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "vndr_seq",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "trsp_crr_mod_cd",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "trsp_wo_ofc_cty_cd",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "trsp_wo_seq",  false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "vndr_lgl_eng_nm",  false,      "",      dfNone,      0,     false,       false,   200, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "cnt",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "conti_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "trsp_bnd_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "trsp_cost_dtl_mod_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   50,   daCenter,  true,  "pre_dispatch",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "wo_instr_rmk",		false,      "",      dfNone,      0,     false,       false,   2000, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "wo_edi_use_flg",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "inter_use_flg",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "fax1",		false,      "",      dfNone,      0,     false,       false,   100, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "fax2",		false,      "",      dfNone,      0,     false,       false,   100, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "fax3",		false,      "",      dfNone,      0,     false,       false,   100, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "eml1",		false,      "",      dfNone,      0,     false,       false,   200, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "eml2",		false,      "",      dfNone,      0,     false,       false,   200, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "eml3",		false,      "",      dfNone,      0,     false,       false,   200, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "to_nod_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "fm_nod_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "dor_nod_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtData,   100,   daCenter,  true,  "via_nod_cd",		false,      "",      dfNone,      0,     false,       false,   15, false, true);
				InitDataProperty(0, cnt++ , dtStatus, 300,   daCenter,  true,  "ibflag");
				InitDataProperty(0, cnt++ , dtData,	  100,   daCenter,  true,  "wo_dtl_use_flg");
				InitDataProperty(0, cnt++ , dtData,	  100,   daCenter,  true,  "edi_rcvr_nm_use_flg");
				InitDataProperty(0, cnt++ , dtData,	  100,   daCenter,  true,  "skd_dir_cd");
				InitDataProperty(0, cnt++ , dtData,	  50,   daCenter,  true,  "nego_flg");
				InitDataProperty(0, cnt++ , dtData,	  50,   daCenter,  true,  "addi_flg");
				InitDataProperty(0, cnt++ , dtData,	  50,   daCenter,  true,  "spot_bid_flg");
			} 
			break;

		case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "ibflag|trsp_so_ofc_cty_cd|trsp_so_seq|wo_cxl_flg|dtn_use_flg|wo_bl_no_iss_flg|so_delt_flg";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  30,   daCenter,   true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "trsp_so_seq");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "wo_cxl_flg");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "dtn_use_flg");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "wo_bl_no_iss_flg");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "so_delt_flg");
		   }
			break;
			
		case 3:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTableAuth.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "ibflag|sub_sys_cd|pgm_no|auth_pgm_btn_seq|auth_apro_tp_cd|pgm_btn_id|pgm_btn_nm|btn_use_flg|pgm_fld_id|fld_use_flg";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  50,   daCenter,   true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,    50,   daCenter,   true,    "sub_sys_cd");
				InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_no");
				InitDataProperty(0, cnt++ , dtData,    50,   daCenter,   true,    "auth_pgm_btn_seq");
				InitDataProperty(0, cnt++ , dtData,    50,   daCenter,   true,    "auth_apro_tp_cd");
				InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_btn_id");
				InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_btn_nm");
				InitDataProperty(0, cnt++ , dtData,    50,   daCenter,   true,    "btn_use_flg");
				InitDataProperty(0, cnt++ , dtData,    100,   daCenter,   true,    "pgm_fld_id");
				InitDataProperty(0, cnt++ , dtData,    50,   daCenter,   true,    "fld_use_flg");
		   }
			break;
	}
}

/**
 * 그룹핑된 invoice를 선택할때 조건에 맞는 mrd파일을 열어서 보여준다.
 */
function rdOpen(rdObj, formObj){
	var comboObj = document.wo_group_no;
	if(comboObj.Code == '') return;
	var wo_format = sheetObjects[0].CellValue(comboObj.Text,'wo_fmt_tp_cd');
	var wo_page = '';
	var suffix = '_S';    //Detail Form check가 안되었을때 일때 사용함
//	var prefix = 'Letter_';
	var prefix = 'USA_';
	var prefix_a = 'ASIA_';
	var prefix_e = 'EUR_';
	var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked?'Y':'N');
	var PRE_DIS_USE_FLG_VALUE = (formObj.PRE_DIS_USE_FLG.checked?'Y':'N');

	if(wo_format == 'NC') {
		wo_page = 'WO_NORMAL';
//		prefix_a = 'ASIA_';
//		prefix_e = 'EUR_';
	}
	else if(wo_format == 'CC') wo_page = 'WO_COMBINED1';
	else if(wo_format == 'IB') wo_page = 'WO_COMBINED2_1';
	else if(wo_format == 'CY') wo_page = 'WO_COMBINED2_2';
	else if(wo_format == 'CM') wo_page = 'WO_COMBINED2_3';
	else if(wo_format == 'MM'){
		wo_page = 'WO_EMPTY';
		suffix = '';
//		prefix = '';
//		prefix_a = '';
//		prefix_e = '';
	}

	if(!formObj.WO_DTL_USE_FLG.checked) wo_page += suffix;
	if(sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'M') {
		if(wo_format == 'NC' || wo_format == 'MM') {
			wo_page = prefix + wo_page;
		} else {
			wo_page = 'Letter_' + wo_page;
		}	
	} 
	// conti_cd == M 미주일때
	// NC ==> USA_WO_NORMAL
	// MM ==> USA_WO_EMPTY
	// CC ==> Letter_WO_COMBINED1     -->   ofc_cd가 CHIBB일때 ATLSC의 OFC_ADDR와 연관된  RD FORM 인데 ATLSC OFFICE 삭제가 되어 사용되는지 확인 필요함
	// IB ==> Letter_WO_COMBINED2_1   -->   ofc_cd가 CHIBB일때 ATLSC의 OFC_ADDR와 연관된  RD FORM 인데 ATLSC OFFICE 삭제가 되어 사용되는지 확인 필요함
	// CY ==> Letter_WO_COMBINED2_2   -->   ofc_cd가 CHIBB일때 ATLSC의 OFC_ADDR와 연관된  RD FORM 인데 ATLSC OFFICE 삭제가 되어 사용되는지 확인 필요함
	// CM ==> Letter_WO_COMBINED2_3   -->   ofc_cd가 CHIBB일때 ATLSC의 OFC_ADDR와 연관된  RD FORM 인데 ATLSC OFFICE 삭제가 되어 사용되는지 확인 필요함
	else if (sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'A') wo_page = prefix_a + wo_page;
	else if (sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'E') wo_page = prefix_e + wo_page;
	
	var rdParam = '/rp ['+RT_DP_USE_FLG_VALUE+']';
	rdParam += '['+sheetObjects[0].CellValue(comboObj.Text,'wo_prv_grp_seq')+']';
	rdParam += '['+sheetObjects[0].CellValue(comboObj.Text,'wo_iss_no')+']';
	rdParam += '['+formObj.FORM_USR_OFC_CD.value+']';
	rdParam += '['+formObj.FORM_CRE_USR_ID.value+']';
	rdParam += '['+PRE_DIS_USE_FLG_VALUE+']';
	rdParam += '['+wo_page+']';
	rdParam += '['+sheetObjects[0].CellValue(comboObj.Text, 'conti_cd')+']';

	//formObj.wo_rmk.value = wo_page+'.mrd'+' '+rdParam;
	rdObj.FileOpen(RD_path+'apps/alps/esd/trs/workordermanage/workorderpreview/report/'+wo_page+'.mrd', RDServer+rdParam+"/rfonttype60");
}

function setWoDtlUseFlg(obj){
	var sheetObj = sheetObjects[0];
	var comboObj = document.wo_group_no;
	if(obj.checked){
		sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') = '1';
	}else{
		sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') = '2';
	}
}

/**
 * rd 환경을 초기화한다.
 */
function rdInit(rdObj){
	rdObj.AutoAdjust = true;
//	rdObj.HideToolbar();
	rdObj.SetSaveDialogEx("", "", "pdf", "pdf");
	rdObj.DisableToolbar(13);
	rdObj.DisableToolbar(14);
	rdObj.DisableToolbar(16);
	rdObj.DisableToolbar(17);
	rdObj.HideStatusbar();
	rdObj.ViewShowMode(2);
	rdObj.setbackgroundcolor(255,255,255);
	rdObj.SetPageLineColor(255,255,255);
}


/**
 * invoice 그룹을 선택할때 발생되는 이벤트
 */
function wo_group_no_OnChange(comboObj, Index, Text){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	// 미주 Full Container, TD일 경우 Pre-Dispatch 체크
	if( sheetObj.CellValue(comboObj.Text, 'conti_cd') == 'M' 
		&& sheetObj.CellValue(comboObj.Text, 'wo_fmt_tp_cd') != 'MM' 
		&& sheetObj.CellValue(comboObj.Text, 'trsp_crr_mod_cd').indexOf('T') >= 0 ) {
		formObj.PRE_DIS_USE_FLG.checked = true;
	}else{
		formObj.PRE_DIS_USE_FLG.checked = false;
	}

	setEDIform(sheetObj, formObj);

	if(sheetObj.CellValue(comboObj.Text, 'ibcheck') == 1) {
		ComShowCodeMessage('TRS90136');
	}

	if(sheetObjects[0].CellValue(comboObj.Text, 'inter_use_flg') == 'Y'){
		formObj.INTER_USE_FLG.checked = true;
	}else{
		formObj.INTER_USE_FLG.checked = false;
	}

	if((sheetObj.CellValue(comboObj.Text, 'conti_cd') == 'E'
		&& sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') == '')
			|| sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') == '1'){
		formObj.WO_DTL_USE_FLG.checked = true;
		sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') = '1';
	}else{
		formObj.WO_DTL_USE_FLG.checked = false;
		sheetObj.CellValue(comboObj.Text, 'wo_dtl_use_flg') = '0';
	}

	formObj.WO_RMK.value = sheetObjects[0].CellValue(comboObj.Text, 'wo_instr_rmk');
	formObj.WO_N1ST_FAX_NO.value = sheetObjects[0].CellValue(comboObj.Text, 'fax1');
	formObj.WO_N2ND_FAX_NO.value = sheetObjects[0].CellValue(comboObj.Text, 'fax2');
	formObj.WO_N3RD_FAX_NO.value = sheetObjects[0].CellValue(comboObj.Text, 'fax3');
	formObj.WO_N1ST_EML.value = sheetObjects[0].CellValue(comboObj.Text, 'eml1');
	formObj.WO_N2ND_EML.value = sheetObjects[0].CellValue(comboObj.Text, 'eml2');
	formObj.WO_N3RD_EML.value = sheetObjects[0].CellValue(comboObj.Text, 'eml3');

	rdOpen(rdObjects[0], document.form);
}

function setRmk(obj){
	var comboObj = document.wo_group_no;
	var checkObj = document.form.Apply_To_All;
	sheetObjects[0].CellValue2(comboObj.Text, 'wo_instr_rmk') = obj.value;
	clickApplyToAll(checkObj);
}

function setFax1(obj){
	var comboObj = document.wo_group_no;
	sheetObjects[0].CellValue2(comboObj.Text, 'fax1') = obj.value;
}

function setFax2(obj){
	var comboObj = document.wo_group_no;
	sheetObjects[0].CellValue2(comboObj.Text, 'fax2') = obj.value;
}

function setFax3(obj){
	var comboObj = document.wo_group_no;
	sheetObjects[0].CellValue2(comboObj.Text, 'fax3') = obj.value;
}

function setEml1(obj){
	var comboObj = document.wo_group_no;
	var eMailchk = new RegExp('^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,6}\\b');
	var aRray = new Array();
	var passFlag = 'T';
	if( obj.value.split(',').length > 1 ) {
		aRray = obj.value.split(',');
		for( var e = 0; e < aRray.length; e++ ) {
			if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
				ComShowCodeMessage('TRS90525');
				passFlag = 'F';
			}
		}
	} else if( obj.value.split(';').length > 1 ) {
		aRray = obj.value.split(';');
		for( var e = 0; e < aRray.length; e++ ) {
			if(!eMailchk.test(aRray[e]) && aRray[e] != '') {
				ComShowCodeMessage('TRS90525');
				passFlag = 'F';
			}
		}
	} else {
		if(!eMailchk.test(obj.value) && obj.value != '') {
			ComShowCodeMessage('TRS90525');
			passFlag = 'F';
		}
	}
	if( passFlag == 'T' ) {
		sheetObjects[0].CellValue2(comboObj.Text, 'eml1') = obj.value;
	}
}

function setEml2(obj){
	var comboObj = document.wo_group_no;
	sheetObjects[0].CellValue2(comboObj.Text, 'eml2') = obj.value;
}

function setEml3(obj){
	var comboObj = document.wo_group_no;
	sheetObjects[0].CellValue2(comboObj.Text, 'eml3') = obj.value;
}
/*
 * 1.72 N200901220021-[EDI] 구주 SK155153 IFTMIN 개발 요청
 * 1.74 N200902270200 - [TRS] W/O ISS TP관련 보완 요청
 */
/**
 * EDI인지 확인하여 조건에 맞게 FORM을 세팅한다.
 * 1.76 N200902090090 [TRS] 미주 W/O Form의 문구 삭제요청
 */
function setEDIform(sheetObj, formObj){	
	var comboObj = document.wo_group_no;
	var vndr_seq = sheetObj.CellValue(comboObj.Text, 'vndr_seq');
	var trsp_cost_dtl_mod_cd = sheetObj.CellValue(comboObj.Text, 'trsp_cost_dtl_mod_cd');
	var fm_nod_cd = sheetObj.CellValue(comboObj.Text, 'fm_nod_cd');
	var to_nod_cd = sheetObj.CellValue(comboObj.Text, 'to_nod_cd');
	var trsp_bnd_cd = sheetObj.CellValue(comboObj.Text, 'trsp_bnd_cd');
	var trsp_wo_ofc_cty_cd = sheetObj.CellValue(comboObj.Text, 'trsp_wo_ofc_cty_cd');
	var skd_dir_cd = sheetObj.CellValue(comboObj.Text, 'skd_dir_cd');
	
	if(sheetObj.CellValue(comboObj.Text, 'wo_edi_use_flg') == 'Y' &&
		(	
			(
				vndr_seq == '100253' &&
				(
					trsp_cost_dtl_mod_cd == 'TS' ||
					trsp_cost_dtl_mod_cd == 'LS' ||
					trsp_cost_dtl_mod_cd == 'DR' ||
					(
						trsp_cost_dtl_mod_cd == 'CY' &&
						(
							(
								fm_nod_cd.substring(0,5) == 'KRPUS' &&
								to_nod_cd.substring(0,5) == 'KRYAN'
							) ||
							(
								fm_nod_cd.substring(0,5) == 'KRYAN' &&
								to_nod_cd.substring(0,5) == 'KRPUS'
							)
						)
					)

				)
			) ||
			(
				(
					vndr_seq == '105121' ||
					vndr_seq == '155153' ||
					vndr_seq == '105147' ||
					vndr_seq == '105055' ||
					vndr_seq == '135366' ||
					vndr_seq == '115133'
				) &&
				trsp_cost_dtl_mod_cd == 'DR'
			)
		)	
	) 
	{
		formObj.WO_EDI_USE_FLG.disabled = false;
		formObj.WO_EDI_USE_FLG.checked = true;
		// 20140730. W/O Preview의 Print Out 기능 수정
		//formObj.WO_PRN_USE_FLG.checked = false;
		formObj.WO_EML_USE_FLG.checked = false;
		formObj.WO_FAX_USE_FLG.checked = false;
		formObj.WO_PRN_USE_FLG.disabled = true;
		formObj.WO_EML_USE_FLG.disabled = true;
		formObj.WO_FAX_USE_FLG.disabled = true;
	}else if(sheetObj.CellValue(comboObj.Text, 'conti_cd') == 'M' && 
				sheetObj.CellValue(comboObj.Text, 'wo_edi_use_flg') == 'Y' &&
				sheetObj.CellValue(comboObj.Text, 'edi_rcvr_nm_use_flg') == 'Y' ){
  /* 1.75 N200903270090 - [TRS EDI] AFTT 990 개발 및 204 보완 요청 */
//	 && (trsp_cost_dtl_mod_cd != 'CF' &&trsp_cost_dtl_mod_cd != 'CN' && trsp_cost_dtl_mod_cd != 'ER' ) ){
		formObj.WO_EDI_USE_FLG.disabled = false;
		formObj.WO_EDI_USE_FLG.checked = true;
		formObj.WO_PRN_USE_FLG.disabled = false;
		formObj.WO_EML_USE_FLG.disabled = false;
		formObj.WO_FAX_USE_FLG.disabled = false;
 /* 1.77 N200904300130 - [EDI-TRS] DANSER (S/P # 175368) Work order EDI (IFTMIN) 개발 요청*/
	}else if(vndr_seq == '175368' || vndr_seq == '114745' || vndr_seq == '184332' || vndr_seq == '157955'){
		formObj.WO_EDI_USE_FLG.disabled = false;
		formObj.WO_EDI_USE_FLG.checked = true;
		//20140730. W/O Preview의 Print Out 기능 수정
		//formObj.WO_PRN_USE_FLG.checked = false;
		formObj.WO_PRN_USE_FLG.disabled = false;
		formObj.WO_EML_USE_FLG.disabled = false;
		formObj.WO_FAX_USE_FLG.disabled = false;
		if( skd_dir_cd == 'E' && vndr_seq == '114745' ) {
			formObj.WO_EML_USE_FLG.checked = true;
		}
	}else if(sheetObj.CellValue(comboObj.Text, 'wo_edi_use_flg') == 'Y' &&
			(	
				(
					/* 1.19 N200904300130 - [TRS-EDI] VLCBB Work order EDI 개발 요청 - S/P 추가 */
					vndr_seq == '120759' ||
					vndr_seq == '120852' ||
					vndr_seq == '121403' ||
					vndr_seq == '125140' ||
					vndr_seq == '166660' ||
					vndr_seq == '168242' ||
					vndr_seq == '172121' ||
					vndr_seq == '143046' ||
					vndr_seq == '166697' ||
					vndr_seq == '120849' ||
					vndr_seq == '181404' ||
					vndr_seq == '186225' ||
					vndr_seq == '186226' 
				) &&
				trsp_cost_dtl_mod_cd == 'DR'
			)	
	){
		formObj.WO_EDI_USE_FLG.disabled = false;
		formObj.WO_EDI_USE_FLG.checked = true;
		//20140730. W/O Preview의 Print Out 기능 수정
		//formObj.WO_PRN_USE_FLG.checked = false;
		formObj.WO_EML_USE_FLG.checked = false;
		formObj.WO_FAX_USE_FLG.checked = false;
		formObj.WO_PRN_USE_FLG.disabled = false;
		formObj.WO_EML_USE_FLG.disabled = false;
		formObj.WO_FAX_USE_FLG.disabled = false;
	}else{
		// CHM-201323085 : 100276 (협동통운) 일 때 W/O Preview 화면에 E-mail & Fax 체크박스에 자동check 되도록 로직 변경
		if( vndr_seq == '100276' ) {
			formObj.WO_EDI_USE_FLG.disabled = true;
			formObj.WO_EDI_USE_FLG.checked = false;
			//20140730. W/O Preview의 Print Out 기능 수정
			//formObj.WO_PRN_USE_FLG.checked = false;
			formObj.WO_PRN_USE_FLG.disabled = false;
			formObj.WO_EML_USE_FLG.checked = true;
			formObj.WO_EML_USE_FLG.disabled = false;
			formObj.WO_FAX_USE_FLG.checked = true;
			formObj.WO_FAX_USE_FLG.disabled = false;
		} else {
			formObj.WO_EDI_USE_FLG.disabled = true;
			formObj.WO_EDI_USE_FLG.checked = false;
			//20140730. W/O Preview의 Print Out 기능 수정
			//formObj.WO_PRN_USE_FLG.checked = true;
			formObj.WO_PRN_USE_FLG.disabled = false;
			formObj.WO_EML_USE_FLG.disabled = false;
			formObj.WO_FAX_USE_FLG.disabled = false;
		}
	}
}

/**
 * PREDISPATCH를 클릭할때의 값 저장
 */
function clickPreDisPatch(obj){
	var sheetObj = sheetObjects[0];
	var comboObj = document.wo_group_no;

	if( obj.checked )
	sheetObj.CellValue2(comboObj.Text, 'pre_dispatch') = 'Y';
	else
	sheetObj.CellValue2(comboObj.Text, 'pre_dispatch') = 'N';
	rdOpen(rdObjects[0], document.form);
}

/**
 * Apply_To_All 클릭할때의 값 저장
 */
function clickApplyToAll(obj){
	var sheetObj = sheetObjects[0];
	var str_WO_RMK = document.form.WO_RMK.value;
	
	if( obj.checked ){
		for(var i=1;i<sheetObj.RowCount+1;i++){
			
			sheetObj.CellValue2(i, 'wo_instr_rmk') = str_WO_RMK ;
		}
	}
}

/**
 * INTERNAL_USE_FLG를 클릭할때의 값 저장
 */
function clickInterUse(obj){
	var sheetObj = sheetObjects[0];
	var comboObj = document.wo_group_no;

	if( obj.checked )
	sheetObj.CellValue2(comboObj.Text, 'inter_use_flg') = 'Y';
	else
	sheetObj.CellValue2(comboObj.Text, 'inter_use_flg') = 'N';
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	try {
		switch(sAction) {
		   case IBSAVE:      // 입력
				var comboObj = document.wo_group_no;
				if(comboObj.Code == '') return;
				if(sheetObj.CellValue(comboObj.Text, 'ibcheck') == 1) {
					ComShowCodeMessage('TRS90136');
					return;
				}

				ComOpenWait(true); //레이어형 대기 이미지 표시
				if(formObj.issued.value == 'Y')	formObj.f_cmd.value = MULTI01;
				else formObj.f_cmd.value = ADD;
				formObj.WO_FMT_TP_CD.value = sheetObj.CellValue(comboObj.Text, 'wo_fmt_tp_cd');
				formObj.WO_PRV_GRP_SEQ.value = sheetObj.CellValue(comboObj.Text, 'wo_prv_grp_seq');
				formObj.WO_ISS_NO.value = sheetObj.CellValue(comboObj.Text, 'wo_iss_no');

				formObj.WO_ISS_STS_CD.value = sheetObj.CellValue(comboObj.Text, 'wo_iss_sts_cd');
				formObj.WO_VNDR_SEQ.value = sheetObj.CellValue(comboObj.Text, 'vndr_seq');
				formObj.TRSP_WO_OFC_CTY_CD.value = sheetObj.CellValue(comboObj.Text, 'trsp_wo_ofc_cty_cd');
				formObj.TRSP_WO_SEQ.value = sheetObj.CellValue(comboObj.Text, 'trsp_wo_seq');
				formObj.EMAIL_CONTENTS.value = getEmailContents(sheetObj.CellValue(comboObj.Text, 'vndr_lgl_eng_nm'));
				formObj.TRSP_CRR_MOD_CD.value = sheetObj.CellValue(comboObj.Text, 'trsp_crr_mod_cd');
				formObj.TRSP_COST_DTL_MOD_CD.value = sheetObj.CellValue(comboObj.Text, 'trsp_cost_dtl_mod_cd');
				formObj.EMAIL_TITLE.value = 'SM Line Work Order to '+'\"'+sheetObj.CellValue(comboObj.Text, 'vndr_seq')+'\" - ';
				formObj.CONTI_CD.value = sheetObj.CellValue(comboObj.Text, 'conti_cd');

				var wo_format = sheetObjects[0].CellValue(comboObj.Text,'wo_fmt_tp_cd');
				var wo_page = '';

				var suffix = '_S';
//				var prefix = 'Letter_';
				var prefix = 'USA_';
				var prefix_a = 'ASIA_';
				var prefix_e = 'EUR_';
				var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked?'Y':'N');
				var PRE_DIS_USE_FLG_VALUE = (formObj.PRE_DIS_USE_FLG.checked?'Y':'N');

				if(wo_format == 'NC') {
					wo_page = 'WO_NORMAL';
//					prefix_a = 'ASIA_';
//					prefix_e = 'EUR_';
				}
				else if(wo_format == 'CC') wo_page = 'WO_COMBINED1';
				else if(wo_format == 'IB') wo_page = 'WO_COMBINED2_1';
				else if(wo_format == 'CY') wo_page = 'WO_COMBINED2_2';
				else if(wo_format == 'CM') wo_page = 'WO_COMBINED2_3';
				else if(wo_format == 'MM'){
					wo_page = 'WO_EMPTY';
					// suffix = ''; 화면상으로는 같은 양식이나 메일은 각기 다른 양식으로 발송됨. 
//					prefix_a = '';
//					prefix_e = '';
					suffix = '';
//					prefix = '';
				}

				if(!formObj.WO_DTL_USE_FLG.checked) wo_page += suffix;

				if(sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'M') {
					if(wo_format == 'NC' || wo_format == 'MM') {
						wo_page = prefix + wo_page;
					} else {
						wo_page = 'Letter_' + wo_page;
					}	
				} 
				else if (sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'A') wo_page = prefix_a + wo_page;
				else if (sheetObjects[0].CellValue(comboObj.Text, 'conti_cd') == 'E') wo_page = prefix_e + wo_page;				

				var rdParam = '['+RT_DP_USE_FLG_VALUE+']';
				rdParam += '['+sheetObjects[0].CellValue(comboObj.Text,'wo_prv_grp_seq')+']';
				rdParam += '['+sheetObjects[0].CellValue(comboObj.Text,'wo_iss_no')+']';
				rdParam += '['+formObj.FORM_USR_OFC_CD.value+']';
				rdParam += '['+formObj.FORM_CRE_USR_ID.value+']';
				rdParam += '['+PRE_DIS_USE_FLG_VALUE+']';
				rdParam += '['+wo_page+']';
				rdParam += '['+sheetObjects[0].CellValue(comboObj.Text, 'conti_cd')+']';
				
				formObj.FAX_APP_CD.value = wo_page+'.mrd';
				formObj.FAX_PARAM.value = rdParam;
				formObj.FAX_RCV_INFO.value = sheetObj.CellValue(comboObj.Text, 'vndr_lgl_eng_nm');
				
				
				if(formObj.issued.value == 'Y'){
					sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj));
				}else{
					if(searchSOStatus(formObj)){
						formObj.f_cmd.value = ADD;
						sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj));
					}
				    ComOpenWait(false); //레이어형 대기 이미지 표시
				}
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {

	var comboObj = document.wo_group_no;
	var formObj = document.form;
    var woGroupCode = comboObj.Code;
    var sel_combo_idx=0;

    ComOpenWait(false); //레이어형 대기 이미지 표시
	sheetObj.WaitImageVisible = true;

	if( errMsg != null && errMsg != '' ) {
//		ComShowMessage(errMsg);
	} else {
		if(confirmAllFlg == "Y"){
			if( confirmCount == confirmIndex){
				ComShowCodeMessage('TRS90137');
			}
		}else{
			ComShowCodeMessage('TRS90137');
		}
		sheetObj.CellValue2(comboObj.Text, 'ibcheck') = 1;
		rdObjects[0].RefreshReport();	
		
		if(!opener){
            opener = window.dialogArguments;
		}
		opener.processConfirmedWOData(sheetObj.CellValue(comboObj.Text, 'wo_prv_grp_seq'),sheetObj.CellValue(comboObj.Text, 'wo_iss_no'));
		if(formObj.WO_PRN_USE_FLG.checked){
			rdObjects[0].CMPrint();
		}
	}
}

/**
 * reset 버튼을 누를때 form 조건을 리셋한다.
 */
function resetForm(formObj, sheetObj){
	//formObj.WO_PRN_USE_FLG.checked = true;
	//20140730. W/O Preview의 Print Out 기능 수정
	formObj.WO_PRN_USE_FLG.checked = false;
	formObj.WO_EML_USE_FLG.checked = true;
	formObj.WO_FAX_USE_FLG.checked = false;
	formObj.RT_DP_USE_FLG[1].checked = true;
	formObj.CMDT_DP_USE_FLG.checked = true;
	formObj.PRE_DIS_USE_FLG.checked = false;
	formObj.WO_RMK.value = '';
	formObj.WO_N1ST_EML.value = '';
	formObj.WO_N2ND_EML.value = '';
	formObj.WO_N3RD_EML.value = '';

	formObj.WO_N1ST_FAX_NO.value = '';
	formObj.WO_N2ND_FAX_NO.value = '';
	formObj.WO_N3RD_FAX_NO.value = '';

	formObj.reset();
}


/**
 * email 내용 가져오기
 */
function getEmailContents(vndr_nm){
	var contents = '\n';
	contents += 'Dear '+vndr_nm+'\n';
	contents += '\n';
	contents += 'Please refer to the attached file.\n';
	contents += 'You can also retrieve detailed information on this work order in the following web site :\n';
	contents += 'http://partner.smlines.com/\n\n ';
	contents += 'Thank you.\n';
	contents += 'SM Line\n';
	return contents;
}

/**
 * Confirm시 s/o 삭제여부 조회하기
 */
function searchSOStatus(formObj){
	var sheetObject = sheetObjects[1];
	var soCheck = true;
	formObj.f_cmd.value = SEARCH;
	var queryStr = sheetObjects[1].GetSaveString(true, false);
	sheetObject.DoSearch4Post("ESD_TRS_0024GS.do", TrsFrmQryString(formObj));
	var rows = sheetObject.SearchRows;
	for (i=0; i<rows+1; i++) {
		if(sheetObject.CellValue(i,"so_delt_flg") == 'Y'){
			soCheck = false;
		}
	}
	if(soCheck == false){
		ComShowCodeMessage("TRS90403");
	}
	return soCheck;
}
 
 /**
  * 메일개수 체크(6개까지 허용)
  */
function chkEmailCount(formObj){
	var sMail = formObj.WO_N1ST_EML.value;
	sMail = sMail.replace(eval("/" + " " + "/gi"), "");
	formObj.WO_N1ST_EML.value = sMail;
	var result = sMail.split(';');

	if(result.length > 6){
		ComShowCodeMessage("TRS90410");
		return false;
	}else{
		return true;
	}	   
} 
