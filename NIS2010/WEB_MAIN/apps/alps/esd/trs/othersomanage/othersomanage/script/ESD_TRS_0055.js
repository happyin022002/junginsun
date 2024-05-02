/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0055.js
*@FileTitle : Other
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.1
* 2010.03.18 최종혁
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2011.08.31 유선오   1.1 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.10.19 유선오   1.2 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2012.08.06 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0055 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0055() {
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
var ctMode = 0; //COST MODE, TRANS MODE 조합, 1-단일운송,DOOR제외, 2-복합운송,DOOR제외, 3-단일운송,DOOR, 4-복합운송,DOOR
var eqKindFlag = 'container';
var prefix = 'surcharge_';

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
//         var sheetObject3 = sheetObjects[3]; 

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case 'btng_sodelete':
					doActionIBSheet(sheetObject,formObject, IBDELETE);
					break;

				case 'btn_retrieve':
					doActionIBSheet(sheetObject,formObject, IBSEARCH);
					break;

        	    case "btn_reset":
    	            resetForm(formObject);
        	        break;

				case 'btng_socorrection':
					doActionIBSheet(sheetObject,formObject, IBSAVE);
					break;

				case 'btng_wopreview':
					var checkList = sheetObject.FindCheckedRow('ibcheck');
					var arrRow = checkList.split("|");
					var trsp_so_no = "";
					for(idx=0; idx<arrRow.length-1; idx++){ 
						trsp_so_no += sheetObject.CellValue(arrRow[idx], 'trsp_so_ofc_cty_cd')+sheetObject.CellValue(arrRow[idx], 'trsp_so_seq')+",";
					}		 
					formObject.trsp_so_no.value = trsp_so_no; // S/O의 Office 코드를 검증하기 위해 추가
					gotoPreview(sheetObject,formObject);
					break;

        	    case "btng_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btn_minimize":
                    if(document.all.MiniLayer.style.display != "none"){
                        document.all.MiniLayer.style.display = "none";
						sheetObject.style.height = sheetObject.GetSheetHeight(17);
                    }
                    else {
                        document.all.MiniLayer.style.display = "";
						sheetObject.style.height = sheetObject.GetSheetHeight(13);
                    }
                    break;

				case "btng_provider":
					rep_OnPopupClick();
					break;
				
				case "btn_fm_node":
					openHireYardPopup('fm_node');
					break;

				case "btn_via_node":
					if(ctMode == 1 || ctMode == 3) return;
					openHireYardPopup('via_node');
					break;

				case "btn_to_node":
					openHireYardPopup('to_node');
					break;
				
				case "btn_dr_node":
					if(ctMode == 1 || ctMode == 2) return;
					openHireYardPopup('dr_node');
					break;

				case "btn_eq_no":
					rep_Multiful_inquiry(srcName);
					break;
				
				case 'btns_calendar':
					getCalendar();
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
	    //Axon ??? ??1. ???catch
	    /*
	    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
	    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	    */
	}

	//Axon ??? ??2. ??????? --- start
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
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
    function initSheet(sheetObj,sheetNo) {
    	
        var cnt = 0;
 
        switch(sheetNo) {
		   case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(13);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(37, 4, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle1 = "STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc.|Door Loc.|Distance|Distance|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Toll Fee|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason|Nego Remark.|Trsp So Ofc Cty Cd|Trsp So Seq|SO Type Code|Cargo Type\nCode|EQ Kind Code|Other Cost Month Date";
					var HeadTitle2 = "STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Km|R.Link|Actual\nCustomer|Door Delivery\nAddress|Provider Code|Provider Name|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Toll Fee|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason|Nego Remark.|Trsp So Ofc Cty Cd|Trsp So Seq|SO Type Code|Cargo Type\nCode|EQ Kind Code|Other Cost Month Date";


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++,  dtCheckBox,   30,   daCenter,  true,    "ibcheck");
                    InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      			false,          "",      dfNone,      0,     false,     false,          15);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "eq_tpsz_cd",      		false,          "",      dfNone,      0,     false,     false,          4);

                    InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd", true,          "",      dfNone,       0,     false,     false,          2);
                    InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      true,          "",      dfNone,       0,     false,     false,          2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      	false,          "",      dfNone,      0,     false,     false,          5);
                    InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "fm_yard_value",      	false,          "",      dfNone,      0,     false,     false,          2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      	false,          "",      dfNone,      0,     false,     false,          5);

                    InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "via_yard_value",      	false,          "",      dfNone,      0,     false,     false,          2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",      	false,          "",      dfNone,      0,     false,     false,          5);
                    InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "to_yard_value",      	false,          "",      dfNone,      0,     false,     false,          2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      	false,          "",      dfNone,      0,     false,     false,          5);
                    InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "dr_yard_value",      	false,          "",      dfNone,      0,     false,     false,          2);
                    
    				//2012.06.01 Add Distance column by SHIN DONG IL
    				InitDataProperty(0, cnt++,  dtData,  	  50, 	daRight,   true, 	"ttl_dist", 			false, 			"",		 dfInteger,   1, 	 false, 	false);
    				InitDataProperty(0, cnt++,  dtData,  	  50, 	daCenter,  true, 	"lnk_dist_div_cd", 		false, 			"", 	 dfNone, 	  1, 	 false, 	false);
                    
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "act_cust_cnt_cd",      false,          "",      dfNone,      0,     false,     false,          8);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "dor_de_addr",      	false,          "",      dfNone,      0,     false,     false,          200);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_seq",      		false,          "",      dfNone,      0,     false,     false,          6);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_abbr_nm",      	false,          "",      dfNone,      0,     false,     false,          50);
					InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "curr_cd",      		false,          "",      dfNone,      0,     false,     false,          3);
                    InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "bzc_amt",      		false,          "",      dfFloat,     2,     false,     false,          13);
					InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "nego_amt",      		false,          "",      dfFloat,     2,     false,     false,          13);

                    InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "fuel_scg_amt",      	false,          "",      dfFloat,     2,     false,     false,         	13);
                    InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "toll_fee_amt",      	false,          "",      dfFloat,     2,     false,     false,         	13);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,   daRight,   true,    "etc_add_amt",      	false,          "",      dfNone,      2,     false,     false,          13, false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "total_amt",      		false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|toll_fee_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
                    InitDataProperty(0, cnt++ , dtData,       100,  daCenter,  true,    "ref_bkg_no",      	    false,          "",      dfNone,      0,     true,      true,          	12);

                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      		false,          "",      dfNone,      0,     true,      true,          	12);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "trsp_purp_rsn",       	true,          "",       dfNone,      2,     true,      true,          	1000); 
                    InitDataProperty(0, cnt++ , dtData,       90,   daLeft,    true,    "nego_rmk",      		false,          "",      dfNone,      0,     false,     false,          1000);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "trsp_so_ofc_cty_cd",   false,          "",      dfNone,      2,     false,     false,          3);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "trsp_so_seq",       	false,          "",      dfNone,      2,     false,     false,          12);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "trsp_so_tp_cd",       	false,          "",      dfNone,      0,     false,     false,     		1);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "cgo_tp_cd",       		false,          "",      dfNone,      0,     false,     false,     		1);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "eq_knd_cd",       		false,          "",      dfNone,      0,     false,     false,     		1);
					InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  true,    "trsp_otr_cost_mon_dt", false,          "",      dfNone,      0,     false,     false,     		10);

					ColHidden('ibflag')			= true;
			   }
			break;

			case 2:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(0) ;
					//전체 너비 설정
					SheetWidth = soCreationTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(34, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle = "STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc.|Door Loc.|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Fuel\nSurcharge|Over Weight\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason|Trsp So Ofc Cty Cd|Trsp So Seq|SO Type Code|Cargo Type Code|EQ Kind Code|Other Cost Month Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++,  dtCheckBox,   30,   daCenter,  true,    "ibcheck");
                    InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "eq_no",      			false,          "",      dfNone,      0,     false,      false,         15);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "eq_tpsz_cd",      		false,          "",      dfNone,      0,     false,      false,         4);

                    InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_cost_dtl_mod_cd", true,          	"",      dfNone,      0,     false,      false,         2);
                    InitDataProperty(0, cnt++ , dtData,       60,   daCenter,  true,    "trsp_crr_mod_cd",      true,          	"",      dfNone,      0,     false,      false,         2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "fm_loc_value",      	true,          	"",      dfNone,      0,     false,      false,         5);
                    InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "fm_yard_value",      	true,          	"",      dfNone,      0,     false,      false,         2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "via_loc_value",      	false,          "",      dfNone,      0,     false,      false,         5);

                    InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "via_yard_value",      	false,          "",      dfNone,      0,     false,      false,         2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "to_loc_value",      	true,          	"",      dfNone,      0,     false,      false,         5);
                    InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "to_yard_value",      	true,          	"",      dfNone,      0,     false,      false,         2);
                    InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "dr_loc_value",      	false,          "",      dfNone,      0,     false,      false,         5);
                    InitDataProperty(0, cnt++ , dtData,       30,   daCenter,  true,    "dr_yard_value",      	false,          "",      dfNone,      0,     false,      false,         2);

                    InitDataProperty(0, cnt++ , dtPopup,      90,   daCenter,  true,    "act_cust_cnt_cd",      false,          "",      dfNone,      0,     true,       true,          8);
                    InitDataProperty(0, cnt++ , dtPopup,      90,   daCenter,  true,    "dor_de_addr",      	false,          "",      dfNone,      0,     true,       true,          200);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_seq",      		true,          	"",      dfNone,      0,     false,      false,         6);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "vndr_abbr_nm",      	true,          	"",      dfNone,      0,     false,      false,         20);
					InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "curr_cd",      		false,          "",      dfNone,      0,     false,      false,         3);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "bzc_amt",      		false,          "",      dfFloat,     2,     false,      false,         13);
					InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "nego_amt",      		false,          "",      dfFloat,     2,     false,      false,         13);

                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "fuel_scg_amt",      	false,          "",      dfFloat,     2,     false,      false,         13);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "toll_fee_amt",      	false,          "",      dfFloat,     2,     false,      false,         13);
                    InitDataProperty(0, cnt++ , dtData,		  90,   daCenter,  true,    "etc_add_amt",      	false,          "",      dfNone,      2,     false,      false,         13, false,	 true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "total_amt",      		false,          "|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|toll_fee_amt|+|etc_add_amt|",      dfFloat,      2,     false,       false,          20);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bkg_no",      		false,          "",      dfNone,      0,     true,       true,          12);

                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "ref_bl_no",      		false,          "",      dfNone,      0,     true,       true,          12);
                    InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "trsp_purp_rsn",       	true,          	"",      dfNone,      2,     true,       true,          1000);
					
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "trsp_so_ofc_cty_cd",    false,          "",      dfNone,      2,     false,      false,         3);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "trsp_so_seq",       	false,          "",      dfNone,      2,     false,      false,         12);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "trsp_so_tp_cd",       	false,          "",      dfNone,      0,     false,      false,     	1);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "cgo_tp_cd",       		false,          "",      dfNone,      0,     false,      false,     	1);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "eq_knd_cd",       		false,          "",      dfNone,      0,     false,      false,     	1);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  true,    "trsp_otr_cost_mon_dt",  false,          "",      dfNone,      0,     false,      false,     	10);

					ColHidden('ibflag')			= true;
			   }
			break;

			case 3:      //sheet1 init
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable.clientWidth;

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
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'unique_cd'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_so_seq'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_full_nm'       ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_step_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt'			    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_no'			    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'ovr_wgt_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'grs_wgt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'		            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scg_amt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incur_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_no'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
				
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_bil_flg'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             ,false,"",dfNone,0,true,true);
		   }
			break;
			
		}
    }

	function gotoPreview(sheetObj,formOb)
	{
		var cty_cd = '';
		var seq_no = '';
		var vndr_seq = '';
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		var checkArray = checkList.split('|');

		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}

		for(var i=0; i<checkArray.length-1; i++)
		{
			if(i!=0){
				cty_cd += ',';
				seq_no += ',';
				vndr_seq += ',';
			}
			cty_cd += sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
			seq_no += sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
			vndr_seq += sheetObj.CellValue(checkArray[i], 'vndr_seq');
		}

		document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
		document.woForm.trsp_so_seq.value = seq_no;
		document.woForm.vndr_seq.value = vndr_seq;
		document.woForm.pgmNo.value = 'ESD_TRS_0024';
		document.woForm.trsp_so_no.value = document.form.trsp_so_no.value;
		// W/O 컨펌 시 S/O와 ofc코드가 일치하는지 확인하기 위해 전송
		document.woForm.submit();
		return;
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		try {
			switch(sAction) {

			case IBSEARCH:      //조회
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					
					formObj.f_cmd.value = SEARCH09;
					sheetObj.DoSearch4Post("ESD_TRS_0018GS.do", TrsFrmQryString(formObj));

					break;

			case IBSAVE:        //저장
				  if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}

					var sheetObj1 = sheetObjects[1];
					
					var checkList = sheetObj.FindCheckedRow('ibcheck');
					if(checkList == ''){
						ComShowCodeMessage('COM12176');
						return false;
					}
					var checkArray = checkList.split('|');

					sheetObj.RemoveEtcData();
					formObj.f_cmd.value = MODIFY;
					sheetObj.DoSave("ESD_TRS_0018GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
					break;

			case IBDOWNEXCEL:    //엑셀 다운로드
				  sheetObj.Down2Excel(-1, false, false, true);
				  break;

			case IBINSERT:      // 입력
					sheetObj.DataInsert();
					break;

			case IBDELETE:
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');

				var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESD_TRS_0018GS.do",TrsFrmQryString(formObj),'ibcheck',false);

				for(var k=checkArray.length-2; k>=0; k--)
				{
					sheetObj.RowDelete(checkArray[k], false);
				}
				break;
			}
		}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
			case IBSEARCH:      //조회
			if(	formObj.eq_no.value == '')
				{
					if (formObj.fmdate == '')
					{
						ComShowCodeMessage('COM12114', 'from date');
						formObj.fmdate.focus();
						return false;
					}else if (formObj.todate == '')
					{
						ComShowCodeMessage('COM12114', 'to date');
						formObj.todate.focus();
						return false;
					}
				}
			
				if(formObj.trs_cost_md_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Cost Mode');
					formObj.trs_cost_md_cd.focus();
					return false;
				}else if(formObj.trs_md_cd.options[0].selected)
				{
					ComShowCodeMessage('COM12114', 'Trans Mode');
					formObj.trs_md_cd.focus();
					return false;
				}
			
			break;
	}
	return true;
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	var yard_obj = null;
	var formObj = document.form;

	obj.value = obj.value.toUpperCase();

	if(obj.name == 'search_fm_loc'){
		yard_obj = document.search_fm_yard;
		if(formObj.trs_cost_md_cd.value == 'CN'){
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		}else if(formObj.trs_cost_md_cd.value == 'CF'){
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		}
	}else if(obj.name == 'search_via_loc'){
		yard_obj = document.search_via_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	}else if(obj.name == 'search_to_loc'){
		yard_obj = document.search_to_yard;
		if(formObj.trs_cost_md_cd.value == 'CN'){
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		}else if(formObj.trs_cost_md_cd.value == 'CF'){
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		}
	}else if(obj.name == 'search_dr_loc'){
		yard_obj = document.search_dr_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	}else{
		formObj.TRSP_SO_EQ_KIND.value = '';
	}
	
	var locValue = obj.value;

	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}

	if(obj.name == 'search_dr_loc') {
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}else{
		getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'search_fm_loc':
			case 'search_via_loc':
			case 'search_to_loc':
			case 'search_dr_loc':
				getComboList(obj);
				break;
		}
	}
}

