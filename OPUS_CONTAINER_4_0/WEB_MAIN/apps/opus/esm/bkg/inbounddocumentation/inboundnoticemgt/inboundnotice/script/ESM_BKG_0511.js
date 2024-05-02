/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0511.js
*@FileTitle  : Hold Notice: Pre-Hold Notice Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var org_pod_cd="";
    var orgPodList;
    var orgObj=new Object();
    var isNew=true;
    var isRetrieved=false;
    var isAutoSelect=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Retrieve":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break;
            case "btn_Copy":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
                break;
            case "btn_Delete":
            	doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;
            case "btn_Save":
            	doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
            case "btn_HoldNotice":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_Close" :
            	ComClosePopup();
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
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param  sheet_obj
     * @return 
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     * 
     * @return 
     */
    function loadPage() { 
         for(var i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }       
 		 initForm();
    	 initControl();
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    	 document.form.ofc_cd.focus();
   	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * initializing form data setting initial data after open screen and remove data
     * 
     * @return 
     */
    function initForm() {
    	with(document.form) {
    		ComSetObjValue(frm_auto_ntc_flg, "N");
    		ComSetObjValue(frm_eclz_obl_flg, "N");
    		frm_addr_ctnt.value="";
    		frm_snd_ofc_cntc_ctnt.value="";
    		frm_hld_rmk.value="";
		    org_pod_cd="";
		    orgPodList="";
		    orgObj=new Object();
		    isNew=true;
		    isRetrieved=false;
		    isAutoSelect=false;
    	}
    }
    /**
     * registering HTML tag event <br>
     * 
     * @return 
     */
    function initControl() {
//        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
//    	axon_event.addListener("keydown","ComKeyEnter", "ofc_cd", "pod_cd");
//     	axon_event.addListener("keydown","obj_keydown2", "ofc_cd", "frm_hld_rmk");
//    	axon_event.addListener("keyup","obj_keyup", "ofc_cd", "pod_cd");
    }
    /**
     * process Key Up event<br>
     * 
     * @return 
     */
    function obj_keyup() {
        var sheetObject1=sheetObjects[0];
     	var formObject=document.form;
     	switch(event.srcElement.name) {
        case "ofc_cd":
        	if (event.srcElement.value.length == 5) {
        	    doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
        	}
        	break;
     	case "pod_cd":
     		fncFindComboCode(event.srcElement, pod_cd_list);
     		break;
	    }
    }     
    /**
     * process Key Down event<br>
     * 
     * @return 
     */
    function obj_keydown2() {
     	var formObject=document.form;
     	switch(event.srcElement.name) {
        case "ofc_cd":
        	formObject.pod_cd.value="";
        	pod_cd_list.RemoveAll();
        	break;
        case "frm_hld_rmk":
       	    if (checkMaxLine(event.srcElement, 13) == false) {
       	   	    if(event.keyCode == 13) { 	  
       	   		    event.returnValue=false;
       	   	    }
       	    }
       	    break;
        }
    }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        case "sheet1":
            with(sheetObj){
	          var HeadTitle1="|Office|POD|Type|Send Type|OBL Copy|Content|Contact";
	          var headCount=ComCountHeadTitle(HeadTitle1);
	          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
	
	          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ofc_cd" },
	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd" },
	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"hld_ntc_tp_cd" },
	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"auto_ntc_flg" },
	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"eclz_obl_flg" },
	                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"addr_ctnt" },
	                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"snd_ofc_cntc_ctnt" } ];
	           
	          InitColumns(cols);
	          SetVisible(false);
        }


        	break;
        // Detail Information
        case "sheet2":
            with(sheetObj){
		          
		          var HeadTitle1="|Office|POD|Type|Form|Remark";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ofc_cd" },
		                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd" },
		                 {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"hld_ntc_tp_cd" },
		                 {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"hld_ntc_fom_cd" },
		                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hld_rmk" } ];
		           
		          InitColumns(cols);
		          SetVisible(false);
                }
            break;        
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        case IBSEARCH_ASYNC01:        
        	if (validateForm(sheetObj,formObj,sAction) == false) return; 
        	formObj.f_cmd.value=SEARCH01;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0511GS.do", FormQueryString(formObj));
        	orgPodList=sXml;
        	ComXml2ComboItem(sXml, pod_cd_list, "pod_cd", "pod_cd");
           	pod_cd_list.SetSelectCode(org_pod_cd);
        	org_pod_cd="";
        	break;
        	// Copy
        case IBSEARCH_ASYNC02:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}
        	var param="from_ofc_cd=" + formObj.ofc_cd.value + 
        	            "&from_pod_cd=" + formObj.pod_cd.value;
        	var resultObj=ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1002.do?' + param, 450, 154, "", "none", true);
        	if (resultObj != null) {
        		formObj.ofc_cd.value=resultObj.ofc_cd;
        		formObj.pod_cd.value=resultObj.pod_cd;
        		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        		doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	}
        	break;
        // retrieve
        case IBSEARCH:
        	if (validateForm(sheetObj,formObj,sAction) == false) return; 
        	ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_0511GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|"); 
            sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
            sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
            if (ComGetTotalRows(arrXml[0]) == 0) { 
            
            	isNew=true;
            } else isNew=false;
            if (isNew == true) {
            	ComBtnDisable("btn_Copy");
            } else {
            	ComBtnEnable("btn_Copy");
            }
            copyRowToForm();
            ComOpenWait(false);
            break;
        case IBSAVE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}
            copyFormToRow();
            if (ComIsModifiedSheets(sheetObjects) == false) {
            	ComShowCodeMessage("BKG40027");
            	break;
        	}
    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}
        	setStatusFlag(sheetObjects);
        	ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
            var sParam="f_cmd=" + formObj.f_cmd.value;
            var sParamSheet1=sheetObjects[0].GetSaveString(1);
            if (sParamSheet1 == "") {
            	ComOpenWait(false);
            	return;
            }
            else sParam += "&" + sParamSheet1; //ComSetPrifix(sParamSheet1, "sheet1_");
            var sParamSheet2=sheetObjects[1].GetSaveString(1);
            if (sParamSheet2 == "") {
            	ComOpenWait(false);
            	return;
            }
            else sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
            var sXml=sheetObj.GetSaveData("ESM_BKG_0511GS.do", sParam);
            sheetObjects[0].LoadSaveData(sXml);
			sXml=ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용.
			sheetObjects[1].LoadSaveData(sXml);
			ComOpenWait(false);
        	break;     
        case IBDELETE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}
        	if (ComShowCodeConfirm("BKG00592") == false) {
        		break;
        	}
        	ComOpenWait(true);
        	formObj.f_cmd.value=REMOVE;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0511GS.do", FormQueryString(formObj));
        	sheetObjects[0].LoadSaveData(sXml);
            ComOpenWait(false);
        	break;
        	// Pre-Hold Notice
        case IBSEARCH_ASYNC03:
        	ComOpenPopup('/opuscntr/ESM_BKG_0510_POP.do?pgmNo=ESM_BKG_0510&mainPage=false' , 1110, 700, "PopupEsmBkg0510", "1,0,1,1,1,1,1", false);
        	break;
        }
    }
    /**
     * copying from Sheet data to form<br>
     * 
     * @return 
     */
    function copyRowToForm() {
    	var formObj=document.form;
		var prefix="";
    	with (formObj) {
    		// Setup Information
  			prefix="frm_";
			if (sheetObjects[0].RowCount()== 0) {
				var sheetObj=sheetObjects[0];
				sheetObj.DataInsert(0);
    			sheetObj.SetCellValue(1,"ofc_cd",ofc_cd.value);
    			sheetObj.SetCellValue(1,"pod_cd",pod_cd.value);
    			sheetObj.SetCellValue(1,"hld_ntc_tp_cd",hld_ntc_tp_cd.value);
    			sheetObj.SetCellValue(1,"auto_ntc_flg","");
    			sheetObj.SetCellValue(1,"eclz_obl_flg","");
    			sheetObj.SetCellValue(1,"addr_ctnt","");
    			sheetObj.SetCellValue(1,"snd_ofc_cntc_ctnt","");
    		}
			IBS_CopyRowToForm(sheetObjects[0], formObj, 1, prefix);
			if (sheetObjects[1].RowCount()== 0) {
				var sheetObj=sheetObjects[1];
    			sheetObj.DataInsert(0);
    			sheetObj.SetCellValue(1,"ofc_cd",ofc_cd.value);
    			sheetObj.SetCellValue(1,"pod_cd",pod_cd.value);
    			sheetObj.SetCellValue(1,"hld_ntc_tp_cd",hld_ntc_tp_cd.value);
    			sheetObj.SetCellValue(1,"hld_ntc_fom_cd",hld_ntc_fom_cd.value);
    			sheetObj.SetCellValue(1,"hld_rmk","");
    		}
			IBS_CopyRowToForm(sheetObjects[1], formObj, 1, prefix);
    	}
    }
    /**
     * copying from form data to Sheet<br>
     * 
     * @return 
     */
    function copyFormToRow() {
    	var formObj=document.form;
    	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
    	IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_");
    }
    /**
     * status of sheet changes U<br>
     * 
     * @param  sheets
     * @return 
     */
    function setStatusFlag(sheets){
        for (var i=0;i<sheets.length;i++) {
        //no support[check again]CLT 	
        	for (var j=1;j<sheets[i].Rows;j++) {
	        	if(sheets[i].GetRowStatus(j) == "R") {
	        			sheets[i].SetRowStatus(j,"U");
	        	}
	        }
        }
    }      
    /**
     * return changing retrieve condition<br>
     * 
     * @return boolean
     */
    function isChangedSearchKeyword() {
    	var formObj=document.form;
    	if (orgObj.ofc_cd  != formObj.ofc_cd.value) {
    		return false;
    	}
    	if (orgObj.pod_cd  != formObj.pod_cd.value) {
    		return false;
    	}
    	return true;
    }
    /**
     * acting DEL combo Change event<br>
     * 
     * @return 
     */
    function pod_cd_list_OnChange() {
    	var formObj=document.form;
    	if (!isAutoSelect) {
        	formObj.pod_cd.value=pod_cd_list.GetSelectCode();
    	}
    }
    /**
     * acting DEL combo Focus event<br>
     * 
     * @return 
     */
    function pod_cd_list_OnFocus() {
    	isAutoSelect=false;
    }
    /**
     * event handling after retrieve using retrieve function<br>
     * 
     * @param  sheetObj
     * @param   ErrMsg
     * @return 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	if (sheetObj.RowCount()== 0) {
    		ComShowCodeMessage("BKG43028", document.form.ofc_cd.value, document.form.pod_cd.value);
    	}
     	setSearchKeyword();
    }      
    /**
     * process Save end Event <br>
     * 
     * @param  sheetObj
     * @param   ErrMsg
     * @return 
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {
    		if (document.form.f_cmd.value == MULTI) 
    		{
        		ComBkgSaveCompleted();
        		org_pod_cd=document.form.pod_cd.value;
        		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
        		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    		} 
    		else if (document.form.f_cmd.value == REMOVE) 
    		{
    		    ComBkgSaveCompleted();
        		document.form.pod_cd.value="";
    		    initForm();
        		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
    		}
      	}
    } 
    /**
     * save retrieve condition data to check changing retrieve option<br>
     *
     * @return 
     */
    function setSearchKeyword() {
    	var formObj=document.form;
    	orgObj.ofc_cd=formObj.ofc_cd.value;
    	orgObj.pod_cd=formObj.pod_cd.value;
    	orgObj.pod_cd_list=orgPodList;
    	isRetrieved=true;
    }
    /**
     * reset retrieve condition data<br>
     *
     * @return 
     */
    function resetSearchKeyword() {
    	var formObj=document.form;
    	formObj.ofc_cd.value=orgObj.ofc_cd;
    	formObj.pod_cd.value=orgObj.pod_cd;
    	ComXml2ComboItem(pod_cd_list, pod_cd_list, "pod_cd", "pod_cd");    	
    	pod_cd_list.SetSelectCode(orgObj.pod_cd);
    }
     /**
      * handling process for input validation <br>
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return boolean
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
        	case IBSEARCH_ASYNC01:
        		if (!ComChkObjValid(formObj.ofc_cd)) return false;
        		break;
        	case IBSEARCH_ASYNC02:
        	case IBSEARCH:
        		if (!ComChkValid(formObj)) return false;
        		break;
        	case IBSAVE:
        		if (!ComChkValid(formObj)) return false;
    	    	if (getLine(formObj.frm_hld_rmk) > 13) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_hld_rmk.getAttribute("caption"), "13");
    	    		formObj.frm_hld_rmk.focus();
    	    		return false;
    	    	}
        		break;
        	}
        }
        return true;
    }
    /**
    * selecting same code at combo in case of changing Object(DEL) data<br>
    * 
    * @param  obj
    * @param  comboObj
    * @return 
    * @author 
    * @version 2009.07.09
    */	
 	function fncFindComboCode(obj, comboObj) {
		var idx=-1;
		isAutoSelect=true;
//no support[check again]CLT 		
		pod_cd_list.UseCode=false;
		for(var i=0;i<comboObj.GetItemCount();i++){
			if(obj.value.trim() == comboObj.GetText(i,0).substring(0,obj.value.length)){
				idx=i;
				break;
			}
		}	
//no support[check again]CLT 		
		pod_cd_list.UseCode=true;
		if (idx > -1) comboObj.SetSelectIndex(idx);
	}
    /**
    * limit TextArea line length<br>
    * @param  obj
    * @param maxLine
    * @return
    */
    function checkMaxLine(obj, maxLine) {
        var ln=getLine(obj);
        if (ln >= maxLine) return false;
        return true;
    }
    /**
     * return line length of obj data<br>
     * @param  obj
     * @return line.length
     */
    function getLine(obj) {
        var str_len=obj.value;
        line=str_len.split("\r\n");
        return line.length;
    }
