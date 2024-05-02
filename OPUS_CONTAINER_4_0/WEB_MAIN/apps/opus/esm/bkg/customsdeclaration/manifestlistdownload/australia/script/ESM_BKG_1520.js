/* =========================================================
*Copyright(c) CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1520.js
*@FileTitle  : Aus DG EDI Transmit
*@author     : CLT
*@version    : 1.0
*@since      :
 ========================================================= */

//Common global variable
var sheetObjects = new Array();
var sheetCnt=0;
var comboObjects = new Array();
var comboCnt=0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, SEARCH02);
				break;

				case "btn_new":
					pageReset(formObject);
					// Declaration init
					initDeclarationType(formObject.init_d_type.value);
				break;

				case "btn_edi_transmit":
					if (sheetObject2.CheckedRows("check") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					doActionIBSheet(sheetObject2, formObject, MULTI01);    // 실제 f_cmd = COMMAND01 임에 주의
				break;

				case "btn_edi_cancel":
					if (sheetObject2.CheckedRows("check") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					doActionIBSheet(sheetObject2, formObject, MULTI02);    // 실제 f_cmd = COMMAND01 임에 주의
				break;

				case "btn_down_excel":
					doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
					// sheetObject2.SpeedDown2Excel(-1);
				break;

				case "d_type1": // Declration 선택시(Discharging)
				case "d_type2": // Declration 선택시(Trasit)
				case "d_type3": // Declration 선택시(Loading)
				case "d_type4": // Declration 선택시(Pre-Carriage)
				case "d_type5": // Declration 선택시(On-Carriage)
					var dTypeVal = declarationCheckValue();    // 선택된 체크박스 값 구하기
					dTypeCheckValidate(dTypeVal, srcName);    // 체크 벨리데이션
				break;

			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}


	/**
	 * 페이지 초기화
	 * @param formObject
	 * @return
	 */
	function pageReset(formObject) {
		ComResetAll();
	}


	/**
	 * declaration 필드 선택값 리턴
	 *
	 * @return
	 */
	function declarationCheckValue() {
		var formObj=document.form;
		var retVal="";
		for (var i=1; i<=5; i++) {
			var dTypeFlag="formObj.d_type" + i + ".checked";
			var dTypeValue="formObj.d_type" + i + ".value";
			if (eval(dTypeFlag)) retVal += eval(dTypeValue);
		} // end for(i)
		return retVal;
	}


	/**
	 * Declaration 체크 Validation
	 * @return
	 */
	function dTypeCheckValidate(dTypeVal, srcName) {
		var formObj=document.form;
		//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
		switch (srcName) {
			case "d_type1" :	// Discharging
				switch (dTypeVal) {
					case "DT" :
					case "DL" :
					case "DP" :
					case "DLP" :
						formObj.d_type1.checked=false;
				}
			break;

			case "d_type2" : 	// Transit
				switch (dTypeVal) {
					case "DT" :
					case "TL" :
					case "TP" :
					case "TO" :
					case "TLP" :
					case "DTO" :
						formObj.d_type2.checked=false;
				}
			break;

			case "d_type3" : 	// Loading
				switch (dTypeVal) {
					case "DL" :
					case "TL" :
					case "LO" :
					case "DLO" :
						formObj.d_type3.checked=false;
				}
			break;

			case "d_type4" : 	// Pre-Carriage
				switch (dTypeVal) {
					case "DP" :
					case "TP" :
					case "PO" :
					case "DPO" :
						formObj.d_type4.checked=false;
				}
			break;

			case "d_type5" : 	// On-Carriage
				switch (dTypeVal) {
					case "TO" :
					case "LO" :
					case "PO" :
					case "LPO" :
						formObj.d_type5.checked=false;
				}
			break;

			default :
				formObj.d_type1.checked=false;
			break;

		} // end switch
		var newType=declarationCheckValue();
		formObj.d_type.value=(newType == "LP") ? "PL" : newType;
	}


	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	/**
	 * 콤보 Object를 comboObjects 배열에 등록
	 *
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}


	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage(dType) {
		if (dType == null) dType = "";
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// Declaraion Init
		initDeclarationType(dType);
		var comboObjMaxLen=comboObjects.length;
		for (i=0; i < comboObjMaxLen; i++) {
			// IBCombo 초기화
			initCombo(comboObjects[i], i + 1);
		}
		// 화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerForm('click', 'objClick', form );
		axon_event.addListenerForm('change', 'obj_change', document.form); // change
		axon_event.addListenerForm('click', 'obj_click', document.form); // click
	}


	/**
	 *  Declaration 필드를 초기화 셋팅한다.<br>
	 * @return
	 */
	function initDeclarationType(dType) {
		var formObj = document.form;
		if (dType == "D") {
			formObj.d_type1.checked=true;
			formObj.d_type.value="D";
		} else if (dType == "T") {
			formObj.d_type2.checked=true;
			formObj.d_type.value="T";
		} else if (dType == "L") {
			formObj.d_type3.checked=true;
			formObj.d_type.value="L";
		} else if (dType == "P") {
			formObj.d_type4.checked=true;
			formObj.d_type.value="P";
		} else if (dType == "O") {
			formObj.d_type5.checked=true;
			formObj.d_type.value="O";
		} else {
			formObj.d_type1.checked=true;
			formObj.d_type.value="D";
		}
	}


	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1": // 상단 master 정보
			with (sheetObj) {
				SetSheetHeight(100);
				if (location.hostname != "")
				var HeadTitle = "|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_eng_nm|vsl_cnt_cd|lloyd_no|call_sgn_no|anr_role_div_cd|ssr_no|ack_rslt_id|local_db_yn";
				var headCount=ComCountHeadTitle(HeadTitle);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"d_type" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"vvd_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"port_cd" },
							 {Type:"Date",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"eta_d",   Format:"Ymd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"eta_t",   Format:"Hm"  },
							 {Type:"Date",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"etd_d",   Format:"Ymd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",   SaveName:"etd_t",   Format:"Hm"  },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"brth_yd_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"yd_nm"      },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"auto_snd_tp_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"vsl_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"vsl_eng_nm" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"vsl_cnt_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"lloyd_no" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"call_sgn_no" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"anr_role_div_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"svc_rqst_no" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"ack_rcv_sts_cd" },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",     SaveName:"local_db_yn" } ];

				InitColumns(cols);

				SetEditable(1);
				InitViewFormat(0, "eta_d", "yyyymmdd");
				InitViewFormat(0, "eta_t", "hhmm");
				InitViewFormat(0, "etd_d", "yyyymmdd");
				InitViewFormat(0, "etd_t", "hhmm");
				SetVisible(0);
			}
			break;

		case "sheet2":
			with (sheetObj) {
				SetSheetHeight(290);
				if (location.hostname != "")
				var HeadTitle = "|merge_bl_no|Sel.|Seq.|bkg_no|B/L No.|POL|POD|CNTR No." +
								"|MVMT\nStatus|Tank\nCNTR|IMO\nClass|UN No.|Substances|Quantity|Package|Weight|Flash Point|Send Type|Msg Snd No|First Msg Snd No" +
								"|DG\nInquiry|Cell Position|Class|Compati\n-bility|UN No.|S.D/G|Flash\nPoint|Package\nGroup|Forwarder\nCode|Carriage\nType|On-Carriage Date|SSR\n(Feeder)|Vessel Name\n(Feeder)|Lloy No\n(Feeder)|VVD\n(Feeder)" +
								"|Outer\nQty|Outer\nCode|EMS|Net Weight|Gross Weight|Packages|Substance|Hazardous Contents|cntr_cgo_seq|in_imdg_pck_qty1|in_imdg_pck_cd1|cntr_tpsz_cd|in_pck_desc|out_pck_desc" +
								"|Sub Label 1|Sub Label 2|Sub Label 3|Sub Label 4|Scr File No|group_cnt|DG_SHORT_NM_CNT|CNTR_CNT|IMDG_UN_NO_SEQ";
				var headCount=ComCountHeadTitle(HeadTitle);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:20, DataRowMerge:0 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",     Hidden:1,   Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",       Hidden:1,   Width:90,   Align:"Center",  ColMerge:1,   SaveName:"merge_bl_no",       Format:"",            UpdateEdit:0,   InsertEdit:0 },
							{Type:"DummyCheck", Hidden:0,   Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
							{Type:"Text",       Hidden:0,   Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               Format:"",            UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
							{Type:"Text",       Hidden:0,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
							{Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
							{Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
							{Type:"Text",       Hidden:0,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
							{Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
							{Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tnk_cntr_flg",      Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
							{Type:"Text",       Hidden:0,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      Format:"",            UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",       Hidden:0,   Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",        Format:"",            UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
							{Type:"Text",       Hidden:0,   Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",        Format:"",            UpdateEdit:0,   InsertEdit:1 },
							{Type:"Int",        Hidden:0,   Width:80,   Align:"Right",   ColMerge:0,   SaveName:"out_imdg_pck_qty1", Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",       Hidden:0,   Width:200,  Align:"Left",    ColMerge:0,   SaveName:"packages",          Format:"",            UpdateEdit:0,   InsertEdit:1 },
							{Type:"Float",      Hidden:0,   Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",           Format:"Float",       UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",      Hidden:0,   Width:80,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_cdo_temp", Format:"NullFloat",   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",       Hidden:0,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"send_type",         Format:"",            UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",       Hidden:0,   Width:130,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_no",        Format:"",            UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",       Hidden:0,   Width:130,  Align:"Center",  ColMerge:0,   SaveName:"first_msg_snd_no",  Format:"",            UpdateEdit:0,   InsertEdit:0 },

							{Type:"Text",       Hidden:1,   Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dg"                    },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cell_psn_no"           },
							{Type:"Text",       Hidden:1,   Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd"      },
							{Type:"Text",       Hidden:1,   Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dg_short_nm"           },
							{Type:"Text",       Hidden:1,   Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd"       },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fwrd_id"               },
							{Type:"Text",       Hidden:1,   Width:60,   Align:"Center",  ColMerge:0,   SaveName:"c_type"                },
							{Type:"Text",       Hidden:1,   Width:120,  Align:"Center",  ColMerge:1,   SaveName:"crr_dt"                },
							{Type:"Text",       Hidden:1,   Width:120,  Align:"Right",   ColMerge:0,   SaveName:"fdr_svc_rqst_no"       },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vsl_nm"            },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vsl_lloyd_no"      },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vvd_id"            },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"out_imdg_pck_cd1"      },
							{Type:"Text",       Hidden:1,   Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ems_no"                },
							{Type:"Text",       Hidden:1,   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt"               },
							{Type:"Text",       Hidden:1,   Width:0,    Align:"Left",    ColMerge:0,   SaveName:"hzd_desc"              },
							{Type:"Text",       Hidden:1,   Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_cgo_seq"          },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Right",   ColMerge:0,   SaveName:"in_imdg_pck_qty1"      },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"in_imdg_pck_cd1"       },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd"          },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"in_pck_desc"           },
							{Type:"Text",       Hidden:1,   Width:80,   Align:"Center",  ColMerge:0,   SaveName:"out_pck_desc"          },
							{Type:"Text",       Hidden:1,   Width:95,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd1" },
							{Type:"Text",       Hidden:1,   Width:95,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd2" },
							{Type:"Text",       Hidden:1,   Width:95,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd3" },
							{Type:"Text",       Hidden:1,   Width:95,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd4" },
							{Type:"Text",       Hidden:1,   Width:110,  Align:"Center",  ColMerge:0,   SaveName:"scr_file_no"           },
							{Type:"Text",       Hidden:1,   Width:110,  Align:"Center",  ColMerge:0,   SaveName:"group_cnt"             },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dg_short_nm_cnt"       },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_cnt"              },
							{Type:"Text",       Hidden:1,   Width:100,  Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq"        } ];
				InitColumns(cols);

				SetEditable(1);
				SetColProperty("c_type", {ComboText:"|TBN|ROAD|RAIL|BARGE|MARINTIME", ComboCode:"|X|T|R|B|V"} );
				SetColProperty("imdg_pck_grp_cd", {ComboText:"|I|II|III|N", ComboCode:"|1|2|3|N"} );
				InitViewFormat(0, "crr_dt", "yyyymmdd");
				FrozenCols=8;
			}
			break;
		}
	}


	/**
	 * Combo Object 초기화
	 *
	 * @param comboObj
	 * @param comNo
	 * @return
	 */
	function initCombo(comboObj, comNo) {
		var i=0;
		switch(comboObj.options.id) {
			case "reason_resending": {
				i=0;
				with (comboObj) {
					InsertItem(i++, "", "");
					InsertItem(i++, "Mistake in previous notification", "CAM");
					InsertItem(i++, "Operation not carried out", "CAO");
					InsertItem(i++, "Change of dates of stay of truck/train/barge in the port", "CHD");
					InsertItem(i++, "Change of means of transport", "CHM");
					InsertItem(i++, "Change of name of vessel", "CHV");
					InsertItem(i++, "Specify TBN-container", "TBC");
					InsertItem(i++, "Specify TBN-forwarder", "TBF");
					InsertItem(i++, "Specify TBN-vessel/barge name", "TBN");
					Code="";
				}
				break;
			}
		} // end switch
	}


	/**
	 * Sheet관련 프로세스 처리
	 *
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, row, col) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case SEARCH02: // Retrieve버튼 클릭시 조회
				if (!validateForm(sheetObj, formObj, sAction)) return;
				ComOpenWait(true);
				// 선택된 체크박스 값 구하기
				var dType1Checked = formObj.d_type1.checked;
				var dType2Checked = formObj.d_type2.checked;
				var dType3Checked = formObj.d_type3.checked;
				var dType4Checked = formObj.d_type4.checked;
				var dType5Checked = formObj.d_type5.checked;
				var vvdCd = formObj.vvd_cd.value;
				var portCd = formObj.port_cd.value;
				var searchType = formObj.search_type.value;

				ComResetAll();

				formObj.d_type1.checked = dType1Checked;
				formObj.d_type2.checked = dType2Checked;
				formObj.d_type3.checked = dType3Checked;
				formObj.d_type4.checked = dType4Checked;
				formObj.d_type5.checked = dType5Checked;
				formObj.vvd_cd.value = vvdCd;
				formObj.port_cd.value = portCd;
				formObj.search_type.value = searchType;

				formObj.f_cmd.value = SEARCH02;
				var xmlStr = sheetObj.GetSearchData("ESM_BKG_1520GS.do", FormQueryString(formObj));
				if (!ComBkgErrMessage(sheetObj, xmlStr)) return;
				var arrXml = xmlStr.split("|$$|");
				formObj.cntr_cnt.value = ""; // Total Container 필드 초기화
				sheetObjects[0].LoadSearchData(arrXml[0], {Sync:1});
				sheetObjects[1].LoadSearchData(arrXml[1], {Sync:1});

				// 조회 조건 값을 hidden으로 저장해 둔다.
				setSearchCond(sheetObjects[1], formObj);
			break;

			case IBDOWNEXCEL: // 엑셀
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
			break;

			case MULTI01: // Flat File 생성 및 EDI전송
			case MULTI02: // Flat File 생성 및 EDI전송(CANCEL 전송)
				IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return;
				}
				if (sAction == MULTI01) {
					formObj.trans_type.value = "ORIGIN_SEND";
					if (!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
						// send type 조회시 상태로 초기화
						sheetObjects[1].CheckAll("check", 0, 1);
						ComOpenWait(false);
						return;
					}
				} else {
					formObj.trans_type.value = "CANCEL_SEND";
					if (!ComShowConfirm(ComGetMsg("BKG95003", "[EDI Cancel Transmit]"))) {
						ComOpenWait(false);
						return;
					}
				}
				formObj.f_cmd.value = COMMAND01;
				var saveString = sheetObj.GetSaveString(0, 1, "check");
				var xmlStr = sheetObj.GetSaveData("ESM_BKG_1520GS.do", FormQueryString(formObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					sheetObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;
		}
	}


	/**
	 * Call - BackEndJob : check jobState : '3'
	 */
	function getBackEndJobStatus() {
		var sheetObj2 = sheetObjects[1];
		var xmlStr = sheetObj2.GetSearchData("ESM_BKG_1520GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			xmlStr = "";
			xmlStr = sheetObj2.GetSaveData("ESM_BKG_1520GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey);
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
			if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
				ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
				doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
			} else {
				sheetObj2.LoadSaveData(xmlStr);
			}
		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}


	/**
	 * 다중 저장시 PREFIX 붙여주기
	 *
	 * @param sStr
	 * @param sPrefix
	 * @return
	 */
	function ComSetPrifix(sStr, sPrefix) {
		if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") return sStr;
		var regexp=RegExp(/&/g);
		sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
		return sStr;
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case SEARCH02:
				// 기본포멧체크
				if (!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
				break;

			case SEARCH04:
				// 기본포멧체크
				if (!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd)) return false;
				break;

			case SEARCH05:
				if (formObj.d_type.value != "" && formObj.vvd_cd.value != "") {
					//기본포멧체크
					if (!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd)) return false;
				}
				break;

			case IBDOWNEXCEL:
				if(sheetObj.RowCount()== 0) {
					ComShowCodeMessage('BKG00109');
					return false;
				}
				break;

			case MULTI01 :
			case MULTI02 : //Flat File 생성 및 EDI전송(CANCEL 전송 포함) validation
				if (sheetObjects[1].RowCount() == 0) {
					//ComShowMessage("전송할 데이타가 없습니다.");
					ComShowCodeMessage("BKG01096");
					return false;
				}
				// 조회시 사용된 조회조건 값이 변경된게 있는지 확인한다.
				if (formObj.hid_d_type.value != formObj.d_type.value || formObj.hid_vvd_cd.value != formObj.vvd_cd.value) {
					ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value);
					return false;
				}

				with (sheetObj) {
					for (var i=HeaderRows(); i<=LastRow(); i++) {
						if (GetCellValue(i, "check") == "1") {
							SetRowStatus(i, "I");
							if (sAction == MULTI01) {
								if (GetCellValue(i, "cntr_no") == "") {
									ComShowMessage("Unable to select due to undefined container No..");
									SelectCell(i, "cntr_no");
									return false;
								}
							}
							if (sAction == MULTI02) {
								if (GetCellValue(i, "send_type") == "") {
									ComShowCodeMessage("BKG06096");    // "Unable to send cancel message without original sent message."
									SelectCell(i, "send_type");
									return false;
								} else if (GetCellValue(i, "send_type") == "C") {
									ComShowCodeMessage("BKG06097", GetCellValue(i, "bl_no"));    // "B/L No.[{?msg1}] is already Canceled."
									SelectCell(i, "send_type");
									return false;
								}
							}
						} else {
							SetRowStatus(i, "");
						}
					}
				}
				break;
		} // end switch
		return true;
	}


	/**
	 * 조회 조건 값을 hidden으로 저장해 둔다.
	 * (save버튼 클릭시 조회조건이 변경 되는것을 막기위해 사용)
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function setSearchCond(sheetObj, formObj) {
		if(sheetObj.RowCount()> 0) {
			formObj.hid_d_type.value=formObj.d_type.value;
			formObj.hid_vvd_cd.value=formObj.vvd_cd.value;
		}
	}


	/**
	 * 폼 필드 변경시 이벤트
	 *
	 * @return
	 */
	function obj_change() {
		var srcName = ComGetEvent("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
	}


	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
		var srcName = ComGetEvent("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (srcName == "vvd_cd"  && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
		ComOpenWait(false);
		if (Code < 0) return;
		if (sheetObj.SearchRows() > 0) {
			var formObj = document.form;
			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
			formObj.frm_eta_d.value = ComGetMaskedValue(formObj.frm_eta_d.value, "ymd");
			formObj.frm_eta_t.value = ComGetMaskedValue(formObj.frm_eta_t.value, "hm");
			formObj.frm_etd_d.value = ComGetMaskedValue(formObj.frm_etd_d.value, "ymd");
			formObj.frm_etd_t.value = ComGetMaskedValue(formObj.frm_etd_t.value, "hm");
		}
	}


	/**
	 * 시트를 클릭했을 때 처리
	 */
	function sheet2_OnClick(sheetObj, row, col, value) {
		with (sheetObj) {
			switch(ColSaveName(col)) {
				case "check":
					ReDraw = false;
					var sameRows = "";
//					if (GetCellValue(row, "first_msg_snd_no") == "" || GetCellValue(row, "send_type") == "C") {

						// 선택된 row의 seq와 같은 row index를 검색 (Merge된 CheckBox에 체크/체크해제시 버그 보완수정)
						// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
						sameRows = ComFindAll(sheetObj, "seq", GetCellValue(row, "seq")).toString().split("|");
						// 검색된 row index들에 대한 처리
						for (var i in sameRows) SetCellValue(sameRows[i], "check", value);
/*
					} else {
						// 선택된 row의 first_msg_snd_no와 같은 row index를 검색
						// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
						var sameRows = ComFindAll(sheetObj, "first_msg_snd_no", GetCellValue(row, "first_msg_snd_no")).toString().split("|");
						// 검색된 row index들에 대한 처리
						for (var i in sameRows) {
							if (GetCellValue(sameRows[i], "send_type") != "C") SetCellValue(sameRows[i], "check", value);
						}
					}
*/
					ReDraw = true;
				break;

				/* 긴 문자열 MemoPad 처리*/
				case "packages" :
				case "prp_shp_nm" :
				case "hzd_desc" :
					ComShowMemoPad(sheetObj, null, null, true, 250, 80);
				break;
			} // end switch
		}
	}


	/**
	 * 시트를 더블클릭했을 때 처리
	 */
	function sheet2_OnDblClick(sheetObj, row, col, value) {
		sheet2_OnClick(sheetObj, row, col, value);
	}


	/**
	 * handling event after searching
	 */
	function sheet2_OnSearchEnd(sheetObj, Code, Msg) {
		ComOpenWait(false);
		if (Code < 0) return;
		if (sheetObj.RowCount() > 0) {
			with (sheetObj) {
				ReDraw = false;
				var rowNo = "";
/*
				// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
				var colNo1 = SaveNameCol("seq");
				var colNo2 = SaveNameCol("cntr_no");
				var noSndRows = ComFindAll(sheetObj, "msg_snd_no", "").toString().split("|");
				for (var i in noSndRows) {
					rowNo = parseInt(noSndRows[i]);
					SetRangeBackColor(rowNo, colNo1, rowNo, colNo2, "#C8FFC8");
				}

				// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
				var cancelRows = ComFindAll(sheetObj, "send_type", "C").toString().split("|");
				var colNo = SaveNameCol("check");
				for (var i in cancelRows) {
					rowNo = parseInt(cancelRows[i]);
					SetCellEditable(rowNo, colNo, false);
				}
*/
				// 조회된 컨테이너 Total Count를 setting한다.
				document.form.cntr_cnt.value = GetCellValue(HeaderRows(), "cntr_cnt");
				SetSelectRow(HeaderRows());
				ReDraw = true;
			}
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet2_OnSaveEnd(sheetObj, Code, Msg) {
		ComOpenWait(false);
		if (Code < 0) return;
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
		 var formObj = document.form;
		formObj.output1.value = sheetObjects[1].GetEtcData("originalFlatFile");
		formObj.output2.value = sheetObjects[1].GetEtcData("updateFlatFile");
		formObj.output3.value = sheetObjects[1].GetEtcData("cancelFlatFile");
		doActionIBSheet(sheetObjects[1], formObj, SEARCH02); // 재조회
		// Retrieve after saving
		doActionIBSheet(sheetObj, formObj, SEARCH02);
	}


