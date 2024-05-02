/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0002.js
*@FileTitle  : Total Inventory
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_0002 : ees_cim_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    // 공통전역변수
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var head_cntr_tpsz_cd="";
    var tot_cnmv_sts_cd="";
    var tot_lstm_cd="";
    var comboObjects=new Array();
    var comboCnt=0 ;
    var IBSEARCH01=29;
    var IBSEARCH02=30;
   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
   	document.onclick=processButtonClick;
   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    var formObject=document.form;
		try {
	   		var srcName=ComGetEvent("name");
            switch(srcName) {
			case "btn_New":		//조회조건 초기화
				comboObjects[0].SetSelectCode("");
				comboObjects[1].SetSelectCode("");
				comboObjects[2].SetSelectCode("");
				formObject.reset();
				sheet1.RemoveAll();
				//sheet1.RenderSheet(0);
//				sheet1.RemoveAll();
				//sheet1.RenderSheet(1);
				document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd;
				break;
			case "btn_DownExcel":	//DOWN EXCEL
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);								
				break;
			case "btn_Retrieve":	//조회
				
				document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
			   	document.form.prt_cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
			   	document.form.cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
			   	document.form.prt_dmg_flg.value=document.form.dmg_flg.value; 
			   	document.form.prt_cntr_no.value=document.form.cntr_no.value; 
			   	document.form.prt_lstm_cd.value=comboObjects[2].GetSelectCode();
			   	document.form.lstm_cd.value=comboObjects[2].GetSelectCode();
			   	document.form.prt_soc_cd.value=document.form.soc_cd.value; 
				
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_Print":		//Print
				if( sheetObjects[0].rowcount==0 ) {
					errMsg='No data found.';
					ComShowMessage(msgs["CGM10012"]);
					return;
				}
				formObject.f_cmd.value=IBSEARCH02;
				ComOpenPopupWithTarget('/opuscntr/EES_CIM_0902_POP.do', 775, 740, "", "0,1,1,1,1,1,1", true);
				break;
           } // end switch
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
     * 초기 이벤트 등록
     */
    function initControl() {
//   		 axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', '');						//cntr_no keyup 이벤트 처리
//   		 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
    * cntr_no keyup 이벤트 처리
    * cntr_no keyup시 대분자로 처리
    */
//    function cntr_no_onkeyUp() {
//	   var formObject=document.form;
//	   formObject.cntr_no.value=formObject.cntr_no.value.toUpperCase();
//    }
    /**
     * TP/SZ  클릭 이벤트 등록
     */
    function combo_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    /**
     * MVMT Status  클릭 이벤트 등록
     */
    function combo_cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		comboObj.SetItemCheck(0,0);
    	}
    }    
    /**
     * Lease Term  클릭 이벤트 등록
     */
    function combo_lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		comboObj.SetItemCheck(0,0);
    	}
    }       
    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
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
       for(p=0;p< comboObjects.length;p++){
           initCombo (comboObjects[p],p+1);
       }
       makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
	   initControl();
	   sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Lease Term  콤보코드 가져오기
     */
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
	    //MVMT Status
    	var arr_cnmv_sts_cd=cnmv_sts_cd.split("|");
	    var arr_cnmv_sts_nm=cnmv_sts_nm.split("|");
	    tot_cnmv_sts_cd=arr_cnmv_sts_cd;
	    with (combo_cnmv_sts_cd) {
	    	SetMultiSelect(1);
	        SetMultiSeparator(",");
	   	 	SetDropHeight(320);
	   	 	InsertItem(0 , 'ALL','');
	   	 	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
	   	 		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
	   	 	}
	    } 
    }
    /**
     * sheet1 로딩 완료시 이벤트 후출
     * TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); 	//TP/SZ,MVMT Status,Lease Term 데이타 가져오기
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	//조회
    }  
    /**
    * IBCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    }
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle) {
       var cnt=0;
       switch(sheetNo) {
           case 1:      //t1sheet1 init
               with (sheetObj) {
               
               if (headTitle==null || headTitle =="") {
               headTitle="Division|Lease Term|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
               }
               var headCnt=headTitle.split("|").length;
               sheetObj.FrozenCols=3;
               //SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:2, Page:80, DataRowMerge:0 } );
               SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:2, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:headTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Text",   Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"division",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lease_term",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                     for(var i=1 ; i <= headCnt - 3 ; i++){
                    	 cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                     }
                     cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
               InitColumns(cols);
               //SetSheetHeight(410);
               resizeSheet();
               SetEditable(0);
              }
              
              break;
       }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
       switch(sAction) {
         case IBSEARCH:      //조회
        	if(!validateForm(sheetObj,formObj,sAction)) return;
        	sheetObj.SetWaitImageVisible(0);
        	ComOpenWait(true);         	
  	        //sheetObj.RenderSheet(0);
  	        formObj.f_cmd.value=SEARCH;
 	        sheetObj.DoSearch("EES_CIM_0002GS.do",FormQueryString(formObj) );
	        ComOpenWait(false); 
            break;
         case IBSEARCH01:      //공통조회
        	 sheetObj.SetWaitImageVisible(0);
             form.f_cmd.value=SEARCH01;
              var sXml=sheetObj.GetSearchData("EES_CIM_0002GS.do" , FormQueryString(form));
             //TP/SZ 조회
             var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   
             head_cntr_tpsz_cd=cntr_tpsz_cd;
             document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd; 
             var strCntrTpszCd=cntr_tpsz_cd.split("|");
	         with (combo_cntr_tpsz_cd) {
	        	 SetMultiSelect(1);
	             SetMultiSeparator(",");
	             SetDropHeight(330);
	        	 InsertItem(0 , 'ALL','');
	        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
  		        	 InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	        	 }
	         }                     
             var HeadTitle="Division|Lease Term|Total|"+head_cntr_tpsz_cd;
//             sheet1.Reset();
             sheetObj = sheetObj.Reset();
             sheetObjects[0] = sheetObj; 
             initSheet(sheetObj,1,HeadTitle);
             //sheet1.RenderSheet(1);
             //Lease Term
             var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
             var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
             var arrLeaseTermNm=sLeaseTermNm.split("|");
             var arrLeaseTermCd=sLeaseTermCd.split("|");
             tot_lstm_cd=arrLeaseTermCd;
	         with (combo_lstm_cd) {
	        	 SetMultiSelect(1);
	             SetMultiSeparator(",");
	             SetDropHeight(320);
	        	 InsertItem(0 , 'ALL','');
	        	 for ( var i=1; i<=arrLeaseTermCd.length; i++) {
  		        	 InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
	        	 }
	         }                     
        	 break;
	      case IBDOWNEXCEL:      // 입력
	    	  if(sheetObj.RowCount() < 1){//no data
      			ComShowCodeMessage("COM132501");
      		}else{
      			sheetObj.Down2Excel({ SheetDesign:1, DownRows : "Visible", Merge:1 });      			
      		}
 	         break;
       }
    }
   	/**
    * sheet1 조회종료
    * sheet1 조회종료후 이벤트 호출
    */
   	function sheet1_OnSearchEnd(sheetObj, msg){
	   	for(var i=1; i<=sheetObj.LastRow(); i++){
	   		if(sheetObj.GetCellValue(i,1) == ''){
	   			if(sheetObj.GetCellValue(i,0) == 'Total'){
	   				sheetObj.SetCellValue(i,1,'G.Total');
				   	sheetObj.SetCellValue(i,0,'Total');
			   	} else {
				   	sheetObj.SetCellValue(i,1,'Total');
				   	sheetObj.SetRowBackColor(i,"#C9D5EB");
			   	}
		   	}
	   	}  
	   	if ( sheetObj.RowCount()!= 0 ) {
		   	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
			}
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),"division","Center");
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),"lease_term","Center");
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
		   	sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
		   	sheetObj.SetCellValue(sheetObj.LastRow()-1,0,'G.Total');
		   	sheetObj.SetCellValue(sheetObj.LastRow()-1,1,'G.Total');
		   	sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
		   	sheetObj.SetCellValue(sheetObj.LastRow(),1,'G.Total');
