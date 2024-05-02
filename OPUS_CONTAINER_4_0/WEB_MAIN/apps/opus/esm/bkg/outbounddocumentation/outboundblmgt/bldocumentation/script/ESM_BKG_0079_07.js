/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_07.js
*@FileTitle  : C/M by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer Work	*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var decision_flag=-1; //0-NO, 1-Yes, 2-Close
	// Event handler processing by button click event */
	document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets다. *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
            switch(srcName) {
				case "dcgo_flg":
				case "bb_cgo_flg":
				case "awk_cgo_flg":
				case "rc_flg":
				case "rd_cgo_flg":
				case "hngr_flg":
					return false;
				break;
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_t9AllConfirm":
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
				break;
				case "btn_t9AllRelease":
					doActionIBSheet(sheetObject1,formObject,COMMAND02);
				break;
				case "btn_t9Add":
					if(ComIsBtnEnable("btn_t9Add")){
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
				break;
				case "btn_t9Del":
					if(ComIsBtnEnable("btn_t9Del")){
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
				break;
				case "btn_t9CopyMnd":
					if(ComIsBtnEnable("btn_t9CopyMnd")){
						doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					}
				break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					ComBtnDisable('');
				break;
				case "btn_t9Save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;
				case "btn_t9CMCopyCM":
					var selIdx=sheetObject1.GetSelectRow();
					if(selIdx > 0){
						var cntr_no=sheetObject1.GetCellValue(selIdx, "cntr_no");
						var cntr_tpsz_cd=sheetObject1.GetCellValue(selIdx, "cntr_tpsz_cd");
						var url="ESM_BKG_0176.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
//						ComOpenWindow(url, "ESM_BKG_0176", "width=450,height=300", false);
						ComOpenPopup(url,450, 300, "", "1,0", true);
					}else{
						ComShowMessage(ComGetMsg("BKG00188"));
					}
				break;
				case "btn_t9CopyFmCntr":
//					alert("btn_t9CopyFmCntr");
					doActionIBSheet(sheetObject2,formObject,COMMAND05);
				break;
				case "btn_t9CMbyCntr":
					var cntr_no=formObject.cntr_no.value;
					var t_vvd=formObject.t_vvd.value;
//					alert(cntr_no + " " + t_vvd);
					var url="ESM_BKG_0178_POP.do?pgmNo=ESM_BKG_0178&cntr_no="+cntr_no+"&t_vvd="+t_vvd;
					
//					ComOpenWindowCenter(url, "ESM_BKG_0178", 1014, 640, false);
					ComOpenPopup(url,1014, 580, "", "1,0", true);
					
					
				break;
				case "btn_t9NVOHBL":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0366.do?pgmNo=ESM_BKG_0366&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0366", 1014, 640, false);
				break;
				case "btn_t9multishp":
					if(formObject.bkg_no.value == '' ){
						ComShowMessage(ComGetMsg("BKG00463"));
						formObject.bkg_no.focus();
					}else{
						if(formObject.cntr_no.value == '' || sheetObjects[0].RowCount()== 0 || sheetObjects[0].GetSelectRow()< 1){
							ComShowMessage(ComGetMsg("BKG08130"));
						}else{
							var url="ESM_BKG_0391.do?func=callbackMultiShp&bkg_no=" + formObject.bkg_no.value+"&ui_no=ESM_BKG_0079_07";
							ComOpenWindowCenter(url, "ESM_BKG_0391", 1100, 595, true);
						}
					}
				break;
            } // end switch
    	}catch(e) {
    		if( e.name == "TypeError") {
    			return false;
    		}else{
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			//
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].SetWaitImageVisible(0);
		}
		//iframe create 
//    	CofigIframe();
    	//------------------------------------------------>
    	//setInquiryDisableButton event call
   		setInquiryDisableButton();
     	//------------------------------------------------>
        // do initialize
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		initControl();
    }
	function initControl() {
		//add listener
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		//axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		applyShortcut();
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "t9sheet1": // Visible Left : Container List
			    with(sheetObj){
		      var HeadTitle="|C|Container No.|C/M|seal_no|cntr_tpsz_cd|rcv_term_cd|de_term_cd|cntr_vol_qty|adv_shtg_cd|dcgo_flg|bb_cgo_flg|awk_cgo_flg|rc_flg|rd_cgo_flg|hngr_flg|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|A1|A2|A3";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mf_cfm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"adv_shtg_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"rc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"rd_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"hngr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cm_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cm_cntr_wgt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cm_meas_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 }
		            ];
		       
				      InitColumns(cols);
				      SetSheetHeight(315);
//				      updateSheetSize(sheetObj);
				      SetEditable(1);
		            }


				break;
			case "t9sheet2": // Visible Center : Cargo Detail
			    with(sheetObj){
		      var HeadTitle="|Sel.|Seq.|MfSeq.|CntrNo|Package|Package|Package|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|HTS Code|HTS Code|HS Code|HS Code|NCM Code|NCM Code|Manifest File No.|Self|DG|DG|AK|HG";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"PCKPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"MDPop",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"HTCPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"CMDTPop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"NCMPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"self",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"Combo",     Hidden:0, Width:210,  Align:"Left",    ColMerge:0,   SaveName:"dcgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"},
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hngr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  TrueValue:"Y", FalseValue:"N"} 
		             ];
		       
		      InitColumns(cols);
		      
//              SetColProperty("cntr_mf_mk_desc", {AcceptKeys:"N|E|[ ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./<>?\r\n]",  InputCaseSensitive:1} );
//              SetColProperty("cntr_mf_gds_desc", {AcceptKeys:"N|E|[ ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./<>?\r\n]",  InputCaseSensitive:1} );
		      SetSheetHeight(202);
