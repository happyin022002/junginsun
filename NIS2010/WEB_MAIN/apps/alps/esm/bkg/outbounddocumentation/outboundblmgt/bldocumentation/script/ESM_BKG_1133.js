/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1133.js
*@FileTitle : Bangladesh Shipment Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.14 조원주
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
     * @class ESM_BKG_1133 : Bangladesh ODCY로부터의 파일을 일정 형식으로 Upload시키는 화면 (Setup 화면에 추가).
     */
    function ESM_BKG_1133() {
    	this.processButtonClick		= processButtonClick;
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
	var tabCnt = 0 ;
	var beforetab = 1;
	var isRetrieved = false;
	
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

				case "btn_close":
					window.close();
				break;
				
				case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
				
				case "btn_upload":
					//mySheet.LoadExcel([Mode], [SheetNo], [FileName], [StartExcelRow], [EndExcelRow], 
                     //       [WorkSheetName], [IsAppend], [bProtect], [ColumnMapping]) 
                    
//                     if(isRetrieved == false){
//  		        		ComShowCodeMessage("BKG00448");
//   		        	}else{
//   		        		sheetObjects[0].LoadExcel(0,1,"",2,-1,"",true, false,"1=>5|2=>6|3=>7|4=>8|5=>9|6=>10|7=>11|8=>13|9=>12" );
//   		        	}
                    	  sheetObjects[0].LoadExcel(0,1,"",2,-1,"",true, false,"1=>5|2=>6|3=>7|4=>8|5=>9|6=>10|7=>11|8=>13|9=>12" );
                      
					break;
				
				case "btn_chk_all":
					sheetObjects[0].CheckAll("Chk") = 1;
				break;
				
				case "btn_uncheckall":

					sheetObjects[0].CheckAll("Chk") = 0;
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					break;
					
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
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
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		
       sheetObjects[0].SetMergeCell(0,10,2,2);
       initControl();
		//
		
    }

    function initControl() {
         //add listener
 		
         axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        
 	}
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 290;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
					//MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle1 = "||Lane|VVD|POL|Booking|CNTR|TP/SZ|Vol.|Seal No|Package|Package|Weight|Measure|Creation|Creation|Creation|cntr_seq";
                    var HeadTitle2 = "||Lane|VVD|POL|Booking|CNTR|TP/SZ|Vol.|Seal No|Package|Package|Weight|Measure|Date|By|Office|cntr_seq";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL, DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   // InitDataProperty(0, cnt++, dtHiddenStatus,   40, 	  daCenter, false,    "radio", 		 false, 	"", 		dfNone, 	0, 		true, true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    	daCenter,  	 	true,  	"ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	   40, 	  daCenter, true,    "Chk", 		 false, 	"", 		dfNone, 	0, 		true, true);
    				//InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "Chk");
    				InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,    "slan_cd", false,    "",        dfEngUpKey,      0,          false,       false, 3);   
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,    "vvd_cd",     false,    "",         dfNone,     0,          false,       false, 9);                                                                                                                                         
					InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,    "pol_cd",  false,    "",         dfNone,    2,          false,       false, 7);      
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,    "bkg_no",     false,    "",         dfEngUpKey,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,    "cntr_no",       false,    "",         dfEngUpKey,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daCenter,  true,    "cntr_tpsz_cd",  false,    "",         dfEngUpKey,    2,          true,       true);  
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "cntr_vol_qty",   false,    "",         dfNone,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         60,    daRight,  true,    "cntr_seal_no",   false,    "",         dfNone,    2,          true,       true);
					InitDataProperty(0, cnt++, dtData,         50,    daRight,  true,    "pck_qty",     false,    "",         dfNone,    2,          true,       true);
					InitDataProperty(0, cnt++, dtData,         40,    daCenter,  true,    "pck_tp_cd",     false,    "",         dfEngUpKey,    2,          true,       true, 2);
					
					InitDataProperty(0, cnt++, dtData,         90,    daRight,  true,    "cntr_wgt",      false,    "",         dfNone,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         80,    daRight,  true,    "meas_qty",      false,    "",         dfNone,    2,          true,       true);
					                                                                                                                                     
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,  false,    "cre_dt",    false,    "",         dfNone,    2,          false,       false);                                                 
					InitDataProperty(0, cnt++, dtData,         60,    daCenter,  false,    "cre_usr_id",    false,    "",         dfNone,    2,          false,       false);      
					InitDataProperty(0, cnt++, dtData,         40,    daCenter,  false,    "ofc_cd",    false,    "",         dfNone,    2,          false,       false);      
					InitDataProperty(0, cnt++, dtHidden,         40,    daCenter,  false,    "cntr_seq",    false,    "",         dfNone,    2,          false,       false);		
					
					InitDataValid(0,    "pck_tp_cd",  vtEngUpOnly);
					InitDataValid(0,    "cntr_vol_qty",  vtNumericOther, "1234567890.");
					InitDataValid(0,    "cntr_wgt",  vtNumericOther, "1234567890.");
					InitDataValid(0,    "meas_qty",  vtNumericOther, "1234567890.");   
					InitDataValid(0,    "pck_qty",  vtNumericOther, "1234567890."); 
					


			   }
                break;


        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
               
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_1133GS.do", FormQueryString(formObj));
                    sheetObj.LoadSearchXml(rXml, false);
					
				}
			break;
			
			case IBDELETE:
				
				ComRowHideDelete(sheetObj, "Chk", true);
				
				//alert(sheetObjects[0].CellValue2(i,"ibflag"));
				//ComRowDeleteComplete(sheetObj, "Chk", 1);
				break;
				
			case IBSAVE:      //조회
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return; // Are you sure to save the changes?
		
				formObj.f_cmd.value = MULTI;
    
            	sheetObj.DoSave("ESM_BKG_1133GS.do", FormQueryString(formObj));
                
            	/* Save 이후 VVD 가 있는 경우에만 자동 조회 함 */
                if((formObj.vvd_cd.value == "" || formObj.vvd_cd.value == null) &&(formObj.pol_cd.value == "" || formObj.pol_cd.value == null)){
                	
                }else{
                	doActionIBSheet(sheetObj, document.form, IBSEARCH);
                }
                
        		// 3.저장후 결과처리
