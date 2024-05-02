/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_02.js
*@FileTitle : Export / Import Information (Korea)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.15 최도순
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
     * @class esm_bkg_0361_02 : esm_bkg_0361_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0361_02() {
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
							if(document.form4.savechk.value==''){
								window.close();
							}
						} else {
							document.form4.tabclosechk.value="";
							saveMsgFlg = true;
						}
                    break;
                    
					case "btn_rowAdd":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
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
                    
					case "btn_rowAdd2":
						doActionIBSheet(sheetObject2, formObject2, IBINSERT);
                    break; 

					case "btn_delete2":
						if (!ComShowCodeConfirm("COM12188")) return;
						doActionIBSheet(sheetObject2, formObject2, IBDELETE);
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
     		getButtonTable("btn_delete2").style.display ="none";
     		getButtonTable("btn_rowAdd").style.display ="none";
     		getButtonTable("btn_rowAdd2").style.display ="none";*/
    		ComBtnDisable("btn_save");
    		ComBtnDisable("btn_delete");
    		ComBtnDisable("btn_save2");
    		ComBtnDisable("btn_delete2");
    		ComBtnDisable("btn_rowAdd");
    		ComBtnDisable("btn_rowAdd2");
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

        if(document.form3.get_io_bnd_cd.value != 'I'){
        	beforetab = 0;
        	tab1.SelectedIndex = 0; 
        	
        	var ctxName = "/hanjin";
        	if(document.form4.savechk.value==''){
	        	if(document.form3.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
					if (document.form3.pol_cd.value.substring(0,2)=='KR'){
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
						sendForm("ESM_BKG_0361_01.do","O");
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
     	
     	beforetab= nItem;
     	
     	var ctxName = "/hanjin";
   		var formObj = document.form3;
           
   		switch(nItem) {

   			case 0:				
   				document.form4.tabclosechk.value="Y";
				doActionIBSheet(sheetObjects[1], document.form2, IBSAVE);
   				if (saveMsgFlg) {
	   				document.form.go_cnt_cd.value='';
	   				if( document.form4.savechk.value==''){				
		   				if(formObj.bkg_no.value != ''&& document.form.go_cnt_cd.value==''){
		   					if (formObj.pol_cd.value.substring(0,2)=='KR'){
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
								sendForm("ESM_BKG_0361_01.do","O");
		   					}
		   				}else{
		   					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
 			
 		switch(sheetNo) {
 			case 1:      //sheet1 init
 				with (sheetObj) {
 					// 높이 설정
 					style.height = 140;
 	
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
 	
 					var HeadTitle = "|||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package|UCR No.";
 					var headCount = ComCountHeadTitle(HeadTitle);
 	
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 	
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false, false);
 	
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					
 					
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	false,	"ibflag");
 					InitDataProperty(0,	cnt++,	dtSeq,			20,		daCenter,	false,	"seq");
 					InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	false,	"Check",			false,	"",      dfNone,		0,		true,		true);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"bkg_no", 			true);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"io_bnd_cd",		true,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"xpt_imp_seq",		true,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"cnt_cd",			false,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"xpt_lic_no",		false,	"",      dfNone,			0,		true,		true,15);
					InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"ts_ref_no",		false,	"",      dfNone,			0,		true,		true, 19);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		50,		daRight,	false,	"pck_qty",			true,	"",      dfInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"pck_tp_cd",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,	"mf_wgt",			true,	"",      dfFloat,	3,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"wgt_ut_cd",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daRight,	false,	"divd_seq",			false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	false,	"sam_pck_id",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	false,	"sam_pck_qty",		false,	"",      dfInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"sam_pck_tp_cd",	false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		   140,		daCenter,	false,	"ucr_no",			false,	"",      dfNone,			0,		true,		true);

//					InitUserFormat(0, "xpt_lic_no", "#####-##-######AL", "-" );
				 	
					InitDataCombo(0, "wgt_ut_cd", " |KGS|LGB", " |KGS|LGB");
					InitDataCombo(0, "divd_seq", " |1|2|3|4", " |1|2|3|4");
					InitDataCombo(0, "sam_pck_id", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z");


					ShowButtonImage = 2;	
 				}
 			break;
 			case 2:      //sheet1 init
 				with (sheetObj) {
 	
 					// 높이 설정
 					style.height =140;
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
 	 	
 					
 					var HeadTitle = "|||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package|UCR No.";
 					var headCount = ComCountHeadTitle(HeadTitle);
 	
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 					
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false, false)
 	
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 	
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	false,	"ibflag");
 					InitDataProperty(0,	cnt++,	dtSeq,			20,		daCenter,	false,	"seq");
 					InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	false,	"Check",			false,	"",      dfNone,		0,		true,		true);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"bkg_no", 			true);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"io_bnd_cd",		true,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"xpt_imp_seq",		true,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"cnt_cd",			false,	"",		 dfNone,		0,			false,		false);
 					InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"xpt_lic_no",		false,	"",      dfNone,			0,		true,		true, 15);
					InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"ts_ref_no",		false,	"",      dfNone,			0,		true,		true,18);
					
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"pck_qty",			true,	"",      dfInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"pck_tp_cd",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"mf_wgt",			true,	"",      dfFloat,	3,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"wgt_ut_cd",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daRight,	false,	"divd_seq",			false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	false,	"sam_pck_id",		false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	false,	"sam_pck_qty",		false,	"",      dfInteger,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"sam_pck_tp_cd",	false,	"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		   140,		daCenter,	false,	"ucr_no",			false,	"",      dfNone,			0,		true,		true);

//					InitUserFormat(0, "xpt_lic_no", "#####-##-######AL", "-" );
					
					InitDataCombo(0, "wgt_ut_cd", " |KGS|LGB", " |KGS|LGB");
					InitDataCombo(0, "divd_seq", " |1|2|3|4", " |1|2|3|4");
					InitDataCombo(0, "sam_pck_id", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z");

					ShowButtonImage = 2;	
 				}
 			break;
 		}
 	}
 	
  // Sheet관련 프로세스 처리
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.WaitImageVisible=false;
 		ComOpenWait(true);
 		//sheetObj.ShowDebugMsg = true;
 		switch(sAction) {
 	
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj, formObj, sAction)) {
 					 					
 					formObj.f_cmd.value = SEARCH;
 					test = sheetObj.DoSearch("ESM_BKG_0361_02GS.do", FormQueryString(formObj));
 				}
 			break;
 	
 			case IBINSERT:      // 입력				
 				var newRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue(newRow, "bkg_no") = formObj.bkg_no.value;
				sheetObj.CellValue(newRow, "io_bnd_cd") = formObj.io_bnd_cd.value;	
				sheetObj.CellValue(newRow, "xpt_imp_seq") = formObj.xpt_imp_seq.value;
				sheetObj.CellValue(newRow, "cnt_cd") = "KR";
				sheetObj.CellValue(newRow, "wgt_ut_cd") = "KGS";
				
	    		sheetObj.CellValue2(sheetObj.LastRow, 1) = "";
	    		sheetObj.CellValue2(sheetObj.LastRow, "ts_ref_no") = "TOTAL";
	    		sheetObj.CellAlign(sheetObj.LastRow, "ts_ref_no") = daCenter;

			break;
		
 			case IBSAVE:        //저장 			
 				
 				if(validateForm(sheetObj,formObj,sAction)) {
 					document.form4.savechk.value="";
 					
 					formObj.f_cmd.value = MULTI;
 					
 					if(document.form4.tabclosechk.value=="Y"){
 						if(sheetObj.IsDataModified==true){
 							saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_02GS.do", FormQueryString(formObj) ,"");
 						}
 					}else{
 						saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_02GS.do", FormQueryString(formObj) ,"");
 					}
 					
 				}
 			break;
 			
 			case IBDELETE:      // 입력
	 			var rCnt = sheetObj.Rowcount+1;
 			    var chkCnt=0
				for(i=1;i<rCnt;i++){
					if(sheetObj.CellValue(i, "Check") == 1){
						chkCnt++	
					}
				}
 			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}

	 			var rCnt = sheetObj.Rowcount+1;
				for(i=1;i<rCnt;i++){
					if(sheetObj.CellValue(i, "Check") == 1){
						sheetObj.CellValue2(i, "pck_qty") = 0;
						sheetObj.CellValue2(i, "mf_wgt") = 0;
					}
				}
				ComRowHideDelete(sheetObj, "Check");

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
    	 if (!ComChkValid(formObj)) return false;
    	 with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        var Value = "";
        var Value2 = "";
		var pkg = "";
		var wgt = "";
		var sumQty ="";
		var pkgQty = "";
		var wgtQty = "";
		var sumQty2 = "";

	    if (sAction=='2'){
	    	
	    	pkgQty = document.form3.pkg_qty.value.replace(",","");
			wgtQty = document.form3.wgt_qty.value.replace(",","");
			sumQty2 = parseFloat(pkgQty)+parseFloat(wgtQty);
			sumQty = 0;
			pkg = 0;
			wgt = 0.000;
	    	for(var j=1;j<sheetObj.RowCount+1;j++){
	    		ibflag = sheetObj.CellValue(j,"ibflag");
				
	    		Value = sheetObj.CellValue(j,"xpt_lic_no");
				Value2 = sheetObj.CellValue(j,"ts_ref_no");
				
				var T=Number('1e'+1);

				if(ibflag!='D'){
					pkg += parseInt(sheetObj.CellValue(j,"pck_qty"));
					wgt += parseFloat(sheetObj.CellValue(j,"mf_wgt"));
				}
								
				sumQty = Math.round((pkg+wgt)* T) / T;;
				objs = document.all.item("tabLayer");
				
				if(ibflag=='I'||ibflag=='U'){
					if(Value==''&&Value2==''){
					    if(formObj.name=="form"){
					    	setTab1();
					    }else{
					    	setTab2();
					    }
		             	ComShowCodeMessage("COM12138","Export License Number","Other Reference No.");
					    sheetObj.SelectCell(j, "xpt_lic_no");
						return;
					}					
					if(Value.length > 0 &&Value.length < 14){
						if(formObj.name=="form"){
							setTab1();
					    }else{
					    	setTab2();
					    }
		             	document.form4.savechk.value="N";
						ComShowCodeMessage("BKG00257");
						sheetObj.SelectCell(j, "xpt_lic_no");
						return;
					}
					//로직해제 (4세대)
//					else if(Value.length > 14){
//						var total  = 0;
//						for(var i = 1; i < 15; i++){
//							switch (i%3){
//								case 1:
//									total+=parseInt(((Value.substring(i-1,i)*7)%10));
//								break;	
//								case 2:
//									total+=parseInt(((Value.substring(i-1,i)*3)%10));
//			 				break;
//								case 0:
//									total+=parseInt((Value.substring(i-1,i)*1));
//			 				break;
//							}
//						}     	
//						chkDigit =  ((10-(total%10))%10);
//							
//						if(Value.length == 15){
//				 			if(Value.substring(14,15)!=chkDigit){
//				 				if(formObj.name=="form"){
//				 					setTab1();
//							    }else{
//							    	setTab2();
//							    }
//				             	document.form4.savechk.value="N";
//				             	ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
//				 				sheetObj.CellValue(j, "xpt_lic_no") =  Value.substring(0,14);
//				 				return;
//				 			}
//				 		}else{
//				 			sheetObj.CellValue2(j, "xpt_lic_no") =  Value+chkDigit;
//				 		}	    			
//					}					
				}
	    	}
	    	
	    	if(parseFloat(sumQty)!=parseFloat(sumQty2)&&sheetObj.isDataModified==true){
	    		var mText = new Array(pkgQty,wgtQty,pkg,wgt.toFixed(3));
			    if (!ComShowCodeConfirm2("BKG00199", mText)) return;
	    	}
	    	if(sheetObj.RowCount >= 2 ){
	    		var arr;
	    		for(var j=1;j<sheetObj.RowCount+1;j++){
	    			arr = ComFindText(sheetObj,"xpt_lic_no",sheetObj.CellValue(j,"xpt_lic_no"));
	    			if (arr && 1<arr.length && sheetObj.CellValue(j,"xpt_lic_no") != "") {
	    				ComShowCodeMessage("BKG03056","Export License No");
	    				return;
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
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	formObj = document.form;
    	if (sheetObj.RowCount>0){    		
    	}else{    		
    	}
    	
    	document.form3.get_io_bnd_cd.value="O";

    	if (sheetObj.RowCount > 0) {
    		sheetObj.CellValue2(sheetObj.LastRow, 1) = "";
    		sheetObj.CellValue2(sheetObj.LastRow, "ts_ref_no") = "TOTAL";
    		sheetObj.CellAlign(sheetObj.LastRow, "ts_ref_no") = daCenter;
    	}
    }
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj = document.form2;
    	if (sheetObj.RowCount>0){
    	}else{           
    	}
    	
    	document.form3.get_io_bnd_cd.value="I";
    }
    
    function initControl() {    	
    	
    }
    
    function sheet1_OnPopupClick(sheetObj,Row,Col){
    	comBkgCallPop0696("setCallBack0696",sheetObj.CellValue(Row, Col));
    }
    
    function sheet2_OnPopupClick(sheetObj,Row,Col){
    	comBkgCallPop0696("setCallBack06962",sheetObj.CellValue(Row, Col));
    }

    function setCallBack0696(aryPopupData) {
    	var sheetObj = sheetObjects[0];
    	sheetObj.CellValue(sheetObj.SelectRow, sheetObj.SelectCol) = aryPopupData[0][3];
    }
    function setCallBack06962(aryPopupData) {
    	var sheetObj = sheetObjects[1];
    	sheetObj.CellValue(sheetObj.SelectRow, sheetObj.SelectCol) = aryPopupData[0][3];
    }
    
    function sheet1_OnChange(sheetObj,Row, Col, Value){  
    	if(Col=='7'){
    		if(Value!=''&&Value.length < 14){
    			ComShowCodeMessage("BKG00257");
    			sheetObj.SelectCell(Row, Col);
    		}
    		//로직해제 (4세대)
//    		else{
//    			var total  = 0;
//    			for(var i = 1; i < 13; i++){
//    				switch (i%3){
//    					case 1:
//    						total+=parseInt(((Value.substring(i-1,i)*7)%10));
//    					break;	
//    					case 2:
//    						total+=parseInt(((Value.substring(i-1,i)*3)%10));
//        				break;
//    					case 0:
//    						total+=parseInt((Value.substring(i-1,i)*1));
//        				break;
//    				}
//    			}     	
//    			chkDigit =  ((10-(total%10))%10);
//    			
//    			if(Value.length == 15){
//        			if(Value.substring(14,15)!=chkDigit){
//        				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
//        				sheetObj.CellValue(Row, Col) =  Value.substring(0,14);
//        				sheetObj.SelectCell(Row, Col);
//        			}
//        		}else if(Value.length == 14){
//        			sheetObj.CellValue2(Row, Col) =  Value+chkDigit;
//        		}
//    			
//    			
//    		}
    		sheetObj.CellValue2(Row, Col) = Value.toUpperCase();
    	}
    	
    	if(Col=='8'||Col=='10'||Col=='16'){
    		sheetObj.CellValue2(Row, Col) = Value.toUpperCase();
    	}
    }
    
    function sheet2_OnChange(sheetObj,Row, Col, Value){    	
    	if(Col=='7'){
    		if(Value!=''&&Value.length < 14){
    			ComShowCodeMessage("BKG00257");
    			sheetObj.SelectCell(Row, Col);
    		}
    		//로직해제 (4세대)
//    		else{
//    			var total  = 0;
//    			for(var i = 1; i < 15; i++){
//    				switch (i%3){
//    					case 1:
//    						total+=parseInt(((Value.substring(i-1,i)*7)%10));
//    					break;	
//    					case 2:
//    						total+=parseInt(((Value.substring(i-1,i)*3)%10));
//        				break;
//    					case 0:
//    						total+=parseInt((Value.substring(i-1,i)*1));
//        				break;
//    				}
//    			}     	
//    			chkDigit =  ((10-(total%10))%10);
//    			
//    			if(Value.length == 15){
//        			if(Value.substring(14,15)!=chkDigit){
//        				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
//        				sheetObj.CellValue(Row, Col) =  Value.substring(0,14);
//        				sheetObj.SelectCell(Row, Col);
//        			}
//        		}else if(Value.length == 14){
//        			sheetObj.CellValue2(Row, Col) =  Value+chkDigit;
//        		}
//    			
//    			
//    		}
    	}
    	
    	if(Col=='8'||Col=='10'||Col=='16'){
    		sheetObj.CellValue2(Row, Col) = Value.toUpperCase();
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
		    		if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
