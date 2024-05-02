/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0031.js
*@FileTitle  : Stock Report (Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var headCnt=0;
var tot_cntr_tpsz_cd="";
var obj_cntr_tpsz_cd="";
var comboObjects=new Array();
var comboCnt=0 ;
var save_flag=false;
var IBSEARCH01=29;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
         var shtCnt=0;
         var sheet1=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Close":
					ComClosePopup(); 
					break;
                case "btn_downexcel":
                	if(sheet1.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                		}else{
                			sheet1.Down2Excel({ HiddenColumn:true});
                		}
                    break;
        		case "btn_save":
        			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1); 
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id ; 
        switch(sheetID) {
             case "sheet1":      //sheet1 init
                with (sheetObj) {
            	    var HeadTitle1="Yard|TP/SZ|Available|Sound|Damage|Total|Due Out|Due In|Optimum|Variance||";
            	    headCnt=HeadTitle1.split("|").length;
            	    SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
            	    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	    InitHeaders(headers, info);
            	    var cols = [ {Type:"Text",   Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aval_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"snd_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"tot_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"due_out_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"due_in_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
            	              {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vari_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
            	              {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            	              {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"AutoSum",   Hidden:1, Width:0,  Align:"Left",    ColMerge:1}];
            	    InitColumns(cols);
            	    SetEditable(1);
            	    SetEditableColorDiff(0);
            	    SetSheetHeight(265);
                }
                break; 
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) { 
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:    
	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   sheetObj.SetWaitImageVisible(0);
	    	   ComOpenWait(true); 	    	   
	    	   formObj.f_cmd.value=SEARCH;
	    	   sheetObj.DoSearch("EES_CIM_0031GS.do",FormQueryString(formObj) );
	    	      	   
	    	   break;
           case IBSAVE: 
	    	   if(validateForm(sheetObj,formObj,sAction))
	    	   formObj.f_cmd.value=MULTI;
	    	   sheetObj.DoSave("EES_CIM_0031GS.do",FormQueryString(formObj),"ibflag",true);
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
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	   	if (!ComChkValid(formObj)) return false;
        }
        return true;
    }
    /**
     * end of retrieving Tab1 
     * calling event after retrieving Tab1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	 ComOpenWait(false); 	
       	var formObject=document.form;
//		sheetObj.SetEditableColor("#000000");
//no support[check again]CLT 		sheetObj.UnEditableColor="#000000";
      	if ( sheetObj.RowCount()!= 0 ) {
		   	for ( var j=0; j<headCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
		   		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"cntr_qty"),",","")) >= 0 ) {
		   			sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#0000FF");
				} else {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#FF0000");
				}
		   		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"vari_qty"),",","")) >= 0 ) {
		   			sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#0000FF");
				} else {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#FF0000");
				}
			}
		   	sheetObj.RowDelete(sheetObj.LastRow()-1, false);
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
	    	sheetObj.SetCellValue(sheetObj.LastRow(),"loc_cd",'G.Total');
	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
      	}
//      no support[implemented common]CLT 	
      	sheetObj.SelectHighLight=false;

    }
    /**
     * setting value from Location by loc_cd popup
     */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject=sheetObjects[0];
       var formObject=document.form;
       formObject.loc_cd.value=aryPopupData[0][3] 
    }
    /**
     * event when inputing key on cell
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	
     * @param {ibsheet} col     	
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "cntr_qty":
    			setCaluValue(sheetObj, Row, Col);
    			break;
    	}
    }
    /**
     * Variance = Available - applying Optimum calculation logic
    */    
	function setCaluValue(sheetObj, Row, Col) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vari_qty",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "aval_qty") - sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_qty"),0);
		var tot_pos_cntr_qty=0;	//total by Yard
		var tot_row_cntr_qty=0;	
		var tot_cntr_qty=0;
		var tot_pos_vari_qty=0;	//total by Yard
		var tot_fos_tpsz_row=0;
		var tot_row_vari_row=0;
		var tot_fos_tpsz_row=0;
		var tot_vari_qty=0;
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
			if ( sheetObj.GetCellValue(i, "loc_cd") == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "loc_cd") && sheetObj.GetCellValue(i, "lvl") != "01"  ) {
				tot_pos_cntr_qty=tot_pos_cntr_qty + ComReplaceStr(eval(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_pos_vari_qty=tot_pos_vari_qty + ComReplaceStr(eval(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.GetCellValue(i, "loc_cd") == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "loc_cd") && sheetObj.GetCellValue(i, "lvl") == "01"  ) {
				tot_row_cntr_qty=i;
			}
			if ( sheetObj.GetCellValue(i, "cntr_tpsz_cd") == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_tpsz_cd") && sheetObj.GetCellValue(i, "lvl") == "00" ) {
				tot_fos_tpsz_row=tot_fos_tpsz_row + eval(ComReplaceStr(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_row_vari_row=tot_row_vari_row + eval(ComReplaceStr(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
			if ( sheetObj.GetCellValue(i, "cntr_tpsz_cd") == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_tpsz_cd") && sheetObj.GetCellValue(i, "lvl") == "10" ) {
				tot_row_tpsz_row=i;
			}
		}
		sheetObj.SetCellValue(tot_row_cntr_qty, "cntr_qty",tot_pos_cntr_qty,0);
		sheetObj.SetCellValue(tot_row_tpsz_row, "cntr_qty",tot_fos_tpsz_row,0);
		sheetObj.SetCellValue(tot_row_cntr_qty, "vari_qty",tot_pos_vari_qty,0);
		sheetObj.SetCellValue(tot_row_tpsz_row, "vari_qty",tot_row_vari_row,0);
		sheetObj.SetRowStatus(tot_row_cntr_qty,"R");
		sheetObj.SetRowStatus(tot_row_tpsz_row,"R");
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
			if ( sheetObj.GetCellValue(i, "lvl") == "10"  ) {
				tot_cntr_qty=tot_cntr_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "cntr_qty"),",",""));
				tot_vari_qty=tot_vari_qty + eval(ComReplaceStr(sheetObj.GetCellValue(i, "vari_qty"),",",""));
			}
		}
		sheetObj.SetCellValue(sheetObj.LastRow(), "cntr_qty",tot_cntr_qty,0);
		sheetObj.SetCellValue(sheetObj.LastRow(), "vari_qty",tot_vari_qty,0);
		if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"cntr_qty"),",","")) >= 0 ) {
			sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#0000FF");
		} else {
			sheetObj.SetCellFontColor(sheetObj.LastRow(),"cntr_qty","#FF0000");
		}
	if ( eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.LastRow(),"vari_qty"),",","")) >= 0 ) {
		sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#0000FF");
		} else {
			sheetObj.SetCellFontColor(sheetObj.LastRow(),"vari_qty","#FF0000");
		}
		sheetObj.SetCellValue(sheetObj.LastRow(), "loc_cd","G.Total",0);
		sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
		if ( eval(sheetObj.GetCellValue(Row, "vari_qty")) >= 0 ) {
			sheetObj.SetCellFontColor(Row,"vari_qty","#0000FF");
		} else {
			sheetObj.SetCellFontColor(Row,"vari_qty","#FF0000");
		}		
	}
    /**
     * handling after saving 
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	save_flag=true;
    	if ( ErrMsg == "" ) {
        	callParentFnc();
    		ComShowCodeMessage("CIM30019");
    	}
      	sheetObj.SetCellValue(sheetObj.LastRow(), "loc_cd","G.Total",0);
      	sheetObj.SetCellValue(sheetObj.LastRow(), "cntr_tpsz_cd","G.Total",0);
      	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
      	sheetObj.RenderSheet(1);
    }
    /**
     * setting value and calling calculation FUNCTION 
     */
    function callParentFnc() {
		if ( save_flag ) { 
	    	var opener_obj=window.dialogArguments;
	    	if (!opener) opener_obj = parent;
	    	opener_obj.popupCloseEnd();	  //retrieving EES_CIM_0028
		} 
    }
	/**
	 * converting data to 0 in case of null
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if (Col ==8) {	
    		if ( sheetObject.GetCellValue(Row,Col) == '' ) {	// prohibiting null in int format data
	    		sheetObject.SetCellValue(Row,Col,0,0);
	    	}
    	}
    }  
	/**
	 * event when clicking cell
	 * setting background color for selected row
	 */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	    
