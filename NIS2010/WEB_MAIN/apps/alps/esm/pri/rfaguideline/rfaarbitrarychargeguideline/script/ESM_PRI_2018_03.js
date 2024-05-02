/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2018_03.js
*@FileTitle : RFA Guideline Inquiry - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.12 김재연
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
     * @class ESM_PRI_2018_03 : ESM_PRI_2018_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2018_03() {
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
    var enableFlag = true;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
            switch(srcName) {

				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        pageOnLoadFinish();
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function initSheet(sheetObj,sheetNo) {
    	 
        var cnt = 0;
        var sheetID = sheetObj.id;
        
        switch(sheetID) {
        
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
					style.height = 330;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = "Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton <=)|Weight\n(<Ton )|Base Port|Per|Cargo Type|Cur.|Rate||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false); 
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDataSeq,	30,	daCenter,	false,  "Seq");
					InitDataProperty(0, cnt++, dtPopupEdit, 60,	daCenter,  	false,  "rout_pnt_loc_def_cd",  false);
    				InitDataProperty(0, cnt++, dtData,    	130,daLeft,	 	false,  "loc_des",  			false);
    				InitDataProperty(0, cnt++, dtCombo,     90,	daCenter,  	false,  "prc_trsp_mod_cd",    	false);
    				InitDataProperty(0, cnt++, dtCombo,     70,	daCenter,  	false,  "rcv_de_term_cd",       false);
    				InitDataProperty(0, cnt++, dtData,      80,	daCenter,  	false,  "min_cgo_wgt",    	 	false,  "", dfNullFloat,	2);
					InitDataProperty(0, cnt++, dtData,      80,	daCenter,  	false,	"max_cgo_wgt",      	false,  "", dfNullFloat,	2);
    				InitDataProperty(0, cnt++, dtPopupEdit, 80,	daCenter,  	false,  "bse_port_def_cd",     	false);
					InitDataProperty(0, cnt++, dtCombo,  	70,	daCenter,  	false,  "rat_ut_cd",      		false);
    				InitDataProperty(0, cnt++, dtCombo,     90,	daCenter,  	false,  "prc_cgo_tp_cd",     	false);
    				InitDataProperty(0, cnt++, dtCombo,     70,	daCenter,  	false,	"curr_cd",      		false);
					InitDataProperty(0, cnt++, dtData,      80,	daRight,  	false,  "frt_rt_amt",         	false,  "", dfFloat, 		2);
					
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,	false,	"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,  	false,	"gline_seq");
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,  	false,	"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,  	false,	"arb_seq");
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,  	false,	"rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 	30,	daCenter,  	false,	"bse_port_tp_cd");
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				AutoRowHeight = false;
    				WaitImageVisible = false;
				}
				break;
				
	            case "sheet2":
	            	with (sheetObj) {
	                    
	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                    InitRowInfo( 1, 1, 3, 100);

	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(1, 0, 0, true);

	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, "", true);

	                }
					break;
        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
        	case IBSEARCH:      //조회
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
              	}
	        	formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_2018_03GS.do", FormQueryString(formObj));
				ComOpenWait(false);
           		break;
        	
        	case IBSEARCH_ASYNC01: // radio button select
	 			//var firstCheck = false;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2018_03GS.do" , FormQueryString(formObj));
			
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				var obj = document.form;
				
				if (parseInt(arrData[0][1]) > 0) {
					formObj.org_dest_tp_cd[0].checked = true;
				} else if(parseInt(arrData[1][1]) > 0) {
					formObj.org_dest_tp_cd[1].checked = true;
				}
				break;
			
        	case IBSEARCH_ASYNC02: // Font Style
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2018_03GS.do" , FormQueryString(formObj));
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
				} else {
					document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
				}
				
				if(parseInt(arrData[1][1]) > 0) {
					document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
				} else {
					document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
				}
				break;		
				
        	case IBSEARCH_ASYNC03: //
				formObj.f_cmd.value = SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
				
        	case IBDOWNEXCEL:      //download excel
				//sheetObj.Down2Excel(-1);
        		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Seq");
				break;

        }
    }
    
    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.10.12
	 */
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "-";
 	
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */
    function obj_click(){
		var formObject = document.form;
		
		if (event.srcElement.name == "org_dest_tp_cd") {
     		doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	}
    
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
  			var formObj = document.form;
  			var orgDestTpCd = getOrgDestTpCd();
  			var rCnt = sheetObj.RowCount;

 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
    
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
     	parent.loadTabPage();
    }
     
    /**
     * org_dest_tp_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.10.12
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}

	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */ 		 
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		
		sheetObjects[0].RemoveAll();
	}
	
	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 
     * @version 2009.10.12
     */ 	 
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;

		if (enableFlag) {
			//toggleButtons("INIT");
		} else {
			//toggleButtons("READONLY");
		}		
	}
    
	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sGlineSeq 필수 gline_seq 값
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */ 		    	
	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject = document.form;

		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			
			if (enableFlag) {
				//toggleButtons("INIT");
			} else {
				//toggleButtons("READONLY");
			}
			
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
 	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.10.12
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	  		case IBSEARCH: // 조회			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;
		  	
	        case IBDOWNEXCEL: // 엑셀조회
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	            break;				
    	}
    	return true;
    }    	     

	/* 개발자 작업  끝 */