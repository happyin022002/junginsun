/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0019.js
*@FileTitle : SO Inquiry
*Open Issues :  
*Change history :
*@LastModifyDate : 2011.02.01
*@LastModifier : 최 선
*@LastVersion : 1.5
* 2006.11.10 조풍연
* 1.0 최초생성
*----------------------------------------------------------
* History
* 2010.09.30 이재위	1.1 [CHM-201006169] [TRS] 특수문자를 포함한 INV No. 조회 가능토록
* 2010.10.08 최 선	1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2010.11.18 최 선	1.3 [CHM-201007296] S/P 입력 후 조회시 오류 수정
* 2011.01.03 이윤정	1.4 [CHM-201007768] DMDT 관련 컬럼 추가
* 2011.02.01 최 선	1.5 [CHM-201108674] S/O Inquiry 상에서 Trans mode 선택시 node 입력란의 활성화 관련 오류정정 요청
* 2011.05.06 손은주	1.6 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.05.25 황효근	1.7	[CHM-201111072] Service Order No., Work Order No. 입력값 validation 적용
* 2011.07.11 김영철    1.8 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.07.21 손은주     1.9 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2011.11.21 이수진    2.0 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 작업
* 2011.11.30 유선오    2.1 [CHM-201114748] [TRS] S/O inquiry 상에 보이는 VVD lane 정보 칼럼 변경/추가 요청
* 2011.12.06 변종건    2.2 [CHM-201114914-01] [TRS] S/O, Invoice Inquiry table 상 칼럼 추가 요청
* 2012.10.30 김기택  [CHM-201220924 ] Reason of Node Change(CNG_RSN_DESC) 컬럼추가
* 2014.03.27 김현화 [CHM-201429546] [TRS] S/O candidate 변경 방지 로직 요청('Reason of Trans Mode/Node Change' hidden 처리)
* 2014.11.26 김현화 []'Reason of Trans Mode/Node Change' 보이도록 수정
* 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/

/**
 * @class ESD_TRS_0019 : 
 */
function ESD_TRS_0019() {
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
var prefix = 'surcharge_';

var sheetObjects = new Array();
var sheetCnt = 0;
var ctMode = 0; //COST MODE, TRANS MODE 조합, 1-단일운송,DOOR제외, 2-복합운송,DOOR제외, 3-단일운송,DOOR, 4-복합운송,DOOR

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러  */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btng_rtv_downxls":
				if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))) 
					{
						ComShowCodeMessage("TRS90124");
						return false;
					}
				}

				// office 가 없으면 VVD,BKG,BL,EQ,SO,WO,INV,COP No 중 하나는 있어야한다.
				if (ComIsNull(formObject.input_office) || ComIsEmpty(formObject.input_office)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))) 
					{
						ComShowCodeMessage("TRS90124")+"\n 'Office Code'";
						return false;
					}
				}

				var days_between = ComGetDaysBetween(formObject.from_date , formObject.to_date) ;  // 조회 기간
				var chk_usrail = formObject.chk_usrail.checked;

				if( days_between   < 0) {
					ComShowCodeMessage("TRS90118");
					formObject.from_date.focus();
					return false;
				} 
				if ( days_between > 62 ) {
					ComShowMessage(" Possible inquiry period is limited to 2 month.");
					return false;
				}

				if( chk_usrail  ){
					
					
					if ( days_between > 15 ){
						if(    ComIsNull(formObject.search_fm_loc) || ComIsEmpty(formObject.search_fm_loc) 
						    || ComIsNull(formObject.search_to_loc) || ComIsEmpty(formObject.search_to_loc)  )	{
						ComShowMessage("For USA Rail, the inquiry period is limited to 16days. \nWith From/To locations input, the limitation is extended to 1 month." );
						return false;
						}
					}
				} else {
				}


				doActionIBSheet(sheetObject,formObject,IBSEARCH, 'XLS');     // DOWN XLS 시 XLS 로.
			break;

			case "btn_retrieve":
				// W/O No. 항목 공백 제거. CHM-201431575
				removeSpace(formObject.wonumber);
				
				// DATE 가 없으면 VVD,BKG,BL,EQ,SO,WO,INV,COP No 중 하나는 있어야한다.
				if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))
						&& (ComIsNull(formObject.mtyrefnumber) || ComIsEmpty(formObject.mtyrefnumber))
						&& (ComIsNull(formObject.spot_bid_no) || ComIsEmpty(formObject.spot_bid_no))
						) 
					{
						ComShowCodeMessage("TRS90124");
						return false;
					}
				}

				// office 가 없으면 VVD,BKG,BL,EQ,SO,WO,INV,COP No 중 하나는 있어야한다.
				if (ComIsNull(formObject.input_office) || ComIsEmpty(formObject.input_office)) {
					if ( (ComIsNull(formObject.trunk_vvd) || ComIsEmpty(formObject.trunk_vvd))
						&& (ComIsNull(formObject.bkgnumber) || ComIsEmpty(formObject.bkgnumber))
						&& (ComIsNull(formObject.blnumber) || ComIsEmpty(formObject.blnumber))
						&& (ComIsNull(formObject.eqnumber) || ComIsEmpty(formObject.eqnumber))
						&& (ComIsNull(formObject.sonumber) || ComIsEmpty(formObject.sonumber))
						&& (ComIsNull(formObject.wonumber) || ComIsEmpty(formObject.wonumber))
						&& (ComIsNull(formObject.invoicenumber) || ComIsEmpty(formObject.invoicenumber))
						&& (ComIsNull(formObject.copnumber) || ComIsEmpty(formObject.copnumber))
						&& (ComIsNull(formObject.mtyrefnumber) || ComIsEmpty(formObject.mtyrefnumber))
						) 
					{
						ComShowCodeMessage("TRS90124")+"\n 'Office Code'";
						return false;
					}
				}

				var days_between = ComGetDaysBetween(formObject.from_date , formObject.to_date) ;  // 조회 기간
				var chk_usrail = formObject.chk_usrail.checked;

				if( days_between   < 0) {
					ComShowCodeMessage("TRS90118");
					formObject.from_date.focus();
					return false;
				}
				if ( days_between > 62 ) {
					ComShowMessage(" Possible inquiry period is limited to 2 month.");
					return false;
				}

				if( chk_usrail  ){
					
					
					if ( days_between > 15 ){
						if(    ComIsNull(formObject.search_fm_loc) || ComIsEmpty(formObject.search_fm_loc) 
						    || ComIsNull(formObject.search_to_loc) || ComIsEmpty(formObject.search_to_loc)  )	{
						ComShowMessage("For USA Rail, the inquiry period is limited to 16days. \nWith From/To locations input, the limitation is extended to 1 month." );
						return false;
						}
					}
				} else {
				}
				
				// 2011.05.25 [CHM-201111072] Service Order No. validation 적용
				if(!ComIsNull(formObject.sonumber) && !ComIsEmpty(formObject.sonumber)) {
					var soNums = formObject.sonumber.value;
					var arrSoNum = soNums.split(',');
					
					for(var i=0; i<arrSoNum.length; i++) {
						var soNum = arrSoNum[i];
						
						if( soNum.length < 4 || !ComIsAlphabet(soNum.substring(0,3)) || !ComIsNumber(soNum.substring(3)) ) {
							ComAlertFocus(formObject.sonumber, ComGetMsg('TRS90388', 'Service Order No.'));
							return false;
						}
					}
				}
				
				// 2011.05.25 [CHM-201111072] Work Order No. validation 적용
				if(!ComIsNull(formObject.wonumber) && !ComIsEmpty(formObject.wonumber)) {
					var woNums = formObject.wonumber.value;
					var arrWoNum = woNums.split(',');
					
					for(var i=0; i<arrWoNum.length; i++) {
						var woNum = arrWoNum[i];
						
						if( woNum.length < 4 || !ComIsAlphabet(woNum.substring(0,3)) || !ComIsNumber(woNum.substring(3)) ) {
							ComAlertFocus(formObject.wonumber, ComGetMsg('TRS90388', 'Work Order No.'));
							return false;
						}
					}
				}

				doActionIBSheet(sheetObject,formObject,IBSEARCH, 'RTV');	 // RETRIEVE 시 RTV 로..
			break;

			case "btn_reset":
				sheetObject.RemoveAll();
				document.search_fm_yard.RemoveAll();
				document.search_via_yard.RemoveAll();
				document.search_to_yard.RemoveAll();
				document.search_door_yard.RemoveAll();
				formObject.reset();
			break;
			
			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display = "none";
					sheetObject.style.height = sheetObject.GetSheetHeight(25) ;
				} else {
					document.all.MiniLayer.style.display = "";
					sheetObject.style.height = sheetObject.GetSheetHeight(15) ;
				}
			break;

			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
			break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL, "");
			break;

			case "btng_popup_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL, "");
			break;
			
			case "btng_sohistory":
				soHistory(sheetObject);
			break;

			case "btng_woissuehistory":
				woIssueHistory(sheetObject);
			break;

			case "btng_frustrate":
				setFrustrate(sheetObject);
				break;

			case "btng_wopreview":
				woPreview(sheetObject);
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

			case "btns_calendar":
				getCalendar();
			break;

			case "btng_provider":
				rep_OnPopupClick();
			break;

			case "btns_office": //M CNTR
				if( validation_check() ) {
					var ofc_cd = formObject.input_office.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
				}
				break;
				
			case "btns_user_nm":
				ComOpenPopup('/hanjin/COM_ENS_091.do', 780, 540, 'getStaffPop', '1,0,1,1,1,1,1,1',true, false);
				break;

			case "btn_close":
    	        window.close();
    	        break;


		
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
		
		sheetObjects[0].ColHidden("wo_hzd_mtrl_scg_amt") = true;
		sheetObjects[0].ColHidden("wo_ovr_wgt_scg_amt") = true;
		sheetObjects[0].ColHidden("wo_usa_ttl_amt") = true;
	
		sheetObjects[0].ColHidden("fm_dt") = true;
		sheetObjects[0].ColHidden("fm_yd") = true;
		sheetObjects[0].ColHidden("to_dt") = true;
		sheetObjects[0].ColHidden("to_yd") = true;
		sheetObjects[0].ColHidden("to_sts") = true;
		sheetObjects[0].ColHidden("mt_dt") = true;
		sheetObjects[0].ColHidden("mt_yd") = true;
		sheetObjects[0].ColHidden("web_mt_dt") = true;
		sheetObjects[0].ColHidden("grace_end") = true;

	}

	//IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
}

