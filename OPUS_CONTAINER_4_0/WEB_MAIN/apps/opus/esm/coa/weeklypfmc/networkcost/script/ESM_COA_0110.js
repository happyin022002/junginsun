/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0110.js
*@FileTitle  : Create Networkcost & Slot Charter In & Out
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
*			 : SJH.20150106.MOD : 전반수정
=========================================================*/
/**
 * @extends 
 * @class ESM_COA_0110 : ESM_COA_0110 Business script for the UI
 */

// Grobla Variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var IBNEW=999; //New
var tab_selno=0; //Selected Tab No. (0, 1, ...)
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
  var sheetObject=sheetObjects[0];
  var sheetObject2=sheetObjects[1];
  var formObject=document.form;
  try {
    var srcName=ComGetEvent("name");
    if(ComGetBtnDisable(srcName)) return false;
    switch(srcName) {
      case "btn_New":
          if (tab_selno == 0) { //In case of first tab
            doActionIBSheet(sheetObject,formObject,IBNEW);
          } else { 
            doActionIBSheet2(sheetObject2,formObject,IBNEW);
          }
          break;
      case "btn_Retrieve":
          if (tab_selno == 0) { //In case of first tab
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
          } else { 
            doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
          }
          break;
      case "btn_Creation":
          if (tab_selno == 0) { //In case of first tab
            doActionIBSheet(sheetObject,formObject,IBCREATE);
          } else { 
            doActionIBSheet2(sheetObject2,formObject,IBCREATE);
            doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
            if (formObject.f_fm_wk.value != formObject.f_to_wk.value){
              window.event.srcElement.setAttribute("name","t2btng_missingstatus");
              processButtonClick();               
              window.event.srcElement.setAttribute("name","btn_Creation");                 
            }             
          }         
          break;
      case "t1btng_missingstatus": //next
      case "t2btng_missingstatus":
          if (!validateCond(formObject)) {
            return false;
          }
          var strType="";
          if (srcName == "t1btng_missingstatus") strType="1";
          if (srcName == "t2btng_missingstatus") strType="2";
          var strYear=formObject.f_year.value;
          var strFmMonth=formObject.f_fm_mon.value;
          var strToMonth=formObject.f_to_mon.value;     
          var strFmWeek=formObject.f_fm_wk.value;
          var strToWeek=formObject.f_to_wk.value;     
          var strChkPrd="";                                   
          if(formObject.f_chkprd[0].checked){
            strChkPrd="W";  // Week                  
          } else {
            strChkPrd="M";  // Month                  
          }
          var strTrade=(f_cobtrade.GetSelectCode()=="All")?"":f_cobtrade.GetSelectCode();
          var strLane=(f_coblane.GetSelectCode()=="All")?"":f_coblane.GetSelectCode();
          var strVessel=formObject.f_vessel.value;
          var strVoyage=formObject.f_voyage.value;
          var strDir=(cobDir.GetSelectCode()=="All")?"":cobDir.GetSelectCode();
          if (strDir == "") {
            strDir=formObject.f_dir.value;
          }
          strUrl="?f_stryear="+strYear;
          strUrl += "&f_strfmmonth="+strFmMonth;
          strUrl += "&f_strtomonth="+strToMonth;                    
          strUrl += "&f_strfmweek="+strFmWeek;
          strUrl += "&f_strtoweek="+strToWeek;                    
          strUrl += "&f_strchkprd="+strChkPrd;    // W:Week, M: Month                
          strUrl += "&f_strtrade="+strTrade;
          strUrl += "&f_strlane="+strLane;
          strUrl += "&f_strvessel="+strVessel;
          strUrl += "&f_strvoyage="+strVoyage;
          strUrl += "&f_strdir="+strDir;
          strUrl += "&f_strtype="+strType;
          if(strType == "1") {
            strUrl += "&f_strprcnm=COA_CREATE_NTCOST_PRC";
          } else {
            strUrl += "&f_strprcnm=COA_CREATE_SPC_CHT_PRC";
          }
          //SJH.20141223.MOD
          //ComOpenWindow2("ESM_COA_0114.do" + strUrl,'', "width=900,height=450,menubar=0,status=0,scrollbars=0,resizable=1");
          ComOpenPopup('/opuscntr/ESM_COA_0114.do'+ strUrl, 900, 450,  '', '1,0,1,1,1,1,1,1,1,1,1,1', true);
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
	loadingMode=true;
	var objs = document.all.tabLayer;
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        objs[i].style.display = "inline";
        initSheet(sheetObjects[i],i+1);
        objs[i].style.display = "none";
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	for (var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
    tab_selno=0;
	loadingMode=false;
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
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBTab Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setTabObject(tab_obj){
  tabObjects[tabCnt++]=tab_obj;
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
 * @author SJH.20150106.MOD
 */ 
function initCombo(comboObj, comboNo) {
	with(comboObj) {
		
		SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        SetSelectIndex(0);    	
    	
        switch(comboObj.id) {
        case "f_cobtrade":
            	SetMaxLength(3);
            break;
        case "f_coblane":
            	SetMaxLength(5);
            break;	 
        case "cobDir":
            	SetMaxLength(1);
            break; 
        }
	}
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
         // (8, 0, 0, true);
	        var HeadTitle="STS|SEQ|Item Code|Account Code|Ownership|Carrier|Status|Select";
	        var cnt=0;
	
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibseq" },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_oshp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vop_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cre_slct_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" } ];
	         
	        InitColumns(cols);
	        
        	 SetEditable(1);
	         SetHeaderRowHeight(30);
			 resizeSheet();
	         InitComboNoMatchText(1,"",1);
        }


        break;
      case 2:      //sheet2 init
    	    with(sheetObj){
         // (12, 0, 0, true);
	        var varHead1="Charter-out(Income)|Charter-out(Income)|Charter-out(Income)|"
	        + "Charter-in(Expense)|Charter-in(Expense)|Charter-in(Expense)" ;
	        var varHead2="Basic-chtr|Sub-let|Crs-chtr|Basic-chtred|Sub-chtred|Crs-chtred" ;
	        var HeadTitle0="STS|Item Code|TypeCd|Type|Carrier|" + varHead1 + "|Status|Select" ;		//20150622.ADD : Item Code 추가
	        var HeadTitle1="STS|Item Code|TypeCd|Type|Carrier|" + varHead2 + "|Status|Select" ;		//20150622.ADD : Item Code 추가
	        var cnt=0;
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle0, Align:"Center"},
	                    { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        //20150622.ADD : stnd_cost_cd 추가
	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",  	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slt_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"slt_tp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"incm_bzc_chtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"incm_sub_lse_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"incm_crs_chtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"expn_bzc_chtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expn_sub_chtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expn_crs_chtr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	               {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"op_cre_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cre_slct_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetHeaderRowHeight(10);
			resizeSheet();
	        InitComboNoMatchText(1,"",1);
        }
        break;
  }
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
  switch(tabNo) {
    case 1:
        with (tabObj) {
          var cnt=0 ;
		InsertItem( "Network Cost", "");
		InsertItem( "Slot Charter In & Out", "");
        }
        break;
  }
}
/**
* Reflash the rLane list when a trade code is changed
*/
function f_cobtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.f_cmd.value=SEARCHLIST05;
	var sXml=sheetObj.GetSearchData("ESM_COA_0110GS3.do", coaFormQueryString(formObj));
	var arrXml=sXml.split("|$$|");
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], f_coblane, "code", "name");
	f_coblane.SetSelectIndex(0);
}
//Handling Enter-key of the window
function keyEnter_loc(){
	var sheetObject=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	if(event.keyCode == 13){
	    if (tab_selno == 0) { //In case of first tab
	      doActionIBSheet(sheetObject,formObject,IBNEW);
	    } else { 
	      doActionIBSheet2(sheetObject2,formObject,IBNEW);
	    }
	}
}
/**
 * Change period when the month, week changed
*/
function setPeriod(obj){
	ComCoaSetPeriod(obj);
}  
    /**
* Event when clicking Tab
* activating selected tab items
     */
    function tab1_OnChange(tabObj, nItem) {
      var objs=document.all.item("tabLayer");
      objs[nItem].style.display="inline";
      objs[beforetab].style.display="none";
      //--------------- Important --------------------------------//
      //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
      //----------------------------------------------------------//
      beforetab=nItem;
      tab_selno=nItem;
	  resizeSheet();
    }
    // Handling process about the sheet object
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        // Prohibit button click when a business transaction is processing 
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {        	
        	case IBCLEAR:          //Inquiry
        		//SJH.20150106.ADD/MOD
	        	formObj.f_yearM.value=ComGetNowInfo("yy");
	            formObj.f_year.value=ComGetNowInfo("yy");            
	            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
	            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");  
            
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=document.form.sXml.value; 
				var arrXml=sXml.split("|$$|");
				
	          	//SJH.20150106.ADD/MOD
	            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
	            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
	            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
	            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
	            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
	            
				if (0 < arrXml.length) {
					ComXml2ComboItem(arrXml[0], f_cobtrade, "code", "name");
				}
				if (1 < arrXml.length) {
					ComXml2ComboItem(arrXml[1], f_coblane, "code", "name");
				}
				if (2 < arrXml.length) {
					ComXml2ComboItem(arrXml[2], cobDir, "code", "name");
				}
				if (3 < arrXml.length) {
					ComCoaSetIBCombo(sheetObj, arrXml[3], "vsl_oshp_cd", true, 0);
				}
				if (4 < arrXml.length) {
					ComCoaSetIBCombo(sheetObj, arrXml[4], "vop_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[4], "vop_cd", true, 0);
				}
				if (5 < arrXml.length) {
					ComCoaSetIBCombo(sheetObj, arrXml[5], "cre_sts_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[5], "op_cre_sts_cd", true, 0);
				}
				if (6 < arrXml.length) {
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "incm_bzc_chtr_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "incm_sub_lse_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "incm_crs_chtr_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "expn_bzc_chtr_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "expn_sub_chtr_cd", true, 0);
					ComCoaSetIBCombo(sheetObjects[1], arrXml[6], "expn_crs_chtr_cd", true, 0);
				}
				
				document.form.sXml.value="";
				ComOpenWait(false);
				break;				
    		case IBNEW:      	//Initialize
                formObj.f_cmd.value=SEARCHLIST01;
                 sheetObj.DoSearch("ESM_COA_0110GS.do", coaFormQueryString(formObj) );
                break;
            case IBSEARCH:      //Inquiry result
                if (!validateForm(formObj)) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST02;
                sheetObj.DoSearch("ESM_COA_0110GS.do", coaFormQueryString(formObj) );
                break;
            case IBCREATE:      //Create
                if (!validateCond(formObj)) {
                    return false;
                }
                if (sheetObj.RowCount()> 0) {
                    if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                        ComOpenWait(true);                       
                        
                        //SJH.20141223.MOD : 수정 및 정리
                        setTimeout( function () {
                        	formObj.f_cmd.value=MULTI01;
	                        var sParam = sheetObj.GetSaveString(1);
	                        if (sheetObj.IsDataModified() && sParam == "") return;
	                        sParam = sParam + "&" + FormQueryString(formObj);
	                        var sXml = sheetObj.GetSaveData("ESM_COA_0110GS.do", sParam );
	        	            sheetObj.LoadSaveData(sXml, {Sync:1});
	                        
	                        var err_cd = ComGetEtcData(sXml, "err_cd");
	                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
	        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
	        	                return false;
	        	            }	                
	                        if (err_cd == "00000") {
	                            ComShowMessage(ComGetMsg('COA10018','CREATION')); 
	                        } else {
	                            ComShowMessage("There are missing cost items. Please try creation after settle missing cost items."+"\n"+err_cd+"\n"+err_msg);
	                        }
	                        sheetObj.SetEtcData("err_cd","");
	                        sheetObj.SetEtcData("err_msg","");
	                        
	                        doActionIBSheet(sheetObj,formObj,IBSEARCH);
	                        if (formObj.f_fm_wk.value != formObj.f_to_wk.value){
	                          window.event.srcElement.setAttribute("name","t1btng_missingstatus");
	                          processButtonClick();        
	                          window.event.srcElement.setAttribute("name","btn_Creation");       
	                        }    
                        }, 100);
                    }
                } else {
                    ComShowMessage(ComGetMsg('COA10017'));
                }
                break;
        }
    }
    // Handling process about the sheet object
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        // Prohibit button click when a business transaction is processing 
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
            case IBNEW:      //Initialize
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST03;
                sheetObj.DoSearch("ESM_COA_0110GS2.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBSEARCH:      //Inquiry result
                if (!validateForm(formObj)) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST04;
                sheetObj.DoSearch("ESM_COA_0110GS2.do", coaFormQueryString(formObj) );
                break;
            case IBCREATE:      //SJH.20150106.MOD
                if (!validateCond(formObj)) {
                    return false;
                }
                if (sheetObj.RowCount()> 0) {
                    if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                        ComOpenWait(true);
                        formObj.f_cmd.value=MULTI02;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return; //IsDataModified keyfield check
                        sParam= sParam + "&"+FormQueryString(formObj);
                        var sXml=sheetObj.GetSaveData("ESM_COA_0110GS2.do", sParam );
                        sheetObj.LoadSaveData(sXml, {Sync:1});

                        ComOpenWait(false);
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");
                      
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('COA10018','CREATION')); 
                        } else {
                            ComShowMessage("There are missing cost items. Please try creation after settle missing cost items."+"\n"+err_cd+"\n"+err_msg);
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        //Re-Inquiry
                        ComOpenWait(true);
                        formObj.f_cmd.value=SEARCHLIST04;
                        sheetObj.DoSearch("ESM_COA_0110GS2.do", coaFormQueryString(formObj) );
                        ComOpenWait(false);
                    }
                } else {
                    ComShowMessage(ComGetMsg('COA10017'));
                }
                break;
        }
    }

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
    /**
     * Handling process for form object input validation
     * SJH.20150106.MOD
     */
    function validateForm(formObj){
        with(formObj){
        	if(!chkValidSearch()) return false;
        }
        return true;
    }
    /**
     * Handling process for input validation
     */
    function validateCond(formObj) {
    	with(formObj){
    		
    		//SJH.20150106.MOD
    		if(!chkValidSearch()) return false;
    		
            // Vessel Check... 
            if (ComTrim(f_vessel.value) != "" && ComTrim(f_vessel.value).length != 4){
            	ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
            	f_vessel.focus();
            	return false;
            }
            // Voayage Check...
            if (ComTrim(f_voyage.value) != "" && ComTrim(f_voyage.value).length != 4){
            	ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
            	f_voyage.focus();
            	return false;
            }
            // Direction Check...
            // It's different for the 3rd argument of the msg1 and msg2
            if (ComTrim(cobDir.value) != ComTrim(f_dir.value) && ComTrim(cobDir.value) != "All" && ComTrim(cobDir.value) != "" && ComTrim(f_dir.value) != ""){
            	ComShowMessage(ComGetMsg('COA10016','DIR','VVD'));
            	f_dir.focus();
            	return false;
            }
        }
    	return true;
    }

    function resizeSheet(){
        var objs=document.all.item("tabLayer");
    	if (objs[0].style.display=="inline") {
    		ComResizeSheet(sheetObjects[0]);
    	} else {
    		ComResizeSheet(sheetObjects[1]);
    	}
    }
    