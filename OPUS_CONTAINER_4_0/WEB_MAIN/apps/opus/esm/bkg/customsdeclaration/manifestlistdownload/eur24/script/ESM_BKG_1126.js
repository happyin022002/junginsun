/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1126.js
*@FileTitle  : Europe Advanced Manifest - ENS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
	 // Common global variable
    var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    
    var intervalId="";
    // Event handler processing by button click event */
 	document.onclick=processButtonClick;
 	// Event handler processing by button name */
    function processButtonClick(){
    	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
    	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					formObject.reset();
 					sheetObject1.RemoveAll();
 					p_pol_cd_temp.RemoveAll();
 					p_pol_cd_temp.SetSelectText("");
 					document.form.div_total_bl_cnt.value="";
 					document.form.div_sent_bl_cnt.value="";
 					document.form.div_unsent_bl_cnt.value="";
 					document.form.div_sent_bl_cnt2.value="";
 					document.form.div_a_cnt.value="";
 					document.form.div_r_cnt.value="";
 					document.form.div_dnl_cnt.value="";
 					document.form.div_h_cnt.value="";
 					document.form.div_nr_cnt.value="";
 					break;
 				case "btn_DownExcel":
 					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						ComOpenWait(true);
 	 					var sheetDownload=sheetObjects[3];
 	 			        setTimeout(function(){getDownload(sheetObject1,sheetDownload);},500);
 					}
 					
 					break;
 				case "btn_Inquiry":
	 			      var row=sheetObject1.GetSelectRow();
	 			      var p_bl_no=(sheetObject1.GetCellValue(row, "bl_no") == -1 ? "":sheetObject1.GetCellValue(row, "bl_no"));
	 			      if(p_bl_no == ""){
	 			    		ComShowCodeMessage('COM12189');
		 			    	return;
	 			      }
	 			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1124_POP.do?pgmNo=ESM_BKG_1124&bl_no=" + p_bl_no, "1124", 1080, 700, false);
	 			      
	 			      break; 
 				case "btn_History":
 	 			      var row=sheetObject1.GetSelectRow();
					  var p_vvd=sheetObject1.GetCellValue(row, "vvd");
					  var p_cstms_port_cd=sheetObject1.GetCellValue(row, "pol");
					  var p_bl_no=sheetObject1.GetCellValue(row, "bl_no");
					  if(p_bl_no == "-1"){
	 			    		ComShowCodeMessage('COM12189');
		 			    	return;
	 			      }
 	 			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1127.do?pgmNo=ESM_BKG_1127&p_vvd=" + p_vvd + "&p_cstms_port_cd=" + p_cstms_port_cd+ "&p_bl_no=" + p_bl_no, "1127", 1000, 530, false);
	 			      
 	 			      break;     
 			    case "btn_viewMsg":
 			      var row=sheetObject1.GetSelectRow();
 			      if (ComIsNull(sheetObject1.GetCellValue(row,"ack"))) {
 	    				ComShowCodeMessage('BKG00442');
 	 					return;    
 			      }
 			      var edi_rcv_dt=sheetObject1.GetCellValue(row, "edi_rcv_dt");
 			      var edi_rcv_seq=sheetObject1.GetCellValue(row, "edi_rcv_seq");
 			      var cnt_cd=sheetObject1.GetCellValue(row, "pofe");
 			      if(cnt_cd.toString.length>2)
 			       {
 			    	  cnt_cd=cnt_cd.substring(0,2);
 			       }
 			       ComOpenWindowCenter("/opuscntr/ESM_BKG_1128.do?pgmNo=ESM_BKG_1128&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1128", 600, 680, false);
 			       break;   
 				case "btn_date":	
 					var cal=new ComCalendarFromTo();
 					cal.setEndFunction("endDateSet");
					cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
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
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet1_OnClick(sheetObj, row, col) {
        var colSaveName=sheetObj.ColSaveName(col);
        switch(colSaveName) {
	    	case "cntrs":
	    		 //ComShowMemoPad(sheetObj, row, "cntrs", true, 150, 100);	//편집불가능
			       break;
        } // end switch
    }       
    /**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering Combo Object as list
     * 
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
		ComBtnDisable("btn_BLAdd");
		ComBtnDisable("btn_BLDelete");
		//ComBtnDisable("btn_Transmit");

		initControl();
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
	}
    
    function initControl() {
     	var formObject=document.form;
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        //axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
     }
    /**
     * initializing Combo Object
     * @param comboObj
     * @param comNo
     * @return
     */ 
   	function initCombo(comboObj, comboId) {
   	    var formObject=document.form
  			initComboEditable(comboObj, comboId)
   	}
 	/** 
 	* 콤보 멀티 셀렉트 및 수정 여부 초기 설정 <br> 
 	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	* @param {String} comboId 필수,combo ID
 	* @return 없음.
 	*/ 
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pol_cd_temp" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(1);
	 			SetBackColor("#CCFFFD");
	 		}
 		}
 	} 