/* CH REPORT 에서의 팝업 설정시 수행 */
function openAspopup() {

var formObject = document.form;
var sheetObject = sheetObjects[0];

		sheetObject.style.height = sheetObject.GetSheetHeight(15) ;

/*********  타 창에서 팝업으로 Inquiry 시  ***/
formObject.hid_period.value="S";   //W/O Issue
//formObject.hid_sotype.value = "Y";

//formObject.hid_wrkofc.value = formObject.invar_ofc.value;
formObject.input_office.value = "";

formObject.hid_radio_office.value = "W";
formObject.input_office.value = formObject.invar_ofc.value;


if ( formObject.invar_bnd.value.length > 0 ) formObject.hid_boundmode.value = formObject.invar_bnd.value;
if ( formObject.invar_term.value.length > 0 ) formObject.hid_bkgterm.value = formObject.invar_term.value;
if ( formObject.invar_onlycy.value.length > 0 ) formObject.hid_onlycy.value = formObject.invar_onlycy.value;
if ( formObject.invar_trosts.value.length > 0 ) formObject.hid_trosts.value = formObject.invar_trosts.value;
if ( formObject.invar_sofmdt.value.length > 0 ) formObject.from_date.value = formObject.invar_sofmdt.value;
if ( formObject.invar_sotodt.value.length > 0 ) formObject.to_date.value = formObject.invar_sotodt.value;
if ( formObject.invar_colhd.value.length > 0 ) formObject.hid_tpsz.value = formObject.invar_colhd.value;
if ( formObject.invar_sotype.value.length > 0 ) formObject.hid_sotype.value = formObject.invar_sotype.value;
if ( formObject.invar_from_node.value.length > 0 ) formObject.hid_from_node.value = formObject.invar_from_node.value; 
if ( formObject.invar_to_node.value.length > 0 ) formObject.hid_to_node.value = formObject.invar_to_node.value; 

				if (ComIsNull(formObject.from_date) || ComIsEmpty(formObject.to_date)) {
						ComShowCodeMessage("TRS90124");
						return false;
				}

				if(ComGetDaysBetween(formObject.from_date , formObject.to_date) < 0) {
					ComShowCodeMessage("TRS90118");
					return false;
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH, 'RTV');	 // RETRIEVE 시 RTV 로..

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
				sheetObj.SpeedOption="NOFIT, NOSUM, NOCALC, NOROWHEIGHT, NOTRIM, NOCOMBO";	//IB SHEET 성능개선 20090827 김진
				// 높이 설정
				style.height = GetSheetHeight(15) ;
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
				InitColumnInfo(187, 7 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Status||Seq.|EQ No.|TP/SZ|Org TP/SZ|Cost\nMode|Trans\nMode|S/O TP|Unplanned|Pre-Pull|CB|Frustrated|Block Stowage|S/O No.|S/O CRE DT|S/O DEL|" +
//				"S/O DEL DT|S/O UPD Name|W/O No.|W/O Iss STS|W/O Iss WK|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS Name|CNT(Agreement)|CNT(Agreement)|CNT(CNT Approval)|CNT(CNT Approval)|CNT(CNT Approval)|From|Via|To|" +
				"S/O DEL DT|S/O UPD Name|W/O No.|W/O Iss STS|W/O Iss WK|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS Name|CNT(Agreement)|CNT(CNT Approval)|CNT(CNT Approval)|CNT(CNT Approval)|From|Via|To|" +
				"Door|Distance|Distance|Spot|Spot|Spot|Spot|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Web D/O|Web D/O|Web D/O|W/O S/P|W/O S/P|Parent S/P|Parent S/P|W/O RCV DT|Appt. Time|Deliv. Time|Feeder Term|Feeder Term|" +
//				"3rd Party|Cost OFC|Rate Type|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Calculation\nLogic|" +
				"3rd Party|Cost OFC|Rate Type|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Calculation\nLogic|" +
				"Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Invoice S/P|Invoice S/P|Invoice No.|INV STS|INV CNFM\nDT|CSR No.|INV I/F DT|" +
				"INV OFC|INV User|Invoice Remark|Estimated Time|Estimated Time|Estimated Time|Estimated Time|COP No.|A/G SEQ|A/G Code|BKG No.|BL No.|BND|Term|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|TRO Information|BKG QTY|POR|POL|POD|DEL|" +
				"T.VVD|Lane|In VVD|In VVD Lane|Out VVD|Out VVD Lane|CGO TP|CNTR SPE|Used|L/T|I.Exit|L/T EXP|Seal No.1|Seal No.2|" +
				"Weight(KGS)|Weight(LBS)|No of PKG|PKG CD|Commodity DESC|C.LOC|USA Last City|F|O|C|IT No|" +
				"Pickup No.|PU Yard|Available DT|Last Free DT|S/C No.|RFA No.|Contract Customer Name|Door SVC TP|Pickup CNTR|Shipper|Consignee|Notify|Ref.BKG No|" +
				"Ref.BL No|Outgate Date|Ingate Date|MTY Reference No|Reason|Internal\nRemark|Nego. Remark|Reason of\nNode Change|Special Instruction|W/O Instruction|CHZ Bundle|Supplement Kind|" +
				"From(ID)|From(ID)|To|To|To|MT Info.|MT Info.|WEB M'ty|Grace End|GP ID|GP Seq.|ETS|HJL Handling Fee||||||" ; 

				var HeadTitle1 = "Status||Seq.|EQ No.|TP/SZ|Org TP/SZ|Cost\nMode|Trans\nMode|S/O TP|Unplanned|Pre-Pull|CB|Frustrated|Block Stowage|S/O No.|S/O CRE DT|S/O DEL|" +
//				"S/O DEL DT|S/O UPD Name|W/O No.|W/O Iss STS|W/O Iss WK|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS Name|Flag|Type|Flag|Type|Count|From|Via|To|" +
				"S/O DEL DT|S/O UPD Name|W/O No.|W/O Iss STS|W/O Iss WK|W/O Iss DT|W/O ISS TP|W/O ISS OFC|W/O ISS Name|Flag|Flag|Type|Count|From|Via|To|" +
				"Door|Km|R.Link|Bid|Bid No|Due Date|Due Date|Actual Customer|Factory Name|Zip Code|Address|TEL|FAX|PIC|User Info|Time|Time|Code|Name|Code|Name|W/O RCV DT|Appt. Time|Deliv. Time|Receiving|Delivery|" +
//				"3rd Party|Cost OFC|Rate Type|Currency|Basic|Negotiated|Fuel|VAT|Toll Fee|Additional|HZD|OVR|Usa Rail Surcharge|Total|W/O Amount Total(USD)|Exchange\nRate|Calculation\nLogic|" +
				"3rd Party|Cost OFC|Rate Type|CNT Type|Currency|Basic|Negotiated|Fuel|VAT|Toll Fee|Additional|HZD|OVR|Usa Rail Surcharge|Total|W/O Amount Total(USD)|Exchange\nRate|Calculation\nLogic|" +
				"Currency|Basic|Surcharge|Total|Invoice Amount Total(USD)|Code|Name|Invoice No.|INV STS|INV CNFM\nDT|CSR No.|INV I/F DT|" +
				"INV OFC|INV User|Invoice Remark|From Departure|To Arrival|Door Arrival|TRO Door Date|COP No.|A/G SEQ|A/G Code|BKG No.|BL No.|BND|Term|SEQ|CNFM|Office|User ID|Confirm Time|T1 Document|Rev Curr|Rev Amt|Manifested|Load Ref No|BKG QTY|POR|POL|POD|DEL|" +
				"T.VVD|Lane|In VVD|In VVD Lane|Out VVD|Out VVD Lane|CGO TP|CNTR SPE|Used|L/T|I.Exit|L/T EXP|Seal No.1|Seal No.2|" +
				"Weight(KGS)|Weight(LBS)|No of PKG|PKG CD|Commodity DESC|C.LOC|USA Last City|F|O|C|IT No|" +
				"Pickup No.|PU Yard|Available DT|Last Free DT|S/C No.|RFA No.|Contract Customer Name|Door SVC TP|Pickup CNTR|Shipper|Consignee|Notify|Ref.BKG No|" +
				"Ref.BL No|Outgate Date|Ingate Date|MTY Reference No|Reason|Internal\nRemark|Nego. Remark|Reason of\nNode Change|Special Instruction|W/O Instruction|CHZ Bundle|Supplement Kind|" +
				"Date|Yard|Date|Yard|Status|Date|Yard|WEB M'ty|Grace End|GP ID|GP Seq.|ETS|HJL Handling Fee||||||" ;
                          
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  	false,   "ibflag",				false,      	"",		  dfNone,		   0,	  true,		   true,		0,		false,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtCheckBox,		30,    daCenter,   	true,    "part",				false);
				InitDataProperty(0, cnt++ , dtSeq,			30,    daCenter,   	true,    " ",					false,      	"",		  dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			80,    daCenter,   	true,    "eq_no",				false,      	"",		  dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			40,    daCenter,   	true,    "eq_tpsz",				false,      	"",		  dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70,    daCenter,   	true,    "org_eq_tpsz",			false,      	"",		  dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			50,    daCenter,   	true,    "trsp_cost_dtl_mod_cd",false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			50,    daCenter,   	true,    "trsp_crr_mod_cd",     false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70,    daCenter,  	true,    "trsp_so_tp_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			65,    daCenter,   	true,    "upln_so_flg",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			60,    daCenter,   	true,    "pre_pull_flg",     	false,          "",       dfNone,          0,     false,       false); //20121031
				InitDataProperty(0, cnt++ , dtData,			30,    daCenter,   	true,    "bkg_cntr_cmb_seq",    false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			70,    daCenter,   	true,    "trsp_frst_flg",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			100,   daCenter,   	true,    "blck_stwg",  			false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,			90,    daCenter,   	true,    "so_no",     			false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,			110,   daCenter,   	true,    "so_cre_dt1",     		false,          "",       dfUserFormat2 ,  0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,			60,    daCenter,   	true,    "so_del_flg",     		false,          "",       dfNone,          0,     false,       false);
                    
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "so_del_dt",     		false,          "",       dfUserFormat2,   0,     false,       false);
		 	//  InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   true,     "upd_usr_id",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		90,    daCenter,   	true,    "upd_usr_nm",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "wo_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		80,   daCenter,   	true,    "wo_iss_sts_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,   	true,    "wo_iss_wk",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "wo_iss_dt",     		false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "wo_iss_tp",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "wo_iss_ofc_cd",     	false,          "",       dfNone,          0,     false,       false);
			//	InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   true,     "wo_iss_id",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		90,    daCenter,   	true,    "wo_iss_nm",     		false,          "",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++, dtHidden,   		50,    daCenter,    true, 	 "agmt_cnt_flg", 		false, 			"",	 	  dfEngUpKey, 		1, 	  false, 	   false, 5);
//				InitDataProperty(0, cnt++, dtData,   		60,    daCenter,    true, 	 "agmt_cnt_tp_cd", 		false, 			"", 	  dfEngUpKey, 		1, 	  false, 	   false, 5);
				InitDataProperty(0, cnt++, dtHidden,   		50,    daCenter,    true, 	 "cnt_flg", 			false, 			"",	 	  dfEngUpKey, 		1, 	  false, 	   false, 5);
				InitDataProperty(0, cnt++, dtHidden,   		50,    daCenter,    true, 	 "cnt_tp_cd", 			false, 			"", 	  dfEngUpKey, 		1, 	  false, 	   false, 5);
				InitDataProperty(0, cnt++, dtHidden,  		50,     daRight,    true, 	 "ctrt_cnt", 			false, 			"", 	  dfEngUpKey, 		1, 	   true,  	   true,  5);

				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "fm_nod_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "via_nod_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "to_nod_cd",     		false,          "",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "door",     			false,          "",       dfNone,          0,     false,       false);
				
				//2012.06.01 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData,  		60,    daRight,    	true, 	 "ttl_dist", 			false, 			"", 	  dfInteger, 	   1, 	  false, 	   false);
				InitDataProperty(0, cnt++, dtData,  		50,    daCenter,   	true, 	 "lnk_dist_div_cd", 	false, 			"", 	  dfNone, 		   1, 	  false, 	   false);
				
				//2015.08.20 Add Spot Bidding column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData, 			30,    daCenter, 	true, 	 "spot_bid_flg", 		false, 			"", 	  dfNone,    		1, 	  false,  	   false);
				InitDataProperty(0, cnt++, dtData, 			120,   daCenter, 	true, 	 "spot_bid_no", 		false, 			"", 	  dfNone, 	  		1,    false,  	   false);
				InitDataProperty(0, cnt++, dtData, 			80,    daCenter, 	true, 	 "spot_bid_due_dt", 	false, 			"",       dfDateYmd, 		1,    false, 	   false);
				InitDataProperty(0, cnt++, dtData, 			60,    daCenter, 	true, 	 "spot_bid_due_dt_hms", false, 			"", 	  dfTimeHms, 		1,    false, 	   false);
				
				InitDataProperty(0, cnt++ , dtData,  		100,   daLeft,     	true,    "door_act_cust",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daLeft,     	true,    "door_fctry_nm",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daLeft,     	true,    "door_zip",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		140,   daLeft,     	true,    "dor_de_addr",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daLeft,     	true,    "door_tel",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daLeft,     	true,    "door_fax",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daLeft,     	true,    "door_pic",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daLeft,     	true,    "usa_do_usr_info", 	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "do_cre_date",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "do_cre_time",     	false,          "",       dfNone,          0,     false,       false);
