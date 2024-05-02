/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.1
*@FileName   : esm_bkg_0566.js
*@FileTitle  : Booking History (B/L Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
//    var rdObjects=new Array();
    var rdCnt=0;
    //var queryStr = "";
    var xSearchTab1=false;
    var xSearchTab2=false;
    var xSearchTab3=false;
    var xSearchTab4=false;
    var rdPath;
    // Event handler processing by button click event */
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
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_print":
					RdPrint(viewer)
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
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
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
     * registering the created IBCombo Object at page as comboObjects list
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Tab option
     * setting tab list
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
					InsertItem( "All", "");
					InsertItem( "Fax/EDI", "");
					InsertItem( "Customs", "");
					SetSelectedIndex(0);
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        initControl();
        //initializing RD
        //주석 풀어야 함  initRdConfig(rdObjects[0]);   
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        //---------------
        //initializing IBMultiCombo
        for(var j=0;j<comboObjects.length;j++){
            initCombo(comboObjects[j],j+1);
        }
        //initParam();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
        
//        initRdConfig(rdObjects[0]);
//        initRdConfig();
    }
    function initCombo(comboObj, comboNo) {
     	with (comboObj) {
     		SetMultiSeparator("|");
         }
    }
    function initControl() {
    	var formObject=document.form;
        axon_event.addListenerForm('click', 'bkg0566_click',    formObject); //- in case of clicking
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
	        case "t1sheet1":      //t1sheet1 init
	            with(sheetObj){
			          var HeadTitle="|Item|Item|Now Read|Previous|User Name|Office|Date(Local)|Date(GMT)||||HIS_DTL_SEQ";
		
			          SetConfig( { SearchMode:0, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Text",      Hidden:1, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"his_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"item_hdr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"his_cate_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:210,  Align:"Left",    ColMerge:0,   SaveName:"crnt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"pre_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"office",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"gmt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"crnt_ctnt_org",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pre_ctnt_org",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"corr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"his_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			           
			          InitColumns(cols);
		
			          SetEditable(0);
			          SetCountPosition(0);
			          //ShowFilterRow();
			          SetSheetHeight(390);
	                }

		        break;
			case "t2sheet1":      //t2sheet1 init
			    with(sheetObj){
				      var HeadTitle=" |From|From|To|To|Via|Date|User|Office";
		
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:100, FrozenCol:1, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Text",      Hidden:0, Width:210,  Align:"Left",    ColMerge:1,   SaveName:"item",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"frm_a",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"frm_b",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"to_a",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"to_b",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"office",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"kind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetCountPosition(0);
				      SetSheetHeight(390);
		            }
		      break;
		    case "t3sheet1":      //t3sheet1 init
		        with(sheetObj){
				      var HeadTitle="Port|Port|Customs Status|Date(Local)|Date(GMT)|User|Office";
		
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"port",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"port_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:0,   SaveName:"cust_status_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mf_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"gmt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ofc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetCountPosition(0);
				      SetSheetHeight(390);
		            }

		        break;
			case "t4sheet1":      //t4sheet1 init
			    with(sheetObj){
			      var HeadTitle="Documentation|Date(Local)|Date(GMT)|Office|User|Remark|Reason";
	
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:1, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Text",      Hidden:0, Width:255,  Align:"Left",    ColMerge:1,   SaveName:"item",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"office",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"remark",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"reason",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetCountPosition(0);
			      SetSheetHeight(390);
		        }


		        break; 
		}
	}
    // handling sheet process
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="t1sheet1") {
	      	    	formObj.f_cmd.value=SEARCH;
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0566GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");  
		            if (arrXml.length > 0) 
					{
		                ComBkgXml2ComboItem(arrXml[1], search_by_item, "ud_nm", "ui_id");
		                search_by_item.SetSelectText("All");
		                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		                setEtcDataToForm_bkg(formObj, sheetObjects[0]);  
		            }
      	    	} else if (sheetObj.id=="t2sheet1") {
      	    		formObj.f_cmd.value=SEARCH02;
  	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj) );
      	    	} else if (sheetObj.id=="t3sheet1") {
      	    		formObj.f_cmd.value=SEARCH03;
  	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj) );
      	    	} else if (sheetObj.id=="t4sheet1") {
      	    		formObj.f_cmd.value=SEARCH04;
  	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj) );
      	    	}
                break;
        }
    }
    //######################[1. Event]############################################################    
    /**
     * process after retrieve t1sheet1
     */    
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	if (sheetObj.SearchRows()>0) {
    		sheetObj.RenderSheet(0);
    		sheetObj.SetColBackColor("item_hdr",sheetObj.GetHeaderBackColor());
    		sheetObj.SetColBackColor("his_cate_nm",sheetObj.GetHeaderBackColor());
    		sheetObj.SetColFontColor("item_hdr",sheetObj.GetHeaderFontColor());
    		sheetObj.SetColFontColor("his_cate_nm",sheetObj.GetHeaderFontColor());
    		
    		for (var i=1; i<=sheetObj.RowCount(); i++) {
    			if (sheetObj.GetCellValue(i, "crnt_ctnt") == "View Detail") {
    				sheetObj.SetCellFontUnderline(i, "crnt_ctnt",1);
	    		}
    			if (sheetObj.GetCellValue(i, "pre_ctnt") == "View Detail") {
 	    			sheetObj.SetCellFontUnderline(i, "pre_ctnt",1);
	    		}
    			if (sheetObj.GetCellValue(i, "his_seq") == "999999") {
	    			sheetObj.SetCellBackColor(i,"item_hdr","#F6E1EC");
	    			sheetObj.SetCellBackColor(i,"his_cate_nm","#F6E1EC");
	    		}
//    			if (sheetObj.GetCellValue(i, "via") == "T") {
//    				sheetObj.SetMergeCell(i,4,1,2);
//	    		}
    		}
    		sheetObj.RenderSheet(1);
    	}	
    	xSearchTab1=true;
    }    
    /**
    * process View Detail popup in case of clicking t1sheet1 
    */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
    	var colId=sheetObj.ColSaveName(Col);
    	if (colId == "crnt_ctnt" || colId == "pre_ctnt") {
    		if (Value == "View Detail") {
    			var bkgNo=formObj.bkg_no.value; 
	    		var blNo=formObj.bl_no.value; 
				var sheetRow=Row;
				var sheetIdx="0";
	    		comBkgCallPop0955('setHistoryDtlViewCallBack', bkgNo, blNo, sheetRow, sheetIdx);	
    		}
    	} 
    }
    /**
    * process after retrieve t2sheet1
    */    
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj=document.form;
	   	if (sheetObj.SearchRows()>0) {
	   		sheetObj.RenderSheet(0);
	   		sheetObj.SetColBackColor("item",sheetObj.GetHeaderBackColor());
	   		sheetObj.SetColFontColor("item",sheetObj.GetHeaderFontColor());
	   		for (var i=1; i<=sheetObj.RowCount(); i++) {
	   			if (sheetObj.GetCellValue(i, "via") == "FTP") {
	   				sheetObj.SetMergeCell(i,1,1,4);
	   			}else if (sheetObj.GetCellValue(i, "via") == "EMAIL"){
	   				if(sheetObj.GetCellValue(i, "kind") == "TE" || sheetObj.GetCellValue(i, "kind") == "TU") {
	   					sheetObj.SetMergeCell(i,1,1,4);
	   				}
	   			}
	   		}
	   		sheetObj.RenderSheet(1);
	   	}
	   	xSearchTab2=true;
	   	
    }
    /**
    * process after retrieve t3sheet1
    */    
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj=document.form;
	   	if (sheetObj.SearchRows()>0) {
	   		sheetObj.RenderSheet(0);
	   		sheetObj.SetColBackColor("port_a",sheetObj.GetHeaderBackColor());
	   		sheetObj.SetColBackColor("port_b",sheetObj.GetHeaderBackColor());
	   		sheetObj.SetColFontColor("port_a",sheetObj.GetHeaderFontColor());
	   		sheetObj.SetColFontColor("port_b",sheetObj.GetHeaderFontColor());
	   		sheetObj.RenderSheet(1);
	   	}	
	   	xSearchTab3=true;
    }
    /**
    * process after retrieve t4sheet1 
    */    
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj=document.form;
	   	if (sheetObj.SearchRows()>0) {
	   		sheetObj.RenderSheet(0);
	   		sheetObj.SetColBackColor("item",sheetObj.GetHeaderBackColor());
	   		sheetObj.SetColFontColor("item",sheetObj.GetHeaderFontColor());
	   		sheetObj.RenderSheet(1);
	   	}	
	   	xSearchTab4=true;
    } 
    /**
    * Tro master : event handling in case of changing selected search_by_item combo
    */
    function search_by_item_OnChange(comboObj, oldindex, oldtext , oldcode , newindex , text , idx_cd) {
    	var formObj=document.form; 
    	var sheetObj=sheetObjects[0]; 

//    	sheetObj.RenderSheet(0);
		
		if ( text == "All"){
    		for (var i=1; i<=sheetObj.RowCount()+1; i++) {
    			sheetObj.SetRowHidden(i,0);
    		}
		} else {
		
			for (var i=1; i<= sheetObj.RowCount()+1; i++) {
				if ( sheetObj.GetCellValue( i , "item_hdr") == text ){
					sheetObj.SetRowHidden(i,0);
				} else {
					sheetObj.SetRowHidden(i,1);
				}
			}
			
		}
		//sheetObj.RenderSheet(1);
    } 
   /**
	* event in case of clicking tab
	* activating selected tab
	*/   
	function tab1_OnChange(tabObj, nItem)
	{
		var formObj=document.form;
	    var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- important ----------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
		if (tabObjects[0].GetSelectedIndex()== 1) {
            if (!xSearchTab2) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            search_by_item.SetEnable(0);
		} else if (tabObjects[0].GetSelectedIndex()== 2) {
            if (!xSearchTab3) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            search_by_item.SetEnable(0);
		} else if (tabObjects[0].GetSelectedIndex()== 3) {
            if (!xSearchTab4) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            search_by_item.SetEnable(0);
		} else{
			search_by_item.SetEnable(1);
		}

	} 
	//######################[2. Etc]##############################################################
    /**
    * showing Header(Booking info) 
    * : showing EtcData
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        //IBS_EtcDataToForm(formObj, sheetObj);
        with (formObj) 
        {
        	bkg_no.value=sheetObj.GetEtcData("bkg_no");
        	n1st_vvd.value=sheetObj.GetEtcData("n1st_vvd");
        	trnk_vvd.value=sheetObj.GetEtcData("trnk_vvd");
        	bl_no.value=sheetObj.GetEtcData("bl_no");
        	n1st_pol.value=sheetObj.GetEtcData("n1st_pol");
        	trnk_pol.value=sheetObj.GetEtcData("trnk_pol");
        	port_closing.value=sheetObj.GetEtcData("port_closing");
        	n1st_etb.value=sheetObj.GetEtcData("n1st_etb");
        	trnk_etb.value=sheetObj.GetEtcData("trnk_etb");
        	bdr_dt.value=sheetObj.GetEtcData("bdr_dt");
        	n1st_etd.value=sheetObj.GetEtcData("n1st_etd");
        	trnk_etd.value=sheetObj.GetEtcData("trnk_etd");
        }        
    }
	/**
	 * Booking History : calling Detail View popup. <br>
	 */
	function comBkgCallPop0955(callback_func, bkgNo, blNo, sheetRow, sheetIdx) {
		var param="?bkg_no="+bkgNo
		          + "&bl_no="+blNo
		          + "&sheet_row="+sheetRow
		          + "&sheet_idx="+sheetIdx;
		var sUrl="ESM_BKG_0955.do"+param;
        ComOpenWindowCenter(sUrl, "ESM_BKG_0955", 900, 400, true); 
	}  
    //#############################(3. Util/Etc)##################################################
    /**
	 * setting Rd
	 */
