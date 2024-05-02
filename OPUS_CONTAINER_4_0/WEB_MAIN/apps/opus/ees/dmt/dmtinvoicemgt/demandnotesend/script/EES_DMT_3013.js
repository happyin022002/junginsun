/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3013.js
*@FileTitle  : Demand Note Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================**/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

   	/* Developer's task	*/

	//common global variables
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var comboObjects=new Array();
	var comboCnt=0;
	
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var PERIOD_GAP=15;
	var USR_TRF_TP="";
	
	var DEF_SHEET_HEIGHT = 380;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 145;
	//멀티콤보 이벤트 처리를 위한 전역변수
	var selComboIndex, selComboCode;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick(){
		/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		var srcObj=ComGetEvent();
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
	         	case "btns_calendar": 
		         //	if(srcObj.style.cursor == "hand") {
			            var cal=new ComCalendarFromTo();
			            cal.select(formObj.fm_mvmt_dt1,  formObj.to_mvmt_dt1,  'yyyy-MM-dd');
		         	//}
					break;
     			case "btn_retrieve":
 					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
 					break;
 				case "btn_new":
// 					//sheetObject1.RemoveAll();
// 					loadPage();
// 					/*ComResetAll();
// 					doInit();	
// 					buttonMode("NEW");*/
 					sheet1_OnLoadFinish();
 					break; 
 				case "btn_minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						DmtComShowObject(schCondDiv,  false);
 						sheetObject1.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} else {
 						DmtComShowObject(schCondDiv,  true);
 						sheetObject1.SetSheetHeight(DEF_SHEET_HEIGHT);
 					}
 					break;
				case "btn_demand":
					if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
					break;
				case "btn_grp_demand":
					if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
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
	
    function DmtComShowObject(obj, bShow) {
        try {
            if (bShow) {
                obj.style.display="block";
            } else {
                obj.style.display="none";
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	 /**
	  * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
	  */
	function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
     /**
      * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
      */
	function loadPage() {
		
		for(var i=0; i<sheetObjects.length; i++){    
			ComConfigSheet (sheetObjects[i] );    		 
			initSheet(sheetObjects[i],i+1);    		 
			ComEndConfigSheet(sheetObjects[i]);    		 
		}
		
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		sheet1_OnLoadFinish();    
		office.SetBackColor("#CCFFFD");
		tariff_type.SetBackColor("#CCFFFD");
		status01.SetBackColor("#CCFFFD");
		initControl();
	}
	
	function initControl() {
  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); 
  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form);
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form);
  		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
  		axon_event.addListener('click', 'condType_click', 'cond_type'); //date or vvd cd or cntr radio button
  		axon_event.addListener('click', 'locType_click', 'loc_type'); 	//location radio button
  		axon_event.addListener('click', 'chkAllOffice_click', 'chk_all_office'); 	//location radio button
		axon_event.addListener('mouseover', 'obj_mouseover', 'btn_demand', 'td_gb');
		axon_event.addListener('mouseout',	'obj_mouseout',	 'btn_demand', 'td_gb');	
	} 
	function obj_mouseover() {
 		var msg='';
 		var x=event.x+document.body.scrollLeft;
 		var y=event.y+document.body.scrollTop;
     	switch(event.srcElement.id){
      		case 'btn_demand':
      			msg="Demand Note Issue by Booking";
      			x=x;
      			y=y-20;
      			break;
      		case 'btn_grp_demand':
      			msg="Demand Note Issue by Tariff/Payer Group";
      			x=x;
      			y=y-20;
      			break;
      		case 'td_gb':
      			msg="General/Balance Charge Type";
      			x=x;
      			y=y-20;
      			break;
     	}
 		var bak='lightyellow';
 		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn=document.all("topdeck").style;
	 		skn.left=x;
	 		skn.top=y;
	 		document.all("topdeck").innerHTML=content;
	 		skn.visibility='visible';
	}
	function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
	//ALL OFFICE CHECK
	function grpType_change() {
		var formObj=document.form;
		var grpType=ComGetObjValue(formObj.grp_type);
		if(grpType == '1'){
			// in case of grp_type == 1 ->  B/L NO GROUPING
			sheetObjects[0].SetColHidden("cntr_qty",0);
			sheetObjects[0].SetColHidden("cntr_no",1);
			sheetObjects[0].SetColHidden("dmdt_chg_sts_cd",1);
			sheetObjects[0].SetColHidden("ofc_cd",0);
			sheetObjects[0].SetColHidden("fm_mvmt_yd_cd",0);
		} else if(grpType == '2'){
			// in case of grp_type == 12 -> CNTR NO
			sheetObjects[0].SetColHidden("cntr_qty",1);
			sheetObjects[0].SetColHidden("cntr_no",0);
			sheetObjects[0].SetColHidden("dmdt_chg_sts_cd",0);
			sheetObjects[0].SetColHidden("ofc_cd",0);
			sheetObjects[0].SetColHidden("fm_mvmt_yd_cd",0);
		}
	}
	//ALL OFFICE CHECK
	function chkAllOffice_click() {
		var formObj=document.form;
		with (formObj) {
			if(chk_all_office.checked){
				comboObjects[0].SetEnable(0);
				ComSetObjValue(ofc_cd, 	comboObjects[0].GetSelectCode());
				comboObjects[0].SetSelectCode('');
//				comboObjects[0].Text = '';
				DmtComSetClassManyObjects('input1', port_cd); 	
			} else {
				comboObjects[0].SetEnable(1);
				comboObjects[0].SetSelectCode(ComGetObjValue(ofc_cd));
				ComSetObjValue(ofc_cd, "");
				DmtComSetClassManyObjects('input', port_cd);
			}
		}
	}
	//LOCATION CHECK
	function locType_click() {
		doEnableLocTypeObj(event.srcElement.value);
	}
	function doEnableLocTypeObj(condType) {
		var formObj=document.form;
		with (formObj) {
			switch(condType){
			 	case "1":
			 		//from yard
			 		comboObjects[3].SetEnable(1);
			 		break;
			 	case "2":
			 		//por/del
			 		comboObjects[3].SetEnable(0);
			 		ComClearManyObjects(yd_cd1);
			 		//comboObjects[3].RemoveAll(); 
			 		comboObjects[3].SetSelectText('');
			 		break;
			}
		} // end of the with (formObj) 
	}
	function condType_click() {
	   	 doEnableCondObj(event.srcElement.value);
    }
	function doEnableCondObj(condType) {
		var formObj=document.form;
		with (formObj) {
			switch(condType){				
			 	case "date":
			 		//date
			 		ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1); 		
			 		DmtComSetClassManyObjects('input', yd_cd); 
			 		ComSetObjValue(cond_type, "date"); //from yard : 1, por/del : 2
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		comboObjects[3].SetEnable(1);
	    	 		comboObjects[3].RemoveAll();
//			 		comboObjects[2].SetEnable(1);
					var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj); 
					ComSetObjValue(formObj.fm_mvmt_dt1, 	ComGetDateAdd(ofcCurrDate, "D", -15)); 
					ComSetObjValue(formObj.to_mvmt_dt1,   ofcCurrDate); 
			 		//vvd_cd
			 		ComEnableManyObjects(false, vvd_cd, port_cd, chk_all_office);	
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input2', vvd_cd, port_cd); 
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked=false;
		    		}
			 		//cntr
			 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, cntr_no); 
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			 	case "vvd_cd":
			 		//date
			 		ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1, yd_cd); 		
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, yd_cd);
			 		comboObjects[3].SetEnable(0);
	    	 		comboObjects[3].RemoveAll();
			 		//vvd_cd
			 		ComEnableManyObjects(true, vvd_cd, port_cd, chk_all_office);
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input1', vvd_cd);
			 		DmtComSetClassManyObjects('input', port_cd);
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked=false;
		    		}
			 		//cntr
			 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);	
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input2', bkg_no, bl_no, cntr_no); 
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			 	case "cntr":
			 		//date
			 		ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar, loc_type[0], loc_type[1], yd_cd);
			 		DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1, yd_cd); 		
			 		ComSetObjValue(loc_type, "1"); //from yard : 1, por/del : 2
			 		ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1, yd_cd);
			 		comboObjects[3].SetEnable(0);
	    	 		comboObjects[3].RemoveAll();
			 		//vvd_cd
			 		ComEnableManyObjects(false, vvd_cd, port_cd, chk_all_office);	
			 		ComClearManyObjects(vvd_cd, port_cd);		
			 		DmtComSetClassManyObjects('input2', vvd_cd, port_cd);
			 		if(chk_all_office.checked) {
			 			chk_all_office.checked=false;
		    		}
			 		//cntr
			 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no, btns_bkg_multisearch, btns_bl_multisearch, btns_cntr_multisearch);
			 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		
			 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no);
			 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
			 		//reset status combo list
			 		setStatusCombo(condType);
			 		break;
			}
			if(condType == 'date') {
				var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj); 
				ComSetObjValue(formObj.fm_mvmt_dt1,   ComGetDateAdd(ofcCurrDate, "D", -15)); 
				ComSetObjValue(formObj.to_mvmt_dt1,   ofcCurrDate);  
			}
			comboObjects[0].SetEnable(1);
			if(ComGetObjValue(ofc_cd) != ''){
				comboObjects[0].SetSelectCode(ComGetObjValue(ofc_cd));
				ComSetObjValue(ofc_cd, "");
			}
