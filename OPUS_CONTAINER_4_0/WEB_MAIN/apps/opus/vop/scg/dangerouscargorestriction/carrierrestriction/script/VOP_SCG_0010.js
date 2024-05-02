/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0010.jsp
 *@FileTitle : Vessel Operator's Restriction on DG - Inquiry
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
     * @class vop_scg_0010 : business script for vop_scg_0010
     */
    // common global variables
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
           // try {
               var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
               var optclass=window.event.srcElement.getAttribute("optclass");
               var doc=document.all;
                switch(srcName) {
                   case "btn_Retrieve":
                       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                       break;
                   case "btn_New":
                       doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                       break;
                   case "btn_DownExcel":
                	   if( formObject.optclass[0].checked ){
                		   var paramObj=new Object();
                           paramObj.title="Vessel Operator's Restriction on DG";
//                           paramObj.cols="4";
//                           paramObj.columnwidth="1:10|2:80|3:20|4:10";
//                           var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);
//                           if(sheetObjects[0].RowCount() < 1){//no data
//                        	   ComShowCodeMessage("COM132501");
//                    	   }else{
//                    		   sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
//                    	   }
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
                	   }else{
                           var paramObj=new Object();
                           paramObj.title="Vessel Operator's Restriction on DG";
                           paramObj.cols="9";
                           paramObj.columnwidth="1:5|2:5|3:5|4:55|5:20|6:7|7:7|8:10|9:7";
                           paramObj.datarowheight="0:25";
                           var url=ComScgGetPgmTitle(sheetObjects[1], paramObj);  
                           if(sheetObjects[1].RowCount() < 1){//no data
                        	   ComShowCodeMessage("COM132501");
                    	   }else{
                    		   sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
                    	   }
                	   }	
					break;
                   case "srch_imdg_un_no":
                   	var imdg_un_no=document.form.imdg_un_no.value;
                       var imdg_un_no_seq=document.form.imdg_un_no_seq.value; 
                       ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 470, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
                   	break;					
                   case "btn_Close":
                	   ComClosePopup(); 
                       break;                       
                } // end switch
//         }catch(e) {
//             if( e == "[object Error]") {
//                 ComShowMessage(OBJECT_ERROR);
//             } else {
//                 ComShowMessage(e);
//             }
//         }
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
         * registering IBCombo Object as list
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
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initControl();
            sheet1_OnLoadFinish(sheet1);
