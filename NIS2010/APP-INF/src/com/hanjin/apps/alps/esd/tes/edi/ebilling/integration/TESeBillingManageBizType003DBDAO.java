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
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
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
public class TESeBillingManageBizType003DBDAO extends TESeBillingManageBizType000DBDAO {
	
	/**
	 * MANUAL CNTR의 SEQUENCE 설정
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public void updateEDInvoiceMnlCntrListDtlSeq(HashMap<String,String>[] hms, TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n\n BEGIN - TESeBillingManageBizType001DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
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
		log.debug("\n\n END - TESeBillingManageBizType001DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
	}
	
	/**
	 * PSA DTL 후속 작업 : COST CODE MAPPING/YARD MAPPING/COST CODE로 INV유형 결정/VVD MAPPING 등
	 * 
	 * @param er
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoicePSADTLTmp(EventResponse er) throws DAOException {

		log.debug("\n\n PSAeBillingManageDBDAO.updateEDInvoicePSADTLTmp - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		String tml_inv_edi_seq			= (String)eventResponse.getCustomData("TML_INV_EDI_SEQ");
		log.debug("\n updateEDInvoiceDTLTmp tml_inv_edi_seq: "+(tml_inv_edi_seq!=null?tml_inv_edi_seq:"")+"<<<<<<\n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tml_inv_edi_seq != null ) {
				param.put("tml_inv_edi_seq", tml_inv_edi_seq);
//				param.put("psa_vndr_seq", PSA_VNDR_SEQ);
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLTmpUSQL(), param, null);
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
		
		return updCnt;
	}

	/**
	 * PSA HDR 밀어넣기 : DTL에서 (S/P + INV)별 HDR KEY값 추출 -> HDR저장 VNDR에 해당하는 MDM에서 OFC조회및UPDATE(OFC가 없을 경우 유효성 확인시 AJ처리됨)
	 *                   기타 HDR 주요항목 저장 (INV TP/YD/CURR/COST OFC/TTL AMT.. 등)
	 *                   
	 * @param EventResponse er
	 * @exception DAOException
	 */
	public void createEDInvoicePSAHDRTmpData(EventResponse er) throws DAOException {

		log.error("\n\n PSAeBillingManageDBDAO.createEDInvoicePSAHDRTmpData - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		String tml_inv_edi_seq			= (String)eventResponse.getCustomData("TML_INV_EDI_SEQ");
		log.debug("\n createEDInvoiceHDRTmpData tml_inv_edi_seq: "+(tml_inv_edi_seq!=null?tml_inv_edi_seq:"")+"<<<<<<\n");
		
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( tml_inv_edi_seq != null ) {
				param.put("tml_inv_edi_seq", tml_inv_edi_seq);
//				param.put("psa_vndr_seq", PSA_VNDR_SEQ);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType003DBDAOCreateEDInvoicePSAHDRTmpDataCSQL(), param, null);
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
	 * PSA DTL의 부모 찾아 이어주기
	 * 
	 * @param er
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoicePSADTLHDRseq(EventResponse er) throws DAOException {

		log.debug("\n\n PSAeBillingManageDBDAO.updateEDInvoicePSADTLHDRseq - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		String tml_inv_edi_seq			= (String)eventResponse.getCustomData("TML_INV_EDI_SEQ");
		log.debug("\n updateEDInvoiceDTLHDRseq tml_inv_edi_seq: "+(tml_inv_edi_seq!=null?tml_inv_edi_seq:"")+"<<<<<<\n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tml_inv_edi_seq != null ) {
				param.put("tml_inv_edi_seq", tml_inv_edi_seq);
//				param.put("psa_vndr_seq", PSA_VNDR_SEQ);
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLHDRseqUSQL(), param, null);
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
		
		return updCnt;
	}
	
	/**
	 * PSA DTL ATB_DT 찾아 넣는 작업 : PSA HDR에 정품 YARD가  있어야  처리 가능하기에 PSA DTL에 부모까지 찾은 상태에서 실행한다.
	 * 
	 * @param er
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoicePSADTLAtbDt(EventResponse er) throws DAOException {

		log.debug("\n\n PSAeBillingManageDBDAO.updateEDInvoicePSADTLAtbDt - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		String tml_inv_edi_seq			= (String)eventResponse.getCustomData("TML_INV_EDI_SEQ");
		log.debug("\n updateEDInvoicePSADTLAtbDt tml_inv_edi_seq: "+(tml_inv_edi_seq!=null?tml_inv_edi_seq:"")+"<<<<<<\n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tml_inv_edi_seq != null ) {
				param.put("tml_inv_edi_seq", tml_inv_edi_seq);
//				param.put("psa_vndr_seq", PSA_VNDR_SEQ);
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType003DBDAOUpdateEDInvoicePSADTLAtbDtUSQL(), param, null);
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
		
		return updCnt;
	}

	/**
	 * 기본 수신단계에서 유효성 확인까지 마치고, NON-TES tariff로만 된 경우(cost code mapping이 하나도 안된 경우라 추정) invoice를 삭제처리한다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @throws DAOException
	 */
	public void deleteNonTESTariffInvoice(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( tesEdiSoHdrVO != null ){
				
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("tml_inv_edi_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlInvEdiSeq()));
				param.put("upd_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getUpdUsrId()));
				
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType003DBDAODeleteNonTESTariffInvoiceUSQL(), param, null);
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
	
}