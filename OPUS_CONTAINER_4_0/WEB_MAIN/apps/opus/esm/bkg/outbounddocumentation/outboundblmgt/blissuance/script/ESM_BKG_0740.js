/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0740.js
*@FileTitle  : Group Update for B/L Issue And Onboard Date
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 //var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
//    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "img_ob_cal":
					var cal=new ComCalendar();
					cal.select(formObject.ob_date, 'yyyy-MM-dd');
					
				break;
				case "img_issue_cal":
					var cal=new ComCalendar();
					cal.select(formObject.issue_date, 'yyyy-MM-dd');	
				break;
				case "btn_save":
					//alert(srcName);
					var ob_date=(formObject.ob_chk.checked) ? formObject.ob_date.value : "";
					var issue_date=(formObject.issue_chk.checked) ? formObject.issue_date.value : "";
					var ussue_at=formObject.ussue_at.value;
					var ussue_by=formObject.ussue_by.value;
					if (formObject.credit_chk.checked == true) {
						var credit_chk='Y';
					}else {
						var credit_chk='N';
					}
					if(formObject.ob_chk.checked && ob_date == ''){
						//alert("onboard date");
						formObject.ob_date.focus();						
						return;
					}
					if(formObject.issue_chk.checked && issue_date == ''){
						//alert("issue date");
						formObject.issue_date.focus();						
						return;
					}					
					if(formObject.ob_chk.checked && formObject.issue_chk.checked){
						var fmData=ComTrimAll(formObject.ob_date, "-");
						var toData=ComTrimAll(formObject.issue_date, "-");
						if(fmData > toData){
							ComShowMessage(ComGetMsg('BKG00398'));
							return;
						}		
					}
					//alert("ob_date=" + ob_date + ", issue_date=" + issue_date);
//					if(ob_date != '' && validateData(ob_date) == false){
//						ComShowMessage(ComGetMsg('BKG00385'));
//						return;
//					}
//					if(issue_date != '' && validateData(issue_date) == false){
//						ComShowMessage(ComGetMsg('BKG00385'));
//						return;
//					}
					// return
					if(!opener) opener=parent;  
					if(callback_func != ''){
						eval("opener." + callback_func)(ob_date, issue_date, ussue_at, ussue_by, credit_chk);
					}

				//break;
				case "btn_close":
					ComClosePopup(); 
				break;																					
            } // end switch
/*			
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("지금은 사용하실 수가 없습니다 \n"+
					  "* File Name   : " + e.fileName + "\n" +
					  "* Line Name   : " + e.lineNumber + "\n" +
					  "* Description : " + e.description );
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
*/
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//
		//document.form.ob_date.value = ComGetNowInfo();
		//document.form.issue_date.value = ComGetNowInfo();
		//add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
	function validateData(shd_dt){
		// Should 값에 ETA -3 , ETD + 3 의 범위를 벗어나는지 확인 - 넘어가는 BKG가 있을 경우 메시지 [BKG00385] 표시하고 리턴
		var eta=document.form.eta.value;
		var etd=document.form.etd.value;
		//var obd_dt = formObject.ob_date.value;
		//var iss_dt = formObject.issue_date.value;
		//alert(">eta=" + eta + ", etd=" +etd + ", shd_dt=" +shd_dt);
		var etaArr=eta.split("-"); 
		var etdArr=etd.split("-");
		//var obdArr = obd_dt.split("-");
		//var issArr = iss_dt.split("-");
		var shdArr=shd_dt.split("-");
		if( etaArr.length != 3 || etdArr.length != 3 || shdArr.length != 3){
			alert("날짜 형식이 잘못되었습니다.");
			return false;
		}
		var etaDt=new Date(Number(etaArr[0]),Number(etaArr[1])-1,Number(etaArr[2]));
		var etdDt=new Date(Number(etdArr[0]),Number(etdArr[1])-1,Number(etdArr[2]));
		//var obdDt = new Date(Number(obdArr[0]),Number(obdArr[1])-1,Number(obdArr[2]));
		//var issDt = new Date(Number(issArr[0]),Number(issArr[1])-1,Number(issArr[2]));
		var shdDt=new Date(Number(shdArr[0]),Number(shdArr[1])-1,Number(shdArr[2]));
		var etaInt=Math.floor(etaDt.valueOf()/(24*60*60*1000)-3);
		var etdInt=Math.floor(etdDt.valueOf()/(24*60*60*1000)+3);
		//var obdInt = Math.floor(obdDt.valueOf()/(24*60*60*1000));
		//var issInt = Math.floor(issDt.valueOf()/(24*60*60*1000));
		var shdInt=Math.floor(shdDt.valueOf()/(24*60*60*1000));
		//alert(obdInt + " < " +etaInt+ " = " + (obdInt < etaInt) +"\n"+ obdInt + " > " +etdInt+ " = " + ( obdInt > etdInt));
		//if(obdInt < etaInt || obdInt > etdInt){
		//	ComShowMessage(ComGetMsg('BKG00385'));
		//	sheetObj.SelectCell(arRow[ir], "bl_obrd_dt_sd");
		//	return false;
		//}
		//alert(issInt + " < " +etaInt+ " = " + (issInt < etaInt) +"\n"+ issInt + " > " +etdInt+ " = " + (issInt > etdInt));
		//if(issInt < etaInt || issInt > etdInt){
		//	ComShowMessage(ComGetMsg('BKG00385'));
		//	sheetObj.SelectCell(arRow[ir], "obl_iss_dt_sd");
		//	return false;
		//}					
		//alert(issInt + " < " +etaInt+ " = " + (issInt < etaInt) +"\n"+ issInt + " > " +etdInt+ " = " + (issInt > etdInt));
		if(shdInt < etaInt || shdInt > etdInt){
			return false;
		}					
	}
	/* ----------------------------------------------------------------------------
	 * Event 처리
	 -----------------------------------------------------------------------------*/
	function form1_focus(){
		ComClearSeparator(event.srcElement);
	}
	function form1_blur(){
		ComChkObjValid(event.srcElement);
	}
	function form1_change(){
		var srcName=ComGetEvent("name");
		var formObject = document.form;
		switch(srcName){
			case "ob_date":
				formObject.ob_date.value=ComGetMaskedValue(formObject.ob_date.value, "ymd");
			break;
			
			case "issue_date":
				formObject.issue_date.value=ComGetMaskedValue(formObject.issue_date.value, "ymd");
			break;
		}
	}
	/* 개발자 작업  끝 */
