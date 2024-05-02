/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0054.js
*@FileTitle : Service Order 수정-Supplement 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-16
*@LastModifier : ay han
*@LastVersion : 1.6 
* 2009-02-27 ay han
* 1.0 최초 생성 
* N200903160120  2009-03-18 'Supplement S/O 조회조건 추가 '
* 1.12 2010.11.22 이재위 [CHM-201005356-01] [TRS] RD CNTR 의 Usage Rate 변경 요청
* 2012.08.02 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0054 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0054() {
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
var prefix          = 'surcharge_';
var key_row_name    = 'Adjusted';

var sheetObjects = new Array();
var sheetCnt = 0;

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
    	            doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
        	        break;

        	    case "btn_reset":
					fn_reset();
         	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject, formObject, IBINSERT, "");
         	        break;

        	    case "btng_downexcel":
    	            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
        	        break;

        	    case "btn_minimize":
                    if(document.all.MiniLayer.style.display != "none"){
                        document.all.MiniLayer.style.display = "none";
                        sheetObject.style.height = sheetObject.GetSheetHeight(18);
                    }
                    else {
                        document.all.MiniLayer.style.display = "";
                        sheetObject.style.height = sheetObject.GetSheetHeight(9);
                    }
                    break;

				case "btns_frmnode": //FromNode Popup창
					openHireYardPopup('getFromNode');
				break;

				case "btns_vianode": //ViaNode Popup창
					openHireYardPopup('getViaNode');
				break;

				case "btns_tonode": //ToNode Popup창
					openHireYardPopup('getToNode');
				break;

				case "btns_dorloc": //DoorLocation Popup창
					openHireYardPopup('getDorLoc');
				break;

				case "btng_provider":
					rep_OnPopupClick();
					break;

				case "btng_sodelete":
					doActionIBSheet(sheetObject, formObject, IBSAVE, "SO_DELETE");
					break;

				case "btng_wopreview":
					var checkList = sheetObject.FindCheckedRow('ibcheck');
					var arrRow = checkList.split("|");
					var trsp_so_no = "";
					for(idx=0; idx<arrRow.length-1; idx++){ 
						trsp_so_no += sheetObject.CellValue(arrRow[idx], 'trsp_so_ofc_cty_cd')+sheetObject.CellValue(arrRow[idx], 'trsp_so_seq')+",";
					}		 
					formObject.trsp_so_no.value = trsp_so_no; // S/O의 Office 코드를 검증하기 위해 추가
					doActionIBSheet(sheetObject, formObject, IBSAVE, "WO_PREVIEW");
					break;

				case "btns_calendar":
					getCalendar();
				break;
				
				case "btn_eq_no":
					so_OnPopupClick('EQ','EQ No.');
				break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TRS90384');
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
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
        //2009-03-13 추가 : eq type에 따른 tp/sz 데이터 list 가져오기
        change_eq_tp_sz(0);
        
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
	}
	
	//Axon ??? ??2. ??????? --- start
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 */
	function engnum_keypress() {
	}
	
	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
	 **/
	function manual_click() {
	}
	
	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	}
	
	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	}
	
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수 --- end

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
           case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(52, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle  = "|||EQ No.|TP/SZ|Cost\nMode|Trans\nMode|";
                    	HeadTitle += "From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc|Door Loc|Distance(Km)|Distance(R.Link)|";
                    	HeadTitle += "Actual\nCustomer|Door Delivery\nAddress|";
                    	HeadTitle += "Service Provider|Service Provider|BKG No|BL No|T.VVD|S/O No|Org. W/O No|Org. W/O\nCreation Date|";
                    	HeadTitle += "Org. Invoice No|Org. Invoice\nConfirm Date|Reference No|Reason|";
                    	HeadTitle += "Amount Kind|Default\nS/P|S/P\nType|Agmt Rate TP|Oneway\nRoundTrip|Currency|Basic|Nego|Fuel|Additional|Total|";
                    	HeadTitle += "Agmt No1|Agmt No2|Agmt RT TP CD|Cnt Flag|Cust Cnt|Cust Seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  true,   "trsp_so_ofc_cty_cd"		,	false,  "",	dfNone		,   2,	false,	false,		100,	false,		false,	   "",	  false	);  //01
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  true,   "trsp_so_seq"			,	false,  "",	dfNone		,   2,	false,	false,		100,	false,		false,	   "",	  false	);  //02

                    InitDataProperty(0, cnt++,  dtCheckBox		,  	30	,   daCenter,  true	,   "ibcheck"                                                                                                                    	);  //03
					InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true	,   "eq_no"					,	true ,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //04
                    InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true	,   "eq_tpsz_cd"			,	true ,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //05
					InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,   "trsp_cost_dtl_mod_cd"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //06
                    InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,   "trsp_crr_mod_cd"		,   false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //07
					InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,   "fm_loc"				,	false,  "",	dfEngUpKey	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //08
                    InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true	,   "fm_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //09
                    InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,   "via_loc"				,	false,  "",	dfEngUpKey	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //10
                    InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true	,   "via_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //11
                    InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,	"to_loc"				,	false,  "",	dfEngUpKey	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //12
                    InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true	,   "to_yard"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //13
                    InitDataProperty(0, cnt++ , dtData			,   45	,   daCenter,  true	,   "dor_loc"				,	false,  "",	dfEngUpKey	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //14
                    InitDataProperty(0, cnt++ , dtData			,   25	,   daCenter,  true	,   "dor_zone"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //15
                    
       				//2012.06.11 Add Distance column by SHIN DONG IL
    				InitDataProperty(0, cnt++, dtData			,  100	, 	 daRight,  true, 	"ttl_dist"				, 	false, "", dfInteger	, 	0, false, 	false);
    				InitDataProperty(0, cnt++, dtData			,  100	, 	daCenter,  true, 	"lnk_dist_div_cd"		, 	false, "", dfNone		, 	0, false, 	false);

					InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true	,   "cust_val"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                    InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true	,   "dor_de_addr"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //17
                    InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true	,   "vndr_seq"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //18
					InitDataProperty(0, cnt++ , dtData			,   100	,   daLeft	,  true	,   "vndr_nm"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //19
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "bkg_sq"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //20
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "bl_no"					,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //21
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "truck_vvd"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //22
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "so_number"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //23
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "wo_number"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //24
                    InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true	,   "cre_dt"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //25
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "inv_no"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //26
                    InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true	,   "inv_cfm_dt"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //27

                    InitDataProperty(0, cnt++ , dtData			,   120	,   daCenter,  true	,   "ref_no"				,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //26
                    
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  true	,   "spl_iss_rsn"			,	false,  "",	dfNone		,   0,  true ,	false,		100,	false,		false,	   "",	  false	);  //28

                    InitDataProperty(0, cnt++ , dtData			,   80	,   daLeft  ,  false,   "amount_kind"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //29

                    InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "trsp_dflt_vndr_flg"	,	false,  "",	dfNone		,	2,  false,	false,		100,	false,		false,	   "",	  false	);  //30
					InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "sp_type"			 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //31
					InitDataProperty(0, cnt++ , dtData			,   90	,   daCenter,  false,   "agmt_rate_type_nm" 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //32
					InitDataProperty(0, cnt++ , dtCombo			,   90	,   daCenter,  false,   "way_type"			 	,	false,  "",	dfNone		,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //33
                    InitDataProperty(0, cnt++ , dtCombo			,   90	,   daCenter,  false,   "curr_cd"				,	false,  "",	dfNone		,	2,  true ,	false,		100,	false,		false,	   "",	  false	);  //34
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "bzc_amt"				,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //35
                    InitDataProperty(0, cnt++ , dtPopup			,	90	,   daRight	,  false,	"nego_amt"			    ,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //38
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "fuel_scg_amt"			,   false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //36
                    InitDataProperty(0, cnt++ , dtPopup			,	90	,   daRight	,  false,	"etc_add_amt"			,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //38
                    InitDataProperty(0, cnt++ , dtData			,   90	,   daRight	,  false,   "total_amt"				,   false,  "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|", dfNullFloat, 2, false, false, 10 , false,		true,	   "",	  false	);  //39

                    //Agreement Rate 관련변수 추가
                    InitDataProperty(0, cnt++ , dtHidden		,   90	,   daRight	,  false,   "ovr_wgt_scg_amt"		,  	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //37
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "agmt_ofc_cty_cd"		);	//40
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "agmt_seq"				);  //41
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "agmt_rate_type"		);  //42
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "agmt_way_type"		    );  //42
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "cust_nomi_trkr_flg"	);  //43
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "cust_cnt_cd"			);  //44
					InitDataProperty(0, cnt++ , dtHidden		,   90	,   daCenter,  false,   "cust_seq"				);  //45

					InitDataProperty(0, cnt++ , dtStatus 		,   30	,   daCenter,  true	,   "ibflag"				);  //46
					InitDataProperty(0, cnt++,  dtSeq			,	0	,   daCenter,  true	,   "surcharge_key"			); 	//47

					RangeBackColor(1, 16, 1, 33) = RgbColor(222, 251, 248);   // ENIS

					InitDataCombo(0, "way_type", " |"+way_typeText, " |"+way_typeCode);
					InitDataCombo(0, 'curr_cd' , curr_cdText, curr_cdCode);

					ColHidden('ibflag')				= true;
					ColHidden('surcharge_key')		= true;
               }
                break;

			   case 2:      //SO CREATED SHEET
					with (sheetObj) {

					cnt = 0;
					style.height = 0;
					//전체 너비 설정
					SheetWidth = soCreationTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "sts|svc_ord|seq";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,   150,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++,  dtData,		150,	daCenter,	false,  "trsp_so_ofc_cty_cd", false,  "", dfNone,		0,	false,  false,  20);
					InitDataProperty(0, cnt++ , dtData,     150,	daCenter,	false,  "trsp_so_seq"		, false,  "", dfNone,		0,	false,  false,  20);
					InitDataProperty(0, cnt++ , dtData,     150,	daCenter,	false,  "vndr_seq"		    , false,  "", dfNone,		0,	false,  false,  20);
			   }
				break;
				
			   case 3:      //SURCHARGE SHEET
    				with (sheetObj) {
    				// 높이 설정
    				style.height = 0;
    				//전체 너비 설정
    				SheetWidth = surchargeTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   //전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(65, 2, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false)

    				var HeadTitle = "STS||Office|Cost Mded|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, false);

    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

    				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
    				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"ibcheck");
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'unique_cd'					,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_seq'            	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_cd'            	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_full_nm'       	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_step_tp_cd'        	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scg_amt'                	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_mgst_tpsz_cd'      	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' 	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        	,false,"",dfNone,0,true,true);
    				
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_hndl_flg'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_mgst_usg_flg'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'tri_axl_flg'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_otr_flg'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'ovr_wgt_rmk'				,false,"",dfNone,0,true,true);
    				
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd'	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'grs_wgt'                	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'					,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no_split'        	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'		            	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scg_amt'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'		,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'			,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'		,false,"",dfNone,0,true,true);
    				
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
    				
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_grs_wgt'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd'	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'		,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'					,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'				,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_bil_flg'          	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             	,false,"",dfNone,0,true,true);
    				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             	,false,"",dfNone,0,true,true);
			   }
				break;				
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	switch(sAction) {
    			case IBSEARCH:
    				var checkList 	= sheetObj.FindCheckedRow('ibcheck');
    				
    				var vvd 	= formObj.vvdnumber.value	;
    				var bkg_no	= formObj.bkgnumber.value	;
    				var bl_no	= formObj.blnumber.value	;

    				var eq_no	= formObj.eqnumber.value	;
    				var ref_no	= formObj.refnumber.value	;

    				var so_no	= formObj.sonumber.value	;
    				var wo_no	= formObj.wonumber.value	;
    				
    				var lvfrmDate = doSepRemove(doSepRemove(formObj.from_date.value, " "), "-");
    				var lvtoDate  = doSepRemove(doSepRemove(formObj.to_date.value  , " "), "-");
    				
    				var msg1    = "Please enter S/O creation date.";
    				var errMsg  = "";
    				
    				if(      (vvd    == null || ComTrim(vvd   ) == "")   
                          && (bkg_no == null || ComTrim(bkg_no) == "")   
                          && (bl_no  == null || ComTrim(bl_no ) == "")   
                          && (eq_no  == null || ComTrim(eq_no ) == "")   
                          && (ref_no == null || ComTrim(ref_no) == "")   
                          && (so_no  == null || ComTrim(so_no ) == "")   
                          && (wo_no  == null || ComTrim(wo_no ) == "")  )
                    {
                        //if(     lvfrmDate == null || lvfrmDate == "" || lvtoDate == null || lvtoDate == "" )
             			//{
                		//	//2008.09.29:jsk:errMsg = ComGetMsg("TRS90124");
             			//   ComShowMessage(msg1);
             			//    //2008.09.29:jsk:return false;
             			//}
             			
             			if( lvfrmDate == "" && lvtoDate == "" ) { //한쪽 날짜가 빠진 경우
                		    ComShowMessage(msg1);
                			return false;
             			}else if( lvfrmDate == "" && lvtoDate != "" ) { //한쪽 날짜가 빠진 경우
                    		errMsg = ComGetMsg("TRS90119");
                    		ComShowMessage(errMsg);
                    		return false;
                    	} else if( lvfrmDate != "" && lvtoDate == "" ) { //한쪽 날짜가 빠진 경우
                    		errMsg = ComGetMsg("TRS90121");
                    		ComShowMessage(errMsg);
                    		return false;
                    	} else if( lvfrmDate != "" && lvtoDate != "" ) { //날짜 체크하는 부분
                    		if( !doDatecheck(lvfrmDate) ) {
                    			errMsg = ComGetMsg("TRS90072");
                    			ComShowMessage(errMsg);
                    			formObj.from_date.focus();
                    			return false;
                    		} else if( !doDatecheck(lvtoDate) ) {
                    			errMsg = ComGetMsg("TRS90073");
                    			ComShowMessage(errMsg);
                    			formObj.from_date.focus();
                    			return false;
                    		}
                    		if( dateCalcuration(lvfrmDate, lvtoDate) > 61 ) {
                    			errMsg = ComGetMsg("TRS90391",  "two months");
                    			ComShowMessage(errMsg);
                    			return false;
                    		} else if( dateCalcuration(lvfrmDate, lvtoDate) < 0 ) {
                    			errMsg = ComGetMsg("TRS90118");
                    			ComShowMessage(errMsg);
                    			return false;
                    		}
                    	} 
                	             			
                    }    				
    				
    				break;

    			case IBSAVE:
    				var checkList 	= sheetObj.FindCheckedRow('ibcheck');

    				if(checkList == ''){
    					ComShowCodeMessage('COM12176');
    					return false;
    				}

    				var checkArray 	= checkList.split('|');
    				for(var k = 0; k<checkArray.length-1; k++)
    				{
    					var row = checkArray[k];
    					//if( row%3 == 0 ){
    					//}
    				}
    				break;
    	}
    	return true;
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, sFlag) {

        sheetObj.ShowDebugMsg = false;
		var formObj = document.form;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj, formObj, sAction))
                {
					formObj.hid_from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
					formObj.hid_via_node.value = formObj.search_via_loc.value+document.search_via_yard.Code;
					formObj.hid_to_node.value = formObj.search_to_loc.value+document.search_to_yard.Code;
					formObj.hid_dor_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;

					formObj.hid_from_date.value  = removeBar(formObj.from_date.value);
					formObj.hid_to_date.value    = removeBar(formObj.to_date.value);
					formObj.hid_provider.value   = formObj.combo_svc_provider.value;
					
					//2009-03-12 추가
					formObj.hid_tp_sz.value   	= formObj.tp_sz.value;

					////2008.09.29:jsk:if(!checkWoCreDt()) return false;

					formObj.f_cmd.value 		= SEARCHLIST02;
					//sheetObj.ShowDebugMsg = true;
					sheetObj.DoSearch4Post("ESD_TRS_0054GS.do", TrsFrmQryString(formObj));
					//sheetObj.ShowDebugMsg = false;

					/* row three pair unit painting color */
					cols_controll_color();

					sheetObj.CheckAll2("ibcheck") = 0;      /* CHECK RELEASE ; CheckAll2 >> CheckAll   */

                }
                break;

            case IBSAVE:        //저장
                var mainSheetObj        = sheetObj      ;     /* MAIN      SHEET */
    			var creSheetObj         = sheetObjects[1] ;     /* SO CREATE SHEET */

                if( sFlag == "SO_DELETE" )
                {
    			    if(!validateForm(mainSheetObj, formObj, sAction))	return false;

    			    if(!confirm('Are you sure to proceed for ' + 'Supplement S/O Delete' + ' ?'))	return false;

    				var rowCount        = mainSheetObj.RowCount;
    				var checkedRow      = "";
    				var targetRowValue  = "";

    				var mainQueryString          = "";

    				if(rowCount > 0){

						for(var i = 1; i <= rowCount; i++) {
							checkedRow       = mainSheetObj.CellValue(i, "ibcheck");
							targetRowValue   = mainSheetObj.CellValue(i, "amount_kind");

							if(checkedRow > 0){         //체크된 ROW만 PUT.
								if(targetRowValue == key_row_name){		//key_row_name == "Adjusted"
									mainSheetObj.RowStatus(i) = "I";
								}else{
									mainSheetObj.RowStatus(i) = "R";
								}
							////}else{ //None-Checked Row
							////	mainSheetObj.RowStatus(i)     = "R";
							}

						}//for(var i = 1; i < p; i++) {

                        mainQueryString        = mainSheetObj.GetSaveString(false, false, "ibcheck");
    					formObj.f_cmd.value    = REMOVE;
                        mainSheetObj.DoSave("ESD_TRS_0054GS.do", TrsFrmQryString(formObj), -1, false);
 
    					//저장후 조회!!!!
    					doActionIBSheet(mainSheetObj, formObj, IBSEARCH);

					}  //END OF IF(rowCount>0)

    			//END OF "SO_DELETE".
    			}
                else if( sFlag == "WO_PREVIEW" )
                {
                    document.woForm.reset();
                	gotoPreview();
				}
                //END OF "WO_PREVIEW".

				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
              sheetObj.Down2Excel(-1, false, false, true);

              break;

			case IBINSERT:      // 입력
                sheetObj.DataInsert();
                break;
        }
    }

	/**
	* 저장결과가 오류가 발생했을 때 공통처리하는 함수
	* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	*/
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		if(errMsg == null || errMsg == ''){
			cols_controll();
		}else{
			ComShowCodeMessage('errMsg');
			return;
		}
	}

	/**
	 * ofc팝업호출
	 */
	function so_OnPopupClick(val, title)
	{
			var formObject          = document.form  ;
			var cmdt_cd_val         = ""             ;   //향후 사용가능 예정변수
			var rep_cmdt_cd_val     = ""             ;   //향후 사용가능 예정변수
			var cmdt_desc_val       = ""             ;   //향후 사용가능 예정변수
			var classId             = "getCOM_ENS_so";
			var xx1                 = val            ;  //CONTI
			var xx2                 = title          ;  //SUB CONTI
			var xx3                 = ""             ;  //COUNTRY
			var xx4                 = ""             ;  //STATE
			var xx5                 = ""             ;  //CONTROL OFFIC
			var xx6                 = ""             ;  //LOC CODE
			var xx7                 = ""             ;  //LOC NAME
			var xx8                 = ""             ;
			var xx9                 = ""             ;

			var param ="?returnval="+xx1+"&returntitle="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	/**
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getTRS_ENS_906(rowArray, returnval) {

		var formObject = document.form;

		if(returnval == "SO"){
			formObject.sonumber.value     = rowArray;
		}else if(returnval == "WO"){
			formObject.wonumber.value     = rowArray;
		}else if(returnval == "BKG"){
			formObject.bkgnumber.value    = rowArray;
		}else if(returnval == "BL"){
			formObject.blnumber.value     = rowArray;
		}else if(returnval == "EQ"){
			formObject.eqnumber.value     = rowArray;
			checkDigit();
		}else if(returnval == "VVD"){
			formObject.vvdnumber.value    = rowArray;
		}
	}

	function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.eqnumber;
	}
	
	obj.value = obj.value.toUpperCase();

	if(formObj.btns_radio_eq[0].checked){
		obj.value = multiCntrChkDgt(obj.value);
		}
	}

	function checkWoCreDt(){
	
	var formObj = document.form;
	
	if( formObj.from_date.value == null || formObj.from_date.value == ""
			|| formObj.to_date.value == null || formObj.to_date.value == "" ){ 
		
		if((formObj.vvdnumber.value == null ||
			formObj.vvdnumber.value == "") && 
			(formObj.bkgnumber.value == null ||
			formObj.bkgnumber.value == "") &&
			(formObj.blnumber.value == null ||
			formObj.blnumber.value == "") &&
			(formObj.refnumber.value == null ||
			formObj.refnumber.value == "") &&
			(formObj.sonumber.value == null ||
			formObj.sonumber.value == "") &&
			(formObj.wonumber.value == null ||
			formObj.wonumber.value == "")){
				ComShowMessage("Please enter S/O creation date.");
				return false;
			}else{
				return true;	
			}
		}
		return true;
	}
	
	/**
	 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다.
	 */
	function change_val(){

		var formObject = document.form;
		var sheetObject = formObject.sheet1;
		var val="";

		if ( formObject.btns_radio_issued[0].checked == true ) {
			formObject.hid_issued.value="C";
		}else if( formObject.btns_radio_issued[1].checked == true ) {
			formObject.hid_issued.value="I,R";
		}else{
			formObject.hid_issued.value="";
		}

		var vla_1 = "";


		var sheet1_count =formObject.sheet1.RowCount;
		if(sheet1_count>0){
			if(confirm(sheet1_count+"건의 조회결과가 존재합니다. 조회조건변경시 clear되어집니다.\n계속 진행하시려면 확인버튼을 눌러주시기 바랍니다.")){
				formObject.sheet1.RemoveAll();
			}else{
				if ( formObject.hid_issued.value=="C" ) {
					formObject.btns_radio_issued[1].checked = true;
					formObject.hid_issued.value="I,R";
				}else{
					formObject.btns_radio_issued[0].checked = true;
					formObject.hid_issued.value="C";
				}
				return false;
			}
		}

	}

	
	/**
	 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다.
	 */
	function change_eq_val(){
		var formObject = document.form;
		var sheetObject = formObject.sheet1;
        var num;
        
		if ( formObject.btns_radio_eq[0].checked == true ) {
			formObject.hid_eq_radio.value="U";
			num = 0 ;
		}else if( formObject.btns_radio_eq[1].checked == true ) {
			formObject.hid_eq_radio.value="Z";
			num = 1 ;
		}else if( formObject.btns_radio_eq[2].checked == true ) {
			formObject.hid_eq_radio.value="G";			
			num = 2 ;
		}else{
			formObject.hid_eq_radio.value="";
		}	
		
		//2009-03-13 추가 : eq type에 따른 tp/sz 데이터 list 가져오기
        change_eq_tp_sz(num);
	}

	

	//'포커스주기
	function fun_Focus(obj){
		var val = removeBar(obj.value);
		obj.value = val;
		obj.select();
	}

	//'-' 없애기
	function fun_Focus_del(obj){
		var val = removeBar(obj.value);
		obj.value = val;
		obj.select();
	}

	//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function removeBar(str) {
	   var value = "";
	   for ( var i = 0; i < str.length; i++ ) {
		  var ch = str.charAt(i);
		  if ( ch != '-' ) value = value + ch;
	   }
	   return value;
	}

	//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
	function removeDbval(str) {
	   var value = "";
	   for ( var i = 0; i < str.length; i++ ) {
		  var ch = str.charAt(i);
		  if ( ch != '　' ) value = value + ch;
	   }
	   return value;
	}

	//  blur시 데이타체크
	function BlurDate(obj)
	{

		var f =  document.form;
		var dt = removeBar(obj.value);
		if( dt == ""){}else
		{
			if ( isValidDate(dt))
			{
				if( dt.length == 8 )
				{
					addBar(obj);
					return;
				}
				else
				{
					ComShowCodeMessage('TRS90388', 'date');     //유효한 날짜가 아닙니다.
					obj.select();
					obj.focus();
					return;
				}
			}
			ComShowCodeMessage('TRS90388', 'date');     //유효한 날짜가 아닙니다.
			obj.select();
			obj.focus();
			return;
		}
	}

	// 유효 날짜 체크(2)
	function isValidDate(date)
	{
		var year = date.substring(0,4);
		var month = date.substring(4,6);
		var day = date.substring(6,8);

		if (isDatecheck(year, month, day) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// 유효 날짜 체크(1)
	function isDatecheck( year,month,day )
	{
		 if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) )
		 {
			  return true;
		 }
		 else
		 {
			  return false;
		 }
	}

	// 월 체크
	function checkMonth( month )
	{
		 var intmonth = parseInt( month , 10 )

		 if( intmonth >= 1  && intmonth <= 12  )
		 {
			  return true;
		 }
			else
		 {
			  return false;
		 }
	}

	// 유효 날짜 체크
	function checkDay( yyyy, mm, dd )
	{
		 var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
		 var im = parseInt(mm,10) - 1;

			if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) )
		 {
				monthDD[1] = 29;
		 }

		 if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] )
		 {
				return false;
		 }
			else
		 {
				return true;
		 }
	}

	//날자포맷으로 yyyy-mm-dd
	function addBar(dt)
	{
		var dat="";
		if( dt.length == 8 )
	  {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	  }
		 return dat;
	}

	//날자포맷으로 yyyy-mm-dd
	function addBar_from(obj) //날자포맷으로 yyyy-mm-dd
	{
		var formObject = document.form;
		var dt=obj.value;
		var dat=dt;

		if( dt.length == 8 )
		{
			dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
		}

		formObject.from_date.value= dat;
	}

	//날자포맷으로 yyyy-mm-dd
	function addBar_to(obj) //날자포맷으로 yyyy-mm-dd
	{
		var formObject = document.form;
		var dt=obj.value;
		var dat=dt;

		if( dt.length == 8 )
		{
			dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
		}

		formObject.to_date.value= dat;
	}

	function date(){



	}

	/**
	 * From Node 팝업에 대한 리턴값
	 */
	function getFromNode(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];
		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.search_fm_loc.value = lvLoc;
		getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
		document.search_fm_yard.CODE = lvYard;
	}

	/**
	 * Via Node 팝업에 대한 리턴값
	 */
	function getViaNode(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];
		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.search_via_loc.value = lvLoc;
		getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
		document.search_via_yard.CODE = lvYard;
	}

	/**
	 * To Node 팝업에 대한 리턴값
	 */
	function getToNode(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];
		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.search_to_loc.value = lvLoc;
		getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
		document.search_to_yard.CODE = lvYard;
	}

	/**
	 * Door Location 팝업에 대한 리턴값
	 */
	function getDorLoc(rowArray) {
		var formObject = document.form;
		var colArray = rowArray[0];
		var node = colArray[3];

		var lvLoc = node.substring(0, 5);
		var lvYard = node.substring(5, 7);
		formObject.search_door_loc.value = lvLoc;
		getYardCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
		document.search_door_yard.CODE = lvYard;
	}

	/*
	 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
	 */
	function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
		var formObj  = document.form;
		var lvobj    = doSepRemove(obj.value.toUpperCase(), " ");
		var charval  = "Y";
		obj.value    = lvobj;

		for (var i = 0; i < lvobj.length; i++)
		{
			 var oneChar = lvobj.charAt(i)
			 if (oneChar != "")
			 {
				   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
				   }else {
					   charval ="N";
					   break;
				   }
			 }else{
				charval ="N";
				break;
			 }
		}

		if(charval == "Y"){
		}else{
			var errMessage = ComGetMsg('COM12130','NODE','','');
			ComShowMessage(errMessage);
			obj.value = "";
			obj.focus();
			return false;
		}

		if( lvobj == "" ) {

			obj.value = "";



			if(obj.name == 'search_fm_loc')         yard_obj = document.search_fm_yard;
			else if(obj.name == 'search_via_loc')   yard_obj = document.search_via_yard;
			else if(obj.name == 'search_to_loc')    yard_obj = document.search_to_yard;
			else if(obj.name == 'search_door_loc')  yard_obj = document.search_door_yard;

			var locValue = obj.value;

			if(ComTrim(locValue) == ''){
				yard_obj.RemoveAll();
				return;
			}
		} else if( lvobj.length != 5 && lvobj.length != 2) {
			ComShowCodeMessage('TRS90122');      //TRS90122 - Location의 길이가 맞지않습니다.
			if( sep == "F" ){
				formObj.search_fm_loc.select();
				formObj.search_fm_loc.focus();
			}else if( sep == "V" ){
				formObj.search_via_loc.select();
				formObj.search_via_loc.focus();
			}else if( sep == "T" ){
				formObj.search_to_loc.select();
				formObj.search_to_loc.focus();
			}else if( sep == "D" ){
				formObj.search_door_loc.select();
				formObj.search_door_loc.focus();
			}else{

			}
		}else{

			if( sep == 'F' ){
				lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
			}else if( sep == 'V' ){
				lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
			}else if( sep == 'T' ){
				lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
			}else if( sep == 'D' ){
				lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
			}else{
			}
		}

	}

	/**
	 * 공통 Node popup
	 */
	 function openHireYardPopup(objName) {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId = objName;
		var xx1 = ""; //CONTI
		var xx2 = ""; //SUB CONTI
		var xx3 = ""; //COUNTRY
		var xx4 = ""; //STATE
		var xx5 = ""; //CONTROL OFFIC
		var xx6 = ""; //LOC CODE
		var xx7 = ""; //LOC NAME
		var xx8 = "";
		var xx9 = "";
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	/**
	 * SOcheck.
	 */
	function val_check(obj,val){

		var formObject = document.form;
		var inputStr=obj.value;
		var value=obj.value;
		var charval = "Y";
		var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
		lvobj=obj.value;

		if( lvobj != "" ) {
			for (var i = 0; i < inputStr.length; i++)
			{
				 var oneChar = inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == "," )   ){
					   }else {
						   charval ="N";
						   break;
					   }
				 }else{
					charval ="N";
					break;
				 }
			}

			if(charval=="Y"){
			}else{
				var errMessage = ComGetMsg('COM12130',val,'','');
				ComShowMessage(errMessage);
				obj.value = "";
				obj.focus();
			}
		}

	}

	/**
     * 콤보박스 -bound
     */
	function bound_OnChange_1(obj){
		var codeval =obj.value;
		var formObject = document.form;

		formObject.hid_boundmode.value=codeval;
	}

	/**
     * 콤보박스 -cost
     */
	function bound_OnChange_2(obj){
		var codeval =obj.value;
		var formObject = document.form;

		formObject.hid_costmode.value=codeval;
	}

	/**
     * 콤보박스 -trans
     */
	function bound_OnChange_3(obj){
		var codeval =obj.value;
		var formObject = document.form;

		formObject.hid_transmode.value=codeval;
	}

	/**
     * 콤보박스 -trans
     */
	function bound_OnChange_4(obj){
		var codeval =obj.value;
		var formObject = document.form;

		formObject.hid_transmode.value=codeval;
	}

	/**
	 * VNDR_check.
	 */
	function vndr_check(obj){

		var formObject = document.form;
		var inputStr=obj.value;
		var value=obj.value;
		var charval = "Y";

		for (var i = 0; i < inputStr.length; i++)
		{
			 var oneChar = inputStr.charAt(i)
			 if (oneChar != "")
			 {
				   if ( (oneChar >= "0" && oneChar <= "9" )){
				   }else {
					   charval ="N";
					   break;
				   }
			 }else{
				charval ="N";
				break;
			 }

		}

		if(charval=="Y"){
			if(value !=""){
				formObject.f_cmd.value = SEARCH04;
				var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
				formObject.vndr_cd.value="";
				formObject.vndr_cd.focus();
			}
		}else{
			formObject.vndr_cd.value="";
			formObject.vndr_cd.focus();
			var errMessage = ComGetMsg('COM12130','Service Provide','','');
			ComShowMessage(errMessage);
		}

	}

	/**
	 * VNDR 입력시 존재여부체크
	 *
	 */
	function check_vndr(value, obj)
	{
		var formObject = document.form;
		if( value == 0)
		{
			var errMessage = ComGetMsg('COM12114','VNDR','','');
			ComShowMessage(errMessage);
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 외부 콤보박스의 리스트 가져오기
	 **/
	function getVendorComboList()
	{
		var formObj = document.form;
		var vendorNo = formObj.combo_svc_provider.Text ;
		
		getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo, '', '');
	}

	/**
	 * rep_commodity팝업호출
	 */
	function rep_OnPopupClick()
	{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	/**
	 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_rep(rowArray) {
		var formObj = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[4];

			formObj.combo_svc_provider.value = colArray2;
			formObj.svc_provider.value = colArray3;
		}
	}

	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnDblClick(sheetObj, row, col, value)
	{

		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);

		switch(colName){

			case 'etc_add_amt':

				sheet1_check = formObj.sheet1.CellValue(row, "amount_kind");
				if(sheet1_check == key_row_name){
					popSurchargeInputInquiry(sheetObj, row, col, 'search');
				}

				break;
		}


		if(sheetObj.ReadDataProperty(row, col, 0)==6)
		{
			return;
		}



		if(!sheetObj.CellEditable(row, col)) return;

		switch(colName){

			case 'fm_nod_cd_sub':

				if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_nod_cd'));
				}
				break;

			case 'via_nod_cd_sub':

				if( sheetObj.cellValue(row, 'via_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_nod_cd'));
				}
				break;

			case 'to_nod_cd_sub':

				if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_nod_cd'));
				}
				break;

			case 'dor_nod_cd_sub':

				if( sheetObj.cellValue(row, 'dor_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_nod_cd'));
				}
				break;

			case 'etc_add_amt':
				sheet1_check = formObj.sheet1.CellValue(row, "amount_kind");
				if(sheet1_check == key_row_name){
					popSurchargeInputInquiry(sheetObj, row, col, 'search');
				}

				break;

		}
	}

	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnDblClick(sheetObj, row, col, value)
	{
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
		var r_hid_kind = formObj.hid_kind.value;

		switch(colName){

			case 'etc_add_amt':

                if(r_hid_kind == 'AS'){
    				sheet1_check = formObj.sheet1.CellValue(row, "amount_kind");
    				if(sheet1_check == key_row_name){
    					popSurchargeInputInquiry(sheetObj, row, col, 'search');
    				}
                } else {
                    return;
                }

				break;
		}

		if(sheetObj.ReadDataProperty(row, col, 0)==6)
		{
			return;
		}

		if(!sheetObj.CellEditable(row, col)) return;

		switch(colName){

			case 'fm_nod_cd_sub':

				if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_nod_cd'));
				}
				break;

			case 'via_nod_cd_sub':

				if( sheetObj.cellValue(row, 'via_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_nod_cd'));
				}
				break;

			case 'to_nod_cd_sub':

				if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_nod_cd'));
				}
				break;

			case 'dor_nod_cd_sub':

				if( sheetObj.cellValue(row, 'dor_nod_cd') != '' )
				{
					getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_nod_cd'));
				}
				break;

			case 'ibcheck':

				//changeData(row);
				break;

			////case 'etc_add_amt':
            ////
			////	if(r_hid_kind == 'AS'){
    		////		sheet1_check = formObj.sheet1.CellValue(row, "amount_kind");
    		////		if(sheet1_check == key_row_name){
    		////			popSurchargeInputInquiry(sheetObj, row, col);
    		////		}
    		////    } else {
            ////        return;
            ////    }
            ////
			////	break;

		}
	}

	/**
	 * sheet click시 일어나는 이벤트
	 **/
	function sheet1_OnChange(sheetObj, row, col, value)
	{

		var formObj = document.form;
		var sheet1_x1 ="";
		var sheet1_x2 ="";
		var sheet1_checkval ="";
		var sheet1_x1val ="";
		var sheet1_count =sheetObjects[0].RowCount;
		var sheet1_check ="";

		if(sheetObj.ReadDataProperty(row, col, 0)==6)
		{
			return;
		}
		var colName = sheetObj.ColSaveName(col);

			switch(colName){

				case 'ibcheck':
					sheet1_x1 		= sheetObjects[0].CellValue(row, "trsp_so_seq");
					sheet1_x1val 	= sheetObjects[0].CellValue(row, "ibcheck");

					if(sheet1_count>0){
						for(var i = 1; i < sheet1_count+1; i++) {
							sheet1_x2 = sheetObjects[0].CellValue(i, "trsp_so_seq");

							if(sheet1_x1 == sheet1_x2){
								if(sheet1_x1val<1){
									sheetObjects[0].CellValue2(i,'ibcheck')	= 0;

									sheet1_check = sheetObjects[0].CellValue(i, "amount_kind");
									if(sheet1_check == key_row_name){
										sheetObjects[0].RowStatus(i)	= "R";
									}
								}else{
									sheetObjects[0].CellValue2(i,'ibcheck')	= 1;
									sheet1_check = sheetObjects[0].CellValue(i, "amount_kind");
									if(sheet1_check == key_row_name){
										sheetObjects[0].RowStatus(i)	= "I";
									}
								}
							}else{
							}
						}//for(var i = 1; i < p; i++) {
					}

					status_change();

				break;


				case 'fm_nod_cd':
					if( sheetObj.cellValue(row, 'fm_nod_cd') != '' )
					{
						getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
					}
					break;

				case 'via_nod_cd':

					if( sheetObj.cellValue(row, 'via_nod_cd') != '' )
					{
						getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
					}
					break;

				case 'to_nod_cd':

					if( sheetObj.cellValue(row, 'to_nod_cd') != '' )
					{
						getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
					}
					break;

				case 'dor_nod_cd':

					if( sheetObj.cellValue(row, 'dor_nod_cd') != '' )
					{
						getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
					}
					break;

				case 'curr_cd':

						var tot_sum="";
						tot_sum = parseFloat(sheetObjects[0].CellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].CellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'fuel_scg_amt')) +parseFloat(sheetObjects[0].CellValue(row, 'etc_add_amt')) ;
						sheetObjects[0].CellValue2(row, 'tot_amt') = parseFloat(tot_sum);

					break;

				case 'bzc_amt':

						var tot_sum="";
						tot_sum = parseFloat(sheetObjects[0].CellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].CellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'fuel_scg_amt')) +parseFloat(sheetObjects[0].CellValue(row, 'etc_add_amt')) ;
						sheetObjects[0].CellValue2(row, 'tot_amt') = parseFloat(tot_sum);


					break;

				case 'fuel_scg_amt':

						var tot_sum="";
						tot_sum = parseFloat(sheetObjects[0].CellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].CellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'fuel_scg_amt')) +parseFloat(sheetObjects[0].CellValue(row, 'etc_add_amt')) ;
						sheetObjects[0].CellValue2(row, 'tot_amt') = parseFloat(tot_sum);


					break;

				case 'ovr_wgt_scg_amt':

						var tot_sum="";
						tot_sum = parseFloat(sheetObjects[0].CellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].CellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'etc_add_amt')) ;
						sheetObjects[0].CellValue2(row, 'tot_amt') = parseFloat(tot_sum);


					break;

				case 'etc_add_amt':

						var tot_sum="";
						tot_sum = parseFloat(sheetObjects[0].CellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].CellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].CellValue(row, 'etc_add_amt')) ;
						sheetObjects[0].CellValue2(row, 'tot_amt') = parseFloat(tot_sum);


					break;
		}
		cols_controll_color();
	}

	function fn_reset(){

		var formObj   = document.form;
		var rowCount  = sheetObjects[0].RowCount;

		formObj.reset();

		if( rowCount > 0 ){
    			sheetObjects[0].RemoveAll();
    			formObj.reset();
    			formObj.btns_radio_kind[0].checked   = true;
    			formObj.btns_radio_eq[0].checked     = true;
    	}
	}

	/**
	 *조회후 특정 칼럼에 대해서 수정가능토록 하는 로직처리
	 */
	function cols_controll(){

		var formObj 		= document.form;
		var sheet1_x1		= "";

		var sheet1_count 	= sheetObjects[0].RowCount;

		if(sheet1_count>0){
			for(var i = 1; i < sheet1_count+1; i++) {
				sheet1_x1 = sheetObjects[0].CellValue(i, "amount_kind");

				if(sheet1_x1 == key_row_name){

					if ( formObj.btns_radio_kind[0].checked == false ) {
					}else{
					}
				}else{
				}
			}//for(var i = 1; i < p; i++) {
		}

		cols_controll_color();

	}

	/**
	 *조회후 특정 칼럼에 대해서 수정가능토록 하는 로직처리
	 */
	function cols_controll_color(){

		var formObj 		= document.form	;
		var sheet1_x1		= ""			;
		var sheet1_x2		= ""			;
		var sheet1_color	= "Y"			;

		var sheet1_count 	= sheetObjects[0].RowCount;

		sheet1_x1 			= sheetObjects[0].CellValue(1, "trsp_so_seq");

		if(sheet1_count>0){

			for(var i = 1; i < sheet1_count+1; i++) {
				sheet1_x2 = sheetObjects[0].CellValue(i, "trsp_so_seq");
				if(sheet1_x1 == sheet1_x2){
					if(sheet1_color == "Y"){
						sheetObjects[0].RowBackColor(i) = 15723503;
					}else{
						sheetObjects[0].RowBackColor(i) = sheetObjects[0].RgbColor(238,255,226);
					}
				}else{
					sheet1_x1 = sheetObjects[0].CellValue(i, "trsp_so_seq");
					i = i-1;
					if(sheet1_color == "Y"){
						sheet1_color = "N";
					}else{
						sheet1_color = "Y";
					}
				}
			}//for(var i = 1; i < p; i++) {
		}

	}

