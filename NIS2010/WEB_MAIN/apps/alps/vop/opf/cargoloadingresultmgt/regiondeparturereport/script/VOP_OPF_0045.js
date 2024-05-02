/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0045.js
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation 
* History --------------------------------------------------
* No. Date       Modifier  CSR No.        Content
* 1.  2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
* 2.  2012.05.22 전상화 [CHM-201217915]     [VOP-OPF] RDR Inquiry : 소스 내용 변경 없이, 재 태깅 작업 

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
     * @class VOP_OPF_0045 : VOP_OPF_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0045() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 0;
    var gHeadLength = 0;
    var firstFlag = true;

	var arrPreCond = new Array("", "", "", "");
	var enableButton = new Array("btn_Mail", "btn_Print");
	var bRetrive = false;    

	
	/**
	 * marrTabTitle 과 marrTabTitleKey를 항상 같이 맞춘다.(수정 발생시)
	 * 
	 */
	var marrTabTitle = new Array(	
									"VSL Mvmt",
									"Add Slot",
									"Slot/WGT Util",
									"A K",
									"B/B", 
									"HC/45'",
									"RF",
									"DG",
									"VSL Alloc.",
									"Slot Rel.",
									"Slot Swap", 
									"Load", 
									"IPC Over Used",
									"Remark(s)"
								);

    var marrTabTitleKey = new Array(   
            "VSL_Mvmt",
            "Add_Slot",
            "SlotWGT_Util",
            "AK",
            "BB", 
            "HC45",
            "RF",
            "DG",
            "VSL_Alloc",
            "Slot_Rel",
            "Slot_Swap", 
            "Load", 
            "IPC_Over_Used",
            "Remark"
        );
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         //var prefix = "sheet1_";

    	//try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
	            case "btn_New":
					formObject.vsl_cd.value = "";
					formObject.voy_no.value = "";
					formObject.dir_cd.value = "";
					formObject.region.Code2 = "";
					formObject.next_port.value = "";
					formObject.next_date.value = "";

                    formObject.port_cd.value= "";
                    formObject.port_cd_nm.value = "";
                    
					formObject.opr_cd.removeAll();
					formObject.opr_cd.InsertItem(0, "All", "All");
					formObject.opr_cd.Code = "All";
					bRetrive = false;
 
                    fnSheetClear();
 
					formObject.vsl_cd.focus();
					break;
	            case "vsl_cd_pop":
            		var sUrl = "";
                	var vsl_cd = formObject.vsl_cd.value;
                	
                	if(isNull(vsl_cd)){
                		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                		setRegion();
                	}
	            	break;
	            	
	            case "btn_Retrieve":
					if(!validateForm(formObject)){
						return false;
					}
					
					switch(marrTabTitle[beforetab]){
					  case "VSL Mvmt":
						  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
						  break;
					  case "Add Slot":
						  doActionIBSheet(t2frame.document.t2sheet1, document.form, IBSEARCH, "search02");
						  break;
					  case "Slot/WGT Util":
						  doActionIBSheet(t3frame.document.t3sheet1, document.form, IBSEARCH, "search03");
						  break;
					  case "A K":
						  doActionIBSheet(t4frame.document.t4sheet1, document.form, IBSEARCH, "search04");
						  break;
					  case "B/B":
						  doActionIBSheet(t5frame.document.t5sheet1, document.form, IBSEARCH, "search05");
						  break;
					  case "HC/45'":
						  doActionIBSheet(t6frame.document.t6sheet1, document.form, IBSEARCH, "search06");
						  break;
					  case "RF":
						  doActionIBSheet(t7frame.document.t7sheet1, document.form, IBSEARCH, "search07");
						  break;
					  case "DG":
						  doActionIBSheet(t8frame.document.t8sheet1, document.form, IBSEARCH, "search08");
						  break;
					  case "VSL Alloc.":
						  doActionIBSheet(t9frame.document.t9sheet1, document.form, IBSEARCH, "search09");
						  break;
					  case "Slot Rel.":
						  doActionIBSheet(t10frame.document.t10sheet1, document.form, IBSEARCH, "search10");
						  break;
					  case "Slot Swap":
						  doActionIBSheet(t11frame.document.t11sheet1, document.form, IBSEARCH, "search11");
						  break;
					  case "Load":
						  doActionIBSheet(t12frame.document.t12sheet1, document.form, IBSEARCH, "search12");
						  break;
					  case "IPC Over Used":
						  doActionIBSheet(t13frame.document.t13sheet1, document.form, IBSEARCH, "search13");
						  break;
					  case "Remark(s)":
						  doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, "search14");
						  break;
					}

					break;
					
				case "btn_Mail":
					// add Slot Header
					formObject.f_cmd.value = SEARCH;
					var addHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
					var addSlotHeaderList = ComGetEtcData(addHeaderXml, "operatorList");
    	    		
					var addSlotHeader = addSlotHeaderList.split("|");

					for(var idx = 0; idx < addSlotHeader.length; idx++){
						addSlotHeader[idx] = addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
					}

					// Load Header
	    		    formObject.f_cmd.value = SEARCH19;
    	    		var loadHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
    	    		var loadHeaderList = ComGetEtcData(loadHeaderXml, "operatorList");

    	    		var loadHeader = loadHeaderList.split("|");

    	    		var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
				                    + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
				                    + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
				                    + " ["+(comboObjects[0].Code)+"]"       // 4.Region Code
				                    + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
				                    + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
				                    + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
				                    + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
				                    + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
				                    + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
				                    + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
				                    + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
				                    + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
				                    + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
				                    + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
				                    + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
				                    + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
				                    + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
				                    + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
				                    + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
				                    + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
				                    + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
				                    + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
				                    + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
				                    + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
				                    + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
				                    + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
				                    + " ["+nullParam(addSlotHeader[8])+"]"            // 28.AddSlot Header 9
                                    + " ["+formObject.port_cd.value+"]";            // 5.Port Code
    	    		
					formObject.com_templateMrdArguments.value = rdParam;
                    searchVvdMailInfo();
					//ComSendMail();
					ComSendMailModal();
					break;
					
				case "btn_Print":
					// add Slot Header
					formObject.f_cmd.value = SEARCH;
					var addHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
					var addSlotHeaderList = ComGetEtcData(addHeaderXml, "operatorList");
    	    		
					var addSlotHeader = addSlotHeaderList.split("|");

					for(var idx = 0; idx < addSlotHeader.length; idx++){
						addSlotHeader[idx] = addSlotHeader[idx].substring(0, addSlotHeader[idx].indexOf(","));
					}

					// Load Header
	    		    formObject.f_cmd.value = SEARCH19;
    	    		var loadHeaderXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObject));
    	    		var loadHeaderList = ComGetEtcData(loadHeaderXml, "operatorList");

    	    		var loadHeader = loadHeaderList.split("|");

					var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"    // 1.Vessel Code
				                    + " ["+(formObject.voy_no.value)+"]"    // 2.Voyage Number
				                    + " ["+(formObject.dir_cd.value)+"]"    // 3.Direction
				                    + " ["+(comboObjects[0].Code)+"]"       // 4.Region Code
				                    + " ["+nullParam(loadHeader[0])+"]"            // 5.Load Header 1
				                    + " ["+nullParam(loadHeader[1])+"]"            // 6.Load Header 2
				                    + " ["+nullParam(loadHeader[2])+"]"            // 7.Load Header 3
				                    + " ["+nullParam(loadHeader[3])+"]"            // 8.Load Header 4
				                    + " ["+nullParam(loadHeader[4])+"]"            // 9.Load Header 5
				                    + " ["+nullParam(loadHeader[5])+"]"            // 10.Load Header 6
				                    + " ["+nullParam(loadHeader[6])+"]"            // 11.Load Header 7
				                    + " ["+nullParam(loadHeader[7])+"]"            // 12.Load Header 8
				                    + " ["+nullParam(loadHeader[8])+"]"            // 13.Load Header 9
				                    + " ["+nullParam(loadHeader[9])+"]"            // 14.Load Header 10
				                    + " ["+nullParam(loadHeader[10])+"]"           // 15.Load Header 11
				                    + " ["+nullParam(loadHeader[11])+"]"           // 16.Load Header 12
				                    + " ["+nullParam(loadHeader[12])+"]"           // 17.Load Header 13
				                    + " ["+nullParam(loadHeader[13])+"]"           // 18.Load Header 14
				                    + " ["+nullParam(loadHeader[14])+"]"           // 19.Load Header 15
				                    + " ["+nullParam(addSlotHeader[0])+"]"             // 20.AddSlot Header 1
				                    + " ["+nullParam(addSlotHeader[1])+"]"             // 21.AddSlot Header 2
				                    + " ["+nullParam(addSlotHeader[2])+"]"             // 22.AddSlot Header 3
				                    + " ["+nullParam(addSlotHeader[3])+"]"             // 23.AddSlot Header 4
				                    + " ["+nullParam(addSlotHeader[4])+"]"             // 24.AddSlot Header 5
				                    + " ["+nullParam(addSlotHeader[5])+"]"             // 25.AddSlot Header 6
				                    + " ["+nullParam(addSlotHeader[6])+"]"             // 26.AddSlot Header 7
				                    + " ["+nullParam(addSlotHeader[7])+"]"             // 27.AddSlot Header 8
				                    + " ["+nullParam(addSlotHeader[8])+"]"            // 28.AddSlot Header 9
                                    + " ["+(formObject.port_cd.value)+"]";            // 5.Port Code
 
					formObject.com_mrdArguments.value = rdParam;
					///ComOpenRDPopup();
	                ComOpenRDPopupModal();
					break;

				case "btn_Close":
					window.close();
					break;

            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
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
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(id) {
	    		case "region":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|120")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
	            	//MaxLength = 5;
		            break;
		            
                case "port_cd":
                     SetColWidth("50|230|0")
                     DropHeight = 250;
                     MultiSelect = false;
                     MaxSelect = 1;
                     UseAutoComplete = true;
                     ValidChar(2,0);
                     break;
                     
		        case "opr_cd":
	            	SetTitle("Operator");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		    }
    	}
	}
    
     /**
      * region Code 선택시 해당 Operator Code 가져오기. <br>
      **/
     function region_OnChange(comboObj, idx_cd, text) {
        var formObj = document.form;
        formObj.opr_cd.RemoveAll();
        formObj.opr_cd.InsertItem(0, "All", "All");
        formObj.opr_cd.Index = 0;
          
        fnSheetClear();
        fnGoPortCode();
        

     }
      function fnGoPortCode(){
          var formObj = document.form;
          formObj.port_cd.value = "";
          formObj.port_cd_nm.value = "";
          doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "port_cd");
          
          doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");

      }

      /**
       *  Port Code 변경시 name 셋팅. 
       **/
      function port_cd_OnChange(comboObj, idx_cd, text) {
          var formObj = document.form;
          
          formObj.opr_cd.RemoveAll();
          formObj.opr_cd.InsertItem(0, "All", "All");
          formObj.opr_cd.Index = 0;
          
          
          var aText = text.split("|");
          formObj.port_cd_nm.value = comboObj.GetIndexText( comboObj.Index, 1  );
 
          if(text == ""){return;}
          doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");
      }
       function opr_cd_OnChange(comboObj, idx_cd, text) {
           fnSheetClear();
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
					for(; cnt < marrTabTitle.length; cnt++){
						InsertTab(cnt, marrTabTitle[cnt], -1);
					}
                }
             break;

         }
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
 
    }
     
     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnClick(tabObj , nItem)
     {

		  if(nItem == beforetab){
			  return;
		  }

		  var objs = document.all.item("tabLayer");
		  
		  objs[beforetab].style.display = "none";
		  objs[nItem].style.display = "Inline";

		  //--------------- 요기가 중요 --------------------------//
		  objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		  //------------------------------------------------------//
		  beforetab= nItem;
 
		  switch(marrTabTitle[beforetab]){
			  case "VSL Mvmt":
    				  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
    				  break;
			  case "Add Slot":
    				var frame = document.getElementById("t2frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t2frame.document.t2sheet1, document.form, IBSEARCH, "search02");
    				}
    				break;
			  case "Slot/WGT Util":
    				var frame = document.getElementById("t3frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t3frame.document.t3sheet1, document.form, IBSEARCH, "search03");
    				}
			  case "A K":
    				var frame = document.getElementById("t4frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive){
    						doActionIBSheet(t4frame.document.t4sheet1, document.form, IBSEARCH, "search04");
    					}else{
    					    goDetail(frame, beforetab);
    					}
    				}
    				break;
			  case "B/B":
    				var frame = document.getElementById("t5frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t5frame.document.t5sheet1, document.form, IBSEARCH, "search05");
    				}
    				break;
			  case "HC/45'":
    				var frame = document.getElementById("t6frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t6frame.document.t6sheet1, document.form, IBSEARCH, "search06");
    				}
    				break;
			  case "RF":
    				var frame = document.getElementById("t7frame");
    			    if(frame.src == ""){
    					goRefer(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t7frame.document.t7sheet1, document.form, IBSEARCH, "search07");
    				}
    				break;
			  case "DG":
    				var frame = document.getElementById("t8frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t8frame.document.t8sheet1, document.form, IBSEARCH, "search08");
    				}
    				break;
			  case "VSL Alloc.":
    				var frame = document.getElementById("t9frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t9frame.document.t9sheet1, document.form, IBSEARCH, "search09");
    				}
    				break;
			  case "Slot Rel.":
    				var frame = document.getElementById("t10frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t10frame.document.t10sheet1, document.form, IBSEARCH, "search10");
    				}
    				break;
			  case "Slot Swap":
    				var frame = document.getElementById("t11frame");
    			    if(frame.src == ""){
    					goDetail(frame, beforetab);
    					return;
    				}else{
    					if(bRetrive)
    						doActionIBSheet(t11frame.document.t11sheet1, document.form, IBSEARCH, "search11");
    				}
    				break;
			  case "Load":
				var frame = document.getElementById("t12frame");
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t12frame.document.t12sheet1, document.form, IBSEARCH, "search12");
				}
				break;
			  case "IPC Over Used":
				var frame = document.getElementById("t13frame");
			    if(frame.src == ""){
					goDetail(frame, beforetab);
					return;
				}else{
					if(bRetrive)
						doActionIBSheet(t13frame.document.t13sheet1, document.form, IBSEARCH, "search13");
				}
				break;
			  case "Remark(s)":
				  doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, "search14");
				  break;
		  }

		  //top.syncHeight();
     }
     
	 function goDetail(objFrame, nItem){
		 objFrame.src = "VOP_OPF_0045_Dtl.do?nItem=" + nItem;
	 }

	 function goRefer(objFrame, nItem){
		 objFrame.src = "VOP_OPF_0045_07.do?nItem=" + nItem;
 
	 }
 
    /**
   	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackVSL(aryPopupData) {
 		document.form.vsl_cd.value = aryPopupData[0][1];
 		//ComSetFocus(document.form.voy_no);
 		document.form.voy_no.focus();
   	} 
   	
    /**
   	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} obj
   	 */
   	function setCallBackVVD(aryPopupData) {
 		document.form.voy_no.value = aryPopupData[0][2];
 		document.form.dir_cd.value = aryPopupData[0][3];
 		//ComSetFocus(document.form.region);
// 		document.form.region.focus();
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
 		for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
        }
 		//Combo 초기화
     	for(var m=0; m<comboObjects.length; m++){
         	initCombo(comboObjects[m]);
        }
 		
 		initControl();
 		
 		// Default Combo Data조회.
