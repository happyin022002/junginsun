/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1094.jsp
*@FileTitle  : Chassis Long Staying Environment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_CGM_1094 : EES_CGM_1094 business script for
 */

/* developer job	*/
//common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var focusInBuVal=0;
var CanMakeData=true;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version 
 */ 
function processButtonClick(){
	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_retrieve":
			// IBSHEET retrieve
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject2, formObject, IBSAVE);
			break;
		case "btn_new":
			initControl();
			break;
		//case "btn_close":
			//comPopupOK();
			//self.close();
			//break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
* registering IBSheet Object as list <br>
* @param  {object} sheet_obj	
* @return 
* @author 
* @version 
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list
* param : combo_obj ==> comboobject
* adding process for list in case of needing batch processing with other items
* defining list on the top of source
*/
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
* initializing sheet <br>
* implementing onLoad event handler in body tag <br>
* @param  
* @return 
* @author 
* @version 
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	// axon event regist
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('blur', 'obj_blur', form);
	axon_event.addListenerFormat('focusin', 'obj_focusin', form);
	//axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	//axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	//axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
//	//axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	initControl(sheetObjects[0]);
	// IBSHEET retrieve
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	
}
/**
* sheet setting and init in case of load finish <br>
* @param  
* @return 
* @author 
* @version 
*/     
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
    sheetObj.SetWaitImageVisible(1);
}
/**
 * init control of form <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */
function initControl(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	// Form Object reset
	with(formObj){
		// setting form object by grid value
		staying_days.value=0;
		n1st_inq_fm_dys.value=0;
		n1st_inq_to_dys.value=15;
		n2nd_inq_fm_dys.value=parseInt(n1st_inq_to_dys.value.parseInt()) + 1;
		n2nd_inq_to_dys.value=30;
		n3rd_inq_fm_dys.value=parseInt(n2nd_inq_to_dys.value) + 1;
		n3rd_inq_to_dys.value=50;
		n4th_inq_fm_dys.value=parseInt(n3rd_inq_to_dys.value) + 1;
		n4th_inq_to_dys.value=100;
		n5th_inq_fm_dys.value=parseInt(n4th_inq_to_dys.value) + 1;
		n5th_inq_to_dys.value=180;
		n6th_inq_fm_dys.value=parseInt(n5th_inq_to_dys.value) + 1;
	}
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {int} sheetNo
 * @return 
 * @author 
 * @version 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
        with(sheetObj){
		  var HeadTitle="|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";
		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);
		  var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		   
		  InitColumns(cols);
		  SetEditable(1);
		  SetSheetHeight(80);
		  SetVisible(0);
        }
	break;
	case 2:
        with(sheetObj){
		  var HeadTitle="|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";
		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);
		  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		   
		  InitColumns(cols);
		  SetEditable(1);
		  SetSheetHeight(80);
		  SetVisible(0);
            }
		break;
	}
}
/**
 * handling process for Sheet <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type
 * @return 
 * @author 
 * @version
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieve
			formObj.f_cmd.value=SEARCH01;
 			sheetObj.DoSearch("EES_CGM_1094GS.do", FormQueryString(formObj) );

			// setting form object by grid value
			
			break;
		case IBSAVE:
			var actionFlag=false; 
			formObj.f_cmd.value=MULTI;
			sheetObj.RemoveAll();
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(1, "n1st_inq_fm_dys",formObj.n1st_inq_fm_dys.value);
			sheetObj.SetCellValue(1, "n1st_inq_to_dys",formObj.n1st_inq_to_dys.value);
			sheetObj.SetCellValue(1, "n2nd_inq_fm_dys",formObj.n2nd_inq_fm_dys.value);
			sheetObj.SetCellValue(1, "n2nd_inq_to_dys",formObj.n2nd_inq_to_dys.value);
			sheetObj.SetCellValue(1, "n3rd_inq_fm_dys",formObj.n3rd_inq_fm_dys.value);
			sheetObj.SetCellValue(1, "n3rd_inq_to_dys",formObj.n3rd_inq_to_dys.value);
			sheetObj.SetCellValue(1, "n4th_inq_fm_dys",formObj.n4th_inq_fm_dys.value);
			sheetObj.SetCellValue(1, "n4th_inq_to_dys",formObj.n4th_inq_to_dys.value);
			sheetObj.SetCellValue(1, "n5th_inq_fm_dys",formObj.n5th_inq_fm_dys.value);
			sheetObj.SetCellValue(1, "n5th_inq_to_dys",formObj.n5th_inq_to_dys.value);
			for(i=0;i<sheetObj.LastRow()+1;i++)
			{
			  sheetObj.SetRowStatus(i,"U");
			}
			if(actionFlag){
	        	ComShowCodeMessage("CGM10007");
			} else {
				//var txtsave = sheetObj.DoSave("EES_CGM_1094GS.do", FormQueryString(formObj));
				//alert(txtsave);
	 			/*if(sheetObj.DoSave("EES_CGM_1094GS.do", FormQueryString(formObj)))
	 			{
	 				ComShowCodeMessage("CGM00003");
	 			}else
	 			{
	 			}*/
				//ComOpenWait(true);	   
				if(sheetObj.DoSave("EES_CGM_1094GS.do", FormQueryString(formObj))) {
					
       				           		    	
       		    }
				//ComOpenWait(false);
			}
		 	//var params = sheetObj.GetSaveString(true);		
			break;
	}
}