//				InitDataProperty(0, cnt++ , dtData,  		50,    daCenter,   	true,    "vndr_tp_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "vndr_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		120,   daLeft,     	true,    "vndr_abbr_nm",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		70,    daCenter,   	true,    "pvndr_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		120,   daLeft,     	true,    "pvndr_nm",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "wo_rcv_dt",     		false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "appt_time",     		false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "deliv_time",     		false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,   	true,    "wtr_rcv_term_cd",     false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,   	true,    "wtr_de_term_cd",     	false,          "",       dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtPopup, 		70,    daCenter,   	true,    "n3pty_bil_flg",     	false,          "",       dfNone,          0,     true,        false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "cost_ofc_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "trsp_agmt_wy_tp_nm",  false,          "",       dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "agmt_cnt_tp_cd", 		false,          "",       dfNone,          0,     false,       false);				
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "wo_curr_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daRight,    	true,    "wo_bzc_amt",     		false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_nego_amt",     	false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_fuel_scg_amt",     false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_vat_scg_amt",     	false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_toll_fee_amt",     false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtPopup,  		90,    daRight,    	true,    "wo_etc_add_amt",     	false,          "",       dfNullFloat,     2,     true,        false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_hzd_mtrl_scg_amt", false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_ovr_wgt_scg_amt",  false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_usa_ttl_amt",     	false,          "",       dfNullFloat,     2,     false,       false);					
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_tot_amt",     		false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "wo_tot_amt_usd",     	false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daRight,    	true,    "inv_xch_rt",     		false,          "",       dfNone,          2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daLeft,     	true,    "inv_calc_lgc_tp_cd",  false,          "",       dfNone,          2,     false,       false);
                    
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "inv_curr_cd",     	false,          "",       dfNone,          0,     false,       false);                    
				InitDataProperty(0, cnt++ , dtData,   		70,    daRight,    	true,    "inv_bzc_amt",     	false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtPopup,   		80,    daRight,    	true,    "inv_etc_add_amt",     false,          "",       dfNullFloat,     2,     true,        false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daRight,    	true,    "inv_tot_amt",     	false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		145,   daRight,    	true,    "inv_tot_amt_usd",     false,          "",       dfNullFloat,     2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		70,    daCenter,   	true,    "inv_vndr_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		130,   daLeft,     	true,    "inv_vndr_nm",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		80,    daCenter,   	true,    "inv_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "inv_sts_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "inv_cfm_dt",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		130,   daCenter,   	true,    "car_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		110,   daCenter,   	true,    "inv_if_dt",     		false,          "",       dfUserFormat2,   0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "inv_cfm_ofc_cd",     	false,          "",       dfNone,          0,     false,       false);
			//  InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   true,     "inv_cre_usr_id",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "inv_cre_usr_nm",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		150,   daLeft,     	true,    "inv_rmk",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "n1st_nod_pln_dt",     false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "lst_nod_pln_dt",     	false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "dor_nod_pln_dt",     	false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		110,   daCenter,   	true,    "dor_arr_dt",     		false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "cop_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "ag_seq",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "ag_code",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "bkg_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "bl_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "trsp_bnd_cd",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "term",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "tro_seq",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "tro_cnfm",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "tro_cfm_ofc",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "tro_cfm_usr",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "tro_cfm_upd",     	false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "t1_doc_flg",	     	false,          "",       dfNone,   	   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		65,    daCenter,   	true,    "tro_rev_cur",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "eur_tro_rev",     	false,          "",       dfNullFloat,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "manifested",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "tro_lod_ref",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "bkg_qty",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "por_cd",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "pol_cd",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "pod_cd",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "del_cd",     			false,          "",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "t_vvd",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "slan_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "ib_vvd_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "ib_slan_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "ob_vvd_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		85,    daCenter,   	true,    "ob_slan_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "cgo_tp_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtPopup,   		70,    daCenter,   	true,    "bkg_spe",     		false,          "",       dfNone,          0,     true,        false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "used",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		40,    daCenter,   	true,    "lt",     				false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		50,    daCenter,   	true,    "i_exit",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "lt_exp",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "seal_no",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,   	true,    "seal_no2",     		false,          "",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "weight_kgs",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "weight_lbs",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "no_pkg",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "pkg_cd",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		120,    daLeft,    	true,    "cmdt_nm",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "c_loc",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "usa_last_city",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		30,    daCenter,   	true,    "f",     				false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		30,    daCenter,   	true,    "o",     				false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		30,    daCenter,   	true,    "c",     				false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "it_no",     			false,          "",       dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,   		70,    daCenter,  	true,    "pickup_no",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,   	true,    "pu_yard_cd",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		110,    daCenter,   true,    "available_dt",     	false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		110,    daCenter,   true,    "last_free_dt",     	false,          "",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "sc_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,   	true,    "rfa_no",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 		170,   daLeft,      true,    "ctrc_cust_nm",     	false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daLeft,   	true,    "door_svc_tp",     	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "pkup_cntr",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daLeft,   	true,    "shipper",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daLeft,   	true,    "consignee",     		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		90,    daLeft,   	true,    "notify",     			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "ref_bkg_no",     		false,      	"",       dfNone,          0,     false,       false);

				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "ref_bl_no",     		false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,   	true,    "org_gate_out_dt",     false,      	"",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		100,   daCenter,  	true,    "dest_gate_in_dt",     false,      	"",       dfUserFormat2,   0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,  		110,   daCenter,   	true,    "mty_ref_id",     		false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,   	true,    "trsp_purp_rsn",     	false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		80,    daLeft,   	true,    "inter_rmk",     		false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		100,    daLeft,   	true,    "nego_rmk",     		false,      	"",       dfNone,          0,     false,       false);
				//2012.10.30 [CHM-201220924 ] Reason of Node Change(CNG_RSN_DESC) 컬럼추가
				InitDataProperty(0, cnt++ , dtData,   		110,   daLeft,   	true,    "cng_rsn_desc",      	false,      	"",       dfNone,          0,     false,       false); //2014.03.27
				InitDataProperty(0, cnt++ , dtData,   		110,   daLeft,   	true,    "spcl_instr_rmk",    	false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		110,   daLeft,     	true,    "wo_instr_rmk",      	false,      	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daLeft,     	true,    "chz_bundle_seq",	  	false,			"",		  dfNone,		   0,     false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daLeft,     	true,    "trsp_spl_so_tp_cd", 	false,			"",		  dfNone,		   0,     false,	   false,		100,		false,		false,	   "",	  false);

				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "fm_dt",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "fm_yd",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "to_dt",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "to_yd",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "to_sts",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "mt_dt",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "mt_yd",				false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "web_mt_dt",			false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,    true,    "grace_end",			false,			"",		  dfNone,		   0,      false,	   false,		100,		false,		false,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,    		120,   daCenter,  	true,    "mcntr_bdl_grp_seq",	false,			"",		  dfNone,		   0,	   false,	   false,		  5, 		false, 		true);	
				InitDataProperty(0, cnt++ , dtData,     	80,    daCenter,  	true,    "mcntr_bdl_seq",		false,			"",		  dfNone,		   0,	   false,	   false,		  5, 		false, 		true);
				InitDataProperty(0, cnt++ , dtData, 		40,    daCenter,    true,    "hjl_no",     			false,      	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtData,   		100,    daRight,    true,    "wo_hjl_hndl_amt",     false,      	"",       dfNullFloat,     2,      false,      false);
				
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "trsp_so_ofc_cty_cd", 	false,      	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "trsp_so_seq",     	false,      	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "vndr_seq",     		false,      	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "trsp_wo_ofc_cty_cd",  false,     	 	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "trsp_wo_seq",     	false,      	"",       dfNone,          0,      false,      false);
				InitDataProperty(0, cnt++ , dtHidden, 		110,   	daLeft,     true,    "conti_cd",     		false,      	"",       dfNone,          0,      false,      false);

				InitUserFormat2(0, "so_cre_dt1", 		"####-##-## ##:##:##", "-|:" ); 
				InitUserFormat2(0, "so_del_dt", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "wo_iss_dt", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "appt_time", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "deliv_time", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "inv_if_dt", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "available_dt", 		"####-##-##", "-|:" );
				InitUserFormat2(0, "last_free_dt", 		"####-##-##", "-|:" );
				InitUserFormat2(0, "wo_rcv_dt", 		"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "org_gate_out_dt", 	"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "dest_gate_in_dt", 	"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "tro_cfm_upd", 		"####-##-## ##:##:##", "-|:" );
				

				InitUserFormat2(0, "n1st_nod_pln_dt", 	"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "lst_nod_pln_dt", 	"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "dor_nod_pln_dt", 	"####-##-## ##:##:##", "-|:" );
				InitUserFormat2(0, "dor_arr_dt", 		"####-##-## ##:##:##", "-|:" );
				
				HeadRowHeight = 21;
				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
			}
		break;

		case 2: //surcharge sheet
				with (sheetObj) {
				
				sheetObj.SpeedOption="NOFIT, NOSUM, NOSEQ, NOCALC, NOMERGEROW, NOROWHEIGHT, NOCOMBO, NOTRIM";	//IB SHEET 성능개선 20090827 김진
				// 높이 설정
				style.height = 0;
//				//전체 너비 설정
				SheetWidth = 0;

//				style.height = GetSheetHeight(13);
//				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;

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

				var HeadTitle = "ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"ibcheck");
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'unique_cd'					,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'trsp_so_seq'            	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'lgs_cost_cd'            	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'lgs_cost_full_nm'       	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'trsp_step_tp_cd'        	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scg_amt'                	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_mgst_tpsz_cd'      	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_hndl_flg'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_mgst_usg_flg'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'          		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'grs_wgt'                	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'tri_axl_flg'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_otr_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'ovr_wgt_rmk'				,false,"",dfNone,0,true,true);
				
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
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_grs_wgt'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'					,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'n3pty_bil_flg'          	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'cust_cnt_cd'            	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'cust_seq'               	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'n3pty_vndr_seq'         	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'n3pty_ofc_cd'           	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'n3pty_amt'              	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'n3pty_desc'             	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'cre_ofc_cd'             	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'cre_usr_id'             	,false,"",dfNone,0,true,true);
				
		   }
		   break;
	    
		case 3:
			with (sheetObj) {
            // 높이 설정
            style.height = 0 ;
            //전체 너비 설정
            SheetWidth = 0;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 5000);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)
            
            var HeadTitle = "Seq|Office|User Code|Name|EMAIL" ;

            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, false);

            //데이터속성    [ROW,      COL,            DATATYPE, WIDTH,   DATAALIGN, COLMERGE,     SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  	false,    "",              	false,          "",       dfNone,     0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  	false,    "ofc_cd",        	false,          "",       dfNone,     0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,      70,    daLeft,  	false,    "usr_id",    		false,          "",       dfNone,     0,     false,       false);
            InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  	false,    "usr_nm",        	false,          "",       dfNone,     0,     false,       false);
            InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  	false,    "usr_eml",        false,          "",       dfNone,     0,     false,       false);
        }
		break;
	
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, obj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if( formObj.opener.value != 'chreport' ) {
				//search_node_mode();
				if(document.search_fm_yard.Code != '' || formObj.search_fm_loc.value != '') {
					formObj.hid_from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
				}else{
					formObj.hid_from_node.value = '';
				}
				if(document.search_via_yard.Code != '' || formObj.search_via_loc.value != '') {
					formObj.hid_via_node.value = formObj.search_via_loc.value+document.search_via_yard.Code;
				}else{
					formObj.hid_via_node.value = '';
				}
				if(document.search_to_yard.Code != '' || formObj.search_to_loc.value != '') {
					formObj.hid_to_node.value = formObj.search_to_loc.value+document.search_to_yard.Code;
				}else{
					formObj.hid_to_node.value = '';
				}
				if(document.search_door_yard.Code != '' || formObj.search_door_loc.value != '') {
					formObj.hid_door_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;
				}else{
					formObj.hid_door_node.value = '';
				}

			var sp_tp =  checkParaminput(formObj.sp_tp);

			}  // chreport 팝업시 안 읽음.				

			formObj.hid_from_date.value = removeBar(formObj.from_date.value);
			formObj.hid_to_date.value = removeBar(formObj.to_date.value);
			formObj.hid_provider.value = formObj.combo_svc_provider.value;

			formObj.hid_provider_type.value = sp_tp;

			formObj.f_cmd.value = SEARCH01;

			if(obj == "RTV" ) {    //  Retrieve 시
				//sheetObj.DoSearch4Post("ESD_TRS_0019GS.do", TrsFrmQryString(formObj));
			    formObj.hid_grid_flg.value = 'Y';
				IBS_DoSearchSax(sheetObj, "ESD_TRS_0019GS.do", TrsFrmQryString(formObj));
			} else if (obj == "XLS") {    // DOWN XLS 시 
				ComOpenWait(true);
			    formObj.hid_grid_flg.value = 'N';
			    formObj.f_cmd.value = SEARCH03;
			    formObj.target = "_blank"
				formObj.action = "ESD_TRS_0205.do";
			    formObj.submit();
			    ComOpenWait(false);
			}

		break;

		case IBDOWNEXCEL:        // excel down
			sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

