/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0009.js
 *@FileTitle : Vessel Operator's Restriction on DG - Creation
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
     * @class vop_scg_0009 : business script for vop_scg_0009 
     */
    function vop_scg_0009() {
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
 var comboObjects=new Array();
 var comboCnt=0; 
 var codeObjs=new Array();
 var oneventing="N";
 var callbackEvent="";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	 try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		var optclass=window.event.srcElement.getAttribute("optclass");
     		var doc=document.all;
             switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
				case "btn_add":
					 if( !formObject.optclass[0].checked ){
                        return;
					 }					
					 if( doc.btn_add.className == "btn2_1"){
		                 return;
		             }   
		             var Row=sheetObjects[0].DataInsert(-1);
					sheetObjects[0].SelectCell( Row ,"sheet1_imdg_clss_cd");
 					break;					
				case "btn_add2":
					if( !formObject.optclass[1].checked ){
                        return;
					}					
                    if( doc.btn_add2.className == "btn2_1"){
                        return;
                    }   					
                    var Row=sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SelectCell(  Row ,"sheet2_imdg_un_no");
					break;
				case "btn_insert":
					if( !formObject.optclass[0].checked ){
                        return;
					}					
                    if( doc.btn_insert.className == "btn2_1"){
                        return;
                    }   					
 					var Row=sheetObjects[0].DataInsert();
 					sheetObjects[0].SelectCell(  Row, "sheet1_imdg_clss_cd");
 					break;
				case "btn_insert2":
					if( !formObject.optclass[1].checked ){
                        return;
					}			
                    if( doc.btn_insert2.className == "btn2_1"){
                        return;
                    }  					
                    var Row=sheetObjects[1].DataInsert();
 					sheetObjects[1].SelectCell(  Row ,"sheet2_imdg_un_no");
 					break;
				case "btn_copy":
					if( !formObject.optclass[0].checked ){
                        return;
					}		
                    if( doc.btn_copy.className == "btn2_1"){
                        return;
                    }  					
				    var row=sheetObjects[0].DataCopy();
                    sheetObjects[0].SelectCell( row,"sheet1_imdg_clss_cd");
 					break;					 
					break; 
				case "btn_copy2":
					if( !formObject.optclass[1].checked ){
                        return;
					}		
                    if( doc.btn_copy2.className == "btn2_1"){
                        return;
                    } 					
				    var row=sheetObjects[1].DataCopy();
                    sheetObjects[1].SelectCell( row,"sheet2_imdg_un_no");
 					break;
 				case "btn_New":
 					doActionIBSheet(sheetObjects[0],document.form,IBRESET);
 					break;
 				case "btn_row_delete":
					if( !formObject.optclass[0].checked ){
                        return;
					}	 				
                    if( doc.btn_row_delete.className == "btn2_1"){
                        return;
                    }   					
					if(   formObject.optclass[0].checked ){
                        ComRowHideDelete(sheetObjects[0], "sheet1_Sel");
					}
					break;
 				case "btn_row_delete2":
					if( !formObject.optclass[1].checked ){
                        return;
					}	
                    if( doc.btn_row_delete2.className == "btn2_1"){
                        return;
                    }  					
					if( formObject.optclass[1].checked ){
                        ComRowHideDelete(sheetObjects[1], "sheet2_Sel");
					}
					break;
				case "btn_DownExcel":
					if( formObject.optclass[0].checked ){
						if(sheetObjects[0].RowCount() < 1){//no data 
						 ComShowCodeMessage("COM132501");
						}else{ 
							sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(						sheetObjects[0]), SheetDesign:1,Merge:1 });
						}		
					}else{
						if(sheetObjects[1].RowCount() < 1){//no data 
							 ComShowCodeMessage("COM132501");
						}else{ 
							sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(		 				sheetObjects[1]), SheetDesign:1,Merge:1 });
						}	
		 			}	
					break; 
 				case "btn_Save":
		 			if( formObject.optclass[0].checked ){
		 				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
		 			}else{
		 				doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
		 			}	 					
 					break;
                case "srch_imdg_un_no":
                	var imdg_un_no=document.form.imdg_un_no.value;
                    var imdg_un_no_seq=document.form.imdg_un_no_seq.value; 
                    ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 470, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
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
      * egister IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
     }  
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     /*function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
     }*/
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         sheet1_OnLoadFinish(sheet1);
//         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
     }
     
     
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     } 
     
     function initControl() {
         var form=document.form;
         
//    	 axon_event.addListenerForm('keypress','obj_keypress',    form  );
         axon_event.addListenerForm('keydown','ComKeyEnterControl',  form,"crr_regu_desc_class|crr_regu_desc_unno"  );
 	     axon_event.addListenerForm('blur',    'obj_blur'      ,form); //- 포커스 나갈때
//         axon_event.addListenerForm('keyup',   'obj_keyup',     form ); 	     
         axon_event.addListenerForm('click',   'obj_click',   	form);   
         axon_event.addListenerForm('change',  'obj_change',   	form);           
         axon_event.addListener    ('click',   'img_click',   	"srch_imdg_un_no");
         axon_event.addListener    ('click',   'img_click',   	"srch_crr_cd"    ); 
         //axon_event.addListener    ('mousedown', 'mouse_down',   "btn_Retrieve");   
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         ComBtnDisable("btn_add");
         ComBtnDisable("btn_insert");
    	 ComBtnDisable("btn_copy");
    	 ComBtnDisable("btn_row_delete");
    	 ComBtnDisable("btn_add2");
    	 ComBtnDisable("btn_insert2");
    	 ComBtnDisable("btn_copy2");
    	 ComBtnDisable("btn_row_delete2");
    	 ComBtnDisable("srch_imdg_un_no");
         ComBtnEnable("srch_crr_cd");
     }
     /**
      * initializing Combo
      * Setting Combo items
      */
     function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo_imdg_clss_cd":
	            with(comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
	            	SetTitle("Class|Definition");
	            	SetColWidth(0, "50");
	            	SetColWidth(1, "700");
	            	SetDropHeight(200);
                    //no support[check again]CLT ValidChar(2,3);
                    SetMaxLength(3);
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
             case 1:      // sheet1 init
            	    with(sheetObj){
                 
	               var HeadTitle="|Sel.|Class|Definitions|Restrictions|Lane||||";
	               (HeadTitle.split("|").length, 0, 0, true);
	               var prefix="sheet1_";
	
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:690,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_clss_cd_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3, InputCaseSensitive:0, AcceptKeys:"E|N"},
	                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"crr_regu_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_opr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"row_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                
	               InitColumns(cols);
	               SetSheetHeight(287);
	               SetEditable(1);
//               SetGetCountPosition()(2);
//                     SetHeaderGetRowHeight(28);
//               SetGetShowButtonImage()(1);
               }
                 break;
                 
             case 2:      // sheet2 init
                 with (sheetObj) {
                     // setting height
            	
            	 var HeadTitle="|Sel.|Amdt No.|Class|UN No/Seq|UN No/Seq|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Restrictions|Lane|regu_desc|vsl_opr_tp_cd|imdg_crr_rstr_seq";
            	 ( HeadTitle.split("|").length , 0, 0, true);
            	 var prefix="sheet2_";

            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_amdt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
            	              {Type:"PopupEdit", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no_seq",        KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
            	              {Type:"Text",      Hidden:0,  Width:360,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prp_shp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_tec_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_pck_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3, InputCaseSensitive:0, AcceptKeys:"E|N"},
            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"crr_regu_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_opr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	  
            	 InitColumns(cols);
            	 SetSheetHeight(287);
            	 SetEditable(1);
//            	 SetGetCountPosition()(2);
//            	 SetHeaderGetRowHeight(28);
//            	 SetGetShowButtonImage()(1);
//            	 SetGetExtendLastCol()(0);
 			   }
                 break;
         }
     }
     var aEtcData="";
     var aEtcDataAll="";
     
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, pRow) {
         sheetObj.ShowDebugMsg(false);
         
         switch(sAction) {
         				case IBCLEAR :      //initializing
		      	          // initoptclass();
				           formObj.f_cmd.value=SEARCH02;   
				           var param=FormQueryString(formObj);
				           var exceptkey="C";
	 			           var sXml=sheetObj.GetSearchData("VOP_SCG_0009GS.do", param+"&code=CD01950&exceptkey="+exceptkey, true);
				           aEtcData=ComGetEtcData(sXml ,"codeinfo").split("|##|");
				           aEtcDataAll=ComGetEtcData(sXml ,"codeinfoAll").split("|##|");
				           
				           /***************  Grid  Combo Set **********************************/
				           ////2015-05-31//var comText=aEtcDataAll[1].split("|");
				           ////2015-05-31//var comCode=aEtcDataAll[0].split("|");
	  					   ////2015-05-31//comText=comText[0]+"|"+comText[1];
	  					   ////2015-05-31//comCode=comCode[0]+"|"+comCode[1];
		  				   
		  				   sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:aEtcData[1], ComboCode:aEtcData[0]} );
		  				   sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
		  				   
		  				   ////2015-05-31//sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
		  				   ////2015-05-31//sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
		  				   
				           ////2015-05-20//sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:aEtcData[1], ComboCode:aEtcData[0]} );
		  				   ////2015-05-20//sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
		                   
		                   /***********Class Combo Set *********************************/
		  				   var class_cd=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
		  				   var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
		  				   
		  				   tStr = tStr.substr(0, tStr.length-1);
		  				   
		  				   sheetObjects[0].SetColProperty("sheet1_imdg_clss_cd", {ComboText:"|"+tStr, ComboCode:"|"+class_cd[0]} );
	                       /*************** Search Combo grpcd와 Class Cd Setting ******/		
		  				   ComXml2ComboItem(sXml, combo_imdg_clss_cd, "imdg_clss_cd"    , "imdg_clss_cd|imdg_clss_cd_desc" );
				           /******************* CLASS GRID ENABLE, UNNO GRID DISABLE********************/
		                   for(var i=1;i<=sheetObjects[0].RowCount();i++){
		                   	   sheetObjects[0].SetRowEditable(i,1);
		                   }
		                   for(var i=1;i<=sheetObjects[1].RowCount();i++){
		                   	   sheetObjects[1].SetRowEditable(i,0);
		                   }	
	                   	   //formObj.grp_cd.Enable = false;
	                   	   formObj.crr_cd.focus();
						   break;
						   
		              case IBSEARCH:      //retrieve
	                         if(!validateForm(sheetObj,formObj,sAction)){ 
					 		     return;
					 		 }
				             if( formObj.optclass[0].checked ){
				            	   with( sheetObjects[0] ){
                                       formObj.f_cmd.value=SEARCH01;  
                                       var param="f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+combo_imdg_clss_cd.GetSelectText();
                                           //param    +=  "&imdg_un_no="+formObj.imdg_un_no.value;
                                           //param    +=  "&imdg_un_no_seq="+formObj.imdg_un_no_seq.value;
                                           param    +=  "&crr_cd="+formObj.crr_cd.value;                                               
                                           param    +=  "&optclass=class";
                                       var aryPrefix=new Array( "sheet1_" );
                                        var sXml=GetSearchData("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
                                        LoadSearchData(sXml,{Sync:1} );
                                       fnSearchEnd(sheetObjects[0]);
                                     /***********************************TXT AREA Setting***********************************************/
                                       if(GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc")!=-1){
                                    	   formObj.crr_regu_desc_class.value=GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc");
                                       }
					  				   var comText=aEtcData[1].split("|");
					  				   var comCode=aEtcData[0].split("|");
					  				   
					  				   ////2015-05-20//comText=comText[1]+"|"+comText[2]+"|"+comText[4]+"|";
					  				   ////2015-05-20//comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[3]+"|";
					  				   
					  				   ////2015-05-31//comText=comText[0]+"|"+comText[1];
					  				   ////2015-05-31//comCode=comCode[0]+"|"+comCode[1];
					  				   
					  				   comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[3];
					  				   comText=comText[0]+"|"+comText[1]+"|"+comText[3];
					  				   
					  				   sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
				                   }   
						           iniBtn('C');
						           
				              }else if( formObj.optclass[1].checked ){
				            	  
					               with( sheetObjects[1] ){			            	  
							           formObj.f_cmd.value=SEARCH01;  
					         		   var param="f_cmd="+formObj.f_cmd.value+"&imdg_clss_cd="+combo_imdg_clss_cd.GetSelectText();
					         		       param    +=  "&imdg_un_no="+formObj.imdg_un_no.value;
					         		       param    +=  "&imdg_un_no_seq="+formObj.imdg_un_no_seq.value;
					         		       param    +=  "&crr_cd="+formObj.crr_cd.value;	
					         		       param    +=  "&optclass=unno";
					         		       param    +=  "&imdg_tek_nm_check=Y";
					         		       param    +=  "&imdg_crr_rstr_expt_cd=C";//
				  				       var aryPrefix=new Array( "sheet2_" );
 				  				       var sXml=GetSearchData("VOP_SCG_0009GS.do", param+ "&" + ComGetPrefixParam( aryPrefix ) );
				  				       var SHOW_MSG=ComGetEtcData( sXml, "SHOW_MSG");
				          			   var sMsg=ComScgGetMessageFromXml(sXml);
				  				       if(SHOW_MSG != ""){
									       ComShowMessage( sMsg);
									       sXml=ComDeleteMsg(sXml);
				  				       }else{
				  				       }
				  				       LoadSearchData(sXml,{Sync:1} );
				  				       fnSearchEnd(sheetObjects[1]);
				  				       if(GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc")!=-1){
				  				    	   formObj.crr_regu_desc_unno.value=GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc"); 
				  				       }
					  				   if (formObj.crr_cd.value != ConstantMgr.getCompanyCode()) {
					  					   var comText=aEtcDataAll[1].split("|");
					  					   var comCode=aEtcDataAll[0].split("|");
					  					   
					  					   ////2015-05-20//comText=comText[1]+"|"+comText[2]+"|"+comText[3]+"|"+comText[5]+"|";
					  					   ////2015-05-20//comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[2]+"|"+comCode[4]+"|";
					  					   
					  					   ////2015-05-31//comText=comText[0]+"|"+comText[1];
					  					   ////2015-05-31//comCode=comCode[0]+"|"+comCode[1];
					  					   
					  					   comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[2]+"|"+comCode[4];
					  					   comText=comText[0]+"|"+comText[1]+"|"+comText[2]+"|"+comText[4];
					  					   
						                   sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
						                   
					  				   }else{
						                   
					  					   ////2015-05-31//var comText=aEtcDataAll[1].split("|");
					  					   ////2015-05-31//var comCode=aEtcDataAll[0].split("|");
					  					   
					  					   ////2015-05-31//comText=comText[0]+"|"+comText[1];
					  					   ////2015-05-31//comCode=comCode[0]+"|"+comCode[1];
					  					   
					  					   ////2015-05-31//sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
						               
						                   sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
					  					   
					  				   }
					               }
						           iniBtn('U');
				              }
					          /******************* Land by Restriction Status********************/
                              setLaneEnable();						              
	 					   break;
		 			 case IBSAVE:        //save
			 			 if(!validateForm(sheetObj,formObj,sAction)){ 
			 			    return;
			 			 }
			 			 formObj.f_cmd.value=MULTI01;
			 			 var sheetName="";
			 			 if( formObj.optclass[0].checked ){
			 				sheetName="sheet1_";
			 			 }else{
			 		 		sheetName="sheet2_";
			 			 }
			 			 var aryPrefix=new Array(sheetName);
 			 			 var sParam=ComGetSaveString(sheetObjects, true, true);
			 			 if( sParam == ""){ return;}
 			 			 sParam  +=  "&"+FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
 			 			 var sXml=sheetObj.GetSaveData( "VOP_SCG_0009GS.do", sParam);
  	 			 		 sheetObj.LoadSaveData(sXml);
 	 			 		 setLaneEnable();
			 			 break;
		 			case IBRESET:      // NEW button
		 			    var doc=document.all;
		 			    if( formObj.optclass[0].checked ){                 
                            doc.div_s1.style.display="";                    
                            doc.div_s2.style.display="none";
                        }		 			
		 			    if( formObj.optclass[1].checked ){		 			
                            doc.div_s1.style.display="";                    
                            doc.div_s2.style.display="none";
                        }
          	 			 initSetting();
          	 			 formObj.crr_cd.focus();
		                 break; 		
					case IBSEARCH_ASYNC01:  //axon_event checkCarrier
				         formObj.f_cmd.value=SEARCH01;        			
			             var param=FormQueryString(formObj);
 					     var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
					     var sValue=ComScgGetRowValue(sXml, 1,"crr_cd|crr_nm|");
					     var aValue=sValue.split("|");
					     if( sValue != "" ){
					         formObj.crr_cd.value=aValue[0];
					         formObj.crr_nm.value=aValue[1];
							 if(  callbackEvent != ""){
			                     if( callbackEvent == "btn_Retrieve"){
			                    	 callbackEvent="";
			                    	 doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
			                     }
							 }
							 //iniBtn(true); 
					         with(formObj){
					             if( optclass[0].checked){ 
					            	 combo_imdg_clss_cd.focus();
					             }
					             if( optclass[1].checked){
					                 formObj.imdg_un_no.focus();
					             }
					         }						 
					     }else{
					    	 ComShowCodeMessage( "SCG50010", 'Data'  );
					    	 formObj.crr_cd.value="";
					    	 formObj.crr_nm.value="";
					    	 formObj.crr_cd.focus();
					         return;
					     }
					     break;
					case IBSEARCH_ASYNC02:  //CheckUnNumber
			            formObj.f_cmd.value=SEARCH01;
			            var param=FormQueryString(formObj) ;
 			            var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
			            var sTotal=ComScgGetTotalValue(sXml);
		                if( sTotal == "0"){
		                  	 ComShowCodeMessage("SCG50010", 'Data');
		                  	 formObj.imdg_un_no.value="";
		                  	 formObj.imdg_un_no.focus();
		                }else{
		                	 formObj.imdg_un_no_seq.focus();
		                }
		                break;		                 
					case IBSEARCH_ASYNC03:  //shee2 imdg_un_no_seq=> prp_shp_nm 
			             if(!validateForm(sheetObj,formObj,sAction, pRow)){ 
	 			             return;
 	 			         }
					     formObj.f_cmd.value=SEARCH05; 	
					     var param="f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no");
					     param      +=  "&imdg_un_no_seq="+sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no_seq");
 						 var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
						 with(sheetObj){
                    	     SetCellValue(pRow, id+"_imdg_clss_cd" ,ComScgGetRowValue(sXml, 1, "imdg_clss_cd"     ),0);
                    	     SetCellValue(pRow, id+"_prp_shp_nm" ,ComScgGetRowValue(sXml, 1, "prp_shp_nm"       ),0);
                    	     SetCellValue(pRow, id+"_imdg_tec_nm" ,ComScgGetRowValue(sXml, 1, "imdg_tec_nm"      ),0);
                    	     SetCellValue(pRow, id+"_imdg_pck_grp_cd" ,ComScgGetRowValue(sXml, 1, "imdg_pck_grp_cd"  ),0);
                    	     var imdg_tec_nm=ComScgGetRowValue(sXml, 1, "imdg_tec_nm");  
                             if( imdg_tec_nm != "" ){                          
                                 sheetObj.SetColHidden("sheet2_imdg_tec_nm" ,0);
                                 sheetObj.SetColWidth("sheet2_prp_shp_nm"  ,380);
                             }
                         }
			              var sTotal=ComScgGetTotalValue(sXml);
	  	                  if( sTotal == "0"){
			                  ComShowCodeMessage("SCG50010", 'Data');	 
		                      sheetObj.SelectCell(pRow,  "sheet2_imdg_un_no_seq", true );
		                      sheetObj.SetCellValue(pRow,  "sheet2_imdg_un_no_seq","",0);
		                  } 
 					     break;
		            case IBSEARCH_ASYNC04:      //form -> prp_shp_nm retrieve
		                 formObj.f_cmd.value=SEARCH05;
		                 var param=FormQueryString(formObj) ;
 		                 var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                         var sTotal=ComScgGetTotalValue(sXml);
                         if( sTotal == "0"){
                             ComShowCodeMessage("SCG50010", 'Data');
                             formObj.imdg_un_no_seq.value="";
                             formObj.imdg_un_no_seq.focus();   
						 }else{//정상확인시.
		                    var prp_shp_nm=ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
	                        var imdg_clss_cd_desc=ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
	                        var imdg_clss_cd=ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd                         
	                        formObj.prp_shp_nm.value=prp_shp_nm;   
	                        formObj.imdg_clss_cd_desc.value=imdg_clss_cd_desc;
	                        combo_imdg_clss_cd.SetSelectCode(imdg_clss_cd,false);
							 if(  callbackEvent != ""){
			                     if( callbackEvent == "btn_Retrieve"){
			                    	 callbackEvent="";
			                    	 doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
			                     }
							 }
						 }
	                     break;		
					 case IBSEARCH_ASYNC05:  //grid2 CheckUnNumber
					      fnClearUnnoInfo(sheetObj, pRow);
					      sheetObj.SetCellValue(pRow, "sheet2_imdg_un_no_seq","",0);
			              formObj.f_cmd.value=SEARCH01;
			              var param="f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no");
			              param  +=  "&imdg_un_no_seq="+sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no_seq");
 			              var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
			              var sTotal=ComScgGetTotalValue(sXml);
	  	                  if( sTotal == "0"){
		                      ComShowCodeMessage("SCG50010", 'Data');
		                      sheetObj.SetCellValue(pRow, sheetObj.id+"_imdg_un_no","",0);
		                      sheetObj.SelectCell(pRow, sheetObj.id+"_imdg_un_no") ;
		                  }else{
		                	  sheetObj.SelectCell(pRow, sheetObj.id+"_imdg_un_no_seq") ;
		                  }
		                  break;
		                  
                    case    IBSEARCH_ASYNC06:  //CheckLane
                            formObj.f_cmd.value=SEARCH02;
                            var param="f_cmd="+formObj.f_cmd.value+"&vsl_slan_cd="+sheetObj.GetCellValue(pRow, sheetObj.id+"_slan_cd");
                            
                            var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
                            var sTotal=ComScgGetTotalValue(sXml);
                            if( sTotal == "0"){
                                ComShowCodeMessage("SCG50010", 'Data');
                                sheetObj.SetCellValue(pRow, sheetObj.id+"_slan_cd","",0);
                                sheetObj.SelectCell(pRow, sheetObj.id+"_slan_cd") ;
                            }else{
                                sheetObj.SelectCell(pRow, sheetObj.id+"_slan_cd") ;
                            }
                            break;             
					 case IBSEARCH_ASYNC07:  //form CheckUnNumber
			              formObj.f_cmd.value=SEARCH01;
			              var param=FormQueryString(formObj) ;
			              var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
			              var sTotal=ComScgGetTotalValue(sXml);
	  	                  if( sTotal == "0"){
		                      ComShowCodeMessage("SCG50010", 'Data');
		                      formObj.imdg_un_no.value="";
		                      formObj.imdg_un_no.focus();   
		                  }
		                  break;                            
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction, pRow){
         with(formObj){
               switch (sAction){
	                   case IBSEARCH_ASYNC01: //Carrier Check
						    if( !ComChkRequired(formObj) ){
							    return false;
						    }
						    break;                  
		               case IBSEARCH_ASYNC02: 
						    if( !ComChkRequired(formObj) ){
							   return false;
						    }else if( formObj.imdg_un_no.value == ""){ 
 							    formObj.imdg_un_no.focus();
							    formObj.imdg_un_no.select();
                            	return false;
                            }else if( formObj.imdg_un_no_seq.value == ""){  
 							    formObj.imdg_un_no_seq.focus();
							    formObj.imdg_un_no_seq.select();
                            	return false;
                            }
						   break;   
		               case IBSEARCH_ASYNC03: 
		            	   if( sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no") == "" ){
                          	    return false;
                           }		            	   
		            	   if( sheetObj.GetCellValue(pRow, sheetObj.id+"_imdg_un_no_seq") == "" ){
                           	    return false;
                           }
						   break; 
                      case IBSEARCH:  
//                           if( !ComChkValid(formObj) ){
//                              return false;
//                           }
       				       if( formObj.crr_cd.value == "" && formObj.crr_nm.value == "" ){       				 
							   ComShowCodeMessage( "COM12113", " Vessel Operator.."  );
							   formObj.crr_cd.focus();
							   formObj.crr_cd.select();
							   return false;
       				       }
						   break;
       				  case IBSAVE:
//						   if( !ComChkRequired(formObj) ){
//							   return false;
//						   }
//						   if( sheetObj.GetSaveString(false) == ""  ){return false;}
		            	   var cByte=ComGetLenByByte(formObj.crr_regu_desc_class  );
		            	   if ( cByte > 4000  ){
		            		   ComShowCodeMessage("COM12142", "", "4000byte (Current:"+cByte+")");
		            		   formObj.crr_regu_desc_class.focus();
		            		   formObj.crr_regu_desc_class.select();
		            		   return false;
		            	   }
		            	   if( formObj.optclass[0].checked ){
		            	       for(var i=1;i<=sheetObj.RowCount();i++){
		            	    	   if( sheetObj.GetCellValue(i, "sheet1_imdg_crr_rstr_expt_cd") == "L"  ){
		            	    		   if( sheetObj.GetCellValue(i, "sheet1_slan_cd") == ""  ){
		            	                   ComShowCodeMessage("SCG50007", "Lane");
		            	                   sheetObj.SelectCell(i, "sheet1_slan_cd");
		            	                   return false;
		            	               }
		            	           }
		            	       }
                    			var dupRow = sheetObj.ColValueDupRows("sheet1_imdg_clss_cd|sheet1_imdg_crr_rstr_expt_cd|sheet1_slan_cd", false, true);
                     			if(dupRow != "") {
                    				ComShowCodeMessage('SCG50005', 'Data');
                    				if (sheetObj.GetRowStatus(dupRow.split("|")[0])=="R") {
                    					sheetObj.SelectCell(dupRow.split("|")[1], "sheet1_imdg_clss_cd");
                    				}else{
                    					sheetObj.SelectCell(dupRow.split("|")[0], "sheet1_imdg_clss_cd");
                    				}
                    				return;
                     			}
		            	   }
		            	   if( formObj.optclass[1].checked ){
                               for(var i=1;i<=sheetObj.RowCount();i++){
                            	   if( sheetObj.GetCellValue(i, "sheet2_imdg_crr_rstr_expt_cd") == "L"  ){
                            		   if( sheetObj.GetCellValue(i, "sheet2_slan_cd") == ""  ){
                                           ComShowCodeMessage("SCG50007", "Lane");
                                           sheetObj.SelectCell(i, "sheet2_slan_cd");
                                           return false;
                                       }
                                   }
                               }
                     			var dupRow = sheetObj.ColValueDupRows("sheet2_imdg_un_no|sheet2_imdg_un_no_seq|sheet2_imdg_crr_rstr_expt_cd|sheet2_slan_cd", false, true);
                     			if(dupRow != "") {
                    				ComShowCodeMessage('SCG50005', 'Data');
                    				if (sheetObj.GetRowStatus(dupRow.split("|")[0])=="R") {
                    					sheetObj.SelectCell(dupRow.split("|")[1], "sheet2_imdg_un_no");
                    				}else{
                    					sheetObj.SelectCell(dupRow.split("|")[0], "sheet2_imdg_un_no");
                    				}
                    				return;
                     			}
		            	   }
		                   if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
	                           return false;   
	                       }
    					   break;
				} //END Switch
         }
         return true;
     }
     /************************************User Function *************************************************/
     function fnClearUnnoInfo(sheetObj,  row ){    	
    	 sheetObj.SetCellValue(row, sheetObj.id+"_imdg_clss_cd","",0);
    	 sheetObj.SetCellValue(row, sheetObj.id+"_prp_shp_nm","",0);
    	 sheetObj.SetCellValue(row, sheetObj.id+"_imdg_tec_nm","",0);
    	 sheetObj.SetCellValue(row, sheetObj.id+"_imdg_pck_grp_cd","",0);
     }
     /**
      * Handling retrieve option Enable/Disable when selecting optclass
      * 
      * @param void 
      * @param void
      * @return
      */
     function initoptclass(){
    	 var formObj=document.form;
    	 with(formObj){
	    	 if( optclass[0].checked){ 
	    		 initClass();
	    	 }
	    	 if( optclass[1].checked){
                 initUnno();
	    	 }
    	 }
     }
     /**
      * optclass item setting : select option Class style change 
      * @return
      */
     function initClass(){
         var formObj=document.form;
         combo_imdg_clss_cd.DisabledBackColor="#E8E7EC"; 
         combo_imdg_clss_cd.SetEnable(1);
         formObj.imdg_un_no.className='input2';
         formObj.imdg_un_no.readOnly=true;
         formObj.imdg_un_no_seq.className='input2';
         formObj.imdg_un_no_seq.readOnly=true;
         formObj.crr_regu_desc_unno.readOnly=true;
         formObj.crr_regu_desc_class.readOnly=false;  
         formObj.imdg_un_no.value="";
         formObj.imdg_un_no_seq.value="";            
         formObj.imdg_un_no_seq.value="";
         formObj.prp_shp_nm.value="";                
//         document.all.srch_imdg_un_no.src='/opuscntr/img/btns_search_off.gif';   
//         document.all.srch_imdg_un_no.className='';
//         document.getElementById("srch_imdg_un_no").disabled = true;
         fnNewGrid(); 
         if( formObj.crr_cd.value != ""){
        	 //@@ imdg_clss_cd 라는 객체없음 
             //imdg_clss_cd.focus(); 
         }else{
             formObj.crr_cd.focus();
         }           
  } 
     function initClassBtn(){
    	 var doc=document.all;
    	 ComBtnEnable("btn_add");
    	 ComBtnEnable("btn_insert");
    	 ComBtnEnable("btn_copy");
    	 ComBtnEnable("btn_row_delete");
    	 ComBtnDisable("btn_add2");
    	 ComBtnDisable("btn_insert2");
    	 ComBtnDisable("btn_copy2");
    	 ComBtnDisable("btn_row_delete2");
//    	 doc.btn_add.className="btn2";
//    	 doc.btn_insert.className="btn2";
//    	 doc.btn_copy.className="btn2";
//    	 doc.btn_row_delete.className="btn2";    	
//    	 doc.btn_add2.className="btn2_1";
//    	 doc.btn_insert2.className="btn2_1";
//    	 doc.btn_copy2.className="btn2_1";
//    	 doc.btn_row_delete2.className="btn2_1";    	 
     }
     function initUnnoBtn(){
    	 var doc=document.all;
    	 ComBtnDisable("btn_add");
    	 ComBtnDisable("btn_insert");
    	 ComBtnDisable("btn_copy");
    	 ComBtnDisable("btn_row_delete");
    	 ComBtnEnable("btn_add2");
    	 ComBtnEnable("btn_insert2");
    	 ComBtnEnable("btn_copy2");
    	 ComBtnEnable("btn_row_delete2");
//    	 doc.btn_add.className="btn2_1";
//    	 doc.btn_insert.className="btn2_1";
//    	 doc.btn_copy.className="btn2_1";
//    	 doc.btn_row_delete.className="btn2_1";    	
//    	 doc.btn_add2.className="btn2";
//    	 doc.btn_insert2.className="btn2";
//    	 doc.btn_copy2.className="btn2";
//    	 doc.btn_row_delete2.className="btn2";    	 
     }     
     /**
      *  optclass item setting : select option Class style change 
      * @return
      */
     function initUnno(){
  	    var formObj=document.form;
  	    combo_imdg_clss_cd.DisabledBackColor="#eeeeee"; 
  	  	combo_imdg_clss_cd.SetEnable(0);
  	    formObj.imdg_un_no.className='input';
  	    formObj.imdg_un_no.readOnly=false;
  	    formObj.imdg_un_no_seq.className='input';
        formObj.imdg_un_no_seq.readOnly=false;		
        formObj.srch_imdg_un_no.style.display="";		
        formObj.crr_regu_desc_unno.readOnly=false;
        formObj.crr_regu_desc_class.readOnly=true;   
        combo_imdg_clss_cd.SetSelectCode("",false);
        formObj.imdg_clss_cd_desc.value="";	    
	    //document.all.srch_imdg_un_no.src='/opuscntr/img/btns_search.gif';	 
	    //document.all.srch_imdg_un_no.className='Cursor';	
	    fnNewGrid();
        if( formObj.crr_cd.value != ""){
            formObj.imdg_un_no.focus(); 
        }else{
            formObj.crr_cd.focus();
        }
     }    
     /**
      *  Handling NEW button
      *  
      * @param void 
      * @param void
      * @return
      */
     function initSetting(){ 
    	 var formObj=document.form;
    	 fnNewGrid();
         formObj.crr_cd.value="";
         formObj.crr_nm.value="";
         formObj.optclass[0].checked=true;
//         combo_imdg_clss_cd.SetSelectCode("");
         combo_imdg_clss_cd.SetSelectIndex(-1);
         formObj.imdg_un_no.value="";         
         formObj.imdg_un_no_seq.value="";
         formObj.prp_shp_nm.value="";         
         formObj.crr_regu_desc_class.value="";             
         formObj.crr_regu_desc_unno.value="";    
         formObj.imdg_clss_cd_desc.value="";
         initClass();
         initClassBtn(false); 
         initUnnoBtn(false);
     }
      /**
      * Handling retrieve option Enable/Disable when selecting optclass
      * 
      * @param void 
      * @param void
      * @return
      */
     function iniBtn(Type){
         var formObj=document.form;
         with(formObj){
        	 if (Type == 'C') {
        		 initClassBtn(true);
        	 }else{
        		 initUnnoBtn(true);
        	 }
         }
     }
    function initClassBtn(Yn){
        var doc=document.all;
        var ClassName="";
        if( Yn ){
            //ClassName="btn2";
        	 ComBtnEnable("btn_add");
	       	 ComBtnEnable("btn_insert");
	       	 ComBtnEnable("btn_copy");
	       	 ComBtnEnable("btn_row_delete");
        }else{
//            ClassName="btn2_1";   
        	 ComBtnDisable("btn_add");
        	 ComBtnDisable("btn_insert");
        	 ComBtnDisable("btn_copy");
        	 ComBtnDisable("btn_row_delete");
        }
//        doc.btn_add.className=ClassName;
//        doc.btn_insert.className=ClassName;
//        doc.btn_copy.className=ClassName;
//        doc.btn_row_delete.className=ClassName;     
    }
    function initUnnoBtn(Yn){
        var doc=document.all;
        var ClassName="";
        if( Yn ){
            //ClassName="btn2";
        	 ComBtnEnable("btn_add2");
	       	 ComBtnEnable("btn_insert2");
	       	 ComBtnEnable("btn_copy2");
	       	 ComBtnEnable("btn_row_delete2");
        }else{
//            ClassName="btn2_1";   
        	 ComBtnDisable("btn_add2");
        	 ComBtnDisable("btn_insert2");
        	 ComBtnDisable("btn_copy2");
        	 ComBtnDisable("btn_row_delete2");
        }
//        doc.btn_add2.className=ClassName;
//        doc.btn_insert2.className=ClassName;
//        doc.btn_copy2.className=ClassName;
//        doc.btn_row_delete2.className=ClassName;          
    }        
     /**
      * Sheet1 OnPopupClick event handling : CallBack function 
      * @param aryPopupData
      * @param row
      * @param col
      * @param seetIdx 
      * @return
      */
     function setSheet1_PopupCallback_SlanCd(aryPopupData,row, col, seetIdx){
    	 sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][1],0);
     }
     /**
     * Sheet2 OnPopupClick event handling : SlanCd CallBack function 
     * @param aryPopupData
     * @param row
     * @param col
     * @param seetIdx 
     * @return
     */     
     function setSheet2_PopupCallback_SlanCd(aryPopupData,row, col, seetIdx){
    	 sheetObjects[seetIdx].SetCellValue(row, col,aryPopupData[0][1],0);
     }
     /**
     * Sheet2 OnPopupClick ImdgUnNoSeq event handling : CallBack function 
     * @param aryPopupData
     * @param row
     * @param col
     * @param seetIdx 
     * @return
     */
     function setSheet2_PopupCallback_ImdgUnNoSeq(aryPopupData,row, col, seetIdx){
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_imdg_un_no",aryPopupData[0][2],0);//UnNo
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_imdg_un_no_seq",aryPopupData[0][3],0);//UnNoSeq
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_imdg_clss_cd",aryPopupData[0][4],0);//ClassCd
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_prp_shp_nm",aryPopupData[0][6],0);
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_imdg_tec_nm",aryPopupData[0][7],0);
    	 sheetObjects[seetIdx].SetCellValue(row, "sheet2_imdg_pck_grp_cd",aryPopupData[0][8],0);
    	 if( sheetObjects[seetIdx].GetCellValue(row,"sheet2_imdg_tec_nm") != ""){
             sheetObjects[seetIdx].SetColHidden("sheet2_imdg_tec_nm",0);
             sheetObjects[seetIdx].SetColWidth("sheet2_prp_shp_nm"  ,380);
         }
     }
     /**
     * Retrieving Unno, seq, ClassCd by Unno Help popup
     * @param  {Array} aryPopupData	compulsory	 Array Object
     * @param  {Int} row				optional selected Row
     * @param  {Int} col				optional selected Column
     * @param  {Int} sheetIdx		optional Sheet Index
     * @return 없음
     */  
