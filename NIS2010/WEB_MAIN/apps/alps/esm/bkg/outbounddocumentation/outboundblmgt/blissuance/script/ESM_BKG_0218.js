/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0218.js
*@FileTitle : Draft B/L &amp; Waybill (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.18 이일민
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
     * @class ESM_BKG_0218 : ESM_BKG_0218 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0218() {
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

var rdParam;
var rdPath;
var rdPdf;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;
        var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

        	//Outbound 인 경우
    		if (0==beforetab) {
        		switch(srcName) {

	            	//하단버튼 begin
		            //Retrieve
			        case "btn_retrieve":
			        	if (!validateForm(sheetObject1,formObject,IBSEARCH)) return false;
		                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		                break;
		            //New
			        case "btn_new":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
		                break;
		            //Down Excel
		            case "btn_down_excel":
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		                break;
		            //하단버튼 end

	                //TAB1(Outbound) begin
		            case "t1_rdo_bl_tp_cd":
		            	if ("D"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"])) {
		                	ComBtnEnable("btn_remark_t1sht1");
		            	} else {
		                	ComBtnDisable("btn_remark_t1sht1");
		            	}
		            	break;
		            case "t1_rdo_bkg_bl":
		            	var rdo_bkg_bl = ComGetObjValue(formObject.elements["t1_rdo_bkg_bl"]);
		            	if ("BKG"==rdo_bkg_bl) {
		            		formObject.elements["t1_txt_bl_no"].value = "";
		            		formObject.elements["t1_txt_bl_no"].style.display = "none";
		            		formObject.elements["t1_txt_bkg_no"].style.display = "inline";
		            	} else if ("BL"==rdo_bkg_bl) {
		            		formObject.elements["t1_txt_bkg_no"].value = "";
		            		formObject.elements["t1_txt_bkg_no"].style.display = "none";
		            		formObject.elements["t1_txt_bl_no"].style.display = "inline";
		            	}
		            	break;
					//Calendar(On Board, B/L Issue)
		            case "t1_btn_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.elements["t1_txt_date_from"], formObject.elements["t1_txt_date_to"],'yyyy-MM-dd');
						break;
		            //Preview
		            //전송할 B/L 미리보기
		            //B/L Preview 화면을 띄워주고 조회 시 선택했던, Type 정보에 따라 Preview 화면의 B/L Type 도 자동으로 선택해 줌
	                case "btn_preview_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_preview_t1sht1")) return false;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length) {
							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							formObject.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath;
							formObject.com_mrdArguments.value = rdParam + " /rwait";
							formObject.com_mrdBodyTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"bkg_no");
							ComOpenRDPopup("resizable=yes, width=900, height=800");
						}
						break;
	                //Edit Fax/E-mail - Edit Fax/E-mail 팝업창을 띄워줌(OK 버튼은 표시하고 Send 버튼은 숨김)
					case "btn_faxemail_t1sht1":
	    				if(!validateForm(sheetObject1,formObject,"btn_faxemail_t1sht1")) return false;
			        	//open popup 0221
			        	var width = 400;
						var height = 190;
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
	                //Fax
			        case "btn_fax_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_fax_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_fax_t1sht1");
	                    break;
			        //E-mail
			        case "btn_email_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_email_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_email_t1sht1");
	                    break;
	                //Group E-mail
			        case "btn_groupemail_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_groupemail_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_groupemail_t1sht1");
	                    break;
	                //Manifest(US)
			        case "btn_manifest_t1sht1":
			        	if(!validateForm(sheetObject1,formObject,"btn_manifest_t1sht1")) return false;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length && 50>=arrRow.length) {
							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							rdParam = rdParam.replace(/(form_type\[\d\])/g,"form_type[2]");  //setting form_type
							rdParam = rdParam.replace(/(form_level\[\(\d\)\])/g,"form_level[(6)]");  //setting form_level
							rdParam = rdParam.replace(/(form_manifest\[\w\])/g,"form_manifest[X]");  //setting form_manifest
							formObject.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
							if (0==sheetObject1.CellValue(arrRow[0],sheetObject1.id+"por_cd").indexOf("US")) {
								formObject.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
							}
							formObject.com_mrdArguments.value = rdParam + " /rwait";
							formObject.com_mrdBodyTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"bkg_no");
							ComOpenRDPopup("resizable=yes, width=900, height=800");
						}
	                    break;
	                //Remark(s)
			        case "btn_remark_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_remark_t1sht1")) return false;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						var rmk = "";
						if (arrRow && 0<arrRow.length) {
							rmk = 1==arrRow.length ? sheetObject1.CellValue(arrRow[0],sheetObject1.id+"remark") : "";
						}
						formObject.elements["inter_rmk"].value = rmk;
						ComOpenWindow("ESM_BKG_0913.do?screen_id=0218","ESM_BKG_0913","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=yes,alwaysRaised,dependent,titlebar=no,width=500,height=250",true);
	                    break;
			        case "btn_assign_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_assign_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_assign_t1sht1");
			        	break;
	                //Print
			        case "btn_print_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_print_t1sht1")) return false;
						rdOpen(rdObject, formObject, "print");
