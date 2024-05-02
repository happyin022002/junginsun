/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0104.js
 *@FileTitle : (New)Slot Hire
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.29
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.07.29  민정호
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
 * @class fns_joo_0104 : fns_joo_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0104() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업   */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

var gRefresh = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	var srcName = window.event.srcElement.getAttribute("name");

	if (srcName == null) {
		return;
	}

	switch (srcName) {
	    case "btn1_call_batch":                	
			doActionIBSheet(sheetObject, formObject, "CALLBATCH");
	        break;
	        
		case "btn1_save": //SAVE			
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
					
		case "btn1_Retrieve": //RETRIEVE
			if(formObject.page_no.value == ""){
				formObject.page_no.value = "1";
			}		
			
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
	
		case "btn1_New": //NEW
			UF_reset();
			reset_all();	// 페이지 초기화
			break;
	
		case "btn1_Down_Excel": //DownExcel
			sheetObjects[0].SpeedDown2Excel(-1, true, true);
			break;
																	
		case "reward":
			var ipageNo = formObject.page_no.value;
			ipageNo--;
			
			if(ipageNo < 1){
				ipageNo = 1;
			}
			
			formObject.page_no.value = ipageNo;
			break;

		case "forward":
			var ipageNo = formObject.page_no.value;
			var totpage = formObject.tot_page_cnt.value;
			ipageNo++;  
			formObject.page_no.value = ipageNo;
			break;			
						
		case "btn_add":
			var row = sheetObjects[0].DataInsert(-1);
			
			break;
			
		case "btn_delete":
			JooRowHideDelete(sheetObjects[0], prefix+"jo_fsh_flg");
			break;								
	} // end switch
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	initControl();
}
/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject = document.form

	switch (comboNo) {
		case 1: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gTrdCd) != ""){
				var comboItems = (" |"+gTrdCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break; 
			
		case 2: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
				MaxLength=5;
			}
			if (ComTrim(gRlaneCd) != ""){
				var comboItems = (" |"+gRlaneCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;
			
		case 3: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gJoCrrCd) != ""){
				var comboItems = (" |"+gJoCrrCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;
			
		case 4: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}

			comboObj.InsertItem(0, "", "");
			comboObj.InsertItem(1, "411221", "411221");
			comboObj.InsertItem(2, "411223", "411223");
			comboObj.InsertItem(3, "411222", "411222");
			comboObj.InsertItem(4, "510921", "510921");
			comboObj.InsertItem(5, "510922", "510922");
			comboObj.InsertItem(6, "510991", "510991");

			break;		

		case 5: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}

			comboObj.InsertItem(0, "", "");
			comboObj.InsertItem(1, "Settle", "S");
			comboObj.InsertItem(2, "UnSettle", "U");

			break;	

	}
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {

	var formObject = document.form;

	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_next");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_next");
    axon_event.addListener('click', 're_divr_cd_click', 're_divr_cd');

	axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);

// 추가(민정호)	
//	if (gClzFlg == "N") {
		fnBtnEnable("C", true);
//	} else {
//		fnBtnEnable("C", false);
//	}		
}

