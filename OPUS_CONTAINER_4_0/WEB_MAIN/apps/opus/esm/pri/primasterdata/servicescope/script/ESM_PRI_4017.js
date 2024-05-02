/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4017.js
*@FileTitle  : Service Scope Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2]; 
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;
        	
        	switch(srcName) {
        		case "btn_retrieve":
        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_new":
                	formObject.org_cd.value="";
                	formObject.dest_cd.value="";
                	sheetObject1.RemoveAll();
                	sheetObject2.RemoveAll();
                	sheetObject3.RemoveAll();
                	sheetObject4.RemoveAll();
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch (sheetObj.id) {
        	case "sheet1":
        		with(sheetObj){
                
              
        			var HeadTitle="Scope|Description|FMC File|Tariff No|Conference|Bound|Update Date";

        			SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fmc_file_flg",    KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",          KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"conf_flg",        KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_bnd_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];
               
        			InitColumns(cols);

        			SetEditable(0);
        			SetWaitImageVisible(0);
        			SetAutoRowHeight(0);
        			SetSheetHeight(140);
        		}
        		break;
        	case "sheet2":
        		with(sheetObj){               
              
	              var HeadTitle="Lane|Description";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
	               
	              InitColumns(cols);
	              SetEditable(0);
	              SetWaitImageVisible(0);
	              SetAutoRowHeight(0);
	              SetSheetHeight(120);
        		}
        		break; 
        	case "sheet3":
        		with(sheetObj){
                
              
        			var HeadTitle="Origin Region|Description|Service Scope Indicator";

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rgn_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rgn_nm",           KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"svc_scp_ind_flg",  KeyField:0,   CalcLogic:"",   Format:"" } ];
               
        			InitColumns(cols);

        			SetEditable(0);
        			SetWaitImageVisible(0);
        			SetAutoRowHeight(0);
        			SetSheetHeight(120);
        		}
        		break;   
        	case "sheet4":
        		with(sheetObj){
                
              
        			var HeadTitle="Destination Region|Description|Service Scope Indicator";

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rgn_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rgn_nm",           KeyField:0,   CalcLogic:"",   Format:"" },
        			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"svc_scp_ind_flg",  KeyField:0,   CalcLogic:"",   Format:"" } ];
               
        			InitColumns(cols);

        			SetEditable(0);
        			SetWaitImageVisible(0);
        			SetAutoRowHeight(0);
        			resizeSheet();//SetSheetHeight(120);      
        		}
        		break;
        	case "sheet5":
        		with(sheetObj){

        			SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
        			var headers = [ { Text:"", Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
               
        			InitColumns(cols);
        			resizeSheet();//SetSheetHeight(120);
        		}
        		break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[2]); ComResizeSheet(sheetObjects[3]); }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:
    			ComOpenWait(true);
    			if(!validateForm(sheetObj,formObj,sAction)) {
    				ComOpenWait(false);
    				return false;
    	  		}
    	  		formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT     	  		
    	  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj) );
                break;
    		case IBSEARCH_ASYNC01:
    			ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
		  			return false;
		  		}
var svcScpCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "svc_scp_cd");
		  		formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT 		  		
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd );
	            break;
    		case IBSEARCH_ASYNC02:
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
		  			return false;
		  		}
var svcScpCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "svc_scp_cd");
		  		formObj.f_cmd.value=SEARCH03;
//parameter changed[check again]CLT 		  		
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd+"&org_dest_cd=O" );
	            break;
    		case IBSEARCH_ASYNC03:
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
					return false;
		  		}
var svcScpCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "svc_scp_cd");
		  		formObj.f_cmd.value=SEARCH03;
