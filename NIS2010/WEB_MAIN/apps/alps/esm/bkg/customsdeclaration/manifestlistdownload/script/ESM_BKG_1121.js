/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1121.js
*@FileTitle : Europe Advanced Manifest  : EXS Download  & Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.06.07 박성진
* 1.0 Creation
*--------------------------------------------------------
* History
* 2011.08.24 김경섭 [CHM-201111367] [BKG] BKG-UI_1121 ALPS TEST버전 - EXS Function 개발 - update reason 칼럼 추가 및 특수문자 제거
* 2012.09.04 김보배 [CHM-201220027] [BKG] [EXS 신고화면 및 레포트화면] Released 추가 (조회조건 Status/ Summary 합계)
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
     * @class ESM_BKG_1121 : ESM_BKG_1121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1121() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
	
    //전역변수
    var intervalId = "";
       
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }
    
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObj = document.form;
    	
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
		ComBtnDisable("btn_Inquiry");
		ComBtnDisable("btn_Transmit");
		
		//화면에서 필요한 이벤트
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);

	}
    
     function initControl() {
     	var formObject = document.form;

         axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
         axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
         axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ('change', 'bkg_change', formObject);
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
  	    var formObject = document.form
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
	 			MultiSelect = false;
	 			UseEdit = false;
	 			BackColor = "#CCFFFD";
	 			ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	 		}
 		}
 	} 	
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  

	
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
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

	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_vvd_cd":
	    		sheetObjects[2].RemoveAll();
	    		form.p_pol_cd_temp.RemoveAll();
	    		form.p_pod_yard_cd.value = "";
