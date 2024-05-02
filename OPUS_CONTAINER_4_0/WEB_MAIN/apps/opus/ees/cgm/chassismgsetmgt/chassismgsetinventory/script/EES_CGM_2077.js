/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2077.js
*@FileTitle  : Inventory by Lessor & Agreement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	 // common global variables
	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var beforetab=1;
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var comboObjects=new Array();
	 var comboCnt=0;
  	 var oldCntrTypeSize = "";
	 var sCntrTypeSize = "";

	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name <br>
	 * @param
	 * @return 
	 * @author 
	 * @version
	 */ 
	 function processButtonClick(){
	      /***** use additional sheet var in case of more than 2 tap each sheet *****/
	      var sheetObject=sheetObjects[0];
	      /*******************************************************/
	      var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	 		if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	             case "btn_retrieve":
	        		if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
	        			doActionIBSheet(sheetObject, formObject, IBSEARCH);
	        		}
					break;
	             case "btn_new":
	            	initControl();
					break;
	            case "btn_downexcel":
	            	if(sheetObject.RowCount() < 1){//no data
	            		ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	        	    }
	                break;
	            case "ComOpenPopupWithTargetOffice":
	         	ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 510, "ofc_cd:crnt_ofc_cd", "0,1,1,1,1,1,1", true);
	         	break;
	            case "btns_vndr":
	            	ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 555, "callBackVendor", "0,1,1,1,1,1", true, false);
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
	 * @param  {object} sheet_obj	
	 * @return 
	 * @author 
	 * @version
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
	 }
	 /**
	 * initializing sheet <br>
	 * implementing onLoad event handler in body tag <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	  */
	 function loadPage() {
		var formObj=document.form;
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
		
	     for(i=0;i<sheetObjects.length;i++){
	    	 //
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         //
	         ComEndConfigSheet(sheetObjects[i]);
	     }
	   	 // axon event regist
//	     axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//	     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
//	     axon_event.addListener('change', 'obj_change' , 'crnt_ofc_cd');  
	     $('#crnt_ofc_cd').on('change', function(){
	    	 obj_change();
	     });
//	     axon_event.addListener('keyup', 'enterFire', 'crnt_ofc_cd')
	  	 // Multi Combo reset
	  	 comboObjects[comboCnt++]=agmt_lstm_cd;
	   	 for(var k=0;k<comboObjects.length;k++){
	         initCombo(comboObjects[k]);
	     } 
	   	 /*
	     // Lease Term MultiCombo value setting
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
		 */
	 	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	     initControl();
	 }
	
	  /**
	   * init control of form <br>
	   * @param  
	   * @return 
	   * @author 
	   * @version
	   */
	 function initControl(){
	  	 var formObj=document.form;
	  	 var sheetObj=sheetObjects[0];
	  	 // Form Object reset
	  	 with(formObj){
	  		 crnt_ofc_cd.value="";
	  		 vndr_seq.value="";
	  	 }
	  	 // MultiCombo reset
	  	 for(var i=0; i<comboObjects.length; i++){
	  		 comboObjects[i].SetSelectText("",false);
	  	 }
	  	 // Sheet Object reset
	  	 sheetObj.RemoveAll();
	  	 //formObj.crnt_ofc_cd.focus();
		 // init value setting
	     }
	 /**
	  * setting sheet initial values and header <br>
	  * adding case as numbers of counting sheets <br>
	  * @param  {object} sheetObj		 Sheet Object
	  * @param  {int} sheetNo
	  * @return 
	  * @author 
	  * @version
	  */
	 function initSheet(sheetObj,sheetNo) {
	     var cnt=0;
		 var sheetID=sheetObj.id;
	     switch(sheetID) {
	         case "sheet1":
	             with (sheetObj) {
		             var HeadTitle="Lessor|AGMT No.|Ref.No|Total";
					
		             //making data as list for changing column
						oldCntrTypeSize = sCntrTypeSize;
						var arrCntrTypeSize = "";
						if(oldCntrTypeSize != ""){
							arrCntrTypeSize = oldCntrTypeSize.split("|");
						}
						
						//handling header title by changing column
						if (sCntrTypeSize != "") {
							HeadTitle += "|" + oldCntrTypeSize;
						}
		             
		             var headCount=ComCountHeadTitle(HeadTitle);
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"AutoSum",   Hidden:0, Width:185,  Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz_cd_total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		             
					  var sCount = "";
					  var x = 1;
	                  var sumCount = 3;
                      var sumNmVal = "";
					  
 	 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
					 		  if(i != arrCntrTypeSize.length){
				 			  	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					 		  
				 			  	x++;
					 	  	  }
					 	  
					 		  if(i == arrCntrTypeSize.length - 1){
							  	sumNmVal += "|"+sumCount;
							  }else if(i == 0){
							  	sumNmVal += sumCount;
							  }else{
							    sumNmVal += "|"+sumCount;
							  }
							  sumCount++;

					 	  }
					  }
					 	  
		             
		             InitColumns(cols);
		             SetEditable(1);
		             SetEditableColorDiff(0);
//		             SetSheetHeight(510);
		             ShowSubSum([{StdCol:0, SumCols:sumNmVal, Sort:false, ShowCumulate:false, CaptionCol:"vndr_lgl_eng_nm", CaptionText:"Sub Total"}]);
		             resizeSheet();
	             }
	             break;
         }
	     sheet1.SetSumText(0, 0, "TOTAL");
	   }
	 	function resizeSheet(){
		    ComResizeSheet(sheetObjects[sheetObjects.length-1]);
		}
	/**
	 * handling process for Sheet <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {object} formObj	 Form Object
	 * @param  {String} sAction	 Action Type
	 * @return 
	 * @author 
	 * @version
	 */
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	        case IBSEARCH:      //retrieve
		        // Form Object value setting
		    	formObj.f_cmd.value=SEARCH;
		 		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
		 		// retrieve
		 		if(validateForm(sheetObj,formObj,sAction))
		 		{
			 		sheetObj.WaitImageVisible = false;
			 		ComOpenWait(true);	 			
			 		var sXml=sheetObj.GetSearchData("EES_CGM_2077GS.do" , FormQueryString(formObj));
		 			sheetObj.LoadSearchData(sXml,{Sync:0} );
			 		ComOpenWait(false);
		 		}
	             break;
	 	   case IBSEARCH_ASYNC02:	// Office Code  Validation check 
			   	formObj.f_cmd.value=COMMAND01;
			   	formObj.ofc_cd.value=formObj.crnt_ofc_cd.value;
			   	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Office');
			   		formObj.crnt_ofc_cd.value="";
			   		formObj.crnt_ofc_cd.focus();
			   	}
			   	break;
	    	case IBSEARCH_ASYNC05:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
		       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr=ComGetEtcData(sXml,"comboList");    			
		   		var arrStr=sStr.split("@");
		  		makeComboObject(agmt_lstm_cd, arrStr, 0, 0, 0);
		  		comboObjects[0].DeleteItem(0);
		       	break;
	    	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
	    		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
				break;
	    	case IBDOWNEXCEL:        //down excel
	    		if(sheetObj.RowCount() < 1){//no data
	    			ComShowCodeMessage("COM132501");
	    			}else{
	    				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	    			}
	            break;
	    	case IBRESET:
	    		var idx=0
	    		var sXml2=document.form2.sXml.value;
	    		var arrXml=sXml2.split("|$$|");
	    		//Lease Term
	    		if ( arrXml[idx] == null ) {return;}
	    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    	    var arrStr3=new Array();
	    		for ( var i=0; i < vArrayListData.length; i++) {
	    		    vListData=vArrayListData[i];
	    		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
	    		}
		  		makeComboObject(agmt_lstm_cd, arrStr3, 0, 0, 0);
		  		comboObjects[0].DeleteItem(0);
		  		idx++;
	    		break;            
	     }
	 }
	/**
	 * handling process for input validation <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {object} formObj	 Form Object
	 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
	 * @return {boolean}			false => validation check error, true => validation check succes
	 * @author 
	 * @version
	 */ 
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction){
				case IBSEARCH:
					break;
			}
		}
		return true;
	}
	function callBackVendor(aryPopupData, row, col, sheetIdx){
	    	var formObj=document.form;
	     var vndrSeq="";
	     var i=0;
	     for(i=0; i < aryPopupData.length; i++){
	     	vndrSeq=vndrSeq + aryPopupData[i][2];
	     	if(i < aryPopupData.length - 1){
	     		vndrSeq=vndrSeq + ",";
	     	}
	     }
	     formObj.vndr_seq.value=vndrSeq;
	}	
	function sheet1_OnChangeSum(sheetObj, Row)
	 {
	 	with(sheetObj)
	 	{
	 		SetSumText(0, "Seq","Total/%");
	 		SetCellAlign(Row, "TPSZ","Center");
	 	}
	 }
	/**
	 * Sheet1  OnSearchEnd event handling <br>
	 * @param  {object} sheetObj		 Sheet Object
	 * @param  {string} ErrMsg		 String
	 * @return 
	 * @version
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
        {
			//ShowSubSum([{StdCol:0, SumCols:"3|4|5", Sort:false, ShowCumulate:false, CaptionCol:"vndr_lgl_eng_nm", CaptionText:"SubTotal"}]);
        }
		sheet1.SetSumText(0, 0, "TOTAL");
	}
	/**
	 * Sheet1 OnMouseDown event handling <br>
	 * @param  {Integer} Button	mandatory Integer
	 * @param  {integer} Shift	mandatory Integer
	 * @param  {Integer} X	mandatory Integer
	 * @param  {integer} Y	mandatory Integer
	 * @return 
	 * @author 
	 * @version
	 */ 
	 function sheet1_OnMouseDown (Button, Shift, X, Y){
		 var sheetObj=sheetObjects[0];
		 var formObj=document.form;
		 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
		 {
			 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
		 }
	 }
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var eqKndCd=EQ_KND_CD_MGSET;
		var crntOfcCd=document.form.crnt_ofc_cd.value;
		var vndrSeq=document.form.vndr_seq.value;
		var agmtLstmCd=agmt_lstm_cd.GetSelectText();
		var group1="";
		var groupValue1="";
		
		if(sheetObj.GetCellValue(Row, "vndr_lgl_eng_nm") == "Sub Total")
		{		
			groupValue1=sheetObj.GetCellValue(Row, "vndr_lgl_eng_nm"); // "123456.VENDER"
		}else{
			// groupValue1 = sheetObj.cellValue(Row, "vndr_lgl_eng_nm").substring(0,6); // "123456.VENDER"
			var dispText=sheetObj.GetCellValue(Row, "vndr_lgl_eng_nm");
			if(dispText.length >=8)
			{
				groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
			}else
			{
				groupValue1=dispText;
			}
		}
		var s2_group1="";
		var s2_groupValue1="";
	  	var s3_gtotal="";
		if(groupValue1 == "Sub Total")
		{
			s2_group1="SubSum";
			var dispText=sheetObj.GetCellValue(Row-1, "vndr_lgl_eng_nm");
			if(dispText.length >=8)
			{
				s2_groupValue1=dispText.substr(dispText.lastIndexOf('(')+1,6);
			}else
			{
				s2_groupValue1=dispText;
			}
			//groupValue1 = groupValue1.substring(9); 
			groupValue1=s2_groupValue1;
		}else if(groupValue1 == "TOTAL"){
	  		s3_gtotal="GTOTAL";
	  	}else{
			s2_group1="";
			s2_groupValue1="";
		}
		if(groupValue1.lastIndexOf('(') != -1) {
			groupValue1=groupValue1.substring(groupValue1.lastIndexOf('(')+1, groupValue1.length-1);
		}
		
		var s2AgmtNo=sheetObj.GetCellValue(Row, "agmt_no");
		var s2AgmtRefNo=sheetObj.GetCellValue(Row, "agmt_ref_no");
		var s2EqTpszCd="";
		//if(comboObjects[2].Code == "")
		var colSaveName=sheetObj.ColSaveName(Col);
		
		var k = 1;
		oldCntrTypeSize = sCntrTypeSize;
		var arrCntrTypeSize = oldCntrTypeSize.split("|");

		for ( var i = 0; i < arrCntrTypeSize.length; i++) {
			if (arrCntrTypeSize.length > 1) {
				var gubun = "eq_tpsz_cd" + k;
				if(colSaveName == gubun){
					s2EqTpszCd = arrCntrTypeSize[i];
					break;
				}
				k++;
			}
		}

		if(parseInt(Col) == 3) s2EqTpszCd="TOTAL";

		var param="?program_id=2077";
		param=param + "&eq_knd_cd=" + eqKndCd;
		param=param + "&s_crnt_ofc_cd=" + crntOfcCd;
		param=param + "&s_vndr_seq=" + vndrSeq;
		param=param + "&s_agmt_lstm_cd=" + agmtLstmCd;
		param=param + "&s_group1=" + group1; 
		param=param + "&s_group1_val=" + groupValue1;
		param=param + "&s2_group1=" + s2_group1;
		param=param + "&s2_group1_val=" + s2_groupValue1;
		param=param + "&s2_agmt_no=" + s2AgmtNo;
		param=param + "&s2_agmt_ref_no=" + s2AgmtRefNo;
		param=param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
	  	param=param + "&s3_gtotal=" + s3_gtotal;
		var seq=sheetObj.GetCellValue(Row, "Seq");
		if(Col > 2 ){
			ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param,  700, 400, "", "1,0", true, false);
	    }else
	    {
	  	    ComShowCodeMessage('CGM10016');
	    }
	}    
	 /** 
	  * Object activate event handling  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version
	  */
	 function obj_activate(){
	   	ComClearSeparator(event.srcElement);
	 } 
	/** 
	  * Object deactivate event handling  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version
	  */
	 function obj_deactivate(){
		//ComChkObjValid(event.srcElement);
	 }
	 
	/** 
	  * Object change event handling  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version
	  */  
	 function obj_change(){
	 	 var formObj=document.form;
	 	 var sheetObj=sheetObjects[0]; 
	 	 obj=event.srcElement;
	 	 switch(ComGetEvent("name")){
		 	case "crnt_ofc_cd":
		 		break;
	 	   	case "vndr_seq":
	 	   		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
	 	   		var arrVndrSeq=vndrSeq.split(",");
	 	   		for(var i=0; i < arrVndrSeq.length; i++){
	 	   		// 
	 	 			if(arrVndrSeq[i] == ''){
	 	 				ComShowCodeMessage('CGM10009','Lessor');
	 	 				formObj.vndr_seq.value="";
	     	 				ComSetFocus(formObj.vndr_seq);
	     	 				break;
	     	 			}
	     	   		}	 
	      	   	     	 break;
	     	 }   
	     }
	/** 
	 * Object obj_focusout event handling  <br>
	 * @param  
	 * @return 
	 * @author 
	 * @version
	 */  
	function obj_focusout(){
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 obj=event.srcElement;
		 switch(ComGetEvent("name")){
		 	case "crnt_ofc_cd":
		 		break;
		 }
	}
	/** 
	  * Combo Object reset  <br>
	  * @param  {object} comboObj	Combo Object
	  * @return 
	  * @author 
	  * @version
	  */ 
	 function initCombo(comboObj) {
	 	switch(comboObj.options.id) {
	    	case "agmt_lstm_cd":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code="";
	  	            Text="";
	  	            SetDropHeight(180);
	  	            SetMultiSelect(1);
	  	            SetMaxSelect(100);
	  	            SetEnable(1);
		            SetMaxLength(20);
	  	        }
	  	        break;
	 	}
	 }       
	 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	 	cmbObj.RemoveAll();
	 	cmbObj.InsertItem(0,"","");
	 	if(opt == 0) {
	 		for (var i=0; i < arrStr.length;i++ ) {
	 			var arrCode=arrStr[i].split("|");
	     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
//	     		alert( i +"="+ arrCode[txtCol] + "=" + arrCode[codeCol] );
	         }
	 	} else if(opt == 1){
	 		cmbObj.InsertItem(0,"","");
	 		for (var i=0; i < arrStr.length;i++ ) {
	 			var arrCode=arrStr[i].split("|");
	     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	         }
	 	}
	 	cmbObj.SetSelectIndex("" ,false);
	 } 
	 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
	    	cmbObj.RemoveAll();
	    	if(arrStr == undefined ){
	    		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
				cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
				cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	    	} else {
	        	var arrCode=arrStr[0].split("|");
	      	var arrCode2=arrStr[1].split("|");
	          	for (var i=0; i < arrCode.length;i++ ) {
	          		var arrCode3=arrCode[i].split("|");
	          		var arrCode4=arrCode2[i].split("|");
	          		if(i==0)
	          		{
	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		else
	          		{
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          	}
	    	}
	    	cmbObj.SetSelectIndex("", false);
	    } 
	   function enterFire() {
		   var formObj=document.form;
		   if(formObj.crnt_ofc_cd.value != '')
		   {
			   if(event.keyCode == 13)
				   ComKeyEnter('search');
		   }
	   }  
		/* developer job end */
//	   function agmt_lstm_cd_OnCheckClick(comboObj, index, text, code) {
//		      if (!comboObj.GetItemCheck(0)) {
//		          document.form.agmt_no.value="";
//		          comboObj.SetItemCheck(0,0);
//		          for(var i=1; i<comboObj.GetItemCount(); i++) {
//		              comboObj.SetItemCheck(i,1);
//		          }
//		          document.form.agmt_no.value="'" + ComReplaceStr(comboObj.GetSelectCode(), ",", "', '") + "'";
//		      } else if (comboObj.GetItemCheck(0)) {
//		       comboObj.SetItemCheck(0,1);
//		          for(var i=1; i<comboObj.GetItemCount(); i++) {
//		              comboObj.SetItemCheck(i,0);
//		          }
//		          document.form.agmt_no.value="";
//		          comboObj.SetItemCheck(parseInt(agmt_lstm_cd.GetSelectIndex()),1);
//		      } else {
//		          comboObj.SetItemCheck(0,0);
//		          document.form.agmt_no.value="'" + ComReplaceStr(comboObj.GetSelectCode(), ",", "', '") + "'";
//		          comboObj.SetItemCheck(parseInt(agmt_lstm_cd.GetSelectIndex()),1);
//		      }
//	   }
	   
//	   function agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//		   document.form.agmt_lstm_cd_text.value = newCode;
//	   }
//	   
//	   function agmt_lstm_cd_OnBlur(comboObj) {
//		   document.form.agmt_lstm_cd_text.value = comboObj.GetSelectCode();
//	   }