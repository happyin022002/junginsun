/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1021.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.13 손윤석
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
var isSaveable = false;
var isDeleteable = false;
document.onclick = processButtonClick;

//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick()
{
	var sheetObject1 = sheetObjects[0];
    var formObj = document.form;

	try
	{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName)
		{
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObj,IBSEARCH);
				break;

			case "btn_Save":
				doActionIBSheet(sheetObject1,formObj,MULTI);
				break;

			case "btn_Delete":
				doActionIBSheet(sheetObject1,formObj,REMOVE);
				break;
		}
	}
	catch(e)
	{
		if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
		else ComShowMessage(e);
	}
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage()
{
	ComBtnSetInquiry();

    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'obj_keydown1', 'ofc_cd');
    axon_event.addListener('keydown', 'obj_keydown2', 'bank_in_acct_ctnt');

    if (document.form.ofc_cd.value != "") {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction)
{
	var len = formObj.ofc_cd.value.length;

    switch(sAction)
    {
    case MULTI:

    	if(!isSaveable)
    	{
    		ComShowCodeMessage("BKG00448");
    		return false;
    	}

    	if (!ComChkValid(formObj)) return false;

    	if(formObj.old_ofc_cd.value != formObj.ofc_cd.value)
    	{
    		ComShowCodeMessage("BKG00448");
    		return false;
    	}

    	break;


    case REMOVE:
    	if(!isDeleteable)
    	{
    		ComShowCodeMessage("BKG03054");
    		return false;
    	}

    	if (!ComChkValid(formObj)) return false;

    	if(formObj.old_ofc_cd.value != formObj.ofc_cd.value)
    	{
    		ComShowCodeMessage("BKG00448");
    		return false;
    	}
    	isSaveable = false;

    	break;


    case IBSEARCH:
    	isSaveable = true;

    	if (!ComChkValid(formObj)) return false;

    	break;
    }
    return true;
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo)
{
	var cnt = 0;
	switch(sheetNo)
	{
		case 1:      //sheet1 init
			with (sheetObj)
			{
				//높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				var HeadTitle = "|||||||";
				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,	30,	    daCenter,	false, "ibflag");
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "an_tp_cd",                 false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "ofc_cd",                   false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "pod_cd",                   false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "chn_agn_cd",               false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "bank_in_acct_ctnt",        false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "drft_bl_bank_acct_dp_flg", false, "",	dfNone, 0, true, true);
				InitDataProperty(0, cnt++ , dtData,     60,  	daCenter,	false, "upd_usr_id",               false, "",	dfNone, 0, true, true);

				CountPosition = 0;
			}

		break;
	}
}

function initForm() {
	var formObj = document.form;

	formObj.bank_in_acct_ctnt.value        = "";
	formObj.dp_flg.checked                 = false;
	formObj.drft_bl_bank_acct_dp_flg.value = "";
	upd_usr_id.innerHTML                   = "";
}


//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction)
{
    //sheetObj.ShowDebugMsg = false;
    var status = '';
    switch(sAction)
    {
  //조회
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH;
		if(!validateForm(sheetObj,formObj,sAction)) return;

		formObj.old_ofc_cd.value = formObj.ofc_cd.value;
		sheetObj.DoSearch("ESM_BKG_1021GS.do", FormQueryString(formObj));

		status = sheetObj.EtcData('status');
		if(status == 'no_data')
		{
			initForm();

			ComShowCodeMessage("BKG00095");
			isDeleteable = false;

			break;
		}

		isDeleteable = true;

		formObj.bank_in_acct_ctnt.value = sheetObj.CellValue(1, 'bank_in_acct_ctnt');

		if (sheetObj.CellValue(1, 'drft_bl_bank_acct_dp_flg') == "Y")
			formObj.dp_flg.checked = true;
		else formObj.dp_flg.checked = false;

		upd_usr_id.innerHTML = sheetObj.CellValue(1, "upd_usr_id");

		break;



	case REMOVE:
		if(!validateForm(sheetObj,formObj,sAction)) return;

		if(ComShowCodeConfirm("BKG00535") == false) break;

		formObj.f_cmd.value = REMOVE;
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1021GS.do", FormQueryString(formObj));

		status = ComGetEtcData(sXml, 'status');
		if(status == 'ok')
		{
			initForm();

			ComShowCodeMessage("BKG00593");
			isSaveable = false;
			isDeleteable = false;
		}
		else
		{
			alert("Data Delete Action Failed!!");
		}

		break;



	case MULTI:

		if(!validateForm(sheetObj,formObj,sAction)) return;

		if (formObj.dp_flg.checked == true) formObj.drft_bl_bank_acct_dp_flg.value = "Y";
		else formObj.drft_bl_bank_acct_dp_flg.value = "N"

		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1021GS.do", FormQueryString(formObj));

		status = ComGetEtcData(sXml, 'status');
		if(status == 'ok')
		{
			ComShowCodeMessage("BKG00166");
			isDeleteable = true;
		}
		else
		{
			ComShowCodeMessage("BKG00167");
		}

		break;
    }
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
function obj_keydown1()
{
	var key = event.keyCode;
	if(key == 13)
	{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
function obj_keydown2()
{
	fncTextareaMaxLine(document.form.bank_in_acct_ctnt, 4);
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
function fncTextareaMaxLine(obj, maxLine)
{
	var str_len = obj.value;
	line = str_len.split("\r\n");
	ln = line.length;

	if(ln == maxLine && event.keyCode == 13)
	{
	    event.returnValue = false;
	}
}
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************