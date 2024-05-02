/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1164.js
*@FileTitle : Feeder BL Print(Russia)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : WONJOO CHO
*@LastVersion : 1.0
* 2013.07.08 WONJOO CHO
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
     * @class ESM_BKG_1164 : ESM_BKG_1164 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1164() {
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
var clickSheetObj;
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
		                
			        case "btn_save":
						//if(!validateForm(sheetObject1,formObject,"btn_save")) return false;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						if (arrRow && 0 < arrRow.length) {
			        	doActionIBSheet(sheetObject1,formObject,MULTI);
						}else {
		    				ComShowCodeMessage("COM12176");
		    				return false;
		    			}
	                    break;	
		            //Down Excel
		            case "btn_down_excel":
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		                break;

		                
		    		case "btn_Print":
		    			var param = bkgNos = "";
		    			var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
		    			if (arrRow && 0 < arrRow.length) {
		    				for ( var i = 0; i < arrRow.length; i++) {
		    					bkgNos += sheetObject1.CellValue(arrRow[i], sheetObject1.id
		    							+ "bkg_no")
		    							+ ",";
		    				}
		    				if (0 < bkgNos.indexOf(","))
		    					bkgNos = bkgNos.substring(0, bkgNos.length - 1);
		    				if (1000 < bkgNos.split(",").length) {
		    					ComShowCodeMessage("BKG08124", 500); // You select more
		    															// than {?msg1} B/Ls
		    															// for B/L print.
		    															// Max is {?msg1}
		    															// B/Ls one time
		    					return;
		    				}
		    			} else {
		    				ComShowCodeMessage("COM12176");
		    				return false;
		    			}
		    			var formObject2 = document.form2;
		    			var width = 925;
		    			var height = 370;
		    			var left = (screen.width-width)/2;
		    			var top = (screen.height-height)/2;
		    			ComOpenWindow("", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		    			formObject2.bkg_no.value = bkgNos;
		    			formObject2.param_ui_id.value = "ESM_BKG_1164";
		    			formObject2.action = "/hanjin/ESM_BKG_0743_01.do";
		    			formObject2.target = "PopupEsmBkg074301";
		    			formObject2.submit();
		    			break;

		    		case "btn_PDFPrint":
		    			var param = bkgNos = "";
		    			var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
		    			if (arrRow && 0 < arrRow.length) {
		    				for ( var i = 0; i < arrRow.length; i++) {
		    					bkgNos += sheetObject1.CellValue(arrRow[i], sheetObject1.id+"bkg_no") + ",";
		    				}
		    				if (0 < bkgNos.indexOf(","))
		    					bkgNos = bkgNos.substring(0, bkgNos.length - 1);
		    				if (1000 < bkgNos.split(",").length) {
		    					ComShowCodeMessage("BKG08124", 500); // You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
		    					return;
		    				}
		    			} else {
		    				ComShowCodeMessage("COM12176");
		    				return false;
		    			}
		    			var formObject2 = document.form2;
		    			var width = 925;
		    			var height = 670;
		    			var left = (screen.width-width)/2;
		    			var top = (screen.height-height)/2;
		    			ComOpenWindow("", "PopupEsmBkg1151", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		    			formObject2.bkg_no.value = bkgNos;
		    			formObject2.param_ui_id.value = "ESM_BKG_1164";
		    			formObject2.action = "/hanjin/ESM_BKG_1151.do";
		    			formObject2.target = "PopupEsmBkg1151";
		    			formObject2.submit();
		    			break;
		    			
					case "btn_edit_cust_info":
	    				if(!validateForm(sheetObject1,formObject,"btn_edit_cust_info")) return false;
			        	//open popup 0221
	    				//clickRow = Row;
	    				
			        	var width = 500;
						var height = 600;
						var left = (screen.width-width)/2;
						var top = (screen.height-height)/2;
						ComOpenWindow("about:blank","ESM_BKG_1165","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);

						//send popup
						var formObject3 = document.form3;
						var arrRow = ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						formObject3.elements["pop_mode"   ].value = "1";
						formObject3.elements["display"    ].value = "1,0,1,1,1,1,1";
						formObject3.elements["func"       ].value = "getEdit_Cust_Info_POPUP";
						formObject3.elements["row"        ].value = "0";
						formObject3.elements["col"        ].value = "0";
						formObject3.elements["sheetIdx"   ].value = "0";
						formObject3.elements["bkg_no"     ].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"bkg_no");
						formObject3.elements["bl_no"     ].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"bl_no");
						formObject3.elements["sh_cust_nm"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"shpr_nm");
						formObject3.elements["sh_cust_addr"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"shpr_addr");
						formObject3.elements["cn_cust_nm"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"cnee_nm");
						formObject3.elements["cn_cust_addr"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"cnee_addr");
						formObject3.elements["nf_cust_nm"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"ntfy_nm");
						formObject3.elements["nf_cust_addr"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"ntfy_addr");
						formObject3.elements["ex_cust_nm"].value = sheetObject1.CellValue(arrRow[0],sheetObject1.id+"ex_cust_nm");
						
						formObject3.action = "/hanjin/ESM_BKG_1165.do";
						formObject3.target = "ESM_BKG_1165";
						formObject3.submit();
	                    break;
		    			

        		}
    		}

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

        	beforetab = 0;
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
                    style.height = 350;
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
                    InitColumnInfo(17, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.||Booking No.|S|B/L No.|Shipper Name|Shipper Address|CNEE Name|CNEE Address|Notify Name|Notify Address|Export Ref.\nNumber|POL|POR|POD|DEL";
                    var HeadTitle1 = "|Sel.||Booking No.|S|B/L No.|Shipper Name|Shipper Address|CNEE Name|CNEE Address|Notify Name|Notify Address|Export Ref.\nNumber|POL|POR|POD|DEL";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    SetMergeCell(0,1,2,2);
                   
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++, dtHiddenStatus,0,   daCenter,  true, prefix+"ibflag"        );
                  InitDataProperty(0, cnt++, dtCheckBox,    18,  daCenter,  true, prefix+"slct_flg"      );
				  InitDataProperty(0, cnt++, dtDataSeq,     40,  daCenter,  true,  prefix+"seq"           );
                  InitDataProperty(0, cnt++, dtData,        90,  daLeft,    true,  prefix+"bkg_no",       false, "", dfNone,        0, false, false);
                  InitDataProperty(0, cnt++, dtData,        20,  daCenter,  true,  prefix+"bkg_sts_cd",   false, "", dfNone,        0, false, false);
                  InitDataProperty(0, cnt++, dtData,        95,  daLeft,    true,  prefix+"bl_no",        false, "", dfNone,        0, false, false);
                  InitDataProperty(0, cnt++, dtData,        100,  daLeft,    true,  prefix+"shpr_nm",      false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        150, daLeft,    true,  prefix+"shpr_addr",     false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        100,  daLeft,    true,  prefix+"cnee_nm",        false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        150,  daCenter,  true,  prefix+"cnee_addr",          false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        100,  daCenter,  true,  prefix+"ntfy_nm",       false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        150,  daCenter,  true,  prefix+"ntfy_addr",       false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        150,  daCenter,  true,  prefix+"ex_cust_nm",       false, "", dfNone,        0, true, true, 35);
                  InitDataProperty(0, cnt++, dtData,        100,  daCenter,    true,  prefix+"pol_cd",       false, "", dfNone,        0, false,  false );
                  InitDataProperty(0, cnt++, dtData,       100,  daCenter,  true, prefix+"por_cd",      false, "", dfNone,        0, false,  false );
                  InitDataProperty(0, cnt++, dtData,        100,  daCenter,    true,  prefix+"pod_cd",          false, "", dfNone,        0, false,  false );
                  InitDataProperty(0, cnt++, dtData,       100,  daCenter,  true, prefix+"del_cd",      false, "", dfNone,        0, false,  false );
                  
                
                  

					ShowButtonImage	= 1;


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
		//axon_event.addListenerForm('beforedeactivate', 'bkg0218_obj_deactivate', formObject); //- 포커스 나갈때
		//axon_event.addListenerFormat('beforeactivate',   'bkg0218_activate', formObject); //- 포커스 들어갈때
		//axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}

 	function ufRetrieveByEnterKey() {
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

		    	if ("t1sheet1"==sheetObject.id) {
			    	ComClearObject(formObject.elements["t1_txt_vvd"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pol"            ]);
			    	ComClearObject(formObject.elements["t1_txt_pod"            ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_sls_ofc_cd"  ]);
			    	ComClearObject(formObject.elements["t1_txt_ob_srep_cd"     ]);
			    	ComClearObject(formObject.elements["t1_txt_bkg_no"         ]);
			    	ComClearObject(formObject.elements["t1_txt_bl_no"          ]);
			    	ComClearObject(formObject.elements["t1_rdo_date_flg"       ]);
			    	ComClearObject(formObject.elements["t1_txt_date_from"      ]);
			    	ComClearObject(formObject.elements["t1_txt_date_to"        ]);

			    } 
				sheetObject.RemoveAll();
				break;

            case IBSEARCH:      //조회
			    if ("t1sheet1"==sheetObject.id) {
			    	var vvd = ComGetObjValue(formObject.elements["t1_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value = SEARCH;
			    	formObject.elements["vsl_cd"         ].value = vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value = vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value = vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value = ComGetObjValue(formObject.elements["t1_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value = ComGetObjValue(formObject.elements["t1_txt_pod"]);
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

        		} 
             	var sXml = sheetObject.GetSearchXml("ESM_BKG_1164GS.do", FormQueryString(formObject)+"&"+ComGetPrefixParam(sheetObject.id));
            	sheetObjects[0].LoadSearchXml(sXml);

                break;

    		case IBDOWNEXCEL:
    			if (0<sheetObject.RowCount) {
    				sheetObject.SpeedDown2Excel(1);
    			} else {
    				ComShowCodeMessage("BKG00155");
    			}
    			break;
    			
    		case MULTI:		// Save

    	
    		formObject.f_cmd.value = MULTI;
			//ComOpenWait(true);
			var sParam = FormQueryString(formObject);
			var sParamSheet = sheetObjects[0].GetSaveString(false, true, "t1sheet1slct_flg"	);
			
            sParam = sParam + "&" +ComSetPrifix(sParamSheet,"");
            
            var sXml = sheetObject.GetSaveXml("ESM_BKG_1164GS.do", sParam);
            sheetObjects[0].LoadSaveXml(sXml);
            ComOpenWait(false);
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
    			    	var pod = formObject.elements["t1_txt_pod"];
    			    	var dt1 = formObject.elements["t1_txt_date_from"];
    			    	var dt2 = formObject.elements["t1_txt_date_to"];
    			    	var bkg = formObject.elements["t1_txt_bkg_no"];
    			    	var bl  = formObject.elements["t1_txt_bl_no"];
    			    	if ((!ComIsEmpty(vvd) && !ComIsEmpty(pol)) || (!ComIsEmpty(vvd) && !ComIsEmpty(pod)) ||
//    			    		(!ComIsEmpty(dt1) && !ComIsEmpty(dt2) && !ComIsEmpty(pol)) ||
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
    			    			+"＊ VVD and POD  OR\n"
    			    			+"＊ Booking No.  OR\n"
    			    			+"＊ B/L No.");
        			    	requiredFlag = false;
    			    	}
    				} 
    				if(!requiredFlag || !ComChkValid(formObject)) return false;
    				break;
    				
    			case "btn_edit_cust_info":

					if (0==sheetObject.CheckedRows(sheetObject.id+"slct_flg")) {
    					ComShowCodeMessage("BKG00155");
    					return false;
    				}
    				if (sheetObject.CheckedRows(sheetObject.id+"slct_flg") > 1) {
    	        			ComShowCodeMessage("BKG04019");//"Please Select One Row in the list";
    	        			return false;
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

	


    function t1sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with (sheetObject) {
            ColFontUnderline(sheetObject.id+"bkg_no") = true;
            ColFontColor(sheetObject.id+"bkg_no") = RgbColor(0,0,255);

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


    function window.getParameter(p) {
	  if (p) r=location.search.match(new RegExp("[&?]"+p+"=(.*?)(&|$)"));
	  return r&&r[1]?r[1]:null;
	}

    //edit customer info pop up 호출
    function getEdit_Cust_Info_POPUP(rowArray) {
    	
    	//if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
	    	var shNm = rowArray[0][0];
	        var shAddr = rowArray[0][1];
	        var cnNm = rowArray[0][2];
	        var cnAddr = rowArray[0][3];
	        var nfNm = rowArray[0][4];
	        var nfAddr = rowArray[0][5];
	        var exNm = rowArray[0][6];
	    	var sheetObject = sheetObjects[beforetab];
	    	var prefix = sheetObject.id;
			var arrRow = ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);

 					sheetObject.CellValue2(arrRow,prefix+"shpr_nm") = shNm;
 					sheetObject.CellValue2(arrRow,prefix+"shpr_addr") = shAddr;
 					sheetObject.CellValue2(arrRow,prefix+"cnee_nm") = cnNm;
 					sheetObject.CellValue2(arrRow,prefix+"cnee_addr") = cnAddr;
 					sheetObject.CellValue2(arrRow,prefix+"ntfy_nm") = nfNm;
 					sheetObject.CellValue2(arrRow,prefix+"ntfy_addr") = nfAddr;
 					sheetObject.CellValue2(arrRow,prefix+"ex_cust_nm") = exNm;

    }


 
    /* 개발자 작업  끝 */