function re_divr_cd_click(){
	UF_setCond("1");
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
		// 높이 설정
		style.height = 390;
		// 헤더 높이 설정
		sheetObj.HeadRowHeight  = 10;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;
		
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;				
		
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
				
		var HeadTitle2 = "STS||Seq.|Revenue\nMonth|Rev/Exp|Trade|Carrier\nCode|Service\nProvider/\nCustomer|VVD|VVD|VVD|VVD|Revenue\nLane|BSA\nType|Account\nCode" +
								"|BSA|BSA"+
								"|Standard BSA\nfor the 1st settlement|Standard BSA\nfor the 1st settlement"+
								"|SELADG/SINRS\nBSA|SELADG/SINRS\nBSA"+				
								"|BSA\nTEU x Slot Price|CSR\nCreated Amount|SELADG/SINRS BSA\nTEU x Slot Price|Work in progress\n(Before CSR) Amount"+								
							    "|Review\nResult|Settle\nResult|Manual\nSettle|Remark|S.Lane\n1st Port ETD|Revenue\nPort|Revenue\nPort ETD"+
								"|20'HC|20'HC" +
								"|40'HC|40'HC" +
								"|45'|45'|45'" +
								"|Allocation|Allocation|TEU/TON|Round\nType" +
								"|RF Alloc|RF Alloc"+
								"|STL_VVD_SEQ|BSA_RANK|OP_CRR_CD|acct_yrmon|jo_fsh_flg2";								

		var HeadTitle3 = "STS||Seq.|Revenue\nMonth|Rev/Exp|Trade|Carrier\nCode|Service\nProvider/\nCustomer|VSL|VOY|Dir.|Fin\nDir.|Revenue\nLane|BSA\nType|Account\nCode" +
								"|TEU|Slot Price"+
								"|TEU|Slot Price"+
								"|TEU|Slot Price"+
								"|BSA\nTEU x Slot Price|CSR\nCreated Amount|SELADG/SINRS BSA\nTEU x Slot Price|Work in progress\n(Before CSR) Amount"+								
							    "|Review\nResult|Settle\nResult|Manual\nSettle|Remark|S.Lane\n1st Port ETD|Revenue\nPort|Revenue\nPort ETD"+													
								"|Sub-Alloc|Over Ratio\n(TEU)" +
								"|Sub-Alloc|Over Ratio\n(TEU)" +
								"|Sub-Alloc|Under Ratio\n(TEU)|Over Ratio\n(TEU)" +
								"|OUS BSA|OUS\nWeight|TEU/TON|Round\nType" +
								"|Ocean|Inter"+
								"|STL_VVD_SEQ|BSA_RANK|OP_CRR_CD|acct_yrmon|jo_fsh_flg2";				
		
				
		var headCount = ComCountHeadTitle(HeadTitle2);
		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);
		
		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)
						
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
		InitHeadRow(0, HeadTitle2, true);
		InitHeadRow(1, HeadTitle3, true);		
				
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtStatus       ,30, daCenter,  true, prefix+"ibflag"  );		
		InitDataProperty(0, cnt++, dtCheckBox ,30, daCenter,   true, prefix+"jo_fsh_flg");
		InitDataProperty(0, cnt++, dtData    	    ,30, daCenter,   true, prefix+"seq_no"              , false, "", dfNone  , 0, false, false);		
		InitDataProperty(0, cnt++, dtData          ,60, daCenter,  true, prefix+"rev_yrmon"         ,false, "", dfUserFormat2       ,0,false,true);
		InitDataProperty(0, cnt++, dtCombo      ,60, daCenter,  true, prefix+"re_divr_cd"         	   ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtData	         ,60, daCenter,  true, prefix+"trd_cd"       		      ,false, "", dfNone       ,0,false,true);		
		InitDataProperty(0, cnt++, dtData          ,60, daCenter,  true, prefix+"crr_cd"         	   ,false, "", dfNone       ,0,false,true); 
		InitDataProperty(0, cnt++, dtData          ,70, daCenter,  true, prefix+"vndr_cust"         ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtData          ,45, daCenter,  true, prefix+"vsl_cd"    		   ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtData          ,50, daCenter,  true, prefix+"skd_voy_no"       ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtData          ,30, daCenter,  true, prefix+"skd_dir_cd"         ,false, "", dfNone       ,0,false,true); 
		InitDataProperty(0, cnt++, dtData          ,30, daCenter,  true, prefix+"rev_dir_cd"         ,false, "", dfNone       ,0,false,true);		
		InitDataProperty(0, cnt++, dtData          ,60, daCenter,  true, prefix+"rlane_cd"        		 ,false, "", dfNone       ,0,false,true); 
		InitDataProperty(0, cnt++, dtCombo      ,100, daCenter,  true, prefix+"jo_stl_jb_cd"         ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtData          ,60, daCenter,  true, prefix+"acct_cd"         		,false, "", dfNone       ,0,false,true);
		//-----------------------------------------------------------------------------------------------------------------------------		
		InitDataProperty(0, cnt++, dtData          ,50, daRight,  true, prefix+"bsa_qty"         		,false, "", dfNullFloat ,2,false,true);
		InitDataProperty(0, cnt++, dtData          ,60, daRight,  true, prefix+"bsa_slt_prc"         	,false, "", dfNullFloat ,2,false,true);  
		InitDataProperty(0, cnt++, dtData          ,70, daRight,  true, prefix+"act_bsa_qty"        	,false, "", dfNullFloat ,2,false,true);
		InitDataProperty(0, cnt++, dtData          ,70, daRight,  true, prefix+"act_slt_prc"          	,false, "", dfNullFloat ,2,false,true);
		InitDataProperty(0, cnt++, dtData          ,90, daRight,  true, prefix+"fnl_bsa_qty"         	,false, "", dfNullFloat ,2,true,true); 
		InitDataProperty(0, cnt++, dtData          ,90, daRight,  true, prefix+"fnl_bsa_slt_prc"    	,false, "", dfNullFloat ,2,true,true);
		InitDataProperty(0, cnt++, dtData          ,120, daRight,  true, prefix+"estm_stl_amt"      	,false, "|sheet1_bsa_qty|*|sheet1_bsa_slt_prc|", dfNullFloat ,2,false,true);		
		InitDataProperty(0, cnt++, dtData          ,120, daRight,  true, prefix+"act_stl_amt"         	,false, "", dfNullFloat ,2,false,true);		
		InitDataProperty(0, cnt++, dtData          ,120, daRight,  true, prefix+"fnl_stl_amt"        	,false, "|sheet1_fnl_bsa_qty|*|sheet1_fnl_bsa_slt_prc|", dfNullFloat ,2,true,true);
		InitDataProperty(0, cnt++, dtData          ,120, daRight,  true, prefix+"stl_amt"         		,false, "", dfNullFloat ,2,false,true);		// Settle Amout (정산 중인 Amount)				
		//-----------------------------------------------------------------------------------------------------------------------------		
		InitDataProperty(0, cnt++, dtCombo      ,80, daCenter,  true, prefix+"adj_rslt_cd"         				,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtCombo      ,80, daCenter,  true, prefix+"jo_stl_sts_cd2"       			,false, "", dfNone       ,0,false,false);		
		InitDataProperty(0, cnt++, dtCombo      ,80, daCenter,  true, prefix+"jo_stl_sts_cd"         			,false, "", dfNone       ,0,true,true);		
		InitDataProperty(0, cnt++, dtData          ,80, daCenter,  true, prefix+"adj_rmk"       		 		 	 ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtData          ,120, daCenter,  true, prefix+"n1st_lodg_port_etd_dt"      ,false, "", dfUserFormat2       ,0,false,true); 
		InitDataProperty(0, cnt++, dtData          ,80, daCenter,  true, prefix+"lst_lodg_port_cd"        		 ,false, "", dfNone       ,0,false,true); 
		InitDataProperty(0, cnt++, dtData          ,120, daCenter,  true, prefix+"lst_lodg_port_etd_dt"         ,false, "", dfUserFormat2       ,0,false,true);
		//-----------------------------------------------------------------------------------------------------------------------------		
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_20ft_sub_teu_qty"         ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_20ft_ovr_rto"       		     ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_40ft_sub_teu_qty"         ,false, "", dfNone       ,0,true,true); 
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_40ft_ovr_rto"         		 ,false, "", dfNone       ,0,true,true); 
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_45ft_sub_teu_qty"         ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_45ft_ovr_rto"       			 ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_45ft_und_rto"        		 ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_ovr_bsa_teu_qty"         ,false, "", dfNone       ,0,true,true);		
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_ovr_ton_wgt"         		,false, "", dfNone       ,0,true,true);
		
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_ton_teu_qty"       		    ,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden      	,80, daCenter,  true, prefix+"jo_rnd_rule_lvl"        			,false, "", dfNone       ,0,true,true);
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_rf_ocn_prc"         		,false, "", dfNone       ,0,true,true);		
		InitDataProperty(0, cnt++, dtHidden          ,80, daCenter,  true, prefix+"jo_rf_inter_prc"         		,false, "", dfNone       ,0,true,true);		
		//-----------------------------------------------------------------------------------------------------------------------------
		InitDataProperty(0, cnt++, dtHidden       ,80, daCenter,  true, prefix+"stl_vvd_seq"         ,false, "", dfNone       ,0,false,true);			
		InitDataProperty(0, cnt++, dtHidden   	 ,80, daCenter,  true, prefix+"bsa_rank" 		      ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtHidden   	 ,80, daCenter,  true, prefix+"op_crr_cd" 		      ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtHidden   	 ,80, daCenter,  true, prefix+"acct_yrmon" 		      ,false, "", dfNone       ,0,false,true);
		InitDataProperty(0, cnt++, dtHidden   	 ,80, daCenter,  true, prefix+"jo_fsh_flg2" 		      ,false, "", dfNone       ,0,false,true);		
		
		InitUserFormat2(0, prefix+"rev_yrmon" , "####-##", "-|:" );
        InitUserFormat2(0, prefix+"n1st_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
        InitUserFormat2(0, prefix+"lst_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );       
        InitDataCombo(0,  prefix+"jo_stl_jb_cd", "JOINT OPERATION|LEASE|ADDITIONAL|Over Used|20FT|40FT", "101|102|103|201|301|302");
		InitDataCombo(0, prefix+"adj_rslt_cd",    " |Wrong BSA/Price|Used Basis Sttl|Wrong Sttl|Next Sttl|Others", " |A|B|C|D|E");        
		InitDataCombo(0, prefix+"jo_stl_sts_cd2"," |Settle|UnSettle|Manul Settle", " |S|U|M");
		InitDataCombo(0, prefix+"jo_stl_sts_cd"," |Manul Settle", " |M");		
		InitDataCombo(0, prefix+"jo_rnd_rule_lvl", " |Round|Round Up|Round Down|No", " |1|2|3|4");
		InitDataCombo(0, prefix+"re_divr_cd", " |Rev|Exp", " |R|E");		
		
		FrozenCols = 12;		
		
		}
		break;
		
	case 2: // 단지 Estiamted Period 변경시 마감여부를 check할 때 깜빡임을 방지하기 위한 sheet임
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}

	switch (sAction) {
	    case "CALLBATCH": // JOO_SLT_PRC 프로시저 호출
			formObj.f_cmd.value = COMMAND01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0104GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml, false);
			
			break;
			
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			setConditionValue('1');			
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0104GS.do", param);						
			sheetObj.LoadSearchXml(sXml, false); //Append X			
			break;
													
		case IBSAVE: //저장
			var SaveStr = ComGetSaveString(sheetObj);			
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}
						
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0104GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
						
			break;
		
		//조회조건 변경
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCHLIST02;
						
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0104GS.do", FormQueryString(formObj));
			
			var conFlg = formObj.estm_cond_flg.value;
			switch(conFlg){
				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "1":
					var clzFlg = ComGetEtcData(sXml, "estm_clz_flg");
					if (clzFlg == "N") {
						fnBtnEnable("C", true);
					} else {
						fnBtnEnable("C", false);
					}	
				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "2":
					var trdCombo = ComGetEtcData(sXml, "TRD_CD");
					if (ComTrim(trdCombo) != ""){
						var comboItems = (" |"+trdCombo).split("|");
						addComboItem(comboObjects[0], comboItems);
					}
				
				case "3":
					var rlaneCombo = ComGetEtcData(sXml, "RLANE_CD");
					if (ComTrim(rlaneCombo) != ""){
						var comboItems = (" |"+rlaneCombo).split("|");
						addComboItem(comboObjects[1], comboItems);
					}
					
				case "4":
					var crrCombo = ComGetEtcData(sXml, "JO_CRR_CD");
					if (ComTrim(crrCombo) != ""){
						var comboItems = (" |"+crrCombo).split("|");
						addComboItem(comboObjects[2], comboItems);
					}
					break;
			}
			break;

		case IBRESET: //NEW 버튼  
			UF_reset();
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
			case IBSEARCH:
				break;
				
			case IBSAVE:
				break;
		}
	}
	return true;
}
/************************************** Object EVENT FUNCTION ********************************************************/
function jo_crr_cd2_OnChange(comboObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

function trd_cd2_OnChange(comboObj, Value, Text) {
	UF_setCond("3");
}

function rlane_cd2_OnChange(comboObj, Value, Text) {
	UF_setCond("4");
}

/**************************************USER FUNCTION *****************************************************/

/**
 * NEW 버튼 처리 
 * @param    void
 * @return   void
 */
function UF_reset() {
	var formObj = document.form;
	formObj.page_no.value = "1";
	sheetObjects[0].RemoveAll();
	
	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].Code2 = "";
	comboObjects[4].Code2 = "";	
	formObj.diff.checked = false;
	
	var comboItems;
	
	if (ComTrim(gTrdCd) != ""){
		comboItems = (" |"+gTrdCd).split("|");
		addComboItem(comboObjects[0], comboItems);           	
	}

	//Rlane Combo setting
	if (ComTrim(gRlaneCd) != ""){
		comboItems = (" |"+gRlaneCd).split("|");
		addComboItem(comboObjects[1], comboItems);
	}
	
	//Carrier Combo setting
	if (ComTrim(gJoCrrCd) != ""){
		comboItems = (" |"+gJoCrrCd).split("|");
		addComboItem(comboObjects[2], comboItems);           	
	}
	
	formObj.rev_yrmon_fr.value = gYyyyMM;	
	formObj.rev_yrmon_to.value = gYyyyMM;
	
	formObj.re_divr_cd[0].checked = true;
	formObj.vvd.value = "";
	sheetObjects[0].RemoveAll();	
}

