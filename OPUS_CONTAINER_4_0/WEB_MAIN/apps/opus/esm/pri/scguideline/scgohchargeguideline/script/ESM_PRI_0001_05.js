/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_005.js
*@FileTitle  : S/C GOH Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class S/C GOH Guideline Creation :business script for S/C GOH Guideline Creation
     */
    function ESM_PRI_0001_05() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var enableFlag=true;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.16
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
    				case "btn_Save":	
    					if(enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
    						doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					}    						
						break;						
    				case "btn_Add":
    					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
    						doActionIBSheet(sheetObject1,formObject,IBINSERT);
    					}
						break;
    				case "btn_DownExcel":
    					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
    						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					}
    					break;    					
    				case "btn_Copy":
    					if (enableFlag && validateForm(sheetObject1,formObject,IBCOPYROW)) {
    						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);			
    					}
    					break;		
    				case "btn_Del":
    					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
    						doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.17
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
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                var HeadTitle="|Sel.|Seq.|dbSeq.|Type|Point|Description|Bar Type|Per|Cur.|Rate|svcscpcd|glineseq";
                var headCount=ComCountHeadTitle(HeadTitle);
                (headCount, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"goh_chg_seq" },
                       {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                       {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_hngr_bar_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" } ];
                InitColumns(cols);
                resizeSheet(); //SetSheetHeight(380);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetShowButtonImage(2);


               }
               break;
            }
        }
    
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
	}
    
    /**
    * Calling function in case of Onchange Event <br>
    * Showing description when selecting Multi ComboBox <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
      	var colname=sheetObj.ColSaveName(Col);
      	var formObj=document.form
      	switch(colname)
      	{
  	    	case "rout_pnt_loc_def_cd":
  	    		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd", sheetObj.GetCellValue(Row,"rout_pnt_loc_def_cd").toUpperCase(), 0);
  	    		if (Value.length==2){
  	    			formObj.f_cmd.value=SEARCH07;
  	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);    	 				
  	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	  				
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
  						sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","C" ,0);
  					}else{
  						ComShowCodeMessage("PRI00315");
  						locationCellClear(sheetObj,Row);
  					}	  				
  	    		}else if(Value.length==5){
  	    			formObj.f_cmd.value=SEARCH05;
  	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);  	
  	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.SetCellValue(Row, "loc_des",arrData[0][1],0);
	  					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L" ,0);
  					}else{  	
  						ComShowCodeMessage("PRI00315");
  						locationCellClear(sheetObj,Row);
					}	
  	    		}else{
  	    			ComShowCodeMessage("PRI00315");
  	    			locationCellClear(sheetObj,Row);
  	    		}
  	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    	
 	    		locationCellClear(sheetObj,Row);
 	    		break;  
	    	case "frt_rt_amt":
	    		if (sheetObj.GetCellValue(Row,Col) < 0){
            		sheetObj.SetCellValue(Row, Col,0,0);
            	}		
	    		break;	 	    		
      	}
      }  
    /**
     * Initializing specific cell's value of sheet to empty <br>
     * <br><b>Example :</b>
     * <pre>
     * 		locationCellClear(sheetObj,Row)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory 
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  	    
  	function locationCellClear(sheetObj,Row){
  		sheetObj.SetCellValue(Row,"loc_des","",0);
  		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
  	}    
    /**
     * Calling function in case of OnSaveEnd Event <br>
     * Displaying Save confirmation message in case of sucessful saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return N/A
     * @author 
     * @version 2009.04.17
     */ 		
   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
   		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			parent.setTabStyle();
		}
	}      
   /**
    * Calling function in case of OnPopupClick event <br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 
 	var popupRow = 0;
 	var colName="";
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		colName=sheetObj.ColSaveName(Col);
		popupRow = Row;
		var formObj=document.form;
		var locTpCd=sheetObj.GetCellValue(Row,"rout_pnt_loc_tp_cd");
      	switch(colName)
      	{
  	    	case "rout_pnt_loc_def_cd":
	  	  		var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&loc_tp_cd="+ locTpCd +"&location_cmd=LC&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
	  	  	ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0", true);
  	    	break;
      	}
	}    
	
	function setReturnValue(rtnVal) {
		if (rtnVal != null){  
			var sheetObj=sheetObjects[0];
			var tpCd= rtnVal.tp;
			if (colName == "rout_pnt_loc_def_cd"){
				sheetObj.SetCellValue(popupRow, "rout_pnt_loc_tp_cd", tpCd ,0);
				sheetObj.SetCellValue(popupRow, "rout_pnt_loc_def_cd", rtnVal.cd, 0);
				sheetObj.SetCellValue(popupRow, "loc_des", rtnVal.nm, 0);
			} 
		}
	}
    /**
     * Handling Sheet's process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        try{
            switch(sAction) {
	    		case IBCLEAR: 
	    			//currency combo
	    			sheetObj.SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
	    			// per combo
	    			sheetObj.SetColProperty("rat_ut_cd", {ComboText:perCdComboText, ComboCode:perCdComboValue} );
	    			//Common  bar type
	    			sheetObj.SetColProperty("prc_hngr_bar_tp_cd", {ComboText:barCdComboText, ComboCode:barCdComboValue} );
					//Common - type				
					sheetObj.SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1], ComboCode:LOCATION_TYPE1[0]} );
					break;
				case IBSEARCH:    
 					ComOpenWait(true); //->waiting->start 				
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_PRI_0001_05GS.do", FormQueryString(formObj) );
					ComOpenWait(false); //->waiting->End
	                break;
				case IBSAVE:       
 					ComOpenWait(true); //->waiting->start 
					formObj.f_cmd.value=MULTI;	
					var sParam=FormQueryString(formObj);
					var sParamSheet=sheetObj.GetSaveString();
					if (!sheetObj.IsDataModified()&& sParamSheet == "") {
						ComShowCodeMessage("PRI00301");
						return false;
					}		
					if (sParamSheet == ""){
						return false;
					}					
		            if (!ComPriConfirmSave()) {
		                return false;
		            }					
		            var sXml=sheetObj.GetSaveData("ESM_PRI_0001_05GS.do", sParam+"&"+sParamSheet);
		            sheetObj.LoadSaveData(sXml);
					ComOpenWait(false); //->waiting->End
	                break;
				case IBINSERT:      
				    sheetObj.SetDataAutoTrim(0);
			        var Row=sheetObj.DataInsert();
					sheetObj.SetCellValue(Row, "svc_scp_cd",formObj.svc_scp_cd.value);
					sheetObj.SetCellValue(Row, "gline_seq",formObj.gline_seq.value);
					sheetObj.SetCellValue(Row,"goh_chg_seq",parseInt(ComPriGetMax(sheetObj, "goh_chg_seq"))+ 1);
					sheetObj.SetCellValue(Row, "frt_rt_amt","0.00");
					sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
					//ComPriGetMax(sheetObj, sCol)  goh_chg_seq
					break;
				case IBDOWNEXCEL:     
					ComOpenWait(true); //->waiting->start
//					sheetObj.Down2Excel(-1);
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
//						 sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
						 sheetObj.Down2Excel({ HiddenColumn: 1,Merge: 1, KeyFieldMark:0 });
					}
					ComOpenWait(false); //->waiting->End
					break;
				case IBCOPYROW: // Row Copy
					var Row=sheetObj.DataCopy();
				    sheetObj.SetCellValue(Row,"goh_chg_seq",parseInt(ComPriGetMax(sheetObj, "goh_chg_seq"))+ 1);
					break;					
				case IBDELETE: // Delete
					//deleteRowCheck(sheetObj, "chk", "del_chk");
					deleteRowCheck(sheetObj, "chk" ,true);
					break;					
	            }        	
        } catch (e) {
       		if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
	          	if ( sAction == IBCLEAR || sAction == IBDELETE || sAction == IBINSERT
	          			|| sAction == IBCOPYROW) {
	          		return;
	          	}
	          	ComOpenWait(false); //->waiting->End
         }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @returns bool <br>
     *          true  : Valid<br>
     *          false : Invalid
     * @author 
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {
		case IBSEARCH:
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			} else {
				return true;
			}
			break;
		case IBSAVE:
			if (sheetObjects[0].IsDataModified()) {
		        if (parent.document.form.cfm_flg.value == "Yes"){
		    	    ComShowCodeMessage("PRI00105");
		    	    return false;
		        }				
				 var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rat_ut_cd|prc_hngr_bar_tp_cd", false);
				 if (rowM >= 0) {				 
					 ComShowCodeMessage("PRI00303", "G.O.H Sheet", rowM);
					 sheetObjects[0].SelectCell(rowM, "rout_pnt_loc_def_cd");
				     return false;
				 }
				 var mRow = getValidRowCount(sheetObj);
					for (i=1; i <= mRow; i++){						
						if (sheetObj.GetCellValue(i, "frt_rt_amt") <= 0.00){
							ComShowCodeMessage('PRI00321',"Rate","0.00");		
							sheetObj.SelectCell(i,"frt_rt_amt");
							return false;
						}
					}				 
			}    		
			return true;
			break;
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
		case IBCOPYROW: // Row Copy
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
		case IBDELETE: // Delete
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
        case IBDOWNEXCEL: 
	        if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	        	ComShowCodeMessage('PRI08001');
	        	return false;
	        }
        	if (sheetObj.IsDataModified()== true){
        		ComShowCodeMessage('PRI00309','G.O.H');
        		return false;
        	}
	        break;				
		}        
        return true;
    }
     /**
      * Defining edit status by status of parent screen<br>
      * <br><b>Example :</b>
      * <pre>
      * getMainStatus())
      * </pre>
      * @param N/A
      * @return {Boolean} true(Editable,Main status : No) false(Not editable,Main status: Yes)
      * @author 
      * @version 2009.04.17
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
   * Activating or deactivating by status of screen <br>
   * <br><b>Example :</b>
   * <pre>
   *  toggleButtons(mode)
   * </pre>
   * @param {String} Status value Mandatory 
   * @author 
   * @version 2009.04.17
   */  
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_Add");
			ComBtnEnable("btn_Copy");
			ComBtnEnable("btn_Del");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		}
	}     
   /**
    * Calling function in case of clicking tab on parent screen <br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd Mandatory svc_scp_cd
    * @param {string} sGlineSeq Mandatory gline_seq
    * @param {string} isAproUsr Mandatory
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;    			
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
            tabEnableSheet(enableFlag);			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);            
		}
	}
    /**
    * Clearing controls of tab screen on parent screen <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 	
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";    		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
    /**
     * Calling from main <br>
     * if Confirmation=YES,Disable to add,modify,delete. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory ,from main
     * @return N/A
     * @author 
     * @version 2009.04.17
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
