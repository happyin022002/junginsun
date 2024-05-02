/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0102.js
*@FileTitle  : TPB Office Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================

    /* Global Variables */
    var currSheetObj=null;
    var currLayer=5;
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tempValue="";
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
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','1', new Array("s_ofc_cd_for_rhq","s_office_level") );
		s_if_rhq_cd_OnChange();
	}
	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
	function InitTab(tabObj, tabNo) {
		try {
			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
			}
			tabObj.SetSelectedIndex(0);
		}catch(e){
			ComShowMessage(e.message);
		}
	}
	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
	function ChangeTab(tabObj,nItem){
		 formObject = document.form;
    	 var objs=document.all.item("tabLayer");
    	 objs[nItem].style.display="Inline";
    	 for(var i = 0; i< objs.length; i++){
        	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
        	  }
    	}
    	beforetab=nItem;
	}
	
	function getComboText(){
		return $("#s_n3pty_ofc_tp_cd option:selected").text();
	}
	
	function getComboValue(){
		return $("#s_n3pty_ofc_tp_cd option:selected").val();
	}
	
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8=true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init "H"
			    with(sheetObj){
				      var cnt=0;
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Deleted flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      SetSheetHeight(530);
		            }
				break;
			case 2:	  //IBSheet2 init "R"
			    with(sheetObj){
				      var cnt=0;
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
	                  SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      SetColProperty("ofc_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      SetSheetHeight(530);
		            }
				break;
			case 3:	  //IBSheet3 init "S"
			    with(sheetObj){ 
				      var cnt=0;
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      SetSheetHeight(530);
		            }
				break;
			case 4:	  //IBSheet4 init "C" : Control Office
			    with(sheetObj){
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      SetSheetHeight(530);
		            }
				break;
			case 5:	  //IBSheet4 init "T"
			    with(sheetObj){
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      
				      SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      SetColProperty(0 ,"n3pty_ctrl_ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      SetColProperty(0 ,"n3pty_ar_ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      
				      SetSheetHeight(530);
		            }
				break;
			case 6:	  //IBSheet5 init "G"
			    with(sheetObj){
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date|AR_HD_QTR_OFC_CD|IS SAVE";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 }, 
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"is_save",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 }];
				      
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				      
				      SetColProperty(0 ,"n3pty_ofc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      
				      SetSheetHeight(530);
		            }
				break;
			case 7:	  //IBSheet2 init "A" : A/R Office
			    with(sheetObj){
				      var cnt=0;
				      var HeadTitle="STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      SetColProperty("n3pty_ofc_tp_cd", {ComboText:getComboText(), ComboCode:getComboValue()} );
				      SetColProperty("rhq_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
					  SetColProperty("ofc_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
					  SetSheetHeight(530);
		            }
				break;
		}
	}
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
	function processButtonClick(){
		var sheetObject=sheetObjects[currLayer-1 + curTab-1];
		var formObject=document.form;
		if(curTab == 2)
			formObject=document.form2;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_cancel":
					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_remove":
					break;
				case "btn_preview":
					sheetObject.ExcelPrint="PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObject.ExcelPrint="";
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
					break;
				case "btn_print":
					sheetObject.ExcelPrint="PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			} // end switch
		}catch(e) {			
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('COM12111'));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/* Processing Sheet */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		currSheetObj=sheetObj;
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TPB_0102GS.do", tpbFrmQryStr(formObj), {Sync:1} );
				break;
			case IBSAVE:		//Save
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESD_TPB_0102GS.do", {Param:tpbFrmQryStr(formObj), Sync:1});
				
				break;
			case IBINSERT:	  //Insert
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row,'delt_flg','N',0);	
				sheetObj.SetCellValue(Row,'is_save','N',0);	
				
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //Excel download
				sheetObj.Down2Excel(TPBDown2ExcelOptions);
				break;
		}
	}
	/**
	 * Checking validation of input value
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		   if(!ComChkValid(formObj)) return false;
		}
		return true;
	}
	/**
     * handling process after ending sheet1 retrieve
     */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	}
	
	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}
	
	function sheet2_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}	
	
	function sheet3_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}	
	
	function sheet4_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}		
	
	function sheet5_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}	

	function sheet6_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(ComGetMsg('COM12149','Data','',''));
		}
		
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}	
	
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var url="ESD_TPB_0804.do?f_cmd="+SEARCH+"&rhq_cd="+sheetObj.GetCellValue(Row, "rhq_cd");
		var rtnValue =  ComOpenWindow(url,  window,  "scroll:no;status:no;help:no;dialogWidth:300px;dialogHeight:140px" , true);
		if(rtnValue != undefined && rtnValue != ""){
			sheetObj.SetCellValue(Row, sheetObj.ColSaveName(Col),rtnValue);
		}		
	}
	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 */	
 	function sheet1_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	// Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'), Value);
			}
 		}
 	}
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	function sheet3_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	function sheet4_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	function sheet5_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
//	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
				getTPBGenCombo('CheckRegOffice3','checkRegOffice3','V','','',new Array('s_ofc_cd_reg'),Value);
			}
 		}
 	}
 	function sheet6_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
  		tempValue = Value;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 		
 		if( colNm == 'n3pty_ofc_cd' && Value != '' )
 		{
			document.form.s_ofc_cd_reg.value=Value;
			getTPBGenCombo('CheckRegOffice3','checkRegOffice3','V','','',new Array('s_ofc_cd_reg'),Value);
 		
 		} 	
 		
 	}
 	
  function rhqHoCheck(){
		getTPBGenCombo('CheckRegOffice2','checkRegOffice2','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd_t'), tempValue);
  }	
 	
 	function sheet7_OnChange(sheetObj, Row, Col, Value){
 		var colNm=sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt=0;
 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount();i++)
			{
	 			temp=sheetObj.GetCellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			if( cnt > 1 )	//Checking screent dupliaction
			{
				ComShowCodeMessage('TPB90105');
				sheetObj.SetCellValue(Row,'ofc_cd','',0);
			} else	//Checking DB duplication
			{
				document.form.s_ofc_cd_reg.value=Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
	function s_if_rhq_cd_OnChange(){
		var f=document.form;
		getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','1', new Array("s_if_rhq_cd","s_office_level"));
	}
	/**
	 * Changing result grid template by TPB Office Type Code combobox onChange event
	 */
	function n3pty_ofc_tp_cd_OnChange(v) {
		//_____change templete____
		switch(v) {
			case "H": v=1; break;
			case "R": v=2; break;
			case "S": v=3; break;
			case "C": v=4; break;
			case "T": v=5; break;
			case "G": v=6; break;
			case "A": v=7; break;
		}
		
		sheetObjects[v-1].SetColProperty("n3pty_ofc_tp_cd" ,{ComboText:getComboText(), ComboCode:getComboValue()});
		
		var i=1;
		for( i=1 ; i<8 ; i++){
			eval("document.all.layer"+i).style.display="none";
		}
		eval("document.all.layer"+v).style.display="";
		
		if(document.getElementById("btn_add")!=null && document.getElementById("btn_add")!=undefined){
			if(v==6){//현재 MDM에서 다가지고 옴으로 
				document.getElementById("btn_add").style.display="none";
				
			}else{
				document.getElementById("btn_add").style.display="";
			}
		}
		
		currLayer=v;
		//_____change templete____
		//_____init Old Templete____
		if( currSheetObj != null ){
			if( currSheetObj.RowCount()> 0 ){
//				currSheetObj.Reset();
				currSheetObj.RemoveAll();
//				for(i=0;i<sheetObjects.length;i++){
//					ComConfigSheet(sheetObjects[i]);
//					initSheet(sheetObjects[i],i+1);
//					ComEndConfigSheet(sheetObjects[i]);
//				}
			}
		}//_____init Old Templete____
		ComClearCombo(document.form.s_if_ofc_cd);
		if ( v==5 ){
		    document.form.s_if_rhq_cd.disabled=false;
		    document.form.s_if_ofc_cd.disabled=false;
		    s_if_rhq_cd_OnChange();
		} else {
		    document.form.s_if_rhq_cd.value="";
		    document.form.s_if_ofc_cd.value="";
		    document.form.s_if_rhq_cd.disabled=true;
		    document.form.s_if_ofc_cd.disabled=true;
		} 
	}
	
	
	
	/* Finishing work */