//		      updateSheetSize(sheetObj);
		      SetEditable(1);
		      SetShowButtonImage(2);
		      SetAutoRowHeight(0);
		      }


			break;
			case "t9sheet3":
			    with(sheetObj){

		      var HeadTitle="cntr_no|dcgo_seq|diff_rmk";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ 
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
		             ];
		       
		      InitColumns(cols);
		      sheetObj.SetVisible(false);
		      SetEditable(1);
		      SetAutoRowHeight(0);
		      }


			break;
        }
    }
    
    function updateSheetSize(sheetObj){
    	  var marginDefault = 200;
    	  var winHeight = $(parent.window).height();

    	  if(typeof sheetObj == "undefined") {
    		  var obj0 = $("#" + sheetObjects[0].id).offset();
    		  var obj1 = $("#" + sheetObjects[1].id).offset();
              var marginHeight0 = obj0.top + marginDefault;
              var marginHeight1 = obj1.top + marginDefault;
              var sheetHeight0 = winHeight - marginHeight0;
              var sheetHeight1 = winHeight - marginHeight1;
    	  }
    	  else {
    		  var obj = $("#" + sheetObj.id).offset();
              var marginHeight = obj.top + marginDefault;
    		  var sheetHeight = winHeight - marginHeight;
    	  }

    	
    	  if(typeof sheetObj == "undefined") {
    		  sheetObjects[0].SetSheetHeight(sheetHeight0 > 90?sheetHeight0:90);
    		  sheetObjects[1].SetSheetHeight(sheetHeight1 > 90?sheetHeight1:90);
    	  }    
    	  else {
    		  sheetObj.SetSheetHeight(sheetHeight > 90?sheetHeight:90);
    	  }
    }            
    
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
	//	sheetObj.ShowDebugMsg = 1;
		switch(sAction) {
			case IBSEARCH:      // retrieve
				if(formObj.dirty_flag.value == 'Y'){
					if(confirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObj, formObj, IBSAVE);
						return;
					}
				}
				if(validateForm(sheetObj,formObj,sAction)){
				try {
					ComOpenWait(true); 
					formObj.f_cmd.value=SEARCH;
					//sheetObj.DoSearch("ESM_BKG_0079_07GS.do", FormQueryString(formObj));
					var rXml=sheetObj.GetSearchData("ESM_BKG_0079_07GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
                    var arrXml=rXml.split("|$$|");
//                    alert("xml count : " + arrXml.length);
					if(arrXml.length==3){
						var cmCntrXml=arrXml[0];
						var cmDtlXml=arrXml[1];
						var cdgCgoXml=arrXml[2];
						
						// DG CGO Info
						sheetObjects[2].LoadSearchData(cdgCgoXml,{Sync:1} );
//						if(sheetObjects[2].GetTotalRows()> 0){
//							var arrData=ComBkgXml2ComboString(cdgCgoXml, "dcgo_seq", "diff_rmk");
//						     arrData[1]=" \t |"+ arrData[1];
//						     arrData[0]=" |"+ arrData[0];
//						     sheetObjects[1].SetColProperty("dcgo_seq", {ComboText:arrData[1], ComboCode:arrData[0]} );
//						 }
						// CM Booking Info
						ComEtcDataXmlToForm(cmCntrXml, formObj);
						
						
						// btn_t6gridmultishp button color setting
						if(ComGetObjValue(formObj.mlt_shp_flg) == "Y"){
						    ComGetObject("btn_t9multishp").style.setProperty("background-color", "#dceeff", "important");
						    ComGetObject("btn_t9multishp").style.setProperty("color", "blue", "important");
						}else{
						    ComGetObject("btn_t9multishp").style.setProperty("background-color", "", "important");
						    ComGetObject("btn_t9multishp").style.setProperty("color", "", "important");
						}

//						alert(cmCntrXml);
						// CM Container Info
						sheetObjects[0].LoadSearchData(cmCntrXml,{Sync:1} );
						// CM Cntr MF Info
						sheetObjects[1].LoadSearchData(cmDtlXml,{Sync:1} );
						// Show & Hide
						if(sheetObjects[0].GetTotalRows()> 0){
							sheetObjects[0].SelectCell(1, "cntr_no", false);
							setCMInfo(1);
						}
						if(formObj.bdr_flg.value == 'Y'){
							document.getElementById("bkg_no").className="input1";
						}else{
							document.getElementById("bkg_no").className="input";
						}
						// Confrim Release status
						var cfmFlg=ComFindText(sheetObjects[0], "mf_cfm_flg", 0);
						if(cfmFlg.length == 0){
							formObj.bkg_cfm_flg.value="CMCFM";
							//formObj.mf_cfm_flg.value = 'Y';
						}else{
							formObj.bkg_cfm_flg.value="CMRLSE";
							//formObj.mf_cfm_flg.value = 'N';
						}
						formObj.dirty_flag.value='N';
						// ca controll
						//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
						if(parent.t9frame != undefined && typeof(parent.t9frame) == "object") {
							parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value); 
						}
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}

						//set total qty of CNTR information
						var cntr_ttl_pack_qty=ComColumnSum(sheetObjects[0], "pck_qty", false);
						var cntr_ttl_wgt_qty=ComColumnSum(sheetObjects[0], "cntr_wgt", false);
						var cntr_ttl_meas_qty=ComColumnSum(sheetObjects[0], "meas_qty", false);
						// Decimal rounding
						cntr_ttl_wgt_qty = Math.round(cntr_ttl_wgt_qty * 1000) / 1000;
						cntr_ttl_meas_qty = Math.round(cntr_ttl_meas_qty * 1000) / 1000;
										
						formObj.cntr_ttl_pack_qty.value = cntr_ttl_pack_qty;
						formObj.cntr_ttl_wgt_qty.value = cntr_ttl_wgt_qty;
						formObj.cntr_ttl_meas_qty.value = cntr_ttl_meas_qty;
					}else{
						//alert("SEARCH xml : " + arrXml.length);
						return;
					}
				}finally{
					ComOpenWait(false);
				}
				}
			break;
			case IBSAVE:        //save
				if(document.form.isInquiry.value == "Y") return;
				document.form.cntr_update_flg.value="";
				if(validateForm(sheetObj,formObj,sAction)){		
					
					var bkg_pck_qty=ComTrimAll(formObj.bkg_pck_qty.value, ",");
					var bkg_pck_unit=formObj.bkg_pck_unit.value;
					var bkg_wgt_qty=ComTrimAll(formObj.bkg_wgt_qty.value, ",");
					var bkg_wgt_unit=formObj.bkg_wgt_unit.value;
					var bkg_meas_qty=ComTrimAll(formObj.bkg_meas_qty.value, ",");
					var bkg_meas_unit=formObj.bkg_meas_unit.value;
					var cm_pck_qty=ComColumnSum(sheetObj, "pck_qty");//sheetObj.ComputeSum("|4|");
					var cm_pck_unit=bkg_pck_unit;
					var cm_wgt_qty=ComColumnSum(sheetObj, "cntr_mf_wgt");//sheetObj.ComputeSum("|7|");
					var cm_wgt_unit=bkg_wgt_unit;
					var cm_meas_qty=ComColumnSum(sheetObj, "meas_qty");//sheetObj.ComputeSum("|9|");
					var cm_meas_unit=bkg_meas_unit;
					var cntr_ttl_pack_qty=ComTrimAll(formObj.cntr_ttl_pack_qty.value, ",");
					var cntr_ttl_wgt_qty=ComTrimAll(formObj.cntr_ttl_wgt_qty.value, ",");
					var cntr_ttl_meas_qty=ComTrimAll(formObj.cntr_ttl_meas_qty.value, ",");
					
					// Decimal rounding
					bkg_wgt_qty = Math.round(bkg_wgt_qty * 1000) / 1000;
					bkg_meas_qty = Math.round(bkg_meas_qty * 1000) / 1000;
					cm_wgt_qty = Math.round(cm_wgt_qty * 1000) / 1000;
					cm_meas_qty = Math.round(cm_meas_qty * 1000) / 1000;
					if(document.form.bkg_cfm_flg.value != "CMCFM"){
						doActionIBSheet(sheetObjects[1],document.form,COMMAND06);
					}else{
						//Show update window if quantities differ from BKG infomation and Container information
//						if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty){
						if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty ||
								cntr_ttl_pack_qty != cm_pck_qty || cntr_ttl_wgt_qty != cm_wgt_qty || cntr_ttl_meas_qty != cm_meas_qty	){
	                        var sUrl="ESM_BKG_0958.do" +
	                                "?bkg_pck_qty=" + bkg_pck_qty +
	                                "&bkg_pck_unit=" + bkg_pck_unit +
	                                "&bkg_wgt_qty=" + bkg_wgt_qty +
	                                "&bkg_wgt_unit=" + bkg_wgt_unit +
	                                "&bkg_meas_qty=" + bkg_meas_qty +
	                                "&bkg_meas_unit=" + bkg_meas_unit +
	                                "&cm_pck_qty=" + cm_pck_qty +
	                                "&cm_pck_unit=" + cm_pck_unit +
	                                "&cm_wgt_qty=" + cm_wgt_qty +
	                                "&cm_wgt_unit=" + cm_wgt_unit +
	                                "&cm_meas_qty=" + cm_meas_qty +
//	                                "&cm_meas_unit=" + cm_meas_unit;
	                                "&cm_meas_unit=" + cm_meas_unit + 
	                                "&cntr_ttl_pack_qty=" + cntr_ttl_pack_qty + 
	                                "&cntr_ttl_wgt_qty=" + cntr_ttl_wgt_qty + 
	                                "&cntr_ttl_meas_qty=" + cntr_ttl_meas_qty;
	                        ComOpenPopup(sUrl,600, 350, "", "1,0", true);
//	        				ComOpenPopup(sUrl,600, 300, "callbackDecisionCode", "1,0", true);

	
						} else { // add else statement to save the data in CMCFM mode
							doActionIBSheet(sheetObjects[1],document.form,COMMAND06);
						}

					}
				}
			break;
			case IBINSERT:      // insert
//				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"mf_cfm_flg") == 1) return;
				if(formObj.cntr_no.value == '' || sheetObjects[0].RowCount()== 0 || sheetObjects[0].GetSelectRow()< 1){
					ComShowMessage(ComGetMsg("BKG08130"));
					return;
				}else{
					var newRow=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(newRow, "cntr_no",formObj.cntr_no.value,0);
					sheetObj.SetCellValue(newRow, "pck_qty",0,0);
					//sheetObj.CellValue2(newRow, "pck_tp_cd")   = formObj.bkg_pck_unit.value;
					sheetObj.SetCellValue(newRow, "cntr_mf_wgt",0,0);
					sheetObj.SetCellValue(newRow, "wgt_ut_cd",formObj.wgt_ut_cd.value,0);
					sheetObj.SetCellValue(newRow, "meas_qty",0,0);
					sheetObj.SetCellValue(newRow, "meas_ut_cd",formObj.meas_ut_cd.value,0);
					cntrNo = sheetObj.GetCellValue(newRow,"cntr_no");
					setDgCombo(cntrNo);
					// changeEditable
					changeEditable();
					// rearangeSeq
					setSeq();
					formObj.dirty_flag.value='Y';
				}
			break;
			case IBDELETE:      // delete
//				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"mf_cfm_flg") == 1) return;
				/* Row delete */
				ComRowDelete(sheetObj, "sel", 1);
				//ComRowHideDelete(sheetObj, "sel");
				/* Queantity */
				syncQuantity("pck_qty");
				syncQuantity("cntr_mf_wgt");
				syncQuantity("meas_qty");
				// changeEditable
				//changeEditable();
				// rearangeSeq
				setSeq();
				formObj.dirty_flag.value='Y';
			break;
			case IBCOPYROW:
				//alert("->" + formObj.mf_cfm_flg.value);
