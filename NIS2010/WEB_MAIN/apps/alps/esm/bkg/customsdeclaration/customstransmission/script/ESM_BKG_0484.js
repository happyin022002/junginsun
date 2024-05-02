/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0484.js
*@FileTitle : ESM_BKG_0484
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier : 민정호
*@LastVersion : 1.2
* 2009.10.08 경종윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 1.1 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
* 1.2 2011.05.26 민정호 [CHM-201111097] [SITPRO] MRN정보 Tick박스 생성 (Tick마크시, Excel 다운로드시 포함)
* 2013.11.18 김보배 [CHM-201327127] [RFS Lane] Double calling logic 적용 요청 (2) SItpro & Firm BKG
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//전역변수
var intervalId = "";


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

				case "btn_retrieve":
					//ComShowMessage(srcName);
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
				break;

				case "btn_sitpro":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;	

				case "p_option":
					if (formObject.p_option[1].checked) {
						formObject.p_pod_cd_temp.Enable = true;
						ComBtnDisable("btn_DownExcel");
						ComBtnDisable("btn_sitpro");
						ComBtnEnable("btn_DownENS");
						document.getElementById("mrn").disabled = false;
					} else {
						formObject.p_pod_cd_temp.Enable = false;
						ComBtnEnable("btn_DownExcel");
						ComBtnEnable("btn_sitpro");
						ComBtnDisable("btn_DownENS");
						document.getElementById("mrn").disabled = true;
						document.getElementById("mrn").checked = false;
					}
					
					sheetObjects[0].RemoveAll();
				break;

				case "btn_DownENS":
					doActionIBSheet(sheetObjects[0], formObject, "DownENS");
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

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // 화면에 사용되는 이벤트
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'bkg_change', document.form); // change

    	document.form.p_pod_cd_temp.Enable = false;
		ComBtnDisable("btn_DownENS");
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle1 = "|Sel.|Seq.|BKG No.|STS|CGO|B/L No.|T.VVD|POR|B.POL|B.POD|DEL|BKG STAFF|act_vvd_cnt |slan_cd";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        			InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter, 	false,    "ibflag");
	                InitDataProperty(0, cnt++,  dtDummyCheck, 	40,    daCenterTop, true, 	  "check");
	                InitDataProperty(0, cnt++ , dtSeq,	 		30,    daCenter,    true,     "Seq",     		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData, 		95,    daCenter,    true,     "bkg_no",     	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,    true,     "bkg_sts_cd",     false,    "",      dfNone, 		0,     false,		false);
                    
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,    true,     "bkg_cgo_tp_cd",     false,    "",      dfNone, 		0,     false,		false);
					
                    InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,    true,     "bl_no",  		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData, 		100,   daCenter,    true,     "tvvd_cd",    	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData,   	 	100,   daCenter,	  true,   "por_cd",      	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 	 	100,   daCenter,    true,     "b_pol_cd",    	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    true,     "b_pod_cd",  		false,    "",      dfNone, 		0,     false,		false);
                                                  
					InitDataProperty(0, cnt++ , dtData,      	95,    daCenter,    true,     "del_cd",   		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	60,    daCenter,    true,     "doc_usr_id",   	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,    true,     "act_vvd_cnt",   	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,    true,     "slan_cd",   	false,    "",      dfNone, 		0,     false,		false);
					
					WaitImageVisible=false;

               }
               break;

			case "sheet2":  //POFE
				with (sheetObj) {
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					Editable = false;
					InitRowInfo(1, 1, 3, 100);
					var HeadTitle = "|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name|edi_mrn";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 0, 0, true);
					InitHeadMode(false, false, true, true, false,false);
					InitHeadRow(0, HeadTitle, true);
					InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "search_eu_1st_port_yd_cd", false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_yd_cd",        false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "eu_1st_port_name",         false,  "",  dfNone,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "edi_mrn",         			false,  "",  dfNone,  0,  false,  false);
				}
				break;

			case "sheet3":  //ENS Download
				with (sheetObj) {
//style.height = 300;
//SheetWidth = 400;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					Editable = false;
					InitRowInfo(1, 1, 3, 100);
					var HeadTitle = "";
                    HeadTitle += "Number of items contained in the ENS"
                    HeadTitle += "|Unique consignment reference number assigned to the goods";
                    HeadTitle += "|Transport document number";
                    HeadTitle += "|Consignor";
                    HeadTitle += "|Shipper address";
                    HeadTitle += "|Person lodging the ENS";
                    HeadTitle += "|Consignee";
                    HeadTitle += "|Cnee address";
                    HeadTitle += "|Carrier";
                    HeadTitle += "|Party to be notified at arrival of the goods";
                    HeadTitle += "|Notify address";
                    HeadTitle += "|Identity and nationality of active means of transport entering the EU";
                    HeadTitle += "|Conveyance reference number";
                    HeadTitle += "|Code for the first place of arrival in the EU";
                    HeadTitle += "|Date and time of arrival at the first place in the EU";
                    HeadTitle += "|Code(s) for the country(ies) of routing (including the countries of departure and destination) to the extent known";
                    HeadTitle += "|Mode of transport at the border";
                    HeadTitle += "|Code for the place of loading";
                    HeadTitle += "|Code for the place of unloading";
                    HeadTitle += "|Acceptable goods description (not necessary if the 4 digits HS code is provided)";
                    HeadTitle += "|Code for the type of packages";
                    HeadTitle += "|Number of packages";
                    HeadTitle += "|Shipping marks for packaged goods (not necessary for containerised goods)";
                    HeadTitle += "|Container identification marks";
                    HeadTitle += "|Number of the item in relation to the total number of items";
                    HeadTitle += "|C/M Description";
                    HeadTitle += "|4 digit HS code (not necessary if a goods description is provided)";
                    HeadTitle += "|Gross mass (kg)";
                    HeadTitle += "|UN code for dangerous goods";
                    HeadTitle += "|Seal number";
                    HeadTitle += "|Code for the method of payment for transport charges (e.g. cash, credit card)";
                    HeadTitle += "|Declaration date";
                    HeadTitle += "|Signature/authentification";
                    HeadTitle += "|Code for special circumstances (postal/express consignment, ship/aircraft supplies, road/rail transport, AOE) if applicable";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 0, 0, true);
					InitHeadMode(false, false, true, true, false,false);
					InitHeadRow(0, HeadTitle, true);
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "seq"          );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "bkg_no"       );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "trsp_doc_no"  );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "s_cust_nm"    );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "s_cust_addr"  );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item5"        );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "c_cust_nm"    );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "c_cust_addr"  );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item7"        );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "n_cust_nm"    );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "n_cust_addr"  );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "trans_mode"   );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "crn"          );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cstms_port_cd");
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "vps_eta_dt"   );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "route_country");
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item14"       );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "load_loc_cd"  );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "unload_loc_cd");
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cstms_desc"   );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "pkg_type"     );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "pkg_count"    );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cm_ship_mark" );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cntr_no"      );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "pck_qty"      );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cntr_mf_gds_desc");
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "cmdt_hs_cd"   );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "act_wgt"      );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "imdg_un_no"   );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "seal_nbr"     );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item27"       );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "ddate"        );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item29"       );
					InitDataProperty(0, cnt++ , dtData, 50, daLeft, true, "item30"       );
				}
				break;

			case "sheet4":  //ENS Download2 - MRD항목 추가
			with (sheetObj) {
//style.height = 300;
//SheetWidth = 400;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				Editable = false;
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle = "";
                HeadTitle += "Number of\n items contained\n in the ENS"
                HeadTitle += "|Unique consignment\n reference number\n assigned to the goods";
                HeadTitle += "|Transport\n document\n number";
                HeadTitle += "|Consignor";
                HeadTitle += "|Shipper address";
                HeadTitle += "|Person lodging the ENS";
                HeadTitle += "|Consignee";
                HeadTitle += "|Cnee address";
                HeadTitle += "|Carrier";
                HeadTitle += "|Party to be notified\n at arrival of the goods";
                HeadTitle += "|Notify address";
                HeadTitle += "|Identity and nationality\n of active means\n of transport entering the EU";
                HeadTitle += "|Conveyance\n reference number";
                HeadTitle += "|Code for the first place\n of arrival in the EU";
                HeadTitle += "|Date and time of arrival\n at the first place in the EU";
                HeadTitle += "|Code(s) for the country(ies) of\n routing (including the countries of departure\n and destination) to the extent known";
                HeadTitle += "|Mode of transport\n at the border";
                HeadTitle += "|Code for the place\n of loading";
                HeadTitle += "|Code for the place\n of unloading";
                HeadTitle += "|Acceptable goods description\n (not necessary if the 4 digits HS code is provided)";
                HeadTitle += "|Code for\n the type\n of packages";
                HeadTitle += "|Number\n of packages";
                HeadTitle += "|Shipping marks for packaged goods\n (not necessary for containerised goods)";
                HeadTitle += "|Container\n identification marks";
                HeadTitle += "|Number of the item in\n relation\n to the total number of items";
                HeadTitle += "|C/M Description";
                HeadTitle += "|4 digit HS code (not necessary\n if a goods description is provided)";
                HeadTitle += "|Gross mass\n (kg)";
                HeadTitle += "|UN code for\n dangerous goods";
                HeadTitle += "|Seal number";
                HeadTitle += "|Code for the method\n of payment for transport charges\n (e.g. cash, credit card)";
                HeadTitle += "|Declaration date";
                HeadTitle += "|Signature\n/authentification";
                HeadTitle += "|Code for special circumstances (postal/express consignment,\n ship/aircraft supplies, road/rail transport, AOE) if applicable";
                HeadTitle += "|MRN";
                
				var headCount = ComCountHeadTitle(HeadTitle);
				InitColumnInfo(headCount, 0, 0, true);
				InitHeadMode(false, false, true, true, false,false);				
				InitHeadRow(0, HeadTitle, true);
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "seq"          );
				InitDataProperty(0, cnt++ , dtData, 500, daLeft, true, "bkg_no"       );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "trsp_doc_no"  );
				InitDataProperty(0, cnt++ , dtData, 250, daLeft, true, "s_cust_nm"    );
				InitDataProperty(0, cnt++ , dtData, 250, daLeft, true, "s_cust_addr"  );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item5"        );
				InitDataProperty(0, cnt++ , dtData, 250, daLeft, true, "c_cust_nm"    );
				InitDataProperty(0, cnt++ , dtData, 250, daLeft, true, "c_cust_addr"  );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item7"        );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "n_cust_nm"    );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "n_cust_addr"  );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "trans_mode"   );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "crn"          );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cstms_port_cd");
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "vps_eta_dt"   );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "route_country");
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item14"       );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "load_loc_cd"  );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "unload_loc_cd");
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cstms_desc"   );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "pkg_type"     );
				InitDataProperty(0, cnt++ , dtData, 150, daRight, true, "pkg_count",		true,  "", dfInteger, 3, true, true          );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cm_ship_mark" );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cntr_no"      );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "pck_qty"      );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cntr_mf_gds_desc");
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "cmdt_hs_cd"   );
				InitDataProperty(0, cnt++ , dtData, 150, daRight, true, "act_wgt",			true,  "", dfFloat, 3, true, true      );
			
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "imdg_un_no"   );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "seal_nbr"     );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item27"       );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "ddate"        );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item29"       );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "item30"       );
				InitDataProperty(0, cnt++ , dtData, 150, daLeft, true, "mvmt_ref_no"  );				
			}
			break;
				
        }
    }

    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				
				ComSetFocus(formObj.f_cmd);
				
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				var ts_search_flag = "";
				
				if(formObj.check_ts_search.checked) {
					formObj.ts_search_flag.value = "T";
				} else {
					formObj.ts_search_flag.value = "";
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
								
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0484GS.do", FormQueryString(formObj));

				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSearchXml(sXml);
				}
				ComOpenWait(false);
				
				break;
			
			case IBSAVE: // Sitpro FLAT FILE 생성 및 전송
				
	            if(!validateForm(sheetObj,formObj,sAction)) return false;
				
	            // 해당 vvd, port가 현재 존재여부 조회 
	            formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0484GS.do", FormQueryString(formObj));
				var existVvdPortYn = ComGetEtcData(sXml, "existVvdPortYn");
				
				//alert("existVvdPortYn : " + existVvdPortYn );
				
				if(existVvdPortYn == "N") {
					ComShowCodeMessage("BKG00651", "VVD + (POL or POD)");
					ComSetFocus(formObj.vvd_cd);
					return false;
				}
	            
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
	            	return false;
	            }
	            
				setBndCd(); // bnd_cd 셋팅

				var rowCnt = sheetObj.RowCount;
				
				for(var i=1; i<=rowCnt; i++) {
					
					if(sheetObj.CellValue(i, "check") == 1) {
						//sheetObj.CellValue2(i,"ibflag") = "I";
						sheetObj.RowStatus(i) = "I";
					} else {
						//sheetObj.CellValue2(i,"ibflag") = "";
						sheetObj.RowStatus(i) = "";
					}
					
				}

				var sParam = "";
				
				var sParamSheet = sheetObj.GetSaveString();

				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				
				formObj.f_cmd.value = MULTI;
				sParam += "&" + FormQueryString(formObj);
				
				//alert("sParam : " + sParam);
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true,true);
 				var sXml = sheetObj.GetSaveXml("ESM_BKG_0484GS.do", sParam)
 				//sheetObj.LoadSaveXml(sXml);
				//formObj.output.value = ComGetEtcData(sXml, "flatFile");
 				
				var key = ComGetEtcData(sXml, "KEY");
				//ComShowMessage(key);
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

				
				break;
			
			case IBDOWNEXCEL: // 엑셀
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObj.SpeedDown2Excel(-1);
				ComOpenWait(false);
				break;

			case SEARCH01 : //POFE 조회
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				ComSetObjValue(formObj.p_vvd_cd, ComGetObjValue(formObj.vvd_cd));
				
				// 1106 메소드를 이용하여 POFE 를 구하므로 ENS 타입이라는 값 할당
				var sParam = "";  
				sParam += "p_type=ENS" +"&";
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1106GS.do", sParam);
				
