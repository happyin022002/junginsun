/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1056.js
*@FileTitle : Container Loading List_Summary_SPP List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.09.14 손윤석
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
    	 		addRows(sheetObject1);
				break;
    	 	case "btn_Delete":
    	 		deleteRows(sheetObject1);
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
    	 	case "btn_Select":
    	 		selectItem(sheetObject1, formObj);
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
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    
    funcSetDefault();
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
				style.height = 162;
				
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

				var HeadTitle1 = "|Sel.|Type|Name||||";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성    [ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC, DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	20,	daCenter,true, 	"ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,true,	"sel",				false,	"",  dfNone,0,true, true);
				InitDataProperty(0, cnt++ , dtCombo,		70, daCenter,true,	"attr_ctnt1",		false,	"",  dfNone,0,true, true, 2);
				InitDataProperty(0, cnt++ , dtData,			300,daLeft,  true,	"attr_ctnt2",		false,	"",  dfNone,0,true,	true, 50);
				InitDataProperty(0, cnt++ , dtHidden,		30, daCenter,true,	"cstms_div_id_seq",	false,	"",  dfNone,0,false, false, 50);
				InitDataProperty(0, cnt++ , dtHidden,		30, daCenter,true,	"cstms_div_id",		false,	"",  dfNone,0,false, false, 50);
				InitDataProperty(0, cnt++ , dtHidden,		30, daCenter,true,	"cnt_cd",			false,	"",  dfNone,0,false, false, 50);
				InitDataProperty(0, cnt++ , dtHidden,       30, daCenter,true,   "delt_flg", 		false,  "",  dfNone,0,false, false, 50);
				
				InitDataCombo(0, "attr_ctnt1", "TO|FM", "TO|FM", "TO", "TO");
				
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
    sheetObj.ShowDebugMsg = false;
    switch(sAction) 
    {
    	case IBSEARCH:      //조회
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		formObj.f_cmd.value = SEARCH;
    		sheetObj.WaitImageVisible = false;	
    		ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_1056GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
			
		case MULTI:        //저장

			formObj.f_cmd.value = MULTI;
    		sheetObj.WaitImageVisible = false;	
    		ComOpenWait(true);
			var sParam = ComGetSaveString(sheetObj);
			//if (sParam == "") 
			//{
			//	//msgs['BKG00233'] = "변경된 내역이 없습니다.";
			//	ComShowCodeMessage("BKG00233");
			//	return; 
			//}
			sParam += "&" + FormQueryString(formObj);
			
			sheetObj.DoSave("ESM_BKG_1056GS.do", FormQueryString(formObj));
			state = sheetObj.EtcData("TRANS_RESULT_KEY");
			//status = sheetObj.EtcData('TRANS_RESULT_KEY');
			ComOpenWait(false);
			//var xml = sheetObj.GetSaveXml("ESM_BKG_1056GS.do", FormQueryString(formObj));
			//status = ComGetEtcData(xml, "TRANS_RESULT_KEY");
			//alert(state);
			if(state == 'S')
			{
				//ComShowCodeMessage("BKG00166");
				//alert("test");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
    }
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
			break;
	}

    return true;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Row Delete : 실제로 삭제하는것이 아니고, 삭제플레그값을 Y로 설정하여 Update시키도록 한다.
 */
function deleteRows(sheetObj)
{
	var idx = 1;
	var col = sheetObj.SaveNameCol("sel");
	var flg = sheetObj.SaveNameCol("delt_flg");
	var selectok = false;
	
	while(idx < sheetObj.Rows)
	{
		if(sheetObj.CellText(idx, col) == '1')
		{
			selectok = true;
			if(sheetObj.RowStatus(idx) == 'I')
			{
				sheetObj.RowDelete(idx, false); 
				continue;
			}
			else
			{
				sheetObj.RowStatus(idx) = 'D';
				sheetObj.CellText(idx, flg) = 'Y';
				sheetObj.RowHidden(idx) = true;
			}
		}
		idx ++;
	}
	
	if(!selectok)
	{
		ComShowCodeMessage("BKG00546");
		return;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Sheet의 Row추가~ : 기본적인 디폴트값을 자동으로 셋팅해 준다.
 */
function addRows(sheetObj)
{
	sheetObj.DataInsert(-1);
	sheetObj.CellText(sheetObj.Rows-1, sheetObj.SaveNameCol("cstms_div_id")) = 'CLL_SPP_CD';
	sheetObj.CellText(sheetObj.Rows-1, sheetObj.SaveNameCol("cnt_cd"))       = 'KR';
	sheetObj.CellText(sheetObj.Rows-1, sheetObj.SaveNameCol("delt_flg"))     = 'N';
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * 아이템을 체크하고(중복체크가능) Select누르면 부모창에 선택된 값을 새겨준다.
 */
function selectItem(sheetObj, formObj)
{
	var idx = 1;
	var settingTO = "";
	var settingFM = "";
	var col = sheetObj.SaveNameCol("sel");
	var typ = sheetObj.SaveNameCol("attr_ctnt1");
	var set = sheetObj.SaveNameCol("attr_ctnt2");
	var selectok = false;
	
	while(idx < sheetObj.Rows)
	{
		if(sheetObj.CellText(idx, col) == '1')
		{
			selectok = true;
			if(sheetObj.CellText(idx, typ) == 'TO')
			{
				settingTO = settingTO + ", " + sheetObj.CellText(idx, set);
			}
			else
			{
				settingFM = settingFM + ", " + sheetObj.CellText(idx, set);
			}
		}
		idx++;
	}
	
	if(!selectok)
	{
		ComShowCodeMessage("BKG00624");
		return;
	}
	
	settingTO = settingTO.substring(2);
	settingFM = settingFM.substring(2);

	if(opener != null)
	{
		if(settingTO.length > 0)
		{
			opener.form.setText1.value = settingTO;
		}
		if(settingFM.length > 0)
		{
			opener.form.setText2.value = settingFM;
		}
	}
	self.close();
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Row가 추가될때 현재 설정된 EntryType값에 따라서 type칼럼의 디폴트 값을 설정해주는 함수
 */
function funcSetDefault()
{
	var form = document.form;
	if(form.entryTp.value == 'FM')
	{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].InitDataCombo(0, "attr_ctnt1", "TO|FM", "TO|FM", "FM", "FM");
	}
	else
	{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].InitDataCombo(0, "attr_ctnt1", "TO|FM", "TO|FM", "TO", "TO");
	}
}