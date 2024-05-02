/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_0021.js
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2011.11.29 [CHM-201114860-01] 김민아 [OPF] CBF Inquiry Excel Download 기능개선요청
 * 2011.12.12 [CHM-201114818-01] Split 03-특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    function vop_opf_2022() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;    	
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 
 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
       	   var sheetObject1 = sheetObjects[0];
          /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
				case "btn_retrieve":
	
				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
					
			 	   break;
				case "btn_Excel":
			            var paramObj = new Object();
	                    paramObj.title = document.form.vvd.value;
	       
	                   // var url = ComOpfGetExcelDownSet(sheetObject1, paramObj);  
	                   // sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
	                   //sheetObject1.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
			           // sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, document.form.vvd.value);
	                 //  sheetObject1.Down2ExcelCell = true; 
					   sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, document.form.vvd.value);
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }
    

  	//Axon 이벤트 처리2. 이벤트처리함수
  	function obj_deactivate(){
  	    ComChkObjValid(event.srcElement);
  	}
  	
  	function obj_activate(){
  	    ComClearSeparator(event.srcElement);
  	}
  	
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

        var b20  = sheetObj.CellValue(2, "b_20");
 		var b40  = sheetObj.CellValue(2, "b_40");
 		var b40h = sheetObj.CellValue(2, "b_40h");
 		var b45  = sheetObj.CellValue(2, "b_45");
 		var c20  = sheetObj.CellValue(2, "c_20");
 		var c40  = sheetObj.CellValue(2, "c_40");
 		var c40h = sheetObj.CellValue(2, "c_40h");
 		var c45  = sheetObj.CellValue(2, "c_45");
 		var d20  = sheetObj.CellValue(2, "d_20");
 		var d40  = sheetObj.CellValue(2, "d_40");
 		var d40h = sheetObj.CellValue(2, "d_40h");
 		var d45  = sheetObj.CellValue(2, "d_45");
 		var e20  = sheetObj.CellValue(2, "e_20");
 		var e40  = sheetObj.CellValue(2, "e_40");
 		var e40h = sheetObj.CellValue(2, "e_40h");
 		var e45  = sheetObj.CellValue(2, "e_45");
 		var f20  = sheetObj.CellValue(2, "f_20");
 		var f40  = sheetObj.CellValue(2, "f_40");
 		var f40h = sheetObj.CellValue(2, "f_40h");
 		var f45  = sheetObj.CellValue(2, "f_45");
 		var g20  = sheetObj.CellValue(2, "g_20");
 		var g40  = sheetObj.CellValue(2, "g_40");
 		var g40h = sheetObj.CellValue(2, "g_40h");
 		var g45  = sheetObj.CellValue(2, "g_45");                                                           
 		var h20  = sheetObj.CellValue(2, "h_20");                   
 		var h40  = sheetObj.CellValue(2, "h_40");                   
 		var h40h = sheetObj.CellValue(2, "h_40h");                  
 		var h45  = sheetObj.CellValue(2, "h_45");                                                                             
 		var i20  = sheetObj.CellValue(2, "i_20");                   
 		var i40  = sheetObj.CellValue(2, "i_40");                   
 		var i40h = sheetObj.CellValue(2, "i_40h");                  
 		var i45  = sheetObj.CellValue(2, "i_45");                                                                              
 		var j20  = sheetObj.CellValue(2, "j_20");                   
 		var j40  = sheetObj.CellValue(2, "j_40");                   
 		var j40h = sheetObj.CellValue(2, "j_40h");                  
 		var j45  = sheetObj.CellValue(2, "j_45");                                                                              
 		var k20  = sheetObj.CellValue(2, "k_20");                   
 		var k40  = sheetObj.CellValue(2, "k_40");                   
 		var k40h = sheetObj.CellValue(2, "k_40h");                  
 		var k45  = sheetObj.CellValue(2, "k_45");                   
 		var l20  = sheetObj.CellValue(2, "l_20");                   
 		var l40  = sheetObj.CellValue(2, "l_40");                   
 		var l40h = sheetObj.CellValue(2, "l_40h");                  
 		var l45  = sheetObj.CellValue(2, "l_45");  
 		var crrcd = sheetObj.CellValue(3, "crr_cd");
 		var cnt  = 0 ;
		
    
 		sheetObj.CellFont("FontBold", 1,0) = true;
