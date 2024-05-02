/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0504.js
*@FileTitle : Vessel Operation Incentive Status 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 
* 2016.04.26 Create
* 1.0 최초 생성
=========================================================*/

/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends EAS
 * @class ESD_EAS_0501
 */
function ESD_EAS_0501() {
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
var sheetCnt 	= 0;

var Mincount = 0;

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

	var formObj = document.form;

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	// IBMultiCombo 설정
	for(var k = 0; k < comboObjects.length; k++){
		initCombo(comboObjects[k], k + 1);
		comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
	}
	initControl();
	doActionIBSheet(sheetObjects[0], formObj, "offce_level"); // RHQ

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
 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인
 * 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */ 
function initCombo(comboObj, comboNo) {

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
	function initControl() {
	axon_event.addListenerForm  ( 'blur'     ,'obj_blur'      ,document.form ); //- 포커스 나갈때
	axon_event.addListenerFormat( 'focus'    ,'obj_focus'     ,document.form ); //- 포커스 들어갈때
	axon_event.addListenerForm  ( 'change'   ,'obj_change'    ,document.form );
	axon_event.addListenerFormat( 'keypress', 'keypressFormat',document.form); //- 키보드 입력할때

	}
	

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var sheetObject   = sheetObjects[0];
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:      //sheet1 Vessel Operation
			with (sheetObj) {
			
	            //style.height = GetSheetHeight(8); // 높이 설정
	            style.height = 380;
	            SheetWidth = mainTable.clientWidth; //전체 너비 설정
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;     
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(3, 1, 9, 100);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(49, 6, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false, false);
	
				var HeadTitle1 = "|SEL|SEQ|YEAR|RHQ|OFC|Port|Item|Service Provider|Service Provider"
						       + "|CUR|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received|Yearly Estimated and Received"
                               + "|Explanation for\nCredit or discount|the settlement way of\nthe credit or discount|Evidence Attachment\n(Calculation&Obtaining)||Evidence Attachment\n(Collection&Using)||Remark|USD Rate"
						       ;
				var HeadTitle2 = "|SEL|SEQ|YEAR|RHQ|OFC|Port|Item|Code|Name"
							   + "|CUR|Jan|Jan|Feb|Feb|Mar|Mar|Apr|Apr|May|May|Jun|Jun|Jul|Jul|Aug|Aug|Sep|Sep|Oct|Oct|Nov|Nov|Dec|Dec|Yearly Amount|Yearly Amount|Yearly Amount|USD Conversion|USD Conversion|USD Conversion"
                               + "|Explanation for\nCredit or discount|the settlement way of\nthe credit or discount|Evidence Attachment\n(Calculation&Obtaining)||Evidence Attachment\n(Collection&Using)||Remark|USD Rate"
                 			   ;
				var HeadTitle3 = "|SEL|SEQ|YEAR|RHQ|OFC|Port|Item|Code|Name"
							   + "|CUR|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Estimated|Received|Balance|Estimated|Received|Balance"
                               + "|Explanation for\nCredit or discount|the settlement way of\nthe credit or discount|Evidence Attachment\n(Calculation&Obtaining)||Evidence Attachment\n(Collection&Using)||Remark|USD Rate"
							   ;
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            InitHeadRow(2, HeadTitle3, true);
	            
	            //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, COLMERGE, 	SAVENAME,		  			KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 45,  	daCenter, 	true,   	"ibflag",  					false,    	"",  		dfNone,     	0,     	true,   true,    	0,   	false,   	true,      "",    false);
				InitDataProperty(0, cnt++ , dtCheckBox,     40,  	daCenter, 	true,   	"chk",  					false,    	"",  		dfNone,     	0,     	true,   true );
				InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,  	true,   	"incnt_no",  				false,    	"",  		dfEngUpKey,     0,     	false,  false,  	11,   	false,   	true,      "",    false);
				InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,  	true,       "bse_yr",  					false,    	"",  		dfNone,     	0,     	false,  false,    	4,   	false,   	true,      "",    false);
	            InitDataProperty(0, cnt++ , dtData,  		60,   	daCenter,  	true,    	"rhq_cd",		    		false,  	"",			dfEngUpKey,   	0,  	false,	false,		6,		false,		true,	   "",	  false	); 
	            InitDataProperty(0, cnt++ , dtData,   		60,   	daCenter,  	true,    	"ofc_cd",					false,  	"",			dfEngUpKey,   	0,  	false,	false,		6,		false,		true,	   "",	  false	);  
	            InitDataProperty(0, cnt++ , dtData,   		60,   	daCenter,  	true,    	"port_cd",					false,  	"",			dfEngUpKey,   	0,  	true,	true,		5,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtCombo,   		80,   	daLeft,  	true,    	"itm_cd",					false,  	"",			dfEngUpKey,   	0,  	true,	true,		2,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtPopupEdit,	80,   	daCenter,  	true,    	"vndr_seq",					false,  	"",			dfNone,   		0,  	false,	false,		6,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  	   100,   	daLeft,  	true,    	"vndr_nm",					false,  	"",			dfNone,   		0,  	false,	false,		500,	false,		true,	   "",	  false	);	
	            
	            InitDataProperty(0, cnt++ , dtCombo,  		60,   	daCenter,  	true,    	"curr_cd",					false,  	"",			dfEngUpKey,   	0,  	false,	false,		3,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jan_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jan_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"feb_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"feb_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"mar_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"mar_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"apr_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"apr_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"may_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);	            
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"may_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);	            
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jun_estm_incnt_amt",		false, 		"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);	            
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jun_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jul_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"jul_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"aug_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"aug_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"sep_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"sep_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"oct_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"oct_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"nov_estm_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"nov_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"dec_estm_incnt_amt",		false, 		"",			dfNullFloat,   	2,  	true,	true,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"dec_rcv_incnt_amt",		false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		false,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"ttl_incnt_amt",		    false,  	"",			dfNullFloat,   	2,  	true,	true,		15,		false,		false,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"ttl_rcv_amt",		        false, 		"",			dfNullFloat,   	2,  	true,	true,		15,		false,		false,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"ttl_rmn_amt",		        false,  	"|ttl_incnt_amt|-|ttl_rcv_amt|",	dfNullFloat,   	2,  	false,	false,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"year_usd_estm_incnt_amt",	false,  	"|ttl_incnt_amt|/|usd_rt|",			dfNullFloat,   	2,  	false,	false,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"year_usd_rcv_incnt_amt",	false, 		"|ttl_rcv_amt|/|usd_rt|",			dfNullFloat,   	2,  	false,	false,		15,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  		80,   	daRight,  	true,    	"year_usd_bal_incnt_amt",	false,  	"|ttl_rmn_amt|/|usd_rt|",			dfNullFloat,   	2,  	false,	false,		15,		false,		true,	   "",	  false	);

	            InitDataProperty(0, cnt++ , dtData,  	   150,   	daLeft,  	true,    	"instr_rmk",				false,  	"",			dfNone,   		0,  	true,	true,		500,	false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtData,  	   150,   	daLeft,  	true,    	"stl_rmk",					false,  	"",			dfNone,   		0,  	true,	true,		1000,	false,		true,	   "",	  false	);

	            InitDataProperty(0, cnt++ , dtPopup,  	   150,   	daCenter,  	true,    	"atch_flg",					false,  	"",			dfNone,   		0,  	true,	true,		1,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daCenter,  	true,    	"atch_file_lnk_id",			false,  	"",			dfNone,   		0,  	true,	true,		10,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtPopup,  	   150,   	daCenter,  	true,    	"atch2_flg",				false,  	"",			dfNone,   		0,  	true,	true,		1,		false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daCenter,  	true,    	"atch_n2nd_file_lnk_id",	false,  	"",			dfNone,   		0,  	true,	true,		10,		false,		true,	   "",	  false	);

	            InitDataProperty(0, cnt++ , dtData,  	   300,   	daLeft,  	true,    	"incnt_rmk",				false,  	"",			dfNone,   		0,  	true,	true,		500,	false,		true,	   "",	  false	);
	            InitDataProperty(0, cnt++ , dtHidden,  		80,   	daRight,  	true,    	"usd_rt",					false,  	"",			dfNullFloat,   	2,  	false,	false,		15,		false,		true,	   "",	  false	);	            

	            
	            InitDataCombo(0, 'itm_cd', " |"+itm_cdText, " |"+itm_cdCode);
	            InitDataCombo(0, 'curr_cd'," |"+curr_cdText, " |"+curr_cdCode);
	            
				InitDataValid(0, "bse_yr", 		    vtNumericOnly);
	            InitDataValid(0, "rhq_cd", 			vtEngUpOnly);
	            InitDataValid(0, "ofc_cd", 			vtEngUpOnly);
	            InitDataValid(0, "port_cd", 		vtEngUpOnly);
				InitDataValid(0, "vndr_seq", 		vtNumericOnly);
			}
		break;
	}

}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, "SEARCH03");
			break;
			
			case "btn_save":
				doActionIBSheet(sheetObject1, formObject, MULTI03);
			break;
			
			case "btn_new":
				formObject.s_rhq_ofc_cd.code2 = "";
				formObject.s_inv_ofc_cd.code2 = "";
				formObject.s_bse_yr.value=formObject.hid_year.value;
				formObject.s_inv_vndr_seq.value="";
				formObject.s_inv_vndr_nm.value="";
				sheetObject1.RemoveAll();
			break;
			
			case "btn_downexcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
			
			case "btng_load_excel":
				sheetObject1.LoadExcel();
			break;
			
			case "btng_row_add":
				sheetObject1.DataInsert(-1);
				sheetObject1.CellEditable(sheetObject1.LastRow,"bse_yr") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"rhq_cd") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"ofc_cd") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"vndr_seq") 	= true;
				sheetObject1.CellEditable(sheetObject1.LastRow,"curr_cd") 	= true;
			break;	
			case "btng_del_row":
				doActionIBSheet(sheetObject1, formObject, REMOVE03);
			break;

			case "btns_calendar_s":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_fm_dt, 'yyyy-MM-dd');
   	        break;

            case "btns_calendar_e":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_to_dt, 'yyyy-MM-dd');
   	        break;

            case "btn_vndr_seq":
				rep_OnPopupClick();
			break;
		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}

}

	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		    case "SEARCH03": // VSL 운항
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST03;
				sheetObj.DoSearch4Post("ESD_EAS_0501GS.do", FormQueryString(formObj));
			break;
			
		    case MULTI03: //VSL Incentive Save
		    	if(validateForm(sheetObj, formObj, "MULTI03")){
					formObj.f_cmd.value = MULTI03;
					var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
			        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
			        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			        if (State != "S") {
			        	ComShowCodeMessage('COM12151',"Vessel Operation");
			        } else if (State == "S") {
			        	ComShowCodeMessage('COM12116',"Saving");
			        	doActionIBSheet(sheetObj, formObj, "SEARCH03");
			        }
		    	}
			break;
			
		    case REMOVE03: //VSL Incentive Delete
		    	if(validateForm(sheetObj, formObj, "REMOVE03")){
					if( !confirm(ComGetMsg("COM12171", "row"))) {
						return false;
					}
					var checkList = sheetObj.FindCheckedRow('chk');
					var checkArray = checkList.split('|');
					for(var k=checkArray.length-1; k>0; k--){
						if(sheetObj.cellvalue(checkArray[k-1],"incnt_no")==""){
							sheetObj.RowDelete(checkArray[k-1], false);
						}
					}
					var checkRow = sheetObj.FindCheckedRow('chk');
					if(checkRow!=""){
						formObj.f_cmd.value = REMOVE03;
						var sParam = sheetObj.GetSaveString(false, true,"chk") + "&" + FormQueryString(formObj);
				        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", sParam);
				        var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				        if (State != "S") {
				        	ComShowCodeMessage('COM12151',"Vessel Operation");
				        } else if (State == "S") {
				        	ComShowCodeMessage('COM12167',"Data");
				        	doActionIBSheet(sheetObj, formObj, "SEARCH03");
				        }
					}
		    	}
			break;
			case IBDOWNEXCEL:  // EXCEL
				sheetObj.Down2Excel(-1, false, false, true);;
			break;
			
			case "offce_level":
    			// RHQ 콤보 리스트 조회
				var usr_rhq_ofc_cd = formObj.usr_rhq_ofc_cd.value;
    			formObj.s_rhq_ofc_cd.RemoveAll();
    			formObj.f_cmd.value = COMMAND02;
    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
    			ComXml2ComboItem(sXml, formObj.s_rhq_ofc_cd, "ofc_cd", "ofc_cd");

    			formObj.s_rhq_ofc_cd.InsertItem(0, "", "");
    			
    			// 로그인한 RHQ OFFCD 셋팅
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		
        		formObj.s_rhq_ofc_cd.code2 = rhq_ofc_cd;
        		
	  		break; 	
		}
	}

  
  /**
   * Sheet3에서 OnChange 이벤트를 발생시킴.
   */
  function sheet1_OnChange (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  var ttl_qty = 0;
	  
	  //그리드 컬럼을 수정하면 chk컬럼 자동체크
//	  sheetObj.CellValue2(row,"chk") = "N";
	  var rowStatus =sheetObj.RowStatus(row);
	  if(rowStatus=="R"){
		   	sheetObj.CellValue2(row,"chk")= "N";
	   }else if(rowStatus=="I" || rowStatus=="U" ){
	   		sheetObj.CellValue2(row,"chk")= "Y";
	   }
	  
	  switch(colName){
 	      case('rhq_cd'):
 	    	  var rhq_ofc_cd = sheetObj.CellValue(row,"rhq_cd");
 	          checkRhqOfcCd(sheetObj,rhq_ofc_cd,row);
 		  break;
 		  case('ofc_cd'):
 			  var ofc_cd = sheetObj.CellValue(row,"ofc_cd");
 	 	      checkOfcCd(ofc_cd,row,0);
 	 	  break;
		  case('vndr_seq'):
			  var vndrSeq = sheetObj.CellValue(row,"vndr_seq");
		  	  if( vndrSeq != ""){
				  var sXml=sheetObj.GetSearchXml("ESD_EAS_0201GS.do","f_cmd="+SEARCH05+"&s_vndr_seq="+vndrSeq);
				  var vndrNm = EasXmlString(sXml,"vndr_nm");
					
				  if(vndrNm==0){
					 ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
					 sheetObj.CellValue(row,"vndr_seq")="";
					 sheetObj.CellValue(row,"vndr_nm") ="";
					return;
				  }
				  sheetObj.CellValue(row,"vndr_nm") = vndrNm;
		  		}else{
		  			sheetObj.CellValue(row,"vndr_nm") ="";
		  		}
		  break;
 	      case('port_cd'):
 	           var port_cd = sheetObj.CellValue(row,"port_cd");
 	      	   checkPortCd(port_cd,row,0);
 		  break;
		  case 'jan_estm_incnt_amt':	
		  case 'feb_estm_incnt_amt':	
		  case 'mar_estm_incnt_amt':
		  case 'apr_estm_incnt_amt':
		  case 'may_estm_incnt_amt':
		  case 'jun_estm_incnt_amt':
		  case 'jul_estm_incnt_amt':
		  case 'aug_estm_incnt_amt':
		  case 'sep_estm_incnt_amt':	
		  case 'oct_estm_incnt_amt':
		  case 'nov_estm_incnt_amt':
		  case 'dec_estm_incnt_amt':
	  		 sheetObj.CellValue(row,"ttl_incnt_amt") = Number(sheetObj.CellValue(row,'jan_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'feb_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'mar_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'apr_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'may_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'jun_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'jul_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'aug_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'sep_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'oct_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'nov_estm_incnt_amt'))
													 + Number(sheetObj.CellValue(row,'dec_estm_incnt_amt'))
													 ;
		  break;
	
		  case 'jan_rcv_incnt_amt':		
		  case 'feb_rcv_incnt_amt':		
		  case 'mar_rcv_incnt_amt':		
		  case 'apr_rcv_incnt_amt':		
		  case 'may_rcv_incnt_amt':		
		  case 'jun_rcv_incnt_amt':		
		  case 'jul_rcv_incnt_amt':		
		  case 'aug_rcv_incnt_amt':		
		  case 'sep_rcv_incnt_amt':		
		  case 'oct_rcv_incnt_amt':		
		  case 'nov_rcv_incnt_amt':		
		  case 'dec_rcv_incnt_amt':
		  		sheetObj.CellValue(row,"ttl_rcv_amt")  = Number(sheetObj.CellValue(row,"jan_rcv_incnt_amt"))
						   							   + Number(sheetObj.CellValue(row,'feb_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'mar_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'apr_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'may_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'jun_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'jul_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'aug_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'sep_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'oct_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'nov_rcv_incnt_amt'))
						   							   + Number(sheetObj.CellValue(row,'dec_rcv_incnt_amt'))
						   							  ; 
		  		
			break;	
	  }
  }
  /**
   * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
   */
  function sheet1_OnClick(sheetObj, Row, Col, Value) {
  	var formObj = document.form;
  	
      switch (sheetObj.ColSaveName(Col)) {
          case "stl_rmk":
        	  sheetObj.CellEditable(Row, Col) = false;
 			  ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 1000, true);
  			  sheetObj.CellEditable(Row, Col) = true;
          break;
          case "instr_rmk":
          case "incnt_rmk":
        	  sheetObj.CellEditable(Row, Col) = false;
 			  ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 500, true);
 			  sheetObj.CellEditable(Row, Col) = true;
          break;
      } 
  }
  
   /**
   * Sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  var formObj = document.form;
	  
	  switch(colName){
	  
	    case('vndr_seq'):
  	    	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, row , col,0);
	  	break;

	  	case('atch_flg'):

			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_file_lnk_id");
	  	    var bse_yr = sheetObj.cellvalue(row,"bse_yr");
	  	    var incnt_no = sheetObj.cellvalue(row,"incnt_no");
			var sParam = "cr_flg=Y&mdl_tp_cd=VSL&inv_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 
			
			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch_flg") = "Y";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = atch_file_lnk_id;		
			}else{	
				sheetObj.cellvalue(row,"atch_flg") = "N";
				sheetObj.cellvalue(row,"atch_file_lnk_id") = "";
			}
			formObj.f_cmd.value = MODIFY03;
			var updParam = "bse_yr="+bse_yr+"&incnt_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
	        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
	    break; 
	    
	  	case('atch2_flg'):

			var atch_file_lnk_id = sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id");
	  	    var bse_yr = sheetObj.cellvalue(row,"bse_yr");
	  	    var incnt_no = sheetObj.cellvalue(row,"incnt_no");
			var sParam = "cr_flg=Y&mdl_tp_cd=VSL&inv_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id;
	
			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = formObj.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 

			if(atch_file_lnk_id !=""){
				sheetObj.cellvalue(row,"atch2_flg") = "Y";
				sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id") = atch_file_lnk_id;		
			}else{	
				sheetObj.cellvalue(row,"atch2_flg") = "N";
				sheetObj.cellvalue(row,"atch_n2nd_file_lnk_id") = "";
			}
			formObj.f_cmd.value = MODIFY08;
			var updParam = "bse_yr="+bse_yr+"&incnt_no="+incnt_no+"&atch_file_lnk_id="+atch_file_lnk_id + "&" + FormQueryString(formObj);
	        var sXml = sheetObj.GetSaveXml("ESD_EAS_0501GS.do", updParam);
	    break;   
	  }
  }   
  
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
    var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('chk');
	var checkArray = checkList.split('|');
	
	if(sheetObj.RowCount < 1){
		ComShowCodeMessage('COM130401');
		return false;		
	}
	
	if(checkList == '') {
		ComShowCodeMessage('COM12176');
		return false;
	}

	switch(sAction){
		case('MULTI03'): // SAVE VESSEL OPERATION
			for(var i=0;i<checkArray.length-1;i++){
				if(sheetObj.cellvalue(checkArray[i],"bse_yr")==""){
					ComShowCodeMessage('COM130201',"YEAR");
					sheetObj.SelectCell(checkArray[i],"bse_yr");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"bse_yr").length!=4){
					ComShowCodeMessage('COM132201',"YEAR");
					sheetObj.SelectCell(checkArray[i],"bse_yr");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"rhq_cd")==""){
					ComShowCodeMessage('COM130201',"RHQ");
					sheetObj.SelectCell(checkArray[i],"rhq_cd");
					return false;					
				}else if(sheetObj.cellvalue(checkArray[i],"ofc_cd")==""){
					ComShowCodeMessage('COM130201',"OFC");
					sheetObj.SelectCell(checkArray[i],"ofc_cd");
					return false;
				}else if(sheetObj.cellvalue(checkArray[i],"vndr_seq")==""){
					ComShowCodeMessage('COM130201',"S/P Code");
					sheetObj.SelectCell(checkArray[i],"vndr_seq");
					return false;					
				}else if(sheetObj.cellvalue(checkArray[i],"curr_cd")==""){
					ComShowCodeMessage('COM130201',"Currency");
					sheetObj.SelectCell(checkArray[i],"curr_cd");
					return false;					
				}
			}
		break;
		
		case('REMOVE03'): // DELETE VESSEL OPERATION
		break;
	}
	return true;
}


///////////////////////////////////////////////////////////////////////////////
// 월 체크
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12  ) {
		return true;
	} else {
		return false;
	}
}

//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	        	ComKeyOnlyAlphabet('upper');
	        break;
	            
	        case "number":
	        	ComKeyOnlyNumber(obj);
	        break;
	    }
}
/**
* HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
* 예를 들어 다음과 같이 사용한다.<br>
*     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
* 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
* <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
* <br><b>Example :</b>
* <pre>
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
* </pre>
* @param {object} obj      필수,대상 HTML태그(Object)
* @param {string} sSubChar 선택,숫자이외의 부가 글자
* @returns 없음 <br>
* @see #ComKeyOnlyAlphabet
*/
function ComKeyOnlyNumberChk(obj,sSubChar){
   try {
       var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

       if(keyValue >= 48 && keyValue <= 57) {//숫자
           event.returnValue = true;

       } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
       	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
       	for(var i=0; i<sSubChar.length; i++) {
        		if (keyValue == sSubChar.charCodeAt(i)) {
	                event.returnValue = true;
	                return;
       		}
       	}
           event.returnValue = false;
       } else {
           event.returnValue = false;
       }
   } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * HTML Control의 onblur이벤트 처리<br>
 **/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name) {
		case "s_fm_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;
		case "s_prd_fm_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;	
		case "s_prd_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
		break;	

	}
}

/**
 * HTML Control의 onfocus이벤트 처리<br>
 **/
function obj_focus(){
	var obj = event.srcElement;
	switch(obj.name) {	
	case "s_fm_dt":
		ComClearSeparator(obj);
		obj.select();
	break;	
	case "s_to_dt":
		ComClearSeparator(obj);
		obj.select();
	break;

	}
}
/**
 * HTML Control의 onChange이벤트 처리<br>
 **/
function obj_change(){
	var obj = event.srcElement;
	switch(obj.name) {
		case "s_fm_dt":
		case "s_to_dt":
			if(!ComChkObjValid(obj)){
				obj.value = "";
				obj.focus();
			};
		break;
		
		case "s_inv_vndr_seq":
			vender_change();
		break;
	}
} 	

/**
* S/P Code 팝업호출
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
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* S/P Code 팝업 리턴값 세팅
*/
function getCOM_ENS_rep(rowArray) {
	 var formObj = document.form;	
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];
		formObj.s_inv_vndr_seq.value =colArray2;
		formObj.s_inv_vndr_nm.value =colArray4;
	}
}	

/**
* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
*/
function vender_change(){
	var formObj = document.form;
	if(formObj.s_inv_vndr_seq.value =="" ){
		formObj.s_inv_vndr_seq.value="";
		formObj.s_inv_vndr_nm.value="";
		return;
	}

	var sParam = Array();
	sParam[0] = "f_cmd="+ SEARCH05;
	sParam[1] = "s_vndr_seq="+ formObj.s_inv_vndr_seq.value;
	var sXml=sheetObjects[0].GetSearchXml("ESD_EAS_0201GS.do", sParam.join("&"));
	var vndrNm = EasXmlString(sXml,"vndr_nm");
	
	if(vndrNm==0){
		ComShowCodeMessage('COM132202', 'Inv. S/P'); //사용할수 없는 S/P Code 
		formObj.s_inv_vndr_seq.value="";
		formObj.s_inv_vndr_nm.value="";
		return;
	}
	formObj.s_inv_vndr_nm.value = vndrNm;
}


