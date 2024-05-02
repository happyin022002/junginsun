/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInterfaceManageDBDAO.java
*@FileTitle : TDR_RESTOW Data Interface to VSK_TDR_RHND
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-12-08 kimjinjoo
* 1.0 최초 생성
* 2009-03-17 [R200903110001] : LDM review결과로 TES_EDI_SO_COST table PK 구조 변경건 적용  
* 2009-08-27 [PJM-200900072] : EDI Invoice HDR 임시 저장하기에 부산신항만(180020) 추가
*							   EDI Invoice CNTR LIST 임시 저장하기에 부산신항만(180020) 추가
*							   EDI Invoice DTL LIST 임시 저장하기에 부산신항만(180020) 추가
*							       부산신항만(180020)용으로 EDI Invoice MANUAL CNTR LIST 임시 저장하기 기능 추가
*                              EDI Invoice Tariff Code 전환 조건 수정
*                              부산신항만(180020)용으로 MANUAL CNTR의 소속 DTL SEQ를 구하기
*                              부산신항만(180020) VNDR의 OFC_CD조회
*                              부산신항만(180020) STORAGE의 SEQUENCE조회용
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tesinterface.basic.TESInterfaceManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimjinjoo
 * @see TESInterfaceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class TESInterfaceManageDBDAO extends DBDAOSupport {

	/**
	 * TES_EDI_SO_HDR_SEQ 테이블의 nextval 가져온다.
	 * 시간되면 이 SO_SEQ는 DB SEQUENCE로 변경할 것.. 임시로 MAX(~)로 처리합니다. 귀찮아서리...
	 * @param EventResponse er
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void getSoSeq(EventResponse er) throws DAOException {	
		
		DBRowSet dbRowset = null;

        GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		String soSeq = "";
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInterfaceManageDBDAOGetSoSeqRSQL(), null, null);

			if ( dbRowset != null && dbRowset.next()){
				soSeq = dbRowset.getString("SO_MAX_SEQ");
			}
			
        	hdr.put("TML_EDI_SO_SEQ",soSeq);			
        	log.info("\n [getSoSeq]TML_EDI_SO_SEQ : " + hdr.get("TML_EDI_SO_SEQ") );
        	
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
	 * 2009-08-27 [PJM-200900072] : EDI Invoice HDR 임시 저장하기에 부산신항만(180020) 추가
	 * EDI Invoice HDR 임시 저장하기
	 * @param EventResponse er
	 * @param String[] tabCols
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createEDInvoiceHDRTmpData(EventResponse er, String[] tabCols) throws DAOException {

		log.error("\n\n BEGIN - DAO.createEDInvoiceHDRTmpData - ########################################### ");
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		//String FM_VNDR_SEQ = JSPUtil.getNull( (String)eventResponse.getCustomData("FMVNDR") );
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		String tml_edi_so_seq 		= hdr!=null&&hdr.containsKey("TML_EDI_SO_SEQ")?JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ")):"";
		String inv_ofc_cd 			= hdr!=null&&hdr.containsKey("INV_OFC_CD")?JSPUtil.getNull((String)hdr.get("INV_OFC_CD")):"";
		String tml_edi_so_ofc_cty_cd= hdr!=null&&hdr.containsKey("TML_EDI_SO_OFC_CTY_CD")?JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD")):"";
		String vndr_seq 			= hdr!=null&&hdr.containsKey("VNDR_SEQ")?JSPUtil.getNull((String)hdr.get("VNDR_SEQ")):"";
		String inv_no 	    		= hdr!=null&&hdr.containsKey("INV_NO")?JSPUtil.getNull((String)hdr.get("INV_NO")):"";

		log.debug("\n DAO.createEDInvoiceHDRTmpData - tml_edi_so_seq:"+tml_edi_so_seq);		
		log.debug("\n DAO.createEDInvoiceHDRTmpData - inv_ofc_cd:"+inv_ofc_cd);		
		log.debug("\n DAO.createEDInvoiceHDRTmpData - tml_edi_so_ofc_cty_cd:"+tml_edi_so_ofc_cty_cd);		
		log.debug("\n DAO.createEDInvoiceHDRTmpData - vndr_seq:"+vndr_seq);		
		log.debug("\n DAO.createEDInvoiceHDRTmpData - inv_no:"+inv_no);		
		
		ArrayList colNmArrL 	= null;
		ArrayList colValArrL 	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		/**
		 * <중> inv_ofc_cd가 NULL일 경우 -> AUTO REJECT처리하고 HDR만 저장하는것을 고려해야 한다.
		 */
		try {
			if (inv_ofc_cd==null || inv_ofc_cd.trim().equals("")){
				throw new Exception("NO OFFICE CODE FOUND FOR "+vndr_seq);
			}
			log.debug("1 - inv_ofc_cd:"+(inv_ofc_cd!=null&&!inv_ofc_cd.trim().equals("")?inv_ofc_cd:""));
			
			if (tml_edi_so_seq==null || tml_edi_so_seq.trim().equals("")){
				throw new Exception("NO EDI SO HDR SEQUENCE CREATED");
			}

			String[][] exc_cols_n_val ={{"TML_EDI_SO_OFC_CTY_CD", "'"+tml_edi_so_ofc_cty_cd+"'"},
									    {"TML_EDI_SO_SEQ", tml_edi_so_seq},
									    {"INV_OFC_CD", "'"+inv_ofc_cd+"'"},
									    {"TML_SO_OFC_CTY_CD", "''"},
									    {"TML_SO_SEQ", "''"},
									    {"RCV_DT", "TO_CHAR(SYSDATE,'YYYYMMDD')"},
									    {"TML_INV_STS_CD", "'R'"},
									    {"TML_INV_RJCT_STS_CD", "'AJ'"}, //기본값으로 AutoReject상태로 설정하고 나중에 검사과정 이후 이상이 없으면 NL(정상)으로 돌린다.
									    {"DELT_FLG", "'N'"},
									    {"VLD_CHK_FLG", "'N'"},
									    {"CRE_USR_ID", "'eNIS_TES'"},
									    {"CRE_DT", "SYSDATE"},
									    {"UPD_USR_ID", "'eNIS_TES'"},
									    {"UPD_DT", "SYSDATE"},
									    {"LOCL_CRE_DT", "GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('"+inv_ofc_cd+"')"},
									    {"LOCL_UPD_DT", "GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('"+inv_ofc_cd+"')"}};
								
			String vtmp = null;
			
			if (hdr != null){

				colNmArrL 	= new ArrayList();
				colValArrL 	= new ArrayList();
				
				/**
				 * QUERY에 구성
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						colNmArrL.add(tabCols[j]);
					}
				}
				
				/**
				 * QUERY에 BIND 변수 채우기
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						if ((vtmp=checkExcColumn(exc_cols_n_val,tabCols[j]))!=null){
							log.debug(JSPUtil.getNull(vtmp));
							colValArrL.add(vtmp);
						} else {
							if (hdr.containsKey(tabCols[j])){
								if (tabCols[j]!=null && (tabCols[j].trim().equals("IB_VVD_CD") || tabCols[j].trim().equals("OB_VVD_CD"))){
									colValArrL.add("SUBSTR('"+hdr.get(tabCols[j])+"',1,9) ");
								} else {
									if(hdr.get(tabCols[j])==null || hdr.get(tabCols[j]).equals("")){
										colValArrL.add("null");
									}else{
										colValArrL.add("'"+hdr.get(tabCols[j])+"'");
									}
								}

							} else {
								colValArrL.add("null");
							}
						}
					}
				}

				if(colNmArrL.size()>0){
					velParam.put("colum_name", colNmArrL);
				}
				if(colValArrL.size()>0){
					velParam.put("colum_value", colValArrL);
				}
				
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOCreateEDInvoiceHDRTmpDataCSQL(), param, velParam);

				log.debug("\n\n END - DAO.createEDInvoiceHDRTmpData - ########################################### ");				
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
	}
	
	/**
	 * 2009-08-27 [PJM-200900072] : EDI Invoice DTL LIST 임시 저장하기에 부산신항만(180020) 추가
	 * EDI Invoice CNTR LIST 임시 저장하기
	 * @param EventResponse er
	 * @param String[] tabCols
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createEDInvoiceCNTRTmpData(EventResponse er, String[] tabCols) throws DAOException {
		log.debug("test232 LINE");
		log.debug("\n\n\n\n\n BEGIN - DAO.createEDInvoiceCNTRTmpData - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr 	= (HashMap<String, String>)eventResponse.getCustomData("HDR");
		HashMap<String, String>[] cntrs = (HashMap<String, String>[])eventResponse.getCustomData("CNTRs");
		
		log.debug(" CNTRs.length: "+(cntrs!=null?cntrs.length:0)+"<<<<<<");
		log.debug(" ###$$ TML_EDI_SO_OFC_CTY_CD:"+(String)hdr.get("TML_EDI_SO_OFC_CTY_CD")+"~~~~~~~~~~~~~~~~~~~~~~");
		log.debug(" ###$$ TML_EDI_SO_SEQ:"+(String)hdr.get("TML_EDI_SO_SEQ")+"~~~~~~~~~~~~~~~~~~~~~~");
		
		try {
			String[][] exc_cols_n_val ={{"TML_EDI_SO_OFC_CTY_CD", "'"+JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD"))+"'"},
									    {"TML_EDI_SO_SEQ", JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ"))},
									    {"TML_EDI_SO_CNTR_LIST_SEQ", "TES_EDI_SO_CNTR_LIST_SEQ.NEXTVAL"},
									    {"CRE_USR_ID", "'eNIS_TES'"},
									    {"CRE_DT", "SYSDATE"},
									    {"UPD_USR_ID", "'eNIS_TES'"},
									    {"UPD_DT", "SYSDATE"}};

			String vtmp = null;

			if (cntrs != null){
				ArrayList colNmArrL 	= new ArrayList();
				ArrayList colValArrL 	= null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				/**
				 * QUERY 구성 
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						colNmArrL.add(tabCols[j]);
					}
				}
				
				/**
				 * QUERY에 BIND 변수 채우기
				 */
				for (int h=0; cntrs!=null && h<cntrs.length; h++){
					if (cntrs[h]!=null){
						vtmp = null;		
						colValArrL 	= new ArrayList();
						
						for (int j=0; tabCols!=null && j<tabCols.length; j++){
							if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
								if ((vtmp=checkExcColumn(exc_cols_n_val,tabCols[j]))!=null){
									log.debug(JSPUtil.getNull(vtmp));
									colValArrL.add(vtmp);
								} else {
									if (cntrs[h].containsKey(tabCols[j])){
										if (tabCols[j]!=null && (tabCols[j].trim().equals("IB_VVD_CD") || tabCols[j].trim().equals("OB_VVD_CD"))){
											colValArrL.add("SUBSTR('"+JSPUtil.getNull(cntrs[h].get(tabCols[j]))+"',1,9) ");
										} else {
											colValArrL.add("'"+cntrs[h].get(tabCols[j])+"'");	
										}
										
									} else {
										colValArrL.add("null");
									}
								}
							}
						}
						
						if(colNmArrL.size()>0){
							velParam.put("colum_name", colNmArrL);
						}
						if(colValArrL.size()>0){
							velParam.put("colum_value", colValArrL);
						}
						log.debug("==============================TESInterfaceManageDBDAOCreateEDInvoiceCNTRTmpDataCSQL실행==========");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOCreateEDInvoiceCNTRTmpDataCSQL(), param, velParam);
					}
				}
				
			}

			log.debug("\n\n END - DAO.createEDInvoiceCNTRTmpData - ADDBATCH ########################################### ");
			
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
	 * EDI Invoice DTL LIST 임시 저장하기
	 * @param EventResponse er
	 * @param String[] tabCols
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createEDInvoiceDTLTmpData(EventResponse er, String[] tabCols) throws DAOException {
		log.debug("test336 line");
		log.debug("\n\n BEGIN - DAO.createEDInvoiceDTLTmpData - ########################################### ");

		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr 	= (HashMap<String, String>)eventResponse.getCustomData("HDR");
		HashMap<String, String>[] dtls = (HashMap<String, String>[])eventResponse.getCustomData("DTLs");
		
		log.debug(" DTLs.length: "+(dtls!=null?dtls.length:0)+"<<<<<<");
		log.debug(" ###$$ TML_EDI_SO_OFC_CTY_CD:"+(String)hdr.get("TML_EDI_SO_OFC_CTY_CD")+"~~~~~~~~~~~~~~~~~~~~~~");
		log.debug(" ###$$ TML_EDI_SO_SEQ:"+(String)hdr.get("TML_EDI_SO_SEQ")+"~~~~~~~~~~~~~~~~~~~~~~");
		
		try {
			String[][] exc_cols_n_val ={{"TML_EDI_SO_OFC_CTY_CD", "'"+JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD"))+"'"},
									    {"TML_EDI_SO_SEQ", JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ"))},
									    {"TML_EDI_SO_DTL_SEQ", "TES_EDI_SO_DTL_SEQ.NEXTVAL"},
									    {"CRE_USR_ID", "'eNIS_TES'"},
									    {"CRE_DT", "SYSDATE"},
									    {"UPD_USR_ID", "'eNIS_TES'"},
									    {"UPD_DT", "SYSDATE"}};

			String vtmp = null;
			
			if (dtls != null){
				ArrayList colNmArrL 	= new ArrayList();
				ArrayList colValArrL 	= null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				/**
				 * QUERY 구성 
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						colNmArrL.add(tabCols[j]);
					}
				}
				
				for (int h=0; dtls!=null && h<dtls.length; h++){
					if (dtls[h]!=null){
						
						vtmp = null;		
						colValArrL 	= new ArrayList();
						
						for (int j=0; tabCols!=null && j<tabCols.length; j++){
							if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
								if ((vtmp=checkExcColumn(exc_cols_n_val,tabCols[j]))!=null){
									log.debug(JSPUtil.getNull(vtmp));
									colValArrL.add(vtmp);
								} else {
									if (dtls[h].containsKey(tabCols[j])){
										if (tabCols[j]!=null && (tabCols[j].trim().equals("IB_VVD_CD") || tabCols[j].trim().equals("OB_VVD_CD"))){
											colValArrL.add("SUBSTR('"+JSPUtil.getNull(dtls[h].get(tabCols[j]))+"',1,9) ");
										} else {
											colValArrL.add("'"+dtls[h].get(tabCols[j])+"'");	
										}
										
									} else {
										colValArrL.add("null");
									}
								}
							}
						}
		
						if(colNmArrL.size()>0){
							velParam.put("colum_name", colNmArrL);
						}
						if(colValArrL.size()>0){
							velParam.put("colum_value", colValArrL);
						}
						log.debug("=============================TESInterfaceManageDBDAOCreateEDInvoiceDTLTmpDataCSQL실행================");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOCreateEDInvoiceDTLTmpDataCSQL(), param, velParam);
					}
				}
				
			}

			log.debug("\n\n END - DAO.createEDInvoiceDTLTmpData ADDBATCH - ########################################### ");
			
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
	 * 2009-08-27 [PJM-200900072] : 부산신항만(180020)용으로 EDI Invoice MANUAL CNTR LIST 임시 저장하기 기능 추가
	 * EDI Invoice MANUAL CNTR LIST 임시 저장하기
	 * <중> MANUAL CNTR는 반드시 DTL이 저장된 뒤에 저장하기를 수행해야한다. -> DTL의 EDI_SO_DTL_ID이란 값과 MAPPING되는 넘이 있어야 MANUAL CNTR가 존재할 수 있다.
	 * @param EventResponse er
	 * @param String[] tabCols
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createEDInvoiceMNLCNTRTmpData(EventResponse er, String[] tabCols) throws DAOException {
		log.debug("\n\n\n\n\n BEGIN - DAO.createEDInvoiceMNLCNTRTmpData - ########################################### ");
				
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr 	= (HashMap<String, String>)eventResponse.getCustomData("HDR");
		HashMap<String, String>[] mnlCntrs = (HashMap<String, String>[])eventResponse.getCustomData("MNL_CNTRs");		
		
		log.debug(" MNL_CNTRs.length: "+(mnlCntrs!=null?mnlCntrs.length:0)+"<<<<<<");
		log.debug(" ###$$ TML_EDI_SO_OFC_CTY_CD:"+(String)hdr.get("TML_EDI_SO_OFC_CTY_CD")+"~~~~~~~~~~~~~~~~~~~~~~");
		log.debug(" ###$$ TML_EDI_SO_SEQ:"+(String)hdr.get("TML_EDI_SO_SEQ")+"~~~~~~~~~~~~~~~~~~~~~~");
		
		try {
			/**
				 TML_EDI_SO_OFC_CTY_CD		
				 TML_EDI_SO_SEQ			
				 EDI_SO_DTL_ID
				 세개의 값으로 TML_EDI_SO_DTL에서 TML_EDI_SO_DTL_SEQ를 가져와서 넣는다.
				 TML_EDI_SO_DTL_SEQ가 없는 경우는 INSERT를 수행하지 않는다. 			
			 */
			String[][] exc_cols_n_val ={{"TML_EDI_SO_OFC_CTY_CD", "'"+JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD"))+"'"},
									    {"TML_EDI_SO_SEQ", JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ"))},
									    {"TML_EDI_SO_MNL_CNTR_LIST_SEQ", "TES_EDI_SO_MNL_CNTR_LIST_SEQ.NEXTVAL"},
									    {"CRE_USR_ID", "'eNIS_TES'"},
									    {"CRE_DT", "SYSDATE"},
									    {"UPD_USR_ID", "'eNIS_TES'"},
									    {"UPD_DT", "SYSDATE"}};

			String vtmp = null;
			String dtl_seq = null;
			
			if (mnlCntrs != null){
			    //인자값들이 들어감
				ArrayList colNmArrL 	= new ArrayList();
				ArrayList colValArrL 	= null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				for (int k=0; mnlCntrs!=null && k<mnlCntrs.length; k++){
					if (mnlCntrs[k]!=null && mnlCntrs[k].containsKey("EDI_SO_DTL_ID") && mnlCntrs[k].get("EDI_SO_DTL_ID")!=null && !mnlCntrs[k].get("EDI_SO_DTL_ID").equals("")){
						if ((dtl_seq = getEDIDTLseq(JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD")),JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ")),(String)mnlCntrs[k].get("EDI_SO_DTL_ID")))!=null){
							mnlCntrs[k].put("TML_EDI_SO_DTL_SEQ", dtl_seq);
						}
						log.debug("\n MNL_CNTRs["+k+"] EDI_SO_DTL_ID : " + mnlCntrs[k].get("EDI_SO_DTL_ID")+"<<<<<<< \n");
						log.debug("\n MNL_CNTRs["+k+"] TML_EDI_SO_DTL_SEQ : " + mnlCntrs[k].get("TML_EDI_SO_DTL_SEQ")+"<<<<<<< \n");
						log.debug("\n DTL_SEQ - getEDIDTLseq :" + dtl_seq +"<<<<<<< \n");
						//log.debug("\n DTL_SEQ - getEDIDTLseq :" + getEDIDTLseq(con, JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD")),JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ")),(String)mnlCntrs[k].get("EDI_SO_DTL_ID"))+"<<<<<<< \n");
					}
				}
				
				/**
				 * QUERY 구성 
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						colNmArrL.add(tabCols[j]);
					}
				}

				/**
				 * QUERY에 BIND 변수 채우기
				 */
				for (int h=0; mnlCntrs!=null && h<mnlCntrs.length; h++){
					if (mnlCntrs[h]!=null){
						
						vtmp = null;		
						colValArrL 	= new ArrayList();
						
						for (int j=0; tabCols!=null && j<tabCols.length; j++){
							if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
								if ((vtmp=checkExcColumn(exc_cols_n_val,tabCols[j]))!=null){
									log.debug(JSPUtil.getNull(vtmp));
									colValArrL.add(vtmp);
								} else {
									if (mnlCntrs[h].containsKey(tabCols[j])){
										if (tabCols[j]!=null && tabCols[j].trim().equals("TML_EDI_SO_DTL_SEQ")){
											colValArrL.add(JSPUtil.getNull(mnlCntrs[h].get("TML_EDI_SO_DTL_SEQ")));
										} else {
											colValArrL.add("'"+mnlCntrs[h].get(tabCols[j])+"'");	
										}
										
									} else {
										colValArrL.add("null");
									}
								}
							}
						}
		
						if(colNmArrL.size()>0){
							velParam.put("colum_name", colNmArrL);
						}
						if(colValArrL.size()>0){
							velParam.put("colum_value", colValArrL);
						}
						
						if (mnlCntrs[h].get("TML_EDI_SO_DTL_SEQ")!=null && !((String)mnlCntrs[h].get("TML_EDI_SO_DTL_SEQ")).equals("")) {
							new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOCreateEDInvoiceMNLCNTRTmpDataCSQL(), param, velParam);
						}
					}
				}
				
			}

			log.debug("\n\n END - DAO.createEDInvoiceMNLCNTRTmpData - ADDBATCH ########################################### ");
			
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
	 * EDI Invoice AUTO FREE POOL LIST 임시 저장하기
	 * @param EventResponse er
	 * @param String[] tabCols
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createEDInvoiceAUTOFPTmpData(EventResponse er, String[] tabCols) throws DAOException {
		log.debug("\n\n\n\n\n BEGIN - DAO.createEDInvoiceAUTOFPTmpData - ########################################### ");	
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr 	= (HashMap<String, String>)eventResponse.getCustomData("HDR");
		HashMap<String, String>[] autoFps = (HashMap<String, String>[])eventResponse.getCustomData("AUTO_FPs");		
		
		log.debug(" AUTO_FPs.length: "+(autoFps!=null?autoFps.length:0)+"<<<<<<");
		log.debug(" ###$$ TML_EDI_SO_OFC_CTY_CD:"+(String)hdr.get("TML_EDI_SO_OFC_CTY_CD")+"~~~~~~~~~~~~~~~~~~~~~~");
		log.debug(" ###$$ TML_EDI_SO_SEQ:"+(String)hdr.get("TML_EDI_SO_SEQ")+"~~~~~~~~~~~~~~~~~~~~~~");
		
		try {
			String[][] exc_cols_n_val ={{"TML_EDI_SO_OFC_CTY_CD", "'"+JSPUtil.getNull((String)hdr.get("TML_EDI_SO_OFC_CTY_CD"))+"'"},
									    {"TML_EDI_SO_SEQ", JSPUtil.getNull((String)hdr.get("TML_EDI_SO_SEQ"))},
									    {"TML_EDI_SO_AUTO_FP_LIST_SEQ", "TES_EDI_SO_AUTO_FREE_POOL_SEQ.NEXTVAL"},
									    {"CRE_USR_ID", "'eNIS_TES'"},
									    {"CRE_DT", "SYSDATE"},
									    {"UPD_USR_ID", "'eNIS_TES'"},
									    {"UPD_DT", "SYSDATE"}};

			String vtmp = null;

			if (autoFps != null){
				ArrayList colNmArrL 	= new ArrayList();
				ArrayList colValArrL 	= null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				/**
				 * QUERY 구성 
				 */
				for (int j=0; tabCols!=null && j<tabCols.length; j++){
					if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
						colNmArrL.add(tabCols[j]);
					}
				}

				/**
				 * QUERY에 BIND 변수 채우기
				 */
				for (int h=0; autoFps!=null && h<autoFps.length; h++){
					if (autoFps[h]!=null){
						vtmp = null;		
						colValArrL 	= new ArrayList();
						
						for (int j=0; tabCols!=null && j<tabCols.length; j++){
							if (tabCols[j]!=null && !tabCols[j].trim().equals("")){
								if ((vtmp=checkExcColumn(exc_cols_n_val,tabCols[j]))!=null){
									log.debug(JSPUtil.getNull(vtmp));
									colValArrL.add(vtmp);
								} else {
									if (autoFps[h].containsKey(tabCols[j])){
										colValArrL.add("'"+autoFps[h].get(tabCols[j])+"'");	
									} else {
										colValArrL.add("null");
									}
								}
							}
						}
		
						if(colNmArrL.size()>0){
							velParam.put("colum_name", colNmArrL);
						}
						if(colValArrL.size()>0){
							velParam.put("colum_value", colValArrL);
						}
						
						new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOCreateEDInvoiceAUTOFPTmpDataCSQL(), param, velParam);
					}
				}
				
			}

			log.debug("\n\n END - DAO.createEDInvoiceAUTOFPTmpData - ADDBATCH ########################################### ");
			
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
	 * EDI Invoice DB에 넣기가 완료되면 VNDR제공 Tariff Code를 SML기준 LGS COST CODE로 전환한다.
	 * 
	 * @param EventResponse er
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int updateEDInvoiceDTLTmpLGSCostCode(EventResponse er) throws DAOException {

		log.debug("\n\n BEGIN - DAO.updateEDInvoiceDTLTmpLGSCostCode - ########################################### ");
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			
			if ( hdr != null ) {
//				param.putAll( hdr );
				param.put("tml_edi_so_ofc_cty_cd", (String)hdr.get("TML_EDI_SO_OFC_CTY_CD"));
				param.put("tml_edi_so_seq", (String)hdr.get("TML_EDI_SO_SEQ"));
				param.put("vndr_seq", (String)hdr.get("VNDR_SEQ"));
			}

			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOUpdateEDInvoiceDTLTmpLGSCostCodeUSQL(), param, null);
			
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
	 * 2009-08-27 [PJM-200900072] : EDI Invoice Tariff Code 전환 조건 수정
	 * EDI Invoice DB에 넣기가 완료되면 VNDR제공 Tariff Code를 SML기준 LGS COST CODE로 전환한다.
	 * 
	 * @param EventResponse er
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int updateEDInvoiceTmpCostOfc(EventResponse er) throws DAOException {

		log.debug("\n\n BEGIN - DAO.updateEDInvoiceDTLTmpCostOfc - ########################################### ");
		GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

		int updCnt = 0;
		
		try {
			
			if ( hdr != null ) {
//				param.putAll( hdr );	
				param.put("tml_edi_so_ofc_cty_cd", (String)hdr.get("TML_EDI_SO_OFC_CTY_CD"));
				param.put("tml_edi_so_seq", (String)hdr.get("TML_EDI_SO_SEQ"));
				param.put("inv_ofc_cd", (String)hdr.get("INV_OFC_CD"));
				param.put("yd_cd", (String)hdr.get("YD_CD"));
			}

			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInterfaceManageDBDAOUpdateEDInvoiceTmpCostOfcUSQL(), param, null);
			
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
	 * QUERY생성시 제외 대상인지 검사하여 대상인 경우 대상 COLUMN의 넣을 값을 return한다.
	 * @param exc_cols_n_val
	 * @param col
	 * @return String 
	 */
	private String checkExcColumn(String[][] exc_cols_n_val, String col) {

		if (exc_cols_n_val!=null && col!=null){
			for (int k=0; exc_cols_n_val!=null && k<exc_cols_n_val.length; k++){
				if (exc_cols_n_val[k][0]!=null && exc_cols_n_val[k][0].equals(col)){
					return exc_cols_n_val[k][1];
				}
			}
		}
		
		return null; // 일치값이 없을 경우는 반드시 null을 넘길것 - ""도 넘기면 안된당.
	}
	
	/**
	 * 주어진 TABLE의 COLUMN을 모두 조회
	 * @param tableName
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] getTabColumns( String tableName ) throws DAOException {
		
		log.debug("\n\n DAO.getTabColumns - ########################################### ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int tabColsSize = 0;
		String[] tabCols = null;
		
		try {
			param.put("table_name", tableName);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInterfaceManageDBDAOGetTabColumnsRSQL(), param, param);
			
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
		
		return tabCols;
	}
	

	/**
	 * 2009-08-27 [PJM-200900072] : 부산신항만(180020)용으로 MANUAL CNTR의 소속 DTL SEQ를 구하기
	 * @param con
	 * @param tml_edi_so_ofc_cty_cd
	 * @param tml_edi_so_seq
	 * @param edi_so_dtl_id
	 * @return String
	 * @exception DAOException
	 */
	private String getEDIDTLseq(String tml_edi_so_ofc_cty_cd, String tml_edi_so_seq, String edi_so_dtl_id) throws DAOException {
		log.debug("\n\n DAO.getEDIDTLseq - ########################################### ");
		
		String 		retval 		= null;
		DBRowSet 	dbRowset 	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		if (tml_edi_so_ofc_cty_cd==null || tml_edi_so_ofc_cty_cd.trim().equals("") ||
			tml_edi_so_seq==null || tml_edi_so_seq.trim().equals("") ||
			edi_so_dtl_id==null || edi_so_dtl_id.trim().equals("")){
			throw new DAOException("DAO.getEDIDTLseq - invalid arg !!! ");
		}
		
		try {
			param.put("tml_edi_so_ofc_cty_cd", tml_edi_so_ofc_cty_cd);
			param.put("tml_edi_so_seq", tml_edi_so_seq);
			param.put("edi_so_dtl_id", edi_so_dtl_id);
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInterfaceManageDBDAOGetEDIDTLseqRSQL(), param, param);

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
		
		return retval==null||retval.trim().equals("")?null:retval;
	}
	
	/**
	 * 2009-08-27 [PJM-200900072] : 부산신항만(180020) VNDR의 OFC_CD조회
	 * @param EventResponse er
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void getVndrOfcCd( EventResponse er ) throws DAOException {
		
		log.debug("\n\n DAO.getVndrOfcCd - ########################################### ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();

        GeneralEventResponse eventResponse = (GeneralEventResponse)er;
		HashMap<String, String> hdr = (HashMap<String, String>)eventResponse.getCustomData("HDR");
		String vndr_seq = hdr!=null&&hdr.containsKey("VNDR_SEQ")?JSPUtil.getNull((String)hdr.get("VNDR_SEQ")):"";
		String ofcCd = "";
		
		try {
			param.put("vndr_seq", vndr_seq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInterfaceManageDBDAOGetVndrOfcCdRSQL(), param, param);

			if ( dbRowset != null && dbRowset.next()){
				ofcCd = dbRowset.getString("OFC_CD");
			}
			if (ofcCd == null || ofcCd.trim().equals("")){
				throw new Exception("\n\n###################### \n   NO OFFICE CODE FOUND FOR "+vndr_seq+"\n######################\n\n");
			}
			
			hdr.put( "INV_OFC_CD", ofcCd );	
			hdr.put( "TML_EDI_SO_OFC_CTY_CD",ofcCd.substring(0,3) );				
			
        	log.debug("\n X[getVndrOfcCd]TML_EDI_SO_OFC_CTY_CD : " + hdr.get("TML_EDI_SO_OFC_CTY_CD") );
        	log.debug("\n X[getVndrOfcCd]INV_OFC_CD : " + hdr.get("INV_OFC_CD") );
        	
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