//     function setUnnoAndClassCd(aryPopupData){ 
//    	 with(document.form){
//    		 combo_imdg_clss_cd.SetSelectText(aryPopupData[0][4],false);
//    		 imdg_clss_cd_desc.value=aryPopupData[0][5];
//    		 imdg_un_no.value=aryPopupData[0][2];
//    		 imdg_un_no_seq.value=aryPopupData[0][3];
//    		 prp_shp_nm.value=aryPopupData[0][6];
//    	 }
//     } 
     function setUnnoAndClassCd(aryPopupData){
         with(document.form){
             //imdg_clss_cd.Text2    = aryPopupData[0][4]; 
        	 document.form.imdg_un_no.value=aryPopupData[0][2];      
        	 document.form.imdg_un_no_seq.value=aryPopupData[0][3];                  
        	 document.form.prp_shp_nm.value=aryPopupData[0][6]; 
        	 document.form.imdg_un_no_seq.focus();
        	 document.form.imdg_un_no_seq.select();
             //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);              
         }
     }     
     /******************* Land by Restriction Status********************/
     /**
      * Change setting by Enabling Lane, Restriction value
      * @parma void
      * @return void 
      * @author 
      */
     function setLaneEnable(){
         with(sheetObjects[0]){
             for(var i=1;i<= RowCount();i++){
            	 if( GetCellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){
            		 SetCellEditable(i, id+"_slan_cd" ,1);
            	 }
             }
         }
         with(sheetObjects[1]){
             for(var i=1;i<= RowCount();i++){
            	 if( GetCellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){
            		 SetCellEditable(i, id+"_slan_cd" ,1);
            	 }
             }
         }
     }
     /************************************Object_event*************************************************/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	switch (sheetObj.id) {
    	    case "sheet1":
                  for(var i=1;i<=sheetObj.RowCount();i++){
/**************** L:Prohibited on Lane SetEnable(true else False **************/
                	  if( sheetObj.GetCellValue( i, "sheet1_imdg_crr_rstr_expt_cd") == "L"  ){
                		  sheetObj.SetCellEditable( i, "sheet1_slan_cd",1);
                	  }else{
                		  sheetObj.SetCellEditable( i, "sheet1_slan_cd",0);
                	  }
                  }
    	          break;
    	    case "sheet2":
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
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_slan_cd' ){
		        var lane_cd="";//sheetObj.GetCellText(Row, Col);
				ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 426, 475, "setSheet1_PopupCallback_SlanCd", "0,0", true, false, Row, Col, 0);
		    }
 		}
 	}     
    /**
    * Handling Sheet2 OnPopupClick event
    * @param sheetObj
    * @param Row
    * @param Col
    * @return
    */
   function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_imdg_un_no_seq' ){
	   	    	 var imdg_un_no=sheetObj.GetCellText(Row,  sheetObj.id+'_imdg_un_no'     );
 	  	    	 var imdg_un_no_seq=sheetObj.GetCellText(Row,  sheetObj.id+'_imdg_un_no_seq' );
 			     ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,
 			    		970, 510, "setSheet2_PopupCallback_ImdgUnNoSeq", "0,1,1,1,1,1,1,1", true,true, Row, Col, 1);