/**
	 * 쉬트에서 클릭식 adjusted에만 status가 i되도록 한다.
	 */
	function status_change(){

		var formObj = document.form;

        for( i=1; i<= formObj.sheet1.RowCount; i++) {
           if(formObj.sheet1.RowStatus(i)=="U"){
			   formObj.sheet1.RowStatus(i)="R";
           }
        }
		cols_controll_color();

	}

	/**
	 * vvd팝업호출
	 */
	function vvd_OnPopupClick()
	{

			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getCOM_ENS_VVD";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";

			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, 'getCOM_ENS_VVD', '1,0,1,1,1,1,1,1,1,1,1,1');

	}

	/**
	 * Location : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_VVD(rowArray) {

		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			var colArray2 = colArray[7];
			document.form.trunk_vvd.value = colArray2;
		}

	}

	/**
	 * vvd체크.
	 */
	function vvd_check(obj){

		var formObject = document.form;
		var value="";
		var xxx=obj.value;

		if(xxx!=""){
			formObject.f_cmd.value = SEARCH02;
			var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch("ESD_TRS_0001GS.do", queryString);
			if(!check_vvd(formObject.sheet1.EtcData('CNT_CD'),obj)) return;
		}

	}

	/**
	 * S/C Number 입력시 존재여부체크
	 *
	 */
	function check_vvd(val, obj)
	{

		var formObject = document.form;
		if( val == 0)
		{
			var errMessage = ComGetMsg('COM12114','Trunk vvd data','','');
			ComShowMessage(errMessage);
			formObject.trunk_vvd.value="";
			formObject.trunk_vvd.select();
			formObject.trunk_vvd.focus();
		}
	}

	/*
	 * 멀티 달력 입력 Pop-Up
	 */
	function getCalendar() {
		var cal = new ComCalendarFromTo();
		cal.displayType = "date";
		cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
	}

	/**
	 * Additional Amount를 클릭했을때 popup창을 띄워준다.
	 **/
	function sheet1_OnPopupClick(sheetObj, row, col){
		var colName = sheetObj.ColSaveName(col);
		switch(colName) {
			case 'etc_add_amt':
				popSurchargeInputInquiry(sheetObj, row, col, 'search');
				break;
		}
	}

