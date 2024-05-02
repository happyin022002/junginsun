/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0106.jsp
*@FileTitle  : Allocation Results
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
*SJH.20150106.MOD : 전반수정
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(p_srcName) {
  var sheetObject=sheetObjects[0];
  var formObject=document.form;

  try {
	  if(p_srcName == undefined || typeof p_srcName !== 'string') { 
		  srcName=ComGetEvent("name");
		  if(ComGetBtnDisable(srcName)) return false;
	      } else {
	        srcName = p_srcName;
	      }
	 switch(srcName) {
      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;
      case "btn_Applytopl":
            // Missing 체크
            setSpcChtrRevMssCnt();
          break;
      case "btn_applytopl_step2":
          doActionIBSheet(sheetObject,formObject,IBCREATE);
          break;
      case "btn_Downexcel":
          doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
          break;
    } // end switch
  } catch(e) {
    if( e == "[object Error]") {
      ComShowMessage(OBJECT_ERROR);
    } else {
      ComShowMessage(e.message);
    }
  }
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode=false;
}
/**
 * Initializing IBCOMBO<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
 * @param {int} comboNo Mandatory IBMultiCombo's Sequence
 * @return N/A
 * @author 
 */ 
function initCombo(comboObj, comboNo) {
    with(comboObj) {
    	
        SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        SetSelectIndex(0);
        
        switch(comboObj.options.id) {
        case "f_seltrade":
                SetMaxLength(3);
            break;
        case "f_selrlane":
                SetMaxLength(5);
            break;    
        case "f_selioc":
                SetMaxLength(1);
            break;
        case "f_selcost":
            SetMaxLength(1);
        break;            
        }        
    } 
}
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
  switch(sheetNo) {
      case 1:      //sheet1 init
    	  with(sheetObj){
    	    var com_head1="YYYY-MM|Week|Trade|Lane|IOC|VVD|Charter-out\n(a)";
    	   var com_head2="|Total Network Cost\n(a+b)";
    	   var head1="|Cost allocation process for Company Sales"
    	   + "|Cost allocation process for Company Sales"
    	   + "|Cost allocation process for Company Sales"
    	   + "|Cost allocation process for Company Sales"
    	   + "|Cost allocation process for Company Sales";
      	   //SJH.20141105.MOD
    	   var head2="|Company Sales(Initial)|1st TS Alloc.|2nd TS Alloc.|Slot Internal Pricing|Company Sales final(b)";
    	   (13, 2, 0, true);
    	   var HeadTitle0=com_head1 + head1 + com_head2; 
    	   var HeadTitle1=com_head1 + head2 + com_head2;
    	   var cnt=0;

    	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

    	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	   var headers = [ { Text:HeadTitle0, Align:"Center"},
    	                 { Text:HeadTitle1, Align:"Center"} ];
    	   InitHeaders(headers, info);

    	   var cols = [ {Type:"Date",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",          KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"co_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:170,  Align:"Right",   ColMerge:1,   SaveName:"co_sls_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             //SJH.20141124.MOD : 1st TS Alloc. HIDDEN
    	             {Type:"AutoSum",   Hidden:1, Width:105,  Align:"Right",   ColMerge:1,   SaveName:"n1st_asgn_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Float",     Hidden:1, Width:105,  Align:"Right",   ColMerge:1,   SaveName:"n2st_asgn_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             //SJH.20141105.MOD : ipt_asgn_amt -> slt_inter_amt
    	             //{Type:"AutoSum", Hidden:0, Width:105,  Align:"Right",   ColMerge:1,   SaveName:"ipt_asgn_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:170,  Align:"Right",   ColMerge:1,   SaveName:"slt_inter_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:170,  Align:"Right",   ColMerge:1,   SaveName:"co_sales_final",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:1,   SaveName:"total_network_cost",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
    	    
    	   InitColumns(cols);
    	   SetEditable(0);
           SetHeaderRowHeight(10);
           SetCountPosition(0);
           SetWaitImageVisible(0);
           resizeSheet();
        }
        break;
  }
}
/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Reflash the rLane list when a trade code is changed
 */
function f_seltrade_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , value) {
 	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.f_cmd.value=SEARCHLIST01;
	var sXml=sheetObj.GetSearchData("ESM_COA_0106GS2.do", coaFormQueryString(formObj));
	var arrXml=sXml.split("|$$|");
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
	f_selrlane.SetSelectIndex(0);
}
/**
 * Change the period when the year, month, week is changed
 */
function setPeriod(obj) {
	ComCoaSetPeriod(obj);
}
/**
 * Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
  with(formObj){
      if(!chkValidSearch()) return false;
  }
  return true;
}
/**
  * Setting at the window
 */
function setSpcChtrRevMssCnt() {
 	var formObj=document.form;
	var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST;  //SEARCHLIST02;
     var sXml=sheetObj.GetSearchData("ESM_COA_0154GS.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
	if (0 < arrXml.length) {
		if (0 < Number(ComGetEtcData(arrXml[0],"rowCount"))) {
	    	var strUrl="?f_chkprd="+(formObj.f_chkprd[0].checked ? "W":"M");
	        strUrl += "&f_year="  +ComGetObjValue(formObj.f_year  );
	        strUrl += "&f_fm_mon="+ComGetObjValue(formObj.f_fm_mon);
	        strUrl += "&f_to_mon="+ComGetObjValue(formObj.f_to_mon);
	        strUrl += "&f_fm_wk=" +ComGetObjValue(formObj.f_fm_wk );
	        strUrl += "&f_to_wk=" +ComGetObjValue(formObj.f_to_wk );
	        ComOpenWindow2("ESM_COA_0154.do" + strUrl,'', "width=800,height=300,menubar=0,status=0,scrollbars=0,resizable=1");
		} else {
	    	if (ComShowConfirm(ComGetMsg("COA10033"))) {
	    		//doActionIBSheet(sheetObject,formObject,IBCREATE);
	    		processButtonClick("btn_applytopl_step2");
		    }
		}
    }
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBCLEAR:          //Inquiry
		//SJH.20150106.ADD/MOD
    	formObj.f_yearM.value=ComGetNowInfo("yy");
        formObj.f_year.value=ComGetNowInfo("yy");            
        formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
        formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");  
        
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=INIT;
 		var sXml=sheetObj.GetSearchData("ESM_COA_0106GS2.do", coaFormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		
      	//SJH.20150106.ADD/MOD
        formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
        formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
        formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
        formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
        document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
		
		if (0 < arrXml.length) 
			ComXml2ComboItem(arrXml[0], f_seltrade, "code", "name");
		if (1 < arrXml.length)
			ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
		if (2 < arrXml.length)
			ComXml2ComboItem(arrXml[2], f_selioc, "code", "name");
		if (3 < arrXml.length)
			ComXml2ComboItem(arrXml[3], f_selcost, "code", "name");
		
		ComOpenWait(false);
		break;	
  	case IBSEARCH:      //Inquiry
          if(!validateForm(sheetObj,formObj,sAction)) return false;
          // Prohibit button click when a business transaction is processing 
          ComOpenWait(true);
          if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
          if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
          if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
          if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
          formObj.f_cmd.value=SEARCHLIST;
          sheetObj.DoSearch("ESM_COA_0106GS.do", coaFormQueryString(formObj, "param1|param2|param3|param4|param5|param6|param7|param8") );
          break;
      case IBCREATE:      //SJH.20150106.MOD
          if(!validateForm(sheetObj,formObj,sAction)) return false;
          
          if (sheetObj.RowCount()> 0) {
              ComOpenWait(true);                       
              
              setTimeout( function () {
                  	formObj.f_cmd.value=MULTI01;
                    var sParam = sheetObj.GetSaveString(1);
                    if (sheetObj.IsDataModified() && sParam == "") return;
                    sParam = sParam + "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveData("ESM_COA_0106GS.do", sParam );
      	            sheetObj.LoadSaveData(sXml, {Sync:1});
                      
                    var err_cd = ComGetEtcData(sXml, "err_cd");
                    var err_msg = ComGetEtcData(sXml, "err_msg");	                        
      	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
      	                return false;
      	            }	                
                    if (err_cd == "00000") {
                        ComShowMessage(ComGetMsg('COA10018','CREATION')); 
                    } else {
                        ComShowMessage("["+err_cd+"]:"+err_msg);
                    }
                    sheetObj.SetEtcData("err_cd","");
                    sheetObj.SetEtcData("err_msg","");
                      
                    ComOpenWait(false);
              }, 100);
          } else {
              ComShowMessage(ComGetMsg('COA10017'));
          }		          
          break;
      case IBDOWNEXCEL:   // Excell download
          var excelType=selectDownExcelMethod(sheetObj);
                break;
        }
    }

function callBackExcelMethod(excelType){
	 switch (excelType) {
	     case "AY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	         break;
	     case "AN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	     case "DY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	     	break;
	     case "DN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
	 }
}
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
	sheetObj.SetSumValue(0, "TOTAL");
}
function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}