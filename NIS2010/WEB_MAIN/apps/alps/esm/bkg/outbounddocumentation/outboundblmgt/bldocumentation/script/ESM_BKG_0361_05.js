/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_05.js
*@FileTitle : Export / Import Information (Indonesia)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.10 최도순
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2012.08.03 이재위 [CHM-201219301] Split 01-[M&D Export&Import Information] Israel VAT ID추가
* 2012.10.16 이재위 [CHM-201220434] [M&D Export/Import Information] Lebanon의 VAT ID추가
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
     * @class esm_bkg_0361_05 : esm_bkg_0361_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0361_05() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0; 
var sheetObjects = new Array();
var sheetCnt = 0;
var saveMsgFlg = true;
var isInquiry = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        /*******************************************************/
        var formObject = document.form;
        var formObject2 = document.form2;
 		var sheetObject1 = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

					case "btn_add":
		        		var row = sheetObject1.DataInsert(-1);
		        		sheetObject1.CellValue2(row, "ibflag"     ) = "I";
		        		sheetObject1.CellValue2(row, "bkg_no"     ) = formObject.elements["bkg_no"].value;
		        		sheetObject1.CellValue2(row, "io_bnd_cd"  ) = formObject.elements["io_bnd_cd"].value;
		        		sheetObject1.CellValue2(row, "xpt_imp_seq") = ""==sheetObject1.CellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObject1, "xpt_imp_seq")+1 : sheetObject1.CellValue(row, "xpt_imp_seq");
		        		sheetObject1.CellValue2(row, "cnt_cd"     ) = "ID";
                    break;

					case "btn_delete":
		            	ComRowDelete(sheetObject1, "sel", 1);
		            	sheetObject1.ReNumberSeq();
                    break;

					case "btn_save":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;

					case "btn_close":	
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==""){
								window.close();
							}
						} else {
							document.form4.tabclosechk.value="";
							saveMsgFlg = true;
						} 
                    break;

                    ////////////////////////////////////////////////////////////////

					case "btn_add2":
						sheetObject2.DataInsert(-1);
						sheetObject2.CellValue2(row, "ibflag") = "I";
						sheetObject2.CellValue2(row, "bkg_no"     ) = formObject2.elements["bkg_no"].value;
						sheetObject2.CellValue2(row, "io_bnd_cd"  ) = formObject2.elements["io_bnd_cd"].value;
						sheetObject2.CellValue2(row, "xpt_imp_seq") = ""==sheetObject2.CellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObject2, "xpt_imp_seq")+1 : sheetObject2.CellValue(row, "xpt_imp_seq");
						sheetObject2.CellValue2(row, "cnt_cd"     ) = "ID";
                    break;

					case "btn_delete2":
		            	ComRowDelete(sheetObject2, "sel", 1);
		            	sheetObject2.ReNumberSeq();
                    break;

					case "btn_save2":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
                    break;

					case "btn_close2":
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==""){
								window.close();
							}
						} else {
							document.form4.tabclosechk.value="";
							saveMsgFlg = true;
						} 
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
   		if (!opener) opener = window.dialogArguments;
   		isInquiry = opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);

   		if(document.form.popUpTpCd.value=="E"||document.form.popUpTpCd.value=="S" || isInquiry){
      		/*getButtonTable("btn_add").style.display ="none";
     		getButtonTable("btn_save").style.display ="none";
     		getButtonTable("btn_delete").style.display ="none";
      		getButtonTable("btn_add2").style.display ="none";
     		getButtonTable("btn_save2").style.display ="none";
     		getButtonTable("btn_delete2").style.display ="none";*/
    		ComBtnDisable("btn_add");
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_delete");
    		ComBtnDisable("btn_add2");
    		ComBtnDisable("btn_save2");
    		ComBtnDisable("btn_delete2");
     	}
    	if(document.form.popUpTpCd.value!="S"){ 
	    	if(document.form3.bkg_no.value == ""){ 
	    		ComShowCodeMessage("COM12114","Booking Number");   
	        	window.close();
	        	return;
	        }
    	}
    	for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
        initControl();

        if(document.form3.get_io_bnd_cd.value != 'I') {
        	beforetab = 0; 
        	tab1.SelectedIndex = 0; 
        	var ctxName = "/hanjin";
        	if (document.form4.savechk.value=="") {
	        	if (document.form3.bkg_no.value != ""&& document.form.go_cnt_cd.value=="") {
					if (document.form3.pol_cd.value.substring(0,2)=='KR') {
						sendForm("ESM_BKG_0361_02.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='BR') {
						sendForm("ESM_BKG_0361_03.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='IN') {
						sendForm("ESM_BKG_0361_04.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='ID') {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					} else if (document.form3.pol_cd.value.substring(0,2)=='CA') {
						sendForm("ESM_BKG_0361_06.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='MX') {
						sendForm("ESM_BKG_0361_07.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='CO') {
						sendForm("ESM_BKG_0361_08.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='EC') {
						sendForm("ESM_BKG_0361_09.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='PE') {
						sendForm("ESM_BKG_0361_10.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='TR') {
						sendForm("ESM_BKG_0361_11.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='IL') {
						sendForm("ESM_BKG_0361_12.do","O");
					} else if (document.form3.pol_cd.value.substring(0,2)=='LB') {
						sendForm("ESM_BKG_0361_13.do","O");
					} 
					else if (document.form3.pol_cd.value.substring(0,2)=='NG') {
						sendForm("ESM_BKG_0361_14.do","O");
					} 
					else if (document.form3.pol_cd.value.substring(0,2)=='TG') {
						sendForm("ESM_BKG_0361_15.do","O");
					}
					else {
						sendForm("ESM_BKG_0361_01.do","O");
					}
				} else {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
        	}
        } else {
        	beforetab = 1; 
        	tab1.SelectedIndex = 1; 
        	objs = document.all.item("tabLayer");
        	objs[1].style.display = "Inline";
        	objs[0].style.display = "none";        	
        	var ctxName = "/hanjin";
        	if (document.form4.savechk.value=="") {
	        	if (document.form3.bkg_no.value != ""&& document.form.go_cnt_cd.value=="") {
					if (document.form3.pod_cd.value.substring(0,2)=='BR') {
						sendForm("ESM_BKG_0361_03.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='IN') {
						sendForm("ESM_BKG_0361_04.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='ID') {
						doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
					} else if (document.form3.pod_cd.value.substring(0,2)=='MX') {
						sendForm("ESM_BKG_0361_07.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='CO') {
						sendForm("ESM_BKG_0361_08.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='EC') {
						sendForm("ESM_BKG_0361_09.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='PE') {
						sendForm("ESM_BKG_0361_10.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='TR') {
						sendForm("ESM_BKG_0361_11.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='IL') {
						sendForm("ESM_BKG_0361_12.do","I");
					} else if (document.form3.pod_cd.value.substring(0,2)=='LB') {
						sendForm("ESM_BKG_0361_13.do","I");
					} 
					else if (document.form3.pod_cd.value.substring(0,2)=='NG') {
						sendForm("ESM_BKG_0361_14.do","I");
					}
					else if (document.form3.pod_cd.value.substring(0,2)=='TG') {
						sendForm("ESM_BKG_0361_15.do","I");
					}
					else {
						sendForm("ESM_BKG_0361_03.do","I");
					}
				} else {
					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
				}
        	}
        }
	}

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt  = 0;
            InsertTab( cnt++ , "Export" , -1 );
            InsertTab( cnt++ , "Import" , -1 );
        }
    }
    
     function tab1_OnClick(tabObj, nItem){
    	 var objs = document.all.item("tabLayer");
    	 
    	if(tab1.SelectedIndex==0){  
    		if(document.form4.savechk.value=='N'&&objs[0].style.display == "none"){ 
    			tab1_OnChange(tabObj , nItem)
       	    }
  	 	}else if(tab1.SelectedIndex==1){   		
  	 		if(document.form4.savechk.value=='N'&&objs[1].style.display == "none"){
  	 			tab1_OnChange(tabObj , nItem)
       	    } 	 			
  	 	}  
   		
     }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
    	 
    	if (nItem==beforetab) return; 	
    	    	
    	var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";
     	
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
     	
     	beforetab= nItem;
     	
     	var ctxName = "/hanjin";
   		var formObj = document.form3;
           
   		switch(nItem) {

   			case 0:	
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value="";
	   				if(document.form4.savechk.value==""){
		   				if(formObj.bkg_no.value != ""&& document.form.go_cnt_cd.value==""){
		   					if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='ID'){
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CA'){
								sendForm("ESM_BKG_0361_06.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='CO'){
								sendForm("ESM_BKG_0361_08.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='EC'){
								sendForm("ESM_BKG_0361_09.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='PE'){
								sendForm("ESM_BKG_0361_10.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='TR'){
								sendForm("ESM_BKG_0361_11.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IL'){
		   						sendForm("ESM_BKG_0361_12.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='LB'){
		   						sendForm("ESM_BKG_0361_13.do","O");
		   					}
		   					else if (formObj.pol_cd.value.substring(0,2)=='NG'){
		   						sendForm("ESM_BKG_0361_14.do","O");
		   					}
		   					else if (formObj.pol_cd.value.substring(0,2)=='TG'){
		   						sendForm("ESM_BKG_0361_15.do","O");
		   					}
		   					else {
								sendForm("ESM_BKG_0361_01.do","O");
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		   				}
	   				}
				} else {
					document.form4.tabclosechk.value="";
					saveMsgFlg = true;
				} 
               break;

   			case 1:
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value="";
	   				if(document.form4.savechk.value==""){
		   				if(formObj.bkg_no.value != ""&& document.form.go_cnt_cd.value==""){
		   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
		   						doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
		   					}else if (formObj.pod_cd.value.substring(0,2)=='MX'){
								sendForm("ESM_BKG_0361_07.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='CO'){
								sendForm("ESM_BKG_0361_08.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='EC'){
								sendForm("ESM_BKG_0361_09.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='PE'){
								sendForm("ESM_BKG_0361_10.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='TR'){
								sendForm("ESM_BKG_0361_11.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IL'){
		   						sendForm("ESM_BKG_0361_12.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='LB'){
		   						sendForm("ESM_BKG_0361_13.do","I");
		   					}
		   					else if (formObj.pod_cd.value.substring(0,2)=='NG'){
		   						sendForm("ESM_BKG_0361_14.do","I");
		   					}
		   					else if (formObj.pod_cd.value.substring(0,2)=='TG'){
		   						sendForm("ESM_BKG_0361_15.do","I");
		   					}
		   					else {
								sendForm("ESM_BKG_0361_03.do","I");
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH);
		   				}
	   				}
				} else {
					document.form4.tabclosechk.value="";
					saveMsgFlg = true;
				} 
               break;   
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
 	 * 시트 초기설정값, 헤더 정의
 	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 	 */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt = 0;
		with (sheetObj) {
	 		switch(sheetNo) {
				case 1:  //sheet1
					style.height = 150;
					SheetWidth = mainTable1.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = true;
					InitRowInfo(1, 1, 5, 100);
					var HeadTitle = "|Sel.|Seq.|PEB No.|PEB Issue Date|Customs Office|Qualifier||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 0, 0, true);
					InitHeadMode(true, true, false, true, false, false);
					InitHeadRow(0, HeadTitle, true);
					InitDataProperty(0, cnt++, dtHiddenStatus,    0,   daLeft,   false, "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox,        30,  daCenter, false, "sel");
					InitDataProperty(0, cnt++, dtSeq,             40,  daCenter, false, "seq");
					InitDataProperty(0, cnt,   dtData,            60,  daCenter, false, "id_xpt_no",        false, "", dfNone,    0, true,  true, 6);
					InitDataValid   (0, cnt++, vtNumericOnly);
					InitDataProperty(0, cnt++, dtPopupEditFormat, 140, daCenter, false, "id_xpt_no_iss_dt", false, "", dfDateYmd, 0, true,  true, 8);
					InitDataProperty(0, cnt,   dtCombo,           140, daCenter, false, "id_ofc_cd",        false, "", dfNone,    0, true,  true);
					InitDataCombo   (0, cnt++, " |BANBA|JKTBA|SRGBA|SUBBA", " |010700|040300|060100|070100", "", "");
					InitDataProperty(0, cnt,   dtCombo,           140, daCenter, false, "id_decl_cd",       false, "", dfNone,    0, true,  true);
					InitDataCombo   (0, cnt++, " |PEB|PKB", " |E|K", "", "");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "bkg_no");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "io_bnd_cd");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "xpt_imp_seq");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "cnt_cd");
					PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
					break;
	 			case 2:  //sheet2
					style.height = 150;
					SheetWidth = mainTable2.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = true;
					InitRowInfo(1, 1, 5, 100);
					var HeadTitle = "|Chk.|Seq.|PEB No.|PEB Issue Date|Customs Office|Qualifier||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					InitColumnInfo(headCount, 0, 0, true);
					InitHeadMode(true, true, false, true, false, false);
					InitHeadRow(0, HeadTitle, true);
					InitDataProperty(0, cnt++, dtHiddenStatus,    0,   daLeft,   false, "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox,        30,  daCenter, false, "sel");
					InitDataProperty(0, cnt++, dtSeq,             40,  daCenter, false, "seq");
					InitDataProperty(0, cnt,   dtData,            60,  daCenter, false, "id_xpt_no",        false, "", dfNone,    0, true,  true, 6);
					InitDataValid   (0, cnt++, vtNumericOnly);
					InitDataProperty(0, cnt++, dtPopupEditFormat, 140, daCenter, false, "id_xpt_no_iss_dt", false, "", dfDateYmd, 0, true,  true, 8);
					InitDataProperty(0, cnt,   dtCombo,           140, daCenter, false, "id_ofc_cd",        false, "", dfNone,    0, true,  true);
					InitDataCombo   (0, cnt++, " |BANBA|JKTBA|SRGBA|SUBBA", "|010700|040300|060100|070100", "", "");
					InitDataProperty(0, cnt,   dtCombo,           140, daCenter, false, "id_decl_cd",       false, "", dfNone,    0, true,  true);
					InitDataCombo   (0, cnt++, " |PEB|PKB", " |E|K", "", "");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "bkg_no");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "io_bnd_cd");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "xpt_imp_seq");
					InitDataProperty(0, cnt++, dtHidden,          0,   daLeft,   false, "cnt_cd");
					PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
	 				break;
 			}
 		}
 	}
 	
 	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.WaitImageVisible=false;
 		ComOpenWait(true);
 		//sheetObj.ShowDebugMsg = false;

 		switch(sAction) {

 			case IBSEARCH:  //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0361_05GS.do", FormQueryString(formObj));
				}
			break;

 			case IBSAVE:  //저장
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 		 			if (0<sheetObj.RowCount) {
 						for (var row=1; row<=sheetObj.RowCount; row++) {
		 					sheetObj.CellValue2(row, "bkg_no"     ) = formObj.elements["bkg_no"].value;
		 					sheetObj.CellValue2(row, "io_bnd_cd"  ) = formObj.elements["io_bnd_cd"].value;  //O
		 					sheetObj.CellValue2(row, "xpt_imp_seq") = ""==sheetObj.CellValue(row, "xpt_imp_seq") ? ComGetMaxValue(sheetObj, "xpt_imp_seq")+1 : sheetObj.CellValue(row, "xpt_imp_seq");
		 					sheetObj.CellValue2(row, "cnt_cd"     ) = "ID";
		 					sheetObj.CellValue2(row, "id_ofc_cd"  ) = ComTrim(sheetObj.CellValue(row, "id_ofc_cd"));
		 					sheetObj.CellValue2(row, "id_decl_cd" ) = ComTrim(sheetObj.CellValue(row, "id_decl_cd"));
		 					if ("I"==sheetObj.CellValue(row, "ibflag") &&
		 						""==sheetObj.CellValue(row, "id_xpt_no") &&
		 						""==sheetObj.CellValue(row, "id_xpt_no_iss_dt") &&
		 						""==sheetObj.CellValue(row, "id_ofc_cd") &&
		 						""==sheetObj.CellValue(row, "id_decl_cd")) {
		 						sheetObj.CellValue2(row, "ibflag"     ) = "D";
		 					}
 						}
 					}
 					formObj.f_cmd.value = MULTI;
 					if (document.form4.tabclosechk.value=="Y") {
 						if (sheetObj.isDataModified) {
 							saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_05GS.do", FormQueryString(formObj) ,"");
 						}
 					} else {
 						saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_05GS.do", FormQueryString(formObj) ,"");
 					}
 				}
 			break;
 		}
 		ComOpenWait(false);
 	}

 	function setTab(idx) {
    	beforetab=idx;
     	tab1.SelectedIndex = idx;
		objs = document.all.item("tabLayer");
		objs[0].style.display = 0==idx ? "inline" : "none";
		objs[1].style.display = 0==idx ? "none" : "inline"; 
		document.form4.savechk.value="N";
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
		if (sAction==IBSAVE) {
			if (formObj.name=="form" || formObj.name=="form2") {
	 			var dataSheet = sheetObjects[formObj.name=="form" ? 0 : 1];
		 		var pebNo;
		 		var pebDt;
		 		if (dataSheet.IsDataModified) {
					for (var row=1; row<=dataSheet.RowCount; row++) {
						if ("D"!=dataSheet.CellValue(row, "ibflag")) {
			 				if (formObj.name=="form") {
					 			pebNo = dataSheet.CellValue(row, "id_xpt_no");
					 			pebDt = dataSheet.CellValue(row, "id_xpt_no_iss_dt");
			 				} else {
					 			pebNo = dataSheet.CellValue(row, "id_xpt_no");
					 			pebDt = dataSheet.CellValue(row, "id_xpt_no_iss_dt");
			 				}
			 				if (""!=pebNo && 6 > pebNo.length) {
			 					setTab(formObj.name=="form" ? 0 : 1);
			    				ComShowMessage(ComGetMsg("COM12174","6"));  //{?msg1} must be at least {?msg2} characters long.
			    				dataSheet.SelectCell(row, 3);
				             	return false;
			 				}
			 				if (""!=pebDt && !ComIsDate(pebDt)) {
					 			setTab(formObj.name=="form" ? 0 : 1);
			    				ComShowMessage(ComGetMsg("COM12132"));  //Please enter a valid date format: YYYY-MM-DD
			    				dataSheet.SelectCell(row, 4);
				             	return false;
			 				}
						}
		 			}
				} else {
					return true;
				}
			}
		} 
		document.form4.savechk.value = "";
		return true;
        
    }
       
    function setOptionValue(comboObj, val) {
    	for(i=0;i<comboObj.length;i++) {
    		if(val == comboObj.options[i].value)  comboObj.options[i].selected = true;
    	}
    }
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	document.form3.get_io_bnd_cd.value="O";
    }
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	document.form3.get_io_bnd_cd.value="I";
    }
    

    function sheet1_OnSaveEnd(sheetObj,ErrMsg){
    	saveMsgFlg = ComIsNull(ErrMsg);
		if (saveMsgFlg) {
			ComShowCodeMessage("BKG00166");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("BKG00167");  //Data Save Action Failed!!
		}
    	if(document.form4.tabclosechk.value==""){
    		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }
    
    function sheet2_OnSaveEnd(sheetObj,ErrMsg){
    	saveMsgFlg = ComIsNull(ErrMsg);
		if (saveMsgFlg) {
			ComShowCodeMessage("BKG00166");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("BKG00167");  //Data Save Action Failed!!
		}
    	if(document.form4.tabclosechk.value==""){
    		doActionIBSheet(sheetObj, document.form2, IBSEARCH);
    	}
    }

    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	if ("id_xpt_no_iss_dt"==sheetObj.ColSaveName(Col)) {
    		new ComCalendarGrid().select(sheetObj, Row, Col, 'yyyy-MM-dd');
    	}
    }

    function sheet2_OnPopupClick(sheetObj, Row, Col) {
    	if ("id_xpt_no_iss_dt"==sheetObj.ColSaveName(Col)) {
    		new ComCalendarGrid().select(sheetObj, Row, Col, 'yyyy-MM-dd');
    	}
    }

    function initControl() {    	
    	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form2);
    }

    function goCtnCd(obj){
    	var ctxName = "/hanjin";
    	formObj = document.form;
    	formObj2 = document.form2;
    	formObj3 = document.form3;
    	if(obj.name=='exp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==""){
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","O","IN");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='CA'){
						sendForm("ESM_BKG_0361_06.do","O","CA");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","O","MX");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='CO'){
						sendForm("ESM_BKG_0361_08.do","O","CO");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='EC'){
						sendForm("ESM_BKG_0361_09.do","O","EC");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='PE'){
						sendForm("ESM_BKG_0361_10.do","O","PE");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='TR'){
						sendForm("ESM_BKG_0361_11.do","O","TR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='IL'){
						sendForm("ESM_BKG_0361_12.do","O","IL");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='LB'){
						sendForm("ESM_BKG_0361_13.do","O","LB");
					}
					else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='NG'){
						sendForm("ESM_BKG_0361_14.do","O","NG");
					}
					else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='TG'){
						sendForm("ESM_BKG_0361_15.do","O","TG");
					}
	    		}
			} else {
   				document.form4.tabclosechk.value="";
   				saveMsgFlg = true;
			}
    	}else if(obj.name=='imp_cnt_cd'){
    		document.form4.tabclosechk.value="Y";
    		doActionIBSheet(sheetObjects[1], formObj2, IBSAVE);
    		if (saveMsgFlg) {
	    		if(document.form4.savechk.value==""){
		    		if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='MX'){
						sendForm("ESM_BKG_0361_07.do","I","MX");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='CO'){
						sendForm("ESM_BKG_0361_08.do","I","CO");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='EC'){
						sendForm("ESM_BKG_0361_09.do","I","EC");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='PE'){
						sendForm("ESM_BKG_0361_10.do","I","PE");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='TR'){
						sendForm("ESM_BKG_0361_11.do","I","TR");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='IL'){
						sendForm("ESM_BKG_0361_12.do","I","IL");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='LB'){
						sendForm("ESM_BKG_0361_13.do","I","LB");
					}
					else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='NG'){
						sendForm("ESM_BKG_0361_14.do","I","NG");
					}
					else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='TG'){
						sendForm("ESM_BKG_0361_15.do","I","TG");
					}
	    		}
			} else {
   				document.form4.tabclosechk.value="";
   				saveMsgFlg = true;
			}
    	}
    }

    function makeSendForm(url) {
		var srcForm = document.form3;
   		var tgtForm = document.urlForm;
   		for (var i=0; i<tgtForm.elements.length; i++) {
   			tgtForm.elements[i].removeNode(true);
   		}
   		for (var i=0; i<srcForm.elements.length; i++) {
   			tgtForm.appendChild(srcForm.elements[i].cloneNode(true));
   		}
   		tgtForm.action = url;
    }
    function addFormElement(nm,vl) {
   		var tgtForm = document.urlForm;
   		var inp = document.createElement("input");
   		inp.type = "hidden";
   		inp.name = nm;
   		inp.value = vl;
   		tgtForm.appendChild(inp);
    }
    function sendForm(url,io,nn) {
   		makeSendForm("/hanjin/"+url);
   		addFormElement("io_bnd_cd",io);
   		if (nn) {
   			addFormElement("go_cnt_cd",nn);
   		}
    	document.urlForm.submit();
    }
