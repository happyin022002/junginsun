/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1108.js
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
*--------------------------------------------------------
* History
* 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
* 2011.01.17 김경섭 [CHM-201005134-01] [ESM-BKG] ENS Report: POFE 입력 처리, Grid 에 항목별 Sort
* 2011.04.08 김경섭 [CHM-201005134-01] [ESM-BKG] ENS Report: POFE 체크로직 수정
* 2011.04.14 김경섭 [CHM-201109994-01] [ESM-BKG] ENS Report: 엑셀다운시 CNTR NO별 분리(Download용 sheet추가 및 복제),POFE 체크로직 수정
* 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
* 2013.08.27 김보배 [CHM-201325981] [FI] ENS report 화면 download 시 Cargo sequence number item 추가 요청
* 2014.01.03 최문환 [CHM-201328166] [ENS] ENS report 상 POL ETB, POFE ETA 값 추가 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */
    /**
     * @extends 
     * @class ESM_BKG_1108 : ESM_BKG_1108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    //전역변수
    var intervalId="";
    /**
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	var colSaveName=sheetObj.ColSaveName(col);
        switch(colSaveName) {
	    	case "cntrs":
			       break;
        } // end switch
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
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj; 
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		  //MultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
		ComBtnDisable("btn_BLAdd");
		ComBtnDisable("btn_BLDelete");
		//ComBtnDisable("btn_Transmit");
		//화면에서 필요한 이벤트
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
		p_type.SetSelectIndex(0);
	}
    
    function initControl() {
     	var formObject=document.form;
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        // axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        // axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
    }
  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
  	* @param {String} comboId 필수,combo ID
  	* @return 없음. 
   	 */ 
   	function initCombo(comboObj, comboId) {
   	    var formObject=document.form
		initComboEditable(comboObj, comboId)
   	    var cnt=0;	
  		switch(comboObj.options.id) {
	  		case "p_type":
	  			with (comboObj) {
		 			SetDropHeight(300);
					SetMultiSelect(0);
					SetUseEdit(0);
					InsertItem(cnt ++, "ENS", "ENS");
					InsertItem(cnt ++, "Finland (IE344)", "FI");
					Code="ENS";
	  			}
	  			break;    	            
  		}
   	}
 	/** 
 	* 콤보 멀티 셀렉트 및 수정 여부 초기 설정 <br> 
 	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	* @param {String} comboId 필수,combo ID
 	* @return 없음.
 	*/ 
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pofe_yd_temp" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(1);
	 			SetBackColor("#CCFFFD");
	 		}
 		}
 	} 
 	/**
	 * Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
//	function p_type_OnChange(comboObj, value, text){
//		if (p_type.GetSelectCode()== "ENS") {
//			document.getElementById("ensView").style.display="inline";
//			document.getElementById("fiView").style.display="none";
//			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		} else {
//			document.getElementById("ensView").style.display="none";
//			document.getElementById("fiView").style.display="inline";
//			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		}
//	}
	
 	function p_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if(p_type.GetSelectCode()== "ENS") {
			$('#ensView').show();
			$('#fiView').hide();
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		} else {
			$('#ensView').hide();
			$('#fiView').show();
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		}
	}
//	function bkg_keypress(){
//	    switch(ComGetEvent("dataformat")){
//	    	case "ymd":
//	        //number
//	        ComKeyOnlyNumber(ComGetEvent(), "-");
//	        break;
//	    	case "engup":
//	        //영문대문자
//    			ComKeyOnlyAlphabet('upper');
//	        break;
//	      case "engupnum":
//	        //숫자+"영문대분자"입력하기
//	      	ComKeyOnlyAlphabet('uppernum');
//	        break;
//	      case "num":
//	        //숫자 입력하기
//	        ComKeyOnlyNumber(ComGetEvent());
//	        break;
//	      case "custname":
//	        //영문,숫자,공백,기타문자(.,등)
//	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
//	      break;	            
//	      default:
//	      break;
//	    }
//	} 
	
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
		switch(ComGetEvent("name")){	
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
	    		p_pofe_yd_temp.RemoveAll();
	    		p_pofe_yd_temp.SetSelectText("",false);
	    		form.p_pofe_yd.value="";
	   	 		form.p_search_pofe_yard_cd.value="";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	    		if(p_pofe_yd_temp.GetItemCount() >= 1 ){
	    			p_pofe_yd_temp.SetSelectIndex(0);
	    		}
	    		form.p_pol.focus();
				break;
	    	case "p_fi_vvd":
	    		sheetObjects[2].RemoveAll();
	    		form.p_fi_lane.value="";
	    		form.p_fi_pol.value="";
	   	 		form.p_fi_pol_yd.value="";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
				break;				
			default:
				break;
	    }
    }
	/**
	 * Trans Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function p_pofe_yd_temp_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
		if(newtext.indexOf("(") < 0 && (newtext.length < 5 || newtext.length > 7)){

			ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
			//form.p_pofe_yd.value = "";
			//form.p_search_pofe_yard_cd.value = ""; 
			//p_pofe_yd_temp.focus();
			return;
		}
	}        
     /**
      * Booking Creation 화면 이동
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
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
             var blueColor="#0000FF";
             for(var i=HeaderRows(); i<= LastRow(); i++) {
            	 if (GetCellValue(i,"result2") == "DNL" || GetCellValue(i,"result2") == "R" || GetCellValue(i,"result2") == "H") {
            		 SetCellFontColor(i,"result",redColor);
            	 } else if (GetCellValue(i,"result2") == "L") {
            		 SetCellFontColor(i,"result",blueColor);
	                }
             }
             
             
         }//end width
     }
     /*
      * Pre EU port 조회 후 해당 값을 폼에 셋팅 
      */
     function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
     	var formObj=document.form;
     	formObj.p_fi_pol.value=(sheetObjects[3].GetCellValue(1,"p_fi_pol_cd") == -1 ? "":sheetObjects[3].GetCellValue(1,"p_fi_pol_cd"));
     	formObj.p_fi_pol_yd.value=(sheetObjects[3].GetCellValue(1,"p_fi_pol_yard_cd") == -1 ? "": sheetObjects[3].GetCellValue(1,"p_fi_pol_yard_cd"));
     }
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick=processButtonClick;
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
   	  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
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
 					doActionIBSheet(sheetObject1, formObject, IBCLEAR);
 					break;
 				case "btn_DownExcel":
 					if(sheetObject1.RowCount() < 1){//no data
 	                   ComShowCodeMessage("COM132501");
 	              }else{
 	            	 ComOpenWait(true);
  					var sheetDownload=sheetObjects[4];
  			        setTimeout(function() {getDownload(sheetObject1,sheetDownload);},500);
 	              }
 					
 					break;
 				case "btn_Inquiry":
 					  var row=sheetObject1.GetSelectRow();
	 			      var p_bl_no=(sheetObject1.GetCellValue(row, "bl_no") == -1 ? "" :sheetObject1.GetCellValue(row, "bl_no"));
	 			      if(p_bl_no==""){
	 			    	 ComShowCodeMessage('COM12189');
	 			    	 return;
	 			      }
	 			      var parentPgmNo=document.getElementById("pgmNo").value;
	 			      ComOpenWindowCenter("ESM_BKG_1107_POP.do?parentPgmNo="+parentPgmNo+"&pgmNo=ESM_BKG_1107&bl_no=" + p_bl_no, "1107", 1040, 700, false);
	 			      break;
 				case "btn_History":
 	 			      var row=sheetObject1.GetSelectRow();
 	 			      var p_vvd=sheetObject1.GetCellValue(row, "vvd");
 	 			      var p_cstms_port_cd=sheetObject1.GetCellValue(row, "pofe");
 	 			      var p_bl_no=(sheetObject1.GetCellValue(row, "bl_no") == -1? "":sheetObject1.GetCellValue(row, "bl_no"));
 	 			      if(p_bl_no==""){
 	 			    	ComShowCodeMessage('COM12189');
	 			    	return;
 	 			      }
 	 			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1113.do?pgmNo=ESM_BKG_1113&p_vvd=" + p_vvd + "&p_cstms_port_cd=" + p_cstms_port_cd+ "&p_bl_no=" + p_bl_no, "1113",950, 500, false);
 	 			      break;      //ComOpenWindowCenter에 대한 설명은 CoPopup.js에 되어있다. 
 			    case "btn_viewMsg":
 			      var row=sheetObject1.GetSelectRow();
 			      if (ComIsNull(sheetObject1.GetCellValue(row,"ack"))) {
 	    				ComShowCodeMessage('BKG00442');
 	 					return;    
 			      }
 			      var edi_rcv_dt=sheetObject1.GetCellValue(row, "edi_rcv_dt");
 			      var edi_rcv_seq=sheetObject1.GetCellValue(row, "edi_rcv_seq");
 			      var cnt_cd= sheetObject1.GetCellValue(row, "pofe").toString().substring(0,2);
 			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1112", 600, 620, false);
 			      break;   
 				case "btn_date":	
 					var cal=new ComCalendarFromTo();
 					cal.setEndFunction("endDateSet");
					cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
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
	  * DownExcel시 wait 창이 바로 뜨질 않아 setTimeout함수를 호출해서 작업한다.
	  * @param sheetObj sheetObject1
	  * @param sheetObj sheetDownload
	  */   
	  function getDownload(sheetObject1,sheetDownload){
		sheetDownload.RemoveAll();
		with (sheetObject1) {
			var arrPagerows;
			var arrTemp;
			var Row;
			for(var i=HeaderRows(); i<= LastRow(); i++) {
				arrPagerows=GetCellValue(i,"pagerows").split("@@");
				for( var j=0; j< arrPagerows.length; j++){
					arrTemp=arrPagerows[j].split("$$");
					Row=sheetDownload.DataInsert(-1);
					sheetDownload.SetCellValue(Row, "seq",getNull(GetCellValue(i, "seq")                ," "),0);
					sheetDownload.SetCellValue(Row, "vvd",getNull(GetCellValue(i, "vvd")                ," "),0);
					sheetDownload.SetCellValue(Row, "lane",getNull(GetCellValue(i, "lane")               ," "),0);
					sheetDownload.SetCellValue(Row, "pol",getNull(GetCellValue(i, "pol")                ," "),0);
					sheetDownload.SetCellValue(Row, "pol_yd",getNull(GetCellValue(i, "pol_yd")             ," "),0);
					sheetDownload.SetCellValue(Row, "vps_etb_dt",getNull(GetCellValue(i, "vps_etb_dt")         ," "),0);
					sheetDownload.SetCellValue(Row, "pofe",getNull(GetCellValue(i, "pofe")               ," "),0);
					sheetDownload.SetCellValue(Row, "pofe_yd",getNull(GetCellValue(i, "pofe_yd")            ," "),0);
					sheetDownload.SetCellValue(Row, "vps_eta_dt",getNull(GetCellValue(i, "vps_eta_dt")         ," "),0);
					sheetDownload.SetCellValue(Row, "bl_no",getNull(GetCellValue(i, "bl_no")              ," "),0);
					sheetDownload.SetCellValue(Row, "bkg_sts_cd",getNull(GetCellValue(i, "bkg_sts_cd")         ," "),0);
					sheetDownload.SetCellValue(Row, "pod",getNull(GetCellValue(i, "pod")                ," "),0);
					sheetDownload.SetCellValue(Row, "pod_yd",getNull(GetCellValue(i, "pod_yd")             ," "),0);
					sheetDownload.SetCellValue(Row, "del",getNull(GetCellValue(i, "del")                ," "),0);
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
					sheetDownload.SetCellValue(Row, "result2",getNull(GetCellValue(i, "result2")            ," "),0);;
	         		sheetDownload.SetCellValue(Row, "cntrs",arrTemp[0],0);
	       			sheetDownload.SetCellValue(Row, "goods_item_no",arrTemp[1],0);
	         	}
			}
		}//end width
		
		var excelCol = makeHiddenSkipCol(sheetDownload);
		//  goods_item_no  제외
		    excelCol=ComReplaceStr(excelCol,"|"+sheetDownload.SaveNameCol("goods_item_no"),"");
		if ((p_pofe_yd_temp.GetSelectText().substring(0,2) == "FI") || (p_type.GetSelectCode()!= "ENS")){
//			sheetDownload.Down2Excel({ HiddenColumn:-1});
			sheetDownload.Down2Excel({DownCols: excelCol, Merge:1});
		} else{
			sheetDownload.Down2Excel({DownCols: excelCol, Merge:1});
//			sheetDownload.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
		}
		ComOpenWait(false);
	}  
	  
	function getNull(src,nullToStr){
    	 if(src == null || src == ""){
    		 return (nullToStr == null ? "":nullToStr)
    	 }
    	return src;
     }
	 function endDateSet(){
		 if (ComIsNull(form.p_from_mt)) {
			form.p_from_mt.value="00:00";
		 }
		 if (ComIsNull(form.p_to_mt)) {
			 form.p_to_mt.value="23:59";
		 }
	  }
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBCLEAR: // 폼과 시트의 값 삭제
	        	var curPType = p_type.GetSelectCode();
				formObj.reset();
				p_type.SetSelectCode(curPType);
				sheetObj.RemoveAll();
				form.div_total_bl_cnt.value="";
				form.div_sent_bl_cnt.value="";
				form.div_unsent_bl_cnt.value="";
				form.div_sent_bl_cnt2.value="";
				form.div_a_cnt.value="";
				form.div_r_cnt.value="";
				form.div_dnl_cnt.value="";
				form.div_nr_cnt.value="";
				break;
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(p_type.GetSelectCode()== "ENS") { // ENS 전송
					if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd)) {
//						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(1);
						formObj.f_cmd.value=SEARCH04;
						var pofeXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
						formObj.p_vvd.value=ComGetEtcData(pofeXml,"vvd");
						formObj.p_pol.value=ComGetEtcData(pofeXml,"pol");
						//formObj.p_pol_yd.value = ComGetEtcData(pofeXml,"pol_yd");
						//pofe list
						doActionIBSheet(sheetObj, formObj, SEARCH02);
//						alert(p_pofe_yd_temp.GetItemCount());
						if(p_pofe_yd_temp.GetItemCount() == 1){
							p_pofe_yd_temp.SetSelectIndex(0);
						}else if(p_pofe_yd_temp.GetItemCount() > 1){
							//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				    		p_pofe_yd_temp.SetSelectIndex(0);
//				    		p_pofe_yd_temp.focus();
				    		ComShowCodeMessage('BKG95001','select a POFE');
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
				    		return;
						}else{
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							return;
			    		}
		    		}
					// 사용자 입력값을 uppercase로 변경  
					var comboText=p_pofe_yd_temp.GetSelectText().toUpperCase();
					// 선택 또는 입력한  값이 콤보에 있으면
					if (sheetObjects[2].FindText('eu_1st_port_name',comboText) != -1) {
						form.p_pofe_yd.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_name',comboText),"eu_1st_port_yd_cd");
						form.p_search_pofe_yard_cd.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_name',comboText),"eu_1st_port_yd_cd");
						//2011.04.13 수정 : 다운로드 된거 안된거 동시 조회로 인해 포트가 전송후 포트가 변경된것은 데이타 중복이 발생한다.
						//form.p_search_pofe_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port_name',comboText),"search_eu_1st_port_yd_cd");
					} else{
						form.p_pofe_yd.value=comboText;
						form.p_search_pofe_yard_cd.value=comboText;
					}
					// p_search_pofe_yard_cd가 없다는것은 기존의 POFE가 스킵되었고 기존의 전송되었던 POFE와 대응되는 POFE가 없다는 것임.
					if ( ComIsNull(formObj.p_from_dt) || ComIsNull(formObj.p_to_dt) ) {
						if ( ComIsNull(formObj.p_search_pofe_yard_cd) ) {
				    			ComShowCodeMessage('BKG03061','POFE');
//				    			sheetObj.RenderSheet(1);
								sheetObj.SetWaitImageVisible(0);
				    			return;
			    		}
					}
				} else { // Finland (IE344)
					if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_fi_vvd)) {
//						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(1);
						// BL 에 해당되는 VVD 조회
						formObj.f_cmd.value=SEARCH07;
						var sParam="";
						sParam += "p_fi_bl_no=" + formObj.p_bl_no.value + "&"  + "p_search_pofe_yard_cd=" + formObj.p_fi_pofe.value + formObj.p_fi_pofe_yd.value + "&" + FormQueryString(formObj);
						var preEUportXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", sParam);
						formObj.p_fi_vvd.value=ComGetEtcData(preEUportXml, "vvd");
						formObj.p_fi_pofe_yd.value=ComGetEtcData(preEUportXml, "pod_yd");
						doActionIBSheet(sheetObj, formObj, SEARCH06); // pre EU port 조회
						if(formObj.p_fi_pofe.value == ""){
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							return;
			    		}
						if(formObj.p_fi_pol.value == ""){
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							return;
			    		}
		    		}
				}