//	   	 		form.p_search_pofe_yard_cd.value = "";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		
	    		if(form.p_pol_cd_temp.GetCount() >= 1 ){
	    			form.p_pol_cd_temp.Index = 0;
	    		}
	    		form.p_pod_cd.focus();
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
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
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
	function p_pol_cd_temp_OnChange(comboObj, value, text){
		 if(value.substr(0,2)=="GB"){
			 sheetObjects[0].ColHidden("update_reason") = false;
		 }else{
			 sheetObjects[0].ColHidden("update_reason") = true;
		 }
			
	}       
	
	


	    /**
	     * 시트를 행 다중선택 시 처리
	     */
	    function sheet1_OnSelectMenu(sheetObj, sAction) {

	    	 //메뉴에 대한 처리 Check selected|Unheck selected|-|Check all|Uncheck all
	    	  switch(sAction){
	    	    case "Check selected" :
	    	      var sRowStr = sheetObj.GetSelectionRows("/");
	    		  
	    	      //자바 스크립트 배열로 만들기
	    	      var arr = sRowStr.split("/");
	    	      for (i=0; i<arr.length; i++) {
	    	    	  if(arr[i] < 2) continue;//header 부분
	    	    	  if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	    	    	  
	    	    	  if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	    	    		  	var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
		  		    		for(var j =0; j <= sameRows.length ; j++) {
		  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
		  		    			sheetObj.CellValue2(sameRows[j], "sel") = 1;		  			    		
		  		    		}
		  		    		
	    	    	  }else
	    	    		  sheetObj.CellValue2(arr[i], "sel") = 1;
	    	      }
	    	      break;
	    	    case "Unheck selected" :
	    	    	var sRowStr = sheetObj.GetSelectionRows("/");
	    	    	
	    	    	//자바 스크립트 배열로 만들기
	    	    	var arr = sRowStr.split("/");
	    	    	for (i=0; i<arr.length; i++) {
	    	    		if(arr[i] < 2) continue;//header 부분
	    	    		if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	    	    		
	    	    		if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	    	    			var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
	    	    			for(var j =0; j <= sameRows.length ; j++) {
	    	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
	    	    				sheetObj.CellValue2(sameRows[j], "sel") = 0;		  			    		
	    	    			}
	    	    			
	    	    		}else
	    	    			sheetObj.CellValue2(arr[i], "sel") = 0;
	    	    	}
	    	      
	    	      break;

	    	    case "Check all" :
	    	    	sheetObj.CheckAll2("sel") = 1;  break;
	    	    case "Uncheck all" :
	    	    	sheetObj.CheckAll2("sel") = 0;  break;
	    	  }
	    	  
	    }
	    
	    var startSelectedRow =0 ; //shift + 마우스 클릭 으로 체크시키기  위함.
	    /**
	     * sheet1 All 체크시 체크플래그 세팅
	     * @param sheetObj 시트오브젝트
	     * @param Button 마우스버튼 방향
	     * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	     * @param X X 좌표
	     * @param Y Y 좌표
	     */
	    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	    	if(Shift == 0){
	    		startSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
	    		
	    		var colSaveName = sheetObj.ColSaveName(sheetObj.MouseCol);
		        var check = sheetObj.CellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
		        var keySeq = sheetObj.CellValue(startSelectedRow,"dt_seq");
		        
		        switch(colSaveName) {
			    	case "sel" :
			    		if(startSelectedRow < 2) return;
			    		//alert(startSelectedRow +" "+check+" "+keySeq);
			    		for(i=startSelectedRow ; i<= sheetObj.LastRow ; i++) {
			    				if(eval(keySeq) < eval(sheetObj.CellValue(i, "dt_seq")) ) break;
			    				
				    			if(keySeq == sheetObj.CellValue(i, "dt_seq")) {
			    					sheetObj.CellValue(i, "sel") = check;
				    					
				    			}
				    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
				    			
			    		}
			    		break;
				       
		        } // end switch
	    		
	    	}else{
	    		var endSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.;
	    		startSelectedRow = startSelectedRow ==0 ? endSelectedRow:startSelectedRow;
		    		if(startSelectedRow > endSelectedRow){
		    			endSelectedRow = startSelectedRow;
		    			startSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
		    		}
		    		
		    		for (var i=startSelectedRow; i <= endSelectedRow; i++) {
		    	    	  if(i < sheetObj.HeaderRows) continue;//header 부분
		    	    	  if(sheetObj.CellValue(i,"bl_no") == "") continue;//subsum 행이면
		    	    	  
		    	    	  if(i== endSelectedRow){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
		    	    		  	var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(i,"dt_seq"));
			  		    		for(var j =0; j <= sameRows.length ; j++) {
			  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
			  		    			sheetObj.CellValue2(sameRows[j], "sel") = 1;		  			    		
			  		    		}
			  		    		
		    	    	  }else{
		    	    		  sheetObj.CellValue2(i, "sel") = 1;
		    	    	  }
		    	      }
	    	}//shift end
	    }//method end
	    	    
	    /**
	     * 시트를 클릭했을 때 처리 0127참조
	     */
	    function sheet1_OnClick(sheetObj, row, col) {
	    	
	    	var colSaveName = sheetObj.ColSaveName(col);
	        switch(colSaveName) {
		    	case "sel" :
		    		 if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
			        var check = sheetObj.CellValue(row,"sel") == 1 ?0:1;
		    		sheetObj.CellValue2(row, "sel") = check;//mousedown 에서 처리한것을 다시 역으로 처리하므로 이것을 다시 역으로 바꿔준다.
		    		break;
		    		
		    	case "ens_result":

	                if (sheetObj.CellValue(row,"result2") != "R" && sheetObj.CellValue(row,"result2") != "DNL" 
	                	&& sheetObj.CellValue(row,"result2") != "D" && sheetObj.CellValue(row,"result2") != "P" && sheetObj.CellValue(row,"result2") != "H") {
	                	return;
	                }	                
		    		 
	    			 //ComShowMemoPad(sheetObj, row, "rcv_msg", true, 300, 150);	//편집불가능
		    	 
			       var edi_rcv_dt  = sheetObj.CellValue(row, "edi_rcv_dt");
			       var edi_rcv_seq = sheetObj.CellValue(row, "edi_rcv_seq");
			       var cnt_cd      = sheetObj.CellValue(row, "pol").substring(0,2);
			       
 			       ComOpenWindowCenter("/hanjin/ESM_BKG_1128.do?pgmNo=ESM_BKG_1128&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 540, 600, false);
			       
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
		        var colSaveName = sheetObj.ColSaveName(col);
		        switch(colSaveName) {
		        	case "bl_no" :
		        		if (ComGetObjValue(form.p_data_cd) == "DL") {
				            return;
			    		}
		        		ComBkgCall0079(sheetObj.CellValue(row, "bkg_no"));
		        		break;
        	  		case "update_reason":
        	  			var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(row,"dt_seq"));
						//머지된셀이기 때문에 모두 에디터 불가능하게 한다.
    		    		for(var i =0; i <= sameRows.length ; i++) {
    		    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
    		    			sheetObj.CellEditable(sameRows[i], "update_reason") = false;
    		    		}
           				ComShowMemoPad(sheetObj, row, col, false, 400, 200);
           				/*JSP에서 function setMemoValue(sValue,iMax) 오버 라이딩함 Apply적용시 onChange가 발생 및
           				 * 머지된셀을 에디터블 가능 불가능을 하기 위함.
           				 */
        	    	break;
		        } // end switch
	     	
	     }	
	     /**
	      * bl별 머지 되도록 처리하기 위해
	      * CoObject.js에 있는 함수를 오버라이딩 한것임
	      * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
	      * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
	      */
	 	function setSameBlUpdateReason(memoRow, memoCol,sValue) {
	 		var sheetObj = sheetObjects[0];
	 		
	  		var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(memoRow,"dt_seq"));
    		for(var i =0; i <= sameRows.length ; i++) {
//    			if(sheetObj.CellValue(i,"bl_no") == "") continue;//subsum 행이면
    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
    			sheetObj.CellValue2(sameRows[i], "update_reason") = sValue == ""  ? " ": sValue;
    			sheetObj.CellEditable(sameRows[i], "update_reason") = true;//다시 수정가능하게 한다.
    		}
	 	}	 		     

	    /**
	    * sheet1 All 체크시 체크플래그 세팅
	    * @param sheetObj 시트오브젝트
		* @param Row Long 해당 셀의 Row Index 
		* @param Col Long 해당 셀의 Column Index 
		* @param KeyCode Integer 키보드의 아스키 값 
		* @param Shift Integer Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0 
	    * 
	    */
	    function sheet1_OnKeyUp(sheetObj,row, col, keyCode, Shift)  {
	    	//return;
	    	var colSaveName = sheetObj.ColSaveName(col);
	    	switch(colSaveName) {
	    	
	    	//Del키 처리시 처리하기 위함
	    	case "update_reason":
	    		//alert(Shift);
	    		if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
	    		if(keyCode == 46){
			  		var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(row,"dt_seq"));
			  		if(sameRows.length < 2) return;
		    		for(var i =0; i <= sameRows.length ; i++) {
		    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
		    			sheetObj.CellValue2(sameRows[i], "update_reason") = ' ' ;
		    		}
	    		}
	    		break;
	    	} // end switch
	    }//method end	 
	    
	    /**
	    * sheet1 All 체크시 체크플래그 세팅
	    * @param sheetObj 시트오브젝트
		* @param row Long 해당 셀의 Row Index 
		* @param col Long 해당 셀의 Column Index 
		* @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
	    * 
	    */
	    function sheet1_OnChange(sheetObj,row, col, sValue)  {
	    	//return;
	    	var colSaveName = sheetObj.ColSaveName(col);
	    	switch(colSaveName) {
	    	
	    	//memopad를  안띄우고 직접입력할 경우 머지된 셀 처리를 위함
	    	case "update_reason":
	    		if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
		  		var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(row,"dt_seq"));
		  		if(sameRows.length < 2) return;
	    		for(var i =0; i <= sameRows.length ; i++) {
	    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
	    			sheetObj.CellValue2(sameRows[i], "update_reason") = sValue == ""  ? " ": sValue;
	    		}
	    		break;
	    	} // end switch
	    }//method end	 
	    	    
	     /**
	      * 조회후  이벤트 처리 >>> 폰트 칼라변경
	      */
	     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	         with (sheetObj) {
	        	  //pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
	        	 MessageText("SubSum") = "POD";
	             ShowSubSum("pod", "dr_yn", 0, false, false, SaveNameCol("bl_status"));
	        	 
	             var redColor  = RgbColor(255, 0, 0);
	             var blueColor  = RgbColor(0, 0, 255);
	             for(var i= HeaderRows; i<= LastRow; i++) {
		                if (isError(CellValue(i,"sh_nm"))) CellFontColor(i,"sh_nm") = redColor;

		                if (isError(CellValue(i,"sh_ad")))CellFontColor(i,"sh_ad") = redColor;

		                if (isError(CellValue(i,"sh_ct"))) CellFontColor(i,"sh_ct") = redColor;

		                if (isError(CellValue(i,"sh_cn"))) CellFontColor(i,"sh_cn") = redColor;

		                if (isError(CellValue(i,"sh_zip"))) CellFontColor(i,"sh_zip") = redColor;

		                if (isError(CellValue(i,"sh_str"))) CellFontColor(i,"sh_str") = redColor;

		                if (isError(CellValue(i,"sh_eori"))) CellFontColor(i,"sh_eori") = redColor;

		                if (isError(CellValue(i,"cnee_nm"))) CellFontColor(i,"cnee_nm") = redColor;

		                if (isError(CellValue(i,"cnee_ad"))) CellFontColor(i,"cnee_ad") = redColor;

		                if (isError(CellValue(i,"cnee_ct"))) CellFontColor(i,"cnee_ct") = redColor;

		                if (isError(CellValue(i,"cnee_cn"))) CellFontColor(i,"cnee_cn") = redColor;

		                if (isError(CellValue(i,"cnee_zip"))) CellFontColor(i,"cnee_zip") = redColor;

		                if (isError(CellValue(i,"cnee_str"))) CellFontColor(i,"cnee_str") = redColor;

		                if (isError(CellValue(i,"cnee_eori"))) CellFontColor(i,"cnee_eori") = redColor;

		                if (isError(CellValue(i,"ntfy_nm"))) CellFontColor(i,"ntfy_nm") = redColor;

		                if (isError(CellValue(i,"ntfy_ad"))) CellFontColor(i,"ntfy_ad") = redColor;

		                if (isError(CellValue(i,"ntfy_ct"))) CellFontColor(i,"ntfy_ct") = redColor;

		                if (isError(CellValue(i,"ntfy_cn"))) CellFontColor(i,"ntfy_cn") = redColor;

		                if (isError(CellValue(i,"ntfy_zip"))) CellFontColor(i,"ntfy_zip") = redColor;

		                if (isError(CellValue(i,"ntfy_str"))) CellFontColor(i,"ntfy_str") = redColor;

		                if (isError(CellValue(i,"ntfy_eori"))) CellFontColor(i,"ntfy_eori") = redColor;

		                if (isError(CellValue(i,"bl_pk"))) CellFontColor(i,"bl_pk") = redColor;

		                if (isError(CellValue(i,"bl_wt"))) CellFontColor(i,"bl_wt") = redColor;
		                
		                if (isError(CellValue(i,"cntr_seal"))) CellFontColor(i,"cntr_seal") = redColor;
		                if (isError(CellValue(i,"cntr_pk"))) CellFontColor(i,"cntr_pk") = redColor;
		                if (isError(CellValue(i,"cntr_wt"))) CellFontColor(i,"cntr_wt") = redColor;
		                if (isError(CellValue(i,"cntr_ms"))) CellFontColor(i,"cntr_ms") = redColor;
		                
		                if (isError(CellValue(i,"cm_pk"))) CellFontColor(i,"cm_pk") = redColor;
		                if (isError(CellValue(i,"cm_wt"))) CellFontColor(i,"cm_wt") = redColor;
		                if (isError(CellValue(i,"cm_ds"))) CellFontColor(i,"cm_ds") = redColor;
		                if (isError(CellValue(i,"cm_mk"))) CellFontColor(i,"cm_mk") = redColor;
		                
		                if (CellValue(i,"result2") == "DNL" || CellValue(i,"result2") == "R" || CellValue(i,"result2") == "D" || CellValue(i,"result2") == "P" || CellValue(i,"result2") == "H") {
		                	CellFontColor(i,"ens_result") = redColor;
		                	CellFontUnderline(i,"ens_result") = true;	
		                }else if(CellValue(i,"rcv_msg") != ""){
		                	CellFontColor(i,"ens_result") = blueColor;		                	
		                }
		                

		                if (ComGetObjValue(form.p_data_cd) == "BL") {
		                	ColFontUnderline("bl_no") = true;
		                	ColFontColor("bl_no") = blueColor;
		                }
		                	
	             }
	         }//end width
	         pagedMaxCnt = sheetObj.LastRow;
	     }	    
	     
	     /**
	      * Booking Creation 화면 이동
	      * @param String cellValue
	      * return boolean 에러여부
	      */
	     function isError(cellValue) {
		    if(cellValue == "E") return true;
		    
	     	return false;
	     }		
	     
	    
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;
 	
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
     	
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	//try {
     		var srcName = window.event.srcElement.getAttribute("name");
                                            
            switch(srcName) {

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_New":
 					formObject.reset();
 					sheetObject1.RemoveAll();
 					formObject.p_pol_cd_temp.RemoveAll();
 					div_option.innerHTML = ""; 
 					formObject.div_ttl_bl.value = "";
 					formObject.div_ttl_err.value  = "";
 					formObject.div_ttl_cntr.value  = "";
 					break;
 				case "btn_DownExcel":
 					sheetObject1.SpeedDown2Excel(-1);
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
	 		    	
	 					var arrRow = ComFindText(sheetObject1, "sel", 1);

	 					var tempBlno = sheetObject1.CellValue(arrRow[0], "bl_no"); //bl_no가 머지 되어있어 CheckedRows의 개수로는 유효성검사가 안된다.
	 					for(var i= 0; i< arrRow.length; i++) {
	 						//B/L no가 두개 이상 체크되면 에러처리
	 						if (tempBlno != sheetObject1.CellValue(arrRow[i], "bl_no")) {
	 							ComShowCodeMessage("BKG01134");
		 		    			return;
	 							
	 						}
	 							//tempBlno = sheetObject1.CellValue(arrRow[i], "bl_no");
	 					}
	 					
 	 			      var p_bl_no 		   = sheetObject1.CellValue(arrRow[0], "bl_no");
 		            
 	 			      ComOpenWindowCenter("/hanjin/ESM_BKG_1124.do?pgmNo=ESM_BKG_1124&bl_no=" + p_bl_no, "1107", 1040, 700, false);
 					break;  
 				case "btn_Transmit":
 					formObject.p_send_yn.value="Y";
 					doActionIBSheet(sheetObject1, formObject, MULTI03);
 					break;  
 				case "btn_Makefile":
 					/*
 					formObject.p_send_yn.value="N";
 					doActionIBSheet(sheetObject1, formObject, MULTI01);
 					*/
 					break;  
 				case "p_data_cd":
 					sheetObject1.RemoveAll();
 					div_option.innerHTML = "";
 					formObject.div_ttl_bl.value   = "";
 					formObject.div_ttl_err.value  = "";
 					formObject.div_ttl_cntr.value = "";
 					formObject.port_ofc_cd.value  = "";
 					
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
 					
             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
     }
          
    
     var ata_yn ="";
     
     /* A/N Sending 후 Accepted 된 VVD에 대한 ENS전송 방지 */
     var arn_yn ="";
     /* Diversion Request된 VVD에 대한 ENS전송 방지 */
     var dr_yn ="";
     
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case MULTI01: // EDI FLAT FILE 생성 및 전송
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				var arrRow = ComFindText(sheetObj, "sel", 1);

				var sParam = "";  
				var tempBlno = ""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				for(var i= 0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					sParam +=   "ibflag=U"      +"&"+
								"p_send_yn="    +formObj.p_send_yn.value+"&"+
					            "vsl_cd="       +sheetObj.CellValue(arrRow[i], "vsl_cd"        )+"&"+
					            "skd_voy_no="   +sheetObj.CellValue(arrRow[i], "skd_voy_no"    )+"&"+
					            "skd_dir_cd="   +sheetObj.CellValue(arrRow[i], "skd_dir_cd"    )+"&"+
					            "bl_no="        +sheetObj.CellValue(arrRow[i], "bl_no"         )+"&"+
					            "pol="          +sheetObj.CellValue(arrRow[i], "pol"           )+"&"+
					            "update_reason="+sheetObj.UrlEncoding(sheetObj.CellValue(arrRow[i], "update_reason" ))+"&";
					
						tempBlno = sheetObj.CellValue(arrRow[i], "bl_no");
					
				}
				
				formObj.f_cmd.value = MULTI01;
				sParam += "&" + FormQueryString(formObj);
