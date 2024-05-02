/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1022.js
*@FileTitle  : Lease Agreement Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
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
    var tabLoad=new Array();
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";

    var t3sheet1_leftHeaders = [{Text:"Fixed Rate", Align:"Center"}];
    var t1sheet1_leftHeaders = [{Text:"Initial Value", Align:"Center"}];
   
    tabLoad[0]=0;
    tabLoad[1]=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 
     */
    function processButtonClick(){
    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
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
      * initializing sheet <br>
      * implementing onLoad event handler in body tag <br>
      * @param  
      * @return 
      * @author 
      * @version 
      */
    function loadPage() {
    	var formObj=document.form;
    	
    	doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC07);
    	
    	for(i=0;i<sheetObjects.length;i++){
    		//
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//
    		ComEndConfigSheet(sheetObjects[i]);
    	}
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        comboObjects[comboCnt++]=agmt_ver_no;
        for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
        
        if(validateForm(sheetObjects[0], formObj,IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
//        	doActionIBSheet(sheetObjects[0], formObj,IBRESET);
        }
     }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version 
     */
    var leftHeaders = [{Text:"Fixed Rate", Align:"Left"}];
    var leftHeaders1 = [{Text:"Initial Value", Align:"Left"}];
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
   		var sheetID=sheetObj.id;
   		switch(sheetID) {
              case "t1sheet1":
                   with (sheetObj) {
                  var HeadTitle="T/S|";
                  
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
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 },
                         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }

                  InitColumns(cols);
                  SetEditable(1);
                  InitHeadColumnSync(leftHeaders1,sheetObj);
                  SetSheetHeight(135);
                  }
                   break;         	
              case "t2sheet1":
                   with (sheetObj) {
                  var HeadTitle1="|Seq|Registered State|Surcharge Rate";
                  var headCount=ComCountHeadTitle(HeadTitle1);
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                         {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"ste_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:0,   SaveName:"rgst_scg_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
                  InitColumns(cols);
                  SetEditable(1);
                  SetSheetHeight(132);
                  }
                  break;
              case "t3sheet1":
                  with (sheetObj) {
                  var HeadTitle="Type/Size|";
//                  var leftHeaders="Fixed Rate||SF2|SL2|TA2|SF4|GN4|CB4|EG5|EG8|GN5|ZT4";
                  
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
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ 
                              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 },
		                      {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];
				  
                  var sCount = "";
				  var x = 1;
				  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
			 			  cols.push({Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 });
				 		  x++;
				 	  }
				  }                  

	 	          InitColumns(cols);
                  SetEditable(1);
                  InitHeadColumnSync(leftHeaders,sheetObj);
                  SetSheetHeight(132);
   				 }
                   break;
              case "t3sheet2":
                   with (sheetObj) {
                  var HeadTitle="|Number of Units|Number of Units|Number of Units|Number of Units";
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
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
                  
                  var sCount = "";
				  var x = 1;
				  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
			 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 });
				 		  x++;
				 	  }
				  }                  
                  
                   
                  InitColumns(cols);
                  SetEditable(1);
                  SetSheetHeight(132);
   				 }
                   break;
              case "t3sheet3":
                   with (sheetObj) {
                  var HeadTitle="|Used Days|Used Days|Used Days|Used Days";
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
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];

                  var sCount = "";
				  var x = 1;
				  
	 	          for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
			 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 });
				 		  x++;
				 	  }
				  }                  
                  
                  InitColumns(cols);
                  SetEditable(1);
                  SetSheetHeight(132);
   				 }
                 break;
              case "sheet":	// Hidden Sheet
              	 with (sheetObj) {
            	  	SetVisible(0);
                  	// setting height
                  	//setting Host information [mandatory][HostIp, Port, PagePath]
                  //no support[check again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
              	 }
                 break;
        }
    }

    function t3sheet1_OnSearchEnd(sheetObj , code , msg ){
 	   if( sheetObj.RowCount() < 1){
 	        InitHeadColumnSync(leftHeaders,sheetObj);
 	    } else {
 	    	InitHeadText(leftHeaders,sheetObj);
 	   }
 	}
 
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 
     * @author 
     * @version 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      //retrieve
         		formObj.f_cmd.value=SEARCH;
         		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
         		sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
		 	    var sXml=sheetObjects[5].GetSearchData("EES_CGM_1022GS.do" , FormQueryString(formObj), '', true);
         		var arrXml=sXml.split("|$$|");
		 	    ComOpenWait(false);
		 	    
		 	   for (var i=0; i < 10; i++ ){
					sheetObjects[0].SetCellValue(1,i+2, 0);
					sheetObjects[3].SetCellValue(1,i+2, 0);
         		}
         		// tab1 Sheet Object
         		sheetObjects[3].LoadSearchData(arrXml[0],{Sync:1} );
         		setEtcDataToForm(formObj, sheetObjects[3]);
         		if(arrXml.length > 1){
	         		// Rental Rate Tab   Sheet Object value setting
	         		if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'F'){
	         			sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1} );
	         		} else if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'U'){
	         			sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
	         		} else if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'D'){
	         			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	         		}
	         		// Surchage Tab Sheet Object value setting
	         		sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
	         		// Agreement Version MultiCombo setting