/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 잃었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnDeactivate() {
	switch (event.srcElement.name) {
		case 'rev_yrmon_fr':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                  
			break;
		case 'rev_yrmon_to':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                        
			break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 얻었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnActivate() {
	switch (event.srcElement.name) {
	case 'rev_yrmon_fr':
		ComClearSeparator(event.srcElement);
		break;
	case 'rev_yrmon_to':
		ComClearSeparator(event.srcElement);
		break;
	}
	event.srcElement.select();
}
/**
 * 년월 NAVI 처리 이벤트 
 * @param void
 * @return void
 */
function fnDocClick() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
		case "btn_vvd_from_back":
			UF_addMonth(formObj.rev_yrmon_fr, -1);
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_from_next":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_fr, +1);
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_to_back":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_to, -1);
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_to_next":
			UF_addMonth(formObj.rev_yrmon_to, +1);
			sheetObjects[0].RemoveAll();
			break;
	}
	
	UF_setCond("1");	// 추가(민정호)
}
/**
 * <pre>
 *    form Element의 KeyPress Event 발생시 처리.
 *    
 * </pre>
 * @return
 */
function fnObjKeyPress() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {	
		case 'rev_yrmon_fr':
			ComKeyOnlyNumber(obj);
			break;
	
		case 'rev_yrmon_to':
			ComKeyOnlyNumber(obj);
			break;
			
		case 'vvd':
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * 
 * <pre>
 *      버튼권한 처리
 * </pre>
 *
 * @param   
 * @return
 * @author jang kang cheol
 */
function fnBtnEnable(auth, blUse) {
	var doc = document.all;
	var className = "";
	if (blUse) {
		className = "btn1";
	} else {
		className = "btn1_1";
	}

	for ( var i = 0; i < doc.length; i++) {
		if (doc[i].id.indexOf("btn") > -1) {
			if (doc[i].getAttribute("auth") != undefined) {
				if (doc[i].getAttribute("auth") == auth) {
					doc[i].className = className;
				}
			}
		}
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj    = document.form;
	
	var settleFlg = null;
	var isCheck = null;
	var acctYrmon = null;
	
	for (i = 0; i < sheetObj.RowCount+2; i++) {
		settleFlg = sheetObj.CellValue(i, prefix + "jo_stl_sts_cd2");
		isCheck = sheetObj.CellValue(i, prefix + "jo_fsh_flg");
		acctYrmon = sheetObj.CellValue(i, prefix + "acct_yrmon");		
		
		if(acctYrmon == null || acctYrmon == ""){
			acctYrmon = "999912";
		}				
		
//		if(settleFlg == "S" || isCheck == "1" ){
		if(settleFlg == "S" || acctYrmon != "999912" ){		
			sheetObj.CellEditable(i, prefix + "jo_fsh_flg") = false;
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(192,192,192);
		}
	}
	
//	// Retrive 시 checked Row의 checkbox disable
//	for (i = 0; i < sheetObj.RowCount; i++) {
//		isCheck = sheetObj.CellValue(i, prefix + "jo_fsh_flg");
//		if(isCheck == "1"){
//			sheetObj.CellEditable(i, prefix + "jo_fsh_flg") = false;
//		}
//	}
	
	var cmd = formObj.f_cmd.value;
	var cur_page = formObj.page_no.value;
	if( (cmd == SEARCH) && sheetObj.RowCount > 0 && cur_page == "1") {
		var tot_page_cnt = sheetObj.EtcData('tot_page_cnt');
		formObj.tot_page_cnt.value = tot_page_cnt;
	}			
}

function UF_setCond(flg){
	var formObj = document.form;
		
	formObj.estm_cond_flg.value = flg;
	
	switch (flg){
	//exe month, re_divr_cd 변경시
	case "1":
	//rev year month변경시
	case "2":
		formObj.trd_cd2.Index2 = -1;
		formObj.trd_cd2.RemoveAll();
	//Trade변경시
	case "3":
		formObj.rlane_cd2.Index2 = -1;
		formObj.rlane_cd2.RemoveAll();
	//Lane변경시
	case "4":
		formObj.jo_crr_cd2.Index2 = -1;
		formObj.jo_crr_cd2.RemoveAll();
		break;
	}
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);		
}

function UF_checkPeriod(){
	var formObj = document.form;
	var frDt = formObj.rev_yrmon_fr.value.replaceStr("-","")+"01";
	var toDt = formObj.rev_yrmon_to.value.replaceStr("-","")+"01";

	if (ComGetDaysBetween(frDt, toDt) <= 0){
		return false;
	}	
	
	return true;
}

/**
 * 화면 Reset
 */
function reset_all(){	 
	var formObject = document.form;
		formObject.tot_page_cnt.value="0";
		formObject.page_no.value="1";
		formObject.sheet1.RemoveEtcData();
		formObject.sheet1.RemoveAll();	
}

/**
 * Onkeydown 이벤트 관련
 */
 function gotopage(){
	 var formObject = document.form;
	 var tot_page = "";
	 var cur_page = "";
	 cur_page = formObject.page_no.value;
	 tot_page = formObject.tot_page_cnt.value;
	 if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
		 var errMessage = ComGetMsg('JOO00214','','','');  			// 	msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;
		 ComShowMessage(errMessage);
		 return;
	 }
	 doActionIBSheet(sheetObjects[0],formObject,"IBSEARCH"); 
 }
  
  /**
   * setConditionValue
   */    
  function setConditionValue(searchGubun){
		var formObj = document.form;
				
		formObj.pagerows.value = formObj.pagerows2.value; 
		formObj.trd_cd.value = comboObjects[0].Code;
		formObj.rlane_cd.value = comboObjects[1].Code;
		formObj.jo_crr_cd.value = comboObjects[2].Code;
		formObj.acct_cd.value = comboObjects[3].Code;
		formObj.jo_stl_sts_cd.value = comboObjects[4].Code;		
  }       

/* 개발자 작업  끝 */