function popSurchargeInputInquiry(sheetObj, row, col, mode)
{
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'surcharge_key');
	url += '&open_mode='+mode;
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=2';
	url += '&curr_cd='+sheetObj.CellValue(row, 'curr_cd');
	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

    /**
     * Surcharge Input Inquiry popup으로부터 data 전송받기
     **/
    function setSurchargeInputInquiry(winObj, sheetObj, formObj, totalSum)
    {
    	var mainSheetObj        = sheetObjects[0];
    	var surchargeSheetObj	= sheetObjects[2];

    	var row 				= formObj.main_row.value;
    	var unique_cd 			= formObj.unique_cd.value;


    	// 이전에 세팅됐던 값은 지워버린다.
    	for(var a=surchargeSheetObj.RowCount; a>0 ;a--)
    	{
    		if( surchargeSheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surchargeSheetObj.RowDelete(a, false);
    	}
    	var queryStr 	= sheetObj.GetSaveString(true, false);

    	if( queryStr=='' ) 	return false;

    	mainSheetObj.CellValue2(row, 'etc_add_amt') = totalSum;
    	var url = '?prefix='+prefix;
    	surchargeSheetObj.DoSearch4Post("ESD_TRS_0969.screen"+url, queryStr,'', true);
    	winObj.close();
    }


	/**
	 * W/O Preview로 이동하기
	 */
	function gotoPreview()
	{
		var mainSheetObj 	= sheetObjects[0];
		var creSheetObj 	= sheetObjects[1];

		var checkList 		= mainSheetObj.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return;
		}

		var mainSheetRowCount	= 0;
		var checkedRow      	= "";
		var targetRowValue  	= "";
		var targetRowCount		= 0;

		mainSheetRowCount		= mainSheetObj.RowCount;

		var k = 0;
		for(var i = 1; i <= mainSheetRowCount; i++) {
			checkedRow       = mainSheetObj.CellValue(i, "ibcheck");
			targetRowValue   = mainSheetObj.CellValue(i, "amount_kind");

			if(checkedRow > 0){         //체크된 ROW만 PUT.
				if(targetRowValue == key_row_name){		//key_row_name == "Adjusted"

					targetRowCount	= targetRowCount + 1;

					k = creSheetObj.DataInsert();
					creSheetObj.CellValue2(k,	"trsp_so_ofc_cty_cd")	= mainSheetObj.CellValue(i, "trsp_so_ofc_cty_cd")	;
					creSheetObj.CellValue2(k,	"trsp_so_seq"		)	= mainSheetObj.CellValue(i, "trsp_so_seq")			;
					creSheetObj.CellValue2(k,	"vndr_seq"			)	= mainSheetObj.CellValue(i, "vndr_seq")				;
				}
			}
		}

		if(creSheetObj.RowCount > 0){
			var cty_cd = '';
			var seq_no = '';

			for(var i=1; i <= creSheetObj.RowCount; i++)
			{
				if( i!=1 ){
					cty_cd += ',';
					seq_no += ',';
					//vndr_seq += ',';
				}
				cty_cd += creSheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
				seq_no += creSheetObj.CellValue(i, 'trsp_so_seq');
			}

			document.woForm.trsp_so_ofc_cty_cd.value  = cty_cd;
			document.woForm.trsp_so_seq.value         = seq_no;
			document.woForm.pgmNo.value 				= 'ESD_TRS_0024';
			document.woForm.trsp_so_no.value = document.form.trsp_so_no.value;
			// W/O 컨펌 시 S/O와 ofc코드가 일치하는지 확인하기 위해 전송
			document.woForm.submit();
		}
		return;
	}


	/**
	 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다.
	 */
	function change_val(){

		var formObject = document.form;
		var sheetObject = formObject.sheet1;
		var val="";

		if ( formObject.btns_radio_kind[0].checked == true ) {
			formObject.hid_kind.value="AS";
		}else if( formObject.btns_radio_kind[1].checked == true ) {
			formObject.hid_kind.value="RR";
		}else{
			formObject.hid_kind.value="";
		}

		var vla_1 = "";

		var sheet1_count =formObject.sheet1.RowCount;
		if(sheet1_count>0){
			if(confirm(sheet1_count+"건의 조회결과가 존재합니다. 조회조건변경시 clear되어집니다.\n계속 진행하시려면 확인버튼을 눌러주시기 바랍니다.")){
				formObject.sheet1.RemoveAll();
			}else{
				if ( formObject.hid_kind.value=="AS" ) {
					formObject.btns_radio_kind[1].checked = true;
					formObject.hid_kind.value="RR";
				}else{
					formObject.btns_radio_kind[0].checked = true;
					formObject.hid_kind.value="AS";
				}
				return false;
			}
		}

	}