//				alert(sParam);
//			    return;
//				
				ComOpenWait(true,true);
 				var sXml = sheetObj.GetSaveXml("ESM_BKG_1121GS.do", sParam)
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

	 				
				break;
			case MULTI03: // EDI FLAT FILE 생성 및 전송 - 단건
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				var arrRow = ComFindText(sheetObj, "sel", 1);
				
				var sParam = "";  
				var tempBlno = ""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				var successCnt = 0; 
				var failCnt    = 0;
				
				ComOpenWait(true);
				
				for(var i= 0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					
					sParam =   "ibflag=U"      +"&"+
					"p_send_yn="    +formObj.p_send_yn.value+"&"+
		            "vsl_cd="       +sheetObj.CellValue(arrRow[i], "vsl_cd"        )+"&"+
		            "skd_voy_no="   +sheetObj.CellValue(arrRow[i], "skd_voy_no"    )+"&"+
		            "skd_dir_cd="   +sheetObj.CellValue(arrRow[i], "skd_dir_cd"    )+"&"+
		            "bl_no="        +sheetObj.CellValue(arrRow[i], "bl_no"         )+"&"+
		            "pol="          +sheetObj.CellValue(arrRow[i], "pol"           )+"&"+
		            "update_reason="+sheetObj.UrlEncoding(sheetObj.CellValue(arrRow[i], "update_reason" ))+"&";
					
					formObj.f_cmd.value = MULTI03;
					sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_1121GS.do", sParam)
					var state = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if (state != "S"){
						failCnt++;
					}else{
						successCnt++;
					}
					
					tempBlno = sheetObj.CellValue(arrRow[i], "bl_no");
				}
				//성공메시지 보여주고
	     		//ComShowCodeMessage('BKG00101');
				ComShowMessage("Total:"+(successCnt+failCnt)+"\nSuccess:"+successCnt+"\nFail:"+failCnt);
				
	     		ComOpenWait(false);
	     		//전송 성공 후 재조회함.
	     		doActionIBSheet(sheetObj,form,IBSEARCH);				
				
				break;				
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var bl_sc_no = 0;
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				sheetObj.RemoveAll();
				if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd_cd)) {
					formObj.f_cmd.value = SEARCH04;
					var pofeXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj));
					var vvd_cnt = ComGetEtcData(pofeXml,"vvd_cnt");
					var pol_cnt = ComGetEtcData(pofeXml,"pol_cnt");
					var temp_pol = ComGetEtcData(pofeXml,"pol");//bl로 조회한 pol
					var temp_pol_yd = ComGetEtcData(pofeXml,"pol_yd");//bl로 조회한 pol

					formObj.p_pol_cd.value      = temp_pol;
					formObj.p_pol_yard_cd.value = temp_pol_yd;
					
					formObj.p_vvd_cd.value      = ComGetEtcData(pofeXml,"vvd");
					formObj.p_pod_cd.value      = ComGetEtcData(pofeXml,"pod");
					formObj.p_pod_yard_cd.value = ComGetEtcData(pofeXml,"pod_yd");
					doActionIBSheet(sheetObj, formObj, SEARCH01);
