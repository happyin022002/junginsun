/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1106.js
*@FileTitle  : Europe Advanced Manifest  : ENS Download  & Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
*--------------------------------------------------------
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var $divOption;
    //전역변수
    var intervalId="";
   
    //Event handler processing by button click event
    document.onclick=processButtonClick;
 	//Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
     	//try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
            switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					doActionIBSheet(sheetObject1, formObject, IBCLEAR);
// 					formObject.reset();
// 					sheetObject1.RemoveAll();
// 					formObject.p_pod_cd_temp.RemoveAll();
// 					div_option.innerHTML = ""; 
// 					formObject.div_ttl_bl.value = "";
// 					formObject.div_ttl_err.value  = "";
// 					formObject.div_ttl_cntr.value  = "";
 					break;
 				case "btn_DownExcel":
 					if (sheetObject1.RowCount() > 0) {
 						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1, Merge:1 });
 					} else {
 						ComShowCodeMessage("COM132501");
 					}
 					break;
            	case "btn_EDIDownload":
            		doActionIBSheet(sheetObject1,formObject,MULTI);
            		break;  
            	case "btn_BLAdd":
            		break;  
            	case "btn_BLDelete":
            		break;  
 				case "btn_Inquiry":
	 		    		if (sheetObject1.CheckedRows("sel") <= 0 ) {
	 		    			ComShowCodeMessage("COM12189");
	 		    			return;
	 		    		}
	 					var arrRow=ComFindText(sheetObject1, "sel", 1);
	 					var tempBlno=""; //bl_no가 머지 되어있어 CheckedRows의 개수로는 유효성검사가 안된다.
	 					for(var i=0; i< arrRow.length; i++) {
	 						//B/L no가 두개 이상 체크되면 에러처리
	 						if (tempBlno != "" && tempBlno != sheetObject1.GetCellValue(arrRow[i], "bl_no")) {
	 							ComShowCodeMessage("BKG01134");
		 		    			return;
	 						}
	 						tempBlno=sheetObject1.GetCellValue(arrRow[i], "bl_no");
	 					}
	 					var p_bl_no=sheetObject1.GetCellValue(arrRow[0], "bl_no");
 	 			      var parentPgmNo=form.pgmNo.value;
	 			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1107_POP.do?parentPgmNo="+parentPgmNo+"&pgmNo=ESM_BKG_1107&bl_no=" + p_bl_no, "1107", 1040, 700, false);
	 			      break;  
 				case "btn_Transmit":
 					formObject.p_send_yn.value="Y";
 					doActionIBSheet(sheetObject1, formObject, MULTI03);
 					break;  
 				case "btn_Makefile":
 					formObject.p_send_yn.value="N";
 					doActionIBSheet(sheetObject1, formObject, MULTI01);
 					break;  
 				case "p_data_cd":
 					sheetObject1.RemoveAll();
 					$divOption.html("");
 					$divOption.hide();
 					formObject.div_ttl_bl.value="";
 					formObject.div_ttl_err.value="";
 					formObject.div_ttl_cntr.value="";
 					formObject.port_ofc_cd.value="";
 					if(ComGetObjValue(formObject.p_data_cd) == "BL"){
 						ComBtnDisable("btn_Inquiry");
 						ComBtnDisable("btn_Transmit");
 						ComBtnEnable("btn_EDIDownload");
 					}else{
 						ComBtnEnable("btn_Inquiry");
 						ComBtnEnable("btn_Transmit");
 						ComBtnDisable("btn_EDIDownload");
 					}
 					break;  
 				case "btn_Delete":
 					doActionIBSheet(sheetObject1, formObject, MULTI05);
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
    	$divOption = $('#div_option');
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	      //MultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
		ComBtnDisable("btn_Inquiry");
		ComBtnDisable("btn_Transmit");
		//화면에서 필요한 이벤트
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
		p_type.SetSelectIndex(0);
	}
     function initControl() {
     	var formObject=document.form;
//         axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
         axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ('change', 'bkg_change', formObject);
     }
     
     /** 
      * handling buttons on loading
      */
     function SetButtonStatus(){
     		// Customs Common Code 테이블의 EU Staff 인 경우에만 Data Delete 버튼 활성화
     		if(sheetObjects[0].GetCellValue(2, "eu_stf_flg")=="Y" && ComGetObjValue(document.form.p_data_cd) == "DL" ){
     			document.getElementById("btn_Delete").style.display='';
     		}else{
     			document.getElementById("btn_Delete").style.display='none';
     		}		
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
				InsertItem(cnt ++, "ENS",			  "ENS");
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
	 		if(comboId == "p_pod_cd_temp" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
	 			SetBackColor("#CCFFFD");
	 		}
 		}
 	} 	
/*********************** KEY EVENT START ********************/ 	 
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_vvd_cd":
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
	    	case "p_vvd_cd":
	    		sheetObjects[2].RemoveAll();
	    		p_pod_cd_temp.RemoveAll();
	    		form.p_pod_yard_cd.value="";
	   	 		form.p_search_pofe_yard_cd.value="";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		if(p_pod_cd_temp.GetItemCount() >= 1 ){
	    			p_pod_cd_temp.SetSelectIndex(0);
	    		}
	    		form.p_pol_cd.focus();
				break;
	    	case "p_fi_vvd_cd":
	    		sheetObjects[2].RemoveAll();
	    		form.p_fi_pol_cd.value="";
	   	 		form.p_fi_pol_yard_cd.value="";
	    		doActionIBSheet(sheetObjects[3],document.form,SEARCH06);
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
	    	case "bkg_from_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
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
	function p_pod_cd_temp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text){
		
//		form.eu_1st_port_clpt_seq.value=Number(newIndex)+1;
//		form.eu_1st_port_clpt_seq.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_clpt_seq', newText),"eu_1st_port_clpt_seq");
		form.eu_1st_port_clpt_seq.value=sheetObjects[2].GetCellValue(Number(newIndex)+1,"eu_1st_port_clpt_seq");
		form.p_pod_yard_cd.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_name', newText),"eu_1st_port_yd_cd");
		form.p_search_pofe_yard_cd.value=sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_name', newText),"search_eu_1st_port_yd_cd");
		form.p_pod_yard_temp.value=form.p_pod_yard_cd.value.substring(5);//현재 사용안함
		if(sheetObjects[2].GetCellValue(sheetObjects[2].FindText('eu_1st_port_name', newText),"edi_mrn") != "" ){
			form.p_ori_amd_cd[1].checked = true;
		}
	}     
	/**
	 * Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
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
	    /**
	     * 시트를 행 다중선택 시 처리
	     */
	    function sheet1_OnSelectMenu(sheetObj, sAction) {
	    	 //메뉴에 대한 처리 Check selected|Unheck selected|-|Check all|Uncheck all
	    	  switch(sAction){
	    	    case "Check selected" :
	    	      var sRowStr=sheetObj.GetSelectionRows("/");
	    	      //자바 스크립트 배열로 만들기
	    	      var arr=sRowStr.split("/");
	    	      for (i=0; i<arr.length; i++) {
	    	    	  if(arr[i] < 2) continue;//header 부분
	    	    	  if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	    	    	  if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	    	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
		  		    		for(var j=0; j <= sameRows.length ; j++) {
		  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
		  		    			sheetObj.SetCellValue(sameRows[j], "sel",1,0);
		  		    		}
	    	    	  }else
	    	    		  sheetObj.SetCellValue(arr[i], "sel",1,0);
	    	      }
	    	      break;
	    	    case "Unheck selected" :
	    	    	var sRowStr=sheetObj.GetSelectionRows("/");
	    	    	//자바 스크립트 배열로 만들기
	    	    	var arr=sRowStr.split("/");
	    	    	for (i=0; i<arr.length; i++) {
	    	    		if(arr[i] < 2) continue;//header 부분
	    	    		if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	    	    		if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	    	    			var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
	    	    			for(var j=0; j <= sameRows.length ; j++) {
	    	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
	    	    				sheetObj.SetCellValue(sameRows[j], "sel",0,0);
	    	    			}
	    	    		}else
	    	    			sheetObj.SetCellValue(arr[i], "sel",0,0);
	    	    	}
	    	      break;
	    	    case "Check all" :
	    	    	sheetObj.CheckAll("sel",1,1);break;
	    	    case "Uncheck all" :
	    	    	sheetObj.CheckAll("sel",0,1);break;
	    	  }
	    }
	    var startSelectedRow=0 ; //shift + 마우스 클릭 으로 체크시키기  위함.
	    /**
	     * sheet1 All 체크시 체크플래그 세팅
	     * @param sheetObj 시트오브젝트
	     * @param Button 마우스버튼 방향
	     * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	     * @param X X 좌표
	     * @param Y Y 좌표
	     */
