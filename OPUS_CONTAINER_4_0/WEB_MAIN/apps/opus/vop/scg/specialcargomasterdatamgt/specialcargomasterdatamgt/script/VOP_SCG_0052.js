/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0052.js
*@FileTitle  : Partner’s Contact Point for SPCL CGO (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0052 :  business script for vop_scg_0052
     */
    function vop_scg_0052() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array(); 
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn1_Excel":
                	var tabIndex = ComGetObjValue(formObject.tabSelectedIdx);
                	
                	if(tabIndex == 0 && sheetObject1.RowCount() < 1) {//no data
                		ComShowCodeMessage("COM132501");
                		return;
                	}
                	
                	if(tabIndex == 1 && sheetObject2.RowCount() < 1) {//no data
                		ComShowCodeMessage("COM132501");
                		return;
                	}

                	if(tabIndex == 2 && sheetObject2.RowCount() < 1) {//no data
                		ComShowCodeMessage("COM132501");
                		return;
                	}
                	
                	if (tabIndex == 0) {
 		                var paramObj = new Object();
 		                paramObj.title = "Partner's Contact Point for SPCL CGO ";
// 	                    paramObj.columnwidth = "2:10|3:25|4:7|5:7|6:45|7:10|8:10";
// 		                var url = ComScgGetPgmTitle(sheetObject1, paramObj); 
// 		                sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 						var sheetExcelObj = sheetObject1;
 			            paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
 			            paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
 			            paramObj.datarowheight="0:25";
 			            var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
 			            
 			            if(sheetExcelObj.RowCount() < 1){//no data
 			        		  ComShowCodeMessage("COM132501");
 				       	}else{
 			   	       		var str = sheetExcelObj.GetSearchData(url);
 			   	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
 			   	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
 				       	} 		                
                	} else if (tabIndex == 1) {
 						var paramObj = new Object();
 		                paramObj.title = "Partner's Contact Point for TDR/RDR ";
// 	                    paramObj.columnwidth = "2:10|3:25|4:7|5:15|6:45";
// 		                var url = ComScgGetPgmTitle(sheetObject2, paramObj); 
// 		                sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
 						var sheetExcelObj = sheetObject2;
 			            paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
 			            paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
 			            paramObj.datarowheight="0:25";
 			            var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
 			            
 			            if(sheetExcelObj.RowCount() < 1){//no data
 			        		  ComShowCodeMessage("COM132501");
 				       	}else{
 			   	       		var str = sheetExcelObj.GetSearchData(url);
 			   	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
 			   	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
 				       	} 	 		                
                	} else if (tabIndex == 2) {
 						var paramObj = new Object();
 		                paramObj.title = "Partner's Contact Point for Baplie ";
// 	                    paramObj.columnwidth = "2:10|3:25|4:7|5:15|6:45";
// 		                var url = ComScgGetPgmTitle(sheetObject2, paramObj); 
// 		                sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
 						var sheetExcelObj = sheetObject3;
 			            paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
 			            paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
 			            paramObj.datarowheight="0:25";
 			            var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
 			            
 			            if(sheetExcelObj.RowCount() < 1){//no data
 			        		  ComShowCodeMessage("COM132501");
 				       	}else{
 			   	       		var str = sheetExcelObj.GetSearchData(url);
 			   	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
 			   	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
 				       	} 	 		                
     				}
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
                            
         for(i=0;i<sheetObjects.length;i++){
             //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //
             ComEndConfigSheet(sheetObjects[i]);
         }
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         ComSetObjValue(document.form.tabSelectedIdx, "0");
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         //Initializing html control event
         initControl();
         
         resizeSheet();
         sheet1_OnLoadFinish(sheet1);
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet( sheetObj,document.form,IBSEARCH_ASYNC01);
      } 
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

	                var HeadTitle="|No.|Carrier Code|Carrier Full Name|Lane|CGO Type|E-mail|TEL No|FAX No|";
	                //( HeadTitle.split("|").length, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                    {Type:"Text",      Hidden:0,  Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                    {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cate_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetColProperty("spcl_cgo_cate_cd", {ComboText:"DG|AK/BB|RF|SS", ComboCode:"DG|AK|RF|SS"} );
                }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {

	                var HeadTitle="|No.|Carrier Code|Carrier Full Name|Lane|Report Type|E-mail||";
	                //( HeadTitle.split("|").length, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                    {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                    {Type:"Text",      Hidden:0,  Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                    {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:1,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetColProperty("cntc_cate_cd", {ComboText:"TDR|RDR", ComboCode:"TD|RD"} );
                }
                break;
            case 3:      //sheet3 init
         		with (sheetObj) {
         			// setting height
         		
         		var HeadTitle="|No.|Carrier Code|Carrier Full Name|Lane|Bound|Port Code|Message Type|Effective Date From|Effective Date To|E-mail|";

         		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

         		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         		var headers = [ { Text:HeadTitle, Align:"Center"} ];
         		InitHeaders(headers, info);
         		
         		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
         		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
         		             {Type:"Text",      Hidden:0, Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
         		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
       		                 {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
       		                 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                 {Type:"Text",      Hidden:0, Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
         		 
         		InitColumns(cols);
         		
         		SetEditable(0);

         		SetColProperty("skd_dir_cd",   {ComboText:"E|W|N|S", ComboCode:"E|W|N|S"} );
         		SetColProperty("port_cd", {ComboText:"TDR|RDR", ComboCode:"TD|RD"} );
         		SetColProperty("cntc_cate_cd", {ComboText:"BAPLIE(Syntax Error)|BAPLIE(External)|BAPLIE(Internal)", ComboCode:"BE|BX|BI"} );

                }
         		break;    
         }
     }
     /**
      * initializing Combo
      * Setting Combo items
      */
     function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "rgn_shp_opr_cd":
                with(comboObj) {
                    SetTitle("Code|Description");
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "150");
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;          
        }
    }     
     
     /**
      * Initialzing Tab
      * Setting tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     InsertItem("SPCL CGO"          , "" );
                     InsertItem("TDR/RDR"  , "" );
                     InsertItem("BAPLIE"   , "" );
                 }
              break;

          }
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
            	sheetObj.SetWaitImageVisible(0);
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
	     			
	     			var arrXml = sXml.split("|$$|");
	     			
	     			var tabIdx = tabObjects[0].GetSelectedIndex();
	     			
	     			loadCt = 0;
	     		
					if(tabIdx == 0) {
						for(var i=0; i<arrXml.length; i++) {
							tabObjects[0].SetSelectedIndex(i);
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						tabObjects[0].SetSelectedIndex(tabIdx);
					} else {
						for(var i=arrXml.length-1; i>=0; i--) {
							tabObjects[0].SetSelectedIndex(i);
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						tabObjects[0].SetSelectedIndex(tabIdx);
					}
					
					if ( sheetObjects[2].FindText("crr_cd", "COM") == -1) {
						setAddRow(sheetObjects[2], formObj);
					} else {
						sheetObjects[2].SetRowBackColor(1, "#89E168");
					}
				}
                break;
            case IBSEARCH_ASYNC01: // RSO retrieve
                formObj.f_cmd.value=SEARCH01;
                var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
                break;
            case IBROWSEARCH:   //retrieve	
            	alert("sssssssssss")
	    		if (Col == "crr_cd") {
					formObj.f_cmd.value=SEARCH01;
 					var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)+"&crr_cd="+sheetObj.GetCellValue(Row,Col));
					var arrData=ComScgXml2Array(sXml, "crr_cd|crr_nm");
				    if (arrData != null && arrData.length > 0) {
				    	sheetObj.SetCellValue(Row,"vsl_opr_nm",arrData[0][1]);
					}else{
						ComShowCodeMessage('SCG50010', 'Data');
					    sheetObj.SelectCell(Row, Col, true, "");
						sheetObj.SetCellValue(Row,"vsl_opr_nm","",0);
					}
				}else if (Col == "slan_cd") {
	        		  formObj.f_cmd.value=SEARCH02;
 	        		  var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do" , FormQueryString(formObj)+"&vsl_slan_cd="+sheetObj.GetCellValue(Row,Col));
	        		  var arrData=ComScgXml2Array(sXml, "vsl_slan_cd");
	        		  if (arrData != null && arrData.length > 0) {
	        		  }else{
	        			  ComShowCodeMessage('SCG50010', 'Data');
	        			  sheetObj.SelectCell(Row, Col, true, "");
	        			  return;
	        		  }
				}
	    		break;
         }
     }
     //business javascript OnKeyPress event Catch
     function initControl() {
//         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//         axon_event.addListener('change', 'combo_OnChange', 'rgn_shp_opr_cd');     
     }
     
     /**
      * When clicking Tab, related event
      * selected tab's elements activate.
      */
     function tab1_OnChange(tabObj , nItem) {
     	var formObj=document.form;
     	var tabSelectedIdx=ComGetObjValue(formObj.tabSelectedIdx);
     	var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//--------------- important point --------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	
     	resizeSheet();
     	beforetab=nItem;	
     	ComSetObjValue(formObj.tabSelectedIdx, nItem);
     }
     //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
