/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_028.js
*@FileTitle : Cost Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/

// Common variables.
var comboObjects=new Array();
var comboCnt=0 ;
var sheetObjects=new Array();
var sheetCnt=0;
/* Defining button events. */
document.onclick=processButtonClick;
/**
 * Handling button event.
 * @return
 */
function processButtonClick(){
     /***** Setting each tab's sheet variable. *****/
     var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;
			case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('TES21025'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet object on sheetObjects array.
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj; 
}
 /**
  * Register combo object on array.
  * @param {combo}	combo_obj	combo
  * @return
  */
 function setComboObject(combo_obj){
     comboObjects[comboCnt++]=combo_obj;
 }  
/**
 * Coding event handler for body tag's OnLoad.
 * Add  pre-process functions after loading by browser.
 * @return
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);;
    }
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    doActionIBSheet1(sheetObjects[1],document.form,IBSEARCH);     
}
/**
 * Initialize sheets.
 * param : sheetObj, sheetNo
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
            
          var HeadTitle="Seq.|Cost Code|Full Name|Update Date" ;

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"lgs_cost_opt_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:1,    Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:1,    Align:"Left",    ColMerge:0,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(0);
          //no support[check again]CLT style.height=GetSheetHeight(10);
          SetSheetHeight(ComGetSheetHeight(sheetObj, 10));   
                }
            break;                 
        case 2:      //sheet1 init
            with(sheetObj){

          var HeadTitle="Seq.|Cost Code|Full Name|Update Date" ;

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(0);
          SetSheetHeight(ComGetSheetHeight(sheetObj, 10)); 
                }
            break;                 
    }
}
 /**
  * Coding retrieve, save...
  * @param {sheet}	sheetObj	ibsheet
  * @param {form}	formObj		form object
  * @param {int}	sAction		f_cmd
  * @return
  */
function doActionIBSheet(sheetObj, formObj, sAction) {	
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      // retrieve
            //formObj.f_cmd.value = COMMAND01;
         	  //sheetObj.DoSearch4Post("ESD_TES_028Combo.do", tesFrmQryStr(formObj), "",isAppend);  
             //if(validateForm(sheetObj,formObj,sAction))
            formObj.f_cmd.value=SEARCH; 
            sheetObj.DoSearch("ESD_TES_0028GS.do", tesFrmQryStr(formObj) );
            break;
      case COMMAND01:
            formObj.f_cmd.value=SEARCH01;               
            sheetObj.DoSearch("ESD_TES_0028Combo.do", tesFrmQryStr(formObj) );
            break;
    }
}
/**
 * Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		f_cmd
 * @return
 */    
function doActionIBSheet1(sheetObj,formObj,sAction) {	
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      // retrieve
            formObj.f_cmd.value=SEARCH01;
        	sheetObj.DoSearch("ESD_TES_0028Combo.do", tesFrmQryStr(formObj) );
            break;
      case COMMAND01:
            formObj.f_cmd.value=SEARCH01;               
            sheetObj.DoSearch("ESD_TES_0028Combo.do", tesFrmQryStr(formObj) );
            break;
    }
}     
/**
 * Coding event for OnClick.
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			The cell's Row Index
 * @param {int}		Col			The cell's Column Index
 * @param {string}	Value
 * @return
 */
