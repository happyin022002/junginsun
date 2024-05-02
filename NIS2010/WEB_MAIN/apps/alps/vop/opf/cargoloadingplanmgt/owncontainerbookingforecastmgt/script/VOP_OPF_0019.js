/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_0019.js
 *@FileTitle : CBF for Own Booking (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.18 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2011.12.12 [CHM-201114818-01] Split 03-특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
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
	 * @class vop_opf_0019 : vop_opf_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_0019() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

	/* 개발자 작업 */
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt     = 0;
	var beforetab  = 1;
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	var comboObjects = new Array();
	var comboCnt     = 0;
	  
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";
	//임포트여부 > 삭제컬럼 보여주기 유무 결정 
	var importYN = "";
	
	var dupMsg  = "";	 //중복 컨테이너 메시지
	var colorAry = new Array();	//중복컨테이너 로우 색상 지정 변수선언
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var sheetObj2 = sheetObjects[1]; // t1sheet2
		
		var tabObj    = tabObjects[0];
		var comboObj  = comboObjects[0];

		var formObj   = document.form;
		
		var selTabIdx = tabObj.SelectedIndex;
	
		/** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
					break;
					
				case "btn_BookingClosingStatus":
					openBCSPopup(formObj);
					break;
	
				case "btn_Display":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBBATCH);
					break;
	
				case "btn_SummaryPreview":
					openSPPopup(formObj);
					break;
	
				case "btn_DownExcel":
					sheetObjects[tabObj.SelectedIndex].SpeedDown2Excel(-1);					
					break;
	
				case "btn_New":
					ComResetAll();
					comboObj.RemoveAll();
					
					//버튼 비활성화
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_SaveAsXML");
					ComBtnDisable("btn_BookingClosingStatus");
					ComBtnDisable("btn_Display");
					ComBtnDisable("btn_SummaryPreview");
					ComBtnDisable("btn_DownExcel");
					
					ComBtnDisable("t1btn_Delete");
					ComBtnDisable("t1btn_DupCntr");
				
					//초기 포커스 위치
					ComSetFocus(formObj.vsl_cd);
					
					break;
					
				case "t1btn_Delete":
					ComRowHideDelete(sheetObj1, prefix1+"del_chk");

					break;
					
				case "t1btn_DupCntr": 
					//중복된 컨테이너 버튼
					var dupCntrNo = ComGetObjValue(formObj.dup_cntr_no);
					dupCntrMsg(dupCntrNo, sheetObj1, "t1btn_DupCntr");
					break;
					
				case "btn_Delete":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDELETE);
					break;	
					
				case "btn_Save":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);					
					break;
	
				case "btn_vvd":
					var vslCd = ComGetObjValue(formObj.vsl_cd);
					var sUrl = "";
	
					if (vslCd == "") {
						sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 335, 430, "setCallBackVVD", "0,0", true);
					}
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}
	
	/**
	 * 화면단에서 컬럼별로 소팅하거나 중복컨테이너로우가 변경될때마다 해당 로우의 배열을 전역변수(배열)인 colorAry 로 담아온다  
	 */
	function dupColorAry(sheetObj){ 
	    sheetObj.SpaceDupCheck = false;	//기본적으로는 공백을 포함해서 중복체크를 하는데 공백을 제외하고 중복체크

	    colorAry = new Array();
	    
	    var duprows = sheetObj.ColValueDupRows(prefix1+'cntr_no',false,true, sheetObj.HeaderRows, sheetObj.LastRow);	//중복된 모든행 "," 로 조합하여 문자열 반환 (삭제행제외, 최초행포함, sheetObj.HeaderRows~sheetObj.LastRow)
	    var arrRowsAry = duprows.split("|");

	    if(arrRowsAry[0].length > 0){ //최초행의 배열의 길이가 존재할 경우에만 실행
		    var arrRowAry1 = arrRowsAry[0].split(",");	//중복 최초기준행을 배열로 가져온다 > 기준행으로 메세지로 넘길 CNTR_NO를 가져온다
		    var arrRowAry2 = arrRowsAry[1].split(",");
	
		    //alert("arrRowAry1>"+arrRowAry1.length+",arrRowAry2>"+arrRowAry2.length);
		    if(arrRowAry1 != "" && arrRowAry1.length > 0){
			    for (var i=0; i < arrRowAry1.length; i++){
			    	colorAry.push(arrRowAry1[i]);
			    } 
			    for(var j=0; j < arrRowAry2.length; j++ ){
			    	colorAry.push(arrRowAry2[j]);
			    }
		    }
	    }
	} 
	
	/**
	 * 중복컨테이너 선택시 동일한 컨테이너 목록 메시지와 위치이동 > t1btn_DupCntr : 중복컨테이너 박스에 입력했을때 & onMouseDown 클릭시 실행
	 */
	function dupCntrMsg(dupCntrNo, sheetObj, ev){  
		if(ev == "t1btn_DupCntr" && dupCntrNo == ""){	//중복컨테이너버튼 : 컨테이너번호 없는경우
			//if(dupCntrNo == ""){
			srchDupSet(sheetObj, "Y");
			//}
		}else{
			var lColor1 = sheetObj.WebColor("#FFFFC0");	//기본색생
			var lColor2 = sheetObj.WebColor("#FF0000");	//중복색생
			var btnCntrNoMsg = "Found duplicated CNTR No. as like below: ";
			btnCntrNoMsg += "\n" + dupCntrNo + " at the line " ;
			var dupCnt = 0;
			var firstMove = 0;
			
			dupColorAry(sheetObj);

			if(sheetObj.LastRow-1 > 1 && colorAry.length > 0){
				for(var i=0; i < colorAry.length; i++){
					var compCntrNo = sheetObj.CellValue(colorAry[i], prefix1+'cntr_no');
					if(dupCntrNo == compCntrNo){
						if(dupCnt == 0){
							btnCntrNoMsg += sheetObj.CellValue(colorAry[i], prefix1+'No.'); 
							firstMove = colorAry[i];
						}else{
							btnCntrNoMsg += " and " + sheetObj.CellValue(colorAry[i], prefix1+'No.');
						}
						dupCnt++;
					}
					
					if(i == colorAry.length-1 && dupCnt > 0){
						if(ev == "t1btn_DupCntr"){
							alert(btnCntrNoMsg);
							sheetObj.SelectCell(firstMove,3);
							
						    //자동선택된 행의 배경색상을 설정
						    sheetObj.RowBackColor(firstMove) = lColor2;
						    sheetObj.SelectBackColor = lColor2;
						}else{	//onMouseDown
							return btnCntrNoMsg;
						}
					}else{
						sheetObj.SelectBackColor = lColor1;
					}
				}
			}
		}
	}
		
	/**
	 * 중복 정보 및 메시지 처리 > Import BKG Data 버튼, Duplicated CNTR 버튼 클릭시 CNTR No. 가 비어있을경우 중복전체 구하는 로직 실행
	 */
	function srchDupSet(sheetObj, dupFlag){
		with (sheetObj) {
			if(RowCount > 0) {
				//20140801 추가 > duplicate cntrNo
			    sheetObj.SpaceDupCheck = false;	//기본적으로는 공백을 포함해서 중복체크를 하는데 공백을 제외하고 중복체크
			    
			    var duprows = sheetObj.ColValueDupRows(prefix1+'cntr_no',false,true, sheetObj.HeaderRows, sheetObj.LastRow);	//중복된 모든행 "," 로 조합하여 문자열 반환 (삭제행제외, 최초행포함, sheetObj.HeaderRows~sheetObj.LastRow)
			    //arrRowsAry = new Array();
			    var arrRowsAry = duprows.split("|");
			    
			    if(arrRowsAry[0].length > 0){ //최초행의 배열의 길이가 존재할 경우에만 실행
				    var arrRowAry1 = arrRowsAry[0].split(",");	//중복 최초기준행을 배열로 가져온다 > 기준행으로 메세지로 넘길 CNTR_NO를 가져온다
				    var arrRowAry2 = arrRowsAry[1].split(",");
				    var dupCnt = 0;	//중복인 경우 del_chk 를 true로 전환하기 위한 seq & 중복컨테이너 로우 Array seq
			
				    var srchDupMsg = "Found duplicated CNTR No. as like below: ";
				    //alert("arrRowAry1>"+arrRowAry1.length+",arrRowAry2>"+arrRowAry2.length);
				    if(arrRowAry1 != "" && arrRowAry1.length > 0){
				    	//기본적으로 del_chk 는 선택할 수 없음
					    for(var d=sheetObj.HeaderRows; d<=sheetObj.LastRow; d++) {
					    	  sheetObj.CellEditable(d, prefix1+'del_chk') = false;
					    }
					    //중복 컨테이너번호 메시지구하기				    	
				    	var cntr1 = ""; //기준 컨테이너명 선언
				    	var srchColorAry = new Array();	//중복컨테이너 로우 색상 지정 변수선언
				    	
					    for (var i=0; i < arrRowAry1.length; i++){
					    	cntr1 = sheetObj.CellValue(arrRowAry1[i], prefix1+'cntr_no');
					    	sheetObj.CellEditable(arrRowAry1[i], prefix1+'del_chk') = true;	//del_chk 를 true
					    	srchColorAry.push(arrRowAry1[i]);
					    	
					    	srchDupMsg += "\n" + cntr1 + " at the line " + sheetObj.CellValue(arrRowAry1[i], prefix1+'No.');
					    	var cntr2 = "";
					    	for(var j=0; j < arrRowAry2.length; j++ ){
					    		if(dupCnt == 0){
					    			sheetObj.CellEditable(arrRowAry2[j], prefix1+'del_chk') = true;	//del_chk 를 true
					    			srchColorAry.push(arrRowAry2[j]);
					    		}
					    		
					    		cntr2 = sheetObj.CellValue(arrRowAry2[j], prefix1+'cntr_no');
					    		if(cntr1 == cntr2){
					    			srchDupMsg += " and " + sheetObj.CellValue(arrRowAry2[j], prefix1+'No.');
					    		}
					    	}
					    	dupCnt++;
					    }
					    
					    if(importYN){
						    //20140801 > DEL Check 보이기 / 안보이기 처리 > 보이기
						    ColHidden(prefix1 + "del_chk") = false;		//sheetObj.ColHidden(1) = false;
					    }
					    
					    //중복관련 버튼 활성
					    ComBtnEnable("t1btn_Delete");
					    ComBtnEnable("t1btn_DupCntr");
					    
					    alert(srchDupMsg);
					    
						//그리드 셋팅 > param : sheet1, 중복컨테이너로우 배열
						dupSet(sheetObj, srchColorAry);					    
				    }			    	
			    }else{ //중복행이 없을 경우 메시지처리
			    	if(dupFlag == "Y"){
			    		alert("Found Not duplicated CNTR No.");
			    	}
			    }
			}
		}
	}
	
	/**
	 * 조회시, 그리드 셋팅 
	 * 1. 중복데이타행과 그 자동 선택된 행의 배경색상을 설정
	 * 2. 중복 컨테이너번호 만 수정가능함 그외 Row는 삭제 불가능
	 */
	function dupSet(sheetObj, srchColorAry)
	{
	  var lColor2 = sheetObj.WebColor("#FF0000");	//중복색생		
	  var tfSel  = true;
	  for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
		  for(var j=0; j < srchColorAry.length; j++){
			  if(i == srchColorAry[j]){
				  //alert("dupCntrChk:"+dupCntrChk);
				  if(tfSel){ //중복된 최초 ROW에 포커스
					  sheetObj.SelectCell(i,3);
					  tfSel = false;
			  	  }
				  //중복데이타행과 그 자동 선택된 행의 배경색상을 설정
				  sheetObj.RowBackColor(srchColorAry[j]) = lColor2;
				  sheetObj.SelectBackColor = lColor2;
			  }
		  }
	  }
	}
	
	/** 
	 * Booking Closing Status 버튼 클릭시 팝업호출
	 */
	function openBCSPopup(formObj) {	
		var vslCd     = ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo  = ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd  = ComGetObjValue(formObj.skd_dir_cd);
		
		var ydCd      = formObj.yd_cd.text;
		var polCd     = ydCd.substring(0, 5);
	
		var paramStr = "";
		paramStr += 'vsl_cd=' + vslCd + skdVoyNo + skdDirCd + '&pol_cd=' + polCd;
		
		ComOpenWindowCenter("/hanjin/ESM_BKG_0587POP.do?pgmNo=ESM_BKG_0587&" + paramStr, "VOP_OPF_0019", 1025, 675, true);
	}

	/** 
	 * Summary Preview 버튼 클릭시 팝업호출
	 */
	function openSPPopup(formObj) {	
		var vslCd     = ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo  = ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd  = ComGetObjValue(formObj.skd_dir_cd);
		var ydCd      = comboObjects[0].Code;
		var ydNm      = ComGetObjValue(formObj.yd_nm);
		var cbfIndFlg = formObj.cbf_ind_flg[0].checked?formObj.cbf_ind_flg[0].value:formObj.cbf_ind_flg[1].value
	
		var vslSlanCd = ComGetObjValue(formObj.slan_cd);
	
		var paramStr = "";
		paramStr += 'vsl_cd=' + vslCd + '&skd_voy_no=' + skdVoyNo + '&skd_dir_cd=' + skdDirCd;
		paramStr += '&yd_cd=' + ydCd + '&yd_nm=' + ydNm + '&cbf_ind_flg=' + cbfIndFlg;
		paramStr += "&vsl_slan_cd=" + vslSlanCd + "&crr_cd=SML&bkg_shpr_ownr_flg=Y";	
		
		ComOpenWindowCenter("VOP_OPF_2019.do?" + paramStr, "win2", "1000", "620", false, "yes");
	}

	/**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj   = document.form;
		
		var tabObj    = tabObjects[0];
		var selTabIdx = tabObj.SelectedIndex;
		
		var cbfRmkEditable = false;
		
		//1. Retrieve
		if(ComGetObjValue(formObj.f_cmd) == SEARCH) {
			with (sheetObj) {
				
				//1. 기본셋팅
				//1-1. 선택되는 기본색상
				var lColor1 = sheetObj.WebColor("#FFFFC0");	//기본색생
				sheetObj.SelectBackColor = lColor1;
				//1-2. del 체크박스 안보이게처리   
				ColHidden(prefix1 + "del_chk") = true;
				//2. 그리드클릭시 조회와 IMPORT를 구분 (값이 Display 라면 IMPORT)
				formObj.gubun.value = "";
				
				if(RowCount > 0) {
					for (var radioCt=0; radioCt<2; radioCt++) {
						//1. CBF(Pre, Final) 체크
						if (CellValue(LastRow, prefix1+"cbf_ind_flg") == formObj.cbf_ind_flg[radioCt].value) {
							formObj.cbf_ind_flg[radioCt].checked = true;
						}
						//2. Booking Status 체크
						if (CellValue(LastRow, prefix1+"cbf_bkg_sts_cd") == formObj.cbf_bkg_sts_cd[radioCt].value) {
							formObj.cbf_bkg_sts_cd[radioCt].checked = true;
						}						
					}
					//3. Actual Cntr Flg 체크
					if (CellValue(LastRow, prefix1+"ac_cntr_flg") == "C") {
						formObj.ac_cntr_flg.checked = true;
					} else {
						formObj.ac_cntr_flg.checked = false;
					}
					
					//3. 관련 버튼 활성화
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_Save");
					//ComBtnEnable("btn_SaveAsXML");
					ComBtnEnable("btn_SummaryPreview");
					if(selTabIdx == 0) ComBtnEnable("btn_DownExcel");
					
					//4. Last Created 셋팅

					//5. 20140801 추가 > duplicate cntrNo
					srchDupSet(sheetObj, "N");
					importYN = false;

					//6. 버튼 셋팅
					//6-1 관련 버튼 비활성화
					ComBtnEnable("btn_Save");
					//ComBtnEnable("btn_SaveAsXML");
					ComBtnEnable("btn_DownExcel");
					ComBtnDisable("btn_SummaryPreview");
					//6-2. 관련 버튼 (비)활성화
					ComBtnDisable("t1btn_Delete");
					ComBtnEnable("t1btn_DupCntr");
				} else {
					formObj.cbf_ind_flg[0].checked    = true;
					formObj.cbf_bkg_sts_cd[0].checked = true;
					
					//ComSetObjValue(formObj.upd_usr_id, "");
					//ComSetObjValue(formObj.upd_dt, "");
					
					//1. 관련 버튼 비활성화
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_SaveAsXML"); 
					ComBtnDisable("btn_SummaryPreview");
					
					ComBtnDisable("t1btn_Delete");
					ComBtnDisable("t1btn_DupCntr");
					
					if(selTabIdx == 0) ComBtnDisable("btn_DownExcel");
				}
				//6. 무조건 Display 버튼 활성화
				ComBtnEnable("btn_Display");
				
				//7. Booking Status 결정
				ComSetObjValue(formObj.bk_st, formObj.cbf_bkg_sts_cd[0].checked?formObj.cbf_bkg_sts_cd[0].value:formObj.cbf_bkg_sts_cd[1].value);
			}
	    //2. Display > Import BKG Data
		} else {
			with (sheetObj) {
				//1. 그리드클릭시 조회와 IMPORT를 구분 (값이 Display 라면 IMPORT)
				formObj.gubun.value = "Display";
				
				if(RowCount > 0) {
					ComBtnEnable("t1btn_Delete");
					ComBtnEnable("t1btn_DupCntr");
					
					ComBtnEnable("btn_Save");
					//ComBtnEnable("btn_SaveAsXML");
					ComBtnEnable("btn_DownExcel");
					ComBtnDisable("btn_SummaryPreview");
					
					ComShowCodeMessage("OPF50014");	//'Booking data was imported successfully.'
					
					importYN = true;
					
					//5. 20140801 추가 > duplicate cntrNo
					srchDupSet(sheetObj, "N");
				} else {
				    //20140801 > DEL Check 보이기 / 안보이기 처리 > 안보이기 
				    sheetObj.ColHidden(1) = true;
				    
					//ComBtnDisable("btn_Save");
					ComBtnEnable("btn_Save");
					ComBtnDisable("btn_SaveAsXML");
					ComBtnDisable("btn_DownExcel");
				}
			    
				ComBtnDisable("btn_Delete");
			}
			
			cbfRmkEditable = true;
		}
		
		//Remark Column 활성여부
		doColEditable(sheetObjects[1], cbfRmkEditable);
	}
	
    /**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		var tabObj    = tabObjects[0];
		var selTabIdx = tabObj.SelectedIndex;
		
 		with (sheetObj) {
			if(RowCount > 0) {
				if(selTabIdx == 1) ComBtnEnable("btn_DownExcel");
			} else {
				if(selTabIdx == 1) ComBtnDisable("btn_DownExcel");
			}
 		}
 	}
 	
	/**
	 * t1sheet1_OnMouseDown
	 */
	function t1sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y) {
		//if(document.form.gubun.value == "Display"){	//Import 버튼으로 조회된 그리드인경우만 적용
			Redraw = false;
			//마우스 위치를 행으로 리턴 
			var Row = sheetObj.MouseRow;
			var Col = sheetObj.MouseCol;
			var lColor1 = sheetObj.WebColor("#FFFFC0");	//기본색생
			var lColor2 = sheetObj.WebColor("#FF0000");	//중복색생
			var dupCntrNo  = sheetObj.CellValue(Row, prefix1+"cntr_no");
			
			dupColorAry(sheetObj);
			
			if(Row > 1 && colorAry.length > 0){
				var boolChk = false;	//중복여부 
				for(var i=0; i < colorAry.length; i++){
				  if(Row == colorAry[i]){
					  boolChk = true;
					  break;
				  }
				}
				
				if(boolChk){
					  var dupMsg2 = "";
					  if(Col !=2){
						  dupMsg2 = dupCntrMsg(dupCntrNo, sheetObj, "OnMouseDown");
					  }
					  //중복데이타행과 그 자동 선택된 행의 배경색상을 설정
					  sheetObj.SelectBackColor = lColor2;
					  if(Col !=2){
						  alert(dupMsg2);
					  }
				}else{
				  sheetObj.SelectBackColor = lColor1;
				}
			}else{
				sheetObj.SelectBackColor = lColor1;
			}
			Redraw = true;
		//}
	}
	
    /**
     * t2sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnClick(sheetObj, Row, Col, Val) {
     	with(sheetObj) {
     		if(SaveNameCol(prefix2 + "prp_shp_nm") == Col || SaveNameCol(prefix2 + "hzd_desc") == Col) {
     			if(Val != '') ComShowMemoPad(sheetObj, Row, Col, true, 250, 100);
     		}
     	}
    }

	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {	
		sheetObjects[sheetCnt++] = sheet_obj;	
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {	
		comboObjects[comboCnt++] = combo_obj;	
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	 
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
			case 1:
				with (tabObj) {
					var cnt = 0;
					InsertTab(cnt++, "Volume/Weight", -1);
					InsertTab(cnt++, "Special Cargo", -1);
				}
				break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
		
		//Excel Download 버튼 조절
		if(sheetObjects[nItem].RowCount > 0) ComBtnEnable("btn_DownExcel");
		else ComBtnDisable("btn_DownExcel");
	}

	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {	
		//IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//IBTab 초기화
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		//IBSheet 초기화
		for (i = 0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);	
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//버튼 비활성화
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_SaveAsXML");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_Display");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("btn_DownExcel");
		
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_DupCntr");
		
		//Axon Event Listener 등록
		initControl();
	
		//초기 포커스 위치
		ComSetFocus(document.form.vsl_cd);
	}
	 
	/**
	 * IBCOMBO 초기화. <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "yd_cd":
				with (comboObj) {
					BackColor       = "#CCFFFF";
					DropHeight      = 230;
					MultiSelect     = false;
					MaxSelect       = 1;
					UseAutoComplete = true;
				}
				break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}

	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}

	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else ComSetNextFocus(obj);
			
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}

	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	function obj_blur() {
		var formObj  = document.form;
		
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//VVD Info 가져오기
						searchVVDInfo();
					}		
					
					break;
					
				default:
					break;
			}
		}
	}
	 
	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var comboObj = comboObjects[0];
		
		//관련항목 초기화
		resetForCondition(formObj, "vvd");
	
		formObj.f_cmd.value = SEARCH05;
		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));		
	
		var vvdData = ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
		if (vvdData == null) {
			ComShowCodeMessage("OPF50004", 'Data');
			
			//관련항목 초기화
			resetForCondition(formObj, "vvd");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			
			//포커스 이동
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);
			
			//POL 가져오기
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", FormQueryString(formObj));
			var sPol = ComGetEtcData(sXml, "sPol");
			
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				var polCd = ""; //yd_code + clpt_ind_seq
				
				for (var cCt=0; cCt<arrPol.length; cCt++) {
					polCd = arrPol[cCt];
					if(polCd != '') polCd = polCd.substring(0, polCd.length-1); 
					comboObj.InsertItem(cCt, polCd, arrPol[cCt]);
				}
			}
			
			//포커스 이동
			ComSetFocus(formObj.yd_cd);
		}
		sheetObj.WaitImageVisible = true;
	}
	 
    /**
	 * VVD/POL 변경시 관련항목 초기화 <br>
	 **/
	function resetForCondition(formObj, what) {	
		var comboObj = comboObjects[0];
		
		//VVD
		if(what.indexOf("vvd") != -1) {
			if(what.indexOf("pol") == -1) {
				ComSetObjValue(formObj.vsl_eng_nm, "");
				ComSetObjValue(formObj.slan_cd,    "");
				ComSetObjValue(formObj.slan_nm,    "");			
				
				comboObj.RemoveAll();
			}
			ComSetObjValue(formObj.loc_nm,     "");
			ComSetObjValue(formObj.yd_nm,      "");
			ComSetObjValue(formObj.eta,        "");
			
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");
		}
		
		//Common
		for (var radioCt=0; radioCt<2; radioCt++) {
			formObj.cbf_ind_flg[radioCt].checked    = false;
			formObj.cbf_bkg_sts_cd[radioCt].checked = false;
		}
		
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
		
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_SaveAsXML");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_Display");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("btn_DownExcel");
		
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_DupCntr");
	}
	 
	/**
	 * POL 콤보 데이터 선택시. <br>
	 **/
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
	
		//관련항목 초기화
		resetForCondition(formObj, "vvd-pol");
		
		if(Code != '') {		
			//POL Info 가져오기
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
	
			var sPol = ComGetEtcData(sXml, "sPol");
	
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
				
				ComBtnEnable("btn_BookingClosingStatus");
				
				ComSetFocus(formObj.cbf_ind_flg[0]);
			}
			
			// Last Created Info 가져오기
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", FormQueryString(formObj));
			
			//1. CBF, Booking Status 상태 조회
			