// 		sheetObj.CellFont("FontBold", 1,1) = true;
// 		sheetObj.CellFont("FontBold", 1,5) = true;
// 		sheetObj.CellFont("FontBold", 1,9) = true;
// 		sheetObj.CellFont("FontBold", 1,13) = true;
// 		sheetObj.CellFont("FontBold", 1,17) = true;
// 		sheetObj.CellFont("FontBold", 1,21) = true;
// 		sheetObj.CellFont("FontBold", 1,25) = true;
// 		sheetObj.CellFont("FontBold", 1,29) = true;
// 		sheetObj.CellFont("FontBold", 1,33) = true;
// 		sheetObj.CellFont("FontBold", 1,37) = true;
// 		sheetObj.CellFont("FontBold", 1,41) = true;
// 		sheetObj.CellFont("FontBold", 1,45) = true;
// 		sheetObj.CellFont("FontBold", 1,49) = true;
// 		sheetObj.CellFont("FontBold", 1,53) = true;
// 		sheetObj.CellFont("FontBold", 1,54) = true;
// 		sheetObj.CellFont("FontBold", 1,55) = true;
 		
 		
 		sheetObj.CellBackColor(2,5)  = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,9)  = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,13) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,17) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,21) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,25) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,29) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,33) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,37) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,41) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,45) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,49) = sheetObj.RgbColor(166, 166, 166);
 		sheetObj.CellBackColor(2,54) = sheetObj.RgbColor(228, 247, 186);
 		sheetObj.CellBackColor(2,55) = sheetObj.RgbColor(228, 247, 186);
 		
 		
 		sheetObj.CellFont("FontBold", sheetObj.LastRow-1 , 0) = true;  // 세로 TTL 
 		sheetObj.CellFont("FontBold", sheetObj.LastRow-2 , 0) = true;  // 세로 TTL 
 
 		
 		with(sheetObj)
		{   
 			   var i = 1;
 	 	
 	 	       
 	 		   for(var i=1 ; i <= 59 ; i++){
 	 			  sheetObj.CellFont("FontBold", 2,i) = true; 
 	 			  sheetObj.CellFont("FontBold", 3,i) = true; 
 	 			  
 	 			  if(i>53) { 
 	 				  sheetObj.CellBackColor(2,i) = sheetObj.RgbColor(228, 247, 186);  
 	 			      sheetObj.CellBackColor(3,i) = sheetObj.RgbColor(228, 247, 186);
 	 		          sheetObj.CellBackColor(sheetObj.LastRow-1,i) = sheetObj.RgbColor(255,255,255);
 	 			            }
 	 			  else  { sheetObj.CellBackColor(2,i) = sheetObj.RgbColor(166,166,166); 
 	 				      sheetObj.CellBackColor(3,i) = sheetObj.RgbColor(166,166,166); 
 	 			         // sheetObj.CellBackColor(sheetObj.LastRow-1,i) = sheetObj.RgbColor(213,213,213);
 	 			        //  sheetObj.CellBackColor(sheetObj.LastRow-1,i) = sheetObj.RgbColor(213,213,213); 
 	 			        }
 	 	          
 	 		   }
 	 	}

 	//	sheetObj.CellBackColor(1,53) = sheetObj.RgbColor(166, 166, 166);	
 		sheetObj.CellBackColor(sheetObj.LastRow-1,53) = sheetObj.RgbColor(255,255,255);
 	
 		//sheetObj.Cellvalue(1,"pod") = "" ; 
 		
 		if(crrcd == "OPR")  sheetObj.Cellvalue(3,"crr_cd") = "" ; 
 		if(crrcd == "TEU")  sheetObj.Cellvalue(3,"tot_teu") = "" ; 
 		if(b20 == ".")   { sheetObj.ColHidden( "b_20") = true;    cnt = cnt + 1;}
 		if(b40 == ".")   { sheetObj.ColHidden( "b_40") = true;    cnt = cnt + 1; }
 		if(b40h == ".")  { sheetObj.ColHidden( "b_40h") = true;   cnt = cnt + 1; }
 		if(b45 == ".")   { sheetObj.ColHidden( "b_45") = true;    cnt = cnt + 1; }
 		if(c20 == ".")   { sheetObj.ColHidden( "c_20") = true;    cnt = cnt + 1; }
 		if(c40 == ".")   { sheetObj.ColHidden( "c_40") = true;    cnt = cnt + 1; }
 		if(c40h == ".")  { sheetObj.ColHidden( "c_40h") = true;   cnt = cnt + 1; }
 		if(c45 == ".")   { sheetObj.ColHidden( "c_45") = true;    cnt = cnt + 1; }
 		if(d20 == ".")   { sheetObj.ColHidden( "d_20") = true;    cnt = cnt + 1; }
 		if(d40 == ".")   { sheetObj.ColHidden( "d_40") = true;    cnt = cnt + 1; }
 		if(d40h == ".")  { sheetObj.ColHidden( "d_40h") = true;   cnt = cnt + 1; }
 		if(d45 == ".")   { sheetObj.ColHidden( "d_45") = true;    cnt = cnt + 1; }
 		if(e20 == ".")   { sheetObj.ColHidden( "e_20") = true;    cnt = cnt + 1; }
 		if(e40 == ".")   { sheetObj.ColHidden( "e_40") = true;    cnt = cnt + 1; }
 		if(e40h == ".")  { sheetObj.ColHidden( "e_40h") = true;   cnt = cnt + 1; }
 		if(e45 == ".")   { sheetObj.ColHidden( "e_45") = true;    cnt = cnt + 1; }
 		if(f20 == ".")   { sheetObj.ColHidden( "f_20") = true;    cnt = cnt + 1; }
 		if(f40 == ".")   { sheetObj.ColHidden( "f_40") = true;    cnt = cnt + 1; }
 		if(f40h == ".")  { sheetObj.ColHidden( "f_40h") = true;   cnt = cnt + 1; }
 		if(f45 == ".")   { sheetObj.ColHidden( "f_45") = true;    cnt = cnt + 1; }
 		if(g20 == ".")   { sheetObj.ColHidden( "g_20") = true;    cnt = cnt + 1; }
 		if(g40 == ".")   { sheetObj.ColHidden( "g_40") = true;    cnt = cnt + 1; }
 		if(g40h == ".")  { sheetObj.ColHidden( "g_40h") = true;   cnt = cnt + 1; }
 		if(g45 == ".")   { sheetObj.ColHidden( "g_45") = true;    cnt = cnt + 1; }
 		if(h20 == ".")   { sheetObj.ColHidden( "h_20") = true;    cnt = cnt + 1; }
 		if(h40 == ".")   { sheetObj.ColHidden( "h_40") = true;    cnt = cnt + 1; }
 		if(h40h == ".")  { sheetObj.ColHidden( "h_40h") = true;   cnt = cnt + 1; }
 		if(h45 == ".")   { sheetObj.ColHidden( "h_45") = true;    cnt = cnt + 1; }
 		if(i20 == ".")   { sheetObj.ColHidden( "i_20") = true;    cnt = cnt + 1; }
 		if(i40 == ".")   { sheetObj.ColHidden( "i_40") = true;    cnt = cnt + 1; }
 		if(i40h == ".")  { sheetObj.ColHidden( "i_40h") = true;   cnt = cnt + 1; }
 		if(i45 == ".")   { sheetObj.ColHidden( "i_45") = true;    cnt = cnt + 1; }
 		if(j20 == ".")   { sheetObj.ColHidden( "j_20") = true;    cnt = cnt + 1; }
 		if(j40 == ".")   { sheetObj.ColHidden( "j_40") = true;    cnt = cnt + 1; }
 		if(j40h == ".")  { sheetObj.ColHidden( "j_40h") = true;   cnt = cnt + 1; }
 		if(j45 == ".")   { sheetObj.ColHidden( "j_45") = true;    cnt = cnt + 1; }
 		if(k20 == ".")   { sheetObj.ColHidden( "k_20") = true;    cnt = cnt + 1; }
 		if(k40 == ".")   { sheetObj.ColHidden( "k_40") = true;    cnt = cnt + 1; }
 		if(k40h == ".")  { sheetObj.ColHidden( "k_40h") = true;   cnt = cnt + 1; }
 		if(k45 == ".")   { sheetObj.ColHidden( "k_45") = true;    cnt = cnt + 1; }
 		if(l20 == ".")   { sheetObj.ColHidden( "l_20") = true;    cnt = cnt + 1; }
 		if(l40 == ".")   { sheetObj.ColHidden( "l_40") = true;    cnt = cnt + 1; }
 		if(l40h == ".")  { sheetObj.ColHidden( "l_40h") = true;   cnt = cnt + 1; }
 		if(l45 == ".")   { sheetObj.ColHidden( "l_45") = true;    cnt = cnt + 1; }
	
 		
		cnt = 50 - cnt ;
 
		with(sheetObj)
		{
 	 		if(sheetObj.RowCount > 0){
 	 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 	 				for ( var j=0; j<cnt; j++ ) {
	 	 				if(sheetObj.CellValue(i, j) == "."){
	 	 					sheetObj.CellValue(i, j)  = 0;
	 	 					sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255,255,255);
	 	 					
	 	 				
	 	 				}
 	 				}
 	 			}
 	 		}
 	 		
		} 
		
		sheetObj.RowMerge(1) = true;
		sheetObj.RowMerge(2) = true;
		sheetObj.CellValue(sheetObj.LastRow-1,53) = "";	
		
		sheetObj.SetMergeCell(1, 0, 0, 59);
		
		
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 1, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 5, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 9, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 13, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 17, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 21, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 25, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 29, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 33, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 37, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 41, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 45, 1, 4); // "WGT" CELL MERGE
		sheetObj.SetMergeCell(sheetObj.LastRow-1, 49, 1, 4); // "WGT" CELL MERGE

		
		sheetObj.CellValue(sheetObj.LastRow-1, 1) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,1));
		sheetObj.CellValue(sheetObj.LastRow-1, 5) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,5));
		sheetObj.CellValue(sheetObj.LastRow-1, 9) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,9));
		sheetObj.CellValue(sheetObj.LastRow-1, 13) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,13));
		sheetObj.CellValue(sheetObj.LastRow-1, 17) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,17));
		sheetObj.CellValue(sheetObj.LastRow-1, 21) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,21));
		sheetObj.CellValue(sheetObj.LastRow-1, 25) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,25));
		sheetObj.CellValue(sheetObj.LastRow-1, 29) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,29));
		sheetObj.CellValue(sheetObj.LastRow-1, 33) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,33));
		sheetObj.CellValue(sheetObj.LastRow-1, 37) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,37));
		sheetObj.CellValue(sheetObj.LastRow-1, 41) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,41));
		sheetObj.CellValue(sheetObj.LastRow-1, 45) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,45));
		sheetObj.CellValue(sheetObj.LastRow-1, 49) = makeComma(sheetObj.CellValue(sheetObj.LastRow-1,49));
		

		
	//	sheetObj.SetMergeCell(1, 53, 2, 1); // "total teu" CELL MERGE
		
		sheetObj.SetMergeCell(2, 54, 2, 1); // "OPR" CELL MERGE
		sheetObj.SetMergeCell(2, 55, 1, 4); // "special cargo" CELL MERGE
		
		 
		sheetObj.SetMergeCell(sheetObj.LastRow, 0, 0, 54); // "WGT" CELL MERGE
	
		sheetObj.CellAlign(0,1) = daCenter;
		sheetObj.CellAlign(2,56) = daCenter;
 		sheetObj.CellAlign(2,57) = daCenter;
 		sheetObj.CellAlign(2,58) = daCenter;
 		sheetObj.CellAlign(2,59) = daCenter;
	 		
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
                 style.height = 440;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 //MergeSheet = msHeaderOnly;

                 MergeSheet = msPrevColumnMerge + msHeaderOnly;


                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;
                 // Row 선택 시 색상표시 안함
                 SelectHighLight = false;
               
                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 0, 100)
     		
                 var HeadTitle1 = "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"; 
     			//  var HeadTitle1 = "|pod|20|40|40h|45";						
     			 var headCount = ComCountHeadTitle(HeadTitle1);
     		  	 sheet1HeadTitleCnt = headCount;

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 1, 0, true);
                
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false )
                 InitHeadRow(0, HeadTitle1, true);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, false, true);
             
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,	 			 60, daCenter, true,     "pod",          false,     "",      dfNone, 	    0,     true,        true); //1
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "a_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "a_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "a_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "a_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "b_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "b_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "b_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "b_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "c_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "c_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "c_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "c_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "d_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "d_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "d_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "d_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "e_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "e_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "e_40h",        false,     "",      dfNone, 	    0,     true,        true);//20
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "e_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "f_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "f_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "f_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "f_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "g_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "g_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "g_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "g_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "h_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "h_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "h_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "h_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "i_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "i_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "i_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "i_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "j_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "j_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "j_40h",        false,     "",      dfNone, 	    0,     true,        true);//40
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "j_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "k_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "k_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "k_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "k_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "l_20",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "l_40",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "l_40h",        false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "l_45",         false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "tot_20",       false,     "",      dfNone, 	    0,     true,        true);//50
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "tot_40",       false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "tot_40h",      false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "tot_45",       false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "tot_teu",      false,     "",      dfNone, 	    0,     true,        true);//54
                 InitDataProperty(0, cnt++ , dtData,	 			 40, daCenter, true,     "crr_cd",       false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 200, daLeftTop, true,     "sp_20",       false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 200, daLeftTop, true,     "sp_40",       false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 200, daLeftTop, true,     "sp_40h",      false,     "",      dfNone, 	    0,     true,        true);
                 InitDataProperty(0, cnt++ , dtData,	 			 200, daLeftTop, true,     "sp_45",       false,     "",      dfNone, 	    0,     true,        true);//59
            
             
       
         }
         break;
             
        
      }
   }

   function makeComma(srcValue){
		if(srcValue.length > 9){
	  		srcValue = srcValue.substring(0,9);
	  	}
			l=srcValue.length-3;
			while(l > 0) {
				srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
				l-=3;
			}    		
	  	return srcValue;
	  }
   
   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var sheetObject1 = sheetObjects[0];


		
     switch(sAction) {
       case IBSEARCH:        //조회

         // if(validateForm(sheetObj,formObj,sAction)){
			  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH01;

			  sheetObj.DoSearch("VOP_OPF_2022GS.do", FormQueryString(formObj));

			  ComOpenWait(false);
       //   }
       break;
       
     
     }
   }

  
	/* 개발자 작업  끝 */