//		   	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 0, 2);
		   	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
	   	}
	   	document.form.prt_cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
	   	document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
	   	document.form.prt_full_flg.value=document.form.full_flg.value;
	   	if ( document.form.cntr_hngr_rck_cd.checked ) {
		   	document.form.prt_cntr_hngr_rck_cd.value="Y"; 
	   	} else {
		   	document.form.prt_cntr_hngr_rck_cd.value=""; 
	   	}
	   	if ( document.form.disp_flg.checked ) {
		   	document.form.prt_disp_flg.value="Y"; 
	   	} else {
		   	document.form.prt_disp_flg.value=""; 
	   	}
	   	if ( document.form.d2_payld_flg.checked ) {
		   	document.form.prt_d2_payld_flg.value="Y"; 
	   	} else {
		   	document.form.prt_d2_payld_flg.value=""; 
	   	}
	   	document.form.prt_cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
	   	document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
	   	document.form.cnmv_sts_cd.value=comboObjects[1].GetSelectCode();	   	
	   	document.form.prt_dmg_flg.value=document.form.dmg_flg.value;
	   	document.form.prt_cntr_no.value=document.form.cntr_no.value; 
	   	document.form.prt_lstm_cd.value=comboObjects[2].GetSelectCode();
	   	document.form.lstm_cd.value=comboObjects[2].GetSelectCode();
	   	document.form.prt_soc_cd.value=document.form.soc_cd.value; 
	   	//sheetObj.RenderSheet(1);
   	}
    /**
    * IBTab Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setTabObject(tab_obj){
       tabObjects[tabCnt++]=tab_obj;
    }
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
               with (tabObj) {
                   var cnt=0 ;
					InsertItem( "Inventory" , "");
					InsertItem( "Long Staying" , "");
					InsertItem( "Match Back" , "");
					InsertItem( "Turn Time" , "");
               }
            break;
        }
    }
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
    	   if (!ComChkValid(formObj)) return false;
       }
       return true;
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
    }	
    
    /*
    function combo_cntr_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	combo_cntr_tpsz_cd_text.value = newCode;
   }
    
   function combo_cntr_tpsz_cd_OnBlur(comboObj) {
	   combo_cntr_tpsz_cd_text.value = comboObj.GetSelectCode();
   }
    */