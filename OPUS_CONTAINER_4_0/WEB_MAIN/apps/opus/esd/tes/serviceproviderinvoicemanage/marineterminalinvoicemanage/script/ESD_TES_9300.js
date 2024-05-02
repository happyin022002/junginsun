/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9300.js
*@FileTitle  : Office Hierarchy Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObj=sheetObjects[0];
         var sheetObj1=sheetObjects[1];
         var formObj=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_apply":
         	        var sRow=sheetObj.FindCheckedRow("chk1");
         	        var arrRow=sRow.split("|");
         	        var doc_rtn="";
         	        var src_ofc="";
         	        
         	        if(sRow == ""){
         	            ComShowMessage("Please input the 'S/O Office'!!");
         	        }
         	        for( var i=0; i < arrRow.length; i++ ) {
         	        	
         	        	doc_rtn=doc_rtn + doSepRemove(sheetObj.GetCellValue(arrRow[i], "ofc_cd_name"), " ")+",";
         	        }
         	        
         	        doc_rtn=doc_rtn.substring(0, doc_rtn.length-1);
         	        if(formObj.incl_sub.checked == true){
         	            formObj.src_ofc.value=doc_rtn;
         	            doActionIBSheetHidden(sheetObj1, formObj, IBSEARCH);
         	            doc_rtn=sheetObj1.GetCellValue(1,'etc');
         	        }
         	        
         	        eval( "window.parent.document.form."+formObj.param_nm.value+".value='"+doc_rtn+"';" );
         	        ComClosePopup(); 
         	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506'));
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
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet init
                with (sheetObj) {
                var HeadTitle="Seq|Sel.|STS|Office code";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
                    {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);//Edit[Option,Defaultfalse]
                SetSheetHeight(280);
			}
			break;
            case 2:
                with (sheetObj) {
                var HeadTitle="DATA";
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"etc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
						}
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:	  //Retrieve
                formObj.f_cmd.value=SEARCH;
                var searchXml=sheetObj.GetSearchData("ESD_TES_9300GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
                break;
        }
    }
    function sheet_OnSearchEnd(sheetObj,errMsg){
    	if(errMsg!=null&&errMsg!=0){
    		ComShowMessage(errMsg);
    	}
    	var lv_ofc=document.form.ofc_cd.value;
    	var lv_row=sheetObj.FindText("ofc_cd", lv_ofc, 0, -1, false);
    	sheetObj.SelectCell(lv_row, "ofc_cd_name", false);
    }
    function doActionIBSheetHidden(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg(false);
        switch(sAction){
            case IBSEARCH:
            formObj.f_cmd.value=SEARCH01;
            var searchXml=sheetObj.GetSearchData("ESD_TES_9300GS.do", tesFrmQryStr(formObj));
            if (searchXml != "") sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
        }
    }
    function doSepRemove(obj, sep) {
    	var ch="";
    	var lvobj="";
    	for(var i=0; i<obj.length; i++) {
    		if(obj.charAt(i) == sep) {
    			ch="";
    		} else {
    			ch=obj.charAt(i);
    		}
    		lvobj=lvobj + ch;
    	}
    	return lvobj;
    }
