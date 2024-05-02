/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0760.js
*@FileTitle  : Confirm-Hold Notice Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
    // Common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var org_pod_cd="";
    var orgPodList;
    var orgObj=new Object();
    var isNew=true;
    var isRetrieved=false;
    var isAutoSelect=false;
    // Event Handler definition for Button Click event */
    document.onclick=processButtonClick;
    /**
     * Event Handler for branch processing by judging button name.<br>
     * 
     * @return none
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            case "btn_Retrieve":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break;
            case "btn_New":
            	initForm();
                break;
            case "btn_Save":
            	doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
            case "btn_ConfirmHoldNotice":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_Delete":
            	doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;
        	case "btn_close":
        		ComClosePopup(); 
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
      * Registering IBSheet Object in to Array
      * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
      * The array is defined at upper part of source
      */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
      */
    function loadPage() {
        for (k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }       
		initForm();
    	initControl();
    	var sheetObj=sheetObjects[0];
    	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
    	document.form.ofc_cd.focus();
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    /**
     * Form data initialization operation. After open screen or deleting screen, setting initial value
     * 
     * @return none
     */
    function initForm() {
        with(document.form) {
     		ComSetObjValue(frm_eclz_obl_flg, "N");
     		frm_addr_ctnt.value="";
     		frm_snd_ofc_cntc_ctnt.value="";     		
     		frm_t1_hld_rmk.value="";
     		frm_t2_hld_rmk.value="";
     		frm_t3_hld_rmk.value="";
     		frm_t4_hld_rmk.value="";
     		frm_t5_hld_rmk.value="";
 		    org_pod_cd="";
 		    orgPodList="";
 		    orgObj=new Object();
 		    isNew=true;
 		    isRetrieved=false;
 		    isAutoSelect=false;
     	}
    }
    /**
     * Registering HTML tag event. <br>
     * 
     * @return none
     */
    function initControl() {
        //axon_event.addListenerFormat("keypress","obj_KeyPress", form);
     	//axon_event.addListener("keydown","ComKeyEnter", "ofc_cd", "pod_cd");
      	//axon_event.addListener("keydown","obj_keydown2", "ofc_cd", "frm_t1_hld_rmk", "frm_t2_hld_rmk","frm_t3_hld_rmk", "frm_t4_hld_rmk", "frm_t5_hld_rmk");
        //axon_event.addListener("keyup","obj_keyup", "ofc_cd", "pod_cd");
    }
    /**
     * Handling Key Up event. <br>
     * 
     * @return none
     */
//    function obj_keyup() {
//        var sheetObject1=sheetObjects[0];
//      	var formObject=document.form;
//      	switch(event.srcElement.name) {
//        case "ofc_cd":
//            if (event.srcElement.value.length == 5) {
//         	    doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
//         	}
//         	break;
//      	case "pod_cd":
//      		fncFindComboCode(event.srcElement, formObject.pod_cd_list);
//      		break;
// 	    }
//    }     
    /**
     * Handling Key Down event. <br>
     * 
     * @return none
     */
//    function obj_keydown2() {
//        var formObject=document.form;
//      	switch(event.srcElement.name) {
//        case "ofc_cd":
//         	formObject.pod_cd.value="";
//         	formObject.pod_cd_list.RemoveAll();
//         	break;
//        case "frm_t1_hld_rmk":
//        case "frm_t2_hld_rmk":
//        case "frm_t3_hld_rmk":
//        case "frm_t4_hld_rmk":
//        case "frm_t5_hld_rmk":
//            if (checkMaxLine(event.srcElement, 20) == false) {
//        	    if(event.keyCode == 13) { 	  
//        	   	    event.returnValue=false;
//        	   	}
//        	}
//        	break;
//         }
//    }
    /**
     * Registering IBTab Object in to Array<br>
     * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array<br>
     * The array is defined at upper part of source <br>
     * 
     * @param {object} tab_obj mandatory, Tab control
     * @return none
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab basic setting <br>
     * Setting items of tab. <br>
     * 
     * @param {object} tabObj mandatory, Tab control
     * @param {int}    tabNo  mandatory, Tab object serial number
     * @return none
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Event#1" , "");
					InsertItem( "Event#2" , "");
					InsertItem( "Event#3" , "");
					InsertItem( "Event#4" , "");
					InsertItem( "Event#5" , "");
                }
             break;
         }
    }
    /**
     * Definition for sheet initial setting value, header<br>
     * 
     * If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module. <br>
     * 
     * @param {ibsheet} sheetObj mandatory, IBSheet object
     * @param {number}  sheetNo  mandatory, IBSheet object serial number
     * @return none
     */
    function initSheet(sheetObj,sheetNo) {
          var cnt=0;
          switch(sheetObj.id) {
          // Word Information
          case "sheet1":
        	    with(sheetObj){
			            var HeadTitle1="|Office|POD|Type|Send Type|OBL Copy|Content|Contact";
			            var headCount=ComCountHeadTitle(HeadTitle1);
			            (headCount, 0, 0, true);
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
			           (headCount, 0, 0, true);
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
     * Handling process about Sheet <br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {object}  formObj  mandatory,HTML Form object
     * @param {string}  sAction  mandatory,Action name
     * @return 없슴
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {
          //sheetObj.ShowDebugMsg = false;
      	  sheetObj.SetWaitImageVisible(0);
          switch(sAction) {
		  // Retrieving list DEL & creating combo
          case IBSEARCH_ASYNC01:        
          	  if (validateForm(sheetObj,formObj,sAction) == false) return; 
          	  formObj.f_cmd.value=SEARCH01;
          	  var sXml=sheetObj.GetSearchData("ESM_BKG_0511GS.do", FormQueryString(formObj));
          	  orgPodList=sXml;
          	  ComXml2ComboItem(sXml, pod_cd_list, "pod_cd", "pod_cd");
           	  if (org_pod_cd == "") {
            	  pod_cd_list.SetSelectCode("ALL");
        	  } else {
            	  pod_cd_list.SetSelectCode(org_pod_cd);
        	  }
          	  org_pod_cd="";
          	  break;
          case IBSEARCH:
          	  if (validateForm(sheetObj,formObj,sAction) == false) return; 
          	  ComOpenWait(true);
              formObj.f_cmd.value=SEARCH;
              var sXml=sheetObj.GetSearchData("ESM_BKG_0760GS.do", FormQueryString(formObj));
              var arrXml=sXml.split("|$$|");
              sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
              sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
              if (ComGetTotalRows(arrXml[0]) == 0) {
            	  ComShowCodeMessage("BKG04016", document.form.ofc_cd.value);
              	  isNew=true;
              } else {
            	  isNew=false;
              }
              copyRowToForm();
              setSearchKeyword();
              ComOpenWait(false);
              break;
          case IBSAVE:
          	  if (isRetrieved == false) {
          		  ComShowCodeMessage("BKG00448"); 
          		  break;
          	  }
          	  if(validateForm(sheetObj,formObj,sAction) == false) break;
          	  if (isChangedSearchKeyword() == false) {
          		  ComShowCodeMessage("BKG01072");
  	    	      resetSearchKeyword();
  	    	      break;
          	  }
              copyFormToRow();
              if (ComIsModifiedSheets(sheetObjects) == false) {
              	  ComShowCodeMessage("BKG00743");
              	  break;
          	  }
      		  if (ComShowCodeConfirm("BKG00824") == false) {
      			  break;
      		  }
      		  ComOpenWait(true);
              formObj.f_cmd.value=MULTI;
              var sParam="f_cmd=" + formObj.f_cmd.value;
              var sParamSheet1=sheetObjects[0].GetSaveString(true);
              if (sParamSheet1 == "") {
            	  ComOpenWait(false);
            	  return;
              } else {
            	  sParam += "&" + sParamSheet1;
              }
              var sParamSheet2=sheetObjects[1].GetSaveString(true);
              if (sParamSheet2 == "") {
            	  ComOpenWait(false);
            	  return;
              } else {
            	  sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
              }
              var sXml=sheetObj.GetSaveData("ESM_BKG_0760GS.do", sParam);
              var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			  if(transResultKey == "S"){
				  
		      		if (document.form.f_cmd.value == MULTI) {
		      			ComShowCodeMessage("BKG00166");
		          		org_pod_cd=document.form.pod_cd.value;
		          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
		          		doActionIBSheet(sheetObj,document.form,IBSEARCH);
		      		} else if (document.form.f_cmd.value == REMOVE) {
		      			ComShowCodeMessage("BKG00593");
		          		document.form.pod_cd.value="";
		      		    initForm();
		          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
		      		}
				  
			  }
  			  ComOpenWait(false);
          	  break;     
          case IBDELETE:
          	  if (isRetrieved == false) {
          		  ComShowCodeMessage("BKG00448"); 
          		  break;
          	  }
          	  if(validateForm(sheetObj,formObj,sAction) == false) break;
          	  if (isChangedSearchKeyword() == false) {
          		  ComShowCodeMessage("BKG01072");
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
              initForm();
              ComOpenWait(false);
          	  break;
          	  // Call Confirm-Hold Notice Popup
          case IBSEARCH_ASYNC03:
        	  ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0510_POP.do?pgmNo=ESM_BKG_0510&mainPage=false', 1110, 700, "", "none", true);
        	  break;
          }
    }
    /**
     * Sheet data copy as Form. <br>
     * 
     * @return none
     */
    function copyRowToForm() {
      	var formObj=document.form;
  		var pre="";
      	with (formObj) {
      		// Setup Information
    		pre="frm_";
			var sheetObj=sheet1;
  			if (sheetObj.RowCount()== 0) {
  				sheetObj.DataInsert(0);
      			sheetObj.SetCellValue(1,"ofc_cd",ofc_cd.value);
      			sheetObj.SetCellValue(1,"pod_cd",pod_cd.value.trim() == "" ? "ALL" : pod_cd.value);
      			sheetObj.SetCellValue(1,"hld_ntc_tp_cd",hld_ntc_tp_cd.value);
      			sheetObj.SetCellValue(1,"auto_ntc_flg","N");
      			sheetObj.SetCellValue(1,"eclz_obl_flg","");
      			sheetObj.SetCellValue(1,"addr_ctnt","");
      			sheetObj.SetCellValue(1,"snd_ofc_cntc_ctnt","");
      		}
  			IBS_CopyRowToForm(sheetObj, formObj, 1, pre);
			sheetObj=sheet2;
		    if (sheetObj.RowCount()== 0) {
	  			for (var i=1; i<=5; i++) {
	      			sheetObj.DataInsert(-1);
	      			sheetObj.SetCellValue(i,"ofc_cd",ofc_cd.value);
	      			sheetObj.SetCellValue(i,"pod_cd",pod_cd.value.trim() == "" ? "ALL" : pod_cd.value);
	      			sheetObj.SetCellValue(i,"hld_ntc_tp_cd",hld_ntc_tp_cd.value);
	      			sheetObj.SetCellValue(i,"hld_ntc_fom_cd","E" + i);
	      			sheetObj.SetCellValue(i,"hld_rmk","");
	  			}
		    }
  			for (var i=1; i<=5; i++) {
  				pre="frm_t" + i + "_";
  	  			IBS_CopyRowToForm(sheetObj, formObj, i, pre);
  			}
      	}
    }
    /**
     * Sheet data copy as sheet. <br>
     * 
     * @return 없슴
     */
    function copyFormToRow() {
      	var formObj=document.form;
      	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
      	for (var i=1; i<=5; i++) {
          	IBS_CopyFormToRow(formObj, sheetObjects[1], i, "frm_t" + i + "_");
      	}
    }
    /**
     * Returning whether retrieve conditions changes<br>
     * 
     * @return boolean true: Retrieve conditions changed, false:Retrieve conditions not changed
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
     * POD combo Change Event processing<br>
     * POD CD changes into POD selected code valus.<br>
     * 
     * @return none
     */
    function pod_cd_list_OnChange() {
      	var formObj=document.form;
      	if (!isAutoSelect) {
          	formObj.pod_cd.value=pod_cd_list.GetSelectCode();
      	}
    }
    /**
     * POD combo Focus Event processing<br>
     * False setting whether select automatically 
     * @return none
     */
    function pod_cd_list_OnFocus() {
      	isAutoSelect=false;
    }
    /**
     * After inquiry completing using search function, handles occuring event<br>
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {string}  ErrMsg   optional,error message
     * @return none
     */
//    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    	copyRowToForm();
//        ComOpenWait(false);
//      	if (sheetObj.RowCount()== 0) {
//      		ComShowCodeMessage("BKG04016", document.form.ofc_cd.value);
//      	}
//        	// saving retrieve conditions
//       	setSearchKeyword();
//    }      
    /**
     * Handling event Save completion<br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {string}  ErrMsg   optional,error message
     * @return none
     */
//    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//        if (ErrMsg == "") {
//      		if (document.form.f_cmd.value == MULTI) {
//      			ComShowCodeMessage("BKG00166");
//          		org_pod_cd=document.form.pod_cd.value;
//          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
//          		doActionIBSheet(sheetObj,document.form,IBSEARCH);
//      		} else if (document.form.f_cmd.value == REMOVE) {
//      			ComShowCodeMessage("BKG00593");
//          		document.form.pod_cd.value="";
//      		    initForm();
//          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
//      		}
//        }
//    } 
    /**
     * Tab clicked related event
     * Activating selected tab
     */
    function tab1_OnChange(tabObj , nItem) {
       var objs=document.all.item("tabLayer");
       objs[nItem].style.display="inline";
       for(var i = 0; i<objs.length; i++){
	       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
       beforetab=nItem;
    }
    /**
     * To check whether inquiry conditions changed, saving inquiry conditions.<br>
     *
     * @return none
     */
    function setSearchKeyword() {
        var formObj=document.form;
      	orgObj.ofc_cd=formObj.ofc_cd.value;
      	orgObj.pod_cd=formObj.pod_cd.value;
      	orgObj.pod_cd_list=orgPodList;
      	isRetrieved=true;
    }
    /**
     * Resetting inquiry conditions values that changed randomly without saving.<br>
     *
     * @return none
     */
    function resetSearchKeyword() {
      	var formObj=document.form;
      	formObj.ofc_cd.value=orgObj.ofc_cd;
      	formObj.pod_cd.value=orgObj.pod_cd;
      	ComXml2ComboItem(orgObj.pod_cd_list, pod_cd_list, "pod_cd", "pod_cd");    	
      	pod_cd_list.SetSelectCode(orgObj.pod_cd);
    }
    /**
     * Handling validity verification process about screen form input value<br>
     * @param {ibsheet} sheetObj mandaroty,IBSheet object
     * @param {object}  formObj  mandaroty,HTML Form object
     * @param {string}  sAction  mandaroty,Action name 
     * @return boolean Returning whether Form object validate. if valid, true, if not false
     * 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) {
          	case IBSEARCH_ASYNC01:
          		if (!ComChkObjValid(formObj.ofc_cd)) return false;
          		break;
          	case IBSEARCH:
          		if (!ComChkValid(formObj)) return false;
          		break;
          	case IBSAVE:
          		if (!ComChkValid(formObj)) return false;
          		for (var i=1; i<=5; i++) {
          			var obj=eval("document.form.frm_t"+i+"_hld_rmk");
          	    	if (getLine(obj) > 20) {
          	    		ComShowCodeMessage("BKG04012", obj.getAttribute("caption"), "20");
          	    		tabObjects[0].selectedIndex=i-1; 
          	    		obj.focus();
          	    		return false;
          	    	}          			
          		}
          		break;
          	}
        }
        return true;
    }
    /**
     * Selecting same code in case Object(POD) value changes.<br>
     * 
     * @param {object} obj      mandatory. POD object 
     * @param {object} comboObj mandatory. POD Combo object
     * @return 없슴
     */	
   	function fncFindComboCode(obj, comboObj) {
  		var idx=-1;
  		isAutoSelect=true;
  //no support[check again]CLT 		document.form.pod_cd_list.UseCode=false;
  		for(var i=0;i<comboObj.GetItemCount();i++){
  			if(obj.value.trim() == comboObj.GetText(i,0).substring(0,obj.value.length)){
  				idx=i;
  				break;
  			}
  		}	
  //no support[check again]CLT 		document.form.pod_cd_list.UseCode=true;
  		if (idx > -1) comboObj.SetSelectIndex(idx);
  	}
    /**
     * Limiting TextArea number of lines.<br>
     * Calling this function in onKeyPress event of HTML tag(Object), controlling number of lines. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="textarea" name="txtRmk" onKeyPress="checkMaxLine(this, 5)"&gt;
     * </pre>
     *  
     * @param {object} obj      mandatory,HTML tag(Object)
     * @param {number} maxLine  mandatory,max number of lines
     * @return none
    */
    function checkMaxLine(obj, maxLine) {
        var ln=getLine(obj);
        if (ln >= maxLine) return false;
        return true;
    }
    /**
     * Returning number of lins of 'obj' object value.<br>
     * Using for the maximum number of lines of object<br>
     * 
     * 
     * @param {object} obj mandatory, HTML태그(Object)
     * @return int. number of lines
     */
    function getLine(obj) {
        var str_len=obj.value;
        line=str_len.split("\r\n");
        return line.length;
    }         
