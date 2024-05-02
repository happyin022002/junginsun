/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName   : VOP_SCG_1005.js
 *@FileTitle  : SAVE DG Restriction by Port
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/12
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
     * @class vop_scg_1005 : business javascript for vop_scg_1005
     */
    function vop_scg_1005() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     //	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_rowAdd":
					doActionIBSheet(sheetObject1,document.form,IBINSERT); 					
 					break;
 				case "btn_delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
 					break;
 				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
 					break;
 				case "btn_close":
 					ComClosePopup(); 
 					break;
             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
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
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	         
 		 //doActionIBSheet(sheetObjects[0],document.form,IBINSERT);         
        // axon_event.addListenerForm('keyup',   'obj_keyup',   	form) 
         
        sheet1_OnLoadFinish(sheetObjects[0]);
     }
     function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
      }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	 with(sheetObj){
	               var HeadTitle="|sel|Port Code||Name|Save As Type|Save As Type|Save As Type|Save As Type|Class||UN No./Seq.|UN No./Seq.";
	               var prefix="sheet1_";
	
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                      {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sel" },
	                      {Type:"PopupEdit", Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,  InputCaseSensitive:1  },
	                      {Type:"Text",      Hidden:1,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_port_rstr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"port_cd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sav_type_class_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sav_type_class_label", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sav_type_unno_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sav_type_unno_label",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd_txt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
	                      {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(1);
	               SetShowButtonImage(2);
	               SetSheetHeight(150);
	               
	           
	               }
	               break;
         }
     }
   // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case COMMAND02:      //CLASS code retrieve
                 break;
            case IBSEARCH:      //retrieve
//                 formObj.f_cmd.value = SEARCH01;
//                 var param =  FormQueryString(formObj);
//                 var sXml   =  sheetObj.GetSearchXml("VOP_SCG_1005GS.do", param);
//                 var strCombo = ComXml2ComboString( sXml, "imdg_clss_cd", "imdg_clss_cd_txt"  );
                 formObj.f_cmd.value=SEARCH02;      //SEARCH02            
                 var param=FormQueryString(formObj);
                 //var sXml  = sheetObj.GetSearchXml("VOP_SCG_0005GS.do", param);//SEARCH02
                 var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                 var strCombo=ComXml2ComboString( sXml, "imdg_clss_cd", "imdg_clss_cd_txt"  );
                 sheetObj.SetColProperty("sheet1_imdg_clss_cd", {ComboText:"|"+strCombo[0], ComboCode:"|"+strCombo[1]} );
         		 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                 break;
 			 case IBSAVE:        //save
                 if(!validateForm(sheetObj,formObj,sAction)){ 
            	      return;
                 }
			     formObj.f_cmd.value=MULTI01;
				 var aryPrefix=new Array("sheet1_");
	             var sParam=ComGetSaveString(sheetObjects);
	             if( sParam == ""){ return;}
	             sParam  +=  "&"+FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
	             var sXml=sheetObj.GetSaveData( "VOP_SCG_1005GS.do", sParam);
	             sheetObj.LoadSaveData(sXml);
				 var rslt=ComGetEtcData(sXml, "row");
				 if(rslt != '-1') {
					 sheetObj.SelectCell(parseInt(rslt)+1, 2);
					 for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
						 sheetObj.SetRowStatus(i,"I");
					 }
				 }
                 break;
 			case IBINSERT:      // insert
		         with (sheetObj){
                     //sheetObj.InitDataCombo(0, "sheet1_imdg_clss_cd", "1|2|3|4|5|", "1|2|3|4|5|"); 				
 				     DataInsert(-1);
 				     initRow(sheetObj, LastRow());
 				    // CellValue2(LastRow, "sheet1_sel"  ) = 1;
 				     SelectCell(LastRow(), "sheet1_port_cd" )
			     }
 				 break;
 			case IBDELETE:      // delete
		    	 with (sheetObj){
                     //var cnt = CheckedRows("sheet1_sel");
 				    var cnt=RowCount();
 				    for(var i=0;i<cnt;i++){ 
                        for(var j=1;j<= cnt;j++ ){
if(  GetCellValue(j, "sheet1_sel")  == 1 ){
                                RowDelete(j, false);
                            }
                        } 
 				    }
		    	 } 			
                 break; 			
            case IBSEARCH_ASYNC01:      //retrieve   PORT_NM
				 formObj.f_cmd.value=SEARCH09;;
				 var aryPrefix=new Array("sheet1_");
				 var param="f_cmd="+formObj.f_cmd.value+"&port_cd="+sheetObj.GetCellValue( cRow, "sheet1_port_cd");
				 var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
				 var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm"); 
				 var sMsg=getMessage(sXml);
				 if(sMsg != ""){
					 ComShowMessage(sMsg); 
					 sheetObj.SetCellValue(cRow, "sheet1_port_cd","",0);
					 sheetObj.SetCellValue(cRow, "sheet1_port_cd_nm","",0);
					 sheetObj.SelectCell(cRow, "sheet1_port_cd");
                     return;
				 }				 
				 sheetObj.SetCellValue(cRow, "sheet1_port_cd_nm",port_cd_nm,0);
	             break;
         }
     }
     function getMessage(sXml){
    	 return ComScgGetMessageFromXml(sXml);
 	}
     function initRow(sheetObj, Row){ 
    	 var formObj=document.form;
    	 sheetObj.SetCellValue(Row, "sheet1_sav_type_class_label","Class",0);
    	 sheetObj.SetCellValue(Row, "sheet1_sav_type_unno_label","UN No.",0);
    	 //sheetObj.CellValue2(Row, "sheet1_sav_type_unno_label")  = "UN No.";
    	 sheetObj.SetCellValue(Row, "sheet1_imdg_clss_cd",formObj.imdg_clss_cd.value,0);
    	 sheetObj.SetCellValue(Row, "sheet1_imdg_un_no",formObj.imdg_un_no.value,0);
    	 sheetObj.SetCellValue(Row, "sheet1_imdg_un_no_seq",formObj.imdg_un_no_seq.value,0);
    //	 sheetObj.CellValue2(Row, "sheet1_sav_type_unno_label")  = "UN No.";
    	 var strOpt=formObj.strOpt.value;
    	 with(sheetObj){
	    	 if( strOpt == "class"){
//
//	    		 CellEditable(Row, "sheet1_sav_type_class_flag")  = true;
//	    		 CellEditable(Row, "sheet1_sav_type_unno_flag")   = false;    	
//	    		 
//	    		 CellEditable(Row, "sheet1_imdg_un_no")       = false;
//	    		 CellEditable(Row, "sheet1_imdg_un_no_seq")   = false;
//	    		 CellEditable(Row, "sheet1_imdg_clss_cd")     = true;	    		 
//	    		 
	        	 sheetObj.SetCellValue(Row, "sheet1_sav_type_class_flag",1,0);
	    	 }
	    	 if( strOpt == "unno"){
//	    		 CellEditable(Row, "sheet1_sav_type_unno_flag")  = true;
//	    		 CellEditable(Row, "sheet1_sav_type_class_flag") = false;
//	    		 
//	    		 CellEditable(Row, "sheet1_imdg_un_no")      = true;
//	    		 CellEditable(Row, "sheet1_imdg_un_no_seq")  = true;
//	    		 CellEditable(Row, "sheet1_imdg_clss_cd")     = false;
	        	 sheetObj.SetCellValue(Row, "sheet1_sav_type_unno_flag",1,0);
	    	 }
    	 }
	 }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
               switch(sAction) {
 				   case IBSAVE:
//    			    	for(var i=1;i<=sheetObj.RowCount;i++){
//    			    		 if( sheetObj.CellValue(i,"sheet1_port_cd_nm") == "" ){
//	 					          ComShowCodeMessage("SCG01001","Port Cd" );
//    			    		      sheetObj.SelectCell(i, "sheet1_port_cd");
//    			    		      return;
// 					    	  }
//                        }
 					    if(  formObj.strOpt.value == "class"){
 	 					    var strCode=formObj.port_cd.value+"|"+formObj.imdg_clss_cd.value;
 					    	for(var i=1;i<=sheetObj.RowCount();i++){
//                                if( sheetObj.CellValue(i,"sheet1_imdg_clss_cd") == "" ){
//                                	ComShowCodeMessage("SCG00302","(Row:"+i+")");
//                                }
 					    		var rowStrCode=sheetObj.GetCellValue(i,"sheet1_port_cd")+"|"+sheetObj.GetCellValue(i,"sheet1_imdg_clss_cd");
	 	 					    if( strCode == rowStrCode ){
	 	 					    	ComShowCodeMessage("SCG50005",'Data');
	 	 					    	sheetObj.SetSelectRow(i);
	 	 					    	return false;
	 	 					    }
	 					    }
 					    }
 					    if(  formObj.strOpt.value == "unno"){
 	 					    var strCode=formObj.port_cd.value+"|"+formObj.imdg_un_no.value+"|"+formObj.imdg_un_no_seq.value;
	 					    for(var i=1;i<=sheetObj.RowCount();i++){
	 					    	var rowStrCode=sheetObj.GetCellValue(i,"sheet1_port_cd")+"|"+sheetObj.GetCellValue(i,"sheet1_imdg_un_no")+"|"+sheetObj.GetCellValue(i,"sheet1_imdg_un_no_seq");
	 	 					    if( strCode == rowStrCode){
	 	 					    	ComShowCodeMessage("SCG00302","(Row:"+i+")");
	 	 					    	sheetObj.SetSelectRow(i);
	 	 					    	return false;
	 	 					    }
	 					    }
 					    }
 	                   if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
                            return false;   
                        }
 					    break;
             } // end switch
         }
         return true;
     }
 	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
	   	    if(ColSaveName(Col) == "sheet1_port_cd"){
	   	    	var port_cd=GetCellValue(Row, Col);
                ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 427, 495, "setPortNm", "0,0", false,false,Row, Col, 0, "COM_ENS_051");
	   	    } 
	   	    if(ColSaveName(Col) == sheetObj.id+"_imdg_un_no_seq"){
    	    	ComOpenPopup('/opuscntr/VOP_SCG_3005.do',940, 397, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", false,false, Row, Col, 0);	    	
	    	}   	   	    
 		}
 	}
    /**
     * Retrieving Unno, seq, ClassCd by Unno Help Popup.
     * @param  {Array} aryPopupData	compulsory	 Array Object
     * @param  {Int} row				optional selected Row
     * @param  {Int} col				optional selected Column
     * @param  {Int} sheetIdx		optional Sheet Index
     * @return none
     */  
     function setUnnoAndClassCd(aryPopupData,row, col, seetIdx){
        var prefix=sheetObjects[seetIdx].id+"_";
    	with( sheetObjects[seetIdx] ){
    		SetCellText( row, prefix+"imdg_clss_cd" ,aryPopupData[0][4]);//class cd
    		SetCellValue( row, prefix+"imdg_clss_cd_txt",aryPopupData[0][4],0);
    		SetCellValue( row, prefix+"imdg_un_no",aryPopupData[0][2],0);
    		SetCellValue( row, prefix+"imdg_un_no_seq",aryPopupData[0][3],0);
    		SetCellValue( row, prefix+"prp_shp_nm",aryPopupData[0][6],0);
    	}
     } 	
    /**
     * @param  {Array} aryPopupData	compulsory	 Array Object
     * @param  {Int} row				compulsory selected Row
     * @param  {Int} col				compulsory selected Column
     * @param  {Int} sheetIdx			compulsory Sheet Index
     * @return none
     */   
    function setPortNm(aryPopupData, row, col, sheetIdx){
    	with(sheetObjects[0]){
//    		SetCellValue( row , col,aryPopupData[0][2],0);
//    		SetCellValue( row , "sheet1_port_cd_nm",aryPopupData[0][3],0);
    		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow() , "sheet1_port_cd",aryPopupData);
    	}
    }
  	// event when cell value change
  	function sheet1_OnChange(sheetObj, Row, Col, Value)
  	{  
  		with(sheetObj)
  		{
  			switch(sheetObj.ColSaveName(Col) )
 			{
				case  sheetObj.id+"_port_cd":
	  		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, Row);  	
 					break;  			
 				case sheetObj.id+"_imdg_clss_cd":
 	                SetCellValue(Row, "sheet1_imdg_clss_cd_txt",GetCellText(Row, "sheet1_imdg_clss_cd" ),0);
 					break;
// 				case sheetObj.id+"_imdg_un_no_seq": 	
//	  		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02, Row);  	 					
// 					break;
 			}  			 
  		}
  	}
