﻿﻿var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;

	try{ 
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				if(ComIsEmpty(formObj.cust_nm.value) &&
						!ComIsEmpty(formObj.cust_cnt_seq.value)) getCustName(formObj.cust_cnt_seq.value);
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;
				
	  		case "btn_bkginfo":
	  			openESD_SCE_915(sheetObj) ;
				break;

	  		case "btn_cop":
		  		goESD_SCE_006(sheetObj) ;
				break;

	  		case "btn_clm":
		  		goESD_SCE_044(sheetObj) ;
				break;

	  		case "btn_rtr":
				break;
				
			case "btn_calendar":
				if(!ComIsEmpty(formObj.date_kind)){
		            var cal = new ComCalendarFromTo();
		            cal.displayType = "date";
		            cal.select(form.fm_dt,  form.to_dt,  'yyyy-MM-dd');
					break ;					
				}
				else{
					ComShowMessage(ComGetMsg('COM12113', 'date')) ;
					formObj.date_kind.focus() ;
				}
				break ;				

		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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


	}

   /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(56, 13, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "SEQ|COP No|SO NO1|SO NO2|CNTR|T/S|BKG|VVD|POR|POL|POD|DEL|R/D\nTerm|Local/IPI|Current Activity|Date/Time|Date/Time|Location|VD Date/Time|VD Date/Time|F|O|C|Hold|Release|Release|Last Free Date|Last Free Date|Hot\nDelivery|Rail\nCompany|Rail Origin|Estimated\nDeparture|Estimated\nDeparture|Actual Departure|Actual Departure|Rail\nDestination|Estimated Arrival|Estimated Arrival|Actual Arrival|Actual Arrival|Last Rail\nLocation|Last Rail Location\nData/Time|Last Rail Location\nData/Time|Pick-Up Available|Out-Gate|Out-Gate|Estimated Door\nDelivery|Estimated Door\nDelivery|Actual Door Delivery|Actual Door Delivery|Exception Date/Time|Exception Date/Time|Exception Location|Exception Reason|Estimated Rail\nDeparture Date/Time|Estimated Rail\nDeparture Date/Time";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				/*
				InitDataProperty(0, cnt++ , dtSeq,	   30,	daCenter,  true,	"",						false,		  "",	   dfNone,   	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"r_cop_no",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"r_trsp_so_ofc_cty_cd",	false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"r_trsp_so_seq",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"r_cntr_no",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"r_ts",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"r_bkg_no",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"r_bkg_no_split",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_vvd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_por_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_pol_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_pod_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_del_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_rd_term_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_local_ipi",			false,		  "",	   dfNone,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  100,	daCenter,  true,	"r_c_act",				false,		  "",	   dfNone,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_c_act_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_c_act_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_nod",				false,		  "",	   dfNone,   	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_vd_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_vd_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"r_f",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"r_o",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"r_c",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"r_hold",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_hold_r_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_hold_r_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_l_free_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_l_free_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"r_hot",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_rail_com",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_fm_nod_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_rail_etd_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_rail_etd_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_org_out_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_org_out_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_to_nod_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_rail_eta_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_rail_eta_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_dest_in_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_dest_in_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_l_rail_loc",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"r_l_rail_ata_date",	false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_l_rail_ata_time",	false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"r_pick_up_avail",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"r_gate_out_etd_date",	false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_gate_out_etd_time",	false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"r_door_eta_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_door_eta_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"r_door_ata_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_door_ata_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"r_expt_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_expt_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  110,	daCenter,  true,	"r_expt_loc",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  110,	daCenter,  true,	"r_expt_rsn",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"r_etd_rail_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"r_etd_rail_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
                */
				
				
				InitDataProperty(0, cnt++ , dtSeq,	   30,	daCenter,  true,	"",						false,		  "",	   dfNone,   	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"cop_no",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"trsp_so_ofc_cty_cd",	false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtHidden,   0,	daCenter,  true,	"trsp_so_seq",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"eq_no",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"ts",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"bkg_no",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				//InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"bkg_no_split",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"vvd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"por_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"pol_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"pod_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"del_cd",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"rd_term_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"local_ipi",			false,		  "",	   dfNone,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  100,	daCenter,  true,	"c_act",				false,		  "",	   dfNone,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"c_act_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"c_act_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"nod",				false,		  "",	   dfNone,   	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"vd_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"vd_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"f",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"o",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"c",					false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"hold",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"hold_r_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"hold_r_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"l_free_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"l_free_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"hot",				false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"rail_com",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"fm_nod_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"rail_etd_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"rail_etd_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"org_out_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"org_out_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"to_nod_cd",			false,		  "",	   dfNone,	 	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"rail_eta_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"rail_eta_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"dest_in_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"dest_in_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"l_rail_loc",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"l_rail_ata_date",	false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"l_rail_ata_time",	false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"pick_up_avail",		false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"gate_out_etd_date",	false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"gate_out_etd_time",	false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"door_eta_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"door_eta_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"door_ata_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"door_ata_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);

				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"expt_date",			false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"expt_time",			false,		  "",	   dfTimeHm,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  110,	daCenter,  true,	"expt_loc",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  110,	daCenter,  true,	"expt_rsn",			false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"etd_rail_date",		false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"etd_rail_time",		false,		  "",	   dfTimeHm,  	0,	 true,	   true);
                		
				
				style.height = GetSheetHeight(16) ;

			}
			break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:	 
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESD_SCE_0038GS.do", SceFrmQryString(formObj));
			}
			break;

		case IBDOWNEXCEL:
			sheetObj.SpeedDown2Excel();
			break;
		}
	}