/**
 * RHQ Combo 변경시 Inv Office code 콤보 변경.
 * @param comboObj
 * @param Index_Code
 * @param Text
 */
function s_rhq_ofc_cd_OnChange(comboObj,Index_Code, Text){
	formObj = document.form;
	doActionIBCombo(formObj.s_rhq_ofc_cd); // RHQ
}	

//Combo관련 프로세스 처리
function doActionIBCombo(comboObj) {
	var sheetObj = sheetObjects[0];
	switch(comboObj.id) {
    	case "s_rhq_ofc_cd":  
	    	formObj.f_cmd.value = COMMAND03;
	        var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
	        formObj.s_inv_ofc_cd.RemoveAll();
	        ComXml2ComboItem(sXml, formObj.s_inv_ofc_cd, "ofc_cd", "ofc_cd");
	    	formObj.s_inv_ofc_cd.InsertItem(0, "", "");
	    	formObj.s_inv_ofc_cd.code2 = formObj.s_inv_ofc_cd.value
    	break;
	}
}

/**
 * 그리드 상의 RHQ Validation check
 * @param sheetObj
 * @param rhq_ofc_cd
 */
function checkRhqOfcCd(sheetObj,rhq_ofc_cd,row){
	if(rhq_ofc_cd !=""){
		sheetObj.DoRowSearch("ESD_EAS_0501GS.do","f_cmd="+SEARCH01+"&rhq_ofc_cd="+rhq_ofc_cd);
		var rtnVal = sheetObj.EtcData('rhq_ofc_cd');
		if(rtnVal !="" && rtnVal !=null && rtnVal != undefined){
			sheetObj.CellValue(row, "rhq_cd")  = sheetObj.EtcData('rhq_ofc_cd');
		}else{
			sheetObj.CellValue(row, "rhq_cd") = "";
		}
	}
}

