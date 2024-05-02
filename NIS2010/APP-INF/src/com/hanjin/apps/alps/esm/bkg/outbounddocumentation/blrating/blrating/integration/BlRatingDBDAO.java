/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingDBDAO.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================
 History
 2010.11.04 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 2010.11.04 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 2012.06.13 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F 
 2012.12.12 조정민 [CHM-201221699] Split 01-bkg 생성및 변경시 운임 체크 경고문 발생시 BST에 Rate check status 컬럼 추가 및 조회
 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgRevCostVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtAmtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgChgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCustVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.GroupRatingVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateCheckNoticeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateEtcInfo1VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaBkgInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaCustInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScBkgInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScCustInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ServiceScopeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaBkgInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaCustInformVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TroRevenueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAdjustmentVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.InvIfDiffVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.OrganizationChartVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrRtVO;
import com.hanjin.syscommon.common.table.BkgRateVO;

/**
 * NIS2010 BlRatingDBDAO <br>
 * - NIS2010-BlRating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BlRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class BlRatingDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -5026673724177942357L;

	/**
	 * 다건의 BKG_AUTO_RT_HIS Data에 해당하는 정보를 추가한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param List<BkgChgRateVO> listVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void autoRatingHistory(List<BkgChgRateVO> listVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = listVO.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				DBRowSet dbRowset = null;
				int insCnt = 0 ;
				int count = 0 ;
				
				Map<String, String> fmapVO = listVO.get(0).getColumnValues();
				param.putAll(fmapVO);
				velParam.putAll(fmapVO);
			
				//데이터존재여부
				velParam.put("sql_type", "count");
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOAutoRatingHistoryUSQL(), param, velParam);
				if (dbRowset.next()) {
					 count = dbRowset.getInt(1);
				}
				//데이터 삭제 
				if( count>0){
					velParam.put("sql_type", "delete");
					insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAutoRatingHistoryUSQL(), param, velParam);
				}
				
				velParam.put("sql_type", "insert");
				//데이터 추가 
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();
					param.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAutoRatingHistoryUSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 BKG_AUTO_RT_HIS Data에 해당하는 정보를 추가한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void autoRatingHistory(String bkgNo) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt = 0 ;
			
			param.put("bkg_no", bkgNo);
			velParam.put("sql_type", "delete");
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAutoRatingHistoryUSQL(), param, velParam);
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAutoRatingHistoryForGroupRatingCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT Data에 해당하는 Master정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO  rateMainInfoVO 
	 * @param String caflag
	 * @return int
	 * @exception EventException
	 */
	public int modifyChgRateMaster(RateMainInfoVO rateMainInfoVO, String caflag) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;

		try {
			Map<String, String> mapVO = rateMainInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.put("caflag", caflag);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyChgRateMasterUSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI 에서 Audit 이후 Status 업데이트 처리한다..<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String audSts
	 * @param String user_id
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyAudSts(String bkgNo, String audSts, String user_id,  String caFlg) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;

		try {
			param.put("bkg_no", bkgNo);
			param.put("aud_sts_cd", audSts);
			param.put("user_id", user_id);
			param.put("ca_flg", caFlg);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("aud_sts_cd", audSts);
			velParam.put("user_id", user_id);
			velParam.put("ca_flg", caFlg);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyAudStsUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Booking 에서 계약 Type Update 시 ctrtTpCd 를 업데이트 처리한다..<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String ctrtTpCd
	 * @param String user_id
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyCtrtTpCd(String bkgNo, String ctrtTpCd, String user_id,  String caFlg) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;

		try {
			param.put("bkg_no", bkgNo);
			param.put("ctrt_tp_cd", ctrtTpCd);
			param.put("user_id", user_id);
			param.put("ca_flg", caFlg);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ctrt_tp_cd", ctrtTpCd);
			velParam.put("user_id", user_id);
			velParam.put("ca_flg", caFlg);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyCtrtTpCdUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI 에서 Audit 이후 revAudDt 업데이트 처리한다..<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String revAudDt
	 * @param String user_id
	 * @exception DAOException
	 */
	public void modifyAudDt(String bkgNo, String revAudDt, String user_id) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;

		try {
			param.put("bkg_no", bkgNo);
			param.put("rev_aud_dt", revAudDt);
			param.put("user_id", user_id);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("rev_aud_dt", revAudDt);
			velParam.put("user_id", user_id);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyAudDtUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TRO 에서 CHG 를 넣기 위해 BKG_RATE 에 Insert 한다.<br>
	 * 
	 * @author KIM TAE KYOUNG 
	 * @param String bkgNo
 	 * @param String caFlg
	 * @param String user_id
	 * @exception EventException
	 */
	
	public void createRateForTro(String bkgNo, String caFlg,String user_id) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			param.put("user_id", user_id);
			
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("user_id", user_id);
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOCreateRateForTroCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException ex){
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}catch (Exception ex){
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 추가한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param List<BkgChgRateVO> listVO
	 * @param String caflag
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void addChgRate(List<BkgChgRateVO> listVO, String caflag) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = listVO.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();
					param.putAll(mapVO);
					velParam.put("caflag",caflag);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddChgRateCSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 수정한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param List<BkgChgRateVO> listVO
	 * @param String caflag
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void modifyChgRate(List<BkgChgRateVO> listVO, String caflag) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int cnt[] = null;
			int size = listVO.size();
			if (size > 0) {
				
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					velParam.put("caflag",caflag);
					int insCnt = 0 ;
					// Nomal  by 김태경  조건 제한 풀어줌 
					//if("N".equals( bkgChgRateVO.getInclOftFlg())){
						  insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyChgRateUSQL(), param, velParam);
					/*}else{
						  insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyChgRate1USQL(), param, velParam);
					}*/
					
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Charge Amend 권한 사용여부를 업데이트 한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
    public void modifyChargeAmendAuthUseFlag(String bkgNo, SignOnUserAccount account) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("bkg_no",bkgNo);
			param.put("usr_id",account.getUsr_id());
			param.put("ofc_cd",account.getOfc_cd());
			
			int updCnt = 0 ;
			updCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyChargeAmendAuthUseFlagUSQL(), param, velParam);
			
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_CHG_RT Data에 해당하는 정보를 ALL 삭제한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caflag
	 * @exception DAOException
	 */
    public void removeChgRateAll(String bkgNo, String caflag) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.put("bkg_no",bkgNo);
				velParam.put("caflag",caflag);
				
				int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAORemoveChgRateALLDSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 삭제한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param List<BkgChgRateVO> listVO
	 * @param String caflag
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void removeChgRate(List<BkgChgRateVO> listVO, String caflag) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int cnt[] = null;
			int size = listVO.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();
					param.putAll(mapVO);
					velParam.put("caflag",caflag);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAORemoveChgRateDSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 화면번호 : ESM_BKG_0961 Booking customer Inquiry <<관련 Use Case UC-BKG-012:
	 * Rating Creation>> Booking customer를 보여주는 화면
	 * 
	 * @author LEE JIN SEO
	 * @param PpdCctCustInVO ppdCctCustInVO
	 * @return List<PpdCctCustOutVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PpdCctCustOutVO> searchPayerCode(PpdCctCustInVO ppdCctCustInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PpdCctCustOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ppdCctCustInVO != null) {
				Map<String, String> mapVO = ppdCctCustInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchPayerCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PpdCctCustOutVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0270 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Note 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScNoteInVO scNoteInVO
	 * @return List<ScNoteOutVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScNoteOutVO> searchScNote(ScNoteInVO scNoteInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScNoteOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scNoteInVO != null) {
				Map<String, String> mapVO = scNoteInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchScNoteRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScNoteOutVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0265 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ca_flg
	 * @return List<ChargeRemarkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeRemarkVO> searchChargeRemark(String bkg_no, String ca_flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeRemarkVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("ca_flg", ca_flg);
			velParam.put("ca_flg",ca_flg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchChargeRemarkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeRemarkVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0265 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ca_flg
	 * @param String diff_rmk
	 * @param String inter_rmk
	 * @param String doc_inter_rmk
	 * @param String user_id
	 * @exception DAOException
	 */
	public void manageChargeRemark(String bkg_no, String ca_flg, String diff_rmk, String inter_rmk, String doc_inter_rmk, String user_id) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		int insCnt = 0 ;
		int count = 0 ;
		
		try {
			param.put("bkg_no", bkg_no);
			param.put("ca_flg", ca_flg);
			param.put("diff_rmk", diff_rmk);
			param.put("inter_rmk", inter_rmk);
			param.put("doc_inter_rmk", doc_inter_rmk);
			param.put("user_id", user_id);

			velParam.put("ca_flg",ca_flg);
			velParam.put("sql_type", "count");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOManageChargeRemarkUSQL(), param, velParam);
			
			if (dbRowset.next()) {
				 count = dbRowset.getInt(1);
			}

			if( count>0){
				velParam.put("sql_type", "update");
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOManageChargeRemarkUSQL(), param, velParam);
			}else{
				velParam.put("sql_type", "insert");
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOManageChargeRemarkUSQL(), param, velParam);
			}
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0264 조회 이벤트 처리<br>
	 * Freight & Charge_BKG Q'TY Inquiry 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<BkgQtyOutVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgQtyOutVO> searchQtyForRate(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyOutVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchQtyForRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgQtyOutVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 화주의 S/C 계약을 조회함 -- UI_BKG-0269 BKG 데이터 조회
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO scInformInVO
	 * @return ScBkgInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScBkgInformVO searchScBkgInform(ScInformInVO scInformInVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<ScBkgInformVO> list = null;
		ScBkgInformVO rScBkgInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scInformInVO != null) {
				Map<String, String> mapVO = scInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchScBkgInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScBkgInformVO.class);
			if (list != null && list.size() > 0) {
				rScBkgInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rScBkgInformVO;
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 화주의 S/C 계약을 조회함 -- UI_BKG-0269 BKG Customer와 PRI에서 S/C Customer를 조회한다.
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO scInformInVO
	 * @return ScCustInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScCustInformVO searchScCustInform(ScInformInVO scInformInVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<ScCustInformVO> list = null;
		ScCustInformVO rScCustInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scInformInVO != null) {
				Map<String, String> mapVO = scInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchScCustInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScCustInformVO.class);
			if (list != null && list.size() > 0) {
				rScCustInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rScCustInformVO;
	}

	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO scInformInVO
	 * @return List<ScInformListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScInformListVO> searchScInformList(ScInformInVO scInformInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScInformListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scInformInVO != null) {
				Map<String, String> mapVO = scInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchScInformListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScInformListVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * BKG 데이터 조회
	 * 
	 * @author LEE JIN SEO
	 * @param RfaInformInVO rfaInformInVO
	 * @return RfaBkgInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RfaBkgInformVO searchRfaBkgInform(RfaInformInVO rfaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaBkgInformVO> list = null;
		RfaBkgInformVO rRfaBkgInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rfaInformInVO != null) {
				Map<String, String> mapVO = rfaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRfaBkgInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfaBkgInformVO.class);
			if (list != null && list.size() > 0) {
				rRfaBkgInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rRfaBkgInformVO;
	}

	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * BKG Customer와 PRI에서 S/C Customer를 조회한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RfaInformInVO rfaInformInVO
	 * @return RfaCustInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RfaCustInformVO searchRfaCustInform(RfaInformInVO rfaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaCustInformVO> list = null;
		RfaCustInformVO rRfaCustInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rfaInformInVO != null) {
				Map<String, String> mapVO = rfaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRfaCustInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfaCustInformVO.class);
			if (list != null && list.size() > 0) {
				rRfaCustInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rRfaCustInformVO;
	}
	
	/**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * BKG Container VGM Info를 조회한다<br>
     * 
     * @author KIM DONG HO
     * @param String bkg_no
     * @param String ca_flg
     * @return List<BkgCntrVgmInfoListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgCntrVgmInfoListVO> searchBkgCntrVGMInfoList(String bkg_no, String ca_flg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgCntrVgmInfoListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("bkg_no", bkg_no);
            param.put("ca_flg", ca_flg);
            
            velParam.put("bkg_no", bkg_no);
            velParam.put("ca_flg", ca_flg);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOBkgCntrVgmInfoListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCntrVgmInfoListVO.class);
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * TP/CGO/QTY 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RateQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RateQtyVO> searchRateQtyList(BkgBlNoVO bkgBlNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<RateQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateQtyListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RateQtyVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * EsmBkg0739 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * SC 정보를 조회한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RfaInformInVO rfaInformInVO
	 * @return List<RfaInformListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RfaInformListVO> searchRfaInformList(RfaInformInVO rfaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaInformListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rfaInformInVO != null) {
				Map<String, String> mapVO = rfaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRfaInformListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfaInformListVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0771 조회 이벤트 처리<br>
	 * BKG No로 현재 Master BKG가 가지고 있는 Covered B/L No를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String bl_no
	 * @param String caFlg
	 * @return List<CoveredBlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CoveredBlListVO> searchCoveredBl(String bkg_no, String bl_no,String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoveredBlListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("bl_no", bl_no);
			velParam.put("caflag",caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchCoveredBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CoveredBlListVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg0771 수정가능여부 처리<br>
	 * Master B/L을 업데이트 하기 위한 조건의 조회 실행<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bl_no
	 * @param String c_bl_no
	 * @return CoveredBlVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CoveredBlVO searchMstCvrdInfo(String bl_no, String c_bl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoveredBlVO> list = null;
		CoveredBlVO coveredBlVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", bl_no);
			param.put("c_bl_no", c_bl_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchMstCvrdInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CoveredBlVO.class);
			if (list != null && list.size() > 0) {
				coveredBlVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return coveredBlVO;
	}
	/**
	 * EsmBkg07908 데이터를 갱신처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 업데이트 한다.<br>
	 * BL_CVRD_TP_CD 도 로 업데이트 한다.<br>
	 * 
	 * @author Lee Jin Seo
	 * @param String bl_no
	 * @param String bl_cvrd_tp_cd
	 * @param String caflag
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCoveredBl(String bl_no, String bl_cvrd_tp_cd,String caflag) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("bl_no", bl_no);
		param.put("bl_cvrd_tp_cd", bl_cvrd_tp_cd);
		velParam.put("caflag", caflag);
		
		try {
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyCoveredBlUSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)	throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * EsmBkg0771 데이터를 갱신처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다.<br>
	 * BL_CVRD_TP_CD 도 Null로 업데이트 한다.<br>
	 * 
	 * @author Lee Jin Seo
	 * @param List<CoveredBlListVO> listVO
	 * @param String caFlg
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public int modifyCoveredBl(List<CoveredBlListVO> listVO ,String caFlg) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		SQLExecuter sqlExe = new SQLExecuter("");
		
		int size = listVO.size();
		int insCnt = 0;

		try {
  
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					CoveredBlListVO coveredBlListVO = (CoveredBlListVO) list.next();
					Map<String, String> mapVO = coveredBlListVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					
					param.put("rt_bl_tp_cd",coveredBlListVO.getBlCvrdTpCd());
					velParam.put("caflag",caFlg);
					
					
					dbRowset = sqlExe.executeQuery((ISQLTemplate)new BlRatingDBDAOModifyChgRateBkgRateRSQL(), param, velParam);
					dbRowset.next();
					if (dbRowset.getInt(1) > 0) {
						// UPDATE
						insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyCoveredBlUSQL(), param, velParam);
					}else{
						// INSERT
						if("Y".equals(caFlg)) return insCnt;
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyChgRateBkgRateCSQL(), param, velParam);
					}
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * EsmBkg0945 조회 이벤트 처리<br>
	 * Exchange Rate 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExchangeRateVO> searchXchRt(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExchangeRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchXchRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExchangeRateVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg007908 조회 이벤트 처리<br>
	 * Freight & Charge - 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String caflag
	 * @return List<RateMainInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RateMainInfoVO> searchRateMainInfo(String bkg_no,String caflag) throws DAOException {
		DBRowSet dbRowset = null; 
		List<RateMainInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkg_no);
			velParam.put("caflag", caflag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateMainInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RateMainInfoVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EsmBkg007908 조회 이벤트 처리<br>
	 * 운임 목록 리스트 데이터를 조회한다. -- UI_BKG-0079-08<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String caflag
	 * @return List<BkgChgRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChgRateVO> searchChgRate(String bkg_no,String caflag) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChgRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkg_no);
			velParam.put("caflag", caflag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchChgRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgChgRateVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EsmBkg007908 조회 이벤트 처리<br>
	 * Freight & Charge - 를 조회한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkg_no
	 * @param String caflag
	 * @return List<RateCntrInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RateCntrInfoVO> searchRateCntrInfo(String bkg_no,String caflag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RateCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkg_no);
			velParam.put("caflag", caflag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateCntrInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RateCntrInfoVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
    /**
     * manageCntrRate
     * 
     * @param List<CntrRtVO> voList
     * @exception DAOException 
     */
    public void manageCntrRate(List<CntrRtVO> voList) throws DAOException {
        int rsCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            if(voList.size() > 0) {
                BlRatingDBDAOCntrRtUSQL template = new BlRatingDBDAOCntrRtUSQL();
                rsCnt = sqlExe.executeBatch(template, voList, null);
                for(int i = 0; i < rsCnt.length; i++) {
                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }

	/**
	 * EsmBkg007908 조회 이벤트 처리<br>
	 * 운임 Prepaid, Collect , 3rd Pard-PPD, 3rd Pard-CCT 데이터를 조회한다. --
	 * UI_BKG-0079-08<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param caflag
	 * @return List<RateEtcInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RateEtcInfoVO> searchRateEtcInfo(String bkg_no,String caflag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RateEtcInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkg_no);
			velParam.put("caflag", caflag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateEtcInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RateEtcInfoVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * EsmBkg007908 조회 이벤트 처리<br>
	 * 7. Rating에서 한 번도 Save하지 않은 최초 상태로 open되는 경우의 Pre set	
	 * UI_BKG-0079-08<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String caflag
	 * @return List<RateEtcInfo1VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RateEtcInfo1VO> searchRateEtcInfo1(String bkg_no,String caflag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RateEtcInfo1VO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkg_no);
			velParam.put("ca_flg", caflag);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateQtyListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RateEtcInfo1VO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * BKG_CHG_RT에서 BkgRate Data에 해당하는 정보를 수정한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception DAOException
	 */
	    public void modifyChgRateBkgRate(RateMainInfoVO rateMainInfoVO ,String caflag) throws DAOException,Exception {
			DBRowSet dbRowset = null;
	        Map<String, Object> param = new HashMap<String, Object>();
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        int result =0;
	        
		try {
	            Map<String, String> mapVO = rateMainInfoVO.getColumnValues();
	            param.putAll(mapVO);
	            velParam.put("caflag",caflag);

	            /**
	             *    RT_BL_TP_CD = NULL,  --N
	             *    FRT_TERM_CD = NULL,   -- P 
	             *    BKG_CTRT_TP_CD = 'S',    -- R, -- S  -- T
	             */
	            if(rateMainInfoVO.getRtBlTpCd() == null || rateMainInfoVO.getRtBlTpCd().length() == 0){
	            	param.put("rt_bl_tp_cd", "N");
	            }
	            if(rateMainInfoVO.getFrtTermCd() == null || rateMainInfoVO.getFrtTermCd().length() == 0){
	            	param.put("frt_term_cd", "P");
	            }
				if(rateMainInfoVO.getScNo1() != null && rateMainInfoVO.getScNo1().length() > 0){
					param.put("bkg_ctrt_tp_cd", "S");
				}else
				if(rateMainInfoVO.getRfaNo() != null && rateMainInfoVO.getRfaNo().length() > 0){
					param.put("bkg_ctrt_tp_cd", "R");
				}else
				if(rateMainInfoVO.getTaaNo() != null && rateMainInfoVO.getTaaNo().length() > 0){
					param.put("bkg_ctrt_tp_cd", "T");
				}
				
	            SQLExecuter sqlExe = new SQLExecuter("");
	            
	            dbRowset = sqlExe.executeQuery((ISQLTemplate)new BlRatingDBDAOModifyChgRateBkgRateRSQL(), param, velParam);
	        	dbRowset.next();
	            if (dbRowset.getInt(1) > 0) {
	            	// UPDATE
	            	 result = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyChgRateBkgRateUSQL(), param, velParam);
				} else {
					// INSERT
					 result = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyChgRateBkgRateCSQL(), param, velParam);
				}
	            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Modify SQL");
		} catch (SQLException ex) {
	            //log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }catch(Exception ex){
	            //log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }
	    
	/**
	 * searchCntrRateByCntr
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtSeq
	 * @return List<BkgCntrRtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCntrRtVO> searchCntrRateByCntr(String bkgNo, String cntrNo, String cntrRtSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCntrRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_rt_seq", cntrRtSeq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);  

			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BlRatingDBDAOCntrRateByCntrRSQL template = new BlRatingDBDAOCntrRateByCntrRSQL();
			dbRowset = sqlExec.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCntrRtVO.class);

		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * insertCntrRateByCntr
	 * 
	 * @param BkgCntrRtVO bkgCntrRtVO
	 * @exception DAOException
	 */
	public void insertCntrRateByCntr(BkgCntrRtVO bkgCntrRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = bkgCntrRtVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOCntrRateByCntrCSQL template = new BlRatingDBDAOCntrRateByCntrCSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			// //log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			// //log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * removeCntrRateByCntr
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtSeq
	 * @exception DAOException
	 */
	public void removeCntrRateByCntr(String bkgNo, String cntrNo, String cntrRtSeq) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_rt_seq", cntrRtSeq);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);              

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOCntrRateByCntrDSQL template = new BlRatingDBDAOCntrRateByCntrDSQL();
			int result = sqlExe.executeUpdate(template, param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			// //log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			// //log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * split,cod시 new booking의 bkg_rate table을 targetBkg으로 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBkgRateByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", sourceBkg.getBkgNo());
			param.put("targetBkg", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOcopyBkgRateByBkgCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * sourceBkg의 bkg_chg_rate의 row중 manual rate인 row만 target으로 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyManualChg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", sourceBkg.getBkgNo());
			param.put("targetBkg", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOcopyManualChgCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * rate에 입력할 ofc_cd를 조회 (ESM_BKG_0906)<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchCHRateOfc(BkgBlNoVO vo, String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String strResult = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 param.put("ofc_cd", ofcCd);
			 
			 velParam.putAll(mapVO);
			 velParam.put("ofc_cd", ofcCd);

			 dbRowset = new SQLExecuter().executeQuery(new BlRatingDBDAOSearchCHRateOfcRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 strResult = dbRowset.getString("rate_ofc");
			 }
		 }catch(SQLException ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }catch(Exception ex){
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return strResult;
	 }

	/**
	 * 기존에 입력된 TRO관련 rate를 delete (ESM_BKG_0906)<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception DAOException 
	 */
	 public void removeCHRevenue(BkgBlNoVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAORemoveCHRevenueDSQL(), param, velParam);
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	 
	/**
	 * cntr별 rate를 insert (ESM_BKG_0906)<br>
	 * @author Lee NamKyung
	 * @param TroRevenueVO vo
	 * @exception DAOException
	 */
	 public void addT1Revenue(TroRevenueVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddT1RevenueCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * cntr별 vatRate를 insert (ESM_BKG_0906)<br>
	 * @author Lee NamKyung
	 * @param double vatRevenue
	 * @param TroRevenueVO vo
	 * @param String ofcCd
	 * @exception DAOException	 
	 */
	 public void addVATRevenue(double vatRevenue, TroRevenueVO vo, String ofcCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();			
			param.putAll(mapVO);
			param.put("vat_rate", vatRevenue);
			param.put("ofc_cd",   ofcCd);
			
			velParam.putAll(mapVO);
			velParam.put("vat_rate", vatRevenue);
			velParam.put("ofc_cd",   ofcCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddVATRevenueCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	/**
	 *  rate를 Eur로 환산 (ESM_BKG_0906)<br>
	 * @author Lee NamKyung
	 * @param  String currCd
	 * @param  double rate
	 * @return double
	 * @exception DAOException
	 */
	 public double searchVATtoEur(String currCd, double rate) throws DAOException {
		 DBRowSet dbRowset = null;
		 double dResult = 0;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put   ("curr_cd", currCd);
			 param.put   ("rate",    rate);
			 
			 velParam.put("curr_cd", currCd);
			 velParam.put("rate",    rate);

			 dbRowset = new SQLExecuter().executeQuery(new BlRatingDBDAOSearchVATtoEurRSQL(), param, velParam);
			 if(dbRowset.next()) {
				 dResult = dbRowset.getDouble("vat");
			 }
		 }catch(SQLException ex){
			 //log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }catch(Exception ex){
			 //log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }

		 return dResult;
	 }
	 
	 /**
	  * bkg_cod_cost에서 bkg_chg_rt 로 rehandling charge를 복사한다.
	  * @param String codRqstSeq
	  * @param BkgBlNoVO bkgBlNoVO
	  * @param SignOnUserAccount account
	  * @exception DAOException
	  */
	 public void addCodRehandlingChg(String codRqstSeq , BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cod_rqst_seq",codRqstSeq);
			velParam.put("cod_rqst_seq",codRqstSeq);
			param.put("usr_id",account.getUsr_id());
			velParam.put("usr_id",account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOaddCodRehandlingChgCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

    /**
     * sourceBkg의 bkg_chg_rt정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyChgRateByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOcopyChgRateByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			}catch(SQLException ex){
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd에 따라, BKG_CHG_RT/BKG_CHG_RT_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeChgRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAORemoveChgRateCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd에 따라, BKG_TRF_SCG_RT/BKG_TRF_SCG_RT_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeTariffSurchargeRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAORemoveTariffSurchargeRateCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_RATE/BKG_RT_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException 
	 */
	public void removeRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAORemoveRateCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_RATE/BKG_RT_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCreateRateCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_CHG_RT/BKG_CHG_RT_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createChgRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCreateChgRateCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_CHG_RT/BKG_CHG_RT_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createTariffSurchargeRateCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCreateTariffSurchargeRateCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * searchCntrRtBkgInfo
     * 
     * @param String bkgNo
     * @return CntrRtBkgInfoVO
     */
    @SuppressWarnings("unchecked")
    public CntrRtBkgInfoVO searchCntrRtBkgInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        CntrRtBkgInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtBkgInfoRSQL template = new BlRatingDBDAOCntrRtBkgInfoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            List<CntrRtBkgInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtBkgInfoVO.class);
            if(list.size() > 0){
                rsVO = list.get(0);
            } else {
            	rsVO = new CntrRtBkgInfoVO();
            }
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * searchCntrRtQty
     * 
     * @param String bkgNo
     * @return List<CntrRtQtyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtQtyVO> searchCntrRtQty(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtQtyRSQL template = new BlRatingDBDAOCntrRtQtyRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtQtyVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * searchCntrRt
     * 
     * @param String bkgNo
     * @return List<CntrRtVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtVO> searchCntrRt(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtRSQL template = new BlRatingDBDAOCntrRtRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * addCntrRt
     * 
     * @param BkgCntrRtVO cntrRtVO
     * @param String caFlag
     * @exception DAOException 
     */
    public void addCntrRt(BkgCntrRtVO cntrRtVO, String caFlag) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = cntrRtVO.getColumnValues();
            mapVO.put("ca_flag", caFlag);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtCSQL template = new BlRatingDBDAOCntrRtCSQL();
            int insCnt = sqlExe.executeUpdate(template, param, velParam);
            if (insCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
//        int rsCnt[] = null;
//        try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            if(voList.size() > 0) {
//                Map<String, Object> velParam = new HashMap<String, Object>();
//                velParam.put("ca_flag", caFlag);
//                
//                BlRatingDBDAOCntrRtCSQL template = new BlRatingDBDAOCntrRtCSQL();
//                rsCnt = sqlExe.executeBatch(template, voList, velParam);
//                for(int i = 0; i < rsCnt.length; i++) {
//                    if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
//                }
//            }
//        } catch(SQLException ex) {
//            // //log.error(ex.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        } catch(Exception ex) {
//            // //log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }        
    }

    /**
     * remove Cntr Rate
     * 
     * @param List<CntrRtBkgNoVO> voList
     * @exception DAOException 
     */
    public void removeCntrRt(List<CntrRtBkgNoVO> voList) throws DAOException {
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try {
//            Map<String, String> mapVO = new HashMap<String, String>();
//            mapVO.put("bkg_no", bkgNo);
//            mapVO.put("ca_flag", caFlag);
//                        
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            BlRatingDBDAOCntrRtDSQL template = new BlRatingDBDAOCntrRtDSQL();
//            int insCnt = sqlExe.executeUpdate(template, param, velParam);
//            if (insCnt == Statement.EXECUTE_FAILED)
//                throw new DAOException("Fail to insert SQL");
//        } catch (SQLException ex) {
//            //log.error(ex.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        } catch (Exception ex) {
//            //log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
        int rsCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtDSQL template = new BlRatingDBDAOCntrRtDSQL();
            rsCnt = sqlExe.executeBatch(template, voList, null);
            for(int i = 0; i < rsCnt.length; i++) {
                if(rsCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
            }
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }        
    }
   

    /**
     * searchCntrRtAmt
     * 
     * @param String bkgNo
     * @return List<CntrRtAmtVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtAmtVO> searchCntrRtAmt(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtAmtVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtAmtRSQL template = new BlRatingDBDAOCntrRtAmtRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtAmtVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * searchCntrRtCust
     * 
     * @param String bkgNo
     * @return List<CntrRtCustVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtCustVO> searchCntrRtCust(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtCustVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtCustRSQL template = new BlRatingDBDAOCntrRtCustRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtCustVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    } 
    
	/**
	 * booking copy시 ppd ofc와 cct ofc를 copy해준다.
	 * @author 	Kim Byung Kyu
	 * @param  	BkgBlNoVO sourceBkg
	 * @param   BkgBlNoVO targetBkg
	 * @param   SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void copyPpdCctByBkg(BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			param.put   ("usr_id", account.getUsr_id());
			param.put   ("target_bkg_no", targetBkg.getBkgNo());
			param.put   ("source_bkg_no", sourceBkg.getBkgNo());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCopyPpdCctByBkgCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * search Cntr Cfrm By Bkg
     * 
     * @author KimYoungchul
     * @param bkgNo
     * @param caFlag
     * @return String
     * @exception DAOException
     */
    public String checkCntrCfrmByBkg(String bkgNo, String caFlag) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flag", caFlag);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtCntrCfrmRSQL template = new BlRatingDBDAOCntrRtCntrCfrmRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchCntrRtBkgNo
     * 
     * @param String bkgNo
     * @param String caFlag
     * @return List<CntrRtBkgNoVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtBkgNoVO> searchCntrRtBkgNo(String bkgNo, String caFlag) throws DAOException,Exception {
        DBRowSet dbRowset = null;
        List<CntrRtBkgNoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flag", caFlag);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtBkgNoRSQL template = new BlRatingDBDAOCntrRtBkgNoRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtBkgNoVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    
	/**
	 * bkg_no에 해당하는 mastered/covered B/L의 모든 charge 목록을 검색한다.
	 * 
	 * @param String bkgNo
	 * @param String mstFlag
	 * @param String caFlag
	 * @return List<CntrRtBkgChgVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<CntrRtBkgChgVO> searchChgRateByBkg(String bkgNo, String mstFlag, String caFlag) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtBkgChgVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("mst_flag", mstFlag);
            mapVO.put("ca_flag", caFlag);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtBkgChgRSQL template = new BlRatingDBDAOCntrRtBkgChgRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtBkgChgVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * searchContainerByBkg
     * 
     * @param String bkgNo
     * @param String mstFlag
     * @param String caFlag
     * @return List<CntrRtCntrVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtCntrVO> searchContainerByBkg(String bkgNo, String mstFlag, String caFlag) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("mst_flag", mstFlag);
            mapVO.put("ca_flag", caFlag);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtCntrRSQL template = new BlRatingDBDAOCntrRtCntrRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtCntrVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * searchBkgQty
     * 
     * @param String bkgNo
     * @param String caFlag
     * @return List<CntrRtBkgQtyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CntrRtBkgQtyVO> searchBkgQty(String bkgNo, String caFlag) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrRtBkgQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flag", caFlag);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrRtBkgQtyRSQL template = new BlRatingDBDAOCntrRtBkgQtyRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrRtBkgQtyVO.class);
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * 컨테이너에서 사용중인 Tpsz 목록을 가져온다.
     * 
     * @return String
     * @exception DAOException
     */
    public String searchCntrTpsz() throws DAOException {
        DBRowSet dbRowset = null;
        StringBuffer buff = new StringBuffer();
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            SQLExecuter exec = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCntrTpszRSQL template = new BlRatingDBDAOCntrTpszRSQL();
            dbRowset = exec.executeQuery(template, param, velParam);
            while(dbRowset.next()){
                buff.append(dbRowset.getString(1));
                buff.append(',');
            }
        } catch(SQLException ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return buff.toString();
    }
    
    /**
     * B/L별 한국 Wharfage 면제 사유 및 면제 화주 등록 정보 수정
     * 
     * @param BlKrWhfExptVO blKrWhfExptVO
     * @exception DAOException
     */
    public void modifyBlKrWhfExpt ( BlKrWhfExptVO blKrWhfExptVO ) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = blKrWhfExptVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate(
					(ISQLTemplate) new BlRatingDBDAOmodifyBlKrWhfExptUSQL(), param, velParam);
		
		}
		catch (SQLException ex)
		{
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex)
		{
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

    /**
     * update container cargo receiving date.
     * 
     * @param String bkgNo
     * @param String crdDt
     * @param String caFlg
     * @exception DAOException
     */
    public void manageCrdDt(String bkgNo, String crdDt, String caFlg) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cgo_rcv_dt", crdDt);
            mapVO.put("ca_flg", caFlg);
                        
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BlRatingDBDAOCrdDtUSQL template = new BlRatingDBDAOCrdDtUSQL();
            int insCnt = sqlExe.executeUpdate(template, param, velParam);
            if (insCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Wharfage 정보가 존재하는지 대상 조회
     * 
     * @param BkgRateVO bkgRateVO
     * @return BkgRateVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public BkgRateVO searchWhfExptInfo(BkgRateVO bkgRateVO) throws DAOException {
    	BkgRateVO outBkgRateVO = null;
		List<BkgRateVO> listBkgRateVO = null;
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = bkgRateVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOsearchWhfExptInfoRSQL(),param, velParam);
			listBkgRateVO = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRateVO.class);
			if (listBkgRateVO!=null && listBkgRateVO.size() > 0) outBkgRateVO = listBkgRateVO.get(0);
		} 
		catch(SQLException se) 
		{
			//log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		
		return outBkgRateVO;
    }
    
    /**
     * Wharfage Expt 정보 UPDATE
     * 
     * @param BkgRateVO bkgRateVO
     * @throws DAOException
     */
    public void modifyWhfExptInfo(BkgRateVO bkgRateVO) throws DAOException {
    	// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = bkgRateVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate) new BlRatingDBDAOmodifyWhfExptInfoUSQL(),param, velParam);
		}                                                                      
		catch(SQLException se) 
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
    }
    
    /**
     * Wharfage Expt 정보 INSERT
     * 
     * @param BkgRateVO bkgRateVO
     * @throws DAOException
     */
    public void addWhfExptInfo(BkgRateVO bkgRateVO) throws DAOException {
    	// query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	// velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try
    	{
    		Map<String, String> mapVO = bkgRateVO.getColumnValues();
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		new SQLExecuter("").executeUpdate((ISQLTemplate) new BlRatingDBDAOaddWhfExptInfoCSQL(),param, velParam);
    	}                                                                      
    	catch(SQLException se) 
    	{
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} 
    	catch(Exception ex) 
    	{
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}	
    }

    /**
     * modify Frt Term Cd
     * 
     * @author KimYoungchul
     * @param String bkgNo
     * @param String frtTermCd
     * @param String frtTermPrnFlg
     * @param String usrId
     * @param String caFlg 
     * @return int
     * @throws DAOException
     */
    public int modifyFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, String usrId, String caFlg) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int rsCnt = 0;
        try {

            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("frt_term_cd", frtTermCd);
            mapVO.put("frt_term_prn_flg", frtTermPrnFlg);
            mapVO.put("upd_usr_id", usrId);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BlRatingDBDAOFrtTermCdUSQL template = new BlRatingDBDAOFrtTermCdUSQL();
            rsCnt = sqlExe.executeUpdate(template, param, velParam);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsCnt;
    }

    /**
     * add Frt Term Cd
     * 
     * @author KimYoungchul
     * @param bkgNo
     * @param frtTermCd
     * @param frtTermPrnFlg
     * @param usrId
     * @param caFlg
     * @throws DAOException
     */
    public void addFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, String usrId, String caFlg) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int rsCnt = 0;
        try {

            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("frt_term_cd", frtTermCd);
            mapVO.put("frt_term_prn_flg", frtTermPrnFlg);
            mapVO.put("cre_usr_id", usrId);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BlRatingDBDAOFrtTermCdCSQL template = new BlRatingDBDAOFrtTermCdCSQL();
            rsCnt = sqlExe.executeUpdate(template, param, velParam);
            if (rsCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    /**
	 * EsmBkg1076 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * 화주의 S/C 계약을 조회함 -- UI_BKG-1076 BKG 데이터 조회
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO taaInformInVO
	 * @return TaaBkgInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TaaBkgInformVO searchTaaBkgInform(TaaInformInVO taaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<TaaBkgInformVO> list = null;
		TaaBkgInformVO rTaaBkgInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (taaInformInVO != null) {
				Map<String, String> mapVO = taaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchTaaBkgInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TaaBkgInformVO.class);
			if (list != null && list.size() > 0) {
				rTaaBkgInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rTaaBkgInformVO;
	}

	/**
	 * EsmBkg1067 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * 화주의 S/C 계약을 조회함 -- UI_BKG-1067 BKG Customer와 PRI에서 S/C Customer를 조회한다.
	 * 
	 * @author KIM TAE KYOUNG 
	 * @param TaaInformInVO taaInformInVO
	 * @return TaaCustInformVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TaaCustInformVO searchTaaCustInform(TaaInformInVO taaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<TaaCustInformVO> list = null;
		TaaCustInformVO rTaaCustInformVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (taaInformInVO != null) {
				Map<String, String> mapVO = taaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchTaaCustInformRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TaaCustInformVO.class);
			if (list != null && list.size() > 0) {
				rTaaCustInformVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rTaaCustInformVO;
	}

	/**
	 * EsmBkg1067 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO taaInformInVO
	 * @return List<TaaInformListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TaaInformListVO> searchTaaInformList(TaaInformInVO taaInformInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaaInformListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (taaInformInVO != null) {
				Map<String, String> mapVO = taaInformInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchScInformListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScInformListVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EsmBkg1077 조회 이벤트 처리<br>
	 * Rating Application Date 를 조회한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchRatingApplyDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRatingApplyDateVO> searchRatingApplyDateList(String bkgNo, String caFlg)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<SearchRatingApplyDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("ca_flg", caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDDAOSearchRatingApplyDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRatingApplyDateVO.class);
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		return list;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<TpbInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchTpbInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTpbInfoVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchFocByFreightListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFocByFreightListVO> searchFocByFreightList(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ca_flg", caFlg);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchFocByFreightListRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFocByFreightListVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
 
 	 /**
	 * PPD, CLT CNT_CODE UPDATE 를 한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String user_id
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyRateCntCd(String bkgNo,  String user_id,  String caFlg) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;
		
		try {
			param.put("bkg_no", bkgNo);
			param.put("user_id", user_id);
			param.put("ca_flg", caFlg);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("user_id", user_id);
			velParam.put("ca_flg", caFlg);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyRateCntCdUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * callBkgModiIssOfcPrc - 프러시져 호출
	 *
	 * @param BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws DAOException
	 */
	public void callBkgModiIssOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = bkgModiOfcPrcVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("").executeSP((ISQLTemplate)new BlRatingDBDAOCallBkgModiIssOfcPrcUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}

	/**
	 * callBkgModiChgOfcPrc - 프러시져 호출
	 *
	 * @param BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws DAOException
	 */
	public void callBkgModiChgOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = bkgModiOfcPrcVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("").executeSP((ISQLTemplate)new BlRatingDBDAOCallBkgModiChgOfcPrcUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}
	
	/**
	 * O/BL Surrender 처리시 OBS 정보를 조회한다.
	 * ESM_BKG-0400	Bkg System	
	 * @param String bkgNo
	 * @return BkgRateVO bkgRateVO
	 * @exception DAOException
	 */ 
	public BkgRateVO searchBkgRate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgRateVO bkgRateVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchBkgRateRSQL(), param, velParam);
			List<BkgRateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRateVO .class);
			if(list.size() > 0){
				bkgRateVO = list.get(0);
            }
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgRateVO;
	}
	
    /**
     *  Freight & Charge 화면(ESM_BKG_0079_08)화면에서 SC No. or RFA No. or TAA No.
     *  옆 검색 버튼을 누를 때 팝업을 연결하기 위한 필수조건인 Amend Sequend를 조회한다.
     *  
     * @author 		Cho wonjoo
     * @param  		String ctrtType
     * @param  		String ctrtNo
     * @param  		String applicationDate
     * @return 		String
     * @exception 	DAOException
     */
	public String searchAmdtSeq(String ctrtType, String ctrtNo, String applicationDate) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ctrt_type", ctrtType);
			param.put("ctrt_no", ctrtNo);
			param.put("application_date", applicationDate);
			
			velParam.put("ctrt_type", ctrtType);
			velParam.put("ctrt_no", ctrtNo);
			velParam.put("application_date", applicationDate);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchAmdtSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("AMDT_SEQ");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
		
	}
	
	
	/**
	 * OFT Rating 가능여부, 사용자, 날짜를 BKG RATE에 저장한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String oftMssFlg
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void moidfyOftPrecheckResult(String bkgNo, String caFlg, String oftMssFlg, SignOnUserAccount account ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{

			param.put("oft_mss_flg", oftMssFlg);
			param.put("usr_id", account.getUsr_id());
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			velParam.put("oft_mss_flg", oftMssFlg);
			velParam.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOMoidfyOftPrecheckResultUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * CMPB산출을 위해 BKG Creation/Update시 BKG Volume에 해당되는 최저 Revenue만 남기고 나머지 정보는 삭제함
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void modifyChargeRateTempForCMPB(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyChargeRateTempForCMPBDSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			
			// Surcharge Rating을 위해 OFT_CMP_SEQ를 1로 조정한다.
			// OFT_CMB_SEQ가 다수개일 경우 Surcharge Rating 결과도 여러개가 나오게 됨.			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyChargeRateTempCombineSequenceUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
			
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * EsmBkg1090조회 이벤트 처리<br>
	 * DHF Adjustment Location을 조회한다<br>
	 * 
	 * @author JJ Kim
	 * @param String bkgNo
	 * @param String caFlg
	 * @return ChargeAdjustmentVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargeAdjustmentVO searchDHFAdjustment(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeAdjustmentVO> list = null;
		ChargeAdjustmentVO dhfAdj = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchDHFAdjustmentRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeAdjustmentVO.class);
			if (list != null && list.size() > 0) {
				dhfAdj = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dhfAdj;
	}


	/**
	 * EsmBkg1090조회 이벤트 처리<br>
	 * DDC Adjustment Currency를 조회한다<br>
	 * 
	 * @author JJ Kim
	 * @param String bkgNo
	 * @param String caFlg
	 * @return ChargeAdjustmentVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargeAdjustmentVO searchDDCAdjustment(String bkgNo, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeAdjustmentVO> list = null;
		ChargeAdjustmentVO ddcAdj = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchDDCAdjustmentRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeAdjustmentVO.class);
			if (list != null && list.size() > 0) {
				ddcAdj = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ddcAdj;
	}
	
	
	/**
	 * DHF Adjustment Location 저장
	 * 
	 * @param ChargeAdjustmentVO vo
	 * @throws DAOException
	 */
	public void modifyDHFAdjustment(ChargeAdjustmentVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyDHFAdjustmentUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * DDC Adjustment Currency 저장
	 * 
	 * @param ChargeAdjustmentVO vo
	 * @throws DAOException
	 */
	public void modifyDDCAdjustment(ChargeAdjustmentVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyDDCAdjustmentUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Tariff Surcharge 정보를 저장<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param String caFlag
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void addTariffSurchargeRate(List<SearchScOftAutoratingListVO> surList, String caFlag, SignOnUserAccount account) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = surList.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = surList.iterator();
				while (list.hasNext()) {
					SearchScOftAutoratingListVO surVO = (SearchScOftAutoratingListVO) list.next();
					Map<String, String> mapVO = surVO.getColumnValues();
					param.putAll(mapVO);
					param.put("usr_id", account.getUsr_id());
					velParam.put("caFlag",caFlag);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddTariffSurchargeRateCSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * 기존 Tariff Surcharge 정보를 삭제<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param String caFlag
	 * 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void removeTariffSurchargeRate(List<SearchScOftAutoratingListVO> surList, String caFlag) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = surList.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = surList.iterator();
				SearchScOftAutoratingListVO surVO = (SearchScOftAutoratingListVO) list.next();
				Map<String, String> mapVO = surVO.getColumnValues();
				param.putAll(mapVO);
				velParam.put("caFlag",caFlag);
				int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAORemoveTariffSurchargeRateDSQL(), param, velParam);
				if (delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");

			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg2006Event 조회 이벤트 처리<br>
	 * Invoice I/F Temp테이블과 BKG_CHG_RT 테이블을 비교하여 Diff발생한 BKG을 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param InvIfDiffVO  vo
	 * @return List<InvIfDiffVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvIfDiffVO> searchInvoiceInterfaceDifference(InvIfDiffVO vo)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<InvIfDiffVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchInvoiceInterfaceDifferenceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvIfDiffVO.class);
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		return list;
	}
	
	/**
	 *  BKG에 해당되는 Service Scope 목록 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return List<ServiceScopeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceScopeVO> searchServiceScopeList(String bkgNo, String caFlg)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<ServiceScopeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flg", caFlg);
			velParam.put("bkg_no", bkgNo);
			velParam.put("ca_flg", caFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchServiceScopeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ServiceScopeVO.class);
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		return list;
	}
	
	/**
	 *  BKG에 해당되는 Prepaid Amount 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchPpdChgAmt(String bkgNo)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchPpdChgAmtRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("USD_CHG_AMT");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	
	/**
	 *  BKG에 해당되는 SWB, OBL Release 담당자 E-mail  조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchPpdChgRlsEmail(String bkgNo)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchPpdChgRlsEmailRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("USR_EML");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	
	/**
	 *  BKG에 해당되는 E-mail 전송대상 Prepaid 정보조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  usrId
	 * @return List<EmailPpdInfoVO>
	 * @exception DAOException
	 */
	public List<EmailPpdInfoVO> searchPpdChgInfo(String bkgNo, String usrId)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<EmailPpdInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("usr_id", usrId);
			velParam.put("bkg_no", bkgNo);
			velParam.put("usr_id", usrId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchPpdChgInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EmailPpdInfoVO.class);
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		return list;
	}
	
	/**
	 *  BKG에 해당되는 Prepaid Amount 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchPpdChgAmtFlg(String bkgNo)  throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BlRatingDBDAOSearchPpdChgAmtFlgRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("PPD_CHG_AMT_FLG");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	
	/**
	 *  BKG에 해당되는 Retroactive Flag 수정<br>
	 * 
	 * @param String  bkgNo
	 * @param String  rtroKndCd
	 * @param String  caflag
	 * @exception DAOException
	 */
	public void modifyRtroactiveKindCd(String bkgNo, String rtroKndCd, String caflag)  throws DAOException, Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("rtro_knd_cd", rtroKndCd);
			param.put("caflag", caflag);
			velParam.put("bkg_no", bkgNo);
			velParam.put("rtro_knd_cd", rtroKndCd);
			velParam.put("caflag", caflag);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyRtroactiveKindCdUSQL(), param,velParam);		
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	


	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String chgCd
	 * @return List<ChgAmdAuthDtlVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeAmendAuthDetailVO> searchCurrentOftList(String bkgNo, String chgCd) throws DAOException {
		List<ChargeAmendAuthDetailVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("chg_cd", chgCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchCurrentOftListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeAmendAuthDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	


	/**
	 * Approval Request 메일 내용을 조회합니다.<br>
	 * HTML형식으로 조회됨
	 * @param String bkgNo
	 * @param String chgCd
	 * @param String mailType
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String searchApprovalRequestMailBody(String bkgNo, String chgCd, String mailType) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer buff = new StringBuffer();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("chg_cd", chgCd);
			velParam.put("chg_cd", chgCd);
			param.put("mail_type", mailType);
			velParam.put("mail_type", mailType);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchApprovalRequestMailBodyRSQL(), param, velParam);
			
			while (dbRowset.next()){
				if(dbRowset.getString("MAIL_BODY")!=null && dbRowset.getString("MAIL_BODY").length()>1){
					buff.append(dbRowset.getString("MAIL_BODY"));
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return buff.toString();
	}
	
	

	 /**
	  * Charge Amend 승인 요청을 생성
	  * @param ChargeAmendAuthVO vo
	  * @exception DAOException
	  */
	 public void addChargeAmendAuthRequest(ChargeAmendAuthVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddChargeAmendAuthRequestCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	

	/**
	 * Charge Amend 승인 요청을 생성<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<ChargeAmendAuthDetailVO> vo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void addChargeAmendAuthRequestDetail(List<ChargeAmendAuthDetailVO> vo) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = vo.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = vo.iterator();
				while (list.hasNext()) {
					ChargeAmendAuthDetailVO insertVo = (ChargeAmendAuthDetailVO) list.next();
					Map<String, String> mapVO = insertVo.getColumnValues();
					param.putAll(mapVO);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddChargeAmendAuthRequestDetailCSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	

	/**
	 * Charge Amend 승인 요청을 생성<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<ChargeAmendAuthRefUserVO> vo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void addChargeAmendAuthRequestRefUser(List<ChargeAmendAuthRefUserVO> vo) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = vo.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = vo.iterator();
				while (list.hasNext()) {
					ChargeAmendAuthRefUserVO insertVo = (ChargeAmendAuthRefUserVO) list.next();
					Map<String, String> mapVO = insertVo.getColumnValues();
					param.putAll(mapVO);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOAddChargeAmendAuthRequestRefUserCSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * Charge Amend 요청에 대한 Approval/Reject 권한을 가진 사용자인지 조회한다.
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws DAOException
	 */
	public String searchChargeAmendApprovalAuth(SignOnUserAccount account) throws DAOException {
		// booking status code
		String authUsrFlg = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOSearchChargeAmendApprovalAuthRSQL template = new BlRatingDBDAOSearchChargeAmendApprovalAuthRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				authUsrFlg = dbRowset.getString("AUTH_USR_FLG");
			} else {
				authUsrFlg = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return authUsrFlg;
	}


	/**
	 * Charge Amend권한 승인 요청 목록을 조회<br>
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @param SignOnUserAccount account
	 * @return List<ChargeAmendAuthRequestListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeAmendAuthRequestListVO> searchChargeAmendAuthRequestList(ChargeAmendAuthRequestListVO vo, 
			SignOnUserAccount account) throws DAOException {
		List<ChargeAmendAuthRequestListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchChargeAmendAuthRequestListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChargeAmendAuthRequestListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	

	/**
	 * Charge Amend 승인 요청을 생성<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<ChargeAmendAuthRequestListVO> vo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void modifyChargeAmendAuthRequestStatus(List<ChargeAmendAuthRequestListVO> vo) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = vo.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = vo.iterator();
				while (list.hasNext()) {
					ChargeAmendAuthRequestListVO updateVo = (ChargeAmendAuthRequestListVO) list.next();
					Map<String, String> mapVO = updateVo.getColumnValues();
					param.putAll(mapVO);
					int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyChargeAmendAuthRequestStatusUSQL(), param, velParam);
					if (updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Exempt Request 승인받은 Interface된 Charge를 삭제<br>
	 * 
	 * @author JIN JOO KIM
	 * @param ChargeAmendAuthRequestListVO vo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void removeInterfaceCharge(ChargeAmendAuthRequestListVO vo) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAORemoveInterfaceChargeDSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param OrganizationChartVO organizationChartVO
	 * @return List<OrganizationChartVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<OrganizationChartVO> searchOrganizationChart(OrganizationChartVO organizationChartVO) throws DAOException {
		List<OrganizationChartVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (organizationChartVO != null) {
				Map<String, String> mapVO = organizationChartVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchOrganizationChartRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OrganizationChartVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 이전에 산출한 Revenue와  Revenue를 비교한다.
     *  두 값이 다른 경우에만  CMPB INSERT<br>
	 * 
	 * @param BkgRevCostVO revCostVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkRevenueAmountDifference(BkgRevCostVO revCostVO) throws DAOException {
		// booking status code
		String result = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = revCostVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOCheckRevenueAmountDifferenceRSQL template = new BlRatingDBDAOCheckRevenueAmountDifferenceRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RESULT");
			} else {
				result = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * TEMP테이블상 저장된 Revenue Amount를 조회한다.
     * Application Date / 경리 환율 기준으로 USD 환산한 값
	 * 
	 * @param BkgRevCostVO revCostVO
	 * @return BkgRevCostVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgRevCostVO searchRevenueAmount(BkgRevCostVO revCostVO) throws DAOException {
		// booking status code
		List<BkgRevCostVO> list = null; 
		BkgRevCostVO bkgRevCostVO = new BkgRevCostVO();
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = revCostVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOSearchRevenueAmountRSQL template = new BlRatingDBDAOSearchRevenueAmountRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgRevCostVO.class);
			if (list != null && list.size() > 0) {
				bkgRevCostVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgRevCostVO;
	}
	
	/**
	 * Temp테이블에 저장된 Rating 결과, 기존 Manual/Interface Charge 조회
	 * 
	 * @param SignOnUserAccount account
	 * @return List<BkgChgRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChgRateVO> searchRevenueAmountDetail(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChgRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("usr_id", account.getUsr_id());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRevenueAmountDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgChgRateVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	/**
	 * Revenue와 BKG TEU Qty를 Insert한다
	 * 
	 * @param BkgRevCostVO revCostVO
	 * @throws DAOException
	 */
	public void createRevenueAmount(BkgRevCostVO revCostVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = revCostVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCreateRevenueAmountCSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 추가한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param List<BkgChgRateVO> revDtlVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void createRevenueAmountDetail(List<BkgChgRateVO> revDtlVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size = revDtlVOs.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = revDtlVOs.iterator();
				while (list.hasNext()) {
					BkgChgRateVO bkgChgRateVO = (BkgChgRateVO) list.next();
					Map<String, String> mapVO = bkgChgRateVO.getColumnValues();
					param.putAll(mapVO);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOCreateRevenueAmountDetailCSQL(), param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Group & Multi B/L Rating을 위한  목록 조회<br>
	 * 
	 * @param GroupRatingVO vo
	 * @return List<GroupRatingVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<GroupRatingVO> searchGroupRatingList(GroupRatingVO vo) throws DAOException {
		List<GroupRatingVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchGroupRatingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GroupRatingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	

	/**
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 추가한다.<br>
	 * 
	 * @param GroupRatingVO ratinglist
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void modifyGroupRatingList(GroupRatingVO ratinglist) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = ratinglist.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyGroupRatingListUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 조회한 운임으로 Group Rating 가능한 상태인지 확인<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchGroupRatingStatus(String bkgNo) throws DAOException {
		// booking status code
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BlRatingDBDAOSearchGroupRatingStatusRSQL template = new BlRatingDBDAOSearchGroupRatingStatusRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RATE_CNT");
				if(!"1".equals(result)){
					result = "M";  // Multi Rate
				}else{
					result = "";
				}
			} else {
				result = "N";  // No Rate
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * BKG_RATE 업데이트
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @throws DAOException
	 */
	public void modifyBkgRate(RateMainInfoVO rateMainInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = rateMainInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyBkgRateUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Group Rating 상태저장
	 * 성공/실패여부, 실패시 실패사유 저장
	 * 
	 * @param String bkgNo
	 * @param String grpRatRsltCd
	 * @param String grpRatFailRsnCd
	 * @throws DAOException
	 */
	public void modifyGroupRatingStatus(String bkgNo, String grpRatRsltCd, String grpRatFailRsnCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("grp_rat_rslt_cd", grpRatRsltCd);
			param.put("grp_rat_fail_rsn_cd", grpRatFailRsnCd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOModifyGroupRatingStatusUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	/**
	 * Temp테이블에 저장된 Rating 결과, 기존 Manual/Interface Charge 조회
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return List<BkgChgRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChgRateVO> searchGroupRatingCharge(String bkgNo, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChgRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("usr_id", account.getUsr_id());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchGroupRatingChargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgChgRateVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * TPF Interface
	 * Group Rating에서는 I/F여부를 사용자에게 확인받지 않고 무조건 I/F진행.
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageTPFSurcharge(String bkgNo, String caFlg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("ca_flag", caFlg);
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOManageTPFSurchargeCSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


    /**
     * 기존 OFT_MSS_FLG정보와 
     * Rate Check Notice 메일 전송시 필요한 정보를 조회한다.
     * 
     * @param String bkgNo
     * @return RateCheckNoticeVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public RateCheckNoticeVO searchRateCheckNotice(String bkgNo) throws DAOException {
    	RateCheckNoticeVO rateCheckNoticeVO = null;
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BlRatingDBDAOSearchRateCheckNoticeRSQL(),param, velParam);
			List<RateCheckNoticeVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, RateCheckNoticeVO.class);
			if (list!=null && list.size() > 0) rateCheckNoticeVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			//log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		
		return rateCheckNoticeVO;
    }
    
    
	/**
	 * BKG_AUTO_RT_OCN_FRT_TMP 가 생성
	 * @param String bkgNo
     * @throws DAOException
     */
    public void createOcnFrtTmpByChgRt(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BlRatingDBDAOCreateOcnFrtTmpByChgRtCSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    
	/**
	 * @param String bkgNo
	 * @param String ihcFlg
	 * @param String thcFlg
	 * @param String cntCd
	 * @throws DAOException
	 */
	public void modifyAuditForCnt(String bkgNo,  String ihcFlg, String thcFlg, String cntCd) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0 ;
		
		try {
			param.put("bkg_no", bkgNo);
			param.put("ihc_flg", ihcFlg);
			param.put("thc_flg", thcFlg);
			param.put("cnt_cd", cntCd);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("ihc_flg", ihcFlg);
			velParam.put("thc_flg", thcFlg);
			velParam.put("cnt_cd", cntCd);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BlRatingDBDAOModifyAuditForIndiaUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