//				if(formObj.mf_cfm_flg.value == 'Y' || formObj.mf_cfm_flg.value == 1) return;
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"mf_cfm_flg") == 1) return;
				//if(formObj.rep_cmdt_cd.value == '00' || formObj.rep_cmdt_cd.value == '99'){
				//	ComShowMessage(ComGetMsg("BKG00338"));
				//	return;
				//}
				/* mk_desc */
				//alert(sheetObj.id + " " +sheetObj.RowCount+ "/" + sheetObj.SelectRow + " - " + formObj.bkg_mk_desc.value);
				//alert(sheetObj.RowHidden(sheetObj.SelectRow)==false)
				if(sheetObj.RowCount()> 0 && sheetObj.GetSelectRow()> 0 && sheetObj.GetRowHidden(sheetObj.GetSelectRow())==false) {
					// quantity
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pck_qty",formObj.bkg_pck_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pck_tp_cd",formObj.bkg_pck_unit.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_wgt",formObj.bkg_wgt_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "wgt_ut_cd",formObj.wgt_ut_cd.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "meas_qty",formObj.bkg_meas_qty.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "meas_ut_cd",formObj.meas_ut_cd.value,0);
					// description
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_mk_desc",formObj.bkg_mk_desc.value,0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_gds_desc",formObj.bkg_cstms_desc.value,0);
					formObj.dirty_flag.value='Y';
				}
			break;
			case COMMAND01:
//				var isAsk=false;
//				var rflg=false;
				var rcnt=sheetObj.RowCount();
				
				for(ix=1;ix <= rcnt;ix++){
					sheetObj.SetCellValue(ix, "mf_cfm_flg",1,0);
					//
//					var qty1=ComColumnSumByCond(sheetObjects[1], "pck_qty", "cntr_no", sheetObj.GetCellValue(ix, "cntr_no"), false);
//					var qty2=ComColumnSumByCond(sheetObjects[1], "cntr_mf_wgt", "cntr_no", sheetObj.GetCellValue(ix, "cntr_no"), false);
//					var qty3=ComColumnSumByCond(sheetObjects[1], "meas_qty", "cntr_no", sheetObj.GetCellValue(ix, "cntr_no"), false);
					//Stop to show confirmation message
//					if(sheetObj.GetCellValue(ix, "pck_qty") != qty1 ||
//							sheetObj.GetCellValue(ix, "cntr_wgt") != qty2 ||
//							sheetObj.GetCellValue(ix, "meas_qty") != qty3 ||
//							sheetObj.GetCellValue(ix, "pck_tp_cd") == ''){
//						if(!isAsk){
//							rflg=confirm(ComGetMsg("BKG00787"));
//							isAsk=true;
//						}
//						if(rflg){
//							sheetObj.SetCellValue(ix, "cm_pck_qty",qty1,0);
//							sheetObj.SetCellValue(ix, "cm_cntr_wgt",qty2,0);
//							sheetObj.SetCellValue(ix, "cm_meas_qty",qty3,0);
//							sheetObj.SetCellValue(ix, "pck_qty",qty1,0);
//							sheetObj.SetCellValue(ix, "cntr_wgt",qty2,0);
//							sheetObj.SetCellValue(ix, "meas_qty",qty3	,0);
							// syncPckUnit
//							syncPckUnit(sheetObj.GetCellValue(ix, "cntr_no"), "PK");
							// change current view
//							if(formObj.cntr_no.value == sheetObj.GetCellValue(ix, "cntr_no")){
//								formObj.pck_qty.value=ComAddComma3(sheetObj.GetCellValue(ix, "cm_pck_qty"), "#,###");
//								formObj.cntr_wgt.value=ComAddComma3(sheetObj.GetCellValue(ix, "cm_cntr_wgt"), "#,###.000");
//								formObj.meas_qty.value=ComAddComma3(sheetObj.GetCellValue(ix, "cm_meas_qty")	, "#,###.000");
//							}
//						}
//					}
				}
				formObj.bkg_cfm_flg.value="CMCFM";
//				formObj.mf_cfm_flg.value="Y";
				changeEditable();
				formObj.dirty_flag.value='Y';
			break;
			case COMMAND02:
				var rcnt=sheetObj.RowCount();
				for(ix=1;ix<=rcnt;ix++){
					sheetObj.SetCellValue(ix, "mf_cfm_flg",0,0);
				}
				formObj.bkg_cfm_flg.value="CMRLSE";