//			//파라미터 명시적인 생성
// 			var formParams2 = "";
//     		formParams2 += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
//     		formParams2 += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
//     		formParams2 += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
//     		formParams2 += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
//     		formParams2 += "&yd_cd="      +comboObjects[0].Code; 
			
//			--var sXml = sheetObj1.GetSearchXml("VOP_OPF_0019GS.do", formParams2);
			var sCbf = ComGetEtcData(sXml, "sCbf");
			if (sCbf != undefined) {
				var arrCbf = sCbf.split("|");
				if ((arrCbf[2] != null) && (arrCbf[2] != '')) {
					ComSetObjValue(formObj.upd_usr_id, arrCbf[2]=='null'?"":arrCbf[2]);
				} else {
					ComSetObjValue(formObj.upd_usr_id, "");
				}
				if ((arrCbf[3] != null) && (arrCbf[3] != '')) {
					ComSetObjValue(formObj.upd_dt, arrCbf[3]=='null'?"":arrCbf[3]);
				} else {
					ComSetObjValue(formObj.upd_dt, "");
				}
			}	
		}
	}

	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				switch (event.srcElement.name) {
					case "vsl_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "skd_voy_no":
						//숫자입력하기
						ComKeyOnlyNumber(event.srcElement);
						break;
					case "skd_dir_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "crr_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "yd_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "dup_cntr_no":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;	
				}
				break;
				
			default:
				//공통기준:영문, 숫자만을 인식
				ComKeyOnlyAlphabet("num");
				break;
		}
	}

	/**
	 * VVD  데이터 수정시. <br>
	 **/
	function obj_change() {
		var formObj  = document.form;		
		
		with (event.srcElement) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					
					//관련항목 초기화					
					resetForCondition(formObj, "vvd");
					
					break;
				/*case "dup_cntr_no": 	
					//컨테이너 바로가기
					if(formObj.dup_cntr_no.value.length == 11){
						var sheetObj = sheetObjects[0];
						var lastRow  = sheetObj.LastRow;
						var dupCntrNo = formObj.dup_cntr_no.value;
						var firstMove = 0;
						
						if(sheetObj.LastRow > 0){
							alert(dupCntrNo) //SEGU4818400
							for(var i=0; i < sheetObj.LastRow; i++){
								var compCntrNo = sheetObj.CellValue(i, prefix1+'cntr_no');
								
								if(dupCntrNo == compCntrNo){
									alert(1);
									firstMove = sheetObj.CellValue(i, prefix1+'No.');
									sheetObj.SelectCell(firstMove,3);
									break;
								}
							}
						}
					}
					break;	*/			
			}
		}
	}

	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj  = document.form;
		if (rtnObjs) {
			var rtnDatas = rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
	
					// 포커스 이동
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}

	/**
	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVVD(obj) {
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		if (obj) {
			var rtnDatas = obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					
					//VVD Info 가져오기
					searchVVDInfo();
				}
			}
		}
	}
	 
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
			case 1: // t1sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 342;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);
	
					var HeadTitle1 = "|No.|DEL|BKG No.|CNTR No.|POD|TMNL|BS CD|OPR|TP|WGP|F/E|Special Cargo|Special Cargo|Special Cargo|Special Cargo|STWG|CN GR WT\n(kg)|BKG\nStatus|CBF DP CD|UPD USR ID|UPD DT|VSL CD|SKD VOY NO|SKD DIR CD|BKG SHPR OWNR FLG|YD CD|POL_CLPT_IND_SEQ|POD_CLPT_IND_SEQ|CBF SMRY SEQ|SPCL CGO SEQ|FWRD OVR DIM LEN|BKWD OVR DIM LEN|HGT OVR DIM LEN|CBF IND FLG|Booking Status|ActCntrFlg|RD ST|HIDDEN|SLAN CD|DUP_CNTR_CHK|";
					var HeadTitle2 = "|No.|DEL|BKG No.|CNTR No.|POD|TMNL|BS CD|OPR|TP|WGP|F/E|DG|RF|AK|BB|STWG|CN GR WT\n(kg)|BKG\nStatus|";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix1 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	true, 	prefix1 + "No.");
					
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	prefix1 + "del_chk", 			false, 	"", dfNone, 	0, true,  true, 1, false, false, false, false);
					
					InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, 	prefix1 + "bkg_no", 			false, "", dfNone, 		0, false, false);	
					InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, 	prefix1 + "cntr_no", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "pod_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "pod_yd_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "mlb_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "crr_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "cntr_tpsz_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "cntr_wgt_grp_cd", 	false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "full_mty_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix1 + "dcgo_flg", 			false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix1 + "rc_flg",				false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix1 + "awk_cgo_flg", 		false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix1 + "bb_cgo_flg", 		false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix1 + "stwg_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			70, 	daRight, 	true, 	prefix1 + "cntr_grs_wgt", 		false, "", dfNullFloat, 1, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, 	true, 	prefix1 + "bkg_sts_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_dp_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter,	false, 	prefix1 + "upd_dt");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "vsl_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "skd_voy_no");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "skd_dir_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "bkg_shpr_ownr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "yd_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "pol_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "pod_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_smry_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "spcl_cgo_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "fwrd_ovr_dim_len");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "bkwd_ovr_dim_len");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "hgt_ovr_dim_len");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_ind_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "cbf_bkg_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "ac_cntr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "rd_st");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "hid");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "slan_cd");
					InitDataProperty(0, cnt++, dtSeq, 			25, 	daCenter, 	true, 	prefix1 + "hseq");
					InitDataProperty(0, cnt++, dtHidden, 		25, 	daCenter, 	false, 	prefix1 + "dup_cntr_chk");
	 
					HeadRowHeight = 20;
					ColHidden(prefix1 + "del_chk") = true;	//20140801 수정 
					ColHidden(prefix1 + "hseq") = true;
	
					HighLightAfterSort = 1;// 소트 이후 기존에 선택하고 있던 데이터를 찾아감.
				}
				break;
	
			case 2: // sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 342;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);
	
					var HeadTitle1 = "|No.|BKG No.|CNTR No.|POD|TMNL|BS\nCD|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|SG|Reefer\nTemp.(°C)|Commodity|OverAll(cm)|OverAll(cm)|OverAll(cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|CBF DP CD|||||||||||CBF IND FLG|Booking Status|RD ST|HIDDEN|SLAN CD|";
					var HeadTitle2 = "|No.|BKG No.|CNTR No.|POD|TMNL|BS\nCD|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|SG|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|||||||||||||||||";
	
					var headCount = ComCountHeadTitle(HeadTitle2);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	true, 	prefix2 + "No.");
					InitDataProperty(0, cnt++, dtData, 			96, 	daLeft, 	true, 	prefix2 + "bkg_no", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			86, 	daLeft, 	true, 	prefix2 + "cntr_no", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "pod_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	true, 	prefix2 + "pod_yd_cd", 			    false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "mlb_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "crr_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	true, 	prefix2 + "cntr_tpsz_cd", 			false, "", dfNone, 		0, false, false);
		
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "dcgo_flg", 				false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "rc_flg", 				false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "awk_cgo_flg", 			false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "bb_cgo_flg", 			false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtCheckBox, 		37, 	daCenter, 	true, 	prefix2 + "stwg_cgo_flg", 			false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	false, 	prefix2 + "cntr_seq", 				false, "", dfInteger, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, 	false, 	prefix2 + "cgo_seq", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	prefix2 + "cntr_grs_wgt", 			false, "", dfNullFloat, 3, false, false);
					InitDataProperty(0, cnt++, dtData, 			90, 	daRight, 	true, 	prefix2 + "cgo_grs_wgt", 			false, "", dfNullFloat, 3, false, false);
					InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	prefix2 + "imdg_clss_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "imdg_un_no", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "prp_shp_nm", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daLeft, 	true, 	prefix2 + "hzd_desc", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, 	true, 	prefix2 + "imdg_subs_rsk_lbl_cd", 	false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "imdg_mrn_polut_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "pck_grp_cd", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "lmt_qty_flg", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			35, 	daCenter, 	true, 	prefix2 + "expt_qty_flg", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "fdo_temp", 				false, "", dfNullFloat, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, 	prefix2 + "hzd_ctnt", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			75, 	daCenter, 	true, 	prefix2 + "cdo_temp", 				false, "", dfNullFloat, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	prefix2 + "cbf_cmdt_nm", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	prefix2 + "dim_len", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	prefix2 + "dim_wdt", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	prefix2 + "dim_hgt", 				false, "", dfNumber, 	0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	prefix2 + "ovr_fwd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	prefix2 + "ovr_aft", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	prefix2 + "ovr_lft", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	prefix2 + "ovr_rgt", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daRight, 	false, 	prefix2 + "ovr_hgt", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			45, 	daCenter, 	true, 	prefix2 + "crn_pst_sts_cd", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "stwg_cd", 				false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	prefix2 + "spcl_cgo_auth_flg", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, 	prefix2 + "apro_ref_no", 			false, "", dfNone, 		0, true,  true, 50);
					InitDataProperty(0, cnt++, dtData, 			150, 	daLeft, 	true, 	prefix2 + "cbf_rmk", 				false, "", dfNone, 		0, true,  true);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_dp_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "upd_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "upd_dt");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "vsl_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "skd_voy_no");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "skd_dir_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "bkg_shpr_ownr_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "yd_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "pol_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "pod_clpt_ind_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_smry_seq");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_ind_flg");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "cbf_bkg_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "rd_st");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "hid");
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "slan_cd");
					InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, 	true, 	prefix2 + "hseq");
		
					ColHidden(prefix2 + "hseq") = true;
		
					HighLightAfterSort = 1;// 소트 이후 기존에 선택하고 있던 데이터를 찾아감.
		
					ImageList(0) = "img/alps/button/btns_multisearch.gif";
					ImageList(1) = "img/alps/button/btng_minus.gif";
		
					MultiSelection    = false;
					HeadRowHeight     = 20;
					SelectHighLight   = true;
					EditableColorDiff = false;
					
					// 타이틀 배경 193,196,232
					// 서브 타이틀 배경 203,210,248
					SheetBackColor  = RgbColor(248, 248, 248);
					SelectBackColor = RgbColor(236, 246, 247);
					CellBackColor(1, 0) = RgbColor(193, 196, 232);
					
					FocusEditMode = -1;
					InitDataValid(0, prefix2 + "apro_ref_no", vtEngOther, "1234567890~!@#$%^&*()_+-=,./{}[]:;' ");
					InitDataValid(0, prefix2 + "cbf_rmk", vtEngOther, "1234567890/*:, ");
				}
				break;
		}
	}
	 
	// Sheet Redraw
	function doRedraw(how) {
		for(var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {
			sheetObjects[sheetCt].Redraw = how; 
		}
	}
	
	// Sheet ColEditable
	function doColEditable(sheetObj, how) {
		//sheetObj.InitDataProperty(0, sheetObj.SaveNameCol(prefix2+"cbf_rmk"), dtData, 150, daLeft, true, prefix2+"cbf_rmk", false, "", dfNone, 0, how, how);
	}
	
	//Booking Status 원복
	function rollBackBkgStaus(formObj) {
		for (var radioCt=0; radioCt<2; radioCt++) {
			if (ComGetObjValue(formObj.bk_st) == formObj.cbf_bkg_sts_cd[radioCt].value) {
				formObj.cbf_bkg_sts_cd[radioCt].checked = true;
			}
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {	
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
					
					formObj.f_cmd.value = SEARCH;
					
					//파라미터 명시적인 생성
					var formParams = "";
					formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
					formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					formParams += "&yd_cd="             +comboObjects[0].Code;	
					formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
					var arrXml = sXml.split("|$$|");
					
					var arrCt = arrXml.length;
					if (arrXml != null && arrCt > 0) {
						for (var sRstCt=arrCt; sRstCt>0; sRstCt--) {
							sheetObjects[sRstCt-1].LoadSearchXml(arrXml[sRstCt-1]);
						}
					}
				}
	
				break;
				
			case IBBATCH: // Display
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				
				//Booking Status 결정
				ComSetObjValue(formObj.bk_st, formObj.cbf_bkg_sts_cd[0].checked?formObj.cbf_bkg_sts_cd[0].value:formObj.cbf_bkg_sts_cd[1].value);
				
				formObj.f_cmd.value = REPLY;
				
				//파라미터 명시적인 생성
				var formParams = "";
				formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
				formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
				formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
				formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
				formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
				formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
				formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
				formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
				formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
				formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				
				var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
				var arrXml = sXml.split("|$$|");
				
				var arrCt = arrXml.length;
				if (arrXml != null && arrCt > 0) {
					for (var bRstCt=arrCt; bRstCt>0; bRstCt--) {
						sheetObjects[bRstCt-1].LoadSearchXml(arrXml[bRstCt-1]);
					}
				}
	
				break;
				
			case IBDELETE:        //삭제
				//'삭제하시겠습니까?'
	    		if(!ComShowCodeConfirm('OPF50002', 'data')) return false;	//'Do you want to delete {?msg1}?'
			
	     	    formObj.f_cmd.value = REMOVE;
	     	    
	     	    //파라미터 명시적인 생성
				var formParams = "";
				formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
				formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
				formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
				formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
				formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
				formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
				formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
				formParams += "&yd_cd="             +comboObjects[0].Code;	
				formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
				formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
				formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
	     	    
	     	    var sXml = sheetObj.GetSaveXml("VOP_OPF_0019GS.do", formParams);
				sheetObj.LoadSaveXml(sXml);
	 		   
	 		    //초기화
	 		    document.all.btn_New.fireEvent('onclick');
	 		    
	 		    //삭제버튼 비활성화
	 		    ComBtnDisable("btn_Delete");
	     		   
	            break;  
	
			case IBSAVE: // Save
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				
				if(ComGetObjValue(formObj.f_cmd) == SEARCH) {					
					var sheetObj2 = sheetObjects[1];
					var sParam = ComGetSaveString(sheetObj2);
					if(sParam == "") {
						//CBF 상태 변경 여부 체크
						if(sheetObjects[0].CellValue(sheetObjects[0].LastRow, prefix1+"cbf_ind_flg") == ComGetObjValue(formObj.cbf_ind_flg)) return;
						
						if (!ComShowCodeConfirm("OPF50019")) return;
						
						//Booking Status 원복
						rollBackBkgStaus(formObj);
						
						formObj.f_cmd.value = MULTI;
						
						//파라미터 명시적인 생성
						var formParams = "";
						formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
						formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
						formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
						formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
						formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
						formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
						formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
						formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
						formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
						formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
						formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
						formParams += "&yd_cd="             +comboObjects[0].Code;	
						formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
						formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
						formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
						formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
						
						var sXml = sheetObj2.GetSaveXml("VOP_OPF_0019GS.do", formParams);
						sheetObj2.LoadSaveXml(sXml);
					} else {
						if (!ComShowCodeConfirm("OPF50019")) return;
						
						formObj.f_cmd.value = MULTI;
						
						//파라미터 명시적인 생성
						var formParams = "";
						formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
						formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
						formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
						formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
						formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
						formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
						formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
						formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
						formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
						formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
						formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
						formParams += "&yd_cd="             +comboObjects[0].Code;	
						formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
						formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
						formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
						formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
						
						sheetObj2.DoSave("VOP_OPF_0019GS.do", formParams, -1, false);
					}					
					
					//상태를 Retrieve 로 변경
					formObj.f_cmd.value = SEARCH;
				} else {
					//기생성된 CBF 확인
					var fCmd = formObj.f_cmd.value;
					formObj.f_cmd.value = SEARCH06;
					
					//파라미터 명시적인 생성
					var formParams = "";
					formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
					formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					formParams += "&yd_cd="             +comboObjects[0].Code;	
					formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					var formParams2 = formParams;	// for SEARCH08
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", formParams);
					var sCBFCount = ComGetEtcData(sXml, "sCBFCount");
					
					// Container 정보 없이 Header 정보만 있는 경우 Check
					formObj.f_cmd.value = SEARCH08;
					formParams2 += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0019GS.do", formParams2);
					var sCBFCount2 = ComGetEtcData(sXml, "sCBFCount"); 
					
					if ((sCBFCount > 0) || (sCBFCount2 > 0)  ) {
						if (!ComShowCodeConfirm("OPF50019")) {
							formObj.f_cmd.value = fCmd;
							return;
						}
					}
					 
					//현재 일시 구하기
					var creDt = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");					
					ComSetObjValue(formObj.cre_dt, creDt)
					
					//Booking Status 원복
					rollBackBkgStaus(formObj);
					
					formObj.f_cmd.value = MULTI;
					
					//파라미터 명시적인 생성
					var sParam = "";
					sParam += "bk_st="              +ComGetObjValue(formObj.bk_st);
					sParam += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					sParam += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					sParam += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					sParam += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					sParam += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					sParam += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					sParam += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					sParam += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					sParam += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					sParam += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					sParam += "&yd_cd="             +comboObjects[0].Code;	
					sParam += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					sParam += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					sParam += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					sParam += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					
					//속도문제로 아래방법으로 대체
					sParam += "&"+ComGetSaveString(sheetObjects[0], false, true);
					sParam += "&"+ComGetSaveString(sheetObjects[1], false, true);	
					
//					sParam += "&"+ getAllSaveText(sheetObjects[0]);				
//					sParam += "&"+ getAllSaveText(sheetObjects[1]);
					
					var sXml = sheetObj.GetSaveXml("VOP_OPF_0019GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
					
					//버튼 활성화
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_SummaryPreview");
					
					//상태를 Retrieve 로 변경
					formObj.f_cmd.value = SEARCH;
					var sheet1Ct  = sheetObjects[0].RowCount;
					
					var sheetObj2 = sheetObjects[1];
					for(var upCt=sheetObj2.HeaderRows; upCt<=sheetObj2.LastRow; upCt++) {
						sheetObj2.CellValue2(upCt, prefix2+"cbf_smry_seq")   = ++sheet1Ct;
						sheetObj2.CellValue2(upCt, prefix2+"cbf_ind_flg")    = ComGetObjValue(formObj.cbf_ind_flg);
						sheetObj2.CellValue2(upCt, prefix2+"cbf_bkg_sts_cd") = ComGetObjValue(formObj.cbf_bkg_sts_cd);
						sheetObj2.RowStatus(upCt) = "R";
					}
					
					//아이디, 일시 셋팅하기
					ComSetObjValue(formObj.upd_usr_id, userId);
					ComSetObjValue(formObj.upd_dt, creDt);
				}
				
				//CBF 상태 변경을 체크하기 위해 CBF Status 저장
				sheetObjects[0].CellValue2(sheetObjects[0].LastRow, prefix1+"cbf_ind_flg") = ComGetObjValue(formObj.cbf_ind_flg);

				break;
		}
	}
	
	//Making string to save
//	function getAllSaveText(sheetObj) {		
//		var arrSave = new Array();
//		for (var i=0; i<=sheetObj.LastCol; i++ ) {
//			arrSave[i] = sheetObj.ColSaveName(i);
//		}
//		var str = sheetObj.GetRangeText(sheetObj.HeaderRows, 0, sheetObj.LastRow, sheetObj.LastCol, "@", "^");
//		str = str.replace(/\,/gi, "");
//		
//		var arrStr = str.split("^");
//		for (var i = 0 in arrStr) {
//			var arrCol = arrStr[i].split("@");
//			for (var j = 0 in arrCol) {
//				arrCol[j] = arrSave[j]+"="+arrCol[j];
//			}
//			arrStr[i] =  arrCol.join("&");
//		}
//		return  arrStr.join("&");
//	}

	/*******************************************************************************
	 * Validation 시작 *
	 ******************************************************************************/
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
	
		case IBSEARCH:
			//폼 개체 안에 모든 컨트롤의 Validation을 확인
			if (!ComChkValid(formObj, true, false, false)) return false;
			
			//Check requirement of POL
	    	if(ComGetObjValue(document.all.yd_cd) == '') {
	    		ComAlertFocus(document.all.yd_cd, "'POL' " +Msg_Required);	    		
	    		return false;
	    	}
	    	
			break;
		case IBSAVE:
			//Check requirement of CBF
			var chkRslt = false;
			for(var chkCt=0; chkCt<formObj.cbf_ind_flg.length; chkCt++) {
				if(formObj.cbf_ind_flg[chkCt].checked) chkRslt = true;
			}
			if(!chkRslt) {
				ComAlertFocus(formObj.cbf_ind_flg[0], "'CBF' " +Msg_Required);
				return false;
			}
			
			//폼 개체 안에 모든 컨트롤의 Validation을 확인
			if (!ComChkValid(formObj, true, false, false)) return false;
			
			//Check requirement of POL
	    	if(ComGetObjValue(document.all.yd_cd) == '') {
	    		ComAlertFocus(document.all.yd_cd, "'POL' " +Msg_Required);	    		
	    		return false;
	    	}
	
			break;
		}
	
		return true;
	}

/* 개발자 작업 끝 */