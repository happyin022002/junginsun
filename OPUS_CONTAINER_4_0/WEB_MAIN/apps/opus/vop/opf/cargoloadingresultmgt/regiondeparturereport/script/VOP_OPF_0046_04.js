/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_04.js
*@FileTitle  : RDR Creation ? RF
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
     * @class VOP_OPF_0046_04 : VOP_OPF_0046_04 business script for
     */
    function VOP_OPF_0046_04() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    /* Developer performance   */
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
                                sheetObjects[0].SetCellValue( pRow, sheetObjects[0].id+"_cntr_type","T" ,0);
                                sheetObjects[0].SelectCell( pRow, sheetObjects[0].id+"_opr_cd") ;
                                break;
                         case   "btn_Row_Insert":
                                var pRow=sheetObjects[0].DataInsert();
                                sheetObjects[0].SetCellValue( pRow, sheetObjects[0].id+"_cntr_type","T" ,0);
                                sheetObjects[0].SelectCell( pRow, sheetObjects[0].id+"_opr_cd") ;
                                break;
                         case   "btn_Row_Copy":
                                sheetObjects[0].DataCopy();
                                break;
                         case   "btn_Row_Delete":
                                ComRowHideDelete(sheetObjects[0], sheetObjects[0].id+"_sel_chk");
                                break;
                         case   "btn_Retrieve":
                                 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                             
                                 break;
                          case   "btn_Row_Add2":
                                 var pRow=sheetObjects[1].DataInsert(-1);
                                 sheetObjects[1].SetCellValue( pRow, sheetObjects[1].id+"_cntr_type","I" ,0);
                                 sheetObjects[1].SelectCell( pRow, sheetObjects[1].id+"_opr_cd") ;
                                 break;
                          case   "btn_Row_Insert2":
                                 var pRow=sheetObjects[1].DataInsert();
                                 sheetObjects[1].SetCellValue( pRow, sheetObjects[1].id+"_cntr_type","I" ,0);
                                 sheetObjects[1].SelectCell( pRow , sheetObjects[1].id+"_opr_cd") ;
                                 break;
                          case   "btn_Row_Copy2":
                                 sheetObjects[1].DataCopy();
                                 break;
                          case   "btn_Row_Delete2":
                                 ComRowHideDelete(sheetObjects[1], sheetObjects[1].id+"_sel_chk");
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
          * @author jang kang cheol
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
						var bEdt=true;
						var HeadTitle1="|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade";
						var HeadTitle2="|Sel.|Operator|POL|POD|20ft Qty|40ft Qty|Cntr_type";
						var headCount=ComCountHeadTitle(HeadTitle1);
						var prefix=sheetObj.id+"_";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sel_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
						 {Type:"AutoSum",   Hidden:0, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_20",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"N" },
						 {Type:"AutoSum",   Hidden:0, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_40",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"N" },
						 {Type:"Text",      Hidden:1, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_type", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetEditable(bEdt);
//						SetColProperty(0 ,"opr_cd" ,  {AcceptKeys:"E" , InputCaseSensitive:1});
//						SetColProperty(0 ,"pol" ,  {AcceptKeys:"E" , InputCaseSensitive:1});
//						SetColProperty(0 ,"pod" ,  {AcceptKeys:"E" , InputCaseSensitive:1});
						SetSheetHeight(370);
						
                        }
                    break;
                    
                case "sheet2":
                    with(sheetObj){
						var HeadTitle1="|Inter Port|Inter Port|Inter Port|Inter Port|Inter Port|Inter Port|Inter Port";
						var HeadTitle2="|Sel.|Operator|POL|POD|20ft Qty|40ft Qty|Cntr_Type";
						var headCount=ComCountHeadTitle(HeadTitle1);
						var prefix=sheetObj.id+"_";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sel_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"AutoSum",   Hidden:0, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_20",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"N" },
						 {Type:"AutoSum",   Hidden:0, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_40",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"N" },
						 {Type:"Text",      Hidden:1, Width:88,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_type", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(370);
						SetEditable(1);
                    }
                    break;
            }
        }
        
      // handling process related Sheet
        function doActionIBSheet(sheetObj,formObj,sAction, cRow, cCol) {
                var prefix=sheetObj.id+"_";
                var arrPrefix=new Array( sheetObjects[0].id+"_", sheetObjects[1].id+"_" );
                switch(sAction) {
                       case IBSEARCH:      //Retrieve
                                if(!validateForm(sheetObj,formObj,sAction)){
                                    return;
                                }
                                formObj.f_cmd.value=SEARCHLIST01;                     
                                var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix);
                                var sXml=sheetObj.GetSearchData("VOP_OPF_0046_04GS.do",  param );
                                var aXml=sXml.split("|$$|");
                                sheetObjects[0].LoadSearchData(aXml[0],{Sync:0} );
                                sheetObjects[1].LoadSearchData(aXml[1],{Sync:0} );
                                fnSubBtnAuth(true);
                                break;
                       case    IBSEARCH_ASYNC01:  // Grid Operator Code(=Carrier Code) Key In시.
                               formObj.f_cmd.value=SEARCH04;            
                               formObj.crr_cd.value=sheetObj.GetCellValue( cRow, prefix+"opr_cd");
                               var param=FormQueryString(formObj);
                               var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param);
                               if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                   if( ComGetTotalRows(sXml) == "0"  ){
                                       ComShowCodeMessage("COM132201", "Operator");
                                       sheetObj.SetCellValue( cRow, prefix+"opr_cd","",0);
                                       sheetObj.SelectCell( cRow, prefix+"opr_cd");
                                   }else{
                                       sheetObj.SelectCell( cRow, cCol+1);
                                       if(  (sheetObj.GetCellValue( cRow, prefix+"opr_cd") == "" ) ||
                                    		   (sheetObj.GetCellValue( cRow, prefix+"pol"   ) == "" ) ||
                                    		   (sheetObj.GetCellValue( cRow, prefix+"pod"   ) == "" )   ){
                                           return;
                                       }
                                   }
                               }
                               break;
                       case    IBSEARCH_ASYNC02:  //PORT_CODE=POL or POD
                               formObj.f_cmd.value=SEARCH12;          
                               formObj.port_cd.value=sheetObj.GetCellValue( cRow,  sheetObj.ColSaveName(cCol) );
                               var param=FormQueryString(formObj);
                               var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param);
                               if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                   if( ComGetTotalRows(sXml) == "0"  ){
                                       var pol_pod="";
                                       if( sheetObj.ColSaveName(cCol).indexOf("pol") > -1   ){
                                           pol_pod="POL";
                                       }else if( sheetObj.ColSaveName(cCol).indexOf("pod") > -1   ){
                                           pol_pod="POD";
                                       }
                                       ComShowCodeMessage("COM132201",  pol_pod );
                                       sheetObj.SetCellValue( cRow,  sheetObj.ColSaveName(cCol) ,"",0);
                                       sheetObj.SelectCell( cRow,  sheetObj.ColSaveName(cCol) );
                                   }else{
                                          sheetObj.SelectCell( cRow, cCol+1);
                                          if(  sheetObj.GetCellValue(cRow, prefix+"opr_cd") == "" ||
                                        		  sheetObj.GetCellValue(cRow, prefix+"pol"   ) == "" ||
                                        		  sheetObj.GetCellValue(cRow, prefix+"pod"   ) == ""
                                            ){
                                              return;
                                          }    
                                   }
                               }
                               break;
                       case    IBSAVE:  
                               parent.bTabChangeGo=false;
                               formObj.f_cmd.value=MULTI01;         
                               var sParam1=ComGetSaveString( sheetObjects[0]  );
                               if (sheetObjects[0].IsDataModified()&& sParam1 == ""){
                                   parent.sSheetObjIdx=0;
                                   parent.iSelectCell=sheetObjects[0].GetSelectCol();
                                   return;
                               }
                               var sParam2=ComGetSaveString( sheetObjects[1]  );
                               if (sheetObjects[1].IsDataModified()&& sParam2 == ""){
                                   parent.sSheetObjIdx=1;
                                   parent.iSelectCell=sheetObjects[1].GetSelectCol();
                                   return; 
                               }
                               if(!validateForm(sheetObjects ,formObj,sAction)){
                                   return;
                               }
                               if( sParam1 != ""){sParam1=sParam1+"&";}
                               var sParam=sParam1+sParam2;
                               sParam        +=  "&"+FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPrefix);
                               sheetObj.SetWaitImageVisible(0);
                               ComOpenWait(true);
                               var sXml=sheetObj.GetSaveData("VOP_OPF_0046_04GS.do" ,   sParam  );
                               sheetObj.LoadSaveData( sXml );
                               parent.bTabChangeGo=true;
                               ComOpenWait(false);
                               if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                   for(var i=sheetObjects[1].HeaderRows();i<sheetObjects[1].LastRow();i++){
                                       sheetObjects[1].SetRowStatus(i,"R");
                                   }
                               }
                               if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {　  
                                   parent.fnGetHeader();
                               }
                               break;        
                       case    IBDELETE:  
                               if(!validateForm(sheetObj,formObj,sAction)){return;}
                               formObj.f_cmd.value=REMOVE;        
                               var sParam=FormQueryString(formObj);
                               sheetObj.SetWaitImageVisible(0);
                               ComOpenWait(true);
                               var sXml=sheetObj.GetSaveData("VOP_OPF_0046_04GS.do" ,   sParam  );
                               ComOpenWait(false);
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
                   case prefix+'pol' :
                	   if( sheetObj.GetCellValue( Row, Col ).length < 5 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                               ComShowCodeMessage('OPF50007', 'POL', "5");
                               sheetObj.SelectCell( Row, sheetObj.id+"_pol");
                               sheetObj.SetCellValue( Row, Col,"",0);
                               return;
                           }
                           break;
                   case prefix+'pod' :
                	   if( sheetObj.GetCellValue( Row, Col ).length < 5 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                               ComShowCodeMessage('OPF50007', 'POD', "5");
                               sheetObj.SelectCell( Row, sheetObj.id+"_pod");
                               sheetObj.SetCellValue( Row, Col,"",0);
                               return;
                           }
                           break;
            }
        }
        function  sheet2_OnChange(sheetObj, Row, Col,Value) {
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
                   case prefix+'pol' :
                	   if( sheetObj.GetCellValue( Row, Col ).length < 5 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                           ComShowCodeMessage('OPF50007', 'POL', "5");
                           sheetObj.SelectCell( Row, sheetObj.id+"_pol");
                           sheetObj.SetCellValue( Row, Col,"",0);
                           return;
                       }
                       break;
                   case prefix+'pod' :
                	   if( sheetObj.GetCellValue( Row, Col ).length < 5 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                           ComShowCodeMessage('OPF50007', 'POD', "5");
                           sheetObj.SelectCell( Row, sheetObj.id+"_pod");
                           sheetObj.SetCellValue( Row, Col,"",0);
                           return;
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
//           var prefix=sheetObj.id+"_";
//           with(sheetObj)
//           {
//               if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
//                   var lane_cd="";
//                   ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 490, 530, "PopupCallback_opr_cd", "1,0,1,1,1", true, false, Row, Col, 0);
//               }
//               if( sheetObj.ColSaveName(Col) == prefix+'pol' ){
//            	   var port_cd=sheetObj.GetCellValue(Row, Col);
//                   ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "PopupCallback_port1", "0,0", true, false, Row, Col, 0);
//               }
//               if( sheetObj.ColSaveName(Col) == prefix+'pod' ){
//            	   var port_cd=sheetObj.GetCellValue(Row, Col);
//                   ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "PopupCallback_port1", "0,0", true, false, Row, Col, 0);
//               }
//           }
    	   var prefix=sheetObj.id+"_";
           with(sheetObj)
           {
               if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
	               parent.getCallBack(sheetObj, prefix, "opr_cd", Row, Col);
	               parent.mCheckValue=false;
               }
               if( sheetObj.ColSaveName(Col) == prefix+'pol' ){
            	   parent.getCallBack(sheetObj, prefix, "pol", Row, Col);
            	   parent.mCheckValue=false;
               }
               if( sheetObj.ColSaveName(Col) == prefix+'pod' ){
            	   parent.getCallBack(sheetObj, prefix, "pod", Row, Col);
            	   parent.mCheckValue=false;
               }
           }
       }
        /**
        * Sheet2 OnPopupClick event  
        * @param sheetObj
        * @param Row
        * @param Col
        * @return
        */
       function sheet2_OnPopupClick(sheetObj, Row, Col)
       {   
           var prefix=sheetObj.id+"_";
           with(sheetObj)
           {
               if( sheetObj.ColSaveName(Col) == prefix+'opr_cd' ){
                   var lane_cd="";
                   ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 490, 530,  "PopupCallback_opr_cd", "1,0,1,1,1", true, false, Row, Col, 1);
               }
               if( sheetObj.ColSaveName(Col) == prefix+'pol' ){
            	   var port_cd=sheetObj.GetCellValue(Row, Col);
                   ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "PopupCallback_port2", "0,0", true, false, Row, Col, 1);
               }
               if( sheetObj.ColSaveName(Col) == prefix+'pod' ){
            	   	var port_cd=sheetObj.GetCellValue(Row, Col);
                   ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "PopupCallback_port2", "0,0", true, false, Row, Col, 1);
               }
           }
       }
      /**
       * 
       * <pre>
       *     Sheet1 OnKeyUp event
       * </pre>
       *
       */
       function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
           var formObj=document.form;
           if( KeyCode == 229){return;}
           var prefix=sheetObj.id+"_";
           switch( sheetObj.ColSaveName(Col)  ){
                   case  prefix+'opr_cd' :
                         if( sheetObj.GetEditText().length == 3){
                             sheetObj.SetCellValue(Row, prefix+'opr_cd'  ,sheetObj.GetEditText().toUpperCase(),0);
                             doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC01, Row, Col);                            
                         }
                         break;
                  case  prefix+'pol' :
                        if( sheetObj.GetEditText().length == 5){
                            sheetObj.SetCellValue(Row, prefix+'pol'  ,sheetObj.GetEditText().toUpperCase(),0);
                            doActionIBSheet(sheetObj , formObj,IBSEARCH_ASYNC02, Row, Col);                            
                        }
                        break;
                  case prefix+'pod' :
                       if( sheetObj.GetEditText().length == 5){
                          sheetObj.SetCellValue(Row, prefix+'pod'  ,sheetObj.GetEditText().toUpperCase(),0);
                          doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC02, Row, Col);                            
                       }
                       break;
           }
       }
       /**
        * 
        * <pre>
        *     Sheet2 OnKeyUp event
        * </pre>
        *
        */
        function  sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
             var formObj=document.form;
             if( KeyCode == 229){return;}
             var prefix=sheetObj.id+"_";
             switch( sheetObj.ColSaveName(Col)  ){
                    case  prefix+'opr_cd' :
                           if( sheetObj.GetEditText().length == 3){
                               sheetObj.SetCellValue(Row, prefix+'opr_cd'  ,sheetObj.GetEditText().toUpperCase(),0);
                               doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC01, Row, Col);                            
                           }
                           break;
                    case  prefix+'pol' :
                          if( sheetObj.GetEditText().length == 5){
                              sheetObj.SetCellValue(Row, prefix+'pol'  ,sheetObj.GetEditText().toUpperCase(),0);
                              doActionIBSheet(sheetObj , formObj,IBSEARCH_ASYNC02, Row, Col);                            
                          }
                          break;
                    case prefix+'pod' :
                         if( sheetObj.GetEditText().length == 5){
                            sheetObj.SetCellValue(Row, prefix+'pod'  ,sheetObj.GetEditText().toUpperCase(),0);
                            doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC02, Row, Col);                            
                         }
                         break;
             }
        }
       /**
        * CallBack method about OnPopupClick Port Code(Pol, Pod ) event
        * @param aryPopupData
        * @param row
        * @param col
        * @param seetIdx 
        * @return
        */
