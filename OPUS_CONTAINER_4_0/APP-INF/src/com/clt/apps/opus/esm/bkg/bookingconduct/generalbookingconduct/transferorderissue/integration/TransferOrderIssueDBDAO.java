/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAO.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : �씠�궓寃�
*@LastVersion : 1.0
* 2009.04.30 �씠�궓寃�
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.DgSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroChangeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.QtyInfoForTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.ValidateInlandRouteVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.BkgTroActRepVO;
import com.clt.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.clt.syscommon.common.table.MdmCustomerVO;




/**
 * OPUS TransferOrderIssueDBDAO <br>
 * - OPUS-GeneralBookingConduct system Business Logic�쓣 泥섎━�븯湲� �쐞�븳 JDBC �옉�뾽�닔�뻾.<br>
 *
 * @author Lee Nam Kyung
 * @see TransferOrderIssueBCImpl 李몄“
 * @since J2EE 1.4
 */
public class TransferOrderIssueDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tro �솕硫댁쓽 Booking Header �젙蹂대�� 議고쉶�븳�떎.(ESM_BKG_0079_02A/B/C)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    BkgInfoForTroVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgInfoForTroVO searchBkgForTro(BkgBlNoVO bkgBlNoVO, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInfoForTroVO> list = null;
		BkgInfoForTroVO bkgInfoForTroVO = new BkgInfoForTroVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("io_bnd_cd", boundCd);

				velParam.putAll(mapVO);
				param.put   ("io_bnd_cd", boundCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchBkgForTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgInfoForTroVO.class);

			if (list != null && list.size() > 0) {
				bkgInfoForTroVO = (BkgInfoForTroVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgInfoForTroVO;
	}

	/**
	 * Tro �솕硫댁쓽 Danger Cago 肄ㅻ낫紐⑸줉�쓣 議고쉶�븳�떎.(ESM_BKG_0079_02A/B/C)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<DgSeqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DgSeqVO> searchDgSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DgSeqVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchDgSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgSeqVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 Reefer Cago 肄ㅻ낫紐⑸줉�쓣 議고쉶�븳�떎.(ESM_BKG_0079_02A/B/C)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<RfSeqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RfSeqVO> searchRfSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfSeqVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchRfSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RfSeqVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 Awk Cago 肄ㅻ낫紐⑸줉�쓣 議고쉶�븳�떎.(ESM_BKG_0079_02A/B/C)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<AwkSeqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AwkSeqVO> searchAwkSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AwkSeqVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchAwkSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AwkSeqVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 Tro Master �젙蹂대�� 議고쉶�븳�떎.(ESM_BKG_0079_02A/B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String rtnTroFlg
	 * @param     String boundCd
	 * @return    List<TroMstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TroMstVO> searchTro(BkgBlNoVO bkgBlNoVO, String rtnTroFlg, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroMstVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("io_bnd_cd",   boundCd);
				param.put   ("rtn_tro_flg", rtnTroFlg);

				velParam.putAll(mapVO);
				velParam.put("io_bnd_cd",   boundCd);
				velParam.put("rtn_tro_flg", rtnTroFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroMstVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	 
	/**
	 * Tro �솕硫댁쓽 EurTro Master �젙蹂대�� 議고쉶�븳�떎.(EUR_TRO)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @param     String boundCd
	 * @return    List<EurTroMstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public List<EurTroMstVO> searchEurTro(BkgBlNoVO bkgBlNoVO, String troSeq, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurTroMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("tro_seq",   troSeq);
				param.put("io_bnd_cd", boundCd);
				
				velParam.putAll(mapVO);
				velParam.put("tro_seq",   troSeq);
				velParam.put("io_bnd_cd", boundCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurTroMstVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 	
	 
	/**
	 * Tro �솕硫댁쓽 Tro Detail �젙蹂대�� 議고쉶�븳�떎.(ESM_BKG_0079_02A/B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String ioBndCd
	 * @param     String rtnTroFlg
	 * @param     String troSeq
	 * @param     String creUsrId
	 * @return    List<TroDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TroDtlVO> searchTroDtl(BkgBlNoVO bkgBlNoVO, String ioBndCd, String rtnTroFlg, String troSeq, String creUsrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroDtlVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("cre_usr_id",  creUsrId);
				param.put   ("io_bnd_cd",   ioBndCd);
				param.put   ("rtn_tro_flg", rtnTroFlg);

				velParam.putAll(mapVO);
				velParam.put("cre_usr_id",  creUsrId);
				velParam.put("io_bnd_cd",   ioBndCd);
				velParam.put("rtn_tro_flg", rtnTroFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroDtlVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	 
	/**
	 * Tro �솕硫댁쓽 EurTro Detail �젙蹂대�� 議고쉶�븳�떎.(EUR_TRO)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String ioBndCd
	 * @param     String troSeq
	 * @param     String creUsrId
	 * @return    List<EurTroDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurTroDtlVO> searchEurTroDtl(BkgBlNoVO bkgBlNoVO, String ioBndCd, String troSeq, String creUsrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurTroDtlVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("cre_usr_id",  creUsrId);
				param.put   ("io_bnd_cd",   ioBndCd);
				param.put   ("tro_seq",     troSeq);

				velParam.putAll(mapVO);
				velParam.put("cre_usr_id",  creUsrId);
				velParam.put("io_bnd_cd",   ioBndCd);
				velParam.put("tro_seq",     troSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurTroDtlVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 EurTro Danger Cago 肄ㅻ낫紐⑸줉�쓣 議고쉶�븳�떎.(EUR_TRO)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @param     String boundCd
	 * @return    List<BkgEurTroDgSeqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgEurTroDgSeqVO> searchEurTroDgSeq(BkgBlNoVO bkgBlNoVO, String troSeq, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEurTroDgSeqVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("tro_seq",   troSeq);
				param.put   ("io_bnd_cd", boundCd);

				velParam.putAll(mapVO);
				velParam.put("tro_seq",   troSeq);
				velParam.put("io_bnd_cd", boundCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroDgSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroDgSeqVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 TroSeq蹂� Cago 硫��떚肄ㅻ낫 �꽑�깮紐⑸줉�쓣 議고쉶�븳�떎.(ESM_BKG_0079_02A/B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @return    List<BkgTroSpclCgoSeqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgTroSpclCgoSeqVO> searchTroSpclCgoSeq(BkgBlNoVO bkgBlNoVO, String troSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroSpclCgoSeqVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("tro_seq", troSeq);

				velParam.putAll(mapVO);
				velParam.put("tro_seq", troSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroSpclCgoSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroSpclCgoSeqVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Tro �솕硫댁쓽 TroSeq蹂� Qty 紐⑸줉�쓣 議고쉶�븳�떎.(ESM_BKG_0079_02A/B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    List<QtyInfoForTroVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<QtyInfoForTroVO> searchQtyForTro(BkgBlNoVO bkgBlNoVO, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<QtyInfoForTroVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("io_bnd_cd", boundCd);

				velParam.putAll(mapVO);
				velParam.put("io_bnd_cd", boundCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchQtyForTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, QtyInfoForTroVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * [Tro Master]�떒嫄댁쓽 �뜲�씠�꽣瑜� cancel 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String rtnTroFlg
	 * @param     String troSeq
	 * @param     String updUsrId
	 * @return    int
	 * @exception DAOException
	 */
	public int cancelBkgTro(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, String troSeq, String updUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("io_bnd_cd",   boundCd);
			param.put("rtn_tro_flg", rtnTroFlg);
			param.put("tro_seq",     troSeq);
			param.put("upd_usr_id",  updUsrId);

			velParam.putAll(mapVO);
			velParam.put("io_bnd_cd",   boundCd);
			velParam.put("rtn_tro_flg", rtnTroFlg);
			velParam.put("tro_seq",     troSeq);
			velParam.put("upd_usr_id",  updUsrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOCancelBkgTroUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * [Tro Dtl]�떒嫄댁쓽 �뜲�씠�꽣瑜� cancel 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String rtnTroFlg
	 * @param     String troSeq
	 * @param     String troSubSeq
	 * @param     String updUsrId
	 * @return    int
	 * @exception DAOException
	 */
	public int cancelBkgTroDtl(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, String troSeq, String troSubSeq, String updUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("io_bnd_cd",   boundCd);
			param.put("rtn_tro_flg", rtnTroFlg);
			param.put("tro_seq",     troSeq);
			param.put("tro_sub_seq", troSubSeq);
			param.put("upd_usr_id",  updUsrId);

			velParam.putAll(mapVO);
			velParam.put("io_bnd_cd",   boundCd);
			velParam.put("rtn_tro_flg", rtnTroFlg);
			velParam.put("tro_seq",     troSeq);
			velParam.put("tro_sub_seq", troSubSeq);
			velParam.put("upd_usr_id",  updUsrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDDAOCancelBkgTroDtlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * [Tro Master]�떒嫄댁쓽 �뜲�씠�꽣瑜� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroMstVO vo
	 * @exception DAOException
	 */
	public void addBkgTro(TroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgTroCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * [EurTro Master]�떒嫄댁쓽 �뜲�씠�꽣瑜� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroMstVO vo
	 * @exception DAOException
	 */
	public void addEurTro(EurTroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddEurTroCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
	
	/**
	 * 
	 * @param vo
	 * @throws DAOException
	 */
	public void addEurTroXter(EurTroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddEurTroXterCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * [Tro Master](eBooking�슜)�떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
     * @author Jun Yong Jin
	 * @param  TroMstVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBkgTroByXter(TroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroByXterUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Tro Master]�떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroMstVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyBkgTro(TroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [EurTro Master](eBooking �슜)�떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroMstVO vo
	 * @return    int 
	 * @exception DAOException
	 */
	public int modifyEurTroByXter(EurTroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroByXterUSQL(), param, velParam);
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroByXterDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	

	/**
	 * [EurTro Master]�떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroMstVO vo
	 * @return    int 
	 * @exception DAOException
	 */
	public int modifyEurTro(EurTroMstVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return result;
	}

	/**
	 * 而⑦뀒�씠�꼫 議댁옱�뿬遺� 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String cntrNo
	 * @param     BkgBlNoVO vo
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchCntrByBkg(String cntrNo, BkgBlNoVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String cntrExistYn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();

			 param.putAll(mapVO);
			 param.put   ("cntr_no", cntrNo);

			 velParam.putAll(mapVO);
			 velParam.put("cntr_no", cntrNo);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchCntrByBkgRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 cntrExistYn = dbRowset.getString("cntr_exist_yn");
			 }
		 }catch(SQLException se){
		     throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		 }catch(Exception ex){
		     throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		 }

		 return cntrExistYn;
	 }

//	/**
//	 * LocCode 議댁옱�뿬遺� 議고쉶<br>
//	 * @author    Lee NamKyung
//	 * @param     String locCd
//	 * @return    String
//	 * @exception DAOException
//	 */
//	 public String selectLocCdExistYn(String locCd) throws DAOException {
//
//		 DBRowSet dbRowset = null;
//		 String existYn = "";
//
//		 //query parameter
//		 Map<String, Object> param = new HashMap<String, Object>();
//		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
//
//		 try{
//			 param.put   ("loc_cd", locCd);
//			 velParam.put("loc_cd", locCd);
//
//			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSelectLocCdExistYnRSQL(), param, velParam);
//			 if(dbRowset.next()) {
//				 existYn = dbRowset.getString("exist_yn");
//			 }
//		 }catch(SQLException se){
//			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		 }catch(Exception ex){
//			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		 }
//
//		 return existYn;
//	 }

	/**
	 * ZoneCode 議댁옱�뿬遺� 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String zoneCd
	 * @return    String
	 * @exception DAOException
	 */
	 public String selectZoneCdExistYn(String zoneCd) throws DAOException {

		 DBRowSet dbRowset = null;
		 String existYn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("zn_cd", zoneCd);
			 velParam.put("zn_cd", zoneCd);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSelectZoneCdExistYnRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 existYn = dbRowset.getString("exist_yn");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return existYn;
	 }

	/**
	 * Container Partial 由ы꽩 硫붿꽭吏�肄붾뱶 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String cntrNo
	 * @param     BkgBlNoVO vo
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchCntrPartial(String cntrNo, BkgBlNoVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String resultFlag = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();

			 param.putAll(mapVO);
			 param.put   ("cntr_no", cntrNo);

			 velParam.putAll(mapVO);
			 velParam.put("cntr_no", cntrNo);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchCntrPartialRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 resultFlag = dbRowset.getString("result_flag");
			 }
		 }catch(SQLException se){
		     throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		 }catch(Exception ex){
		     throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		 }

		 return resultFlag;
	 }


    /**
	 * [Tro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroDtlVO vo
	 * @exception DAOException
	 */
	public void addBkgTroDtl(TroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgTroDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * [EurTro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� add 泥섎━�븳�떎.<br>
	 * �떎瑜몄뾽臾댁뿉�꽌 �궗�슜�븯�뿬 �떊洹쒕줈 SQL 蹂�寃쏀븯�뿬 �떎�떆 留뚮뱾�뿀�쓬 [ addEurTroDtl ]
	 * @author    Lee NamKyung
	 * @param     EurTroDtlVO vo
	 * @exception DAOException
	 */
	public void addNewEurTroDtl(EurTroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddNewEurTroDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * [EurTro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroDtlVO vo
	 * @exception DAOException
	 */
	public void addEurTroDtl(EurTroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddEurTroDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
	
	/**
	 * [Tro Detail] eBooking�슜 TroDtl�쓣 modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyBkgTroDtlByXter(TroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * [Tro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyBkgTroDtl(TroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroDtlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * [EurTro Detail] eBooking�슜 EurTro瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyEurTroDtlByXter(EurTroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL(), param, velParam);
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroDtlByXterDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	
	
	/**
	 * [EurTro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� modify 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     EurTroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyEurTroDtl(EurTroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroDtlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return result;
	}
	
	/**
	 * [Tro Detail] �떒嫄댁쓽 �뜲�씠�꽣瑜� remove 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     TroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int removeBkgTroDtl(TroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAORemoveBkgTroDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * [Tro SpclCgo] TroSeq�뿉 �빐�떦�븯�뒗 Spcl Cago �뜲�씠�꽣瑜� �씪愿꼛emove 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String boundCd
	 * @param     String rtnTroFlg
	 * @param     String troSeq
	 * @return    int
	 * @exception DAOException
	 */
	public int removeBkgTroSpclCgoSeq(BkgBlNoVO vo, String boundCd, String rtnTroFlg, String troSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			param.put("io_bnd_cd",   boundCd);
			param.put("rtn_tro_flg", rtnTroFlg);
			param.put("tro_seq",     troSeq);

			velParam.putAll(mapVO);
			velParam.put("io_bnd_cd",   boundCd);
			velParam.put("rtn_tro_flg", rtnTroFlg);
			velParam.put("tro_seq",     troSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAORemoveBkgTroSpclCgoSeqDSQL(), param, velParam);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * [Tro SpclCgo] TroSeq�뿉 �빐�떦�븯�뒗 Spcl Cago �뜲�씠�꽣瑜� �씪愿� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroSpclCgoSeqVO vo
	 * @exception DAOException
	 */
	public void addBkgTroSpclCgoSeq(BkgTroSpclCgoSeqVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgTroSpclCgoSeqCSQL(), param, velParam);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * [EurTro SpclCgo] EurTroSeq�뿉 �빐�떦�븯�뒗 Danger Cago �뜲�씠�꽣瑜� �씪愿� add 泥섎━�븳�떎.<br>
	 * @author    Lee NamKyung 
	 * @param     BkgEurTroDgSeqVO vo
	 * @exception DAOException
	 */
	public void addEurTroDgSeq(BkgEurTroDgSeqVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgEurTroDgSeqCSQL(), param, velParam);			
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}

	/**
	 * [EurTro popup] EurTro�뿉 �엯�젰�맂 Container�뿉 �빐�떦�븯�뒗 紐⑤뱺 Booking 踰덊샇瑜� 議고쉶�븳�떎<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String ioBndCd
	 * @return    List<BkgEurCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgEurCntrListVO> searchEurTroCntrList(BkgBlNoVO bkgBlNoVO, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEurCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put   ("io_bnd_cd", ioBndCd);

				velParam.putAll(mapVO);
				velParam.put("io_bnd_cd", ioBndCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOBkgBlNoVORSQL(), param, velParam);  //TransferOrderIssueDBDAOBkgEurCntrListVORSQL()
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurCntrListVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR_TRO Cancel/Frust 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String ioBndCd
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<TroMultiCancelFrustVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TroMultiCancelFrustVO> searchEurTroForCancelFrust(String ioBndCd, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroMultiCancelFrustVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll   (mapVO);
				param.put      ("io_bnd_cd", ioBndCd);
				velParam.putAll(mapVO);
				velParam.put   ("io_bnd_cd", ioBndCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroMultiCancelFrustVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR_TRO Multi ���긽 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String cntrNo
	 * @param     String boundCd
	 * @return    List<TroMultiBkgVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TroMultiBkgVO> searchMultiBkg(BkgBlNoVO vo, String cntrNo, String boundCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroMultiBkgVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				param.put      ("bkg_no", vo.getBkgNo());
				param.put      ("cntr_no", cntrNo);
				param.put      ("bound_cd", boundCd);
				velParam.put      ("bkg_no", vo.getBkgNo());
				velParam.put   ("cntr_no", cntrNo);
				velParam.put   ("bound_cd", boundCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchMultiBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroMultiBkgVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR TRO Confirm ���긽 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @return    EurPayerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public EurPayerVO searchEurTroPayer(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurPayerVO> list = null;
		EurPayerVO eurPayerVO = new EurPayerVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroPayerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurPayerVO.class);

			if (list != null && list.size() > 0) {
				eurPayerVO = (EurPayerVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eurPayerVO;
	}

	/**
	 * EUR_TRO Confirm ���긽 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String ioBndCd
	 * @return    List<TroListForCfmVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TroListForCfmVO> searchEurTroListForCfm(BkgBlNoVO vo, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroListForCfmVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				param.put      ("io_bnd_cd", ioBndCd);
				velParam.putAll(mapVO);
				velParam.put   ("io_bnd_cd", ioBndCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroListForCfmVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR_TRO confirm 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     TroListForCfmVO vo
	 * @exception DAOException
	 */
	public void confirmEurTro(TroListForCfmVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOConfirmEurTroUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}	 

	 /**
	 * (ESM_BKG_0905) Customer/EQuipment Detail�젙蹂� add 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActCustVO vo
	 * @exception DAOException
	 */
	public void addBkgTroActCust(BkgTroActCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActCustVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) Customer/EQuipment Detail�젙蹂� modify 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActCustVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyBkgTroActCust(BkgTroActCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActCustVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * (ESM_BKG_0905) Customer/EQuipment Detail�젙蹂� remove 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActCustVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int removeBkgTroActCust(BkgTroActCustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActCustVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * (ESM_BKG_0905) EQuipment Master�젙蹂� add 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActRepVO vo
	 * @exception DAOException
	 */
	public void addBkgTroActRep(BkgTroActRepVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActRepVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) EQuipment Master�젙蹂� modify 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActRepVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyBkgTroActRep(BkgTroActRepVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActRepVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * (ESM_BKG_0905) EQuipment Master�젙蹂� remove 泥섎━<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroActRepVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int removeBkgTroActRep(BkgTroActRepVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActRepVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * (ESM_BKG_0905)Customer �꺆�쓽 Master 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String custCntCd
	 * @param     String custSeq
	 * @param     String custNm
	 * @return    List<MdmCustomerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCustomerVO> searchMdmCustForTro(String custCntCd, String custSeq, String custNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cust_cnt_cd",     custCntCd);
			param.put("cust_seq",        custSeq);			
			param.put("cust_lgl_eng_nm", custNm);
			
			velParam.put("cust_cnt_cd",     custCntCd);
			velParam.put("cust_seq",        custSeq);
			velParam.put("cust_lgl_eng_nm", custNm);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOBkgMdmCustomerExtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustomerVO.class);  //returnVO : tableVO 濡� 蹂�寃�
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * (ESM_BKG_0905)Customer �꺆�쓽 Detail 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String ofcCd
	 * @param     String cntCd
	 * @param     String custSeq
	 * @return    List<BkgTroActCustVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgTroActCustVO> searchTroActCustByCust(String ofcCd, String cntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroActCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd",   ofcCd);
			param.put("cnt_cd",   cntCd);
			param.put("cust_seq", custSeq);
			
			velParam.put("ofc_cd",   ofcCd);
			velParam.put("cnt_cd",   cntCd);
			velParam.put("cust_seq", custSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActCustExtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActCustVO.class); //returnVO : tableVO 濡� 蹂�寃�
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}	
	
	/**
	 * (ESM_BKG_0905) EQuipment Master�젙蹂� 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param	  String doorLoc
	 * @param     String ofcCd
	 * @param     String custNm
	 * @return    List<BkgTroActRepVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgTroActRepVO> searchActCustRep(String doorLoc, String ofcCd, String custNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroActRepVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd",  doorLoc);			
			param.put("ofc_cd",  ofcCd);
			param.put("tro_act_rep_nm", custNm);
			
			velParam.put("loc_cd",  doorLoc);
			velParam.put("ofc_cd",  ofcCd);
			velParam.put("tro_act_rep_nm", custNm);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActRepExtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActRepVO.class);

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
	 * (ESM_BKG_0905) EQuipment Detail�젙蹂� 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     String ofcCd
	 * @param     String troActRepSeq
	 * @return    List<BkgTroActCustExtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<BkgTroActCustExtVO> searchTroActCustByEq(String doorLoc, String ofcCd, String troActRepSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroActCustExtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", 			 doorLoc);
			param.put("ofc_cd",              ofcCd);
			param.put("tro_act_rep_seq",     troActRepSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOBkgTroActCustExtVOEQRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActCustExtVO.class);  //BkgTroActCustVO + venderNm -> �떒�닚tableVO �궗�슜遺덇�
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Vendor Name 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String cntCd
	 * @param     String vndrSeq
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchVndrName(String cntCd, String vndrSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String vndrLglEngNm = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("vndr_seq", vndrSeq);
			 velParam.put("vndr_seq", vndrSeq);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchVndrNameRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 vndrLglEngNm = dbRowset.getString("vndr_lgl_eng_nm");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return vndrLglEngNm;
	 }

	/**
	 * CntrNo蹂� Cago weight 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String cntrNo
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchBkgCntrWgt(String bkgNo, String cntrNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put("bkg_no",  bkgNo);
			 param.put("cntr_no", cntrNo);
			 velParam.put("bkg_no",  bkgNo);
			 velParam.put("cntr_no", cntrNo);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchBkgCntrWgtRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("cgo_wgt");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	 /**
	 * (ESM_BKG_0905)Open�떆, Default媛� 珥덇린�솕瑜� �쐞�븳 �젙蹂� 議고쉶<br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    TroActCustDefaultVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public TroActCustDefaultVO searchTroActCustDefault(String doorLoc, BkgBlNoVO bkgBlNoVO) throws DAOException {

		 DBRowSet dbRowset = null;
		 List<TroActCustDefaultVO> list = null;
		 TroActCustDefaultVO troActCustDefaultVO = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("dor_loc_cd",   doorLoc);
			 param.put   ("bkg_no",       bkgBlNoVO.getBkgNo());
			 //param.put   ("bkg_no_split", bkgBlNoVO.getBkgNoSplit());
			 velParam.put("dor_loc_cd",   doorLoc);
			 velParam.put("bkg_no",       bkgBlNoVO.getBkgNo());
			 //velParam.put("bkg_no_split", bkgBlNoVO.getBkgNoSplit());

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroActCustDefaultRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroActCustDefaultVO.class);
			 if (list != null && list.size() > 0) {
				 troActCustDefaultVO = (TroActCustDefaultVO)list.get(0);
		     }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return troActCustDefaultVO;
	 }

	/**
	 * BKG_EUR_TRO : CXL_FLG = 'Y' 濡� 蹂�寃쏀븳�떎.(EUR_TRO : ESM_BKG_0703 popup)<br>
	 *  : (confirm 愿��젴�젙蹂� 蹂�寃쏀룷�븿)
	 * @author    Lee NamKyung
	 * @param     TroMultiCancelFrustVO vo
	 * @exception DAOException
	 */
	public void cancelEurTro(TroMultiCancelFrustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOCancelEurTroUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_EUR_TRO : EUR_TRNS_TP_CD = 'FR' 濡� 蹂�寃쏀븳�떎.(EUR_TRO : ESM_BKG_0703 popup)<br>
	 *  : (confirm 愿��젴�젙蹂� 蹂�寃쏀룷�븿)
	 * @author    Lee NamKyung 
	 * @param     TroMultiCancelFrustVO vo
	 * @exception DAOException
	 */
	public void frustrateEurTro(TroMultiCancelFrustVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOFrustrateEurTroUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_TRO Flag 蹂�寃�.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception DAOException
	 */
	public void unconfirmTro(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOUnconfirmTroUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_EUR_TRO Flag 蹂�寃�.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String boundCd
	 * @param 	SignOnUserAccount account
	 * @exception DAOException
	 */
	public void unconfirmEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("io_bnd_cd", boundCd);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOUnconfirmEurTroUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int copyTroBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt=0;
		try{
			if(sourceBkg != null){
				param.put("tro_seq", sourceTroSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());

				velParam.put("tro_seq", sourceTroSeq); 
				velParam.put("bkg_no", sourceBkg.getBkgNo());
				velParam.put("targetBkg", targetBkg.getBkgNo());				
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyTroBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * souceBKG�쓽 bkg_tro_dtl瑜� targetBkg�쑝濡� �꽔�뒗�떎.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyTroDtlBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq,String sourceTroSubSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("tro_seq",     sourceTroSeq); 
				param.put("bkg_no",      sourceBkg.getBkgNo());
				param.put("targetBkg",   targetBkg.getBkgNo());
				param.put("usr_id",      account.getUsr_id());
				param.put("tro_sub_seq", sourceTroSubSeq); 

				velParam.put("tro_seq",     sourceTroSeq); 
				velParam.put("bkg_no",      sourceBkg.getBkgNo());
				velParam.put("targetBkg",   targetBkg.getBkgNo());
				velParam.put("tro_sub_seq", sourceTroSubSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyTroDtlBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * souceBKG�쓽 bkg_tro_dg_seq瑜� targetBkg�쑝濡� �꽔�뒗�떎.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyTroSpclCgoSeqBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq,String sourceTroSubSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("tro_seq", sourceTroSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("tro_sub_seq", sourceTroSubSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyTroSpclCgoSeqBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  souceBKG�쓽 bkg_tro_xter_if瑜� targetBkg�쑝濡� �꽔�뒗�떎.<br>
	 *  
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String rtnTroFlg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgTroXterIf(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq,String rtnTroFlg,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("tro_seq", sourceTroSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("rtn_tro_flg", rtnTroFlg); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyBkgTroXterIfCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * troSeq 議댁옱�뿬遺�瑜� 泥댄겕 (ESM_BKG_0920)<br>
	 * @author    Lee NamKyung
	 * @param     String boundCd
	 * @param     BkgBlNoVO vo
	 * @return    String
	 * @exception DAOException
	 */
	public String searchTroExist(String boundCd, BkgBlNoVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put("io_bnd_cd", boundCd);
			 
			 velParam.putAll(mapVO);
			 velParam.put("io_bnd_cd", boundCd);
			 
			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroExistRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("str_return");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }
	
	/**
	 * souceBKG�쓽 bkg_eur_tro瑜� targetBkg�쑝濡� �꽔�뒗�떎. <br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int copyEurTroBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq, String boundCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt=0;
		try{
			if(sourceBkg != null){
				param.put("tro_seq",   sourceTroSeq); 
				param.put("bkg_no",    sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id",    account.getUsr_id()); 
				param.put("io_bnd_cd", boundCd);
				velParam.put("tro_seq",   sourceTroSeq); 
				velParam.put("bkg_no",    sourceBkg.getBkgNo());
				velParam.put("targetBkg", targetBkg.getBkgNo());
				velParam.put("io_bnd_cd", boundCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyEurTroBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * souceBKG�쓽 bkg_eur_tro_dtl瑜� targetBkg�쑝濡� �꽔�뒗�떎.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyEurTroDtlBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq, String sourceTroSubSeq, String boundCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("tro_seq",     sourceTroSeq); 
				param.put("bkg_no",      sourceBkg.getBkgNo());
				param.put("targetBkg",   targetBkg.getBkgNo());
				param.put("usr_id",      account.getUsr_id());
				param.put("tro_sub_seq", sourceTroSubSeq); 
				param.put("io_bnd_cd",   boundCd); 
				velParam.put("tro_seq",     sourceTroSeq); 
				velParam.put("bkg_no",      sourceBkg.getBkgNo());
				velParam.put("targetBkg",   targetBkg.getBkgNo());
				velParam.put("tro_sub_seq", sourceTroSubSeq); 
				velParam.put("io_bnd_cd",   boundCd); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyEurTroDtlBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * souceBKG�쓽 bkg_eur_tro_dg_seq瑜� targetBkg�쑝濡� �꽔�뒗�떎. <br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String sourceTroSeq
	 * @param String sourceTroDcgoSeq
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyEurTroDgSeqBySeq(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String sourceTroSeq, String sourceTroDcgoSeq, String boundCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("tro_seq",      sourceTroSeq); 
				param.put("bkg_no",       sourceBkg.getBkgNo());
				param.put("targetBkg",    targetBkg.getBkgNo());
				param.put("usr_id",       account.getUsr_id());
				param.put("tro_dcgo_seq", sourceTroDcgoSeq); 
				param.put("io_bnd_cd",    boundCd); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOcopyEurTroDgSeqBySeqCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
		
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_eur_tro table�쓣 �궘�젣  <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String boundCd
	 * @param String sourceTroSeq
	 * @param String sourceTroDcgoSeq
	 * @exception DAOException
	 */
	public void removeEurTroDgSeq(BkgBlNoVO bkgBlNoVO, String boundCd, String sourceTroSeq,String sourceTroDcgoSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(bkgBlNoVO != null){
				param.put("bkg_no",       bkgBlNoVO.getBkgNo());
				param.put("io_bnd_cd",    boundCd);
				param.put("tro_seq",      sourceTroSeq); 
				param.put("tro_dcgo_seq", sourceTroDcgoSeq); 

				velParam.put("tro_seq",      sourceTroSeq); 
				velParam.put("tro_dcgo_seq", sourceTroDcgoSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveEurTroDgSeqDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
	/**
	 * bkg_eur_tro_dtl table�쓣 �궘�젣�븳�떎. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String boundCd
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @exception DAOException
	 */
	public void removeEurTroDtl(BkgBlNoVO bkgBlNoVO, String boundCd, String sourceTroSeq,String sourceTroSubSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("io_bnd_cd", boundCd);
				param.put("tro_seq", sourceTroSeq); 
				param.put("tro_sub_seq", sourceTroSubSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveEurTroDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
	
	/**
	 *  bkg_eur_tro table�쓣 �궘�젣�븳�떎. <br>
	 *  
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String boundCd
	 * @param String sourceTroSeq
	 * @exception DAOException
	 */
	public void removeEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, String sourceTroSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("io_bnd_cd", boundCd);
				param.put("tro_seq", sourceTroSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveEurTroDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_tro_spcl_cgo_seq table�쓣 �궘�젣�븳�떎. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rtnTroFlg
	 * @param String sourceTroSeq
	 * @exception DAOException
	 */
	public void removeBkgTroSpclCgoSeqBySplit(BkgBlNoVO bkgBlNoVO, String rtnTroFlg, String sourceTroSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("rtn_tro_flg", rtnTroFlg);
				param.put("tro_seq", sourceTroSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveBkgTroSpclCgoSeqBySplitDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * bkg_tro_dtl table�쓣 �궘�젣�븳�떎. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rtnTroFlg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @exception DAOException
	 */
	public void removeBkgTroDtlBySplit(BkgBlNoVO bkgBlNoVO, String rtnTroFlg, String sourceTroSeq,String sourceTroSubSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("rtn_tro_flg", rtnTroFlg);
				param.put("tro_seq", sourceTroSeq); 
				param.put("tro_sub_seq", sourceTroSubSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveBkgTroDtlBySplitDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_tro_xter_if  table�쓣 �궘�젣�븳�떎. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rtnTroFlg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @exception DAOException
	 */
	public void removeBkgTroXterIfBySplit(BkgBlNoVO bkgBlNoVO, String rtnTroFlg, String sourceTroSeq,String sourceTroSubSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("rtn_tro_flg", rtnTroFlg);
				param.put("tro_seq", sourceTroSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveBkgTroXterIfBySplitDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_tro  table�쓣 �궘�젣�븳�떎. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rtnTroFlg
	 * @param String sourceTroSeq
	 * @param String sourceTroSubSeq
	 * @exception DAOException
	 */
	public void removeBkgTroBySplit(BkgBlNoVO bkgBlNoVO, String rtnTroFlg, String sourceTroSeq,String sourceTroSubSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(bkgBlNoVO != null){
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("rtn_tro_flg", rtnTroFlg);
				param.put("tro_seq", sourceTroSeq); 
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveBkgTroBySplitDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CTM�뿉�꽌 EUR mty release瑜� �뻽�쓣 �븣�쓽 泥섎━(unconfirm)<br>
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void unconfirmEurTroByCtm(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = eurTroMtyRelByCtmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOunconfirmEurTroByCtmUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CTM�뿉�꽌 EUR mty release瑜� �뻽�쓣 �븣�쓽 泥섎━(confirm)<br>
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void confirmEurTroByCtm(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = eurTroMtyRelByCtmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOconfirmEurTroByCtmUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	

	/**
	 * CTM�뿉�꽌 EUR mty release瑜� �뻽�쓣 �븣�쓽 泥섎━(redelivery)<br>
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void redeliveEurTroByCfm(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = eurTroMtyRelByCtmVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOredelivEurTroByCtmUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
	}
	/**
	 * Tro confirm�떆 媛숈� cntr瑜� �떎瑜� bkg�뿉�꽌 confirm�븯�뒗 吏� �솗�씤<br>
	 *
	 * @param TroListForCfmVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchEurTroPartial(TroListForCfmVO vo)throws DAOException  {
		 DBRowSet dbRowset = null;
		 String rtnString = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);	
			 velParam.putAll(mapVO);
			 param.put("bkg_no", vo.getBkgNo());
			 param.put("cntr_no", vo.getCntrNo());
			 param.put("io_bnd_cd", vo.getIoBndCd());
			 param.put("tro_seq", vo.getTroSeq());
			 
			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchEurTroPartialRSQL(), param, velParam);
			 if(dbRowset.next()) {
					rtnString = dbRowset.getString("BKG_NO");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		return rtnString;
	}

	/**
	 * combine�떆 tro瑜� �삷寃� 以��떎.<br>
	 *
	 * @param 		CombineTroNewSeqVO combineTroNewSeqVO
	 * @param 		account SignOnUserAccount
	 * @return 		int
	 * @exception 	DAOException
	 */
	public int moveBkgTro(CombineTroNewSeqVO combineTroNewSeqVO, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = combineTroNewSeqVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);			

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOmoveBkgTroCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * combine�떆 tro detail瑜� �삷寃� 以��떎.<br>
	 * @param 		CombineTroNewSeqVO combineTroNewSeqVO
	 * @param 		account SignOnUserAccount
	 * @return 		int
	 * @exception 	DAOException
	 */	
	public int moveBkgTroDtl(CombineTroNewSeqVO combineTroNewSeqVO, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = combineTroNewSeqVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);			

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOmoveBkgTroDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	
	
	/**
	 * combine�떆 europe tro瑜� �삷寃� 以��떎.<br>
	 *
	 * @param 		CombineTroNewSeqVO combineTroNewSeqVO
	 * @param 		account SignOnUserAccount
	 * @return 		int
	 * @exception 	DAOException
	 */
	public int moveBkgEurTro(CombineTroNewSeqVO combineTroNewSeqVO, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = combineTroNewSeqVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);			

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOmoveBkgEurTroCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * combine�떆 europe tro detail瑜� �삷寃� 以��떎.<br>
	 *
	 * @param 		CombineTroNewSeqVO combineTroNewSeqVO
	 * @param 		account SignOnUserAccount
	 * @return 		int
	 * @exception 	DAOException
	 */	
	public int moveBkgEurTroDtl(CombineTroNewSeqVO combineTroNewSeqVO, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = combineTroNewSeqVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);			

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOmoveBkgEurTroDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
     * inland route Validation<br>
     * 蹂�寃쏀븯�젮�뒗 route媛� inland route濡� �벑濡앸릺�뼱 �엳�뒗吏� �솗�씤�븳�떎.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @param		String checkCop
	 * @return      List<ValidateInlandRouteVO> 
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ValidateInlandRouteVO> validateInlandRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door, String trspModCd, String checkCop) throws DAOException{
		DBRowSet dbRowset = null;
		List<ValidateInlandRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			param.put("bound_cd", boundCd);
			param.put("full_cy", fullCy);
			param.put("door", door);
			param.put("trsp_mod_cd", trspModCd);
			param.put("check_cop", checkCop);
			
			velParam.put("check_cop", checkCop);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOvalidateInlandRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ValidateInlandRouteVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}

	/**
     * eur tro�뿉 pctl_no瑜� 媛깆떊�븳�떎..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @return      int
	 * @exception 	DAOException
	 */
	public int modifyEurTroPctlNo(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("tro_seq", troSeq);
			param.put("bound_cd", boundCd);
			velParam.putAll(mapVO);			
			velParam.put("tro_seq", troSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOmodifyEurTroPctlNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return result;
	}

		/**
     * eur tro�뿉 pctl_no瑜� 媛깆떊�븳�떎..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @return      int
	 * @exception 	DAOException
	 */
	public int modifyTroPctlNo(BkgBlNoVO bkgBlNoVO, String troSeq, SignOnUserAccount account) throws DAOException   {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("tro_seq", troSeq);
			velParam.put("tro_seq", troSeq);
			velParam.putAll(mapVO);			

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyTroPctlNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	/**
	 * bkg�쓽 留덉�留� tro seq 議고쉶<br>
	 * @author    Ryu Daeyoung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchTroLastSeq(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String lastTroSeq = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);			

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroLastSeqRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 lastTroSeq = dbRowset.getString("last_seq");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return lastTroSeq;
	}

	/**
	 * Combine �썑�쓽 new tro seq瑜� 議고쉶�븳�떎<br>
	 * @author    Ryu Daeyoung
	 * @param     String bkgNo
	 * @param     String targetBkgNoList
	 * @return    String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CombineTroNewSeqVO> searchCombineTroNewSeq(String bkgNo, String targetBkgNoList) throws DAOException {
		DBRowSet dbRowset = null;
		List<CombineTroNewSeqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("mst_bkg_no", bkgNo);
			
			ArrayList<String> combineBkgList = new ArrayList();
            if(targetBkgNoList!=null){
                StringTokenizer siViaCdToken = new StringTokenizer(targetBkgNoList, "|");
                while(siViaCdToken.hasMoreTokens()){
                	String siVia = siViaCdToken.nextToken();
                	combineBkgList.add(siVia);
                }
            }
            if(combineBkgList != null && combineBkgList.size() > 0) {
                velParam.put("combine_bkg_nos", combineBkgList);
            }
//			param.put("combine_bkg_nos", targetBkgNoList);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchCombineTroNewSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CombineTroNewSeqVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyTroBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyTroBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyTroDtlBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyTroDtlBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyTroSpclCgoSeqBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyTroSpclCgoSeqBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyEurTroBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyEurTroBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyEurTroDtlBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyEurTroDtlBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * tro 愿��젴 �젙蹂대�� sourceBkg�뿉�꽌 targetBkg�쑝濡� 蹂듭궗�븳�떎.<br>
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void copyEurTroDgSeqBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcopyEurTroDgSeqBySplitCSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SCE_TRO_MAPG�뿉 Souce BKG媛� �뾾�뒗 寃쎌슦 cancel 泥섎━ 
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void cancelBkgTroBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcancelBkgTroBySplitUSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SCE_TRO_MAPG�뿉 Souce BKG媛� �뾾�뒗 寃쎌슦 cancel 泥섎━ 
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void cancelBkgTroDtlBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcancelBkgTroDtlBySplitUSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SCE_TRO_MAPG�뿉 Souce BKG媛� �뾾�뒗 寃쎌슦 cancel 泥섎━ 
	 * 
	 * @param sourceBkg String
	 * @param targetBkg String
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void cancelEurTroBySplit(String sourceBkg, String targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("source_bkg_no", sourceBkg);
			param.put("target_bkg_no", targetBkg);
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new TransferOrderIssueDBDAOcancelEurTroBySplitUSQL(), param, velParam);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * BKG_TRO_ACT_CUST 議댁옱�뿬遺� 議고쉶<br>
	 * @param     String ofcCd
	 * @param	  String troActRepSeq
	 * @return    String
	 * @exception DAOException
	 */
	public String selectBkgTroActCustExistYn(String ofcCd, String troActRepSeq) throws DAOException {

		DBRowSet dbRowset = null;
		String existYn = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put   ("ofc_cd", ofcCd);
			param.put   ("tro_act_rep_seq", troActRepSeq);
			velParam.put("ofc_cd", ofcCd);
			velParam.put("tro_act_rep_seq", troActRepSeq);

			dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSelectBkgTroActCustExistYnRSQL(), param, velParam);
			if(dbRowset.next()) {
				existYn = dbRowset.getString("exist_yn");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return existYn;
	}	
	/**
	 * TRO_SUB_SEQ瑜� 議고쉶�븳�떎.<br>
	 * @param     String bkgNo
	 * @param	  String ioBndCd
	 * @param	  String troSeq
	 * @return    
	 * @exception DAOException
	 */
	public List<TroDtlVO> searchEurTroSubSeq(String bkgNo, String ioBndCd, String troSeq) throws DAOException {

		DBRowSet dbRowset = null;
		
		List<TroDtlVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put   ("bkg_no", bkgNo);
			param.put   ("io_bnd_cd", ioBndCd);
			param.put   ("tro_seq", troSeq);
			velParam.put("bkg_no", bkgNo);
			velParam.put("io_bnd_cd", ioBndCd);
			velParam.put("tro_seq", troSeq);

			dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchEurTroSubSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroDtlVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * TRO_SUB_SEQ瑜� 議고쉶�븳�떎.<br>
	 * @param     String bkgNo
	 * @param	  String ioBndCd
	 * @param	  String troSeq
	 * @return    String
	 * @exception DAOException
	 */
	public String searchMinEurTroSubSeq(String bkgNo, String ioBndCd, String troSeq) throws DAOException {

		DBRowSet dbRowset = null;
		
		String minEurTroSubSeq = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put   ("bkg_no", bkgNo);
			param.put   ("io_bnd_cd", ioBndCd);
			param.put   ("tro_seq", troSeq);
			velParam.put("bkg_no", bkgNo);
			velParam.put("io_bnd_cd", ioBndCd);
			velParam.put("tro_seq", troSeq);

			dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchMinEurTroSubSeqRSQL(), param, velParam);
			if(dbRowset.next()) {
				minEurTroSubSeq = dbRowset.getString("min_eur_tro_sub_seq");
			 }
		}catch(SQLException se){
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}

		return minEurTroSubSeq;
	}
	
	/**
	 * Update MLT_STOP_SEQ <br>
	 * @author    KIM TAE KYOUNG
	 * @param     EurTroDtlVO vo
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyEurTroDtlMltSeq(EurTroDtlVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroMltSeqUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return result;
	}
	
	/**
	 * Check whether BKG_TRO is updated by other users or not. True is OK. False is NG.<br>
	 * @param     TroMstVO troMstVO
	 * @param     String processFlag
	 * @return    boolean
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public boolean searchBkgTroUpdate(TroMstVO troMstVO, String processFlag) throws DAOException {
		DBRowSet dbRowset = null;
		boolean retVal = false;

		//In case of "I", system check tro_seq exists or not to avoid duplication error.
		//In case of "U", system check someone already updated or not 
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(troMstVO != null){
				param.put("bkg_no", troMstVO.getBkgNo());
				param.put("tro_seq", troMstVO.getTroSeq());
				velParam.put("bkg_no", troMstVO.getBkgNo());
				velParam.put("tro_seq", troMstVO.getTroSeq());
				if("U".equals(processFlag)){ 
					param.put("upd_usr_id_old", troMstVO.getUpdUsrIdOld());
					param.put("upd_dt_old", troMstVO.getUpdDtOld());
					velParam.put("upd_usr_id_old", troMstVO.getUpdUsrIdOld());
					velParam.put("upd_dt_old", troMstVO.getUpdDtOld());					
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchBkgTroUpdateRSQL(), param, velParam);
			
			if(dbRowset.next()){
				if("U".equals(processFlag)){
					retVal = true;					
				}
			}else{
				if("I".equals(processFlag)){
					retVal = true;					
				}
			}

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
	 
		/**
		 * Check whether BKG_TRO_DTL is updated by other users or not. True is OK. False is NG.<br>
		 * @param     TroDtlVO troDtlVO
		 * @param     String processFlag
		 * @return    boolean
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public boolean searchBkgTroDtlUpdate(TroDtlVO troDtlVO, String processFlag) throws DAOException {
			DBRowSet dbRowset = null;
			boolean retVal = false;

			//In case of "I", system check tro_seq exists or not to avoid duplication error.
			//In case of "U", system check someone already updated or not 
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(troDtlVO != null){
					param.put("bkg_no", troDtlVO.getBkgNo());
					param.put("tro_seq", troDtlVO.getTroSeq());
					param.put("tro_sub_seq", troDtlVO.getTroSubSeq());
					velParam.put("bkg_no", troDtlVO.getBkgNo());
					velParam.put("tro_seq", troDtlVO.getTroSeq());
					velParam.put("tro_sub_seq", troDtlVO.getTroSubSeq());
					if("U".equals(processFlag)){ 
						param.put("upd_usr_id_old", troDtlVO.getUpdUsrIdOld());
						param.put("upd_dt_old", troDtlVO.getUpdDtOld());
						velParam.put("upd_usr_id_old", troDtlVO.getUpdUsrIdOld());
						velParam.put("upd_dt_old", troDtlVO.getUpdDtOld());					
					}
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchBkgTroDtlUpdateRSQL(), param, velParam);
				
				if(dbRowset.next()){
					if("U".equals(processFlag)){
						retVal = true;					
					}
				}else{
					if("I".equals(processFlag)){
						retVal = true;					
					}
				}
 
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return retVal;
		}
		 
	/**
	 * Retrieve to check the change of key information after confirm at EUR TRO<br>
	 * @param     String bkgNo
	 * @param     String ioBndCd
	 * @param     String troSeq
	 * @return    List<EurTroChangeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurTroChangeVO> searchEurTroChange(String bkgNo, String ioBndCd, String troSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurTroChangeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put   ("bkg_no",  bkgNo);
			param.put   ("io_bnd_cd",   ioBndCd);
			param.put   ("tro_seq", troSeq);

			velParam.put("bkg_no",  bkgNo);
			velParam.put("io_bnd_cd",   ioBndCd);
			velParam.put("tro_seq", troSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroChangeAfterConfirmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurTroChangeVO.class);

		}catch(SQLException se){
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	 
}
