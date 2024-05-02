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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.util.TESeBillingManageUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileTagVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.core.layer.event.EventResponse;
//import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public abstract class TESeBillingManageBizType000DBDAO extends DBDAOSupport {
	
	/**
	 * MANUAL CNTR의 SEQUENCE 설정
	 * 
	 * @param hms
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public abstract void updateEDInvoiceMnlCntrListDtlSeq(HashMap<String,String>[] hms, TesEdiSoHdrVO tesEdiInitVO) throws DAOException;

	/**
	 * 주어진 TABLE의 COLUMN을 모두 조회
	 * 
	 * @param tableName
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] getTabColumns(String tableName) throws DAOException {
		
		log.debug("\n bbb -  TESeBillingManageBizType000DBDAO.getTabColumns - ########################################### ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int tabColsSize = 0;
		String[] tabCols = null;
		
		try {
			param.put("table_name", tableName);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOGetTabColumnsRSQL(), param, param);
			
			tabColsSize = dbRowset.getRowCount();
			tabCols = new String[tabColsSize];
			
			int idx = 0;
			while ( dbRowset.next() ){
				tabCols[idx++] = dbRowset.getString("COLUMN_NAME");
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
		log.debug("\n eee -  TESeBillingManageBizType000DBDAO.getTabColumns - ########################################### ");
		
		return tabCols;
	}

	/**
	 * EDI HDR의 SEQ 생성
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String getEdiHdrSoSeq() throws DAOException {	
		log.debug("\n BBB -  TESeBillingManageBizType000DBDAO.getEdiHdrSoSeq - ########################################### ");
		
		DBRowSet dbRowset = null;

		String so_seq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOGetEdiHdrSoSeqRSQL(), null, null);

			if ( dbRowset != null && dbRowset.next()){
				so_seq = dbRowset.getString("EDI_HDR_SO_MAX_SEQ");
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
		log.debug("\n EEE -  TESeBillingManageBizType000DBDAO.getEdiHdrSoSeq - ########################################### ");
		
		return so_seq;
	}
	
	/**
	 * EDI data 임시 table에 저장
	 * ~~ 현재 그냥 단일 QUERY를 수행하는것을 차후에는 성능을 고려해서 목록을 전부 list화해서 executeBatch로 뺄 예정 ~~
	 * 
	 * @param tesEdiRcvFltFileTagVO
	 * @param hms
	 * @param tab_cols
	 * @param exc_cols_n_val
	 * @param tesEdiInitVO
	 * @throws DAOException
	 */
	public void saveEDInvoiceTmpData(ComTesEdiRcvFltFileTagVO tesEdiRcvFltFileTagVO, HashMap<String, String>[] hms, String[] tab_cols, String[][] exc_cols_n_val, TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n BBB -  TESeBillingManageBizType000DBDAO.saveEDInvoiceTmpData - ########################################### ");

		try {
			String vtmp = null;
			
			log.debug("\n  getTblNm: "+JSPUtil.getNull(tesEdiRcvFltFileTagVO.getTblNm())+" ---------------------------- \n");
			
			if (hms != null){
				if (tesEdiRcvFltFileTagVO!=null && tesEdiRcvFltFileTagVO.getTblNm()!=null && !tesEdiRcvFltFileTagVO.getTblNm().trim().equals("")){
					ArrayList colNmArrL 	= new ArrayList();
					ArrayList colValArrL 	= null;
					
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();	
					
					/**
					 * Manual CNTR List 대상 DTL seq를 HMS에 update
					 */
					if (tesEdiRcvFltFileTagVO.getMnlCntrRcvTagFlg()!=null && tesEdiRcvFltFileTagVO.getMnlCntrRcvTagFlg().equals("Y")){
						updateEDInvoiceMnlCntrListDtlSeq(hms, tesEdiInitVO);	
					}
					
					/**
					 * QUERY 구성 
					 */
					for (int j=0; tab_cols!=null && j<tab_cols.length; j++){
						if (tab_cols[j]!=null && !tab_cols[j].trim().equals("")){
							colNmArrL.add(tab_cols[j]);
						}
					}
					
					/**
					 * QUERY에 변수 채우기
					 */
					for (int h=0; hms!=null && h<hms.length; h++){
						if (hms[h]!=null){
							
							vtmp = null;
							colValArrL 	= new ArrayList();
							
							for (int j=0; tab_cols!=null && j<tab_cols.length; j++){
								if (tab_cols[j]!=null && !tab_cols[j].trim().equals("")){
									vtmp = TESeBillingManageUtil.checkExcColumn(exc_cols_n_val,tab_cols[j]);
									if (vtmp!=null && !vtmp.trim().equals("")){
										log.debug(JSPUtil.getNull(vtmp));
										colValArrL.add(vtmp);
									} else {
										if (hms[h].containsKey(tab_cols[j])){
											colValArrL.add("'"+hms[h].get(tab_cols[j])+"'");
										} else {
											colValArrL.add("null");
										}
									}
								}
							}
							velParam.put("table_name", JSPUtil.getNull(tesEdiRcvFltFileTagVO.getTblNm()));
							if(colNmArrL.size()>0){
								velParam.put("colum_name", colNmArrL);
							}
							if(colValArrL.size()>0){
								velParam.put("colum_value", colValArrL);
							}
							new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOSaveEDInvoiceTmpDataCSQL(), param, velParam);
						}
					}					
				}
			}

			log.debug("\n EEE -  TESeBillingManageBizType000DBDAO.saveEDInvoiceTmpData - ########################################### ");
			
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
	}
	
	/**
	 * cost ofc update하기
	 * 
	 * @param tesEdiInitVO
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoiceTmpCostOfc(TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType000DBDAO.updateEDInvoiceTmpCostOfc - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tesEdiInitVO != null ) {
				param.put("tml_edi_so_ofc_cty_cd", tesEdiInitVO.getTmlEdiSoOfcCtyCd());
				param.put("tml_edi_so_seq", tesEdiInitVO.getTmlEdiSoSeq());
				param.put("inv_ofc_cd", tesEdiInitVO.getInvOfcCd());
				param.put("yd_cd", tesEdiInitVO.getYdCd());
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOupdateEDInvoiceTmpCostOfcUSQL(), param, null);
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
	
	/**
	 * Storage invoice의 경우 FM PRD/TO PRD가 빠진 경우 EDI RULE에 따라 UPDATE한다.
	 * 
	 * @param tesEdiInitVO
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoiceTmpFmToDt(TesEdiSoHdrVO tesEdiInitVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType000DBDAO.updateEDInvoiceTmpFmToDt - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( tesEdiInitVO != null ) {
				param.put("tml_edi_so_ofc_cty_cd", tesEdiInitVO.getTmlEdiSoOfcCtyCd());
				param.put("tml_edi_so_seq", tesEdiInitVO.getTmlEdiSoSeq());
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOUpdateEDInvoiceTmpFmToDtUSQL(), param, null);
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
	
	
	/**
	 * 약속된 VNDR Tariff로 COST CODE UPDATE
	 * 
	 * @param invVO
	 * @return int
	 * @throws DAOException
	 */
	public int updateEDInvoiceDTLTmpLGSCostCode(TesEdiSoHdrVO invVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType000DBDAO.updateEDInvoiceDTLTmpLGSCostCode - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			if ( invVO != null ) {
				param.put("tml_edi_so_ofc_cty_cd", invVO.getTmlEdiSoOfcCtyCd());
				param.put("tml_edi_so_seq", invVO.getTmlEdiSoSeq());
				param.put("vndr_seq", invVO.getVndrSeq());
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOupdateEDInvoiceDTLTmpLGSCostCodeUSQL(), param, null);
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
		log.debug("\n END - TESeBillingManageBizType000DBDAO.updateEDInvoiceDTLTmpLGSCostCode - ########################################### ");
		
		return updCnt;
	}
	
	/**
	 * 수동 비용의 경우 DTL별 INV AMT 누락시 RATE * VOL으로 넣어준다
	 * @param invVO
	 * @return
	 * @throws DAOException
	 */
	public int updateEDInvoiceDTLInvAmt(TesEdiSoHdrVO invVO) throws DAOException {
		log.debug("\n BEGIN - TESeBillingManageBizType000DBDAO.updateEDInvoiceDTLInvAmt - ########################################### ");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		
		try {
			if ( invVO != null ) {
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(invVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(invVO.getTmlEdiSoSeq()));
				param.put("tml_inv_edi_seq", JSPUtil.getNull(invVO.getTmlInvEdiSeq()));
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOUpdateEDInvoiceDTLInvAmtUSQL(), param, null);
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
		log.debug("\n END - TESeBillingManageBizType000DBDAO.updateEDInvoiceDTLInvAmt - ########################################### ");
		return updCnt;
	}	
	

	/**
	 * EDI로 접수된 Invoice의 유효성을 체크한다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice01(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.validateEDIInvoice01() \n");	
		
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
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOValidateEDIInvoice01RSQL(), param, null);
				
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
						+ "\n\n --- TESeBillingManageBizType000DBDAO.validateEDIInvoice01() --- "
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.validateEDIInvoice01() \n");
		
		return rjctRmk;
	}
	
	/**
	 * EDI로 접수된 Invoice VVD의 유효성을 체크한다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice02(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.validateEDIInvoice02() \n");
		
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
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOValidateEDIInvoice02RSQL(), param, null);

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
						+ "\n\n --- TESeBillingManageBizType000DBDAO.validateEDIInvoice02() --- "
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.validateEDIInvoice02() \n");
		
		return rjctRmk;
	}	

	
	/**
	 * 2009-08-27 [PJM-200900072] : EDI Invoice 유효성 확인시 사용하던 autoRejectEDIInvoice제거하고 setEDIInvoiceValidSts를 추가
	 * EDI Invoice Validation 확인 작업을 한 결과 표시(VLD_CHK_FLG)
	 * EDI Invoice Validation 결과 Auto Reject(AJ) 대상인 Invoice의 상태를 'AJ'로 바꿔주고
	 * Reject 사유를 업데이트 시킨다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @param rjctRmk
	 * @exception DAOException
	 */
	public void setEDIInvoiceValidSts(TesEdiSoHdrVO tesEdiSoHdrVO, String rjctRmk) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.setEDIInvoiceValidSts() \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( tesEdiSoHdrVO != null ){
				
				tesEdiSoHdrVO.setInvRjctRmk(JSPUtil.getNull(rjctRmk));
				
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				
				if ( mapVO != null ) {
					param.putAll( mapVO );
				}				

				log.error(
						"\n\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
						+ "\n\n --- TESInvoiceCommonDBDAO.setEDIInvoiceValidSts() --- "
						+ "\n			TmlEdiSoOfcCtyCd:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd())
						+ "\n			TmlEdiSoSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq())
						+ "\n			VndrSeq:"+JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq())
						+ "\n			InvNo:"+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())
						+ "\n			rjctRmk:"+JSPUtil.getNull(rjctRmk)
						+ "\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" 
						+ "\n\n"
				);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOSetEDIInvoiceValidStsUSQL(), param, null);

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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.setEDIInvoiceValidSts() \n");
	}
	
	/**
	 * 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void checkRegularInvoiceDup( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.checkRegularInvoiceDup() \n");
		
		DBRowSet dbRs = null;
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if (tesEdiSoHdrVO != null){
				param.put("vndr_seq", JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq()));
				param.put("inv_no", JSPUtil.getNull(tesEdiSoHdrVO.getInvNo()));

				dbRs = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOCheckRegularInvoiceDupRSQL(), param, velParam);
				
				if (dbRs!=null && dbRs.getRowCount()>0){
					throw new DAOException(new ErrorHandler("TES00079", new String[]{JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())} ).getMessage());
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.checkRegularInvoiceDup() \n");
	}
	
	/**
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * tml_edi_so_ofc_cty_cd가 정규 invoice인 TES_TML_SO_HDR가 됨 (동일구조)
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceGetTMLSoSeq( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.convertEDIInvoiceGetTMLSoSeq() \n");

		DBRowSet dbRs = null;
		String seq = null;
		
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if (tesEdiSoHdrVO != null){
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				
				dbRs = new SQLExecuter("").executeQuery((ISQLTemplate)new TESeBillingManageBizType000DBDAOConvertEDIInvoiceGetTMLSoSeqRSQL(), param, velParam);
				
				if ( dbRs!=null && dbRs.next() ){
					if ((seq = dbRs.getString("SEQ"))!=null){
						tesEdiSoHdrVO.setTmlSoOfcCtyCd(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd());
						tesEdiSoHdrVO.setTmlSoSeq(seq);				
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.convertEDIInvoiceGetTMLSoSeq() \n");
	}
	
	/**
	 * EDI로 접수된 Invoice HDR를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTesTmlSoHdr( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.convertEDIInvoiceTesTmlSoHdr() \n");
		
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
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOConvertEDIInvoiceTesTmlSoHdrCSQL(), param, velParam);
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
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceUpdateTesEdiSoHdr(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.convertEDIInvoiceUpdateTesEdiSoHdr() \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( tesEdiSoHdrVO==null ||
					(tesEdiSoHdrVO.getTmlSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd().trim()) ||
					 tesEdiSoHdrVO.getTmlEdiSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlEdiSoSeq().trim()) ||
					 tesEdiSoHdrVO.getTmlSoSeq()==null || "".equals(tesEdiSoHdrVO.getTmlSoSeq().trim())) )
			{
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageDBDAO", "convertEDIInvoiceUpdateTesEdiSoHdr"} ).getMessage());
			}
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOConvertEDIInvoiceUpdateTesEdiSoHdrUSQL(), param, velParam);
			}
		}  catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.convertEDIInvoiceUpdateTesEdiSoHdr() \n");
	}
	
	/**
	 * EDI로 접수된 Invoice VVD를 실제 SO Table로 옮긴다.
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoice2TmlVVDList(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.convertEDIInvoice2TmlVVDList() \n");
		
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
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageBizType000DBDAO", "convertEDIInvoiceTmlSoVVDList"} ).getMessage());
			}
			
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOConvertEDIInvoice2TmlVVDListCSQL(), param, velParam);
			}
			log.debug("\n END - [TESeBillingManageBizType000DBDAO][convertEDIInvoice2VVDList] \n");
		} catch (SQLException se) {
			log.debug("\n SQLException - [TESeBillingManageBizType000DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.debug("\n DAOException - [TESeBillingManageBizType000DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.debug("\n Exception - [TESeBillingManageBizType000DBDAO][convertEDIInvoice2VVDList] \n");
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.convertEDIInvoice2TmlVVDList() \n");		
	}
	
	/**
	 * EDI로 접수된 Invoice DTL을 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * 
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoice2TmlDtl(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n BBB - TESeBillingManageBizType000DBDAO.convertEDIInvoice2TmlDtl() \n");
		
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
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESeBillingManageBizType000DBDAO", "convertEDIInvoiceTesTmsSoDtl"} ).getMessage());
			}
			
			if (tesEdiSoHdrVO != null){
				param.put("tml_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoOfcCtyCd()));
				param.put("tml_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlSoSeq()));
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(tesEdiSoHdrVO.getTmlEdiSoSeq()));
				param.put("cre_usr_id", JSPUtil.getNull(tesEdiSoHdrVO.getCreUsrId()));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESeBillingManageBizType000DBDAOConvertEDIInvoice2TmlDtlCSQL(), param, velParam);
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
		log.debug("\n EEE - TESeBillingManageBizType000DBDAO.convertEDIInvoice2TmlDtl() \n");		
	}

}