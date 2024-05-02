/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1164.js
*@FileTitle  : Feeder BL Print(Russia)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
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
   	/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var rdObjects=new Array();
var rdCnt=0;
var rdParam;
var rdPath;
var rdPdf;
var clickSheetObj;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        var rdObject=rdObjects[0];
    	try {
    		var srcName=ComGetEvent("name");
    		 if(ComGetBtnDisable(srcName)) return false;
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
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
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
		    			var param=bkgNos="";
		    			var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
		    			if (arrRow && 0 < arrRow.length) {
		    				for ( var i=0; i < arrRow.length; i++) {
		    					bkgNos += sheetObject1.GetCellValue(arrRow[i], sheetObject1.id
		    							+ "bkg_no")
		    							+ ",";
		    				}
		    				if (0 < bkgNos.indexOf(","))
		    					bkgNos=bkgNos.substring(0, bkgNos.length - 1);
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
		    			var formObject2=document.form2;
		    			var width=925;
		    			var height=370;
		    			var left=(screen.width-width)/2;
		    			var top=(screen.height-height)/2;
		    			ComOpenWindow("", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		    			formObject2.bkg_no.value=bkgNos;
		    			formObject2.param_ui_id.value="ESM_BKG_1164";
		    			formObject2.action="/hanjin/ESM_BKG_0743_01.do";
		    			formObject2.target="PopupEsmBkg074301";
		    			formObject2.submit();
		    			break;
		    		case "btn_PDFPrint":
		    			var param=bkgNos="";
		    			var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
		    			if (arrRow && 0 < arrRow.length) {
		    				for ( var i=0; i < arrRow.length; i++) {
		    					bkgNos += sheetObject1.GetCellValue(arrRow[i], sheetObject1.id+"bkg_no") + ",";
		    				}
		    				if (0 < bkgNos.indexOf(","))
		    					bkgNos=bkgNos.substring(0, bkgNos.length - 1);
		    				if (1000 < bkgNos.split(",").length) {
		    					ComShowCodeMessage("BKG08124", 500); // You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
		    					return;
		    				}
		    			} else {
		    				ComShowCodeMessage("COM12176");
		    				return false;
		    			}
		    			var formObject2=document.form2;
		    			var width=925;
		    			var height=670;
		    			var left=(screen.width-width)/2;
		    			var top=(screen.height-height)/2;
		    			ComOpenWindow("", "PopupEsmBkg1151", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		    			formObject2.bkg_no.value=bkgNos;
		    			formObject2.param_ui_id.value="ESM_BKG_1164";
		    			formObject2.action="/hanjin/ESM_BKG_1151.do";
		    			formObject2.target="PopupEsmBkg1151";
		    			formObject2.submit();
		    			break;
					case "btn_edit_cust_info":
	    				if(!validateForm(sheetObject1,formObject,"btn_edit_cust_info")) return false;
			        	//open popup 0221
	    				//clickRow = Row;
			        	var width=500;
						var height=600;
						var left=(screen.width-width)/2;
						var top=(screen.height-height)/2;
						ComOpenWindow("about:blank","ESM_BKG_1165","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
						//send popup
						var formObject3=document.form3;
						var arrRow=ComFindText(sheetObject1, sheetObject1.id+"slct_flg", 1);
						formObject3.elements["pop_mode"   ].value="1";
						formObject3.elements["display"    ].value="1,0,1,1,1,1,1";
						formObject3.elements["func"       ].value="getEdit_Cust_Info_POPUP";
						formObject3.elements["row"        ].value="0";
						formObject3.elements["col"        ].value="0";
						formObject3.elements["sheetIdx"   ].value="0";
						formObject3.elements["bkg_no"     ].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"bkg_no");
						formObject3.elements["bl_no"     ].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"bl_no");
						formObject3.elements["sh_cust_nm"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"shpr_nm");
						formObject3.elements["sh_cust_addr"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"shpr_addr");
						formObject3.elements["cn_cust_nm"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"cnee_nm");
						formObject3.elements["cn_cust_addr"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"cnee_addr");
						formObject3.elements["nf_cust_nm"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"ntfy_nm");
						formObject3.elements["nf_cust_addr"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"ntfy_addr");
						formObject3.elements["ex_cust_nm"].value=sheetObject1.GetCellValue(arrRow[0],sheetObject1.id+"ex_cust_nm");
						formObject3.action="/hanjin/ESM_BKG_1165.do";
						formObject3.target="ESM_BKG_1165";
						formObject3.submit();
	                    break;
        		}
    		}
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        	beforetab=0;
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObject,sheetNo) {
        var cnt=0;
		var prefix="";
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObject){
                prefix=sheetObject.id;
              
                  var HeadTitle="|Sel.|Sel.|Booking No.|S|B/L No.|Shipper Name|Shipper Address|CNEE Name|CNEE Address|Notify Name|Notify Address|Export Ref.\nNumber|POL|POR|POD|DEL";
	              var HeadTitle1="|Sel.|Sel.|Booking No.|S|B/L No.|Shipper Name|Shipper Address|CNEE Name|CNEE Address|Notify Name|Notify Address|Export Ref.\nNumber|POL|POR|POD|DEL";
	              SetMergeCell(0,1,2,2);
	
	              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"},
	                          { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",     Wrap:1 },
	                     {Type:"CheckBox",  Hidden:0, Width:18,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slct_flg",   Wrap:1 },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",        Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shpr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shpr_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cnee_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cnee_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntfy_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntfy_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ex_cust_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,    Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetShowButtonImage(1);
	              SetSheetHeight(485);									
              }

            break;
        }
    }
 	function initControl() {
		var formObject=document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        //axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        //axon_event.addListenerForm('beforedeactivate', 'bkg0218_obj_deactivate', formObject); //- 포커스 나갈때
		//axon_event.addListenerFormat('beforeactivate',   'bkg0218_activate', formObject); //- 포커스 들어갈때
		//axon_event.addListenerForm('blur', 'form1_blur', formObject);
	}

 	// 	function ufRetrieveByEnterKey() {
