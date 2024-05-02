/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0009.js
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


   /**
     * @fileoverview
     * @author 
     */

    /**
     * @extends 
     * @class ESD_LEA_0009 : business script for ESD_LEA_0009
     */
    function ESD_LEA_0009() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    // The global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
    function processButtonClick(){	
		var sheetObject = sheetObjects[0];
		
		var formObject = document.form;

		try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
				
					case "btn_parameter":            	   
						var strToolTip	=	"$FROM       : From mail Address"	+"\n"+
											"$TO         : To mail Address"		+"\n"+      
											"$EXE_YRMON  : Execute Year Month"	+"\n"+      
											"$ST_TM      : Batch Start Time"	+"\n"+      
											"$END_TM     : Batch End Time"		+"\n"+      
											"$WRK_FLAG   : Success/Fail";
						ComShowMessage(strToolTip);  
            	        break;

					case "btn_parameter2":          	   
						var strToolTip	=	"$FROM      : From mail Address"	+"\n"+
											"$TO        : To mail Address"		+"\n"+      
											"$EXE_YRMON : Execute Year Month"	+"\n"+      
											"$ST_TM     : Batch Start Time"		+"\n"+      
											"$END_TM    : Batch End Time"		+"\n"+      
											"$WRK_FLAG  : Success/Fail";
						ComShowMessage(strToolTip);  
            	        break;

					case "btn_settingapply":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;

            	    case "btn_mailsendtest":
           	    	
            	    	if(formObject.frm_save_div.value != "Y" ){
							ComShowMessage(ComGetMsg("LEA90014"));
							return false;
            	    	}
            	    	doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
            	    	break;

                } // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
    }



		/**
		 * registering IBSheet Object as list
		 * adding process for list in case of needing batch processing with other items 
		 * defining list on the top of source
		 */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;

        }

        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
    			for(k=0;k<tabObjects.length;k++){
    				initTab(tabObjects[k],k+1);
    			}
            for(i=0;i<sheetObjects.length;i++){

                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }

           
		document.form.frm_mail_div.value = "B";
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		lea_sheetToFormValue(sheetObjects[0],document.form);   		
		
	}


	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}


	/**
     * initializing Tab
     * setting Tab items
     */
	function initTab(tabObj , tabNo) {	
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++, "Batch" , -1 );
					InsertTab( cnt++, "Interface" , -1 );
				}
				break;
		}
	}

	
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		
		beforetab= nItem;
    		
		var formObj = document.form;
		
		switch(nItem) {
			case 0:
				formObj.frm_mail_div		.value = "B";
				formObj.frm_bat_fm_eml    	.valid = "1";
				formObj.frm_bat_to_eml    	.valid = "1";
				formObj.frm_bat_subj_nm   	.valid = "1";
				formObj.frm_bat_ctnt   	  	.valid = "1";
				formObj.frm_if_fm_eml     	.valid = "0";
				formObj.frm_if_to_eml     	.valid = "0";
				formObj.frm_if_subj_nm    	.valid = "0";
				formObj.frm_if_ctnt    		.valid = "0";
				break;
				
			case 1:
				formObj.frm_mail_div		.value = "I";
				formObj.frm_bat_fm_eml    	.valid = "0";
				formObj.frm_bat_to_eml    	.valid = "0";
				formObj.frm_bat_subj_nm   	.valid = "0";
				formObj.frm_bat_ctnt   	  	.valid = "0";
				formObj.frm_if_fm_eml     	.valid = "1";
				formObj.frm_if_to_eml     	.valid = "1";
				formObj.frm_if_subj_nm    	.valid = "1";
				formObj.frm_if_ctnt    		.valid = "1";
				break;
		}
	}

	
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1: //IBSheet1 init
				with (sheetObj) {
				//Setting width
					SheetWidth = mainTable.clientWidth;
		
					 //Setting the Host information[Required][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//Kind of merge[Optional, Default msNone]
					MergeSheet = msAll;
		
					//Edit kind[Optional, Default false]
					Editable = true;
		
					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
		
					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(16, 0, 0, true);
		
					//Setting function handling header
					InitHeadMode(true, true, true, true, false,false)
		
					var HeadTitle = "|";
		
					//Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//Data attribute 		[ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtStatus,     30,    daCenter,  true,    	"ibflag");
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"pgm_sub_sys_cd" ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"eml_svr_ip"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"port_no"        ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_fm_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_to_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_cc_eml"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_subj_nm"    ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_ctnt"       ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"bat_snd_flg"    ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_fm_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_to_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_cc_eml"      ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_subj_nm"     ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_ctnt"        ,        false,          "",       dfNone,     	0,     false,   false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    	"if_snd_flg"     ,        false,          "",       dfNone,     	0,     false,   false);
					
					style.height = GetSheetHeight(13) ;
				}
				break;		
		}
	}

	
	// Handling the process about the sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH: //Retrieving
				formObj.f_cmd.value = SEARCH01;
				
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", leaFormQueryString(formObj));
				
				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
				break;

			case IBSAVE: //Saving
				if (!lea_comm_validChkForm(formObj)){
					return false;
				}				
				
				lea_formValueToSheet(sheetObj,formObj);
				
				formObj.f_cmd.value = MULTI;
				
				var param = sheetObj.GetSaveString(true);
				
				var savexml = sheetObj.GetSaveXml("ESD_LEA_0009GS.do", param+"&"+ leaFormQueryString(formObj));	
				
				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
				break;

			case IBSEARCH_ASYNC01:  //SEND MAIL
				if (!lea_comm_validChkForm(formObj)){
					return false;
				}
				
				lea_formValueToSheet(sheetObj,formObj);
				
				formObj.f_cmd.value = SEARCH03;
				
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0009GS.do", leaFormQueryString(formObj));
				
				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
				ComShowMessage(ComGetMsg("LEA90023"));
				break;				
		}
	}

	/**
     * Handling the process for the input validation
     */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//			if (!isNumber(iPage)) {
