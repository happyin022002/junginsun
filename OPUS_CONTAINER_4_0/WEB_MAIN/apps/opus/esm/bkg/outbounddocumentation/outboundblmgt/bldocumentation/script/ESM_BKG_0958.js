/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0958.jsp
*@FileTitle  : Booking QTY Update Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

   	/* 개발자 작업	*/
	// 공통전역변수
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var formObject=document.form;
         var obj=new Object(); 
         var opener = parent;
         var formObj = opener.document.form;
         
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn1_Yes":
//					formObj.bkg_pck_qty.value=ComColumnSum(opener.sheetObjects[0], "pck_qty");
//					formObj.bkg_wgt_qty.value=ComColumnSum(opener.sheetObjects[0], "cntr_wgt");;
//					formObj.bkg_meas_qty.value= ComColumnSum(opener.sheetObjects[0], "meas_qty");
					formObj.bkg_pck_qty.value=ComColumnSum(opener.sheetObjects[1], "pck_qty");
					formObj.bkg_wgt_qty.value=ComColumnSum(opener.sheetObjects[1], "cntr_mf_wgt");
					formObj.bkg_meas_qty.value= ComColumnSum(opener.sheetObjects[1], "meas_qty");
					var hasDiff=false;
					var col_val='';
					for(rn=1;rn<=opener.sheetObjects[0].RowCount();rn++){
						if(rn!=1){
							if(col_val !=  opener.sheetObjects[0].GetCellValue(rn, "pck_tp_cd")){
								hasDiff=true;
								break;
							}
						}
						col_val= opener.sheetObjects[0].GetCellValue(rn, "pck_tp_cd");
					}
					formObj.bkg_pck_unit.value=col_val;
					opener.document.form.cntr_update_flg.value="Y";
					opener.doActionIBSheet(opener.sheetObjects[1],opener.document.form,COMMAND06);
					ComClosePopup();
					break;
				case "btn1_No":
					opener.doActionIBSheet(opener.sheetObjects[1],opener.document.form,COMMAND06);
					ComClosePopup();
					break;
				case "btn1_Close":
					ComClosePopup();
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
	function loadPage(){
	}
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		}
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
	/* 개발자 작업  끝 */
