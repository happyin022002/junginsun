/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0044.js
*@FileTitle : Slip Correction - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태
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
     * @class ESM_FMS_0044 : ESM_FMS_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0044() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
        this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    }
    
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
						
					case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;
						
					case "btn_tax":
						var csr_no = form.csr_no.value;
		        		
		        		ComOpenPopup("ESM_FMS_0086.do?csr_no="+csr_no, 917, 505,"setTaxEvidence", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0086");
						break;
						
					case "btn_close":
						window.close();
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

        	//khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        sheetObjects[0].ExtendLastCol = false;
        
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:
                with (sheetObj) {

                    // 높이 설정
                    style.height = 202;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 2, 3, 100);
 
 					var HeadTitle1 = " |Seq|Acct Code|Vendor Code|Center Code|City|Eff. Date|Slip Amount|Dr Amount|Cr Amount|Flet Ctrt Tp Cd|Ims Slp Seq No";
					var HeadTitle2 = " |Seq|Description|Description|Description|Description|VVD Code|Key Number|Dr Amount|Cr Amount|Flet Ctrt Tp Cd|Org Slp Seq No";
					//var HeadTitle1 = " |Seq|Acct Code|Vendor Code|Center Code|City|Eff. Date|Slip Amount|Dr Amount|Cr Amount|Flet Ctrt Tp Cd";
					//var HeadTitle2 = " |Seq|Description|Description|Description|Description|VVD Code|Key Number|Dr Amount|Cr Amount|Flet Ctrt Tp Cd";
					var headCount = ComCountHeadTitle(HeadTitle1);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	   30,		daCenter,	true,		"ibflag1");
					InitDataProperty(0, cnt++ , dtData,			   40,		daCenter,	true,		"slp_seq_no",       false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	  125,		daCenter,	true,		"acct_cd",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	  125,		daCenter,	false,		"ownr_cd",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	  125,		daCenter,	false,		"ctr_cd",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	  125,		daCenter,	false,		"slp_loc_cd",		false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,      	  125,		daCenter,	false,		"eff_dt",			false,	"",		dfDateYmd,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	   	  298,		daRight,	false,		"csr_amt",			false,	"",		dfNullFloat,		2,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	   90,		daRight,	false,		"dr_amt",			false,	"",		dfNullFloat,		2,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	   90,		daRight,	false,		"cr_amt",			false,	"",		dfNullFloat,		2,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	   90,		daCenter,	false,		"flet_ctrt_tp_cd",	false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		   40,		daCenter,	false,		"ims_slp_seq_no",   false,	"",		dfNone,				0,	false,	true);

					cnt = 0;
					InitDataProperty(1, cnt++ , dtHiddenStatus,	   30,		daCenter,	true,		"ibflag");
					InitDataProperty(1, cnt++ , dtData,			   40,		daCenter,	true,		"slp_seq_no",       false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(1, cnt++ , dtData,      	  125,		daLeft,		true,		"csr_desc",			false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  125,		daCenter,	false,		"csr_desc1",		false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  125,		daCenter,	false,		"csr_desc2",		false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  125,		daCenter,	false,		"csr_desc3",		false,	"",		dfNone,				0,	true,	true);
					InitDataProperty(1, cnt++ , dtData,      	  125,		daCenter,	false,		"vvd_cd",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(1, cnt++ , dtData,   	   	  298,		daRight,	false,		"key_num",			false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(1, cnt++ , dtHidden,   	   90,		daRight,	false,		"dr_amt",			false,	"",		dfNullFloat,		2,	false,	true);
					InitDataProperty(1, cnt++ , dtHidden,   	   90,		daRight,	false,		"cr_amt",			false,	"",		dfNullFloat,		2,	false,	true);
					InitDataProperty(1, cnt++ , dtHidden,   	   90,		daCenter,	false,		"flet_ctrt_tp_cd",	false,	"",		dfNone,				0,	false,	true);
					InitDataProperty(1, cnt++ , dtHidden,		   40,		daCenter,	false,		"org_slp_seq_no",   false,	"",		dfNone,				0,	false,	true);

					CountPosition = 0;
					
					DataRowMerge(0) = true;
					DataRowMerge(1) = true;
										
               }
                break;

 

        }
    }

     /**
      * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
      * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {form}    formObj     Form Object
      * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
      **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				
	  			formObj.f_cmd.value = SEARCH;
	  			
	  			sheetObj.DoSearch("ESM_FMS_0042GS.do" , FormQueryString(formObj));
	  			
                break;
                
			case IBSAVE:        //저장
           	
	       		formObj.f_cmd.value = MULTI;
	       		
				//var param = FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"");
				
				var sParam = sheetObj.GetSaveString(); 
				if (sheetObj.IsDataModified == false && sParam == "") {
					return; 
				}

				var aryPrefix = new Array("");
				
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
			
	       		var sXml = sheetObj.GetSaveXml("ESM_FMS_0044GS.do", sParam);
	       		
	       		var arrXml = sXml.split("|$$|");
	       		
	       		if (arrXml.length > 0) sheetObj.LoadSaveXml(arrXml[0]);
	       		
	       		break;
        }
    }
    
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount > 0){
    		
    		var csr_no = form.csr_no.value;
    		
    		var dr_amt = 0;
    		var cr_amt = 0;
    		var balance_amt = 0;
    		
    		for(var ir=2; ir<=sheetObj.LastRow; ir++) {
    			sheetObj.CellValue(ir,"org_slp_seq_no") = sheetObj.CellValue(ir,"slp_seq_no");
    			
    			sheetObj.CellValue(ir,"ibflag") = "R";
    			sheetObj.CellValue(ir,"ibflag1") = "R";
    			
    			if(ir%2 == 0) {
    				dr_amt += parseFloat(sheetObj.CellValue(ir,"dr_amt"));
    				cr_amt += parseFloat(sheetObj.CellValue(ir,"cr_amt"));
    			}
    		}
    		
    		form.dr_amt.value = ComAddComma(dr_amt.toFixed(2));
    		form.cr_amt.value = ComAddComma(cr_amt.toFixed(2));

    		//if(sheetObj.CellValue(2,"flet_ctrt_tp_cd") == "TO") {
    		if(csr_no.substring(0,2) == "20") {
    			form.diff.value = "CR";
    		} else {
    			form.diff.value = "Diff";
    			document.all.balanceAmt.style.display = "";
    			
    			//form.balance_amt.value = ComAddComma((dr_amt + cr_amt).toFixed(2));
    			
    			balance_amt = dr_amt + cr_amt;
    			
    			if(parseFloat(balance_amt.toFixed(2)) == 0) {
					form.balance_amt.value = "0.00";
				} else {
					form.balance_amt.value = ComAddComma(balance_amt.toFixed(2));
				}
    		}
    		
    		ComColFontName(sheetObj, "5"); 
    		ComColFontName(sheetObj, "6"); 
    		ComColFontName(sheetObj, "7"); 
    	}  
    }