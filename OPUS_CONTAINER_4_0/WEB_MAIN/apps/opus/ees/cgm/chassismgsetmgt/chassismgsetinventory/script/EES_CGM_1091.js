/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CGM_1091.js
*@FileTitle  : Chassis Inventory List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 2009.07.09
     */ 
    function processButtonClick(){
        /***** use additional sheet var in case of more than 2 tap each sheet *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_downexcel":
                	if(sheetObject1.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                	}
                	
                    break;
                case "btn_close":
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
         	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
         	//
            ComEndConfigSheet(sheetObjects[i]);
         }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
 	/**
 	 * setting sheet initial values and header <br>
 	 * adding case as numbers of counting sheets <br>
 	 * @param  {object} sheetObj		 Sheet Object
 	 * @param  {int} sheetNo		
 	 * @return 
 	 * @author 
 	 * @version 2009.07.09
 	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
	              var HeadTitle="|Seq.|Chassis No.|TP/SZ|Term|AGMT No.|Lessor|MVMT|LCC|SCC|Yard|On-Hire Date|MVMT Date|L/S Days";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
			                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lsdays",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetColProperty(0,"chss_mvmt_dt", {Format:"####-##-####:##"} );
	              SetColProperty(0,"onh_dt", {Format:"####-##-####:##"} );
	              SetSheetHeight(430);
              }
                break;
         }
     }
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return 
     * @author 
     * @version 2009.07.09
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
	            // Form Object value setting
                formObj.f_cmd.value=SEARCH;
                formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
		 		//sheetObj.WaitImageVisible=false;
		 		//ComOpenWait(true);                
                ComOpenWait(true,false);
	     		// retrieve
 	     		var sXml=sheetObj.GetSearchData("EES_CGM_1091GS.do" , FormQueryString(formObj));
	     		sheetObj.LoadSearchData(sXml,{Sync:1} );
		 		ComOpenWait(false);	     		
                break;
            case IBDOWNEXCEL:        //down excel
 				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
        }
    }
 	/**
 	 * detailpage double click -> Equipment No M.G.Set Master Inquiry page show <br>
 	 * 
 	 * @author 
 	 * @version 2009.10.28
 	 */   
 	 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
 	 {
 	 	var formObject=document.form;
     	if(Row >= 1)
      	{
     		if(sheetObj.GetCellValue(Row, "eq_no") == null || sheetObj.GetCellValue(Row, "eq_no") == "")
  			{
  				return;
  			}
     		var eqNo=sheetObj.GetCellValue(Row, "eq_no");
     		var seq=sheetObj.GetCellValue(Row, "Seq");
  			if(seq != ''){
  		  		var pgmNo='EES_CGM_1003';
  		  		var pgmUrl='/opuscntr/EES_CGM_1003.do';
  		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
  		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	//var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
//  		    	ComOpenPopup("opusMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);
  		    	window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src);
  		    	
//				var param="?pgmNo=EES_CGM_1003";
//	   			param=param + "&pgmNo="+pgmNo+"&eq_no="+eqNo; 
//	   		    ComOpenPopup('/opuscntr/EES_CGM_1003_POP.do' + param, 1080, 600, "", "1,0", true, false);
  			}
      	}
 	 }          
	/* developer job end */
