/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1044.js
*@FileTitle : Customer Code Entry
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function processButtonClick()
{
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject1 = sheetObjects[0];
     /*******************************************************/
     var formObj = document.form;

     try
     {
    	 var srcName = window.event.srcElement.getAttribute("name");

    	 switch(srcName)
    	 {
    	 	case "btn_Add":
    	 		funcAddRow(sheetObject1);
				break;
    	 	case "btn_Delete":
    	 		funcDeleteRow(sheetObject1);
				break;
    	 	case "btn_Retrieve":
    	 		doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
    	 	case "btn_Save":
    	 		doActionIBSheet(sheetObject1, formObj, MULTI);
				break;
    	 	case "btn_Close":
    	 		var sParam = ComGetSaveString(sheetObject1);
				if(sParam != "")
				{
					if(ComShowCodeConfirm("BKG00168"))
					{
						self.close();
					}
				}
				else
				{
					self.close();
				}
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

//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}


//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage()
{

    for(i=0;i<sheetObjects.length;i++){

    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

    //sheetObjects[0].RowEditable(1) = false;
    var form = document.form;
    var cust_seq = form.origin_cust_seq.value;
    if(cust_seq.length != 6) form.cust_seq.value = funcLPad(cust_seq, '0', 6);
    else					 form.cust_seq.value = form.origin_cust_seq.value;
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo)
{
	var cnt = 0;
	switch(sheetObj.id)
	{
		case "sheet1":      //sheet1 init
			with (sheetObj)
			{
				// 높이 설정
				style.height = 142;

				//전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

				var HeadTitle1 = "|Sel.|Seq|Reference|Fax|E-mail|OFC|User ID|Updated||||";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC, DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,true, 	"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,true,	"sel",				false,	"",  dfNone,0,true,	true);
				InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,true,	"seq",				false,	"",  dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtData,			200,daCenter,true,	"cntc_rmk",			false,	"",  dfNone,0,true, true, 100);
				InitDataProperty(0, cnt++ , dtData,			100,daCenter,true,	"fax_no",			false,	"",  dfNone,0,true,	true, 20);
				InitDataProperty(0, cnt++ , dtData,			140,daCenter,true,	"cntc_eml",			false,	"",  dfEngKey,0,true,	true, 50);
				InitDataProperty(0, cnt++ , dtData,			70, daCenter,true,	"ofc_cd",			false,	"",  dfNone,0,false,true, 20);
				InitDataProperty(0, cnt++ , dtData,			70, daCenter,true,	"upd_usr_id",		false,	"",  dfNone,0,false,true, 20);
				InitDataProperty(0, cnt++ , dtData,			100,daCenter,true,	"upd_dt",			false,	"",  dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,true,	"cust_cnt_cd",		false,	"",  dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,true,	"cust_seq",			false,	"",  dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,true,	"cmdt_cntc_seq",	false,	"",  dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,true,	"usr_nm",	false,	"",  dfNone,0,false,true);
				InitDataValid(0, 4, vtNumericOther, "-");

				ToolTipOption="balloon:true;width:320;forecolor:#0000FF;icon:1";

				CountPosition = 0;
			}

		break;
	}
}

//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function doActionIBSheet(sheetObj,formObj,sAction)
{
    //sheetObj.ShowDebugMsg = false;
    switch(sAction)
    {
    	case IBSEARCH:      //조회
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_1044GS.do", FormQueryString(formObj));
			for(var i=1;i<sheetObj.Rows;i++)
			{
				//alert(sheetObj.CellValue(i, "usr_nm"));
				sheetObj.ToolTipText(i, "upd_usr_id") = sheetObj.CellValue(i, "usr_nm");
			}

			break;

		case MULTI:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = MULTI;
			var sParam = ComGetSaveString(sheetObj);
			if (sParam == "")
			{
				//msgs['BKG00168'] = "값이 변경되었습니다.저장하지 않고 닫으시겠습니까?";
				//msgs['BKG00233'] = "변경된 내역이 없습니다.";
				ComShowCodeMessage("BKG00233");
				return;
			}
			sParam += "&" + FormQueryString(formObj);




			sheetObj.DoSave("ESM_BKG_1044GS.do", FormQueryString(formObj));

			//
			return;

			if(!sheetObj.DoSave("ESM_BKG_1044GS.do", FormQueryString(formObj))) return;
			status = sheetObj.EtcData('status');

			alert(status);

			//var xml = sheetObj.GetSaveXml("ESM_BKG_1044GS.do", FormQueryString(formObj));
			//status = ComGetEtcData(xml, 'status');

			if(status == 'ok')
			{
				ComShowCodeMessage("BKG00166");
			}
			else
			{
				ComShowCodeMessage("BKG00167");
			}
			break;
    }
    //sheetObj.RowEditable(1) = false;
}

//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction)
{
	switch(sAction)
	{
		case IBSEARCH:

		break;
		case MULTI:
			//메일 주소 유효성 검증
			var idx = 1;
			var focusRow = 1;
			var validate = true;

			for(idx=2;idx<sheetObj.Rows;idx++)
			{
				if(sheetObj.RowStatus(idx) == 'D') continue;
				var email_text = sheetObj.CellValue(idx, sheetObj.SaveNameCol("cntc_eml"));
				if(!emailAddrValidate(email_text) && email_text != '')
				{
					ComShowCodeMessage("BKG00366");
					focusRow = idx;
					sheetObj.CellValue(focusRow, sheetObj.SaveNameCol("cntc_eml")) = "";
					validate = false;
					break;
				}
				if(email_text.length > 30)
				{
					ComShowCodeMessage("BKG00107");
					validate = false;
					focusRow = idx;
					break;
				}
				var remrk_text = sheetObj.CellValue(idx, sheetObj.SaveNameCol("cntc_rmk"));
				if(remrk_text.length > 50)
				{
					ComShowCodeMessage("BKG00107");
					validate = false;
					focusRow = idx;
					break;
				}
			}

			if(!validate)
			{
				sheetObj.SelectRow = focusRow;
				return false;
			}
		break;
	}

    return true;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcDeleteRow(sheetObj)
{
	var idx = 1;
	var col = sheetObj.SaveNameCol("sel");
	while(idx < sheetObj.Rows)
	{
		if(sheetObj.CellText(idx, col) == '1')
		{
			if(sheetObj.RowStatus(idx) == 'I')
			{
				//sheetObj.RowStatus(idx) = 'D';
				sheetObj.RowDelete(idx,false);
				continue;
			}
			else
			{
				sheetObj.RowStatus(idx) = 'D';
				sheetObj.RowHidden(idx) = true;
			}
		}
		idx ++;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcAddRow(sheetObj)
{
	sheetObj.DataInsert(-1);
	var ofc_cd = sheetObj.SaveNameCol("ofc_cd");
	var sel = sheetObj.SaveNameCol("sel");
	var upd_dt = sheetObj.SaveNameCol("upd_dt");
	var usr_id = sheetObj.SaveNameCol("upd_usr_id");
	var row = sheetObj.Rows - 1;

	var cust_cnt_cd = sheetObj.SaveNameCol("cust_cnt_cd");
	var cust_seq = sheetObj.SaveNameCol("cust_seq");
	var cmdt_cntc_seq = sheetObj.SaveNameCol("cmdt_cntc_seq");

	sheetObj.CellText(row, ofc_cd) = document.form.office.value;
	sheetObj.CellText(row, cust_cnt_cd) = document.form.cust_cnt_cd.value;
	sheetObj.CellText(row, cust_seq) = document.form.cust_seq.value;

	sheetObj.CellEditable(row, ofc_cd) = false;
	sheetObj.CellEditable(row, upd_dt) = false;
	sheetObj.CellEditable(row, usr_id) = false;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function emailAddrValidate(sVal)
{
    try
    {
        var format =  /^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
        return (sVal.search(format) != -1);
    }
    catch(err)
    {
    	ComFuncErrMsg(err.message);
    }
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcSearch()
{
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcLPad(src, fit, fixLength)
{
	if(src.length >= fixLength) return src.substring(0, fixLength);
	var gap = fixLength - src.length;
	var temp = src;
	for(var i=0;i<gap;i++)
	{
		src = fit + src;
	}
	return src;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcRPad(src, fit, fixLength)
{
	if(src.length >= fixLength) return src.substring(0, fixLength);
	var gap = fixLength - src.length;
	var temp = src;
	for(var i=0;i<gap;i++)
	{
		src = src + fit;
	}
	return src;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************


function sheet1_OnSaveEnd(sheetObj, errMsg){
    //ComOpenWait(false);
    //sheetObj.WaitImageVisible = true;

    if(errMsg != ""){

	}

}