//parameter changed[check again]CLT 		  		
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd+"&org_dest_cd=D" );
		  		ComOpenWait(false);
	            break;
    	}
   	}
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
 		}
 	}   
    /**
     * calling function when occurring OnClick Event <br>
     * showing memopad when clicking desc cell (MemoPad editable)<br>
     */ 
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
 	}
  	/**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	
  	function sheet2_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
 			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
 		}
 	}
  	/**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	
  	function sheet3_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
 			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC03);
 		}
 	}
    /**
 	 * loading HTML Control event in the page <br>
 	 * initializing IBSheet Object calling from {@link #loadPage} function <br>
 	 */
  	function initControl() {
  		DATE_SEPARATOR="/";
  		//Axon event handling 1. event catch
  		axon_event.addListenerForm('blur', 'obj_blur', form);
  		axon_event.addListenerForm('change', 'obj_change', form);
  		axon_event.addListenerForm('keypress', 'obj_keypress', form);
  		//AS-IS : axon_event.addListener('keydown', 'getKeyEnter', 'form');
  		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
  	}
 	/**
     * HTML tag (Object)'s onKeyDown event can calling this function, when pressing Enter key handling automatic transaction <br>
     * <br>
     * sFlag = not setting : handling same as sFlag="Search"<br>
     * sFlag = "Search"          : when clicking enter key, handling like clicking retrieve button. calling from OnKeyDown !<br>
     * sFlag = "NextFocus"       : when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
     * sFlag = "LengthNextFocus" : when inputed maxlength, changing next focus automatically. when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
     * sFlag = Function naming string  : getting Function naming string and clicking enter key, calling relevant function. calling from OnKeyDown !<br>
     * sFlag = "LengthNextFocus" should be called from OnKeyUp event, all remainders should be called from OnKeyDown event<br>
     */
    function getKeyEnter(sFlag)
    {
      	var formObj=document.form;
       	try {
       		var keyValue=null;
           	if(event == undefined || event == null) {
           		keyValue=13;
           	} else {
           		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
           	}
           	if (keyValue != 13) return;
       		var obj=document.getElementById("btn_retrieve");
       		if (obj == null) obj=document.getElementById("btn_retrieve");
       		if (obj) obj.fireEvent("onclick");
         } catch(err) { ComFuncErrMsg(err.message); }
    }
  	/**
     * calling function when occurring OnBlur event <br>
     * prohibiting input date < current data <br>
     */
 	function obj_blur(){
 		srcName=event.srcElement.name;
 		srcValue=event.srcElement.value;
 		formObj=document.form;
 		if(srcValue == "") {
 			return;
 		}
 		switch(srcName) {
 			case "org_cd":
 				if(formObj.org_tp_cd.value != "S") {
 					if(srcValue.length == 2) {
 						formObj.org_tp_cd.value='C';
 					}else if(srcValue.length == 3) { 
 						formObj.org_tp_cd.value='R';
 					} else if(srcValue.length == 5) {
 						formObj.org_tp_cd.value='L';
 					}
 				}
 				formObj.f_cmd.value=SEARCH04;
		  		formObj.cd.value=formObj.org_cd.value;
//parameter changed[check again]CLT 		  		
		  		sXml=sheetObjects[4].GetSearchData("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=O");
		  		if(ComGetEtcData(sXml, "FLAG") == "N") {
		  			formObj.org_cd.value="";
		  			formObj.org_cd.focus();
		  		} else {
		  			formObj.dest_cd.focus();
		  		}
 				break;
 			case "dest_cd":
 				if(formObj.dest_tp_cd.value != "S") {
 					if(srcValue.length == 2) {
 						formObj.dest_tp_cd.value='C';
 					}else if(srcValue.length == 3) { 
 						formObj.dest_tp_cd.value='R';
 					} else if(srcValue.length == 5) {
 						formObj.dest_tp_cd.value='L';
 					}
 				}
 				formObj.f_cmd.value=SEARCH04;
		  		formObj.cd.value=formObj.dest_cd.value;
//parameter changed[check again]CLT 		  		
		  		sXml=sheetObjects[4].GetSearchData("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=D");
		  		if(ComGetEtcData(sXml, "FLAG") == "N") {
		  			formObj.dest_cd.value="";
		  		}
 				break;
 		}
 	}
 	/** 
	 * Object's OnChange event handler <br>
	 * initializing code  <br>
	 */ 
 	function obj_change(){
 		srcName=event.srcElement.name;
 		srcValue=event.srcElement.value;
 		formObj=document.form;
 		switch(srcName) {
 			case "org_tp_cd":
 				formObj.org_cd.value="";
 				break;
 			case "dest_tp_cd":
 				formObj.dest_cd.value="";
 				break;
 		}		
 	}
 	/** 
	 * handling OnKeyPress events <br>
	 * handling process for input validation by object's dataformat   <br>
	 */ 
  	function obj_keypress() {
  		 switch (event.srcElement.name) {
  			case "org_cd":
  				ComKeyOnlyAlphabet('upper');
  				break;
  			case "dest_cd":
  				ComKeyOnlyAlphabet('upper');
  				break;
  		}
  	}
	/**
     * checking Origin Code, Destination Code's validation <br>
     */
 	function checkOriDestCd(){
    	var formObj=document.form;
    	var orgCd=formObj.org_cd.value; 
    	var destCd=formObj.dest_cd.value;
		if(formObj.org_tp_cd.value != "S") {
			if(orgCd.length == 2) {
				formObj.org_tp_cd.value='C';
			}else if(orgCd.length == 3) { 
				formObj.org_tp_cd.value='R';
			} else if(orgCd.length == 5) {
				formObj.org_tp_cd.value='L';
			}
		}
		formObj.f_cmd.value=SEARCH04;
  		formObj.cd.value=orgCd;
//parameter changed[check again]CLT   		
  		sXml=sheetObjects[4].GetSearchData("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=O");
  		if(ComGetEtcData(sXml, "FLAG") == "N") {
  			formObj.org_cd.value="";
	  		formObj.org_cd.focus();
	  		return false;
  		}
		if(formObj.dest_tp_cd.value != "S") {
			if(destCd.length == 2) {
				formObj.dest_tp_cd.value='C';
			}else if(destCd.length == 3) { 
				formObj.dest_tp_cd.value='R';
			} else if(destCd.length == 5) {
				formObj.dest_tp_cd.value='L';
			}
		}
		formObj.f_cmd.value=SEARCH04;
  		formObj.cd.value=destCd;
//parameter changed[check again]CLT   		
  		sXml=sheetObjects[4].GetSearchData("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=D");
  		if(ComGetEtcData(sXml, "FLAG") == "N") {
  			formObj.dest_cd.value="";
  			formObj.dest_cd.focus();
  			return false;
  		}
  		return true;
 	}
  	/**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch (sAction) {
        		case IBSEARCH :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(!checkOriDestCd()) {
        				return false;
        			}
        			break;
        		case IBSEARCH_ASYNC01 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount()< 1) {
        				return false;
        			}
        			break;
        		case IBSEARCH_ASYNC02 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount()< 1) {
        				return false;
        			}
        			break;
        		case IBSEARCH_ASYNC03 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount()< 1) {
        				return false;
        			}
        			break;
        	}
        }
        return true;
	}