//	    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
//	    	if(Shift == 0){
//	    		startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
//	    		var colSaveName=sheetObj.ColSaveName(sheetObj.MouseCol());
//	    		var check=sheetObj.GetCellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
//	    		
//	    		var keySeq=sheetObj.GetCellValue(startSelectedRow,"dt_seq");
//		        switch(colSaveName) {
//			    	case "sel" :
//			    		if(startSelectedRow < 2) return;
//			    		//alert(startSelectedRow +" "+check+" "+keySeq);
//			    		for(i=startSelectedRow ; i<= sheetObj.LastRow(); i++) {
//			    			if(eval(keySeq) < eval(sheetObj.GetCellValue(i, "dt_seq")) ) break;
//			    			if(keySeq == sheetObj.GetCellValue(i, "dt_seq")) {
//			    				sheetObj.SetCellValue(i, "sel",check);
//			    			}
//			    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
//			    		}
//			    		break;
//		        } // end switch
//	    	}else{
//	    		var endSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.;
//	    		startSelectedRow=startSelectedRow ==0 ? endSelectedRow:startSelectedRow;
//		    		if(startSelectedRow > endSelectedRow){
//		    			endSelectedRow=startSelectedRow;
//		    			startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
//		    		}
//		    		for (var i=startSelectedRow; i <= endSelectedRow; i++) {
//		    	    	  if(i < sheetObj.HeaderRows()) continue;//header 부분
//		    	    	  if(sheetObj.GetCellValue(i,"bl_no") == "") continue;//subsum 행이면
//		    	    	  if(i== endSelectedRow){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
//		    	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(i,"dt_seq"));
//		    	    		  if(sheetObjects[0].GetCellValue(i,"trsm_blck_flg")=="Y"){
//			    	    		  sheetObj.SetCellValue(i, "sel",0,0);
//			    	    		} else {
//		    	    		  		for(var j=0; j <= sameRows.length ; j++) {
//	    	    		  				if(sameRows[j] == undefined || sameRows[j] == "") continue;
//	    	    		  				sheetObj.SetCellValue(sameRows[j], "sel",1,0);
//			    	    		  	}
//			    	    	  }
//		    	    	  }else{
//		    	    		  if(sheetObjects[0].GetCellValue(i,"trsm_blck_flg")=="N"){
//		    	    			  sheetObj.SetCellValue(i, "sel",1,0);
//		    	    		  } else {
//		    	    			  sheetObj.SetCellValue(i, "sel",0,0);
//		    	    		  }
//		    	    	  }
//		    	      }
//	    	}//shift end
//	    }//method end
	    /**
	     * 시트를 클릭했을 때 처리 0127참조
	     */
	    function sheet1_OnClick(sheetObj, row, col) {
	    	var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
//		    	case "sel" :
//		    		if(sheetObj.GetCellValue(row,"bl_no") == "") return;//subsum 행이면
//		    		if(sheetObj.GetCellEditable(row,"sel") == 0 ) {return;}
//		    		else{
//		    		var check=sheetObj.GetCellValue(row,"sel") == 1 ?0:1;
//		    		sheetObj.SetCellValue(row, "sel",check,0);//mousedown 에서 처리한것을 다시 역으로 처리하므로 이것을 다시 역으로 바꿔준다.
//		    		}
//		    		break;
		    	case "ens_result":
		    		if (sheetObj.GetCellValue(row,"result2") != "R" && sheetObj.GetCellValue(row,"result2") != "DNL" ) {
	                	return;
	                }	                
	    			 //ComShowMemoPad(sheetObj, row, "rcv_msg", true, 300, 150);	//편집불가능
		    		var edi_rcv_dt=sheetObj.GetCellValue(row, "edi_rcv_dt");
		    		var edi_rcv_seq=sheetObj.GetCellValue(row, "edi_rcv_seq");
		    		var cnt_cd=sheetObj.GetCellValue(row, "eu_1st_port").substring(0,2);
			       ComOpenWindowCenter("/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 540, 600, false);
			       break;   
	        } // end switch
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
		        		if (ComGetObjValue(form.p_data_cd) == "DL") {
				            return;
			    		}
		        		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
			    	break;
		        } // end switch
	     }	   
	     /**
	      * 조회후  이벤트 처리 >>> 폰트 칼라변경
	      */
	     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	    	 var formObj=document.form;
	    	 with (sheetObj) {
	        	var rfsFlg="N";
	        	var rfsBls="";
	        	var rfsCnt=0;  // RFS 신고 대상 개수 2개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	        	var tempBl="";
		    	var rfsBlArray=new Array();
	        	  //pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
		    	//no support[implemented common]CLT 	        	 MessageText("SubSum")="POD";
//		    	ShowSubSum([{StdCol:"pod", SumCols:"dr_yn", Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("bl_status")}]);
	             var redColor="#FF0000";
	             var blueColor="#0000FF";
	             var blackColor="#000000";
	             if (ComGetObjValue(form.p_data_cd) == "BL") {
	            	 SetColFontColor("bl_no",blueColor);
                	SetColFontUnderline("bl_no",1);
                }else if(ComGetObjValue(form.p_data_cd) == "DL"){
                	SetColFontColor("bl_no",blackColor);
                	SetColFontUnderline("bl_no",0);
                }
	             for(var i=HeaderRows(); i<= LastRow(); i++) {
            	 	if (isError(GetCellValue(i,"sh_nm"))) SetCellFontColor(i,"sh_nm",redColor);
            	 	if (isError(GetCellValue(i,"sh_ad")))SetCellFontColor(i,"sh_ad",redColor);
            	 	if (isError(GetCellValue(i,"sh_ct"))) SetCellFontColor(i,"sh_ct",redColor);
            	 	if (isError(GetCellValue(i,"sh_cn"))) SetCellFontColor(i,"sh_cn",redColor);
            	 	if (isError(GetCellValue(i,"sh_zip"))) SetCellFontColor(i,"sh_zip",redColor);
            	 	if (isError(GetCellValue(i,"sh_str"))) SetCellFontColor(i,"sh_str",redColor);
            	 	if (isError(GetCellValue(i,"sh_eori"))) SetCellFontColor(i,"sh_eori",redColor);
            	 	if (isError(GetCellValue(i,"cnee_nm"))) SetCellFontColor(i,"cnee_nm",redColor);
            	 	if (isError(GetCellValue(i,"cnee_ad"))) SetCellFontColor(i,"cnee_ad",redColor);
            	 	if (isError(GetCellValue(i,"cnee_ct"))) SetCellFontColor(i,"cnee_ct",redColor);
            	 	if (isError(GetCellValue(i,"cnee_cn"))) SetCellFontColor(i,"cnee_cn",redColor);
            	 	if (isError(GetCellValue(i,"cnee_zip"))) SetCellFontColor(i,"cnee_zip",redColor);
            	 	if (isError(GetCellValue(i,"cnee_str"))) SetCellFontColor(i,"cnee_str",redColor);
            	 	if (isError(GetCellValue(i,"cnee_eori"))) SetCellFontColor(i,"cnee_eori",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_nm"))) SetCellFontColor(i,"ntfy_nm",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_ad"))) SetCellFontColor(i,"ntfy_ad",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_ct"))) SetCellFontColor(i,"ntfy_ct",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_cn"))) SetCellFontColor(i,"ntfy_cn",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_zip"))) SetCellFontColor(i,"ntfy_zip",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_str"))) SetCellFontColor(i,"ntfy_str",redColor);
            	 	if (isError(GetCellValue(i,"ntfy_eori"))) SetCellFontColor(i,"ntfy_eori",redColor);
            	 	if (isError(GetCellValue(i,"bl_pk"))) SetCellFontColor(i,"bl_pk",redColor);
            	 	if (isError(GetCellValue(i,"bl_wt"))) SetCellFontColor(i,"bl_wt",redColor);
            	 	if (isError(GetCellValue(i,"cntr_seal"))) SetCellFontColor(i,"cntr_seal",redColor);
            	 	if (isError(GetCellValue(i,"cntr_pk"))) SetCellFontColor(i,"cntr_pk",redColor);
            	 	if (isError(GetCellValue(i,"cntr_wt"))) SetCellFontColor(i,"cntr_wt",redColor);
            	 	if (isError(GetCellValue(i,"cntr_ms"))) SetCellFontColor(i,"cntr_ms",redColor);
            	 	if (isError(GetCellValue(i,"cm_pk"))) SetCellFontColor(i,"cm_pk",redColor);
            	 	if (isError(GetCellValue(i,"cm_wt"))) SetCellFontColor(i,"cm_wt",redColor);
            	 	if (isError(GetCellValue(i,"cm_ds"))) SetCellFontColor(i,"cm_ds",redColor);
            	 	if (isError(GetCellValue(i,"cm_mk"))) SetCellFontColor(i,"cm_mk",redColor);
            	 	if (isError(GetCellValue(i,"cm_hts"))) SetCellFontColor(i,"cm_hts",redColor);
            	 	if (GetCellValue(i,"result2") == "DNL" || GetCellValue(i,"result2") == "R" || GetCellValue(i,"result2") == "H") {
            	 		SetCellFontColor(i,"ens_result",redColor);
            	 		SetCellFontUnderline(i,"ens_result",1);
            	 	}else if(GetCellValue(i,"rcv_msg") != "" || GetCellValue(i,"result2") == "L"){
            	 		SetCellFontColor(i,"ens_result",blueColor);
		                }
