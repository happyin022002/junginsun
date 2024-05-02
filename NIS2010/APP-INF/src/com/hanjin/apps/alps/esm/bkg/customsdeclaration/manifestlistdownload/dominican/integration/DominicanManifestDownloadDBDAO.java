/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DominicanManifestDownloadDBDAO.java
 *@FileTitle : DominicanManifestDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.04
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2013.07.04 경종윤
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration.EurCustomsTransmissionDBDAOaddEurCrnAckCSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestBLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic.Eur24ManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestOBListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrMFListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrSealNoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlDangerCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlGeneralInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010 DominicanManifestDownloadDBDAO <br>
 * - NIS2010-Eur24ManifestDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Gyoung Sub
 * @see Eur24ManifestDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public class DominicanManifestDownloadDBDAO extends DBDAOSupport{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public DominicanManifestDownloadDBDAO() {}

	/**
	 * BL 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchDominicanManifestList(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DominicanManifestDownloadDBDAOsearchDominicanManifestListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DominicanManifestListDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * vessel 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return DominicanVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DominicanVslInfoVO searchVslInfo(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DominicanVslInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DominicanVslInfoVO retVO =null;
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DominicanManifestDownloadDBDAOsearchVslInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DominicanVslInfoVO.class);
			
			if (list != null && list.size() > 0) {
				retVO = list.get(0);
			}
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVO;
	}
	
	/**
	 * BL, customer 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DominicanManifestBLVO> searchManifestBL(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DominicanManifestBLVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DominicanManifestDownloadDBDAOsearchManifestBLRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DominicanManifestBLVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL, customer 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DominicanManifestContainerVO> searchManifestContainer(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DominicanManifestContainerVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DominicanManifestDownloadDBDAOsearchManifestContainerRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DominicanManifestContainerVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
}