// 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "Combo");
 		document.form.vsl_cd.focus();
        document.form.opr_cd.InsertItem(0, "All", "All");
        document.form.opr_cd.Code = "All";

		for( var k = 0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
		
		var formObj = document.form;
		
		/************************************/
		if (formObj.popYn.value == "Y" ){
		    formObj.vsl_cd.value = preConds.vsl_cd;
            formObj.voy_no.value = preConds.voy_no;
            formObj.dir_cd.value = preConds.dir_cd;
            formObj.region.Code  = preConds.region;
            if(  preConds.joo_init_tab != ""  ){
                goTabMoveByJoo(preConds.joo_init_tab);
            }
		}
 	}
    /**
     * 
     * <pre>
     *    공동운항에서 RDR Inquiry를 참조시, 해당되는 탭으로 자동 이동처리.
     * </pre>
     *
     * @param  pageName
     * @author jang kang cheol
     */
    function goTabMoveByJoo(pageName){
        for(var i=0;i<marrTabTitleKey.length;i++){
            if( marrTabTitleKey[i] == pageName ){
                tab1_OnClick( tabObjects[0] , i);
                tabObjects[0].SelectedIndex = i;
                return;
            }
        }
    }
     
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl(){
 
     	//Code 입력 시 영문대문자만 or 숫자만 입력하기
     	axon_event.addListener  ('keypress', 'obj_keypress', 'vsl_cd'
     														, 'voy_no'
     														, 'dir_cd');
     	 
     	axon_event.addListener  ('keyup', 'obj_keyup', 'vsl_cd'
													 , 'voy_no'
													 , 'dir_cd');
     	
     	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
     	
     	axon_event.addListener  ('change' , 'change_event', 'vsl_cd'
				 										   , 'voy_no');
     	
     	axon_event.addListener  ('blur'  , 'blur_event', 'dir_cd');
     	
     	axon_event.addListener  ('focus' , 'focus_event', 'vsl_cd'
														 , 'voy_no'
														 , 'dir_cd');
     }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     function obj_keypress() {

         if(event.srcElement.name=="vsl_cd")
         {
        	//문자/숫자만 입력가능.
        	 ComKeyOnlyAlphabet('uppernum');
         }else if(event.srcElement.name=="voy_no")
         {
        	//숫자만 입력가능.
          	ComKeyOnlyNumber(event.srcElement);
         }
         else{
        	//영대문자만 입력가능.
          	ComKeyOnlyAlphabet('upper');
         }
         
         ComKeyEnter();
     }
     
 
     /**
      * Form Object  keydown 이벤트시 처리
      * @param  void
      * @return void
      */     
      function obj_keyup(){
           
           var obj = event.srcElement;
           var formObj = document.form;

           switch (obj.name){
 
              case 'vsl_cd':
                    var objMaxLength = obj.getAttribute("maxLength");

                    if (ComChkLen(obj.value, objMaxLength) == 2) {
                        ComSetNextFocus(obj);
                    }
                    ComClearObject(formObj.voy_no);
                    ComClearObject(formObj.dir_cd);
                    
                    formObj.region.Code2 = "";
                    formObj.port_cd.value= "";
                    formObj.port_cd_nm.value = "";
                    
                    fnSheetClear();
                    break;
                    
              case 'voy_no':
                    var objMaxLength = obj.getAttribute("maxLength");
                    if (ComChkLen(obj.value, objMaxLength) == 2) {
                        ComSetNextFocus(obj);
                    }
                    ComClearObject(formObj.dir_cd);
                    formObj.region.Code2 = "";
                    formObj.port_cd.value= "";
                    formObj.port_cd_nm.value = "";
                    
                    fnSheetClear();
                    break;
                    
              case 'dir_cd':
                    formObj.region.Code2 = "";
                    formObj.port_cd.value= "";
                    formObj.port_cd_nm.value = "";
                    fnSheetClear();
                    break;
           }
           // Focus 이동..
           ComKeyEnter('LengthNextFocus');
      }
    /**
     * HTML Control의 onfocus이벤트에서 블럭설정. <br>
     **/
    function focus_event(){
 
        event.srcElement.select();
    }
    
    /**
     * HTML Control의 change이벤트에서 특정 폼 reset설정. <br>
     **/
    function change_event(){
    	var elementObj = event.srcElement;
    	var formObj = document.form;
    	
    	if(elementObj.name=="vsl_cd"){
    		formObj.voy_no.value = "";
    		formObj.dir_cd.value = "";
    	}
    	else if(elementObj.name=="voy_no")
        {
    		formObj.dir_cd.value = "";
        }
    }
     
    /**
     * HTML Control의 blur이벤트에서 특정 폼 Validation 체크. <br>
     **/
    function blur_event(){
    	var elementObj = event.srcElement;
    	var formObj = document.form;
    	
    	if(elementObj.name=="dir_cd" 
    		&& !isNull(formObj.vsl_cd.value)
    		&& !isNull(formObj.voy_no.value)
    		&& !isNull(formObj.dir_cd.value))
    	{
    		sheetObjects[0].WaitImageVisible = false;
		
			formObj.f_cmd.value = SEARCH06;
			formObj.skd_voy_no.value = formObj.voy_no.value;
			formObj.skd_dir_cd.value = formObj.dir_cd.value;
			
			var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));

			var vvdData = ComOpfXml2Array(sXml, "vsl_cd|skd_voy_no|skd_dir_cd");
			 
			if(vvdData == null) {
				ComShowCodeMessage("COM132201", "Data");

				formObj.vsl_cd.value = "";
        		formObj.voy_no.value = "";
        		formObj.dir_cd.value = "";
                formObj.region.Code2 = "";
        		formObj.port_cd.value= "";
        		formObj.port_cd_nm.value = "";
                
        		formObj.vsl_cd.focus();
        		return false;
			}else{
				if(vvdData.length > 1) {
	    			ComShowCodeMessage("COM132201", "Data");

					formObj.vsl_cd.value = "";
					formObj.voy_no.value = "";
					formObj.dir_cd.value = "";
                    formObj.region.Code2 = "";
	                formObj.port_cd.value= "";
	                formObj.port_cd_nm.value = "";
	                
	                
					formObj.vsl_cd.focus();
					return false;
				} else {
					setRegion();
					return true;
				}
			}

    	}
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo, headTitleList) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "t1sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
                    
                    var HeadTitle = "|Port|Arrival Time|Berthing Time|Unberthing Time|Departure Time";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t1sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	195,	daCenter,		true,	prefix+"port",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	195,	daCenter,		true,	prefix+"arr_time",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	195,	daCenter,		true,	prefix+"berth_time",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	195,	daCenter,		true,	prefix+"unberth_time", 	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	180,	daCenter,		true,	prefix+"dep_time",  	false,	"",		dfNone,		0,	false,	false);
                    
				}
                break;
                
            case "t2sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
                    
                    //var HeadTitle = "|POL|POD|SML";
					var HeadTitle = "|POL|POD";
                    
                    if(!isNull(headTitleList)){
                    	for(var hh=0; hh < headTitleList.length; hh++){
                    		HeadTitle = HeadTitle+"|"+headTitleList[hh];
                    	}
                    }
                    HeadTitle = HeadTitle+"|Total";
                    
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t2sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daCenter,		true,	prefix+"pol",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daCenter,		true,	prefix+"pod",  			false,	"",		dfNone,		0,	false,	false);
 
                    if(!isNull(headTitleList)){
                    	for(var hh=0; hh < headTitleList.length; hh++){
							var col_fix = (hh + 1 < 10 ? "0" + (hh + 1) : hh + 1);
                    		InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	true,	prefix + "opr_qty_" + col_fix ,  	false,	"",		dfNumber,		0,	false,	false);
                    	}
                    }
					
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	true,	prefix+"total",  	false,	"",		dfNumber,		0,	false,	false);
				}
                break;
                
            case "t3sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Operator|Full|Empty|Additional\n(AK/BB)|Additional\n(HC/45')|Total Used Slot|Total Used Slot";
					var HeadTitle2 = "|Operator|Full|Empty|Additional\n(AK/BB)|Additional\n(HC/45')|Slot (TEU)|Weight (Ton)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t3sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		190,	daCenter,	true,	prefix+"opr_cd",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"full",			false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"empty",			false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"akbb",			false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"hc45",			false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"total_slot",	false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	130,	daRight,	true,	prefix+"total_wgt",		false,	"",		dfFloat,	1,	false,	false);
                    
                    HeadRowHeight = 20;
					RowHeight(0) = 20;
					RowHeight(1) = 20;
				}
                break;
                
            case "t4sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
					var HeadTitle2 = "|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|OF|OA|OP|OS|OH|Void (TEU)|Weight (Ton)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t4sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"opr_cd",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"pol",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"pod",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	110,	daCenter,		true,	prefix+"cntr_no",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,		daCenter,		true,	prefix+"type_size", false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"cell_no",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"ovf",  		false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"oa",  		false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"op",  		false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"os",  		false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"oh",  		false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,		daRight,		true,	prefix+"void_teu",  false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"weight",  	false,	"",		dfFloat,	1,	false,	false);
                    
				}
                break;
                
            case "t5sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo";
					var HeadTitle2 = "|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|Dimension|Dimension|Dimension|Weight|Slot|Crane|Working (fm)|Working (to)";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t5sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"opr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	75,		daCenter,		true,	prefix+"pol",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	75,		daCenter,		true,	prefix+"pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,	prefix+"cntr_no",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,		daCenter,		true,	prefix+"type_size", false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,		daCenter,		true,	prefix+"cell_no",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,		daRight,		true,	prefix+"dml",  		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,		daRight,		true,	prefix+"dmb",  		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,		daRight,		true,	prefix+"dmh",  		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	60,		daRight,		true,	prefix+"weight",  	false,	"",	dfNumber,	0,	false,	false);
                    //InitDataProperty(0, cnt++ , dtData,	45,		daRight,		true,	prefix+"unit",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	45,		daRight,		true,	prefix+"slot",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	45,		daRight,		true,	prefix+"crane",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daCenter,		true,	prefix+"fm_work",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,		daCenter,		true,	prefix+"to_work",  	false,	"",	dfNone,		0,	false,	false);
                    
				}
                break;
                
            case "t6sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 10, 100);
                    
                    var HeadTitle1 = "|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR";
					var HeadTitle2 = "|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45’|45’|45’|45’|45’|Ratio Type";
					var HeadTitle3 = "|Operator|Loaded|BSA\n(T)|Over Ratio\n(T)|Add Slot\n(T)|Loaded|BSA\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Loaded|BSA\n(F)|Under Ratio\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Ratio Type";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t6sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"opr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	55,		daRight,	true,	prefix+"load_20",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	true,	prefix+"hc20_qty",  false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	prefix+"hc20_rate", false,	"",	dfFloat,	3,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	true,	prefix+"add_20",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	55,		daRight,	true,	prefix+"load_40",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	true,	prefix+"hc40_qty",  false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	prefix+"hc40_rat",  false,	"",	dfFloat,	3,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	true,	prefix+"add_40",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	55,		daRight,	true,	prefix+"load_45",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	true,	prefix+"bsa_45",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData   ,	85,		daRight,	true,	prefix+"un_rat_45", false,	"",	dfFloat,	3,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	prefix+"ov_rat_45", false,	"",	dfFloat,	3,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	true,	prefix+"add_45",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	prefix+"ratio_type",false,	"",	dfNone,		0,	false,	false);
                    
				}
                break;
                
            case "t7sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade";
					var HeadTitle2 = "|Operator|POL|POD|20ft Qty|40ft Qty";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t7sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"opr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"pol",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	false,	prefix+"qty_20",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"qty_40",  	false,	"",	dfNumber,	0,	false,	false);
                    
				}
                break;
                
            case "t7sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Inter Port|Inter Port|Inter Port|Inter Port|Inter Port";
					var HeadTitle2 = "|Operator|POL|POD|20ft Qty|40ft Qty";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t7sheet2_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"opr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"pol",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	false,	prefix+"qty_20",  	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"qty_40",  	false,	"",	dfNumber,	0,	false,	false);
                    
				}
                break;
                
            case "t8sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo";
					var HeadTitle2 = "|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|IMO|UN No.|Weight (Ton)";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t8sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"opr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"pol",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	110,	daCenter,	false,	prefix+"cntr_no",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"type_size", false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"cell_no",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"imo",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix+"un_no",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,	false,	prefix+"weight",  	false,	"",	dfFloat,	0,	false,	false);
				}
                break;
                
            case "t9sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA\nType";
					var HeadTitle2 = "|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic Weight|Weight Swap|Weight Release|TTL Weight|Weight\nper TEU|BSA\nType";

					var headCount = ComCountHeadTitle(HeadTitle1);
					var headCount2 = ComCountHeadTitle(HeadTitle2);
					
					//alert("headCount = " + headCount + ", headCount2 = " + headCount2);


                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t9sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	prefix+"opr_cd",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"basic_slot",  	false,	"",	dfInteger,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,     daRight,    false,  prefix+"swap_slot",     false,  "", dfInteger,  0,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"release_slot",  false,	"",	dfInteger,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"tot_alloc",  	false,	"",	dfInteger,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"basic_wgt",  	false,	"",	dfInteger,	1,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  90,     daRight,    false,  prefix+"swap_wgt",      false,  "", dfInteger,  1,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"release_wgt",  	false,	"",	dfInteger,	1,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	90,		daRight,	false,	prefix+"tot_wgt",  		false,	"",	dfInteger,	1,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	    90,		daRight,	false,	prefix+"teu_wgt",  		false,	"",	dfFloat,	3,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,	90,		daCenter,	false,	prefix+"bsa_type",  	false,	"",	dfNone,		0,	false,	false);

					InitDataCombo(0, prefix + "bsa_type", "Fixed|Used", "F|U");
                    
					SetMergeCell(0, 10, 2, 1);
					SetMergeCell(0, 11, 2, 1);
				}
                break;
                
            case "t10sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release";
					var HeadTitle2 = "|From Carrier|From Carrier|To Carrier|To Carrier|TEU|Weight (Ton)|Type";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t10sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"fm_carr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"fm_carr_nm",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"to_carr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"to_carr_nm",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		150,	daRight,	false,	prefix+"teu",  			false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		150,	daRight,	false,	prefix+"weight",  		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,	100,	daCenter,	false,	prefix+"type",  		false,	"",	dfNone,		0,	false,	false);

					InitDataCombo(0, prefix + "type", "Fixed|Used", "F|U");
                    
				}
                break;
                
            case "t11sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 10, 100);
                    
                    var HeadTitle1 = "|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap";
					var HeadTitle2 = "|Seq.|From|From|To|To|TEU|Weight (Ton)";
					var HeadTitle3 = "|Seq.|Carrier Code|VVD|Carrier Code|VVD|TEU|Weight (Ton)";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t11sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,	prefix+"Seq");
                    InitDataProperty(0, cnt++ , dtData,	150,	daCenter,	false,	prefix+"fm_carr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	150,	daCenter,	false,	prefix+"fm_vsl_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	150,	daCenter,	false,	prefix+"to_carr_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	150,	daCenter,	false,	prefix+"to_vsl_cd",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	150,	daRight,	true,	prefix+"teu",  			false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	150,	daRight,	true,	prefix+"weight",  		false,	"",	dfNumber,	0,	false,	false);
                    
				}
                break;
                
            case "t12sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|Operator|POD|FE/Size|FE/Size";
                    if(!isNull(headTitleList)){
                    	for(var a=0; a < headTitleList.length; a++){
                        	HeadTitle1 = HeadTitle1+"|POL"
                        }
                    }
                    HeadTitle1 = HeadTitle1+"|TOTAL|TOTAL";
                    
                    var HeadTitle2 = "|Operator|POD|FE/Size|FE/Size";
                    if(!isNull(headTitleList)){
                    	for(var b=0; b < headTitleList.length; b++){
                    		HeadTitle2 = HeadTitle2+"|"+headTitleList[b];
                    	}
                    }
                    HeadTitle2 = HeadTitle2+"|Volumn|Weight";
                    
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t12sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"opr_cd",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	prefix+"pod",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	prefix+"cntr_type",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	prefix+"cntr_size",  	false,	"",		dfNone,		0,	false,	false);
                    if(!isNull(headTitleList)){
                        gHeadLength = headTitleList.length;
                    	for(var c=0; c < headTitleList.length; c++){
							var colNm = prefix + "pol_qty_" + ( c + 1 < 10  ? "0" + (c + 1) : c + 1);
                    		InitDataProperty(0, cnt++ , dtData,	90,	daRight,	false,	 colNm,  false,	"",	dfNone,	0,	false,	false);
                    	}
                    }
                    InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	prefix+"total_vol", 	false,	"",		dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	prefix+"total_wgt", 	false,	"",		dfFloat,	1,	false,	false);
                    
                    SetMergeCell(0,1,2,1);
                    SetMergeCell(0,2,2,1);
                    SetMergeCell(0,3,2,2);
 
 
				}
                break;
                
            case "t13sheet1":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Operator|From Port|To Port|BSA (+ Slot Swap)|BSA (+ Slot Swap)|Used Slot|Used Slot|Slot(TEU)|WGT(TEU)|Slot Release|Slot Release|Settlement|Settlement";
					//var HeadTitle2 = "|Operator|From Port|To Port|Slot (TEU)|WGT (M/T)|Slot (TEU)|WGT (M/T)|Slot (TEU)|WGT (M/T)|Slot (TEU)|WGT (M/T)|Slot (TEU)|By";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t13sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		72,		daCenter,	true,	prefix+"opr_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		72,		daCenter,	true,	prefix+"from_pod",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		72,		daCenter,	true,	prefix+"to_pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"bsa_slot",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"bsa_wgt",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"used_slot",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"used_wgt",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		172,		daRight,	true,	prefix+"over_slot",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		172,		daRight,	true,	prefix+"over_wgt",		false,	"",	dfNumber,	0,	false,	false);


					InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"release_slot",	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"release_wgt",	false,	"",	dfNumber,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	72,		daRight,	true,	prefix+"over_set_slot",	false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,	72,		daCenter,	true,	prefix+"over_set_by",	false,	"",	dfNone,		0,	false,	false);

					HeadRowHeight = 20;
