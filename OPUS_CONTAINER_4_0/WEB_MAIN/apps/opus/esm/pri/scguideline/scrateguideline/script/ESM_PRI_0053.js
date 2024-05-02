/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_pri_0053.js
*@FileTitle  : Guideline MQC Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends Pri
     * @class ESM_PRI_0053 : Business Script for Guideline MQC
     */
    function ESM_PRI_0053() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.24
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
	            case "btn_Retrieve":
	                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.07.24
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.07.24
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        //no support[check again]CLT pageOnLoadFinish();
    }
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.07.24
     */ 
    function pageOnLoadFinish() {
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.07.24
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        case 1:      // sheet1 init
            with(sheetObj){

          var HeadTitle="Seq.|||||MIN|MAX";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_seq" },
                 {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty" },
                 {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty" } ];
           
          InitColumns(cols);

          SetEditable(0);
          SetWaitImageVisible(0);
          SetAutoRowHeight(0);
          SetSheetHeight(160);
          }


        break;
        }
    }
    /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.07.24
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //Retrieving
                if(validateForm(sheetObj,formObj,sAction)){
                    if(sheetObj.id == "sheet1") {
                    	ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;
                        sheetObj.DoSearch("ESM_PRI_0053GS.do", FormQueryString(formObj) );
                        ComOpenWait(false);
                    }
                }
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return bool <br>
     *         true  : Valid<br>
     *         false : Invalid
     * @author 
     * @version 2009.07.24
     */
    function validateForm(sheetObj,formObj,sAction){
        with (sheetObj) {
            if (sAction == IBSAVE) {
            }
        }
        return true;
    }
