/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_5002.js
*@FileTitle  : Invoice Interface to A/R
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================**/

/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    
   	/*  Developer's task	*/

	//  Common global variable

	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var comboObjects=new Array();
	var comboCnt=0;
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type";	
	var ROWMARK="|";
	var FIELDMARK="=";
	var PERIOD_GAP=15;
	var USR_TRF_TP;
	
 	//Event handler processing by button click event */
	document.onclick=processButtonClick;
 	//Event handler processing by button name */
	function processButtonClick(){
 	 /*****Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
 	 /*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
	         	case "btns_calendar": //calendar button
			            var cal=new ComCalendarFromTo();
			            cal.select(formObj.fm_dt,  formObj.to_dt,  'yyyy-MM-dd');
					break;
	 			case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
					var totRowCnt=sheetObject1.RowCount();
					break;
	 			case "btn_new":
	 				//Form.reset(), IBSheet.RemoveAll() processing. 
	 				//in case of IBMultiCombo id="myCombo" => "initComboValue_myCombo()"
	 				ComResetAll();
 					doInit();	// Lookup initialization conditions
 					buttonMode("NEW");
 					break;
 				case "btn_minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						DmtComShowObject(schCondDiv,  false);
 						sheetObject1.SetSheetHeight(430+124);
 					} else {
 						DmtComShowObject(schCondDiv,  true);
 						sheetObject1.SetSheetHeight(430);
 					}
 					break;	 	
	 			case "btn_detail":
	 				var totRowCnt=sheetObject1.RowCount();
	    			if(totRowCnt > 0){
	    				if(ComIsBtnEnable(srcName)) {
							openPopupWindow(sheetObject1, formObj, srcName);
						}
	    			} 
	 				break;
	 			case "btn_downexcel": 	
	 				if(sheetObject1.RowCount() < 1){//no data						
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}	 				
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
     * IRegister as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	//Page generated in the comboObjects IBCombo Object Properties in an array
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
	 	//khlee-Preferences change the name of the function to start	 		
	 		ComConfigSheet (sheetObjects[i] );	 		
	 		initSheet(sheetObjects[i],i+1);
	 	//khlee-The final configuration functions added	 		
	 		ComEndConfigSheet(sheetObjects[i]);
	 	}
		// IBMultiCombo Initialization
		for(var k=0;k<comboObjects.length;k++){			
			initCombo(comboObjects[k],k+1);			
		}		
		//html control event Initialization
		initControl();		
		//office.SetBackColor("#e9f4ff");
		//tariff_type.SetBackColor("#e9f4ff");		
		sheet1_OnLoadFinish();	
	}	
	
  	/**
 	 * BUTTON MODE
 	 */
 	function buttonMode(mode) {
 		 var formObj=document.form;
 		 with (formObj) {
 			 if(mode == "NEW"){
 				DmtComEnableManyBtns(false, "btn_detail", "btn_downexcel");
 			 }else if(mode == "RETRIEVE"){
 				DmtComEnableManyBtns(true,  "btn_detail", "btn_downexcel");
 			 } 
 		 }
 	}
    /**
     * HTML tags received as arguments (Object) by changing the properties of the obj.style.display displayed on the screen which changes whether. <br>
     * Tab forms mainly when using the div tag should use this function. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComShowObject(txtName,  true);   // result : show txtName control
     *     ComShowObject(txtName,  false);  // result : hide txtName control
     * </pre>
     * @param {object} obj     Required,Target HTML tags(Object)
     * @param {bool}   bShow   Required,The visibility to true / false Set.
     * @return 없음
     * @see #ComShowManyObjects
     */
	function DmtComShowObject(obj, bShow) {
        try {
            if (bShow) {
                obj.style.display="block";
            } else {
                obj.style.display="none";
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- focus out
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //id jsp name next to the additional ex)name="btn_retrieve" id="btn_Retrieve"
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	function condType_click() {
		doEnableCondObj(ComGetEvent("value"));
	}
	function obj_blur(){
		var obj=event.srcElement;
        var objName=obj.name;
        
        if(objName == 'cust_cd') {
        	 doActionText(sheetObjects[0], document.form, obj, SEARCH20);
         }
	}

	/**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
	function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
		 switch(sheetNo) {
		 	case 1:      // sheet1 init
		 	    with(sheetObj){				        
				      //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				      var HeadTitle="|Seq.|Payer|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|Payer Name|payerFlg";
				      var headCount=ComCountHeadTitle(HeadTitle);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_cnt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"tax_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"payer_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"payer_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				       
				      InitColumns(cols);		
				      //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
				      SetToolTipText(0,"inv_cnt","Count of Invoices");
				      SetSheetHeight(430);
		      	}
            	break;
	        }
	    }
	 /**
  	 * Combo basic setting 
  	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
  	 * If the case dasuil combo combo by adding the number of seats will initialize the module configuration
  	 */ 
	function initCombo(comboObj, comboNo) {
  	    var formObject=document.form
  	    switch(comboObj.options.id) {
  	    	case "office": 
	        	with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "65");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2);		// upper case
  					//no support[check again]CLT 					IMEMode=0;
		    	}  	        	  
				break;   	    
  	    	case "tariff_type": 
  	        	with (comboObj) { 
					SetMultiSelect(1);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					SetMultiSeparator(",");
  					ValidChar(2);		// upper case
  					//no support[check again]CLT 					IMEMode=0;
  		    	}
  	        	break;
  	     } 
	}		 
  	/**
 	 * Combo Treatment-related processes
 	 */	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		switch(sAction) {
	 		//Tariff type comboList
	 		case IBSEARCH_ASYNC02:     
	 			//var sComboObj=comboObjects[1];	 			
				formObj.f_cmd.value=SEARCHLIST;  				
				var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));				
				sComboObj.RemoveAll();
				var data=ComGetEtcData(xmlStr, COMMON_TARIFF_CD);				
				if (data != undefined && data != '') {					
					var comboItems=data.split(ROWMARK);					
					addComboItem(sComboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);					
				}	
				var data2=ComGetEtcData(xmlStr, USER_TARIFF_TYPE);				
				//User Setup Tariff Type Default value in the absence of.
				if(data2 == ''){
					data2='CTIC,DMIF';
					//sComboObj.SetItemCheck(1,1); //add
					//sComboObj.SetItemCheck(5,1); //add
				}
				sComboObj.SetSelectCode(data2,false);
				USR_TRF_TP=data2;
				formObj.usr_trf_tp.value=data2;		
				with (sComboObj) {	                
					SetMultiSeparator(",");	                 
				}
				break;
     		//Office comboList	
     		case IBSEARCH_ASYNC01:    
 				formObj.f_cmd.value=SEARCHLIST02;  	    	    
 				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj)); 				
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
 		    	    var comboCodeArr=ofc_cds.split("|");			    	    
 		    	    var comboTextArr=ofc_nms.split("|");
 		    	    for (var i=0 ; i < comboTextArr.length ; i++) {
 		    	    	sComboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
 		         	}
 	    	    }
 	    	    // Login User Office is Default - Displayed when there is no item in the list by adding
    	  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
    	  		sComboObj.SetSelectCode(usr_ofc_cd);
    	  		if(sComboObj.GetSelectCode()!= usr_ofc_cd) {
    	  			sComboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
    	  			sComboObj.SetSelectCode(usr_ofc_cd);
    	  		}
 	    	    break; 	    	
         }
 		sheetObj.SetWaitImageVisible(1);
     }	
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var comboID=comboObj.options.id;
 		switch(comboID) {		
 			case "tariff_type":
 				comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
 			   	break;
 		} 		
 	}
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	 		case IBSEARCH:      //retrieving
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}				
	 		    //ComOpenWait Start
			 	sheetObj.SetWaitImageVisible(0);
			 	ComOpenWait(true);
			 	formObj.f_cmd.value=SEARCH;  				
			 	sheetObj.DoSearch("EES_DMT_5002GS.do",	FormQueryString(formObj) );
 				//ComOpenWait End
				ComOpenWait(false);
	 			break;
		}
	}
	//no support[check again]CLT 	
	function sheet1_OnLoadFinish() {   
		var formObject=document.form
		sheetObjects[0].SetWaitImageVisible(0);
		//OPEN Screen call		
      	doInit();
      	sheetObjects[0].SetWaitImageVisible(1);
	}  
	function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg){
		with(sheetObj){
			//Flag is Y, Payer CD delt with separately tooltip status..
//			if ( RowCount()<= 0 ) { return; }
			if(RowCount() <= 0) {
				DmtComEnableManyBtns(false, "btn_detail", "btn_downexcel");
				return;
			}
			DmtComEnableManyBtns(true, "btn_detail", "btn_downexcel");
            for ( var i=1 ; i < LastRow(); i++ ) {
            	if ( GetCellValue( i , "payer_flg" ) == "Y" ) {
                    SetToolTipText( i , "payer_cd" ,"Customer Code not available any more");                     
                    SetCellFontColor( i , "payer_cd" ,"#DC0000");
                }
            } 			
            SetSumText(0, "seq","TTL");
		}
	}
	/**
 	 * INIT SETTING
 	 */
	function doInit() {
 		var formObj=document.form;
 		with (formObj) {
	 		//combo reset 			
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);			
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);			
			doEnableCondObj("date");
			chk_hold_box.checked=false;
			ComClearManyObjects(chk_hold, ofc_cd, dmdt_trf_cd, cust_cd, cust_nm, s_cust_gubun, s_cust_cd);
			buttonMode("NEW");
			sheetObjects[0].RemoveAll();
 		}
 	}
 	function doEnableCondObj(condType) {
 		var formObj=document.form;
 		with (formObj) {
 			switch(condType){
 			 	case "date":
 			 		//date
 			 		ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
 			 		DmtComSetClassManyObjects('input1', fm_dt, to_dt); 
 					// The initial set of date values (Today's date in six months- Today's date)
 			 		var sheetObj=sheetObjects[0];
 			 		var formObj=document.form;
 					//Users of Office should look up the current date.
 					var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj); 
 					//Viewed in the field of the screen allows you to map date.
 					ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -6)); //A date earlier than 6 months.
 					ComSetObjValue(formObj.to_dt,   ofcCurrDate); 
 			 		//inv
 			 		ComEnableManyObjects(false, bkg_no, bl_no, inv_no, btns_bkg_multisearch, btns_bl_multisearch, btns_inv_multisearch);
 			 		ComClearManyObjects(bkg_no, bl_no, inv_no);		
 			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, inv_no); 
 			 		break;
 			 	case "inv":
 			 		//date
 			 		ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
 			 		DmtComSetClassManyObjects('input2', fm_dt, to_dt); 		
 			 		ComClearManyObjects(fm_dt, to_dt);
 			 		//inv
 			 		ComEnableManyObjects(true, bkg_no, bl_no, inv_no, btns_bkg_multisearch, btns_bl_multisearch, btns_inv_multisearch);
 			 		ComClearManyObjects(bkg_no, bl_no, inv_no);		
 			 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, inv_no);
 			 		break;
 			}
 		} // end of the with (formObj) 
 	} 	 
 	/*
  	 * Each common pop-up function calls 
  	 */
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'bkg_no':		// BKG No. Multi-Input pop-up calls
	  			case 'bl_no':		// B/L No. Multi-Input pop-up calls
	  			case 'inv_no':		// INV No. Multi-Input pop-up calls
		  			var returntitle='';
	  				var sWidth  = 0;
	  				var sHeight = 415;		  			
	  				if(flag == 'bkg_no'){
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 'bl_no'){
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 'inv_no'){
	  					returntitle='INV No.';
	  					sWidth = 420;
	  				}
					var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				//ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
					break;
	  		} // switch-end
  		} // with-end
  		if(sUrl.indexOf('.do') != -1) {
  			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} 
  		else if(sUrl != '') {
  			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
  		}
  	}
    /*
  	 * Customer Code Customer common values ​​selected in the pop-up settings in the appropriate fields 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
        document.form.cust_nm.value=aryPopupData[0][4];
    }
	//Customer check
	function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd)));
//        alert(cust_len);
        if(cust_len == 0){
        	ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
        	return;
        }
        if(cust_len > 2) {
			var char_chk=ComGetObjValue(formObj.cust_cd).substring(0,2);
			//If the CUSTOMER is a two-digit alphanumeric views
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			//VENDOR or query
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
            ComSetFocus(formObj.cust_cd);
			return;
		}
        ComSetObjValue(formObj.f_cmd, formCmd);         
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd=ComGetEtcData(sXml, "PAYER_CODE");
        var custNm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.cust_cd);
            document.form.s_cust_gubun.value="";
            document.form.cust_cd.value="";
            document.form.cust_nm.value="";   
            ComShowCodeMessage("DMT00165", "Payer");
        } else {
        	document.form.cust_nm.value=custNm;
            document.form.cust_cd.value=custCd;
        }
        sheetObj.SetWaitImageVisible(1);
    } 	 
	/*
	 * Multi-input pop-up page is closed, then the function is invoked Opener
	 * - Multi-input allows you to set the appropriate fields.
	 */
	function getDmt_Multi(rArray, return_val) {
    	var targObj=eval("document.form." + return_val);
    	var retStr=rArray.toString().toUpperCase();
    	ComSetObjValue(targObj, retStr);
	}  	
	
	var selComboIndex, selComboCode;
	 function tariff_type_OnSelect(comboObj ,index, code) {
	  selComboIndex = index;
	  selComboCode = code;
	 }
	 function tariff_type_OnChange(comboObj) {
	     setMultiCombo(comboObj, selComboIndex, selComboCode);
	 }

	// caller: ComResetAll After the call to apply under.
   	// IBMultiCombo Office Initialization
   	function initComboValue_office() {
   		comboObjects[0].SetEnable(1);
   		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
   	}
   	// IBMultiCombo Tariff Type Initialization
   	function initComboValue_tariff_type() {
   		document.form.usr_trf_tp.value=USR_TRF_TP;
   		comboObjects[1].SetEnable(1);
   		ComSetObjValue(comboObjects[1], document.form.usr_trf_tp.value);
   	}
	/**
	 * Screen input form validation process for handling
	 */
	function validateForm(sheetObj,formObj,sAction)
	{
		 with(formObj){
	     		// office Combo Check
	     		//2010.02.22 OFFICE  to be viewed without Code. Code -> Corrected to Text
	     		if(comboObjects[0].GetSelectText()== '') {
	     			ComShowCodeMessage('COM12113', "Office CD");
	     			return false;
	     		}
			 	// Tariff Type Combo Check
	     		if(comboObjects[1].GetSelectCode()== '') {
	     			ComShowCodeMessage('COM12113', "Tariff Type");
	     			return false;
	     		}
			 	//check Or.
			 	ComSetObjValue(chk_hold, "");  //For re-referral  clear.
	     		if(chk_hold_box.checked){
	     			ComSetObjValue(chk_hold, "Y");
	     		} else {
	     			ComSetObjValue(chk_hold, "N");
	     		}
	     		var condType=ComGetObjValue(cond_type);
	     		//******************** Date condition  ************************
	     		if(condType == 'date') {
	     			if(!ComIsDate(fm_dt)) {
	     				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
	     				return false;
	     			}
	     			if(!ComIsDate(to_dt)) {
	     				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
	     				return false;
	     			}
	                if (ComChkPeriod(fm_dt.value, to_dt.value) <= 0){
	        			ComShowCodeMessage('DMT01020');
	        			return false;
	        		} 
	     		//******************** INV condition  ************************	
	     		} else if(condType == 'inv') {
	     			if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(inv_no)) {
	     				ComShowCodeMessage('DMT00102', 'INV No. or BKG No. or B/L No.');
	         			return false;
	 				}
	     			var invNo=ComGetObjValue(inv_no);
	     			if(invNo != '') {
	     				var arrInvNo=invNo.split(',');
	     				for(var i=0; i<arrInvNo.length; i++) {
	     					if(ComChkLen(arrInvNo[i], 9) != 2) {	// Length exceeds
	     						ComAlertFocus(inv_no, ComGetMsg('COM12173', 'INV No.', '9'));
	                 			return false;
	     					}
	     				}
	     			}
	     			var bkgNo=ComGetObjValue(bkg_no);
	     			if(bkgNo != '') {
	     				var arrBkgNo=bkgNo.split(',');
	     				for(var i=0; i<arrBkgNo.length; i++) {
	     					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
	     						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
	                 			return false;
	     					}
	     				}
	     			}
	     			var blNo=ComGetObjValue(bl_no);
	     			if(blNo != '') {
	     				var arrBlNo=blNo.split(',');
	     				for(var i=0; i<arrBlNo.length; i++) {
	     					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
	     						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
	                 			return false;
	     					}
	     				}
	     			}
	     		}
	     		//Major Required Information Set.