//				var sXml = sheetObj.GetSearchXml("ESM_BKG_1106GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.p_pod_cd_temp, "search_eu_1st_port_yd_cd", "eu_1st_port_name");
				ComSetObjValue(formObj.p_pod_cd, "");
				ComSetObjValue(formObj.p_pod_yard_cd, "");
				sheetObjects[1].LoadSearchXml(sXml);
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				break;

			case "DownENS": // 엑셀
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
	            ComSetObjValue(formObj.f_cmd, SEARCH05);

				var inp;
				var len = formObj.elements.length;
				for (var i=0; i<len; i++) {
					if (formObj.elements[i] && formObj.elements[i].name) {
						if ("bkg_nos"==formObj.elements[i].name) {
							formObj.elements[i--].removeNode(true);
						}
					}
				}
				for (var i=1; i<=sheetObj.RowCount; i++) {
					if(sheetObj.CellValue(i, "check") == 1) {
						inp = document.createElement("input");
						inp.type = "hidden";
						inp.name = "bkg_nos";
						inp.value = sheetObj.CellValue(i, "bkg_no");
						formObj.appendChild(inp);
					}
				}

				var sXml = sheetObj.GetSearchXml("ESM_BKG_0484GS.do", FormQueryString(formObj));
				
			
				sheetObjects[3].LoadSearchXml(sXml);	// MRD 미포함 엑셀 다운로드

				
				ComOpenWait(false);
				break;

        }
    }

    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	//ComShowMessage("1");
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0484GS.do?f_cmd=" + SEARCH03
    			+ "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
    	
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
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
    	var sheet1RowCnt = sheetObj.RowCount;
    	
    	 switch(sAction) {
			case IBSEARCH: // 조회
			    
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				
				// 라디오버튼 클릭시 체크
				//if(!ioCheck(formObj)) return false;
				
				var vvdCd = formObj.vvd_cd.value;
				var polVal = formObj.pol_cd.value;
				var podVal = formObj.pod_cd.value;
				var blNo = formObj.bl_no.value;
				var bkgNo = formObj.bkg_no.value;
				
				//ComShowMessage("polVal : " + polVal + "\npodVal : " + podVal);
				
				if(bkgNo == "" && blNo == "") {
					
					if(vvdCd == "") {
						ComShowCodeMessage("BKG00251");
						ComSetFocus(formObj.vvd_cd);
						return false;
					}
				
					if(polVal == "" && podVal == "") {
						//ComShowMessage("POL또는 POD 중 반드시 1개 이상 입력해야합니다.");
						ComShowCodeMessage("BKG00378");
						ComSetFocus(formObj.pol_cd);
						return false;
					}
					
				}
				
				var ofcCd = formObj.ofcCd.value;
				if(ofcCd.substring(0,3) == "ANR") {
					if(polVal != "BEANR" && podVal != "BEANR") {
						//ComShowMessage("Office가 ANR일 경우 POL 또는 POD에 반드시 BEANR이 있어야 합니다.");
						ComShowCodeMessage("BKG06066");
						ComSetFocus(formObj.pol_cd);
						return false;
					}
				}
				
				
				break;
				
			case IBSAVE:
				if(sheet1RowCnt == 0) {
	        		//ComShowMessage("전송할 데이타가 없습니다.");
	        		ComShowCodeMessage('BKG01096');
	        		return false;
				}

				var checkCnt = 0;
				var manyActVvdFlag = false;
				for(var i=1; i <= sheet1RowCnt; i++) {
		        	if(sheetObj.CellValue(i, "check") == 1) {
		        		checkCnt++;
		        		
//		        		if( ( formObj.vvd_cd.value == ""  
//		        				 || (formObj.vvd_cd.value != "" && formObj.pol_cd.value == "") 
//		        				 || (formObj.vvd_cd.value != "" && formObj.pod_cd.value == "") )
//		        				 && sheetObj.CellValue(i, "act_vvd_cnt") > 1) {
//		        			manyActVvdFlag = true;
//		        			break;
//		        		}
		        		
		        		if(formObj.vvd_cd.value != "" && (formObj.pol_cd.value != "" || formObj.pod_cd.value != "")) {
		        			continue;
		        		} else {
		        			if(sheetObj.CellValue(i, "act_vvd_cnt") > 1) {
		        				manyActVvdFlag = true;
		        				break;
		        			}
		        		}
		        	}
		        }
				
				if(checkCnt == 0) {
		        	//ComShowMessage("전송할 row를 먼저 체크해 주세요");
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        } else {
		        	if(manyActVvdFlag) {
		        		
		        		var msg1 = "";
		        		
		        		if(formObj.bl_no.value != "") {
		        			msg1 = "B/L No";
		        		} else if(formObj.bkg_no.value != "") {
		        			msg1 = "BKG No";
		        		}
		        		
		        		// "This [{?msg1}] has t/s information, please input vvd & port(pol or pod)."
		        		ComShowCodeMessage("BKG06115", msg1);
		        		return false
		        	}
		        }

				if (!ComChkValid(formObj)) return false;

				break;
			
			case IBDOWNEXCEL:
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage("BKG00389");
					return false;
				}
				break;

			case "DownENS":
				if (!ComChkValid(formObj)) return false;
				
				if(sheet1RowCnt == 0) {
	        		ComShowCodeMessage('BKG00095');
	        		return false;
				}
				var arr = [formObj.vvd_cd,
				           formObj.pol_cd,
				           formObj.pod_cd,
				           formObj.bl_no,
				           formObj.bkg_no];
				if (ComIsEmpty(arr[3]) && ComIsEmpty(arr[4])) {
					if (ComIsEmpty(arr[0])) {
						ComShowCodeMessage("BKG00251");
						ComSetFocus(arr[0]);
						return false;
					}
					if(ComIsEmpty(arr[1]) && ComIsEmpty(arr[2])) {
						ComShowCodeMessage("BKG00378");
						ComSetFocus(arr[1]);
						return false;
					}
				}
				
				var checkCnt = 0;
				for(var i=1; i <= sheet1RowCnt; i++) {
		        	if(sheetObj.CellValue(i, "check") == 1) {
		        		checkCnt++;
		        	}
		        }
				if(checkCnt == 0) {
		        	ComShowCodeMessage('BKG01097');
		        	return false;
		        }
				break;
    	}
    	return true;
	}
    
    /**
     * 조회시 bound값 셋팅<br> 
     * POL이 KR 이면 Outbound 따라서 bnd_cd 는 O 아니면 Inbound 따라서 bnd_cd 는 I<br>
     * 
     * @return
     */
    function setBndCd() {
    	var formObj = document.form;
    	var polCd = formObj.pol_cd.value;
    	
    	if(polCd != "") {
    		
    		if(polCd.substr(1,2) == "KR") {
    			formObj.bnd_cd.value = "O";
    		} else {
    			formObj.bnd_cd.value = "I";
    		}
    		
    	} else {
    		formObj.bnd_cd.value = "I";
    	}
    	

    }

     /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change() {
	    switch (event.srcElement.getAttribute("name")) {
	    	case "vvd_cd":
	    		var formObj = document.form;
	    		sheetObjects[1].RemoveAll();
	    		formObj.p_pod_cd_temp.RemoveAll();
	    		ComSetObjValue(formObj.p_pod_yard_cd,"");
	    		ComSetObjValue(formObj.p_search_pofe_yard_cd,"");
	    		doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
	    		if (0<formObj.p_pod_cd_temp.GetCount()) {
	    			formObj.p_pod_cd_temp.Index = 0;
	    		}
	    		ComSetFocus(formObj.pol_cd);
				break;
	    }
    }

 	/**
 	 * Trans Type 콤보 이벤트 처리 
 	 * @param comboObj
 	 * @param value
 	 * @param text
 	 * @return
 	 */
 	function p_pod_cd_temp_OnChange(comboObj, value, text) {
 		var formObj = document.form;
 		ComSetObjValue(formObj.p_pod_yard_cd, sheetObjects[1].CellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"eu_1st_port_yd_cd"));
 		ComSetObjValue(formObj.p_search_pofe_yard_cd, sheetObjects[1].CellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"search_eu_1st_port_yd_cd"));
 		if ("" != sheetObjects[1].CellValue(sheetObjects[1].FindText('eu_1st_port_name',text),"edi_mrn")) {
 			ComSetObjValue(formObj.p_ori_amd_cd, "A");
 		} else {
 			ComSetObjValue(formObj.p_ori_amd_cd, "O");
 		}
 	}

//	function sheet3_OnSearchEnd(sheetObj, errMsg) {
//		with (sheetObj) {
//			if (0==RowCount) {
//				ComShowCodeMessage("BKG00389");
//			} else {
//				ComOpenWait(true);
//				SpeedDown2Excel(-1);
//				ComOpenWait(false);
//			}
//		}
//	}
	
	function sheet4_OnSearchEnd(sheetObj, errMsg) {
		var frmObj = document.form;
		
		with (sheetObj) {
			if (0==RowCount) {
				ComShowCodeMessage("BKG00389");
			} else {
				ComOpenWait(true);
				
                var exceptLines = "";
                var colSkips = "";
                
				if(!frmObj.mrn.checked) {
					colSkips = "mvmt_ref_no";
				}
                var xmlUrl = "http://"+location.hostname +":"+ location.port + "/hanjin/apps/alps/esm/bkg/customsdeclaration/customstransmission/script/ESM_BKG_0484.xml";        
                Redraw = false; 
                SpeedDown2Excel(-1, false, false, "", xmlUrl, false, false, "", false, colSkips, exceptLines);
                Redraw = true; 
                
				ComOpenWait(false);
			}
		}
	}	