//			if(ComGetObjValue(dmdt_chg_sts_cd) != ''){
//				comboObjects[2].Code = ComGetObjValue(dmdt_chg_sts_cd);
//				ComSetObjValue(dmdt_chg_sts_cd, "");
//			}
		} // end of the with (formObj) 
	}
	//reset status combo list
	function setStatusCombo(condType) {
		var comboObj=comboObjects[2];
		var orgCode=comboObj.GetSelectCode();
   	 	if(condType=='date') {
   	 		if(comboObj.GetItemCount() != 7) {
   	 			comboObj.RemoveAll();
   	 			initCombo(comboObj, 3);
   	 		}
   	 	} else {
   	 		if(comboObj.GetItemCount() != 6) {
   	 			comboObj.RemoveAll();
   	 			initCombo(comboObj, 4);
	   	 		if(orgCode.indexOf('R') != -1) {
					 orgCode=ComReplaceStr(orgCode, 'R', 'L');
					 if(orgCode == 'F,U,C,I,L'){
						 orgCode='A,F,U,C,I,L';
					 }
				 }
   	 		}
   	 	}
   	 	comboObj.SetSelectCode(orgCode);
    }
	function status_OnCheckClick(comboObj, index, code) {
		var codes=comboObj.GetSelectCode();
		if(codes.indexOf('L')!=-1 && codes.indexOf('R')!=-1) {
			ComShowCodeMessage('DMT01067');
			comboObj.SetItemCheck(index,0);
			return;
		}
		var formObj=document.form;
		with (formObj) {
			if(index == 0) {
				if(comboObj.GetItemCheck(0)){	// All
					comboObj.SetSelectCode("A,F,L,U,C,I");
				}else{
					comboObj.SetSelectCode('');
				}
			} else if(comboObj.GetItemCheck(0)) {
				comboObj.SetItemCheck(0,0);
			} else if(codes == 'F,L,U,C,I') {
				comboObj.SetItemCheck(0,1);
			}
			if(codes == '' || codes == 'R') {	
				ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
				DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
			} else {
				if(ComGetObjValue(cond_type) == 'date') {
					ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1, btns_calendar);
					DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
				}
			}
		}
	}
   	// IBMultiCombo Office initializing
   	function initComboValue_office() {
   		comboObjects[0].SetEnable(1);
   		ComSetObjValue(comboObjects[0], document.form.usr_ofc_cd.value);
   	}
   	// IBMultiCombo Tariff Type initializing
   	function initComboValue_tariff_type() {
   		document.form.usr_trf_tp.value=USR_TRF_TP;
   		comboObjects[1].SetEnable(1);
   		ComSetObjValue(comboObjects[1], document.form.usr_trf_tp.value);
   	}
   	// IBMultiCombo Status initializing
   	function initComboValue_status() {
   		comboObjects[2].SetEnable(1);
   		ComSetObjValue(comboObjects[2], "F");
   	}
	// IBMultiCombo YardCode2 initializing
   	function initComboValue_yd_cd2() {
   		comboObjects[3].RemoveAll();
   	}
    function obj_blur(){
        var obj=event.srcElement;
        if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
        } else if(obj.name == 'yd_cd' || obj.name == 'port_cd') {
        	if(obj.value.length > 0 && obj.value.length < 5) {
        		var cdDiv=(obj.name == 'yd_cd') ? 'Yard' : 'Location';
        		ComShowCodeMessage('DMT00110', cdDiv);
        		if(obj.name == 'yd_cd'){
        			document.form.yd_cd.value="";
        		} else {
        			document.form.port_cd.value="";
        		}
        	}
        } else {
        	ComChkObjValid(obj);
        }
	}
    /**
     * HTML Control Foucs in
     */
	function obj_focus(){
		var obj=event.srcElement;
		ComClearSeparator(obj);
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
	    		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
	    	case "engup2":
	    		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
	    	case "int":
		        ComKeyOnlyNumber(event.srcElement,"-.");//&lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
		        break;
		    default:
	            ComKeyOnlyNumber(event.srcElement);
		}
    }  
	function obj_keyup() {
		var srcObj=event.srcElement;
		checkLocYdCd(srcObj);
	}
	function checkLocYdCd(srcObj) {
		var formObj=document.form;
		var cd=ComTrim(ComGetObjValue(srcObj));
		if (cd.length == 5) {
			var comboObj=comboObjects[3];
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				if(comboObj.GetItemCount() == 0) {
					formObj.loc_cd.value=cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.port_cd);
				}
			} else {
					formObj.loc_cd.value=cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
		}
	}	 
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
    }
    function getSvcProvdr(aryPopupData) {
    	document.form.svc_provdr.value=aryPopupData[0][2];
    }	 
	function getDmt_Multi(rArray, return_val) {
     	var targObj=eval("document.form." + return_val);
     	var retStr=rArray.toString().toUpperCase();
     	ComSetObjValue(targObj, retStr);
	}  	
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 485, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'svc_provdr':	// Service Provider Popup
					ComOpenPopup('COM_ENS_0C1.do', 700, 536, "getSvcProvdr", "1,0,1,1,1,1,0", true);//COM_ENS_0C1
					break;
	  			case 'bkg_no':		
	  			case 'bl_no':		
	  			case 'cntr_no':	
	  				var returntitle = '';
	  				var sWidth  = 0;
	  				var sHeight = 431;
	  				if (flag == 'bkg_no') {
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 'bl_no') {
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 'cntr_no') {
	  					returntitle='CNTR No.';
	  					sWidth = 437;
	  				}
					var param="?returnval=" + flag + "&returntitle=" + returntitle;
					ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl.indexOf('.do') != -1) {
  			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		}else if(sUrl != '') {
  			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
  		}
  	}
  	/**
 	 * BUTTON MODE
 	 */
 	function buttonMode(mode) {
 		 var formObj=document.form;
 		 with (formObj) {
 			 if(mode == "NEW"){
 				 DmtComEnableManyBtns(true,  "btn_retrieve", "btn_new", "btn_minimize");
 				DmtComEnableManyBtns(false, "btn_demand", "btn_grp_demand", "btn_downexcel");
 			 }else if(mode == "RETRIEVE"){
 				 DmtComEnableManyBtns(true,  "btn_retrieve", "btn_new");
 				DmtComEnableManyBtns(true,  "btn_minimize", "btn_demand", "btn_grp_demand", "btn_downexcel");
 			 } 
 		 }
 	} 
	 /**
   	 * Combo basic setting
   	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
   	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration 
   	 */ 
	function initCombo(comboObj, comboNo) {
   		 var formObj=document.form;
   		 switch(comboObj.options.id) {  
   	    	case "office": 
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "65");
   					SetColWidth(1, "250");
  					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2);	
					SetMaxLength(6);
   		    	}
   				break; 
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "45");
   					SetColWidth(1, "310");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
   		    	}
   				break; 
   	    	case "status01":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
					if(comboNo==3) {
						
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "110");
						SetColWidth(1, "150");
						SetColBackColor(0,"#CCFFFD");
	  					SetColBackColor(1,"#CCFFFD");
					} else{
						SetColAlign(0, "left");
						SetColWidth(0, "110");
   						SetColBackColor(0,"#CCFFFD");
					}
					//SetDropHeight(160);
					addComboItem(comboObj, comboNo);
