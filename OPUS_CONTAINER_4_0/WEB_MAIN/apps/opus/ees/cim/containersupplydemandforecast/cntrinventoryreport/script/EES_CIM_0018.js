/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0018.js
*@FileTitle  : Land Inventory With CNTR List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0 ;
	var head_cntr_tpsz_cd="";
	var headTitle="";
	var tot_cnmv_sts_cd="";
	var tot_lstm_cd="";
	var IBSEARCH01=29;
	var IBSEARCH02=30;
	var IBSEARCH03=31;
	var IBSEARCH04=32;
	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
	     var shtCnt=0;
	     var sheetObject=sheetObjects[shtCnt++];
	     /*******************************************************/
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":	
					//sheetObjects[0].RemoveAll();//1111
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_more":
	                doActionIBSheet1(sheetObjects[0], formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
	                break;
		        case "btn_new":
		        	ComResetAll();
		        	formObject.reset();
		        	sheetObjects[0].RemoveAll();
				    document.form.view_flg[0].checked=true;
				    view_flg_click(); 
				    setHeadData(sheetObjects[0], 0);
				    document.form.loc_cd.focus();
				    
				    formObject.rstr_usg_lbl.value="";
					formObject.hid_rulabel_type.value="";
				    
				    document.getElementById("locTpCdInput").style.display = "";
		        	document.getElementById("locTpCdCombo").style.display = "none";
		        	comboObjects[0].Code = "";
		        	comboObjects[0].SetItemCheck(0,1);
		        	for(var i=1 ; i < comboObjects[1].GetItemCount() ; i++) {
						comboObjects[1].SetItemCheck(i,0);
					}
					comboObjects[1].SetItemCheck(0,1);
		        	comboObjects[1].SetEnable(0);
		        	
		        	for(var i=0 ; i < comboObjects[0].GetItemCount() ; i++) {
						comboObjects[0].SetItemCheck(i,0);
					}
			        
		        	for(var i=0 ; i < comboObjects[1].GetItemCount() ; i++) {
						comboObjects[1].SetItemCheck(i,0);
					}
		        	
		        	comboObjects[0].SetEnable(1);
		        	comboObjects[1].SetEnable(0);
		        	
		        	document.form.rstr_usg_lbl.readOnly = false;
		        	document.form.rstr_usg_lbl.className = "input";
		        	ComEnableObject(document.form.btn_rulabel_cd, true);
		        	
		        	document.form.loc_cd.readOnly = false;
		        	document.form.loc_cd.className = "input1";
		        	ComEnableObject(document.form.btn_loc_cd, true);
		        	
		        	rtv_total="0";
		        	ComBtnDisable("btn_more");
		        	
		        	document.getElementById("btn_loc_cd").style.display = "";
		        	document.getElementById("btn_loc_multi_cd").style.display = "none";
		        	document.getElementById("loc_cd").maxLength = "7";
					break;
				case "btn_loc_cd":	//Location 조회 팝업
	    	        var cnt_cd="";
	    	        var loc_cd="";
		            cnt_cd=formObject.loc_type_code.value;
		            loc_cd=formObject.loc_cd.value;
		            if ( formObject.loc_type_code.value != '0' ) {	
						if ( formObject.loc_type_code.value == '5' ) {	//yard
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 480, "3:loc_cd", "1,0,1,1,1,1,1", true);
		           		} else {
		        			var loc_code="";
		        			if ( form.loc_type_code.value == "2" ) {
		        				loc_code="lcc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code="ecc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code="scc_cd";
		        			}
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);		           		
		           		}
		            }
					break;
				case "btn_loc_multi_cd":	//Location 조회 팝업
					var formObj=document.form;
				   	var cmdt_cd_val=""; // 향후 사용가능 예정변수
				   	var rep_cmdt_cd_val=""; // 향후 사용가능 예정변수
				   	var cmdt_desc_val=""; // 향후 사용가능 예정변수
				   	var classId="getLse_Multi";
				   	var xx1="loc_cd"; // CONTI
				   	var xx2=""; // SUB CONTI
				   	var xx3=""; // COUNTRY
				   	var xx4=""; // STATE
				   	var xx5=""; // CONTROL OFFIC
				   	var xx6=""; // LOC CODE
				   	var xx7=""; // LOC NAME
				   	var xx8="";
				   	var xx9="";
				   	var param="?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
						+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
						+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
					   	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
					   			'1,0');
					break;
				case "btn_rulabel_cd":	//RU Label 조회 팝업
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
					ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
					break;
				case "btn_movement":
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var cnmv_dt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cnmv_dt");
		                ComOpenWindowCenter("/opuscntr/EES_CTM_0408_POP.do?" +
		                		"p_cntrno=" 	+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no").substring(0,10) + "&" +
		                		"check_digit=" 	+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no").substring(10,11) + "&" +
		                		"ctnr_tpsz_cd=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_tpsz_cd") + "&" +
		                                    "p_date1=" 		+ ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
		                                    "p_date2=" 		+ ComGetDateAdd(cnmv_dt, "M", 0, "-", true) + "&" +
		                                    "pop_mode=1"
		                                    ,"EES_CTM_0408", 1020, 682);						
					}
					break;
				case "btn_master":
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
						var cntr_no_len=cntr_no.length;
						if ( cntr_no_len > 10 ) {
							cntr_no=cntr_no.substring(0,10);
						} 
						//ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?cntr_no="+cntr_no+"&popup_mode=Y",1100, 730, "", "1,0,1,1,1,1,1,1", true);
						ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?cntr_no="+cntr_no+"&popup_mode=Y",1200, 750, "", "1,0,1,1,1,1,1,1", true);
					}
					break;
				case "btn_DownExcel":