//            doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        }
         function sheet1_OnLoadFinish(sheetObj) {
             doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         }         
        function initControl() {
            var form=document.form;
////            axon_event.addListenerForm('keypress','obj_keypress',    form  );
//            axon_event.addListenerForm('keydown','ComKeyEnterControl',  form,"crr_regu_desc_class|crr_regu_desc_unno"  );
            axon_event.addListenerForm('blur',    'obj_blur'      ,form);
////            axon_event.addListenerForm('keyup',   'obj_keyup',     form );          
            axon_event.addListenerForm('click',   'obj_click',     form);   
            axon_event.addListenerForm('change',  'obj_change',    form);           
            axon_event.addListener    ('click',   'img_click',     "srch_imdg_un_no");
            axon_event.addListener    ('click',   'img_click',     "srch_crr_cd"    ); 
            axon_event.addListener    ('mousedown', 'mouse_down',   "btn_Retrieve");   
            // Initializing IBMultiCombo
            for(var k=0; k<comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
        }
        /**
         * Initializing Combo
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
                    with (sheetObj) {
                        // setting height
                	
                	var HeadTitle="|Sel.|Class|Definitions|Restrictions|Lane||||";
                	(HeadTitle.split("|").length, 0, 0, true);
                	var prefix="sheet1_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:690,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_clss_cd_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             
                	             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             ////{Type:"Text",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"crr_regu_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_opr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"row_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                	 
                	InitColumns(cols);
                	SetSheetHeight(300);
                    SetEditable(1);
//                    SetGetCountPosition()(2);
//                	SetHeaderGetRowHeight(28);
//                	SetGetShowButtonImage()(1);                  
                  }
                    break;
                case 2:      // sheet2 init
                    with (sheetObj) {
                        // setting height
                	
                	var HeadTitle="|Sel.|Amdt No.|Class|UN No./Seq.|UN No./Seq.|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Restrictions|Lane|regu_desc|vsl_opr_tp_cd|imdg_crr_rstr_seq";
                	( HeadTitle.split("|").length , 0, 0, true);
                	var prefix="sheet2_";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_amdt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"PopupEdit", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no_seq",        KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:360,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prp_shp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_tec_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_pck_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"crr_regu_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_opr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix+"imdg_crr_rstr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                	 
                	InitColumns(cols);
                	SetSheetHeight(300);
                	SetEditable(1);
//                	                       SetGetCountPosition()(2);
//                	SetHeaderGetRowHeight(28);
//                	SetGetShowButtonImage()(1);
//                	SetGetExtendLastCol()(0);
                  }
                    break;
            }
        }
      // Sheet related process handling
        var aEtcData="";
        varaEtcDataAll="";
        function doActionIBSheet(sheetObj,formObj,sAction, pRow) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                 case IBCLEAR :      //initializing
                          initoptclass(); 
                          formObj.f_cmd.value=SEARCH02;   
                          var param=FormQueryString(formObj);
                          var exceptkey="C";
                           var sXml=sheetObj.GetSearchData("VOP_SCG_0009GS.do", param+"&code=CD01950&exceptkey="+exceptkey, true);
                          aEtcData=ComGetEtcData(sXml ,"codeinfo").split("|##|");     
                          aEtcDataAll=ComGetEtcData(sXml ,"codeinfoAll").split("|##|");                     
                          /***************  Grid  Combo Set **********************************/
                          sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:aEtcData[1], ComboCode:aEtcData[0]} );
                          sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
                                /***********Class Combo Set *********************************/
                          var class_cd=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
                          var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
                          sheetObjects[0].SetColProperty("sheet1_imdg_clss_cd", {ComboText:"|"+tStr, ComboCode:"|"+class_cd[0]} );
                          /*************** Search Combo grpcd and Class Cd Setting ******/        
                          ComXml2ComboItem(sXml, combo_imdg_clss_cd, "imdg_clss_cd"    , "imdg_clss_cd|imdg_clss_cd_desc" );
                          /******************* CLASS GRID ENABLE, UNNO GRID DISABLE********************/
                          for(var i=1;i<=sheetObjects[0].RowCount();i++){
                              sheetObjects[0].SetRowEditable(i,1);
                          }
                          for(var i=1;i<=sheetObjects[1].RowCount();i++){
                              sheetObjects[1].SetRowEditable(i,0);
                          }    
                          /**************0011 PGM recieved param set **************************/
                          if( formObj.pCrr_cd.value != ""){
                              if(formObj.pSearchMethod.value != ""){
                                  if(  formObj.pSearchMethod.value  == "class" ){
                                      formObj.optclass[0].checked=true;
                                      //formObj.optclass[0].onclick = function(){obj_click()}; 
                                      formObj.optclass[0].onclick = obj_click(); 
                                  }else if(  formObj.pSearchMethod.value  == "unno" ){
                                      formObj.optclass[1].checked=true;
                                      formObj.optclass[0].onclick = obj_click(); 
                                  } 
                              }
                              //obj_click();   //.fireEvent('onclick')                           
                              formObj.crr_cd.value=formObj.pCrr_cd.value;
                              combo_imdg_clss_cd.SetSelectCode(formObj.pImdg_clss_cd.value);
                              formObj.imdg_un_no.value=formObj.pImdg_un_no.value;
                              formObj.imdg_un_no_seq.value=formObj.pImdg_un_no_seq.value;
                              formObj.prp_shp_nm.value=formObj.pPrp_shp_nm.value;
                              doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                              doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);                              
                          }else{
//                              formObj.crr_cd.focus();
                          }
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
	   					  				  comText=comText[0]+"|"+comText[1]+"|"+comText[2];
	   					  				  comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[2];
	   					  				  
	   					  				  ////sheetObjects[0].SetColProperty("sheet1_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
	   					  				  sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
                                      }   
                                      
                                 }else if( formObj.optclass[1].checked ){
                                	 
                                      with( sheetObjects[1] ){                           
                                          formObj.f_cmd.value=SEARCH01;  
                                          var param="f_cmd="+formObj.f_cmd.value;//+"&imdg_clss_cd="+imdg_clss_cd.GetSelectText();
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
                                          /********In case value exists in SHOW_MSG, message displays before DATA DISP.*******/
                                          if(SHOW_MSG != "" && SHOW_MSG != undefined){
                                              ComShowMessage( sMsg);
                                              sXml=ComDeleteMsg(sXml);
                                          }
                                          LoadSearchData(sXml,{Sync:0} );
                                          fnSearchEnd(sheetObjects[1]);
                                          if(GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc")!=-1){
                                        	  formObj.crr_regu_desc_unno.value=GetCellValue(GetSelectRow(), id+"_"+"crr_regu_desc");  
                                          }
                                          
                                          if (formObj.crr_cd.value != ConstantMgr.getCompanyCode()) {
   					  					   var comText=aEtcDataAll[1].split("|");
   					  					   var comCode=aEtcDataAll[0].split("|");
   					  					   
   					  					   ////2015-05-31//comText=comText[1]+"|"+comText[2]+"|"+comText[3]+"|"+comText[5]+"|";
   					  					   ////2015-05-31//comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[2]+"|"+comCode[4]+"|";
   					  					   
   					  					   comCode=comCode[0]+"|"+comCode[1]+"|"+comCode[2]+"|"+comCode[4];
   					  					   comText=comText[0]+"|"+comText[1]+"|"+comText[2]+"|"+comText[4];
					  					   
   					  					   ////sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:comText, ComboCode:comCode} );
   					  					   sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
                                          
                                          }else{
	   						                  sheetObjects[1].SetColProperty("sheet2_imdg_crr_rstr_expt_cd", {ComboText:aEtcDataAll[1], ComboCode:aEtcDataAll[0]} );
	   					  				  }
                                      }
                                 }
                                 /******************* Land by Restriction Status********************/
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
//                            formObj.crr_cd.focus();
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
                                iniBtn(true); 
                                with(formObj){
                                    if( optclass[0].checked){ 
//                                        imdg_clss_cd.focus();
                                    }
                                    if( optclass[1].checked){
//                                        formObj.imdg_un_no.focus();
                                    }
                                }                       
                            }else{
                                ComShowCodeMessage( "SCG50010", 'Data'  );
                                formObj.crr_cd.value="";
                                formObj.crr_nm.value="";
//                                formObj.crr_cd.focus();
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
//                                formObj.imdg_un_no.focus();
                           }else{
//                                formObj.imdg_un_no_seq.focus();
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
//                                formObj.imdg_un_no_seq.focus();   
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
//                                   formObj.imdg_un_no.focus();
                                   formObj.imdg_un_no.select();
                                   return false;
                               }else if( formObj.imdg_un_no_seq.value == ""){  
//                                   formObj.imdg_un_no_seq.focus();
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
                              if( !ComChkValid(formObj) ){
                                 return false;
                              }
                              if( formObj.crr_cd.value == "" || formObj.crr_nm.value == "" ){                      
                                  ComShowCodeMessage( "COM12113", " Vessel Operator.."  );
//                                  formObj.crr_cd.focus();
                                  formObj.crr_cd.select();
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
        * handling process for input validation <br>
        * <br><b>Example : </b>
        * <pre>
        *      CheckDup(sheetObj, sheet1_loc_cd|sheet1_rgn_shp_opr_cd) 
        * </pre>
        * @param {Object }  compulsory, Sheet Object 
        * @param {Object }  compulsory, ColSaveName for checking
        * @return boolean
        * @see #link connect
        * @author
        * @version
        */
        function CheckDup(sheetObj ,ColSaveName){
            var Row=sheetObj.ColValueDup( ColSaveName,false);
            var msg="";
            if( Row != -1){
                msg=fnMakeMsg(Row, sheetObj);
                ComShowCodeMessage("SCG50010", 'Data');
                if( sheetObj.id == "sheet1"){
                    sheetObj.SelectCell(Row, "sheet1_imdg_clss_cd");
                }else if( sheetObj.id == "sheet2"){
                    sheetObj.SelectCell(Row, "sheet2_imdg_un_no");
                }           
                return false;           
            }
            if( sheetObj.id == "sheet1"){
                return CheckDupAddClss(sheetObj);
            }else if( sheetObj.id == "sheet2"){
                return CheckDupAddUnno(sheetObj);
            }
            return true;
        }
        function fnMakeMsg(cRow,sheetObj ){
        	var rstr_expt_cd=sheetObj.GetCellValue(cRow, sheetObj.id+"_imdg_crr_rstr_expt_cd");
            var msg="";
            switch (rstr_expt_cd){
                case "P":
                     msg="[Prohibited or Restrictions]";
                     break;
                case "R":
                    msg="[Prohibited or Restrictions]";
                     break;
                case "C":
                    msg="[Excepted fm Class prohibition]";                 
                    break;
                case "T":
                    msg="[T/S Prohibited]";                            
                    break;
                case "L":
                	var slan_cd=sheetObj.GetCellValue(cRow, sheetObj.id+"_slan_cd");
                    msg="[Prohibited on Lane - "+slan_cd+"]";                    
                    break;                 
            }
            return msg;
        }
        /**
         * 
         * <pre>
         *
         * </pre>
         *
         * @param   sheetObj
         * @return  boolean
         * @author
         */
        function CheckDupAddClss(sheetObj){
            for(var i=1;i<=sheetObj.RowCount();i++){
            	if(sheetObj.GetRowStatus(i) == "D" ){
                    continue;
                }
            	if( sheetObj.GetCellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "P" ){
            		var mStr=sheetObj.GetCellValue(i, sheetObj.id+"_imdg_clss_cd" )+"$R";
                    for(var j=i+1;j <= sheetObj.RowCount(); j++){
                    	if(sheetObj.GetRowStatus(j) == "D"  ){
                            continue; 
                        }                     
                    	var sStr=sheetObj.GetCellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.GetCellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" )
                        if( mStr ==  sStr){
                            var msg=fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet1_imdg_clss_cd");
                            return false;   
                        }
                    }
            	}else if( sheetObj.GetCellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "R" ){
            		var mStr=sheetObj.GetCellValue(i, sheetObj.id+"_imdg_clss_cd" )+"$P";
                    for(var j=i+1;j <= sheetObj.RowCount(); j++){
                    	if(sheetObj.GetRowStatus(j) == "D"  ){
                            continue;
                        }
                    	var sStr=sheetObj.GetCellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.GetCellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" )
                        if( mStr ==  sStr){
                            var msg=fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet1_imdg_clss_cd");
                            return false;   
                        }
                    }              
                }
            } 
            return true;
        }
        function CheckDupAddUnno(sheetObj){
            for(var i=1;i<=sheetObj.RowCount();i++){
            	if(sheetObj.GetRowStatus(i) == "D" ){
                    continue;
                }
            	if( sheetObj.GetCellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "P" ){
            		var mStr=sheetObj.GetCellValue(i, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.GetCellValue(i, sheetObj.id+"_imdg_un_no_seq" )+"$R";
                    for(var j=i+1;j <= sheetObj.RowCount(); j++){
                    	if(sheetObj.GetRowStatus(j) == "D"  ){
                            continue;
                        }                     
                    	var sStr=sheetObj.GetCellValue(j, sheetObj.id+"_imdg_clss_cd" )+"$"+sheetObj.GetCellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" );
                        if( mStr ==  sStr){
                            var msg=fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet2_imdg_un_no");
                            return false;   
                        }
                    }
            	}else if( sheetObj.GetCellValue(i, sheetObj.id+"_imdg_crr_rstr_expt_cd" ) == "R" ){
            		var mStr=sheetObj.GetCellValue(i, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.GetCellValue(i, sheetObj.id+"_imdg_un_no_seq" )+"$P";
                    for(var j=i+1;j <= sheetObj.RowCount(); j++){
                    	if(sheetObj.GetRowStatus(j) == "D"  ){
                            continue;
                        }                      
                    	var sStr=sheetObj.GetCellValue(j, sheetObj.id+"_imdg_un_no" )+"$"+sheetObj.GetCellValue(j, sheetObj.id+"_imdg_un_no_seq" )
                    	+"$"+sheetObj.GetCellValue(j, sheetObj.id+"_imdg_crr_rstr_expt_cd" );
                        if( mStr ==  sStr){
                            var msg=fnMakeMsg(j, sheetObj);
                            ComShowCodeMessage("SCG50010", 'Data');
                            sheetObj.SelectCell(j, "sheet2_imdg_un_no");
                            return false;   
                        }
                    }              
                }
            } 
            return true;
        }     
        function ComLog2(msg){
            var win=document.form.crr_regu_desc_class;
            win.value += "\n"+msg;
        }
        /**
         *  Handling retrieve option Enable/Disable when selecting optclass
         * 
         * @param void 
         * @param void
         * @return
         */
        function initoptclass(){
            var formObj=document.form;
            if( formObj.optclass[0].checked){ 
                initClass();
            }
            if( formObj.optclass[1].checked){
                initUnno();
            }
        }
        /**
         *  optclass item setting - select option Class style change
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
//               document.all.srch_imdg_un_no.src='/opuscntr/img/btns_search_off.gif';   
//               document.all.srch_imdg_un_no.className='';
               document.getElementById("srch_imdg_un_no").disabled = true;
               fnNewGrid(); 
               if( formObj.crr_cd.value != ""){
//                   imdg_clss_cd.focus(); 
               }else{
//                   formObj.crr_cd.focus();
               }           
        }   
        function initClassBtn(){
            var doc=document.all;
            doc.btn_add.className="btn2";
            doc.btn_insert.className="btn2";
            doc.btn_copy.className="btn2";
            doc.btn_row_delete.className="btn2";     
            doc.btn_add2.className="btn2_1";
            doc.btn_insert2.className="btn2_1";
            doc.btn_copy2.className="btn2_1";
            doc.btn_row_delete2.className="btn2_1";       
        }
        function initUnnoBtn(){
            var doc=document.all;
            doc.btn_add.className="btn2_1";
            doc.btn_insert.className="btn2_1";
            doc.btn_copy.className="btn2_1";
            doc.btn_row_delete.className="btn2_1";       
            doc.btn_add2.className="btn2";
            doc.btn_insert2.className="btn2";
            doc.btn_copy2.className="btn2";
            doc.btn_row_delete2.className="btn2";
        }     
        /**
         *  optclass item setting - select option Class style change
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
//           document.all.srch_imdg_un_no.src='/opuscntr/img/btns_search.gif';   
//           document.all.srch_imdg_un_no.className='Cursor';    
            document.getElementById("srch_imdg_un_no").disabled = false;
           fnNewGrid();
           if( formObj.crr_cd.value != ""){
//               formObj.imdg_un_no.focus(); 
           }else{
//               formObj.crr_cd.focus();
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
//            combo_imdg_clss_cd.SetSelectCode("");
//            formObj.optclass[0].checked=true;
            combo_imdg_clss_cd.SetSelectIndex("");
            formObj.imdg_un_no.value="";         
            formObj.imdg_un_no_seq.value="";
            formObj.prp_shp_nm.value="";         
            formObj.crr_regu_desc_class.value="";             
            formObj.crr_regu_desc_unno.value="";    
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
        function iniBtn(Yn){
            var formObj=document.form;
            with(formObj){
                initClassBtn(Yn);
                initUnnoBtn(Yn);
            }
        }
       function initClassBtn(Yn){
           var doc=document.all;
           var ClassName="";
           if( Yn ){
               ClassName="btn2";
           }else{
               ClassName="btn2_1";           
           }
       }
       function initUnnoBtn(Yn){
           var doc=document.all;
           var ClassName="";
           if( Yn){
               ClassName="btn2";
           }else{
               ClassName="btn2_1";           
           }
       }        
       /**
        * Retrieving Unno, seq, ClassCd by Unno Help popup
        * @param  {Array} aryPopupData compulsory   Array Object
        * @param  {Int} row                option selected Row
        * @param  {Int} col                option selected Column
        * @param  {Int} sheetIdx       option Sheet Index
        * @return none
        */  
//        function setUnnoAndClassCd(aryPopupData){ 
//        	with(document.form){
//        		combo_imdg_clss_cd.SetSelectText(aryPopupData[0][4],false);
//        		formObj.imdg_clss_cd_desc.value=aryPopupData[0][5];    
//        		formObj.imdg_un_no.value=aryPopupData[0][2];      
//        		formObj.imdg_un_no_seq.value=aryPopupData[0][3];                  
//        		formObj.prp_shp_nm.value=aryPopupData[0][6]; 
//        	}
//        } 
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
         * Handling Lane Enable - change setting by Restriction value
         * @parma void
         * @return void 
         * @author 
         */
        function setLaneEnable(){
            with(sheetObjects[0]){
                for(var i=1;i<= RowCount();i++){
                	if( GetCellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){
                        SetCellEditable(i, id+"_slan_cd" ,0);
                    }
                }
            }
            with(sheetObjects[1]){
                for(var i=1;i<= RowCount();i++){
                	if( GetCellValue(i, id+"_imdg_crr_rstr_expt_cd") == "L" ){
                        SetCellEditable(i, id+"_slan_cd" ,0);
                    }
                }
            }
        }
        /************************************Object_event*************************************************/
       function sheet1_OnSearchEnd(sheetObj, ErrMsg){
           switch (sheetObj.id) {
               case "sheet1":
                     for(var i=1;i<=sheetObj.RowCount();i++){
/**************** L:Prohibited on Lane 만 SetEnable(true else False **************/
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
         * Handling Class combo OnChange event
         * @param comboObj
         * @param value
         * @param text
         * @return
         */
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
          *     input EnterKey
          * </pre>
          *
          * @param   
          * @return
          * @author
          */
         function combo_imdg_clss_cd_OnKeyDown(comboObj, KeyCode, Shift) {
             var formObj=document.form;
             if( KeyCode == 13){
                 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
         
         function getCrr_cd(rowArray) {
     	    var sheetObj=sheetObjects[0];
     	    var formObj=document.form;
     	    
     	    var colArray=rowArray[0];
     	    formObj.crr_cd.value=colArray[3];
     	    formObj.crr_nm.value=colArray[4];
     	 }	         
         
        /**
         * Handling image Button click event
         * @param  void
         * @return void
         */
        function img_click(){
           var obj=ComGetEvent();
           var formObj=document.form;
           if(obj.name == "srch_crr_cd"){
               //ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.crr_cd), 700, 460, "crr_cd:crr_cd|crr_full_nm:crr_nm", "1,0,1,1,1", true);
        	   ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 600, 500, 'getCrr_cd', "1,0,1", true);
           }    
//           if(obj.name == "srch_imdg_un_no"){
////                if( obj.className == ""){
////                     return;
////                }              
////                var imdg_un_no=formObj.imdg_un_no.value;
////                var imdg_un_no_seq=formObj.imdg_un_no_seq.value;
////                ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq,970, 500, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
//           	var imdg_un_no=document.form.imdg_un_no.value;
//            var imdg_un_no_seq=document.form.imdg_un_no_seq.value; 
//            ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 470, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);        	   
//           }
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
          *    onblur/Search at the same time event
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
           *     user function after retrieving.
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
                        //no support[check again]CLT /**************** flag restricting OnBlur when SearchXml ****************/
                              if( oneventing == "N" ){
                                oneventing="Y";
                                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                                oneventing="N";
                              }                           
                        }else{
                              formObj.crr_nm.value='';
                              iniBtn(false);                          
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
                          sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_crr_regu_desc",document.form.crr_regu_desc_class.value,0);
                          break;
                      case 'crr_regu_desc_unno':
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
//                				  obj.focus();
                				  obj.select();
                				  return;
                			  }
                			  return;
                		  }
                	  }
                	  break;
                  case "imdg_un_no":
                	  if( !ComChkObjValid(formObj.imdg_un_no) ){
//                		  obj.focus(); 
                          obj.select();  
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
            
            if(obj.name == undefined){
            	obj.name = "btn_Retrieve";
            }
            
            switch(obj.name ) {
               case "optclass":
                   initoptclass();                  
                   if(obj.value == "class"){    
                       doc.div_s1.style.display="";                    
                       doc.div_s2.style.display="none";
                       formObj.crr_regu_desc_class.value="";
                   }
                   if(obj.value == "unno"){
                       doc.div_s1.style.display="none";                    
                       doc.div_s2.style.display="";          
                       formObj.crr_regu_desc_unno.value="";                    
                   }
                   break;
               case "btn_Retrieve":
            	   initoptclass();
                   if( formObj.optclass[0].checked){ 
                       doc.div_s1.style.display="";                    
                       doc.div_s2.style.display="none";
                       formObj.crr_regu_desc_class.value="";
                   }
                   if( formObj.optclass[1].checked){
                       doc.div_s1.style.display="none";                    
                       doc.div_s2.style.display="";          
                       formObj.crr_regu_desc_unno.value="";  
                   } 
            } // end switch
         }

