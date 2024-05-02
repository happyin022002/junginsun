/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAO.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
* 2011.10.27 윤태승 [CHM-20113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
* 2011.12.09 금병주 [CHM-201114805-01] [BKG] 구주 TRO M/H 상 CNTR 중복 confirm 에 대한 Validation 추가 요청
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2014.02.07 문동선 [CHM-201428756] TROI notice 화면상 CNTR 선택기능 및 글자굵기 수정요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroXterIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.DgSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.QtyInfoForTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.ValidateInlandRouteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgEurTroDgSeqVO;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;




/**
 * ALPS TransferOrderIssueDBDAO <br>
 * - ALPS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Nam Kyung
 * @see TransferOrderIssueBCImpl 참조
 * @since J2EE 1.4
 */
public class TransferOrderIssueDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [Request-KR]Tro RtnTroEdiMain 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchRtnTroEdiMain(BkgBlNoVO vo, String troSeq, String rtnTroFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put   ("tro_seq",     troSeq);
			 param.put   ("rtn_tro_flg", rtnTroFlg);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq",     troSeq);
			 velParam.put("rtn_tro_flg", rtnTroFlg);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchRtnTroEdiMainRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("str_flatfile");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	/**
	 * [Request-KR]Tro RtnTroEdiCntr 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @return    List<String>
	 * @exception DAOException
	 */
	 public List<String> searchRtnTroEdiCntr(BkgBlNoVO vo, String troSeq, String rtnTroFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<String> list = new ArrayList<String>();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put   ("tro_seq",     troSeq);
			 param.put   ("rtn_tro_flg", rtnTroFlg);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq",     troSeq);
			 velParam.put("rtn_tro_flg", rtnTroFlg);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchRtnTroEdiCntrRSQL(), param, velParam);
			 for (int i=0; i<dbRowset.getRowCount(); i++) {
   				 dbRowset.next();
   				 String strTemp = dbRowset.getString("str_flatfile");
   				 list.add(strTemp);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){ 
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return list;
	 }

	/**
	 * [Request-KR]Tro TroStatus 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchTroStatus(BkgBlNoVO vo, String troSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();

			 param.putAll(mapVO);
			 param.put   ("tro_seq", troSeq);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq", troSeq);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroStatusRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("sts");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	/**
	 * [Request-KR]Tro TroIfModify 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchTroIfModify(BkgBlNoVO vo, String troSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();

			 param.putAll(mapVO);
			 param.put   ("tro_seq", troSeq);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq", troSeq);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroIfModifyRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("sts_mod");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	/**
	 * [Request-KR]Tro TroEdiMain 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @param     String modCd
	 * @param     String rtnTroFlg
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchTroEdiMain(BkgBlNoVO vo, String troSeq, String modCd, String rtnTroFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put   ("msg_id",      "INTHJSTRO");
			 param.put   ("mod_cd",      modCd);
			 param.put   ("rtn_tro_flg", rtnTroFlg);
			 param.put   ("tro_seq",     troSeq);

			 velParam.putAll(mapVO);
			 velParam.put("msg_id",      "INTHJSTRO");
			 velParam.put("mod_cd",      modCd);
			 velParam.put("rtn_tro_flg", rtnTroFlg);
			 velParam.put("tro_seq",     troSeq);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroEdiMainRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("str_flatfile");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	/**
	 * [Request-KR]Tro TroEdiDtl 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @return    List<String>
	 * @exception DAOException
	 */
	 public List<String> searchTroEdiDtl(BkgBlNoVO vo, String troSeq, String rtnTroFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<String> list = new ArrayList<String>();

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put   ("tro_seq",     troSeq);
			 param.put   ("rtn_tro_flg", rtnTroFlg);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq",     troSeq);
			 velParam.put("rtn_tro_flg", rtnTroFlg);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroEdiDtlRSQL(), param, velParam);

			 for (int i=0; i<dbRowset.getRowCount(); i++) {
   				 dbRowset.next();
   				 String strTemp = dbRowset.getString("str_flatfile");
   				 list.add(strTemp);
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return list;
	 }

	/**
	 * [Request-KR]Tro TroEdiEtc 조회<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO vo
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @return    String
	 * @exception DAOException
	 */
	 public String searchTroEdiEtc(BkgBlNoVO vo, String troSeq, String rtnTroFlg) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strReturn = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();

			 param.putAll(mapVO);
			 param.put   ("tro_seq",     troSeq);
			 param.put   ("rtn_tro_flg", rtnTroFlg);

			 velParam.putAll(mapVO);
			 velParam.put("tro_seq",     troSeq);
			 velParam.put("rtn_tro_flg", rtnTroFlg);

			 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchTroEdiEtcRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strReturn = dbRowset.getString("str_flatfile");
			 }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strReturn;
	 }

	/**
	 * Tro Request 완료여부를 변경한다.(ESM_BKG_0079_02B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String troSeq
	 * @param     String rtnTroFlg
	 * @param     SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgTroRqst(BkgBlNoVO bkgBlNoVO, String troSeq, String rtnTroFlg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no",       bkgBlNoVO.getBkgNo());
			param.put("rtn_tro_flg",  rtnTroFlg);
			param.put("tro_seq",      troSeq);
			param.put("upd_usr_id",   account.getUsr_id());

			velParam.put("bkg_no",       bkgBlNoVO.getBkgNo());
			velParam.put("rtn_tro_flg",  rtnTroFlg);
			velParam.put("tro_seq",      troSeq);
			velParam.put("upd_usr_id",   account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroRqstUSQL(), param, velParam);

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
	 * Tro Request Receive 정보를 저장한다.(ESM_BKG_0079_02B)<br>
	 * @author    Lee NamKyung
	 * @param     BkgTroXterIfVO vo
	 * @exception DAOException
	 */
	public void receiptHjtTroEdiAck(BkgTroXterIfVO vo) throws Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDDAOReceiptHjtTroEdiAckCSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			if(se.getMessage().indexOf("XPKBKG_TRO_XTER_IF") > 0){
				throw new EventException((String)new ErrorHandler("BKG00764",new String[]{vo.getIfDt()}).getMessage());
			} else {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		}catch(Exception ex){
			log.error(ex.toString());
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Tro Request Receive 정보를 저장한다.(ESM_BKG_0079_02B)<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String troSeq
	 * @exception DAOException
	 */
	public void modifyBkgTroAfterAck(String bkgNo, String troSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			//param.putAll(mapVO);
			param.put("bkg_no", bkgNo);
			param.put("tro_seq", troSeq);
			//param.put("upd_usr_id",   account.getUsr_id());

			//velParam.putAll(mapVO);
			velParam.put("bkg_no", bkgNo);
			velParam.put("tro_seq", troSeq);
			

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroAfterAckUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.toString());
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.toString());
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Tro 화면의 Booking Header 정보를 조회한다.(ESM_BKG_0079_02A/B/C)<br>
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
	 * Tro 화면의 Danger Cago 콤보목록을 조회한다.(ESM_BKG_0079_02A/B/C)<br>
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
	 * Tro 화면의 Reefer Cago 콤보목록을 조회한다.(ESM_BKG_0079_02A/B/C)<br>
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
	 * Tro 화면의 Awk Cago 콤보목록을 조회한다.(ESM_BKG_0079_02A/B/C)<br>
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
	 * Tro 화면의 Tro Master 정보를 조회한다.(ESM_BKG_0079_02A/B)<br>
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
	 * Tro 화면의 EurTro Master 정보를 조회한다.(EUR_TRO)<br>
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
	 * Tro 화면의 Tro Detail 정보를 조회한다.(ESM_BKG_0079_02A/B)<br>
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
	 * Tro 화면의 EurTro Detail 정보를 조회한다.(EUR_TRO)<br>
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
	 * Tro 화면의 EurTro Danger Cago 콤보목록을 조회한다.(EUR_TRO)<br>
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
	 * Tro 화면의 TroSeq별 Cago 멀티콤보 선택목록을 조회한다.(ESM_BKG_0079_02A/B)<br>
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
	 * Tro 화면의 TroSeq별 Qty 목록을 조회한다.(ESM_BKG_0079_02A/B)<br>
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
	 * [Tro Master]단건의 데이터를 cancel 처리한다.<br>
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
	 * [Tro Dtl]단건의 데이터를 cancel 처리한다.<br>
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
	 * [Tro Master]단건의 데이터를 add 처리한다.<br>
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
	 * [EurTro Master]단건의 데이터를 add 처리한다.<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Tro Master](eBooking용)단건의 데이터를 modify 처리한다.<br>
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
	 * [Tro Master]단건의 데이터를 modify 처리한다.<br>
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
	 * [EurTro Master](eBooking 용)단건의 데이터를 modify 처리한다.<br>
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
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroByXterUSQL(), param, velParam);
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
	 * [EurTro Master]단건의 데이터를 modify 처리한다.<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 컨테이너 존재여부 조회<br>
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
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return cntrExistYn;
	 }

