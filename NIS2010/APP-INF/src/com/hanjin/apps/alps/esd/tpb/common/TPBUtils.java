/*=========================================================
*Copyright(c) Since 2006 CyberLogitec
*@FileName : TPBUtils.java
*@FileTitle : TPB 에서 공통으로 사용하는 기능을 처리하는 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : Sun, CHOI
*@LastVersion : 1.3
* 2006-11-06 Youngchang_Kim 1.0 최초 생성
* 2008-09-02 Kim Jin-seung  1.1 수정 - getParams(HttpServletRequest, String), getParams(MultipartRequest, String) 추가;
* 2008-09-10 O Wan-Ki 		1.2   추가 - getOfficeTopLevel method 추가
* 2009-11-19 Sun, CHOI      1.3 ALPS Migration
* 2011.05.11 손은주 [CHM-201110508-01][TPB] ALPS WAS error log 수정 작업
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common;
 
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBC;
import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.combo.event.CommonCodeEvent;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.MultipartRequest;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * TPBUtils
 * - TPB 에서 공통으로 사용하는 기능을 처리하는 클래스
 *
 * @author Sun, CHOI
 * @see
 * @since J2EE 1.4
 */
public class TPBUtils {
	
	protected transient static Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.tpb.common.TPBUtils");
	//protected transient static Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * request의 파라미터 값을 HashMap 으로 구한다. 
	 * @param req HttpServletRequest HttpRequest
	 * @return HashMap request parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(HttpServletRequest req)  {
		HashMap params = new HashMap();

		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, JSPUtil.getParameter(req,key));
		}
		return params;
	}

	/**
	 * prefix로 시작하는 파라미터 값의 HashMap 값을 구한다. 
	 * @param req HttpServletRequest HttpRequest
	 * @param prefix String
	 * @return HashMap request parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(HttpServletRequest req, String prefix)  {
		HashMap params = new HashMap();
		if ( prefix==null || prefix.trim().length()==0 ) {
			return null;
		}
		
		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			if ( key.startsWith(prefix) ){
				params.put(key, JSPUtil.getParameter(req,key));
			}
		}
		return params;
	}

	/**
	 * request의 파리미터 값을 HashMap 으로 구한다. 
	 * @param multiReq MultipartRequest
	 * @return HashMap MultipartRequest parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(MultipartRequest multiReq)  {
		HashMap params = new HashMap();

		Enumeration e = multiReq.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, multiReq.getParameter(key));
		}
		return params;
	}

	/**
	 * prefix로 시작하는 파라미터 값의 HashMap 값을 구한다.  
	 * @param multiReq MultipartRequest
	 * @param prefix String
	 * @return HashMap MultipartRequest parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(MultipartRequest multiReq, String prefix)  {
		HashMap params = new HashMap();
		if ( prefix==null || prefix.trim().length()==0 ) {
			return null;
		}

		Enumeration e = multiReq.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			if ( key.startsWith(prefix) ){
				params.put(key, multiReq.getParameter(key));
			}
		}
		return params;
	}
	
	/**
	 * @param req HttpServletRequest HttpRequest
	 * @return HashMap request parameter 정보를 배열로 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getArrayParams(HttpServletRequest req)  {
		HashMap params = new HashMap();

		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, req.getParameterValues(key));
		}
		return params;
	}
	
	/**
	 * 입력데이터의 유효성 검증 메소드, TPBCommonCodeDBDAO 에서 처리됨
	 * @param e        EventSupport
	 * @param method   TPBCommonCodeDBDAO에서 호출할 메소드명
	 * @return boolean  실행결과, 값이 없을 경우 null 리턴
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkVaildate(EventSupport e, String method) throws EventException {
		HashMap params = e.getEventParams();
		params.put("method",method);
		CommonCodeEvent event = new CommonCodeEvent();
		event.setEventParams(params);

		CommonCodeBC command = new CommonCodeBCImpl();
		GeneralEventResponse eventResponse = (GeneralEventResponse)command.searchCommonCode(event);
		DBRowSet dbRs = eventResponse.getRs();
		boolean check = false;
		if( dbRs == null ) check = false;
		else {
			if( dbRs.getRowCount() > 0 )  check = true;
			else check = false;
		}
		return check;
	}

	/**
	 * TPB FileUpload에 필요한 정보(파일경로, 파일 최대 크기 등)를 가져옴 
	 * @param request 
	 * @return 
	 */