/**
* 공통 Node popup
*/
function openHireYardPopup( btn_obj )
{
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_061_1";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var returnFunction = 'setFmNode';
	if(btn_obj == 'via_node') returnFunction = 'setViaNode';
	else if(btn_obj == 'to_node') returnFunction = 'setToNode';
	else if(btn_obj == 'dr_node') returnFunction = 'setDoorNode';

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;

	if(myWin != null) myWin.close();
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
* fmNode를 팝업을 통해 세팅
*/
function setFmNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_fm_loc.value = loc;
	getComboList(document.form.search_fm_loc);
	document.search_fm_yard.CODE = yard;
}

/**
* viaNode를 팝업을 통해 세팅
*/
function setViaNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_via_loc.value = loc;
	getComboList(document.form.search_via_loc);
	document.search_via_yard.CODE = yard;
}

/**
* toNode를 팝업을 통해 세팅
*/
function setToNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_to_loc.value = loc;
	getComboList(document.form.search_to_loc);
	document.search_to_yard.CODE = yard;
}

/**
* doorNode를 팝업을 통해 세팅
*/
function setDoorNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_dr_loc.value = loc;
	getComboList(document.form.search_dr_loc);
	document.search_dr_yard.CODE = yard;
}

/**
 * Additional Amount를 클릭했을때 popup창을 띄워준다.
 **/