//				return false;
//			}
		}
		return true;
	}
	
	
	/**
     * Handling the event after finishing to save the sheet data
     */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			document.form.frm_save_div.value = "Y";
			ComShowMessage(ComGetMsg("LEA90024"));
			document.form.frm_mail_div.value = "B";
			doActionIBSheet(sheetObj,document.form,IBSEARCH);

		} else {
			ComShowMessage(ComGetMsg("LEA90009"));
			return;
		}
	}
	 
	
	/**
	 * Copying the sheet data to the form one.
	 */
	function lea_sheetToFormValue(sheetObj,formObj){
		if (sheetObj.RowCount > 0){
			formObj.frm_save_div		.value = "Y";
			formObj.frm_eml_svr_ip    	.value = sheetObj.CellValue(1, "eml_svr_ip"     );
			formObj.frm_port_no       	.value = sheetObj.CellValue(1, "port_no"        );
			formObj.frm_bat_fm_eml    	.value = sheetObj.CellValue(1, "bat_fm_eml"     );
			formObj.frm_bat_to_eml    	.value = sheetObj.CellValue(1, "bat_to_eml"     );
			formObj.frm_bat_cc_eml    	.value = sheetObj.CellValue(1, "bat_cc_eml"     );
			formObj.frm_bat_subj_nm   	.value = sheetObj.CellValue(1, "bat_subj_nm"    );
			formObj.frm_bat_ctnt      	.value = sheetObj.CellValue(1, "bat_ctnt"       );
			formObj.frm_bat_snd_flg   	.value = sheetObj.CellValue(1, "bat_snd_flg"    );
			formObj.frm_if_fm_eml     	.value = sheetObj.CellValue(1, "if_fm_eml"      );
			formObj.frm_if_to_eml     	.value = sheetObj.CellValue(1, "if_to_eml"      );
			formObj.frm_if_cc_eml     	.value = sheetObj.CellValue(1, "if_cc_eml"      );
			formObj.frm_if_subj_nm    	.value = sheetObj.CellValue(1, "if_subj_nm"     );
			formObj.frm_if_ctnt       	.value = sheetObj.CellValue(1, "if_ctnt"        );
			formObj.frm_if_snd_flg    	.value = sheetObj.CellValue(1, "if_snd_flg"     );	
			formObj.frm_bat_to_eml_len	.value = ComGetLenByByte(sheetObj.CellValue(1, "bat_to_eml"    ));
			formObj.frm_bat_cc_eml_len	.value = ComGetLenByByte(sheetObj.CellValue(1, "bat_cc_eml"    ));
			formObj.frm_if_to_eml_len 	.value = ComGetLenByByte(sheetObj.CellValue(1, "if_to_eml"     ));
			formObj.frm_if_cc_eml_len 	.value = ComGetLenByByte(sheetObj.CellValue(1, "if_cc_eml"     ));
		}			
	}
	
	
	/**
	 * Copying the form data to the sheet one
	 */
	function lea_formValueToSheet(sheetObj,formObj){
		if (sheetObj.RowCount == 0){
			//Add row
			sheetObj.DataInsert(-1);
		}
		sheetObj.CellValue(1, "eml_svr_ip"     ) = formObj.frm_eml_svr_ip    .value;
		sheetObj.CellValue(1, "port_no"        ) = formObj.frm_port_no       .value;
		sheetObj.CellValue(1, "bat_fm_eml"     ) = formObj.frm_bat_fm_eml    .value;
		sheetObj.CellValue(1, "bat_to_eml"     ) = formObj.frm_bat_to_eml    .value;
		sheetObj.CellValue(1, "bat_cc_eml"     ) = formObj.frm_bat_cc_eml    .value;
		sheetObj.CellValue(1, "bat_subj_nm"    ) = formObj.frm_bat_subj_nm   .value;
		sheetObj.CellValue(1, "bat_ctnt"       ) = formObj.frm_bat_ctnt      .value;
		sheetObj.CellValue(1, "bat_snd_flg"    ) = formObj.frm_bat_snd_flg   .value;
		sheetObj.CellValue(1, "if_fm_eml"      ) = formObj.frm_if_fm_eml     .value;
		sheetObj.CellValue(1, "if_to_eml"      ) = formObj.frm_if_to_eml     .value;
		sheetObj.CellValue(1, "if_cc_eml"      ) = formObj.frm_if_cc_eml     .value;
		sheetObj.CellValue(1, "if_subj_nm"     ) = formObj.frm_if_subj_nm    .value;
		sheetObj.CellValue(1, "if_ctnt"        ) = formObj.frm_if_ctnt       .value;
		sheetObj.CellValue(1, "if_snd_flg"     ) = formObj.frm_if_snd_flg    .value;			
	}
	
	
	/**
	 * Getting the character byte and limited the length
	 */
	function lea_getLenByByte(obj,toObj){
		if(!ComChkLenByByte(obj, 200)){
			ComShowMessage(ComGetMsg("COM12142",obj.desc,"200"));
			return false;
		}
		toObj.value = ComGetLenByByte(obj.value);

	}

	
	/**
	 * Checking whether the input field in the page is included the parameter or not.
	 */
	function lea_validParameterValue(obj){
		if(obj.value == "" || obj.value == null) return false;
		var str = obj.value;
		var buff = str.split("$");
		if(buff.length > 0){
			for(i=1; i<buff.length; i++) {
				if(buff[i].indexOf("FROM") < 0 && buff[i].indexOf("TO") < 0 && 
						buff[i].indexOf("EXE_YRMON") < 0 && buff[i].indexOf("ST_TM"   ) < 0 &&  
						buff[i].indexOf("END_TM"   ) < 0 && buff[i].indexOf("WRK_FLAG") < 0  ){
					ComShowMessage(ComGetMsg("LEA90005"));
					obj.focus();
					return false;
				}
			}
		}
		return true;	
	}

