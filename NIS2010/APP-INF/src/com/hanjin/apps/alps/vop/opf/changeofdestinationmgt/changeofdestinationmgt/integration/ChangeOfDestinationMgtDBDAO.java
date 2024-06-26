/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAO.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
*=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
* 2011.11.16 김민아 [CHM-201114641-01] COD 데이터 조회시 HJSALPSB에 접속되어 실행되는 부분을 HJSALPSA를 바로보도록 Data Source 명 변경(searchRehandlingList)
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration.TerminalAgreementManageDBDAOSearchRehandlingCostRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeBoxBlVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodOldNewPodVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * ALPS ChangeOfDestinationMgtDBDAO <br>
 * - ALPS-ChangeOfDestinationMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see ChangeOfDestinationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ChangeOfDestinationMgtDBDAO extends DBDAOSupport {

	/**
	 * COD Approval을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CODRequestListVO> searchCODRequestList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CODRequestListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCODRequestListVORSQL(), param, velParam);
			/**[2009-09-18] SQLExecuter("") 절대 수정 불가 **/
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCODRequestListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CODRequestListVO .class);
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
		 * RSO, LANE 별 EMAIL 을 조회 합니다.<br>
		 * 
		 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
		 * @return List<CODRequestInformationVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CODRequestInformationVO> searchCODEmailsendList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CODRequestInformationVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(changeOfDestinationMgtConditionVO != null){
					Map<String, String> mapVO = changeOfDestinationMgtConditionVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCODEmailSendRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CODRequestInformationVO.class);
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
		 * 해당 VVD의 CARRIER CODE 를 조회 합니다.<br>
		 * 
		 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
		 * @return List<CODRequestInformationVO>
		 * @exception EventException
		 */	 
		 @SuppressWarnings("unchecked")
			public List<CODRequestInformationVO> searchCODCarrierCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<CODRequestInformationVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(changeOfDestinationMgtConditionVO != null){
						Map<String, String> mapVO = changeOfDestinationMgtConditionVO.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCarrierCdRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, CODRequestInformationVO.class);
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
			 * 해당 BKG의 NEW,OLD POD CODE 를 조회 합니다..<br>
			 * 
			 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
			 * @return List<CODRequestInformationVO>
			 * @exception EventException
			 */	 
			 @SuppressWarnings("unchecked")
				public List<CODRequestInformationVO> searchCODNewOldPODCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
					DBRowSet dbRowset = null;
					List<CODRequestInformationVO> list = null;
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					try{
						if(changeOfDestinationMgtConditionVO != null){
							Map<String, String> mapVO = changeOfDestinationMgtConditionVO.getColumnValues();
						
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL(), param, velParam);
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, CODRequestInformationVO.class);
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
	 * RSO 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<ScgRgnShpOprCdVO> searchRsoCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORsoComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO .class);
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
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ScgRgnShpOprCdVO> searchOfcRso(SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("usr_id", account.getUsr_id());
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOSearchOfcRsoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO .class);
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
	 * Freight & Charges for COD에 CUR 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<MdmCurrencyVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrCdCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCurrCdComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO .class);
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
	 * COD Condition 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchCodCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCodComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * Auth Result 콤보생성을 조회 합니다.<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchAuthCombo() throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		try{
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOAuthComboRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * COD Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchCodRsnCombo() throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		try{
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCodRsnComboRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * Reject Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodRjctCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfCodRjctCdVO> searchCODRejectCodeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfCodRjctCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORjctComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCodRjctCdVO .class);
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
	 * COD Request Information 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CODRequestInformationVO> searchCODDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CODRequestInformationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOCODRequestInformationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CODRequestInformationVO .class);
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
	 * Approval Information 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ApprovalInformationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ApprovalInformationVO> searchRsoDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApprovalInformationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOApprovalInformationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalInformationVO .class);
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
	 * Freight & Charges for COD 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchRehandlingList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOBkgCodCostVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostVO .class);
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
	 * Row Add 시 CHR, CUR, Rate 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodCostListVO> searchRehandlingQTY(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				//Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
				//param.putAll(mapVO);
				//velParam.putAll(mapVO);
				param.put("bkg_no", changeOfDestinationMgtConditionVO.getBkgNo());
				param.put("cod_rqst_seq", changeOfDestinationMgtConditionVO.getCodRqstSeq());
				param.put("cod_rhnd_port_cd", changeOfDestinationMgtConditionVO.getCodRhndPortCd());
				velParam.put("bkg_no", changeOfDestinationMgtConditionVO.getBkgNo());
				velParam.put("cod_rqst_seq", changeOfDestinationMgtConditionVO.getCodRqstSeq());
				velParam.put("cod_rhnd_port_cd", changeOfDestinationMgtConditionVO.getCodRhndPortCd());
			}
			
			if(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO() != null){
				Map<String, String> mapVO = codRehandlingInfoVO.getCodOldNewRhndPortVvdVO() .getColumnValues();
				
				List<CodCntrVO> codCntrs = codRehandlingInfoVO.getCodCntrVOs();
	            List<String> aryYdSeq = new ArrayList();   
	            for(int i = 0; i <  codCntrs.size() ; i++){   
	                aryYdSeq.add(codCntrs.get(i).getCntrNo() );   
	            }
	            velParam.put("cntr_no", aryYdSeq);  
	            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORehandlingQTYRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostListVO .class);
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
	 * CNTR Q'ty 시 Container List 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodCostListVO> searchRehandlingContainerList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				param.put("bkg_no", changeOfDestinationMgtConditionVO.getBkgNo());
				param.put("cod_rqst_seq", changeOfDestinationMgtConditionVO.getCodRqstSeq());
				param.put("cod_rhnd_port_cd", changeOfDestinationMgtConditionVO.getCodRhndPortCd());
				
				param.put("tpsz", changeOfDestinationMgtConditionVO.getTpsz());
				param.put("cntr_cgo_tp_cd", changeOfDestinationMgtConditionVO.getCntrCgoTpCd());
				param.put("cgo_cate_cd", changeOfDestinationMgtConditionVO.getCgoCateCd());
				
				velParam.put("bkg_no", changeOfDestinationMgtConditionVO.getBkgNo());
				velParam.put("cod_rqst_seq", changeOfDestinationMgtConditionVO.getCodRqstSeq());
				velParam.put("cod_rhnd_port_cd", changeOfDestinationMgtConditionVO.getCodRhndPortCd());
				
				velParam.put("tpsz", changeOfDestinationMgtConditionVO.getTpsz());
				velParam.put("cntr_cgo_tp_cd", changeOfDestinationMgtConditionVO.getCntrCgoTpCd());				
				velParam.put("cgo_cate_cd", changeOfDestinationMgtConditionVO.getCgoCateCd());
			}
			
			if(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO() != null){
				Map<String, String> mapVO = codRehandlingInfoVO.getCodOldNewRhndPortVvdVO() .getColumnValues();
				
				List<CodCntrVO> codCntrs = codRehandlingInfoVO.getCodCntrVOs();
	            List<String> aryYdSeq = new ArrayList();   
	            for(int i = 0; i <  codCntrs.size() ; i++){   
	                aryYdSeq.add(codCntrs.get(i).getCntrNo() );   
	            }
	            velParam.put("cntr_no", aryYdSeq);  
	            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORehandlingContainerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostListVO .class);
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
	 * CNTR Type/SIZE시 유효성 체크를 합니다.<br>
	 * 
	 * @param changeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchRatUtCdCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORatUtCdCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostVO .class);
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
	 * CHR, CUR, Rate 을 조회 합니다.<br>
	 * 
	 * @param changeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param String strCurrCd
	 * @param String strRate
	 * @return List<BkgCodCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchRehandlingRate(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, String strCurrCd, String strRate) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCodCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("curr_cd", strCurrCd);
			param.put("rate", strRate);
			velParam.put("curr_cd", strCurrCd);
			velParam.put("rate", strRate);

			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORehandlingRateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCodCostVO .class);
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
	 * Bay Plan 을 조회 합니다.<br>
	 * 
	 * @param changeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ChangeOfDestinationMgtConditionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChangeOfDestinationMgtConditionVO> searchBayPlanCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChangeOfDestinationMgtConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOBayPlanCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChangeOfDestinationMgtConditionVO .class);
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
	 * Region COD MIN. Tariff 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfCodDvsFeeVO> searchDiversionList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfCodDvsFeeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCodDvsFeeVO .class);
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
	 * Region COD MIN. Tariff View 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeViewVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfCodDvsFeeViewVO> searchDiversionViewList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfCodDvsFeeViewVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCodDvsFeeViewVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
