/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_2041.js
*@FileTitle  : RFA  Amendment History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_2041 : Business Script for ESM_PRI_2041
     */
    function ESM_PRI_2041() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0; 
 // RFA No. that used on last version 
 var preRfaNo="";
 var sUrl="";
 // After wait image applied, This variable has the value whether each tab enabled
 var tabEnableFlg=new Array();
 //Setting tab color to activate , deactivate tab
 var TAB_SELECT_COLOR="131,133,217"; 
 var TAB_TRUE_COLOR="206,220,246";
 var TAB_FALSE_COLOR="192,192,192";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
     function processButtonClick(){
 		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
             switch(srcName) {
             case "btn_retrieve":
     			if (formObj.rfa_no.value ==""){
    				ComShowCodeMessage("PRI02015");
    				formObj.rfa_no.focus();
    				return;
    			}
            	 sheetObj.RemoveAll();
            	 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);	
                 doActionIBSheet(sheetObj,formObj,IBSEARCH);
                 break;
             case "btn_new":
            	 sheetObj.RemoveAll();
            	 comboObjects[0].RemoveAll();
            	 clearAllTabPages();
            	 formObj.rfa_no.value="";
            	 formObj.svc_scp_nm.value="";
            	 clearAllForms();
            	 formObj.rfa_no.focus();
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
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items<br>
      * defining list on the top of source <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */ 
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * registering IBTab Object as list <br>
      * adding process for list in case of needing batch processing with other items<br>
      * defining list on the top of source <br>
      * <br><b>Example :</b>
      * <pre>
      *     setTabObject(tab_obj);
      * </pre>
      * @param {ibtab} tab_obj Mandatory IBTab Object
      * @return void
      * @author 
      * @version 2009.04.17
      */ 
      function setTabObject(tab_obj) {
          tabObjects[tabCnt++]=tab_obj;
      }
      /**
       * registering IBMultiCombo Object as list
       * adding process for list in case of needing batch processing with other items<br>
       * defining list on the top of source <br>
       * <br><b>Example :</b>
       * <pre>
       *     setComboObject(combo_obj);
       * </pre>
       * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
       * @return void
       * @author 
       * @version 2009.04.17
       */          
      function setComboObject(combo_obj){
          comboObjects[comboCnt++]=combo_obj;
      }      
      /**
       * initializing sheet <br>
       * implementing onLoad event handler in body tag <br>
       * adding first-served functions after loading screen. <br>
       * <br><b>Example :</b>
       * <pre>
       *     loadPage();
       * </pre>
       * @return void
       * @author 
       * @version 2009.04.17
       */
     function loadPage() {
         for(var i=0;i<sheetObjects.length;i++){
         		//Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
         for(var k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         //Initializing IBMultiCombo
         for(var k=0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         initControl();
         initIBComboItem();  // Setting item to IBCombo
         // From ESM_PRI_2043 to Main pop =>  2009-10-06 : Add Receiving Parameter and Writing modules to jsp.
    	 var form=document.form;
         if("null" != form.rfa_no_2043.value && null != form.rfa_no_2043.value && "" != form.rfa_no_2043.value) {
         	form.rfa_no.value=form.rfa_no_2043.value;
         	form.rfa_no.focus();
         	form.amdt_seq.focus();
         }
         form.rfa_no.focus();
     }
     /**
     * IBMulti Combo value Setting . <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.17
     */         
      function initIBComboItem() {
          var formObj=document.form;
          ComPriTextCode2ComboItem(termTypeComboValue,termTypeComboText , getComboObject(comboObjects, 'term_type_cd') ,"|","\t" );
      }
      /**
      * Catching events for Axon event.<br>
      * <br><b>Example :</b>
      * <pre>
      *     initControl()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */            
     function initControl() {
          // Process Axon Event No.1, Event Catch           
    	  axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    	  axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
    }      
     /**
     * Handling OnKeyPress<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */       
     function obj_keypress() {
         switch (ComGetEvent("dataformat")) {
             case "engup":
                 if (ComGetEvent("name") == "rfa_no" ) {
                     ComKeyOnlyAlphabet('uppernum');
                 } else {
                     ComKeyOnlyAlphabet('upper');
                 }    
                 break;
             case "int":
                 ComKeyOnlyNumber(ComGetEvent());
                 break;
             case "float":
                 ComKeyOnlyNumber(ComGetEvent(), ".");
                 break;
             default:
         }
     }         
     /**
     * Handling Onbeforedeactivate event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */            
     function obj_deactivate() {
         var formObj=document.form;
         var sheetObj=sheetObjects[0]; 
         var eleName=ComGetEvent("name");
         switch(eleName){
             case "rfa_no":
            	 if (formObj.rfa_no.value != ""){
                	 sheetObj.RemoveAll();
                	 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);    
                	 clearAllTabPages();
            	 }            	 
                 break;    

             default:            	
            	 ComChkObjValid(ComGetEvent());       
         }
         preRfaNo=formObj.rfa_no.value;
     }    
     /**
     * handling OnBeforeActivate event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
     function obj_activate() {
         var formObj=document.form;
         var srcName=ComGetEvent("name");
         ComClearSeparator(ComGetEvent());
     }     
     /**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.04.17
     */  
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
	  			case IBSEARCH_ASYNC01:      //Retrieve
	  				ComOpenWait(true); //->waiting->start
	  				formObj.f_cmd.value=SEARCH01;
	  				var param=FormQueryString(formObj);
	  				var sXml=sheetObj.GetSearchData("ESM_PRI_2041GS.do" , param);
	  				if(preRfaNo != formObj.rfa_no.value){
		  			 	clearAllForms();
		  			 	ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
		  				comboObjects[0].InsertItem(0, "||", "X");
		  				comboObjects[0].SetSelectCode("X");
	  				}
	 				if (ComGetEtcData(sXml,"prop_no") != undefined){
	 					formObj.prop_no.value=ComGetEtcData(sXml,"prop_no");
	 				}else{
	 			 		formObj.rfa_no.value="";
	 				}
	 				if (ComGetEtcData(sXml,"amdt_seq") != undefined){
	 					formObj.amdt_seq.value=ComGetEtcData(sXml,"amdt_seq");
	 				}				
	 				if (ComGetEtcData(sXml,"ctrt_pty_nm") != undefined){
	 					formObj.ctrt_pty_nm.value=ComGetEtcData(sXml,"ctrt_pty_nm");
	 				}
	 				if (ComGetEtcData(sXml,"ctrt_eff_dt") != undefined){
	 					formObj.ctrt_eff_dt.value=ComGetEtcData(sXml,"ctrt_eff_dt");
	 				}
	 				if (ComGetEtcData(sXml,"ctrt_exp_dt") != undefined){
	 					formObj.ctrt_exp_dt.value=ComGetEtcData(sXml,"ctrt_exp_dt");
	 				}
	 				ComOpenWait(false); //->waiting->End
	                break;
	  			case IBSEARCH:      //Retrieving
	  				ComOpenWait(true); //->waiting->start
	 				formObj.f_cmd.value=SEARCH02;
	  				clearAllTabPages();
	 				var param=FormQueryString(formObj);
	 				var sXml=sheetObj.GetSearchData("ESM_PRI_2041GS.do" , param);
	 				if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
	 			 	ComOpenWait(false); //->waiting->End
	  			break;
	          }        	 
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
        	 // tab Activate/Deactivate
//        	 setAllTabEnable();
         }
     }     
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets  <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} sheetNo mandatory IBSheet Object Serial No
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
				with(sheetObj){
					var HeadTitle1="|Seq.|AMD No.|SVC Scope|Effective Date|Expiry Date|Creation Date|Approve Date";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					  {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",  KeyField:0,   CalcLogic:"",   Format:"",		       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					  {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"apro_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(162);
					SetEditable(0);
					SetWaitImageVisible(0);
				}
 	            break;
         }
     }
     /**
     * setting tab initial values .  <br>
     * adding process for list in case of needing batch processing with other items </b>
     * <br><b>Example :</b>
     * <pre>
     *     initTab(tabObj,1);
     * </pre>
     * @param {tabObj} tabObj Mandatory IBTab Object
     * @param {int} tabNo Mandatory IBTab Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.04.17
     */   
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Duration", "");
					InsertItem( "Affiliate", "");
					InsertItem( "Dem/Det"  , "");
					InsertItem( "Rate" , "");
					InsertItem( "Location Group", "");
					InsertItem( "Commodity Group", "");
					InsertItem( "Arbitrary", "");
					InsertItem( "Special Note" , "");
                 }
              break;
          }
     }
     /**
     * setting intial combo value <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.04.17
     */  
      function initCombo(comboObj, comboNo) {
          switch(comboObj.options.id) {
              case "svc_scp_cd":
                  var i=0;
                  with(comboObj) {
                      SetDropHeight(200);
                      SetMultiSelect(0);
                      SetMaxSelect(1);
    	              SetUseAutoComplete(1);
    	              SetMaxLength(3);
    	              ValidChar(2);
                  }
                  break;    
              case "term_type_cd":
                  var i=0;
                  with(comboObj) {
                      SetDropHeight(200);
                      SetMultiSelect(0);
                      SetMaxSelect(1);
  	                  SetUseAutoComplete(1);
                  }
                  break;                    
          }
      }      
      /**
      * Activating selected tab in case of cliking Tab<br>
      * <br><b>Example :</b>
      * <pre>
      *     tab1_OnChange(tabObj, tabIndex)
      * </pre>
      * @param {tabObj} tabObj Mandatory IBTab Object
      * @param {int} tabIndex Mandatory ,Process Flag constant variable
      * @return void
      * @author 
      * @version 2009.04.17
      */ 
	function tab1_OnChange(tabObj, tabIndex) {
		/*if (tabEnableFlg[tabIndex] !=undefined 
				&& !tabEnableFlg[beforetab] && !tabEnableFlg[tabIndex]){			
			// When both of Previous and Current Tabs all Deactivated, Moves to First Tab.
			document.getElementById("t1frame").contentWindow.tabClearSheet();
			var objs=document.all.item("tabLayer");
			//objs[beforetab].style.display="none"; 
			for(var i = 0; i<objs.length; i++){
				if(i != tabIndex){
					objs[i].style.display="none";
				}
			}
			objs[0].style.display="inline";
			if (beforetab != 0){
				loadTabPage(0);
			}
			beforetab=0;
			return;
		}		
    	if (tabEnableFlg[tabIndex] !=undefined  
    			&& tabEnableFlg[beforetab]  && !tabEnableFlg[tabIndex]){
			tabObj.SetSelectedIndex(beforetab);
			return;
		}		  
		if (beforetab != tabIndex) {
			var objs=document.all.item("tabLayer");
			objs[tabIndex].style.display="inline";
			//objs[beforetab].style.display="none"; 
			for(var i = 0; i<objs.length; i++){
				if(i != tabIndex){
					objs[i].style.display="none";
					objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
				}
			}
		} */
		if (beforetab != tabIndex) {
			var objs=document.all.item("tabLayer");
			objs[tabIndex].style.display="inline";
			objs[beforetab].style.display="none";
			for(var i = 0; i<objs.length; i++){
				if(i != tabIndex){
					objs[i].style.display="none";
					objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
				}
			}
		}
		
		beforetab=tabIndex;
		loadTabPage(tabIndex);
	}
      /**
      * Activating selected tab in case of cliking Tab<br>
      * <br><b>Example :</b>
      * <pre>
      *     tab1_OnClick(tabObj, tabIndex)
      * </pre>
      * @param {tabObj} tabObj Mandatory IBTab Object
      * @param {int} tabIndex Mandatory ,Process Flag constant variable
      * @return void
      * @author 
      * @version 2009.04.17
      */           
