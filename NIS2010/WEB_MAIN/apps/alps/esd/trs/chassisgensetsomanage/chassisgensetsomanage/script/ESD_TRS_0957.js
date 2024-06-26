/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0957 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0957() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

	/**
	 * IBSheet Object를 배열로 등록
	 * comSheetObject(id)에서 호출한다
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
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//html컨트롤 이벤트초기화
		initControl();
		
	}

	/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	    //???? ????
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	    //입력Validation 확인하기
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	    //?????? ???
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	    //???????
	//    ComKeyOnlyNumber(event.srcElement);
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

				
				case "btng_fileimport":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;

				case "btng_delete":
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;

				case "btng_verify":
					importEqNo(sheetObject, formObject);
					break;

				 case "btn_close":
	   	              window.close();
        	      break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e);
    		}
    	}
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
                    style.height = GetSheetHeight(10);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "Seq.|STS||EQ No|EQ TP/SZ|WO No|Verify Result" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,		false,    "eq_seq",			false,		"",		dfNone,		0,		false,		false	);
					InitDataProperty(0, cnt++ , dtStatus,		60,		daCenter,		false,    "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,    "ibcheck");
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,			false,    "eq_no",				false,		"",		dfNone,		0,		false,		false	);
					InitDataProperty(0, cnt++ , dtData,			80,	daLeft,			false,    "eq_tpsz_cd",			false,		"",		dfNone,		0,		false,		false	);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			false,    "trsp_wo_of_cty_cd",			false,		"",		dfNone,		0,		false,		false	);
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,			false,    "verify_result",	false,		"",		dfNone,		0,		false,		false	);

					InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"vndr_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"vndr_abbr_nm");
					InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "lstm_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"ownr_co_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "usr_co_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"mvmt_sts_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "lst_sts_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"mvmt_dt");

					ColHidden('ibflag')			= true;
			   }
                break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

                 if(validateForm(sheetObj,formObj,sAction))
               // formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("UI_ESD_TRS_0911_DATA.html");
                //sheetObj.DoSearch4Post("com.hanjin.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", TrsFrmQryString(formObj));
                break;
            case IBDELETE:        //저장
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');

				for(var k=checkArray.length-2; k>=0; k--)
				{
					sheetObj.RowDelete(checkArray[k], false);
				}
                break;

           case IBINSERT:      // 입력
                sheetObj.DataInsert();
                break;

           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);

              break;

           case IBLOADEXCEL:        //엑셀 업로드
			  sheetObj.RemoveAll();
              sheetObj.LoadExcel();
              break;

        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

	  
	/**
     * MInimize 클릭시 이벤트 관련
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";


            sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =20;

		}
    	else
    	{
    	    objs.style.display = "inline";

    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =10;

    	}

    }

	function importEqNo(sheetObj, formObj)
	{
        var opener_obj = window.dialogArguments;
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		sheetObj.RemoveEtcData();
		var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
		if(queryStr=='') return false;
		if(opener_obj.document.form.kind_chassis[0].checked) formObj.f_cmd.value = SEARCH04;
		else formObj.f_cmd.value = SEARCH05;
		
		var searchXml = sheetObj.GetSaveXml("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj));
		sheetObj.LoadSearchXml(searchXml, false, -1, true);

		if (verifyEqNo(sheetObj))
		{
			opener_obj.importEqNo(sheetObj, self.window);
		}
	}

	/**
	* S/O Creation시 2주이내에 create됐는지 여부 확인
	*/
	function verifyEqNo(sheetObj)
	{
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		var returnFlag = true;

		if(checkList == '')
		{
			ComShowCodeMessage('COM12176');
			return false;
		}

		for(var k=0; k<checkArray.length-1; k++)
		{
			var row = checkArray[k];
			var eq_no = sheetObj.CellValue(row, 'eq_no');
			
			if(sheetObj.EtcData(eq_no) != '' &&  sheetObj.EtcData(eq_no) != undefined)
			{
				sheetObj.CellValue2(row, 'verify_result') = '';
				sheetObj.RowBackColor(row) = 15723503;
				sheetObj.CellBackColor(row, 'ibcheck') = 0; 
			}else
			{
				sheetObj.CellValue2(row, 'ibcheck') = false;
				sheetObj.CellValue2(row, 'verify_result') = 'Invalid Equipment Number';
				
				sheetObj.RowBackColor(row) = sheetObj.RgbColor(238,255,226);
				returnFlag = false;
			}
		}
	
		return returnFlag;
	}

