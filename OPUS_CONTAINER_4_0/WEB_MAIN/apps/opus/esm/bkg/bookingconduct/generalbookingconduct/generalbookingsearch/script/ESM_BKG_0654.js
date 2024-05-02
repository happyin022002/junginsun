/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0654.js
*@FileTitle  : RFA Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
    * function calling after Customer Inquiry(common Popup) ,Return 
    * <pre>
    *     callBackShpr(arrBal);
    * </pre>
    * @param {string}
    * @return void

    */    	
   function callBackShpr(rArray){
  		var formObject=document.form;
  		if(rArray != null){
  			formObject.s_cust_cnt_cd.value=rArray[0][3].substring(0,2);
  			formObject.s_cust_seq.value=rArray[0][3].substring(2);
  			formObject.s_cust_nm.value=rArray[0][4];
  		}  		    	 
    }	    
   /**
    * function calling after Customer Inquiry(common Popup) ,Return <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBackCnee(arrBal);
    * </pre>
    * @param {string} 
    * @return void
    */    	
   function callBackCnee(rArray){
  		var formObject=document.form;
  		if(rArray != null){
  			formObject.c_cust_cnt_cd.value=rArray[0][3].substring(0,2);
  			formObject.c_cust_seq.value=rArray[0][3].substring(2);
  			formObject.c_cust_nm.value=rArray[0][4];
  		}  		    	 
    }
   
   /**
    * function calling after Customer Inquiry(common Popup) ,Return <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBackCtrlPty(arrBal);
    * </pre>
    * @param {string} 
    * @return void
    */    	
   function callBackCtrlPty(rArray){
  		var formObject=document.form;
  		if(rArray != null){
  			formObject.bkg_ctrl_pty_cust_cnt_cd.value=rArray[0][3].substring(0,2);
  			formObject.bkg_ctrl_pty_cust_seq.value=rArray[0][3].substring(2);
  			formObject.bkg_ctrl_pty_cust_nm.value=rArray[0][4];
  		}  		    	 
    }
   
 // public variable
    var comboObjects=new Array();
    var comboCnt=0;     
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
    		 var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
					case "btn_Retrieve":
						if(validateForm(formObject))doActionIBSheet(sheetObject,formObject,IBSEARCH);	
					break; 
					case "btn_Shpr":
		        		var custCd=formObject.s_cust_cnt_cd.value+formObject.s_cust_seq.value;
			        		ComOpenPopup('/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 770, 470, "callBackShpr", '0,1,1,1,1,1,1', true);									
					break; 
					case "btn_Cnee":
						var custCd=formObject.c_cust_cnt_cd.value+formObject.c_cust_seq.value;
		        		ComOpenPopup('/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 770, 470, "callBackCnee", '0,1,1,1,1,1,1', true);															
					break;
					case "btn_Ctrl_Pty":
						var custCd=formObject.bkg_ctrl_pty_cust_cnt_cd.value+formObject.bkg_ctrl_pty_cust_seq.value;
		        		ComOpenPopup('/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 770, 470, "callBackCtrlPty", '0,1,1,1,1,1,1', true);															
					break;   
					case "btn_Select":
						comPopupSend(sheetObject, formObject);	
					break;
					case "btn_Rfa":
						var rArray=getCheckedRowByName(sheetObject, "chk");
						if(rArray != null){
							var rfaNo=rArray[0][5];
							var isPop=true;
							if(ComIsNull(rfaNo)){
							   isPop=false;
							}
							if(isPop && rfaNo.length > 3){
							   if(rfaNo.substring(0,3) == "DUM"){
								   isPop=false;
							   }
							}else{
							   isPop=false;
							}
							if(isPop){
//						      var pgmNo="ESM_PRI_2019";
//						      var pgmUrl="/opuscntr/ESM_PRI_2019.do";
//						      var params="&s_rfa_no=" + rfaNo;  //==> RFA No.
//						      var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
//						      var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
//						      var sFeatures="status=no; dialogWidth=1024px; dialogHeight=700px; resizable=no; scrollbars=yes";   
//						      var winObj =  ComOpenWindow("opusMain.screen?parentPgmNo=" + parentPgmNo + src,  "",  sFeatures , true);
								
								
 						      var params="s_rfa_no=" + rfaNo;  //==> RFA No.							      
						      var sUrl="/opuscntr/ESM_PRI_2019.do?" + params;
						      var sFeatures="status=no; dialogWidth=1024px; dialogHeight=700px; resizable=no; scrollbars=yes";   
						      var winObj =  ComOpenWindowCenter(sUrl,  "",  sFeatures , true);
								
							}     									
						}
					break;																					
					case "btn_Close":
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
  * setting combo initial values and header 
  * @param {IBMultiCombo} comboObj  comboObj
  */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator("|");
	}
  /**
   * registering IBCombo Object as list
   * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
   **/
   function setComboObject(combo_obj){
     comboObjects[comboCnt++]=combo_obj;
   }
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){	
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
   	    // IBMultiCombo initialization
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }	    
		 initControl();    
		 doActionIBSheet(sheetObjects[0],document.form,INIT);
	}
	function initControl() {
        axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
   	}
      /**
         * setting sheet initial values and header
         * 
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
                        var HeadTitle="|TP|Customer Code|Customer Code|Customer Name|RFA Number|Sales OFC|Service Scope|Service Scope";
                        
                        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                        
                        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                        var headers = [ { Text:HeadTitle, Align:"Center"} ];
                        InitHeaders(headers, info);
                        
                        var cols = [ {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                                     {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sales_ofc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"svc_scp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                        
                        InitColumns(cols);
                        
                        SetEditable(1);
                        SetSheetHeight(240);
                    }
                    break;
            }
        }
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
				case INIT:      //init loading
					formObj.f_cmd.value=INIT;
					ComOpenWait(true);
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0654GS.do" , FormQueryString(formObj));
					ComOpenWait(false); 
					var arrXml=sXml.split("|$$|");  
					if (arrXml.length > 0){
	    				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "svc_scp_cd", "svc_scp_nm");
					}     	        						
					if (arrXml.length > 1){	
						sheetObj.LoadSearchData(arrXml[1] );
					}       		
				break;            
				case IBSEARCH:      //retrieve
					formObj.f_cmd.value=SEARCH;
					ComOpenWait(true);
 					sheetObj.DoSearch("ESM_BKG_0654GS.do", FormQueryString(formObj) );
					ComOpenWait(false); 
				break;
            }
        }
    	// retrieve function is complete, retrieve the generated Event.
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{		
    		if(ErrMsg == ""){
    			if(sheetObj.RowCount()< 1){
    				var idx=sheetObj.DataInsert(-1);
    				sheetObj.SetCellValue(idx, "cust_lgl_eng_nm","DUMMY CUSTOMER");
    				sheetObj.SetCellValue(idx, "rfa_no","DUM0000001");
    			}
    		}
    	}      
    	//double click -> select
        function sheet1_OnDblClick(sheetObj , row, col) {  
       	 	var formObj=document.form;
       	 	sheetObj.SetCellValue(row,"chk","1",0);
       	 	comPopupSend(sheetObj, formObj);
        }     
    	// If Scope Combo List selected
    	function svc_scp_cd_list_OnChange(Code, Text){
    		document.form.svc_scp_cd.value=comboObjects[0].GetSelectCode();
    	}      
        /**
         * handling process for input validation
         */
        function validateForm(formObj){
        	 if(ComIsNull(formObj.s_cust_cnt_cd.value) && ComIsNull(formObj.c_cust_cnt_cd.value)&& ComIsNull(formObj.bkg_ctrl_pty_cust_cnt_cd.value)){
        		 ComShowCodeMessage("BKG00625");
        		 return false;
        	 }
            return true;
        }
         /**
          * send screen information to main
          */     
 		function comPopupSend(sheetObj, formObj){
 			var calllFunc=formObj.calllFunc.value;
 			var rArray=getCheckedRowByName(sheetObj, "chk");
         	if(rArray == null) {
				ComShowCodeMessage("COM12114", "row");
				return;
			}else{
                if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
                else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
                ComClosePopup(); 
			}
 		}     	