//	function initRdConfig(){
//	   var Rdviewer=rdObjects[0] ;
//	   RdViewer.style.height = 0; 
//	   RdViewer.SetBackgroundColor(128,128,128);
//	   RdViewer.SetPageLineColor(128,128,128);
//	   RdViewer.AutoAdjust = true;
//	   RdViewer.ViewShowMode(0);
//	}    
	
	/**
	 * sending selected key to RD(*.mrd)
	 */
	function RdPrint(rdObject) {
//		initRdConfig();
		
		var formObj = document.form;
		var RdViewer = viewer;
//		RdViewer.SetAppendReport(0);
//		RdViewer.ApplyLicense("0.0.0.0");
		var rdUrl = "apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/";
		var rdFileName = "";
		var rdParam="";		
		if (tabObjects[0].selectedIndex == 1) {
			rdFileName = "ESM_BKG_0800.mrd";
			rdParam="/rp ['"+formObj.bkg_no.value+"']";
		} else if (tabObjects[0].selectedIndex == 2) {
			rdFileName = "ESM_BKG_0801.mrd";
			rdParam="/rp ['"+formObj.bkg_no.value+"']";
		} else if (tabObjects[0].selectedIndex == 3) {
			rdFileName = "ESM_BKG_0802.mrd";
			rdParam="/rp ['"+formObj.bkg_no.value+"']";
		} else {
			rdFileName = "ESM_BKG_0799.mrd";
			rdParam="/rp ['"+formObj.bkg_no.value+"'] ['"+search_by_item.GetSelectText()+"']";
		}
		
		var appendReport = [];
		var mrdPath = RD_path+"apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/"+rdFileName;
		var mrdParam = RDServer + rdParam;
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);
		