//2009-03-13 추가 : eq type에 따른 tp/sz 데이터 list 가져오기
function change_eq_tp_sz(num){
		var formObject = document.form;
		
		tpszList =new Array(2);		
        tpszList[0]=new Array(28);
        tpszList[1]=new Array(10);

		
		//CNTR
		tpszList[0][0]="ALL";
		tpszList[0][1]="A2";
		tpszList[0][2]="A4";
		tpszList[0][3]="D2";
		tpszList[0][4]="D3";
		tpszList[0][5]="D4";		
		tpszList[0][6]="D5";
		tpszList[0][7]="D7";
		tpszList[0][8]="D8";
		tpszList[0][9]="D9";
		tpszList[0][10]="DW";
		tpszList[0][11]="DX";
		tpszList[0][12]="F2";
		tpszList[0][13]="F4";
		tpszList[0][14]="F5";
		tpszList[0][15]="O2";
		tpszList[0][16]="O4";
		tpszList[0][17]="P2";
		tpszList[0][18]="P4";
		tpszList[0][19]="R2";
		tpszList[0][20]="R4";
		tpszList[0][21]="R5";
		tpszList[0][22]="R7";		
		tpszList[0][23]="R8";
		tpszList[0][24]="S2";
		tpszList[0][25]="S4";
		tpszList[0][26]="T2";
		tpszList[0][27]="T4";            
                    
		//Chassis
		tpszList[1][0]="ALL";
		tpszList[1][1]="EG8";
		tpszList[1][2]="EG5";
		tpszList[1][3]="CB4";
		tpszList[1][4]="SF4";
		tpszList[1][5]="TA2";		
		tpszList[1][6]="SL2";
		tpszList[1][7]="SF2";
		tpszList[1][8]="GN4";		
		tpszList[1][9]="GN5";
		tpszList[1][10]="ZT4";		
			
 
	if(num == 0 || num == 1){
       	for(ctr=0;ctr<tpszList[num].length;ctr++){
       	    //카테고리에 해당하는 콤보박스의 값을 채움
       		formObject.tp_sz.options[ctr]=new Option(tpszList[num][ctr],tpszList[num][ctr]);       		  
      	}				
      	
      	//select 리스트 길이 지정
     	formObject.tp_sz.length=tpszList[num].length;
     	
    }else{
			formObject.tp_sz.options[0]=new Option("ALL","ALL");
			formObject.tp_sz.length=1;  
   }		
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}	