//				formObj.mf_cfm_flg.value="N";
				changeEditable();
				formObj.dirty_flag.value='Y';
			break;
			case COMMAND04:      //booking split no retrieve
				if(validateForm(sheetObj, formObj, sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.SetWaitImageVisible(1);
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;		
			case COMMAND05:      // Copy from Container 
				if(validateForm(sheetObj, formObj, sAction)) {
				//try {
				//	ComOpenWait(true); 
					var rcnt=sheetObjects[0].RowCount();
					var srcCol="cntr_no|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|dcgo_flg|awk_cgo_flg|hngr_flg";
					var tgtCol="cntr_no|pck_qty|pck_tp_cd|cntr_mf_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|dcgo_flg|awk_cgo_flg|hngr_flg";
					for(ix=1; ix<=rcnt; ix++){
						var mfCfmFlg=sheetObjects[0].GetCellValue(ix, "mf_cfm_flg");
						if(mfCfmFlg == 0) {
//							sheetObjects[0].Copy2SheetCol(sheetObjects[1],srcCol,tgtCol,ix,ix,-1,1); 
							var rowIdx=sheetObjects[1].DataInsert(-1);
							sheetObjects[1].SetCellValue(rowIdx,"cntr_no",sheetObjects[0].GetCellValue(ix,"cntr_no"),0);
							sheetObjects[1].SetCellValue(rowIdx,"pck_qty",sheetObjects[0].GetCellValue(ix,"pck_qty"),0);
							sheetObjects[1].SetCellValue(rowIdx,"pck_tp_cd",sheetObjects[0].GetCellValue(ix,"pck_tp_cd"),0);
							sheetObjects[1].SetCellValue(rowIdx,"cntr_mf_wgt",sheetObjects[0].GetCellValue(ix,"cntr_wgt"),0);
							sheetObjects[1].SetCellValue(rowIdx,"wgt_ut_cd",sheetObjects[0].GetCellValue(ix,"wgt_ut_cd"),0);
							sheetObjects[1].SetCellValue(rowIdx,"meas_qty",sheetObjects[0].GetCellValue(ix,"meas_qty"),0);
							sheetObjects[1].SetCellValue(rowIdx,"meas_ut_cd",sheetObjects[0].GetCellValue(ix,"meas_ut_cd"),0);
							sheetObjects[1].SetCellValue(rowIdx,"dcgo_flg",sheetObjects[0].GetCellValue(ix,"dcgo_flg"),0);
							sheetObjects[1].SetCellValue(rowIdx,"awk_cgo_flg",sheetObjects[0].GetCellValue(ix,"awk_cgo_flg"),0);
							sheetObjects[1].SetCellValue(rowIdx,"hngr_flg",sheetObjects[0].GetCellValue(ix,"hngr_flg"),0);
						};
					}
					syncQuantityAll();
					setSeq();
					// Show & Hide
					if(sheetObjects[0].GetTotalRows()> 0){
						sheetObjects[0].SelectCell(1, "cntr_no", false);
						setCMInfo(1);
					}
					formObj.dirty_flag.value='Y';
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
			
			case COMMAND06:        //real save
					
			try {
				ComOpenWait(true); 
				formObj.f_cmd.value=MULTI;

				if(document.form.cntr_update_flg.value=="Y"){
					var rcnt=sheetObjects[0].RowCount();
					for(ix=1;ix <= rcnt;ix++){
						var qty1=ComColumnSumByCond(sheetObjects[1], "pck_qty", "cntr_no", sheetObjects[0].GetCellValue(ix, "cntr_no"), false);
						var qty2=ComColumnSumByCond(sheetObjects[1], "cntr_mf_wgt", "cntr_no", sheetObjects[0].GetCellValue(ix, "cntr_no"), false);
						var qty3=ComColumnSumByCond(sheetObjects[1], "meas_qty", "cntr_no", sheetObjects[0].GetCellValue(ix, "cntr_no"), false);
						sheetObjects[0].SetCellValue(ix, "pck_qty",qty1,0);
						sheetObjects[0].SetCellValue(ix, "cntr_wgt",qty2,0);
						sheetObjects[0].SetCellValue(ix, "meas_qty",qty3,0);
						
						syncPckUnit(sheetObjects[0].GetCellValue(ix, "cntr_no"), "PK");
					}
				}
				
				// form param
				var sParam=FormQueryString(formObj);
				// Sheet1 param
				var sParamSheet1=sheetObjects[0].GetSaveString();
				if (sParamSheet1 != "") {
					sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
				}
				// Sheet2 param
				var sParamSheet2=sheetObjects[1].GetSaveString();
				if (sParamSheet2 != "") {
					sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
				}
				// return xML
//				alert(sParam);
				var rXml=sheetObj.GetSaveData("ESM_BKG_0079_07GS.do", sParam);
				var rMsg=ComResultMessage(rXml);
				if(rMsg == ''){
					/* Transaction status */
					sheetObjects[0].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
					sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
					formObj.dirty_flag.value='N';
					/* success Msg */
					ComShowMessage(ComGetMsg("BKG00166"));
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
					setCMInfo(1);
				} else {
					//alert(rMsg.split('<||>').join('\n'));
					ComShowMessage(rMsg);
				}
				}finally{
					document.form.cntr_update_flg.value="";
					ComOpenWait(false);
				}

			break;
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      // Retrieve
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
			break;
			case IBSAVE:        //저장
				if(document.form.isInquiry.value == "Y") return false;
				if(formObj.dirty_flag.value != 'Y')  {
					ComShowMessage(ComGetMsg("BKG00233"));
					return false;
				}
				if(sheetObjects[0].GetTotalRows()== 0){
					ComShowMessage(ComGetMsg("BKG01028"));
					return false;
				}
				if(confirm(ComGetMsg("BKG00350")) == false) return false;
//				if(sheetObjects[0].GetTotalRows()== 0) return false;
//				if(formObj.dirty_flag.value != 'Y')  {
//					//alert("변경된 내용이 없습니다.");
//					return false;
//				}
				if(formObj.bkg_sts_cd.value == 'X') {
					ComShowMessage(ComGetMsg("BKG00433"));
					return false;
				}
				if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N') {
					ComShowMessage(ComGetMsg("BKG00335"));
					return false;
				}
				if(formObj.bkg_no.value == '' || formObj.bkg_no.value.length < 11){
					ComShowMessage(ComGetMsg("BKG00463"));
					formObj.bkg_no.focus();
					return false;
				}
				if(formObj.bl_no.value == '' ){
					ComShowMessage(ComGetMsg("BKG00463"));
					formObj.bl_no.focus();
					return false;
				}
				/*
//no support[check again]CLT 				sheetObjects[1].SpaceDupCheck=false;
				var dupRow=sheetObjects[1].ColValueDup("dcgo_seq", false);
				if(dupRow != -1){
ComShowMessage(ComGetMsg("BKG01136", sheetObjects[1].GetCellValue(dupRow,"dcgo_seq")));
					return false;
				}				
				if(formObj.eur_flg.value == 'Y'){
					var cntrCnt=sheetObjects[0].RowCount();
					for(i=1;i<=cntrCnt;i++){
var cntrNo=sheetObjects[0].GetCellValue(i, "cntr_no");
						var cntrArr1=ComFindText(sheetObjects[1], "cntr_no", cntrNo);
						var cntrArr2=ComFindText(sheetObjects[2], "cntr_no", cntrNo);
						if(cntrArr2.length > 0){
							if(cntrArr1.length < cntrArr2.length){
								ComShowMessage(ComGetMsg("BKG01135", cntrNo));
								return false;
							}
						}
					}
				}	
				*/
				var rcnt=sheetObj.RowCount();
				
				//Special character check....
				for(ix=1;ix<=rcnt;ix++){
					var mf_gds = sheetObj.GetCellValue(ix, "cntr_mf_gds_desc");
					sheetObj.SetCellValue(ix, "cntr_mf_gds_desc", chekcSpecialValue(mf_gds), 0);
					var mf_mk = sheetObj.GetCellValue(ix, "cntr_mf_mk_desc");
					sheetObj.SetCellValue(ix, "cntr_mf_mk_desc", chekcSpecialValue(mf_mk), 0);
				}
				
				var cntr_no = "";
				for(ix=1;ix<=rcnt;ix++){
					cntr_no = sheetObjects[1].GetCellValue(ix, "cntr_no");
					if(sheetObj.GetCellValue(ix, "ibflag") == "D"){ // sheetObj.GetRowHidden(ix)
						continue;
					}
					if(sheetObj.GetCellValue(ix, "pck_qty") == '') {
//						ComShowMessage(ComGetMsg("BKG00504"));
						ComShowMessage(ComGetMsg("BKG03035", "Package Quantity.\n\nContainer No : "+cntr_no));
						return false;
					}
					if(sheetObj.GetCellValue(ix, "pck_tp_cd") == '') {
//						ComShowMessage(ComGetMsg("BKG00505"));
						ComShowMessage(ComGetMsg("BKG03035", "Package Type.\n\nContainer No : "+cntr_no));
						return false;
					}
					if(sheetObj.GetCellValue(ix, "wgt_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Weight Unit Code");
						return false;
					}
					if(sheetObj.GetCellValue(ix, "meas_ut_cd") == '') {
						ComShowCodeMessage("BKG08179","Measure Unit Code");
						return false;
					}
					if(ComTrim(sheetObj.GetCellValue(ix, "cntr_mf_gds_desc")) == '') {
//						ComShowMessage(ComGetMsg("BKG01042"));
						ComShowMessage(ComGetMsg("BKG03035", "Description.\n\nContainer No : "+cntr_no));
						return false;
					}
//					if(sheetObj.GetCellValue(ix, "cntr_mf_gds_desc").length+sheetObj.GetCellValue(ix, "cntr_mf_mk_desc").length > 4000) {
////						ComShowMessage(ComGetMsg("BKG01042"));
//						ComShowMessage(ComGetMsg("BKG06129"));
//						return false;
//					}
					
					if( sheetObj.GetCellValue(ix, "cntr_mf_gds_desc").length > 3500 ){
		                ComShowCodeMessage("COM12142","Description","3500");
		                return false;
					}
					if( sheetObj.GetCellValue(ix, "cntr_mf_mk_desc").length > 3500 ){
		                ComShowCodeMessage("COM12142","Marks","3500");
		                return false;
					}
					if(formObj.hts_flg.value == 'Y' && sheetObj.GetCellValue(ix, "hamo_trf_cd") == ''){
//						ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
						ComShowMessage(ComGetMsg("BKG03035", "HTS Code.\n\nContainer No : "+cntr_no));
						return false;
					}					
					if(sheetObj.GetCellValue(ix, "hamo_trf_cd") != '' && (sheetObj.GetCellValue(ix, "hamo_trf_cd").length < 6 || sheetObj.GetCellValue(ix, "hamo_trf_cd").length > 10)) {
//						ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
						ComShowMessage(ComGetMsg("BKG95001", "check the length of HTS Code.\n\nContainer No : "+cntr_no));
						return false;
					}
					if(sheetObj.GetCellValue(ix, "cmdt_hs_cd") != '' && (sheetObj.GetCellValue(ix, "cmdt_hs_cd").length < 6 || sheetObj.GetCellValue(ix, "cmdt_hs_cd").length > 10)) {
//						ComShowMessage(ComGetMsg("BKG00334", 'HS'));
						ComShowMessage(ComGetMsg("BKG95001", "check the length of HS Code.\n\nContainer No : "+cntr_no));
						return false;
					}
					if(!ComIsNull(sheetObj.GetCellValue(ix, "cmdt_hs_cd"))){
						if(!checkHsCd(sheetObj, sheetObj.GetCellValue(ix, "cmdt_hs_cd"))){
							return false;
						}
					}
					if(sheetObj.GetCellValue(ix, "ncm_no") == '') {
						var por_cnty=(formObj.por_cd.value == '') ? '' : formObj.por_cd.value.substring(0, 2);
						var pol_cnty=(formObj.pol_cd.value == '') ? '' : formObj.pol_cd.value.substring(0, 2);
						var pod_cnty=(formObj.pod_cd.value == '') ? '' : formObj.pod_cd.value.substring(0, 2);
						var dev_cnty=(formObj.del_cd.value == '') ? '' : formObj.del_cd.value.substring(0, 2);
						if(por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || dev_cnty == 'BR'){
//							ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
							ComShowMessage(ComGetMsg("BKG03035", "NCM Code.\n\nContainer No : "+cntr_no));
							return false;
						}
					}
					if(sheetObj.GetCellValue(ix, "ncm_no") != '' && (sheetObj.GetCellValue(ix, "ncm_no").length < 4 || sheetObj.GetCellValue(ix, "ncm_no").length > 8)) {
//						ComShowMessage(ComGetMsg("BKG00788", 'NCM'));
						ComShowMessage(ComGetMsg("BKG95001", "check the length of NCM Code.\n\nContainer No : "+cntr_no));
						return false;
					}
					//alert("-->" + formObj.mypkg_flg.value);
					if(sheetObj.GetCellValue(ix, "hamo_trf_cd") == '' && sheetObj.GetCellValue(ix, "cmdt_hs_cd") == '' && formObj.mypkg_flg.value == 'Y') {
						if(formObj.pol_cd.value != 'MYPKG' && formObj.pod_cd.value != 'MYPKG'){
							ComShowMessage(ComGetMsg("BKG01045"));
							return false;
						}
					}
				} // end of FOR
				var ncnt=sheetObjects[0].RowCount();
				for(nx=1;nx<=ncnt;nx++){
					if(sheetObjects[0].GetCellValue(nx, "bb_cgo_flg") == 'N'){
						var cntrNo=sheetObjects[0].GetCellValue(nx, "cntr_no");
						var cntrArr=ComFindText(sheetObj, "cntr_no", cntrNo);
						for(ia=0;ia<cntrArr.length;ia++){
							//alert(cntrNo + " = " + sheetObjects[0].CellValue(nx, "bb_cgo_flg") +" -> "+ sheetObj.CellValue(cntrArr[ia], "pck_qty"));
							if(sheetObj.GetCellValue(cntrArr[ia], "pck_qty") == 0) {
								ComShowMessage(ComGetMsg("BKG08004", cntrNo));
								return false;
							}
						}
					}
					//stop to show message
//					if(sheetObjects[0].GetCellValue(nx, "mf_cfm_flg") == 1){
//						if(sheetObjects[0].GetCellValue(nx, "pck_qty") != sheetObjects[0].GetCellValue(nx, "cm_pck_qty") ||
//						sheetObjects[0].GetCellValue(nx, "cntr_wgt") != sheetObjects[0].GetCellValue(nx, "cm_cntr_wgt") ||
//						sheetObjects[0].GetCellValue(nx, "meas_qty") != sheetObjects[0].GetCellValue(nx, "cm_meas_qty")){
//							//ComShowMessage(ComGetMsg("BKG01043"));
//							if(!confirm(ComGetMsg("BKG01043", sheetObjects[0].GetCellValue(nx, "cntr_no") ))) return false;
//						}
//					}
				}

			break;
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;					
		}
        return true;
    }
	/*-------------------------------------------------------------------------------------------------------
	 * Event Handling
	 *------------------------------------------------------------------------------------------------------*/
    function form1_blur(){
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "bkg_no":
            break;
        }
    }
