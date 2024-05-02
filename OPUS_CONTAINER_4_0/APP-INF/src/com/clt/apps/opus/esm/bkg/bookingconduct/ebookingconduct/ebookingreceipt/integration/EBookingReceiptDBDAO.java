/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingReceiptDBDAO.java
 *@FileTitle : e-Booking n SI Process
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.05.21 전용진
 * 1.0 Creation
* ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
 * 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgUsaCstmsFileNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterAwkCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCntrMkDescVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterDgCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRfCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.CodecoEdiForVgmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.DgRiderCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.KrXptLicNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusAkVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusCntrTpszVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusHbl1VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusMndVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusQtyDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusRfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusXptImpLicListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDescVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiInstrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiRefVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteOfcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteUserIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RjctSndrRcvrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCmShipmentVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrPoNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterHbl1VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterMndVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterPoDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstTabVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterUsaCstmsFileNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterXptLicVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOManageRefNoCSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOManageRefNoUSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgXterCntrSealNoVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;


/**
 * OPUS EBookingReceiptDBDAO <br>
 * - OPUS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptBCImpl 참조
 * @since J2EE 1.4
 */
public class EBookingReceiptDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306084558829118142L;

	/**
	 * bkg_xter_aes에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterAes(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_AES");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterAesCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_awk_cgo에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO 
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterAwkCgo(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_AWK_CGO");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterAwkCgoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterCntr(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		ArrayList<String> cntrNoValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_CNTR");
		Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
								param.put(tmpColVals[0].substring(2, tmpColVals[0].length()), tmpColVals[1]);
								velParam.put(tmpColVals[0].substring(2, tmpColVals[0].length()), tmpColVals[1]);
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
								
								param.put(tmpColVals[0].substring(2, tmpColVals[0].length()), tmpColVals[1]);
								velParam.put(tmpColVals[0].substring(2, tmpColVals[0].length()), tmpColVals[1]);
								
								if ( "CNTR_NO".equals(tmpColVals[0].substring(2, tmpColVals[0].length())) ) {
									cntrNoValues.add(strReplace(tmpColVals[1],"'","''"));
								}
							}
						}
					}
				}
				log.debug("cntrNoValues:"+cntrNoValues.size());
				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
				velParam.put("cntr_no",  cntrNoValues);
				velParam.put("cntr_no_size",  cntrNoValues.size());
			}
			if(xterRqstNoVO != null){
				int result = 0;
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCntrRSQL(), param, velParam);
				List<BkgXterCntrVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterCntrVO.class);
				if(list != null && list.size() > 0) result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCntrUSQL(), param, velParam);
				else result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCntrCSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr_mk_desc에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterCntrMkDesc(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		ArrayList<String> cntrNoValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_CNTR_MK_DESC");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								if ( "MK_DESC_SEQ".equals(tmpColVals[0].substring(2, tmpColVals[0].length())) ) {
									continue;
								} else {
									tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
									tableValues.add(strReplace(tmpColVals[1],"'","''"));
								}
								if ( "CNTR_NO".equals(tmpColVals[0].substring(2, tmpColVals[0].length())) ) {
									cntrNoValues.add(strReplace(tmpColVals[1],"'","''"));
								}
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
				velParam.put("cntr_no",  cntrNoValues);
				velParam.put("cntr_no_size",  cntrNoValues.size());
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCntrMkDescCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * BKG_XTER_CNTR_SEAL_NO에 INSERT한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterCntrSealNo(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_CNTR_SEAL_NO");

		try {
			ArrayList<BkgXterCntrSealNoVO> bkgXterCntrSealNoVOs = new ArrayList<BkgXterCntrSealNoVO> ();


			if(colVals != null){
				String cntrNo = "";
				for (int i = 0; i < colVals.length; i++) {
					if (colVals[i] != null) {
						tmpColVals = colVals[i].split(":");
						if (tmpColVals.length == 2){
							String fldNm = tmpColVals[0].substring(2);
							String fldVl = tmpColVals[1];
	
							BkgXterCntrSealNoVO bkgXterCntrSealNoVO = new BkgXterCntrSealNoVO();
							if (fldNm.equals("CNTR_NO")) {
								cntrNo = fldVl;
							}
							else {
								if (cntrNo == null || "".equals(cntrNo.trim())) {
									cntrNo = "NO DATA";
								}
								bkgXterCntrSealNoVO.setXterSndrId(xterRqstNoVO.getSenderId());
								bkgXterCntrSealNoVO.setXterRqstNo(xterRqstNoVO.getRqstNo());
								bkgXterCntrSealNoVO.setXterRqstSeq(xterRqstNoVO.getRqstSeq());							
								bkgXterCntrSealNoVO.setCntrNo(cntrNo);
								bkgXterCntrSealNoVO.setXterCntrSealNo(fldVl);
	
								bkgXterCntrSealNoVOs.add(bkgXterCntrSealNoVO);
	
							}
						}

					}
				}
				if ( bkgXterCntrSealNoVOs.size() > 0){
					int updCnt[] = null;
					SQLExecuter sqlExe = new SQLExecuter("");
					updCnt = sqlExe.executeBatch((ISQLTemplate) new EBookingReceiptDBDAOaddBkgXterCntrSealNoCSQL(), bkgXterCntrSealNoVOs, velParam);
					for (int i = 0; i < updCnt.length; i++)
					{
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
	
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cust에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterCust(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		BookingUtil util = new BookingUtil();
		log.debug("INSERT TABLE:BKG_XTER_CUST");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCustCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_dg_seq에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterDgCgo(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_DG_CGO");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterDgCgoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_instr에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterInstr(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_INSTR");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterInstrCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_qty에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterQty(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_QTY");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterQtyCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_rf_cgo에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterRfCgo(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_RF_CGO");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRfCgoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_rqst_cng에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterRqstCng(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_RQST_CNG");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRqstCngCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_rqst_misc에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterRqstMisc(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_RQST_MISC");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRqstMiscCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_rqst_mst에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterRqstMst(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_RQST_MST");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								
								if ("XTER_BKG_RMK1".equals(tmpColVals[0].substring(2, tmpColVals[0].length())) || "XTER_BKG_RMK2".equals(tmpColVals[0].substring(2, tmpColVals[0].length()))) {
									byte[] befStr = strReplace(tmpColVals[1],"'","''").getBytes();
									if (befStr.length >= 3999) {
										byte[] afStr = new byte[befStr.length];
										System.arraycopy(befStr, 0, afStr, 0, 3999);
										tableValues.add(new String(afStr).trim());									
									}else{									
										tableValues.add(strReplace(tmpColVals[1],"'","''"));									
									}
								}else{
									tableValues.add(strReplace(tmpColVals[1],"'","''"));																		
								}
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRqstMstCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_tro에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterTro(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_TRO");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterTroCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_tro_dtl에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterTroDtl(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_TRO_DTL");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterTroDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_xpt_lic_no에 insert한다.<br>
	 * pk가 flat file에 포함되어 있음.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterXptLicNo(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_XPT_LIC_NO");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterXptLicNoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_xter_xpt_lic_no에 update한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void updateBkgXterXptLicNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("INSERT TABLE:BKG_XTER_XPT_LIC_NO UPDATE");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOupdateBkgXterXptLicNoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 *  BKG_XTER_CUST BXC에 update한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void updateBkgXterCustCode(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("INSERT TABLE: BKG_XTER_CUST BXC UPDATE");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOupdateBkgXterCustCodeUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	/**

	 * assign된 bkg_no가 있는지 조회한다..<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterRqstNoVO>
	 * @exception DAOException
	 */		
	public String searchXterRqstMstBkgNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;		
		String xterbkgBlNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRqstMstBkgNoRSQLRSQL(), param, velParam);
		    while (dbRowset.next()) {
		    	xterbkgBlNo = dbRowset.getString("BKG_NO");
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterbkgBlNo;
	}
	
	/**
	 * assign된 bkg_no를 update한다..<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */		
	public void assignBkgNoToXterRqst(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModityBkgNoToRqstMstUSQL(), param, velParam);				

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}			
	}

	/**
	 * bkg_xter_rqst_mst에 bkg_upld_sts_cd를 newSts로 update한다.<br>
	 * newSts가 'D'일 경우 rqst_delt_flg를 'y'로 update한다.<br>
	 *
	 * @param String userId
	 * @param String newSts
	 * @param List<XterRqstNoVO> xterRqstNoVOs
	 * @exception DAOException
	 */
	public void changeXterRqstStatus(String userId, String newSts, List<XterRqstNoVO> xterRqstNoVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(newSts != null){
				param.put("bkg_upld_sts_cd", newSts);
				velParam.put("bkg_upld_sts_cd", newSts);
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(xterRqstNoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EBookingReceiptDBDAOchangeXterRqstStatusUSQL(), xterRqstNoVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr을 mst -> hbl로 복사한다<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void copyBkgXterCntr(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOcopyBkgXterCntrCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr_mk_desc을 mst -> hbl로 복사한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void copyBkgXterCntrMkDesc(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOcopyBkgXterCntrMkDescCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr_mk_desc을 mst -> hbl로 복사한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void copyBkgXterCntrSealNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOcopyBkgXterCntrSealNoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr_mk_desc을 mst -> hbl로 복사한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void copyBkgXterCust(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOcopyBkgXterCustCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_cntr_mk_desc을 mst -> hbl로 복사한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void copyBkgXterRqstMst(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOcopyBkgXterRqstMstCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Null 체크<br>
	 *
	 * @param String str
	 * @return boolean
	 */
	private boolean isNull(String str) {
		return (str==null || str.trim().length()==0 || "null".equals(str));
	}
	/**
	 * rqst건에 대해 auto confirm을 전송 했음을 기록한다..<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @exception DAOException
	 */			
	public void modifyAutoBkgRctSend(XterRqstNoVO xterRqstNoVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyAutoBkgRctSendUSQL(), param, velParam);				

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}			
	} 
	/**
	 * 해당 Rqst에 대한 Handling Office를 조회하여 update한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param gdsDesc String  
	 * @param mkDesc String 
	 * @exception DAOException
	 */
	public void modifyHandlingOfc(XterRqstNoVO xterRqstNoVO, String gdsDesc, String mkDesc)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("gds_desc", gdsDesc);
			param.put("mk_desc", mkDesc);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyHandlingOfcUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	/**
	 * eBkg을 통해 Bkg No가 생성된 경우 그 정보를 BKG_XTER_RQST_MST에 업데이트함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyXterBkgNo(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyXterBkgNoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * eBkg Customer Code를 OPUS Customer 정보를 토대로 업데이트함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyXterCustCustCd(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyXterCustCustCdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_xter_rqst_mst에 reject reason code, reject remark, upld_usr_id, upld_dt 를 update한다.<br>
	 *
	 * @param String rjctRsnRmk
	 * @param String xterRjctRsnCd
	 * @param String usrId
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void modifyXterRqstReject(String rjctRsnRmk, String xterRjctRsnCd, String usrId, XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("rjct_rsn_rmk", rjctRsnRmk);
				velParam.put("rjct_rsn_rmk", rjctRsnRmk);
				param.put("xter_rjct_rsn_cd", xterRjctRsnCd);
				velParam.put("xter_rjct_rsn_cd", xterRjctRsnCd);
				param.put("upld_usr_id", usrId);
				velParam.put("upld_usr_id", usrId);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOmodifyXterRqstRejectUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Null replace<br>
	 *
	 * @param String str
	 * @return String
	 */
	private String replaceNull(String str) {
		return (str==null)?"":str;
	}

	/**
	 * assign된 bkg_no가 있는지 조회한다..<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterRqstNoVO>
	 * @exception DAOException
	 */		
	public String seachXterRqstMstBkgNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;		
		String xterbkgBlNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRqstMstBkgNoRSQLRSQL(), param, velParam);
			while (dbRowset.next()) {
				xterbkgBlNo = dbRowset.getString("BKG_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterbkgBlNo;
	}
	/**
	 * OPUS BKG AWK Cargo 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusAkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusAkVO> searchOpusAk(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusAkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusAkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusAkVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG 정보 조회.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return OpusBkgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OpusBkgVO searchOpusBkg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusBkgVO> list = null;
		OpusBkgVO opusBkgVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusBkgVO.class);
			if (list != null && list.size() > 0) {
				opusBkgVO = (OpusBkgVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return opusBkgVO;
	}
	/**
	 * OPUS C/M 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusCmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusCmVO> searchOpusCm(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusCmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusCmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusCmVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG CNTR 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusCntrVO> searchOpusCntr(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusCntrVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG CNTR SEAL NO 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCntrSealNoVO> searchOpusCntrSealNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCntrSealNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusCntrSealNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrSealNoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * BKG별 CNTR별 Container Type/Size 조회<br>
	 *
	 * @param bkgNo String
	 * @return List&lt;OpusCntrTpszVO&gt;
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusCntrTpszVO> searchOpusCntrTpSz(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusCntrTpszVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusCntrTpSzRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusCntrTpszVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * EBookingReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusDgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusDgVO> searchOpusDg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusDgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusDgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusDgVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG House B/L 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusHbl1VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusHbl1VO> searchOpusHbl1(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusHbl1VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusHbl1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusHbl1VO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * 미주 NVOCC Filer 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgUsaCstmsFileNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgUsaCstmsFileNoVO> searchOpusHbl2(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgUsaCstmsFileNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusHbl2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsaCstmsFileNoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG M&D 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusMndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusMndVO> searchOpusMnd(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusMndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusMndRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusMndVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * OPUS BKG QTY 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusQtyVO> searchOpusQty(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusQtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusQtyVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG QTY DETAIL 정보 조회<br>
	 * 
	 * @author KimByungKyu
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusQtyDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusQtyDtlVO> searchOpusQtyDtl(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusQtyDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchOpusQtyDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusQtyDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG RF CARGO 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusRfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusRfVO> searchOpusRf(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusRfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusRfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusRfVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG TRO Master 정보 조회<br>
	 *
	 * @param  XterRqstNoVO xterRqstNoVO
	 * @return List<OpusTroMstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusTroMstVO> searchOpusTro(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusTroMstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusTroMstVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG TRO 상세 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusTroDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusTroDtlVO> searchOpusTroDtl(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusTroDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusTroDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusTroDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * OPUS BKG Route (T/S) 상세 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<VslSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VslSkdVO> searchOpusVvd(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * ALSP BKG 수출 허가 번호 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<OpusXptImpLicListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpusXptImpLicListVO> searchOpusXptImpLicList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpusXptImpLicListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchOpusXptImpLicListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpusXptImpLicListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * continent code를 조회한다.<br>
	 *
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	public List<BkgComboVO> searchComboMdmConti() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			EBookingReceiptDBDAOsearchComboMdmContiRSQL template = new EBookingReceiptDBDAOsearchComboMdmContiRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setComboCd(dbRowset.getString("CONTI_CD"));
				vo.setVal(dbRowset.getString("CONTI_CD"));
				vo.setName(dbRowset.getString("CONTI_NM"));
				vo.setDesc(dbRowset.getString("CONTI_NM"));
				list.add(vo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * eBKG, eSI를 처리해야 하는 Office를 결정 한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchHandlingOfc(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ofcCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchHandlingOfcRSQL(), param, velParam);
			while (dbRowset.next()) {
				ofcCd = dbRowset.getString("OFC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ofcCd;
	}
	
	/**
	 * eBKG 또는 eSI 수신 처리 결과가 Reject인 경우에 reply 메시지 Header를 만듬<br>
	 * @param xterRqstNoVO
	 * @param hrdCdgId
	 * @return
	 * @throws DAOException
	 */
	public RjctSndrRcvrVO searchRejectEdiHeader(XterRqstNoVO xterRqstNoVO, String hrdCdgId) throws DAOException {
		DBRowSet dbRowset = null;
		List<RjctSndrRcvrVO> list = null;
		RjctSndrRcvrVO rjctSndrRcvrVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
				mapVO.put("hrd_cdg_id", hrdCdgId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RjctSndrRcvrVO .class);
			if (list != null && list.size() > 0) {
				rjctSndrRcvrVO = (RjctSndrRcvrVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rjctSndrRcvrVO;
	}
	/**
	 * eBKG 또는 eSI 수신 처리 결과가 Reject인 경우에 reply 메시지 Type 을 만듬<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchRejectEdiType(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String ediType = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchRejectEdiTypeRSQL(), param, velParam);
			while (dbRowset.next()) {
				ediType = dbRowset.getString("RESULT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ediType;
	}
	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterAwkCgoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterAwkCgoVO> searchXterAk(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterAwkCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterAkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterAwkCgoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterRqstMstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstMstVO searchXterBkg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstMstVO> list = null;
		XterRqstMstVO xterRqstMstVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstMstVO.class);
			if (list != null && list.size() > 0) {
				xterRqstMstVO = (XterRqstMstVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstMstVO;
	}

	/**
	 * eBKG 또는 eSI 수신 ACK 메시지를 생성 함<br>
	 * @param docTpCd
	 * @param xterRqstNoVO
	 * @param ediSeq
	 * @param resCd
	 * @param hrdCdgId
	 * @return
	 * @throws DAOException
	 */
	public String searchXterBkgAck(String docTpCd, XterRqstNoVO xterRqstNoVO, String ediSeq, String resCd, String hrdCdgId) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("doc_tp_cd", docTpCd);
				param.put("edi_seq", ediSeq);
				param.put("res_cd", resCd);
				param.put("hrd_cdg_id", hrdCdgId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgAckRSQL(), param, param);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;
	}
	/**
	 * eBKG 또는 eSI 수신 ACK 메시지를 생성 대상 Trade Partner인지 확인.<br>
	 *
	 * @param String senderId
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterBkgAckReceiver(String senderId, String hrdCdgId) throws DAOException {
		DBRowSet dbRowset = null;
		String ackRcv = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(senderId != null){
				param.put("sender_id", senderId);
				param.put("hrd_cdg_id", hrdCdgId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL(), param, param);
			while (dbRowset.next()) {
				ackRcv = dbRowset.getString("ACK_RECEIVER");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ackRcv;
	}
	/**
	 * eBKG 또는 eSI 수신시 같이 접수된 BKG No 조회<br>
	 *
	 * @param xterRqstNoVOparam XterRqstNoVOparam
	 * @return XterRqstNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstNoVO searchXterBkgNo(XterRqstNoVO xterRqstNoVOparam) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVOparam .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = (XterRqstNoVO) list.get(0);
			}

			if(xterRqstNoVO == null || xterRqstNoVO.getBkgNo() == null || xterRqstNoVO.getBkgNo().equals("")){
				DBRowSet nullBkgNo = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgNoNullRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(nullBkgNo, XterRqstNoVO .class);
				if (list != null && list.size() > 0) {
					xterRqstNoVO = (XterRqstNoVO) list.get(0);
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstNoVO;
	}

	/**
	 * OPUS BKG Customer 및 MDM Customer 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return BlDocCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlDocCustVO searchXterBlDocCust(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlDocCustVO> list = null;
		BlDocCustVO blDocCustVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBlDocCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlDocCustVO .class);
			if (list != null && list.size() > 0) {
				blDocCustVO = (BlDocCustVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return blDocCustVO;
	}
	/**
	 * bkg_xter_cntr_mk_desc에서 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterCntrMkDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterCntrMkDescVO> searchXterCm(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterCntrMkDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterCntrMkDescVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * bkg_xter_cntr에서 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XterCntrVO> searchXterCntr(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCntrVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * flatfile 생성을 위해 external rqst의 cntr정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiCntrVO> searchXterCntrForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiCntrVO> list = null;
		//			RejectEdiCntrVO rejectEdiCntrVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCntrForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiCntrVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * bkg_xter_cntr_seal_no에서 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterCntrSealNoVO> searchXterCntrSealNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterCntrSealNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCntrSealNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterCntrSealNoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * bkg_xter_cust와 mdm_customer에서 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return BkgXterCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgXterCustVO searchXterCust(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterCustVO> list = null;
		BkgXterCustVO bkgXterCustVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterCustVO .class);
			if (list != null && list.size() > 0) {
				bkgXterCustVO = (BkgXterCustVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgXterCustVO;
	}
	/**
	 * e-bkg receipt ack flat file 생성을 위해 customer master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterCustForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer flatFile = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterCustForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile.append(dbRowset.getString("FLAT_FILE"));
//				flatFile = flatFile + dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile.toString();			
	}
	/**
	 * flatfile 생성을 위해 external rqst의 customer 정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiCustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiCustVO> searchXterCustForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiCustVO> list = null;
		//			RejectEdiCustVO rejectEdiCustVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiCustVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * e-bkg receipt ack flat file 생성을 위해 desc master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterDescForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterDescForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;			
	}
	/**
	 * Reject 메시지를 생성하기 위해 Description of Goods 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiDescVO> searchXterDescForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiDescVO> list = null;
		//			RejectEdiDescVO rejectEdiDescVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterDescForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiDescVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterDgCgoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterDgCgoVO> searchXterDg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterDgCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterDgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterDgCgoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * flatfile 생성을 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiDgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiDgVO> searchXterDgForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiDgVO> list = null;
		//			RejectEdiDgVO rejectEdiDgVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterDgForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiDgVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * external request 정보 중 house b/l 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterHbl1VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XterHbl1VO> searchXterHbl1(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterHbl1VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterHbl1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterHbl1VO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * NVOCC의 AMS File No 및 Piece Count를 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterUsaCstmsFileNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XterUsaCstmsFileNoVO> searchXterHbl2(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterUsaCstmsFileNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterHbl2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterUsaCstmsFileNoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * eBKG 또는 eSI 요청 번호별 House B/L Total Count 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchXterHblCount(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] xterRqstNo = null;
		int idx = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstStatusRSQL(), param, velParam);
			xterRqstNo = new String[dbRowset.getRowCount()];
			while (dbRowset.next()) {
				xterRqstNo[idx++] = dbRowset.getString("XTER_RQST_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstNo;
	}
	/**
	 * 수신 받은 eBKG 또는 eSI의 최종 Sequence 조회<br>
	 *
	 * @param xterRqstNoVOparam XterRqstNoVOparam
	 * @param xterRqstViaCd String 
	 * @param siNo String
	 * @param xterDocTpCd String
	 * @return XterRqstNoVO
	 * @exception DAOException
	 */
	public XterRqstNoVO searchXterHblSeq(XterRqstNoVO xterRqstNoVOparam, String xterRqstViaCd, String siNo, String xterDocTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
		String hblSeq = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVOparam .getColumnValues();

			param.putAll(mapVO);
			//			param.put("rqst_no", xterRqstNoVOparam.getRqstNo());
			//			param.put("sender_id", xterRqstNoVOparam.getSenderId());
			//			param.put("bkg_no", xterRqstNoVOparam.getBkgNo());
			param.put("xter_rqst_via_cd", xterRqstViaCd);
			param.put("si_no", siNo);
			velParam.putAll(mapVO);
			velParam.put("bkg_no", xterRqstNoVOparam.getBkgNo());
			velParam.put("xter_Doc_Tp_Cd", xterDocTpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterHblSeqRSQL(), param, velParam);
			while (dbRowset.next()) {
				hblSeq = dbRowset.getString("XTER_RQST_SEQ");
			}
			xterRqstNoVO.setRqstSeq(hblSeq);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstNoVO;
	}
	/**
	 * Reject EDI 메시지 생성을 위한 eBKG 또는 eSI Instruction 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return RejectEdiInstrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RejectEdiInstrVO searchXterInstrForRejeceEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiInstrVO> list = null;
		RejectEdiInstrVO rejectEdiInstrVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterInstrForRejeceEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiInstrVO .class);
			if (list != null && list.size() > 0) {
				rejectEdiInstrVO = (RejectEdiInstrVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rejectEdiInstrVO;
	}
	/**
	 * external request 처리를 위해 external rqst의 mark & Description 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String usrOfc
	 * @return List<XterMndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XterMndVO> searchXterMnd(XterRqstNoVO xterRqstNoVO, String usrOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterMndVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("usr_ofc", usrOfc);
				velParam.put("usr_ofc", usrOfc);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterMndRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterMndVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * bkg_xter_qty에서 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterQtyVO> searchXterQty(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterQtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterQtyVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * flatfile 생성을 위해 external rqst의 물량 정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiQtyVO> searchXterQtyForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiQtyVO> list = null;
		//			RejectEdiQtyVO rejectEdiQtyVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterQtyForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiQtyVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterRfCgoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterRfCgoVO> searchXterRf(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterRfCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterRfCgoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * bkg_xter_rqst_mst, bkg_xter_cust, com_user, mdm_location 테이블에서 화면상의 항목을 조회한다.<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExternalRqstListVO> searchXterRqstList(ExternalRqstListInputVO xterRqstListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExternalRqstListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstListInputVO != null){
				if (!JSPUtil.getNull(xterRqstListInputVO.getXterBkgRqstStsCd()).equals("")) {
					xterRqstListInputVO.setXterBkgRqstStsCd("'" + xterRqstListInputVO.getXterBkgRqstStsCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(xterRqstListInputVO.getBkgUpldStsCd()).equals("")) {
					xterRqstListInputVO.setBkgUpldStsCd("'" + xterRqstListInputVO.getBkgUpldStsCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(xterRqstListInputVO.getXterRqstViaCd()).equals("")) {
					xterRqstListInputVO.setXterRqstViaCd("'" + xterRqstListInputVO.getXterRqstViaCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(xterRqstListInputVO.getDocTpCd()).equals("")) {
					xterRqstListInputVO.setDocTpCd("'" + xterRqstListInputVO.getDocTpCd().replaceAll(",", "','") + "'");
				}
				if (!JSPUtil.getNull(xterRqstListInputVO.getDelivery()).equals("")) {
					xterRqstListInputVO.setDelivery("'" + xterRqstListInputVO.getDelivery().replaceAll(",", "','") + "'");
				}
				Map<String, String> mapVO = xterRqstListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExternalRqstListVO .class);
//			if ( list != null && list.size() > 0 ) {
//				ExternalRqstListVO externalRqstListVO = list.get(0);
//				externalRqstListVO.setMaxRows(Integer.parseInt(externalRqstListVO.getRowCount()));
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * e-bkg receipt ack flat file 생성을 위해 misc master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterRqstMiscForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EbookingReceiptDBDAOSearchXterRqstMiscForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;			
	}
	/**
	 * e-bkg receipt ack flat file 생성을 위해 rqst master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterRqstMstForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRqstMstForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;			
	}
	/**
	 * flatfile 생성을 위해 external rqst의 master 정보를 조회한다.<br>
	 * 
	 * @param String rcvId
	 * @param String rejectRmk
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return RejectEdiMstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RejectEdiMstVO searchXterRqstMstForRejectEdi(String rcvId, String rejectRmk, XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiMstVO> list = null;
		RejectEdiMstVO rejectEdiMstVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("rcv_id", rcvId);
				param.put("reject_rmk", rejectRmk);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstMstForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiMstVO .class);
			if (list != null && list.size() > 0) {
				rejectEdiMstVO = (RejectEdiMstVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rejectEdiMstVO;
	}
	/**
	 * eBKG 또는 eSI 수신 요청 번호 별로 House B/L 이 아닌 Max Sequqnce 조회<br>
	 *
	 * @param String xterSndrId
	 * @param String xterRqstNo
	 * @param String xterDocTpCd
	 * @return XterRqstNoVO
	 * @exception DAOException
	 */
	public XterRqstNoVO searchXterRqstMstSeq(String xterSndrId, String xterRqstNo, String xterDocTpCd) throws DAOException {
		XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNo != null && xterSndrId != null){
				param.put("xter_sndr_id", xterSndrId);
				param.put("xter_rqst_no", xterRqstNo);
				param.put("xter_doc_tp_cd", xterDocTpCd);
				velParam.put("xter_doc_tp_cd", xterDocTpCd);
			}
			int pegasusSeq = 0;
			int xterRqstSeq = 0;
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstMstSeqCheckRSQL(), param, velParam);
			while (dbRowset.next()) {
				pegasusSeq = dbRowset.getInt("RQST_SEQ");
			}
			DBRowSet rowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL(), param, velParam);
			while (rowset.next()) {
				xterRqstSeq = rowset.getInt("RQST_SEQ");
			}
			
			if(pegasusSeq > xterRqstSeq) xterRqstNoVO.setRqstSeq(String.valueOf(pegasusSeq));
			else xterRqstNoVO.setRqstSeq(String.valueOf(xterRqstSeq));
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
//			if (list != null && list.size() > 0) {
//				xterRqstNoVO = (XterRqstNoVO) list.get(0);
//			}
//			
//			if(xterRqstNoVO.getRqstSeq().equals("1")){
//				
//				list = (List)RowSetUtil.rowSetToVOs(rowset, XterRqstNoVO .class);
//				if (list != null && list.size() > 0) {
//					xterRqstNoVO = (XterRqstNoVO) list.get(0);
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstNoVO;
	}
	/**
	 * 해당 Rqst가 처리되면 담당 ofc에 notice하기 위해 office의 email addres를 조회한다..<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchXterRqstNoticeOfc(XterRqstNoVO xterRqstNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		String [] eml = null;
		int idx = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstNoticeOfcRSQL(), param, velParam);

			eml = new String[dbRowset.getRowCount()];
			while (dbRowset.next()) {
				eml[idx++] = dbRowset.getString("EML");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eml;
	}
	/**
	 * External Request Reject Edi를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String ediHeader
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterRqstRejectEdi(XterRqstNoVO xterRqstNoVO, String ediHeader) throws DAOException {
		DBRowSet dbRowset = null;
		String ediBody = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				param.put("ediHeader", ediHeader);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL(), param, velParam);
			while (dbRowset.next()) {
				ediBody = dbRowset.getString("EDI_BODY");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ediBody;
	}
	/**
	 * 주어진 RQST의 STATUS를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterRqstStatus(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rqstSts = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstStatusRSQL(), param, velParam);
			while (dbRowset.next()) {
				rqstSts = dbRowset.getString("BKG_UPLD_STS_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rqstSts;
	}
	/**
	 * eBKG, eSI Upload 화면 (0229화면)의 11개 Tab들의 데이터 여부를 리턴한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterRqstTabVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstTabVO searchXterRqstTab(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstTabVO> list = null;
		XterRqstTabVO xterRqstTabVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstTabRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstTabVO .class);
			if (list != null && list.size() > 0) {
				xterRqstTabVO = (XterRqstTabVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstTabVO;
	}
	/**
	 * bkg_xter_rqst_mst의 xter_rqst_via_code를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterRqstViaCode(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rqstViaCode = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstViaCodeRSQL(), param, velParam);
			while (dbRowset.next()) {
				rqstViaCode = dbRowset.getString("XTER_RQST_VIA_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rqstViaCode;
	}

	/**
	 * 해당 사용자의 external request 조회조건을 조회한다.<br>
	 *
	 * @param String userId
	 * @return List<BkgXterSrchSetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterSrchSetVO> searchXterSrchSetForList(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterSrchSetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(userId != null){
				param.put("usr_id", userId);
				velParam.put("usr_id", userId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSrchSetForListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterSrchSetVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * (Xter)eBooking Tro Master를 조회한다.<br>
	 *
	 * @param  XterRqstNoVO xterRqstNoVO
	 * @return List<BkgXterTroVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterTroVO> searchXterTro(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterTroVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterTroVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * (Xter)eBooking Tro Dtl를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterTroDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterTroDtlVO> searchXterTroDtl(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterTroDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterTroDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterTroDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	/**
	 * e-bkg receipt ack flat file 생성을 위해 tro detail master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterTroDtlForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer flatFile = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterTroDtlForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile.append(dbRowset.getString("FLAT_FILE"));
//				flatFile = flatFile + dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile.toString();			
	}
	/**
	 * e-bkg receipt ack flat file 생성을 위해 tro master 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String searchXterTroForAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterTroForAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;			
	}		
	/**
	 * flatfile 생성을 위해 external rqst의 vsl 정보를 조회한다.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiVvdVO> searchXterVvdForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiVvdVO> list = null;
		//			RejectEdiVvdVO rejectEdiVvdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterVvdForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiVvdVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

//	/**
//	 * eBKG 또는 eSI로 수신 받은 수출 허가 번호 정보 조회<br>
//	 *
//	 * @param xterRqstNoVO XterRqstNoVO
//	 * @return List<BkgXterXptLicNoVO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<BkgXterXptLicNoVO> searchXterXptImpLicList(XterRqstNoVO xterRqstNoVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<BkgXterXptLicNoVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(xterRqstNoVO != null){
//				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
//
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterMndRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterXptLicNoVO.class);
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return list;
//	}

	/**
	 * 첫번째 sep만 split하여 리턴<br>
	 *
	 * @param String str
	 * @param String sep
	 * @return String[]
	 */
	private String[] splitByToken(String str, String sep) {
		String[] retStr = new String[2];

		int splitNo = str.indexOf(sep);
		retStr[0] = str.substring(0, splitNo);
		retStr[1] = str.substring(splitNo+1, str.length());

		return retStr;
	}
	/**
	 * String replace<br>
	 *
	 * @param String dest
	 * @param String src
	 * @param String rep
	 * @return String
	 */
	private String strReplace(String dest,String src,String rep) {
		String retstr="";
		String left="";
		int pos=0;
		if(dest == null) {
			return retstr;
		}

		while(true) {
			if((pos=dest.indexOf(src))!=-1) {
				left = dest.substring(0, pos);
				dest = dest.substring(pos+src.length(), dest.length());
				retstr=retstr+left+rep;
				pos=pos+src.length();
			} else {
				retstr=retstr+dest;
				break;
			}
		}
		return retstr;
	}

	/**
	 * bkg_xter_rqst_mst에 upload 되었음을 기록함<br>
	 * bkg no, confirm date, user, status 변경 등.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void updateXterRqstCfm(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account)  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOUpdateXterRqstCfmUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * rqst건의 shipper에 update함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */		
	public void updateXterShipper(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account)  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOUpdateXterShipperUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * OPUS BKG 정보 조회.<br>
	 * 
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceVO searchOpusPoNo(String bkgNo, String cntrNo) throws DAOException {
		BkgReferenceVO bkgReferenceVO = null;
		List<BkgReferenceVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null && cntrNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
				param.put("cntr_no", cntrNo);
				velParam.put("cntr_no", cntrNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchOpusPoNoRefSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceVO.class);
			if (list != null && list.size() > 0) {
				bkgReferenceVO = (BkgReferenceVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgReferenceVO;
	}
	
	/**
	 * OPUS BKG Customer 및 MDM Customer 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return BlDocCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CustEtcVO searchXterBkgCustEtc(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustEtcVO> list = null;
		CustEtcVO custEtcVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgCustEtcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustEtcVO .class);
			if (list != null && list.size() > 0) {
				custEtcVO = (CustEtcVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return custEtcVO;
	}
	

	/**
	 * bkg_xter_aes에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterTmpBlMkDesc(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_TMP_BL_MK_DESC");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//velParam.put("table_values",   setparam_In(tableValues, "|$$|"));
				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOAddBkgXterTmpBlMkDescCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * BKG_XTER_REF에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterRef(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_REF");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOAddBkgXterRefCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	/**
	 * BKG_XTER_CLUZ에 insert한다.<br>
	 * bkg_xter_rqst_mst와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterCluz(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_CLUZ");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(colVals != null){
				for (int j=0;j<colVals.length;j++) {
					if (colVals[j] != null) {
						tmpColVals = splitByToken(colVals[j], ":");
						if ( !isNull(replaceNull(tmpColVals[1])) ) {
							if ( "D".equals(tmpColVals[0].substring(0, 1)) ) {
								tableDateColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableDateValues.add(strReplace(tmpColVals[1],"'","''"));
							} else {
								tableColumns.add(tmpColVals[0].substring(2, tmpColVals[0].length()));
								tableValues.add(strReplace(tmpColVals[1],"'","''"));
							}
						}
					}
				}
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("table_columns", tableColumns);
				velParam.put("table_values",  tableValues);
				velParam.put("table_date_columns", tableDateColumns);
				velParam.put("table_date_values", tableDateValues);
			}
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOAddBkgXterCluzCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	/**
	 * Inner Package를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterInnerPackageVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XterInnerPackageVO> searchXterInnerPackage(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterInnerPackageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterInnerPackageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterInnerPackageVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Export Licens 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterXptLicVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterXptLicVO searchXterXptLicVO(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterXptLicVO> list = null;
		XterXptLicVO xterXptLicVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterXptLicRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterXptLicVO.class);
			if (list != null && list.size() > 0) {
				xterXptLicVO = (XterXptLicVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterXptLicVO;
	}
	
	/**
	 * Export Licens 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterXptLicVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KrXptLicNoVO> searchKrXptLicNoList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrXptLicNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchKrXptLicNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KrXptLicNoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * SEANACCS인 경우에 VSL_CD DATA 값을 조회한다.<br>
	 *
	 * @param String callSgnNo
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception DAOException
	 */		
	public String searchXterVslCd(String callSgnNo, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;		
		String xterVslCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(callSgnNo != null){
				param.put("call_sgn_no", callSgnNo);
				velParam.put("call_sgn_no", callSgnNo);
				param.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				velParam.put("skd_dir_cd", skdDirCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterVslCdRSQL(), param, velParam);
			while (dbRowset.next()) {
				xterVslCd = dbRowset.getString("VSL_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterVslCd;
	}
	
	/**
	 * eBKG의 Cntr 별 P/O No 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterCntrPoNoVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<XterCntrPoNoVO> searchXterCntrPoNoList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCntrPoNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterCntrPoNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCntrPoNoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * eBKG의 Cntr 별 P/O No 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterPoDtlVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<XterPoDtlVO> searchXterPoDtlNoList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterPoDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterPoDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterPoDtlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Conter Etc Info 를 조회한다.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return CntrEtcInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CntrEtcInfoVO manageCntrEtcInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrEtcInfoVO> list = null;
		CntrEtcInfoVO cntrEtcInfoVO = null;
		//query parameter
		final Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		final Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				final Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOCntrEtcInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrEtcInfoVO .class);
			if (list != null && list.size() > 0) {
				cntrEtcInfoVO = (CntrEtcInfoVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cntrEtcInfoVO;
	}

    /**
	 * OB/L이 Issue 되어었는지 조회한다.
	 * @author 	RyuDaeYoung
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @throws  EventException
	 */
	public String searchBlIss(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String blIss = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBlIssRSQL(), param, velParam);
			if(dbRowset.next()){
				blIss = dbRowset.getString("OBL_ISS_FLG");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blIss;
	}


	/**
	 * bkg_xter_rqst_mst에 bkg_upld_sts_cd를 newSts로 update한다.<br>
	 * newSts가 'D'일 경우 rqst_delt_flg를 'y'로 update한다.<br>
	 * @author 	RyuDaeYoung
	 * @param List<XterRqstNoVO> xterRqstNoVOs
	 * @exception DAOException
	 */
	public void changeXterRqstBkgNo(List<XterRqstNoVO> xterRqstNoVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(xterRqstNoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EBookingReceiptDBDAOchangeXterRqstBkgNoUSQL(), xterRqstNoVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * bkg_xter_rqst_mst테이블에서 SEANACCS Validation 사항을 조회한다.<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstValidationVO searchXterRqstValidation(ExternalRqstListInputVO xterRqstListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstValidationVO> list = null;
		XterRqstValidationVO xterRqstValidationVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstListInputVO != null){
				
				Map<String, String> mapVO = xterRqstListInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstValidationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstValidationVO .class);
			if (list != null && list.size() > 0) {
				xterRqstValidationVO = (XterRqstValidationVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterRqstValidationVO;
	}

	/**
	 * searchMqXlsGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchMqXlsGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bkgHrdCdgCtntVO) {
				Map<String, String> mapVO = bkgHrdCdgCtntVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchMqXlsGroupListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * searchMqXlsMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchMqXlsMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bkgHrdCdgCtntVO) {
				Map<String, String> mapVO = bkgHrdCdgCtntVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchMqXlsMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * searchMqXmlMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchMqXmlMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bkgHrdCdgCtntVO) {
				Map<String, String> mapVO = bkgHrdCdgCtntVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchMqXmlMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	
	/**
     * BkgDgCgoVO 모델에 대한 데이타 조회.
     * 
     * @param String bkgNo
     * @return List<BkgDgCgoVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<BkgDgCgoVO> searchBkgDgCgo( String bkgNo ) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgDgCgoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchBkgDgCgoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDgCgoVO .class);
			
        }catch(SQLException ex){
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            //log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
     
 	/**
 	 * @param XterRqstNoVO xterRqstNoVO
 	 * @return List<XterDgRiderVO>
 	 * @throws DAOException
 	 */
 	public List<XterDgRiderVO> searchOpusDgRiderList(XterRqstNoVO xterRqstNoVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<XterDgRiderVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 			if(xterRqstNoVO != null){
 				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchOpusDgRiderListRSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterDgRiderVO .class);
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
 		}
 		return list;
 	} 

	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<DgRiderCntrListVO>
	 * @throws DAOException
	 */
	public List<DgRiderCntrListVO> searchOpusDgRiderCntrList(XterRqstNoVO xterRqstNoVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<DgRiderCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchOpusDgRiderCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgRiderCntrListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 	
	
	/**
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 */
	public List<XterDgRiderVO> searchXterDgRiderList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterDgRiderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterDgRiderListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterDgRiderVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}	
	
	/**
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<DgRiderCntrListVO>
	 */
	public List<DgRiderCntrListVO> searchXterDgRiderCntrList(XterRqstNoVO xterRqstNoVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<DgRiderCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterDgRiderCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgRiderCntrListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * edi seq를 생성 함<br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterEdiSeqAck() throws DAOException {
		DBRowSet dbRowset = null;
		String ediSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterEdiSeqAckRSQL(), param, velParam);
			while (dbRowset.next()) {
				ediSeq = dbRowset.getString("EDI_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ediSeq;
	}

	/**
	 * BKG_XTER_REF를 조회함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchXterRefAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> refInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRefAckRSQL(), param, velParam);
			if( dbRowset != null) {
				refInfoList = new ArrayList<String>();
				while (dbRowset.next()) {
					refInfoList.add(dbRowset.getString("CNTR_REF_INFO"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return refInfoList;
	}

	/**
	 * edi seq를 생성 함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchXterCustAck(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> custInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCustAckRSQL(), param, velParam);
			if( dbRowset != null) {
				custInfoList = new ArrayList<String>();
				while (dbRowset.next()) {
					custInfoList.add(dbRowset.getString("CNTR_CUST_INFO"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return custInfoList;
	}
	
	
	/**
	 * edi email 주소를 조회 함<br>
	 *
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchSendEmailErrorInfo() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> emailInfoList = new ArrayList<String>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchSendEmailErrorInfoRSQL(), null, null);
			if( emailInfoList != null) {
				emailInfoList = new ArrayList<String>();
				while (dbRowset.next()) {
					emailInfoList.add(dbRowset.getString("ATTR_CTNT1"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return emailInfoList;
	}
	
	/**
	 * e-BKG/SI 송신시 발생한 Error Msg를 사용자가 알 수 있는 내용으로 변환한다.<br>
	 *
	 * @param String errMsg
	 * @return String
	 * @exception DAOException
	 */
	public String searchErrMsgForMail(String errMsg) throws DAOException {
		DBRowSet dbRowset = null;
		String errDesc = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{	
			param.put("err_msg", errMsg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchErrMsgForMailRSQL(), param, velParam);
			while (dbRowset.next()) {
				errDesc = dbRowset.getString("ERR_DESC");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return errDesc;
	}

	/**
	 * eBkg Customer Code를 OPUS Customer 정보를 토대로 업데이트함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String nmAndAddrOvflwFlg
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyNmAndAddrOvflwFlg(XterRqstNoVO xterRqstNoVO, String nmAndAddrOvflwFlg, SignOnUserAccount account) throws DAOException {
		String[] arrOvflwFlg = nmAndAddrOvflwFlg.split(",");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			for (int i=0; i < arrOvflwFlg.length; i++) {
				mapVO.put("nm_and_addr_ovflw_flg", arrOvflwFlg[i]);				

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("");
				if(xterRqstNoVO != null){
					result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyNmAndAddrOvflwFlgUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Reject 메시지를 생성하기 위해 Description of Goods 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<RejectEdiDescVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RejectEdiRefVO> searchXterRefForRejectEdi(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RejectEdiRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRefForRejectEdiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RejectEdiRefVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * bkg_xter_qty에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void addBkgXterQtyByXml(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
		
	/**
	 * 
	 * @param rqstNoVo
	 * @param flatFileStr
	 * @return
	 * @throws DAOException
	 */
	public String addBkgXterRcvMsg(XterRqstNoVO rqstNoVo, String flatFileStr) throws DAOException {
		DBRowSet dbRowset = null;
		String msgSeq = "0";
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rqstNoVo != null){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgXterRcvMsgSeqRSQL(), param, param);
				if(dbRowset.next()) msgSeq = dbRowset.getString(1);
				
				param.putAll(rqstNoVo.getColumnValues());
				param.put("bkg_xter_rcv_msg_seq",  msgSeq);
				param.put("flat_file_str",  flatFileStr);
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL(), param, param);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return msgSeq;
		
	}

	/**
	 * bkg_xter_rcv_msg에 update한다.<br>
	 *
	 * @param String msgSeq
	 * @param String sndrId
	 * @param String rqstNo
	 * @param String rqstSeq
	 * @param String upldFlg
	 * @exception DAOException
	 */
	public void updateBkgXterRcvMsg(String msgSeq, String sndrId, String rqstNo, String rqstSeq, String upldFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(msgSeq != null){				
				param.put("xter_sndr_id", sndrId);
				param.put("xter_rqst_no", rqstNo);
				param.put("xter_rqst_seq", rqstSeq);
				param.put("bkg_xter_rcv_msg_seq",  msgSeq);
				param.put("upld_flg",  upldFlg);

				velParam.put("xter_sndr_id", sndrId);
				velParam.put("xter_rqst_no", rqstNo);
				velParam.put("xter_rqst_seq", rqstSeq);
				velParam.put("bkg_xter_rcv_msg_seq",  msgSeq);
				velParam.put("upld_flg",  upldFlg);

				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOupdateBkgXterRcvMsgUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 
	 * @param String rcvFromDt
	 * @param String rcvToDt
	 * @param String UpldCd
	 * @param String RqstNo
	 * @param String msgSeq
	 * @param String msgDesc
	 * @return List<BkgXterRevMsgVO>
	 * @exception DAOException
	 */
	public List<BkgXterRevMsgVO> searchBkgXterRcvMsgList(String rcvFromDt, String rcvToDt, String upldCd, String rqstNo, String msgSeq, String msgDesc) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterRevMsgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rcvFromDt != null && rcvToDt != null){
				param.put("rcv_from_dt", rcvFromDt);
				param.put("rcv_to_dt", rcvToDt);
				param.put("upld_flg", upldCd);
				param.put("xter_rqst_no",  rqstNo);
				param.put("bkg_xter_rcv_msg_seq",  msgSeq);
				param.put("xml_and_edi_msg_desc",  msgDesc);

				velParam.put("rcv_from_dt", rcvFromDt);
				velParam.put("rcv_to_dt", rcvToDt);
				velParam.put("upld_flg", upldCd);
				velParam.put("xter_rqst_no",  rqstNo);
				velParam.put("bkg_xter_rcv_msg_seq",  msgSeq);
				velParam.put("xml_and_edi_msg_desc",  msgDesc);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgXterRcvMsgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterRevMsgVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}	

	/**
	 * 
	 * @param BkgXterRevMsgVO bkgXterRevMsgVO
	 * @return BkgXterRevMsgVO
	 * @exception DAOException
	 */
	public BkgXterRevMsgVO searchBkgXterRcvMsgView(BkgXterRevMsgVO bkgXterRevMsgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterRevMsgVO> list = null;
		BkgXterRevMsgVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgXterRevMsgVO != null){
				Map<String, String> mapVO = bkgXterRevMsgVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterRevMsgVO.class);
			if (list != null && list.size() > 0) {
				result = (BkgXterRevMsgVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * bkg_xter_rqst_mst에 update한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void updateBkgXterRqstMst(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoVO != null){
				
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOupdateBkgXterRqstMstUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
		
	/**
	 * External Request DOC_TP_CD를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterBkgRqstDocTpCd(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String docTpCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstDocTpCdRSQL(), param, velParam);
			while (dbRowset.next()) {
				docTpCd = dbRowset.getString("DOC_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return docTpCd;
	}
	
	/**
	 * 
	 * @param unlocCd
	 * @return
	 * @throws DAOException
	 */
	public String getUnlocCodeToLocCd(String unlocCd) throws DAOException {
		DBRowSet dbRowset = null;
		String locCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("un_loc_cd", unlocCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchUnLocCdToLocCdRSQL(), param, null);
			while (dbRowset.next()) {
				locCd = dbRowset.getString("LOC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return locCd;
	}
	
	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws DAOException
	 */
	public void ediPegasusBkgXterCntrDelete(String rqstNo, String rqstSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("xter_rqst_no", rqstNo);
			param.put("xter_rqst_seq", rqstSeq);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws DAOException
	 */
	public void ediPegasusBkgXterTroUpdate(String rqstNo, String rqstSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("xter_rqst_no", rqstNo);
			param.put("xter_rqst_seq", rqstSeq);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOEdiPegasusBkgXterTroUSQL(), param, null);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * 
	 * @param custRefNoCtnt
	 * @param usrId
	 * @param bkgNo
	 * @param bkgRefTpCd
	 * @return
	 * @throws DAOException
	 */
	public int modifyBkgReferenceNo(String custRefNoCtnt, String usrId, String bkgNo, String bkgRefTpCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int count = 0;
		try{
			param.put("ca_flg", "N");
			param.put("cust_ref_no_ctnt", custRefNoCtnt);
			param.put("upd_usr_id", usrId);
			param.put("bkg_no", bkgNo);
			param.put("bkg_ref_tp_cd", bkgRefTpCd);
			count = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOManageRefNoUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return count;
	}
	
	/**
	 * 
	 * @param custRefNoCtnt
	 * @param usrId
	 * @param bkgNo
	 * @param bkgRefTpCd
	 * @throws DAOException
	 */
	public void addBkgReference(String custRefNoCtnt, String usrId, String bkgNo, String bkgRefTpCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("ca_flg", "N");
			param.put("cust_ref_no_ctnt", custRefNoCtnt);
			param.put("upd_usr_id", usrId);
			param.put("bkg_no", bkgNo);
			param.put("bkg_ref_tp_cd", bkgRefTpCd);
			param.put("cre_usr_id", usrId);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOManageRefNoCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws DAOException
	 */
	public void ediPegasusBkgXterDgCgoUpdate(String senderId, String rqstNo, String rqstSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("sender_id", senderId);
			param.put("xter_rqst_no", rqstNo);
			param.put("xter_rqst_seq", rqstSeq);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOEdiPegasusBkgXterDgCgoUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param RerouteOfcVO rerouteOfcVO
	 * @param String usr_id
	 * @return List<RerouteOfcVO>
	 * @exception DAOException
	 */
	public List<RerouteOfcVO> searchRerouteOfcCd(RerouteOfcVO rerouteOfcVO, String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<RerouteOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = rerouteOfcVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", usr_id);
			velParam.put("usr_id", usr_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchRerouteOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RerouteOfcVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * office code save.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param String usr_id
	 * @exception DAOException
	 */
	public void changeRerouteRqstOfcCd(XterRqstNoVO rqstNoVo, String usr_id) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rqstNoVo != null){
				
				Map<String, String> mapVO = rqstNoVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usr_id);
				velParam.put("usr_id", usr_id);

				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOupdateRerouteOfcCdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @return List<RerouteUserIdVO>
	 * @exception DAOException
	 */
	public List<RerouteUserIdVO> searchRerouteUserId() throws DAOException {
		DBRowSet dbRowset = null;
		List<RerouteUserIdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchRerouteUserIdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RerouteUserIdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public List<PoOtherShipVO> searchPoNoByShip(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherShipVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchPoNoByShipRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherShipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws DAOException
	 */
	public List<XterCmShipmentVO> searchXterCmShipment(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCmShipmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOEBookingXterCmShipmentRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCmShipmentVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws DAOException
	 */
	public String sendXterRqstNoticeSubject(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;		
		String subject = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSendXterRqstNoticeSubjectRSQL(), param, velParam);
		    while (dbRowset.next()) {
		    	subject = dbRowset.getString(1);
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return subject;
	}
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgVgmUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkgVgmWgtVO != null) {
				Map<String, String> mapVO = bkgVgmWgtVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", bkgVgmWgtVO.getUsrId());
				velParam.putAll(mapVO);
				velParam.put("upd_usr_id", bkgVgmWgtVO.getUsrId());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOmodifybkgVgmUpldUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @return List<CodecoEdiForVgmVO>
	 * @throws DAOException
	 */
	public List<CodecoEdiForVgmVO> searchCodecoEdiForVgm() throws DAOException {
		DBRowSet dbRowset = null;
		List<CodecoEdiForVgmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchCodecoEdiForVgmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodecoEdiForVgmVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * VGM update from CODECO<br>
	 *
	 * @param CodecoEdiForVgmVO codecoEdiForVgmVO
	 * @exception DAOException
	 */
	public void manageVgmInfoFmCodeco(CodecoEdiForVgmVO codecoEdiForVgmVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (codecoEdiForVgmVO != null) {
				Map<String, String> mapVO = codecoEdiForVgmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOmanageVgmInfoFmCodecoCSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param tableData
	 * @param talbeName
	 * @throws DAOException
	 */
	public void addReceiptXterVermas(LinkedHashMap<String, String> tableData, String talbeName) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		try {
			param.put("usr_id", "SYSTEM");
			String[] columns = tableData.keySet().toArray(new String[0]);
			for (int i = 0; i < columns.length; i++) {
				String columnType = columns[i].substring(columns[i].length()-3, columns[i].length());
				if(columnType.equals("_DT")){
					tableDateColumns.add(columns[i]);
					tableDateValues.add(tableData.get(columns[i]));
				}else{
					if(columns[i].indexOf("_ADDR") == -1 && columns[i].indexOf("_NM") == -1 ){
						tableColumns.add(columns[i]);
						tableValues.add(tableData.get(columns[i]));
					}
				}
				param.put(columns[i], tableData.get(columns[i]));
			}
			velParam.put("table_name", talbeName);
			velParam.put("table_columns", tableColumns);
			velParam.put("table_values",  tableValues);
			velParam.put("table_date_columns", tableDateColumns);
			velParam.put("table_date_values", tableDateValues);
			
			int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOReceiptXterVermasCSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param xterSndrId
	 * @param xterVgmDocId
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	public String getReceiptXterVermasSeqMax(String xterSndrId, String xterVgmDocId, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;		
		String maxSeq = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("xter_sndr_id", xterSndrId);
			param.put("xter_vgm_doc_id", xterVgmDocId);
			param.put("cntr_no", cntrNo);
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOReceiptXterVermasSqlMaxRSQL(), param, null);
		    while (dbRowset.next()) {
		    	maxSeq = dbRowset.getString(1);
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxSeq;
	}
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgXterVgmRqstUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (bkgVgmWgtVO != null) {
				Map<String, String> mapVO = bkgVgmWgtVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", bkgVgmWgtVO.getUsrId());
				velParam.putAll(mapVO);
				velParam.put("upd_usr_id", bkgVgmWgtVO.getUsrId());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOmodifyBkgXterVgmRqstUpldUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @return
	 * @throws DAOException
	 */
	public List<XterCntrVO> searchXterCntrVgm(String senderId, String rqstNo, String rqstSeq) throws DAOException {
		DBRowSet dbRowset = null;		
		List<XterCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("sender_id", senderId);
			param.put("rqst_no", rqstNo);
			param.put("rqst_seq", rqstSeq);
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCntrVgmRSQL(), param, null);
		    list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCntrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @param xterCntrVO
	 * @return
	 * @throws DAOException
	 */
	public String selectBkgXterVgm(XterCntrVO xterCntrVO) throws DAOException {
		DBRowSet dbRowset = null;		
		String count = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (xterCntrVO != null) {
				Map<String, String> mapVO = xterCntrVO.getColumnValues();
				param.putAll(mapVO);
			}
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOmanageXterVgmRSQL(), param, null);
		    while (dbRowset.next()) {
		    	count = dbRowset.getString("CNT");
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return count;
	}
	
	/**
	 * 
	 * @param xterCntrVO
	 * @throws DAOException
	 */
	public void manageXterVgm(XterCntrVO xterCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (xterCntrVO != null) {
				Map<String, String> mapVO = xterCntrVO.getColumnValues();
				param.putAll(mapVO);
			}
			int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOmanageXterVgmCSQL(), param, param);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @throws DAOException
	 */
	public void manageXterVgm(XterRqstNoVO xterRqstNoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (xterRqstNoVO != null) {
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
				param.putAll(mapVO);
				int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new EBookingReceiptDBDAOBookingSITickUSQL(), param, param);
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param ediNo
	 * @return
	 * @throws DAOException
	 */
	public LinkedHashMap<String, String> searchCargoSmartValidation(String ediNo) throws DAOException {
		DBRowSet dbRowset = null;		
		LinkedHashMap<String, String> resTpCd = new LinkedHashMap<String, String>();
		//query parameter
		Map<String, String> param = new HashMap<String, String>();
		try{
			param.put("edi_no", ediNo);
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchCargoSmartValidationRSQL(), param, null);
		    while (dbRowset.next()) {
		    	resTpCd.put(dbRowset.getString("XTER_VGM_RQST_SEQ"), dbRowset.getString("RES_TP_CD"));
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return resTpCd;
	}
	
	/**
	 * 
	 * @param apkMsgNo
	 * @param hrdCdgId
	 * @param sndrId
	 * @return
	 * @throws DAOException
	 */
	public String searChcargoSmartAckHeader(String apkMsgNo, String hrdCdgId, String sndrId, String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("apk_msg_no", apkMsgNo);
			param.put("hrd_cdg_id", hrdCdgId);
			param.put("sndr_id", sndrId);
			param.put("rqst_no", rqstNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchCargoSmartAckHeaderRSQL(), param, param);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("HEADER_FILE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile;
	}
	
	/**
	 * 
	 * @param resTpCd
	 * @param ediNo
	 * @param header
	 * @return
	 * @throws DAOException
	 */
	public String searChcargoSmartAck(LinkedHashMap<String, String> resTpCd, String ediNo, String header) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer flatFile = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("edi_no", ediNo);
			String[] resTpCds = resTpCd.keySet().toArray(new String[0]);
			for (int i = 0; i < resTpCds.length; i++) {
				param.put("rqst_seq", resTpCds[i]);
				param.put("res_tp_cd", resTpCd.get(resTpCds[i]));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchCargoSmartAckRSQL(), param, param);
				while (dbRowset.next()) {
					flatFile.append(header + dbRowset.getString("FLAT_FILE"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * 
	 * @param resTpCd
	 * @param ediNo
	 * @param sndrId
	 * @throws DAOException
	 */
	public void updateBkgXterVgmRqst(LinkedHashMap<String, String> resTpCd, String ediNo, String sndrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(ediNo == null || ediNo.equals("")) return;
			
			param.put("edi_no", ediNo);
			param.put("sndr_id", sndrId);
			String[] resTpCds = resTpCd.keySet().toArray(new String[0]);
			for (int i = 0; i < resTpCds.length; i++) {
				param.put("rqst_seq", resTpCds[i]);
				param.put("res_tp_cd", resTpCd.get(resTpCds[i]));
				new SQLExecuter("").executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOUpdateXterVgmRqstUSQL(), param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}




