/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0078.js
*@FileTitle  : Contract Parties Information Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
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
          var sheetObject1=sheetObjects[0];          
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				case "prc_ctrt_pty_tp_cd":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
         for(i=0;i<sheetObjects.length;i++){
         //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
         /**/
		 var prcCtrtPtyTpCdCode=prcCtrtPtyTpCdValue.split("|");
		 var prcCtrtPtyTpCdName=prcCtrtPtyTpCdText.split("|");
		 var divStr="";
 		 var checked="";
		 for(var i=0; i<prcCtrtPtyTpCdCode.length; i++){
			if (i == 0)
				checked="checked";
			else
				checked="";
			divStr += "\n";
			divStr += "<input type=\"radio\" id=\"tp"+(i+1)+"\" name=\"prc_ctrt_pty_tp_cd\" value=\""+prcCtrtPtyTpCdCode[i]+"\" class=\"trans\""+checked+">"+ "<label for=\"tp"+(i+1)+"\">"+prcCtrtPtyTpCdName[i]+"</label>";
//			if(i < prcCtrtPtyTpCdCode.length)
//				divStr += "&nbsp;";
		 }
		 document.getElementById("div_prcCtrtPtyTpCd").innerHTML="<div id=\"div_prcCtrtPtyTpCd\">"+ divStr +"</div>";
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      // sheet1 init
            	    with(sheetObj){                 
		               var HeadTitle="|sel|prop_no|amdt_seq|prc_ctrt_pty_tp_cd|cust_cnt_cd|cust_seq|ctrt_cust_val_sgm_cd|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|"
		               HeadTitle += "Contract Party|Address|Signature|Title|EFF Date|EXP Date|Source|Source|Status|Status|Accept Staff/Team|Accept Date|acpt_usr_id|acpt_ofc_cd|n1st_cmnc_amdt_seq";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		               SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                Wrap:1 },
				                      {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		                
		               InitColumns(cols);
		               SetEditable(0);
		               SetSheetHeight(170);
		               SetWaitImageVisible(0);
		               SetColHidden("chk",1);
             	}
            	    break;
         }
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
	   	 		case IBSEARCH_ASYNC10:
	  				document.form.prc_ctrt_pty_tp_cd[0].checked=true;
	  				//srcInfocd		        
	  	 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
	  		        //status
	  	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
	   				break;
	   	 		case IBSEARCH_ASYNC20: // execute option 
	  				formObj.f_cmd.value=SEARCH11;
	   	 			var eleName="";
 	  				var sXml=sheetObj.GetSearchData("ESM_PRI_0078GS.do" , FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "cd|etc1");
	  				if(arrData!=undefined){
		  				for (var i=0; i < arrData.length; i++) {
		  					if (arrData[i][0] == "P" ){
		  						eleName="tp2";
		  					}else{
		  						eleName="tp1";
		  					}	
		  					document.getElementById(eleName).style.fontWeight="bold";
		  					switch (arrData[i][1]){
		  						case "0":
		  			 				document.getElementById(eleName).style.fontWeight="";
		  			 				document.getElementById(eleName).style.color="black";
		  							break;
		  						case "1":
		  			 				document.getElementById(eleName).style.color="black";
		  							break;
		  					}
		  				}
	  				}
	  				break;	
	   	 		case IBSEARCH:      //Retrieving			
	   	 			ComOpenWait(true); //->waiting->start
	   				formObj.f_cmd.value=SEARCH;
 	   				sheetObj.DoSearch("ESM_PRI_0078GS.do", FormQueryString(formObj) );
	   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
	   				ComOpenWait(false); //->waiting->End
	   				break;
	            }//end switch        	  
          } catch (e) {
             	if (e == "[object Error]") {
                     ComShowMessage(OBJECT_ERROR);
                 } else {
                     ComShowMessage(e.message);
                 }
            }finally{
  	          if (sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC20) {
  	        	  return;
  	          }
  	          ComOpenWait(false); //->waiting->End
          }
      }
      /**
       * Calling function in case of Onclick event <br>
       * Call User Info PopUp. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} Row mandatory Onclick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index 
       * @param {str} Value without Value Mandatory Format when saving 
       * @return void
       * @author 
       * @version 2009.06.03
       */  	           
       function sheet1_OnClick(sheetObj, Row, Col, Value) {
  	    var colname=sheetObj.ColSaveName(Col);
       	switch(colname)
       	{
   	    	case "acpt_usr_nm":
//   	    		ComUserPopup(sheetObj.CellValue(Row,"acpt_usr_id"));
   	    		break;
       	}    	 
      } 	
