/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInterfaceManageDBDAO.java
*@FileTitle : TDR_RESTOW Data Interface to VSK_TDR_RHND
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*2012-01-04
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileTagVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileXcldVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.core.layer.event.EventResponse;
//import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageCommonDBDAO extends DBDAOSupport {
	
	/**
	 * 유효한 eBilling EDI VNDR여부를 확인한다.
	 * @param tesEdiSoHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkValidEdiVndrSeq(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageCommonDBDAO.checkValidEdiVndrSeq ----------------- \n");
		
		String retval = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (tesEdiSoHdrVO!=null){
				param.put("vndr_seq",JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOCheckValidEdiVndrSeqRSQL(), param, velParam);
				if (dbRowset!=null && dbRowset.next()){
					retval = dbRowset.getString("CHK_VAL_VNDR");
				}
			} else {
				log.error("\n No proper TESCommonEvent object found!!!! \n");
				throw new DAOException("No proper TESCommonEvent object found!!!");	
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n EEE - TESCommonDBDAO.checkValidEdiVndrSeq ----------------- \n");
		return retval;
	}
	
	/**
	 * EDI ERROR관련 LOG 
	 * @param tesEdiErrLogVO
	 * @throws DAOException
	 */
	public void logEDIErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) throws DAOException{
		log.debug("\n BBBB - TESeBillingManageCommonDBDAO-logEDIErrMsg \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiErrLogVO != null){
				param.put("edi_msg", JSPUtil.getNull(tesEdiErrLogVO.getEdiMsg()));
				param.put("err_log_rmk", JSPUtil.getNull(tesEdiErrLogVO.getErrLogRmk()));
				param.put("tml_inv_edi_seq", JSPUtil.getNull(tesEdiErrLogVO.getTmlInvEdiSeq()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageCommonDBDAOLogEDIErrMsgCSQL(), param, velParam);
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
		log.debug("\n EEEE - TESeBillingManageCommonDBDAO-logEDIErrMsg \n");
	}
	
	/**
	 * EDI Main Rule 조회
	 * @param tesEdiInitVO
	 * @return
	 * @throws DAOException
	 */
	public ComTesEdiRcvRuleMnVO getEdiMainRule(TesEdiSoHdrVO tesEdiInitVO) throws DAOException{
		log.debug("\n TESeBillingManageCommonDBDAO-getEdiMainRule \n");
		
		List<ComTesEdiRcvRuleMnVO> tesEdiRuleMainVOlist = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiInitVO != null){
				log.debug("\n  TESeBillingManageCommonDBDAO-getEdiMainRule ~~ sndr_id:"+JSPUtil.getNull(tesEdiInitVO.getSndrId())+" \n");
				param.put("sndr_id", JSPUtil.getNull(tesEdiInitVO.getSndrId()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOGetEdiMainRuleRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiRuleMainVOlist = (List)RowSetUtil.rowSetToVOs(dbRowset, ComTesEdiRcvRuleMnVO.class);
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

		return (tesEdiRuleMainVOlist!=null && tesEdiRuleMainVOlist.size()>0 ? tesEdiRuleMainVOlist.get(0) : null);		
	}
	
	/**
	 * EDI VNDR RULE 조회
	 * @param tesEdiInitVO
	 * @return
	 * @throws DAOException
	 */
	public ComTesEdiRcvRuleVndrMgmtVO getSetEdiVndrRules(TesEdiSoHdrVO tesEdiInitVO) throws DAOException{
		log.debug("\n TESeBillingManageCommonDBDAO-getSetEdiVndrRules \n");
		
		List<ComTesEdiRcvRuleVndrMgmtVO> tesEdiRuleVndrVOList = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiInitVO != null){
				param.put("sndr_id", JSPUtil.getNull(tesEdiInitVO.getSndrId()));
				param.put("vndr_seq", JSPUtil.getNull(tesEdiInitVO.getVndrSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOGetSetEdiVndrRulesRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiRuleVndrVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, ComTesEdiRcvRuleVndrMgmtVO.class);
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

		return (tesEdiRuleVndrVOList!=null && tesEdiRuleVndrVOList.size()>0 ? tesEdiRuleVndrVOList.get(0) : null);		
	}
	
	/**
	 * EDI F/F TAG Rule 조회
	 * @param tesEdiInitVO
	 * @return
	 * @throws DAOException
	 */
	public List<ComTesEdiRcvFltFileTagVO> getSetFltFileTagRules(TesEdiSoHdrVO tesEdiInitVO) throws DAOException{
		log.debug("\n TESeBillingManageCommonDBDAO-getSetFltFileTagRules \n");
		
		List<ComTesEdiRcvFltFileTagVO> tesEdiFltFileTagMgmtVOlist = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiInitVO!=null && tesEdiInitVO != null){
				param.put("sndr_id", JSPUtil.getNull(tesEdiInitVO.getSndrId()));
				param.put("vndr_seq", JSPUtil.getNull(tesEdiInitVO.getVndrSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOGetSetFltFileTagRulesRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiFltFileTagMgmtVOlist = (List)RowSetUtil.rowSetToVOs(dbRowset, ComTesEdiRcvFltFileTagVO.class);
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

		return tesEdiFltFileTagMgmtVOlist;		
	}	
	

	/**
	 * EDI F/F Exclude 정보 조회
	 * @param tesEdiInitVO
	 * @param tesEdiFltFileTagMgmtVO
	 * @return
	 * @throws DAOException
	 */
	public List<ComTesEdiRcvFltFileXcldVO> getSetFltFileXcldDtlRules(TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvFltFileTagVO tesEdiFltFileTagMgmtVO) throws DAOException{
		log.debug("\n TESeBillingManageCommonDBDAO-getSetFltFileXcldDtlRules \n");
		
		List<ComTesEdiRcvFltFileXcldVO> tesEdiFltFileXcldDtlVOlist = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesEdiInitVO!=null && tesEdiFltFileTagMgmtVO!=null){
				param.put("sndr_id", JSPUtil.getNull(tesEdiInitVO.getSndrId()));
				param.put("vndr_seq", JSPUtil.getNull(tesEdiInitVO.getVndrSeq()));
				param.put("tag_nm", JSPUtil.getNull(tesEdiFltFileTagMgmtVO.getFltFileTagNm()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOGetSetFltFileXcldDtlRulesRSQL(), param, velParam);
				if (dbRowset!=null){
					tesEdiFltFileXcldDtlVOlist = (List)RowSetUtil.rowSetToVOs(dbRowset, ComTesEdiRcvFltFileXcldVO.class);
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

		return tesEdiFltFileXcldDtlVOlist;		
	}	
	
	/**
	 * TML_INV_EDI_SEQ 구하기
	 * @return
	 * @throws DAOException
	 */
	public String createTmlInvEdiSeq() throws DAOException {
		
		log.debug("\n\n DAO.createTmlInvEdiSeq - ########################################### ");
		
		String tml_inv_edi_seq = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOCreateTmlInvEdiSeqRSQL(), param, param);
			if ( dbRowset.next() ) {
				tml_inv_edi_seq = dbRowset.getString("TML_INV_EDI_SEQ");
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
		
		return tml_inv_edi_seq;
	}
	
	/**
	 * EDI 저장된 INVOICE목록 가져오기(처리 중인 F/F 전체 단위로)
	 * @param tml_inv_edi_seq
	 * @return
	 * @throws DAOException
	 */
	public List<TesEdiSoHdrVO> getEDIInvoiceList(String tml_inv_edi_seq) throws DAOException {
		log.debug("\n TESeBillingManageCommonDBDAO-getEDIInvoiceList \n");
		
		List<TesEdiSoHdrVO> lt_tesEdiSoHdrVO = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tml_inv_edi_seq != null && !tml_inv_edi_seq.trim().equals("")){
				param.put("tml_inv_edi_seq", JSPUtil.getNull(tml_inv_edi_seq));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageCommonDBDAOGetEdiInvoiceListRSQL(), param, velParam);
				if (dbRowset!=null){
					lt_tesEdiSoHdrVO = (List)RowSetUtil.rowSetToVOs(dbRowset, TesEdiSoHdrVO.class);
				}
			} else {
				log.error("\n NO tml_inv_edi_seq found \n");
				throw new EventException("NO tml_inv_edi_seq found");				
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
		return lt_tesEdiSoHdrVO;
	}	

}