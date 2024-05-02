/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3508.js
*@FileTitle  : Tariff Rule Summary Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
	var apro_usr_flg = "";
    document.onclick = processButtonClick;

    function processButtonClick(){
        var formObject = document.form; 
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {			
				case "btn_close":
					ComClosePopup(); 
					break;			
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}        
    }
    
   /**
	* Page 를 초기 로딩할 때 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     loadPage();
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.11.10
	*/	
    function loadPage() {
    	initRdConfig(viewer);
		rdOpen(viewer, document.form);
    }  
	
   /**
	* RD Viewer 를 초기화하기 위하여 사용함
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     initRdConfig(rdObject)
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.11.10
	*/	    
    function initRdConfig(rdObject){
    }

   /**
	* 특정 RD 파일에 대하여 RD Viewer 를 기동하기 위해 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     rdOpen(rdObject,formObj)
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.11.10
	*/	    
    function rdOpen(rdObject,formObj){
    	var path  = "apps/opus/esm/pri/tariff/tariffrule/report/ESM_PRI_3508.mrd";
    	var param = "/rp ["+formObj.trf_pfx_cd.value+"] ["+formObj.trf_no.value+"] ["+formObj.amdt_seq.value +"]  ["+formObj.trf_rule_no.value +"] [Y] [Y]";
    	var df_save_nm = formObj.trf_pfx_cd.value+"_"+formObj.trf_no.value;
    	viewer.openFile(RD_path + path, RDServer + param, {timeout:3000});
    	viewer.bind('report-finished', function(e){
    		controlBtn(true);
    		controlRdobtn(false);
    	});
    }