//					Code = "F";
   		    	}
   	    		break;
   	    	case "yd_cd2":
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
  					SetUseAutoComplete(1);
  					SetColAlign(0, "left");
  					SetColWidth(0, "50");
  					SetDropHeight(160);
   		    	}
   	    		break;
   		 }
	}	 
	 /**
  	  * INIT SETTING
  	  */
	function doInit() {
  		var formObj=document.form;
//		var data = getDefaultDate(PERIOD_GAP).split("|");
//		formObj.fm_mvmt_dt1.value = data[1];
//		formObj.to_mvmt_dt1.value = data[0];
  		
  
		doEnableCondObj("date");
		sheetObjects[0].SetColHidden("cntr_qty",0);
		sheetObjects[0].SetColHidden("cntr_no",1);
		sheetObjects[0].SetColHidden("dmdt_chg_sts_cd",1);
		sheetObjects[0].SetColHidden("ofc_cd",1);
		sheetObjects[0].SetColHidden("fm_mvmt_yd_cd",1);
		comboObjects[2].SetSelectCode('F');
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
		    	      //no support[check again]CLT MultiSelection=true;
		    	      SetSelectionMode(smSelectionList);
		    	      var HeadTitle="||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|STS|Office|From YD|BKG DEL|Tariff|Payer|Payer|S/C No.|RFA No.|Invoice|Invoice|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd";
		    	      var HeadTitle1="||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|STS|Office|From YD|BKG DEL|Tariff|Code|Name|S/C No.|RFA No.|Cur.|Billing AMT|inv_org_amt|inv_dc_amt|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd";
		    	      var headCount=ComCountHeadTitle(HeadTitle);
		    	      var headCount1=ComCountHeadTitle(HeadTitle1);
		    	      (headCount, 0, 0, true);
		
		    	      //SetConfig( { SearchMode:2, FrozenCol:savenamecol("cntr_qty"), MergeSheet:5, Page:20, DataRowMerge:1 } );
		    	      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		    	             {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk_box" },
		    	             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_org_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_dc_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"dc_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:7,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		    	       
		    	      InitColumns(cols);		
		    	      SetEditable(1);
		    	      SetEllipsis(1);
		    	      FrozenCols=SaveNameCol("cntr_qty");
		    	      //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
		    	      SetToolTipText(0,"inv_curr_cd","Amount per A/R Office Currency");
		    	      SetToolTipText(0,"inv_chg_amt","Amount per A/R Office Currency");
		    	      SetToolTipText(1,"inv_curr_cd","Amount per A/R Office Currency");
		    	      SetToolTipText(1,"inv_chg_amt","Amount per A/R Office Currency");
		    	      SetSheetHeight(DEF_SHEET_HEIGHT);
    	      	}
                break;
    	  }
     }
   	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      
				
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				
				// Status 콤보의 동작을 공통함수로 제어함에 따라, Period 변수명 변경에 따른 추가조치
				ComSetObjValue(formObj.fm_dt, ComGetObjValue(formObj.fm_mvmt_dt1));
				ComSetObjValue(formObj.to_dt, ComGetObjValue(formObj.to_mvmt_dt1));
				