//            	var imdg_un_no=document.form.imdg_un_no.value;
//                var imdg_un_no_seq=document.form.imdg_un_no_seq.value; 
//                ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 470, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);		    	
		    }
		    if( sheetObj.ColSaveName(Col) == sheetObj.id+'_slan_cd' ){
		        var lane_cd="";//sheetObj.GetCellText(Row, Col);
				ComOpenPopup('/opuscntr/VOP_VSK_0202.do?lane_cd='+lane_cd, 426, 475, "setSheet2_PopupCallback_SlanCd", "0,0", true, false, Row, Col, 1);
		    }
		}
	}
     /**
      * Handling Class combo OnChange event
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
     /*function combo_imdg_clss_cd_OnChange(comboObj,value,text) {
    	 var formObj=document.form;
    	 var aText=text.split("|");
         var sText=comboObj.GetText( value , 1);
         if( text == "" ){
        	 imdg_clss_cd_desc.value="";
         }else{
        	 imdg_clss_cd_desc.value=sText;
         } 
     }*/
     function combo_imdg_clss_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,value,text) {
	       var formObj=document.form;
	       var aText=newText.split("|");
	       var sText=comboObj.GetText( newCode , 1);
	       if( newText == "" ){
	    	   formObj.imdg_clss_cd_desc.value="";
	       }else{
	    	   formObj.imdg_clss_cd_desc.value=sText;
	       } 
	   }
      /**
       * 
       * <pre>
       *     input EnterKey.
       * </pre>
       *
       * @param   
       * @return
       * @author
       */
      function combo_imdg_clss_cd_OnKeyDown(comboObj, KeyCode, Shift) {
          var formObj=document.form;
         // imdg_clss_cd.style.ime-mode="disabled";
          if( KeyCode == 13){
              doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
          }
      }
    /**
     * Handling Sheet1 combo OnChange event
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
     function sheet1_OnChange(sheetObj, row, col) {
    	 
    	 switch( sheetObj.ColSaveName(col)  ){
    	       case 'sheet1_imdg_clss_cd' :
//    	            var SetSelectedIndex(sheetObj.GetComboInfo(row, col, "SelectedIndex"));
                    var sText = sheetObj.GetComboInfo(row, col, "Text");
                    var arrText = sText.split("|");
                    
                    var idx = sheetObj.GetComboInfo(row, col, "SelectedIndex");
                    if(idx != -1){
                    	//@@ 'sheet1_imdg_clss_cd' -> SetCellValue
                        sheetObj.SetCellValue(row, sheetObj.id+"_imdg_clss_cd_desc",arrText[idx]);
                    }
                    //var aSelectedText=aText[SelectedIndex].split("\t");
    	    	    //sheetObj.SetCellValue(row, sheetObj.id+"_imdg_clss_cd_desc",aSelectedText[1],0);
    	            break;
    	       case 'sheet1_imdg_crr_rstr_expt_cd':
    	    	   if( sheetObj.GetCellValue(row, sheetObj.id+"_imdg_crr_rstr_expt_cd") == "L" ){
    	        		 sheetObj.SetCellEditable(row, sheetObj.id+"_slan_cd" ,1);
                         sheetObj.SelectCell(row,  sheetObj.id+"_slan_cd");
    	        	}else{
    	        		 sheetObj.SetCellValue(row, sheetObj.id+"_slan_cd","",0);
    	        		 sheetObj.SetCellEditable(row, sheetObj.id+"_slan_cd" ,0);
    	        	}
   	                break;
               case 'sheet1_slan_cd' :
            	   //if( sheetObj.GetCellValue!= "" ){
                   //   if( sheetObj.GetEditText().length != 3){
                   //        ComShowCodeMessage("SCG50006","Lane","3" );
                   //        sheetObj.SetCellValue(row, sheetObj.id+"_slan_cd","",0);
                   //        sheetObj.SelectCell(row, sheetObj.id+"_slan_cd");
                   //    }
                   //}
                   break;          
    	 }
     }
     /**
      * Handling Sheet1 OnSelectCell event
      * @param OldRow
      * @param OldCol
      * @param NewRow
      * @param NewCol
      * @return
      */
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
         var formObject=document.form;
         if( OldRow != NewRow ){
        	 formObject.crr_regu_desc_class.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "sheet1_crr_regu_desc");
         }
     }
      /**
       * 
       * <pre>
       *     Handling Sheet1 OnKeyUp event
       * </pre>
       *
       * @param   
       * @return
       * @author 
       */
     function  sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
          var formObj=document.form;
          if( KeyCode == 229){return;}
          switch( sheetObj.ColSaveName(Col)  ){
                 case 'sheet1_slan_cd' :
                       if( sheetObj.GetEditText().length == 3){
                           sheetObj.SetCellValue(Row, "sheet1_slan_cd",sheetObj.GetEditText(),0);
                           doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC06, Row);                            
                       }
                       break;
          }
     }

     /**
      * Handling Sheet2 combo OnChange event
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
	//function sheet2_OnChange(sheetObj, Row, Col) {
    //@@ Val 파라미터 추가 -> Val.length 로 처리해야 됨 
    function sheet2_OnChange(sheetObj, Row, Col, Val) {
	var formObj=document.form;
		switch( sheetObj.ColSaveName(Col)  ){
			case 'sheet2_imdg_crr_rstr_expt_cd':
				if( sheetObj.GetCellValue(Row, sheetObj.id+"_imdg_crr_rstr_expt_cd") == "L" ){
					sheetObj.SetCellEditable(Row, sheetObj.id+"_slan_cd" ,1);
					sheetObj.SelectCell(Row,  sheetObj.id+"_slan_cd");
				}else{
					sheetObj.SetCellValue(Row, sheetObj.id+"_slan_cd","",0);
					sheetObj.SetCellEditable(Row, sheetObj.id+"_slan_cd" ,0);
				}
				break;
			case 'sheet2_imdg_un_no_seq' :
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03, Row);
				break;
			case 'sheet2_imdg_un_no' :
				if( sheetObj.GetCellValue!= "" ){
					//@@if( sheetObj.GetEditText().length != 4){
					if(Val.length != 4){
						ComShowCodeMessage( "SCG50006","UN No.","4" );         
						sheetObj.SetCellValue(Row, sheetObj.id+"_imdg_un_no","",0);
						sheetObj.SelectCell(Row, sheetObj.id+"_imdg_un_no");
					}
				}
				break;
			case 'sheet2_slan_cd' :
				//if( sheetObj.GetCellValue!= "" ){
				//	if( sheetObj.GetEditText().length != 3){
				//		ComShowCodeMessage( "SCG50006","Lane","3" );         
				//		sheetObj.SetCellValue(Row, sheetObj.id+"_slan_cd","",0);
				//		sheetObj.SelectCell(Row, sheetObj.id+"_slan_cd");
				//	}
				//}
				break;                      
		}
	}
	function  sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
    	   var formObj=document.form;
    	   if( KeyCode == 229){return;}
      	   switch( sheetObj.ColSaveName(Col)  ){
                  case 'sheet2_imdg_un_no' :
       	    	        if( sheetObj.GetEditText().length == 4){
       	    	        	//@@GetEditText() 의 값이 초기화 되기때문에 변수에 보관후 적용
       	    	        	var Val = sheetObj.GetEditText();
       	    	        	fnClearUnnoInfo(sheetObj, Row); 
       	    	        	sheetObj.SetCellValue(Row, "sheet2_imdg_un_no",Val,0);
       	    	        	sheetObj.SetCellValue(Row, "sheet2_imdg_un_no_seq","",0);
                            doActionIBSheet(sheetObjects[1], formObj,IBSEARCH_ASYNC05, Row);       	    	        	
    	    	        }
                        break;
                  case 'sheet2_imdg_un_no_seq' :
                	  if( sheetObj.GetCellValue(Row, "sheet2_imdg_un_no") == "" ){
                	         ComShowCodeMessage( "SCG50010", 'Data'  );        	        
                	         sheetObj.SetCellValue(Row, "sheet2_imdg_un_no_seq","",0);
                	         sheetObj.SelectCell(Row, "sheet2_imdg_un_no");
                	    }
//                	  if( sheetObj.GetEditText()!=  sheetObj.GetCellValue(Row, "sheet2_imdg_un_no_seq") ){
//     	    	        	fnClearUnnoInfo(sheetObj, Row);
//     	    	        }
                        if(sheetObj.GetEditText()== ""){
     	    	            sheetObj.SetCellValue(Row, "sheet2_imdg_un_no_seq",sheetObj.GetEditText(),0);
     	    	        }
                	    break;
                 case 'sheet2_slan_cd' :
                      if( sheetObj.GetEditText().length == 3){
                          sheetObj.SetCellValue(Row, "sheet2_slan_cd",sheetObj.GetEditText(),0);
                          doActionIBSheet(sheetObjects[1], formObj,IBSEARCH_ASYNC06, Row);                            
                      }
                      break;
      	   }
      }
	
	//@@
    function getCrr_cd(rowArray) {
	    var sheetObj=sheetObjects[0];
	    var formObj=document.form;
	    
	    var colArray=rowArray[0];
	    formObj.crr_cd.value=colArray[3];
	    formObj.crr_nm.value=colArray[4];
	 }	
	
	/**
      * Handling image Button event
      * @param  void
      * @return void
      */
     function img_click(){
	    var obj=ComGetEvent();
        var formObj=document.form;
	    if(obj.name == "srch_crr_cd"){
             //ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.crr_cd), 423, 450, "crr_cd:crr_cd|crr_nm:crr_nm", "1,0,1,1,1", true);
             ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 600, 500, 'getCrr_cd', "1,0,1", true);
	    }    
