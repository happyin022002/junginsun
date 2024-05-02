/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_005.js
 *@FileTitle  : S/C GOH Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class S/C GOH Guideline Inquiry : business script for S/C GOH Guideline Inquiry
     */
    function ESM_PRI_0002_05() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var enableFlag=true;
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;						
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
						}else{
			                ComShowCodeMessage('PRI08001');
			                return false;
						}
					}
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
        resizeSheet();

        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);            
        toggleButtons("CLEAR");
        parent.loadTabPage();
    }
 	/**
     * calling function when Page Loading <br>
     */ 
    //no support[check again]CLT function pageOnLoadFinish() {
    	 
    //}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
				with(sheetObj){
					var HeadTitle="Seq.|dbSeq.|Type|Point|Description|Bar Type|Per|Cur.|Rate|svcscpcd|glineseq";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"goh_chg_seq" },
					             {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Text",      Hidden:0, Width:280,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_hngr_bar_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					             {Type:"Float",     Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" } ];
					   
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(425);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetShowButtonImage(2);
					//SetAutoRowHeight(0);
				}
                break;
        }
    }
    
    function resizeSheet() {
	   	ComResizeSheet(sheetObjects[0]);
	  }
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
    		case IBCLEAR: // when screen loading code retrieve
	    		//currency combo
				sheetObj.SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
				// per combo
				sheetObj.SetColProperty("rat_ut_cd", {ComboText:perCdComboText, ComboCode:perCdComboValue} );
				//comon  bar type
				sheetObj.SetColProperty("prc_hngr_bar_tp_cd", {ComboText:barCdComboText, ComboCode:barCdComboValue} );
				//comon - type				
				sheetObj.SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1] , ComboCode:LOCATION_TYPE1[0]} );
				break;
			case IBSEARCH:      //retrieve
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_PRI_0002_05GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
                break;
			case IBDOWNEXCEL:
				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj)});
				break;
        }
	}
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {
		case IBSEARCH: // retrieve		
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			} else {
				return true;
			}
			break;
        case IBDOWNEXCEL: 
	        if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	            return false;
	        }
	        break;				
		}        
        return true;
    }
	/**
     * setting editable or not by parent screen's state<br>
     */    
    function getMainStatus(){
    	var mainStatus=parent.document.form.cfm_flg.value;
     	var editStatus=true;
     	if (mainStatus == "Yes"){
     		editStatus=false;
     	}
     	return editStatus;
    }     
    /**
     * setting button's attribute function <br>
     */ 
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_downexcel");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_downexcel");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_downexcel");
			break;
		}
	}     
    /**
     * calling function when clicking parent's screen tab <br>
     * showing retrieved data<br>
     */ 		     	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject=document.form;
		if(formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;    			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}						
	    }
    }
    /**
     * initializing parent's screen tab control <br>
     */ 	
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";    		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
    /**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */ 		  
    function tabEnableSheet(flag) {
    	 var formObject=document.form;		
    	 sheetObjects[0].SetEditable(flag);
    	 enableFlag=flag;
    	 if (enableFlag) {
    		 toggleButtons("INIT");
    	 } else {
    		 toggleButtons("READONLY");
    	 }			
    }   	 