//	/**
//	 * Region COD MIN. Tariff 을 저장 합니다.<br>
//	 * 
//	 * @param OpfCodDvsFeeVO vo
//	 * @throws DAOException
//	 */
//	public void addsearchDiversionList(OpfCodDvsFeeVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVOCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * Region COD MIN. Tariff 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param OpfCodDvsFeeVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifysearchDiversionList(OpfCodDvsFeeVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
//	/**
//	 * Region COD MIN. Tariff 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param OpfCodDvsFeeVO vo
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int removesearchDiversionList(OpfCodDvsFeeVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
 
	/**
	 * SHA Tide Information Creation 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<OpfCodDvsFeeVO> updModels
	 * @throws DAOException
	 */
	public void modifysearchDiversionListS(List<OpfCodDvsFeeVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OpfCodDvsFeeBoxBl 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeBoxBlVO>
	 * @throws DAOException
	 */
	public List<OpfCodDvsFeeBoxBlVO> searchCodDiversionFeeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<OpfCodDvsFeeBoxBlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodDvsFeeBoxBlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCodDvsFeeBoxBlVO .class);
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
	 * Old POD ETA & New POD ETA & CNTR TP/SZ & QTY조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodOldNewPodVO>
	 * @throws DAOException
	 */
	public List<OpfCodOldNewPodVO> searchOldNewPodCntr(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<OpfCodOldNewPodVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeOfDestinationMgtConditionVO != null){
				Map<String, String> mapVO = changeOfDestinationMgtConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAOOpfCodOldNewPodVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfCodOldNewPodVO .class);
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
	 * 요청된 Port에서 Re-handling될 화물의 Cost를 산출한다.<br>
	 * 
	 * @param  BkgCodCostListVO bkgCodCostListVO
	 * @return List<BkgCodCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchRehandlingCost(BkgCodCostListVO bkgCodCostListVO) throws DAOException {

		List<BkgCodCostVO>	list			= null;
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= bkgCodCostListVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChangeOfDestinationMgtDBDAORehandlingInformationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs( dbRowset, BkgCodCostVO .class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return list;
	}

 
}