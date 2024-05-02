/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAO.java
*@FileTitle : ChinaCustomsTransmissionDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaAckVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlChargeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCMCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusBlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusDangerCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaCncusVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.CstmsEmlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoSKDVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.MailContentsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsChnSndLogBlVO;
import com.clt.syscommon.common.table.BkgCstmsChnSndLogCntrVO;
import com.clt.syscommon.common.table.BkgCstmsChnSndLogVO;


/**
 * OPUS CustomsTransmissionDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Subin
 * @see ChinaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class ChinaCustomsTransmissionDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 3447327723043443513L;

	/**
	 * B/L Info 조회
	 * @param String blNo
	 * @param String transMode
	 * @return ChinaBlGeneralListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChinaBlGeneralListVO searchBlGeneral(String blNo, String transMode) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaBlGeneralListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			velParam.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlGeneralListVO.class);

			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Container 조회
	 * @param String blNo
	 * @param String transMode
	 * @return List<ChinaBlCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaBlCntrListVO> searchBlCntr(String blNo, String transMode) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaBlCntrListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			velParam.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchBlCntrRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlCntrListVO.class);
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * B/L Customer 조회
	 * @param String blNo
	 * @param String transMode
	 * @return List<ChinaBlCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaBlCustListVO> searchBlCust(String blNo, String transMode) throws DAOException	{
		DBRowSet dbRowset = null;
		List<ChinaBlCustListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			velParam.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchBlCustRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlCustListVO.class);
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * B/L Danger Container 조회
	 * @param String blNo
	 * @param String transMode
	 * @return List<ChinaBlDangerCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaBlDangerCntrListVO> searchBlDangerCntr(String blNo, String transMode) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<ChinaBlDangerCntrListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			velParam.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchBlDangerCntrRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlDangerCntrListVO.class);
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param ChinaContainerCondVO containerCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchContainerType(ChinaContainerCondVO containerCondVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String tpszCd = null;

		try {
			Map<String, String> mapVO = containerCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchContainerTypeRSQL(),param, velParam);
			if(dbRowset.next()) tpszCd = dbRowset.getString("CNTR_NO") + "\t" + dbRowset.getString("CNTR_TPSZ_CD");
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return tpszCd;
	}

	/**
	 * B/L VVD Info 조회
	 * @param VvdKeyVO vvdKeyVO
	 * @return ChinaVvdInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChinaVvdInfoVO searchCncusVvdInfo(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaVvdInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusVvdInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaVvdInfoVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L VVD Info 조회
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaBlInfoListVO> searchManifestList(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaBlInfoListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchManifestListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlInfoListVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * Transmit 대상 B/L 리스트 데이터 갯수 조회 - CSV 저장용<br>
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchManifestDetailListCount(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		String total = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdKeyVO != null){
				Map<String, String> mapVO = vvdKeyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaCustomsTransmissionDBDAOsearchManifestDetailListCountRSQL(), param, velParam);
			if(dbRowset.next()) {
				total = Integer.toString(dbRowset.getInt(1));
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return total;
	}

	/**
	 * Transmit 대상 B/L 리스트 조회 - CSV 저장용<br>
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<BlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BlInfoVO> searchManifestDetailList(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchManifestDetailListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlInfoDetailListVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송 내역 검사를 위해 로그 데이터 건수를 조회한다.<br>
	 *
	 * @param String blNo
	 * @param String transMode
	 * @return Integer
	 * @exception DAOException
	 */
	public int searchSendLogVvd(String blNo, String transMode) throws DAOException {
		DBRowSet dbRowset = null;
		int count = -1;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			velParam.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchSendLogVvdRSQL(),param, velParam);
			if(dbRowset.next()){
				count = dbRowset.getInt("CNT");
			}
			return count;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 POL 조회<br>
	 *
	 * @param List<TransKeyVO> transKeyVOList
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> searchVvdInfo(List<TransKeyVO> transKeyVOList) throws DAOException {
		List<String> list = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (transKeyVOList.size() > 0) {
				param.put("vvd", transKeyVOList.get(0).getVvd());
				param.put("trans_mode", transKeyVOList.get(0).getTransMode());
				param.put("loc_cd", transKeyVOList.get(0).getLocCd());
				velParam.put("trans_mode", transKeyVOList.get(0).getTransMode());

				List<String> arrString = new ArrayList();  //BL_NO
				for (TransKeyVO transKeyVO : transKeyVOList) arrString.add(transKeyVO.getBlNo());
				velParam.put("field_list", arrString);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchVvdInfoRSQL(), param, velParam);
			while (dbRowset.next()) list.add(dbRowset.getString("LOC_CD"));
			return list;

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 VSL 정보 조회<br>
	 *
	 * @param String vvd
	 * @return ChinaVslInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChinaVslInfoVO searchVslInfo(String vvd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchVslInfoRSQL(), param, velParam);
			List<ChinaVslInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaVslInfoVO.class);
			if (list.size() > 0){
				return list.get(0);
			} else {
				return null;
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 VVD 정보 조회<br>
	 *
	 * @param TransKeyVO transKeyVO
	 * @param String pol
	 * @param String portCd
	 * @return ChinaCncusVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChinaCncusVvdVO searchCncusVvd(TransKeyVO transKeyVO, String pol, String portCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = transKeyVO.getColumnValues();
			param.putAll(mapVO);
			param.put("pol", pol);
			param.put("port_cd", portCd);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL(), param, velParam);
			List<ChinaCncusVvdVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaCncusVvdVO.class);
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 VVD 정보 조회<br>
	 *
	 * @param List<TransKeyVO> transKeyVOList
	 * @param String locCd
	 * @return List<ChinaCncusBlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaCncusBlListVO> searchCncusBl(List<TransKeyVO> transKeyVOList, String locCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (transKeyVOList.size() > 0) {
				param.put("bl_no", transKeyVOList.get(0).getBlNo());
				param.put("loc_cd", locCd);
				param.put("trans_mode", transKeyVOList.get(0).getTransMode());
				velParam.put("trans_mode", transKeyVOList.get(0).getTransMode());

				List<String> arrString = new ArrayList();  //BL_NO
				for (TransKeyVO transKeyVO : transKeyVOList) arrString.add(transKeyVO.getBlNo());
				velParam.put("field_list", arrString);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusBlRSQL(), param, velParam);
			List<ChinaCncusBlListVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaCncusBlListVO.class);
			return list;

		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 Cons_Voy 정보 조회<br>
	 *
	 * @param TransKeyVO transKeyVO, String pol
	 * @return String
	 * @exception DAOException
	 */
	public String getConsVoy(TransKeyVO transKeyVO, String pol) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = transKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("pol", pol);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOGetConsVoyRSQL(), param, velParam);
			String consVoy = "";
			if (dbRowset.next()) consVoy = dbRowset.getString("CONS_VOY");
			return consVoy;
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 B/L Cargo 정보 조회<br>
	 *
	 * @param String blNo
	 * @return List<ChinaBlChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<ChinaBlChargeVO> searchBlCharge(String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchBlChargeRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlChargeVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * flatFile 생성을 위한 Danger Cargo 정보 조회<br>
	 *
	 * @param String blNo
	 * @param String transMode
	 * @param String dcgoSeq
	 * @return List<ChinaCncusDangerCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaCncusDangerCntrVO> searchCncusDangerCntr(String blNo, String transMode, String dcgoSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaCncusDangerCntrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			param.put("trans_mode", transMode);
			param.put("dcgo_seq", dcgoSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaCncusDangerCntrVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 Container 정보 조회<br>
	 *
	 * @param String blNo
	 * @param String transMode
	 * @return List<ChinaCncusCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaCncusCntrVO> searchCncusCntr(String blNo, String transMode) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaCncusCntrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			param.put("trans_mode", transMode);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusCntrRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaCncusCntrVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * VVD 데이터 전송 로그를 생성한다.<br>
	 *
	 * @param BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO
	 * @param String blNo
	 * @exception DAOException
	 */
	public void addSendLogVvd (BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO, String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgCstmsChnSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("bl_no", blNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaCustomsTransmissionDBDAOaddSendLogVvdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL 데이터 전송 로그를 생성한다.<br>
	 *
	 * @param BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO
	 * @param String transMode
	 * @exception DAOException
	 */
	public void addSendLogBl (BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO, String transMode) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgCstmsChnSndLogBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("trans_mode", transMode);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaCustomsTransmissionDBDAOaddSendLogBlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container 데이터 전송 로그를 생성한다.<br>
	 *
	 * @param BkgCstmsChnSndLogCntrVO bkgCstmsChnSndLogCntrVO
	 * @exception DAOException
	 */
	public void addSendLogCntr (BkgCstmsChnSndLogCntrVO bkgCstmsChnSndLogCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgCstmsChnSndLogCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaCustomsTransmissionDBDAOaddSendLogCntrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_CHN_SND_LOG 테이블에 수신 데이터를 업데이트한다.<br>
	 *
	 * @param List<ChinaAckVO> ackVOs
	 * @exception DAOException
	 */
	public void modifyAckMsg (List<ChinaAckVO> ackVOs) throws DAOException {
		int updCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.putAll(ackVOs.get(0).getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsTransmissionDBDAOmodifyAckMsgUSQL(), ackVOs, velParam);

			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_CHN_ACK_MSG 테이블에 수신 데이터를 Insert 한다. 2011.06.27 add<br>
	 *
	 * @param List<ChinaAckVO> ackVOs
	 * @exception DAOException
	 */
	public void addAckMsg (List<ChinaAckVO> ackVOs) throws DAOException {
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			insCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsTransmissionDBDAOaddAckMsgCSQL(), ackVOs, null);

			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BBKG_CSTMS_CHN_SND_LOG 테이블에서 ACK_RCV_DT_MSG를 조회한다. 2011.06.27 add<br>
	 *
	 * @param String ediRefId
	 * @return String[] sndMsg
	 * @exception DAOException
	 */
	public String[] searchAckMsg (String ediRefId) throws DAOException {
		DBRowSet dbRowset = null;
		String[] sndMsg = new String[2];

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("edi_ref_id", ediRefId);
			velParam.put("edi_ref_id", ediRefId);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchAckMsgRSQL(),param, velParam);
			if(dbRowset.next()){
				sndMsg[0] = dbRowset.getString("ACK_RCV_DT_MSG");
				sndMsg[1] = dbRowset.getString("AGN_ACK_RCV_DT_MSG");
			}
			return sndMsg;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CSTMS_CHN_SND_LOG_BL 테이블의 AGN컬럼에 수신 데이터를 업데이트한다.(MSG KIND : CNCRSP)<br>
	 *
	 * @param List<ChinaAckVO> ackVOs
	 * @exception DAOException
	 */
	public void modifyBlAckMsgForAgn(List<ChinaAckVO> ackVOs) throws DAOException {
		try {
			if (ackVOs.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new ChinaCustomsTransmissionDBDAOmodifyBlAckMsgForAgnUSQL(), ackVOs, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_CHN_SND_LOG_BL 테이블에 수신 데이터를 업데이트한다.(MSG KIND : RESPON)<br>
	 *
	 * @param List<ChinaAckVO> ackVOs
	 * @exception DAOException
	 */
	public void modifyBlAckMsg(List<ChinaAckVO> ackVOs) throws DAOException {
		try {
			if (ackVOs.size() > 0) {
				int updCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new ChinaCustomsTransmissionDBDAOmodifyBlAckMsgUSQL(), ackVOs, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_CHN_SND_LOG_CNTR 테이블에 수신 데이터를 업데이트한다.<br>
	 *
	 * @param List<ChinaAckVO> ackVOs
	 * @exception DAOException
	 */
	public void modifyCntrAckMsg (List<ChinaAckVO> ackVOs) throws DAOException {
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			updCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaCustomsTransmissionDBDAOmodifyCntrAckMsgUSQL(), ackVOs, null);

			for (int i = 0; i < updCnt.length; i++) {
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No" + i + " SQL");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L VVD Info 조회
	 * @param VvdKeyVO vvdKeyVO
	 * @return ChinaVvdInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChinaVvdInfoVO searchCncusTmlVvdInfo(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaVvdInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCncusTmlVvdInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaVvdInfoVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L VVD Info 조회
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChinaBlInfoListVO> searchTmlManifestList(VvdKeyVO vvdKeyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaBlInfoListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vvdKeyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchTmlManifestListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaBlInfoListVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 Terminal VSL 정보 조회<br>
	 *
	 * @param String vvd
	 * @param String blType
	 * @return TmlVslInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TmlVslInfoVO searchTmlVslInfo(String vvd, String blType) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmlVslInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("bl_type", blType);
			velParam.put("bl_type", blType);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchTmlVslInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmlVslInfoVO.class);

			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 B/L 정보 조회<br>
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @return List<TmlBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TmlBlVO> searchTmlBlInfo(List<TransKeyVO> transKeyVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmlBlVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", transKeyVOs.get(0).getBkgNo());

			String strBkgNo = null;
			 List<String> arrString = new ArrayList();  //BKG_NO
			 for (int i=0; i<transKeyVOs.size(); i++) {
				 strBkgNo = transKeyVOs.get(i).getBlNo();
				 arrString.add(strBkgNo);
			 }
			 velParam.put("field_list", arrString);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchTmlBlInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmlBlVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 Container 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return List<TmlCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TmlCntrVO> searchTmlCntrInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmlCntrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchTmlCntrInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmlCntrVO.class);

			return list;
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * flatFile 생성을 위한 Container 정보 조회<br>
	 *
	 * @param String blNo
	 * @param String transMode
	 * @return List<ChinaCMCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaCMCntrVO> searchCMCntr(String blNo, String transMode) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			param.put("trans_mode", transMode);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL(),param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaCMCntrVO.class);
		}
		catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Inbound Domestic T/S Manifest - Info B/L 조회
	 * @param String bkgNo
	 * @return InboundTSInfoBLVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InboundTSInfoBLVO searchInboundTSInfoBL(String bkgNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchInboundTSInfoBLRSQL(),param, velParam);
			List<InboundTSInfoBLVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InboundTSInfoBLVO.class);
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Inbound Domestic T/S Manifest - Info VSL_SKD 조회
	 * @param String bkgNo
	 * @return InboundTSInfoSKDVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InboundTSInfoSKDVO searchInboundTSInfoSKD(String bkgNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchInboundTSInfoSKDRSQL(),param, velParam);
			List<InboundTSInfoSKDVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InboundTSInfoSKDVO.class);
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Inbound Domestic T/S Manifest - Customer 조회
	 * @param String bkgNo
	 * @return InboundTSCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InboundTSCustVO searchInboundTSCust(String bkgNo) throws DAOException	{
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchInboundTSCustRSQL(),param, velParam);
			List<InboundTSCustVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InboundTSCustVO.class);
			if (list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Inbound Domestic T/S Manifest - Container 목록조회
	 * @param String bkgNo
	 * @return List<InboundTSCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InboundTSCntrVO> searchInboundTSCntrList(String bkgNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChinaCustomsTransmissionDBDAOsearchInboundTSCntrListRSQL(),param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, InboundTSCntrVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SYS ACK - EDI Technical Failure 수신시 E-mail 전송용 데이터 조회<br>
	 *
	 * @param String ediRefId
	 * @return List<MailContentsVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MailContentsVO> searchMailContentsByEdiRefId(String ediRefId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("edi_ref_id", ediRefId);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChinaCustomsTransmissionDBDAOsearchMailContentsByEdiRefIdRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, MailContentsVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 송수신시 전송할 E-mail 주소 조회<br>
	 *
	 * @param CstmsEmlListVO cstmsEmlListVO
	 * @return List<CstmsEmlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstmsEmlListVO> searchCstmsEmlList(CstmsEmlListVO cstmsEmlListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (cstmsEmlListVO != null) {
				Map<String, String> mapVO = cstmsEmlListVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChinaCustomsTransmissionDBDAOsearchCstmsEmlListRSQL(), param, null);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CstmsEmlListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}