//		                if (CellValue(i,"result2") == "H") {
//		                	CellFontColor(i,"ens_result") = redColor;
//		                } else if(CellValue(i,"result2") == "L") {
//		                	CellFontColor(i,"ens_result") = blueColor;	
//		                }
		                
		                if (GetCellValue(i,"trsm_blck_flg")=="Y"){ // ENS 신고 이후에 B/L이 원래의 VVD가  아닌 다른 배로 갈아타는 경우 그 B/L은 따로 또 ENS신고를 해야한다. 이전것을 취소하는 전송은 존재하지 않는다.
		                										   // 그래서 시스템 상에서 이 B/L은 쓰이지 않는다는 것을 이렇게 표현한다.  
		            		SetCellBackColor(i,"sel","#EFF0F3");
		            		SetCellEditable(i, "sel",0); // 콤보박스를 막는 것!

		            		// 해당 bl_no 랑 bl_status 컬럼에 가운데 줄
		            		SetCellFont("FontStrike", i,"bl_status",i,"bl_no",1); //줄을 긋는 표현
		        		}
		                
		                if(ComGetObjValue(formObj.p_pod_cd_temp).substring(0,5) != "FIKTK" && p_type.GetSelectCode()== "ENS"){
		                	if (GetCellValue(i,"rfs_yn") == "Y"){
	    						rfsFlg="Y";
	    						if(rfsBlArray[GetCellValue(i, "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
	    							rfsBlArray[GetCellValue(i, "bl_no")]=GetCellValue(i, "bl_no");
	                				rfsCnt++;
	    							if(rfsCnt <= 2)
	    								rfsBls += GetCellValue(i, "bl_no")+", ";
	    						}
		    				}
		                	if (tempBl== GetCellValue(i, "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
		                	tempBl=GetCellValue(i, "bl_no");
		                }
	             }
	             if(rfsFlg == "Y" && rfsCnt > 0){
	            	 rfsBls=rfsCnt > 2 ? rfsBls+"..etc.":rfsBls.substring(0,rfsBls.length-1);
	            	 // BKGs via FIKTK are selected, "BKG NO, BKG NO, ..."
	            	 // Do not miss to send ENS to second POFE “FIKTK”.
//	            	 second POFE alert msg 제거
//	            	 ComShowCodeMessage('BKG06147',rfsBls);
	             }
	         }//end width
	         pagedMaxCnt=sheetObj.LastRow();
	         // 체크박스 초기화
	         sheetObj.CheckAll("sel",0,1);
	     }	    
	     /**
	      * Booking Creation 화면 이동
	      * @param String cellValue
	      * return boolean 에러여부
	      */
function isError(GetCellValue) {
	if(GetCellValue== "E") return true;
	     	return false;
	     }		
 	
     var ata_yn="";
     /* A/N Sending 후 Accepted 된 VVD에 대한 ENS전송 방지 */
     var arn_yn="";
     /* Diversion Request된 VVD에 대한 ENS전송 방지 */
     var dr_yn="";
     /* ENS ETA 가 SYSDATE 보다 30일 이상 지난 경우 ENS전송 방지 */
     var trsm_val="";
     /* ENS ETA 가 SYSDATE 보다 30일 이상 지난 경우에도 전송이 가능하도록 함 Customs Common Code 테이블에 ERR_MSG중 2번째 값을 Y로*/
     var eta_err_msg="";
     /* Pofe가 NL인 경우 세관의 응답이 없으면 재전송이 불가능한데 이것을 푸는 것으로 Customs Common Code 테이블에 ERR_MSG중 1번째 값을 Y로*/
     var nl_err_msg="";
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
				p_pod_cd_temp.RemoveAll();
				$divOption.html("");
				$divOption.hide();
				formObj.div_ttl_bl.value="";
				formObj.div_ttl_err.value="";
				formObj.div_ttl_cntr.value="";
				ComBtnDisable("btn_Inquiry");     
				ComBtnDisable("btn_Transmit");
				ComBtnEnable("btn_EDIDownload");
				break;
			case MULTI01: // EDI FLAT FILE 생성 및 전송 대량 전송
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 전송할 대상 B/L존재여부를 조회한다.
				if (sheetObj.CheckedRows("sel") <= 0 ) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
				var arrRow=ComFindText(sheetObj, "sel", 1);
				var sParam="";  
				var tempBlno=""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				for(var i=0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					sParam +=   "ibflag=U"     +"&"+
								"p_send_yn="   +formObj.p_send_yn.value+"&"+
								"vsl_cd="      +sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+"&"+
								"skd_voy_no="  +sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+"&"+
								"skd_dir_cd="  +sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+"&"+
								"bl_no="       +sheetObj.GetCellValue(arrRow[i], "bl_no"        )+"&"+
								"eu_1st_port=" +sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+"&"+
								"p_type="	   +p_type.GetSelectCode()+"&";
					tempBlno=sheetObj.GetCellValue(arrRow[i], "bl_no");
				}
				formObj.f_cmd.value=MULTI01;
				sParam += "&" + FormQueryString(formObj);
//				alert(sParam);
//				return;
//				
				ComOpenWait(true,true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_1106GS.do", sParam)
				var key=ComGetEtcData(sXml, "KEY");
				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
			case MULTI03: // EDI FLAT FILE 생성 및 전송 - 단건
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 전송할 대상 B/L존재여부를 조회한다.
				if (sheetObj.CheckedRows("sel") <= 0 ) {
					ComShowCodeMessage("COM12189");
					return;
				}
				if(!ComShowConfirm(ComGetMsg("BKG95003", "transmit"))) return; // "Do you want to {?msg1}?"
				var arrRow=ComFindText(sheetObj, "sel", 1);
				var sParam="";  
				var tempBlno=""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				var successCnt=0; 
				var failCnt=0;
				ComOpenWait(true);
				for(var i=0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					sParam="ibflag=U"     +"&"+
					"p_send_yn="   +formObj.p_send_yn.value+"&"+
					"vsl_cd="      +sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+"&"+
					"skd_voy_no="  +sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+"&"+
					"skd_dir_cd="  +sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+"&"+
					"bl_no="       +sheetObj.GetCellValue(arrRow[i], "bl_no"        )+"&"+
					"eu_1st_port=" +sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+"&";
					formObj.f_cmd.value=MULTI03;
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_BKG_1106GS.do", sParam)
//					sheetObj.LoadSearchXml(sXml);
					var state=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if (state != "S"){
						failCnt++;
						//ComOpenWait(false);
						//ComShowMessage("Bl_no:"+sheetObj.CellValue(arrRow[i], "bl_no")+" Transimit Error occurred.\n"+ComResultMessage(sXml));
						//return;
					}else{
						successCnt++;
					}
					tempBlno=sheetObj.GetCellValue(arrRow[i], "bl_no");
				}
				//성공메시지 보여주고
	     		//ComShowCodeMessage('BKG00101');
				ComShowMessage("Total:"+(successCnt+failCnt)+"\nSuccess:"+successCnt+"\nFail:"+failCnt);
	     		//전송 성공 후 재조회함.
	     		doActionIBSheet(sheetObj,form,IBSEARCH);				
	     		ComOpenWait(false);
				break;
			case IBSEARCH : // 조회
				ComOpenWait(true);
				if(p_type.GetSelectCode()== "ENS") { // ENS 전송
					if(!validateForm(sheetObj,formObj,sAction)) {
						ComOpenWait(false);
						return;
					}
//					sheetObj.RenderSheet(0);
					sheetObj.SetWaitImageVisible(1);
					sheetObj.RemoveAll();
					if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd_cd)) {
						formObj.f_cmd.value=SEARCH04;
						var pofeXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
						//ComXml2ComboItem(pofeXml, formObj.p_pod_cd_temp, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
						formObj.p_pod_yard_temp.value="";//현재 사용안함
						formObj.p_vvd_cd.value=ComGetEtcData(pofeXml,"vvd");
						formObj.p_pol_cd.value=ComGetEtcData(pofeXml,"pol");
						formObj.p_pol_yard_cd.value=ComGetEtcData(pofeXml,"pol_yd");
						doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(p_pod_cd_temp.GetItemCount() == 1){
							p_pod_cd_temp.SetSelectIndex(0);
						}else if(p_pod_cd_temp.GetItemCount() > 1){
							//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				    		p_pod_cd_temp.SetSelectIndex(0);
				    		formObj.p_pod_cd_temp.focus();
				    		ComShowCodeMessage('BKG95001','select a POFE');
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(false);
				    		return;
						}else{
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(false);
							return;
			    		}
		    		}
					if ( ComIsNull(formObj.p_search_pofe_yard_cd) ) {
		    			ComShowCodeMessage('BKG03061','POFE');
//		    			sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(false);
		    			return;
					}
					formObj.f_cmd.value=SEARCH;
					formObj.p_pod_cd.value=formObj.p_pod_yard_cd.value.substring(0,5);
					if(p_pod_cd_temp.GetItemCount() > 1) {
						//no support[check again]CLT 						formObj.p_pod_cd_temp.UseCode=false;
						formObj.p_first_of_multi_pofe_cd.value=p_pod_cd_temp.GetText(0,0);
						//no support[check again]CLT 						formObj.p_pod_cd_temp.UseCode=true;
					}
					var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					if(ComGetEtcData(sXml,"div_pol") == undefined){
						$divOption.html(""); //"POL :  / ETD :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; POD (1st EU Port) :  / ETA : " ;
						$divOption.hide();
						formObj.div_ttl_bl.value="0";
						formObj.div_ttl_err.value="0";
						formObj.div_ttl_cntr.value="0";
						formObj.port_ofc_cd.value="";
						formObj.div_sent_bl_cnt.value="0";
						formObj.div_unsent_bl_cnt.value="0";
						formObj.div_sent_bl_cnt2.value="0";
						formObj.div_a_cnt.value="0";
						formObj.div_r_cnt.value="0";
						formObj.div_dnl_cnt.value="0";
						formObj.div_nr_cnt.value="0";
						ata_yn="";
						arn_yn="";
						dr_yn="";
						trsm_val="";
						nl_err_msg="";
						eta_err_msg="";
	//			
					}else{
						var divOptnTxt ="POL : "                + ComGetEtcData(sXml,"div_pol")
						                     + " / ETD : "             + ComGetEtcData(sXml,"vps_etd_dt")
						                     + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
						                     +" POD (1st EU Port) : "  + ComGetEtcData(sXml,"eu_1st_port")
						                     + " / ETA : "             + ComGetEtcData(sXml,"vps_eta_dt");
						$divOption.show();
						$divOption.html(divOptnTxt);
						formObj.div_ttl_bl.value=ComGetEtcData(sXml,"ttl_bl");
						formObj.div_ttl_err.value=ComGetEtcData(sXml,"ttl_err_bl");
						formObj.div_ttl_cntr.value=ComGetEtcData(sXml,"ttl_cntr");
						formObj.port_ofc_cd.value=ComGetEtcData(sXml,"port_ofc_cd");
						formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
						formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
						formObj.div_sent_bl_cnt2.value=ComGetEtcData(sXml,"sent_bl_cnt");
						formObj.div_a_cnt.value=ComGetEtcData(sXml,"a_cnt");
						formObj.div_r_cnt.value=ComGetEtcData(sXml,"r_cnt");
						formObj.div_dnl_cnt.value=ComGetEtcData(sXml,"dnl_cnt");
						formObj.div_nr_cnt.value=ComGetEtcData(sXml,"nr_cnt");
						ata_yn          =ComGetEtcData(sXml,"ata_yn");
						arn_yn          =ComGetEtcData(sXml,"arn_yn");
						dr_yn           =ComGetEtcData(sXml,"dr_yn");
						trsm_val=ComGetEtcData(sXml,"trsm_val");
						nl_err_msg=ComGetEtcData(sXml,"nl_err_msg");
						eta_err_msg=ComGetEtcData(sXml,"eta_err_msg");
						if(ComGetObjValue(formObj.p_data_cd) == "DL"){
	 						if(ComGetEtcData(sXml,"ens_edi_svc_flg") == "Y")
	 							ComBtnEnable("btn_Transmit");
	 						else
	 							ComBtnDisable("btn_Transmit");
	 					}
						/* 전체 블로킹에서 개별 B/L별 블로킹으로 바뀜 전송시 체크함
						if( 
								//ComGetEtcData(sXml,"eu_1st_port").substring(0,2) =="ES" && 
								ComGetObjValue(formObj.p_ori_amd_cd) == "A"){
							ComShowCodeMessage('BKG01142');
							ComBtnDisable("btn_Transmit");
						}
						*/
					}
					formObj.p_down_yn_first_of_multi_pofe.value=ComGetEtcData(sXml,"down_yn_first_of_multi_pofe");
//					sheetObj.RenderSheet(1);
					sheetObj.SetWaitImageVisible(0);
				} else { // Finland (IE344)
					if(!validateForm(sheetObj,formObj,sAction)) {
						ComOpenWait(false);
						return;
					}
//					sheetObj.RenderSheet(0);
					sheetObj.SetWaitImageVisible(1);
					sheetObj.RemoveAll();
					// B/L No 만 입력하고 조회시
					if (!ComIsNull(formObj.p_fi_bl_no) && ComIsNull(formObj.p_fi_vvd_cd)) {
						formObj.f_cmd.value=SEARCH07;
						var preEUportXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
						formObj.p_fi_vvd_cd.value=ComGetEtcData(preEUportXml, "vvd");
						formObj.p_fi_pod_cd.value=ComGetEtcData(preEUportXml, "pod");
						formObj.p_fi_pod_yard_cd.value=ComGetEtcData(preEUportXml, "pod_yd");
						doActionIBSheet(sheetObj, formObj, SEARCH06); // pre EU port 조회
						if(formObj.p_fi_pod_cd.value == ""){
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_fi_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(false);
							return;
			    		}
						if(formObj.p_fi_pol_cd.value == ""){
							ComShowCodeMessage('BKG03061','BL:'+formObj.p_fi_bl_no.value);
//							sheetObj.RenderSheet(1);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(false);
							return;
			    		}
		    		}
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					if(ComGetEtcData(sXml,"div_pod") == undefined){
						$divOption.html(""); //"POL(pre EU Port) :  / ETD :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; POD :  / ETA : " ;
						$divOption.hide();
						formObj.div_ttl_bl.value="0";
						formObj.div_ttl_err.value="0";
						formObj.div_ttl_cntr.value="0";
						formObj.port_ofc_cd.value="";
						formObj.div_sent_bl_cnt.value="0";
						formObj.div_unsent_bl_cnt.value="0";
						formObj.div_sent_bl_cnt2.value="0";
						formObj.div_a_cnt.value="0";
						formObj.div_r_cnt.value="0";
						formObj.div_dnl_cnt.value="0";
						formObj.div_nr_cnt.value="0";
						ata_yn="";
						arn_yn="";
						dr_yn="";
						trsm_val="";
					}else{
						var divOptnTxt = "POL (pre EU Port) : "  + ComGetEtcData(sXml,"div_pol")
						                     + " / ETD : "             + ComGetEtcData(sXml,"vps_etd_dt")
						                     + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
						                     +" POD               : "  + ComGetEtcData(sXml,"div_pod")
						                     + " / ETA : "             + ComGetEtcData(sXml,"vps_eta_dt");
						$divOption.show();
						$divOption.html(divOptnTxt);
						formObj.div_ttl_bl.value=ComGetEtcData(sXml,"ttl_bl");
						formObj.div_ttl_err.value=ComGetEtcData(sXml,"ttl_err_bl");
						formObj.div_ttl_cntr.value=ComGetEtcData(sXml,"ttl_cntr");
						formObj.port_ofc_cd.value=ComGetEtcData(sXml,"port_ofc_cd");
						formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
						formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
						formObj.div_sent_bl_cnt2.value=ComGetEtcData(sXml,"sent_bl_cnt");
						formObj.div_a_cnt.value=ComGetEtcData(sXml,"a_cnt");
						formObj.div_r_cnt.value=ComGetEtcData(sXml,"r_cnt");
						formObj.div_dnl_cnt.value=ComGetEtcData(sXml,"dnl_cnt");
						formObj.div_nr_cnt.value=ComGetEtcData(sXml,"nr_cnt");
						ata_yn          =ComGetEtcData(sXml,"ata_yn");
						arn_yn          =ComGetEtcData(sXml,"arn_yn");
						dr_yn           =ComGetEtcData(sXml,"dr_yn");
						trsm_val=ComGetEtcData(sXml,"trsm_val");
						if(ComGetObjValue(formObj.p_data_cd) == "DL"){
	 						if(ComGetEtcData(sXml,"ens_edi_svc_flg") == "Y")
	 							ComBtnEnable("btn_Transmit");
	 						else
	 							ComBtnDisable("btn_Transmit");
	 					}
					}
//					sheetObj.RenderSheet(1);
					sheetObj.SetWaitImageVisible(0);
				}
				ComOpenWait(false);
				SetButtonStatus();
				break;
			case SEARCH01 : // eu_1st_port 조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
