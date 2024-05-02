/*=========================================================
*Copyright(c) 2009 CyberLogitec         
*@FileName : ESM_BKG_0098.js
*@FileTitle : Booking Receipt Notice (Fax/E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.09 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2010.11.16 이일민 [CHM-201006562-01] Fax / Email / GroupEmail Exception 처리
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
* 2016.03.11 문동선 [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
* 2016.07.08 조창우 [CHM-201642288] booking receipt notice(fax/edi)에 VGM CUTOFF 기능 추가
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
     * @class ESM_BKG_0098 : ESM_BKG_0098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0098() {
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
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*********************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
	
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					ComResetAll();
					ComClearObject(formObject.bkg_ofc_cd);
					break;
	
				case "btn_Print":
					if(!validateForm(sheetObjects[0],formObject,"btn_Print")) {
						return false;
					}
					rdOpen(rdObjects[0], formObject, "print");
					break;
	
				case "btn_Preview":
					if(!validateForm(sheetObjects[0],formObject,"btn_Preview")) {
						return false;
					}
					rdOpen(rdObjects[0], formObject, "preview");
					break;
	
				case "btn_EditFaxEmail":
					if(!validateForm(sheetObjects[0],formObject,"btn_EditFaxEmail")) {
						return false;
					}
		        	//open popup 0221
		        	var width = 355;
					var height = 170;
					var left = (screen.width-width)/2;
					var top = (screen.height-height)/2;
					ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
					//send popup
					var formObject3 = document.form3;
					formObject3.elements["pop_mode"   ].value = "1";
					formObject3.elements["display"    ].value = "1,0,1,1,1,1,1";
					formObject3.elements["func"       ].value = "getCOM_Fax_Email_POPUP";
					formObject3.elements["row"        ].value = "0";
					formObject3.elements["col"        ].value = "0";
					formObject3.elements["sheetIdx"   ].value = "0";
					formObject3.elements["bkg_no"     ].value = "";
					formObject3.elements["send_hidden"].value = "Y";
					formObject3.action = "/hanjin/ESM_BKG_0221.do";
					formObject3.target = "ESM_BKG_0221";
					formObject3.submit();
					break;
	
				case "btn_AssignEmail":
					if(!validateForm(sheetObjects[0],formObject,"btn_AssignEmail")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],formObject,"btn_AssignEmail");
					break;
	
				case "btn_EditRemark":
					if(!validateForm(sheetObjects[0],formObject,"btn_EditRemark")) {
						return false;
					}
					comBkgCallPop0384('callBack0384');
					break;
	
				case "btn_EditCCT":
					if(!validateForm(sheetObjects[0],formObject,"btn_EditCCT")) {
						return false;
					}
		        	//open popup 0934
		        	var width = 300;
					var height = 530;
					var left = (screen.width-width)/2;
					var top = (screen.height-height)/2;
					ComOpenWindow("about:blank","ESM_BKG_0934","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
					//send popup
					var formObject4 = document.form4;
					formObject4.elements["row"        ].value = "0";
					formObject4.elements["col"        ].value = "0";
					formObject4.action = "/hanjin/ESM_BKG_0934.do";
					formObject4.target = "ESM_BKG_0934";
					formObject4.submit();
					break; 
				
				case "btn_EditVVD":
	//				if(!validateForm(sheetObjects[0],formObject,"btn_EditVVD")) {
	//					return false;
	//				}
					var tvvd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"tvvd")
					if(tvvd == "T/VVD")
						tvvd = "";
					var vslCd = tvvd.substring(0,4);
					var skdVoyNo = tvvd.substring(4,8);
					var skdDirCd = tvvd.substring(8,9);
	
		        	//open popup 
		        	var sUrl = "/hanjin/ESM_BKG_1150.do?vslCd="+vslCd+"&skdVoyNo="+skdVoyNo+"&skdDirCd="+skdDirCd;
		        	ComOpenPopup(sUrl, 500, 430, "", "0,0", true);	
		        	break;
	
				case "btn_Fax":
					if(!validateForm(sheetObjects[0],formObject,"btn_Fax")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],formObject,"btn_Fax");
					break;
	
				case "btn_Email":
					if(!validateForm(sheetObjects[0],formObject,"btn_Email")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],formObject,"btn_Email");
				break;
	
				case "btn_GroupEmail":
					if(!validateForm(sheetObjects[0],formObject,"btn_GroupEmail")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],formObject,"btn_GroupEmail");
					break;
	
				case "btn_EmailEdit":
					if(!validateForm(sheetObjects[0],formObject,"btn_EmailEdit")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],formObject,"btn_EmailEdit");
					break;
	
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					break;
	
				case "btns_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		initControl();
		
		initRdConfig(rdObjects[0]);
		
		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
			ComSetDisplay("btn_Fax1", false);
		}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            with (sheetObj) {
				// 높이 설정
				style.height = 320;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(1, 1, 2, 100);
	
	            var HeadTitle1 = "|Sel.||Booking No.|S|Kind|Shipper|Shipper|FF Code|Fax No.|Fax No.|E-mail|E-mail|Port CCT|Doc CCT|Rail Cut-Off|Rail Cut-Off|VGM CCT|T/VVD|POR|EQ OFC|POL|POD|DEL|BKG Staff|Contact PIC|Fax Result|Fax Result|Fax Date|E-mail Result|E-mail Result|E-mail Date|Remark(s)|New Flg|remark_backup|mnl_rail_from_cct|mnl_rail_to_cct";
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(38, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	
                SetMergeCell(0,1,1,2);

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		18,		daCenter,	false,	"slct_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"bkg_no",		false,	"",	dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,	"status",		false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"kind",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"shipper_code",	false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,	"shipper_name",	false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"ff_cd",		false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	"fax",			false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtPopup,		20,		daLeft,		false,	"fax_btn",		false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		false,	"eml",			false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtPopup,		20,		daLeft,		false,	"eml_btn",		false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"cct",			false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"doc_cct",		false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"rail_from_cct",false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"rail_to_cct",	false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"vgm_cct",	    false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"tvvd",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"por",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"eq_ofc",		false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"pol",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"pod",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"del",			false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"bkg_staff",	false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,	"contact_pic",	false,	"", dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"fax_result",	false,	"", dfNone,			0,	false,	true);
                InitDataProperty(0, cnt++,  dtPopup,        20,     daCenter,   false,  "fax_his_btn",  false,  "", dfNone,         0,  true,   true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"fax_date",		false,	"", dfUserFormat2,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"eml_result",	false,	"", dfNone,			0,	false,	true);
                InitDataProperty(0, cnt++,  dtPopup,        20,     daCenter,   false,  "eml_his_btn",  false,  "", dfNone,         0,  true,   true);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"eml_date",		false,	"", dfUserFormat2,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,	"remark",		false,	"", dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"new_flg");
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"remark_backup");
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"mnl_rail_from_cct");
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"mnl_rail_to_cct");
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,	"mnl_vgm_cct");

				InitUserFormat2(0, "fax_date",  "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "eml_date",  "####-##-## ##:##", "-|:" );

				ShowButtonImage = 1;
				//ImageList에 이미지를 설정한다.
				ImageList(0) = "img/btns_plus.gif";
				ImageList(1) = "img/btns_minus.gif";
				ImageList(2) = "img/btns_multisearch.gif";
				//특정컬럼에 팝업버튼 이미지 변경
				PopupButtonImage(0, 10) = 0;
				PopupButtonImage(0, 12) = 0;
				sheetObj.FrozenCols = 4;
            }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:      //초기화
				ComClearObject(formObj.bkg_from_dt);
				ComClearObject(formObj.bkg_to_dt);
				//ComClearObject(formObj.bkg_ofc_cd);
				ComClearObject(formObj.bkg_staff);
				ComClearObject(formObj.bkg_status);
				ComClearObject(formObj.bkg_kind);
				ComClearObject(formObj.vvd);
				ComClearObject(formObj.pol_cd);
				ComClearObject(formObj.pod_cd);
				ComClearObject(formObj.por_cd);
				ComClearObject(formObj.del_cd);
				ComClearObject(formObj.sales_ofc);
				ComClearObject(formObj.sales_rep);
				ComClearObject(formObj.bkg_no);
				ComClearObject(formObj.cust_tp_cd);
				ComClearObject(formObj.cust_seq);
				ComClearObject(formObj.cust_nm);
				ComClearObject(formObj.fax_proc_sts_cd);
				ComClearObject(formObj.eml_proc_sts_cd);
	
				formObj.bkg_from_dt.value = ComGetNowInfo();
				formObj.bkg_to_dt.value = ComGetNowInfo();
				formObj.cust_tp_cd.selectedIndex = 1;
				sheetObj.RemoveAll();
				if("Normal"!=ComGetObjValue(formObj.rtn_ofc_cd)){
					ComBtnDisable("btn_EditCCT");
					ComBtnDisable("btn_EditRemark");
				}
				break;
	
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	        	formObj.f_cmd.value = SEARCH;
	        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0098GS.do", FormQueryString(formObj));
		       	var arrXml = sXml.split("|$$|");
		       	for(var i = 0; i < arrXml.length; i++){ 
		       		sheetObjects[i].Redraw = false;    
		       		if(i > 0) {
	     				sheetObjects[i].WaitImageVisible = false;	
		       		}  
		       		sheetObjects[i].LoadSearchXml(arrXml[i]); 
		       		sheetObjects[i].Redraw = true; 
		       	}
		       	for (var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++) {
		       		sheetObjects[0].CellFontColor(i, 3) = sheetObjects[0].RgbColor(0, 0, 255);
	//	       		if("Normal"!=ComGetObjValue(formObj.rtn_ofc_cd)){
		       			sheetObj.CellEditable(i, "cct") = false;	       		
		       			sheetObj.CellEditable(i, "doc_cct") = false;
		       			sheetObj.CellEditable(i, "rail_from_cct") = false;
		       			sheetObj.CellEditable(i, "rail_to_cct") = false;
		       			sheetObj.CellEditable(i, "vgm_cct") = false;
	//	       		}
		       	}
		       	   
				formObj.fax_bkg_total.value = ComAddComma(ComGetEtcData(sXml, "faxBkgTotal"));
				formObj.eml_bkg_total.value = ComAddComma(ComGetEtcData(sXml, "emlBkgTotal"));
				formObj.fax_total.value = ComAddComma(ComGetEtcData(sXml, "faxTotal"));
				formObj.eml_total.value = ComAddComma(ComGetEtcData(sXml, "emlTotal"));
				formObj.fax_success.value = ComAddComma(ComGetEtcData(sXml, "faxSuccess"));
				formObj.eml_success.value = ComAddComma(ComGetEtcData(sXml, "emlSuccess"));
				formObj.fax_send.value = ComAddComma(ComGetEtcData(sXml, "faxSending"));
				formObj.eml_send.value = ComAddComma(ComGetEtcData(sXml, "emlSending"));
				formObj.fax_unsent.value = ComGetEtcData(sXml, "faxUnSent");
				formObj.eml_unsent.value = ComGetEtcData(sXml, "emlUnSent");
				break;
	
			case IBDOWNEXCEL:
				if (sheetObj.RowCount > 0) {
					sheetObj.SpeedDown2Excel(1);
				} else {
					ComShowMessage("BKG00155");
				}
				break;
	
			case "btn_AssignEmail":
				var arrRow = ComFindText(sheetObj, "slct_flg", 1);
				var bkg_no = "";
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						bkg_no += sheetObj.CellValue(arrRow[i],"bkg_no")+'|';
					}
					if (0<bkg_no.indexOf("|")) bkg_no = bkg_no.substring(0,bkg_no.length-1);
				}
				var formObject5 = document.form5;
				formObject5.elements["f_cmd" ].value = SEARCH03;
				formObject5.elements["bkg_no"].value = bkg_no;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0218GS.do", FormQueryString(formObject5));
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		        xmlDoc.async="false";
		        xmlDoc.loadXML(sXml);
		        var dataNode = xmlDoc.documentElement.getElementsByTagName("DATA").item(0);
				var sep = dataNode.getAttribute("COLSEPARATOR");
		        var dataChildNodes = dataNode.childNodes;
		        var succFlg = false;
		        if (0<dataChildNodes.length) {
		        	var agentEmail,agentBkgNo;
					for (var i=0; i<dataChildNodes.length; i++) {
					    agentEmail = dataChildNodes.item(i).firstChild.nodeValue.split(sep)[1];
					    agentBkgNo = dataChildNodes.item(i).firstChild.nodeValue.split(sep)[2];
					    if (""!=agentEmail) {
							if (arrRow && 0<arrRow.length) {
								for (var j=0; j<arrRow.length; j++) {
									if (agentBkgNo==sheetObj.CellValue(arrRow[j],"bkg_no")) {
										sheetObj.CellValue2(arrRow[j],"eml") = agentEmail;
										break;
									}
								}
							}
							succFlg = true;
					    }
					}
					if (succFlg) {
						ComShowCodeMessage("COM130405","BKG Agent E-mail");  //{?msg1} was retrieved successfully.
					}
		        }
		        if (!succFlg) {
		        	ComShowCodeMessage("COM130402","BKG Agent E-mail");  //{?msg1} doesn\'t exist
		        }
		        break;
	
			case "btn_Fax":
				formObj.f_cmd.value = MULTI01;
				var params = FormQueryString(formObj);
				var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
				var chkRow = chkRowArr.split("|");
				if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = sheetObjects[0].CellValue(chkRow[idx],"remark");
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = encodeRemark(sheetObjects[0].CellValue(chkRow[idx],"remark"));
					}
					params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0098GS.do", params);
					if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
						ComShowCodeMessage("BKG00496");
					}
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = sheetObjects[0].CellValue(chkRow[idx],"remark_backup");
						sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = "";
					}
					if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
				    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
				     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
				     		ComShowMessage(rmsg[3]);
				     	} else {
				     		sheetObjects[0].LoadSaveXml(sXml);
						}
					}
				}
				break;
	
			case "btn_Email":
				formObj.f_cmd.value = MULTI02;
				var params = FormQueryString(formObj);
				var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
				var chkRow = chkRowArr.split("|");
				if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = sheetObjects[0].CellValue(chkRow[idx],"remark");
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = encodeRemark(sheetObjects[0].CellValue(chkRow[idx],"remark"));
						
		    			if(sheetObjects[0].CellValue(chkRow[idx],"eml") != ""
			                && !ComIsEmailAddr(sheetObjects[0].CellValue(chkRow[idx],"eml"))){
			                ComShowCodeMessage("BKG40021" , sheetObjects[0].CellValue(chkRow[idx],"eml"));
			                return false;
			            }
					}
					params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0098GS.do", params);
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = sheetObjects[0].CellValue(chkRow[idx],"remark_backup");
						sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = "";
					}
					if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
				    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
				     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
				     		ComShowMessage(rmsg[3]);
				     	} else {
				     		sheetObjects[0].LoadSaveXml(sXml);
						}
					}
				}
				break;
	
			case "btn_GroupEmail":
				formObj.f_cmd.value = MULTI03;
				var params = FormQueryString(formObj);
				var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
				var chkRow = chkRowArr.split("|");
				if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
					sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = sheetObjects[0].CellValue(chkRow[idx],"remark");
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = encodeRemark(sheetObjects[0].CellValue(chkRow[idx],"remark"));
					}
					params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0098GS.do", params);
					if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
						ComSetObjValue(formObj.elements["edt_ntc_knd_cd" ],"");
						ComSetObjValue(formObj.elements["edt_bkg_no_list"],"");
						ComSetObjValue(formObj.elements["edt_to_eml"     ],"");
						ComSetObjValue(formObj.elements["edt_cc_eml"     ],"");
						ComSetObjValue(formObj.elements["edt_from_eml"   ],"");
						ComSetObjValue(formObj.elements["edt_subject"    ],"");
						ComSetObjValue(formObj.elements["edt_contents"   ],"");
						ComShowCodeMessage("BKG00497");
					}
					for (var idx=0;idx<chkRow.length-1;idx++) {
						sheetObjects[0].CellValue2(chkRow[idx],"remark") = sheetObjects[0].CellValue(chkRow[idx],"remark_backup");
						sheetObjects[0].CellValue2(chkRow[idx],"remark_backup") = "";
					}
					if ("F"==ComGetEtcData(sXml,"TRANS_RESULT_KEY")) {
				    	var rmsg = ComGetEtcData(sXml,"Exception").split("<||>");
				     	if (rmsg[3] != undefined && 0 < rmsg[3].length) {
				     		ComShowMessage(rmsg[3]);
				     	} else {
				     		sheetObjects[0].LoadSaveXml(sXml);
						}
					}
				}
				break;
	
			case "btn_EmailEdit":
				var formObject = document.form;
				var arrRow = ComFindText(sheetObjects[0], "slct_flg", 1);
				var bkg_no_list = "";
				var edt_to_eml = "";
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						bkg_no_list += sheetObjects[0].CellValue(arrRow[i],"bkg_no")+"|";
					}
					if (0<bkg_no_list.indexOf("|")) bkg_no_list = bkg_no_list.substring(0,bkg_no_list.length-1);
					edt_to_eml = sheetObjects[0].CellValue(arrRow[0],"eml");
					ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0098&ntc_knd_cd=BK&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 700, true);
				}
				break;
        }
    }

    /**
     * Remark 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0384(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 전용진
     * @version 2009.10.06
     */
    function callBack0384(rArray){
    	var formObj = document.form;
    	if(rArray != null){
			var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
			if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
				for (var idx=0;idx<chkRow.length-1;idx++) {
					sheetObjects[0].CellValue(chkRow[idx], "remark") = rArray[0][6];
				}
			}
    	}
    }

	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
		axon_event.addListenerForm('beforedeactivate', 'bkg0098_obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',   'bkg0098_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}

	 /**
	 * 마우스 IN일때 
	 */
	function bkg0098_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}        
	 
	function bkg0098_obj_deactivate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
				break;
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}        

	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}

   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

	function obj_keypress(){
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "engnum"://숫자+"영문대소"입력하기
    	  	  	ComKeyOnlyAlphabet('num'); 
	        	break;	   
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result = false;
        with(formObj){
			switch(sAction) {
			case IBSEARCH:
				if(!ComIsNull(formObj.cust_seq)){
					if(!ComIsNumber(formObj.cust_seq)){
			 			ComShowCodeMessage("BKG00340");
						formObj.cust_seq.focus();
						return false;
					}
				}
				if ( ComIsNull(formObj.bkg_no) ) {
					if ( !ComIsNull(formObj.vvd) ) {
						if ( checkMendatoryPOR(formObj) || checkMendatoryPOL(formObj) || checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)||
							 checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj) ||
							 checkMendatorySalesOfcCd(formObj) || checkMendatorySrepCd(formObj) ) {
							result = true;
						} else {
							ComShowCodeMessage("BKG00104", "\n\tPOR or\n\tPOL or\n\tPOD or\n\tDEL or\n\tBKG Office or\n\tBKG Staff or\n\tSales Office or\n\tSales Rep\n");
						}
						return result;
					} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
						if ( checkMendatoryDt(formObj) ){ 
							if ( checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj) || 
							     checkMendatorySalesOfcCd(formObj) || checkMendatorySrepCd(formObj) || 
							     checkMendatoryPOR(formObj) || checkMendatoryPOL(formObj) ) {
							    result = true;
							} else {
							    ComShowCodeMessage("BKG00104", "\n\tPOR or\n\tPOL or\n\tBKG Office or\n\tBKG Staff or\n\tSales Office or\n\tSales Rep");
							} 
						}
					} else if ( ComIsNull(formObj.vvd) || ComIsNull(formObj.bkg_from_dt) || ComIsNull(formObj.bkg_to_dt) ) {
						ComShowCodeMessage("BKG00104", "\n\tBKG DT or\n\tVVD\n");
					} else {
						return result;
					}
				} else {
					return true;
				}
				break;
			}
	
			if ( sAction=="btn_Print" || sAction=="btn_Preview" || sAction=="btn_EditFaxEmail" ||
	             sAction=="btn_AssignEmail" || sAction=="btn_EditRemark" || sAction=="btn_EditCCT" ||
	             sAction=="btn_Fax" || sAction=="btn_Email" || sAction=="btn_GroupEmail" || sAction=="btn_EmailEdit") {
				if (sheetObj.RowCount == 0) {
					ComShowCodeMessage("BKG00155");
					return false;
				}
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowCodeMessage("BKG00155");
					return false;
				}
	
				if (sAction == "btn_Preview") {
					if (50<sheetObj.CheckedRows("slct_flg")) {
						ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
						return false;
					}
				}
