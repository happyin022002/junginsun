/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2028.js
*@FileTitle  : Lease Term Change Summary Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_2028 : ees_cgm_2028 business script for
     */
  
   	/* developer job	*/
    // common global variables
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
        var sheetObject1=sheetObjects[0];
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
 				case "btn_Retrieve":
 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
 						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					}
 					break;
 				case "btn_New":
 					initControl();
 					break;
 				case "btn_loadexcel":
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;
 				//case "viewflg":
            	//	doOptionBtnAction(formObject, srcName);
            	//	break;
 				case "btns_sts_evnt_dt" :
					var cal=new ComCalendarFromTo();
					cal.select(formObject.sts_evnt_dt_fr, formObject.sts_evnt_dt_to, "yyyy-MM-dd");
 					break;	
 				case "btns_office1":	// Office Code getting popup 
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 510, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;
 				case "btns_office2":	// Office Code getting popup 
 					ComOpenPopup('/opuscntr/COM_ENS_071.do', 800, 510, "setCallback_Office", "0,1,1,1,1,1,1,1", true, false);
 					break;
 				case "btns_vndr1":	// Lessor Code getting popup
 					ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 515, "vndr_seq:vndr_seq", "0,1,1,1,1,1", true);
 					break;	
 				case "btns_vndr2":	// Lessor Code getting popup
 					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, "setCallback_Vendor", "0,1,1,1,1,1", true, false);
					break;	
            } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
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
//    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//        axon_event.addListenerFormat('keydown', 'obj_keydown', form);
//        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
        
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
        
    	for(i=0;i<sheetObjects.length;i++){
        	//
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	//
        	ComEndConfigSheet(sheetObjects[i]);
        }	
    	// IBMultiCombo reset
        comboObjects[comboCnt++]=old_agmt_lstm_cd;
        comboObjects[comboCnt++]=new_agmt_lstm_cd;
     	for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
     	// Lease Term Combo Control  init value  setting.
//        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0], formObj,IBRESET);
        // Form Control reset
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
    	// Form object
     	formObj=document.form;
        // Form Object reset 
        with(formObj){
        	ComCgmSetObjectValue(sts_evnt_ofc_cd);
        	ComCgmSetObjectValue(sts_evnt_dt_fr);
        	ComCgmSetObjectValue(sts_evnt_dt_to);
        	ComCgmSetObjectValue(vndr_seq);
        }
        // Option button reset
        //formObj.viewflg(0).checked = true;
        // MultiCombo reset
        comboObjects[0].SetSelectText("",false);
        comboObjects[1].SetSelectText("",false);
        // Sheet Object reset
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        //doOptionBtnAction(formObj,"viewflg");
    	// 초기 focus
//        formObj.sts_evnt_ofc_cd.focus();
      //  sheet1_OnSearchEnd(sheetObjects[0],"");
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
                var HeadTitle1="|Office|Old|Old|Old|New|New|New";
                HeadTitle1=HeadTitle1 + "|Term Change Quantity";
                var HeadTitle2="|Office|Lessor|AGMT No.|Term|Lessor|AGMT No.|Term";
                HeadTitle2=HeadTitle2 + "|Total";
                
				//making data as list for changing column
				oldCntrTypeSize = sCntrTypeSize;
				var arrCntrTypeSize = "";
				if(oldCntrTypeSize != ""){
					arrCntrTypeSize = oldCntrTypeSize.split("|");
				}
				
				//handling header title by changing column
				if (sCntrTypeSize != "") {
					
					HeadTitle2 += "|" + oldCntrTypeSize;
					
				}
                
                var headCount=ComCountHeadTitle(HeadTitle1);
              //  (headCount, 0, 0, true);
                
               // var totalVal="|9|+|10|";
                var totalVal = "";
                var z = 1;
                var sumCount = 8;
                var sumNmVal = "";
				for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
					if (arrCntrTypeSize.length > 1) {
						if(i != arrCntrTypeSize.length){
							if(i == arrCntrTypeSize.length - 1){
								totalVal += "|eq_tpsz_cd" + z+"|";
							}else if(i == 0){
								totalVal += "|eq_tpsz_cd" + z+"|+";
							}else{
								totalVal += "|eq_tpsz_cd" + z+"|+";
								
							}
							z++;
						}
						
						if(i == arrCntrTypeSize.length - 1){
							sumNmVal += "|"+sumCount;
						}else if(i == 0){
							sumNmVal += sumCount;
						}else{
							sumNmVal += "|"+sumCount;
							
						}
						HeadTitle1 += "|Term Change Quantity" ;
						
						sumCount++;
					}
				}
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sts_evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"old_vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"old_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"old_agmt_lstm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"new_vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"new_agmt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"new_agmt_lstm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"Total",             KeyField:0,   CalcLogic:totalVal,Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
                
				  var sCount = "";
				  var x = 1;
				  
	 	          for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
			 			  cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
				 		  x++;
				 	  }
				  }
                
                 
                InitColumns(cols);
