/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2103.js
*@FileTitle  : Lease Agreement Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
   	/* developer job	*/
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";
    
    var t3sheet1_leftHeaders = [{Text:"During Build-up Period|During Fixed Period", Align:"Center"}];
    
    var t3sheet2_leftHeaders = [{Text:"Initial Value(USD)", Align:"Center"}];
    
    var t3sheet3_leftHeaders = [{Text:"Post Trip Charge(POTC)|Pre Trip Charge(PRTC)", Align:"Center"}];
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 2009.06.18
     */
    function processButtonClick(){
        /***** use additional sheet var in case of more than 2 tap each sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Close":
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 	/**
 	 * IBTab Object - > array
 	 * adding process for list in case of needing batch processing with other items
 	 * defining list on the top of source
 	*/
 	function setTabObject(tab_obj){
 		tabObjects[tabCnt++]=tab_obj;
 	}
 	/**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.06.18
     */
    function loadPage() {
        var formObj=document.form;
        
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

    	for(i=0;i<sheetObjects.length;i++){
    		//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //
            ComEndConfigSheet(sheetObjects[i]);
        }
    	// IBMultiCombo reset 
    	comboObjects[comboCnt++]=agmt_ver_no;
    	for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
    	// Tab Object reset 
 		for(k=0;k<tabObjects.length;k++){
 			initTab(tabObjects[k],k+1);
 		}
 		
 		// retrieve
 		if(validateForm(sheetObjects[3], formObj,IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[3], formObj,IBSEARCH);
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version 2009.06.18
     */
    function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
	 		case "t3sheet1":
	 		    with(sheetObj){
		 	      var HeadTitle="Type/Size|";
			 	      
        			//making data as list for changing column
        			oldCntrTypeSize = sCntrTypeSize;
        			var arrCntrTypeSize = "";
        			if(oldCntrTypeSize != ""){
        				arrCntrTypeSize = oldCntrTypeSize.split("|");
        			}

        			//handling header title by changing column
    				if (sCntrTypeSize != "") {
    					HeadTitle += "|" + oldCntrTypeSize;
    				}

			 	      var headCount=ComCountHeadTitle(HeadTitle);
			 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			 	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			 	      InitHeaders(headers, info);
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

  					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
 	 	              
			 	      InitColumns(cols);
			 	      SetEditable(0);
			 	//      InitHeadColumn(t3sheet1_leftHeaders, sheetObj);
			 	     // resizeSheet(sheetObj);
			 	     SetSheetHeight(120);
	 				}
	            break;
	            
	       case "t3sheet2":
	    	    with(sheetObj){
		 	      var HeadTitle="Type/Size|";
		 	      
      			//making data as list for changing column
      			oldCntrTypeSize = sCntrTypeSize;
      			var arrCntrTypeSize = "";
      			if(oldCntrTypeSize != ""){
      				arrCntrTypeSize = oldCntrTypeSize.split("|");
      			}

      			//handling header title by changing column
  				if (sCntrTypeSize != "") {
  					HeadTitle += "|" + oldCntrTypeSize;
  				}

			 	      var headCount=ComCountHeadTitle(HeadTitle);
			 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			 	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			 	      InitHeaders(headers, info);
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

					  var sCount = "";
					  var x = 1;
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
			         
			         InitColumns(cols);
			         SetEditable(0);
			         SetSheetHeight(80);
	               }
	            break;
	            
	       case "t3sheet3":
	    	    with(sheetObj){
		 	      var HeadTitle="Type/Size|";
		 	      
      			//making data as list for changing column
      			oldCntrTypeSize = sCntrTypeSize;
      			var arrCntrTypeSize = "";
      			if(oldCntrTypeSize != ""){
      				arrCntrTypeSize = oldCntrTypeSize.split("|");
      			}

      			//handling header title by changing column
  				if (sCntrTypeSize != "") {
  					HeadTitle += "|" + oldCntrTypeSize;
  				}

			 	      var headCount=ComCountHeadTitle(HeadTitle);
			 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			 	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			 	      InitHeaders(headers, info);
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

					  var sCount = "";
					  var x = 1;
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }

 	 	             InitColumns(cols);
			         SetEditable(0);
			         SetSheetHeight(120);
	               }
	            break;                  
         	case "sheet1":      // sheet1 init
                 with (sheetObj) {
                var HeadTitle="|M.G.Set No.|Yard|Fueling Date|Current Running Hours|Fuel Q’ty(Gallon)|Fuel Rate|Fuel Amount|Labor Amount|Total Amount(USD)|Chassis No.|Reefer Container No.";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                  InitColumns(cols);
	              SetEditable(1);
	              SetShowButtonImage(2);
	              SetSheetHeight(160);
 			   }
              break;
         }
    }
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 
     * @author 
     * @version 2009.06.18
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
	            formObj.f_cmd.value=SEARCH;
	     		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	     		sheetObj.SetWaitImageVisible(0);
	     		
		 	    ComOpenWait(true);
		 	    var sXml=sheetObjects[2].GetSearchData("EES_CGM_2103GS.do" , FormQueryString(formObj), '', true);
         		var arrXml=sXml.split("|$$|");
               	ComOpenWait(false);
               	
                var dataCount=ComGetTotalRows(arrXml[0]);
               
                if(dataCount != null && dataCount > 0){
	                // Sheet Object 1
	               	sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	               	
	                setEtcDataToForm(formObj, sheetObj);
	                
	                var dataCount=ComGetTotalRows(arrXml[0]);
                
                
                    sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
                    sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
                    sheetObjects[2].LoadSearchData(arrXml[3],{Sync:1} );
                    
                   // Agreement Version Multi Combo setting
                    var cols=ComCgmXml2ComboString(arrXml[0], "agmt_ver_no", "agmt_ver_no");
                    ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
                    comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
                    
                    return true;
                } else {
	     			ComShowCodeMessage('CGM10012');
	     			//self.close();
                }	     		
               

	            break;
          	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
            	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
    			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
    			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
    			
    			//getting changing column information from server
    			oldCntrTypeSize = sCntrTypeSize;
	            
        }
    }
    /**
     * Form Tag setting . <br>
     * @param  {object} formObj	 
     * @param  {object} sheetObj
     * @return 
     * @author 
     * @version 2009.06.18
     */
    function setEtcDataToForm(formObj, sheetObj){
    	formObj.eq_knd_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_seq"));
  		formObj.agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_no"));
  		formObj.old_agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("old_agmt_no"));
  		formObj.agmt_ref_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ref_no"));
  		formObj.agmt_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_iss_ofc_cd"));
  		formObj.agmt_eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_exp_dt"));
  		formObj.eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("eff_dt"));
  		formObj.exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("exp_dt"));
  		formObj.vndr_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_lgl_eng_nm"));
  		formObj.onh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("onh_hndl_rt_amt"));
  		formObj.offh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("offh_hndl_rt_amt"));
  		formObj.pay_term_dys.value=ComCgmNullToBlank(sheetObj.GetEtcData("pay_term_dys"));
  		formObj.mon_dpc_rt_amt.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mon_dpc_rt_amt")),2);
  		formObj.max_dpc_rt_amt.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("max_dpc_rt_amt")),2);
  		formObj.init_dpc_rt_amt.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("init_dpc_rt_amt")),2);
  		formObj.diff_rmk.value=ComCgmNullToBlank(sheetObj.GetEtcData("diff_rmk"));
  		formObj.agmt_lstm_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_lstm_cd"));
   		comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
