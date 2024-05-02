/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAO.java
*@FileTitle : NewZealandCustomsTransmissionDBDAO
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListBlEtcInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListConVoyInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS NewZealandCustomsTransmissionDBDAO <br>
 * - NewZealandCustomsTransmission system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see Related NewZealandCustomsTransmissionBCImpl
 * @since J2EE 1.6
 */@SuppressWarnings("serial")
public class NewZealandCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * issue_date 조회해 오는 쿼리
	 *
	 * @param String vvd
	 * @return NewZealandManifestListVslInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public NewZealandManifestListVslInfoVO searchVslInfo(String vvd) throws DAOException {

		NewZealandManifestListVslInfoVO vslInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			velParam.put("vvd", vvd);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchVslInfoRSQL(), param, velParam);
			List<NewZealandManifestListVslInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestListVslInfoVO.class);
			if (list.size() > 0) {
				vslInfo = (NewZealandManifestListVslInfoVO)list.get(0);
			}

		} catch(SQLException ex) {
			// log.error(se.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			// log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vslInfo;
	}

	/**
	 * Cons_Voy 정보 조회<br>
	 *
	 * @param NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO
	 * @return String
	 * @exception DAOException
	 */
	public NewZealandManifestListConVoyInfoVO getConsVoy(NewZealandCstmsVvdInfoCondVO newZealandCstmsVvdInfoCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		NewZealandManifestListConVoyInfoVO conVoyInfoVO  = null;

		try {
			if (newZealandCstmsVvdInfoCondVO != null) {
				Map<String, String> mapVO = newZealandCstmsVvdInfoCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOGetConsVoyRSQL(), param, velParam);
			List<NewZealandManifestListConVoyInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestListConVoyInfoVO.class);

			if (list.size() > 0) {
				conVoyInfoVO = (NewZealandManifestListConVoyInfoVO)list.get(0);
			}

		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return conVoyInfoVO;
	}

	   /**
	 * frm_port_cd 조회해 오는 쿼리
	 *
	 * @param String frmPortCd
	 * @return String flg
	 * @exception DAOException
	 */
	public String searchPortNm(String frmPortCd) throws DAOException {
		// input_text
		String flg = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("frm_port_cd", frmPortCd);
			velParam.put("frm_port_cd", frmPortCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			NewZealandCustomsTransmissionDBDAOSearchPortNameRSQL template = new NewZealandCustomsTransmissionDBDAOSearchPortNameRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("port_nm");
			} else {
				flg = "";
			}


		} catch(SQLException ex) {
			// log.error(se.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			// log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flg;
	}

	/**
	 * EDI Transmit Container 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO
	 * @return List<VietnamManifestListCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public NewZealandManifestListBlEtcInfoVO searchBlEtcInfo(NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		NewZealandManifestListBlEtcInfoVO blEtcVO = null;

		try {
			Map<String, String> mapVO = newZealandCstmsMfDtl2VO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchBlEtcInfoRSQL(), param, velParam);
			List<NewZealandManifestListBlEtcInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestListBlEtcInfoVO.class);

			if (list.size() > 0) {
				blEtcVO = (NewZealandManifestListBlEtcInfoVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return blEtcVO;
	}

	/**
	 * EDI Transmit Container 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO
	 * @return List<VietnamManifestListCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestListCntrInfoVO> searchContainerInfo(NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestListCntrInfoVO> list = null;

		try {
			Map<String, String> mapVO = newZealandCstmsMfDtl2VO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCustomsCNTRInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestListCntrInfoVO.class);

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
	 * EDI Transmit Container Seal 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestCntrSealNoInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestCntrSealNoInfoVO> searchCntrSealNoInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestCntrSealNoInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestCntrSealNoInfoVO.class);

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
	 * EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandmManifestBlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestBlInfoVO> searchBlInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestBlInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCustomsBLVOLInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestBlInfoVO.class);

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
	 * EDI Transmit Location 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestLocInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestLocInfoVO> searchLocInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestLocInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchLocInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestLocInfoVO.class);

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
	 * EDI Transmit Customer 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @param SignOnUserAccount account
	 * @return List<NewZealandManifestCustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestCustomerInfoVO> searchCustomerInfo(NewZealandCstmsMfDtl2VO inputVO, SignOnUserAccount account) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestCustomerInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			mapVO.put("usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestCustomerInfoVO.class);

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
	 * EDI Transmit DG Goods 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestGoodsInfoVO> searchGoodsInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestGoodsInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchGoodsInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestGoodsInfoVO.class);

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
	 * EDI Transmit DG Goods 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestDgGoodsInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestDgGoodsInfoVO> searchDgGoodsInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestDgGoodsInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestDgGoodsInfoVO.class);

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
	 * EDI Transmit Desc 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestDescInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestDescInfoVO> searchDescInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestDescInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchDescInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestDescInfoVO.class);

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
	 * EDI Transmit CM Desc 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestDescInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestDescInfoVO> searchCmDescInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestDescInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCmDescInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestDescInfoVO.class);

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
	 * EDI Transmit Mark 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestMarkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestMarkInfoVO> searchMarkInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestMarkInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchMarkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestMarkInfoVO.class);

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
	 * EDI Transmit CM Mark 정보를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtl2VO inputVO
	 * @return List<NewZealandManifestMarkInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NewZealandManifestMarkInfoVO> searchCmMarkInfo(NewZealandCstmsMfDtl2VO inputVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NewZealandManifestMarkInfoVO> list = null;

		try {
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchCmMarkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestMarkInfoVO.class);

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
	 * 세관 신고용 Send Log 테이블 Seq를 조회한다.<br>
	 *
	 * @param String sndDt
	 * @param String nzlSndLogId
	 * @return int seqNumber
	 * @throws DAOException
	 */
	public int searchSendLogSeq(String sndDt, String nzlSndLogId) throws DAOException {
		DBRowSet dbRowset = null;
		int seqNumber = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("snd_dt", sndDt);
			param.put("nzl_snd_log_id", nzlSndLogId);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOsearchSendLogSeqRSQL(), param, velParam, true);
			if (dbRowset.next()) {
				seqNumber = dbRowset.getInt(1);
			} else {
				seqNumber = 0;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seqNumber;
	}

	/**
	 * [ESM_BKG_1518] EDI Transmit
	 * BKG_CSTMS_NZL_SND_LOG 정보 신규 저장<br>
	 *
	 * @param NewZealandManifestSndLogVO newZealandManifestSndLogVO
	 * @exception DAOException, Exception
	 */
	public void addCstmsNzlSendLog(NewZealandManifestSndLogVO newZealandManifestSndLogVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (newZealandManifestSndLogVO != null) {
				Map<String, String> mapVO = newZealandManifestSndLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOAddCstmsNzlSendLogCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1518] EDI Transmit
	 * BKG_CSTMS_NZL_SND_LOG 정보 신규 저장<br>
	 *
	 * @param NewZealandManifestSndLogVO newZealandManifestSndLogVO
	 * @exception DAOException, Exception
	 */
	public void modifyCstmsNzlSendLog(NewZealandManifestSndLogVO newZealandManifestSndLogVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (newZealandManifestSndLogVO != null) {
				Map<String, String> mapVO = newZealandManifestSndLogVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOModifyCstmsNzlSendLogCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_BKG_1518_01]
	 * Transmit Result Error Report 목록 조회 - SAS111<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<AdvJpReceiveLogVO>
	 * @exception DAOException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<NewZealandManifestErrorReportVO> searchErrorReport(NewZealandCstmsMfDtl2VO errorReportVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (errorReportVO != null) {
				Map<String, String> mapVO = errorReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new NewZealandCustomsTransmissionDBDAOSearchErrorReportRSQL(), param, velParam);
			return(List) RowSetUtil.rowSetToVOs(dbRowset, NewZealandManifestErrorReportVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}