//					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
//					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:0,Merge:1 });
					sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
					break;
		        case "btn_print":
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
	
	
	function getLse_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		var AllText = "";
		formObj.loc_cd.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			
			tempText=rowArray[i].toUpperCase();
			if(i == 0) {
				AllText = tempText;
			}else{
				AllText = AllText+","+tempText;
			}
		}
		
		formObj.loc_cd.value = AllText;
		
	}
	
	/**
     * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
     * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
     * @returns string <br>
     */
    function ComToHtml2(obj){
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var str = getArgValue(obj);

            str = str.replace(/&/gi, "@amp;");
            return str;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * setting selected values from Location by loc_cd
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.loc_cd.value=aryPopupData[0][3]  
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
    function initCombo (comboObj, comboNo) {
    	switch(comboObj.options.id) {
	  	/* case "ru_lable_type":
	 		with(comboObj) {
//	    		BackColor = "#CCFFFA";
//	 			DropHeight = 150;
//	 			MultiSelect = false;
//	 			UseAutoComplete = true;
//	 			Style = 0;
//	 			ValidChar(2,3);
	  		SetBackColor("#CCFFFA");
 			SetDropHeight(150);
 			SetMultiSelect(0);
 			 SetMaxSelect(1);
 			SetUseAutoComplete(1);
	 		}
	 	 break;*/
	 	 
	  	/*case "rstr_usg_lbl":
	  		with(comboObj) {
   			SetBackColor("#CCFFFA");
   			SetDropHeight(150);
   			SetMultiSelect(1);
   			SetUseAutoComplete(1);
   			
      	 	SetMultiSeparator(",");
   			//MultiSeparator = "";
   			Style=0;
   		}
	   		break;*/
	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();     	
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
//        document.form.loc_cd.focus();
        sheet1_OnLoadFinish(sheet1);
        document.form.loc_cd.focus();
        
        comboObjects[0].SetEnable(1);
    	comboObjects[1].SetEnable(0);
    	
    	document.form.rstr_usg_lbl.readOnly = false;
    	document.form.rstr_usg_lbl.className = "input";
  	    ComEnableObject(document.form.btn_rulabel_cd, true);
    	
    	/* IBMultiCombo initailizing */
     	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
     		initCombo(comboObjects[k], k+1);
     	}
     	
     	var formObj=document.form;
		ComBtnDisable("btn_more");
		

		document.form.view_customer.disabled=true;
		document.form.view_commodity.disabled=true; 		
    } 
    /**
     * getting data for Period,HEAD,TPSZ
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH01); //Period,HEAD,TPSZ 데이타 가져오기
    	doActionIBSheet(sheetObj,document.form,IBSEARCH03); //Ru Label Code 데이타 가져오기
    	doActionIBSheet(sheetObj,document.form,IBSEARCH04); //페이징 갯수 가져오기
    	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02); 
    	ComSetFocus(document.form.loc_cd);
    }
    /**
     * creating MVMT Status
     */    
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        //MVMT Status
        var arr_cnmv_sts_cd=cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm=cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd=arr_cnmv_sts_cd;
        with (combo_cnmv_sts_cd) {
        	SetMultiSelect(1);
            SetMultiSeparator(",");
            SetDropHeight(320);
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }
    /**
     * registering initial event 
     */
	function initControl() {
     	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', 'next_vvd');			//handling cntr_no keyup event
     	//axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');					//handling LOC_CD keyup event
     	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('click', 'view_flg_click', 'view_flg');						//handling event when changing view
     	axon_event.addListener('click', 'ts_cntr_behind_click', 'ts_cntr_behind');			//handling event when changing EQ-wise,BKG-wise
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				
    	//axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate', form); 	
    	//axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);					//upper case, numbers only
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');	//handling event when changing Location by 
    	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
	}
	/**
     * handling event when clicking TP/SZ
     */
    function combo_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
	/**
     * registering event when clicking MVMT Status 
     */
    function combo_cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }   
	/**
     * registering event when clicking Lease Term 
     */    
    function combo_lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    
    

    /**
     * MultiSelect�띿꽦���댁슜�섎뒗 寃쎌슦, checking諛뺤뒪瑜��대┃�섎뒗 �쒓컙 諛쒖깮�쒕떎.
     * @return
     */
    function rstr_usg_lbl_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    
    
    /**
     * in case of onChange combo event
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function ru_lable_type_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    	comboOnChange(NewIndex,NewText, NewCode);
    }
    
    
    
    /**
     * handling in case of onChange combo event 
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */   
    function comboOnChange(NewIndex,NewText,NewCode){ 	
    	var formObj=document.form;
    	comboObjects[1].RemoveAll();
    	//sheetObjects[1].WaitImageVisible=false;
        form.f_cmd.value=SEARCH02;
        var ruLabelType=NewCode;
        ruLabelType = comboObjects[0].GetSelectCode();
    	var param="&ru_label_type="+ruLabelType;
    	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
    	var chk=sXml.indexOf("ERROR");
    	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
    		 return;
    	}	             
    	 
    	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
        var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
         
        comboObjects[1].InsertItem(0 , 'ALL',''); 
        if(strRstrUsgTblNm.length > 0) {
        	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
        		 var arrCode=strRstrUsgTblNm[i].split("|");
        		 if(arrCode[0] != ""){
        		 	comboObjects[1].InsertItem(i+1, arrCode[0], arrCode[0]);
        		 }
        	}	
        }
        comboObjects[1].SetItemCheck(0,1);
        comboObjects[1].SetEnable(1);
    }
    
    
    
    
    /**
    * handling event when changing Location by
    * deactivating input column when selecting ALL (by RCC)
    * activating the others
    */
    function loc_type_code_onchange() {
//        var formObject=document.form;
//        ComSetFocus(document.form.loc_cd);
	        var formObject = document.form;
	        formObject.rstr_usg_lbl.value = "";
	        formObject.hid_rulabel_type.value = "";
	        formObject.loc_cd.value = "";
	        if(formObject.loc_type_code.value == '6'){
	        	document.form.rstr_usg_lbl.readOnly = false;
	        	document.form.rstr_usg_lbl.className = "input1";
	        	ComEnableObject(document.form.btn_rulabel_cd, true);
	        	
	        	document.form.loc_cd.readOnly = true;
	        	document.form.loc_cd.className = "input2";
	        	ComEnableObject(document.form.btn_loc_cd, false);
	        	//document.getElementById("locTpCdInput").style.display = "none";
	        	//document.getElementById("locTpCdCombo").style.display = "";
	        	/*comboObjects[0].Code = "FLOW";
	        	comboObjects[0].SetItemCheck(0,1);
	        	for(var i=1 ; i < comboObjects[1].GetItemCount() ; i++) {
					comboObjects[1].SetItemCheck(i,0);
				}
				comboObjects[1].SetItemCheck(0,1);
	        	comboObjects[1].SetEnable(1);*/
	        	
	        } else {
	        	document.form.rstr_usg_lbl.readOnly = false;
	        	document.form.rstr_usg_lbl.className = "input";
	        	ComEnableObject(document.form.btn_rulabel_cd, true);
	        	
	        	document.form.loc_cd.readOnly = false;
	        	document.form.loc_cd.className = "input1";
	        	ComEnableObject(document.form.btn_loc_cd, true);
	        	//document.getElementById("locTpCdInput").style.display = "";
	        	//document.getElementById("locTpCdCombo").style.display = "none";
	        	/*comboObjects[0].Code = "";
	        	comboObjects[0].SetItemCheck(0,1);
	        	for(var i=1 ; i < comboObjects[1].GetItemCount() ; i++) {
					comboObjects[1].SetItemCheck(i,0);
				}
				comboObjects[1].SetItemCheck(0,1);
	        	comboObjects[1].SetEnable(0);
	        	
	        	for(var i=0 ; i < comboObjects[0].GetItemCount() ; i++) {
					comboObjects[0].SetItemCheck(i,0);
				}
		        
	        	for(var i=0 ; i < comboObjects[1].GetItemCount() ; i++) {
					comboObjects[1].SetItemCheck(i,0);
				}
	        	
	        	comboObjects[0].SetEnable(1);
	        	comboObjects[1].SetEnable(0);*/
	        }
	        
	        if(formObject.loc_type_code.value == '7' || formObject.loc_type_code.value == '8' || formObject.loc_type_code.value == '9'){
	        	document.getElementById("btn_loc_cd").style.display = "none";
	        	document.getElementById("btn_loc_multi_cd").style.display = "";
	        	
	        	document.getElementById("loc_cd").maxLength = "1000000";
	        }else{
	        	document.getElementById("btn_loc_cd").style.display = "";
	        	document.getElementById("btn_loc_multi_cd").style.display = "none";
	        	document.getElementById("loc_cd").maxLength = "7";
	        }
	        
	        ComSetFocus(document.form.loc_cd);
    	    
    }
	/**
     * registering key event
     */  
	function obj_keypress() {
		var formObject=document.form;
		switch (ComGetEvent("name")) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
				break;
			case "over_stay_days":
				ComKeyOnlyNumber(ComGetEvent());// upper case, numbers only
				break;
			case "froms":
				// activating "-" only in case of numbers 
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "tos":
				// activating "-" only in case of numbers 
				ComKeyOnlyNumber(ComGetEvent());
				break;
		}
	}
    /**
     * handling Location  beforeactivate event
     */    
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
	 * handling Location  beforedeactivate event
	 * handling format YYYY
	 */	
	function obj_deactivate() {
		var f=document.getElementById("froms");
		var t=document.getElementById("tos");
		sVal1=f.value.replace(/\/|\-|\./g, "");
		sVal2=t.value.replace(/\/|\-|\./g, "");
		switch (ComGetEvent("name")) {
		case "froms":
			if (ComChkObjValid(ComGetEvent(), false)) {
				if (f.getAttribute("dataformat") == "yyyy") {
					if (sVal1 != "" && sVal2 != "") {
						var flag=ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (ComGetEvent("name") == "tos") {
								ComGetEvent().value="";
								ComShowCodeMessage("CIM29046");
								enterSwitch=false;
								t.focus();
								t.select();
								return false;
							} else {
								ComGetEvent().value="";
								ComShowCodeMessage("CIM29046");
								enterSwitch=false;
								f.focus();
								f.select();
								return false;
							}
						} 
						enterSwitch=true;
					}
				} 
			} else {
				if (f.getAttribute("dataformat") == "yyyy") {
					if (sVal1.length > 0 && !ComIsDate(sVal1) && ComGetEvent("name") == 'froms') {
						enterSwitch=false;
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYY");
						ComGetEvent().focus();
						ComGetEvent().select();
						return false;
					}
				} 
			}
			break;
		case "tos":
			if (ComChkObjValid(ComGetEvent(), false)) {
				if (t.getAttribute("dataformat") == "yyyy") {
					if (sVal1 != "" && sVal2 != "") {
						var flag=ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (ComGetEvent("name") == "tos") {
								ComGetEvent().value="";
								ComShowCodeMessage("CIM29046");
								enterSwitch=false;
								t.focus();
								t.select();
								return false;
							} else {
								ComGetEvent().value="";
								ComShowCodeMessage("CIM29046");
								enterSwitch=false;
								f.focus();
								f.select();
								return false;
							}
						} 
						enterSwitch=true;
					}
				} 
			} else {
				if (t.getAttribute("dataformat") == "yyyy") {
					if (sVal2.length > 0 && !ComIsDate(sVal2) && ComGetEvent("name") == 'tos') {
						enterSwitch=false;
						ComGetEvent().value="";
						ComShowCodeMessage("CIM21004", "YYYY");
						ComGetEvent().focus();
						ComGetEvent().select();
						return false;
					}
				}
			}
			break;
		}
		return true;
	}
	/**
	 * handling Location  blur event
	 */	
	function obj_blur() {
    	var srcName = window.event.srcElement.getAttribute("name");
    	var formObject = document.form;
    	if (srcName == "loc_cd") {
    		if(formObject.loc_type_code.value != '7' && formObject.loc_type_code.value != '8' && formObject.loc_type_code.value != '9'){
    			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
    		}
    	} 
    	else if (srcName == "froms" || srcName == "tos") {
    		obj_deactivate();
    	}
	}
    /**
	* handling view_flg keyup event
	* upper case when view_flg keyup
	*/
    function view_flg_click() {
    	if ( document.form.view_flg[1].checked ) {
    		document.form.ts_cntr_behind.readOnly=false;
    		document.form.ts_cntr_behind.disabled=false;
    		document.form.ts_cntr_behind.className="input";
    		document.form.view_customer.checked=true;
    		document.form.view_commodity.checked=true;
    		document.form.view_customer.disabled=false;
    		document.form.view_commodity.disabled=false;    		
    		document.form.froms.value="";
    		document.form.tos.value="";
    		div_eq.style.display="none";
    		div_bkg.style.display="";
    	} else {
    		document.form.ts_cntr_behind.readOnly=true;
    		document.form.ts_cntr_behind.disabled=true;
    		document.form.ts_cntr_behind.checked=false;
    		document.form.ts_cntr_behind.className="input2";
    		document.form.next_vvd.disabled=true;
    		document.form.next_vvd.className="input2";
    		document.form.next_vvd.value="";    		
    		document.form.view_customer.checked=false;
    		document.form.view_commodity.checked=false;
    		document.form.view_customer.disabled=true;
    		document.form.view_commodity.disabled=true;    		
    		div_eq.style.display="";
    		div_bkg.style.display="none";
    	}
    }
    /**
	* handling view_flg keyup event
	* upper case when view_flg keyup
	*/
    function ts_cntr_behind_click() {
    	if ( document.form.ts_cntr_behind.checked ) {
    		document.form.next_vvd.disabled=false;
    		document.form.next_vvd.className="input";
    		document.form.next_vvd.readOnly=false;
    	} else {
    		document.form.next_vvd.disabled=true;
    		document.form.next_vvd.readOnly=true;
    		document.form.next_vvd.className="input2";
    		document.form.next_vvd.value="";
    	}
    }
    /**
	* handling LOC_CD keyup event
	* upper case when LOC_CD keyup
	*/
    function loc_cd_onkeyUp() {
        var formObject=document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        if ( formObject.loc_type_code.value == '5' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",7);
	        	    formObject.loc_cd.value=formObject.loc_cd.value.substring(0,7).toUpperCase();
	        	    if ( formObject.loc_cd.value.length == 7 ) {
	        	    	ComSetFocus(document.form.full_flg);
	        	    }
	            }
	        } else {
	            //document.getElementById("loc_cd").setAttribute("maxLength",5);
	        	if(formObject.loc_type_code.value == '2' && formObject.loc_type_code.value == '3' && formObject.loc_type_code.value == '4'){
	        		if ( formObject.loc_cd.value.length == 5 ) {
	        			ComSetFocus(document.form.full_flg);
	        		}
	        	}
	        }
        }
    }
    /**
    * handling cntr_no keyup event
    * upper case when cntr_no keyup
    */
    function cntr_no_onkeyUp() {
        var formObject=document.form;
        formObject.cntr_no.value=formObject.cntr_no.value.toUpperCase();
        formObject.next_vvd.value=formObject.next_vvd.value.toUpperCase();
    }
    /**
	* handling view_customer click event
	* view option for shpr cnee ntfy 
	*/	
    function view_customer_click() {
    	if ( document.form.view_customer.checked ) {
    		sheetObjects[0].SetColHidden("shpr",0);
    		sheetObjects[0].SetColHidden("cnee",0);
    		sheetObjects[0].SetColHidden("ntfy",0);
    	} else {
    		sheetObjects[0].SetColHidden("shpr",1);
    		sheetObjects[0].SetColHidden("cnee",1);
    		sheetObjects[0].SetColHidden("ntfy",1);
    	}
    }
    /**
	* handling view_commodity_click click event
	* view option rep_cmdt_nm, mk_desc 
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[0].SetColHidden("rep_cmdt_nm",0);
    		sheetObjects[0].SetColHidden("mk_desc",0);
    	} else {
    		sheetObjects[0].SetColHidden("rep_cmdt_nm",1);
    		sheetObjects[0].SetColHidden("mk_desc",1);
    	}
    }
    
	/**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo,headTitle,viewFlag) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      //sheet1 init
        		with (sheetObj) {
	        	    if (headTitle==null || headTitle =="") {
	        	        viewFlag = 'eq';
	        	        headTitle = "Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|Term|MVMT|F/M|Cargo Type|Event Date|S.Days|Gross Weight(KG)|Tare Weight(KG)|Pay Load(KG)|RU Label Type|RU Label Value|Maker|Model No.|Unit Type|Humidity Control|R/D Term|BKG No.|B/L No.|EQR Ref. No.|SHPR|";
	        	        headTitle += "CNEE|NTFY|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|UC|PF|CMDT|CMDT(Customs)|AGMT No.|Lessor Code|Lessor|M/Date|APNT BKG No.";
	        	    }
	        	    var headCount=ComCountHeadTitle(headTitle);
	        	    sheetObj.FrozenCols=4;
	        	    SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	    var headers = [ { Text:headTitle, Align:"Center"} ];
	        	    InitHeaders(headers, info);
	        	    var cols = [ {Type:"Seq",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"Seq",                     KeyField:0,   CalcLogic:"",   Format:"" },
	        	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_loc_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	        	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
	        	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
	        	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"" } ];
	        	    
	        	    if ( viewFlag == 'eq') {
	        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",                KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",                 KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"stay_days",               KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tare_wgt",                KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_load",                KeyField:0,   CalcLogic:"",   Format:"" });
	        	    //cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_nm",         KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_tp",         KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_desc",       KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rf_mkr_seq",         	   KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rf_mdl_nm",         	   KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rf_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"" });	        	    
	        	    cols.push({Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rf_humid_ctrl_val_cd",    KeyField:0,   CalcLogic:"",   Format:"" });
	        	    if ( viewFlag == 'eq') {
		        	    if ( eval(document.form.over_stay_days.value) > 0 ) {
			        	    cols.push({Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ft_dys",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			        	    cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ft_end_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			        	    cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"act_dys",                 KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		        	    }
		        	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",              KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"" });      	    
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ref_id",                  KeyField:0,   CalcLogic:"",   Format:"" });
	        	    if ( viewFlag == 'bkg') {
		        	    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                     KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"next_vvd",                KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",                 KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr",                    KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee",                    KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntfy",                    KeyField:0,   CalcLogic:"",   Format:"" });
	        	    if ( viewFlag == 'bkg') {
	        	    	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_no",               KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    if ( viewFlag == 'eq') {
		        	    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",                 KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",              KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",            KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"disp_flg",                KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"uclm_ls_flg",             KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"plst_flr_flg",            KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    if ( viewFlag == 'bkg') {
		        	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",              KeyField:0,   CalcLogic:"",   Format:"" });		        	    
	        	    }
	        	    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rep_cmdt_nm",             KeyField:0,   CalcLogic:"",   Format:"" });
	        	    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mk_desc",                 KeyField:0,   CalcLogic:"",   Format:"" });
	        	    if ( viewFlag == 'bkg') {
	        	    	cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"" });
	        	    }
	        	    if ( viewFlag == 'eq') {
	        	    	cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"" });
	        	    	cols.push({Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"lessor_cd",               KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Text",      Hidden:0,  Width:300,   Align:"Left",    ColMerge:1,   SaveName:"lessor",                  KeyField:0,   CalcLogic:"",   Format:"" });
		        	    cols.push({Type:"Date",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"mft_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd" });
	        	    } 
	        	    if ( viewFlag == 'bkg') {
		        	    if ( document.form.loc_cd.value.substring(0,2) == 'US' ) {
			        	    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",                 KeyField:0,   CalcLogic:"",   Format:"" });
			        	    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",             KeyField:0,   CalcLogic:"",   Format:"" });
			        	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"obl_rdem_flg",            KeyField:0,   CalcLogic:"",   Format:"" });
			        	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_flg",           KeyField:0,   CalcLogic:"",   Format:"" });
			        	    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dty_free_dt",             KeyField:0,   CalcLogic:"",   Format:"" });
		        	    }
		        	    cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"gwgt",                    KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		        	    cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pwgt",                    KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		        	    cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"twgt",                    KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
	        	    }
	        	    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"apnt_bkg_no",             KeyField:0,   CalcLogic:"",   Format:"" });
	        	InitColumns(cols);
        	    //SetSheetHeight(340);
        	    resizeSheet();
        	    SetEditable(0);
               }
               break;
        }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    /**
     * setting sheet header
     * changing header by option EQ-wise,BKG-wise checkbox
     */
    function setHeadData(sheetObj) {
	 	var headTitle="";
	 	var viewFlag="";
	 	var subLoc="";
	 	if ( document.form.loc_type_code.value == '1') {
	 		subLoc="LCC"; //In case of RCC 
	 	} else if  ( document.form.loc_type_code.value == '2') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '3') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '4') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '5') {
	 		subLoc="SCC";
	 	}else if  ( document.form.loc_type_code.value == '6') {
	 		subLoc="SCC";
	 	}else if  ( document.form.loc_type_code.value == '7') {
	 		subLoc="SCC";
	 	}else if  ( document.form.loc_type_code.value == '8') {
	 		subLoc="SCC";
	 	}else if  ( document.form.loc_type_code.value == '9') {
	 		subLoc="SCC";
	 	}
	 	
	 	if ( document.form.view_flg[0].checked == true ) {	//EQ-wise
	 		headTitle="Seq.|"+subLoc+"|Yard|CNTR No.|TP/SZ|Term|MVMT|F/M|Cargo Type|Event Date|S.Days|Gross Weight(KG)|Tare Weight(KG)|Pay Load(KG)|RU Label Type|RU Label Value|Maker|Model No.|Unit Type|Humidity Control";
            if ( eval(document.form.over_stay_days.value) > 0 ) {
            	headTitle += "|F.Days|End Date|Act S.Ds";
            }
            headTitle += "|R/D Term|BKG No.|B/L No.|EQR Ref. No.|SHPR|";
            headTitle += "CNEE|NTFY|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|UC|PF|CMDT|CMDT(Customs)|AGMT No.|Lessor Code|Lessor|M/Date|APNT BKG No.";
		 	viewFlag = "eq";
	 	} else {	//BKG-wise
	 		var strPolEtc='';
	 		if (document.form.ts_cntr_behind.checked && (document.form.next_vvd.value == '' || document.form.next_vvd.value != '') ) {
	 			strPolEtc='POL ATD';
	 		} else if ( !document.form.ts_cntr_behind.checked && document.form.next_vvd.value == '' ) {
	 			strPolEtc='POL ETD';
	 		}
	 		headTitle="Seq.|"+subLoc+"|Yard|CNTR No.|TP/SZ|MVMT|F/M|Cargo Type|Event Date|S.Days|Gross Weight(KG)|Tare Weight(KG)|Pay Load(KG)|RU Label Type|RU Label Value|Maker|Model No.|Unit Type|Humidity Control|BKG No.|B/L No.|EQR Ref. No.|POR|DEL|Disc VVD|Load VVD|"+strPolEtc+"|SHPR|";
            headTitle += "CNEE|NTFY|SC/RFA No.|R/D Term|CMDT|CMDT(Customs)|Sales OFC";
            if ( document.form.loc_cd.value.substring(0,2) == 'US' ) {
            	headTitle += "|IT No.|F|O|C|LFD";
            }
            headTitle += "|G.WGT|P.WGT|T.WGT|APNT BKG No.";
		 	viewFlag = "bkg";
	 	}
	 	sheetObjects[0] = sheetObjects[0].Reset();
	 	initSheet(sheetObjects[0], 1, headTitle, viewFlag);
    }
    
    /**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	var lstTotal = sheetObj.GetEtcData("rtv_total");
    	if (sheetObj.RowCount()< lstTotal) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }		
    	sheetObj.SetWaitImageVisible(0);
    	ComOpenWait1(false);    	
    }
    
    /**
     * handling process for Sheet
     */    
    function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
    	switch(sAction) {
    	case IBSEARCHAPPEND:
    		if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
	        setTimeout( function () {	        	
				sheetObj.SetWaitImageVisible(0);				
				sheet1.DoSearchFx("EES_CIM_0018GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
 			} , 100);
	        
			break;
    	}
    }
    
    /**
     * handling process for Sheet
     */    
    function doActionIBSheet(sheetObj, formObj, sAction, cnmv_sts_cd , cnmv_sts_nm) {
        switch(sAction) {        	
	      	case IBSEARCH:      //조회
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait1(true);
	            document.form.cntr_tpsz_cd.value=combo_cntr_tpsz_cd.GetSelectCode();
	            document.form.cnmv_sts_cd.value=combo_cnmv_sts_cd.GetSelectCode();
	            document.form.lstm_cd.value=combo_lstm_cd.GetSelectCode();
	            
	            
	            formObj.cnt_cd.value=formObj.loc_cd.value.substring(0,2);	  //US check
		        setHeadData(sheetObj);	  //changing header by option EQ-wise,BKG-wise checkbox
		        view_customer_click();
		        view_commodity_click(); 
		  	    formObj.f_cmd.value=SEARCH;
		  	    sheetObj.SpeedOption="NOPROGRESSTICK, NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO,NOFORMAT";
		  	    //sheetObj.SetWaitImageVisible(1);
		        //ComOpenWait(false); 
		        setTimeout( function () {
					rowTotal = 0;
					rtv_total=rowTotal;					
					if(Number(rowTotal) > formObj.pagerows.value) {
						ComBtnEnable("btn_more");
					}else{
						ComBtnDisable("btn_more");
					}
					
					appendPageNo=1;
					appendCondParam = FormQueryString(formObj);	
			  	    sheet1.DoSearchFx("EES_CIM_0018GS.do",FormQueryString(formObj) );
     			} , 100);
		        sheetObj.SetWaitImageVisible(0);
	            break;
	       	case IBSEARCH01:     
	       		sheetObj.SetWaitImageVisible(0);
	           	form.f_cmd.value=SEARCH01;
 	           	var sXml=sheetObj.GetSearchData("EES_CIM_0018GS.do" , FormQueryString(form));
	           	//retrieving TP/SZ
	           	var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   
	           	head_cntr_tpsz_cd=cntr_tpsz_cd;
	           	document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd;
	           	var strCntrTpszCd=cntr_tpsz_cd.split("|");
	           	with (combo_cntr_tpsz_cd) {
	          	 	SetMultiSelect(1);
	          	 	SetMultiSeparator(",");
	          	 	SetDropHeight(330);
	          	 	InsertItem(0 , 'ALL','');
	          	 	for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
	          	 		InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	          	 	}
	           	}                  
			 	//Lease Term
			 	var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
			 	var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
			 	var arrLeaseTermNm=sLeaseTermNm.split("|");
			 	var arrLeaseTermCd=sLeaseTermCd.split("|");
			 	tot_lstm_cd=arrLeaseTermCd;
			 	with (combo_lstm_cd) {
			 		SetMultiSelect(1);
			 		SetMultiSeparator(",");
			 		SetDropHeight(320);
			 		InsertItem(0 , 'ALL','');
			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
			 		}
			 	}                     
			 	break;
			case IBSEARCH02: //location focusOut
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel="E";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel="S";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel="Y";
				}
				if(formObj.loc_type_code.value != 6 ){
					formObj.inquiryLevel.value=inquiryLevel;
					formObj.location.value=formObj.loc_cd.value;
					formObj.f_cmd.value=SEARCH02;
					if (formObj.loc_cd.value == "") {
						return false;
					}
					sheetObj.SetWaitImageVisible(0);
	 				var sXml=sheetObj.GetSearchData("EES_CIM_0018GS.do",FormQueryString(formObj));
					var sCheck=ComGetEtcData(sXml, "check");
					if (sCheck != "OK") {
						if (document.form.loc_cd.value != "") {
							ComShowCodeMessage("CIM29013");
							document.form.loc_cd.value="";
							ComSetFocus(document.form.loc_cd);
							return false;
						} else {
							return true;
						}
					} else {
						ComSetFocus(document.form.full_flg);
						return false;
					}
				}
				break;	
				
			case IBSEARCH03:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD20097';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");
					comboObjects[0].RemoveAll();
					//comboObjects[0].InsertItem(0, "", "");
					for (var i=0; i<arrStr.length; i++) {
						var arrCode=arrStr[i].split("|");
						comboObjects[0].InsertItem(i, arrCode[1] , arrCode[0]);
					}
					comboObjects[0].SetSelectIndex("0" ,false);
				}
				break;
		
			case IBSEARCH04:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30029';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");					
					var arrCode=arrStr[0].split("|");
					formObj.pagerows.value=arrCode[0];
				}
				break;
	   		case IBDOWNEXCEL:     
	   			if(sheetObj.RowCount() < 1){//no data
	      			ComShowCodeMessage("COM132501");
	      		}else{
	   				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	      		}
	   			break;
	   			
	   		case IBSEARCH_ASYNC02:
	   	    	/*sheetObj.SetWaitImageVisible(0);
	   	    	var ruLabelType="FLOW";
	   	    	var param="&ru_label_type="+ruLabelType;   	    	
	   	        form.f_cmd.value=SEARCH02;
	   	        var sXml=sheetObj.GetSearchData("EES_MST_0051GS.do" , FormQueryString(formObj)+param);
	   			var chk=sXml.indexOf("ERROR");
	   			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
	   				 sheetObj.LoadSearchData(sXml,{Sync:1} );
	   				 return;
	   			}	             
	   	         
	   			with (rstr_usg_lbl) {
	          	 	SetMultiSelect(1);
	          	 	SetMultiSeparator(",");
	          	 	SetDropHeight(150);
	           	}   
	   			
	   	        var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
	   	        var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
	   	         
	   	        comboObjects[1].RemoveAll();
	   	        comboObjects[1].InsertItem(0 , 'ALL',''); 
   	        	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
   	        		 var arrCode=strRstrUsgTblNm[i].split("|");
   	        		 if(arrCode[0] != ""){
   	        			 comboObjects[1].InsertItem(i+1, arrCode[0], arrCode[0]);
   	        		 }
   	        	}	
	   	        comboObjects[1].SetItemCheck(0,1);
	   	        comboObjects[1].SetEnable(1);*/
	   	        break;

        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		var sVal1=formObj.froms.value.replace(/\/|\-|\./g, "");
    		var sVal2=formObj.tos.value.replace(/\/|\-|\./g, "");
    		if(formObj.loc_type_code.value == '6'){
    			if(formObj.rstr_usg_lbl.value == "") {
	    	  		ComShowMessage(msgs["CIM30024"]);	//RU Label Input is Mandatory.
	    	  		formObj.rstr_usg_lbl.focus();
	    	  		return false;
	    	  	}
    		}
    		
    		if(formObj.loc_type_code.value == '7' || formObj.loc_type_code.value == '8' || formObj.loc_type_code.value == '9'){
    			if(formObj.loc_type_code.value != "6"){
    	    	  	if(formObj.loc_type_code.value != "" && formObj.loc_cd.value == "") {
    	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
    	    	  		formObj.loc_cd.focus();
    	    	  		return false;
    	    	  	}
     	    	}
	    	  	if (!ComChkValid(formObj)) return false;
    		}else{
	    	  	if ( doActionIBSheet(sheetObjects[0], formObj, IBSEARCH02) ) {	//Location 유효성체크
	    	  		formObject.loc_cd.focus();
	     	        return false;
	     	    } else {
	     	    	if(formObj.loc_type_code.value != "6"){
	    	    	  	if(formObj.loc_type_code.value != "" && formObj.loc_cd.value == "") {
	    	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	    	  		formObj.loc_cd.focus();
	    	    	  		return false;
	    	    	  	}
	     	    	}
		    	  	if (!ComChkValid(formObj)) return false;
	     	    }
    		}
    	  	
    	  	if(sVal1 == "" && !sVal2 == ""){
				ComShowCodeMessage("CIM30022","M/Date From Year");
				formObj.froms.focus();
				formObj.froms.select();
				return false;
			}else if(sVal1 != "" && sVal2 == ""){
				ComShowCodeMessage("CIM30022","M/Date To Year");
				formObj.tos.focus();
				formObj.tos.select();
				return false;
			}
    	}
    	return true;
    }
    
    function obj_keyup() {
    	var srcName = window.event.srcElement.getAttribute("name");
    	if (srcName == "loc_cd") {
    		loc_cd_onkeyUp();
    	}
    }
    
    
    function ComOpenWait1(flag, bOpenLayer){
        try {
            if(flag == isOpenWaitWindow ) return;
            isOpenWaitWindow = flag;
            if(flag) {
            	var waitW   = 60;
            	var waitH   = 60;
            	var waitImage = "style/images/theme_default/waiting.gif";
            	
            	var ifr = document.getElementById("waitiframe");
            	if (ifr==null){
                	$('<div class="layer_wait"> </div>').appendTo("body");
                	//$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");            	
                	//$('<IFRAME id="waitiframe" name="waitiframe" frameBorder="0" name="iFrm" src="'+waitImage+ '"scrolling="no" width="'+waitW + '" height="' + waitH + '"></IFRAME>').appendTo(".layer_wait")
        
                	$("body").prepend("<div class='layer_wait_bg'></div>");        	
            	}

            	//open wait image
            	$(".layer_wait_bg,.layer_wait").fadeIn(100);

            	//position center
            	$(".layer_wait").css({
                	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
                	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
            	});
            } else {
            	//close wait image
            	$(".layer_wait_bg,.layer_wait").fadeOut(100);
            }
        } catch(err) {ComFuncErrMsg(err.message); }
        return true;
    }