function sheet2_OnSaveEnd(sheetObj,code,msg) {
	if(code == 0) {
		ComShowCodeMessage('CGM00003');
	}
}
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
		case IBSEARCH:
			break;
		}
	}
}
/**
 * Sheet1  OnSearchEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	var formObj = document.form;
	if(sheetObj.RowCount() == 0){
		formObj.staying_days.value=0; 
		formObj.n1st_inq_fm_dys.value=0;
		formObj.n1st_inq_to_dys.value=15;
		formObj.n2nd_inq_fm_dys.value=parseInt(formObj.n1st_inq_to_dys.value.parseInt()) + 1;
		formObj.n2nd_inq_to_dys.value=30;
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value) + 1;
		formObj.n3rd_inq_to_dys.value=50;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value) + 1;
		formObj.n4th_inq_to_dys.value=100;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value) + 1;
		formObj.n5th_inq_to_dys.value=180;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value) + 1;
	}else{
		formObj.staying_days.value=sheetObj.GetCellValue(1,"n1st_inq_fm_dys"); //chungpa 20091015 staying_days.
		formObj.n1st_inq_fm_dys.value=sheetObj.GetCellValue(1,"n1st_inq_fm_dys");
		formObj.n1st_inq_to_dys.value=sheetObj.GetCellValue(1,"n1st_inq_to_dys");
		formObj.n2nd_inq_fm_dys.value=sheetObj.GetCellValue(1,"n2nd_inq_fm_dys");
		formObj.n2nd_inq_to_dys.value=sheetObj.GetCellValue(1,"n2nd_inq_to_dys");
		formObj.n3rd_inq_fm_dys.value=sheetObj.GetCellValue(1,"n3rd_inq_fm_dys");
		formObj.n3rd_inq_to_dys.value=sheetObj.GetCellValue(1,"n3rd_inq_to_dys");
		formObj.n4th_inq_fm_dys.value=sheetObj.GetCellValue(1,"n4th_inq_fm_dys");
		formObj.n4th_inq_to_dys.value=sheetObj.GetCellValue(1,"n4th_inq_to_dys");
		formObj.n5th_inq_fm_dys.value=sheetObj.GetCellValue(1,"n5th_inq_fm_dys");
		formObj.n5th_inq_to_dys.value=sheetObj.GetCellValue(1,"n5th_inq_to_dys");
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value) + 1;
		CanMakeData=false;	
	}
	sheetObj.SetRowStatus(1,"U");// I,R,U,D
}

/** 
 * Object activate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */
function obj_activate(){
	ComClearSeparator(ComGetEvent());
} 
/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */
function obj_deactivate(){
	ComChkObjValid(ComGetEvent());
}
/** 
 * Object Keypress event handling  <br>
 * 
 * @param  
 * @return 
 * @author 
 * @version 
 */ 
function obj_keypress(){
	obj=ComGetEvent();
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    var formObj=document.form;
    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
        	if(obj.name=="staying_days")
        	{
//        		if(event.keyCode == 13) 
//        		{
//        			// IBSHEET retrieve
//        			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//        			return;
//        		}
        		ComKeyOnlyNumber(obj);
        	}else if(obj.name=="n1st_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n1st_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n2nd_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n2nd_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n3rd_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n3rd_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n4th_inq_fm_dys")
    		{
            	ComKeyOnlyNumber(obj);
    		}else if(obj.name=="n4th_inq_to_dys")
            {
    			ComKeyOnlyNumber(obj);
            }else if(obj.name=="n5th_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n5th_inq_to_dys")
            {
            	ComKeyOnlyNumber(obj);
            }else if(obj.name=="n6th_inq_fm_dys")
            {
            	ComKeyOnlyNumber(obj);
            }
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); break;
        case "engup":
            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
            else ComKeyOnlyAlphabet('upper');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
    }	
} 
/** 
 * Object focusin event handling  <br>
 * form FOCUS_IN handling.  <br>
 * @param  
 * @return 
 * @author 
 * @version 2009.07.28
 */ 
