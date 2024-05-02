/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComboUtil.java
*@FileTitle : AGT ComboBox Utility
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.agt.common.event.CodeInfo;
import com.hanjin.framework.component.util.JStringTokenizer;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * jsp에서 기본적으로 사용하는 Util method 모음 각 method는 static 이므로, JSPUtil.methodXXX() 로 호출하여 사용한다. <br>
 * JSPUtil의 method 는 크게 Request, 문자열 변환, HTML, Date 그리고, math 관련 method로 구성되어 있다.
 *
 * @author junghyung kim
 * @see ESM_AGT_xxx.jsp 참조
 * @since J2EE 1.4
 */
public final class ComboUtil {

	//log 객체
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ComboUtil.class);

	/**
	 * ComboUtil 생성자
	 */
	//private ComboUtil() {}

	/**
	 * IBSheet 에서 Select List Box를 만드는 javascript 변수를 정의하여 return 
	 * @param tagName       자바스크립트에서 사용할 변수 이름
	 * @param sSelectedCode 선택될 코드
	 * @param sOptionalSelectTag 추가옵션
	 * @param codeItem      반환할 업무 대상
	 * @param searchCode    Where절에 들어갈 코드 값 
	 * @param rtnType       name : name을 리턴/code :code를 리턴/없으면 name과 code를 모두 리턴
	 * @param addOption     추가할 option string
	 * @return String
	 * @throws EventException
	 */
	public static String getIBCodeCombo(String tagName,String sSelectedCode, String sOptionalSelectTag, String codeItem,
			String searchCode, String rtnType, String addOption) throws EventException {
		StringBuffer sbText = new StringBuffer();
		StringBuffer sbValue = new StringBuffer();
		List totalList = new ArrayList();
		String rtnVaule = "";
		
		log.debug("===================================================================");
		log.debug("getIBCodeCombo : ["+tagName+"]["+codeItem+"]["+searchCode+"]["+sOptionalSelectTag+"][" + sSelectedCode + "]");
		log.debug("===================================================================");

		Collection codeList = CodeUtil.getInstance().getCodeSelect(codeItem, searchCode);
		JStringTokenizer stringTokenizer = new JStringTokenizer(addOption, "|");
		log.debug("count:::" + stringTokenizer.countTokens());

		while (stringTokenizer.hasMoreElements()) {
			String strCodeModel = (String) stringTokenizer.nextElement();
			log.debug("strCodeModel:::" + strCodeModel);
			JStringTokenizer stringTokenizer1 = new JStringTokenizer(strCodeModel, ":");
			CodeInfo codeModel = new CodeInfo();
			
			while (stringTokenizer1.hasMoreElements()) {
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setSortKey(((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setSortKey("");
				}
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setCode(((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setCode("");
				}
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setName(((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setName("");
				}
			}
			totalList.add(codeModel);

		}
		
		Iterator iterator = codeList.iterator();
		while (iterator.hasNext()) {
			CodeInfo codeModel = (CodeInfo) iterator.next();
			totalList.add(codeModel);
		}

		Iterator totalIterator = totalList.iterator();
		CodeInfo codeModel = null;

		if(rtnType.equals("")){
			codeModel = (CodeInfo) totalIterator.next();
			sbText.append("var ").append(tagName).append("Text").append(" = \"");
			sbText.append(codeModel.getName());
			sbValue.append("var ").append(tagName).append("Code").append(" = \"");
			sbValue.append(codeModel.getCode());
		}

		int i = 0;
		while (totalIterator.hasNext()) {
			codeModel = (CodeInfo) totalIterator.next();
			sbText.append("|");
			sbText.append(codeModel.getName());
			sbValue.append("|");
			sbValue.append(codeModel.getCode());
			i++;
		}
		
		if(sbText.toString().equals("")){
			sbText.append(" |");
			sbValue.append(" |");
		}
		if (sbText.length() > 0 && rtnType.equals("")) {
			sbText.append("\";");
			sbValue.append("\";");
		}
				
		if(rtnType.equals("name")){
			rtnVaule = " " + sbText.toString();
			log.debug(tagName + "Name value  : " +rtnVaule);
		}else if(rtnType.equals("code")){
			rtnVaule = " " + sbValue.toString();
			log.debug(tagName + "Code value  : " +rtnVaule);
		}else{
			rtnVaule = " " + sbText.append("\n").append("" + sbValue).toString();
			log.debug(tagName + "Code&Name value  : " +rtnVaule);
		}
		log.debug("===================================================================");
		
		return rtnVaule;
	}

	/**
	 * SELECT box HTML 코드를 return.
	 * 
	 * @param tagName		Select List Box의 name
	 * @param sSelectedCode	선택될 코드
	 * @param sOptionalSelectTag   SELECT tag 에 선택적으로 추가할 element( onChange 이벤트등 )
	 * @param codeItem		반환할 업무 대상
	 *  					01.A/R Office Code		: arOfcCd
	 *  					02.Subject Office Code	: sbOfcCd
	 * 
	 * @param searchCode	Where절에 들어갈 코드 값
	 * @param spaceYN		Option의 첫항목에 space를 넣을지 유무 
	 *                      Y     : 첫번째 option항목에 <option value=""></option>으로 채워짐
	 *                      N, "" : 첫번째 option항목에 스페이스를 채우지 않음
	 *                      문자열 : Y,N,"" 이 아니고 문자열이 들어오면 해당 문자열로 첫번째 option항목의 text를 채워짐
	 *                               <option value="">문자열</option> 
	 * @param addOption		추가할 option string
	 * @return String
	 * @throws EventException
	 */
	public static String getCodeCombo(String tagName, String sSelectedCode, String sOptionalSelectTag, String codeItem,
			String searchCode, String spaceYN, String addOption) throws EventException {

		log.debug("===================================================================");
		log.debug("getCodeCombo : ["+tagName+"]["+codeItem+"]["+searchCode+"]["+spaceYN+"]");
		log.debug("===================================================================");

		StringBuffer sb = new StringBuffer("");

		sb.append("<SELECT name=\"" + tagName + "\" " + sOptionalSelectTag + ">\n");
		if(spaceYN.equals("Y")){
			sb.append("\t<OPTION value=''></OPTION>\n");
		}else if(!spaceYN.equals("N") && !spaceYN.equals("")){
			sb.append("\t<OPTION value=''>"+spaceYN+"</OPTION>\n");
		}
		
		Collection codeList = CodeUtil.getInstance().getCodeSelect(codeItem, searchCode);

		List totalList = new ArrayList();
		JStringTokenizer stringTokenizer = new JStringTokenizer(addOption, "|");

		while (stringTokenizer.hasMoreElements()) {
			String strCodeModel = (String) stringTokenizer.nextElement();
			log.debug("strCodeModel:::" + strCodeModel);
			JStringTokenizer stringTokenizer1 = new JStringTokenizer(strCodeModel, ":");
			CodeInfo codeModel = new CodeInfo();
			while (stringTokenizer1.hasMoreElements()) {
				
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setSortKey( ((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setSortKey("");
				}
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setCode(((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setCode("");
				}
				if (stringTokenizer1.hasMoreTokens()) {
					codeModel.setName(((String) stringTokenizer1.nextToken()).trim());
				} else {
					codeModel.setName("");
				}
			}

			totalList.add(codeModel);
		}

		Iterator iterator = codeList.iterator();
		while (iterator.hasNext()) {
			CodeInfo codeModel = (CodeInfo) iterator.next();
			totalList.add(codeModel);
		}

		Iterator totalIterator = totalList.iterator();
		while (totalIterator.hasNext()) {
			CodeInfo codeModel = (CodeInfo) totalIterator.next();
			sb.append("\t<OPTION");
			sb.append(sSelectedCode.equals(codeModel.getCode()) ? " selected " : " ");
			sb.append("value=\"" + codeModel.getCode() + "\">" + codeModel.getName() + "</OPTION>\n");
		}

		sb.append("</SELECT>");
		log.debug(sb.toString());
		log.debug("===================================================================");

		return sb.toString();
	}
	
	/**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @return
	 * @throws EventException
	 */
	public static HashMap getCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException {
		HashMap h = new HashMap();
		StringBuffer sbText = new StringBuffer();
		StringBuffer sbValue = new StringBuffer();
		List totalList = new ArrayList();
		
		log.debug("===================================================================");
		log.debug("getIBCodeCombo : ["+tagName+"]["+codeItem+"]["+searchCode+"]");
		log.debug("===================================================================");

		Collection codeList = CodeUtil.getInstance().getCodeSelect(codeItem, searchCode);
		Iterator iterator = codeList.iterator();
		while (iterator.hasNext()) {
			CodeInfo codeModel = (CodeInfo) iterator.next();
			totalList.add(codeModel);
		}

		Iterator totalIterator = totalList.iterator();
		CodeInfo codeModel = null;

		int i = 0;
		String tmpStr = "";
		while (totalIterator.hasNext()) {
			codeModel = (CodeInfo) totalIterator.next();
			if(tmpStr.equals(codeModel.getSortKey()) || tmpStr.equals("")){
				sbText.append("|");
				sbText.append(codeModel.getName());
				sbValue.append("|");
				sbValue.append(codeModel.getCode());
				i++;				
			}else{
				if(tmpStr.equals(""))tmpStr = codeModel.getSortKey() ;
				if(rtnType.equals("name")){
					h.put(tmpStr, " " +sbText.toString());
					log.debug(tmpStr + " : " + sbValue.toString());
				}else if(rtnType.equals("code")){
					h.put(tmpStr, " " +sbValue.toString());
					log.debug(tmpStr + " : " + sbValue.toString());
				}	
				sbText = new StringBuffer();
				sbValue = new StringBuffer();
				
				sbText.append("|");
				sbText.append(codeModel.getName());
				sbValue.append("|");
				sbValue.append(codeModel.getCode());
			}
			tmpStr = codeModel.getSortKey();
		}
		if(!sbText.toString().equals("")){
			if(rtnType.equals("name")){
				h.put(tmpStr, " " +sbText.toString());
				log.debug(tmpStr + " : " + sbValue.toString());
			}else if(rtnType.equals("code")){
				h.put(tmpStr, " " +sbValue.toString());
				log.debug(tmpStr + " : " + sbValue.toString());
			}
		}		
		log.debug("===================================================================");
		return h;		
		
	}
}// end of class