/*********************** KEY EVENT START ********************/ 	 

	var preVvd;//이전에 조회했던 VVD에서 Focus Out 되면 재조회 하지 않는다.
	var prePodCd;
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_vvd_cd":
//	    		if(preVvd == formObj.p_vvd_cd.value) {
//	    			formObj.p_pod_cd.value = prePodCd;
//	    		}else{
//		    		preVvd = formObj.p_vvd_cd.value;
//		    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//	    		}
//	    		formObj.p_pol_cd.focus();
				break;
	    	case "p_from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
				default:
					break;
	    }
    }           
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(ComGetEvent().name){	
	    	case "p_from_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "p_to_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
			default:
					break;
		}
	}       
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change(){
	    switch (ComGetEvent("name")) {
	    	case "p_vvd":
	    		sheetObjects[2].RemoveAll();
	    		p_pol_cd_temp.RemoveAll();
	    		p_pol_cd_temp.SetSelectText("",false);
	    		document.form.p_pol_yd.value="";
	   	 		//form.p_search_pofe_yard_cd.value = "";
//	    		form.p_pofe_yd_temp.RemoveAll();
//	    		form.p_pofe_yd_temp.Text2 = "";
//	    		form.p_pofe_yd.value = "";
//	   	 		form.p_search_pofe_yard_cd.value = "";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	    		if(p_pol_cd_temp.GetItemCount() >= 1 ){
	    			p_pol_cd_temp.SetSelectIndex(0);
	    		}
	    		if(p_pol_cd_temp.GetItemCount() >= 1 ){
	    			p_pol_cd_temp.SetSelectIndex(0);
	    		}
	    		document.form.p_b_ofc_cd.focus();
				break;
			default:
				break;
	    }
    }
    function sheet1_OnDblClick(sheetObj, row, col) {
	        var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
	        		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
		    	break;
	        } // end switch
     }	    
     /**
      * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
             var redColor="#FF0000";
             for(var i=HeaderRows(); i<= LastRow(); i++) {
            	 if (GetCellValue(i,"result2") == "DNL" || GetCellValue(i,"result2") == "R" || GetCellValue(i,"result2") == "D" || GetCellValue(i,"result2") == "P" || GetCellValue(i,"result2") == "H") {
 	                	SetCellFontColor(i,"result",redColor);
	                }
             }
         }//end width
     }	     
 	
	 /**
	  * DownExcel시 wait 창이 바로 뜨질 않아 setTimeout함수를 호출해서 작업한다.
	  * @param sheetObj sheetObject1
	  * @param sheetObj sheetDownload
	  */   
	function getDownload(sheetObject1,sheetDownload){
		sheetDownload.RemoveAll();
		 with (sheetObject1) {
	     	 var arrCntr;
	     	 var Row ;
	          for(var i=HeaderRows(); i<= LastRow(); i++) {
	        	  arrCntr=GetCellValue(i,"cntrs").split("\n");
	         	for( var j=0; j< arrCntr.length; j++){
	         		Row=sheetDownload.DataInsert(-1);
					sheetDownload.SetCellValue(Row, "seq",getNull(GetCellValue(i, "seq")                ," "),0);
					sheetDownload.SetCellValue(Row, "vvd",getNull(GetCellValue(i, "vvd")                ," "),0);
					sheetDownload.SetCellValue(Row, "lane",getNull(GetCellValue(i, "lane")               ," "),0);
					sheetDownload.SetCellValue(Row, "bpol",getNull(GetCellValue(i, "bpol")               ," "),0);
					sheetDownload.SetCellValue(Row, "bpol_yd",getNull(GetCellValue(i, "bpol_yd")			   ," "),0);
					sheetDownload.SetCellValue(Row, "pol",getNull(GetCellValue(i, "pol")                ," "),0);
					sheetDownload.SetCellValue(Row, "pol_yd",getNull(GetCellValue(i, "pol_yd")             ," "),0);
					sheetDownload.SetCellValue(Row, "pofe",getNull(GetCellValue(i, "pofe")               ," "),0);
					sheetDownload.SetCellValue(Row, "pofe_yd",getNull(GetCellValue(i, "pofe_yd")            ," "),0);
					sheetDownload.SetCellValue(Row, "bl_no",getNull(GetCellValue(i, "bl_no")              ," "),0);
					sheetDownload.SetCellValue(Row, "bkg_sts_cd",getNull(GetCellValue(i, "bkg_sts_cd")         ," "),0);
					sheetDownload.SetCellValue(Row, "pod",getNull(GetCellValue(i, "pod")                ," "),0);
					sheetDownload.SetCellValue(Row, "pod_yd",getNull(GetCellValue(i, "pod_yd")             ," "),0);
					sheetDownload.SetCellValue(Row, "del",getNull(GetCellValue(i, "del")                ," "),0);
	         		sheetDownload.SetCellValue(Row, "cntrs",arrCntr[j],0);
					sheetDownload.SetCellValue(Row, "ct",getNull(GetCellValue(i, "ct")                 ," "),0);
					sheetDownload.SetCellValue(Row, "sent_type",getNull(GetCellValue(i, "sent_type")          ," "),0);
					sheetDownload.SetCellValue(Row, "ack",getNull(GetCellValue(i, "ack")                ," "),0);
					sheetDownload.SetCellValue(Row, "result",getNull(GetCellValue(i, "result")             ," "),0);
					sheetDownload.SetCellValue(Row, "mrn_no",getNull(GetCellValue(i, "mrn_no")             ," "),0);
					sheetDownload.SetCellValue(Row, "ens_send_gmt_dt",getNull(GetCellValue(i, "ens_send_gmt_dt")    ," "),0);
					sheetDownload.SetCellValue(Row, "ens_send_dt",getNull(GetCellValue(i, "ens_send_dt")        ," "),0);
					sheetDownload.SetCellValue(Row, "ack_rcv_gmt_dt",getNull(GetCellValue(i, "ack_rcv_gmt_dt")     ," "),0);
					sheetDownload.SetCellValue(Row, "ack_rcv_dt",getNull(GetCellValue(i, "ack_rcv_dt")         ," "),0);
					sheetDownload.SetCellValue(Row, "edi_rcv_dt",getNull(GetCellValue(i, "edi_rcv_dt")         ," "),0);
					sheetDownload.SetCellValue(Row, "edi_rcv_seq",getNull(GetCellValue(i, "edi_rcv_seq")        ," "),0);
					sheetDownload.SetCellValue(Row, "bkg_no",getNull(GetCellValue(i, "bkg_no")             ," "),0);
					sheetDownload.SetCellValue(Row, "result2",getNull(GetCellValue(i, "result2")            ," "),0);
	         	}
	          }
	       }//end width
	//		sheetDownload.SpeedDown2Excel(-1);
	//	 	sheetDownload.Down2Excel({ HiddenColumn:-1});
		 
			var excelCol = makeHiddenSkipCol(sheetDownload);
			//  goods_item_no  제외
			    excelCol=ComReplaceStr(excelCol,"|"+sheetDownload.SaveNameCol("result2"),"");
	//		    excelCol=ComReplaceStr(excelCol,"|27","");
			    sheetDownload.Down2Excel({DownCols: excelCol, Merge:1,UserMerge:excelCol});
	//	 	sheetDownload.Down2Excel({DownCols: makeHiddenSkipCol(sheetDownload), Merge:1});
			    
			ComOpenWait(false);
	}     
    
	function getNull(src,nullToStr){
    	if(src == null || src == ""){
    		return (nullToStr == null ? "":nullToStr)
    	}
    	return src;
	}
	
	function endDateSet(){
		if (ComIsNull(document.form.p_from_mt)) {
			document.form.p_from_mt.value="00:00";
		}
		if (ComIsNull(document.form.p_to_mt)) {
			document.form.p_to_mt.value="23:59";
		}
	}
    
	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var bl_sc_no=0;
				if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd)) {
					sheetObj.RemoveAll();
					//sheetObj.RenderSheet(0);
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH04;
					var pofeXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj));
					var vvd_cnt=ComGetEtcData(pofeXml,"vvd_cnt");
					var pol_cnt=ComGetEtcData(pofeXml,"pol_cnt");
					var temp_pol=ComGetEtcData(pofeXml,"pol");//bl로 조회한 pol
					formObj.p_vvd.value=ComGetEtcData(pofeXml,"vvd");
					formObj.p_pol.value=ComGetEtcData(pofeXml,"pod");
					doActionIBSheet(sheetObj, formObj, SEARCH01);
					//EU POL list
					doActionIBSheet(sheetObj, formObj, SEARCH02);
					if(eval(vvd_cnt) > 1){
						ComShowCodeMessage('BKG95001','BL이 2개이상 VVD를 가지고 있습니다. 직접 입력해주세요.');
						//sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						return;
					}
					if(p_pol_cd_temp.GetItemCount() == 1){
						p_pol_cd_temp.SetSelectIndex(0);
					}else if(p_pol_cd_temp.GetItemCount() > 1){
						//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
			    		p_pol_cd_temp.SetSelectIndex(0);
			    		p_pol_cd_temp.SetSelectText(temp_pol);			    		
			    		//ComShowCodeMessage('BKG95001','select a POL');
						//sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						bl_sc_no=1;
			    		//return;
					}else{
						ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
						//sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						return;
		    		}
	    		}
				// 사용자 입력값을 uppercase로 변경  
				var comboText=p_pol_cd_temp.GetSelectText().toUpperCase();
				// 선택 또는 입력한  값이 콤보에 있으면
				if (sheetObjects[2].FindText('eu_1st_port',comboText) != -1) {
					document.form.p_pol_yd.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port',comboText),"eu_1st_port_yd_cd").substring(5);
				}else{
					document.form.p_pol_yd.value=comboText;
				}
				//sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
//				formObj.p_pol.value = ComGetObjValue(formObj.p_pol_cd_temp);
				formObj.p_pol.value=p_pol_cd_temp.GetSelectText();		
				sheetObj.RemoveAll();
				var sXml=sheetObj.GetSearchData("ESM_BKG_1126GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1});
				if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
					formObj.div_total_bl_cnt.value="0";
					formObj.div_sent_bl_cnt.value="0";
					formObj.div_unsent_bl_cnt.value="0";
					formObj.div_sent_bl_cnt2.value="0";
					formObj.div_a_cnt.value="0";
					formObj.div_r_cnt.value="0";
					formObj.div_dnl_cnt.value="0";
					formObj.div_h_cnt.value="0";
					formObj.div_l_cnt.value="0";
					formObj.div_nr_cnt.value="0";
				}else{
					formObj.div_total_bl_cnt.value=ComGetEtcData(sXml,"total_bl_cnt");
					formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_sent_bl_cnt2.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_a_cnt.value=ComGetEtcData(sXml,"a_cnt");
					formObj.div_r_cnt.value=ComGetEtcData(sXml,"r_cnt");
					formObj.div_dnl_cnt.value=ComGetEtcData(sXml,"dnl_cnt");
					formObj.div_h_cnt.value=ComGetEtcData(sXml,"h_cnt");
					formObj.div_l_cnt.value=ComGetEtcData(sXml,"l_cnt");
					formObj.div_nr_cnt.value=ComGetEtcData(sXml,"nr_cnt");
				}
				//sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				if(bl_sc_no == 1 && sheetObj.RowCount()< 1){
					ComShowCodeMessage('BKG95001','select a POL');
				}
				
				formObj.div_unsent_bl_cnt.style.color="#FF0000";
				formObj.div_r_cnt.style.color="#FF0000";
				formObj.div_dnl_cnt.style.color="#FF0000";
				formObj.div_h_cnt.style.color="#FF0000";
				formObj.div_nr_cnt.style.color="#FF0000";
				
				break;
			case SEARCH01 : // lane 조회
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1126GS.do", FormQueryString(formObj));
				formObj.p_lane.value=ComGetEtcData(sXml,"p_lane");
				
//				formObj.f_cmd.value=SEARCH01;
//				var sXml=sheetObj.GetSearchData("ESM_BKG_1126GS.do", FormQueryString(formObj)+"&p_vvd_cd="+formObj.p_vvd.value);

//				formObj.p_lane.value=ComGetEtcData(sXml,"p_lane");
				break;
			case SEARCH02 : // eu pol port 조회
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj)+"&p_vvd_cd="+formObj.p_vvd.value);
				ComXml2ComboItem(sXml, p_pol_cd_temp, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			case SEARCH05 : // eu 국가 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObjects[1].RenderSheet(0);
				sheetObjects[1].SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				sheetObjects[1].RenderSheet(1);
				sheetObjects[1].SetWaitImageVisible(0);
				break;
        }//end switch
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
	    		if (!ComIsNull(formObj.p_from_mt)) {
    				var from_mt_temp="";
    				var arr_mt=formObj.p_from_mt.value.split(":")
    				if(ComIsNull(arr_mt[0])){
    					from_mt_temp="00:";
    				}else{
    					if(eval(arr_mt[0])> 23 ) from_mt_temp="23:";
    					else from_mt_temp=eval(arr_mt[0])< 10 ? "0"+eval(arr_mt[0])+":":arr_mt[0]+":";
    				}
    				if(ComIsNull(arr_mt[1])){
    					from_mt_temp +="00";
    				}else{
    					if(eval(arr_mt[1])> 59 ) from_mt_temp +="59";
    					else from_mt_temp += eval(arr_mt[1])< 10 ? "0"+eval(arr_mt[1]):arr_mt[1];
    				}
    				formObj.p_from_mt.value=from_mt_temp;
    			}
    			if (!ComIsNull(formObj.p_to_mt)) {
    				var to_mt_temp="";
    				var arr_mt2=formObj.p_to_mt.value.split(":")
    				if(ComIsNull(arr_mt2[0])){
    					to_mt_temp="00:";
    				}else{
    					if(eval(arr_mt2[0])> 23 ) to_mt_temp="23:";
    					else to_mt_temp=eval(arr_mt2[0])< 10 ? "0"+eval(arr_mt2[0])+":":arr_mt2[0]+":";
    				}
    				if(ComIsNull(arr_mt2[1])){
    					to_mt_temp +="00";
    				}else{
    					if(eval(arr_mt2[1])> 59 ) to_mt_temp +="59";
    					else to_mt_temp += eval(arr_mt2[1])< 10 ? "0"+eval(arr_mt2[1]):arr_mt2[1];
    				}
    				formObj.p_to_mt.value=to_mt_temp;
    			}
	    		/*
    			if(form.p_pofe_yd_temp.GetSelectText()!= "" &&
    					(form.p_pofe_yd_temp.GetSelectText().length < 5 || form.p_pofe_yd_temp.GetSelectText().length > 7) ){
    				if(form.p_pofe_yd_temp.GetSelectText().indexOf("(") < 0){
	    				ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
	    				return false;
    				}
    			}
    			*/
	    		if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
	    			if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 7){
		    			ComShowCodeMessage('COM132001','Send/Received Date','7Days');
		    		//	p_from_dt.focus();
		    			return false;
		    		}
	    			return true;
	    		}
	    		if (!ComIsNull(formObj.p_bl_no)) {
	    			return true;
	    		}
	    		//기본포멧체크
    			if (ComIsNull(formObj.p_vvd)) {
    				ComShowCodeMessage('BKG00104','VVD');
 					//formObj.p_vvd_cd.focus();
 					return false;    
    			}
