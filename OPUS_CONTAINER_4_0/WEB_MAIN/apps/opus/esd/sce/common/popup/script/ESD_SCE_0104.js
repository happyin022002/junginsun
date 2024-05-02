/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0104.js
*@FileTitle  : Common Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE :  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var selCol=0;
var selOfc="";
var sheet_height = 10;
   /**
    * registering IBSheet Object as list
    * ComSheetObject(id) from Call
    * adding process for list in case of needing batch processing with other items
    * defining list on the top of source
    */
   function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
   }
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var sheetNum=0;
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if( formObject.selection[0].checked) {
			sheetObject=sheetObjects[0];
			sheetObj=sheetObjects[0];
			sheetNum=0;
		} else {
			sheetObject=sheetObjects[1];
			sheetObj=sheetObjects[1];
			sheetNum=1;
		}
        switch(srcName) {
		//minestar
			case "selection":
				if( formObject.selection[0].checked) {
					document.getElementById("location").style.display="";
					document.getElementById("node").style.display="none";
				} else if( formObject.selection[1].checked) {
					document.getElementById("node").style.display="";
					document.getElementById("location").style.display="none";
				}
				break;
			case "btn_ok" :
				getChkedVl( sheetObject, sheetNum);
				ComClosePopup(); 
				break;
    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH , sheetNum);
    	        break;
    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
            case "btn_close":
            	ComClosePopup(); 
    	        break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function getChkedVl( sheetObject, sheetNum) {
	var chkCnt=sheetObj.CheckedRows(0) ;
	if( chkCnt==0 ) {
		ComShowMessage(ComGetMsg('COM12113', 'Location')) ;
		return false ;
	}
	var chkRows=sheetObj.FindCheckedRow(0) ;
	var arrChkRows=chkRows.split("|") ;
	var loc_cd="";
	if( sheetNum ==0) {
		loc_cd=sheetObj.GetCellValue(arrChkRows[0], "loc_cd");
	} else {
		if(document.form.modeVal.value=="zone"){
			loc_cd=sheetObj.GetCellValue(arrChkRows[0], "zn_cd");
		}else {
			loc_cd=sheetObj.GetCellValue(arrChkRows[0], "yd_cd")
		}
	}
	var opener=window.dialogArguments;
	opener.getSelectedValue ( loc_cd);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObject,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
      case 1:      //IBSheet1 init
    	  with (sheetObject) {
	          var HeadTitle="||No|Location|Name|Conti|Sub Conti|Region|Country|State|SCC|ECC|LCC|RCC|Control Office|Port" ;
	
	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_state",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"loc_eq_ofc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"loc_port_ind",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	           
	          InitColumns(cols);
	
	          SetEditable(1);
//	          SetSheetHeight(ComGetSheetHeight(sheetObject,sheet_height));
	          resizeSheet();
            }
            break;
      case 2:      //IBSheet1 init
        with (sheetObject) {
	          var HeadTitle="";
	          HeadTitle="||SEQ|Node Code|Node Name|Ctrl Office|Postal Code|District|Street|Address|vndr_cnt_cd|loc_cd";
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	          if(document.form.modeVal.value == "zone") {
		          cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"zn_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"zn_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          } else {
		          cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yd_fcty_tp_mrn_tml_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yd_fcty_tp_cy_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd_fcty_tp_cfs_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		          cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"yd_fcty_tp_rail_rmp_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	          }
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnt_cd" });
	          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"loc_cd" });
	  
	          InitColumns(cols);
	
	          SetEditable(1);
	          SetSheetHeight(ComGetSheetHeight(sheetObject,sheet_height));
        }
        break;
    }
}
/* handling sheet process */
function doActionIBSheet(sheetObject,formObj,sAction, sheetNum) {
//	sheetObject.ShowDebugMsg(false);
	var target ;
	if( sheetNum == 0) {
		formObj.cnt_cd.value=formObj.cnt_cd_1.value;
		formObj.loc_cd.value=formObj.loc_cd_1.value;
		target="COM_ENS_051GS.do";
	} else if ( sheetNum == 1) {
		formObj.cnt_cd.value=formObj.cnt_cd_2.value;
		formObj.loc_cd.value=formObj.loc_cd_2.value;
		target="COM_ENS_061GS.do";
	}
	switch(sAction) {
		case IBSEARCH:	
			if(!validateForm(sheetObject,formObj,sAction, sheetNum)) {
	        	return false;
			}
			formObj.f_cmd.value=SEARCH;
			selectVal=SceFrmQryString(formObj)
			sheetObject.DoSearch(target, selectVal );
			break;
		case IBSEARCHAPPEND:  
	    	formObj.f_cmd.value=SEARCHLIST;
	    	sheetObject.DoSearch(target, selectVal+"&"+ "iPage=" + PageNo,{Append:true} );
	        break;
	}
}
function validateForm(sheetObject, formObj, sAction, sheetNum) {
	return true;
}
function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj=document.form ;
    if (sheetObj.RowCount()>= OnePageRow && sheetObj.GetTotalRows()> sheetObj.RowCount()){
    	selectVal=SceFrmQryString(formObj);
    	formObj.f_cmd.value=SEARCH;
		PageNo=Math.ceil(sheetObj.SearchRows()/OnePageRow)+1;
		//alert(OnePageRow);
		//alert(PageNo);
		formObj.cnt_cd.value=formObj.cnt_cd_1.value;
		formObj.loc_cd.value=formObj.loc_cd_1.value;
		target="COM_ENS_051GS.do";
		sheetObj.DoSearch("target", selectVal+"&"+ "iPage=" + PageNo,{Append:true} );
    }
}
function sheet2_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
		var formObj=document.form ;
    if (sheetObj.RowCount()>= OnePageRow && sheetObj.GetTotalRows()> sheetObj.RowCount()){
    	selectVal=SceFrmQryString(formObj);
    	formObj.f_cmd.value=SEARCH;
		PageNo=Math.ceil(sheetObj.SearchRows()/OnePageRow)+1;
		//alert(OnePageRow);
		//alert(PageNo);
		formObj.cnt_cd.value=formObj.cnt_cd_2.value;
		formObj.loc_cd.value=formObj.loc_cd_2.value;
		target="COM_ENS_061GS.do";
		sheetObj.DoSearch("target", selectVal+"&"+ "iPage=" + PageNo,{Append:true} );
    }
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 