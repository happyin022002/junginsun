/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_03.js
*@FileTitle  : RDR Creation ? HC/45
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
     * @class VOP_OPF_0046_03 : VOP_OPF_0046_03 business script for
     */
    function VOP_OPF_0046_03() {
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
             var prefix=sheetObjects[0].id+"_";
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
                         case   "btn_ImportSubAllocation":
                                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);     
                                break;
                         case   "btn_Row_Add":
                                var pRow=sheetObjects[0].DataInsert(-1);
                                sheetObjects[0].SelectCell( pRow, prefix+"opr_cd") ;
                                break;
                         case   "btn_Row_Insert":
                                var pRow=sheetObjects[0].DataInsert();
                                sheetObjects[0].SelectCell(pRow, prefix+"opr_cd") ;
                                break;
                         case   "btn_Row_Copy":
                                sheetObjects[0].DataCopy();
                                break;
                         case   "btn_Row_Delete":
                                ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
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
						var HeadTitle1="|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR";
						var HeadTitle2="|Sel.|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45’|45’|45’|45’|45’|Ratio\nType";
						var HeadTitle3="|Sel.|Operator|Loaded|BSA\n(T)|Over Ratio\n(T)|Add Slot\n(T)|Loaded|BSA\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Loaded|BSA\n(F)|Under Ratio\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Ratio\nType";
						var headCount=ComCountHeadTitle(HeadTitle1);
						var bEdt=true;
						var prefix=sheetObj.id+"_";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
						 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_20",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc20_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc20_rate",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_20",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_40",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc40_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc40_rat",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_40",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_45",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_45",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:prefix+"un_rat_45",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ov_rat_45",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_45",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
						 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ratio_type", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 } ];
						   
						InitColumns(cols);
						SetSheetHeight(370);
						SetEditable(1);
						var slot_add_calcul="|"+prefix+"add_20|+|"+prefix+"add_40|+|"+prefix+"add_45|";
						SetColProperty(prefix+"ratio_type", {ComboText:"Rate|Void", ComboCode:"R|V"} );
                    }
                    break;
            }
        }
      // handling process related Sheet
        function doActionIBSheet(sheetObj,formObj,sAction, cRow ) {
                var prefix=sheetObj.id+"_";
                switch(sAction) {
                        case IBSEARCH:      //Retrieve
                                 if(!validateForm(sheetObj,formObj,sAction)){return;}
                                 formObj.f_cmd.value=SEARCHLIST01;                     
                                 var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                 var sXml= sheetObj.GetSearchData("VOP_OPF_0046_03GS.do",  param );
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
                        case    IBSEARCH_ASYNC02:  //Import Sub Allocation
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                fnSetMainSearchOption();
                                formObj.f_cmd.value=SEARCHLIST02;            
                                formObj.crr_cd.value=sheetObj.GetCellValue( cRow, prefix+"opr_cd");
                                var param=FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix);
                                var sXml=sheetObj.GetSearchData("VOP_OPF_0046_03GS.do", param);
                                sheetObj.LoadSearchData(sXml,{Sync:1} );
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
                                sParam += "&"+FormQueryString(formObj);
                                var sXml=sheetObj.GetSaveData("VOP_OPF_0046_03GS.do" ,   sParam  );
                                sheetObj.LoadSaveData( sXml );
                                
                                parent.bTabChangeGo=true;
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) { 
                               	    //alert("Data was saved successfully");	//@@패치대기
                                    parent.fnGetHeader();
                                }
                                break;        
                        case    IBDELETE:  
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                formObj.f_cmd.value=REMOVE;        
                                var sParam=FormQueryString(formObj);
                                var sXml=sheetObj.GetSaveData("VOP_OPF_0046_03GS.do" ,   sParam  );
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
                                fnSubBtnAuth(false);;
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
//                   ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 490, 530, "setSheet1_PopupCallback_port", "1,0,1,1,1", true, false, Row, Col, 0);
//               }
//           }
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
       */
       function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
            var formObj=document.form;
            if( KeyCode == 229){return;}
            var prefix=sheetObj.id+"_";
            switch( sheetObj.ColSaveName(Col)  ){
                   case prefix+'opr_cd' :
                         if( sheetObj.GetEditText().length == 3){
                             sheetObj.SetCellValue(Row, prefix+'opr_cd'  ,sheetObj.GetEditText().toUpperCase(),0);
                             doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, Row);                            
                         }
                         break;
            }
       }