//				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
//				sheetObj.RemoveAll();
				var sXml=sheetObj.GetSearchData("ESM_BKG_1108GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
					formObj.div_total_bl_cnt.value="0";
					formObj.div_sent_bl_cnt.value="0";
					formObj.div_unsent_bl_cnt.value="0";
					formObj.div_sent_bl_cnt2.value="0";
					formObj.div_a_cnt.value="0";
					formObj.div_r_cnt.value="0";
					formObj.div_dnl_cnt.value="0";
					formObj.div_nr_cnt.value="0";
				}else{
					formObj.div_total_bl_cnt.value=ComGetEtcData(sXml,"total_bl_cnt");
					formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_sent_bl_cnt2.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_a_cnt.value=ComGetEtcData(sXml,"a_cnt");
					formObj.div_r_cnt.value=ComGetEtcData(sXml,"r_cnt");
					formObj.div_dnl_cnt.value=ComGetEtcData(sXml,"dnl_cnt");
					formObj.div_nr_cnt.value=ComGetEtcData(sXml,"nr_cnt");
				}
//				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				
				formObj.div_unsent_bl_cnt.style.color="#FF0000";
				formObj.div_r_cnt.style.color="#FF0000";
				formObj.div_dnl_cnt.style.color="#FF0000";
				formObj.div_nr_cnt.style.color="#FF0000";   
				break;
			case SEARCH01 : // lane 조회
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1108GS.do", FormQueryString(formObj));
				formObj.p_lane.value=ComGetEtcData(sXml,"p_lane");
				formObj.p_fi_lane.value=ComGetEtcData(sXml,"p_lane");
				break;
			case SEARCH02 : // eu_1st_port 조회
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj)+"&p_vvd_cd="+formObj.p_vvd.value);
				ComXml2ComboItem(sXml, p_pofe_yd_temp, "search_eu_1st_port_yd_cd", "eu_1st_port_name");
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
/*				
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj)+"&p_vvd_cd="+formObj.p_vvd.value);
				ComXml2ComboItem(sXml, p_pofe_yd_temp, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
				//formObj.p_pofe.value = "";
				//p_pofe_yd_temp.value = "";
				//ComXml2ComboItem(sXml, formObj.p_pod_cd_temp, "eu_1st_port_yd_cd", "eu_1st_port");
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
*/				
				break;
			case SEARCH05 : // eu 포트 조회
				sheetObjects[1].RenderSheet(0);
				sheetObjects[1].SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				sheetObjects[1].RenderSheet(1);
				sheetObjects[1].SetWaitImageVisible(0);
				break;
			case SEARCH06 : // Finland (IE344) pre EU port 조회
