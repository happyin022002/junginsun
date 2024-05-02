/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0008.js
*@FileTitle : KPI Target 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_SPE_0008 : business script for ESD_SPE_0008
     */
    /* The common global variables */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  	/**
	 * Initializing IBTab object
	 * Calling this function before calling loadPage() function in setupPage()
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
				TabBackColor(0, "146,174,230");
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  	}
  	/**
  	 * Calling this function when occurring onchange event in tab1
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing the content of the clicked tab in case of clicking IBTab object.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.SetBackColor("#FFFFFF");
  		tabObj.SetTabBackColor(nItem, "146,174,230");
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		beforetab=nItem;
  	}
  	/**
  	 * Registering IBSheet Object as list
  	 * Adding process for list in case of needing batch processing with other items
  	 * Defining list on the top of source
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
  	}
     /**
       * setting sheet initial values and header
       * param : sheetObj, sheetNo
       * adding case as numbers of counting sheets 
       */
      function initSheet(sheetObj,sheetNo) {
          var cnt=0;
          switch(sheetNo) {
              case 1:      //IBSheet1 init
            	    with(sheetObj){
            	        var HeadTitle=" ||EG ID|EG Name||KPI|Prior Year|Prior Year|Target|Target|Portion (%)||||" ;
            	        var HeadTitle1=" ||EG ID|EG Name||KPI|Performance| Target |||Portion (%)||||" ;

            	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	        var headers = [ { Text:HeadTitle, Align:"Center"},
            	                    { Text:HeadTitle1, Align:"Center"} ];
            	        InitHeaders(headers, info);

            	        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Status",    Hidden:1, Width:5,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eg_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eg_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"sp_kpi_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"sp_kpi_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"per",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"target",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"kpi_tgt_rto",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
            	               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"kpi_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	               {Type:"Int",       Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"kpi_wgt_rto",  KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
            	               {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"eg_rhq_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"eg_cty_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"svc_cate_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	               {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ev_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
            	         
            	        InitColumns(cols);

            	        SetEditable(1);
	                    SetRangeBackColor(1,6, 1,9,"#555555");// ENIS
            	        SetSheetHeight(260 );
            	        SetEditEnterBehavior("down");
            	        SetColProperty("kpi_ut_cd", {ComboText:"%|PT|MM", ComboCode:"PC|PO|MM"} );
        	        }
                  break;
          }
      }
  	/* Event handler processing by button click event */
  	document.onclick=processButtonClick;
  /* Event handler processing by button name */
      function processButtonClick(){
           var sheetObject=sheetObjects[0];
           var formObject=document.form;
           try {
      		  var srcName=ComGetEvent("name");
      		  if (srcName == "" || srcName == undefined) return false;
      		  if(ComGetBtnDisable(srcName)) return false;
              switch(srcName) {
          	    case "btn_retrieve":
      	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
          	    case "btn_print":
          	        break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
    // Handling the process about the sheet
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
          switch(sAction) {
             case IBSEARCH:      //Retrieving
                   if(validateForm(sheetObj,formObj,sAction)){
  	                if(!ComChkRequired(formObj)) return;
             		formObj.f_cmd.value=SEARCH;
             		var param=speFormString(formObj,'f_cmd,eg_id,ev_yr,eg_rhq_cd,eg_cty_cd,svc_cate_cd,mapped');
             		sheetObj.DoSearch("ESD_SPE_0008GS.do",param );
                  }
                  break;
  			case IBSAVE:		//Saving             
	  			if(!validateForm(sheetObj,formObj,sAction)) {
		            return false;
		        } //end if
		        formObj.f_cmd.value=MULTI;	
		       var param=speFormString(formObj,'f_cmd');
		       sheetObj.DoSave("ESD_SPE_0008GS.do", param);
  				break;
          }
      }
  	/**
  	 * Calling this function in case of finishing to retrieve sheet data
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var formObject=document.form;
		var eg_id_sheet=sheetObj.GetCellValue(2,'eg_id');
		var eg_rhq_cd_sheet=sheetObj.GetCellValue(2,'eg_rhq_cd');
		var eg_cty_cd_sheet=sheetObj.GetCellValue(2,'eg_cty_cd');
		var svc_cate_cd_sheet=sheetObj.GetCellValue(2,'svc_cate_cd');
  		if(eg_id_sheet == ''){
  			eg_id_sheet=sheetObj.GetEtcData("eg_id_db");
  			eg_rhq_cd_sheet=sheetObj.GetEtcData("eg_rhq_cd");
  			eg_cty_cd_sheet=sheetObj.GetEtcData("eg_cty_cd");
  			svc_cate_cd_sheet=sheetObj.GetEtcData("svc_cate_cd");
  		}
  		formObject.eg_id.value=eg_id_sheet;
  		formObject.eg_rhq_cd.value=eg_rhq_cd_sheet;
  		formObject.eg_cty_cd.value=eg_cty_cd_sheet;
  		formObject.svc_cate_cd.value=svc_cate_cd_sheet;
  		sheetObj.ShowSubSum([{StdCol:2, SumCols:"10", Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"1=;5=TotalweightofaboveServiceCategory"}]);
  		for(i=0; i<=sheetObj.RowCount(); i++){
  			var code=sheetObj.GetCellValue(i,"sp_kpi_cd");
  			if(code == "TMLP"){
  				sheetObj.SetCellEditable(i, "kpi_tgt_rto",0);
  				sheetObj.SetCellEditable(i, "kpi_ut_cd",0);
  			}
  		}
  	}
  	function sheet1_OnChange(sheet1,row,col){
  		if (sheet1.ColSaveName(col) == "kpi_wgt_rto" ){
  			sheet1.ShowSubSum([{StdCol:2, SumCols:"10", Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"1=;5=TotalweightofaboveServiceCategory"}]);
  		}
  		if (sheet1.ColSaveName(col) == "kpi_tgt_rto" ){
  			var target=sheet1.GetCellValue(row,col);
  			if(target > 999.99){
  				ComShowCodeMessage('COM12133','The value of target','999.99','less');	
  				sheet1.SetCellValue(row,col,0,0);
  			}
  		}
  		if (sheet1.ColSaveName(col) == "kpi_wgt_rto" ){
  			var portion=sheet1.GetCellValue(row,col);
  			if(portion > 100){
  				//The value of portion 100 must be.
  				ComShowCodeMessage('SPE10005','100');	
  				sheet1.SetCellValue(row,col,0,0);
  			}
  		}
  	}
     /**
       * Handling the process for the input validation
       */
      function validateForm(sheetObj,formObj,sAction){
          with(formObj){
  	        switch(sAction){
  	        	case IBSAVE : 
  	        		var rows=(sheetObj.FindSubSumRow(2)).split('|');
  	        		for(i=0; i<rows.length-1; i++){
  	        			var total=sheetObj.GetCellValue(rows[i],10);
  	        			if(total != 100){
  	        				ComShowCodeMessage('COM12133','For each EG ID, the sum of portion','100','greater');
  	        				return false;
  	        			}
  	        		}
  	        		for(k=0; k<rows.length-1; k++){
  	        			for(j=2; j<sheetObj.RowCount()+1; j++){
  	        				if(j!=Number(rows[k])){
  	        					if(sheetObj.GetCellValue(j,"sp_kpi_cd") != "TMLP" && sheetObj.GetCellValue(j,8) == "0"){
  	        						ComShowCodeMessage('COM12113','Target');
  	        						return false;
  	        					}else if(sheetObj.GetCellValue(j,"sp_kpi_cd") == "TMLP"){
  	        						if(sheetObj.GetCellValue(j,9) == null || sheetObj.GetCellValue(j,9)==""){
  	        							sheet1.SetCellValue(j,9,"PC",0);
  	        						}
  	        					}
  	        				}
  	        			}
  	        		}
  	        	break;
  	        	case IBSEARCH:
  	        		if(formObj.eg_id.value == null || formObj.eg_id.value == ""){
          			 	if((formObj.eg_rhq_cd.value != null && formObj.eg_rhq_cd.value != "")
          					&& (formObj.svc_cate_cd.value != null && formObj.svc_cate_cd.value != "")
          					&& (formObj.eg_cty_cd.value != null && formObj.eg_cty_cd.value != "")){
          					return true;
          				}else if((formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == "")
          					&& (formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == "")
          					&& (formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == "")){ 
          					ComShowCodeMessage('COM12113','The conditions of retrieval');
          					return false;
          				}else if(formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL1');
          				 	return false;
          				}else if(formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL2');
          				 	return false;
          				}else if(formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL3');
          				 	return false;
          				}
          			 }
  	        	break;
  	        }
          }
          return true;
      }