function sheet1_OnPopupClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col);
	switch(colName) {
		case 'act_cust_cnt_cd':
		case 'dor_de_addr':
			popActualCustomer(sheetObj, document.form);
			break;
	}
}

function sheet1_OnDblClick(sheetObj, row, col)
{
	var colName = sheetObj.ColSaveName(col);
	switch(colName) {
		case 'etc_add_amt':
			popSurchargeInputInquiry(sheetObj, row, col);
			break;
	}
}

/**
* 조회조건 reset
*/
function resetForm(formObj)
{
	formObj.fmdate.value=beforeOneMonth;
	formObj.todate.value=today_1;
	formObj.trs_cost_md_cd.options[0].selected = true;
	formObj.trs_md_cd.options[0].selected = true;
	
	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	document.search_dr_yard.RemoveAll();
	formObj.eq_no.value = '';
}

/**
* COST MODE, TRANS MODE 변경시 조회조건 reset
*/
function resetSearchCondition(selObj)
{
	var formObj = document.form;

	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	document.search_dr_yard.RemoveAll();

	var costMode = formObj.trs_cost_md_cd.value;
	var tranMode = formObj.trs_md_cd.value;

	//COST MODE에 따라 조회조건 활성/불활성화를 세팅하기 위한 네종류 조건 확인
	if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 1;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 2;
	else if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 3;
	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 4;
	
	setKindEnabled();	// 조회조건 활성/불활성화

}

