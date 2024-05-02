/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6085.js
*@FileTitle : PRS-Surcharge Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.02 송민석
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
     * @class ESM_PRI_6085 : ESM_PRI_6085 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6085() {
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
 
 var xchgYrMon = "";
 var isReqUsr = false;
 var isAproUsr = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 
 
	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     *
	 * @return 없음
	 */ 
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
 		 var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
                                           
            switch(srcName) {

                 case "btn_Add":
                	 doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                     break; 
                      
                 case "btn_Delete":
                	 doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
 					 break;

                 case "btn_Save":
                	 doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
                     break; 
 				 case "btn_Close":
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
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
      *
   	 * @param  {object}   sheet_obj 필수, sheet Object
   	 * @return 없음
   	 */ 
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;
 			
     }


   	/** 
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
   	 * 
   	 * @return 없음
   	 */ 
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         initParams(document.form);
         loadInitData();
         initButtons();
         changeButtonStatus(sheetObjects[1])
     }
      
 	  /**  
 	   * 팝업이 오픈될때 메인화면으로 부터 받은 초기 파라메터를<BR> 
 	   * 저장해 놓는다.
 	   *  
 	   * <br><b>Example :</b>
 	   * <pre>
 	   *   initParams(formObj)
 	   * </pre>
 	   *
 	   * @param {object} formObj 필수, html document form Object
 	   * @return 없음
 	   */             
      function initParams(formObj){
	   	 var is_req_usr = formObj.is_req_usr.value;
	   	 var is_apro_usr = formObj.is_apro_usr.value;
	   	 if( is_req_usr.toUpperCase() == "TRUE" ){
	   		 isReqUsr = true;
	   	 }
	   	 if( is_apro_usr.toUpperCase() == "TRUE" ){
	   		 isAproUsr = true;
	   	 }
      }   	 
     /**  
      * 화면 loading시 최초 버튼 상태를 설정한다.
      *  
      * <br><b>Example :</b>
      * <pre>
      *   initButtons();
      * </pre>
      * 
      * @return 없음
      */    
     function initButtons(){
    	 enableButton("btn_Retrieve");
    	 disableButton("btn_Save");
    	 //disableButton("btn_Delete");
     }
     /**  
      * 화면 loading시 필요한 최초 데이터를 조회해서<br>
      * 화면에 Setting 해 놓는다.
      *  
      * <br><b>Example :</b>
      * <pre>
      *   loadInitData();
      * </pre>
      * 
      * @return 없음
      */       
     function loadInitData( ){
    	 var formObj = document.form;
    	 initCombo(formObj);
    	 xchgYrMon = getXChgRateFromYrMon();
    	 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
     }
     /**  
     * Combo에서 필요한 코드를 조회해서 Combo에 Set한다.
     * 화면에 Setting 해 놓는다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   initCombo(formObj);
     * </pre>
     * 
     * @param {object} formObj 필수, html document form Object
     * @return 없음
     */         
     function initCombo(formObj){  
    	var scgDtlSheetObj = sheetObjects[1];
   	 	//surcharge scope cd combo
		formObj.f_cmd.value = COMMAND12;
       // WHERE TRF_PFX_CD = @[etc2]
       //                      AND TRF_NO = @[etc3]
		var sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc2="+formObj.trf_pfx_cd.value+"&etc3="+formObj.trf_no.value);
		setIBCombo(scgDtlSheetObj,sXml,"chg_cd",true,0,"","",true);
		
    	 //currency combo
		formObj.f_cmd.value = COMMAND16;
		var sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		setIBCombo(scgDtlSheetObj,sXml,"curr_cd",true,0,"USD");
			
		// per combo
		formObj.f_cmd.value = COMMAND18;
		sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		setIBCombo(scgDtlSheetObj, sXml, "bkg_rat_ut_cd", true, 0);
     }
     

   	/** 
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {String} sheetNo 필수, sheet의 ID
   	 * @return 없음
   	 */ 
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         sheetObj.WaitImageVisible = false;
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 90;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     MultiSelection = false;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Route|Route|Route|Route|R/D Term|Total\nSurcharge|Access Date||";
 					var HeadTitle2 = "|POR|POL|POD|DEL|R/D Term|Total\nSurcharge|Access Date||";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);


                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                    
 					InitDataProperty(0, cnt++ , dtData,				120,   	daCenter,  	true,		"por_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			120,   	daCenter,  	true,		"pol_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			120,   	daCenter,  	true,		"pod_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			120,   	daCenter,  	true,		"del_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			120,   	daCenter,  	true,		"rd_term_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			120,   	daRight,  	true,		"tot_surcharge",   			false,          "",      dfNullFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daCenter,  	true,		"cre_ymd",   			false,          "",      dfDateYmd,      	0,			false,      true);

 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"tri_prop_no",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,      true);

 					CountPosition = 0;
                }
                break;

 			   case "sheet2":      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     MultiSelection = false;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Surcharge\nCode|Per|Cur.|Amount|Amount|Amount|Remark(s)|||adj_flg";
 					var HeadTitle2 = "|Sel.|Seq.|Surcharge\nCode|Per|Cur.|Local|USD|Tariff|Remark(s)|||adj_flg";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);
					
					

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtDummyCheck,		40,   	daCenter,  	true,		"del_chk",   			false,          "",      dfNone,      		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtSeq,    			40,   	daCenter,  	true,		"seq",   			false,          "",      dfNone,      		0,			false,		true);
 					InitDataProperty(0, cnt++ , dtComboEdit,    			80,   	daCenter,  	true,		"chg_cd",   			true,          "",      dfNone,      		0,			false,      true,3);
 					InitDataProperty(0, cnt++ , dtCombo,    			60,   	daCenter,  	true,		"bkg_rat_ut_cd",   			true,          "",      dfNone,      		0,			false,      true,2);
 					InitDataProperty(0, cnt++ , dtCombo,    			80,   	daCenter,  	true,		"curr_cd",   			true,          "",      dfNone,      		0,			false,      true,3);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	true,		"adj_scg_amt",   			true,          "",      dfFloat,      	2,			true,       true,12);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"adj_scg_usd_amt",   			false,          "",      dfFloat,      	2,			false,      false);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"trf_scg_amt",   			false,          "",      dfFloat,      	2,			false,      false);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daCenter,  	true,		"trf_scg_rmk",   			false,          "",      dfNone,      		0,			false,      false);

 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"tri_prop_no",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"amdt_seq",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtHidden,				120,   	daCenter,  	true,		"adj_flg",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataValid(0, "chg_cd", vtEngUpOnly);	// 영문대문자만 입력

 					CountPosition = 0;
                }
                break;
         }
     }


  	/** 
     * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param {object} sheetObj 필수, sheet Object
  	 * @param {object} formObj 필수, html document form Object
  	 * @param {int} sAction 필수, action의 구분
  	 * @return 없음
  	 */    
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 			case IBSEARCH:      //조회
 				ComOpenWait(true);
 				//if(validateForm(sheetObj,formObj,sAction))
	            formObj.f_cmd.value = SEARCH;
 				// ComGetPrefixParam("sheet1_");
	            sXml = sheetObj.GetSearchXml("ESM_PRI_6085GS.do", FormQueryString(formObj) );
				var arrXml = sXml.split("|$$|");
 				if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);	// sheet1. hidden sheet - main 데이터
 				if (arrXml.length > 1 ){
 					// combo code에 없는 내용이 list에 있을경우 이를 combo에 add해준다.
 					var sCode = sheetObjects[1].GetComboInfo(0, "chg_cd", "Code");
 					var sText = sheetObjects[1].GetComboInfo(0, "chg_cd", "Text");
 	 				var arrData = ComPriXml2Array(arrXml[1], "chg_cd|chg_nm");
 	 				if( arrData != null && arrData != undefined){
 		 				for(var i = 0 ; i < arrData.length ; i++){
 		 					if( sCode.indexOf(arrData[i][0]) < 0 ){
 								sCode += "|" + arrData[i][0];
 								sText += "|"+ arrData[i][0]+"\t"+ arrData[i][1];
 								sheetObjects[1].InitDataCombo(0, "chg_cd", sText, sCode);
 		 					}
 		 				}
 	 				} 					
 					
 					sheetObjects[1].LoadSearchXml(arrXml[1]);	// sheet1. hidden sheet - main 데이터
 				
 				}
 				ComOpenWait(false);
                break;

 			case IBSAVE:        //저장
				eventStatus = "IBSAVE";
 				if( !validateForm(sheetObj,document.form,sAction) ){
 					return false;
 				}	
 				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_PRI_6085GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;
 			case IBINSERT:      // 입력
 				var idx = sheetObj.DataInsert(-1);
 				setFormDataToSheet(idx,sheetObj, formObj);
				
				break;
 			case IBDELETE: //삭제
				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
 				deleteRowCheck(sheetObj, "del_chk") ;
 				changeButtonStatus(sheetObj);
				break;
         }
     }

 
     /**  
     * HTML Form에 있는 특정 데이터들을 Sheet의 특정 Cell들에<BR>  
     * SETTING한다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   setFormDataToSheet(idx, sheetObj, formObj)
     * </pre>
     *
     * @param {int} idx 필수, form의 값을 assign하고자 하는 Cell이 있는 row index
     * @param {object} sheetObj 필수, sheet Object
     * @param {object} formObj 필수, html document form Object
     * @return 없음
     */     
     function setFormDataToSheet(idx, sheetObj, formObj){
    	 sheetObj.CellValue(idx, "tri_prop_no") = formObj.tri_prop_no.value;
    	 sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
    	 sheetObj.CellValue(idx, "trf_scg_rmk") = "Inclusive";
    	 sheetObj.CellValue(idx, "adj_flg")  = "Y";
     
     }
     
  	
   	/*

   	 */
   	 
     /**  
   	 * tri_prop_no, amdt_seq 조회 조건을 이용하여<BR>
   	 * Surcharge Detail에 사용된 <BR>
   	 * 환율의 년월을 조회해 return한다.<BR>
      *  
      * <br><b>Example :</b>
      * <pre>
      *   xchgYrMon = getXChgRateFromYrMon();  // 결과 : "200910"
      * </pre>
      *
      * @return string, 환율계산 기준 년월
      */       	 
   	function getXChgRateFromYrMon(){
   		var tmpXchgYrMon = "";
      	var formObj = document.form
		var formParam = "f_cmd="+SEARCHLIST13+"&etc1="+formObj.tri_prop_no.value;
		
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam );
		var arrData = ComXml2ComboString(sXml, "cd", "nm");
		if( arrData != "" ){
			tmpXchgYrMon = arrData[1];
		}
		return tmpXchgYrMon;
   	}   	
   	
   	
   	
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */    
   	function sheet2_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);  
   		if( colname == "curr_cd" || colname == "adj_scg_amt"){
   			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
   			getLocalAmtToUSD(sheetObj,row);
   			changeRemark(sheetObj,row,col);
   			sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_surcharge") = calcTotalValue(sheetObj,"adj_scg_usd_amt");
   		}else if(colname == "chg_cd" ){
			var sCode = sheetObj.GetComboInfo(0, "chg_cd", "Code");
			var sText = sheetObj.GetComboInfo(0, "chg_cd", "Text");
			if (sCode.indexOf(value) < 0) {
				var formObj = document.form;
				formObj.f_cmd.value = COMMAND09;
				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + value);
				var arrData = ComPriXml2Array(sXml, "cd|nm");
				if (arrData != null && arrData.length > 0) {
					sCode += "|" + value;
					sText += "|"+ value+"\t"+ arrData[0][1];
					sheetObj.InitDataCombo(0, "chg_cd", sText, sCode);
					//ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
				} else {
					sheetObj.CellValue2(row, "chg_cd") = "";
				}
			}
   			
   		}
   		changeButtonStatus(sheetObj);
   	}
   	
   	
   
 	/** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {String} ErrMsg 필수, sheet의 결과 메시지
	 * @return 없음
	 */      	
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg)  {
		sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_surcharge") = calcTotalValue(sheetObj,"adj_scg_usd_amt");
	}       	
   	 	
	 
 	/** 
     * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      changeButtonStatus(sheetObjects[0]);
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @return 없음
	 */  	 
   	function changeButtonStatus(sheetObj){
   		var formObj = document.form;
   		
   		if(sheetObj.RowCount > 0 && sheetObj.IsDataModified == true ){
	   		if(formObj.prc_prop_sts_cd.value == "I"   ){
	   	   		if(isReqUsr || isAproUsr ){   			
	   	   			enableButton("btn_Save");
	   	   			enableButton("btn_Add");
	   	   			enableButton("btn_Delete");
	   	   		}else{
	   	   			disableButton("btn_Save");
	   	   			disableButton("btn_Add");
	   	   			disableButton("btn_Delete");
	   	   		}
	   		}else if(formObj.prc_prop_sts_cd.value == "R"){
	   	   		if(isReqUsr ){   			
	   	   			enableButton("btn_Save");
	   	   			enableButton("btn_Add");
	   	   			enableButton("btn_Delete");
	   	   		}else{
	   	   			disableButton("btn_Save");
	   	   			disableButton("btn_Add");
	   	   			disableButton("btn_Delete");
	   	   		}
	   		
	   		}else{
   	   			disableButton("btn_Save");
   	   			disableButton("btn_Add");
   	   			disableButton("btn_Delete");
	   		}
   		}else{
   			if(formObj.prc_prop_sts_cd.value == "I"   &&  (isReqUsr || isAproUsr)){
   				enableButton("btn_Add");
   				enableButton("btn_Delete");
   			}else if(formObj.prc_prop_sts_cd.value == "R"   &&  isReqUsr  ){
   				enableButton("btn_Add");
   				enableButton("btn_Delete");
   			}else{
   				disableButton("btn_Add");
   				disableButton("btn_Delete");
   			}
   			disableButton("btn_Save");
   			
   			
   		}

   	}
   	
    /** 
     * sheet의 surchage 관련 Cell의 값을 변화 시켰을경우<BR>
     * 해당 row의 remark 내용을 변화시킴
     * <br><b>Example :</b>
     * <pre>
     *       changeRemark(sheetObj,row);
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} row 필수, 변경하고자 하는 row index
     * @return 없음
     */           
   	function changeRemark(sheetObj,row){
   		
   		var remark = sheetObj.CellValue(row,"trf_scg_rmk");
   		var adjAmt = sheetObj.CellValue(row,"adj_scg_amt");
   		var trfAmt = sheetObj.CellValue(row,"trf_scg_amt");
   		var adjFlg = sheetObj.CellValue(row,"adj_flg");
   		var status = sheetObj.RowStatus(row);
   		var INCLUSIVE = "Inclusive";
   		var FIXED = "Fixed";
   		var SEPERATOR = ":";
   		var rmkText = "";

		if( adjAmt == 0){
			rmkText = INCLUSIVE;
			adjFlg = "Y";
		}else if( adjAmt == trfAmt){
			if( trfAmt == 0){
				rmkText=INCLUSIVE;
				adjFlg = "Y";
			}else{
				rmkText = "";
				adjFlg = "N";
			}
		}else if( adjAmt != trfAmt){
			rmkText = FIXED;
			adjFlg = "Y";
		}
		if( remark != "" && remark != INCLUSIVE && remark != FIXED){
		
			if( remark.indexOf(FIXED) >= 0 ){
				rmkText = (rmkText != "" ? rmkText+SEPERATOR : "") + remark.substring(FIXED.length+SEPERATOR.length ,remark.length );
			}else if( remark.indexOf(INCLUSIVE)  >= 0 ){
				rmkText = (rmkText != "" ? rmkText+SEPERATOR : "") + remark.substring(INCLUSIVE.length+SEPERATOR.length ,remark.length );
			}else{
				rmkText = rmkText + SEPERATOR + remark;
			}
		}
		sheetObj.CellValue2(row,"trf_scg_rmk") = rmkText;
		sheetObj.CellValue2(row,"adj_flg") = adjFlg;
   		
   	}
 
  	 
     /** 
      * 현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
      * 
      * <br><b>Example :</b>
      * <pre>
      *       getLocalAmtToUSD(sheetObj,row);
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경하고자 하는 row index
      * @return 없음
      */     	 
   	function getLocalAmtToUSD(sheetObj,row){
			//USD이면 DB조회가 필요 없다.
		if(  sheetObj.Cellvalue(row,"curr_cd") == "USD"){
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = sheetObj.Cellvalue(row,"adj_scg_amt")
		}else{
   	    	//USD AMOUNT
 	      	var formObj = document.form
			var formParam = "f_cmd="+COMMAND03+"&etc1="+sheetObj.Cellvalue(row,"curr_cd");
			formParam = formParam + "&etc2="+sheetObj.Cellvalue(row,"adj_scg_amt");
			formParam = formParam + "&etc3="+xchgYrMon;
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam );
			var arrData = ComXml2ComboString(sXml, "cd", "nm");
			//alert(arrData[0]+"/"+arrData[1])
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = arrData[1];
		}   		
   		
   	}
  	 
 	
 
    /** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      if (!validateForm(sheetObj,document.form,sAction)) {
     *          return false;
     *       }
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {object} formObj 필수, html document form Object
   	 * @param {int} sAction 필수, action의 구분
     *
   	 * @return boolean, true: 유효, false: 비유효
   	 */          
     function validateForm(sheetObj, formObj, sAction) {
         switch (sAction) {
         case IBSEARCH:
         break;
         case IBSAVE: // 저장
	         if (sheetObj.IsDataModified == false) {
	             return false;
	         }
         	 var colNames = "tri_prop_no|amdt_seq|chg_cd";
         	 //중복체크
	         var dupRow = sheetObj.ColValueDup(colNames,false); 
	         
	     	 if (dupRow >= 0) {
	     		sheetObj.SelectRow = dupRow;
				ComShowCodeMessage("PRI00302");
				return false;
	     	 }
         break;
         }
         return true;
     }
      
   	 
     /** 
     * sheet의 해당 컬럼의 총합을 계산하는데 ibflag가 I/R/U 인것만 합산한다. 
     * 
     * <br><b>Example :</b>
     * <pre>
     *      amt =  calcTotalValue(sheetObj,"adj_scg_usd_amt"); // 계산된 숫자값
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} col 필수, 변경하고자 하는 column name
     * @return float, 해당 컬럼의 총합
     */     
      function calcTotalValue(sheetObj,col){
    	   var allRows = sheetObj.FindStatusRow("I|R|U");
   	   	   var arAllRows = allRows.split(";");
   	   	   var totalValue = 0.0;
	   	   for (var idx=0; idx<arAllRows.length-1; idx++){ 
	   		   totalValue = totalValue + eval(sheetObj.CellValue(arAllRows[idx],col));
	   	   }
	   	   return totalValue;
      }
      
 	/** 
     * sheet를 이용해 Save를 했을경우 Save 완료후 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {String} ErrMsg 필수, sheet의 결과 메시지
	 * @return 없음
	 */          
      function sheet2_OnSaveEnd(sheetObj, errMsg){
    	  if( errMsg == ""){
    		  window.returnValue="SUCCESS";
    		  self.close();
      	 }
      }
       
	/* 개발자 작업  끝 */