function sheet1_OnChange( sheetObj , row , col, value) {

/* 기능 제거. 20071127. 지연
	if ( sheetObj.ColSaveName(col) == "part") {
		woNo = sheetObj.CellValue(row , "wo_no");
		if (woNo == "") {
			sheetObj.CellValue2(row , "part") = "0";
			return;
		}
		dupRow = sheetObj.findText("wo_no" , woNo , sheetObj.HeadRows);
		while( dupRow != -1) {
			sheetObj.CellValue2( dupRow , "part") = value;
			dupRow = sheetObj.findText("wo_no" , woNo , parseInt(dupRow)+1);
		}
	}
*/


}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {	 
	if ( sheetObj.SearchRows > 1999 ){   // 2000 Row 넘는 부분에 대해서는 메시지 출력.
		ComShowCodeMessage("TRS90362");
	}
}

function sheet1_OnSaveEnd(sheetObj,errMsg) {
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{

// FRUSTRATE 수행 후 ..
		var checkList = sheetObj.FindCheckedRow('part');
		var checkArray = checkList.split('|');

		if(formObj.f_cmd.value == MULTI01){
			for(var i=0; i<checkArray.length-1; i++)	{
				sheetObj.CellValue2(checkArray[i], 'trsp_frst_flg')='Y';
				sheetObj.CellValue2(checkArray[i], 'upd_usr_id')= formObj.upd_usr_id.value  ;

			}
			ComShowCodeMessage('COM12156', 'Frustrate');
		}
	}

}


function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{

		case('n3pty_bil_flg'):
			var trsp_so_tp_cd = sheetObj.CellValue(row, "trsp_so_tp_cd");
		    if (trsp_so_tp_cd == "Domestic") {
		    	return;
		    }
			pop3rdPartyBilling(sheetObj, row, col, 'search');
		break;

		case('wo_etc_add_amt'):
			var trsp_so_tp_cd = sheetObj.CellValue(row, "trsp_so_tp_cd");
			if (trsp_so_tp_cd == "Domestic") {
				return;
			}
			popSurchargeInputInquiry(sheetObj, row, col, 'search','WO');
		break;


		case('inv_etc_add_amt'):
			popSurchargeInputInquiry(sheetObj, row, col, 'search','IV');
		break;

		case('bkg_spe'):
			var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
			var lvbkg = sheetObj.CellValue(row, "bkg_no");
			var lveqno = sheetObj.CellValue(row, "eq_no");
			var lvtro_seq = sheetObj.CellValue(row, "tro_seq");
			var lvui_conti_cd = sheetObj.CellValue(row, "conti_cd");

			if( sheetObj.CellValue(row, "bkg_spe") == 'DG' ) {
				var url = "ESD_TRS_0938Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "bkg_spe") == 'BB' ) {
				var url = "ESD_TRS_0937Pop.do?bkg_no="+lvbkg;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "bkg_spe") == 'AK' ) {
				var url = "ESD_TRS_0936Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "bkg_spe") == 'RF' ) {
				var url = "ESD_TRS_0935Pop.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			}
		break;
		
		case('ctrt_cnt'):
			var myOption = "dialogWidth:450px; dialogHeight:360px; help:no; status:no; resizable:no; scroll=no;";
			var url = "";
		    var sc_no  = sheetObj.CellValue(row,"sc_no");
		    var rfa_no = sheetObj.CellValue(row,"rfa_no");
		    var vndr_seq = sheetObj.CellValue(row,"vndr_seq");
		    var trsp_bnd_cd = sheetObj.CellValue(row,"trsp_bnd_cd");
		    var fm_nod_cd   = sheetObj.CellValue(row,"fm_nod_cd").substr(0, 5);
		    var fm_nod_yard = sheetObj.CellValue(row,"fm_nod_cd").substr(5, 2);
		    var to_nod_cd   = sheetObj.CellValue(row,"to_nod_cd").substr(0, 5);
		    var to_nod_yard = sheetObj.CellValue(row,"to_nod_cd").substr(5, 2);
		    var dor_nod_cd  = sheetObj.CellValue(row,"door").substr(0, 5);
		    var dor_nod_yard = sheetObj.CellValue(row,"door").substr(5, 2);
		    var ctrl_ofc_cd  = document.form.input_office.value;

			if(sheetObj.CellValue(row,"ctrt_cnt") !="0"){
				url="ESD_TRS_0980.do"
				   +"?sc_no="+sc_no
				   +"&rfa_no="+rfa_no
				   +"&trsp_bnd_cd="+trsp_bnd_cd
				   +"&ctrl_ofc_cd="+ctrl_ofc_cd
				   +"&fm_nod_cd="+fm_nod_cd
				   +"&fm_nod_yard="+fm_nod_yard
				   +"&to_nod_cd="+to_nod_cd
				   +"&to_nod_yard="+fm_nod_yard
				   +"&dor_nod_cd="+dor_nod_cd
				   +"&dor_nod_yard="+dor_nod_yard
				   +"&chk_row="+row+"|"
				   +"&vndr_seq="
				   +"&scrn_mode=S"
				   ;
				window.showModalDialog(url, window, myOption);			
			}
		break;
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

//'포커스주기
function fun_Focus(obj){
	//var val = removeBar(obj.value);
	//obj.value = val;
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
function commaadd(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++ ) {
		var ch = str.charAt(i);
		if ( ch == ',' ){
			value = value + "','";
		}else{
			value = value + ch;
		}
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
function BlurDate(obj) {
	var f =  document.form;
	var dt = obj.value;
	if( dt == ""){
	} else {
		if ( isValidDate(dt)) {
			if( dt.length == 8 ) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage("TRS90070");
		obj.select();
		obj.focus();
		return;
	}
}

// 유효 날짜 체크(2)
function isValidDate(date) {
	var year = date.substring(0,4);
	var month = date.substring(4,6);
	var day = date.substring(6,8);

	if (isDatecheck(year, month, day) ) {
		return true;
	} else {
		return false;
	}
}
	   
// 유효 날짜 체크(1)
function isDatecheck( year,month,day ) {
	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
		return true;
	} else {
		return false;
	}
}

// 월 체크
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12 ) {
		return true;
	} else {
		return false;
	}
}

// 유효 날짜 체크
function checkDay( yyyy, mm, dd ) {
	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	var im = parseInt(mm,10) - 1;
	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
		monthDD[1] = 29;
	}
	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
		return false;
	} else {
		return true;
	}
}

