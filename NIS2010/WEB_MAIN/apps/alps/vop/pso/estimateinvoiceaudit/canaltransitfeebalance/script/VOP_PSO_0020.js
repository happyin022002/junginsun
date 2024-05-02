/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0020.js
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
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
     * @class vop_pso_0020 : vop_pso_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0020() {
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
    var tabObjects = new Array();
    var tabClicks  = new Array(3);//해당 탭이 클릭되 었는가 셋팅.
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

	        switch(srcName) {
	
		          case "btn_retrieve":
		        	  doActionIBSheet(sheetObject1,formObject,IBSEARCH,"");
								break;
		
		          case "btn_DownExcel":
		            	sheetObject1.SpeedDown2Excel(-1);
								break;
		
		          case "btn_confirm":
						if(!ComShowCodeConfirm("PSO00041", "confirm")){
							return;
						}
		        	  doActionIBSheet(sheetObject1,formObject,IBSAVE, "C");			
								break;
		
		          case "btn_reject":
						if(!ComShowCodeConfirm("PSO00041", "reject")){
							return;
						}
		        	  doActionIBSheet(sheetObject1,formObject,IBSAVE, "R");
								break; 
								
		          case "btn_close":
		        	  self.close();
		        	  break;
	        }// end switch
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        //for(i=0;i<sheetObjects.length;i++){
        		//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        //}
        //최초 SUM정보 쿼리 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        //alert(1);
      //Axon 이벤트 처리1. 이벤트catch
       // axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, "rdoCity"); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
       // axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
       // axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

      var cnt = 0;
			var sheetid = sheetObj.id;
      switch(sheetid) {

				case "t1sheet1":
					with (sheetObj) {
							// 높이 설정
							style.height = 310;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = false;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(2, 1, 3, 100);

							var HeadTitle1 = "CHK|Seq.|ITEM|Amount|Amount|Remark(s)|DY|SN|";
							var HeadTitle2 = "CHK|Seq.|ITEM|Debit|Credit|Remark(s)|DY|SN|";							
							
							var headCount = ComCountHeadTitle(HeadTitle1); 
							

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							InitHeadRow(1, HeadTitle2, true);

							var prefix = "t1sheet1_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
//    							InitDataProperty(0, cnt++ , dtStatus,		30,		daCenter,	true,	prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtDataSeq,		60,		daCenter,	true,	prefix+"seq");
							InitDataProperty(0, cnt++ , dtData,		320,	daLeft,	true,		prefix+"item",			false,		"",	dfNone,				0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		160,	daRight,	true,		prefix+"amount_debit",		false,		"",	dfNullFloat,	2,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		160,	daRight,	true,		prefix+"amount_create",		false,		"",	dfNullFloat,	2,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		prefix+"diff_rmk",		false,		"",	dfNone,				0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"rev_yrmon");
							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"vndr_seq");
							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"hidden");

							CountPosition  = 0;
							
							ShowMsgMode = false; 
						}
						break;

				case "t2sheet1":
					with (sheetObj) {
							// 높이 설정
							style.height = 340;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = false;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);

							var HeadTitle1 = "|Seq.|Date|VVD Code|Amount";						
							
							var headCount = ComCountHeadTitle(HeadTitle1); 
							

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							InitHeadRow(1, HeadTitle2, true);
							var prefix = "t2sheet1_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,		"Seq");
							InitDataProperty(0, cnt++ , dtData,		270,	daCenter,	true,		prefix+"rev_yrmon",			false,		"",	dfDateYmd,		0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		270,	daCenter,	true,		prefix+"vvd",			false,		"",	dfNone,				0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		270,	daRight,	true,		prefix+"amount",			false,		"",	dfNullFloat,	2,		true,		true);
                                                        

						}
						break;
						
				case "t3sheet1":
					with (sheetObj) {
							// 높이 설정
							style.height = 340;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msHeaderOnly;

							//전체Edit 허용 여부 [선택, Default false]
							Editable = false;

							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);

							var HeadTitle1 = "|Seq.|Date|VVD Code|Amount";
							
							var headCount = ComCountHeadTitle(HeadTitle1); 
							

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							InitHeadRow(1, HeadTitle2, true);

							var prefix = "t3sheet1_";
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtDataSeq,		70,		daCenter,	true,		"Seq");
							InitDataProperty(0, cnt++ , dtData,		270,	daCenter,	true,		prefix+"rev_yrmon",			false,		"",	dfDateYmd,		0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		270,	daCenter,	true,		prefix+"vvd",			false,		"",	dfNone,				0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,		270,	daRight,	true,		prefix+"amount",			false,		"",	dfNullFloat,	2,		true,		true);
                                                       
								
						}
						break;
						
						
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, flag) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch(sAction) {
        case IBSEARCH:      //조회
	       	if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				if (sheetObj.id == "t1sheet1") {
					formObj.opflag.value = "S";
					sheetObj.DoSearch("VOP_PSO_0020GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam("t1sheet1_"));
					sheetObj.CellFont("FontBold", 7, 2) = true;
					sheetObj.CellFont("FontBold", 7, 3) = true;
					sheetObj.CellFont("FontBold", 7, 4) = true;
					// Primary Key 값을 무조건 셋팅
					sheetObj.CellValue2(15, 6) = formObj.rev_yrmon.value;
					sheetObj.CellValue2(15, 7) = formObj.vndr_seq.value;
				} else if (sheetObj.id == "t2sheet1") {
					formObj.opflag.value = "B";
					formObj.pso_bztp_cd.value = 5;
					sheetObj.DoSearch("VOP_PSO_0020GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam("t2sheet1_"));
				} else if (sheetObj.id == "t3sheet1") {
					formObj.opflag.value = "C";
					formObj.pso_bztp_cd.value = 6;
					sheetObj.DoSearch("VOP_PSO_0020GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam("t3sheet1_"));
				}
				ComOpenWait(false);
	       	}
	        break;
		case IBSAVE:        //Confirm저장
            if (!validateForm(sheetObj, formObj, sAction)) {
            	return false;
			}
			if (flag === "C") {//Confirm ... 의 경우
				sheetObj.ShowMsgMode = true;
//				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				// SAVE를 위해 강제로 INS플라그로 설정.
				sheetObj.CellValue(2, "t1sheet1_hidden") = "UPDATE";
				sheetObj.DoSave("VOP_PSO_0020GS.do", FormQueryString(formObj) + "&"
						+ ComGetPrefixParam("t1sheet1_"));
//				ComOpenWait(false);
				this.close();
				var opener = window.dialogArguments;
				opener.setAdvPyStatus("A", formObj.row.value, formObj.col.value);
			} else if (flag === "R") {//Reject의 경우
				sheetObj.ShowMsgMode = true;
//				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				// SAVE를 위해 강제로 INS플라그로 설정.
				sheetObj.CellValue(2, "t1sheet1_hidden") = "UPDATE";
				sheetObj.DoSave("VOP_PSO_0020GS.do", FormQueryString(formObj) + "&"
						+ ComGetPrefixParam("t1sheet1_"));
//				ComOpenWait(false);
				this.close();
				var opener = window.dialogArguments;
				opener.setAdvPyStatus("R", formObj.row.value, formObj.col.value);
			}
			break;
		}
    }




    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    tabClicks[cnt]=false;
                    InsertTab( cnt++ , "(A)STATEMENT OF BALANCE" , -1 );
                    tabClicks[cnt]=false;
                    InsertTab( cnt++ , "(B)DETAILS OF REMITTANCE" , -1 );
                    tabClicks[cnt]=false;
                    InsertTab( cnt++ , "(C)DETAILS OF DISBURSEMENT" , -1 );

                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {


        var objs = document.all.item("tabLayer");

	    	objs[nItem].style.display = "Inline";
	    	objs[beforetab].style.display = "none";


	    	//--------------- 요기가 중요 --------------------------//
	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab= nItem;
	    	
//    	    	alert('nItem:='+nItem);
//    	    	alert(tabClicks[nItem]);
	    	if( (nItem === 1 || nItem === 2) && tabClicks[nItem]==false )
	    		doActionIBSheet(sheetObjects[nItem],document.form, IBSEARCH, "");

	    	tabClicks[nItem] = true;
	    		

    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }

        return true;
    }

    /**
     * amount_debit과 amount_create의 Other항목이 변경된 경우 합계데이터를 재계산한다.
     * @return
     */
    function t1sheet1_OnAfterEdit(obj,row,col){
    	return;
//        	if(col == 3 || col == 4)//amount_debit total항목 변경
//        	{
//        		if(obj.CellValue(row,col)==0) {
//        			obj.CellValue2(row,col) = "";
//        			retrun;
//        		}
//        		//obj.CellValue2(14,col) = obj.ComputeSum(col, 2, 13);
//        		//alert('remove!!!');
//        		//obj.CellValue2(15,4)   = obj.ComputeSum("|4| - |3|", 14, 14);
//
//        	}
    }


    //Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
	}

    function obj_activate(){
    	ComClearSeparator(event.srcElement);
    }

    function obj_keypress(){
  	    obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	
  	    switch(obj.dataformat) {
  	        case "ymd":
  	        case "ym":
  	        case "hms":
  	        case "hm":
  	        case "jumin":
  	        case "saupja":
  	            ComKeyOnlyNumber(obj);
  	            break;
  	        case "int":
  	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
  	            else ComKeyOnlyNumber(obj);
  	            break;
  	        case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;
  	        case "eng":
  	            ComKeyOnlyAlphabet(); break;
  	        case "engup":
  	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
  	            else ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "engdn":
  	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
  	            else ComKeyOnlyAlphabet('lower');
  	            break;
  	    }
    }
    function changeDisplayType(sType) {
  		switch(sType) {
  			case "year":
  				ComSetObjValue(sltFormat, "yyyy");
  				break;
  			case "month":
  				ComSetObjValue(sltFormat, "yyyy-MM");
  				break;
  			case "date":
  			case "week-end":
  				ComSetObjValue(sltFormat, "yyyy-MM-dd");
  				break;
  				
  		}
  	}
	/* 개발자 작업  끝 */