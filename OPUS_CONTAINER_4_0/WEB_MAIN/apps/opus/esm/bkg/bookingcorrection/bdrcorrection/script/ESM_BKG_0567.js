/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0567.js
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================
*/

/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;    
    var rdObjects=new Array();
    var rdCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
        sheetObject1=sheetObjects[0];
        sheetObject2=sheetObjects[1];
        sheetObject3=sheetObjects[2];
        sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;

    	try {
    		var srcName= ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
			    	break;
			    case "btn_DownExcel":
			        if (document.all.item("tabLayer")[2].style.display == "inline")  {
			    		sheetObj=sheetObjects[3];
			    	} else if (document.all.item("tabLayer")[1].style.display == "inline")  {
			    		sheetObj=sheetObjects[2];
			    	} else if (document.all.item("tabLayer")[0].style.display == "inline")  {
			    		sheetObj=sheetObjects[1];
			    	} else {
			    		sheetObj=sheetObjects[0];
			    	}
			    	
	      	    	// mandatory condition check
	      	    	//if(formObject.bkg_no.value.trim() == "") {
	      	    	if(formObject.oldBkgNo.value.trim() == "") {
	      	    		ComBkgNessMessage(formObject.bkg_no); 
	      	    		return false;
	      	    	}
//			    	var sheetObj=null;
			    				    	
		        	if (sheetObj.RowCount()== 0) {
		        		ComShowCodeMessage("BKG00109"); 
		        	    return;
		        	} else {
		        		sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false,Merge:1,SheetDesign:1});
		        	}
			    	break;
			    case "btn_ca_kind_detail": 
			    	ComOpenPopup("ESM_BKG_0758_POP.do?pgmNo=ESM_BKG_0758", 300, 400, "", '1,0,1,1,1', true);
			    	break;
				case "btn_print":
	      	    	// mandatory condition check
	      	    	if(formObject.oldBkgNo.value.trim() == "") {
	      	    		ComBkgNessMessage(formObject.bkg_no); 
	      	    		return false;
	      	    	}
	      	    	if(sheetObject1.RowCount()== 0) {
		        		ComShowCodeMessage("BKG00394"); 
		        	    return;
		        	}
					RdPrint();
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
    	}
    }
   /**
     * setting tab object
     * @param tab_obj
     * @return
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
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
    * initializing Tab
    * setting Tab items
    */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "General", "");
					InsertItem( "Freight & Charge", "");
					InsertItem( "Customer Information", "");
 				    //BaseColor = "#F3F2F8";
                }
             break;
        }
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form; 
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        
        //RD Init
//        initRdConfig(rdObjects[0]);   
        //initParam(); 
        if (formObj.bkg_no.value != "") {
	   		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	   	} 
        if (formObj.popFlg.value == "Y") {
        	ComEnableManyTd(true, "btn_close");
        } else {
        	ComEnableManyTd(false, "btn_close");
        }
    }
    
 	/**
     * handling process for OnKeyPress
     */
// 	function obj_keypress_loc() {
// 		switch(event.srcElement.dataformat){
// 	       case "float":
// 	           //only Number + "."
// 	           ComKeyOnlyNumber(event.srcElement, ".");
// 	           break;
// 	       case "eng":
// 	           //only Alphabet, Alphabet+Number -> ComKeyOnlyAlphabet('num');
// 	           ComKeyOnlyAlphabet();
// 	           break;
// 	       case "engdn":
// 	           //only lower case of Alphabet, lower case of Alphabet+Number -> ComKeyOnlyAlphabet('lowernum');
// 	           ComKeyOnlyAlphabet('lower');
// 	           break;
// 	       case "engup":
// 	           //only upper cae of Alphabet
// 	           ComKeyOnlyAlphabet('upper');
// 	           break;
// 	       case "int":
// 	           //only number (Decimal, Date, Time)
// 	           ComKeyOnlyNumber(event.srcElement);
// 	           break;
// 	       case "uppernum":
// 	           //only upper case of Alphabet + Number
// 	           ComKeyOnlyAlphabet('uppernum'); 
// 	           break;
// 	       case "tel":
// 		        // only Number + "-"
// 		        ComKeyOnlyNumber(event.srcElement, "-"); 
// 		        break;
// 	    }
// 	}
 	/**
      * handling process for KeyUp
      */
