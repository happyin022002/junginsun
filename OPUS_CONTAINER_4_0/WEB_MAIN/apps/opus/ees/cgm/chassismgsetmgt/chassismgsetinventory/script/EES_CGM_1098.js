/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1098.js
*@FileTitle  : Inventory by Agreement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_1098 : EES_CGM_1098 business script for
     */

   	/* developer job	*/
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
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            		}
            		formObject.crnt_loc_cd.focus();           		
                    break;
                case "btn_new":
                	initControl();
                    break; 
                case "btn_downexcel":
                	
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    break;
                case "btns_crnt_loc_cd":	// Location Popup
	                var tmp=formObject.combo_location_text.value; //[fix] var tmp=formObject.location.text;
	            	if(tmp == "RCC"){
	            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
	            	} else if(tmp == "LCC") {
	            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
	            	} else if(tmp == "SCC") {
	            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
	            	}
                	break;
                case "btns_crnt_yd_cd":		// Yard
                	//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
                	ComOpenPopup('/opuscntr/COM_ENS_061.do',  800, 540, "callBackYard", "0,1,1,1,1,1,1", true, false);
                	break;
                case "btns_vndr":
                	ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 545, "callBackVendor", "0,1,1,1,1,1", true, false);
                	break;   
                case "btns_agmt_no":
       			ComOpenPopup('/opuscntr/EES_CGM_1117.do', 820, 420, "setAgmtNo", "0,1,1,1,1,1", true, false);
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
   //    	 axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
   //      axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
         axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
      	 axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
      	 axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
      	 axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
     	 // Multi Combo reset
     	 comboObjects[comboCnt++]=combo_location; //[fix] comboObjects[comboCnt++]=formObj.location;
      	 for(var k=0;k<comboObjects.length;k++){
  	         initCombo(comboObjects[k]);
 	     }  
        /*
      	 // Location MultiCombo value setting
     	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		 */
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
      	 with(formObj){
      		 crnt_loc_cd.value="";
      		 crnt_yd_cd.value="";
      		 vndr_seq.value="";
      		 agmt_no.value="";
      		 include_np.checked=false;
      	 }
      	 // MultiCombo reset
      	 for(var i=0; i<comboObjects.length; i++){
      		 comboObjects[i].SetSelectText("",false);
      	 }
      	 // Sheet Object reset
      	 sheetObj.RemoveAll();
    	 // init value setting
    	 comboObjects[0].SetSelectIndex(0); //[fix] comboObjects[0].SetSelectIndex(0,false);
    	 sheetObj.SetCellValue(0,"crnt_loc_cd", comboObjects[0].GetSelectText()); //[fix] sheetObj.GetCellValue(0,"crnt_loc_cd")=comboObjects[0].GetSelectText();