//					if(eval(vvd_cnt) > 1){
//						ComShowCodeMessage('BKG95001','BL이 2개이상 VVD를 가지고 있습니다. 직접 입력해주세요.');
//						sheetObj.Redraw = true;
//						sheetObj.WaitImageVisible = false;
//						return;
//					}
					
					if(formObj.p_pol_cd_temp.GetCount() == 1){
						formObj.p_pol_cd_temp.Index = 0;
					}else if(formObj.p_pol_cd_temp.GetCount() > 1){
						//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
			    		formObj.p_pol_cd_temp.Text = temp_pol;
			    		formObj.p_pol_cd_temp.focus();
			    		//ComShowCodeMessage('BKG95001','select a EU POL');
						sheetObj.Redraw = true;
						sheetObj.WaitImageVisible = false;
						bl_sc_no = 1;
			    		//return;
					}else{
						ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
						sheetObj.Redraw = true;
						sheetObj.WaitImageVisible = false;
						return;
		    		}
		    		
	    		}
				formObj.f_cmd.value = SEARCH;
				formObj.p_pol_cd.value = ComGetObjValue(formObj.p_pol_cd_temp);
//				formObj.p_pol_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port',formObj.p_pol_cd.value),"eu_1st_port_yd_cd");
				formObj.p_pol_yard_cd.value = ComGetObjValue(formObj.p_pol_cd_temp);
				
