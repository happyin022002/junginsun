/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0647.js
*@FileTitle  : B/L Status Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    // var rowsPerPage = 50;
    var rowsPerPage=99999;
    var prefix="sheet1_";
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
	//registering the created IBCombo Object at page as comboObjects list
	//ComComboObject is called from Constructor method  
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	} 	
 	/**
 	 * Combo basic setting 
 	 * @param comboObj
 	 * @param comboNo
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject=document.form
 			initComboEditable(comboObj, comboId)
 	}
 	  //combo multi select and modified basic setting
 	function initComboEditable(combo, comboId){
 	 	with (combo) {
	 	 	SetMultiSelect(0);
	 	 	SetUseAutoComplete(1);
	 	 	SetUseEdit(0);
	 	 	if(comboId == "cust_tp_cd" ){
	 	 		SetDropHeight(300);
	 	 		SetColBackColor(1,"255,255,255");
	 	 	}	
 	 	}
 	 } 	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
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
			  //MultiComboinitializing 
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],comboObjects[k].id);
         }
         initControl();
         setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
    }
    function initControl() {
    	var formObject=document.form;
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus out     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus in
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }        
 /*********************** KEY EVENT START ********************/ 	 
    /**
	 * control onBlur of HTML Control
	 */
    function bkg_deactivate() {
    	var formObj=document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * checking Validation at onFocus event of HTML Control
	 **/
	function bkg_activate(){
		//checking input Validation
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
				break;
		}
	}  
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
						case "btn_dura_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
						 	break;		 				
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					form.reset();
							cust_tp_cd.SetSelectText("");
							sheetObject1.RemoveAll();
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				 case "bl_type_ori":
							if(form.bl_type_ori.checked){
								form.bl_type_way.checked=false;
							}
							break; 		
		 				 case "bl_type_way":
							if(form.bl_type_way.checked){
								form.bl_type_ori.checked=false;
							}
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
      * handling sheet process
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return void
      */
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:      //retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) 
 					return;
 				// debug.innerHTML=FormQueryString(formObj);
 				// alert(FormQueryString(formObj));
 				// break;
 				formObj.f_cmd.value=SEARCH;
 				formObj.rows_per_page.value=rowsPerPage;
 				formObj.curr_page.value=1;
 				pagedMaxCnt=sheetObj.HeaderRows();
				sheetObj.RemoveAll();
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0647GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml, {Sync:0});
				sheetObj.SetWaitImageVisible(0);
	    		sheetObj.RenderSheet(1);
 				break;
 			case IBSEARCHAPPEND: 
				formObj.f_cmd.value=SEARCH;
                formObj.curr_page.value=PageNo;
                selectVal=FormQueryString(formObj);
                sheetObj.DoSearch("ESM_BKG_0647GS.do", selectVal+ "&" + ComGetPrefixParam(prefix)+"&"+ "iPage=" + PageNo);
                break;  
			case SEARCH01:      //retrieve
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0647GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				/*CUSTOMER TYPE*/								
				ComXml2ComboItem(arrXml[0], cust_tp_cd, "val", "val|name");
				break;
			case IBDOWNEXCEL:  
				// sheetObj.Down2Excel();
				// sheetObj.SpeedDown2Excel();
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.SetHeaderBackColor("#CCCCCC");
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObj), SheetDesign:1,Merge:1 });
					sheetObj.SetHeaderBackColor("#333333");					
				}
				break;
         }
     }
	 /**
     * to retrieve the rest of history when the scroll move at the bottom of the list <br>
     */ 
     function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	     //alert("PageNo:"+PageNo+"  "+OnePageRows);
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	  }        
     /*
      * initial value is sheet header number
      */ 
      var pagedMaxCnt=2; 
			/**
       * event handling after retrieve >>> changing font color
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 with (sheetObj) {
    		 var blueColor="#0000FF";
    		 for (var i=pagedMaxCnt; i <= LastRow(); i++){
    			 sheetObj.SetCellFontColor(i,prefix+"bkg_no",blueColor);
    			 sheetObj.SetCellFontUnderline(i,prefix+"bkg_no",1);
    			 sheetObj.SetCellFontColor(i,prefix+"bl_no",blueColor);
    			 sheetObj.SetCellFontUnderline(i,prefix+"bl_no",1);
    		 }
    	 }
     }
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
     		obj.SetCellFontColor(idx,celName,color);
     }
     
     /*
	 * Search Option or Item Option Modify
	 */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
			// var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx,
			// prefix+"bkg_no");
			// ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079.do"+param, "Booking Main",
			// 1024,740,false,"scrollbars=yes,resizable=yes");
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, prefix+"bkg_no"));
		} else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
			var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no") + "&bl_tp_cd=W";
			ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do"+param, "BL Preview", 1024,700,true,"scrollbars=no,resizable=yes");
		}
	 }
		 /**
		     * handling process for input validation <br>
		     * @param sheetObj
		     * @param formObj
		     * @param sAction
		     * @return boolean
		     */ 
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.vvd_cd) && (ComIsNull(formObj.dura_from_dt) && ComIsNull(formObj.dura_to_dt))&& ComIsNull(formObj.bkg_bl_no)) {
     					ComShowCodeMessage('BKG00227');
     					formObj.vvd_cd.focus();
     					return false;
		  		}
	    		if (formObj.vvd_cd.value !='' && formObj.vvd_cd.value.length != 9) {
     					ComShowCodeMessage('BKG00538');
     					formObj.vvd_cd.focus();
     					return false;
		  		}
		  		if (ComIsNull(formObj.por_cd) && ComIsNull(formObj.pol_cd) 
		  									  && ComIsNull(formObj.pod_cd) 
		  									  && ComIsNull(formObj.del_cd) 
		  									  && ComIsNull(formObj.del_ofc_cd)
		  									  && ComIsNull(formObj.obl_ofc_cd)
		  									  && ComIsNull(formObj.sal_ofc_cd)
		  									  && ComIsNull(formObj.bl_ofc_cd)
		  									  && ComIsNull(formObj.obl_rcv_ofc_cd)
		  									  && ComIsNull(formObj.bkg_ofc_cd)
		  									  && ComIsNull(formObj.bkg_bl_no)) {
     					ComShowCodeMessage('BKG00626','POR or POL or POD or DEL or Control Ofc or Booking Ofc or Sales Ofc or BL Issue Ofc or OBL Receive Ofc ');
     					formObj.pol_cd.focus();
     					return false;
		  		}
	  			break;
    	 }
         return true;
    }
     
    function isNullEtcData(xmlStr){
    	var rtn=false;
    	var xmlDoc = ComGetXmlDoc(xmlStr);
        xmlDoc.loadXML(xmlStr);
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) 
        	return true;
        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;
        var etcNodes=etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn=true;
        return rtn;
    }
    
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
            case "sheet1":
                with(sheetObj){
					var HeadTitle1="  |No|Booking No.|B/L No.|POR|POL|POD|DEL|BKG OFC|DEL OFC|On Board|On Board|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|Issue & Release|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender|OBL Receive or Surrender";
					HeadTitle1 += "|B/L Data Input|B/L Data Input|B/L Data Input|B/L Data Input|B/L Data Input|VVD|Shipper|Forwarder|Consignee|Sales Office|Sales Rep|S/C or RFA|Payment Term|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|Payment Status|B/L Remark(s)";
					var HeadTitle2="  |No|Booking No.|B/L No.|POR|POL|POD|DEL|BKG OFC|DEL OFC|Type|Date|B/L Type|Issue|Print|Release|Office|Date|By|Office|Date|No|Surrender|D/O";
					HeadTitle2 += "|S/R|Complete|B/L Type|Office|By|VVD|Shipper|Forwarder|Consignee|Sales Office|Sales Rep|S/C or RFA|Payment Term|PPD (Org)|PPD (Org)|PPD (3rd)|PPD (3rd)|CCT (Dest)|CCT (Dest)|CCT (3rd)|CCT (3rd)|B/L Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
						{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
						{Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_ofc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_ofc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_date",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ir_bl_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_issued",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_print",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_released",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ir_office",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ir_date",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ir_by",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ors_office",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ors_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ors_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ors_surrender", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ors_do",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bdi_sr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bdi_complete",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bdi_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bdi_office",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bdi_by",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:150,   Align:"Left",    ColMerge:1,   SaveName:prefix+"shipper",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:150,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fowarder",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:150,   Align:"Left",    ColMerge:1,   SaveName:prefix+"consignee",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sales_office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sales_rep",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_rfa_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ppd_org",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ppd_org2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ppd_3rd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ppd_3rd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_dest",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_dest2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_3rd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_3rd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"obl_iss_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

					InitColumns(cols);
					SetEditable(0);
//					SetSheetHeight(420);
					SetRangeBackColor(1,9,1,28,"#555555");
					SetRangeBackColor(1,36,1,43,"#555555");
					resizeSheet();
                }
				break;
         }
     }
     
     function setSchKey(val){ // Radio Click 시 data clear
    	 var formObj=document.form;
    	 if (val == "BKG"){
    		 formObj.vvd_cd.value="";
    		 formObj.pol_cd.value="";
    	 }
    	 if (val == "BL"){
    		 formObj.vvd_cd.value="";
    		 formObj.pol_cd.value="";
    	 }
     }  