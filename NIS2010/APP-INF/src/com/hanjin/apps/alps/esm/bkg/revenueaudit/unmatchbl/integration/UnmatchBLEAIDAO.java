/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLEAIDAO.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.20 
* 1.0 Creation
* ======================================================================
* History
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
=========================================================
* History
*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 UnmatchBLEAIDAO <br>
 * - NIS2010-RevenueAudit system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see UnmatchBLBCImpl 참조
 * @since J2EE 1.6
 */
public class UnmatchBLEAIDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -4360544808457882816L;

	/**
	 * searchSelfAuditList 결과를 조회하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return RlstSearchSelfAuditListVO
	 * @exception Exception, DAOException
	 */
	public RlstSearchSelfAuditListVO searchSelfAuditList(String key) throws Exception, DAOException {
		try {
			return (RlstSearchSelfAuditListVO)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Re-audit BackEndJob 결과를 확인하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchReauditBackEndJobResult(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}
