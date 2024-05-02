/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0806.js
*@FileTitle : Loading Confirmation by Shipper Preview And Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.06 김기종
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
     * @author CLT
     */

    /**
     * @extends 
     * @class esm_bkg_0806 : esm_bkg_0806 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0806() {
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

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
    	 var sheetObject = opener.sheetObjects[0];
         var formObject = opener.document.form;
         var param="";
         
		param=RdParam(formObject,sheetObject,"");
		rdOpen(formObject,param );
	}
    
	/*
	* Rd 파라함수
	*/
	function RdParam(formObject,sheetObject,prefix) { 
		var strResult = ""; 
		var key1 ="";
		var key2="";
		var key3="";
		var key4="";
		var key5="";
		var key6="";
		var key7="";
		
		var vsNM ="";
		var tabflag="";
		var iCheckRow = sheetObject.FindCheckedRow(prefix + "Check"); 
		
		var arrRow = iCheckRow.split("|"); 
		
		for (idx=0; idx<arrRow.length-1; idx++) {	
			if(sheetObject.CellValue(arrRow[idx],prefix+"Check")==true){ 
				if (key1.length > 1){
					key1+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_no")+"'";
					key2+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"'";
					key3+=","+"'"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_cust_tp_cd")+"'";
				}else{
					key1="('"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_no")+"'";
					key2="('"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"'";
					key3="('"+sheetObject.CellValue(arrRow[idx],prefix+"bkg_cust_tp_cd")+"'";
				}
			}
		}
		key4 = ComGetObjValue(formObject.language);
		
		key5 = ComGetObjValue(formObject.mphn_no);
		key6 = ComGetObjValue(formObject.fax_no);
		key7 = ComGetObjValue(formObject.snd_dt);
		
		strResult ="["+ key1+")] " + "["+ key2+")] " + "["+ key3+")] " + "['"+ key4+"'] "+ "['"+ key5+"'] "+ "['"+ key6+"'] "+ "['"+ key7+"'] ";
		
		return strResult; 
	}
    
	/*
	* Rd 오픈
	*/
	function rdOpen(formObject, param){
		
		var rdParam = "/rp " + param + " /riprnmargin /rwait";

		// 열고자 하는 RD 파일을 지정한다.
		var strPath = RD_path+"apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0806.mrd";
		
//		viewer.SetMsgTitle("Loading Confirmation by Shipper Preview & Print");
		
		viewer.openFile(strPath, RDServer + rdParam, {timeout:1800}); 

	}

	/* 개발자 작업  끝 */