//       /**
//        * CallBack method about Sheet1 OnPopupClick event 
//        * @param aryPopupData
//        * @param row
//        * @param col
//        * @param seetIdx 
//        * @return
//        */
//       function setSheet1_PopupCallback_port(aryPopupData,row, col, seetIdx){
//           var formObj=document.form;
//           sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][3],0);
//           setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
//       }
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
            with(sheetObj){
                //{(Loaded ? 20’ High Cubic Sub Allocation) x (Over Ratio-1)}  , 
                if(ColSaveName(Col) == prefix + "load_20"  ||
                   ColSaveName(Col) == prefix + "hc20_qty" ||
                   ColSaveName(Col) == prefix + "hc20_rate"    ){
                	if(parseInt  (GetCellValue(Row,  prefix + "load_20"   ))  > 0 &&
                			parseInt  (GetCellValue(Row,  prefix + "hc20_qty"  ))  > 0 &&
                			parseFloat(GetCellValue(Row,  prefix + "hc20_rate" ))  > 1    ){
                            /**   
                             *   Load > bsa =>   (Load - Bsa)
                             *    
                             */
                		if( parseInt(GetCellValue(Row,  prefix + "load_20")) >
                		parseInt(GetCellValue(Row,  prefix + "hc20_qty"))){
                			var addSlot=(      parseInt(GetCellValue(Row,  prefix + "load_20"))
                					- parseInt(GetCellValue(Row,  prefix + "hc20_qty"))
                                                  )
                                               *  (GetCellValue(Row,  prefix + "hc20_rate") - 1);
                                SetCellValue(Row,  prefix + "add_20",ComRound(addSlot, 0));
                            }else{
                                SetCellValue(Row,  prefix + "add_20","0");
                            }
                    }else{
                        SetCellValue(Row,  prefix + "add_20","0");
                    }
                }
                 //{(Loaded ? 40’ High Cubic Sub Allocation) x (Over Ratio-1) } x 2, 
                if(ColSaveName(Col) == prefix + "load_40"  ||
                   ColSaveName(Col) == prefix + "hc40_qty" ||
                   ColSaveName(Col) == prefix + "hc40_rat"   ){
                	if(parseInt  (GetCellValue(Row,  prefix + "load_40" )) > 0 &&
                			parseInt  (GetCellValue(Row,  prefix + "hc40_qty")) > 0 &&
                			parseFloat(GetCellValue(Row,  prefix + "hc40_rat")) > 1){
                		if(parseInt(GetCellValue(Row,  prefix + "load_40")) > parseInt(GetCellValue(Row,  prefix + "hc40_qty"))){
                			var addSlot=(  parseInt(GetCellValue(Row,  prefix + "load_40" ))
                					- parseInt(GetCellValue(Row,  prefix + "hc40_qty"))
                                                  )
                                                *
                                                (GetCellValue(Row,  prefix + "hc40_rat") - 1) * 2;
                                    SetCellValue(Row,  prefix + "add_40",ComRound(addSlot, 0));
                                }else{
                                    SetCellValue(Row,  prefix + "add_40","0");
                                }
                        }else{
                            SetCellValue(Row,  prefix + "add_40","0");
                        }
                }
                /**
                 * - HC45
                 *   case1) Load <= Bsa : in case of Under
                 *                        Load * ( URate - 1) * 2
                 *   case2) Load > Bsa :  in case of Over  
                 *                       Bsa  * (URate-1) * 2
                 *                    + (Load - Bsa ) * (ORate - 1) * 2
                 */
                if(ColSaveName(Col) == prefix + "load_45"   ||
            		ColSaveName(Col) == prefix + "bsa_45"    ||
            		ColSaveName(Col) == prefix + "un_rat_45" ||
            		ColSaveName(Col) == prefix + "ov_rat_45"   ){
                	var loaded45=parseInt  (GetCellValue(Row,  prefix + "load_45"));
                	var bsa45=parseInt  (GetCellValue(Row,  prefix + "bsa_45"));
					var undRt45=parseFloat(GetCellValue(Row,  prefix + "un_rat_45"));
					var ovrRt45=parseFloat(GetCellValue(Row,  prefix + "ov_rat_45"));
					if(parseInt(GetCellValue(Row,  prefix + "load_45")) > 0 && parseInt(GetCellValue(Row,  prefix + "bsa_45")) > 0){
                        if (/****************** in case of Case1 Under ******************************/
                        		( parseInt  (GetCellValue(Row,  prefix + "load_45"  )) <= parseInt(GetCellValue(Row,  prefix + "bsa_45")) ) &&
                        		( parseFloat(GetCellValue(Row,  prefix + "un_rat_45")) > 1 )
                           ){
                        	var addSlot=parseInt(GetCellValue(Row,  prefix + "load_45"))
                                           *  (GetCellValue(Row,  prefix + "un_rat_45") - 1) * 2;
                               SetCellValue(Row,  prefix + "add_45",ComRound(addSlot, 0));
                        }
                        else 
                        if(/****************** in case of Case2 Over  ******************************/
                        		( parseInt(GetCellValue(Row,  prefix + "load_45")) >
                        		parseInt(GetCellValue(Row,  prefix + "bsa_45"))
                            )
                            &&
                            ( parseFloat(GetCellValue(Row,  prefix + "un_rat_45")) > 1 )
                            && ( parseFloat(GetCellValue(Row,  prefix + "ov_rat_45")) > 1 )
                           ){
                        	var addSlot=( parseInt(GetCellValue(Row,  prefix + "bsa_45"))
                                           * ( GetCellValue(Row,  prefix + "un_rat_45") - 1) * 2 ) 
                                           /****************************************************/
                                           + 
                                           ((parseInt(GetCellValue(Row,  prefix + "load_45"))
                                        		   -   parseInt(GetCellValue(Row,  prefix + "bsa_45" ))
                                             )
                                           * (GetCellValue(Row,  prefix + "ov_rat_45") - 1) * 2 );
                              SetCellValue(Row,  prefix + "add_45",ComRound(addSlot, 0));
                        }else{
                              SetCellValue(Row,  prefix + "add_45","0");
                        }
                    }else{
/* 
    * BSA 0 and Over Ratio = 0   ==> Add Slots 0 (AS-IS maintain)
    * BSA 0 and Over Ratio > 0   ==> Add Slots,  X = ((A-B)*R2 - (A-B))*2 + (B*R1 - B)*2
      - A   : Loaded
      - B   : BSA
      - R1 : Under Ratio
      - R2 : Over Ratio 
 */                    
                    	if (bsa45 == 0){
                    		SetCellValue(Row, prefix+"un_rat_45",0,0);
                    	}
//	 						SetCellEditable(Row, prefix+"un_rat_45",0);
// 						}else{
//	 						SetCellEditable(Row, prefix+"un_rat_45",1);
// 						}
                    	if (bsa45 == 0 && ovrRt45 > 0){
                    		SetCellValue(Row,  prefix + "add_45",ComRound(2*loaded45*(ovrRt45 - 1), 0)+"");
                    	}else{
                    		SetCellValue(Row,  prefix + "add_45","0");
                    	}
                    }
					
					if (bsa45 == 0) {
 						SetCellEditable(Row, prefix+"un_rat_45",0);
					} else {
						SetCellEditable(Row, prefix+"un_rat_45",1);
					}
                }
            }            
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
        function fnSetMainSearchOption(){
            var pForm=parent.form;
            var cForm=document.form;
            cForm.vsl_cd.value=pForm.vsl_cd.value;
            cForm.voy_no.value=pForm.voy_no.value;
            cForm.dir_cd.value=pForm.dir_cd.value;
//            cForm.region.value=pForm.region.GetSelectCode();
//            cForm.port_cd.value=pForm.port_cd.GetSelectCode();
            cForm.region.value=pForm.region.value;
            cForm.port_cd.value=pForm.port_cd.value;
        }
        function fnSubBtnAuth(bFlag){
            var pFormObj=parent.form;
        }
        /**
         * handling process for input validation
         */
         function validateForm(sheetObj,formObj,sAction){
             switch(sAction) {
                     case   IBSEARCH_ASYNC02:
                             var pForm=parent;
                             if( pForm.port_cd.GetSelectCode()== "" ){
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
         /**
          * after Load 
          * @param sheetObj
          * @param sErrMsg
          */
         function sheet1_OnSearchEnd(sheetObj, sErrMsg){
             var prefix=sheetObj.id+"_";
//             var updateSys =  parent.form.sys_create_desc.value; //Externally, Internally
             var bEdt=true;
//
//             if( updateSys.indexOf( "Externally" ) > -1 ){
//                	 bEdt = false;
//             }
//             sheetObj.InitDataProperty(0, 3, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_20",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
//             sheetObj.InitDataProperty(0, 7, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_40",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
//             sheetObj.InitDataProperty(0,11, dtAutoSumEx,  55,     daRight,    true,   prefix+"load_45",   false,  "", dfNumber,   0,  bEdt,  bEdt,4);
             
             sheetObj.SetColProperty(0, 3, {Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt});
             sheetObj.SetColProperty(0, 7, {Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt});
             sheetObj.SetColProperty(0, 11,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt});
             
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
	       		SetSheetHeight(sheetHeight > 90?sheetHeight-10:90);
	       	  }    
	     }  
    /* Developer performance  end */