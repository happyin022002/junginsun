/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0003.js
 *@FileTitle : Segregation Table - Creation
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
     * @class vop_scg_0003 : business javascript for vop_scg_0003 
     */
    function vop_scg_0003() {
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
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var formObject=document.form;          
    	/*******************************************************/
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
     			case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_t1RowAdd":
					if (ComIsBtnEnable("btn_t1RowAdd")) sheetObjects[0].DataInsert(-1);
					break;
				case "btn_t1RowInsert":
					if (ComIsBtnEnable("btn_t1RowInsert")) sheetObjects[0].DataInsert();
					break; 
				case "btn_t1RowCopy":
					if (ComIsBtnEnable("btn_t1RowCopy")) sheetObjects[0].DataCopy();
					break;
				case "btn_t1RowDelete":
					if (ComIsBtnEnable("btn_t1RowDelete")) ComRowHideDelete(sheetObjects[0], "del_chk");
					break;	
     			case "btn_t2RowAdd":
     				if (ComIsBtnEnable("btn_t2RowAdd")) sheetObjects[1].DataInsert(-1);
					break;
				case "btn_t2RowInsert":
					if (ComIsBtnEnable("btn_t2RowInsert")) sheetObjects[1].DataInsert();
					break; 
				case "btn_t2RowCopy":
					if (ComIsBtnEnable("btn_t2RowCopy")) sheetObjects[1].DataCopy();
					break;
				case "btn_t2RowDelete":
					if (ComIsBtnEnable("btn_t2RowDelete")) ComRowHideDelete(sheetObjects[1], "del_chk");
					break;	
				case "btns_Numbers&Symbols":
					ComOpenWindowCenter("VOP_SCG_1003_01.do", "VOP_SCG_1003_01", 800, 345, true);
					break;
				case "btns_PermittedMixedStowageOfClass1":
					ComOpenWindowCenter("VOP_SCG_1003_02.do", "VOP_SCG_1003_02", 705, 390, true);
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
    	 resizeSheet();
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
     
     //no support[check again]CLT function t1sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         //Disabling because Segregation Table's Matrix is Fixed. 
         ComBtnDisable('btn_t1RowAdd');
         ComBtnDisable('btn_t1RowInsert');
         ComBtnDisable('btn_t1RowCopy');
         ComBtnDisable('btn_t1RowDelete');
         ComBtnDisable('btn_t2RowAdd');
         ComBtnDisable('btn_t2RowInsert');
         ComBtnDisable('btn_t2RowCopy');
         ComBtnDisable('btn_t2RowDelete');
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
    	        
//    	        (23, 0, 0, true);
	    	        var HeadTitle="|Sel.|Class|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9";
	
	    	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	    	        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	        InitHeaders(headers, info);
	
	    	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    	               {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"row_imdg_clss_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_11",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_12",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_15",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_13",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_16",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_14",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_21",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_22",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_23",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_41",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_42",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_43",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_51",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_52",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_61",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_62",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	    	               {Type:"Text",      Hidden:0,  Width:44,   Align:"Center",  ColMerge:0,   SaveName:"clss_cd_9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
	    	         
	    	        InitColumns(cols);
	    	        SetSheetHeight(440);
	    	        SetEditable(1);
	    	        //SetExtendLastCol(0);	                
                }
                 break;
         	case 2:      //t2sheet1 init
         	    with(sheetObj){
                
//              (16, 0, 0, true);
	              var HeadTitle="|Sel.|Compatibility\ngrorp|A|B|C|D|E|F|G|H|J|K|L|N|S";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"row_imdg_comp_grp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_a",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_b",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_c",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_d",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_e",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_f",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_g",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_h",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_j",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_k",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_l",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_n",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Text",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:0,   SaveName:"segr_cd_s",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(410);
	              SetEditable(1);
	              //SetExtendLastCol(0);
              }
              break;
         }
     }
     function resizeSheet(){
    	    for (i=0; i<sheetObjects.length; i++){
    	        ComResizeSheet(sheetObjects[i]);
    	    }
     }

     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
    	 sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      //retrieve
         		if(validateForm(sheetObj,formObj,sAction)) {
     				formObj.f_cmd.value=SEARCH;
 	    			var sXml=sheetObj.GetSearchData("VOP_SCG_0003GS.do", FormQueryString(formObj));
	    			var arrXml=sXml.split("|$$|");
	    			for(var inx=0; inx<arrXml.length; inx++){
	    				sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
	    			}
         		}
         		break;
 			 case IBSAVE:        //save
               if(validateForm(sheetObj,formObj,sAction)) {
            	   //if(!ComShowCodeConfirm('SCG50001', 'data')) return;            		
            	   formObj.f_cmd.value=MULTI;
            	   var sParam=ComGetSaveString(sheetObjects);
            	   if (sParam == "") return;
            	   sParam += "&" + FormQueryString(formObj);
            	   sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
            	   sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
             	   var sXml=sheetObj.GetSaveData("VOP_SCG_0003GS.do", sParam);
             	   sheetObj.LoadSaveData(sXml);
               }
               break;
 			 case IBROWSEARCH:
 				 if (sheetObj.id == "t1sheet1") {
 	 				formObj.f_cmd.value=SEARCH;				
  					var sXml=sheetObj.GetSearchData("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=C"+"&imdg_segr_cd="+sheetObj.GetEditText());
 	    		    var arrData=ComScgXml2Array(sXml, "imdg_segr_cd");
 	    		    if (arrData != null && arrData.length > 0) {
 					}else{
 						ComShowCodeMessage('SCG50010', 'Data');
 					    //sheetObj.SelectCell(Row, Col, true, "");
 						sheetObj.SelectCell(Row, Col);
 						sheetObj.SetCellValue(Row,Col,"");
  						return false;
 					} 					 
 				 }else
 				 if (sheetObj.id == "t2sheet1") {
  	 				formObj.f_cmd.value=SEARCH;
  	 				var segrCd="";
  	 				if (sheetObj.GetEditText().length > 1 && sheetObj.GetEditText().substring(0,1) == "X"){
  	 					segrCd=sheetObj.GetEditText().substring(1,2);
  	 				}else{
  	 					segrCd=sheetObj.GetEditText();
  	 				}
   					var sXml=sheetObj.GetSearchData("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=P"+"&imdg_segr_cd="+segrCd);
  	    		    var arrData=ComScgXml2Array(sXml, "imdg_segr_cd");
  	    		    if (arrData != null && arrData.length > 0) {
  					}else{
  						ComShowCodeMessage('SCG50010', 'Data');
 					    //sheetObj.SelectCell(Row, Col, true, "");
 						sheetObj.SelectCell(Row, Col);
 						sheetObj.SetCellValue(Row,Col,"");
  						return false;
  					} 					 
  				 }
 				 break;
         }
     }
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
InsertItem( "Between Various Classes" , "");
InsertItem( "Within Class 1" , "");
                 }
              break;
          }
     }
     /**
      * Related event when clicking Tab
      * selected tab element activates.
      */
     function tab1_OnChange(tabObj , nItem)
     {
    	 var objs=document.all.item("tabLayer");
    	 objs[nItem].style.display="Inline";
    	 objs[beforetab].style.display="none";
    	 //--------------- important point --------------------------//
    	 objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 beforetab=nItem;
    	 resizeSheet();
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE){
    		 var msg1="";
    		 var msg2="";
    		 for (var ir=1; ir<=sheetObjects[0].LastRow()-1; ir++){
    			 if(sheetObjects[0].GetCellValue(ir,"ibflag") != "R") {
    				 msg1 += sheetObjects[0].GetCellValue(ir,"row_imdg_clss_cd")+", ";
   				}
    		 }
    		 if (msg1 != "") {
    			 msg1=msg1.substring(0,msg1.length-2);
    			 if(ComShowCodeConfirm('SCG50014')) {
    				 return true;
    			 }else{
    				 return false;
    			 }
    		 }
    		 for (var ir=1; ir<=sheetObjects[1].LastRow()-1; ir++){
if(sheetObjects[1].GetCellValue(ir,"ibflag") != "R") {
msg2 += sheetObjects[1].GetCellValue(ir,"row_imdg_comp_grp_cd")+", ";
    				}
     		 }
    		 if (msg2 != "") {
     			 msg2=msg2.substring(0,msg2.length-2);
     			 if(ComShowCodeConfirm('SCG50014')) {
     				 return true;
    			 }else{
    				 return false;
     			 }
     		 }
    	 }
    	 return true;
     }
     /**
      * when input value change in IBSheet Object
      */
     function t1sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	 if (Col != 1) {
    		 if (sheetObj.GetEditText()!= "" && KeyCode != 229) {
    			 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
    		 }
    	 }
     }
     /**
      * when input value change in IBSheet Object
      */
     function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	 if (Col != 1) {
    		 if (sheetObj.GetEditText()!= "" && sheetObj.GetEditText()!= "X" && KeyCode != 229) {
    			 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
    		 }
    	 }
     }