//			sheetObj.RenderSheet(0);
			sheetObj.SetWaitImageVisible(1);
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, p_pod_cd_temp, "search_eu_1st_port_yd_cd", "eu_1st_port_name");
			formObj.p_pod_cd.value="";
			formObj.p_pod_yard_temp.value="";//현재 사용안함
			formObj.p_pod_yard_cd.value="";
			sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
			//formObj.p_pod_cd.value = ComGetEtcData(sXml,"eu_1st_port");
//			sheetObj.RenderSheet(1);
			sheetObj.SetWaitImageVisible(0);
			break;
			case SEARCH05 : // eu 포트 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
//				sheetObjects[1].RenderSheet(0);
				sheetObjects[1].SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
//				sheetObjects[1].RenderSheet(1);
				sheetObjects[1].SetWaitImageVisible(0);
				break;
			case MULTI: //저장
				
				if ( !validateForm(sheetObj, formObj, sAction)) return;
	            var cntr_list="";
				var arrRow=ComFindText(sheetObj, "sel", 1);
				if(p_type.GetSelectCode()== "ENS") { // ENS 전송
					var p_eu_1st_port="";
					var p_eu_1st_port_yd_cd="";
					if (arrRow && arrRow.length > 0) {
						p_eu_1st_port_yd_cd=sheetObj.GetCellValue(arrRow[0], "eu_1st_port_yd_cd");
						for (var i=0; i<arrRow.length; i++) {
							cntr_list += sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+","+
							sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+","+
							sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+","+
							sheetObj.GetCellValue(arrRow[i], "bl_no"        )+","+
							sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+","+
							sheetObj.GetCellValue(arrRow[i], "cntr_cntr_no" )+","+
							sheetObj.GetCellValue(arrRow[i], "edi_mrn"      )+","+
							sheetObj.GetCellValue(arrRow[i], "msg_snd_no"			)+","+
							sheetObj.GetCellValue(arrRow[i], "cstms_estm_arr_dt"	)+","+
							sheetObj.GetCellValue(arrRow[i], "eu_1st_port_clpt_seq")+"@";
						}
					}
					if(ComGetLenByByte(cntr_list) > 4000){
						cntr_list=getStringToClobString(cntr_list, 30,"@")
					} else{
						cntr_list="'"+cntr_list+"'";
					}
					var pType=p_type.GetSelectCode();
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					var sParam="&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list+"&eu_1st_port="+p_eu_1st_port+"&eu_1st_port_yd_cd="+p_eu_1st_port_yd_cd+"&p_type="+ pType;
				} else { // Finland (IE344)
					if (arrRow && arrRow.length > 0) {
						for (var i=0; i<arrRow.length; i++) {
							cntr_list += sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+","+
							sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+","+
							sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+","+
							sheetObj.GetCellValue(arrRow[i], "bl_no"        )+","+
							sheetObj.GetCellValue(arrRow[i], "pod"			 )+","+
							sheetObj.GetCellValue(arrRow[i], "cntr_cntr_no" )+","+
							sheetObj.GetCellValue(arrRow[i], "edi_mrn"      )+","+
							sheetObj.GetCellValue(arrRow[i], "msg_snd_no" )+","+
							sheetObj.GetCellValue(arrRow[i], "cstms_estm_arr_dt")+"@";
						}
					}
					if(ComGetLenByByte(cntr_list) > 4000){
						cntr_list=getStringToClobString(cntr_list, 30,"@")
					} else{
						cntr_list="'"+cntr_list+"'";
					}
					var pType=p_type.GetSelectCode();
//					alert("pType >>> " + pType);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					var sParam="&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list+"&p_type="+ pType;
				}
				var xmlStr=sheetObj.GetSaveData("ESM_BKG_1106GS.do", sParam);
			  var sResult=ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
			  sheetObj.LoadSaveData(xmlStr);
			  ComOpenWait(false);
			  sheetObj.SetWaitImageVisible(0);
			  // 다운로드 후  버튼 비활성화,재조회 한다.
	      		ComSetObjValue(formObj.p_data_cd,"DL");
	    		ComBtnEnable("btn_Inquiry");
				ComBtnEnable("btn_Transmit");
				ComBtnDisable("btn_EDIDownload");
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);
			  break;
			case SEARCH06 : // Finland (IE344) pre EU port 조회
