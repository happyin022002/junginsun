/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0621.js
*@FileTitle : TRO Status List (USA)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2014.06.02 조인영
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
 * @class ESM_BKG_0621 : ESM_BKG_0621 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0621() {
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
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboCnt = 0;
var comboObjects = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];
     var sheetObject1 = sheetObjects[1];

     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
       
                case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
                case "btn_New":
                	 ComResetAll();
                	 sheetObjects[0].RemoveAll();
					 break;
                case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
 					break;
    			case 'btn_multi_ofc':
    				rep_Multiful_inquiry('Office Code');
    				break;
    			case 'btn_multi_por':
    				rep_Multiful_inquiry('POR');
    				break;
    			case 'btn_multi_pol':
    				rep_Multiful_inquiry('POL');
    				break;
    			case 'btn_multi_eq':
    				rep_Multiful_inquiry('EQ Office Code');
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

/**
 * IBSheet Object를 배열로 등록
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
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//MultiCombo초기화 
 	for(var k=0;k<comboObjects.length;k++){
 		initCombo(comboObjects[k],comboObjects[k].id);
 	}
	initControl();
    doActionIBSheet(sheetObjects[0],document.form,SEARCH01);

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
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerForm  ('beforedeactivate', 'getStaffList',  formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	ComSetObjValue(formObject.bkg_dt_fr,ComGetNowInfo());
	ComSetObjValue(formObject.bkg_dt_to,ComGetNowInfo());
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
    var formObject = document.form
}

  /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {

	case 1:     //sheet1 init
        with (sheetObj) {

        	// 높이 설정
			style.height = 300;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone] msPrevColumnMerge + msHeaderOnly;            
			MergeSheet = msAll; 
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = "| |BKG Info|BKG Info|BKG Info|BKG Info|BKG Info|BKG Info|BKG Info|BKG Info|BKG Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRO Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|TRS Info|Door Arrival Date|Door Arrival Date|Door Arrival Date|Service Provider|Service Provider|CNTR|CNTR";                                                                                                                                                                                                 
            var HeadTitle2 = "| |BKG No|Lane|T.VVD|POR|POL|TP/SZ|QTY|BKG OFC|EQ OFC|Seq|Sub seq|Door Loc|P/U CY|RTN CY|TP/SZ|QTY|TRO Date|P/U Req Date|Confirm|CNTR No|COP No|SO STS|SO No|SO Date|SO Staff|WO Staff|W/O|RMK|Door Type|SO OFC|TRO|W/O|SPP|Name|Contact|Loc|MVMT";                                                                                                                                                                                                                 
            var headCount = ComCountHeadTitle(HeadTitle1);
 
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);
 
            var rowIdx = 0;                                                                                                                                                                                                                                                                                                                      
            
            //데이터속성    [	ROW, 		COL,  DATATYPE,   				WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  				KEYFIELD, 		CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(rowIdx, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		    "ibflag");                                                                                                                                                                                               
			InitDataProperty(rowIdx, cnt++ , dtDataSeq,				30,		daCenter,	false,			"rnum");                       
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	false,			"bkg_no",				false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	false,			"slan_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"vvd_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"por_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"pol_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	false,			"bkg_tpsz",			false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	false,			"op_cntr_qty",				false,			"",      dfInteger,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"bkg_ofc_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"eq_ctrl_ofc_cd",				false,			"",      dfNone,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					30,		daCenter,	false,			"tro_seq",			false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtHidden,				50,		daCenter,	false,			"tro_sub_seq",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"dor_loc_cd",			false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"pkup_yd_cd",			false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"rtn_yd_cd",			false,			"",      dfNone,			0,		true,		true);                               
			InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	false,			"tro_tpsz",			false,			"",      dfNone,			0,		true,		true);                                       
			InitDataProperty(rowIdx, cnt++ , dtData,					40,		daCenter,	false,			"tro_qty",				false,			"",      dfInteger,			0,		true,		true);                       
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"tro_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"rqst_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"cfm_flg",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					95,		daCenter,	false,			"eq_no",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daCenter,	false,			"cop_no",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"so_sts",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					95,		daCenter,	false,			"so_no",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"so_cre_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,	false,				"so_cre_id",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,	false,				"wo_iss_id",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					95,		daCenter,	false,			"wo_no",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,		false,			"inter_rmk",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daLeft,		false,			"door_svc_tp",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"cre_ofc_cd",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"dor_arr_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"de_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					80,		daCenter,	false,			"apnt_dt",				false,			"",      dfDateYmd,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					150,	daLeft,		false,			"service_provider",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					100,	daLeft,		false,			"cntc_pson_nm",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					60,		daCenter,	false,			"loc_cd",				false,			"",      dfNone,			0,		true,		true);
			InitDataProperty(rowIdx, cnt++ , dtData,					50,		daCenter,	false,			"cnmv_sts_cd",				false,			"",      dfNone,			0,		true,		true);

			DataLinkMouse("bkg_no") = true;
			ColFontUnderline("bkg_no") = true;
    		
    		var color1 = RgbColor(129, 0, 129);
    		ColFontColor("bkg_no") = color1;
           }
            break;

        }
    }

// Sheet관련 프로세스 처리
var arrMultiCombo;//멀티콤보 세팅할 변수
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

      case IBSEARCH:      //조회
          if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = SEARCH;
			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0621_1GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0) 
				sheetObj.LoadSearchXml(arrXml[0]); 
          	  
          	ComEtcDataXmlToForm(sXml, formObj);
          }
          break;

      case IBDOWNEXCEL:      // 다운로드
			sheetObj.SpeedDown2Excel(-1);
			break;	
			
		case SEARCH01:      //조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0621GS.do", FormQueryString(formObj));
			arrMultiCombo = sXml.split("|$$|");	
			ComXml2ComboItem(arrMultiCombo[0], formObj.r_term,      "val", "val");
			ComXml2ComboItem(arrMultiCombo[1], formObj.d_term,      "val", "val");
			break;
    }
}

 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
 	var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
 	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	var srcValue = window.event.srcElement.getAttribute("value");
 	if (ComChkLen(srcValue, srcMaxLength) == "2") {
 		ComSetNextFocus();
 	}
 }
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
     	switch(sAction) {
			case IBSEARCH: // 조회시 확인
         		if (!ComChkValid(formObj)) return false;
         		if (ComIsNull(formObj.bkg_no) && ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.bkg_dt_fr) || ComIsNull(formObj.bkg_dt_to)) && (ComIsNull(formObj.tro_dt_fr) || ComIsNull(formObj.tro_dt_to)) && (ComIsNull(formObj.pup_dt_fr) || ComIsNull(formObj.pup_dt_to))){
					ComShowCodeMessage('BKG00626', 'BKG Date or TRO Date or P/Up Req Date or VVD or BKG No.');

					return false;
				}
         		
         		if (!ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to) && ComGetDaysBetween(formObj.bkg_dt_fr.value, formObj.bkg_dt_to.value) > 31){
           		 
         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
         			formObj.bkg_dt_fr.focus();
         			return false;
         		}
         		
         		if (!ComIsNull(formObj.tro_dt_fr) && !ComIsNull(formObj.tro_dt_to) && ComGetDaysBetween(formObj.tro_dt_fr.value, formObj.tro_dt_to.value) > 31){
	           		 
         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
         			formObj.tro_dt_fr.focus();
         			return false;
         		}
         		
         		if (!ComIsNull(formObj.pup_dt_fr) && !ComIsNull(formObj.pup_dt_to) && ComGetDaysBetween(formObj.pup_dt_fr.value, formObj.pup_dt_to.value) > 31){
	           		 
         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
         			formObj.pup_dt_fr.focus();
         			return false;
         		}
         
         		break;
     	}	
     }
     return true;
}

/**
 * ETD,ETB 기간 선택 달력 띄우기
 */
