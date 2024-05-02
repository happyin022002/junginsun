/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057.js
 *@FileTitle  : Amendment History Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ESM_PRI_0057 : business script for ESM_PRI_0057 
	 */

 	// global variables
	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var beforetab=1; 
	 var beforeChk=0; 
	 var sheetObjects=new Array();
	 var sheetCnt=0; 
	 var comboObjects=new Array();
	 var comboCnt=0; 
	 var preScNo="";
	 var sUrl="";
	 var tabDataExist=new Array();
	 tabDataExist[0]=0;//rate
	 tabDataExist[1]=0;//note
	 var tabEnableFlg=new Array();
	 var TAB_SELECT_COLOR="131,133,217"; 
	 var TAB_TRUE_COLOR="206,220,246";
	 var TAB_FALSE_COLOR="192,192,192";
	 var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif"; 
	 var ICON_URL_AMEND="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon4.gif";
	 var termLoad=false;
	 var image2 = "img/blank.gif";
	 var image0 = "img/tab_icon1.gif";
	 var image1 = "img/tab_icon2.gif";
	 //Event handler processing by button click event */
 	document.onclick=processButtonClick;
 	
 	/**
 	 * Event handler processing by button name  <br>
 	 */
 	function processButtonClick(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
	  	try {
	  		var srcName=ComGetEvent("name");
	          switch(srcName) {
	          case "btn_retrieve":  
				if (formObj.sc_no2.value ==""){
					ComShowCodeMessage("PRI01061");
					if (formObj.sc_no2.value ==""){
						formObj.sc_no2.focus();
					}
					return;
				}
	         	 searchInitSheet(true);          
	         	 sheetObj.RemoveAll();
	         	 doActionIBSheet(sheetObj,formObj,IBSEARCH);       
	              break;
	          case "btn_new":
	         	 formObj.sc_no2.value="";
	         	 clearAllForms();
	         	 sheetObj.RemoveAll();
	         	 comboObjects[0].RemoveAll();
	         	 clearAllTabPages();
	         	 tabObjects[0].SetSelectedIndex(0);
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
  	* adding process for list in case of needing batch processing with other items  <br>
  	* defining list on the top of source <br>
  	*/ 
 	function setSheetObject(sheet_obj){
 		sheetObjects[sheetCnt++]=sheet_obj;
 	}
  	/**
   	* registering IBTab Object as array <br>
   	* adding process for list in case of needing batch processing with other items  <br>
   	* defining list on the top of source <br>
   	*/ 
  	function setTabObject(tab_obj) {
  		tabObjects[tabCnt++]=tab_obj;
  	}
  	/**
  	 * registering IBMulti Combo Object as array <br>
  	 * adding process for list in case of needing batch processing with other items  <br>
  	 * defining list on the top of source <br>
  	 */    
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}      
    /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
     function loadPage() {
         for(var i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         for(var k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         for(var k=0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         initControl();
         initIBComboItem();  
    	 var form=document.form;
         if("null" != form.sc_no_0062.value && null != form.sc_no_0062.value && "" != form.sc_no_0062.value) {
        	var scNo=form.sc_no_0062.value;
         	form.sc_no2.value=scNo;
         	form.sc_no2.focus();
         	form.amdt_seq.focus();
         }
         
         //2015.05.27 ICH
 		 tab1.SetTabHidden(12, true);
         
     }
     /**
      * setting IBMulti Combo <br>
      */     
      function initIBComboItem() {
          var formObj=document.form;
          ComPriTextCode2ComboItem(termTypeComboValue,termTypeComboText , getComboObject(comboObjects, 'term_type_cd') ,"|","\t" );
      }
      /**
       * handling Axon event<br>
       */        
     function initControl() {
          //handling Axon event        
    	  axon_event.addListenerForm('blur', 'obj_blur', document.form);
    	  axon_event.addListenerForm  ('click', 'obj_OnClick', form);
    }      
   
     /**
     * handling Onbeforedeactivate events <br>
     */       
     function obj_blur() {
         var formObj=document.form;
         var sheetObj=sheetObjects[0]; 
         var eleName=ComGetEvent("name");
         switch(eleName){
             case "sc_no2":
            	 if (formObj.sc_no2.value != ""){
            		 //if (preScNo != formObj.sc_no2.value){
            		 if("null" != form.sc_no_0062.value && null != form.sc_no_0062.value && "" != form.sc_no_0062.value && preScNo != formObj.sc_no2.value) {
            			 preScNo=formObj.sc_no2.value;
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);	
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH);            			 
            		 } else {
            			 preScNo=formObj.sc_no2.value;
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
            		 }            		 
            	 }            	 
                 break;                       
             default:            	
            	 break;     
         }
         preScNo=formObj.sc_no2.value;
     }    
    
     /**
      * Handling sheet process <br>
      */  
      function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
	  			case IBSEARCH_ASYNC01:     
	  				ComOpenWait(true); //->waiting->start
	  				formObj.f_cmd.value=SEARCH01;
	  				var param=FormQueryString(formObj)+"&sc_no="+formObj.sc_no2.value;
	  				var sXml=sheetObj.GetSearchData("ESM_PRI_0057GS.do" , param);
	  			 	clearAllForms();
	  			 	comboObjects[0].RemoveAll();
	  				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm"); 				
	  				comboObjects[0].InsertItem(0, "||", "X");
	  				comboObjects[0].SetSelectCode("X");
	 				if (ComGetEtcData(sXml,"prop_no") != undefined){
	 					formObj.prop_no.value=ComGetEtcData(sXml,"prop_no");
	 				}else{
	 			 		formObj.sc_no2.value="";
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
	 				if (ComGetEtcData(sXml,"lgcy_if_flg") != undefined){
	 					formObj.lgcy_if_flg.value=ComGetEtcData(sXml,"lgcy_if_flg");
	 				}
	                 break;
	  			case IBSEARCH:      
	  				ComOpenWait(true); //->waiting->start
	  				formObj.f_cmd.value=SEARCH02; 				
	  				clearAllTabPages();
	  				if(comboObjects[0].GetSelectCode() == ""){
	  					comboObjects[0].SetSelectCode("X");
	  				}
	  				var param=FormQueryString(formObj)+"&conv_flg="+getConversionValue();
	 				var sXml=sheetObj.GetSearchData("ESM_PRI_0057GS.do" , param);
	 			 	sheetObj.LoadSearchData(sXml,{Sync:1} );
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
         }
     }   
      /**
       * setting sheet initial values and header <br>
       * adding case as numbers of counting sheets <br>
       */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {			
			case "sheet1":
				with(sheetObj){
				var HeadTitle1="|Seq.|AMD No.|SVC Scope|Filed Date|Effective Date|Expiry Date|Creation Date|Conversion Update|prop_no|pre_conv_cfm_flg|lgcy_if_flg";
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				  {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				  {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"file_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Date",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Image",     Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"conv_cfm_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Text",      Hidden:1, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"pre_conv_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"lgcy_if_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 
				InitColumns(cols);
				SetSheetHeight(162);
				SetEditable(0);
				SetImageList(2,image2);
				SetImageList(0,image0);
				SetImageList(1,image1);
				SetWaitImageVisible(0);
				SetColHidden("conv_cfm_flg",1);
				}
			break;
         }
     }
     /**
      * initializing Tab setting Tab items  <br>
      */   
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Duration", "");
					InsertItem( "MQC"  , "");
					InsertItem( "Cust. Type" , "");
					InsertItem( "Contract Party" , "");
					InsertItem( "Ori/Dest", "");
					InsertItem( "G.Location", "");
					InsertItem( "G.CMDT", "");
					InsertItem( "Arbitrary", "");
					InsertItem( "Rate" , "");
					InsertItem( "Special Note" , "");
					InsertItem( "Affiliate", "");
					InsertItem( "L/Agent", "");
					InsertItem( "IHC" , "");
					InsertItem( "GOH" , "");
					InsertItem( "Boiler Plate" , "");
                 }
              break;
          }
          tabObjects[0].SetSelectedIndex(0);
     }
     /**
      * initializing Combo, Combo items  <br>
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
      var preTab=0;
      /**
       * activating selected tab items when clicking Tab <br>
       */ 
	function tab1_OnChange(tabObj, tabIndex) {	   
//		if (tabEnableFlg[tabIndex] !=undefined 
//				&& !tabEnableFlg[beforetab] && !tabEnableFlg[tabIndex]){
//			if (termLoad == true){
//				document.getElementById("t1frame").contentWindow.tabClearSheet();
//			}
//			var objs=document.all.item("tabLayer");
//			objs[beforetab].style.display="none"; 
//			objs[0].style.display="inline";			
//			if (beforetab != 0){
//				loadTabPage(0);
//			}
//			beforetab=0;
//			return;
//		}
//		if (tabEnableFlg[tabIndex] !=undefined 
//				&& tabEnableFlg[beforetab] && !tabEnableFlg[tabIndex]){
//			tabObj.SetSelectedIndex(beforetab);
//			return;
//		}	
//		if (beforetab != tabIndex) {
//			var objs=document.all.item("tabLayer");
//			objs[tabIndex].style.display="inline";
//			//objs[beforetab].style.display="none";   
//			for(var i = 0; i<objs.length; i++){
//				if(i != tabIndex){
//					objs[i].style.display="none";
//					objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
//				}
//			}
//		}
		var objs=document.all.item("tabLayer");
		objs[tabIndex].style.display="Inline";
		for(var i = 0; i<objs.length; i++){
			if(i != tabIndex){
				objs[i].style.display="none";
				objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
			}
		}
		beforetab=tabIndex;
		loadTabPage(tabIndex);
	}
       /**
        * activating selected tab items when clicking Tab <br>
        */           
      function tab1_OnClick(tabObj,  tabIndex) {
        	if (!tabEnableFlg[tabIndex]){
  			  tabObj.SetSelectedIndex(beforetab);
  		  }
      }         
      /**
       * Frame loading when changing Tab <br>
       */            
      function loadTabPage(tabIndex) {    	  
          if (tabIndex == null || tabIndex == -1) {
              tabIndex=tabObjects[0].GetSelectedIndex();
          }
          var objTabWindow=document.getElementById("t" + (parseInt(tabIndex) + 1) + "frame").contentWindow;
          if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
              switch (tabIndex) {
              case 0://DURATIOIN
              		sUrl="ESM_PRI_0057_01.do"; 
                  break;
              case 1://MQC
                  sUrl="ESM_PRI_0057_02.do"; 
                  break;
              case 2://CUST TYPE
                  sUrl="ESM_PRI_0057_17.do"; 
                  break;
              case 3:// CONTRACT PARTY
                  sUrl="ESM_PRI_0057_18.do"; 
                  break;
              case 4://ORG/DEST
                  sUrl="ESM_PRI_0057_04.do"; 
              		break;
              case 5://G LOCATION
                  sUrl="ESM_PRI_0057_14.do"; 
                  break;
              case 6://G CDMT
                  sUrl="ESM_PRI_0057_05.do"; 
                  break;
              case 7: //ARB
              	sUrl="ESM_PRI_0057_07.do"; 
                  break;
              case 8://RATE
                  sUrl="ESM_PRI_0057_06.do"; 
                  break;
              case 9://SPECIAL NOTE
                  sUrl="ESM_PRI_0057_12.do"; 
                  break;
              case 10://AFFIL
                  sUrl="ESM_PRI_0057_09.do"; 
                  break;
              case 11://L AGENT
                  sUrl="ESM_PRI_0057_10.do"; 
                  break;
              case 12://IHC
              	sUrl="ESM_PRI_0057_15.do"; 
                  break;
              case 13://GOH
              	sUrl="ESM_PRI_0057_08.do";                
                  break;
              case 14://BOILER
                  sUrl="ESM_PRI_0057_13.do";                   
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
          var sConChk="0";
          var sLgcyIfFlg=sheetObj.GetCellValue(sRow, "lgcy_if_flg");
          if (formObj.con_flg.checked == true){
        	  sConChk="1";
          }
          if (sAmdtSeq =="0") {
        	  if (tabIndex != 8 && tabIndex != 9){
        		  sAmdtSeq=-1;
        	  }
          }
          if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null ) {		
        	  for (var i=0; i < 500;i++){
        		  var sts=document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.loadFinishCheck();
        		  if (sts == true) break;
        	  }       	  	
        	  if (sts){
        		  document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg);	
        		  if (tabIndex == 0){
					termLoad=true;
        		  }
        	  }				
          }     
      }
      /**
       * initializing sheet data in tabs<br>
       */          
      function clearAllTabPages() {
    	  for (var i=0; i < tabObjects[0].GetCount(); i++) {
    		  if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                  document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
              }
          }
      }
      /**
       * initialiaing IBMulti Combo Object and all items on screen<br>
       */            
      function clearAllForms(){          
          var formObj=document.form;
          formObj.prop_no.value="";
          formObj.amdt_seq.value="";
          formObj.ctrt_eff_dt.value="";
          formObj.ctrt_exp_dt.value="";
          comboObjects[0].SetSelectIndex(0);
          formObj.ctrt_pty_nm.value="";
          comboObjects[1].SetSelectIndex(0);
          formObj.con_flg.checked=false;
          formObj.lgcy_if_flg.value="";
      }      
      /**
      *  setting all tab's ativation when retrieving<br>
      */       
      function searchInitSheet(sw){
    	  if (!sw) tabObjects[0].SetSelectedIndex(0 );
    	  for (var i=0; i < tabObjects[0].GetCount(); i++){
    		  setTabEnable(i, sw)
    	  }
      }
      /**
       * event handler when changing seleted item in IBMulti Combo<br>
       */       
  	function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
    	var formObj=document.form;
    	formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
    	selectedGlineSeq=null;
    }
  	
    /**
    * calling Event when keyboard press data IBMulti Combo
    */    	
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt=comboObj.GetSelectText();
		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
    /**
    * calling Event when deleting all items in IBMulti Combo<br>
    */ 	
	function svc_scp_cd_OnClear(comboObj) {
		var formObject=document.form;
		formObject.svc_scp_nm.value="";
		//comboObj.SetSelectIndex(0);
		comboObjects[0].SetSelectIndex(0);
	}
    /**
    * calling the function when IBMulti Combo lost the focus<br>
    * setting Combo text in Html Object <br>
    */ 	
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj=document.form;		
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null) {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
			}
		}
		if (code == -1){
			formObj.svc_scp_nm.value="";
		}
	}

    /**
     * calling function when occurring OnSelectCell Event <br>
     */   	
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	 try{
    		 //ComOpenWait(true); //->waiting->start
    		 //setAllTabEnable(true);
    		 var tabIdx=0;
        	 //var colName=sheetObj.ColSaveName(NewCol);
        	 if(OldRow != NewRow || beforeChk != getConversionValue() ){
        		var svcScpCd="";
        		if (sheetObj.GetCellValue(NewRow,"svc_scp_cd") !=""){
        			svcScpCd=sheetObj.GetCellValue(NewRow,"svc_scp_cd");
        		} 
        		tabIdx=comApplyStyleProposalStatusSummary(svcScpCd,sheetObj.GetCellValue(NewRow,"amdt_seq"));
        		if (!ComIsNull(comboObjects[1].GetSelectText()) && !ComIsEmpty(comboObjects[1].GetSelectText())){
        			tabIdx=getTermTypeToTabIndex(comboObjects[1].GetSelectCode());
        		}
        		tabObjects[0].SetSelectedIndex(tabIdx);
        		tab1_OnChange(tabObjects[0], tabIdx);	
             }
        	 //beforeChk=getConversionValue();    
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
         	setAllTabEnable();
         }
    }	
	/* function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	    	var tabIdx=0;   	
	    	try{
//	    		tabObjects[0].SelectBackColor = "131,133,217";
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
	         setAllTabEnable();
	        }
	    }	*/
     /**
      * calling function when occurring OnSelectCell Event <br>
      * handlign Conversion Update <br>
      */   	
     function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y)  {   
     	var tabIdx=0;
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
     	var colName=sheetObj.ColSaveName(Col);
     	var formObj=document.form;
        var conAuth=true;
      	if (colName == "conv_cfm_flg" 
      		&& ( sheetObj.GetCellValue(Row, "pre_conv_cfm_flg")=="Y" || sheetObj.GetCellValue(Row, "amdt_seq")=="0" )
      		&& sheetObj.GetCellValue(Row,Col)==image0 && sheetObj.GetCellValue(Row, "svc_scp_cd") =="" && conAuth	){
             if (!ComShowCodeConfirm("PRI01118")){
             	return false;
             }        
             var propNo=sheetObj.GetCellValue(Row, "prop_no");
             var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
//             sheetObj.CellValue(Row, "ibflag") = "U";
             sheetObj.SetRowStatus(Row,"U");
             doConversionUpdate(propNo,amdtSeq,Row,Col);             
     	} 
     }
    /**
    * changing tab's icon whend changing main, scope's terms state, adding data <br>
    */    
    function comApplyStyleProposalStatusSummary(svcScpCd,amdtSeq){
       	var formObj=document.form;
        formObj.f_cmd.value=SEARCH04;
        var lgcyIfFlg=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "lgcy_if_flg");
        var sParam="prop_no="+formObj.prop_no.value+"&amdt_seq="+amdtSeq
        			+"&svc_scp_cd="+svcScpCd+"&f_cmd="+SEARCH04
        			+"&term_type_cd="+term_type_cd.GetSelectCode()
        			+"&lgcy_if_flg="+lgcyIfFlg;
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0057GS.do", sParam);
        var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|amdt_flg|dat_flg");
        var tabIdx="";
        var conValue=getConversionValue();
        var rValue=0;
        var enableIdx=new Array();
        var j=0;
        for (var i=0; arrText != null && i < arrText.length; i++){
           	 switch(arrText[i][0]){
   		     	 case '01':  //Duration,Scope Duration
   		     	 	 tabIdx=0;
   		             break;
//   		         case '11':  //Scope  DURATION
//   		             tabIdx = 0;
//   		             break;			             
   		         case '02':  //MQC,Scope MQC
   		         	 tabIdx=1;
   		             break;  
//   		         case '12':  //Scope MQC
//   		             tabIdx = 1;                 
//   		             break;					             
   		         case '07':  //Customer Type
   		         	 tabIdx=2;
   		         	if (svcScpCd !="") arrText[i][1]="0";
   		             break;  		             
   		         case '04':  //Contract Party
   		         	 tabIdx=3;
   		         	 if (svcScpCd !="") arrText[i][1]="0";
   		             break;      
   		         case '41':  //Origin//Destination
   		             tabIdx=4;
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;			             
   		         case '13':  //Group Location
   		             tabIdx=5;
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;		             
   		         case '14':  //Group Commodity
   		             tabIdx=6;          
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;	
   		         case '51':  //Origin Arbitrary Destination Arbitrary 
   		             tabIdx=7;
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;				        	 
   		         case '71':  //General,Special  Rate                  
   		         	tabIdx=8;
   		         	if (svcScpCd == ""){
   		         		arrText[i][1]="0";
   		         		tabDataExist[0]=arrText[i][1];
   		         	}else{
   		         		if (conValue == "1") {
   		         			arrText[i][1]="1";
   		         			tabDataExist[0]=arrText[i][1];
   		         		}else{
   		         			if (amdtSeq =="0") arrText[i][1]="0";
   		         			tabDataExist[0]=arrText[i][1];
   		         		}
   		         	}	
   		             break;  	
   		         case '32':  //Special Note
   		             tabIdx=9;
   		         	if (svcScpCd == "") {
   		         		arrText[i][1]=0;
   		         		tabDataExist[1]=arrText[i][1];
   		         	}else{
   		         		if (conValue == "1") {
   		         			arrText[i][1]=arrText[i][2]
   		         			tabDataExist[1]=arrText[i][1];
   		         		}else{
   		         			if (amdtSeq =="0") arrText[i][1]="0";
   		         			tabDataExist[1]=arrText[i][1];
   		         		}	   		         	
   		         	}		   
   		             break;
   		         case '05':	//Affiliate
   		        	 tabIdx=10;
   		         	if (svcScpCd !="") arrText[i][1]="0";
   		        	 break;   	
   		         case '15':  //Loading Agent
   		             tabIdx=11;   		      
   		         	if (svcScpCd == "") arrText[i][1]="0";
   		             break;	
   		         case '61':  //Origin,Destination IHC
   		             tabIdx=12;
   		         	 if (svcScpCd == "") arrText[i][1]="0";
   		             break;			             
   		         case '16':  //GOH Charge
   		             tabIdx=13;
   		         	 if (svcScpCd == "") arrText[i][1]="0";
   		             break; 
   		     	 case '06':  //Boiler plate
   		     	 	if (svcScpCd !="") arrText[i][1]="0";
   		     	 	 tabIdx=14;
   		             break;	   	             
           	 	}
           	 if (amdtSeq =="0" && tabIdx != 9 && tabIdx != 8) {
           		 arrText[i][1]="0";
           	 }
           	 if (arrText[i][1] =="1"){        
           		 enableIdx[j++]=tabIdx;
           		 tabEnableFlg[tabIdx]=true;
           		 tab1.SetTabDisable(tabIdx, false);
           	 }else{
           		 tabEnableFlg[tabIdx]=false;
           		 if(tabEnableFlg[tabIdx] == false) tab1.SetTabDisable(tabIdx, true);
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
    * changing tab's activate/deactivate color <br>
    */      
     function setTabEnable(idx, sw){
    	 if (sw){
    		 tab1.SetTabDisable(idx, false);
    	 }else{
    		 tab1.SetTabDisable(idx, true);
    	 }
     }
    /**
    * changing tab's activate/deactivate color after retreiveing<br>
    */      
//     function setAllTabEnable(){
//    	var firstTabFlg = false;
//    	var selectTab = 0;
//    	for (var i = 0; i < tabObjects[0].GetCount(); i++){
//    		 tabObjects[0].TabEnable(i) = tabEnableFlg[i];
//    		 if (!firstTabFlg && tabEnableFlg[i]){
//    			 selectTab = i;
//    			 firstTabFlg = true;
//    		 }
//    	}
//    	tabObjects[0].SelectedIndex = selectTab;
//     }    
    function setAllTabEnable(noData){
    	if (noData){
          	for (var i=0; i < tabObjects[0].GetCount(); i++){
          		tabEnableFlg[i]=false;
          		 if (tabEnableFlg[i]){
          			tabObjects[0].SetTabDisable(i, false);
         		 }else{
         			tabObjects[0].SetTabDisable(i, true);
         		 }
         	}
          	tabObjects[0].SetSelectedIndex(0);
    	}else{
        	var firstTabFlg=false;
          	var selectTab=0;
          	for (var i=0; i < tabObjects[0].GetCount(); i++){
          		 if (tabEnableFlg[i]){
          			tabObjects[0].SetTabDisable(i, false);
          		 }else{
          			 tabObjects[0].SetTabDisable(i, true);
          		 }
          		 if (!firstTabFlg && tabEnableFlg[i]){
          			 selectTab=i;
          			 firstTabFlg=true;
          		 }
          	}
          	tabObjects[0].SetSelectedIndex(selectTab);
    	}
    }         
      /**
       * setting Rate,Special Note Tab to activate mode when selecting Conversion Check Box   <br>
       */        
     function obj_OnClick(){
     	var sheetObj=sheetObjects[0];
     	var formObj=document.form;
     	if (ComGetEvent("name") == "con_flg" ) {     
     		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")!=""){
         		if (getConversionValue() == "1"){
					setTabEnable(8, true);	//rate
					setTabEnable(9, true);	//special note 					
         		}else{
					if (tabDataExist[0] != 1) setTabEnable(8, false);
					if (tabDataExist[1] != 1) setTabEnable(9, false);
         		}
     		}
     		if (getConversionValue() == "1"){
     			sheetObj.SetColHidden("conv_cfm_flg",0);
     		}else{
     			sheetObj.SetColHidden("conv_cfm_flg",1);
     		}  
     		sheetObj.FitColWidth("10|10|10|10|10|10|10|10|10|3|3|4");
     		comboObjects[1].SetSelectIndex(0);
     		//doActionIBSheet(sheetObj,formObj,IBSEARCH);
     	}
     }     
     /**
      * calculating Conversion Check Box value<br>
      */       
    function getConversionValue(){
    	var formObj=document.form;
    	var rValue="0";
    	if (formObj.con_flg.checked == true){
    		rValue="1";
    	}
    	return rValue;
    }
    
    /**
     * Conversion Check Box checked false when selecting Term Type <br>
     */    
    function term_type_cd_OnChange(comboObj, code, text) {
        var formObj=document.form;
        if (text !=""){
        	formObj.con_flg.checked=false;
        }
    } 
    
    /**
     * returning  Tab Index by Term Type Combo code <br>
     */      
    function getTermTypeToTabIndex(code){
	   	var tabIdx=0; 
    	switch(code){
		 	 case '01':  //Duration,Scope Duration
		 	 	 tabIdx="0";
		         break;
		     case '02':  //MQC,Scope MQC
		     	 tabIdx="1";
		         break;  
		     case '03':  //Contract Party
		     	 tabIdx="3";
		         break;  		    
		     case '04':  //Customer Type
		     	 tabIdx="2";
		         break;				         
		     case '05':	//Affiliate
		    	 tabIdx="10";
		    	 break;
		 	 case '06':  //Boiler plate
		 	 	 tabIdx="14";
		         break;
		     case '11':  //ori/dest
		         tabIdx="4";
		         break;		             
		     case '12':  //Group Location
		         tabIdx="5";                 
		         break;				        	 
		     case '13': //Group Commodity
		         tabIdx="6";
		         break;		             
		     case '14':  //Arbitrary 
		         tabIdx="7";          
		         break;		
		     case '15':  //rate
		         tabIdx="8";
		         break;			         
		     case '16':  //Special Note
		         tabIdx="9";
		         break;           
		     case '17':  //loading agent
		         tabIdx="11";
		         break;
		     case '18':  //ihc
		         tabIdx="12";
		         break;	
		     case '19':  //goh
		         tabIdx="13";
		         break;		             
	   	 }    	
	   	 return tabIdx;
    }
/**
 * returning duration's exp_dt  <br>
 */
function getCtrtExpDate() {
	var formObj=document.form;
	var ctrtExpDt=formObj.ctrt_exp_dt.value;
	ctrtExpDt=ctrtExpDt.replace(/-/gi, "");
	return ctrtExpDt;
}
 /**
  * Updating Conversion  <br>
  */
 function doConversionUpdate(propNo, amdtSeq, Row, Col) {
	  try{
		  ComOpenWait(true); //->waiting->start
		  var sheetObj=sheetObjects[0];	  
		  var sParam="f_cmd="+MULTI+"&prop_no="+propNo+"&amdt_seq="+amdtSeq;
		  var sXml=sheetObj.GetSaveData("ESM_PRI_0057GS.do", sParam);
		  sheetObj.LoadSaveData(sXml);
		  var saveOk=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	  	  if(saveOk == "S") {	  		
	  		 sheetObj.SetCellValue(Row, "conv_cfm_flg","1");
//	  		 sheetObj.CellValue(Row, "ibflag") = "R";	
	  		sheetObj.SetRowStatus(Row,"R");
	  		 for (var i=Row ; i >= 1; i--){
	  			 if (sheetObj.GetCellValue(i, "amdt_seq") == ComParseInt(amdtSeq) + 1 && sheetObj.GetCellValue(i, "svc_scp_cd")=="" ){
	  				 sheetObj.SetCellValue(i, "pre_conv_cfm_flg","Y");
	  				 break;
	  			 }
	  		 }
		 }		  
      } catch (e) {
        	if (e == "[object Error]") {
              ComShowMessage(OBJECT_ERROR);
          } else {
              ComShowMessage(e.message);
          }
      }finally{
      	ComOpenWait(false); //->waiting->End
      }
 } 