//날자포맷으로 yyyy-mm-dd
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}

//날자포맷으로 yyyy-mm-dd
function addBar_from(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.from_date.value= dat;
}

//날자포맷으로 yyyy-mm-dd
function addBar_to(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;

	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.to_date.value= dat;
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
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	formObject.TRSP_SO_EQ_KIND.value = "A";
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
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;
	formObj.TRSP_SO_EQ_KIND.value = "";

	for (var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}
	if(charval!="Y") {
		var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	if( lvobj == "" ) {
		obj.value = "";
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_via_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_to_loc') yard_obj = document.search_to_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

		var locValue = obj.value;
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
//	}else if( lvobj.length != 5 ) {
//		ComShowCodeMessage("TRS90074");
//		if(sep=="F"){
//			formObj.search_fm_loc.select();
//			formObj.search_fm_loc.focus();
//		}else if(sep=="V"){
//			formObj.search_via_loc.select();
//			formObj.search_via_loc.focus();
//		}else if(sep=="T"){
//			formObj.search_to_loc.select();
//			formObj.search_to_loc.focus();
//		}else if(sep=="D"){
//			formObj.search_door_loc.select();
//			formObj.search_door_loc.focus();
//		}
	}else{
		if( sep == 'F' ) {
			formObj.TRSP_SO_EQ_KIND.value = "A";
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'V' ){
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'T' ){
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
		comObj.focus();
	}
}

/**
 * vvd팝업호출
 */
function vvd_OnPopupClick() {
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
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[7];
		var x1=document.form.trunk_vvd.value;

		if(x1==""){
			document.form.trunk_vvd.value = colArray2;
			formObject.trunk_vvd.focus();
		} else {
			document.form.trunk_vvd.value = document.form.trunk_vvd.value+","+colArray2;
			formObject.trunk_vvd.focus();
		}
	}
}

/**
 * 팝업호출
 */
function so_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var title = val;
	if (val == "sw" ) {
		if(formObject.radio_gubun[0].checked)  {
			title = "S/O No.";
		} else {
			title = "W/O No.";
		}
	}
	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}
	  
	  

	  
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	
	if(returnval=="T.VVD") {
		var x1=document.form.trunk_vvd.value;
		if(x1==""){
			document.form.trunk_vvd.value = rowArray;
			formObject.trunk_vvd.focus();
		}else{
			document.form.trunk_vvd.value = document.form.trunk_vvd.value+","+rowArray;
			formObject.trunk_vvd.focus();
		}
	}else if(returnval=="Booking No."){
		var x2=document.form.bkgnumber.value;
		if(x2==""){
			document.form.bkgnumber.value = rowArray;
			formObject.bkgnumber.focus();
		}else{
			document.form.bkgnumber.value = document.form.bkgnumber.value+","+rowArray;
			formObject.bkgnumber.focus();
		}
	}else if(returnval=="B/L No."){
		var x3=document.form.blnumber.value;
		if(x3==""){
			document.form.blnumber.value = rowArray;
			formObject.blnumber.focus();
		}else{
			document.form.blnumber.value = document.form.blnumber.value+","+rowArray;
			formObject.blnumber.focus();
		}
	}else if(returnval=="EQ No."){
		var x4=document.form.eqnumber.value;
 
		if(x4==""){

			document.form.eqnumber.value = rowArray;
			formObject.eqnumber.focus();
		}else{
		    document.form.eqnumber.value = document.form.eqnumber.value+","+rowArray;
			formObject.eqnumber.focus();
		}
  		if ( formObject.radio_eq[0].checked == true ) {
			document.form.eqnumber.value = multiCntrChkDgt(document.form.eqnumber.value);
	}		
	}else if(returnval=="SO No."){
		var x5=document.form.sonumber.value;
		if(x5==""){
			document.form.sonumber.value = rowArray;
			formObject.sonumber.focus();
		}else{
			document.form.sonumber.value = document.form.sonumber.value+","+rowArray;
			formObject.sonumber.focus();
		}
	}else if(returnval=="WO No."){
		var x5=document.form.wonumber.value;
		if(x5==""){
			document.form.wonumber.value = rowArray;
			formObject.wonumber.focus();
		}else{
			document.form.wonumber.value = document.form.wonumber.value+","+rowArray;
			formObject.wonumber.focus();
		}
	}else if(returnval=="Invoice No."){
		var x6=document.form.invoicenumber.value;
		if(x6==""){
			document.form.invoicenumber.value = rowArray;
			formObject.invoicenumber.focus();
		}else{
			document.form.invoicenumber.value = document.form.invoicenumber.value+","+rowArray;
			formObject.invoicenumber.focus();
		}
	}else if(returnval=="MTY REF No."){
		var x6=document.form.mtyrefnumber.value;
		if(x6==""){
			document.form.mtyrefnumber.value = rowArray;
			formObject.mtyrefnumber.focus();
		}else{
			document.form.mtyrefnumber.value = document.form.mtyrefnumber.value+","+rowArray;
			formObject.mtyrefnumber.focus();
		}
	}else if(returnval=="COP No."){
		var x6=document.form.copnumber.value;
		if(x6==""){
			document.form.copnumber.value = rowArray;
			formObject.copnumber.focus();
		}else{
			document.form.copnumber.value = document.form.copnumber.value+","+rowArray;
			formObject.copnumber.focus();
		}
	}else if(returnval=="ZIP Code"){

		var x5=document.form.zip_code.value;
		if(x5==""){
			document.form.zip_code.value = rowArray;
			formObject.zip_code.focus();
		}else{
			document.form.zip_code.value = document.form.zip_code.value+","+rowArray;
			formObject.zip_code.focus();
		}
	}else{
	}
}

/**
 * ofc팝업호출
 */
function ofc_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 768, 447, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');
}
	  
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_071(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var in_val_2 = colArray[3];
	document.form.input_office.value = in_val_2;
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
		for (var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i)
			if (oneChar != "") {
				if (!( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",") || (oneChar == "-" ) || (oneChar == " " ) || (oneChar == "/" ) )){
					charval ="N";
					break;
				}
			}else{
				charval ="N";
				break;
			}
		}
		if(charval=="N"){
			var errMessage = ComGetMsg('TRS90083',val,'','');  
			ComShowMessage(errMessage);
			obj.value = "";
			obj.focus();
		}
	}
}

/**
 * 콤보박스 -bound
 */
function bound_OnChange_1(obj) {
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_boundmode.value=codeval;
}

/**
 * 콤보박스 -cost
 */
function bound_OnChange_2(obj) {
    var codeval =obj.value;
    var formObject = document.form;
    
    formObject.hid_costmode.value=codeval;
    //cost mode에 따른 화면정의!
    setKindEnabled(); 
}

/**
 * 콤보박스 -trans
 */
function bound_OnChange_3(obj){
	var codeval =obj.value;
	var formObject = document.form;
	
	formObject.hid_transmode.value=codeval;
	//trans mode에 따른 화면정의!
	setKindEnabled();
}

/**
 * 콤보박스 -so
 */
function bound_OnChange_4(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_somode.value=codeval;
}

/**
 * 콤보박스 -wo
 */
function bound_OnChange_5(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_womode.value=codeval;
}

/**
 * 콤보박스 -invoice
 */
function bound_OnChange_6(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_invoicemode.value=codeval;
}

/**
 * 콤보박스 -cargo
 */
function bound_OnChange_7(obj){
	var codeval =obj.value;
	var formObject = document.form;
	formObject.hid_cargomode.value=codeval;
}

function bound_OnChange_8(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_sotype.value=codeval;
}

function bound_OnChange_9(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_amount.value=codeval;
}

function bound_OnChange_10(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_unplanned.value=codeval;
}

function cnt_flg_OnChange(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_cnt_flg.value=codeval;
}

/**
 * 라디오버튼을 누를시 period
 */
function change_period(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

/*	if ( formObject.radio_period[0].checked == true ) {
		formObject.hid_period.value="S";   //S/O Creation  
	}else if( formObject.radio_period[1].checked == true ) {
		formObject.hid_period.value="W";   //W/O Issue
	}else if( formObject.radio_period[2].checked == true ) {
		formObject.hid_period.value="I";   //Invoice Confirm 
	}else if( formObject.radio_period[3].checked == true ) {
		formObject.hid_period.value="O";   //Invoice Confirm 
	}else if( formObject.radio_period[4].checked == true ) {
		formObject.hid_period.value="L";   //Invoice Confirm 
	}else if( formObject.radio_period[5].checked == true ) {
		formObject.hid_period.value="D";   //Invoice Confirm 
	}else{
		formObject.hid_period.value="";
	}
*/

formObject.hid_period.value = formObject.sel_period.value ;


}

/**
 * 라디오버튼을 누를시
 */
function change_office(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

	if ( formObject.radio_office[0].checked == true ) {
		formObject.hid_radio_office.value="S";   //Issue
	}else if( formObject.radio_office[1].checked == true ) {
		formObject.hid_radio_office.value="V";   //Invoice
	}else{
		formObject.hid_radio_office.value="";
	}
}

/**
 * 라디오버튼을 누를시
 */
function change_user(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

	if ( formObject.radio_user[0].checked == true ) {
		formObject.hid_radio_user.value="S";   //Issue
	}else if( formObject.radio_user[1].checked == true ) {
		formObject.hid_radio_user.value="V";   //Invoice
	}else{
		formObject.hid_radio_user.value="";
	}
}

function change_eqno(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

	if ( formObject.radio_eq[0].checked == true ) {
		formObject.hid_radio_eq.value="CNTR";   //Container 
	}else if( formObject.radio_eq[1].checked == true ) {
		formObject.hid_radio_eq.value="CHS";   //Chassis   
	}else if( formObject.radio_eq[2].checked == true ) {
		formObject.hid_radio_eq.value="GEN";   //Genset  
	}else{
		formObject.hid_radio_eq.value="";
	}
}
	
/**
 * 라디오버튼을 누를시
 */
function change_number(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

	if ( formObject.radio_number[0].checked == true ) {
		formObject.hid_radio_number.value="S";  // S/C No. 
	}else if( formObject.radio_number[1].checked == true ) {
		formObject.hid_radio_number.value="R";  // RFA No.  
	}else{
		formObject.hid_radio_number.value="";
	}
}

/**
 * trunk_vvd_check.
 */
function vvd_check(obj){
	var formObject = document.form;
	var inputStr=obj.value;
	var value=obj.value;
	var charval = "Y";

	for (var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i);
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",")){
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
			//formObject.f_cmd.value = SEARCH04;
			//var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
			//formObject.sheet1.DoRowSearch("ESD_TRS_0075GS.do", queryString);
			//if(!check_vndr(formObject.sheet1.EtcData('CNT_CD'),obj)){
			//	formObject.vndr_cd.value="";
			//	formObject.vndr_nm.value="";
			//	formObject.vndr_cd.focus();
			//}
		}else{
			formObject.trunk_vvd.value="";
		}
	}else{
		formObject.trunk_vvd.value="";
		formObject.trunk_vvd.focus();
		var errMessage = ComGetMsg('COM12130','T.VVD','English or Number type','');  
		ComShowMessage(errMessage);
	}
}