//	function form1_keypress(){
//		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
//   			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
//			//ComKeyEnter("search");
//		}
//		switch(event.srcElement.dataformat){
//			case "ymd":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "ym":
//			case "yw":
//			case "jumin":
//			case "saupja":	
//				ComKeyOnlyNumber(event.srcElement, "-"); 
//			break;
//			case "hms":
//			case "hm":		
//				ComKeyOnlyNumber(event.srcElement, ":"); 
//			break;
//			case "int":		
//				ComKeyOnlyNumber(event.srcElement); 
//			break;
//			case "float":	     
//				ComKeyOnlyNumber(event.srcElement, "."); 
//			break;	    
//			case "engup":
//				ComKeyOnlyAlphabet("upper");
//			break;
//			case "engupnum":
//				ComKeyOnlyAlphabet("uppernum");
//			break;
//			case "engupnumspc":
//				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
//				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//				if(keyValue >= 97 && keyValue <= 122){                  //소문자
//                	event.keyCode=keyValue + 65 - 97;
//				}
//				//event.returnValue = true;
//			break;
//		}			
//	}
    function form1_change(){
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		//document.form.dirty_flag.value = 'Y'
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "cntr_no":
            break;
        }
    }
	// Retrieve function
	function t9sheet1_OnClick(sheetObj, row, col, val) {
//        var col_name=sheetObj.ColSaveName(col);
//		switch(col_name) {
//			case "cntr_no":
//				setCMInfo(row);
//			break;
//		} // end switch
		setCMInfo(row);
	}
	function t9sheet1_OnChange(sheetObj, row, col, val){
		document.form.dirty_flag.value='Y'
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "mf_cfm_flg":
				if(val==1) {
//					document.form.mf_cfm_flg.value='Y';
					var cfmFlg=ComFindText(sheetObj, "mf_cfm_flg", 0);
					if(cfmFlg.length == 0){
						document.form.bkg_cfm_flg.value="CMCFM";
					}
					// sync quantity
//					var qty1=ComColumnSumByCond(sheetObjects[1], "pck_qty", "cntr_no", sheetObj.GetCellValue(row, "cntr_no"), false);
//					var qty2=ComColumnSumByCond(sheetObjects[1], "cntr_mf_wgt", "cntr_no", sheetObj.GetCellValue(row, "cntr_no"), false);
//					var qty3=ComColumnSumByCond(sheetObjects[1], "meas_qty", "cntr_no", sheetObj.GetCellValue(row, "cntr_no"), false);
//					if(sheetObj.GetCellValue(row, "pck_qty") != qty1 ||
//							sheetObj.GetCellValue(row, "cntr_wgt") != qty2 ||
//							sheetObj.GetCellValue(row, "meas_qty") != qty3 ||
//							sheetObj.GetCellValue(row, "pck_tp_cd") == ''){
						//Stop to show confirmation message
//						if(confirm(ComGetMsg("BKG00787"))){
//							sheetObj.SetCellValue(row, "cm_pck_qty",qty1,0);
//							sheetObj.SetCellValue(row, "cm_cntr_wgt",qty2,0);
//							sheetObj.SetCellValue(row, "cm_meas_qty",qty3,0);
//							sheetObj.SetCellValue(row, "pck_qty",qty1,0);
//							sheetObj.SetCellValue(row, "cntr_wgt",qty2,0);
//							sheetObj.SetCellValue(row, "meas_qty",qty3,0);
							// syncPckUnit
//							syncPckUnit(sheetObj.GetCellValue(row, "cntr_no"), "PK");
							// change current view
//							if(document.form.cntr_no.value == sheetObj.GetCellValue(row, "cntr_no")){
//								document.form.pck_qty.value=ComAddComma3(sheetObj.GetCellValue(row, "cm_pck_qty"), "#,###");
//								document.form.cntr_wgt.value=ComAddComma3(sheetObj.GetCellValue(row, "cm_cntr_wgt"), "#,###.000");
//								document.form.meas_qty.value=ComAddComma3(sheetObj.GetCellValue(row, "cm_meas_qty"), "#,###.000");
//							}
//						}
//					}
				}else{
//					document.form.mf_cfm_flg.value='N';
					document.form.bkg_cfm_flg.value="CMRLSE";
				}
				// changeEditable
				changeEditable();
			break;
			
		} // end switch
	}
	function t9sheet2_OnPopupClick(sheetObj, row, col){
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "PCKPop":
				comBkgCallPop0696("callbackPckTp", sheetObj.GetCellValue(row, "pck_tp_cd"));
			break;
			case "MDPop":
				
				var frm2 = document.form2;
				var width = 450;
				var height = 530;
				var left = (screen.width-width)/2;
				var top = (screen.height-height)/2;
				var win = window.open("", "ESM_BKG_0706", "width="+width+",height="+height+",left="+left+",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
				frm2.mk_desc.value = sheetObj.GetCellValue(row, "cntr_mf_mk_desc");
				frm2.gds_desc.value = sheetObj.GetCellValue(row, "cntr_mf_gds_desc");
				frm2.func.value = "callbackMFDesc";
				frm2.action = "ESM_BKG_0706.do";
				frm2.method = "POST";
				frm2.target = "ESM_BKG_0706";
				frm2.submit();	           
				
//			   var frm2=document.form2;
//	           var param="?pgmNo=ESM_BKG_0706&gds_desc="+sheetObj.GetCellValue(row, "cntr_mf_gds_desc")+"&mk_desc="+sheetObj.GetCellValue(row, "cntr_mf_mk_desc");	           
//	           ComOpenPopup("ESM_BKG_0706.do"+param, 450,450, "callbackMFDesc","1,0", true);
			break;
			case "HTCPop":
//				comBkgCallPop0607("callbackHTSCode", 'T', sheetObj.GetCellValue(row, "hamo_trf_cd"));
	           var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd=T"+"&hamo_trf_cd="+sheetObj.GetCellValue(row, "hamo_trf_cd")+"&hs_aply_dt=";
	           ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, "callbackHTSCode", "1,0,1,1,1", true);
			break;
			case "CMDTPop":
//				comBkgCallPop0607("callbackHSCode", 'H', sheetObj.GetCellValue(row, "cmdt_hs_cd"));
	           var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd=H"+"&hamo_trf_cd="+sheetObj.GetCellValue(row, "cmdt_hs_cd")+"&hs_aply_dt="+document.form.hs_aply_dt.value;
	           ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, "callbackHSCode", "1,0,1,1,1", true);
			break;
			case "NCMPop":
				var ncm_no=sheetObj.GetCellValue(row, "ncm_no");
				var sUrl="ESM_BKG_0745_P.do?page_gubun=popup&ncm_no="+ncm_no;
				ComOpenPopup(sUrl,1000, 550, "sheet1_SetValues", "1,0", true);  
			break;
		} // end switch
	}
	
	function t9sheet2_OnChange(sheetObj, row, col, val){
		document.form.dirty_flag.value='Y'
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "pck_tp_cd":
				if(sheetObj.GetCellValue(row,"pck_tp_cd")!= ""){
					var pckTpCd = sheetObj.GetCellValue(row,"pck_tp_cd");
					var rXml = sheetObj.GetSearchData("ESM_BKG_0079_07GS.do","f_cmd="+SEARCH01+"&pck_tp_cd="+pckTpCd);
					var pckNm = ComGetEtcData(rXml, "pck_nm");
					if(pckNm == undefined || pckNm == ''){
						ComShowMessage(ComGetMsg("BKG00530"));
						sheetObj.SetCellValue(row,"pck_tp_cd","");
						return false;
					}
				}
				syncPckUnit(sheetObj.GetCellValue(row, "cntr_no"), "PK");
			break;
			case "pck_qty":
			case "cntr_mf_wgt":
			case "meas_qty":
				/* Measure */
				var measQty = sheetObj.GetCellValue(row, "meas_qty");
				var measUtCd = document.form.meas_ut_cd.value;
				if(measUtCd=="CBM"&&measQty >= 1000){
					ComShowMessage(ComGetMsg("BKG01187"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}else if(measUtCd=="CBF"&&measQty >= 35000){
					ComShowMessage(ComGetMsg("BKG01186"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}
				
//	            if(sheetObj.GetCellValue(row, "meas_qty") >= 1000){
//					ComShowMessage(ComGetMsg("BKG00174"));
//					sheetObj.SetCellValue(row, "meas_qty",0,0);
//					sheetObj.SelectCell(row, "meas_qty");
//					return false;
//				}
	            /* Measure Container No. */
	            var cntr_meas_qty = 0;
	            var cntrNo = sheetObj.GetCellValue(row, "cntr_no");
	            for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++ ){
	                if(sheetObj.GetRowStatus(ir) != 'D'&&sheetObj.GetCellValue(ir, "cntr_no")==cntrNo){
    	                cntr_meas_qty += BkgParseFloat(sheetObj.GetCellValue(ir, "meas_qty"));
	    			}
	    		}
	            cntr_meas_qty=Math.round(cntr_meas_qty * 1000) / 1000;
//	            if(cntr_meas_qty >= 1000){
//					ComShowMessage(ComGetMsg("BKG00174"));
//					sheetObj.SetCellValue(row, "meas_qty",0,0);
//					sheetObj.SelectCell(row, "meas_qty");
//					return false;
//				}
	            if(measUtCd=="CBM"&&cntr_meas_qty >= 1000){
					ComShowMessage(ComGetMsg("BKG01187"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}else if(measUtCd=="CBF"&&cntr_meas_qty >= 35000){
					ComShowMessage(ComGetMsg("BKG01186"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}
				syncQuantity(col_name);
			break;
			case "self":
				if(val == 1) {
					sheetObj.SetCellValue(row, "cntr_mf_no",'SELF',0);
					sheetObj.SetCellEditable(row, "cntr_mf_no",0);
				} else {
					sheetObj.SetCellValue(row, "cntr_mf_no",'',0);
					sheetObj.SetCellEditable(row, "cntr_mf_no",1);
				}
			break;
		} // end switch
	}
	// Search End Event
	function t9sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()> 0) {
			for(var row=sheetObj.HeaderRows(); row <= sheetObj.RowCount(); row++) {
				if(sheetObj.GetCellValue(row, "cntr_mf_no") == 'SELF') {
					sheetObj.SetCellValue(row, "self",1,0);
					sheetObj.SetCellEditable(row, "cntr_mf_no",0);
				} else {
					sheetObj.SetCellValue(row, "self",0,0);
					sheetObj.SetCellEditable(row, "cntr_mf_no",1);
				}
			}
		}		
		// changeEditable
		changeEditable();
	}
	
	// t9sheet2 On After Edit Event Handling
	function t9sheet2_OnAfterEdit(sheetObj, Row, Col){
        var col_name=sheetObj.ColSaveName(Col);
		switch(col_name) {
			case "cntr_mf_mk_desc":
			case "cntr_mf_gds_desc":
				var str = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(str), 0);
			break;
		}
	}	
	/*---------------------------------------------------------------------------------------------------
	 * Functions
	 *--------------------------------------------------------------------------------------------------*/
	// Package, Weight, Measure value same
	function syncQuantity(col_name){
		// sum
		var vSum=ComColumnSumByCond(sheetObjects[1], col_name, "cntr_no", document.form.cntr_no.value, false);
		// CM
		//var cmArr = ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		//for(rx=0;rx<cmArr.length;rx++){
		//	vSum += BkgParseFloat(sheetObjects[1].CellValue(cmArr[rx], col_name));
		//}
		// Set Value
		if(col_name=="pck_qty") {
			//document.form.pck_qty.value = ComAddComma3(''+vSum, "#,###");
			var bkg_pck_qty=ComTrimAll(document.form.pck_qty.value, ",");
			if(vSum != bkg_pck_qty) document.form.cm_pck_qty.style.color="red";
			else  document.form.cm_pck_qty.style.color="#606060";
			document.form.cm_pck_qty.value=ComAddComma3(''+vSum, "#,###");
			var cntrArr=ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].SetCellValue(cntrArr[0], "cm_pck_qty",vSum,0);
			}
		}
		if(col_name=="cntr_mf_wgt") {
			//document.form.cntr_wgt.value = ComAddComma3(''+vSum, "#,###.000");
			var bkg_cntr_wgt=ComTrimAll(document.form.cntr_wgt.value, ",");
			if(vSum != bkg_cntr_wgt) document.form.cm_cntr_wgt.style.color="red";
			else  document.form.cm_cntr_wgt.style.color="#606060";
			document.form.cm_cntr_wgt.value=ComAddComma3(''+vSum, "#,###.000");
			var cntrArr=ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].SetCellValue(cntrArr[0], "cm_cntr_wgt",vSum,0);
			}
		}
		if(col_name=="meas_qty") {
			//document.form.meas_qty.value = ComAddComma3(''+vSum, "#,###.000");
			var bkg_meas_qty=ComTrimAll(document.form.meas_qty.value, ",");
			if(vSum != bkg_meas_qty) document.form.cm_meas_qty.style.color="red";
			else  document.form.cm_meas_qty.style.color="#606060";
			document.form.cm_meas_qty.value=ComAddComma3(''+vSum, "#,###.000");
			var cntrArr=ComFindText(sheetObjects[0], "cntr_no", document.form.cntr_no.value);
			if(cntrArr.length > 0){
				sheetObjects[0].SetCellValue(cntrArr[0], "cm_meas_qty",vSum,0);
			}
		}
	}
	// Package, Weight, Measure value same
	function syncQuantityAll(){
		// CM
		//var cmArr = ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		//for(rx=0;rx<cmArr.length;rx++){
		//	vSum += BkgParseFloat(sheetObjects[1].CellValue(cmArr[rx], col_name));
		//}
		for(ix=1;ix<=sheetObjects[0].RowCount();ix++){
			document.form.cntr_no.value=sheetObjects[0].GetCellValue(ix,"cntr_no");
			if(sheetObjects[0].GetCellValue(ix,"mf_cfm_flg") != 1) {
				syncQuantity("pck_qty");
				syncQuantity("cntr_mf_wgt");
				syncQuantity("meas_qty");
			}
		}
	}
	/* grid1 and grid2 Column value Synchronization. */
	function syncPckUnit(cntr_no, def) {
		var rflg=false;
		//var rcnt = sheetObjects[1].RowCount;
		//for(rn=1;rn<=rcnt;rn++){
		var col_val='';
		var cmArr=ComFindText(sheetObjects[1], "cntr_no", cntr_no);
		for(rn=0;rn<cmArr.length;rn++){
			if(rn!=0){
				if(col_val != sheetObjects[1].GetCellValue(cmArr[rn], "pck_tp_cd")){
					rflg=true;
					break;
				}
			}
			col_val=sheetObjects[1].GetCellValue(cmArr[rn], "pck_tp_cd");
		}
		if(col_val == ''){
			//document.form.pck_tp_cd.value = def;
		}else{
			if(rflg){
				var idxArr=ComFindText(sheetObjects[0], "cntr_no", cntr_no);
				if(idxArr.length > 0) {
					sheetObjects[0].SetCellValue(idxArr[0], "pck_tp_cd",def,0);
				}
				document.form.pck_tp_cd.value=def;
			}else{
				var idxArr=ComFindText(sheetObjects[0], "cntr_no", cntr_no);
				if(idxArr.length > 0) {
					sheetObjects[0].SetCellValue(idxArr[0], "pck_tp_cd",col_val,0);
				}
				document.form.pck_tp_cd.value=col_val;
			}
		}
	}
	/* when cntr seleted in cntr grid, set Cntr info and CM grid */
	function setCMInfo(row){
		if(row > 0) {
			var cntrNo = sheetObjects[0].GetCellValue(row, "cntr_no");
						
			// CopyRow To Form
//			alert("cntr_no -> " + sheetObjects[0].GetCellValue(row, "cntr_no") +" "+ row);
			ComCopyRowToForm(sheetObjects[0], row, document.form, "");
			document.form.pck_qty.value=ComAddComma3(document.form.pck_qty.value, "#,###");
			document.form.cntr_wgt.value=ComAddComma3(document.form.cntr_wgt.value, "#,###.000");
			document.form.meas_qty.value=ComAddComma3(document.form.meas_qty.value, "#,###.000");			
			var sealNos=sheetObjects[0].GetCellValue(row, "cntr_seal_no");
			if(sealNos!=''){
				var seal_arr=(sealNos.indexOf(',') == -1) ? new Array(sealNos) : sealNos.split(',');
				ComArrayToOptions(seal_arr, document.form.cntr_seal_no);
			}
			// retrieve CM
//			ComShowAndHideSheet(sheetObjects[1], "cntr_no", sheetObjects[0].GetCellValue(row, "cntr_no"));
			manageDeatilRowsHidden(sheetObjects[1], "cntr_no", cntrNo);
//			ComShowAndHideSheet(sheetObjects[2], "cntr_no", sheetObjects[0].GetCellValue(row, "cntr_no"));
//			manageDeatilRowsHidden(sheetObjects[2], "cntr_no", cntrNo);
			
			setDgCombo(cntrNo);
//			if(dcgoSeq!=' '){
//				sheetObjects[1].SetColProperty("dcgo_seq", {ComboText:diffRmk, ComboCode:dcgoSeq} );
//			}else{
//				sheetObjects[1].SetColProperty("dcgo_seq", {ComboText:"", ComboCode:""} );
//			}
			// changeEditable
			changeEditable();
			// rearangeSeq
			setSeq();
			// calculate sum
			
			//sheetObjects[1].ShowSubSum("cntr_no", "pck_qty|cntr_mf_wgt|meas_qty")
			var cm_pck_qty=0;
			var cm_cntr_wgt=0;
			var cm_meas_qty=0;
			var rcnt=sheetObjects[1].RowCount();
			for(rn=1;rn<=rcnt;rn++){
				if(sheetObjects[1].GetRowHidden(rn) == false){
					cm_pck_qty  += BkgParseInt(sheetObjects[1].GetCellValue(rn, "pck_qty"));
					cm_cntr_wgt += BkgParseFloat(sheetObjects[1].GetCellValue(rn, "cntr_mf_wgt"));
					cm_meas_qty += BkgParseFloat(sheetObjects[1].GetCellValue(rn, "meas_qty"));
				}
			}
			cm_cntr_wgt=Math.round(cm_cntr_wgt * 1000) / 1000;
			cm_meas_qty=Math.round(cm_meas_qty * 1000) / 1000;
			//			
			document.form.cm_pck_qty.value=ComAddComma3(''+cm_pck_qty, "#,###");
			var bkg_pck_qty=ComTrimAll(document.form.pck_qty.value, ",");
			if(cm_pck_qty != bkg_pck_qty) document.form.cm_pck_qty.style.color="red";
			else  document.form.cm_pck_qty.style.color="#606060";
			document.form.cm_cntr_wgt.value=ComAddComma3(''+cm_cntr_wgt, "#,###.000");
			var bkg_cntr_wgt=ComTrimAll(document.form.cntr_wgt.value, ",");
			if(cm_cntr_wgt != bkg_cntr_wgt) document.form.cm_cntr_wgt.style.color="red";
			else  document.form.cm_cntr_wgt.style.color="#606060";
			document.form.cm_meas_qty.value=ComAddComma3(''+cm_meas_qty, "#,###.000");
			var bkg_meas_qty=ComTrimAll(document.form.meas_qty.value, ",");
			if(cm_meas_qty != bkg_meas_qty) document.form.cm_meas_qty.style.color="red";
			else  document.form.cm_meas_qty.style.color="#606060";
		}
	}
	//
	function setQuantityFromPopup(flag){
		return flag
	}
	function setColumnValue(sheetObj, col_name, col_value, setColumn, setValue){
		var idxArr=ComFindText(sheetObj, col_name, col_value);
		for(ir=0;ir<idxArr.length;ir++) {
			sheetObj.SetCellValue(idxArr[ir], setColumn,setValue,0);
		}
	}
	
	function changeEditable(){
		var dcFlg=(document.form.dcgo_flg != undefined && document.form.dcgo_flg.checked);
		var bbFlg=(document.form.bb_cgo_flg != undefined && document.form.bb_cgo_flg.checked);
		var akFlg=(document.form.awk_cgo_flg != undefined && document.form.awk_cgo_flg.checked);
		var rcFlg=(document.form.rc_flg != undefined && document.form.rc_flg.checked);
		var rdFlg=(document.form.rd_cgo_flg != undefined && document.form.rd_cgo_flg.checked);
		var hgFlg=(document.form.hngr_flg != undefined && document.form.hngr_flg.checked);
		document.form.dcgo_flg.disabled=!dcFlg;
		document.form.bb_cgo_flg.disabled=!bbFlg;
		document.form.awk_cgo_flg.disabled=!akFlg;
		document.form.rc_flg.disabled=!rcFlg;
		document.form.rd_cgo_flg.disabled=!rdFlg;
		document.form.hngr_flg.disabled=!hgFlg;
		var rcnt=sheetObjects[1].RowCount();
		for(rn=1; rn <= rcnt; rn++){
			sheetObjects[1].SetCellEditable(rn, "dcgo_flg",dcFlg);
			sheetObjects[1].SetCellEditable(rn, "awk_cgo_flg",akFlg);
			sheetObjects[1].SetCellEditable(rn, "hngr_flg",hgFlg);
		}
//		var cfmFlg=document.form.mf_cfm_flg.value;
		var cfmFlg = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"mf_cfm_flg");
		var cntr_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
