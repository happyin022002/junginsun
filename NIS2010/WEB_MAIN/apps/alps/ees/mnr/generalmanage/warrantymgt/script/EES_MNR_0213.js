/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0213.js
*@FileTitle : Warranty Alert_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신 
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
     * @class ess_mnr_0213 : ess_mnr_0213 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0213() {
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
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn1_Retrieve": 
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					case "btn1_New": 
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break; 	
					case "btn1_OK":
						self.close();
					break;	
					case "btn1_Close":
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }   
     
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            initSheet(sheetObjects[i],i + 1); 
        }       
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    } 

		
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) { 
            case "sheet1":
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			}  		  
			break;  		
        }	
    }	
	
 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){ 
					formObj.f_cmd.value = SEARCH;   
					var sXml = sheetObj.GetSearchXml("EES_MNR_0213GS.do","",FormQueryString(formObj),true);	
					var arrResult = MnrXmlToArray(sXml); 
							 		                 
					if(arrResult != null){     
						formObj.fm_warr_dt.value = "Fm " +  arrResult[0][5];		 			 							  					  	  	   	
						formObj.to_warr_dt.value = "To " +  arrResult[0][0]; 		 			 							  					  	  	   	
						formObj.eq_mkr_nm.value = arrResult[0][2];   		 			 							  					  	  	   	
						formObj.eq_mdl_nm.value = arrResult[0][4];     		 			 							  					  	  	   	
						formObj.warr_rmk.value = arrResult[0][3];            		 			 							  					  	  	   	
					} else {     
						self.close();  
					} 	 	   
					//0 to_warr_dt|1 mnr_disp_sel_flg|2 eq_mkr_nm|3 warr_rmk|4 eq_mdl_nm|5 fm_warr_dt|6 to_ser_no|7 pagerows|8 ibflag|9 cre_dt|10 fm_ser_no|11 upd_usr_id|12 eq_knd_cd|13 lot_eq_pfx_cd|14 upd_dt|15 eq_tpsz_cd|16 cre_usr_id
				}    
				break;  
				 	
			case IBCLEAR:      //초기화    
				break;

        }     
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */         
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){      
			if(sAction==IBSEARCH) {        
				if (!ComChkValid(formObj)) return false;        
			} 	 	
        }       	
        return true; 
    }

/* 개발자 작업  끝 */