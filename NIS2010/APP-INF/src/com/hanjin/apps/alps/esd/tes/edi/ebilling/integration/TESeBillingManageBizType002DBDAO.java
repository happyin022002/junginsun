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
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoDtlVO;
import com.hanjin.syscommon.common.table.TesEdiSoCntrListVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType002DBDAO extends TESeBillingManageBizType000DBDAO {

	/**
	 * MANUAL CNTR의 SEQUENCE 설정
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public void updateEDInvoiceMnlCntrListDtlSeq(HashMap<String,String>[] hms, TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n\n BEGIN - TESeBillingManageBizType002DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
		String vndr_seq = null;
		try {
			if (hms != null && tesEdiInitVO!=null){
				vndr_seq = JSPUtil.getNull(tesEdiInitVO.getVndrSeq());
				log.debug("\n vndr_seq:"+vndr_seq+"<<<<\n");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n\n END - TESeBillingManageBizType002DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
	}
	
	
	/**
	 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO로 VVD Update해야 할 DTL 대상 조회
	 * 
	 * @param invVO
	 * @return List<TesEdiSoDtlVO>
	 * @throws DAOException
	 */
	public List<TesEdiSoDtlVO> getEDInvoiceToUpdateDtlVVD(TesEdiSoHdrVO invVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType002DBDAO.getEDInvoiceToUpdateDtlVVD - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<TesEdiSoDtlVO> tesEdiSoDtlVOlist = null;

		try {
			if (invVO != null){
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(invVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(invVO.getTmlEdiSoSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateDtlVVDRSQL(), param, velParam);
				tesEdiSoDtlVOlist = (List)RowSetUtil.rowSetToVOs(dbRowset, TesEdiSoDtlVO.class);
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
		log.debug("\n END - TESeBillingManageBizType002DBDAO.getEDInvoiceToUpdateDtlVVD - ########################################### ");
		return tesEdiSoDtlVOlist;
	}	
	
	/**
	 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO로 VVD Update해야 할 DTL 대상 Update하기
	 * 
	 * @param tesEdiSoDtlVOlist
	 * @throws DAOException
	 */
	public void updateEDInvoiceDtlVVD(List<TesEdiSoDtlVO> tesEdiSoDtlVOlist) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType002DBDAO.updateEDInvoiceDtlVVD - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;		
		
		try {
			if(tesEdiSoDtlVOlist.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TESeBillingManageBizType002DBDAOUpdateEDInvoiceDtlVVDUSQL(), tesEdiSoDtlVOlist, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		log.debug("\n END - TESeBillingManageBizType002DBDAO.updateEDInvoiceDtlVVD - ########################################### ");
	}	
	
	/**
	 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO로 VVD Update해야 할 CNTR List 대상 조회
	 * 
	 * @param invVO
	 * @return List<TesEdiSoCntrListVO>
	 * @throws DAOException
	 */
	public List<TesEdiSoCntrListVO> getEDInvoiceToUpdateCntrListVVD(TesEdiSoHdrVO invVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType002DBDAO.getEDInvoiceToUpdateCntrListVVD - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<TesEdiSoCntrListVO> tesEdiSoCntrListVOlist = null;

		try {
			if (invVO != null){
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(invVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(invVO.getTmlEdiSoSeq()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateCntrListVVDRSQL(), param, velParam);
				tesEdiSoCntrListVOlist = (List)RowSetUtil.rowSetToVOs(dbRowset, TesEdiSoCntrListVO.class);
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
		log.debug("\n END - TESeBillingManageBizType002DBDAO.getEDInvoiceToUpdateCntrListVVD - ########################################### ");
		return tesEdiSoCntrListVOlist;
	}	
	
	/**
	 * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO로 VVD Update해야 할 CNTR List 대상 Update하기
	 * 
	 * @param tesEdiSoDtlVOlist
	 * @throws DAOException
	 */
	public void updateEDInvoiceCntrListVVD(List<TesEdiSoCntrListVO> tesEdiSoDtlVOlist) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType002DBDAO.updateEDInvoiceCntrListVVD - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;		
		
		try {
			if(tesEdiSoDtlVOlist.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TESeBillingManageBizType002DBDAOUpdateEDInvoiceCntrListVVDUSQL(), tesEdiSoDtlVOlist, velParam, param);
				for (int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
		log.debug("\n END - TESeBillingManageBizType002DBDAO.updateEDInvoiceCntrListVVD - ########################################### ");
	}	

}