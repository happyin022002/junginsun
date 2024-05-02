/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0026.js
*@FileTitle  : Allocation History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_SPC_0026 : business script for ESM_SPC_0026
     */
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    //type check
    var type_check;
    //retrive check
    var check_retrive=false;
    var tab_retrives=null;
    var searchParams="";
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         /***** setting additional sheet value in case of more 2 sheet per tab *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
   try {
    		var srcName=ComGetEvent("name");
    		 if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_retrieve":
//        			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
//        			sheetObjects[0].RemoveAll();
//        			sheetObjects[1].RemoveAll();
        			
   	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
    	            break;
				case "btn_new":
					if(checkModifiedSheet(sheetObjects)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//using common funtion : initializing the screen
					resetAll();
					break;
        	    case "btn_downexcel":
        	    	if(sheetObjects[beforetab].RowCount() < 1){//no data
        	    		ComShowCodeMessage("COM132501");
        	    	}else{
        	    		doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
        	    	}
   	            	
        	        break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setComboObject(combo_obj){
		comObjects[comboCnt++]=combo_obj;
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
     * tab1_OnChange 
     * 
     */
    function tab1_OnChange(tabObj , nItem)
    {
	    var formObj=document.form;
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
    	beforetab=nItem;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        tab_retrives=new Array(sheetObjects.length);
        var tdisp="block";
        for(i=0;i<sheetObjects.length;i++){
            // change the name of start environment setting function
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            // Adding last environment setting function
            ComEndConfigSheet(sheetObjects[i]);
            initDataSelection(i);
        }
        var sheetResizeFull=true;
		document_onresize();
		var formObject=document.form;
    	var comObj=salesOffice;
        	if(comObj.GetItemCount() <= 1){
    	    	comObj.SetSelectIndex(0);
        		var comObj1=subOffice;
    		if(comObj.GetSelectCode()!= comObj1.GetSelectCode()){
    			comObj1.SetEnable(0);
    		}
    	}
		var rtn=getCodeList("ChildOffice", "ofc_cd="+ofc_cd+"&level=4");
		initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));
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
				initSheet1(sheetObj);
                break;
            case 2:      //sheet1 init
				initSheet2(sheetObj);
                break;
        }
    }
	/**
     * Changing title after retrieving TabSheet1
     */
	function initSheet1(sheetObj){
	       with (sheetObj) {
	            //setting height
            	//SetSheetHeight(100 );
	            //setting width
	            //SheetWidth=mainTable[beforetab].clientWidth;
	       }
	}
    /**
     * Changing the title after retrieving it in TabSheet2
     */
    var sheet2=new Object();
	function initSheet2(sheetObj){
	    with(sheetObj){
	      var comObj=document.getElementById("salesOffice");
	      var HeadTitle1="Modefied Date(UTC)|Modified By|Office|POL|POD|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|lvl|";
	      var HeadTitle2="Modefied Date(UTC)|Modified By|Office|POL|POD|TEU|HC|45'|53'|RF|WT|Total TEU|TEU|HC|45'|53'|RF|WT|Total TEU |20'|40'|HC|45'|53'|RF|WT|lvl|";
	      var cnt=0;
//	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0} ); );
	      SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7} );
	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);
	      var cols = [ 
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"aloc_gdt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"user_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"aloc_lod_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_40ft_hc_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_45ft_hc_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_53ft_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_rf_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"aloc_ttl_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_40ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_45ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_53ft_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_rf_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_ttl_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_53ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"usd_bkg_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetEditable(0);
//	      SetSheetHeight(500);
	      resizeSheet();
	      SetHeaderRowHeight(10);
	      //InitTreeInfo("lvl", "", "#0000FFNAN");
		}
	}
	function t1sheet2_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "pol_yd_cd":
    	case "pod_yd_cd":
//    		var mark=sheetObj.GetCellValue(row, col);
//    		var status=sheetObj.GetRowStatus(row);
//    		if(mark == "+"){
//   				sheetObj.SetRowExpanded(row,1);
//   				sheetObj.SetCellValue(row, col,"-",0);
//    		}
//    		else if(mark == "-"){
//   				sheetObj.SetRowExpanded(row,0);
//   				sheetObj.SetCellValue(row, col,"+",0);
//    		}
//    		break;
    		var mark=sheetObj.GetCellValue(row, col);
    		var status=sheetObj.GetRowStatus(row);
    		if(mark == "+"){
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,0);
					if(sheetObj.ColSaveName(col) == "pol_yd_cd" && sheetObj.GetCellValue(startRow, "pod_yd_cd") == '+'){
						startRow = sheetObj.GetMergedEndCell(startRow,"pol_yd_cd").split(",")[0] ;	
					}
				}
   				sheetObj.SetCellValue(row, col, "-", 0);