//                SetSheetHeight(520);
	            SetEditable(1);
				SetEditableColorDiff(0);
//                SetRangeBackColor(1,1,1,10,"#555555");
                
                ShowSubSum([{StdCol:"sts_evnt_ofc_cd", SumCols:sumNmVal, Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"Office Total"}]);
                
                resizeSheet();

 				}
 				break;
        }
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
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
 	    	case "old_agmt_lstm_cd":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code="";
 	  	            Text="";
 	  	            SetDropHeight(200);
 	  	            SetMultiSelect(1);
 	  	            SetMaxSelect(100);
 	  	            SetEnable(1);
 	  	        }
 	  	        break;
     	 	case "new_agmt_lstm_cd":
     	 		var cnt=0;
      	        with(comboObj) {
      	        	Code="";
      	            Text="";
      	            SetDropHeight(200);
      	            SetMultiSelect(1);
      	            SetMaxSelect(100);
      	            SetEnable(1);
      	        }
      	        break;
     	}
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
        		formObj.f_cmd.value=SEARCH;
        		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
        		sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
        		// retrieve
 	     		var sXml=sheetObj.GetSearchData("EES_CGM_2028GS.do" , FormQueryString(formObj), '', true);
	     		sheetObj.LoadSearchData(sXml,{Sync:1} );
		 	    ComOpenWait(false);
 				break;
 			case IBDOWNEXCEL:        //down excel
 				if(sheetObj.RowCount() < 1){//no data
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        		}
 				break;
 			case IBSEARCH_ASYNC01:	// Term Code MultiCombo retrieve
	        	formObj.f_cmd.value=SEARCH;
	        	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
 	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	    		var sStr=ComGetEtcData(sXml,"comboList");    			
	    		var arrStr=sStr.split("@");
	    		// combo control, result string, Text Index, Code Index
	   			MakeComboObject(old_agmt_lstm_cd, arrStr, 0, 0);
	   			MakeComboObject(new_agmt_lstm_cd, arrStr, 0, 0);
	        	break;
        	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
				break;
	        	
 			 case IBRESET:
     	 		var idx=0
     	 		var sXml2=document.form2.sXml.value;
     	 		var arrXml=sXml2.split("|$$|");
     	 		//agmt_lstm_cd
     	 		if ( arrXml[idx] == null ) {return;}
     	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
     	 	    var arrStr1=new Array();
     	 		for ( var i=0; i < vArrayListData.length; i++) {
     	 		    vListData=vArrayListData[i];
     	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
     	 		}
     	 		// combo control, result string, Text Index, Code Index
     		  	MakeComboObject(old_agmt_lstm_cd, arrStr1, 0, 0);
	   			MakeComboObject(new_agmt_lstm_cd, arrStr1, 0, 0); 
     	 		idx++;       
     	 		break;
        }
    }
    /**
     * handling process for input validation <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type
     * @return {boolean}			false => validation check error, true => validation check succes
     * @author 
     * @version 
     */  
    function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction){
        	 	case IBSEARCH:	// retrieve
	        	 	if(sts_evnt_dt_fr.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Change Period');
//	    	 			sts_evnt_dt_fr.focus();
	    	 			return false;
	        	 	} else if(sts_evnt_dt_to.value == ''){
	        	 		ComShowCodeMessage('CGM10004','Change Period');
//	        	 		sts_evnt_dt_to.focus();
	    	 			return false;
	        	 	} else {
	        	 		return true;
	        	 	}
        	 		break;
        	 }
         }
    }