function callDatePop(val){
	var cal = new ComCalendarFromTo();
	if (val == 'BKG_DATE'){
		cal.select(form.bkg_dt_fr,  form.bkg_dt_to,  'yyyy-MM-dd');
	}
	if (val == 'TRO_DATE'){
		cal.select(form.tro_dt_fr,  form.tro_dt_to,  'yyyy-MM-dd');
	}
	if (val == 'PUP_DATE'){
		cal.select(form.pup_dt_fr,  form.pup_dt_to,  'yyyy-MM-dd');
	}
	
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//comBkgIndicateLink(sheetObj,"bkg_no"); 
}
function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	var colName = sheetObj.ColSaveName(colIdx);
//    		if (colName == "bkg_no"){
//    			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
//     		}
}

/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(val)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title = val;
		
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	if(returnval=="Office Code") {
		var x2=formObject.bkg_ofc_cd.value;
		if(x2==""){
			formObject.bkg_ofc_cd.value = rowArray;
			formObject.bkg_ofc_cd.focus();
		}else{
			formObject.bkg_ofc_cd.value = formObject.bkg_ofc_cd.value+","+rowArray;
			formObject.bkg_ofc_cd.focus();
		}
	}else if(returnval=="POR") {
		var x2=formObject.por_cd.value;
		if(x2==""){
			formObject.por_cd.value = rowArray;
			formObject.por_cd.focus();
		}else{
			formObject.por_cd.value = formObject.por_cd.value+","+rowArray;
			formObject.por_cd.focus();
		}
	}else if(returnval=="POL") {
		var x2=formObject.pol_cd.value;
		if(x2==""){
			formObject.pol_cd.value = rowArray;
			formObject.pol_cd.focus();
		}else{
			formObject.pol_cd.value = formObject.pol_cd.value+","+rowArray;
			formObject.pol_cd.focus();
		}
	}else if(returnval=="EQ Office Code") {
		var x2=formObject.eq_ctrl_ofc_cd.value;
		if(x2==""){
			formObject.eq_ctrl_ofc_cd.value = rowArray;
			formObject.eq_ctrl_ofc_cd.focus();
		}else{
			formObject.eq_ctrl_ofc_cd.value = formObject.eq_ctrl_ofc_cd.value+","+rowArray;
			formObject.eq_ctrl_ofc_cd.focus();
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	comBkgIndicateLink(sheetObj,"bkg_no"); 
}
function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
	var colName = sheetObj.ColSaveName(colIdx);
	if (colName == "bkg_no"){
		comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
	}
}
 
/* 개발자 작업  끝 */