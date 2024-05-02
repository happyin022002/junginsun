/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0077.js 
*@FileTitle  : Booking Copy 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // global variable
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var gXml = "";
 var mnlAllowFlg ="";
 var oldCopycnt ="";
 
 // Event handler processing by button click event  */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
 		         var sheetObject=sheetObjects[0];
          /*******************************************************/
        var formObj=document.form;
		var bkgNo=ComGetObjValue(formObj.bkg_no);
		var bkgStsCd=ComGetObjValue(formObj.bkg_sts_cd);
		var bdrFlg=ComGetObjValue(formObj.bdr_flg);
		var bkgTrunkVvd=ComGetObjValue(formObj.bkg_trunk_vvd);
		var porCd=ComGetObjValue(formObj.por_cd);
		var polCd=ComGetObjValue(formObj.pol_cd);
		var podCd=ComGetObjValue(formObj.pod_cd);
		var delCd=ComGetObjValue(formObj.del_cd);
		var sCustCntCd=ComGetObjValue(formObj.s_cust_cnt_cd);
		var sCustSeq=ComGetObjValue(formObj.s_cust_seq);
		var fCustCntCd=ComGetObjValue(formObj.f_cust_cnt_cd);
		var fCustSeq=ComGetObjValue(formObj.f_cust_seq);		
		var cCustCntCd=ComGetObjValue(formObj.c_cust_cnt_cd);
		var cCustSeq=ComGetObjValue(formObj.c_cust_seq);	
		var bkgCtrlPtyCustCntCd=ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd);
		var bkgCtrlPtyCustSeq=ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq);
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
         		case "btn_RfaNo":
         			comBkgPop0654('callBack0654',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq);
         			break;    	
         		case "btn_ScNo":
         			comBkgPop0655('callBack0655',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq);
         			break;    	  
         		case "btn_TtaNo":
         			comBkgPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq);
            		break;
 				case "btn_New": 					
					ComResetAll();
					ComSetObjValue(formObj.bkg_no, bkgNo);
					ComSetObjValue(formObj.bkg_sts_cd, bkgStsCd);
					ComSetObjValue(formObj.bdr_flg, bdrFlg);
					manualBookingCopyOn(false);
 					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 					break; 							
 				case "btn_Copy":
 					doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
 					break;  
				case "btn_Print":