//				if ( ComIsNull(formObj.p_pol_yard_cd) ) {
//					ComShowCodeMessage('BKG03061','EU POL');
//					sheetObj.Redraw = true;
//					sheetObj.WaitImageVisible = false;
//					return;
//				}
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj));

				sheetObj.LoadSearchXml(sXml);
			
				if(ComGetEtcData(sXml,"div_pol") == undefined){
					div_option.innerHTML = ""; //"POL :  / ETD :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; POD (1st EU Port) :  / ETA : " ;
					formObj.div_ttl_bl.value = "0";
					formObj.div_ttl_err.value  = "0";
					formObj.div_ttl_cntr.value  = "0";
					formObj.port_ofc_cd.value  = "";
					formObj.div_sent_bl_cnt.value       = "0";
					formObj.div_unsent_bl_cnt.value     = "0";
					formObj.div_sent_bl_cnt2.value      = "0";
					formObj.div_a_cnt.value             = "0";
					formObj.div_r_cnt.value             = "0";
					formObj.div_dnl_cnt.value           = "0";
					formObj.div_h_cnt.value           	= "0";
					formObj.div_l_cnt.value           	= "0";
					formObj.div_nr_cnt.value            = "0";
					ata_yn="";
					arn_yn="";
					dr_yn="";
//			
				}else{
					div_option.innerHTML = "EU POL : "                + ComGetEtcData(sXml,"div_pol")
					                     + " / ETD : "             + ComGetEtcData(sXml,"vps_etd_dt");
//					                     + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
//					                     +" POD (1st EU Port) : "  + ComGetEtcData(sXml,"eu_1st_port")
//					                     + " / ETA : "             + ComGetEtcData(sXml,"vps_eta_dt"); 
					formObj.div_ttl_bl.value = ComGetEtcData(sXml,"ttl_bl");
					formObj.div_ttl_err.value  = ComGetEtcData(sXml,"ttl_err_bl");
					formObj.div_ttl_cntr.value  = ComGetEtcData(sXml,"ttl_cntr");
					formObj.port_ofc_cd.value  = ComGetEtcData(sXml,"port_ofc_cd");
					formObj.div_sent_bl_cnt.value       = ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_unsent_bl_cnt.value     = ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_sent_bl_cnt2.value      = ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_a_cnt.value             = ComGetEtcData(sXml,"a_cnt");
					formObj.div_r_cnt.value             = ComGetEtcData(sXml,"r_cnt");
					formObj.div_dnl_cnt.value           = ComGetEtcData(sXml,"dnl_cnt");
					formObj.div_h_cnt.value 	        = ComGetEtcData(sXml,"h_cnt");
					formObj.div_l_cnt.value 	        = ComGetEtcData(sXml,"l_cnt");
					formObj.div_nr_cnt.value            = ComGetEtcData(sXml,"nr_cnt");
					ata_yn                              = ComGetEtcData(sXml,"ata_yn");
					arn_yn                              = ComGetEtcData(sXml,"arn_yn");
					dr_yn                               = ComGetEtcData(sXml,"dr_yn");
					
					if(ComGetObjValue(formObj.p_data_cd) == "DL"){
 						if(ComGetEtcData(sXml,"exs_edi_svc_flg") == "Y")
 							ComBtnEnable("btn_Transmit");
 						else
 							ComBtnDisable("btn_Transmit");
 							
 					}
				}
				
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				if(bl_sc_no == 0 && sheetObj.RowCount < 1 && formObj.p_pol_cd_temp.GetCount() > 1){
					ComShowCodeMessage('BKG95001','select a EU POL');
				} 
				
				if (bl_sc_no == 1 && sheetObj.RowCount > 1 && temp_pol_yd != ""){
					formObj.p_pol_cd_temp.Text = temp_pol_yd;
					formObj.p_pol_yard_cd.value = temp_pol_yd;
				}
				
				if(sheetObj.RowCount > 1) {
					formObj.search_eu_pol_cd.value = formObj.p_pol_cd_temp.Text;
				}
				
				break;
			case SEARCH01 : // pol 조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			
			
			sheetObj.Redraw = false;    
			sheetObj.WaitImageVisible = true;
			
			formObj.f_cmd.value = SEARCH01;
			var sXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj));
			