//    function tab1_OnClick(tabObj,  tabIndex) {
//    	if (!tabEnableFlg[tabIndex]){
//			tabObj.SetSelectedIndex(beforetab);
//		}   
//    }        
      /**
      * Loading a screen to frame when changing Tab<br>
      * <br><b>Example :</b>
      * <pre>
      *     loadTabPage(tabIndex)
      * </pre>
      * @param {tabIndex} tabIndex Mandatory tab's serial no
      * @return void
      * @author 
      * @version 2009.04.17
      */   
      function loadTabPage(tabIndex) {
          if (tabIndex == null || tabIndex == "") {
              tabIndex=tabObjects[0].GetSelectedIndex();
          }
          var objTabWindow=document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow;
          if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
              switch (tabIndex) {
              case 0://DURATIOIN
              		sUrl="ESM_PRI_2041_01.do"; 
                  	break;
              case 1://Affiliate
	              sUrl="ESM_PRI_2041_07.do"; 
	              break;
	          case 2: //Dem/Det
	          	sUrl="ESM_PRI_2041_09.do"; 
	              break;                  
              case 3://Rate
                  sUrl="ESM_PRI_2041_05.do"; 
                  break;
              case 4://Location Group
                  sUrl="ESM_PRI_2041_04.do"; 
                  break;
              case 5:// Commodity Group
                  sUrl="ESM_PRI_2041_03.do"; 
                  break;
              case 6://Arbitrary
                  sUrl="ESM_PRI_2041_06.do"; 
              		break;
              case 7://Special Note
                  sUrl="ESM_PRI_2041_08.do"; 
                  break;
              }   
              objTabWindow.location.href=sUrl;
              return true;
          }
          var sheetObj=sheetObjects[0];
          var formObj=document.form;          
          var sRow=sheetObj.GetSelectRow();
          var sPropNo=formObj.prop_no.value;
          var sAmdtSeq=sheetObj.GetCellValue(sRow, "amdt_seq");
          var sSvcScpCd=sheetObj.GetCellValue(sRow, "svc_scp_cd");
          // When AMDT_SEQ is zero, Don't retrieve data.
          if (sAmdtSeq =="0") {
        	  sAmdtSeq=-1;
          }
          if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null ) {
        	  
        	  if (objTabWindow.tabLoadSheet) {
        		  objTabWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);
        	  }
        	  