/**
 * COST MODE, TRANS MODE 선택에 따른 조회조건 enabled처리
 **/
function setKindEnabled()
{
	var sheetObj = sheetObjects[0];
	var obj = document.form;

	switch(ctMode)
	{
		case 1:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = true;
			document.search_via_yard.Enable = false;
			document.search_dr_yard.Enable = false;
			break;
		case 2:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = true;
			document.search_via_yard.Enable = true;
			document.search_dr_yard.Enable = false;
			break;
		case 3:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = false;
			document.search_via_yard.Enable = false;
			document.search_dr_yard.Enable = true;
			break;
		case 4:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = false;
			document.search_via_yard.Enable = true;
			document.search_dr_yard.Enable = true;
			break;
	}
}

 function getVerifyColumn(sheetObj)
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

 		if(sheetObj.CellValue(row,'isimport')=='T' && sheetObj.EtcData(eq_no) != '' &&  sheetObj.EtcData(eq_no) != undefined)
 		{
 			sheetObj.CellValue2(row, 'ibcheck') = false;
 			sheetObj.CellValue2(row, 'verify_result') = sheetObj.EtcData(eq_no);
 			sheetObj.RowBackColor(row) = sheetObj.RgbColor(238,255,226);
 			returnFlag = false;
 		}
 	}

 	return returnFlag;
 }

