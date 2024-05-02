/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0074.jsp
 *@FileTitle : Special Provisions for Segregation (Inquire)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0074 : business javascript for vop_scg_0074
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0; 
    // Event handler processing by button click event */
    document.onclick=processButtonClick; 
    // Event handler processing by button name */
        function processButtonClick(){
            /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
            var sheetObject1=sheetObjects[0];
            /*******************************************************/
            var formObject=document.form;
          //  try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                var doc=document.all;
                var srcObj=window.ComGetEvent();
                if( srcName == null ){return;}
                if( srcName.indexOf("btn") == -1  ){
                    return;
                }else{
                    if( srcObj.className=="btn2_1" ){
                        return;
                    }
                }
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                        break;
                    case "btn_Excel":
                    	if(sheetObjects[0].RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                       }else{
                        var paramObj=new Object();
                        paramObj.title="Special Provisions for Segregation";
//                        paramObj.columnwidth="2:10|3:10|4:60|5:5|6:15|7:15";                        
//                        var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);  
//                        sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol( sheetObjects[0]), SheetDesign:1,Merge:1 });
						var sheetExcelObj = sheetObjects[0];
	                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
	                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
	                    paramObj.datarowheight="0:25";
	                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
	                    
	                    if(sheetExcelObj.RowCount() < 1){//no data
	                		  ComShowCodeMessage("COM132501");
	        	       	}else{
		       	       		var str = sheetExcelObj.GetSearchData(url);
		       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
		       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
	        	       	}                        
                       }
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
                //Initializing IBMultiCombo
                for(var k=0; k < comboObjects.length; k++){
                    initCombo(comboObjects[k], k + 1);
                }
            }
            initControl();         
        }
        function sheet1_OnLoadFinish(sheetObj) {
             doActionIBSheet( sheetObj,document.form,IBRESET);
         }            
        function initControl() {
             //axon_event.addListenerForm('keypress', 'obj_keypress',    form  );
             axon_event.addListenerForm('change',   'obj_change',form); //- focus out
             //axon_event.addListenerForm('keyup',    'obj_keyup',form);  
             initBtn(false);
        }
        /** 
         * register IBCombo Object as list
         * @param    {IBCombo}  combo_obj   IBCombo Object
         */ 
        function setComboObject(combo_obj){
            comboObjects[comboCnt++]=combo_obj;
        }      
         /**
         * Initializing Combo 
         * param : comboObj, comboNo
         * adding case as numbers of counting combo
         */ 
         function initCombo(comboObj, comboNo) {
                switch(comboObj.options.id) {
                    case "imdgsclprovino":    
                        var i=0;
                        with(comboObj) {
                            InsertItem(0,   "1", "1");
                            InsertItem(1,   "2", "2");                         
                        }
                        break;
                }
        }
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetObj.id) {
                case "sheet1":      //sheet1 init
                    with(sheetObj){
                    
                  var HeadTitle1="|No.|UN No./Seq.|UN No./Seq.|Proper Shipping Name|Class|Subsidiary risk(s)|Packing Group";
                  var headCount=ComCountHeadTitle(HeadTitle1);

                  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"PopupEdit", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:560,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd_1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                   
                  InitColumns(cols);
                  //SetSheetHeight(420);
                  resizeSheet();
                  SetEditable(0);
                  SetColProperty(0 ,"imdg_un_no" , {AcceptKeys:"E"});
                  }


                    break;
            }
        }
        function resizeSheet(){
       	 	ComResizeSheet(sheetObjects[0]);
        }
        // Sheet related process handling
        function doActionIBSheet(sheetObj,formObj,sAction,pRow) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                case IBRESET: 
                     //formObj.imdgsclprovino.focus();
                     break;
                case IBSEARCH:      //retrieve
                     if( !validateForm(sheetObj,formObj,sAction)){
                         return;
                     }             
                     formObj.f_cmd.value=SEARCHLIST01;
                     var param=FormQueryString(formObj);  
                     sheetObj.DoSearch("VOP_SCG_0073GS.do", param );
                     break;
            }
        }
        /**
         * Handling Sheet1 OnPopupClick event  
         * @param sheetObj
         * @param Row
         * @param Col
         * @return
         */
        function sheet1_OnPopupClick(sheetObj, Row, Col)
         {
             with(sheetObj)
             {
                 if( sheetObj.ColSaveName(Col) ==  'imdg_un_no_seq' ){
                      var imdg_un_no=sheetObj.GetCellText(Row,   'imdg_un_no'     );
                      var imdg_un_no_seq=sheetObj.GetCellText(Row,   'imdg_un_no_seq' );
                      ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,940, 400, "setSheet1_PopupCallback_ImdgUnNoSeq", "0,1,1,1,1,1,1,1", true,true, Row, Col, 0);
                 }
             }
         }
        /**
        * Sheet1 OnPopupClick CallBack function handling ImdgUnNoSeq event
        * @param aryPopupData
        * @param row
        * @param col
        * @param seetIdx 
        * @return
        */
        function setSheet1_PopupCallback_ImdgUnNoSeq(aryPopupData,row, col, seetIdx){
            sheetObjects[seetIdx].SetCellValue(row, "imdg_un_no",aryPopupData[0][2],0);//UnNo
            sheetObjects[seetIdx].SetCellValue(row, "imdg_un_no_seq",aryPopupData[0][3],0);//UnNoSeq
            sheetObjects[seetIdx].SetCellValue(row, "imdg_clss_cd",aryPopupData[0][4],0);//ClassCd
            sheetObjects[seetIdx].SetCellValue(row, "prp_shp_nm",aryPopupData[0][6],0);
            sheetObjects[seetIdx].SetCellValue(row, "imdg_pck_grp_cd",aryPopupData[0][8],0);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01,row);
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
                switch ( sAction ){
                        case IBSEARCH:
                            if(imdgsclprovino.GetSelectText()== ""){
                                ComShowCodeMessage('SCG50011', 'Table No.');   
                               // formObj.imdgsclprovino.focus();
                                return false;
                            }
                            break;             
                }
            return true;
        }
        /**
         * Grid one row Clear
         * @param  void
         * @return void
         */            
         function fnClearUnnoInfo(sheetObj, pRow){
             sheetObj.SetCellValue(pRow, "prp_shp_nm"  ,"",0);
             sheetObj.SetCellValue(pRow, "imdg_clss_cd","",0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_1","",0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_2","",0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_3","",0);
             sheetObj.SetCellValue(pRow, "imdg_pck_grp_cd"       ,"",0);
         }
         /**
          * 
          * <pre>
          *     Setting Unno information by Unno, Unnoseq.
          * </pre>
          *
          * @param  Object sheetObj, String sXml, String pRow 
          * @return void
          * @author 
          */
         function fnSetUnnoInfo(sheetObj, sXml, pRow){
             var formObj=document.form;
             var imdg_tbl_no=ComScgGetRowValue(sXml,1,"imdg_tbl_no");
             if( formObj.imdgsclprovino.value != imdg_tbl_no && imdg_tbl_no != ""){
                 ComShowCodeMessage("SCG50005", "UN No./Seq [Table No : "+imdg_tbl_no+"]");
                 sheetObj.SetCellValue(pRow, "imdg_un_no"  ,"",0);
                 sheetObj.SetCellValue(pRow, "imdg_un_no_seq","",0);
                 sheetObj.SelectCell( pRow, "imdg_un_no") ;
                 return;
             }
             sheetObj.SetCellValue(pRow, "prp_shp_nm"  ,ComScgGetRowValue(sXml,1,"prp_shp_nm"),0);
             sheetObj.SetCellValue(pRow, "imdg_clss_cd",ComScgGetRowValue(sXml,1,"imdg_clss_cd"),0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_1",ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_1"),0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_2",ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_2"),0);
             sheetObj.SetCellValue(pRow, "imdg_subs_rsk_lbl_cd_3",ComScgGetRowValue(sXml,1,"imdg_subs_rsk_lbl_cd_3"),0);
             sheetObj.SetCellValue(pRow, "imdg_pck_grp_cd"       ,ComScgGetRowValue(sXml,1,"imdg_pck_grp_cd"       ),0);
         }
        /**
         * Handling Form Object obj_keypress event
         * @param  void
         * @return void
         */     