//					RowHeight(0) = 20;
//					RowHeight(1) = 20;

					InitDataCombo(0, prefix + "over_set_by", "Fixed|Used", "F|U");

/*

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Operator|From Port|To Port|Slot(TEU)|WGT(Ton)|Settlement";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t13sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	prefix+"opr_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		180,	daCenter,	true,	prefix+"from_pod",  	false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,		180,	daCenter,	true,	prefix+"to_pod",  		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	180,	daRight,	true,	prefix+"slot_teu",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSum,	180,	daRight,	true,	prefix+"slot_ton",		false,	"",	dfNumber,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,	180,	daCenter,	false,	prefix+"bsa_type",  	false,	"",	dfNone,		0,	false,	false);

*/
					
				}
                break;

            case "t14sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
                    
                    var HeadTitle1 = "|Remark";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="t14sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	false,	prefix+"remark",  	false,	"",	dfNone,		0,	false,	false);
				}
                break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
    //	sheetObj.ShowDebugMsg = false;
        if(sheetObj == null){
            return;
        }
	    switch(sAction) {
 
	      case IBSEARCH:
	    	  var sheetID = sheetObj.id;
			  var changeCond = false;
			  
			  
              formObj.f_cmd.value = SEARCH14;
              sheetObjects[1].DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_"));
              if(sheetObjects[1].RowCount > 0){
                for( var k = 0; k < enableButton.length; k++){
                    ComBtnEnable(enableButton[k]);
                }
              }else{
                for( var k = 0; k < enableButton.length; k++){
                    ComBtnDisable(enableButton[k]);
                }
              }
			  
			  
			  if(strFlag != "Combo" && strFlag !="oprCd"){
				  if(arrPreCond[0] == document.form.vsl_cd.value)
					  changeCond = true;

				  if(arrPreCond[1] == document.form.voy_no.value)
					  changeCond = true;

				  if(arrPreCond[2] == document.form.dir_cd.value)
					  changeCond = true;

				  if(arrPreCond[3] == document.form.region.Code)
					  changeCond = true;
				  
 
			  }


//	    	  if(strFlag=="Combo"){
//    	  	        formObj.f_cmd.value = SEARCH;
//    	  	        var comboXml = sheetObj.GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObj));
//    	  	        
//    	  	        // 1. Region Combo Data Set..
//    		    	var regionList = ComGetEtcData(comboXml, "regionList");
//    		    	if(regionList==null || regionList.length<1){
//    		    		comboObjects[0].RemoveAll();
//    		    		return false;
//    		    	}else{
//    		    		setComboItem2(comboObjects[0], regionList);
//    		    	}
//	    	  } else 
	    		if(strFlag=="oprCd"){
	    		   formObj.f_cmd.value = SEARCH;
		  	       var comboXml = sheetObj.GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObj));
		  	     
    	    		// 2. Operator Combo Data Set..
    		    	var operatorList = ComGetEtcData(comboXml, "operatorList");
    		    	if(operatorList==null || operatorList.length<1){
    	    			//ComShowCodeMessage("OPF07001", "Operator");
    		    		formObj.opr_cd.RemoveAll();
    		    		formObj.opr_cd.InsertItem(0, "All", "All");
    		    		formObj.opr_cd.Index = 0;
    		    		//return false;
    		    	}else{
    		    		setComboItem(formObj.opr_cd, operatorList);
    		    		formObj.opr_cd.InsertItem(0, "All", "All");
    		    		formObj.opr_cd.Index = 0;
    		    	}

	    	  }else if(strFlag=="search01"){
	    		  formObj.f_cmd.value = SEARCH01;
	    		  sheetObj.WaitImageVisible = true;
				  var sXml = sheetObj.GetSearchXml("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"));

				  sheetObj.Redraw = false;    
				  sheetObj.WaitImageVisible = false;	
				  sheetObj.LoadSearchXml(sXml); 
				  sheetObj.Redraw = true; 

		  	      if(sheetObjects[1].RowCount > 0 && ComGetEtcData(sXml, "NEXT_PORT") != null && ComGetEtcData(sXml, "NEXT_PORT") != "undefined"){
					  document.form.next_port.value = ComGetEtcData(sXml, "NEXT_PORT"); 	    
					  document.form.next_date.value = ComGetEtcData(sXml, "ETA"); 	    
					  document.form.next_canal.value = ComGetEtcData(sXml, "NEXT_CANAL"); 	    
					  document.form.eta_canal.value  = ComGetEtcData(sXml, "ETA_CANAL"); 	    
				  }else{
					  document.form.next_port.value = ""; 	    
					  document.form.next_date.value = ""; 	    
					  document.form.next_canal.value = ""; 	    
					  document.form.eta_canal.value = ""; 	    
				  }
	    	  }
	    	  else if(strFlag=="search02"){
	    		  // *** 그리드 가변 해더 조회.
	    		  formObj.f_cmd.value = SEARCH20;
 

	    		  var headerXml = sheetObjects[0].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObj));
	    		  var dataList = ComGetEtcData(headerXml, "operatorList");
 
	    			  var headerList = dataList.split("|");
	    			  // 1. sheet 초기화..
	    			  sheetObj.Reset();
	    		  	  ComConfigSheet (sheetObj);
	    			  initSheet(sheetObj,2, headerList);
	    		  	  ComEndConfigSheet(sheetObj);
 
	    			  // 2. param data set..
	    		  	  var paramQty = "&qty1=SML";
	    			  for(var n=0; n < headerList.length; n++){
	    				  paramQty = paramQty +"&"+"qty"+(n+2)+"="+ headerList[n];
	    			  }
 
	    			  // 3.*** 데이터 조회.
			  	      formObj.f_cmd.value = SEARCH02;
			  	      var par = FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_") + paramQty;
 
			  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", par );
 
	    		  //}
	    	  }
	    	  else if(strFlag=="search03"){
	    		  formObj.f_cmd.value = SEARCH03;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_"));
	    	  }
	    	  else if(strFlag=="search04"){
	    		  formObj.f_cmd.value = SEARCH04;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_"));
	    	  }
	    	  else if(strFlag=="search05"){
	    		  formObj.f_cmd.value = SEARCH05;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t5sheet1_"));
	    	  }
	    	  else if(strFlag=="search06"){
	    		  formObj.f_cmd.value = SEARCH06;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t6sheet1_"));
	    	  }
	    	  else if(strFlag=="search07"){
	    		  formObj.f_cmd.value = SEARCH07;
	    		  var aryPrefix = new Array("t7sheet1_","t7sheet2_");
	  	    	  var sXml = sheetObj.GetSearchXml("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	  	    	  var arrXml = sXml.split("|$$|");

	              if (arrXml.length > 0) t7frame.document.t7sheet1.LoadSearchXml(arrXml[0]);
	              if (arrXml.length > 1) t7frame.document.t7sheet2.LoadSearchXml(arrXml[1]);
 
	    	  }
	    	  else if(strFlag=="search08"){
	    		  formObj.f_cmd.value = SEARCH08;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t8sheet1_"));
	    	  }
	    	  else if(strFlag=="search09"){
	    		  formObj.f_cmd.value = SEARCH09;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t9sheet1_"));
	    	  }
	    	  else if(strFlag=="search10"){
	    		  formObj.f_cmd.value = SEARCH10;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t10sheet1_"));
	    	  }
	    	  else if(strFlag=="search11"){
	    		  formObj.f_cmd.value = SEARCH11;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t11sheet1_"));
	    	  }
	    	  else if(strFlag=="search12"){
 
	    		  // *** 그리드 가변 해더 조회.
	    		  formObj.f_cmd.value = SEARCH19;
	    		  var headerXml = sheetObjects[0].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObj));
	    		  var dataList = ComGetEtcData(headerXml, "operatorList");
    			  var headerList = dataList.split("|");

    			  // 1. sheet 초기화..
    			  sheetObj.Reset();
    		  	  ComConfigSheet (sheetObj);
    			  initSheet(sheetObj, 12, headerList);
 
    		  	  ComEndConfigSheet(sheetObj);
    			  // 2. param data set..
    		  	  var paramQty = "";
    			  for(var n=0; n < headerList.length; n++){
    				  paramQty = paramQty +"&"+"qty"+(n+1)+"="+ headerList[n];
    			  }

				  if(dataList == ""){
					sheetObj.LoadSearchXml(headerXml); 
				  }else{
					  // 3.*** 데이터 조회.
					  formObj.f_cmd.value = SEARCH12;
					  sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t12sheet1_")+paramQty);
					  fnLoadMerge(sheetObj);
				  }
	    	  }
	    	  else if(strFlag=="search13"){
	    		  formObj.f_cmd.value = SEARCH13;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t13sheet1_"));
	    	  }
	    	  else if(strFlag=="search14"){
	    		  formObj.f_cmd.value = SEARCH14;
		  	      sheetObj.DoSearch("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_"));
				  var strRemark = "";
					
				  if(sheetObj.RowCount > 0){
					  strRemark = sheetObj.CellValue(sheetObj.HeaderRows, "t14sheet1_remark");
				  }
	    		  formObj.remark.value = strRemark;
	    	  }
	    	  else if(strFlag=="port_cd"){
              /********************Get Port Code Combo List Start  Edit By JKC********************/
 
                  formObj.f_cmd.value = SEARCH14;
                  var sXml = sheetObjects[1].GetSearchXml("VOP_OPF_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t14sheet1_"));
                  formObj.port_cd.value = "";
                  formObj.port_cd_nm.value = "";
                  if(  ComGetTotalRows(sXml) > 0 ){
                      formObj.port_cd.value    =   ComGetEtcData(sXml, "port_cd");
                      formObj.port_cd_nm.value =   ComGetEtcData(sXml, "port_cd_nm");
                  } 
 
              /********************Get Port Code Combo List End ********************/
	          }
			  //조회 조건 변동시 체크하기 위하여.
			  arrPreCond[0] = document.form.vsl_cd.value;
			  arrPreCond[1] = document.form.voy_no.value;
			  arrPreCond[2] = document.form.dir_cd.value;
			  arrPreCond[3] = document.form.region.Code;
			  
			  if(strFlag != "Combo" && strFlag !="oprCd")
				bRetrive = true;

			  break;
	        
	    }
	}
    function fnLoadMerge(sheetObj){
        var prefix = sheetObj.id+"_";
        for(var i=0;i<= sheetObj.LastRow; i++){
            if(  sheetObj.CellValue(i,  prefix+"cntr_type") ==  sheetObj.CellValue(i,  prefix+"cntr_size")
                &&   sheetObj.CellValue(i,  prefix+"cntr_type") == "WEIGHT"    
               ){
                sheetObj.SetMergeCell(i, sheetObj.SaveNameCol( prefix+"cntr_type" ), 1, 2 );
            }
        }        
    }
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			 ColBackColor("t1sheet1_port") = RgbColor(204, 255, 253);
		}
	}
	
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		 	ColBackColor("t2sheet1_pol") = RgbColor(204, 255, 253);
		    ColBackColor("t2sheet1_pod") = RgbColor(204, 255, 253);
			
			SumText(0, "t2sheet1_pol") = "Total";
		}
	}
	
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		 	 ColBackColor("t3sheet1_opr_cd") = RgbColor(204, 255, 253);
			
			SumText(0, "t3sheet1_opr_cd") = "Total";
		}
	}
	
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		   ColBackColor("t4sheet1_opr_cd") = RgbColor(204, 255, 253);
		}
	}
	 
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    ColBackColor("t5sheet1_opr_cd") = RgbColor(204, 255, 253);
		}
	}
	 
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    ColBackColor("t6sheet1_opr_cd") = RgbColor(204, 255, 253);
			
			SumText(0, "t6sheet1_opr_cd") = "Total";
		}
	}
	
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    ColBackColor("t7sheet1_opr_cd") = RgbColor(204, 255, 253);
			
			SumText(0, "t7sheet1_opr_cd") = "Total";
			SumText(0, "t7sheet1_pol") = "Total";
			SumText(0, "t7sheet1_pod") = "Total";
			
			RowMerge(LastRow) = true;
		}
	}
	
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t7sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	        ColBackColor("t7sheet2_opr_cd") = RgbColor(204, 255, 253);
			
			SumText(0, "t7sheet2_opr_cd") = "Total";
			SumText(0, "t7sheet2_pol") = "Total";
			SumText(0, "t7sheet2_pod") = "Total";
			
			RowMerge(LastRow) = true;
		}
	}
	 
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t8sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	       ColBackColor("t8sheet1_opr_cd") = RgbColor(204, 255, 253);
		}
	}
	 
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t9sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	        ColBackColor("t9sheet1_opr_cd") = RgbColor(204, 255, 253);
			SumText(0, "t9sheet1_opr_cd") = "Total";
		}
	}
	 
	/**
	 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function t12sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			//CellValue2(LastRow, "t12sheet1_cntr_type") = CellValue(LastRow, "t12sheet1_cntr_size");
			// 마지막 합계 셀 컬럼 머지.
			if(RowCount > 1){
				SetMergeCell(LastRow-5,1,6,2);
				SetMergeCell(LastRow-5,3,5,1);
				SetMergeCell(LastRow  ,3,1,2);
			}
		}
	}
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0], comboItem[0]);
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
    	 //alert("validateForm Event!!");
//        if(!ComChkValid(formObj))
//        {
//        	return false;
//        }
    	if(isNull(formObj.vsl_cd.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		formObj.vsl_cd.focus();
        	return false;
    	}
    	else if(isNull(formObj.voy_no.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		formObj.voy_no.focus();
        	return false;
    	}
    	else if(isNull(formObj.dir_cd.value)){
    		ComShowCodeMessage("COM130201", "VVD CD");
    		formObj.dir_cd.focus();
        	return false;
    	}
        else if(isNull(comboObjects[0].Code)){
        	//ComShowMessage("\'Region\' is mandatory item.");
			ComShowCodeMessage("COM130201", "Region");
        	//ComSetFocus(formObj.region);
			formObj.region.focus();
        	return false;
        }
        else if(isNull(formObj.opr_cd.Code)){
        	//ComShowMessage("\'Operator\' is mandatory item.");
			ComShowCodeMessage("COM130201", "Operator");
        	//ComSetFocus(formObj.opr_cd);
        	formObj.opr_cd.focus();
        	return false;
        }
        else if(isNull(formObj.port_cd)){
            ComShowCodeMessage("COM130201", "Port Code");
           // formObj.port_cd.focus();
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
     
     /**
      * 화면 폼입력값에 Null Check
      */
     function nullParam(itemValue){
    	 
         if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	 return "";
         }
         else{
        	 return itemValue;
         }
     }
      function searchVvdMailInfo(){
          var formObj = document.form;
          formObj.f_cmd.value = SEARCH06;
          var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));    
   
          //Mail Subject에 사용하기위해.
          var dataColNm = "vsl_slan_cd|vsl_eng_nm|skd_voy_no|skd_dir_cd";
          var vvdInfoData = ComOpfXml2Array(sXml, dataColNm);
          var aVvdInfoData = vvdInfoData[0];
          //[FEX TDR] M/V HANJIN ROME 0012W, ASIA
          var s = "["+aVvdInfoData[0]+" RDR] M/V "+aVvdInfoData[1]+" "+aVvdInfoData[2]+aVvdInfoData[3]+", "+formObj.region.Text;
   
          formObj.com_subject.value = s;
      }
      function fnSheetClear() {
          var formObj = document.form;
          for(var idxSht = 0; idxSht < sheetObjects.length; idxSht++){
              sheetObjects[idxSht].RemoveAll();
          }
 
          //t2frame
          for(var idxSht = 2; idxSht <= 13; idxSht++){
              var subFrameObj = document.getElementById(  't'+idxSht+'frame'  );
              var subFrameObjCon  =  eval( 't'+idxSht+'frame'  );
              if( subFrameObj.src == ""   ){
                  continue;
              }
 
              if( subFrameObjCon.sheetObjects == undefined  ){
                  continue;
              }  
              for(var i=0;i< subFrameObjCon.sheetObjects.length ;i++){
                  subFrameObjCon.sheetObjects[i].RemoveAll();    
              } 
             
          }       
          formObj.remark.value = "";
          for( var k = 0; k < enableButton.length; k++){
              ComBtnDisable(enableButton[k]);
          }
      }
      
    function setRegion(){
    	var formObj = document.form;
    	sheetObjects[0].WaitImageVisible = false;
    	
		formObj.f_cmd.value = SEARCH15;
		var comboXml = sheetObjects[0].GetSearchXml("VOP_OPF_0045GS.do" , FormQueryString(formObj));
		
		// Region Combo Data Set..
    	var regionList = ComGetEtcData(comboXml, "regionList");
    	var dataList;
    	if(regionList==null || regionList.length<1){
    		var rdrVvd = formObj.vsl_cd.value+formObj.voy_no.value+formObj.dir_cd.value;
    		comboObjects[0].RemoveAll();
    		comboObjects[0].Enable = false;
    		ComShowCodeMessage("OPF50030", rdrVvd);
    		return false;
    	}else{
    		comboObjects[0].Enable = true;
    		setComboItem2(comboObjects[0], regionList);
    		dataList = regionList.split("|");
    		if(dataList.length == 1){
    			formObj.region.Index = 0;
    		}
    	}
		
	    if( formObj.region.Code != "" ){
		   doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "oprCd");
	    }
	    
	    // Region Combo의 값이 단건일 경우 자동 조회
	    if(regionList != null && regionList.length >= 1){
	    	if(dataList.length == 1){
	    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
	    	}
	    }
    }
	/* 개발자 작업  끝 */