//				ComSetObjValue(ofc_cd, 			comboObjects[0].Code);
				ComSetObjValue(ofc_cd, 			comboObjects[0].GetSelectText());
				ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].GetSelectCode());
		} // end of the with clause
		return true;
	}
	/*
	 * Double-click pop-up(5003)
	 */
 	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
 		var formObj=document.form;
 		//hold Whether the button authority / If you have permission to hold the button showing / hiding the other of the button itself
		var holdAuth="";
// 2011.02.14. HOLD Do not show		
//		if(holdAuthority(ComGetObjValue(formObj.usr_ofc_cd))){
//			holdAuth = "Y";
//		} else {
			holdAuth="N";
//		}
 		ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].GetSelectCode());
		ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].GetSelectCode());
		var url="EES_DMT_5003.do"
 			+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
 			+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
 			+"&chk_hold="+ComGetObjValue(formObj.chk_hold)
 			+"&cond_type="+ComGetObjValue(formObj.cond_type)
 			+"&fm_dt="+ComGetObjValue(formObj.fm_dt)
 			+"&to_dt="+ComGetObjValue(formObj.to_dt)
 			+"&inv_no="+ComGetObjValue(formObj.inv_no)
 			+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
 			+"&bl_no="+ComGetObjValue(formObj.bl_no)
 			+"&sh_cust_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "payer_cd")
 			+"&sh_cust_nm="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "payer_nm")
 			+"&sh_inv_curr_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "inv_curr_cd")
 			+"&hold_auth="+holdAuth
 			;
		ComOpenPopup(url, "1100", "700", "fnCallProc", "0,1", true);