//	public static FileMetaData getFileMetaData(HttpServletRequest request) {
//		return getFileMetaData(request, "tpb_common"); 
//	}

	/**
	 * TPB FileUpload에 필요한 정보(파일경로, 파일 최대 크기 등)를 가져옴 
	 * @param request 
	 * @param file_path_id String - file_description.xml에 정의된 file-id; 기본값 : tpb_common
	 * @return 
	 */
//	public static FileMetaData getFileMetaData(HttpServletRequest request, String file_path_id) {
//
//		FileMetaData fmd = null; 
//
//		HttpSession session = request.getSession(false);
//		ServletContext context = session.getServletContext();
//		fmd = FileMetaDataManager.getInstance().getFileMetaData(context, file_path_id); // parsing file-description.xml 
//		
//		return fmd; 
//	}
	
	/**
	 * TPB FileUpload에 필요한 정보(파일경로, 파일 최대 크기 등)를 가져옴 
	 * @param request 
	 * @return 
	 */
	public static ModuleMetaData getFileMetaData(HttpServletRequest request) {
		return getFileMetaData(request, "TPB"); 
	}
	
	/**
	 * TPB FileUpload에 필요한 정보(파일경로, 파일 최대 크기 등)를 가져옴 
	 * @param request 
	 * @return 
	 */
	public static ModuleMetaData getFileMetaData(HttpServletRequest request, String file_path_id) {

		ModuleMetaData fmd = null; 

		HttpSession session = request.getSession(false);
		ServletContext context = session.getServletContext();
		fmd = FileMetaDataManager.getInstance().getFileMetaData(context, file_path_id); 
		return fmd; 
	}

	/**
	 * 사용자의 조직코드로 레벨정보를 구한다.
	 * 레벨 : HO / RHQ / General Office
	 * @param e        EventSupport
	 * @return String  실행결과, 값이 없을 경우 null 리턴
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public static String getLevel(Event e) throws EventException {
		String strLevel = null;
		SignOnUserAccount sa = e.getSignOnUserAccount();
		HashMap params = new HashMap();

		params.put("method", "searchLevel"); //호출할 메소드명
		params.put("ofc_cd", sa.getOfc_cd()); // 사용자의 조직코드
		CommonCodeEvent event = new CommonCodeEvent();
		event.setEventParams(params);

		CommonCodeBC command = new CommonCodeBCImpl();
		GeneralEventResponse eventResponse = (GeneralEventResponse)command.searchCommonCode(event);
		
		try {
			if(eventResponse.getRs().next()){
				strLevel = eventResponse.getRs().getString("lvl");
			}
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new EventException(e1.getMessage());
		}
		
		return strLevel;
	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다. 
	 * 레벨 : HO / RHQ / GO(General Office)
	 * @param e Event - User Session이 있는 Event
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @throws EventException
	 */