//	/**
//	 * LocCode 존재여부 조회<br>
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
	 * ZoneCode 존재여부 조회<br>
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
	 * Container Partial 리턴 메세지코드 조회<br>
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
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return resultFlag;
	 }


    /**
	 * [Tro Detail] 단건의 데이터를 add 처리한다.<br>
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
	 * [EurTro Detail] 단건의 데이터를 add 처리한다.<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [Tro Detail] eBooking용 TroDtl을 modify 처리한다.<br>
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
	 * KR TRO/O Tab 의 Return CY Update.<br>
	 * @author    JKLim
	 * @param     String bkgNo 
	 * @param     String usrId
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyKrTroReturnCy(String bkgNo, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			param.put("bkg_no",   bkgNo);
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyBkgTroDtlByBkgUSQL(), param, velParam);
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
	 * Booking POL:KR, RCV Term CFS -> TRO Create<br>
	 * @author    JKLim
	 * @param     String bkgNo 
	 * @param     String usrId
	 * @return    int
	 * @exception DAOException
	 */
	public int manageKrCfsTroCreate(String bkgNo, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			param.put("bkg_no",   bkgNo);
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgTroKrCfsCSQL(), param, velParam);
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
	 * Booking POL:KR, RCV Term CFS -> TRO Create<br>
	 * @author    JKLim
	 * @param     String bkgNo 
	 * @param     String usrId
	 * @return    int
	 * @exception DAOException
	 */
	public int manageKrCfsTroDtlCreate(String bkgNo, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			param.put("bkg_no",   bkgNo);
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOAddBkgTroDtlKrCfsCSQL(), param, velParam);
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
	 * Tro TRO/O Tab 의 Remarks에 문구 modify 처리한다.<br>
	 * @author    Yun TaeSeung
	 * @param     String bkgNo 
	 * @param     String rtnTroFlg
	 * @param     String troSeq
	 * @return    int
	 * @exception DAOException
	 */
	public int modifyKrTroRmk(String bkgNo, String rtnTroFlg, String troSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			param.put("bkg_no",   bkgNo);
			param.put("rtn_tro_flg", rtnTroFlg);
			param.put("tro_seq",     troSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyKrTroRmkUSQL(), param, velParam);
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
	 * [Tro Detail] 단건의 데이터를 modify 처리한다.<br>
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
	 * [EurTro Detail] eBooking용 EurTro를 modify 처리한다.<br>
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
			result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL(), param, velParam);
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
	 * [EurTro Detail] 단건의 데이터를 modify 처리한다.<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [Tro Detail] 단건의 데이터를 remove 처리한다.<br>
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
	 * [Tro SpclCgo] TroSeq에 해당하는 Spcl Cago 데이터를 일괄remove 처리한다.<br>
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
	 * [Tro SpclCgo] TroSeq에 해당하는 Spcl Cago 데이터를 일괄 add 처리한다.<br>
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
	 * [EurTro SpclCgo] EurTroSeq에 해당하는 Danger Cago 데이터를 일괄 add 처리한다.<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [EurTro popup] EurTro에 입력된 Container에 해당하는 모든 Booking 번호를 조회한다<br>
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
	 * [Tro popup] Tro에 IfResult 목록을 조회한다<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<BkgTroXterIfVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgTroXterIfVO> searchTroIfResultList(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroXterIfVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroIfResultListRSQL(), param, velParam);  //TransferOrderIssueDBDAOBkgEurCntrListVORSQL()
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroXterIfVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR_TRO Cancel/Frust 조회<br>
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
	 * EUR_TRO Multi 대상 조회<br>
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
	 * EUR TRO Confirm 대상 조회<br>
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
	 * EUR_TRO Confirm 대상 조회<br>
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
	 * EUR_TRO confirm 처리<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	 

	 /**
	 * (ESM_BKG_0905) Customer/EQuipment Detail정보 add 처리<br>
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
	 * (ESM_BKG_0905) Customer/EQuipment Detail정보 modify 처리<br>
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
	 * (ESM_BKG_0905) Customer/EQuipment Detail정보 remove 처리<br>
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
	 * (ESM_BKG_0905) EQuipment Master정보 add 처리<br>
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
	 * (ESM_BKG_0905) EQuipment Master정보 modify 처리<br>
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
	 * (ESM_BKG_0905) EQuipment Master정보 remove 처리<br>
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
	 * (ESM_BKG_0905)Customer 탭의 Master 조회<br>
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
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustomerVO.class);  //returnVO : tableVO 로 변경
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * (ESM_BKG_0905)Customer 탭의 Detail 조회<br>
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
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActCustVO.class); //returnVO : tableVO 로 변경
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}	
	
	/**
	 * (ESM_BKG_0905) EQuipment Master정보 조회<br>
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
	 * (ESM_BKG_0905) EQuipment Detail정보 조회<br>
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
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActCustExtVO.class);  //BkgTroActCustVO + venderNm -> 단순tableVO 사용불가
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Vendor Name 조회<br>
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
	 * CntrNo별 Cago weight 조회<br>
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
 
	 /** (ESM_BKG_0079_02C) Search Guideline Revenue<br>
	 * @author    Jeon Sungjin
	 * @param     GlineRevInVO glineRevInVO
	 * @return    GlineRevOutVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public GlineRevOutVO searchGlineRev(GlineRevInVO glineRevInVO) throws DAOException {
		 GlineRevOutVO glineRevOutVO = null;
		 List<GlineRevOutVO> list = null;
		 DBRowSet dbRowset = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = glineRevInVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchGlineRevRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlineRevOutVO.class);
			 if (list != null && list.size() > 0) {
				 glineRevOutVO = (GlineRevOutVO)list.get(0);
		     }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return glineRevOutVO;
	 }
		 
	 /**
	 * (ESM_BKG_0905)Open시, Default값 초기화를 위한 정보 조회<br>
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
	 * BKG_EUR_TRO : CXL_FLG = 'Y' 로 변경한다.(EUR_TRO : ESM_BKG_0703 popup)<br>
	 *  : (confirm 관련정보 변경포함)
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
	 * BKG_EUR_TRO : EUR_TRNS_TP_CD = 'FR' 로 변경한다.(EUR_TRO : ESM_BKG_0703 popup)<br>
	 *  : (confirm 관련정보 변경포함)
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
	 *  BKG_TRO Flag 변경.(ESM_BKG_0079_01)<br>
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
	 *  BKG_EUR_TRO Flag 변경.(ESM_BKG_0079_01)<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * souceBKG의 bkg_tro_dtl를 targetBkg으로 넣는다.<br>
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
	 * souceBKG의 bkg_tro_dg_seq를 targetBkg으로 넣는다.<br>
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
	 *  souceBKG의 bkg_tro_xter_if를 targetBkg으로 넣는다.<br>
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
	 * troSeq 존재여부를 체크 (ESM_BKG_0920)<br>
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
	 * souceBKG의 bkg_eur_tro를 targetBkg으로 넣는다. <br>
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
	 * souceBKG의 bkg_eur_tro_dtl를 targetBkg으로 넣는다.<br>
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
	 * souceBKG의 bkg_eur_tro_dg_seq를 targetBkg으로 넣는다. <br>
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
	 * bkg_eur_tro table을 삭제  <br>
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
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOremoveEurTroDgSeqDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * bkg_eur_tro_dtl table을 삭제한다. <br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  bkg_eur_tro table을 삭제한다. <br>
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
	 * bkg_tro_spcl_cgo_seq table을 삭제한다. <br>
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
	 * bkg_tro_dtl table을 삭제한다. <br>
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
	 * bkg_tro_xter_if  table을 삭제한다. <br>
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
	 * bkg_tro  table을 삭제한다. <br>
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
	 * CTM에서 EUR mty release를 했을 때의 처리(unconfirm)<br>
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
	 * CTM에서 EUR mty release를 했을 때의 처리(confirm)<br>
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
	 * CTM에서 EUR mty release를 했을 때의 처리(redelivery)<br>
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
	 * Tro confirm시 같은 cntr를 다른 bkg에서 confirm하는 지 확인<br>
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
	 * combine시 tro를 옮겨 준다.<br>
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
	 * combine시 tro detail를 옮겨 준다.<br>
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
	 * combine시 europe tro를 옮겨 준다.<br>
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
	 * combine시 europe tro detail를 옮겨 준다.<br>
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
     * 변경하려는 route가 inland route로 등록되어 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @return      List<ValidateInlandRouteVO> 
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ValidateInlandRouteVO> validateInlandRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door, String trspModCd) throws DAOException{
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOvalidateInlandRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ValidateInlandRouteVO .class);

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
     * Tro Confirm Validation<br>
     * Tro Confirm대상이 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @return      List<ValidateInlandRouteVO> 
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ValidateInlandRouteVO> validateTroConfirm(BkgBlNoVO bkgBlNoVO,
			String boundCd, String fullCy, String door, String trspModCd) throws DAOException{
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOvalidateTroConfirmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ValidateInlandRouteVO .class);

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
     * eur tro에 pctl_no를 갱신한다..<br>
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
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

		/**
     * eur tro에 pctl_no를 갱신한다..<br>
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
	 * bkg의 마지막 tro seq 조회<br>
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
	 * Combine 후의 new tro seq를 조회한다<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * tro 관련 정보를 sourceBkg에서 targetBkg으로 복사한다.<br>
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
	 * SCE_TRO_MAPG에 Souce BKG가 없는 경우 cancel 처리 
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
	 * SCE_TRO_MAPG에 Souce BKG가 없는 경우 cancel 처리 
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
	 * SCE_TRO_MAPG에 Souce BKG가 없는 경우 cancel 처리 
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
     * Check Duplicate CNTR no. <br>
     * 
     * @param TroListForCfmVO troListForCfmVO
     * @return String
     * @throws DAOException
     */
	public int searchEurTroDupCntr(TroListForCfmVO troListForCfmVO) throws DAOException {
        DBRowSet dbRowset = null;
        int cnt = 0;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
               Map<String, String> mapVO = troListForCfmVO.getColumnValues();

               param.putAll(mapVO);
               velParam.putAll(mapVO);                

               dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOSearchEurTroDupCntrRSQL(), param, velParam);
               if(dbRowset.next()) {
                      cnt = dbRowset.getInt("cnt");
               }
        }catch(SQLException se){
               throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
               throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
	}
	
	/** (ESM_BKG_0317) Search arbitary Revenue<br>
	 * @author    Kim Jinjoo
	 * @param     GlineRevInVO glineRevInVO
	 * @return    List<GlineRevOutVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<GlineRevOutVO> searchArbitraryRev(GlineRevInVO glineRevInVO) throws DAOException {
//		 GlineRevOutVO glineRevOutVO = null;
		 List<GlineRevOutVO> list = null;
		 DBRowSet dbRowset = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = glineRevInVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchArbitraryRevRSQLRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlineRevOutVO.class);
//			 if (list != null && list.size() > 0) {
//				 glineRevOutVO = (GlineRevOutVO)list.get(0);
//		     }
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return list;
	 }
	 
	 /** (ESM_BKG_0317) Search arbitary Revenue<br>
		 * @author    Kim Jinjoo
		 * @param     GlineRevInVO glineRevInVO
		 * @return    List<GlineRevOutVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<GlineRevOutVO> searchArbitraryRevChk(GlineRevInVO glineRevInVO) throws DAOException {
//			 GlineRevOutVO glineRevOutVO = null;
			 List<GlineRevOutVO> list = null;
			 DBRowSet dbRowset = null;

			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 Map<String, String> mapVO = glineRevInVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchArbitraryRevChkRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlineRevOutVO.class);
//				 if (list != null && list.size() > 0) {
//					 glineRevOutVO = (GlineRevOutVO)list.get(0);
//			     }
			 }catch(SQLException se){
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 }catch(Exception ex){
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }

			 return list;
		 }
	 
	/** (ESM_BKG_1139) Cntr List 조회한다.<br>
	 * @author    Moon Dongsun
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    List<BkgEurTroVO>
	 * @exception EventException
	 */
	 public List<BkgEurTroVO> searchTroCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		 List<BkgEurTroVO> list = null;
		 DBRowSet dbRowset = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchTroCntrListByBkgRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgEurTroVO.class);
		 }catch(SQLException se){
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return list;
	 }	 
	 
	 
		/**
		 * Tro 화면의 container 콤보목록을 조회한다.(ESM_BKG_0079_02A/B/C)<br>
		 * @author    Lee NamKyung
		 * @param     BkgBlNoVO bkgBlNoVO
		 * @return    List<BkgComboVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgComboVO> searchEurTroCntr(BkgBlNoVO bkgBlNoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgComboVO> list = null;

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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransferOrderIssueDBDAOSearchEurTroCntrRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);

			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return list;
		}
		 
		 
		/**
		 * cop상의 qty와 tro qty일치하는지 check
		 * @param TroDtlVO vo
		 * @return String
		 * @throws DAOException
		 */
		public String checkCopQty(TroDtlVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			String result = "N";
			try {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOCheckCopQtyRSQL(), param, velParam);
				 if(dbRowset.next()) {
					 result = dbRowset.getString("cfm_block_flg");
				 }
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
		
		 /** inv로 운임이 if되었는지 체크
		 * @param String bkgNo
		 * @param String cntrNo
		 * @return String
		 * @throws DAOException
		 */
		public String checkInvChgIf(String bkgNo, String cntrNo) throws DAOException {

			 DBRowSet dbRowset = null;
			 String ifFlg = "";

			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 param.put   ("bkg_no", bkgNo);
				 velParam.put("bkg_no", bkgNo);
				 param.put   ("cntr_no", cntrNo);
				 velParam.put("cntr_no", cntrNo);

				 dbRowset = new SQLExecuter().executeQuery(new TransferOrderIssueDBDAOCheckInvChgIfRSQL(), param, velParam);
				 if(dbRowset.next()) {
					 ifFlg = dbRowset.getString("if_flg");
				 }
			 }catch(SQLException se){
				 throw new DAOException(new ErrorHandler(se).getMessage(), se);
			 }catch(Exception ex){
				 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			 }

			 return ifFlg;
		 }
		 
		
		/**Return CY,pick up cy정보를 업데이트한다.
		 * @param EurTroMstVO vo
		 * @throws DAOException
		 */
		public void modifyEurTroCyInfo(EurTroMstVO vo) throws DAOException {
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
				result = sqlExe.executeUpdate((ISQLTemplate)new TransferOrderIssueDBDAOModifyEurTroCyInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
}