//				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH06;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", FormQueryString(formObj));
				sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
				sheetObj.SetWaitImageVisible(0);
//				sheetObj.RenderSheet(1);
				break;
			case MULTI05: // 데이터 삭제
				if (!validateForm(sheetObj, formObj, sAction)) return;
					if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
					if(p_type.GetSelectCode()== "ENS") {
			            var cntr_list="";
						var arrRow=ComFindText(sheetObj, "sel", 1);
						if (arrRow && arrRow.length > 0) {
							for (var i=0; i<arrRow.length; i++) {
								cntr_list += sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+","+
								sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+","+
								sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+","+
								sheetObj.GetCellValue(arrRow[i], "bl_no"        )+","+
								sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+","+"@";
							}
						}
						if(ComGetLenByByte(cntr_list) > 4000){
							cntr_list=getStringToClobString(cntr_list, 30,"@")
						} else{
							cntr_list="'"+cntr_list+"'";
						}
						formObj.f_cmd.value=MULTI05;
						var sParam="&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list;
			        }
				var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do", sParam);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				doActionIBSheet(sheetObj,form,IBSEARCH); // 데이터 삭제 후 재조회함
				break;
	        }
	    }
				
     /**
      * BackEndJob 실행결과조회<br>
      * 
      * @param sheetObj
      * @param sKey
      */
     function doActionValidationResult(sheetObj, sKey) {
    	 var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
     	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
     	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
     	// 에러가 발생했을 경우 대기사항을 종료한다.
     	if (!ComBkgErrMessage(sheetObj, sXml)) {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		return;
     	}
     	if (sJbStsFlg == "SUCCESS") {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 성공메시지 보여주고
     		ComShowCodeMessage('BKG00101');	
     		//resultlist.innerHTML = "<pre>"+ ComGetEtcData(sXml, "RESULT")+"</pre>";
     		//전송 성공 후 재조회함.
     		doActionIBSheet(sheetObj,form,IBSEARCH);
     		return;
     	} else if (sJbStsFlg == "FAIL") {
     		//에러
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 에러메시지 보여주고
     		ComShowMessage(ComResultMessage(sXml));
     	}
     }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
	    		if(p_type.GetSelectCode()== "ENS") {
		    		if (!ComIsNull(formObj.p_bl_no)) {
		    			return true;
		    		}
	    			if (ComIsNull(formObj.p_vvd_cd)) {
	    				ComShowCodeMessage('BKG00104','VVD');
	 					formObj.p_vvd_cd.focus();
	 					return false;    
	    			}
	    			if (ComIsNull(formObj.p_pol_cd)) {
	    				ComShowCodeMessage('BKG00104','POL');
	    				formObj.p_pol_cd.focus();
	    				return false;    
	    			}
	    			if (ComGetObjValue(formObj.p_pod_cd_temp) == "") {
	    				//alert(ComGetObjValue(formObj.p_pod_cd_temp));
	    				ComShowCodeMessage('BKG00104','POFE');
	    				formObj.p_pod_cd_temp.focus();
	    				return false;    
	    			}
	    		} else { // Finland (IE344)
	    			if (!ComIsNull(formObj.p_fi_bl_no)) {
		    			return true;
		    		}
	    			if (ComIsNull(formObj.p_fi_vvd_cd)) {
	    				ComShowCodeMessage('BKG00104','VVD');
	 					formObj.p_fi_vvd_cd.focus();
	 					return false;    
	    			}
	    			if (ComIsNull(formObj.p_fi_pod_cd)) {
	    				ComShowCodeMessage('BKG00104','POD');
	    				formObj.p_fi_pod_cd.focus();
	    				return false;    
	    			}
	    			if (ComIsNull(formObj.p_fi_pol_cd)) {
	    				//alert(ComGetObjValue(formObj.p_fi_pol_cd));
	    				ComShowCodeMessage('BKG00104','pre EU port');
	    				formObj.p_fi_pol_cd.focus();
	    				return false;
	    			}
	    		}
	    		/* EU POL Validation 제거 
			    			if(sheetObjects[1].FindText('cnt_cd',form.p_pol_cd.value.substring(0,2)) > 0 ){
			    				ComShowCodeMessage('BKG01139');
			    				formObj.p_pol_cd.focus();
			    				return false;
			    			}
			    */
				break;
	    	case MULTI://다운로드
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189"); // 'Nothing selected';
	    			return false;
	    		}
	    		var objPofe=p_pod_cd_temp
	    		var pofeCnt=objPofe.GetItemCount();
	    		/*
	    		 * POFE 가 2개 일 경우
	    		 * 조회 옵션으로 1번째 POFE 선택 조회 시 DOWNLOAD 하면 
	    		 * 무조건 경고 메시지를 보여준다
	    		 */
	    		if(pofeCnt > 1 && objPofe.GetSelectIndex()== 0) {
   					ComShowCodeMessage("BKG06140");
	    		}
	    		/*
	    		 * POFE 가 2개 일 경우
	    		 * 조회 옵션으로 2번째 POFE 선택 조회 시 
	    		 * 1번째 POFE가 다운로드가 되었는지 판단
	    		 * 		- 다운로드 되었으면 계속 진행
	    		 * 		- 다운로드 안되었으면 경고 메시지 보여주고 POFE로 FOCUS 이동 후 종료
	    		 */
	    		if(pofeCnt > 1 && objPofe.GetSelectIndex()== 1 && formObj.p_down_yn_first_of_multi_pofe.value == "N" ) {
   					ComShowCodeMessage("BKG06139");
   					formObj.p_pod_cd_temp.focus();
   					return false;
	    		}
	    		var arrRow=ComFindText(sheetObj, "sel", 1);
			    /* 
			     * CM 당 각각의 Package Count : MAX 99,999 (N5) - 최대 5자리까지 입력 가능
			     * 상위 기준 이상의 값이 입력된 경우 C/M의 PK 칼럼이 E (Error)로 표기되고  
			     * Each Package of CM cannot be exceed over 99,999 메시지 발생
			     */	    
	    		for (var i=0; i<arrRow.length; i++) {
	    			if(sheetObj.GetCellValue(arrRow[i], "cntr_pk_lmt_flg") == "Y"){
				    	ComShowCodeMessage("BKG06152"); // Each Package of CM cannot be exceed over 99,999
				    	return false;
				    }
	    		}
	    		/*
	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
	    		 * */
	    		var errorCnt=0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var errorBls="";
	    		var tempBl="";
	    		var errBlArray=new Array();
	    		var preBlNo = "";
	    		for (var i=0; i<arrRow.length; i++) {
	    			if(sheetObj.GetCellValue(arrRow[i], "err_yn") == "Y") {
//	    				if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined) { // bl단위로 에러 메시지를 보여주기 위함.
	    				if (preBlNo != sheetObj.GetCellValue(arrRow[i], "bl_no")) {
		    				errorCnt++;
		    				if(errorCnt > 10)
		    					continue;
		    				else
		    					errorBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
	    				}
	    				preBlNo = sheetObj.GetCellValue(arrRow[i], "bl_no");
	    			}
	    		}
			    if(errorCnt > 0){
					errorBls=errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
					//에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
					if(!ComShowConfirm(ComGetMsg("BKG01133",errorBls,"Will you proceed to download?")) ){ // Error B/L ({?msg1}) is included. {?msg2}
						return false;
					}
			    }
	    		break;
	    	case MULTI01:// EDI FLAT FILE 생성 및 전송
	    	case MULTI03:// EDI FLAT FILE 생성 및 전송 단건
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189"); // Nothing selected
	    			return false;
	    		}
	    		if (ComIsNull(formObj.port_ofc_cd)) {
	    			ComShowCodeMessage('BKG01131'); // Customs office doen't exist. Please register.
	    			return false;    
	    		}
	    		if(eta_err_msg == "Y") { // ETA가 30일이 지나도 전송이 가능하게 하는 것으로 Customs Common Code 페이지에서 설정 가능
		    		if (location.href.indexOf("alpsdev") < 0  && ata_yn == "Y") {
		    			ComShowCodeMessage('BKG01140'); // "The vessel already arrived at POFE. ENS can not be manifested anymore."
		    			return false;    
		    		}
		    		if (trsm_val == "Y") {
		    			ComShowCodeMessage('BKG06151'); // "Not possible to send ENS, ENS ETA is already passed."
		    			return false;    
		    		}
	    		}
				//DR전송 BL은 재전송 못하게 한다. bl대신 VVD 입력 2011.02.11 최초 1row만 체크
				if(dr_yn == "Y"){
			    	ComShowCodeMessage("BKG01138", formObj.p_vvd_cd.value,""); // Diversion Request for “{?msg1}” is already submitted. ENS won’t be submitted after Diversion Request
			    	return false;
				}
	    		if (arn_yn == "Y") {
	    			ComShowCodeMessage('BKG01145',formObj.p_vvd_cd.value); // ENS manifest for {?msg1} is not possible anymore.\nArrival Notification has been already sent by our inbound office to POFE.
	    			return false;    
	    		}
	    		var errYN="N";
	    		var arrRow=ComFindText(sheetObj, "sel", 1);
	    		var nodownCnt=0;//다운로드 하지 않은 개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var nodownBls="";
	    		/*
	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
	    		 * */
	    		var errorCnt=0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var errorBls="";
	    		/* not received이 존재하면 확인창 후 취소 버튼 클릭시 진행 안함 */
	    		var nrCnt=0;
	    		var nrBls="";
	    		var ensRslt="";
	    		/*
	    		 * Amend전송: Send log 테이블, cre_dt 기준,  1/18 17:18 분 이후 건에 대해 Amendment Block,  BL은 재전송 못하게 한다.
	    		 * */
	    		var amdCnt=0;  //amd개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var amdBls="";
	    		var tempBl="";
	    		var errBlArray=new Array();
				for (var i=0; i<arrRow.length; i++) {
					if(sheetObj.GetCellValue(arrRow[i], "err_yn") == "Y"){
						if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
							errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")]=sheetObj.GetCellValue(arrRow[i], "bl_no");
							errorCnt++;
							if(errorCnt <= 10)
								errorBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
						}
					}
					if (tempBl== sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					tempBl=sheetObj.GetCellValue(arrRow[i], "bl_no");
					/* 2010-11-30 Download조회에서만 전송버튼이 활성화 되므로 이부분은 현재 실효성은 없으나 초기버전대로 일단 수행은 한다.*/
					if(sheetObj.GetCellValue(arrRow[i], "download_yn") == "N"){
						nodownCnt++;
						if(nodownCnt <= 10)
							nodownBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
					}
					// POFE 가 NL 이고 전송은 했으나 아직 ACK가 안 온 상태에서 전송 불가하게 수정
					// POFE 가 NL 이고 전송은 했으나 SYSTEM ACK 만 수신된 상태에서 전송 불가
					ensRslt=sheetObj.GetCellValue(arrRow[i], "ens_result");
					if(sheetObj.GetCellValue(arrRow[i], "result2") == "NR" || ensRslt.substring(ensRslt.length, ensRslt.length-3) == "(S)"){
						nrCnt++;
						if(nrCnt <= 10)
							nrBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
					}
					if(  (form.p_pod_yard_cd.value.substring(0,2) == "GB" && sheetObj.GetCellValue(arrRow[i], "edi_mrn") !='' && sheetObj.GetCellValue(arrRow[i], "kts_send_dt") < "2011012123")
							||(form.p_pod_yard_cd.value.substring(0,2) != "GB" && sheetObj.GetCellValue(arrRow[i], "edi_mrn") !='' && sheetObj.GetCellValue(arrRow[i], "kts_send_dt") < "2011011817")
					   ){
						amdCnt++;
						if(amdCnt <= 10)
							amdBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
					}
				}//end for
				if(nodownCnt > 0){
					nodownBls=nodownCnt > 10 ? nodownBls+"..etc.":nodownBls.substring(0,nodownBls.length-1);
					ComShowCodeMessage("BKG01130",nodownBls,""); // {?msg1} B/L(s) were not downloaded. Please \"Download\" first, before \"transmit\". \nB/L #: {?msg2}.
					return false;
				}
			    if(errorCnt > 0){
					errorBls=errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
			    	ComShowCodeMessage("BKG01133",errorBls,""); // Error B/L ({?msg1}) is included. {?msg2}
			    	return false;
			    }
