/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1518.js
*@FileTitle  : ESM_BKG-1518
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/09
=========================================================*/
/*******************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 *           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var comboCnt=0;
	var comboObjects=new Array();
	var sheetCnt=0;
	var bkgNo='' ;
	var kind='' ;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 /** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
		 var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
		 /** **************************************************** */
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					formObject.reset();
					//doActionIBSheet(sheetObjects[0], formObject, COMMAND11);
				break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1 && sheetObject2.RowCount() < 1) { //no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),  Merge:1});
					}
				break;
				case "btn_cuscar":
					doActionIBSheet(sheetObject2, formObject, MULTI01);
					break;
				break;
				case "btn_view":
					doActionIBSheet(sheetObject2, formObject, MULTI02);
				break;
				case "btn_transfer":
					doActionIBSheet(sheetObject2, formObject, MULTI03);
				break;
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}

	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();

		for ( var k=0 ; k < comboObjects.length ; k++ ) {
			initCombo(comboObjects[k], k+1);
		}

		if( document.form.vvd.value != ""){
			var formObject = document.form;
			var vvdValue = formObject.vvd.value;
			document.form.f_cmd.value = SEARCH;
			sheetObjects[2].DoSearch("ESM_BKG_1518GS.do", FormQueryString(document.form) + "&vvd=" + vvdValue);

		}

	}
	function initControl() {
		// Event needed for screen
//		axon_event.addListenerForm("keyup","obj_KeyUp", document.form);
//		axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);
		axon_event.addListenerForm("blur", "obj_blur", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}

	/**
	 * process when you enter retrieve condition
	 */
	function obj_blur() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName == "vvd") {
			var vvdValue=formObject.vvd.value;
			if (ComChkLen(vvdValue, 9) == "2" ) {
				formObject.f_cmd.value = SEARCH;
				sheetObjects[2].DoSearch("ESM_BKG_1518GS.do?vvd="+vvdValue, FormQueryString(formObject));
				if(vvdValue != '') formObject.pol_cd.focus();
			}
		}
	}

	// 조회후 처리 함수
	function sheet3_OnSearchEnd(sheetObj, Code, Msg) {
		var vvdValue = sheetObj.GetCellValue(1, "vvd");
		var vvdNm = sheetObj.GetCellValue(1, "vvd_nm");
		var eta = sheetObj.GetCellValue(1, "eta_dt");
		if (vvdNm != "-1") document.form.vsl_name.value=vvdNm;
		//if(vvdValue != "-1") doActionIBSheet( sheetObjects[0], document.form, IBSEARCH );
	}

	/**
	 * setting sheet initial values and header param :
		 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
				with(sheetObj){
					var HeadTitle1="|Seq.|POL|POL ATD|POD|BDR|BDR DATE|B/L|SND|ACPT|ERR|CNTR|SND|ACPT|ERR";
					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag"    },
								 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"SEQ"       },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol"       },
								 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"pol_atd"   },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod"       },
								 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bdr"       },
								 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bdr_date"  },
								 {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"bl"        },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"dnld"      },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"acpt"      },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"diff"      },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr"      },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_dnld" },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_acpt" },
								 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"cntr_diff" } ];

					InitColumns(cols);
					SetSheetHeight(185);
					SetWaitImageVisible(0);
					SetEditable(1);
					SetColProperty("pol_atd", {Format:"YmdHms"} );
					SetColProperty("bdr_date", {Format:"YmdHms"} );
				}
				break;
			case 2:      // sheet2 init
				with(sheetObj){

					var HeadTitle1="|Sel.|Seq.|Kind|Status|ECI No|B/L No.|A|A|S|Last EDI|Last EDI|CNTR|A|A|S|Last EDI|Last EDI|TS|POR|POL|POD|DEL|PRE|POST|BDR|PKG|PKG|WGT|WGT|Description|Notify Name" +
									// Hidden column
									"|vvd_pod_cd|vvd_pol_cd|mrn_no|svc_rqst_no|cnee_addr|prev_docno|cm_pck_qty|anr_msg_sts_cd|lloyd_cd|pagerows|cntr_seq|brth_desc|cntr_wgt_ut_cd|vvd_seq|cntr_pck_tp_cd|rd_term|vvd|bkg_no|ntfy_name1|decl_flg|ibflag|act_wgt_ut_cd|shpr_addr|cntr_mf_desc|cm_cntr_no|anr_decl_no|ntfy_addr|cntr_anr_msg_sts_cd|act_wgt|cm_pck_tp_cd|sequence|cntr_pck_qty22|cntr_fm|msg_tp_cd|msg_seq|s3|pck_qty|cntr_mf_wgt";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sStatus"             },
								 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sel"                 },
								 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq"                 },
								 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"kind",        Edit:1 },
								 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"status"              },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eci_no_yn"           },
								 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no"               },
								 {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack2"             },
								 {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bl_ack"              },
								 {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s1"                  },
								 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi2"        },
								 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_last_edi"         },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no"             },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack2"           },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ack"            },
								 {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s2"                  },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi2"      },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_last_edi"       },
								 {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd"        },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd"              },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd"              },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd"              },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd"              },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd"     },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd"     },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg"             },
								 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd"           },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_pck_qty"        },
								 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd"           },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt_qty"        },
								 {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:"mf_desc"             },
								 {Type:"Text",      Hidden:0, Width:350,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_name"           },

								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd_pod_cd"          },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vvd_pol_cd"          },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"mrn_no"              },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"svc_rqst_no"         },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr"           },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"prev_docno"          },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_qty"          },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_msg_sts_cd"      },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"lloyd_cd"            },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"pagerows"            },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_seq"            },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"brth_desc"           },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_wgt_ut_cd"      },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd_seq"             },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_tp_cd"      },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"rd_term"             },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vvd"                 },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no"              },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_name1"          },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"decl_flg"            },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ibflag"              },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt_ut_cd"       },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr"           },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_desc"        },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_cntr_no"          },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"anr_decl_no"         },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr"           },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_anr_msg_sts_cd" },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"act_wgt"             },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cm_pck_tp_cd"        },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"sequence"            },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_pck_qty22"      },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_fm"             },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_tp_cd"           },
								 {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"msg_seq"             },
								 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s3"                  },
								 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty"             },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt"         } ];

					InitColumns(cols);
					SetSheetHeight(332);
					SetWaitImageVisible(0);
					SetEditable(1);
					//SetColProperty("kind", {ComboText:"Original|Cancel|", ComboCode:"O|C|N"} );
					SetColProperty("kind", {ComboText:"Cancel ECI|Add Consignment|Cancel Consignment|Original", ComboCode:"1|2|3|9"} );
					SetCountPosition(0);
				}
				break;
			case 3:
				with(sheetObj) {
					var HeadTitle1="|SEQ|VVD|SSR_NO|VVD_NM|ETA_DT";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								 {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq"    },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd"    },
								 {Type:"Text",      Hidden:0, Width:155,  Align:"Center",  ColMerge:1,   SaveName:"ssr_no" },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd_nm" },
								 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt" } ];

					InitColumns(cols);
					SetSheetHeight(100);
					SetVisible(false);
					SetEditable(1);
				}
				break;

		}
	}


	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      // Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					var xmlArr = sheetObj.GetSearchData("ESM_BKG_1518GS.do", FormQueryString(formObj)).split("|$$|");
					if (ComGetEtcData(xmlArr[0], "TRANS_RESULT_KEY") == "F") {
						sheetObj.LoadSearchData(xmlArr[0], { Sync : 1 });
					} else if (ComGetEtcData(xmlArr[1], "TRANS_RESULT_KEY") == "F") {
						sheetObjects[1].LoadSearchData(xmlArr[1], { Sync : 1 });
					} else {
						sheetObj.LoadSearchData(xmlArr[0], { Sync : 1 });
						sheetObjects[1].LoadSearchData(xmlArr[1], { Sync : 1 });
					}
				}
				break;

			case MULTI03:
				if(validateForm(sheetObj,formObj,sAction) ) {
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI03;
					var saveString = ComSetPrifix(sheetObj.GetSaveString(false, true, "sel"), "sheet4_");
					var sXml = sheetObj.GetSearchData("ESM_BKG_1518GS.do", saveString + "&" + FormQueryString(formObj));
					var key = ComGetEtcData(sXml, "KEY");
					intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				}
				break;

			case MULTI01:
				if(validateForm(sheetObj,formObj,sAction)) {
					if( sheetObjects[1].RowCount()> 0 ){
						for(var i=1; i<sheetObj.RowCount()+1; i++ ){
							if( sheetObj.GetCellValue(i,"sel") == "1") {
								if (sheetObj.GetCellValue(i,"status") == "Error") {
									var param = "?f_cmd=" + SEARCH09 + "&bl_no=" + sheetObj.GetCellValue(i, "bl_no") +
												"&vvd_pod_cd=" + sheetObj.GetCellValue(i, "vvd_pod_cd") +
												"&cntr_no=" + sheetObj.GetCellValue(i, "cntr_no") +
												"&vvd=" + formObj.vvd.value;
									ComOpenPopup("ESM_BKG_1518_01.do" + param, 650, 380, "", "1,0", true);
								}
							}
						}
					}
				}
				break;

			case MULTI02:
				if( validateForm(sheetObj,formObj,sAction) ){
					if( sheetObjects[1].RowCount()> 0 ){
						//ComOpenWindowCenter("ESM_BKG_0045_POP.do?pgmNo=ESM_BKG_0045&popup=y&bl_no=" + blNo + "&pKind=" + kind, "0045", 1020, 750);
						var param = "?bkg_no="+ bkgNo + "&isPop=N" + "&pgmNo=ESM_BKG_0079_Q_POP";
						ComOpenPopup("ESM_BKG_0079_Q_POP.do" + param, 1278, 730, "", "0,1");
					}
				}
				break;

			case COMMAND11 : //  PORT 조회
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchData("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=NZ&cstms_div_id=NZ_PORT_LIST");
				var arrXml = sXml.split("|$$|");
				ComXml2ComboItem(arrXml[0], pod, "pod_cd", "pod_cd");
				formObj.pod.Code = formObj.in_pod.value;
				pod.SetSelectText(formObj.in_pod.value);
				if(pod.GetSelectIndex() < 0) pod.SetSelectIndex(0,true);
				ComOpenWait(false);
				break;
		}
	}

	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		if (!ComChkValid(formObj)) return;
		switch (sAction) {
			case IBSEARCH: // Retrieve
				if (formObj.vvd.value == "" ) {
					ComShowCodeMessage('BKG00626','VVD');
					formObj.vvd.focus();
					return false;
				}
				return true;
			break;

			case MULTI03:
				var chkCnt=0;
				var chkKindVal="";
				var chkKindCnt=0;

				for(var i=1; i<sheetObj.RowCount()+1; i++ ){
					if( sheetObj.GetCellValue(i,"sel") == '1' ) {
						if(chkCnt == 0){
							chkKindVal = sheetObj.GetCellValue(i,"kind")
						}
						if(chkKindVal != sheetObj.GetCellValue(i,"kind")){
							chkKindCnt++;
						}
						chkCnt ++;
					}
				}

				if( chkCnt == 0 ) {
					ComShowCodeMessage('BKG00249','');
					return false;
				}

				if( chkKindCnt > 0 ) {
					ComShowCodeMessage('BKG00651','kind');
					return false;
				}

				//before transmitting, ask msg
				if (!ComShowCodeConfirm("BKG06200", "CUSCAR")){
					return false;
				}
				return true;
			break;

			case MULTI01:
				var chkCnt=0;
				for(var i=1; i<sheetObj.RowCount()+1; i++ ){
					if( sheetObj.GetCellValue(i,"sel") == '1' ) {
						chkCnt ++;
					}
				}
				if( chkCnt == 0 ) {
					ComShowCodeMessage('BKG00249','');
					return false;
				}
				if( chkCnt > 1 ) {
					ComShowCodeMessage('BKG00733','');
					return false;
				}
				return true;
			break;

			case MULTI02:
				if (bkgNo == "") {
					ComShowCodeMessage('BKG00249','');
					return false;
				}
				return true;
				break;
		}
	}

	function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
		ComOpenWait(false);
		if(sheetObj.RowCount() > 0){
			sheetObj.SetSumValue(0, "SEQ", "TOTAL");
		}
	}

	function sheet1_OnDownFinish(sheetObj, downloadType, result) {
		sheet2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]),  Merge:1});
	}

	/**
	 * Process for double click
	 *
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet2_OnDblClick(sheetObj, row, col) {
		doActionIBSheet(sheetObj, document.form, MULTI02);
	}

	function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg){
		for(var i=1; i<=sheetObj.RowCount(); i++){
			sheetObj.SetCellValue(i,"kind",'9',0);
			if(sheetObj.GetCellValue(i,"mrn_no") != '') {
				sheetObj.SetCellValue(i,"eci_no_yn",'Y',0);
			}
		}
		ComOpenWait(false);
	}

	/**
	 * Process for double click
	 *
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet2_OnClick(sheetObj, row, col, Value) {
		bkgNo = sheetObj.GetCellValue(row, "bkg_no");
		kind = sheetObj.GetCellValue(row, "kind");
		var formObject = document.form;

		with (sheetObj) {
			switch (ColSaveName(col)) {
				case "status":
					if (Value == "Error") {
						var param = "?f_cmd=" + SEARCH09 + "&bl_no=" + GetCellValue(row, "bl_no") +
									"&vvd_pod_cd=" + GetCellValue(row, "vvd_pod_cd") +
									"&cntr_no=" + GetCellValue(row, "cntr_no") +
									"&vvd=" + formObject.vvd.value;
						ComOpenPopup("ESM_BKG_1518_01.do" + param, 650, 380, "", "1,0", true);
					}
					break;
			}
		}
	}

	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "kind") {
			var eci_no_yn = sheetObj.GetCellValue( Row, "eci_no_yn" );
			if (Value != "9" && eci_no_yn == "") {
				ComShowCodeMessage('BKG06133','ECI No');
				sheetObj.SetCellValue(Row,"kind",'9',0);
			}
		}
	}

	function initCombo(comboObj, comboId) {
		var formObject = document.form
		if (comboObj.options.id == "pod") {
			BackColor = "#CCFFFD";
		}
	}

	/**
	 * BackEndJob 실행결과조회.
	 */
	function doActionValidationResult(sheetObj, sKey) {
		var sXml=sheetObj.GetSearchData("ESM_BKG_1518GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		// 에러가 발생했을 경우 대기사항을 종료한다.
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// 성공메시지 보여주고
			ComShowCodeMessage('BKG00101');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			return;
		} else if (sJbStsFlg == "FAIL") {
			//에러
			clearInterval(intervalId);
			ComOpenWait(false);
			// 에러메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
		}
	}