/**
 * Grid에 입력된 Office Code에 대한 Validation
 * @param ofc_cd
 * @param row
 * @param sheetIdx
 */
function checkOfcCd(ofc_cd,row,sheetIdx){
	var sheetObj = sheetObjects[sheetIdx];
	if(ofc_cd !=""){
		sheetObj.DoRowSearch("ESD_EAS_0501GS.do","f_cmd="+SEARCH02+"&ofc_cd="+ofc_cd);
		
		var rtnVal = sheetObj.EtcData('ofc_cd');
		if(rtnVal !="" && rtnVal !=null && rtnVal != undefined){
			if(sheetIdx== "0" ||sheetIdx== "1"){
				sheetObj.CellValue(row, "inv_ofc_cd")  = sheetObj.EtcData('ofc_cd');
			}else if(sheetIdx== "2"){
				sheetObj.CellValue(row, "ofc_cd")  = sheetObj.EtcData('ofc_cd');
			}else if(sheetIdx== "3"){
				sheetObj.CellValue(row, "team_cd")  = sheetObj.EtcData('ofc_cd');	
			}
		}else{
			if(sheetIdx== "0" ||sheetIdx== "1"){
				sheetObj.CellValue(row, "inv_ofc_cd") = "";
			}else if(sheetIdx== "2"){
				sheetObj.CellValue(row, "ofc_cd") = "";
			}else if(sheetIdx== "3"){
				sheetObj.CellValue(row, "team_cd") = "";	
			}
		}
	}
}