/**
 * trunk_vvd_check 입력시 존재여부체크 
 *
 */
function check_vndr(value, obj) {
	var formObject = document.form;
	if( value == 0) {
		var errMessage = ComGetMsg('COM12114','VNDR','','');  
		ComShowMessage(errMessage);
		return false;
	}else{
		formObject.trunk_vvd.value=value;
		return true;
	}
}

/**
 * office_check_check.
 */
function office_check(obj){ 
	var formObject = document.form;
	var inputStr=doSepRemove(obj.value.toUpperCase(), " ");
	var value=doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";

	formObject.input_office.value =doSepRemove(obj.value.toUpperCase(), " ");
	for (var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i)
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" )  ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}

	if(charval=="Y"){
		if(value !=""){
			formObject.f_cmd.value = SEARCH02;
			var queryString = "office_cd="+value+"&"+TrsFrmQryString(formObject);
			formObject.sheet1.DoRowSearch("ESD_TRS_0019GS.do", queryString);
			if(!check_office(formObject.sheet1.EtcData('CNT_CD'),obj)){
				formObject.input_office.value="";
				formObject.input_office.focus();
			}
		}else{
			formObject.input_office.value="";
		}
	}else{
		formObject.input_office.value="";
		formObject.input_office.focus();
		var errMessage = ComGetMsg('COM12130','Office Code','English or Number type','');  
		ComShowMessage(errMessage);
	}
}

/**
 * office_check_check 입력시 존재여부체크 
 *
 */
function check_office(value, obj) {
	var formObject = document.form;
	if( value == 0) {
		var errMessage = ComGetMsg('COM12114','OFFICE','','');  
		ComShowMessage(errMessage);
		return false;
	}else{
		//formObject.input_office.value=value;
		return true;
	}
}

/**
 * user_check.
 
function user_check(obj){ 
	var formObject = document.form;
	var inputStr=doSepRemove(obj.value, " ");
	var value=doSepRemove(obj.value, " ");
	var charval = "Y";
	
	formObject.user_nm.value =doSepRemove(obj.value, " ");
	for (var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i)
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "a" && oneChar <= "z") || (oneChar >= 0 && oneChar <= 9) || oneChar =="_"  ){
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
		}else{
			formObject.user_nm.value="";
		}
	}else{
		var errMessage = ComGetMsg('COM12130','User Name','English or Number type','');  
		ComShowMessage(errMessage);
		formObject.user_nm.value="";
		formObject.user_nm.focus();
	}
	
	searchUserId(sheetObjects[2]);
}
*/

/**
 * so/wo number_check.
 */