//		if(cfmFlg == 'Y' || cfmFlg == 1 || document.form.isInquiry.value == "Y"){
		if(cfmFlg == 'Y' || cfmFlg == 1 || document.form.isInquiry.value == "Y" || ( document.form.bdr_flg.value == "Y" && document.form.corr_flg.value == "N")){
//			sheetObjects[1].SetEditable(0); //avoid issue that sheetObjects[1] details are not shown correctly
			changeRowEditable(cntr_no, 0);
			ComBtnDisable("btn_t9Add");
			ComBtnDisable("btn_t9Del");
			ComBtnDisable("btn_t9CopyMnd");
			ComBtnDisable("btn_t8multishp");
		}else{
//			sheetObjects[1].SetEditable(1);
			changeRowEditable(cntr_no, 1);
			ComBtnEnable("btn_t9Add");
			ComBtnEnable("btn_t9Del");
			ComBtnEnable("btn_t9CopyMnd");
			ComBtnEnable("btn_t8multishp");
		}
//		if(document.form.corr_flg.value == 'Y' || document.form.isInquiry.value == "Y") {
		if(document.form.isInquiry.value == "Y" || ( document.form.bdr_flg.value == "Y" && document.form.corr_flg.value == "N") ) {
			ComBtnDisable("btn_t9CMbyCntr");
		} else {
			ComBtnEnable("btn_t9CMbyCntr");
		}
		
		if(( document.form.bdr_flg.value == "Y" && document.form.corr_flg.value == "N")) {
			ComBtnDisable("btn_t9CMCopyCM");
			ComBtnDisable("btn_t9CopyFmCntr");
			ComBtnDisable("btn_t9AllConfirm");
			ComBtnDisable("btn_t9AllRelease");
			ComBtnDisable("btn_t9Save");
			sheetObjects[0].SetEditable(0);
		} else {
			ComBtnEnable("btn_t9CMCopyCM");
			ComBtnEnable("btn_t9CopyFmCntr");
			ComBtnEnable("btn_t9AllConfirm");
			ComBtnEnable("btn_t9AllRelease");
			ComBtnEnable("btn_t9Save");
			sheetObjects[0].SetEditable(1);
		}
	}
	
	function setSeq(){
		var rSeq=1;
		var rCnt=sheetObjects[1].RowCount();
		for (rn=1; rn <= rCnt; rn++) {
			var rsts=sheetObjects[1].GetRowStatus(rn);
			if(rsts != 'D' && sheetObjects[1].GetRowHidden(rn) == false){
				sheetObjects[1].SetCellValue(rn, "seq",rSeq++,0);
				sheetObjects[1].SetRowStatus(rn,rsts);
			}
		}
	}
	function copyCm(fmCntr, toCntrArr){
		if(fmCntr == '' || toCntrArr == ''){
			return;
		}
		//alert(fmCntr + " => " + toCntrArr)
		var tgtCnt=toCntrArr.length;
		//alert("tgtCnt==>" + tgtCnt)
		var cArr=ComFindText(sheetObjects[1], "cntr_no", fmCntr);
		//alert("cArr==>" + cArr)
		for(ix=0;ix<tgtCnt;ix++){
			//alert("\ttgt" +ix+ ". "+ toCntrArr[ix]);
			for(ir=0;ir<cArr.length;ir++) {
				var nRow=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetRowHidden(nRow,1);
				for(ic=0; ic <=  sheetObjects[1].LastCol(); ic++){
					if(sheetObjects[1].ColSaveName(ic) == "ibflag") continue;
					if(sheetObjects[1].ColSaveName(ic) == "cntr_no"){
						sheetObjects[1].SetCellValue(nRow, ic,toCntrArr[ix],0);
					}else{
						sheetObjects[1].SetCellValue(nRow, ic,sheetObjects[1].GetCellValue(cArr[ir], ic),0);
					}
				}
			}
		}
		document.form.dirty_flag.value='Y'
	}
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
		// syncPckUnit
		syncPckUnit(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cntr_no"), 'PK');
		document.form.dirty_flag.value='Y';
	}
	function callbackMFDesc(mk_desc, gds_desc){
		//alert(mk_desc + "\n===================================\n" + gds_desc);
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,1);
//		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,0);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,1);
		document.form.dirty_flag.value='Y';
	}
	function callbackHTSCode(returnValue){
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "hamo_trf_cd",returnValue[0][3],0);
		document.form.dirty_flag.value='Y';
	}
	function callbackHSCode(returnValue){
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_hs_cd",returnValue[0][3],0);
		document.form.dirty_flag.value='Y';
	}
	function sheet1_SetValues(returnValue){
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow() , 'ncm_no', returnValue.cd);
		document.form.dirty_flag.value='Y';
	}