//				if (!validateDate(formObj)) {
//					return false
//				}
				grpType_change();
				//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;		
				
				sheetObj.DoSearch("EES_DMT_3013GS.do",	FormQueryString(formObj) );
 				break;
         }
	}
    /**
    * Screen input form validation process for handling
    */
	function validateForm(sheetObj,formObj,sAction){		
    	with(formObj){
			if(!chk_all_office.checked){
	     		if(comboObjects[0].GetSelectCode()== '') {
	     			ComShowCodeMessage('COM12113', "Office");
	     			return false;
	     		}
			} 
     		// Tariff Type Combo Check
     		if(comboObjects[1].GetSelectCode()== '') {
     			ComShowCodeMessage('COM12113', "Tariff Type");
     			return false;
     		}
     		// Status Combo Check
     		if(comboObjects[2].GetSelectCode()== '') {
     			ComShowCodeMessage('COM12113', "Status");
     			return false;
     		}
     		var condType=ComGetObjValue(cond_type);
     		if(condType == 'date') {
     			if(!ComIsDate(fm_mvmt_dt1)) {
     				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
     				return false;
     			}
     			if(!ComIsDate(to_mvmt_dt1)) {
     				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
     				return false;
     			}
                if(ComChkPeriod(fm_mvmt_dt1.value, to_mvmt_dt1.value) > 0){
        			if(ComGetDaysBetween(fm_mvmt_dt1.value, to_mvmt_dt1.value) > 31){
        				ComShowCodeMessage('DMT00162','1 Month');
        				return false;
        			}
        		} else if (ComChkPeriod(fm_mvmt_dt1.value, to_mvmt_dt1.value) <= 0){
        			ComShowCodeMessage('DMT01020');
        			return false;
        		} 
                var yardCd=ComGetObjValue(yd_cd);
                if( yardCd != '' && yardCd.length < 5 ) {
					ComAlertFocus(yd_cd, ComGetMsg('DMT00110', 'Yard'));
					return false;
	       		} 
     		} else if(condType == 'vvd_cd') {
     			if( ComChkLen(vvd_cd, 9) != 2) {	
     				//ComShowCodeMessage('DMT00102', "VVD CD");
     				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
 					return false;
     			}
     			var portCd=ComGetObjValue(port_cd);
     			if(chk_all_office.checked){
     				if(ComIsNull(portCd)){
     					ComShowCodeMessage('COM12113', "Port CD");
    	     			return false;
     				}
     			} 
     			if(!ComIsNull(portCd)){
     				if(ComChkLen(portCd, 5) != 2) {
     					ComAlertFocus(port_cd, ComGetMsg('DMT00119', 'Port', '5'));
     					return false;
     				}
     			}
     		} else if(condType == 'cntr') {
     			if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
     				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
         			return false;
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
     			var cntrNo=ComGetObjValue(cntr_no);
     			if(cntrNo != '') {
     				var arrCntrNo=cntrNo.split(',');
     				for(var i=0; i<arrCntrNo.length; i++) {
     					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// 길이 초과
     						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
                 			return false;
     					}
     				}
     			}
     		}
     		if(svc_provdr.value != '') {
     			if(!ComIsNumber(svc_provdr)) {
     				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
     				return false;
     			}
     			if(ComChkLen(svc_provdr, 6) != 2) {
 					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
 					return false;
 				}
     		}
			ComSetObjValue(ofc_cd, 			comboObjects[0].GetSelectCode());
			ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].GetSelectCode());
			ComSetObjValue(dmdt_chg_sts_cd, comboObjects[2].GetSelectCode());
			if(ComGetObjValue(cond_type) == 'date'){
				ComSetObjValue(loc_cd, ComGetObjValue(yd_cd) + comboObjects[3].GetSelectText());
			} else if(ComGetObjValue(cond_type) == 'vvd_cd'){
				if(chk_all_office.checked){
					ComSetObjValue(all_office,  "Y");
					ComSetObjValue(ofc_cd, 		"");
				}
			} 
  	  	} //end of the with(formObj){ clause
  	  return true;
	}
	function validateDate(formObj){
		if(ComChkPeriod(formObj.fm_mvmt_dt1.value, formObj.to_mvmt_dt1.value) > 0){
			if(ComGetDaysBetween(formObj.fm_mvmt_dt1.value, formObj.to_mvmt_dt1.value) > 31){
				ComShowCodeMessage('DMT00162','1 Month');
				return false;
			}
		} else if (ComChkPeriod(formObj.fm_mvmt_dt1.value, formObj.to_mvmt_dt1.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=formCmd; 		
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		switch(comboObj.options.id) {
	       case "office": //SEARCHLIST02 
	    	   	// Office List
				var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
				var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
	    	    var comboCodeArr=ofc_cds.split("|");
	    	    var comboTextArr=ofc_nms.split("|");
	    	    for (var i=0 ; i < comboTextArr.length ; i++) {
	    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
	         	}
	   	  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
	   	  		comboObj.SetSelectCode(usr_ofc_cd);
	   	  		if(comboObj.GetSelectCode()!= usr_ofc_cd) {
		    	  		comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
		    	  		comboObj.SetSelectCode(usr_ofc_cd);
	   	  		}
	    	    break;
	        case "tariff_type":
		 		// Tariff type comboList
				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);				
				if (data != undefined && data != '') {					
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
				}
 				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				if(data2 == '')
 					data2='DMIF';
 				else {
 					data2=data2.split(',')[0];
 				}
 				comboObj.SetSelectCode(data2);
 				USR_TRF_TP=data2; 
 				formObj.usr_trf_tp.value=data2;
 				break;
	        case "yd_cd2":
	        	var comboDatas;
	        	var chkObj;
	        	var condType=ComGetObjValue(formObj.cond_type);
	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();
	 	        	comboDatas=ComGetEtcData(sXml, "YD");
	        	} else {
	        		comboDatas=ComGetEtcData(sXml, "LOC_CD");
	        	}
				if (comboDatas != undefined && comboDatas != '') {
					if(srcObj.name == 'yd_cd') {
						comboItems=comboDatas.split(ROWMARK);
						addComboItem(comboObj, comboItems);
					}
				} else {
					if(srcObj.name == 'yd_cd') {
						sheetObj.SetWaitImageVisible(1);
						return;
					}
					if(condType == 'date')
 	        			formObj.yd_cd.value="";
 	        		else
 	        			formObj.port_cd.value="";
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
	        	break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj,comboItems) {
 		switch(comboObj.options.id) {
 			case "tariff_type":
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
 			case "status01":
 				if(comboItems == 3) {
	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished|To Date", "F");
	  				comboObj.InsertItem(2, "Long Staying|From Date", "L");
	  				comboObj.InsertItem(3, "Unfinished|From Date", "U");
	  				comboObj.InsertItem(4, "Confirmed|To Date", "C");
	  				comboObj.InsertItem(5, "Invoiced|To Date", "I");
	  				comboObj.InsertItem(6, "All Long Staying|Regardless of Date", "R");
 				} else {
 	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished", "F");
	  				comboObj.InsertItem(2, "Long Staying", "L");
	  				comboObj.InsertItem(3, "Unfinished", "U");
	  				comboObj.InsertItem(4, "Confirmed", "C");
	  				comboObj.InsertItem(5, "Invoiced", "I");
 				}
 				break;
 			case "yd_cd2":
 				for (var i=0 ; i < comboItems.length ; i++) {
 		    		var comboItem=comboItems[i].split(FIELDMARK);
 					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
 		    	}
 				break;
 		}
 	}
 	//no support[check again]CLT 	
 	function sheet1_OnLoadFinish() {
		var formObj=document.form
		sheetObjects[0].SetWaitImageVisible(0);
		//office combo list
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST02); //"office"
		//tariff type combo list
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST); //"tariff_type"
		//doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCHLIST03);
      	doInit();
      	sheetObjects[0].SetWaitImageVisible(1);
      	buttonMode("NEW");
	}        
