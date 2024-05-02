/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0502.js
*@FileTitle : Credit & Incentive Summary
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
 * @class ESD_EAS_0502
 */
function ESD_EAS_0502() {
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

var tabObjects = new Array();
var tabCnt = 0 ;

var beforetab = 1;
var Mincount = 0;

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++, "Terminal/Transportation/Vessel Operation" , -1 );
				InsertTab( cnt++, "Refrigerator Parts Credit/Welfare Card Mileage" , -1 );
			}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
	
	if( tabObjects[0].SelectedIndex == "0" ) {
	    document.all.div_year.style.display = "inline";
		document.all.div_period.style.display = "none";
	}else{
	    document.all.div_year.style.display = "none";
		document.all.div_period.style.display = "inline";
	}
}

/**
 * Summary Division Code Change Event
 */
function chgSmmrDivCd(val){
	if( val == "R" ) {
	    document.all.div_rhq.style.display = "inline";
		document.all.div_src.style.display = "none";
	}else{
	    document.all.div_rhq.style.display = "none";
		document.all.div_src.style.display = "inline";
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

	var formObj = document.form;

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
    }

	// IBMultiCombo 설정
	for(var k = 0; k < comboObjects.length; k++){
		initCombo(comboObjects[k], k + 1);
		comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
	}
	initControl()
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
	axon_event.addListenerFormat( 'keypress' ,'obj_keypress'  ,document.form); //- 키보드 입력할때
	}
	

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1
			with (sheetObj) {
			
                //style.height = GetSheetHeight(8); // 높이 설정
                style.height = 410;
                SheetWidth = mainTable.clientWidth; //전체 너비 설정
                sheetObj.AutoSizeMode = true;
                //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;     
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 9, 100);
	
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(8, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "RHQ|OFFICE|Credit Source|Estimated AMT(USD)|Received AMT(USD)|Balance(USD)|";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
	
                //데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,		  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtData,   		140,   	daCenter,  	true,    "rhq_cd",			false,  "",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	); 
                InitDataProperty(0, cnt++, dtData,   		140,   	daCenter,  	true,    "ofc_cd",			false,  "",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	); 
				InitDataProperty(0, cnt++, dtData,  		170,   	daLeft,    	true,    "cr_src",			false,  "",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	); 
                InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   	false,   "estm_amt",   		false,  "",			dfNullFloat,   	2,  false,	false,		100,	false,		true,	   "",	  false	); 
				InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   	false,   "rcv_amt",			false,  "",			dfNullFloat,   	2,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   	false,   "bal_amt",			false,  "",			dfNullFloat,   	2,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtHidden,  		80,   	daRight,   	false,   "order_seq",		false,  "",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtHiddenStatus,  0,  	daCenter,  	false,   "ibflag");

	
				ColHidden('ibflag')				= true;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				//style.height = GetSheetHeight(8); // 높이 설정
				style.height = 410;
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				//SheetWidth = mainTable2.clientWidth;
				 sheetObj.AutoSizeMode = true;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle1 = "Credit Source|RHQ|OFFICE|Estimated AMT(USD)|Received AMT(USD)|Balance(USD)|";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   		140,   	daCenter,  true,    "cr_src",	false,  	"",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	);
				InitDataProperty(0, cnt++, dtData,   		140,   	daCenter,  true,    "rhq_cd",	false,  	"",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtData,   		170,   	daCenter,  true,    "ofc_cd",	false,  	"",			dfNone,   		0,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   false,   "estm_amt", false,  	"",			dfNullFloat,	2,  false,	false,		100,	false,		true,	   "",	  false	);
				InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   false,   "rcv_amt",	false,  	"",			dfNullFloat,	2,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtData,  		170,   	daRight,   false,   "bal_amt",	false,  	"",			dfNullFloat,   	2,  false,	false,		100,	false,		true,	   "",	  false	);
                InitDataProperty(0, cnt++, dtHiddenStatus,  0,   	daCenter,  false,   "ibflag");

			}
			break;
			
		case 3:      //sheet3 init
		with (sheetObj) {
			//style.height = GetSheetHeight(8); // 높이 설정
            style.height = 410;
            SheetWidth = mainTable.clientWidth; //전체 너비 설정
            //SheetWidth = mainTable1.clientWidth;
            sheetObj.AutoSizeMode = true;
            //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;     

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(9, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

			var HeadTitle1 = "Credit Source|TEAM|Year|Service Provider|Service Provider|Issued AMT(USD)|Collected (Used)AMT(USD)|Balance(USD)";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData,   		100,   	daLeft,    true,    "cr_src",		false,  	"",			dfNone,   		0,  	false,		false,		100,	false,		true,	   "",	  false	);
			InitDataProperty(0, cnt++, dtData,   		100,   	daCenter,  true,    "team_cd",		false,  	"",			dfNone,   		0,  	false,		false,		100,	false,		true,	   "",	  false	);
			InitDataProperty(0, cnt++, dtData,   		100,   	daCenter,  true,    "bse_yr",		false,  	"",			dfNone,   		0,  	false,		false,		100,	false,		true,	   "",	  false	);			
            InitDataProperty(0, cnt++, dtHidden,   		50,   	daCenter,  true,    "vndr_seq",		false,  	"",			dfNone,   		0,  	false,		false,		100,	false,		true,	   "",	  false	);
            InitDataProperty(0, cnt++, dtData,  		160,   	daLeft,    true,    "vndr_nm",		false,  	"",			dfNone,   		0,  	false,		false,		100,	false,		true,	   "",	  false	);
            InitDataProperty(0, cnt++, dtData,  		160,   	daRight,   true,    "iss_amt",   	false,  	"",			dfNullFloat,   	2,  	false,		false,		100,	false,		true,	   "",	  false	);
			InitDataProperty(0, cnt++, dtData,  		160,   	daRight,   true,    "used_amt",		false,  	"",			dfNullFloat,   	2,  	false,		false,		100,	false,		true,	   "",	  false	);
            InitDataProperty(0, cnt++, dtData,  		160,   	daRight,   true,    "bal_amt",		false,  	"",			dfNullFloat,   	2,  	false,		false,		100,	false,		true,	   "",	  false	);
            InitDataProperty(0, cnt++, dtHiddenStatus,  0,   	daCenter,  false,   "ibflag" ); 
		}
		break;
	}

}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){


/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];

	var formObject = document.form;

	/*******************************************************/	

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				if(tabObjects[0].SelectedIndex == "0") {
					doActionIBSheet(sheetObject1, formObject, "SEARCH01");
					doActionIBSheet(sheetObject2, formObject, "SEARCH02");
				}else if (tabObjects[0].SelectedIndex == "1"){
					doActionIBSheet(sheetObject3, formObject, "SEARCH03");
				}
			break;
					
			case "btn_downexcel":
				if (tabObjects[0].SelectedIndex == '0') {
					if(formObject.s_smmr_div_cd.value=="R"){
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else if(formObject.s_smmr_div_cd.value=="C"){
						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					}
				} else {
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
				}
			break;
			case "btns_calendar_s":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_fm_dt, 'yyyy-MM-dd');
   	        break;

            case "btns_calendar_e":
   	         	var cal = new ComCalendar();
   	         	cal.select(formObject.s_to_dt, 'yyyy-MM-dd');
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
		    case "SEARCH01":
		    	sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESD_EAS_0502GS.do", FormQueryString(formObj));
			break;
			
		    case "SEARCH02":
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST02;
				sheetObj.DoSearch4Post("ESD_EAS_0502GS.do", FormQueryString(formObj));
			break;
			
		    case "SEARCH03":
	    		sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCHLIST03;
				sheetObj.DoSearch4Post("ESD_EAS_0502GS.do", FormQueryString(formObj));
			break;
				
			case IBDOWNEXCEL:  // EXCEL
				sheetObj.Down2Excel(-1, false, false, true);
			break;
			
			case "offce_level":
    			// RHQ 콤보 리스트 조회
				var usr_rhq_ofc_cd = formObj.usr_rhq_ofc_cd.value;
    			formObj.s_rhq_cd.RemoveAll();
    			formObj.f_cmd.value = COMMAND02;
    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
    			ComXml2ComboItem(sXml, formObj.s_rhq_cd, "ofc_cd", "ofc_cd");

    			formObj.s_rhq_cd.InsertItem(0, "", "");
    			
    			// 로그인한 RHQ OFFCD 셋팅
				formObj.f_cmd.value = COMMAND01;
        		var sXml = sheetObj.GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(formObj));
        		var rhq_ofc_cd = EasXmlString(sXml,"rhq_ofc_cd");
        		
        		formObj.s_rhq_cd.code2 = rhq_ofc_cd;
        		
	  		break; 	
		}
	}
	/**
	 * sheet1 Search End Event
	 * TES, TRS, VSL  RHQ 기준 소계
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		
  		for (var i = sheetObj.HeaderRows ; i< sheetObj.RowCount + sheetObj.HeaderRows ; i++) {
  			if (sheetObj.CellValue(i, "order_seq") == "2") {
  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(244,244,186);
  			}else if (sheetObj.CellValue(i, "order_seq") == "3") {
  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(226,245,240);
  			}else if (sheetObj.CellValue(i, "order_seq") == "4") {
  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(232,255,198);	
  				sheetObj.CellValue(i,"rhq_cd") = "Grand Total";
  			}
  		}

	}

	/**
	 * sheet2 Search End Event
	 * TES, TRS, VSL Source 기준 소계
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.SubSumBackColor = sheetObj.RgbColor(232,255,198);
		sheetObj.ShowSubSum("ibflag","estm_amt|rcv_amt|bal_amt",-1,true,false,0,"0=Grand Total");
		sheetObj.SubSumBackColor = sheetObj.RgbColor(247,231,236);
		sheetObj.ShowSubSum("cr_src","estm_amt|rcv_amt|bal_amt",-1,true,false,1,"0=%s;1=Sub Total");
	}
	/**
	 * sheet3 Search End Event
	 * M&R, Mileage 소계
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.SubSumBackColor = sheetObj.RgbColor(232,255,198);
		sheetObj.ShowSubSum("ibflag","iss_amt|used_amt|bal_amt",-1,true,false,0,"0=Grand Total");
		sheetObj.SubSumBackColor = sheetObj.RgbColor(247,231,236);
		sheetObj.ShowSubSum("cr_src","iss_amt|used_amt|bal_amt",-1,true,false,1,"0=%s;1=Sub Total");		
	}




/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){

    var formObject = document.form;	

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
	}
} 	