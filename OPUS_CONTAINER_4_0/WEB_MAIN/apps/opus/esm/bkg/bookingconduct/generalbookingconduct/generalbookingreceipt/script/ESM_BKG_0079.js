/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079.js
*@FileTitle  : BKG Creation Main
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/04/08
=========================================================*/
	/* developer job	*/
	// common global variables
    var tabObjects=new Array();
    var tabName=new Array();
    var tabCnt=0 ;
    var beforetab=10;
    var beforetab_sub=1;
    var beforetab_trob=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var caIssSuccess=false;
    var caCancel=false;
    var caIssue=false;
    var openDgPopUp="N";
    var eur_flg = null;
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
    
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		
    		var strBkgNo=formObject.bkg_no.value;
    		var strBlNo=formObject.bl_no.value;
            switch(srcName) {
				case "btn_History":
					var bkgNo=nullToBlank(strBkgNo); 
					var blNo = nullToBlank(strBlNo);
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0566(bkgNo,blNo); 
                	break;
				case "btn_BLPreview":
					var bkgNo=nullToBlank(strBkgNo); 
					var blNo=nullToBlank(formObject.bl_no.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (blNo == "") {
						ComShowCodeMessage("BKG00400");
						return false;
					}					
					comBkgCallPop0927(bkgNo, blNo);					
                	break;
            	case "btn_CAIssue":
            		var bkgNo=nullToBlank(strBkgNo);
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					caIssSuccess=false;
					comBkgCallPop0708('setCAIssueCallBack', bkgNo, "S");

				    caIssue=true;
                	break;
            	case "btn_CAReason":    
            		var bkgNo=nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0708('setCAReasonCallBack', bkgNo, "R"); 
                	break;
            	case "btn_CACancel": 
            		var bkgNo=nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (!ComBkgProcessYn("Cancel C/A")) {
        	    		return false;
        	    	}
					formObject.bkg_no.value=bkgNo;
            		formObject.f_cmd.value=MULTI01;  //cancelCA
            		doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
            		caCancel=true;
            		if(ComGetObjValue(formObject.isPop)=="Y"){
            			ComClosePopup(); 
	            		var calllFunc="callBackCaCancel"
            			eval('window.dialogArguments.'+calllFunc)();            			
            		}
            		break;
            	case "btn_CAConfirm": 
            		var bkgNo=nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					if (!ComBkgProcessYn("confirm C/A")) {
        	    		return false;
        	    	}
					formObject.bkg_no.value=bkgNo;					
            		formObject.f_cmd.value=MULTI;    //completeCA
            		var success=doActionIBSheet(sheetObjects[0], document.form, IBSAVE); 
            		if(success==true){
	            		if(ComGetObjValue(formObject.isPop)=="Y"){
	            			ComClosePopup(); 
		            		var calllFunc="callBackCaConfirm"
	            			eval('window.dialogArguments.'+calllFunc)();            			
	            		} 
            		}
            		break;
            	case "btn_CAInquiry":
            		var bkgNo=nullToBlank(strBkgNo); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						return false;
					}
					comBkgCallPop0567_POP(bkgNo);
                	break;
            	case "btn_Close":
            		ComClosePopup();
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
    		} else {
    			ComShowCodeMessage(e.message);
    		}
    	}
    }
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
    function loadPage() {
    	//sheet init 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1); 
            ComEndConfigSheet(sheetObjects[i]);
        }
        //tab init 
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
        //tro tab init 
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01); 
      	ComBtnDisable("btn_CAIssue");
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * register Tab Object to tabObjects array
    */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
     /**
      * 0079 btn Control init
      */ 
     function initControl() {
      	var formObj=document.form;
      	var strBkgNo=formObj.bkg_no.value;      
      	var strCaFlg=formObj.ca_flg.value; 
      	var strBdrFlg=formObj.bdr_flg.value;
      	var strCaExist=formObj.ca_exist_flg.value;  
      	//01.Button to initialize the state
      	ComSetDisplay("btn_History",   true); 
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
	      	if (strBkgNo == "") {
				ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	ComSetDisplay("btn_CAInquiry", false); 
	          	setEnabledTroTab(false);  //Control troTab
	      	} else if (strCaFlg == "Y") {
	      		ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(true);  //Control troTab
	      	} else {
	      		ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	          	setEnabledTroTab(false);  //Control troTab
	      	}			
          	ComSetDisplay("btn_CAReason",  false); 
          	ComSetDisplay("btn_CACancel",  false); 
          	ComSetDisplay("btn_CAConfirm", false);
	      	ComBtnDisable("btn_CAIssue");
		}else{
	      	if (strBkgNo == "") {

	      		ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	ComSetDisplay("btn_CAReason",  false); 
	          	ComSetDisplay("btn_CACancel",  false); 
	          	ComSetDisplay("btn_CAConfirm", false); 	
	          	ComSetDisplay("btn_CAInquiry", false);  
	      		ComBtnDisable("btn_CAIssue");
	      		
	          	setEnabledTroTab(false);  //Control troTab
	      	} else if (strCaFlg == "Y") {

	      		ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	ComSetDisplay("btn_CAReason",  true); 
	          	ComSetDisplay("btn_CACancel",  true); 
	          	ComSetDisplay("btn_CAConfirm", true); 	
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}
	      		ComBtnDisable("btn_CAIssue");
	          	setEnabledTroTab(true);  //Control troTab
	      	} else {
	      		ComSetDisplay("btn_BLPreview", true); 
				ComSetDisplay("btn_CAIssue", true); 
	          	ComSetDisplay("btn_CAReason",  false); 
	          	ComSetDisplay("btn_CACancel",  false); 
	          	ComSetDisplay("btn_CAConfirm", false);
	          	
	          	if (strCaExist == "Y") {
	          		ComSetDisplay("btn_CAInquiry", true);  
	          	} else {
	          		ComSetDisplay("btn_CAInquiry", false); 
	          	}

	      		if (strBdrFlg == "Y") {
	      			ComBtnEnable("btn_CAIssue");
	      		} else {
	      			ComBtnDisable("btn_CAIssue"); 
	      		}     
	          	setEnabledTroTab(false);  //Control troTab
	      	}
		}
      	//applyShortcut();
     }  
    /**
     * Tab basic setting
     */
    function initTab(tabObj, tabNo) {
    	var formObj=document.form;
     	with (tabObj) {
            var cnt=0 ;
			InsertItem( bkgTabName[0], "");
			InsertItem( bkgTabName[1], "");
			InsertItem( bkgTabName[1], "");
			InsertItem( bkgTabName[1], "");
			InsertItem( bkgTabName[2], "");
			InsertItem( bkgTabName[3], "");
			InsertItem( bkgTabName[4], "");
			InsertItem( bkgTabName[5], "");
			InsertItem( bkgTabName[6], "");
			InsertItem( bkgTabName[7], "");
			InsertItem( bkgTabName[8], "");
			InsertItem( bkgTabName[9], "");
            //formObj.openTab.value = 0;            
        }
    }
 	/**
 	 * setting sheet initial values and header
 	 * param : sheetObj, sheetNo
 	 * adding case as numbers of counting sheets
 	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0; 
		switch(sheetObj.id) {
			case "h1sheet1":      //hidden h1sheet1
			    with(sheetObj){
			      var HeadTitle="|";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
			}

		        break; 
 		}
 	}
    
$(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
});

$(window).on('resizeEnd', function() {
	if(beforetab == 1 || beforetab == 2 || beforetab == 5 || beforetab == 6) {
	    var ifrId = "#t" + (beforetab  + 1) + "frame";
	    var height = $(window).height();
	    var ifrOffset = $(ifrId).offset();
	    $(ifrId).height(height - ifrOffset.top - 25);
	    $(ifrId)[0].contentWindow.updateSheetSize();
	}
});


    
 // handling of Sheet process
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	  	    case COMMAND01: 
	  	    	var sParam = "f_cmd=" + SEARCH12 + "&ofc_cd=" + formObj.usr_ofc.value;
	  	    	$.ajax({
	    		    type: "POST",
	    		    url: 'ESM_Booking_UtilGS.do',
	    		    async: true,
	    		    dataType: "text",
	    		    data: sParam,
	    		    success: function(eur_flg_xml){
	    	  	    	eur_flg = ComGetEtcData(eur_flg_xml, "eur_flg");
	    				formObj.troTab.value=ComGetEtcData(formObj.sXml.value,"tro_tab");
	    	  	    	formObj.sXml.value="";
	    		    	initTroTab();
	    		    },
	    		    error: function(xhr){ 
	    		    }
	    		});
	          	break;
 	 		case IBSAVE:  
 	          	if(!validateForm(sheetObj, formObj, sAction)) {
 	          		return false;
 	          	}
 	          	if (formObj.f_cmd.value == MULTI) {         //completeCA
 	          	    var sParam1=ComSetPrifix(sheetObj.GetSaveString(), "t1sheet1_");
 	          	    var sParam=FormQueryString(formObj);
 	          		sParam += "&" + sParam1; 
 	 	          	ComOpenWait(true);
 	          		var sXml=sheetObj.GetSaveData("ESM_BKG_0079GS.do", sParam);
 	 	          	ComOpenWait(false);
 					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
 		            if(State != "S"){
 	 	          		var success=sheetObj.LoadSaveData(sXml);
 		            	return false;
 		            } else {
 		            	setCARefresh();
 	            		if(ComGetObjValue(formObj.isPop)!="Y"){ 	            	

 	            		}
 	            		if("Y" == ComGetEtcData(sXml, "pre_checking")){
 	            			openDgPopUp="Y";
 	            		} else {
 	            			openDgPopUp="N";
 	            		}
 	            		return true;
 	          		}
 	          	}
 	          	else if (formObj.f_cmd.value == MULTI01) {  //cancelCA
 	          	    var sParam1=ComSetPrifix(sheetObj.GetSaveString(), "t1sheet1_");
 	          	    var sParam=FormQueryString(formObj);
 	          		sParam += "&" + sParam1; 
  	          		var sXml=sheetObj.GetSaveData("ESM_BKG_0079GS.do", sParam);
 					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
 		            if(State != "S"){
  		            	var success=sheetObj.LoadSaveData(sXml);
 		            } else {
 		            	setCARefresh();
 		            }
 	          	}
 	          	ComOpenWait(false);
                break;
         }
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj) {
        }
        return true;
    }    
    /**
     * Disabled -> BookingUtilDBDAOSearchBkgBlNoVORSQL
     * abled     -> searchBkgCreTabByUser 
     */ 
    function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
    	var formObj=document.form;
    	formObj.troTab.value=sheetObj.GetEtcData("tro_tab");
    	initTroTab();
    }

    
    /**
     * tab click undefined error 
     * @param tabObj
     * @param tabIndex
     */
    function tab1_OnChange(tabObj, tabIndex) {
    	var beforeTabObj=document.getElementById("t" + (beforetab + 1) + "frame").contentWindow;;
        ComOpenWait(true);
        var readyStateCheckInterval = setInterval(function() {
        	if (beforeTabObj.document.readyState === "complete") {
        		clearInterval(readyStateCheckInterval);
        		ComOpenWait(false);
        		tab1OnChange(tabObj, tabIndex);
        	}
        }, 100);
    }
    
    
    /**
    * handling process for tab event
    */  
