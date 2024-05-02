/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0057_17.js
*@FileTitle  : Amendment History Inquiry - Customer Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0057_17 : business script for ESM_PRI_0057_17 
     */
    function ESM_PRI_0057_17() {
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
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var returnData="";
	 //Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 /**
	  * Event handler processing by button name  <br>
	  */
     function processButtonClick(){
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
             sheetObjects[i].SetWaitImageVisible(0);
             ComEndConfigSheet(sheetObjects[i]); 			
         }    
         resizeSheet();
         loadSts=true;
         parent.loadTabPage();
     }
  /**
   * calling function when occurring OnSelectCell Event <br>
   */        	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       if (OldRow != NewRow) {

       }
	}                  
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id; 
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
				with(sheetObj){
					var HeadTitle="|propno|amdtseq|ptytpcd|Customer Typ" +
							"e|EFF Date|EXP Date|Source|Source|Status|Status|acpt_usr_id|acpt_ofc_cd|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					    
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(300);
					SetEditable(0);
				}
                 break;
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
//          if (window.event == null || ComGetEvent() == null || ComGetEvent("suppressWait") != "Y") {
//              ComOpenWait(true);
//          }
//    	 var objEvt = ComGetEvent();
//    	 if (window.event == null || objEvt == null || $(objEvt).attr('suppressWait')!= "Y") {
//    		 ComOpenWait(true);
//    	 }
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	 		case IBSEARCH_ASYNC10: // 
	     		formObj.f_cmd.value=COMMAND13;
	     		//term, Source, Status
	     		formObj.cd.value="CD01714:Y:CD02064:N:CD01719:N";
	     		// Y in case of code|desc
	     		var sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if ( arrXml[0] != null)	setIBCombo(sheetObj, arrXml[0],"prc_ctrt_cust_tp_cd", false,0); 
				if ( arrXml[1] != null)	setIBCombo(sheetObj, arrXml[1],"src_info_cd", false, 0, "NW"); 				
				if ( arrXml[2] != null)	setIBCombo(sheetObj, arrXml[2],"prc_prog_sts_cd", false, 0, "I");	 		
				break;
	 		case IBSEARCH:      //retrieve			
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_PRI_0057_17GS.do", FormQueryString(formObj) );
				break;
         }//end switch
      } catch (e) {
          if (e == "[object Error]") {
              ComShowMessage(OBJECT_ERROR);
          } else {
              ComShowMessage(e.message);
          }
      } finally {
      	ComOpenWait(false);
      }
    }
    
    /**
     * calling function when creating object instance<br>
     */      
//    function sheet1_OnLoadFinish(sheetObj) {   
//    	sheetObjects[0].SetWaitImageVisible(0);
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);		   
//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//        parent.loadTabPage();
//        sheetObjects[0].SetWaitImageVisible(1);   
//    }
    
     /**
      * calling function when occurring OnSearchEnd Event <br>
      */ 		
 	function sheet1_OnSearchEnd(sheetObj, errMsg){    	 
  		var sCols="prc_ctrt_cust_tp_cd";
 		searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value); 
 		//buttonControl();
 	}
	 /**
	  * calling function when clicking parent's screen tab <br>
	  * showing retrieved data<br>
	  */ 
     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
         var formObject=document.form;
         try {
        	 if (formObject.prop_no.value != sPropNo
                     || formObject.amdt_seq.value != sAmdtSeq) {
             	formObject.prop_no.value=sPropNo;
             	formObject.amdt_seq.value=sAmdtSeq;
             	formObject.lgcy_if_flg.value=sLgcyIfFlg;
             	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
             }
             return true;
         }catch (e){
        	 return false;
         }
     }
 	/**
      * initializing parent's screen tab control <br>
      */      
     function tabClearSheet() {
         var formObject=document.form;
     	 formObject.prop_no.value="";
     	 formObject.amdt_seq.value="";
         for (var i=0; i < sheetObjects.length; i++) {
             sheetObjects[i].RemoveAll();
         }
     }
     var enableFlag=true;
 	/**
      * calling function from main screen <br>
      * prohibiting insert, update, delete in case or Confirmation = YES  <br>
      */     
     function tabEnableSheet(flag) {
         var formObject=document.form;
         enableFlag=flag;
         sheetObjects[0].SetEditable(flag);
     }
     var loadSts=false;
 	/**
 	* checking tab screen load  <br>
 	*/ 	
     function loadFinishCheck(){
         return loadSts;
     }