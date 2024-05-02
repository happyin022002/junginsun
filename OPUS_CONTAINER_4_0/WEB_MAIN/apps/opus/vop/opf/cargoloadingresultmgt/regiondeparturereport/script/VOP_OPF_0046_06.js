/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_06.js
*@FileTitle  : RDR Creation ? Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7 
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0046_06 : VOP_OPF_0046_06 business script for
     */
    function VOP_OPF_0046_06() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             　
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
           // try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                } // end switch
//            }catch(e) {
//                if( e == "[object Error]") {
//                    ComShowMessage(OBJECT_ERROR);
//                } else {
//                    ComShowMessage(e);
//                }
//            }
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
            var formObj=document.form;
            initControl();
            
            var  pFormObj=parent.document.form;
            var  formObj=document.form;
            if(  pFormObj.flagRetrieveYn.value  == "Y" ){
                 parent.doActionIBSheet( parent.sheetObjects[0], pFormObj, IBSEARCH);
            }
            parent.iframeResize(true);
        }
         function initControl() {
             axon_event.addListenerForm('change', 'obj_change',    form  );    
         }
         /**
          * handling in case of Object Onchange event in Form
          * 
          * @return void
          */
          function obj_change(){
             obj=ComGetEvent();
             var formObj=document.form;
             switch(obj.name ) {
                 case "remark":
                       var cRow;
                       if(sheetObjects[0].RowCount()== 0 ){
                           cRow=sheetObjects[0].DataInsert(-1);
                       }else{
                           cRow=sheetObjects[0].LastRow();
                           sheetObjects[0].SetRowStatus( cRow ,"U");
                       }
                       break;
             } // end switch 
          }
          /**
           * 
           * @param   sheetObj
           */
          //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj){
              
          //}
        /**
         * <pre>
         *     handling input validation by using dataformat of form element
         *     in case of losing focus 
         * </pre>
         * 
         * @return void
         */ 
        function fn_deactivate(){
        }
         /**
          * <pre>
          *     handling input validation by using dataformat of form element
          *     in case of getting focus 
          * </pre>
          * 
          * @return void
          */ 
         function fn_activate(){
         }        
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
         /**
          * setting sheet initial values and header
          * param : sheetObj, sheetNo
          * adding case as numbers of counting sheets
          */
         function initSheet(sheetObj,sheetNo) {
             var cnt=0;
             var sheetID=sheetObj.id;
             switch(sheetID) {
                 case "sheet1":
                	 with(sheetObj){
						var HeadTitle1="";
						var headCount=ComCountHeadTitle(HeadTitle1);
						var prefix=sheetObj.id+"_";
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" } ];
						    
						InitColumns(cols);
						SetSheetHeight(380);
						SetEditable(1);
                     }
                     break;
             }
         }
        // handling process related Sheet
        function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
            var prefix=sheetObj.id+"_";
            switch(sAction) {
                    case    IBSEARCH:      //Retrieve
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value=SEARCHLIST01;
                            var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                            var sXml=sheetObj.GetSearchData("VOP_OPF_0046_06GS.do",  param );
                            var sMessage=ComOpfGetMessageFromXml(sXml);
                            if( sMessage != ""){
                                ComShowMessage(  sMessage  );
                            }else{
                                var sRemark=ComGetEtcData(sXml, "remark");
                                if(sRemark == "null"){sRemark="";}
                                ComSetObjValue( formObj.remark,   sRemark );    
                            }
                            break;
                    case    IBSAVE:  
                            parent.bEditTabChange=false;
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value=MULTI01;         
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("VOP_OPF_0046_06GS.do" ,   sParam  );
                            sheetObj.LoadSaveData( sXml );
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) { 
                                parent.fnGetHeader();
                            }
                            parent.bEditTabChange=true;
                            break;        
                    case    IBDELETE:  
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value=REMOVE;         
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("VOP_OPF_0046_06GS.do" ,   sParam  );
                            sheetObj.LoadSaveData( sXml );
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                 formObj.remark.value="";
                            }
                            break;  
                    case    IBRESET: //Btn_New
                            formObj.remark.value="";
                            for(var i=0;i<sheetObjects.length;i++){
                                sheetObjects[i].RemoveAll();
                            }
                            break;
            }
        }
        /**
         * handling process for input validation
         */
         function validateForm(sheetObj,formObj,sAction){
             switch(sAction) {
                     case   IBSAVE:
                            if( ComGetLenByByte(formObj.remark)  > 1000 ){
                                 ComShowCodeMessage('OPF50022',   parent.aTabTitle[parent.beforetab], "1000 Byte ( Current"+ComGetLenByByte(formObj.remark)+" Byte)" );   
                                 return false;   
                            }
                            if( parent.bChangedData ){
                                if( !ComShowCodeConfirm("OPF50003") ){                            
                                    return false;
                                }
                            }else{
                                if( !ComShowCodeConfirm("OPF50001") ){                            
                                    return false;
                                }
                            }
                            break;
                     case   IBDELETE:
                            if( !ComShowCodeConfirm("OPF50002", parent.aTabTitle[parent.beforetab] ) ){                            
                                return false;
                            }                            
                            break;
             }
             return true;
        }
         
         function updateSheetSize(sheetObj){
	       	  if(typeof sheetObj == "undefined") {
	       		  sheetObj = sheetObjects[0];
	       	  }
	       	  var obj = $("#" + sheetObj.id).offset();
	       	  var marginDefault = 160;
	       	  var marginHeight = obj.top + marginDefault;
	       	  var winHeight = $(parent.window).height();
	       	  var sheetHeight = winHeight - marginHeight;
	
	       	  with(sheetObj){
	       		SetSheetHeight(sheetHeight > 90?sheetHeight-10:90);
	       	  }    
	     } 
	/* Developer performance  end */