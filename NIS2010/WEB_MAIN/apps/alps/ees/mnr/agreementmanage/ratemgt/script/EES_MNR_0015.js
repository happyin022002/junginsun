/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0015.js
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : Chang Young Kim
*@LastVersion : 1.21
* 2009.06.09 박명신
* 1.0 Creation
* 2013-12-17 by Jonghee HAN 선처리 MNR 통합 Log Error 복구 (ORA-01861: literal does not match format string)
* 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/
/****************************************************************************************
	이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends
	 * @class EES_MNR_0015 : EES_MNR_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0015() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
	}
/* 개발자 작업	*/

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var tempSheetObjects = new Array();

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	// 조회상태 여부 (현제 조회상태인지 아닌지)
	var nowRetriveSt = false;

	var retPossible = false;

	//어그리먼트 사용하는 견적서 리스트
	var checkEstList = "";

	//미승인 견적서 리스트
	var notApprovalEstList = "";

	//탭메뉴를 가지고 있는 배열
	var uTab = new Array();
	var gTab = new Array();
	var zTab = new Array();

	//LB 타입일 경우 헤더 배열 eq_type 별 3가지 모두 동일
	var lbHeader = new Array();

	//TS타입일 경우 타입사이즈 배열 eq_type 별 3가지 모두 틀림
	var uTpSz = new Array();
	var gTpSz = new Array();
	var zTpSz = new Array();

	//버젼정보의 디폴트
	var defVerCode = "1";

	//Combo의 디폴트
	var defagmtOfcCdCode = "";
	var defeqKndCdCode = "";

	//초기화인지 구분
	var loadIbclear = false;

	var tempEqKndCd = "U";

	//이전 trf_no 를 기억하기 위한
	var priTrfNo = "";

	var formObj = document.form;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3];
		 var sheetObject5 = sheetObjects[4];
		 var sheetObject6 = sheetObjects[5];
		 var sheetObject7 = sheetObjects[6];
		 var sheetObject8 = sheetObjects[7];
		/*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					if(retPossible){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					break;

				case "btn_new":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;

				case "btn_versionup":
					//버젼업하기 전에 먼저 조회하라는 메세지
					if(!nowRetriveSt){
						ComShowCodeMessage("MNR00182");
						break;
					}

					//미승인 견적서 조회
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);

					//notApprovalEstList <== 미승인 견적서 리스트
					if(notApprovalEstList != 'XX'){
						ComShowCodeMessage("MNR00343",notApprovalEstList);
						return false;
					}

					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					break;

				case "btn_save":
					sheetObjects[1].focus();
					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
					break;

				case "btn_del":
					//버젼업 상태에서 삭제시 상태만 롤백한다.
					if(formObject.isversionup.value == "Y"){
						formObject.agmt_ver_no.Enable = true;
						//현제 코드를 저장
						var delVerNo = formObject.agmt_ver_no.Code;
						formObject.agmt_ver_no.DeleteItem(delVerNo);
						defVerCode = parseInt(delVerNo,10) - 1;
						formObject.agmt_ver_no.Code2 = defVerCode;
						//버튼 원상복귀 한다.
						MnrWaitControl(false);
						formObject.isversionup.value = "N";

						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else {
						if(!nowRetriveSt){
							ComShowCodeMessage("MNR00047");
							break;
						}
						//삭제 하려는 agreement가 견적서에서 사용중인지 확인한다.
						//해당 agreement를 한번이라도 사용햇다면 삭제 할수 없다.
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);

						//삭제
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					}
					break;

				case "btn_add":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;

				case "btn_s1del":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;

				case "btn_t1apply":
					doActionIBSheet(sheetObjects[2],document.form,IBCOPYROW);
					break;

				case "btn_t1add":
					doActionIBSheet(sheetObjects[2],document.form,IBINSERT);
					break;

				case "btn_t1del":
					doActionIBSheet(sheetObjects[2],document.form,IBDELETE);
					break;

				case "btn_t2apply":
					doActionIBSheet(sheetObjects[3],document.form,IBCOPYROW);
					break;

				case "btn_t2add":
					doActionIBSheet(sheetObjects[3],document.form,IBINSERT);
					break;

				case "btn_t2del":
					doActionIBSheet(sheetObjects[3],document.form,IBDELETE);
					break;

				case "btn_t3apply":
					doActionIBSheet(sheetObjects[4],document.form,IBCOPYROW);
					break;

				case "btn_t3add":
					doActionIBSheet(sheetObjects[4],document.form,IBINSERT);
					break;

				case "btn_t3del":
					doActionIBSheet(sheetObjects[4],document.form,IBDELETE);
					break;

				case "btn_t4apply":
					doActionIBSheet(sheetObjects[5],document.form,IBCOPYROW);
					break;

				case "btn_t4add":
					doActionIBSheet(sheetObjects[5],document.form,IBINSERT);
					break;

				case "btn_t4del":
					doActionIBSheet(sheetObjects[5],document.form,IBDELETE);
					break;

				case "btn_t5apply":
					doActionIBSheet(sheetObjects[6],document.form,IBCOPYROW);
					break;

				case "btn_t5add":
					doActionIBSheet(sheetObjects[6],document.form,IBINSERT);
					break;

				case "btn_t5del":
					doActionIBSheet(sheetObjects[6],document.form,IBDELETE);
					break;

				case "btn_t6apply":
					doActionIBSheet(sheetObjects[7],document.form,IBCOPYROW);
					break;

				case "btn_t6add":
					doActionIBSheet(sheetObjects[7],document.form,IBINSERT);
					break;

				case "btn_t6del":
					doActionIBSheet(sheetObjects[7],document.form,IBDELETE);
					break;

				case "btn_t7apply":
					doActionIBSheet(sheetObjects[8],document.form,IBCOPYROW);
					break;

				case "btn_t7add":
					doActionIBSheet(sheetObjects[8],document.form,IBINSERT);
					break;

				case "btn_t7del":
					doActionIBSheet(sheetObjects[8],document.form,IBDELETE);
					break;

				case "btn_t8apply":
					doActionIBSheet(sheetObjects[9],document.form,IBCOPYROW);
					break;

				case "btn_t8add":
					doActionIBSheet(sheetObjects[9],document.form,IBINSERT);
					break;

				case "btn_t8del":
					doActionIBSheet(sheetObjects[9],document.form,IBDELETE);
					break;

				case "btn_vndr":
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC03);
					setComboEnable(true);
					break;

				case "btn_calendar":
					var cal = new ComCalendarFromTo();
						cal.select(form.eff_dt, form.exp_dt, 'yyyy-MM-dd');
					break;

				case "btn_calendar1":
					var cal = new ComCalendar();
					cal.select(formObject.agmt_dt, 'yyyy-MM-dd');
					break;

				case "btn_agmt_no":
					if(!formObject.agmt_no.readOnly){
						ComOpenPopup('/hanjin/EES_MNR_0016.do', 920, 540, 'setEES_MNR_0016', "0,1,1,1,1,1", true);
					}
					break;

				case "btns_agmtAtch":	// 2014-12-15 Chang Young Kim, M&R Agreement Attachment_Pop Up 호출( EES_MNR_0017 )
					if(ComIsEmpty(formObject.file_atch_flg.value) ) {
						// msgs['MNR00248'] = 'Please search it first.';
						ComShowCodeMessage('MNR00248');
						return;
					}

					var strAgmtOfcCtyCd	= formObject.agmt_ofc_cty_cd.value;
					var strAgmtSeq		= formObject.agmt_seq.value;
					var strAgmtVerNo	= formObject.agmt_ver_no.Code;
					var strFileAtchFlg	= formObject.file_atch_flg.value;
					var strActnFlg		= "S";

					ComOpenPopup('/hanjin/EES_MNR_0017.do?agmt_ofc_cty_cd='+strAgmtOfcCtyCd+
							'&agmt_seq='+strAgmtSeq+
							'&agmt_ver_no='+strAgmtVerNo+
							'&file_atch_flg='+strFileAtchFlg+
							'&actn_flg='+strActnFlg, 920, 540, 'setEES_MNR_0017', "0,1,1,1,1,1", true);

					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		tempSheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

	/**
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다.
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		MnrWaitControl(true);
		initControl();
		//메뉴 구조를 가져오고 타입별로 각 배열에 담는다.
		setPageInit();

		//형식적 initSheet
		initSheet(sheetObjects[0],"sheet1",'','');

		ComConfigSheet(sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet2",'','');
		ComEndConfigSheet(sheetObjects[1]);

		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k + 1);
		}

		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}

	function setPageInit(){
		//쉬트 순서를 바꿔준다.
		for(var i = 0;i < tempSheetObjects.length ;i++){
			if(tempSheetObjects[i].id == "sheet1"){
				sheetObjects[0] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "sheet2"){
				sheetObjects[1] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t1sheet1"){
				sheetObjects[2] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t2sheet1"){
				sheetObjects[3] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t3sheet1"){
				sheetObjects[4] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t4sheet1"){
				sheetObjects[5] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t5sheet1"){
				sheetObjects[6] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t6sheet1"){
				sheetObjects[7] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t7sheet1"){
				sheetObjects[8] = tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t8sheet1"){
				sheetObjects[9] = tempSheetObjects[i];
			}
		}
		//메뉴구조를 가져온다. 가져온 데이타를 각 배열로 쪼갠다.
		doActionIBSheet(sheetObjects[0],document.form,IBRESET);
	}

	/**
	 * Combo 기본 설정
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트.
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo (comboObj, comboNo) {
		//var cnt = 0 ;
		var formObject = document.form

		switch(comboNo) {
			case 1:
				with (comboObj) {
					SetTitle("Ver|Creation Date");
					SetColAlign("left|left");
					SetColWidth("50|170");
					DropHeight = 160;
				}
			break;
			case 2:
				with (comboObj) {
					SetTitle("Code|Desc");
					SetColAlign("left|left");
					SetColWidth("50|170");
					DropHeight = 160;
				}
			break;

			case 4:
				with (comboObj) {
					SetTitle("Tariff No|Tariff Type|Service Provider|EQ Type|Status|Eff.From|Unit|Currency");
					SetColAlign("left|left|left|left|left|center|left|left");
					SetColWidth("140|80|180|80|100|80|80|80");
					DropHeight = 160;
				}
			break;

			default :
				with (comboObj) {
					//SetColAlign("left");
					//DropHeight = 160;
				}
			break;
		 }
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetType,eq_type,display_type) {
		var cnt = 0;

		switch(sheetType) {
			case "sheet1":
				with (sheetObj) {
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}
			case "sheet2":	//t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 230;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(24, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, true, true, true, false,false);

					var HeadTitle1 = "|Sel|Cost CTRL\nOffice|Transmission\nMode|EDI ID|Web ID|Tel No|Fax No|E-mail|Remark";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1 , true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"del_check",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	80,	daLeft,		true,	"aply_ofc_cd",			true,	"",	dfNone,	0,	true,	true);

					//추가 파트너용
					InitDataProperty(0, cnt++ , dtCombo,		80,	daLeft,		false,	"trsm_mod_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		false,	"edi_id",				false,	"",	dfNone,	0,	true,	true, 20);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		false,	"sp_ptal_id",			false,	"",	dfNone,	0,	true,	true, 20);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		false,	"phn_no",				false,	"",	dfNone,	0,	true,	true, 20);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		false,	"fax_no",				false,	"",	dfNone,	0,	true,	true, 20);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		false,	"mnr_prnr_eml",			false,	"",	dfNone,	0,	true,	true, 200);

					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"agmt_ofc_cty_cd",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"agmt_seq",				false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"agmt_ver_no",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"agmt_ofc_tp_cd",		false,	"",	dfNone,	0,	true,	true);
					//추가 파트너용
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"ctrl_ofc_cd",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"mnr_grp_tp_cd",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"mnr_prnr_tp_cd",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"mnr_prnr_knd_cd",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"mnr_prnr_sts_cd",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"mnr_prnr_seq",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"pay_term_dys",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	false,	"eff_dt",				false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"exp_dt",				false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"mnr_prnr_locl_lang_nm",false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	daLeft,		false,	"mnr_prnr_lgl_eng_nm",	false,	"",	dfNone,	0,	false,	false);

					WaitImageVisible = false;

					InitDataValid(0,	"aply_ofc_cd", vtEngUpOther,"0123456789");
					InitDataValid(0,	"edi_id", vtEngUpOther,"0123456789");
					InitDataValid(0,	"sp_ptal_id", vtEngOther,"0123456789");
					InitDataValid(0,	"phn_no", vtNumericOther,"-");
					InitDataValid(0,	"fax_no", vtNumericOther,"-");
					InitDataValid(0,	"mnr_prnr_eml", vtEngDnOther,"0123456789@.-_;");

					PopupImage = "/hanjin/img/btns_search.gif";
					ShowButtonImage = 2;

					MultiSelection = false;
					//SELECT 로우 배경색
					SelectionMode = smSelectionRow;
					SelectHighLight = true;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);

					CountPosition = 0;

				}
				break;
			case "LB":	//lb
				with (sheetObj) {
					// 높이 설정
					style.height = 222;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, true, true, true, false,false);

					var HeadTitle = "|Sel|Seq.|Detail Type|Rate Type|Amount";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_check",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtCombo,		130,	daLeft,		true,	"cost_cd",			true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,		130,	daLeft,		true,	"cost_dtl_cd",		true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"agmt_rt_amt",		false,	"",	dfFloat,2,	true,	true,17);

					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ofc_cty_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ver_no",		false,	"",	dfNone,	0,	true,	true);

					//LB형 쉬트 콤보 설정 값이 유동적
					var sCondition = new Array (
						new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM5"),
						new Array("MnrGenCd","MRDRRC", "COMMON")
					)

					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					//쉬트 콤보데이타에 값을 세팅함
					var sheetComboText = "";
					var sheetComboCode = "";
					var sheetComboDefault = "";
					//쉬트 콤보 SAVE_NAME
					var comboSaveNames = new Array();
					comboSaveNames[0] = "cost_cd";
					comboSaveNames[1] = "cost_dtl_cd";

					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							sheetComboCodeText = "";
							sheetComboDefault = "";

							for(var j = 0; j < comboList[i].length;j++){
								var tempText = comboList[i][j].split("|");

								sheetComboText += tempText[1] + "|";
								sheetComboCode += tempText[0] + "|";
								sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
								if(j ==0){
									sheetComboDefault = tempText[0];
								}
							}

							sheetComboText = MnrDelLastDelim(sheetComboText);
							sheetComboCode = MnrDelLastDelim(sheetComboCode);

							InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault);
						}
					}

					//SELECT 로우 배경색
					SelectionMode = smSelectionFree;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;
				}
				break;

			case "TS":	//ts
				with (sheetObj) {
					// 높이 설정
					style.height = 222;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼 정보 설정전에 미리 루핑
					var disPlayTpSz = new Array();
					var HeadTitleTemp = "";

					if(eq_type == 'U'){
						disPlayTpSz = uTpSz;
					} else if(eq_type == 'G'){
						disPlayTpSz = gTpSz;
					} else if(eq_type == 'Z'){
						disPlayTpSz = zTpSz;
					}

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, true, true, true, false,false);

					var HeadTitle = "|Sel|Seq.|Detail Type|TP/SZ|Amount";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_check",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtCombo,		150,	daLeft,		true,	"cost_dtl_cd",		true,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtPopup,		70,		daCenter,	true,	"mnr_rt_tp_cd",		true,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"agmt_rt_amt",		false,	"",	dfFloat,	2,	true,	true, 17);

					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ofc_cty_cd",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_seq",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ver_no",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"cost_cd",			false,	"",	dfNone,		0,	true,	true);

					var sCondition = new Array (
						new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM4")
					)
					var comboList = MnrComSearchCombo(sheetObj,sCondition);

					var lbComboText = "";
					var lbComboCode = "";
					var lbComboDefault = "";
					//TS형 콤보타입
					if(comboList[0] != null){
						for(var j = 0; j < comboList[0].length;j++){
							var tempText = comboList[0][j].split("|");

							lbComboText += tempText[1] + "|";
							lbComboCode += tempText[0] + "|";
							if(j == 0){
								lbComboDefault = tempText[0];
							}
						}
					}
					InitDataCombo (0, "cost_dtl_cd", lbComboText, lbComboCode ,lbComboDefault);

					PopupImage  =  "/hanjin/img/btns_search.gif";
					ShowButtonImage = 2;

					//SELECT 로우 배경색
					SelectionMode = smSelectionFree;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;
				}
				break;

			case "QT":	//qt
				with (sheetObj) {
					// 높이 설정
					style.height = 222;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

					var HeadTitle1 = "|Sel|Seq.|Detail Type|Q'ty|Amount";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_check",		false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtCombo,		150,	daLeft,	true,		"cost_dtl_cd",		true,	"",		dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"rpr_qty",			false,	"",		dfInteger,	0,	true,	true, 6);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"agmt_rt_amt",		false,	"",		dfFloat,	2,	true,	true, 17);

					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ofc_cty_cd",	false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_seq",			false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"agmt_ver_no",		false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	false,	"cost_cd",			false,	"",		dfNone,		0,	true,	true);

					//QT형 쉬트 콤보 설정 값이 유동적
					var sCondition = new Array (
						new Array("MnrGenCd",eq_type + "G" + display_type, "CUSTOM4")
					)
					var comboList = MnrComSearchCombo(sheetObj,sCondition);

					var lbComboText = "";
					var lbComboCode = "";
					var lbComboDefault = "";
					//QT형 콤보타입
					if(comboList[0] != null){
						for(var j = 0; j < comboList[0].length;j++){
							var tempText = comboList[0][j].split("|");

							lbComboText += tempText[1] + "|";
							lbComboCode += tempText[0] + "|";
							if(j == 0){
								lbComboDefault = tempText[0];
							}
						}
					}
					InitDataCombo (0, "cost_dtl_cd", lbComboText, lbComboCode ,lbComboDefault);

					//SELECT 로우 배경색
					SelectionMode = smSelectionFree;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 0;
				}
				break;
		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)){
					for(i = 0;i < sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");

					//헤더 데이타 세팅

					if(arrXml[0] != null){
						//agmt_no 를 조회해온걸루 새루 세팅
						ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
						// G/W Contract YN
						ComSetObjValue(formObj.file_atch_flg, ComGetEtcData(arrXml[0], "file_atch_flg"));
						//vndr
						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
						//version no
						formObj.agmt_ver_no.Code2  = ComGetEtcData(arrXml[0], "agmt_ver_no");
						//currency
						formObj.curr_cd.Code  = ComGetEtcData(arrXml[0], "curr_cd");
						//agmt_ofc_cd
						formObj.agmt_ofc_cd.Code  = ComGetEtcData(arrXml[0], "agmt_ofc_cd");
						//eff dt
						ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
						ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
						//pay_term_dys
						ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
						//agmt sign dt
						ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
						//agmt_ref_no
						ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
						//EQ_TYPE
						formObj.eq_knd_cd.Enable = false;
						formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");

						//Tariff No
						setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
					}

					//쉬트 데이타 세팅
					for(var i = 1; i < arrXml.length + 1; i++){
						sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
					}
					//조회 상태
					nowRetriveSt = true;
					//isVersionUp 상태표시
					formObj.isversionup.value = "N";
					MnrFormSetReadOnly(formObj,true,"agmt_no");
				}
			break;

			case IBSAVE:		//저장
					if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value = MULTI;
						var sheet2Param = "";
						var sheetTparams = "";
						var disPlayTypes = "";
						var priFixStr = "";
						//apply ofc 밀어 넣기
						var tempSheet2Param = sheetObjects[1].GetSaveString(true);

						//apply ofc 멘덴토리 체크
						if(tempSheet2Param == "" && sheetObjects[1].IsDataModified){
							return;
						} else if(tempSheet2Param != ""){
							sheet2Param = ComSetPrifix(tempSheet2Param,"sheet2");
							disPlayTypes = disPlayTypes + "sheet2|";
							priFixStr = priFixStr + sheetObjects[1].id + "|";
						}

						//탭 시트 밀어 넣기
						for(var i = 2 ; i < sheetObjects.length ; i++){
							var tempParamStr = sheetObjects[i].GetSaveString(true);
							//탭시트 멘덴토리 체크
							if(tempParamStr == "" && sheetObjects[i].IsDataModified){
								return;
							} else if(tempParamStr != ""){
								priFixStr = priFixStr + sheetObjects[i].id + "|";
								sheetTparams = sheetTparams + ComSetPrifix(tempParamStr,sheetObjects[i].id) + "&";
								var tabIndex = parseInt(sheetObjects[i].id.substr(1,1),10) - 1;
								//QT~~xx~~Z~~6~~OT~~MRZSOT~~Other
								if(formObj.eq_knd_cd.Code == 'U'){
									disPlayTypes = disPlayTypes + uTab[tabIndex][0] + "|";
								} else if (formObj.eq_knd_cd.Code == 'G'){
									disPlayTypes = disPlayTypes + gTab[tabIndex][0] + "|";
								} else if (formObj.eq_knd_cd.Code == 'Z'){
									disPlayTypes = disPlayTypes + zTab[tabIndex][0] + "|";
								}
							}
						}
						//디스플레이 타입별루 VO를 쪼개야 한다.
						formObj.agmt_display_type.value = MnrDelLastDelim(disPlayTypes);
						formObj.agmt_prifix.value = MnrDelLastDelim(priFixStr);
						sheetTparams = MnrDelLastDelim(sheetTparams);

						var sParam = FormQueryString(formObj);

						if(sheet2Param != ""){
							sParam = sParam + "&" + sheet2Param;
						}

						if(sheetTparams != ""){
							sParam = sParam + "&" + sheetTparams;
						}

						var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0015GS.do",sParam);

						var arrXml = sXml.split("|$$|");

						//이벤트를 발생시키기 위한	0 -> delete 1 -> save
						sheetObjects[1].LoadSaveXml(arrXml[0]);

						if(MnrComGetErrMsg(sXml) == null){
							//조회 상태
							nowRetriveSt = true;
							MnrFormSetReadOnly(formObj,true,"agmt_no");
							//SAVE한후 결과를 다시 세팅
							//헤더 데이타 세팅
							if(arrXml[0] != null){
								//agmt_no 를 조회해온걸루 새루 세팅
								ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								formObj.agmt_ofc_cty_cd.value = formObj.agmt_no.value.substring(0,3);
								formObj.agmt_seq.value = parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);

								//version no 를 다시 세팅
								var sCondition = new Array (
									new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.local_ofc_cd.value)
								)

								var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
								formObj.agmt_ver_no.RemoveAll();
								if(comboList[0] != null){
									for(var j = 0; j < comboList[0].length;j++){
										var tempText = comboList[0][j].split("|");

										formObj.agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
									}

									formObj.agmt_ver_no.Code2 = ComGetEtcData(arrXml[0], "agmt_ver_no");
									defVerCode = ComGetEtcData(arrXml[0], "agmt_ver_no");
								}

								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//currency
								formObj.curr_cd.Code  = ComGetEtcData(arrXml[0], "curr_cd");
								//agmt_ofc_cd
								formObj.agmt_ofc_cd.Code  = ComGetEtcData(arrXml[0], "agmt_ofc_cd");
								//file_atch_flg
								formObj.file_atch_flg.value = ComGetEtcData(arrXml[0], "file_atch_flg");
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								formObj.eq_knd_cd.Enable = false;
								formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
							}

							//쉬트 데이타 세팅
							for(var i = 1; i < arrXml.length + 2; i++){
								sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
							}
							//isVersionUp 상태표시
							formObj.isversionup.value = "N";

							MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");

							for(var i = 0; i < sheetObjects.length; i++){
								sheetObjects[i].Editable = true;
							}
							formObj.agmt_ver_no.Enable = true;
							formObj.curr_cd.Enable = true;
							formObj.agmt_ofc_cd.Enable = true;
							formObj.eq_knd_cd.Enable = false;

							//바꼇을지 모르는 값들을 원상복귀 한다.
							MnrWaitControl(false);
						}
					}
				break;

			case IBCREATE:	//Version up
					if(validateForm(sheetObj,formObj,sAction)){
						formObj.agmt_ver_no.Enable = true;
						setComboEnable(true);
						var newVersion = parseInt(defVerCode,10) + 1;
						formObj.agmt_ver_no.InsertItem(0, newVersion + '|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),newVersion);
						formObj.agmt_ver_no.Code2 = newVersion;
						defVerCode = newVersion;
						//나머지 값은 그대로 유지	...

						//버튼 세팅
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_del");
						ComBtnDisable("btn_retrieve");
						ComBtnDisable("btn_versionup");

						formObj.isversionup.value = "Y";

						MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
						MnrFormSetReadOnly(formObj,true,"agmt_no");

						formObj.agmt_ver_no.Enable = false;
						formObj.curr_cd.Enable = true;
						formObj.agmt_ofc_cd.Enable = true;
						formObj.eq_knd_cd.Enable = false;

						//비조회 상태로 다시
						nowRetriveSt = false;
					}
				break;

			case IBSEARCHAPPEND:		//Delete
				if(validateForm(sheetObj,formObj,sAction)){
						//삭제 하기전 키값을 저장
						var tempAgmtNo = formObj.agmt_no.value;
						var tempAgmtOfc = formObj.agmt_ofc_cty_cd.value;
						var tempAgmtSeq = formObj.agmt_seq.value;

						//삭제
						formObj.f_cmd.value = REMOVE;
						var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveXml(sXml);

						//version no 를 다시 조회한다.
						var sCondition = new Array (
							new Array("MnrAgmtHdr",tempAgmtNo,formObj.local_ofc_cd.value)
						)

						var comboList = MnrComSearchCombo(sheetObj,sCondition);
						formObj.agmt_ver_no.RemoveAll();

						//해당 어그리먼트가 있을경우
						if(comboList[0] != null){
							for(var j = 0; j < comboList[0].length;j++){
								var tempText = comboList[0][j].split("|");

								formObj.agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
								//넘어온 값을 세팅한다.
								if(j == 0){
									defVerCode = tempText[0];
								}
							}
							formObj.agmt_ver_no.Code2 = defVerCode;
							formObj.agmt_no.value = tempAgmtNo;
							formObj.agmt_ofc_cty_cd.value = tempAgmtOfc;
							formObj.agmt_seq.value = tempAgmtSeq;

							//dosearch와 동일
							for(i = 0;i<sheetObjects.length;i++){
								sheetObjects[i].RemoveAll();
							}

							formObj.f_cmd.value = SEARCH;
							var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");

							//헤더 데이타 세팅
							if(arrXml[0] != null){
								//agmt_no 를 조회해온걸루 새루 세팅
								ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//version no
								formObj.agmt_ver_no.Code  = ComGetEtcData(arrXml[0], "agmt_ver_no");
								//currency
								formObj.curr_cd.Code  = ComGetEtcData(arrXml[0], "curr_cd");
								//agmt_ofc_cd
								formObj.agmt_ofc_cd.Code  = ComGetEtcData(arrXml[0], "agmt_ofc_cd");
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								formObj.eq_knd_cd.Enable = false;
								formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");

								formObj.agmt_rmk.value =  ComGetEtcData(arrXml[0], "agmt_rmk");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
							}

							//쉬트 데이타 세팅
							for(var i = 1; i < arrXml.length + 1; i++){
								sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
							}
							//조회 상태
							nowRetriveSt = true;
							//isVersionUp -- > 'N' 상태표시
							formObj.isversionup.value = "N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						//해당 어그리먼트가 하나두 없을 경우 초기화 작업
						} else {
							//IBCLEAR 와 동일한 작업 수행
							MnrWaitControl(true);
							retPossible = false;
							nowRetriveSt = false;

							//쉬트 초기화
							for(i = 0;i < sheetObjects.length;i++){
								sheetObjects[i].RemoveAll();
								sheetObjects[i].Editable = true;
							}

							//콤보 초기화
							for(var i = 0; i < comboObjects.length;i++){
								comboObjects[i].RemoveAll();
								comboObjects[i].Enable = true;
							}

							//isVersionUp 상태표시
							formObj.isversionup.value = "N";
							//ReadOnly 원상복귀
							MnrFormSetReadOnly(formObj,false,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");

							//Tariff 콤보
							formObj.trf_no.Enable = false;
							priTrfNo = "";

							//폼 초기화 화면에 보여 지는 값만 리셋
							formObj.vndr_seq.value = "";
							formObj.vndr_nm.value = "";
							formObj.pay_term_dys.value = "";
							formObj.agmt_ref_no.value = "";
							formObj.agmt_rmk.value = "";
							formObj.file_atch_flg.value = "";
							//기본적으로 세팅해야 될값을 세팅
							//AGREEMENT NO
							formObj.agmt_no.value = "NEW";
							//agmt_ver_no 세팅
							formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
							defVerCode = '1';
							formObj.agmt_ver_no.Code2 = defVerCode;

							//공통콤보 정보를 가져온다.
							var sCondition = new Array (
								//폼 콤보
								new Array("MdmCurrency","","COMMON"),		//CURRENCY
								new Array("MnrOfcGenInfo","","AGMT"),	//AGMT_OFC_CD
								new Array("MnrGenCd",formObj.ctrl_ofc_cd.value,"CUSTOM9"),
								//sheetObjects[1] 콤보
								new Array("MnrGenCd","CD00016", "COMMON")
							)

							var comboList = MnrComSearchCombo(sheetObj,sCondition);

							//1  CURRENCY 세팅
							if(comboList[0] != null){
								for(var j = 0; j < comboList[0].length;j++){
									var tempText = comboList[0][j].split("|");
									formObj.curr_cd.InsertItem(j ,comboList[0][j] ,tempText[0]);
								}
							}
							formObj.curr_cd.Code = "-1";

							//AGMT_OFC_CD 세팅  Agreement Office
							if(comboList[1] != null){
								for(var j = 0; j < comboList[1].length;j++){
									var tempText = comboList[1][j].split("|");
									formObj.agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
									if(j == 0){
										defagmtOfcCdCode = tempText[0];
									}
								}
							}
							formObj.agmt_ofc_cd.Code = defagmtOfcCdCode;

							//EQ_KND_CD 세팅  EQ_TYPE
							if(comboList[2] != null){
								for(var j = 0; j < comboList[2].length;j++){
									var tempText = comboList[2][j].split("|");
									formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){
										defeqKndCdCode = tempText[0];
									}
								}
							}
							formObj.eq_knd_cd.Code = defeqKndCdCode;

							//sheetObjects[1] 세팅
							//TRSM_MOD_CD
							var sheetComboText = "";
							var sheetComboCode = "";
							var sheetComboDefault = "";
							if(comboList[3] != null){
								for(var j = 0; j < comboList[3].length;j++){
									var tempText = comboList[3][j].split("|");

									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									if(j == 0){
										sheetComboDefault = tempText[0];
									}
								}
							}
							sheetComboText = MnrDelLastDelim(sheetComboText);
							sheetComboCode = MnrDelLastDelim(sheetComboCode);
							sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode ,sheetComboDefault);

							//**** 기본으로  Agreement Office를 하나 깔아줌
							var Row = sheetObjects[1].DataInsert(-1);
							sheetObjects[1].CellValue2(Row,"agmt_ofc_tp_cd") = "COST";
							sheetObjects[1].CellValue2(Row,"aply_ofc_cd") = formObj.agmt_ofc_cd.Code;
							sheetObjects[1].CellValue2(Row,"ctrl_ofc_cd") = formObj.agmt_ofc_cd.Code;
							sheetObjects[1].CellValue2(Row,"mnr_grp_tp_cd") = "RPR";
							sheetObjects[1].CellValue2(Row,"mnr_prnr_tp_cd") = "S";
							sheetObjects[1].CellValue2(Row,"mnr_prnr_knd_cd") = "C";
							sheetObjects[1].CellValue2(Row,"mnr_prnr_sts_cd") = "C";

							//AGMT Sign Date 세팅
							formObj.agmt_dt.value = ComGetNowInfo("ymd");
							MnrWaitControl(false);
						}
				}
				break;

			case IBINSERT:	// 쉬트 1 입력
					if(sheetObj.id == "sheet2"){
						if(formObj.vndr_seq.value == ""){
							ComShowCodeMessage("MNR00271");
							return;
						}

						var Row = sheetObj.DataInsert(-1);

						sheetObj.CellValue2(Row,"agmt_ofc_tp_cd") = "COST";
						sheetObj.CellValue2(Row,"mnr_grp_tp_cd") = "RPR";
						sheetObj.CellValue2(Row,"mnr_prnr_tp_cd") = "S";
						sheetObj.CellValue2(Row,"mnr_prnr_knd_cd") = "C";
						sheetObj.CellValue2(Row,"mnr_prnr_sts_cd") = "C";
						sheetObj.CellValue2(Row,"mnr_prnr_seq") = formObj.vndr_seq.value;
						sheetObj.CellValue2(Row,"mnr_prnr_lgl_eng_nm") = formObj.vndr_nm.value;
						sheetObj.CellValue2(Row,"mnr_prnr_locl_lang_nm") = formObj.vndr_nm.value;
						sheetObj.CellValue2(Row,"pay_term_dys") = formObj.pay_term_dys.value;
						sheetObj.CellValue2(Row,"eff_dt") = formObj.eff_dt.value;
						sheetObj.CellValue2(Row,"exp_dt") = formObj.exp_dt.value;
					}

					//텝인덱스를 구한다.
					if(sheetObj.id != "sheet1" && sheetObj.id != "sheet2"){
						var tabIndex = parseInt(sheetObj.id.substr(1,1),10) - 1;
						//QT~~xx~~Z~~6~~OT~~MRZSOT~~Other
						if(formObj.eq_knd_cd.Code == 'U'){
							var Row = sheetObj.DataInsert(-1);
							sheetObj.CellValue2(Row,"agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
							sheetObj.CellValue2(Row,"agmt_seq") = formObj.agmt_seq.value;
							sheetObj.CellValue2(Row,"agmt_ver_no") = formObj.agmt_ver_no.Code;
							if(uTab[tabIndex][0] == 'QT' || uTab[tabIndex][0] == 'TS'){
								sheetObj.CellValue2(Row,"cost_cd") = uTab[tabIndex][5];
							}
						} else if (formObj.eq_knd_cd.Code == 'G'){
							var Row = sheetObj.DataInsert(-1);
							sheetObj.CellValue2(Row,"agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
							sheetObj.CellValue2(Row,"agmt_seq") = formObj.agmt_seq.value;
							sheetObj.CellValue2(Row,"agmt_ver_no") = formObj.agmt_ver_no.Code;
							if(gTab[tabIndex][0] == 'QT' || gTab[tabIndex][0] == 'TS'){
								sheetObj.CellValue2(Row,"cost_cd") = gTab[tabIndex][5];
							}
						} else if (formObj.eq_knd_cd.Code == 'Z'){
							var Row = sheetObj.DataInsert(-1);
							sheetObj.CellValue2(Row,"agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
							sheetObj.CellValue2(Row,"agmt_seq") = formObj.agmt_seq.value;
							sheetObj.CellValue2(Row,"agmt_ver_no") = formObj.agmt_ver_no.Code;
							if(zTab[tabIndex][0] == 'QT' || zTab[tabIndex][0] == 'TS'){
								sheetObj.CellValue2(Row,"cost_cd") = zTab[tabIndex][5];
							}
						}
					}
				break;

			case IBDELETE:	// 삭제
					MnrRowDelete(sheetObj, "del_check");
					break;
				break;

			case IBCOPYROW:	// 값입력
					//요청으로 삭제
				break;

			case IBRESET:	// 메뉴구조를 가져온다
				formObj.f_cmd.value = SEARCH01;

				var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));

				//0 mnr_ord_tp_cd|1 ibflag|2 eq_type|3 dp_seq|4 tab_title|5 pagerows
				var arrResult = MnrXmlToArray(sXml);

				var uCnt = 0;
				var gCnt = 0;
				var zCnt = 0;
				if(arrResult != null){
					//갖고온 데이타를 타입별로 쪼갠다.
					for(var i = 0; i < arrResult.length;i++){
						if(arrResult[i][2] == "U"){
							uTab[uCnt++] = arrResult[i];
						}
						if(arrResult[i][2] == "Z"){
							zTab[zCnt++] = arrResult[i];
						}
						if(arrResult[i][2] == "G"){
							gTab[gCnt++] = arrResult[i];
						}
					}
				}
				//EQ_TYPE별 타입사이를 조회해서 각 배열에 담는다.
				var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");

				if(arrXml != null){
					for(var i = 0; i < arrXml.length; i++){
						if(i == 0){
							uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 1){
							zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 2){
							gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
						}
					}
				}
				break;

			case IBCLEAR:	//초기화
				MnrWaitControl(true);
				loadIbclear = true;
				retPossible = false;
				nowRetriveSt = false;

				//쉬트 초기화
				for(i = 0;i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
					sheetObjects[i].Editable = true;
				}

				//콤보 초기화
				for(var i = 0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
					comboObjects[i].Enable = true;
				}

				//isVersionUp 상태표시
				formObj.isversionup.value = "N";
				//ReadOnly 원상복귀
				MnrFormSetReadOnly(formObj,false,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");

				//Tariff 콤보
				formObj.trf_no.Enable = false;
				priTrfNo = "";

				//폼 초기화 화면에 보여 지는 값만 리셋
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value = "";
				formObj.pay_term_dys.value = "";
				formObj.agmt_ref_no.value = "";
				formObj.agmt_rmk.value = "";
				// G/W Contract
				formObj.file_atch_flg.value = "";
				//기본적으로 세팅해야 될값을 세팅
				//AGREEMENT NO
				formObj.agmt_no.value = "NEW";
				//agmt_ver_no 세팅
				formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
				defVerCode = '1';
				formObj.agmt_ver_no.Code2 = defVerCode;

				//공통콤보 정보를 가져온다.
				var sCondition = new Array (
					//폼 콤보
					new Array("MdmCurrency","","COMMON"),		//CURRENCY
					new Array("MnrOfcGenInfo","","AGMT"),	//AGMT_OFC_CD
					new Array("MnrGenCd",formObj.ctrl_ofc_cd.value,"CUSTOM9"),
					//sheetObjects[1] 콤보
					new Array("MnrGenCd","CD00016", "COMMON")
				)

				var comboList = MnrComSearchCombo(sheetObj,sCondition);

				//1  CURRENCY 세팅
				if(comboList[0] != null){
					for(var j = 0; j < comboList[0].length;j++){
						var tempText = comboList[0][j].split("|");
						formObj.curr_cd.InsertItem(j ,comboList[0][j] ,tempText[0]);
					}
				}
				formObj.curr_cd.Code = "-1";

				//AGMT_OFC_CD 세팅  Agreement Office
				if(comboList[1] != null){
					for(var j = 0; j < comboList[1].length;j++){
						var tempText = comboList[1][j].split("|");
						formObj.agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
						if(j == 0){
							defagmtOfcCdCode = tempText[0];
						}
					}
				}
				formObj.agmt_ofc_cd.Code = defagmtOfcCdCode;

				//EQ_KND_CD 세팅  EQ_TYPE
				if(comboList[2] != null){
					for(var j = 0; j < comboList[2].length;j++){
						var tempText = comboList[2][j].split("|");
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){
							defeqKndCdCode = tempText[0];
						}
					}
				}
				formObj.eq_knd_cd.Code = defeqKndCdCode;

				//sheetObjects[1] 세팅
				//TRSM_MOD_CD
				var sheetComboText = "";
				var sheetComboCode = "";
				var sheetComboDefault = "";
				if(comboList[3] != null){
					for(var j = 0; j < comboList[3].length;j++){
						var tempText = comboList[3][j].split("|");

						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j == 0){
							sheetComboDefault = tempText[0];
						}
					}
				}
				sheetComboText = MnrDelLastDelim(sheetComboText);
				sheetComboCode = MnrDelLastDelim(sheetComboCode);
				sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode ,sheetComboDefault);

				//**** 기본으로  Agreement Office를 하나 깔아줌
				var Row = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].CellValue2(Row,"agmt_ofc_tp_cd") = "COST";
				sheetObjects[1].CellValue2(Row,"aply_ofc_cd") = formObj.agmt_ofc_cd.Code;
				sheetObjects[1].CellValue2(Row,"ctrl_ofc_cd") = formObj.agmt_ofc_cd.Code;
				sheetObjects[1].CellValue2(Row,"mnr_grp_tp_cd") = "RPR";
				sheetObjects[1].CellValue2(Row,"mnr_prnr_tp_cd") = "S";
				sheetObjects[1].CellValue2(Row,"mnr_prnr_knd_cd") = "C";
				sheetObjects[1].CellValue2(Row,"mnr_prnr_sts_cd") = "C";

				//AGMT Sign Date 세팅
				formObj.agmt_dt.value = ComGetNowInfo("ymd");

				//Effect Period 초기화
				formObj.eff_dt.value = "";
				formObj.exp_dt.value = "";

				loadIbclear = false;
				MnrWaitControl(false);
				break;

			case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Service Provider Detail Information
					var sXml = MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");

					if(ComGetEtcData(sXml, "vndr_seq") != null){
						//Vender nm 세팅
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));

						//Curr 세팅
						formObj.curr_cd.Code  = ComGetEtcData(sXml, "pay_curr_cd");

						//PAY TERM 세팅
						var tempPayTerm = ComGetEtcData(sXml, "gen_pay_term_cd");

						if(tempPayTerm != ""){
							if("O60" == tempPayTerm || "O45" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"0");
							} else if ("IN" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"5");
							} else if ("OUT" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"60");
							} else {
								ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
							}
						}

						//Ctrl Office 정보를 갱신한다.
						for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
							sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = ComGetEtcData(sXml, "vndr_seq");
							sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = ComGetObjValue(formObj.vndr_nm);
							sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = ComGetObjValue(formObj.vndr_nm);
							sheetObjects[1].CellValue2(i,"pay_term_dys") = ComGetObjValue(formObj.pay_term_dys);
						}
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
						ComSetObjValue(formObj.pay_term_dys,"0");
						formObj.curr_cd.Code = "";

						//Ctrl Office 정보를 갱신한다.
						for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
							sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = "";
							sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = "";
							sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = "";
							sheetObjects[1].CellValue2(i,"pay_term_dys") = "";
						}
					}
				}
				break;

				case IBSEARCH_ASYNC02:	//조회(agreement no 입력시)
					//version no 조회
					var sCondition = new Array (
						new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.local_ofc_cd.value)
					)

					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					formObj.agmt_ver_no.RemoveAll();
					if(comboList[0] != null){
						for(var j = 0; j < comboList[0].length;j++){
							var tempText = comboList[0][j].split("|");

							formObj.agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
							//넘어온 값을 세팅한다.
							if(j == 0){
								defVerCode = tempText[0];
							}
						}
						formObj.agmt_ver_no.Code2 = defVerCode;

						//********************** IBSEARCH START  **********************//
						if(validateForm(sheetObj,formObj,IBSEARCH)){
							for(i = 0;i<sheetObjects.length;i++){
								sheetObjects[i].RemoveAll();
							}
							formObj.f_cmd.value = SEARCH;
							var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");

							//헤더 데이타 세팅
							if(arrXml[0] != null){
								//agmt_no 를 조회해온걸루 새루 세팅
								//ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								// G/W Contract YN
								ComSetObjValue(formObj.file_atch_flg, ComGetEtcData(arrXml[0], "file_atch_flg"));
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//version no
								formObj.agmt_ver_no.Code2  = ComGetEtcData(arrXml[0], "agmt_ver_no");
								//currency
								formObj.curr_cd.Code2  = ComGetEtcData(arrXml[0], "curr_cd");
								//agmt_ofc_cd
								formObj.agmt_ofc_cd.Code2  = ComGetEtcData(arrXml[0], "agmt_ofc_cd");
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								formObj.eq_knd_cd.Enable = false;
								formObj.eq_knd_cd.Code  = ComGetEtcData(arrXml[0], "eq_knd_cd");

								formObj.agmt_rmk.value =  ComGetEtcData(arrXml[0], "agmt_rmk");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
							}

							//쉬트 데이타 세팅
							for(var i = 1; i < arrXml.length + 1; i++){
								sheetObjects[i].LoadSearchXml(arrXml[i - 1]);
							}
							//조회 상태
							nowRetriveSt = true;
							//isVersionUp 상태표시
							formObj.isversionup.value = "N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						}
						//********************** IBSEARCH END  **********************//
					} else {
						//agmt_ver_no 세팅
						formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
						formObj.agmt_ver_no.Code2 = '1';
						defVerCode = '1';
						ComShowCodeMessage("MNR00165","data");
						ComSetObjValue(formObj.agmt_no, "");
						ComSetFocus(formObj.agmt_no);
					}

					retPossible = true;
				break;

			case IBSEARCH_ASYNC03:	//타리프 콤보 조회
				if(formObj.vndr_seq.value != ""){
					formObj.trf_no.RemoveAll();

					var ofcCd = formObj.local_ofc_cd.value;
					var mnrTrfKndCd = "LCL";
					var creDtFr = ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
					var creDtTo = ComGetNowInfo('ymd');
					var eqKndCd = formObj.eq_knd_cd.Code;
					var mnrTrfStsCd = "HA";
					var vndrSeq = formObj.vndr_seq.value;

					var f_query = "";
					f_query += 'f_cmd' + '=' + SEARCH03	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'ofc_cd' + '=' + ofcCd + "&";
					f_query += 'mnr_trf_knd_cd' + '=' + mnrTrfKndCd + "&";
					f_query += 'cre_dt_fr' + '=' + creDtFr + "&";
					f_query += 'cre_dt_to' + '=' + creDtTo + "&";
					f_query += 'eq_knd_cd' + '=' + eqKndCd + "&";
					f_query += 'mnr_trf_sts_cd' + '=' + mnrTrfStsCd + "&";
					f_query += 'vndr_seq' + '=' + vndrSeq;

					var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do","" ,f_query,true);

					//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
					var arrResult = MnrXmlToArray(sXml);

					var defSelTrfNo = "";
					formObj.trf_no.InsertItem(0,"","");
					if(arrResult != null){
						for(var i = 0; i < arrResult.length;i ++){
							if(i == 0){
								defSelTrfNo = arrResult[i][19];
							}
							var tempComboText = arrResult[i][19] + "|" + arrResult[i][11] + "|" + arrResult[i][2] + "|" + arrResult[i][21] + "|" + arrResult[i][0] + "|" + arrResult[i][6] + "|" + arrResult[i][25] + "|" + arrResult[i][7];
							formObj.trf_no.InsertItem(i + 1, tempComboText ,arrResult[i][19]);
						}
					}
					formObj.trf_no.Code = defSelTrfNo;
				}
				break;

			case IBSEARCH_ASYNC04:	//어그리먼트 사용여부 체크
					var agmtOfcCtyCd = formObj.agmt_ofc_cty_cd.value;
					var agmtSeq = formObj.agmt_seq.value;
					var agmtVerNo = formObj.agmt_ver_no.Code;
					var f_query = "";
					f_query += 'f_cmd' + '=' + SEARCH04	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'agmt_ofc_cty_cd' + '=' + agmtOfcCtyCd + "&";
					f_query += 'agmt_seq' + '=' + agmtSeq + "&";
					f_query += 'agmt_ver_no' + '=' + agmtVerNo;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do","" ,f_query,true);
					var searchResult = ComGetEtcData(sXml, "EST_LIST");

					if(searchResult != null && searchResult != ''){
						checkEstList = searchResult;
					} else {
						checkEstList = "XX";
					}
				break;

			case IBSEARCH_ASYNC05:	//버젼업 하기전 미승인 견적서가 존재하는지 체크
					var agmtOfcCtyCd = formObj.agmt_ofc_cty_cd.value;
					var agmtSeq  = formObj.agmt_seq.value;
					var agmtVerNo = formObj.agmt_ver_no.Code;
					var f_query = "";
					f_query += 'f_cmd' + '=' + SEARCH05	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'agmt_ofc_cty_cd' + '=' + agmtOfcCtyCd + "&";
					f_query += 'agmt_seq' + '=' + agmtSeq + "&";
					f_query += 'agmt_ver_no' + '=' + agmtVerNo;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0015GS.do","" ,f_query,true);
					var searchResult = ComGetEtcData(sXml, "EST_LIST");

					if(searchResult != null && searchResult != ''){
						notApprovalEstList = searchResult;
					} else {
						notApprovalEstList = "XX";
					}
				break;
		}
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj ,disPlayArray ) {
		 with(tabObj){
			 RemoveAll();
			 var cnt  = 0 ;
			 for(var j = 0; j < disPlayArray.length;j++){
				InsertTab( cnt++ , disPlayArray[j][6] , -1 );
			 }
			 BaseColor = '#f3f2f8';
		 }
	}

	/**
	 * COM_ENS_071 의 값을 받은 함수
	 */
	function getCOM_ENS_071(aryPopupData, row, col, shhetIdx){
		 var formObj = document.form;

		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[1].CellValue(row,col) = aryPopupData[0][3];
		 }
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tabLayer");

			objs[nItem].style.display = "Inline";
			objs[beforetab].style.display = "none";

			//--------------- 요기가 중요 --------------------------//
			objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
			//------------------------------------------------------//
			beforetab = nItem;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
				case IBSAVE:
					//가변적 필수 입력 사항 체크
					ComSetFocus(formObj.agmt_no);

					//Transmission Mode에 따른  E,F,M,W
					for(i = 1;i <= sheetObjects[1].LastRow;i++){
						if(sheetObjects[1].CellValue(i,"trsm_mod_cd") == "E"){
							if(sheetObjects[1].CellValue(i,"edi_id") == ""){
								ComShowCodeMessage("MNR00003", "EDI ID");
								sheetObjects[1].SelectCell(i, "edi_id", true);
								return false;
							}
						} else if(sheetObjects[1].CellValue(i,"trsm_mod_cd") == "F"){
							if(sheetObjects[1].CellValue(i,"fax_no") == ""){
								ComShowCodeMessage("MNR00003", "FAX_NO");
								sheetObjects[1].SelectCell(i, "fax_no", true);
								return false;
							}
						} else if(sheetObjects[1].CellValue(i,"trsm_mod_cd") == "M"){
							if(sheetObjects[1].CellValue(i,"mnr_prnr_eml") == ""){
								ComShowCodeMessage("MNR00003", "E-MAIL");
								sheetObjects[1].SelectCell(i, "mnr_prnr_eml", true);
								return false;
							}
						} else if(sheetObjects[1].CellValue(i,"trsm_mod_cd") == "W"){
							if(sheetObjects[1].CellValue(i,"sp_ptal_id") == ""){
								ComShowCodeMessage("MNR00003", "Web Service Potral ID");
								sheetObjects[1].SelectCell(i, "sp_ptal_id", true);
								return false;
							}
						}
					}
					//쉬트에  데이타가 하나두 없다면
					var checkSheetDataCnt = false;
					for(i = 2;i < sheetObjects.length;i++){
						if(sheetObjects[i].RowCount > 0){
							checkSheetDataCnt = true;
						}
					}
					if(!checkSheetDataCnt){
						ComShowCodeMessage("MNR00195");
						return false;
					}

					//CURRCD 가 없다면
					if(formObj.curr_cd.Code == ""){
						ComShowCodeMessage("MNR00172","Currency ");
						formObj.curr_cd.focus();
						return false;
					}

					//Cost ctrl office 는  무조건 한개 이상 입력
					if(sheetObjects[1].LastRow <= 0 ){
						ComShowCodeMessage("MNR00187");
						return false;
					}

					//ctrl office code 는 중복되어서는 안된다.
					if(sheetObjects[1].IsDataModified){
						var Row = sheetObjects[1].ColValueDup("aply_ofc_cd");
						if(Row > 0){
							ComShowCodeMessage("MNR00006", "Cost CTRL Office Sheet of " + Row + " row ");
							sheetObjects[1].SelectCell(Row, "aply_ofc_cd", true);
							return false;
						}
					}

					//LB => cost_cd , QT => cost_dtl_cd , TS => cost_dtl_cd|mnr_rt_tp_cd 는 중복되어서는 안된다.
					var targetTab = new Array();
					if(formObj.eq_knd_cd.Code == 'U'){
						targetTab = uTab;
					} else if (formObj.eq_knd_cd.Code == 'G'){
						targetTab = gTab;
					} else if (formObj.eq_knd_cd.Code == 'Z'){
						targetTab = zTab;
					}
					var sheetBugMod = 0;
					var checkCol = "";
					for (var i = 2; i < targetTab.length + 2; i++){
						if(sheetObjects[i].IsDataModified){
							if(sheetObjects[i].HeaderRows > 1){
								sheetBugMod = 1 - sheetObjects[i].HeaderRows;
							} else {
								sheetBugMod = 0;
							}

							if(targetTab[i - 2][0] == "LB"){
								checkCol = "cost_cd|cost_dtl_cd";
								/*	Agreement Creation의 Rate 입력에서 '0'값도 입력 및 Save가능하게 해주세요. [2010-02-17]
								var checkNomal = sheetObjects[i].FindText("agmt_rt_amt", "0.00");
								if(checkNomal != -1){
									ComShowCodeMessage("MNR00201", targetTab[i - 2][6] + " tab of " + (checkNomal) + " row ");
									sheetObjects[i].SelectCell(checkNomal, "agmt_rt_amt", true);
									return false;
								}
								*/
							} else if(targetTab[i - 2][0] == "QT"){
								checkCol = "cost_dtl_cd";
								//QTY는 0이 될수 없음
								/* Agreement Creation의 QTY 입력에서 '0' 값도 입력 및 Save가능하게 해주세요. [2010-02-17]
								for (ir = sheetObjects[i].HeaderRows; ir <= sheetObjects[i].LastRow; ir++){
									if(sheetObjects[i].CellValue(ir,"rpr_qty") == "0"){
										ComShowCodeMessage("MNR00224", targetTab[i - 2][6] + " tab of " + (ir) + " row ");
										sheetObjects[i].SelectCell(ir, "rpr_qty", true);
										return false;
									}
								}
								*/
							} else if(targetTab[i - 2][0] == "TS"){
								checkCol = "cost_dtl_cd|mnr_rt_tp_cd";
							}

							var Row = sheetObjects[i].ColValueDup(checkCol);
							if(Row > 0){
								ComShowCodeMessage("MNR00006", targetTab[i - 2][6] + " tab of " + (Row + sheetBugMod) + " row ");
								sheetObjects[i].SelectCell(Row, checkCol, true);
								return false;
							}
						}
					}

					//폼중 필수 입력값이 다 제대로 들어갔는지
					if (!ComChkValid(formObj)) return false;

					//타리프가  없어두 정말 저장할건지
					if(formObj.trf_no.Code == ""){
						//저장 의사 확인
						if (!ComShowCodeConfirm("MNR00202")){return false;}
					} else {
						//저장 의사 확인
						if (!ComShowCodeConfirm("MNR00183")){return false;}
					}
					return true;
					break;
				//버젼업
				case IBCREATE:
					if( formObj.agmt_no.value == "" || formObj.agmt_no.value == "NEW") {
						ComShowCodeMessage("MNR00172","Agreement No For Version Up ");
						ComSetFocus(formObj.agmt_no);
						return false;
					} else if ( formObj.agmt_ver_no.Code == "") {
						ComShowCodeMessage("MNR00172","Version No For Version Up ");
						formObj.agmt_ver_no.focus();
						return false;
					} else {
						formObj.agmt_ofc_cty_cd.value = formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value = parseInt(agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
					break;
				//IBSEARCHAPPEND 삭제임 변수 부족
				case IBSEARCHAPPEND:
					if( formObj.agmt_no.value == "" || formObj.agmt_no.value == "NEW") {
						ComShowCodeMessage("MNR00047");
						ComSetFocus(formObj.agmt_no);
						return false;
					} else if ( formObj.agmt_ver_no.Code == "") {
						ComShowCodeMessage("MNR00047");
						formObj.agmt_ver_no.focus();
						return false;
					} else {
						formObj.agmt_ofc_cty_cd.value = formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value = parseInt(agmt_no.value.substring(3,formObj.agmt_no.value.length),10);

						//checkEstList <== 해당 어그리먼트를 사용하고 있는 견적서 리스트
						if(checkEstList != 'XX'){
							ComShowCodeMessage("MNR00342",checkEstList);
							return false;
						} else {
							//삭제 의사 확인
							if(!ComShowCodeConfirm("MNR00046")){return false;}
						}
						return true;
					}
					break;
				case IBSEARCH:
					if( formObj.agmt_no.value == ""  || formObj.agmt_no.value == "NEW") {
						ComShowCodeMessage("MNR00172","Agreement No For Search ");
						ComSetFocus(formObj.agmt_no);
						return false;
					} else if ( formObj.agmt_ver_no.Code == ""  ) {
						ComShowCodeMessage("MNR00172","Version No For Search ");
						formObj.agmt_ver_no.focus();
						return false;
					} else {
						formObj.agmt_ofc_cty_cd.value = formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value = parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
					break;

				case IBSEARCH_ASYNC01:
					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("MNR00172","Service Provider Seq ");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
					break;
			}
		}
		return true;
	}

	function setComboEnable(changeValue){
		var formObj = document.form;
		for(var i = 1; i < comboObjects.length;i++){
			comboObjects[i].Enable = changeValue;
		}

		if(changeValue == true){
			if(formObj.vndr_seq.value == ""){
				formObj.trf_no.Enable = false;
			} else {
				formObj.trf_no.Enable = true;
			}
		}

		if(nowRetriveSt == true){
			formObj.eq_knd_cd.Enable = false;
		} else {
			formObj.eq_knd_cd.Enable = true;
		}
	}

	/**
	 * 조회 + 설정
	 */
	function setTrfCombo(trfNo){
		var formObj = document.form;

		if(formObj.vndr_seq.value == ""){
			formObj.trf_no.Enable = false;
			formObj.trf_no.RemoveAll();
			formObj.trf_no.Code2 = "";
		} else {
			formObj.trf_no.Enable = true;
			if(formObj.agmt_ver_no.Code == defVerCode){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
				formObj.trf_no.Code2 = trfNo;
			} else {
				formObj.trf_no.RemoveAll();
				formObj.trf_no.InsertItem(0,trfNo,trfNo);
				formObj.trf_no.Code2 = trfNo;
			}
		}

		if(formObj.agmt_ver_no.Code == defVerCode){
			formObj.trf_no.Enable = true;
		} else {
			formObj.trf_no.Enable = false;
		}
	}

	function trf_no_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;

		var selCurrCd	= ComTrim(comboObj.GetText(Index_Code, 7));
		var priCurrCd	= ComTrim(formObj.curr_cd.Code);

		if(Index_Code != ""){
			var formObj  = document.form;

			if(selCurrCd != priCurrCd) {
				var usrOk = ComShowCodeConfirm("MNR00203",selCurrCd);
				if(usrOk){
					formObj.curr_cd.Code2 = selCurrCd;
					ComSetFocus(formObj.agmt_ref_no);
				} else {
					formObj.trf_no.Code2 = priTrfNo;
					ComSetFocus(formObj.agmt_ref_no);
				}
			}
		}
		priTrfNo = formObj.trf_no.Code;
	}

	function agmt_ver_no_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;
		if(comboObj.Code == defVerCode){
			if(!loadIbclear){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_del");
				ComBtnEnable("btn_versionup");
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_s1del");
				ComBtnEnable("btn_calendar");
				ComBtnEnable("btn_calendar1");
			}
			MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			//데이타 수정 가능하게
			setComboEnable(true);

			for(var i = 1; i < sheetObjects.length; i++){
				sheetObjects[i].Editable = true;
			}
		} else {
			if(!loadIbclear){
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_del");
				ComBtnDisable("btn_versionup");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_s1del");
				ComBtnDisable("btn_calendar");
				ComBtnDisable("btn_calendar1");
			}
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			//데이타 수정 못하게
			setComboEnable(false);

			for(var i = 1; i < sheetObjects.length; i++){
				sheetObjects[i].Editable = false;
			}
		}

		//초기세팅시에는 조회 안하게
		if(formObj.agmt_no.value != "NEW" && formObj.agmt_no.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}

	/*
	function curr_cd_OnChange(comboObj,Index_Code, Text){
	}

	function agmt_ofc_cd_OnChange(comboObj,Index_Code, Text){
	}
	*/

	//EQ_TYPE콤보 이벤트
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;
		//확인 메세지
		if(formObj.agmt_no.value == "NEW"){
			var cnt = 0;
			for (var i = 2; i < sheetObjects.length; i++){
				cnt += sheetObjects[i].RowCount;
			}
			if(cnt > 0) {
				//변경의사 확인
				if(!ComShowCodeConfirm("MNR00192")) {
					formObj.eq_knd_cd.Code2 = tempEqKndCd;
					return;
				}
			}
		}

		var objs = document.all.item("tabLayer");
		tempEqKndCd = comboObj.Code;

		//텝세팅	쉬트세팅 0 1 쉬트는 다른용도로 사용
		//mnr_ord_tp_cd|ibflag|eq_type|dp_seq|tab_type|cost_cd|tab_title|pagerows
		//QT~~I~~Z~~6~~OT~~MRZSOT~~Other
		objs[beforetab].style.display = "none";
		ComOpenWait(true,true);

		if(comboObj.Code == 'U'){
			for(var i = 0; i < uTab.length ; i++){
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],uTab[i][0],comboObj.Code,uTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],uTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(uTpSz, "|");
		} else if (comboObj.Code == 'G'){
			for(var i = 0; i < gTab.length ; i++){
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],gTab[i][0],comboObj.Code,gTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],gTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(gTpSz, "|");
		} else if (comboObj.Code == 'Z'){
			for(var i = 0; i < zTab.length ; i++){
				sheetObjects[i + 2].Reset();
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],zTab[i][0],comboObj.Code,zTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],zTab);
			formObj.agmt_type_tpsz.value = ComGetAryJoin(zTpSz, "|");
		}

		//RC 타입은 일단 모두 깔아준다. 이벤트 때문에  HARDCODING으로 변경
		sheetObjects[2].RemoveAll();
		var sCode = sheetObjects[2].GetComboInfo(0,"cost_cd", "Code");
		var arrCode = sCode.split("|");

		for(var i = 0;i < arrCode.length;i++){
			var Row = sheetObjects[2].DataInsert(-1);
			sheetObjects[2].CellEditable(Row,"cost_cd") = false;
			sheetObjects[2].CellValue2(Row,"cost_cd") = arrCode[i];
		}

		ComOpenWait(false,true);
		objs[beforetab].style.display = "inline";

		//추가 요청 사항 eq_type 변할시 타리프 콤보도 변해야 한다.
		if(formObj.eq_knd_cd.Enable == true){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
		}
	}

	//삭제 버튼 클릭시 발생시킬 메세지
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00020",ErrMsg);
		} else {
			ComShowCodeMessage("MNR00048",ErrMsg);
		}
	}

	//저장  버튼 클릭시 발생시킬 메세지
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",ErrMsg);
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}

	//오피스코드 벨리데이션 체크
	function sheet2_OnChange(sheetObj,Row, Col, Value)	{
		var retArray =  null;
		if (sheetObj.ColSaveName(Col) == "aply_ofc_cd"){
			doCheckOffice(sheetObj,Row,Col);
		}
	}

	function doCheckOffice(sheetObj,Row,Col){
		var checkOffice = sheetObj.CellValue(Row ,Col);

		retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",checkOffice);
			sheetObj.CellValue2(Row ,Col) = "";
			sheetObj.SelectCell(Row ,Col);
		} else {
			sheetObj.CellValue(Row ,"ctrl_ofc_cd") = sheetObj.CellValue(Row ,Col);
			return;
		}
	}

	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 0;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 1;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t3sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 2;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t4sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 3;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t5sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 4;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t6sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 5;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t7sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 6;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t8sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex = 7;

		var disPlayTpSz = new Array();
		var disPlayTab = new Array();
		if(formObj.eq_knd_cd.Code == 'U'){
			disPlayTpSz = uTpSz;
			disPlayTab = uTab;
		} else if(formObj.eq_knd_cd.Code == 'G'){
			disPlayTpSz = gTpSz;
			disPlayTab = gTab;
		} else if(formObj.eq_knd_cd.Code == 'Z'){
			disPlayTpSz = zTpSz;
			disPlayTab = zTab;
		}

		var prefixValue = sheetObj.CellValue(Row,"cost_dtl_cd");

		var checkedList = "";
		for(var x = 1 ; x <= sheetObj.RowCount;x++){
			if(prefixValue == sheetObj.CellValue(x,"cost_dtl_cd")){
				checkedList = checkedList + (sheetObj.CellValue(x,"mnr_rt_tp_cd") + "|");
			}
		}
		checkedList = MnrDelLastDelim(checkedList);
		var param ="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function t1sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t2sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function t3sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t4sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t5sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t6sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t7sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}
	function t8sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz = new Array();

			if(formObj.eq_knd_cd.Code == 'U'){
				disPlayTpSz = uTpSz;
			} else if(formObj.eq_knd_cd.Code == 'G'){
				disPlayTpSz = gTpSz;
			} else if(formObj.eq_knd_cd.Code == 'Z'){
				disPlayTpSz = zTpSz;
			}

			var checkResult = false;
			for(var i = 0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult = true;
				}
			}

			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.CellValue2(Row,Col) ="";
				sheetObj.SelectCell(Row,Col, true);
			}
		}
	}

	function sheet2_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) != "aply_ofc_cd") return;

		var param = "?row=" + row + "&col=" + col;
		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}

	/**
	 * EES_MNR_0016 Popup의 값을 받은 함수
	 */
	function setEES_MNR_0016(aryPopupData, row, col, shhetIdx){
		var formObj = document.form;

		if(aryPopupData[0][6] != null && aryPopupData[0][6] != "") {
			formObj.agmt_no.value = aryPopupData[0][6];
		}

		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
	}

	/**
	 * EES_MNR_0017 Popup의 값을 받은 함수
	 */
	function setEES_MNR_0017(strAtchFlg){
		var formObj = document.form;

		formObj.file_atch_flg.value = strAtchFlg;
	}

	function getMnr_psMulti(aryPopupData,sheet_id,temp_value1){
		//temp value는 기호에 맞게 사용  0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals = temp_value1.split("|");
		var formObj = document.form;
		var targetSheet = sheetObjects[sheet_id];
		//값이 없는 놈들은 모두 삭제한다.
		var startpoint = targetSheet.RowCount;
		for(var i = startpoint; i >= 1 ; i--){
			if(targetSheet.CellValue(i,"mnr_rt_tp_cd")	== ""){
				targetSheet.RowDelete(i, false);	//완전 삭제
			}
		}

		for(var j = 0; j < aryPopupData.length ; j++){
			var isHaveTpSz = false;
			for(var i = 1;i <= targetSheet.RowCount;i++){
				if(targetSheet.CellValue(i,"cost_dtl_cd") == tempVals[0] && targetSheet.CellValue(i,"mnr_rt_tp_cd") == aryPopupData[j]){
					isHaveTpSz = true;
				}
			}

			if(!isHaveTpSz){
				var Row = targetSheet.DataInsert(-1);

				targetSheet.CellValue2(Row,"agmt_ofc_cty_cd") = formObj.agmt_ofc_cty_cd.value;
				targetSheet.CellValue2(Row,"agmt_seq") = formObj.agmt_seq.value;
				targetSheet.CellValue2(Row,"agmt_ver_no") = formObj.agmt_ver_no.Code;
				targetSheet.CellValue2(Row,"mnr_rt_tp_cd") = aryPopupData[j];
				targetSheet.CellValue2(Row,"cost_cd") = tempVals[1];
				targetSheet.CellValue2(Row,"cost_dtl_cd") = tempVals[0];
			}
		}

		if(targetSheet.RowCount > 1){
			targetSheet.SelectCell(1, "agmt_rt_amt", false);
		}
	}

	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value = ComLpad(aryPopupData[0][2],6,"0");
			formObj.vndr_nm.value  = aryPopupData[0][4];
			var sXml = MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");

			if(ComGetEtcData(sXml, "vndr_seq") != null){
				//Vender nm 세팅
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));

				//Curr 세팅
				formObj.curr_cd.Code  = ComGetEtcData(sXml, "pay_curr_cd");

				//PAY TERM 세팅
				var tempPayTerm = ComGetEtcData(sXml, "gen_pay_term_cd");

				if(tempPayTerm != ""){
					if("O60" == tempPayTerm || "O45" == tempPayTerm){
						ComSetObjValue(formObj.pay_term_dys,"0");
					} else if ("IN" == tempPayTerm){
						ComSetObjValue(formObj.pay_term_dys,"5");
					} else if ("OUT" == tempPayTerm){
						ComSetObjValue(formObj.pay_term_dys,"60");
					} else {
						ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
					}
				}

				//Ctrl Office 정보를 갱신한다.
				for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
					sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = ComGetEtcData(sXml, "vndr_seq");
					sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = ComGetObjValue(formObj.vndr_nm);
					sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = ComGetObjValue(formObj.vndr_nm);
					sheetObjects[1].CellValue2(i,"pay_term_dys") = ComGetObjValue(formObj.pay_term_dys);
				}
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				ComSetObjValue(formObj.vndr_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
				ComSetObjValue(formObj.pay_term_dys,"0");
				formObj.curr_cd.Code = "";

				//Ctrl Office 정보를 갱신한다.
				for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
					sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = "";
					sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = "";
					sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = "";
					sheetObjects[1].CellValue2(i,"pay_term_dys") = "";
				}
			}
		}
	}

	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch
		var formObject = document.form;
		axon_event.addListenerForm  ('blur',	 'obj_deactivate',  formObject);			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',	'obj_activate',	formObject,	'agmt_no');		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress',	formObject);			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}

	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}

	function obj_activate(){
		var obj = event.srcElement;
		//버그성 agmt_no 일단 막아놈
		if(obj.name != "agmt_no"){
			ComClearSeparator(event.srcElement);

		} else {
			obj.style.imeMode = "disabled" ;
		}
	}

	function obj_change(){
		var obj = event.srcElement;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
				case "vndr_seq":
					formObj.vndr_seq.value =  ComLpad(formObj.vndr_seq.value,6,"0");
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);
					formObj.trf_no.Enable = true;
					break;
				case "agmt_no":
					formObj.agmt_no.value = formObj.agmt_no.value.substring(0,3) + ComLpad(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length), 6, "0");
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
					break;
				case "pay_term_dys":
					//Ctrl Office 정보를 갱신한다.
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"pay_term_dys") = ComGetObjValue(formObj.pay_term_dys);
					}
					break;
				case "eff_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"eff_dt") = ComGetObjValue(formObj.eff_dt);
					}
					if(!ComIsDate(formObj.eff_dt.value, 'ymd')){
						ComShowCodeMessage("MNR00015");
						formObj.eff_dt.value = "";
						ComSetFocus(formObj.eff_dt);
					}
					break;
				case "exp_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"exp_dt") = ComGetObjValue(formObj.exp_dt);
					}
					if(!ComIsDate(formObj.exp_dt.value, 'ymd')){
						ComShowCodeMessage("MNR00015");
						formObj.exp_dt.value = "";
						ComSetFocus(formObj.exp_dt);
					}
					break;
				case "agmt_dt":
					if(!ComIsDate(formObj.agmt_dt.value, 'ymd')){
						ComShowCodeMessage("MNR00015");
						formObj.agmt_dt.value = "";
						ComSetFocus(formObj.agmt_dt);
					}
					break;


			}
		} else {
			switch(obj.name) {
				case "vndr_seq":
					formObj.vndr_nm.value = "";
					formObj.trf_no.RemoveAll();
					formObj.trf_no.Code = "";
					formObj.trf_no.Enable = false;

					//Ctrl Office 정보를 갱신한다.
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"mnr_prnr_seq") = "";
						sheetObjects[1].CellValue2(i,"mnr_prnr_lgl_eng_nm") = "";
						sheetObjects[1].CellValue2(i,"mnr_prnr_locl_lang_nm") = "";
						sheetObjects[1].CellValue2(i,"pay_term_dys") = "";
					}
					break;
				case "agmt_no":
					//agmt_ver_no 세팅
					formObj.agmt_ver_no.RemoveAll();
					formObj.agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
					defVerCode = '1';
					formObj.agmt_ver_no.Code = defVerCode;
					break;
				case "pay_term_dys" :
					//Ctrl Office 정보를 갱신한다.
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"pay_term_dys") = "";
					}
					break;
				case "eff_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"eff_dt") = "";
					}
					break;
				case "exp_dt":
					for(var i = 1; i <= sheetObjects[1].LastRow ;i++){
						sheetObjects[1].CellValue2(i,"exp_dt") = "";
					}
					break;
			}
		}
	}

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
			case "saupja":
				ComKeyOnlyNumber(obj);
				break;
			case "int":
				ComKeyOnlyNumber(obj);
				break;
			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;
			case "eng":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engup":
				if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else if(obj.name = "agmt_ref_no"){
					ComKeyOnlyAlphabet('uppernum',"45");
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
				break;
			case "engdn":
				//포멧 처리를 하지 않기 위해
				if(obj.name == "phn_no" || obj.name == "fax_no"){
					ComKeyOnlyNumber(obj, "-");
				}	else {
					ComKeyOnlyAlphabet('lower');
				}
				break;
		}
	}
	/* 개발자 작업  끝 */