function number_check(obj){ 
	var formObject = document.form;
	var inputStr=doSepRemove(obj.value.toUpperCase(), " ");
	var value=doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";

	formObject.sc_rfa_cd.value =doSepRemove(obj.value.toUpperCase(), " ");

	for (var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i);
		if (oneChar != "") {
			if ( (oneChar >= "A" && oneChar <= "Z" ) ||(oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "0" && oneChar <= "9" ) || (oneChar == ",")){
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
			<!--fn_revalue(); -->
		}else{
			formObject.sc_rfa_cd.value="";
		}
	}else{
		var errMessage = ComGetMsg('COM12130','Number','English or Number type',''); 
		ComShowMessage(errMessage);
		formObject.sc_rfa_cd.value="";
		formObject.sc_rfa_cd.focus();
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
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * combo_node add
 */
function node_add() {
	var formObj = document.form;
	if(document.search_fm_yard.Code != '' && formObj.search_fm_loc.value != '') {
		formObj.chk_from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
	}else{
		formObj.chk_from_node.value = '';
	}
	
	if(document.search_via_yard.Code != '' && formObj.search_via_loc.value != '') {
		formObj.chk_via_node.value = formObj.search_via_loc.value+document.search_via_yard.Code;
	}else{
		formObj.chk_via_node.value = '';
	}
	if(document.search_to_yard.Code != '' && formObj.search_to_loc.value != '') {
		formObj.chk_to_node.value = formObj.search_to_loc.value+document.search_to_yard.Code;
	}else{
		formObj.chk_to_node.value = '';
	}
	if(document.search_door_yard.Code != '' && formObj.search_door_loc.value != '') {
		formObj.chk_door_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;
	}else{
		formObj.chk_door_node.value = '';
	}
	var costMode = formObj.hid_costmode.value;
	var tranMode = formObj.hid_transmode.value;

	//COST MODE에 따라 조회조건 활성/불활성화를 세팅하기 위한 네종류 조건 확인
//	if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 1;
//	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR') ctMode = 2;
//	else if((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 3;
//	else if(!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR') ctMode = 4;
//	alert("costMode===>"+costMode+", tranMode===>"+tranMode);
	if (costMode == "" || costMode == "ALL" || costMode == "DR") {
		/*
		 	Trans Mode	Via			Door
			WD			비활성화		비활성화
			TD			비활성화		활성화
			RD			비활성화		비활성화
			WT			활성화		활성화
			WR			활성화		비활성화
			TR			활성화		활성화
			TW			활성화		활성화
			RW			활성화		비활성화
			RT			활성화		활성화
	   */
		if (tranMode == "WD" || tranMode == "RD"){
			ctMode = 7; 	// Via / Door 비활성화
		}else if (tranMode == "TD"){
			ctMode = 8; 	// Via 비활성화
		}else if (tranMode == "WR" || tranMode == "RW"){
			ctMode = 9; 	// Door 비활성화
		}else{
			ctMode = 6; 	// From / Via / Door / To 모두 활성화
		}
	}else{
		/*
		 	Trans Mode	Via			Door
			WD			비활성화		비활성화
			TD			비활성화		비활성화
			RD			비활성화		비활성화
			WT			활성화		비활성화
			WR			활성화		비활성화
			TR			활성화		비활성화
			TW			활성화		비활성화
			RW			활성화		비활성화
			RT			활성화		비활성화
		 */
		if (tranMode == "WD" || tranMode == "TD" || tranMode == "RD"){
			ctMode = 7; 	// Via / Door 비활성화
		}else{
			ctMode = 9; 	// Door 비활성화
		}
	}
}

/**
 * search_fm_yard_OnChange
 */
function search_fm_yard_OnChange(combo, Index_Code, Text) {
	//search_node_mode(combo, Index_Code, Text);
}

/**
 * search_via_yard_OnChange
 */
function search_via_yard_OnChange(combo, Index_Code, Text) {
	//search_node_mode(combo, Index_Code, Text);
}

/**
 * search_to_yard_OnChange
 */
function search_to_yard_OnChange(combo, Index_Code, Text) {
	//search_node_mode(combo, Index_Code, Text);
}

/**
 * combo_search_door_yard_onChange
 */
function search_door_yard_OnChange(combo, Index_Code, Text) {
	//search_node_mode(combo, Index_Code, Text);
}

/**
 * combo_search_door_yard_onChange
 */
function search_node_mode() {
	var formObj = document.form;
	//모드에 따른 경우에 수를 가진다.
	node_add(); 
	var fmNode		= formObj.search_fm_loc.value+document.search_fm_yard.Code;
	var viaNode		= formObj.search_via_loc.value+document.search_via_yard.Code;
	var toNode		= formObj.search_to_loc.value+document.search_to_yard.Code;
	var doorNode	= formObj.search_door_loc.value+document.search_door_yard.Code;
	switch(ctMode) {
		case 1:
			if(fmNode == toNode) {
				ComShowCodeMessage('COM12115', 'From yard And To yard');
				formObj.search_fm_loc.focus();
				return false;
			}
		break;

		case 2:
			if(formObj.search_via_loc.value == '' || document.search_via_yard.Code == '') {
				ComShowCodeMessage('COM12114', 'Via');
				formObj.search_via_loc.focus();
				return false;
			} else if(fmNode == toNode) {
				ComShowCodeMessage('COM12115', 'From yard And To yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(fmNode == viaNode) {
				ComShowCodeMessage('COM12115', 'From yard And Via yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(viaNode == toNode) {
				ComShowCodeMessage('COM12115', 'Via yard And To yard');
				formObj.search_via_loc.focus();
				return false;
			}
		break;
		
		case 3:
			if(formObj.search_door_loc.value == '' || document.search_door_yard.Code == '') {
				ComShowCodeMessage('COM12114', 'Door');
				formObj.search_door_loc.focus();
				return false;
			} else if(fmNode == doorNode) {
				ComShowCodeMessage('COM12115', 'From yard And Door yard');
				formObj.search_fm_loc.focus();
				return false;
			} else if(toNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Door yard And To yard');
				formObj.search_door_loc.focus();
				return false;
			}
		break;
		
		case 4:
			if(formObj.search_via_loc.value == '' || document.search_via_yard.Code == '') {
				ComShowCodeMessage('COM12114', 'Via');
				formObj.search_via_loc.focus();
				return false;
			}else if(formObj.search_door_loc.value == '' || document.search_door_yard.Code == '') {
				ComShowCodeMessage('COM12114', 'Door');
				formObj.search_door_loc.focus();
				return false;
			}else if(fmNode == viaNode) {
				ComShowCodeMessage('COM12115', 'From yard And Via yard');
				formObj.search_fm_loc.focus();
				return false;
			}else if(viaNode == toNode) {
				ComShowCodeMessage('COM12115', 'Via yard And To yard');
				formObj.search_via_loc.focus();
				return false;
			}else if(fmNode == doorNode) {
				ComShowCodeMessage('COM12115', 'From yard And Door yard');
				formObj.search_fm_loc.focus();
				return false;
			}else if(toNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Door yard And To yard');
				formObj.search_door_loc.focus();
				return false;
			}else if(viaNode == doorNode) {
				ComShowCodeMessage('COM12115', 'Via yard And Door yard');
				formObj.search_via_loc.focus();
				return false;
			}
		break;
	}
}

/**
 * COST MODE, TRANS MODE 선택에 따른 조회조건 enabled처리
 **/
function setKindEnabled() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = document.form;

//		document.combo_svc_provider.Text = '';
//		formObj.svc_provider.value='';
	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	document.search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.search_door_loc.value = '';
	document.search_door_yard.RemoveAll();

	node_add();
	switch(ctMode) {
//		case 1:
//			obj.search_via_loc.disabled = true;
//			obj.search_door_loc.disabled = true;
//			document.search_via_yard.Enable = false;
//			document.search_door_yard.Enable = false;
//		break;
//
//		case 2:
//			obj.search_via_loc.disabled = false;
//			obj.search_door_loc.disabled = true;
//			document.search_via_yard.Enable = true;
//			document.search_door_yard.Enable = false;
//		break;
//
//		case 3:
//			obj.search_via_loc.disabled = true;
//			obj.search_door_loc.disabled = false;
//			document.search_via_yard.Enable = false;
//			document.search_door_yard.Enable = true;
//		break;
//
//		case 4:
//			obj.search_via_loc.disabled = false;
//			obj.search_door_loc.disabled = false;
//			document.search_via_yard.Enable = true;
//			document.search_door_yard.Enable = true;
//		break;
//		
//		case 5: // From / Via / Door / To 모두 비활성화
//			obj.search_fm_loc.disabled = true;
//			obj.search_via_loc.disabled = true;
//			obj.search_door_loc.disabled = true;
//			obj.search_to_loc.disabled = true;
//			document.search_fm_yard.Enable = false;
//			document.search_via_yard.Enable = false;
//			document.search_door_yard.Enable = false;
//			document.search_to_yard.Enable = false;
//		break;
		
		case 6: // From / Via / Door / To 모두 활성화
			obj.search_fm_loc.disabled = false;
			obj.search_via_loc.disabled = false;
			obj.search_door_loc.disabled = false;
			obj.search_to_loc.disabled = false;
			document.search_fm_yard.Enable = true;
			document.search_via_yard.Enable = true;
			document.search_door_yard.Enable = true;
			document.search_to_yard.Enable = true;
		break;
		
		case 7: // Via / Door 비활성화
			obj.search_fm_loc.disabled = false;
			obj.search_via_loc.disabled = true;
			obj.search_door_loc.disabled = true;
			obj.search_to_loc.disabled = false;
			document.search_fm_yard.Enable = true;
			document.search_via_yard.Enable = false;
			document.search_door_yard.Enable = false;
			document.search_to_yard.Enable = true;
		break;
		
		case 8: // Via 비활성화
			obj.search_fm_loc.disabled = false;
			obj.search_via_loc.disabled = true;
			obj.search_door_loc.disabled = false;
			obj.search_to_loc.disabled = false;
			document.search_fm_yard.Enable = true;
			document.search_via_yard.Enable = false;
			document.search_door_yard.Enable = true;
			document.search_to_yard.Enable = true;
		break;
		
		case 9: // Door 비활성화
			obj.search_fm_loc.disabled = false;
			obj.search_via_loc.disabled = false;
			obj.search_door_loc.disabled = true;
			obj.search_to_loc.disabled = false;
			document.search_fm_yard.Enable = true;
			document.search_via_yard.Enable = true;
			document.search_door_yard.Enable = false;
			document.search_to_yard.Enable = true;
		break;
	}
}

/**
 * W/O PreView
 */
function woPreview(sheetObj){
	var chkRows = sheetObj.FindCheckedRow ("part");
	var trsp_wo_ofc_cty_cd = "";
	var trsp_wo_seq = "";
	var emptyData = "";
	if ( chkRows == "") {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var arrRow = chkRows.split("|");
	for (idx=0; idx<arrRow.length-1; idx++){ 
		if ( sheetObj.CellValue( arrRow[idx] , "hjl_no" ) == "Y") {
			ComShowCodeMessage("TRS90368");
			return false;
		}				
		if ( sheetObj.CellValue( arrRow[idx] , "wo_no" ) == "") {
			ComShowCodeMessage("TRS90377");
			return false;
		}		    
		trsp_wo_ofc_cty_cd += sheetObj.CellValue(arrRow[idx] , "trsp_wo_ofc_cty_cd")+ ",";
		trsp_wo_seq += sheetObj.CellValue(arrRow[idx] , "trsp_wo_seq")+ ",";
		emptyData += ",";
	}

	trsp_wo_ofc_cty_cd = trsp_wo_ofc_cty_cd.substring(0 , trsp_wo_ofc_cty_cd.length-1);
	trsp_wo_seq = trsp_wo_seq.substring(0 , trsp_wo_seq.length-1);

	var wo_cancel_flag = '';
	var detain = '';
	var bno_issue = '';
	var eq_mode = 'IS';
	var issued = 'Y';
	
	var param = "?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024";
	window.open('ESD_TRS_0024.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=1000,Height=800");
}


/**
 * Frustrate Flag 설정
 **/
function setFrustrate(sheetObj)
{
	var formObj = document.form;

/*	if (formObj.wo_radio.value == 'N'){
		ComShowCodeMessage('TRS90311');
		return;
	}
*/

	var checkList = sheetObj.FindCheckedRow('part');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	/* frustrate 를 위한 validation 체크 */
	var checkArray = checkList.split('|');

	for(var i=0; i<checkArray.length-1; i++)
	{
		
		if(sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd') == 'RAIL BILLING'){
			ComShowCodeMessage('TRS90406');
			return;
		}

/* 모든 S/O Frustrate 가능.  20071127. 지연
if(sheetObj.CellValue(checkArray[i], 'inv_no')==''){
			ComShowMessage('Invoice' );
			return;
		}
*/
		if(sheetObj.CellValue(checkArray[i], 'hjl_no') =='Y'){
			ComShowMessage('You cannot frustrate the selected S/O since it was created through ETS.'  );
			return;
		}
		
		if(sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd')!='CY/DOOR'){
			ComShowCodeMessage('TRS90310');
			return;
		}

		if(sheetObj.CellValue(checkArray[i], 'so_del_flg') =='Y'){
			ComShowMessage('Frustrate function is not designed for deleted S/Os.'  );
			return;
		}
	
	
	
	}

	document.form.f_cmd.value = MULTI01;
	sheetObj.DoSave("ESD_TRS_0023GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
}

 /**
  * S/O History
  */
 function soHistory(sheetObj){
 	var chkRows = null;
 	chkRows = sheetObj.FindCheckedRow ("part");
 	var soNo ="";
 	
 	var arrRow = chkRows.split("|");
 	if ( chkRows == "") {
 		ComShowCodeMessage('COM12176');
 		return false;
 	}else if(arrRow.length > 2){
		ComShowCodeMessage("COM12113", 'only one row');
		return false;
	}
 	var so_no = null;
 	var cost_mode = null;
 	var param = null;
 	for (idx=0; idx<arrRow.length-1; idx++){
 		cost_mode = sheetObj.CellValue(arrRow[idx], 'trsp_cost_dtl_mod_cd');
 		so_no = sheetObj.CellValue(arrRow[idx], 'so_no');
 		param = "?so_no="+so_no;
    		
 		if( cost_mode == 'CY' || cost_mode == 'DR' || cost_mode == 'TS' || cost_mode == 'LS'){
// 			window.open('ESD_TRS_0975.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=900,Height=460");
 			ComOpenWindow('ESD_TRS_0975.do'+param, 'OpneSOHistoryWin', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:930px;dialogHeight:460px', true);
 		}
 	}
 	
 }

/**
 * W/O Issue History
 */
function woIssueHistory(sheetObj){
	var chkRows = sheetObj.FindCheckedRow ("part");
	var woNo ="";
	if ( chkRows == "") {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var arrRow = chkRows.split("|");
	for (idx=0; idx<arrRow.length-1; idx++){ 
		if ( sheetObj.CellValue( arrRow[idx] , "wo_no" ) == "") {
			ComShowCodeMessage("TRS90377");
			return false;
		}
		dupChk = woNo.indexOf(sheetObj.CellValue(arrRow[idx] , "wo_no"));
		if ( parseInt(dupChk) < 0 ) {
			woNo += sheetObj.CellValue(arrRow[idx] , "wo_no")+ ",";    
		}
	}
	woNo = woNo.substring(0 , woNo.length-1);
	var param = "?wo_history="+woNo;
//	window.open('ESD_TRS_0958.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=900,Height=460");
    ComOpenWindow('ESD_TRS_0958.do'+param, 'OpneHistoryWin', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:900px;dialogHeight:490px', true);
}

/**
 * sheet1에 대한 팝업처리
 */
function fn_popup(sheetObj, row, col) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_021";
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
	ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 772, 450, 'getCOM_ENS_021', '1,0,1,1,1,1,1,1,1,1,1,1');
}
	  
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_021(rowArray) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var in_val = colArray[2];
		formObject.sc_rfa_cd.value  = in_val;
	}
}

/**
 * sc-rfa검증
 */
function fn_revalue() {
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH02;
	var value = formObject.sc_rfa_cd.value;
	var queryString = "col=sc_no&row=&searchStr="+value+"&"+TrsFrmQryString(formObject);
	formObject.sheet1.DoRowSearch("ESD_TRS_0077_01GS.do", queryString);
	if(!checkCountry(formObject.sheet1.EtcData('CNT_CD'))) return;
}

/**
 * S/C Number 입력시 존재여부체크 
 *
 */
function checkCountry(value, row, col) {
	var formObject = document.form;
	if( value == 0) {
		var errMessage = ComGetMsg('COM12114','S/C No. - RFA No. Number','','');  
		ComShowMessage(errMessage);
		formObject.sc_rfa_cd.value  = "";
		formObject.sc_rfa_cd.focus();
		return false;
	} else {
		//formObject.sc_rfa_cd.focus();
		return true;
	}
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5= formObject.input_office.value;  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&ofc_cd="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	//var comboObj = document.combo_svc_provider;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];

		//comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);
		formObj.combo_svc_provider.value =colArray2;
		formObj.svc_provider.value =colArray4;
	}
}

function retriveSo() {
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "RTV");
}
	
function  vender_blur() {
	var formObj = document.form;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !="") {
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i)
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}

		if(error_val !="Y" ){
			//vender value값을 가져온다(SHEET1)
			formObj.f_cmd.value = SEARCHLIST12;
			sheetObjects[0].DoSearch4Post("ESD_TRS_0065GS.do", TrsFrmQryString(formObj));

			//1개의 파라미터의 값을 조회후 가져온다.
			var x1 = "";
			if (sheetObjects[0].EtcData('CNT_CD1') != undefined) {
				x1 = sheetObjects[0].EtcData('CNT_CD1');
			}
			if(x1 != "") {
				formObj.svc_provider.value = x1;
			}else{
				var errMessage = ComGetMsg('TRS90076','','','');  
				ComShowMessage(errMessage);
				formObj.combo_svc_provider.focus();
				formObj.svc_provider.value ="";
			}
		} else {
			var errMessage = ComGetMsg('TRS90076','','','');  
			ComShowMessage(errMessage);
			formObj.combo_svc_provider.focus();
			formObj.svc_provider.value ="";
		}
	}else{
		formObj.svc_provider.value ="";
	}
}	

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

// Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
	}
}

// Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}


//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}

/**
 * Radio box에서 선택한 항목의 value를 return
 *
 * @param
 * @since	1.0
 */