//	         		var comboItemCnt=comboObjects[0].GetItemCount();
		         	var cols=ComCgmXml2ComboString(arrXml[3], "agmt_ver_no", "agmt_ver_no");
		         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
		         	comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObjects[3].GetEtcData("agmt_ver_no")),false);
         		} else {
         			// Sheet Object Clear
             		for(var i=0; i<sheetObjects.length; i++){
             			sheetObjects[i].RemoveAll();
             		}
         		}
         		break;
         		
        	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
				break;
        }
    }
    function setEtcDataToForm(formObj, sheetObj){
    	formObj.eq_knd_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_seq"));
  		formObj.agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_no"));
  		formObj.old_agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("old_agmt_no"));
  		formObj.agmt_ref_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ref_no"));
  		formObj.curr_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("curr_cd"));
  		formObj.agmt_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_iss_ofc_cd"));
  		formObj.agmt_eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_exp_dt"));
  		formObj.eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("eff_dt"));
  		formObj.exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("exp_dt"));
  		formObj.vndr_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_lgl_eng_nm"));
  		formObj.dpp_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("dpp_rt_amt"));
  		formObj.dpp_cvrg_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("dpp_cvrg_amt"));
  		formObj.lmsm_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("lmsm_amt"));
  		formObj.onh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("onh_hndl_rt_amt"));
  		formObj.offh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("offh_hndl_rt_amt"));
  		formObj.pay_term_dys.value=ComCgmNullToBlank(sheetObj.GetEtcData("pay_term_dys"));
  		formObj.drp_off_lmt_qty.value=ComCgmNullToZero(sheetObj.GetEtcData("drp_off_lmt_qty"));
  		formObj.drp_off_lmt_rto.value=ComCgmNullToZero(sheetObj.GetEtcData("drp_off_lmt_rto"));
  		formObj.mon_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("mon_dpc_rt_amt"));
  		formObj.max_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("max_dpc_rt_amt"));
  		formObj.init_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("init_dpc_rt_amt"));
  		formObj.diff_rmk.value=ComCgmNullToBlank(sheetObj.GetEtcData("diff_rmk"));
  		comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
  		formObj.agmt_lstm_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_lstm_cd"));
  		formObj.chss_pool_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("chss_pool_cd"));
  		if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'F'){
  			formObj.eq_rntl_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'U'){
  			formObj.eq_rntl_tp_cd[1].checked=true;
  		} else if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'D'){
  			formObj.eq_rntl_tp_cd[2].checked=true;
  		}
    	if(sheetObj.GetEtcData("dpp_tp_cd") == 'G'){
    		formObj.dpp_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("dpp_tp_cd") == 'L'){
  			formObj.dpp_tp_cd[1].checked=true;
  		}	
  		if(sheetObj.GetEtcData("drp_off_lmt_prd_cd") == 'M'){
  			formObj.drp_off_lmt_prd_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("drp_off_lmt_prd_cd") == 'Y'){
  			formObj.drp_off_lmt_prd_cd[1].checked=true;
  		}	
  		if(sheetObj.GetEtcData("drp_off_lmt_tp_cd") == 'F'){
  			formObj.drp_off_lmt_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("drp_off_lmt_tp_cd") == 'R'){
  			formObj.drp_off_lmt_tp_cd[1].checked=true;
  		}
  		var element=document.getElementById("poolLayer");
  		if(formObj.agmt_lstm_cd.value == "CP"){
  			element.style.visibility="visible";
  		} else {
  			element.style.visibility="hidden";
  		}
  		var qtyLayer=document.getElementById("qtyLayer");
		var rtoLayer=document.getElementById("rtoLayer");
		if(formObj.drp_off_lmt_tp_cd[0].checked){
			qtyLayer.style.display="block";
			rtoLayer.style.display="none";
		} else if(formObj.drp_off_lmt_tp_cd[1].checked){
			qtyLayer.style.display="none";
			rtoLayer.style.display="block";
		}
 		setTab3SheetEnable(formObj);	
    }
    function setTab3SheetEnable(formObj){
    	var objsheets1=document.getElementById("t3sheetLayer1");
     	var objsheets2=document.getElementById("t3sheetLayer2");
     	var objsheets3=document.getElementById("t3sheetLayer3");
     	with(formObj){
			if(eq_rntl_tp_cd[0].checked){
				objsheets1.style.display='Inline';
				objsheets2.style.display='none';
				objsheets3.style.display='none';
			} else if (eq_rntl_tp_cd[1].checked){	
				objsheets1.style.display='none';
				objsheets2.style.display='Inline';
				objsheets3.style.display='none';
			} else if (eq_rntl_tp_cd[2].checked){
				objsheets1.style.display='none';
				objsheets2.style.display='none';
				objsheets3.style.display='Inline';
			}
    	}
    } 
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
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
					InsertItem( "Depr. For Casualty Value" , "");
					InsertItem( "Surcharge" , "");
					InsertItem( "Remark(s)" , "");
                 }
              break;
          }
          tabObj.SetSelectedIndex(0);
     }
     /**
     * Event when clicking Tab
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
 	    	objs[nItem].style.display="Inline";
 	    	objs[beforetab].style.display="none";
 	    	//-------------------------------------//
 	    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
 	    	//------------------------------------------------------//
 	    	beforetab=nItem;
     }
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
     * Combo Object reset  <br>
     * @param  {object} comboObj	Combo Object
     * @return 
     * @author 
     * @version
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
    function agmt_ver_no_OnChange(Index_Code, Text){
    	var formObj=document.form;
    	if(validateForm(sheetObjects[0], formObj, IBSEARCH) != false) {
        	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } 
    
    function t1sheet1_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t1sheet1_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t1sheet1_leftHeaders,sheetObj);
    	}
    	
	}
    
    function t3sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	for(var i=1; i<= sheetObj.RowCount(); i++){
    		if(i < sheetObj.RowCount()){
    			sheetObj.SetCellValue(i, "rntl_fm_title","From",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    		} else {
    			sheetObj.SetCellValue(i, "rntl_fm_title","Over",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    			sheetObj.SetCellEditable(i, "rntl_to_tr_val",0);
    		}
    		sheetObj.SetCellEditable(i, "rntl_fm_title",0);
			sheetObj.SetCellEditable(i, "rntl_to_title",0);
     	}
    }
    function t3sheet3_OnSearchEnd(sheetObj, ErrMsg){
    	for(var i=1; i<= sheetObj.RowCount(); i++){
    		if(i < sheetObj.RowCount()){
    			sheetObj.SetCellValue(i, "rntl_fm_title","From",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    		} else {
    			sheetObj.SetCellValue(i, "rntl_fm_title","Over",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    			sheetObj.SetCellEditable(i, "rntl_to_tr_val",0);
    		}
    		sheetObj.SetCellEditable(i, "rntl_fm_title",0);
			sheetObj.SetCellEditable(i, "rntl_to_title",0);
     	}
    }    
	/* developer job end */
