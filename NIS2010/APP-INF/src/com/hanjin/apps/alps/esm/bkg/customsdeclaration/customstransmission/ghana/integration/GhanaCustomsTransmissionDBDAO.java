/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GhanaCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG_1142
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.04.12 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.vo.GhanaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 GhanaCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM
 * @see GhanaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class GhanaCustomsTransmissionDBDAO extends DBDAOSupport {
	
	/**
	 * 가나세관에 Manifest 신고한 BL 전송 History를 생성한다.
	 * 
	 * @param GhanaManifestTransmitVO ghanaManifestTransmitVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBlSendLog(GhanaManifestTransmitVO ghanaManifestTransmitVO) throws DAOException,Exception {
		
		int result= 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (ghanaManifestTransmitVO != null) {
				Map<String, String> mapVO = ghanaManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new GhanaCustomsTransmissionDBDAOaddBlSendLogCSQL(), param, velParam);
			
 			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
