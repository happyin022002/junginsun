/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0101.js
*@FileTitle : Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 김종옥
*@LastVersion : 1.0 
* 2013.09.12 
* 1.0 최초 생성 
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
     * @class ESD_EAS_0101 : ESD_EAS_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0101() {
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

	var comboObjects = new Array();
	var comboCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	 
    	var sheetObject1 = sheetObjects[0];
 
    	var srcObj = window.event.srcElement;
    	/*******************************************************/
        var formObject = document.form;
        var rdObject = rdObjects[0];

    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_print":
					rdObject.PrintDialog();
					break;								
					
				case "btn_fax":
					ComSetObjValue(formObject.send_flg, "F");
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
					
				case "btn_email":
					ComSetObjValue(formObject.send_flg, "E");
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;	
					
				case "btn_close":
					window.close();
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
    function loadPage(){
		var formObj = document.form;
    	var opener = window.dialogArguments;

    	for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
    	
		ComSetObjValue(formObj.dod_inv_no, opener.form.in_dod_inv_no.value);
		ComSetObjValue(formObj.cntc_pnt_nm, opener.form.cntc_pnt_nm.value);
		ComSetObjValue(formObj.cntc_pnt_phn_no, opener.form.cntc_pnt_phn_no.value);
		ComSetObjValue(formObj.cntc_pnt_fax_no, opener.form.cntc_pnt_fax_no.value);
		ComSetObjValue(formObj.cntc_pnt_eml, opener.form.cntc_pnt_eml.value);
		
    	//RD
    	rdOpen(rdObjects[0], document.form, sheetObjects[0]);
    }    

    function rdOpen(rdObject,formObj,sheetObj){
    	var Rdviewer = rdObject ;

        Rdviewer.AutoAdjust = true;
        Rdviewer.HideStatusbar();
        Rdviewer.ViewShowMode(0);
                
        Rdviewer.SetPageLineColor(255,255,255);         
    	
    	var path = formObj.mrd.value;		//mrd_path
    	var rd_nm = "";
    
    	// 광양의 경우 Report를 분리
    	if (formObj.dod_inv_no.value.substr(0,2) == "KA" ) {
    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1003.mrd";
    		rd_nm = "ESD_EAS_1003.mrd";
    	} else if (formObj.dod_inv_no.value.substr(0,2) == "IN" ){                                                                                  
    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1001.mrd";  
    		rd_nm = "ESD_EAS_1001.mrd";
    	} else {
    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
    		rd_nm = "ESD_EAS_1004.mrd";
    	}
    	
    	ComSetObjValue(formObj.mrd, path);
    	ComSetObjValue(formObj.rd_name, rd_nm);
   	
     	
    	//MASTER DATA 조회
    	ComSetObjValue(formObj.f_cmd, SEARCH01);	

		//RD 호출
		var rdParm = "/rv dod_inv_no[" + ComGetObjValue(formObj.dod_inv_no) +"]";
		
		ComSetObjValue(formObj.rd_parm, rdParm);
		//Rdviewer.FileOpen(RD_path+path, rdParm);
		
		// 임시로 RD_path 경로를 로칼로 변경함- 반영시 주석처리
		//RD_path = "http://localhost:7002/hanjin/"
		
		Rdviewer.FileOpen(RD_path+path, RDServer + rdParm);
		
	
		//Rdviewer.DisableToolbar (0);
		Rdviewer.DisableToolbar (13);
		Rdviewer.DisableToolbar (14);
		Rdviewer.DisableToolbar (15);
		Rdviewer.DisableToolbar (16);
		Rdviewer.DisableToolbar (17);
        
    }    
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
	        case 1:
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 102;
		            // 전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 2, 1, 2, 100);
		
		            var HeadTitle  = "|";
                    var headCount = ComCountHeadTitle(HeadTitle);
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);

					InitDataProperty(0, cnt++ , dtHiddenStatus, 45,		daCenter,	false,	"ibflag");					
		            InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"dod_inv_no",		false,		"",			dfNone,			0,		false,		true);
		
					CountPosition = 0;
		        }
		        break;

        }
    }    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBINSERT:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("ESD_EAS_0101GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						ComShowCodeMessage("EAS90041");
					}
					else {
						ComShowCodeMessage("EAS90042");
					}
				}
			break;

        }
    }
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			
			case IBINSERT:
				with(formObj){
					//FAX 입력여부 확인
					if(formObj.send_flg.value == "F" && cntc_pnt_fax_no.value == "") {
						ComShowCodeMessage("EAS90043");
						cntc_pnt_fax_no.focus();
						return false;
					}
					//EMAIL 입력여부 확인
					if(formObj.send_flg.value =="E" && cntc_pnt_eml.value == "" ) {
						ComShowCodeMessage("EAS90043");
						cntc_pnt_eml.focus();
						return false;
					}
				}
			break;
    	}
		
		return true;
	}	
    
