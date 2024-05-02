/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0033.jsp
 *@FileTitle : Loading Port for RSO - Creation
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
     * @class ui_scg_0033 : business script for ui_scg_0033 
     */
  
 // common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0; 
 var gRow=0;
 var dup_chk="";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
        /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
         var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        var doc=document.all;
  //   	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 							break;
 							case "btn_add":			
 			                     if( doc.btn_add.className == "btn2_1"){
 			                         return;
 			                     }    							    
 								sheetObject.DataInsert(-1);
 								sheetObject.SelectCell( sheetObject.LastRow(),"sheet1_loc_cd");
 							break;
 							case "btn_insert":
                                if( doc.btn_insert.className == "btn2_1"){
                                    return;
                                }   							    
 								sheetObject.DataInsert();
 								sheetObject.SelectCell( sheetObject.GetSelectRow(),"sheet1_loc_cd");
 							break; 
 							case "btn_delete":
                                if( doc.btn_delete.className == "btn2_1"){
                                    return;
                                }        							    
 								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 							break;	
 							case "btn_save":
//                                if( doc.btn_save.className == "btn2_1"){
//                                    return;
//                                }   							    
 								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 							break;		
 							case "btn_copy":
//                                if( doc.btn_copy.className == "btn2_1"){
//                                    return;
//                                }    							    
 								doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
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
         //
             ComConfigSheet (sheetObjects[i] );
             //sheetObjects[i].WaitImageVisible = false;
             initSheet(sheetObjects[i],i+1);
         //
             ComEndConfigSheet(sheetObjects[i]);
            // initControl(i);
         }
  	 	//IBMultiCombo초기화
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	   initControl(); 
 	   //@@ 콤보조회 
 	   sheet1_OnLoadFinish(sheet1);
 		//doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     
      //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
         //doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
      }
     //@@콤보조회
     function sheet1_OnLoadFinish(sheetObj) {
     	doActionIBSheet( sheetObj,document.form,IBCLEAR);
     } 
      /**
       * Initializing Form Conrol. <br>
       * @param  {object} sheetObj	compulsory
       * @return none
       * @author 
       * @version 
       */
      function initControl(sheetObj){
      	// Form object
      	 formObj=document.form;
          // register axon event
          //axon_event.addListenerFormat('keypress', 'obj_keypress', form);
          axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
          //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
         // axon_event.addListenerForm  ('focusout', 'obj_focusout', form);
//          axon_event.addListenerFormat('keypress', 'obj_keypress', form);
      	initUseBtn(false);
      }
	/** 
	 * register IBCombo Object as list
	 * @param    {IBCombo}	combo_obj	register IBCombo Object list
	 */	
    function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}      
     /**
     * initializing Combo 
     * param : comboObj, comboNo
     * adding case as numbers of counting combo
     */ 
     function initCombo(comboObj, comboNo) {
    	    switch(comboObj.options.id) {
    	        case "rso":    
    	            var i=0;
    	            with(comboObj) {
    	            	SetTitle("Code|Description");
    	            	SetColAlign(0, "center");
    	            	SetColAlign(1, "left");
    	            	SetColWidth(0, "50");
    	            	SetColWidth(1, "150");
    	            	SetDropHeight(260);
    	            	SetMultiSelect(0);
    	            	SetMaxSelect(1);
    	            	SetUseAutoComplete(1);
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
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
                     // setting height
            	 
//            	 (9, 0, 0, true);
            	 var HeadTitle="|Sel.|No.|Loading Port Code|Port Name|RSO Code|Country";
            	 var prefix="sheet1_";

            	 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"loc_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rgn_shp_opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:520,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cnt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix+"key_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix+"key_rgn_shp_opr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	  
            	 InitColumns(cols);
            	 //SetSheetHeight(420);
            	 resizeSheet();
            	 SetEditable(1);
            	 SetColProperty(prefix+"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//            	 SetGetShowButtonImage()(1);
                }
                 break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
   // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, cRow, loc_cd) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBCLEAR:   
			formObj.f_cmd.value=SEARCH01;
			var aryPrefix=new Array("sheet1_");
			var sXml=sheetObj.GetSearchData("VOP_SCG_0033GS.do", FormQueryString(formObj) );
			sheetObj.ShowDebugMsg(false);
			var sRso=ComGetEtcData(sXml, "cmbRso");
			if(sRso != undefined){
				var arrRso=sRso.split("%");
			    MakeComboObject(rso, arrRso);
	         }
	         //doActionIBSheet(sheetObj,formObj,IBSEARCH);
		      break;   
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)){
					return;
				}
				formObj.f_cmd.value=SEARCH;
				var aryPrefix=new Array("sheet1_");
				var sXml=sheetObj.GetSearchData("VOP_SCG_0033GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix ));
				sheetObj.ShowDebugMsg(false);
				var arrXml=sXml.split("|$$|");
				//sheetObjects[0].Redraw = false;    							
				for(var i=0; i < arrXml.length; i++){ 
					if(i > 0) {
						sheetObjects[i].SetWaitImageVisible(0);
					}  
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
				 var total=ComGetTotalRows(arrXml[0]);
                // if(total != "0"){
                 initUseBtn(true);
               //  }
			     break;
			case IBDELETE:      // delete
				if (sheetObj.id == 'sheet1') {   
					 ComRowHideDelete(sheetObj, "sheet1_del_chk");
		   	   	}
				break;
			case IBSAVE:        //save
			    //alert(sheetObj.CellValue(1,0)+"    "+sheetObj.CellValue(1,1)  );
				if(!validateForm(sheetObj,formObj,sAction)){
					return;
				}
				formObj.f_cmd.value=MULTI;	
				var sParam=ComGetSaveString(sheetObjects);
			    if (sParam == "") return;
			    sParam += "&" + FormQueryString(formObj);
				var aryPrefix=new Array("sheet1_");
			    var sXml=sheetObjects[0].GetSaveData("VOP_SCG_0033GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
			    sheetObjects[0].LoadSaveData(sXml);
			 //   sheetObjects[1].LoadSaveXml(sXml); 
		        sheetObj.ShowDebugMsg(false);
                break;
			case IBINSERT:      // insert
                InitDataProperty(0, 2, dtData,        200,    daCenter,     true,   prefix+"rgn_shp_opr_cd",      true,     "",      dfNone,             0,      false,    false);    						
			    break;
			case IBCOPYROW:	 
			    if (sheetObj.id == "sheet1") {
				    var row=sheetObj.DataCopy();
				    sheetObj.SetRowStatus(row,"I");
			    }; 
			break;
			case IBSEARCH_ASYNC01:
				formObj.f_cmd.value=SEARCH02;
				var aryPrefix=new Array("sheet1_");
                var param="f_cmd="+formObj.f_cmd.value+"&loc_cd="+loc_cd+"&" + ComGetPrefixParam( aryPrefix ) ;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0033GS.do",  param);
	        	var loc_info=ComGetEtcData(sXml,"loc_info");
	        	if( loc_info != ""){
	        	    var aLocinfo=loc_info.split("|");
	        	    sheetObj.SetCellValue(cRow,"sheet1_cnt_nm",aLocinfo[2],0);
	        	}
			break;
			case IBSEARCH_ASYNC02:
				formObj.f_cmd.value=SEARCH04;
				var aryPrefix=new Array("sheet1_");
                var param="f_cmd="+formObj.f_cmd.value+"&loc_cd="+loc_cd+"&" + ComGetPrefixParam( aryPrefix ) ;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0033GS.do",  param);
				dup_chk=ComGetEtcData(sXml,"dup_chk");
	        	if( dup_chk == "Y"){
	        		ComShowCodeMessage("SCG50005", "Data");
	        		sheetObj.RowDelete(cRow,0);
	        	}
			break;
         }
     }
     function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift ){
    	 if(KeyCode==13){
    		 getLocCd(sheetObj, Row, Col, sheetObj.SelectCell(Row, Col)  );
    	 }
     }     
     function sheet1_OnChange(sheetObj, row, col) {
		 if( sheetObj.ColSaveName(col) == "sheet1_loc_cd" ){
			 
			   //RSO단위로 UNIQUE하게 처리
			   doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC02, row, sheetObj.GetCellValue(row, col));
			   if(dup_chk == "Y"){
				   dup_chk = "";
				   return;
			   }
			 
			 if( (sheetObj.GetCellValue(row, col)).length != 5 ){
    	    	 ComShowCodeMessage("SCG50006","Port Code","5");
    	    	 sheetObj.SelectCell(row, "sheet1_loc_cd");
    	    	 return;
			 }
			 getLocCd(sheetObj, row, col, sheetObj.SelectCell(row, col)  );
             var Row=sheetObj.ColValueDup("sheet1_loc_cd|sheet1_rgn_shp_opr_cd",false);
    	     if( Row != -1){
    	    	 ComShowCodeMessage("SCG50005", "Data");
    	    	 sheetObj.SetCellValue(Row, "sheet1_loc_cd" ,"",0);
    	    	 sheetObj.SetCellValue(Row ,"sheet1_rgn_shp_opr_cd" ,"",0);
    	    	 sheetObj.SetCellValue(Row ,"sheet1_cnt_nm" ,"",0);
    	    	 sheetObj.SetSelectRow(Row);
    	    	 return false;
    	     }
		 }
     }
     /**
     * when input value change in IBSheet Object
     */
    function getLocCd(sheetObj,Row, Col, Value){
    	var key=sheetObj.GetCellValue(Row,"sheet1_loc_cd")+"|"+sheetObj.GetCellValue(Row,"sheet1_rgn_shp_opr_cd");
    	 //chkSheetDup(sheetObj, Row, key);
    	 if( sheetObj.ColSaveName(Col) == "sheet1_loc_cd" ){
    		 document.form.loc_cd.value=sheetObj.GetCellValue(Row,"sheet1_loc_cd");
            document.form.f_cmd.value=SEARCH02;
 			var sXml=sheetObj.GetSearchData("VOP_SCG_0033GS.do", FormQueryString(document.form) );
		    var msg=ComScgGetMessageFromXml(sXml); 	
		    if( msg != "" ){
		    	ComShowMessage(msg);
		    	sheetObj.SetCellValue( Row, "sheet1_loc_cd","",0);
		    }
        	var loc_info=ComGetEtcData(sXml,"loc_info");
            if( loc_info != "" ){
        	    setLocInfo(Row, loc_info);
            }else{
            	sheetObj.SelectCell( Row, Col )  ;
            }
    	 }
     }
     function chkSheetDup(sheetObj, key){
    	 var aStr=key.split("|");
    	 var sKey="";//aaa|bbb|=> sheetObj.GetCellValue('aaa')+"|"+sheetObj.GetCellValue('bbb')
    	 for(var i=0;i<aStr.length;i++){
    		 if( i < aStr.length-1 ){
    			 sKey +=   "sheetObj.GetCellValue( $row, '"+aStr[i]+"' )+'|'";
    		 }else{
    			 sKey +=   "+sheetObj.GetCellValue( $row, '"+aStr[i]+"' )+'|'";
    		 }
    	 }
         var mRowValue="";
    	 for(var i=1;i<= sheetObj.RowCount();i++ ){
    		 mRowValue=eval( ComReplaceStr(sKey, "$row", i  ) ) ;
        	 for(var j=2;j<= sheetObj.RowCount();j++ ){
    		      var dRowValue=eval( ComReplaceStr(sKey, "$row", j  ) ) ;
    		      if( (mRowValue == dRowValue) && (i != j) ){
    		    	  alert(i+"  "+mRowValue+"    "+j+" "+dRowValue);
    		    	  return;
    		      }
        	 }
    	 }
     }
   	 /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
                if(sAction == IBSEARCH){
                	 if (rso.GetSelectCode()== "" ){
    		    	     ComShowCodeMessage('COM12113', 'RSO Code!');   
    		    	     return false;
    		         }
               }
               if(sAction == IBSAVE){
                     var Row=sheetObj.ColValueDup("sheet1_loc_cd",false);
            	     if( Row != -1){
            	    	 ComShowCodeMessage("SCG50005","Data");
            	    	 //sheetObj.SelectRow = Row;
            	    	 sheetObj.SelectCell(Row, "sheet1_loc_cd");
            	    	 return false;
            	     }
            	     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
            	    	 return false;	 
            	     }
               
         }
         return true;
     }
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
			 gRow=Row;
			 var port_cd=sheetObj.GetCellValue(Row, Col);
            //ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setLocCd", "0,0", true);
			 ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 422, 510, "returnPortHelp", "0,0", true);
 		}
 	}
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
//					formObj.vps_port_cd.value=rtnDatas;
					
				   var sheetObject=sheetObjects[0];
				   var formObj=document.form;
				   sheetObject.SetCellValue(gRow,"sheet1_loc_cd",rtnObjs,0);