//	function sheet1_OnClick(sheetObj, row, col, Value){
//		if(sheetObj.ColSaveName(col) == "chk_box")
//			ComSyncAllCheck(sheetObj, col, Value);
//	}
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk_box") {
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
//                        if (CellEditable(arr[i], "chk_box")) {
//                            CellValue2(arr[i], "chk_box") = "1";    // 선택된 행의 CheckBox 체크
//                        }
                    	if(GetCellValue(arr[i], "chk_box") == '0'){
                    		SetCellValue(arr[i], "chk_box",'1',0);
                    	} else {
                    		SetCellValue(arr[i], "chk_box",'0',0);
                    	}
                    }
                    if (CheckedRows("chk_box") == RowCount()) {
                    	SetHeaderCheck(0, "chk_box",1);
                        SetHeaderCheck(1, "chk_box",1);
                    } else {
                    	SetHeaderCheck(0, "chk_box",0);
                        SetHeaderCheck(1, "chk_box",0);
                    }
                }
            } else {
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
    function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg) {  

			//ComOpenWait End
		ComOpenWait(false);
		var totRowCnt=sheetObj.RowCount();
		if(totRowCnt > 0){
			buttonMode("RETRIEVE");
			sheetObj.CheckAll("chk_box",0);
		} 
		
		with(sheetObj) {
			var formObj=document.form;
			ComSetObjValue(formObj.dmdt_trf_cd, comboObjects[1].GetSelectCode());
    		var dmdtTrfCd=formObj.dmdt_trf_cd.value;
    		if(!ComIsEmpty(dmdtTrfCd)){
    			if(dmdtTrfCd.substr(2,1) == 'O'){
    				SetCellValue(0, "port","BKG POR");
        			SetCellValue(1, "port","BKG POR");
    			} else {
    				SetCellValue(0, "port","BKG DEL");
        			SetCellValue(1, "port","BKG DEL");
    			}
    		} else {
    			//default
    			SetCellValue(0, "port","BKG POR");
    			SetCellValue(1, "port","BKG POR");
    		}
		}
	}
 	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
 		var formObj=document.form;
 		//ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
 		ComSetObjValue(formObj.ofc_cd, 			sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ofc_cd"));
		ComSetObjValue(formObj.dmdt_trf_cd, 	comboObjects[1].GetSelectCode());
		ComSetObjValue(formObj.dmdt_chg_sts_cd, comboObjects[2].GetSelectCode());
		var url="EES_DMT_3109.do"
 			+"?group_by="//+ComGetObjValue(formObj.grp_type)
 			+"&chg_type="+ComGetObjValue(formObj.chg_type)
 			+"&ofc_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ofc_cd") //ComGetObjValue(formObj.ofc_cd)
 			+"&dmdt_chg_sts_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_chg_sts_cd") //ComGetObjValue(formObj.dmdt_chg_sts_cd)
 			+"&bkg_no="+sheetObj.GetCellValue(Row, "bkg_no")
 			+"&dmdt_trf_cd="+sheetObj.GetCellValue(Row, "dmdt_trf_cd")
 			+"&cntr_no="//+sheetObj.GetCellValue(Row, "cntr_no")
 			+"&dmdt_inv_no="//+sheetObj.GetCellValue(Row, "dmdt_inv_no")
 			+"&invoice_issue=1"	//Invoice Issue BEFORE
 			;
