/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_TES_9001.js
*@FileTitle : B/L Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
*2014-06-19 : 박재흥 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_TES_9001 : business script for ESD_TES_9001 
     */
    function ESD_TES_9001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    
	// Common global variable 
	
	var sheetObjects = new Array();
	var sheetObjectsMap = new Array();
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
	
    var intervalId = "";
	var rtnValue = "";
       
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheetObj){

    	sheetObjects[sheetCnt++] = sheetObj;
    	sheetObjectsMap[sheetObj.id]= sheetObj;
    }
    
    /**
     * registering IBCombo Object as list
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }
    
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */                    
    function loadPage() {
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
	      //initializing MultiCombo 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
//		ComBtnDisable("btn_Inquiry");
//		ComBtnDisable("btn_Transmit");
//		
		initControl();
		
		//PUSBB
//		form.yd_cd.value    ='THBKKMP';
//		form.vndr_seq.value ='167780';

		tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');  //alert("tes_getInputValue");
		doActionIBSheet(sheetObjectsMap['costcode'],formObj,IBSEARCH);
	}
    /** set common code
     * 
     * @return
     */
    function setCommonCode(){//alert("start setCommonCode");

		var formObj = document.form;
		var tmp;
		if (formObj.tmp_common_code.value!=undefined && formObj.tmp_common_code.value!=null && formObj.tmp_common_code.value.trim()!=''){
			tmp = formObj.tmp_common_code.value.split('--');
			if (tmp.length > 0){
				for (var i=0; i<tmp.length; i++){
					tmp[i] = (tmp[i]!=undefined&&tmp[i]!=null?tmp[i]:'');
				}
				
				var CNTR_TPSZ_CD		= tmp[0];
				//MT_A_LGS_COST_CD	= tmp[1];
				//CARR_CD             = tmp[6];
				
				tmp = CNTR_TPSZ_CD.split('|');
				for (var i=0; i<tmp.length; i++){
					addTpszList(tmp[i],tmp[i]);
				}
				
			}//end if tmp.length
		}//end if
	}//end function    
    
    function addTpszList(code,text)	{
            var oOption = document.createElement("OPTION");
            	oOption.value = code;
    		    oOption.text  = text;
    		    form.cntr_tpsz_cd.add(oOption);
    }
    
     function initControl() {
     	var formObject = document.form;

         axon_event.addListenerFormat('keypress','on_keypress',formObject); //
         axon_event.addListenerForm  ('blur', 'on_blur',  formObject); //     
         axon_event.addListenerFormat('focus', 'on_focus',    formObject); //
         axon_event.addListener (     'keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ( 'change', 'on_change', formObject);
     }

 	/**
  	 *  initializing Combo
 	* @param {object} combo
 	* @param {String} comboId
  	 */ 
  	function initCombo(comboObj, comboId) {
  	    var formObject = document.form
 			initComboEditable(comboObj, comboId)
  	}
  	
 	
 	/** 
 	* setting combo function
 	* @param {object} combo
 	* @param {String} comboId 
 	*/ 
  	
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "cost_code_combo" ){
	 			MultiSelect = false;
	 			UseEdit = false;
	 			BackColor = "#CCFFFD";
	 		}
 		}
 	} 	
/*********************** KEY EVENT START ********************/ 	 
	function on_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //capital English
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //capital English 
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //number
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        //English,number,blank,etc.
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  

	
	/**
     * onBlur event
     **/
    function on_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_vvd_cd":
				break;
				
			default:
				break;
	    }
    }           

    /**
     * form input filed change event
     * 
     * @return
     */
    function bkg_change(){
    	
	    switch (event.srcElement.getAttribute("name")) {
			default:
				break;
	    }
    }
    
   
	/**
	 * checking validation on onFocus event
	 **/
	function on_focus(){
		switch(event.srcElement.name){	
	    	case "from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}       
	
	
	function sheet1_OnAfterEdit(sheetObj, row, col) {
    	var sName = sheetObj.ColSaveName(col);
    	var temp =0;
    	
    	if(sName == "portion") {
			var strVal = sheetObj.CellValue(row, "portion");
			
			if(!ComIsNumber(strVal,'/')){
				strVal.value = '';
			}
			
			if(strVal.indexOf("/")>=0){
				if(strVal.substring(strVal.indexOf("/")+1, strVal.length) != ""){
					temp = parseInt(strVal.substring(0, strVal.indexOf("/"))) / parseInt(strVal.substring(strVal.indexOf("/")+1, strVal.length))*100;
					temp = ComRound(temp, 2);
					
					sheetObj.CellValue(row, "portion") = temp;
					
				}else{
					sheetObj.CellValue(row, "portion")  = ComReplaceStr(strVal, "/", "");
				}
				
			}else{
				sheetObj.CellValue(row, "portion") = ComRound(sheetObj.CellValue(row, "portion"), 2);
			}
			
    	}//end if(sName == "portion") {
    }	
	
	function CheckTor() {    
		var url_str = 'ESD_TES_9500.screen';
		url_str += '?yd_cd='+document.form.yd_cd.value;
		url_str += '&yd_nm='+document.form.yd_nm.value;
		url_str += '&vvd='+document.form.vvd.value;
		url_str += '&atb_dt='+document.form.atb_dt.value;
		rtnValue  =  window.showModalDialog(url_str, window, "dialogWidth:790px; dialogHeight:250px; help:no; status:no; resizable:yes;");
		 
}	
	
	/**
	 * Trans Type COMBO event 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function cost_code_combo_OnChange(comboObj, value, text){
		
//		form.p_pod_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',text),"eu_1st_port_yd_cd");
//		form.p_search_pofe_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',text),"search_eu_1st_port_yd_cd");
//		form.p_pod_yard_temp.value = form.p_pod_yard_cd.value.substring(5);
//		if(sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',text),"edi_mrn") != "" ){
//			form.p_ori_amd_cd[1].checked = true;
//		}
		var sheetObj = sheetObjectsMap['costcode'];
		var rowIndex = sheetObj.FindText('cost_code',text);
		
		if(rowIndex >= 0){
			form.cost_code.value       = text;
			form.agmt_ofc_cty_cd.value = sheetObj.CellValue(rowIndex,'agmt_ofc_cty_cd');
			form.agmt_seq       .value = sheetObj.CellValue(rowIndex,'agmt_seq');
			form.agmt_ver_no    .value = sheetObj.CellValue(rowIndex,'agmt_ver_no');
			form.tml_trns_mod_cd.value = sheetObj.CellValue(rowIndex,'tml_trns_mod_cd');
			doActionIBSheet(sheetObjectsMap['sheet1'],document.form,SEARCH01);

			//20140609 
            if(text== 'SVXXHC' && form.cost_cd_inv_tp_cd.value=="MT"){
                 CheckTor();
                 if(rtnValue!=null && rtnValue!="" && rtnValue!=undefined){
                	 for(var i=1; i<= sheetObjects[0].RowCount; i++){
                		 sheetObjects[0].CellValue(i, 'calc_vol_qty') = rtnValue;	
                	 }
                	  
                 }
             }//end text ==        
			
		}
		
		//alert(FormQueryString(form));
	}       
	
	
	/**
	 * 
	 */
	function form_combo_onChange(obj){
		doActionIBSheet(sheetObjectsMap['sheet1'],document.form,SEARCH01);
	}


	    /**
	     * onClick event 
	     */
	    function sheet1_OnClick(sheetObj, row, col) {
	    	
	        var colSaveName = sheetObj.ColSaveName(col);
	        var check = sheetObj.CellValue(row,"sel");
	        var keySeq = sheetObj.CellValue(row,"dt_seq");
	        switch(colSaveName) { 
			       
	        } // end switch
	        
	    } 
	     
	     /**
	      * double click event : transition to Booking Creation screen
	      * @param sheetObj Sheet
	      * @param Row Row Index
	      * @param Col Col Index
	      */
	     function sheet1_OnDblClick(sheetObj, row, col) {
		        var colSaveName = sheetObj.ColSaveName(col);
		        
		        if(colSaveName != "calc_vol_qty" && colSaveName != "portion" && colSaveName != "inv_xch_rt"){
			        sheetObj.CellValue(row,"sel") = 1;
			        //(TargetSheet,[SrcColumns],[DestColumns],[StartRow ],[EndRow],[DestRow],[AddType],[useSameSaveName],[raiseChangeEvent],                                       [SrcCheckCol], [DestCheckCol])
			        //              ""전체,     "" 전체,        시작행,     종료행,   -1 제일뒤, 2 append   
			        sheetObj.Copy2SheetCol(sheetObjectsMap['select'],"","",row,row,-1,2);
			        // CHM-201640822 Semi Update Pop-Up BOX설정 변경(2가지 - DG All Defualt Item Multiple사용 가능)
				    //@ 체크 된거 삭제 처리
//			        sheetObj.CellValue(row,"sel") = 0;
//			        sheetObj.RowHidden(row) = true;
//			        sheetObj.RowStatus(row) = 'D';
//			        sheetObj.RowDelete(row,false);
		        }
	     }	 
	     /**
	 	 * 
	 	 * @param {ibsheet}		sheetObj
	 	 * @param {int,String}	row
	 	 * @param {int,String}	col
	 	 * @param {String}		Value
	 	 * @return
	 	 */
	     function sheet1_OnChange(sheetObj, row,col,value){
	    	 
	    	 var colSaveName = sheetObj.ColSaveName(col);
	    	 
	    	 if(colSaveName == "calc_vol_qty"){
	    		 sheetObj.CellValue2(row,"rvis_vol_qty") = value;
	    		 //@ Amount 재계산은 InitDataProperty CalcuLogic, 컬럼연산 |calc_vol_qty| * |ctrt_rt|
	    	 }
	     }	     
	     
	     /**
	      * event after retrieving >>> changing font color
	      */
	     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	         with (sheetObj) {
	         }//end width
	     }	
	     
	     function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
	     {
	          if(sheetObj.MouseCol == sheetObj.SaveNameCol("portion")){
	               //마우스 모양 설정하기
	//	           sheetObj.MousePointer = "Default";  //기본 화살표 모양
	               sheetObj.MousePointer = "Hand";     //손가락 모양
	               //풍선도움말 만들기
	           	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  =  "Input Percentage Formula like \"2/3\" or Percentage like \"75.12\"";
	          }

	     }	     
	     
	     /**
	      * event after retrieving >>> changing font color
	      */
	     function costcode_OnSearchEnd(sheetObj, ErrMsg) {
	         
	         with (sheetObj) {
	        	 //alert(RowCount);
	        	 if(RowCount > 0){
	        		 document.forms[0].agmt_no.value      = CellValue(HeaderRows ,'agmt_ofc_cty_cd')+CellValue(HeaderRows ,'agmt_seq');
	        		 document.forms[0].agmt_version.value = CellValue(HeaderRows ,'agmt_ver_no');
	        		 document.forms[0].eff_fm_dt.value    = CellValue(HeaderRows ,'eff_fm_dt');
	        		 document.forms[0].eff_to_dt.value    = CellValue(HeaderRows ,'eff_to_dt');
	        		 document.forms[0].ctrt_ofc_cd.value  = CellValue(HeaderRows ,'ctrt_ofc_cd');
	        		 document.forms[0].cre_ofc_cd.value   = CellValue(HeaderRows ,'cre_ofc_cd');
	        		 document.forms[0].cre_dt.value       = CellValue(HeaderRows ,'cre_dt');
	        		 document.forms[0].upd_dt.value       = CellValue(HeaderRows ,'upd_dt');
	        		 
	        	 }
	         }//end width
	         
	     }	    	     
	     
	     /**
	      * returning value according to cellValue
	      * @param String cellValue
	      * return boolean 
	      */
	     function isError(cellValue) {
		    if(cellValue == "E") return true;
		    
	     	return false;
	     }		
	     
	    
 	// Event handler processing by button click event */
 	document.onclick = processButtonClick;
 	
 	// Event handler processing by button name */
     function processButtonClick(){
     	
          /* */
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	//try {
     		var srcName = window.event.srcElement.getAttribute("name");
                                            
            switch(srcName) {
 				case "btn_AddItem":
                    if (sheetObjectsMap['sheet1'].CheckedRows("sel") < 1) {
                        ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                        return;
                    }
 					var queryStr = '';
 			        queryStr = sheetObjectsMap['sheet1'].GetSaveString(false, false, 'sel');
 			        //alert(queryStr);
 			        tes_copy_rows_to2(sheetObjectsMap['select'], queryStr, true);
 			        
 			        // CHM-201640822 Semi Update Pop-Up BOX설정 변경(2가지 - DG All Defualt Item Multiple사용 가능)
 			        //@ 체크 된거 삭제 처리
// 			       ComRowDeleteComplete(sheetObjectsMap['sheet1'], "sel", 1);
 					break;
 				case "btn_Delete":
 					//@ 체크 된거 삭제 처리
 					ComRowDeleteComplete(sheetObjectsMap['select'], "sel", 1);
 					break;
 				case "btn_SelectItems":
                    eval("window.dialogArguments." + sFunc + "(sheetObjectsMap['select'])");    // JSP에서 request.getParameter로 받은 param
                    window.close();
 					break;
 				case "btn_RiderPrint":
 					ComShowMessage("준비중입니다");
 					break;
 				case "btn_RtvReceipt":
 					ComShowMessage("준비중입니다");
 					break;
 				case "btn_RtvCntrFrt":
 					ComShowMessage("준비중입니다");
 					break;
             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
     }

    /**
     * handling process for Sheet<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case IBSEARCH : // 
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Redraw = false;
				sheetObj.WaitImageVisible = true;
				
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				var sXml =  sheetObj.GetSearchXml("ESD_TES_9001GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.cost_code_combo, "cost_code", "cost_code");
				sheetObj.LoadSearchXml(sXml);
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				break;
			case SEARCH01: // 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH01;
				var sXml =  sheetObj.GetSearchXml("ESD_TES_9001GS.do", FormQueryString(formObj));
				
				sheetObj.LoadSearchXml(sXml);
				
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				break;
        }//end switch(sAction) {
    }
    

     /**
      * BackEndJob : retrieve<br>
      * 
      * @param sheetObj
      * @param sKey
      */
     function doActionValidationResult(sheetObj, sKey) {

     }
    
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    	case IBSEARCH:
	    		if (!ComChkValid(formObj)) return false;
//	    		
//    			if (ComIsNull(formObj.vvd_cd)) {
//    				ComShowCodeMessage('BKG00104','VVD');
// 					formObj.vvd_cd.focus();
// 					return false;    
//    			}
	    	case SEARCH01:
    			if (ComIsNull(formObj.cost_code_combo.Code)) {
    				ComShowCodeMessage('TES21602');
 					formObj.cost_code_combo.focus();
 					return false;    
    			}
    			
	    }//end switch
	    
        return true;

    }
    
    /**
     * when inputting search condition
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
    }
    
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
		var amount_formula = "";
		var calcVolDataType ;
		var rvisVolDataType ;
		var stayDaysDataType;

		if(prgm_id == "ESD_TES_0001"||prgm_id =="ESD_TES_0004_1"||prgm_id =="ESD_TES_0064"){
			amount_formula = "|calc_vol_qty| * |ctrt_rt| * (|portion|/100) * |inv_xch_rt|";
            calcVolDataType  = dtData;
            rvisVolDataType  = dtData;
            stayDaysDataType = dtHidden;
		}else{
			amount_formula = "|stay_days| * |ctrt_rt|";
			calcVolDataType  = dtHidden;
			rvisVolDataType  = dtHidden;
			stayDaysDataType = dtData;
		}
		
		switch(sheetID) {
			
			case "sheet1":
                with (sheetObj) {
					 // setting width
	                SheetWidth = mainTable.clientWidth;
	
	                //setting Host information[mandatory][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //Kind of Merge [Option, Default msNone]
	                MergeSheet = msNone;
	
	               //Edit [Option, Default false]
	                Editable = true;
	
	                var HeadTitle = "status||Seq|Calculation Type|"
	     				+ "Cost Code|TP/\nSZ |I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|"
	     				+ "Vol.Tier|Calculated\nVol.|Revised\n Vol.|Stay Days|UOM|Rate|Exch.\n Rate|Amount|Portion\n(%)|AGMT\nCurr.|AGMT DTL RMK|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|vol_rt_chk_flg|vol_dup_chk_flg|rmk_chk_flg";
	                
	                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 9, 100);
	
	                var headCount = ComCountHeadTitle(HeadTitle);
					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
	                //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                //Data attribute  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	
	                InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  false, "ibflag");
	                InitDataProperty(0, cnt++,  dtCheckBox,    20,    daCenter,  true,  "sel",             false,    "",          dfNone,     0,         true,   false);
	                InitDataProperty(0, cnt++ , dtSeq,         30,    daCenter,  false, "seq",             false,    "",          dfNone,     0,         false,  false);
	                                                                                                                                                     
	                InitDataProperty(0, cnt++ , dtHidden,      40,    daCenter,  false, "calc_tp_cd",      false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtHidden,      70,    daCenter,  false, "lgs_cost_cd",     false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "cntr_tpsz_cd",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "io_bnd_cd",       false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "dcgo_ind_cd",     false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtHidden,      70,    daCenter,  false, "rc_flg",          false,    "",          dfNone,     0,         false, false);                
	                InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false, "tml_wrk_dy_cd",   false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "ioc_cd",          false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "tml_trns_mod_cd", false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "lane_cd",         false,    "",          dfNone,     0,         false, false);
	                                                                                                                                                     
	                InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false, "tier",            false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , calcVolDataType,70,   daRight,   false, "calc_vol_qty",    false,    "",          dfNone,     0,         true,  true);
	                InitDataProperty(0, cnt++ , rvisVolDataType,70,   daRight,   false, "rvis_vol_qty",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , stayDaysDataType,70,  daRight,   false, "stay_days",       false,    "",          dfNone,     0,         true,  true);
	                InitDataProperty(0, cnt++ , dtData,        35,    daCenter,  false, "vol_tr_ut_cd",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daRight,   false, "ctrt_rt",         false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        60,    daRight,   false, "inv_xch_rt",      false,    "",          dfFloat,    5,         true, true, 15);
	                InitDataProperty(0, cnt++ , dtData,        60,    daRight,   false, "inv_amt",         false, amount_formula, dfFloat,    2,         true, true);  
	                InitDataProperty(0, cnt++ , dtData,        60,    daRight,   false, "portion",         false,    "",          dfNone,  0,         true, true, 7);  
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "curr_cd",         false,    "",          dfNone,     0,         false, false);                
	                InitDataProperty(0, cnt++, dtData,		220,	daCenter,		false, "agmt_dtl_rmk",				false, "",	dfNone,	0,	false,	false);

	                // 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_ofc_cty_cd",		false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_seq",				false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_ver_no",			false, "",	dfNone,	0,	false,	false);
	                
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "vol_rt_chk_flg",			false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "vol_dup_chk_flg",			false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "rmk_chk_flg",				false, "",	dfNone,	0,	false,	false);
	                
	                style.height = GetSheetHeight(8) ;
	                CountFormat = "[SELECTDATAROW / ROWCOUNT]";
	                ToolTipOption = "balloon:true; width:320; backcolor:#ffffff; forecolor:#14358B; icon:0;";
	                
				}//end with (sheetObj) {
				break;
			case "select":
				with (sheetObj) {
	                // setting width
	                SheetWidth = mainTable.clientWidth;
	
	                //setting Host information[mandatory][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //Kind of Merge [Option, Default msNone]
	                MergeSheet = msNone;
	
	               //Edit [Option, Default false]
	                Editable = true;
	
	                var HeadTitle = "status||Seq|Calculation Type|"
	     				+ "Cost Code|TP/\nSZ |I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|"
	     				+ "Vol.Tier|Calculated\nVol.|Revised\n Vol.|Stay Days|UOM|Rate|exch. rate|Amount|portion|AGMT\nCurr.|AGMT DTL RMK|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|vol_rt_chk_flg|vol_dup_chk_flg|rmk_chk_flg";
	                
	                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 9, 100);
	
	                var headCount = ComCountHeadTitle(HeadTitle);
					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
	                //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	                //Data attribute  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	
	                InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  false, "ibflag");
	                InitDataProperty(0, cnt++,  dtCheckBox,    20,    daCenter,  true,  "sel",             false,    "",          dfNone,     0,         true,   false);
	                InitDataProperty(0, cnt++ , dtSeq,         30,    daCenter,  false, "seq",             false,    "",          dfNone,     0,         false,  false);
	                                                                                                                                                     
	                InitDataProperty(0, cnt++ , dtHidden,      40,    daCenter,  false, "calc_tp_cd",      false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtHidden,      70,    daCenter,  false, "lgs_cost_cd",     false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "cntr_tpsz_cd",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "io_bnd_cd",       false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "dcgo_ind_cd",     false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtHidden,      70,    daCenter,  false, "rc_flg",          false,    "",          dfNone,     0,         false, false);                
	                InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false, "tml_wrk_dy_cd",   false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "ioc_cd",          false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "tml_trns_mod_cd", false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "lane_cd",         false,    "",          dfNone,     0,         false, false);
	                                                                                                                                                     
	                InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false, "tier",            false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ ,calcVolDataType,70,    daRight,   false, "calc_vol_qty",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ ,rvisVolDataType,70,    daRight,   false, "rvis_vol_qty",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ ,stayDaysDataType,70,   daRight,   false, "stay_days",       false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        35,    daCenter,  false, "vol_tr_ut_cd",    false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtData,        40,    daRight,   false, "ctrt_rt",         false,    "",          dfNone,     0,         false, false);
	                InitDataProperty(0, cnt++ , dtHidden,      60,    daRight,   false, "inv_xch_rt",      false,    "",          dfFloat,    5,         true, true, 15);
	                InitDataProperty(0, cnt++ , dtData,        60,    daRight,   false, "inv_amt",         false,    "",          dfFloat,    2,         true, true);
	                InitDataProperty(0, cnt++ , dtHidden,      60,    daRight,   false, "portion",         false,    "",          dfInteger,  0,         true, true, 7); 
	                InitDataProperty(0, cnt++ , dtData,        40,    daCenter,  false, "curr_cd",         false,    "",          dfNone,     0,         false, false);                
	                // 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
	                InitDataProperty(0, cnt++, dtHidden,		220,	daCenter,		false, "agmt_dtl_rmk",				false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_ofc_cty_cd",		false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_seq",				false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "tml_agmt_ver_no",			false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "vol_rt_chk_flg",			false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "vol_dup_chk_flg",			false, "",	dfNone,	0,	false,	false);
	                InitDataProperty(0, cnt++, dtHidden,		70,		daCenter,		false, "rmk_chk_flg",				false, "",	dfNone,	0,	false,	false);
	
	                style.height = GetSheetHeight(5) ;
	                CountFormat = "[SELECTDATAROW / ROWCOUNT]";
	
				}//end with (sheetObj)
				break;
			case "costcode":
				with (sheetObj) {
				// setting width
				SheetWidth = mainTable.clientWidth;
				
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//Kind of Merge [Option, Default msNone]
				MergeSheet = msAll;
				
				//Edit [Option, Default false]
				Editable = true;
				
				var HeadTitle = "cost_code|agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|tml_trns_mod_cd|eff_fm_dt|eff_to_dt|ctrt_ofc_cd|cre_ofc_cd|cre_dt|upd_dt";
				
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);
				
				var headCount = ComCountHeadTitle(HeadTitle);
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				//Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//Data attribute  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "cost_code" ,       false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "agmt_ofc_cty_cd" , false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "agmt_seq" ,        false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "agmt_ver_no" ,      false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "tml_trns_mod_cd" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "eff_fm_dt" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "eff_to_dt" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "ctrt_ofc_cd" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "cre_ofc_cd" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "cre_dt" , false,          "",       dfNone,    0,     false,       false);              
				InitDataProperty(0, cnt++ , dtData ,    100,    daCenter,  false,    "upd_dt" , false,          "",       dfNone,    0,     false,       false);              
				
				style.height = GetSheetHeight(3) ;
				
			}//end with (sheetObj)
				break;
			
		}//end switch
		
 	}     
	
     