/*
				if (sAction == "btn_Preview") {
					if (sheetObj.CheckedRows("slct_flg") > 1) {
						ComShowCodeMessage("BKG00362");
						return false;
					}
				}
*/
				if (sAction == "btn_GroupEmail" || sAction=="btn_EmailEdit") {
					var returnFlg = true;
					var messageCd = "";
					var arrRow = ComFindText(sheetObj, "slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						var shpr_cd = sheetObj.CellValue(arrRow[0],"shipper_code");
						var email = sheetObj.CellValue(arrRow[0],"eml");
						var loop_shpr_cd;
						var loop_email;
						for (var i=0; i<arrRow.length; i++) {
							loop_shpr_cd = sheetObj.CellValue(arrRow[i],"shipper_code");
							loop_email = sheetObj.CellValue(arrRow[i],"eml");
							if (""==loop_email || shpr_cd != loop_shpr_cd || email != loop_email) {
								messageCd = "BKG00357";  //동일한 shipper code 또는 e-mail이 아닙니다.(asis:BKG00807)
								returnFlg = false;
								break;
							}
						}
						if (!returnFlg) {
							var ff_cd = sheetObj.CellValue(arrRow[0],"ff_cd");
							var loop_ff_cd;
							var loop_email;
							for (var i=0; i<arrRow.length; i++) {
								loop_ff_cd = sheetObj.CellValue(arrRow[i],"ff_cd")
								loop_email = sheetObj.CellValue(arrRow[i],"eml");
								if (""!=loop_ff_cd && ff_cd == loop_ff_cd && email == loop_email) {
									returnFlg = true;
								} else {
									returnFlg = false;
									break;
								}
							}
						}
						if (!returnFlg && ""!=messageCd) {
							ComShowCodeMessage(messageCd);
						}
						return returnFlg;
					}
				}
				return true;
			}
        }
        return result;
    }

	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowCodeMessage("BKG00112");
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			}
		}
		return true;
	}

	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryPOD(formObj) {
		if( ComIsNull(formObj.pod_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryPOR(formObj) {
		if( ComIsNull(formObj.por_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryDEL(formObj) {
		if( ComIsNull(formObj.del_cd) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
			return false;
		}
		return true;
	}
	
	function checkMendatorySalesOfcCd(formObj) {
		if( ComIsNull(formObj.sales_ofc) ) {
			return false;
		}
		return true;
	}

	function checkMendatoryBkgStfCd(formObj) {
		if( ComIsNull(formObj.bkg_staff) ) {
			return false;
		}
		return true;
	}

	function checkMendatorySrepCd(formObj) {
		if( ComIsNull(formObj.sales_rep) ) {
			return false;
		}
		return true;
	}
	
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
		if ( col == 3 ) {
			var param = "";
			var chkBkgNo = sheetObjects[0].CellValue(row, "bkg_no");
	
			if ( chkBkgNo != "" ) {
				param  = "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObjects[0].CellValue(row, "bkg_no");
				//freezing 관련 작업
//				ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkg0079", 1005, 650, false);			
				comBkgCallPopBkgDetail(sheetObjects[0].CellValue(row, "bkg_no"));   
			}
		}
    }

	/**
	* IBSheet Object에서 팝업을 클릭시
	*/
 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var formObject = document.form;
		var param = "";
		if (sheetObj.ColSaveName(Col) == "fax_btn" || sheetObj.ColSaveName(Col) == "eml_btn") {
			if ( sheetObj.CellValue(Row, "new_flg") == "Y" ) {
				sheetObj.RowHidden(Row)= true;		//2.행 숨기기
				sheetObj.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			} else {
				var Row = sheetObj.DataCopy();
				sheetObj.RowStatus(Row) = "R";
				sheetObj.CellValue(Row, "fax") = "";
				sheetObj.CellValue(Row, "eml") = "";
				sheetObj.CellValue(Row, "cct") = "";
				sheetObj.CellValue(Row, "doc_cct") = "";
				sheetObj.CellValue(Row, "rail_from_cct") = "";
				sheetObj.CellValue(Row, "rail_to_cct") = "";
				sheetObj.CellValue(Row, "mnl_rail_from_cct") = "";
				sheetObj.CellValue(Row, "mnl_rail_to_cct") = "";
				sheetObj.CellValue(Row, "vgm_cct") = "";
				sheetObj.CellValue(Row, "mnl_vgm_cct") = "";
				sheetObj.CellValue(Row, "fax_btn") = "";
				sheetObj.CellValue(Row, "eml_btn") = "";
				sheetObj.CellValue(Row, "new_flg") = "Y";
				sheetObj.CellValue(Row, "fax_result") = "";
				sheetObj.CellValue(Row, "fax_date") = "";
				sheetObj.CellValue(Row, "eml_result") = "";
				sheetObj.CellValue(Row, "eml_date") = "";
				sheetObj.CellValue(Row, "eml_date") = "remark";
				sheetObj.PopupButtonImage(Row, 10) = 1;
				sheetObj.PopupButtonImage(Row, 12) = 1;
			} 
		} else if ("fax_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.CellValue(Row,"fax_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		} else if ("eml_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.CellValue(Row,"eml_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
	 
 	function sheetMultiBtnClick(sheetObject, Row, Col) {
		var formObject = document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo = sheetObject.CellValue(Row,"bkg_no");
		ntcKndCd = "BK";
 		if ("fax_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "F";
 		} else if ("eml_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "M";
 		}
		ComOpenWindowCenter("/hanjin/ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, "ESM_BKG_1071", 715, 500, false);
 	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj){
			ColFontUnderline("bkg_no") = true;
            for(i=1 ; i<=LastRow; i++) {
                if ("Failed"==CellValue(i,"fax_result")) {
                	CellFontUnderline(i,"fax_result") = true;
                } else if ("Failed"==CellValue(i,"eml_result")) {
                	CellFontUnderline(i,"eml_result") = true;
                }
                if (""!=CellValue(i,"fax_result")) {
					PopupButtonImage(i, "fax_his_btn") = 2;
                } else {
                    SetMergeCell(i,21,1,2);
                }
                if (""!=CellValue(i,"eml_result")) {
					PopupButtonImage(i, "eml_his_btn") = 2;
                } else {
                    SetMergeCell(i,24,1,2);
                }
            }
		}
	}

	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			var row = MouseRow;
			var col = MouseCol;
			
			var colname = ColSaveName(col);
			
			switch(colname)	{
				case "FaxResult":
				case "EmailResult":
					if ("Failed" == CellValue(row, col))
						MouseToolTipText = "failure reason";
					else
						MouseToolTipText = "";
					break;
				default :
						MouseToolTipText = "";
			}
		}
	}

	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
		Rdviewer.style.height = 0;

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	function rdOpen(rdObject, formObject, viewType){
		var sheetObj = sheetObjects[0];
		var Rdviewer = rdObject;

//		Rdviewer.SetAppendReport(1);
		var chkRow = ComFindText(sheetObj, "slct_flg", 1);

//Rdviewer.SetAppendReport(1);
		if ( sheetObj.CellValue(chkRow[0], "bkg_no") != "" ) {
			var bkgNos = "";
			for (var i=0; i<chkRow.length; i++) {
				bkgNos += "'"+sheetObj.CellValue(chkRow[i], "bkg_no")+"',";
			}
			bkgNos = bkgNos.substring(0,bkgNos.length-1);
			var rdParam = " /rv " + "BKG_NO["+bkgNos+"] USR_ID["+formObject.usr_id.value+"] O_PS["
			            + encodeRemark(sheetObj.CellValue(chkRow[0], "remark"))+"] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]";
			var rdUrl = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			var rdFile = formObject.mrd.value+".mrd";

			Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ " /riprnmargin /rwait");
			if ( viewType == "print" ) {
//				Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ " /riprnmargin /rwait");
				if ("US"==formObject.strCnt_cd.value) {
					Rdviewer.SetPrint2(4,1,1,100);
				}
				Rdviewer.PrintDialog();
			} else {
				formObject.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/"+rdFile;
				formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
				formObject.com_mrdSaveDialogFileName.value = sheetObj.CellValue(chkRow[0],"bkg_no");
				ComOpenRDPopup('resizable=yes, width=900, height=800');
			}
		}
//		Rdviewer.SetAppendReport(0);
	}

    /**
     * 로컬 RD 테스트용
     */
	function rdOpen2(rdObject, formObject, viewType){
		var sheetObj = sheetObjects[0];
		var Rdviewer = rdObject;

		Rdviewer.SetAppendReport(1);
		var chkRow = ComFindText(sheetObj, "slct_flg", 1);

		if ( sheetObj.CellValue(chkRow[0], "bkg_no") != "" ) {
			var bkgNos = "";
			for (var i=0; i<chkRow.length; i++) {
				bkgNos += "'"+sheetObj.CellValue(chkRow[i], "bkg_no")+"',";
			}
			bkgNos = bkgNos.substring(0,bkgNos.length-1);
			var rdParam = " /rv " + "BKG_NO["+bkgNos+"] USR_ID["+formObject.usr_id.value+"] O_PS["
			            + encodeRemark(sheetObj.CellValue(chkRow[0], "remark"))+"] P_PORT_CARGO_CUT_DT["
						+ sheetObj.CellValue(chkRow[0], "cct")+ "] P_DOC_CUT_DT["
						+ sheetObj.CellValue(chkRow[0], "doc_cct")+ "][Y]";
			var rdUrl = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			var rdFile = formObject.mrd.value+".mrd";

			Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam+ " /riprnmargin /rwait");

			if ( viewType == "print" ) {
				Rdviewer.CMPrint();
			} else {
				Rdviewer.ViewPdf();
			}

			Rdviewer.SetAppendReport(0);
		}
	}

    //edit fax/email 팝업(0221)에서 호출됨
    function getCOM_Fax_Email_POPUP(rowArray) {
    	if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
 	    	var faxno = rowArray[0][21];
 	        var email = rowArray[0][22];
 	    	var sheetObject = sheetObjects[0];
 			var arrRow = ComFindText(sheetObject, "slct_flg", 1);
 			if (arrRow && 0<arrRow.length) {
 				for (var i=0; i<arrRow.length; i++) {
 					sheetObject.CellValue2(arrRow[i],"fax") = faxno;
 					sheetObject.CellValue2(arrRow[i],"eml") = email;
 				}
 			}
     	}
    }

    //edit CCT 팝업(0934)에서 호출됨
    function setCctValue(row,col,cctValue,docCctValue,railFromCctValue,railToCctValue,vgmCctValue) {
    	var sheetObject = sheetObjects[0];
		var arrRow = ComFindText(sheetObject, "slct_flg", 1);
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				if (""!=cctValue) {
					sheetObject.CellValue2(arrRow[i],"cct") = cctValue;
				}
				if (""!=docCctValue) {
					sheetObject.CellValue2(arrRow[i],"doc_cct") = docCctValue;
				}
				if (""!=railFromCctValue) {
					sheetObject.CellValue2(arrRow[i],"rail_from_cct") = railFromCctValue;
					sheetObject.CellValue2(arrRow[i],"mnl_rail_from_cct") = railFromCctValue;
				}
				if (""!=railToCctValue) {
					sheetObject.CellValue2(arrRow[i],"rail_to_cct") = railToCctValue;
					sheetObject.CellValue2(arrRow[i],"mnl_rail_to_cct") = railToCctValue;
				}
				if (""!=vgmCctValue) {
					sheetObject.CellValue2(arrRow[i],"vgm_cct") = vgmCctValue;
					sheetObject.CellValue2(arrRow[i],"mnl_vgm_cct") = vgmCctValue;
				}
			}
		}
    }

    //remark를 encoding함
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
