/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9001.js
*@FileTitle  : B/L Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	// Common global variable 
	var sheetObjects=new Array();
	var sheetObjectsMap=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var intervalId="";
    var rtnValue="";
    
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheetObj){
    	sheetObjects[sheetCnt++]=sheetObj;
    	sheetObjectsMap[sheetObj.id]=sheetObj;
    }
    
    /**
     * registering IBCombo Object as list
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj; 
    }
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */                    
    function loadPage() {
    	var formObj=document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	//initializing MultiCombo 
    	for(var k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k],comboObjects[k].id);
    	}
    	//	ComBtnDisable("btn_Inquiry");
    	//ComBtnDisable("btn_Transmit");
    	//
    	initControl();
    	//	PUSBB
    	//document.form.yd_cd.value    ='THBKKMP';
    	//document.form.vndr_seq.value ='167780';
    	tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');  //alert("tes_getInputValue");
    	doActionIBSheet(sheetObjectsMap['costcode'],formObj,IBSEARCH);
		if(formObj.cost_cd_inv_tp_cd.value=="SE" || formObj.cost_cd_inv_tp_cd.value=="OE"){
			formObj.dcgo_ind_cd.disabled=true;
		}else{
			formObj.dcgo_ind_cd.disabled=false;
		}
    }
    
    /** set common code
     * 
     * @return
     */
    function setCommonCode(){//alert("start setCommonCode");
    	var formObj=document.form;
    	var tmp;
    	var CNTR_TPSZ_CD;
    	if (formObj.tmp_common_code.value!=undefined && formObj.tmp_common_code.value!=null && formObj.tmp_common_code.value.trim()!=''){
    		tmp=formObj.tmp_common_code.value.split('--');
    		if (tmp.length > 0){
    			for (var i=0; i<tmp.length; i++){
    				tmp[i]=(tmp[i]!=undefined&&tmp[i]!=null?tmp[i]:'');
    			}
    			
    			if(formObj.cost_cd_inv_tp_cd.value=="SE" || formObj.cost_cd_inv_tp_cd.value=="OE"){
    				CNTR_TPSZ_CD=tmp[7];
    			}else{
    				CNTR_TPSZ_CD=tmp[0];	
    			}
    			
    			tmp=CNTR_TPSZ_CD.split('|');
    			for (var i=0; i<tmp.length; i++){
    				addTpszList(tmp[i],tmp[i]);
    			}
    		}//end if tmp.length
    	}//end if
    }//end function
    
    function addTpszList(code,text){
    	var oOption=document.createElement("OPTION");
        oOption.value=code;
        oOption.text=text;
        document.form.cntr_tpsz_cd.add(oOption);
    }
    
    function initControl() {
    	var formObject=document.form;
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
    	var formObject=document.form
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
    			SetMultiSelect(0);
    			SetUseEdit(0);
    			SetBackColor("#CCFFFD");
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
    	var formObj=document.form;    
    	switch (ComGetEvent("name")) {
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
    	switch (ComGetEvent("name")) {
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
    	var sName=sheetObj.ColSaveName(col);
    	var temp=0;
    	if(sName == "portion") {
    		var strVal=sheetObj.GetCellValue(row, "portion");
    		if(!ComIsNumber(strVal,'/')){
    			strVal.value='';
    		}
    		if(strVal.indexOf("/")>=0){
    			if(strVal.substring(strVal.indexOf("/")+1, strVal.length) != ""){
    				temp=parseInt(strVal.substring(0, strVal.indexOf("/"))) / parseInt(strVal.substring(strVal.indexOf("/")+1, strVal.length))*100;
    				temp=ComRound(temp, 2);
    				sheetObj.SetCellValue(row, "portion",temp);
    			}else{
    				sheetObj.SetCellValue(row, "portion",ComReplaceStr(strVal, "/", ""));
    			}
    		}else{
    			sheetObj.SetCellValue(row, "portion",ComRound(sheetObj.GetCellValue(row, "portion"), 2));
    		}
    	}//end if(sName == "portion") {
    }
    
    
	/**
	 * Trans Type COMBO event 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function cost_code_combo_OnChange(obj, oldindex, oldtext, oldcode , newindex, newtext , newcode){
		
		var sheetObj=sheetObjectsMap['costcode'];
		var rowIndex=sheetObj.FindText('cost_code', newtext);
		if(rowIndex >= 0){
			//2016.12.28 Add
			if(!getCheckYardCost(newtext)){
			    //old 값으로 다시 변경해 준다.
			    if(ComIsEmpty(oldcode)){
			        cost_code_combo.SetSelectIndex(-1, 0);
			    }else{
			        cost_code_combo.SetSelectIndex(oldindex, 0);
			    }
			    return;
			}

            document.form.cost_code.value=newtext;
			
			document.form.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(rowIndex,'agmt_ofc_cty_cd');
			document.form.agmt_seq       .value=sheetObj.GetCellValue(rowIndex,'agmt_seq');
			document.form.agmt_ver_no    .value=sheetObj.GetCellValue(rowIndex,'agmt_ver_no');
			document.form.tml_trns_mod_cd.value=sheetObj.GetCellValue(rowIndex,'tml_trns_mod_cd');
			doActionIBSheet(sheetObjectsMap['sheet1'],document.form, SEARCH01);
     
		}
		//alert(FormQueryString(document.form));
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
		var colSaveName=sheetObj.ColSaveName(col);
		var check=sheetObj.GetCellValue(row,"sel");
		var keySeq=sheetObj.GetCellValue(row,"dt_seq");
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

		var colSaveName=sheetObj.ColSaveName(col);
		if(colSaveName != "calc_vol_qty" && colSaveName != "portion" && colSaveName != "inv_xch_rt"){
		
			sheetObj.SetCellValue(row,"sel",1);
			//(TargetSheet,[SrcColumns],[DestColumns],[StartRow ],[EndRow],[DestRow],[AddType],[useSameSaveName],[raiseChangeEvent],                                       [SrcCheckCol], [DestCheckCol])
			//              ""전체,     "" 전체,        시작행,     종료행,   -1 제일뒤, 2 append   
			sheetObj.Copy2SheetCol(sheetObjectsMap['select'],"","",row,row,-1,2, false, false);
			
			
			//@ 체크 된거 삭제 처리
			sheetObj.SetCellValue(row,"sel",0);
			sheetObj.SetRowHidden(row,1);
			sheetObj.SetRowStatus(row,'D');
			sheetObj.RowDelete(row,false);
		}

//		var colSaveName=sheetObj.ColSaveName(col);
//		if(colSaveName != "calc_vol_qty" && colSaveName != "portion" && colSaveName != "inv_xch_rt"){
//			
//			sheetObj.SetCellValue(row, "sel", 1);
//			
//			// "sheet1"에서 선택한 Row를 "select"에 복사처리한다. 	
//			var queryStr='';
//	        queryStr=sheetObj.GetSaveString(0, 1, 'sel');
//	        alert(queryStr);
//	        
//	        tes_copy_rows_to2(sheetObjectsMap['select'], queryStr, true);
//	        
//	        // "sheet1"에서 선택된 Row를 삭제 처리한다.
//	        sheetObj.RowDelete(row, 0);
//	        
//	        return;
//		}
	}
	
	/**
     * 
     * @param {ibsheet}sheetObj
     * @param {int,String}row
     * @param {int,String}col
     * @param {String}Value
     * @return
     */
     function sheet1_OnChange(sheetObj, row,col,value){
    	 var colSaveName=sheetObj.ColSaveName(col);
    	 if(colSaveName == "calc_vol_qty"){
    		 sheetObj.SetCellValue(row,"rvis_vol_qty",value,0);
    		 //@ Amount 재계산은 InitDataProperty CalcuLogic, 컬럼연산 |calc_vol_qty| * |ctrt_rt|
    	 }	
    	 
		if (colSaveName == "rvis_vol_qty" || colSaveName == "calc_vol_qty"
				|| colSaveName == "ctrt_rt" || colSaveName == "inv_xch_rt"
				|| colSaveName == "vol_tr_ut_cd") {
			sheetObj.SetCellValue(row, 'inv_xch_rt',Math.abs(sheetObj.GetCellValue( row, 'inv_xch_rt')));

			sheet1_RecalcCalcAmt(sheetObj, row);
		}    	
		
		if (colSaveName == "stay_days") {
			if (isNaN(sheetObj.GetCellValue(row, 'stay_days')) || parseInt(sheetObj.GetCellValue(row, 'stay_days'), 10) < 0) {
				sheetObj.SetCellValue(row, 'stay_days',0,0);
			}
		}		
     }    

 	function sheet1_RecalcCalcAmt(sheetObj, Row) {
		var sCurrCd = document.form.curr_cd.value;		
		
		if (sheetObj.RowCount()> 0) {
			if (sheetObj.GetCellValue(Row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(Row, 'calc_tp_cd') == 'S') {
				if (sheetObj.GetCellValue(Row, 'calc_vol_qty') != null
						&& sheetObj.GetCellValue(Row, 'calc_vol_qty') != ''
						&& !isNaN(sheetObj.GetCellValue(Row, 'calc_vol_qty'))
						&& sheetObj.GetCellValue(Row, 'ctrt_rt') != null
						&& sheetObj.GetCellValue(Row, 'ctrt_rt') != ''
						&& !isNaN(sheetObj.GetCellValue(Row, 'ctrt_rt'))) {
					if (sheetObj.GetCellValue(Row, 'rvis_vol_qty') != null
							&& sheetObj.GetCellValue(Row, 'rvis_vol_qty') != ''
							&& !isNaN(sheetObj.GetCellValue(Row, 'rvis_vol_qty'))
							&& sheetObj.GetCellValue(Row, 'rvis_vol_qty') > 0) {
						sheetObj.SetCellValue(Row, 'calc_vol_qty', sheetObj.GetCellValue(Row, 'rvis_vol_qty'));
					}
					
					var nInvAmt = (parseInt(sheetObj.GetCellValue(Row, 'calc_vol_qty'), 10) * parseFloat(sheetObj.GetCellValue(Row, 'ctrt_rt')));
        
//			        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
//			        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정			        	
//			        }
					
					sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
				}
				
				if (sheetObj.GetCellValue(Row, 'curr_cd') != undefined
						&& sheetObj.GetCellValue(Row, 'curr_cd') != null
						&& sheetObj.GetCellValue(Row, 'curr_cd') != ''
						&& !isNaN(sheetObj.GetCellValue(Row, 'inv_xch_rt'))
						&& parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt')) > 0) {
					
					var nInvAmt = tes_round(parseFloat(sheetObj.GetCellValue(Row, 'inv_amt'))* parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt')), 2);        			
        			
//			        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
//			        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정			        	
//			        }
			        
					sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
				}
			}

//			if ((sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != undefined
//					&& sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != null
//					&& sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != '')
//					&& (sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != undefined
//					&& sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != null
//					&& sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != '')) {
//						sheetObj.SetCellValue(Row, 'inv_amt',sheetObj.GetCellValue(Row,'inv_amt')* tes_getTEUconv(sheetObj.GetCellValue(Row, 'vol_tr_ut_cd'),sheetObj.GetCellValue(Row, 'cntr_tpsz_cd')));
//			}
		}
 	}     
     
     /**
      * event after retrieving >>> changing font color
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
             for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
             	if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='ALL'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','ALL');
     			    
             	}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='N'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','None');
     			    
             	}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='AN'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Same No DG');
     			    
             	}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='AS'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Same DG');
     			    
             	}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='SN'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.No DG');
     			    
             	}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='1'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.1');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='2'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.2');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='3'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.3');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='4'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.4');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='5'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.5');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='6'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.6');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='7'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.7');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='8'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.8');
     			    
     			}else if(sheetObj.GetCellValue(i,'dcgo_ind_cd')=='9'){
     			    sheetObj.SetToolTipText(i,'dcgo_ind_cd','Sep.9');
     			    
     			}
             }        	 
         }//end width
     }
     
     function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos) {
    	 if(sheetObj.MouseCol()== sheetObj.SaveNameCol("portion")){
    		 //마우스 모양 설정하기
    		 //sheetObj.MousePointer = "Default";  //기본 화살표 모양
    		 sheetObj.SetMousePointer("Hand");//손가락 모양
    		 //풍선도움말 만들기
    		 sheetObj.SetToolTipText(sheetObj.MouseRow(),sheetObj.MouseCol(),"Input Percentage Formula like \"2/3\" or Percentage like \"75.12\"");
    	 }
     }
     
     /**
      * event after retrieving >>> changing font color
      */
     function costcode_OnSearchEnd(sheetObj, ErrMsg) {
    	 with (sheetObj) {
    		 //alert(RowCount);
    		 if(RowCount()> 0){
    			 document.forms[0].agmt_no.value=GetCellValue(HeaderRows(),'agmt_ofc_cty_cd')+GetCellValue(HeaderRows(),'agmt_seq');
    			 document.forms[0].agmt_version.value=GetCellValue(HeaderRows(),'agmt_ver_no');
    			 document.forms[0].eff_fm_dt.value=GetCellValue(HeaderRows(),'eff_fm_dt');
    			 document.forms[0].eff_to_dt.value=GetCellValue(HeaderRows(),'eff_to_dt');
    			 document.forms[0].ctrt_ofc_cd.value=GetCellValue(HeaderRows(),'ctrt_ofc_cd');
    			 document.forms[0].cre_ofc_cd.value=GetCellValue(HeaderRows(),'cre_ofc_cd');
    			 document.forms[0].cre_dt.value=GetCellValue(HeaderRows(),'cre_dt');
    			 document.forms[0].upd_dt.value=GetCellValue(HeaderRows(),'upd_dt');
    		 }
    	 }//end width
     }
     
     /**
      * returning value according to cellValue
      * @param String cellValue
      * return boolean 
      */
     function isError(cellValue) {
    	 if(cellValue == "E") {
    		 return true;    		 
    	 }
    	 return false;
     }
     
     // Event handler processing by button click event */
     document.onclick=processButtonClick;
     
     // Event handler processing by button name */
     function processButtonClick(){
    	 /* */
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         //try {
         var srcName=ComGetEvent("name");
         switch(srcName) {
			case "btn_AddItem":
				
				var checkedRows = sheetObjectsMap['sheet1'].FindCheckedRow("sel");

				if(checkedRows == "") {
					ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
					return;
				}
				// "sheet1"에서 선택한 Row를 "select"에 복사처리한다. 	
				var queryStr='';
		        queryStr=sheetObjectsMap['sheet1'].GetSaveString(0, 1, 'sel');
		        
		        tes_copy_rows_to2(sheetObjectsMap['select'], queryStr, true);
		        
		        // "sheet1"에서 선택된 Row를 삭제 처리한다.
		        sheetObjectsMap['sheet1'].RowDelete(checkedRows, 0);
		        
				break;
			case "btn_Delete":
				// sheet의 비교대상의 key 값
				var strRowKeyValue = "";
				// sheet의 삭제할 rowIndex
				var deleteRowIndex = "";
				
				// 재조회
				doActionIBSheet(sheetObjectsMap['sheet1'],document.form, SEARCH01);
				
				// 체크된 rowIndex취득(ex> "1|2|3")
				var checkedRows = sheetObjectsMap['select'].FindCheckedRow("sel");
				
				if(checkedRows != "") {
			        
		        	for(var i=sheetObjectsMap['select'].HeaderRows(); i<sheetObjectsMap['select'].HeaderRows() + sheetObjectsMap['select'].RowCount(); i++){
		        		// check가 false인 row 검색
		        		if(!sheetObjectsMap['select'].GetCellValue(i,"sel")) {
		        			// 키값취득
		        			strRowKeyValue = sheetObjectsMap['select'].GetCellValue(i,"cntr_tpsz_cd");
		        			// 키값의 rowIndex 취득
		        			deleteRowIndex = sheetObjectsMap['sheet1'].FindText("cntr_tpsz_cd", strRowKeyValue);
		        			// 해당row의 삭제.
		        			sheetObjectsMap['sheet1'].RowDelete(deleteRowIndex, 0);
		        		}
		            }
					// "select"에서 선택된 Row를 삭제 처리한다.					
			        sheetObjectsMap['select'].RowDelete(checkedRows, 0);
				}		        
				
				break;
         	case "btn_SelectItems":
         		
         		var opener= window.dialogArguments;     
         		if (!opener)  opener=window.opener;  //이 코드 추가할것         		
                if (!opener) opener="parent."; //이 코드 추가할것                
                eval(opener + sFunc + "(sheetObjectsMap['select'])");    // JSP에서 request.getParameter로 받은 param
                
         		ComClosePopup();
         		
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
         //     }catch(e) {
         //     if( e == "[object Error]") {
         //     ComShowMessage(OBJECT_ERROR);
         //     } else {
         //     ComShowMessage(e);
         //     }
         //     }
     }
     
    /**
     * handling process for Sheet<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH : // 
        		//if(!validateForm(sheetObj,formObj,sAction)) return;
//        		sheetObj.RenderSheet(0);
//        		sheetObj.SetWaitImageVisible(1);
        		//sheetObj.RemoveAll();
        		formObj.f_cmd.value=SEARCH;
        		//	parameter changed[check again]CLT 
        		var sXml=sheetObj.GetSearchData("ESD_TES_9001GS.do", FormQueryString(formObj));        		
        		ComXml2ComboItem(sXml, cost_code_combo, "cost_code", "cost_code");
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
//        		sheetObj.RenderSheet(1);
//        		sheetObj.SetWaitImageVisible(0);
        		break;
        	case SEARCH01: //  
        		if(!validateForm(sheetObj,formObj,sAction)) return;  
//        		sheetObj.RenderSheet(0);
//        		sheetObj.SetWaitImageVisible(1);
        		//sheetObj.RemoveAll();
        		formObj.f_cmd.value=SEARCH01;
        		//parameter changed[check again]CLT 
        		var sXml=sheetObj.GetSearchData("ESD_TES_9001GS.do", FormQueryString(formObj));
        		sheetObj.LoadSearchData(sXml,{Sync:1} );
//        		sheetObj.RenderSheet(1);
//        		sheetObj.SetWaitImageVisible(0);
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
    		//    if (ComIsNull(formObj.vvd_cd)) {
    		//    ComShowCodeMessage('BKG00104','VVD');
    		// formObj.vvd_cd.focus();
    		// return false;    
    		//    }
    	case SEARCH01:
    		if (ComIsNull(cost_code_combo.GetSelectCode())) {
    			ComShowCodeMessage('TES21602');
    			cost_code_combo.Focus();
    			return false;    
    		}
    	}//end switch
        return true;
    }
    
    /**
     * when inputting search condition
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
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
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	var amount_formula="";
    	var calcVolDataType ;
    	var rvisVolDataType ;
    	var stayDaysDataType;
    	var sCurrCd = document.form.curr_cd.value;
    	
    	if(prgm_id == "ESD_TES_0001"||prgm_id =="ESD_TES_0004_1"||prgm_id =="ESD_TES_0004_2"||prgm_id =="ESD_TES_0004_3"||prgm_id =="ESD_TES_0009"||prgm_id =="ESD_TES_0064"){
    		
//			if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
//	        	amount_formula="Math.round(tes_round(|calc_vol_qty| * |ctrt_rt| * (|portion|/100) * |inv_xch_rt|,2))";  //2016-05-16 수정			        	
//	        } else {
	        	amount_formula="tes_round(|calc_vol_qty| * |ctrt_rt| * (|portion|/100) * |inv_xch_rt|,2)";
//	        }	
    		
    		
    		if(prgm_id =="ESD_TES_0004_2"||prgm_id =="ESD_TES_0004_3"||prgm_id =="ESD_TES_0009"){
//    			if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
//    				amount_formula="Math.round(tes_round(|calc_vol_qty| * |ctrt_rt| * (|portion|/100) * |inv_xch_rt|*|stay_days|,2))";
//    			} else {
    				amount_formula="tes_round(|calc_vol_qty| * |ctrt_rt| * (|portion|/100) * |inv_xch_rt|*|stay_days|,2)";
//    			}
    		}
    		
    		calcVolDataType=dtData;
    		rvisVolDataType=dtData;
    		stayDaysDataType=dtHidden;
    	} else {
//    		if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
//    			amount_formula="Math.round(|stay_days| * |ctrt_rt| * |calc_vol_qty|)";
//    		} else {
    			amount_formula="|stay_days| * |ctrt_rt| * |calc_vol_qty|";
//    		}
    		calcVolDataType=dtHidden;
    		rvisVolDataType=dtHidden;
    		stayDaysDataType=dtData;
    	}
    	
    	switch(sheetID) {
    		case "sheet1":
    			with(sheetObj){
                //no support[check again]CLT 	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    			var HeadTitle="status||Seq|Calculation Type|"
    						+ "Cost Code|TP/\nSZ |I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|Sub Trade|"
    						+ "Vol.Tier|Calculated\nVol.|Revised\n Vol.|Stay Days|UOM|Rate|Exch.\n Rate|Amount|Portion\n(%)|AGMT\nCurr.|AGMT DTL RMK";
    			var headCount=ComCountHeadTitle(HeadTitle);

    			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

    			var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
    			var headers = [ { Text:HeadTitle, Align:"Center"} ];
    			InitHeaders(headers, info);

    			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"calc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:(document.form.cost_cd_inv_tp_cd.value=="SE" || document.form.cost_cd_inv_tp_cd.value=="OE")?1:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tier",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calc_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rvis_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"stay_days",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:(document.form.cost_cd_inv_tp_cd.value=="OS" || document.form.cost_cd_inv_tp_cd.value=="ST" || document.form.cost_cd_inv_tp_cd.value=="OE" || document.form.cost_cd_inv_tp_cd.value=="SE")?1:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",          KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:amount_formula,Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"portion",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"agmt_dtl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
    			InitColumns(cols);

    			SetEditable(1);
                      //no support[check again]CLT 	                style.height=GetSheetHeight(8) ;
    			SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
             //no support[check again]CLT 	                
    			ToolTipOption="balloon:true; width:320; backcolor:#ffffff; forecolor:#14358B; icon:0;";
    			SetSheetHeight(153);
             }

//end with (sheetObj) {
                break;
    		case "select":
    			with(sheetObj){
	    	        //no support[check again]CLT 	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    			var HeadTitle="status||Seq|Calculation Type|"
				    	      + "Cost Code|TP/\nSZ |I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|Sub Trade|"
				    	      + "Vol.Tier|Calculated\nVol.|Revised\n Vol.|Stay Days|UOM|Rate|Exch.\n Rate|Amount|portion|AGMT\nCurr.|AGMT DTL RMK";
	    			var headCount=ComCountHeadTitle(HeadTitle);
	
	    			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    			var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	    			var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    			InitHeaders(headers, info);
	
	    			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			    	             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"calc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:(document.form.cost_cd_inv_tp_cd.value=="SE" || document.form.cost_cd_inv_tp_cd.value=="OE")?1:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tier",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calc_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rvis_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"stay_days",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Float",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",          KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
			    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			    	             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"portion",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
			    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
			    	             {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"agmt_dtl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    	       
		    		InitColumns(cols);		
		    		SetEditable(1);
		    	            //no support[check again]CLT 	                style.height=GetSheetHeight(5) ;
		    		SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
		    		SetSheetHeight(138);
		    		
		    		
    			}

//end with (sheetObj)
    			break;
			case "costcode":
				with(sheetObj){
	    	        //no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					var HeadTitle="cost_code|agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|tml_trns_mod_cd|eff_fm_dt|eff_to_dt|ctrt_ofc_cd|cre_ofc_cd|cre_dt|upd_dt|chk_yd_flg";
					var headCount=ComCountHeadTitle(HeadTitle);
	
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_code",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_fm_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_to_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_yd_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    	       
					InitColumns(cols);
	
					SetEditable(1);
					SetSheetHeight(160);
    	            //no support[check again]CLT 				style.height=GetSheetHeight(3) ;
    	      	}

//end with (sheetObj)
    			break;
    	}//end switch
    }  
    
    /**
     * 2016.12.28 Add
     * 
     * @param Text
     * @returns {Boolean}
     */
    function getCheckYardCost(Text) {
        var sheetObj=sheetObjectsMap['costcode'];
        var rowIndex=sheetObj.FindText('cost_code', Text);
        var tmpYdCd = ComGetObjValue(document.form.yd_cd);
        if(rowIndex >= 0){
            var chkYdFlg = sheetObj.GetCellValue(rowIndex,"chk_yd_flg");
            var msg = "";
            if(!ComIsEmpty(chkYdFlg)){
                switch(chkYdFlg){
                    case "CFS" : //CFS yard
                        msg = "This Yard ("+tmpYdCd+") is not CFS Yard. Please kindly check again.";
                        ComShowMessage(msg);
                        return false;
                        break;
                    case "RAIL" ://Rail Ramp yard
                        msg = "This Yard ("+tmpYdCd+") is not Rail Ramp Yard. Please kindly check again.";
                        ComShowMessage(msg);
                        return false;
                        break;
                    case "EXT" ://Exclusive Terminal yard
                        msg = "This Yard ("+tmpYdCd+") is not exclusive Yard. Please kindly check again.";
                        ComShowMessage(msg);
                        return false;
                        break;
                }
            }
        }
        return true;
    }

 
