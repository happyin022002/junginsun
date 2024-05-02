/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0503.js
*@FileTitle  : Vessel Information inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_vsk_0503 : business script for vop_vsk_0503
     */

	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0; 
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
 		 var objs=document.all.item("tabLayer");
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_Retrieve":
						if( objs[0].style.display == "inline" ){
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);   //tab1
						}else if( objs[1].style.display == "inline" ){
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);   //tab1
						}else if( objs[2].style.display == "inline" ){
							doActionIBSheet(sheetObject2,formObject,IBSEARCH);   //tab3
						}
						break;
					case "btn_New":
						if( objs[0].style.display == "inline" ){
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);   //tab1
						}else if( objs[1].style.display == "inline" ){
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);   //tab2
						}else if( objs[2].style.display == "inline" ){
							doActionIBSheet(sheetObject2,formObject,IBCLEAR);   //tab3
						}
						break;
					case "btn_Excel":
						if( objs[0].style.display == "inline" ){
							//sheetObject1.Down2Excel(-1);
							var vVesselCode=formObject.vsl_cd.value; //vessel Code
							if(sheetObject1.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}
							else{
								sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false,SheetName:vVesselCode,SheetDesign:1 ,DownHeader:0});
							}							
						}else if( objs[1].style.display == "inline" ){
							if(sheetObject1.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}
							else{
								sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
							}
						}else if( objs[2].style.display == "inline" ){
							if(sheetObject2.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}
							else{
								sheetObject2.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
							}							
						}
						break;
					case "btn_vsl_cd":
						//var sUrl = "/opuscntr/VOP_VSK_0219.do";
						//ComOpenPopupWithTarget(sUrl, 460, 490, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
						var sUrl="/opuscntr/COM_ENS_0A1.do";
						ComOpenPopupWithTarget(sUrl, 618, 470, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", '0,0,1,1,1,1,1,1,1,1', true);
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(i=0;i<sheetObjects.length;i++){
        	//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		initControl();
    }
	/**
	 * setting combo initial values and header
     * param : comboObj, comboNo
     * adding case as numbers of counting combos 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "year":  
				with(comboObj) {
					comboObj.SetDropHeight(300);
					comboObj.SetBackColor("#CCFFFD");
					for(var j=6; j<=20 ; j++)
					{
						if(j < 10 )
							InsertItem(i++,  "200"+j,  "200"+j);
						else
							InsertItem(i++,  "20"+j,  "20"+j);
					}
					Code=document.form.nowYear.value;
				}
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
        	case "t1sheet1":
				with(sheetObj){
					var HeadTitle1="1|1|1|1";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t1sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"name1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"val1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"name2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"val2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(0);
					SetRowHidden(0, 1);
				}
        		break;
            case "t10sheet1":    				
                with (sheetObj) {
                	//SetWaitImageVisible(0);
                }
                break;
        }
    }
		// handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:		//Retrieve
				if(validateForm(sheetObj,formObj,sAction))
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value=SEARCH01;
						//sheetObj.RowMerge(1) = true;
			        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
			        	var sXml=sheetObj.GetSearchData("VOP_VSK_0503GS.do", sParam);
						//fill input BOX
						if(ComGetEtcData(sXml, "vsl_cd") != "null" ){ 
							setXmlEtcDataToForm(formObj, sXml);
						}else{
								ComShowCodeMessage("VSK50023");
		    	    			formObj.vsl_cd.value="";
		    	    			formObj.vsl_eng_nm.value="";
							setClearDataToForm(formObj, 1);
						}
						//fill t1Sheet
						if(sXml.length>0){
							//fill t1Sheet
							sheetObj.SetDataRowMerge(0);
							sheetObj.SetDataRowMerge(1);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
						}
					}
				break;
			case IBCLEAR:
				//if(validateForm(sheetObj,formObj,sAction))
				if ( sheetObj.id == "t1sheet1")
				{
					formObj.vsl_eng_nm.value="";
					setClearDataToForm(formObj, 0);
					sheetObj.RemoveAll();
				}
				break;
        }
    }
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			sheetObj.SetCellAlign(1,0,"Center");
			sheetObj.SetCellAlign(1,1,"Center");
			sheetObj.SetCellAlign(1,2,"Center");
			sheetObj.SetCellAlign(1,3,"Center");
			sheetObj.SetCellAlign(2,0,"Left");
			sheetObj.SetCellAlign(2,1,"Left");
			sheetObj.SetCellAlign(2,2,"Right");
			sheetObj.SetCellAlign(2,3,"Right");
			sheetObj.SetCellFont("FontSize", 1,0,15);
			sheetObj.SetCellFont("FontBold", 1,0,1);
			sheetObj.SetCellBackColor(1,0,"#CCFFCC");
			sheetObj.SetCellBackColor(1,1,"#CCFFCC");
			sheetObj.SetCellBackColor(1,2,"#CCFFCC");
			sheetObj.SetCellBackColor(1,3,"#CCFFCC");
			for(var i=3 ; i<39 ; i++){
				for(var j=0 ; j<4 ; j++){
					sheetObj.SetCellBackColor(i,j,"#FFFF99");
				}
			}
		}
	}    
    /**
     * Setting EtcData to Form
     */
    function setXmlEtcDataToForm(formObj, sXml) {
    	var iMatchCnt=0;
    	try {
    		var elements=formObj.elements;
    		// Creating HTML control to Array
    		for ( var i=0; i < elements.length; i++) {
    			var sValue, eNmPrefix, eName;
    			if (elements[i].classid == undefined) {
    				eName=elements[i].name; 	// Html object
    			} else {
    				eName=elements[i].id; 	// IBMultiCombo
    			}
    			//except item
    			if (eName == "")
    				continue;
    			//set_XXXX, in case of Hidden object, getting 'set_' Prefix after trim
    			eNmPrefix=eName.substring(0,4);
    			if(eNmPrefix == 'set_') eName=eName.substring(4,eName.length);
    			sValue=ComGetEtcData(sXml, eName);
    		    // Including separator(for thousand ",")
    			if (eName == "cntr_dzn_capa" || eName == "cntr_op_capa" || eName == "cntr_pnm_capa" || eName == "cntr_vsl_clss_capa"
    				|| eName == "dpl_capa" || eName == "dwt_wgt" || eName == "lgt_shp_tong_wgt" 
    				|| eName == "grs_rgst_tong_wgt" || eName == "pnm_gt_wgt" || eName == "suz_gt_wgt" || eName == "net_rgst_tong_wgt" || eName == "pnm_net_tong_wgt" || eName == "suz_net_tong_wgt"
    				|| eName == "foil_capa" || eName == "doil_capa" || eName == "frsh_wtr_capa" || eName == "blst_tnk_capa" || eName == "foil_csm" || eName == "doil_csm" || eName == "frsh_wtr_csm"
    				|| eName == "mn_eng_bhp_pwr" || eName == "mn_eng_rpm_pwr" || eName == "gnr_bhp_pwr" || eName == "gnr_rpm_pwr" || eName == "bwthst_bhp_pwr" || eName == "bwthst_rpm_pwr")
    				sValue=ComAddComma(sValue);    			
    			// in case EtcData of name is not exist, find next
    			if (sValue == undefined)
    				continue;
    			if (elements[i].type == "radio") {
    				var eRadio=document.all[eName];
    				// check first radio, pass other
    				if (eRadio.length > 1)
    					i += (eRadio.length - 1);
    				if (sValue != undefined) {
    					ComSetObjValue(eRadio, sValue);
    					iMatchCnt++;
    				}
    				continue;
    			}
    			// except radio
    			ComSetObjValue(elements[i], sValue);
    			iMatchCnt++;
    		}// for
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return iMatchCnt;
    }    
    /**
     * Setting EtcData to Form
     */
    function setClearDataToForm(formObj, exCnt) {
    	var iMatchCnt=0;
    	try {
    		var elements=formObj.elements;
    		// Creating HTML control to array
    		for ( var i=0; i < elements.length; i++) {
    			var sValue, eNmPrefix, eName;
    			if (elements[i].classid == undefined) {
    				eName=elements[i].name; 	// Html object
    			} else {
    				eName=elements[i].id; 	// IBMultiCombo
    			}
    			//except
    			if (eName=="" || eName=="nowYear" || eName=="vsl_eng_nm")
    				continue;
    			if ( exCnt == 1 ){
        			if (eName == "vsl_cd"){
        				continue;
        			}
    			}else if( exCnt == 2 ){
           			if (eName == "vsl_cd" || eName == "year"){
            			continue;    				
        			}
    			}
    			if (elements[i].type == "radio") {
    				var eRadio=document.all[eName];
    				// check first radio, pass other
    				if (eRadio.length > 1)
    					i += (eRadio.length - 1);
    				if (sValue != undefined) {
    					ComSetObjValue(eRadio, sValue);
    					iMatchCnt++;
    				}
    				continue;
    			}
    			// except radio
    			ComSetObjValue(elements[i], "");
    			iMatchCnt++;
    		}// for
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return iMatchCnt;
    } 
    /* initControl() */
    function initControl() {
    	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	//axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	axon_event.addListener('change', 'vsl_cd_onchangeMax4', 'vsl_cd', '');
    	//axon_event.addListener('keydown',  'ComKeyEnter',   'form');
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);
    }
    /** 
     * Handling key press event
     */ 
    function obj_keypress(){
     	obj=event.srcElement;
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     	    case "engup":
     	        ComKeyOnlyAlphabet('uppernum');
     	        break;
     	}
    }    
    /** 
     * Handling key up event
     */ 
    function obj_keyup(){
    	var formObj=document.form;
     	obj=ComGetEvent();
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     	    case "engup":
     	        if(formObj.vsl_cd.value.length == 4 ){
     	        	formObj.vsl_eng_nm.value="";
					setClearDataToForm(formObj, 2);
					sheetObjects[0].RemoveAll();
    	    		//formObj.f_cmd.value = SEARCH;
    	    		//var vslXml = sheetObjects[2].GetSearchXml("VOP_VSK_0219GS.do?op_=0219", FormQueryString(formObj));
     	        	formObj.f_cmd.value=COMMAND16;
     	        	var vslXml=sheetObjects[0].GetSearchData("VOP_VSK_0219GS.do", FormQueryString(formObj));
     	        	//var vslXml = sheetObjects[2].GetSearchXml("VOP_VSK_0219GS.do?vsl_cd="+formObj.vsl_cd.value, "");
    	    		var sVslEngNm=ComGetEtcData(vslXml, "vsl_eng_nm");
    	    		if(isNull(sVslEngNm)){
    	    			formObj.vsl_cd.value="";
    	    			formObj.vsl_eng_nm.value="";
    	    			ComAlertFocus(formObj.vsl_cd, ComGetMsg('VSK50023'));
    	    		}else{
    	    			formObj.vsl_eng_nm.value=sVslEngNm;
    	    		}
     	        }else if(formObj.vsl_cd.value.length == 0){
					setClearDataToForm(formObj, 0);
					sheetObjects[0].RemoveAll();
					formObj.vsl_eng_nm.value="";
     	        }
     	        break;
     	}
    }     
    //Checking Vessel Code length
	function vsl_cd_onchangeMax4(){
		var formObj=document.form;
		//Checking length is 4
		if(formObj.vsl_cd.value != ""){
			if(formObj.vsl_cd.value.length < 4 ){
				ComShowCodeMessage("VSK50022");
				ComAlertFocus(formObj.vsl_cd, "");
				return ;
			}
		}
	}
    //Handling deactivate event
    function obj_deactivate(){
     	var elementObj=ComGetEvent();
		var formObj=document.form;
    	switch(elementObj.name){ 	    	
    		case "vsl_cd":
    			if(!isNull(elementObj.value)){
    				if(elementObj.maxLength != elementObj.value.length){
    					ComShowCodeMessage("VSK50022");
    					ComAlertFocus(formObj.vsl_cd, "");
    				}
    			}
    			break;
    	}	
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Particular I" , "");
					InsertItem( "Particular II" , "");
//                    InsertTab( cnt++ , "Dock Plan" , -1 );
                }
           		break;
         }
    }
    /**
     * Handling tab click event
     * Activating clicked tab
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
        var formObject=document.form;
	    objs[nItem].style.display="Inline";
	    objs[beforetab].style.display="none";
	    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	    beforetab=nItem;
        switch(nItem) {
    		case 0:
        		//formObject.vsl_cd.value = "";
        		//formObject.vsl_eng_nm.value = "";
        		formObject.vsl_cd.className="input1";
    			comboObjects[0].RemoveAll();
    			comboObjects[0].SetEnable(0);
    			break;
    		case 1:
        		//formObject.vsl_cd.value = "";
        		//formObject.vsl_eng_nm.value = "";
        		formObject.vsl_cd.className="input1";
    			comboObjects[0].RemoveAll();
    			comboObjects[0].SetEnable(0);
    			break;
    		case 2:
        		//formObject.vsl_cd.value = "";
        		//formObject.vsl_eng_nm.value = "";
        		formObject.vsl_cd.className="input";
    			comboObjects[0].RemoveAll();
    			comboObjects[0].SetEnable(1);
    			initCombo(comboObjects[0], 1);          		
    			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if (sheetObj.id == "t1sheet1" || sheetObj.id == "t1sheet2")
        	{
        		if(ComIsEmpty(formObj.vsl_cd.value))
        		{
        			ComShowCodeMessage('VSK50013');
        			ComAlertFocus(formObj.vsl_cd, "");
        			return false;
        		}
        	}
        }
        return true;
    }
//	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
//		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_dt");
//		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_usr_id");
//	}
//	
//	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
//		if(sheetObj.RowCount > 0){
//    		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_dt");
//    		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_usr_id");
//		}
//	} 
    /**
     * Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }