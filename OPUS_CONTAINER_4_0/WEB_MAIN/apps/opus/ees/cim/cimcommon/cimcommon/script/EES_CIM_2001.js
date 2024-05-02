/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CIM_2001.js
*@FileTitle : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
    // 공통전역변수
    var tabObjects=new Array();
    var comboObjects=new Array();
    var comboCnt=0 ; 
    var tcnt=0;
	var tabCnt=0;
	var beforetab=1;
	var tabIndex=0;
	var tabFlag=0;
	var IBSEARCH01=29;
    var IBSEARCH02=30;
    var IBSEARCH03=31;
    var IBSEARCH04=32;
    var IBSEARCH05=33;
    var IBSEARCH06=34;
    
    var sheetObjects=new Array();
    
    var sheetCnt=0; 
    var HeadTitleCnt=0;
    var isOpen=false;
    var arr_bkg_no = "";
    var arr_cyc_no = "";
    var vCnmvStsCd = "";
	var sXml_3 = "";
	var now_date = "";
	var now_day = "";
	var now_time = "";
	var strMinimizeYN = true;
	var row_now_day = "";
	var row_now_time = "";
	var row_now_date = "";
	var SortInfo = "ASC";
	var strShtClick = true;
    document.onclick=processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt=0;
    	var sheet1=sheetObjects[shtCnt];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
			case "btn_new":		//조회조건 초기화
				sheet1.RemoveAll();
				sheet2.RemoveAll();
				sheet3.RemoveAll();
				sheet4.RemoveAll();
				sheet5.RemoveAll();
				sheet6.RemoveAll();
				sheet7.RemoveAll();
				formObject.reset();                
				ComSetFocus(document.form.s_cntr_no);
				tabObjects[0].SetSelectedIndex(0);
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_downexcel");
				
				ComBtnDisable("btn_master");
				$("#btn_master").css("background-color","#E0E0E0");
				ComBtnDisable("btn_cycle");
				$("#btn_cycle").css("background-color","#E0E0E0");
				ComBtnDisable("btn_ctn_status");
				$("#btn_ctn_status").css("background-color","#E0E0E0");
				
				ComBtnDisable("btns_calendar1");
				ComBtnDisable("ComOpenPopupWithTarget1");
				ComBtnDisable("btn_save1");
				ComBtnDisable("btn_save2");
				$("#btn_save2").css("background-color","#E0E0E0");
				
				if(strMinimizeYN == false) {
    				sheet_Change();
    			}
				
				formObject.pop_cntr_no.value='';
				formObject.o_cntr_no.value='';
				$("#cntr_txt").css("display","");
				$("#cntr_combo").css("display","none");
				comboObjects[0].RemoveAll();
				
				/*document.getElementById("input_cntr_sts_cd").className = "input2";
				document.getElementById("input_cntr_sts_cd").disabled=true;*/
				document.getElementById("input_cntr_sts_evnt_dt2").className = "input2";				
				document.getElementById("input_cntr_sts_evnt_dt2").disabled=true;
				document.getElementById("input_onh_yd_cd").className = "input2";
				document.getElementById("input_onh_yd_cd").disabled=true;
				
				// initializing date. setting current time as event time
			    strTime=new Date(); 
			    y=strTime.getFullYear();
			    m=strTime.getMonth() + 1;
			    d=strTime.getDate();
			    if (m < 10) m="0" + m;
			    if (d < 10) d="0" + d;			    			    
			    
			 // initializing date. setting current time as event time
			    document.form.s_event_date2.value=y + "-" + m + "-" + d;
			    document.form.s_event_date1.value=ComGetDateAdd(document.form.s_event_date2.value, "M", -3);
				break;
    		case "btn_retrieve":
    			if (formObject.s_cntr_no.value == "" && formObject.s_bkg_no.value == "") {
					ComShowCodeMessage("CIM21001", "Booking No or Container No");
					ComSetFocus(formObject.s_cntr_no);
					return;
				} 
    			
    			if(strMinimizeYN == false) {
    				sheet_Change();
    			}
    			tabObjects[0].SetSelectedIndex(0);
    			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    			break;   
    		case "btn_save":
    			var ibcheckYN = false;
    			var delcheck = false;
        		for(var i=1;i<=sheetObjects[3].RowCount();i++) {
        			if(sheetObjects[3].GetCellValue(i,"ibcheck") == 1) {
        				ibcheckYN = true;
        				break;
        			}
        			
        			if(sheetObjects[3].GetCellProperty(i, "delcheck", "Type") == "DummyCheck") {
        				delcheck = true;
        				break;
        			} 
        		}
        		
        		if(ibcheckYN == true || delcheck == true) {
        			doActionIBSheet(sheetObjects[3], formObject, IBSAVE, 1);
        		}else{
        			ComShowCodeMessage("CIM30011");
        		}
        		
    			break;
    		case "btn_save1":
    			sheetObjects[7].RemoveAll();
    			doActionIBSheet(sheetObjects[7], formObject, IBSAVE, 2);
    			break;
    		case "btn_save2":
    			var cycYN = false;
        		for(var i=1;i<=sheetObjects[0].RowCount();i++) {
        			if(sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9999" || sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9998") {
        				cycYN = true
        				sheetObjects[0].SetRowStatus(i,"U");
        			}
        		}
        		if(cycYN == true) {
        			doActionIBSheet(sheetObjects[0], formObject, IBSAVE, 3);
        		}
        		
    			break;
    		case "btn_popup1": //agmt no
                	rep_Multiful_inquiry("pop_cntr_no");                	
                break;
    		case "btn_popup2": //
            		rep_Multiful_inquiry("pop_edi_error_cntr_no");                	
            	break;
    		case "btn_reset":
    			var sel_row = sheetObjects[2].GetSelectRow();
        		var sel_col = sheetObjects[2].GetSelectCol();
        		
        		sheet3_OnClick(sheetObjects[2], sel_row, sel_col, "");
    			break;
    		case "btn_add":
    			doActionIBSheet(sheetObjects[3], formObject, IBINSERT);
    			break;
    		case "btn_delete":
    			doActionIBSheet(sheetObjects[3], formObject, IBDELETE);
    			break;
    		case "btn_downexcel":
    			if(sheetObjects[3].RowCount() < 1){//no data
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObjects[3].Down2Excel( {DownCols: makeHiddenChangeSkipCol(	sheetObjects[3]), SheetDesign:1,Merge:1 });
        		}
    			break;
    		 case "btn_master":
 				if (sheetObjects[2].RowCount() != 0 ) {
 					var cntr_no=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(),"cntr_no");
 					//if (sheetObjects[3].GetRowStatus(sheetObjects[3].GetSelectRow()) == "R"){
 						var cntr_no_len=cntr_no.length;
 						if ( cntr_no_len > 10 ) {
 							cntr_no=cntr_no.substring(0,10);
 						} 
 						ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?popup_mode=Y&cntr_no="+cntr_no,1100, 630, "", "1,0,1,1,1,1,1,1", true);
 					//}
 				}
 				break;  		
    		 case "btns_calendar1":     		
 	    		if(!formObject.input_cntr_sts_evnt_dt2.disabled){
 					var cal=new ComCalendar();
 					cal.select(formObject.input_cntr_sts_evnt_dt2, 'yyyy-MM-dd');
 	    		}
 				break;
    		 case "btns_calendar2":
                 var evtObj = ComGetEvent();
                 if (!evtObj.disabled) {
                     var cal=new ComCalendarFromTo();
                     cal.select(formObject.s_event_date1, formObject.s_event_date2, 'yyyy-MM-dd');
                 }
                 break;
    		 case "ComOpenPopupWithTarget1":
 	    		if(!formObject.input_onh_yd_cd.disabled){			
 	 		        ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 530, "3:input_onh_yd_cd", "0,0,1,1,1,1,1", true);
 	   		        if (formObject.input_onh_yd_cd.value == ""){
 	   		        	formObject.yd_cd_nm.value="";
 	   		        }
 	            	if (formObject.input_onh_yd_cd.value.length > 0 && formObject.input_onh_yd_cd.value.length != 7){
 	            		ComShowCodeMessage("CIM30013", formObject.input_onh_yd_cd.value);
 	            		formObject.input_onh_yd_cd.value="";
 	            		formObject.yd_cd_nm.value="";
 	            		ComSetFocus(formObject.input_onh_yd_cd);
 	            		return;
 	            	} else {
 	            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH04);
 	            	} 	    			
 	    		}
 				break;  
 				
    		 case "btn_minimize":
    			 ComOpenWait(true);
    			 sheet_Change();
     			 
     			 break;   
    		 case "btn_cycle": //
    			 var sel_row = sheetObjects[2].GetSelectRow();
         		 var sel_col = sheetObjects[2].GetSelectCol();         		
         		
    			 var sel_cntrno = sheetObjects[2].GetCellValue(sel_row,"cntr_no");
    			 ComOpenPopup("/opuscntr/EES_CTM_0470_POP.do?cntr_no=" + sel_cntrno, 1000, 400, "", "0,1");
                 break;
    		 case "btn_ctn_status": //
    			 var sel_row = sheetObjects[2].GetSelectRow();
         		 var sel_col = sheetObjects[2].GetSelectCol();         		
         		
    			 var sel_cntrno = sheetObjects[2].GetCellValue(sel_row,"cntr_no");
    			 
    			 window.open("/opuscntr/EES_MST_0028.do?pid=EES_MST_M008&MENU=Y&pgmNo=EES_MST_0028&parentPgmNo=EES_MST_M001&main_page=true&mainMenuLinkFlag=true&menuflag=true&mainPage=true&s_cntrno="+sel_cntrno,
    					 "_blank","width=1400, height=660;"); 
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
    
    function makeHiddenChangeSkipCol(sobj){
        var lc = sobj.LastCol();
        var rtnStr = "";
        for(var i=3;i<=lc;i++){
        	if( ! ( 1==sobj.GetColHidden(i) || sobj.GetCellProperty(0,i,"Type") == "CheckBox" || sobj.GetCellProperty(0,i,"Type") == "DummyCheck" 
        		|| sobj.GetCellProperty(0,i,"Type") == "Radio"||  sobj.GetCellProperty(0,i,"Type") == "Status" 
        		||  sobj.GetCellProperty(0,i,"Type") =="DelCheck"  )){
        		rtnStr += "|"+ i;
        	}
        }
        return rtnStr.substring(1);
    }
    
    /**
     * MultiCombo object initial property //LHS
     * @param comboObj
     * @param comboNo
     * @return
     */
    function initCombo (comboObj, comboNo) {
    	 switch(comboObj.options.id) {
       	 case "s_cntr_no":
    		with(comboObj) {
       		 	SetBackColor("#CCFFFA");
    			SetDropHeight(150);
    			SetMultiSelect(0);
    			SetUseAutoComplete(1);
    			SetEditable(false);
    			Style=0;
    		}
    		break;
    	}      
    }
    
    
    function sheet_Change(){    	
    	if(strMinimizeYN == true) {
    		if(sheetObjects[0].RowCount() > 0) {
    			var row_num = "";
	    		var sel_row = sheetObjects[0].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[0].RowCount();i++) {
	    			row_num = row_num + "|" + i;
	    		}
	    		sheetObjects[0].SetRowHidden(row_num, 0);
	    		
	    	}
    		
    		if(sheetObjects[1].RowCount() > 0) {
    			var row_num = "";
	    		var sel_row = sheetObjects[1].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[1].RowCount();i++) {
	    			row_num = row_num + "|" + i;
	    		}
	    		sheetObjects[1].SetRowHidden(row_num, 0);	    
	    		
	    	}
	    	
	    	if(sheetObjects[2].RowCount() > 0) {
	    		var row_num = "";
	    		var sel_row = sheetObjects[2].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[2].RowCount();i++) {	    			
	    				row_num = row_num + "|" + i;
	    		}
	    		
	    		sheetObjects[2].SetRowHidden(row_num, 0);	    
	    		
	    	}
	    	
	    	sheetObjects[0].SetSheetHeight(150);
	    	sheetObjects[1].SetSheetHeight(150);
	    	sheetObjects[2].SetSheetHeight(150);
	    	sheetObjects[3].SetSheetHeight(250);
	    	sheetObjects[4].SetSheetHeight(250);
	    	sheetObjects[5].SetSheetHeight(250);
	    	sheetObjects[6].SetSheetHeight(250);

	    	
    		strMinimizeYN= false;
    		document.getElementById("btn_minimize").innerText = "Minimize";
    	} else {
	    	if(sheetObjects[0].RowCount() > 0) {
	    		var row_num = "";
	    		var sel_row = sheetObjects[0].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[0].RowCount();i++) {
	    			if(sel_row == i) {
	    				sheetObjects[0].SetRowHidden(i,0);
	    			}else{
	    				row_num = row_num + "|" + i;
	    			}
	    		}
	    		sheetObjects[0].SetRowHidden(row_num, 1);	    
	    		
	    	}
	    	
	    	if(sheetObjects[1].RowCount() > 0) {
	    		var row_num = "";
	    		var sel_row = sheetObjects[1].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[1].RowCount();i++) {
	    			if(sel_row == i) {
	    				sheetObjects[1].SetRowHidden(i,0);
	    			}else{
	    				row_num = row_num + "|" + i;
	    			}
	    		}
	    		sheetObjects[1].SetRowHidden(row_num, 1);	    
	    		
	    	}
	    	
	    	if(sheetObjects[2].RowCount() > 0) {
	    		var row_num = "";
	    		var sel_row = sheetObjects[2].GetSelectRow();
	    		for(var i=1;i<=sheetObjects[2].RowCount();i++) {
	    			if(sel_row == i) {
	    				sheetObjects[2].SetRowHidden(i,0);
	    			}else{
	    				row_num = row_num + "|" + i;
	    			}
	    		}
	    		
	    		sheetObjects[2].SetRowHidden(row_num, 1);	    		
	    		
	    	}
	    	sheetObjects[0].SetSheetHeight(80);
	    	sheetObjects[1].SetSheetHeight(80);
	    	sheetObjects[2].SetSheetHeight(100);
	    	sheetObjects[3].SetSheetHeight(300);
	    	sheetObjects[4].SetSheetHeight(300);
	    	sheetObjects[5].SetSheetHeight(300);
	    	sheetObjects[6].SetSheetHeight(300);
	    	
	    	strMinimizeYN= true;
	    	document.getElementById("btn_minimize").innerText = "Maximize";    		
    	}
    	ComOpenWait(false);
    }
    
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj, tabNo) {
    	switch (tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt=0;
    			InsertItem( "Container Movement History with EDI Error", "");
    			InsertItem( "Container Movement History", "");
    			InsertItem( "EDI Message History", "");
    			InsertItem( "Container Status Inquiry", "");
    		}
    		break;
    	}
    }
    
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj) {
    	tabObjects[tabCnt++]=tab_obj;
    }
    
    
    /**
     * event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj, nItem) {
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i<objs.length; i++){
    	   if(i != nItem){
    	        objs[i].style.display="none";
    	        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	   	}
    	}
    	beforetab=nItem;
    	tabIndex=nItem;
    }
    
    
    /**
     * event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnClick(tabObj, nItem) {
    	beforetab=nItem;
    	tabIndex=nItem;
    	var formObj=document.form;
    	if (isOpen) {
    		if (nItem == 0) {
    			//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		} else if (nItem == 1) {
    			formObj.f_cmd.value=SEARCH03;
	            var xml=sheetObjects[4].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	            var rtnValue=xml.split("|$$|");
	            sheetObjects[4].LoadSearchData(rtnValue[0],{Sync:0} );
    		} else if (nItem == 2) {
    			formObj.f_cmd.value=SEARCH04;
	            var xml=sheetObjects[5].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	            var rtnValue=xml.split("|$$|");
	            sheetObjects[5].LoadSearchData(rtnValue[0],{Sync:0} );
    		} else if (nItem == 3) {
    			formObj.f_cmd.value=SEARCH05;
	            var xml=sheetObjects[6].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	            var rtnValue=xml.split("|$$|");
	            sheetObjects[6].LoadSearchData(rtnValue[0],{Sync:0} );
    		}
    	}
    }
    
    /**
     * 초기 이벤트 등록 
     */
    function initControl() {
        //axon_event.addListenerForm('change','form_change',form);
    	var formObj=document.form;
		axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- handling OnBeforeDeactivate event of all control except rdoCity
		axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- when key down
		axon_event.addListenerForm('change', 'obj_change', formObj);
    }    
	
    
    function cntr_change() {
    	var formObj=document.form;
    	var cntrNo = formObj.o_cntr_no.value;
    	comboObjects[0].RemoveAll();
    	formObj.pop_cntr_no.value = cntrNo;
    	comboObjects[0].InsertItem(0, cntrNo, cntrNo);
    	comboObjects[0].SetSelectIndex(0);
    }
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
	
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		/* IBMultiCombo initailizing */
		for ( var j=0 ; j < comboObjects.length ; j++ ) {
	 		initCombo(comboObjects[j], j+1);
	 		
	 	}
		
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			 tabObjects[k].SetSelectedIndex(0);
		}

		// initializing date. setting current time as event time
	    strTime=new Date(); 
	    y=strTime.getFullYear();
	    m=strTime.getMonth() + 1;
	    d=strTime.getDate();
	    if (m < 10) m="0" + m;
	    if (d < 10) d="0" + d;
	    now_day=""+y+"-"+m+"-"+d;   
	    
	    
	    digital=new Date();
	    hours=digital.getHours();
	    minutes=digital.getMinutes();
	    if (minutes < 10)
	        minutes="0" + minutes;
	    if (hours < 10)
	        hours="0" + hours;
	    now_time=hours + ":" + minutes;
	    now_date=now_day + " " +now_time;
	    
	    document.form.s_event_date2.value=y + "-" + m + "-" + d;
	    document.form.s_event_date1.value=ComGetDateAdd(document.form.s_event_date2.value, "M", -3);
	    
		isOpen=true;
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_add");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_downexcel");
		
		ComBtnDisable("btn_master");
		$("#btn_master").css("background-color","#E0E0E0");
		ComBtnDisable("btns_calendar1");
		ComBtnDisable("ComOpenPopupWithTarget1");
		ComBtnDisable("btn_save1");
		ComBtnDisable("btn_save2");
		//document.getElementById("btn_save2").style.
		$("#btn_save2").css("background-color","#E0E0E0");
		
		ComBtnDisable("btn_cycle");
		$("#btn_cycle").css("background-color","#E0E0E0");
		ComBtnDisable("btn_ctn_status");
		$("#btn_ctn_status").css("background-color","#E0E0E0");
		
		/*document.getElementById("input_cntr_sts_cd").className = "input2";
		document.getElementById("input_cntr_sts_cd").disabled=true;*/
		document.getElementById("input_cntr_sts_evnt_dt2").className = "input2";				
		document.getElementById("input_cntr_sts_evnt_dt2").disabled=true;
		document.getElementById("input_onh_yd_cd").className = "input2";				
		document.getElementById("input_onh_yd_cd").disabled=true;
		initControl();	
		// Smaller than Min-value. 방지를 위하여 100으로 Setting 후 80으로 변경
    	sheetObjects[0].SetSheetHeight(80);
    	sheetObjects[1].SetSheetHeight(80);		
	}
	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
				var HeadTitle="||APP|CYC|CHANGE|BKG No.|BKG STS|CGO|POR|POL|POD|DEL|Lane|ETD DT|T.VVD|R/Term|D/Term|Creation Date|Update Date" ;

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",     Hidden:1,  Width:30,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },     
				            {Type:"Text",       Hidden:1,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no" ,		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				              {Type:"Text",     Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"app_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
				             {Type:"Text",      Hidden:0,  Width:40,    Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  	Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no_chg" ,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:0,   SaveName:"pol_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"tvvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	       
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(100);
				SetCountPosition(0);
	        }
			break;
			
		case 2:      //sheet1 init
		    with(sheetObj){
				var HeadTitle="Seq|Type|Lane|VVD|Load|ETD|Discharge|ETB" ;

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"vsl_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"vsl_pol_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120, Align:"Center",  ColMerge:0,   SaveName:"vsl_etd",         KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"vsl_pod_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"vsl_etb",         KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	       
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(100);
				SetCountPosition(0);
	        }
			break;
			
		case 3:      //sheet1 init
		    with(sheetObj){
				var HeadTitle="ERR|CNTR No.|TPSZ|R/Term|D/Term|CRNT YD|CRNT STS|EVENT DT|VOL|DG|RC|BB|AWK|RD|SOC|CFM|Lessor Code|Lessor|AGMT|" +
						"Term|On-Hire Date|On-Hire Yard|F/Days|Min On-hire Days|Current Status|" +
						"CRE USER|CRE DT|UPD USR|UPD DT" ;

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center", ColMerge:0,   	SaveName:"cntr_err_cnt" ,			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,   	SaveName:"cntr_no" ,				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center", ColMerge:0,   	SaveName:"cntr_tpsz_cd",   			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center", ColMerge:0,   	SaveName:"cntr_rcv_term_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center", ColMerge:0,   	SaveName:"cntr_de_term_cd",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cntr_crnt_yd_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center", ColMerge:0,      SaveName:"cntr_cnmv_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cntr_cnmv_dt",          	KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,   	SaveName:"cntr_vol_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,   	SaveName:"cntr_dcgo_flg",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,   	SaveName:"cntr_rc_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,   	SaveName:"cntr_bb_cgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,   	SaveName:"cntr_awk_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,      SaveName:"cntr_rd_cgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center", ColMerge:0,      SaveName:"soc",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center", ColMerge:0,      SaveName:"cntr_cfm_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center", ColMerge:0,      SaveName:"cntr_vndr_seq",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cntr_vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center", ColMerge:0,      SaveName:"cntr_agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center", ColMerge:0,      SaveName:"cntr_lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center", ColMerge:0,      SaveName:"cntr_onh_dt",    			KeyField:0,   CalcLogic:"",   Format:"YmdHm",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center", ColMerge:0,      SaveName:"cntr_onh_yd_cd",    		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center", ColMerge:0,      SaveName:"cntr_used_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cntr_min_onh_dys", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cntr_sts_cd",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cre_usr_id",     	    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"cre_dt",       		    KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"upd_usr_id",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center", ColMerge:0,      SaveName:"upd_dt",       		    KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetEditable(0);			
				SetSheetHeight(100);
	        }
			break;
		case 4:      //sheet7 init
     	    with(sheetObj){
	               var HeadTitle="|DEL|SEL|CNTR No.|Receive DT|Input|Result|Result Message|STS|A/F|Origin YD" +
	               		"|Event Date|CYC|Booking No.|Return YD|Reference NO|F/M|OB|Seal|MTY REPO NO|CHSS NO|MGST NO|EDI BKG NO|OSCA FLG|VVD Code" +
	               		"|CGO TP|I/O" +
	               		"|CNTR STS|EDI SGHT|Callsign|Retry" +
	               		"|Vendor|BKG KNT|DM|LLOYD NO|WO NO|EDI VVD CD" +
	               		"|TIR NO|MTY PLN NO|TRSP DOC NO|EDI CRR NO|CRNT VSL CD|CRNT SKD VOY NO|CRNT SKD DIR CD|CNMV RMK" +
	               		"|MVMT EDI MSG AREA CD|MVMT EDI MSG SEQ|MVMT EDI MSG TP ID|MVMT EDI MSG YRMONDY|MVMT EDI TP CD " +
	               		"|MVMT TRSP MOD CD|OFC CD|UPD USR ID|CRE USR ID|CHK FLG";
	              
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               
	               var cols = [ 
	                      {Type:"Status",    Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },     
	                      {Type:"Text", 	 Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delcheck" },
	                      {Type:"Text", 	 Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },	                      
	                      {Type:"Text",    	 Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inp_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inp_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"status",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:7 , AcceptKeys:"E|N", InputCaseSensitive:1 },
	                      {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",         KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,EditLen:7 , AcceptKeys:"E|N", InputCaseSensitive:1 },
	                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",   ColMerge:0,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	                     
	                      {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"fcntr_flg",  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"ob_cntr_flg",       KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	                      
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mty_pln_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	                      
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"chss_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mgst_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"osca_bkg_flg",        KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"bkg_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_sts_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_sght_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"call_sgn_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"rty_knt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"bkg_knt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"cntr_dmg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"lloyd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"edi_vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"tir_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mty_repo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"trsp_doc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"edi_crr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	                      
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"crnt_vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"crnt_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"crnt_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"cnmv_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_edi_msg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_edi_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"chk_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  	ColMerge:0,   SaveName:"h_save" },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_onh_yd_cd" },
	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cntr_sts_cd" },
				          {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cnmv_evnt_dt" },
				          {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"usr_nm" },
				          {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnmv_rmk" },
				          {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
				          {Type:"Int",       Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnmv_seq" },
				          {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" }]
	               InitColumns(cols);
	               //SetEditable(0);
	               SetColProperty("fcntr_flg", {ComboText:"M|F", ComboCode:"N|Y"} );
	               SetColProperty("ob_cntr_flg", {ComboText:"I|O", ComboCode:"N|Y"} );
	               SetSheetHeight(300);
	               SetCountPosition(0);
              }
          break;
          
		case 5:      //sheet1 init
			with(sheetObj){                 
            var HeadTitle="CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|Booking No.|B/L No.|Reference No.|F/M|I/O|MSG|TP|DM|HR|HB|D|E|R|R|SP|S/P|S/P|RU Label Type|RU Label Value|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Office|User Name|Remark(S)";
            var sTipAF="";
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_co_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, },
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, ToolTipText:sTipAF },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_knt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Bound indicator"},
                   {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"[ Cargo type ] \nF: Full, P: Reposition, R: Revenue"},
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Damage, Y"},
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Hanger Rack, Y"},
                   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Hanger Bar"},
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Disposal Candidate, Y"},
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Immediate Exit, Y"},
                   {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Re-stuffing, F(From), T(To)"},
                   {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Re-furbishing, Y"},
                   {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Special, Y"},
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_nm_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_val_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                   {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                   {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                   {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"usr_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            InitColumns(cols);
            SetEditable(0);
            SetDataAutoTrim(1);
            SetSheetHeight(300);
            SetCountPosition(0);
            }
             break;
             
		case 6:    
			with(sheetObj){              
	        var HeadTitle="|Seq.|Result error message|Container No.|T/S|ORG YD|Event Date|Receiving Date|Booking No.|EDI Booking|B/L No.|VVD Code|Call sign/Lloyd|Seal No.|Chassis No.|M.G Set|S/P|Mode|LCC|RTN YD|POL|POD|STS|I/O|F/M|E/I|Retry|Remark(s)";
	        HeadTitle += "|crnt_vsl_cd|crnt_skd_voy_no|crnt_skd_dir_cd|call_sgn_no|lloyd_no|wbl_no|pkup_no|mvmt_edi_rslt_cd|mvmt_edi_msg_area_cd|mvmt_edi_msg_seq|mvmt_edi_msg_tp_id|mvmt_edi_msg_yrmondy|mvmt_edi_tp_cd|upd_flag";
	        HeadTitle += "|WO No.|EDI VVD Code|TIR No.|MTY PLN No.|MTY REPO No.|EDI CRR No.|TRSP DOC No.|FLT FILE REF No.";
	       

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	               {Type:"Text",       Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:499 },
	               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
	               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",               KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"edi_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_lloyd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_sght_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rty_knt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",       Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:499 },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_vsl_cd" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_voy_no" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd" },
	               {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no" },
	               {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lloyd_no" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
	               {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rslt_cd" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
	               {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy" },
	               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd" },
	               {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd_flag" },
	               {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wo_no" },
	               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"edi_vvd_cd" },
	               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tir_no" },
	               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no" },
	               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mty_repo_no" },
	               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_crr_no" },
	               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_doc_no" }, 
	               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"flt_file_ref_no" }];
	         
	               InitColumns(cols);

	              SetEditable(1);
	              SetDataAutoTrim(1);
	              
	              // upper case & numbers only
	              SetColProperty(0,"cntr_no",{AcceptKeys:"N|E" , InputCaseSensitive:1} );
	              SetColProperty(0,"bkg_no", {AcceptKeys:"N|E" , InputCaseSensitive:1});
	              SetColProperty(0,"vvd_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});
	              SetColProperty(0,"edi_mvmt_sts_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});
	              SetColProperty(0,"cntr_full_sts_cd",{AcceptKeys:"N|E" , InputCaseSensitive:1});
	              //SetWaitTimeOut(36000);
	              SetSheetHeight(300);
	              SetEditable(0);
	              SetCountPosition(0);
	              //resizeSheet();
				}
	              break;
		 case 7:      //sheet1 init
     	    with(sheetObj){
	               var HeadTitle="|Status|Date|Yard|AGMT No.|Contract No.|Lessor|Lessor Name|F/M|Pre Movement|DOC Charge|DOC Credit|Curr.|Handle On/Off Charge|DII/DIO Fee|Free Day|Pick Up Charge|Pick Up Credit|Term Change|Created Date|Updated Date|Created User|Updated User|Remark(s)";
	               var prefix="sheet1_";
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sheetStatus" },
	                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_cr_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_lft_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cntr_dir_itchg_fee_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rntl_chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_cr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"cntr_lstm_cng_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,    Align:"Center",    ColMerge:0,   SaveName:"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,    Align:"Center",    ColMerge:0,   SaveName:"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cntr_sts_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               InitColumns(cols);
	               SetEditable(0);
	               SetSheetHeight(300);
	               SetCountPosition(0);
              }
          break;
          
		 case 8:      //sheet7 init
	     	    with(sheetObj){
					 var HeadTitle="|CNTR No.|TP/SZ|Term|Lessor|Lessor Name|EQ\nStatus|EQ Status\nDate|EQ Status\nYard|F/M|MVMT\nStatus|MVMT Yard|MVMT Date|Remark(s)";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DummyCheck", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Sel" },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11},
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"full_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_onh_yd_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cntr_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_cnmv_evnt_dt" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_lst_sts_yd_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_lst_sts_seq" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk1" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk2" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_chk3" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"h_save" } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0, "cntr_rmk", {AcceptKeys:"E|[0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ]"});
				      SetSheetHeight(300);
				     // SetSheetHeight(390);
		           }
	          break;
	          
		 
		}
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
		sheetObj.ShowDebugMsg(false);
		isOpen=true;
	    switch(sAction) {
	       case IBSEARCH: // 메인 sheet 조회
	    	   if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	    	   ComBtnDisable("btn_save");
	    	   ComBtnDisable("btn_add");
	    	   ComBtnDisable("btn_delete");
	    	   ComBtnDisable("btn_downexcel");
	    	   
	    	   ComBtnDisable("btn_master");
	    	   $("#btn_master").css("background-color","#E0E0E0");
	    	   ComBtnDisable("btns_calendar1");
	    	   ComBtnDisable("ComOpenPopupWithTarget1");
	    	   ComBtnDisable("btn_save1");
	    	   ComBtnDisable("btn_save2");
	    	   //document.getElementById("btn_save2").style.
	    	   $("#btn_save2").css("background-color","#E0E0E0");
	    	   
	    	   ComBtnDisable("btn_cycle");
				$("#btn_cycle").css("background-color","#E0E0E0");
				ComBtnDisable("btn_ctn_status");
				$("#btn_ctn_status").css("background-color","#E0E0E0");
				
	    	   /*document.getElementById("input_cntr_sts_cd").className = "input2";
				document.getElementById("input_cntr_sts_cd").disabled=true;*/
	    	   document.getElementById("input_cntr_sts_evnt_dt2").className = "input2";				
	    	   document.getElementById("input_cntr_sts_evnt_dt2").disabled=true;
	    	   document.getElementById("input_onh_yd_cd").className = "input2";				
	    	   document.getElementById("input_onh_yd_cd").disabled=true;
				
	    	   ComOpenWait(true);
	    	   formObj.f_cmd.value=SEARCH;
	    	   var sXml=sheetObj.GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));            	
	    	   sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
	    	   break;
	    	   
	       case IBSEARCH01:
	    	   if(sheetObj.id == "sheet2") {
	    		   formObj.f_cmd.value=SEARCH01;
	    		   ComOpenWait(true);
	    		   var sXml=sheetObj.GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	    		   sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
	   		   }
	    	   break;
	    	   
	       case IBSEARCH02:
	    	   if(sheetObj.id == "sheet3") {
	    		   formObj.f_cmd.value=SEARCH02;
	    		   ComOpenWait(true);
	    		   var sXml=sheetObj.GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	    		   sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
	   		   }
	    	   break;
	    	   
	       case IBSEARCH03 :
	    	   if(strShtClick == true) { 
		    	   ComOpenWait(true);
		    	   var strCntrNo = formObj.h_cntrno.value;
		    	   formObj.check_digit.value = strCntrNo.substring(10,11);
		    	   formObj.p_cntrno.value = strCntrNo.substring(0,10);
		    	   
		    	   sheetObjects[4].RemoveAll();
		    	   sheetObjects[5].RemoveAll();
		    	   sheetObjects[6].RemoveAll();
		    	   //sheetObjects[4].RemoveAll();    	
					
		    	   /*formObj.f_cmd.value=SEARCH03;
	               var xml=sheetObjects[4].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	               var rtnValue=xml.split("|$$|");
	               sheetObjects[4].LoadSearchData(rtnValue[0],{Sync:0} );
	               
	               formObj.f_cmd.value=SEARCH04;
	               var xml=sheetObjects[5].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	               var rtnValue=xml.split("|$$|");
	               sheetObjects[5].LoadSearchData(rtnValue[0],{Sync:0} );
	               
	               formObj.f_cmd.value=SEARCH05;
	               var xml=sheetObjects[6].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	               var rtnValue=xml.split("|$$|");
	               sheetObjects[6].LoadSearchData(rtnValue[0],{Sync:0} );*/
	               
	               
	               formObj.f_cmd.value=SEARCH06;
	               var xml=sheetObjects[3].GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	               var rtnValue=xml.split("|$$|");
	               sheetObjects[3].LoadSearchData(rtnValue[0],{Sync:0} );
	    	   }
	    	   break;
	       case IBSEARCH06 :
				formObj.f_cmd.value=SEARCH06;
				var sel_row = sheetObjects[3].GetSelectRow();
				
				var yd_cd = sheetObjects[3].GetCellValue(sel_row,"dest_yd_cd",0);
				var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+yd_cd+"&yd_chk_flg=Y");
				
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
				}
				
            	var codestr=ComXmlString(sXml, "code_nm");
	            if (codestr == ""){
	            	
	            	sheetObjects[3].SetCellValue(sel_row,"dest_yd_cd","",0);
	            	ComShowCodeMessage("CIM30013", "VVD Code");
	            	return false;
	            } else {
	            	sheetObjects[3].SetCellValue(sel_row,"dest_yd_cd",codestr);;
	            }
	            break;            
	       case IBSAVE:        //Save
	    	   if(initFlag == 1) {
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					
					formObj.f_cmd.value=MULTI;
					
					for(var i=0;i<=sheetObjects[3].LastCol();i++) {	       				
	       				if((sheetObjects[3].GetCellValue(i,"ibflag")=="U" || sheetObjects[3].GetCellValue(i,"ibflag")=="I")
	       						&& sheetObjects[3].GetCellValue(i,"bkg_no") == ""
	       					    && (sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "OP"
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "OC"
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "VL"	
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "VD"	
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "IC"	
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "ID"	
	       					        ||sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "TS"		       					        	
	       				   )) {
	       					ComShowCodeMessage("CIM30013", "BKG NO");
	       					ComOpenWait(false);
	       					return false;
	       				}
	       			}
					
					var sXml=sheetObj.DoSave("EES_CIM_2001GS.do", FormQueryString(formObj));			
					ComOpenWait(false);
	    	   }else if(initFlag == 2) {
	    		   if(!validateChkForm(sheetObj,formObj,sAction)) {
						return false;
					}
	       			sheetObjects[7].DataInsert(-1);
	       			var colName = "";
	       			for(var i=0;i<=sheetObjects[3].LastCol();i++) {	       				
	       				if(sheetObjects[3].ColSaveName(i) == "cntr_no") {
	       					sheetObjects[7].SetCellValue(1,"cntr_no",sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"cntr_no"));
	       				}
	       			}
					for(var i=1; i<sheetObjects[7].RowCount()+1; i++){
						sheetObjects[7].SetCellValue(i,"h_save","1",0);
						sheetObjects[7].SetCellValue(i,"cntr_rmk","",0);
						sheetObjects[7].SetCellValue(i,"h_onh_yd_cd",formObj.input_onh_yd_cd.value);
						sheetObjects[7].SetCellValue(i,"h_cnmv_evnt_dt",formObj.input_cntr_sts_evnt_dt2.value);
						sheetObjects[7].SetCellValue(i,"h_cntr_sts_cd",formObj.input_cntr_sts_cd.value);
					}
					formObj.f_cmd.value=SEARCH;
					var sParam1=sheetObjects[7].GetSaveString();
					if (sheetObjects[7].IsDataModified()&& sParam1 == "") return;
					formObj.input_cntr_sts_evnt_dt.value=ComReplaceStr(ComGetObjValue(form.input_cntr_sts_evnt_dt2), "-", "");
					sheetObjects[7].DoSearch("EES_MST_0025GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString(true) );
					 
	    	   }else if(initFlag == 3) {
	    		    sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					
					formObj.f_cmd.value=MULTI01;
					
					var sXml=sheetObj.DoSave("EES_CIM_2001GS.do", FormQueryString(formObj));			
					ComOpenWait(false);
	    	   }
			   break;
				
	       case IBINSERT: 
	    	   var sel_row = sheetObjects[3].GetSelectRow();
	    	   var sel_col = sheetObjects[3].GetSelectRow();
	    	   var sel_insert = sel_row + 1;
	    	   sheetObjects[3].DataInsert(sel_insert,"");
	    	   sheetObjects[3].SetEditable(1);
	    	   
	    	   for(var i=0;i<=sheetObj.LastCol();i++) {
	    		   sheetObjects[3].SetCellEditable(sel_insert, i, 1)
	    	   }
	    	   
	    	   var row_date = sheetObjects[3].GetCellValue(sel_row,"cnmv_evnt_dt");
	    	   
	    	   
	    	   var sYear="";
	    	   var sMonth="";
	    	   var sDay="";
	    	   var shours="";
	    	   var sminutes="";
	    	   var minutes="";
		   	   var hours="";
		   	   var day="";
		   	   var month="";
		   	   var year="";
	    	   
	    	   sYear = row_date.substring(0,4);
	    	   sMonth = row_date.substring(4,6);
	    	   if(sMonth < 10) {
	    		   sMonth = Number(sMonth.substring(1,2))-1;
	    		   sMonth = "0"+sMonth;
	    	   }else{
	    		   sMonth = Number(sMonth)-1;
	    	   }	    	   
	    	   sDay = row_date.substring(6,8);
	    	   shours = row_date.substring(8,10);
	    	   if(shours < 10) {
	    		   shours = Number(shours.substring(1,2))+1;
	    		   shours = "0"+shours;
	    	   }else{
	    		   shours = Number(shours)+1;
	    	   }
	    	   
	    	   sminutes = row_date.substring(10,12);	    	   
		   	   strTime=new Date(sYear,sMonth,sDay,shours,sminutes,0); 
		   	    
		   	   minutes=strTime.getMinutes();
		   	   hours=strTime.getHours();
		   	   day=strTime.getDate();
		   	   month=strTime.getMonth();
		   	   month = Number(month) + 1;
		   	   year=strTime.getFullYear();
		   	   
		   	   if (month < 10) {
		   		   month="0" + Number(month);
		   	   }else{
		   		   month=Number(month);
		   	   }
		   	   
		   	   if (day < 10) day="0" + day;		   	    	   	    
		   	   row_now_day=""+year+""+month+""+day;
		   	   if (minutes < 10)	minutes="0" + minutes;
		   	   if (hours < 10)		hours="0" + hours;
		   	   
		   	   row_now_time=""+hours + "" + minutes;
		   	   row_now_date=""+row_now_day + "" +row_now_time;
		   	   sheet4_style_change(sheetObjects[3],sel_insert,"Add");
		   	   ComBtnEnable("btn_save");
			   break;
	       case IBDELETE:   
	    	   var btnYN = false;
	    	   for(var i=sheetObjects[3].RowCount(); i>=0; i--){ // RowDelete
					if(sheetObjects[3].GetCellValue(i,"ibflag")=="I" && sheetObjects[3].GetCellValue(i,"delcheck") == "1"){
	                   sheetObjects[3].RowDelete(i, false);
	               }
					
					if((sheetObjects[3].GetCellValue(i,"inp_tp_cd") == "EDI" || sheetObjects[3].GetCellValue(i,"inp_tp_cd") == "IEM") && sheetObjects[3].GetCellValue(i,"delcheck") == "1"){
						//sheetObjects[3].RowDelete(i, false);
						sheetObjects[3].SetRowHidden(i,1);
						sheetObjects[3].SetRowStatus(i,"D");
						btnYN = true;
					}
					
					if(sheetObj.GetCellValue(i,"status") == "O.K" && sheetObjects[3].GetCellValue(i,"delcheck") == "1"){
						sheetObjects[3].SetRowHidden(i,1);
						sheetObjects[3].SetRowStatus(i,"D");
						btnYN = true;
					}
					
					if(sheetObj.GetCellProperty(i, "ibcheck", "Type") == "DummyCheck" || sheetObj.GetCellProperty(i, "delcheck", "Type") == "DummyCheck") {
						btnYN = true;
					}
					
					if(btnYN == true) {
						ComBtnEnable("btn_save");
					}else{
						ComBtnDisable("btn_save");
					}
               }
	    	  
			   break;
			   
	       case IBSEARCH04 :
				if (formObj.input_onh_yd_cd.value != ""){
					formObj.f_cmd.value=SEARCH06;
					var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.input_onh_yd_cd.value+"&yd_chk_flg=N");
					var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR")!= -1 || sXml.indexOf("Error")!= -1){
					   sheetObj.LoadSearchData(sXml,{Sync:1} );
					   return;
					}
			    	var codestr=ComXmlString(sXml, "code_nm");
			    	if (codestr == "" && formObj.input_onh_yd_cd.value != ""){
			    		ComShowCodeMessage("CIM30013", formObj.input_onh_yd_cd.value);
			    		formObj.input_onh_yd_cd.value="";
			    		formObj.yd_cd_nm.value="";
			    		ComSetFocus(formObj.input_onh_yd_cd);
			    		return;
			    	} else {
			    		formObj.yd_cd_nm.value=codestr;
			    	}
				}
				break;	
	      
	       case IBSEARCH05:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30040';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:0} );
				   return;
			    }
				
				if (xml != "") {
					var strCode="";
					var strCodeNm="";
					var strAllCode="";
					var arrAllCode="";
					var arrStrCode=ComGetEtcData(xml, "code_nm");
					var arrCode = arrStrCode.split("@");
					var vChgTypes = "";
					var vChgCdNmTypes = "";
					for(var i=0;i<arrCode.length;i++) {						
						strAllCode = arrCode[i].split("@");
						for(var j=0;j<strAllCode.length;j++) {
							arrAllCode = strAllCode[j].split("|");
							strCode = arrAllCode[0];
							strCodeNm = arrAllCode[1];
							
							if(i == 0) {
								vChgTypes =  strCode;
								vChgCdNmTypes =  strCodeNm; 
							}else{
								vChgTypes = vChgTypes + "|" + strCode; 
								vChgCdNmTypes = vChgCdNmTypes + "|" + strCodeNm; 
							}
							
						}
					}
					
					for(var i=1;i<=sheetObjects[0].RowCount();i++) {
		    			if(sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9999" || sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9998") {
		    				sheetObjects[0].InitCellProperty(i, "cnmv_cyc_no_chg", {
		    					Type : "Combo" , Edit:1 , ComboCode:vChgTypes, ComboText:vChgCdNmTypes
		    				});
		    				
		    				if(sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9999") sheetObjects[0].SetCellValue(i,"cnmv_cyc_no_chg","Target")
		    				if(sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "9998") sheetObjects[0].SetCellValue(i,"cnmv_cyc_no_chg","Hold")
		    				//if(sheetObjects[0].GetCellValue(i,"cnmv_cyc_no") == "1") sheetObjects[0].SetCellValue(i,"cnmv_cyc_no_chg","Hold")
		    				sheetObjects[0].SetCellValue(i,"cntr_no",formObj.s_cntr_no.value);
		    				ComBtnEnable("btn_save2");
		    				$("#btn_save2").css("background-color","#27415d");
		    			}
		    		}
				}
				break;
	    }
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateChkForm(sheetObj,formObj,sAction) {
		with(formObj) {
    		switch(sAction) {
    			case IBSAVE: 
    				if(sheetObjects[3].RowCount() > 0) {
    					if(formObj.input_cntr_sts_evnt_dt2.value == "") {
            				ComShowCodeMessage("CIM30013","Date");
            				formObj.input_cntr_sts_evnt_dt2.focus();
            				return false;
            			}
    					
    					if(ComGetDaysBetween(ComGetNowInfo(), formObj.input_cntr_sts_evnt_dt2) > 0){			
    						ComShowCodeMessage("CIM30028", "Date");			
    						formObj.input_cntr_sts_evnt_dt2.value="";
    						formObj.input_cntr_sts_evnt_dt.value="";
    						return false;
    					}
    					
    					if(formObj.input_onh_yd_cd.value == "") {
            				ComShowCodeMessage("CIM30013","Yard");
            				formObj.input_onh_yd_cd.focus();
            				return false;
            			}
    					
    					
    				}else{
    					return false;
    				}
    				break;
				default :	//do nothing
    		}
    	}
        return true;
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		 with(formObj) {
	    		switch(sAction) {
	    			case IBSEARCH:
		    			 if (formObj.s_event_date1.value == "" || formObj.s_event_date2.value == "") {
		 					ComShowCodeMessage("CIM21001", "MVMT Event Date");
		 					return;
		 				} 
		 	    	   
		 	    	   if (ComGetUnMaskedValue(formObj.s_event_date1.value, 'ymd') > ComGetUnMaskedValue(formObj.s_event_date2.value, 'ymd')) {
		                    ComShowCodeMessage("CIM21001", "MVMT Event Date");
		                    return;
		                }
		    			break;
	    			case IBSAVE: 
	    				for(var i=1;i<=sheetObjects[3].RowCount();i++) {
	    					if(sheetObj.GetCellValue(i,"ibcheck") == 1) {
		            			if(sheetObjects[3].GetCellValue(i,"mvmt_sts_cd") == "") {
		            				ComShowCodeMessage("CIM30013","MVMT STS CD");
		            				return false;
		            			}
		            			
		            			if(sheetObjects[3].GetCellValue(i,"org_yd_cd") == "") {
		            				ComShowCodeMessage("CIM30013","ORG YD CD");
		            				return false;
		            			}
		            			
		            			if(sheetObjects[3].GetCellValue(i,"cnmv_evnt_dt") == "") {
		            				ComShowCodeMessage("CIM30013","CNMV EVNT DT");
		            				return false;
		            			}
		            			
		            			// Same Evnet Date 체크
		            			for(var k=1;k<=sheetObjects[3].RowCount();k++) {
		            				if(sheetObjects[3].GetCellValue(k,"ibflag") != "D") {
			            				if((sheetObjects[3].GetCellValue(i,"cnmv_evnt_dt") == sheetObjects[3].GetCellValue(k,"cnmv_evnt_dt")) && (i!=k)) {
			            					//ComShowCodeMessage("CIM30029");
			            					//return false;		            	
			            				}
		            				}
		            			}
		            			
		            			if(sheetObjects[3].GetCellValue(i,"org_yd_cd") != "") {
			            			var yard_cd = sheetObjects[3].GetCellValue(i,"org_yd_cd");
			        	    		var param="f_cmd="+SEARCH+"&node_cd="+yard_cd + "&mode=yard";
			        	    		
			        	    		sheetObjects[3].SetWaitImageVisible(0);
			        				var sXml=sheetObjects[3].GetSearchData("COM_ENS_061GS.do",param);
			        				sheetObjects[3].SetWaitImageVisible(1);
			        				if ( ComGetTotalRows(sXml) == 1 ) {
			        				} else {				
			        					ComShowCodeMessage("CIM29021");
			        					sheetObjects[3].SetCellValue(i,"org_yd_cd","");
			        					return false;
			        				}
		            			}
	    					}
	    					
	    					if(sheetObjects[3].GetCellValue(i,"ibflag")=="I"){
	    						if(sheetObjects[3].GetCellValue(i,"cntr_no") == "") {
		            				ComShowCodeMessage("CIM30013","CNTR NO");
		            				return false;
		            			}
	    						
	    						if(sheetObjects[3].GetCellValue(i,"inp_dt") == "") {
		            				ComShowCodeMessage("CIM30013","INP DT");
		            				return false;
		            			}
		            			
	    					}
	            		}	    				
	    				break;
					default :	//do nothing
	    		}
	    	}
	        return true;
	}
    
    
    /**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var strDataChk = false;
    	if(sheetObjects[0].RowCount() > 0) {
    		var sch_bkgno = form.s_bkg_no.value;
    		var sheetObj = sheetObjects[0];
    		if(sch_bkgno == "") {
    			sheetObjects[0].SelectCell(sheetObjects[0],1, 0);
        		var sel_row = sheetObjects[0].GetSelectRow();
        		var sel_col = sheetObjects[0].GetSelectCol();
        		
        		sheet1_OnClick(sheetObj, sel_row, sel_col , true);
        		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
        		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF")
        		strDataChk = true;
    		}else{
    			for(var i=1;i<=sheetObj.RowCount()+1;i++) {
        			
        			if(sheetObj.GetCellValue(i,"bkg_no") == sch_bkgno) {
        				sheetObj.SetSelectRow(i, 1);
        				sheet1_OnClick(sheetObj, i, 0, true);
        				sheetObj.SetRangeFontBold(i, 0, i, sheetObj.LastCol(), 1);
        				sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(), "0000FF")
        				strDataChk = true;
        			}
        		}
    		}
    		
    		for(var i=1;i<=sheetObj.RowCount()+1;i++) {
    			if(sheetObj.GetCellValue(i,"app_cd") == "OPUS") {
    				sheetObj.SetColFontColor("bkg_no","#0000FF");
    				sheetObj.SetColFontUnderline("bkg_no",1);
    				sheetObj.SetDataLinkMouse("bkg_no",1);
    			}
    		}
    		
    		
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH05);   	
    		
        	if(strDataChk == false) {
        		sheet1.RemoveAll();
    			sheet2.RemoveAll();
    			sheet3.RemoveAll();
    			sheet4.RemoveAll();
    			sheet5.RemoveAll();
    			sheet6.RemoveAll();
    			sheet7.RemoveAll();
        	}    		
    	} else {
    		sheet1.RemoveAll();
			sheet2.RemoveAll();
			sheet3.RemoveAll();
			sheet4.RemoveAll();
			sheet5.RemoveAll();
			sheet6.RemoveAll();
			sheet7.RemoveAll();    		
			document.form.h_cntrno.value=document.form.o_cntr_no.value;
			doActionIBSheet(sheetObj,document.form,IBSEARCH03);
			ComBtnDisable("btn_save");	   		
    	}
    	
    	ComOpenWait(false);
    }
    
    
   /* *//**
     * IBSeet Event - cell double click <br>
     * 
     * @param {sheetObj} String 
     * @param {Row} Long : Row Index
     * @param {Col} Long : Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : X
     * @param {CellY} Long : Y
     * @param {CellW} Long : wide
     * @param {CellH} Long : height
     *//*
    function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){
    		var h_bkg_no=sheetObj.GetCellValue(Row, "bkg_no");
    		document.form.h_bkg_no.value=h_bkg_no;
    		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH01);
    		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH02);
    	}
    }*/
    
    function sheet1_OnClick(sheetObj, Row, Col, Value, shtclick) {
    	//if(strMinimizeYN == true) {
	    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
	    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000")
	    	if ( Row == 0  ) return;
	    	if( sheetObj.RowCount()> 0 ){
	    		var h_bkg_no=sheetObj.GetCellValue(Row, "bkg_no");
	    		//if(sheetObj.ColSaveName(Col) != "cnmv_cyc_no_chg" && sheetObj.ColSaveName(Col) != "bkg_no") {	
	    		if(sheetObj.ColSaveName(Col) != "cnmv_cyc_no_chg") {
		    		document.form.h_bkg_no.value=h_bkg_no;
		    		if(shtclick == true || shtclick == undefined) {
		    			strShtClick = true
		    		}else{
		    			strShtClick = false;
		    		}
		    		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH01);
		    		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH02);
		    		
		    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
		    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF")
	    			
	    		}
	    	}
    	//}
    }
    
    function sheet4_OnMouseDown(sheetObj, Button, Shift, X, Y) {
    	if(sheetObjects[3].MouseRow() == 0 && sheetObjects[3].MouseCol() == 11) {
    		if(SortInfo == "DESC") {
    			sheetObjects[3].ColumnSort("cnmv_seq|cnmv_evnt_dt", "ASC");
    			SortInfo = "ASC";
    		}else{
    			sheetObjects[3].ColumnSort("cnmv_seq|cnmv_evnt_dt", "DESC");
    			SortInfo = "DESC";
    		}
    	}
    }

	/**
	 * handling double click event on sheet<br>
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	    /*var SaveName=sheetObj.ColSaveName(Col);
	    if (SaveName != "bkg_no") return;
	    if(sheetObj.GetCellValue(Row, "app_cd") == "OPUS"){
		    var bkgNo=sheetObj.GetCellValue(Row, SaveName);
		    var param="?bkg_no="+ bkgNo + "&isPop=N" + "&pgmNo=ESM_BKG_0079_Q_POP";
		    ComOpenPopup("/opuscntr/ESM_BKG_0079_Q_POP.do" + param, 1208, 730, "", "0,1");	    	
	    }*/
	}
	
	
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
  		if ( ErrMsg == "" ) {
  			ComShowCodeMessage("CIM30025");
  		}
  		 
  		if(strMinimizeYN == false) {
			sheet_Change();
		}
		tabObjects[0].SetSelectedIndex(0);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		
  		ComOpenWait(false);
    }
    
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF")
		ComOpenWait(false);
    }
    
    
    function sheet2_OnClick(sheetObj, Row, Col, Value) {    	
    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000")
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){    		
    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF")
    	}
    }
    
    