// 	function obj_keyup() {
// 		var formObj=document.form;
// 		with (formObj) {
// 			if ( window.event.keyCode == 13 ) {
// 				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
// 			}
// 		}
// 	}
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
			    with(sheetObj){
	        		  var HeadTitle="|C/A No.|C/A OFC|Contract OFC|C/A Date|C/A Usr ID|Reason|Class|Class|Exempt"+
				      "|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind||";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Radio",     Hidden:0, Width:21,   Align:"Center",  ColMerge:0,   SaveName:"radio",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Left",    ColMerge:0,   SaveName:"ca_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"corr_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"corr_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"corr_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ca_rsn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rat_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"expn_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"doc_perf_expt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rt_corr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chg_term_corr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcvde_term_corr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_corr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_corr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"qty_corr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"meas_qty_corr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_corr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trnk_vsl_corr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prpst_vsl_corr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ca_otr_rsn_corr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_corr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      			InitColumns(cols);
		      			SetEditable(1);
		      			SetCountPosition(0);
		      			SetSheetHeight(122);
		       }
		    break; 
		    
	        case "t1sheet1":      //t1sheet1 init
	            with(sheetObj){
			          var HeadTitle="Correction Items|Correction Items|Previous|Current";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"item_hdr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"his_cate_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"pre_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"crnt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			           
			          InitColumns(cols);
			          SetEditable(0);
			          SetCountPosition(0);
			          SetSheetHeight(202);
	             }
		    break;
		    
			case "t2sheet1":      //t2sheet1 init
			    with(sheetObj){
			      var HeadTitle="|FRT|P/T|Rated As|Curr.|Rate|Amount|Term|Prepaid|Collect|Third";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:"corr_name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rat_as_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chg_ut_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"chg_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"frt_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prepaid",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"collect",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"third",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
				      InitColumns(cols);
				      SetEditable(0);
				      SetCountPosition(0);
				      SetSheetHeight(202);
			      }
		    break;
		    
		    case "t3sheet1":      //t3sheet1 init
		        with(sheetObj){
			         var HeadTitle=" | |Previous|Current";
			         var headCount=ComCountHeadTitle(HeadTitle);
			         SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			         var headers = [ { Text:HeadTitle, Align:"Center"} ];
			         InitHeaders(headers, info);
			         var cols = [ {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"item_hdr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"his_cate_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"pre_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"crnt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			         InitColumns(cols);
			         SetEditable(0);
			         SetCountPosition(0);
			         SetSheetHeight(202);
	            }
		    break;
		    
     		case "msgsheet1":      //msgsheet1 init : msg grid
     		    with(sheetObj){
	     	          var HeadTitle="";
		     	      var headCount=ComCountHeadTitle(HeadTitle);
		     	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		     	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		     	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		     	      InitHeaders(headers, info);
		     	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		     	      InitColumns(cols);
		     	      SetEditable(0);
		     	      SetWaitImageVisible(0);
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
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
      	    	//Mandatory Check 
      	    	if(formObj.bkg_no.value.trim() == "" && 
      	    	   formObj.bl_no.value.trim()  == "" && 
      	    	   formObj.ca_no.value.trim()  == "") {
      	    		ComBkgNessMessage(formObj.bkg_no); 
      	    		return false;
      	    	}
      	    	if (sheetObj.id=="sheet1") {  
      	    		formObj.f_cmd.value=SEARCH; 
      	    		
      	    		var sXml=sheetObj.GetSearchData("ESM_BKG_0567GS.do", FormQueryString(formObj));
      	    		
					var arrXml=sXml.split("|$$|");
					if(ComGetEtcData(arrXml[0], "DataYn") == "N") {
//						sheetObjects[4].LoadSearchData(arrXml[0],{Sync:0} );
						//clear
				    	formObj.remark.value="";
				    	sheetObjects[0].RemoveAll();
				    	sheetObjects[1].RemoveAll();
				    	sheetObjects[2].RemoveAll();
				    	sheetObjects[3].RemoveAll();
				    	setEtcDataToForm_clear();			    	
						return;
					} 
		            if (arrXml.length > 0) 
					{
		            	sheetObjects[0].RemoveAll();
		            	sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
		            }
      	    	} else if (sheetObj.id=="t1sheet1") {
	      	    	formObj.f_cmd.value=SEARCH01; 
	      	    	var sXml=sheetObj.GetSearchData("ESM_BKG_0567GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");  
			    	//clear
			    	formObj.remark.value="";
			    	sheetObjects[1].RemoveAll();
			    	sheetObjects[2].RemoveAll();
			    	sheetObjects[3].RemoveAll();
			    	//load
					sheetObjects[1].LoadSearchData(arrXml[0],{Sync:0} );
					sheetObjects[2].LoadSearchData(arrXml[1],{Sync:0} );
					sheetObjects[3].LoadSearchData(arrXml[2],{Sync:0} );
      	    	} 
                break;
        }
    }
    //######################[1. Event]############################################################
	/**
      * Sheet1 click event handling
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colId=sheetObj.ColSaveName(Col);
		
		if (colId == "radio") {
//			tab1.SetTabDisable(1, true);
//		   	tab1.SetTabDisable(2, true);
		   	
			formObj.bkg_no_mst.value=sheetObj.GetCellValue(Row, "bkg_no");
			formObj.ca_no_mst.value=sheetObj.GetCellValue(Row, "ca_no");
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			formObj.remark.value=nullToBlank(sheetObj.GetCellValue(Row, "bkg_corr_rmk"));
			
			var qtyCorrFlg = sheetObj.GetCellValue(Row, "qty_corr_flg");
			var custCorrFlg = sheetObj.GetCellValue(Row, "cust_corr_flg");
			
//			if(qtyCorrFlg == "F") {
//				tab1.SetTabDisable(1, false);
//			}
//			if(custCorrFlg == "E") {
//				tab1.SetTabDisable(2, false);
//			}
//			
//			tab1.SetTabDisable(0, false);
		}
	}    
    /**
	 * handling process after ending sheet1 retrieve
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
	   	if (ErrMsg != msgs['BKG00095']) 
	   	{
	   		setEtcDataToForm_bkg(formObj, sheetObjects[0]);  
		   	if (sheetObj.SearchRows()> 0) {
		   		var nRow=1; //sheetObj.RowCount();
		   	    sheetObj.SetCellValue(nRow, "radio",1);
		   	    sheetObj.SelectCell(nRow, "radio");
		   	    sheet1_OnClick(sheetObj, nRow, sheetObj.SaveNameCol("radio"), 1);
		   	} else {
		    	formObj.remark.value="";
		    	sheetObjects[1].RemoveAll();
		    	sheetObjects[2].RemoveAll();
		    	sheetObjects[3].RemoveAll();
		   	}
	   	}	   	
    }
    /**
	 * handling process after ending sheet2 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj=document.form;
	   	if (sheetObj.SearchRows()> 0) {
	   		sheetObj.RenderSheet(0);
	   		var strCorrNm="";	   		
	   		var bRgbColor=false;
    		for (var i=1; i<=sheetObj.RowCount(); i++) {
    			if (i==1) {
    				strCorrNm=sheetObj.GetCellValue(i, "corr_name");
    			}
    			if (strCorrNm != sheetObj.GetCellValue(i, "corr_name")) {
    				strCorrNm=sheetObj.GetCellValue(i, "corr_name");
	    		    bRgbColor=!bRgbColor;
	    		}
/*    			
        		if (bRgbColor) {
	    			sheetObj.SetRangeBackColor(i, 0, i, 10,"#FFFF00");
	    		} else {
	    			sheetObj.SetRangeBackColor(i, 0, i, 10,"#FFFFFF");
	    		}
*/
    			if (strCorrNm == "DIFFERENCE") {
    				sheetObj.SetRangeBackColor(i, 0, i, 10,"#BAEBB0F2CE");
    			} else if (strCorrNm == "PREVIOUS") {
    				sheetObj.SetRangeBackColor(i, 0, i, 10,"#555555");
    			} else {
    				sheetObj.SetRangeBackColor(i, 0, i, 10,"#FEF0FBE3F7");
    			}
    		}
	   		sheetObj.RenderSheet(1);
	   		//tabObjects[0].tabEnable(1)=true;
	   		tab1.SetTabDisable(1, false);
	   	} else {
	   		//tabObjects[0].tabEnable(1)=false;
	   		tab1.SetTabDisable(1, true);
	   	}
    }    
    /**
	 * handling process after ending sheet3 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	if (sheetObj.SearchRows()> 0) {
	   		//tabObjects[0].tabEnable(2)=true;
	   		tab1.SetTabDisable(2, false);
	   	} else {
	   		//tabObjects[0].tabEnable(2)=false;
	   		tab1.SetTabDisable(2, true);
	   	}
    }
    /**
     * tab change handling 
     * @param tabObj
     * @param nItem
     * @return
     */
    function tab1_OnChange(tabObj, nItem)
	{
		var formObj=document.form;
	    var objs=document.all.item("tabLayer");
		objs[nItem].style.display="inline";
		for ( var i = 0; i < objs.length; i++) {
			if (i != nItem) {
				objs[i].style.display="none";
				objs[i].style.zIndex=objs[nItem].style.zIndex -1 ;
			}
		}
//		beforetab=nItem;
	} 

	//######################[2. Etc]##############################################################
    /**
	 * Output Header (Booking Info)
	 * - view EtcData instance of ComEtcDataToForm()
	 * 
	 * @param formObj
	 * @param sheetObj
	 * @return
	 */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        with (formObj) 
        {	
        	oldBkgNo.value=sheetObj.GetEtcData("bkg_no");
        	oldBlNo.value=sheetObj.GetEtcData("bl_no");
        	oldCaNo.value=sheetObj.GetEtcData("ca_no");
        	bkg_no.value=sheetObj.GetEtcData("bkg_no");
        	bl_no.value=sheetObj.GetEtcData("bl_no");
        	ca_no.value=sheetObj.GetEtcData("ca_no");
        	cust_cnt_cd.value=sheetObj.GetEtcData("cust_cnt_cd");
        	cust_nm.value=sheetObj.GetEtcData("cust_nm");
        	cust_seq.value=sheetObj.GetEtcData("cust_seq");
        	sailed_vvd.value=sheetObj.GetEtcData("sailed_vvd");
        	t_vvd.value=sheetObj.GetEtcData("t_vvd");
        	por_cd.value=sheetObj.GetEtcData("por_cd");
        	pol_cd.value=sheetObj.GetEtcData("pol_cd");
        	del_cd.value=sheetObj.GetEtcData("del_cd");
        	pod_cd.value=sheetObj.GetEtcData("pod_cd");
        	por_nod_cd.value=sheetObj.GetEtcData("por_nod_cd");
        	pol_nod_cd.value=sheetObj.GetEtcData("pol_nod_cd");
        	del_nod_cd.value=sheetObj.GetEtcData("del_nod_cd");
        	pod_nod_cd.value=sheetObj.GetEtcData("pod_nod_cd");
        } 
    }
    /**
	 * Output Header (Booking Info)
	 * - clear EtcData instance of ComEtcDataToForm()
	 * 
	 * @param rdObject
	 * @return
	 */
    function setEtcDataToForm_clear() {
    	var formObj=document.form;
        //------------------------------
        //sheetEtcData -> Form 
        with (formObj) 
        {	
        	oldBkgNo.value=""; 
        	oldBlNo.value=""; 
        	oldCaNo.value="";        	
        	//bkg_no.value       = sheetObj.EtcData("bkg_no"); 
        	//bl_no.value        = sheetObj.EtcData("bl_no"); 
        	//ca_no.value        = sheetObj.EtcData("ca_no"); 
        	cust_cnt_cd.value=""; 
        	cust_nm.value=""; 
        	cust_seq.value=""; 
        	sailed_vvd.value=""; 	        
        	t_vvd.value=""; 
        	por_cd.value="";
        	pol_cd.value="";
        	del_cd.value="";
        	pod_cd.value="";
        	por_nod_cd.value="";
        	pol_nod_cd.value="";
        	del_nod_cd.value="";
        	pod_nod_cd.value="";        	
        } 
    }
    //#############################(3. Util/Etc)##################################################
    /**
	 * RD Setting
	 * 
	 * @param rdObject
	 * @return
	 */
