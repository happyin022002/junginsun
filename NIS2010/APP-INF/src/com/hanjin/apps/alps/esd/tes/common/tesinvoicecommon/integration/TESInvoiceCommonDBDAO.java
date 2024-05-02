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
* 2009-03-16 [R200903110001] : CNTC항차 VALIDATION 기준 변경 - REV_VVD MASTER에만 있으면 일단 통과
* 2009-05-29 [N200905280100] : TPB I/F 누락 방지 추가
* 2009-09-18 [CHM-200901007] : Split 01-TPB Billing case (AW)에 대한 IF 오류 수정 (from TES)
* 2009-08-27 [PJM-200900072] : 부산신항만(180020)용 getAutoFPmode 조회 기능 추가.
*                              EDI Invoice 유효성 확인에 부산신항만(180020) 추가
*                              EDI Invoice 유효성 확인시 사용하던 autoRejectEDIInvoice제거하고 setEDIInvoiceValidSts를 추가
                               EDI Invoice Validation 확인 작업을 한 결과 표시(VLD_CHK_FLG)
                               EDI Invoice Validation 결과 Auto Reject(AJ) 대상인 Invoice의 상태를 'AJ'로 바꿔주고 Reject 사유를 업데이트 시킨다.
*                              EDI Invoice 정규 Invoice 기본정보로 전환에 부산신항만(180020) 추가
*                              EDI Invoice 정규 Invoice DTL정보로 전환에 부산신항만(180020) 추가
*                              EDI Invoice 정규 Invoice VVD목록정보로 전환에 부산신항만(180020) 추가
*                              신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
* 2009-10-26 [ITM-200900174] : 미사용 변수 제거
* 							   EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가
* 2009-10-29 [CHM-200901475] : 부신신항의 VVD구하기에서 VSK_VSL_PORT_SKD의 Calling port indicator가 복수인 경우 VVD가 복수로 생성되어 Group화 처리되어 ATB DATE는 MIN값으로 대체
* 2009-11-12 [CHM-200901554] : EDI invoice 유효성 확인 logic 조건 수정(EDI invoice만 해당)
* 2009-11-20 [CHM-200901648] : EDI INVOICE전환시 VVD LIST 조회 조건 로직 수정 
* 2010-11-11 박재흥 [CHM-201006940-01] INV AUTO CALC CHECK
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
import com.hanjin.apps.alps.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchDBdateRSQL;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;

/**
 * ALPS-ESD에 대한 DB 처리를 담당<br>
 * - ALPS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author byungheeyoo
 * @see TESInvoiceCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESInvoiceCommonDBDAO extends DBDAOSupport {

	/**
	 * [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void checkRegularInvoiceDup( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][checkRegularInvoiceDup \n");
		
		DBRowSet dbRs = null;
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(tesEdiSoHdrVO != null){
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRs = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckRegularInvoiceDupRSQL(), param, velParam);
			
			if (dbRs!=null && dbRs.getRowCount()>0){
				log.error("\n\n $$$$$$$ TESInvoiceCommonDBDAO-checkRegularInvoiceDup() - "
							+(dbRs!=null?dbRs.getRowCount():0)+
							" $$$$$$$ \n\n");
//				throw new DAOException("\n\n Invoice, \""+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())+"\", is duplicated.  Please, check the status of the invoice before proceeding. \n");
				throw new DAOException(new ErrorHandler("TES00079", new String[]{JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())} ).getMessage());
			} else {
				log.error("\n\n $$$$$$$ TESInvoiceCommonDBDAO-checkRegularInvoiceDup() - OK");
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
	 * [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void checkEDIInvoiceDup( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][checkEDIInvoiceDup \n");
		
		DBRowSet dbRs = null;
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(tesEdiSoHdrVO != null){
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRs = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOCheckEDIInvoiceDupRSQL(), param, velParam);
			
			if (dbRs!=null && dbRs.getRowCount()>0){
//				throw new DAOException("\n\n Invoice, \""+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())+"\", is duplicated.  Please, check the status of the invoice before proceeding. \n");
				throw new DAOException(new ErrorHandler("TES00079", new String[]{JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())} ).getMessage());
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
	 * 2009-08-27 [PJM-200900072] : 부산신항만(180020)용 getAutoFPmode 조회 기능 추가.
	 * (EDI전송) AUTO FreePool용 Monthly/Daily mode 조회
	 * @param param_map
	 * @return
	 * @exception DAOException
	 */