function setEqKindRadio(selObj)
{
	var sheetObj = sheetObjects[0];
	
	if(sheetObj.RowCount>0 && eqKindFlag != selObj.value)
	{
		if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?'))
		{
			sheetObjects[0].RemoveAll(); // cost mode 변경시 쉬트 내용 모두 삭제
			eqKindFlag = selObj.value;
			return;
		}else{
			if(eqKindFlag == 'container') document.form.eq_kind[0].checked = true;
			else if(eqKindFlag == 'chassis') document.form.eq_kind[1].checked = true;
			else if(eqKindFlag == 'genset') document.form.eq_kind[2].checked = true;
			return;
		}
	}else{
		eqKindFlag = selObj.value;
	}
}

/**
 * number check
 **/
function checkNumber(obj, delflag)
{
	if(!ComIsNumber(obj))
	{
		ComShowCodeMessage('COM12122', obj.name);
		if (delflag) obj.value = '';
	}
}

/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject = document.form;
	if(x1 == 'btn_eq_no'){
		formObject.eq_no.value = rowArray;
		checkDigit();
	}
}


function popActualCustomer(sheetObject, formObject)
{
	var myOption = "dialogWidth:800px; dialogHeight:506px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0914.screen';
	window.showModalDialog(url, window, myOption);
}