//    			if (ComIsNull(formObj.p_pol)) {
//    				ComShowCodeMessage('BKG00104','POL');
//    				formObj.p_pol.focus();
//    				return false;    
//    			}
//    			if(form.p_pofe_yd_temp.Text == "" ){
//    				ComShowCodeMessage('BKG00104','POFE');
//    				formObj.p_pofe_yd_temp.focus();
//    				return false;    
//    			}   
				break;
	    }
        return true;
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
			case "sheet1":
			    with(sheetObj){		       
				      var HeadTitle1="|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Status|Status|MRN\nNO|EXS Send Date|EXS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2";
				      var HeadTitle2="|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 9, 0, true);		
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20,  FrozenCol:8,  DataRowMerge:0 } );		
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						             {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bpol",             KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bpol_yd",          KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe",             KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe_yd",          KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"del",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntrs",  MultiLineText:1,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ct",               KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sent_type",        KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ack",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_gmt_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_dt",      KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_gmt_dt",   KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetMergeCell(0, 4, 2, 2); //bpol
				      SetMergeCell(0, 6, 2, 2); //pol
				      SetMergeCell(0, 8, 2, 2); //pofe
				      SetMergeCell(0, 12, 2, 2); //pod
				      SetSheetHeight(372);
				      //SetRangeBackColor(1, 3, 1, 25,"#555555");
		      }
				break;
			case "sheetDownload":
			    with(sheetObj){		        
				      var HeadTitle1="|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Status|Status|MRN\nNO|ENS Send Date|EXS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR";
				      var HeadTitle2="|Seq.|VVD|LANE|B.POL|B.POL|EU POL|EU POL|POFE|POFE|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 9, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bpol",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bpol_yd",          KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ct",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sent_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ack",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_gmt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_gmt_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrs",    MultiLineText:1,   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetMergeCell(0, 4, 2, 2); //bpol
				      SetMergeCell(0, 6, 2, 2); //pol
				      SetMergeCell(0, 8, 2, 2); //pofe
				      SetMergeCell(0, 12, 2, 2); //pod
				      SetSheetHeight(390);
		      }
			break;				
			case "sheet2":
			    with(sheetObj){		       
				      var HeadTitle1="|cnt_cd";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(280);
		            }
				break;
			case "sheet3":
			    with(sheetObj){		        
				      var HeadTitle1="|eu_1st_port|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];			       
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(280);
		            }
				break;
		}//end switch
 	}     
    /* 개발자 작업  끝 */
