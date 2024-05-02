﻿/*********************************************************************
 * Copyright(c) 2014 CyberLogitec
 *@FileName : ESD_TES_0015.js
 *@FileTitle : Invoice Processing Audit Inquiry
 *Open Issues :
 *Change history :  
 *@LastModifyDate : 2014-06-19
 *@LastModifier : yOng hO lEE
 *@LastVersion : 1.0
 * 2014-06-19 yOng hO lEE
 * 1.0 최초 생성
 * Open Issues      :
 * Change history   :
 *********************************************************************/

// 공통전역변수
/**
 * INVOICE Layer
 * 1 : Marine Terminal Invoice
 * 2 : On-dock Rail Charge Invoice
 * 3 : Off-dock CY Invoice
 * 4 : Marine Terminal Strorage Invoice
 */	 

// Invoice Layer Setting
var beforelayer	= 1;

// Marine Terminal Invoice
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var io_hidden = ''
	
var comboObjects = new Array();
var comboCnt = 0 ;	
	
// On-dock Rail Charge Invoice
var beforetab1 = 0;
	
// Off-dock CY Invoice
var beforetab2 = 0;

// Marine Terminal Strorage Invoice
var beforetab3 = 0;

var tot_page = 1; //ATB 에서 전체 페이지 수를 나타내는 변수

