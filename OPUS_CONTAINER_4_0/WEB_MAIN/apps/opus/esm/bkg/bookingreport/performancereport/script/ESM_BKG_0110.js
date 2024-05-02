/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0110.js
*@FileTitle : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /* developer's work		*/
    // global variable
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var combo1=null;
 var comboCnt=0;
 var tabItem=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
     function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++]=sheet_obj;
     }
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
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         initCombo(ca_knd);
         initControl();
         document.form.cho_from_dt.value=getCalculatedDate(0,-1,0,"-");
 		 document.form.cho_to_dt.value=getCalculatedDate(0,0,0,"-"); 
 		 setDisable("0");
 		 for (var i=0 ; i < document.form.ca_rsn_cd.length ; i++){
 			 document.form.ca_rsn_cd[i].checked=false;
 		 }
 		 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
     }
        /**
       * handling when input searching condition 
       */
      function obj_KeyUp() {
 	     var formObject=document.form;
 	     var srcName=ComGetEvent("name");
 	     var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
 	     var srcValue=window.event.srcElement.getAttribute("value");
 	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
 	     	ComSetNextFocus();
 	     }
      }
     /**
       * dynamic loading the event of HTML Control in the page<br>
       * initializing IBSheet Object when this function is called from {@link #loadPage}<br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects order in the list
       */
      function initControl() {
      	var formObject=document.form;
      	//handling Axon 1. event catch
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- out of focus
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- keyboard
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
          //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
     /**
	 * Controlling keyboard in onkeypress event of HTML Control 
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //only number
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //number+"."
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //only alphabet, alphabet+number -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //only alphabet lower case, alphabet lower case+number -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //only alphabet upper case, alphabet upper case + number -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //only number (inteager, date, time)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
	 /**
      * initial setting combo value
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj) {
      	comboObj.SetMultiSelect(1);
      //no support[check again]CLT 	comboObj.UseCode=true;
      	//comboObj.LineColor = "#ffffff";
      	//comboObj.SetColAlign("left|left");
      	comboObj.SetMultiSeparator(",");
      	comboObj.SetDropHeight(150);
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
 				case "sheet1":      //sheet1 init
 				    with(sheetObj){
 			        
 			      var HeadTitle1="|Booking Office|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Total B/L|Total C/A|Ratio";
 			      var HeadTitle2="|Booking Office|A|B|C|D|E|F|G|H|I|J|K|M|C|G|A|R|Total B/L|Total C/A|Ratio";

 			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 			      var headers = [ { Text:HeadTitle1, Align:"Center"},
 			                  { Text:HeadTitle2, Align:"Center"} ];
 			      InitHeaders(headers, info);

 			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_a",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_b",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_c",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_d",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_e",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_f",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_g",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_h",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_i",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_j",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_k",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_m",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_c",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_g",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_a",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_r",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tot_bl",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tot_ca",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ratio",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
 			       
 			      InitColumns(cols);

 			      SetEditable(1);
 			     SetSheetHeight(320);
 			            }
                 break;
 				case "sheet2":      //sheet1 init
 				    with(sheetObj){
 			        
 			      var HeadTitle1="|Customer|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Total B/L|Total C/A|Ratio";
 			      var HeadTitle2="|Customer|A|B|C|D|E|F|G|H|I|J|K|M|C|G|A|O|Total B/L|Total C/A|Ratio";

 			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 			      var headers = [ { Text:HeadTitle1, Align:"Center"},
 			                  { Text:HeadTitle2, Align:"Center"} ];
 			      InitHeaders(headers, info);

 			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_a",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_b",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_c",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_d",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_e",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_f",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_g",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_h",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_i",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_j",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"kind_k",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_m",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_c",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_g",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_a",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rea_r",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tot_bl",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tot_ca",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ratio",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
 			       
 			      InitColumns(cols);

 			      SetEditable(1);
 			     SetSheetHeight(320);
 			            }


                 break;
         }
     }
   // Event handler processing by button name */
      function processButtonClick(){
           /***** using extra sheet valuable if there are more 2 sheets *****/
  	         var sheetObject1=sheetObjects[0];
  	         var sheetObject2=sheetObjects[1];
           /*******************************************************/
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
              switch(srcName) {
  		       case "btn_Retrieve":
  		    	  if (tabItem == 0){
  		    		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  		    	  }else{
  		    		  doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
  		    	  }
                break;
  		       case "btn_new":
  		    	   ComResetAll();
  		    	   changeTab("0");
  		    	   //sheetObject1.RemoveAll();
  		    	   //sheetObject2.RemoveAll();
               break;
  		       case "btn_excel":
  		    	 if(sheetObject1.RowCount() < 1){
  		    		 ComShowCodeMessage("COM132501");
		  		 }else{
		  			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(  		    	   sheetObject1), SheetDesign:1,Merge:1 });
  		    	   if (tabItem == 0){
  		    		   sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(  		    		   sheetObject1), SheetDesign:1,Merge:1 });
  		    	   }else{
  		    		   sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(  		    		   sheetObject2), SheetDesign:1,Merge:1 });
  		    	   }
		  		 }
   		    	   
               break;
  		       case "btn_print":
  								alert(srcName);
               break;
  		       case "btn_calendar":
 	  	           var cal=new ComCalendar();
 	  	           cal.setDisplayType('month');
 	  	           cal.select(formObject.cho_from_dt, 'yyyy-MM');
   			   break;
  		       case "btn_calendar1":
 	  	           var cal=new ComCalendarFromTo();
	               cal.select(formObject.cho_from_dt, formObject.cho_to_dt, 'yyyy-MM-dd');
  			   break;
  		       case "btn_calendar2":
 		    	   var cal=new ComCalendarFromTo();
  	               cal.select(formObject.bl_obrd_from_dt, formObject.bl_obrd_to_dt, 'yyyy-MM-dd');
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
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 						case IBSEARCH:      //retrieve
 							if(!validateForm(sheetObj,formObj,sAction)) return;
 							sheetObj.RemoveAll();
 							sheetObj.SetWaitImageVisible(0);
 							ComOpenWait(true);
	 						formObj.f_cmd.value=SEARCH;   
 	 						sheetObj.DoSearch("ESM_BKG_0110GS.do",FormQueryString(formObj) );
	 						ComOpenWait(false);	
 						break;
 						case COMMAND01:      // INIT
	 						formObj.f_cmd.value=INIT;   
  							var sXml=sheetObj.GetSearchData("ESM_BKG_0110GS.do", FormQueryString(formObj));
 							//ComXml2ComboItem(sXml, formObj.ca_knd, "val", "val|name");
 							ComBkgXml2ComboItem(sXml, ca_knd, "val", "name");
 							//comboObjects[0].Text2 = "A,B,C,D,E,F,G,H,I,J,K";
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
      * setting Tab 
      * setting item of Tab
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt=0 ;
                     InsertItem( "By Office" , "");
                     InsertItem( "By Customer" , "");
                 }
                 break;
         }
     }
     /**
      * Event when clicking Tab
      * activating selected tab items
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
         objs[nItem].style.display="Inline";
         objs[beforetab].style.display="none";
         tabItem=nItem;
         if (nItem == 0){
        	 document.form.tab_tp[1].checked=true;
         }else{
        	 document.form.tab_tp[0].checked=true;
         }
         setDisable(nItem);
         //--------------- important --------------------------//
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab=nItem;
     } 
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 if (cho_from_dt.value == '' || cho_to_dt.value == ''){
        		 ComShowCodeMessage("BKG00499");//Period are mandatory items.
        		 cho_from_dt.focus();
        		 return false;
        	 }
        	 if (ComGetDaysBetween(cho_from_dt.value, cho_to_dt.value) > 31){
        		 ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
        		 cho_to_dt.focus();
        		 return false;
        	 }
        	 var reason="";
        	 var idx=0;
        	 for (var i=0 ; i < ca_rsn_cd.length ; i++){
        		 if (ca_rsn_cd[i].checked == true){
        			 if (idx == 0){
        				 reason=ca_rsn_cd[i].value;
        			 }else{
        				 reason=reason + "," + ca_rsn_cd[i].value;
        			 }
        			 idx++;
        		 }
        	 }
        	 rea_val.value=reason;
         }
         return true;
     }
      /**
       * change tab
       */
     function changeTab(nItem){
    	 tabObjects[0].SetSelectedIndex(nItem);
    	 setDisable(nItem);
     }
    // Event which is called after searching
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
  	{
  		with(sheetObj)
  		{
  			var lastTot=GetCellValue(LastRow(), LastCol());
  			SetCellValue(LastRow(), LastCol(),lastTot / RowCount(),0);
  		}
  	}
    // Event which is called after searching
  	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
  	{
  		with(sheetObj)
  		{
  			var lastTot=GetCellValue(LastRow(), LastCol());
  			SetCellValue(LastRow(), LastCol(),lastTot / RowCount(),0);
  		}
  	}
  	// Revenue Setting
  	function changeRat(idx){
  		formObj=document.form;
  		if (idx == 0){
  			if (formObj.rat_flg[0].checked == true){
  				formObj.rat_flg[0].checked=true;
	  			formObj.rat_flg[1].checked=false;
  			}
  		}else{
  			if (formObj.rat_flg[1].checked == true){
  				formObj.rat_flg[0].checked=false;
	  			formObj.rat_flg[1].checked=true;
  			}
  		}
  	}
  	function setDisable(nItem){
  		var formObj=document.form;
  		if (nItem == "0"){
  			formObj.cust_tp[0].disabled=true;
  			formObj.cust_tp[1].disabled=true;
  			formObj.cust_nm.disabled=true;
  			formObj.cust_nm.style.background="#E8EFF9";
  			//formObj.bkg_ofc_cd.disabled = false;
  			//formObj.bkg_ofc_cd.style.background = "#FFFFFF";     
  		}else{
  			formObj.cust_tp[0].disabled=false;
  			formObj.cust_tp[1].disabled=false;
  			formObj.cust_nm.disabled=false;
  			formObj.cust_nm.style.background="#FFFFFF";
  			//formObj.bkg_ofc_cd.disabled = true;
  			//formObj.bkg_ofc_cd.style.background = "#E8EFF9";   
  		}
  	}
     /**
      * function of calculating date
      */
     function getCalculatedDate(iYear,iMonth,iDay,seperator)
     {
     	// getting object of current date.
     	var gdCurDate=new Date();
     	//calculating date
     	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
     	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
     	gdCurDate.setDate(gdCurDate.getDate() + iDay);
     	//getting actual valuable (year, month, date) 
     	var giYear=gdCurDate.getFullYear();
     	var giMonth=gdCurDate.getMonth()+1;
     	var giDay=gdCurDate.getDate();
     	//checking digit 
     	giMonth="0" + giMonth;
     	giMonth=giMonth.substring(giMonth.length-2,giMonth.length);
     	giDay="0" + giDay;
     	giDay=giDay.substring(giDay.length-2,giDay.length);
     	//alert(giYear + seperator + giMonth + seperator + giDay);
     	//checking display form
     	return giYear + seperator + giMonth + seperator + giDay;	
     }
	/* the end of developer's work */
