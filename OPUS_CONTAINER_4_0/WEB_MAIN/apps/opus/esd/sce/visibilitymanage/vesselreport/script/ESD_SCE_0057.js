///*=========================================================
//*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
//*@FileName : ESD_SCE_0057.jsp
//*@FileTitle : USIOR COLUMN Select Item pop-up screen
//*@author     : CLT
//*@version    : 1.0
//*@since      : 2014/07/31
//=========================================================*/
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         var opener=window.dialogArguments;
         if (!opener) opener=parent;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;
        	    case "btn_ok":
                    var chkcnt=sheetObject.CheckedRows(0);
                    var iCheckRow=sheetObject.FindCheckedRow(0);
        	    	if(chkcnt < 1){
        	    		ComShowMessage('Please select at least one.');
        	    		return false;
        	    	}
        	    	var chkrow=0;
        	    	var coldesc1='';
        	    	var coldesc2='';
        	    	var visibilities='';
        	    	for(var a=0 ; a < chkcnt ; a++){
        	    		chkrow=sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			coldesc1=sheetObject.GetCellValue(chkrow, "coldesc1");
        	    			coldesc2=sheetObject.GetCellValue(chkrow, "coldesc2");
        	    		}else{
        	    			coldesc1=coldesc1 + ',' + sheetObject.GetCellValue(chkrow, "coldesc1");
        	    			coldesc2=coldesc2 + ',' + sheetObject.GetCellValue(chkrow, "coldesc2");
        	    		}
        	    	}
        	    	for(var t=2 ; t < sheetObject.RowCount()+2; t++){
//        	    		if(t == 2){
//        	    			visibilities=sheetObject.GetCellValue(t, "chk");
//        	    		}else{
        	    			visibilities=visibilities + sheetObject.GetCellValue(t, "chk");
//        	    		}
        	    	}
        	    	formObject.save_list.value=visibilities;
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
        	    	opener.addColDesc(coldesc1, coldesc2, chkcnt, iCheckRow);
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
    /**
     * registering IBSheet Object as list
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
 			for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			}
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			setXmlData();
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo,etdeta) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                var HeadTitle1="CHK|SEQ|COLUMN NAMES1|COLUMN NAMES2" ;
                var HeadTitle2="CHK|SEQ|COLUMN NAMES1|COLUMN NAMES2" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"coldesc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"coldesc2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetEditable(1);
//                SetSheetHeight(200);
                resizeSheet();
               }
                break;
        } 
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:                 
                formObj.f_cmd.value=SEARCH05;   
                //var defaultVal="1111111111111111111111111111111111111111111111111111111111111111111111";
                var defaultVal="11111111111111111111111111111111111111111111111111111111111111111111111111";
                var sXml=sheetObj.GetSearchData("ESD_SCE_0057GS.do",SceFrmQryString(formObj));
                var vals=ComGetEtcData(sXml, "ALL_COL");
                if(vals == undefined || vals == "") vals=defaultVal;
                makeSheetData(sheetObj,vals);
           break;
           case IBSAVE:
               formObj.f_cmd.value=MULTI;
               sheetObj.DoAllSave("ESD_SCE_0057GS.do", SceFrmQryString(formObj));
          break;
        }
    }
    function makeSheetData(sheetObj,vals) {
    	var len=vals.length;
    	var newData="<SHEET><DATA TOTAL='"+len+"'>";
		// Column Desc Array
		var colDesc=
			new Array(
					"BKG",
					"Container",
					"324 edi Status",
					"324 EDI Send Date/Time",
					"B/L",
					"Unmatch List",
					"BKG",
					"BKG",
					"COP",
					"COP",
					"TY/SZ",
					"MVMT",
					"MVMT Yard",
					"MVMT DT",
					"DUP",
					"VVD",
					"Lane",
					"ETA",
					"SPE",
					"Rail DEST",
					"CSTMS\nCLR LOC",
					"EQ Office",
					"Term",
					"Add",
					"S/P",
					"S/P",					
					"Rail Plan",
					"Rail1",
					"Rail1",
					"Truck(Door)\nPlan",
					"Truck (Door)",
					"Truck (Door)",
					"DR_WK",
					"DR_FM",
					"DR_TO",
					"DR_S/P",
					"DR_S/P Name",
					"Truck(Shuttle)\nPlan",
					"Truck (Shuttle)",
					"Truck (Shuttle)",
					"Truck(Additional)\nPlan",
					"Truck (Additional)",
					"Truck (Additional)",
					"COP Status",
					"From",
					"Guide",
					"P/UP Node",
					"AVL Date",
					"Free Date",
					"F",
					"O",
					"C",
					"CM",
					"P/UP NO.",
					"P/UP Office",
					"P/UP End",
					"S/C NO.",
					"CNEE",
					"CNEE Address",
					"SHPR",
					"SHPR Address",
					"NTFY",
					"NTFY Address",
					"Filer",
					"IT NO.",
					"IT Date",
					"PO NO.",
					"Seal NO.",
					"Weight",
					"CLM",
					"CLM",
					"CLM",
					"CLM",
					"Remark",
					"Internal Hold",
					"Internal Hold"
					  );
		// Column Desc Array
		var colDesc2=
			new Array(
					"BKG",
					"Container",
					"324 edi Status",
					"324 EDI Send Date/Time",
					"B/L",
					"Unmatch List",
					"POD",
					"DEL",
					"POD",
					"DEL",
					"TY/SZ",
					"MVMT",
					"MVMT Yard",
					"MVMT DT",
					"DUP",
					"VVD",
					"Lane",
					"ETA",
					"SPE",
					"Rail DEST",
					"CSTMS\nCLR LOC",
					"EQ Office",
					"Term",
					"Add",
					"S/P Code",
					"S/P Name",							
					"Rail Plan",
					"S/O",
					"W/O",
					"Truck(Door)\nPlan",
					"S/O",
					"W/O",
					"DR_WK",
					"DR_FM",
					"DR_TO",
					"DR_S/P",
					"DR_S/P Name",
					"Truck(Shuttle)\nPlan",
					"S/O",
					"W/O",
					"Truck(Additional)\nPlan",
					"S/O",
					"W/O",
					"COP Status",
					"From",
					"Guide",
					"P/UP Node",
					"AVL Date",
					"Free Date",
					"F",
					"O",
					"C",
					"CM",
					"P/UP NO.",
					"P/UP Office",
					"P/UP End",
					"S/C NO.",
					"CNEE",
					"CNEE Address",
					"SHPR",
					"SHPR Address",
					"NTFY",
					"NTFY Address",
					"Filer",
					"IT NO.",
					"IT Date",
					"PO NO.",
					"Seal NO.",
					"Weight",
					"CLM Status",
					"CLM Location",
					"ST",
					"CLM Date",
					"Remark",
					"Flag",
					"Remark"
					  );
		for(var i=0; i<colDesc.length; i++){
			newData += "<TR>";
			newData += "<TD>";
			newData += vals.charAt(i);
			newData += "</TD>";
			newData += "<TD></TD>";
			newData += "<TD>";
			newData += colDesc[i];
			newData += "</TD>";
			newData += "<TD>";
			newData += colDesc2[i];
			newData += "</TD>";
			newData += "</TR>"; 	
		}		
		newData += "</DATA>"; 	
		newData += "</SHEET>"; 
  		if (newData != "") sheetObj.LoadSearchData(newData,{Sync:1} );
    }
    function openColumnList(){
    	var formObject=document.form;
    	var edi_grp_cd=toUpperCase(formObject.cs_grp_id.value);
    	window.open ("ESD_SCE_0057.do?edi_grp_cd=" + edi_grp_cd , "list", "scrollbars=no,fullscreen=no,width=765,height=450");
    }
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 