//    	 formObj.crnt_loc_cd.focus(); 
     }
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
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
                var HeadTitle="LCC|AGMT No.|Lessor|Total";
                
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
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ 
                       {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz_cd_total",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
                
                
				  var sCount = "";
				  var x = 1;
				  
 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
			 			  cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
				 		  x++;
				 	  }
				  }
				 	  
                    var sumCount = 3;
                    var sumNmVal = "";
					for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
						if (arrCntrTypeSize.length > 1) {
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
//                SetSheetHeight(422);
                SetEditable(1);
                SetEditableColorDiff(0);
                resizeSheet( );
                
                var info = [
				{StdCol:"crnt_loc_cd", SumCols:sumNmVal, Sort:1, ShowCumulate:0, CaptionCol:"agmt_no", CaptionText:"Sub Total"}
				];
				
				ShowSubSum(info);
                

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
 	        // Form Object value setting
	    	formObj.f_cmd.value=SEARCH;
	 		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
	 		if(formObj.include_np.checked){
	 			formObj.include_np.value="Y";
	 		} else {
	 			formObj.include_np.value="";
	 		}
	 		
	 		if(!ComIsEmpty(combo_location.GetSelectCode())) {
	 			formObj.location.value = combo_location.GetSelectCode();
	 		}
	 		
	 		// retrieve
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);
		 		var sXml=sheetObj.GetSearchData("EES_CGM_1098GS.do" , FormQueryString(formObj));
	 			sheetObj.LoadSearchData(sXml,{Sync:1} );
	 			ComOpenWait(false);
	 		}
            break;
          case IBSEARCH_ASYNC01:	// Location Combo retrieve
       		formObj.f_cmd.value=SEARCH;
       		formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting (Location)
       		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
       		var sStr=ComGetEtcData(sXml,"comboList");    			
       		var arrStr=sStr.split("@");
       		// combo control, result string, Text Index, Code Index
       		makeComboObject(combo_location, arrStr, 1, 1, 0); //[fix] makeComboObject(formObj.location, arrStr, 1, 1, 0);
       		break;
          case IBSEARCH_ASYNC02:	// Yard  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.yd_cd.value=formObj.crnt_yd_cd.value;
		   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Yard');
		   		formObj.crnt_yd_cd.value="";
		   		formObj.crnt_yd_cd.focus();
		   	}
		   	break;     
	      case IBSEARCH_ASYNC08:
	       	//formObj.f_cmd.value = SEARCH;
	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	   		formObj.f_cmd.value=SEARCH17;
	    	var location=formObj.combo_location_text.value;
	    	//[fix] var location=formObj.location.text;
	    	if(location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="RCC";
	    		formObj.eq_orz_cht_rcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="LCC";
	    		formObj.eq_orz_cht_lcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="SCC";
	    		formObj.eq_orz_cht_scc_cd.value=formObj.crnt_loc_cd.value;
	    	}else
	    	{
	    		formObj.eq_orz_cht_chktype.value="";
	    		formObj.eq_orz_cht_scc_cd.value="";
	    	}
	    	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		// data count
	        var dataCount=ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.crnt_loc_cd.value="";
		   		//formObj.crnt_loc_cd.focus();
	        }
	        formObj.crnt_loc_cd.focus(); 
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
    		//Location
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
    		// combo control, result string, Text Index, Code Index
	  		makeComboObject(combo_location, arrStr1, 1, 1, 0);
	  		//[fix] makeComboObject(formObj.location, arrStr1, 1, 1, 0);       
    		idx++;        		
	  		break;	
	  		
    	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
        	formObj.f_cmd.value = SEARCH21;
    		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
			
			//getting changing column information from server
			oldCntrTypeSize = sCntrTypeSize;
			
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
    				if(crnt_loc_cd.value == ''){
    					ComShowCodeMessage('CGM10004','Location');
    					crnt_loc_cd.focus();
    					return false;
    				} else {
    					if(crnt_loc_cd.value.length != 5) 
    					{
    						ComShowCodeMessage('CGM10044','Location(5)');
    						crnt_loc_cd.focus();
    						return false;
    					}else
    					{
    					return true;
    				}
    				}
    				break;
    		}
    	}
    }
    /**
     * call back function. <br>
     * @param  {Array} aryPopupData	mandatory	 Array Object
     * @param  {Int} row				mandatoryselectedRow
     * @param  {Int} col				mandatoryselectedColumn
     * @param  {Int} sheetIdx			mandatory Sheet Index
     * @return 
     * @author 
     * @version
     */   
    function callBackLocation(aryPopupData, row, col, sheetIdx){
        var formObj=document.form;
        var location=formObj.combo_location_text.value;
        //[fix] var location=formObj.location.text;
        var crntLocCd="";
        var i=0;
        for(i=0; i < aryPopupData.length; i++){
        	if(location == 'RCC'){
        		crntLocCd=crntLocCd + aryPopupData[i][11];
        	} else if(location == 'LCC'){
        		crntLocCd=crntLocCd + aryPopupData[i][10];
        	} else if(location == 'SCC'){
        		crntLocCd=crntLocCd + aryPopupData[i][8];
        	}
        	if(i < aryPopupData.length - 1){
        		crntLocCd=crntLocCd + ",";
         	}
        }
        formObj.crnt_loc_cd.value=crntLocCd;
    }	 
    /**
     * call back function. <br>
     * @param  {Array} aryPopupData	mandatory	 Array Object
     * @param  {Int} row				mandatoryselectedRow
     * @param  {Int} col				mandatoryselectedColumn
     * @param  {Int} sheetIdx			mandatory Sheet Index
     * @return 
     * @author 
     * @version
     */   
    function callBackYard(aryPopupData, row, col, sheetIdx){
        var formObj=document.form;
        var crntYdCd="";
        var i=0;
        for(i=0; i < aryPopupData.length; i++){
        	crntYdCd=crntYdCd + aryPopupData[i][3];
        	if(i < aryPopupData.length - 1){
        		crntYdCd=crntYdCd + ",";
         	}
        }
        formObj.crnt_yd_cd.value=crntYdCd;
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
	function sheet1_OnChangeSum(sheetObj, Row )
	{
		
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
			SetSumText(0,"crnt_loc_cd","");
			SetSumText(0,"agmt_no","Grand Total");
			SetCellAlign(0, "agmt_no","Center");
		}
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
 /*function sheet1_OnMouseDown (Button, Shift, X, Y){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	 if(sheetObj.RowCount() + 1 == sheetObj.MouseRow())
	 {
		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
		 //var groupValue1 = sheetObj.GetCellValue(sheetObj.MouseRow, "group1");
		 //alert(groupValue1);
		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
	 }
 }*/
 function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
 	var eqKndCd=EQ_KND_CD_CHASSIS;
 	var location=comboObjects[0].GetSelectCode();
 	var crntLocCd=document.form.crnt_loc_cd.value;
 	var crntYdCd=document.form.crnt_yd_cd.value;
 	var includeNp="";
 	if(document.form.include_np.checked){
 		includeNp="Y";
 	}
 	var agmt_no=document.form.agmt_no.value;
 	var vndrSeq=document.form.vndr_seq.value;
	var eqTpszCd="";
	var colSaveName=sheetObj.ColSaveName(Col);
	
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
	
	var groupValue1=sheetObj.GetCellValue(Row, "crnt_loc_cd");
	var groupValue2=sheetObj.GetCellValue(Row, "agmt_no");
	var groupValue3=sheetObj.GetCellValue(Row, "vndr_seq");
	if(groupValue3.indexOf('(') != -1) {
		groupValue3=groupValue3.substring(groupValue3.indexOf('(')+1, groupValue3.length-1);
	}
  	var s2_group1="";
  	var s2_groupValue1="";
  	var s3_gtotal="";
  	if(groupValue2.substring(0,9) == "Sub Total")
  	{
		s2_group1="SubSum";
		s2_groupValue1=sheetObj.GetCellValue(Row-1, "crnt_loc_cd");
        groupValue1=s2_groupValue1;
  	}else if(groupValue2 == "Grand Total"){
  		s3_gtotal="GTOTAL";
  	}else{
  		s2_group1="";
  		s2_groupValue1="";
  	}
 	var param="?program_id=1098";
 	param=param + "&eq_knd_cd=" + eqKndCd;
 	param=param + "&location=" + location;
 	param=param + "&crnt_loc_cd=" + crntLocCd;
 	param=param + "&crnt_yd_cd=" + crntYdCd;
	param=param + "&eq_tpsz_cd=" + eqTpszCd;     	
 	param=param + "&include_np=" + includeNp;
 	param=param + "&agmt_no=" + agmt_no;
 	param=param + "&vndr_seq=" + vndrSeq;
	param=param + "&group_value1=" + groupValue1;
	param=param + "&group_value2=" + groupValue2;
	param=param + "&group_value3=" + groupValue3;
	//param = param + "&s_group1=" + group1; 
  	//param = param + "&s_group1_val=" + groupValue1;
  	param=param + "&s2_group1=" + s2_group1;
  	param=param + "&s2_group1_val=" + s2_groupValue1;
  	param=param + "&s3_gtotal=" + s3_gtotal;
 	//var LCC = sheetObj.GetCellValue(Row, "crnt_loc_cd");
 	if(Col >= 3) // && LCC != '')
    {
    	ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 900, 550, "", "1,0", true, false);
    }else
    {
    	ComShowCodeMessage('CGM10016');
    }
 }          