/**
 * Grid에 입력된 Port Code Check
 * @param ofc_cd
 * @param row
 * @param sheetIdx
 */
function checkPortCd(port_cd,row,sheetIdx){
	var sheetObj = sheetObjects[sheetIdx];
	if(port_cd!=""){
		sheetObj.DoRowSearch("ESD_EAS_0501GS.do","f_cmd="+SEARCH03+"&port_cd="+port_cd);
		
		var rtnVal = sheetObj.EtcData('port_cd');
		if(rtnVal !="" && rtnVal !=null && rtnVal != undefined){
			sheetObj.CellValue(row, "port_cd")  = sheetObj.EtcData('port_cd');
		}else{
			sheetObj.CellValue(row, "port_cd") = "";
		}
	}
}


/**
* 콜백 함수. <br>
* @param  {Array} aryPopupData	필수	 Array Object
* @param  {Int} row				필수 선택한 Row
* @param  {Int} col				필수 선택한 Column
* @param  {Int} sheetIdx		필수 Sheet Index
* @return 없음
* @author 
* @version 2013.03.21
*/   
function callBackLocation(aryPopupData, row, col, sheetIdx){
   var sheetObj = sheetObjects[sheetIdx];
   var vndrSeq = "";
   var vndrNm = "";
   var i = 0;

   for(i = 0; i < aryPopupData.length; i++){
	   vndrSeq = vndrSeq + aryPopupData[i][2];
	   vndrNm = vndrNm + aryPopupData[i][4];
   }
   sheetObj.CellValue2(row, "vndr_seq") = vndrSeq;
   sheetObj.CellValue2(row, "vndr_nm") = vndrNm;
}