//			ComXml2ComboItem(sXml, formObj.p_pol_cd_temp, "eu_1st_port", "eu_1st_port");
			ComXml2ComboItem(sXml, formObj.p_pol_cd_temp, "search_eu_1st_port_yd_cd", "search_eu_1st_port_yd_cd");
			
			sheetObjects[2].LoadSearchXml(sXml);
			
			
			//formObj.p_pol_cd.value = ComGetEtcData(sXml,"eu_1st_port");
			
			sheetObj.Redraw = true;
			sheetObj.WaitImageVisible = false;

			
			break;
			case SEARCH05 : // eu 포트 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				
				
				sheetObjects[1].Redraw = false;    
				sheetObjects[1].WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH05;
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1121GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchXml(sXml);
				sheetObjects[1].Redraw = true;
				sheetObjects[1].WaitImageVisible = false;
				
				
				break;
			case MULTI: //저장
				if ( !validateForm(sheetObj, formObj, sAction)) return;
				
	            var cntr_list = "";
				var arrRow = ComFindText(sheetObj, "sel", 1);
				var p_eu_1st_port = "";
				var p_eu_1st_port_yd_cd = "";
				
				if (arrRow && arrRow.length > 0) {
					p_eu_1st_port_yd_cd = sheetObj.CellValue(arrRow[0], "eu_1st_port_yd_cd");
					for (var i=0; i<arrRow.length; i++) {
					   cntr_list += sheetObj.CellValue(arrRow[i], "vsl_cd"       )+","+
						            sheetObj.CellValue(arrRow[i], "skd_voy_no"   )+","+
						            sheetObj.CellValue(arrRow[i], "skd_dir_cd"   )+","+
						            sheetObj.CellValue(arrRow[i], "bl_no"        )+","+
						            sheetObj.CellValue(arrRow[i], "eu_1st_port"  )+","+
						            sheetObj.CellValue(arrRow[i], "cntr_cntr_no" )+","+
						            sheetObj.CellValue(arrRow[i], "edi_mrn"      )+","+
						            sheetObj.CellValue(arrRow[i], "msg_snd_no" )+"@";
					}
				}
				
				if(ComGetLenByByte(cntr_list) > 4000){
					cntr_list = getStringToClobString(cntr_list, 30,"@")
				} else{
					cntr_list = "'"+cntr_list+"'";
				}
	            
			  //alert(cntr_list);
			  //return;
			  sheetObj.WaitImageVisible = false;
			
			  ComOpenWait(true);
			  formObj.f_cmd.value = MULTI;
			  var sParam = "&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list+"&eu_1st_port="+p_eu_1st_port+"&eu_1st_port_yd_cd="+p_eu_1st_port_yd_cd;

			  var xmlStr = sheetObj.GetSaveXml("ESM_BKG_1121GS.do", sParam);
			  var sResult = ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
			  sheetObj.LoadSaveXml(xmlStr);
			  ComOpenWait(false);
			  
			  sheetObj.WaitImageVisible = false;
			  
			  // 다운로드 후  버튼 비활성화,재조회 한다.
	      		ComSetObjValue(formObj.p_data_cd,"DL");
	    		ComBtnEnable("btn_Inquiry");
				ComBtnEnable("btn_Transmit");
				ComBtnDisable("btn_EDIDownload");
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);

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
     	var sXml = sheetObj.GetSearchXml("ESM_BKG_1121GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
     	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

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
	    		if (!ComIsNull(formObj.p_bl_no)) {
	    			return true;
	    		}
	    			
    			if (ComIsNull(formObj.p_vvd_cd)) {
    				ComShowCodeMessage('BKG00104','VVD');
 					formObj.p_vvd_cd.focus();
 					return false;    
    			}

    			if (ComGetObjValue(formObj.p_pol_cd_temp) == "") {
    				ComShowCodeMessage('BKG00104','POL');
    				formObj.p_pol_cd_temp.focus();
    				return false;    
    			}
    			
    			
				break;
	    	case MULTI://다운로드
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return false;
	    		}
	    		
	    		if(formObj.search_eu_pol_cd.value != formObj.p_pol_cd_temp.Text) {
	    			ComShowCodeMessage("BKG06138");
	    			formObj.p_pol_cd_temp.focus();
	    			return false;
	    		}
	    		
	    		var arrRow = ComFindText(sheetObj, "sel", 1);
	    
	    		/*
	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
	    		 * */
	    		var errorCnt = 0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var errorBls = "";
	    		var tempBl = "";
	    		var beBlNo = "";
	    		var nowBlNo = "";
	    		var errBlArray = new Array();
	    		for (var i=0; i<arrRow.length; i++) {
	    			if(sheetObj.CellValue(arrRow[i], "err_yn") == "Y"){
	    				
	    				if(errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
		    				errorCnt++;
		    				if(errorCnt > 10){
		    					continue;
		    				}else{
		    					nowBlNo = sheetObj.CellValue(arrRow[i], "bl_no");
		    					if(beBlNo == nowBlNo){
		    						errorCnt--;
		    					}else{
		    						beBlNo = nowBlNo;
		    						errorBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
		    					}
		    					
		    				}
	    				}
	    			}
	    		}
	    		
			    if(errorCnt > 0){
					errorBls = errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
					//에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
					if(!ComShowConfirm(ComGetMsg("BKG01133",errorBls,"Will you proceed to download?")) ){
						return false;
					}
			    }

	    		break;
	    		
	    	case MULTI01:// EDI FLAT FILE 생성 및 전송
	    	case MULTI03:// EDI FLAT FILE 생성 및 전송
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return false;
	    		}
	    		
	    		if (ComIsNull(formObj.port_ofc_cd)) {
	    			ComShowCodeMessage('BKG01131');
	    			return false;    
	    		}
	    		
	    		
	    		var errYN = "N";
	    		var arrRow = ComFindText(sheetObj, "sel", 1);
	    		
	    		var nodownCnt = 0;//다운로드 하지 않은 개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var nodownBls = "";
	    		
	    		/*
	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
	    		 * */
	    		var errorCnt = 0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var errorBls = "";
	    		
	    		/* not received이 존재하면 확인창 후 취소 버튼 클릭시 진행 안함 */
	    		var nrCnt = 0;
	    		var nrBls = "";
	    		
	    		
	    		/*
	    		 * Amend전송: Send log 테이블, cre_dt 기준,  1/18 17:18 분 이후 건에 대해 Amendment Block,  BL은 재전송 못하게 한다.
	    		 * */
	    		var amdCnt = 0;  //amd개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var amdBls = "";
	    		
	    		var tempBl = "";
	    		var errBlArray = new Array();
	    		
				for (var i=0; i<arrRow.length; i++) {
					
					if(sheetObj.CellValue(arrRow[i], "err_yn") == "Y"){
						if(errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
							errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] = sheetObj.CellValue(arrRow[i], "bl_no");
							
							errorCnt++;
							if(errorCnt <= 10)
								errorBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
						}
					}
					
					if (tempBl== sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					
					tempBl = sheetObj.CellValue(arrRow[i], "bl_no");
					
								
					/* 2010-11-30 Download조회에서만 전송버튼이 활성화 되므로 이부분은 현재 실효성은 없으나 초기버전대로 일단 수행은 한다.*/
					if(sheetObj.CellValue(arrRow[i], "download_yn") == "N"){
						nodownCnt++;
						if(nodownCnt <= 10)
							nodownBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
					}
					
					if(sheetObj.CellValue(arrRow[i], "result2") == "NR"){
						nrCnt++;
						if(nrCnt <= 10)
							nrBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
					}
					
				}//end for
				
	    		
				
				if(nodownCnt > 0){
					nodownBls = nodownCnt > 10 ? nodownBls+"..etc.":nodownBls.substring(0,nodownBls.length-1);
					ComShowCodeMessage("BKG01130",nodownBls,"");
					return false;
				}
				
				
			    if(errorCnt > 0){
					errorBls = errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
			    	ComShowCodeMessage("BKG01133",errorBls,"");
			    	return false;
			    }
			    
				//에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
				if(nrCnt > 0 ){
					nrBls = nrCnt > 10 ? nrBls+"..etc.":nrBls.substring(0,nrBls.length-1);
					if(!ComShowConfirm(ComGetMsg("BKG01141",nrBls)) ) 
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
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
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

        var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
			
			case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 280;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
						MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 3, 100);
						
						var HeadTitle1 = "Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|B/L Data|B/L Data|B/L Data|UPDATE\nREASON|Container Data|Container Data|Container Data|Container Data|Container Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|rcv_msg|EDI|EDI|EDI|EDI|EDI|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|IB Flag";
				        var HeadTitle2 = "Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|PK|WT|MS|UPDATE\nREASON|CNTR  No|Seal|PK|WT|MS|PK|WT|MS|DS|MK|HS|rcv_msg|Ack. Status|Sent Time(GMT)|MRN|Ref No|Received Time(GMT)|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|IB Flag";
				        var headCount = ComCountHeadTitle(HeadTitle1);
						
						
						headCount = ComCountHeadTitle(HeadTitle1);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 5, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
						InitHeadMode(false, false, true, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
				           //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

						InitDataProperty(0, cnt++ , dtData,			40,	daCenter,  true,  "dt_seq",	  false,  "",  dfNone,	0,  false,  false);
						InitDataProperty(0, cnt++,  dtCheckBox,     40, daCenter,  true,  "sel",      false,  "",  dfNone,  0,  true,   false);
						InitDataProperty(0, cnt++ , dtData,  80,  daCenter,  true,  "bl_status",      false,  "",  dfNone,  0,   false,  false);
						InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "bl_no",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol",            false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod",            false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpol",           false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpod",           false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "del",            false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ct",             false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "lt",             false,  "",  dfNone,  0,  false,  false);
	    				  
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_nm",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_ad",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_ct",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_cn",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_zip",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_str",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "sh_eori",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_nm",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_ad",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_ct",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_cn",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_zip",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_str",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cnee_eori",      false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_nm",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_ad",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_ct",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_cn",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_zip",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_str",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "ntfy_eori",      false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "bl_pk",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "bl_wt",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "bl_ms",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,  200, daLeft,    true,  "update_reason",  false,  "",  dfNone,  0,  true,  false);
						InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "cntr_cntr_no",   false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cntr_seal",      false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cntr_pk",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cntr_wt",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cntr_ms",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_pk",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_wt",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_ms",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_ds",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_mk",          false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  40,  daCenter,  true,  "cm_hts",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "rcv_msg",    false,  "",  dfNone,  0,  false,  false);						
						InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "ens_result",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "sent_time",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  140,  daCenter,  true,  "edi_mrn",        false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "edi_ref_no",     false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "received_time",       false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "vsl_cd",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "skd_voy_no",     false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "skd_dir_cd",     false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "eu_1st_port",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "eu_1st_port_yd_cd",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "bkg_no",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "err_yn",         false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "download_yn",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,   "msg_snd_no",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,    "dr_yn",    false,  "",  dfNone,  0,  false,  false);
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,    "result2",    false,  "",  dfNone,  0,  false,  false);		
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,    "edi_rcv_dt",    false,  "",  dfNone,  0,  false,  false);		
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,    "edi_rcv_seq",    false,  "",  dfNone,  0,  false,  false);		
						InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,    "kts_send_dt",    false,  "",  dfNone,  0,  false,  false);		
						InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
						CountPosition = 0;
						
						//InitDataCombo(0, "bl_status",	 "Original|Amendment","Original|Amendment");
						
						SetSortDialog(false	);
						//ActionMenu = "Check selected|Unheck selected"
						SelectHighLight= true;
					    MultiSelection = true;
					    SelectionMode = smSelectionRow;
					    
					}
				break;
			case "sheet2":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 280;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "|cnt_cd";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "cnt_cd",          false,  "",  dfNone,  0,  false,  false);
					
					CountPosition = 0;
					SelectHighLight= false;
					
				}
				break;
			case "sheet3":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 280;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name|eu_1st_port|edi_mrn";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(false, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "search_eu_1st_port_yd_cd", false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_yd_cd",        false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_name",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "edi_mrn",         false,  "",  dfNone,  0,  false,  false);
					
					CountPosition = 0;
					SelectHighLight= false;
					
				}
				break;
		}//end switch
		
 	}     
	
    /* 개발자 작업  끝 */