//   				sheetObj.SetCellValue(row, "ibflag", status, 0);
    		}
    		else if(mark == "-"){
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,1);
				}
   				sheetObj.SetCellValue(row, col, "+", 0);
//   				sheetObj.SetCellValue(row, "ibflag", status, 0);
    		}
    		sheetObj.SetDataMerge();
    		break;
    	}
    }
   	function toggleExpand(sheetObj, row, col){
   		var mark=sheetObj.GetCellValue(row, col);
		if(sheetObj.GetRowExpanded(row)){
			sheetObj.SetRowExpanded(row,0);
			ChangeValue2(sheetObj, row, col, "+");
		}
		else{
			sheetObj.SetRowExpanded(row,1);
			ChangeValue2(sheetObj, row, col, "-");
		}
   	}
    function initDataSelection(sheetNo){
    	if(sheetNo == 1){
    		changeDataSelection(document.getElementsByName("chkDs2OFC"),[0]);
            changeDataSelection(document.getElementsByName("chkDs2POL"),[0]);
			changeDataSelection(document.getElementsByName("chkDs2POD"),[0]);
			changeDataSelection(document.getElementsByName("chkDs2HC"),[0]);
			changeDataSelection(document.getElementsByName("chkDs245"),[0]);
			changeDataSelection(document.getElementsByName("chkDs253"),[0]);
			changeDataSelection(document.getElementsByName("chkDs2RF"),[0]);
			changeDataSelection(document.getElementsByName("chkDs2WT"),[0]);
    	}
    }
	function changeDataSelection(tobj, internal){
		if(internal == undefined || internal == null){
			internal == false;
		}
		var sheetObj=sheetObjects[beforetab];
		var obj=null;
		if(tobj == undefined || tobj == null){
			tobj=null;
			obj=event.srcElement;
		}
		else{
			obj=tobj;
		}
		var sts=obj.checked;
		switch(ComGetEvent("name")){
		case "chkDs2OFC":
	    case "chkDs2POL":
		case "chkDs2POD":
		controlTreeFnc(sheetObj);
		break;
		case "chkDs2HC":
		    sheetObj.SetColHidden("aloc_40ft_hc_qty",!sts);
		    if(!document.form.chkDs245.checked && !document.form.chkDs253.checked) 
		       sheetObj.SetColHidden("fcast_ttl_qty",!sts);// showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU.
		    sheetObj.SetColHidden("fcast_40ft_hc_qty",!sts);
		    sheetObj.SetColHidden("usd_bkg_40ft_hc_qty",!sts);
			break;
		case "chkDs245":
		    sheetObj.SetColHidden("aloc_45ft_hc_qty",!sts);
		    if(!document.form.chkDs2HC.checked && !document.form.chkDs253.checked) 
		        sheetObj.SetColHidden("fcast_ttl_qty",!sts);// showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU.
		    sheetObj.SetColHidden("fcast_45ft_hc_qty",!sts);
		    sheetObj.SetColHidden("usd_bkg_45ft_hc_qty",!sts);
			break;
		case "chkDs253":
		    sheetObj.SetColHidden("aloc_53ft_qty",!sts);
		    if(!document.form.chkDs2HC.checked && !document.form.chkDs245.checked) 
		        sheetObj.SetColHidden("fcast_ttl_qty",!sts);// showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU.
		    sheetObj.SetColHidden("fcast_53ft_qty",!sts);
		    sheetObj.SetColHidden("usd_bkg_53ft_qty",!sts);
			break;
		case "chkDs2RF":
		    sheetObj.SetColHidden("aloc_rf_qty",!sts);
		    sheetObj.SetColHidden("fcast_rf_qty",!sts);
		    sheetObj.SetColHidden("usd_bkg_rf_qty",!sts);
			break;
		case "chkDs2WT":
		    sheetObj.SetColHidden("aloc_ttl_wgt",!sts);
		    sheetObj.SetColHidden("fcast_ttl_wgt",!sts);
		    sheetObj.SetColHidden("usd_bkg_ttl_wgt",!sts);
			break;
		}
	}
	function controlTreeFnc(sheetObj){
		var sheetObj1=sheetObjects[beforetab];
		var formObj=document.form;
		var sts1= true ;// formObj.chkDs2OFC.checked ;
		var sts2= formObj.chkDs2POL.checked;
		var sts3= formObj.chkDs2POD.checked;
		var rowCnt = sheetObj.RowCount() + 2;	
		// tree 기능 제거
//		sheetObj1.ShowTreeLevel(sts3?3:(sts2?2:1));
		if(sts1){
//			ChangeValue(sheetObj, "lvl", "1", "pol_cd", "1", " >= 0");
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 1) {
					sheetObj.SetRowHidden(i, 0);
				}
			}
		}else{
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 1) {
					sheetObj.SetRowHidden(i, 1);
				}
			}
			
		}
		if(sts2){
			changeValueFnc(sheetObj1, "lvl", "1", "pol_yd_cd", "-");
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 2) {
					sheetObj.SetRowHidden(i, 0);
					}
				}
		}else{
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 2) {
					sheetObj.SetRowHidden(i, 1);
				}
			}
			
		}

		if(sts3){
			changeValueFnc(sheetObj1, "lvl", "2", "pod_yd_cd", "-");
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 3) {
					sheetObj.SetRowHidden(i, 0);
					}
				}
		}else{
			for(var i=0 ; i < rowCnt ; i++){
				var lvl = sheetObj.GetCellValue(i, "lvl")*1 ;
				if (lvl == 3) {
					sheetObj.SetRowHidden(i, 1);
				}
			}		
		}