//	public DBRowSet getAutoFPmode(java.util.HashMap<String, Object> param_map) throws DAOException {
//		
//		log.debug("\n DAO.getAutoFPmode \n");
//		
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		DBRowSet dRs = null;
//		int i = 1;
//		
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" SELECT                                                                  \n");
//		queryStr.append("     CASE                                                                \n");
//		queryStr.append("     WHEN SUM(X.E_TP) > 0                                                \n");
//		queryStr.append("     THEN 'X'                                                            \n");
//		queryStr.append("     WHEN SUM(X.M_TP) > 0 AND SUM(X.D_TP) > 0                            \n");
//		queryStr.append("     THEN 'X'                                                            \n");
//		queryStr.append("     WHEN SUM(X.M_TP) > 0                                                \n");
//		queryStr.append("     THEN 'M'                                                            \n");
//		queryStr.append("     WHEN SUM(X.D_TP) > 0                                                \n");
//		queryStr.append("     THEN 'D'                                                            \n");
//		queryStr.append("     ELSE 'X'                                                            \n");
//		queryStr.append("     END FP_MODE                                                         \n");
//		queryStr.append(" FROM (                                                                  \n");
//		queryStr.append("     SELECT                                                              \n");
//		queryStr.append("     DECODE(F.FP_CALC_PRD_CD,'M',1,0) M_TP,                              \n");
//		queryStr.append("     DECODE(F.FP_CALC_PRD_CD,'D',1,0) D_TP,                              \n");
//		queryStr.append("     DECODE(F.FP_CALC_PRD_CD,'M',0,'D',0,1) E_TP                         \n");
//		queryStr.append("     FROM TES_EDI_SO_HDR H, TES_EDI_SO_AUTO_FREE_POOL F                  \n");
//		queryStr.append("     WHERE H.TML_SO_OFC_CTY_CD = ?                                       \n");
//		queryStr.append("     AND H.TML_SO_SEQ = ?                                                \n");
//		queryStr.append("     AND NVL(H.DELT_FLG,'N') <> 'Y'                                      \n");
//		queryStr.append("     AND H.VNDR_SEQ IN ('180020')                                        \n");
//		queryStr.append("     AND H.TML_INV_TP_CD IN ('ST')                                       \n");
//		queryStr.append("     AND H.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD               \n");
//		queryStr.append("     AND H.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ                             \n");
//		queryStr.append("     GROUP BY F.FP_CALC_PRD_CD                                           \n");
//		queryStr.append(" ) X                                                                     \n");
//		
//		try {
//			con = getConnection();
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//
//			ps.setString(i++, param_map!=null?(JSPUtil.getNull((String)param_map.get("tml_so_ofc_cty_cd"))):"");
//			ps.setString(i++, param_map!=null?(JSPUtil.getNull((String)param_map.get("tml_so_seq"))):"");
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			
//			rs = ps.executeQuery();
//
//			dRs = new DBRowSet();
//			dRs.populate(rs);
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
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}
	
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
	 * EDI로 접수된 Invoice의 유효성을 체크한다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice01(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
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
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOValidateEDIInvoice01RSQL(), param, null);
				
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
		
		return rjctRmk;
	}
	
	/**
	 * EDI로 접수된 Invoice의 유효성을 체크한다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String validateEDIInvoice02(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
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
	
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOValidateEDIInvoice02RSQL(), param, null);

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
						+ "\n\n --- TESInvoiceCommonDBDAO.validateEDIInvoice02() --- "
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
		
		return rjctRmk;
	}	



	/**
	 * 2009-08-27 [PJM-200900072] : EDI Invoice 유효성 확인시 사용하던 autoRejectEDIInvoice제거하고 setEDIInvoiceValidSts를 추가
	 * EDI Invoice Validation 확인 작업을 한 결과 표시(VLD_CHK_FLG)
	 * EDI Invoice Validation 결과 Auto Reject(AJ) 대상인 Invoice의 상태를 'AJ'로 바꿔주고
	 * Reject 사유를 업데이트 시킨다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @param String	rjctRmk  : Reject 사유
	 * @exception DAOException
	 */
	public void setEDIInvoiceValidSts(TesEdiSoHdrVO tesEdiSoHdrVO, String rjctRmk) throws DAOException {
		
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
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOSetEDIInvoiceValidStsUSQL(), param, null);

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
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String convertEDIInvoiceGetTMLSoSeq( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][convertEDIInvoiceGetTMLSoSeq(TesTmlSoHdrVO) \n");

		DBRowSet dbRs = null;
		String seq = null;
		
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(tesEdiSoHdrVO != null){
				Map<String, String> mapVO = tesEdiSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRs = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceGetTMLSoSeqRSQL(), param, velParam);
			
			if ( dbRs!=null && dbRs.next() ){
				seq = dbRs.getString("SEQ");
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
		
		return seq;
		
	}

	/**
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTesTmlSoHdr( TesEdiSoHdrVO tesEdiSoHdrVO ) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][convertEDIInvoiceTesTmlSoHdr \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (	"".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()) ||
				"".equals(tesEdiSoHdrVO.getTmlEdiSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlSoSeq()) )
		{
//			throw new DAOException("TESInvoiceCommonDBDAO.convertEDIInvoiceTesTmlSoHdr - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "convertEDIInvoiceUpdateTesEdiSoHdr"} ).getMessage());
		}		
		try {
			Map<String, String> mapVO	= tesEdiSoHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );				
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmlSoHdrCSQL(), param, velParam);
			
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
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceUpdateTesEdiSoHdr(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {
		log.debug("\n[TESInvoiceCommonDBDAO][convertEDIInvoiceUpdateTesEdiSoHdr \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (	"".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()) ||
				"".equals(tesEdiSoHdrVO.getTmlEdiSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlSoSeq()) )
		{
//			throw new DAOException("TESInvoiceCommonDBDAO.convertEDIInvoiceUpdateTesEdiSoHdr - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "convertEDIInvoiceUpdateTesEdiSoHdr"} ).getMessage());
		}		
		try {
			Map<String, String> mapVO	= tesEdiSoHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );				
				velParam.putAll( mapVO );	 
			}
			
//			int insCnt = 
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceUpdateTesEdiSoHdrUSQL(), param, velParam);
			
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
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTesTmsSoDtl(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][convertEDIInvoiceTesTmsSoDtl \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if (	"".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()) ||
				"".equals(tesEdiSoHdrVO.getTmlEdiSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlInvTpCd())
			){
//			throw new DAOException("TESInvoiceCommonDBDAO.convertEDIInvoiceTesTmsSoDtl - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "convertEDIInvoiceTesTmsSoDtl"} ).getMessage());
		}		
		try {
			Map<String, String> mapVO	= tesEdiSoHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );				
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceTesTmsSoDtlCSQL(), param, velParam);
			
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

		log.debug("\n DAO.convertEDIInvoice_TES_TML_SO_DTL \n");
	}

	/**
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTmlSoVVDList(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {

		log.debug("\n[TESInvoiceCommonDBDAO][convertEDIInvoiceTmlSoVVDList \n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (	"".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()) ||
				"".equals(tesEdiSoHdrVO.getTmlEdiSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlSoSeq()) )
		{
//			throw new DAOException("TESInvoiceCommonDBDAO.convertEDIInvoiceTmlSoVVDList - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "convertEDIInvoiceTmlSoVVDList"} ).getMessage());
		}		
		try {
			Map<String, String> mapVO	= tesEdiSoHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );				
				velParam.putAll( mapVO );	 
			}
			
//			int insCnt = 
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceTmlSoVVDListCSQL(), param, velParam);
			
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
	 * 2009-08-27 [PJM-200900072] : EDI Invoice 정규 Invoice 기본정보로 전환에 부산신항만(180020) 추가
	 * EDI로 접수된 Invoice(TEMP)를 실제 SO Table로 옮긴다.
	 * TES_EDI_SO_HDR의 PK : tml_edi_so_ofc_cty_cd + tml_edi_so_seq
	 * @param TesEdiSoHdrVO tesEdiSoHdrVO
	 * @exception DAOException
	 */
	public void convertEDIInvoiceTesEdiSoFile(TesEdiSoHdrVO tesEdiSoHdrVO) throws DAOException {

		log.debug("\n DAO.convertEDIInvoiceTesEdiSoFile(TesEdiSoHdrVO) \n");

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (	"".equals(tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()) ||
				"".equals(tesEdiSoHdrVO.getTmlEdiSoSeq())||
				"".equals(tesEdiSoHdrVO.getTmlSoSeq()) )
		{
//			throw new DAOException("TESInvoiceCommonDBDAO.convertEDIInvoiceUpdateTesEdiSoHdr - 필수 인자 오류!");
			throw new DAOException(new ErrorHandler("TES00077", new String[]{"TESInvoiceCommonDBDAO", "convertEDIInvoiceUpdateTesEdiSoHdr"} ).getMessage());
		}		
		try {
			Map<String, String> mapVO	= tesEdiSoHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );				
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOConvertEDIInvoiceTesEdiSoFileUSQL(), param, velParam);
			
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
	 * CSR이 처음 만들어진 후 3개월이 경과한 건을 조회
	 * @param String ofcCd
	 * @return SearchOldCsrDataVO
	 * @exception DAOException
	 */
	public DBRowSet searchOldCsrData(String ofcCd) throws DAOException{
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchOldCsrDataRSQL(), param, velParam);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
		return dbRowset;			
	}	
	
	
	/**
	 * Invoice이 처음 만들어진 후 3개월이 경과한 건을 조회
	 * @param String ofcCd
	 * @return SearchOldInvDataVO
	 * @exception DAOException
	 */
	public DBRowSet searchOldInvData(String ofcCd) throws DAOException{
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchOldInvDataRSQL(), param, velParam);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
		return dbRowset;			
	}
	
	
	/**
	 * CSR이 처음 만들어진 후 3개월이 경과한 건이 있는지 Check
	 * @param String ofcCd
	 * @return SearchOldCsrDataVO
	 * @exception DAOException
	 */
	public String searchOldCsrExistChk(String ofcCd) throws DAOException{
		DBRowSet dbRowset = null;
		String retVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchOldCsrExistChkRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				retVal = dbRowset.getString("csr_exist_chk");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
		return retVal;			
	}	
	
	
	/**
	 * Invoice이 처음 만들어진 후 3개월이 경과한 건이 있는지 Check
	 * @param String ofcCd
	 * @return SearchOldInvDataVO
	 * @exception DAOException
	 */
	public String searchOldInvExistChk(String ofcCd) throws DAOException{
		DBRowSet dbRowset = null;
		String retVal = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchOldInvExistChkRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				retVal = dbRowset.getString("inv_exist_chk");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
		return retVal;			
	}
	
	/**
	 * session의 ofc_cd를 기준으로 (session이 아닌) MDM의 CONTI_CD를 조회
	 * @param String ofc_cd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public String searchContiCd(String ofc_cd) throws DAOException {

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("\n[TESInvoiceCommonDBDAO][searchContiCd][] - \n");

			if ( !"".equals(ofc_cd) ) {
				param.put("ofc_cd", ofc_cd);
				velParam.put("ofc_cd", ofc_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchContiCdRSQL(), param, velParam);
			
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
	 * SVXXJO가 minus값 이고 Invoice office가 CGPBO,JKTBB,LOSBA,NYCBB,SINBB,TEMBA, 2013년 4/8일 기준 1년 전까지를 대상으로
	 * account code는  954113인 Invoice 확인
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @exception DAOException
	 */
	public void searchMinusInvAmtSvxxJoExist(TesTmlSoHdrVO[] tesTmlSoHdrVOs) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String		jo_exist_flg		= "";
		String		inv_no	= "";

		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = null;

			for (int k = 0; k < tesTmlSoHdrVOs.length; k++ ){
				tesTmlSoHdrVO = (TesTmlSoHdrVO)tesTmlSoHdrVOs[k];
				
				param.put("inv_no", tesTmlSoHdrVO.getInvNo());
				param.put("vndr_seq", tesTmlSoHdrVO.getVndrSeq());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESInvoiceCommonDBDAOSearchMinusInvAmtSvxxJoExistRSQL(), param, velParam);

				if ( dbRowset != null && dbRowset.next()){
					jo_exist_flg = dbRowset.getString("JO_EXIST_FLG");
					inv_no	     = dbRowset.getString("INV_NO");
					if ( jo_exist_flg != null && "Y".equals(jo_exist_flg.trim())){
						throw new DAOException("\n\nWhen terminal invoice \""+inv_no+"\" has cost code 'SVXXJO' with minus amount and the matched debit note was already interfaced to ERP before April 8, 2013, D/note invoice is the target of modifing account code from '954113' to '954111' in TES & ERP by system update since account code mapping is changed as of April 8, 2013. \n\nFor above relevent case, kindly requested to inform  CSR no of D/note invoice to PIC of each system module as follwoing. \n\n(ysyang@hanjin.com; yongary@cyberlogitec.com;\nsam2la4@cyberlogitec.com;swcho@hanjin.com)\n\n");
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
	 * Agreement 정보 update
	 *  
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param String fromDate
	 * @param String toDate
	 * @throws DAOException
	 */
	public void updateInvoiceDetailAgmt(TesTmlSoHdrVO tesTmlSoHdrVO, String fromDate, String toDate) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			if ( !"".equals( tesTmlSoHdrVO.getTmlSoOfcCtyCd() ) ) {
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
			}
			
			if ( !"".equals( tesTmlSoHdrVO.getTmlSoSeq() ) ) {
				param.put("tml_so_seq", tesTmlSoHdrVO.getTmlSoSeq() );
			}
			
			if ( !"".equals( tesTmlSoHdrVO.getVndrSeq() ) ) {
				param.put("vndr_seq", tesTmlSoHdrVO.getVndrSeq() );
			}
			
			if ( !"".equals( tesTmlSoHdrVO.getYdCd() ) ) {
				param.put("yd_cd", tesTmlSoHdrVO.getYdCd() );
			}
			
			if ( !"".equals( fromDate ) ) {
				param.put("from_date", fromDate );
			}
			
			if ( !"".equals( toDate ) ) {
				param.put("to_date", toDate );
			}		
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TESInvoiceCommonDBDAOUpdateInvoiceDetailAgmtUSQL(), param, velParam);

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