//						if(!validateForm(sheetObject1,formObject,"btn_print_t1sht1")) return false;
//						rdOpen(rdObject, formObject, "down");
	                    break;
					case "btn_EmailEdit_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_EmailEdit_t1sht1")) return false;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						var ntc_knd_cd = formObject.t1_chk_doc_rmd.checked ? "DR" : ("W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : "BL");
						var bkg_no_list = "";
						var edt_to_eml = "";
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) {
								bkg_no_list += sheetObject1.CellValue(arrRow[i],sheetObject1.id+"bkg_no")+'|';
							}
							if (0<bkg_no_list.indexOf("|")) bkg_no_list = bkg_no_list.substring(0,bkg_no_list.length-1);
							edt_to_eml = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"eml");
							ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0218_01&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 670, true);
						}
						break;
					//E-mail(S/R)
			        case "btn_emailSR_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_emailSR_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_emailSR_t1sht1");
	                    break;	
	                  //E-mail(E/Q)
			        case "btn_emailEQ_t1sht1":
						if(!validateForm(sheetObject1,formObject,"btn_emailEQ_t1sht1")) return false;
						doActionIBSheet(sheetObject1,formObject,"btn_emailEQ_t1sht1");
	                    break;    
	                //TAB1(Outbound) end
        		}

            //Inbound 인 경우
        	} else if (1==beforetab) {
        		switch(srcName) {

	            	//하단버튼 begin
		            //Retrieve
			        case "btn_retrieve":
			        	if (!validateForm(sheetObject2,formObject,IBSEARCH)) return false;
		                doActionIBSheet(sheetObject2,formObject,IBSEARCH);
		                break;
		            //New
			        case "btn_new":
						doActionIBSheet(sheetObject2,formObject,IBCLEAR);
		                break;
		            //Down Excel
		            case "btn_down_excel":
						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
		                break;
		            //하단버튼 end

		            //TAB2(Inbound) begin
		            case "t2_rdo_bl_tp_cd":
		            	if ("D"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"])) {
		                	ComBtnEnable("btn_remark_t2sht1");
		            	} else {
		                	ComBtnDisable("btn_remark_t2sht1");
		            	}
		            	break;
		            //Calendar(ETA Date)
		            case "t2_btn_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.elements["t2_txt_date_from"], formObject.elements["t2_txt_date_to"],'yyyy-MM-dd');
						break;
		            //Calendar(On Board, B/L Issue)
		            case "t2_btn_calendar2":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.elements["t2_txt_date_from2"], formObject.elements["t2_txt_date_to2"],'yyyy-MM-dd');
						break;
	                //Preview
			        case "btn_preview_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_preview_t2sht1")) return false;
						var arrRow = ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);
						if (arrRow && 0<arrRow.length) {
							ufSetRdParamByBkgNos(formObject,arrRow[0],arrRow);
							formObject.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath;
							formObject.com_mrdArguments.value = rdParam + " /rwait";
							formObject.com_mrdBodyTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdTitle.value = "SM Line Draft B/L Copies";
							formObject.com_mrdSaveDialogFileName.value = sheetObject2.CellValue(arrRow[0],sheetObject2.id+"bkg_no");
							ComOpenRDPopup("resizable=yes, width=900, height=800");
						}
			        	break;
	                //Edit Fax/E-mail
	                case "btn_faxemail_t2sht1":
	    				if(!validateForm(sheetObject2,formObject,"btn_faxemail_t2sht1")) return false;
			        	//open popup 0221
			        	var width = 400;
						var height = 190;
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
	                //Fax
			        case "btn_fax_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_fax_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_fax_t2sht1");
	                    break;
	                //E-mail
			        case "btn_email_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_email_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_email_t2sht1");
	                    break;
	                //Group E-mail
			        case "btn_groupemail_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_groupemail_t2sht1")) return false;
						doActionIBSheet(sheetObject2,formObject,"btn_groupemail_t2sht1");
	                    break;
	                //Remark(s)
			        case "btn_remark_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_remark_t2sht1")) return false;
						var arrRow = ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);
						var rmk = "";
						if (arrRow && 0<arrRow.length) {
							rmk = 1==arrRow.length ? sheetObject2.CellValue(arrRow[0],sheetObject2.id+"remark") : "";
						}
						formObject.elements["inter_rmk"].value = ComReplaceStr(ComReplaceStr(rmk,"\r","\\r"),"\n","\\n");
						ComOpenWindow("ESM_BKG_0913.do?screen_id=0218","ESM_BKG_0913","toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=500,height=320",true);
	                    break;
	                //Print
			        case "btn_print_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_print_t2sht1")) return false;
						rdOpen(rdObject, formObject, "print");
	                    break;
					case "btn_EmailEdit_t2sht1":
						if(!validateForm(sheetObject2,formObject,"btn_EmailEdit_t2sht1")) return false;
						var arrRow = ComFindText(sheetObject2, sheetObject2.id+"slct_flg", 1);
						var ntc_knd_cd = "W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
						var bkg_no_list = "";
						var edt_to_eml = "";
						if (arrRow && 0<arrRow.length) {
							for (var i=0; i<arrRow.length; i++) {
								bkg_no_list += sheetObject2.CellValue(arrRow[i],sheetObject2.id+"bkg_no")+'|';
							}
							if (0<bkg_no_list.indexOf("|")) bkg_no_list = bkg_no_list.substring(0,bkg_no_list.length-1);
							edt_to_eml = sheetObject2.CellValue(arrRow[0],sheetObject2.id+"eml");
							ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0218_02&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no_list+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 670, true);
						}
						break;
	                //TAB2(Inbound) end
        		}  // end switch
            }  // end TAB
    	} catch(e) {
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
		initControl();
		for(k=sheetObjects.length-1;0<=k;k--){
			doActionIBSheet(sheetObjects[k],document.form,IBCLEAR);
        }
		for(k=0;k<rdObjects.length;k++){
    		initRdConfig(rdObjects[k]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        if (0<=location.href.indexOf("_02.")) {  //inbound
        	beforetab = 1;
			tabObjects[0].SelectedIndex = 1;

			var objs = document.all.item("tabLayer");
	    	objs[1].style.display = "Inline";
	    	objs[0].style.display = "none";
	    	objs[0].style.zIndex = objs[1].style.zIndex -1 ;

	    	if (getParameter("bl_no")) {  //bl_no 파라미터가 있는 경우
	        	var formObject = document.form;
				formObject.elements["t2_txt_bl_no"].value = getParameter("bl_no");
	        	if (!validateForm(sheetObjects[1],formObject,IBSEARCH)) return false;
	            doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
			}
    	} else {  //outbound
        	beforetab = 0;
        	
            var opener = window.dialogArguments;
            var formObj = document.form;
            if(opener != undefined ){
            	if(document.form.ui_id.value="ESM_BKG_0726"){
            		document.getElementById('t1_txt_bl_no').value = opener.document.form.blNoStr.value;
            		document.form.t1_rdo_bl_tp_cd[1].checked = true;
		        	if (!validateForm(sheetObjects[0],formObj,IBSEARCH)) return false;
	                doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);  
            	}	
            }
            
    	}
        
		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
			ComSetDisplay("btn_Fax1", false);
			ComSetDisplay("btn_Fax2", false);
		}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObject,sheetNo) {
        var cnt = 0;
		var prefix = "";
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObject) {
            		prefix = sheetObject.id;
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(49, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.||Booking No.|S|B/L No.|Shipper Code|Shipper Name||FF Code|T.VVD|POL|POD";
                    HeadTitle      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
                    HeadTitle      +=  "|Fax Sent|Fax Sent|Fax Sent|Fax Sent|E-mail Sent|E-mail Sent|E-mail Sent|E-mail Sent|QTY|QTY|QTY";

                    var HeadTitle1 = "|Sel.||Booking No.|S|B/L No.|Shipper Code|Shipper Name||FF Code|T.VVD|POL|POD";
                    HeadTitle1      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
                    HeadTitle1      +=  "|Result|Result|Fax Date||Result|Result|Date||BKG QTY|CNTR QTY|QTY FLG";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    SetMergeCell(0,1,2,2);
 					SetMergeCell(0,13,2,2);
 					SetMergeCell(0,15,2,2);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,0,   daCenter,  false, prefix+"ibflag"        );
                    InitDataProperty(0, cnt++, dtCheckBox,    18,  daCenter,  false, prefix+"slct_flg"      );
					InitDataProperty(0, cnt++, dtDataSeq,     40,  daCenter,  true,  prefix+"seq"           );
                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"bkg_no",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        20,  daCenter,  true,  prefix+"bkg_sts_cd",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        95,  daLeft,    true,  prefix+"bl_no",        false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        80,  daLeft,    true,  prefix+"shpr_cd",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        150, daLeft,    true,  prefix+"short_shpr_nm",false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"shpr_nm"       );
                    InitDataProperty(0, cnt++, dtData,        60,  daLeft,    true,  prefix+"ff_cd",        false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        70,  daCenter,  true,  prefix+"vvd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        42,  daCenter,  true,  prefix+"pol_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        42,  daCenter,  true,  prefix+"pod_cd",       false, "", dfNone,        0, false, false);
                    //2015.10.13 BL Copy Send Fax 전송 기능 삭제
					if(pgmNo != "ESM_BKG_0218_02"){
	                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"fax_no",       false, "", dfNone,        0, true,  true );
    	                InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"fax_btn",      false, "", dfNone,        0, true,  true );					
                    }else{
        	            InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"fax_no",       false, "", dfNone,        0, false,  false );
            	        InitDataProperty(0, cnt++, dtHidden,       20,  daCenter,  false, prefix+"fax_btn",      false, "", dfNone,        0, true,  true );                    
                    }
                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"eml",          false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"eml_btn",      false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        75,  daLeft,    true,  prefix+"cntc_pson_nm", false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"fax_result",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"fax_his_btn",  false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        130, daCenter,  true,  prefix+"fax_date",     false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"fax_reason",   false, "", dfNone,        0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"eml_result",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"eml_his_btn",  false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        130, daCenter,  true,  prefix+"eml_date",     false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"eml_reason",   false, "", dfNone,        0, false, false, 0, false, false);
                    
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"qty_bkg",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"qty_cntr",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"qty_flg",   false, "", dfNone,        0, false, false);
                    
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_all_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_clt_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_ppd_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_chg_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_arr_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"hidd_opt",     false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"remark",       false, "", dfNone,        0, false, false);
        			InitDataProperty(0, cnt++, dtHidden,	  0,   daLeft,    false, prefix+"new_flg"       );
        			//fax+email
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"syscd",        false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplmrd",      false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"title",        false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplparam",    false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"rcvinfo",      false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"rcveml",       false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"contents",     false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplmrdpdf",   false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"itr",          false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"ntc_knd_cd",   false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"grp_flag",     false, "", dfNone,        0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"por_cd",       false, "", dfNone,        0, false, false, 0, false, false);

					InitUserFormat2(0, prefix+"fax_date",  "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"eml_date",  "####-##-## ##:##", "-|:" );

					ShowButtonImage	= 1;
					//ImageList에 이미지를 설정한다.
 					ImageList(0) = "img/btns_plus.gif";
 					ImageList(1) = "img/btns_minus.gif";
 					ImageList(2) = "img/btns_multisearch.gif";
 					
  					//특정컬럼에 팝업버튼 이미지 변경
 					PopupButtonImage(0, prefix+"fax_btn") = 0;
 					PopupButtonImage(0, prefix+"eml_btn") = 0;

                    //tooltip
 					//WordWrap = true;
 					//FrozenCols = 8;  //틀고정 설정 (cntr_no)
 					//Ellipsis = true;  // 문장이 길경우 ...으로 표시함
        			ToolTipOption="balloon:true;width:320;forecolor:#666666;backcolor:#FFFFFF;icon:1";
            	}
                break;

            case 2:      //t2sheet1 init
                with (sheetObject) {
            		prefix = sheetObject.id;
                    // 높이 설정
                    style.height = 239;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 1, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(46, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.||Booking No.|S|B/L No.|CNEE/NTFY Code|CNEE/NTFY Name||FF Code|T.VVD|POL|POD";
                    HeadTitle      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
                    HeadTitle      +=  "|Fax Sent|Fax Sent|Fax Sent|Fax Sent|E-mail Sent|E-mail Sent|E-mail Sent|E-mail Sent||";

                    var HeadTitle1 = "|Sel.||Booking No.|S|B/L No.|CNEE/NTFY Code|CNEE/NTFY Name||FF Code|T.VVD|POL|POD";
                    HeadTitle1      +=  "|Fax|Fax|E-mail Address|E-mail Address|Contact PIC";
                    HeadTitle1      +=  "|Result|Result|Fax Date||Result|Result|Date|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    SetMergeCell(0,1,2,2);
 					SetMergeCell(0,13,2,2);
 					SetMergeCell(0,15,2,2);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,0,   daCenter,  false, prefix+"ibflag"        );
                    InitDataProperty(0, cnt++, dtCheckBox,    18,  daCenter,  false, prefix+"slct_flg"      );
					InitDataProperty(0, cnt++, dtDataSeq,     40,  daCenter,  true,  prefix+"seq"           );
                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"bkg_no",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        20,  daCenter,  true,  prefix+"bkg_sts_cd",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        95,  daLeft,    true,  prefix+"bl_no",        false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        80,  daLeft,    true,  prefix+"shpr_cd",      false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        150, daLeft,    true,  prefix+"short_shpr_nm",false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"shpr_nm"       );
                    InitDataProperty(0, cnt++, dtData,        60,  daLeft,    true,  prefix+"ff_cd",        false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        70,  daCenter,  true,  prefix+"vvd",          false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        42,  daCenter,  true,  prefix+"pol_cd",       false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        42,  daCenter,  true,  prefix+"pod_cd",       false, "", dfNone,        0, false, false);
                    //2015.10.13 팩스기능 삭제 Edit Fax/E-mail
                    if(pgmNo != "ESM_BKG_0218_02"){
	                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"fax_no",       false, "", dfNone,        0, true,  true );
    	                InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"fax_btn",      false, "", dfNone,        0, true,  true );            
                    }else{
	                    InitDataProperty(0, cnt++, dtData,         90,  daLeft,    true,  prefix+"fax_no",       false, "", dfNone,        0, false,  false );
    	                InitDataProperty(0, cnt++, dtHidden,       20,  daCenter,  false, prefix+"fax_btn",      false, "", dfNone,        0, true,  true );
			        }            
                    InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"eml",          false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"eml_btn",      false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        75,  daLeft,    true,  prefix+"cntc_pson_nm", false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"fax_result",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"fax_his_btn",  false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        130, daCenter,  true,  prefix+"fax_date",     false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"fax_reason",   false, "", dfNone,        0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,        60,  daCenter,  true,  prefix+"eml_result",   false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtPopup,       20,  daCenter,  false, prefix+"eml_his_btn",  false, "", dfNone,        0, true,  true );
                    InitDataProperty(0, cnt++, dtData,        130, daCenter,  true,  prefix+"eml_date",     false, "", dfUserFormat2, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"eml_reason",   false, "", dfNone,        0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_all_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_clt_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_ppd_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_chg_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"frt_arr_flg",  false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"hidd_opt",     false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    true,  prefix+"remark",       false, "", dfNone,        0, false, false);
        			InitDataProperty(0, cnt++, dtHidden,	  0,   daLeft,    false, prefix+"new_flg"       );
        			//fax+email
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"syscd",        false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplmrd",      false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"title",        false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplparam",    false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"rcvinfo",      false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"rcveml",       false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"contents",     false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"tmplmrdpdf",   false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"itr",          false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"ntc_knd_cd",   false, "", dfNone,        0, false, false, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"grp_flag",     false, "", dfNone,        0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      0,   daLeft,    false, prefix+"por_cd",       false, "", dfNone,        0, false, false, 0, false, false);

					InitUserFormat2(0, prefix+"fax_date",  "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"eml_date",  "####-##-## ##:##", "-|:" );

					ShowButtonImage	= 1;
					//ImageList에 이미지를 설정한다.
 					ImageList(0) = "img/btns_plus.gif";
 					ImageList(1) = "img/btns_minus.gif";
 					ImageList(2) = "img/btns_multisearch.gif";

  					//특정컬럼에 팝업버튼 이미지 변경
 					PopupButtonImage(0, prefix+"fax_btn") = 0;
 					PopupButtonImage(0, prefix+"eml_btn") = 0;

                    //tooltip
 					//WordWrap = true;
 					//FrozenCols = 8;  //틀고정 설정 (cntr_no)
 					//Ellipsis = true;  // 문장이 길경우 ...으로 표시함
        			ToolTipOption="balloon:true;width:320;forecolor:#666666;backcolor:#FFFFFF;icon:1";
                }
                break;
        }
    }

 	function initControl() {
		var formObject = document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
//        axon_event.addListenerForm('change', 'form1_change', document.form);
        
//		axon_event.addListenerForm('beforedeactivate', 'bkg0218_obj_deactivate', formObject); //- 포커스 나갈때
//		axon_event.addListenerFormat('beforeactivate',   'bkg0218_activate', formObject); //- 포커스 들어갈때
//		axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}

// 	function form1_change(){
//       
//        var srcName = event.srcElement.getAttribute("name");
//        var srcVal = event.srcElement.value;	
//        switch(srcName){
//            case "t1_txt_bkg_no":
//            	if(srcVal.length>13){
//            		event.srcElement.value = srcVal.substring(0,13);
//            	}
//            break;
//            case "t1_txt_bl_no":
//            	if(srcVal.length>12){
//            		event.srcElement.value = srcVal.substring(0,12);
//            	}
//            break;
//        }
// 	}
 	function ufRetrieveByEnterKey() {

// 		if (event.srcElement.name == "t1_txt_bkg_no"){
// 			if(eval('document.form.'+event.srcElement.name).value.length>12){
// 				if(event.keyCode!=8 && event.keyCode!=46 && event.keyCode!=13 && event.keyCode!=37 && event.keyCode!=39 && event.keyCode!=17){
// 					return false;
// 				}
// 			}
// 		}
//
// 		if (event.srcElement.name == "t1_txt_bl_no"){
// 			if(eval('document.form.'+event.srcElement.name).value.length>11){
// 				if(event.keyCode!=8 && event.keyCode!=46 && event.keyCode!=13 && event.keyCode!=37 && event.keyCode!=39 && event.keyCode!=17)
// 					return false;
// 			}
// 		}
        if (13!=event.keyCode) return;
        document.getElementById("btn_retrieve").fireEvent("onclick");
 	}


 	//Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObject,formObject,sAction) {
    	sheetObject.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:      //초기화
		    	ComClearObject(formObject.elements["f_cmd"          ]);
		    	ComClearObject(formObject.elements["bl_tp_cd"       ]);
		    	ComClearObject(formObject.elements["vsl_cd"         ]);
		    	ComClearObject(formObject.elements["skd_voy_no"     ]);
		    	ComClearObject(formObject.elements["skd_dir_cd"     ]);
		    	ComClearObject(formObject.elements["pol_cd"         ]);
		    	ComClearObject(formObject.elements["pod_cd"         ]);
		    	ComClearObject(formObject.elements["bkg_ofc_cd"     ]);
		    	ComClearObject(formObject.elements["doc_usr_id"     ]);
		    	ComClearObject(formObject.elements["bkg_sts_cd"     ]);
		    	ComClearObject(formObject.elements["bkg_cust_tp_cd" ]);
		    	ComClearObject(formObject.elements["cust_cnt_cd"    ]);
		    	ComClearObject(formObject.elements["cust_seq"       ]);
		    	ComClearObject(formObject.elements["cust_nm"        ]);
		    	ComClearObject(formObject.elements["obl_iss_ofc_cd" ]);
		    	ComClearObject(formObject.elements["obl_iss_usr_id" ]);
		    	ComClearObject(formObject.elements["ob_sls_ofc_cd"  ]);
		    	ComClearObject(formObject.elements["ob_srep_cd"     ]);
		    	ComClearObject(formObject.elements["bkg_no"         ]);
		    	ComClearObject(formObject.elements["bl_no"          ]);
		    	ComClearObject(formObject.elements["bl_obrd_dt_from"]);
		    	ComClearObject(formObject.elements["bl_obrd_dt_to"  ]);
		    	ComClearObject(formObject.elements["obl_iss_dt_from"]);
		    	ComClearObject(formObject.elements["obl_iss_dt_to"  ]);
		    	ComClearObject(formObject.elements["fax_proc_sts_cd"]);
		    	ComClearObject(formObject.elements["eml_proc_sts_cd"]);
		    	ComClearObject(formObject.elements["sc_no"          ]);
		    	ComClearObject(formObject.elements["rfa_no"         ]);
		    	if ("t1sheet1"==sheetObject.id) {
			    	ComClearObject(formObject.elements["t1_txt_vvd"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pol"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pod"            ]);
			    	ComClearObject(formObject.elements["t1_txt_bkg_ofc"        ]);
			    	ComClearObject(formObject.elements["t1_txt_doc_usr_id"     ]);
			    	ComClearObject(formObject.elements["t1_slt_bkg_sts_cd"     ]);
			    	ComClearObject(formObject.elements["t1_slt_bkg_cust_tp_cd" ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_seq1"      ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_seq2"      ]);
			    	ComClearObject(formObject.elements["t1_txt_cust_nm"        ]);
			    	ComClearObject(formObject.elements["t1_txt_obl_iss_ofc_cd" ]);
			    	ComClearObject(formObject.elements["t1_txt_obl_iss_usr_id" ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_sls_ofc_cd"  ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_srep_cd"     ]);
			    	ComClearObject(formObject.elements["t1_txt_bkg_no"         ]);
			    	ComClearObject(formObject.elements["t1_txt_bl_no"          ]);
			    	ComClearObject(formObject.elements["t1_rdo_date_flg"       ]);
			    	ComClearObject(formObject.elements["t1_slt_fax_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t1_slt_eml_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t1_txt_date_from"      ]);
			    	ComClearObject(formObject.elements["t1_txt_date_to"        ]);
			    	ComClearObject(formObject.elements["t1_txt_sc_no"          ]);
			    	ComClearObject(formObject.elements["t1_txt_rfa_no"         ]);
			    	ComClearObject(formObject.elements["faxBlTotal1"           ]);
			    	ComClearObject(formObject.elements["faxTotal1"             ]);
			    	ComClearObject(formObject.elements["faxSuccess1"           ]);
			    	ComClearObject(formObject.elements["faxSending1"           ]);
			    	ComClearObject(formObject.elements["faxUnSent1"            ]);
			    	ComClearObject(formObject.elements["emlBlTotal1"           ]);
			    	ComClearObject(formObject.elements["emlTotal1"             ]);
			    	ComClearObject(formObject.elements["emlSuccess1"           ]);
			    	ComClearObject(formObject.elements["emlSending1"           ]);
			    	ComClearObject(formObject.elements["emlUnSent1"            ]);
			    	ComClearObject(formObject.elements["t1_sr_opt"             ]);
			    	ComClearObject(formObject.elements["t1_un_pickup_flg"      ]);
			    	
			    } else if ("t2sheet1"==sheetObject.id) {	
    		    	ComClearObject(formObject.elements["eta_dt_from"           ]);
    		    	ComClearObject(formObject.elements["eta_dt_to"             ]);
			    	ComClearObject(formObject.elements["t2_txt_vvd"            ]); 
			    	ComClearObject(formObject.elements["t2_txt_pod"            ]);
			    	ComClearObject(formObject.elements["t2_txt_pol"            ]);
			    	ComClearObject(formObject.elements["t2_txt_sc_no"          ]);
			    	ComClearObject(formObject.elements["t2_slt_bkg_cust_tp_cd" ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_seq1"      ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_seq2"      ]);
			    	ComClearObject(formObject.elements["t2_txt_cust_nm"        ]);
			    	ComClearObject(formObject.elements["t2_txt_bl_no"          ]);
			    	ComClearObject(formObject.elements["t2_rdo_date_flg"       ]);
			    	ComClearObject(formObject.elements["t2_slt_fax_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t2_slt_eml_proc_sts_cd"]);
			    	ComClearObject(formObject.elements["t2_txt_date_from"      ]);
			    	ComClearObject(formObject.elements["t2_txt_date_to"        ]);
			    	ComClearObject(formObject.elements["t2_txt_date_from2"     ]);
			    	ComClearObject(formObject.elements["t2_txt_date_to2"       ]);
			    	ComClearObject(formObject.elements["faxBlTotal2"           ]);
			    	ComClearObject(formObject.elements["faxTotal2"             ]);
			    	ComClearObject(formObject.elements["faxSuccess2"           ]);
			    	ComClearObject(formObject.elements["faxSending2"           ]);
			    	ComClearObject(formObject.elements["faxUnSent2"            ]);
			    	ComClearObject(formObject.elements["emlBlTotal2"           ]);
			    	ComClearObject(formObject.elements["emlTotal2"             ]);
			    	ComClearObject(formObject.elements["emlSuccess2"           ]);
			    	ComClearObject(formObject.elements["emlSending2"           ]);
			    	ComClearObject(formObject.elements["emlUnSent2"            ]);
        		}
				sheetObject.RemoveAll();
				break;

            case IBSEARCH:      //조회
			    if ("t1sheet1"==sheetObject.id) {
			    	var vvd = ComGetObjValue(formObject.elements["t1_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value = SEARCH01;
			    	formObject.elements["bl_tp_cd"       ].value = ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]);
			    	formObject.elements["vsl_cd"         ].value = vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value = vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value = vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value = ComGetObjValue(formObject.elements["t1_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value = ComGetObjValue(formObject.elements["t1_txt_pod"]);
					formObject.elements["bkg_ofc_cd"     ].value = ComGetObjValue(formObject.elements["t1_txt_bkg_ofc"]);
					formObject.elements["doc_usr_id"     ].value = ComGetObjValue(formObject.elements["t1_txt_doc_usr_id"]);
					formObject.elements["bkg_sts_cd"     ].value = ComGetObjValue(formObject.elements["t1_slt_bkg_sts_cd"]);
					formObject.elements["bkg_cust_tp_cd" ].value = ComGetObjValue(formObject.elements["t1_slt_bkg_cust_tp_cd"]);
					formObject.elements["cust_cnt_cd"    ].value = ComGetObjValue(formObject.elements["t1_txt_cust_seq1"]);
					formObject.elements["cust_seq"       ].value = ComGetObjValue(formObject.elements["t1_txt_cust_seq2"]);
					formObject.elements["cust_nm"        ].value = ComGetObjValue(formObject.elements["t1_txt_cust_nm"]);
					formObject.elements["sc_no"          ].value = ComGetObjValue(formObject.elements["t1_txt_sc_no"]);
					formObject.elements["rfa_no"         ].value = ComGetObjValue(formObject.elements["t1_txt_rfa_no"]);
					formObject.elements["pol_yd_cd"      ].value = ComGetObjValue(formObject.elements["t1_txt_pol_yd_cd"]);
					formObject.elements["obl_iss_ofc_cd" ].value = ComGetObjValue(formObject.elements["t1_txt_obl_iss_ofc_cd"]);
					formObject.elements["obl_iss_usr_id" ].value = ComGetObjValue(formObject.elements["t1_txt_obl_iss_usr_id"]);
					formObject.elements["ob_sls_ofc_cd"  ].value = ComGetObjValue(formObject.elements["t1_txt_ob_sls_ofc_cd"]);
					formObject.elements["ob_srep_cd"     ].value = ComGetObjValue(formObject.elements["t1_txt_ob_srep_cd"]);
					formObject.elements["bkg_no"         ].value = ComGetObjValue(formObject.elements["t1_txt_bkg_no"]);
					formObject.elements["bl_no"          ].value = ComGetObjValue(formObject.elements["t1_txt_bl_no"]);
  					if ("OnBoard"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value = ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["bl_obrd_dt_to"  ].value = ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["bl_obrd_dt_from"],"","-");
						ComClearSeparator(formObject.elements["bl_obrd_dt_to"],"","-");
						formObject.elements["obl_iss_dt_from"].value = "";
						formObject.elements["obl_iss_dt_to"  ].value = "";
  					} else if ("Issue"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value = "";
						formObject.elements["bl_obrd_dt_to"  ].value = "";
						formObject.elements["obl_iss_dt_from"].value = ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["obl_iss_dt_to"  ].value = ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["obl_iss_dt_from"],"","-");
						ComClearSeparator(formObject.elements["obl_iss_dt_to"],"","-");
  					}
  					formObject.elements["fax_proc_sts_cd"].value = ComGetObjValue(formObject.elements["t1_slt_fax_proc_sts_cd"]);
  					formObject.elements["eml_proc_sts_cd"].value = ComGetObjValue(formObject.elements["t1_slt_eml_proc_sts_cd"]);
  					formObject.elements["no_sr_flg"].value = formObject.elements["t1_sr_opt"].checked ? "Y":"N";
  					formObject.elements["un_pickup_flg"].value = formObject.elements["t1_un_pickup_flg"].checked ? "Y":"N";
        		} else if ("t2sheet1"==sheetObject.id) {
			    	var vvd = ComGetObjValue(formObject.elements["t2_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value = SEARCH02;
			    	formObject.elements["bl_tp_cd"       ].value = ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]);
					formObject.elements["eta_dt_from"    ].value = ComGetObjValue(formObject.elements["t2_txt_date_from"]);
					formObject.elements["eta_dt_to"      ].value = ComGetObjValue(formObject.elements["t2_txt_date_to"]);
					ComClearSeparator(formObject.elements["eta_dt_from"],"","-");
					ComClearSeparator(formObject.elements["eta_dt_to"],"","-");
			    	formObject.elements["vsl_cd"         ].value = vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value = vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value = vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value = ComGetObjValue(formObject.elements["t2_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value = ComGetObjValue(formObject.elements["t2_txt_pod"]);
			    	formObject.elements["sc_no"          ].value = ComGetObjValue(formObject.elements["t2_txt_sc_no"]);
					formObject.elements["bkg_cust_tp_cd" ].value = ComGetObjValue(formObject.elements["t2_slt_bkg_cust_tp_cd"]);
					formObject.elements["cust_cnt_cd"    ].value = ComGetObjValue(formObject.elements["t2_txt_cust_seq1"]);
					formObject.elements["cust_seq"       ].value = ComGetObjValue(formObject.elements["t2_txt_cust_seq2"]);
					formObject.elements["cust_nm"        ].value = ComGetObjValue(formObject.elements["t2_txt_cust_nm"]);
					formObject.elements["bl_no"          ].value = ComGetObjValue(formObject.elements["t2_txt_bl_no"]);
  					if ("OnBoard"==ComGetObjValue(formObject.elements["t2_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value = ComGetObjValue(formObject.elements["t2_txt_date_from2"]);
						formObject.elements["bl_obrd_dt_to"  ].value = ComGetObjValue(formObject.elements["t2_txt_date_to2"]);
						ComClearSeparator(formObject.elements["bl_obrd_dt_from"],"","-");
						ComClearSeparator(formObject.elements["bl_obrd_dt_to"],"","-");
						formObject.elements["obl_iss_dt_from"].value = "";
						formObject.elements["obl_iss_dt_to"  ].value = "";
  					} else if ("Issue"==ComGetObjValue(formObject.elements["t2_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value = "";
						formObject.elements["bl_obrd_dt_to"  ].value = "";
						formObject.elements["obl_iss_dt_from"].value = ComGetObjValue(formObject.elements["t2_txt_date_from2"]);
						formObject.elements["obl_iss_dt_to"  ].value = ComGetObjValue(formObject.elements["t2_txt_date_to2"]);
						ComClearSeparator(formObject.elements["obl_iss_dt_from"],"","-");
						ComClearSeparator(formObject.elements["obl_iss_dt_to"],"","-");
  					}
  					formObject.elements["fax_proc_sts_cd"].value = ComGetObjValue(formObject.elements["t2_slt_fax_proc_sts_cd"]);
  					formObject.elements["eml_proc_sts_cd"].value = ComGetObjValue(formObject.elements["t2_slt_eml_proc_sts_cd"]);
        		}
            	var sXml = sheetObject.GetSearchXml("ESM_BKG_0218GS.do", FormQueryString(formObject)+"&"+ComGetPrefixParam(sheetObject.id));
				ufRedrawSheet(sheetObject,sXml);
				ComEtcDataXmlToForm(sXml, formObject);
                break;

    		case IBDOWNEXCEL:
    			if (0<sheetObject.RowCount) {
    				sheetObject.SpeedDown2Excel(1);
    			} else {
    				ComShowCodeMessage("BKG00155");
    			}
    			break;

    		case "btn_fax_t1sht1":
		    	formObject.elements["f_cmd"].value = MULTI01;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						sheetObject.CellValue2(arrRow[i], prefix+"rcvinfo") = sheetObject.CellValue(arrRow[i], prefix+"fax_no");
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t1_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t1_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t1_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t1_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t1_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : "BL";
					}
					ufFaxEmailSend(sheetObject, formObject, "Fax");  //5336
				}
            	break;

            case "btn_fax_t2sht1":
		    	formObject.elements["f_cmd"].value = MULTI11;
		    	var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						sheetObject.CellValue2(arrRow[i], prefix+"rcvinfo") = sheetObject.CellValue(arrRow[i], prefix+"fax_no");
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t2_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t2_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t2_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t2_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t2_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
					}
					ufFaxEmailSend(sheetObject, formObject, "Fax");  //5336
				}
            	break;

            case "btn_email_t1sht1":
		    	formObject.elements["f_cmd"].value = MULTI02;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t1_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t1_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t1_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t1_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t1_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = formObject.t1_chk_doc_rmd.checked ? "DR" : ("W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : "BL");
						
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;

            case "btn_email_t2sht1":
		    	formObject.elements["f_cmd"].value = MULTI12;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t2_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t2_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t2_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t2_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t2_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;

            case "btn_groupemail_t1sht1":
		    	formObject.elements["f_cmd"].value = MULTI03;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t1_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t1_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t1_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t1_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t1_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = formObject.t1_chk_doc_rmd.checked ? "DR" : ("W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : "BL");
						sheetObject.CellValue2(arrRow[i], prefix+"grp_flag") = "Y";
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;

            case "btn_groupemail_t2sht1":
		    	formObject.elements["f_cmd"].value = MULTI13;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						//sheetObject.CellValue2(arrRow[i], prefix+"title") = "B/L Preview"; // 타이틀
						//sheetObject.CellValue2(arrRow[i], prefix+"contents") = "B/L Preview Contents"; // 메일내용
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t2_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t2_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t2_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t2_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t2_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t2_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
						sheetObject.CellValue2(arrRow[i], prefix+"grp_flag") = "Y";
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
        		break;
            case "btn_assign_t1sht1":
				var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
				var bkg_no = "";
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						bkg_no += sheetObject.CellValue(arrRow[i],sheetObject.id+"bkg_no")+'|';
					}
					if (0<bkg_no.indexOf("|")) bkg_no = bkg_no.substring(0,bkg_no.length-1);
				}
				var formObject4 = document.form4;
				formObject4.elements["f_cmd" ].value = SEARCH03;
				formObject4.elements["bkg_no"].value = bkg_no;
				var sXml = sheetObject.GetSearchXml("ESM_BKG_0218GS.do", FormQueryString(formObject4));
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
									if (agentBkgNo==sheetObject.CellValue(arrRow[j],sheetObject.id+"bkg_no")) {
										sheetObject.CellValue2(arrRow[j],sheetObject.id+"eml") = agentEmail;
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
            case "btn_emailSR_t1sht1":
		    	formObject.elements["f_cmd"].value = MULTI04;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t1_chk_opt1"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t1_chk_opt2"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t1_chk_opt3"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t1_chk_opt4"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t1_chk_opt5"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "SR";
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;
            case "btn_emailEQ_t1sht1":
		    	formObject.elements["f_cmd"].value = MULTI05;
				var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					for (var i=0; i<arrRow.length; i++) {
						ufSetRdParam(formObject,arrRow[i]);
						sheetObject.CellValue2(arrRow[i], prefix+"syscd") = "BKG";
						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrd") = rdPath;
						sheetObject.CellValue2(arrRow[i], prefix+"batchflg") = "N";
//						sheetObject.CellValue2(arrRow[i], prefix+"tmplparam") = rdParam;
						sheetObject.CellValue2(arrRow[i], prefix+"rcveml") = sheetObject.CellValue(arrRow[i], prefix+"eml");
//						sheetObject.CellValue2(arrRow[i], prefix+"tmplmrdpdf") = rdPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
						sheetObject.CellValue2(arrRow[i], prefix+"itr") = "|$$|";
//						sheetObject.CellValue2(arrRow[i], prefix+"frt_all_flg") = formObject.elements["t1_chk_opt1"].checked ? "Y":"N";
//						sheetObject.CellValue2(arrRow[i], prefix+"frt_clt_flg") = formObject.elements["t1_chk_opt2"].checked ? "Y":"N";
//						sheetObject.CellValue2(arrRow[i], prefix+"frt_ppd_flg") = formObject.elements["t1_chk_opt3"].checked ? "Y":"N";
//						sheetObject.CellValue2(arrRow[i], prefix+"frt_chg_flg") = formObject.elements["t1_chk_opt4"].checked ? "Y":"N";
//						sheetObject.CellValue2(arrRow[i], prefix+"frt_arr_flg") = formObject.elements["t1_chk_opt5"].checked ? "Y":"N";
//						sheetObject.CellValue2(arrRow[i], prefix+"hidd_opt") = formObject.elements["t1_chk_opt_hidden"].checked ? "Y":"N";
						sheetObject.CellValue2(arrRow[i], prefix+"ntc_knd_cd") = "EQ";
					}
					ufFaxEmailSend(sheetObject, formObject, "Email");
				}
            	break;	
        }
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj) {
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
                    InsertTab( cnt++ , "Outbound" , -1 );
                    InsertTab( cnt++ , "Inbound" , -1 );
                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab = nItem;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObject,formObject,sAction) {
        with (formObject) {
            switch(sAction) {
    			case IBSEARCH:
    				//조건적 필수 입력
    				var requiredFlag = false;
    				if (0==beforetab) {
    					var vvd = formObject.elements["t1_txt_vvd"];
    			    	var pol = formObject.elements["t1_txt_pol"];
    			    	var dt1 = formObject.elements["t1_txt_date_from"];
    			    	var dt2 = formObject.elements["t1_txt_date_to"];
    			    	var bkg = formObject.elements["t1_txt_bkg_no"];
    			    	var bl  = formObject.elements["t1_txt_bl_no"];
    			    	if ((!ComIsEmpty(vvd) && !ComIsEmpty(pol)) ||
    			    		(!ComIsEmpty(dt1) && !ComIsEmpty(dt2) && !ComIsEmpty(pol)) ||
    			    		!ComIsEmpty(bkg) || !ComIsEmpty(bl)) {
    			    		requiredFlag = true;
        	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
        	                    ComShowCodeMessage("BKG00756","Duration","31Days")
        	                    dt1.focus();
        	                    return false;
        	                }
    			    	} else {
    			    		alert("※ mandatory item\n\n"
    			    			+"＊ VVD and POL  OR\n"
    			    			+"＊ (On Board or B/L Issue Date) and POL  OR        \n"
    			    			+"＊ Booking No.  OR\n"
    			    			+"＊ B/L No.");
        			    	requiredFlag = false;
    			    	}
    				} else if (1==beforetab) {
    					var eta1 = formObject.elements["t2_txt_date_from"];
    					var eta2 = formObject.elements["t2_txt_date_to"];
    					var dt1  = formObject.elements["t2_txt_date_from2"];
    					var dt2  = formObject.elements["t2_txt_date_to2"];
    					var pod  = formObject.elements["t2_txt_pod"];
    					var vvd  = formObject.elements["t2_txt_vvd"];
    					var bl   = formObject.elements["t2_txt_bl_no"];
    			    	if ((((!ComIsEmpty(eta1) && !ComIsEmpty(eta2)) || (!ComIsEmpty(dt1) && !ComIsEmpty(dt2))) && !ComIsEmpty(pod)) ||
				    		(!ComIsEmpty(vvd) && !ComIsEmpty(pod)) ||
				    		!ComIsEmpty(bl)) {
				    		requiredFlag = true;
	    	                if (ComGetDaysBetween(eta1.value,eta2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    eta1.focus();
	    	                    return false;
	    	                }
	    	                if (ComGetDaysBetween(dt1.value,dt2.value) > 31 ) {
	    	                    ComShowCodeMessage("BKG00756","Duration","31Days")
	    	                    dt1.focus();
	    	                    return false;
	    	                }
				    	} else {
				    		alert("※ mandatory item\n\n"
    			    			+"＊ (ETA Date or (On Board or B/L Issue Date)) and POD  OR        \n"
    			    			+"＊ VVD and POD  OR\n"
    			    			+"＊ B/L No.");
        			    	requiredFlag = false;
    			    	}
    				}
    				if(!requiredFlag || !ComChkValid(formObject)) return false;
    				break;
    			case "btn_preview_t1sht1":
    			case "btn_preview_t2sht1":
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (50<sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
    					return false;
    				}
					break;
    			case "btn_manifest_t1sht1":
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (50<sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG08124",50);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
    					return false;
    				}
    				break;
    			case "btn_groupemail_t1sht1":
    			case "btn_groupemail_t2sht1":
    			case "btn_EmailEdit_t1sht1":
    			case "btn_EmailEdit_t2sht1":
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var returnFlg = true;
    				var messageCd = "";
    				var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						var shpr_cd = sheetObject.CellValue(arrRow[0],sheetObject.id+"shpr_cd");
						var email = sheetObject.CellValue(arrRow[0],sheetObject.id+"eml");
						var loop_shpr_cd;
						var loop_email;
						for (var i=0; i<arrRow.length; i++) {
							loop_shpr_cd = sheetObject.CellValue(arrRow[i],sheetObject.id+"shpr_cd");
							loop_email = sheetObject.CellValue(arrRow[i],sheetObject.id+"eml");
							if (""==loop_email || shpr_cd != loop_shpr_cd || email != loop_email) {
								messageCd = "BKG00357";  //동일한 shipper code 또는 e-mail이 아닙니다.
								returnFlg = false;
								break;
							}
						}
						if (!returnFlg) {
							var ff_cd = sheetObject.CellValue(arrRow[0],sheetObject.id+"ff_cd");
							var loop_ff_cd;
							var loop_email;
							for (var i=0; i<arrRow.length; i++) {
								loop_ff_cd = sheetObject.CellValue(arrRow[i],sheetObject.id+"ff_cd")
								loop_email = sheetObject.CellValue(arrRow[i],sheetObject.id+"eml");
								if (''!=loop_ff_cd && ff_cd == loop_ff_cd && email == loop_email) {
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
					break;
    			case "btn_fax_t1sht1":
    			case "btn_fax_t2sht1":
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							if (ComIsNull(sheetObject.CellValue(arrRow[i],sheetObject.id+"fax_no"))) {
								ComShowCodeMessage("BKG00404","Fax","Fax Number");  //"{?msg1} is mandatory. Please enter {?msg2}."
								sheetObject.SelectCell(arrRow[i],sheetObject.id+"fax_no");
								return false;
							}
						}
					}
    				break;
    			case "btn_emailSR_t1sht1":
    			case "btn_email_t1sht1":
    			case "btn_email_t2sht1":
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							if (ComIsNull(sheetObject.CellValue(arrRow[i],sheetObject.id+"eml"))) {
								ComShowCodeMessage("BKG00404","E-mail Address","E-mail Address");  //"{?msg1} is mandatory. Please enter {?msg2}."
								sheetObject.SelectCell(arrRow[i],sheetObject.id+"eml");
								return false;
							}
						}
					}
    				break;
    			default:
    				if (0==sheetObject.RowCount) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
            }
        }
        return true;
    }

	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 0;
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	function rdOpen(rdObject, formObject, viewType) {
		switch(viewType) {
			case "print":
		    	var sheetObject = sheetObjects[beforetab];
		    	var prefix = sheetObject.id;
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
					//rdObject.SetMessageboxShow(1); //에러메시지만 출력함
					rdObject.FileOpen(RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath, RDServer + rdParam);
					if ("US"==formObject.strCnt_cd.value) {
						rdObject.SetPrint2(4,1,1,100);
					}
					rdObject.PrintDialog();//CMPrint();
				}
				break;
			case "down":
				var rdViewer = rdObject;
				var sheetObject = sheetObjects[beforetab];
				var prefix = sheetObject.id;
				var subject = "test";
				var arrRow = ComFindText(sheetObject, prefix+"slct_flg", 1);
				if (arrRow && 0<arrRow.length) {
					ufSetRdParamByBkgNos(formObject,arrRow[i],arrRow);
					
					//rdObject.SetMessageboxShow(1); //에러메시지만 출력함
					rdViewer.FileOpen(RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+rdPath, RDServer + rdParam);
					
					if ("US"==formObject.strCnt_cd.value) {
						rdViewer.SetPrint2(4,1,1,100);
					}
//					rdViewer.SetSaveDialogEx("", "", "xls@pdf@bmp@tif","pdf"); // 파일저장 대화상자 초기값 설정: 위치, 파일이름, 파일형식
//					var ret = rdViewer.SaveAsDialog(); // 파일저장 대화상자 띄워서 현재문서 저장함
					rdViewer.SaveAsPdfFile("C:\\rdfiles\\" + subject + ".pdf");
//					rdObject.PrintDialog();//CMPrint();
				}
				break;
		}
	}
	
	/**
	 * 마우스 오버
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function t1sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
		ufDisplayTooltip(sheetObject);
	}
	function t2sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
		ufDisplayTooltip(sheetObject);
	}
	function ufDisplayTooltip(sheetObject) {
		var m_row = sheetObject.MouseRow;
		var m_colNm = sheetObject.ColSaveName(sheetObject.MouseCol);
		if (0<m_row) {
			with (sheetObject) {
				if (m_colNm==id+"short_shpr_nm") {
					MouseToolTipText = CellValue(m_row,id+"shpr_nm");
				} else if (m_colNm==id+"fax_result" && "Failed"==CellValue(m_row,id+"fax_result")) {
					MouseToolTipText = ComIsNull(CellValue(m_row,id+"fax_reason")) ? "no message":CellValue(m_row,id+"fax_reason");
				} else if (m_colNm==id+"eml_result" && "Failed"==CellValue(m_row,id+"eml_result")) {
					MouseToolTipText = ComIsNull(CellValue(m_row,id+"eml_reason")) ? "no message":CellValue(m_row,id+"eml_reason");
				} else {
					MouseToolTipText = "";
				}
			}
		}
	}

    function t1sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with (sheetObject) {
            ColFontUnderline(sheetObject.id+"bkg_no") = true;
            ColFontColor(sheetObject.id+"bkg_no") = RgbColor(0,0,255);
            for(i=2 ; i<=LastRow; i++) {
                if ("Failed"==CellValue(i,id+"fax_result")) {
                	CellFontUnderline(i,id+"fax_result") = true;
                } else if ("Failed"==CellValue(i,id+"eml_result")) {
                	CellFontUnderline(i,id+"eml_result") = true;
                }
                if (""!=CellValue(i,id+"fax_result")) {
					PopupButtonImage(i, id+"fax_his_btn") = 2;
                } else {
                    SetMergeCell(i,18,1,2);
                }
                if (""!=CellValue(i,id+"eml_result")) {
					PopupButtonImage(i, id+"eml_his_btn") = 2;
                } else {
                    SetMergeCell(i,22,1,2);
                }
            }
        }
    }
    function t2sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with(sheetObject) {
            ColFontUnderline(sheetObject.id+"bkg_no") = true;
            ColFontColor(sheetObject.id+"bkg_no") = RgbColor(0,0,255);
            for(i=2 ; i<=LastRow; i++) {
                if ("Failed"==CellValue(i,id+"fax_result")) {
                	CellFontUnderline(i,id+"fax_result") = true;
                } else if ("Failed"==CellValue(i,id+"eml_result")) {
                	CellFontUnderline(i,id+"eml_result") = true;
                }
                if (""!=CellValue(i,id+"fax_result")) {
					PopupButtonImage(i, id+"fax_his_btn") = 2;
                } else {
                    SetMergeCell(i,18,1,2);  //fax result cell
                }
                if (""!=CellValue(i,id+"eml_result")) {
					PopupButtonImage(i, id+"eml_his_btn") = 2;
                } else {
                    SetMergeCell(i,22,1,2);  //email result cell
                }
            }
        }
    }

	/**
	* IBSheet Object에서 팝업을 클릭시
	*/
	function t1sheet1_OnPopupClick(sheetObject, row, col) {
		if (sheetObject.id+"fax_btn"==sheetObject.ColSaveName(col) ||
			sheetObject.id+"eml_btn"==sheetObject.ColSaveName(col)) {
	 		sheetFaxEmlBtnClick(sheetObject, row, col);
		} else if (sheetObject.id+"fax_his_btn"==sheetObject.ColSaveName(col) && ""!=sheetObject.CellValue(row,sheetObject.id+"fax_result")) {
	 		sheetMultiBtnClick(sheetObject, row, col);
		} else if (sheetObject.id+"eml_his_btn"==sheetObject.ColSaveName(col) && ""!=sheetObject.CellValue(row,sheetObject.id+"eml_result")) {
	 		sheetMultiBtnClick(sheetObject, row, col);
		}
	}
	function t2sheet1_OnPopupClick(sheetObject, row, col) {
		if (sheetObject.id+"fax_btn"==sheetObject.ColSaveName(col) ||
			sheetObject.id+"eml_btn"==sheetObject.ColSaveName(col)) {
	 		sheetFaxEmlBtnClick(sheetObject, row, col);
		} else if (sheetObject.id+"fax_his_btn"==sheetObject.ColSaveName(col) && ""!=sheetObject.CellValue(row,sheetObject.id+"fax_result")) {
	 		sheetMultiBtnClick(sheetObject, row, col);
		} else if (sheetObject.id+"eml_his_btn"==sheetObject.ColSaveName(col) && ""!=sheetObject.CellValue(row,sheetObject.id+"eml_result")) {
	 		sheetMultiBtnClick(sheetObject, row, col);
		}
	}

    //BKG 메인팝업을 호출한다.
	function t1sheet1_OnDblClick(sheetObject, row, col) {
		openBkgMainPopup(sheetObject, row, col);
	}
	function t2sheet1_OnDblClick(sheetObject, row, col) {
		openBkgMainPopup(sheetObject, row, col);
	}
	function openBkgMainPopup(sheetObject, row, col) {
		if (sheetObject.id+"bkg_no"==sheetObject.ColSaveName(col)) {
			var bkg_no = sheetObject.CellValue(row, sheetObject.id+"bkg_no");
			if (""==bkg_no) {
				ComShowCodeMessage("BKG08017");  //BKG No. not exists
				return;
			}
			//freezing관련 수정
//			ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+bkg_no+"&mainPage=false", "ESM_BKG_0079", 1024, 768, false);
			comBkgCallPopBkgDetail(bkg_no);   
		}
	}

	function sheetFaxEmlBtnClick(sheetObject, Row, Col) {
 		var prefix = sheetObject.id;
		var formObject = document.form;
		var param = "";
		if ("Y"==sheetObject.CellValue(Row, prefix+"new_flg")) {
			sheetObject.RowHidden(Row)= true;		//2.행 숨기기
			sheetObject.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		} else {
			var Row = sheetObject.DataCopy();
			sheetObject.RowStatus(Row) = "R";
			sheetObject.CellValue2(Row, prefix+"fax_no") = "";
			sheetObject.CellValue2(Row, prefix+"fax_btn") = "";
			sheetObject.CellValue2(Row, prefix+"eml") = "";
			sheetObject.CellValue2(Row, prefix+"eml_btn") = "";
			sheetObject.CellValue2(Row, prefix+"fax_result") = "";
			sheetObject.CellValue2(Row, prefix+"fax_date") = "";
			sheetObject.CellValue2(Row, prefix+"eml_result") = "";
			sheetObject.CellValue2(Row, prefix+"eml_date") = "";
			sheetObject.CellValue2(Row, prefix+"frt_all_flg") = "";
			sheetObject.CellValue2(Row, prefix+"frt_clt_flg") = "";
			sheetObject.CellValue2(Row, prefix+"frt_ppd_flg") = "";
			sheetObject.CellValue2(Row, prefix+"frt_chg_flg") = "";
			sheetObject.CellValue2(Row, prefix+"frt_arr_flg") = "";
			sheetObject.CellValue2(Row, prefix+"new_flg") = "Y";
			//2015.10.13 팩스기능 삭제 Edit Fax/E-mail
            if(pgmNo != "ESM_BKG_0218_02"){			
				sheetObject.PopupButtonImage(Row, prefix+"fax_btn") = 1;
			}
			sheetObject.PopupButtonImage(Row, prefix+"eml_btn") = 1;
		}
 	}

 	function sheetMultiBtnClick(sheetObject, Row, Col) {
 		var prefix = sheetObject.id;
		var formObject = document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo = sheetObject.CellValue(Row,prefix+"bkg_no");
 		if (0==beforetab) {
 			ntcKndCd = "W"==ComGetObjValue(formObject.elements["t1_rdo_bl_tp_cd"]) ? "WB" : "BL";
 		} else if (1==beforetab) {
 			ntcKndCd = "W"==ComGetObjValue(formObject.elements["t2_rdo_bl_tp_cd"]) ? "WB" : "NN";
 		}
 		if (prefix+"fax_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "F";
 		} else if (prefix+"eml_his_btn"==sheetObject.ColSaveName(Col)) {
 			ntcViaCd = "M";
 		}
		ComOpenWindowCenter("ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, "ESM_BKG_1071", 715, 500, false);
 	}
 	
    //remark popup(0913)에서 호출됨
    function setRemark(remark) {
    	var sheetObject = sheetObjects[beforetab];
    	var prefix = sheetObject.id;
		var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				sheetObject.CellValue2(arrRow[i],prefix+"remark") = remark;
			}
		}
    }

    function ufRedrawSheet(sheetObject,sXml) {
       	var arrXml = sXml.split("|$$|");
   		sheetObject.Redraw = false;
   		sheetObject.LoadSearchXml(arrXml[0]);
   		sheetObject.Redraw = true;
    }

    //rd 파라미터 세팅(일반)
    function ufSetRdParam(formObject, rowIdx) {
    	var sheetObject = sheetObjects[beforetab];
		var bkg_no = "'"+sheetObject.CellValue(rowIdx,sheetObject.id+"bkg_no")+"'";
	    ufSetRdParamCommon(formObject, rowIdx, bkg_no);
    }

    //rd 파라미터 세팅(그룹이메일)
    function ufSetRdParamByBkgNos(formObject, rowIdx, arrRow) {
    	var sheetObject = sheetObjects[beforetab];
		var bkg_no = "";
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				bkg_no += "'"+sheetObject.CellValue(arrRow[i],sheetObject.id+"bkg_no")+"',";
			}
			if (0<bkg_no.lastIndexOf(",")) bkg_no = bkg_no.substring(0,bkg_no.length-1);
		    ufSetRdParamCommon(formObject, rowIdx, bkg_no);
		}
    }

    //rd 파라미터 세팅
    function ufSetRdParamCommon(formObject, rowIdx, bkg_no) {
    	var sheetObject = sheetObjects[beforetab];
		var form_type = "D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) ? (1==beforetab ? "2" : "4"):"5";
		var form_dataOnly = "N";
		var form_manifest = "N";
		var form_usrId = formObject.elements["strUsr_id"].value;
		var form_hiddeData = formObject.elements["t"+(beforetab+1)+"_chk_opt_hidden"].checked ? "Y":"N";
		var form_level = "";
		var form_remark = "";
		var pdf_file_name = "";
		if (1<bkg_no.split(",").length) {
			pdf_file_name = bkg_no.replace(/'/g,"").substring(0,bkg_no.indexOf(",")-2)+"_"+bkg_no.split(",").length;
		} else {
			pdf_file_name = bkg_no.replace(/'/g,"");
		}
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt1"].checked) form_level += "1,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt2"].checked) form_level += "5,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt3"].checked) form_level += "4,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt4"].checked) form_level += "6,";
		if (formObject.elements["t"+(beforetab+1)+"_chk_opt5"].checked) form_level += "3,";
		if (0<form_level.indexOf(",")) form_level = form_level.substring(0,form_level.length-1);
		form_level = 0<form_level.length ? form_level : "1";
		form_remark = encodeRemark(sheetObject.CellValue(rowIdx,sheetObject.id+"remark"));
		rdParam  = "/rv";
		rdParam += " form_bkgNo[("+bkg_no+")]";
		rdParam += " form_type["+form_type+"]";
		rdParam += " form_dataOnly["+form_dataOnly+"]";
		rdParam += " form_manifest["+form_manifest+"]";
		rdParam += " form_usrId["+form_usrId+"]";
		rdParam += " form_hiddeData["+form_hiddeData+"]";
		rdParam += " form_level[("+form_level+")]";
		rdParam += " form_remark["+form_remark+"]";
		rdParam += " form_Cntr[1]";
		rdParam += " form_mainOnly[N]";
		rdParam += " form_CorrNo[]"; // form_CorrNo
		rdParam += " form_his_cntr[BKG_CONTAINER]"; // form_his_cntr
		rdParam += " form_his_bkg[BKG_BOOKING]"; // form_his_bkg
		rdParam += " form_his_mkd[BKG_BL_MK_DESC]"; // form_his_mkd
		rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]"; // form_his_xpt
		rdParam += " form_his_bl[BKG_BL_DOC]"; // form_his_bl
		rdParam += " isEncode[Y]";
		rdParam += " /rp []";
		rdParam += " /riprnmargin";// /rwait /rmatchprndrv[3]";
		rdPath = "D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "ESM_BKG_0109_DBL.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
		if ("ESM_BKG_0109_OBL_A4.mrd"==rdPath && 0==sheetObject.CellValue(rowIdx,sheetObject.id+"por_cd").indexOf("US")) {
			rdPath = "ESM_BKG_0109_OBL_LETTER.mrd";
		}
		formObject.com_mrdPath.value = rdPath;
		rdPdf = "D"==ComGetObjValue(formObject.elements["t"+(beforetab+1)+"_rdo_bl_tp_cd"]) && 0==beforetab ? "Draft_"+pdf_file_name+".pdf" : "WayBill_"+pdf_file_name+".pdf";
    }

    // fax, email 세팅
    function ufFaxEmailSend(sheetObject, formObject, strGubun) {
		//ComOpenWait(true);
		var sXml = sheetObject.GetSaveXml("ESM_BKG_0218GS.do", FormQueryString(formObject) + "&" + sheetObject.GetSaveString(false,true,1));
		//ComOpenWait(false);
		if ("ERROR"==sXml.substring(1,6)){
			//alert(ComResultMessage(sXml).split('<||>').join('\n'));
			ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
		} else {
			ComSetObjValue(formObject.elements["edt_ntc_knd_cd" ],"");
			ComSetObjValue(formObject.elements["edt_bkg_no_list"],"");
			ComSetObjValue(formObject.elements["edt_to_eml"     ],"");
			ComSetObjValue(formObject.elements["edt_cc_eml"     ],"");
			ComSetObjValue(formObject.elements["edt_from_eml"   ],"");
			ComSetObjValue(formObject.elements["edt_subject"    ],"");
			ComSetObjValue(formObject.elements["edt_contents"   ],"");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if ("S"==State) {
				//2015.10.13 팩스기능 삭제 Edit Fax/E-mail
	            if(pgmNo != "ESM_BKG_0218_02"){			
		            ComShowCodeMessage("BKG06082");
	            }else{
					ComShowCodeMessage("BKG43055");
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				return;
			}
		}
	}

    function window.getParameter(p) {
	  if (p) r=location.search.match(new RegExp("[&?]"+p+"=(.*?)(&|$)"));
	  return r&&r[1]?r[1]:null;
	}

    //edit fax/email 팝업에서 호출됨
    function getCOM_Fax_Email_POPUP(rowArray) {
    	if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
	    	var faxno = rowArray[0][21];
	        var email = rowArray[0][22];
	    	var sheetObject = sheetObjects[beforetab];
	    	var prefix = sheetObject.id;
			var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
 					sheetObject.CellValue2(arrRow[i],prefix+"fax_no") = faxno;
 					sheetObject.CellValue2(arrRow[i],prefix+"eml") = email;
				}
			}
    	}
    }

    //remark를 encoding함
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g,"''");
	}
	
	
    // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(bkgBlNo){
    	var formObj = document.form;
    	var bkg_no = formObj.bkg_no.value;
    	var _Width = '400';
		var _Height = '420';
		
    	var rdo_bkg_bl = ComGetObjValue(formObj.elements["t1_rdo_bkg_bl"]);
    	if ("BKG"==rdo_bkg_bl) {
    		var url = "ESM_BKG_9457.do?bkg_no="+formObj.t1_txt_bkg_no.value;
    	} else if ("BL"==rdo_bkg_bl) {
    		var url = "ESM_BKG_9457.do?bkg_no="+formObj.t1_txt_bl_no.value;
    	}
    	
//    	var newWin = window.showModalDialog("ESM_BKG_9457.do?bkg_no="+bkgNo, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
		
    	var newWin = ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
    }
    
    // Pop UP 에서 입력된 No 를 전달 받는다.
    function addValueNo(multi_value){
    	var formObject = document.form;
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
    	if(multi_value != ''){
        	var rdo_bkg_bl = ComGetObjValue(formObject.elements["t1_rdo_bkg_bl"]);
        	if ("BKG"==rdo_bkg_bl) {
        		document.getElementById('t1_txt_bkg_no').value = multi_value;	
        	} else if ("BL"==rdo_bkg_bl) {
        		document.getElementById('t1_txt_bl_no').value = multi_value;	
        	}
    		
    	}
	}	
    /* 개발자 작업  끝 */