//        	  for (var i=0; i < 500;i++){
//	      		  var sts=document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.loadFinishCheck();
//	      		  if (sts == true) break;
//	      	  }      	  	
//			  if (sts){
//				  document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);	
//			  }
          }
      }
      /**
      * Clearing all data of sheet which is loaded on Tab<br>
      * <br><b>Example :</b>
      * <pre>
      *     clearAllTabPages()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */         
      function clearAllTabPages() {
          for (var i=0; i < tabObjects[0].GetCount(); i++) {
        	  if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                  document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
              }
          }
      }
      /**
      * Clearing inputted fields on screen and a value of IBMulti Combo Object <br>
      * <br><b>Example :</b>
      * <pre>
      *     clearAllForms()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */        
      function clearAllForms(){          
          var formObj=document.form;          
          formObj.prop_no.value="";
          formObj.amdt_seq.value="";
          formObj.ctrt_eff_dt.value="";
          formObj.ctrt_exp_dt.value="";
//          comboObjects[0].SetSelectIndex(-1);
          comboObjects[0].RemoveAll();
          formObj.ctrt_pty_nm.value="";
          preRfaNo="";
      }      

      /**
      * event in case of changing selected item of IBMulti Combo<br>
      * Fill Scope name using Text field of Combo Item. <br> 
      * <br><b>Example :</b>
      * <pre>
      *    ssvc_scp_cd_OnChange(comboObj, code, text);
      * </pre>
      * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
      * @param   {string} code Mandatory code
      * @param   {string} text Mandatory ,Character on screen 
      * @return void
      * @author 
      * @version 2009.04.17
      */         
  	function svc_scp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
  		var formObj=document.form;
		formObj.svc_scp_nm.value=ComPriGetNameFromComboVal(comboObj, NewCod);
	}
    /**
    * event in case of pressing KeyBoard in IBMulti Comb<br>
    * changing focus to next object in case of exceeding designated length<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory Ascii code Value
    * @param   {string} Shift   Displaying whether Mandatory shift is keyup
    * @return void
    * @author 
    * @version 2009.04.17
    */   	
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt=comboObj.GetSelectText();
		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}

    /**
    * calling function in case of OnSelectCell event <br>
    * Changing tab's icon after loading term's data for selected scope to Frame<br>
    * <br><b>Example :</b>
    * <pre>
    *		sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} OldRow Mandatory ,previous selected cell's Row Index
    * @param {int} OldCol Mandatory Previous selected Cell's Column Index
    * @param {int} NewRow Mandatory ,current selected cell's Row Index
    * @param {int} NewCol Mandatory ,current selected cell's Column Index
    * @return void
    * @author 
    * @version 2009.04.17
    */   
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	var tabIdx=0;   	
    	try{
//    		tabObjects[0].SelectBackColor = "131,133,217";
    		if(OldRow != NewRow  ){
    			ComOpenWait(true); //->waiting->start
    			tabIdx=comApplyStyleProposalStatusSummary(sheetObj.GetCellValue(NewRow,"svc_scp_cd"),sheetObj.GetCellValue(NewRow,"amdt_seq"));
        		if (comboObjects[1].GetSelectText()!=""){
        			tabIdx=getTermTypeToTabIndex(comboObjects[1].GetSelectCode());
        		}   	
        		tabObjects[0].SetSelectedIndex(tabIdx);
        		tab1_OnChange(tabObjects[0], tabIdx);	
    			ComOpenWait(false); //->waiting->End
            }    	
    		
        } catch (e) {
           	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
         	ComOpenWait(false); //->waiting->End
         //	setAllTabEnable();
        }
    }	
    /**
    * Modifying Tab's icon accorting to added data and modification of each terms in main and scope<br>
    * <br><b>Example :</b>
    * <pre>
    *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
    * </pre>
    * @param   {string} svcScpCd selection   Scope code
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function comApplyStyleProposalStatusSummary(svcScpCd,amdtSeq){
   	 var formObj=document.form;
        formObj.f_cmd.value=SEARCH04;
        var sParam="prop_no="+formObj.prop_no.value+"&amdt_seq="+amdtSeq
        			+"&svc_scp_cd="+svcScpCd+"&f_cmd="+SEARCH04+"&term_type_cd="+term_type_cd.GetSelectCode();
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2041GS.do", sParam);
        var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|amdt_flg|dat_flg");
        var tabIdx="";
        var rValue=0;
        var enableIdx=new Array();
        var j=0;
        for (var i=0; arrText != null && i < arrText.length; i++){
           	 switch(arrText[i][0]){
   		     	 case '01':  //Duration
   		     	 	 tabIdx=0;
   		             break;
   		         case '05':  //Affiliate
   		         	 tabIdx=1;
   		         	if (svcScpCd !="") arrText[i][1]="0";
   		             break;  		             
   		         case '08':  //Dem/Det
   		         	 tabIdx=2;
   		         	 if (svcScpCd !="") arrText[i][1]="0";
   		             break; 	   		             
   		         case '71':  //  Rate                  
   		         	tabIdx=3;
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;  
   		         case '13':  //Group Location
   		             tabIdx=4;
   		         	 if (svcScpCd == "") arrText[i][1]="0";
   		             break;		             
   		         case '14':  //Group Commodity
   		             tabIdx=5;          
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;	
   		         case '51':  //Origin Arbitrary Destination Arbitrary 
   		             tabIdx=6;
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;	
   		         case '32':  //Special Note
   		             tabIdx=7;
   		         	if (svcScpCd == "") arrText[i][1]="0";      	
   		             break;	   	             
           	 	}
           	 if (amdtSeq =="0" ) {
           		 arrText[i][1]="0";
           	 }
           	 if (arrText[i][1] =="1"){        
           		 enableIdx[j++]=tabIdx;	
           		tabEnableFlg[tabIdx]=true;
           		tabObjects[0].SetTabDisable(tabIdx, false);
           	 }else{
           		 tabEnableFlg[tabIdx]=false;
           		 if(tabEnableFlg[tabIdx] == false) tabObjects[0].SetTabDisable(tabIdx, true);
           	 }
        }        
        if (enableIdx != null && enableIdx.length > 0){
       	 	rValue=enableIdx[0];
        }        
        for (var i=0; i < enableIdx.length;i++){
           	 if (rValue >= enableIdx[i]){
           		 rValue=enableIdx[i];
           	 }
        }
        return rValue;
    }
    /**
     * Decide Tab Activate/Deactivate. <br>
     * <br><b>Example :</b>
     * <pre>
     *    setTabEnable(idx, sw);
     * </pre>
     * @param   {int} idx Mandatory  tab's index
     * @param   {bool} sw Mandatory  true : Activate  false : Deactivate
     * @return void
     * @author 
     * @version 2009.04.17
     */  