function checkParaminput(oFrm){
    sRtn = "";

    if( typeof( oFrm.length) != "undefined"){
        for(var i = 0; i < oFrm.length; i++){
            if(oFrm[i].checked) sRtn = oFrm[i].value;
        }
    }else{
        if(oFrm.checked) sRtn = oFrm.value;
    }

    return sRtn;
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode,step)
{
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&open_mode='+mode;
	url += '&step_cd='+step;
	url += '&main_row='+row;
	url += '&ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=1';
	url += '&curr_cd='+sheetObj.CellValue(row, 'wo_curr_cd');

	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

/**
 * 3pt bill Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode)
{
	var myOption = "width=615,height=330,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0954.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&open_mode='+'search';
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&trsp_so_ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&trsp_so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=1';
	url += '&bkg_no='+sheetObj.CellValue(row, 'bkg_no');
	url += '&eq_no='+sheetObj.CellValue(row, 'eq_no');
	url += '&wo_no='+sheetObj.CellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.CellValue(row, 'trsp_wo_seq');
	url += '&curr_cd='+sheetObj.CellValue(row, 'wo_curr_cd');
	myWin = window.open(url, "pop3rdPartyBilling", myOption);
	myWin.focus();
}

function sheet1_OnSelectMenu(sheetObj, MenuString){
	
	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}


/**
 * 체크박스 선택시
 */
function usrailOnly(obj){
	var formObject = document.form;
	var val="";

	if ( obj.checked == true ) {
		formObject.chk_dom_rail.checked = false;
		formObject.hid_dom_usrail.value = "N";

		sheetObjects[0].ColHidden("wo_hzd_mtrl_scg_amt") 	= false;
		sheetObjects[0].ColHidden("wo_ovr_wgt_scg_amt") 	= false;
		sheetObjects[0].ColHidden("wo_usa_ttl_amt") 		= false;
		sheetObjects[0].ColHidden("wo_toll_fee_amt") 		= true;
		
		formObject.hid_usrail.value = 'Y';

		formObject.sel_sotype.value = 'R';
		formObject.sel_costmode.value = 'ALL';
		formObject.sel_transmode.value = 'RD';
		formObject.input_office.value = 'PHXSA,SYSTEM';

		formObject.chk_prepull.checked = false; //20121031
		formObject.chk_prepull.disabled = true; //20121031
		formObject.hid_prepull.value = ""; //20121031
		
		formObject.spot_bid_flg.value = "";
		formObject.spot_bid_no.value = "";
		formObject.spot_bid_flg.disabled = true; //20121031
		formObject.spot_bid_no.disabled = true; //20121031
//		document.all.item("spotBidLayer").style.display = "none";
	} else {
		sheetObjects[0].ColHidden("wo_hzd_mtrl_scg_amt") 	= true;
		sheetObjects[0].ColHidden("wo_ovr_wgt_scg_amt") 	= true;
		sheetObjects[0].ColHidden("wo_usa_ttl_amt") 		= true;
		sheetObjects[0].ColHidden("wo_toll_fee_amt") 		= false;
		
		formObject.hid_usrail.value = 'N';

		formObject.sel_sotype.value = 'ALL';
		formObject.sel_costmode.value = 'ALL';
		formObject.sel_transmode.value = 'ALL';
		formObject.input_office.value = '';

		formObject.chk_prepull.disabled = false; //20121031
		
		formObject.spot_bid_flg.disabled = false; //20121031
		formObject.spot_bid_no.disabled = false; //20121031
//		document.all.item("spotBidLayer").style.display = "Inline";
	}

	bound_OnChange_8(formObject.sel_sotype);  // SO TYPE CHANGE 이벤트.
	bound_OnChange_3(formObject.sel_transmode);  // TRANS MODE CHANGE 이벤트.
	bound_OnChange_2(formObject.sel_costmode);  // COST CODE CHANGE 이벤트

}

/**
 * 체크박스 선택시
 */
function usDomRailOnly(obj){
	var formObject = document.form;
	var val="";

	if ( obj.checked == true ) {
		formObject.chk_usrail.checked = false;
		formObject.hid_usrail.value = "N";

		sheetObjects[0].ColHidden("wo_hzd_mtrl_scg_amt") 	= false;
		sheetObjects[0].ColHidden("wo_ovr_wgt_scg_amt") 	= false;
		sheetObjects[0].ColHidden("wo_usa_ttl_amt") 		= false;
		sheetObjects[0].ColHidden("wo_toll_fee_amt") 		= true;
		
		formObject.hid_dom_usrail.value = 'Y';

		formObject.sel_sotype.value = 'D';
		formObject.sel_costmode.value = 'ALL';
		formObject.sel_transmode.value = 'RD';
		formObject.input_office.value = 'PHXSA';
		formObject.sel_unplanned.value = 'ALL';
		formObject.sel_boundmode.value = 'ALL';
		formObject.sel_womode.value = 'ALL';

		formObject.chk_prepull.checked = false; //20121031
		formObject.chk_prepull.disabled = true; //20121031
		formObject.hid_prepull.value = ""; //20121031
		
		formObject.spot_bid_flg.value = "";
		formObject.spot_bid_no.value = "";
		formObject.blnumber.value = "";
		formObject.copnumber.value = "";
		formObject.mtyrefnumber.value = "";
		formObject.sc_rfa_cd.value = "";
		formObject.spot_bid_flg.disabled = true; //20121031
		formObject.spot_bid_no.disabled = true; //20121031
		formObject.blnumber.disabled = true;
		formObject.copnumber.disabled = true;
		formObject.mtyrefnumber.disabled = true;
		formObject.sc_rfa_cd.disabled = true;
		formObject.sel_boundmode.disabled = true;
		formObject.sel_womode.disabled = true;
//		document.all.item("spotBidLayer").style.display = "none";
	} else {
		sheetObjects[0].ColHidden("wo_hzd_mtrl_scg_amt") 	= true;
		sheetObjects[0].ColHidden("wo_ovr_wgt_scg_amt") 	= true;
		sheetObjects[0].ColHidden("wo_usa_ttl_amt") 		= true;
		sheetObjects[0].ColHidden("wo_toll_fee_amt") 		= false;
		
		formObject.hid_dom_usrail.value = 'N';

		formObject.sel_sotype.value = 'ALL';
		formObject.sel_costmode.value = 'ALL';
		formObject.sel_transmode.value = 'ALL';
		formObject.input_office.value = '';

		formObject.chk_prepull.disabled = false; //20121031
		
		formObject.spot_bid_flg.disabled = false; //20121031
		formObject.spot_bid_no.disabled = false; //20121031
		formObject.blnumber.disabled = false;
		formObject.copnumber.disabled = false;
		formObject.mtyrefnumber.disabled = false;
		formObject.sc_rfa_cd.disabled = false;
		formObject.sel_boundmode.disabled = false;
		formObject.sel_womode.disabled = false;
		
//		document.all.item("spotBidLayer").style.display = "Inline";
	}

	bound_OnChange_8(formObject.sel_sotype);  // SO TYPE CHANGE 이벤트.
	bound_OnChange_3(formObject.sel_transmode);  // TRANS MODE CHANGE 이벤트.
	bound_OnChange_2(formObject.sel_costmode);  // COST CODE CHANGE 이벤트

}


/**
 * 체크박스 선택시
 */
function usdropnpullOnly(obj){
	var formObject = document.form;

	if ( obj.checked == true ) {
		sheetObjects[0].ColHidden("fm_dt") = false;
		sheetObjects[0].ColHidden("fm_yd") = false;
		sheetObjects[0].ColHidden("to_dt") = false;
		sheetObjects[0].ColHidden("to_yd") = false;
		sheetObjects[0].ColHidden("to_sts") = false;
		sheetObjects[0].ColHidden("mt_dt") = false;
		sheetObjects[0].ColHidden("mt_yd") = false;
		sheetObjects[0].ColHidden("web_mt_dt") = false;
		sheetObjects[0].ColHidden("grace_end") = false;

		formObject.hid_usdropnpull.value = 'Y';

	} else {
		sheetObjects[0].ColHidden("fm_dt") = true;
		sheetObjects[0].ColHidden("fm_yd") = true;
		sheetObjects[0].ColHidden("to_dt") = true;
		sheetObjects[0].ColHidden("to_yd") = true;
		sheetObjects[0].ColHidden("to_sts") = true;
		sheetObjects[0].ColHidden("mt_dt") = true;
		sheetObjects[0].ColHidden("mt_yd") = true;
		sheetObjects[0].ColHidden("web_mt_dt") = true;
		sheetObjects[0].ColHidden("grace_end") = true;
		
		formObject.hid_usdropnpull.value = 'N';

	}

}

/**
 * 체크박스 선택시 20121031
 */
function usPrePull(obj) {
	var formObject = document.form;
	if ( obj.checked == true ) {
		formObject.hid_prepull.value = "Y";
	} else {
		formObject.hid_prepull.value = "";
	}
}

function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.eqnumber;
	}

	if(formObj.radio_eq[0].checked){
		obj.value = multiCntrChkDgt(obj.value);
	}
}

/**
 * 문자열 공백 제거 함수 2014.09.11.
 */
function removeSpace(obj){
	var str = obj.value;
	var returnStr = '';

	for(i=0; i< str.length; i++){
		if(str.charAt(i) != ' '){
			returnStr = returnStr + str.charAt(i);
		}
	}
    
	obj.value = returnStr;
}

/**
 * staff 팝업에서 값 가져오기
 */
function getStaffPop(rowArray, row, col){
	var formObj = document.form;
	var userCode = '';
	var userName = '';
	
	if(rowArray.length>0)
	{
		userCode = rowArray[0][4];
		userName = rowArray[0][5];
	}
	formObj.user_id.value = userCode;
	formObj.user_nm.value = userName;
}

/**
 * User Name Combo 조회
 */
function searchUserId(sheetObj){
	var formObj = document.form;
	var usrId = '';
	var usrNm = '';
	
	if(formObj.user_nm.value == undefined || formObj.user_nm.value == ''){
		formObj.user_id.value = '';
	    formObj.user_nm.value = '';
	}else{
		formObj.user_id.value = '';
		
		formObj.f_cmd.value = SEARCH;
	    selectVal = FormQueryString(formObj)
	    sheetObj.DoSearch4Post("COM_ENS_091GS.do", selectVal);
		
		//sheetObj.DoRowSearch("COM_ENS_091GS.do", TrsFrmQryString(formObj));
	    
	    if(sheetObj.RowCount > 1){
	    	
	    	alert("There are several same names - RowCount::"+sheetObj.RowCount);
	    	
	    	formObj.user_id.value = '';
		    formObj.user_nm.value = '';
	    }
	    else{
	    	usrId = sheetObj.CellValue(1,'usr_id');
	    	usrNm = sheetObj.CellValue(1,'usr_nm');
	    	
	    	if (usrId == undefined || usrId == ''){
	    		formObj.user_id.value = '';
	    	    formObj.user_nm.value = '';
	    	}else{
	    		formObj.user_id.value = usrId;
	    	    formObj.user_nm.value = usrNm;
	    	}
	    }
	}
	
}
