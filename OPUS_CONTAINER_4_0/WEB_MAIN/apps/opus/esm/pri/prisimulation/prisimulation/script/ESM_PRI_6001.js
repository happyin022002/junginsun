/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_6001.js
*@FileTitle  : Verify Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/26
=========================================================**/

/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    var sheetObjects=new Array();
    var sheetCnt=0;
    
    var comboObjects=new Array();
    var comboCnt=0;
    
    var formObj;
    var gCurrDate;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_new":
                	sheetObjects[0].RemoveAll();
                	sheetObjects[1].RemoveAll();
                	formObj.reset();
                    formObj.ld_dt.value=gCurrDate;
                    eq_tp_cd.RemoveAll();
                    formObj.svc_scp_cd.empty();
                    ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                    break;
                case "btn_por":
                	selectLoc('POR');
                	break;  
                case "btn_del":
                	selectLoc('DEL');
                	break;  
                case "btn_pol":
                	selectLoc('POL');
                	break;  
                case "btn_pod":
                	selectLoc('POD');
                    break;  
                case "btn_doc":
                	selectLoc('DOC');
                	break;  
                case "btn_dep_lane":
                	selectLane('DEP');
                	break;
                case "btn_arv_lane":
                	selectLane('ARV');
                    break;
                case "btn_sub_trd":
                	var sUrl="/opuscntr/COM_COM_0013.do?code=" + formObj.sub_trd_cd.value + "&main_page=" + "false";
     		        var rVal=ComOpenPopup(sUrl, 750, 410, "get_subTrdCd", "1,0,1", true);
                	break;
        	    case "btn_calendar":
					var cal=new ComCalendar();
					cal.select(formObj.ld_dt, 'yyyy-MM-dd');
        	        break;
        	    case "btn_commodity": //cmdt_cd
        	    	var ctrtNo = formObj.ctrt_no.value;
        	    	var ctrtTp = formObj.ctrt_tp.value;
        	    	var param = "";
        	    	if(formObj.svc_scp_cd.value==""){
        	    		param = "por_cd="+formObj.por.value+"&del_cd="+formObj.del.value+"&app_dt="+formObj.ld_dt.value;
        	    	}else{
        	    		param = "svc_scp_cd="+formObj.svc_scp_cd.value+"&app_dt="+formObj.ld_dt.value;//??rfa는 svc scp 안받는듯
        	    	}
        	    	
        	    	if(ctrtTp=="S"){
        	    		ComOpenPopup("ESM_BKG_0657.do?" + param + "&sc_no=" + ctrtNo, 850, 420, "callback_sc_cmdt", "1,0", true);
        	    	}else if(ctrtTp=="R"){
        	    		ComOpenPopup("ESM_BKG_0656.do?" + param + "&rfa_no=" + ctrtNo, 700, 450, "callback_rfa_cmdt", "1,0", true);
        	    	}else if(ctrtTp=="T"){
        	    		ComOpenPopup("ESM_BKG_1078.do?" + param + "&taa_no=" + ctrtNo, 625, 497, "callback_taa_cmdt","1,0", true);
        	    	}else{
        	    		ComOpenPopup("ESM_BKG_0653.do", 820, 500, "callback_cmdt", "1,0,1,1,1,1", true,true,0,0,0,"");	
        	    	}
                    break;
        	    case "btn_cust":
                    var custCd=form.cust_cnt_cd.value + form.cust_seq.value;
                    if(form.cust_cnt_cd.value == ""){
                        custCd="";
                    }
                    ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+custCd, 770, 470, "callBackComEns041", '1,0,1,1,1,1,1', false);
                    break;
        	    case "btn_ctrt":
                    if(form.ld_dt.value == ""){
                        ComShowCodeMessage("COM130201", "Effective Date");
                        return false;
                    }
                    ComOpenPopup("/opuscntr/ESM_PRI_6101.do?peff_dt="+form.ld_dt.value, 1200, 700, "callBackCtrt", '1,0,1,1,1,1,1,1', true);
                    break;
        	    case "btn_apply":
        	    	doActionIBSheet(sheetObject1,formObj,SEARCH01);
        	    	break;
        	    case "btn_rv":
        	    	var row=sheetObjects[1].FindCheckedRow("chk");
        	    	if(row.length==0){
	  					ComShowCodeMessage("PRI00011");
	  				} else if (row.indexOf("|") > 0) {
                        ComShowCodeMessage("PRI03031");
                    } else {
	  					var param = "pctl_no=" + sheetObjects[1].GetCellValue(row, "pctl_no")
	  					+ "&cntr_sz_cd=" + sheetObjects[1].GetCellValue(row, "org_cntr_sz_cd")
	  					+ "&cmdt_cd=" + sheetObjects[1].GetCellValue(row, "grp_cmdt")
	  					+ "&cmdt_seq=" + sheetObjects[1].GetCellValue(row, "cmdt_seq")
	  					+ "&auto_rat_flg=" + sheetObjects[1].GetCellValue(row, "auto_rat_flg");
	  					ComOpenPopup("/opuscntr/ESM_PRI_6102.do?" + param, 1200, 700, "", '1,0', true);
	  				}
        	    	break;
        		case "btn_excel": 			
         			
         			if(sheetObjects[1].RowCount() < 1){
         			  ComShowCodeMessage("COM132501");
         			}else{
         				sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
         			} 			
         			
        			break;
        		case "btn_up":
        			if (sheetObjects[1].GetSheetHeight() > 200)
        			{
        				sheetObjects[1].SetSheetHeight(sheetObjects[1].GetSheetHeight() - 50);
        			}
        			break;
        			
        		case "btn_down":
    				sheetObjects[1].SetSheetHeight(sheetObjects[1].GetSheetHeight() + 50);
        			break;
        			
        		case "btn_cm":
        			var cost_dtl_pctl_no="";
        	        var classId="ESM_PRI_6002_POP";
        	        var param="";
        	        var cost_dtl_pctl_no = "";
        	        var ttl_rt2 = "0"; var cnt_ttl_rt2 = 0;
        	        var ttl_rt4 = "0"; var cnt_ttl_rt4 = 0;
        	        var ttl_rt5 = "0"; var cnt_ttl_rt5 = 0;
        	        var ttl_rt7 = "0"; var cnt_ttl_rt7 = 0;
        	        var chkRow = sheetObjects[1].FindCheckedRow("chk");
        	        if(chkRow.length==0){
	  					ComShowCodeMessage("PRI00011");
	  					return;
	  				}
        	        var arr1=chkRow.split("|");
                    for (var i=0; i<arr1.length; i++) {
                    	if (sheetObjects[1].GetCellValue(arr1[i], "cntr_sz_cd") == "20")
                		{
                    		cnt_ttl_rt2++;
                    		ttl_rt2 = sheetObjects[1].GetCellValue(arr1[i], "base_rt");
                		}
                    	if (sheetObjects[1].GetCellValue(arr1[i], "cntr_sz_cd") == "40")
                		{
                    		cnt_ttl_rt4++;
                    		ttl_rt4 = sheetObjects[1].GetCellValue(arr1[i], "base_rt");
                		}
                    	if (sheetObjects[1].GetCellValue(arr1[i], "cntr_sz_cd") == "50")
                		{
                    		cnt_ttl_rt5++;
                    		ttl_rt5 = sheetObjects[1].GetCellValue(arr1[i], "base_rt");
                		}
                    	if (sheetObjects[1].GetCellValue(arr1[i], "cntr_sz_cd") == "70")
                		{
                    		cnt_ttl_rt7++;
                    		ttl_rt7 = sheetObjects[1].GetCellValue(arr1[i], "base_rt");
                		}
                    	cost_dtl_pctl_no=sheetObjects[1].GetCellValue(arr1[i], "pctl_no");
                    }
                    if (cnt_ttl_rt2 > 1 || cnt_ttl_rt4 > 1 || cnt_ttl_rt5 > 1 || cnt_ttl_rt7 > 1)
                	{
                    	ComShowCodeMessage("PRI03030");
                    	return;
                	}
        	        formObj.f_cmd.value="";
        	        param='?pctl_no='+cost_dtl_pctl_no+'&ttl_rt2='+ttl_rt2+'&ttl_rt4='+ttl_rt4+'&ttl_rt5='+ttl_rt5+'&ttl_rt7='+ttl_rt7+'&classId='+classId+'&'+FormQueryString(formObj);
        	        ComOpenWindow('ESM_PRI_6002_POP.do'+param,'(CMTX)Route Cost Detail', 'width=1200,height=660,menubar=0,status=1,scrollbars=1,resizable=1');
        			break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
  /**
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj mandatory IBSheet Object
    * @return void
    * @author 
    * @version 2010.10.13
    */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
  /**
    * registering IBCombo Object as list</b>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(comboObj);
    * </pre>
    * @param {ibcombo} combo_obj Mandatory IBCombo Object
    * @return void
    * @author 
    * @version 2010.10.13
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2010.10.13
    */
    function loadPage() {
        formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        // Axon Event Initialize
        initControl();
        initIBComboItem();

        gCurrDate=ComGetNowInfo('ymd', '-');
        formObj.ld_dt.value=gCurrDate;
        
        cgo_tp_cd.SetSelectCode("DR");
        eq_tp_cd.SetSelectCode("D");
//        ComBtnDisable("btn_cm");
//        formObj.unmatch_chk.disabled = true;
    }
    
    /**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2010.10.13
     */         
     function initControl() {
        // Process Axon Event No.1, Event Catch             
        axon_event.addListenerFormat('beforeactivate', 'obj_onActivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);               
        axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
        axon_event.addListenerForm ('change', 'obj_onChange', document.form);
     }

     /**
      * setting Item in IBMultiCombo<br>
      */
     function initIBComboItem() {
         ComPriTextCode2ComboItem(cgoTpCdListComboValue, cgoTpCdListComboText, getComboObject(comboObjects, 'cgo_tp_cd'),	"|", "\t" );      
         ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
         ComPriTextCode2ComboItem(gohCdListComboValue,   gohCdListComboText,   getComboObject(comboObjects, 'goh_cd'),		"|", "\t" );
//         ComPriTextCode2ComboItem(svcScpComboValue,   	svcScpComboText,	getComboObject(comboObjects, 'svc_scp_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(trnsModComboValue,   	trnsModComboText,	getComboObject(comboObjects, 'org_trns_mod_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(trnsModComboValue,   	trnsModComboText,	getComboObject(comboObjects, 'dest_trns_mod_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(wgtUtCdComboValue,	wgtUtCdComboText,	getComboObject(comboObjects, 'wgt_ut_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(measUtCdComboValue,   measUtCdComboText,	getComboObject(comboObjects, 'meas_ut_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(filerComboValue,   	filerComboText,		getComboObject(comboObjects, 'usa_cstms_file_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(filerComboValue,   	filerComboText,		getComboObject(comboObjects, 'cnd_cstms_file_cd'),		"|", "\t" );
         ComPriTextCode2ComboItem(siCdComboValue,   	siCdComboText,		getComboObject(comboObjects, 'si_cd'),		"|", "\t" );
     }
     
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2010.10.13
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch(sheetID) {
    		case "sheet1":
    			with(sheetObj){
    				var HeadTitle1="Flag|Trade|Sub\nTrade|Service\nLane|Cargo Cutoff\nTime|eCom T/T|eCom T/T|Total Trans.\nTime|Cargo Avail.\nTime|Ocean\nPriority|Eqt.\nType|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|pctl_no";
    				var HeadTitle2="Flag|Trade|Sub\nTrade|Service\nLane|Cargo Cutoff\nTime|Ocean|Total|Total Trans.\nTime|Cargo Avail.\nTime|Ocean\nPriority|Eqt.\nType|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|pctl_no";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

    				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"}  ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",Hidden:1, Width:30,		Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    				             {Type:"Text",	Hidden:0, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"trd_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"slan_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:105,	Align:"Center",  ColMerge:0,   SaveName:"cct",			KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"cml_ocn_tztm_hrs",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:60,		Align:"Center",  ColMerge:0,   SaveName:"cml_inlnd_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:90,		Align:"Center",  ColMerge:0,   SaveName:"ttl_tztm_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:105,	Align:"Center",  ColMerge:0,   SaveName:"cgo_aval_hrs",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",  Hidden:0, Width:50,   	Align:"Center",  ColMerge:0,   SaveName:"ocn_rout_prio_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },				             
    				             {Type:"Text",	Hidden:0, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"por_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"ob_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"pol_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:250,	Align:"Center",  ColMerge:0,   SaveName:"ts_route",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"pod_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"ib_itchg_ctnt",KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:0,   SaveName:"del_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"pctl_no",		KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
                     InitColumns(cols);
                     SetEditable(0);
                     SetWaitImageVisible(0);
                     SetAutoRowHeight(0);
                     SetSheetHeight(280);
		             SetColProperty("ttl_tztm_hrs", {AcceptKeys:"N", Format:"##D##H"} );
		             SetColProperty("cml_ocn_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
		             SetColProperty("cml_inlnd_tztm_hrs", {AcceptKeys:"N", Format:"##D"} );
		             SetFocusAfterProcess(0);
                }

                break;
                
    		case "sheet2":
    			with(sheetObj){
    			var HeadTitle1 ="Flag||CMDT Name|CMDT Code|G.CMDT Name|G.CMDT|Size|Type Size|CMDT SEQ|Curr|OFT Rate|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|Match / Unmatch|PCTL NO|Remark|"; //Match / Unmatch 이름 변경시 sheet2_onsearch 부분도 고쳐야 함
//    			var HeadTitle2 ="Flag||CMDT\nName|CMDT\nCode|G.CMDT\nName|G.CMDT|Size|Type\nSize|CMDT SEQ|OFT\nRate|Curr|Match\nFlag|Effective\nDate|Merchant / Carrier|Merchant / Carrier|Scope|Origin|Origin\nVia|Dest\nVia|Dest|Cargo\nType|Eq.\nType|SOC|GOH|PCTL NO|Remark|";
//    			var HeadTitle3 ="Flag||CMDT\nName|CMDT\nCode|G.CMDT\nName|G.CMDT|Size|Type\nSize|CMDT SEQ|OFT\nRate|Curr|Match\nFlag|Effective\nDate|From|To|Scope|Origin|Origin\nVia|Dest\nVia|Dest|Cargo\nType|Eq.\nType|SOC|GOH|PCTL NO|Remark|";
    			SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
    			
    			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    			var headers = [ { Text:HeadTitle1, Align:"Center"}//,
//				                { Text:HeadTitle2, Align:"Center"},
//				                { Text:HeadTitle3, Align:"Center"} 
				                ];
    			InitHeaders(headers, info);
    			
    			var cols = [ {Type:"Status",Hidden:1, Width:30,		Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    			             {Type:"CheckBox",Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk"},
    			             {Type:"Text",	Hidden:0, Width:300,	Align:"Left",  	 ColMerge:1,   SaveName:"cmdt_nm",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
    			             {Type:"Text",	Hidden:0, Width:75,		Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:0, Width:450,	Align:"Left",  	 ColMerge:1,   SaveName:"grp_cmdt_nm",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
    			             {Type:"Text",	Hidden:0, Width:80,		Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:1, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"cntr_sz_cd",	KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:0, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"org_cntr_sz_cd",KeyField:0,  CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:0, Width:45,		Align:"Right",	 ColMerge:0,   SaveName:"curr_cd",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Float",	Hidden:0, Width:120,	Align:"Right",	 ColMerge:0,   SaveName:"base_rt",		KeyField:0,   CalcLogic:"",   Format:"Float",	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"auto_rat_flg",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:1, Width:100,	Align:"Center",  ColMerge:0,   SaveName:"eff_dt",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"rcv_t_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",	Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"del_t_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",   KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"org_mtch_flg",			KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"org_via_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"dest_via_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:70,		Align:"Center",  ColMerge:0,   SaveName:"dest_mtch_flg",			KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd_mtch_flg",	KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd_mtch_flg",	KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"soc_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",  Hidden:1, Width:40,		Align:"Center",  ColMerge:0,   SaveName:"goh_mtch_flg",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"pctl_no",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",  Hidden:1, Width:50,		Align:"Center",  ColMerge:0,   SaveName:"remark",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    						 {Type:"Text",  Hidden:0, Width:1,		Align:"Center",  ColMerge:0,   SaveName:"",		KeyField:0,   CalcLogic:"",   Format:"",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    			
    			InitColumns(cols);
    			SetEditable(1);
    			SetWaitImageVisible(0);
    			SetAutoRowHeight(1);
    			SetSheetHeight(280);
    		}
    			
    			
    			break;
        }
    }
    
   /**
    * setting intial combo value <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
    * @param {int} comboNo Mandatory IBMultiCombo's Serial No
    * @return void
    * @author 
    * @version 2010.10.13
    */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "cgo_tp_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(2);
                    SetUseAutoComplete(1);
                    SetColAlign(0, "center");
                    ValidChar(2);	// Uppercase, Alphabet Only 
                }
                break;
            case "eq_tp_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(1);
                    SetUseAutoComplete(1);
                    ValidChar(2);	// Uppercase, Alphabet Only 
                }
                break;
            case "goh_cd":
            	with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetMaxLength(1);
	            	SetUseAutoComplete(1);
	            	ValidChar(2);	// Uppercase, Alphabet Only 
	            }
            	break;
        }
    }
    
  /**
   * Handling sheet's processes <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj mandatory html form object
   * @param {int} sAction mandatory,Constant Variable
   * @return void
   * @author 
   * @version 2010.10.13
   */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            switch (sAction) {              
                case IBSEARCH: // retrieving
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);                  
                    formObj.f_cmd.value=SEARCH;           
                    var sXml=sheetObj.GetSearchData("ESM_PRI_6001GS.do", FormQueryString(formObj));
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    ComOpenWait(false);
                    break;              
                case SEARCH01: // apply rate
                	if (!validateForm(sheetObj,document.form,sAction)) {
                		return false;
                	}
                	ComOpenWait(true);                  
                	formObj.f_cmd.value=SEARCH01;
                	formObj.act_wgt.value=formObj.act_wgt.value.replace(/,/g, "");//,제거
                	formObj.meas_qty.value=formObj.meas_qty.value.replace(/,/g, "");//,제거
                	
                	var sParam = FormQueryString(formObj)+"&pctl_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "pctl_no")
			                    +"&slan_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "slan_cd")
			                    +"&por="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "por_cd")
			                    +"&del="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "del_cd");

            		ComSetObjValue(formObj.act_wgt, ComAddComma(ComGetObjValue(formObj.act_wgt)));//,추가
            		ComSetObjValue(formObj.meas_qty, ComAddComma(ComGetObjValue(formObj.meas_qty)));//,추가
            		
        			var sXml=sheetObj.GetSearchData("ESM_PRI_6001GS.do", sParam);
        			var key=ComGetEtcData(sXml, "BackEndJobKey");
        			// top.document.body.scrollTop = 0;
        			intervalId=setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');", 3000);
                	
//                	var sXml=sheetObj.GetSearchData("ESM_PRI_6001GS.do", sParam);
//                	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
                	break;              
                case SEARCH02: // checking contract no
                	ComOpenWait(true);                  
                	formObj.f_cmd.value=SEARCH02;
                	var ctrtTp=ComSearchEtcData(sheetObj, "ESM_PRI_6001GS.do","f_cmd="+formObj.f_cmd.value+"&ctrt_no="+formObj.ctrt_no.value, 'ctrt_tp');
                	if(ctrtTp==null || ctrtTp==""){
                		ComShowCodeMessage("COM132201", "Contract No");
                		formObj.ctrt_tp.value = "";
                		formObj.ctrt_no.focus();
                	}else{
                		formObj.ctrt_tp.value = ctrtTp;
                	}
                	ComOpenWait(false);
                	break;                 
            }
        }catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
    /**
     * handling process for input validation <br>
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieving
        	if (!ComChkValid(formObj))
                return false;
            break;
        case SEARCH01: // apply rate
        	if(sheetObjects[0].RowCount()<=0){
        		ComShowCodeMessage("COM132701");
        		return false;
        	}
        	if(sheetObjects[0].GetSelectRow()=="-1"){
        		ComShowCodeMessage("COM12113", "Route");
        		return false;
        	}
        	if(formObj.ctrt_no.value==""){
        		ComShowCodeMessage("COM130201", "Contract No");
        		return false;
        	}
        	if(formObj.ctrt_tp.value==""){
        		ComShowCodeMessage("COM132201", "Contract No");
        		return false;
        	}
        	if(cgo_tp_cd.GetSelectCode()==""){
        		ComShowCodeMessage("PRI00308", "select", "Cargo Type");
        		cgo_tp_cd.Focus();
        		return false;
        	}
        	if(eq_tp_cd.GetSelectCode()==""){
        		ComShowCodeMessage("PRI00308", "select", "Eqt Type");
        		eq_tp_cd.Focus();
        		return false;
        	}
        	break;
        }
        return true;
    }
        
    /**
     * Calling Function in case of OnChange event <br>
     */
    function cgo_tp_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, text, code){
        eq_tp_cd.RemoveAll();
        
        if(code=="DR"){
        	eq_tp_cd.InsertItem(1, "D", "D");
        	eq_tp_cd.InsertItem(2, "R", "R");
        	eq_tp_cd.InsertItem(3, "T", "T");
        }else if(code=="DG"){
        	eq_tp_cd.InsertItem(1, "D", "D");
        	eq_tp_cd.InsertItem(2, "R", "R");
        	eq_tp_cd.InsertItem(3, "F", "F");
        	eq_tp_cd.InsertItem(4, "T", "T");
        }else if(code=="RF"){
        	eq_tp_cd.InsertItem(1, "R", "R");
        	eq_tp_cd.InsertItem(2, "T", "T");
        }else if(code=="AK"){
        	eq_tp_cd.InsertItem(1, "F", "F");
        	eq_tp_cd.InsertItem(2, "A", "A");
        	eq_tp_cd.InsertItem(3, "O", "O");
        	eq_tp_cd.InsertItem(4, "S", "S");
        }else if(code=="BB"){
        	eq_tp_cd.InsertItem(1, "F", "F");
        	eq_tp_cd.InsertItem(2, "A", "A");
        }else{
        	ComPriTextCode2ComboItem(eqtTpCdListComboValue, eqtTpCdListComboText, getComboObject(comboObjects, 'eq_tp_cd'),	"|", "\t" );
        }
    }
    
   /**
    * handling OnBeforeActivate event<br>
    */   
    function obj_onActivate() {
        var srcName=ComGetEvent("name");
        ComClearSeparator (ComGetEvent());
    }
    
    
    /*-popup---------------------------------------------------------------*/	
    var locInd='';
	function selectLoc(pt){
		var param='?loc_port_ind=1';
		locInd=pt;
		if(locInd == 'POR'){
          param=param+'&loc_cd='+formObj.por.value;
		}else if(locInd == 'POL'){
			param=param+'&loc_cd='+formObj.pol.value;
		}else if(locInd == 'POD'){
			param=param+'&loc_cd='+formObj.pod.value;
		}else if(locInd == 'DEL'){
		  param=param+'&loc_cd='+formObj.del.value;
		}else if(locInd == 'DOC'){
			param=param+'&loc_cd='+formObj.doc_loc_cd.value;
		}else{
			return;
		}
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 810, 500, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}	
    function getLoc(rowArray) {
    	var colArray=rowArray[0];
    	var rtnLod=colArray[3];
    	if(locInd == 'POR'){
    		formObj.por.value=rtnLod;
  		}else if(locInd == 'POL'){
  			formObj.pol.value=rtnLod;
  		}else if(locInd == 'POD'){
  			formObj.pod.value=rtnLod;
  		}else if(locInd == 'DEL'){
  			formObj.del.value=rtnLod;
  		}else if(locInd == 'DOC'){
  			formObj.doc_loc_cd.value=rtnLod;
  		}
    }
	/*----------------------------------------------------------------*/
    var laneInd='';
	function selectLane(pt) {
	    var param='?';
	    laneInd=pt;
	    if(laneInd == 'DEP'){
	    	param=param+'&lane_cd='+formObj.dep_lane.value;
		}else if(laneInd == 'ARV'){
			param=param+'&lane_cd='+formObj.arv_lane.value;
		}
        ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800,400,'getLane',"1,0,1,1,1,1,1,1,1,1,1,1", true);
	}
	function getLane(rowArray) {
    	var colArray=rowArray[0];
    	if(laneInd == 'DEP'){
	    	document.form.dep_lane.value=colArray[3];
		}else if(laneInd == 'ARV'){
			document.form.arv_lane.value=colArray[3];
		}
    }
	/**                                                                                            
     * Returning select value of Rep. Commodity pop-up <br>                                                                                
     */  
    function getCOM_ENS_011(rowArray){
        var colArray=rowArray[0];
        formObj.cmdt_cd.value=colArray[2]; // Commodity - cmdt_cd
    }
    /**                                                                                            
     *  CallBack function for getting Actual Coustomer, Coustomer code <br>                                                                               
     */  
    function callBackComEns041(rArray){
        if(rArray != null){
            var colArray=rArray[0];
            var ctrtCustCntCd=colArray[3].substring(0,2); 
            var ctrtCustSeq=ComLpad(colArray[3].substring(2),6,"0");
            formObj.cust_cnt_cd.value=ctrtCustCntCd;
            formObj.cust_seq.value=ctrtCustSeq;
        }                   
    }
    function get_subTrdCd(rowArray) {
	   	var colArray=rowArray[0];
     	formObj.sub_trd_cd.value=colArray[3];
   }
    
    function callBackCtrt(rtnObj){
    	if(rtnObj.CntrNo!=null || rtnObj.CntrNo!=""){
    		formObj.ctrt_no.value = rtnObj.CntrNo; 
    	}
    	if(rtnObj.CntrType!=null || rtnObj.CntrType!=""){
    		formObj.ctrt_tp.value = rtnObj.CntrType.substring(0, 1);
    	}
    }
    /*----------------------------------------------------------------*/
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
    		sheetObj.SetCellValue(i, "cntr_tp_cd", eq_tp_cd.GetSelectCode());
    	}
	}
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
    		if(sheetObj.GetCellValue(i, "auto_rat_flg")=="N"){
    			for(var j=0; j<sheetObj.LastCol(); j++){
    				if(sheetObj.GetCellValue(0, j)=="Match / Unmatch" && sheetObj.GetCellValue(i, j)=="N"){
    					sheetObj.SetCellFontColor(i, j, "#FF0000");
    				}
    			}
    		}
    		sheetObj.SetCellValue(i, "cntr_tp_cd", eq_tp_cd.GetSelectCode());
    	}
	}
        
	function sheet1_OnClick(sheetObj,Row,Col,Value) {
		var pctlNo = sheetObj.GetCellValue(Row, "pctl_no"); 
		if(pctlNo!=""){
        	ComOpenWait(true);                  
        	formObj.f_cmd.value=SEARCH04;
        	var sXml=sheetObj.GetSearchData("ESM_PRI_6001GS.do", "f_cmd="+formObj.f_cmd.value+"&pctl_no="+pctlNo);
        	var svc_scp_cd = ComGetEtcData(sXml, "svc_scp");
        	var ob_trns_mod = ComGetEtcData(sXml, "ob_trns_mod");
        	var ib_trns_mod = ComGetEtcData(sXml, "ib_trns_mod");
        	if(ob_trns_mod==""){
        		org_trns_mod_cd.SetSelectCode("");
        	}else{
        		org_trns_mod_cd.SetSelectCode(ob_trns_mod);
        	}
        	if(ib_trns_mod==""){
        		dest_trns_mod_cd.SetSelectCode("");
        	}else{
        		dest_trns_mod_cd.SetSelectCode(ib_trns_mod);
        	}
    		// Service Scope setting
    		var rName=svc_scp_cd.split("$");
    		var rCode='';
    		var _first=false;
    		for ( var j=0; j < rName.length; j++) {
    			if (_first) {
    				rCode += '$';
    			}
    			rCode += rName[j].substring(0, 3);
    			_first=true;
    		}
    		//- svc_scp_cd setting
    		var r_value=rCode + "^" + svc_scp_cd;
    		fnSetComboBox('svc_scp_cd', r_value, '');
    		
        	ComOpenWait(false);
		}
	
	}
    /**
     * Handling change event
     * @return
     */
    function obj_onChange(){
    	var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
    		case "ctrt_no":
    			if(formObj.ctrt_no.value!=""){
    				doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
    			}else{
    				formObj.ctrt_tp.value="";
    			}
    			break;
    		} // end switch isRmkModFlg
    	}catch(e) {
    		ComShowMessage(e.message);
    	}
    }
    
    /**
     * BackEndJob handling
     * @param sheetObj Sheet
     * @param sKey sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	sheetObjects[1].RemoveAll();
    	var formObj=document.form;
    	var sXml=sheetObj.GetSearchData("ESM_PRI_6001GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	
    	if (!isErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		// Error
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// Error Message
    		var errMsg=ComGetEtcData(sXml, "err_msg");
    		if(errMsg!=""){
    			ComShowMessage(errMsg);
    		}else{
    			ComShowCodeMessage("COM132101");
    		}
    	}
    }

    function isErrMessage(SheetObj, xmlStr){
       if(xmlStr == null  || xmlStr == "" ) return true;
       try {
         var vPrefix=xmlStr.substring(1,6);
          if (vPrefix == "ERROR") {
           SheetObj.LoadSearchData(xmlStr,{ Append:1},{Sync:1} );
           return false;
          } else {
           return true;
          }
       } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * set combo box
     * @param vCombo
     * @param vCode
     * @param vSelected
     * @return
     */
    function fnSetComboBox(vCombo, vCode, vSelected) {
    	var _spr="^"; // delimiter
    	var obj=eval("document.all." + vCombo); // SELECT box position ID
    	for ( var i=obj.length - 1; i >= 0; i--)
    		obj[i]=null; // Init
    	try {
    		var result=vCode;
    		if (result != "ERR" && result != "^") {
    			var aList=result.split(_spr);
    			var aCode, aName;
    			var aCode=aList[0].split("$");
    			var aName=aList[1].split("$");
    			var optioncnt=obj.options.length;
    			var codeindex=0;
    			for ( var j=optioncnt; j < aCode.length + optioncnt; j++) {
    				obj.options[j]=new Option();
    				obj.options[j].text=aName[codeindex];
    				obj.options[j].value=aCode[codeindex];
    				if (vSelected == aCode[codeindex]) {
    					obj.options[j].selected=true;
    				}
    				++codeindex;
    			}
    		}
    	} catch (err) {
    		 ComFuncErrMsg(err.message);
    	}
    }
    
    function callback_sc_cmdt(arrVal) {
    	if(arrVal != null){	
    		ComSetObjValue(formObj.cmdt_cd, arrVal[0][3]);
    	}
    }
    
    function callback_rfa_cmdt(arrVal) {
		if(arrVal != null){		
			if(arrVal[0][5] == "REP"){
				ComOpenPopup("ESM_BKG_0653.do?rep_cmdt_cd="+arrVal[0][3], 820, 500, "callback_cmdt", "1,0,1,1,1,1", true,true,0,0,0,"");
			} else {			
				ComSetObjValue(formObj.cmdt_cd, arrVal[0][6]);
			}
		}
    }
    
    function callback_taa_cmdt(arrVal) {
		if(arrVal != null){		
			ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
		}
    }
    
    function callback_cmdt(arrVal) {
    	if(arrVal != null){	
    		ComSetObjValue(formObj.cmdt_cd, arrVal[0][3]);
    	}
    }
    

	function msgmove(type){
		var stop="550px";
		if(type == "doc_loc"){
			stop="500px"
		}
		var sleft="0px";
		if(type == "hbl_knt"){
			sleft="750px";
		} else if(type == "self_knt"){
			sleft="880px";
		} else if(type == "cstms_file"){
			sleft="80px";
		} else if(type == "doc_loc"){
			sleft="1100px";
		} else {
			sleft="0px";
		}
		msg.style.left=sleft;
		msg.style.top=stop;
	}
	function msgset(type){
		var strmsg = "";
		var width = 0;
		if(type=="hbl_knt" || type=="self_knt" || type=="cstms_file"){
			strmsg = " &nbsp; to ensure proper CDD/NMS/SMC"
			width = 190;
		}else if(type=="doc_loc"){
			strmsg = " &nbsp; to ensure proper DOC/XDO"
			width = 165;
		}
		text='<table  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; width:'+width+'px;"><tr><td>' + strmsg + '</td></tr></table>';
		msg.innerHTML=text;
	}
	function msghide(){
		msg.innerHTML='';
	}	