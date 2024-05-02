/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0186.js
*@FileTitle  : Customer Code Entry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/    
    /**
     * @extends 
     * @class Customer Code Entry : business script for Customer Code Entry.
     */
    
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var formObject=document.form;
          try {
     		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
					case "btn_new":
						sheetObject1.RemoveAll();
						formObject.reset();
						document.form.anr_msg_sts_cd.src='img/btng_icon_b.gif'; // 2014.11.26 추가
					break;
					case "btn_sendfile":
						
						if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
							var selrow=sheetObjects[0].GetSelectRow();
							var rowNum=sheetObjects[0].GetSelectRow();

							if( rowNum%2 == 1 ) rowNum=rowNum - 1 ;
							ComOpenPopup("/opuscntr/ESM_BKG_0184.do?popup=y&cusrep=y&msg_tp_cd=R&rcv_snd_div_cd=S" 
									+ "&ref_seq="	+sheetObjects[0].GetCellValue(rowNum, "ref_seq" )
									+ "&anr_decl_no="	+sheetObjects[0].GetCellValue(rowNum, "anr_decl_no" )
									, 700, 610, "0002", "1,0", false);
						}
					break;
					case "btn_receivefile":
						var rowNum=sheetObjects[0].GetSelectRow();
						var selrow=sheetObjects[0].GetSelectRow();
						if( rowNum%2 == 1 ) rowNum=rowNum - 1 ;
						if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
							ComOpenPopup("/opuscntr/ESM_BKG_0184.do?popup=y&cusrep=y&msg_tp_cd=R&rcv_snd_div_cd=R" 
									+ "&ref_seq="	+sheetObjects[0].GetCellValue(rowNum, "ref_seq" )
									+ "&anr_decl_no="	+sheetObjects[0].GetCellValue(rowNum, "anr_decl_no" )
									, 700, 610, "0002", "1,0", false);
						}
					break;							
					case "btn_Close":
						ComClosePopup();
						break;
             } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
	
	
	/**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen
      */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();	 
		//if( document.form.popup.value == 'y' ){
		//document.getElementById("navi").style.display = "none";
		//}
		if( document.form.vvd.value != '' ){
			document.form.f_cmd.value=SEARCH01;
 	 		var aryPrefix=new Array("sheet2_"); //prefix string array
 	 		sheetObjects[1].DoSearch("ESM_BKG_0186GS_1.do?vvd="+document.form.vvd.value, FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix), {Sync:2});
 	 		
 	 		var vvdNm=sheetObjects[1].GetCellValue( 1, 2 );
 	 		var accept=sheetObjects[1].GetCellValue( 1, 3 );
 	 		var ssrNoValue=sheetObjects[1].GetCellValue( 1, 4 );
 	 		
 	 		if(vvdNm==-1){
 	 			document.form.vvd_nm.value="";
 	 		}else {
 	     		document.form.vvd_nm.value=vvdNm;
 	 		}
 	 		
 	 		if(ssrNoValue==-1){
 	 			document.form.svc_rqst_no.value="";
 	 		} else{
 	 			document.form.svc_rqst_no.value=ssrNoValue;
 	 		}
 	 		
 	     	if( 'A' != accept )
	     		document.form.anr_msg_sts_cd.src='img/btng_icon_r.gif'; 
	     	else
	     		document.form.anr_msg_sts_cd.src='img/btng_icon_b.gif';
	     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	     	
        }
     }
	
	 function initControl() {
//		 axon_event.addListenerForm("keyup","obj_KeyUp", document.form);
//		 axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);
		 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		 axon_event.addListenerForm("blur", "obj_blur", document.form);
		 
	 }
	/**
	 * handling search conditions input 
	 */
	function obj_blur() {
		var formObject = document.form;
	    var srcName = window.event.srcElement.getAttribute("name");
	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	    var srcValue = window.event.srcElement.getAttribute("value");
		 	
		var vvdValue   = formObject.vvd.value;
		
		if(srcName !="vvd")return;
		
		//var ssrNoValue = formObject.ssr_no.value;
		if ( ComChkLen(vvdValue, 9) == "2" ) {
			document.form.f_cmd.value = SEARCH01;
			var aryPrefix = new Array("sheet2_"); //prefix string array
		   	sheetObjects[1].DoSearch("ESM_BKG_0186GS_1.do?vvd="+vvdValue, FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix),{Sync:2});
		     	
		   	vvdValue = sheetObjects[1].GetCellValue( 1, 2 );
			var vvdNm=sheetObjects[1].GetCellValue( 1, 2 );
			var accept=sheetObjects[1].GetCellValue( 1, 3);
			var ssrNoValue=sheetObjects[1].GetCellValue( 1, 4 );
			
			if(sheetObjects[1].RowCount() <= 0) {
				vvdValue = "";
				vvdNm = "";
				accept = "";
				ssrNoValue = "";
			}
			
			document.form.vvd_nm.value = vvdNm;
		    document.form.svc_rqst_no.value = ssrNoValue;
 	 	}
		 	
	 	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
	}
	 
	// handling after sheet2 is searched    
	function sheet2_OnSearchEnd(Code, Msg) {
		var formObject=document.form;
		formObject.vvd_nm.value=sheetObjects[1].GetCellValue( 1, 2 );
		formObject.svc_rqst_no.value=sheetObjects[1].GetCellValue( 1,4 );
	    	
		if( 'A' != sheetObjects[1].GetCellValue( 1, 3) )
			document.form.anr_msg_sts_cd.src = 'img/btng_icon_r.gif'; 
	    else
	     	document.form.anr_msg_sts_cd.src = 'img/btng_icon_b.gif';
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
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 					case "sheet1":
 					    with(sheetObj){
 						  var cnt=0;
	 				      var HeadTitle1="|Seq.|Send Status|Send Date|Send ID|Send Office|VVD|Declaration No.|REF Seq.";
	 				      var HeadTitle2="|Seq.|Receive Status|Receive Date|Error Code|Error Description|Error Description|Error Description|Error Description";
	 				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge: 0} );
	 				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	 				      var headers = [ { Text:HeadTitle1, Align:"Center"},
	 				                      { Text:HeadTitle2, Align:"Center"} ];
	 				      InitHeaders(headers, info);
	 				      var cols = [[
	 				                 {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          Wrap:1 },
		 				             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"edi_snd_sts_cd",  Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"snd_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHms",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"edi_snd_usr_id",  Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",      Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:190,  Align:"Center",  ColMerge:1,   SaveName:"anr_decl_no",     Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ref_seq",         Wrap:1 },
		 				             ],[
		 				             {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          Wrap:1 },
		 				             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"edi_rcv_sts_cd",  Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHms",    PointCount:0,   UpdateEdit:0,   InsertEdit:1,   Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"edi_msg_err_id",  Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"err",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"err",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:190,  Align:"Center",  ColMerge:1,   SaveName:"err",             Wrap:1 },
		 				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"err",             Wrap:1 } 
	 				             ]];
	 				      InitColumns(cols,2);
					      SetEditable(0);
					      SetEllipsis(1);
					      SetSheetHeight(500);
                          SetRangeBackColor(1,1,1,7,"#555555");
 				      }
 					break;
 					
 					case "sheet2":
 					    with(sheetObj){
	 				      var HeadTitle1="|Seq.|vvdNm|accept|ssrNo|";
	 				      var headCount=ComCountHeadTitle(HeadTitle1);
	 				      var prefix='sheet2_';
	 				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	 				      InitHeaders(headers, info);
	 				      var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	 				                   {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"SEQ",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				                   {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				                   {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anr_msg_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				                   {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ssr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 				      InitColumns(cols);
	 				      sheetObj.SetVisible(false);
	 				      SetEditable(1);
	 				     SetSheetHeight(500);
 				       }
					break;				
 			}
 	}
     /**
      * handler get code value and change Desc
      * @return
      */
     function changeSendStatusCodeToDesc( sCode ){
    	 switch(sCode){
    	 	case 'O':
    	 		return 'Original';
    	 		break;
    	 	case 'C':
    	 		return 'Cancel';
    	 		break;
    	 	case 'R':
    	 		return 'Replace';
    	 		break;
    	 }
     }
     /**
      * handler get code value and change Desc
      * @return
      */
     function changeRecvStatusCodeToDesc( sCode ){
    	 switch(sCode){
    	 	case 'A':
    	 		return 'Accepted';
    	 		break;
    	 	case 'E':
    	 		return 'Error';
    	 		break;
    	 	case 'N':
    	 		return 'Waiting';
    	 		break;
    	 }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    	case IBSEARCH:    
    		if(validateForm(sheetObj,formObj,sAction)) {
    			formObj.f_cmd.value=SEARCH;
    			var sXml=sheetObj.GetSearchData("ESM_BKG_0186GS.do", FormQueryString(formObj));
    			sheetObj.LoadSearchData(sXml,{Sync:1} );
    			
    			for( var i=1; i<sheetObj.RowCount()+1; i++ ){
    				sheetObj.SetCellValue( i+1,2 ,changeSendStatusCodeToDesc( sheetObj.GetCellValue( i+1,2 ) ),0);
    				i++;
    				sheetObj.SetCellValue( i+1,2 ,changeRecvStatusCodeToDesc( sheetObj.GetCellValue( i+1,2 ) ),0);
    			}
    		}
    		break;
	    }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 		case IBSEARCH: 
	 			if (formObj.vvd.value == "" ) 
	 			{
	 				ComShowCodeMessage("BKG00626");
//	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;	 	
	 		
	 		case COMMAND01: //EDIT BL
				if (sheetObjects[1].RowCount()<= 0) {
					ComShowCodeMessage("BKG00395");
					return false;
				}
				return true;
    		break;
     	}
     }
     /**
      * handler show cell data on MemoPad.
      * 
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet1_OnClick(sheetObj, row, col){
    	 if( ( row%2 == 1 ) && ( col == 5 || col == 6 || col == 7 || col == 8 ) ) {
    		 //alert( sheetObj.CellValue(row,col) );
    		 if( sheetObj.GetCellValue(row,col) != '' )
    			 ComShowMemoPad(sheetObj, null, null, true, 600, 80);	//odd row not editable
    	 }
     }
