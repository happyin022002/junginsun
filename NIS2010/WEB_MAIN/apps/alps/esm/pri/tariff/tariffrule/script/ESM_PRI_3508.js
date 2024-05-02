/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3508.js
*@FileTitle : Tariff Rule Summary Print
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
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
     * @class ESM_PRI_3508 : ESM_PRI_3508 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3508() {
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
    var rdObjects = new Array();
    var rdCnt = 0;
       
	var apro_usr_flg = "";
	
    document.onclick = processButtonClick;

    function processButtonClick(){
        var formObject = document.form; 
        var Rdviewer = rdObjects[0];
        
		try {
			var srcName = window.event.srcElement.getAttribute("name");
           
			switch (srcName) {			
				case "btn_saveas":
					Rdviewer.SetSaveExcelOption (1); //1- Maintain formats when saving as Microsoft Excel files, 2- Allow to change formats.
  				    var ret = Rdviewer.SaveAsDialog (); // Save the current document with displaying the 'Save As' dialog box.
					break;
					
				case "btn_close":
					close(); 
					break;			
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
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
		ComBtnDisable("btn_saveas");
	   	//RD
    	initRdConfig(rdObjects[0]);
		controlTools(document.form);
		rdOpen(rdObjects[0], document.form);
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
		var Rdviewer = rdObject;
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.SetNoDataDialogInfo(0, "", "");
		//Rdviewer.DisableToolbar (1); 
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
    	var Rdviewer = rdObject ;
    	// 열고자 하는 RD 파일을 지정한다.
    	
    	var path  = "apps/alps/esm/pri/tariff/tariffrule/report/ESM_PRI_3508.mrd";
    	             
    	var param = "/rp ["+formObj.trf_pfx_cd.value+"] ["+formObj.trf_no.value+"] ["+formObj.amdt_seq.value +"]  ["+formObj.trf_rule_no.value +"] [Y] [Y] /rxlspagezoom [95]";
    	
    	var df_save_nm = df_save_nm = formObj.trf_pfx_cd.value+"-"+formObj.trf_no.value;
    	
    	Rdviewer.SetSaveDialogEx ("c:\\", df_save_nm, "xls@pdf@ppt@doc", "xls");
    	//RD_path = "http://localhost:7001/hanjin/";
    	Rdviewer.FileOpen(RD_path + path, RDServer + param);
    }

   /**
	* RD Viewer 에서 Viewer 의 속성을 변경하기 위하여 사용
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     controlTools(formObj);
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.11.10
	*/		
	function controlTools(formObj){
        var formObject = document.form;
        var Rdviewer = rdObjects[0];
		var file_nm = formObject.trf_pfx_cd.value + "-" + formObject.trf_no.value;
		Rdviewer.SetSaveDialogEx ("c:\\Documents and Settings\\", file_nm, "pdf@xls@doc@ppt", "pdf");						
	}

   /**
	* RD Viewer 에서 로딩이 완료되었을 경우에 Print  버튼과 Save As 버튼을 활성화 시킴
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     ReportFinished();
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.11.10
	*/		
	function ReportFinished(){
		ComBtnEnable("btn_saveas");	
	}

	/* 개발자 작업  끝 */