//				sheetObj.Redraw = false;    
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH06;
				var sParam="";
				sParam += "p_fi_vvd_cd=" + formObj.p_fi_vvd.value + "&" 
						+ "p_fi_pod_cd=" + formObj.p_fi_pofe.value + "&"
						+ FormQueryString(formObj);
				var sXml=sheetObjects[3].GetSearchData("ESM_BKG_1106GS.do", sParam);
				sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
//				formObj.p_fi_pofe.value
				sheetObj.SetWaitImageVisible(0);
//				sheetObj.Redraw = true;
				break;
        }//end switch
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
	    		if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
	    			if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 7){
		    			ComShowCodeMessage('COM132001','Send/Received Date','7Days');
		    			formObj.p_from_dt.focus();
		    			return false;
		    		}
	    			return true;
	    		}
	    		if (!ComIsNull(formObj.p_bl_no)) {
	    			return true;
	    		}
	    		if(p_type.GetSelectCode()== "ENS") {
	    			if(p_pofe_yd_temp.GetSelectText()!= "" &&
	    					(p_pofe_yd_temp.GetSelectText().length < 5 || p_pofe_yd_temp.GetSelectText().length > 7) ){
	    				if(p_pofe_yd_temp.GetSelectText().indexOf("(") < 0){
		    				ComShowCodeMessage('BKG06065','POFE(5~7 Digits)');
		    				return false;
	    				}
	    			}
		    		//기본포멧체크
	    			if (ComIsNull(formObj.p_vvd)) {
	    				ComShowCodeMessage('BKG00104','VVD');
	 					formObj.p_vvd.focus();
	 					return false;    
	    			}
	    			if (ComIsNull(formObj.p_pol)) {
	    				ComShowCodeMessage('BKG00104','POL');
	    				formObj.p_pol.focus();
	    				return false;    
	    			}
	    			if(p_pofe_yd_temp.GetSelectText()== "" ){
	    				ComShowCodeMessage('BKG00104','POFE');
	    				p_pofe_yd_temp.focus();
	    				return false;    
	    			}
	    		} else { // Finland (IE344)
	    			if (ComIsNull(formObj.p_fi_vvd)) {
	    				ComShowCodeMessage('BKG00104','VVD');
	 					formObj.p_fi_vvd.focus();
	 					return false;    
	    			}
	    			if (ComIsNull(formObj.p_fi_pol)) {
	    				ComShowCodeMessage('BKG00104','POL');
	    				formObj.p_fi_pol.focus();
	    				return false;    
	    			}
	    			if (ComIsNull(formObj.p_fi_pofe)) {
	    				ComShowCodeMessage('BKG00104','POD');
	    				formObj.p_fi_pofe.focus();
	    				return false;    
	    			}
	    		}
				break;
	    }
        return true;
    }
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength= ComGetEvent("maxlength");
    	var srcValue=ComGetEvent("value");
    	if ((srcName == "p_vvd" || srcName == "p_pol" || srcName == "p_pod") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
				      var HeadTitle1="|Seq.|VVD|LANE|POL|POL|POL ETB|POFE|POFE|POFE ETA|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Status|Status|MRN\nNO|ENS Send Date|ENS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|hidden_cntrs";
				      var HeadTitle2="|Seq.|VVD|LANE|POL|POL|POL ETB|POFE|POFE|POFE ETA|B/L No|ST|POD|POD|DEL|CNTR|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|hidden_cntrs";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, FrozenCol: 11 } );
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",           Wrap:1 },
				             {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_etb_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"pofe_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntrs",  MultiLineText:1,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ct",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sent_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ack",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_gmt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ens_send_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_gmt_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pagerows",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetMergeCell(0, 4, 2, 2); //pol
				      SetMergeCell(0, 7, 2, 2); //pofe
				      SetMergeCell(0, 12, 2, 2); //pod
				      SetDataRowHeight(22);
				      SetRangeBackColor(1,10,1,50,"#555555");
				      SetSheetHeight(330);
		      		}
				break;
				
			case "sheetDownload":
			    with(sheetObj){
				      var HeadTitle1="|Seq.|VVD|LANE|POL|POL|POL ETB|POFE|POFE|POFE ETA|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Status|Status|MRN\nNO|ENS Send Date|ENS Send Date|ACK Receive Date|ACK Receive Date|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR|Goods Item No.";
				      var HeadTitle2="|Seq.|VVD|LANE|POL|POL|POL ETB|POFE|POFE|POFE ETA|B/L No|ST|POD|POD|DEL|CT|Sent\nType|Ack|Result|MRN\nNO|GMT|Local Time|GMT|Local Time|edi_rcv_dt|edi_rcv_seq|bkg_no|result2|CNTR|Goods Item No.";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_etb_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				             {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"goods_item_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetMergeCell(0, 4, 2, 2); //pol
				      SetMergeCell(0, 7, 2, 2); //pofe
				      SetMergeCell(0, 12, 2, 2); //pod
				      SetSheetHeight(390);
		      		}
			    break;	
			    
			case "sheet2":
			    with(sheetObj){
				      var HeadTitle1="|cnt_cd";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
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
				      var HeadTitle1="|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(280);
		            }
				break;
				
			case "sheet4":
			    with(sheetObj){
				      var HeadTitle1="|p_fi_pol|p_fi_pol_yd";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"p_fi_pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"p_fi_pol_yard_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(280);
	            }
			break;
		}//end switch
 	}     
