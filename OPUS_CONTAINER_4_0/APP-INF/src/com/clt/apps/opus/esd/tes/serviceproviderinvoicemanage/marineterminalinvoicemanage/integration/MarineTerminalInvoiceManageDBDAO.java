/***********************************************************
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName	: MarineTerminalInvoiceManageDBDAO.java
 * @FileTitle	: Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
 * Open Issues	:
 * Change history	:
 * @LastModifyDate	: 2007-02-20
 * @LastModifier	: kimjinjoo
 * @LastVersion	: 1.0
 * 2007-02-20	kimjinjoo
 * 1.0 최초 생성
 * 2009-02-05	: 조직개편 (동서남아지역본부)으로 인한 MDM_ORGANIZATION에 등록된 RHQ OFC로 표시.
 * 2009-03-11 [R200903110001]	: 조회조건중 값이 없는 경우 조건 제외 현상 방지 추가
 * 2009-05-08 [R200905060012]	: TPB I/F SVXXJO COST CODE 누락건 방지
 * 2009-05-26 [R200905260001]	: [TES] 자동계산 logic 수정 
 * 2009-06-22 : [N200906220001] TES 소급처리용 invoice 기능 추가 및 LEA 처리 로직 추가  
 * ===================================================================
 * @LastModifyDate : 2009-08-25
 * @LastModifier   : park chae heung 
 * 
 *  	
 * =========================================================
 ***********************************************************/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchBkgCntrTPCDListRSQL;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic.MarineTerminalInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes1003Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9232Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9300Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.clt.apps.opus.esd.tes.tescommon.util.TESCommonUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesMgstFuelChgVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoAccmYdVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * ESD에 대한 DB 처리를 담당<br>
 * ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author parkyeonjin
 * @see MarineTerminalInvoiceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class MarineTerminalInvoiceManageDBDAO extends DBDAOSupport {


	/**
	 * MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceBasicInfo(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchTerminalInvoiceBasicInfo  Start........ =================\n");		
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceBasicInfoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
		
	}


	 /**
	 * checkTerminalInvoiceStatus 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO 
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkTerminalInvoiceStatus(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		
		boolean flag = false;
		DBRowSet dbRowset = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTermainalInvoiceManageDBDAOCheckTerminalInvoiceStatusRSQL(), param, velParam);

			while (dbRowset.next()){
				if((dbRowset.getString(1).equals("C") ||dbRowset.getString(1).equals("R")) && (!dbRowset.getString(2).equals("RJ"))){
					flag = true;
				}
			}
			
		} catch (SQLException se) {
			log.debug("##################### dao checkTerminalInvoiceStatus ============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return flag;
	
	}


	/**
	 * searchTerminalInvoiceVVD 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO 
	 * @return DBRowSet
	 * @throws DAOException
	 */
				
	public DBRowSet searchTerminalInvoiceVVD(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchTerminalInvoiceVVD  Start........ =================\n");
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
log.debug("param inv_no:"+param.get("inv_no"));
log.debug("vndr_seq:"+param.get("vndr_seq"));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	
	}


	/**
	 * createTerminalInvoiceBasicInfo 데이타 모델을 DB에 저장한다.<br>
	 * @param tesTmlSoHdrVO TesTmlSoHdrVO
	 * @param userId  String
	 * @param ofc_cd  String
	 * @throws DAOException
	 * @return int
	 */
	public int createTerminalInvoiceBasicInfo(TesTmlSoHdrVO tesTmlSoHdrVO, String userId, String ofc_cd) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  createTerminalInvoiceBasicInfo  Start........ =================\n");
		
		int resultCnt = 0;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getInvOfcCd().substring(0, 3));
				param.put("cre_usr_id", userId);
				param.put("ofc_cd", ofc_cd);
			}
			
			resultCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceBasicInfoCSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return resultCnt;			

	}

	/**
	 * modifyTerminalInvoice 수정 된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param event EsdTes0001Event 
	 * @param userId  String
	 * @param ofc_cd  String
	 * @throws DAOException
	 */
	public void modifyTerminalInvoice(EsdTes0001Event event,  String userId, String ofc_cd) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//추석 연휴 전 수정부분 - Invoice Confirm시 화면에서 tml_inv_sts_cd값을 바꿔주지 않더라도 'C'값을 갖도록 수정
				if(Integer.parseInt(event.getTesCommonVo().getFCmd())==141){
					param.put("tml_inv_sts_cd", "C");
				}
				
				param.put("upd_usr_id", userId);
				param.put("ofc_cd", ofc_cd);
				
			}
			
			if(Integer.parseInt(event.getTesCommonVo().getFCmd())==141){
				modifyCntrListForTerminalInvoiceConfirm(event, userId, ofc_cd);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyTerminalInvoiceUSQL(), param, velParam);

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

	}



	/**
	 * MarineTerminalInvoiceManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Reject Lift함
	 * 
	 * @param  event EsdTes0001Event 
	 * @throws DAOException
	 */
	public void rejectLiftTerminalInvoice(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    rejectLiftTerminalInvoice() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORejectLiftTerminalInvoiceUSQL(), param, velParam);

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

	}


	/**
	 * MarineTerminalInvoiceManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * TES_TML_SO_HDR데이타를 update하는 메서드.
	 * 
	 * @param  event EsdTes0001Event 
	 * @throws DAOException
	 */
	public void modifyN3rdPartyAmount(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    modifyN3rdPartyAmount() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesN3rdPtyIfVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyN3rdPartyAmountUSQL(), param, velParam);

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
	}


	/**
	 * MarineTerminalInvoiceManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * TES_TML_SO_DTL 데이타를 update하는 메서드
	 * 
	 * @param  event EsdTes0001Event
	 * @throws DAOException
	 */
	public void modifyTmlSoDtlAmount(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    modifyTmlSoDtlAmount() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesN3rdPtyIfVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyTmlSoDtlAmountUSQL(), param, velParam);

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
	}


	/**
	 * Reject Lift기능구현.<br>
	 *
	 * @param tesTmlSoHdrVO  TesTmlSoHdrVO 
	 * @param userId
	 * @param ofc_cd
	 * @throws DAOException
	 */
	public void removeTerminalInvoice(TesTmlSoHdrVO tesTmlSoHdrVO, String userId, String ofc_cd) throws DAOException {
		log.debug("\n\n================= start marineterminalinvoicemanageDBDAO  RemoveTerminalInvoice  ================\n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				
				param.put("upd_usr_id", userId);
				param.put("ofc_cd", ofc_cd);
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq());

				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTermainalInvoiceManageDBDAORemoveTerminalInvoiceUSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
	}


	/** searchTerminalInvoiceATBDtTrunk
	 * 
	 * @param event EsdTes0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceATBDtTrunk(EsdTes0001Event event) throws DAOException {
		log.debug("\n\n================= marineterminalinvoicemanageDBDAO  searchTerminalInvoiceATBDtTrunk  ================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
	
	/** MarineTerminalInvoiceManage의 AtbDt와 VVD type을 조회한다.<br>
	 *
	 * @param ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 *
	 * LST_ATB_DT값을 ACT_BRTH_DT로 바꾸지 말것!!!!!!!!
	 * VSK_VSL_PORT_SKD 테이블에서 LST_ATB_DT 값을 ATB값으로 제공하게 되어있다.(LST_ATB_DT가 없는경우 VPS_ETB_DT 사용)
	 *
	 * ACT_BRTH_DT 값도 테이블에 있지만 LST_ATB_DT(Last Estimated ATB Date)값을 ATB로 제공하는 이유...
	 * Trunk의 경우 Actual ATB를 유저가 직접 입력하게되어 있지만, 실질적으로 잘 관리되지 못하는 상태기 때문에
	 * 시스템이 예측한 가장 근접한 ATB Date를 사용하기로 함
	 *
	 * 참고적으로, Feeder의 경우 ATB 가없고, Trunk에만 ATB가 있다.
	 * 그렇기 때문에 Trunk/Feeder를 모두 통합 관리하기 위해 Estimated 값을 사용한다.
	 *
	 */
	public DBRowSet searchTerminalInvoiceATBDtCntc(String ofc_cd) throws DAOException {
		log.debug("========== start dao searchTerminalInvoiceATBDtCntc=============== ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("ofc_cd", ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtCNTCRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	
		
	}
	
	/** searchTerminalInvoiceAgmtCost
	 * 
	 * @param tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String searchTerminalInvoiceAgmtCost(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String agmtCostYN = "N";
		String agmtCost = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAgmtCostRSQL(), param, velParam);
			
			if(dbRowset!= null && dbRowset.next()){
				agmtCost = dbRowset.getString("COST_CD_FTR_RMK");
			}
			
			if(agmtCost!=null && !"".equals(agmtCost)){
				agmtCostYN = "Y";
			}
			
		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		
		
		return agmtCostYN;
	}
	

	/** searchTerminalInvoiceTotalAmount 총금액을 가져온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceTotalAmount(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountRSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		
		
		return dbRowset;
	}


	/** searchTerminalInvoiceTotalAmountForPopup 총금액 팝업창에서 사용함<br>
	 *
	 * @param  tesTmlSoDtlVO TesTmlSoDtlVO 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceTotalAmountForPopup(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		log.debug("================ start searchTerminalInvoiceTotalAmountForPopup ==================================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceTotalAmountForPopupRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;			

	}




	/**
	 * MarineTerminalInvoiceManage의 VVD정보를 DB에 저장한다.<br>
	 *
	 * @param tesTmlSoHdrVO TesTmlSoHdrVO
	 * @param tesTmlSoCntrListVO
	 * @param tesCommonVO
	 * @param userId
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceVVD(TesTmlSoHdrVO tesTmlSoHdrVO, TesTmlSoCntrListVO tesTmlSoCntrListVO, TesCommonVO tesCommonVO ,String userId) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    multiTerminalInvoiceVVD() ============");
	
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("userId", userId);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceVVDCSQL(), param, velParam);

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
		
	}


	/** removeTerminalInvoiceContainerList 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param  event EsdTes0001Event 
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceContainerList(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceContainerList() ============");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceContainerListDSQL(), param, velParam);

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

	}



	/** removeTerminalInvoiceVVDList 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param  event EsdTes0001Event 
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceVVDList(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceVVDList() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			

			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceVVDListDSQL(), param, velParam);

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
		
	}


	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param EsdTes0001Event event
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceRvisList(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceRvisList() ============");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("vsl_cd", event.getTesCommonVo().getVvd().substring(0, 4));
				param.put("skd_voy_no", event.getTesCommonVo().getVvd().substring(4, 8));
				param.put("skd_dir_cd", event.getTesCommonVo().getVvd().substring(8, 9));				
			}
			
			if(event.getMarineTerminalInvoiceCommonVO()!= null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceRvisListDSQL(), param, velParam);

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
	
	}



	/** removeTerminalInvoiceRvisList 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param voList List<TesTmlSoDtlVO> 
	 * @param delete_mode  String
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceRvisList(List<TesTmlSoDtlVO> voList, String delete_mode) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceRvisList() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try {
			velParam.put("delete_mode", delete_mode);

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceRvisListArrDSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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

	}


	/** removeTerminalInvoiceN3RDList 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param  event EsdTes0001Event 
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceN3RDList(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceN3RDList() ============");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("vsl_cd", event.getTesCommonVo().getVvd().substring(0, 4));
				param.put("skd_voy_no", event.getTesCommonVo().getVvd().substring(4, 8));
				param.put("skd_dir_cd", event.getTesCommonVo().getVvd().substring(8, 9));
			}
			
			if(event.getMarineTerminalInvoiceCommonVO()!= null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL(), param, velParam);

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

	}


	/** removeTerminalInvoiceN3RDList 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param List<TesTmlSoDtlVO> voList
	 * @param String delete_mode
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceN3RDList(List<TesTmlSoDtlVO> voList, String delete_mode) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceN3RDList() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListArrDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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

	}


	/** removeTerminalInvoiceCostCalculation 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param EsdTes0001Event event
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceCostCalculation(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceCostCalculation() ============");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("vsl_cd", event.getTesCommonVo().getVvd().substring(0, 4));
				param.put("skd_voy_no", event.getTesCommonVo().getVvd().substring(4, 8));
				param.put("skd_dir_cd", event.getTesCommonVo().getVvd().substring(8, 9));
			}
			
			if(event.getMarineTerminalInvoiceCommonVO()!= null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceCostCalculationDSQL(), param, velParam);

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
	
	}



	/** removeTerminalInvoiceCostCalculation 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param List<TesTmlSoDtlVO> voList
	 * @param String delete_mode
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceCostCalculation(List<TesTmlSoDtlVO> voList, String delete_mode) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    removeTerminalInvoiceCostCalculation() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try {
			velParam.put("delete_mode", delete_mode);

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceCostCalculationArrDSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
		
	}

	/** multiTerminalInvoiceContainerListInsert
	 * 
	 * @param voList
	 * @param String ioBndCd
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceContainerListInsert(List<TesTmlSoCntrListVO> voList, String ioBndCd) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    createTerminalInvoiceContainerList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("io_bnd_cd_df", ioBndCd);
		
		try {
//log.debug("dao createTerminalInvoiceContainerList voList.size()============>"+voList.size());

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListInsertCSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiTerminalInvoiceContainerListDelete
	 * 
	 * @param List<TesTmlSoCntrListVO> voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceContainerListDelete(List<TesTmlSoCntrListVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    createTerminalInvoiceContainerList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
//log.debug("dao createTerminalInvoiceContainerList voList.size()============>"+voList.size());

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	

	/** multiTerminalInvoiceContainerListUpdate
	 * 
	 * @param  voList List<TesTmlSoCntrListVO>
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceContainerListUpdate(List<TesTmlSoCntrListVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    createTerminalInvoiceContainerList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
//log.debug("dao createTerminalInvoiceContainerList voList.size()============>"+voList.size());

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	

//	/**
//	 * verify전 CNTR목록 삭제하기
//	 * 
//	 * @param  event EsdTes9010Event
//	 * @throws DAOException
//	 */
//	public void deleteTerminalInvoiceContainerList(EsdTes9010Event event) throws DAOException {
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO  deleteTerminalInvoiceContainerList() ============");
//
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//		
//		try {
//			if(event.getTesTmlSoCntrListVO() != null){
//				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAODeleteTerminalInvoiceContainerListDSQL(), param, velParam);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		
//	}

	
	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param   voList
	 * @see 	EsdTes0001Event
	 * @throws  DAOException
	 */
	public void createTerminalInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    createTerminalInvoiceContainerList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
//log.debug("dao createTerminalInvoiceContainerList voList.size()============>"+voList.size());

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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

	}

	/** createTerminalInvoiceContainerListSeq
	 * 
	 * @param tesTmlSoCntrListVO
	 * @return int
	 * @throws DAOException
	 */
	public int createTerminalInvoiceContainerListSeq(TesTmlSoCntrListVO tesTmlSoCntrListVO) throws DAOException {
		log.debug("start createTerminalInvoiceContainerListSeq ");
		
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListSeqRSQL(), param, velParam);

			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;	
		
	}
	
	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param voList
	 * @param lgsCostCd
	 * @see EsdTes0001Event
	 * @throws DAOException 
	 */
	public void updateContainerListRvisFlg(List<TesTmlSoCntrListVO> voList, String lgsCostCd) throws DAOException {
		log.debug("\n==========MarineTerminalInvoiceManageDAO    updateContainerListRvisFlg() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//log.debug("\n[][updateContainerListRvisFlg][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> lgs_cost_cd==========>"+velParam.get("lgs_cost_cd"));

		try {
			velParam.put("lgs_cost_cd", lgsCostCd.substring(0, 2));
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOUpdateContainerListRvisFlgUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}

	
	/** multiTerminalInvoiceDBVerify
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceDBVerify(List<TesTmlSoCntrListVO> voList) throws DAOException {
		log.debug("\n==========MarineTerminalInvoiceManageDAO    multiTerminalInvoiceDBVerify() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDBVerifyUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiTerminalInvoiceDBVerify2
	 * 
	 * @param List<TesTmlSoCntrListVO> voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceDBVerify2(List<TesTmlSoCntrListVO> voList) throws DAOException {
		log.debug("\n==========MarineTerminalInvoiceManageDAO    multiTerminalInvoiceDBVerify2() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDBVerify2USQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param TesTmlSoDtlVO tesTmlSoDtlVO
	 * @see EsdTes0001Event
	 * @throws DAOException
	 */
	public void updateMarineTerminalRvisVol(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    updateMarineTerminalRvisVol() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOUpdateMarineTerminalRvisVolUSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		
		
	}

	/**
	 *  TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *  
	 * @param  tesTmlSoDtlVO
	 * @throws DAOException
	 */
	public void updateMarineTerminalRehandlingVolume(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		log.debug("\n==========MarineTerminalInvoiceManageDAO    updateMarineTerminalRehandlingVolume() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOUpdateMarineTerminalRehandlingVolumeUSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	
	}

	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  tesTmlSoDtlVO TesTmlSoDtlVO
	 * @param  tesCommonVo	TesCommonVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceCalculationList (TesTmlSoDtlVO tesTmlSoDtlVO, TesCommonVO tesCommonVo) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    searchTerminalInvoiceCalculationList() ============");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVo != null){
				Map<String, String> mapVO = tesCommonVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceCalculationListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		

	}


	/** calculateTerminalInvoiceCost 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  EsdTes0001Event event
	 * @param  String agmtCostYN
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet calculateTerminalInvoiceCost(EsdTes0001Event event, String agmtCostYN) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    calculateTerminalInvoiceCost() ============");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoAccmVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoAccmVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			velParam.put("agmt_cost_yn", agmtCostYN);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCalculateTerminalInvoiceCostRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset ;
		
	}
	
	/** multiRehandlingVolumeInsert
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiRehandlingVolumeInsert(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiRehandlingVolumeInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiRehandlingVolumeUpdate
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiRehandlingVolumeUpdate(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiRehandlingVolumeUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	
	/** multiRehandlingVolumeDelete
	 * 
	 * @param voList List<TesTmlSoRvisListVO>
	 * @throws DAOException
	 */
	public void multiRehandlingVolumeDelete(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiRehandlingVolumeDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	


	/** MANUAL RVIS 등록시
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceDetailInsert(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDetailInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	
	/** MANUAL RVIS 업데이트시
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceDetailUpdate(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDetailUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}

	/** multiTerminalInvoiceDetailDelete
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceDetailDelete(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDetailDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiTerminalInvoiceDetailSearchCount
	 * 
	 * @param tesTmlSoDtlVO
	 * @return int
	 * @throws DAOException
	 */
	public int multiTerminalInvoiceDetailSearchCount(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    multiTerminalInvoiceDetailSearchCount() ============ ");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int tpbCnt = 0;
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceDetailSearchCountRSQL(), param, velParam);
			dbRowset.next();
			tpbCnt = dbRowset.getInt("CNT");
			
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
		return tpbCnt;
	}
	
	/** dBCheckTerminalInvoice
	 * 
	 * @param tesTmlSoHdrVO
	 * @param tesTmlSoCntrListVO
	 * @param tesCommonVO 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet dBCheckTerminalInvoice(TesTmlSoHdrVO tesTmlSoHdrVO,  TesTmlSoCntrListVO tesTmlSoCntrListVO, TesCommonVO tesCommonVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    dBCheckTerminalInvoice() ============ ");
	
		DBRowSet dbRowset = new DBRowSet();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		  
		try {
			
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAODBCheckTerminalInvoiceRSQL(), param, velParam);
			
		} 
//		catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}	
	
	/** searchMgsetCount
	 * 
	 * @param tesTmlSoDtlVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchMgsetCount(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchMgsetCount() ============ ");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int mgSetCnt = 0;
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchMgsetCountRSQL(), param, velParam);
			dbRowset.next();
			mgSetCnt = dbRowset.getInt("CNT");
			
			if(mgSetCnt<1){
//				throw new DAOException("please enter MGSET.");
				throw new DAOException(new ErrorHandler("TES00092", new String[]{""}).getMessage());
			}
			
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
		return mgSetCnt;
	}	
	
	/** searchDtlMgsetCount
	 * 
	 * @param tesTmlSoDtlVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDtlMgsetCount(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchDtlMgsetCount() ============ ");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		  
		try {
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchDtlMgsetCountRSQL(), param, velParam);
			
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
		return dbRowset;
	}
	

	/**multiTerminalInvoiceRvisSeq
	 * 
	 * @param tesTmlSoDtlVO
	 * @return int
	 * @throws DAOException
	 */
	public int multiTerminalInvoiceRvisSeq(TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		DBRowSet dbRowset = new DBRowSet();
		int maxSeq = 0;

		try {
			
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisSeqRSQL(), param, velParam);
			
			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;			
		
	}
	
	/** multiTerminalInvoiceRvisInsert
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceRvisInsert(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisInsertCSQL (), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiTerminalInvoiceRvisUpdate
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceRvisUpdate(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	
	/** multiTerminalInvoiceRvisDelete
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceRvisDelete(List<TesTmlSoRvisListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}		
	
	/** MultiTerminalInvoiceCommonSeq
	 * @param colName
	 * @param tabName
	 * @param whereColumn1
	 * @param whereColumn2
	 * @param whereColumn1Value
	 * @param whereColumn2Value
	 * @return int
	 * @throws DAOException
	 */
	public int multiTerminalInvoiceCommonSeq(String colName, String tabName, String whereColumn1, String whereColumn2, String whereColumn1Value, String whereColumn2Value) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		DBRowSet dbRowset = new DBRowSet();
		int maxSeq = 0;
		
		velParam.put("colName", colName);
		velParam.put("tabName", tabName);
		velParam.put("whereColumn1", whereColumn1);
		velParam.put("whereColumn2", whereColumn2);
		velParam.put("whereColumn1Value", whereColumn1Value);
		velParam.put("whereColumn2Value", whereColumn2Value);
		
		param.put("whereColumn1Value", whereColumn1Value);
		param.put("whereColumn2Value", whereColumn2Value);


		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceCommonSeqRSQL(), param, velParam);
			
			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;			
		
	}
	
	/** multiTerminalInvoiceN3rdParyIFUpdate
	 * 
	 * @param voList List<TesN3rdPtyIfVO>
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFUpdate(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	
	
	/** multiTerminalInvoiceN3rdParyIFDelete
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFDelete(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		
		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	
	/** multiTerminalInvoiceN3rdParyIFDeleteTpb
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFDeleteTpb(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		
		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFDeleteTpbDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}	
	
	/** multiTerminalInvoiceN3rdParyIFFlgUpdate
	 * 
	 * @param 	voList List<TesTmlSoDtlVO>
	 * @throws 	DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFFlgUpdate(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFFlgUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}		
	
	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  voList List<TesN3rdPtyIfVO>
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIF(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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

	}



	/**
	 * MarineTerminalInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param voList List<TesFileImpTmpVO>
	 * @throws DAOException
	 */
	public void createTES_FILE_IMP_TMP(List<TesFileImpTmpVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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

	}
	
	/** createTES_FILE_IMP_TMP_getSeq 
	 *  max seq값을 가져온다
	 *  
	 * @param event EsdTes9010Event
	 * @return int
	 * @throws DAOException
	 */
	public int createTES_FILE_IMP_TMP_getSeq(EsdTes9010Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		int rtnVal = 0;
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMP_getSeqRSQL(), param, velParam);

			if(dbRowset.next()){
				rtnVal = dbRowset.getInt("SEQ");
			}
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * MarineTerminalInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * @param  event EsdTes0001Event
	 * @throws DAOException
	 */
	public void createTES_FILE_IMP_TMPforReverify(EsdTes0001Event event) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cre_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPforReverifyCSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}

	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 *
	 * @param  event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchContainerListByWorkOrder(EsdTes9010Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchContainerListByWorkOrder() ============ ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchContainerListByWorkOrderRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
	}

	/**
	 * MarineTerminalInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * @param tesTmlSoCntrListVO TesTmlSoCntrListVO
	 * @throws DAOException
	 */
	public void removeTES_FILE_IMP_TMP(TesTmlSoCntrListVO tesTmlSoCntrListVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAORemoveTES_FILE_IMP_TMPDSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}




	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event  EsdTes9010Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyTerminalInvoiceContainerListCNTC(EsdTes9010Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    verifyTerminalInvoiceContainerListCNTC() ============ ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoCntrListVO() != null){//io_bnd_cd
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getFmTp().length()==1){
				param.put("fm_tp_length", "1");
			}else{
				param.put("fm_tp_length", "0");
			}
				
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getTsTp().length()==1){
				param.put("ts_tp_length", "1");
			}else{
				param.put("ts_tp_length", "0");
			}
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListCNTCRSQL(), param, velParam);

			
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
		return dbRowset;	
	}		


	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes9010Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyTerminalInvoiceContainerList(EsdTes9010Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    verifyTerminalInvoiceContainerList() ============ ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoCntrListVO() != null){//io_bnd_cd
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getFmTp().length()==1){
				param.put("fm_tp_length", "1");
			}else{
				param.put("fm_tp_length", "0");
			}
				
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getTsTp().length()==1){
				param.put("ts_tp_length", "1");
			}else{
				param.put("ts_tp_length", "0");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOVerifyTerminalInvoiceContainerListTrunkRSQL(), param, velParam);				
	
			
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
		return dbRowset;		

	}



	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet reVerifyTerminalInvoiceContainerList(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    reVerifyTerminalInvoiceContainerList() ============ ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOReVerifyTerminalInvoiceContainerListRSQL(), param, velParam);				
	
			
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
		return dbRowset;				
		
	}


	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes9010Event 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCNTRNumber(EsdTes9010Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchCNTRNumber() ============ ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchCNTRNumberRSQL(), param, velParam);

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
		return dbRowset;		
	
	}


	/**
	 * MarineTerminalInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * @param  voList List<TesFileImpTmpVO>
	 * @throws DAOException
	 */
	public void updateCNTRNumber(List<TesFileImpTmpVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    updateCNTRNumber() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOUpdateCNTRNumberUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	
	}


	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTES_FILE_IMP_TMP(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchTES_FILE_IMP_TMP() ============ ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL(), param, velParam);

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
		return dbRowset;		

	}

	
	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param tesTmlSoCntrListVO
	 * @param tesCommonVO
	 * @param vrfyResult
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceContainerList(TesTmlSoCntrListVO tesTmlSoCntrListVO, TesCommonVO tesCommonVO, String vrfyResult) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    searchTerminalInvoiceContainerList() ============");
		//if(log.isDebugEnabled())log.debug("==========MarineTerminalInvoiceManageDBDAO    searchTerminalContainerList()  model ============"+model);

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("vrfy_rslt_ind_cd", vrfyResult);
				velParam.put("vrfyResult", vrfyResult);
						
