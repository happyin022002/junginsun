/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6029.js
*@FileTitle : SM,OP Summary-Multi Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.08 송민석
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
     * @class ESM_PRI_6029 : ESM_PRI_6029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6029() {
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

         /*******************************************************/
         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");                               
 			switch(srcName) {
 				case "btn2_Retrieve":
 					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                    break; 
 				case "btn1_OK":
 					buttonOkClick();
                    break; 
 				case "btn1_Close":
 					self.close();
                    break; 
                    
 				case "btn_MoveLeft":
 					moveSheetRows(sheetObjects[1],sheetObjects[0] );
                    break; 
                    
 				case "btn_MoveRight":
 					moveSheetRows(sheetObjects[0],sheetObjects[1]);
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
         
         initControl();
         initParams();
         // 화면이 열릴때는 이미 이전에 조회했던 내용이 있다면 오른쪽 sheet에 
         // 그 내용을 채워줘야한다.
         doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
         document.form.cust_cnt_cd.focus();
     }
      function initParams(){
	   		var args = window.dialogArguments
	 		var arrParams = args.Params;
	  		document.form.cust_list.value =arrParams["cust_list"]
      }
      /** 
      * document에서 일어나는 event들의 listener를 정의 한다.. <BR>
      * 
      *
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * 
      * @return 없음
      */     
  	function initControl() {
  		//** Date 구분자 **/
  		DATE_SEPARATOR = "/";
  	
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerFormat('keypress', 	'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
  	}
 
    /**  
     * 화면에서 Key가 눌렸을경우의 이벤트처리
     *  
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * 
     * @return 없음
     */  
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
				
			case "engup":
		        //영문만입력하기
	            ComKeyOnlyAlphabet("uppernum");
	            break;
	            
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		}
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
                     style.height = 230;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Customer Code|Customer Name|S.OFC";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			95,   	daLeft,  	true,		"cust_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			200,   	daLeft,  	true,		"cust_lgl_eng_nm",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daLeft,  	true,		"ofc_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					
 					CountPosition = 0;
                }
                break;

 			case "sheet2":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 230;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Customer Code|Customer Name|S.OFC";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,			40,   	daCenter,  	true,		"sel_chk",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtSeq,				40,   	daCenter,  	true,		"seq",   		false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			95,   	daLeft,  	true,		"cust_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			150,   	daLeft,  	true,		"cust_lgl_eng_nm",   			false,          "",      dfNone,      		0,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			0,   	daLeft,  	true,		"ofc_cd",   			false,          "",      dfNone,      		0,			true,       true);
 					
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

		        
		        if( !validateForm(sheetObj, formObj, sAction) ) return;
 				ComOpenWait(true);
 				formObj.f_cmd.value = SEARCH01;
	   		    sheetObj.DoSearch("ESM_PRI_6029GS.do", FormQueryString(formObj) );
	   		    ComOpenWait(false);
                break;
 			case IBSEARCH_ASYNC01:      //조회
 				ComOpenWait(true);
		        formObj.f_cmd.value = SEARCH02;
	   		    sheetObj.DoSearch("ESM_PRI_6029GS.do", FormQueryString(formObj) );
	   		    ComOpenWait(false);
	   		    break;
 
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
  		with (formObj) {
  			if(ComIsNull(formObj.cust_cnt_cd) && ComIsNull(formObj.cust_seq) &&ComIsNull(formObj.cust_lgl_eng_nm)) {
  				ComShowCodeMessage("PRI04005","Customer Code","Customer Name");
  				return false;
  			}
  			
  			if(!ComIsNull(formObj.cust_cnt_cd) && ComGetLenByByte(formObj.cust_cnt_cd) < 2) {
  				ComShowCodeMessage("PRI04003","Country code","2");
  				return false;
  			}
  			
  			if(!ComIsNull(formObj.cust_lgl_eng_nm) && ComGetLenByByte(formObj.cust_lgl_eng_nm) < 5) {
  				ComShowCodeMessage("PRI04004","Customer Name","5","100");
  				return false;
  			}
  		}
  	
  		return true;
  	}
  	 
      
      /** 
       * sheetObject의 내용중 check가 된 row를 target 쪽으로 move 시킨다.
       * 
       * 
       * <br><b>Example :</b>
       * <pre>
       *        moveSheetRows(sheetObjects[0],sheetObjects[1]);
       * </pre>
       * 
       * @param {object} sheetObj 필수,   sheet Object
       * @param {object} targetSheetObj 필수, target sheet Object
       * @return 없음
       */       
  	function moveSheetRows(sheetObj,targetSheetObj){
  		//ComOpenWait(true);
  		var checkedData = sheetObj.FindCheckedRow("sel_chk");
  		var arrRow = checkedData.split("|");
  		for (var idx=0; idx<arrRow.length-1; idx++){
  			arrRow[idx] -= idx;
  			var insRow = targetSheetObj.DataInsert()
  			targetSheetObj.CellValue2(insRow,"sel_chk") = 0 ;
  			targetSheetObj.CellValue2(insRow,"cust_cd") = sheetObj.CellValue(arrRow[idx],"cust_cd") ;
  			targetSheetObj.CellValue2(insRow,"cust_lgl_eng_nm") = sheetObj.CellValue(arrRow[idx],"cust_lgl_eng_nm") ;
  			targetSheetObj.CellValue2(insRow,"ofc_cd") = sheetObj.CellValue(arrRow[idx],"ofc_cd") ;
  			sheetObj.RowDelete(arrRow[idx],false);
  			
  		}
  		makeCustCdList();
  		//ComOpenWait(false);
  	}
  	

    /** 
     * customer 코드를 ';'로 연결한 string으로 만든다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      makeCustCdList();
	 * </pre>
	 * 
	 * @return 없음
	 */      	
  	function makeCustCdList(){
  		var sheetObj = 	sheetObjects[1];
  		var custCdList = "";
  		var formObj = document.form;
  		for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
  			if(i != sheetObj.HeaderRows){
  				custCdList +=  ";" 
  			}
  			custCdList +=  sheetObj.CellValue(i,"cust_cd");
  		}
  		formObj.cust_list.value = custCdList;
  	}
  	
    /** 
    * customer 명을 ';'로 연결한 string으로 만든다.
	 * <br><b>Example :</b>
	 * <pre>
	 *      custNmList = makeCustNameList();
	 * </pre>
	 * 
	 * @return string, customer name string
	 */    	
  	function makeCustNameList(){
  		var sheetObj = 	sheetObjects[1];
  		var custNmList = "";
  		var formObj = document.form;
  		for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
  			if(i != sheetObj.HeaderRows){
  				custNmList +=  ";" 
  			}
  			custNmList +=  sheetObj.CellValue(i,"cust_lgl_eng_nm");
  		}
  		return custNmList;
  	}
    /** 
     *  OK 버튼에 대한 프로세스 처리<BR>
     *  팝업을 닫기전 return 값을 assign한후 화면을 닫는다.
     * <br><b>Example :</b>
     * <pre>
     *      buttonOkClick();
     * </pre>
     * @return 없음
     */  	
	function buttonOkClick() {
		var rtnObject = new Object(); 		
		rtnObject.custList = document.form.cust_list.value;
		rtnObject.custNameList = makeCustNameList();
		
		window.returnValue = rtnObject;
	    self.close();
	}

	/* 개발자 작업  끝 */