/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0204.js
*@FileTitle  : Dangerous cargo application
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
    /* developer job	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var opener=window.dialogArguments;
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
        function processButtonClick(){
             var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
    				switch(srcName) {
    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[0],document.form,SEARCH);
    					break;
    					case "btn_Select":
    						var polCntCd = document.form.pol_cd.value.substr(0,2);
    						var podCntCd = document.form.pod_cd.value.substr(0,2);
    						var selectRow = sheetObjects[0].GetSelectionRows("/");
    						var cfrFlg = sheetObjects[0].GetCellValue(selectRow, "cfr_flg");
   							if(cfrFlg == "Y" && (polCntCd != "US" && podCntCd != "US")){
       							ComShowCodeMessage("BKG02125");
       							return false;
       						}
    						comPopupOK();     						
    					break;
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
    	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
    	 * defining list on the top of source
    	 */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
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
            if(document.getElementById("pop_type").value == "PA" || document.getElementById("pop_type").value == "OA"){
            	ComBtnDisable("btn_Select");
            }
            doActionIBSheet(sheetObjects[0],document.form,INIT);
    		initControl();
        }
         function initControl() {    	  
//       	    axon_event.addListenerForm('keypress','obj_keypress', form);
//       	    axon_event.addListenerForm('keydown','obj_keydown', 	form);   
       		axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form);
       	    if(document.getElementById("imdg_un_no").value != ""){
       	    	doActionIBSheet(sheetObjects[0],document.form,SEARCH);
       	    }
       	}  
     	function obj_deactivate() {
     		ComAddSeparator(event.srcElement);
     	}
     	/**
     	 * setting sheet initial values and header
     	 * param : sheetObj, sheetNo
     	 * adding case as numbers of counting sheets
     	 */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetId=sheetObj.id;
            switch(sheetId) {
                case "sheet1":
                    with (sheetObj) {
                    var HeadTitle="Sel|Sel.|UN No.|UN No.|Class|Class|P.GRP|Proper Shipping Name|Variation Remarks|Technical Name|SRL1|SRL2|SRL3|SRL4" +
                    "|Flash Point|PSA|Marine Pollutant|EMS No.|ERG|ERG|Limited Q’ty|Limited Q’ty|Excepted Q‘ty|Excepted Q‘ty|HCDG|Depends||||";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                              {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"check",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm_var_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"imdg_tec_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"srl1",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"srl2",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"srl3",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"srl4",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_temp_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_emer_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",     KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"limited_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_cd",         KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_crr_rstr_expt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_pck_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_intmd_bc_rstr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_ctrl_temp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_emer_temp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_nos",  	   KeyField:0,	CalcLogic:"",	Format:"",			PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",  		   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",  		   			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                              ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetColProperty("imdg_pck_grp_cd", {ComboText:"I|II|III", ComboCode:"1|2|3"} );
                    SetSheetHeight(260);
    			}
    			break;
            }
        }
     // handling of Sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
    		  case INIT:      //Default
    			formObj.f_cmd.value=INIT;
    			var sXml=sheetObj.GetSearchData("ESM_BKG_0204GS.do", FormQueryString(formObj));
    			var imdgAmdtNos=ComGetEtcData(sXml,"IMDG_AMDT_NO");
    			var imdgAmdtNo_arr= new Array();
    			var imdgAmdtNoOrigin = document.getElementById("imdg_amdt_no_origin").value;
    			var selectIndex = 0; //the index of default amendment No
    				
    			if(imdgAmdtNos!=''){
    				imdgAmdtNo_arr = imdgAmdtNos.split(','); //set the result of query
    			}
    			var addImdgAdmtNoFlg="Y";
    			if(imdgAmdtNoOrigin != ""){
	    			for (var i = 0; i < imdgAmdtNo_arr.length; i++){
	    				if(imdgAmdtNo_arr[i] == imdgAmdtNoOrigin){
	    					addImdgAdmtNoFlg="N";
	    					selectIndex = i;
	    				}
	    			}
    			}else{
    				addImdgAdmtNoFlg="N";
    			}
    			if(addImdgAdmtNoFlg=="Y"){
    				selectIndex = imdgAmdtNo_arr.length;
    				imdgAmdtNo_arr.push(imdgAmdtNoOrigin); //add the original amendment No if it does not exist in query result
    			}
    			
    			ComArrayToOptions(imdgAmdtNo_arr, document.getElementById("imdg_amdt_no"));
    			document.getElementById("imdg_amdt_no").selectedIndex = selectIndex;
   			
    			break;

    		  case SEARCH:      // RETRIEVE
                sheetObj.SetColHidden("imdg_subs_rsk_lbl_rmk",0);
              	if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_0204GS.do", FormQueryString(formObj) );
					for(var i=1; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "crr_cd") != ""){
							 sheetObj.SetCellValue(i, "imdg_crr_rstr_expt_cd","R",0);
						 }						 
					}
					/*
					var cnt=0;
					for (var i=1; i <= sheetObj.RowCount(); i++){
if(sheetObj.GetCellValue(i,"imdg_subs_rsk_lbl_rmk") == ""){
							cnt++;
						}
					}
					if(cnt == sheetObj.RowCount()){
						sheetObj.SetColHidden("imdg_subs_rsk_lbl_rmk",1);
					}
					*/
				}
              break;             
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }
            return true;
        }
       /* developers work end */

        /**
         * When ENTER is pressed on the ibSheet, behavior is same as clicking 'Select'
         */
        function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
        	if(KeyCode==13){
        		comPopupOK();
        	}
        }