//       function  PopupCallback_port(aryPopupData,row, col, seetIdx){
        function  PopupCallback_port1(aryPopupData){
//           var formObj=document.form;
           var sheetObj = sheetObjects[0];
           var row = sheetObj.GetSelectRow();
           var col = sheetObj.GetSelectCol();
           sheetObj.SetCellValue(row, col,aryPopupData,0);
//           sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][2],0);
           //setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02, row); }, 400);
        }
        function  PopupCallback_port2(aryPopupData){
            var sheetObj = sheetObjects[1];
            var row = sheetObj.GetSelectRow();
            var col = sheetObj.GetSelectCol();
            sheetObj.SetCellValue(row, col,aryPopupData,0);
        }
        /**
         * CallBack Method about OnPopupClick Opr Code event 
         * @param aryPopupData
         * @param row
         * @param col
         * @param seetIdx 
         * @return
         */
        function  PopupCallback_opr_cd(aryPopupData,row, col, seetIdx){
            var formObj=document.form;
            sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][3],0);
            setTimeout( function(){ doActionIBSheet(sheetObjects[seetIdx], formObj,IBSEARCH_ASYNC01, row); }, 400);
        }
         /**
          * 
          * <pre>
          *      DupCheck code chosen
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
          function fnSubBtnAuth(bFlag){
              var pFormObj=parent.form;
          }
        /**
         * handling process for input validation
         */
         function validateForm(sheetObj,formObj,sAction  ){
             switch(sAction) {
                     case   IBSAVE:
                            for(var i=0;i<sheetObj.length;i++){
                                var dupRow = sheetObj[i].ColValueDupRows( sheetObj[i].id+"_opr_cd"+"|"+sheetObj[i].id+"_pol"+"|"+sheetObj[i].id+"_pod"   , false, true );
                                 //2|6,7
                                 var aDupRow=dupRow.split("|");
                                 if(dupRow != "") {
                                     ComShowCodeMessage('OPF50005', 'Data');
                                     if (sheetObj[i].GetRowStatus( aDupRow[0]) == "R" ) {
                                         var sSelRow="";
                                         if(aDupRow[1].indexOf(",") > -1 ){//multi.=>  ","
                                             var aDupRowComma=aDupRow[1].split(",");
                                             sSelRow=aDupRowComma[0];
                                         }else{
                                             sSelRow=aDupRow[1];                                    
                                         }
                                         sheetObj[i].SelectCell(sSelRow, sheetObj[i].id+"_opr_cd");
                                     }else{
                                         sheetObj[i].SelectCell(aDupRow[0], sheetObj[i].id+"_opr_cd");
                                     }
                                     return false;
                                 }
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
         function sheet1_OnSearchEnd(sheetObj, sErrMsg){
//             //in case Inter Port Sheet is  Externally, cannot edit
//             var updateSys =  parent.form.sys_create_desc.value; //Externally, Internally
             //var bEdt=true;
//
//             if( updateSys.indexOf( "Externally" ) > -1 ){
//                	 bEdt = false;
//             }
//             fnSubBtnAuth(bEdt);             
//             sheetObj.Editable = bEdt;
             sheetObj.SetSumText(0,"sheet1_opr_cd","TTL")
         }
         
         function sheet2_OnSearchEnd(sheetObj, sErrMsg){
           sheetObj.SetSumText(0,"sheet2_opr_cd","TTL")
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
       		ComResizeSheet(sheetObjects[0], 40);
       	    ComResizeSheet(sheetObjects[1], 40);

       	  }    
       }  
    /* Developer performance  end */