//        alert(comboObj);
        if (!ComIsNull(newCode)) {
//            var arrText=newCode.split("|");
            formObj.rgn_shp_opr_desc.value=comboObj.GetText(newCode,1);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (sAction == IBSEARCH) {
        	if (comboObjects[0].GetSelectCode()== "") {
        		ComShowCodeMessage('SCG50011','RSO');
//        		rgn_shp_opr_cd.focus();
        		return;
        	}
        }
        return true;
    }
    /**
      * Clicking popup in IBSheet Object
      */
    function sheet1_OnPopupClick(sheetObj, Row, Col){
        if (sheetObj.ColSaveName(Col) == "crr_cd") {
        	ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.GetCellValue(Row, "crr_cd"), 423, 420, "setCrrCd", "1,0,1,1,1,1", false, false, Row, Col, 0);
        } else if (sheetObj.ColSaveName(Col) == "slan_cd") {
			ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 426, 455, "setSlanCd", "0,0", true, false, Row, Col, 0);
        }
    }
    
    /**
     * when input value change in IBSheet Object
     */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var code=Value;
		if (sheetObj.ColSaveName(Col) == "crr_cd" && code !="") {
			if (code.length >= 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "crr_cd", Row);
			}else{
				ComShowCodeMessage('SCG50009','Carrier Code', '3', '4');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}else if (sheetObj.ColSaveName(Col) == "slan_cd" && code !="") {
			if (code.length == 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);
			}else{
				ComShowCodeMessage('SCG50006','Lane Code', '3');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}	
	}
    
    function setAddRow(sheetObj, formObj) {
		var row = sheetObj.DataInsert(0);
		sheetObj.SetCellValue(row,"rgn_shp_opr_cd"     , ComGetObjValue(formObj.rgn_shp_opr_cd));
		sheetObj.SetCellValue(row,"crr_cd"             , "COM", 0);
		sheetObj.SetCellValue(row,"slan_cd"            , "COM", 0);
		sheetObj.SetCellValue(row,"spcl_cgo_cate_cd"   , "BE");
		sheetObj.SetCellValue(row,"cntc_pson_eml_ctnt" , "realvision21@cyberlogitec.com");
		
		sheetObj.SelectCell(row, 2);
		sheetObj.SetRowEditable(row,0);		
		sheetObj.SetRowBackColor(row, "#89E168");
	}
    /**
     * crr_cd input.<br>
     * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
     */
    function setCrrCd(aryPopupData, Row, Col, sheetIdx){
        sheetObjects[sheetIdx].SetCellValue(Row,Col,aryPopupData[0][1],0);
        sheetObjects[sheetIdx].SetCellValue(Row,3,aryPopupData[0][2],0);
    }
    /**
     * slan_cd input.<br>
     * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
     */
    function setSlanCd(aryPopupData, Row, Col, sheetIdx){
        sheetObjects[sheetIdx].SetCellValue(Row,Col,aryPopupData[0][3],0);
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
