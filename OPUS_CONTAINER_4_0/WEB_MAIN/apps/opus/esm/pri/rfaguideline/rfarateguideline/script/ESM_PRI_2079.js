/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2079.js
*@FileTitle  : RFA Guideline Inquiry - Rate (Route Point) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 // global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var currentSheet=1; 
 var enableFlag=true;
 //Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];          
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
            switch(srcName) {
	            case "btn_Close":
	            	ComClosePopup(); 
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
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
     function loadPage() {    	 
    	 initControl();
    	 setSearchCondition()
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].SetWaitImageVisible(0);
             ComEndConfigSheet(sheetObjects[i]);
         }         
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);                  
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
               var HeadTitle="|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",     Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(0);
               SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
               
               SetShowButtonImage(0);
               SetSheetHeight(140);
               }
               break;
             case "sheet2":	// Route Point Origin sheet
            	 with(sheetObj){
               var HeadTitle="|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetSheetHeight(100);
                     }
               break;
             case "sheet3":	// Route Point Origin Via sheet
            	 with(sheetObj){
               var HeadTitle="|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetSheetHeight(100);
                     }
               break;
             case "sheet4":	// Route Point Destination Via sheet
            	 with(sheetObj){
               var HeadTitle="|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetSheetHeight(100);
                     }
               break;
             case "sheet5":	// Route Point Destination sheet
            	 with(sheetObj){
               var HeadTitle="|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Term|Trans Mode";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetSheetHeight(100);
                     }
               break;            
         }
     }
     /**
     * Handling sheet process <br>
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
        	 var objEvt = ComGetEvent();
             if (ComGetEvent() == null || $(objEvt).attr('suppressWait') != "Y") {             
                 ComOpenWait(true);
             }
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 			case IBCLEAR: // when screen loading 
	 				var sXml="";
	 				var radioObj=formObj.rt_pnt;
					//comon - type
	 				sheetObj.SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1], ComboCode:LOCATION_TYPE2[0]} );
	         		formObj.f_cmd.value=COMMAND13;
	         		//comon term, trans mode
	         		var param="";
	         		param="CD02070:N";//Origin
					if(radioObj[3].checked == true){
						param="CD02071:N";  //Destination
					}
					param += ":CD01720:N"
	         		formObj.cd.value=param; 
//parameter changed[check again]CLT
					sXml=sheetObj.GetSearchData("PRICommonGS.do" , FormQueryString(formObj));
	 				var arrXml=sXml.split("|$$|");
	 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"rcv_de_term_cd",true,0);
	 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_trsp_mod_cd",true,0);			
	 				break;
				case IBSEARCH:      //retrieve
					var sXml="";
					// getting sheet data from main page
					for (var i=4; i < 8; i++){
						var opener=window.dialogArguments;
						if (!opener) opener=parent;
						sXml=opener.getSheetXml(i);
						sheetObjects[i-3].LoadSearchData(sXml,{Sync:1} );
					}
					//copying hidden sheet's data
					if (sheetObjects[currentSheet].RowCount()!= 0){
						sheetToSheet(sheetObjects[currentSheet],sheetObjects[0]);
					}				
					//column  hidden
					setGetColHidden();
		         	break;		
	          }
         } catch (e) {
             if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally {
         	ComOpenWait(false);
         }
      }
      /**
       * checking validation process of inputed form data <br>
       */
      function validateForm(sheetObj,formObj,sAction){
     	  switch (sAction) {
 	  		case IBSEARCH: // retrieve			
 				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				} else {
 					return true;
 				}
 				break;
     	  }
          return true;
      }
      /**
       * handling radio button Axon event <br>
       */ 	 
  	function initControl() {
//  	    axon_event.addListener('click', 'radio_click', 'rt_pnt');
  		axon_event.addListenerForm('click', 'obj_click', document.form);
  	}
  	
    /**
    * calling function when clicking radio button <br>
    */ 	
  	function obj_click() {
  		var formObj=document.form;
  		if (event.srcElement.name == "rt_pnt") {
	  		var radioObj=document.form.rt_pnt;
	  		var hiddenVal=false;
	  		var idx=1 ;
	  		if(validateForm(sheetObjects[0],document.form,IBSAVE)!=true){
	  			radioObj[currentSheet-1].checked=true;
	  			return ;
	  		}  	  		
	  		// setting current screen data wiht hidden sheet 
	  	  	sheetToSheet(sheetObjects[0],sheetObjects[currentSheet]);
	  		//selected radio button
	  		for (i=0; i < 4 ; i++){
	  			if (radioObj[i].checked == true ){
	  				idx=i + 1;
	  				currentSheet=idx;
	  			}
	  		}
	  		// column hidden or not by radio button
	  		setGetColHidden();
	  		//setting hidden sheet's data with sheet
	  		changeCombo();
	  		sheetToSheet(sheetObjects[idx],sheetObjects[0]);
  		}
  	}         
    /**
     * setting term's combo by Route Point <br>
     */ 	   
    function changeCombo(){
    	var radioObj=document.form.rt_pnt;
		if (radioObj[0].checked){
			document.form.cd.value="CD02070";
		}else if (radioObj[3].checked){
			document.form.cd.value="CD02071";
		}
		if (radioObj[0].checked || radioObj[3].checked){
			//comon term
			document.form.f_cmd.value=SEARCH19;
//parameter changed[check again]CLT
			var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(document.form));
			setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0);
		}
    }
     /**
      * calling function when occurring radio button click event <br>
      * setting column show or hidden
       */ 	   	 
   	function setGetColHidden()
   	{
   		var radioObj=document.form.rt_pnt;
   		var hiddenVal=false;
   		var idx=1;
  		//selected radio button
  		for (i=0; i < 4 ; i++){
  			if (radioObj[i].checked == true ){
  				idx=i + 1;
  			}
  		}
  		if (idx == 2 || idx == 3){
  			hiddenVal=true;
  		} else {
  			hiddenVal=false;
  		}
//		sheetObjects[0].ColHidden("rcv_de_term_cd")=hiddenVal;
//		sheetObjects[0].ColHidden("prc_trsp_mod_cd")=hiddenVal;
  		sheetObjects[0].SetColHidden("rcv_de_term_cd", hiddenVal);
  		sheetObjects[0].SetColHidden("prc_trsp_mod_cd", hiddenVal);
   	}   	
     /**
	    * calling function when data moving between sheets <br>
	    * after all sheet data moving, origin data delete <br>
	    */  	 	 
   	function sheetToSheet (sheetObj1, sheetObj2){
   		if (sheetObj1.RowCount()!= 0 ){
   	   		var sXml=ComMakeSearchXml(sheetObj1, true, "","",true)
   	   		if (sXml !=""){
   	   			sheetObj2.LoadSearchData(sXml,{Sync:1} );
   	   			if ( sheetObj2 == sheetObjects[0]){
   	   				sheetGetRowHidden(sheetObj2);
   	   			}
   	   		}	
   		}
   	}
 	 /**
 	    *  row hidden when deleted row move between sheets<br>
 	    */   	 
 	function sheetGetRowHidden(sheetObj){
		for (i=sheetObj.RowCount(); i > 0; i-- ){
			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
				sheetObj.SetRowHidden(i,1);
			}
   		}	
 	}
 /**
    * checking radio button value based on main condition<br>
    */  	 
	function setSearchCondition()
	{
		 var formObj=document.form;
		 var radioSelect=formObj.org_dest_tp_cd.value + formObj.pnt_via_tp_cd.value;
	  	 var radioObj=document.form.rt_pnt;
		 switch (radioSelect){
			 case "OP":
				 currentSheet=1;				 
				 break;
			 case "OV":
				 currentSheet=2;
				 break;
			 case "DV":
				 currentSheet=3;
				 break;				 
			 case "DP":
				 currentSheet=4;
				 break;
		 }// end switch
		 radioObj[currentSheet - 1].checked=true;
	}		
	 /**
	    * checking sheet change after clicking close button <br>
	    */  		 
	function getSheetModify()
	{
		 if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true || sheetObjects[2].IsDataModified()== true || sheetObjects[3].IsDataModified()== true || sheetObjects[4].IsDataModified()== true ){
			 return true;
		 }
		 return false;
	}