/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0058.jsp
*@FileTitle  : Priority Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var validateData="";
var retValidate=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Customer Event handler processing by button name
 * 
 * 
 **/
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_apply":
   	              doActionIBSheet(sheetObject,formObject,IBSAVE);
         	      break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	       break;
                case "btn_downexcel":
                   doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                with (sheetObj) {
	               var HeadTitle="No.|STS|Priority|ORG.LOC|Node|DEST.LOC|Node|Route " ;
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prio_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_loc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_loc_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:470,  Align:"Left",    ColMerge:0,   SaveName:"route",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ori_prio_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                
	               InitColumns(cols);
	               SetEditable(1);
	               SetWaitImageVisible(0);
	               SetColProperty("prio_seq", {ComboText:"|", ComboCode:"|"} );
	               SetSheetHeight(ComGetSheetHeight(sheetObj, 11));
               }
                break;
        }
    }
  // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction));
	            ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST;
                sheetObj.DoSearch("ESD_PRD_0058GS.do", PrdFQString(formObj), {Sync:2} );
                priority_seq=sheetObjects[0].GetEtcData("prio_seq_combo");
                sheetObjects[0].InitDataCombo (0, "prio_seq", sheetObjects[0].GetEtcData("prio_seq_combo"),sheetObjects[0].GetEtcData("prio_seq_combo"));
                maxPrioSeq=sheetObjects[0].GetEtcData("maxPrioSeq");
                sheetObj.DoSearch("ESD_PRD_0058GS.do", PrdFQString(formObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction));
            	ComOpenWait(true);
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESD_PRD_0058GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;
           case IBDOWNEXCEL:        
        	   if(sheetObj.RowCount() < 1){//no data
        		   ComShowCodeMessage("COM132501");
        		   }else{
//        			   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
                	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
        		   }
                break;
        }
    }
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        if(sheetObj.ColSaveName(Col)=="prio_seq" && Value ==0 ){
        	sheetObj.SetCellValue(Row,"prio_seq",sheetObj.GetCellValue(Row,"ori_prio_seq"),0);
            ComShowMessage("Not select Value 0."    );
            return false;
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
    function sheet1_OnSaveEnd(sheetObj,errMsg)  {
         //var iRow = document.form.openSheetRow.value;
    	if(errMsg=="" || errMsg == "Data was saved successfully." || errMsg == "Saved data successfully."){
            var openerSheet=window.opener.document.sheet1 ;
            for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow() ; i++){
				if(openerSheet.FindText("rout_seq", sheetObj.GetCellValue( i, "rout_seq") , 0,-1) != -1){
					openerSheet.SetCellValue( openerSheet.FindText("rout_seq", sheetObj.GetCellValue( i, "rout_seq") , 0,-1), "prio_seq" ,sheetObj.GetCellValue( i, "prio_seq") ,0);
					if(openerSheet.GetRowStatus(openerSheet.FindText("rout_seq", sheetObj.GetCellValue( i, "rout_seq") , 0,-1))=='U'){
						openerSheet.GetRowStatus(openerSheet.FindText("rout_seq", sheetObj.SetCellValue( i, "rout_seq") , 0,-1),'R');
                     	}
                    }
            }
            ComClosePopup(); 
         } else {
             ComShowMessage(ComGetMsg('COM12151',''));
             ComClosePopup(); 
         }
    }    
