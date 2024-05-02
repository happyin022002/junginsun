 /*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0442.js
 *@FileTitle  : B/L Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : business script for Customer Code Entry
     */

    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var deleteRowIndex=-1;
    var deleteRowIndex2=-1;
    var deleteRowIndex3=-1;
    var cntrNo=""; 
    var crnNo=""; 
    var cntr_no="";
    var crn_no="";
    var bkg_No2="";
    var cntrNoTemp=""; 
    var crnNoTemp=""; 
    var cntr_noTemp="";
    var crn_noTemp="";
    var bkg_No2Temp="";    
    var memo_imsi="";
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
				case "btn_add1":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
				break;
				case "btn_delete1":
					hideNchangeStatByD(sheetObjects[0], deleteRowIndex );
				break;
				case "btn_add2":
					doActionIBSheet(sheetObjects[2],document.form,COMMAND02);
				break;
				case "btn_delete2":
					hideNchangeStatByD2(sheetObjects[2], deleteRowIndex2, deleteRowIndex3 );
				break;							
				case "btn_retrieve":    								 
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;		
				case "pop_shipper":  
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.shpr_cnt_cd.value + "&cust_seq=" + formObject.shpr_cust_seq.value  , "cust1", 1024, 650, false);
				break;		
				case "pop_consignee":    								 
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.cnee_cnt_cd.value + "&cust_seq=" + formObject.cnee_cust_seq.value  , "cust2", 1024, 650, false);
				break;		
				case "pop_notify":    								 
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.ntfy_cnt_cd.value + "&cust_seq=" + formObject.ntfy_cust_seq.value  , "cust3", 1024, 650, false);
				break;		
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					formObject.reset();
				break;							
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;		
				case "btn_contact":
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240", "cust", 1024, 650, false);
				break;
				case "btn_close":
					ComClosePopup();
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
//            if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
//            {   
//            	document.form.frm_crn_number.value = document.form.cn_no.value;
//            	document.form.bl_no.value = document.form.frm_bl_no.value;
//    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
//		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
        if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
        {   
        	document.form.frm_crn_number.value=document.form.cn_no.value;
        	document.form.bl_no.value=document.form.frm_bl_no.value;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }    	
        initControl();
    }
    function initControl() {
    	var formObject=document.form;      		
    	//axon_event.addListenerFormat('keypress','bkg0042_keypress',formObject); 
    }    
     //function sheet1_OnLoadFinish(sheetObj) {
     //    if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
     //     {   
     //   	document.form.frm_crn_number.value = document.form.cn_no.value;
     //    	document.form.bl_no.value = document.form.frm_bl_no.value;
 	 //	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     //     }
     //}
      /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
				with(sheetObj){
					var HeadTitle="|Sel.|CNTR No.|SEAL No.|TYPE & Description|TYPE & Description|TYPE & Description|Package|Package|Packag|Weight|Weight|T1 Ind||";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"iso_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					 {Type:"Text",      Hidden:0, Width:255,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1   ,AcceptKeys:"N" },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2    ,AcceptKeys:"E"},
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pck_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1   ,AcceptKeys:"E" },
					 {Type:"Text",      Hidden:0, Width:85,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1  ,AcceptKeys:"N|[.]"},
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 ,AcceptKeys:"E"},
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"t1_doc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_call_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(135);
					SetEditable(1);
					SetColProperty("t1_doc_cd", {ComboText:"Yes|No", ComboCode:"Y|N"} );
				}
                break;
            case "sheet2":      //sheet2 init
				with(sheetObj){						
					var HeadTitle="||Seq.|QTY & Description|QTY & Description|QTY & Description|Weight|Weight|Description|HS Code||||";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:0,   SaveName:"pck_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:125,  Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0, Width:330,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_desc2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10    ,AcceptKeys:"N"},
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_call_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:330,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(200);
					SetEditable(1);
					SetShowButtonImage(2);
					SetVisible(0);
				}
                break;
            case "sheet3":      //sheet2 init
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|QTY & Description|QTY & Description|QTY & Description|Weight|Weight|Description|HS Code|||||";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );						
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 ,AcceptKeys:"E"},
					 {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:0,   SaveName:"pck_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,AcceptKeys:"E"},
					 {Type:"AutoSum",   Hidden:0, Width:125,  Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 ,AcceptKeys:"E"},
					 {Type:"Text",      Hidden:0, Width:330,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_desc2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30,AcceptKeys:"E" },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,AcceptKeys:"N"},
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_call_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"row_falg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:330,  Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(140);
					SetEditable(1);
					SetCountPosition(0);
				      
				}
            break;
        }
    }
	// handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		   case COMMAND01:               			    
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SelectCell(sheetObjects[0].RowCount(),2);
        		sheetObjects[0].SetCellValue(sheetObjects[0].RowCount(), 13 ,formObj.frm_crn_number.value,0);
        		sheetObjects[0].SetCellValue(sheetObjects[0].RowCount(), 14 ,bkg_No2,0);
        		break;
			case COMMAND02:            				
				sheetObjects[2].DataInsert(-1);
				sheetObjects[2].SelectCell(sheetObjects[2].RowCount(),1);
				break;
			case IBSEARCH:      
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				if(formObj.bl_no.value.length > 12) // Tyota B/L
				{    					
					formObj.bl_tp_cd.value=formObj.bl_no.value.substring(12);    						 
				}
				else if(formObj.bl_no.value.length == 11){
					formObj.bl_tp_cd.value=formObj.bl_no.value.substring(10);
				}
        		else{
        			formObj.bl_tp_cd.value="";
				}