/*     
    function doOptionBtnAction(formObj, srcName){
    	switch(srcName){
        	case "viewflg":
        		var viewLayer1=document.getElementById("viewLayer1");
        		var viewLayer2=document.getElementById("viewLayer2");
        		if(formObj.viewflg[0].checked){
        			viewLayer1.style.display="block";
        			viewLayer2.style.display="none";
        		} else if(formObj.viewflg[1].checked){
        			viewLayer1.style.display="none";
        			viewLayer2.style.display="block";
        		}
        		break;
        }
    }
*/       
    /**
     * Office popup call setting Callback function
     * @author 
     * @version 
     */
    function setCallback_Office(aryPopupData, row, col, sheetIdx){
    	var formObj=document.form;
    	var ofcCd="";
    	for(i=0; i < aryPopupData.length; i++){
    		ofcCd=ofcCd + aryPopupData[i][3];
   		 	if(i < aryPopupData.length - 1){
   		 		ofcCd=ofcCd + ",";
   		 	}
    	}
    	formObj.sts_evnt_ofc_cd.value=ofcCd;
    }
    /*
     * Lessor popup call setting Callback function
     * @author 
     * @version 
     */
    function setCallback_Vendor(aryPopupData, row, col, sheetIdx){
    	var formObj=document.form;
    	var vndrSeq="";
    	for(i=0; i < aryPopupData.length; i++){
    		vndrSeq=vndrSeq + aryPopupData[i][2];
   		 	if(i < aryPopupData.length - 1){
   		 	vndrSeq=vndrSeq + ",";
   		 	}
    	}
    	formObj.vndr_seq.value=vndrSeq;
    }
    /**
     * Sheet1 Total Sum handling <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {string} Row			mandatory Row
     * @author 
     * @version 
     */  
 	function sheet1_OnChangeSum(sheetObj, Row){
 		with(sheetObj)
 		{
    		SetSumText(0, "sts_evnt_ofc_cd","");
     		SetSumText(0, "old_vndr_seq","Grand Total");
     		SetCellAlign(0, "old_vndr_seq","Center"); 			
 		}
 	}
    /**
     * Sheet1 Office Total handling <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {string} ErrMsg		mandatory ErrMsg
     * @author 
     * @version 
     */  
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 		//	ShowSubSum([{StdCol:"sts_evnt_ofc_cd", SumCols:"8|9|10", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"Office Total"}]);
    		SetSumText(0, "sts_evnt_ofc_cd","");
     		SetSumText(0, "old_vndr_seq","Grand Total");
     		SetCellAlign(0, "old_vndr_seq","Center"); 	
 		}
 	}
     function sheet1_OnMouseDown (Button, Shift, X, Y){
     	 var sheetObj=sheetObjects[0];
     	 var formObj=document.form;
     	 if(sheetObj.RowCount() + 2 == sheetObj.MouseRow)
     	 {
     		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
     		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
     		 //alert(groupValue1);
     		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
     	 }
      }
     /**
      * Sheet1 Double Click ->detail info page <br>
      * @author 
      * @version
      */   
     function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	var eqKndCd=EQ_KND_CD_CHASSIS;
     	var stsEvntDtFr=document.form.sts_evnt_dt_fr.value;
     	var stsEvntDtTo=document.form.sts_evnt_dt_to.value;
     	var stsEvntOfcCd=sheetObj.GetCellValue(Row, "sts_evnt_ofc_cd");
     	var oldAgmtNo=sheetObj.GetCellValue(Row, "old_agmt_no");
     	var oldAgmtOfcCtyCd=oldAgmtNo.substring(0,3);
     	var oldAgmtSeq=oldAgmtNo.substring(3);
     	var newAgmtNo=sheetObj.GetCellValue(Row, "new_agmt_no");
     	var newAgmtOfcCtyCd=newAgmtNo.substring(0,3);
     	var newAgmtSeq=newAgmtNo.substring(3);
     	var eqTpszCd="";
     	var colSaveName=sheetObj.ColSaveName(Col);
     	var sVndrSeq=document.form.vndr_seq.value;
     	var sAgmtLstmCd=old_agmt_lstm_cd.GetSelectText();
     	var s2AgmtLstmCd=new_agmt_lstm_cd.GetSelectText();
     	
     	
    	var k = 1;
		oldCntrTypeSize = sCntrTypeSize;
		var arrCntrTypeSize = oldCntrTypeSize.split("|");

		for ( var i = 0; i < arrCntrTypeSize.length; i++) {
			if (arrCntrTypeSize.length > 1) {
				var gubun = "eq_tpsz_cd" + k;
				if(colSaveName == gubun){
					eqTpszCd = arrCntrTypeSize[i];
					break;
				}
				k++;
			}
		}
     	
     	
     	
     	if( sheetObj.GetCellValue(Row, "sts_evnt_ofc_cd")== "Office Total" ){
     		stsEvntOfcCd=sheetObj.GetCellValue(Row-1, "sts_evnt_ofc_cd");
     	} else if( sheetObj.GetCellValue(Row, "sts_evnt_ofc_cd")== "TOTAL" ){
     		stsEvntOfcCd=document.form.sts_evnt_ofc_cd.value;
  	    } 
     	