// 		var returnValue=ComOpenWindowCenter(url, "EES_DMT_3109", "935", "690", true);
// 		if(returnValue == "Y") {
// 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
// 		}
 		ComOpenPopup(url, "945", "688", "callbackProc", "0,1", true);
 	}  
 	
 	function openPopupWindow(sheetObj, formObj, srcName) {
 		 if (srcName == "btn_demand") {
 	 		 //ComSetObjValue(formObj.ofc_cd, 			comboObjects[0].Code);
 			 ComSetObjValue(formObj.ofc_cd, 			sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ofc_cd"));
 	 		 ComSetObjValue(formObj.dmdt_trf_cd, 		comboObjects[1].GetSelectCode());
 	 		 ComSetObjValue(formObj.dmdt_chg_sts_cd, 	comboObjects[2].GetSelectCode());
 			 var url="EES_DMT_3109.do"
 				+"?group_by="//+ComGetObjValue(formObj.grp_type)
 	 			+"&chg_type="+ComGetObjValue(formObj.chg_type)
 	 			+"&ofc_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ofc_cd") //ComGetObjValue(formObj.ofc_cd)
 	 			+"&dmdt_chg_sts_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_chg_sts_cd") //ComGetObjValue(formObj.dmdt_chg_sts_cd)
 	 			+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no")
 	 			+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_trf_cd")
 	 			+"&cntr_no="//+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")
 	 			+"&dmdt_inv_no="//+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no")
 				+"&invoice_issue=1"	//Invoice Issue BEFORE
 				;

 			ComOpenPopup(url, "945", "688", "callbackProc", "0,1", true);
 		}
 		 else if(srcName == "btn_grp_demand") {
 			if (sheetObj.CheckedRows("chk_box") == 0) {
     			ComShowCodeMessage('COM12114', 'BKG No');
     			return;
     		}
 			if (formObj.chk_all_office.checked) {
 				var chkRows=sheetObj.FindCheckedRow("chk_box").split("|");
 	 			for(var i=0; i < chkRows.length-1; i++) {
 	 				for(var j=0; j < chkRows.length-1; j++) {
 	 					if(sheetObj.GetCellValue(chkRows[i], "ofc_cd") != sheetObj.GetCellValue(chkRows[j], "ofc_cd")){
 	 						ComShowCodeMessage('DMT01095');
 	 						return;
 	 					} else {
 	 						ComSetObjValue(formObj.ofc_cd, 	sheetObj.GetCellValue(chkRows[i], "ofc_cd"));
 	 					}
 	 	     		} //for(var j=0; i < chkRows.length-1; j++) {
 	     		} //for(var i=0; i < chkRows.length-1; i++) {
 			} //if(formObj.chk_all_office.checked){
 			else {
 				ComSetObjValue(formObj.ofc_cd, 				comboObjects[0].GetSelectCode());
 			}
 			ComSetObjValue(formObj.dmdt_trf_cd, 		comboObjects[1].GetSelectCode());
 			ComSetObjValue(formObj.dmdt_chg_sts_cd, 	comboObjects[2].GetSelectText());
 			ComSetObjValue(formObj.dmdt_chg_sts_cd_2, 	comboObjects[2].GetSelectCode());
			var url="EES_DMT_3108.do"
				+"?ofc_cd="+ComGetObjValue(formObj.ofc_cd)
				+"&dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_chg_sts_cd="+ComGetObjValue(formObj.dmdt_chg_sts_cd)	 //text
				+"&dmdt_chg_sts_cd_2="+ComGetObjValue(formObj.dmdt_chg_sts_cd_2) //code
				//+"&bkg_no="+bksNos
				;
			
			ComOpenPopup(url, "1200", "690", "callbackProc", "0,1", true);
 		}
 	}

 	function callbackProc(rtnVal) {
		if(rtnVal == "Y") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 		
 	}
 	
  	function status01_OnSelect(comboObj ,index, code) {
 		selComboIndex = index;
 		selComboCode = code;
 	}
 	
 	function status01_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
 		DmtComMultiComboStatus_OnChange(document.form, comboObj, selComboIndex);
 	}   	
	/* Developer's task end */