//	public static String[] getOfficeLevel(Event e) throws EventException {
//		return TPBUtils.getOfficeLevel( e.getSignOnUserAccount().getOfc_cd() );
//	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다. 
	 * 레벨 : HO / RHQ / GO(General Office)
	 * @param officeCode - Office Code
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @throws EventException
	 */
	public static String[] getOfficeLevel(String officeCode) throws EventException {
		
		String[] officeInfo = null;
		
		if ( officeCode!=null && officeCode.trim().length()>0 ) {
			CommonCodeBC command = new CommonCodeBCImpl();
			officeInfo = command.searchOfficeLevel(officeCode);
		}
		
		return officeInfo;
	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다. 
	 * 레벨 : HO / RHQ / Control / GO(General Office=TPB Office)
	 * @param officeCode - Office Code
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @throws EventException
	 */
	public static String[] getHandleOfficeLevel(String officeCode) throws EventException {
		
		return getHandleOfficeLevel(officeCode, false);
	}

	/**
	 * 사용자의 조직코드로 레벨정보를 구한다. 
	 * 레벨 : HO / RHQ / Control / GO(General Office=TPB Office)
	 * @param officeCode - Office Code
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @throws EventException
	 */
	public static String[] getHandleOfficeLevel(String officeCode, boolean isIncludeControlOffice) throws EventException {
		
		String[] officeInfo = null;
		
		if ( officeCode!=null && officeCode.trim().length()>0 ) {
			CommonCodeBC command = new CommonCodeBCImpl();
//			log.debug("officeCode===>"+officeCode);
			officeInfo = command.searchHandleOfficeLevel(officeCode, isIncludeControlOffice);
		}
		
		return officeInfo;
	}
	
	/**
	 * 사용자의 조직코드가 TPB Office인지 여부 
	 * 레벨 : HO / RHQ / Control / GO(General Office=TPB Office)
	 * @param officeCode - Office Code
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @throws EventException
	 */
	public static String getIsTPBOffice(String officeCode) throws EventException {
		
		String officeInfo = null;
		
		if ( officeCode!=null && officeCode.trim().length()>0 ) {
			CommonCodeBC command = new CommonCodeBCImpl();
			officeInfo = command.searchIsTPBOffice(officeCode);
		}
		
		return officeInfo;
	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다. 
	 * 레벨 : H > R >= S > C > T > G
	 * @param officeCode - Office Code
	 * @return String - Office Top Level ( H > R >= S > C > T > G )
	 * @throws EventException
	 */
	public static String getOfficeTopLevel(String officeCode) throws EventException {
		
		String officeInfo = null;
		
		if ( officeCode!=null && officeCode.trim().length()>0 ) {
			CommonCodeBC command = new CommonCodeBCImpl();
			officeInfo = command.searchOfficeTopLevel(officeCode);
		}
		
		return officeInfo;
	}
	
	/** 
	 * 공통코드를 Select Box로 가져와 사용하기 위한 html text를 생성한다. 
	 * com.hanjin.framework.component.util.JSPUtil.getCodeCombo mehtod에 대응되는 TPB 최적화 method
	 * @param tagName
	 * @param sDefaultSelectCode
	 * @param sOptionalSelectTag
	 * @param mainCode
	 * @param sortKey - rownum, intg_cd_id, code, name; 각각 1, 2, 3, 4; default 2; 정렬은 ASC
	 * @param addOption
	 * @return String - select-html tag text
	 * @throws EventException
	 */
	public static String getCodeCombo(String tagName, String sDefaultSelectCode, String sOptionalSelectTag, 
			String mainCode, int sortKey, String addOption) throws EventException {

		return TPBUtils.getCodeCombo(tagName, sDefaultSelectCode, sOptionalSelectTag, mainCode, sortKey, addOption);
	}
	
	/** 
	 * 공통코드를 Select Box로 가져와 사용하기 위한 html text를 생성한다. 
	 * com.hanjin.framework.component.util.JSPUtil.getCodeCombo mehtod에 대응되는 TPB 특성화 method
	 * @param tagName - HTML object(Select Box) name; e.g. "s_office_level"
	 * @param sDefaultSelectCode - HTML Select Box, selected Option Value; e.g. "G"
	 * @param sOptionalSelectTag - HTML Select Box, Added Text like style definition etc.; e.g. "style='width:110'"
	 * @param mainCode - Code id; com_intg_cd_dtl.intg_cd_id; e.g. "CD00925"
	 * @param sortKey - rownum, intg_cd_id, code, name; each of them... 1, 2, 3, 4; default 2; sorting order .. ASC
	 * @param addOption - Select Box Options; delimiter ':'; 1) temperary sortKey Value 2)temperary code 3) temperary option display value; e.g. "100000:S:&lt;Select&gt;"   
	 * @param sCodeCondition - code (com_intg_cd_dtl.intg_cd_val_ctnt) condition to retrieve; it's possible to use 'IN' or 'NOT IN' condition in SQL Where Clausee.g. "R|G|!H"
	 * @return String - select-html tag text; <br>e.g.<br> 
		&lt;SELECT name="s_office_level" style='width:110'&gt;<br>
		 &nbsp; &nbsp; &lt;OPTION value="S" &gt;&lt; Select&gt; &lt;/OPTION&gt;<br>
		 &nbsp; &nbsp; &lt;OPTION value="R" selected&gt;RHQ&lt;/OPTION&gt;<br>
		 &nbsp; &nbsp; &lt;OPTION value="G" selected&gt;GOO&lt;/OPTION&gt;<br>
		&lt;/SELECT&gt;<br>
	 * @throws EventException
	 */
	public static String getCodeCombo(String tagName, String sDefaultSelectCode, String sOptionalSelectTag, 
			String mainCode, int sortKey, String addOption, String sCodeCondition) throws EventException {
		///----- Arrange addOption -----
		String[] addOptionArr1 = null; 
		String[][] addOptionArr2 = null;
		String[] tempArr = null;
		if ( addOption !=null && addOption.trim().length()>0 ) { 
			addOptionArr1 = addOption.split("\\|");
			addOptionArr2 = new String[addOptionArr1.length][3];
			for(int k=0; k<addOptionArr1.length; k++){
				tempArr = addOptionArr1[k].split("\\:");
				if ( tempArr.length >= 3){
					addOptionArr2[k][0] = tempArr[0];
					addOptionArr2[k][1] = tempArr[1];
					addOptionArr2[k][2] = tempArr[2];
				}
			}
		}
		
		///----- Arrange sCodeCondition ----- 
		// !A|B|C|!D => ... NOT IN ('A','D') AND ... IN ('B','C') 
		String[] sCodeConditionArr  = null;
		StringBuffer sbCodeConditionPositive = new StringBuffer(""); 
		StringBuffer sbCodeConditionNegative = new StringBuffer("");
		int counterPositive = 0;
		int counterNegative = 0;
		if ( sCodeCondition != null && sCodeCondition.trim().length()>0 ){
			sCodeConditionArr = sCodeCondition.split("\\|");
			for (int k=0; k<sCodeConditionArr.length; k++){
				if ( sCodeConditionArr[k].trim().length()==0 ) { continue; } 
				if ( sCodeConditionArr[k].startsWith("!") ){
					if ( counterNegative > 0 ) { sbCodeConditionNegative.append( "|" ); } // at first allocation, remove '|'
					sbCodeConditionNegative.append( sCodeConditionArr[k].substring(1) ); // except '!'
					counterNegative++;
				} else {
					if ( counterPositive > 0 ) { sbCodeConditionPositive.append( "|" ); } // at first allocation, remove '|'
					sbCodeConditionPositive.append( sCodeConditionArr[k] );
					counterPositive++;
				}
			}
		}
		log.debug( " @@ sbCodeConditionPositive : " + sbCodeConditionPositive.toString() ) ;
		log.debug( " @@ sbCodeConditionNegative : " + sbCodeConditionNegative.toString() ) ;
		sCodeConditionArr = null; 

		String[] sCodeConditionArrPositive = null;
		String[] sCodeConditionArrNegative = null;
		if ( sbCodeConditionPositive.toString()!=null && sbCodeConditionPositive.toString().trim().length()>0 ){
			sCodeConditionArrPositive = sbCodeConditionPositive.toString().split("\\|");
		}
		if ( sbCodeConditionNegative.toString()!=null && sbCodeConditionNegative.toString().trim().length()>0 ){
			sCodeConditionArrNegative = sbCodeConditionNegative.toString().split("\\|");
		}
//		log.debug("mainCode=====>"+mainCode);
//		log.debug("sDefaultSelectCode=====>"+sDefaultSelectCode);
//		log.debug("addOptionArr2=====>"+addOptionArr2);
//		log.debug("sCodeConditionArrPositive=====>"+sCodeConditionArrPositive);
//		log.debug("sCodeConditionArrNegative=====>"+sCodeConditionArrNegative);
//		log.debug("sortKey=====>"+sortKey);
		///----- Getting Common code Result -----
		DBRowSet resultRs = null; //SORTKEY / INTG_CD_ID / CODE / NAME / SELECTEDYN
		if ( mainCode != null && mainCode.trim().length()>0 ){
			CommonCodeBC command = new CommonCodeBCImpl();
			resultRs = command.searchCodeComboData( 
					mainCode, 
					sDefaultSelectCode, 
					addOptionArr2, 
					sCodeConditionArrPositive, 
					sCodeConditionArrNegative, 
					sortKey);
		}
		addOptionArr1 = null;
		addOptionArr2 = null;
		tempArr = null; 
		
		///----- Generate html text ----- 
		//	<SELECT name = "s_office_level" style='width:110'>	<OPTION  selected value=""> &lt;Select&gt;</OPTION>
		//		<OPTION  value="H"> HO</OPTION>
		//		<OPTION  value="R"> RHQ</OPTION>
		//		<OPTION  value="G"> GO</OPTION>
		//	</SELECT>
		///----- resultArr ------- 
		//	SORTKEY	INTG_CD_ID	CODE	NAME	SELECTEDYN
		//	100010	CD00836		H		HO		N
		//	100015	{null}		-		<SELECT>N
		//	100020	CD00836		R		RHQ		Y
		
		StringBuffer str = new StringBuffer();
		String[] dataRowArr = null; 
//		String strSelected = null; 

		str.append( "<SELECT name=\"" + tagName + "\" " + sOptionalSelectTag + ">\r\n" );
		try {
			while ( resultRs!=null && resultRs.next() ){
				dataRowArr = new String[5];
				for(int n=0; n<5; n++){
					dataRowArr[n] = resultRs.getString(n+1);
					if ( dataRowArr[n]==null ) { dataRowArr[n] = ""; }
				}			
//				if ( dataRowArr[4]!=null && dataRowArr[4].equals("Y") ) { strSelected = " selected"; } 
//				else { strSelected = ""; }			
				str.append( "\t<OPTION value=\"" + dataRowArr[2] + "\"" + (dataRowArr[4].equals("Y")?" selected":"") + ">" );
				str.append( dataRowArr[3] + "</OPTION>\r\n" );
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
		str.append( "</SELECT>" );
		
		
		return str.toString();
	}
	
	/**
	 * invoice No.의  file No를 구한다.  
	 * @param invNo 
	 * @return String fileNo
	 * @throws EventException
	 */
//	public static String getInvFileNo(String invNo) throws EventException {
//		
//		String fileNo = null;
//		
//		if ( invNo!=null && invNo.trim().length()==11 ) {
//			CommonCodeBC command = new CommonCodeBCImpl();
//			fileNo = command.getInvFileNo(invNo);
//		}
//		
//		return fileNo;
//	}
	
	/**
	 * invoice No.의  file No를 구한다.  
	 * @return String
	 * @throws EventException
	 */
	public static String searchTPBSeq() throws EventException {
		
		String tpbSeq = null;
		
		CommonCodeBC command = new CommonCodeBCImpl();
		tpbSeq = command.searchTPBSeq();
		
		return tpbSeq;
	}
	
//	/**
//	 * xml 특수문자를 변환한다.<BR>
//	 * 특별히 TPB의 경우 ERP A/R Interface(WTC방식)시에 사용한다.    
//	 * @param str - 변환할 원본 문자열  
//	 * @return String - 변환된 문자열
//	 * @throws EventException
//	 */
//	public static String replaceXmlSpecialCharacter(String str) throws EventException {
//		
//		if ( str==null ) { return str; }
//
//		try {
//			str = JSPUtil.replace(str,"&","&amp;"); 
//			str = JSPUtil.replace(str,">","&gt;"); 
//			str = JSPUtil.replace(str,"<","&lt;"); 
//			str = JSPUtil.replace(str,"\"","&quot;"); 
//			str = JSPUtil.replace(str,"'","&apos;");
//		} catch (Exception e) {
//			str = null;
//			log.error(e.getMessage(), e);
//			throw new EventException(e.getMessage());
//		} 
//		
//		return str;
//	}
}