//				에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
			    if(nl_err_msg == "Y"){ // 네덜란드 세관에서 응답 메시지가 오지 않아도 전송이 가능하게 하는 것으로 Customs Common Code 페이지에서 설정 가능
					if(nrCnt > 0 ){
						// POFE 가 NL 이고 전송은 했으나 아직 ACK가 안 온 상태에서 전송 불가하게 수정
						// POFE 가 NL 이고 전송은 했으나 SYSTEM ACK 만 수신된 상태에서 전송 불가
					    var pofeCntCd=ComGetObjValue(formObj.p_pod_cd_temp).substring(0,2);
					    if(pofeCntCd == "NL"){
					    	for (var i=0; i<arrRow.length; i++) {
					    		if (sheetObj.GetCellValue(arrRow[i], "ens_result") == "Not Received"
					    			|| ensRslt.substring(ensRslt.length, ensRslt.length-3) == "(S)"){ //"(S)"가 어떻게 나오는 건지 모르겠다.
					    			nrBls=nrCnt > 10 ? nrBls+"..etc.":nrBls.substring(0,nrBls.length-1);
					    			if(!ComShowMessage(ComGetMsg("BKG06144",nrBls)) ) // [{?msg1}] ENS was already transmitted and the Ack message is not received yet. Please wait more. Duplicate ENS is not allowed for NL customs.
					    				return false;
					    		}
					    	}
					    } else {
					    	nrBls=nrCnt > 10 ? nrBls+"..etc.":nrBls.substring(0,nrBls.length-1);
					    	if(!ComShowConfirm(ComGetMsg("BKG01141",nrBls)) ) // [{?msg1}] EDI is already transmitted and Ack Message is not received yet. Will you re-transmitted EDI?
					    		return false;
					    }
					}
			    }
			    if(amdCnt > 0){
			    	amdBls=amdCnt > 10 ? amdBls+"..etc.":amdBls.substring(0,amdBls.length-1);
			    	if( form.p_pod_yard_cd.value.substring(0,2) == "GB")
			    		ComShowCodeMessage("BKG01142",amdBls,"21th"); // ENS Amendment to ES is not acceptable for a while.\nOnly original ENS is accepted by ES customs at this moment.
			    	else
			    		ComShowCodeMessage("BKG01142",amdBls,"18th"); // ENS Amendment to ES is not acceptable for a while.\nOnly original ENS is accepted by ES customs at this moment.
			    	return false;
			    }
				break;
	    	case MULTI05 :
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189"); // 'Nothing selected';
	    			return false;
	    		}
	    		break;
	    }//end case
        return true;
    }
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=ComGetEvent().getAttribute("maxlength");
    	var srcValue=ComGetEvent().getAttribute("value");
    	if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
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
				with (sheetObj) {
			        var HeadTitle1="|Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|rfs_yn|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|B/L Data|B/L Data|B/L Data|trsm_blck_flg|Container Data|Container Data|Container Data|Container Data|Container Data|Container Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|rcv_msg|EDI|EDI|EDI|EDI|EDI|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|cstms_estm_arr_dt|pol_clpt_ind_seq|pod_clpt_ind_seq|eu_1st_port_clpt_seq|eu_stf_flg";
			        var HeadTitle2="|Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|rfs_yn|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|PK|WT|MS|trsm_blck_flg|CNTR  No|Seal|cntr_pk_lmt_flg|PK|WT|MS|PK|WT|MS|DS|MK|HS|rcv_msg|Ack. Status|Sent Time(GMT)|MRN|Ref No|Received Time(GMT)|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|cstms_estm_arr_dt|pol_clpt_ind_seq|pod_clpt_ind_seq|eu_1st_port_clpt_seq";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:5, DataRowMerge:0 } ); // 나누어지는 행의 숫자는 Page : '숫자'로 나타낸다.
	
			        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_status",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bpol",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bpod",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"del",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ct",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfs_yn",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ad",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ct",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_cn",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_zip",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_str",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_eori",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ad",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ct",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_zip",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_str",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_eori",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ad",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ct",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_zip",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_str",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_eori",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_pk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_wt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_ms",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsm_blck_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_pk_lmt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_pk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ms",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_pk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_wt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_ms",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_ds",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_mk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_hts",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_msg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ens_result",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"sent_time",             MultiLineText:1,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"received_time", MultiLineText:1,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"err_yn",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"download_yn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"msg_snd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_yn",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"kts_send_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_estm_arr_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_clpt_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_clpt_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_clpt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_stf_flg",  			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			        
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetCountPosition(0);
			              //no support[check again]CLT 					SetSortDialog(false	);
			        //no support[implemented common]CLT 					SelectHighLight=true;
			        //no support[check again]CLT 				    MultiSelection=true;
			        SetSelectionMode(smSelectionRow);
			        SetSheetHeight(270);
			        SetRangeBackColor(1,13,1,60,"555555");
				}
				break;
		case "sheet2":
			with (sheetObj) {
		        var HeadTitle1="|cnt_cd";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        headCount=ComCountHeadTitle(HeadTitle1);
	
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
	
				SetEditable(0);
				SetCountPosition(0);
		        //no support[implemented common]CLT 				SelectHighLight=false;
				SetSheetHeight(280);
			}
			break;
		case "sheet3":
			with (sheetObj) {
		        var HeadTitle1="|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_clpt_seq|eu_1st_port_name|edi_mr|clpt_ind_seq";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        headCount=ComCountHeadTitle(HeadTitle1);
	
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_clpt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clpt_ind_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		         
		        InitColumns(cols);
	
				SetEditable(0);
				SetCountPosition(0);
				//no support[implemented common]CLT 				SelectHighLight=false;
				SetSheetHeight(280);
			}
			break;
		case "sheet4":
			with (sheetObj) {
		        var HeadTitle1="|p_fi_pol_cd|p_fi_pol_yard_cd";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        headCount=ComCountHeadTitle(HeadTitle1);
	
		        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
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
    function sheet1_OnChange(o,r,c,v){
    	try{
    		//머지된 영역의 값을 동일하게 세팅해 주자.
    		if(sheetObjects[0].ColSaveName(c)=="sel") {
    			var chgValue=v;
    			//머지시작점
    			var mergeStartRow=parseInt((sheetObjects[0].GetMergedStartCell(r,37)).split(",")[0]);
    			//머지끝점
    			var mergeEndRow=parseInt((sheetObjects[0].GetMergedEndCell(r,37)).split(",")[0]);
    			for(var x=mergeStartRow;x<=mergeEndRow;x++){
    				sheetObjects[0].SetCellValue(x,"sel",chgValue,0);
    			}
    		}
    	}catch(e){
    		alert(e.message);
    	}
    	if (sheetObjects[0].GetCellValue(r,"trsm_blck_flg")=="Y"){
    		sheetObjects[0].SetCellValue(r,"sel",0,0);
		}
    }
    /*
     * Pre EU port 조회 후 해당 값을 폼에 셋팅 
     */
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	
    	//formObj.p_fi_pol_cd.value=sheetObjects[3].GetCellValue(1,"p_fi_pol_cd");
		//formObj.p_fi_pol_yard_cd.value=sheetObjects[3].GetCellValue(1,"p_fi_pol_yard_cd");
    	
    	var pfPolCd = sheetObjects[3].GetCellValue(1,"p_fi_pol_cd");
    	var pfPolYd = sheetObjects[3].GetCellValue(1,"p_fi_pol_yard_cd");
    	
    	if(pfPolCd != "-1") 
    		formObj.p_fi_pol_cd.value = pfPolCd;
    	if(pfPolYd != "-1")
    		formObj.p_fi_pol_yard_cd.value = pfPolYd;
    }