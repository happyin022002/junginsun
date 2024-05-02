/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestListDownloadDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS MalaysiaManifestListDownloadDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon, Jong-Geon
 * @see MalaysiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class MalaysiaManifestListDownloadDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1141화면, B/L info를 조회한다.
	 * 
	 * @param MalaysiaManifestListCondVO inputVO
	 * @return List<MalaysiaManifestListBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestListBlInfoVO> searchCustomsBlInfo(MalaysiaManifestListCondVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MalaysiaManifestListBlInfoVO> list = null;

		try
		{			
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestListBlInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 1141화면, Container info를 조회한다.
	 * 
	 * @param MalaysiaManifestListCondVO inputVO
	 * @return List<MalaysiaManifestListCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MalaysiaManifestListCntrInfoVO> searchCustomsCNTRInfo(MalaysiaManifestListCondVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List <MalaysiaManifestListCntrInfoVO> list = null;

		try
		{			
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
            
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestListCntrInfoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * 1141화면, EDI Transmit Ship Call No.,Vsl Id 정보를 조회한다.
	 * 
	 * @param MalaysiaManifestListCondVO inputVO
	 * @return MalaysiaManifestVslInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MalaysiaManifestVslInfoVO searchShipCallNoVslId(MalaysiaManifestListCondVO inputVO) throws DAOException {
	
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO = null;
	
		try
		{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	        
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MalaysiaManifestListDownloadDBDAOSearchSrnVslIdRSQL(), param, velParam);
			List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, MalaysiaManifestVslInfoVO.class);
	
			if (list != null && list.size() > 0)
			{
				malaysiaManifestVslInfoVO = (MalaysiaManifestVslInfoVO) list.get(0);
			}
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return malaysiaManifestVslInfoVO;
	}	
}
