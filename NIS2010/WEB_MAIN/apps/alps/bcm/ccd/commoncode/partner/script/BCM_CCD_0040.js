/*
=========================================================
*Copyright(c) 2018 SM Lines. All Rights Reserved.
*@FileName   : BCM_CCD_0040.js
*@FileTitle  : Vendor 
*@author     : CLT
*@version    : 1.0
*@since      : 2018/03/01 
========================================================= 
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    		   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     		   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class BCM_CCD_0040 : BCM_CCD_0040 on the screen for creating the script defines the task using.
 */

/** Common global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var create_vndr_seq='';
    var prefix1_1="sheet1_1_";
    var prefix1_2="sheet1_2_";
    var prefix2="sheet2_";
    /** Event handler processing by button click event */
    var init_delt_flg = "N";
	document.onclick=processButtonClick;  
	
	/** Event handler processing by button name */
	function processButtonClick(){
		/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
        var sheetObject1=sheetObjects[0];   
        var sheetObject2=sheetObjects[1]
        var sheetObject3=sheetObjects[2];   
        /*******************************************************/
        var formObject=document.form;

		try {
			var srcName=ComGetEvent("name");						

			switch (srcName) {		
		        case "btn_History":
		        	var tblNo = 'MDM_VENDOR';
		        	var vndrCd = formObject.vndr_seq.value;
		        	var mstKey = nullToBlank(Number(vndrCd));
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Vendor Code");
						return false;
					}
		        	comMdmCallPop(tblNo, mstKey);
	        		break;			
				case "btn_Retrieve": //retrieve
					if (formObject.isRequest.value == "Y"){
						formObject.vndr_seq.value="";
						doActionIBSheet(sheetObject1, formObject, SEARCH08);
					} else if (formObject.isRequest.value == "N"){
						doActionIBSheet(sheetObject1, formObject, SEARCH01);
					}
					break;
				case "btn_New": 	//New
					doActionIBSheet(sheetObject1,	formObject,	IBCLEAR);
					formObject.rqst_no.value="";
					formObject.saveflag.value="N";
					break;	
				case "btn_Save": //save
					doActionIBSheet(sheetObject1,	formObject,	IBSAVE);
					break;
				case "btn_Create": //Sequence generation
					doActionIBSheet(sheetObject1,	formObject,	IBCREATE);
					break;
				case "btn_Close":
					self.close(); 
					break;
				case "btn_CheckDup":
					var param="rqst_no=" + ComGetObjValue(formObject.rqst_no);
					param=param + "&" + "name=" + formObject.vndr_lgl_eng_nm.value;
		         	var sUrl="BCM_CCD_1040.do?" + param;
		         	sUrl=sUrl+ "&vndrCntCd=" + formObject.loc_cd.value.substring(0, 2);
		         	var rVal=ComOpenPopup(sUrl, 770, 460, "", "0,0", true);
					break;
				case "btn_Request":
					doActionIBSheet(sheetObject1, formObject, MULTI03); 
					break;
				case "btn_rowadd_sheet1_1": //add row 
	                doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
//				case "btn_rowdelete_sheet1_1": //delete row
//					doActionIBSheet(sheetObject1, formObject, IBDELETE);					
//					break;		
				case "btn_rowadd_sheet1_2": //add row 
	                doActionIBSheet(sheetObject2, formObject, MODIFY01);
					break;
//				case "btn_rowdelete_sheet1_2": //delete row
//					doActionIBSheet(sheetObject2, formObject, MODIFY02);					
//					break;
				case "btn_rowadd_sheet2": //add row 
	                doActionIBSheet(sheetObject3, formObject, MODIFY03);
					break;
//				case "btn_rowdelete_sheet2": //delete row
//					doActionIBSheet(sheetObject3, formObject, MODIFY04);					
//					break;		
				case "btn_com_ens_0m1_vndr_cnt_cd":
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_0M1.do?cnt_cd=" + formObj.vndr_cnt_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 450, "getCOM_ENS_0M1_vndr_cnt_cd", "0,0", true);
					break;	
				case "btn_com_ens_051_loc_cd":
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_051.do?loc_cd=" + formObj.loc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 410, "getCOM_ENS_051_loc_cd", "0,0", true);
					break;	
				case "btn_com_ens_071_ofc_cd": 		  			
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 430, "getCOM_ENS_071_ofc_cd", "0,0", true);
					break;	
				case "btn_com_ens_n13_inv_curr_cd": 
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_N13.do?curr_cd=" + formObj.inv_curr_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 700, 400, "getCOM_ENS_N13_inv_curr_cd", "0,0", true);
					break;		
				case "btn_com_ens_071_vndr_ofc_cd":
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.vndr_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 420, "getCOM_ENS_071_vndr_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_0c1_prnt_vndr_cd": 
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		  			var sUrl="COM_ENS_0C1.do?mdm_yn=" + formObj.mdm_yn.value;
		         	var rVal=ComOpenPopup(sUrl, 770, 410, "getCOM_ENS_0C1_prnt_vndr_cd", "0,0", true);
					break;
				case "btn_vndr_cd_pop":
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_0C1.do?mdm_yn=" + formObj.mdm_yn.value;
		         	var rVal=ComOpenPopup(sUrl, 770, 410, "getBtn_vndr_cd_pop", "0,0", true);
		        	if (formObj.vndr_seq.value !="" ){
		         	    doActionIBSheet(sheetObject1, formObj, SEARCH01);
		        	}
					break;	
				case "btn_chk_de_ste_cd" :
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		  			var sUrl="COM_ENS_0X1.do?cnt_cd=" + formObj.chk_de_cnt_cd.value;
		         	var rVal=ComOpenPopup(sUrl, 300, 350, "getCOM_ENS_0X1_chk_de_ste_cd", "1,0,1,1,1,1,1,1", true);
		         	//ComOpenPopup('/hanjin/COM_ENS_0X1.do?' + param, 780, 470, 'getCOM_ENS_0X1', '1,0,1,1,1,1,1,1', true, Col,Row);
					break;
		        case "btn_chk_de_cnt_cd":
		        	if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_0M1.do?cnt_cd=" + formObj.chk_de_cnt_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 430, "getCOM_ENS_0M1_chk_de_cnt_cd", "0,0", true);
		            //ComOpenPopup('/hanjin/COM_ENS_0M1.do', 770, 520, 'getCnt_cd', "1,0,1,1,1,1,1", true);
		            break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
  	/**
 	  * initializing sheet
 	  * implementing onLoad event handler in body tag
 	  * adding first-served functions after loading screen.
 	  */
	function loadPage() {
        var formObj=document.form;
		var rqstNo=formObj.rqst_no.value;
        for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);	
		}
		for (var k=0; k<comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
		doActionIBCombo(sheetObjects[0], formObj, SEARCH);
		initControl();
		formObj.saveflag.value="N";
		formObj.edi_if_flg.value="N";
		ComSetDisplay('btn_rowdelete_set1_1', false);
		ComSetDisplay('btn_rowdelete_set1_2', false);
		ComSetDisplay('btn_rowdelete_set2', false);
		vndrTpEnable("all", false);		
		if(formObj.isRequest.value == "Y") {
			formObj.vndr_seq.readOnly = true;
			formObj.vndr_seq.style.backgroundColor="#E8E7EC";
			formObj.vndr_cnt_cd.readOnly = true;
			formObj.vndr_cnt_cd.style.backgroundColor="#E8E7EC";
			formObj.rqst_no.style.backgroundColor="CCFFFD";
			ComEnableObject(formObj.btn_vndr_cd_pop, false);
			requestFromEnable(true);
			ComSetFocus(document.form.rqst_no);
		} else if(formObj.isRequest.value == "N") {
			formObj.rqst_no.readOnly = true;
			formObj.rqst_no.style.backgroundColor="#E8E7EC";
			ComSetFocus(document.form.vndr_seq);
		}
		
		if(formObj.vndr_seq.value.length > 0) {
			doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
			if(formObj.isApprove.value == 'Y') {
				popupViewEnable(false);
			}
		} else if (formObj.rqst_no.value.length > 0) {
			doActionIBSheet(sheetObjects[0], formObj, SEARCH08);
			if(formObj.mst_rqst_sts_cd.value != 'Saved' || formObj.isApprove.value == 'Y') {
				popupViewEnable(false);
				ComBtnDisable('btn_Retrieve');
				ComBtnDisable('btn_Save');
				ComBtnDisable('btn_Request');
			}
			ComBtnDisable('btn_Create');
			ComBtnDisable('btn_New');
		} else {
			ComSetDisplay('btn_Retrieve', true); 
			ComBtnDisable('btn_Request');
			ComBtnDisable('btn_Save');
			ComBtnDisable('btn_rowadd_sheet1_1');
			ComBtnDisable('btn_rowdelete_sheet1_1');
			ComBtnDisable('btn_rowadd_sheet1_2');
			ComBtnDisable('btn_rowdelete_sheet1_2');
			ComBtnDisable('btn_rowadd_sheet2');
			ComBtnDisable('btn_rowdelete_sheet2');
		}

		if(formObj.isCheck.value == 'Y') {
			chkDeEnable(true);
		} else {
			chkDeEnable(false);
		}

		formObj.subs_co_cd.Code = "00";
	}		
	
    /**
     * The default setting Combo
     * If the number of combo a combo by adding the number of case sheets to initialize the module configuration. 
     */ 
    function initCombo(comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
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
     	case "sheet1_1":
     	    with(sheetObj){
     			// 높이설정
     			style.height = 130;
     			// 전체 너비 설정
     			SheetWidth = mainTable.clientWidth;
     			
        		// 전체 Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
    			
    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;
    			
        		// 행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
        		initRowInfo(1, 1, 2, 100);
        		
        		// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
        		InitColumnInfo(17, 0, 0, false);
        		
        		// 헤더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, true, true, false, false);     			

		        var HeadTitle="ibflag|Del|Primary Flag|Seq|Phone/Fax|International\nNo|No|Delete Flag|Create User|Create Date/Time|Update User|Update Date/Time|VNDR Seq|Intl Phn No|Phn No|Intl Fax No|Fax No";

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true)

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT,
                // EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
                // FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus ,  30, daCenter, false, prefix1_1 + "ibflag");
                InitDataProperty(0, cnt++, dtDelCheck,  40, daCenter, false, prefix1_1 + "del");
                InitDataProperty(0, cnt++, dtCombo   , 100, daCenter, false, prefix1_1 + "prmry_chk_flg"      , false, "", dfNone, 0, true ,  true , 1  );
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, false, prefix1_1 + "vndr_cntc_pnt_seq"  , false, "", dfNone, 0, false,  false, 12 );
                InitDataProperty(0, cnt++, dtCombo   ,  80, daCenter, false, prefix1_1 + "cntc_div_cd"        , false, "", dfNone, 0, true ,  true , 12 );
                InitDataProperty(0, cnt++, dtData    , 110, daCenter, false, prefix1_1 + "intl_no"            , false, "", dfNone, 0, true ,  true , 4  );
                InitDataProperty(0, cnt++, dtData    , 160, daCenter, false, prefix1_1 + "no"                 , false, "", dfNone, 0, true ,  true , 20 );
                InitDataProperty(0, cnt++, dtCombo   ,  70, daCenter, false, prefix1_1 + "delt_flg"           , false, "", dfNone, 0, true ,  true , 1  );
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, true , prefix1_1 + "cre_usr_id"         , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    , 110, daLeft  , true , prefix1_1 + "cre_dt"             , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, true , prefix1_1 + "upd_usr_id"         , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    , 110, daLeft  , true , prefix1_1 + "upd_dt"             , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_1 + "vndr_seq"           , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_1 + "intl_phn_no"        , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_1 + "phn_no"             , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_1 + "intl_fax_no"        , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_1 + "fax_no"             , false, "", dfNone, 0, false,  false);
                
                InitDataCombo(0, prefix1_1+ "prmry_chk_flg", "N|Y", "N|Y");
                InitDataCombo(0, prefix1_1+ "delt_flg", "N|Y", "N|Y");
                InitDataCombo(0, prefix1_1+ "cntc_div_cd", "Phone|Fax", "PHN|FAX");
               
                WaitImageVisible = false;
                
                if(document.form.isApprove.value == 'Y') {
                	Editable = false;
                }
     		}
          	break;
          	
     	case "sheet1_2":
     	    with(sheetObj){
     			// 높이설정
     			style.height = 130;
     			// 전체 너비 설정
     			SheetWidth = mainTable.clinetWidth;
     			
        		// 전체 Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
    			
    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;
    			
        		// 행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
        		initRowInfo(1, 1, 2, 100);
        		
        		// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
        		InitColumnInfo(12, 0, 0, false);
        		
        		// 헤더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, true, true, false, false);     			

		        var HeadTitle="ibflag|Del|Primary Flag|Seq|Email/Web|Address|Delete Flag|Create User|Create Date/Time|Update User|Update Date/Time|VNDR Seq";

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true)

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT,
                // EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
                // FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus ,  30, daCenter, false, prefix1_2 + "ibflag");
                InitDataProperty(0, cnt++, dtDelCheck,  40, daCenter, false, prefix1_2 + "del"); 
                InitDataProperty(0, cnt++, dtCombo   , 100, daCenter, false, prefix1_2 + "prmry_chk_flg"      , false, "", dfNone, 0, true ,  true , 1  );
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, false, prefix1_2 + "vndr_cntc_pnt_seq"  , false, "", dfNone, 0, false,  false, 12 );
                InitDataProperty(0, cnt++, dtCombo   ,  80, daCenter, false, prefix1_2 + "cntc_div_cd"        , false, "", dfNone, 0, true ,  true , 12 );
                InitDataProperty(0, cnt++, dtData    , 270, daCenter, false, prefix1_2 + "vndr_eml"           , false, "", dfNone, 0, true ,  true , 200);
                InitDataProperty(0, cnt++, dtCombo   ,  70, daCenter, false, prefix1_2 + "delt_flg"           , false, "", dfNone, 0, true ,  true , 1  );
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, true , prefix1_2 + "cre_usr_id"         , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    , 110, daCenter, true , prefix1_2 + "cre_dt"             , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    ,  80, daCenter, true , prefix1_2 + "upd_usr_id"         , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtData    , 110, daCenter, true , prefix1_2 + "upd_dt"             , false, "", dfNone, 0, false,  false);
                InitDataProperty(0, cnt++, dtHidden  ,   5, daLeft  , false, prefix1_2 + "vndr_seq"           , false, "", dfNone, 0, false,  false);
                
                InitDataCombo(0, prefix1_2+ "prmry_chk_flg", "N|Y", "N|Y");
                InitDataCombo(0, prefix1_2+ "delt_flg", "N|Y", "N|Y");
                InitDataCombo(0, prefix1_2+ "cntc_div_cd", "Email|Web", "EMAIL|WEB");
                
                WaitImageVisible = false;
                if(document.form.isApprove.value == 'Y') {
                	Editable = false;
                }
     		}
          	break;
          	
     	case "sheet2":
     	    with(sheetObj) {
     			// 높이 설정
     			style.height = 200;
     			
        		// 전체 너비 설정
        		SheetWidth = mainTable.clientWidth
        		
        		// 전체 Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
        		
    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;
    			
        		// 행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
        		initRowInfo(1, 1, 2, 100);
        		
        		// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
        		InitColumnInfo(12, 0, 0, false);
        		
        		// 헤더에서 처리할 수 있는 각종 기능을 설정한다
        		InitHeadMode(true, true, true, true, false, false);

			    var HeadTitle="ibflag|Del|Subject|Kind of Service|Delete Flag|Create User|Create Date/Time|Last Update User|Last Update Date/Time|||";

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT,
                // EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
                // FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus  , 30 , daCenter, false, prefix2 + "ibflag");
                InitDataProperty(0, cnt++, dtDelCheck, 40 , daCenter, false, prefix2 + "del");
                InitDataProperty(0, cnt++, dtCombo   , 210, daLeft  , false, prefix2 + "vndr_cost_cd"    	 , true , "", dfNone, 0, true , true );
                InitDataProperty(0, cnt++, dtCombo   , 210, daLeft  , false, prefix2 + "cntr_vndr_svc_cd"	 , true , "", dfNone, 0, true , true );
                InitDataProperty(0, cnt++, dtCombo   , 70 , daCenter, false, prefix2 + "delt_flg"       	 , false, "", dfNone, 0, true , true );
                InitDataProperty(0, cnt++, dtData    , 80 , daCenter, true , prefix2 + "cre_usr_id"      	 , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData    , 150, daCenter, true , prefix2 + "cre_dt"          	 , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData    , 110, daCenter, true , prefix2 + "upd_usr_id"      	 , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData    , 150, daCenter, true , prefix2 + "upd_dt"          	 , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden  , 50 , daCenter, false, prefix2 + "vndr_seq"        	 , false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden  , 210, daLeft  , false, prefix2 + "pre_vndr_cost_cd"    , true , "", dfNone, 0, true , true );
                InitDataProperty(0, cnt++, dtHidden  , 210, daLeft  , false, prefix2 + "pre_cntr_vndr_svc_cd", true , "", dfNone, 0, true , true );
                
                InitDataCombo(0, prefix2+ "delt_flg", "N|Y", "N|Y");
                
                WaitImageVisible = false;
                
                if(document.form.isApprove.value == 'Y') {
                	Editable = false;
                }
     		}
          	break;
     	}
	}
	
	function getCOM_ENS_0X1_chk_de_ste_cd(rowArray, Row, Col) {
	   	var formObj=document.form;
		var colArray=rowArray[0];
//		formObj.chk_de_cnt_cd.value=colArray[5];
		formObj.chk_de_ste_cd.value=colArray[3];
		formObj_OnChange();
	}
	
  /**
   * Sheet processing-related processes <br>
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
 			var ins_vndr_seq=""
 				if(document.form.vndr_seq.value == "") {
 					ins_vndr_seq="1";
 				}else{
 					ins_vndr_seq=document.form.vndr_seq.value;
 				}
	 		switch (sAction) {					
	 		
	 			case IBCREATE: // New retrieve
	 				doActionIBSheet(sheetObj, formObj, IBCLEAR);
	 				formObj.new_vndr_seq.value="1";
					ComEnableObject(formObj.vndr_seq, false);
					formObj.vndr_seq.style.backgroundColor="#E8E7EC";
					ComEnableObject(formObj.vndr_cnt_cd, false);
					formObj.vndr_cnt_cd.style.backgroundColor="#E8E7EC";
					ComEnableObject(formObj.btn_vndr_cd_pop, false);
					ComEnableObject(formObj.rqst_no, false);
					formObj.rqst_no.style.backgroundColor="#E8E7EC";
					formObj.modi_vndr_cd.readOnly = true;
					formObj.modi_vndr_cd.style.backgroundColor="#E8E7EC";
					requestFromEnable(false);
					formObj.ibflag.value="I";
 		 			formObj.delt_flg.value = "N";
 		 			ComBtnDisable("btn_Create");
					ComBtnDisable("btn_Retrieve");
					ComBtnDisable("btn_Request");
					ComBtnEnable("btn_Save");
					formObj.pay_mzd_cd.Code = 'X';
					formObj.pay_mzd_cd.Enable = true;
					ComSetFocus(formObj.vndr_lgl_eng_nm);
					ComSetDisplay('mainTable2', false);
					ComSetDisplay('mainTable3', false);
					ComSetDisplay('mainTable4', false);
		 			break;

	 			case SEARCH01:  	
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}	
		 			formObj.f_cmd.value=SEARCH01;			 			
		 			create_vndr_seq=formObj.vndr_seq.value;
		        	sheetObjects[0].RemoveAll();
		        	sheetObjects[0].RemoveEtcData();
		        	sheetObjects[1].RemoveAll();
		        	sheetObjects[1].RemoveEtcData();
		        	sheetObjects[2].RemoveAll();
		        	sheetObjects[2].RemoveEtcData();
		        	var prefixArr=new Array("", prefix1_1, prefix1_2, prefix2);
		        	var sXml=sheetObj.GetSearchXml("BCM_CCD_0040GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixArr));
		        	var rtnValue=sXml.split("|$$|");
		    		var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
		    		if(sav != "S" ){
		        		ComOpenWait(false);
		        		return;
		    		}
		    		formObj.vndr_cnt_cd.style.backgroundColor="#E8E7EC";
 		 			formObj.vndr_seq.readOnly=true;
 		 			formObj.vndr_seq.style.backgroundColor="#E8E7EC";
 		 			formObj.rqst_no.readOnly=true;
 		 			formObj.rqst_no.style.backgroundColor="#E8E7EC";
 		 			ComEnableObject(formObj.btn_vndr_cd_pop, false);
 		 			if (ComGetEtcData(rtnValue[0],"input_flg") == 'N') { 
	 		 			formObj.vndr_cnt_cd.value=ComXmlString(rtnValue[0], "vndr_cnt_cd");
	 		 			formObj.mst_rqst_sts_cd.value=ComXmlString(rtnValue[0], "mst_rqst_sts_cd");
	 		 			formObj.vndr_lgl_eng_nm.value=ComXmlString(rtnValue[0], "vndr_lgl_eng_nm");
	 		 			formObj.vndr_locl_lang_nm.value=ComXmlString(rtnValue[0], "vndr_locl_lang_nm");
	 		 			formObj.vndr_abbr_nm.value=ComXmlString(rtnValue[0], "vndr_abbr_nm");	 			
	 		 			if(ComXmlString(rtnValue[0], "lgs_flg") =="Y"){
	 		 				formObj.lgs_flg.checked=true;
	 	 					vndrTpEnable("lgs", true);
	 		 			}	 		 	
	 		 			if(ComXmlString(rtnValue[0], "blk_flg") =="Y"){
	 		 				formObj.blk_flg.checked=true;
	 		 				vndrTpEnable("blk", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "procu_flg") =="Y"){
	 		 				formObj.procu_flg.checked=true;
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "finc_flg") =="Y"){
	 		 				formObj.finc_flg.checked=true;
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "team_flg") =="Y"){
	 		 				formObj.team_flg.checked=true;
	 		 				vndrTpEnable("team", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "inter_co_flg") =="Y"){
	 		 				formObj.inter_co_flg.checked=true;
	 		 				vndrTpEnable("inter_co", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "otr_flg") =="Y"){
	 		 				formObj.otr_flg.checked=true;
	 		 			}
	 		 			formObj.loc_cd.value=ComXmlString(rtnValue[0], "loc_cd");
	 		 			formObj.ofc_cd.value=ComXmlString(rtnValue[0], "ofc_cd");
	 		 			formObj.rgst_no.value=ComXmlString(rtnValue[0], "rgst_no");
	 		 			formObj.tax_id.value=ComXmlString(rtnValue[0], "tax_id");
	 		 			formObj.prnt_vndr_seq.value=ComXmlString(rtnValue[0], "prnt_vndr_seq");
	 		 			formObj.inv_curr_cd.value=ComXmlString(rtnValue[0], "inv_curr_cd");
	 		 			formObj.cntc_pson_nm.value=ComXmlString(rtnValue[0], "cntc_pson_nm");
	 		 			formObj.ceo_nm.value=ComXmlString(rtnValue[0], "ceo_nm");
	 		 			formObj.bzct_nm.value=ComXmlString(rtnValue[0], "bzct_nm");
	 		 			formObj.bztp_nm.value=ComXmlString(rtnValue[0], "bztp_nm");
	 		 			formObj.usa_edi_cd.value=ComXmlString(rtnValue[0], "usa_edi_cd");
	 		 			formObj.svc_scp_cd_nm.value=ComXmlString(rtnValue[0], "svc_scp_cd_nm");
	 		 			formObj.svc_prd_tp_nm.value=ComXmlString(rtnValue[0], "svc_prd_tp_nm");
	 		 			formObj.svc_prd_rmk.value=ComXmlString(rtnValue[0], "svc_prd_rmk");
	 		 			formObj.dcgo_hndl_flg.value = ComXmlString(rtnValue[0], "dcgo_hndl_flg");
	 		 			formObj.mty_rro_edi_use_flg.value = ComXmlString(rtnValue[0], "mty_rro_edi_use_flg");
	 		 			formObj.wo_atch_file_flg.value = ComXmlString(rtnValue[0], "wo_atch_file_flg");
	 		 			formObj.wo_edi_use_flg.value = ComXmlString(rtnValue[0], "wo_edi_use_flg");
	 		 			formObj.inv_edi_use_flg.value = ComXmlString(rtnValue[0], "inv_edi_use_flg");
	 		 			formObj.rfnd_psdo_cust_cd.value=ComXmlString(rtnValue[0], "rfnd_psdo_cust_cd");
	 		 			formObj.vndr_ofc_cd.value=ComXmlString(rtnValue[0], "vndr_ofc_cd");
	 		 			formObj.eng_addr.value=ComXmlString(rtnValue[0], "eng_addr");
	 		 			formObj.zip_cd.value=ComXmlString(rtnValue[0], "zip_cd");
	 		 			formObj.locl_lang_addr.value=ComXmlString(rtnValue[0], "locl_lang_addr");
	 		 			formObj.chk_de_addr1.value=ComXmlString(rtnValue[0], "chk_de_addr1");
	 		 			formObj.chk_de_addr2.value=ComXmlString(rtnValue[0], "chk_de_addr2");
	 		 			formObj.chk_de_addr3.value=ComXmlString(rtnValue[0], "chk_de_addr3");
	 		 			formObj.chk_de_cty_nm.value=ComXmlString(rtnValue[0], "chk_de_cty_nm");
	 		 			formObj.chk_de_ste_cd.value=ComXmlString(rtnValue[0], "chk_de_ste_cd");
	 		 			formObj.chk_de_zip_cd.value=ComXmlString(rtnValue[0], "chk_de_zip_cd");
	 		 			formObj.chk_de_cnt_cd.value=ComXmlString(rtnValue[0], "chk_de_cnt_cd");
	 		 			formObj.lu_delt_flg.value = ComXmlString(rtnValue[0], "lu_delt_flg");
	 		 			formObj.delt_flg.value = ComXmlString(rtnValue[0], "delt_flg");
	 		 			formObj.modi_vndr_cd.value=ComXmlString(rtnValue[0], "modi_vndr_cd");
	 		 			formObj.old_modi_vndr_cd.value=ComXmlString(rtnValue[0], "modi_vndr_cd");
	 		 			formObj.cre_usr_id.value=ComXmlString(rtnValue[0], "cre_usr_id");
	 		 			formObj.cre_dt.value=ComXmlString(rtnValue[0], "cre_dt");
	 		 			formObj.upd_usr_id.value=ComXmlString(rtnValue[0], "upd_usr_id");
	 		 			formObj.upd_dt.value=ComXmlString(rtnValue[0], "upd_dt");
	 		 			formObj.bank_acct_flg.value=ComXmlString(rtnValue[0], "bank_acct_flg");
	 		 			formObj.subs_co_cd.Code = ComXmlString(rtnValue[0], "subs_co_cd");
	 		 			formObj.gen_pay_term_cd.Code = ComXmlString(rtnValue[0], "gen_pay_term_cd");
	 		 			formObj.pay_term_tp_cd.Code = ComXmlString(rtnValue[0], "pay_term_tp_cd");
	 		 			formObj.pay_mzd_cd.Code = ComXmlString(rtnValue[0], "pay_mzd_cd");
	 		 			formObj.blk_vndr_svc_cd.Code = ComXmlString(rtnValue[0], "blk_vndr_svc_cd");
	 		 			
	 		 			init_delt_flg = ComXmlString(rtnValue[0], "delt_flg");
	 		 			sheetObjects[0].LoadSearchXml(rtnValue[1]);
	 		 			
	 		 			for(i=1; i <= sheetObjects[0].LastRow; i++) {
	 		 				if(sheetObjects[0].CellValue(i, prefix1_1 + "cntc_div_cd") == "PHN") {
	 		 					sheetObjects[0].CellValue2(i, prefix1_1 + "no") = sheetObjects[0].CellValue(i, prefix1_1 + "phn_no");
	 		 					sheetObjects[0].CellValue2(i, prefix1_1 + "intl_no") = sheetObjects[0].CellValue(i, prefix1_1 + "intl_phn_no");
	 		 				} else if(sheetObjects[0].CellValue(i, prefix1_1 + "cntc_div_cd") == "FAX") {
	 		 					sheetObjects[0].CellValue2(i, prefix1_1 + "no") = sheetObjects[0].CellValue(i, prefix1_1 + "fax_no");	
	 		 					sheetObjects[0].CellValue2(i, prefix1_1 + "intl_no") = sheetObjects[0].CellValue(i, prefix1_1 + "intl_fax_no");
	 		 				}
	 		 			}
	 		 			sheetObjects[1].LoadSearchXml(rtnValue[2]);
	 		 			sheetObjects[2].LoadSearchXml(rtnValue[3]);
	 		 			for(var i=1; i<=sheetObjects[2].LastRow; i++) {
	 		 				var tmpCntrVndrSvcCd = sheetObjects[2].CellValue(i, prefix2 + "cntr_vndr_svc_cd");
	 		 				sheetObjects[2].CellValue(i, prefix2 + "pre_vndr_cost_cd") = sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd");
	 		 				sheetObjects[2].CellValue(i, prefix2 + "pre_cntr_vndr_svc_cd") = sheetObjects[2].CellValue(i, prefix2 + "cntr_vndr_svc_cd");

	 		 				if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "SV") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", svName, svValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "TM") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", tmName, tmValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "SR") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", srName, srValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "TR") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", trName, trValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "CG") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", cgName, cgValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "CT") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", ctName, ctValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "EQ") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", eqName, eqValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "MR") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", mrName, mrValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "CM") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", cmName, cmValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "PT") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", ptName, ptValue);
	 		 				} else if (sheetObjects[2].CellValue(i, prefix2 + "vndr_cost_cd") == "CA") {
	 		 					sheetObjects[2].CellComboItem(i, prefix2+"cntr_vndr_svc_cd", caName, caValue);
	 		 				}
	 		 				sheetObjects[2].CellValue(i, prefix2 + "cntr_vndr_svc_cd") = tmpCntrVndrSvcCd;
	 		 				sheetObjects[2].CellValue(i, prefix2 + "ibflag") = "R";
	 		 			}
	 		    		formObj.ibflag.value="U";
	 		    		if(formObj.rfnd_psdo_cust_cd.value != '') {
	 		    			formObj.tpb_flg.checked=true;
	 		    		} else {
	 		    			formObj.tpb_flg.checked=false;
	 		    		}
//	 		    		formObj.pay_mzd_cd.Enable = false;
	 		    		if(formObj.isApprove.value == 'Y') {
		 		    		ComBtnDisable('btn_Save');
		 		    		ComBtnDisable('btn_rowadd_sheet1_1');
		 		    		ComBtnDisable('btn_rowdelete_sheet1_1');
		 		    		ComBtnDisable('btn_rowadd_sheet1_2');
		 		    		ComBtnDisable('btn_rowdelete_sheet1_2');
		 		    		ComBtnDisable('btn_rowadd_sheet2');
		 		    		ComBtnDisable('btn_rowdelete_sheet2');	 		    		
	 		    		} else {
		 		    		ComBtnEnable('btn_Save');
		 		    		ComBtnEnable('btn_rowadd_sheet1_1');
		 		    		ComBtnEnable('btn_rowdelete_sheet1_1');
		 		    		ComBtnEnable('btn_rowadd_sheet1_2');
		 		    		ComBtnEnable('btn_rowdelete_sheet1_2');
		 		    		ComBtnEnable('btn_rowadd_sheet2');
		 		    		ComBtnEnable('btn_rowdelete_sheet2');
	 		    		}
	 		    		formObj.onchange_flag.value = "N";
	 		    		formObj.rqst_no.value = "";
	 		 		}else { 
	 		 			formObj.input_flg.value="Y";
	 		 			formObj.delt_flg.value = "N";
	 		 			formObj.ibflag.value="I";
	 		 			formObj.vndr_seq.value=create_vndr_seq;
	 	    	    	ComShowCodeMessage("CCD00033", "Vendor Code");
	 	    	    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
	 		 		}
	 		 		break;	 				 		
		 		case IBCLEAR:      // initializing
		 			ComResetAll();
 		   			for(var i=0; i<formObj.elements.length; i++) {
 						if (formObj.elements[i].type == "text" || formObj.elements[i].type == "select-one"
 							|| formObj.elements[i].type == "checkbox") {
 							ComEnableObject(formObj.elements[i], true);
 						}
 					}

 		   			if(formObj.isRequest.value == "Y") {
 		   				formObj.vndr_cnt_cd.readOnly = true;
 		   				formObj.vndr_seq.readOnly = true;
 		   				formObj.rqst_no.style.backgroundColor = "#CCFFFD";
 		   				ComSetFocus(formObj.rqst_no);
 		   				requestFromEnable(true);
		 			} else if(formObj.isRequest.value == "N") {
		 				formObj.vndr_cnt_cd.readOnly = true;
		 				formObj.rqst_no.readOnly = true;
 		   				formObj.vndr_cnt_cd.style.backgroundColor = "#CCFFFD";
 		   				formObj.vndr_seq.style.backgroundColor = "#CCFFFD";
 		   				ComEnableObject(formObj.btn_vndr_cd_pop, true);
 		   				ComSetFocus(formObj.vndr_seq);
 	 					formObj.gen_pay_term_cd.Enable  = true;
 	 					formObj.pay_term_tp_cd.Enable  = true;
 			 			formObj.pay_mzd_cd.Enable = true;
 	 					ComEnableObject(formObj.btn_com_ens_051_loc_cd, true);
 	 					ComEnableObject(formObj.btn_com_ens_071_ofc_cd, true);
 	 					ComEnableObject(formObj.btn_com_ens_0c1_prnt_vndr_cd, true);
 	 					ComEnableObject(formObj.btn_com_ens_n13_inv_curr_cd, true);
 		   			}
 		   			
 		   			formObj.vndr_lgl_eng_nm.className = "input1";
	 		   		formObj.loc_cd.className = "input1";
		 		   	formObj.ofc_cd.className = "input1";
		 		   	formObj.inv_curr_cd.className = "input1";
		 		   	formObj.eng_addr.className = "input1";
		 		  	formObj.input_flg.className = "input1";
		 		  	formObj.vndr_seq.className = "input1";
 		   			formObj.mst_rqst_sts_cd.readOnly = true;
 		   			formObj.modi_vndr_cd.readOnly = true;
 		   			formObj.modi_vndr_cd.style.backgroundColor="#E8E7EC";
	 		   		formObj.rfnd_psdo_cust_cd.readOnly = true;
	 				formObj.rfnd_psdo_cust_cd.style.backgroundColor="#E8E7EC";
 		   			formObj.mst_rqst_sts_cd.className = "input2";
 					ComEnableObject(formObj.btn_chk_de_cnt_cd, true);
 					ComEnableObject(formObj.btn_chk_de_ste_cd, true);
 					formObj.old_modi_vndr_cd.value = "";
		    		formObj.edi_if_flg.value = "N";
		    		init_delt_flg = "N";
 					vndrTpEnable("all", false);
		 			ComBtnEnable("btn_Create");
		 			ComBtnEnable("btn_Retrieve");
		 			ComBtnDisable("btn_Save"); 
		 			ComBtnDisable("btn_Request"); 
		 			formObj.pay_mzd_cd.Code = 'X';
		 			formObj.subs_co_cd.Code = "00";
		 			
		 			if(formObj.isCheck.value == 'Y') {
		 				chkDeEnable(true);
		 			} else {
		 				chkDeEnable(false);
		 			}
	 		 		break;	
		 		case IBINSERT: 	
		 			with (sheetObjects[0]) {
		 				sheetObj.DataInsert(-1);
		                sheetObj.CellValue(sheetObj.RowCount, prefix1_1+"vndr_seq") = ins_vndr_seq;
		                sheetObj.CellValue(sheetObj.RowCount, prefix1_1+"delt_flg") = "N";
		 			}
		 			break;	
//		 		case IBDELETE:      		
// 	        	   for(var i=1; i<sheetObjects[0].RowCount + 1 ;i++){
// 	        		   if(sheetObjects[0].RowStatus(i) =="D"){
// 	        			  sheetObjects[0].RowHidden(i) = true;
// 	        		   }
// 	        	   }
//			 	   break;  
		 		case MODIFY01: 	
		 			with (sheetObjects[1]) {
		 				sheetObj.DataInsert(-1);
		                sheetObj.CellValue(sheetObj.RowCount, prefix1_2+"vndr_seq") = ins_vndr_seq;
		                sheetObj.CellValue(sheetObj.RowCount, prefix1_2+"delt_flg") = "N";
		 			}
		 			break;		
//		 		case MODIFY02:      		
// 	        	   for(var i=1; i<sheetObjects[1].RowCount + 1 ;i++){
// 	        		   if(sheetObjects[1].RowStatus(i) =="D"){
// 	        			  sheetObjects[1].RowHidden(i) = true;
// 	        		   }
// 	        	   }
//			 	   break; 
		 		case MODIFY03: 
		 			with (sheetObjects[2]) {
		 				sheetObj.DataInsert(-1);
		 				sheetObj.CellValue(sheetObj.RowCount, prefix2+"vndr_seq") = ins_vndr_seq;
		 				sheetObj.CellComboItem(sheetObj.RowCount, prefix2+"cntr_vndr_svc_cd", svName, svValue);
		 				sheetObj.CellValue(sheetObj.RowCount, prefix2+"delt_flg") = "N";
		 			}
	 		 		break;	
//		 		case MODIFY04: 
// 	        	   for(var i=1; i<sheetObjects[2].RowCount + 1 ;i++){
// 	        		   if(sheetObjects[2].RowStatus(i) =="D"){
// 	        			  sheetObjects[2].RowHidden(i) = true;
// 	        		   }
// 	        	   }
//			 	   break; 
		 		case IBSAVE: 
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	                if(formObj.onchange_flag.value != "Y" && !sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
	                	ComShowCodeMessage("COM130503");
	                	return;
	                }
		 			if (!ComShowCodeConfirm("COM130101", "Data")) {
		 				return false;
		 			}
		 			var sParamSheet2=sheetObjects[2].GetSaveString(true);
					if (sheetObjects[2].IsDataModified && sParamSheet2 == "") {
					    return;
					}	
		 			if(formObj.vndr_seq.value == "" && formObj.saveflag.value == "Y"){ 
		 				formObj.vndr_seq.value="1";
		 			}
	         		var locCd=formObj.loc_cd.value;
	         		var vndrCntCd=locCd.substring(0, 2);
	         		ComSetObjValue(formObj.vndr_cnt_cd, vndrCntCd);
	         		if(formObj.vndr_seq.value.length > 0){
	         			formObj.f_cmd.value=MULTI;
	         		} else {
	         			formObj.f_cmd.value=MULTI01;
	         		}
		 			if(formObj.lgs_flg.checked){
		 				formObj.lgs_flg.value="Y";
              		}
             		if(formObj.procu_flg.checked){
             			formObj.procu_flg.value="Y";
              		}
             		if(formObj.finc_flg.checked){
             			formObj.finc_flg.value="Y";
              		}
             		if(formObj.team_flg.checked){
             			formObj.team_flg.value="Y";
              		}
             		if(formObj.inter_co_flg.checked){
             			formObj.inter_co_flg.value="Y";
             		}
             		if(formObj.otr_flg.checked){
             			formObj.otr_flg.value="Y";
              		}
		 			var sParam=FormQueryString(formObj);
		    		sParam += "&" + sheetObjects[0].GetSaveString(false, true, prefix1_1+"ibflag");
		    		sParam += "&" + sheetObjects[1].GetSaveString(false, true, prefix1_2+"ibflag");
		    		sParam += "&" + sheetObjects[2].GetSaveString(false, true, prefix2+"ibflag");
		    		
		    		var sXml=sheetObj.GetSaveXml("BCM_CCD_0040GS.do", sParam);
	    			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			     	if(sav == "S"  ){
			     		if( formObj.vndr_seq.value != ''){
			     			ComShowCodeMessage("COM130102", "Data");
			     			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			     		} else {
							ComShowCodeMessage("CCD00058");
				     		var rqstNo=ComGetEtcData(sXml, "RQST_NO");
			    			ComSetObjValue(formObj.rqst_no, rqstNo);
			     			doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
			     		}
				     	ComBtnEnable("btn_Retrieve");
			     	}else{
			     		ComShowCodeMessage("COM130103", "Data");
			       	}
	 		 		break;
		 		case SEARCH08:  	

		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			formObj.f_cmd.value=SEARCH08;			 			
		 			create_vndr_seq=formObj.vndr_seq.value;
		        	sheetObjects[0].RemoveAll();
		        	sheetObjects[0].RemoveEtcData();
		        	sheetObjects[1].RemoveAll();
		        	sheetObjects[1].RemoveEtcData();
		        	sheetObjects[2].RemoveAll();
		        	sheetObjects[2].RemoveEtcData();
		        	var prefixArr=new Array("", prefix1_1,  prefix1_2, prefix2);
		        	var sXml=sheetObj.GetSearchXml("BCM_CCD_0040GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixArr));
		 			var rtnValue=sXml.split("|$$|");
		    		var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
		    		if(sav != "S" ){
		        		ComOpenWait(false);
		        		return;
		    		}
		    		formObj.vndr_cnt_cd.readOnly=true;
		    		formObj.vndr_cnt_cd.style.backgroundColor="#E8E7EC";
 		 			formObj.vndr_seq.readOnly=true;
 		 			formObj.vndr_seq.style.backgroundColor="#E8E7EC";
 		 			formObj.rqst_no.readOnly=true;
 		 			formObj.rqst_no.style.backgroundColor="#E8E7EC";
	 		 		if (ComGetEtcData(rtnValue[0],"input_flg") == 'N'){ 
	 		 			formObj.vndr_cnt_cd.value=ComXmlString(rtnValue[0], "vndr_cnt_cd");
	 		 			formObj.vndr_lgl_eng_nm.value=ComXmlString(rtnValue[0], "vndr_lgl_eng_nm");
	 		 			formObj.vndr_locl_lang_nm.value=ComXmlString(rtnValue[0], "vndr_locl_lang_nm");
	 		 			formObj.vndr_abbr_nm.value=ComXmlString(rtnValue[0], "vndr_abbr_nm");	 			
	 		 			if(ComXmlString(rtnValue[0], "lgs_flg") =="Y"){
	 		 				formObj.lgs_flg.checked=true;
	 		 				vndrTpEnable("lgs", true);
	 		 			}	 		 		
	 		 			if(ComXmlString(rtnValue[0], "blk_flg") =="Y"){
	 		 				formObj.blk_flg.checked=true;
	 		 				vndrTpEnable("blk", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "procu_flg") =="Y"){
	 		 				formObj.procu_flg.checked=true;
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "finc_flg") =="Y"){
	 		 				formObj.finc_flg.checked=true;
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "team_flg") =="Y"){
	 		 				formObj.team_flg.checked=true;
	 		 				vndrTpEnable("team", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "inter_co_flg") =="Y"){
	 		 				formObj.inter_co_flg.checked=true;
	 		 				vndrTpEnable("inter_co", true);
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "otr_flg") =="Y"){
	 		 				formObj.otr_flg.checked=true;
	 		 			}
	 		 			if(ComXmlString(rtnValue[0], "vndr_seq")!='1'){
	 		 				formObj.vndr_seq.value=ComXmlString(rtnValue[0], "vndr_seq");
	 		 			}
	 		 			formObj.rqst_no.value=ComXmlString(rtnValue[0], "rqst_no");
	 		 			formObj.loc_cd.value=ComXmlString(rtnValue[0], "loc_cd");
	 		 			formObj.ofc_cd.value=ComXmlString(rtnValue[0], "ofc_cd");
	 		 			formObj.tax_id.value=ComXmlString(rtnValue[0], "tax_id");
	 		 			formObj.rgst_no.value=ComXmlString(rtnValue[0], "rgst_no");
	 		 			formObj.prnt_vndr_seq.value=ComXmlString(rtnValue[0], "prnt_vndr_seq");
	 		 			formObj.inv_curr_cd.value=ComXmlString(rtnValue[0], "inv_curr_cd");
	 		 			formObj.cntc_pson_nm.value=ComXmlString(rtnValue[0], "cntc_pson_nm");
	 		 			formObj.ceo_nm.value=ComXmlString(rtnValue[0], "ceo_nm");
	 		 			formObj.bzct_nm.value=ComXmlString(rtnValue[0], "bzct_nm");
	 		 			formObj.bztp_nm.value=ComXmlString(rtnValue[0], "bztp_nm");
	 		 			formObj.usa_edi_cd.value=ComXmlString(rtnValue[0], "usa_edi_cd");
	 		 			formObj.svc_scp_cd_nm.value=ComXmlString(rtnValue[0], "svc_scp_cd_nm");
	 		 			formObj.svc_prd_tp_nm.value=ComXmlString(rtnValue[0], "svc_prd_tp_nm");
	 		 			formObj.svc_prd_rmk.value=ComXmlString(rtnValue[0], "svc_prd_rmk");
	 		 			formObj.dcgo_hndl_flg.value = ComXmlString(rtnValue[0], "dcgo_hndl_flg");
	 		 			formObj.mty_rro_edi_use_flg.value = ComXmlString(rtnValue[0], "mty_rro_edi_use_flg");
	 		 			formObj.wo_atch_file_flg.value = ComXmlString(rtnValue[0], "wo_atch_file_flg");
	 		 			formObj.wo_edi_use_flg.value = ComXmlString(rtnValue[0], "wo_edi_use_flg");
	 		 			formObj.inv_edi_use_flg.value = ComXmlString(rtnValue[0], "inv_edi_use_flg");
	 		 			formObj.rfnd_psdo_cust_cd.value=ComXmlString(rtnValue[0], "rfnd_psdo_cust_cd");
	 		 			formObj.vndr_ofc_cd.value=ComXmlString(rtnValue[0], "vndr_ofc_cd");
	 		 			formObj.eng_addr.value=ComXmlString(rtnValue[0], "eng_addr");
	 		 			formObj.zip_cd.value=ComXmlString(rtnValue[0], "zip_cd");
	 		 			formObj.locl_lang_addr.value=ComXmlString(rtnValue[0], "locl_lang_addr");
	 		 			formObj.chk_de_addr1.value=ComXmlString(rtnValue[0], "chk_de_addr1");
	 		 			formObj.chk_de_addr2.value=ComXmlString(rtnValue[0], "chk_de_addr2");
	 		 			formObj.chk_de_addr3.value=ComXmlString(rtnValue[0], "chk_de_addr3");
	 		 			formObj.chk_de_cty_nm.value=ComXmlString(rtnValue[0], "chk_de_cty_nm");
	 		 			formObj.chk_de_ste_cd.value=ComXmlString(rtnValue[0], "chk_de_ste_cd");
	 		 			formObj.chk_de_zip_cd.value=ComXmlString(rtnValue[0], "chk_de_zip_cd");
	 		 			formObj.chk_de_cnt_cd.value=ComXmlString(rtnValue[0], "chk_de_cnt_cd");
	 		 			formObj.lu_delt_flg.value = ComXmlString(rtnValue[0], "lu_delt_flg");
	 		 			formObj.modi_vndr_cd.value=ComXmlString(rtnValue[0], "modi_vndr_cd");
	 		 			formObj.bank_acct_flg.value=ComXmlString(rtnValue[0], "bank_acct_flg");
	 		 			formObj.mst_rqst_sts_cd.value = ComXmlString(rtnValue[0], "mst_rqst_sts_cd");
	 		 			formObj.cre_usr_id.value=ComXmlString(rtnValue[0], "cre_usr_id");
	 		 			formObj.cre_dt.value=ComXmlString(rtnValue[0], "cre_dt");
	 		 			formObj.upd_usr_id.value=ComXmlString(rtnValue[0], "upd_usr_id");
	 		 			formObj.upd_dt.value=ComXmlString(rtnValue[0], "upd_dt");
	 		 			formObj.gen_pay_term_cd.Code = ComXmlString(rtnValue[0], "gen_pay_term_cd");
	 		 			formObj.pay_term_tp_cd.Code = ComXmlString(rtnValue[0], "pay_term_tp_cd");
	 		 			formObj.pay_mzd_cd.Code = ComXmlString(rtnValue[0], "pay_mzd_cd");
	 		 			formObj.blk_vndr_svc_cd.Code = ComXmlString(rtnValue[0], "blk_vndr_svc_cd");
	 		 			formObj.subs_co_cd.Code=ComXmlString(rtnValue[0], "subs_co_cd");

	 		 			if(formObj.mst_rqst_sts_cd.value == "Approved" && formObj.vndr_seq.value != '') {
	 						ComSetDisplay('mainTable2', true);
	 						ComSetDisplay('mainTable3', true);
	 						 				
	 		 			} else {
	 						ComSetDisplay('mainTable2', false);
	 						ComSetDisplay('mainTable3', false);
	 		 			}
	 		 			
	 		    		formObj.ibflag.value="U";
	 		    		if(formObj.rfnd_psdo_cust_cd.value != '') {
	 		    			formObj.tpb_flg.checked=true;
	 		    		} else {
	 		    			formObj.tpb_flg.checked=false;
	 		    		}
	 		    		ComBtnEnable('btn_Save');
	 		    		ComBtnEnable('btn_Create');
 		    			ComEnableObject(formObj.btn_vndr_cd_pop, false);
	 		    		if(formObj.mst_rqst_sts_cd.value == 'Saved') {
		 		    		requestFromEnable(false);
		 		    		ComBtnEnable('btn_Request');
	 		    		} else {
		 		   			for(var i=0; i<form.elements.length; i++) {
		 						if (form.elements[i].type == "text" || form.elements[i].type == "select-one"
		 							|| form.elements[i].type == "checkbox") {
		 							ComEnableObject(form.elements[i], false);
		 							form.elements[i].className = "input2";
		 						}
		 					}
		 					formObj.gen_pay_term_cd.Enable  = false;
		 					formObj.pay_term_tp_cd.Enable  = false;
		 					formObj.pay_mzd_cd.Enable = false;
		 					ComEnableObject(formObj.btn_com_ens_051_loc_cd, false);
		 					ComEnableObject(formObj.btn_com_ens_071_ofc_cd, false);
		 					ComEnableObject(formObj.btn_com_ens_0c1_prnt_vndr_cd, false);
		 					ComEnableObject(formObj.btn_com_ens_n13_inv_curr_cd, false);
		 					ComEnableObject(formObj.btn_chk_de_cnt_cd, false);
		 					ComEnableObject(formObj.btn_chk_de_ste_cd, false);
		 					ComBtnDisable('btn_Retrieve');
		 					ComBtnDisable('btn_Save');
		 					ComBtnDisable('btn_Request');
		 					ComBtnDisable('btn_rowadd_sheet1_1');
		 					ComBtnDisable('btn_rowadd_sheet1_2');
		 					ComBtnDisable('btn_rowdelete_sheet1_1');
		 					ComBtnDisable('btn_rowdelete_sheet1_2');
		 					ComBtnDisable('btn_rowadd_sheet2');
		 					ComBtnDisable('btn_rowdelete_sheet2');
		 					if(formObj.mst_rqst_sts_cd.value == 'Rejected') {
		 						formObj.mst_rqst_sts_cd.style.color = "#ff0000";
		 					}
	 		    		}
	 		 		} else { 
	 	    	    	ComShowCodeMessage("CCD00033", "Request No");
	 	    	    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
	 		 			//new vndr_cd.
	 		 			formObj.input_flg.value="Y";
	 		 			formObj.delt_flg.value = "N";
	 		 			formObj.ibflag.value="I";
						ComSetFocus(formObj.rqst_no);
	 		 		}
	 		 		break;
			 	
		 		case MULTI03:	// Request
					if (!ComShowCodeConfirm('CCD00023', 'request')) {
					    return;
					}
					var sParam='f_cmd=' + MULTI03 + '&rqst_no=' + ComGetObjValue(formObj.rqst_no) + '&proc_tp_cd=O';
					var sXml=sheetObj.GetSaveXml("BCM_CCD_0040GS.do", sParam);
						var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
						if(sav == "S"  ){
							ComShowCodeMessage("CCD00031");
	 		    			ComBtnDisable('btn_Request');
			     			doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
						} else {
							ComShowCodeMessage("COM130103", "Data");
						}
				break;
					
		 		case SEARCH10:
          			formObj.f_cmd.value=SEARCH10;
		 			var sParam="f_cmd="       + formObj.f_cmd.value + "&check_cd=" + formObj.rgst_no.value + "&vndr_seq=" + formObj.vndr_seq.value;
		 			var sXml=sheetObj.GetSearchXml("BCM_CCD_0040GS.do", sParam);
		 			var check_cd=ComGetEtcData(sXml, "result");
    		        return check_cd;
		 		break;
	 		}
		} catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally {
			 ComOpenWait(false);
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
  	 * registering IBCombo Object as list
  	 * adding process for list in case of needing batch processing with other items 
  	 * defining list on the top of source
  	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}		

	/**
     * handling process for input validation <br>
     */
     function validateForm(sheetObj, formObj, sAction) {
        var sheetObject1=sheetObjects[0];   
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
    	 switch (sAction) {
	    	 case SEARCH01: 
	    		// Vendor Seq is null
		    	 if(formObj.vndr_seq.value == "") {
	    		 	ComShowCodeMessage('CCD00001',"Vendor Code"); 
					ComSetFocus(document.form.vndr_seq);					
					return false;
		    	 }
	    	 	 break;
	    	 
	    	 case SEARCH08:
	    		if(formObj.rqst_no.value == "") {
	    		 	ComShowCodeMessage('CCD00001',"Request No"); 
					ComSetFocus(document.form.rqst_no);					
					return false;
	    		}
	    		break;
	    	 	
	    	 case IBSAVE: // save
		    	 // Vendor Seq is null , ComIsEmpty()
	    	 	if(formObj.delt_flg.value !="Y" || init_delt_flg != "Y"){
	    	 		if( formObj.rqst_no.value == ''){
				    	if(formObj.vndr_seq.value == "" && formObj.ibflag.value != "I") {
				    		ComShowCodeMessage('CCD00001',"Vendor"); 
							ComSetFocus(document.form.vndr_seq);					
							return false;
				    	}
		    	 	}
			    	 if(formObj.vndr_lgl_eng_nm.value == "") {
							ComShowCodeMessage('CCD00001',"Vendor Name"); 
							ComSetFocus(document.form.vndr_lgl_eng_nm);					
							return false;
						}
				    	// Location is null
			    	 if(formObj.loc_cd.value == "") {
							ComShowCodeMessage('CCD00001',"Location"); 
							ComSetFocus(document.form.loc_cd);					
							return false;
						}
				    	// Control Office is null
			    	 if(formObj.ofc_cd.value == "") {
							ComShowCodeMessage('CCD00001',"Control Office"); 
							ComSetFocus(document.form.ofc_cd);					
							return false;
						}
				    	//Payment Term is null
			    	 if(formObj.gen_pay_term_cd.Code == "") {
							ComShowCodeMessage('CCD00001',"Payment Term"); 
							ComSetFocus(document.form.gen_pay_term_cd);					
							return false;
						}
				    	//Payment Term Type is null
			    	 if(formObj.pay_term_tp_cd.Code == "") {
							ComShowCodeMessage('CCD00001',"Payment Term Type"); 
							ComSetFocus(document.form.pay_term_tp_cd);					
							return false;
						}
				    	//Payment Method is null
			    	 if(formObj.pay_mzd_cd.Code == "") {
							ComShowCodeMessage('CCD00001',"Payment Method"); 
							ComSetFocus(document.form.pay_mzd_cd);					
							return false;
						}
				    	//Invoice Currency is null
			    	 if(formObj.inv_curr_cd.value == "") {
							ComShowCodeMessage('CCD00001',"Invoice Currency"); 
							ComSetFocus(document.form.inv_curr_cd);					
							return false;
						}
				    	//Address(ENG) is null
			    	 if(formObj.eng_addr.value == "") {
							ComShowCodeMessage('CCD00001',"Address(ENG)"); 
							ComSetFocus(document.form.eng_addr);					
							return false;
						}
			    	 if (ComGetLenByByte(formObj.vndr_locl_lang_nm.value) > formObj.vndr_locl_lang_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Vendor Name(Local)", formObj.vndr_locl_lang_nm.getAttribute("maxLength")+" Bytes");
			              formObj.vndr_locl_lang_nm.select(); 
	       			     return false;
	    	          }   
			    	 if (ComGetLenByByte(formObj.locl_lang_addr.value) > formObj.locl_lang_addr.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Address(Local)", formObj.locl_lang_addr.getAttribute("maxLength")+" Bytes");
			              formObj.locl_lang_addr.select(); 
	      			     return false;
	   	             }
			    	 if (ComGetLenByByte(formObj.chk_de_addr1.value) > formObj.chk_de_addr1.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Address1(Local)", formObj.chk_de_addr1.getAttribute("maxLength")+" Bytes");
			              formObj.chk_de_addr1.select(); 
	     			     return false;
	  	             }
			    	 if (ComGetLenByByte(formObj.chk_de_addr2.value) > formObj.chk_de_addr2.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Address2(Local)", formObj.chk_de_addr2.getAttribute("maxLength")+" Bytes");
			              formObj.chk_de_addr2.select(); 
	    			     return false;
	 	             } 
			    	 if (ComGetLenByByte(formObj.chk_de_addr3.value) > formObj.chk_de_addr3.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Address3(Local)", formObj.chk_de_addr3.getAttribute("maxLength")+" Bytes");
			              formObj.chk_de_addr3.select(); 
	    			     return false;
	 	             }
			    	 if (ComGetLenByByte(formObj.vndr_abbr_nm.value) > formObj.vndr_abbr_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Short Name", formObj.vndr_abbr_nm.getAttribute("maxLength")+" Bytes");
			              formObj.vndr_abbr_nm.select(); 
	    			     return false;
	 	             }
			    	 if (ComGetLenByByte(formObj.cntc_pson_nm.value) > formObj.cntc_pson_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Contact Person", formObj.cntc_pson_nm.getAttribute("maxLength")+" Bytes");
			              formObj.cntc_pson_nm.select(); 
	    			     return false;
	 	             }
			    	 if (ComGetLenByByte(formObj.ceo_nm.value) > formObj.ceo_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "CEO Name", formObj.ceo_nm.getAttribute("maxLength")+" Bytes");
			              formObj.ceo_nm.select(); 
	    			     return false;
	 	             }
			    	 if (ComGetLenByByte(formObj.bzct_nm.value) > formObj.bzct_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Business Category", formObj.bzct_nm.getAttribute("maxLength")+" Bytes");
			              formObj.bzct_nm.select(); 
	    			     return false;
	 	             }
			    	 if (ComGetLenByByte(formObj.bztp_nm.value) > formObj.bztp_nm.getAttribute("maxLength")){
			              ComShowCodeMessage("COM12142", "Business Type", formObj.bztp_nm.getAttribute("maxLength")+" Bytes");
			              formObj.bztp_nm.select(); 
	    			     return false;
	 	             }
			    	 if(formObj.pay_mzd_cd.Code == "P" || formObj.pay_mzd_cd.Code == "T" || formObj.pay_mzd_cd.Code == "V"){
				    	 if(formObj.chk_de_addr1.value == "") {
								ComShowCodeMessage('CCD00001',"Address1(Local)"); 
								ComSetFocus(document.form.chk_de_addr1);					
								return false;
						 }
				    	 
				    	 if(formObj.chk_de_addr2.value == "") {
								ComShowCodeMessage('CCD00001',"Address2(Local)"); 
								ComSetFocus(document.form.chk_de_addr2);					
								return false;
						 }
				    	 
				    	 if(formObj.chk_de_cnt_cd.value == "") {
								ComShowCodeMessage('CCD00001',"Country Code"); 
								ComSetFocus(document.form.chk_de_cnt_cd);					
								return false;
						 }
			    	 }

			    	 //VENDOR CONTACT POINT
		            sheetObj=sheetObjects[0];
//		            var rowCnt = sheetObj.RowCount("I")+sheetObj.RowCount("R")+sheetObj.RowCount("U") ;
		            var phnRowCnt=0;
		            var faxRowCnt=0;
		            var phnCntPrimary=0;
		            var faxCntPrimary=0;
		            for(i=1; i <= sheetObjects[0].LastRow; i++){
		            	if(sheetObjects[0].CellValue(i,prefix1_1+"cntc_div_cd")=="PHN" && sheetObjects[0].CellValue(i,prefix1_1+"delt_flg")=="N") {
		            		phnRowCnt++;
		            	} else if(sheetObjects[0].CellValue(i,prefix1_1+"cntc_div_cd")=="FAX" && sheetObjects[0].CellValue(i,prefix1_1+"delt_flg")=="N") {
		            		faxRowCnt++;
		            	}
		            	
		            	if(sheetObjects[0].CellValue(i,prefix1_1+"prmry_chk_flg")=="Y" && sheetObjects[0].CellValue(i,prefix1_1+"cntc_div_cd")=="PHN" 
		            			&& sheetObjects[0].CellValue(i,prefix1_1+"delt_flg")=="N") {
		                    phnCntPrimary++;
		                } else if(sheetObjects[0].CellValue(i,prefix1_1+"prmry_chk_flg")=="Y" && sheetObjects[0].CellValue(i,prefix1_1+"cntc_div_cd")=="FAX"
		                				&& sheetObjects[0].CellValue(i,prefix1_1+"delt_flg")=="N") {
		                	faxCntPrimary++;
		                }
		                	
		            }

		            // Phone prmry_chk_flg 는 1개만 가능 
		            if(phnCntPrimary>1  || (phnCntPrimary == 0 && phnRowCnt > 0)){
		            	sheetObjects[0].SelectCell(1,prefix1_1+"prmry_chk_flg",0);
		                //ComShowMessage('Address primary flag only one.');
		                ComShowCodeMessage("CCD00068", "Phone");
		                return false;
		            }
		            
		            // Fax prmry_chk_flg 는 1개만 가능 
		            if(faxCntPrimary>1  || (faxCntPrimary == 0 && faxRowCnt > 0)){
		            	sheetObjects[0].SelectCell(1,prefix1_1+"prmry_chk_flg",0);
		                //ComShowMessage('Address primary flag only one.');
		                ComShowCodeMessage("CCD00068", "Fax");
		                return false;
		            }
		            
		            var emailRowCnt=0;
		            var emailCntPrimary=0;
		            
		            for(i=1; i <= sheetObjects[1].LastRow; i++){
		            	/*if(sheetObjects[1].CellValue(i,prefix1_2+"cntc_div_cd") == "") {
							ComShowCodeMessage('CCD00001',"Email/Web"); 
							sheetObjects[1].SelectCell(i, 4, false);					
							return false;
		            	}*/
		            	if(sheetObjects[1].CellValue(i,prefix1_2+"delt_flg")=="N") {
		            		emailRowCnt++;
		            	} 
		            	
		            	if(sheetObjects[1].CellValue(i,prefix1_2+"prmry_chk_flg")=="Y" && sheetObjects[1].CellValue(i,prefix1_2+"delt_flg")=="N") {
		                	emailCntPrimary++;
		                }
		            }
		            // Email & Web prmry_chk_flg 는 1개만 가능 
		            if(emailCntPrimary>1  || (emailCntPrimary == 0 && emailRowCnt > 0)){
		            	sheetObjects[1].SelectCell(1,prefix1_2+"prmry_chk_flg",0);
		                //ComShowMessage('Address primary flag only one.');
		                ComShowCodeMessage("CCD00068", "Email/Web");
		                return false;
		            }
		             
		            if(formObj.isRequest.value != "Y" && formObj.lgsFlg.value == 'Y' && sheetObjects[2].RowCount == 0) {
						ComShowCodeMessage('CCD00001',"Vendor Classification");
		            	return false;
		            } else if(formObj.isRequest.value != "Y" && formObj.lgsFlg.value == 'Y' && sheetObjects[2].RowCount != 0) {
		            	var nonDeltFlg = 0;
		            	for(var i=0; i<=sheetObjects[2].RowCount; i++) {
		            		if(sheetObjects[2].CellValue(i, prefix2+"delt_flg") == 'N') {
		            			nonDeltFlg++;
		            		}
		            	}	
		            	if(nonDeltFlg == 0) {
			            	ComShowCodeMessage('CCD00001',"Vendor Classification");
			            	return false;
		            	}	
		            }
		            
		    		for (var i=1; i<=sheetObjects[2].RowCount; i++) {
		    			var sb1=sheetObjects[2].CellValue(i,  prefix2+"vndr_cost_cd");
		    			var knd1=sheetObjects[2].CellValue(i, prefix2+"cntr_vndr_svc_cd");
		    			 if(sb1 == "" ) {
								ComShowCodeMessage('CCD00001',"Vendor Classification - Subject"); 
								sheetObjects[2].SelectCell(i,2, false);
								return false;
							}
		    			 if(knd1 == "") {
								ComShowCodeMessage('CCD00001',"Vendor Classification - Kind of Service"); 
								sheetObjects[2].SelectCell(i,3, false);
								return false;
							}

		    			for (var j=1; j<=sheetObjects[2].RowCount; j++) {
		    				var sb2=sheetObjects[2].CellValue(j,  prefix2+"vndr_cost_cd");
		    				var knd2=sheetObjects[2].CellValue(j, prefix2+"cntr_vndr_svc_cd");
							if (j != i && sb1 == sb2 && knd1 == knd2 ) {
								ComShowCodeMessage("CCD00004", "Vendor Classification : "+ sheetObjects[2].CellText(i, prefix2+"vndr_cost_cd")+" | "+ sheetObjects[2].CellText(i,  prefix2+"cntr_vndr_svc_cd"));
								sheetObjects[2].SelectCell(i,3, false);
								return false;
							}
		    			}
		    		}
		    		if (formObj.modi_vndr_cd.value != formObj.old_modi_vndr_cd.value) {
		    	    	formObj.edi_if_flg.value = "Y";	    			
		    	    } else {
		    	    	formObj.edi_if_flg.value = "N";
		    	    }
		    		if (!formObj.lgs_flg.checked && !formObj.blk_flg.checked && !formObj.procu_flg.checked && !formObj.otr_flg.checked
		    				&& !formObj.finc_flg.checked && !formObj.team_flg.checked && !formObj.inter_co_flg.checked) {
		    			ComShowCodeMessage("COM12113", "Vendor Type");
		    			ComSetFocus(formObj.lgs_flg);
		    			return false;
		    		}
		    		if (formObj.team_flg.checked) {
		    			if (formObj.vndr_ofc_cd.value.length < 1) {
		    				ComShowCodeMessage("CCD00001", "Organization Code");
		    				ComSetFocus(formObj.vndr_ofc_cd);
		    				return false;
		    			}
		    		}
		    		if (formObj.loc_cd.value.substring(0, 2) == "KR") {
		    			if(formObj.vndr_locl_lang_nm.value.length < 1) {
		    				ComShowCodeMessage("CCD00001", "Vendor Name(Local)");
		    				ComSetFocus(formObj.vndr_locl_lang_nm);
		    				return false;
		    			} else if(formObj.rgst_no.value.length < 1) {
		    				ComShowCodeMessage("CCD00001", "Register No.");
		    				ComSetFocus(formObj.rgst_no);
		    				return false;
		    			}
		    			var check_cd = doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
			 			if(check_cd != ""){
	    		        	ComShowCodeMessage("CCD00004", "Register No."); 		
	    		        	ComSetFocus(document.form.rgst_no);		
	    		        	return false;
			 			}		    		
		    		}
	    	 	}else{
	    	 		ComShowCodeMessage("CCD00048");
	    	 		return false;
	    	 	}
	    		
	    	 	break;
    	 }
 		return true;
 	}

   /**
    * Axon EVENT.<br>
    */    
     function initControl() {
    	//Axon event handling     
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);   
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form	); 
		axon_event.addListenerForm('change', 'obj_change', document.form);
		axon_event.addListenerForm('change', 'formObj_OnChange', document.form);		
     } 
     /**
      * All the combo box query
      */
 	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
 		switch (sAction) {
 			case SEARCH: // load page
 				var sXml=sheetObj.GetSearchXml("BCM_CCD_0040GS.do", "f_cmd=" + SEARCH);
 				var rtnValue=sXml.split("|$$|");

 				for(var i=0; i<rtnValue.length; i++){
 					var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
 					var cdName=comboXml[0].split("|");
 					var cdValue=comboXml[1].split("|");
 					if(i == 5){
						sheetObjects[2].InitDataCombo(0, prefix2+"vndr_cost_cd", "|"+comboXml[0], "|"+comboXml[1]);
					}else if(i == 6){
						caName = cdName[0]+"|"+cdName[1];
						cgName = cdName[6]+"|"+cdName[5]+"|"+cdName[8]+"|"+cdName[4]+"|"+cdName[3]+"|"+cdName[7]+"|"+cdName[2];
						cmName = cdName[9]+"|"+cdName[10]; 
						ctName = cdName[11];
						eqName = cdName[13]+"|"+cdName[15]+"|"+cdName[12]+"|"+cdName[14];
						mrName = cdName[16]+"|"+cdName[17]+"|"+cdName[24]+"|"+cdName[18]+"|"+cdName[25]+"|"+cdName[19]+"|"+cdName[20]+"|"+cdName[21]+"|"+cdName[22]+"|"+cdName[23];
						ptName = cdName[26]+"|"+cdName[30]+"|"+cdName[29]+"|"+"Line Handling Co."+"|"+"Launch Hire Co."+"|"+cdName[27]+"|"+cdName[28];
						srName = cdName[31];
						svName = cdName[34]+"|"+cdName[35]+"|"+cdName[33]+"|"+cdName[32];
						tmName = cdName[37]+"|"+"TMPTI"+"|"+cdName[36];
						trName = cdName[40]+"|"+cdName[42]+"|"+cdName[41]+"|"+cdName[39]+"|"+cdName[38];
						
						caValue = cdValue[0]+"|"+cdValue[1];
						cgValue = cdValue[6]+"|"+cdValue[5]+"|"+cdValue[8]+"|"+cdValue[4]+"|"+cdValue[3]+"|"+cdValue[7]+"|"+cdValue[2];						
						cmValue = cdValue[9]+"|"+cdValue[10];
						ctValue = cdValue[11];
						eqValue = cdValue[13]+"|"+cdValue[15]+"|"+cdValue[12]+"|"+cdValue[14];
						mrValue = cdValue[16]+"|"+cdValue[17]+"|"+cdValue[24]+"|"+cdValue[18]+"|"+cdValue[25]+"|"+cdValue[19]+"|"+cdValue[20]+"|"+cdValue[21]+"|"+cdValue[22]+"|"+cdValue[23];
						ptValue = cdValue[26]+"|"+cdValue[30]+"|"+cdValue[29]+"|"+cdValue[0]+"|"+cdValue[1]+"|"+cdValue[27]+"|"+cdValue[28];
						srValue = cdValue[31];
						svValue = cdValue[34]+"|"+cdValue[35]+"|"+cdValue[33]+"|"+cdValue[32];
						tmValue = cdValue[37]+"|"+cdValue[25]+"|"+cdValue[36];
						trValue = cdValue[40]+"|"+cdValue[42]+"|"+cdValue[41]+"|"+cdValue[39]+"|"+cdValue[38];
						
						sheetObjects[2].InitDataCombo(0, prefix2+"cntr_vndr_svc_cd", "|"+comboXml[0], "|"+comboXml[1]);
					}else{
	 					for (var j=0; j < cdName.length; j++) {
 							comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
	 					}
					}
 				}  
      		break;
      	}
 	}
    /**
     * If the data field to be the change Event
     */
    function obj_change(){
    	  var formObject=document.form;
    	  /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        if(formObject.ibflag.value != "I"){
        	formObject.ibflag.value="U";
        }
    	try {			
    		var srcName=ComGetEvent("name");
			if(!ComIsBtnEnable(srcName)) return false;
    		var obj=ComGetEvent();
    		var cName="";
            switch(srcName) {
            		case "tpb_flg":
            			var vndrSeq=formObject.vndr_seq.value;
            			if(formObject.tpb_flg.checked) {
            				formObject.tpb_flg.value='Y';
            				if(vndrSeq != '')
            					formObject.rfnd_psdo_cust_cd.value='TB' + vndrSeq;
            				else
            					formObject.rfnd_psdo_cust_cd.value = 'TB' ;
            			} else {
            				formObject.tpb_flg.value='N';
            				ComClearObject(formObject.rfnd_psdo_cust_cd);
            			}
            			break;
            		case "vndr_seq":
            			var max_seq=formObject.vndr_seq.value;
    					while(max_seq.toString().length < 6){
    						max_seq="0" + max_seq;
    					}
    					formObject.vndr_seq.value=max_seq;
	             		if(formObject.vndr_seq.value.length > 0){
	        		        	doActionIBSheet(sheetObject1,	formObject,	SEARCH01);
	              		}
	              		break;
            		case "rqst_no":
            			var max_seq = formObject.rqst_no.value;
            			while(max_seq.toString().length <6) {
            				max_seq = "0" + max_seq;
            			}
            			formObject.rqst_no.value = max_seq;
            			if(formObject.rqst_no.value.length >0) {
            				doActionIBSheet(sheetObject1, formObject, SEARCH08);
            			}
            			break;
            		case "lgs_flg":
	             		if(formObject.lgs_flg.checked){
	             			formObject.lgs_flg.value="Y";
	             			vndrTpEnable("lgs", true);
	              		}else{
	              			formObject.lgs_flg.value="N";
	              			vndrTpEnable("lgs", false);
	              		}
	              		break;	
            		case "blk_flg":
            			if(formObject.blk_flg.checked) {
            				formObject.blk_flg.value="Y";
            				vndrTpEnable("blk", true);
            			} else {
            				formObject.blk_flg.value="N";
            				vndrTpEnable("blk", false);
            			}
            			break;
            		case "procu_flg":
	             		if(formObject.procu_flg.checked){
	             			formObject.procu_flg.value="Y";
	              		}else{
	              			formObject.procu_flg.value="N";
	              		}
	              		break;	
            		case "finc_flg":
	             		if(formObject.finc_flg.checked){
	             			formObject.finc_flg.value="Y";
	              		}else{
	              			formObject.finc_flg.value="N";
	              		}
	              		break;	
            		case "team_flg":
	             		if(formObject.team_flg.checked){
	             			formObject.team_flg.value="Y";
            				vndrTpEnable("team", true);
	              		}else{
	              			formObject.team_flg.value="N";
            				vndrTpEnable("team", false);
	              		}
	              		break;	
            		case "inter_co_flg":
	             		if(formObject.inter_co_flg.checked){
	             			formObject.inter_co_flg.value="Y";
            				vndrTpEnable("inter_co", true);
	              		}else{
	              			formObject.inter_co_flg.value="N";
            				vndrTpEnable("inter_co", false);
	              		}
	              		break;	
            		case "otr_flg":
	             		if(formObject.otr_flg.checked){
	             			formObject.otr_flg.value="Y";
	              		}else{
	              			formObject.otr_flg.value="N";
	              		}
	              		break;	
	              	case "vndr_cnt_cd":
	              		if(formObject.vndr_cnt_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH03;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.vndr_cnt_cd.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.vndr_cnt_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Vendor Country"); 		
	        		        	ComSetFocus(document.form.vndr_cnt_cd);		
	        		        } 
	              		}
	              		break;
	              	case "loc_cd":
	              		if(formObject.loc_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH04;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.loc_cd.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.loc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Location"); 		
	        		        	ComSetFocus(document.form.loc_cd);		
	        		        }else{
	        		        	ComSetFocus(document.form.ofc_cd);
	        		        }
	              		}
	              		break;
	              	case "ofc_cd":
	              		if(formObject.ofc_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH05;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.ofc_cd.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	    		 			var cont_cd=ComGetEtcData(sXml, "country");
	        		        if(check_cd == ""){
	        		        	formObject.ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Control Office"); 		
	        		        	ComSetFocus(document.form.ofc_cd);		
	        		        }else{
	        		        	/*if(cont_cd == "JP"){
	        		        		ComShowCodeMessage("CCD00047");
	        		        		formObject.eng_addr.setAttribute("dataformat","engup");
	        		        		formObject.eng_addr.setAttribute("otherchar", " (,)/.+:'-");
	        		        	}else{
	        		        		formObject.eng_addr.setAttribute("dataformat","excepthan");
	        		        	}*/
	        		        	//ComSetFocus(document.form.rgst_no);
	        		        	ComSetFocus(document.form.tax_id);
	        		        } 
	              		}
	              		break;
	              	case "prnt_vndr_seq":
	              		if(formObject.prnt_vndr_seq.value.length>0){	
	              			formObject.f_cmd.value=SEARCH06;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.prnt_vndr_seq.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.prnt_vndr_seq.value="";
	        		        	ComShowCodeMessage("COM130402", "Parent Vendor"); 		
	        		        	ComSetFocus(document.form.prnt_vndr_seq);		
	        		        } 
	              		}
	              		break;
	              	case "inv_curr_cd":
	              		if(formObject.inv_curr_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH07;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.inv_curr_cd.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.inv_curr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Invoice Currency"); 		
	        		        	ComSetFocus(document.form.inv_curr_cd);		
	        		        }else{
	        		        	ComSetFocus(document.form.cntc_pson_nm);
	        		        }  
	              		}
	              		break;
	              	case "vndr_ofc_cd":
	              		if(formObject.vndr_ofc_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH05;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value + "&check_cd=" +formObject.vndr_ofc_cd.value;
	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd=ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.vndr_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Vendor Office"); 		
	        		        	ComSetFocus(document.form.vndr_ofc_cd);		
	        		        }else{
	        		        	ComSetFocus(document.form.subs_co_cd);
	        		        }  
	              		}
	              		break;
	              	 case "vndr_locl_lang_nm":
	              		cName="Vendor Name(Local)";
	              		var attriVal=obj.getAttribute("maxLength");
	              		var sVal=ComGetLenByByte(obj.value);
	              		if (sVal > attriVal){
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.vndr_locl_lang_nm); 
	              			return false;
	              		}
	              		break;
	              	 case "locl_lang_addr":
	              		cName="Address(Local)";
	              		var attriVal=obj.getAttribute("maxLength");
	              		var sVal=ComGetLenByByte(obj.value);
	              		if (sVal > attriVal){
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.locl_lang_addr); 
	              			return false;
	              		}
	              		break;
	              	 case "chk_de_addr1":
	              		cName="Address1(Local)";
	              		var attriVal=obj.getAttribute("maxLength");
	              		var sVal=ComGetLenByByte(obj.value);
	              		if (sVal > attriVal){
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.chk_de_addr1); 
	              			return false;
	              		}
	              		break;
	              	 case "chk_de_addr2":
	              		cName="Address2(Local)";
	              		var attriVal=obj.getAttribute("maxLength");
	              		var sVal=ComGetLenByByte(obj.value);
	              		if (sVal > attriVal){
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.chk_de_addr2); 
	              			return false;
	              		}
	              		break;
	              	 case "chk_de_addr3":
	              		cName="Address3(Local)";
	              		var attriVal=obj.getAttribute("maxLength");
	              		var sVal=ComGetLenByByte(obj.value);
	              		if (sVal > attriVal){
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.chk_de_addr3); 
	              			return false;
	              		}
	              		break;
	              		
	              	 case "vndr_abbr_nm":
	              	 	cName="Short Name";
	              	 	var attriVal = obj.getAttribute("maxLength"); 
	              	 	var sVal = ComGetLenByByte(obj.value);
	              	 	if (sVal > attriVal) {
	              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
	              			ComSetFocus(formObject.chk_de_addr3); 
	              			return false;
	              	 	}
	              	 	break;
	              	
	              	 case "cntc_pson_nm":
		              	 	cName="Contact Person";
		              	 	var attriVal = obj.getAttribute("maxLength"); 
		              	 	var sVal = ComGetLenByByte(obj.value);
		              	 	if (sVal > attriVal) {
		              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
		              			ComSetFocus(formObject.chk_de_addr3); 
		              			return false;
		              	 	}
		              	 	break;
	              	 	
	              	 case "ceo_nm":
		              	 	cName="CEO Name";
		              	 	var attriVal = obj.getAttribute("maxLength"); 
		              	 	var sVal = ComGetLenByByte(obj.value);
		              	 	if (sVal > attriVal) {
		              			ComShowCodeMessage("COM12142", cName, attriVal+" Bytes");
		              			ComSetFocus(formObject.chk_de_addr3); 
		              			return false;
		              	 	}
		              	 	break;
	              	 	 	
	              	case "chk_de_ste_cd":
	              		if(formObject.chk_de_ste_cd.value.length > 0) {	
	              			formObject.f_cmd.value = SEARCH09;
	    		 			var sParam = "f_cmd=" + SEARCH09 + "&check_de_cnt_cd=" + formObject.chk_de_cnt_cd.value + "&check_cd=" + formObject.chk_de_ste_cd.value;
	    		 			var sXml = sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd = ComGetEtcData(sXml, "result");
	        		        if(check_cd == "") {
	        		        	formObject.chk_de_ste_cd.value = "";
	        		        	ComShowCodeMessage("COM130402", "State"); 		
	        		        	ComSetFocus(document.form.chk_de_ste_cd);		
	        		        } else {
	        		        	formObject.chk_de_cnt_cd.value = ComGetEtcData(sXml, "cnt_cd");
	        		        }
	              		}
	              		break;
	              	case "chk_de_cnt_cd":
	              		if(formObject.chk_de_cnt_cd.value.length > 0) {
	              			formObject.f_cmd.value = SEARCH03;
	    		 			var sParam = "f_cmd=" + formObject.f_cmd.value + "&check_cd=" + formObject.chk_de_cnt_cd.value;
	    		 			var sXml = sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
	    		 			var check_cd = ComGetEtcData(sXml, "result");
	        		        if(check_cd == ""){
	        		        	formObject.chk_de_cnt_cd.value = "";
	        		        	ComShowCodeMessage("COM130402", "Check Delivery Country");
	        		        	ComSetFocus(document.form.chk_de_cnt_cd);
	        		        } else {
	    	              		if(formObject.chk_de_ste_cd.value.length > 0) {	
			              			formObject.f_cmd.value = SEARCH09;
			    		 			var sParam = "f_cmd=" + SEARCH09 + "&check_de_cnt_cd=" + formObject.chk_de_cnt_cd.value + "&check_cd=" + formObject.chk_de_ste_cd.value;
			    		 			var sXml = sheetObject1.GetSearchXml("BCM_CCD_0040GS.do", sParam);
			    		 			var check_cd = ComGetEtcData(sXml, "result");
			        		        if(check_cd == "") {
			        		        	ComShowCodeMessage("COM130402", "Check Delivery State");
			        		        	ComSetFocus(document.form.chk_de_ste_cd);
			        		        }
	    	              		}
	        		        }
	              		}
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
     * Delete Flag column values ​​'Y' Confirm Message When selecting the output
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet1_1_OnChange(sheetObj, row, col, value) {
		if(sheetObj.CellValue(row, prefix1_1 + "cntc_div_cd") == "PHN") {
			sheetObj.CellValue2(row, prefix1_1 + "intl_phn_no") = sheetObj.CellValue(row, prefix1_1 + "intl_no");
			sheetObj.CellValue2(row, prefix1_1 + "phn_no") = sheetObj.CellValue(row, prefix1_1 + "no");
		} else if (sheetObj.CellValue(row, prefix1_1 + "cntc_div_cd") == "FAX" ){
			sheetObj.CellValue2(row, prefix1_1 + "intl_fax_no") = sheetObj.CellValue(row, prefix1_1 + "intl_no");
			sheetObj.CellValue2(row, prefix1_1 + "fax_no") = sheetObj.CellValue(row, prefix1_1 + "no");		
		}

    	if(sheetObj.ColSaveName(col) != prefix1_1+"delt_flg") return;
    	if(value != 'Y') return;
    	if( !ComShowConfirm(ComGetMsg("CCD00012")) ) {
    		sheetObj.CellValue(row, col) = 'N';
    	}
    }
    
    /**
     * Delete Flag column values ​​'Y' Confirm Message When selecting the output
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet1_2_OnChange(sheetObj, row, col, value) {
    	if(sheetObj.ColSaveName(col) != prefix1_2+"delt_flg") return;
    	if(value != 'Y') return;
    	if( !ComShowConfirm(ComGetMsg("CCD00012")) ) {
    		sheetObj.CellValue(row, col) = 'N';
    	}
    }
    /**
     * Delete Flag column values ​​'Y' Confirm Message When selecting the output
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet2_OnChange(sheetObj, row, col, value) {
    	if(sheetObj.ColSaveName(col) != prefix2+"delt_flg") return;
    	if(value != 'Y') return;
    	if( !ComShowConfirm(ComGetMsg("CCD00012")) ) {
    		sheetObj.CellValue(row, col) = 'N';
    	}
    }
    /**
     * Delete Flag column values ​​'Y' Confirm Message When selecting the output
     * @param comboObj
     * @param code
     * @param text
     */
    function delt_flg_OnChange() {//CHECK OLD CODE: OnChange(comboObj, code, text) {
 	   document.form.onchange_flag.value = "Y"; 	   
       if(document.form.delt_flg.value != 'Y') return;
 	   if( !ComShowConfirm(ComGetMsg("CCD00012")) ) {
 		  document.form.delt_flg.value = 'N';
 	   }
    }

    /**
     * COM_ENS_051 : LOC_CD
     */
    function getCOM_ENS_051_loc_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.loc_cd.value=colArray[1];
    	formObj_OnChange();
    }    
    /**
     * COM_ENS_071 : Office code
     */
    function getCOM_ENS_071_ofc_cd(rowArray) {    	
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ofc_cd.value=colArray[1];			 
    	formObj_OnChange();
    }	
    
    /**
	 * COM_ENS_0C1 : Vendor code
	 */
   function getCOM_ENS_0C1_prnt_vndr_cd(rowArray, row, col) {   
   	var formObj=document.form;
	var colArray=rowArray[0];	
	formObj.prnt_vndr_seq.value=colArray[2];
	formObj_OnChange();
    }   
   /**
	 * COM_ENS_N13 : Currency code
	 */
   function getCOM_ENS_N13_inv_curr_cd(rowArray) { 
   	var formObj=document.form;
   	var colArray=rowArray[0];	
   	formObj.inv_curr_cd.value=colArray[1];	
   	formObj_OnChange();
   } 
   /**
    * COM_ENS_071 : Office code
    */
   function getCOM_ENS_071_vndr_ofc_cd(rowArray) {    	
   	var formObj=document.form;
   	var colArray=rowArray[0];	
   	formObj.vndr_ofc_cd.value=colArray[1];	
   	formObj_OnChange();
   }	
   /**
    * COM_ENS_0M1 : Country code
    */
   function getCOM_ENS_0M1_vndr_cnt_cd(rowArray) {    	
   	var formObj=document.form;
   	var colArray=rowArray[0];	
   	formObj.vndr_cnt_cd.value=colArray[1];		
   	formObj_OnChange();
   }
   function getCOM_ENS_0M1_chk_de_cnt_cd(rowArray) {    	
		var formObj=document.form;
		var colArray=rowArray[0];	
		formObj.chk_de_cnt_cd.value=colArray[1];		
		formObj_OnChange();
   }
   /**
    * COM_COM_0007 : Vendor code
    */
   function getBtn_vndr_cd_pop(rowArray) {    	
   	var formObj=document.form;
   	var colArray=rowArray[0];	
   	formObj.vndr_seq.value=colArray[2];
    var sheetObject1=sheetObjects[0];
    formObj.rqst_no.value = "";
	if (formObj.rqst_no.value=='' || formObj.rqst_no.value == undefined){
		doActionIBSheet(sheetObject1,	formObj,	SEARCH01);
	} else{
		formObj.vndr_seq.value="";
		doActionIBSheet(sheetObject1,	formObj,	SEARCH08);
	}
   }
   
   /**
    * Payment Method Change Event
    * @param comboObj
    * @param code
    * @param text
    */
   function pay_mzd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
	   var formObj=document.form;
	   formObj.onchange_flag.value = "Y";
	   if(newCode == "P" || newCode == "T" || newCode == "V"){
		   formObj.chk_de_addr1.setAttribute("class","input1");
		   formObj.chk_de_addr2.setAttribute("class","input1");
		   formObj.chk_de_cnt_cd.setAttribute("class","input1");
	   }else{
		   formObj.chk_de_addr1.setAttribute("class","input");
		   formObj.chk_de_addr2.setAttribute("class","input");
		   formObj.chk_de_cnt_cd.setAttribute("class","input");
	   }
   }
   
   function formObj_OnChange() {
	   document.form.onchange_flag.value = "Y";
   }
   
   function gen_pay_term_cd_OnChange() {
	   document.form.onchange_flag.value = "Y";
   }
   
   function pay_term_tp_cd_OnChange() {
	   document.form.onchange_flag.value = "Y";
   }

   function subs_co_cd_OnChange() {
	   document.form.onchange_flag.value = "Y";
   }
   
   function blk_vndr_svc_cd_OnChange() {
	   document.form.onchange_flag.value = "Y";
   }
   
   function vndrTpEnable(view, value) {
	   var formObj=document.form;
	   switch(view) {
	   	   case "all":
		   		ComEnableObject(formObj.usa_edi_cd, value);
		   		ComEnableObject(formObj.svc_scp_cd_nm, value);
		   		ComEnableObject(formObj.svc_prd_tp_nm, value);
		   		ComEnableObject(formObj.svc_prd_rmk, value);
		   		ComEnableObject(formObj.dcgo_hndl_flg, value);
		   		ComEnableObject(formObj.mty_rro_edi_use_flg, value);
		   		ComEnableObject(formObj.wo_atch_file_flg, value);
		   		ComEnableObject(formObj.wo_edi_use_flg, value);
		   		ComEnableObject(formObj.inv_edi_use_flg, value);
		   		ComEnableObject(formObj.tpb_flg, value);
		   		ComEnableObject(formObj.vndr_ofc_cd, value);
				ComEnableObject(formObj.btn_com_ens_071_vndr_ofc_cd, value);
				formObj.blk_vndr_svc_cd.Enable = value;
				formObj.subs_co_cd.Enable = value;
		   		//ComEnable 함수가 두번 실행되면 글자가 빨간색으로 되는 CSS 제어
				if(value) {
					formObj.usa_edi_cd.className = "input";
					formObj.svc_scp_cd_nm.className = "input";
					formObj.svc_prd_tp_nm.className = "input";
					formObj.svc_prd_rmk.className = "input";
					formObj.dcgo_hndl_flg.className = "input";
					formObj.mty_rro_edi_use_flg.className = "input";
					formObj.wo_atch_file_flg.className = "input";
					formObj.wo_edi_use_flg.className = "input";
					formObj.inv_edi_use_flg.className = "input";
					formObj.tpb_flg.className = "input";
					formObj.vndr_ofc_cd.className = "input";
				} else {
					formObj.usa_edi_cd.className = "input2";
					formObj.svc_scp_cd_nm.className = "input2";
					formObj.svc_prd_tp_nm.className = "input2";
					formObj.svc_prd_rmk.className = "input2";
					formObj.dcgo_hndl_flg.className = "input2";
					formObj.mty_rro_edi_use_flg.className = "input2";
					formObj.wo_atch_file_flg.className = "input2";
					formObj.wo_edi_use_flg.className = "input2";
					formObj.inv_edi_use_flg.className = "input2";
					formObj.tpb_flg.className = "input2";
					formObj.vndr_ofc_cd.className = "input2";
				}
	   		    break;
	   		   
	   	   case "lgs":
		   		ComEnableObject(formObj.usa_edi_cd, value);
				ComEnableObject(formObj.svc_scp_cd_nm, value);
				ComEnableObject(formObj.svc_prd_tp_nm, value);
				ComEnableObject(formObj.svc_prd_rmk, value);
				ComEnableObject(formObj.dcgo_hndl_flg, value);
				ComEnableObject(formObj.mty_rro_edi_use_flg, value);
				ComEnableObject(formObj.wo_atch_file_flg, value);
				ComEnableObject(formObj.wo_edi_use_flg, value);
				ComEnableObject(formObj.inv_edi_use_flg, value);
				ComEnableObject(formObj.tpb_flg, value);
				if(value) {
					formObj.usa_edi_cd.className = "input";
					formObj.svc_scp_cd_nm.className = "input";
					formObj.svc_prd_tp_nm.className = "input";
					formObj.svc_prd_rmk.className = "input";
					formObj.dcgo_hndl_flg.className = "input";
					formObj.mty_rro_edi_use_flg.className = "input";
					formObj.wo_atch_file_flg.className = "input";
					formObj.wo_edi_use_flg.className = "input";
					formObj.inv_edi_use_flg.className = "input";
					formObj.tpb_flg.className = "input";
					formObj.lgsFlg.value = "Y";
				} else {
					formObj.usa_edi_cd.className = "input2";
					formObj.svc_scp_cd_nm.className = "input2";
					formObj.svc_prd_tp_nm.className = "input2";
					formObj.svc_prd_rmk.className = "input2";
					formObj.dcgo_hndl_flg.className = "input2";
					formObj.mty_rro_edi_use_flg.className = "input2";
					formObj.wo_atch_file_flg.className = "input2";
					formObj.wo_edi_use_flg.className = "input2";
					formObj.inv_edi_use_flg.className = "input2";
					formObj.tpb_flg.className = "input2";		
					formObj.lgsFlg.value = "N";
				}
	   		    break;
	   		   
	   	   case "blk":
				formObj.blk_vndr_svc_cd.Enable = value;
	   		    break;
	   		   
	   	   case "team":
				ComEnableObject(formObj.vndr_ofc_cd, value);
				ComEnableObject(formObj.btn_com_ens_071_vndr_ofc_cd, value);
				if(value) {
					formObj.vndr_ofc_cd.className = "input";
				} else {
					formObj.vndr_ofc_cd.className = "input2";
				}
	   		    break;
	   		
	   	   case "inter_co":
				formObj.subs_co_cd.Enable = value;
	   		    break;
	   }
   }
   
   function chkDeEnable(value) {
	   var formObj=document.form;
	   ComEnableObject(formObj.chk_de_addr1, value);
	   ComEnableObject(formObj.chk_de_addr2, value);
	   ComEnableObject(formObj.chk_de_addr3, value);
	   ComEnableObject(formObj.chk_de_cnt_cd, value);
	   ComEnableObject(formObj.chk_de_ste_cd, value);
	   ComEnableObject(formObj.chk_de_cty_nm, value);
	   ComEnableObject(formObj.chk_de_zip_cd, value);
	   ComEnableObject(formObj.lu_delt_flg, value);
	   ComEnableObject(formObj.btn_chk_de_cnt_cd, value);
	   ComEnableObject(formObj.btn_chk_de_ste_cd, value);
	   if(value) {
			formObj.chk_de_addr1.className = "input";
			formObj.chk_de_addr2.className = "input";
			formObj.chk_de_addr3.className = "input";
			formObj.chk_de_cnt_cd.className = "input";
			formObj.chk_de_ste_cd.className = "input";
			formObj.chk_de_cty_nm.className = "input";
			formObj.chk_de_zip_cd.className = "input";
			formObj.lu_delt_flg.className = "input";
	   } else {
			formObj.chk_de_addr1.className = "input2";
			formObj.chk_de_addr2.className = "input2";
			formObj.chk_de_addr3.className = "input2";
			formObj.chk_de_cnt_cd.className = "input2";
			formObj.chk_de_ste_cd.className = "input2";
			formObj.chk_de_cty_nm.className = "input2";
			formObj.chk_de_zip_cd.className = "input2";
			formObj.lu_delt_flg.className = "input2";		   
	   }
   }
   
   function popupViewEnable(value) {
	   	var formObj=document.form;
		for(var i=0; i<formObj.elements.length; i++) {
			if (formObj.elements[i].type == "text" || formObj.elements[i].type == "select-one"
				|| formObj.elements[i].type == "checkbox") {
				ComEnableObject(formObj.elements[i], value);
				if(value) {
					formObj.elements[i].className = "input";
				} else {
					formObj.elements[i].className = "input2";
				}
			}
		}			
		formObj.gen_pay_term_cd.Enable  = value;
		formObj.subs_co_cd.Enable = value;
		formObj.pay_term_tp_cd.Enable  = value;
		formObj.pay_mzd_cd.Enable = value;
		ComEnableObject(formObj.btn_vndr_cd_pop, value);
		ComEnableObject(formObj.btn_com_ens_051_loc_cd, value);
		ComEnableObject(formObj.btn_com_ens_071_ofc_cd, value);
		ComEnableObject(formObj.btn_com_ens_0c1_prnt_vndr_cd, value);
		ComEnableObject(formObj.btn_com_ens_n13_inv_curr_cd, value);
		ComEnableObject(formObj.btn_chk_de_cnt_cd, value);
		ComEnableObject(formObj.btn_chk_de_ste_cd, value);   		
   }
   