//     function setTabEnable(idx, sw){
//    	 tabObjects[0].TabEnable(idx) = sw;
//     }
     function setTabEnable(idx, sw){
    	 if (sw){

    	 }else{

    	 }
     }         
     /**
      * After retrieve finished, modify the color of tabs activate/deactivate <br>
      * <br><b>Example :</b>
      * <pre>
      *    setAllTabEnable();
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */      
	function setAllTabEnable(){
		var firstTabFlg=false;
		var selectTab=0;
		for (var i=0; i < tabObjects[0].GetCount(); i++){
			if (tabEnableFlg[i]){				

			}else{				

			}
			if (!firstTabFlg && tabEnableFlg[i]){
				selectTab=i;
				firstTabFlg=true;
			}
		}
		tabObjects[0].SetSelectedIndex(selectTab);
	}        
     /**
      * Return Tab index of Term Type Combo code. <br>
      * <br><b>Example :</b>
      * <pre>
      *    getTermTypeToTabIndex(code);
      * </pre>
      * @param   {string} code Mandatory Term Type Code
      * @return   string tabIdx Term Type's Tab Index 
      * @author 
      * @version 2009.04.17
      */    
    function getTermTypeToTabIndex(code){
	   	var tabIdx=0; 
    	switch(code){
		 	 case '01':  //Duration,Scope Duration
		 	 	 tabIdx="0";
		         break;			         
		     case '05':	//Affiliate
		    	 tabIdx="1";
		    	 break;
		     case '07':  //dem/det
		         tabIdx="2";
		         break;	
		     case '15':  //rate
		         tabIdx="3";
		         break;	
		     case '12':  //Group Location
		         tabIdx="4";                 
		         break;	 
		     case '13': //Group Commodity
		         tabIdx="5";
		         break;	
		     case '14':  //Arbitrary 
		         tabIdx="6";          
		         break;
		     case '16':  //Special Note
		         tabIdx="7";
		         break;
	   	 }    	
	   	 return tabIdx;
    }