function obj_focusin(){
	var formObj=document.form;
	var obj=ComGetEvent();
	CanMakeData=true; 
	if(obj.name=="staying_days")
	{
		focusInBuVal=parseInt(formObj.staying_days.value); 
	}else if(obj.name=="n1st_inq_fm_dys")
    {
    }else if(obj.name=="n1st_inq_to_dys")
    {
    	focusInBuVal=parseInt(formObj.n1st_inq_to_dys.value);
    }else if(obj.name=="n2nd_inq_fm_dys")
    {
    }else if(obj.name=="n2nd_inq_to_dys")
    {
    	focusInBuVal=parseInt(formObj.n2nd_inq_to_dys.value);
    }else if(obj.name=="n3rd_inq_fm_dys")
    {
    }else if(obj.name=="n3rd_inq_to_dys")
    {
    	focusInBuVal=parseInt(formObj.n3rd_inq_to_dys.value);
    }else if(obj.name=="n4th_inq_fm_dys")
	{
	}else if(obj.name=="n4th_inq_to_dys")
    {
		focusInBuVal=parseInt(formObj.n4th_inq_to_dys.value);
    }else if(obj.name=="n5th_inq_fm_dys")
    {
    }else if(obj.name=="n5th_inq_to_dys")
    {
    	focusInBuVal=parseInt(formObj.n5th_inq_to_dys.value);
    }
}
/** 
  * Object blur event handling  <br>
  * form FOCUS_OUT handling.  <br>
  * @param  
  * @return 
  * @author 
  * @version 2009.07.24
  */  
function obj_blur(){
	var formObj=document.form;
	var obj=ComGetEvent();
	if(CanMakeData == false)return;  
	if(obj.name=="staying_days")
	{
		formObj.n1st_inq_fm_dys.value=parseInt(formObj.staying_days.value);
		formObj.n1st_inq_to_dys.value=parseInt(formObj.n1st_inq_fm_dys.value)+1;
		formObj.n2nd_inq_fm_dys.value=parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value=parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
	}else if(obj.name=="n1st_inq_fm_dys")
    {
		formObj.n1st_inq_to_dys.value=parseInt(formObj.n1st_inq_fm_dys.value)+1;
		formObj.n2nd_inq_fm_dys.value=parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value=parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n1st_inq_to_dys")
    {
    	if(parseInt(formObj.n1st_inq_fm_dys.value)>=parseInt(formObj.n1st_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n1st_inq_to_dys.value=focusInBuVal;
		   	return;
    	}
		formObj.n2nd_inq_fm_dys.value=parseInt(formObj.n1st_inq_to_dys.value)+1;
		formObj.n2nd_inq_to_dys.value=parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n2nd_inq_fm_dys")
    {
		formObj.n2nd_inq_to_dys.value=parseInt(formObj.n2nd_inq_fm_dys.value)+1;
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n2nd_inq_to_dys")
    {
    	if(parseInt(formObj.n2nd_inq_fm_dys.value)>=parseInt(formObj.n2nd_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n2nd_inq_to_dys.value=focusInBuVal;
		   	return;
    	}    	
		formObj.n3rd_inq_fm_dys.value=parseInt(formObj.n2nd_inq_to_dys.value)+1;
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n3rd_inq_fm_dys")
    {
		formObj.n3rd_inq_to_dys.value=parseInt(formObj.n3rd_inq_fm_dys.value)+1;
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n3rd_inq_to_dys")
    {
    	if(parseInt(formObj.n3rd_inq_fm_dys.value)>=parseInt(formObj.n3rd_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n3rd_inq_to_dys.value=focusInBuVal;
		   	return;
    	}       	
		formObj.n4th_inq_fm_dys.value=parseInt(formObj.n3rd_inq_to_dys.value)+1;
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n4th_inq_fm_dys")
	{
		formObj.n4th_inq_to_dys.value=parseInt(formObj.n4th_inq_fm_dys.value)+1;
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
	}else if(obj.name=="n4th_inq_to_dys")
    {
    	if(parseInt(formObj.n4th_inq_fm_dys.value)>=parseInt(formObj.n4th_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n4th_inq_to_dys.value=focusInBuVal;
		   	return;
    	}       			
		formObj.n5th_inq_fm_dys.value=parseInt(formObj.n4th_inq_to_dys.value)+1;
		formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n5th_inq_fm_dys")
    {
    	formObj.n5th_inq_to_dys.value=parseInt(formObj.n5th_inq_fm_dys.value)+1;
		formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }else if(obj.name=="n5th_inq_to_dys")
    {
    	if(parseInt(formObj.n5th_inq_fm_dys.value)>=parseInt(formObj.n5th_inq_to_dys.value))
    	{
    		ComShowCodeMessage('CGM10042','Long Staying Days Period');
    		formObj.n5th_inq_to_dys.value=focusInBuVal;
		   	return;
    	}      	
    	formObj.n6th_inq_fm_dys.value=parseInt(formObj.n5th_inq_to_dys.value)+1;
    }
}
/** 
 * Object change event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */  
function obj_change(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0]; 
	obj=ComGetEvent();
}
/** 
 * Object obj_focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version 
 */  
function obj_focusout(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	obj=ComGetEvent();
}
/* developer job end */