function cusSpite(custCntSeq){
	if(custCntSeq != null && custCntSeq != '' && custCntSeq.length > 2){
		custCntSeq = custCntSeq.toUpperCase();
		//값을 분리
		val1 = custCntSeq.substring(0,2);
		val2 = custCntSeq.substring(2,custCntSeq.length);
		//hidden 값 변경
		document.form.cust_value1.value = val1;
		document.form.cust_value2.value = val2;
		if(!ComIsNumber(document.form.cust_value2.value)){
			ComShowMessage(ComGetMsg('COM12122', "Customer Seq"));
			
			return false;
		}//if
		return true;
	}else if(custCntSeq != null && custCntSeq != '' && custCntSeq.length <= 2){
		//값을 분리하지 않음
		document.form.cust_value1.value = custCntSeq;
		document.form.cust_value2.value = "";
		return true;
	}else{
		//값을 초기화
		document.form.cust_value1.value = "";
		document.form.cust_value2.value = "";
		sc_no_val = document.form.sc_no;
		if(ComIsEmpty(sc_no_val)){
		    return false;
		}else{
			return true;
		}//if
	}
}


function cusSpiteGn(custCntSeq){
	if(custCntSeq != null && custCntSeq != '' && custCntSeq.length > 2){
		custCntSeq = custCntSeq.toUpperCase();
		//값을 분리
		val1 = custCntSeq.substring(0,2);
		val2 = custCntSeq.substring(2,custCntSeq.length);
		//hidden 값 변경
		document.form.cust_value1.value = val1;
		document.form.cust_value2.value = val2;
		val1 =  val1.toUpperCase();
		if(!ComIsNumber(document.form.cust_value2.value)){
			ComShowMessage(ComGetMsg('COM12122', "Customer Seq"));
			
			return false;
		}//if
		
		return true;
	}else if(custCntSeq != null && custCntSeq != '' && custCntSeq.length <= 2){
		//값을 분리하지 않음
		document.form.cust_value1.value = custCntSeq;
		document.form.cust_value2.value = "";
		return true;
	}else{
		//값을 초기화
		document.form.cust_value1.value = "";
		document.form.cust_value2.value = "";
		sc_no_val = document.form.sc_no;
		if(ComIsEmpty(sc_no_val)){
		    return false;
		}else{
			return true;
		}//if
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */ 
function validateForm(sheetObj,formObj,sAction){
	var result = true ;
	switch (sAction) {
		case IBSEARCH:
			    
		    if(ComIsEmpty(formObj.cust_cnt_seq) && ComIsEmpty(formObj.sc_no)){
				ComShowMessage(ComGetMsg('COM12138', "Customer", "S/C No."));
				formObj.cust_cnt_seq.focus() ;
				result = false  ;
		    }
			else if(!ComIsEmpty(formObj.cust_cnt_seq) && !chkLenthOver(formObj.cust_cnt_seq, 3, "Customer")){
				   result = false ;
	        }else{
				   result = cusSpite(formObj.cust_cnt_seq.value);//두개의 값으로 분리함
			}
			break;

		default:
			break;
	}


	return result ;
}
//getCustName(this.value);"
var preCustCntSeq = null ;
var preEventName = null;
function rememberPreEvent(){
	var srcName = window.event.srcElement.getAttribute("name");
	preEventName = srcName;
}

function shootDecision(){
    var formObj = document.form ;
	if(preEventName == "cust_cnt_seq") getCustName(formObj.cust_cnt_seq.value);
	rememberPreEvent();
}	
function getCustName(custCntSeq){
	var srcName = window.event.srcElement.getAttribute("name");
	preEventName = srcName;
    var formObj = document.form ;
		    sheetObjects[0].RemoveEtcData();
		    if((preCustCntSeq!=custCntSeq && !ComIsEmpty(custCntSeq) && ComGetLenByByte(custCntSeq)>2)|| 
		    		((!ComIsEmpty(custCntSeq) && ComGetLenByByte(custCntSeq)>2) && ( ComIsEmpty(formObj.cust_nm.value))))
		    {
		    	if(cusSpiteGn(custCntSeq)){
		            formObj.f_cmd.value = SEARCH ;
		    	    sheetObjects[0].DoSearch4Post("ESD_SCE_0038GS.do", SceFrmQryString(formObj));
		    	    ComEtcDataToForm(formObj,sheetObjects[0]);
		    	    if(ComIsEmpty(formObj.cust_nm.value)){
		    	    	formObj.cust_cnt_seq.value = "";
		    	    }//if
		    	    preCustCntSeq = custCntSeq ;
		    		
		    	}else{
		    		return;
		    	}
		    }else if(ComIsEmpty(custCntSeq) ){
		    	formObj.new_target_flag_hidden.value = "" ;
		    	formObj.cust_nm.value = "" ;
		    	preCustCntSeq = "" ;
		    }

}


function chkLenthOver(obj, len, msg) {
	var result = true ;
	
	if(ComGetLenByByte(obj.value)<len){
		ComShowMessage(ComGetMsg('COM12143', msg, len));
        obj.focus() ;
        result = false ;
	}
	
	return result ;
}

function openESD_SCE_915(sheetObj){
    var row = sheetObj.SelectRow  ;
  
  	if(row < 0){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}
  
    var bkgNo      = sheetObj.CellValue(row, "bkg_no") ;

    newForm  = "<form name='form1' method='post'>" ;
    newForm += "  <input type='hidden' name='bkg_no'       value='" + bkgNo + "'>" ;
    newForm += "</form>"
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "bkg_no="+bkgNo;
    var newWin = window.showModalDialog("ESD_SCE_0915.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:415px");
//    var newWin  = window.open("","bkg_info_win", "width=810,height=425," + getCenterXY(810, 425));
//    formObj.action = "ESD_SCE_0915.do" ;
//    formObj.target = "bkg_info_win" ;
//    formObj.submit() ;
}

function goESD_SCE_006(sheetObj){
	var row = sheetObj.SelectRow  ;
	if(row < 0){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}
	
  	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(row, "cop_no") + "'>" ;
    newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(row, "bkg_no") + "'>" ;
    newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "eq_no") + "'>" ;
    newForm += "  <input type='hidden' name='pgmNo'      value='ESD_SCE_0006'>" ;	
    newForm += "</form>"   
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
	formObj.action = "ESD_SCE_0006.do";
	formObj.submit() ;
}  

function goESD_SCE_044(sheetObj){
	var row = sheetObj.SelectRow  ;
	
	if(row < 0){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}
	
  	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='trsp_so_ofc_cty_cd' value='" + sheetObj.CellValue(row, "trsp_so_ofc_cty_cd") + "'>" ;
    newForm += "  <input type='hidden' name='trsp_so_seq'        value='" + sheetObj.CellValue(row, "trsp_so_seq") + "'>" ;
    newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "eq_no") + "'>" ;
    newForm += "</form>"
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "cntr_no="+sheetObj.CellValue(row, "eq_no")+"&trsp_so_ofc_cty_cd="+sheetObj.CellValue(row, "trsp_so_ofc_cty_cd")+"&trsp_so_seq="+sheetObj.CellValue(row, "trsp_so_seq");
    var newWin = window.showModalDialog("ESD_SCE_0044.do?"+paramUrl, "clm_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");
//    var newWin  = window.open("","clm_win", "width="+800+",height=525," + getCenterXY(screen.width, 500));
//    formObj.action = "ESD_SCE_0044.do" ;
//    formObj.target = "clm_win" ;
//    formObj.submit() ;
}


function getCenterXY(w, h){
    	
	var height = screen.availHeight ; 
	var width = screen.availWidth ; 
	
	var leftpos = width/2 - w/2; 
	var toppos = height/2 - h/2; 
	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;
	
	return "left=" + leftpos + ", top=" + toppos ;
}

function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0038GS.do", selectVal, "i_page=" + PageNo, true);
}

function sheet_OnAfterColumnMove(sheetObj, col, newPos){
	var newColName = sheetObj.ColSaveName(newPos) ;
	switch (newColName) {
		case "bkg_no":
			if (col > newPos){
				 newPos = newPos+1;
			}
			
  			sheetObj.MoveColumnPos("bkg_no_split", newPos, false);
			break;

		default:
			break;
	}

}

function chgDateKind(val){
	var formObj = document.form ;
	if(val==""){
		formObj.fm_dt.value    = "" ;
		formObj.to_dt.value    = "" ;
		formObj.fm_dt.readOnly = true ;	
		formObj.to_dt.readOnly = true ;	
	}
	else{
		formObj.fm_dt.readOnly = false ;	
		formObj.to_dt.readOnly = false ;	
	}
}