//	function callbackDecisionCode(returnValue){
//		var formObj = document.form; 
//		decision_flag =  returnValue.cd;
//		if(decision_flag==0){
//			// nothing
//		}else if(decision_flag==1){
//
//			//formObj.bkg_pck_qty.value  = ComAddComma3(''+cm_pck_qty, "#,###");
//			//formObj.bkg_wgt_qty.value  = ComAddComma3(''+cm_wgt_qty, "#,###.000");
//			//formObj.bkg_meas_qty.value = ComAddComma3(''+cm_meas_qty, "#,###.000");
//			/* change container qnt'y */
//			//var cntrArr = ComFindText(sheetObjects[0], "cntr_no", formObj.cntr_no.value);
//			//if(cntrArr.length > 0){
//			//	sheetObjects[0].CellValue2(cntrArr[0], "pck_qty") = cm_pck_qty;
//			//	sheetObjects[0].CellValue2(cntrArr[0], "cntr_wgt") = cm_wgt_qty;
//			//	sheetObjects[0].CellValue2(cntrArr[0], "meas_qty") = cm_meas_qty;							
//			//}
//		}else {
//			return false;
//		}
//	}
	/* ESM_BKG_0391 */
	function callbackMultiShp(rArray){
		var formObj = document.form;
		var pck_qty= 0;
		var pck_tp_cd="";
		var cntr_mf_wgt=0;
		var wgt_ut_cd="";
		var meas_qty=0;
		var meas_ut_cd="";
		var mk_desc="";
		var cmdt_desc="";
		var hamo_trf_cd="";	//19-HS
		var cmdt_hs_cd="";	//21-HTS
		var ncm_no="";		//23
		
		if(rArray[0].length>0){
			for(var i=0; i<rArray[0].length;i++){
				//new ver.  ibflag|Sel.|CntrSeq|Container No.|MfSeq.|Package|Package|Package|TP/SZ|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|Vol|Seal No.1|Seal No.2|HS Code|HS Code|HTS Code|HTS Code|NCM Code|NCM Code|P/O No.|Print";
				pck_qty		=rArray[0][i][5];
				pck_tp_cd	=rArray[0][i][6];
				cntr_mf_wgt =rArray[0][i][9];
				wgt_ut_cd   =rArray[0][i][10];
				meas_qty	=rArray[0][i][11];
				meas_ut_cd	=rArray[0][i][12];
				mk_desc		=rArray[0][i][13];
				cmdt_desc	=rArray[0][i][15];
				hamo_trf_cd	=rArray[0][i][19];//
				cmdt_hs_cd	=rArray[0][i][21];//
				ncm_no		=rArray[0][i][23];//

				var newRow=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(newRow, "cntr_no"		,formObj.cntr_no.value,0);
				sheetObjects[1].SetCellValue(newRow, "pck_qty"		,pck_qty);
				sheetObjects[1].SetCellValue(newRow, "pck_tp_cd"	,pck_tp_cd);
				sheetObjects[1].SetCellValue(newRow, "cntr_mf_wgt"	,cntr_mf_wgt);
				sheetObjects[1].SetCellValue(newRow, "wgt_ut_cd"	,wgt_ut_cd);
				sheetObjects[1].SetCellValue(newRow, "meas_qty"		,meas_qty);
				sheetObjects[1].SetCellValue(newRow, "meas_ut_cd"	,meas_ut_cd);
				sheetObjects[1].SetCellValue(newRow, "cntr_mf_mk_desc"	,mk_desc);
				sheetObjects[1].SetCellValue(newRow, "cntr_mf_gds_desc"	,cmdt_desc);
				sheetObjects[1].SetCellValue(newRow, "hamo_trf_cd"	,hamo_trf_cd);
				sheetObjects[1].SetCellValue(newRow, "cmdt_hs_cd"	,cmdt_hs_cd);
				sheetObjects[1].SetCellValue(newRow, "ncm_no"		,ncm_no);
			}
			
			// rearangeSeq
			setSeq();

		}
	}	
	function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				//ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
