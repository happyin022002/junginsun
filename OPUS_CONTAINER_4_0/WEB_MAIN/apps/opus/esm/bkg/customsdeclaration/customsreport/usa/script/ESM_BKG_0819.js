/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0819.js
*@FileTitle  : MI Transmit History  for IE
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
     * @extends 
     * @class esm_bkg_0819 : business script for esm_bkg_0819
     */
    function esm_bkg_0819() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             var sheetObject1=sheetObjects[0];
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
    			switch(srcName) {
    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
    					break;
    				case "btn_DownExcel":
    					doActionIBSheet(sheetObject1,document.form,IBDOWNEXCEL);
    					break;
    				case "btn_Select":
    					doActionIBSheet(sheetObject1,document.form,IBROWSEARCH);
    					break;
    				case "btn_Close":
    					ComClosePopup(); 
    					break;	
    				case "btn_calendar":
    	                if(formObject.fromd.disabled) return;
    					var cal=new ComCalendarFromTo();
    	                cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
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
         * adding first-served functions after loading screen
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
	    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	    	axon_event.addListenerForm("click","obj_click", document.form);
	    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
			doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
		      
		      var HeadTitle1="|MSG|SENT DATE|OFFICE|USER ID|VVD|POL|POD|TTL B/L|IE(63)|P/MIB";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsm_msg_tp_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_usr_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"snd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_bl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ie_bl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mib_bl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(0);
		      SetColProperty(prefix+"snd_dt", {Format:"####-##-## ##:##:##"} );
		      SetCountPosition(2);
              SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	          SetSheetHeight(400);
		      }
				break;
    		}
    	}
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	//sheetObj.ShowDebugMsg = false;
        	sheetObj.SetWaitImageVisible(0);
            switch(sAction) {
	        	case IBCREATE:      //init
					if (sheetObj.id == "sheet1") {
						formObj.reset();
						formObj.fromd.value=ComGetDateAdd(null, 'd', -7, '-');
						formObj.tod.value=ComGetNowInfo('ymd','-');
						alterRequiredChk("1");
					}
					break;
	        	case IBSEARCH:      
		        	if(!validateForm(sheetObj,formObj,sAction)) return;
					ComOpenWait(true);
	 				formObj.f_cmd.value=SEARCH;
 	 				if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0819GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	 				ComOpenWait(false);
	 				break;
	        	case IBROWSEARCH:
	        		var opener_obj=opener;
	    			var form1=opener_obj.document.form;
form1.vvd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vvd");
form1.pod.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_pod_cd");
  ComClosePopup(); 
 					break;
	        	case IBDOWNEXCEL:
	                if(sheetObj.RowCount() < 1){//no data
	                    ComShowCodeMessage("COM132501");
	                    return;
	                }
					ComOpenWait(true);
 					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObj), SheetDesign:1,Merge:1 });
					ComOpenWait(false);
 					break;
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch(sAction) {
  				case IBSEARCH:
  					if(!ComChkRequired(formObj)) return false;
  					break;
        	 	}
        	 return true;
        }
        /**
         * handling input search conditions
         */
        function obj_KeyUp() {
        	var val="";
        }
        /**
         * handling click search conditions
         */
        function obj_click(){
        	var formObject=document.form;
        	var srcObj=window.event.srcElement;
        	var srcName=srcObj.getAttribute("name");
        	var srcVal=srcObj.value;
        	if(srcName == "gubun"){
        		alterRequiredChk(srcVal);
        	}
        }
        /**
         * handling click search conditions
         */
        function alterRequiredChk(gubunVal){
        	var formObject=document.form;
        	if(gubunVal == "1"){
    			formObject.fromd.disabled=false;
    			formObject.fromt.disabled=false;
    			formObject.tod.disabled=false;
    			formObject.tot.disabled=false;
    			formObject.vvd.disabled=true;
    		}else{
    			formObject.fromd.disabled=true;
    			formObject.fromt.disabled=true;
    			formObject.tod.disabled=true;
    			formObject.tot.disabled=true;
    			formObject.vvd.disabled=false;
    			formObject.vvd.focus();
    		}        	
        }
        /**
         * handling double click on sheet
         */
        function sheet1_OnDblClick(Row, Col, CellX, CellY, CellW, CellH) {
        	var sheetObject1=sheetObjects[0];
        	doActionIBSheet(sheetObject1,document.form,SEARCH02);
        }
        /**
         * handling after retrieve complete
         */
        function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		with(sheetObj)
    		{
    			for (var i=1; i <= LastRow(); i ++)
    			{
if (GetCellValue(i, "sheet1_mib_bl") != GetCellValue(i, "sheet1_ie_bl")){
     					SetCellFontColor(i, "sheet1_tot_bl","#FF0000");// font color is red
     					SetCellFontColor(i, "sheet1_ie_bl","#FF0000");
     					SetCellFontColor(i, "sheet1_mib_bl","#FF0000");
    				}
    			}
    		}
    	}
