/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1206.js
*@FileTitle  : Reject Reason Remarks
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author  
     */
    /**
     * @extends 
     * @class VOP_OPF_1206 : VOP_OPF_1206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_1206() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var prefix1="sheet1_";
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	function processButtonClick() {
		var sheetObject=sheetObjects[0];
		// var sheetObject1=sheetObjects[1];
		var formObject = document.form;
		var param = "";

		try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_save" :
				if(ComGetObjValue(formObject.isPop) == 'R') {
					parent.document.form.rejectRmk.value = ComGetObjValue(formObject.rejectRmk);
				}
				if(ComGetObjValue(formObject.isPop) == 'C') {
					parent.document.form.codRemark.value = ComGetObjValue(formObject.rejectRmk);
					formObject.f_cmd.value=MODIFY01;
					formObject.codRemark.value = ComGetObjValue(formObject.rejectRmk);
					var param = "&bkg_no=" + parent.document.form.bkg_no.value;
					param += "&cod_rqst_seq=" + parent.document.form.cod_rqst_seq.value;
        			sheetObject.DoSave("VOP_OPF_0206GS.do", FormQueryString(formObject) + param ,-1,false,true);
				}
//    			parent.document.all.rejectRmkView.style.display = "none";
				ComClosePopup();
				break;
			case "btn_close" :
/*
				if (ComGetObjValue(formObject.isPop) == "C") {
					parent.document.all.codRemarkView.style.display = "none";
				} else if (ComGetObjValue(formObject.isPop) == "R") {
					parent.document.all.rejectRmkView.style.display = "none";
				} else if (ComGetObjValue(formObject.isPop) == "Q") {
					parent.document.all.qtyView.style.display = "none";
				}
*/
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
    function loadPage() {
    	if (document.form.isPop.value == "Q") {
//    		document.form.rejectRmk.value = parent.document.all.tempQtyView.value;
    		document.form.rejectRmk.value = parent.document.form.qty_list.value;
    	}
    	for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
    	sheetObjects[0].DataInsert(-1);
    	sheetObjects[0].SetCellValue(0, "sheet1_cod_rqst_seq",document.form.cod_rqst_seq.value);
    	sheetObjects[0].SetCellValue(0, "sheet1_bkg_no",document.form.bkg_no.value);
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
        return true;
    }
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet1 init
                with (sheetObj) {
           	 
	            	 var HeadTitle="1|2|3|4";
	            	 var prefix="sheet1_";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status", Hidden:1, Width:0, Align:"Center", ColMerge:1, SaveName:prefix+"ibflag" },
	            	              {Type:"Text",   Hidden:1, Width:0, Align:"Center", ColMerge:1, SaveName:prefix+"cod_rqst_seq", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
	            	              {Type:"Text",   Hidden:1, Width:0, Align:"Center", ColMerge:1, SaveName:prefix+"bkg_no",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
	            	              {Type:"Text",   Hidden:1, Width:0, Align:"Center", ColMerge:1, SaveName:prefix+"diff_rmk",     KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 }];
	            	  
	            	 InitColumns(cols);
                	}
                break;
        	}
        }