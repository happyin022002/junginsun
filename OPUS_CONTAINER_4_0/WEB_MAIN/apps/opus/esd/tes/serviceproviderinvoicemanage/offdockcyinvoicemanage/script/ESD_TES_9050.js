/**
 * @fileoverview Off-Dock CY Container List
 * @author
 */
/**
 * @extends Tes
 * @class ESD_TES_9050 : Off-Dock CY Container List
 */
// Common variables.
var sheetObjects=new Array();
var sheetCnt=0;
/* Defining button events. */
document.onclick=processButtonClick;
/* Handling button event. */
    function processButtonClick(){
         /***** Setting each tab's sheet variable. *****/
         /*******************************************************/
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_ok":
    	            ComShowMessage ("btn_ok button click");
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage (ComGetMsg('TES23028'));
    		} else {
    			ComShowMessage (e);
    		}
    	}
    }
	/**
	 * Register IBSheet object on sheetObjects array.
	 * @return     
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * Coding event handler for body tag's OnLoad.
    * Add  pre-process functions after loading by browser.
    * @return
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    }
    /**
    * Initialize sheets.
    * @param {ibsheet} sheetObj IBSheet Object
    * @param {int} sheetNo
    * @return
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
						var HeadTitle="Cost Group|Cost Code|Amount";
						SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ 
						  {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"calc_cost_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
						    
						InitColumns(cols);
						SetSheetHeight(240);
						SetEditable(1);
						//ShowSubSum([{StdCol:0, SumCols:"2"}]);
						ShowSubSum([{StdCol:"calc_cost_grp_cd", SumCols:"2", Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"SubTotal"}]);
						//, Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"calc_cost_grp_cd=;lgs_cost_cd=SubTotal"
						SetColProperty("calc_cost_grp_cd", {ComboText:"TMNLCost|StoragebyDay|StoragebyPool", ComboCode:"TM|SD|SP"} );
               	}
                break;
        }
    }
    /**
    * Coding retrieve, save...
    * @param {ibsheet} sheetObj 	IBSheet Object
    * @param {form} formObj		Form Object
    * @param {int} sAction			f_cmd
    * @return
    */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  // retrieve
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value=SEARCHLIST;
			    sheetObj.DoSearch("ESD_TES_9050Popup.do", tesFrmQryStr(formObj) );
			    break;
		}
	}
    /**
	 * Validating input value.
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} formObj		Form Object
	 * @param {int} sAction			f_cmd
	 * @return
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}
	 /**
	  * After completing sheet retrieve, functions.
	  * @param {ibsheet}	main_hidden	Coincidence sheet
	  * @param {string}	ErrMsg		error message
	  * @return
	  */
	function sheet_OnSearchEnd(sheetObj,errMsg){
		//sheetObj.ShowSubSum(0, "2");
		//sheetObj.ShowSubSum([{StdCol:"calc_cost_grp_cd", SumCols:"1", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"calc_cost_grp_cd=;lgs_cost_cd=SubTotal"}]);
		//sheetObj.ShowSubSum([{StdCol:0, SumCols:"0", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"calc_cost_grp_cd=;lgs_cost_cd=SubTotal"}]);
		if(errMsg !=null  && errMsg != 0 && errMsg != ""){
			ComShowMessage (errMsg);
		}
		
		sheetObj.SetSumText(0, "calc_cost_grp_cd", "TOTAL");
	}