/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4012.js
*@FileTitle  : Pendulum Service Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/10/01
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
     * @class ESM_COA_4012 : ESM_COA_4012 Business script for the UI
     */
  var sheetObjects=new Array();
  var sheetCnt=0; 
  var comboObjects=new Array();
  var comboCnt=0;
  var loadingMode=false;
  //20151126.ADD
  var selRow=0;
  var selValue="";

document.onclick=processButtonClick;

function processButtonClick(){

    var costLocGrpCdCombo=comboObjects[0];
    var formObject=document.form;
    
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
			case "btns_calendar1":
				var cal=new ComCalendar();
				cal.select(formObject.f_from_dt, 'yyyy-MM-dd');
				break;   
			case "btns_calendar2":
				var cal=new ComCalendar();
				cal.select(formObject.f_to_dt, 'yyyy-MM-dd');
				break;				
            case "btn_Retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
                
            case "btn_Save1":
            	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);                
                break;					
				
            case "btn_Rowadd1":
                doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
                break;	
                
			case "btn_DownExcel1":				
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
		
            case "btn_Detail":
                if(sheetObjects[0].RowCount()>0){
                	sheet1_OnDblClick(sheetObjects[0], sheetObjects[0].GetSelectRow(), 0);
                } else {
                     ComShowMessage(ComGetMsg('COA10005','Sheet1'));
                }
                break;
                
            case "btn_Save2":
            	doActionIBSheet(sheetObjects[1],formObject,IBSAVE);                
                break;
				
            case "btn_Rowadd2":
                doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
                break;
                
			case "btn_DownExcel2":				
				doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				break;
				
            case "btn_creation":
            	doActionIBSheet(sheetObjects[1],formObject,IBCREATE);                
                break;	
                
			case "btn_ApplytolaneTt":	    //Apply To Lane Transit-time 
				var strUrl="ESM_COA_4013.do";
				ComOpenPopup(strUrl, '380', '260', '', '0,0', true);
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
        if (comboObjects[k].options.id == "f_slan_cd") comboObjects[k].SetBackColor("#CCFFFD");		//20151126.ADD
    } 
    loadingMode=false;
}   

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    sheetObj.UseUtf8=true;
    var cnt=0;    
    switch(sheetNo) {
        case 1: //sheet1 init
            with(sheetObj){
         	  var HeadTitle = "Del.|STS|VVD|From|To|Service Lane|Direction";
			  
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
              
              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);
              
              var cols = [
       		             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibDel" },
      		             {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },      
      		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9, InputCaseSensitive:1, AcceptKeys:"N|E" },
      		             {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:8 },
			             {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:8 },
			             {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                     
              InitColumns(cols);
                     
			  SetEditable(1);	//Editkind[optional,Defaultfalse]
  		      SetWaitImageVisible(0);
  		      SetSheetHeight(150) ;
  		      SetColProperty(0 ,"scc_cd", {AcceptKeys:"E" , InputCaseSensitive:1});		//SJH.20141127.ADD
            }
            break;
            
        case 2: //sheet9 init
        	with(sheetObj){
			    var aryCd=null;
			    var aryCnt=0;	    
			    var hdCode=document.form.f_header.value;		    
			    var HeadTitle="Del.|STS|||||Yard";			    
			    
				if(hdCode != '') {
					aryCd=hdCode.split("|");
					aryCnt=aryCd.length;					
					for(var k=0; k<aryCnt; k++) {
						HeadTitle=HeadTitle + "|" + aryCd[k] ;
					}
				}
	    	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	    	    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	    InitHeaders(headers, info);  
	    	    
	    	    var cols = [
	    		             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibDel" },
	    		             {Type:"Status",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },     
	    		             {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",      KeyField:1,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",    KeyField:1,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:8 },
	    		             {Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",    keyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:8 },
	    		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:7 } ];
	    	    
				for(var k=0; k<aryCnt; k++){
					cols.push({Type:"Float",    Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:aryCd[k].toLowerCase(),       KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
				}
	    	    InitColumns(cols);	
	    	    SetEditable(1);	//Editkind[optional,Defaultfalse]
	    	    SetWaitImageVisible(0);
	    	    SetSheetHeight(250) ;
	    	    SetColProperty(0 ,"yd_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
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
       case "f_slan_cd":           
       case "f_dir_cd":
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
                ComXml2ComboItem(arrXml[0], f_slan_cd, "code", "name");
                ComCoaSetIBCombo(sheetObjects[0], arrXml[0], "slan_cd", true, 0);           
            }
            if (arrXml.length > 1) {
                ComXml2ComboItem(arrXml[1], f_dir_cd, "code", "code");
				ComCoaSetIBCombo(sheetObjects[0], arrXml[1], "dir_cd",true,0);
            }
            ComSetObjValue(formObj.sXml, "");
            
            setYmd();
            ComOpenWait(false);
            break;
            
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
            ComOpenWait(true);
            if(sheetObj.id == "sheet1"){     
            	sheetObjects[0].RemoveAll();
            	sheetObjects[1].RemoveAll();            	
                formObj.f_cmd.value=SEARCH01;
                sheetObj.DoSearch("ESM_COA_4012GS.do", coaFormQueryString(formObj) );
                ComOpenWait(false);                
            } else if (sheetObj.id == "sheet2"){
            	sheetObjects[1].RemoveAll();
            	                formObj.f_cmd.value=SEARCH02;
	            var sXml=sheetObj.GetSearchData("ESM_COA_4012GS.do", coaFormQueryString(formObj));
	            var headCode=ComGetEtcData(sXml,'headCode');
	            
	            if (headCode != "") {
	            	formObj.f_header.value = headCode;
	            	
	                sheetObjects[1].SetVisible(0);
	                sheetObjects[1] = sheetObjects[1].Reset();
	                ComConfigSheet(sheetObjects[1]);
	                
	                initSheet(sheetObjects[1], 2);
	                
	                sheetObjects[1].SetVisible(1);
	                sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	                sheetObjects[1].RemoveEtcData(); // Delete ETC data
	            }
	            ComOpenWait(false);	            
            } else {
            	ComOpenWait(false);
            	return false;
            }
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
            sheetObj.DoSave("ESM_COA_4012GS.do", coaFormQueryString(formObj));        
            ComOpenWait(false);
            break;

		case IBINSERT:	//Add row
			var formObject=document.form;
			
			var row = sheetObj.DataInsert(-1);
			if(sheetObj.id == "sheet2"){
  				sheetObj.SetCellValue(row,"slan_cd", formObject.f_selslane.value.toUpperCase());
  				sheetObj.SetCellValue(row,"dir_cd", formObject.f_seldir.value.toUpperCase());
  				sheetObj.SetCellValue(row,"eff_fm_dt", formObject.f_from.value.toUpperCase());
  				sheetObj.SetCellValue(row,"eff_to_dt", formObject.f_to.value.toUpperCase());
			}
			break;
  				
        case IBDOWNEXCEL:   // Excell download
        	var excelType = null;        	
        	if(sheetObj.id == "sheet1"){
        		excelType=selectDownExcelMethod(sheetObj, "0");
            } else if (sheetObj.id == "sheet2"){
            	excelType=selectDownExcelMethod(sheetObj, "1");
            } else {
            	return false;
            }           	
            break;
            
        case IBCREATE:
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
            if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                ComOpenWait(true);
                
                setTimeout( function () {
                	formObj.f_cmd.value=MULTI03;
                    var sParam = sheetObj.GetSaveString(1);
                    if (sheetObj.IsDataModified() && sParam == "") return;
                    sParam = sParam + "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveData("ESM_COA_4012GS.do", sParam );
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
            }
            break;
            
        case IBBATCH: 
//			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
            if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                ComOpenWait(true);
                
                setTimeout( function () {
                	formObj.f_cmd.value=MULTI04;
                    var sParam = sheetObj.GetSaveString(1);
                    if (sheetObj.IsDataModified() && sParam == "") return;
                    sParam = sParam + "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveData("ESM_COA_4012GS.do", sParam );
    	            sheetObj.LoadSaveData(sXml, {Sync:1});
                    
                    var err_cd = ComGetEtcData(sXml, "err_cd");
                    var err_msg = ComGetEtcData(sXml, "err_msg");	                        
    	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
    	                return false;
    	            }	                
                    if (err_cd == "00000") {
                        ComShowMessage(ComGetMsg('COA10018','Apply to Lane Transit-time')); 
                    } else {
                        ComShowMessage("["+err_cd+"]:"+err_msg);
                    }
                    sheetObj.SetEtcData("err_cd","");
                    sheetObj.SetEtcData("err_msg","");
                    
                    ComOpenWait(false);
                }, 100);
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
		//필수
		if(formObj.f_from_dt.value.length == 0 && getIbComboObjValue(f_slan_cd) == "") {		//20151126.ADD
			ComShowMessage(ComGetMsg('COA10002','Period or Service Lane'));
  			ComSetFocus(formObj.f_from_dt);
  			return false;	
  		}		
  		if(formObj.f_from_dt.value.length > 0) {
  	  		if(!ComIsDate(formObj.f_from_dt , "ymd")){
  	  			ComShowMessage(ComGetMsg('COM12180'));
  	  			ComSetFocus(formObj.f_from_dt);
  	  			return false;	
  	  		}
  		}
  		if(formObj.f_to_dt.value.length > 0) {
  	  		if(!ComIsDate(formObj.f_to_dt , "ymd")){
  	  			ComShowMessage(ComGetMsg('COM12180'));
  	  			ComSetFocus(formObj.f_to_dt);
  	  			return false;	
  	  		}
  		}  		
  		if(sheetObj.id == "sheet2"){
  			if(formObj.f_selslane.value.length == 0 || formObj.f_seldir.value.length == 0 || formObj.f_from.value.length == 0) {
  				ComShowMessage(ComGetMsg('COA10026','the first sheet data.'));
  	  			return false;	
  	  		}
  		}
  		if (sAction == IBSAVE) {
  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
  				if(sheetObj.GetCellValue(i, "ibflag") != "" && sheetObj.GetCellValue(i, "ibflag") != "R") {
  					//필수값
  					if (ComTrimAll(sheetObj.GetCellText(i, "slan_cd")).length == 0) {
  						if(sheetObj.id == "sheet1"){
  	  						ComShowMessage(ComGetMsg('COA10002','Service Lane'));
  	  						sheetObj.SelectCell(i, "slan_cd");  
  						} else {
  							ComShowMessage(ComGetMsg('COA10026','the first sheet data.'));
  						}							
  				  		return false;
  					}
  					if (ComTrimAll(sheetObj.GetCellText(i, "dir_cd")).length == 0) {
  						if(sheetObj.id == "sheet1"){
  	  						ComShowMessage(ComGetMsg('COA10002','Direction'));
  	  						sheetObj.SelectCell(i, "dir_cd"); 
  						} else {
  							ComShowMessage(ComGetMsg('COA10026','the first sheet data.'));
  						} 							
  				  		return false;
  					}
  					if (ComTrimAll(sheetObj.GetCellText(i, "eff_fm_dt")).length == 0) {
  						if(sheetObj.id == "sheet1"){
  	  						ComShowMessage(ComGetMsg('COA10002','Effective From Date'));
  	  						sheetObj.SelectCell(i, "eff_fm_dt");
  						} else {
  							ComShowMessage(ComGetMsg('COA10026','the first sheet data.'));
  						}
  						return false;
  					}				
  					//sheet1
  					if(sheetObj.id == "sheet1") {
  						if(sheetObj.GetCellValue(i, "ibflag") != "D") {
  							//Date Validation : fm_date or to_date가 구간사이에 속한 경우
  							for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
  								if (i != j &&
  									sheetObj.GetCellValue(i, "slan_cd") == sheetObj.GetCellValue(j, "slan_cd") &&
  									sheetObj.GetCellValue(i, "dir_cd") == sheetObj.GetCellValue(j, "dir_cd")) {
  									if (sheetObj.GetCellValue(j, "eff_to_dt").length > 0) {		  								
  			  							if (parseInt(sheetObj.GetCellValue(i, "eff_fm_dt")) >= parseInt(sheetObj.GetCellValue(j, "eff_fm_dt")) &&
  			  								parseInt(sheetObj.GetCellValue(i, "eff_fm_dt")) <= parseInt(sheetObj.GetCellValue(j, "eff_to_dt"))) {
  			  								ComShowMessage("Check the Overlapping period.");
  			  								sheetObj.SetCellFontColor(i, "eff_fm_dt","#FF0000");
  			  								sheetObj.SelectCell(i, "eff_fm_dt");
  			  					  			return false;	
  			  							}
  									}
  								}
  							}  	  						
  						}
  					//sheet2
  					} else {
  						//필수값, 20151209.MOD
  						if (ComTrimAll(sheetObj.GetCellText(i, "yd_cd")).length < 7) {
  							ComShowCodeMessage('COA10067', 'Yard', '7');//'{?msg1} must be {?msg2} characters long.'
  							sheetObj.SelectCell(i, "yd_cd");  							
  					  		return false;
  						}
  			  			var dr=sheetObj.ColValueDup("yd_cd");
  						if(dr>0){//duplication		
  							ComShowCodeMessage('COM12115', "[ Yard ]");
  							sheetObj.SelectCell(dr,"yd_cd");
  							return false;
  						}
  						//100% 여야 함. 20151126.MOD
  						if (sheetObj.GetCellValue(dr, "ibflag") != "D") {
  	  						var rto_total = 0;
  	  						for ( var Col = parseInt(sheetObj.SaveNameCol("yd_cd"))+1 ; Col <= sheetObj.LastCol() ; Col++) {	
  	  							rto_total = ComRound(rto_total,2)+ComRound(sheetObj.GetCellText(i, Col),2);				//20151215.MOD : 정확한 산식을 위해..
  	  						}
  	  						if (rto_total != 1) {  	  							
  	  							ComShowMessage("Total Pendulum Ratio is should be 100%.");
  	  							sheetObj.SelectCell(i, sheetObj.SaveNameCol("yd_cd")+1);
  	  							return false;
  	  						}  							
  						}
  					}				
  				}				//END IBFLAG=U/I/D  				
  			}	
  		}  		
  		break;
	}
  		
//	case IBCREATE:
  		
  		return true;
}