//        		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
//        		if ( State == "S" ) {
//        			sheetObj.LoadSaveXml(sXml);
//        			ComShowMessage(ComGetMsg("BKG06071"));
//        		}else{
//        			fnExceptionMessage(sXml);
//        		}
				
		break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		 
//		 if(formObj.vvd_cd.value == "" || formObj.vvd_cd.value == null){
// 			ComShowCodeMessage("BKG00115");
// 			return false;
// 		}
    	 
//    	 if(formObj.pol_cd.value == "" || formObj.pol_cd.value == null){
//  			ComShowCodeMessage("BKG00209");
//  			return false;
//  		}
        return true;
    }
	
	function calculateCntrQty(){
		var sheetObj = sheetObjects[0];
		for(ir=sheetObj.HeaderRows ;ir<=sheetObj.LastRow ;ir++ ){
			var tpSz = sheetObj.CellValue(ir, "cntr_tpsz_cd");
			var cate = sheetObj.CellValue(ir, "category");
			var varFlg = false;
			//alert(ir + " -> " + tpSz + " : " + cate);
			if(cate == "BKG"){
				sheetObj.SetMergeCell(ir, 0, 3, 1);
			}
			if(cate == "CNTR"){
				if(!opener) opener = window.dialogArguments; 
				if(opener != undefined){
					var cntrQtyArr = opener.getCntrQtyByType(tpSz);
					if(cntrQtyArr != null){
						for(ic=2 ;ic<=sheetObj.LastCol ;ic++){
							sheetObj.CellValue2(ir, ic) = (cntrQtyArr[ic] == 0) ? '' : cntrQtyArr[ic];
						}
					}
				}
			}
			if(cate == "Difference"){
				for(ic=2 ;ic<=sheetObj.LastCol ;ic++){
					var p1 = ComIsEmpty(sheetObj.CellValue(ir-2, ic)) ? 0 : parseFloat(sheetObj.CellValue(ir-2, ic));
					var p2 = ComIsEmpty(sheetObj.CellValue(ir-1, ic)) ? 0 : parseFloat(sheetObj.CellValue(ir-1, ic));
					//alert(sheetObj.CellValue(ir-2, ic) +" - "+ sheetObj.CellValue(ir-1, ic) + " = " + (p1 - p2));
					//sheetObj.CellValue2(ir, ic) = ((p1-p2)==0) ? '' : (p1-p2);
					sheetObj.CellValue2(ir, ic) = (ComIsEmpty(sheetObj.CellValue(ir-2, ic)) && ComIsEmpty(sheetObj.CellValue(ir-1, ic))) ? '' : (p1-p2);
					
					if((p1-p2) != 0){
						varFlg = true;
						sheetObj.CellFont("FontBold", ir, ic) = true;
						sheetObj.CellFontColor(ir, ic) = sheetObj.RgbColor(255, 0, 0);
					}
				}
				//if(varFlg){
				//	sheetObj.RowBackColor(ir-2) = sheetObj.RgbColor(255, 204, 255);
				//	sheetObj.RowBackColor(ir-1) = sheetObj.RgbColor(255, 204, 255);
				//	sheetObj.RowBackColor(ir)   = sheetObj.RgbColor(255, 204, 255);
				//}
			}
		}
		
	}
		
		  /**
	     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
	     * 
	     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
	     * @param {string}  ErrMsg   선택,에러 메시지
	     * @return 없슴
	     */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	    	var formObject = document.form;
	    	//var prefix = sheetObj.id + "_";

	    	// 조회조건 저장
	    	//sOldLocCd  = formObject.loc_cd.value;
	   		
	    	isRetrieved = true;
	    }
	    
	    
	 	function form1_keypress(){
			
			switch(event.srcElement.dataformat){
				
				case "int":		//숫자
					ComKeyOnlyNumber(event.srcElement); 
				break;
				case "float":	//숫자+"."	            
					ComKeyOnlyNumber(event.srcElement, "."); 
				break;	    
				case "engup":
					//영문대문자
					ComKeyOnlyAlphabet("upper");
				break;
				case "engupnum":
					//숫자+"영문대분자"입력하기
					ComKeyOnlyAlphabet("uppernum");
				break;
				
				  case "engnum"://숫자+"영문대소"입력하기
	      	  	  ComKeyOnlyAlphabet('num');
				  break;
				
				case "engupspecial": // 영문대문자 + _ + -
	              ComKeyOnlyAlphabet('engnum', "95");
	              break;
	              
				case "engupnumspc":
					//영문대문자 + 숫자 + 스페이스
					//ComKeyOnlyAlphabet("uppernum", "32|45|95");
					var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
					if(keyValue >= 97 && keyValue <= 122){
	                	event.keyCode = keyValue + 65 - 97;
					}
					//event.returnValue = true;
				break;
			}	
		}
	 	



	/* 개발자 작업  끝 */