var auth_ofc_main_hidden_xml = ''; //ofc_cd 별 권한 체크시  vvd_hidden에 문제가 생김

	/**
	 * 조회 조건 Check.
	 */
	function checkRetrive() {
		var formObject = document.form;
		// Check Date Term
		if ( ComGetDaysBetween(formObject.fm_prd_dt.value, formObject.to_prd_dt.value) < 0 ) {
			ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
			return false;
		}
		
		if ( ComGetDaysBetween(formObject.fm_prd_dt.value, formObject.to_prd_dt.value) > 31) {
			// Bkg, Cntr, VVD, Cost code별 조회시 조회기간 12개월
			if( formObject.bkg_no.value != '' || formObject.cntr_no.value != '' || formObject.vvd.value != '' || formObject.lgs_cost_cd.Code != '' ) {
				if(ComGetDaysBetween(formObject.fm_prd_dt.value, formObject.to_prd_dt.value) > 365) {
					ComShowMessage('Invoice DT must inputted within 365 days.');
//					tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
					return false;					
				}
			} else {
				ComShowMessage('Invoice DT must inputted within 31 days.');
//				tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
				return false;
			}
	    }
		
		if (formObject.inv_date_type.value == undefined || formObject.inv_date_type.value == null || formObject.inv_date_type.value.trim() == '')
		{
			ComShowMessage('Please select \'Inv. Date\' type');
			return false;
		}
	
		// Check Office Code
		if ( (formObject.inv_ofc_cd.value == undefined || formObject.inv_ofc_cd.value == null || formObject.inv_ofc_cd.value.trim() == '') &&
			(formObject.cost_ofc_cd.value == undefined || formObject.cost_ofc_cd.value == null || formObject.cost_ofc_cd.value.trim() == '') )
		{
			ComShowMessage('Please inputted \'Cost Office\' Or \'Invoice Office\'');
			return false;
		}
		
		// Yard Code 가 없는 경우 지워준다.
		if ( formObject.loc_cd.value == undefined || formObject.loc_cd.value == null || formObject.loc_cd.value.trim() == '' ) {
			formObject.yd_cd.value = '';
			formObject.yd_cd_hidden.value = '';
			formObject.is_valid_yd_cd.value = '';
		}
		
		//cost code, cntr sty code를 SQL에 넣을 수 있는 문장으로 만들어준다.
		formObject.cost_code.value		= "";
		formObject.cntr_sty_code.value	= "";
		if (formObject.cost_tp[0].checked == false) {
			for (var i = 1; i < 7; i++) {
				if (formObject.cost_tp[i].checked == true) {
					formObject.cost_code.value = formObject.cost_code.value + formObject.cost_tp[i].desc;
				}
			}
			for (var j = 0; j < 2; j++) {
				if (formObject.cntr_tp[j].checked == true) {
					formObject.cntr_sty_code.value = formObject.cntr_sty_code.value + formObject.cntr_tp[j].desc;
				}
			}
		}
		return true;	
	}

	/**
	 * Button More Page Check
	 */
	function checkPage(sheetObject, PageNo, OnePageRow)
	{
		if ( PageNo > (sheetObject.TotalRows / OnePageRow) ) {
			return false;
		}
		return true;
	}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/**
		 * INVOICE Layer
		 * 1 : Marine Terminal Invoice
		 * 2 : On-dock Rail Charge Invoice
		 * 3 : Off-dock CY Invoice
		 * 4 : Marine Terminal Strorage Invoice
		 */	 
		
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		// Marine Terminal Invoice
		var sheetObject		= sheetObjects[0];
		var sheetObject1	= sheetObjects[1];
		var sheetObject2	= sheetObjects[2];
	
		// On-dock Rail Charge Invoice
		var sheetObject3	= sheetObjects[3];
		var sheetObject4	= sheetObjects[4];
		var sheetObject5	= sheetObjects[5];
		
		// Off-dock CY Invoice
		var sheetObject6	= sheetObjects[6];
		var sheetObject7	= sheetObjects[7];
		var sheetObject8	= sheetObjects[8];
		var sheetObject9	= sheetObjects[9];
		var sheetObject10	= sheetObjects[10];

		// Marine Terminal Strorage Invoice
		var sheetObject11	= sheetObjects[11];
		var sheetObject12	= sheetObjects[12];
		var sheetObject13	= sheetObjects[13];
		var sheetObject14	= sheetObjects[14];

		/*******************************************************/
		var formObject = document.form;

		var OnePageRow = 10000;	// ViewRow Per Page

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
	
				case "btn_retrieve":
					if ( checkRetrive() ) {
						ComOpenWait(true);	
							
						/**
						 * INVOICE Layer
						 * 1 : Marine Terminal Invoice
						 * 2 : On-dock Rail Charge Invoice
						 * 3 : Off-dock CY Invoice
						 * 4 : Marine Terminal Strorage Invoice
						 */	 
						// Marine Terminal Invoice
						if ( formObject.tml_inv_tp_cd[0].checked ) {
							doActionIBSheet(sheetObject, formObject, IBSEARCH);
						} 
						// On-dock Rail Charge Invoice
						else if ( formObject.tml_inv_tp_cd[1].checked ) {
							doActionIBSheet1(sheetObject3, formObject, IBSEARCH);
						} 
						// Off-dock CY Invoice
						else if ( formObject.tml_inv_tp_cd[2].checked ) {
							doActionIBSheet2(sheetObject6, formObject, IBSEARCH);
						} 
						// Marine Terminal Strorage Invoice
						else if ( formObject.tml_inv_tp_cd[3].checked ) {
							doActionIBSheet3(sheetObject11, formObject, IBSEARCH);
						} 
						ComOpenWait(false);		
					}										
				break;
	
				case "btn_new":
					try {
						tes_removeTESCommonALLIframes();
						tes_removeTESInvoiceCommonALLIframes();
					} catch (e){
					}
					
					formObject.reset();
					for ( i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}
					initSearchCond();
					validateYardCode();
				break;
	
				
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.select(formObject.fm_prd_dt, 'yyyy-MM-dd');
				break;
	
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.to_prd_dt, 'yyyy-MM-dd');
				break;

				case "btn_yard":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_061";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if (chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getYard', dispaly);
					} else {
						ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
					break;

				case "btn_vndr":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_0C1";
					
					var param = '?classId='+classId;
					
					var chkStr = dispaly.substring(0,3)
					
					// radio PopUp
					if (chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
					} else {
						ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
				break;
				
				case "btn_cost_ofc_cd" :
					var formObject = document.form;
					var cmdt_cd_val ="";   //향후 사용가능 예정변수
					var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
					var cmdt_desc_val ="";   //향후 사용가능 예정변수
					var classId ="getCOM_ENS_ofc";
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
					ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getCostOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;

				case "btn_inv_ofc_cd" :
					var formObject = document.form;
					var cmdt_cd_val ="";   //향후 사용가능 예정변수
					var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
					var cmdt_desc_val ="";   //향후 사용가능 예정변수
					var classId ="getCOM_ENS_ofc";
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
					ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
				
				case "btn_moretm1":

					if ( checkPage(sheetObject, formObject.iPageTm.value, OnePageRow) ) {
						var PageNo	= parseInt(formObject.iPageTm.value) + 1;
						t1sheet1_OnScrollNext(sheetObject, tesFrmQryStr(formObject), PageNo, OnePageRow);
					}
				break;
					
				case "btn_moreon1":
					
					if ( checkPage(sheetObject3, formObject.iPageOn.value, OnePageRow) ) {
						var PageNo	= parseInt(formObject.iPageOn.value) + 1;
						ondockt1sheet1_OnScrollNext(sheetObject3, tesFrmQryStr(formObject), PageNo, OnePageRow);
					}
				break;
					
				case "btn_moreof1":
					
					if ( checkPage(sheetObject6, formObject.iPageOf.value, OnePageRow) ) {
						var PageNo	= parseInt(formObject.iPageOf.value) + 1;
						offdockt1sheet1_OnScrollNext_OnScrollNext(sheetObject6, tesFrmQryStr(formObject), PageNo, OnePageRow);
					}
				break;
					
				case "btn_morest1":
					
					if ( checkPage(sheetObject11, formObject.iPageSt.value, OnePageRow) ) {
						var PageNo	= parseInt(formObject.iPageSt.value) + 1;
						storaget1sheet1_OnScrollNext(sheetObject11, tesFrmQryStr(formObject), PageNo, OnePageRow);
					}
				break;

				// Marine Terminal Invoice
				case "btn_downexceltm1":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;
				
				case "btn_downexceltm2":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexceltm3":
					doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
				break;
					
				// On-dock Rail Charge Invoice
				case "btn_downexcelon1":
					doActionIBSheet1(sheetObject3, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelon2":
					doActionIBSheet1(sheetObject4, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelon3":
					doActionIBSheet1(sheetObject5, formObject, IBDOWNEXCEL);
				break;
					
				// Off-dock CY Invoice
				case "btn_downexcelof1":
					doActionIBSheet2(sheetObject6, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelof2":
					doActionIBSheet2(sheetObject7, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelof3":
					doActionIBSheet2(sheetObject8, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelof4":
					doActionIBSheet2(sheetObject9, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelof5":
					doActionIBSheet2(sheetObject10, formObject, IBDOWNEXCEL);
				break;
					
				// Marine Terminal Strorage Invoice
				case "btn_downexcelst1":
					doActionIBSheet3(sheetObject11, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelst2":
					doActionIBSheet3(sheetObject12, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelst3":
					doActionIBSheet3(sheetObject13, formObject, IBDOWNEXCEL);
				break;
					
				case "btn_downexcelst3":
					doActionIBSheet3(sheetObject14, formObject, IBDOWNEXCEL);
				break;
					
			} // end switch
		} catch(e) {
			if ( e == "[object Error]") {
				ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다 ");
			} else {
				ComShowMessage(e);
			}
		}
	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object
     */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Combo 기본 설정
	 * Combo의 항목을 설정한다.
	 * @param(comboObjl) 	combo object
	 * @param(comboNo) 		combo number
	 * @param(combo_val) 	combo value
	 * @param(def_val) 		def value
	 */
	function initCombo (comboObj, comboNo, combo_val, def_val) {
		var cnt  = 0 ;
		
		switch(comboNo) {

			case 1:   //nod_cd
				with (comboObj) {
					SetColAlign('left');
					SetColWidth('45');
					DropHeight=150;

					var tmp = '';
					if (combo_val != null) {tmp = combo_val.split('|');}
					for (var i = 0; tmp != null && i < tmp.length; i++) {
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val != undefined && def_val != null && def_val.trim() != '') {
						Code = def_val;
					} else {
						Code = '';
					}
				}
			break;
			case 2:   // cost code
				with (comboObj) {
				SetColAlign('left');
				SetColWidth('100');
				DropHeight=150;
				
				var tmp = '';
				cnt	= 0;
				if (combo_val != null) {
					tmp = combo_val.split('|');
					InsertItem(0, '', '');  // 전체 조회 추가
					cnt++;
				}
				for (var i = 0; tmp != null && i < tmp.length; i++) {
					InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
				}
				if (def_val != undefined && def_val != null && def_val.trim() != '') {
					Code = def_val;
				} else {
					Code = '';
				}
			}
				break;
		}
	}

	/**
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param(combo_obj) como object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * 
     */
	function loadPage() {
    	//ComShowMessage('loadPage');
        for( i = 0; i < comboObjects.length; i++) {
            initCombo (comboObjects[i], i+1);
        }

		for ( i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet (sheetObjects[i]);		// khlee-시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);	// khlee-마지막 환경 설정 함수 추가
		}

		for ( k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k+1);
		}
		/**
		 * INVOICE Layer
		 * 1 : Marine Terminal Invoice
		 * 2 : On-dock Rail Charge Invoice
		 * 3 : Off-dock CY Invoice
		 * 4 : Marine Terminal Strorage Invoice
		 */	 
		
		// Marine Terminal Invoice
		var sheetObjectTm1		= sheetObjects[0];
		var sheetObjectTm2		= sheetObjects[1];
		var sheetObjectTm3		= sheetObjects[2];
		var sheetObjectTm4		= sheetObjects[3];
		
		// On-dock Rail Charge Invoice
		var sheetObject3	= sheetObjects[3];	// 
		var sheetObject4	= sheetObjects[4];	// 
		var sheetObject5	= sheetObjects[5];	// 
		
		// Off-dock Inovice Sheet
		var sheetObject6	= sheetObjects[6];	// 		
		var sheetObject7	= sheetObjects[7];	// 
		var sheetObject8	= sheetObjects[8];	// 
		var sheetObject9	= sheetObjects[9];	// 
		var sheetObject10	= sheetObjects[10];	// 	
		
		// Marine Terminal Strorage Invoice
		var sheetObject11	= sheetObjects[11];
		var sheetObject12	= sheetObjects[12];
		var sheetObject13	= sheetObjects[13];
		var sheetObject14	= sheetObjects[14];
	
//		var formObject		= document.form;
		initSearchCond();
		initCheckBox();
		
		try	{
			tes_getComboItem('lgs_cost_cd', 2, SEARCHLIST13, '');  // setCalcColFormat
		} catch(e) {}
		
		// Marine Terminal Invoice
		sheetObjects[0].WaitImageVisible = false;
		sheetObjects[1].WaitImageVisible = false;
		sheetObjects[2].WaitImageVisible = false;
		
		// On-dock Rail Charge Invoice
		sheetObjects[3].WaitImageVisible = false;
		sheetObjects[4].WaitImageVisible = false;
		sheetObjects[5].WaitImageVisible = false;
		
		// Off-dock Inovice Sheet
		sheetObjects[6].WaitImageVisible = false;
		sheetObjects[7].WaitImageVisible = false;
		sheetObjects[8].WaitImageVisible = false;
		sheetObjects[9].WaitImageVisible = false;
		sheetObjects[10].WaitImageVisible = false;
		
		// Marine Terminal Strorage Invoice
		sheetObjects[11].WaitImageVisible = false;
		sheetObjects[12].WaitImageVisible = false;
		sheetObjects[13].WaitImageVisible = false;
		sheetObjects[14].WaitImageVisible = false;
	}
	
	/**
	 * 조회조건 초기화
	 */
	function initSearchCond() {
		// Invoice div display
		if ( beforelayer != 0) {
			invoiceOnclick(0);
		}
		
		tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
	}

	/**
	 * check box 초기화
	 */        
	function initCheckBox() {
		document.form.cost_tp[0].checked = true;
		document.form.cost_tp[1].checked = false;
		document.form.cost_tp[2].checked = false;
		document.form.cost_tp[3].checked = false;
		document.form.cost_tp[4].checked = false;
		document.form.cost_tp[5].checked = false;
		document.form.cost_tp[6].checked = false;
		document.form.cntr_tp[0].checked = true;
		document.form.cntr_tp[1].checked = true;

		ComEnableManyObjects(false, document.form.cntr_tp[0], document.form.cntr_tp[1]);
	}

	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @param(sheet_obj) sheet object
	 * @param(sheetNo) sheetNo
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		
		// case 1 : MR 
		// case 4 : ON
		// case 7 : OF
		// case 12 : ST
		switch (sheetNo) {
			// Marine Terminal Invoice
			case 1:      //tmt1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 10000);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(23, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|CNTR No.|CNTR\nDTC|Cost\r\nCalculated|Type\r\nSize|F/M|VVD|I/O|DG|Working\nDate|IPC|Lane|T/S|R/D Term|BKG_NO|Verify Result|Remarks";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,	dtDataSeq,	30,		daCenter,		false,	"",						false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"cost_ofc_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"inv_ofc_cd",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"yd_cd",				false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"vndr_seq",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true);

					InitDataProperty(0, cnt++,	dtData,		120,	daCenter,		false,	"inv_no",				false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		90,		daCenter,		false,	"cntr_no",				false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		50,		daCenter,		false,	"modi_flg",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true, "Move Container Discrepancy to Coincidence");
					InitDataProperty(0, cnt++,	dtData,		90,		daCenter,		false,	"lgs_cost_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"cntr_tpsz_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);

					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"cntr_sty_cd",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		80,		daCenter,		false,	"vvd",             	 	false,	"",		dfNone,		0,	false,	false,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"io_bnd_cd",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"dcgo_clss_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"wrk_dt",				false,	"",		dfDateYmd,	0,	true,	true,	0,		false,	true);

					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"ioc_cd",				false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"lane_cd",				false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		40,		daCenter,		false,	"locl_ts_ind_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		80,		daCenter,		false,	"rcvde_term_ind_cd",false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		100,	daCenter,		false,	"bkg_no_con",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);

					InitDataProperty(0, cnt++,	dtData,		80,		daCenter,		false,	"dscr_ind_cd",		false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtData,		70,		daCenter,		false,	"cntr_rmk",			false,	"",		dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++,	dtHidden,		50,		daCenter,		false,	"atb_dt",           	false,	"",		dfNone,		0,	false,	false,	0,		false,	false);
					
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
			break;
			case 2:      //t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Discrepancy Type|CNTR No.|Type\r\nSize|F/M|VVD|I/O|DG|Working\nDate|IPC|Lane|T/S|R/D Term|BKG NO|Remarks";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,		false,	"",							false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"cost_ofc_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"inv_ofc_cd",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"yd_cd",					false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"vndr_seq",				false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,	120,	daCenter,		false,	"inv_no",					false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtCombo,	110,	daCenter,		false,	"dscr_ind_cd",			false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtData,	100,	daLeft,			false,	"cntr_no",					false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	65,		daCenter,		false,	"cntr_tpsz_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	35,		daCenter,		false,	"cntr_sty_cd",				false,	"",	dfNone,		0,	false,	false);

                    InitDataProperty(0, cnt++, dtData,	80,		daCenter,		false,	"vvd",						false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,	35,		daCenter,		false,	"io_bnd_cd",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	40,		daCenter,		false,	"dcgo_clss_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"wrk_dt",					false,	"",	dfDateYmd,	0,	true,	true);
					InitDataProperty(0, cnt++, dtData,	35,		daCenter,		false,	"ioc_cd",					false,	"",	dfNone,		0,	false,	false);

                    InitDataProperty(0, cnt++, dtData,	35,		daCenter,		false,	"lane_cd",					false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,	35,		daCenter,		false,	"locl_ts_ind_cd",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,	57,		daCenter,		false,	"rcvde_term_ind_cd",	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,	100,	daCenter,		false,	"bkg_no_con",			false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtData,	50,		daCenter,		false,	"cntr_rmk",				false,	"",	dfNone,		0,	false,	false);

                    InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,		false,	"atb_dt",					false,	"",	dfNone,		0,	false,	false);

                    InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date", "DD|DP|HO|PD|NH|DB|DF");
				}
			break;
			case 3:      //t3sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					// 컬럼 헤더 타이틀 변경 ( T/S => Mode ) - 2009-04-15 자체
					// CHM-201538943 TES Invoice Processing Audit 기능 보완 (By Bkg) (2015-11-24 양양선B 요청)
					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|Type\r\nSize|VVD|I/O|DG|Reefer|Applied\nDate|IPC|Mode|Lane|Bkg No.|CNTR No.|" +
										"Vol.\nTier|Calculated\r\nVol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|Carrier|3rd\nParty||BKG\nCNTR Vol|BKG\nCNTR AMT";

					var HeadCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(HeadCount, 6, 0, true);

//					InitColumnInfo(33, 6, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,		false,	"",						false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"cost_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"inv_ofc_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"yd_cd",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"vndr_seq",			false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,		120,	daCenter,		false,	"inv_no",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,		150,	daLeft,			false,	"calc_tp_cd",			false,	"",	dfNone,   	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		100,	daLeft,			false,	"lgs_cost_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"cntr_tpsz_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"vvd_no",				false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,		30,		daCenter,		false,	"io_bnd_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"dcgo_ind_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"rc_flg",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"tml_wrk_dy_cd",		false,	"",	dfDateYmd,  0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"ioc_cd",				false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"tml_trns_mod_cd",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"lane_cd",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"bkg_no",				false,	"",	dfNone,		0,	true,	true);	// Bkg No.
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"cntr_no",				false,	"",	dfNone,		0,	true,	true);	// CNTR No.
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"tier",					false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"calc_vol_qty",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"rvis_vol_qty",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"vol_tr_ut_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"ctrt_rt",				false,	"",	dfFloat,		2,	true,	true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"curr_cd",				false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"inv_xch_rt",			false,	"",	dfFloat,		5,	true,	true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"inv_amt",				false,	"",	dfFloat,		2,	true,	true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"calc_rmk",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++,	dtData,		50,		daCenter,		false,	"tml_crr_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"n3pty_flg",			false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false,	"tml_so_dtl_seq",		false,	"",	dfNone,		0,	true,	true);
					// CHM-201538943 TES Invoice Processing Audit 기능 보완 (By Bkg) (2015-11-24 양양선B 요청)
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"bkg_cntr_vol",			false,	"",	dfNone,		0,	true,	true);	// BKG NO. Container Count
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"bkg_cntr_amt",			false,	"",	dfNullFloat,	2,	true,	true);	// BKG NO. Container Count
//					InitDataProperty(0, cnt++, dtData,		120,	daCenter,		false,	"cntr_list",			false,	"",	dfNone,		0,	true,	true);	// BKG NO. Container List

					initDataCombo(0, "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
			
				}
			break;

			// On-dock Invoice
			case 4:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 10000);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(18, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|CNTR No.|CNTR\nDTC|Cost\r\nCalculated|Type/Size|F/M|DG|Working\nDate|CLM Date|Rail Billing\nDate|Verify\nResult|Remark";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,			30,		daCenter,		false,	""					,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"cost_ofc_cd"		,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"inv_ofc_cd"		,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"yd_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"vndr_seq"		,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,		120,	daCenter,		false,	"inv_no"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,		false,	"cntr_no"			,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,		false,	"modi_flg"		,	false,	"",	dfNone,		0,	true,	true,	30,		false,	true,	"Move Container Discrepancy to Coincidence");
					InitDataProperty(0, cnt++,	dtData,		90,		daCenter,		false,	"lgs_cost_cd",		false,	"",	dfNone,		0,	true,	true,	0,		false,	true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"cntr_tpsz_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);

					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"cntr_sty_cd"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,		false,	"dcgo_clss_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"wrk_dt"			,	false,	"",	dfDateYmd,	0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"clm_dt"			,	false,	"",	dfDateYmd,	0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,		false,	"rail_bil_dt"		,	false,	"",	dfDateYmd,	0,	true,	true,	30);
				
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"dscr_ind_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"cntr_rmk"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtHidden,		80,		daCenter,		false,	"vvd"				,	false,	"",	dfNone,		0,	true,	true,	30);

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
			break;
			case 5:     //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Discrepancy Type|CNTR No.|Type/Size|F/M|DG|Working\nDate|CLM Date|Rail Billing\nDate|Remark";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq,	30,		daCenter,		false,	"");
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"cost_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"inv_ofc_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"yd_cd",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,		false,	"vndr_seq",			false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,		120,	daCenter,		false,	"inv_no",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,		150,	daCenter,		false,	"dscr_ind_cd"	,	false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,		false,	"cntr_no"			,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"cntr_tpsz_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"cntr_sty_cd"		,	false,	"",	dfNone,		0,	true,	true,	30);

					InitDataProperty(0, cnt++, dtData,		60,		daCenter,		false,	"dcgo_clss_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"wrk_dt"			,	false,	"",	dfDateYmd,	0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"clm_dt"			,	false,	"",	dfDateYmd,	0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,		false,	"rail_bil_dt"		,	false,	"",	dfDateYmd,	0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,		false,	"cntr_rmk"		,	false,	"",	dfNone,		0,	true,	true,	30);

					InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date", "DD|DP|HO|PD|NH|DB|DF");

				}
			break;
			case 6:     //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(15) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|Type/Size|Applied\nDate|DG|Calculated Vol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remark|3rd Party|dtl_seq";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,		false,	""					,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"cost_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"inv_ofc_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"yd_cd",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"vndr_seq",			false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,	120,	daCenter,		false,	"inv_no",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,	150,	daCenter,		false,	"calc_tp_cd"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	150,	daCenter,		false,	"lgs_cost_cd"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"cntr_tpsz_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"tml_wrk_dy_cd"	,	false,	"",	dfDateYmd,	0,	true,	true,	30);

					InitDataProperty(0, cnt++, dtData,	40,		daCenter,		false,	"dcgo_ind_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,		false,	"calc_vol_qty"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,		false,	"rvis_vol_qty"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"vol_tr_ut_cd"	,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"ctrt_rt"			,	false,	"",	dfNone,		0,	true,	true,	30);

					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"curr_cd"			,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	60,		daCenter,		false,	"inv_xch_rt"		,	false,	"",  dfNullFloat,	5,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	90,		daCenter,		false,	"inv_amt"			,	false,	"",  dfNullFloat,	2,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	90,		daCenter,		false,	"calc_rmk"		,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,	70,		daCenter,		false,	"n3pty_flg"		,	false,	"",	dfNone,		0,	true,	true,	30);

					InitDataProperty(0, cnt++, dtHidden,	70,		daCenter,		false,	"tml_so_dtl_seq",   false,	"",	dfNone,		0,	true,	true,	30);

					style.height = GetSheetHeight(15) ;
					InitDataCombo(0 , "calc_tp_cd", "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
				}
			break;

			// Off-dock Invoice
			case 7:   //t1sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(15);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 10000);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(31, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|CNTR No.|CNTR\nDTC|Cost\r\nCalculated|Type/Size|Gate In|Gate Out|F/M|I/O|DG|B/B|Verify\nResult|Remarks|";

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,	dtSeq,				30,		daCenter,		false, ""							,	false, "",	dfNone,		0,	true,	true,	6);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++,	dtData,			90,		daCenter,		false, "cntr_no"					,	false, "",	dfNone,		0,	false,	false, 3);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "modi_flg"					,	false, "",	dfNone,		0,	false,	false,	6,	false,	true,	"Move Container Discrepancy to Coincidence");
					InitDataProperty(0, cnt++,	dtData,			90,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	true,	true,	0,	false,	true);
					InitDataProperty(0, cnt++,	dtData,			70,		daCenter,		false, "cntr_tpsz_cd"			,	false, "",	dfNone,		0,	false,	false,	1);

					InitDataProperty(0, cnt++, dtData,			110,	daCenter,		false, "inv_gate_in_dt"			,	false, "",	dfUserFormat2, 0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtData,			110,	daCenter,		false, "inv_gate_out_dt"		,	false, "",	dfUserFormat2, 0,	false,	false,	6);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "cntr_sty_cd"				,	false, "",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "io_bnd_cd"				,	false, "",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "dcgo_clss_cd"			,	false, "",	dfNone,		0,	true,	true,	1);

					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "bb_cgo_flg"				,	false, "",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false, "dscr_ind_cd"				,	false, "",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,			false, "cntr_rmk"					,	false, "",	dfNone,		0,	true,	true,	500);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false, "tml_so_cntr_list_seq"	,	false, "",	dfInteger,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false, "bkg_no"					,	false, "",	dfNone,		0,	false,	false,	9);
					
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false, "bkg_no_split"			,	false, "",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "vrfy_rslt_ind_cd"			,	false, "",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "gate_in_td_dys"			,	false, "",	dfInteger,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "gate_out_td_dys"		,	false, "",	dfInteger,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "inv_stay_dys"				,	false, "",	dfInteger,		0,	false,	false,	9);
					
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "mvmt_gate_in_dt"		,	false, "",	dfUserFormat2, 0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,"mvmt_gate_out_dt"		,	false, "",	dfUserFormat2, 0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false, "mvmt_stay_dys"			,	false, "",	dfInteger,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false, "stay_diff_dys"			,	false, "",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false, "awk_cgo_flg"			,	false, "",	dfNone,		0,	true,	true,9);
					
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false, "rc_flg"						,	false, "",	dfNone,		0,	true,	true,9);

					InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "mvmt_gate_in_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "mvmt_gate_out_dt", "####-##-## ##:##", "-|:");

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
			break;
			case 8: // t2sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(15);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 5, 100);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(27, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					var HeadTitle0 = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Discrepancy Type|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O\|Remarks";
					var HeadTitle1 = "||||||||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq,		30,		daCenter,		false,	""							,	false, "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"dscr_ind_cd"			,	false, "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			130,	daCenter,		false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"cntr_sty_cd"				,	false,	"",	dfNone,		0,	true,	true,	9);

					InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"mvmt_gate_in_dt"		,	false,	"",	dfUserFormat2, 0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"inv_gate_in_dt"			,	false,	"",	dfUserFormat2, 0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"gate_in_td_dys"			,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"mvmt_gate_out_dt"		,	false,	"",	dfUserFormat2, 0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"inv_gate_out_dt"		,	false,	"",	dfUserFormat2, 0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"gate_out_td_dys"		,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			50,		daLeft,			false,	"cntr_rmk"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"tml_so_cntr_list_seq"	,	false,	"",	dfInteger,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no"					,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no_split"			,	false,	"",	dfNone,		0,	false,	false,	9);

					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"vrfy_rslt_ind_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"modi_flg"				,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"bb_cgo_flg"				,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"dcgo_clss_cd"			,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"io_bnd_cd"				,	false,	"",	dfNone,		0,	false,	false,	9);

					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"awk_cgo_flg"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"rc_flg"					,	false,	"",	dfNone,		0,	true,	true,	9);

					InitUserFormat2(0,	"inv_gate_in_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"inv_gate_out_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"mvmt_gate_in_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"mvmt_gate_out_dt",	"####-##-## ##:##",	"-|:");

					InitDataCombo(0,
							"dscr_ind_cd",
							"Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date|Another Movement",
							"DD|DP|HO|PD|NH|DB|DF|AM");

					HeadRowHeight = 10;
					RangeBackColor(1, 7, 1, 8) = RgbColor(222, 251, 248); // ENIS
					RangeBackColor(1, 10, 1, 11) = RgbColor(222, 251, 248); // ENIS

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
				}
			break;
			case 9: // t3sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(15);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(44, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|Type/Size|Calculated\nVol.|Reefer|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|semi|3rd Party";

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"calc_tp_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"calc_vol_qty"				,	false,	"",	dfInteger,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"rc_flg"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"rev_yrmon"				,	false,	"",	dfDateYm,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"rvis_vol_qty"				,	false,	"",	dfInteger,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"vol_tr_ut_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"ctrt_rt"					,	false,	"",	dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"curr_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_xch_rt"				,	false,	"",	dfFloat,		5,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_amt"					,	false,	"",	dfFloat,		2,	false, false);
					InitDataProperty(0, cnt++, dtData,			150,	daLeft,			false,	"calc_rmk"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"semi_auto_calc_flg"		,	false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,			10,		daLeft,			false,	"n3pty_flg"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			60,		daRight,		false,	"calc_amt"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			10,		daLeft,			false,	"tml_agmt_ofc_cty_cd"	,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_ver_no"		,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_so_dtl_seq"			,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"calc_cost_grp_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			125,	daLeft,			false,	"lgs_cost_cd2"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"dcgo_ind_cd"			,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"free_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"inv_amt2"				,	false,	"",	dfFloat,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"ovr_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"paid_day"				,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"stay_dys"					,	false,	"",	dfInteger,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			80,		daRight,		false,	"diff_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"fp_calc_prd_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"fp_teu_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"inv_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"ovr_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"stk_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daLeft,			false,	"wrk_dt"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"acct_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"curr_chk"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataCombo(0,	"calc_tp_cd",	"Auto Calculated Cost|Manual Input Cost|Semi-Updated",	"A|M|S");

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
				}
			break;
			case 10: // t4sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(15);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(46, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\Month|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|semi|3rd Party";

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"calc_tp_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"io_bnd_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"dcgo_ind_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"rev_yrmon"				,	false,	"",	dfDateYm,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			45,		daCenter,		false,	"stay_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			45,		daCenter,		false,	"free_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"paid_day"				,	false,	"",	dfInteger,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"free_dy_xcld_dys"		,	false,	"",	dfInteger,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"ovr_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"vol_tr_ut_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"ctrt_rt"					,	false,	"",	dfFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"curr_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_xch_rt"				,	false,	"",	dfFloat,		5,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_amt"					,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			200,	daLeft,			false,	"calc_rmk"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"semi_auto_calc_flg"		,	false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,			10,		daLeft,			false,	"n3pty_flg"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			60,		daRight,		false,	"calc_amt"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			10,		daLeft,			false,	"tml_agmt_ofc_cty_cd"	,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_ver_no"		,	false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtHidden,			125,	daLeft,			false,	"lgs_cost_cd2"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"calc_cost_grp_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_so_dtl_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daRight,		false,	"calc_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daRight,		false,	"rvis_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daRight,		false,	"diff_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"fp_calc_prd_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"fp_teu_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"inv_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"ovr_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"stk_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"wrk_dt"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"acct_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"curr_chk"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			35,		daCenter,		false,	"ovr_dys2"				,	false,	"",	dfInteger,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			40,		daCenter,		false,	"rc_flg"					,	false,	"",	dfNone,		0,	false,	false);

					InitDataCombo(0,	"calc_tp_cd",	"Auto Calculated Cost|Manual Input Cost|Semi-Updated",	"A|M|S");

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
				}
			break;
			case 11: // t5sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(15);
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(43, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks";

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"calc_tp_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			65,		daCenter,		false,	"wrk_dt"					,	false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daRight,		false,	"stk_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);

					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_vol_qty"				,	false,	"",	dfFloat,		2,	true,	true);
					InitDataProperty(0, cnt++, dtData,			37,		daRight,		false,	"diff_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"fp_teu_qty"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			45,		daRight,		false,	"ovr_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			35,		daRight,		false,	"vol_tr_ut_cd"			,	false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"ctrt_rt"					,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"curr_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_xch_rt"				,	false,	"",	dfFloat,		5,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_amt"					,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			200,	daLeft,			false,	"calc_rmk"				,	false,	"",	dfNone,		0,	true,	true);

					InitDataProperty(0, cnt++, dtHidden,			60,		daRight,		false,	"calc_amt"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			10,		daLeft,			false,	"tml_agmt_ofc_cty_cd"	,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_agmt_ver_no"		,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			125,	daLeft,			false,	"lgs_cost_cd2"			,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"calc_cost_grp_cd"		,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_so_dtl_seq"			,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"fp_calc_prd_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"calc_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"io_bnd_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"rvis_vol_qty"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"dcgo_ind_cd"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"free_dys"					,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"inv_amt2"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"ovr_dys"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"paid_day"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"stay_dys"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"acct_cd"					,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"curr_chk"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			40,		daCenter,		false,	"rc_flg"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			80,		daCenter,		false,	"rev_yrmon"				,	false,	"",	dfDateYm,	0,	false,	false);

					InitDataCombo(0,	"calc_tp_cd",	"Auto Calculated Cost|Manual Input Cost",	"A|M|S");

					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
				}
			break;
			
			// Marine Storage Invoice
			case 12:   //t1sheet1 init
				with (sheetObj) {

					style.height=GetSheetHeight(15);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1 , 5, 10000);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(35, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|CNTR No.|CNTR\nDTC|Cost\r\nCalculated|Type/Size|Gate In|Gate Out|F/M|I/O|TS|DG|B/B|Verify\nResult|Remarks|STS";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	6);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			90,		daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false,	3);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"modi_flg"				,	false,	"",	dfNone,		0,	true,	true,	9,	false,	true,	"Move Container Discrepancy to Coincidence");
					InitDataProperty(0, cnt++,	dtData,			90,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	true,	true,	0,	false,	true);
                    InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	false,	false,	1);

                    InitDataProperty(0, cnt++, dtData,			110,	daCenter,		false,	"inv_gate_in_dt"			,	false,	"",	dfUserFormat2,	0,	false,	false,	9);
                    InitDataProperty(0, cnt++, dtData,			110,	daCenter,		false,	"inv_gate_out_dt"		,	false,	"",	dfUserFormat2,	0,	false,	false,	6);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"cntr_sty_cd"				,	false,	"",	dfNone,		0,	true,	true,	9);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"io_bnd_cd"				,	false,	"",	dfNone, 		0,	true,	true,	9);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"locl_ts_ind_cd"			,	false,	"",	dfNone, 		0,	true,	true,	9);
                    
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"dcgo_clss_cd"			,	false,	"",	dfNone,		0,	true,	true,	1);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"bb_cgo_flg"				,	false,	"",	dfNone,		0,	true,	true,	9);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"dscr_ind_cd"			,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,			false,	"cntr_rmk"				,	false,	"",	dfNone, 		0,	true,	true,	500);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"tml_so_cntr_list_seq"	,	false,	"",	dfInteger,		0,	false,	false,	9);
					
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no"					,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no_split"			,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"vrfy_rslt_ind_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"gate_in_td_dys"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"gate_out_td_dys"		,	false,	"",	dfNone,		0,	true,	true,	9);
					
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"inv_stay_dys"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"mvmt_gate_in_dt"		,	false,	"",	dfUserFormat2,	0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"mvmt_gate_out_dt"		,	false,	"",	dfUserFormat2,	0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"mvmt_stay_dys"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no"					,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no_chk"				,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no_tp"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"vsl_cd"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"skd_voy_no"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"skd_dir_cd"				,	false,	"",	dfNone,		0,	false,	false);

                    InitUserFormat2(0,	"inv_gate_in_dt",	"####-##-## ##:##",	"-|:" );
                    InitUserFormat2(0,	"inv_gate_out_dt",	"####-##-## ##:##",	"-|:" );
					InitUserFormat2(0,	"mvmt_gate_in_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"mvmt_gate_out_dt",	"####-##-## ##:##",	"-|:");
					
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
			break;
			case 13:   //t2sheet1 init
				with (sheetObj) {

					style.height=GetSheetHeight(15);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1 , 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(36, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					var HeadTitle0 = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Discrepancy Type|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O|Remarks";
					var HeadTitle1 = "||||||||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq,		30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"dscr_ind_cd"			,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			130,	daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtData,			50,		daCenter,		false,	"cntr_sty_cd"				,	false,	"",	dfNone,		0,	true,	true,	9);

					InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"mvmt_gate_in_dt"		,   false,	"",	dfUserFormat2,	0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"inv_gate_in_dt"			,   false,	"",	dfUserFormat2,	0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"gate_in_td_dys"			,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"mvmt_gate_out_dt"		,   false,	"",	dfUserFormat2,	0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			95,		daCenter,		false,	"inv_gate_out_dt"		,   false,	"",	dfUserFormat2,	0,	false,	false);

                    InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"gate_out_td_dys"		,	false,	"",	dfInteger, 	0,	false,	false);
                    InitDataProperty(0, cnt++,	dtData,			50,		daLeft,			false,	"cntr_rmk"				,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"tml_so_cntr_list_seq"	,	false,	"",	dfInteger,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no"					,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bkg_no_split"			,	false,	"",	dfNone,		0,	false,	false,	9);

					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"vrfy_rslt_ind_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"modi_flg"				,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"bb_cgo_flg"				,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"dcgo_clss_cd"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"io_bnd_cd"				,	false,	"",	dfNone,		0,	true,	true,	9);

					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"locl_ts_ind_cd"			,	false,	"",	dfNone,		0,	true,	true,	9);
                    InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no_chk"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"bl_no_tp"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"vsl_cd"					,	false,	"",	dfNone,		0,	false,	false);

                    InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"skd_voy_no"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daCenter,		false,	"skd_dir_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"inv_stay_dys"			,	false,	"",	dfNone,		0,	true,	true,	9);
					InitDataProperty(0, cnt++, dtHidden,			10,		daCenter,		false,	"mvmt_stay_dys"			,	false,	"",	dfNone,		0,	true,	true,	9);


					InitUserFormat2(0,	"inv_gate_in_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"inv_gate_out_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"mvmt_gate_in_dt",	"####-##-## ##:##",	"-|:");
					InitUserFormat2(0,	"mvmt_gate_out_dt",	"####-##-## ##:##",	"-|:");

					InitDataCombo(0 ,	"dscr_ind_cd",	"Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date|Another Movement",	"DD|DP|HO|PD|NH|DB|DF|AM");

					HeadRowHeight = 10;
					RangeBackColor(1,7,1,8) = RgbColor(222, 251, 248);   // ALPS
					RangeBackColor(1,10,1,11) = RgbColor(222, 251, 248);   // ALPS
				}
			break;
			case 14:   //t3sheet1 init
				with (sheetObj) {

					style.height=GetSheetHeight(15);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1 , 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					// 컬럼 데이타 변경(추가, 삭제)시 function resetSheetDataProperty(CURR_CD) 컬럼 번호 수정 확인 ( ctrt_rt, inv_amt )
					InitColumnInfo(36, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"calc_tp_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			80,		daLeft,			false,	"cntr_no"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			40,		daCenter,		false,	"cntr_tpsz_cd"			,	false,	"",	dfNone,		0,	false,	false);
                    
                    InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"io_bnd_cd"				,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"dcgo_ind_cd"			,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"rev_yrmon"				,	false,	"",	dfDateYm,	0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			45,		daCenter,		false,	"stay_dys"					,	false,	"",	dfInteger,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			45,		daCenter,		false,	"free_dys"					,	false,	"",	dfInteger,		0,	false,	false);
                    
                    InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"pay_dys"					,	false,	"",	dfInteger,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"free_dy_xcld_dys"		,	false,	"",	dfInteger,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"ovr_dys"					,	false,	"",	dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			35,		daCenter,		false,	"vol_tr_ut_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			40,		daRight,		false,	"ctrt_rt"					,	false,	"",	dfFloat,		2,	false,	false);

                    InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"curr_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_xch_rt"				,	false,	"",	dfFloat,		5,	false,	false);
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_amt"					,	false,	"",	dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			150,	daLeft,			false,	"calc_rmk"				,	false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtData,			15,		daLeft,			false,	"n3pty_flg"				,	false,	"",	dfNone,		0,	true,	true);
                    
                    InitDataProperty(0, cnt++, dtHidden,			60,		daRight,		false,	"calc_amt"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_ofc_cty_cd"	,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_ver_no"		,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			50,		daLeft,			false,	"lgs_cost_cd2"			,	false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtHidden,			20,		daCenter,		false,	"calc_cost_grp_cd"		,	false,	"",	dfNone,		0,	false,	false,	9);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"fp_calc_prd_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			true,	"tml_so_dtl_seq"			,	false,	"",	dfInteger,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"acct_cd"					,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"curr_chk"				,	false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtHidden,			35,		daCenter,		false,	"ovr_dys2"				,	false,	"",	dfInteger,		0,	false,	false);

					InitDataCombo(0 ,	"calc_tp_cd",	"Auto Calculated Cost|Manual Input Cost",	"A|M|S");
				}
			break;
			case 15:   //t4sheet1 init
				with (sheetObj) {

					style.height=GetSheetHeight(15);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1 , 5, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					// 컬럼 데이타 변경(추가, 삭제)시 function resetSheetDataProperty(CURR_CD) 컬럼 번호 수정 확인 ( ctrt_rt, inv_amt )
					InitColumnInfo(32, 6, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					// 2008-07-02 3rd party interface 로직변경요청 CSR start
					//var HeadTitle = "|Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party ";
					var HeadTitle = "Seq.|Cost Office|Inv Office|Yard|S/P|INV No.|Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|Year\nMonth ";
					// 2008-07-02 3rd party interface 로직변경요청 CSR end

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,				30,		daCenter,		false,	""							,	false,	"",	dfNone,		0,	true,	true,	30);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"cost_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"inv_ofc_cd"				,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"yd_cd"					,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,		false,	"vndr_seq"				,	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daCenter,		false,	"inv_no"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtCombo,			150,	daLeft,			false,	"calc_tp_cd"				,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"lgs_cost_cd"				,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			80,		daCenter,		false,	"wrk_dt"					,	false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"stk_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);
                    
					InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"inv_vol_qty"				,	false,	"",	dfFloat,		2,	true,	true);
                    InitDataProperty(0, cnt++, dtData,			60,		daRight,		false,	"diff_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			45,		daRight,		false,	"fp_teu_qty"				,	false,	"",	dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			35,		daRight,		false,	"ovr_vol_qty"				,	false,	"",	dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			30,		daCenter,		false,	"vol_tr_ut_cd"			,	false,	"",	dfNone,		1,	true,	true);
                    
					InitDataProperty(0, cnt++,	dtData,			50,		daRight,		false,	"ctrt_rt"					,	false,	"",	dfFloat,		2,	false,	false);
                    InitDataProperty(0, cnt++, dtData,			60,		daCenter,		false,	"curr_cd"					,	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++, dtData,       		60,		daRight,		false,	"inv_xch_rt"				,	false,	"",	dfFloat,		5,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daRight,		false,	"inv_amt"					,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtData,			200,	daLeft,			false,	"calc_rmk"				,	false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"n3pty_flg"				,	false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtHidden,			70,		daRight,		false,	"calc_amt"				,	false,	"",	dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_ofc_cty_cd"	,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_seq"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			30,		daLeft,			false,	"tml_agmt_ver_no"		,	false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++, dtHidden,			50,		daLeft,			false,	"lgs_cost_cd2"			,	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"calc_cost_grp_cd"		,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"tml_so_dtl_seq"			,	false,	"",	dfInteger,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"fp_calc_prd_cd"			,	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"acct_cd"					,	false,	"",	dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++, dtHidden,			20,		daLeft,			false,	"curr_chk"				,	false,	"",	dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++, dtHidden,			80,		daCenter,		false,	"rev_yrmon"				,	false,	"",	dfDateYm,	0,	true,	true);

					InitDataCombo(0 ,	"calc_tp_cd",	"Auto Calculated Cost|Manual Input Cost",	"A|M|S");
				}
			break;
		}
	}
	
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param tab_obj
     */
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
	 * INVOICE Layer
	 * 1 : Marine Terminal Invoice
	 * 2 : On-dock Rail Charge Invoice
	 * 3 : Off-dock CY Invoice
	 * 4 : Marine Terminal Strorage Invoice
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     * @param(tab_obj)
     */
	function initTab(tabObj , tabNo) {
		var cnt  = 0 ;

		switch(tabNo) {
			// Marine Invoice
			case 1:
				with (tabObj) {
					cnt  = 0 ;
					InsertTab( cnt++ , "Coincidence" , -1 );
					InsertTab( cnt++ , "Discrepancy" , -1 );
					InsertTab( cnt++ , "Cost Calculation" , -1 );
				}
			break;
			// On-dock Invoice
			case 2:
				with (tabObj) {
				cnt  = 0 ;
				InsertTab( cnt++ , "Coincidence" , -1 );
				InsertTab( cnt++ , "Discrepancy" , -1 );
				InsertTab( cnt++ , "Cost Calculation" , -1 );
				}
			break;
			// Off-dock Invoice
			case 3:
				with (tabObj) {
				cnt  = 0 ;
				InsertTab(cnt++, "Coincidence  ", -1);
				InsertTab(cnt++, "Discrepancy  ", -1);
				InsertTab(cnt++, "Cost Calc.(TMNL)", -1);
				InsertTab(cnt++, "Cost Calc.(SR by FD)", -1);
				InsertTab(cnt++, "Cost Calc.(SR by FP)", -1);
				}
			break;
			// Storage Invoice
			case 4:
				with (tabObj) {
				cnt  = 0 ;
                InsertTab( cnt++ , "Coincidence  " , -1 );
                InsertTab( cnt++ , "Discrepancy  " , -1 );
                InsertTab( cnt++ , "Cost Calc.(SR by FD)" , -1 );
                InsertTab( cnt++ , "Cost Calc.(SR by FP)" , -1 );
				}
			break;
		}
	}

	/**
	 * 1 : Marine Terminal Invoice
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param(tabObj)
	 * @param(nItem)
	 */
	function tmtab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tmtabLayer");

		objs[nItem].style.display		= "Inline";
		objs[beforetab].style.display	= "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * 1 : Marine Terminal Invoice
	 * 2 : On-dock Rail Charge Invoice
	 * 3 : Off-dock CY Invoice
	 * 4 : Marine Terminal Strorage Invoice
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param(tabObj)
	 * @param(nItem)
	 */
	function ontab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("ontabLayer");

		objs[nItem].style.display		= "Inline";
		objs[beforetab1].style.display	= "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab1].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab1= nItem;
	}

	
	/**
	 * 1 : Marine Terminal Invoice
	 * 2 : On-dock Rail Charge Invoice
	 * 3 : Off-dock CY Invoice
	 * 4 : Marine Terminal Strorage Invoice
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param(tabObj)
	 * @param(nItem)
	 */
	function offtab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("offtabLayer");
		
		objs[nItem].style.display		= "Inline";
		objs[beforetab2].style.display	= "none";
		
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab2].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab2= nItem;
	}
	
	/**
	 * 1 : Marine Terminal Invoice
	 * 2 : On-dock Rail Charge Invoice
	 * 3 : Off-dock CY Invoice
	 * 4 : Marine Terminal Strorage Invoice
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param(tabObj)
	 * @param(nItem)
	 */
	function sttab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("sttabLayer");
		
		objs[nItem].style.display		= "Inline";
		objs[beforetab3].style.display	= "none";
		
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab3].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab3= nItem;
	}
	

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj) {
//            if (!ComIsNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
    
	
	/**
	 * INVOICE Layer를 비활성화하는 메소드이다.
	 * 0 : Marine Terminal Invoice
	 * 1 : On-dock Rail Charge Invoice
	 * 2 : Off-dock CY Invoice
	 * 3 : Marine Terminal Strorage Invoice
	 */	 
	function invoiceOnclick(nlayer) {
		// INVOICE 선택여부에 따라 sheet div를 display
		var objs = document.all.item("invoiceLayer");

		if ( nlayer != beforelayer ) {
			objs[nlayer].style.display		= "inline";
			objs[beforelayer].style.display	= "none";
	
			beforelayer	= nlayer;
		}
	}
    
	/**
	 * cost type 전체를 비활성화 하는 메소드 이다.  
	 */	 
	function cost_tpOnclick() {
		document.form.cost_tp[0].checked = false;
		ComEnableManyObjects(true, document.form.cntr_tp[0], document.form.cntr_tp[1]);
	}
	
	
	/**
	 * 기간 체크
	 */
	function setPeriodFromTo() {
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var to_dt = new String(formObj.DB_DATE.value).substring(0, 8);
		var fr_dt;
		if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8) {
			// fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6, 8);
			if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
				if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))) {
					fr_dt = fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
				}
				formObj.fm_prd_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
				formObj.to_prd_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
			}
		}
	}


	/**
	 * yard code 가져 옮 
	 */	 
	function getYard(rowArray) {
		var colArray = rowArray[0];

		document.all.loc_cd.value = colArray[3].substr(0, 5);
		node = colArray[3].substr(5, 2);
		tes_getComboItem('nod_cd', 1, SEARCHLIST04, '', 'loc_cd', 'setNodCode');
	}


	/**
	 * nod code 가져 옮 
	 */	 	 
	function setNodCode() {
		document.all.nod_cd.Code = node;
		node = '';
	}

	/**
	 * code combo 값을 가져온다.
	 *  @param(obj) object
	 */	 
	function getNodeCodeCombo(obj) {
		if (obj.value.length == "5") {
			tes_getComboItem('nod_cd', 1, SEARCHLIST04, '', 'loc_cd','');
		} else {
			return false;
		}
	}

	/**
	 * yard code 변경
	 * @return
	 */ 
	function nod_cd_OnChange() {
	    var formObj = document.form;
	    
	    formObj.yd_cd.value = formObj.loc_cd.value + formObj.nod_cd.Code;
	    validateYardCode();
	}
	 
	/**
	 * yard code 값 null, '' 체크
	 */	 	 
	function validateYardCode() {
		var formObj = document.form;
		if ( formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '' ) {
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			
			return false;
		}
		if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
		}
	}

	/**
	 * yard code 유효성체크
	 */	 
	function checkValidYardCode() {
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value != undefined && formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value.trim() != '') {
			tmp = formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0) {
				formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
					formObj.yd_cd_hidden.value = formObj.yd_cd.value;

					formObj.yd_cd_deltflg.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');

					if (formObj.yd_cd_deltflg.value == "Y") {
							ComShowMessage('Deleted Yard Code!');
					}
				} else {
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					formObj.yd_cd.value = '';
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_cd.value = '';
				ComShowCodeMessage('TES10066');
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_cd.value = '';
			ComShowCodeMessage('TES10066');
		}
	}
    
	/**
	 *  cost code 값 null, '' 체크 
	 *	@return
	 */	 	
	function validateCostOFCCode() {
		var formObj = document.form;
		if (formObj.cost_ofc_cd.value == null || formObj.cost_ofc_cd.value.trim() == '') {
			formObj.cost_ofc_cd_hidden.value = '';
			formObj.is_valid_cost_ofc_cd.value = '';
			return false;
		}
		if ((formObj.cost_ofc_cd_hidden.value == null || formObj.cost_ofc_cd_hidden.value.trim() == '') || formObj.cost_ofc_cd.value.trim() != formObj.cost_ofc_cd_hidden.value.trim() ) {
			formObj.cost_ofc_cd_hidden.value = '';
			formObj.is_valid_cost_ofc_cd.value = '';
			tes_getInputValue('is_valid_cost_ofc_cd', SEARCHLIST02, 'cost_ofc_cd', 'checkValidCostOFCCode');
		}
	}
    
	/**
	 *  cost code 값 유효성 체크 
	 *	@return
	 */		
	function checkValidCostOFCCode() {
		var formObj = document.form;
		var tmp = '';
	
		if (formObj.is_valid_cost_ofc_cd.value != undefined && formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value.trim() != '') {
			tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
			if (tmp.length > 0 ) {
				formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y' ) {
					formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;
					formObj.cost_ofc_cd_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');

					if (formObj.cost_ofc_cd_deltflg.value=="Y") {
						ComShowMessage('Deleted Office Code!');
					}
				} else {
					formObj.is_valid_cost_ofc_cd.value = '';
					formObj.cost_ofc_cd_hidden.value = '';
					formObj.cost_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Cost Office Code');
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				formObj.cost_ofc_cd_hidden.value = '';
				formObj.cost_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Cost Office Code');
			}
		} else {
			formObj.is_valid_cost_ofc_cd.value = '';
			formObj.cost_ofc_cd_hidden.value = '';
			formObj.cost_ofc_cd.value = '';
			ComShowCodeMessage('TES40052', 'Cost Office Code');
		}
	}	     
    
	/**
	 * cost ofc code 가져 옮 
	 * @param(rowArray)  
	 */	 
	function getCostOfc(rowArray) {
		var formObject = document.form;
	
		for (var i = 0; i < rowArray.length; i++) {
			var colArray = rowArray[0];
			document.form.cost_ofc_cd.value = colArray[3];
		}
	}

	/**
	 * invoice code 가져 옮 
	 * @param(rowArray)  
	 */	 
	function getInvOfc(rowArray) {
		var formObject = document.form;
		
		for (var i = 0; i < rowArray.length; i++) {
			var colArray = rowArray[0];
			document.form.inv_ofc_cd.value = colArray[3];
		}
	}
	
	/**
	 *  invoice office code 값 null, '' 체크 
	 *	@return
	 */	    
    function validateInvOFCCode() {
        var formObj = document.form;
        if (formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value.trim() == '') {
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.is_valid_inv_ofc_cd.value = '';
            return false;
        }
        if ((formObj.inv_ofc_cd_hidden.value == null || formObj.inv_ofc_cd_hidden.value.trim() == '') || formObj.inv_ofc_cd.value.trim() != formObj.inv_ofc_cd_hidden.value.trim()) {
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.is_valid_inv_ofc_cd.value = '';
            tes_getInputValue('is_valid_inv_ofc_cd', SEARCHLIST03, 'inv_ofc_cd', 'checkValidInvOFCCode');
        }
    }

	/**
	 *  invoice office 값 유효성 체크 
	 *	@return
	 */	    
	function checkValidInvOFCCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_inv_ofc_cd.value != undefined && formObj.is_valid_inv_ofc_cd.value != null && formObj.is_valid_inv_ofc_cd.value.trim() != '' ) {
			tmp = formObj.is_valid_inv_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_inv_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_inv_ofc_cd.value != null && formObj.is_valid_inv_ofc_cd.value == 'Y'){
					formObj.inv_ofc_cd_hidden.value = formObj.inv_ofc_cd.value;

					formObj.inv_ofc_cd_deltflg.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');

					if (formObj.inv_ofc_cd_deltflg.value == "Y") {
						ComShowMessage('Deleted Office Code!');
					}

				} else {
					formObj.is_valid_inv_ofc_cd.value = '';
					formObj.inv_ofc_cd_hidden.value = '';
					formObj.inv_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Invoice Office Code');
				}
			} else {
				formObj.is_valid_inv_ofc_cd.value = '';
				formObj.inv_ofc_cd_hidden.value = '';
				formObj.inv_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Invoice Office Code');
			}
		} else {
			formObj.is_valid_inv_ofc_cd.value = '';
			formObj.inv_ofc_cd_hidden.value = '';
			formObj.inv_ofc_cd.value = '';
			ComShowCodeMessage('TES40052', 'Invoice Office Code');
			
		}
	}
	
	
	/**
	 * 사용자가 입력한 검색조건 날짜를 받아서 From Date가 To Date보다 크게 입력되었는지 확인한다.
	 */
	function chkPeriod() {
		var formObj = document.form;
		var is_valid=0;
		var fromVal = formObj.fm_prd_dt.value;
		var toVal = formObj.to_prd_dt.value;

		is_valid = ComGetDaysBetween(fromVal, toVal);
		if (is_valid<0) {
			formObj.to_prd_dt.value = '';
			ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
		}
	}

	/**
	 * 사용자가 VNDR Seq를 직접 입력할 경우 해당VNDR Name을 화면에 보여준다.
	 * @param(obj) object
	 */
	function getVndrName(obj) {
		var formObj = document.form;
		if (tes_getStrLen(obj.value) == 6) {
			if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
				formObj.vndr_seq_hidden.value = '';
				formObj.is_valid_vndr_seq.value = '';
				return false;
			}
			if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
				formObj.vndr_seq_hidden.value = '';
				formObj.is_valid_vndr_seq.value = '';
				tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
			}
		}
	}

	/**
	 * vndr code 값 null,'' 체크
	 */	 
	function checkValidVndrCode() {
		var formObj = document.form;
		var tmp = '';
//		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!='') {
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0) {
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				formObj.vndr_seq.focus();
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			formObj.vndr_seq.focus();
		}
	}
	
	/**
	 * Vendor Help 화면에서 선택한 벤더를 작업화면으로 보내준다.
	 * @param(rowArray) 
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		document.all.vndr_seq.value = colArray[6];
		document.all.vndr_seq_name.value = colArray[4];
	}

	/**
	 * vndr code null, '' 값 체크
	 */	 
	function validateVNDRCode() {
		var formObj = document.form;
		if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}

		if (formObj.vndr_seq.value.length < 6) {
			formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}

		if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVNDRCode');
		}
	}

	/**
	 * vndr code 값 유효성 체크
	 */	 
	function checkValidVNDRCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;

					formObj.vndr_seq_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

					if (formObj.vndr_seq_deltflg.value=="Y") {
						ComShowMessage('Deleted S/P Code!');
					}
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					ComShowCodeMessage('TES10067');//msgs['TES10067'] = '유효하지 않은 VendorCode입니다.' ;
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowCodeMessage('TES10067');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowCodeMessage('TES10067');
		}
	}

	 /**
	 * 입력된 vndr_seq값을 Validation하는 함수
	 *
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		
		if (formObj.vndr_seq.value.length < 6) {
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}
		
		if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}
	
	/**
	 * 
	 */
	function checkValidVndrCode() {
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!='') {
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0) {
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y') {
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();
		
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				formObj.vndr_seq.focus();
		
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			formObj.vndr_seq.focus();
		}
	}
	

    
    /** 글입력시 max length 체크해서 false 리턴함
	 * @param {obj}  object
	 **/
	function chkInput(obj) {
		//	ComShowMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}
 
	/** 숫자인지 체크함
	 * @param {obj}  object
	 **/	
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	 
	/** 숫자인지 체크함, 숫자값에 대시를 넣어준다
	 * @param {obj}  object
	 **/		 
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,"-")) {
			obj.value = '';
		}
	}

	/** 영문과 숫자인지 체크함
	 * @param {obj}  object
	 **/	 
	function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj, 'n')) {
			obj.value = '';
		}
	}

	/** 영문인지 체크함
	 * @param {obj}  object
	 **/	 
    function isAlpha(obj) {
        if (!ComIsAlphabet(obj)) {
           obj.value = "";
        }

    }

	/** 한글 및 영문 길이 체크
	 * @param {src}  문자열
	 **/ 
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}
	
	
	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function t1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet(sheetObj, formObject, IBSEARCHAPPEND, PageNo);
	}
	
	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function ondockt1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet1(sheetObj, formObject, IBSEARCHAPPEND, PageNo);
	}
	
	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function offdockt1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet2(sheetObj, formObject, IBSEARCHAPPEND, PageNo);
	}
	
	/**
	 * 
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRow
	 */
	function storaget1sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRow) {
		var formObject	= document.form;
		doActionIBSheet3(sheetObj, formObject, IBSEARCHAPPEND, PageNo);
	}
	
	/**
	 * Marine Terminal Invoice Sheet에 Coincidency, Discrepancy, Calculation값을 모두 가져와 담아준다.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction, PageNo) {
		sheetObj.ShowDebugMsg = false;
		if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		}
		formObj.iPageTm.value = PageNo;

		switch (sAction) {
			case (IBSEARCH) :
				formObj.f_cmd.value = SEARCH01;
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
	            
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null;
			break;
			
			case (IBSEARCHAPPEND) :  // 페이징 조회
				formObj.f_cmd.value = SEARCH01;

				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[0].LoadSearchXml(arrXml[0], true);
				sheetObjects[1].LoadSearchXml(arrXml[1], true);
				sheetObjects[2].LoadSearchXml(arrXml[2], true);
				
			break; 				
			
			case IBDOWNEXCEL:		//엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
			break;
		}
	}

	/**
	 * On-dock Rail Charge Invoice Sheet에 Coincidency, Discrepancy, Calculation값을 모두 가져와 담아준다.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */ 
	function doActionIBSheet1(sheetObj, formObj, sAction, PageNo) {
		sheetObj.ShowDebugMsg = false;

		if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		}

		formObj.iPageOn.value = PageNo;
		
		switch (sAction) {
			case (IBSEARCH) :
				formObj.f_cmd.value = SEARCH02;
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj));
				
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[3].LoadSearchXml(arrXml[0]);
				sheetObjects[4].LoadSearchXml(arrXml[1]);
				sheetObjects[5].LoadSearchXml(arrXml[2]);				
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null;
			break;
			
			case (IBSEARCHAPPEND) :  // 페이징 조회
				formObj.f_cmd.value = SEARCH02;
			
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[3].LoadSearchXml(arrXml[0], true);
				sheetObjects[4].LoadSearchXml(arrXml[1], true);
				sheetObjects[5].LoadSearchXml(arrXml[2], true);				
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null;
			break; 				

			case IBDOWNEXCEL:		//엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
			break;
			}
	}
	
	/**
	 * Off-dock CY Invoice Sheet에 Coincidency, Discrepancy, Calculation(TM, FD, FP)값을 모두 가져와 담아준다.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */ 
	function doActionIBSheet2(sheetObj, formObj, sAction, PageNo) {
		sheetObj.ShowDebugMsg = false;

		if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		}
		formObj.iPageOf.value = PageNo;

		switch (sAction) {
			case (IBSEARCH) :
				formObj.f_cmd.value = SEARCH03;
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj));
				
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[6].LoadSearchXml(arrXml[0]);
				sheetObjects[7].LoadSearchXml(arrXml[1]);
				sheetObjects[8].LoadSearchXml(arrXml[2]);
				sheetObjects[9].LoadSearchXml(arrXml[3]);
				sheetObjects[10].LoadSearchXml(arrXml[4]);
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null; arrXml[3] = null; arrXml[4] = null;
			break;
			
			case (IBSEARCHAPPEND) :  // 페이징 조회
				formObj.f_cmd.value = SEARCH03;
			
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[6].LoadSearchXml(arrXml[0], true);
				sheetObjects[7].LoadSearchXml(arrXml[1], true);
				sheetObjects[8].LoadSearchXml(arrXml[2], true);
				sheetObjects[9].LoadSearchXml(arrXml[3], true);
				sheetObjects[10].LoadSearchXml(arrXml[4], true);
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null; arrXml[3] = null; arrXml[4] = null;
			break; 				

			case IBDOWNEXCEL:		//엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
			break;
		}
	}
	
	/**
	 * Marine Terminal Strorage Invoice Sheet에 Coincidency, Discrepancy, Calculation (SD, SP)값을 모두 가져와 담아준다.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */ 
	function doActionIBSheet3(sheetObj, formObj, sAction, PageNo) {
		sheetObj.ShowDebugMsg = false;

		if ( PageNo == undefined || PageNo == "" || PageNo == 0 ) {
			PageNo = 1;
		}
		formObj.iPageSt.value = PageNo;

		switch (sAction) {
			case (IBSEARCH) :
				formObj.f_cmd.value = SEARCH04;
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj));
				
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[11].LoadSearchXml(arrXml[0]);
				sheetObjects[12].LoadSearchXml(arrXml[1]);
				sheetObjects[13].LoadSearchXml(arrXml[2]);
				sheetObjects[14].LoadSearchXml(arrXml[3]);
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null; arrXml[3] = null;
			break;

			case (IBSEARCHAPPEND) :  // 페이징 조회
				formObj.f_cmd.value = SEARCH04;
			
				var searchXml = sheetObj.GetSearchXml("ESD_TES_0015GS.do", tesFrmQryStr(formObj), "iPage=" + PageNo);
				var arrXml = searchXml.split("|$$|"); 
				sheetObjects[11].LoadSearchXml(arrXml[0], true);
				sheetObjects[12].LoadSearchXml(arrXml[1], true);
				sheetObjects[13].LoadSearchXml(arrXml[2], true);
				sheetObjects[14].LoadSearchXml(arrXml[3], true);
				searchXml = null; arrXml[0] = null; arrXml[1] = null; arrXml[2] = null; arrXml[3] = null;
			break; 				

			case IBDOWNEXCEL:		//엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
			break;
			
		}
	}
	
	
	/**
	 * 영문인지 체크함
	 * @param {object}	obj		input object
	 * @return
	 */	
    function isAlpha(obj) {
        if (!ComIsAlphabet(obj)) {
           obj.value = "";
        }
    }

	/**
	 * 글입력시 max length 체크해서 false 리턴함
	 * @param {object}	obj		input object
	 * @return 
	 */
	function chkInput(obj) {
		if (obj.maxLength < ComGetLenByByte(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}

	function getSubOffice1(){
    	if(document.form.sub_office1.checked == true){
    		if(document.form.cost_ofc_cd.value != ''){
    			document.form.ofc_cd.value = document.form.cost_ofc_cd.value;
    			tes_getInputValue('sub_ofc_cd1', SEARCHLIST15, 'ofc_cd', 'setSubOffice1');
    		} else {
    			ComShowMessage('Please enter Cost Office.');
				document.form.sub_office1.checked = false;
    		}
    	} else {
    		document.form.sub_ofc_cd1.value = '';
    		document.form.cost_ofc_cd.value = '';
    	} 
    }
    
    function setSubOffice1(){
    	if(document.form.sub_ofc_cd1.value != ''){
    		document.form.cost_ofc_cd.value = document.form.sub_ofc_cd1.value;
    	}
    }
    	
    function getSubOffice2(){
		if(document.form.sub_office2.checked == true){
			if(document.form.inv_ofc_cd.value != ''){
				document.form.ofc_cd.value = document.form.inv_ofc_cd.value;
				tes_getInputValue('sub_ofc_cd2', SEARCHLIST15, 'ofc_cd', 'setSubOffice2');
			} else {
				ComShowMessage('Please enter Invoice Office.');
				document.form.sub_office2.checked = false;
			}
		} else {
			document.form.sub_ofc_cd2.value = '';
			document.form.inv_ofc_cd.value = '';
		}  	
    }
    
    function setSubOffice2(){
    	if(document.form.sub_ofc_cd2.value != ''){
    		document.form.inv_ofc_cd.value = document.form.sub_ofc_cd2.value;
    	}
    }

