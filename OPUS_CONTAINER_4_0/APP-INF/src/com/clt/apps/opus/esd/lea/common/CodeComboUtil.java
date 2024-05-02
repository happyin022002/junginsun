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

=========================================================*/

package com.clt.apps.opus.esd.lea.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.clt.apps.opus.esd.lea.common.codecomboutil.integration.CodeComboUtilDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;


  
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
    
    private static String MAIN_COST_TYPE_CD	= "MAIN_COST_TYPE_CD"	;
    private static String SUB_COST_TYPE_CD	= "SUB_COST_TYPE_CD"	;

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
		int			i				= 0;
		
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
    
   
}