/**
 * Location Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.crnt_loc_cd.value="";
	var sheetObj=sheetObjects[0];
	if(newCode == "RCC")
	{
		sheetObj.SetCellValue(0, "crnt_loc_cd", "RCC");  
	}else if(newCode == "LCC")
	{
		sheetObj.SetCellValue(0, "crnt_loc_cd", "LCC");
	}else if(newCode == "SCC")
	{
		sheetObj.SetCellValue(0, "crnt_loc_cd", "Yard");
	}
//	document.form.combo_location_text.value = newCode;
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
	//ComChkObjValid(ComGetEvent());
 }
   function setAgmtNo(aryPopupData, row, col, sheetIdx){
  	 var formObj=document.form;
   	 var agmtNo="";
   	 var i=0;
   	 for(i=0; i < aryPopupData.length; i++){
   		 agmtNo=agmtNo + aryPopupData[i][2];
   		 if(i < aryPopupData.length - 1){
   			 agmtNo=agmtNo + ",";
   		 }
   	 }
   	  formObj.agmt_no.value=agmtNo;
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
	 obj=ComGetEvent();
	 switch(ComGetEvent("name")){
	 	case "crnt_yd_cd":
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
 	switch(comboObj.id) {
    	case "location":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(100);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  	            SetEnable(1);
  	            SetUseAutoComplete(1);
  	        }
  	        break;
 	}
 }       
 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	if(opt == 0) {
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	cmbObj.SetSelectIndex(0);
 }  
	/* developer job end */
