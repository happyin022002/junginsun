/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_4001.js
*@FileTitle  : Unit Price management for MRI Freight revenue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */
    /**
     * @extends 
     * @class ESM_COA_4001 : ESM_COA_4001 Business script for the UI
     */
  var sheetObjects=new Array();
  var sheetCnt=0;
  var comboObjects=new Array();
  var comboCnt=0;
  var loadingMode=false;
  var EXCEL_LOAD_FLG = false;	//check excell loading
  var EXCEL_VAL_FLG = false;	//check excell validation check
  var IBVALIDATION1 = "IBVALIDATION1";
  var IBVALIDATION2 = "IBVALIDATION2";   

document.onclick=processButtonClick;

function processButtonClick(){

    var costLocGrpCdCombo=comboObjects[0];
    var formObject=document.form;
    
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
                
            case "btn_Save1":
            	doActionIBSheet(sheetObjects[0],formObject,IBVALIDATION1);
                if(EXCEL_VAL_FLG) doActionIBSheet(sheetObjects[0],formObject,IBSAVE);                
                break;					
				
            case "btn_Rowadd1":
                doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
                break;	
                
			case "btn_DownExcel1":				
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
				
			case "btn_LoadExcel1":
				doActionIBSheet(sheetObjects[0],formObject,IBLOADEXCEL);
				break;
			//SJH.20141105.ADD	
			case "btn_Validation1":	
				doActionIBSheet(sheetObjects[0],formObject,IBVALIDATION1);
				break;
				
            case "btn_EccStatus":
                if(sheetObjects[0].RowCount()>0){
                    var sRow=sheetObjects[0].GetSelectRow();
                    formObject.f_view_tpsz.value=sheetObjects[0].GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.f_ecc_cd2.value=sheetObjects[0].GetCellValue(sRow, "scc_cd");
			  		formObject.f_from.value = sheetObjects[0].GetCellValue(sRow, "cost_src_fm_yrmon");		//SJH.20141105.MOD
			  		formObject.f_to.value = sheetObjects[0].GetCellValue(sRow, "cost_src_to_yrmon");		//SJH.20141105.MOD
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                } else {
                     ComShowMessage(ComGetMsg('COA10005','Sheet1'));
                }
                break;
                
            case "btn_Save2":
            	doActionIBSheet(sheetObjects[1],formObject,IBVALIDATION2);
            	if(EXCEL_VAL_FLG) doActionIBSheet(sheetObjects[1],formObject,IBSAVE);                
                break;
				
            case "btn_Rowadd2":
                doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
                break;
                
			case "btn_DownExcel2":				
				doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				break;
				
			case "btn_LoadExcel2":
				doActionIBSheet(sheetObjects[1],formObject,IBLOADEXCEL);
				break;
			//SJH.20141105.ADD
			case "btn_Validation2":
				doActionIBSheet(sheetObjects[1],formObject,IBVALIDATION2);
				break;	
			
			//SJH.20141223.ADD
			case "btn_Location" :
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 850, 520,  '', '1,0,1,1,1,1,1,1,1,1,1,1', true);
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
        if (comboObjects[k].options.id == "f_ecc_cd") comboObjects[k].SetBackColor("#CCFFFD");	//20141029.ADD
    }    
    loadingMode=false;
}   

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    sheetObj.UseUtf8=true;
    var cnt=0;
    switch(sheetNo) {
        case 1: //sheet1 init
            with(sheetObj){
         	  var HeadTitle0 = "Del.|STS|CHGSTS|Location\nHierarchy|TP / SZ|Trade|Location|Effective Month|Effective Month|EPP A Amount|EPP A Amount|EPP B Amount|EPP B Amount|Eq Status|Imbalance(%)|Inbound Vol.|Outbound Vol.|MT Cost Type|Source From|Source To|Batch|Remarks";
			  var HeadTitle1 = "Del.|STS|CHGSTS|Location\nHierarchy|TP / SZ|Trade|Location|From|To|Inbound|Outbound|Inbound|Outbound|Eq Status|Imbalance(%)|Inbound Vol.|Outbound Vol.|MT Cost Type|Source From|Source To|Batch|Remarks";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
              
              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                              { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              
            //SJH.20141127.MOD : 자리수, LOACATION
              var cols = [
       		             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibDel" },
      		             {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },      
      		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_status",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      		             {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cost_loc_grp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
      		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_fm_yrmon",        KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6   },
      		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_to_yrmon",        KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6   },
      		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ib_mty_amt1",     	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
      		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ob_mty_amt1",     	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
      		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ib_mty_amt2",     	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
      		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ob_mty_amt2",     	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
      		             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
      		             {Type:"Float",     Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:"cntr_imbal_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
      		             {Type:"Float",     Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:"cntr_ib_qty",      	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
      		             {Type:"Float",     Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:"cntr_ob_qty",      	  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
      		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Left",    ColMerge:1,   SaveName:"mty_cost_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cost_src_fm_yrmon",   KeyField:1,   CalcLogic:"",   Format:"Ym",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6  },
                         {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cost_src_to_yrmon",   KeyField:1,   CalcLogic:"",   Format:"Ym",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6  },
                         {Type:"CheckBox",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bat_flg",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TrueValue:"Y",   FalseValue:"N" },
                         {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"remark",   			  KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   MultiLineText:1, Wrap:1 } ];
                     
              InitColumns(cols);
                     
			  SetEditable(1);	//Editkind[optional,Defaultfalse]
  		      SetWaitImageVisible(0);
  		      SetSheetHeight(200) ;
  		      SetColProperty(0 ,"scc_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});		//SJH.20141127.ADD, 20151209.MOD : AcceptKeys E->N,E
            }
            break;
            
        case 2: //sheet9 init
            with(sheetObj){
        	var HeadTitle="Del.|STS|CHGSTS|TP / SZ|Location|Source From|Source To|ORIGIN|DESTINATION|Mode|MT Vol.|MT Unit Amt.|Remarks";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);              
              
              var cols = [
        		             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibDel" },
          		             {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },      
          		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_status",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                           	 {Type:"Combo",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:1,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",               KeyField:1,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5  },
                             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cost_src_fm_yrmon",    KeyField:1,   CalcLogic:"",   Format:"Ym",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6  },
                             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cost_src_to_yrmon",    KeyField:1,   CalcLogic:"",   Format:"Ym",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6  },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"org_nod_cd",           KeyField:1,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7  },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dest_nod_cd",          KeyField:1,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7  },                             
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"trsp_mty_cost_mod_nm", KeyField:1,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mty_qty",         	   KeyField:0,   CalcLogic:"",   Format:"Float",      PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
                             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mty_ut_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",      PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"remark",   			   KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   MultiLineText:1, Wrap:1 } ];
               
              InitColumns(cols);

  		      SetEditable(1);	//Editkind[optional,Defaultfalse]
  		      SetWaitImageVisible(0);
              SetSheetHeight(130) ;
              SetColProperty(0 ,"org_nod_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});	//20151209.MOD : AcceptKeys E->N,E
              SetColProperty(0 ,"dest_nod_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});	//20151209.MOD : AcceptKeys E->N,E
              SetColProperty(0 ,"trsp_mty_cost_mod_nm", {AcceptKeys:"E|N|[ `-=~!@#$%^&*()_+[]\\;',.{}|:\"?]" , InputCaseSensitive:1});
              SetColProperty(0 ,"scc_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});		//SJH.20141127.ADD, 20151209.MOD : AcceptKeys E->N,E
            }
            break;
    }
}
/**
 * Function to initialize the IBCOMBO <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
* @param {ibsheet} comboObj mandatory IBMultiCombo Object
* @param {int} comboNo mandatory  The order of the IBMultiCombo
 * @return nothing
 */ 
function initCombo(comboObj) {
     switch(comboObj.options.id) {
        case "f_cost_loc_grp_cd":
            with(comboObj) {
        		DropHeight = 300;
                SetSelectIndex(0);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
            }
            break;
       case "f_trd_cd":
            with(comboObj) {
    	   		DropHeight = 300;
                InsertItem(0, "All", "All");
                SetSelectIndex(0);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
            }
            break; 	            
        case "f_ecc_cd":
            with(comboObj) {
        		DropHeight = 300;
                InsertItem(0, "All", "All");
                SetSelectIndex(0);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
            }
            break;
       case "f_cntr_tpsz_cd":
            with(comboObj) {
    	   		DropHeight = 300;
                InsertItem(0, "All", "All");
                SetSelectIndex(0);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
            }
            break;           
    }
}
/**
 * Registering IBSheet Object as list
 * Calling from comSheetObject(id)
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source by.yjjeon
   */
  function setComboObject(combo_obj){
      comboObjects[comboCnt++]=combo_obj;
  } 
// window double click  //////////////////////////////////

/**
* Handling process about the sheet object MT ECC
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:    
            ComOpenWait(true);
            var sXml=formObj.sXml.value;      
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                ComXml2ComboItem(arrXml[0], f_cost_loc_grp_cd, "code", "name");
                ComCoaSetIBCombo(sheetObjects[0], arrXml[0], "cost_loc_grp_cd", true, 0);           
            }
            if (arrXml.length > 1) {
                ComXml2ComboItem(arrXml[1], f_trd_cd, "code", "code");
				ComCoaSetIBCombo(sheetObjects[0], arrXml[1], "trd_cd",true,0);
            }
            if (arrXml.length > 2) {
                ComXml2ComboItem(arrXml[2], f_ecc_cd, "code", "code");
//                ComCoaSetIBCombo(sheetObjects[0], arrXml[2], "scc_cd",true,0);		SJH.20141127.MOD
//                ComCoaSetIBCombo(sheetObjects[1], arrXml[2], "scc_cd",true,0);
            }
            if (arrXml.length > 3) {
                ComXml2ComboItem(arrXml[3], f_cntr_tpsz_cd, "code", "code");
				ComCoaSetIBCombo(sheetObjects[0], arrXml[3], "cntr_tpsz_cd",true,0);	
				ComCoaSetIBCombo(sheetObjects[1], arrXml[3], "cntr_tpsz_cd",true,0);
            }
            if (arrXml.length > 4) {
            	ComCoaSetIBCombo(sheetObjects[0], arrXml[4], "cntr_io_vol_sts_cd",true,0);
            }            
//            if (arrXml.length > 5) {		//SJH.20141125 : 나중 콤보이나 현재는 텍스트로..@@@
//            	ComCoaSetIBCombo(sheetObjects[1], arrXml[5], "trsp_mty_cost_mod_nm",true,0);
//            }
			
            ComSetObjValue(formObj.sXml, "");
            
            setYrMon();
            ComOpenWait(false);
            break;
            
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
            ComOpenWait(true);
            if(sheetObj.id == "sheet1"){     
            	sheetObjects[0].RemoveAll();
            	sheetObjects[1].RemoveAll();
                formObj.f_cmd.value=SEARCH01;
            } else if (sheetObj.id == "sheet2"){
            	sheetObjects[1].RemoveAll();
                formObj.f_cmd.value=SEARCH02;
            } else {
            	ComOpenWait(false);
            	return false;
            }
            sheetObj.DoSearch("ESM_COA_4003GS.do", coaFormQueryString(formObj) );
            EXCEL_VAL_FLG = false;
			EXCEL_LOAD_FLG = false;            
            ComOpenWait(false);
            break;
        
        //SJH.20150105.ADD
		case SEARCHLIST01:
			formObj.f_cmd.value=SEARCHLIST01;
			var sXml=sheetObj.GetSearchData("ESM_COA_4003GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_ecc_cd, "code", "code");
			initCombo(f_ecc_cd,f_ecc_cd.id);
			f_ecc_cd.SetSelectIndex(0);
			break;
             
        case IBSAVE:
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
        	
            ComOpenWait(true);
            
            if(sheetObj.id == "sheet1"){
                formObj.f_cmd.value=MULTI01;
            } else if (sheetObj.id == "sheet2"){
                formObj.f_cmd.value=MULTI02;
            } else {
            	return false;
            }
            sheetObj.DoSave("ESM_COA_4003GS.do", coaFormQueryString(formObj));
            EXCEL_VAL_FLG = false;
			EXCEL_LOAD_FLG = false;             
            ComOpenWait(false);
            break;

		case IBINSERT:	//Add row
			var row = sheetObj.DataInsert(-1);
			if (formObj.f_cost_yrmon.value != "")
				sheetObj.SetCellValue(row, "cost_yrmon", formObj.f_cost_yrmon.value);
			if(sheetObj.id == "sheet2") {
				var sRow = sheetObjects[1].SelectRow;
				if (sRow > 0) {
 	    			sheetObj.SetCellValue(row, "cost_yrmon", sheetObjects[1].GetCellValue(sRow, "cost_yrmon"));				
				}
			}	
			EXCEL_VAL_FLG = false;
			break;
  				
        case IBDOWNEXCEL:   // Excell download
        	//SJH.20141215.DEL
//			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
//				sheetObj.SetCellValue(i,"chg_status",sheetObj.GetCellValue(i,"ibflag"));
//			}  
        	var excelType = null;        	
        	if(sheetObj.id == "sheet1"){
        		excelType=selectDownExcelMethod(sheetObj, "0");
            } else if (sheetObj.id == "sheet2"){
            	excelType=selectDownExcelMethod(sheetObj, "1");
            } else {
            	return false;
            }           	
            break;
            
    	case IBLOADEXCEL:    		
    		//20150716.MOD/ADD/DEL
    		sheetObj.SetWaitImageVisible(0);
        	sheetObj.RemoveAll();
        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});        	
        	EXCEL_VAL_FLG = false;
			break;      
			
		case IBVALIDATION1:		
		case IBVALIDATION2:		
			if((parseInt(sheetObj.LastRow())+1) > parseInt(sheetObj.HeaderRows())) {							//20160325.ADD
				if(!validateForm(sheetObj,formObj,sAction)) return false;	
			}		
			break;
    }
}

/**
 * Handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: 	  		
		case IBSAVE: 	
			if(formObj.f_cost_yrmon.value.length == 0 && getIbComboObjValue(f_ecc_cd) == "") {
				ComShowMessage(ComGetMsg('COA10002','YYYY-MM or Location'));
	  			ComSetFocus(formObj.f_cost_yrmon);				//20150806.MOD
	  			return false;	
	  		}
	  		if(formObj.f_cost_yrmon.value.length > 0) {
	  	  		if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
	  	  			ComShowMessage(ComGetMsg('COM12180'));
	  	  			ComSetFocus(formObj.f_cost_yrmon);			//20150806.MOD
	  	  			return false;	
	  	  		}
	  		}
	  		if (sAction == IBSAVE) {
	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {	  				
	  				if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
			  	  		if(EXCEL_LOAD_FLG && sheetObj.GetCellValue(i, "ibflag") == "U") {
			  	  			ComShowMessage(ComGetMsg('COM12114','Status.\nWhen loading Excel [UPDATE] is not allowed.\n'));
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}				  	  	
		  	  		if(!EXCEL_VAL_FLG) {
	  					ComShowMessage(ComGetMsg('COA10071'));
		  	  			return false; 	
		  	  			break;
		  	  		}
	  	  			if (ComTrimAll(sheetObj.GetCellText(i, "remark")).length > 0) {
	  	  				ComShowMessage(ComGetMsg('COM12114','Remarks'));
		  	  			return false;	
		  	  			break;
	  	  			}	  	  		
		  	  	}
	  	  	}
	  		}
	  		return true;
	  		break;
	  		
		case IBVALIDATION1: 	
		case IBVALIDATION2:
			var sTitle = new Array();
			var keyCol = 0;
			var sMsg = new Array();
			
			//sheet1/sheet2 keyCol set
			if (sAction == IBVALIDATION1) keyCol = sheetObj.SaveNameCol("eff_fm_yrmon");
			else keyCol = sheetObj.SaveNameCol("trsp_mty_cost_mod_nm");		//SJH.20141127.MOD
			
			if(sheetObj.GetCellValue(i, "ibflag") != "" && sheetObj.GetCellValue(i, "ibflag") != "R") {				
	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	  				var remark = "";
	  				var rcheck = 0;  
	  				
	  				for ( var Col = 0 ; Col <= sheetObj.LastCol() ; Col++) {	  					
						//0--- title 설정
						if (i == sheetObj.HeaderRows()) {
							if (sheetObj.HeaderRows() < 2) {
								sTitle[Col] = sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ");
							} else {
	  						sTitle[Col] = sheetObj.GetCellValue(1, sheetObj.ColSaveName(Col)).replace("\n"," ");
	  						if (sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ") != sTitle[Col]) 
	  							sTitle[Col] = sheetObj.GetCellValue(0, sheetObj.ColSaveName(Col)).replace("\n"," ") + " " + sTitle[Col];	  								
							}
						}	  	
						if (Col > 2) {
							//1--- Keyfield Validation
							if (Col <= keyCol || sheetObj.ColSaveName(Col)=="cost_src_fm_yrmon" || sheetObj.ColSaveName(Col)=="cost_src_to_yrmon") {
		  						if (ComTrimAll(sheetObj.GetCellText(i, Col)).length == 0) {
		  							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellText(i, Col);
		  							rcheck++;
		  						} 	  								
							}
							if (sheetObj.GetCellValue(i, Col).length > 0 || sheetObj.GetCellText(i, Col).length > 0) {
		  						//2--- Combo Validation
		  						if (sheetObj.GetCellProperty(0, Col, "Type") == "Combo") {
		  							if (ComTrimAll(sheetObj.GetCellText(i, Col)).length > 0 && sheetObj.GetComboInfo(i, Col, "SelectedIndex") < 1) {
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellText(i, Col);
			  							rcheck++;		  								
		  							}
		  						}		  						
		  						//3--- Date Validation
		  						if (sheetObj.GetCellProperty(0, Col, "Format") == "Ym") {
		  							if (!ComIsDate(sheetObj.GetCellValue(i, Col), "ym")) {		
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellValue(i, Col);
			  							rcheck++;
		  							}
		  						}
								//4--- ssd_cd Validation, max 5, SJH.20141127.ADD	
								if(sheetObj.ColSaveName(Col)=="scc_cd") {
									if(sheetObj.GetCellValue(i, Col).length != 5) {
										remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[Col]+" ] : "+sheetObj.GetCellValue(i, Col)+" (Only 5 characters)";
										rcheck++;										
									}
								}							
							}	//END LENGTH > 0
						}
					}	//END FOR (COL)
					
					if (sAction == IBVALIDATION1) {
						//5--- sheet1 : Date Validation : fm_date > to_date
						if(parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) < parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon"))) {
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ Effective Month ] : "+
							         sheetObj.GetCellValue(i, "eff_fm_yrmon")+" > "+sheetObj.GetCellValue(i, "eff_to_yrmon")+" (End must be greater than start)";
							rcheck++;
						}
						//6--- sheet1 : Date Validation : fm_date or to_date가 구간사이에 속한 경우
	  					for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
	  						if (i != j &&
	  							sheetObj.GetCellValue(i, "cost_loc_grp_cd") == sheetObj.GetCellValue(j, "cost_loc_grp_cd") &&
	  							sheetObj.GetCellValue(i, "cntr_tpsz_cd") == sheetObj.GetCellValue(j, "cntr_tpsz_cd") &&
	  							sheetObj.GetCellValue(i, "trd_cd") == sheetObj.GetCellValue(j, "trd_cd") &&
	  							sheetObj.GetCellValue(i, "scc_cd") == sheetObj.GetCellValue(j, "scc_cd")) {
	  							if (sheetObj.GetCellValue(j, "eff_to_yrmon").length > 0) {		  								
		  							if (parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
		  								parseInt(sheetObj.GetCellValue(i, "eff_fm_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("eff_fm_yrmon")]+" ] : "+sheetObj.GetCellValue(i, "eff_fm_yrmon")+" (Check the overlapping period)";
		  								rcheck++;
		  							}
		  							if (parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_yrmon")) &&
		  								parseInt(sheetObj.GetCellValue(i, "eff_to_yrmon")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_yrmon"))) {
		  								remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("eff_to_yrmon")]+" ] : "+sheetObj.GetCellValue(i, "eff_to_yrmon")+" (Check the overlapping period)";
		  								rcheck++;
		  							}
	  							}
	  						}
	  					}
	  					//7-- sheet1 : max 100, SJH.20141125.ADD	  					
	  					if(sheetObj.GetCellValue(i, "mty_cost_tp_nm").length > 100) {
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ MT Cost Type ] : exceed 100 characters";
							rcheck++;
						}
	  					sMsg[0] = "cost_loc_grp_cd|cntr_tpsz_cd|trd_cd|scc_cd|eff_fm_yrmon|eff_to_yrmon";
	  					sMsg[1] = "Location Hierarchy|TP / SZ|Trade|Location|Effective From Month|Effective To Month";			  					
					} 				//END SHEET1 ERROR
					else {		
						//5--- sheet2 : org_nod_cd Validation : 5 or 7
						if(sheetObj.GetCellValue(i, "org_nod_cd").length > 0 && 
						   sheetObj.GetCellValue(i, "org_nod_cd").length != 5 && sheetObj.GetCellValue(i, "org_nod_cd").length != 7) {
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("org_nod_cd")]+" ] : "+sheetObj.GetCellValue(i, "org_nod_cd");
							rcheck++;
						}	
						//6--- sheet2 : dest_nod_cd Validation : 5 or 7
						if(sheetObj.GetCellValue(i, "dest_nod_cd").length > 0 && 
						   sheetObj.GetCellValue(i, "dest_nod_cd").length != 5 && sheetObj.GetCellValue(i, "dest_nod_cd").length != 7) {
							remark = remark + ((rcheck == 0) ? "" : ",\n") + "[ "+sTitle[sheetObj.SaveNameCol("dest_nod_cd")]+" ] : "+sheetObj.GetCellValue(i, "dest_nod_cd");
							rcheck++;
	  			        }
	  					sMsg[0] = "cntr_tpsz_cd|scc_cd|cost_src_fm_yrmon|cost_src_to_yrmon|org_nod_cd|dest_nod_cd|trsp_mty_cost_mod_nm";	//SJH.20150105.MOD  
	  					sMsg[1] = "TP / SZ|Location|Cost Source From|Cost Source To|ORIGIN|DESTINATION|Mode";								//SJH.20150105.MOD  						
					} 				//END SHEET2 ERROR
					
					sheetObj.SetCellValue(i, "remark", remark);
	  			}			//END FOR ROW
	  			
		  		//8--- dup check
				var dr = sheetObj.ColValueDup(sMsg[0]);					
				var sMsgArr = sMsg[0].split("|");	
				if(dr>0){
					if (sheetObj.GetCellValue(dr, "ibflag") != "D") {
						var drRmk = sheetObj.GetCellValue(dr, "remark");							
						drRmk = drRmk + ((drRmk.length == 0) ? "" : ",\n") + "[ "+sMsg[1]+" ] : ";
						for ( var k = 0; k < sMsgArr.length; k++) {
							drRmk = drRmk + sheetObj.GetCellValue(dr, sMsgArr[k])+((k == sMsgArr.length-1) ? "" : "|");
						}
						drRmk = drRmk +"(dup error)";
						rcheck++;
						sheetObj.SetCellValue(dr, "remark", drRmk);
					}
				}
			}				//END IBFLAG=U/I/D
			//SJH.20141127.MOD
			//ComShowMessage(ComGetMsg('COM12116','Validation'));
			EXCEL_VAL_FLG = true;
			if (rcheck > 0) return false;	  			
			break;
	}  		
	return true;
}

/**
 * Setting this month
 * setYrMon()
 *
 * @param NONE
 * @return NONE
 */
function setYrMon(){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        var nowYrMon=nowYear + nowMon;
        f_cost_yrmon.value=nowYrMon;
        f_cost_yrmon.dataformat="ym";
        isValidYYYYMM(f_cost_yrmon,true,'-',true);
        if(!ComAddSeparator(f_cost_yrmon)) return false;
    }
}

/**
* Search details with double clicking on sheet8
*/
function sheet1_OnDblClick(sheetObj , row, col){
	var formObject = document.form;
	formObject.f_view_tpsz.value = sheetObj.GetCellValue(row, "cntr_tpsz_cd");
	formObject.f_ecc_cd2.value = sheetObj.GetCellValue(row, "scc_cd");
	formObject.f_from.value = sheetObj.GetCellValue(row, "cost_src_fm_yrmon");
	formObject.f_to.value = sheetObj.GetCellValue(row, "cost_src_to_yrmon");	
	
	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH); 		
}

function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[excelType[1]];
	switch (excelType[0]) {
		case "AY":
			sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
		case "AN":
			sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;      						
		case "DY":
			sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
		case "DN":
			sheetObj.Down2Excel({DownCols:makeHiddenCoaSkipCol(sheetObj), SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
	} 
}

//DOWNEXCEL OPTION
function makeHiddenCoaSkipCol(sobj){ 
    var lc = sobj.LastCol();
    var rtnStr = "";
    for(var i=0;i<=lc;i++){
       if( ! ( sobj.GetCellProperty(0,i,"Type") == "Status" ||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" ) ){
          rtnStr += "|"+ i;
       }
    }
    return rtnStr.substring(1);
}

//LOADEXCEL OPTION
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
	ComOpenWait(false);									//20150716.MOD
	if(isExceedMaxRow(msg)) return;						//20150501.COMMON ADD
	
//	var sheetObj = sheetObjects[0];
	if ((sheetObj.LastRow()+sheetObj.HeaderRows()) >= 2000) {
		if(!ComShowCodeConfirm("COA10072", "2000", "\nDo you want to continue?")) {
			sheetObj.RemoveAll();
			return false;
		}
	}	
	onLoadExcel(code, sheetObj);
} 

function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
	ComOpenWait(false);									//20150716.MOD
	if(isExceedMaxRow(msg)) return;						//20150501.COMMON ADD
	
//	var sheetObj = sheetObjects[1];
	if ((sheetObj.LastRow()+sheetObj.HeaderRows()) >= 2000) {
		if(!ComShowCodeConfirm("COA10072", "2000", "\nDo you want to continue?")) {
			sheetObj.RemoveAll();
			return false;
		}
	}	
	onLoadExcel(code, sheetObj);
}

function onLoadExcel(code, sheetObj){
	var check = 0;	
	if (sheetObj.RowCount() > 0) {						//20150501.COMMON MOD
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i,"chg_status").substring(0,1).toUpperCase() == "D") {
				sheetObj.SetCellValue(i,"ibflag","");
				sheetObj.SetCellValue(i,"ibDel",1);
			}else if (sheetObj.GetCellValue(i,"chg_status").substring(0,1).toUpperCase() == "U" || 
					  sheetObj.GetCellValue(i,"chg_status").substring(0,1).toUpperCase() == "I") {
				sheetObj.SetCellValue(i,"ibflag", sheetObj.GetCellValue(i,"chg_status").substring(0,1).toUpperCase());
				sheetObj.SetCellValue(i,"bat_flg","");
			}else{
				sheetObj.SetCellValue(i,"ibflag","");
			}
			if (sheetObj.GetCellValue(i, "ibflag").toUpperCase() != "D") {
    			if (sheetObj.GetCellValue(i, "ibflag").toUpperCase() == "I") {
    				sheetObj.SetCellValue(i,"rt_seq","");
    			}        								
			}
			if(sheetObj.id == "sheet1" && sheetObj.GetCellValue(i,"chg_status").substring(0,1).toUpperCase() == "I") {
  				sheetObj.SetCellValue(i,"eff_to_yrmon","");
  			}			
		}
	}	
	EXCEL_LOAD_FLG = true;
	EXCEL_VAL_FLG = false;
}

//20150716.ADD
function sheet1_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}
function sheet2_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}

function sheet1_OnChange(sheetObj, Row, Col, value) {
    EXCEL_VAL_FLG = false;
}

function sheet2_OnChange(sheetObj, Row, Col, value){
	EXCEL_VAL_FLG = false;
}  	

//SJH.20141106.ADD
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if(ErrMsg == ""){
        // [COA10006] : The processes was completed
        ComShowMessage(ComGetMsg("COA10006"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}
//20150604.ADD
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    if(ErrMsg == ""){
        // [COA10006] : The processes was completed
        ComShowMessage(ComGetMsg("COA10006"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}
//SJH.20150105.ADD
function f_cost_loc_grp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (loadingMode == true)
		return;	
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if (comboObj.GetSelectText()!= "") {		
		 doActionIBSheet(sheetObj,formObj,SEARCHLIST01);
	}	
}