//				else formObj.bl_tp_cd.value="";
				formObj.f_cmd.value=SEARCH;
				formObj.dif_chr.value="@@";
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sXml=sheetObj.GetSearchData("ESM_BKG_0442GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
		   	  	if (arrXml.length > 0) {			   	  		 
		   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		   	  	}
		   	  	if (arrXml.length > 1) {    			   	  		 
		   	  		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		   	  	}
		   	    ComEtcDataToForm(formObj, sheetObj);    			   	    
		   	    if(sheetObjects[1].RowCount()== 0)
		   	    {
		   	    	sheetObjects[1].RemoveAll();
				    sheetObjects[2].RemoveAll();
		   	    }
		   	    else
		   	    {
		   	    	sheet1_OnClick(sheetObjects[0], 1, 1);
		   	    	//sheet2_total_setup(formObj, sheetObjects[2]);
		   	    }
		   	    ComOpenWait(false);
				break;
			case IBSAVE:       
				if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
				}				
				formObj.f_cmd.value=MULTI;
			    if(sheetObjects[0].RowCount()>0)
			    {
			    	for(var i=0; i<sheetObjects[0].RowCount(); i++){
			    			sheetObjects[0].SetCellValue( i+1, 14 ,formObj.etc_bkg_no.value,0);
			    	}
			    }
			    if(sheetObjects[2].RowCount()>0)
			    {
			    	for(var i=0; i<sheetObjects[2].RowCount(); i++){
			    		if(sheetObjects[2].GetCellValue(i+1, "ibflag") == "I")
			    		{       					 
			    			if(cntr_no == "")
			    			{
			    				ComShowCodeMessage('BKG00565');
			    				return false;
			    			}
			    			//if(sheetObjects[2].CellValue( i+1, "cntr_mf_seq" )== "")
			    			//{
			    			//	ComShowCodeMessage('BKG00578');
			    			//	return false;
			    			//}
			    			sheetObjects[2].SetCellValue( i+1, 10 ,cntr_no,0);
			        		sheetObjects[2].SetCellValue( i+1, 11 ,crn_no,0);
			        		sheetObjects[2].SetCellValue( i+1, 12 ,bkg_No2,0);
			    			sheetObjects[1].SetCellValue( i+1, 14 ,sheetObjects[2].GetCellValue(i+1, 15 ),0);
			    		}
			    		if(sheetObjects[2].GetCellValue(i+1, "ibflag") == "U")
			    		{
			    			var row1=sheetObjects[2].GetCellValue(i+1,14);
			    			//sheetObjects[1].CellValue2(row1,2) = sheetObjects[2].CellValue(i+1,2);
			    			sheetObjects[1].SetCellValue(row1,3,sheetObjects[2].GetCellValue(i+1,3),0);
							sheetObjects[1].SetCellValue(row1,4,sheetObjects[2].GetCellValue(i+1,4),0);
							sheetObjects[1].SetCellValue(row1,5,sheetObjects[2].GetCellValue(i+1,5),0);
							sheetObjects[1].SetCellValue(row1,6,sheetObjects[2].GetCellValue(i+1,6),0);
							sheetObjects[1].SetCellValue(row1,7,sheetObjects[2].GetCellValue(i+1,7),0);
							sheetObjects[1].SetCellValue(row1,8,sheetObjects[2].GetCellValue(i+1,8),0);
							sheetObjects[1].SetCellValue(row1,9,sheetObjects[2].GetCellValue(i+1,9),0);
							sheetObjects[1].SetCellValue(row1,10,sheetObjects[2].GetCellValue(i+1,10),0);
							sheetObjects[1].SetCellValue(row1,11,sheetObjects[2].GetCellValue(i+1,11),0);
							sheetObjects[1].SetCellValue(row1,12,sheetObjects[2].GetCellValue(i+1,12),0);
							sheetObjects[1].SetCellValue(row1,13,sheetObjects[2].GetCellValue(i+1,13),0);
							replaceStr(sheetObjects[2].GetCellValue(i+1,15),i+1);
							sheetObjects[1].SetCellValue(row1,14,sheetObjects[2].GetCellValue(i+1,15),0);
			    		}
			    	}
			    }
			    if(ComShowConfirm(ComGetMsg("BKG00350"))){     
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
			    	var sParam="";	    						 
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
					}