//	function initRdConfig(rdObject){
//		var RdViewer=rdObject;
//		RdViewer.AutoAdjust=true;
//		RdViewer.HideStatusBar();
//		RdViewer.ViewShowMode(0); 
//		RdViewer.SetBackgroundColor(128,128,128);
//		RdViewer.SetPageLineColor  (128,128,128);
//	}    
	/**
	 * RD Print
	 * 
	 * @param
	 * @return
	 */
	function RdPrint() {
		var formObj=document.form;
		//var RdViewer = rdObjects[0];
		var rdUrl="apps/opus/esm/bkg/bookingcorrection/bdrcorrection/report/";
		//var rdOption   = " /riprnmargin";   //' /rwait'
		var rdFileName="";
		var rdParam="";		
		var strTitle="CA Inquiry";
		var sRow=sheetObjects[0].FindCheckedRow("radio");
		var arrRow=sRow.split("|");
		rdFileName="ESM_BKG_0182.mrd"; 
		rdParam="/rp ['"+sheetObjects[0].GetCellValue(arrRow[0], "bkg_no")+"'] ['"+sheetObjects[0].GetCellValue(arrRow[0], "ca_no")+"']";
		//RdViewer.FileOpen(RD_path + rdUrl + rdFileName, RDServer + rdParam + rdOption); 
		//when use common Popup, 
		formObj.com_mrdPath.value=rdUrl + rdFileName;
		formObj.com_mrdArguments.value=rdParam  + " /riprnmargin /rwait";
		formObj.com_mrdTitle.value=strTitle;
  		formObj.com_mrdBodyTitle.value=strTitle;
  		ComOpenRDPopupModal("dialogWidth:900px;dialogHeight:800px");
		/* : modal 
		  	    var goUrl="COM_RD_COMMON_POPUP.do";
		  		var param="?com_mrdPath="     +formObj.com_mrdPath.value+
		                    "&com_mrdArguments="+formObj.com_mrdArguments.value+
		                    "&com_mrdTitle="    +formObj.com_mrdTitle.value+
		                    "&com_mrdBodyTitle="+formObj.com_mrdBodyTitle.value+
		                    "&com_zoomIn="      +7;
		  		ComOpenWindowCenter(goUrl+param, "ESM_BKG_0567", 1200, 800, true);
		*/ 
		return true;
	}
 	/**
 	 * TD Button handling (Enable/Disable)
 	 * 
 	 * @param bEnable
 	 * @param objs
 	 * @return
 	 */
    function ComEnableManyTd(bEnable, objs) {
 	    try {
 	        var args=arguments;
 	        if (args.length < 2) return;
 	        for(var i=1; i<args.length; i++) {
 	 	    	if (bEnable == true) {
 		    		ComBtnEnable(args[i]);
 		    	} else {
 		    		ComBtnDisable(args[i]);
 		    	} 
 	        }
 	    } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function bkg0567_keydown(){
		 var keyValue=ComGetEvent("keycode");
		 var formObject=document.form;
		 if(keyValue == 13){
			 if (formObject.bkg_no.value != "") {
				try {
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				} catch(err) { ComFuncErrMsg(err.message); }
			 }
		 }
	 }
