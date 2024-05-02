/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0273.js
*@FileTitle : Full CNTR Release Order History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var searchStatus='';
// Event handler processing by button click event */
document.onclick=processButtonClick;
//*************************************************************************************************
//*************************************************************************************************
//*************************************************************************************************
/** Event handler processing by button name
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick()
{
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try 
	{
		var srcName=ComGetEvent("name");
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
			var cal=new ComCalendarFromTo();
			cal.select(formObj.in_cre_dt_from, formObj.in_cre_dt_to,'yyyy-MM-dd');
			break;
		case "btn_Print":
			if(!funcCheckRowValid(sheetObject)) return;
				sheetObject.DoPrint();
			break;
		case "btn_Close":
				ComClosePopup(); 
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
 * handling process for input validation<br>
 */
function validateForm(sheetObj,formObj,sAction)
{
	switch(sAction)
	{
		case IBSEARCH:
			if(formObj.f_rad.value == 'Released Date')
	    	{
				var from_dt=formObj.in_cre_dt_from.value;
				var to_dt=formObj.in_cre_dt_to.value;				
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
				if(!ComChkPeriod(from_dt, to_dt))
				{
					ComShowCodeMessage("COM12133", "To Date", "From Date", "greater");
					formObj.in_cre_dt_from.focus();
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
	    			formObj.in_bl_no.focus();
	    			return false;
	    		}
	    	}
		break;
	}
    return true;
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() 
{
	for(i=0;i<sheetObjects.length;i++)
	{
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	if(formObj.f_mod.value == 'POPUP')
	{
		funcChangeOption(formObj, "BL");
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
	else
	{
		var now=new Date();
	    var year=now.getFullYear();
	    var month=now.getMonth() + 1;	// January=0,December=11
	    var day=now.getDate();
	    if(month < 10) month='0' + month;
	    if(day < 10) day='0' + day;
	    var dateval='' + year + '-' + month + '-' + day;
	    formObj.in_cre_dt_from.value=dateval;
	    formObj.in_cre_dt_to.value=dateval;
	    formObj.in_cre_dt_from.focus();
	    funcChangeOption(formObj, "Released Date");
	}
	initControl();
}
/**
 * Initialization Handling
 */
function initControl() 
{
	var formObject=document.form;
    axon_event.addListenerForm('click', 'obj_click', form );     
    axon_event.addListenerForm('keyup', 'obj_keyup', form );     
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    axon_event.addListenerForm ('focus', 'obj_activate', form);
    
}
/**
* Obj Select Event Handling
* @param {void}
* @return void
* @author
* @version 2009.10.01
*/
function obj_activate()
{
	var form=document.form;
	var srcName=ComGetEvent("name");
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
 * Key Up Event Handling
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function keyupcheck()
{
	var form=document.form;
	var key=event.keyCode;
	var srcValue=event.srcElement.getAttribute("value");
	var dtaLength=event.srcElement.getAttribute("maxlength");
	var srcLength=srcValue.length; 
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName=ComGetEvent("name");
    if(srcLength < dtaLength) return;
    switch(srcName)
    {
    case 'in_cre_dt_from':
    	form.in_cre_dt_to.focus();
    	break;
    case 'in_cre_dt_to':
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

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 */
function initSheet(sheetObj,sheetNo) 
{
    var cnt=0;
    switch(sheetNo) 
    {
        case 1:      //sheet1 init
            with(sheetObj)
            {

          var HeadTitle1="|Seq.|B/L No.|BKG No.|Container|TP/SZ|Consignee|Full Release Yard|MT Return Yard|T/VVD|POL|POD|Pin Data|D/O No|Badge Code|Released Date|Relase Expiry Date|Trucker Code/Name|Vechicle Registration|R.H.I.D.S Code|UVI No.|D/O Issue Date|T-Mode|ATP No.|CNTR Slot|P/Up DT|CNXL|Del.Term|Remark(s)|Office|Sent By|Sent at|M";

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tp_sz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Popup",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pin_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"do_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"co_bdg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rlse_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rlse_exp_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cgo_crr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"veh_rgst_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"road_hlg_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"uq_vsl_id_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"do_iss_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_slt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pkup_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cxl_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",  ColMerge:1,   SaveName:"rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rlse_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mzd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetEllipsis(1);
          SetShowButtonImage(2);
//          SetSheetHeight(420);
          resizeSheet();
                }


        break;
    }
}
/**
 * handling sheet process<br>
 */
function doActionIBSheet(sheetObj,formObj,sAction) 
{
    switch(sAction) 
    {
    	case IBSEARCH:      //Retrieve
    	formObj.f_cmd.value=SEARCH;
    	if(validateForm(sheetObj,formObj,sAction))	
    	{
     		sheetObj.DoSearch("ESM_BKG_0273GS.do", FormQueryString(formObj) );
    	}
    	break;
		case IBDOWNEXCEL:   //Excel Down
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1  });
			}			
		break;
    }
}
/**
 * Sheet Search End Event Handling
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		searchStatus=sheetObj.GetEtcData('status');
		for(var i=1; i <= LastRow(); i ++)
		{
			switch(GetCellValue(i, "MDST"))
			{
			case "M":
				SetRowMerge(i,1);
				SetCellAlign(i, "Check","Left");
				break;
			case "D":
				InitCellProperty(i, "Check",{ Type:"CheckBox"} );
				break;
			}
		}
	}
}

/**
 * Popup Click  Event Handling.<br>
 */
function sheet1_OnPopupClick(sheetObj, row, col){
	
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case "pin_no":
        	gEvaluationRowHeight=sheetObj.GetRowHeight(row);
        	var bkgNo=sheetObj.GetCellValue(row, "bkg_no").trim();
        	var cntrNo=sheetObj.GetCellValue(row, "cntr_no");
            popupRow=row;
            
            ComOpenPopup("/opuscntr/ESM_BKG_0271_POP.do?bkg_no="+bkgNo + "&cntr_no=" + cntrNo, 550, 350, "callBackComEns041", '0,1,1,1,1,1,1', true);
        	
            break;
    }
}

/**
 * Change Option Event Handling
 */
function funcChangeOption(formObj, mode)
{
	if(mode == "Released Date")
	{
			formObj.rad_vvd.checked=false;
			formObj.rad_bl.checked=false;
			formObj.rad_rlse_dt.checked=true;
			formObj.in_cre_dt_from.className="input1";
			formObj.in_cre_dt_to.className="input1";
			formObj.in_vvd.className="input";
			formObj.in_pod_cd.className="input";
			formObj.in_bl_no.className="input";
			formObj.f_rad.value="Released Date";
	}
	else if(mode == "BL")
	{
		formObj.rad_vvd.checked=false;
		formObj.rad_bl.checked=true;
		formObj.rad_rlse_dt.checked=false;
		formObj.in_cre_dt_from.className="input";
		formObj.in_cre_dt_to.className="input";
		formObj.in_vvd.className="input";
		formObj.in_pod_cd.className="input";
		formObj.in_bl_no.className="input1";
		formObj.f_rad.value="BL";
	}
	else
	{
		formObj.rad_vvd.checked=true;
		formObj.rad_bl.checked=false;
		formObj.rad_rlse_dt.checked=false;
		formObj.in_cre_dt_from.className="input";
		formObj.in_cre_dt_to.className="input";
		formObj.in_vvd.className="input1";
		formObj.in_pod_cd.className="input1";
		formObj.in_bl_no.className="input";
		formObj.f_rad.value="VVD";
	}
}
/**
 * Sheet Status Validation Check
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
 * Keyboard input contol in onkeypress event of HTML Control
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function obj_keypress()
{
	var form=document.form;
	var key=event.keyCode;
	var srcValue=event.srcElement.getAttribute("value");
	var maxLength=event.srcElement.getAttribute("maxlength");
	var srcLength=srcValue.length; 
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName=ComGetEvent("name");
    switch(event.srcElement.dataformat)
    {
        case "float":
            //number+"." input
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            //Only eng input, eng+num -> ComKeyOnlyAlphabet('num');
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            //Only lower eng input, lower eng+num -> ComKeyOnlyAlphabet('lowernum');
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            //Only upper eng input, upper eng+num -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        case "date":
        	ComKeyOnlyNumber(event.srcElement, "-");
        	break;
        case "ymd":
            ComKeyOnlyNumber(event.srcElement);
            if (srcValue.length == 4) {
              document.form.elements[srcName].value=srcValue.substring(0,4) + "-"
            }
            if (srcValue.length == 7) {
              document.form.elements[srcName].value=srcValue.substring(0,7) + "-"
            }
            break;
        default:	
            //Only num input(num,date,time)
            ComKeyOnlyNumber(event.srcElement);
    }
}
/**
 * Date Validation Check
 */
function funcValidDateData(val)
{
	var temp='';
	if(val.length != 10) return false;
	temp=val.substring(0, 4);
	if(isNaN(temp)) return false;
	temp=val.substring(4,5);
	if(temp != '-') return false;
	temp=val.substring(5,7);
	if(isNaN(temp)) return false;
	temp=val.substring(7,8);
	if(temp != '-') return false;
	temp=val.substring(8);
	if(isNaN(temp)) return false;
	return true;
}
 