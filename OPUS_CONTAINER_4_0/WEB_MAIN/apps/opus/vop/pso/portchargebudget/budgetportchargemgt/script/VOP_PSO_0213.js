/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0213.js
*@FileTitle : Expense Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_PSO_0213 : business script for VOP_PSO_0213
     */
    function VOP_PSO_0213() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				break;
				case "btn_DownExcel":
					
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}
					
					break;
				case "btn_ok":
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
            for(i=0;i<sheetObjects.length;i++){
            		doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }
        }

      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
          var cnt=0;
    			var sheetid=sheetObj.id;
          switch(sheetid) {
    				case "sheet1":
    				    with(sheetObj){
    			      
    			      var HeadTitle1="|Revenue\nMonth|Lane|VVD|Terminal\nCode|Status|Account\nCode|Cost\nCode|S/P\nCode|IN/OUT|Curr.|Amount|USD Amount|Accrual Cost|SYS_SRC_ID|ESTM_SEQ_NO|Formula\nDescription|Formula\nExpression|acct_eng_nm|lgs_cost_full_nm|vndr_nm";
    			      var headCount=ComCountHeadTitle(HeadTitle1);
    			      var prefix="sheet1_";

    			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    			      InitHeaders(headers, info);

    			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"expn_yrmon",     KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io_bnd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:prefix+"inv_usd_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"accl_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sys_src_id" },
    			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"estm_seq_no" },
    			             {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , MultiLineText:true},
    			             {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"xpr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , MultiLineText:true},
    			             {Type:"Text",      Hidden:1,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"acct_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:1,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm",KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:1,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    			       
    			      InitColumns(cols);

    			      SetEditable(0);
    			      //SetCountPosition(0);
    			      SetHeaderRowHeight(40);
    			      //SetDataRowHeight(45);
    			      SetSheetHeight(400);
    			      }
    			break;
            }
        }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
          case IBSEARCH:      //Retrieving
           	if(validateForm(sheetObj,formObj,sAction)){
				if ( sheetObj.id == "sheet1"){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("VOP_PSO_0213GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
					
					
				}
           	}
          	break;
        }
    }
    
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        ComOpenWait(false);
    }
    
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet1_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        if(prefix+"acct_cd" == selColName){
        	sText=sheetObj.GetCellText(Row, prefix+"acct_eng_nm");    
        }else if(prefix+"lgs_cost_cd" == selColName){
        	sText=sheetObj.GetCellText(Row, prefix+"lgs_cost_full_nm");        	
        }else if(prefix+"vndr_seq" == selColName){
        	sText=sheetObj.GetCellText(Row, prefix+"vndr_nm");        	
        }else{
        	sText=sheetObj.GetCellText(Row,Col);
        }
        //sText=sheetObj.GetCellText(Row,Col);
        if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }
    } 

	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var prefix="sheet1_";
		var colname=sheetObj.ColSaveName(Col);
		switch (colname) {
			case prefix+ "foml_desc":
			case prefix+ "xpr_desc":
				var tmpValue = sheetObj.GetCellValue(Row, Col);
				if(!ComIsEmpty(tmpValue)){
					ComShowMemoPad(sheetObj, Row, Col, true, 800, null, null,1);
				}
				break;
		}
		
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }

