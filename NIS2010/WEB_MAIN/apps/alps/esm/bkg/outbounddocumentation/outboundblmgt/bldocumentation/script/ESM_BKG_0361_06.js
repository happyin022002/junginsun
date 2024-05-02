/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_06.js
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
     * @class esm_bkg_0361_06 : esm_bkg_0361_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0361_06() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initCombo				= initCombo;
    	this.setComboObject 		= setComboObject;
    }
    
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 0; 
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var saveMsgFlg = true;
var isInquiry = false;
var re = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
var re2 = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
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
        
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);           
        }
        initControl();

        if(document.form3.get_io_bnd_cd.value != 'I'){				
        	beforetab = 0; 
        	tab1.SelectedIndex = 0; 
        	
        	objs = document.all.item("tabLayer");

        	objs[0].style.display = "Inline";
        	objs[1].style.display = "none";      
        	
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
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
					else{
						sendForm("ESM_BKG_0361_03.do","I");
					}
				}else{
					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
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
     
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }
 
    function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "imp_ndr_ref_id": 
	            var i=0;	            
	            comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.",            "NDR1");
	            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000",          "NDR2");
	            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or commercial use",           "NDR3");
	            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under any of tariff item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set out in the schedule to the Customs Tariff", "NDR4");
	            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation under tariff item No. 980l.10.00 in the List of Tariff Provisions set out in the schedule to the Customs Tariff",        "NDR5");
	            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international commercial transportation of goods",       "NDR6");
	            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use",         "NDR7");
	            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances",         "NDR8");
	            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported in transit through Canada en route to a non-Canadian destination",         "NDR9");
	            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for the purpose of being transshipped through another country to another Canadian destination",         "NDR10");
	            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada",         "NDR11");
	            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier",         "NDR12");
	            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export from a bonded warehouse or sufferance warehouse",         "NDR13");
	            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned to Canada within 12 months after the date of exportation",         "NDR14");
	            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to an emergency will report orally according to section 15 of the export regulations",         "NDR15");
	            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export",         "NDR16");
	            comboObj.SetColWidth("50|900");
	            comboObj.DropHeight= 300;
	            comboObj.ColBackColor(0) = "#eeeeee";
	            break; 
	        case "exp_ndr_ref_id": 
	        	var i=0;	            
	        	    comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.|NDR1",            "NDR1");
		            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000|NDR2",          "NDR2");
		           
		            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or|NDR3 ",           "NDR3");
		            comboObj.InsertItem(i++, "|commercial use|NDR3",           "NDR3");
		            
//		            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under |NDR4", "NDR4");
//		            comboObj.InsertItem(i++, "|any of tariff item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set|NDR4", "NDR4");
//		            comboObj.InsertItem(i++, "|out in the schedule to the Customs Tariff|NDR4", "NDR4");
		            
		            comboObj.InsertItem(i++, "NDR4|Goods exported from Canada on a temporary basis by using ATA carnet numbers are required as |NDR4", "NDR4");
		            comboObj.InsertItem(i++, "|part of the NDR|NDR4", "NDR4");
		            
//		            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation|NDR5",        "NDR5");
//		            comboObj.InsertItem(i++, "|under tariff item No. 980l.10.00 in the List of Tariff Provisions set out in the schedule to the|NDR5",        "NDR5");
//		            comboObj.InsertItem(i++, "|to the Customs Tariff|NDR5",        "NDR5");
		            
		            comboObj.InsertItem(i++, "NDR5|Goods that were temporarily imported and documented on a Form E29B, Temporary Admission|NDR5",        "NDR5");
		            comboObj.InsertItem(i++, "|Permit, and are subsequently exported; E29B numbers are required as part of the NDR.|NDR5",        "NDR5");
		            
		            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international|NDR6",       "NDR6");
		            comboObj.InsertItem(i++, "|commercial transportation of goods|NDR6",       "NDR6");
		            
		            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use|NDR7",         "NDR7");
		            
		            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances|NDR8",         "NDR8");

//		            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported|NDR9",         "NDR9");
//		            comboObj.InsertItem(i++, "|in transit through Canada en route to a non-Canadian destination|NDR9",         "NDR9");
		            
		            comboObj.InsertItem(i++, "NDR9|NDR9 is no longer in use.|NDR9",         "NDR9");

//		            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for|NDR10",         "NDR10");
//		            comboObj.InsertItem(i++, "|the purpose of being transshipped through another country to another Canadian destination|NDR10",         "NDR10");
		            
		            comboObj.InsertItem(i++, "NDR10|Goods exported for repair or warranty repair regardless of value that will be returned to Canada.|NDR10",         "NDR10");

 //		            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada|NDR11",         "NDR11");
		            
		            comboObj.InsertItem(i++, "NDR11|Goods imported for repair or addition, which are subsequently exported, where the value of|NDR11",         "NDR11");
		            comboObj.InsertItem(i++, "|the repair or addition is less than CAN $2,000 or is covered by a warranty.|NDR11",         "NDR11");
		            
		            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier|NDR12",         "NDR12");
		            
		            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export from a bonded|NDR13",         "NDR13");
		            comboObj.InsertItem(i++, "|warehouse or sufferance warehouse|NDR13",         "NDR13");
		            
		            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned to Canada within|NDR14",         "NDR14");
		            comboObj.InsertItem(i++, "|12 months after the date of exportation|NDR14",         "NDR14");
		            
		            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to an emergency|NDR15",         "NDR15");
		            comboObj.InsertItem(i++, "|will report orally according to section 15 of the export regulations|NDR15",         "NDR15");

//		            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export|NDR16",         "NDR16");
		            
		            comboObj.InsertItem(i++, "NDR16|Other (this includes non-restricted goods used for unique situations). For this category,|NDR16",         "NDR16");
		            comboObj.InsertItem(i++, "|the reason for the NDR must be pre-authorized by the CBSA.|NDR16",         "NDR16");
		            comboObj.Code = "";
		            comboObj.SetColWidth("50|550|0");
		            comboObj.DropHeight= 350;
		            comboObj.ColBackColor(0) = "#eeeeee";
	            break; 
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
		   						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
//				} else {
//					document.form4.tabclosechk.value="";
//					saveMsgFlg = true;
//				} 
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
		   					doActionIBSheet(sheetObjects[1], document.form2, IBSEARCH) ;
		   				}
	   				}
//				} else {
//					document.form4.tabclosechk.value="";
//					saveMsgFlg = true;
//				} 
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
 	
 					var HeadTitle = "|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|caed_tp_cd|caed_no1|caed_no2|caed_no3|g7_edi_no1|g7_edi_no2|mf_smry_rpt_no|b13a_xpt_dt|b13a_xpt_no1|b13a_xpt_no2|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt";
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
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_tp_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no3",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"g7_edi_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"g7_edi_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"mf_smry_rpt_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"cgo_ctrl_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"ndr_ref_id",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"ndr_ref_ctnt",		false,	"",			dfNone,		0,			false,		false);
 					
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
 	 	
 					
 					var HeadTitle = "|Seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|caed_tp_cd|caed_no1|caed_no2|caed_no3|g7_edi_no1|g7_edi_no2|mf_smry_rpt_no|b13a_xpt_dt|b13a_xpt_no1|b13a_xpt_no2|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt";
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
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_tp_cd",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"caed_no3",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"g7_edi_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"g7_edi_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"mf_smry_rpt_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_dt",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_no1",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"b13a_xpt_no2",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"cgo_ctrl_no",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"ndr_ref_id",		false,	"",			dfNone,		0,			false,		false);
 					InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"ndr_ref_ctnt",		false,	"",			dfNone,		0,			false,		false);
 					
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
 					sheetObj.DoSearch("ESM_BKG_0361_06GS.do", FormQueryString(formObj));
 				}
 			break;
 	
 			case IBSAVE:        //저장
 				if(document.form4.tabclosechk.value=="Y"){
	 				obj = document.getElementsByName("exp_caed_tp_cd");	
		 			for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	switch(obj[i].value) {
					        	case "CE": 
					        		if(formObj.caed_no.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
			 						break;
					        	case "G7": 
					        		if(formObj.g7_edi_no.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
					        		break;
					        	case "SM": 
					        		if(formObj.exp_mf_smry_rpt_no.value==''){
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
					        	case "EX": 
					        		if(formObj.b13a_xpt_no.value==''){		
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
					        	case "IT": 
					        		if(formObj.exp_cgo_ctrl_no.value==''){	
					        			if (!ComShowCodeConfirm("BKG00254")) return;
					        		}
						        	break;
					        	case "ND": 
					        		if(comboObjects[0].Code==''){			
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
 						obj = document.getElementsByName("exp_caed_tp_cd");	
 						sheetObj.CellValue(1,"cnt_cd")="CA";
 						
 						
 						sheetObj.CellValue(1,"ndr_ref_id")= ComGetObjValue(comboObjects[0]);
 						sheetObj.CellValue(1,"ndr_ref_ctnt") = formObj.exp_ndr_ref_ctnt.innerText;
 					}else if(formObj.name=="form2"){
 						IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 					
 						obj = document.getElementsByName("imp_caed_tp_cd");
 						sheetObj.CellValue(1,"cnt_cd")="CA";
 						
 						sheetObj.CellValue(1,"ndr_ref_id")= ComGetObjValue(comboObjects[1]);
 					}
 					
				    for(var i=0; i<obj.length; i++){
				        if(obj[i].checked==true){
				        	sheetObj.CellValue(1,"caed_tp_cd")=obj[i].value;
				        	var reVal="";
				        	
				        	switch(obj[i].value) {
					        	case "CE": 
					        		reVal = ComTrimAll(formObj.caed_no.value, "-", "/", ":"," ");				        		
						        	sheetObj.CellValue(1,"caed_no1")=reVal.substring(0,6);
			 						sheetObj.CellValue(1,"caed_no2")=reVal.substring(6,12);
			 						sheetObj.CellValue(1,"caed_no3")=reVal.substring(12,23);
			 						break;
					        	case "G7": 
					        		reVal = ComTrimAll(formObj.g7_edi_no.value, "-", "/", ":"," ");		
					        		sheetObj.CellValue(1,"g7_edi_no1")=reVal.substring(0,6);
			 						sheetObj.CellValue(1,"g7_edi_no2")=reVal.substring(6,17);		 						
					        		break;
					        	case "EX": 
					        		reVal = ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", ":"," ");
					        		sheetObj.CellValue(1,"b13a_xpt_dt")=reVal.substring(0,12);
			 						sheetObj.CellValue(1,"b13a_xpt_no1")=reVal.substring(12,15);
			 						sheetObj.CellValue(1,"b13a_xpt_no2")=reVal.substring(15,21);			 						
						        	break;
				        	}
				        }
				    }
				    
 					if (sheetObj.CellValue(1,"caed_tp_cd")=='0' && sheetObj.CellValue(1, "ndr_ref_ctnt") == ''){
 						sheetObj.CellValue(1,0)='D';
				    }
 					
 					formObj.f_cmd.value = MULTI;
 					if(document.form4.tabclosechk.value=="Y"){
 						if(sheetObj.IsDataModified==true){
 							saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_06GS.do", FormQueryString(formObj) ,"");
 						}
 					}else{
 						saveMsgFlg = sheetObj.DoSave("ESM_BKG_0361_06GS.do", FormQueryString(formObj) ,"");
 					}
 				}
 			break;
 			
 			case IBDELETE:      // 입력
 				if(formObj.name=="form"){
	 				var obj = document.getElementsByName("exp_caed_tp_cd");
		    		for(var i=0; i<obj.length; i++){      
				        obj[i].checked = false
				        radioBtnSet(obj[i]);
				    }
		    		
 				}else{
 					var obj2 = document.getElementsByName("imp_caed_tp_cd");
		    		for(var i=0; i<obj2.length; i++){      
		    			obj2[i].checked = false
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
    	// if (!ComChkValid(formObj)) return false;
    	 with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
		
		if(sAction=='2'){	
	 		if(formObj.name=="form"){
		 		size = formObj.exp_caed_tp_cd.length;	
				for(var i = 0; i < size; i++) {
				  if(formObj.exp_caed_tp_cd[i].checked) {
					objs = document.all.item("tabLayer");
										
					switch(formObj.exp_caed_tp_cd[i].value) {
				        case "CE":     
				        	 if(formObj.caed_no.value==''){
				        		 setTab1();
				        		 ComAlertFocus(formObj.caed_no, ComGetMsg("BKG08245", "CAED No"));
				        		 return false;
				        		 break;
				        	 }
				        	 sVal = ComTrimAll(formObj.caed_no.value, "-", "/", ".").toUpperCase();
				        	 if (!ComIsCaedNo(sVal)){
				        		 setTab1();
				        		 ComAlertFocus(formObj.caed_no, ComGetMsg("COM12128","a valid format : NNANNN(6) - AAANNN(6) - NNNNNNNNNNN(11)"));				        		 
				        		 return false;
				        		 break;
				        	 }else{
				 	   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
				 	   				formObj.caed_no.value  =sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
					   			}else{
					   				formObj.caed_no.value  =sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
					   			}
				        	 }
				        	 break;
				        case "G7": 
				        	 if(formObj.g7_edi_no.value==''){
				        		 setTab1();
				             	 ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("BKG08245", "G7 EDI No"));
				        		 return false;
				        		 break;
				        	 }
				        	 
			        	 	sVal = ComTrimAll(formObj.g7_edi_no.value, "-", "/", ".");
		                    if (!ComIsG7EdiNo(sVal)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.g7_edi_no, ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
		                    	formObj.g7_edi_no.value  = sVal.replace(re,'$1' + "-" + '$2');
		                    }		                    
		                    break;
				        case "SM":
				        	 if(formObj.exp_mf_smry_rpt_no.value==''){
				        		 setTab1();
					        		 ComAlertFocus(formObj.exp_mf_smry_rpt_no,  ComGetMsg("BKG08245", "Summary Report"));
					        		 return false;
					        		 break;
				        	 }
				        	 if(formObj.exp_mf_smry_rpt_no.value.length<4){
				        		 setTab1();
				        		 ComAlertFocus(formObj.exp_mf_smry_rpt_no,  ComGetMsg("BKG08245", "Summary Report"));
				        		 return false;
				        		 break; 
				        	 }
				        	 break;
				        case "EX":				        	 
				        	if(formObj.b13a_xpt_no.value==''){				        		
					        		setTab1();
					        		 ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("BKG08245", "EXD (Form B13A)"));
					        		 return false;
					        		 break;
				        	 }
				        	
				        	sVal = ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", " ",":");
		                    if (!ComIsB13aXptNo(sVal)){
		                    	 setTab1();
				        		 ComAlertFocus(formObj.b13a_xpt_no, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));				        		 
				        		 return false;
				        		 break;
		                    }else{
		                    	var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
		                    	formObj.b13a_xpt_no.value  = sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
		                    }		
				        	break;
				        case "IT":
				        	if(formObj.exp_cgo_ctrl_no.value==''){				        		 
					        		setTab1();
					        		 ComAlertFocus(formObj.exp_cgo_ctrl_no,  ComGetMsg("BKG08245", "In-Transit Cargo"));
					        		 return false;
					        		 break;
				        	}
				        	break;
				        case "ND":
				        	if(comboObjects[0].Code==''){				        		
					        		setTab1();
					        		 ComAlertFocus(formObj.exp_ndr_ref_id,  ComGetMsg("BKG08245", "No Declaration"));
					        		 return false;
					        		 break;
				        	}
				        	break;
					 }
				  }
				}
	 		}else if(formObj.name=="form2"){
	 			size2 = formObj.imp_caed_tp_cd.length;	
				for(var j = 0; j < size2; j++) {
				  if(formObj.imp_caed_tp_cd[j].checked) {
					objs = document.all.item("tabLayer");
					
					switch(formObj.imp_caed_tp_cd[j].value) {
					case "CE":     
			        	 if(formObj.caed_no.value==''){
			        		 setTab2();
			        		 ComAlertFocus(formObj.caed_no, ComGetMsg("BKG08245", "CAED No"));
			        		 return false;
			        		 break;
			        	 }
			        	 sVal = ComTrimAll(formObj.caed_no.value, "-", "/", ".").toUpperCase();
			        	 if (!ComIsCaedNo(sVal)){
			        		 setTab2();
			        		 ComAlertFocus(formObj.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));				        		 
			        		 return false;
			        		 break;
			        	 }else{
			 	   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
			 	   				formObj.caed_no.value  =sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
				   			}else{
				   				formObj.caed_no.value  =sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
				   			}	 
			        	 }
			        	 break;
			        case "G7": 
			        	 if(formObj.g7_edi_no.value==''){
			        		 setTab2();
			             	 ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("BKG08245", "G7 EDI No"));
			        		 return false;
			        		 break;
			        	 }
			        	 
		        	 	sVal = ComTrimAll(formObj.g7_edi_no.value, "-", "/", ".");
	                    if (!ComIsG7EdiNo(sVal)){
	                    	setTab2();
			        		 ComAlertFocus(formObj.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));				        		 
			        		 return false;
			        		 break;
	                    }else{
	                    	var re      = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	                    	formObj.g7_edi_no.value  = sVal.replace(re,'$1' + "-" + '$2');
	                    }		                    
	                    break;
			        case "SM":
			        	 if(formObj.imp_mf_smry_rpt_no.value==''||formObj.imp_mf_smry_rpt_no.value.length<4){
			        		 setTab2();
			        		 ComAlertFocus(formObj.imp_mf_smry_rpt_no,  ComGetMsg("BKG08245", "Summary Report"));
			        		 return false;
			        		 break;
			        	 }	
			        	 break;
			        case "EX":				        	 
			        	if(formObj.b13a_xpt_no.value==''){
			        		setTab2();
			        		 ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("BKG08245", "EXD (Form B13A)"));
			        		 return false;
			        		 break;
			        	 }
			        	
			        	sVal = ComTrimAll(formObj.b13a_xpt_no.value, "-", "/", " ",":");
	                    if (!ComIsB13aXptNo(sVal)){
	                    	setTab2();
			        		 ComAlertFocus(formObj.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));				        		 
			        		 return false;
			        		 break;
	                    }else{
	                    	var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
	                    	formObj.b13a_xpt_no.value  = sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	                    }		
			        	break;
			        case "IT":
			        	if(formObj.imp_cgo_ctrl_no.value==''){
			        		setTab2();
			        		 ComAlertFocus(formObj.imp_cgo_ctrl_no,  ComGetMsg("BKG08245", "In-Transit Cargo"));
			        		 return false;
			        		 break;
			        	}
			        	break;
			        case "ND":
			        	if(comboObjects[1].Code==''){
			        		setTab2();
			        		 ComAlertFocus(formObj.imp_ndr_ref_id,  ComGetMsg("BKG08245", "No Declaration"));
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
    	var obj = document.getElementsByName("exp_caed_tp_cd");
		
    	if (sheetObj.RowCount>0){
    		IBS_CopyRowToForm(sheetObj,formObj, 1, "exp_"); 
    		
    		for(var i=0; i<obj.length; i++){
 		        if(obj[i].value==sheetObj.CellValue(1,"caed_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }

				radioBtnSet(obj[i]);
 		    }
    		if(sheetObj.CellValue(1,"caed_no1")!=''){
    			formObj.caed_no.value = sheetObj.CellValue(1,"caed_no1")+"-"+sheetObj.CellValue(1,"caed_no2")+"-"+sheetObj.CellValue(1,"caed_no3");
    		}
    		if(sheetObj.CellValue(1,"g7_edi_no1")!=''){
    			formObj.g7_edi_no.value = sheetObj.CellValue(1,"g7_edi_no1")+"-"+sheetObj.CellValue(1,"g7_edi_no2");
    		}
    		if(sheetObj.CellValue(1,"b13a_xpt_dt")!=''){
    			formObj.b13a_xpt_no.value = sheetObj.CellValue(1,"b13a_xpt_dt")+" "+sheetObj.CellValue(1,"b13a_xpt_no1")+"-"+sheetObj.CellValue(1,"b13a_xpt_no2");
    		}
    		if(sheetObj.CellValue(1,"ndr_ref_id")!=''){
    			comboObjects[0].Code=sheetObj.CellValue(1,"ndr_ref_id");
    		} else {
    			formObj.exp_ndr_ref_ctnt.innerText = sheetObj.CellValue(1,"ndr_ref_ctnt");
    		}
    		if(sheetObj.CellValue(1,"mf_smry_rpt_no")!=''){
    			formObj.exp_mf_smry_rpt_no.value = sheetObj.CellValue(1,"mf_smry_rpt_no");
    		}
    		
    		if(sheetObj.CellValue(1,"cgo_ctrl_no")!=''){
    			formObj.exp_cgo_ctrl_no.value = sheetObj.CellValue(1,"cgo_ctrl_no");
    		}
 		    
    	}else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "exp_"); 
            
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.CellValue(1,"caed_tp_cd")=obj[i].value;
		        }

				radioBtnSet(obj[i]);
		    }
    	}
    	
    	document.form3.get_io_bnd_cd.value="O";
    }
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
    	formObj = document.form2;
    	var obj = document.getElementsByName("imp_caed_tp_cd");
	    
    	if (sheetObj.RowCount>0){
    		IBS_CopyRowToForm(sheetObj, formObj, 1, "imp_"); 
    		
    		for(var i=0; i<obj.length; i++){
 		        if(obj[i].value==sheetObj.CellValue(1,"caed_tp_cd")){
 		        	obj[i].checked=true;
 		        }else{
 		        	obj[i].checked=false;
 		        }

				radioBtnSet(obj[i]);
 		    }
    		
    		if(sheetObj.CellValue(1,"caed_no1")!=''){
    			formObj.caed_no.value = sheetObj.CellValue(1,"caed_no1")+"-"+sheetObj.CellValue(1,"caed_no2")+"-"+sheetObj.CellValue(1,"caed_no3");
    		}
    		if(sheetObj.CellValue(1,"g7_edi_no1")!=''){
    			formObj.g7_edi_no.value = sheetObj.CellValue(1,"g7_edi_no1")+"-"+sheetObj.CellValue(1,"g7_edi_no2");
    		}
    		if(sheetObj.CellValue(1,"b13a_xpt_dt")!=''){
    			formObj.b13a_xpt_no.value = sheetObj.CellValue(1,"b13a_xpt_dt")+" "+sheetObj.CellValue(1,"b13a_xpt_no1")+"-"+sheetObj.CellValue(1,"b13a_xpt_no2");
    		}
    		if(sheetObj.CellValue(1,"ndr_ref_id")!=''){
    			comboObjects[1].Code=sheetObj.CellValue(1,"ndr_ref_id");
    		}
    		
    	}else{
    		initSheetData(sheetObj);
            IBS_CopyFormToRow(formObj,sheetObj, 1, "imp_"); 
            
            for(var i=0; i<obj.length; i++){
		        if(obj[i].checked==true){
		        	sheetObj.CellValue(1,"caed_tp_cd")=obj[i].value;
		        }

				radioBtnSet(obj[i]);
		    }
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
        axon_event.addListenerFormat ('beforeactivate',   'obj_activate',    document.form);
        axon_event.addListenerFormat ('beforeactivate',   'obj_activate',    document.form2);
    }
    
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "int":    	        
    	        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    function obj_activate(){
        ComClearSeparatorMod(event.srcElement);
    }

    function ComClearSeparatorMod(obj,sFormat,sDelim)
    {
        try{
            if (typeof(obj) != "object" ) return;
            
            obj.value = ComTrimAll(obj.value, "-", "/", ":"," ");
            
            if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus = new Function("this.select()");

			event.returnValue=true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
        
    function ComIsCaedNo(obj, sFlag) {
        try {
            var sVal = getArgValue(obj);

            sVal = sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 23) return false;
            
            if (!ComIsNumber(sVal.substring(0,2))) return false;
            if (!isAlpha(sVal.substring(2,3))) return false;      
            if (!ComIsNumber(sVal.substring(3,6))) return false;
            if (!isAlpha(sVal.substring(6,8))) return false; 
            if (!isAlpha(sVal.substring(8,9))&&!ComIsNumber(sVal.substring(8,9))) return false;  
            if (!ComIsNumber(sVal.substring(9,23))) return false;
            
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ChkComIsCaedNo(obj){
    	if(obj.form.name=='form'){
	    	size = document.form.exp_caed_tp_cd.length;	
	    	j=0
			for(var i = 0; i < size; i++) {
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
	    	if(j<1) return false;
    	}else{		
			size = document.form2.imp_caed_tp_cd.length;	
			j=0
			for(var i = 0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
		
    	if (!ComIsCaedNo(obj.value)){
    		 if(obj.form.name=='form'){
    			 //ComAlertFocus(document.form.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
    		 }else{
    			 //ComAlertFocus(document.form2.caed_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
    		 }
    		 return false;
	   	}else{ 
	   		sVal = obj.value.toUpperCase();
	   		if(obj.form.name=='form'){
	   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
	   				document.form.caed_no.value  =sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
	   			}else{
	   				document.form.caed_no.value  =sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   			}
	   		
	   		}else{
	   			
	   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
	   				document.form2.caed_no.value  = sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
	   			}else{
	   				document.form2.caed_no.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   			}
	   			
	   			
	   		}
	   	}
    }
    
    function ComIsG7EdiNo(obj, sFlag) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            sVal = sVal.replace(/\/|\-|\./g,"");
            if (sVal.length != 17) return false;
            
            if (!ComIsNumber(sVal.substring(0,2))) return false;
            if (!isAlpha(sVal.substring(2,3))) return false;      
            if (!ComIsNumber(sVal.substring(3,17))) return false;
            
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ChkComIsG7EdiNo(obj){
    	if(obj.form.name=='form'){
	    	size = document.form.exp_caed_tp_cd.length;	
	    	j=0
			for(var i = 0; i < size; i++) {
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
	    	if(j<1) return false;
    	}else{		
			size = document.form2.imp_caed_tp_cd.length;	
			j=0
			for(var i = 0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
    	
    	if (!ComIsG7EdiNo(obj.value)){
			 if(obj.form.name=='form'){
				 //ComAlertFocus(document.form.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
			 }else{
				 //ComAlertFocus(document.form2.g7_edi_no,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
			 }
	   	}else{
	   		var re      = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	   		sVal = obj.value.toUpperCase()
	   		if(obj.form.name=='form'){
	   			document.form.g7_edi_no.value  = sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   		}else{
	   			document.form2.g7_edi_no.value  = sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   		}
	   	}
    }
    
    function ComIsB13aXptNo(obj, sFlag) {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            sVal = sVal.replace(/\/|\-|\./g," ");
            if (sVal.length != 21) return false;
            if (!ComIsNumber(sVal)) return false;

            var year, month, day, week;
           
            year  = sVal.substring(0,4);
            month = sVal.substring(4,6);
            day   = sVal.substring(6,8);
            hm   = sVal.substring(8,12);
            if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)|| !ComIsTime(hm, "hm")) return false;
            
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function ChkComIsB13aXptNo(obj){
    	if(obj.form.name=='form'){
	    	size = document.form.exp_caed_tp_cd.length;	
	    	j=0
			for(var i = 0; i < size; i++) {				
				if(document.form.exp_caed_tp_cd[i].checked) {
					if(document.form.exp_caed_tp_cd[i].value!='EX') return false;
					j++
				}
			}
	    	if(j<1) return false;
    	}else{		
			size = document.form2.imp_caed_tp_cd.length;	
			j=0
			for(var i = 0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='EX') return false;
					j++
				}				
			}
			if(j<1) return false;
    	}
    	
    	if (!ComIsB13aXptNo(obj.value)){
			 if(obj.form.name=='form'){
				 //ComAlertFocus(document.form.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
			 }else{
				 //ComAlertFocus(document.form2.b13a_xpt_no,  ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
			 }
	   	}else{
	   		var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
        	if(obj.form.name=='form'){
	   			document.form.b13a_xpt_no.value  = obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	   		}else{
	   			document.form2.b13a_xpt_no.value  = obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	   		}
	   	}
    }
   
    function isAlpha(str) {
        var pattern = /^[a-zA-Z]+$/;
        return (pattern.test(str)) ? true : false;
    }
    
    function radioBtnSet(obj){
    	formObj = document.form;
    	formObj2 = document.form2;
    	
    	if(obj.name=='exp_caed_tp_cd'&& obj.checked==true){ 
    		 
    		var obj2 = document.getElementsByName("exp_caed_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked = false;
		        }
		    }
    		    
	    	switch(obj.value) {
		        case "CE":  
		        	 formObj.caed_no.readOnly=false;
		             formObj.g7_edi_no.value='';
		             formObj.g7_edi_no.readOnly=true;
		             formObj.exp_mf_smry_rpt_no.value='';
		             formObj.exp_mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_no.value='';
		             formObj.b13a_xpt_no.readOnly=true;
		             formObj.exp_cgo_ctrl_no.value='';
		             formObj.exp_cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].Enable=false;
		             //formObj.exp_ndr_ref_ctnt.innerText = '';
		             //formObj.exp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "G7": 
		        	 formObj.caed_no.value='';
		        	 formObj.caed_no.readOnly=true;
		             formObj.g7_edi_no.readOnly=false;
		             formObj.exp_mf_smry_rpt_no.value='';
		             formObj.exp_mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_no.value='';
		             formObj.b13a_xpt_no.readOnly=true;
		             formObj.exp_cgo_ctrl_no.value='';
		             formObj.exp_cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].Enable=false;
		             //formObj.exp_ndr_ref_ctnt.innerText = '';
		             //formObj.exp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "SM":
		        	 formObj.caed_no.value='';
		        	 formObj.caed_no.readOnly=true;
		             formObj.g7_edi_no.value='';
		             formObj.g7_edi_no.readOnly=true;
		             formObj.exp_mf_smry_rpt_no.readOnly=false;
		             formObj.b13a_xpt_no.value='';
		             formObj.b13a_xpt_no.readOnly=true;
		             formObj.exp_cgo_ctrl_no.value='';
		             formObj.exp_cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].Enable=false;
		             //formObj.exp_ndr_ref_ctnt.innerText = '';
		             //formObj.exp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "EX":
		        	 formObj.caed_no.value='';
		        	 formObj.caed_no.readOnly=true;
		             formObj.g7_edi_no.value='';
		             formObj.g7_edi_no.readOnly=true;
		             formObj.exp_mf_smry_rpt_no.value='';
		             formObj.exp_mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_no.readOnly=false;
		             formObj.exp_cgo_ctrl_no.value='';
		             formObj.exp_cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].Enable=false;
		             //formObj.exp_ndr_ref_ctnt.innerText = '';
		             //formObj.exp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "IT":
		        	 formObj.caed_no.value='';
		        	 formObj.caed_no.readOnly=true;
		             formObj.g7_edi_no.value='';
		             formObj.g7_edi_no.readOnly=true;
		             formObj.exp_mf_smry_rpt_no.value='';
		             formObj.exp_mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_no.value='';
		             formObj.b13a_xpt_no.readOnly=true;
		             formObj.exp_cgo_ctrl_no.readOnly=false;
		             comboObjects[0].index='';
		             comboObjects[0].Enable=false;
		             //formObj.exp_ndr_ref_ctnt.innerText = '';
		             //formObj.exp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "ND":
		        	 formObj.caed_no.value='';
		        	 formObj.caed_no.readOnly=true;
		             formObj.g7_edi_no.value='';
		             formObj.g7_edi_no.readOnly=true;
		             formObj.exp_mf_smry_rpt_no.value='';
		             formObj.exp_mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_no.value='';
		             formObj.b13a_xpt_no.readOnly=true;
		             formObj.exp_cgo_ctrl_no.value=''
		             formObj.exp_cgo_ctrl_no.readOnly=true;
		             comboObjects[0].Enable=true;
		             //formObj.exp_ndr_ref_ctnt.readOnly = false;
		        	 break;
	    	}
    	}else if(obj.name=='imp_caed_tp_cd'&& obj.checked==true){
    		var obj2 = document.getElementsByName("imp_caed_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked = false;
		        }
		    }
    		switch(obj.value) {
	    		case "CE":  
		        	 formObj2.caed_no.readOnly=false;
		             formObj2.g7_edi_no.value='';
		             formObj2.g7_edi_no.readOnly=true;
		             formObj2.imp_mf_smry_rpt_no.value='';
		             formObj2.imp_mf_smry_rpt_no.readOnly=true;
		             formObj2.b13a_xpt_no.value='';
		             formObj2.b13a_xpt_no.readOnly=true;
		             formObj2.imp_cgo_ctrl_no.value='';
		             formObj2.imp_cgo_ctrl_no.readOnly=true;
		             comboObjects[1].index='';
		             comboObjects[1].Enable=false;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "G7": 
		        	 formObj2.caed_no.value='';
		        	 formObj2.caed_no.readOnly=true;
		             formObj2.g7_edi_no.readOnly=false;
		             formObj2.imp_mf_smry_rpt_no.value='';
		             formObj2.imp_mf_smry_rpt_no.readOnly=true;
		             formObj2.b13a_xpt_no.value='';
		             formObj2.b13a_xpt_no.readOnly=true;
		             formObj2.imp_cgo_ctrl_no.value='';
		             formObj2.imp_cgo_ctrl_no.readOnly=true;
		             comboObjects[1].index='';
		             comboObjects[1].Enable=false;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "SM":
		        	 formObj2.caed_no.value='';
		        	 formObj2.caed_no.readOnly=true;
		             formObj2.g7_edi_no.value='';
		             formObj2.g7_edi_no.readOnly=true;
		             formObj2.imp_mf_smry_rpt_no.readOnly=false;
		             formObj2.b13a_xpt_no.value='';
		             formObj2.b13a_xpt_no.readOnly=true;
		             formObj2.imp_cgo_ctrl_no.value='';
		             formObj2.imp_cgo_ctrl_no.readOnly=true;
		             comboObjects[1].index='';
		             comboObjects[1].Enable=false;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "EX":
		        	 formObj2.caed_no.value='';
		        	 formObj2.caed_no.readOnly=true;
		             formObj2.g7_edi_no.value='';
		             formObj2.g7_edi_no.readOnly=true;
		             formObj2.imp_mf_smry_rpt_no.value='';
		             formObj2.imp_mf_smry_rpt_no.readOnly=true;
		             formObj2.b13a_xpt_no.readOnly=false;
		             formObj2.imp_cgo_ctrl_no.value='';
		             formObj2.imp_cgo_ctrl_no.readOnly=true;
		             comboObjects[1].index='';
		             comboObjects[1].Enable=false;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "IT":
		        	 formObj2.caed_no.value='';
		        	 formObj2.caed_no.readOnly=true;
		             formObj2.g7_edi_no.value='';
		             formObj2.g7_edi_no.readOnly=true;
		             formObj2.imp_mf_smry_rpt_no.value='';
		             formObj2.imp_mf_smry_rpt_no.readOnly=true;
		             formObj2.b13a_xpt_no.value='';
		             formObj2.b13a_xpt_no.readOnly=true;
		             formObj2.imp_cgo_ctrl_no.readOnly=false;
		             comboObjects[1].index='';
		             comboObjects[1].Enable=false;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
		             break;
		        case "ND":
		        	 formObj2.caed_no.value='';
		        	 formObj2.caed_no.readOnly=true;
		             formObj2.g7_edi_no.value='';
		             formObj2.g7_edi_no.readOnly=true;
		             formObj2.imp_mf_smry_rpt_no.value='';
		             formObj2.imp_mf_smry_rpt_no.readOnly=true;
		             formObj2.b13a_xpt_no.value='';
		             formObj2.b13a_xpt_no.readOnly=true;
		             formObj2.imp_cgo_ctrl_no.value=''
		             formObj2.imp_cgo_ctrl_no.readOnly=true;
		             comboObjects[1].Enable=true;
		             //formObj2.imp_ndr_ref_ctnt.innerText = '';
		        	 break;
    		}
    	}
    	
    	
    	if(obj.name=='exp_caed_tp_cd'&& obj.checked==false){ 
   		 
    		var obj2 = document.getElementsByName("exp_caed_tp_cd");
    		var chkcnt = 0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		
    		if(chkcnt==0){
    			 formObj.caed_no.value='';
	        	 formObj.caed_no.readOnly=true;
	             formObj.g7_edi_no.value='';
	             formObj.g7_edi_no.readOnly=true;
	             formObj.exp_mf_smry_rpt_no.value='';
	             formObj.exp_mf_smry_rpt_no.readOnly=true;
	             formObj.b13a_xpt_no.value='';
	             formObj.b13a_xpt_no.readOnly=true;
	             formObj.exp_cgo_ctrl_no.value=''
	             formObj.exp_cgo_ctrl_no.readOnly=true;
	             comboObjects[0].index='';
	             comboObjects[0].Enable=false;
	             //formObj.exp_ndr_ref_ctnt.innerText = '';
	             //formObj.exp_ndr_ref_ctnt.readOnly = true;
    		}
    	}else if(obj.name=='imp_caed_tp_cd'&& obj.checked==false){ 
    		var obj2 = document.getElementsByName("imp_caed_tp_cd"); 
    		var chkcnt = 0
    		for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
    		
    		if(chkcnt==0){
    			 formObj2.caed_no.value='';
	        	 formObj2.caed_no.readOnly=true;
	             formObj2.g7_edi_no.value='';
	             formObj2.g7_edi_no.readOnly=true;
	             formObj2.imp_mf_smry_rpt_no.value='';
	             formObj2.imp_mf_smry_rpt_no.readOnly=true;
	             formObj2.b13a_xpt_no.value='';
	             formObj2.b13a_xpt_no.readOnly=true;
	             formObj2.imp_cgo_ctrl_no.value=''
	             formObj2.imp_cgo_ctrl_no.readOnly=true;
	             comboObjects[1].index='';
	             comboObjects[1].Enable=false;
	             //formObj2.imp_ndr_ref_ctnt.innerText = '';
	             //formObj2.imp_ndr_ref_ctnt.readOnly = true;
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
					}else if (formObj.exp_cnt_cd.options[formObj.exp_cnt_cd.selectedIndex].value=='US'){
						sendForm("ESM_BKG_0361_01.do","O","US");
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
    
    function exp_ndr_ref_id_OnChange(comboObj,sCode,sText){
//    	var formObjEx = document.form;
//    	
//    	// Export 경우
//    	if(comboObj.name == "exp_ndr_ref_id") {
//	    	formObjEx.exp_ndr_ref_ctnt.innerText = '';
//	    	formObjEx.exp_ndr_ref_ctnt.readOnly=true;
//	    }
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