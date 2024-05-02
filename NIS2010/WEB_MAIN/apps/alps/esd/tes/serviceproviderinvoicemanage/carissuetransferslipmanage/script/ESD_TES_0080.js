// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var rdObjects = new Array();
var rdCnt = 0;
var approvalFlg = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= sheetObjects[0];
         var sheetObject1 	= sheetObjects[1];
         var sheetObject2 	= sheetObjects[2];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_close":
					window.close();
	        break;
				case "btng_print":					
					rdObject.PrintDialog();
					break;

				case "btng_approvalrequest":					
					if(approvalFlg==""){
						opener.approvalrequest();
					}
					focus();
					approvalFlg="Y";
					//window.close();
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet} sheet_obj	ibsheet object
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
		// 'Approval Request' button을 보일지 말지 결정하는 부분... -> 일단 CSR생성화면에서 Preview하는 경우만 보이기...
		if (previewFlgYN!=undefined && previewFlgYN=='Y'){
			document.all.item("btng_approvalrequest_yn")[0].style.display = "inline";
			document.all.item("btng_approvalrequest_yn")[1].style.display = "none";
		} else {
			document.all.item("btng_approvalrequest_yn")[0].style.display = "none";
			document.all.item("btng_approvalrequest_yn")[1].style.display = "inline";
		}

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initRdConfig(rdObjects[0]);
       	rdOpen();	
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * @param {ibsheet} sheetObj 	==> 시트오브젝트
     * @param {int}		sheetNo 	==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(13);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.||Invoice No.|Net Amount|Tax Amount|Total Amount" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

										InitDataProperty(0, cnt++ , dtSeq,	 					30,		daCenter,		false,    "",										false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtCheckBox, 			50,		daCenter,		false,    "",										false,			"",			dfNone,					0,			true,			true	);
										InitDataProperty(0, cnt++ , dtData,	 					200,	daLeft,			false,    "inv_no",							false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "ttl_inv_amt",				false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "vat_amt",						false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "total_amt",					false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_ofc_cty_cd",	false,			"",			dfNone,					2,			false,			false	); 
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_seq",					false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtHiddenStatus,	 	1,		daRight,		false,    "ibflag",							false,			"",			dfNone,					0,			false,			false	);

               }
                break;    
                 
        }
    }


  // Sheet관련 프로세스 처리
	/**
	 * @param {ibsheet} sheetObj 	시트오브젝트
     * @param {form}	formObj		폼 오브젝트
     * @param {String}	sAction     액션 값
	 */  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
               	formObj.f_cmd.value = SEARCHLIST;                  
                sheetObj.DoSearch4Post("ESD_TES_0024GS.do", tesFrmQryStr(formObj));
                break; 
                
           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break

        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


	 /**
     * MInimize 클릭시 이벤트 관련
     * @param {String} nItem	
     */
    function Minimize(nItem)
    {
        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
	    	    objs.style.display = "none";
	    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
				sheetObjects[0].focus();
				sheetObjects[0].ViewRows  =20; 
				}
	    	else
	    	{
	    	    objs.style.display = "inline";
	    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
				sheetObjects[0].focus();
				sheetObjects[0].ViewRows  =10;
	    	}
    }
    
		function rdOpen(){//alert("start rdOpen");		
			
			var sXml = "";		
			var i=0;
			var j=0; 
			//var opener_obj = window.dialogArguments;	
			var opener_obj = opener;	
			var opener_sheet_obj1 =  opener_obj.document.sheet2;
			var opener_sheet_obj2 =  opener_obj.document.sheet3;
			
			var fromObj = new Array();
			var rdObj = new Array();
						
			fromObj[0] = document.form;                            // RD 로 보내기 위해 배열로담는다
			rdObj[0] = opener_sheet_obj1;     
			rdObj[1] = opener_sheet_obj2;

			sXml = "<?xml version='1.0' ?><SHEET>";

			sheetCnt = 1;
			for(i=0;i<2;i++){//alert(11);
					sheetCnt = i+1;
					if(rdObj[i].RowCount ==0){
							sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
 
							for(j=0;j<=rdObj[i].LastCol;j++){
									sXml +="<TD></TD>";
							}
							sXml +="</TR></DATA></SHEET"+sheetCnt+">";
					}else{
							sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
							
					}			
			}
			sXml +="</SHEET>"; 

			if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
			{
				ComShowMessage(ComGetMsg("TES10078"));
				return;
			}
 
			rdObjects[0].SetRData(sXml); 

			if(previewFlg =="krjp"){			
					rdObjects[0].FileOpen(RD_path+'apps/alps/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080krjp.mrd', '');					
			}else{
					rdObjects[0].FileOpen(RD_path+'apps/alps/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080.mrd', ''); 					
			}
		}
		
		 /**
		  * RD 초기설정값
		  * @param {rd object}		rdObject	rd
		  * @return
		  */
		 function initRdConfig(rdObject){
		    var Rdviewer = rdObject ;
		    
			Rdviewer.AutoAdjust = true;
			// Rdviewer.HideToolbar(); // show tool bar ... In 2008-09-12

	        // Added Option  ... In 2008-09-12
	    	Rdviewer.SetSaveDialogEx("", "", "pdf", "pdf");
	    	Rdviewer.DisableToolbar(13);
	    	Rdviewer.DisableToolbar(14);
	    	Rdviewer.DisableToolbar(16);
	    	Rdviewer.DisableToolbar(17);

			Rdviewer.HideStatusbar();
			Rdviewer.ViewShowMode(2);

			Rdviewer.setbackgroundcolor(255,255,255);
			Rdviewer.SetPageLineColor(255,255,255);
		}