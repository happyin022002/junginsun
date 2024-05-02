/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1016.js
 *@FileTitle : ESM_BKG-1016
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.23
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
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
 * @class ESM_BKG-1016 : ESM_BKG-1016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1016() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var formObject = document.form;
    
		try {
			var srcName = window.event.srcElement.getAttribute("name");			 
			switch(srcName) {
			 
			case "btn_Close":				 
				var obj = new Object(); 						 
				obj.nm = formObject.frm_pck_desc.value;								 
				window.returnValue = obj;
				self.close();
				break;  
			 
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
}
/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;	
	    fc_chk_byte();
	    axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		//axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {  
		switch(sAction) {
		case IBSAVE:  
			break;
		}
	}
	/**
	 * 입력한 글자수 체크
	 * @param aro_name
	 * @param ari_max
	 * @return
	 */
	function fc_chk_byte()
	{
		   var f = document.form;		  
		   var comentLength = 0;
		   var tempvalue = "";
		   var cvalue = "";
		   comentLength = f.frm_pck_desc.value.length;
		   var jj = 0; 
		   for( i = 0; i < comentLength; i++) {			 			
		     var retCode = f.frm_pck_desc.value.charCodeAt(i);
		     var retChar = f.frm_pck_desc.value.substring(i,i+1).toUpperCase();
		     if(retCode == 13)
		     {		    	 
		    	 jj = 0;
		    	 continue; 
		     }		        
		     else
		     {		    	 
		    	 jj++
		     }
		     if ((retChar < "0" || retChar > "9") && (retChar < "A" || retChar > "Z") && ((retCode > 255) || (retCode < 0))) { // 한글인경우
		      tempvalue = f.frm_pck_desc.value.substring(i,i+1);
		      cvalue += tempvalue;
		      if(jj != 0 && jj %15 == 0)
		      {			    	  
		    	  cvalue += "\r\n";
		      }
		      } else { // 한글이 아닌경우
		       tempvalue = f.frm_pck_desc.value.substring(i,i+1);
		       cvalue += tempvalue;
		       if(jj != 0 && jj %30 == 0)
		       {				    	  
		    	   cvalue += "\r\n";
		       }
		     } 		   		     
		   }		   
		    
		   tempvalue = f.frm_pck_desc.value.substring(i,i+1);
	       cvalue += tempvalue;
		   f.frm_pck_desc.value = cvalue;		   
	}