//   function tab1_OnChange(tabObj, tabIndex) {
    function tab1OnChange(tabObj, tabIndex) {
    	var nTabCnt=tabObj.GetCount();
    	var formObj=document.form;
// 		var bkgNo=formObj.bkg_no.value;
 	    var beforeTabObj=document.getElementById("t" + (beforetab + 1) + "frame").contentWindow;;
 	    var newTabObj=document.getElementById("t" + (tabIndex  + 1) + "frame").contentWindow;;
 	    try{
 	    if(!beforeTabObj){
 	    	return false;
 	    } else {
//	 	    if(formObj.isInquiry.value == "Y" || caCancel == true){ //System does not check data modification at CA Issue
	 	    if(formObj.isInquiry.value == "Y" || caCancel == true || caIssue == true){
	 	      	if (nTabCnt == 10) {  //eurTro : tro tab 2개
	 	   			switch(beforetab) { 
						case 0: //creation
		  			 	case 1: //tro/o
		  				case 2: //tro/i
		  				case 4: //cust
		  				case 7: // Charge
						case 8: // B/L Issue
//							beforeTabObj.form.modify_flag.value="N";
		  				break;
		  				case 3: // container -> dirty_flg
		  				case 5: // M & D -> dirty_flg
		  				case 6: // CM -> dirty_flg
		  				case 9: // H.B/L-> dirty_flg
//		  					beforeTabObj.form.dirty_flag.value="N";
		  				break;
	 	   			}
		 	    } else {
	 	   			switch(beforetab) { 	 	    	
		 	    		case 0: // creation
					 	case 1: // tro/o
						case 3: // cust
						case 6: // Charge
						case 7: // B/L Issue
//							beforeTabObj.form.modify_flag.value="N";
						break;
						case 2: // container -> dirty_flag
						case 4: // M & D -> dirty_flg
						case 5: // CM -> dirty_flg
						case 6: // H.B/L-> dirty_flg
//	  						beforeTabObj.form.dirty_flag.value="N";
						break;
		 	    	}
	 	    	}
	 	      	if(caCancel==true){
//	 	      		caCancel==false;
	 	      		caCancel=false;
	 	      	}
	 	    } else {
		 	    if(ComIsNull(ComGetObjValue(formObj.openTab))) {
		 	    	if (beforetab<10) {// && beforeTabObj && "complete"==beforeTabObj.document.readyState) {
		 	    		if(beforeTabObj.document.forms.length>0){
			 	    		beforeTabObj.checkModify();
		 	    		}
		 	    	}
		 	    }
	 	    }
	   }
       var befBkgNo="";
       var curBkgNo="";    	
       var befObjTabWindow=document.getElementById("t" + (beforetab + 1) + "frame").contentWindow;       
       var curObjTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
       if(befObjTabWindow.location.href != "" && befObjTabWindow.location.href != "about:blank" ){
      	   befBkgNo=eval("t" + (beforetab + 1) + "frame").form.bkg_no.value;
       }    	 
       if (beforetab != tabIndex) {
           var objs=document.all.item("tabLayer");
           objs[tabIndex].style.display="inline";
           objs[beforetab].style.display="none";            
       }
       var isLoading=false;
       if(curObjTabWindow.location.href != "" && curObjTabWindow.location.href != "about:blank"){
		   curBkgNo=eval("t" + (tabIndex + 1) + "frame").form.bkg_no.value;		   
	   }            
	   // Booking number retrieve
	   if(ComIsNull(befBkgNo) && !ComIsNull(ComGetObjValue(document.form.bkg_no))){
		   befBkgNo=ComGetObjValue(document.form.bkg_no);
	   }
	   // if it is not load load
       if(curObjTabWindow.location.href == "" || curObjTabWindow.location.href == "about:blank"){
    	   isLoading=true;
       }
	   // each tab of the load or re-retrieve
	   if(isLoading){	
		   loadTabPage(tabIndex, isLoading, befBkgNo);
       } else {
    	   newTabObj.searchData(befBkgNo);
       }
	   beforetab=tabIndex;
		setForceFocus();
	    } catch(e) {
	    	if(e.name == "TypeError")
	    		return false;
	    	
	    	if(e == "[object Error]") {	//IE8
	    		return false;
	    	}else if(e == "TypeError: Object doesn't support property or method 'checkModify'"){	//IE11
	    		return false;
	    	}else if(e == "TypeError: undefined is not a function"){//chrome
	    		return false;
	    	}else{
	    		ComShowMessage(e);
	    	}
	    }
   }     
 /**
  * handling process for load tab page
  */     
  function loadTabPage(tabIndex, changeBkgNo, bkgNo) {
	   var formObj=document.form;	   
	   if (tabIndex == null || tabIndex == "") {
          tabIndex=tabObjects[0].GetSelectedIndex();
      }
	  var nTabCnt=tabObjects[0].GetCount();
      if (beforetab != tabIndex) {
         var objs=document.all.item("tabLayer");
         objs[tabIndex].style.display="inline";
         objs[beforetab].style.display="none";            
      }  
      var objTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
      var isReLoading=false;
      if(objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank"){
    	  isReLoading=true;
      }
      if(!isReLoading){
    	  if(changeBkgNo){
    		  isReLoading=true;
    	  }
      }
      if(!ComIsNull(formObj.openTab) && tabIndex == 0){
    	  isReLoading=false;
      }
      if (isReLoading) {
  		var ctxName="/opuscntr";
 		var isInquiry=ComGetObjValue(formObj.isInquiry);
 		var sUrl="";
     	if (nTabCnt == 10) {  //eurTro : tro tab 2개
             switch(tabIndex) {
 				case 0:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_01_Q.do?bkg_no="+bkgNo;		
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_01.do?bkg_no="+bkgNo;		
 					}
 				    break;
 				case 1:
 					var ioBoundCd="O";
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_02C_Q.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_02C.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 					}
 	                break;
 				case 2:
 					var ioBoundCd="I";
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_02C_Q.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_02C.do?bkg_no="+bkgNo+"&io_bnd_cd="+ioBoundCd;
 					}
 	                break;
 				case 3:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_04_Q.do?bkg_no="+bkgNo;  //Container
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_04.do?bkg_no="+bkgNo;  //Container
 					}
 	                break;
 				case 4:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_05_Q.do?bkg_no="+bkgNo;  //Customer
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_05.do?bkg_no="+bkgNo;  //Customer
 					}
 	                break;
 				case 5:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_06_Q.do?bkg_no="+bkgNo;  //M&D	
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_06.do?bkg_no="+bkgNo;  //M&D	
 					}
 			        break;
 				case 6:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_07_Q.do?bkg_no="+bkgNo;  //C/M
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_07.do?bkg_no="+bkgNo;  //C/M
 					}
 				    break;
 				case 7:  		
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_08_Q.do?bkg_no="+bkgNo;  //
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_08.do?bkg_no="+bkgNo;  //
 					}
 			        break;
 				case 8:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_09_Q.do?bkg_no="+bkgNo;  //BL Issue
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_09.do?bkg_no="+bkgNo;  //BL Issue
 					} 
 			    break;
 				case 9:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0366_Q.do?bkg_no="+bkgNo;  //BL Issue
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0366.do?bkg_no="+bkgNo;  //BL Issue
 					} 
 			    break;
 			}
     	} else {             //Tro : tro tab 1개
             switch(tabIndex) {
 				case 0:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_01_Q.do?bkg_no="+bkgNo;	
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_01.do?bkg_no="+bkgNo;	
 					}
 				    break;
 				case 1:
 					var troTab=formObj.troTab.value;
 					if(isInquiry == "Y"){
 	 					if (troTab == "KOR") {
 	 						sUrl=ctxName + "/ESM_BKG_0079_02B_Q.do?bkg_no="+bkgNo;						
 	 					} else {
 	 						sUrl=ctxName + "/ESM_BKG_0079_02A_Q.do?bkg_no="+bkgNo;
 	 					} 						
 					}else{
 	 					if (troTab == "KOR") {
 	 						sUrl=ctxName + "/ESM_BKG_0079_02B.do?bkg_no="+bkgNo;						
 	 					} else {
 	 						sUrl=ctxName + "/ESM_BKG_0079_02A.do?bkg_no="+bkgNo;
 	 					} 						
 					}
 	                break;
 				case 2:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_04_Q.do?bkg_no="+bkgNo;  //Container
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_04.do?bkg_no="+bkgNo;  //Container
 					}
 	                break;
 				case 3:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_05_Q.do?bkg_no="+bkgNo;  //Customer
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_05.do?bkg_no="+bkgNo;  //Customer
 					}
 	                break;
 				case 4:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_06_Q.do?bkg_no="+bkgNo;  //M&D	
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_06.do?bkg_no="+bkgNo;  //M&D	
 					}
 			        break;
 				case 5:
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_07_Q.do?bkg_no="+bkgNo;  //C/M
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_07.do?bkg_no="+bkgNo;  //C/M
 					}
 				    break;
 				case 6:  	
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_08_Q.do?bkg_no="+bkgNo;  //
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_08.do?bkg_no="+bkgNo;  //
 					}
 			        break;
 				case 7:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0079_09_Q.do?bkg_no="+bkgNo;  //BL Issue
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0079_09.do?bkg_no="+bkgNo;  //BL Issue
 					}
 			        break;
 				case 8:  
 					if(isInquiry == "Y"){
 						sUrl=ctxName + "/ESM_BKG_0366_Q.do?bkg_no="+bkgNo;  //BL Issue
 					}else{
 						sUrl=ctxName + "/ESM_BKG_0366.do?bkg_no="+bkgNo;  //BL Issue
 					} 
 			    break;
 			}
     	}
     	var objTabFrame=document.getElementById("t" + (tabIndex + 1) + "frame");
        
     	var heightPx = getIframeHeight(tabIndex,nTabCnt);
     	objTabFrame.style.height = heightPx+"px";
     	objTabWindow.location.href=sUrl;
     	beforetab=tabIndex;
        return true;
      }
  }   
  
	function getIframeHeight(tabIdx, tabCnt){
		var formObj=document.form;
		var t1frameH = "610";	//BKG Creation
		var t2frameH = "630";	//TRO/O - 기타
		var t3frameH = "610";	//CNTR
		var t4frameH = "930";	//Customer
		var t5frameH = "610";	//M&D
		var t6frameH = "590";	//C/M
		var t7frameH = "620";	//Charge
		var t8frameH = "720";	//B/L Issue
		var t9frameH = "750";	//House B/L
		var t10frameH = "640";	//TRO/O - KOR
		var t11frameH = "640";	//TRO/O - EUR
		var t12frameH = "640";	//TRO/I - EUR
		
		var height;
		if (tabCnt == 10) {  //eurTro : tro tab 2개
			switch(tabIdx) {
				case 0:
				default:
					height=t1frameH;		
				    break;
				case 1:
					height=t11frameH;		
			        break;
				case 2:
					height=t12frameH;		
			        break;
				case 3:
					height=t3frameH;		
			        break;
				case 4:
					height=t4frameH;		
			        break;
				case 5:  
					height=t5frameH;		
			        break;
				case 6:
					height=t6frameH;		
				    break;
				case 7:  		
					height=t7frameH;		
			        break;
				case 8:  
					height=t8frameH;		
			    	break;
				case 9:  
					height=t9frameH;		
			    	break;
			}
		}else{
			switch(tabIdx) {
				case 0:
				default:
					height=t1frameH;		
				    break;
				case 1:
					if(formObj.troTab.value=="KOR")		height=t10frameH;
					else								height=t2frameH;
			        break;
				case 2:
					height=t3frameH;		
			        break;
				case 3:
					height=t4frameH;		
			        break;
				case 4:
					height=t5frameH;		
			        break;
				case 5:  
					height=t6frameH;		
			        break;
				case 6:
					height=t7frameH;		
				    break;
				case 7:  		
					height=t8frameH;		
			        break;
				case 8:  
					height=t9frameH;		
			    	break;
			}
		}
		return height;
	}  
  /**
   * handling process for CA
   */   
    function initCAControl(bkgNo, caFlg, bdrFlg, caExistFlg, blNo) {
    	var formObj=document.form;
    	//01. BkgBlNoVO init
    	formObj.bkg_no.value=nullToBlank(bkgNo); 
    	formObj.ca_flg.value=nullToBlank(caFlg); 
    	formObj.bdr_flg.value=nullToBlank(bdrFlg); 
    	formObj.ca_exist_flg.value=nullToBlank(caExistFlg); 
    	formObj.bl_no.value=nullToBlank(blNo);
    	//02. Booking  : CA btn init
    	initControl(); 
 		if("Y"==openDgPopUp){
 			var bkgTabObj=document.frames("t1frame");
 	 	    bkgTabObj.comBkgCallPop0200(formObj.bkg_no.value, "N");
 		}
    }
    /**
     * handling process for CA
     */   
      function initIssueCAControl(bkgNo, caFlg, bdrFlg, caExistFlg, blNo) {
      	var formObj=document.form;
      	//01. BkgBlNoVO init
      	formObj.bkg_no.value=nullToBlank(bkgNo); 
      	formObj.ca_flg.value=nullToBlank(caFlg); 
      	formObj.bdr_flg.value=nullToBlank(bdrFlg); 
      	formObj.ca_exist_flg.value=nullToBlank(caExistFlg); 
      	formObj.bl_no.value=nullToBlank(blNo);
      	//02. Booking  : CA btn init
      	initControl(); 
      	
      	//03. B/L Issue(9) tab click
      	ComSetDisplay("btn_CAReason",  false); 
      	ComSetDisplay("btn_CACancel",  false); 
      	ComSetDisplay("btn_CAConfirm", false);
      	ComSetDisplay("btn_CAIssue", false);
      	
   		if("Y"==openDgPopUp){
   			var bkgTabObj=document.frames("t1frame");
   	 	    bkgTabObj.comBkgCallPop0200(formObj.bkg_no.value, "N");
   		}
      }    
    /**
     * handling process for Set CA
     */  
	function setCARefresh() {
		if (tabObjects[0].GetSelectedIndex()!= 0) {
			tabObjects[0].SetSelectedIndex(0);
			t1frame.location.href="ESM_BKG_0079_01.do?bkg_no="+ComGetObjValue(document.form.bkg_no);	
		} else {
			t1frame.CARefresh();	
			t1frame.location.href="ESM_BKG_0079_01.do?bkg_no="+ComGetObjValue(document.form.bkg_no);	
		}
		if(document.getElementById("t2frame").contentWindow.location.href != "" && document.getElementById("t2frame").contentWindow.location.href != "about:blank" ){
			t2frame.form.bkg_no.value="";
        }
		if(document.getElementById("t3frame").contentWindow.location.href != "" && document.getElementById("t3frame").contentWindow.location.href != "about:blank" ){
			t3frame.form.bkg_no.value="";
		}
		if(document.getElementById("t4frame").contentWindow.location.href != "" && document.getElementById("t4frame").contentWindow.location.href != "about:blank" ){
			t4frame.form.bkg_no.value="";
		}
		if(document.getElementById("t5frame").contentWindow.location.href != "" && document.getElementById("t5frame").contentWindow.location.href != "about:blank" ){
			t5frame.form.bkg_no.value="";
		}
		if(document.getElementById("t6frame").contentWindow.location.href != "" && document.getElementById("t6frame").contentWindow.location.href != "about:blank" ){
			t6frame.form.bkg_no.value="";
		}
		if(document.getElementById("t7frame").contentWindow.location.href != "" && document.getElementById("t7frame").contentWindow.location.href != "about:blank" ){
			t7frame.form.bkg_no.value="";
		}
		if(document.getElementById("t8frame").contentWindow.location.href != "" && document.getElementById("t8frame").contentWindow.location.href != "about:blank" ){
			t8frame.form.bkg_no.value="";
		}
		if(document.getElementById("t9frame").contentWindow.location.href != "" && document.getElementById("t9frame").contentWindow.location.href != "about:blank" ){
			t9frame.form.bkg_no.value="";
		}
		if(document.getElementById("t10frame").contentWindow.location.href != "" && document.getElementById("t10frame").contentWindow.location.href != "about:blank" ){
			t10frame.form.bkg_no.value="";
		}
		if(document.getElementById("t11frame").contentWindow.location.href != "" && document.getElementById("t11frame").contentWindow.location.href != "about:blank" ){
			t11frame.form.bkg_no.value="";
		}
		if(document.getElementById("t12frame").contentWindow.location.href != "" && document.getElementById("t12frame").contentWindow.location.href != "about:blank" ){
			t12frame.form.bkg_no.value="";
		}
	}
    /**
    * handling process for Tab init
    */  
    function initTroTab() {    	
	   	var formObj=document.form;
	   	var strTroTab=formObj.troTab.value; 
	   	var cnt=0;
        tabName[cnt++]="Booking Creation";
	   	if (strTroTab == "KOR") {
            cnt=0;
            tabName[cnt++]="TRO/A O/B";
	   		tabObjects[0].DeleteItem(4);
	   		tabObjects[0].DeleteItem(3);
	   		tabObjects[0].DeleteItem(1);
	   	} else if (strTroTab == "EUR") {
            tabName[cnt++]="TRO/C O/B";
            tabName[cnt++]="TRO/C I/B";
	   		tabObjects[0].DeleteItem(2);
	   		tabObjects[0].DeleteItem(1);
	   	} else {
            tabName[cnt++]="TRO/B O/B";
	   		tabObjects[0].DeleteItem(4);
	   		tabObjects[0].DeleteItem(3);
	   		tabObjects[0].DeleteItem(2);
	   	}
        tabName[cnt++]="Container";
        tabName[cnt++]="Customer";
        tabName[cnt++]="M&D";
        tabName[cnt++]="C/M";
        tabName[cnt++]="Charge";
        tabName[cnt++]="B/L Issue";
        tabName[cnt++]="House B/L";
        var nTabCnt=tabObjects[0].GetCount();
        var formObj=document.form;
        if(!ComIsNull(formObj.openTab)){
        	if(ComGetObjValue(formObj.openTab) == "B9"){
        		// ChargeTab
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=7;	       		
    	       	} else {             
    	       		tabIndex=6;
    	       	}        		
        	}else if(ComGetObjValue(formObj.openTab) == "B4"){
        		// Container
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=3;	       		
    	       	} else {             
    	       		tabIndex=2;
    	       	}        	        		
        	}else if(ComGetObjValue(formObj.openTab) == "B5"){
        		// Customer
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=4;	       		
    	       	} else {             
    	       		tabIndex=3;
    	       	}        	
        	}else if(ComGetObjValue(formObj.openTab) == "B6"){
        		// M&D
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=5;	       		
    	       	} else {             
    	       		tabIndex=4;
    	       	}        	       	
        	}else if(ComGetObjValue(formObj.openTab) == "B8"){
        		// CM
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=6;	       		
    	       	} else {             
    	       		tabIndex=5;
    	       	}        	   
        	}else if(ComGetObjValue(formObj.openTab) == "B10"){
        		// BL Issue
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=8;	       		
    	       	} else {             
    	       		tabIndex=7;
    	       	}        	    	         		
        	}else if(ComGetObjValue(formObj.openTab) == "B11"){
        		// HOUSE BL
    	       	if (nTabCnt == 10) {  
    	       		tabIndex=9;	       		
    	       	} else {             
    	       		tabIndex=8;
    	       	}              	
        	}else if(ComGetObjValue(formObj.openTab) == "B2"){
    	       	tabIndex=1;
        	}else if(ComGetObjValue(formObj.openTab) == "B3"){
    	       	if (nTabCnt == 10) {
    	       		tabIndex=2;
    	       	} else {
    	       		tabIndex=1;
    	       	}
        	}
        	tabObjects[0].SetSelectedIndex(tabIndex);
        	if (ComIsNull(formObj.bkg_no)) {
        		loadTabPage(tabIndex, false, "");
        	} else {
        		loadTabPage(tabIndex, true, ComGetObjValue(formObj.bkg_no));
        	}
       		ComSetObjValue(formObj.openTab , "");
        }
    }
    /**
    * handling process for Tab enable
    */  
	function setEnabledTroTab(bFlag)
	{
		var formObj=document.form;
		var nTabCnt=tabObjects[0].GetCount();
    	if (nTabCnt == 10) {  //eurTro : tro tab 2개
	    	if (bFlag) {
	    		if (tabObjects[0].GetSelectedIndex()== 1 || tabObjects[0].GetSelectedIndex() == 2) {
	    			tabObjects[0].SetSelectedIndex(0);
	    		}
	    	}	
    	    if (tabObjects[0].GetTabDisable(1) != bFlag) {  
    			tabObjects[0].SetTabDisable(1,bFlag); 
    			tabObjects[0].SetTabDisable(2,bFlag); 
    			tabObjects[0].SetTabDisable(8,bFlag); 
    	    }
    	} else {             //Tro : tro tab 1개
	    	if (bFlag) {
	    		if (tabObjects[0].GetSelectedIndex()== 1) {
	    			tabObjects[0].SetSelectedIndex(0);
	    		}
	    	}
	    	
    	    if (tabObjects[0].GetTabDisable(1) != bFlag) {
			    tabObjects[0].SetTabDisable(1,bFlag); 
    			tabObjects[0].SetTabDisable(7,bFlag); 
    	    }
    	}
	}    
    /**
     * CA Issue: CaStart
     */
    function setCAIssueCallBack(arrPopupData) {
    	caIssSuccess=true;
    	setCARefresh();
        caIssue=false;
    }
