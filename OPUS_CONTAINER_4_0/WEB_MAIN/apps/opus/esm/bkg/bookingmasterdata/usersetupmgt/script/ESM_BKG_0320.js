/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0320.js
*@FileTitle  : Internet O/BL Release Authority
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 			switch(srcName) {
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
 					break;
 				case "btn_RowDelete":
 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
 					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					break;
 				case "btn_DownExcel":
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;
             } // end switch
     		}catch(e) {
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
//         doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 		
	 		initControl();
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
             case "sheet1":
                 with (sheetObj) {
                 var HeadTitle1="|	|User ID|User Name|Office|Internet O/BL|FTP BL|Creation|Creation|Creation";
                 var HeadTitle2="|	|User ID|User Name|Office|Internet O/BL|FTP BL|Date|Name|Office";
                 var headCount=ComCountHeadTitle(HeadTitle1);
                 var prefix="sheet1_";
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle1, Align:"Center"},
                           { Text:HeadTitle2, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                     {Type:"CheckBox",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_id",     		KeyField:1,   CalcLogic:"",   Format:"" ,           PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_nm",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inet_auth_flg",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inet_ftp_auth_flg",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_nm",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_ofc_cd", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 InitColumns(cols);
                 SetEditable(1);
                 SetRangeBackColor(1, 3, 1, 7,"#555555");
                 SetColProperty(prefix+"upd_dt", {Format:"####-##-##"} );
                 SetColProperty("usr_id", {AcceptKeys : "E|N|[_]", InputCaseSensitive :1} );
                 SetSheetHeight(422);
 				}
 				break;
         }
     }
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case IBSEARCH:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value=SEARCH;
			 				if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0320GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
			 				break;
			 			case SEARCH01:      //조회
							if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH01;
							if ("sheet1" == sheetObj.id) {
								var sXml=sheetObj.GetSearchData("ESM_BKG_0320GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
								sheetObj.SetCellValue(Row, Col+1,ComGetEtcData(sXml, "search_usr_nm"));
					    	sheetObj.SetCellValue(Row, Col+2,ComGetEtcData(sXml, "search_ofc_cd"));
					    	if(isNullEtcData(sXml)) {
					    		ComShowCodeMessage('BKG00768');
					    		sheetObj.SetCellValue(Row, Col,"",0);
					    	}
							}
							break;
			 			case IBSAVE:        //저장
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value=MULTI;
//							for ( var ir=1; ir <= sheetObj.RowCount(); ir++) {
//								if(sheetObj.GetCellValue(ir,"sheet1_ibflag") != "D"){
//									sheetObj.SetCellValue(ir,"sheet1_ibflag","");
//								}
//							}
//							var sRow = sheetObj.FindCheckedRow("sheet1_del_chk");
//							var arrRow = sRow.split("|");
//							for(idx=0; idx<arrRow.length; idx++){
//								sheetObj.SetCellValue(arrRow[idx],"sheet1_ibflag","U");
//							}
							var sStatusRow = sheetObj.FindStatusRow("I|U|D");
							if (sStatusRow == ""){
								ComShowCodeMessage("BKG00333");
								return;
							}
							var sParam=sheetObj.GetSaveString();
							sParam += "&" + FormQueryString(formObj);
							var sXml=sheetObj.GetSaveData("ESM_BKG_0320GS.do" , sParam);
							sheetObj.LoadSaveData(sXml);
			 				break;
						case IBINSERT:      // 입력
							sheetObj.DataInsert(-1);
							break;
						case IBDOWNEXCEL:   // 엑셀다운로드
							if(sheetObj.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
								}else{
									sheetObj.Down2Excel({ HiddenColumn:1});
								}
							break;
			    }
     }
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @version 2009.05.17
     */ 	
	 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	 		var formObject=document.form;
	 		if (ErrMsg == "") {
				ComBkgSaveCompleted();
				sheetObj.RemoveAll();
				doActionIBSheet(sheetObj,formObject,IBSEARCH);
			}
		}
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSAVE:
    			var prefix="sheet1_";
    			for(var i=sheetObj.HeaderRows(); i <= sheetObj.RowCount()+ sheetObj.HeaderRows()-1; i++) {
    				var vUsrId=sheetObj.GetCellValue(i, prefix+"usr_id");
    				if (sheetObj.GetCellValue(i, prefix+"ibflag") != "R") {
	  					if (ComIsNull(vUsrId)) {
	      					ComShowCodeMessage('BKG00768','User ID');
	      					return false;
	  					}
	  				}
	  			}
	  			break;
    	 }
         return true;
     }
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var prefix="sheet1_";
    	var formObject=document.form;
    	if (sheetObj.ColSaveName(Col) == prefix+"usr_id"){
    		formObject.ch_usr_id.value=Value;
    		doActionIBSheet(sheetObj,formObject,SEARCH01,Row,Col);
    	}
    }
    function isNullEtcData(xmlStr){
    	var rtn=false;
    	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        var xmlRoot=xmlDoc.documentElement;
        if(xmlRoot == null) return true;
        var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;
        var etcNodes=etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn=true;
        return rtn;
    }
	/* 개발자 작업  끝 */    
