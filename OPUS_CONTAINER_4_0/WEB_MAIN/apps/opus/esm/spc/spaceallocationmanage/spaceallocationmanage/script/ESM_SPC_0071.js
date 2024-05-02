/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0071.js
*@FileTitle  : SKD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
    var ipageNo=1 ;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var selectVal;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /*  Event handler processing by button name */
        function processButtonClick(){
        	/***** setting additional sheet value in case of more 2 sheet per tab *****/
        	var sheetObject=sheetObjects[0];
        	/*******************************************************/
        	var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
        		switch(srcName) {
            	    case "btn_retrieve":
            	    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
        			ComShowCodeMessage("COM12111");
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
         * adding first-served functions after loading screen
         */
        function loadPage() {
        	for(i=0;i<sheetObjects.length;i++){
        		// change the name of start environment setting funtion
        		ComConfigSheet(sheetObjects[i]);
        		initSheet(sheetObjects[i],i+1);
        		// Adding last environment setting funtion
        		ComEndConfigSheet(sheetObjects[i]);
        	}
        	// Retrieving automatically in case of inputing VVD
        	var sheetObject=sheetObjects[0];
        	var formObject=document.form;
        	var vvd=formObject.vvd.value;
        	if(vvd != null && vvd.length == 9) {
        		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	}
        }
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
        	var cnt=0;
        	switch(sheetNo) {
        	    case 1:      //IBSheet1 init
        	        with(sheetObj){
			        	      var HeadTitle="SEQ|VESSEL|VOYAGE|DIR|CALLING_IND|PORT|YARD|S.LANE|ETA DATE|ETD DATE|T.IND|C.IND" ;
			
			        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			        	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			        	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        	      InitHeaders(headers, info);
			
			        	      var cols = [ {Type:"Text",      Hidden:0,  Width:27,   Align:"Center",  ColMerge:0,   SaveName:"cltp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:77,   Align:"Center",  ColMerge:0,   SaveName:"cltp_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"turn_port_ind_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cng_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			        	       
			        	      InitColumns(cols);
			        	      SetEditable(1);
//			        	      SetSheetHeight(400);
			        	      resizeSheet()
        	           }

        	     break;
        	}
        }
       // Handling the process related with sheet
        function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        	sheetObj.ShowDebugMsg(false);
        	switch(sAction) {
        	    case IBSEARCH:      //Retrieve
        	    	if(!validateForm(sheetObj,formObj,sAction)) {
        	    		return false;
        	    	}
        	    	formObj.f_cmd.value=SEARCHLIST;
        	    	var param=SpcFormString(formObj,'vvd');
        	    	sheetObj.DoSearch("ESM_SPC_0071GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param );
        	    	break;
        	}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
        		if(formObj.vvd.value=="") {
        			ComShowMessage("You must input VVD");
        			formObj.vvd.focus();
        			return false;
        		}
        		if(formObj.vvd.value.length < 9) {
        			ComShowMessage("VVD must be 9 characters");
        			formObj.vvd.focus();
        			return false;
        		}
        	}
        	return true;
        }
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }