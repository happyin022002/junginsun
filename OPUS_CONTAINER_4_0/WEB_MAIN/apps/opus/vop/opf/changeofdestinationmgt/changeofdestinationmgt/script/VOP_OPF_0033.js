/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0033.js
*@FileTitle  : COD Approve Main Screen 
*@author     : CLT 
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
/**
 * @extends 
 * @class VOP_OPF_0033 : VOP_OPF_0033 business script for
 */
//    function VOP_OPF_0033() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
   	/* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var objBlurFlg=false;
    //items related VVD CD 
    var strVVDOptions="vsl_cd|skd_voy_no|skd_dir_cd";
 	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
 	// Event handler processing by button name */
	function processButtonClick(){
		　
		var sheetObject1=sheetObjects[0];   //t1sheet1
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
        		case "btn_slan_cd_pop":
        			var slan_cd=formObject.slan_cd.value;
        			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 550, 450, "slan_cd_pop_event", "0,0", true);
        			break;
				case "btn_VVDpop":
					//open VVD select  pop-up					
					var vsl_cd=getObjValue("vsl_cd");
                	var sUrl="";
                	if(vsl_cd == ""){
                		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 460, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 360, 380, "setCallBackVVD", "0,0", true);
                	}
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Detail":
					var sUrl="";
					if(sheetObject1.RowCount()== 0){
						ComShowCodeMessage("COM12177");
					}else{
						if(sheetObject1.GetSelectRow()>= sheetObject1.HeaderRows()){
							var vBkgNo=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_bkg_no");
							var vBlNo=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_bl_no");
							var vVvd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vvd");
							var vVslSlanCd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vsl_slan_cd");
							var vCodRqstSeq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_rqst_seq");
							var vCodRhndPortCd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_rhnd_port_cd");
							var vCodStsCd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_sts_cd");
							var vCodEmailSendYn=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_email_send_yn");
							var vCodRhndPortYdCd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_rhnd_port_yd_cd");
							var vNewPol=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_new_pol");
							var vNewPod=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_new_pod");
							sUrl="/opuscntr/VOP_OPF_0206.do?bkg_no="+vBkgNo+"&bl_no="+vBlNo+"&vvd="+vVvd+"&vsl_slan_cd="+vVslSlanCd+"&cod_rqst_seq="+vCodRqstSeq
							+"&cod_rhnd_port_cd="+vCodRhndPortCd+"&cod_sts_cd="+vCodStsCd+"&cod_email_send_yn="+vCodEmailSendYn+"&cod_rhnd_port_yd_cd="+vCodRhndPortYdCd
							+"&new_pol="+vNewPol+"&new_pod="+vNewPod;
//	                		ComOpenPopup(sUrl, 900, 690, "", "0,0", true, false, "", "", "","COD Approval Detail at RSO Office");
							ComOpenPopup(sUrl, 930, 730, "", "0,0", true, false, "", "", "","COD Approval Detail at RSO Office");
						}else{
							ComShowCodeMessage("COM12177");
						}
					}
					break;
				case "btn_History":
					if (sheetObject1.RowCount()== 0){
						ComShowCodeMessage("COM12177");
					} else{					
						if(sheetObject1.GetSelectRow()>= sheetObject1.HeaderRows()){
							var param="?bkg_no="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_bkg_no");
							param+="&cod_rqst_seq="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_cod_rqst_seq");
	    					ComOpenPopup("/opuscntr/ESM_BKG_0981.do"+param, 800, 280, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						}else{
							ComShowCodeMessage("COM12177");
						}
					}
					break;
				case "btn_Tariff":
	            		sUrl="/opuscntr/VOP_OPF_0207.do?isPop=R";
	            		ComOpenPopup(sUrl, 520, 350, "", "0,0", true);
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
     * register Combo Object as array
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage(rso) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		setRso_Combo(rso); //setting RSO combo
		setAuth_Combo(); // setting Auth Result combo 
		setCodRsn_Combo(); // setting DOC Reason combo 
		initControl();
	}
    /**
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 
     **/
    function initControl(){
//      axon_event.addListenerFormat('focus',     'obj_activate',   form); 
//      axon_event.addListenerFormat('keypress',  'obj_keypress',   form); 
        axon_event.addListenerFormat('blur',	  'obj_blur',	    form); 
//      axon_event.addListenerForm  ("keyup",    'obj_keyup',      form);
//    	axon_event.addListener  ('keypress', 'eng_keypress', 'slan_cd'); 
    	axon_event.addListener  ('change', 'change_event', 'slan_cd');   
//    	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//    		case "engup":
//    			switch(event.srcElement.name){
//    				case "slan_cd":		    	     
//    					ComKeyOnlyAlphabet('uppernum');		//inputting capital/number
//    					break;	    	
//    				case "vsl_cd":		    	        	
//    					ComKeyOnlyAlphabet('uppernum');		//inputting capital/number
//    					break;
//    				case "skd_voy_no":		    	        	
//    					ComKeyOnlyNumber(event.srcElement);	//inputting number
//    					break;
//    				case "skd_dir_cd":		    	        	
//    					ComKeyOnlyAlphabet('upper');		//inputting capital
//    					break;
//    			}
//    			break;
//    		default:    	    	
//    			ComKeyOnlyAlphabet("num");					//common standard: recognization only number, english
//	    		break;
//    	}
//    }
    /**
     * Input only capital in onkeypress event of HTML Control <br>
     **/
//    function eng_keypress() {
//        ComKeyOnlyAlphabet('upper');
//    }
    /**
     * popup Data Validation method input in Key
     */
    function change_event() {
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[0];
    	var gubun="";
    	if(!isNull(elementObj.value)){
    		// Length Check..
	    	if(elementObj.maxLength != elementObj.value.length){
	    		ComShowCodeMessage("OPF50007",elementObj.caption,elementObj.maxLength);
	    		setFocus(elementObj.name);
	    		return false;
	    	}
    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun="slanCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    /**
  	 * Setting data received from VSL Code Help (Pop-Up)<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					//change focus 
					setFocus("skd_voy_no");
				}
			}
    	}
  	} 
    /**
  	 * setting data received from VVD Code Help (Pop-Up)<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("skd_voy_no", rtnDatas[2]);
					setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
    	}
  		searchVVDInfo();
  	}
  	/**
     * Retrieve VVD Info
     */
    function searchVVDInfo() {
    	if(objBlurFlg){
	    	var formObj=document.form;
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
	 	   	//Setting item related VVD Info
	 	    setVVDInfo(formObj, sXml);
	 		objBlurFlg=false;
    	}else{
    		objBlurFlg=true;
    	}
    }
  	/**
     * Setting item related VVD Info : VVD
     */
    function setVVDInfo(formObj, sXml) {
    	var vvdData=ComOpfXml2Array(sXml, strVVDOptions);
 	   	if(vvdData == null) {
 		    ComShowCodeMessage("COM12114", "VVD CD");
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 1) {
 	   			ComShowCodeMessage("COM12114", "VVD CD");
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		}
 	   	}
    }
    /**
     * change focus and initialize Object chose 
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs=nameVars.split("|");
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		if(type == 'sheet') sheetObj.SetCellValue(etcVal, prefixs[0]+nameArrs[objIdx],"",0);
    		else {
    			if(eval("document.form."+nameArrs[objIdx]).type == 'hidden') {
    				setObjValue(nameArrs[objIdx],"");
    			} else {
    				ComClearObject(eval("document.form."+nameArrs[objIdx]));
    			}
    		}
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, nameArrs[objIdx]);
    			else {
    				setFocus(nameArrs[objIdx]);
    			}
    		}
    	}
    }    
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    	eval("document.form."+name).select();
    }
    /**
     * checking Null in window form input value
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    // handling work javascript OnKeyUp event
//    function obj_keyup() {
//    	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
//    }  
    // change focus to next HTML Tag(object) of HTML Tag(object) received as factor
    function obj_nextfocus(obj) {
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {
			var formObj=document.form;
			ComSetNextFocus(obj);
			if(obj.name == 'vsl_cd') {
				setObjValue("skd_voy_no", ""); 	
				setObjValue("skd_dir_cd", ""); 
			} else if(obj.name == 'skd_voy_no') {
				setObjValue("skd_dir_cd", ""); 
			}
    	}
    }
    // handling work javascript OnBlur event
    function obj_blur() {
    	switch(event.srcElement.name){ 
	    	case "skd_dir_cd":
	        	searchVVDInfo();
	        	break;
    	}
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
		              var HeadTitle1="|Seq.|LANE|VVD|BKG No.|Rqst\nSeq.|COD\nReason|OLD|OLD|OLD|NEW|NEW|NEW|Booking\nOffice|Auth\nResult|Re-\nHandling\nPort|CNTR\nQ'ty|COD\nCharge|Remark(s)|BL No.||||opr|";
		              var HeadTitle2="|Seq.|LANE|VVD|BKG No.|Rqst\nSeq.|COD\nReason|POL|POD|DEL|POL|POD|DEL|Booking\nOffice|Auth\nResult|Re-\nHandling\nPort|CNTR\nQ'ty|COD\nCharge|Remark(s)|BL No.||||opr|";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              var prefix="sheet1_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_rsn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"old_pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"old_del",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"new_pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"new_del",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rqst_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cod_rhnd_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"chg_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:1},
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"act_dept_yn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pod_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cod_email_send_yn", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_opr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cod_rhnd_port_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		              	
		              	InitColumns(cols);
		              	SetEditable(0);
		              	SetHeaderRowHeight(30);
		              	//SetSheetHeight(442);
		              	SetCountPosition(0);
		              	
		              	resizeSheet();
		              	
                    }
        	    break;
 			}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

	// handling process related Sheet
	function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
	        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	        	var sXml=sheetObj.GetSearchData("VOP_OPF_0033GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
			case IBCLEAR:
				setRso_Combo(); //setting RSO combo
				setAuth_Combo();
				setCodRsn_Combo();
				setObjValue("slan_cd", ""); 
				setObjValue("vsl_cd", "");
				setObjValue("skd_voy_no", "");
				setObjValue("skd_dir_cd", "");
				setObjValue("bkg_no", ""); 
				sheetObj.RemoveAll();
				break;				
			case IBROWSEARCH:	
				if(gubun=="slanCd"){
					formObj.f_cmd.value=COMMAND12;
					var lanXml=sheetObjects[1].GetSearchData("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
					var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
					if(isNull(strLanCdDesc)){
						ComShowCodeMessage("OPF50004", "Data");
						setObjValue("slan_cd", "");
						setFocus("slan_cd");
						return false;
					}
				}
				break;
         }
	}
	
	/**
      * handling process for input validation
      */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}

	function setRso_Combo(rso){
	    var formObj=document.form;
		formObj.f_cmd.value=SEARCH01;
		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0033GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[0], "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
		if( rso != ''){
			comboObjects[0].SetSelectCode(rso);
		} else {
			comboObjects[0].SetSelectCode("AMR");
		}
	}

	function setAuth_Combo(){
	    var formObj=document.form;
		formObj.f_cmd.value=SEARCH03;
		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0033GS.do", FormQueryString(formObj));
		comboObjects[1].SetDropHeight(150);
		ComXml2ComboItem(sRhqXml, comboObjects[1], "intg_cd_val_ctnt", "intg_cd_val_dp_desc|intg_cd_val_ctnt");
		comboObjects[1].SetSelectText("All");
	}
	
	/* get COD Reason combo */
	function setCodRsn_Combo(){
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH04;
		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0033GS.do", FormQueryString(formObj));
		comboObjects[2].SetDropHeight(170);
		ComXml2ComboItem(sRhqXml, comboObjects[2], "intg_cd_val_ctnt", "intg_cd_val_ctnt|intg_cd_val_dp_desc");
		comboObjects[2].SetSelectIndex(0);
	}
    /**
     * slan_cd Data PopUp Value input method.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value=aryPopupData[0][1];
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col){
		var vBkgNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_bkg_no");
		var vBlNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_bl_no");
		var vVvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vvd");
		var vVslSlanCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_slan_cd");
		var vCodRqstSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cod_rqst_seq");
		var vCodRhndPortCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cod_rhnd_port_cd");
		var vCodStsCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cod_sts_cd");
		var vCodEmailSendYn=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cod_email_send_yn");
		var vCodRhndPortYdCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cod_rhnd_port_yd_cd");
		var vNewPol=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_new_pol");
		var vNewPod=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_new_pod");
		var vVslOprCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_opr_cd");
		
		sUrl="/opuscntr/VOP_OPF_0206.do?bkg_no="+vBkgNo+"&bl_no="+vBlNo+"&vvd="+vVvd+"&vsl_slan_cd="+vVslSlanCd+"&cod_rqst_seq="+vCodRqstSeq
		+"&cod_rhnd_port_cd="+vCodRhndPortCd+"&cod_sts_cd="+vCodStsCd+"&cod_email_send_yn="+vCodEmailSendYn+"&cod_rhnd_port_yd_cd="+vCodRhndPortYdCd
		+"&new_pol="+vNewPol+"&new_pod="+vNewPod+"&vsl_opr_cd="+vVslOprCd;
//		ComOpenPopup(sUrl, 930, 690, "", "0,0", true);
		
		ComOpenPopup(sUrl, 930, 730, "", "0,0", true);
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount()> 0){
 	 			var compare = "";
 	 			var merge = 1;
 	 			var no = 0;
 	 			for(var i=HeaderRows(); i <= LastRow(); i++){
 	 				var key = GetCellValue(i, "sheet1_vvd") + GetCellValue(i, "sheet1_bkg_no") + GetCellValue(i, "sheet1_cod_rqst_seq");
 	 				if(compare != key) {
 	 					compare = key;
 	 					if(merge > 1) {
 	 						for(var j=1;j<=18;j++) {
 	 							if(j!=15 && j!=16 && j!=17) {
 	 								SetMergeCell(i-merge, j, merge, 1);
 	 							}
 	 						}
 	 					}
 	 					merge = 1;
 	 					no++;
 	 					
 	 				} else {
 	 					merge++;
 	 				}
 	 				SetCellValue(i, "sheet1_Seq",no,0);
 	 				if(GetCellValue(i, "sheet1_act_dept_yn") == "N"){
 	 					for(var j=1 ; j<21 ; j++){
 	 						SetCellBackColor(i, j,"#F7E1EC");
 	 					}
 	 				} 
 	 			}
 	 			// 마지막 행 처리
 	    		if(merge > 1) {
 	    			for(var j=1;j<=18;j++) {
 	    				if(j!=15 && j!=16 && j!=17) {
 	    					SetMergeCell(i-merge, j, merge, 1);
 	    				}
 	    			}
 	    		}
 	 		}
		}
	}    
    function call_0206(){
		var sheetObject1=sheetObjects[0];   //t1sheet1
		var formObject=document.form;    	
    	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }