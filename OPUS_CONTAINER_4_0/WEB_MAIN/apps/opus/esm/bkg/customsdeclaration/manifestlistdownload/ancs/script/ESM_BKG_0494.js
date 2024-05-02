/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0494.js
*@FileTitle  : SSR Transmit (CUSREP)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,document.form,SEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,MULTI);
				break;
				case "btn_new":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;	
				case "btn_transmission":
					doActionIBSheet(sheetObject,formObject,MULTI01);
					break;	
				case "btn_cusrep":
					ComOpenWindowCenter("ESM_BKG_0186_POP.do?vvd=" + formObject.vvd.value , "", 1350, 680);
					break;			
            } // end switch
    	}catch(e) {
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
    	doActionIBSheet(sheetObjects[0],document.form, INIT);
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	//axon_event.addListener('keydown', 'obj_KeyDown', 'form');
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	initComboSetVal(sheetObjects[0],document.form);
    	
    	if( document.form.pod.value != '' ){
    		frm_pod.SetSelectCode(document.form.pod.value);
    	}
    	
    	if( document.form.vvd.value != '' ){
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
    	}
    }
    
    /**
     * handling search conditions input
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if(srcName != 'frm_remark'){
	    	if (event.keyCode == 13) {
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
	    	}
    	}
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
    	}
    }
    

    
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     **/
    function setComboObject(combo_obj){          
       comboObjects[comboCnt++]=combo_obj;
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
	 * retrieving Berth Code data
	 */
    //pod를 하드코딩에서 콤보로 변경 후 pod에 따라 Berth Code를 변경시키기 위해 변수를 추가 함. 2012.03.16
    var berth_combo_list= new Array();    
	function initComboSetVal(sheetObj,formObj){
		formObj.f_cmd.value=SEARCH01;
		slan_cd.SetUseEdit(1);
		var hrdCdgId='ANR_CSTMS_BRTH_CD'; 
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0494GS.do?hrd_cdg_id="+hrdCdgId, FormQueryString(formObj));
 		berth_combo_list = ComBkgXml2Array(sXml, "attr_ctnt2|attr_ctnt1");
// 		berth_combo_list = ComBkgXml2ComboItem2(sXml, comboObjects[0], "attr_ctnt2", "attr_ctnt1");
//		slan_cd.InsertItem(0, '', ''); 
		//ComSetObjValue(formObj.slan_cd,"TPE");
		
		doActionIBSheet(sheetObjects[0], formObj, COMMAND11);		
	}
	
	/*
	 * 2012.03.16
	 * input에서 콤보로 바뀌면서 onchange 부분을 따로 처리함 */
	function frm_pod_OnChange(comboObj,oldindex, oldtext, oldcode , newindex, text , code) {
		var formObject = document.form;
		slan_cd.RemoveAll(); 
	    for(var i in berth_combo_list){
	    	if( berth_combo_list[i][1].substring(0,5) == code){
	    		slan_cd.InsertItem(-1, berth_combo_list[i][1], berth_combo_list[i][0]);//맨 마지막에 추가 text,code순
	    	}
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
            case "sheet1":      //sheet1 init
                with(sheetObj){
            		var HeadTitle1="|user_date";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"user_date",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eta_call_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"berth_code",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_ttl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_flag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lloyd_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crsrep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"last_edi",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pagerows",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ssr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"demdet_free_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lloyd_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dnld_ttl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"user_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prv_prot",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lloyd_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetVisible(false);
                }
                break;
        }
    }
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case SEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0494GS.do", FormQueryString(formObj) );
                    // DoSearch 이후 sheet1_OnSearchEnd function callback
				}
				break;
			case MULTI:        
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
					sheetObj.SetCellValue(1, "ibflag","I",0);
					sheetObj.DoSave("ESM_BKG_0494GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;
			case MULTI01:      
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI01;
					sheetObj.SetCellValue(1, "ibflag","I",0);
					var sParam=ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) ;
	    	        ComOpenWait(true);
 	    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0494GS.do?msg_tp_cd='R'", sParam);
	    	        ComOpenWait(false);
 	    	        sheetObj.LoadSaveData(SaveXml);
					state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
					if (state == "S")
						doActionIBSheet(sheetObj, document.form, SEARCH);
				}
				break;
			case COMMAND01:
				if(validateForm(sheetObj,formObj,sAction)) {
					if(ComShowCodeConfirm("BKG00447")) {
						formObj.f_cmd.value=ADD;
						IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
						sheetObj.SetCellValue(1,"ibflag","U",0);
						sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
			case COMMAND02:
				if(validateForm(sheetObj,formObj,sAction)) {
					if(ComShowCodeConfirm("COM12165", "Vessel Arrival Manifest")) {
						formObj.f_cmd.value=ADD;
						IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
						sheetObj.SetCellValue(1,"ibflag","U",0);
						sheetObj.SetCellValue(1,"del_flag","D",0);
						sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
    				}
				}
				break;
			case COMMAND03:
				var remark=formObj.frm_remark.value;
				sheetObj.RemoveAll();
				formObj.reset();
				comboObjects[0].SetSelectCode("");
				comboObjects[1].SetSelectIndex(0);
				//formObj.frm_remark.value=remark;
//				document.getElementById('trans_sel').innerHTML="";
				break;
			case COMMAND11 : //  PORT 조회
				
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchData("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				ComXml2ComboItem(sXml, frm_pod, "pod_cd", "pod_cd");
				//frm_pod.InsertItem(0, '', ''); 				
				frm_pod.SetSelectIndex(0,true); 				
				ComOpenWait(false);
				
				break;					
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	
    	if(sheetObj.RowCount() > 0){
			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
			var diff=formObj.frm_bkg_ttl.value - formObj.frm_dnld_ttl.value;
			if (diff < 0) 
				diff=(diff * -1);
			formObj.frm_diff.value=diff;
			var bethCd=sheetObj.GetCellValue(1,3);
			var accept=sheetObj.GetCellValue(1,9);
			var accept_A="<select style='width:120px;' name='transflag'><option value='R'>Replace</option><option value='C'>Cancel</option></select>";
			var accept_N="<select style='width:120px;' name='transflag'><option value='O' selected='selected'>Original</option></select>";
//			if( accept == 'A' )
//				document.getElementById('trans_sel').innerHTML=accept_A ;
//			else
//				document.getElementById('trans_sel').innerHTML=accept_N ;
			comboObjects[0].SetSelectCode(bethCd);
			var accept=sheetObj.GetCellValue(1,"crsrep");
			if( 'A' != accept )
	     		document.form.anr_msg_sts_cd.src='img/btng_icon_r.gif'; 
	     	else
	     		document.form.anr_msg_sts_cd.src='img/btng_icon_b.gif';
		} else {
			//setting all field value "" , except search conditions
			for(var i=0; i<formObj.getElementsByTagName("input").length; i++) {
				if (formObj.getElementsByTagName("input")[i].name != "vvd" &&
					formObj.getElementsByTagName("input")[i].name != "frm_pod") {
					formObj.getElementsByTagName("input")[i].value="";
				}
			}
		}
		ComOpenWait(false);
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case SEARCH:      
    			if (!ComChkValid(formObj))	return false;
    			if ( ComChkLen(formObj.vvd.value, 9) != "2" ) 
     			{
     				//ComShowCodeMessage('BKG00715', 'VVD');
    				ComShowCodeMessage('BKG00626', 'VVD');
    				formObj.vvd.focus();
     				return false;
     			}
			break;
    		case MULTI:      
    			if (!ComChkValid(formObj))	return false;
    			
    			if ( formObj.vvd.value == "" ) 
     			{
    				ComShowCodeMessage('BKG01101', 'VVD');
     				formObj.vvd.focus();
     				return false;
     			}
			break;
    		case MULTI01:   
    			if (!ComChkValid(formObj))	return false;
    			if ( formObj.vvd.value == "" ) 
     			{
    				ComShowCodeMessage('BKG01101', 'VVD');
     				formObj.vvd.focus();
     				return false;
     			}

    			if (!ComShowCodeConfirm("BKG06200", "CUSREP")){
    				return false;
    			}
				
			break;
    	}	
            return true;
    }
    
     /**
      * handling container list combo change
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
    function slan_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
     	var formObj=document.form;
     	formObj.berth_code.value=comboObj.GetSelectCode();
    }     