function requestFromEnable(value) {
	var formObj = document.form;
	var input;
	var input1;
		if(value) {
			input = "#E8E7EC";
			input1 = "#E8E7EC";
				
		} else {
			input = "#FFFFFF";
			input1 = "#CCFFFD";
		}
		formObj.vndr_lgl_eng_nm.readOnly = value;
		formObj.vndr_lgl_eng_nm.style.backgroundColor = input1;
		formObj.vndr_locl_lang_nm.readOnly = value;
		formObj.vndr_locl_lang_nm.style.backgroundColor = input;
		formObj.vndr_abbr_nm.readOnly = value;
		formObj.vndr_abbr_nm.style.backgroundColor = input;
		formObj.loc_cd.readOnly = value;
		formObj.loc_cd.style.backgroundColor = input1;
		formObj.ofc_cd.readOnly = value;
		formObj.ofc_cd.style.backgroundColor = input1;
		formObj.tax_id.readOnly = value;
		formObj.tax_id.style.backgroundColor = input;
		formObj.rgst_no.readOnly = value;
		formObj.rgst_no.style.backgroundColor = input;
		formObj.prnt_vndr_seq.readOnly = value;
		formObj.prnt_vndr_seq.style.backgroundColor = input;
		formObj.inv_curr_cd.readOnly = value;
		formObj.inv_curr_cd.style.backgroundColor = input1;
		formObj.cntc_pson_nm.readOnly = value;
		formObj.cntc_pson_nm.style.backgroundColor = input;
		formObj.eng_addr.readOnly = value;
		formObj.eng_addr.style.backgroundColor = input1;
		formObj.zip_cd.readOnly = value;
		formObj.zip_cd.style.backgroundColor = input;
		formObj.locl_lang_addr.readOnly = value;
		formObj.locl_lang_addr.style.backgroundColor = input;
		formObj.ceo_nm.readOnly = value;
		formObj.ceo_nm.style.backgroundColor = input;
		formObj.bzct_nm.readOnly = value;
		formObj.bzct_nm.style.backgroundColor = input;
		formObj.bztp_nm.readOnly = value;
		formObj.bztp_nm.style.backgroundColor = input;
		formObj.gen_pay_term_cd.Enable = !value;
		formObj.pay_term_tp_cd.Enable = !value;
		formObj.pay_mzd_cd.Enable = !value;
		ComEnableObject(formObj.btn_com_ens_051_loc_cd, !value);
		ComEnableObject(formObj.btn_com_ens_071_ofc_cd, !value);
		ComEnableObject(formObj.btn_com_ens_0c1_prnt_vndr_cd, !value);
		ComEnableObject(formObj.btn_com_ens_n13_inv_curr_cd, !value);
		ComEnableObject(formObj.lgs_flg, !value);
		ComEnableObject(formObj.blk_flg, !value);
		ComEnableObject(formObj.procu_flg, !value);
		ComEnableObject(formObj.finc_flg, !value);
		ComEnableObject(formObj.team_flg, !value);
		ComEnableObject(formObj.inter_co_flg, !value);
		ComEnableObject(formObj.otr_flg, !value);
}

function sheet2_OnComboChange(sheetObj, Row, Col, Text) {
	if(Col == 2) {
		if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "SV") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", svName, svValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = svValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "TM") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", tmName, tmValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = tmValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "SR") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", srName, srValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = srValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "TR") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", trName, trValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = trValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "CG") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", cgName, cgValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = cgValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "CT") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", ctName, ctValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = ctValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "EQ") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", eqName, eqValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = eqValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "MR") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", mrName, mrValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = mrValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "CM") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", cmName, cmValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = cmValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "PT") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", ptName, ptValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = ptValue.split("|")[0];
		} else if (sheetObj.CellValue(Row, prefix2 + "vndr_cost_cd") == "CA") {
			sheetObj.CellComboItem(Row, prefix2+"cntr_vndr_svc_cd", caName, caValue);
			sheetObj.CellValue(Row, prefix2 + "cntr_vndr_svc_cd") = caValue.split("|")[0];
		}
	}
	//if (sheetObjects[2].CellValue(Row, prefix2 + "vndr_cost_cd") == 
}
   