function sheet1_OnClick (sheetObj , row , col, Value )
{
var sText=sheetObj.GetCellValue(row , "lgs_cost_rmk");
var sDel_flag=sheetObj.GetCellValue(row , "delt_flg");
	document.form.txtEvent.value=sText;
	if(sDel_flag=="Y"){
		document.form.del_flg_y.checked=false;         	
		document.form.del_flg_n.checked=true;	
	}
	else if(sDel_flag=="N"){            
		document.form.del_flg_y.checked=true;
		document.form.del_flg_n.checked=false;		
	}
}
/**
 * Coding event for OnSearchEnd.
 * @param {sheet}	sheetObj
 * @param {string}	ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj,code,errMsg){     	
    if(errMsg!=null ){
        ComShowMessage(errMsg);
    }
    var catevalue=sheetObj.GetEtcData("extp_cate_list");
    var tpvalue=sheetObj.GetEtcData("extp_tp_list");
    for(p=0;p< comboObjects.length;p++){   
     	if (document.form.command_h.value  == ""){
        initCombo (comboObjects[p],p+1, catevalue, tpvalue);
      }else if (document.form.command_h.value  == "S"){
        	initCombo (comboObjects[p],p+1, "", tpvalue);
      } 
    }        
    ComEtcDataToForm(document.form, sheetObj);
}
/**
 * Initialize combo.
 * @param {combo object}	comboObj	combo
 * @param {int}				comboNo		combo index
 * @param {string}			catevalue	Subject Code combo data
 * @param {string}			tpvalue		Detail Code combo data
 * @return
 */
function initCombo (comboObj, comboNo,catevalue, tpvalue) {
	var cnt=0 ;
	var cateArray=catevalue.split("|");         
	var tpArray=tpvalue.split("|");
	var test1="FF";
	var valueArray;
	var time;
    switch(comboNo) {
    	case 1:
        if(cateArray.length >1){
        	comboObj.RemoveAll();
        	with (comboObj) {
        		InsertItem(cnt++, 'ALL' + '|' +'', ' ');
			    for(i=0 ;i<cateArray.length;i++){
			    	valueArray=cateArray[i].split("--");                
					if(valueArray[0] !=""){			                              
						InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]); 
					}			                            
			    } 
        	}
        }			    	  
        break;
        case 2:
        comboObj.RemoveAll();
        with (comboObj) {
        	SetColAlign(0, "left");
        	SetColWidth(0, "90");
			InsertItem(cnt++, 'ALL' + '|' +'', ' ');	            
			for(i=0 ;i<tpArray.length;i++){
				valueArray=tpArray[i].split("--");			               	
				if(valueArray[0] !=""){			               	             	                         
					InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]); 
				}
			}
			comboObjects[1].SetSelectCode(document.form.lgs_cost_subj_cd1.value );
		}
        break;
   	}
	comboObjects[1].SetSelectCode(document.form.lgs_cost_dtl_cd1.value );
}
var cnt=0;
/**
 * Coding event for OnChange.
 * @param {combo object}	comObj		Subject Code combo
 * @param {string}			text
 * @return
 */
function lgs_cost_subj_cd_OnChange(comboObj, OldIxd, OldTxt, OldCod, NewIdx, NewTxt, NewCod)
{
   //document.form.cost_code_sc.value = comObj.Code;
   document.form.lgs_cost_subj_cd.value=comboObj.GetSelectCode();
   document.form.command_h.value="S"; 
       doActionIBSheet(sheetObjects[1], document.form, COMMAND01);	  
    } 
/**
 * Coding event for OnBlur.
 * @param {combo object}	comObj		Subject Code combo
 * @return
 */
function lgs_cost_subj_cd_OnBlur(comObj)
{
     var finded=comObj.FindItem(comObj.GetSelectCode() , 0);
    ///ComShowMessage(comObj.Text());
    comObj.SetSelectCode(finded);
   if(finded!=-1){
    	 doActionIBSheet(sheetObjects[1], document.form, COMMAND01);	 
   }else{        	
    	comObj.SetSelectCode("");
  }         
} 
 /**
  * Coding event for OnChange.
  * @param {combo object}	comObj
  * @param {string}			text
  * @return
  */     
function lgs_cost_dtl_cd_OnChange(comboObj, OldIxd, OldTxt, OldCod, NewIdx, NewTxt, NewCod)
{
    //document.form.cost_code_dc.value = comObj.Code; 
   document.form.lgs_cost_dtl_cd.value=comboObj.GetSelectCode();
   //document.form.command_h.value = "S"; 
}  