// 		var returnValue=ComOpenWindowCenter(url, "EES_DMT_5003", "940","705", true);
// 		if(returnValue == "Y") {
// 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
// 		}
 	}  
	/**
	 * EES_DMT_5003 Pop-up call
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
 		 if(srcName == "btn_detail") {
// 		 	/hold Whether the button authority / If you have permission to hold the button showing / hiding the other of the button itself
 			var holdAuth="";
// 			2011.02.14. HOLD Do not show 			
// 			if(holdAuthority(ComGetObjValue(formObj.usr_ofc_cd))){
// 				holdAuth = "Y";
// 			} else {
 				holdAuth="N";
// 			}
	 		ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].GetSelectCode());
			ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].GetSelectCode());
			var url="EES_DMT_5003.do"
	 			+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
	 			+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
	 			+"&chk_hold="+ComGetObjValue(formObj.chk_hold)
	 			+"&cond_type="+ComGetObjValue(formObj.cond_type)
	 			+"&fm_dt="+ComGetObjValue(formObj.fm_dt)
	 			+"&to_dt="+ComGetObjValue(formObj.to_dt)
	 			+"&inv_no="+ComGetObjValue(formObj.inv_no)
	 			+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
	 			+"&bl_no="+ComGetObjValue(formObj.bl_no)
	 			+"&sh_cust_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "payer_cd")
	 			+"&sh_cust_nm="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "payer_nm")
	 			+"&sh_inv_curr_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "inv_curr_cd")
	 			+"&hold_auth="+holdAuth
	 			;
			ComOpenPopup(url, "1100", "700", "fnCallProc", "0,1", true);
//	 		var returnValue=ComOpenWindowCenter(url, "EES_DMT_5003", "940","705", true);
//	 		if (returnValue == "Y") {
//	 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//	 		}
 		 }
	} 
	
	function fnCallProc(rtnVal) {
		if (rtnVal == "Y") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/* developers work end */
