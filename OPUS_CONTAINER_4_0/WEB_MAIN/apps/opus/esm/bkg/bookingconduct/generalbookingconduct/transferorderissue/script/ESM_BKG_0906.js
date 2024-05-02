/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0906.js
*@FileTitle  : TRO-Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /* Global Variables */
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler defined process to button click event */
    document.onclick=processButtonClick;
    /* Event handler is branch processing by name of button */
    function processButtonClick(){
    	/***** Assignment sheet in case of over 2 by tab****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Confirm":
					doActionIBSheet(sheetObject1, formObject, IBSAVE, MULTI);
	                break; 
				case "btn_Close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
    	}
    }
    /**
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing sheet
     * To implement onLoad event of body tag
     * Add functionality to after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);                
            ComEndConfigSheet(sheetObjects[i]);
        }
//        axon_event.addListenerFormat('keypress', 'obj_KeyPress',   form);
//        axon_event.addListenerForm  ('click',    'obj_click',      form); 
//        axon_event.addListenerForm  ('change',   'obj_change_loc', form);
        axon_event.addListenerForm  ('beforedeactivate', 'bkg0906_deactivate',  form); //- 포커스 나갈때
        initControl();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);        
    }
    function initControl() {
    	var formObj=document.form;
    	formObj.bkg_no.focus(); 
    	var ioBoundCd=formObj.io_bnd_cd.value ;
    	if (ioBoundCd == "O") {
    		document.getElementById("div_inbound").style.display="none";
//    		formObj.sheet1.SetSheetHeight(210);
    	} else {
    		document.getElementById("div_inbound").style.display="block";
    	}
    }
    function obj_click() {
		var formObj=document.form; 
		with(formObj) {
			switch(event.srcElement.name){			   
	            case "rdo_cct_ofc_cd":
	            	if (rdo_cct_ofc_cd[0].checked) {
	            	    cct_ofc_cd.value=cre_ofc_cd.value;
	            	} else if (rdo_cct_ofc_cd[1].checked) {
	            		cct_ofc_cd.value=clt_ofc_cd.value;
	            	}
	            	break;
			}
		}
    }
    /**
    * change event
    */
    function obj_change_loc() {
    	var formObj=document.form;
		with(formObj) {
			switch(event.srcElement.name){
	            case "chk_range_1":
	            case "chk_range_2": 
					if (formObj.chk_range_1.value.trim() == "" || 
						formObj.chk_range_2.value.trim() == "") {
						return;
					}
					var chk_range1=parseInt(formObj.chk_range_1.value);
					var chk_range2=parseInt(formObj.chk_range_2.value);
					for (var i=1; i<=sheetObjects[0].LastRow(); i++) {
						if (sheetObjects[0].GetCellEditable(i, "chk") == true &&
								parseInt(sheetObjects[0].GetCellValue(i, "tro_seq")) >= chk_range1 &&
								parseInt(sheetObjects[0].GetCellValue(i, "tro_seq")) <= chk_range2 ) {
							sheetObjects[0].SetCellValue(i, "chk","1",0);
						} else {
							sheetObjects[0].SetCellValue(i, "chk","",0);
						}
					}
					formObj.chk_range_1.value="";
					formObj.chk_range_2.value="";
	            	break;
			}
		}
    }
    /**
     * Initializing sheet. Defining header
     * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
     * Composition a initial module in case of multi sheet
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //hidden sheet1
	            with (sheetObj) {	
			        var HeadTitle="|||SEQ|Container No.|Status|Currency|Rate|Manifested|T1 Doc|Add Rate|Charge|VAT||||||||||||";
			        var headCount=ComCountHeadTitle(HeadTitle);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"CheckBox",  Hidden:0, Width:21,   Align:"Center",  ColMerge:0,   SaveName:"chk",              KeyField:0 },
			               {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cfm_flg_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trns_rev_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"all_in_rt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"t1_doc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"add_rev_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"add_rev_chg_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vat_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hlg_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"corr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_trsp_mzd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_pkup_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rtn_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"zn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
//			        SetSheetHeight(120);
			        SetSheetHeight(200);
			    }
				break; 	
		}
	}
    /* Processing Sheet */
    function doActionIBSheet(sheetObj, formObj, sAction, sCmd) {    	
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //retrieving            		
	          	if(!validateForm(sheetObj,formObj,sAction)){
 	          		return false;
 	          	}          	
	          	formObj.f_cmd.value=SEARCH;
          		sheetObj.DoSearch("ESM_BKG_0906GS.do", FormQueryString(formObj) );
                break;
          	case COMMAND01:  
          		formObj.f_cmd.value=COMMAND01;
          		var SaveXml = sheetObj.DoSearch("ESM_BKG_0906GS.do", FormQueryString(formObj) );
          		sheetObj.LoadSaveData(SaveXml);
          		break;
          	case IBSAVE: 
 	          	if(!validateForm(sheetObj, formObj, sAction, sCmd)){
 	          		return false;
 	          	}
            	if (formObj.rdo_cct_ofc_cd[0].checked) {
            		formObj.cct_ofc_cd.value=formObj.cre_ofc_cd.value;
            	} else if (formObj.rdo_cct_ofc_cd[1].checked) {
            		formObj.cct_ofc_cd.value=formObj.clt_ofc_cd.value;
            	}
            	formObj.f_cmd.value=sCmd
				var params=FormQueryString(formObj);
				var params2="";
				var sXml="";
				var chkCnt=0;
				sheetObj.SetWaitImageVisible(false);
				ComOpenWait(true);
				for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
//					//alert(i + ":"+sheetObj.CellValue(i, "chk") );
					if("1" != sheetObj.GetCellValue(i, "chk")){
						continue;
					}
					params2="&sheet1_"+"radio="				+ sheetObj.GetCellValue(i, "radio") +
					"&sheet1_"+"ibflag="			+ sheetObj.GetCellValue(i,	"ibflag") +
					"&sheet1_"+"tro_seq_disp="		+ sheetObj.GetCellValue(i,	"tro_seq_disp") +
					"&sheet1_"+"tro_seq="			+ sheetObj.GetCellValue(i,	"tro_seq") +
					"&sheet1_"+"cntr_no="			+ sheetObj.GetCellValue(i,	"cntr_no") +
					"&sheet1_"+"cfm_flg_old="		+ sheetObj.GetCellValue(i,	"cfm_flg_old") +
					"&sheet1_"+"curr_cd="			+ sheetObj.GetCellValue(i,	"curr_cd") +
					"&sheet1_"+"trns_rev_amt="		+ sheetObj.GetCellValue(i,	"trns_rev_amt") +
					"&sheet1_"+"all_in_rt_cd="		+ sheetObj.GetCellValue(i,	"all_in_rt_cd") +
					"&sheet1_"+"t1_doc_flg="		+ sheetObj.GetCellValue(i,	"t1_doc_flg") +
					"&sheet1_"+"vat_flg="			+ sheetObj.GetCellValue(i,	"vat_flg") +
					"&sheet1_"+"cxl_flg="			+ sheetObj.GetCellValue(i,	"cxl_flg") +
					"&sheet1_"+"bkg_no="			+ sheetObj.GetCellValue(i,	"bkg_no") +
					"&sheet1_"+"io_bnd_cd="			+ sheetObj.GetCellValue(i,	"io_bnd_cd") +
					"&sheet1_"+"hlg_tp_cd=" 		+ sheetObj.GetCellValue(i,	"hlg_tp_cd") +
					"&sheet1_"+"corr_no="			+ sheetObj.GetCellValue(i,	"corr_no") +
					"&sheet1_"+"cfm_dt="			+ sheetObj.GetCellValue(i,	"cfm_dt") +
					"&sheet1_"+"cfm_flg="			+ sheetObj.GetCellValue(i,	"cfm_flg") +
					"&sheet1_"+"bkg_trsp_mzd_cd="	+ sheetObj.GetCellValue(i,	"bkg_trsp_mzd_cd") +
					"&sheet1_"+"cntr_pkup_yd_cd="	+ sheetObj.GetCellValue(i,	"cntr_pkup_yd_cd") +
					"&sheet1_"+"cntr_rtn_yd_cd="	+ sheetObj.GetCellValue(i,	"cntr_rtn_yd_cd") +
					"&sheet1_"+"zn_cd="				+ sheetObj.GetCellValue(i,	"zn_cd") +
					"&sheet1_"+"add_rev_amt="		+ sheetObj.GetCellValue(i,	"add_rev_amt") +
					"&sheet1_"+"add_rev_chg_cd="	+ sheetObj.GetCellValue(i,	"add_rev_chg_cd") +
					"&sheet1_"+"cntr_tpsz_cd="		+ sheetObj.GetCellValue(i,	"cntr_tpsz_cd");
					//alert(params + params2);
					sXml=sheetObj.GetSaveData("ESM_BKG_0906GS.do", params + params2);
					if(ComGetEtcData(sXml, "isSuccess") != "Y"){
						//booking data interface => INV
						f_interfaceToInv(false,chkCnt);
						sheetObj.LoadSaveData(sXml);
						sheetObj.SetCellValue(i, "chk","0");
		            	return false;
					}
					chkCnt++;
				}
				//booking data interface => INV
				f_interfaceToInv(true,chkCnt);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				var obj=new Object();
				obj.msg="OK";
				ComPopUpReturnValue(obj);
//				ComClosePopup();    
            	break;					
		}
        return true;
    }        
    function f_interfaceToInv(result,chkCnt){
    	var formObj=document.form;
    	if (chkCnt > 0){
    		doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
    	}
    	ComOpenWait(false);
    }
    //#################(Event)############################
    // Sheet saveEnd
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)
    {
    	var formObj=document.form;
//		if (ErrMsg.trim() == ComGetMsg('BKG00166')) {
		if (ComTrim(ErrMsg) == ComTrim(ComGetMsg('BKG00166'))) {				
			pre_comPopupOK();
		}
    }
    // Sheet searchEnd
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
   	    var formObj=document.form;
 		with(sheetObj)
 		{
 			formObj.cre_ofc_cd.value=sheetObj.GetEtcData("cre_ofc_cd"); //ComGetEtcData("cre_ofc_cd");
 			formObj.clt_ofc_cd.value=sheetObj.GetEtcData("clt_ofc_cd"); //ComGetEtcData("clt_ofc_cd");
 	   	    formObj.payer_cnt_cd.value=(sheetObj.GetEtcData("payer_cnt_cd")  == undefined)? '' : sheetObj.GetEtcData("payer_cnt_cd");
 	        formObj.payer_seq.value=(sheetObj.GetEtcData("payer_seq")  == undefined)? '' : sheetObj.GetEtcData("payer_seq");
 	   	    formObj.payer_nm.value=sheetObj.GetEtcData("payer_nm"); 
 		}
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
 				if ("Y" == GetCellValue(i, "cxl_flg") || "Yes" == GetCellValue(i, "cfm_flg")) {
					SetCellEditable(i, "chk",0);
				} else {
					SetCellEditable(i, "chk",1);
				}
 				if ("Yes" == GetCellValue(i, "cfm_flg")) {
 					SetCellFontColor(i, "cfm_flg","#FF0000");
				} else {
					SetCellFontColor(i, "cfm_flg","#000000");
				}
 			}
 		}	
    }
    //#################(Etc/Logic)############################
    /**
     * Checking validation of input value
     */
    function validateForm(sheetObj,formObj,sAction,sCmd){
        with(formObj)
        {
        	switch (sAction) {
         	    case IBSEARCH:
 					if (bkg_no.value == "") {
 					    ComShowCodeMessage("BKG00255");
 					    return false;
 					}
         	    	break;
         	    case IBSAVE:
					if ( sheetObj.CheckedRows("chk") < 1 ) {
						ComShowCodeMessage("BKG00155");
						return false;
					}
 					if (sCmd == MULTI) {
 						if (!setConfirm()) {
 							return false;
 						}
 					} else if (sCmd == MULTI01) {
 						if (!setCancel()) {
 							return false;
 						}
 					}
         	    	break; 
            }
        }
        return true;
    }
 	/**     
 	 * setCancel -> cxl_flg check
 	 */
 	function setCancel() {
 	    var formObj=document.form;
 		var sheetObj=sheetObjects[0]; 
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{				
 				if (GetCellValue(i, "chk") == 1) {
 					var cxlFlg=GetCellValue(i, "cxl_flg");
 					if (cxlFlg == "Yes") {
 						ComShowCodeMessage("BKG00384");
 						return false;
 					}
 				} 
 			}
 			if (!ComBkgProcessYn("Cancel")) {
 	    		return false;
 	    	}
 			var toDay=ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting
 			for (var i=1; i<=LastRow(); i++)
 			{ 				
 				if (GetCellValue(i, "chk") == 1) {
 					SetCellValue(i, "cfm_dt",toDay,0);
 				} 
 			}
 		}
 		return true;
 	}
 	/**     
 	 * setConfirm -> status check / cfm_dt set
 	 */
 	function setConfirm() {
 	    var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		var j=0 ;
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow(); i++)
 			{
 				if (GetCellValue(i, "chk") == 1) {
 					if (!setCfmCheck(sheetObj, i, "chk")) {
 						return false;
 					}
 					j=j + 1;
// 					if  (j > 3) {
// 			 			ComShowCodeMessage("BKG08169", "Confirm is available up to 3 TROs at the same time due to system performance!!");
// 		 	 			return false;
// 					}
 				} 
 			}
 			var boundCd=formObj.io_bnd_cd.value;
 			if (boundCd == "I") {
 	 			//checking mandatory : radiobox
 	 			if (!formObj.rdo_cct_ofc_cd[0].checked && !formObj.rdo_cct_ofc_cd[1].checked) {
 	 				ComShowCodeMessage("BKG00888", "Office Code[TRO/CCT at B/L]");
 	 				return false;
 	 			}
 	 			//checking CCT at B/L mandatory : radiobox check
 	 			if (formObj.rdo_cct_ofc_cd[1].checked){
 	 				if(formObj.clt_ofc_cd.value == "") {
 	 					ComShowCodeMessage("BKG00068", "CCT at B/L Office Code");
 	 	 				return false;
 	 				}else{
 	 					if(!fnExistOfcCode(formObj.clt_ofc_cd.value)){
 	 	 					ComShowCodeMessage("BKG00068", "CCT at B/L Office Code");
 	 						return false;
 	 					}
 	 				}
 	 			}
 	 			
	 			if (!ComBkgProcessYn("Confirm")) {
	 	    		return false;
	 	    	}
 			} else if (boundCd == "O") {
 				if (!ComBkgProcessYn("Confirm")) {
     	    		return false;
     	    	}
 			}
 			if (boundCd == "I") {
 				for (var i=1; i<=LastRow(); i++)
 				{
 					if(GetCellValue(i, "chk") == 1) {
 						var now_cntr_no=GetCellValue(i, "cntr_no");
 						//alert(now_cntr_no);
 						var nRow=sheetObj.FindText("cntr_no", now_cntr_no);
 						//alert(nRow);
 						var test=GetCellValue(nRow, "cfm_flg_old");
 						//alert(test); (nRow != i && test == "Yes")
 						if (nRow != i) {
 							//ComShowCodeMessage("BKG08171", "Duplicated container no!! Please check container no again");
 							//return false;
 						}
 					}
 				}
 			}
 			var toDay=ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting
 			for (var i=1; i<=LastRow(); i++)
 			{ 				
 				if (GetCellValue(i, "chk") == 1) {
 					SetCellValue(i, "cfm_dt",toDay,0);
 					SetCellValue(i, "cfm_flg","Yes",0);
 					//containerNo check 
 					if (boundCd == "I") {
 						if (GetCellValue(i, "cntr_no") == "") {
	 						ComShowCodeMessage("BKG01028");
	 	 	 				return false;
	 					}
 					}
 				} 
 			}
 		}
 		return true;
 	} 	
 	
 	function fnExistOfcCode(input_text) {
 		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
		var param="&f_cmd=" + SEARCHLIST19 + "&input_text=" + input_text;
		var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
		var output_text=ComGetEtcData(sXml, "output_text");
		if (output_text == 'Y') {
			return true;
		} else {
			return false;
		}
 	}  
 	/**     
 	  * setCfmCheck -> cfm_upd_dt set
 	  */
 	function setCfmCheck(sheetObj, nRow, colId) {
 		var formObj=document.form;
 		with(sheetObj) {
 			var cfmFlg=GetCellValue(nRow, "cfm_flg");
 			var cfmFlgOld=GetCellValue(nRow, "cfm_flg_old");
 			var cxlFlg=GetCellValue(nRow, "cxl_flg");
 			if (cfmFlgOld == "Yes") {
 				ComShowCodeMessage("BKG00383");
 				return false;
 			}
 			if (cxlFlg == "Yes") {
 				ComShowCodeMessage("BKG00384");
 				return false;
 			}
 		}
 		return true;
 	} 	
	/**
	 * parent : default Recall 
	 */
    function pre_comPopupOK() {
	   	sheetObjects[0].SetCellValue(1, "radio","Y",0);
   	    comPopupOK();
    } 
    function bkg0906_deactivate() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if(srcName == "payer_cnt_cd"){
    		if(ComIsNull(srcValue)){
        		ComSetObjValue(formObject.payer_nm,"");
        	}
		}else if(srcName == "payer_seq"){
			if(ComIsNull(srcValue)){
				ComSetObjValue(formObject.payer_nm,"");
			}else{
				ComSetObjValue(formObject.payer_seq,ComLpad(srcValue,6,"0"));
				if(ComChkLen(formObject.payer_cnt_cd, 2) == "2"){
					formObject.f_cmd.value=SEARCHLIST14;
					var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0079_01GS.do?cust_cnt_cd="+ComGetObjValue(formObject.payer_cnt_cd)+"&cust_seq="+ComGetObjValue(formObject.payer_seq), FormQueryString(formObject));
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
						ComSetObjValue(formObject.payer_nm,ComGetEtcData(sXml,"cust_nm"));
					}else{
						ComSetObjValue(formObject.payer_nm,"");
					}
				}
			}
		}
    }