//		ShowRow(sheetObj1, "lvl", 1);
//		if(!sts1)HideRow(sheetObj1, "lvl", 1);
//		if(!sts2)HideRow(sheetObj1, "lvl", 2);
//		if(!sts3)HideRow(sheetObj1, "lvl", 3);
		sheetObj.SetColHidden("pod_yd_cd",!sts3);
		sheetObj.SetColHidden("pol_yd_cd",!sts2&&!sts3);
		sheetObj.SetDataMerge();
		return true;
    }
    function HideRow(sheetObj, col, val){
    	with(sheetObj){
    		var frow=-1;
    	while((frow=FindText(col, val, frow + 1)) >= 0){
    			SetRowHidden(frow,1);
    		}
    	}
    }
    function changeValueFnc(sheetObj, col, val, sCol, sVal){
    	with(sheetObj){
    		var frow=-1;
    		while((frow=FindText(col, val, frow + 1)) >= 0){
    			var status=sheetObj.GetRowStatus(frow);
    			SetCellValue(frow, sCol,sVal,0);
    		}
    	}
    }
	function changeDataSelectionTpSzAll(idx){
		changeDataSelection(document.getElementsByName("chkDs"+idx+"HC")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"45")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"53")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"RF")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"WT")[0]);
	}
	/**
	 * Converting the value of sCol to the value of sVal in the row which col is same as val .
	 */
	function ChangeValues2(sheetObj, col, val, sCol, sVal){
		with(sheetObj){
			var frow=-1;
			while((frow=FindText(col, val, frow + 1)) >= 0){
				var status=sheetObj.GetRowStatus(frow);
				SetCellValue(frow, sCol,sVal,0);
				sheetObj.SetRowStatus(frow,status);
			}
		}
	}
	function ChangeValue2(sheetObj, row, col, val){
		with(sheetObj){
		    SetCellValue(row, col,val,0);
		}
	}
	function ChangeValue3(sheetObj, row, col, val){
		with(sheetObj){
			SetCellValue(row, col,val);
		}
	}
    //Handling the process related with Sheet
    function doActionIBSheet(sheetObj,formObj,sAction, quite) {
    	if(quite == undefined) quite=false;
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                sheetObj.ReDraw=false;
                var param=SpcFormString(formObj,'vvd,ioc,salesOffice,subOffice');
                var rtn = sheetObj.GetSearchData("ESM_SPC_0026GS.do", "f_cmd="+(SEARCHLIST01 + beforetab)+"&"+ param  );
                
                sheetObj.ReDraw=true;     
                sheetObj.LoadSearchData(rtn , {Sync:1});
                controlTreeFnc(sheetObj);
				break;
			case IBDOWNEXCEL:        //Excel download              
//				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1});
              break;
        }
    }
	var selectedCell_OldValue=0;
    function t1sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    	selectedCell_OldValue=sheetObj.GetCellValue(row, col)*1;
    }
	function t1sheet1_OnChange(sheetObj, row, col, value){
	}
	
	
	
	
	function salesOffice_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if(newCode == "") return;
		var rtn=getCodeList("ChildOffice", "ofc_cd="+newCode+"&level=5&include=1");
		initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));				
	} 
	function initDataValue_salesOffice(){
	    var sheetObj=salesOffice;
	    with(sheetObj){
	        Index2=0;
	    }
	}
	function initData_salesOffice(codes, names){
	    var sheetObj=salesOffice;
	    var cnt=0;
	    with(sheetObj){
	        RemoveAll();
	        sheetObj.SetTitle("Office|Name");
	        sheetObj.SetColWidth(0, "60");
	        sheetObj.SetColWidth(1, "250");
	        sheetObj.SetColAlign(0, "left");
	        sheetObj.SetColAlign(1, "left");
	        sheetObj.SetMultiSelect(0);
	        sheetObj.SetMaxSelect(1);
	        sheetObj.SetDropHeight(190);
	        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	        if(codes == undefined || codes == null){
	        	return;
	        }
	        if(codes.length > 2){
	        	sheetObj.InsertItem(-1, "|ALL", "");
	        }
	    	var selectCode="";
		    for(var i=0 ; i < codes.length - 1 ; i++){
		    	var txt=names[i].split("~");
		    	if(txt[1] == "1"){
		    		selectCode=codes[i];
		    	}
		    	sheetObj.InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
		    }
		    if(selectCode != ""){
//		    	sheetObj.SetSelectCode=selectCode;
		    	sheetObj.SetSelectCode(selectCode);
		    }
		    else{
//		    	sheetObj.Index=0;
		    	sheetObj.SetSelectIndex("0", false);
		    }
			SetEnable((sheetObj.GetItemCount() > 1));
	    }
	}	
	function initData_subOffice(codes, names){
	    var sheetObj=subOffice;
	    var cnt=0;
	    with(sheetObj){
	        RemoveAll();
	        SetTitle("Office|Name");
			SetColWidth(0, "60");
			SetColWidth(1, "250");
			SetColAlign(0, "left");
			SetColAlign(1, "left");;
	        SetMultiSelect(0);
	        SetMaxSelect(1);
	        SetDropHeight(190);
	        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
		        if(codes == undefined || codes == null){
	        	return;
	        }
	        if(codes.length > 1){
	        	InsertItem(-1, "|ALL", "");
	        }
	    	var selectCode="";
		    for(var i=0 ; i < codes.length - 1 ; i++){
		    	var txt=names[i].split("~");
		       	if(txt[1] == "1"){
		    		selectCode=codes[i];
		    	}
		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
		    }
		    if(selectCode != ""){
		    	 Code=selectCode;
		    }
		    else{
		    	Index=0;
		    }
			SetEnable((GetItemCount() > 1));
			SetEnable(!(Index > 1));
	    }
	}
	function initDataValue_subOffice(){
	    var sheetObj=subOffice;
	    with(sheetObj){
	        Index2=0;
	    }
	}
	function Clearcombo(){
      var comObj1=salesOffice;
	  var comObj2=subOffice;
	  salesOffice.SetSelectCode("");
	  subOffice.SetSelectCode("");
	  comObj1.enable=false;
	  comObj2.enable=false;
	}
	function chk_combo(){
	  var comObj1=salesOffice;
	  var comObj2=subOffice;
	  comObj1.enable=true;
	  comObj2.enable=true;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        var vvd=formObj.vvd.value;
        if(vvd="" || vvd.length < 9){
        	ComShowCodeMessage("COM12174", "VVD", "9");
            formObj.vvd.focus();
            return false;
        }
        var sales_ofc=comObjects[0].GetSelectCode();
        var chk_nycna=document.all.id_chk_nycna.checked
        var chk_hamur=document.all.id_chk_hamur.checked
        if(sales_ofc == ""  && ( chk_nycna == false && chk_hamur == false) ){
        	ComShowMessage(getMsg("SPC90114", "Sales Office"));
            document.form.vvd.focus();
            //comObjects[0].focus();
            return false;                   
        }
        return true;
    }
    function optionSetting() {    
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    }

