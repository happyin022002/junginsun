/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0273.js
*@FileTitle : Full CNTR Release Order History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.20 손윤석
* 1.0 Creation
=========================================================*/ 
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

var searchStatus = '';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function processButtonClick()
{
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	//var sheetObject1 = sheetObjects[1];
	/*******************************************************/
	var formObj = document.form;

	try 
	{
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) 
        {
        case "btn_Retrieve":
        	doActionIBSheet(sheetObject,formObj,IBSEARCH);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;
		case "rad_rlse_dt":
			funcChangeOption(formObj, "Released Date");
			formObj.in_cre_dt_from.focus();
			break;
		case "rad_vvd":
			funcChangeOption(formObj, "VVD");
			formObj.in_vvd.focus();
			break;
		case "rad_bl":
			funcChangeOption(formObj, "BL");
			formObj.in_bl_no.focus();
			break;
		case "btn_dtt":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.in_cre_dt_from, formObj.in_cre_dt_to,'yyyy-MM-dd');
			break;
		case "btn_Print":
			if(!funcCheckRowValid(sheetObject)) return;
			sheetObject.Down2Print(true, poLandscape , "Full Container Release History", 1.5, 1.5);
			break;
		case "btn_Close":
			window.close();
			break;
        } // end switch
	}
	catch(e) 
	{
		if( e == "[object Error]") 
		{
			ComShowMessage(OBJECT_ERROR);
		} 
		else 
		{
			ComShowMessage(e);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @param {String} CondParam 필수, 서버전송 정보
 * @param {int} PageNo 선택, 페이지 번호
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction)
{
	switch(sAction)
	{
		case IBSEARCH:
			//if (!ComChkObjValid(formObj.ofc_cd)) return false;
			
			
			if(formObj.f_rad.value == 'Released Date')
	    	{
				var from_dt = formObj.in_cre_dt_from.value;
				var to_dt = formObj.in_cre_dt_to.value;				
				
				
				if(from_dt == '' || to_dt == '')
				{
					if(!ComIsDate(from_dt)) 
					{
						ComShowCodeMessage("COM12134", "Released Date");
						formObj.in_cre_dt_from.focus();
						return false;
					}
					
					if(!ComIsDate(to_dt)) 
					{
						ComShowCodeMessage("COM12134", "Released Date");
						formObj.in_cre_dt_to.focus();
						return false;
					}
					
				}	
				
				
				if(!ComBkgMonthsBetweenCheck(from_dt,to_dt, "1")){
				      ComShowCodeMessage("BKG08257", "1");
                      ComSetFocus(formObj.in_cre_dt_to.value);
                      return false;
                }
				  
	    	}	
			else if(formObj.f_rad.value == 'VVD')
	    	{
				if(!ComChkObjValid(formObj.in_vvd)) return false;
				if(!ComChkObjValid(formObj.in_pod_cd)) return false;
	    	}
	    	else
	    	{
	    		if(!ComChkObjValid(formObj.in_bl_no)) 
	    		{
	    			//funcChangeOption(formObj, "BL");
	    			formObj.in_bl_no.focus();
	    			return false;
	    		}
	    	}
			
		
		break;
	}

    return true;
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}



/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function loadPage() 
{
	for(i=0;i<sheetObjects.length;i++)
	{
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var formObj = document.form;
	
	if(formObj.f_mod.value == 'POPUP')
	{
		funcChangeOption(formObj, "BL");
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
	else
	{
		var now   = new Date();
	    var year  = now.getFullYear();
	    var month = now.getMonth() + 1;	// 1월=0,12월=11이므로 1더함
	    var day   = now.getDate();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    var dateval = '' + year + '-' + month + '-' + day;
	    formObj.in_cre_dt_from.value = dateval;
	    formObj.in_cre_dt_to.value = dateval;
	    formObj.in_cre_dt_from.focus();
	    funcChangeOption(formObj, "Released Date");
	}

	initControl();
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function initControl() 
{
	var formObject = document.form;
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject); //- 키보드 입력할때
    axon_event.addListenerFormat('keyup',            'keyupcheck',      formObject);
    axon_event.addListener      ('keydown',          'ComKeyEnter',         'form');
}

/**
* 화면에서 폼객체가 선택되었을 경우에 발생하는 이벤트를 처리
* @param {void}
* @return void
* @author Son Yunseok
* @version 2009.10.01
*/
function obj_activate()
{
	var form = document.form;
	var srcName = event.srcElement.getAttribute("name");
	
	switch(srcName)
    {
    case 'in_cre_dt_from':
    	funcChangeOption(form, "Released Date");
    	break;
    case 'in_cre_dt_to':
    	funcChangeOption(form, "Released Date");
    	break;
    case 'in_vvd':
    	funcChangeOption(form, "VVD");
    	break;
    case 'in_pod_cd':
    	funcChangeOption(form, "VVD");
    	break;
    case 'in_bl_no':
    	funcChangeOption(form, "BL");
    	break;
    }
}

/**
 * Key Up Event받아서 자리수만큼 입력다됬을 경우 다음 객체로 포커스 이동
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function keyupcheck()
{
	var form = document.form;
	var key = event.keyCode;
	var srcValue = event.srcElement.getAttribute("value");
	var dtaLength = event.srcElement.getAttribute("maxlength");
	var srcLength = srcValue.length; 
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName = event.srcElement.getAttribute("name");
    
    if(srcLength < dtaLength) return;
    
    switch(srcName)
    {
    case 'in_cre_dt_from':
    	form.in_cre_dt_to.focus();
    	break;
    case 'in_cre_dt_to':
    //	funcChangeOption(form, "VVD");
        form.in_cntr_no.focus();
    	break;
    case 'in_vvd':
    	form.in_pod_cd.focus();
    	break;
    case 'in_pod_cd':
    	form.in_cntr_no.focus();
    	break;
    case 'in_bl_no':
    	form.in_cntr_no.focus();
    	break;
    case 'in_cntr_no':
    	form.in_yd_cd.focus();
    	break;
    }
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo Sheet Index 번호
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) 
{
    var cnt = 0;
    switch(sheetNo) 
    {
        case 1:      //sheet1 init
        with (sheetObj) 
        {
        	// 높이 설정
            style.height = 420;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(35, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            var HeadTitle1 = "|Seq.|B/L No.|BKG No.|Container|TP/SZ|Consignee|Yard|E-Mail|T/VVD|POL|POD|D/O No|PIN Code|Badge Code|Released Date|Relase Expiry Date|Trucker Code/Name|Vechicle Registration|R.H.I.D.S Code|UVI No.|D/O Issue Date|T-Mode|ATP No.|F/Forwarder|Party to invoice|MT return yard|P/Up DT|Release Notes|Del.Term|Remark(s)|Office|Sent By|Sent at|M";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"seq");
			InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"bl_no",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"bkg_no",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"cntr_no",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"cntr_tp_sz_cd",false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			200,daLeft,		true,	"cust_nm",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"yd_cd",		false,	"",  dfNone,0,	false,	false);
            InitDataProperty(0, cnt++ , dtData,         200,daCenter,   true,   "rlse_ntc_eml", false,  "",  dfNone,0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"vvd",			false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"pol_cd",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"pod_cd",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"do_no",		false,	"",  dfNone,0,	false,	false);
            InitDataProperty(0, cnt++ , dtData,         70, daCenter,   true,   "pin_no",		false,  "",  dfNone,0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,         80, daCenter,   true,   "co_bdg_id",    false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         120,daCenter,   true,   "rlse_dt",  	false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         120,daCenter,   true,   "rlse_exp_dt",  false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         130,daCenter,   true,   "cgo_crr_id",   false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         150,daCenter,   true,   "veh_rgst_id",  false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         100,daCenter,   true,   "road_hlg_id",  false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         70, daCenter,   true,   "uq_vsl_id_no", false,  "",  dfNone,0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"do_iss_dt",	false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"trsp_mod",		false,	"",  dfNone,0,	false,	false);
            InitDataProperty(0, cnt++ , dtData,         150,daCenter,   true,   "cstms_voy_no", false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         150,daCenter,   true,   "frt_fwrd_cd",  false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         150,daCenter,   true,   "pty_to_inv_cd",false,  "",  dfNone,0,  false,  false);
            InitDataProperty(0, cnt++ , dtData,         150,daCenter,   true,   "mt_ret_cy_cd", false,  "",  dfNone,0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"pkup_dt",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"cxl_flg",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"de_term_cd",	false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			250,daCenter,	true,	"rmk",			false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"ofc_cd",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			150,daLeft,		true,	"usr_nm",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"rlse_dt",		false,	"",  dfNone,0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			20,	daCenter,	true,	"mzd",			false,	"",  dfNone,0,	false,	false);
			Ellipsis = true;
        }
        //sheetObj.ExtendLastCol = false;
        break;
    }
}

/**
 * Sheet관련 프로세스 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction) 
{
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) 
    {
    case IBSEARCH:      //조회
    	formObj.f_cmd.value = SEARCH;
    	if(validateForm(sheetObj,formObj,sAction))	
    	{
    		sheetObj.DoSearch("ESM_BKG_0273GS.do", FormQueryString(formObj));
    		searchStatus = sheetObj.EtcData('status');
    	}
    	//sheetObj.ExtendLastCol = false;
//    	for(var i=0;i<sheetObj.Rows;i++)
//    	{
//    		sheetObj.RowHeight(i) = 11;
//    	}
    	break;
	case IBDOWNEXCEL:   //엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
    }
}

/**
 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event처리 <br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} ErrMsg 필수, 메시지 문자열
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		for(var i = 1; i <= LastRow; i ++)
		{
			
			if(CellValue(i,"cxl_flg")=="U"){
				CellValue2(i,"cxl_flg") = "Update";
			}else if (CellValue(i,"cxl_flg")=="Y"){
				CellValue2(i,"cxl_flg") = "Cancel";
			}else if (CellValue(i,"cxl_flg")=="N"){
				CellValue2(i,"cxl_flg") = "None";
			}
			
			
			switch(CellValue(i, "MDST"))
			{
			case "M":
				RowMerge(i) = true;
				CellAlign(i, "Check") = daLeft;
				break;
			case "D":
				InitCellProperty(i, "Check", dtCheckBox);
				break;
			}
		}
	}
}

/**
 * Option이 변경될 경우 화면 처리
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} formObj 필수, 폼객체
 * @param {String} mode 필수, 검색 옵션
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcChangeOption(formObj, mode)
{
	if(mode == "Released Date")
	{
			formObj.rad_vvd.checked = false;
			formObj.rad_bl.checked = false;
			formObj.rad_rlse_dt.checked = true;
			formObj.in_cre_dt_from.className = "input1";
			formObj.in_cre_dt_to.className = "input1";
			formObj.in_vvd.className = "input";
			formObj.in_pod_cd.className = "input";
			formObj.in_bl_no.className = "input";
			formObj.f_rad.value = "Released Date";
	}
	else if(mode == "BL")
	{
		formObj.rad_vvd.checked = false;
		formObj.rad_bl.checked = true;
		formObj.rad_rlse_dt.checked = false;
		formObj.in_cre_dt_from.className = "input";
		formObj.in_cre_dt_to.className = "input";
		formObj.in_vvd.className = "input";
		formObj.in_pod_cd.className = "input";
		formObj.in_bl_no.className = "input1";
		formObj.f_rad.value = "BL";
	}
	else
	{
		formObj.rad_vvd.checked = true;
		formObj.rad_bl.checked = false;
		formObj.rad_rlse_dt.checked = false;
		formObj.in_cre_dt_from.className = "input";
		formObj.in_cre_dt_to.className = "input";
		formObj.in_vvd.className = "input1";
		formObj.in_pod_cd.className = "input1";
		formObj.in_bl_no.className = "input";
		formObj.f_rad.value = "VVD";
	}
}

/**
 * Sheet가 정상적인 데이터를 가진 상태인지 검사한다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} formObj 필수, 폼객체
 * @return boolean
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcCheckRowValid(sheetObj)
{
	if(searchStatus != 'ok')
	{
		ComShowCodeMessage("BKG00155");
		return false;
	}
	return true;
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function obj_keypress()
{
	var form = document.form;
	var key = event.keyCode;
	var srcValue = event.srcElement.getAttribute("value");
	var maxLength = event.srcElement.getAttribute("maxlength");
	var srcLength = srcValue.length; 
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName = event.srcElement.getAttribute("name");
    
    switch(event.srcElement.dataformat)
    {
        case "float":
            //숫자+"."입력하기
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
            //ComKeyOnlyAlphabet();
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        case "date":
        	ComKeyOnlyNumber(event.srcElement, "-");
        	break;
        case "ymd":
            ComKeyOnlyNumber(event.srcElement);
            if (srcValue.length == 4) {
              document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
            }
            if (srcValue.length == 7) {
              document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
            }
            break;
        default:	
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}

/**
 * 날자형식이 올바르게 설정되었는지 검사한다.<br>
 * @param {String} val 필수, 문자형 날자
 * @return boolean
 * @author Son Yunseok
 * @version 2009.10.01
 */
function funcValidDateData(val)
{
	var temp = '';
	if(val.length != 10) return false;

	temp = val.substring(0, 4);
	if(isNaN(temp)) return false;
	
	temp = val.substring(4,5);
	if(temp != '-') return false;
	
	temp = val.substring(5,7);
	if(isNaN(temp)) return false;
	
	temp = val.substring(7,8);
	if(temp != '-') return false;
	
	temp = val.substring(8);
	if(isNaN(temp)) return false;
	
	return true;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
//function funcWidthPlus(sheetObj, idx)
//{
//	//mySheet.ColWidth(Col)
//	var width = sheetObj.ColWidth(idx);
//	sheetObj.ColWidth(idx) = width + 10;
//	document.form.in_vvd.value = sheetObj.ColWidth(idx); 
//}
//function funcWidthMinus(sheetObj, idx)
//{
//	var width = sheetObj.ColWidth(idx);
//	sheetObj.ColWidth(idx) = width - 10;
//	document.form.in_vvd.value = sheetObj.ColWidth(idx);	
//}