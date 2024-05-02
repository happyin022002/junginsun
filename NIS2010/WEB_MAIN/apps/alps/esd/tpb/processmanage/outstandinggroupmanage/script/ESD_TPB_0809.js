/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0809.js
*@FileTitle : 3rd Party Target Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-08
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-08 Sun, CHOI 1.1 ALPS Migration
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
     * @class ESD_TPB_0809 : ESD_TPB_0809 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0809() {
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
	
	var trdPartyObj = window.dialogArguments;
	var s_div_cd = trdPartyObj.divCd;
	var s_trd_value = trdPartyObj.trdVal;
	
    /**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}


	function loadPage() {
		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
	}


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
			
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			with(document.form) {
				switch(srcName) {
					case "btn_3rdParty":
						get3rdParty( document.all.s_vndr_cust_div_cd.value );
						break;
					case "btn_3rdParty_v":
						get3rdParty( "SP" );
						break;
					case "btn_close":
					    window.close();
					    break;
					case "btn_ok":
						trdPartyObj.divCd = document.all.s_vndr_cust_div_cd.value;
						trdPartyObj.trdVal = document.all.s_trd_party_val.value;
						window.returnValue = trdPartyObj;
						window.close();
						break;
				} // end switch
			}// end with
		}catch(e) {			

		}
	}
	/* 개발자 작업  끝 */