/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0077.jsp 
*@FileTitle  : Selection USIOR COLUMN
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
// Common global variable
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
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
        	    	var coldesc1='';    //return Exception Inquiry
        	    	var coldesc2='';    //to save
        	    	for(var a=0 ; a < chkcnt ; a++){
        	    		chkrow=sheetObject.FindCheckedRow(0).split('|')[a];
        	    		if(a == 0){
        	    			coldesc1=sheetObject.GetCellValue(chkrow, "coldesc1");
        	    		}else{
        	    			coldesc1=coldesc1 + ',' + sheetObject.GetCellValue(chkrow, "coldesc1");
        	    		}
        	    	}
        	    	for(var t=1 ; t <= sheetObject.GetTotalRows(); t++){
        	    		if(t == 0){
        	    			coldesc2=sheetObject.GetCellValue(t, "cbox");
        	    		}else{
        	    			coldesc2=coldesc2 + sheetObject.GetCellValue(t, "cbox");
        	    		}
        	    	}
        	    	//alert("coldesc1:"+coldesc2);
        	    	//document.form.title1.value = iCheckRow;
        	    	//document.form.title2.value = coldesc2;
        	    	formObject.save_list.value=coldesc2;
                    doActionIBSheet(sheetObject,formObject,IBSAVE);       
                    //alert("coldesc1:"+coldesc1+" \n chkcnt:"+chkcnt+" \n iCheckRow:"+iCheckRow); 	  
                    var opener=window.dialogArguments;
        	    	opener.addColDesc(coldesc1, chkcnt, iCheckRow);
        	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
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
                with(sheetObj){
               // (3, 0, 0, true);
              var HeadTitle="CHK|SEQ|COLUMN NAMES|COLUMN NAMES" ;

              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cbox",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"coldesc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
//              SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
              resizeSheet();
                    }


                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //
                formObj.f_cmd.value=SEARCHLIST;
   		var sXml=sheetObj.GetSearchData("ESD_SCE_0077GS.do",SceFrmQryString(formObj));
  		// XML Doc Object Creation
  		try {
  		  // IE			
			  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			  xmlDoc.async="false";
			  xmlDoc.loadXML(sXml);
		}catch(E){
		  try {//Firefox, Mozilla, Opera, etc.
			  parser=new DOMParser();
			  xmlDoc=parser.parseFromString(sXml,"tet/xxml");
		  }catch(E){
			  alert(e.message);
			  return;
		  }
		}
		//var newXmlDoc=xmlDoc.cloneNode(true);
		//alert(newXmlDoc.xml);
		//alert(xmlDoc.xml);
  		var dataXml=xmlDoc.getElementsByTagName("DATA");
  		var rowXml=xmlDoc.getElementsByTagName("TR");
  		var headerSep="|";
  		var total=dataXml[0].getAttribute("TOTAL");
  		//if(parseInt(total) < 1)	return;
  		var newData="<SHEET>";
		newData += "<DATA TOTAL='34'>";
		var vals="";
  		if(parseInt(total) > 0)
  		{	
	  		dataSep=dataXml[0].getAttribute("COLSEPARATOR");
	  		d_row=dataXml[0].getAttribute("COLORDER").split(headerSep);
			c_row=rowXml[0].childNodes[0].nodeValue.split(dataSep);
	  		for( var j=0; j < d_row.length; j++ ) {
				if(d_row[j]=="all_col"){
					vals=c_row[j];
					break;
				}
			}
        }
  		else 
  		{
  			vals="1111111111111111111111111111111111";
  		}
		// Column Desc Array
		var colDesc=
			new Array("Exception No.",
					  "BKG No",
					  "Container No.",
					  "B/L No.",
					  "COP No.",
					  "Exception Type",
					  "Exception Type Detail",
					  "Exception Status",
					  "Exception Reason",
					  "Shipper",
					  "Consignee",
					  "Notify",
					  "VVD",
					  "POR",
					  "POL",
					  "POD",
					  "DEL",
					  "Occurred Date/Time",
					  "Occurred Office",
					  "Occurred Node",
					  "Resolved Date",
					  "Delay Time",
					  "From Activity",
					  "From Estimated Date/Time",
					  "From Actual Date/Time",
					  "From Updated Date/Time",
					  "To Activity",
					  "To Estimated Date/Time",
					  "To Actual Date/Time",
					  "To Updated Date/Time",
					  "Confirm",
					  "Confirm ID",
					  "Confirm Date",
					  "Remark"
					  );
		//alert(vals.length);
		for(var i=0; i<vals.length; i++){
			newData += "<TR>"; 	
			newData += "<TD>";
			newData += vals.charAt(i);
			newData += "</TD>";
			newData += "<TD></TD>";
			newData += "<TD>";
			newData += colDesc[i];
			newData += "</TD>";
			newData += "</TR>"; 	
		}		
		newData += "</DATA>"; 	
		newData += "</SHEET>"; 
  		if (newData != "") sheetObj.LoadSearchData(newData,{Sync:1} );
                //sheetObj.DoSearch4Post("ESD_SCE_0077GS.do", SceFrmQryString(formObj));
           break;
           case IBSAVE:
                formObj.f_cmd.value=MODIFY01;
                sheetObj.DoAllSave("ESD_SCE_0077GS.do", SceFrmQryString(formObj));
           break;
        }
    }
    function openColumnList(){
    	var formObject=document.form;
    	var edi_grp_cd=toUpperCase(formObject.cs_grp_id.value);
    	window.open ("ESD_SCE_0077.do?edi_grp_cd=" + edi_grp_cd , "list", "scrollbars=no,fullscreen=no,width=765,height=450");
    }
    function resizeSheet(){ // auto-sizing
	    ComResizeSheet(sheetObjects[0]);
}  
