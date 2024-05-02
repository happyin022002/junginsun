/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_01.js
*@FileTitle  : RDR Creation ? VSL Mvmt
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
     * @class VOP_OPF_0046_01 : VOP_OPF_0046_01 business script for
     */
    function VOP_OPF_0046_01() {
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
    var dddss=0;
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
                                   sheetObjects[0].SelectCell( pRow, prefix+"port_cd") ;
                                   break;
                            case   "btn_Row_Insert":
                                   var pRow=sheetObjects[0].DataInsert();
                                   sheetObjects[0].SelectCell( pRow, prefix+"port_cd") ;
                                   break;
                            case   "btn_Row_Copy":
                                   sheetObjects[0].DataCopy();
                                   break;
                            case   "btn_Row_Delete":
                                   ComRowHideDelete(sheetObjects[0], prefix+"sel_chk");
                                   break;
                            case   "btn_ImportVesselMovement":
                                   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);        
                                   break;
                            case "btn_DownExcel":
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
            initControl(); 
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
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":
                    with(sheetObj){
						var HeadTitle="|Sel.|Port|Arrival Time|Berthing Time|Unberthing Time|Departure Time|Call Ind";
						var headCount=ComCountHeadTitle(HeadTitle);
						var prefix=sheetObj.id+"_";
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
						 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },	//,   UpdateEdit:1,   InsertEdit:1
						 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"berth_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },	//,   UpdateEdit:1,   InsertEdit:1
						 {Type:"Text",      Hidden:0,  Width:195,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unberth_time", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },	//,   UpdateEdit:1,   InsertEdit:1 
						 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },   //,   UpdateEdit:1,   InsertEdit:1
						 {Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"call_ind",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
						InitColumns(cols);
						SetSheetHeight(340);
						SetEditable(1);
						SetColProperty(prefix+"arr_time", {Format:"####-##-## ##:##"} );
						SetColProperty(prefix+"berth_time", {Format:"####-##-## ##:##"} );
						SetColProperty(prefix+"unberth_time", {Format:"####-##-## ##:##"} );
						SetColProperty(prefix+"dep_time", {Format:"####-##-## ##:##"} );
                	}
                    break;
            }
        }
      // handling process related Sheet
        function doActionIBSheet(sheetObj,formObj,sAction, cRow ) {
                if(sheetObj  == null ){ return;}
                var prefix=sheetObj.id+"_";
                switch(sAction) {
                        case    IBSEARCH:      //Retrieve
                                if(!validateForm(sheetObj,formObj,sAction)){return;}
                                formObj.f_cmd.value=SEARCHLIST01;  
                                var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                var sXml=sheetObj.GetSearchData("VOP_OPF_0046_01GS.do",  param );
                                sheetObj.LoadSearchData(sXml,{Sync:1} );
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                    ComSetObjValue(formObj.next_port,  ComGetEtcData(sXml, "NEXT_PORT" ) );
                                    ComSetObjValue(formObj.eta       , ComGetEtcData(sXml, "ETA") );
                                    ComSetObjValue(formObj.next_canal, ComGetEtcData(sXml, "NEXT_CANAL") );
                                    ComSetObjValue(formObj.eta_canal , ComGetEtcData(sXml, "ETA_CANAL" ) );
                                }else{
                                    ComClearObject(formObj.next_port  );
                                    ComClearObject(formObj.eta  );
                                    ComClearObject(formObj.next_canal );
                                    ComClearObject(formObj.eta_canal  );
                                }
                                fnSubBtnAuth(true);
                                break;
                        case    IBSEARCH_ASYNC01:  // Grid Port Code Key In시.
                                formObj.f_cmd.value=SEARCH12;            
                                formObj.port_cd.value=sheetObj.GetCellValue( cRow, prefix+"port_cd");
                                var param=FormQueryString(formObj);
                                var sXml=sheetObj.GetSearchData("VOP_OPF_UTILGS.do", param);
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                    if( ComGetTotalRows(sXml) == "0"  ){
                                        ComShowCodeMessage("COM132201", "Port");
                                        sheetObj.SetCellValue( cRow, prefix+"port_cd","",0);
                                        sheetObj.SelectCell( cRow, prefix+"port_cd");
                                    } 
                                }
                                break;
                        case    IBSEARCH_ASYNC02:  
                                if( !validateForm( sheetObj,formObj,sAction )){return;}                            
                                /********   setting retrieve condition of Main Frame as Sub Frame Hidden value.   *******/
                                fnSetMainSearchOption();
                                formObj.f_cmd.value=SEARCHLIST02;  
                                var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
                                sheetObj.DoSearch("VOP_OPF_0046_01GS.do", param );
                                break;   
                        case    IBSAVE:
                                parent.bTabChangeGo=false;
                                formObj.f_cmd.value=MULTI01;
                                if( !validateForm( sheetObj,formObj,sAction ) ){
                                    return;
                                }  
                                var sParam=ComGetSaveString( sheetObj, true, true );
                                if( sParam == ""){
                                    parent.sSheetObjIdx=0;
                                    parent.iSelectCell=sheetObj.GetSelectCol();
                                    return;
                                }
                                sParam  +=  "&"+FormQueryString(formObj);
                                var sXml=sheetObj.GetSaveData("VOP_OPF_0046_01GS.do" ,   sParam  );
                                sheetObj.LoadSaveData( sXml );
                                parent.bTabChangeGo=true;
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                    parent.fnGetHeader();
                                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
                                }
                                break;        
                        case    IBDELETE:  
                                if(!validateForm( sheetObj,formObj,sAction  )){return;}
                                formObj.f_cmd.value=REMOVE;         
                                var sParam=FormQueryString(formObj);
                                var sXml=sheetObj.GetSaveData("VOP_OPF_0046_01GS.do" ,   sParam  );
                                sheetObj.LoadSaveData( sXml );
                                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                     for(var i=0;i<sheetObjects.length;i++){
                                         sheetObjects[i].RemoveAll();
                                     }
                                     if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
                                         for(var i=0;i<sheetObjects.length;i++){
                                             sheetObjects[i].RemoveAll();
                                         }
                                         ////////////Parent Header Sheet Clear//////////
                                         parent.sheetObjects[0].RemoveAll();
                                     }
                                }
                                break;  
                        case    IBRESET: //Btn_New
                                ComClearObject(formObj.next_port  );
                                ComClearObject(formObj.eta  );
                                ComClearObject(formObj.next_canal );
                                ComClearObject(formObj.eta_canal  );
                                for(var i=0;i<sheetObjects.length;i++){
                                    sheetObjects[i].RemoveAll();
                                }
                                fnSubBtnAuth(false);
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
            var prefix=sheetObj.id+"_";
            with(sheetObj)
            {
                if( sheetObj.ColSaveName(Col) == prefix+'port_cd' ){
//                	var port_cd=sheetObj.GetCellValue(Row, Col);
//                  parent.ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 520, "PopupCallback_port", "0,0", true, false, Row, Col, 0);
                	parent.getCallBack(sheetObj, prefix, "port_cd", Row, Col);
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
                    case prefix+'port_cd' :
                          if( sheetObj.GetEditText().length == 5){
                              sheetObj.SetCellValue(Row, prefix+'port_cd'  ,sheetObj.GetEditText().toUpperCase(),0);
                              doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, Row);                            
                          } 
                          break;
             }
        }
        function  sheet1_OnChange(sheetObj, Row, Col,Value) {
            var formObj=document.form;
            var prefix=sheetObj.id+"_";
            switch( sheetObj.ColSaveName(Col)  ){
                   case prefix+'port_cd' :
                	   if( sheetObj.GetCellValue( Row, Col ).length < 5 && sheetObj.GetCellValue( Row, Col ).length > 0 ){
                             ComShowCodeMessage('OPF50007', 'Port Code', "5");
                             sheetObj.SetCellValue( Row, Col,"",0);
                             sheetObj.SelectCell( Row, Col);
                             return;
                         }
                         break;
                   case prefix+'arr_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'berth_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'unberth_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
                   case prefix+'dep_time' :
                        fnCheckDate(sheetObj, Row, Col);
                        break;
            }
        }
        function fnCheckDate(sheetObj, Row, Col){
        	var dateTmp=sheetObj.GetCellValue(Row, Col);
            if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
                ComShowMessage(ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm'));
                sheetObj.SelectCell(Row, Col, true);
                return false;
            } 
            return true;
        }
        /**
         * CallBack method of Sheet1 OnPopupClick event
         * @param aryPopupData
         * @param row
         * @param col
         * @param seetIdx 
         * @return
         */
