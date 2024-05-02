/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonDBDAO.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : 
*@LastVersion : 1.0
* 2006-10-31 
* 1.0 최초 생성
* 2009-03-03 : 성능측정 관련 기능 추가
* 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회  method 추가
* 2011.08.08  [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
* 2015.01.20  [CHM-201430578]TMNL Invoice Manual 입력시 Vol validation 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent;
import com.hanjin.apps.alps.esd.tpb.common.combo.integration.CommonCodeDBDAOSearchGetTesBillingCaseRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;


/**
 * ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author byungheeyoo
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class TESCommonDBDAO extends DBDAOSupport {
	
	/**
	 * [ Bkg No ]을 [Select] 합니다.<br>
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrBkgNo(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(event.getTesCommonVO() != null){
			param.put("atb_dt",event.getTesCommonVO().getAtbDt());
			param.put("vvd",event.getTesCommonVO().getVvd());
		}
		
		if(event.getTesTmlSoHdrVO() != null){
			param.put("yd_cd",event.getTesTmlSoHdrVO().getYdCd());
		}
		
		if(event.getTesTmlSoDtlVO() != null){
			param.put("io_bnd_cd",event.getTesTmlSoDtlVO().getIoBndCd());
			param.put("cntr_no",event.getTesTmlSoDtlVO().getCntrNo());
		}
		
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrBkgNoRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [ Bkg No ]을 [Select] 합니다.<br>
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrBkgNoOff(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(event.getTesTmlSoHdrVO() != null){
			param.put("yd_cd",event.getTesTmlSoHdrVO().getYdCd());
			param.put("to_prd_dt",event.getTesTmlSoHdrVO().getToPrdDt());
			param.put("fm_prd_dt",event.getTesTmlSoHdrVO().getFmPrdDt());
		}
		
		if(event.getTesTmlSoDtlVO() != null){
			param.put("cntr_no",event.getTesTmlSoDtlVO().getCntrNo());
		}
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrBkgNoOffRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회
	 * @param ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMDMCnt_cd(String ofcCd) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getEDIOriginInvoice] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String	cntCd	= "";
		
		try {

			if ( ofcCd != null && !"".equals(ofcCd) ) {
				param	.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetMDMCnt_cdRSQL(), param, velParam);

			if ( dbRowset.next() ){
				cntCd = dbRowset.getString("cnt_cd");
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
		
		log.debug("\n DAO.getMDMCnt_cd \n");

		return JSPUtil.getNull(cntCd);		
	}

	
	/**
	 * 원본 EDI invoice file 정보 조회
	 * @param tesEdiSoFileVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getEDIOriginInvoice(TesEdiSoFileVO tesEdiSoFileVO) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getEDIOriginInvoice] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if(tesEdiSoFileVO != null){
				Map<String, String> mapVO = tesEdiSoFileVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetEDIOriginInvoiceRSQL(), param, velParam);

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
	 * 원본 EDI invoice file 정보를 DB에 입력
	 * @param event
	 * @return String
	 * @exception DAOException
	 */
	public String putEDIOriginInvoice(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][putEDIOriginInvoice] ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(event.getTesEdiSoFileVO() != null){
				Map<String, String> mapVO = event.getTesEdiSoFileVO() .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO() .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO() .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if ( !"".equals( event.getSignOnUserAccount().getUsr_id() ) ) {
				param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				velParam.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			}
			
			int iRet = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOPutEDIOriginInvoiceCSQL(), param, velParam);

			if ( iRet > 0 ) {
				return "SUCCESS";
			} else {
				return "FAILURE";
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
	 * 
	 * @param fVo
	 * @return
	 * @throws DAOException
	 */
	public String putEDIOriginInvoice(TesEdiSoFileVO fVo) throws DAOException {
		log.debug("\n[TESCommonDBDAO][putEDIOriginInvoice] ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (fVo != null){
				Map<String, String> mapVO = fVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int iRet = new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOPutEDIOriginInvoiceCSQL(), param, velParam);

				if (iRet > 0){
					return "SUCCESS";
				} else {
					return "FAILURE";
				}
			} else {
				return "FAILURE";
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
	 * EDI Invoice원본에 mapping되는 invoice의 상태를 확인
	 * @param hVo
	 * @param fVo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkEDIOriginInvoice(TesEdiSoHdrVO hVo, TesEdiSoFileVO fVo) throws DAOException {
		log.debug("\n[TESCommonDBDAO][checkEDIOriginInvoice] ### \n");

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hVo != null){
				log.debug("\n DAO INVNO: "+hVo.getInvNo()+"<<<\n");
				param.put("vndr_seq", JSPUtil.getNull(hVo.getVndrSeq()));
				param.put("inv_no", JSPUtil.getNull(hVo.getInvNo()));
				param.put("org_file_nm", JSPUtil.getNull(fVo.getOrgFileNm()));

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOCheckInvoiceRSQL(), param, velParam);
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
		
		return dbRowset;
	}
	
	/**
	 *  EDI invoice원본 PDF FILE을 해당 INVOICE를 찾아 MAPPING한다.
	 * @param hVo
	 * @throws DAOException
	 */
	public void mapEDIOriginInvoice(TesEdiSoHdrVO hVo) throws DAOException {
		log.debug("\n[TESCommonDBDAO][mapEDIOriginInvoice] ### \n");

		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hVo != null){
				log.debug("\n ### tml_edi_so_ofc_cty_cd: "+JSPUtil.getNull(hVo.getTmlEdiSoOfcCtyCd())+" - "+JSPUtil.getNull(hVo.getTmlEdiSoSeq())+"<<<\n");
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(hVo.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(hVo.getTmlEdiSoSeq()));

				new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOMapEDIOriginInvoiceUSQL(), param, null);
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
	 * 
	 * @param hVo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkEDIOriginInvoiceMapping(TesEdiSoHdrVO hVo) throws DAOException {
		log.debug("\n[TESCommonDBDAO][checkEDIOriginInvoiceMapping] ### \n");

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hVo != null){
				log.debug("\n ### tml_edi_so_ofc_cty_cd: "+JSPUtil.getNull(hVo.getTmlEdiSoOfcCtyCd())+" - "+JSPUtil.getNull(hVo.getTmlEdiSoSeq())+"<<<\n");
				param.put("tml_edi_so_ofc_cty_cd", JSPUtil.getNull(hVo.getTmlEdiSoOfcCtyCd()));
				param.put("tml_edi_so_seq", JSPUtil.getNull(hVo.getTmlEdiSoSeq()));

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOCheckEDIOriginInvoiceMappingRSQL(), param, velParam);
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
		
		return dbRowset;
	}
	
	/**
	 * Cost Office Code 조회
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostOFC(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCostOFC] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCostOFCRSQL(), param, velParam);

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
	 * validate Cost Office Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCostOFC(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateCostOFC]\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {

			if ( !"".equals( event.getTesTmlSoHdrVO().getCostOfcCd() ) ) {
				param.put("cost_ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
				velParam.put("cost_ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
			}
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateCostOFCRSQL(), param, velParam);

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
	 * validate Cost Office Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCostOFC2(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateCostOFC2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO	= event.getTesTmlSoHdrVO().getColumnValues();
			
			if ( mapVO != null ) {

				if ( !"".equals( mapVO.get("cost_ofc_cd") ) ) {
					param.put("cost_ofc_cd", mapVO.get("cost_ofc_cd") );
					velParam.put("cost_ofc_cd", mapVO.get("cost_ofc_cd") );
				}
				
				if ( !"".equals( mapVO.get("yd_cd") ) ) {
					param.put("yd_cd", mapVO.get("yd_cd") );
					velParam.put("yd_cd", mapVO.get("yd_cd") );
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateCostOFC2RSQL(), param, velParam);

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
	 * validate Yard Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCode(TESCommonEvent event) throws DAOException {
		
		log.debug("\n[TESCommonDBDAO][validateYardCode \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCodeRSQL(), param, velParam);

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
	 * validate Yard Code ( Delt_flg )
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCode2(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateYardCode2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCode2RSQL(), param, velParam);
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
	 * TES 내에 미존재 (2009-07-07)
	 * @param event TESCommonEvent
	 * @return String
	 * @exception DAOException
	 */
	public String searchOrganizationCurrencyCode(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchOrganizationCurrencyCode] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String		arCurrCd	= "";

		try {
			if ( !"".equals( event.getTesCommonVO().getInvOfcCd() ) ) {
				param.put("inv_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
				velParam.put("inv_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchOrganizationCurrencyCodeRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");
			
			while (dbRowset.next()){
				arCurrCd = dbRowset.getString("AR_CURR_CD"); //일단 하나라는 전제에 작업
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

		return arCurrCd;
	}

	/**
	 * Currency List(통화) 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCurrencyList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCurrencyList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCurrencyListRSQL(), param, velParam);

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
	 * Node Code 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getNodeCode(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][getNodeCode] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if( !"".equals( event.getMdmYardVO().getLocCd() ) ) {
				param.put("loc_cd", event.getMdmYardVO().getLocCd());
				velParam.put("loc_cd", event.getMdmYardVO().getLocCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetNodeCodeRSQL(), param, velParam);

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
	 * OFC LOCAL Date Time 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchDBdate(TESCommonEvent event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("\n[TESCommonDBDAO][searchDBdate][] - ofc_cd : " + event.getSignOnUserAccount().getOfc_cd()+"\n");

			if ( !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchDBdateRSQL(), param, velParam);

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
	 * OFC LOCAL Date Time 조회
	 * @param String ofc_cd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public String searchDBdateStr(String ofc_cd) throws DAOException {

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("\n[TESCommonDBDAO][searchDBdateStr][] - \n");

			if ( !"".equals(ofc_cd) ) {
				param.put("ofc_cd", ofc_cd);
				velParam.put("ofc_cd", ofc_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchDBdateRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rtnValue = dbRowset.getString(1);
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
		
		return rtnValue;
	}	
	
	/**
	 * validate Vendor Seq Code
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateVndrCode(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateVndrCode] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateVndrCodeRSQL(), param, velParam);

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
	 * validate Vendor Seq Code ( Delt_flg )
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateVndrCode2(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][validateVndrCode2] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateVndrCode2RSQL(), param, velParam);

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
	 * Yard, Cost Code List Inquiry
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchYdCostCodeList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchYdCostCodeList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO	= event.getTesCommonVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchYdCostCodeListRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");

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
	 * validate Yard Code & Cost Code List 조회 
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateYardCodeNsearchYdCostCodeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][validateYardCodeNsearchYdCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {
			
			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );

				// CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20
				if ( "US".equals(event.getMdmYardVO().getYdCd().substring(0, 2) ) || "CA".equals(event.getMdmYardVO().getYdCd().substring(0, 2) ) ) {
					param.put("genset_flg", "Y");
					velParam.put("genset_flg", "Y");
				} else {
					param.put("genset_flg", "N");
					velParam.put("genset_flg", "N");
				}
				param.put("lgs_cost_cd", "TMRFGR");
				velParam.put("lgs_cost_cd", "TMRFGR");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL(), param, velParam);

			log.debug("\n dRs.getRow:"+dbRowset.getRow() + " - dRs.getRowCount:"+ dbRowset.getRowCount()+"\n");

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
	 * TES Cost Code List Inquiry
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTESCostCodeList() throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchTESCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchTESCostCodeListRSQL(), param, velParam);

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
	 * Container Type Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrTPCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrTPCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrTPCDListRSQL(), param, velParam);

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
	 * Container Size Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrSZCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrSZCDList] \n");

		DBRowSet				dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrSZCDListRSQL(), param, velParam);

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
	 * Container Type Size Cd List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrTPSZCDList() throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchCntrTPSZCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCntrTPSZCDListRSQL(), param, velParam);

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
	 * Lnae Code List 조회
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchLaneList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchLaneList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= event.getVskVslPortSkdVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchLaneListRSQL(), param, velParam);

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
	 * Invoice Auto Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAutoTESTmlSoCostCDList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchAutoTESTmlSoCostCDList] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getTesCommonVO().getCalcCostGrpCd() ) ) {
				param.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
				velParam.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAutoTESTmlSoCostCDListRSQL(), param, velParam);
			
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
	 * Invoice Manual Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchManualTESTmlSoCostCDList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchManualTESTmlSoCostCDList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getTesCommonVO().getCalcCostGrpCd() ) ) {
				param.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
				velParam.put("calc_cost_grp_cd", event.getTesCommonVO().getCalcCostGrpCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchManualTESTmlSoCostCDListRSQL(), param, velParam);
		
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
	 * TES Common Cost Code List 조회
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTESInvoiceCommonCodeList() throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchTESInvoiceCommonCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		/**
		# yd_chr_inv_tp_cd : yard의 특성을 조회하기 위한 code값...
		1. Marine Terminal Invoice = 'MT'
		2. On-dock Rail Charge Invoice = 'ON'
		3. Off-dock CY Invoice(Terminal) = 'OT'
		4. Off-dock CY Invoice(Storage) = 'OS'
		5. Storage Invoice = 'ST'
		 */

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL(), param, velParam);

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
	 * Agreement Cost Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgreementCostCodeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchAgreementCostCodeList] \n");

		DBRowSet					dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd());
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAgreementCostCodeListRSQL(), param, velParam);

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
	 * Lane Code List 조회
	 * @param event TESCommonEvent
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchLaneCodeList(TESCommonEvent event) throws DAOException {

		log.debug("\n[TESCommonDBDAO][searchLaneCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( event.getMdmYardVO().getYdCd() ) ) {
				param.put("yd_cd", event.getMdmYardVO().getYdCd() );
				velParam.put("yd_cd", event.getMdmYardVO().getYdCd() );
			}

			if ( !"".equals( event.getTesCommonVO().getVvd() ) ) {
				param.put("vvd", event.getTesCommonVO().getVvd() );
				velParam.put("vvd", event.getTesCommonVO().getVvd() );
			}
			
			velParam.put("vsl_cd_sub", event.getTesCommonVO().getVvd().substring(0,4) );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchLaneCodeListRSQL(), param, velParam);
		
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
	 * MDM Account 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMDMAccount(TESCommonEvent event) throws DAOException {
		
		log.debug("\n[TESCommonDBDAO][searchMDMAccount] \n");
		
		DBRowSet dbRowset = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchMDMAccountRSQL(), null, null);
			
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
	 * MDM Account 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAuthOfcCd(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchAuthOfcCd] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO	= event.getTesCommonVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
				
			log.debug("param cre_ofc_cd===>"+param.get("cre_ofc_cd"));
			log.debug("param agmt_no_ofc_cd===>"+param.get("no_ofc_cd"));
			log.debug("param act_tp===>"+param.get("act_tp"));
			log.debug("param yd_cd===>"+param.get("no_yd_cd"));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchAuthOfcCdRSQL(), param, velParam);
			
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
	 * 등록된 주용 기능의 성능 측정 시작용 Sequence Select
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception DAOException
	 */
	public String beginJobExecutionPerformanceR(TesJbExePerfLogVO tesJbExePerfLogVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String				logSeq		= "";
		
		try {
			if( tesJbExePerfLogVO != null ){
				Map<String, String> mapVO = tesJbExePerfLogVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset	= new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOBeginJobExecutionPerformanceRSQL(), param, velParam);
			
			while ( dbRowset.next()) {
				logSeq	= dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}
		
		return	logSeq;
	}

		
	/**
	 * 등록된 주용 기능의 성능 측정 시작 Insert
	 * @param TesJbExePerfLogVO	tesJbExePerfLogVO
	 * @exception DAOException
	 */
	public void beginJobExecutionPerformanceC(TesJbExePerfLogVO	tesJbExePerfLogVO) throws DAOException {
		log.debug("\n[TESCommonDBDAO][beginJobExecutionPerformance] ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if( tesJbExePerfLogVO != null ) {
				Map<String, String> mapVO = tesJbExePerfLogVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOBeginJobExecutionPerformanceCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

	}
	
	/**
	 * 등록된 주용 기능의 성능 측정 마침용 
	 * @param curr_seq
	 * @param mode
	 * @exception DAOException
	 */
	public void endJobExecutionPerformance(String curr_seq, String mode) throws DAOException {
		log.debug("\n[TESCommonDBDAO][endJobExecutionPerformance - MODE:"+(mode!=null?mode:"NO MODE FOUND ERROR")+"  ### \n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			if( !"".equals( mode ) ) {
				param.put("mode", mode);
			}

			if( !"".equals( curr_seq ) ) {
				param.put("exe_perf_log_seq", curr_seq);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESCommonDBDAOEndJobExecutionPerformanceUSQL(), param, velParam);

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
	 * Regional Head Office 조회
	 * @param TESCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchRhqOfcCd(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchRhqOfcCd] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO	= event.getTesCommonVO().getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
					
			log.debug("param acct_ofc_cd===>"+param.get("acct_ofc_cd"));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchRhqOfcCdRSQL(), param, velParam);
			
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
	 * 해당 월 환율 적용하여 USD Amt를 구한다.
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkUsdConvert(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][checkUsdConvert]\n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try {

			if ( !"".equals( event.getTesAwkCgoTrfMngVO().getLclAmt() ) ) {
				param.put("lcl_amt", event.getTesAwkCgoTrfMngVO().getLclAmt() );
				velParam.put("lcl_amt", event.getTesAwkCgoTrfMngVO().getLclAmt() );
			}
			
			if ( !"".equals( event.getTesAwkCgoTrfMngVO().getCurrCd() ) ) {
				param.put("curr_cd", event.getTesAwkCgoTrfMngVO().getCurrCd() );
				velParam.put("curr_cd", event.getTesAwkCgoTrfMngVO().getCurrCd() );
			}
			
			if ( !"".equals( event.getTesAwkCgoTrfMngVO().getSelectRow() ) ) {
				param.put("select_row", event.getTesAwkCgoTrfMngVO().getSelectRow() );
				velParam.put("select_row", event.getTesAwkCgoTrfMngVO().getSelectRow() );
			}
			
			if ( !"".equals( event.getTesAwkCgoTrfMngVO().getSelectCol() ) ) {
				param.put("select_col", event.getTesAwkCgoTrfMngVO().getSelectCol() );
				velParam.put("select_col", event.getTesAwkCgoTrfMngVO().getSelectCol() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOcheckUsdConvertRSQL(), param, velParam);

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
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param ComUpldFileVO comUpldFileVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchExcelTemplateFileKey(ComUpldFileVO comUpldFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		String fileKey = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comUpldFileVO != null) {
				Map<String, String> mapVO = comUpldFileVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOExcelTemplateFileRSQL(), param, velParam);
			if (dbRowset.next()) {
				fileKey = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return fileKey;
	}
	
	/**
	 * Invoice No 중복 확인
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchInvNoDupChk(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchInvNoDupChk] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getInvNo())) {
				param.put("inv_no", event.getTesTmlSoHdrVO().getInvNo() );
				velParam.put("inv_no", event.getTesTmlSoHdrVO().getInvNo() );
			}
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq())) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchInvNoDupChkRSQL(), param, velParam);
			
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
	 * Invoice의 Manual 입력시  필수 입력 체크 여부
	 * @param event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostCodeChkFlg(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCostCodeChkFlg] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesCommonVO().getParamLgsCostCd() )) {
				param.put("param_lgs_cost_cd", event.getTesCommonVO().getParamLgsCostCd() );
				velParam.put("param_lgs_cost_cd", event.getTesCommonVO().getParamLgsCostCd() );
			}
			if ( !"".equals( event.getTesCommonVO().getCoid() )) {
				param.put("coid", event.getTesCommonVO().getCoid() );
				velParam.put("coid", event.getTesCommonVO().getCoid() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCostCodeChkFlgRSQL(), param, velParam);
			
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
	 * TES 공통 조회 기능 <br>
	 * AGMT NO 를 조회하여 TES AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @return String return_agmt_no
	 * @exception DAOException
	 */
	public String searchTesAgmtNoData(String agmt_no) throws DAOException {
		DBRowSet dbRowset 	  = null;
		String return_agmt_no = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {			
			param.put("agmt_no",     agmt_no);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchTesAgmtNoDataRSQLRSQL(), param, null);
			
			while (dbRowset.next()){
				return_agmt_no = dbRowset.getString ("agmt_no");
				break;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return return_agmt_no;
	}


	/**
	 * TES Invoice Cost Code List Inquiry
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTESInvCostCodeList() throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchTESInvCostCodeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchTESInvCostCodeListRSQL(), param, velParam);

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
	 * Calling Yard Sequence List Inquiry
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCallYdIndSeqList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCallYdIndSeqList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getYdCd() )) {
				param.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
				velParam.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
			}
			if ( !"".equals( event.getTesCommonVO().getVvd() )) {
				param.put("vvd", event.getTesCommonVO().getVvd() );
				velParam.put("vvd", event.getTesCommonVO().getVvd() );
				
				param.put("vsl_cd", event.getTesCommonVO().getVvd().substring(0, 4) );
				velParam.put("vsl_cd", event.getTesCommonVO().getVvd().substring(0, 4) );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCallYdIndSeqListRSQL(), param, velParam);

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
	 * Calling Port Sequence Inquiry
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchClptIndSeq(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchClptIndSeq] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getYdCd() )) {
				param.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
				velParam.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
			}
			if ( !"".equals( event.getTesCommonVO().getVvd() )) {
				param.put("vvd", event.getTesCommonVO().getVvd() );
				velParam.put("vvd", event.getTesCommonVO().getVvd() );
				
				param.put("vsl_cd", event.getTesCommonVO().getVvd().substring(0, 4) );
				velParam.put("vsl_cd", event.getTesCommonVO().getVvd().substring(0, 4) );				
				
				param.put("call_yd_ind_seq", event.getTesCommonVO().getParamCallYdIndSeq() );
				velParam.put("call_yd_ind_seq", event.getTesCommonVO().getParamCallYdIndSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchClptIndSeqRSQL(), param, velParam);

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
	 * CALLING YARD SEQUENCE check
	 * doubling calling 이면 Y, 아니면 N 
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCallingYardSeqChk(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchCallingYardSeqChk] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getYdCd() )) {
				param.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
				velParam.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
			}
			if ( !"".equals( event.getTesCommonVO().getVvd() )) {
				param.put("vvd", event.getTesCommonVO().getVvd() );
				velParam.put("vvd", event.getTesCommonVO().getVvd() );	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchCallingYardSeqChkRSQL(), param, velParam);

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
	 * Sub Office List Inquiry
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSubOfficeList(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][searchSubOfficeList] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getTesCommonVO().getOfcCd() )) {
				param.put("ofc_cd", event.getTesCommonVO().getOfcCd() );
				velParam.put("ofc_cd", event.getTesCommonVO().getOfcCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchSubOfficeListRSQL(), param, velParam);

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
	
	public DBRowSet getUserOfcCdChk(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getUserOfcCd] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getTesCommonVO().getUsrId() )) {
				param.put("usr_id", event.getTesCommonVO().getUsrId() );
				velParam.put("usr_id", event.getTesCommonVO().getUsrId() );
			}
			
			if ( !"".equals( event.getTesCommonVO().getOfcCd() )) {
				param.put("ofc_cd", event.getTesCommonVO().getOfcCd() );
				velParam.put("ofc_cd", event.getTesCommonVO().getOfcCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetUserOfcCdChkRSQL(), param, velParam);

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
	
	public String getIndOfcCdChk(String ofcCd) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getIndOfcCdChk] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String idaOfcCd = "";

		try {
			if ( !"".equals( ofcCd )) {
				param.put("ofc_cd", ofcCd );
				velParam.put("ofc_cd", ofcCd );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetIndOfcCdChkRSQL(), param, velParam);

			while (dbRowset.next()){
				idaOfcCd = dbRowset.getString("IDA_OFC_CD");
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
		return idaOfcCd;
	}
		
	public DBRowSet getIndGstRto(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getIndGstRto] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() )) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
				velParam.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			
			if ( !"".equals( event.getTesTmlSoHdrVO().getCostOfcCd() )) {
				param.put("ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
				velParam.put("ofc_cd", event.getTesTmlSoHdrVO().getCostOfcCd() );
			}
			
			if ( !"".equals( event.getTesTmlSoDtlVO().getIdaSacCd() )) {
				param.put("ida_sac_cd", event.getTesTmlSoDtlVO().getIdaSacCd() );
				velParam.put("ida_sac_cd", event.getTesTmlSoDtlVO().getIdaSacCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOGetIndGstRtoRSQL(), param, velParam);

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
	
	public DBRowSet validateSacCd(TESCommonEvent event) throws DAOException {
		log.debug("\n[TESCommonDBDAO][getIndGstRto] \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			if ( !"".equals( event.getTesTmlSoDtlVO().getIdaSacCd() )) {
				param.put("ida_sac_cd", event.getTesTmlSoDtlVO().getIdaSacCd() );
				velParam.put("ida_sac_cd", event.getTesTmlSoDtlVO().getIdaSacCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOValidateSacCdRSQL(), param, velParam);

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
}

