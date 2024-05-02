/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: CodeUtil.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-11-16 Park Eun Ju
* 1.0 최초 생성
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정 getCodeCombo 추가

=========================================================*/

package com.hanjin.apps.alps.esd.lea.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration.CodeComboUtilDBDAO;
import com.hanjin.apps.alps.esd.lea.common.codecomboutil.event.CodeInfo;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JStringTokenizer;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

  
/**
 * @author  
 * @see 
 * @since J2EE 1.4
 */
public final class CodeComboUtil {

	// log 객체
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CodeComboUtil.class);
	
    /**
     *  codeComboDAO 객체
     */
    private transient static CodeComboUtilDBDAO codeComboDAO = null;

    /**
     *  CodeUtil 객체
     */
    private static CodeComboUtil instance = new CodeComboUtil();
    
//    private static String MAIN_COST_TYPE_CD	= "MAIN_COST_TYPE_CD"	;
//    private static String SUB_COST_TYPE_CD	= "SUB_COST_TYPE_CD"	;

    /**
     * 1. 기능 : CodeInfo getInstance()<p>
     * 2. 처리개요 :  <p>
     *    - 객체생성시에 instance를 만들고 공유한다. <p>
     * 3. 주의사항 : <p>
     * @return CodeUtil
     **/    
    public static CodeComboUtil getInstance() {
        return instance;
    }
 
    /**
     * 1. 기능 : CodeUtil 생성자<p>
     *
     **/
    private CodeComboUtil() {
        codeComboDAO = new CodeComboUtilDBDAO();
    }

    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param sCodeType  	업무 구분
	 *  					01.Cost Type Code 1		:          => LEA_SUB_COST_TP
	 *  					02.Cost Type Code 2		:          => LEA_SUB_COST_TP
	 *                      
     * @param code      	Where절에 들어갈 코드
     * @return
     * @throws EventException
     */
    public static DBRowSet getCodeComboList20(String sCostKind, String sMainCostTypeCode) throws EventException {
    	DBRowSet 	dRs 			= null;
//		int			i				= 0;
		
	        try {	        	
	        	dRs	= codeComboDAO.searchCostCodeComboList(sCostKind, sMainCostTypeCode);
	        	
	    	}catch (DAOException de) {
	            log.error("DAOException : " +de.getMessage());
	            throw new EventException("DAOException : " + de.getMessage());
	        } catch(Exception ex){
	        	log.error("Exception : " +ex.getMessage());
	        	throw new EventException("Exception : " + ex.getMessage());
	        }
	       	return dRs;
   }    
    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem  	업무 구분
	 *  					01.A/R Office List	: arOfcCd (Office Code로 A/R Office List 찾기)
	 *                         A/R Ofiice Code  : arOfcCd2 (Office Code로 A/R Office Code 찾기)
	 *  					02.Subject Office Code	: sbOfcCd (A/R Office COde로 하위 Office List 찾기)
	 *                      
     * @param code      	Where절에 들어갈 코드
     * @return Collection
     * @throws EventException
     */
    public Collection getCodeSelect(String codeItem, String code) throws EventException {
    	DBRowSet dRs = null;
    	ArrayList arrList = null;
		Collection codeList = null;
		
        try {
        	if(codeItem.equals("lgsOFC")){		 			// 1. A/R Office List
        		dRs = codeComboDAO.searchLogisticsOfficeCodeList(code);
        	}
        	
        	if(dRs != null){
        		arrList = new ArrayList();

        		while(dRs.next()){
					arrList.add(new CodeInfo(dRs.getString("code"), dRs.getString("name")));
				}
				
				codeList = arrList;
        	}
			
            return codeList;

        } catch(SQLException se){
            log.error(se.getMessage());
            throw new EventException("Code Exception : " + se.getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
    
	/**
	 * SELECT box HTML 코드를 return.
	 * 
	 * @param tagName		Select List Box의 name
	 * @param sSelectedCode	선택될 코드
	 * @param sOptionalSelectTag   SELECT tag 에 선택적으로 추가할 element( onChange 이벤트등 )
	 * @param codeItem		반환할 업무 대상
	 *  					01.Logistics Office Code		: lgsOFC
	 *
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
		
		Collection codeList = CodeComboUtil.getInstance().getCodeSelect(codeItem, searchCode);

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
   
}