/**
 * Setting this month
 * setYmd()
 *
 * @param NONE
 * @return NONE
 */
function setYmd(){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        var nowDay=ComGetNowInfo("dd");        
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        if ( nowDay.length == 1 ) nowDay="0" + nowDay; // conversion : 1day -> 01day         
        var nowYmd = nowYear + nowMon + nowDay; 
        f_from_dt.value=nowYmd;
        f_from_dt.dataformat="ymd";
        if(!addDateDash(f_from_dt)) f_from_dt.value = "";    
    }
}

/**
* Search details with double clicking on sheet8
*/
function sheet1_OnDblClick(sheetObj, row, col){
	var formObject = document.form;
	formObject.f_from.value = sheetObj.GetCellValue(row, "eff_fm_dt");
	formObject.f_to.value = sheetObj.GetCellValue(row, "eff_to_dt");	
	formObject.f_selslane.value = sheetObj.GetCellValue(row, "slan_cd");
	formObject.f_seldir.value = sheetObj.GetCellValue(row, "dir_cd");
	
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

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {	
	var formObject = document.form;
//	document.getElementById("btn_ApplytolaneTt").disabled = true;		//20151201.MOD
	document.getElementById("btn_creation").disabled = true;
	document.getElementById("btn_Rowadd2").disabled = true;
	document.getElementById("btn_Save2").disabled = true;
	document.getElementById("btn_DownExcel2").disabled = true;
	formObject.f_from.value = "";
	formObject.f_to.value = "";
	formObject.f_selslane.value = "";
	formObject.f_seldir.value = "";
}
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {	
	var formObject=document.form;	
//	document.getElementById("btn_ApplytolaneTt").disabled = false;		//20151201.MOD
	document.getElementById("btn_creation").disabled = false;
	document.getElementById("btn_Rowadd2").disabled = false;
	document.getElementById("btn_Save2").disabled = false;
	document.getElementById("btn_DownExcel2").disabled = false;
	for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {		
		sheetObj.SetCellValue(i,"slan_cd", formObject.f_selslane.value.toUpperCase());
		sheetObj.SetCellValue(i,"dir_cd", formObject.f_seldir.value.toUpperCase());
		sheetObj.SetCellValue(i,"eff_fm_dt", formObject.f_from.value.toUpperCase());
		sheetObj.SetCellValue(i,"eff_to_dt", formObject.f_to.value.toUpperCase());
		sheetObj.SetCellValue(i,"ibflag", "");
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
	var dupChk = sheetObj.GetEtcData("dup_chk");
	
	if((dupChk == "S"||dupChk=="")&&(ErrMsg == "")){
		ComShowMessage(ComGetMsg("COA10006"));
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}else if(dupChk == "Dup"){
//		ComShowCodeMessage('COM12115', '[ Service Lane, Direction, From ]');
		ComShowMessage("Check the Overlapping period.");
	}else{
		ComShowMessage(ComGetMsg("COM132101"));
	}
}

function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	
	//Creation만 제외!!
	if(formObj.f_cmd.value != MULTI03) {
	    if(ErrMsg == ""){
	        // [COA10006] : The processes was completed
	        ComShowMessage(ComGetMsg("COA10006"));
	    }else{
	        ComShowMessage(ComGetMsg("COM132101"));
	    }			
	}
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}

//20151126.ADD
function sheet1_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var param="";
	with(sheetObj) {
		if (ColSaveName(Col) == "vvd_cd") {
			selRow=Row;
			selValue=Value;			
			if(GetCellValue(selRow,"dir_cd") != "" && selValue != "" ) {
				if(GetCellValue(selRow,"dir_cd") != selValue.substring(selValue.length-1)) {
					alert("VVD's Last Element is not the same as Dir.");
					SetCellValue(selRow,"vvd_cd","",0);
					return false;						
				}
			}				
			param=param+"f_cmd="+SEARCHLIST02;
			param=param+"&vvd_cd="+sheetObj.GetCellValue(Row,Col);
			param=param+"&code=etdDt";
			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
			getEdtDate(etdDt);
		}
		if (ColSaveName(Col) == "eff_fm_dt" || ColSaveName(Col) == "eff_to_dt") {        			
			selRow=Row;
			if(GetCellValue(selRow,"eff_fm_dt") != "" && GetCellValue(selRow,"eff_to_dt") != "" ) {
				if ( parseInt(GetCellValue(selRow, "eff_fm_dt")) > parseInt(GetCellValue(selRow,"eff_to_dt")) ) {
		  	 		alert("From Date is greater than To Date.");
		  	 		SetCellValue(selRow,"eff_to_dt","",0);
					ComOpenWait(false);
					return false;
				}
			} 
		}
	}
}

