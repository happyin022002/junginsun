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
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageBizType001DBDAO extends TESeBillingManageBizType000DBDAO {

	/**
	 * MANUAL CNTR의 SEQUENCE 설정
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public void updateEDInvoiceMnlCntrListDtlSeq(HashMap<String,String>[] hms, TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		
		log.debug("\n\n BEGIN - TESeBillingManageBizType001DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
		
		try {
			if (hms != null){
				String dtl_seq = null;
				for (int k=0; hms!=null && k<hms.length; k++){
					if (hms[k]!=null && hms[k].containsKey("EDI_SO_DTL_ID") && hms[k].get("EDI_SO_DTL_ID")!=null && !hms[k].get("EDI_SO_DTL_ID").equals("")){
						if ((dtl_seq = getEDIDTLseq4MnlCntrList(JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoOfcCtyCd()),JSPUtil.getNull(tesEdiInitVO.getTmlEdiSoSeq()),(String)hms[k].get("EDI_SO_DTL_ID")))!=null){
							hms[k].put("TML_EDI_SO_DTL_SEQ", dtl_seq);
						}
						log.debug("\n DTL_SEQ - getEDIDTLseq4MnlCntrList :" + dtl_seq +"<<<<<<< \n");
					}
				}
			}

			log.debug("\n\n END - TESeBillingManageBizType001DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
			
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * MANUAL CNTR의 저장용 KEY값 조회
	 * 
	 * @param tml_edi_so_ofc_cty_cd
	 * @param tml_edi_so_seq
	 * @param edi_so_dtl_id
	 * @return
	 * @throws DAOException
	 */
	protected String getEDIDTLseq4MnlCntrList(String tml_edi_so_ofc_cty_cd, String tml_edi_so_seq, String edi_so_dtl_id) throws DAOException {
		log.debug("\n BBB -  TESeBillingManageBizType001DBDAO.getEDIDTLseq4MnlCntrList - ########################################### ");
		
		String 		retval 		= null;
		DBRowSet 	dbRowset 	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		if (tml_edi_so_ofc_cty_cd==null || tml_edi_so_ofc_cty_cd.trim().equals("") ||
			tml_edi_so_seq==null || tml_edi_so_seq.trim().equals("") ||
			edi_so_dtl_id==null || edi_so_dtl_id.trim().equals("")){
			throw new DAOException("TESeBillingManageBizType001DBDAO.getEDIDTLseq - invalid arg !!! ");
		}
		
		try {
			param.put("tml_edi_so_ofc_cty_cd", tml_edi_so_ofc_cty_cd);
			param.put("tml_edi_so_seq", tml_edi_so_seq);
			param.put("edi_so_dtl_id", edi_so_dtl_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType001DBDAOGetEDIDTLseq4MnlCntrListRSQL(), param, param);

			while (dbRowset.next()){
				retval = dbRowset.getString("TML_EDI_SO_DTL_SEQ");
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
		log.debug("\n EEE -  TESeBillingManageBizType001DBDAO.getEDIDTLseq4MnlCntrList - ########################################### ");
		
		return retval!=null&&!retval.trim().equals("")?retval.trim():null;
	}

	/**
	 * KHH의 예외처리: VAT는 INVOICE AMT의 10%와 CURR_CD는 TWD로 update하기
	 * 
	 * @param tesEdiInitVO
	 * @return
	 * @throws DAOException
	 */
	public int updateEDInvoiceVATamtNCurr(TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType001DBDAO.updateEDInvoiceVATamtNCurr - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tesEdiInitVO != null ) {
				param.put("tml_edi_so_ofc_cty_cd", tesEdiInitVO.getTmlEdiSoOfcCtyCd());
				param.put("tml_edi_so_seq", tesEdiInitVO.getTmlEdiSoSeq());
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType001DBDAOUpdateEDInvoiceVATamtNCurrUSQL(), param, null);
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
		log.debug("\n END - TESeBillingManageBizType000DBDAO.updateEDInvoiceTmpCostOfc - ########################################### ");

		return updCnt;
	}
}