//   	    if(obj.name == "srch_imdg_un_no"){
//	         if( obj.className == ""){
//	    		  return;
//	    	 }
//   	    	 var imdg_un_no=formObj.imdg_un_no.value;
//  	    	 var imdg_un_no_seq=formObj.imdg_un_no_seq.value;
//  	    	 ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
// 	    }
     }
     /**
      * Handling document.all Object mouse down event
      * @return
      */
     function mouse_down(){
    	 var obj=ComGetEvent();
    	 var formObj=document.form;
    	 switch ( obj.id ){
			case "btn_Retrieve":  				
				callbackEvent="btn_Retrieve"; 	
			break;
    	 }
     }
      /**
       * 
       * <pre>
       *    onblur and Search at the same time event
       * </pre>
       *
       * @param   
       * @return
       * @author
       */
      function ComKeyEnterControl(){
          if( event.keyCode != 13){return;}
          var obj=ComGetEvent();
          var formObj=document.form;
          switch ( obj.name ){
             case "crr_cd":
                 oneventing="Y";
                 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                 if( !ComChkValid(formObj) ){
                     oneventing="N";
                     return;
                 }else{
                     callbackEvent="btn_Retrieve";                     
                     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                 }
                 oneventing="N";
                 break;
             default:
                  ComKeyEnter();
                  break;
          }      
      }
     /**
      * Handling Form Object obj_keypress event
      * @param  void
      * @return void
      */     
      function obj_keypress (){
    	  var obj=ComGetEvent();
      	  switch(ComGetEvent("name")){
 	           case 'crr_cd':
 	        	     ComKeyOnlyAlphabet('upper');
 	    	         break;
      	       case 'imdg_un_no':
      	    	    ComKeyOnlyNumber(obj);
      	    	    break;
      	       case 'imdg_un_no_seq':
      	    	    ComKeyOnlyNumber(obj);
     	    	    break;      	    	    
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
          for(var i=0;i<sheetObjects.length;i++){
              var cnt=sheetObjects[i].RowCount();
              for(var j=1;j<= cnt;j++ ){
                  sheetObjects[i].RowDelete(1, false);
              }
          }
      }
       /**
        * 
        * <pre>
        *     user fuction after retrieve
        * </pre>
        *
        * @param   sheetObj
        * @return  void
        * @author 
        */
      function fnSearchEnd(sheetObj){
          switch ( sheetObj.id ){
              case "sheet2" :
                  sheetObj.SetColHidden("sheet2_imdg_tec_nm",1);
                  for(var i=1;i<=sheetObj.RowCount();i++){
                	  if( sheetObj.GetCellValue(i,"sheet2_imdg_tec_nm") != ""){
                          sheetObj.SetColHidden("sheet2_imdg_tec_nm",0);
                          return;
                      }
                  }
                  sheetObj.SetColWidth("sheet2_prp_shp_nm",480);
                  break;
          }
      }
      /**
       * Handling Sheet2 OnSelectCell event
       * @param OldRow
       * @param OldCol
       * @param NewRow
       * @param NewCol
       * @return
       */
      function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
           var formObject=document.form;
           if( OldRow != NewRow ){           
        	   formObject.crr_regu_desc_unno.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "sheet2_crr_regu_desc");
           }
      }
      /**
       * Handling Form Object  keydown event
       * @param  void
       * @return void
       */     
       function obj_keyup(){ 
	   	    var obj=ComGetEvent();
	   	    var formObj=document.form;
	  	    switch(ComGetEvent("name")){
  	           case 'crr_cd':
  	                 fnNewGrid();     	               
  	                 combo_imdg_clss_cd.SetSelectText("",false);
  	                 formObj.imdg_clss_cd_desc.value="";
	        	     formObj.imdg_un_no.value="";	        	     
	        	     formObj.imdg_un_no_seq.value="";
	        	     formObj.prp_shp_nm.value="";  
                     formObj.crr_regu_desc_class.value="";  	        	     
                     formObj.crr_regu_desc_unno.value="";  
            	     if( formObj.crr_cd.value.length  > 3    ){
  	    	    	       if( oneventing == "N" ){
	        	    	     oneventing="Y";
	        	    	     doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
	        	    	     oneventing="N";
	    	    	       }                           
            	     }else{
            	    	   formObj.crr_nm.value='';
            	    	   //initClassBtn(false);            	    	   
            	     }
  	                 break;
  	           case 'imdg_un_no':
  	                 fnNewGrid();     	               
                     formObj.crr_regu_desc_class.value="";                     
                     formObj.crr_regu_desc_unno.value="";
                     formObj.imdg_un_no_seq.value="";
                     formObj.prp_shp_nm.value="";
                     combo_imdg_clss_cd.SetSelectText("",false);
                     formObj.imdg_clss_cd_desc.value="";
          	         if( formObj.imdg_un_no.value.length == 4  ){  	
  	        	         doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
          	         }
	                 break;
  	           case 'imdg_un_no_seq':
  	        	   combo_imdg_clss_cd.SetSelectText("",false);
  	        	   formObj.imdg_clss_cd_desc.value="";
  	               fnNewGrid();     	               
                   formObj.prp_shp_nm.value="";
                   formObj.crr_regu_desc_class.value="";                     
                   formObj.crr_regu_desc_unno.value="";                     
  	        	   break;
	  	    }     		 
       }
       /**
        * Handling Form Object  onchange event
        * @param  void
        * @return void
        */     
        function obj_change(){
  	  	    var obj=ComGetEvent();
  	  	    var formObj=document.form;
  	  	    switch(ComGetEvent("name")){
    	           case 'crr_regu_desc_class':
	            	   var cByte=ComGetLenByByte(formObj.crr_regu_desc_class  );
	            	   if ( cByte > 4000  ){
	            		   ComShowCodeMessage("COM12142", "", "4000byte (Current:"+cByte+")");
	            		   formObj.crr_regu_desc_class.focus();
	            		   formObj.crr_regu_desc_class.select();
	            		   return false;
	            	   }    	        	   
    	        	   sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_crr_regu_desc",document.form.crr_regu_desc_class.value,0);
    	               break;
    	           case 'crr_regu_desc_unno':
	            	   var cByte=ComGetLenByByte(formObj.crr_regu_desc_unno  );
	            	   if ( cByte > 4000  ){
	            		   ComShowCodeMessage("COM12142", "", "4000byte (Current:"+cByte+")");
	            		   formObj.crr_regu_desc_class.focus();
	            		   formObj.crr_regu_desc_class.select();
	            		   return false;
	            	   }    	        	   
    	        	   sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_crr_regu_desc",document.form.crr_regu_desc_unno.value,0);
    	               break;
  	  	    }
        }           
     /**
      * Handling Form Object  blur event
      * @param  void
      * @return void
      */     
      function obj_blur (){
            if( oneventing == "Y"){return;}
	  	    var obj=ComGetEvent();
            var formObj=document.form;
	  	    switch(ComGetEvent("name")){
			   case "crr_cd":
				     if( formObj.crr_cd.value.length  >= 3 ){
	    	    	     if( oneventing == "N" ){
	        	    	     oneventing="Y";
	        	    	     doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
	        	    	     oneventing="N";
	    	    	     }
	  	             }else{ 
	  	                 if( formObj.crr_cd.value !=""   ){
	  	                     if( !ComChkValid(formObj) ){
	  	                         obj.focus(); 
	  	                         obj.select();      	  	                         
	  	                         return;
	  	                     }
	  	                     return;
	  	                 }
	  	             }
    	    	     break;
               case "imdg_un_no":
            	   if( formObj.imdg_un_no.value.length  == 4 ){
                	   doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);   
                   }
                   break;
			   case "imdg_un_no_seq":
	  	    	    if( oneventing == "N" ){
					     formObj.prp_shp_nm.value="";
					     if( formObj.imdg_un_no.value.length  == 4  && formObj.imdg_un_no_seq.value.length  != ""    ){
		    	    	     oneventing="Y";							    	 
		   	                 doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC04); 
	        	    	     oneventing="N";
		   	    	     }
	  	    	    }
		    	    break;
	  	    }
      }
     /**
      * Handling Form Object  OnChange event
      * @param  void
      * @return void
      */
      function obj_click(){ 
   	     obj=ComGetEvent();
   	     var formObj=document.form;
   	     var doc=document.all;
         switch(obj.name ) {
 			case "optclass":
                initoptclass();
 	 	    	if(obj.value == "class"){ 
                    doc.div_s1.style.display="";                    
                    doc.div_s2.style.display="none";
                    formObj.crr_regu_desc_class.value="";
                    initClassBtn(false);
                    ComBtnDisable("srch_imdg_un_no");
                    ComBtnEnable("srch_crr_cd");
 	 	    	}
 	 	    	if(obj.value == "unno"){
                    doc.div_s1.style.display="none";                    
                    doc.div_s2.style.display="";          
                    formObj.crr_regu_desc_unno.value="";                    
                    initUnnoBtn(false);
//                    ComBtnDisable("srch_crr_cd");
                    ComBtnEnable("srch_imdg_un_no");
 	 	    	}
 				break;
         } // end switch
      }
