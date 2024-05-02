/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CMS_0306.js
*@FileTitle  : Customer 
*@author     : Hipluscard
*@version    : 1.0
*@since      : 2017/06/07
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
		       MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
		       OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    function BCM_CMS_0306() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet; 
		this.obj_keypress_loc       = obj_keypress_loc;
		this.obj_keyup              = obj_keyup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initTab                = initTab;
    	this.tab3_OnChange          = tab3_OnChange;
    }

    /** Common global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	
    var tabObjects = new Array(); 
    var tabCnt = 0 ; 
    var beforetab_trob = 1; 
    
    var x_sheetObject1 = null;
    var x_sheetObject2 = null;
    var x_sheetObject3 = null;
	
	/** Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name */
	function processButtonClick() {
		/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
				//if(window.event.srcElement.style.cursor == "default") return;
			switch (srcName) {
			case "btn_History":
	        	var tblNo = 'MDM_CUST_PERF_GRP';
	        	var custCd = formObj.cust_grp_id.value;
	        	var mstKey = nullToBlank(custCd);
	        	if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Group Customer Code");
					return false;
				}
				comMdmCallPop(tblNo, mstKey);
        		break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObj,SEARCH);
				ComBtnEnable("btn_Save");
				break;
			case "btn_Save":  
			    doActionIBSheet(sheetObjects[0],formObj,MULTI); 
				break;
			case "btn_Close":
				self.close();
				break;
            case "btn_Create":
 				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 				formObj.creflag.value="Y";
 			    formObj.saveflag.value="N";
 				formObj.cust_grp_id.readOnly=true;
 				formObj.cust_grp_id.style.backgroundColor="#bebebe";
 				formObj.cust_cd.style.backgroundColor="#d4f6ff";
				formObj.cust_cd.readOnly=false;
 				ComBtnDisable("btn_Create");
 				ComBtnEnable("btn_Save");
 				ComImageChange("btn_com_ens_041","img/btns_search.gif",false);
 				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 				formObj.creflag.value="N";
 				formObj.saveflag.value="N";
 				formObj.cust_grp_id.style.backgroundColor="#d4f6ff";
				formObj.cust_grp_id.readOnly=false;
				formObj.cust_cd.style.backgroundColor="#d4f6ff";
				formObj.cust_cd.readOnly=false;
 				ComBtnEnable("btn_Create");
 				ComBtnDisable("btn_Save");
 				ComImageChange("btn_com_ens_041","img/btns_search.gif",false);
 				//ComBtnEnable("btn_com_ens_041");
			    break;	
			case "btn_com_ens_041": // Customer code pop-up
				   var param="";
				   if(!form.btn_com_ens_041.disabled)
					   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				   doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
				break;
             case "btn_com_ens_071": // office pop-up
 				var param="";
 	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
 	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
 				break;
 			case "btn_BCM_CMS_0301": //group customer pop-up
				var param="";	
	    		param=param + "cust_grp_id=" + form.cust_grp_id.value;	    		
	    		ComOpenPopup('/hanjin/BCM_CMS_0301.do?' + param, 780, 430, 'setCustGrpId', '1,0,1,1,1,1,1,1', true);				
				break;
             case "t2_btn_t1bAdd":
            	x_sheetObject2.DataInsert(-1);   
				break;
				
             case "t2_btn_t1bDel":
             	var nRow = x_sheetObject2.CheckedRows("del_chk");
 				if (nRow <= 0) {
 					ComShowCodeMessage("SAM00023");
 					return false;
 				} else {
 					if (ComShowConfirm(ComGetMsg("SAM00014"))) { 
 						ComRowHideDelete(x_sheetObject2, "del_chk");
 					} else {
 						return false;
 					}
 				}
             	break;
			} 
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
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
  	  * setting sheet initial values and header
  	  * param : sheetObj, sheetNo
  	  * adding case as numbers of counting sheets
  	  */
	  	
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.creflag.value="N";
	    formObj.saveflag.value="N";
	    initComboSetVal(sheetObjects[0],document.form);
	    
        //---------------
        //tab 초기화 
        for(var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }   

	    x_sheetObject1 = sheetObjects[0];  //customer group main
 	   	x_sheetObject2 = sheetObjects[1];  //Individual Customer
 	   	x_sheetObject3 = sheetObjects[2];  //history
 	   	
 	   ComBtnDisable("btn_Save");
 	   	
 	  if (!(ComIsNull(formObj.cust_grp_id.value))) {
		   doActionIBSheet(sheetObjects[0],formObj,SEARCH);
	   }
 	  
	   if (formObj.proc_tp_cd.value == "Create") {
		   doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			formObj.creflag.value="Y";
		    formObj.saveflag.value="N";
			formObj.cust_grp_id.readOnly=true;
			formObj.cust_grp_id.style.backgroundColor="#bebebe";
			ComBtnDisable("btn_Create");
			ComBtnEnable("btn_Save");
	   }
	   
	   /*formObj.nbs_clss_cd1.Enable=false;
	   formObj.nbs_clss_cd2.Enable=false;
	   formObj.nbs_clss_cd3.Enable=false;
	   formObj.vbs_clss_cd.Enable=false;*/
	   
	   ComSetDisplay("btn_Create1", false);
	   
	   //doActionIBSheet(sheetObjects[0],formObj,SEARCH13);
 	   	
 	   initControl();
	}
	
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObj);
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);
 	    //axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
 	   	//axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	    //axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 	    //axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
        
 	   	//applyShortcut();
    }	
    
	 function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
	    switch(sheetObj.id) {
	        case "sheet1":   //sheet1 init
	            with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
	                
	              //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 15, 100);
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(15, 0, 0, true);
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	    			var HeadTitle1 = " |";
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          40,    daCenter,  false,   "Seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_grp_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ofc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_div_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd1");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd2");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd3");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "vbs_clss_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_grp_id");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "delt_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cd");
					
					//sheetObj.DataInsert();
	            }
	            break;
					
	        case "t2bsheet1_customer":		
				with (sheetObj) {
					// 높이 설정
					style.height = 280;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel.|Primary|Customer Code|Customer Code|Customer name|Location|Srep Code|Office||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag"); 
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,		"del_chk",		    false,		"",	dfNone,		0,		true,		true);					
				
					InitDataProperty(0, cnt++ , dtRadioCheck,	70,		daCenter,	false,		"prmry_chk_flg",    false,      "", dfNone,   	0,      true,      true,1);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,		"cust_cd",      	true,       "", dfEngUpKey,   0,      false,      true,8);
					InitDataProperty(0, cnt++,  dtPopup,        20,   	daCenter,   false,     	"CUSTPop",          false,     	"", dfNone,    	0,      false,       true);
					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		false,		"cust_lgl_eng_nm",  false,      "", dfNone,   0,      false,      false,50);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		"loc_cd",      		false,      "", dfNone,   0,      false,      false,1);
					InitDataProperty(0, cnt++ , dtData,			70,  	daCenter,  	false,		"srep_cd",			false,	    "",	dfNone,	    0,		false,       false, 200);  
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		"ofc_cd",	    	false,		"",	dfEngUpKey,	0,		false,		false, 2);
					
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_cnt_cd",		false,		"",	dfEngUpKey,	0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_seq",			false,		"",	dfNumber,	0,		true,		true, 6);
					
					ShowButtonImage = 2;
					WaitImageVisible = false;   
					
				}
				break;   

	    }
	}
	
	 /**
	  * setDataInsert call .<br>
	  * DELT FLG setting 'N' 
	  * @param sheetObj, sNo
	  */
		function setDataInsert(sheetObj, sNo) {
			var formObj=document.form;
			switch (sNo) {
			case 1:
				var prefix="";
				var nRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(nRow, prefix + "delt_flg",'N');
				break;
			}
			return nRow;
		}
		
		 /**
		 * Receiving Term,Delivery Term 콤보 데이타를 가져온다.
		 **/
		 function initComboSetVal(sheetObj,formObj){
		 	formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("BCM_CMS_0302GS.do", FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], formObj.indiv_corp_div_cd, "cd", "cd_desc");
			if (arrXml.length > 1) 
				ComXml2ComboItem(arrXml[1], formObj.rvis_cntr_cust_tp_cd, "cd", "cd_desc");
			if (arrXml.length > 2) 
				ComXml2ComboItem(arrXml[2], formObj.nbs_clss_cd1, "cd", "cd_desc");
			if (arrXml.length > 3) 
				ComXml2ComboItem(arrXml[3], formObj.nbs_clss_cd2, "cd", "cd_desc");
			if (arrXml.length > 4) 
				ComXml2ComboItem(arrXml[4], formObj.nbs_clss_cd3, "cd", "cd_desc");
			if (arrXml.length > 5) 
				ComXml2ComboItem(arrXml[5], formObj.vbs_clss_cd, "cd", "cd_desc");
			if (arrXml.length > 7) 
				ComXml2ComboItem(arrXml[7], formObj.cust_div_cd, "cd", "cd_desc");
		 }	
		
		 // Sheet관련 프로세스 처리
		 function doActionIBSheet(sheetObj, formObj, sAction) {
		     sheetObj.ShowDebugMsg = false;
		     switch(sAction) {
		
		 		case SEARCH: //retrieve
					if(!validateForm(sheetObj, formObj, sAction)) {
						return false;
					}
					
					ComOpenWait(true);					
					
					formObj.f_cmd.value = SEARCH;
	    		    var sXml = sheetObj.GetSearchXml("BCM_CMS_0306GS.do", FormQueryString(formObj));				
					var arrXml = sXml.split("|$$|"); 
					
					if (arrXml.length > 0) {
						x_sheetObject1.LoadSearchXml(arrXml[0]); 
					}
					
					if (arrXml.length > 1) {
						x_sheetObject2.LoadSearchXml(arrXml[1]); 
					}
					
	    		    if (sheetObj.CellValue(1, "cust_grp_nm") != undefined){
	    		    	formSettingVal(sheetObj,formObj,arrXml[0]);
	    		    	
	    		    } else {
	    		    	ComOpenWait(false);
		        		return;
	    		    }
	    		    
	    		    ComBtnEnable("btn_Save");
	    		    ComImageChange("btn_com_ens_041","img/btns_search_off.gif",true);
	    		    
	    		    if (sheetObj.CellValue(1, "delt_flg") == "Y"){
	    		    	ComBtnDisable("btn_Save");
	    		    } else {
	    		    	ComBtnEnable("btn_Save");
	    		    }
	    		    
	    		    formObj.cust_grp_id.readOnly=true;
	 				formObj.cust_grp_id.style.backgroundColor="#bebebe";
	 				formObj.cust_cd.readOnly=true;
	 				formObj.cust_cd.style.backgroundColor="#bebebe";
	    		    	
	    		    ComOpenWait(false);
		    		break;		
		    		
				case MULTI:        //저장
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}

					var confMsg;
					var saveMsg;
					
					if (formObj.ibflag.value=="I"){
						formObj.cust_grp_id.value = "G-"+ formObj.cust_cd.value;
					}
						confMsg=ComGetMsg('CCD00023', 'save');
						saveMsg=ComGetMsg("COM130102", "Data");
						setSave(confMsg,saveMsg);
					//}
	 		 		break;		
	 		 		
				case IBCLEAR:      //Initialization
					formObj.reset();
					
					formObj.cust_grp_id.value="";

					formObj.ibflag.value="I";
					sheetObjects[1].RemoveAll();

					ComSetObjValue(formObj.nbs_clss_cd1,"");
			    	ComSetObjValue(formObj.nbs_clss_cd2,"");
			    	ComSetObjValue(formObj.nbs_clss_cd3,"");
			    	ComSetObjValue(formObj.vbs_clss_cd,"");
			    	
			    	break;	 		

				case SEARCH04:      //Office Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH04;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "REP. Office");
				        	formObj.ofc_cd.value="";
				        }
						ComOpenWait(false);
					}
				break;
				
				case SEARCH09:      //Customer Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH09;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        var srepcd=ComGetEtcData(sXml, "srepcd");
				        var grpidchk=ComGetEtcData(sXml, "grpidchk");
				        var grpprmrychk=ComGetEtcData(sXml, "grpprmrychk");
				        if(result=="" ){
				        	ComShowCodeMessage("COM130402", "Customer Code");
				        	formObj.cust_cnt_cd.value="";
				        	formObj.cust_seq.value="";
				        	formObj.cust_cd.value="";
				        	formObj.srep_cd.value="";
				        } else if (grpidchk != "" && formObj.creflag.value == "Y") { //Group customer code 생성시 중복 체크
				        	ComShowCodeMessage("SAM00025", grpidchk);
				        	formObj.cust_cnt_cd.value="";
				        	formObj.cust_seq.value="";
				        	formObj.cust_cd.value="";
				        	formObj.srep_cd.value="";
				        	formObj.cust_cd.focus();
				        } else if (grpprmrychk != ""  && formObj.creflag.value == "Y") { //Group customer code 의 PRIMARY Customer code check
				        	ComShowCodeMessage("SAM00026", grpprmrychk, formObj.cust_cd.value);
				        	formObj.cust_cnt_cd.value="";
				        	formObj.cust_seq.value="";
				        	formObj.cust_cd.value="";
				        	formObj.srep_cd.value="";
				        	formObj.cust_cd.focus();
				        } else {
					        formObj.srep_cd.value=srepcd;
				        }
						ComOpenWait(false);
					}
				break;
				
				case SEARCH10:      //Sales Rep Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH10;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Sales Rep Code");
				        	formObj.srep_cd.value="";
			//	        	document.form.srep_cd.focus();
				        }
						ComOpenWait(false);
					}
				break;
				
		    	case SEARCH11:      //Group Customer Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH11;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Group Customer Code");
				        	formObj.cust_grp_id.value="";
			//	        	document.form.cust_grp_id.focus();
				        }
						ComOpenWait(false);
					}
					break;
					
		    	case SEARCH13:      //User MDM Auth check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH13;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0309GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result=="N"){
				        	ComSetDisplay("btn_Save1", false);
				        	ComSetDisplay("bth_cust_row_add", false);
				        	ComSetDisplay("bth_cust_row_del", false);
				        	document.all.item("user_mdm_auth").style.display = "block";
				        	document.all.item("user_mdm_auth").innerText = "You have no authority to update MDM. Request MDM role in advance.";
				        }
						ComOpenWait(false);
					}
					break;
				
		     }
		 }

	/**
	 * Checkbox in the pop-up when you pass a value to parent window. <br>
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} value sheetObj input value
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		var rArray=null;
		rArray=chkGetLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		ComClosePopup(); 
	}
	//===================================================================================
	//UI Object Event Handler
	// ===================================================================================
	function setCallBack0B1(aryPopupData) {
		var form=document.form;
		form.loc_cd.value=aryPopupData[0][3];
	} 
	function setCallBack0B2(aryPopupData) {
		var form=document.form;
		form.cust_seq.value=aryPopupData[0][3].substring(2,8);
		form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
		form.cust_cd.value=aryPopupData[0][3];
		if (form.ibflag.value=="N") {
			form.ibflag.value="U";
		}
	}
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		form.ofc_cd.value=aryPopupData[0][3];
		if (form.ibflag.value=="N") {
			form.ibflag.value="U";
		}
	}
	function setCallBack0B4(aryPopupData) {
		var form=document.form;
		form.vndr_seq.value=aryPopupData[0][2];
	}
	function setCallBack0B5(aryPopupData) {
		var form=document.form;
		form.cust_cnt_cd.value=aryPopupData[0][3];
	}
	function setCallBack0B6(aryPopupData) {
		var form=document.form;
		form.capi_curr_cd.value=aryPopupData[0][2];
	}
	
	function setCallBack0B8(aryPopupData) {
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "cust_cd") = aryPopupData[0][3];
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "cust_lgl_eng_nm") = aryPopupData[0][4];
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "loc_cd") = aryPopupData[0][9];
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "ofc_cd") = aryPopupData[0][5];
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "srep_cd") = aryPopupData[0][14];
	}
	
   function setCustGrpId(aryPopupData){
	   var form=document.form;
	   form.cust_grp_id.value=aryPopupData[0][2];
	   doActionIBSheet(sheetObjects[0], form, SEARCH);
   }
   
	// Firm/Private 변경시
	function nbs_clss_cd1_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
 			formObj.ibflag.value					="U";
 		}
	}
	// Firm/Private 변경시
	function nbs_clss_cd2_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
 			formObj.ibflag.value					="U";
 		}
	}
	// Firm/Private 변경시
	function nbs_clss_cd3_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
 			formObj.ibflag.value					="U";
 		}
	}
	// Firm/Private 변경시
	function vbs_clss_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(formObj.ibflag.value == 'N' ){
 			formObj.ibflag.value					="U";
 		}
	}

	 /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
	    	case SEARCH:
	    		if( ComIsNull(formObj.cust_grp_id) ){
	    			ComShowCodeMessage("CCD00001", "Group Customer Code");
	    			document.form.cust_grp_id.focus();
	    			return false;
	    		}
	    		break;
	    	case SEARCH08:
	    		if(formObj.loc_cd.value == "" || formObj.loc_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Location Code");
//	    			document.form.loc_cd.focus();
	    			return false;
	    		}
	    		break;
	    	case MULTI:
	    		if(formObj.cust_cd.value == "" || formObj.cust_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Customer Code");
//	    			document.form.cust_cd.focus();
	    			return false;
	    		}
	    		if(ComTrim(formObj.cust_grp_nm.value) == "" || formObj.cust_grp_nm.value == null){
	    			ComShowCodeMessage("CCD00001", "Group Cust Name");
	    			document.form.cust_grp_nm.focus();
	    			return false;
	    		}
	    		
	    		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
	    		if(formObj.ofc_cd.value == "" || formObj.ofc_cd.value == null){
	    			//ComShowCodeMessage("CCD00001", "REP. Office");
	    			document.form.ofc_cd.focus();
	    			return false;
	    		}
	    		
	    		var chg_flag = "N";
	    		//CUSTOMER MANDATORY CHECK
	    		for (var i=1; i<=x_sheetObject2.RowCount; i++) {
	    			if (x_sheetObject2.CellValue(i, "cust_cd") == ""){
	    				ComShowCodeMessage("SAM00009", "Individual Customer code");
	    				x_sheetObject2.SelectCell(i, "cust_cd");
	    				return false;
	    			}
	    			if (x_sheetObject2.CellValue(i, "ibflag") == "I" || x_sheetObject2.CellValue(i, "ibflag") == "U"){
	    				var chg_flag = "Y";
	    			}
	    		}
	    		
	    		if (formObj.ibflag.value == "N" && chg_flag == "N"){
	    			ComShowCodeMessage("SAM00006")
	    			return false;
	    		}
	    		break;
	    	}
	    	return true;
		}
	   /**
        * When Save, Call Function 
       */
	    function setSave(confMsg, saveMsg) {
			var formObj   = document.form;
			var sheetObj  = sheetObjects[0];

			if (!confirm(confMsg)) {
				formObj.saveflag.value="N";
			    return false;
			}
			
			if (formObj.delt_flg.checked) {
				formObj.delt_flg.value = "Y";
			} else {
				formObj.delt_flg.value = "N";
			}

			formObj.f_cmd.value=MULTI;
			
      	    var sParam = FormQueryString(formObj);
      	    var sParam1 = ComSetPrifix(x_sheetObject2.GetSaveString(), "t2bsheet2_");
      	    sParam += "&" + sParam1; 
      	    
			ComOpenWait(true); //대기이미지 표시

			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0306GS.do", sParam);
			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
			ComOpenWait(false); //대기이미지 숨김

			if(sav == "S"  ){
 				ComShowCodeMessage("COM130102", "Data");
 				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
 			}else{
 				ComShowCodeMessage("COM130103", "Data");
 			}
	   }
		 /**
	     * Call Back Function  
	     */
	   function getBCM_CMS_0306_saveflag(saveFlag) {
			var formObj   = document.form;
 		    var confMsg;
			var saveMsg;
			formObj.saveflag.value=saveFlag;
			confMsg=ComGetMsg("CCD00030");
			saveMsg=ComGetMsg("CCD00031");
			setSave(confMsg, saveMsg );
			//ComShowCodeMessage("CCD00031", "Data");
	   }
	
	
		function obj_focus() {
	      	if(event.srcElement.options){
//	      		event.srcElement.focus();
	      	}else{
	      		event.srcElement.select();
	      	}
	      }
		
		function form_onChange(evt,el) {
		  	var formObj = document.form;
		  	var xml = "";
		  	var srcName;
		  	var srcValue;
			var srcObj;
		  	if (el) {
		  		srcObj = el;
		  		srcName = el.getAttribute("name");
		  		srcValue = el.getAttribute("value");
		  		
		  	} else {
		  		srcObj = window.event.srcElement;
		  		srcName = srcObj.getAttribute("name");
		  		srcValue = srcObj.getAttribute("value");
		  		if(srcName != "cust_grp_id" && formObj.ibflag.value != 'I'){
		  			formObj.ibflag.value					="U";
		  		}
		  	}
		  	switch(srcName) {
			  	case "cust_cd":
			  		if(formObj.cust_cd.value.length>0){	   
			  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
			  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
	               		if(formObj.cust_seq.value.match(/[^0-9]{1}/)){
	               			  ComShowCodeMessage("CCD00039", "Customer Code");
	               			  formObj.cust_cd.value='';
	               			  return false;
	               		}  
	               		var custlpad="";
	               		if (formObj.cust_seq.value.length <6 ){
	               			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
	               				 custlpad=custlpad+"0" ;
	               			}
	               			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
	               		}
	               		doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
			  		}
              		break;
		  		case "ofc_cd":
            		if(formObj.ofc_cd.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
            			if(formObj.ofc_cd.value.length==0){
            					document.form.ofc_cd.focus();
	            			}else{
	            				document.form.srep_cd.focus();
	            			}
            		}
            		break;
            	
            	case "srep_cd":
            		if(formObj.srep_cd.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
            			if(formObj.srep_cd.value.length==0){
	            				document.form.srep_cd.focus();
	            			}else{
	            				document.form.indiv_corp_div_cd.focus();
	            			}
            		}
            		break;
	            case "cust_grp_id":
            		if(formObj.cust_grp_id.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH11);
            			if(formObj.cust_grp_id.value.length==0){
        					document.form.cust_grp_id.focus();
            			}else{
            				//document.form.mlt_trd_acct_flg.focus();
            				doActionIBSheet(sheetObjects[0], formObj, SEARCH);
            			}
            		}
            		break;
            	
	            case "delt_flg":
	            	if (formObj.delt_flg.checked) {
	    				formObj.delt_flg.value = "Y";
	    			} else {
	    				formObj.delt_flg.value = "N";
	    			}
	            	break;
		  	}
		}
		
	    function formSettingVal(sheetObj,formObj,sXml){
	    	formObj.cust_grp_nm.value 			= sheetObj.CellValue(1, "cust_grp_nm");
	    	formObj.ofc_cd.value 				= sheetObj.CellValue(1, "ofc_cd");
	    	formObj.srep_cd.value 				= sheetObj.CellValue(1, "srep_cd");
	    	formObj.cust_cd.value 				= sheetObj.CellValue(1, "cust_cd");
	    	
	    	formObj.cust_cnt_cd.value			= sheetObj.CellValue(1, "cust_cnt_cd");
	    	formObj.cust_seq.value 				= sheetObj.CellValue(1, "cust_seq");
	    	
	    	ComSetObjValue(formObj.nbs_clss_cd1,sheetObj.CellValue(1, "nbs_clss_cd1"));
	    	ComSetObjValue(formObj.nbs_clss_cd2,sheetObj.CellValue(1, "nbs_clss_cd2"));
	    	ComSetObjValue(formObj.nbs_clss_cd3,sheetObj.CellValue(1, "nbs_clss_cd3"));
	    	ComSetObjValue(formObj.vbs_clss_cd,sheetObj.CellValue(1, "vbs_clss_cd"));
	    	
	    	if (sheetObj.CellValue(1, "delt_flg") == "Y") {
				formObj.delt_flg.checked = true;
			} else {
				formObj.delt_flg.checked = false;
			}
	    	
	    	formObj.ibflag.value				="N";
	    	
		 }	    
	    
		/**
		 * Tab 기본 설정
		 * 탭의 항목을 설정한다.
		 */
		function initTab(tabObj, tabNo) {
		     switch(tabNo) {
		         case 1:
		            with (tabObj) {
		                var cnt  = 0 ;
		                InsertTab( cnt++ , "Individual Customer" , -1 );
		                BaseColor = "243,242,248"; 
		            }
		         break;
		     }
		} 	  
		
		// 업무 자바스크립트 OnKeyPress 이벤트 처리
		function obj_keypress_loc() {
			var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			switch(event.srcElement.dataformat){
		       case "float":
		           //숫자+"."입력하기
		           ComKeyOnlyNumber(event.srcElement, ".");
		           break;
		       case "eng":
		           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		           ComKeyOnlyAlphabet();
		           break;
		       case "engdn":
		           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		           ComKeyOnlyAlphabet('lower');
		           break;
		       case "engup":
		           //영문 대문자만 입력하기
		           ComKeyOnlyAlphabet('upper');
		           break;
		       case "int":
		           //숫자만입력하기(정수,날짜,시간)
		           ComKeyOnlyNumber(event.srcElement);
		           break;
		       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
		       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
		     			event.keyCode = keyValue + 65 - 97;
		     		}
		           break;
		       case "tel":
			        // 숫자+"-"입력하기
			        ComKeyOnlyNumber(event.srcElement, "-"); 
			        break;
	           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
		   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
		    	   break;
		    }
		}
		
	    function setTabObject(tab_obj){
	        tabObjects[tabCnt++] = tab_obj;
	    }    
	    
		//IB sheet의 값이 변경될경우.
		function t2bsheet1_customer_OnChange(sheetObj,row,col,value){
			var formObj = document.form;
			var val_type = "";
			var val_value = "";
			
			/* ColSaveName */
			var col_save_name = sheetObj.ColSaveName(col);
			var data_type = sheetObj.ReadDataProperty(row, col, 0);
			if (col_save_name == "prmry_chk_flg" ) {
	        	if(sheetObj.CellValue(row,col_save_name)=="1" ){
	        		formObj.cust_cd.value = sheetObj.CellValue(row,"cust_cd")
	        		formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
		  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
		  			formObj.srep_cd.value = sheetObj.CellValue(row,"srep_cd")
		  			formObj.ibflag.value="U";
	        	}
	        }

			if (col_save_name == "cust_cd") {
	        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        		val_type = "Customer Code";
	        		val_value = sheetObj.CellValue(row,col_save_name);
	        		if(val_value.substr(2,6).match(/[^0-9]{1}/)){
	         			ComShowCodeMessage("CCD00039", "Customer Code");
	         			sheetObj.SelectCell(row, col);
	         			sheetObj.CellValue2(row,col_save_name) = "";
	         			return false;
	         		} 
	        		
	        		var custlpad="";
               		if (val_value.substr(2,6).length <6 ){
               			for(i=1; i <= 6- val_value.substr(2,6).length; i++){
               				 custlpad=custlpad+"0" ;
               			}
               			val_value=val_value.substr(0,2)+custlpad+val_value.substr(2,6);
               		}
               		
               		sheetObj.CellValue2(row,col_save_name) = val_value;
	        		
	        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
	        			sheetObj.CellValue2(row,"cust_lgl_eng_nm") = "";
			        	sheetObj.CellValue2(row,"loc_cd") = "";
			        	sheetObj.CellValue2(row,"srep_cd") = "";
			        	sheetObj.CellValue2(row,"ofc_cd") = "";	
	        			sheetObj.CellValue2(row,col_save_name) = "";
	        			sheetObj.SelectCell(row, col);
	        		}
	        	}
	        }
			
			if (col_save_name == "del_chk" && value == "1" && sheetObj.CellValue(row,"prmry_chk_flg") == "1") {
				ComShowCodeMessage("CCD00008");
				sheetObj.CellValue2(row,col_save_name) = "0";
			}
		}
		
		function t2bsheet1_customer_OnPopupClick(sheetObj, row, col){
	        var col_name = sheetObj.ColSaveName(col);
			switch(col_name) {
				
				case "CUSTPop":
					var param="";
	    		   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B8', '1,0,1,1,1,1,1,1', true);
				break;
				
			}		
		}
		
		/**
		 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
		 */
		function searchValidationData(sheetObj, val_type, val_value, row) {
			var formObj = document.form;
			var sParam  = "";
			var result  = "";
			var sXml    = "";
			var grpprmrychk = ""

	    	ComOpenWait(true);
	    	if (val_type == "Customer Code") {
		    	sParam = "f_cmd=109&" + "&cust_cd="+val_value + "&cust_cnt_cd="+val_value.substr(0,2) + "&cust_seq="+val_value.substr(2,6);
		    	sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        result=ComGetEtcData(sXml, "result");
		        grpprmrychk=ComGetEtcData(sXml, "grpprmrychk");
		        
		        if (grpprmrychk != "") {
		        	ComOpenWait(false);
		        	ComShowCodeMessage("SAM00026", grpprmrychk, val_value);
		        	return false;
		        }
		        
		        if (sheetObj.id == "t2bsheet1_customer" && result!=""){
		        	sheetObj.CellValue2(row,"cust_lgl_eng_nm") = ComGetEtcData(sXml, "custnm");
		        	sheetObj.CellValue2(row,"loc_cd") = ComGetEtcData(sXml, "loccd");
		        	sheetObj.CellValue2(row,"srep_cd") = ComGetEtcData(sXml, "srepcd");
		        	sheetObj.CellValue2(row,"ofc_cd") = ComGetEtcData(sXml, "ofccd");		        	
		        }
	    	}

		    ComOpenWait(false);
	        
	        if(result==""){
	        	ComShowCodeMessage("COM130402", val_type);
	        	return false;
	        }
			 
			return true;
		}
		
	    //######################[1. Event]############################################################
	    /**
	     * Tab 클릭시 이벤트 관련
	     * 선택한 탭의 요소가 활성화 된다.
	     */
	    function tab3_OnChange(tabObj , nItem)
	    {
	        //var objs = document.all.item("tabLayer_moreinfo");
	        var formObj = document.form;
	        tabLayer_customer.style.display = "Inline";
	        
	        /*switch(nItem) {
	         	case 0:
		        	 tabLayer_customer.style.display = "Inline";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 1:
	         		tabLayer_customer.style.display = "none";
	         		tabLayer_history.style.display = "Inline";
				     break;
	        }*/

	    	objs[beforetab_trob].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	beforetab_trob = nItem;
	    }
	    
		
		function obj_keyup() {
			var formObj = document.form;
			with (formObj) {
				//textarea : enter 제외
				if (event.srcElement.type == "textarea") {
					return;
				}			
				if ( window.event.keyCode == 13 ) {
					formObj.curr_rtn_tro_flg.value = "";  //default tab clear
					formObj.curr_tro_seq.value     = "";  //default 순번 clear
			
			    }
			}
		}  	    
	    
       function ComImageChange(name, imagePath, disabled) {
	   		var img = eval('document.form.' + name);
	   		img.src = imagePath;
	   		img.disabled = disabled;
   		}
