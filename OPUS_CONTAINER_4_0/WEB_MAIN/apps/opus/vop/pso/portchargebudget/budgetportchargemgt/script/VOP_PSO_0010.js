/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0010.js
*@FileTitle : Estimate Expense Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/*******************************************************************************
 * Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5;
 * REMOVELIST=6; MULTI=7; Other Case: COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

 // public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    var isShift=false;
    var arrChk=[0, 0, false];
	var ROWMARK="|";
	var FIELDMARK=",";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
	     var sheetObject1=sheetObjects[0];
	     var sheetObject2=sheetObjects[1];
	     /** **************************************************** */
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "btn_port_cd":
					var sUrl="/opuscntr/VOP_VSK_0043.do";
					ComOpenPopup(sUrl, 422, 510, "portCallBack", "0,0", true);
					break;
	            case "btn_detail":
	            	sUrl="/opuscntr/VOP_PSO_0213.do?";
	            	sUrl += "sdt="+formObject.txtsdate.value + "&edt="+formObject.txtedate.value
							+"&vslCd="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vsl_cd")
							+"&skdVoyNo="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_skd_voy_no")
							+"&skdDirCd="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_skd_dir_cd")
							+"&ydCd="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_tmnl_code")
							+"&revYrmon="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_rev_yrmon")
							+"&exeYrmon="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_exe_yrmon")
							+"&clptIndSeq="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_clpt_ind_seq")
                            +"&hideVrtlPortFlg="+ComGetObjValue(formObject.hide_vrtl_port_flg)//2016.08.26 add
							+"&psoBztpCd=2" // 2009.12.07 add
	            		 ;
	        		ComOpenPopup(sUrl, 1030, 625, "", "0,0", true);
	        		break;
	            case "btns_search":
	            	openLaneCode();
	            	break;
	            case "btns_calendar_r":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
		            cal.select(form.exe_yrmon, "yyyy-MM");
	            	break;
	            case "btns_calendar_s":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
		            cal.select(form.txtsdate, "yyyy-MM");
	            	break;
	            case "btns_calendar_e":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.select(form.txtedate, "yyyy-MM");
	            	break;
	            case "btn_vvd_search":
					var vsl_cd=formObject.vsl_cd.value;
	            	var sUrl="";
	            	if(vsl_cd == ""){
	            		sUrl="/opuscntr/VOP_VSK_0219.do";
	            		ComOpenPopup(sUrl, 500, 480, "getVslCdData", "0,0", true);
	            	}else{
	            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		ComOpenPopup(sUrl, 340, 400, "getVvdData", "0,0", true);
	            	}
				break;
	          case "btn_retrieve":
		  			if(!checkVvd(document.form)) break;
		  			ComSetObjValue(document.form.status, "");
		  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
	          case "btn_new":
		  			clearConditon(document.form);
					break;
	          case "btn_exp":
	        	    if(arrChk[2] == false){
	        		    ComShowCodeMessage("PSO00039");
	        		    setInitCheckRowObject();
	        		    return;
	        	    }
	        	    //2016.10.20 Add 한번더 Check Row 체크.
	        	    var tmpChkRows = sheetObjects[0].CheckedRows("sheet1_chk");
                    if(tmpChkRows == 1){
                        ComSetObjValue(document.form.status, "");
                        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    }else{
                        ComShowCodeMessage("PSO00039");
                        setInitCheckRowObject();
                        return;
                    }
					
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
	
	function setLaneCode(rtnVal){
		if(rtnVal){
			document.form.lane.value=rtnVal;
		}
	} 
    /**
	 * If one of VVD items is inputted, then all VVD items have to inputted
	 * 
	 * @param formObj
	 * @return
	 */
    function checkVvd(formObj){
    	formObj.vvd.value=""; 
    	/*
		 * if( formObj.vsl_cd.value != "" ||formObj.skd_voy_no.value != ""
		 * ||formObj.skd_dir_cd.value != "") { if(formObj.vsl_cd.value == "") {
		 * ComShowCodeMessage("PSO00031"); formObj.vsl_cd.focus(); return false; }
		 * else if(formObj.skd_voy_no.value == "") {
		 * ComShowCodeMessage("PSO00032"); formObj.skd_voy_no.focus(); return
		 * false; } else if(formObj.skd_dir_cd.value == "") {
		 * ComShowCodeMessage("PSO00033"); formObj.skd_dir_cd.focus(); return
		 * false; } else{ formObj.vvd.value=formObj.vsl_cd.value +
		 * formObj.skd_voy_no.value + formObj.skd_dir_cd.value; return true; } }
		 */
    	formObj.vvd.value=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
    	return true;
    }
    /**
	 * Clearing conditions
	 * 
	 * @return
	 */	
    function clearConditon (formObj)
    {
    	formObj.reset();
    	// setToday(document.form.txtsdate, "ym");//setting current year
    	// setDateAdd(document.form.txtsdate,"M",-5);
     	// setToday(document.form.txtedate, "ym");//setting current year
     	// setToday(document.form.rev_yrmon, "ym");//current month
		
    	initCoditionDate();     	
     	
     	sheetObjects[0].RemoveAll();// Grid Clear
     	yard_cd.RemoveAll();
     	
    }
    /**
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen
	 */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
        // doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initControl();
	}
    function initCombo(comboObj, comboNo) {
		var formObject=document.form;
		switch(comboObj.options.id) {  
			case "yard_cd":		// Yard
				with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetDropHeight(190);
					SetMaxLength(2);
					ValidChar(2, 1);
				}
			break; 
		}
	}  
    function initCoditionDate(){
		var tmpExeYm = ComGetDateAdd(ComGetNowInfo("ym")+"01","M",-1,"-").substring(0,7);
		
		document.form.exe_yrmon.value=tmpExeYm;
		
		tmpExeYm = tmpExeYm+"-01";		
		
		var tmpFrYm = ComGetDateAdd(tmpExeYm,"M", -6);
		var tmpToYm = ComGetDateAdd(tmpExeYm,"M", 1);
		document.form.txtsdate.value=gf_GetDateFormat(tmpFrYm,"ym"); 
		document.form.txtedate.value=gf_GetDateFormat(tmpToYm,"ym");
    }
     /**
		 * registering initial event
		 */
	function initControl(){
		axon_event.addListener ('keydown', 'obj_keydown', 'form');
		// axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm('keyup', 'obj_keyup', form);
		//axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form);
		axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form);
		
		initCoditionDate();

	}
	
	function obj_keydown(){
	  	isShift=event.shiftKey ? true : false;
	  	ComKeyEnter();
	}
	/**
	 * Handling onBlur event
	 */
	function obj_blur(){
		var formObj=document.form;
 	   	obj=ComGetEvent();
 	   	if(obj.name=="txtsdate" || obj.name=="txtedate"){
 	   		var creDtFr=ComReplaceStr(txtsdate.value,"-","");
 	   		var creDtTo=ComReplaceStr(txtedate.value,"-","");
 	   		switch(ComGetEvent("name")) {
 	   			case "txtsdate":	// Agreement From Date
   					if(creDtFr != '' && creDtTo != ''){
	    				if(creDtFr > creDtTo){
	    					ComShowCodeMessage('COM12133','To date','From date','greater');
	    					txtsdate.value='';
	    					document.form.txtsdate.focus();
	    					return false;
	    				}
	    			}
	    	        break;
	    		case "txtedate":	// Agreement To Date
	    			if(creDtFr != '' && creDtTo != ''){
	    				if(creDtFr > creDtTo){
	    					ComShowCodeMessage('COM12133','To date','From date','greater');
	    					txtedate.value='';
		    				txtedate.focus();
		    				return false;
	    				}
		    		}
		    	    break;	
   			}
   			ComChkObjValid(event.srcElement);
	   	}
	   	return true;	
 	}
  
  	/**
	 * Handling onFocus event
	 */
  	function obj_focus(){
  		ComClearSeparator(event.srcElement);
  	}
     
    /**
	 * Handling key up event
	 */
 	function obj_keyup() {
 		var eleObj=event.srcElement;
 		var formObj=document.form;
		if (!event.keyCode) return true;
		if(event.keyCode ==9 || isShift ){
			// alert(event.keyCode);
			return true;
		}
 		switch (eleObj.name) {
			// case "txtsdate":
			// if (eleObj.value.length == 6) {
			// formObj.txtedate.focus();
			// }
			// break;
			// case "txtedate":
			// if (eleObj.value.length == 6) {
			// formObj.lane.focus();
			// }
			// break;
	 		case "lane":
	 			if (eleObj.value.length == 3) {
	 				formObj.vsl_cd.focus();
	 			}
	 			break;
	 		case "vsl_cd":
	 			if (eleObj.value.length == 4) {
	 				formObj.skd_voy_no.focus();
	 			}
	 			break;
	 		case "skd_voy_no":
	 			if (eleObj.value.length == 4) {
	 				formObj.skd_dir_cd.focus();
	 			}
	 			break;
	 		case "port_cd":
				if(eleObj.value.length == 5){
					doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
				}else{
					yard_cd.RemoveAll();
				}
				break;
	 		default:
	 			break;
 		}
 	}
  /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
			case "sheet1":
				with(sheetObj){
			    var HeadTitle1="|Seq.|Rev. Month|LANE|VVD|CHK|Turning Port|TMNL Code|Port Seq.|Activity Date(ATD/ETD)|Estimate Cost(USD)|Color|hvvd|vsl_cd|skd_voy_no|skd_dir_cd|turn_port_ind_cd|turn_skd_voy_no|turn_skd_dir_cd|clpt_ind_seq|vir_turn_port_flg|vir_turn_port_ind_cd|exe_yrmon";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			    var prefix="sheet1_";

			    SetConfig( { SearchMode:2, MergeSheet:1, Page:200, FrozenCol:0, DataRowMerge:0 } );

			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:60,   	Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Date",      Hidden:0, Width:150,  	Align:"Center",  ColMerge:0,   SaveName:prefix+"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:75,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:150,  	Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0, Width:50,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:100,  	Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_port_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:200,  	Align:"Center",  ColMerge:0,   SaveName:prefix+"tmnl_code",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:100,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"clpt_ind_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:200,  	Align:"Center",  ColMerge:0,   SaveName:prefix+"act_dt",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0, Width:150,  	Align:"Right",   ColMerge:0,   SaveName:prefix+"estm_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",            PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"txtcolor",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"hvvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_port_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"vir_turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"vir_turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"exe_yrmon",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);

			      SetEditable(1);
			      SetColProperty(0,prefix+"act_dt", {Format:"####-##-##"} );
			      // SetSheetHeight(447);
			      resizeSheet(sheetObj);
				}
				break;
        	}
    }
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	// sheetObj.ColumnSort("sheet1_rev_yrmon|sheet1_lane|sheet1_vvd");
    	/*
		 * var prefix = "sheet1_"; var varBackColor = "#000000"; with(sheetObj){
		 * for(var i=HeaderRows(); i<=LastRow(); i++){ var turnPortIndCd =
		 * GetCellValue(i, prefix+"turn_port_ind_cd"); var txtcolor =
		 * GetCellValue(i, prefix+"txtcolor"); if("V" ==turnPortIndCd || "D" ==
		 * turnPortIndCd || "F" == turnPortIndCd){ SetRowEditable(i, 0); }else{
		 * SetRowEditable(i, 1); }
		 * 
		 * if("Red" == txtcolor){ varBackColor = "#FF0000"; } else if("Blue" ==
		 * txtcolor){ varBackColor = "#0054FF"; } else if("Pink" == txtcolor){
		 * varBackColor = "#F44EDC"; } SetRowBackColor(i, varBackColor);
		 * //SetRowFontColor(i, varBackColor); } }
		 */
		
    	ComOpenWait(false);
    	
    	//Check Row 변수 초기화.
    	setInitCheckRowObject();
        
    }
    
    function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		if(checkVvd(document.form)){
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
		}
		
    }
    
    function setInitCheckRowObject(){
        arrChk=[0, 0, false];
    }
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      // Retrieving
              	if (validateForm(sheetObj, formObj, sAction)){
					if (sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						formObj.mismatched.value=formObj.mismatched.checked == true ? "checked" : "";

                        sheetObj.SetWaitImageVisible(0);
                        ComOpenWait(true);
                        
						//2016.10.19 Modify
						//sheetObj.DoSearch("VOP_PSO_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						var sXml=sheetObj.GetSearchData("VOP_PSO_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						
						var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
                        isRunning = isRunning == "true" ? "Processing" : "";
                        ComSetObjValue(formObj.status, isRunning);
                        sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					}
               	}
				break;
          	case IBCREATE:// Click Expense Apply Button
          		if (sheetObj.id == "sheet1") {
					formObj.f_cmd.value=MULTI;
					
					//2016.10.19 Modify
					//sheetObj.DoSave("VOP_PSO_0010GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
					var SaveStr=ComGetSaveString(new Array(sheetObj)); // array
	                if(SaveStr.length <= 0 ) return;
                    
	                ComOpenWait(true);
	                 
					var sXml=sheetObj.GetSaveData("VOP_PSO_0010GS.do",  SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                    var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
                    var strRunning = isRunning == "true" ? "Processing" : "";
                    ComSetObjValue(formObj.status, strRunning);
                    if(isRunning == "true"){
                        ComShowCodeMessage("PSO01019"); //Accrual Batch Job is Running. Please try Expense Apply when Batch Job is Completed
                        ComOpenWait(false);
                    }else{
                        ComShowMessage(ComGetSelectSingleNode(sXml,"MESSAGE"));

                        ComOpenWait(false);
                        if(checkVvd(document.form)){
                            doActionIBSheet(sheetObj,document.form,IBSEARCH);
                        }
                    }
                    
				}
          		break;
			case COMMAND05:	// Port Code [keyup:5 length]
			    formObj.f_cmd.value=COMMAND05;	//
				var param=FormQueryString(formObj);
				var isPort=ComSearchEtcData(sheetObj, "VOP_PSO_0002GS.do", param, "isPort");
				if(isPort == "O"){
					rVal=formObj.port_cd.value;
					loadTerminal();
					yard_cd.Focus();
				} else if(isPort == "X"){
					formObj.port_cd.value="";
					formObj.port_cd.focus();
				}
				break;
          default: 
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
    /**
	 * Setting data about VVD
	 * 
	 * @param obj
	 * @return
	 */
    function getVslCdData(rtnValue){
    	if(rtnValue != null){
			document.form.vsl_cd.value= rtnValue;
		}
    	return;
    }
    
	function getVvdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
				}
			}
    	}
    }
	/*
	 * for select only 1 chk column of sheet1
	 */            
	function sheet1_OnBeforeCheck(sheetObj, Row, Col){
		var formObj=document.form;
		var prefix="sheet1_";
		sheetObj.ShowDebugMsg(false);
		switch (sheetObj.ColSaveName(Col)) {
			case prefix + "chk" :
				var valChk=sheetObj.GetCellValue(Row, Col);
				arrChk[1]=arrChk[0];	
				arrChk[0]=Row;	
				if(arrChk[1] != 0 && arrChk[0] != arrChk[1]){
					sheetObj.SetCellValue(arrChk[1], Col,0);// previous
				}
				arrChk[2]=valChk == true ? false : true;	// checked
			break;
		}
	}

	function resizeSheet(){
		for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i], 90);
	    }
	}
	
	function portCallBack(rtnVal) {
		if(rtnVal){
			document.form.port_cd.value=rtnVal;
		}
	}
	
	/*
	 * Retrieving Yard
	 */
	function loadTerminal() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		sheetObj.ShowDebugMsg(false);
		yard_cd.RemoveAll();
		formObj.f_cmd.value=SEARCH01;
		var etcData = ComSearchEtcData(sheetObj, "VOP_PSO_0038GS.do", FormQueryString(formObj), "lane");
		var comboItems=etcData.split(ROWMARK);
		addComboItem(yard_cd, comboItems);
	}
	/**
	 * Adding data to combo (Currency, Yard)
	 */	
	function addComboItem(comboObj,comboItems) {
		for (var i=0 ; i < comboItems.length ; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
		}   		
	}    	