function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm)
{
	var sheetObj = sheetObjects[0];
	var row = sheetObj.SelectRow;

	sheetObj.CellValue2(row, 'act_cust_cnt_cd') = act_cust_cd;
	sheetObj.CellValue2(row, 'dor_de_addr') = factory_addr;

	winObj.close();
}

function getCalendar(){
	var cal = new ComCalendarFromTo();	
	cal.displayType = "date";
	cal.select(document.form.fmdate, document.form.todate, 'yyyy-MM-dd');
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col)
{
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'surcharge_key');
	url += '&open_mode=search';
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&sheet_arr_no=2';
	url += '&ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

//'포커스주기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

function removeBar(str) {
    var value = "";
    for ( var i = 0; i < str.length; i++ ) {
    var ch = str.charAt(i);
    if ( ch != '-' ) value = value + ch;
    }
    return value;
}

function sheet1_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;

	switch(colName)
	{
//		case('bkg_no'):
//			formObj.f_cmd.value = SEARCH13;	
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName;
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			sheetObj.CellValue2(row, 'ibcheck') = '1';
//			break;
//		case('bkg_no_split'):
//			formObj.f_cmd.value = SEARCH14;	
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName+'&bkg_no='+sheetObj.CellValue(row,'bkg_no');
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			sheetObj.CellValue2(row, 'ibcheck') = '1';
//			break;
//		case('bl_no'):
//			formObj.f_cmd.value = SEARCH15;
//			var urlStr = 'ibflag=R&'+colName+'='+value+'&row='+row+'&col='+colName;
//			sheetObj.DoRowSearch('ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj));
//			if(sheetObj.CellValue(row,col) != value){
//				ComShowCodeMessage('COM12161', value));
//				return false;
//			}
//			sheetObj.CellValue2(row, 'ibcheck') = '1';
//			break;
	}
}

/**
* Sheet의 Cell에 이벤트를 주기 위해 강제호출하는 함수-아이비시트 내장함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var costMode = formObj.trs_cost_md_cd.value;
	if (costMode=='ER'){
		var rowCount = sheetObj.RowCount;
		for(var i=1; i<rowCount+2; i++)
		{
			sheetObj.CellEditable(i, "ref_bkg_no") = false;
			sheetObj.CellEditable(i, "ref_bl_no") = false;
		}
	}
}

/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
*/
function sheet1_OnSaveEnd(sheetObj,errMsg){
	var formObj = document.form;
	if(errMsg != null && errMsg != ''){
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == MODIFY){
			ComShowCodeMessage('TRS90105');
		}
	}
}

function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.eq_no;
	}
	
	obj.value = obj.value.toUpperCase();

	if(formObj.eq_kind[0].checked){
		obj.value = multiCntrChkDgt(obj.value);
	}
}

//  blur시 데이타체크
function BlurDate(obj)
{	
	var f =  document.form;
	var dt = obj.value;
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
				ComShowCodeMessage('TRS90070');
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage('TRS90070');
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

	formObject.fmdate.value= dat;
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

	formObject.todate.value= dat;
}

//'-' 없애기
function fun_Focus_del(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

/**
 * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long}	X			X 좌표
 * @param {long}	Y			Y 좌표
 * @return
 */	
function sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
	var row = t1sheet1.MouseRow;
	var col = t1sheet1.MouseCol;
	if (t1sheet1.ColSaveName(col) == "nego_rmk" && row >= 1
			&& t1sheet1.CellValue(row, "nego_rmk") != null
			&& t1sheet1.CellValue(row, "nego_rmk") != '') {
		t1sheet1.ToolTipText(row, col) = t1sheet1.CellValue(row, "nego_rmk");
	}
}
