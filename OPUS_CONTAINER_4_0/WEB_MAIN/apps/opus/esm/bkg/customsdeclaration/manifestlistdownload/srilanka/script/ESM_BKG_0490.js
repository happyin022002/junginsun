/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0490.js
*@FileTitle  : Manifest Transmit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;

	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
        /*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "btn_ViewResponse":
					var sUrl="/opuscntr/ESM_BKG_0492.do?pgmNo=ESM_BKG_0492&sr_sts_cd="+formObject.sr_sts_cd.value+"&rgst_dt="+formObject.rgst_dt.value
					+"&rjct_dt="+formObject.rjct_dt.value+"&vsl_auth_no="+formObject.vsl_auth_no.value+"&sr_sts_desc="+escape(formObject.sr_sts_desc.value)
					+"&sr_cmt_desc="+escape(formObject.sr_cmt_desc.value)+"&decl_bl_qty="+formObject.decl_bl_qty.value;
 					ComOpenWindowCenter(sUrl, "ESM_BKG_0492", 450, 400, false);
				break;
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE); 		
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);            
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
    		tabObjects[k].SetSelectedIndex(0);
        }
        axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);	
        //axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form'); 	
		ComBtnDisable("btn_Transmit");
    }
    
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
    	var sheetID=sheetObj.id;
        var cnt=0;
        switch(sheetID) {
        	case "t1sheet1":      // t1sheet1 init
	        	with(sheetObj){
	        		var HeadTitle1="|Seq.|B/L No.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking||||||||||";
	        		var HeadTitle2="|Seq.|B/L No.|POL|POD|DEL|Package|Package|Weight|Weight|Measure|Measure||||||||||";
	        		var headCount=ComCountHeadTitle(HeadTitle1);
	        		(headCount, 0, 0, true);
	
	        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        		var headers = [ { Text:HeadTitle1, Align:"Center"},
	        		                { Text:HeadTitle2, Align:"Center"} ];
	        		InitHeaders(headers, info);
	
	        		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	        		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"meas_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vvd_number",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vsl_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"carrier_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"customs_office_code",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"reg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"call_port",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"auth_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          
	        		InitColumns(cols);	
	        		SetEditable(0);
	        		SetSheetHeight(400);
	        	}
                break;
            case "t2sheet1":      // t2sheet1 init
                with(sheetObj){
            		var HeadTitle1="|Seq.|B/L No.|Container|Container|Container|Container|Container|Container|Container|Container|Container";
            		var HeadTitle2="|Seq.|B/L No.|Container No.|CNTR TP|SEAL No.|Package|Package|Weight|Weight|Measure|Measure";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Int",       Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);
            		SetEditable(0);
            		SetSheetHeight(260);
            	}
                break;
        }
    }
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve						
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			return false;
	 			}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.total_cntr.value="";
				formObj.total_bl.value="";
				formObj.f_cmd.value=SEARCH;
				formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
				formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
				formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);
				formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);
				if(beforetab == 0)
					formObj.pgNo.value="esm0490";
				else formObj.pgNo.value="esm0490_1";
				sXml=sheetObj.GetSearchData("ESM_BKG_0490GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {			   	  		 
		   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		   	  	    //ComEtcDataToForm(formObj, sheetObjects[0]);
		   	  	}
		   	  	if (arrXml.length > 0) {			   	  		 
		   	  	    sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		   	  	}
		   	    ComEtcDataToForm(formObj, sheetObj);
		   	    if ( sheetObjects[0].RowCount()> 0 || sheetObjects[1].RowCount()> 0 )
		   	    {
		   	    	ComBtnEnable("btn_Transmit");
		   	    } else {
		   	    	ComBtnDisable("btn_Transmit");
		   	    }
		   	    ComOpenWait(false);
				break;
        	case IBSAVE:  
			    formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true); 
				for (var i=2; i <= sheetObjects[0].RowCount()+1; i++)
				{   
					sheetObjects[0].SetRowStatus(i,"I");
					sheetObjects[0].SetCellValue(i, "vsl_cd",formObj.vvd_number.value.substring(0,4),0);
					sheetObjects[0].SetCellValue(i, "skd_voy_no",formObj.vvd_number.value.substring(4,8),0);
					sheetObjects[0].SetCellValue(i, "skd_dir_cd",formObj.vvd_number.value.substring(8),0);
					sheetObjects[0].SetCellValue(i, "vvd_number",formObj.vvd_number.value,0);
					sheetObjects[0].SetCellValue(i, "vsl_nm",formObj.vsl_nm.value,0);
					sheetObjects[0].SetCellValue(i, "carrier_no",formObj.carrier_no.value,0);
					sheetObjects[0].SetCellValue(i, "customs_office_code",formObj.customs_office_code.value,0);
					sheetObjects[0].SetCellValue(i, "reg_no",formObj.reg_no.value,0);
					sheetObjects[0].SetCellValue(i, "call_port",formObj.call_port.value,0);
					sheetObjects[0].SetCellValue(i, "auth_no",formObj.auth_no.value,0);
				} 	
				var sParam="";
    			var sParamSheet2=sheetObjects[0].GetSaveString();
    			if (sParamSheet2 != "") {    	    				 
    				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
    			}		
    			sParam += "&" + FormQueryString(formObj);    					 
    			var sXml=sheetObj.GetSaveData("ESM_BKG_0490GS.do", sParam);
    			sheetObjects[0].LoadSaveData(sXml);
    			sXml=ComDeleteMsg(sXml); 
    			ComOpenWait(false); 
    			break;		
        }
    }
    
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    
    /**
     * Tab option
     * setting tab list
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "B/L Info." , "");
                    InsertItem( "CNTR Info." , "");
                }
                break;
         }
    }
    
    /**
     * event in case of clicking tab
     * activating selected tab
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
			case IBSEARCH: // retrieve
			if (formObj.vvd_number.value == "" ) 
			{
				ComShowCodeMessage('BKG00208');
				formObj.vvd_number.focus();
				return false;
			}  
			if ( formObj.call_port.value == "" ) 
			{
				ComShowCodeMessage('BKG00207');
				formObj.call_port.focus();
				return false;
			}  
			if (formObj.vvd_number.value.length > 0 && formObj.vvd_number.value.length < 9) {
				ComShowCodeMessage('BKG00208');
				formObj.vvd_number.focus();
				return false;
			}
			if (formObj.pod_cd.value.length > 0 && formObj.pod_cd.value.length < 5) {
				ComShowCodeMessage('BKG00208');
				formObj.pod_cd.focus();
				return false;
			}
			if (formObj.call_port.value.length > 0 && formObj.call_port.value.length < 5) {
				ComShowCodeMessage('BKG00207');
				formObj.call_port.focus();
				return false;
			}
			return true;  
			break;			 
    	 }
    }
    
     /**
      * Enter event
      * @return
      */
    function obj_ComKeyEnter() {
      	var formObject=document.form;
      	var srcName=ComGetEvent("name");
      	if(srcName != "") {         		 
      		ComKeyEnter();
      	}         	         
    }
    
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			//SumText(0, "Seq") = "";
			//SumText(0, "BLNo") = "B/L Total";
			//CellValue(LastRow, "POL") = 49;
		}
	}
	
	/**
	* control keyboard input at onkeyUp of HTML Control
	**/
	function obj_KeyUp() {
//	    var formObject=document.form;        
//	    var srcName=ComGetEvent("name");
//	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	    var srcValue=window.event.srcElement.getAttribute("value");
//	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
//	    	ComSetNextFocus();        	    		
//	    }
	}
	
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 			SetSumText(0, "Seq","");
 			SetSumText(0, "BLNo","CNTR Total");
			SetCellValue(LastRow(), "ContainNo",58);
		}
	}
