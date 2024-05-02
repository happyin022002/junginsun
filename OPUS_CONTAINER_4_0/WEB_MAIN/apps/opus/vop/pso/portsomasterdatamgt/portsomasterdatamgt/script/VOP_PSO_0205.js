/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0205.js
*@FileTitle  : Service Provider Help 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	// public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var usrOfcCd="";/*office cd of SSO user*/
    var isShift=false;
    // Event handler processing by button click event
    
    document.onclick=processButtonClick;
    // Event handler processing by button name
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
            switch(srcName) {
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				break;
    			case "btn_OK":
    				comPopupOK();
    				break;
    			case "btn_Close":
    				ComClosePopup(); 
    				break;
    			case "btns_search":
    				var sUrl="/opuscntr/COM_ENS_0M1.do";
					ComOpenPopup(sUrl, 600, 470, "getCntCdData", "0,1,1,1,1,1,1,1", false);
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
     * Setting Country Code
     * @param obj
     * @return
     */
    function getCntCdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vndr_cnt_cd.value=rtnDatas[3];
				}
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
    	var formObject=document.form;
    	formObject.ofc_cd.value=usrOfcCd; //ofc cd
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(i=0;i<sheetObjects.length;i++){
        	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        initControl();
        self.focus();
    }
    
    /**
     * registering initial event 
     * @return
     */
    function initControl(){
    	//axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	//axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
    	axon_event.addListenerForm('keyup', 'obj_keyup', form);
    	axon_event.addListenerFormat('focus',   'obj_activate',    form);
    }
    
    function obj_activate(){
    	ComSetFocus(ComGetEvent());
  	}
    
    function obj_keydown(){
    	isShift=event.shiftKey ? true : false;
    	ComKeyEnter();
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetid=sheetObj.id;
    	switch(sheetid) {
			case "sheet1":
				with(sheetObj){
			        var HeadTitle1="|S/P Code|Service Provider Name|Delete|Canal";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        var prefix="sheet1_";

			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);

			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"delt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cnl_agn_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }  ];
			       
			        InitColumns(cols);
			        SetEditable(0);
			    	//SetSheetHeight(202);
			        resizeSheet(sheetObj);
				}
				break;
    	}
    }
    
    /**
    *  handling sheet process
    */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.SetWaitImageVisible(0);
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("VOP_PSO_0205GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		                ComOpenWait(false);
					}
					else if(sheetObj.id=="sheet2"){
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("VOP_PSO_0205GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
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
			var ofcCd=ComTrim(ofc_cd.value); 
			var vndrCntCd=ComTrim(vndr_cnt_cd.value);
			var vndrLglEngNm=ComTrim(vndr_lgl_eng_nm.value);
			switch(sAction) {
				case IBSEARCH:
					if(ofcCd == "" && vndrCntCd == ""){
						if(vndrLglEngNm == ""){
							ComShowCodeMessage("PSO00036", "[Office or Country]");
							ofc_cd.focus();
							return false;
						}
					}
				break;
			}
		}	
        return true;
    }
    
    /**
     * Handling grid double click process
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	comPopupOK();
    }
    
     
    function resizeSheet(){
    	for (var i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