//        function PopupCallback_port(aryPopupData,row, col, seetIdx){
//            var formObj=document.form;
//            sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][2],0);
//            setTimeout( function(){ doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC01, row); }, 400);
//        }
//        VOP_OPF_0046.js
//        function  PopupCallback_port(aryPopupData){
//            var sheetObj = sheetObjects[0];
//            var row = sheetObj.GetSelectRow();
//            var col = sheetObj.GetSelectCol();
//            sheetObj.SetCellValue(row, col,aryPopupData,0);
//        }
        /**
         * 
         * <pre>
         *    DupCheck of code chosen
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
                             pForm.port_cd.Focus();
                             return false;
                        }
                        break;
                 case   IBSAVE:
                        if( sheetObj.RowCount()> 10 ){
                           ComShowCodeMessage("OPF50023", "10");
                           return false;
                        }
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
	  *  date check logic like Arrival Date < Berthing Date 
	  */
     function chkDate(){ 
    	var prefix=sheetObjects[0].id+"_";
    	// data format check
    	for(var i=1; i<sheetObjects[0].RowCount()+1; i++){
    		if(!fnCheckDate(sheetObjects[0], i, prefix+"arr_time")) {
            	return false;
            }
            if(!fnCheckDate(sheetObjects[0], i, prefix+"berth_time")) {
            	return false;
            }
            if(!fnCheckDate(sheetObjects[0], i, prefix+"unberth_time")) {
            	return false;
            }
            if(!fnCheckDate(sheetObjects[0], i, prefix+"dep_time")) {
            	return false;
            }
    	}
    	for(var i=1; i<sheetObjects[0].RowCount()+1; i++){
    		var arrTime 	= sheetObjects[0].GetCellValue(i, prefix+"arr_time");
    		var berthTime 	= sheetObjects[0].GetCellValue(i, prefix+"berth_time");
    		var unberthTime = sheetObjects[0].GetCellValue(i, prefix+"unberth_time");
    		var depTime 	= sheetObjects[0].GetCellValue(i, prefix+"dep_time");
    		
    		if(arrTime > berthTime)
	    	{    		
    			ComShowCodeMessage("OPF50013", "Berthing Time", "Arrival Time");
//	    		ComShowCodeMessage("COM132401");
	    		return false;
	    	}
    		if(berthTime > unberthTime)
	    	{    		
    			ComShowCodeMessage("OPF50013", "Unberthing Time", "Berthing Time");
//	    		ComShowCodeMessage("COM132401");
	    		return false;
	    	}	    	
    		if(unberthTime > depTime)
	    	{    		
    			ComShowCodeMessage("OPF50013", "Depature Time", "Unberthing Time");
//	    		ComShowCodeMessage("COM132401");
	    		return false;
	    	}		    	
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
      		SetSheetHeight(sheetHeight > 90?sheetHeight-80:90);
      	  }    
      }    
	/* Developer performance  end */