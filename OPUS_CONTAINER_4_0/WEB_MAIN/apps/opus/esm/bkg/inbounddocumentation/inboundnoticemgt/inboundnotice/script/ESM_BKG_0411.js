/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0411.js
*@FileTitle  : Pick up Notice Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview business script for
     * @author
     */
    /**
     * @extends 
     * @class esm_bkg_0411 : esm_bkg_0411 
     */
   	/* developer's work*/
    // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var SH_STUP=0;
    var SH_PRE_FOM=1;
    var SH_PRE_HRS=2;
    var SH_ARR_FOM=3;
    var SH_ARR_HRS=4;
    var org_del_cd="";
    var orgDelList;
    var orgObj=new Object();
    var isRetrieved=false;
    var isAutoSelect=false;
    var isNew=true;
    // Event handler processing by button click event   */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function processButtonClick(){
        var shtCnt=0;
        var sheet1Obj=sheetObjects[shtCnt++];
        var sheet2Obj=sheetObjects[shtCnt++];
        var sheet3Obj=sheetObjects[shtCnt++];
        var sheet4Obj=sheetObjects[shtCnt++];
        var sheet5Obj=sheetObjects[shtCnt++];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheet1Obj,formObject,IBSEARCH);
                    break;
                case "btn_Copy":
                	doActionIBSheet(sheet1Obj,formObject,IBSEARCH_ASYNC02);
                    break; 
                case "btn_Save":
                	doActionIBSheet(sheet1Obj,formObject,IBSAVE);
                    break; 
                case "btn_Delete":
                	doActionIBSheet(sheet1Obj,formObject,IBDELETE);
                	break;
                case "btn_Close":
                	ComClosePopup();
                	break;
            } // end switch
        } catch(e) {
            if(e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
                ComOpenWait(false);
            } else {
                ComShowMessage(e.message);
                ComOpenWait(false);
            }
        }
    }
    /**
    * registering IBSheet Object as list<br>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * 
    * @param {IBSheet} sheet_obj , IBSheet 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen. <br>
    * 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function loadPage() {
        for (var i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
           	ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
        }
        initControl();
        initForm();
     }
    /**
      * initializing Form data. setting initial value after deleting data or opening screen.
      * 
      * @return 
      * @author 
      * @version 2009.07.09
      */
    function initForm() {   	 
        isRetrieved=false;
        isAutoSelect=false;
        isNew=true;
        // initializing original DEL code
        org_del_cd="";
    	// initializing 
 		with(document.form){
 			ofc_cd.value=p_ofc_cd.value;
            del_cd.value               = "ALL";
            ntc_snd_tp_cd.value        = "A"; // Auto

            frm_pkup_ntc_seq.value         = "";
            frm_pkup_ntc_snd_tp_cd.value   = "";
            frm_ofc_cd.value               = "";
            frm_del_cd.value               = "";
            frm_eclz_obl_cpy_flg.value     = "";
            frm_foc_clr_rmk_stup_flg.value = "";
            frm_auto_ntc_flg.value         = "Y"; // Auto
            frm_each_foc_ntc_flg.value     = "Y"; // Each Y Send(3times)
            frm_trkr_ntc_flg.value         = "N"; // No
            frm_auto_ntc_yd_flg.value      = "N"; // No auto send only when the delivery is yard term
            frm_hd_tit_ctnt.value          = "";
                    
            frm_t1_pkup_ntc_seq.value      = "";
            frm_t1_pkup_ntc_fom_cd.value   = "";
            frm_t1_eclz_obl_cpy_flg.value  = "N";
            frm_t1_btm_rmk.value           = "";
            
            frm_t2_pkup_ntc_seq.value      = "";
            frm_t2_pkup_ntc_fom_cd.value   = "";
            frm_t2_eclz_obl_cpy_flg.value  = "N";
            frm_t2_btm_rmk.value           = "";
 		}
 		// initializing
        for (var i=0;i<sheetObjects.length;i++) {
        	sheetObjects[i].RemoveAll();
        }
        resetSetupFlag();
        // getting all of DEL code which is registered at EQ office (creating DEL combo)
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
        document.form.ofc_cd.focus();
     }
    /**
     * registering tag event <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function initControl() {
//        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//     	axon_event.addListener("keydown","obj_keydown", "frm_hd_tit_ctnt", "frm_t1_btm_rmk", "frm_t2_btm_rmk");
//     	axon_event.addListener("keyup","obj_keyup", "ofc_cd", "del_cd", "frm_t1_btm_rmk", "frm_t2_btm_rmk");
     	//axon_event.addListener("change", "frm_auto_ntc_flg"); 
    }    
   
    /**
     * handling event ,Change <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function frm_auto_ntc_flg_change() {
    	var formObject=document.form;
   	    switch(ComGetEvent("name")) {
    	case "frm_auto_ntc_flg":
			if (formObject.frm_auto_ntc_flg.value == "Y" ) { // Auto
			    //formObject.frm_each_foc_ntc_flg.disabled=false;
			    document.getElementById("frm_each_foc_ntc_flg").disabled=false;
			    //formObject.frm_trkr_ntc_flg.disabled=false;
			    document.getElementById("frm_trkr_ntc_flg").disabled=false;
			    document.getElementById("frm_auto_ntc_yd_flg").disabled=false;
			    formObject.frm_each_foc_ntc_flg.value="N";
			} else { // Manual
			    formObject.frm_each_foc_ntc_flg.disabled=true;
			    document.getElementById("frm_each_foc_ntc_flg").disabled=true;
			    //formObject.frm_trkr_ntc_flg.disabled=true;
			    document.getElementById("frm_trkr_ntc_flg").disabled=true;
			    document.getElementById("frm_auto_ntc_yd_flg").disabled=true;
			}
  		    break;
    	}
     }     
    /**
    * setting sheet initial values and header<br>
    * adding case as numbers of counting sheets <br>
    * 
    * @param {ibsheet} sheetObj , IBSheet 
    * @param {number}  sheetNo  , IBSheet 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    var leftHeaders = [{Text:"1st|2nd|3rd", Align:"Left"}];
    function initSheet(sheetObj,sheetNo) {
        var sheetID=sheetObj.id;        
        var cnt=0;
        switch(sheetID) {
        // Setup Information
        case "sheet1":
        	with (sheetObj) {
            	//(11, 0, 0);
            	var HeadTitle1="|Seq|Send Type Code|Office Code|DEL|Auto|FOC|Trucker|Auto send only yard term|OBL Copy|Remart Setup|Content";
            	SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
            	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);
            	var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_seq",          KeyField:0 },
                         {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_snd_tp_cd",    KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ofc_cd",                KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"del_cd",                KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"auto_ntc_flg",          KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"each_foc_ntc_flg",      KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trkr_ntc_flg",          KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"auto_ntc_yd_flg",          KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eclz_obl_cpy_flg",      KeyField:1 },
                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"foc_clr_rmk_stup_flg",  KeyField:1 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hd_tit_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 } ];
            	InitColumns(cols);
            	SetVisible(false);
                SetSheetHeight(120);
        	}
        	break;
        // Word Information
        case "t1sheet1":
        case "t2sheet1":
            with (sheetObj) {
	            //(8, 0, 0, false);
	            var HeadTitle1="||||Seq|Form Code|Enclose O_B/L Copy|Bottom Remark";
	
	            SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );
	
	            var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_snd_tp_cd",  KeyField:1 },
	                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:1 },
	                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",              KeyField:1 },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"pkup_ntc_fom_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eclz_obl_cpy_flg",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"btm_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 } ];
	             
	            InitColumns(cols);
	            SetVisible(false);
            }
            break;
        // Hour Information
        case "t1sheet2":
        case "t2sheet2":
            with (sheetObj) {
	            var HeadTitle1="||||||||Movement Status|Condition|Time";
	
	            SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
	
	            var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Width:100,  Align:"Center",  ColMerge:0,   SaveName:"head" },
	                      {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_snd_tp_cd",  KeyField:1 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",              KeyField:1 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_cd",              KeyField:1 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_seq",        KeyField:0 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pkup_ntc_fom_cd",     KeyField:1 },
	                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ntc_seq",             KeyField:0 },
	                      {Type:"Combo",     Hidden:0, Width:260,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",         KeyField:0 },
	                      {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"ntc_cond_cd",         KeyField:0 },
	                      {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"ntc_bse_hrs",         KeyField:0 } ];

	            InitColumns(cols);
	            SetEditable(1);
	            SetCellEditable(i,"ntc_cond_cd",0);
	            SetCellEditable(i,"ntc_bse_hrs",0);
	            InitHeadColumn(leftHeaders, sheetObj);
	            SetColProperty("ntc_bse_hrs", {ComboText:"0Hours|6Hours|12Hours|24Hours|36Hours|48Hours|60Hours|120Hours", ComboCode:"0|6|12|24|36|48|60|120"} );
	            SetColProperty("ntc_cond_cd", {ComboText:"At|After", ComboCode:"AT|AF"} );
//	            SetColProperty("mvmt_sts_cd", {ComboText:evtValue, ComboCode:evtCode} );
	            SetColProperty("mvmt_sts_cd", {ComboText:"N/A|RL (Rail Departed)|AR (Arrival @ Rail Destination)|NT (Notification)|NF (Last Free Date)|NE (NF event date)", ComboCode:"NA|RL|AR|NT|NF|NE"} );
	            SetSheetHeight(140);
               for (var i=1; i<Rows; i++) {
            	   SetCellValue(i, "mvmt_sts_cd","NA");
            	   SetCellEditable(i, "ntc_cond_cd",0);
            	   SetCellEditable(i, "ntc_bse_hrs",0);
               }
            }
            break;  
        }
    }
    /**
    * handling of Sheet  <br>
    * 
    * @param {ibsheet} sheetObj ,IBSheet 
    * @param {object}  formObj  ,HTML Form 
    * @param {string}  sAction  ,Action 
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
       // sheetObj.WaitImageVisible = false;
        switch(sAction) {
        //  creating combo and searching list of DEL
        case IBSEARCH_ASYNC01:       
        	if (validateForm(sheetObj,formObj,sAction) == false) return; 
        	formObj.f_cmd.value=SEARCH01;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0411GS.do", FormQueryString(formObj), {Sync:1});
        	orgDelList=sXml;
        	ComXml2ComboItem(sXml, del_cd_list, "val", "name");
        	if (org_del_cd == "") {
            	del_cd_list.SetSelectCode("ALL");
        	} else {
            	del_cd_list.SetSelectCode(org_del_cd);
        	}
        	org_del_cd="";
        	break;
        case IBSEARCH:
            if (validateForm(sheetObj,formObj,sAction) == false) break; 
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_0411GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
  
            if (ComGetTotalRows(arrXml[0]) == 0)  isNew= true;
            else isNew=false;
            if (arrXml.length > 0) sheetObjects[SH_STUP].LoadSearchData(arrXml[0],{Sync:1} );
            if (arrXml.length > 1) sheetObjects[SH_PRE_FOM].LoadSearchData(arrXml[1],{Sync:1} );
            if (arrXml.length > 2) sheetObjects[SH_PRE_HRS].LoadSearchData(arrXml[2],{Append:-1 , Sync:1} );
            if (arrXml.length > 3) sheetObjects[SH_ARR_FOM].LoadSearchData(arrXml[3],{Sync:1} );
            if (arrXml.length > 4) sheetObjects[SH_ARR_HRS].LoadSearchData(arrXml[4],{Append:-1 , Sync:1} );

            //Sync:1 되지 않아서 문제 발생. 
            setTimeout( function () {
            	copyRowToForm();
            	ComOpenWait(false); 
                if (isNew == true) {
                	ComBtnDisable("btn_Copy");
                	ComShowCodeMessage("BKG00889");
                } else {
                	ComBtnEnable("btn_Copy");
                }
            } , 500); 
           	            
       //#8845 Pick Up Notice Option Set-Up 화면 Canada 경우도 추가      
            var eqOfcCntCd =ComGetEtcData(arrXml[0], "eqOfcCntCd");
                   
            if("US" == eqOfcCntCd){
    			document.getElementById("us_form").style.display="inline";
    			document.getElementById("us_form1").style.display="inline";
    			document.getElementById("ca_form").style.display="none";
    			document.getElementById("ca_form1").style.display="none";
            }else{
    			document.getElementById("us_form1").style.display="none";
    			document.getElementById("us_form").style.display="none";
    			document.getElementById("ca_form1").style.display="inline";
    			document.getElementById("ca_form").style.display="inline";
            }
            break;
        case IBSAVE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) {
        		break;
        	}
        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG01072"); 
	    	    resetSearchKeyword();
	    	    break;
        	}
            copyFormToRow();
            if (ComIsModifiedSheets(sheetObjects) == false) {
            	ComShowCodeMessage("BKG00743");
            	break;
        	}
    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}
            ComOpenWait(true);
        	setStatusFlag(sheetObjects);
            formObj.f_cmd.value=MULTI;
            var sParam=FormQueryString(formObj);
            var sParamSheet1=sheetObjects[SH_STUP].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sParamSheet2=sheetObjects[SH_PRE_FOM].GetSaveString();
            if (sParamSheet2 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
            }
            var sParamSheet3=sheetObjects[SH_PRE_HRS].GetSaveString();
            if (sParamSheet3 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet3, "sheet3_");
            }
            var sParamSheet4=sheetObjects[SH_ARR_FOM].GetSaveString();
            if (sParamSheet4 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet4, "sheet2_");
            }
            var sParamSheet5=sheetObjects[SH_ARR_HRS].GetSaveString();
            if (sParamSheet5 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet5, "sheet3_");
            }
            var sXml=sheetObj.GetSaveData("ESM_BKG_0411GS.do", sParam);
            sheetObjects[SH_STUP].LoadSaveData(sXml, {Sync:1});
			sXml=ComDeleteMsg(sXml);   /// showing the message once .
			sheetObjects[SH_PRE_FOM].LoadSaveData(sXml, {Sync:1});
			sheetObjects[SH_PRE_HRS].LoadSaveData(sXml, {Sync:1});
			sheetObjects[SH_ARR_FOM].LoadSaveData(sXml, {Sync:1});
			sheetObjects[SH_ARR_HRS].LoadSaveData(sXml, {Sync:1});
            ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgSaveCompleted();
	    		org_del_cd=document.form.del_cd.value;
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
            break;
            // Copy
        case IBSEARCH_ASYNC02:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}
        	var param="from_ofc_cd=" + formObj.ofc_cd.value + "&from_del_cd=" + formObj.del_cd.value;
        	
        	ComOpenPopup("/opuscntr/ESM_BKG_0992.do?" + param, 500, 190, "findCustomsCode", "1,0,1,1,1,1,1", true);
        	
        	/*var resultObj=ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0992.do?' + param, 500, 190, "", "none", true);
        	if (resultObj != null) {
        		formObj.ofc_cd.value=resultObj.ofc_cd;
        		formObj.del_cd.value=resultObj.del_cd;
        		org_del_cd=formObj.del_cd.value;
        		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        		doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	}*/
        	break;
        case IBDELETE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}
    		if (ComShowCodeConfirm("BKG00535") == false) {
    			break;
    		}
        	ComOpenWait(true);
        	formObj.f_cmd.value=MULTI01;
        	var sParam=FormQueryString(formObj) +  "&pkup_ntc_seq=" + sheetObjects[SH_PRE_FOM].GetCellValue(1, "pkup_ntc_seq");
        	var sXml=sheetObj.GetSaveData("ESM_BKG_0411GS.do", sParam);
        	sheetObjects[SH_STUP].LoadSaveData(sXml, {Sync:1});
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgDeleteCompleted();
				initForm();
			}
			//헤더이지만, sheetObjects[i].RemoveAll() 때문에 Row가 삭제됨. 
			 InitHeadColumn(leftHeaders,sheetObjects[SH_PRE_HRS]);
			 InitHeadColumn(leftHeaders,sheetObjects[SH_ARR_HRS]);
        	break;
         }
    }
    /**
     * registering IBTab Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {object} tab_obj , Tab 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    
	function findCustomsCode(rtnVal) {
		var formObj = document.form;
		formObj.ofc_cd.value=rtnVal.ofc_cd;
		formObj.del_cd.value=rtnVal.del_cd;
		org_del_cd=formObj.del_cd.value;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		
	}
	
    /**
     * setting Tab  <br>
     * setting item of Tab <br>
     * 
     * @param {object} tabObj , Tab 
     * @param {int}    tabNo  , Tab 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {                
                    var cnt=0 ;
                    InsertItem( "Pre-Arrival Notice" , "");
                    InsertItem( "Arrival Notice" , "");
                }
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
     * Event when clicking Tab <br>
     * activating selected tab items <br>
     * 
     * @param {object} tabObj , Tab 
     * @param {int}    nItem  , Tab 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        beforetab=nItem;                
    }
    /**
     *  copying sheet data to Form<br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function copyRowToForm() {
    	var formObj=document.form;
		var idx=0;
		var prefix="";
		var fom_cd="";
    		// Setup Information
		
		prefix="frm_";
		if (sheetObjects[SH_STUP].RowCount()== 0)
		{
			sheetObjects[SH_STUP].DataInsert(0);
			sheetObjects[SH_STUP].SetCellValue(1,"pkup_ntc_seq","");
			sheetObjects[SH_STUP].SetCellValue(1,"pkup_ntc_snd_tp_cd",formObj.ntc_snd_tp_cd.value);
			sheetObjects[SH_STUP].SetCellValue(1,"ofc_cd",formObj.ofc_cd.value);
			sheetObjects[SH_STUP].SetCellValue(1,"del_cd",formObj.del_cd.value.trim() == "" ? "ALL" : formObj.del_cd.value);
			sheetObjects[SH_STUP].SetCellValue(1,"auto_ntc_flg","Y");
			sheetObjects[SH_STUP].SetCellValue(1,"each_foc_ntc_flg","Y");
			sheetObjects[SH_STUP].SetCellValue(1,"trkr_ntc_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"auto_ntc_yd_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"eclz_obl_cpy_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"foc_clr_rmk_stup_flg","N");
			sheetObjects[SH_STUP].SetCellValue(1,"hd_tit_ctnt","");
		}
		IBS_CopyRowToForm(sheetObjects[SH_STUP], formObj, 1, prefix);
		for (var j=0; j<2; j++)
		{								
			if (j == 0) idx=SH_PRE_FOM;
			else idx=SH_ARR_FOM;
			// Pre-Arrival Word Information & Hour Information
			if (idx == SH_PRE_FOM) {
				prefix="frm_t1_";
				fom_cd="PRE";
			}
			// Arrival Word Information & Hour Information
			else {
				prefix="frm_t2_";
				fom_cd="ARR";
			}
			// Sheet Init
			if (sheetObjects[idx].RowCount()== 0)
			{
    			with (sheetObjects[idx]) 
    			{
        			DataInsert(0);
        			SetCellValue(1, "pkup_ntc_snd_tp_cd",formObj.ntc_snd_tp_cd.value);
        			SetCellValue(1, "ofc_cd",formObj.ofc_cd.value);
        			SetCellValue(1, "del_cd",formObj.del_cd.value.trim() == "" ? "ALL" : formObj.del_cd.value);
        			SetCellValue(1, "pkup_ntc_seq",sheetObjects[SH_STUP].GetCellValue(1, "pkup_ntc_seq"));
        			SetCellValue(1, "pkup_ntc_fom_cd",fom_cd);
        			SetCellValue(1, "eclz_obl_cpy_flg","N");
        			SetCellValue(1, "btm_rmk","");
    			}
    			with (sheetObjects[idx+1]) 
    			{
        			for (var i=0; i<RowCount(); i++) {
            			SetCellValue(i+1, "pkup_ntc_snd_tp_cd",formObj.ntc_snd_tp_cd.value);
            			SetCellValue(i+1, "ofc_cd",formObj.ofc_cd.value);
            			SetCellValue(i+1, "del_cd",formObj.del_cd.value.trim() == "" ? "ALL" : formObj.del_cd.value);
        				SetCellValue(i+1, "pkup_ntc_seq","");
        				SetCellValue(i+1, "pkup_ntc_fom_cd",fom_cd);
        				SetCellValue(i+1, "ntc_seq","");
        				SetCellValue(i+1, "mvmt_sts_cd","NA");
        				SetCellValue(i+1, "ntc_cond_cd","");
        				SetCellValue(i+1, "ntc_bse_hrs","");
        			}
    			}
			}
			// Hour Init
    		with (sheetObjects[idx+1]) 
    		{
    			for (var i=0; i<RowCount(); i++) {
    				if (GetCellValue(i+1, "mvmt_sts_cd") == "NA") {
    					SetCellEditable(i+1, "ntc_cond_cd",0);
    					SetCellEditable(i+1, "ntc_bse_hrs",0);
    				} else {
    					SetCellEditable(i+1, "ntc_cond_cd",1);
    					if (GetCellValue(i+1, "ntc_cond_cd") == "AT")
    						SetCellEditable(i+1, "ntc_bse_hrs",0);
    					else SetCellEditable(i+1, "ntc_bse_hrs",1);
    				}
    			}
    		}
        	IBS_CopyRowToForm(sheetObjects[idx], formObj, 1, prefix);
		}
		resetSetupFlag();
    }
    /**
     * copying Form data to sheet <br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function copyFormToRow() {
    	var formObj=document.form;
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_STUP], 1, "frm_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_PRE_FOM], 1, "frm_t1_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_ARR_FOM], 1, "frm_t2_");
    }
    /**
     *  changing status of sheet to U<br>
     * 
     * @param {array} sheets 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function setStatusFlag(sheets){
        for (var i=0;i<sheets.length;i++) {
        	for (var j=0;j<sheets[i].RowCount();j++) {
        		if(sheets[i].GetRowStatus(j+1) == "R") {
        			sheets[i].SetRowStatus(j+1,"U");
        		}
        	}
        }
    }      
    /**
     * returning condition which is changed or not<br>
     * 
     * @return boolean true: condition of searching is changed, false: not changed
     * @author 
     * @version 2009.07.09
     */
    function isChangedSearchKeyword() {
    	var formObj=document.form;
    	if (orgObj.ofc_cd  != formObj.ofc_cd.value) {
    		return true;
    	}
    	if (orgObj.del_cd  != formObj.del_cd.value) {
    		return true;
    	}
    	return false;
    }
    /**
     * saving condition of searching to check that changed or not<br>
     *
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function setSearchKeyword() {
    	var formObj=document.form;
    	orgObj.ofc_cd=formObj.ofc_cd.value;
    	orgObj.del_cd=formObj.del_cd.value;
    	orgObj.del_cd_list=orgDelList;
    	isRetrieved=true;
    }
    /**
     * reseting the value of changed searching condition without saving<br>
     *
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function resetSearchKeyword() {
    	var formObj=document.form;
    	formObj.ofc_cd.value=orgObj.ofc_cd;
    	formObj.del_cd.value=orgObj.del_cd;

    	ComXml2ComboItem(orgDelList, del_cd_list, "val", "name");    	
    	del_cd_list.SetSelectCode(orgObj.del_cd);
    }
    /**
     * reseting other flag as changing flag<br>
     *
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function resetSetupFlag() {
   	    var formObject=document.form;
		 if (formObject.frm_auto_ntc_flg.value == "Y" ) { // Auto
			 if (isNew == true) formObject.frm_each_foc_ntc_flg.value="N";
			 formObject.frm_each_foc_ntc_flg.disabled=false;
			 formObject.frm_trkr_ntc_flg.disabled=false;
			 formObject.frm_auto_ntc_yd_flg.disabled=false;
		 } else { // Manual
			 formObject.frm_each_foc_ntc_flg.disabled=true;
			 formObject.frm_trkr_ntc_flg.disabled=true;
			 formObject.frm_auto_ntc_yd_flg.disabled=true;
		 }
    }
     /**
      * handling process for input validation <br>
      * 
      * @param {ibsheet} sheetObj ,IBSheet 
      * @param {object}  formObj  ,HTML Form 
      * @param {string}  sAction  ,Action  
      * @return boolean Form   valid: true,  invalid: false
      * @author 
      * @version 2009.07.09
      */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj) {
        	switch(sAction) {
        	case IBSEARCH_ASYNC01:
        		if (!ComChkObjValid(formObj.ofc_cd)) return false;
        		break;
        	case IBSEARCH:
    	    	// maxlength, checking  Validation
  	    	    if (!ComChkObjValid(formObj.ofc_cd)) return false;
  	    	    if (!ComChkObjValid(formObj.del_cd)) return false;
    	    	break;
        	case IBSAVE:
//    	    	if (!ComChkValid(formObj)) return false;
//    	    	if (checkMaxLine(formObj.frm_t1_btm_rmk, 18) == false) {
//    	    		ComShowCodeMessage("BKG04012", formObj.frm_t1_btm_rmk.getAttribute("caption"), "18");
//    	    		tabObjects[0].selectedIndex=0;    	  
//    	    		formObj.frm_t1_btm_rmk.focus();
//    	    		return false;
//    	    	}
    	    	if (checkMaxLine(formObj.frm_hd_tit_ctnt, 2) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_hd_tit_ctnt.getAttribute("caption"), "2");
    	    		formObj.frm_hd_tit_ctnt.focus();
    	    		return false;
    	    	}
    	    	if (checkMaxLine(formObj.frm_t1_btm_rmk, 18) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_t1_btm_rmk.getAttribute("caption"), "18");
    	    		tabObjects[0].selectedIndex = 0;    	  
    	    		formObj.frm_t1_btm_rmk.focus();
    	    		return false;
    	    	}
    	    	if (checkMaxLine(formObj.frm_t2_btm_rmk, 18) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_t2_btm_rmk.getAttribute("caption"), "18");
    	    		tabObjects[0].selectedIndex = 1;    
    	    		formObj.frm_t2_btm_rmk.focus();
    	    		return false;
    	    	}
    	    	
    	    	for (var i=0; i<sheetObjects.length; i++) {
        			if (i == SH_PRE_HRS || i == SH_ARR_HRS) {
        				var sObj=sheetObjects[i];
        				var dupRow=checkHourDupValue(sObj);
        				if (dupRow > 0) {
        		        	ComShowCodeMessage("BKG00488");
        		        	if (i == SH_PRE_HRS) tabObjects[0].selectedIndex=0;
            				else tabObjects[0].selectedIndex=1;
        		        	sObj.SelectCell(dupRow, "mvmt_sts_cd");
        		        	return false;
        		        }
            			for(var j=0; j<sObj.RowCount(); j++) {
            				if (sObj.GetCellValue(j+1, "mvmt_sts_cd") != "NA" && sObj.GetCellValue(j+1, "mvmt_sts_cd") != "") {
            					if (sObj.GetCellValue(j+1, "ntc_cond_cd") == "") {
                    				if (i == SH_PRE_HRS) tabObjects[0].selectedIndex=0;
                    				else tabObjects[0].selectedIndex=1;
                    				ComShowCodeMessage("BKG01101", "Condition");
                    				sObj.SelectCell(j+1, "ntc_cond_cd");
                    				return false;
                    			}
            					if (sObj.GetCellValue(j+1, "ntc_bse_hrs") == "") {
                    				if (i == SH_PRE_HRS) tabObjects[0].selectedIndex=0;
                    				else tabObjects[0].selectedIndex=1;
                    				ComShowCodeMessage("BKG01101", "Time");
                    				sObj.SelectCell(j+1, "ntc_bse_hrs");
                    				return false;
                    			}
                			}
            			}
        			}
        		}
        		break;
        	}
        }
        return true;
    }
    /**
     * handling event after searching <br>
     * 
     * @param {ibsheet} sheetObj ,IBSheet 
     * @param {string}  ErrMsg   
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject=document.form;
      	//  saving condition of searching
     	setSearchKeyword();
    }
    
    function t1sheet2_OnSearchEnd(sheetObj , code , msg ){
    	 if( sheetObj.RowCount() < 1){
	          InitHeadColumn(leftHeaders,sheetObj);
	          //InitHeadColumn(leftHeaders1,sheetObj);
	    } else {
	    	InitHeadText(leftHeaders,sheetObj);
	   }
  	}
    
    function t2sheet2_OnSearchEnd(sheetObj , code , msg ){
    	 if( sheetObj.RowCount() < 1){
    		 InitHeadColumn(leftHeaders,sheetObj);
	         //InitHeadColumn(leftHeaders1,sheetObj);
	    } else {
	    	InitHeadText(leftHeaders,sheetObj);
	   }
   	}
    /**
     * setting Flag as changing in Hour sheet<br>
     * 
     * @param {ibsheet} sheetObj . Sheet ID
     * @param {int}     Row      . Sheet Row
     * @param {int}     Col      . Sheet Col
     * @param {string}  Value    . Sheet Cell 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function changeHoursSetup(sheetObj, Row, Col, Value) {
    	with (sheetObj) {
    		if (ColSaveName(Col) == "mvmt_sts_cd") {
    			if (Value == "NA") {
    				SetCellValue(Row, "ntc_cond_cd","");
    				SetCellValue(Row, "ntc_bse_hrs","");
    				SetCellEditable(Row, "ntc_cond_cd",0);
					SetCellEditable(Row, "ntc_bse_hrs",0);
    			} else {
    				SetCellEditable(Row, "ntc_cond_cd",1);
    				SetCellEditable(Row, "ntc_bse_hrs",1);
    			}
    		} else if (ColSaveName(Col) == "ntc_cond_cd") {
    			if (Value == "AT") {
    				SetCellValue(Row, "ntc_bse_hrs","0");
    				SetCellEditable(Row, "ntc_bse_hrs",0);
    			} else {
    				SetCellEditable(Row, "ntc_bse_hrs",1);
    			}
    		}
    	}
    }
    /**
     * changing Tab1 Sheet2 <br>
     * 
     * @param {ibsheet} sheetObj . Sheet ID
     * @param {int}     Row      . Sheet Row
     * @param {int}     Col      . Sheet Col
     * @param {string}  Value    . Sheet cell
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function t1sheet2_OnChange(sheetObj, Row, Col, Value) {
    	changeHoursSetup(sheetObj, Row, Col, Value);
    }
    /**
    * changing Tab2 Sheet2 <br>
    * 
    * @param {ibsheet} sheetObj . Sheet ID
    * @param {int}     Row      . Sheet Row
    * @param {int}     Col      . Sheet Col
    * @param {string}  Value    . Sheet cell
    * @return 
    * @author 
    * @version 2009.07.09
    */
    function t2sheet2_OnChange(sheetObj,Row, Col, Value) {
    	changeHoursSetup(sheetObj, Row, Col, Value);
    }
    /**
     * DEL combo Change <br>
     *  changing DEL_CD to code<br>
     * 
     * @return 
     * @author 
     * @version 2009.07.09
     */
    //[2:56:25 PM] Tuan Luc Duong: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

    function del_cd_list_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form;
    	if (!isAutoSelect) {  
        	formObj.del_cd.value=del_cd_list.GetSelectCode();
    	}
    }
    /**
     *  handling focus event with DEL combo<br>
     * setting false
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function del_cd_list_OnFocus() {
    	isAutoSelect=false;
    }
    /**
     *  checking duplication in Movement sheet
     * 
     * @param {ibsheet} sheetObj . Sheet Object
     * @return int. duplicated Row
     * @author 
     * @version 2009.07.09
     */
    function checkHourDupValue(sheetObj) {
    	var str="";
    	var dupRow=-1;
    	for(var i=0; i<sheetObj.RowCount(); i++) {
    		if (sheetObj.GetCellValue(i+1, "mvmt_sts_cd") == "NA" || sheetObj.GetCellValue(i+1, "mvmt_sts_cd") == "-") continue;
    		for (var j=i+1; j<sheetObj.RowCount(); j++) {
    			if (sheetObj.GetCellValue(i+1, "mvmt_sts_cd") == sheetObj.GetCellValue(j+1, "mvmt_sts_cd")) {
    				dupRow=j+1;
    				break;
    			}
    		}
    		if (dupRow > 0) break;
    	}
    	return dupRow;
    }
    /**
     * selecting code which is same with DEL Combo in case of changing DEL code<br>
     * 
     * @param {object} obj      . DEL  
     * @param {object} comboObj . DEL Combo 
     * @return 
     * @author 
     * @version 2009.07.09
     */	
	function fncFindDelComboCode(obj, comboObj) {
		var idx=-1;
		isAutoSelect=true;
//no support[check again]CLT 		document.form.del_cd_list.UseCode=false;
		for(var i=0;i<comboObj.GetItemCount();i++){
			if(obj.value.trim() == comboObj.GetText(i,0).substring(0,obj.value.length)){
				idx=i;
				break;
			}
		}	
//no support[check again]CLT 		document.form.del_cd_list.UseCode=true;
		if (idx > -1) comboObj.SetSelectIndex(idx);
	}
    /**
     *  limiting the number of Text Area line <br>
     *  calling from onKeyPress , limiting the number of Text Area line <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="textarea" name="txtRmk" onKeyPress="checkMaxLine(this, 5)"&gt;
     * </pre>
     *  
     * @param {object} obj      , HTML Tag(Object)
     * @param {number} maxLine  ,the max number of Line 
     * @return  <br>
     * @author 
     * @version 2009.07.09
     */
    function checkMaxLine(obj, maxLine) {
        var ln=getLine(obj);
        if (event.keyCode == 13) {
            if (ln >= maxLine) {
            	return false;
            }
        } else {
            if (ln > maxLine) {
            	return false;
            }
        }
        return true;
    }
    /**
     * returning the number of object line <br>
     *  using to limit the max of line <br>
     * 
     * @param {object} obj , HTML tag(Object)
     * @return int. the number of line
     * @author 
     * @version 2009.07.09
     */
    function getLine(obj) {
        var str_len=obj.value;
        line=str_len.split("\r\n");
        return line.length;
    }
	/* the end of developer's work */