//no support[check again]CLT 					sheetObjects[1].ExcelPrint="PrintOnly";
                    sheetObjects[1].Down2Excel();
					break;
				case "btn_Close":
                    ComClosePopup(); 
					break;
				case "btn_Test":
					manualBookingStatusValidation();
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
    
    function comBkgPop0654(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq){
        ComOpenPopup("ESM_BKG_0654.do?pgmNo=ESM_BKG_0654&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq, 860, 475, callback_func,"1,0", false);
	}
    
    function comBkgPop0655(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq){
        ComOpenPopup("ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq, 1024, 480, callback_func,"1,0,", false);
	}
    function comBkgPop1062(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq){
        ComOpenPopup("ESM_BKG_1062.do?pgmNo=ESM_BKG_1062&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq, 860, 475, callback_func,"1,0", false);
	}
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     * @param sheet_obj IBSheet Object
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
        initControl();
        var formObj=document.form;
        formObj.mnl_flg.value = "N";
        formObj.save_fin_flg.value = "N";
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    }
	 /**
	  * init Control
	  */
	 function initControl() {
	 	var formObj=document.form;
		 axon_event.addListenerForm('blur', 'bkg0077_blur',  formObj);
		 axon_event.addListenerForm('click', 'bkg0077_click',  formObj);
	 }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
         	case "sheet1":      //sheet1 init
                with(sheetObj){
                    var HeadTitle="||POL|POL|POL|POD|POD|POD|VVD|POL ETD|POL ETD|POL ETA|POL ETA";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, AcceptKeys:"E|N", InputCaseSensitive:1 },
                                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"etd_day",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"etd_time",               KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eta_day",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eta_time",               KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq_list" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq_list" },
                                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"voyage_time" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"etd" },
                                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eta" } ];
                                                          
                    InitColumns(cols);

                    SetEditable(1);
                    SetCountPosition(0);
                    SetSheetHeight(120);
                }
         		break;
         		
         	case "sheet2":      //sheet2
                with(sheetObj){
                    var HeadTitle="New Booking Number|New Booking Number|New Booking Number";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"new0",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"new1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"new2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                    InitColumns(cols);

                    SetEditable(1);
                    SetCountPosition(0);
                    SetRowHidden(0, 1);
                    SetSheetHeight(120);
                }
             	break;
             	
			case "sheet3":
                with(sheetObj){
                    var HeadTitle="TP/SZ|Vol.";

                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"c_tpsz",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"c_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
                                                       
                    InitColumns(cols);

                    SetEditable(1);
                    SetCountPosition(0);
                    SetVisible(0);
                }
				break;
			
			case "sheet4":      //sheet4
                with(sheetObj){
                    var HeadTitle="Manual Booking Number|Manual Number|Manual Booking Number";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl0",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                                          
                    InitColumns(cols);

                    SetEditable(1);
                    SetCountPosition(0);
                    SetRowHidden(0, 1);
                    SetSheetHeight(120);
                }
             	break;
             	
			case "sheet5":      //sheet4
                with(sheetObj){
                    var HeadTitle="Manul Status|Manul Status|Manul Status";

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl_bkg_sts_0",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl_bkg_sts_1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"mnl_bkg_sts_2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                                          
                    InitColumns(cols);

                    SetEditable(1);
                    SetCountPosition(0);
                    SetSheetHeight(120);
                }
             	break;
         }
     }
     /**
      * Sheet process handling
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      //Retrive
   				formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("ESM_BKG_0077GS.do", FormQueryString(formObj));

         		BkgEtcDataXmlToForm(sXml, formObj);
		   		ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
       			ComSetObjValue(formObj.vvd_modify_flg, "Y");     
         		sheetObj.LoadSearchData(sXml);
                break;
 			case IBSAVE:        //Save
           		if(validateForm(sheetObj,formObj,sAction)){
           			sheetObjects[1].RemoveAll();
            		if(ComGetObjValue(formObj.vvd_modify_flg) == "N"){
            			ComSetObjValue(formObj.f_cmd, MULTI02);	// Copy No Route      copyBkgWithRoute(e);
            		}else{
        				ComSetObjValue(formObj.f_cmd, MULTI01);	// Copy With Route    copyBkgWithoutRoute(e);
            		}
            		var params=FormQueryString(formObj);	
    				params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true),"sheet1_");
    				if(formObj.mnl_flg_chk.checked){
    					params = params + "&" + createManualBookingCopyInformation();
					}
    				
            		sheetObj.SetWaitImageVisible(0);
            		ComOpenWait(true);                				
                    var sXml=sheetObj.GetSaveData("ESM_BKG_0077GS.do", params);
                    if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){
                    	var message=ComResultMessage(sXml);
            			if(message != null){
            				var rmsg=message.split("<||>");
            				if(rmsg[2] != undefined && rmsg[2].length > 0) {
            					ComShowMessage(rmsg[2]);
            				}
            			}
            			ComOpenWait(false);
						break;
                    }
                    
    				if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
    					if(ComShowCodeConfirm("BKG00312",ComGetEtcData(sXml, "first_vvd"))){
    						ComSetObjValue(formObj.close_bkg_flag, "Y");
    						ComSetObjValue(formObj.mail_open_flag, "Y");
            				doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
    					} else {
    						ComSetObjValue(formObj.close_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
    						ComOpenWait(false);
    						break;
    					}    
    				}else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
    					if(ComShowCodeConfirm("BKG02069")){
    						ComSetObjValue(formObj.cbf_bkg_flag, "Y");
    						ComSetObjValue(formObj.mail_open_flag, "Y");
            				doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
    					} else {
    						ComSetObjValue(formObj.cbf_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
    						ComOpenWait(false);
    						break;
    					} 
    				}else if(ComGetEtcData(sXml, "IsPctlNoPop") == "YC"){
    					gXml = sXml;
    					sheetObjects[2].LoadSearchData(sXml );
		    			
    				}else{
    					gXml = sXml;
    					
//                        console.log("gXml", gXml);
//                        console.log("TRANS_RESULT_KEY", ComGetEtcData(sXml, "TRANS_RESULT_KEY"));
                        
    					if(sheetObj != sheetObjects[0]){
    						sheetObj.LoadSearchData(sXml, {Sync:1});
    					}	    				
	    				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	    					if(formObj.mnl_flg_chk.checked){
	    						formObj.save_fin_flg.value = "Y";
	    						setManualBookingStatusColor("Off","All");
	    					}else{
	    						var newBookingNum=ComGetEtcData(sXml,"new_booking_num");
		    					var newBookingArr=newBookingNum.split("||");
		    					for(var i=0 ; i < newBookingArr.length ; i++){
		    						if(i%3 == 0){
		    							addRow=sheetObjects[1].DataInsert(-1);
		    						}
		    						sheetObjects[1].SetCellValue(addRow, "new"+i%3,newBookingArr[i]);
	                                sheetObjects[1].SetCellFontUnderline(addRow, "new"+i%3,1);
	                                /* Wait 처리 */
	                                if(formObj.bkg_wt_chk_flg.value == 'Y'){
	                                	sheetObj.GetSaveData("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+newBookingArr[i] + "&bkg_wt_chk_flg=Y");
	                                }
		    					}  
	    					} 	
	    					ComSetObjValue(formObj.close_bkg_flag, "N");
	    					ComSetObjValue(formObj.cbf_bkg_flag, "N");
    						ComSetObjValue(formObj.mail_open_flag, "N");
	    				}
	    				
	    				
    				}
           		}
           		ComOpenWait(false);
                break;
 			case SEARCH01:      //Retrive
   				formObj.f_cmd.value=SEARCH01;
   				var params=FormQueryString(formObj);	
				params = params + "&" + createManualBookingCopyInformation();
                var sXml=sheetObjects[3].GetSearchData("ESM_BKG_0077GS.do", params);
		    	setManualBookingStatus(sXml);
                break;
        }
    }
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	var formObj = document.form;
    	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
    		var cbo1 = sheetObj.GetCellValue(i,"pol_clpt_ind_seq_list");
    		var cbo2 = sheetObj.GetCellValue(i,"pod_clpt_ind_seq_list");
    		
			sheetObj.CellComboItem(i,"pol_clpt_ind_seq", {ComboText:cbo1, ComboCode:cbo1} );
			sheetObj.CellComboItem(i,"pod_clpt_ind_seq", {ComboText:cbo2, ComboCode:cbo2} );
		}	
 		setVslPrePostCd();
 		defaultBackColor(formObj);
		ComSetFocus(formObj.copy_cnt);
    }
    
    function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	var sXml = gXml;
    	var formObj = document.form;
		// Call ESD_PRD_018 screen
		var url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B"
		url=url + "&por="   +	ComGetEtcData(sXml, "por");
		url=url + "&por_n="   +	ComGetEtcData(sXml, "por_n");
		url=url + "&pol="   + ComGetEtcData(sXml, "pol");
		url=url + "&pol_n=" + ComGetEtcData(sXml, "pol_n");
		url=url + "&pod="   + ComGetEtcData(sXml, "pod");
		url=url + "&pod_n=" + ComGetEtcData(sXml, "pod_n");
		url=url + "&del="   + ComGetEtcData(sXml, "del");
		url=url + "&del_n=" + ComGetEtcData(sXml, "del_n");
	    for(i=1 ; i <= sheetObjects[0].LastRow(); i++){
	        url=url + "&pol" + i + "="   + sheetObjects[0].GetCellValue(i, "pol_cd");
	        url=url + "&pol" + i + "_n=" + sheetObjects[0].GetCellValue(i, "pol_cd") + sheetObjects[0].GetCellValue(i, "pol_yd_cd");
	        url=url + "&pol" + i + "_c=" + sheetObjects[0].GetCellValue(i, "pol_clpt_ind_seq");
	        url=url + "&pod" + i + "="   + sheetObjects[0].GetCellValue(i, "pod_cd");
	        url=url + "&pod" + i + "_n=" + sheetObjects[0].GetCellValue(i, "pod_cd") + sheetObjects[0].GetCellValue(i, "pod_yd_cd");
	        url=url + "&pol" + i + "_c=" + sheetObjects[0].GetCellValue(i, "pod_clpt_ind_seq");
	        url=url + "&vvd" + i + "="   + sheetObjects[0].GetCellValue(i, "bkg_vvd_cd");
	        if(sheetObjects[0].GetCellValue(i, "vsl_pre_pst_cd") == "T"){
				url=url + "&t_vvd=" + ComGetEtcData(sXml, "t_vvd");    							
			}
		}
		url=url + "&rcv_t=" + ComGetEtcData(sXml, "rcv_t");
		url=url + "&del_t=" + ComGetEtcData(sXml, "del_t");
		url=url + "&shpr="  + ComGetEtcData(sXml, "shpr");
		url=url + "&cngn="  + ComGetEtcData(sXml, "cngn");
		url=url + "&com="     + ComGetEtcData(sXml, "com");
		url=url + "&rep_com=" + ComGetEtcData(sXml, "rep_com");
		url=url + "&wgt="     + ComGetEtcData(sXml, "wgt");
		url=url + "&wgt_un="  + ComGetEtcData(sXml, "wgt_un");
		url=url + "&bkg_ofc=" + ComGetEtcData(sXml, "bkg_ofc");
		url=url + "&org_sal_ofc=" + ComGetEtcData(sXml, "org_sal_ofc"); 
		url=url + "&m_pu=" + ComGetEtcData(sXml, "m_pu");
		url=url + "&f_rt=" + ComGetEtcData(sXml, "f_rt");
		url=url + "&sc="  + ComGetObjValue(formObj.sc_no);
		url=url + "&rfa=" + ComGetObjValue(formObj.rfa_no);
		url=url + "&cgo_tp=" + ComGetEtcData(sXml, "cgo_tp");
		if(formObj.dcgo_flg == "Y"){
			url=url + "&dg_f=Y";
		} else {
			url=url + "&dg_f=N";    						
		}
		if(formObj.rc_flg == "Y"){
			url=url + "&rf_f=Y";
		} else {
			url=url + "&rf_f=N";    						
		}
		if(formObj.awk_cgo_flg == "Y"){
			url=url + "&ak_f=Y";
		} else {
			url=url + "&ak_f=N";    						
		}
		if(formObj.bb_cgo_flg == "Y"){
			url=url + "&bb_f=Y";
		} else {
			url=url + "&bb_f=N";    						
		}
		url=url + "&rd_f=" + ComGetEtcData(sXml, "rd_f");
		if(formObj.hngr_flg == "Y"){
			url=url + "&hg_f=Y";
		} else {
			url=url + "&hg_f=N";    						
		}
		url=url + "&soc_f=" + ComGetEtcData(sXml, "soc_f");       					
		if(formObj.hot_de_flg == "Y"){
			url=url + "&pm_f=Y";
		} else {
			url=url + "&pm_f=N";    						
		}
	    for(i=1 ; i <= sheetObjects[2].LastRow() ; i++){
	        url=url + "&c_tpsz="+sheetObjects[2].GetCellValue(i, "c_tpsz");
	        url=url + "&c_qty="+sheetObjects[2].GetCellValue(i, "c_qty");
		}		    			
	    ComOpenPopup(url, 1024, 780, 'callBackEsdPrd018_save',"1,0,1,1,1", false); 
	    //ComOpenWindowCenter(url+"&func=callBackEsdPrd018_save", "PopupEsdPrd0080", 1024, 730, false);  
    }

     /**
      * handling process for input validation
      * @param sheetObj sheet Object
      * @param formObj  form Object
      * @param sAction 
      */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSAVE:   
				// message in case of check Reefer
				if(ComGetObjValue(formObj.rc_flg) == "Y"){
					ComShowCodeMessage("BKG00326");
				}
				// error message in case of invalid Number Of Copy
				if(BkgParseInt(ComGetObjValue(formObj.copy_cnt)) < 1 || BkgParseInt(ComGetObjValue(formObj.copy_cnt)) > 30){
					ComShowCodeMessage("BKG00327");
					return false;
				}
				if(formObj.mnl_flg_chk.checked){
					doActionIBSheet(sheetObjects[3],formObj,SEARCH01);
					if(!manualBookingStatusValidation()){
						setManualBookingStatusColor("On","All");
						sendManualBookingStatusMessage("All");
						return false;
					}
					if(!setManualBookingStatusCheck()){
						return false;
					}
					setManualBookingStatusColor("Off","All");
	    		}
				//error message in case of invalid VVD
				var isVvdModify=false;
                for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++){
                    if(ComChkLen(sheetObjects[0].GetCellValue(i, "bkg_vvd_cd"), 9) != "2"
                        && sheetObjects[0].GetCellValue(i, "vsl_pre_pst_cd") == "T"){
						ComShowCodeMessage("BKG00007");
						return false;
					}
                    if(!isVvdModify && sheetObjects[0].GetCellValue(i, "bkg_vvd_cd") != sheetObjects[0].CellSearchValue(i, "bkg_vvd_cd")){
						isVvdModify=true;
					}
                    if(sheetObjects[0].GetCellValue(i, "vsl_pre_pst_cd") == "T"){
                        ComSetObjValue(formObj.bkg_trunk_vvd, sheetObjects[0].GetCellValue(i, "bkg_vvd_cd"));
					}
				}
				return true;
				break;    
        }
    }   
	/**
     * obj deactivate when mouse out
     */
    function bkg0077_blur() {
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=ComGetEvent("maxlength");
    	var srcValue=ComGetEvent("value");
    	// check TrunkVvd
	 	if(srcName == "rfa_no"){
			if(srcValue == "DUM"){
				ComSetObjValue(formObj.rfa_no,"DUM0000001");
			}else{
				if(srcValue.length>=10){
	    			if(srcValue != ComGetObjValue(formObj.rfa_no_old)){
	        			// call validateRfaAvailable()
	        			formObj.f_cmd.value=SEARCHLIST12;
                        var sValue=ComSearchEtcData(sheetObjects[2], "ESM_BKG_0000GS.do", "rfa_no="+ srcValue + "&" + FormQueryString(formObj), "rfa_available");
	    				changeObjectColor(sValue, "N", "rfa_no", "red", "input1");
	    			}   		
				}
			}
			if(ComGetObjValue(formObj.rfa_no) != ComGetObjValue(formObj.rfa_no_old)) clearContractParty();
			ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));   
    	}else if(srcName == "sc_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.sc_no,"DUM000001");
    		}else{
    			if(srcValue.length>=8){
        			if(srcValue != ComGetObjValue(formObj.sc_no_old)){
            			// call validateScAvailable()
            			formObj.f_cmd.value=SEARCHLIST13;
             			var sValue=ComSearchEtcData(sheetObjects[2], "ESM_BKG_0000GS.do", "sc_no="+srcValue + "&" + FormQueryString(formObj), "sc_available");
        				changeObjectColor(sValue, "N", "sc_no", "red", "input");
        			}   		
    			}
    		}
    		if(ComGetObjValue(formObj.sc_no) != ComGetObjValue(formObj.sc_no_old)) clearContractParty();
    		ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));    
    	}else if(srcName == "taa_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.taa_no,"DUM0000001");
    		}else{
    			if(srcValue.length>=10){
        			if(srcValue != ComGetObjValue(formObj.taa_no_old)){
            			// call validateScAvailable()
         			    formObj.f_cmd.value=SEARCH06;
          			    var sValue=ComSearchEtcData(sheetObjects[2], "ESM_BKG_0000GS.do", "taa_no="+srcValue + "&" + FormQueryString(formObj), "taa_available");
        				changeObjectColor(sValue, "N", "taa_no", "red", "input");
        			}   		
    			}
    		}
    		if(ComGetObjValue(formObj.taa_no) != ComGetObjValue(formObj.taa_no_old)) clearContractParty();
    		ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));    
    	}else if(srcName == "copy_cnt"){
    		
    		
    		// error message in case of invalid Number Of Copy
			if(BkgParseInt(ComGetObjValue(formObj.copy_cnt)) > 30){
				ComShowCodeMessage("BKG00327");
				formObj.copy_cnt.value ="";
			}	
    		if(formObj.mnl_flg_chk.checked){
    			if(oldCopycnt == ""){
    				
    			} else if(oldCopycnt != parseInt(formObj.copy_cnt.value,10)){
    				manualBookingCopySheetSet();
    			}    			
    		}
    		oldCopycnt = parseInt(formObj.copy_cnt.value,10);
    	}
    }
    
    /**
     * obj deactivate when click
     */
    function bkg0077_click() {
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	var srcValue=ComGetEvent("value");
    	
	 	if(srcName == "mnl_flg_chk"){
	 		if(formObj.mnl_flg_chk.checked){
	 			manualBookingCopyOn(true);
	 			manualBookingCopySheetSet();
	 		}else{
	 			manualBookingCopyOn(false);
	 		}	 		
	 	}
    }
    
	/**
	 * Sheet1 change event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
 	function sheet1_OnChange(sheetObj, Row, Col){
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		
		if(colName == "pol_cd" || colName == "pod_cd" || colName == "bkg_vvd_cd"){
            if(	sheetObj.GetCellValue(Row, "pol_cd").length > 0 &&
                sheetObj.GetCellValue(Row, "pod_cd").length > 0 &&
                sheetObj.GetCellValue(Row, "bkg_vvd_cd").length > 0){
	 			searchLaneEtaEtd(sheetObj, formObj, Row);
	 		}
            if(	sheetObj.GetCellValue(Row, "pol_cd").length < 1 ||
                sheetObj.GetCellValue(Row, "pod_cd").length< 1 ||
                sheetObj.GetCellValue(Row, "bkg_vvd_cd").length < 1){
	 			sheetObj.SetCellValue(Row, "slan_cd","");
	 			sheetObj.SetCellValue(Row, "etd_day","");
	 			sheetObj.SetCellValue(Row, "etd_time","");
	 			sheetObj.SetCellValue(Row, "eta_day","");
	 			sheetObj.SetCellValue(Row, "eta_time","");
	 		}
		}
		if(colName == "bkg_vvd_cd"){
    		changeObjectColor("Y", "Y", "btn_Copy", "red");			
    		ComSetObjValue(formObj.vvd_modify_flg, "Y");
		}
	}
    
    /**
     * call VVD Popup
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnPopupClick( sheetObj, Row, Col ){
		comBkgCallPop0019("callBack0019",
        sheetObj.GetCellValue(Row, "bkg_vvd_cd"),
        sheetObj.GetCellValue(Row, "pol_cd").substring(0, 5),
        sheetObj.GetCellValue(Row, "pod_cd").substring(0, 5), false);
	}
	
	/**
	 * Shee21 double click event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet2_OnDblClick(sheetObj, Row,Col){
        if(sheetObj.GetCellValue(Row,Col) != ""){
            ComBkgCall0079(sheetObj.GetCellValue(Row,Col));
		}
	}
	
	/**
	 * Sheet4change event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet4_OnChange(sheetObj, Row,Col){
        if(sheetObjects[4].GetCellValue(Row,Col) != ""){
        	setManualBookingStatusColor("Off","Target",Row,Col);
        	sheetObjects[4].SetCellValue(Row,Col,"");
		}
	} 
	
	/**
	 * Sheet4 double click event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet4_OnDblClick(sheetObj, Row,Col){
		var formObj = document.form;
        if(sheetObj.GetCellValue(Row,Col) != "" && formObj.save_fin_flg.value == "Y" && formObj.mnl_flg_chk.checked){
            ComBkgCall0079(sheetObj.GetCellValue(Row,Col));
		}
	} 
	/**
	 * Sheet1 combo change event handling
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Text
	 * @return
	 */
	function sheet1_OnComboChange(sheetObj, Row, Col, Text) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		if(Text==""){
			return;
		}  	 			
 		if(colName == "pol_clpt_ind_seq"){
 			sheetObj.SetCellValue(Row, "pol_yd_cd","",0);
 		} else if(colName == "pod_clpt_ind_seq"){
 			sheetObj.SetCellValue(Row, "pod_yd_cd","",0);
 		}
 		searchLaneEtaEtd(sheetObj, formObj, Row);
	}
	/**
	 * set default backColor
	 * @param formObj
	 * @return
	 */
    function defaultBackColor(formObj){
    	if(ComGetObjValue(formObj.dcgo_flg) != "Y"){
    		document.getElementById("dcgoFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.dcgo_flg, false);
    	}
    	if(ComGetObjValue(formObj.stowage_flg) != "Y"){
    		document.getElementById("stowageFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.stowage_flg, false);
    	}    	
    	if(ComGetObjValue(formObj.hot_de_flg) != "Y"){
    		document.getElementById("hotDeFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.hot_de_flg, false);
    	}    
    	if(ComGetObjValue(formObj.rc_flg) != "Y"){
    		document.getElementById("rcFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.rc_flg, false);
    	}    
    	if(ComGetObjValue(formObj.hngr_flg) != "Y"){
    		document.getElementById("hngrFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.hngr_flg, false);
    	}   
    	if(ComGetObjValue(formObj.spcl_hide_flg) != "Y"){
    		document.getElementById("spclHideFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.spcl_hide_flg, false);
    	}    
    	if(ComGetObjValue(formObj.awk_cgo_flg) != "Y"){
    		document.getElementById("awkCgoFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.awk_cgo_flg, false);
    	}   
    	if(ComGetObjValue(formObj.stop_off_flg) != "Y"){
    		document.getElementById("stopOffFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.stop_off_flg, false);
    	}    
    	if(ComGetObjValue(formObj.fd_grd_flg) != "Y"){
    		document.getElementById("fdGrdFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.fd_grd_flg, false);
    	}       	
    	if(ComGetObjValue(formObj.bb_cgo_flg) != "Y"){
    		document.getElementById("bbCgoFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.bb_cgo_flg, false);
    	}   
    	if(ComGetObjValue(formObj.bulk_rail_flg) != "Y"){
    		document.getElementById("bulkRailFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.bulk_rail_flg, false);
    	}    
    	if(ComGetObjValue(formObj.prct_flg) != "Y"){
    		document.getElementById("prctFlg").style.backgroundColor="#DCDCDC";
    		BkgEnableObject(formObj.prct_flg, false);
    	}       	    	
    }
	/**
	 * POD/POL/VVD in case of editing
	 * @param sheetObj
	 * @param formObj
	 * @param Row
	 * @return
	 */
	function searchLaneEtaEtd(sheetObj, formObj, Row){
        if(	sheetObj.GetCellValue(Row, "pol_cd").length > 0 &&
            sheetObj.GetCellValue(Row, "pod_cd").length > 0 &&
            sheetObj.GetCellValue(Row, "bkg_vvd_cd").length > 0){
	   		formObj.f_cmd.value=SEARCH01;
	   		var params="f_cmd=" + formObj.f_cmd.value;
       		params=params + "&edit_row=" + Row + "&" + sheetObj.GetSaveString(true);
 	   		var sXml=sheetObj.GetSearchData("ESM_BKG_0092GS.do", params);
	   		if(ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq_list"))||ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq_list"))){
		   		sheetObj.SetCellValue(Row, "eta_day","",0);
		   		sheetObj.SetCellValue(Row, "eta_time","",0);
		   		sheetObj.SetCellValue(Row, "etd_day","",0);
		   		sheetObj.SetCellValue(Row, "etd_time","",0);
		   		sheetObj.SetCellValue(Row, "eta","",0);
		   		sheetObj.SetCellValue(Row, "etd","",0);
	   		} else {
	   		    var cbo1 = ComGetEtcData(sXml,"pol_clpt_ind_seq_list");
	   		    var cbo2 = ComGetEtcData(sXml,"pod_clpt_ind_seq_list");
		   		ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
		   		// set result
		   		sheetObj.SetCellValue(Row, "eta_day",ComGetEtcData(sXml,"eta_day"),0);
		   		sheetObj.SetCellValue(Row, "eta_time",ComGetEtcData(sXml,"eta_time"),0);
		   		sheetObj.SetCellValue(Row, "etd_day",ComGetEtcData(sXml,"etd_day"),0);
		   		sheetObj.SetCellValue(Row, "etd_time",ComGetEtcData(sXml,"etd_time"),0);
		   		sheetObj.SetCellValue(Row, "eta",ComGetEtcData(sXml,"eta"),0);
		   		sheetObj.SetCellValue(Row, "etd",ComGetEtcData(sXml,"etd"),0);
		   		sheetObj.SetCellValue(Row, "slan_cd",ComGetEtcData(sXml,"slan_cd"),0);
		   		sheetObj.SetCellValue(Row, "pol_yd_cd",ComGetEtcData(sXml,"pol_yd_cd"),0);
		   		sheetObj.SetCellValue(Row, "pod_yd_cd",ComGetEtcData(sXml,"pod_yd_cd"),0);
				sheetObj.CellComboItem(Row,"pol_clpt_ind_seq", {ComboText:cbo1, ComboCode:cbo1} );
				sheetObj.CellComboItem(Row,"pod_clpt_ind_seq", {ComboText:cbo2, ComboCode:cbo2} );
				sheetObj.SetCellValue(Row, "pol_clpt_ind_seq",ComGetEtcData(sXml,"pol_clpt_ind_seq"),0);
				sheetObj.SetCellValue(Row, "pod_clpt_ind_seq",ComGetEtcData(sXml,"pod_clpt_ind_seq"),0);
		   		setVslPrePostCd();
	   		}
		}	 			
	}    
	/**
	 * set VSL previous post code
	 */
   	function setVslPrePostCd(){
   		var formObj=document.form;
		var sheetObj=sheetObjects[0];
        var rowCnt=sheetObj.LastRow()+1;
		var maxRow=0;
		if(rowCnt > 1){
            var iSeq = parseInt(ComGetObjValue(formObj.trunkSeq));
    		sheetObj.SetCellValue(ComGetObjValue(formObj.trunkSeq), "vsl_pre_pst_cd","T",0);
     		for ( j=1 ; j <= sheetObj.LastRow() ; j++ ){
    			if(j < iSeq){
      				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","S",0);
    			} else if(j > iSeq){
      				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","U",0);
    			}
    		}
			setPrePstSeq(sheetObj);
		}
	}
	/**
	 * sort Seq
	 * @param sheetObj
	 * @return
	 */
	function setPrePstSeq(sheetObj){
       // setting Seq
       var isPre=true;
       var prePostIdx=1;
       for ( j=1 ; j <= sheetObj.LastRow() ; j++ ){
            if(sheetObj.GetCellValue(j, "vsl_pre_pst_cd") != "T"){
      			if(isPre){
      				sheetObj.SetCellValue(j, "seq","Pre" + prePostIdx,0);
      				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","S",0);
      				sheetObj.SetCellValue(j, "vsl_seq",prePostIdx,0);
      				prePostIdx++;
      			}else{
      				sheetObj.SetCellValue(j, "seq","Post" + prePostIdx,0);
      				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","U",0);
      				sheetObj.SetCellValue(j, "vsl_seq",prePostIdx,0);
      				prePostIdx++;	        				 
      			}
      		}else{
      			sheetObj.SetCellValue(j, "seq","Trunk",0);
      			sheetObj.SetCellValue(j, "vsl_seq","0",0);
      			isPre=false;
      			prePostIdx=1;
      		}
	 	}	   		
	}
	/**
	 * call back function after VVD Popup
	 * @param arrVal
	 * @return
	 */
	function callBack0019(arrVal){
		if(arrVal != null){			
		    var iRow = sheetObjects[0].GetSelectRow();
			sheetObjects[0].SetCellValue( parseInt(iRow,10), "pol_cd",arrVal[0][4]);
			sheetObjects[0].SetCellValue( parseInt(iRow,10), "pod_cd",arrVal[0][12]);
			sheetObjects[0].SetCellValue( parseInt(iRow,10), "bkg_vvd_cd",arrVal[0][3]);
		}		
		searchLaneEtaEtd(sheetObjects[0], document.form, iRow);
	}  
    /**
     * call back function after ending RFA retrieve
     * @param arrVal
     * @return
     */
	function callBack0654(arrVal){
		if(arrVal != null){
			var formObj=document.form;			
			ComSetObjValue(formObj.rfa_no, arrVal[0][5]);
			if(arrVal[0][1] == "S" || arrVal[0][1] == "P" ){
  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
  			}else{
  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, '');
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, '');
  			}
		}
	}        
   /**
    * call back function after ending S/C retrieve
    * @param arrVal
    * @return
    */
	function callBack0655(arrVal){
		if(arrVal != null){
			var formObj=document.form;			
			ComSetObjValue(formObj.sc_no, arrVal[0][5]);
			if(arrVal[0][1] == "S" || arrVal[0][1] == "P" ){
  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
  			}else{
  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, '');
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, '');
  			}
		}
	}       
    /**
     * call back function after ending TAA retrieve
     * @param arrVal
     * @return
     */    
	function callBack1062(arrVal){
	  	var formObj=document.form;   
	  	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.taa_no,     arrVal[0][5]);
	  			if(arrVal[0][1] == "S" || arrVal[0][1] == "P" ){
	  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
	  			}else{
	  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, '');
		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, '');
	  			}
	  			changeObjectColor("Y", "N", "taa_no", "red", "input");
	  		}
	  	}
	}            
	/**
	 * call back function after ending ESD_PRD_018 call
	 * @param pctlNo
	 * @return
	 */
	function callBackEsdPrd018_save(pctlNo){
		var formObj = document.form;
		ComSetObjValue(formObj.pctl_no,pctlNo);
		
		if(ComIsNull(formObj.pctl_no.value)){
			ComShowCodeMessage("BKG00309");	
		} else {
			doActionIBSheet(sheetObjects[2], formObj, IBSAVE);
		}  
	}
	
	/**
	 * Draw sheet Based on number of copy
	 */
	function manualBookingCopySheetSet(){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value);
		var rowCnt = parseInt(cpnCnt/3, 10);
		var rowCntAdditional = parseInt((cpnCnt%3), 10);
		var lastRow = sheetObjects[3].LastRow();

		if(cpnCnt + rowCntAdditional>0){
			if(lastRow > 0){
				for(i = 1; i < lastRow+1 ; i++){
					sheetObjects[3].RowDelete(1,0);
					sheetObjects[4].RowDelete(1,0);
				}	
			}
			if(rowCnt > 0){
				for(i =0; i<rowCnt; i++){
					sheetObjects[3].DataInsert(-1);
					sheetObjects[4].DataInsert(-1);
				}	
			}
			if(rowCntAdditional > 0){
				sheetObjects[3].DataInsert(-1);
				sheetObjects[4].DataInsert(-1);
				if(rowCntAdditional < 3){
					if(rowCntAdditional == 2){
						sheetObjects[3].SetCellEditable(sheetObjects[3].LastRow(),2,0);
						sheetObjects[4].SetCellEditable(sheetObjects[3].LastRow(),2,0);
					}else{
						sheetObjects[3].SetCellEditable(sheetObjects[3].LastRow(),2,0);
						sheetObjects[3].SetCellEditable(sheetObjects[3].LastRow(),1,0);
						sheetObjects[4].SetCellEditable(sheetObjects[3].LastRow(),2,0);
						sheetObjects[4].SetCellEditable(sheetObjects[3].LastRow(),1,0);
					}
				}
			}
		}
	}
	
	/**
	 * Control sheet visibility
	 * @param boolean swch
	 * @return 
	 */
	function manualBookingCopyOn(swch){
		var formObj = document.form;
		var lastRow = sheetObjects[3].LastRow();
		var lasrRowNoneManual = sheetObjects[1].LastRow();
		
		
		if(swch){
			formObj.mnl_flg.value = "Y";
			ComSetDisplay("mnl_bkg_sheet",true);
			ComSetDisplay("new_bkg_sheet",false);
		}else{
			oldCopycnt = "";
			formObj.mnl_flg.value = "N";
			ComSetDisplay("mnl_bkg_sheet",false);
			ComSetDisplay("new_bkg_sheet",true);
		}
		if(formObj.save_fin_flg.value == "N"){
			if(lastRow > 0){
				for(k = 1; k < lastRow+1 ; k++){
					sheetObjects[3].RowDelete(1,0);
					sheetObjects[4].RowDelete(1,0);
				}	
			}
		}
		sheetObjects[1].RemoveAll();
		formObj.save_fin_flg.value = "N";
	}
	
	/**
	 * gather manual booking number
	 */	
	function createManualBookingCopyInformation(){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		var rowCnt = sheetObjects[3].LastRow();
		var mnlBkgNoParams = "";
		var lastColCnt = parseInt((cpnCnt%3), 10);
		var colCnt = 3;
		
		for(i =1; i< rowCnt+1; i++){
			if(rowCnt == 1){
				colCnt = cpnCnt;
			}else if(i == rowCnt && rowCnt != 1){
				colCnt = lastColCnt==0?3:lastColCnt;
			}else {
				colCnt = 3;
			}
			for(j=0; j<colCnt; j++){
				if(sheetObjects[3].GetCellValue(i,j)!= ""){
					mnlBkgNoParams = mnlBkgNoParams +"sheet4_ibflag=&"+"&sheet4_mnl_bkg_no="+ sheetObjects[3].GetCellValue(i,j)+"&";
				}
			}
		}
		mnlBkgNoParams = mnlBkgNoParams.substring(0,mnlBkgNoParams.length-1);
		return mnlBkgNoParams;
	}
	
	/**
	 * input manual booking status for validation
	 * @param sXml
	 * @return
	 */	
	function setManualBookingStatus(sXml){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
			var manualBookingStatus = ComGetEtcData(sXml,"MnlBkgSts");
			var manualBookingStatusArr =manualBookingStatus.split("|");
			var rowCnt = sheetObjects[3].LastRow();
			var lastColCnt = parseInt((cpnCnt%3), 10);
			var colCnt = 3;
			var k =0;
			
			for(i = 1; i< rowCnt+1; i++){
				if(rowCnt == 1){
					colCnt = cpnCnt;
				}else if(i == rowCnt && rowCnt != 1){
					colCnt = lastColCnt==0?3:lastColCnt;
				}else {
					colCnt = 3;
				}
				for(j=0; j<colCnt; j++){
					sheetObjects[4].SetCellValue(i,j, manualBookingStatusArr[k]);
					k = k+1;
				}
			}
		}
	}
	
	/**
	 * Validate manual booking number Status input result
	 * @param 
	 * @return boolean
	 */	
	function setManualBookingStatusCheck(){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		var rowCnt = sheetObjects[3].LastRow();
		var lastColCnt = parseInt((cpnCnt%3), 10);
		var colCnt = 3;
		var k = 0;
		for(i = 1; i< rowCnt+1; i++){
			if(rowCnt == 1){
				colCnt = cpnCnt;
			}else if(i == rowCnt && rowCnt != 1){
				colCnt = lastColCnt==0?3:lastColCnt;
			}else {
				colCnt = 3;
			}
			for(j=0; j<colCnt; j++){
				if(sheetObjects[4].GetCellValue(i,j) == ""){
					k = k+1;
				}
			}
		}
		if(k > 0){
			return false
		}
		return true
	}
	
	/**
	 * Validate manual booking number
	 * @param 
	 * @return boolean
	 */	
	function manualBookingStatusValidation(){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		var rowCnt = sheetObjects[3].LastRow();
		var inpTltCnt = 0;
		var lastColCnt = parseInt((cpnCnt%3), 10);
		var colCnt = 3;
		var mnlDenyCnt = 0;
		
		mnl_allow_flg = "N";
		//Count number of input data
		for(i =1; i< rowCnt+1; i++){
			//Setting colomn count for each row
			if(rowCnt == 1){
				colCnt = cpnCnt;
			}else if(i == rowCnt && rowCnt != 1){
				colCnt = lastColCnt==0?3:lastColCnt;
			}else {
				colCnt = 3;
			}
			//count total number of inputted data
			for(j=0; j<colCnt; j++){
				if(sheetObjects[3].GetCellValue(i,j) != ""){
					inpTltCnt = inpTltCnt+1;
				}
			}
		}
		//Compare number of Ccopy and number of input data
		if(inpTltCnt != cpnCnt){
			ComShowCodeMessage("BKG95001","input manual booking number.","\nNumber of copy : "+ cpnCnt +"\nInputted Booking number : " +inpTltCnt);
			return false;
		}
		//Chaeck Manual Booking status. All status should be "Y" 
		for(i =1; i< rowCnt+1; i++){
			if(rowCnt == 1){
				colCnt = parseInt(formObj.copy_cnt.value,10)
			}else if(i == rowCnt && rowCnt != 1){
				colCnt = lastColCnt==0?3:lastColCnt;
			}else {
				colCnt = 3;
			}
			for(j=0; j<colCnt; j++){
				if(sheetObjects[4].GetCellValue(i,j) != "Y"){
					mnlDenyCnt = mnlDenyCnt+1;
				}
			}
		}
		if(mnlDenyCnt > 0){
			mnlAllowFlg = "N"
		}else {
			mnlAllowFlg = "Y"
		}
		if(mnlAllowFlg == "Y"){
			return true;
		}
		return false;
	}
	
	/**
	 * Chagne cell color based on manual booking status
	 * @param boolen tgt
	 * @return 
	 */	
	function setManualBookingStatusColor(swch,tgt,Row,Col){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		var rowCnt = sheetObjects[3].LastRow();
		var lastColCnt = parseInt((cpnCnt%3), 10);
		var colCnt = 3;
		if(swch == "Off"){
			if(tgt == "All"){
				for(i = 1; i< rowCnt+1; i++){
					if(rowCnt == 1){
						colCnt = cpnCnt;
					}else if(i == rowCnt && rowCnt != 1){
						colCnt = lastColCnt==0?3:lastColCnt;
					}else {
						colCnt = 3;
					}
					for(j=0; j<colCnt; j++){
						sheetObjects[3].SetCellFontColor(i,j,"#000000");
						sheetObjects[3].SetCellFont("FontBold",i,j,i,j,0);
						if(formObj.save_fin_flg.value == "Y"){
							sheetObjects[3].SetCellFontColor(i,j,"#0000FF");
							sheetObjects[3].SetCellFont("FontBold",i,j,i,j,1);
							sheetObjects[3].SetCellFont("FontUnderline",i,j,i,j,1);
							sheetObjects[3].SetCellEditable(i,j,0);
						}
					}
				}
			}else if(tgt == "Target"){
				sheetObjects[3].SetCellFontColor(Row,Col,"#000000");
				sheetObjects[3].SetCellFont("FontBold",Row,Col,Row,Col,0);
			}
		} else if(swch == "On"){
			if(tgt == "All"){
				for(i = 1; i< rowCnt+1; i++){
					if(rowCnt == 1){
						colCnt = cpnCnt;
					}else if(i == rowCnt && rowCnt != 1){
						colCnt = lastColCnt==0?3:lastColCnt;
					}else {
						colCnt = 3;
					}
					for(j=0; j<colCnt; j++){
						if(sheetObjects[4].GetCellValue(i,j) == "X" || sheetObjects[4].GetCellValue(i,j) == "B"){
							sheetObjects[3].SetCellFontColor(i,j,"#FF0000");
							sheetObjects[3].SetCellFont("FontBold",i,j,i,j,1);
						}else if(sheetObjects[4].GetCellValue(i,j) == "M"){
							sheetObjects[3].SetCellFontColor(i,j,"#FF5E00");
							sheetObjects[3].SetCellFont("FontBold",i,j,i,j,1);
						}else if(sheetObjects[4].GetCellValue(i,j) == "O"){
							sheetObjects[3].SetCellFontColor(i,j,"#993800");
							sheetObjects[3].SetCellFont("FontBold",i,j,i,j,1);
						}					
					}
				}
			}else if(tgt == "Target"){
				if(sheetObjects[4].GetCellValue(Row,Col) == "X" || sheetObjects[4].GetCellValue(Row,Col) == "B"){
					sheetObjects[3].SetCellFontColor(i,j,"#FF0000");
					sheetObjects[3].SetCellFont("FontBold",Row,Col,Row,Col,1);
				}else if(sheetObjects[4].GetCellValue(Row,Col) == "M"){
					sheetObjects[3].SetCellFontColor(i,j,"#FF5E00");
					sheetObjects[3].SetCellFont("FontBold",Row,Col,Row,Col,1);
				}else if(sheetObjects[4].GetCellValue(Row,Col) == "O"){
					sheetObjects[3].SetCellFontColor(i,j,"#993800");
					sheetObjects[3].SetCellFont("FontBold",Row,Col,Row,Col,1);
				}	
			}
			
		}

	}
	
	/**
	 * Show alert message for wrong manual booking status
	 * @param boolen tgt
	 * @return 
	 */	
	function sendManualBookingStatusMessage(tgt,Row,Col){
		var formObj = document.form;
		var cpnCnt = parseInt(formObj.copy_cnt.value,10);
		var rowCnt = sheetObjects[3].LastRow();
		var lastColCnt = parseInt((cpnCnt%3), 10);
		var colCnt = 3;

		if(tgt == "All"){
			for(i = 1; i< rowCnt+1; i++){
				if(rowCnt == 1){
					colCnt = cpnCnt;
				}else if(i == rowCnt && rowCnt != 1){
					colCnt = lastColCnt==0?3:lastColCnt;
				}else {
					colCnt = 3;
				}
				for(j=0; j<colCnt; j++){
					if(sheetObjects[4].GetCellValue(i,j) == "X" || sheetObjects[4].GetCellValue(i,j) == "B"){
						ComShowCodeMessage("BKG90771",sheetObjects[3].GetCellValue(i,j),"is used for another booking");
					}else if(sheetObjects[4].GetCellValue(i,j) == "M"){
						ComShowCodeMessage("BKG90771",sheetObjects[3].GetCellValue(i,j),"does not exist");
					}else if(sheetObjects[4].GetCellValue(i,j) == "O"){
						ComShowCodeMessage("BKG90772");
					}
				}
			}
		}else if(tgt == "Target"){
			if(sheetObjects[4].GetCellValue(Row,Col) == "X" || sheetObjects[4].GetCellValue(Row,Col) == "B"){
				ComShowCodeMessage("BKG90771",sheetObjects[3].GetCellValue(Row,Col),"does not exist");
			}else if(sheetObjects[4].GetCellValue(Row,Col) == "M"){
				ComShowCodeMessage("BKG90771",sheetObjects[3].GetCellValue(Row,Col),"is used for another booking");
			}else if(sheetObjects[4].GetCellValue(Row,Col) == "O"){
				ComShowCodeMessage("BKG90772");
			}
		}

	}
	
	function clearContractParty(){
		var formObj=document.form;
		formObj.bkg_ctrl_pty_cust_cnt_cd.value = '';
		formObj.bkg_ctrl_pty_cust_seq.value = '';
		formObj.bkg_ctrl_pty_cust_nm.value = '';
	}
	
