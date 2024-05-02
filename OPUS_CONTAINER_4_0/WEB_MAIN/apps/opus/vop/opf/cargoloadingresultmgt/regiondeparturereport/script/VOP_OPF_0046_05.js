/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_05.js
*@FileTitle  : RDR Creation
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
     * @class VOP_OPF_0046_05 : VOP_OPF_0046_05 business script for
     */
    function VOP_OPF_0046_05() {
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
                var prefix=sheetObjects[0].id+"_";
                var className=ComGetEvent("class");
                if( className.indexOf("_1") > -1 ){
                    return;
                }
                switch(srcName) {
                        case   "btn_Retrieve":
                               doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                             
                               break;
                        case   "btn_Row_Add":
                               var pRow=sheetObjects[0].DataInsert(-1);
                               sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                               break;
                        case   "btn_Row_Insert":
                               var pRow=sheetObjects[0].DataInsert();
                               sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                               break;
                        case   "btn_Row_Copy":
                               sheetObjects[0].DataCopy();
                               break;
                        case   "btn_Row_Delete":
                               ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
                               break;
                        case   "btn_ImportAllocation":
                               doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);        
                               break;
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
           var formObj=document.form;
           //axon_event.addListener    ('keydown', 'ComKeyEnter', 'form');
           //axon_event.addListenerForm('keypress', 'obj_keypress',    form  );    
           axon_event.addListenerFormat('BeforeDeactivate' ,  'fn_deactivate',  form);      
           axon_event.addListenerFormat('BeforeActivate'   ,  'fn_activate'  ,  form);     
         }
         /**
          * 
          * @param   sheetObj
          * 
          */
         //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj){
             
         //}
        /**
         * <pre>
         *     handling input validation by using dataformat of form element
         *     occur in case of losing focus
         * </pre>
         * 
         * @return void
         */ 
        function fn_deactivate(){
        }
         /**
          * <pre>
          *     handling input validation by using dataformat of form element
          *     occur in case of getting focus
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
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":
                    with(sheetObj){
						var HeadTitle1="|Sel.|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA\nType";
						var HeadTitle2="|Sel.|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic Weight|Weight Swap|Weight Release|TTL Weight|Weight\nper TEU|BSA\nType";
						var headCount=ComCountHeadTitle(HeadTitle1);
						var headCount2=ComCountHeadTitle(HeadTitle2);
						var prefix=sheetObj.id+"_";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var tot_alloc_calculate="|"+prefix+"basic_slot|+|"+prefix+"release_slot|+|"+prefix+"swap_slot|";
						var tot_wgt_calculate="|"+prefix+"basic_wgt|+|"+prefix+"release_wgt|+|"+prefix+"swap_wgt|";
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"basic_slot",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"swap_slot",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"release_slot", KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_alloc",    KeyField:0,   CalcLogic:tot_alloc_calculate,Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"basic_wgt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, ApproximateType:2 },
						 {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"swap_wgt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, ApproximateType:2 },
						 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"release_wgt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, ApproximateType:2 },
						 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_wgt",      KeyField:0,   CalcLogic:tot_wgt_calculate,Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
						 {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"teu_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8, ApproximateType:2 },
						 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bsa_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(370);
						SetEditable(1);

						SetColProperty(prefix+"bsa_type", {ComboText:"Used|Fixed", ComboCode:"U|F"} );
                	}
                    break;
            }
        }
         /**
          * Sheet1 OnPopupClick event 
          * @param sheetObj
          * @param Row
          * @param Col
          * @return
          */
         function sheet1_OnPopupClick(sheetObj, Row, Col)
         {   
//             var prefix=sheetObj.id+"_";
//             with(sheetObj)
//             {
//                 if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
//                     var lane_cd="";
//                     ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 490, 530, "PopupCallback_opr_cd", "1,0,1,1,1", true, false, Row, Col, 0);
//                 }
//             }
      	   var prefix=sheetObj.id+"_";
           with(sheetObj)
           {
               if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
               	parent.getCallBack(sheetObj, prefix, "opr_cd", Row, Col);
       			parent.mCheckValue=false;
               }
           }
         }
         /**
          * 
          * <pre>
          *     Sheet1 OnKeyUp event
          * </pre>
          *
          * @author jang kang cheol
          */
          function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
              var formObj=document.form;
              if( KeyCode == 229){return;}
              var prefix=sheetObj.id+"_";
              switch( sheetObj.ColSaveName(Col)  ){
                      case  prefix+'opr_cd' :
                            if( sheetObj.GetEditText().length == 3){
                                sheetObj.SetCellValue(Row, prefix+'opr_cd'  ,sheetObj.GetEditText().toUpperCase(),0);
                                doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC01, Row);                            
                            }
                            break;
              }
          }
          function  sheet1_OnChange(sheetObj, Row, Col,Value) {
              var formObj=document.form;
              var prefix=sheetObj.id+"_";
              switch( sheetObj.ColSaveName(Col)  ){
                     case prefix+'opr_cd' :
                    	 if( sheetObj.GetCellValue( Row, Col ).length < 3 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                               ComShowCodeMessage('OPF50007', 'Operator', "3");
                               sheetObj.SelectCell( Row, sheetObj.id+"_opr_cd");
                               sheetObj.SetCellValue( Row, Col,"",0);
                               return;
                           }
                           break;
              }
          }