//20151209.ADD
function sheet2_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	with(sheetObj) {		
		if (ColSaveName(Col) == "yd_cd" && sheetObj.GetCellValue(Row, "yd_cd")=="XXXXXXX") {  
		    var aryCd=null;
		    var aryCnt=0;			
		    var hdCode=document.form.f_header.value;
		    var sumRT=0;
			if(hdCode != '') {
				aryCd=hdCode.split("|");
				aryCnt=aryCd.length;
			}		
			keyCol = sheetObj.SaveNameCol("yd_cd");
			for ( var Co = keyCol+1 ; Co <= sheetObj.LastCol() ; Co++) {
				if(Co==sheetObj.LastCol()) {
					sheetObj.SetCellValue(Row, Co, 1-sumRT);
				} else {
					sheetObj.SetCellValue(Row, Co, ComRound(1 / aryCnt, 2));
					sumRT = sumRT+ComRound(1 / aryCnt, 2);
				}
			}
		}
	}
}

//20151126.ADD
function getEdtDate(result) {
	if(result == null || result == "" || result == "null"){
		ComShowMessage(ComGetMsg('COA10076',selValue));  //msg1 + 'is invalid VVD or has no ETD'
		sheet1.SelectCell(selRow,"vvd_cd",true);
	} else {
		sheet1.SetCellValue(selRow,"eff_fm_dt",result);
	}
}