//				   sheetObject.SetCellValue(gRow,"sheet1_loc_nm",aryPopupData[0][3]);
//				   sheetObject.SetCellValue(gRow,"sheet1_rgn_shp_opr_cd",rso.GetSelectCode());//aryPopupData[0][7];
//				   sheetObject.SetCellValue(gRow,"sheet1_cnt_nm",aryPopupData[0][4]);
				   //RSO단위로 UNIQUE하게 처리
				   doActionIBSheet(sheetObject, document.form, IBSEARCH_ASYNC02, gRow, rtnObjs);
				   if(dup_chk == "Y"){
					   dup_chk = "";
					   return;
				   }
				   
				   doActionIBSheet(sheetObject, document.form, IBSEARCH_ASYNC01, gRow, rtnObjs);
				   gRow=0;
				}
			}
		}
	}
    /** 
     * result handling of Sheet Loc_cd  <br>
     * @param  none
     * @return none
     * @author 
     * @version 
     */  
	function setLocInfo(cRow, locinfo) {
  	   var sheetObject=sheetObjects[0];
       var formObj=document.form;
  	   var aLocinfo=locinfo.split("|");
	   sheetObject.SetCellValue(cRow,"sheet1_loc_cd",aLocinfo[0],0);
	   sheetObject.SetCellValue(cRow,"sheet1_rgn_shp_opr_cd",rso.GetSelectCode(),0);//aLocinfo[1];
	   sheetObject.SetCellValue(cRow,"sheet1_cnt_nm",aLocinfo[2],0);
	   sheetObject.SetCellValue(cRow,"sheet1_loc_nm",aLocinfo[3],0);
	   if( aLocinfo != 0 ){
	       //sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
	   }
	}
     /** 
      * Setting value sselected from Location by loc_cd popup. <br>
      * @param  none
      * @return none
      * @author 
      * @version
      */       
     function setLocCd(aryPopupData){
	   var sheetObject=sheetObjects[0];
	   var formObj=document.form;
	   sheetObject.SetCellValue(gRow,"sheet1_loc_cd",aryPopupData[0][2]);
	   sheetObject.SetCellValue(gRow,"sheet1_loc_nm",aryPopupData[0][3]);
	   sheetObject.SetCellValue(gRow,"sheet1_rgn_shp_opr_cd",rso.GetSelectCode());//aryPopupData[0][7];
	   sheetObject.SetCellValue(gRow,"sheet1_cnt_nm",aryPopupData[0][4]);
	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][2]);
	   gRow=0;
     } 
     /** 
     * Multi combo set <br>
     * @param  none
     * @return none
     * @author 
     * @version 
     */      
 	 function MakeComboObject(cmbObj, arrStr) {
 			for (var i=0; i < arrStr.length-1;i++ ) {
 			    var text=arrStr[i].split("|");
 				cmbObj.InsertItem(i,   arrStr[i],text[0]);
 			}
 	 }
 	 var value ="";
     function rso_OnChange (comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	 var aText=newText.split("|");
    	 document.form.rgn_shp_opr_desc.value=comboObj.GetText(newCode,1);
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
     }
     function initUseBtn(useyn){
         var doc=document.all;
         if( useyn ){
        	 ComBtnEnable("btn_add");
        	 ComBtnEnable("btn_insert");
        	 ComBtnEnable("btn_copy");
        	 ComBtnEnable("btn_delete");
         }else{
        	 ComBtnDisable("btn_add");
        	 ComBtnDisable("btn_insert");
        	 ComBtnDisable("btn_copy");
        	 ComBtnDisable("btn_delete");
         }
     }     
  