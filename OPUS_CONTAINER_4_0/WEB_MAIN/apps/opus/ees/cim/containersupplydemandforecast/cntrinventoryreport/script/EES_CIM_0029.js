/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0029.jsp
*@FileTitle  : Stock Report (CNTR Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
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
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_Downexcel":
            		if(sheetObj.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            			}else{
            				sheet1.Down2Excel({ HiddenColumn:true});
            			}

                    break;
                case "btn_Close":
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
                 with(sheetObj){
                
              var HeadTitle1="Yard|CNTR No.|TP/SZ|Damage|DMG Flg DT|DMG Unflg DT|Term|BKG No.|VVD|Gate In";

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                  {Type:"CheckBox",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",  KeyField:0,   CalcLogic:"",   Format:"" },
                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                  {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetSheetHeight(275);
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
 	    	   sheetObj.DoSearch("EES_CIM_0029GS.do",FormQueryString(formObj) );
	    	   ComOpenWait(false);
	    	   break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    /**
     * handling process after retrieving
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject=document.form;
    	var obj_cntr_tpsz_cd=formObject.obj_cntr_tpsz_cd.value;
    	obj_cntr_tpsz_cd=obj_cntr_tpsz_cd.split("|")
    	var cnt_cntr_tpsz_cd=sheetObj.GetCellValue(sheetObj.LastRow(), "cntr_no");
    	cnt_cntr_tpsz_cd=cnt_cntr_tpsz_cd.split("|");
    	var totStr="";
    	for ( var i=0; i<cnt_cntr_tpsz_cd.length; i++) {
    		if ( cnt_cntr_tpsz_cd[i] > 0 ) {
    			totStr=totStr + obj_cntr_tpsz_cd[i] +" : "+ComAddComma(eval(cnt_cntr_tpsz_cd[i]))+",  ";
    		}
    	}
    	totStr=totStr.trim().substr(0,totStr.length-3);
    	formObject.total_cnt.value=ComAddComma(sheetObj.RowCount()-1);
    	formObject.total.value=totStr;
    	sheetObj.RowDelete(sheetObj.LastRow(),false);
    //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
    }
     /**
      * event when clicking cell
      * setting background color for selected row
      */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	    