//					var sParamSheet2=sheetObjects[1].GetSaveString();    sheetObjects[1] copy 가 안되 sheetObjects[2] 로 변경함
					var sParamSheet2=sheetObjects[2].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
					}	    						 
					//if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0442GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);   
					sheetObjects[1].LoadSaveData(sXml);
					ComOpenWait(false);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			    }
			    break;
			case IBINSERT:      
				break;
        }
    }
   /**
    * 
    * @param sheetObj
    * @param Row
    * @return
    */ 
   function hideNchangeStatByD(sheetObj,Row){  
	   var vIsCheck=false;
	   
	   var sRow = sheetObj.FindCheckedRow(1);
	   var arrRow = sRow.split("|");
	   
	   for ( var idx = arrRow.length - 1; idx >= 0; idx--) {
			vIsCheck=true;
			sheetObj.SetRowHidden(arrRow[idx], 1); // 2.행 숨기기
			if( sheetObj.GetRowStatus(arrRow[idx]) == "I"){
				sheetObj.RowDelete(arrRow[idx] , 0);
			} else {
				sheetObj.SetRowStatus(arrRow[idx], "D"); // 3.트랜잭션 상태 "삭제"로 만들기
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00442');	
			return;
		}
	}
   /**
    * handling checked data
    * @param sheetObj
    * @param Row
    * @param Row1
    * @return
    */
	function hideNchangeStatByD2(sheetObj,Row,Row1){ 
		var vIsCheck=false;
		var sRow = sheetObj.FindCheckedRow(1);
		   var arrRow = sRow.split("|");
		   
		   for ( var idx = arrRow.length - 1; idx >= 0; idx--) {
				vIsCheck=true;
				sheetObj.SetRowHidden(arrRow[idx], 1); // 2.행 숨기기
				if( sheetObj.GetRowStatus(arrRow[idx]) == "I"){
					sheetObj.RowDelete(arrRow[idx] , 0);
				} else {
					sheetObj.SetRowStatus(arrRow[idx], "D"); // 3.트랜잭션 상태 "삭제"로 만들기
				}
				
				var row1=sheetObj.GetCellValue(i,14);
				
				if( sheetObjects[1].GetRowStatus(row1) == "I"){
					sheetObjects[1].RowDelete(row1 , 0);
				} else {
					sheetObjects[1].SetRowStatus(row1, "D"); // 3.트랜잭션 상태 "삭제"로 만들기
				}
			}
		   
		for(var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, 1) == 1) {
				vIsCheck=true;
				sheetObjects[2].SetRowHidden(i,1);
		    	sheetObjects[2].SetRowStatus(i,"D");//2.row hide
				//alert(Row);
				var row1=sheetObjects[2].GetCellValue(i,14);
				sheetObjects[1].SetCellValue(row1,"ibflag","D");
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00442');			
			return;
		}
	}
    /**
     * 
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col) { 
    	    	if(sheetObjects[0].GetCellValue(row,1)==1) return;
		cntrNo=sheetObjects[0].GetCellValue( row, 2 );
		crnNo=sheetObjects[0].GetCellValue( row, 13 );
		bkgNo=sheetObjects[0].GetCellValue( row, 14 );
		cntr_no=sheetObjects[0].GetCellValue( row, 2 );
		crn_no=sheetObjects[0].GetCellValue( row, 13 );
		bkg_No2=sheetObjects[0].GetCellValue( row, 14 );
    	//alert("start");
    	if(sheetObjects[2].RowCount()>0)
	    {
	    	//alert("test");
    		for(var i=1; i<sheetObjects[2].RowCount()+1; i++){
    			if(sheetObjects[2].GetCellValue(i, "ibflag") == "I")
	    		{       					 
    				
//	    			alert("test I");
	    			if(cntr_noTEMP == "")
	    			{
	    				ComShowCodeMessage('BKG00565');
	    				return false;
	    			}
	    			//if(sheetObjects[2].CellValue( i, "cntr_mf_seq" )== "")
	    			//{
	    			//	ComShowCodeMessage('BKG00578');
	    			//	return false;
	    			//}
	    			sheetObjects[2].SetCellValue( i, 10 ,cntr_noTEMP,0);
	        		sheetObjects[2].SetCellValue( i, 11 ,crn_noTEMP,0);
	        		sheetObjects[2].SetCellValue( i, 12 ,bkg_No2TEMP,0);
	    			sheetObjects[2].Copy2SheetCol(sheetObjects[1],"","",i,i,-1,2,true,false,"","");
	    			sheetObjects[1].SetCellValue( i, 14 ,sheetObjects[2].GetCellValue(i, 15 ),0);
	    		}
    			if(sheetObjects[2].GetCellValue(i, "ibflag") == "U"){
//	    			alert("test U");
					var row1=sheetObjects[2].GetCellValue(i,14);
	    			//sheetObjects[1].CellValue2(row1,2) = sheetObjects[2].CellValue(i,2);
					sheetObjects[1].SetCellValue(row1,3,sheetObjects[2].GetCellValue(i,3),0);
					sheetObjects[1].SetCellValue(row1,4,sheetObjects[2].GetCellValue(i,4),0);
					sheetObjects[1].SetCellValue(row1,5,sheetObjects[2].GetCellValue(i,5),0);
					sheetObjects[1].SetCellValue(row1,6,sheetObjects[2].GetCellValue(i,6),0);
					sheetObjects[1].SetCellValue(row1,7,sheetObjects[2].GetCellValue(i,7),0);
					sheetObjects[1].SetCellValue(row1,8,sheetObjects[2].GetCellValue(i,8),0);
					sheetObjects[1].SetCellValue(row1,9,sheetObjects[2].GetCellValue(i,9),0);
					sheetObjects[1].SetCellValue(row1,10,sheetObjects[2].GetCellValue(i,10),0);
					sheetObjects[1].SetCellValue(row1,11,sheetObjects[2].GetCellValue(i,11),0);
					sheetObjects[1].SetCellValue(row1,12,sheetObjects[2].GetCellValue(i,12),0);
					sheetObjects[1].SetCellValue(row1,13,sheetObjects[2].GetCellValue(i,13),0);
					replaceStr(sheetObjects[2].GetCellValue(i,15),i)
					sheetObjects[1].SetCellValue(row1,14,sheetObjects[2].GetCellValue(i,15),0);
	    		}
	    		//if(sheetObjects[2].CellValue(i, "ibflag") == "D")
	    		//{
	    		//	var row1 = sheetObjects[2].CellValue(i,14);
	    		//	sheetObjects[1].CellValue2(row1,"ibflag") = "D";
	    		//}		    		
	    	}
	    }
    	sheetObjects[2].RemoveAll();
    	sheetObjects[0].SetCellValue( row,1 ,1,0);
    	deleteRowIndex=row;  
    	if(ComGetLenByByte(sheetObjects[0].GetCellValue( row, 2 )) != 0){            	 
        	for(var i=0; i<sheetObjects[1].RowCount(); i++){
				var cmcntrNo=sheetObjects[1].GetCellValue( i+1, 10 );
				var cmcrnNo=sheetObjects[1].GetCellValue( i+1, 11 );
				var cmbkgNo=sheetObjects[1].GetCellValue( i+1, 12 );
//        		cntr_no  		= sheetObjects[1].GetCellValue( i+1, 10 );
        		crn_no   		= sheetObjects[1].GetCellValue( i+1, 11 );
        		bkg_No2  		= sheetObjects[1].GetCellValue( i+1, 12 );  
        		if ( cntrNo == cmcntrNo && crnNo == cmcrnNo && bkgNo == cmbkgNo && sheetObjects[1].GetCellValue( i+1, "ibflag" ) != "D")
        		{
        			sheetObjects[2].DataInsert(-1);
        			sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 0 ,"R",0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 2 ,sheetObjects[1].GetCellValue( i+1, 2 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 3 ,sheetObjects[1].GetCellValue( i+1, 3 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 4 ,sheetObjects[1].GetCellValue( i+1, 4 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 5 ,sheetObjects[1].GetCellValue( i+1, 5 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 6 ,sheetObjects[1].GetCellValue( i+1, 6 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 7 ,sheetObjects[1].GetCellValue( i+1, 7 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 8 ,sheetObjects[1].GetCellValue( i+1, 8 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 9 ,sheetObjects[1].GetCellValue( i+1, 9 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 10 ,sheetObjects[1].GetCellValue( i+1, 10 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 11 ,sheetObjects[1].GetCellValue( i+1, 11 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 12 ,sheetObjects[1].GetCellValue( i+1, 12 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 13 ,sheetObjects[1].GetCellValue( i+1, 13 ),0);
					sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 15 ,sheetObjects[1].GetCellValue( i+1, 14 ),0);
        			sheetObjects[2].SetCellValue( sheetObjects[2].RowCount(), 14 ,i+1,0);
        		}        		        	
        	}
        }  
     	cntrNoTEMP=cntrNo; 
    	crnNoTEMP=crnNo; 
    	bkgNoTEMP=bkgNo;
    	cntr_noTEMP=cntr_no; 
    	crn_noTEMP=crn_no; 
    	bkg_No2TEMP=bkg_No2;              
    }
    
    function sheet1_OnChange(sheetObj, row, col, value) {
    	var evName = sheetObj.ColSaveName(col);
    	if("Chk"==evName||"pck_qty"==evName||"cntr_mf_wgt"==evName||"t1_doc_cd"==evName)return;

    	
    	sheetObj.SetCellValue(row, col,value.toUpperCase());
    }    
    
    function sheet3_OnChange(sheetObj, row, col, value) {
    	var evName = sheetObj.ColSaveName(col);
    	if("Chk"==evName||"pck_qty"==evName||"cntr_mf_wgt"==evName)return;
    	sheetObj.SetCellValue(row, col,value.toUpperCase());
    }        
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	    	 case IBSEARCH: 
			     if(ComGetLenByByte(formObj.frm_crn_number) == 0)
			     {
			    	ComShowCodeMessage('BKG00608');
					formObj.frm_crn_number.focus();
					return false;
			     }
		    	 if (ComGetLenByByte(formObj.bl_no) == 0) {
						ComShowCodeMessage('BKG00609');
						formObj.bl_no.focus();
						return false;
		    	 }   			      		     	
		    	 return true;
		    	 break;
        	 case IBSAVE:        //저장
        		 
        		 // Container 시트의 Weight Unit 체크
        		 if(sheetObjects[0].RowCount() >0){
        			 for(var i= sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++) {
        				 if((sheetObjects[0].GetCellValue( i, "cntr_wgt_ut_cd" ) != "KGS") 
        				 	&& (sheetObjects[0].GetCellValue( i, "cntr_wgt_ut_cd" ) != "LBS")
        				 	&& (sheetObjects[0].GetCellValue( i, "cntr_wgt_ut_cd" ) != "PND")
        				 	&& (sheetObjects[0].GetCellValue( i, "ibflag" ) != "D")){
        					 ComShowCodeMessage('BKG06150', 'KGS, LBS or PND');
        					 return false;
        				 }
			    	}
			     }
        		 
        		 // Cargo 시트의 Weight Unit 체크
        		 // 제일 마지막 row 는 total 을 보여주는 row 이므로 단위 체크에서 제외
        		 if(sheetObjects[2].RowCount() >0){
        			 for(var i= sheetObjects[2].HeaderRows(); i<= sheetObjects[2].LastRow(); i++) {
        				 if((i != sheetObjects[2].LastRow())
        					&& (sheetObjects[2].GetCellValue( i, "cntr_wgt_ut_cd" ) != "KGS") 
        				 	&& (sheetObjects[2].GetCellValue( i, "cntr_wgt_ut_cd" ) != "LBS")
        				 	&& (sheetObjects[2].GetCellValue( i, "cntr_wgt_ut_cd" ) != "PND")
        				 	&& (sheetObjects[2].GetCellValue( i, "ibflag" ) != "D")){
        					 ComShowCodeMessage('BKG06150', 'KGS, LBS or PND');
        					 return false;
        				 }
			    	}
			    }
			    return true;
   				break;		    	 
    	 }            
    }
     /**
      * 
      * @param SheetObj
      * @param Row
      * @param Col
      * @return
      */ 
     function sheet3_OnClick(SheetObj, Row, Col){
		deleteRowIndex2=sheetObjects[2].GetCellValue( sheetObjects[2].RowCount(), 14 );
		deleteRowIndex3=Row;        
		sheetObjects[2].SetCellValue( Row, 1 ,1,0);
		if (SheetObj.ColSaveName(Col) == "cntr_mf_desc2")
		{
			ComShowMemoPad(SheetObj,Row,Col,false,290,150,30);         		
		}         		          	 
     }
      /**
       * 
       * @param str
       * @param Row
       * @return
       */
     function replaceStr(str,Row)
     {
    	 var pck_desc="";
      	pck_desc=replaceAll(str,"'","^");           
      	sheetObjects[2].SetCellValue( Row, 15 ,pck_desc,0);
     }
     /**
      * open popup when IBSheet cell click
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */ 
	function sheet3_OnPopupClick(sheetObj, Row, Col)
	{
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;    			    	      	 
		var pck_desc=sheetObjects[2].GetCellValue(Row,'cntr_mf_desc');
		pck_desc=replaceAll(pck_desc,"\r\n","<br>");
		var sUrl="/opuscntr/ESM_BKG_1016.do?pgmNo=ESM_BKG_1016&pck_desc="+pck_desc;     		  	     		 
		var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_1016", 300, 300, false);    	    
		if (rtnVal != null){    		  				 
	  		sheetObj.SetCellValue(Row, 'cntr_mf_desc',rtnVal.nm,0);
	  		if(sheetObjects[2].GetCellValue( sheetObjects[2].RowCount(), 14 ) > 0)
	  			sheetObjects[1].SetCellValue(sheetObjects[2].GetCellValue( sheetObjects[2].RowCount(), 14 ), 'cntr_mf_desc',rtnVal.nm,0);
		}
	}
    /**
    * replace value
    * @param strTemp 
    * @param strValue1 
    * @param strValue2
    * @return
    */
    function replaceAll(strTemp,strValue1,strValue2)
    {
         while(1){
        	 if(strTemp.indexOf(strValue1) != -1)
        		 strTemp=strTemp.replace(strValue1,strValue2);
        	 else
        		 break;
         }
         return strTemp;
    }
    /**
     * handler Enter event
     * @return
     */
    function obj_ComKeyEnter() {
     	if( event.keyCode != 13){return;}
    	var formObject=document.form;
     	var srcName=ComGetEvent("name");
     	
     	if(srcName != "fax_no" && srcName != "cust_eml" 
     		&& srcName != "shpr_addr1" && srcName != "cnee_addr1" && srcName != "ntfy_addr1"
     		&& srcName != "shpr_addr2" && srcName != "cnee_addr2" && srcName != "ntfy_addr2" && srcName != "") {         		 
     		ComKeyEnter();
     	}         	         
    }
     /**
 	 *  setting MemoPad
      * @param {ibsheet} 	sheetObj   
      * @param {int} 		row 
      * @param {int} 		col 
      * * @param {int} 		col2
      * @param {bool} 		bReadOnly
      * @param {int}    		iWidth	
      * @param {int}    		iHeight	
 	 */
     function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax,col2) {
 		try{
 			//set param default value			
 			if (row == undefined 		|| row == null) 		
 				row=sheetObj.GetSelectRow();
 			if (col == undefined 		|| col == null) 		
 				col=sheetObj.GetSelectCol();
 			if (bReadOnly == undefined  || bReadOnly == null) 	
 				bReadOnly=false;
 			if (iWidth == undefined 	|| iWidth == null) 		
 				iWidth=200; 
 			if (iHeight == undefined 	|| iHeight == null) 	
 				iHeight=200; 
 			if (iMax == undefined 	    || iMax == null) 	    
 				iMax=4000; 
 			//check  IBSheet info validation for Memo 
 			if (sheetObj.GetCellEditable(row,col)) {
 				return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
 			}
 			//get IBSheet info for Memo
 			if (!ComIsNumber(col)) 
 				col=sheetObj.SaveNameCol(col);
 	        memoSheet=sheetObj;
 	        memoRow=row;
 	        memoCol=col;
 			//make MemoPad
 	        momo_imsi=sheetObj.GetCellText(row,col);
 			if (!initMemoPad2(iMax)) return;
 	        //get location for Momo div (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop use in ComCalendar.js)
 	        var iLeft=AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col2) + 2;
 	        var iTop=AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
 	        if (sheetObj.GetCountPosition()!= 0)  iTop += 16;
             //change location in case of current page can't scrolling
			if (top.document != document && window.frameElement.scrolling=="no") {
				//height over
				if (iTop + iHeight  > document.body.clientHeight) {
					iBottom=iTop + sheetObj.GetRowHeight(row);
					if (iBottom > document.body.clientHeight) iBottom=document.body.clientHeight;  
					iTop=iBottom-iHeight;
					if (iTop <0) iTop=0
				}
				//width over
			    if (iLeft + iWidth  > document.body.clientWidth)   {
			    	iLeft=document.body.clientWidth - iWidth;    
			     	if (iLeft<0) iLeft=0;
			    }
			}
 	        var _divMemo=document.getElementById(MEMO_DIV_NAME);
 	        var _frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
 			_frameDoc.getElementById("btn_apply").style.display=(bReadOnly)?"none":"inline";
 	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor=bReadOnly?"#E8E7EC":"";
 	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily=sheetObj.GetSheetFontName;
 	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize=11;
 			_frameDoc.getElementById(MEMO_TEXT_NAME).SetSheetHeight(iHeight-25);
 	        _frameDoc.getElementById(MEMO_TEXT_NAME).value=sheetObj.GetCellText(row,col);
 	        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly=bReadOnly;
 			_divMemo.style.width=iWidth;
 			_divMemo.SetSheetHeight(iHeight);
 	        _divMemo.style.top=iTop;
 	        _divMemo.style.left=iLeft;
 	        _divMemo.style.visibility="visible";
 	        _divMemo.focus();	
 	        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
         } catch(err) { ComFuncErrMsg(err.message); }
 	}
 	/**
      * make iframe in DIV for MemoPad and Textarea and Button create in iFrame
      */
     function initMemoPad2(iMax) {
    		try {
    			// 메모용 Div가 없으면 생성한다.
    			if (document.getElementById(MEMO_DIV_NAME) != null)
    				return true;

    			// 메모용 Div 만들기
    	        var _divMemo=document.createElement("div");
    	        _divMemo.id=MEMO_DIV_NAME;
    	        _divMemo.style.position = "absolute";
    	        _divMemo.style.overflow = "hidden";
    	        _divMemo.style.width = "200px";
    	        _divMemo.style.height = "200px";
    	        _divMemo.style.zIndex = "1000";
    	        _divMemo.style.visibility="hidden";
    	        
    	        document.body.appendChild(_divMemo);

    	        //var _divMemo = document
    			//		.createElement("<div id='"
    			//				+ MEMO_DIV_NAME
    			//				+ "' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
    			//document.body.insertBefore(_divMemo);

    			// 메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
    	        _divMemo.innerHTML = "<iframe id='"+ MEMO_FRAME_NAME +"' style='width:100%;height:100%'></iframe>";
    	        var _frameMemo = document.getElementById(MEMO_FRAME_NAME);
    			//var _frameMemo = document
    			//		.createElement("<IFRAME id='"
    			//				+ MEMO_FRAME_NAME
    			//				+ "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%' />");
    			//_divMemo.appendChild(_frameMemo);

    			var _FrameDoc = _frameMemo.contentWindow.document;

    			// iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
    	        var _FrameDiv=_FrameDoc.createElement("div");
    	        _FrameDiv.style.position = "absolute";
    	        _FrameDiv.style.overflow = "hidden";
    	        _FrameDiv.style.backgroundColor = "#E6EFF6";
    	        _FrameDiv.style.width = "100%";
    	        _FrameDiv.style.height = "100%";
    	        if (_FrameDoc.body){
    	            _FrameDoc.body.appendChild(_FrameDiv);
    	        }else {
    	            _FrameDoc.appendChild(_FrameDiv);
    	        }
    	        
    			//var _FrameDiv = _FrameDoc
    			//		.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
    			//_FrameDoc.appendChild(_FrameDiv);

    			// Div안에 Textarea 만들기
    	        //var sHtml = "<link href=\"style/css/theme_default.css\" rel=\"stylesheet\" type=\"text/css\">";
    	        var sHtml = "<textarea id='"+ MEMO_TEXT_NAME+ "' onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%' rows='10' cols='6'></textarea>" 
    	                  + "\n<button id='btn_apply' class='btn_etc' onclick='parent.setMemoValue2(document.getElementById(\""+ MEMO_TEXT_NAME + "\").value," + iMax + ");'>Apply</button>"
    					  + "\n<button id='btn_close' class='btn_etc' onclick='parent.ComHideMemoPad(true)'>Close</button>"
    					  + "</body>";
    	        _FrameDiv.innerHTML=sHtml;

    			//making Textarea in DIV
//    			var _area=_FrameDoc.createElement("textarea");
//    			_area.setAttribute('id',MEMO_TEXT_NAME);
//    			_area.setAttribute('style','border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%');
//    			_FrameDiv.appendChild(_area);
    	        
    	        
    	        //var _area = _FrameDoc
    			//		.createElement("<textarea id='"
    			//				+ MEMO_TEXT_NAME
    			//				+ "' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
    			//_FrameDiv.appendChild(_area);

    	        /*
    			// Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
    			var _centerTag = _FrameDoc.createElement("<center>");
    			_FrameDiv.appendChild(_centerTag);

    			// Apply 버튼 만들기
    			var _button1 = _FrameDoc
    					.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue2(document.getElementById(\""
    							+ MEMO_TEXT_NAME + "\").value," + iMax + ");'/>");
    			_button1.innerHTML = "Apply";
    			_centerTag.appendChild(_button1);

    			// Close 버튼 만들기
    			var _button2 = _FrameDoc
    					.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
    			_button2.innerHTML = "Close";
    			_centerTag.appendChild(_button2);
    			*/

    			// 메모용 iFrame 자동 닫기 처리
    			if (document.onmouseup == null
    					|| document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
    				// Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
    				window.popupMemoOldEventListener = document.onmouseup;
    				if (window.popupMemoOldEventListener != null) {
    					// alert("CoObject \n" +
    					// window.popupMemoOldEventListener.toString());
    					// 기존에 document.onmouseup에 정의된 함수가 있는 경우
    					document.onmouseup = new Function(
    							"window.popupMemoOldEventListener(); ComHideMemoPad();");
    				} else {
    					// 기존에 document.onmouseup에 정의된 함수가 없는 경우
    					document.onmouseup = ComHideMemoPad;
    				}

    				/*
    				// ActiveX에 포커스가 갔을때 메모DiV 닫기
    				var objs = document.getElementsByTagName("OBJECT")
    				window.popupMemoOldObjEventListener = new Array(objs.length);
    				for ( var i = 0; i < objs.length; i++) {
    					window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
    					if (window.popupMemoOldObjEventListener[i] != null) {
    						// 기존에 document.onmouseup에 정의된 함수가 있는 경우
    						objs[i].onfocus = new Function(
    								"window.popupMemoOldObjEventListener[" + i
    										+ "](); ComHideMemoPad();");
    					} else {
    						// 기존에 document.onmouseup에 정의된 함수가 없는 경우
    						objs[i].onfocus = ComHideMemoPad;
    					}
    				}*/
    			}
    		} catch (err) {
    			ComFuncErrMsg(err.message);
    			return false;
    		}
    		return true;
    	}
 	/**
     * call when Apply button click in MemoPad , set MemoPad value to cell of IBSheet. <br>
     */
	function setMemoValue2(sValue,iMax) {
		try {
			//alert(sValue); 
			if(sValue.length > iMax){    				
				ComShowMessage("characters long");
				//document.getElementById(MEMO_FRAME_NAME).focus();
				return;
			}else{
				//alert("test1");
				if (memoSheet == null) 
					return; 
				//alert(momo_imsi);
				//if(momo_imsi == "")
				//{
					//alert("test3");
				memoSheet.SetCellValue(memoRow, "cntr_mf_desc2",sValue,0);
				//}
					///alert(memoCol);
				memoSheet.SetCellValue(memoRow, memoCol,sValue,0);
				//alert(memoCol);
				ComHideMemoPad(true);
			}
        } catch(err) { ComFuncErrMsg(err.message); }
	}
    /**
     * @param formObj
     * @param sheetObj
     * @return
     */ 
     function sheet2_total_setup(formObj, sheetObj){
    	 var pck_qty=0;
    	 var cntr_mf_wgt=0;
    	 for(var i=1; i <= sheetObjects[2].rowCount; i++){        		 
    		 pck_qty=pck_qty + sheetObjects[2].GetCellValue(i,"pck_qty");
    		 cntr_mf_wgt=cntr_mf_wgt + sheetObjects[2].GetCellValue(i,"cntr_mf_wgt");
    	 }
        document.all.t2simple.innerHTML=pck_qty;
	   	document.all.t3simple.innerHTML=cntr_mf_wgt;        	 
     }
     /**
      * handling search conditions input 
      */
     function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=ComGetEvent("maxlength");
		var srcValue=ComGetEvent("value");
		if (( srcName == "frm_crn_number" 
			|| srcName == "vvd_number"
			|| srcName == "bl_no")
			&& ComChkLen(srcValue, srcMaxLength) == "2") 
		{
			ComSetNextFocus();
		}
     }
      function bkg0042_keypress(){
      	var srcName=ComGetEvent("name");
      	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
  	    switch(ComGetEvent("dataformat")){
  	    case "engup":
  			ComKeyOnlyAlphabet('upper');
        	break;
  	    case "engupnum":
  	    	ComKeyOnlyAlphabet('uppernum');
  	    	break;
  	    case "engupspace": 
  	    	if(event.keyCode != 32) {
  	    		ComKeyOnlyAlphabet('uppernum');
  	    	}	        
  	    case "custname":
  	    	ComKeyOnlyAlphabet('uppernum','32');
  	    	break;
  	    case "engdnnum":
  	    	ComKeyOnlyAlphabet('lowernum');
  	    	break;
  	    case "int":
  	    	ComKeyOnlyNumber(ComGetEvent());
  	    	break;	            
  	    case "address":
  	    	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
  	    	break;
  	    case "num":
  	    case "zipcode":
  	    	ComKeyOnlyAlphabet('uppernum','45|32');
  	    	break;	            
        case "etc":
        	if(keyValue >= 97 && keyValue <= 122) {
        		event.keyCode=keyValue + 65 - 97;
        	}
      		break;	        	            
  	    default:
  	    }
  	}         