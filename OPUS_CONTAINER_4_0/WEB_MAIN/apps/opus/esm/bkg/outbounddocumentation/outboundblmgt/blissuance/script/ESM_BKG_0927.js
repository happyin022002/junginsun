/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0927.js
*@FileTitle  : B/L Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
*/

/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /* Global Variables */
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var queryStr="";
	var rControl=true; // RD Control YN
	var iterator="|$$|";
	var IBSENDFAX="IBSENDFAX";
	var IBSENDEMAIL="IBSENDEMAIL";
	var emailYn=true;
	var faxYn=true;
	var riderYn="N";
	var houseYn="N";
	var oblIssFlg="N";
	var por_cd;
//	var is_first="Y";
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
    function processButtonClick(){
		 var sheetObject=sheetObjects[0];
         var formObject= document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		var Rdviewer_face = rdframe1.viewer;
    		var Rdviewer_rider = rdframe2.viewer;
    		var Rdviewer_houseD = rdframe3.viewer;
    		var Rdviewer_houseS = rdframe4.viewer;
            switch(srcName) {
            	case "btn_Retrieve": // btn_Retrieve
					Retrive(sheetObject);
                	break;
            	case "btn_New": // btn_New
					pageReset(formObject);
                	break;
            	case "btn_Print": // btn_Print
					RD_Print();
                	break;
            	case "btn_BlPrint": // btn_BlPrint
					//alert("UI_BKG_0743");
					Pop_ESM_BKG_0743(formObject);
                	break;
				case "btn_Close": // btn_Close
					ComClosePopup(); 
                	break;
            	case "btn_Fax": // btn_Fax
					doActionIBSheet(sheetObject,formObject,IBSENDFAX);
                	break;
            	case "btn_Email": // btn_Email
					doActionIBSheet(sheetObject,formObject,IBSENDEMAIL);
                	break;
				//---------------- RD Control Button Start ----------------//
            	case "btn_RD_ZoomOut": // btn_RD_ZoomOut
					RDControl(srcName);
                	break;
            	case "btn_RD_ZoomIn": // btn_RD_ZoomIn
					RDControl(srcName);
                	break;
            	case "btn_RD_FirstPage": // btn_RD_FirstPage
					RDControl(srcName);
                	break;
            	case "btn_RD_PreviousPage": // btn_RD_PreviousPage
					RDControl(srcName);
                	break;
            	case "btn_RD_NextPage": // btn_RD_NextPage
					RDControl(srcName);
                	break;
            	case "btn_RD_LastPage": // btn_RD_LastPage
					RDControl(srcName);
                	break;
            	case "rdo_form_level":
            		formObject.form_level.value=window.event.srcElement.value;
            		Retrive(sheetObject);
            		break;
            	case "btn_Close":
            		ComClosePopup();
            		break;
				//---------------- RD Control Button End ----------------//
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
				alert(e.discription);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    function RDControl(srcName) {
    	if (rControl) {
    		var formObject = document.form;
    		var tabIndex = tabObjects[0].GetSelectedIndex();
    		var face_obj = rdframe1.viewer; // Face RD
    		var rider_obj = rdframe2.viewer; // Rider RD
    		switch (tabObjects[0].GetSelectedIndex()) {
    			case 0:
    				Rdviewer = rdframe1.viewer;
    				break;
    			case 1:
    				Rdviewer = rdframe2.viewer;
    				break;
    			case 2:
    				Rdviewer = rdframe3.viewer;
    				break;
    			case 3:
    				Rdviewer = rdframe4.viewer;
    				break;
    		}
    		switch (srcName) {
    			case "btn_RD_ZoomOut": // btn_RD_ZoomOut
    				if (tabIndex == 2 || tabIndex == 3) {
    					Rdviewer.zoomIn();
    				} else {
    					face_obj.zoomIn();
    					if(tabObjects[0].GetTabDisable(1)==0){
    						rider_obj.zoomIn();
    					}
    				}
    				break;
    			case "btn_RD_ZoomIn": // btn_RD_ZoomIn
    				// alert("ZoomOut_pre : [" + Rdviewer.ZoomRatio + "]");
    				if (tabIndex == 2 || tabIndex == 3) {
    					Rdviewer.zoomOut();
    				} else {
    					face_obj.zoomOut();
    					if(tabObjects[0].GetTabDisable(1)==0){
    						rider_obj.zoomOut();
    					}
    				}
    				break;
    			case "btn_RD_FirstPage": // btn_RD_FirstPage
    				Rdviewer.moveFirstPage();
    				break;
    			case "btn_RD_PreviousPage": // btn_RD_PreviousPage
    				Rdviewer.prevPage();
    				break;
    			case "btn_RD_NextPage": // btn_RD_NextPage
    				Rdviewer.nextPage();
    				break;
    			case "btn_RD_LastPage": // btn_RD_LastPage
    				Rdviewer.moveLastPage();
    				break;
    		}
    	} else {
    		return;
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
    	 for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			//sheetObjects[i].ExtendLastCol = false;
		}
		init_Control();
		tabObjects[0].SetTabDisable(0 , true);
		
		// checkHtml5RDPass
		var formObject = document.form;
		
		var level_val = "";
		if(formObject.bl_prn_chg_tp_cd.value=="1" 
			|| formObject.bl_prn_chg_tp_cd.value=="5" 
			|| formObject.bl_prn_chg_tp_cd.value=="4"
		    || formObject.bl_prn_chg_tp_cd.value=="6" 
		    || formObject.bl_prn_chg_tp_cd.value=="3"){
			level_val = formObject.bl_prn_chg_tp_cd.value;
		}else{
			level_val = "1";
		}		
		formObject.form_level.value=level_val;
		Retrive(sheetObjects[0]);
    }
    
	function init_Control() {
//		axon_event.addListenerForm  ('blur', 'obj_blur',  form);  //OnBeforeDeactivate(blur) event
//	    axon_event.addListenerFormat('focus',   'obj_focus',    form);    //OnBeforeActivate event
//	    axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);     //onkeypress event
		axon_event.addListenerForm('keydown',         'obj_keydown', 	form);
		axon_event.addListenerForm('click',         'obj_click', 	form);
	}
	
	function obj_keydown(){
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if (event.keyCode == 13){ // Enter Key
			//
			switch(srcName){
				case "bkg_no": // bkg_no
					Retrive(sheetObjects[0]);
					break;
				case "bl_no": // bl_no
					Retrive(sheetObjects[0]);
					break;
				case "RD_Zoom": // RD_Zoom
					RDControl(srcName);
					break;
			}
		}
	}
	function obj_click() {
		var formObject=document.form;
		var obj=ComGetEvent("name");
		switch(obj){
			case "bl_tp_cd": // bl_tp_cd
				formObject.eventSrc.value="bl_tp_cd";
				formObject.bl_tp_cd_param.value=ComGetEvent("value");
				Retrive(sheetObjects[0]);
				break;
			case "hiddenData": // hiddenData
				//alert(obj.name + "\n\n" + obj.value);
				Retrive(sheetObjects[0]);
				break;
		}
	}
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "ym":
//	        case "hms":
//	        case "hm":
//	        case "jumin":
//	        case "saupja":
//	            break;
//	        case "int":
//				//only numbers
//				ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//				//numbers +"."
//				ComKeyOnlyNumber(obj, ".");
//	            break;
//	        case "eng":
//				//only alphabet
//				ComKeyOnlyAlphabet();
//				break;
//	        case "engup":
//				//numbers + upper case
//				var KeyCodes="32";
//				ComKeyOnlyAlphabet('uppernum', KeyCodes)
//	            break;
//	        case "engdn":
//	            //lower case
//				ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engupnum":
//	            //lower case
//	        	ComKeyOnlyAlphabet("uppernum");
//	            break;	            
//	    }
//	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
            case "sheet_search":      //sheet_search
			    with(sheetObj){
				      var HeadTitle1="ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"syscd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"title",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplparam",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcvinfo",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndnm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndeml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"filekey",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcveml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"contents",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrdpdf",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"itr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(300);
			     }
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
   	 * Setting IBTab Object Initial.
   	 * Tab ID is tab1,tab2,...
   	 * InitTab() function is called before the loadPage() function call from setupPage() function.
   	 */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem("B/L Face" , "");
					InsertItem("Rider" , "");
					InsertItem("NVO H/B (D)" , "");
					InsertItem("NVO HB (S)" , "");
                }
             break;
         }
    }
    /**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */ 
    function tab1_OnChange(tabObj , nItem)
    {
    	formObject = document.form;
    	var objs = document.all.item("tabLayer");
    	switch (nItem) {
    	case 0:
    		 $("#rdframe1").removeClass("hiddenFrame").siblings("iframe").addClass("hiddenFrame");
    		break;
    	case 1:
    		 $("#rdframe2").removeClass("hiddenFrame").siblings("iframe").addClass("hiddenFrame");
    		break;
    	case 2:
    		 $("#rdframe3").removeClass("hiddenFrame").siblings("iframe").addClass("hiddenFrame");
    		break;
    	case 3:
    		 $("#rdframe4").removeClass("hiddenFrame").siblings("iframe").addClass("hiddenFrame");
    		break;
    	}
    }
	///* Processing Sheet */
    function doActionIBSheet(sheetObj,formObject,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:      //retrieving
				formObject.f_cmd.value=SEARCH;
          		var sXml=sheetObj.GetSearchData("ESM_BKG_0927GS.do", FormQueryString(formObject));
				loadSet(formObject, sXml);
                break;
			case IBSENDEMAIL:        // Email
				paramSet(sheetObj, formObject, IBSENDEMAIL);
				break;
			case IBSENDFAX:        // Fax
				paramSet(sheetObj, formObject, IBSENDFAX);
				break;
        }
    }
    
	function paramSet(sheetObj, formObject, strGubun) {
		var Rdviewer_face = rdframe1.viewer;
		var Rdviewer_rider = rdframe2.viewer;
		var Rdviewer_houseD = rdframe3.viewer;
		var Rdviewer_houseS = rdframe4.viewer;
		var bl_tp_cd=ComGetObjValue(formObject.bl_tp_cd);
		var cntChk=0;
		var rdParam="";
		var strPath="";
		var strPdf="";
		var bkg_no=rControl == true ? formObject.bkg_no.value : "";
		var form_dataOnly="N";
		var hiddenData="";
		if ( formObject.hiddenData.checked == true ) {
			hiddenData=formObject.hiddenData.value;
		}
		// calling first popup - save in first_bkg_no / first_bl_no
		var form_remark=formObject.form_remark.value;
		if ( formObject.first_bkg_no.value != "" ) {
			if ( formObject.first_bkg_no.value != formObject.bkg_no.value ) {
				form_remark="";
			}
		} else {
			if ( formObject.first_bl_no.value != "" && formObject.first_bl_no.value != formObject.bl_no.value ) {
				form_remark="";
			}
		}
		form_remark=ComReplaceStr(form_remark, "\r\n", "(##)");
		form_remark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
		// Type : "" - Original / "W" - WayBill / "D" - Draft
		// Face
		if ( formObject.bl_face.checked ) {
			// Face
			switch(bl_tp_cd) {
				case "": // Original
					formObject.form_type.value="2";
					rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] /rp [] /riprnmargin";
					strPath=0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
					strPdf="Original.pdf";
					break;
				case "W": // WayBill
					formObject.form_type.value="5";
					rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] /rp [] /riprnmargin";
					strPath=0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
					strPdf="WayBill.pdf";
					break;
				case "D": // Draft
					formObject.form_type.value="7";
					rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] /rp [] /riprnmargin";
					strPath=0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
					strPdf="Draft.pdf";
					break;
			}
			cntChk++; // Face
		}
		
		// Rider
		if ( riderYn == "Y" && formObject.bl_rider.checked == true ) {
			cntChk++;
		}
		// HouseD
		if ( houseYn == "Y" && formObject.bl_houseD.checked == true ) {
			rdParam += iterator + "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin";
			strPath += iterator + "ESM_BKG_0109_HBL_D.mrd";
			strPdf += iterator + "HouseD.pdf";
			cntChk++;
		}
		// HouseS
		if ( houseYn == "Y" && formObject.bl_houseS.checked == true ) {
			rdParam += iterator + "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin";
			strPath += iterator + "ESM_BKG_0109_HBL_S.mrd";
			strPdf += iterator + "HouseS.pdf";
			cntChk++;
		}
		if ( cntChk == 0 ) {
			ComShowCodeMessage("COM12113", "Print List");
			return;
		}
		var sheetObject=sheetObjects[0];
		if ( strGubun == IBSENDFAX ) {
			// Fax
			formObject.f_cmd.value=SEARCH02;
			// Sheet
			var Row=sheetObject.DataInsert();
			sheetObject.SetCellValue(Row, "bkg_no",formObject.bkg_no.value,0);
			sheetObject.SetCellValue(Row, "bl_no",formObject.bl_no.value,0);
			sheetObject.SetCellValue(Row, "syscd","BKG",0);
			sheetObject.SetCellValue(Row, "tmplmrd",strPath,0);
			sheetObject.SetCellValue(Row, "batchflg","N",0);
			sheetObject.SetCellValue(Row, "tmplparam",rdParam,0);
			sheetObject.SetCellValue(Row, "rcvinfo",formObject.fax_no.value,0);
			sheetObject.SetCellValue(Row, "itr","|$$|",0);
		}
		else if ( strGubun == IBSENDEMAIL ) {
			// Email
			formObject.f_cmd.value=SEARCH01;
			// Sheet
			var Row=sheetObject.DataInsert();
			sheetObject.SetCellValue(Row, "bkg_no",formObject.bkg_no.value,0);
			sheetObject.SetCellValue(Row, "bl_no",formObject.bl_no.value,0);
			sheetObject.SetCellValue(Row, "syscd","BKG",0);
			sheetObject.SetCellValue(Row, "tmplmrd",strPath,0);
			sheetObject.SetCellValue(Row, "batchflg","N",0);
			sheetObject.SetCellValue(Row, "tmplparam",rdParam,0);
			sheetObject.SetCellValue(Row, "title","B/L Preview",0);// title
			sheetObject.SetCellValue(Row, "contents","B/L Preview Contents",0);// email contents
			sheetObject.SetCellValue(Row, "rcveml",formObject.email.value,0);// email address
			sheetObject.SetCellValue(Row, "tmplmrdpdf",strPdf,0);// converting pdf name
			sheetObject.SetCellValue(Row, "itr","|$$|",0);
		}
		open0221(strGubun);
	}
	function open0221(fax_email) {
		//open popup 0221
		var width=360;
		var height=170;
		var left=(screen.width-width)/2;
		var top=(screen.height-height)/2;
		ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		//send popup
		var formObject=document.form;
		var formObject3=document.form3;
		formObject3.elements["pop_mode"   ].value="1";
		formObject3.elements["display"    ].value="1,0,1,1,1,1,1";
		formObject3.elements["func"       ].value="getCOM_Fax_Email_POPUP";
		formObject3.elements["row"        ].value="0";
		formObject3.elements["col"        ].value="0";
		formObject3.elements["sheetIdx"   ].value="0";
		formObject3.elements["bkg_no"     ].value=formObject.bkg_no.value;
		formObject3.elements["send_hidden"].value="N";
		formObject3.elements["ok_hidden"  ].value="Y";
		formObject3.elements["fax_no"     ].value=formObject.fax_no.value;
		formObject3.elements["email"      ].value=formObject.email.value;
		formObject3.elements["ui_id"      ].value="ESM_BKG_0927";
		formObject3.elements["fax_email"  ].value=fax_email;  //fax/email
		formObject3.elements["ntc_knd_cd" ].value="W"==ComGetObjValue(formObject.bl_tp_cd) ? "WB" : ("D"==ComGetObjValue(formObject.bl_tp_cd) ? "BL" : "NN");
		formObject3.elements["form_level" ].value=formObject.form_level.value;
		//form type setting 2015.10.06. kim-taekyun
		if(ComGetObjValue(formObject.bl_tp_cd)=="W"){
			formObject3.elements["form_type" ].value="5";
		}else if(ComGetObjValue(formObject.bl_tp_cd)=="D"){
			formObject3.elements["form_type" ].value="7";
		}else{
			formObject3.elements["form_type" ].value="2";
		}
		formObject3.action="/opuscntr/ESM_BKG_0221.do";
		formObject3.target="ESM_BKG_0221";
		formObject3.submit();
	}
	function FaxEmailSend(sheetObj, formObject, strGubun) {
		if (!sheetObj) {
			sheetObj=sheetObjects[0];
		}
		if (!formObject) {
	        formObject=document.form;
		}
		//var sXml = sheetObj.GetSearchXml("ESM_BKG_0927GS.do", FormQueryString(formObject));
		//sheetObj.GetSaveString();
		var sXml=sheetObj.GetSaveData("ESM_BKG_0927GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
		var strMsg=strGubun == IBSENDFAX ? "Fax" : "Email";
		if(sXml.substring(1, 6) == "ERROR"){
			//
			//alert(ComResultMessage(sXml).split('<||>').join('\n'));
			ComShowCodeMessage("BKG00183", formObject.bkg_no.value);
		}
		else {
			//
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			//alert("State : [" + State + "]");
			if ( State == "S" ) {
				ComShowCodeMessage("COM130601", strMsg);
			}
		}
		sheetObj.RemoveAll();
		return;
	}
	function Retrive(sheetObject) {
		var formObject=document.form;
		if ( validateForm(formObject) ) {
			var isMdfyBlNo=ComGetLenByByte(formObject.bl_no)-1 == ComGetObjValue(formObject.bl_no).lastIndexOf("S") ||
                             ComGetLenByByte(formObject.bl_no)-1 == ComGetObjValue(formObject.bl_no).lastIndexOf("W");
			var backupBlNo;
			if (isMdfyBlNo) {
				backupBlNo=ComGetObjValue(formObject.bl_no);
				ComSetObjValue(formObject.bl_no,ComGetObjValue(formObject.bl_no).substr(0,ComGetLenByByte(formObject.bl_no)-1));
			}
			var isMdfyBkgNo=ComGetLenByByte(formObject.bkg_no)-1 == ComGetObjValue(formObject.bkg_no).lastIndexOf("S") ||
				ComGetLenByByte(formObject.bkg_no)-1 == ComGetObjValue(formObject.bkg_no).lastIndexOf("W");
			var backupBkgNo;
			if (isMdfyBkgNo) {
				backupBkgNo=ComGetObjValue(formObject.bkg_no);
				ComSetObjValue(formObject.bkg_no,ComGetObjValue(formObject.bkg_no).substr(0,ComGetLenByByte(formObject.bkg_no)-1));
			}
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			sheetObjects[0].RemoveAll()
//			if (isMdfyBlNo) {
//				ComSetObjValue(formObject.bl_no,backupBlNo);
//			}
			btnChk();
		}else{
			tabObjects[0].SetTabDisable(0 , true); // Face tab 
			tabObjects[0].SetTabDisable(1 , true); // Rider tab
			tabObjects[0].SetTabDisable(2 , true); // HouseD tab
			tabObjects[0].SetTabDisable(3 , true); // HouseS tab
			tabObjects[0].SetSelectedIndex(0);// Face tab selecting
			initRdConfig(viewer,1);  // RD screen initializing
			rControl=false;
//			rdOpen(formObject, "", "N", "N");  // RD connect			
		}
	}
	function validateForm(formObject) {
		//
		if ( formObject.bkg_no.value.length == "" && formObject.bkg_no.value.length == 0 && formObject.bl_no.value.length == "" && formObject.bl_no.value.length == 0 ) {
//			ComShowCodeMessage("BKG00445");
			if ( formObject.bkg_no.value.length == "" ) {
				formObject.bkg_no.focus();
			}
			return false;
		}
		return true;
	}
	function loadSet(formObject, sXml) {
		search_sheet=sheetObjects[0];
		if(sXml.substring(1, 6) == "ERROR"){
			if(formObject.bkg_no.value == ""){
				ComShowCodeMessage("BKG00885");
			}else{
				ComShowCodeMessage("BKG00183", formObject.bkg_no.value);
			}
			for (var i=0; i < formObject.bl_tp_cd.length; i++) {
				formObject.bl_tp_cd[i].checked=false;
				formObject.bl_tp_cd[i].disabled=true;
			}
			// Face
			formObject.bl_face.checked=false;
			formObject.bl_face.disabled=true;
			// Rider
			formObject.bl_rider.checked=false;
			formObject.bl_rider.disabled=true;
			// HouseD
			formObject.bl_houseD.checked=false;
			formObject.bl_houseD.disabled=true;
			// HouseS
			formObject.bl_houseS.checked=false;
			formObject.bl_houseS.disabled=true;
			
			// Tab
			tabObjects[0].SetTabDisable(0 , true); // Face tab 
			tabObjects[0].SetTabDisable(1 , true); // Rider tab
			tabObjects[0].SetTabDisable(2 , true); // HouseD tab
			tabObjects[0].SetTabDisable(3 , true); // HouseS tab
			tabObjects[0].SetSelectedIndex(0);// Face tab selecting
			rControl=false;
			rdOpenStart(formObject, "", "N", "N"); // RD connect
			return;
		} else {
			formObject.fax_no.value=ComGetEtcData(sXml,"fax_no");
			formObject.email.value=ComGetEtcData(sXml,"email");
			// Print
			formObject.bl_face.disabled=false;
			formObject.bl_rider.disabled=false;
			formObject.bl_houseD.disabled=false;
			formObject.bl_houseS.disabled=false;
			// N/N copy_signed
			formObject.bl_cpy_esig_flg.value=ComGetEtcData(sXml,"bl_cpy_esig_flg");
			
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if ( State == "S" ) {
				// success in case of exist bkg_no or bl_no
				rControl=true;
				// bkg_no / bl_no setting
				formObject.org_bkg_no.value=formObject.bkg_no.value=ComGetEtcData(sXml,"bkg_no");
				formObject.bl_no.value=ComGetEtcData(sXml,"bl_no");
				var bl_tp_cd=formObject.bl_tp_cd_param.value;
				//bl_tp_cd = ComGetEtcData(sXml,"bl_tp_cd");   //DB value
				riderYn=ComGetEtcData(sXml,"rider_yn");
				houseYn=ComGetEtcData(sXml,"houseBl_yn");
				oblIssFlg=ComGetEtcData(sXml,"obl_iss_flg");
				por_cd=ComGetEtcData(sXml,"por_cd");
//				formObject.bl_prn_chg_tp_cd.value=ComGetEtcData(sXml,"bl_prn_chg_tp_cd");

				if (""==bl_tp_cd) {
					formObject.bl_tp_cd[0].checked=true;
				} else if ("W"==bl_tp_cd) {
					formObject.bl_tp_cd[1].checked=true;
				} else if ("D"==bl_tp_cd) {
					if ("Y"==oblIssFlg && "bl_tp_cd"!=formObject.eventSrc.value) {
						formObject.bl_tp_cd[0].checked=true;
						bl_tp_cd="";
					} else {
						formObject.bl_tp_cd[2].checked=true;
						bl_tp_cd="D";
					}
				}
				if ("onload"==formObject.eventSrc.value) {
					if ("W"==bl_tp_cd) {
						formObject.bl_tp_cd[0].disabled=true;
					} else {
						formObject.bl_tp_cd[1].disabled=true;
					}
				}
//				if (is_first=="Y"){
//					
//					// Charge
//					if(formObject.bl_prn_chg_tp_cd.value=="1"){
//						formObject.rdo_form_level1.checked=true;
//						formObject.rdo_form_level2.checked=false;
//						formObject.rdo_form_level3.checked=false;
//						formObject.rdo_form_level4.checked=false;
//						formObject.rdo_form_level5.checked=false;
//					}else if(formObject.bl_prn_chg_tp_cd.value=="5"){
//						formObject.rdo_form_level1.checked=false;
//						formObject.rdo_form_level2.checked=true;
//						formObject.rdo_form_level3.checked=false;
//						formObject.rdo_form_level4.checked=false;
//						formObject.rdo_form_level5.checked=false;
//					}else if(formObject.bl_prn_chg_tp_cd.value=="4"){
//						formObject.rdo_form_level1.checked=false;
//						formObject.rdo_form_level2.checked=false;
//						formObject.rdo_form_level3.checked=true;
//						formObject.rdo_form_level4.checked=false;
//						formObject.rdo_form_level5.checked=false;
//					}else if(formObject.bl_prn_chg_tp_cd.value=="6"){
//						formObject.rdo_form_level1.checked=false;
//						formObject.rdo_form_level2.checked=false;
//						formObject.rdo_form_level3.checked=false;
//						formObject.rdo_form_level4.checked=true;
//						formObject.rdo_form_level5.checked=false;
//					}else if(formObject.bl_prn_chg_tp_cd.value=="3"){
//						formObject.rdo_form_level1.checked=true;
//						formObject.rdo_form_level2.checked=false;
//						formObject.rdo_form_level3.checked=false;
//						formObject.rdo_form_level4.checked=false;
//						formObject.rdo_form_level5.checked=true;
//					}else{
//						formObject.rdo_form_level1.checked=true;
//						formObject.rdo_form_level2.checked=false;
//						formObject.rdo_form_level3.checked=false;
//						formObject.rdo_form_level4.checked=false;
//						formObject.rdo_form_level5.checked=false;
//					}
//					formObject.form_level.value=formObject.bl_prn_chg_tp_cd.value == "" ? "1" : formObject.bl_prn_chg_tp_cd.value;
//				}else{
//					is_first="N";
//				}
				// Print
				formObject.bl_face.checked=true;
				// tab
				if ( riderYn == "N" ) {  //Impossible to checkbox not checking
					formObject.bl_rider.checked=false;
					formObject.bl_rider.disabled=true;
					tabObjects[0].SetTabDisable(1, true); //Rider tab
				} else {
					formObject.bl_rider.checked=true;
					formObject.bl_rider.disabled=false;
					tabObjects[0].SetTabDisable(1, false); // Rider tab
				}
				if ( houseYn == "N" ) {  //Impossible to checkbox not checking
					formObject.bl_houseD.checked=false;
					formObject.bl_houseD.disabled=true;
					formObject.bl_houseS.checked=false;
					formObject.bl_houseS.disabled=true;
					tabObjects[0].SetTabDisable(2, true); // houseD tab
					tabObjects[0].SetTabDisable(3, true); // houseS tab
				} else {
					formObject.bl_houseD.checked=true;
					formObject.bl_houseD.disabled=false;
					formObject.bl_houseS.checked=true;
					formObject.bl_houseS.disabled=false;
					tabObjects[0].SetTabDisable(2, false); // houseD tab
					tabObjects[0].SetTabDisable(3, false); // houseS tab
				}
				//Face tab selecting
				tabObjects[0].SetTabDisable(0, false);
				tabObjects[0].SetSelectedIndex(0);
				tabObjects[0].SetTabDisable(tabObjects[0].GetSelectedIndex(), false);// Face tab
				rdOpenStart(formObject, bl_tp_cd, riderYn, houseYn);
//				is_first="N";
			}
		}
	}
	function rdOpen(formObject, bl_tp_cd, riderYn, houseYn, totalPageNo) {
		var totalPage = totalPageNo;
		var Rdviewer_face = rdframe1.viewer;
		var Rdviewer_rider = rdframe2.viewer;
		var Rdviewer_houseD = rdframe3.viewer;
		var Rdviewer_houseS = rdframe4.viewer;
		var rdParam="";
		var strPath="";
		var bkg_no=rControl == true ? formObject.bkg_no.value : "";
		//var form_dataOnly = rControl == true ? "N" : "Y";
		var form_dataOnly="N";
		var hiddenData="";
		if(bkg_no ==""){
			return false;
		}
		if ( formObject.hiddenData.checked == true ) {
			hiddenData=formObject.hiddenData.value;
		}
		var form_level=formObject.form_level.value;
		if ( form_level.split(",").length > 0 ) {
			form_level=form_level.split(",")[0];
		}
		var form_remark=formObject.form_remark.value;
		if ( formObject.first_bkg_no.value != "" ) {
			if ( formObject.first_bkg_no.value != formObject.bkg_no.value ) {
				form_remark="";
			}
		}
		else {
			if ( formObject.first_bl_no.value != "" && formObject.first_bl_no.value != formObject.bl_no.value ) {
				form_remark="";
			}
		}
		form_remark=ComReplaceStr(form_remark, "\r\n", "(##)");
		form_remark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
		// Type
		// "" - Original / "W" - WayBill / "D" - Draft
		// /rv form_bkgNo[( 'JKTZ2148104', 'PHXZ5225101', 'SLCZ9305010' )] form_type[OBL] form_printBlType[ORIGINAL] form_dataOnly[N] form_manifest[N] /riprnmargin
		// /rv form_bkgNo[( ':(BKG_NO)' )]  form_gubun[M] /riprnmargin
		// Face
		switch(bl_tp_cd) {
			case "": // Original
				formObject.form_type.value="2";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_path[" + getFileDownPath() + "] "; // form_path		
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_end_no[" + totalPage +"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				if(null == por_cd){
					strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";	
				}else{
					strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				}
				break;
			case "W": // WayBill
				formObject.form_type.value="5";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_path[" + getFileDownPath() + "] "; // form_path		
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_end_no[" + totalPage +"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;
			case "D": // Draft
				formObject.form_type.value="7";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_path[" + getFileDownPath() + "] "; // form_path		
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] isEncode[Y] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_end_no[" + totalPage +"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;
		}
		Rdviewer_face.openFile(strPath, RDServer + rdParam);
		Rdviewer_face.setDownloadFileName(getBlRdFileName(bkg_no, formObject.form_type.value, "Face"));	//BL filename
		
		// Rider
		if ( riderYn == "Y" ) {
			rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_Cntr[" + formObject.form_Cntr.value + "] ";
			rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC]  isEncode[Y] form_type[" + formObject.form_type.value + "] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_end_no[" + totalPage +"] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
			strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_LETTER_Rider.mrd" : "ESM_BKG_0109_A4_Rider.mrd");
			Rdviewer_rider.openFile(strPath, RDServer + rdParam);
			Rdviewer_rider.setDownloadFileName(getBlRdFileName(bkg_no, formObject.form_type.value, "Rider"));	//BL filename
			tabObjects[0].SetSelectedIndex(1);
		}
		// House
		if ( houseYn == "Y" ) {
			// HouseD
			rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait /rmmloverlapobj";
			strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			Rdviewer_houseD.openFile(strPath, RDServer + rdParam);
			Rdviewer_houseD.setDownloadFileName(getBlRdFileName(bkg_no, formObject.form_type.value, "HB(D)"));	//BL filename
			tabObjects[0].SetSelectedIndex(2);
			// HouseS
			rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_S.mrd";
			Rdviewer_houseS.openFile(strPath, RDServer + rdParam);
			Rdviewer_houseS.setDownloadFileName(getBlRdFileName(bkg_no, formObject.form_type.value, "HB(S)"));	//BL filename
			tabObjects[0].SetSelectedIndex(3);
		}
		tabObjects[0].SetSelectedIndex(1);
		tabObjects[0].SetSelectedIndex(2);
		tabObjects[0].SetSelectedIndex(3);
		tabObjects[0].SetSelectedIndex(0);
	}
	//전체 페이지 숫자를 알기위해 formMainOnly='N'로 하여 Face를 실행 한다.
	function rdOpenStart(formObject, bl_tp_cd, riderYn, houseYn){
		var rdOpenStartViewer = rdframe5.viewer;
		var rdParam="";
		var strPath="";
		var bkg_no=rControl == true ? formObject.bkg_no.value : "";
		//var form_dataOnly = rControl == true ? "N" : "Y";
		var form_dataOnly="N";
		var hiddenData="";
		if(bkg_no ==""){
			return false;
		}
		if ( formObject.hiddenData.checked == true ) {
			hiddenData=formObject.hiddenData.value;
		}
		var form_level=formObject.form_level.value;
		if ( form_level.split(",").length > 0 ) {
			form_level=form_level.split(",")[0];
		}
		var form_remark=formObject.form_remark.value;
		if ( formObject.first_bkg_no.value != "" ) {
			if ( formObject.first_bkg_no.value != formObject.bkg_no.value ) {
				form_remark="";
			}
		}
		else {
			if ( formObject.first_bl_no.value != "" && formObject.first_bl_no.value != formObject.bl_no.value ) {
				form_remark="";
			}
		}
		form_remark=ComReplaceStr(form_remark, "\r\n", "(##)");
		form_remark=ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
		// Type
		// "" - Original / "W" - WayBill / "D" - Draft
		// /rv form_bkgNo[( 'JKTZ2148104', 'PHXZ5225101', 'SLCZ9305010' )] form_type[OBL] form_printBlType[ORIGINAL] form_dataOnly[N] form_manifest[N] /riprnmargin
		// /rv form_bkgNo[( ':(BKG_NO)' )]  form_gubun[M] /riprnmargin
		// Face
		switch(bl_tp_cd) {
			case "": // Original
				formObject.form_type.value="2";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_mainOnly[N] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				if(null == por_cd){
					strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";	
				}else{
					strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				}
				break;
			case "W": // WayBill
				formObject.form_type.value="5";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_mainOnly[N] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;
			case "D": // Draft
				formObject.form_type.value="7";
				rdParam="/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_mainOnly[N] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] isEncode[Y] form_rqst_via_cd[] form_his_bl_mkd[BKG_BL_ISS] form_path[" + getFileDownPath() + "] form_esig[] form_cpy_esig[" +formObject.bl_cpy_esig_flg.value + "] form_knt_flg[] form_count[] /rp [] /riprnmargin /rwait";
				strPath=RD_path+"apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;
		}
		rdOpenStartViewer.openFile(strPath, RDServer + rdParam, {timeout:3000});
		rdOpenStartViewer.bind('report-finished', function(e){ 
			rdOpen(formObject, bl_tp_cd, riderYn, houseYn, e.totalPage);
		});
	}	
	
	function btnChk() {
		var formObject=document.form;
		var bl_tp_cd="";
		for (var i=0; i < formObject.bl_tp_cd.length; i++) {
			if ( formObject.bl_tp_cd[i].checked == true ) {
				bl_tp_cd=formObject.bl_tp_cd[i].value;
				break;
			}
		}
		// Email / Fax button deactivating
		// activating in case of WayBill or Draft
		ComBtnEnable("btn_Fax");
		ComBtnEnable("btn_Email");
		if ( formObject.email.value == "" || formObject.fax_no.value == "" ) {
			if ( formObject.email.value == "" ) {
				emailYn=false;
			}
		}
	}
	function pageReset(formObject) {
		//
		formObject.reset();
		formObject.bkg_no.value="";
		formObject.bl_no.value="";
		// Type
		for (var i=0; i < formObject.bl_tp_cd.length; i++) {
			//
			formObject.bl_tp_cd[i].checked=false;
			formObject.bl_tp_cd[i].disabled=false;
		}
		// Print
		// Face
		formObject.bl_face.checked=false;
		formObject.bl_face.disabled=false;
		// Rider
		formObject.bl_rider.checked=false;
		formObject.bl_rider.disabled=false;
		// HouseD
		formObject.bl_houseD.checked=false;
		formObject.bl_houseD.disabled=false;
		// HouseS
		formObject.bl_houseS.checked=false;
		formObject.bl_houseS.disabled=false;
		// Tab
		tabObjects[0].SetTabDisable(0, false);// Face tab
		tabObjects[0].SetTabDisable(1, false);// Rider tab
		tabObjects[0].SetTabDisable(2, false);// HouseD tab
		tabObjects[0].SetTabDisable(3, false);// HouseS tab
		tabObjects[0].SetSelectedIndex(0);
		ComBtnEnable("btn_Fax");
		ComBtnEnable("btn_Email");
		rControl=false;
		// RD connect
		rdOpenStart(formObject, "", "Y", "Y");
	}
	function RD_Print() {
		var formObject=document.form;
		var cntChk=0;
		// RD
		var Rdviewer_face = rdframe1.viewer;
		var Rdviewer_rider = rdframe2.viewer;
		var Rdviewer_houseD = rdframe3.viewer;
		var Rdviewer_houseS = rdframe4.viewer;
		if ("US"==formObject.strCnt_cd.value) {
//			Rdviewer_face.SetPrint2(4,1,1,100);
//			Rdviewer_rider.SetPrint2(4,1,1,100);
//			Rdviewer_houseD.SetPrint2(4,1,1,100);
//			Rdviewer_houseS.SetPrint2(4,1,1,100);
		}
		//alert("tabObjects[0].TabEnable(" + tabObjects[0].SelectedIndex + ") : ["+ tabObjects[0].TabEnable(tabObjects[0].SelectedIndex) + "]\n\n" + "formObject.bl_face.checked : [" + formObject.bl_face.checked + "]");
		//alert("beforetab : [" + beforetab + "]");
		//alert("tabObjects[0].TabEnable(0) : [" + tabObjects[0].TabEnable(0) + "]\n\n" + "tabObjects[0].TabEnable(1) : [" + tabObjects[0].TabEnable(1) + "]\n\n" + "tabObjects[0].TabEnable(2) : [" + tabObjects[0].TabEnable(2) + "]\n\n" + "tabObjects[0].TabEnable(3) : [" + tabObjects[0].TabEnable(3) + "]");
		//alert("tabObjects[0].GetCount() : [" + tabObjects[0].GetCount() + "]");
		//alert("riderYn : [" + riderYn + "]\n\n" + "formObject.bl_rider.checked : [" + formObject.bl_rider.checked + "]\n\n" + "houseYn : [" + houseYn + "]\n\n" + "formObject.bl_houseD.checked : [" + formObject.bl_houseD.checked + "]\n\n" + "formObject.bl_houseS.checked : [" + formObject.bl_houseS.checked + "]");
		//return;
		// Face
		if ( formObject.bl_face.checked == true ) {
			//alert("Face Print");
			Rdviewer_face.print({isServerSide:true});
			cntChk++;
		}
		// Rider
		if ( riderYn == "Y" && formObject.bl_rider.checked == true ) {
			//alert("Rider Print");
			Rdviewer_rider.print({isServerSide:true});
			cntChk++;
		}
		// HouseD
		if ( houseYn == "Y" && formObject.bl_houseD.checked == true ) {
			//alert("HouseD Print");
			Rdviewer_houseD.print({isServerSide:true});
			cntChk++;
		}
		// HouseS
		if ( houseYn == "Y" && formObject.bl_houseS.checked == true ) {
			//alert("HouseS Print");
			Rdviewer_houseS.print({isServerSide:true});
			cntChk++;
		}
	}
	function Pop_ESM_BKG_0743(formObject) {
		var formObject2=document.form2;
		var hiddenData=formObject.hiddenData.checked == true ? formObject.hiddenData.value : "";
		var width=630;
		var height=440;
		var left=(screen.width-width)/2;
		var top=(screen.height-height)/2;
		formObject2.bkg_no.value=formObject.bkg_no.value;
		formObject2.form_manifest.value=formObject.manifest.value;
		formObject2.form_hiddeData.value=hiddenData;
		formObject2.form_remark.value=formObject.form_remark.value;
		//var param = "?bkg_no=" + formObject.bkg_no.value + "&form_manifest=" + formObject.manifest.value + "&form_hiddeData=" + hiddenData + "&form_remark=" + ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)");
		ComOpenWindow("", "PopupEsmBkg0743", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		formObject2.action="/opuscntr/ESM_BKG_0743.do";
		formObject2.target="PopupEsmBkg0743";
		formObject2.submit();
	}
	
	function unloadPage() {
		if (opener && opener.document && opener.document.tab1 &&
			opener.frames && opener.frames[opener.document.tab1.GetSelectedIndex()] &&
			opener.frames[opener.document.tab1.GetSelectedIndex()].document &&
			opener.frames[opener.document.tab1.GetSelectedIndex()].document.form) {
			var openerForm=opener.frames[opener.document.tab1.GetSelectedIndex()].document.form;
			var sendBkgNo=ComGetObjValue(document.form.org_bkg_no);
			if (openerForm.frm_t10sheet1_bkg_no) {
				openerForm.frm_t10sheet1_bkg_no.value=sendBkgNo;
			} else if (openerForm.frm_t11sheet1_bkg_no) {
				openerForm.frm_t11sheet1_bkg_no.value=sendBkgNo;
			} else if (openerForm.bkg_no) {
				openerForm.bkg_no.value=sendBkgNo;
			}
			opener.runShortcut("retrieve");
		}
	}