//    	if( sheetObj.GetCellValue(Row, "new_agmt_no")== "" && sheetObj.GetCellValue(Row, "new_agmt_lstm_cd") == "Office Total"){
//    		stsEvntOfcCd=sheetObj.GetCellValue(Row-1, "sts_evnt_ofc_cd");
//    		old_lstm_cd=old_agmt_lstm_cd.GetSelectText();
//    		new_lstm_cd=new_agmt_lstm_cd.GetSelectText();
// 	    	vndr_seq=document.form.vndr_seq.value;
// 	    } else if( stsEvntOfcCd == "TOTAL"  ){
// 	    	stsEvntOfcCd=document.form.sts_evnt_ofc_cd.value;
// 	    	old_lstm_cd=old_agmt_lstm_cd.GetSelectText();
// 	    	new_lstm_cd=new_agmt_lstm_cd.GetSelectText();
// 	    	vndr_seq=document.form.vndr_seq.value;
// 	    }
     	
     	var param="?program_id=2028";
     	param=param + "&eq_knd_cd=" + eqKndCd;
     	param=param + "&sts_evnt_dt_fr=" + stsEvntDtFr;
     	param=param + "&sts_evnt_dt_to=" + stsEvntDtTo;
     	param=param + "&sts_evnt_ofc_cd=" + stsEvntOfcCd;
     	param=param + "&old_agmt_ofc_cty_cd=" + oldAgmtOfcCtyCd;
     	param=param + "&old_agmt_seq=" + oldAgmtSeq;
     	param=param + "&new_agmt_ofc_cty_cd=" + newAgmtOfcCtyCd;
     	param=param + "&new_agmt_seq=" + newAgmtSeq;
     	param=param + "&eq_tpsz_cd=" + eqTpszCd;
     	param=param + "&s_vndr_seq=" + sVndrSeq;
     	param=param + "&s_agmt_lstm_cd=" + sAgmtLstmCd;
     	param=param + "&s2_agmt_lstm_cd=" + s2AgmtLstmCd;
 	    if(Col >= 8  ){
 	    	ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
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
      	ComClearSeparator(ComGetEvent());
    }
    /** 
     * Object deactivate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_deactivate(){
      	var formObj=document.form;
      	obj=ComGetEvent();      	
      	if(obj.name == 'sts_evnt_dt_fr' || obj.name == 'sts_evnt_dt_to'){
      		with(formObj){
      			var fromDt=ComReplaceStr(sts_evnt_dt_fr.value,"-","");
	   	 		var toDt=ComReplaceStr(sts_evnt_dt_to.value,"-","");
	      		switch(ComGetEvent("name")) {
		      		case "sts_evnt_dt_fr": 
			   	 		if(fromDt != '' && toDt != ''){
			    			if(fromDt > toDt){
			    				ComShowCodeMessage('COM12133','To date','From date','greater');
			    				sts_evnt_dt_fr.value="";
			    				ComSetFocus(sts_evnt_dt_fr);
			    			}
			    		}
			   	 		break;
		      		case "sts_evnt_dt_to":
	    	    		if(fromDt != '' && toDt != ''){
	    	    			if(fromDt > toDt){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				sts_evnt_dt_to.value="";
	    	    				ComSetFocus(sts_evnt_dt_to);
	    	    			}
	    	    		}
	    	           	break;	
	      		}	
      		}
      		ComChkObjValid(ComGetEvent());	
      	}
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
	   	obj=ComGetEvent();
	   	switch(ComGetEvent("name")){
		   	case "sts_evnt_ofc_cd":
		   	 	var ofcCd=ComTrimAll(formObj.sts_evnt_ofc_cd.value);
		 		if(ofcCd != ''){
		 			var arrOfcCd=ofcCd.split(",");
		 			for(var i=0; i < arrOfcCd.length; i++){
	    	 			// 
	    	 			if(arrOfcCd[i] == ''){
	    	 				ComShowCodeMessage('CGM10009','Change Office');
	    	 				formObj.sts_evnt_ofc_cd.value="";
	    	 				ComSetFocus(formObj.sts_evnt_ofc_cd);
	    	 				break;
	    	 			}
	    	 		}
		 		}
	   	 		break;
	   	 	case "vndr_seq":
		   	 	var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
		 		if(vndrSeq != ''){
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
		 		}
	   	 		break;
	   	}
    }
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	cmbObj.RemoveAll();
      	for (var i=0; i < arrStr.length;i++ ) {
      		var arrCode=arrStr[i].split("|");
      		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
      	}
      	cmbObj.SetSelectIndex("" ,false);
    }  