//		RdViewer.openFile(RD_path + rdUrl + rdFileName, RDServer + rdParam + " /riprnmargin /rwait",{timeout:3000}); 
//		viewer.print({isServerSide:true});
		
		
		return true;
	}	
	
	 function bkg0566_click(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0]; 
    	var srcName=ComGetEvent("name");
    	if(srcName == "ca_only"){
        	with(sheetObj) {
        		RenderSheet(0);
    	    	for (var i=1; i<=RowCount(); i++) {
    	    		if (GetCellValue(i, "corr_no").length == 0) {
        	    		if(ComGetObjValue(formObj.ca_only) == "Y"){
	    	    		    SetRowHidden(i,1);
	    	    		} else {
	    	    			SetRowHidden(i,0);
	    	    		}
    	    		} 
//    	    		else {
//        	    		if(ComGetObjValue(formObj.ca_only) == "Y"){
//	    	    		    SetRowHidden(i,0);
//	    	    		} else {
//	    	    			SetRowHidden(i,1);
//	    	    		}
//    	    		}
    	    	}
    	    	RenderSheet(1);
        	}    		
    	}
	 }
	 function getViewDetail(obj){
		 var sheetObj=sheetObjects[0]; 
		 var iRow=sheetObj.GetSelectRow();
		 var crntCtnt=sheetObj.GetCellValue(iRow, obj);
		 return crntCtnt;
	 }