log.debug("tml_so_ofc_cty_cd===================>"+param.get("tml_so_ofc_cty_cd"));				
log.debug("tml_so_seq===================>"+param.get("tml_so_seq"));
log.debug("vsl_cd===================>"+param.get("vsl_cd"));
log.debug("vvd===================>"+param.get("vvd"));
log.debug("vrfy_rslt_ind_cd===================>"+param.get("vrfy_rslt_ind_cd"));
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceContainerListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
	}



	/** MarineTerminalInvoiceManage의 VVD가 정상적으로 저장되었는지 확인한다.<br>
	 *
	 * @param  event 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkMissingVVD(EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    checkMissingVVD() ============");	
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event.getTesTmlSoVvdListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoVvdListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			//ofc_cd 추가해야함
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCheckMissingVVDRSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		

	}



	/** MarineTerminalInvoiceManage의 COMListOnlyContainerList를 조회한다.<br>
	 *
	 * @param  event EsdTes9010Event 파라메터
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCOMListOnlyListCNTC(EsdTes9010Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getFmTp().length()==1){
				param.put("fm_tp_length", "1");
			}else{
				param.put("fm_tp_length", "0");
			}
			
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getTsTp().length()==1){
				param.put("ts_tp_length", "1");
			}else{
				param.put("ts_tp_length", "0");
			}
			
			//ofc_cd 추가해야함
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListCNTCRSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}	

	/** MarineTerminalInvoiceManage의 COMListOnlyContainerList를 조회한다.<br>
	 *
	 * @param  event EsdTes9010Event 파라메터
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCOMListOnlyList(EsdTes9010Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getFmTp().length()==1){
				velParam.put("fm_tp_length", "1");
			}else{
				velParam.put("fm_tp_length", "0");
			}
			
			if(event.getMarineTerminalInvoiceCommonVO().getAllTp().equals("N") && event.getMarineTerminalInvoiceCommonVO().getTsTp().length()==1){
				velParam.put("ts_tp_length", "1");
			}else{
				velParam.put("ts_tp_length", "0");
			}
			
			//ofc_cd 추가해야함

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListTrunkRSQL(), param, velParam);	

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}

	/** MarineTerminalInvoiceManage의 AccumulatedVolume를 조회한다.<br>
	 *
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO
	 * @param  tesCommonVO TesCommonVO
	 * @param  ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAccumulatedVolume(TesTmlSoHdrVO tesTmlSoHdrVO, TesCommonVO tesCommonVO, String ofc_cd) throws DAOException {
		log.debug("==================== start searchAccumulatedVolume ==========================");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("ofc_cd", ofc_cd);
			
			//ofc_cd 추가해야함
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}


//	/** MarineTerminalInvoiceManage의 AccumulatedVolume를 조회한다.<br>
//	 *
//	 * @param  event EsdTes0001Event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchOtherCarrierAccountCode(EsdTes0001Event event) throws DAOException {
//		log.debug("==================== start searchOtherCarrierAccountCode ==========================");
//
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();		
//		  
//		try {
//			
//			if(event.getMarineTerminalInvoiceCommonVO() != null){
//				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchOtherCarrierAccountCodeRSQL(), param, velParam);
//
//		} catch (SQLException se) {
//			log.debug("#####################se.getMessage()============>"+se.getMessage());
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dbRowset;
//	}

	/** MarineTerminalInvoiceManage의 AccumulatedVolumeList를 조회한다.<br>
	 *
	 * @param  tesTmlSoAccmYdVO TesTmlSoAccmYdVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAccumulatedVolumeList(TesTmlSoAccmYdVO tesTmlSoAccmYdVO) throws DAOException {
		log.debug("==================== start searchAccumulatedVolumeList ==========================");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoAccmYdVO != null){
				Map<String, String> mapVO = tesTmlSoAccmYdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchAccumulatedVolumeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}


	/** MarineTerminalInvoiceManage의 3rd Party를 조회한다.<br>
	 *
	 * @param  event EsdTes9232Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAutoTrdPartyVolume(EsdTes9232Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchAutoTrdPartyVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoHdrVO()!= null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO()!= null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchAutoTrdPartyVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}

	/** MarineTerminalInvoiceManage의 JO일때 3rd Party Volume를 조회한다.<br>
	 *
	 * @param  event EsdTes9232Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchManualTrdPartyVolumeJo(EsdTes9232Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchManualTrdPartyVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoHdrVO()!= null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO()!= null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeJoRSQL(), param, velParam);	

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}		

	/** MarineTerminalInvoiceManage의 3rd Party Volume를 조회한다.<br>
	 *
	 * @param  event EsdTes9232Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchManualTrdPartyVolume(EsdTes9232Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchManualTrdPartyVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoHdrVO()!= null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO()!= null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchManualTrdPartyVolumeRSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	
	}



	/** MarineTerminalInvoiceManage의 3rd Party Volume를 조회한다.<br>
	 *
	 * @param  tesN3rdPtyIfVO TesN3rdPtyIfVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMarineTerminalTrdPartyVolume(TesN3rdPtyIfVO tesN3rdPtyIfVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchMarineTerminalTrdPartyVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesN3rdPtyIfVO != null){
				Map<String, String> mapVO = tesN3rdPtyIfVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchMarineTerminalTrdPartyVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	}




	/** MarineTerminalInvoiceManage의 auto일때 RevisedVolume를 조회한다.<br>
	 *
	 * @param  tesTmlSoCntrListVO TesTmlSoCntrListVO
	 * @param  tesTmlSoDtlVO TesTmlSoDtlVO
	 * @param  tesCommonVO TesCommonVO
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAutoRevisedVolume(TesTmlSoCntrListVO tesTmlSoCntrListVO, TesTmlSoDtlVO tesTmlSoDtlVO, TesCommonVO tesCommonVO, TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchAutoRevisedVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				log.debug("velParam yd_cd====================>"+velParam.get("yd_cd"));
			}
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;					
	}


	/** MarineTerminalInvoiceManage의 manual일때 RevisedVolume를 조회한다.<br>
	 *
	 * @param  tesTmlSoCntrListVO TesTmlSoCntrListVO
	 * @param  tesTmlSoDtlVO TesTmlSoDtlVO
	 * @param  tesCommonVO TesCommonVO
	 * @param  marineTerminalInvoiceCommonVO MarineTerminalInvoiceCommonVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchManualRevisedVolume(TesTmlSoCntrListVO tesTmlSoCntrListVO, TesTmlSoDtlVO tesTmlSoDtlVO, TesCommonVO tesCommonVO, MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchManualRevisedVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				log.debug("vvd===========================>"+mapVO.get("vvd"));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(marineTerminalInvoiceCommonVO != null){
				Map<String, String> mapVO = marineTerminalInvoiceCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
log.debug("mapVO.rvis_div=======>"+mapVO.get("rvis_div"));				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchManualRevisedVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;				
	}

	/** MarineTerminalInvoiceManage의 RehandlingVolume를 조회한다.<br>
	 * @param  tesTmlSoRvisListVO TesTmlSoRvisListVO
	 * @param  tesCommonVO TesCommonVO
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRehandlingVolume(TesTmlSoRvisListVO tesTmlSoRvisListVO, TesCommonVO tesCommonVO, TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoRvisListVO != null){
				Map<String, String> mapVO = tesTmlSoRvisListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(tesCommonVO != null){
				Map<String, String> mapVO = tesCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	

			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchRehandlingVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
	}
	
	
	/** MarineTerminalInvoiceManage의 MenualRvis구분값을 조회한다.<br>
	 *
	 * @param MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO
	 * @return DBRowSet
	 * @throws DAOException
	 */

	public DBRowSet searchManualRvisDivision(MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			if(marineTerminalInvoiceCommonVO != null){
				Map<String, String> mapVO = marineTerminalInvoiceCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchManualRvisDivisionRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
	}
	
	/** MarineTerminalInvoiceManage의 Confirm시 ContainerList를 수정한다.<br>
	 * @param  event EsdTes0001Event
	 * @param  userId
	 * @param  ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public int modifyCntrListForTerminalInvoiceConfirm(EsdTes0001Event event, String userId, String ofc_cd) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int resultCnt 	= 0;
		int updCnt 		= 0;
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("usr_id", userId);
				param.put("ofc_cd", ofc_cd);
			}
			
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL(), param, velParam);
			
			if(updCnt > 0) 	resultCnt = 1;

			if(event.getTesTmlSoHdrVO()!=null && event.getTesTmlSoHdrVO().getTmlInvTpCd().equals("TM")){
				resultCnt = multiMarineTerminalInvoiceAccumulatedVolume(event, ofc_cd);
			}
			
			return resultCnt;			
			
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

	}

	/** MarineTerminalInvoiceManage의 AccumulatedVolume를 생성/수정한다.<br>
	 *
	 * @param  event EsdTes0001Event
	 * @param  ofc_cd String
	 * @return int
	 * @throws DAOException
	 */
	public int multiMarineTerminalInvoiceAccumulatedVolume(EsdTes0001Event event, String ofc_cd) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		int 				resultCnt 	= 0;
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("ofc_cd", ofc_cd);
			}
			
			if(event.getTesTmlSoAccmVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoAccmVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = multiMarineTerminalInvoiceAccumulatedVolumeCountAccm(event);
			
			int rowCnt =  dbRowset.getRowCount();
			
			if(rowCnt < 0){
				resultCnt 	= new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeInsertCSQL(), param, velParam); 
			}
			
			if(resultCnt > 0) resultCnt =1;
				
			return resultCnt;			
			
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

	}
	
	/** MarineTerminalInvoiceManage의 multiMarineTerminalInvoiceAccumulatedVolumeCountAccm 
	 * 
	 * @param  event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet multiMarineTerminalInvoiceAccumulatedVolumeCountAccm(EsdTes0001Event event) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
//		int 				resultCnt 	= 0;
		
		try {
			if(event.getTesTmlSoAccmVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoAccmVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiMarineTerminalInvoiceAccumulatedVolumeCountAccmRSQL(), param, velParam);
			
			return dbRowset;			
			
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
	}
		

	/**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  model EsdTes0013Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceSummary(EsdTes0013Event model) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchTerminalInvoiceSummary  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		List<String> itemList = new ArrayList<String>();
		
		try {
			if(model != null){
				Map<String, String> mapVO = model.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = model.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				mapVO = model.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				itemList = TESCommonUtil.getSeperationParameterList(model.getMarineTerminalInvoiceCommonVO().getCostCode(), ","); // 화면에서 선택한 멀티콤보의 값을 list 형태로 변환한다.
				
				velParam.put("cost_cd", itemList); // in 조건으로 파라메터 제공을 위해 list 로 가공하여 셋팅				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}



	/**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes0014Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalExpenseSummary(EsdTes0014Event event) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchTerminalExpenseSummary  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempCostOfcCd = ""; 
		String tempInvOfcCd  = "";
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//cost_ofc_cd 넣는 부분
				if(!event.getTesTmlSoHdrVO().getCostOfcCd().equals("")){
					strCd = new StringTokenizer(event.getTesTmlSoHdrVO().getCostOfcCd(), ",");
					tempCostOfcCd = strCd.nextToken();
					tempArrL.add(tempCostOfcCd);

					while(strCd.hasMoreTokens()){
						tempCostOfcCd = strCd.nextToken();
						tempArrL.add(tempCostOfcCd);
					}
				}
				
				if(tempArrL.size()>0){
					velParam.put("cost_ofc_cd", tempArrL);
				}
				
				if(!event.getTesTmlSoHdrVO().getInvOfcCd().equals("")){
					strCd = new StringTokenizer(event.getTesTmlSoHdrVO().getInvOfcCd(), ",");
					tempInvOfcCd = strCd.nextToken();
					tempArrL.add(tempInvOfcCd);

					while(strCd.hasMoreTokens()){
						tempInvOfcCd = strCd.nextToken();
						tempArrL.add(tempInvOfcCd);
					}
				}
				if(tempArrL.size()>0){
					velParam.put("inv_ofc_cd", tempArrL);
				}	

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseSummaryRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}

	/**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * model 데이타 모델
	 *
	 * @param event EsdTes9300Event
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet searchOfficeHierarchy(EsdTes9300Event event) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchOfficeHierarchy  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchOfficeHierarchyRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

		
//		
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//
//		StringBuffer queryStr = new StringBuffer();
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		queryStr.append("SELECT 															  \n");
//		queryStr.append("	LEVEL, DECODE(LEVEL,                                              \n");
//		queryStr.append("	1, OFC_CD,                                                        \n");
//		queryStr.append("	2, '      '||OFC_CD,                                              \n");
//		queryStr.append("	3, '            '||OFC_CD,                                        \n");
//		queryStr.append("	4, '                  '||OFC_CD,                                  \n");
//		queryStr.append("	5, '                        '||OFC_CD,                            \n");
//		queryStr.append("	6, '                           '||OFC_CD,                         \n");
//		queryStr.append("	7, '                                 '||OFC_CD,                   \n");
//		queryStr.append("	8, '                                       '||OFC_CD,             \n");
//		queryStr.append("	9, '                                             '||OFC_CD,       \n");
//		queryStr.append("	10, '                                                  '||OFC_CD, \n");
//		queryStr.append("	'') OFC_CD_NAME, OFC_CD                                           \n");
//		queryStr.append("FROM MDM_ORGANIZATION                                                \n");
//		queryStr.append("WHERE DELT_FLG = 'N'                                                 \n");
//		queryStr.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD                        \n");
//		queryStr.append("START WITH OFC_CD = ?                                          	  \n");
//		queryStr.append("ORDER SIBLINGS BY OFC_CD             								  \n");
//
//
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//
//			ps.setString(i++, param_map.get("ofc_cd").toString());
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
	}


	 /**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * model 데이타 모델
	 * 
	 * @param event EsdTes9300Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSubOffice(EsdTes9300Event event) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchSubOffice  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
//		String[] src_ofc = param_map.get("src_ofc").toString().split(",");
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempOfcCd = ""; 
		
		try {
			if(event != null){
				
				//ofc_cd 넣는 부분
				if(!event.getMarineTerminalInvoiceCommonVO().getSrcOfc().equals("")){
					strCd = new StringTokenizer(event.getMarineTerminalInvoiceCommonVO().getSrcOfc(), ",");
					tempOfcCd = strCd.nextToken();
					tempArrL.add(tempOfcCd);

					while(strCd.hasMoreTokens()){
						tempOfcCd = strCd.nextToken();
						tempArrL.add(tempOfcCd);
					}
				}
				
				if(tempArrL.size()>0){
					velParam.put("ofc_cd", tempArrL);
				}
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchSubOfficeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
		
		
		
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//
//		String[] src_ofc = param_map.get("src_ofc").toString().split(",");
//
//		StringBuffer queryStr = new StringBuffer();
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		queryStr.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(OFC_CD,',')),',') ETC	\n");
//		queryStr.append("FROM(														\n");
//		queryStr.append("    SELECT ROWNUM ROW_ID, OFC_CD							\n");
//		queryStr.append("    FROM(													\n");
//		queryStr.append("        SELECT OFC_CD FROM MDM_ORGANIZATION				\n");
//		queryStr.append("        WHERE DELT_FLG = 'N'								\n");
//		queryStr.append("        CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD		\n");
//		queryStr.append("        START WITH OFC_CD = ?								\n");
//
//		for(int j=1; j<src_ofc.length; j++){
//			queryStr.append("        UNION												\n");
//			queryStr.append("        SELECT OFC_CD FROM MDM_ORGANIZATION				\n");
//			queryStr.append("        WHERE DELT_FLG = 'N'								\n");
//			queryStr.append("        CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD		\n");
//			queryStr.append("        START WITH OFC_CD = ?								\n");
//		}
//
//		queryStr.append("        )													\n");
//		queryStr.append("    )														\n");
//		queryStr.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1						\n");
//		queryStr.append("START WITH ROW_ID = 1 										\n");
//
//
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//
//			ps.setString(i++, src_ofc[0]);
//			for(int j=1; j<src_ofc.length; j++){
//				ps.setString(i++, src_ofc[j]);
//			}
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
	}


	

	/**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes0014Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalExpenseVolumeSummary(EsdTes0014Event event) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchTerminalExpenseVolumeSummary  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strCd = null;
		String tempCostOfcCd = ""; 
		String tempInvOfcCd  = "";
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();

				param.putAll(mapVO);
				mapVO.remove("cost_ofc_cd");
				velParam.putAll(mapVO);

				
				log.debug("event.getTesTmlSoDtlVO().getLaneCd()====>"+event.getTesTmlSoDtlVO().getLaneCd());
				
				if(!"".equals(event.getTesTmlSoDtlVO().getLaneCd())){
					param.put("lane_cd", event.getTesTmlSoDtlVO().getLaneCd());
					velParam.put("lane_cd", event.getTesTmlSoDtlVO().getLaneCd());
				}
				
				//cost_ofc_cd 넣는 부분
				if(!event.getTesTmlSoHdrVO().getCostOfcCd().equals("")){
					strCd = new StringTokenizer(event.getTesTmlSoHdrVO().getCostOfcCd(), ",");
					tempCostOfcCd = strCd.nextToken();
					tempArrL.add(tempCostOfcCd);

					while(strCd.hasMoreTokens()){
						tempCostOfcCd = strCd.nextToken();
						tempArrL.add(tempCostOfcCd);
					}
				}
				
				if(tempArrL.size()>0){
					velParam.put("cost_ofc_cd", tempArrL);
				}
				
log.debug("event.getMarineTerminalInvoiceCommonVO().getInvDateType()====>"+event.getMarineTerminalInvoiceCommonVO().getInvDateType());
log.debug("event.getTesTmlSoHdrVO().getFmPrdDt()====>"+event.getTesTmlSoHdrVO().getFmPrdDt());

				//mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				//param.putAll(mapVO);
				//velParam.putAll(mapVO);

				mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				tempArrL = new ArrayList();
				for(int j=0; j<event.getMarineTerminalInvoiceCommonVO().getCostCode().length()/2; j++){
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCostCode().substring(j*2, (j+1)*2));
				}
				if(tempArrL.size()>0){ 
					//param.put("lgs_cost_subj_cd", tempArrL);
					velParam.put("lgs_cost_subj_cd", tempArrL);
				}
				
				//inv_ofc_cd 위해서 초기화
				tempArrL = new ArrayList();
				mapVO.remove("inv_ofc_cd");
				
				tempArrL = new ArrayList();
				//inv_ofc_cd 넣는 부분
				if(!event.getTesTmlSoHdrVO().getInvOfcCd().equals("")){
					strCd = new StringTokenizer(event.getTesTmlSoHdrVO().getInvOfcCd(), ",");
					tempInvOfcCd = strCd.nextToken();
					tempArrL.add(tempInvOfcCd);

					while(strCd.hasMoreTokens()){
						tempInvOfcCd = strCd.nextToken();
						tempArrL.add(tempInvOfcCd);
					}
				}
				if(tempArrL.size()>0){
					velParam.put("inv_ofc_cd", tempArrL);
				}	
				
log.debug("event.getMarineTerminalInvoiceCommonVO().getCntrStyCode()=====>"+event.getMarineTerminalInvoiceCommonVO().getCntrStyCode());				
				//cntr_sty_cd_num 넣는 부분
				tempArrL = new ArrayList();
				for(int j=0; j<event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().length(); j++){
					tempArrL.add(event.getMarineTerminalInvoiceCommonVO().getCntrStyCode().substring(j, (j+1)));					
				}
				if(tempArrL.size()>0){
					velParam.put("cntr_sty_cd", tempArrL);						
					
				}
			
			}

			
log.debug("velParam.get(cntr_sty_cd)===========>"+velParam.get("cntr_sty_cd"));			
log.debug("#########FmPrdDt====>"+param.get("fm_prd_dt"));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalExpenseVolumeSummaryRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;
		
		/*******************************************************************
		 * 추후 같은 현상(DB다운) 발생시 아래 조건 실행 토록 주석 제거 
		// 조회조건중 값이 없는 경우 조건 제외 현상 방지 추가	( 2009-03-11 )
		if ( "".equals( param_map.get("yd_cd") ) 		&& 
			 "".equals( param_map.get("vndr_seq") ) 	&& 
			 "".equals( param_map.get("cost_ofc_cd") )	&&
			 "".equals( param_map.get("inv_ofc_cd") )
		) {
			isSearchOpt	= true;
		}
		
		// 조회조건중 inv_date 값이 없는 경우 조건 제외 현상 방지 추가 ( 2009-03-11 )
		if ( !"I".equals( param_map.get("inv_date_type") )	&&
			 !"R".equals( param_map.get("inv_date_type") )	&&
			 !"P".equals( param_map.get("inv_date_type") )	&&
			 !"A".equals( param_map.get("inv_date_type") )	
		) {
			isInvDate	= true;
		}
		
		// 조회조건이 없는 경우 쿼리 실행 안되도록 조건 추가 ( 2009-03-11 ) 
		if ( isSearchOpt || isInvDate ) {
			queryStr.append("		AND		1	= 2		\n");
		}
		***********************************************************************/
	}

	/**
	 * Reject Lift기능구현.<br>
	 *
	 * @param tesTmlSoHdrVO TesTmlSoHdrVO
	 * @param userId
	 * @param ofc_cd
	 * @throws DAOException
	 */
	public void modifyTerminalInvoiceConfirm(TesTmlSoHdrVO tesTmlSoHdrVO, String userId, String ofc_cd) throws DAOException {
		log.debug("\n================= marineterminalinvoicemanageDBDAO  modifyTerminalInvoiceConfirm  Start........ =================\n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				
				param.put("upd_usr_id", userId);
				param.put("ofc_cd", ofc_cd);
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq());

				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTermainalInvoiceManageDBDAOModifyTerminalInvoiceConfirmUSQL(), param, velParam);

			
		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		

	}


	/**
	 * marineterminalinvoicemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes0001Event
	 * @param  ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchACCMUpdateData(EsdTes0001Event event, String ofc_cd) throws DAOException {
		log.debug("\n=============== marineterminalinvoicemanageDBDAO  searchACCMUpdateData  Start........ =================\n");
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter		
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				
				param.putAll(mapVO);
				param.put("ofc_cd", ofc_cd);
					
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchACCMUpdateDataRSQL(), param, velParam);

			return dbRowset;
		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}				
		
	}

	/**
	 * 
	 * @param accm_seq
	 * @param event
	 * @param userId
	 * @param ofc_cd
	 * @throws DAOException
	 */
	public void modifyMarineTerminalInvoiceAccumulatedVolumeUpdate(String accm_seq, EsdTes0001Event event, String userId, String ofc_cd) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    modifyMarineTerminalInvoiceAccumulatedVolumeUpdate()");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoAccmVO()!= null){
				Map<String, String> mapVO = event.getTesTmlSoAccmVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("accm_seq", accm_seq);
			param.put("upd_usr_id", userId);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeUpdateUSQL(), param, velParam);

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
		
	}
	
	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param accm_seq
	 * @param event EsdTes0001Event
	 * @param userId
	 * @param ofc_cd
	 * @throws DAOException
	 */
	public void modifyMarineTerminalInvoiceAccumulatedVolumeInsert(String accm_seq, EsdTes0001Event event, String userId, String ofc_cd) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    modifyMarineTerminalInvoiceAccumulatedVolume()");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoAccmVO()!= null){
				Map<String, String> mapVO = event.getTesTmlSoAccmVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("accm_seq", accm_seq);
			param.put("cre_usr_id", userId);
			param.put("upd_usr_id", userId);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOModifyMarineTerminalInvoiceAccumulatedVolumeInsertCSQL(), param, velParam);

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
	
	}

	/** MarineTerminalInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param  event EsdTes0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMarineTerminalAccumVolCase (EsdTes0001Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    searchMarineTerminalAccumVolCase() ============");

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchMarineTerminalAccumVolCaseRSQL(), param, velParam);

			return dbRowSet;
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

	}


	/** checkSOInvAmt 
	 *
	 * @param  tesTmlSoHdrVO TesTmlSoHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkSOInvAmt(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDBDAO    checkSOInvAmt() ============");
		
		DBRowSet dbRowSet 	= null;
		String   retval		= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCheckSOInvAmtRSQL(), param, velParam);

			if (dbRowSet.next()){
				retval = dbRowSet.getString("RETVAL");
			}

			return retval;			
			
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
	
	}

	/** MarineTerminalInvoiceManage의 VVD Dual을 조회한다.<br>
	 *
	 * @param  event EsdTes0001Event
	 * @return DBRowSet
	 * @throws DAOException
	 *
	 */
	public DBRowSet searchTerminalInvoiceVVDDual(EsdTes0001Event event) throws DAOException {
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if(event.getTesCommonVo() != null){
				Map<String, String> mapVO = event.getTesCommonVo().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceVVDDualRSQL(), param, velParam);

			return dbRowSet;
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
					
	}
	
	/** searchTerminalInvoiceAutoBoundList
	 * @param  event EsdTes1003Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceAutoBoundList(EsdTes1003Event event) throws DAOException {

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAutoBoundListRSQL(), param, velParam);

			return dbRowSet;
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

	}
	
	/** multiTerminalInvoiceAutoBoundListInsert
	 * @param  voList List<TesTmlSoDtlVO>
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceAutoBoundListInsert(List<TesTmlSoDtlVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    multiTerminalInvoiceAutoBoundListInsert()");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try {


			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	
	/** multiTerminalInvoiceAutoBoundListUpdate
	 * 
	 * @param  voList List<TesTmlSoDtlVO>
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceAutoBoundListUpdate(List<TesTmlSoDtlVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    multiTerminalInvoiceAutoBoundListUpdate()");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceAutoBoundListUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}
	

	/** checkDualVVDChk
	 * 
	 * @param  event EsdTes1003Event
	 * @return String
	 * @throws DAOException
	 */
	public String checkDualVVDChk(EsdTes1003Event event) throws DAOException {
log.debug("dao start checkDualVVDChk============");

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		String rsltStr	= "";
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCheckDualVVDChkRSQL(), param, velParam);
			dbRowSet.next();
			rsltStr = dbRowSet.getString("VVD_CHECK");
			
			return rsltStr;
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
	}
	
	/** checkDualVVDInsert
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void checkDualVVDInsert(EsdTes1003Event event) throws DAOException {
		log.debug("dao start checkDualVVDInsert=========");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getMarineTerminalInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getMarineTerminalInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			param.put("cre_usr_id", event.getSignOnUserAccount().getUsr_id());
			param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
			param.put("locl_cre_dt", event.getSignOnUserAccount().getOfc_cd());
			param.put("locl_upd_dt", event.getSignOnUserAccount().getOfc_cd());
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCheckDualVVDInsertCSQL(), param, velParam);

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
	
	}	
	
	/**
	 * Search MGSet List
	 * @param model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMGSetFuelingChargeList(MarineTerminalInvoiceCommonVO model) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);		
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOSearchMGSetFuelingChargeListRSQL(), param, velParam);
			
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

		return dbRowset;		
	}	
	
	/** insertMGSetFuelingCharge
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void insertMGSetFuelingCharge(List<TesMgstFuelChgVO> voList) throws DAOException {
		
		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOInsertMGSetFuelingChargeCSQL(), voList, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

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
	}		
	
	/** updateMGSetFuelingCharge
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void updateMGSetFuelingCharge(List<TesMgstFuelChgVO> voList) throws DAOException {
		
		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOUpdateMGSetFuelingChargeUSQL(), voList, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}			
			
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
	}		
	
	/** deleteMGSetFuelingCharge
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void deleteMGSetFuelingCharge(List<TesMgstFuelChgVO> voList) throws DAOException {
		
		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAODeleteMGSetFuelingChargeDSQL(), voList, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}			
			
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
	}
	

	/**
	 * 9001 팝업화면에서 searchCostCodeList
	 *
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO paramVO2
	 * @param String cost_cd_inv_tp_cd
	 * @param SignOnUserAccount account
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCostCodeDetailListVO> searchCostCodeList(SearchCostCodeDetailListVO paramVO, TesCommonVO paramVO2, String cost_cd_inv_tp_cd, SignOnUserAccount account) throws DAOException {
		List<SearchCostCodeDetailListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.put("ofc_cd", account.getOfc_cd());
				param.put("cost_cd_inv_tp_cd", cost_cd_inv_tp_cd);
				param.putAll(mapVO);
				
				velParam.put("cost_cd_inv_tp_cd", cost_cd_inv_tp_cd);
				velParam.putAll(mapVO);
			}
			
			if (paramVO2 != null){
				Map<String, String> cmnVO = paramVO2.getColumnValues();
				param.putAll(cmnVO);
			}			
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MarineTerminalInvoiceManageDBDAOSearchCostCodeListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCostCodeDetailListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 9001 팝업화면에서 searchCostCodeDetailList
	 *
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO paramVO2
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCostCodeDetailListVO> searchCostCodeDetailList(
			SearchCostCodeDetailListVO paramVO, TesCommonVO paramVO2) throws DAOException {
		List<SearchCostCodeDetailListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (paramVO != null){
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cost_cd_inv_tp_cd", paramVO2.getCostCdInvTpCd());
				velParam.put("cost_cd_inv_tp_cd", paramVO2.getCostCdInvTpCd());
				
				if(paramVO.getCostCode() !=null && paramVO.getCostCode() != ""){
					if(paramVO.getCostCode().equals("TMRFPL") || paramVO.getCostCode().equals("TMRFPT") || paramVO.getCostCode().equals("SVSCRF")
							|| paramVO.getCostCode().equals("TMRFMO") || paramVO.getCostCode().equals("TMRFGO") || paramVO.getCostCode().equals("TMRFXX")){
						
						param.put("rf_yn", "Y");
						velParam.put("rf_yn", "Y");
						
					}
				}
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MarineTerminalInvoiceManageDBDAOSearchCostCodeDetailListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCostCodeDetailListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 9010 Search CNTR TYPE CD List<br>
	 * 
	 * @param TesTmlSoCntrListVO tesTmlSoCntrListVO
	 * @return DBRowSet
	 * @throws DAOException
	 */	
	public String searchBkgCntrTPCDList(TesTmlSoCntrListVO tesTmlSoCntrListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("cntr_no", tesTmlSoCntrListVO.getCntrNo() );
			velParam.put("cntr_no", tesTmlSoCntrListVO.getCntrNo() );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchBkgCntrTPCDListRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnVal = dbRowset.getString("CNTR_TPSZ_CD");
			}
		
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
		
		return rtnVal;
	}
	
}