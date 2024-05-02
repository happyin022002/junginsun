/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0015.js
*@FileTitle  : Service Order 생성화면 - Chassis or Genset 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
	/**
	 * IBSheet Object를 배열로 등록
	 * comSheetObject(id)에서 호출한다
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
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//html컨트롤 이벤트초기화
	}
	function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
           case 1:      //sheet1 init
        	    with(sheetObj){
		             var HeadTitle="STS";
		             SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];              
		             InitColumns(cols);
		             SetEditable(0);
		             SetVisible(false);
                   }
               break;
        }
    }
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
//         var opener=window.dialogArguments;
//         if(!opener) opener=parent;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_apply":
					if(	formObject.pop_fm_loc.value == '' && 
						formObject.pop_to_loc.value == '' &&
						formObject.pop_transMode.value == '' &&
						formObject.pop_remark.value == '') return;
						opener.setPopupValue(formObject.pop_fm_loc.value,
											 pop_fm_yard.GetSelectCode(),
											 formObject.pop_to_loc.value,
											 pop_to_yard.GetSelectCode(),
											 formObject.pop_transMode.value,
											 formObject.pop_remark.value, window);
						ComClosePopup(); 
        	        break;
        	    case "btn_close":
        	    	ComClosePopup(); 
         	        break;
				case "btn_fm_node":
					openHireYardPopup('fm_node');
					break;
				case "btn_to_node":
					openHireYardPopup('to_node');
					break;
			 } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    function closePop() {
    	ComClosePopup();
    }
	/**
	 * 외부 콤보박스의 리스트 가져오기
	 **/
	function getComboList(obj)
	{
		var locObj=eval('document.form.'+obj+'_loc');
		var comboObj=eval(obj+'_yard');
		var formObj=document.form;
		if(ComTrim(locObj.value) == ''){
			comboObj.RemoveAll();
			return;
		}
		document.form.TRSP_SO_EQ_KIND.value='A';
		getYardCombo(comboObj, sheetObjects[0], formObj, locObj.value);
	}
	/**
	 * enter check
	 **/
	function enterCheck(obj)
	{
		if(event.keyCode == 13){ getComboList(obj); }
	}
	/**
	* 공통 Node popup
	*/
	function openHireYardPopup( btn_obj )
	{
		var formObject=document.form;
		var cmdt_cd_val="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val="";   //향후 사용가능 예정변수
		var cmdt_desc_val="";   //향후 사용가능 예정변수
		var classId="getCOM_ENS_061_1";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var returnFunction='setFmNode';
		if(btn_obj == 'to_node') returnFunction='setToNode';
		var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;

		//ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 480, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1',true);
		//ComOpenPopup('/opuscntr/COM_ENS_061.do', 770, 470, 'getCOM_ENS_061_2', "1,0,1,1,1,1,1,1,1,1");
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 480, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1',false);
	}
	/**
     * popSearchPiCommCodeGrid 프로세스 처리
     */
	function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
		var myUrl=getPopupURL(POPUP_PI_COMM);
		var myOption=getPopupOption(POPUP_PI_COMM);
		var url;
		if(myWin!=null)  ComClosePopup(); 
		url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
		myWin=window.open(url, "piCommCodePop", myOption);
		myWin.focus();
	}
	/**
	* fmNode를 팝업을 통해 세팅
	*/
	function setFmNode(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		var node=colArray[3];
		var loc=node.substring(0,5);
		var yard=node.substring(5,7);
		formObject.pop_fm_loc.value=loc;
		getComboList('pop_fm');
		pop_fm_yard.SetSelectCode( yard , false );
	}
	/**
	* fmNode를 팝업을 통해 세팅
	*/
	function setToNode(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		var node=colArray[3];
		var loc=node.substring(0,5);
		var yard=node.substring(5,7);
		formObject.pop_to_loc.value=loc;
		getComboList('pop_to');
		pop_to_yard.SetSelectCode( yard , false );
	}