//   		formObj.onh_init_val_amt_clg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("onh_init_val_amt_clg")),2);
//   		formObj.mgst_potc_scg_rt_amt_clg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_potc_scg_rt_amt_clg")),2);
//   		formObj.mgst_prtc_scg_rt_amt_clg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_prtc_scg_rt_amt_clg")),2);
//   		formObj.mgst_bldp_rt_amt_clg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_bldp_rt_amt_clg")),2);
//   		formObj.mgst_lse_fx_rt_amt_clg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_lse_fx_rt_amt_clg")),2);
//   		formObj.onh_init_val_amt_umg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("onh_init_val_amt_umg")),2);
//   		formObj.mgst_potc_scg_rt_amt_umg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_potc_scg_rt_amt_umg")),2);
//   		formObj.mgst_prtc_scg_rt_amt_umg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_prtc_scg_rt_amt_umg")),2);
//   		formObj.mgst_bldp_rt_amt_umg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_bldp_rt_amt_umg")),2);
//   		formObj.mgst_lse_fx_rt_amt_umg.value=ComCgmAmountFormat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_lse_fx_rt_amt_umg")),2);
    }     
    /**
     * handling process for input validation <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			
     * @author 
     * @version 2009.06.18
     */  
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
          	switch(sAction){
          	 	case IBSEARCH:	// retrieve
          	 		var agmtNo=formObj.agmt_no.value;
          	 		var result=true;
          	 		if(agmtNo != ""){
          	 			if(agmtNo.length <= 3){
          	 				result=false;
          	 			} else {
          	 				if(ComIsNumber(agmtNo.substring(3))==false){
          	 					result=false;
          	 				}
          	 			}
          	 		} else {
          	 			result=false;
          	 		}
          	 		if(!result){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			ComClosePopup(); 
        	 			return false;
        	 		} else {
        	 			return true;
        	 		}
          	 		break;
          	}
        }
    }
    /**
 	 * initializing Tab
 	 * setting Tab items
 	 */
 	function initTab(tabObj , tabNo) {
 		switch(tabNo) {
 				case 1:
 					with (tabObj) {
 						var cnt=0 ;
 						InsertItem( "Rental Rate" , "");
 						InsertItem( "Depr. For Casualty" , "");
 						InsertItem( "Surcharge" , "");
 						InsertItem( "Remark(s)" , "");
 					}
 					break;
 			}
 		tabObj.SetSelectedIndex(0);
 	}
 	/**
 	* Event when clicking Tab
 	 *
 	*/
 	function tab1_OnChange(tabObj , nItem){
 		var objs=document.all.item("tabLayer");
 			objs[nItem].style.display="Inline";
 			objs[beforetab].style.display="none";
 			objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
 			beforetab=nItem;
 	}
 	/** 
     * Combo Object reset  <br>
     * @param  {object} comboObj	 Combo Object
     * @return 
     * @author 
     * @version 2009.06.15
     */ 
    function initCombo(comboObj) {
     	switch(comboObj.options.id) {
 	    	case "agmt_ver_no":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code="";
 	  	            Text="";
 	  	            SetDropHeight(100);
 	  	            SetMultiSelect(0);
 	  	            SetMaxSelect(1);
 //no support[check again]CLT 	  	            UseCode=true;
 	  	            SetEnable(1);
 	  	        }
 	  	        break;
     	}
    }  
    /**
     * Agreement Version No  Change event. <br>
     * @param  {string} Index_Code 
     * @param  {string} Text 
     * @return 
     * @author 
     * @version 2009.06.09
     */
     function agmt_ver_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
     	var formObj=document.form;
     	if(validateForm(sheetObjects[0], formObj, IBSEARCH) != false) {
         	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
         }
     } 
     
     function t3sheet1_OnSearchEnd(sheetObj , code , msg){
     	if( sheetObj.RowCount() < 1) {
     		InitHeadColumn(t3sheet1_leftHeaders,sheetObj);
     	}else {
     		InitHeadText(t3sheet1_leftHeaders,sheetObj);
     	}
 	}
     
     function t3sheet2_OnSearchEnd(sheetObj , code , msg){
     	if( sheetObj.RowCount() < 1) {
     		InitHeadColumn(t3sheet2_leftHeaders,sheetObj);
     	}else {
     		InitHeadText(t3sheet2_leftHeaders,sheetObj);
     	}
 	}
     
     function t3sheet3_OnSearchEnd(sheetObj , code , msg){
     	if( sheetObj.RowCount() < 1) {
     		InitHeadColumn(t3sheet3_leftHeaders,sheetObj);
     	}else {
     		InitHeadText(t3sheet3_leftHeaders,sheetObj);
     	}
 	}         
	/* developer job end */
