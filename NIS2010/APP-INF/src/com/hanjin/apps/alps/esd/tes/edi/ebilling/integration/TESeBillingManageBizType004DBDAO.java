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
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

//import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.core.layer.event.EventResponse;
//import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
//import com.hanjin.framework.support.db.RowSetUtil;
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
public class TESeBillingManageBizType004DBDAO extends TESeBillingManageBizType000DBDAO {
	
	/**
	 * MANUAL CNTR의 SEQUENCE 설정
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public void updateEDInvoiceMnlCntrListDtlSeq(HashMap<String,String>[] hms, TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n\n BEGIN - TESeBillingManageBizType004DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
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
		log.debug("\n\n END - TESeBillingManageBizType004DBDAO.updateEDInvoiceMnlCntrListDtlSeq  - ########################################### ");
	}
	
	/**
	 * EDI로 접수된 Invoice의 유효성을 체크한다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice01(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType004DBDAO.validateEDIInvoice01 - ########################################### ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String rjctRmk = "";
		
		try {
			if ( tesEdiSoHdrVO != null ){
				
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				
				if ( mapVO != null ) {
					param.putAll( mapVO );
				}
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType004DBDAOValidateEDIInvoice01RSQL(), param, null);
				
				while (dbRowset.next()){
					for(int j=0; j<dbRowset.getMetaData().getColumnCount(); j++){
						if( !"".equals(dbRowset.getString(j+1)) ){
							if (rjctRmk.trim().equals("")) {
								rjctRmk = dbRowset.getString(j+1);
							} else {
								rjctRmk = rjctRmk + ", " + dbRowset.getString(j + 1);
							}
						}
					}
				}
				log.error(
						"\n\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
						+ "\n\n --- TESInvoiceCommonDBDAO.validateEDIInvoice01() --- "
						+ "\n			TmlEdiSoOfcCtyCd:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd())
						+ "\n			TmlEdiSoSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq())
						+ "\n			VndrSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq())
						+ "\n			InvNo:"+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())
						+ "\n			rjctRmk:"+JSPUtil.getNull(rjctRmk)
						+ "\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" 
						+ "\n\n"
				);
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
		log.debug("\n END - TESeBillingManageBizType004DBDAO.validateEDIInvoice01 - ########################################### ");
		return rjctRmk;
	}
	
	/**
	 * EDI로 접수된 Invoice의 유효성을 체크한다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice02(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType004DBDAO.validateEDIInvoice02 - ########################################### ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
	
		String rjctRmk = "";
		try {
			if ( tesEdiSoHdrVO != null ){
				
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				
				if ( mapVO != null ) {
					param.putAll( mapVO );
				}
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType004DBDAOValidateEDIInvoice02RSQL(), param, null);

				while (dbRowset.next()){
					for(int j=0; j<dbRowset.getMetaData().getColumnCount(); j++){
						if( !"".equals(dbRowset.getString(j+1)) ){
							if (rjctRmk.trim().equals("")) {
								rjctRmk = dbRowset.getString(j+1);
							} else {
								rjctRmk = rjctRmk + ", " + dbRowset.getString(j + 1);
							}
						}
					}
				}
				log.error(
						"\n\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
						+ "\n\n --- TESeBillingManageBizType004DBDAO.validateEDIInvoice02() --- "
						+ "\n			TmlEdiSoOfcCtyCd:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd())
						+ "\n			TmlEdiSoSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq())
						+ "\n			VndrSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq())
						+ "\n			InvNo:"+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())
						+ "\n			rjctRmk:"+JSPUtil.getNull(rjctRmk)
						+ "\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" 
						+ "\n\n"
				);				
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
		log.debug("\n END - TESeBillingManageBizType004DBDAO.validateEDIInvoice02 - ########################################### ");
		return rjctRmk;
	}	

	/**
	 * EDI로 접수된 Invoice HDR를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTesTmlSoHdr( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType004DBDAO.convertEDIInvoiceTesTmlSoHdr() \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try {
			if ( tesEdiSoHdrVO==null ||
					(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoSeq().trim()) ||
					 tesEdiSoHdrVO.getTmlSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlSoSeq().trim())) )
			{
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageDBDAO", "convertEDIInvoiceTesTmlSoHdr"} ).getMessage());
			}
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType004DBDAOConvertEDIInvoiceTesTmlSoHdrCSQL(), param, velParam);
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.convertEDIInvoiceTesTmlSoHdr() \n");
	}
	
	/**
	 * EDI로 접수된 Invoice(TEMP)를 실제 VVD로 옮긴다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoice2TmlVVDList(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType004DBDAO.convertEDIInvoice2TmlVVDList() \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( tesEdiSoHdrVO==null ||
					(tesEdiSoHdrVO.getTmlSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlSoSeq().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoSeq().trim())) )
			{
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageBizType004DBDAO", "convertEDIInvoiceTmlSoVVDList"} ).getMessage());
			}
			
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlVVDListCSQL(), param, velParam);
			}
			log.debug("\n END - [TESeBillingManageBizType004DBDAO][convertEDIInvoice2VVDList] \n");
		} catch (SQLException se) {
			log.debug("\n SQLException - [TESeBillingManageBizType004DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.debug("\n DAOException - [TESeBillingManageBizType004DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.debug("\n Exception - [TESeBillingManageBizType004DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE - TESeBillingManageBizType004DBDAO.convertEDIInvoice2TmlVVDList() \n");		
	}
	
	/**
	 * EDI로 접수된 Invoice(TEMP)를 실제 DTL로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoice2TmlDtl(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType004DBDAO.convertEDIInvoice2TmlDtl() \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if ( tesEdiSoHdrVO==null ||
					(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoSeq().trim()) ||
					 tesEdiSoHdrVO.getTmlSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlSoSeq().trim())) )
			{
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageBizType004DBDAO", "convertEDIInvoiceTesTmsSoDtl"} ).getMessage());
			}
			
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlDtlCSQL(), param, velParam);
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
		log.debug("\n EEE - TESeBillingManageBizType004DBDAO.convertEDIInvoice2TmlDtl() \n");		
	}

}