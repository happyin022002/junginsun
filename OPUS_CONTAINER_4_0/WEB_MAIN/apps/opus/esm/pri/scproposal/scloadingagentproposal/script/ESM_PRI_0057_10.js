/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_10.js
 *@FileTitle  : Amendment History Inquiry - Loding Agent
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0057_10 : business script for ESM_PRI_0057_10  
     */
    function ESM_PRI_0057_10() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	//Event handler processing by button click event */
 	document.onclick=processButtonClick;
	 /**
	  * Event handler processing by button name  <br>
	  */
	function processButtonClick(){
	    var sheetObject1=sheetObjects[0];
	    var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} 
					break;
	        } // end switch
		}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics <br>
      * Setting body tag's onLoad event handler <br>
      * Adding pre-handling function after loading screen on the browser  <br>
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
 		 loadSts=true;
 		 parent.loadTabPage();
     }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var formObj=document.form;
         switch(sheetID) {             
             case "sheet1":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|lodg_agn_seq|amdt_seq|Customer Code|Customer Code|Mannual Input|Customer Name|Address|Location" + "|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" + "|1|2|3|4|5";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lodg_agn_seq" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
					  {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
					  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					  {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mnl_inp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:270,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
					  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl" },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl" },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
					    
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(300);
					SetEditable(0);
					SetEllipsis(1);
					SetWaitImageVisible(0);
					SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
					SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
					SetShowButtonImage(2);
					//SetAutoRowHeight(0);
				}
                break
         }
     }
     
     function resizeSheet() {
 	    ComResizeSheet(sheetObjects[0]);
 	}
     
     /**
      * Handling sheet process <br>
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 try {
	         sheetObj.ShowDebugMsg(false);
	         switch(sAction) {
	 	        case IBSEARCH: // retrieve	
	  				ComOpenWait(true);
	 	         	formObj.f_cmd.value=SEARCH01;
	 	         	sheetObj.DoSearch("ESM_PRI_0057_10GS.do", FormQueryString(formObj) );
	 				break;
	        }
	  	}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally {
			 ComOpenWait(false);
		}
    }
   /**
   	* registering IBTab Object as array <br>
   	* adding process for list in case of needing batch processing with other items  <br>
   	* defining list on the top of source <br>
   	*/
      function setTabObject(tab_obj){
          tabObjects[tabCnt++]=tab_obj;
      }
       /**
        * checking validation process of inputed form data <br>
        */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieve		
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		}	
		return true;
    }
    /**
     * calling function when occurring OnSelectCell Event <br>
     * Amend Row's Highlight color is different <br>
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {

        }
    } 
   /**
    * calling function when occurring OnClick Event <br>
    */  
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //showing memopad when clicking desc cell (MemoPad editable)
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "cust_addr":
 	    		sheetObj.SetCellEditable(Row,"cust_addr",0);
 	    		ComShowMemoPad(sheetObj, Row, Col, true, 200);
 	    		break;
     	}
    }
     /**
      * calling function when clicking parent's screen tab <br>
      * showing retrieved data<br>
      */ 
     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
     	var formObject=document.form;
     	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
     		formObject.prop_no.value=sPropNo;
     		formObject.amdt_seq.value=sAmdtSeq;
     		formObject.svc_scp_cd.value=sSvcScpCd;
     		formObject.con_chk.value=sConChk;	
 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
     	}
     }	
	/**
     * initializing parent's screen tab control <br>
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";  			
		sheetObjects[0].RemoveAll();
	}
	var enableFlag=true;
	/**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;  			
		enableFlag=flag;  		
	}

   /**
    * calling function when occurring OnSearchEnd Event <br>
    */ 
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	manageGetCellEditable(sheetObj);
	} 
	/**
     * control SHEET's CELL editable authority function <br>
     */
     function manageGetCellEditable(sheetObj) {
    	 var formObj=document.form;
    	 var amdt_seq=formObj.amdt_seq.value;
    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
    	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
    		 if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
    			 sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(),1);
    			 sheetObj.SetRowEditable(i,0);
    		 }				  
    		 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq && sLgcyIfFlg != "Y"){
    			 sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
    		 }
    	 }
     }
     var loadSts=false;
     /**
      * calling function from main screen <br>
      */
     function loadFinishCheck(){
         return loadSts;
     }    	     