//         function obj_keypress (){
//             var obj=ComGetEvent();
//             switch(ComGetEvent("name")){
//                  case 'imdgsclprovino':
//                       ComKeyOnlyNumber(obj);
//                       break;
//             }
//         }      
         /**
          * Handling Form Object  blur event
          * @param  void
          * @return void
          */     
          function obj_change (){
                var obj=ComGetEvent();
                var formObj=document.form;
                switch(ComGetEvent("name")){
                   case "imdgsclprovino":
                         if( obj.value != "" ){
                             doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                         }else{
                             fnNewGrid();
                             initBtn(false);
                         }
                         break;
                }
          }
          function initBtn(Yn){
              var doc=document.all;
              if( Yn ){
           	   ComBtnEnable("btn2_Row_Add");
           	   ComBtnEnable("btn2_Row_Insert");
           	   ComBtnEnable("btn2_Row_Copy");
           	   ComBtnEnable("btn2_Row_Delete");
              }else{
           	   ComBtnDisable("btn2_Row_Add");
           	   ComBtnDisable("btn2_Row_Insert");
           	   ComBtnDisable("btn2_Row_Copy");
           	   ComBtnDisable("btn2_Row_Delete");
              }
          }
          /**
           * 
           * <pre>
           *    Grid data clear
           * </pre>
           *
           * @param   
           * @return
           * @author
           */
          function fnNewGrid(){
                  var cnt=sheetObjects[0].RowCount();
                  for(var j=1;j<= cnt;j++ ){
                      sheetObjects[0].RowDelete(1, false);
                  }
          } 
           function imdgsclprovino_OnChange(comboObj, Index_Code, Text){
               var formObj=document.form;
               switch (comboObj.options.id){
                  case "imdgsclprovino":
                        if( comboObj.GetSelectCode()!= "" ){
                            doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                        }else{
                            fnNewGrid();
                            initBtn(false);
                        }
                        break;
               }          
           }