//        if (13!=event.keyCode) return;
//        document.getElementById("btn_retrieve").fireEvent("onclick");
// 	}
 	
 	//Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObject,formObject,sAction) {
    	sheetObject.ShowDebugMsg(false);
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
			    	var vvd=ComGetObjValue(formObject.elements["t1_txt_vvd"]);
			    	formObject.elements["f_cmd"          ].value=SEARCH;
			    	formObject.elements["vsl_cd"         ].value=vvd.substring(0,4);
			    	formObject.elements["skd_voy_no"     ].value=vvd.substring(4,8);
			    	formObject.elements["skd_dir_cd"     ].value=vvd.substring(8,9);
			    	formObject.elements["pol_cd"         ].value=ComGetObjValue(formObject.elements["t1_txt_pol"]);
			    	formObject.elements["pod_cd"         ].value=ComGetObjValue(formObject.elements["t1_txt_pod"]);
					formObject.elements["ob_sls_ofc_cd"  ].value=ComGetObjValue(formObject.elements["t1_txt_ob_sls_ofc_cd"]);
					formObject.elements["ob_srep_cd"     ].value=ComGetObjValue(formObject.elements["t1_txt_ob_srep_cd"]);
					formObject.elements["bkg_no"         ].value=ComGetObjValue(formObject.elements["t1_txt_bkg_no"]);
					formObject.elements["bl_no"          ].value=ComGetObjValue(formObject.elements["t1_txt_bl_no"]);
  					if ("OnBoard"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value=ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["bl_obrd_dt_to"  ].value=ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["bl_obrd_dt_from"],"","-");
						ComClearSeparator(formObject.elements["bl_obrd_dt_to"],"","-");
						formObject.elements["obl_iss_dt_from"].value="";
						formObject.elements["obl_iss_dt_to"  ].value="";
  					} else if ("Issue"==ComGetObjValue(formObject.elements["t1_rdo_date_flg"])) {
						formObject.elements["bl_obrd_dt_from"].value="";
						formObject.elements["bl_obrd_dt_to"  ].value="";
						formObject.elements["obl_iss_dt_from"].value=ComGetObjValue(formObject.elements["t1_txt_date_from"]);
						formObject.elements["obl_iss_dt_to"  ].value=ComGetObjValue(formObject.elements["t1_txt_date_to"]);
						ComClearSeparator(formObject.elements["obl_iss_dt_from"],"","-");
						ComClearSeparator(formObject.elements["obl_iss_dt_to"],"","-");
  					}
        		} 
              	var sXml=sheetObject.GetSearchData("ESM_BKG_1164GS.do", FormQueryString(formObject)+"&"+ComGetPrefixParam(sheetObject.id));
            	sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                break;
    		case IBDOWNEXCEL:
    			if (0<sheetObject.RowCount()) {
     				sheetObject.Down2Excel({ HiddenColumn:1});
    			} else {
    				ComShowCodeMessage("BKG00155");
    			}
    			break;
    		case MULTI:		// Save
    		formObject.f_cmd.value=MULTI;
			//ComOpenWait(true);
			var sParam=FormQueryString(formObject);
			var sParamSheet=sheetObjects[0].GetSaveString(false, true, "t1sheet1slct_flg"	);
            sParam=sParam + "&" +ComSetPrifix(sParamSheet,"");
             var sXml=sheetObject.GetSaveData("ESM_BKG_1164GS.do", sParam);
             sheetObjects[0].LoadSaveData(sXml);
            ComOpenWait(false);
            break;
        }
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObject,formObject,sAction) {
        with (formObject) {
            switch(sAction) {
    			case IBSEARCH:
    				//조건적 필수 입력
    				var requiredFlag=false;
    				if (0==beforetab) {
    					var vvd=formObject.elements["t1_txt_vvd"];
    			    	var pol=formObject.elements["t1_txt_pol"];
    			    	var pod=formObject.elements["t1_txt_pod"];
    			    	var dt1=formObject.elements["t1_txt_date_from"];
    			    	var dt2=formObject.elements["t1_txt_date_to"];
    			    	var bkg=formObject.elements["t1_txt_bkg_no"];
    			    	var bl=formObject.elements["t1_txt_bl_no"];
    			    	if ((!ComIsEmpty(vvd) && !ComIsEmpty(pol)) || (!ComIsEmpty(vvd) && !ComIsEmpty(pod)) ||
//    			    		(!ComIsEmpty(dt1) && !ComIsEmpty(dt2) && !ComIsEmpty(pol)) ||
    			    		!ComIsEmpty(bkg) || !ComIsEmpty(bl)) {
    			    		requiredFlag=true;
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
        			    	requiredFlag=false;
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
    				if (0==sheetObject.RowCount()) {
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
	    var Rdviewer=rdObject ;
		Rdviewer.AutoAdjust=true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetSheetHeight(0);
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
    function t1sheet1_OnSearchEnd(sheetObject, ErrMsg) {
        with (sheetObject) {
            SetColFontUnderline(sheetObject.id+"bkg_no",1);
            SetColFontColor(sheetObject.id+"bkg_no","#0000FF");
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
var bkg_no=sheetObject.GetCellValue(row, sheetObject.id+"bkg_no");
			if (""==bkg_no) {
				ComShowCodeMessage("BKG08017");  //BKG No. not exists
				return;
			}
			//freezing관련 수정
//			ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+bkg_no+"&mainPage=false", "ESM_BKG_0079", 1024, 768, false);
			comBkgCallPopBkgDetail(bkg_no);   
		}
	}
    function getParameter(p) {
	  if (p) r=location.search.match(new RegExp("[&?]"+p+"=(.*?)(&|$)"));
	  return r&&r[1]?r[1]:null;
	}
    //edit customer info pop up 호출
    function getEdit_Cust_Info_POPUP(rowArray) {
    	//if (rowArray && 0<rowArray.length && 5<rowArray[0].length) {
	    	var shNm=rowArray[0][0];
	        var shAddr=rowArray[0][1];
	        var cnNm=rowArray[0][2];
	        var cnAddr=rowArray[0][3];
	        var nfNm=rowArray[0][4];
	        var nfAddr=rowArray[0][5];
	        var exNm=rowArray[0][6];
	    	var sheetObject=sheetObjects[beforetab];
	    	var prefix=sheetObject.id;
			var arrRow=ComFindText(sheetObject, sheetObject.id+"slct_flg", 1);
 					sheetObject.SetCellValue(arrRow,prefix+"shpr_nm",shNm,0);
 					sheetObject.SetCellValue(arrRow,prefix+"shpr_addr",shAddr,0);
 					sheetObject.SetCellValue(arrRow,prefix+"cnee_nm",cnNm,0);
 					sheetObject.SetCellValue(arrRow,prefix+"cnee_addr",cnAddr,0);
 					sheetObject.SetCellValue(arrRow,prefix+"ntfy_nm",nfNm,0);
 					sheetObject.SetCellValue(arrRow,prefix+"ntfy_addr",nfAddr,0);
 					sheetObject.SetCellValue(arrRow,prefix+"ex_cust_nm",exNm,0);
    }
    /* 개발자 작업  끝 */