//			}
		}
	}
	function searchData(bkgNo){
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		ComSetObjValue(formObj.dirty_flag, "N");
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	function setInquiryDisableButton() {
		if(document.form.isInquiry.value == "Y"){
			// button
			ComBtnDisable("btn_t9Save");
			ComBtnDisable("btn_t9CMCopyCM");
			ComBtnDisable("btn_t9CMbyCntr");
			ComBtnDisable("btn_t9Add");
			ComBtnDisable("btn_t9Del");
			ComBtnDisable("btn_t9CopyMnd");
		}
	}
	/**
	 * onblur Event <br>
	 **/
	function obj_deactivate() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=ComGetEvent("value");
		if (srcName == "bkg_no" || srcName == "bl_no") {
			formObj.elements[srcName].value=srcValue.toUpperCase();
		}
	}	
	
	function changeRowEditable(cntr_no, flag) {
		for(i=1; i<=sheetObjects[1].RowCount(); i++){
//			if(sheetObjects[1].GetCellValue(i, "cntr_no")==cntr_no){ // To make performance good
			if((sheetObjects[1].GetCellValue(i, "cntr_no")==cntr_no)&&(sheetObjects[1].GetRowEditable(i)!=flag)){
				sheetObjects[1].SetRowEditable(i, flag);
			}
		}
	}
	function setDgCombo(cntrNo){
		var dcgoSeq=" ";
		var diffRmk=" ";
		var rowcnt=sheetObjects[2].RowCount();
		for(i=1;i<=rowcnt;i++){
//			if(sheetObjects[2].GetRowHidden(i) == false){
			if(sheetObjects[2].GetCellValue(i, "cntr_no") == cntrNo){
				dcgoSeq=dcgoSeq + "|" + sheetObjects[2].GetCellValue(i, "dcgo_seq");
				diffRmk=diffRmk + "|" + sheetObjects[2].GetCellValue(i, "diff_rmk");
			}
		}
		var rowCnt2 = sheetObjects[1].RowCount();
		if(dcgoSeq!=" "){
			for(i=1;i<=rowCnt2;i++){
//				if(cntrNo == sheetObjects[1].GetCellValue(i, "cntr_no")){
				if((cntrNo == sheetObjects[1].GetCellValue(i, "cntr_no")) && (sheetObjects[1].GetCellProperty(i, "dcgo_seq", "ComboCode")=="")){
					sheetObjects[1].InitCellProperty(i,"dcgo_seq", {Type:"Combo", ComboText:diffRmk, ComboCode:dcgoSeq} );
				}
			}
		}else{
//			sheetObjects[1].SetColProperty("dcgo_seq", {Type:"Combo", ComboText:"", ComboCode:""} );
		}
	}
	
	/**
	 * Control visible/invisible rows of detail sheet based on selected container<br>
	 **/
	function manageDeatilRowsHidden(sheetObj, Col, keyVal){
		var rowCount = sheetObj.RowCount();
		var visibleIdx = "";
		var notVisibleIdx = "";
		for (i=1;i<=rowCount;i++){
			if((sheetObj.GetCellValue(i, Col) == keyVal) && (sheetObj.GetRowStatus(i)!="D")){
				visibleIdx += i + "|";
			}else if(sheetObj.GetRowHidden(i)==false){
				notVisibleIdx += i + "|";
			}
		}
		
		sheetObj.SetRowHidden(notVisibleIdx, 1);
		sheetObj.SetRowHidden(visibleIdx, 0);
	}
	
	function checkHsCd(sheetObj, hsCd){
		var formObj = document.form;
		formObj.f_cmd.value=SEARCH02;
		var hsAplyDt = formObj.hs_aply_dt.value;
		var param="f_cmd="+ SEARCH02 + "&hs_cd=" + hsCd + "&hs_aply_dt=" + hsAplyDt + "&hamo_tp_cd=" + "H" ;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_07GS.do", param);
    	var hsCdRslt = ComGetEtcData(sXml,"hs_cd_rslt");
    	if(hsCdRslt != "Y"){
    		if(!ComShowConfirm(ComGetMsg("BKG08370", hsCd))){
    			return false;
    		}
    	}
    	return true;
	}
	
	/* Developer Work End */
