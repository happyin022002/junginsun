/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TES Invoice CommonDBDAO.java
*@FileTitle : TES Invoice Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성

=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD에 대한 DB 처리를 담당<br>
 * ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author byungheeyoo
 * @see TESInvoiceCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESInvoiceCommonDBDAO extends DBDAOSupport {

	/**
	 * ofc_cd에 따라 Withholding tax입력 mode를 가져온다.
	 * @param TESInvoiceCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getWHTmode(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][getWHTmode] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if ( !"".equals( event.getTesCommonVO().getInvOfcCd() ) ) {
				param.put( "ofc_cd", event.getTesCommonVO().getInvOfcCd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOGetWHTmodeRSQL(), param, velParam);

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
	 * (calc 계산시) agreement의 currency code를 가져온다.
	 * @param TESInvoiceCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getAgmtCurrCD(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][getAgmtCurrCD] \n");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if ( "".equals( event.getTesTmlSoHdrVO().getYdCd() ) || 
				"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ||
				"".equals( event.getTesCommonVO().getFromDate() ) ||
				"".equals( event.getTesCommonVO().getToDate() ) ) {
//				throw new DAOException("\n[TESInvoiceCommonDBDAO][getAgmtCurrCD] - 필수 인자 오류!");
				throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "getAgmtCurrCD"} ).getMessage());
			}

		try {

			if ( !"".equals( event.getTesTmlSoHdrVO().getYdCd() ) ) {
				param.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
			}
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			if ( !"".equals( event.getTesCommonVO().getFromDate() ) ) {
				param.put("from_date", event.getTesCommonVO().getFromDate() );
			}
			if ( !"".equals( event.getTesCommonVO().getToDate() ) ) {
				param.put("to_date", event.getTesCommonVO().getToDate() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL(), param, velParam);

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
	 * (calc 계산시) agreement의 status를 가져온다.
	 * @param TESInvoiceCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getAgmtSts(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][getAgmtSts] \n");
		
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		

		if ( "".equals( event.getTesTmlSoHdrVO().getYdCd() ) || 
			"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ||
			"".equals( event.getTesCommonVO().getFromDate() ) ||
			"".equals( event.getTesCommonVO().getToDate() ) ) {
//			throw new DAOException("\n[TESInvoiceCommonDBDAO][getAgmtSts] - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "getAgmtSts"} ).getMessage());
		}
		
		try {

			if ( !"".equals( event.getTesTmlSoHdrVO().getYdCd() ) ) {
				param.put("yd_cd", event.getTesTmlSoHdrVO().getYdCd() );
			}
			if ( !"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ) {
				param.put("vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );
			}
			if ( !"".equals( event.getTesCommonVO().getFromDate() ) ) {
				param.put("from_date", event.getTesCommonVO().getFromDate() );
			}
			if ( !"".equals( event.getTesCommonVO().getToDate() ) ) {
				param.put("to_date", event.getTesCommonVO().getToDate() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOGetAgmtStsRSQL(), param, velParam);

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
	 * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	 * @param TESInvoiceCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getN3ptyBilCSCD(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][getN3ptyBilCSCD] \n");
		
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String	lgsCostCd	= !"".equals( event.getTesLgsCostVO().getLgsCostCd() )?event.getTesLgsCostVO().getLgsCostCd():event.getTesCommonVO().getParamLgsCostCd();

		if ( lgsCostCd == null || "".equals( lgsCostCd ) ) {
			// 'param_lgs_cost_cd'와 'lgs_cost_cd' 중 어디에도 값이 없으면 필수값이 제대로 안 넘어 온거당.
//			throw new DAOException("TESInvoiceCommonDBDAO.getN3ptyBilCSCD - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "getN3ptyBilCSCD"} ).getMessage());
		}
	
		try {

			if ( !"".equals( lgsCostCd ) ) {
				param.put("lgs_cost_cd", lgsCostCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOGetN3ptyBilCSCDRSQL(), param, velParam);
			
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
	 * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	 * @param TESInvoiceCommonEvent event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet isValidErrInvNo(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][isValidErrInvNo] \n");
	
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
log.debug("event.getTesTmlSoHdrVO().getTmlInvTpCd()====>"+event.getTesTmlSoHdrVO().getTmlInvTpCd());
log.debug("event.getTesTmlSoHdrVO().getYdCd()====>"+event.getTesTmlSoHdrVO().getYdCd());
log.debug("event.getTesTmlSoHdrVO().getVndrSeq()====>"+event.getTesTmlSoHdrVO().getVndrSeq());
log.debug("event.getTesTmlSoHdrVO().getErrInvNo()====>"+event.getTesTmlSoHdrVO().getErrInvNo());
	
		if ( "".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ||
			"".equals( event.getTesTmlSoHdrVO().getYdCd() ) ||
			"".equals( event.getTesTmlSoHdrVO().getVndrSeq() ) ||
			"".equals( event.getTesTmlSoHdrVO().getErrInvNo() ) )
		{ 
//			throw new DAOException("[TESInvoiceCommonDBDAO][isValidErrInvNo] - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "isValidErrInvNo"} ).getMessage());
		}
		
		try {
		
			Map<String, String> mapVO = event.getTesTmlSoHdrVO() .getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOIsValidErrInvNoRSQL(), param, velParam);

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
	
	
	/** selectYdNm
	 * 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectYdNm(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String	 yd_nm	= "";

		try {
			if ( tesTmlSoHdrVO != null ){
				param.put("yd_cd", tesTmlSoHdrVO.getYdCd());
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSelectYdNmRSQL(), param, velParam);

				if ( dbRowset != null && dbRowset.next()){
					yd_nm	= dbRowset.getString("YD_NM");
				}
			}
			
			return yd_nm;
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
	
	/** selectVndrNm
	 * 
	 * @param tesTmlSoHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectVndrNm(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String	 yd_nm	= "";

		try {
			if ( tesTmlSoHdrVO != null ){
				param.put("vndr_seq", tesTmlSoHdrVO.getVndrSeq());
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSelectVndrNmRSQL(), param, velParam);

				if ( dbRowset != null && dbRowset.next()){
					yd_nm	= dbRowset.getString("VNDR_LGL_ENG_NM");
				}
			}
			
			return yd_nm;
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
	
	/** selectCostCdFtrRmk
	 * 
	 * @param tesTmlSoHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectCostCdFtrRmk(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String	 cost_cd_ftr_rmk	= "";

		try {
			if ( tesTmlSoHdrVO != null ){
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq());
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSelectCostCdFtrRmkRSQL(), param, velParam);

				if ( dbRowset != null && dbRowset.next()){
					cost_cd_ftr_rmk	= dbRowset.getString("COST_CD_FTR_RMK");
				}
			}
			
			return cost_cd_ftr_rmk;
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
	 * 2007-12-10 : invoice의 상태를 확인
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param mode
	 * @exception DAOException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO tesTmlSoHdrVO, String mode) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String		sts		= "";
		String		inv_no	= "";

		try {
			if ( tesTmlSoHdrVO != null ){
				
				param.put("inv_sts_rc", TESInvoiceCommonBC.INV_STS_RC);		// Invoice Update하고자 할 때
				param.put("inv_sts_cf", TESInvoiceCommonBC.INV_STS_CF);		// CSR 생성 할 때와 Invoice Confirm을 풀 때
				param.put("inv_sts_csr", TESInvoiceCommonBC.INV_STS_CSR);	// CSR cancel하고자 할 때 
				
				param.put("mode", mode);
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq());
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckInvoiceStatus02RSQL(), param, velParam);

				if ( dbRowset != null && dbRowset.next()){
					sts 	= dbRowset.getString("STS");
					inv_no	= dbRowset.getString("INV_NO");
					if ( sts != null && !"Y".equals(sts.trim())){
//						throw new DAOException("\n\n Please, check the status of the invoice number \""+inv_no+"\" before proceeding. \n");
						throw new DAOException(new ErrorHandler("TES00078", new String[]{inv_no} ).getMessage());
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

	}
	
	/**
	 * 2007-12-10 : invoice의 상태를 확인
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @param mode
	 * @exception DAOException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO[] tesTmlSoHdrVOs, String mode) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String		sts		= "";
		String		inv_no	= "";
		
		try {
			
			param.put("inv_sts_rc", TESInvoiceCommonBC.INV_STS_RC);		// Invoice Update하고자 할 때
			param.put("inv_sts_cf", TESInvoiceCommonBC.INV_STS_CF);		// CSR 생성 할 때와 Invoice Confirm을 풀 때
			param.put("inv_sts_csr", TESInvoiceCommonBC.INV_STS_CSR);	// CSR cancel하고자 할 때 
			
			TesTmlSoHdrVO tesTmlSoHdrVO = null;

			for (int k = 0; k < tesTmlSoHdrVOs.length; k++ ){
				tesTmlSoHdrVO = (TesTmlSoHdrVO)tesTmlSoHdrVOs[k];

				param.put("mode"				, mode);
				param.put("tml_so_ofc_cty_cd"	, tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq"			, tesTmlSoHdrVO.getTmlSoSeq());

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckInvoiceStatus02RSQL(), param, velParam);

				if (dbRowset!=null && dbRowset.next()){
					sts 	= dbRowset.getString("STS");
					inv_no	= dbRowset.getString("INV_NO");
					if ( sts != null && !"Y".equals(sts.trim())){
//						throw new DAOException("\n\n Please, check the status of the invoice number \""+inv_no+"\" before proceeding. \n");
						throw new DAOException(new ErrorHandler("TES00078", new String[]{inv_no} ).getMessage());
					}
				}
				dbRowset = null;
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
	 * 2007-12-10 : invoice의 상태를 확인
	 * @param csrNo
	 * @param mode
	 * @exception DAOException
	 */
	public void checkInvoiceStatus(String csrNo, String mode) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String		sts		= "";
		String		inv_no	= "";

		try {
			if ( csrNo != null && !"".equals( csrNo.trim() ) ) {
				
				param.put("inv_sts_rc", TESInvoiceCommonBC.INV_STS_RC);		// Invoice Update하고자 할 때
				param.put("inv_sts_cf", TESInvoiceCommonBC.INV_STS_CF);		// CSR 생성 할 때와 Invoice Confirm을 풀 때
				param.put("inv_sts_ar", TESInvoiceCommonBC.INV_STS_AR);		// Approval Requested 상태의 CSR을 cancel하고자 할 때
				param.put("inv_sts_csr", TESInvoiceCommonBC.INV_STS_CSR);	// CSR cancel하고자 할 때 
				
				param.put("mode", JSPUtil.getNull(mode) );
				param.put("csr_no", csrNo );
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckInvoiceStatus01RSQL(), param, velParam);

				while ( dbRowset != null && dbRowset.next() ){
					sts 	= dbRowset.getString("STS");
					inv_no	= dbRowset.getString("INV_NO");
					if ( sts != null && !"Y".equals(sts.trim())){
//						throw new DAOException("\n\n Please, check the status of the invoice number \""+inv_no+"\" before proceeding. \n");
						throw new DAOException(new ErrorHandler("TES00078", new String[]{inv_no} ).getMessage());
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
	}	


	/**
	 * 2009-06-03 : N3RT_PTY_IF 존재 여부 Check 
	 * @param tesTmlSoHdrVO
	 * @exception DAOException
	 */
	public void checkDetailTpb( TesTmlSoHdrVO tesTmlSoHdrVO ) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( tesTmlSoHdrVO.getTmlSoOfcCtyCd() ) ) {
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				velParam.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
			}
			
			if ( !"".equals( tesTmlSoHdrVO.getTmlSoSeq() ) ) {
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq() );
				velParam.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckDetailTpbRSQL(), param, velParam);
				
			if ( dbRowset != null ) {
				while ( dbRowset.next() ) {
					// IF에는 존재 DTL에 Flg가 Y가 아니면
					if ( !"Y".equals( dbRowset.getString("N3PTY_FLG") ) && dbRowset.getInt("CNT") > 0 ) {
						// N3PTY_FLG Update
						updateDetailN3ptyFlg(dbRowset.getString("SO_OFC_CD"), dbRowset.getString("SO_SEQ"), dbRowset.getString("DTL_SEQ"));
					} else if ( "Y".equals( dbRowset.getString("N3PTY_FLG") ) && dbRowset.getInt("CNT") < 1 ) {
						// Exception
//						throw new DAOException("\n\n COST CODE [" + dbRowset.getString("LGS_COST_CD") + "] , Type/Size [" + JSPUtil.getNull( dbRowset.getString("CNTR_TPSZ_CD") ) + "] 3rd party is not exist.");
						throw new DAOException(new ErrorHandler("TES00076", new String[]{dbRowset.getString("LGS_COST_CD"), JSPUtil.getNull( dbRowset.getString("CNTR_TPSZ_CD") )} ).getMessage());
					}
				}// while..[]
			}// if..[]
			

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
	 * 2009-06-03 : SO_DTL의 N3PTY_FLG Y Update 
	 * @param soOfcCd
	 * @param soSeq
	 * @param soDtlSeq
	 * @exception DAOException
	 */
	public void updateDetailN3ptyFlg(String soOfcCd, String soSeq, String soDtlSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( soOfcCd ) ) {
				param.put("tml_so_ofc_cty_cd", soOfcCd );
			}
			
			if ( !"".equals( soSeq ) ) {
				param.put("tml_so_seq", soSeq );
			}
			
			if ( !"".equals( soDtlSeq ) ) {
				param.put("tml_so_dtl_seq", soDtlSeq );
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOUpdateDetailN3ptyFlgUSQL(), param, velParam);

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
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getMgstNos(TESInvoiceCommonEvent event) throws DAOException {
		
		log.debug("\n[TESInvoiceCommonDBDAO][getMgstNos] \n");
		
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("\n[TESInvoiceCommonDBDAO][getMgstNos] before replace "+event.getTesCommonVO().getTmpMgstNo());
		
		String sMgstNos = event.getTesCommonVO().getTmpMgstNo().replaceAll("@", ",").replaceAll("`", "'");
		
		log.debug("\n[TESInvoiceCommonDBDAO][getMgstNos] after replace "+sMgstNos);
				
		try {
			velParam.put("eq_no", sMgstNos);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOGetMgstNosRSQL(), null, velParam);

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
	
	/** 2010-11-11: [CHM-201006940-01] INV AUTO CALC CHECK
	 * Invoice CF시 Cost Code에 따라 auto calc 체크 확인
	 * @param tesTmlSoHdrVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkInvCalcCostCD(TesTmlSoHdrVO tesTmlSoHdrVO ) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if ( !"".equals( tesTmlSoHdrVO.getTmlSoOfcCtyCd() ) ) {
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				velParam.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
			}
			
			if ( !"".equals( tesTmlSoHdrVO.getTmlSoSeq() ) ) {
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq() );
				velParam.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckInvCalcCostCDRSQL(), param, velParam);

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
	 * 
	 * @param tesTmlSoHdrVO
	 * @return
	 * @throws DAOException
	 */
	public String searchApPayInvRgstNo(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException{
		DBRowSet 	dbRowset  = null;
		String		rtnRgstno = "";  		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchApPayInvRgstNoRSQL(), param, velParam);

			while ( dbRowset != null && dbRowset.next() ){
				rtnRgstno 	= dbRowset.getString("INV_RGST_NO");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnRgstno;
	}	
	
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @return
	 * @throws DAOException
	 */
	public ApPayInvVO searchApPayInv(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchApPayInvRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @param apPayInvVO
	 * @return ApPayInvDtlVO[] 
	 * @throws DAOException
	 */
	public ApPayInvDtlVO[] searchApPayInvDtl(TesTmlSoHdrVO tesTmlSoHdrVO, ApPayInvVO apPayInvVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(apPayInvVO != null){
				Map<String, String> mapVO = apPayInvVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO .class);
			
			ApPayInvDtlVO[] rtvos = new ApPayInvDtlVO[list.size()]; 
			
			for(int i=0 ; i<list.size();i++){
				rtvos[i] = list.get(i);
			}
			return rtvos;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/** cancelApPayInv
	 *  
	 * @param apPayInvVO
	 * @throws DAOException
	 */
	public void cancelApPayInv(ApPayInvVO apPayInvVO) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apPayInvVO != null){
				Map<String, String> mapVO = apPayInvVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOCancelApPayInvUSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** cancelApPayInvDtl
	 * 
	 * @param apPayInvVO
	 * @throws DAOException
	 */
	public void cancelApPayInvDtl(ApPayInvVO apPayInvVO) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apPayInvVO != null){
				Map<String, String> mapVO = apPayInvVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOCancelApPayInvDtlUSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}