//          /**
//           * CallBack Method about OnPopupClick Opr Code event 
//           * @param aryPopupData
//           * @param row
//           * @param col
//           * @param seetIdx 
//           * @return
//           */
//          function  PopupCallback_opr_cd(aryPopupData,row, col, seetIdx){
//              var formObj=document.form;
//              sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][3],0);
//              setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
//          }
      // handling process related Sheet
          function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
        	  var prefix=sheetObj.id+"_";
        	  switch(sAction) {
        	  	case    IBSEARCH:      //Retrieve
                        if(!validateForm(sheetObj,formObj,sAction)){return;}
                        formObj.f_cmd.value=SEARCHLIST01;
                        var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                        var sXml=sheetObj.GetSearchData("VOP_OPF_0046_05GS.do",  param );
                        sheetObj.LoadSearchData(sXml,{Sync:1} );
                        fnSubBtnAuth(true);
                        break;
                    case    IBSEARCH_ASYNC01:  // Grid Operator Code(=Carrier Code) Key In.
                        formObj.f_cmd.value=SEARCH04;            
                        formObj.crr_cd.value=sheetObj.GetCellValue( cRow, prefix+"opr_cd");
                            var param=FormQueryString(formObj);
                            var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param);
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                if( ComGetTotalRows(sXml) == "0"  ){
                                    ComShowCodeMessage("COM132201", "Operator");
                                    sheetObj.SetCellValue( cRow, prefix+"opr_cd","",0);
                                    sheetObj.SelectCell( cRow, prefix+"opr_cd");
                                } 
                            }
                            break;
                    case    IBSEARCH_ASYNC02:  
                            fnSetMainSearchOption(); 
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value=SEARCHLIST02;  
                            var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                            sheetObj.DoSearch("VOP_OPF_0046_05GS.do", param );
                            break;   
                    case    IBSAVE:  
                            parent.bTabChangeGo=false;
                            formObj.f_cmd.value=MULTI01;         
                            var sParam=ComGetSaveString(sheetObj );
                            if( sParam == ""){
                                parent.sSheetObjIdx=0;
                                parent.iSelectCell=sheetObj.GetSelectCol();
                                return;
                            }
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            sParam        +=  "&"+FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("VOP_OPF_0046_05GS.do" ,   sParam  );
                            sheetObj.LoadSaveData( sXml );
                            parent.bTabChangeGo=true;
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {　  
                                parent.fnGetHeader();
                            }
                            break;        
                    case    IBDELETE:  
                            if(!validateForm(sheetObj,formObj,sAction)){return;}
                            formObj.f_cmd.value=REMOVE;         
                            var sParam=FormQueryString(formObj);
                            var sXml=sheetObj.GetSaveData("VOP_OPF_0046_05GS.do" ,   sParam  );
                            sheetObj.LoadSaveData( sXml );
                            if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                 for(var i=0;i<sheetObjects.length;i++){
                                     sheetObjects[i].RemoveAll();
                                 }
                            }
                            break;  
                    case    IBRESET: //Btn_New
                            for(var i=0;i<sheetObjects.length;i++){
                                sheetObjects[i].RemoveAll();
                            }
                            fnSubBtnAuth(false);
                            break;
            }
        }
        /**
        * 
        * <pre>
        *     DupCheck code chosen
        * </pre>
        * @param  sheetObj
        * @param  cRow
        * @param  sColSaveName
        * @author jang kang cheol
        */
       function fnDupCheckSel(sheetObj, cRow, sColSaveName) {
           var dupRow = sheetObj.ColValueDupRows( sColSaveName, false, true );
           if( dupRow != "" ) {
                return false;   
           }
           return true;
       }
       function fnSetMainSearchOption(){
           var pForm=parent.form;
           var cForm=document.form;
           cForm.vsl_cd.value=pForm.vsl_cd.value;
           cForm.voy_no.value=pForm.voy_no.value;
           cForm.dir_cd.value=pForm.dir_cd.value;
//           cForm.region.value=pForm.region.GetSelectCode();
//           cForm.port_cd.value=pForm.port_cd.GetSelectCode();
           cForm.region.value=pForm.region.value;
           cForm.port_cd.value=pForm.port_cd.value;
       }
       function fnSubBtnAuth(bFlag){
           var pFormObj=parent.form;
       }
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction) {
                    case   IBSEARCH_ASYNC02:
                            var pForm=parent.form;
//                            if( pForm.port_cd.GetSelectCode()== "" ){
                           	if( pForm.port_cd.value== "" ){
                                 ComShowCodeMessage("COM130201", "Port");
                                 pForm.port_cd.focus();
                                 return false;
                            }
                            break;            
                    case   IBSAVE:
                            var dupRow = sheetObj.ColValueDupRows( sheetObj.id+"_opr_cd", false, true );
                            //2|6,7
                            var aDupRow=dupRow.split("|");
                            if(dupRow != "") {
                                ComShowCodeMessage('OPF50005', 'Data');
                                if (sheetObj.GetRowStatus( aDupRow[0]) == "R" ) {
                                    var sSelRow="";
                                    if(aDupRow[1].indexOf(",") > -1 ){//multi.=>  ","
                                        var aDupRowComma=aDupRow[1].split(",");
                                        sSelRow=aDupRowComma[0];
                                    }else{
                                        sSelRow=aDupRow[1];                                    
                                    }
                                    sheetObj.SelectCell(sSelRow, sheetObj.id+"_opr_cd");
                                }else{
                                    sheetObj.SelectCell(aDupRow[0], sheetObj.id+"_opr_cd");
                                }
                                return false;
                            }
                            //change   
                            if( parent.bChangedData ){
                                if( !ComShowCodeConfirm("OPF50003") ){
                                    parent.bTabChangeGo=true;                         
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
        
    	function sheet1_OnSearchEnd(sheetObj, code, errMsg){
    		sheetObj.SetSumText(0,"sheet1_opr_cd","TTL")
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
	       		//SetSheetHeight(sheetHeight > 90?sheetHeight-10:90);
	       		ComResizeSheet(sheetObjects[0]);
	       	  }    
	     } 
    	
	/* Developer performance  end */