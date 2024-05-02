/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationDBDAO.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.agreement.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * AgreementDBDAO <br>
 * LseCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see AgreementRegistrationBCImpl 참조
 * @since J2EE 1.6
 */
public class AgreementDBDAO extends DBDAOSupport {

	/**
	 * Lease Agreement No. 로 Agreement 조회<br>
	 *
	 * @param String agmtCytCd
	 * @param String agmtSeq
	 * @return List<AgreementVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementVO> searchAgreementBrieflyData(String agmtCytCd, String agmtSeq) throws DAOException {

		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agmtSeq != null){

				param.put("agmt_cty_cd", agmtCytCd);
				param.put("agmt_seq", agmtSeq);

				velParam.put("agmt_cty_cd", agmtCytCd);
				velParam.put("agmt_seq", agmtSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementDBDAOAgreementBrieflyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Vendor 의 해당 Lease Term Agreement 조회<br>
	 *
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @return List<AgreementVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementVO> searchAgreementLessorBrieflyData(String vndrSeq, String lstmCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vndrSeq != null){

				param.put("vndr_seq",    vndrSeq);
				param.put("lstm_cd",     lstmCd);
				velParam.put("vndr_seq", vndrSeq);
				velParam.put("lstm_cd",  lstmCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementDBDAOAgreementLessorBrieflyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Vendor List 로 해당 Lease Agreement 조회<br>
	 *
	 * @param String vndrSeq
	 * @return List<AgreementVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementVO> searchAgreementByVendorBrieflyData(String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			List<String> arrVndrSeq  = null;

			if ( !JSPUtil.getNull(vndrSeq).equals("") ) {
				arrVndrSeq = JSPUtil.convertStringToArrayList(vndrSeq);
				param.put("vndr_seq", arrVndrSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementDBDAOAgreementByVendorBrieflyRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}