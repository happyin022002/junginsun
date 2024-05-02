/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_01.js
*@FileTitle : Export / Import Information (USA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.10 최도순
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.05.17 최도순 [CHM-201110713-01] 미주 T&E,IE화물구분표시 및 관련정보 조회기능 개발(*PKGSC로 미주업무 이행관련)
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
     * @class esm_bkg_0361_01 : esm_bkg_0361_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0361_01() {
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
var tabCnt = 0 ;
var beforetab = 0; 
var sheetObjects = new Array();
var sheetCnt = 0;
var saveMsgFlg = true; 
var isInquiry = false;
//var NDClear = "Y";

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

					case "btn_save":
						 document.form4.tabclosechk.value="";
						 doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break; 

					case "btn_close":	
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value=='' || document.form4.savechk.value == "N"){
								window.close();
							}
						} else {
							document.form4.tabclosechk.value="";
							saveMsgFlg = true;
						} 
                    break;
                    
					case "btn_delete":
						if (!ComShowCodeConfirm("COM12188")) return;
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    break; 
                    
					case "btn_save2":
						document.form4.tabclosechk.value="";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
                    break; 

					case "btn_close2":
						document.form4.tabclosechk.value="Y";
						doActionIBSheet(sheetObject2, formObject2, IBSAVE);
						if (saveMsgFlg) {
							if(document.form4.savechk.value==''){
								window.close();
							}
						} else {
							document.form4.tabclosechk.value="";
							saveMsgFlg = true;
						}
                    break;
                    
					case "btn_delete2":
						if (!ComShowCodeConfirm("COM12188")) return;
						doActionIBSheet(sheetObject2, formObject2, IBDELETE);
                    break; 
                    
					case "btn_vinNo":
						var bkg_no = formObject.exp_bkg_no.value;
						var vin_no_list = formObject.exp_vin_ctnt.value;
						var url = "ESM_BKG_0362.do?bkg_no=" +bkg_no+ "&vin_no_list=" + encodeURIComponent(vin_no_list) + "&ui_id=ESM_BKG_0361";
						//ComOpenWindow(url, "ESM_BKG_0697", "width=300,height=280", false);이거아님
						ComOpenWindowCenter(url, "ESM_BKG_0362", 300, 400, true)
						
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
   		if (!opener) opener = window.dialogArguments;
   		isInquiry = opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);

   		if(document.form.popUpTpCd.value=="E"||document.form.popUpTpCd.value=="S" || isInquiry){
    		/*getButtonTable("btn_save").style.display ="none";
    		getButtonTable("btn_delete").style.display ="none";
    		getButtonTable("btn_save2").style.display ="none";
    		getButtonTable("btn_delete2").style.display ="none";*/
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_delete");
    		ComBtnDisable("btn_save2");
    		ComBtnDisable("btn_delete2");
    	}
    	
    	if(document.form.popUpTpCd.value!="S"){
	        if(document.form3.bkg_no.value == ''){ 
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
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='KR'){
						sendForm("ESM_BKG_0361_02.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='CA'){
						sendForm("ESM_BKG_0361_06.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='CO'){
						sendForm("ESM_BKG_0361_08.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='EC'){
						sendForm("ESM_BKG_0361_09.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='PE'){
						sendForm("ESM_BKG_0361_10.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='TR'){
						sendForm("ESM_BKG_0361_11.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='IL'){
						sendForm("ESM_BKG_0361_12.do","O");
					}else if (document.form3.pol_cd.value.substring(0,2)=='LB'){
						sendForm("ESM_BKG_0361_13.do","O");
					}
					else if (document.form3.pol_cd.value.substring(0,2)=='NG'){
						sendForm("ESM_BKG_0361_14.do","O");
					}
					else if (document.form3.pol_cd.value.substring(0,2)=='TG'){
						sendForm("ESM_BKG_0361_15.do","O");
					}
					else {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
					}
				}else{
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
				}
        	}
        } else {
        	beforetab = 1; 
        	tab1.SelectedIndex = 1; 
        	objs = document.all.item("tabLayer");

        	objs[1].style.display = "Inline";
        	objs[0].style.display = "none";        	
        	
        	var ctxName = "/hanjin";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pod_cd.value.substring(0,2)=='BR'){
						sendForm("ESM_BKG_0361_03.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='IN'){
						sendForm("ESM_BKG_0361_04.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='ID'){
						sendForm("ESM_BKG_0361_05.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='MX'){
						sendForm("ESM_BKG_0361_07.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='CO'){
						sendForm("ESM_BKG_0361_08.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='EC'){
						sendForm("ESM_BKG_0361_09.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='PE'){
						sendForm("ESM_BKG_0361_10.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='TR'){
						sendForm("ESM_BKG_0361_11.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='IL'){
						sendForm("ESM_BKG_0361_12.do","I");
					}else if (document.form3.pod_cd.value.substring(0,2)=='LB'){
						sendForm("ESM_BKG_0361_13.do","I");
					}
					else if (document.form3.pod_cd.value.substring(0,2)=='NG'){
						sendForm("ESM_BKG_0361_14.do","I");
					}
					else if (document.form3.pod_cd.value.substring(0,2)=='TG'){
						sendForm("ESM_BKG_0361_15.do","I");
					}
					else {
						sendForm("ESM_BKG_0361_03.do","I");
					} 
				}else{
					sendForm("ESM_BKG_0361_03.do","I");
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
            var cnt  = 0 ;
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
     	
     	//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	
     	beforetab = nItem;
     	
     	var ctxName = "/hanjin";
   		var formObj = document.form3;
           
   		switch(nItem) {

   			case 0:	
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
//   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if( document.form4.savechk.value==''){
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   				 	if (formObj.pol_cd.value.substring(0,2)=='KR'){
								sendForm("ESM_BKG_0361_02.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","O");
		   					}else if (formObj.pol_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","O");
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
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
		   				}
	   				}
//   				} else {
//   	   				document.form4.tabclosechk.value="";
//   	   				saveMsgFlg = true;
//   				}
               break;

   			case 1:
   				document.form4.tabclosechk.value="Y";
   				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
//   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if( document.form4.savechk.value==''){
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   					if (formObj.pod_cd.value.substring(0,2)=='BR'){
								sendForm("ESM_BKG_0361_03.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='IN'){
								sendForm("ESM_BKG_0361_04.do","I");
		   					}else if (formObj.pod_cd.value.substring(0,2)=='ID'){
								sendForm("ESM_BKG_0361_05.do","I");
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
							sendForm("ESM_BKG_0361_03.do","I");
		   				}
	   				}
//   				} else {
//   	   				document.form4.tabclosechk.value="";
//   	   				saveMsgFlg = true;
//   				}
   				
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
 	
 		switch(sheetNo) {
 			case 1:      //sheet1 init
 				with (sheetObj) {
 					// 높이 설정
 					style.height = 0;
 	
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;
 	
 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 	
 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;
 	
 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 	
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 5, 100);
 	
 					var HeadTitle = "|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt|entr_clss_tp_cd|entr_clss_rmk|aes_tp_prn_flg|vin_ctnt|veh_cmdt_flg";
 					var headCount = ComCountHeadTitle(HeadTitle);
 	
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 	
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false, false);
 	
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 	
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0,	cnt++,	dtStatus,	20,		daCenter,	false,	"ibflag");
 					InitDataProperty(0,	cnt++,	dtSeq,		20,		daCenter,	false,	"seq");
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"bkg_no", 			true);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"io_bnd_cd",		true,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"xpt_imp_seq",		true,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"cnt_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_tp_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_inlnd_trns_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_ptu_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_ptu_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_dwn_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_dwn_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_expt_id",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_expt_ctnt",	false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"entr_clss_tp_cd",	false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"entr_clss_rmk",	false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_tp_prn_flg",	false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"vin_ctnt",			false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"veh_cmdt_flg",		false,	"",			dfNone,		0,			false,		false);
 					
 				}
 			break;
 			case 2:      //sheet1 init
 				with (sheetObj) {
 	
 					// 높이 설정
 					style.height = 0;
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;
 	
 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 	
 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;
 	
 				   //전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 	
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 3, 100);
 	 	
 					
 					var HeadTitle = "|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt";
 					
 					var headCount = ComCountHeadTitle(HeadTitle);
 				 	
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 					
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false, false)
 	
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 	
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0,	cnt++,	dtStatus,	20,		daCenter,	false,	"ibflag");
 					InitDataProperty(0,	cnt++,	dtSeq,		20,		daCenter,	false,	"seq");
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"bkg_no", 			true);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"io_bnd_cd",		true,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"xpt_imp_seq",		true,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"cnt_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_tp_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_inlnd_trns_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_pta_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_ptu_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_ptu_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_dwn_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_dwn_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_expt_id",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"aes_expt_ctnt",		false,	"",			dfNone,		0,			false,		false);
 					
 				}
 			break;
 		}
 	}
 	
  // Sheet관련 프로세스 처리
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.WaitImageVisible=false;
 		ComOpenWait(true);
 		//sheetObj.ShowDebugMsg = false;
 		switch(sAction) {
 	
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj, formObj, sAction)) {
 					 					
 					formObj.f_cmd.value = SEARCH;
 					//sheetObj.DoSearch("ESM_BKG_0361_01GS.do", FormQueryString(formObj));
 					var sXml = sheetObj.GetSearchXml("ESM_BKG_0361_01GS.do", FormQueryString(formObj));
 					var arrXml = sXml.split("|$$|");
 					if (arrXml[0].length > 0) {
 						sheetObj.LoadSearchXml(arrXml[0]);
 					}
 					if (arrXml[1].length > 0) {
 		                ComXml2ComboItem(arrXml[1], formObj.exp_aes_expt_id, "val", "name");
 		                ComXml2ComboItem(arrXml[1], formObj.imp_aes_expt_id, "val", "name");
 		               	if (1==sheetObj.RowCount) {
 		               		formObj.exp_aes_expt_id.Code = sheetObj.CellValue(1,"aes_expt_id");
 		               	}
 					}
 				}
 				break;
 	
 			case IBSAVE:        //저장

	 			if(document.form4.tabclosechk.value=="Y"){
	 				obj = document.getElementsByName("exp_aes_tp_cd");	
		 			for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	
				        	switch(obj[i].value) {
					        	case "AE": 
					        		if(formObj.exp_aes_inlnd_trns_no.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
			 						break;
					        	case "PA": 
					        		if(formObj.exp_aes_pta_no1.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
					        		break;
					        	case "PU": 
					        		if(formObj.exp_aes_ptu_no.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
					        	case "DN": 
					        		if(formObj.exp_aes_dwn_no.value==''){		
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
					        	case "EX": 
					        		if(formObj.exp_aes_expt_id.Code==''){	
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
				        	}
				        }
				    }
	 			}
 				

 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					
 					var obj= "";
 					if (sheetObj.RowCount==0){
 						initSheetData(sheetObj);
 					} 
 		
 					if(formObj.name=="form"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_");
 						obj = document.getElementsByName("exp_aes_tp_cd"); 		
 						obj2 = document.getElementsByName("exp_entr_clss_tp_cd"); 

 						for(var i=0; i<obj.length; i++){
 					        if(obj[i].checked==true){
 					        	sheetObj.CellValue(1,"aes_tp_cd")=obj[i].value;
 					        }
 					    }
 						
 						if( formObj.aes_tp_prn_flg.checked == true ){
 							sheetObj.CellValue2(1,"aes_tp_prn_flg") = "Y";
 						}else{
 							sheetObj.CellValue2(1,"aes_tp_prn_flg") = "N";
 						}
 						

 						

 						
 						var checkCnt = 0;
 						for(var j=0; j<obj2.length; j++){
 					        if(obj2[j].checked==true){
 					        	sheetObj.CellValue(1,"entr_clss_tp_cd")=obj2[j].value;
 					        	checkCnt ++;
 					        }
 					    }
 						
 						if(checkCnt==0){
 							sheetObj.CellValue(1,"entr_clss_tp_cd") = "";
 						}
 	
 						sheetObj.CellValue(1,"cnt_cd")="US";
 						sheetObj.CellValue(1,"aes_expt_id") = formObj.exp_aes_expt_id.Code;
 						sheetObj.CellValue(1,"aes_expt_ctnt") = formObj.exp_aes_expt_ctnt.innerText;
// 						sheetObj.CellValue(1,"vin_ctnt") = formObj.exp_vin_ctnt.value;
 					}else if(formObj.name=="form2"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 					
 						obj = document.getElementsByName("imp_aes_tp_cd");
 						sheetObj.CellValue(1,"cnt_cd")="US";
 						sheetObj.CellValue(1,"aes_expt_id") = formObj.imp_aes_expt_id.Code;
 					}
				    for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	sheetObj.CellValue(1,"aes_tp_cd")=obj[i].value;
				        }
				    }

				    if (sheetObj.CellValue(1,"aes_tp_cd")=='0' && sheetObj.CellValue(1,"aes_expt_ctnt") == ''){
				    	if(formObj.exp_old_vin_ctnt.value == sheetObj.CellValue(1,"vin_ctnt")){
				    		sheetObj.CellValue(1,0)='D';
				    	}
				    }
 					formObj.f_cmd.value = MULTI;
 					if(document.form4.tabclosechk.value=="Y"){
 						if(sheetObj.IsDataModified==true){
 							saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_01GS.do", FormQueryString(formObj) ,"");
 						}
 					}else{
 						saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_01GS.do", FormQueryString(formObj) ,"");

 					}
 				}
 			break;
 			
 			case IBDELETE:      // 입력
 				if(formObj.name=="form"){
	 				var obj = document.getElementsByName("exp_aes_tp_cd");
		    		for(var i=0; i<obj.length; i++){      
				        obj[i].checked = false
				    }
		    		for(var i=0; i<obj.length; i++){      
		    			radioBtnSet(obj[i]);
		    		}
		    		
		    		formObj.exp_entr_clss_tp_cd[0].checked =false;
		    		formObj.exp_entr_clss_tp_cd[1].checked =false;
		    		
		    		formObj.exp_entr_clss_rmk.value = '';
 				}else{
 					var obj2 = document.getElementsByName("imp_aes_tp_cd");
		    		for(var i=0; i<obj2.length; i++){      
		    			obj2[i].checked = false
				    }
		    		for(var i=0; i<obj2.length; i++){      
		    			radioBtnSet(obj2[i]);
		    		}
		    		
 				}
 				sheetObj.CellValue(1,0)='D';	
			break;	
 		}
 		ComOpenWait(false);
 	}
 	
 	function setTab1(){
    	beforetab=0;
     	tab1.SelectedIndex = 0;
		objs[0].style.display = "Inline";
		objs[1].style.display = "none"; 
		document.form4.savechk.value="N";
    }
    
    function setTab2(){
    	beforetab=1;
    	tab1.SelectedIndex = 1;
		objs[0].style.display = "none";
     	objs[1].style.display = "Inline"; 	
     	document.form4.savechk.value="N";
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 //if (!ComChkValid(formObj)) return false;
    	 with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
		
		if(sAction=='2'){	
	 		if(formObj.name=="form"){
	 			/*
	 			if(formObj.exp_entr_clss_tp_cd[0].checked||formObj.exp_entr_clss_tp_cd[1].checked){
	 				if(formObj.exp_entr_clss_rmk.value==''){
	 					ComAlertFocus(formObj.exp_entr_clss_rmk, ComGetMsg("BKG01163"));
	 					return false;
	 				}
	 			}
	 			*/
	 			if(formObj.exp_entr_clss_rmk.value!=''){
	 				if(formObj.exp_entr_clss_tp_cd[0].checked ==false && formObj.exp_entr_clss_tp_cd[1].checked == false){
	 					ComAlertFocus(formObj.exp_entr_clss_rmk, ComGetMsg("BKG08189"));
	 					return false;
	 				}
	 			}
	 			
		 		size = formObj.exp_aes_tp_cd.length;
		 		for(var i = 0; i < size; i++) {
				  if(formObj.exp_aes_tp_cd[i].checked) {
					objs = document.all.item("tabLayer");
					
					switch(formObj.exp_aes_tp_cd[i].value) {
				        case "AE":     
				        	 if(formObj.exp_aes_inlnd_trns_no.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_inlnd_trns_no, ComGetMsg("BKG08245", "AES (AES ITN)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if (!ComIsAesNo(formObj.exp_aes_inlnd_trns_no.value)){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));				        		 
				        		 return false;
				        		 break;
				        	 }else{
				        		 var re      = new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
				        		 formObj.exp_aes_inlnd_trns_no.value  = formObj.exp_aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
				        	 }
				        	 break;
				        case "PA": 
				        	 if(formObj.exp_aes_pta_no1.value==''||formObj.exp_aes_pta_no1.value.length<9){
				        		 setTab1();
				             	 ComAlertFocus(formObj.exp_aes_pta_no1,  ComGetMsg("BKG08245", "PTA (Post Agent)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_pta_no2.value==''||formObj.exp_aes_pta_no2.value.length<9){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_no2,  ComGetMsg("BKG08245", "PTA (Post Agent)"));
				        		 return false; 
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_pta_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_dt,  ComGetMsg("BKG08245", "PTA (Post Agent)"));
				        		 return false;
				        		 break;
				        	 }	
				        	 
			        	 	sVal = ComTrimAll(formObj.exp_aes_pta_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.exp_aes_pta_dt.value)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_pta_dt,  ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.exp_aes_pta_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		                    
		                    break;
				        case "PU":
				        	 if(formObj.exp_aes_ptu_no.value==''||formObj.exp_aes_ptu_no.value.length<9){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_ptu_no,  ComGetMsg("BKG08245", "PTU (Post USPPI)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.exp_aes_ptu_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_ptu_dt,  ComGetMsg("BKG08245", "PTU (Post USPPI)"));
				        		 return false;
				        		 break;
				        	 }
				        	 
				        	 sVal = ComTrimAll(formObj.exp_aes_ptu_dt.value, "-", "/", ".");
			                    if (!ComIsDateMod(formObj.exp_aes_ptu_dt.value)){
			                    	setTab1();
					        		 ComAlertFocus(formObj.exp_aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
					        		 return false;
					        		 break;
			                    }else{
			                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
			                    	formObj.exp_aes_ptu_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
			                    }		
				        	 break;
				        case "DN":				        	 
				        	if(formObj.exp_aes_dwn_no.value==''||formObj.exp_aes_dwn_no.value.length<9){
				        		setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_no,  ComGetMsg("BKG08245", "Down (AES Down)"));
				        		 return false;
				        		 break;
				        	 }
				        	if(formObj.exp_aes_dwn_dt.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_dt,  ComGetMsg("BKG08245", "Down (AES Down)"));
				        		 return false;
				        		 break;
				        	 }
				        	
				        	sVal = ComTrimAll(formObj.exp_aes_dwn_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.exp_aes_dwn_dt.value)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.exp_aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.exp_aes_dwn_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	break;
				        case "EX":
				        	if(formObj.exp_aes_expt_id.Code=='' && formObj.exp_aes_expt_ctnt.value ==''){
				        		setTab1();
				        		 ComAlertFocus(formObj.exp_aes_expt_id,  ComGetMsg("BKG08245", "Exception"));
				        		 return false;
				        		 break;
				        	}
				        	break;
					 }
				  }
				}
	 		}else if(formObj.name=="form2"){
	 			size2 = formObj.imp_aes_tp_cd.length;	
				for(var j = 0; j < size2; j++) {
				  if(formObj.imp_aes_tp_cd[j].checked) {
					objs = document.all.item("tabLayer");
						
					if (formObj.imp_aes_tp_cd[j].value=="EX"&&formObj.imp_aes_expt_id.Code!=""&&formObj.imp_aes_expt_ctnt.value!=""){					
						setTab2();
						ComAlertFocus(formObj.imp_aes_expt_id, ComGetMsg("BKG00198"));		        		 
						return false;
						break;
					}
					
					switch(formObj.imp_aes_tp_cd[j].value) {
				        case "AE":
				        	 if(formObj.imp_aes_inlnd_trns_no.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_inlnd_trns_no, ComGetMsg("BKG08245", "AES (AES ITN)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if (!ComIsAesNo(formObj.imp_aes_inlnd_trns_no.value)){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));				        		 
				        		 return false;
				        		 break;
				        	 }else{
				        		 var re      = new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
				        		 formObj.imp_aes_inlnd_trns_no.value  = formObj.imp_aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
				        	 }
				        	 break;
				        case "PA": 
				        	 if(formObj.imp_aes_pta_no1.value==''||formObj.imp_aes_pta_no1.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_no1,  ComGetMsg("BKG08245", "PTA (Post Agent)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_pta_no2.value==''||formObj.imp_aes_pta_no2.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_no2,  ComGetMsg("BKG08245", "PTA (Post Agent)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_pta_dt.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_dt,  ComGetMsg("BKG08245", "PTA OPost Agent)"));
				        		 return false;
				        		 break;
				        	 }
				        	 
				        	 sVal = ComTrimAll(formObj.imp_aes_pta_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_pta_dt.value)){
		                    	 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_pta_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_pta_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	 break;
				        case "PU":
				        	 if(formObj.imp_aes_ptu_no.value==''||formObj.imp_aes_ptu_no.value.length<9){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_no,  ComGetMsg("BKG08245", "PTU (Post USPPI)"));
				        		 return false;
				        		 break;
				        	 }
				        	 if(formObj.imp_aes_ptu_dt.value==''){
				        		 setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_dt,  ComGetMsg("BKG08245", "PTU (Post USPPI)"));
				        		 return false;
				        		 break;
				        	 }
				        	 
				        	 sVal = ComTrimAll(formObj.imp_aes_ptu_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_ptu_dt.value)){
		                    	setTab2();
				        		 ComAlertFocus(formObj.imp_aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_ptu_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	 break;
				        case "DN":				        	 
				        	if(formObj.imp_aes_dwn_no.value==''||formObj.imp_aes_dwn_no.value.length<9){
				        		setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_no,  ComGetMsg("BKG08245", "Down (AES Down)"));
				        		 return false;
				        		 break;
				        	 }
				        	if(formObj.imp_aes_dwn_dt.value==''){
				        		setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_dt,  ComGetMsg("BKG08245", "Down (AES Down)"));
				        		 return false;
				        		 break;
				        	 }
				        	
				        	 sVal = ComTrimAll(formObj.imp_aes_dwn_dt.value, "-", "/", ".");
		                    if (!ComIsDateMod(formObj.imp_aes_dwn_dt.value)){
		                    	setTab2();
				        		 ComAlertFocus(formObj.imp_aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                    	formObj.imp_aes_dwn_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                    }		
				        	break;
				        case "EX":
				        	if(formObj.exp_aes_expt_id.Code==''){
				        		setTab2();
				        		 ComAlertFocus(formObj.imp_aes_expt_id,  ComGetMsg("BKG08245", "Exception"));
				        		 return false;
				        		 break;
				        	}
				        	break;
					 }
				  }
				}	 			
	 		}	 		
		} 
		return true;
        
    }
       
    function setOptionValue(comboObj, val) {
    	for(i=0;i<comboObj.length;i++) {
    		if(val == comboObj.options[i].value)  comboObj.options[i].selected = true;
    	}
    }
    
 // 시트 데이터 초기화
    function initSheetData(sheetObj) {
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    }
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	formObj = document.form;
    	var obj = document.getElementsByName("exp_aes_tp_cd");
    	var obj2 = document.getElementsByName("exp_entr_clss_tp_cd");

    	if (sheetObj.RowCount>0){
    		IBS_CopyRowToForm(sheetObj,formObj, 1, "exp_"); 
    		
    		for(var i=0; i<obj.length; i++){
 		        if(obj[i].value==sheetObj.CellValue(1,"aes_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
 		    }
    		
    		if( sheetObj.CellValue(1,"aes_tp_prn_flg") == "Y" ){
    			formObj.aes_tp_prn_flg.checked = true;
    		}
    		
    		if( ComTrim(sheetObj.CellValue(1,"vin_ctnt")) == "" ){
    			formObj.vin_exist_flg.checked = false;
    		}else{
    			formObj.vin_exist_flg.checked = true;
    			formObj.exp_old_vin_ctnt.checked = sheetObj.CellValue(1,"vin_ctnt");
    		}
    		
    		for(var j=0; j<obj2.length; j++){
 		        if(obj2[j].value==sheetObj.CellValue(1,"entr_clss_tp_cd")){
 		        	obj2[j].checked=true;
 		        }else{
 		        	obj2[j].checked=false;
 		        }
 		    }
    	}else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
            
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.CellValue(1,"aes_tp_cd")=obj[i].value;
		        }

		    }
    	}
		for(var i=0; i<obj.length; i++){
			radioBtnSet(obj[i]);
		}
    	
    	document.form3.get_io_bnd_cd.value="O";
    }

    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj = document.form2;
    	var obj = document.getElementsByName("imp_aes_tp_cd");
	    
    	if (sheetObj.RowCount>0){
    		IBS_CopyRowToForm(sheetObj, formObj, 1, "imp_"); 
    		
    		for(var i=0; i<obj.length; i++){
 		        if(obj[i].value==sheetObj.CellValue(1,"aes_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }
 		    }
    	}else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
            
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.CellValue(1,"aes_tp_cd")=obj[i].value;
		        }
		    }
    	}
		for(var i=0; i<obj.length; i++){
			radioBtnSet(obj[i]);
		}
    	
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


    
    function initControl() {    	
    	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form2);
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    document.form);
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    document.form2);
    }
    
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "int":    	        
    	        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparatorMod(event.srcElement);
    }


    function ComClearSeparatorMod(obj,sFormat,sDelim)
    {
        try{
            if (typeof(obj) != "object" ) return;

            //sFormat인자값이 없는 경우 태그의 dataformat 속성값을 가져온다.
            sFormat = getDataFormat(obj, sFormat);
           
            obj.value = ComTrimAll(obj.value,"-");            
            if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus = new Function("this.select()");
          
			//event.returnValue=true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ComChkObjValidMod(obj, bMsg, bTrim, bMasked){

        try {
            var sTitle  = "";
            var sMsg    = "";
            //다음 배열은 순서가 중요함
            var props   = new Array("dataformat", "maxLength", "minlength");

            if (bMsg==undefined || bMsg==null)            bMsg = true;
            if (bTrim==undefined || bTrim==null)          bTrim = true;
            if (bMasked==undefined || bMasked==null)      bMasked = true;

            var sFormat     = "";
            var sVal        = "";
            var maskValue   = "";
            var iMaxLen=0, iMaxVal=null, iMinVal=null;

            sVal = ComGetObjValue(obj)            

            if(bTrim) sVal = ComTrim(sVal);
            maskValue = sVal;

            //체크할 속성 확인하기
            for(var j=0; j<props.length; j++){
	
                var attriVal = obj.getAttribute(props[j]);
                //ComDebug(props[j] + "=" + attriVal);
                 
                if (attriVal == null) continue;

                switch(props[j]) {
                    case "dataformat":  //포멧 확인
                        sFormat = attriVal;
		                //루프를 돌다가 "dataformat"을 지나게 되면 그때부터는 마스크구분자 없는 값으로 다른 Validation(길이,min,max 등)을 확인한다.
		                
                        if (sVal== "") continue;

                        //마스크값도 가져오지만 포멧Validation도 ComGetMaskedValue 함수에서 체크한다.
                        maskValue = ComGetMaskedValueMod(obj, sFormat);

                        if (sVal != maskValue && sFormat.indexOf("eng")>=0) obj.value = maskValue;
 
                        if (maskValue!= "") continue;
                        switch(sFormat) {
                            case "mdy":     //mm-dd-yyyy
                                sMsg = ComGetMsg("COM12187","MM-DD-YYYY");
                            break;  
                            
                            case "aesno":     //mm-dd-yyyy
                            	sMsg = ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN");
                            break; 
                        }
                        break;
                    case "maxLength":   //입력최대길이 확인
	                    if (sVal== "") continue;
	                    iMaxLen = attriVal;
	                    //ComDebug("iMaxLen=" + iMaxLen);
	                    if(ComGetLenByByte(sVal) > iMaxLen) sMsg = ComGetMsg('COM12142', sTitle, attriVal);
                    break;
	                    case "minlength":   //입력최소길이 확인
	                    if (sVal== "") continue;
	                    if(ComGetLenByByte(sVal) < attriVal) sMsg = ComGetMsg('COM12143', sTitle, attriVal);
                    break;
                }

                if (sMsg!="") {
                	if(event == null){
                		if (bMsg) ComShowMessage(sMsg);
 		                obj.focus(); 
		                obj.select(); 
                	}else{
                	//포커스 나갈수 있는 경우 : 이벤트를 통해서 함수가 호출되고, 값이 공백이거나 readonly인 경우
	                	var canFocusOut = (event.srcElement == obj && (sVal=="" || obj.getAttribute("readOnly")==true));
	                	
                		if (bMsg && !canFocusOut) ComShowMessage(sMsg);
                		
	                    //컨트롤이 숨겨져 있을수도 있으므로 에러 감싼다.
	                    try{                     	
	                    	if(canFocusOut) {
	                    		event.returnValue = true;
	                    	} else {
	                			//값이 정확할때 까지 포커스가 나가지 않아야 하는 경우
		                    	event.cancelBubble = true;
		                    	event.returnValue = false;
		                    	obj.focus(); 
		                    	obj.select();		                    	
		                    }
	
	                    } catch(ee) {;}
	                }
                	return false;                	
                }
            }

            if (bMasked && sFormat != "") {
            	obj.value = ComGetMaskedValueMod(obj, sFormat);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
        
        return true;
    }
    
    function ComGetMaskedValueMod(obj, sFormat, sDelim) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = String(getArgValue(obj));

            if (ComIsEmpty(sVal)) return "";

            var sRegExp         = "";
            var sReplaceText    = "";
            var sResultVal      = "";

            var sDelim = "-";

            switch(sFormat) {
                case "mdy":     //mm-dd-yyyy
                    sVal = ComTrimAll(sVal, "-", "/", ".");
                    if (!ComIsDateMod(sVal)) break;
                    var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
                    sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
                    break;
                case "aesno":   
	                sVal = ComTrimAll(sVal, "-");
	                if (!ComIsAesNo(sVal)) break;
	                var re      = new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	                sResultVal  = sVal.replace(re,'$1').toUpperCase();
	                break;
                case "int":     //정수
                if (!ComIsNumber(sVal)) break;
	                sResultVal  = sVal;
	                break;
                default :
                    return "";
            }

            return sResultVal;
        } catch(err) { ComFuncErrMsg(err.message); }
    } 
    
    function ComIsDateMod(obj, sFlag) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            //날짜구분자로 사용될수 있는는 "/", "-", "."를 제거되고 비교한다.
            sVal = sVal.replace(/\/|\-|\./g,"");

            if (!ComIsNumber(sVal)) return false;
            if (sFlag==undefined || sFlag==null) sFlag = "mdy";

            var year, month, day, week;

           
                if (sVal.length != 8) return false;
                year  = sVal.substring(4,8);
                month = sVal.substring(0,2);
                day   = sVal.substring(2,4);
                if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)) return false;
            
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ComIsAesNo(obj, sFlag) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            //날짜구분자로 사용될수 있는는 "/", "-", "."를 제거되고 비교한다.
            sVal = sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 15) return false;
            
            if (!ComIsNumber(sVal.substring(1,15))) return false;
            if (!isAlpha(sVal.substring(0,1))) return false;      
            
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function isAlpha(str) {
        var pattern = /^[a-zA-Z]+$/;
        return (pattern.test(str)) ? true : false;
    }
    
    function radioBtnSet(obj){

    	var formObj = document.form;
    	var formObj2 = document.form2;

    	if(obj.name=='exp_aes_tp_cd'&& obj.checked==true){ 
    		var obj2 = document.getElementsByName("exp_aes_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked = false;
		        }
		    }
    		    
	    	switch(obj.value) {
		        case "AE":
		        	 formObj.exp_aes_inlnd_trns_no.focus();
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=false;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_id.Code='';
		             formObj.exp_aes_expt_id.Enable=false;
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
//		             formObj.aes_tp_prn_flg.disabled = false;
		             break;
		        case "PA": 
		        	 formObj.exp_aes_pta_no1.focus();
		             formObj.exp_aes_pta_no1.readOnly=false;
		             formObj.exp_aes_pta_no2.readOnly=false;
		             formObj.exp_aes_pta_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             formObj.exp_aes_expt_id.Code='';
		             formObj.exp_aes_expt_id.Enable=false;
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
//		             formObj.aes_tp_prn_flg.checked = false;
//		             formObj.aes_tp_prn_flg.disabled = true;
		             break;
		        case "PU":
		        	 formObj.exp_aes_ptu_no.focus();
		             formObj.exp_aes_ptu_no.readOnly=false;
		             formObj.exp_aes_ptu_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
		             formObj.exp_aes_expt_id.Code='';
		             formObj.exp_aes_expt_id.Enable=false;
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
//		             formObj.aes_tp_prn_flg.checked = false;
//		             formObj.aes_tp_prn_flg.disabled = true;
		             break;
		        case "DN":
		        	 formObj.exp_aes_dwn_no.focus();
		             formObj.exp_aes_dwn_no.readOnly=false;
		             formObj.exp_aes_dwn_dt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_expt_id.Code='';
		             formObj.exp_aes_expt_id.Enable=false;
		             formObj.exp_aes_expt_ctnt.value='';
		             formObj.exp_aes_expt_ctnt.readOnly=true;
//		             formObj.aes_tp_prn_flg.checked = false;
//		             formObj.aes_tp_prn_flg.disabled = true;
		             break;
		        case "EX":
		        	 formObj.exp_aes_expt_id.Enable=true;
		        	 //formObj.exp_aes_expt_id.focus();
		             formObj.exp_aes_expt_ctnt.readOnly=false;
		             formObj.exp_aes_inlnd_trns_no.value='';
		        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
		             formObj.exp_aes_pta_no1.value='';
		             formObj.exp_aes_pta_no1.readOnly=true;
		             formObj.exp_aes_pta_no2.value='';
		             formObj.exp_aes_pta_no2.readOnly=true;
		             formObj.exp_aes_pta_dt.value='';
		             formObj.exp_aes_pta_dt.readOnly=true;
		             formObj.exp_aes_ptu_no.value='';
		             formObj.exp_aes_ptu_no.readOnly=true;
		             formObj.exp_aes_ptu_dt.value='';
		             formObj.exp_aes_ptu_dt.readOnly=true;
		             formObj.exp_aes_dwn_no.value='';
		             formObj.exp_aes_dwn_no.readOnly=true;
		             formObj.exp_aes_dwn_dt.value='';
		             formObj.exp_aes_dwn_dt.readOnly=true;
//		             formObj.aes_tp_prn_flg.checked = false;
//		             formObj.aes_tp_prn_flg.disabled = true;
		             break;
	    	}
    	}else if(obj.name=='imp_aes_tp_cd'&& obj.checked==true){
    		var obj2 = document.getElementsByName("imp_aes_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked = false;
		        }
		    }
    		switch(obj.value) {
    		case "AE":  
	        	 formObj2.imp_aes_inlnd_trns_no.focus();
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=false;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             formObj2.imp_aes_expt_id.Code='';
	             formObj2.imp_aes_expt_id.Enable=false;
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "PA": 
	        	 formObj2.imp_aes_pta_no1.focus();
	             formObj2.imp_aes_pta_no1.readOnly=false;
	             formObj2.imp_aes_pta_no2.readOnly=false;
	             formObj2.imp_aes_pta_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             formObj2.imp_aes_expt_id.Code='';
	             formObj2.imp_aes_expt_id.Enable=false;
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "PU":
	        	 formObj2.imp_aes_ptu_no.focus();
	             formObj2.imp_aes_ptu_no.readOnly=false;
	             formObj2.imp_aes_ptu_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             formObj2.imp_aes_expt_id.Code='';
	             formObj2.imp_aes_expt_id.Enable=false;
	             formObj2.imp_aes_expt_ctnt.value='';	
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "DN":
	        	 formObj2.imp_aes_dwn_no.focus();
	             formObj2.imp_aes_dwn_no.readOnly=false;
	             formObj2.imp_aes_dwn_dt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_expt_id.Code='';
	             formObj2.imp_aes_expt_id.Enable=false;
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
	             break;
	        case "EX":
	        	 formObj2.imp_aes_expt_id.Enable=true;
	        	 //formObj2.imp_aes_expt_id.focus();
	             formObj2.imp_aes_expt_ctnt.readOnly=false;
	             formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             break;
    		}
    	}
    	
    	
    	if(obj.name=='exp_aes_tp_cd'&& obj.checked==false){ 
    		var obj2 = document.getElementsByName("exp_aes_tp_cd");
    		var chkcnt = 0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }

    		if(chkcnt==0){
    			 formObj.exp_aes_inlnd_trns_no.value='';
	        	 formObj.exp_aes_inlnd_trns_no.readOnly=true;
	             formObj.exp_aes_pta_no1.value='';
	             formObj.exp_aes_pta_no1.readOnly=true;
	             formObj.exp_aes_pta_no2.value='';
	             formObj.exp_aes_pta_no2.readOnly=true;
	             formObj.exp_aes_pta_dt.value='';
	             formObj.exp_aes_pta_dt.readOnly=true;
	             formObj.exp_aes_ptu_no.value='';
	             formObj.exp_aes_ptu_no.readOnly=true;
	             formObj.exp_aes_ptu_dt.value='';
	             formObj.exp_aes_ptu_dt.readOnly=true;
	             formObj.exp_aes_dwn_no.value='';
	             formObj.exp_aes_dwn_no.readOnly=true;
	             formObj.exp_aes_dwn_dt.value='';
	             formObj.exp_aes_dwn_dt.readOnly=true;
	             formObj.exp_aes_expt_id.Code='';
	             formObj.exp_aes_expt_id.Enable=false;
	             //formObj.exp_aes_expt_ctnt.innerText='';
	             //formObj.exp_aes_expt_ctnt.readOnly=true;
    		}
    	}else if(obj.name=='imp_aes_tp_cd'&& obj.checked==false){ 
    		var obj2 = document.getElementsByName("imp_aes_tp_cd"); 
    		var chkcnt = 0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		
    		if(chkcnt==0){
    			formObj2.imp_aes_inlnd_trns_no.value='';
	        	 formObj2.imp_aes_inlnd_trns_no.readOnly=true;
	             formObj2.imp_aes_pta_no1.value='';
	             formObj2.imp_aes_pta_no1.readOnly=true;
	             formObj2.imp_aes_pta_no2.value='';
	             formObj2.imp_aes_pta_no2.readOnly=true;
	             formObj2.imp_aes_pta_dt.value='';
	             formObj2.imp_aes_pta_dt.readOnly=true;
	             formObj2.imp_aes_ptu_no.value='';
	             formObj2.imp_aes_ptu_no.readOnly=true;
	             formObj2.imp_aes_ptu_dt.value='';
	             formObj2.imp_aes_ptu_dt.readOnly=true;
	             formObj2.imp_aes_dwn_no.value='';
	             formObj2.imp_aes_dwn_no.readOnly=true;
	             formObj2.imp_aes_dwn_dt.value='';
	             formObj2.imp_aes_dwn_dt.readOnly=true;
	             formObj2.imp_aes_expt_id.Code='';
	             formObj2.imp_aes_expt_id.Enable=false;
	             formObj2.imp_aes_expt_ctnt.value='';
	             formObj2.imp_aes_expt_ctnt.readOnly=true;
    		}
    	}
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
	    		if(document.form4.savechk.value==''){
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='KR'){
						sendForm("ESM_BKG_0361_02.do","O","KR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","O","BR");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","O","IN");
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='ID'){
						sendForm("ESM_BKG_0361_05.do","O","ID");
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
	    		if(document.form4.savechk.value==''){
		    		if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='BR'){
						sendForm("ESM_BKG_0361_03.do","I","BR");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='IN'){
						sendForm("ESM_BKG_0361_04.do","I","IN");
					}else if (formObj2.imp_cnt_cd.options[formObj2.imp_cnt_cd.selectedIndex].value=='ID'){
						sendForm("ESM_BKG_0361_05.do","I","ID");
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
    
    function radioChkCtrl(selRadio){
    	
    	if(selRadio== '1'){
    		if(document.form.exp_entr_clss_tp_cd[0].checked){
    			document.form.exp_entr_clss_tp_cd[1].checked =false;
    		}
    	}else{
    		if(document.form.exp_entr_clss_tp_cd[1].checked){
    			document.form.exp_entr_clss_tp_cd[0].checked =false;
    		}
    	}
    }
    
    function exp_aes_expt_id_OnChange(comboObj,sCode,sText){
//    	var formObjEx = document.form;
//    	
//    	// Export 경우
//		if(comboObj.name == "exp_aes_expt_id") {
//    		formObjEx.exp_aes_expt_ctnt.innerText = '';
//    		formObjEx.exp_aes_expt_ctnt.readOnly=true;
//    	}
    }
    
    function checkSpace(obj) {
    	// 입력한 값이 모두 space 이면 값을 공백처리한다.
    	var objText = obj.innerText;
    	str = objText.replace(/^\s*/,'').replace(/\s*$/, '');
    	if(str == "" && objText != "") {
    		obj.innerText = "";
    		ComShowMessage(ComGetMsg("BKG08246"));
    	}
    }
    
    
    function copyToDesc(chkObj){
		if(chkObj.name=="exp_vin_no_cpy_desc_flg"&&chkObj.checked==true){
			opener.document.form.dg_cmdt_desc.value=opener.document.form.dg_cmdt_desc.value +
													"\n VIN No. "+document.form.exp_vin_ctnt.value;	
		}
		opener.document.form.dirty_flag.value = 'Y';
    }