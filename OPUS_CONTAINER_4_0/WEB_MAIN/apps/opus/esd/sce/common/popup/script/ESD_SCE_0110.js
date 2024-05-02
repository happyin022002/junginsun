/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0110.jsp
*@FileTitle  : (RCC/LCC/ECC/SCC) Popup
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
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var dist=document.form.dist.value;
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1,dist);
		ComEndConfigSheet(sheetObjects[i]);
	}
//	document.all['seletad'].selectedIndex = document.form.f_slt_idx.value;
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
    	    case "btn_retrieve":
    	    	//if( validateForm(formObject) ){
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        //}
    	        break;
    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
//            case "btns_calendar1":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
//    	        break;
//
//    	    case "btns_calendar2":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
//    	        break;
            case "btn_close":
            	ComClosePopup(); 
    	        break;
			case "btn_ok":
				PopupOK(sheetObject, formObject);
			    break;
			case "btn_bkg_calendar":
				var cal=new calendarPopupFromTo();
				cal.displayType="date";
				cal.select(formObject.sdate, 'sdate',formObject.edate, 'edate', 'yyyy-MM-dd');
				break ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,dist) {		
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
                with (sheetObj) {
	        	var HeadTitle = "";
	            
	        	if(dist=="rcc"){
	            	HeadTitle="|SEQ|RCC Code" ;
	            }else if(dist=="lcc"){
	            	HeadTitle="|SEQ|LCC Code" ;
	            }else if(dist=="ecc"){
	            	HeadTitle="|SEQ|ECC Code" ;
	            }else if(dist=="scc"){
	            	HeadTitle="|SEQ|SCC Code" ;
	            }
	
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	            if(dist=="rcc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="lcc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="ecc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="scc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"scc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }
	       
	            InitColumns(cols);
	
	            SetEditable(1);
//	            SetSheetHeight(200);
	            resizeSheet();
            
         }
            break;
        case 9:      //IBSheet1 init
            with (sheetObj) {
        		var HeadTitle;
	            if(dist=="rcc"){
	            	HeadTitle="|SEQ|RCC Code" ;
	            }else if(dist=="lcc"){
	            	HeadTitle="|SEQ|LCC Code" ;
	            }else if(dist=="ecc"){
	            	HeadTitle="|SEQ|ECC Code" ;
	            }else if(dist=="scc"){
	            	HeadTitle="|SEQ|SCC Code" ;
	            }
	
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	            if(dist=="rcc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"rcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="lcc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="ecc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"ecc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }else if(dist=="scc"){
	            	cols.push({Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"scc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	            }
	       
	            InitColumns(cols);
	
	            SetEditable(1);
	            SetSheetHeight(200);
   
           }
            break;
    }
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value=SEARCH03;
			//delHypen(formObj.sdate);
			//delHypen(formObj.edate);
			//alert("SceFrmQryString(formObj)-->"+SceFrmQryString(formObj));
			sheetObj.DoSearch("ESD_SCE_0110GS.do", SceFrmQryString(formObj) );
			break;
	   case IBDOWNEXCEL:       
		   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		  break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(formObj){
    with(formObj){
    	/*--
 	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
  	        ComShowMessage("You must input period");
  	        if(formObj.sdate.value=="" || !chkDateValue(formObj.sdate.value) )  {
  	          //setFocus(formObj.sdate);
  	          formObj.sdate.focus() ;
  	          return false;
  	        }
  	        if(formObj.edate.value=="" || !chkDateValue(formObj.edate.value) ) {
  	          //setFocus(formObj.edate);
  	          formObj.edate.focus() ;
  	          return false;
  	        }
  	    }
  	    if( formObj.seletad.value == "ETA" ){
	  	    if(formObj.selpod.value=="") {
	  	        ComShowMessage("You must input POD");
	  	        //setFocus(formObj.selpod);
	  	        formObj.selpod.focus() ;
	  	        return false;
	  	    }
  	    } else{
	  	    if(formObj.selpol.value=="") {
	  	        ComShowMessage("You must input POL");
	  	        //setFocus(formObj.selpol);
	  	        formObj.selpol.focus() ;
	  	        return false;
	  	    }
  	    }
  	    --*/
  	    if(formObj.selvvd.value != null && formObj.selvvd.value != "") {
  	    	if(formObj.selvvd.value.length != 9) {
      	        ComShowMessage("VVD must be 9 characters");
      	        setFocus(formObj.selvvd);
      	        return false;
      	    }
  	    }
  	    if(formObj.sellane.value != null && formObj.sellane.value != "") {
  	    	if(formObj.sellane.value.length != 3) {
      	        ComShowMessage("Lane must be 3 characters");
      	        setFocus(formObj.sellane);
      	        return false;
      	    }
  	    }
    }
    return true;
}
function PopupOK(sheetObj, formObject){
	var rcc_val="";	
	var lcc_val="";
	var rows=sheetObj.LastRow() + 1;
	var iCheckRow=sheetObj.CheckedRows("check");
	var dist=sheetObj.ColSaveName(2);
	var opener=window.dialogArguments;
	if(rows==1 && iCheckRow == 0) {
		return null;
	}else if(rows > 1 && iCheckRow == 0) {
		ComShowMessage("Please check row") ;
		return null;
	}
	else {
		var ik=0;
  		if(dist=="rcc_cd"){
			for(var i=0; i < rows; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				rcc_val=sheetObj.GetCellValue(i, "rcc_cd");
		  			} else {
		  				rcc_val=rcc_val + "," + sheetObj.GetCellValue(i, "rcc_cd");
	                }
	                ik++;
	     		}
	  		}
		}else if(dist=="lcc_cd"){
			for(var i=0; i < rows; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				lcc_val=sheetObj.GetCellValue(i, "lcc_cd");
		  			} else {
		  				lcc_val=lcc_val + "," + sheetObj.GetCellValue(i, "lcc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}else if(dist=="ecc_cd"){
			for(var i=0; i < rows; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				ecc_val=sheetObj.GetCellValue(i, "ecc_cd");
		  			} else {
		  				ecc_val=ecc_val + "," + sheetObj.GetCellValue(i, "ecc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}else if(dist=="scc_cd"){
			for(var i=0; i < rows; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				scc_val=sheetObj.GetCellValue(i, "scc_cd");
		  			} else {
		  				scc_val=scc_val + "," + sheetObj.GetCellValue(i, "scc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}							
  	}
  	if(dist=="rcc_cd"){
  	  	opener.rtn_rcc_code(rcc_val);
  	}else if(dist=="lcc_cd"){
   	  	opener.rtn_lcc_code(lcc_val); 	  	  	   	  	
  	}else if(dist=="ecc_cd"){
   	  	opener.rtn_ecc_code(ecc_val); 	  	  	   	  	
  	}else if(dist=="scc_cd"){
   	  	opener.rtn_scc_code(scc_val); 	  	  	   	  	
  	}
  ComClosePopup(); 
}

function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 
/*
 * 
function selectVSLEVNT(evt){
  //alert("evt:"+evt);
if(evt=="ETA"){
   document.all['seletad'].selectedIndex=0;
   document.form.f_slt_idx.value=0;
}else{
   document.all['seletad'].selectedIndex=1;
   document.form.f_slt_idx.value=1;
}
             ComConfigSheet(sheetObjects[0]);
            initSheet(sheetObjects[0],1,evt);
            ComEndConfigSheet(sheetObjects[0]);
}
 * */