/*    *//**
     * IBSeet Event - cell double click <br>
     * 
     * @param {sheetObj} String 
     * @param {Row} Long : Row Index
     * @param {Col} Long : Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : X
     * @param {CellY} Long : Y
     * @param {CellW} Long : wide
     * @param {CellH} Long : height
     *//*
    function sheet3_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){
    		var h_cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
    		document.form.h_cntrno.value=h_cntr_no;
    		tabObjects[0].SetSelectedIndex(1);
    		doActionIBSheet(sheetObj,document.form,IBSEARCH03);
    	}
    }*/

    
    function sheet3_OnClick(sheetObj, Row, Col, Value) {
    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000")
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){
    		var h_cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
    		document.form.h_cntrno.value=h_cntr_no;
    		tabObjects[0].SetSelectedIndex(0);
    		strShtClick = true;
    		doActionIBSheet(sheetObj,document.form,IBSEARCH03);
    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF")
    		
    		ComBtnDisable("btn_save");
    	}
    }
    
    
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
    	if(sheetObjects[2].RowCount() > 0) {
    		sheetObjects[2].SelectCell(sheetObjects[2],1, 0);
    		var sel_row = sheetObjects[2].GetSelectRow();
    		var sel_col = sheetObjects[2].GetSelectCol();
    		var sch_cntr = form.s_cntr_no.value;
    		var sheetObj = sheetObjects[2];
    		var strChk = false;
    		tabObjects[0].SetSelectedIndex(0);
    		
			for(var i=1;i<=sheetObj.RowCount()+1;i++) {
				sheetObjects[3].SetCellValue(i,"h_save","0",0);
				if(sheetObj.GetCellValue(i,"cntr_no") == sch_cntr) {
					strChk = true;
    				form.h_cntrno.value = sheetObjects[2].GetCellValue(i,"cntr_no");
    				sheetObj.SetSelectRow(i, 1);
    				sheetObj.SetRangeFontBold(i, 0, i, sheetObj.LastCol(), 1);
    				sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(), "0000FF")
    				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
				}
			}
			
			if(strChk == false){
				form.h_cntrno.value = sheetObjects[2].GetCellValue(sel_row,"cntr_no");
				sheetObj.SetSelectRow(sel_row, 1);
				sheetObj.SetRangeFontBold(1, 0, 1, sheetObj.LastCol(), 1);
				sheetObj.SetRangeFontColor(1, 0, 1, sheetObj.LastCol(), "0000FF")
				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
			}
			
			for(var i=1;i<=sheetObjects[3].RowCount()+1;i++) {
				sheetObjects[3].SetRowStatus(i,"R");
			}
			sheetObjects[7].RemoveAll();
			formObj.input_cntr_sts_evnt_dt2.value = "";
    		formObj.input_onh_yd_cd.value = "";
    		formObj.yd_cd_nm.value = "";
			
			ComBtnEnable("btn_cycle");
			$("#btn_cycle").css("background-color","#27415d");
			ComBtnEnable("btn_ctn_status");
			$("#btn_ctn_status").css("background-color","#27415d");
    		
    	}
    	
    	ComOpenWait(false);
    }
    
    function sheet4_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
    	if( sheetObj.RowCount()> 0 ){    
    		arr_bkg_no = "";
    		arr_cyc_no = "";
    		for(var i=sheetObjects[0].RowCount();i>=1;i--) {
    			arr_bkg_no = "|"+sheetObjects[0].GetCellValue(i,"bkg_no")+arr_bkg_no ;
    			arr_cyc_no = "|"+sheetObjects[0].GetCellValue(i,"cnmv_cyc_no")+arr_cyc_no;
    		}
    		
    		arr_bkg_no = arr_bkg_no + "|" + "New Input"
    		
    		formObj.f_cmd.value=SEARCH11;
			sXml_3=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
			if ( sXml_3 != "" ) {
            	vCnmvStsCd=ComGetEtcData(sXml_3, "mvmt_sts_cd");
            }
	        
    		for(var i=1;i<=sheetObj.RowCount()+1;i++) {
	    		if(sheetObj.GetCellValue(i,"status") == "ERROR") {
	    			sheetObj.SetRangeFontBold(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);
	    			sheetObj.SetRangeBackColor(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FEE8E2");
	    			sheetObj.SetRangeFontColor(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FF0000");
	    			
	    			
	    		}else{
	    			sheetObj.SetRangeFontBold(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
	    			sheetObj.SetRangeBackColor(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FFFFFF");
	    			sheetObj.SetRangeFontColor(i, 0, sheetObj.LastRow(), sheetObj.LastCol(), "#000000");
	    		}
	    		
	    		//################ 시트 변경 및 버튼 활성화#########################//
	    		if(sheetObj.GetCellValue(i,"chk_flg") == "Y" || sheetObj.GetCellValue(i,"status") == "O.K") {
	    			sheetObj.InitCellProperty(i, "ibcheck", {
	    				Type : "DummyCheck" , Edit:1 
	    			});
	    		}else{
	    			sheetObj.InitCellProperty(i, "ibcheck", {
	    				Type : "Text" , Edit:0 
	    			});
	    		}
	    		
	    		if((sheetObj.GetCellValue(i,"inp_tp_cd") == "EDI" || sheetObj.GetCellValue(i,"inp_tp_cd") == "IEM") && sheetObj.GetCellValue(i,"status") == "ERROR"){
	    			sheetObj.InitCellProperty(i, "delcheck", {
						Type : "DummyCheck" , Edit:1 
					});
	    		}else{
		    		sheetObj.InitCellProperty(i, "delcheck", {
						Type : "Text" , Edit:0 
					});
	    		}
	    		
	    		
	    		if(sheetObj.GetCellValue(i,"status") == "O.K"){
	    			sheetObj.InitCellProperty(i, "delcheck", {
						Type : "DummyCheck" , Edit:1 
					});
	    		}
	    		
	    		//A/F가 E인 경우 Del, Sel 체크 풀어라
	    		if(sheetObj.GetCellValue(i,"mvmt_cre_tp_cd") == "E") {
	    			sheetObj.InitCellProperty(i, "delcheck", {
						Type : "Text" , Edit:0 
					});
	    			sheetObj.SetCellValue(i,"delcheck","",0);
	    			
	    			sheetObj.InitCellProperty(i, "ibcheck", {
	    				Type : "Text" , Edit:0 
	    			});
	    			sheetObj.SetCellValue(i,"ibcheck","",0);
	    		}
    		}
    		ComBtnEnable("btn_add");
    		ComBtnEnable("btn_delete");
    		ComBtnEnable("btn_downexcel");
    		
    		ComBtnEnable("btn_master");
    		$("#btn_master").css("background-color","#27415d");
    		
    		ComBtnEnable("btns_calendar1");
    		ComBtnEnable("ComOpenPopupWithTarget1");
    		ComBtnEnable("btn_save1");
    		
    		sheetObjects[7].RemoveAll();
    		formObj.input_cntr_sts_evnt_dt2.value = "";
    		formObj.input_onh_yd_cd.value = "";
    		formObj.yd_cd_nm.value = "";
    		
    		/*document.getElementById("input_cntr_sts_cd").className = "input1";
    		document.getElementById("input_cntr_sts_cd").disabled=false;*/
    		document.getElementById("input_cntr_sts_evnt_dt2").className = "input1";				
    		document.getElementById("input_cntr_sts_evnt_dt2").disabled=false;
    		document.getElementById("input_onh_yd_cd").className = "input1";				
    		document.getElementById("input_onh_yd_cd").disabled=false;
    		
    		SortInfo = "ASC";
    		sheetObj.SetSelectRow(sheetObj.RowCount());
    	}
		ComOpenWait(false);
    }
    
    function sheet4_OnSaveEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
  		save_flag=true;
  		if ( ErrMsg == "" ) {
  			var sel_row = sheetObjects[2].GetSelectRow();
    		var sel_col = sheetObjects[2].GetSelectCol();
    		
  			sheet3_OnClick(sheetObjects[2], sel_row, sel_col, "");
  		}
  		
  		ComOpenWait(false);
    }
    
    
    function sheet4_OnClick(sheetObj, Row, Col, Value) {
    	var colName = sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	
    	if(colName == "delcheck") {
    		if(sheetObj.GetCellProperty(Row, "delcheck", "Type") == "DummyCheck") {
    			if(sheetObj.GetCellValue(Row,"delcheck") == 1) {
    				//sheetObj.SetRowStatus(Row,"R");
    				
    				if(sheetObj.GetCellValue(Row,"ibcheck") == 1) {    	
    					sheetObj.SetRowStatus(Row,"R");
    					sheetObj.SetCellValue(Row,"ibcheck",0);
    				}
    				
    				if(!sheetObj.GetRowStatus(Row,"I")) {
	    				if(!ComShowCodeConfirm("CIM30031")){	    					
	    					sheetObj.SetCellValue(Row,"delcheck",0);
	    				}
    				}
    			}
			}
    	}
    	
    	if(colName == "ibcheck") {
    		if(sheetObj.GetCellProperty(Row, "ibcheck", "Type") == "DummyCheck") {
				sheetObj.SetCellValue(Row,"delcheck",0);
				
	    		var ibcheckYN = false;
	    		for(var i=1;i<=sheetObj.RowCount()+1;i++) {
	    			if(sheetObj.GetCellValue(i,Col) == 1) {
	    				ibcheckYN = true;
	    				break;
	    			}
	    		}
	    		
	    		if(ibcheckYN == true) {  
	    			ComBtnEnable("btn_save");
	    		}else{
	    			ComBtnDisable("btn_save");
	    		}
	    		
	    		//for(var i=1;i<=sheetObj.RowCount()+1;i++) {
	    			if(sheetObj.GetCellValue(Row,Col) == 1) {
	    				sheetObj.SetRowStatus(Row,"U");
	    			}else{
	    				if(sheetObj.GetCellProperty(Row, "delcheck", "Type") == "DummyCheck") {
	    					ComBtnEnable("btn_save");
	    				}
	    				
	    				if(sheetObj.GetRowStatus(Row) == "I") {
	    				}else{
	    					sheetObj.SetRowStatus(Row,"R");
	    				}
	    			}
	    		//}
	    		
	    		if(sheetObj.GetCellValue(Row,Col) == 1) {
	    			sheet4_style_change(sheetObj,Row,"Modify","1","#FAC194");
	    		}else{
	    			if(sheetObj.GetCellValue(Row, "status") == "O.K") {
	    				sheet4_style_change(sheetObj,Row,"Modify","0","#FFFFFF");
	    				sheetObj.SetRangeFontColor(Row, 0,Row , sheetObj.LastCol(), "#000000");
	    			}else{
		    			sheet4_style_change(sheetObj,Row,"Modify","0","#FEE8E2");
		    			sheetObj.SetRangeFontColor(Row, 0,Row , sheetObj.LastCol(), "#FF0000");
	    			}
	    		}
			}
		}
    	
    	var btnSaveYN = "N";
    	for(var i=1;i<=sheetObj.RowCount()+1;i++) {
    		if(sheetObj.GetRowStatus(i,"I") || sheetObj.GetRowStatus(i,"U")) {
    			btnSaveYN = "Y";
    		}
    	}
    	
		if(sheetObj.CheckedRows("delcheck") > 0 || sheetObj.CheckedRows("ibcheck") > 0) {
			ComBtnEnable("btn_save");
		}else{
			if(btnSaveYN != "Y") {
				ComBtnDisable("btn_save");
			}
		}
    }
    
    
    
    function sheet4_style_change(sheetObj,Row,Type,UseYN,Color)  {    	
    	
    	if(Type == "Modify") {
    		if(sheetObj.GetCellProperty(Row, "ibcheck", "Type") == "DummyCheck") {
    			var colName = ""
				for(var i=0;i<=sheetObj.LastCol();i++) {
					colName = sheetObj.ColSaveName(i);
					if(colName == "ref_no" ||
							colName == "cntr_seal_no" ||
							colName == "wo_no" ||
							colName == "tir_no" ||
							colName == "mty_pln_no" ||
							colName == "mty_repo_no" ||
							colName == "trsp_doc_no" ||
							colName == "dest_yd_cd" ||
							colName == "cnmv_rmk" || 
							colName == "vvd_cd"
							) {
						sheetObj.InitCellProperty(Row,colName, {
							Type : "Text" , Edit:UseYN 
						});
					}
					
					if(colName == "fcntr_flg") {
						var strFcntrFlg = sheetObj.GetCellValue(Row,"fcntr_flg");
						sheetObj.InitCellProperty(Row,colName, {
							Type : "Combo" ,Edit:UseYN , ComboText:"M|F", ComboCode:"N|Y"
						});
						
						sheetObj.SetCellValue(Row,"fcntr_flg",strFcntrFlg);
						sheetObj.SetCellBackColor(Row, colName, Color);
					}
					
					if(colName == "ob_cntr_flg" ) {
						var strObCntrFlg = sheetObj.GetCellValue(Row,"ob_cntr_flg");
						sheetObj.InitCellProperty(Row,colName, {
							Type : "Combo" ,Edit:UseYN , ComboText:"I|O", ComboCode:"N|Y"
						});
						sheetObj.SetCellValue(Row,"ob_cntr_flg",strObCntrFlg);
						sheetObj.SetCellBackColor(Row, colName, Color);
					}
				}
    			
    			/*if(sheetObj.GetCellValue(Row,"inp_tp_cd") == "EDI" || sheetObj.GetCellValue(Row,"inp_tp_cd") == "IEM"){
	    			sheetObj.InitCellProperty(Row, "delcheck", {
						Type : "DummyCheck" , Edit:1 
					});
	    		}else{
	    			sheetObj.InitCellProperty(Row, "delcheck", {
						Type : "Text" , Edit:0 
					});
	    		}*/
    			
    			sheetObj.InitCellProperty(Row, "delcheck", {
					Type : "DummyCheck" , Edit:1 
				});
    			
    			
    			var strBkgNo = sheetObj.GetCellValue(Row, "bkg_no");
    			//arr_bkg_no = arr_bkg_no + "|" + "New Input"
		    	sheetObj.InitCellProperty(Row, "bkg_no", {
					Type : "Combo" , Edit:UseYN , ComboCode:arr_bkg_no, ComboText:arr_bkg_no
				});
		    	sheetObj.SetCellValue(Row, "bkg_no", strBkgNo);
				sheetObj.SetCellBackColor(Row, "bkg_no", Color);
				
				var formObj = document.form;
				var sel_row = sheetObjects[0].GetSelectRow();
				formObj.h_bkg_no.value = strBkgNo;
				formObj.f_cmd.value=SEARCH01;
	 		    var sXml=sheetObj.GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	 		    var cols=ComCimXml2ComboString(sXml, "vsl_vvd", "vsl_vvd", "\t");
	 		   var strText = "";
	 		    if(cols[0] != "" && cols[0] != undefined) {
	 		    	strText = cols[0].substring(0,cols[0].length-1);
	 		    	
		 		    sheetObj.InitCellProperty(Row, "vvd_cd", {
			    				Type : "Combo" , Edit:1 , ComboText:strText, ComboCode: strText
			    			});
		 		   
		 		   var arrText = strText.split("|");
		 		   
		 		   for(var i=0; i<arrText.length; i++) {
		 			  if(arrText[i] != "") {
		 				 
		 				  sheetObj.SetCellValue(Row, "vvd_cd",arrText[i]);
		 				  sheetObj.SetCellValue(Row, "crnt_vsl_cd",arrText[i].substring(0, 4));
		 				  sheetObj.SetCellValue(Row, "crnt_skd_voy_no",arrText[i].substring(4, 8));
		 				  sheetObj.SetCellValue(Row, "crnt_skd_dir_cd",arrText[i].substring(8, 9));
		 				  
		 				  
		 				 
		 				  break;
		 			  }
		 		   
		 			 var strCnmvCycNo = "";
		 			var strCgoTpCd = "";
			 		   var strStsCd = "";
			 		  for(var j=1; j<sheetObjects[0].RowCount()+1; j++) {
			 			  if(sheetObjects[0].GetCellValue(j,"bkg_no") == sheetObj.GetCellValue(Row,"bkg_no")) {
			 				 sheetObj.SetCellValue(Row, "bkg_cgo_tp_cd",sheetObjects[0].GetCellValue(j,"bkg_cgo_tp_cd"));
			 				 sheetObj.SetCellValue(Row, "cnmv_cyc_no",sheetObjects[0].GetCellValue(j,"cnmv_cyc_no"));
			 				 
			 				strCgoTpCd = sheetObjects[0].GetCellValue(j, "bkg_cgo_tp_cd");
			 				  strStsCd = sheetObj.GetCellValue(Row, "mvmt_sts_cd");
			 				  if(strCgoTpCd == "F") {
			 					 sheetObj.SetCellValue(Row, "fcntr_flg","Y");
			 				  }else{
			 					 sheetObj.SetCellValue(Row, "fcntr_flg","N"); 
			 				  }
			 				  
			 				 if(strStsCd == "OP" || strStsCd == "OC" || strStsCd == "VL") {
			 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","Y");
			 				  }else{
			 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","N"); 
			 				  }
			 			  }
			 		  }
		 		   }
		 		   
	 		    }
				
		
				if ( sXml_3 != "" ) {
					sheetObj.InitCellProperty(Row, "mvmt_sts_cd", {
						Type : "Combo" , Edit:UseYN , ComboCode:vCnmvStsCd, ComboText:vCnmvStsCd
					});
					sheetObj.SetCellBackColor(Row, "mvmt_sts_cd", Color);
				}
		
				sheetObj.InitCellProperty(Row, "org_yd_cd", {
					Type : "Text" , Edit:UseYN ,AcceptKeys : "E|N", InputCaseSensitive:1
				});
				sheetObj.SetCellBackColor(Row, "org_yd_cd", Color);
	
				sheetObj.InitCellProperty(Row, "cnmv_cyc_no", {
					Type : "Text" , Edit:UseYN ,AcceptKeys : "E|N", InputCaseSensitive:1
				});
				sheetObj.SetCellBackColor(Row, "cnmv_cyc_no", Color);				
				
				sheetObj.InitCellProperty(Row, "cnmv_evnt_dt", {
					Type : "Date" , Edit:UseYN ,  Format:"YmdHm"
				});
				
				sheetObj.InitCellProperty(Row, "dest_yd_cd", {
					Type : "Text" , Edit:UseYN ,AcceptKeys : "E|N", InputCaseSensitive:1
				});
				sheetObj.SetCellBackColor(Row, "cnmv_evnt_dt", Color);
    		}
    	}else{
			var sel_row = sheetObjects[2].GetSelectRow();
			sheetObj.SetCellValue(Row,"cntr_no", document.form.h_cntrno.value),0;
			sheetObj.SetCellValue(Row,"inp_tp_cd", "MANUAL",0);
			sheetObj.SetCellValue(Row,"status", "O.K",0);
			sheetObj.SetCellValue(Row,"ofc_cd", form.office_cd.value,0);
			sheetObj.SetCellValue(Row,"upd_usr_id", form.usr_id.value,0);
			sheetObj.SetCellValue(Row,"cre_usr_id", form.usr_id.value,0);
			
			sheetObj.SetCellValue(Row,"cnmv_evnt_dt", row_now_date,0);
			
			sheetObj.SetCellValue(Row,"bkg_no", sheetObj.GetCellValue(Row-1,"bkg_no")),0;
			sheetObj.SetCellValue(Row,"cnmv_cyc_no", sheetObj.GetCellValue(Row-1,"cnmv_cyc_no"),0);			
			sheetObj.SetCellValue(Row,"fcntr_flg", sheetObj.GetCellValue(Row-1,"fcntr_flg"),0);
			sheetObj.SetCellValue(Row,"ob_cntr_flg", sheetObj.GetCellValue(Row-1,"ob_cntr_flg"),0);
			sheetObj.SetCellValue(Row,"cntr_seal_no", sheetObj.GetCellValue(Row-1,"cntr_seal_no"),0);
			sheetObj.SetCellValue(Row,"bkg_cgo_tp_cd", sheetObj.GetCellValue(Row-1,"bkg_cgo_tp_cd"),0);
			
			
			
			if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "OP") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "OC",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "OC") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "VL",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "VL") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "VD",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "VD") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "IC",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "IC") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "ID",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "ID") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "MT",0);
			}else if(sheetObj.GetCellValue(Row-1,"mvmt_sts_cd") == "MT") {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "",0);
			}else {
				sheetObj.SetCellValue(Row,"mvmt_sts_cd", "",0);
			}
			
			
			var strCnmvCycNo = "";
 			var strCgoTpCd = ""; 
	 		   var strStsCd = "";
	 		  for(var j=1; j<sheetObjects[0].RowCount()+1; j++) {
	 			  if(sheetObjects[0].GetCellValue(j,"bkg_no") == sheetObj.GetCellValue(Row,"bkg_no")) {
	 				 sheetObj.SetCellValue(Row, "bkg_cgo_tp_cd",sheetObjects[0].GetCellValue(j,"bkg_cgo_tp_cd"));
	 				 sheetObj.SetCellValue(Row, "cnmv_cyc_no",sheetObjects[0].GetCellValue(j,"cnmv_cyc_no"));
	 				 
	 				strCgoTpCd = sheetObjects[0].GetCellValue(j, "bkg_cgo_tp_cd");
	 				  strStsCd = sheetObj.GetCellValue(Row, "mvmt_sts_cd");
	 				  if(strCgoTpCd == "F") {
	 					 sheetObj.SetCellValue(Row, "fcntr_flg","Y"); 
	 				  }else{
	 					 sheetObj.SetCellValue(Row, "fcntr_flg","N"); 
	 				  }
	 				  
	 				 if(strStsCd == "OP" || strStsCd == "OC" || strStsCd == "VL") {
	 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","Y");
	 				  }else{
	 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","N"); 
	 				  }
	 			  }
	 		  }
				
			var colName = ""
			for(var i=0;i<=sheetObj.LastCol();i++) {
				colName = sheetObj.ColSaveName(i);
				if(colName == "trsp_doc_no" ||
						colName == "mvmt_sts_cd" ||
						colName == "org_yd_cd" ||
						colName == "cnmv_cyc_no" ||
						colName == "cnmv_evnt_dt" ||
						colName == "bkg_no" ||
						colName == "ref_no" ||
						colName == "fcntr_flg" ||
						colName == "ob_cntr_flg" ||
						colName == "cntr_seal_no" ||
						colName == "chss_no" ||
						colName == "mgst_no" ||
						colName == "dest_yd_cd" ||
						colName == "wo_no" ||
						colName == "tir_no" ||
						colName == "mty_pln_no" ||
						colName == "mty_repo_no" ) {
				sheetObj.SetCellBackColor(Row, colName, "#FAC194");
				}else{
					sheetObj.InitCellProperty(Row, colName, {
						Type : "Text" , Edit:0 
					});
				}
	    		
				sheetObj.InitCellProperty(Row, "cnmv_cyc_no", {
					Type : "Text" , Edit:1 
				});
				
	    		sheetObj.InitCellProperty(Row, "bkg_no", {
					Type : "Combo" , Edit:1 , ComboCode:arr_bkg_no, ComboText:arr_bkg_no
				});
		
				if ( sXml_3 != "" ) {
					sheetObj.InitCellProperty(Row, "mvmt_sts_cd", {
						Type : "Combo" , Edit:1 , ComboCode:vCnmvStsCd, ComboText:vCnmvStsCd
					});
				}
				
				sheetObj.InitCellProperty(Row, "org_yd_cd", {
					Type : "Text" , Edit:1 ,AcceptKeys : "E|N", InputCaseSensitive:1
				});			

				sheetObj.InitCellProperty(Row, "cnmv_cyc_no", {
					Type : "Text" , Edit:1 ,AcceptKeys : "E|N", InputCaseSensitive:1
				});		
				
				sheetObj.InitCellProperty(Row, "cnmv_evnt_dt", {
					Type : "Date" , Edit:1 ,  Format:"YmdHm"
				});
				
				sheetObj.InitCellProperty(Row, "delcheck", {
					Type : "DummyCheck" , Edit:1 
				});
	    	}
			
			sheetObj.SetCellValue(Row,"inp_dt", now_date,0);
    	}
    }
    
    function sheet4_OnChange(sheetObj, Row, Col, Val) {
    	var colName = sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	
    	if (colName == "bkg_no") {
    		var sel_bkg_no =  sheetObj.GetCellValue(Row,"bkg_no");
    		if(sel_bkg_no == "New Input") {
    			sheetObj.InitCellProperty(Row, "bkg_no", {
					Type : "Text" , Edit:1 ,AcceptKeys : "E|N", InputCaseSensitive:1, EditLen:10
				});
    			sheetObj.SetCellValue(Row,"bkg_no","");
    			
    			sheetObj.InitCellProperty(Row, "vvd_cd", {
					Type : "Text" , Edit:1 ,AcceptKeys : "E|N", InputCaseSensitive:1, EditLen:9
				});
    			sheetObj.SetCellValue(Row,"vvd_cd","");
    			
    		}else{
	    		sheetObj.SetRangeFontColor(Row, Col, Row, Col, "#0000FF");
	    		
	    		var sel_row = sheetObjects[0].GetSelectRow();
	    		formObj.h_bkg_no.value = sheetObj.GetCellValue(Row,"bkg_no");
	    	    formObj.f_cmd.value=SEARCH01;
	 		    var sXml=sheetObj.GetSearchData("EES_CIM_2001GS.do", FormQueryString(formObj));
	 		    var cols=ComCimXml2ComboString(sXml, "vsl_vvd", "vsl_vvd", "\t");
	 		    
	 		    var strText = "";
	 		    if(cols[0] != "" && cols[0] != undefined) {
	 		    	strText = cols[0].substring(0,cols[0].length-1);
	 		    	
		 		    sheetObj.InitCellProperty(Row, "vvd_cd", {
			    				Type : "Combo" , Edit:1 , ComboText:strText, ComboCode: strText
			    			});
		 		   
		 		   var arrText = strText.split("|");
		 		   
		 		   for(var i=0; i<arrText.length; i++) {
		 			  if(arrText[i] != "") {
		 				  sheetObj.SetCellValue(Row, "vvd_cd",arrText[i]);
		 				  sheetObj.SetCellValue(Row, "crnt_vsl_cd",arrText[i].substring(0, 4));
		 				  sheetObj.SetCellValue(Row, "crnt_skd_voy_no",arrText[i].substring(4, 8));
		 				  sheetObj.SetCellValue(Row, "crnt_skd_dir_cd",arrText[i].substring(8, 9));
		 				  break;
		 			  }
		 		   
			 		  var strCnmvCycNo = "";
			 		 var strCgoTpCd ="";
			 		   var strStsCd ="";
			 		  for(var j=1; j<sheetObjects[0].RowCount()+1; j++) {
			 			  if(sheetObjects[0].GetCellValue(j,"bkg_no") == sheetObj.GetCellValue(Row,"bkg_no")) {
			 				 sheetObj.SetCellValue(Row, "bkg_cgo_tp_cd",sheetObjects[0].GetCellValue(j,"bkg_cgo_tp_cd"));
			 				 sheetObj.SetCellValue(Row, "cnmv_cyc_no",sheetObjects[0].GetCellValue(j,"cnmv_cyc_no"));
			 				 
			 				 strCgoTpCd = sheetObjects[0].GetCellValue(j, "bkg_cgo_tp_cd");
			 				 strStsCd = sheetObj.GetCellValue(Row, "mvmt_sts_cd");
			 				 if(strCgoTpCd == "F") {
			 					 sheetObj.SetCellValue(Row, "fcntr_flg","Y");
			 				 }else{
			 					 sheetObj.SetCellValue(Row, "fcntr_flg","N"); 
			 				 }
			 				  
			 				 if(strStsCd == "OP" || strStsCd == "OC" || strStsCd == "VL") {
			 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","Y");
			 				  }else{
			 					 sheetObj.SetCellValue(Row, "ob_cntr_flg","N"); 
			 				  }
			 				 
			 				if(strStsCd == "OP") {
			 					sheetObj.SetCellValue(Row, "fcntr_flg","N"); 
			 				}
			 			  }
			 		  }
		 		   
		 		   //sheetObj.SetCellValue(Row,"cnmv_cyc_no",strCnmvCycNo);
	 		    }
	 		   }else{
	 			  sheetObj.SetCellValue(Row, "vvd_cd","");
	 		   }
	    	}
    	}
    	
    	if (colName == "mvmt_sts_cd" || colName == "vvd_cd" || colName == "cnmv_evnt_dt" || colName == "ref_no" || colName == "cntr_seal_no"
    		 || colName == "wo_no" || colName == "edi_vvd_cd" || colName == "tir_no" || colName == "mty_pln_no"
    		 || colName == "mty_repo_no" || colName == "edi_crr_no" || colName == "trsp_doc_no" || colName == "dest_yd_cd" || colName == "cnmv_cyc_no"
    		 ||  colName == "crnt_vsl_cd" || colName == "crnt_skd_voy_no" || colName == "crnt_skd_dir_cd" || colName == "cnmv_rmk"
    	     || colName == "rty_knt" || colName == "lloyd_no" || colName == "cnmv_cyc_no") {
    		sheetObj.SetRangeFontColor(Row, Col, Row, Col, "#0000FF");
    	}
    	
    	if(colName == "org_yd_cd"){
    		if(sheetObj.GetCellValue(Row,"org_yd_cd") != "") {
    			var yard_cd = sheetObj.GetCellValue(Row,"org_yd_cd");
	    		var param="f_cmd="+SEARCH+"&node_cd="+yard_cd + "&mode=yard";
	    		
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
				sheetObj.SetWaitImageVisible(1);
				if ( ComGetTotalRows(sXml) == 1 ) {
				} else {				
					ComShowCodeMessage("CIM29021");
					sheetObj.SetCellValue(Row,"org_yd_cd","");
					return false;
				}
				
				sheetObj.SetRangeFontColor(Row, Col, Row, Col, "#0000FF");
    		}
    	}
    	
    	if(colName == "dest_yd_cd") {
    		doActionIBSheet(sheetObjects[3],document.form,IBSEARCH06);
    	}
    	
    	var mvmtStsCd = sheetObj.GetCellValue(Row, "mvmt_sts_cd");
    	
    	if(mvmtStsCd == "MT" || mvmtStsCd == "EN" || mvmtStsCd == "TN") {
    		
    	} else {
        	if(colName == "vvd_cd") {
        		var CellPro = sheetObj.GetCellProperty(Row, "vvd_cd", "Type");
        		if(CellPro == "Text") {
        			var strVvdText = sheetObj.GetCellValue(Row, "vvd_cd");
        			if(strVvdText.length == 9) {
    	    			sheetObj.SetCellValue(Row, "crnt_vsl_cd",strVvdText.substring(0, 4));
    					sheetObj.SetCellValue(Row, "crnt_skd_voy_no",strVvdText.substring(4, 8));
    					sheetObj.SetCellValue(Row, "crnt_skd_dir_cd",strVvdText.substring(8, 9));
        			}else{
        				ComShowCodeMessage("CIM30013", "VVD Code");
    					sheetObj.SetCellValue(Row,"vvd_cd","",0);
    					return false;
        			}
        		}
        	}    		
    	}

    	
    	if(colName == "mvmt_sts_cd") {
    		if(mvmtStsCd == "MT" || mvmtStsCd == "EN" || mvmtStsCd == "TN") {
    			sheetObj.SetCellValue(Row, "crnt_vsl_cd", "")
    			sheetObj.SetCellValue(Row, "crnt_skd_voy_no", "")
    			sheetObj.SetCellValue(Row, "crnt_skd_dir_cd", "")
    			sheetObj.SetCellValue(Row, "fcntr_flg","N");
    			sheetObj.SetCellValue(Row, "ob_cntr_flg","N"); 
    			sheetObj.SetCellValue(Row, "bkg_cgo_tp_cd","");
    			sheetObj.SetCellValue(Row, "vvd_cd","");
    			sheetObj.SetCellValue(Row, "bkg_no","");
    		}
			if(mvmtStsCd == "OP") {
 				sheetObj.SetCellValue(Row, "fcntr_flg","N"); 
 			}    		
    	}    	
    }
    
    
    function sheet5_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    	sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
		ComOpenWait(false);
    }
    
    
    function sheet5_OnClick(sheetObj, Row, Col, Value) {
    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000");
    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
    	
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){    		
    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
    	}
    }
    
    
    function sheet6_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    	sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
		ComOpenWait(false);
    }
    
    
    function sheet6_OnClick(sheetObj, Row, Col, Value) {
    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000");
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){    		
    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
    	}
    }
    
    
    function sheet7_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    	sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
		ComOpenWait(false);
    }
    
    
    function sheet7_OnClick(sheetObj, Row, Col, Value) {
    	sheetObj.SetRangeFontBold(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), 0);
    	sheetObj.SetRangeFontColor(1, 0, sheetObj.LastRow(), sheetObj.LastCol(), "000000");
    	if ( Row == 0  ) return;
    	if( sheetObj.RowCount()> 0 ){    		
    		sheetObj.SetRangeFontBold(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), 1);
    		sheetObj.SetRangeFontColor(sheetObj.GetSelectRow(), 0, sheetObj.GetSelectRow(), sheetObj.LastCol(), "0000FF");
    	}
    }
    
    function sheet8_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
    	formObj.f_cmd.value=MULTI;
		if(ComShowCodeConfirm("COM130101")){
			ComOpenWait(true);
			formObj.input_cntr_sts_evnt_dt.value=ComReplaceStr(ComGetObjValue(form.input_cntr_sts_evnt_dt2), "-", "");
			sheetObjects[7].SetRowStatus(1,"U");
			sheetObjects[7].DoSave("EES_MST_0025GS.do", FormQueryString(formObj)+"&pg_num=2001", -1, false);
			ComOpenWait(false);
		}
    }
    
    function sheet8_OnSaveEnd(sheetObj, ErrMsg) {
		var sheetObj=sheetObjects[7];		
		var rowCount=sheetObj.RowCount();
		var failcnt=0;		
		var failcnt2=0;	
		var sel_row = sheetObjects[2].GetSelectRow();
		var sel_col = sheetObjects[2].GetSelectCol();
		if(ErrMsg != '' && ErrMsg.length > 0) return;
		for(var i=1; i<rowCount+1; i++){
			if(sheetObj.GetCellValue(i,"h_chk1") == "E"){
				sheetObjects[2].SetCellFontColor(sel_row, "cntr_sts_cd","#FF0000");
				failcnt++;
			}
			if(sheetObj.GetCellValue(i,"h_chk2") == "E"){
				sheetObjects[2].SetCellFontColor(sel_row, "cntr_crnt_yd_cd","#FF0000");
				failcnt++;			
			}
			if(sheetObj.GetCellValue(i,"h_chk3") == "E"){
				sheetObjects[2].SetCellFontColor(sel_row, "cntr_cnmv_dt","#FF0000");
				failcnt++;			
			}		
			if(sheetObj.GetCellValue(i,"h_chk1") == "" &&	sheetObj.GetCellValue(i,"h_chk2") == "" &&
				sheetObj.GetCellValue(i,"h_chk3") == ""){
				sheetObjects[2].SetCellFontColor(sel_row, "cntr_no","#FF0000");
				failcnt++;	
			}
			if(failcnt > 0){
				failcnt2++;
			}
			failcnt=0;
		}	
		
		var succCount=rowCount - failcnt2;
		var sMsg="";
		
		if(rowCount >0){		
			if (succCount > 0 && failcnt2 == 0 ){
				sMsg=ComGetMsg("CIM30025", "", "", "");
	  			sheet3_OnClick(sheetObjects[2], sel_row, sel_col, "");
				ComShowMessage (sMsg);
			}
			if (succCount > 0 && failcnt2 > 0 ){
				sMsg=sMsg + ComGetMsg("CIM30027", "", "", "");
				ComShowMessage (sMsg);
			}
			if (succCount == 0 && failcnt2 > 0){
				sMsg=sMsg + ComGetMsg("CIM30026", "", "", "");
				ComShowMessage (sMsg);
			}
			
			if (succCount > 0 && failcnt2 == 0 ) sheetObj.RemoveAll();
		}			
	}
    
    function obj_keyup() {
		var vKeyCode=event.keyCode;
		var formObj=document.form;
		switch (ComGetEvent("name")) {
			case "input_onh_yd_cd":
		    	if (formObj.input_onh_yd_cd.value.trim().length == 7){
		    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH04);
		    	} 			
		    	else if (vKeyCode == 13 || vKeyCode == 9 && (formObj.input_onh_yd_cd.value.length > 0)){
		    		ComShowCodeMessage("CIM30013", formObj.input_onh_yd_cd.value);
		    		formObj.input_onh_yd_cd.value="";
		    		formObj.yd_cd_nm.value="";
		    		ComSetFocus(formObj.input_onh_yd_cd);
		    		formObj.input_onh_yd_cd.focus();				
				}
		    break;	
		}
	}	
    
	function obj_change(){
		var formObj=document.form;
		if (formObj.input_onh_yd_cd.value.trim().length == 7){
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH04);
    	}
	}	
	
	/**
	 * converting xml data gotten with GetSearchXml function of IBsheet <br>
	 * to String connecting Combo of IBsheet(seperator : '|')<br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mysheet.GetSearchXml(&quot;aaa.do&quot;);
	 * var arrData = ComXmlString(xmlStr, nm);
	 * 
	 * </pre>
	 * 
	 * @param {string}
	 *            xmlStr mandatory, xml
	 * @param {string}
	 *            Text
	 * @return array Code연
	 */
	function ComXmlString(xmlStr, codeCol) {
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}

		if (codeCol == null || codeCol == "") {
			return rtnArr;
		}

		try {
			var xmlDoc = ComGetXmlDoc(xmlStr);
			if (xmlDoc == null)
				return;
			var xmlRoot = xmlDoc.documentElement;

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return rtnArr;
			}

			var colListIdx = Array();
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
			}

			var sCode = "";
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

				sCode += arrData[colListIdx[0]];

				if (i != dataChildNodes.length - 1) {
					sCode += "|";
				}
			}
			
			if(sCode.length > 0 &&  sCode.slice(-1) == "|"){
				sCode = sCode.substring(0,sCode.length-1)
			}
		 
			rtnArr.push(sCode);
		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}
	
	/**
	 * Calling rep_commodity pop-up
	 */
	function rep_Multiful_inquiry(input_obj) {
	   	var formObject=document.form;
	   	var cmdt_cd_val=""; // 향후 사용가능 예정변수
	   	var rep_cmdt_cd_val=""; // 향후 사용가능 예정변수
	   	var cmdt_desc_val=""; // 향후 사용가능 예정변수
	   	var classId="getLse_Multi";
	   	var xx1=input_obj; // CONTI
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
	   	if(input_obj == "pop_cntr_no") {
		   	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
		   			'1,0');
	   	}else{
	   		ComOpenPopup('EES_CIM_2002.do' + param, 1300, 630, 'getCim_Cntri',
   			'1,0');
	   	}
	}
	
	
	function getCim_Cntri(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		var AllText = "";
		//initializing
		formObj.s_cntr_no.value='';
		formObj.pop_cntr_no.value='';
		formObj.o_cntr_no.value='';
		comboObjects[0].RemoveAll();
		
		if(rowArray.length > 1) {
			$("#cntr_txt").css("display","none");
			$("#cntr_combo").css("display","");
		}else{
			$("#cntr_txt").css("display","");
			$("#cntr_combo").css("display","none");
		}
		
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText=rowArray[i].toUpperCase();
			comboObjects[0].InsertItem(i, tempText, tempText);
			if(i == 0) {
				comboObjects[0].SetSelectIndex(0);
				AllText = tempText;
				formObj.o_cntr_no.value=tempText;
			}else{
				AllText = AllText+","+tempText;
			}
		}
		
		formObj.pop_cntr_no.value = AllText;
		
	}
	
	
	function getLse_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		var AllText = "";
		//initializing
		formObj.s_cntr_no.value='';
		formObj.pop_cntr_no.value='';
		formObj.o_cntr_no.value='';
		comboObjects[0].RemoveAll();
		
		if(rowArray.length > 1) {
			$("#cntr_txt").css("display","none");
			$("#cntr_combo").css("display","");
		}else{
			$("#cntr_txt").css("display","");
			$("#cntr_combo").css("display","none");
		}
		
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			
			tempText=rowArray[i].toUpperCase();
			comboObjects[0].InsertItem(i, tempText, tempText);
			if(i == 0) {
				comboObjects[0].SetSelectIndex(0);
				AllText = tempText;
				formObj.o_cntr_no.value=tempText;
			}else{
				AllText = AllText+","+tempText;
			}
		}
		
		formObj.pop_cntr_no.value = AllText;
		
	}
	
	
	/**
    * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
    * 
    * @param {String}
    *            str 제거 대상 String
    * @return {String} str 제거된 String
    * @author 박영진
    * @version 2009.06.04
    */
   function LseDelLastDelim(str) {
	   	// 마지막에 &를 없애기 위함
	   	if (str != "") {
	   		str=str.substr(0, str.length - 1);
	   	}
	   	return str;
   }

	   
   function s_cntr_no_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	   var formObject=document.form;
	   if(NewCode != "") {
		   tabObjects[0].SetSelectedIndex(0);
   		   doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	  }
   }
	   
	   