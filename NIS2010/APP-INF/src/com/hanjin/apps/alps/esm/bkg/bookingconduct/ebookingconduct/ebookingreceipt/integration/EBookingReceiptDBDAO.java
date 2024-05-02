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
 * 2011.04.18 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청
 * 2011.04.21 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청 - searchXterRqstNoticeOfc(),searchXterShprNm() 메소드 삭제
 * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
 * 2011.07.12 김진승 [CHM-201111965-01 [Simple SI] Customer Code I/F 요청
 * 2011.07.11 정선용 [CHM-201112036-01] [INTTRA] S/I Rejection APERAK 요청.
 * 2011.08.24 김기종 [CHM-201112495-01] Split Candidate 후보 flag변경(취소)기능 개발요청
 * 2011.10.19 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청  
 * 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.06.21 조정민 [CHM-201218361] [BKG] [삼성전자] BOKCON 재전송 기능 검토 요청
 * 2012.11.06 김현화 [CHM-201220884-01]APERAK 송신 로직 추가(searchXterBkgAckReceiver)
 * 2012.11.09 김진주 [             ] 자체 개선사항. e-BKG/SI 수신오류 원인 분석 메세지  제공
 * 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
 * 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
 * 2014.11.03 최도순[CHM-201432379] 미주 E-BKG HANDLING OFFICE 지정로직
 * 2014.01.13 최도순 [CHM-201433292] e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAOPrdExecEnisLogCSQL;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsAkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsBbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsCntrTpszVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsHbl1VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsQtyDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsRfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterChgRtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCntrMkDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtPtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtRqstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.DgRiderCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.EBookingControlMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ErrMsgToEsvcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.KrXptLicNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiInstrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RjctSndrRcvrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XptLicNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrPoNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterEtcInterfaceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterHbl1VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterPoDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRefDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstTabVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterShprInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterUsaCstmsFileNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterXptLicVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOSearchCntrTpSzRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration.SpecialCargoRiderDBDAOsearchBlRiderListRSQL;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration.KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgXterCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;

/**
 * ALPS EBookingReceiptDBDAO <br>
 * - ALPS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			throw new DAOException("BKG_XTER_AES " + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_AWK_CGO " + new ErrorHandler(se).getMessage(),se);
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterCntrCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException("BKG_XTER_CNTR" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_CNTR_MK_DESC" + new ErrorHandler(se).getMessage(),se);
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
				String sealPtNm = "";
				for (int i = 0; i < colVals.length; i++) {
					if (colVals[i] != null) {
						tmpColVals = colVals[i].split(":");
						if (tmpColVals.length == 2){
							String fldNm = tmpColVals[0].substring(2);
							String fldVl = tmpColVals[1];
	
							BkgXterCntrSealNoVO bkgXterCntrSealNoVO = new BkgXterCntrSealNoVO();
							if (fldNm.equals("CNTR_NO")) {
								cntrNo = fldVl;
							} else if (fldNm.equals("SEAL_PTY_NM")) {
								sealPtNm = fldVl;
							}				
							else {
								if (cntrNo == null || "".equals(cntrNo.trim())) {
									cntrNo = "NO DATA";
								}
								bkgXterCntrSealNoVO.setXterSndrId(xterRqstNoVO.getSenderId());
								bkgXterCntrSealNoVO.setXterRqstNo(xterRqstNoVO.getRqstNo());
								bkgXterCntrSealNoVO.setXterRqstSeq(xterRqstNoVO.getRqstSeq());							
								bkgXterCntrSealNoVO.setCntrNo(cntrNo);
								bkgXterCntrSealNoVO.setSealPtyNm(sealPtNm);
								bkgXterCntrSealNoVO.setXterCntrSealNo(fldVl);
	
								bkgXterCntrSealNoVOs.add(bkgXterCntrSealNoVO);
								sealPtNm = "";
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
			throw new DAOException("BKG_XTER_CNTR_SEAL_NO" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_CUST" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_DG_CGO" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_INSTR" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_QTY" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_RF_CGO" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_RQST_CNG" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_RQST_MISC" + new ErrorHandler(se).getMessage(),se);
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

								if(tmpColVals[0].equals("N_XTER_RQST_NO")){
									tableValues.add(xterRqstNoVO.getRqstNo());
								} else {
									if(tmpColVals[0].equals("N_GDS_DESC")||tmpColVals[0].equals("N_MK_DESC")){
										tableValues.add(tmpColVals[1]);	
									} else { 
										tableValues.add(strReplace(tmpColVals[1],"'","''"));	
									}
								}
								
								/* 계약번호가 존재하면 고객명 조회 2017.09.05 이소연과장 요청 */
								if(tmpColVals[0].equals("N_CTRT_NO") && (tmpColVals[1] != null && !tmpColVals[1].equals(""))){
									xterRqstNoVO.setCtrtNm(searchContractCustomerName(tmpColVals[1].trim()));
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
			throw new DAOException("BKG_XTER_RQST_MST" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_TRO" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_TRO_DTL" + new ErrorHandler(se).getMessage(),se);
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
			throw new DAOException("BKG_XTER_XPT_LIC_NO" + new ErrorHandler(se).getMessage(),se);
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
	 * @exception DAOException
	 */
	public void modifyXterBkgNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
	 * eBkg Customer Code를 ALPS Customer 정보를 토대로 업데이트함<br>
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
	 * eBkg Simple SI 접수시 Customer 정보가 누락된 경우 Booking에 생성된 Customer 정보를 BKG_XTER_CUST 테이블에 업데이트 함<br>
	 * (Shipper/FF country code, customer seq가 없는 경우 WEB에서 조회시 오류 발생)
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyXterCustForSimpleSi(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws DAOException {
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyXterCustForSimpleSiUSQL(), param, velParam);
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
	 * @param String bkgUpldStsCd
	 * @exception DAOException
	 */
	public void modifyXterRqstReject(String rjctRsnRmk, String xterRjctRsnCd, String usrId, XterRqstNoVO xterRqstNoVO, String bkgUpldStsCd) throws DAOException {
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
				param.put("bkg_upld_sts_cd", bkgUpldStsCd);
				velParam.put("bkg_upld_sts_cd", bkgUpldStsCd);
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
	 * ALPS BKG AWK Cargo 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsAkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsAkVO> searchAlpsAk(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsAkVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisAkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsAkVO .class);
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
	 * ALPS BKG BB Cargo 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsBbVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsBbVO> searchAlpsBb(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsBbVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsBbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsBbVO .class);
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
	 * ALPS BKG 정보 조회.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return AlpsBkgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AlpsBkgVO searchAlpsBkg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsBkgVO> list = null;
		AlpsBkgVO alpsBkgVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsBkgVO.class);
			if (list != null && list.size() > 0) {
				alpsBkgVO = (AlpsBkgVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return alpsBkgVO;
	}
	/**
	 * ALPS C/M 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsCmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsCmVO> searchAlpsCm(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsCmVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisCmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsCmVO .class);
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
	 * ALPS BKG CNTR 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsCntrVO> searchAlpsCntr(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsCntrVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsCntrVO .class);
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
	 * ALPS BKG CNTR SEAL NO 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgCntrSealNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCntrSealNoVO> searchAlpsCntrSealNo(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisCntrSealNoRSQL(), param, velParam);
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
	 * @return List&lt;AlpsCntrTpszVO&gt;
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsCntrTpszVO> searchAlpsCntrTpSz(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsCntrTpszVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsCntrTpSzRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsCntrTpszVO .class);
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
	 * @return List<AlpsDgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsDgVO> searchAlpsDg(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsDgVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisDgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsDgVO .class);
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
	 * ALPS BKG House B/L 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsHbl1VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsHbl1VO> searchAlpsHbl1(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsHbl1VO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisHbl1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsHbl1VO .class);
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
	public List<BkgUsaCstmsFileNoVO> searchAlpsHbl2(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisHbl2RSQL(), param, velParam);
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
	 * ALPS BKG M&D 정보 조회.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsMndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsMndVO> searchAlpsMnd(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsMndVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisMndRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsMndVO .class);
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
	 * ALPS BKG QTY 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsQtyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsQtyVO> searchAlpsQty(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsQtyVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsQtyVO .class);
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
	 * ALPS BKG QTY DETAIL 정보 조회<br>
	 * 
	 * @author KimByungKyu
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsQtyDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsQtyDtlVO> searchAlpsQtyDtl(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsQtyDtlVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsQtyDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsQtyDtlVO .class);
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
	 * ALPS BKG RF CARGO 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsRfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsRfVO> searchAlpsRf(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsRfVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisRfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsRfVO .class);
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
	 * ALPS BKG TRO Master 정보 조회<br>
	 *
	 * @param  XterRqstNoVO xterRqstNoVO
	 * @return List<AlpsTroMstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsTroMstVO> searchAlpsTro(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsTroMstVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisTroRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsTroMstVO .class);
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
	 * ALPS BKG TRO 상세 정보 조회<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<AlpsTroDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsTroDtlVO> searchAlpsTroDtl(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsTroDtlVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchNisTroDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsTroDtlVO .class);
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
	 * ALPS BKG Route (T/S) 상세 정보 조회<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<VslSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VslSkdVO> searchAlpsVvd(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsVvdRSQL(), param, velParam);
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
	 * @return List<AlpsMndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AlpsXptImpLicListVO> searchAlpsXptImpLicList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsXptImpLicListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsXptImpLicListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsXptImpLicListVO.class);
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
	 * EAI로 전송할 Err Msg를 조회한다.<br>
	 *
	 * @param String eaiIfTp
	 * @param String errMsg
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return ErrMsgToEsvcVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ErrMsgToEsvcVO searchErrMsgToEsvc(String eaiIfTp, String errMsg, XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErrMsgToEsvcVO> list = null;
		ErrMsgToEsvcVO errMsgToEsvcVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("ff_ref_no", xterRqstNoVO.getFfRefNo());
				param.put("eai_if_tp", eaiIfTp);
				param.put("err_msg", errMsg);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchErrMsgToEsvcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErrMsgToEsvcVO .class);
			if (list != null && list.size() > 0) {
				errMsgToEsvcVO = (ErrMsgToEsvcVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return errMsgToEsvcVO;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchErrMsgForMailRSQL(), param, velParam);
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
	 * 
	 * @param String rcvId
	 * @return RjctSndrRcvrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RjctSndrRcvrVO searchRejectEdiHeader(String rcvId) throws DAOException {
		DBRowSet dbRowset = null;
		List<RjctSndrRcvrVO> list = null;
		RjctSndrRcvrVO rjctSndrRcvrVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rcvId != null){
				param.put("rcv_id", rcvId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchRejectEdiHeaderRSQL(), param, velParam);
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
	 * external request 처리를 위해 external rqst의 Break Bulk cgo 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<BkgXterBbCgoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterBbCgoVO> searchXterBb(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterBbCgoVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterBbCgoVO .class);
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
	 * VGM outbound를 위한 Flat File Rcv ID 조회<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<TmnlRcvIdVO>
	 * @exception DAOException
	 */
	public List<TmnlRcvIdVO> searchVGMOutboundRcvId(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TmnlRcvIdVO> list = null;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				mapVO.put("brac_cd", "9");
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchVGMOutboundRcvIdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlRcvIdVO .class);
						
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
	 * VGM outbound를 위한 Flat File Header 메시지를 생성 함<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchVGMOutboundHeader(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchVGMOutboundHeaderRSQL(), param, velParam);
			int i=0;
			while (dbRowset.next()) {
				if (i == 0) {
					flatFile = new String[dbRowset.getRowCount()];
				}
				flatFile[i] = dbRowset.getString(1);
				i++;
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
	 * VGM outbound를 위한 Flat File 메시지를 생성 함<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String bracCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVGMOutbound(BkgBlNoVO bkgBlNoVO, String bracCd) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("brac", bracCd);
				velParam.put("brac", bracCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchVGMOutboundRSQL(), param, velParam);
			while (dbRowset.next()) {
				flatFile = dbRowset.getString("FLAT_FILE");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchVGMOutboundCntrRSQL(), param, velParam);
			StringBuilder sb = new StringBuilder();
			while (dbRowset.next()) {
				sb.append(dbRowset.getString("FLAT_FILE"));
			}
			if(!StringUtils.isEmpty(flatFile) && flatFile.indexOf("$VGM_BODY$") > -1){
				flatFile = flatFile.replace("$VGM_BODY$", sb.toString());
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
	 * VGM upload 결과 ACK를 전송하기 위한 Flat File 생성<br>
	 *
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVGMUploadAck(XterVgmRqstListVO xterVgmRqstListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String flatFile = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterVgmRqstListVO != null){
				Map<String, String> mapVO = xterVgmRqstListVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchVGMUploadAckRSQL(), param, velParam);
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
	 * eBKG 또는 eSI 수신 ACK 메시지를 생성 함<br>
	 *
	 * @param String docTpCd
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterBkgAck(String docTpCd, XterRqstNoVO xterRqstNoVO) throws DAOException {
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
				param.put("doc_tp_cd", docTpCd);
				velParam.put("doc_tp_cd", docTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgAckRSQL(), param, velParam);
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
	 * @param String rqstNo
	 * @param String rqstSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterBkgAckReceiver(String senderId, String rqstNo, String rqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String ackRcv = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(senderId != null){
				param.put("sender_id", senderId);
				velParam.put("sender_id", senderId);
		        param.put("rqst_no", rqstNo);
		        velParam.put("rqst_no", rqstNo);
		        param.put("rqst_seq", rqstSeq);
		        velParam.put("rqst_seq", rqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL(), param, velParam);
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

//			param.put("sender_id", xterRqstNoVOparam.getSenderId());
//			param.put("rqst_no",   xterRqstNoVOparam.getRqstNo());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = (XterRqstNoVO) list.get(0);
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
	 * ALPS BKG Customer 및 MDM Customer 정보 조회<br>
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
		String flatFile = "";
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
				//flatFile = flatFile + dbRowset.getString("FLAT_FILE");	
				StringBuffer tmpBuffer = new StringBuffer(flatFile).append(dbRowset.getString("FLAT_FILE"));
				flatFile = tmpBuffer.toString();
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
		String hblSeq = null;

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
			if ( list != null && list.size() > 0 ) {
				ExternalRqstListVO externalRqstListVO = list.get(0);
				externalRqstListVO.setMaxRows(Integer.parseInt(externalRqstListVO.getRowCount()));
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
	@SuppressWarnings("unchecked")
	public XterRqstNoVO searchXterRqstMstSeq(String xterSndrId, String xterRqstNo, String xterDocTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = (XterRqstNoVO) list.get(0);
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
	 * External Request Reject Edi를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterRqstRejectEdi(XterRqstNoVO xterRqstNoVO, String usrId) throws DAOException {
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

				param.put("usr_id", usrId);
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
	 * @param SignOnUserAccount account
	 * @return XterRqstTabVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstTabVO searchXterRqstTab(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws DAOException {
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
				param.put("usr_ofc_cd", account.getOfc_cd());
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
	 * e-SVC로 전송할 EAI I/F를 위해 shipper 정보를 조회함<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return XterShprInfoVO
	 * @exception DAOException
	 */		

	@SuppressWarnings("unchecked")
	public XterShprInfoVO searchXterShprInfo(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterShprInfoVO> list = null;
		XterShprInfoVO xterShprInfoVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterShprInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterShprInfoVO  .class);
			if (list != null && list.size() > 0) {
				xterShprInfoVO  = (XterShprInfoVO ) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterShprInfoVO ;

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
		String flatFile = "";
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
				//flatFile = flatFile + dbRowset.getString("FLAT_FILE");	
				StringBuffer tmpBuffer = new StringBuffer(flatFile).append(dbRowset.getString("FLAT_FILE"));
				flatFile = tmpBuffer.toString();
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
				
				sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyAutoUploadStatusBkgUSQL(), param, velParam);
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
	 * ALPS BKG 정보 조회.<br>
	 * 
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceVO searchAlpsPoNo(String bkgNo, String cntrNo) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchAlpsPoNoRefSeqRSQL(), param, velParam);
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
	 * ALPS BKG Customer 및 MDM Customer 정보 조회<br>
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
	 * Export Licens 정보를 조회한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String cntCd 
	 * @return List<IdXptLicNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XptLicNoVO> searchXptLicNoListByCntCd(XterRqstNoVO xterRqstNoVO, String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<XptLicNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("cnt_cd", cntCd);
				velParam.putAll(mapVO);
				velParam.put("cnt_cd", cntCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXptLicNoByCntCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XptLicNoVO.class);
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
	 * e-Booking Control for Vessel Slot Management 조회(ESM_BKG_1088)<br>
	 *
	 * @param EBookingControlMgmtVO eBookingControlMgmtVO
	 * @return List<EBookingControlMgmtVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<EBookingControlMgmtVO> searchEBookingControlForVslMgmt(EBookingControlMgmtVO eBookingControlMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EBookingControlMgmtVO> list = null;
		Map<String, Object> param = null;
		Map<String, Object> velParam = null;
		Map<String, String> mapVO = null;
		StringBuilder sb = null;
		String[] arr = null;
		try{
			if (null!=eBookingControlMgmtVO) {
				param = new HashMap<String, Object>();
				velParam = new HashMap<String, Object>();
				sb = new StringBuilder();
				if (!"".equals(eBookingControlMgmtVO.getDelivery())) {
					sb.delete(0,sb.length());
					arr = eBookingControlMgmtVO.getDelivery().split(",");
					if (null!=arr && 0<arr.length) {
						for (String str : arr) {
							sb.append("'").append(str).append("',");
						}
						sb.delete(sb.length()-1, sb.length());
						eBookingControlMgmtVO.setDelivery(sb.toString());
					}
				}
				if (!"".equals(eBookingControlMgmtVO.getBkgUpldStsCd())) {
					sb.delete(0,sb.length());
					arr = eBookingControlMgmtVO.getBkgUpldStsCd().split(",");
					if (null!=arr && 0<arr.length) {
						for (String str : arr) {
							sb.append("'").append(str).append("',");
						}
						sb.delete(sb.length()-1, sb.length());
						eBookingControlMgmtVO.setBkgUpldStsCd(sb.toString());
					}
				}
				if (!"".equals(eBookingControlMgmtVO.getDocTpCd())) {
					sb.delete(0,sb.length());
					arr = eBookingControlMgmtVO.getDocTpCd().split(",");
					if (null!=arr && 0<arr.length) {
						for (String str : arr) {
							sb.append("'").append(str).append("',");
						}
						sb.delete(sb.length()-1, sb.length());
						eBookingControlMgmtVO.setDocTpCd(sb.toString());
					}
				}
				if (!"".equals(eBookingControlMgmtVO.getXterBkgRqstStsCd())) {
					sb.delete(0,sb.length());
					arr = eBookingControlMgmtVO.getXterBkgRqstStsCd().split(",");
					if (null!=arr && 0<arr.length) {
						for (String str : arr) {
							sb.append("'").append(str).append("',");
						}
						sb.delete(sb.length()-1, sb.length());
						eBookingControlMgmtVO.setXterBkgRqstStsCd(sb.toString());
					}
				}
				mapVO = eBookingControlMgmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchEBookingControlForVslMgmtRSQL(), param, velParam, true);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EBookingControlMgmtVO.class);
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
	 * e-Booking Control Management 수정(ESM_BKG_1088)<br>
	 *
	 * @param List<EBookingControlMgmtVO> eBookingControlMgmtVOList
	 * @param String modifyMode
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */		
	public void modifyEBookingControlMgmt(List<EBookingControlMgmtVO> eBookingControlMgmtVOList, String modifyMode, SignOnUserAccount account)  throws DAOException{
		Map<String, Object> param = null;
		Map<String, Object> velParam = null;
		Map<String, String> mapVO = null;
		SQLExecuter sqlExe = null;
		try {
			if (null!=eBookingControlMgmtVOList && 0<eBookingControlMgmtVOList.size()) {
				param = new HashMap<String, Object>();
				velParam = new HashMap<String, Object>();
				sqlExe = new SQLExecuter("");
				for (EBookingControlMgmtVO eBookingControlMgmtVO : eBookingControlMgmtVOList) {
					mapVO = eBookingControlMgmtVO.getColumnValues();
					if (!"".equals(mapVO.get("xter_sndr_id")) && !"".equals(mapVO.get("xter_rqst_no")) && !"".equals(mapVO.get("xter_rqst_seq"))) {
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						param.put("usr_id", account.getUsr_id());
						param.put("inp_xter_rqst_acpt_cd", modifyMode);
						velParam.put("inp_xter_rqst_acpt_cd", modifyMode);
						int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOmodifyEBookingControlMgmtUSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to update SQL");
						}
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
	 * @param 	XterRqstNoVO xterRqstNoVO
	 * @return 	String
	 * @throws  EventException
	 */
	public String searchBlIss(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String blIss = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

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
	 * searchMqXlsBkgGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchMqXlsBkgGroupListRSQL(), param, velParam);
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
	 * searchMqXlsBkgMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL(), param, velParam);
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
 	 * booking split 관련 상태 수정(ESM_BKG_0099)<br>
 	 *
 	 * @param SplitBlInfoVO splitBlInfoVO
 	 * @param SignOnUserAccount account
 	 * @exception DAOException
 	 */
 	public void modifyXterBkgNoBySplit(SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account)throws DAOException {
 		Map<String, Object> param = null;
 		Map<String, Object> velParam = null;
		Map<String, String> mapVO = null;
 		try {
 			if(splitBlInfoVO != null){
	 	 		param = new HashMap<String, Object>();
	 	 		velParam = new HashMap<String, Object>();
	 			mapVO = splitBlInfoVO.getColumnValues();
	 			mapVO.put("upd_usr_id", account.getUsr_id());
	 			param.putAll(mapVO);
	 			velParam.putAll(mapVO);
	 			(new SQLExecuter("")).executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyXterBkgNoBySplitUSQL(), param, velParam);
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
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String hjsId
	 * @return String ediBody
	 * @throws DAOException
	 */
	public String searchXterRqstRejectAperakEdi(XterRqstNoVO xterRqstNoVO, String hjsId) throws DAOException {
		DBRowSet dbRowset = null;
		String ediBody = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				mapVO.put("hjs_id", hjsId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL(), param, velParam);
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
 	 * Cancel Split Candidate (ESM_BKG_0445)<br>
 	 *
 	 * @param SplitBlInfoVO splitBlInfoVO
 	 * @param SignOnUserAccount account
 	 * @exception DAOException
 	 */
 	public void modifyXterBkgNoBySplitStsCd (SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account)throws DAOException {
 		Map<String, Object> param = null;
 		Map<String, Object> velParam = null;
		Map<String, String> mapVO = null;
 		try {
 			if(splitBlInfoVO != null){
	 	 		param = new HashMap<String, Object>();
	 	 		velParam = new HashMap<String, Object>();
	 			mapVO = splitBlInfoVO.getColumnValues();
	 			mapVO.put("upd_usr_id", account.getUsr_id());
	 			param.putAll(mapVO);
	 			velParam.putAll(mapVO);
	 			(new SQLExecuter("")).executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyXterBkgNoBySplitStsCdUSQL(), param, velParam);
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
	 * @param String ibNo
	 * @param String faxLogRefNo
	 * @return Map<String,Object>
	 * @throws DAOException
	 */
	public Map<String,Object> searchReturnEml(String ibNo, String faxLogRefNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String,Object> retMap = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter

		try{
			param.put("sr_no", ibNo);
			param.put("fax_log_ref_no", faxLogRefNo);
			
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchFntOfcEmlRSQL(), param, null);
			while (dbRowset.next()) {
                retMap = new HashMap<String,Object>();
	            retMap.put("TO_EMAIL",dbRowset.getString("TO_EMAIL"));
	            retMap.put("EML_SUBJ_CTNT",dbRowset.getString("EML_SUBJ_CTNT"));
	            retMap.put("FROM_EMAIL",dbRowset.getString("FROM_EMAIL"));
 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return retMap;
	}
	
	/**
	 * auto confirm edi flatfile 전송을 위한 id조회 
	 * 
	 * @param String senderId
	 * @return String mchnTrdPrnrId
	 * @throws DAOException
	 */
	public String searchHostTradePartnerId(String senderId) throws DAOException {
		DBRowSet dbRowset = null;
		String mchnTrdPrnrId = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("sender_id", senderId);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchHostTradePartnerIdRSQL(), param, velParam);
			while (dbRowset.next()) {
				mchnTrdPrnrId = dbRowset.getString("MCHN_TRD_PRNR_ID");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return mchnTrdPrnrId;
	}
	/**
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<BlRiderVO>
	 * @throws DAOException
	 */
	public List<BlRiderVO> searchXterImgSto(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<BlRiderVO> list = null;
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

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterImgStoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlRiderVO .class);
			
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
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BlRiderVO> 
	 * @throws DAOException
	 */
	public List<BlRiderVO> searchBkgImgSto(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<BlRiderVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoRiderDBDAOsearchBlRiderListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlRiderVO .class);
			
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
	 * BL Issue 상태 조회
	 * 
	 * @param String bkgNo
	 * @return List<HistoryLineVO>
	 * @throws DAOException
	 */
	public List<HistoryLineVO> searchBlIssComplete(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<HistoryLineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchBlIssCompleteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HistoryLineVO .class);
			
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
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws DAOException
	 */
	public List<XterDgRiderVO> searchAlpsDgRiderList(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL(), param, velParam);
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
	public List<DgRiderCntrListVO> searchAlpsDgRiderCntrList(XterRqstNoVO xterRqstNoVO)  throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsDgRiderCntrListRSQL(), param, velParam);
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
	 * bkg_xter_caed에 insert한다.<br>
	 * bkg_xter_caed와 1:1 관계임<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param colVals String[] 
	 * @exception DAOException
	 */
	public void addBkgXterCaed(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_CAED");

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
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOAddBkgXterCaedCSQL(), param, velParam);
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
	 * e-bkg receipt BOKCON flat file 생성을 위해 Request master 정보를 조회한다.
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchXterRqstMstForBOKCON(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EbookingReceiptDBDAOSearchXterRqstMstForBOKCONRSQL(), param, velParam);
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
	
	/**e-bkg receipt BOKCON flat file 생성을 위해 Tro 정보를 조회한다.
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchXterTroForBOKCON(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EbookingReceiptDBDAOSearchXterTroForBOKCONRSQL(), param, velParam);
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
	
	/**e-bkg receipt BOKCON flat file 생성을 위해 Tro detail 정보를 조회한다.
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchXterTroDtlForBOKCON(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EbookingReceiptDBDAOSearchXterTroDtlForBOKCONRSQL(), param, velParam);
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
	
	/** BkgNo로 BkgRqst 정보를 조회한다.
	 * @param String bkgNo
	 * @return XterRqstNoVO
	 * @throws DAOException
	 */
	public XterRqstNoVO selectBkgRqstNoByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EbookingReceiptDBDAOselectBkgRqstNoByBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = (XterRqstNoVO) list.get(0);
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
	 * PO NO의 path item를 조회한다.<br>
	 *
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterPoMdtItm(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO ) throws DAOException {
		DBRowSet dbRowset = null;
		String pathItem = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(searchXterPoMdtItmParmVO != null){
				Map<String, String> mapVO = searchXterPoMdtItmParmVO .getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterPoMdtItmRSQL(), param, null);
			while (dbRowset.next()) {
				pathItem = dbRowset.getString("PATH_ITEM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return pathItem;
	}		
	
	/**
	 * IKEA Customer 인지 여부를 체크한다.<br>
	 *
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean validateEdiIkeaCust(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		boolean vRslt = false;
		
		try{
			if(searchXterPoMdtItmParmVO != null){
				Map<String, String> mapVO = searchXterPoMdtItmParmVO .getColumnValues();
				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOvalidateEdiIkeaCustRSQL(), param, null);

			if (dbRowset.next()) {
				vRslt = true;
			} else {
				vRslt = false;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vRslt;
	}
	
	/**
	 * Container Type/Size 유효성 검사.(ESM_BKG_0229_07)<br>
	 *
	 * @author 		LimJaeKwan
	 * @param 		String cntrTpSz
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchCntrTpSz(String cntrTpSz) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String isOk = "N";
		try{
			param.put("cntr_tpsz_cd", cntrTpSz);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCntrTpSzRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = "Y";
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}	

	/**
	 * Xter B/L별 Wharfage 면제 정보 (면제 사유 등) 조회
	 * @author LimJaeKwan
	 * @param  XterRqstNoVO xterRqstNoVO
	 * @return KrWhfBlExpInfoVO
	 * @throws DAOException
	 */
	public List<KrWhfBlExptInfoVO> searchXterKrWhfBlInfo( XterRqstNoVO xterRqstNoVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlExptInfoVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterWhfBlExptRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlExptInfoVO .class);
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
	 * ALPS B/L별 Wharfage 면제 정보 (면제 사유 등) 조회
	 * @author LimJaeKwan
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return KrWhfBlExpInfoVO
	 * @throws DAOException
	 */
	public List<KrWhfBlExptInfoVO> searchKrWhfBlInfo( BkgBlNoVO bkgBlNoVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<KrWhfBlExptInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KrWharfageDecMgtDBDAOsearchKrWhfBlExptInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KrWhfBlExptInfoVO .class);
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
	 * Xter Upload Sts Code 조회
	 * @param xterRqstNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchXterBkgSts(XterRqstNoVO xterRqstNoVO ) throws DAOException {
		DBRowSet dbRowset = null;
		String xterBkgSts = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterBkgStsRSQL(), param, null);
			while (dbRowset.next()) {
				xterBkgSts = dbRowset.getString("BKG_UPLD_STS_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterBkgSts;
	}
	
	/**
	 * Booking pol이 Europe 인지 확인함<br>
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchXterCMvalidationEuDeHjsCD(String bkgNo)  throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String[] valiVal = new String[2];

		try{
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchValidateXterCmEuPodHjsCDRSQL(), param, null);
			if(dbRowset.getRowCount() > 0){
				while (dbRowset.next()) {
					valiVal[0] = dbRowset.getString(1);
					valiVal[1] = dbRowset.getString(2);
				}	
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return valiVal;
	}
	
	/**
	 * Actual Customer Nmae 조회<br>
	 * @param String agmtActCntCd
	 * @param String agmtActCustSeq
	 * @param String exCustNm
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchActualCustomerName(String agmtActCntCd, String agmtActCustSeq, String exCustNm  )  throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String[] valiVal = new String[2];

		try{
			param.put("agmt_act_cnt_cd", agmtActCntCd);
			param.put("agmt_act_cust_seq", agmtActCustSeq);
			param.put("ex_cust_nm", exCustNm);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchActualCustomerNameRSQL(), param, null);
			if(dbRowset.getRowCount() > 0){
				while (dbRowset.next()) {
					valiVal[0] = dbRowset.getString(1);
					valiVal[1] = dbRowset.getString(2);
				}	
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return valiVal;
	}
	
	/**
	 * Actual Customer Nmae 조회<br>
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchBkgContactInfo(String bkgNo  )  throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String[] valiVal = new String[2];

		try{
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchBookingDocNameRSQL(), param, null);
			if(dbRowset.getRowCount() > 0){
				while (dbRowset.next()) {
					valiVal[0] = dbRowset.getString(1);
					valiVal[1] = dbRowset.getString(2);
				}	
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return valiVal;
	}
	
	/**
	 * e-BKG cancel request 업로드 시에도 remark 저장<br>
	 *
	 * @param String bkgNo
	 * @param String interRmk
	 * @param String xterRmk
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgRmk(String bkgNo , String interRmk, String xterRmk, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("inter_rmk", interRmk);
			velParam.put("inter_rmk", interRmk);
			param.put("xter_rmk", xterRmk);
			velParam.put("xter_rmk", xterRmk);
			param.put("user_id", account.getUsr_id());
			velParam.put("user_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyBkgRmkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBookingInfoVO searchXterBkgInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		BkgBookingInfoVO bkgBookingInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterBkgInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO .class);
			if (list != null && list.size() > 0) {
				bkgBookingInfoVO = (BkgBookingInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgBookingInfoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBookingInfoVO searchXterSIInterface(SIWebServiceVO sIWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		BkgBookingInfoVO bkgBookingInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO .class);
			if (list != null && list.size() > 0) {
				bkgBookingInfoVO = (BkgBookingInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgBookingInfoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlDocCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlDocCustVO searchXterCustInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BlDocCustVO> list = null;
		BlDocCustVO blDocCustVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterCustInterfaceRSQL(), param, velParam);
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
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return CustEtcVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustEtcVO searchBkgCustEtcInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<CustEtcVO> list = null;
		CustEtcVO custEtcVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgCustEtcInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustEtcVO .class);
			if(list != null && list.size() > 0){
				custEtcVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return custEtcVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Tro 정보를 조회한다.<br>
	 *
	 * @param  BkgWebServiceVO bkgWebServiceVO
	 * @return TroMstVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public TroMstVO[] searchXterTroInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<TroMstVO> list = null;
		TroMstVO[] troMstVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterTroInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroMstVO .class);

			troMstVO = new TroMstVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					troMstVO[i] = new TroMstVO();				
					troMstVO[i] = (TroMstVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return troMstVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Tro Dtl 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return TroDtlVO[]
	 * @exception DAOException
	 */
	public TroDtlVO[] searchXterTroDtlInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<TroDtlVO> list = null;
		TroDtlVO[] troDtlVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterTroDtlInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroDtlVO .class);

			troDtlVO = new TroDtlVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					troDtlVO[i] = new TroDtlVO();				
					troDtlVO[i] = (TroDtlVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return troDtlVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Reefer cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgRfCgoVO[]
	 * @exception DAOException
	 */
	public BkgRfCgoVO[] searchXterRfInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgRfCgoVO> list = null;
		BkgRfCgoVO[] bkgRfCgoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRfInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRfCgoVO .class);

			bkgRfCgoVO = new BkgRfCgoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgRfCgoVO[i] = new BkgRfCgoVO();				
					bkgRfCgoVO[i] = (BkgRfCgoVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgRfCgoVO;
	}
		
	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DgCgoListVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DgCgoListVO[] searchXterDgInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<DgCgoListVO> list = null;
		DgCgoListVO[] bgCgoListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterDgInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgCgoListVO .class);

			bgCgoListVO = new DgCgoListVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bgCgoListVO[i] = new DgCgoListVO();				
					bgCgoListVO[i] = (DgCgoListVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bgCgoListVO;
	}
		
	/**
	 * external request 처리를 위해 external rqst의 danger cgo Rider 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @exception DAOException
	 */	
	public BkgImgStoVO[] searchXterDgRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgImgStoVO> list = null;
		BkgImgStoVO[] bkgImgStoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterDgRiderListInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgImgStoVO .class);

			bkgImgStoVO = new BkgImgStoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgImgStoVO[i] = new BkgImgStoVO();				
					bkgImgStoVO[i] = (BkgImgStoVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgImgStoVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgAwkCgoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgAwkCgoVO[] searchXterAkInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgAwkCgoVO> list = null;
		BkgAwkCgoVO[] bkgAwkCgoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterAkInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgAwkCgoVO .class);

			bkgAwkCgoVO = new BkgAwkCgoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgAwkCgoVO[i] = new BkgAwkCgoVO();				
					bkgAwkCgoVO[i] = (BkgAwkCgoVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgAwkCgoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Awkward cgo Rider 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @exception DAOException
	 */	
	public BkgImgStoVO[] searchXterAkRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgImgStoVO> list = null;
		BkgImgStoVO[] bkgImgStoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterAkRiderListInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgImgStoVO .class);

			bkgImgStoVO = new BkgImgStoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgImgStoVO[i] = new BkgImgStoVO();				
					bkgImgStoVO[i] = (BkgImgStoVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgImgStoVO;
	}

	
	/**
	 * external request 처리를 위해 external rqst의 Break Bulk cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBbCgoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBbCgoVO[] searchXterBbInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgBbCgoVO> list = null;
		BkgBbCgoVO[] bkgBbCgoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterBbInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBbCgoVO .class);

			bkgBbCgoVO = new BkgBbCgoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgBbCgoVO[i] = new BkgBbCgoVO();				
					bkgBbCgoVO[i] = (BkgBbCgoVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgBbCgoVO;
	}
	
	/**
	 * MND 중 Booking Request시 접수되는 Import&Export Licence No만 별도 처리하기 위해 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return AlpsXptImpLicListVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AlpsXptImpLicListVO[] searchAlpsXptImpLicListInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AlpsXptImpLicListVO> list = null;
		AlpsXptImpLicListVO[] alpsXptImpLicListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsXptImpLicListInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsXptImpLicListVO .class);

			alpsXptImpLicListVO = new AlpsXptImpLicListVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					alpsXptImpLicListVO[i] = new AlpsXptImpLicListVO();				
					alpsXptImpLicListVO[i] = (AlpsXptImpLicListVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return alpsXptImpLicListVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstNoVO searchXterRqstNoInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRqstNoInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO .class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = (XterRqstNoVO) list.get(0);
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
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBlNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO searchBkgBlNoInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO bkgBlNoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgBlNoInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO .class);
			if (list != null && list.size() > 0) {
				bkgBlNoVO = (BkgBlNoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgBlNoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return XterEtcInterfaceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterEtcInterfaceVO searchXterEtcInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<XterEtcInterfaceVO> list = null;
		XterEtcInterfaceVO xterEtcInterfaceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterEtcInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterEtcInterfaceVO .class);
			if (list != null && list.size() > 0) {
				xterEtcInterfaceVO = (XterEtcInterfaceVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterEtcInterfaceVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return VslSkdVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslSkdVO[] searchVslSkdInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<VslSkdVO> list = null;
		VslSkdVO[] vslSkdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchVslSkdInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);

			vslSkdVO = new VslSkdVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					vslSkdVO[i] = new VslSkdVO();				
					vslSkdVO[i] = (VslSkdVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vslSkdVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DocRqstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DocRqstVO searchDocRqstInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<DocRqstVO> list = null;
		DocRqstVO docRqstVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchDocRqstInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DocRqstVO .class);
			if (list != null && list.size() > 0) {
				docRqstVO = (DocRqstVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return docRqstVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BookingSaveValidationVO searchBookingSaveValidationInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BookingSaveValidationVO> list = null;
		BookingSaveValidationVO bookingSaveValidationVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBookingSaveValidationInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingSaveValidationVO .class);
			if (list != null && list.size() > 0) {
				bookingSaveValidationVO = (BookingSaveValidationVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bookingSaveValidationVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BookingSaveValidationVO searchSISaveValidationInterface(SIWebServiceVO sIWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BookingSaveValidationVO> list = null;
		BookingSaveValidationVO bookingSaveValidationVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchSISaveValidationInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingSaveValidationVO .class);
			if (list != null && list.size() > 0) {
				bookingSaveValidationVO = (BookingSaveValidationVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bookingSaveValidationVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQuantityVO[] searchBkgQuantityInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		BkgQuantityVO[] bkgQuantityVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgQuantityInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);

			bkgQuantityVO = new BkgQuantityVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgQuantityVO[i] = new BkgQuantityVO();				
					bkgQuantityVO[i] = (BkgQuantityVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgQuantityVO;
	}		
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQuantityVO[] searchSIBkgQuantityInterface(SIWebServiceVO sIWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		BkgQuantityVO[] bkgQuantityVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchSIBkgQuantityInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);

			bkgQuantityVO = new BkgQuantityVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgQuantityVO[i] = new BkgQuantityVO();				
					bkgQuantityVO[i] = (BkgQuantityVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgQuantityVO;
	}		
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQtyDtlVO[] searchBkgQtyDtlInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgQtyDtlVO> list = null;
		BkgQtyDtlVO[] bkgQtyDtlVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgQtyDtlInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO .class);

			bkgQtyDtlVO = new BkgQtyDtlVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgQtyDtlVO[i] = new BkgQtyDtlVO();				
					bkgQtyDtlVO[i] = (BkgQtyDtlVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgQtyDtlVO;
	}	
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQtyDtlVO[] searchSIBkgQtyDtlInterface(SIWebServiceVO sIWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgQtyDtlVO> list = null;
		BkgQtyDtlVO[] bkgQtyDtlVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchSIBkgQtyDtlInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO .class);

			bkgQtyDtlVO = new BkgQtyDtlVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgQtyDtlVO[i] = new BkgQtyDtlVO();				
					bkgQtyDtlVO[i] = (BkgQtyDtlVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgQtyDtlVO;
	}	
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlCustomerInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlCustomerInfoVO searchBlCustomerInfoInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BlCustomerInfoVO> list = null;
		BlCustomerInfoVO blCustomerInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBlCustomerInfoInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCustomerInfoVO .class);
			if (list != null && list.size() > 0) {
				blCustomerInfoVO = (BlCustomerInfoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return blCustomerInfoVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 BkgTroSpclCgoSeqVO 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgTroSpclCgoSeqVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgTroSpclCgoSeqVO[] searchXterBkgTroSpclCgoSeqInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgTroSpclCgoSeqVO> list = null;
		BkgTroSpclCgoSeqVO[] bkgTroSpclCgoSeqVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterBkgTroSpclCgoSeqInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroSpclCgoSeqVO .class);

			bkgTroSpclCgoSeqVO = new BkgTroSpclCgoSeqVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgTroSpclCgoSeqVO[i] = new BkgTroSpclCgoSeqVO();				
					bkgTroSpclCgoSeqVO[i] = (BkgTroSpclCgoSeqVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgTroSpclCgoSeqVO;
	}	
	
	
	/**
	 * external request 처리를 위해 external rqst의 BkgQuantityVO 정보를 조회한다.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgQuantityVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQuantityVO[] searchBkgQuantityVOInterface(BkgBlNoVO bkgBlNoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		BkgQuantityVO[] bkgQuantityVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgQuantityVOInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);

			bkgQuantityVO = new BkgQuantityVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgQuantityVO[i] = new BkgQuantityVO();				
					bkgQuantityVO[i] = (BkgQuantityVO) list.get(i);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgQuantityVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Reference 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceVO[] searchBkgReferenceInterface(BkgWebServiceVO bkgWebServiceVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgReferenceVO> list = null;
		BkgReferenceVO[] bkgReferenceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceVO != null){
				Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchBkgReferenceInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceVO .class);

			bkgReferenceVO = new BkgReferenceVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgReferenceVO[i] = new BkgReferenceVO();				
					bkgReferenceVO[i] = (BkgReferenceVO) list.get(i);
				}
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
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceParamVO
	 * @return BkgWebServiceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgWebServiceVO searchWebServiceProcessType(BkgWebServiceVO bkgWebServiceParamVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgWebServiceVO> list = null;
		BkgWebServiceVO bkgWebServiceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgWebServiceParamVO != null){
				Map<String, String> mapVO = bkgWebServiceParamVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchWebServiceProcessTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgWebServiceVO .class);
			if (list != null && list.size() > 0) {
				bkgWebServiceVO = (BkgWebServiceVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgWebServiceVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @return SIWebServiceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SIWebServiceVO searchWebServiceSIProcessType(XterRqstNoVO xterRqstNoRstVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SIWebServiceVO> list = null;
		SIWebServiceVO sIWebServiceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterRqstNoRstVO != null){
				Map<String, String> mapVO = xterRqstNoRstVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchWebServiceSIProcessTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SIWebServiceVO .class);
			if (list != null && list.size() > 0) {
				sIWebServiceVO = (SIWebServiceVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sIWebServiceVO;
	}
	
	/**
	 * Interface로 Upload된 정보 PreviousStatus Update<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void modifyPreviousBookingRequestStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(bkgWebServiceVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyPreviousBookingRequestStatusUSQL(), param, velParam);
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
	 * Interface로 Upload된 정보 PreviousStatus Update<br>
	 *
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void modifyPreviousSIRequestStatus(XterRqstNoVO xterRqstNoRstVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoRstVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoRstVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyPreviousSIRequestStatusUSQL(), param, velParam);
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
	 * Interface로 Upload된 정보 PreviousStatus Update<br>
	 *
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void modifyAllPreviousSIRequestStatus(XterRqstNoVO xterRqstNoRstVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = xterRqstNoRstVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(xterRqstNoRstVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyAllPreviousSIRequestStatusUSQL(), param, velParam);
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
	 * Interface로 Upload된 정보 Status Update<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void modifyAutoUploadStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(bkgWebServiceVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyAutoUploadStatusUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
				sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifyAutoUploadStatusBkg2USQL(), param, velParam);
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
	 * Interface로 Upload된 정보 Status Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void modifySIAutoUploadStatus(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(sIWebServiceVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifySIAutoUploadStatusUSQL(), param, velParam);
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
	 * 미주지역 Rqst에 대한 Handling Office를 조회한다.<br>
	 *
	 * @param String polCd
	 * @param String cmdtNm
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsHandlingOfc(String polCd, String cmdtNm)throws DAOException {
		
		DBRowSet dbRowset = null;
		String ofcCd = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("pol_cd", polCd);
			param.put("cmdt_nm", cmdtNm);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchUsHandlingOfcRSQL(), param, velParam);
			if(dbRowset.next()){
				ofcCd = dbRowset.getString("OFC_CD");
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
	 * bkg_xter_ref_dtl에 insert한다.<br>
	 * CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @param String[] colVals
	 * @exception DAOException
	 */
	public void addBkgXterRefDtl(XterRqstNoVO xterRqstNoVO, String[] colVals) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> tableColumns = new ArrayList<String>();
		ArrayList<String> tableValues = new ArrayList<String>();
		ArrayList<String> tableDateColumns = new ArrayList<String>();
		ArrayList<String> tableDateValues = new ArrayList<String>();
		String[] tmpColVals = null;
		log.debug("INSERT TABLE:BKG_XTER_REF_DTL");

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
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterRefDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException("BKG_XTER_DG_CGO" + new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * eBKG의 Ref Detail (SHIP Id) 정보를 조회한다.<br>
	 * CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return List<XterRefDtlVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<XterRefDtlVO> searchXterRefDtlList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRefDtlVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterRefDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterRefDtlVO.class);
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
	 * 수신 받은 eBKG 또는 eSI의 최종 RqstNo 조회<br>
	 *
	 * @param xterRqstNoVOparam XterRqstNoVOparam
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterHblRqstNo(XterRqstNoVO xterRqstNoVOparam) throws DAOException {
		DBRowSet dbRowset = null;
		String hblRqstNo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVOparam .getColumnValues();

			param.putAll(mapVO);			
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterHblRqstNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				hblRqstNo = dbRowset.getString("XTER_RQST_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return hblRqstNo;
	}
	
	/**
	 * 수신 받은 eBKG 또는 eSI의 최종 RqstNo 조회<br>
	 *
	 * @param xterRqstNoVOparam XterRqstNoVOparam
	 * @param String siNo
	 * @param String xterDocTpCd
	 * @return Integer
	 * @exception DAOException
	 */
	public Integer searchXterHblDup(XterRqstNoVO xterRqstNoVOparam , String siNo, String xterDocTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		Integer hblCnt = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = xterRqstNoVOparam .getColumnValues();

			param.putAll(mapVO);	
			param.put("si_no", siNo);
			velParam.putAll(mapVO);
			velParam.put("bkg_no", xterRqstNoVOparam.getBkgNo());
			velParam.put("xter_Doc_Tp_Cd", xterDocTpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterHblDupRSQL(), param, velParam);
			while (dbRowset.next()) {
				hblCnt= dbRowset.getInt("HBL_CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return hblCnt;
	}
	
	/**
	 * e-bkg receipt시  Black Lsit 여부 체크<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @exception DAOException
	 */			
	public String checkBkgBlackList(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String resultStr = "";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOcheckBkgBlackListRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return resultStr;			
	}
	
	/**
	 * Portal Customer 체크
	 * 
	 * @param String xterSndrId
	 * @param String custTpcd
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String checkPortalCustomerCd(String xterSndrId, String custTpcd, String custCd) throws DAOException {
		DBRowSet dbRowset = null;
		String resultStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("xter_sndr_id", xterSndrId);
			param.put("cust_tp_cd", custTpcd);
			param.put("cust_cd", custCd);
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOcheckPortalCustomerCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return resultStr;	
	}
	
	/**
	 * @param logDesc
	 * @param applInfo
	 * @param modName
	 * @throws DAOException
	 */
	public void createBkgExecEnisLog(String logDesc, String applInfo, String modName)  throws DAOException {
		Map<String, String> param = new HashMap();
		int exeFlag = 0;

		try{
			param.put("mod_name", modName);
			param.put("log_desc", logDesc);
			param.put("appl_info",applInfo);

			exeFlag  = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOPrdExecEnisLogCSQL(), param, null);
			
			if(exeFlag == Statement.EXECUTE_FAILED){
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
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 */
	public List<XterDgRiderVO> searchXterAkRiderList(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterAkRiderListRSQL(), param, velParam);
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
	 * @return List<XterDgRiderVO>
	 * @throws DAOException
	 */
	public List<XterDgRiderVO> searchAlpsAkRiderList(XterRqstNoVO xterRqstNoVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchAlpsAkRiderListRSQL(), param, velParam);
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
	 * 미주 서부임을 확인.<br>
	 *
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsWest(String locCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String usWestFlag = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("loc_cd", locCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchUsWestRSQL(), param, velParam);
			if(dbRowset.next()){
				usWestFlag = dbRowset.getString("US_WEST_FLAG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return usWestFlag;

	}
	
	/**
	 * eBKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterCustChkPntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterCustChkPntVO searchXterCustChkPnt(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCustChkPntVO> list = null;
		XterCustChkPntVO xterCustChkPntVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCustChkPntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCustChkPntVO .class);
			if (list != null && list.size() > 0) {
				xterCustChkPntVO = (XterCustChkPntVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterCustChkPntVO;
	}
	
	/**
	 * BKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param String bkgNo
	 * @return XterCustChkPntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterCustChkPntVO searchBkgCustChkPnt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCustChkPntVO> list = null;
		XterCustChkPntVO xterCustChkPntVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterCustChkPntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCustChkPntVO .class);
			if (list != null && list.size() > 0) {
				xterCustChkPntVO = (XterCustChkPntVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xterCustChkPntVO;
	}
	
	/**
	 * BKG_XPT_IMP_LIC에 insert한다.<br>
	 *
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception DAOException
	 */
	public void addBkgAes(XterRqstNoVO xterRqstNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
				
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(xterRqstNoVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgAesCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException("BKG_XTER_AES " + new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * New Ofc Code 조회
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewOfcCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String newOfcCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchNewOfcCdRSQL(), param, null);
			while (dbRowset.next()) {
				newOfcCd = dbRowset.getString("NEW_OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newOfcCd;
	}
	
	 /**
     * CntrEtcInfoVO 모델에 해당하는 데이타 조회.
     * 
     * @param SIWebServiceVO sIWebServiceVO
     * @return CntrEtcInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CntrEtcInfoVO searchXterSIEtcInfoForCntr(SIWebServiceVO sIWebServiceVO) throws DAOException {
        DBRowSet dbRowset = null;
        CntrEtcInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            EBookingReceiptDBDAOsearchXterSICntrEtcInfoRSQL template = new EBookingReceiptDBDAOsearchXterSICntrEtcInfoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<CntrEtcInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrEtcInfoVO.class);
            if(list==null || list.size()==0){
                rsVO = new CntrEtcInfoVO();
            }else{
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }
    
    /**
     * ContainerVO 모델에 해당하는 데이타 조회.
     *  
     * @param SIWebServiceVO sIWebServiceVO
     * @return ContainerVO[]
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public ContainerVO[] searchXterSIContainer(SIWebServiceVO sIWebServiceVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ContainerVO> list = null;
        ContainerVO[] containerVOs = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            EBookingReceiptDBDAOsearchXterSIContainerRSQL template = new EBookingReceiptDBDAOsearchXterSIContainerRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerVO.class);
            
            containerVOs = new ContainerVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					containerVOs[i] = new ContainerVO();				
					containerVOs[i] = (ContainerVO) list.get(i);
				}
			}
			
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return containerVOs;
    }
    
    /**
     * BkgCntrSealNoVO 모델에 해당하는 데이타 조회.
     * 
     * @param SIWebServiceVO sIWebServiceVO
     * @return BkgCntrSealNoVO[]
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public BkgCntrSealNoVO[] searchXterSISealNo(SIWebServiceVO sIWebServiceVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgCntrSealNoVO> list = null;
        BkgCntrSealNoVO[] bkgCntrSealNoVOs = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            EBookingReceiptDBDAOsearchXterSISealNoRSQL template = new EBookingReceiptDBDAOsearchXterSISealNoRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCntrSealNoVO.class);
            
            bkgCntrSealNoVOs = new BkgCntrSealNoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgCntrSealNoVOs[i] = new BkgCntrSealNoVO();				
					bkgCntrSealNoVOs[i] = (BkgCntrSealNoVO) list.get(i);
				}
			}
			
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return bkgCntrSealNoVOs;
    }
    
    /**
     * MndVO 모델에 해당하는 데이타 조회.
     * 
     * @param SIWebServiceVO sIWebServiceVO
     * @return MndVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public MndVO searchXterSIMnd(SIWebServiceVO sIWebServiceVO) throws DAOException {
        DBRowSet dbRowset = null;
        MndVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            EBookingReceiptDBDAOsearchXterSIMndRSQL template = new EBookingReceiptDBDAOsearchXterSIMndRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<MndVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, MndVO.class);
            if(list==null || list.size()==0){
                rsVO = new MndVO();
            }else{
                rsVO = list.get(0);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return rsVO;
    }
    
    /**
	 * ALSP BKG 수출 허가 번호 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return AlpsXptImpLicListVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AlpsXptImpLicListVO[] searchXterSIXptImpLicList(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AlpsXptImpLicListVO> list = null;
		AlpsXptImpLicListVO[] alpsXptImpLicListVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIXptImpLicListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AlpsXptImpLicListVO.class);
			
			alpsXptImpLicListVOs = new AlpsXptImpLicListVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					alpsXptImpLicListVOs[i] = new AlpsXptImpLicListVO();				
					alpsXptImpLicListVOs[i] = (AlpsXptImpLicListVO) list.get(i);
				}
			}
				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return alpsXptImpLicListVOs;
	}
	
	/**
	 * ALSP BKG indonesia 수출 허가 번호 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return XptImpLicVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public XptImpLicVO[] searchXterSIIdXptImpLicList(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XptImpLicVO> list = null;
		XptImpLicVO[] xptImpLicVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIIdXptImpLicListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XptImpLicVO.class);
			
			xptImpLicVOs = new XptImpLicVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					xptImpLicVOs[i] = new XptImpLicVO();				
					xptImpLicVOs[i] = (XptImpLicVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return xptImpLicVOs;
	}
	
	/**
	 * ALSP BKG Container Po No  조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceVO[] searchXterSIPoOtherCntr(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgReferenceVO> list = null;
		BkgReferenceVO[] bkgReferenceVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIPoOtherCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceVO.class);
			
			bkgReferenceVOs = new BkgReferenceVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgReferenceVOs[i] = new BkgReferenceVO();				
					bkgReferenceVOs[i] = (BkgReferenceVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgReferenceVOs;
	}
	
	/**
	 * ALSP BKG Bl Rider 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BlRiderVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlRiderVO[] searchXterSIBlRider(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlRiderVO> list = null;
		BlRiderVO[] blRiderVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSIBlRiderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlRiderVO.class);
			
			blRiderVOs = new BlRiderVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					blRiderVOs[i] = new BlRiderVO();				
					blRiderVOs[i] = (BlRiderVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return blRiderVOs;
	}
	
	/**
	 * ALSP BKG  Po No  조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgReferenceVO[] searchXterSIPoOtherNoBkg(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgReferenceVO> list = null;
		BkgReferenceVO[] bkgReferenceVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIPoOtherNoBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgReferenceVO.class);
			
			bkgReferenceVOs = new BkgReferenceVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgReferenceVOs[i] = new BkgReferenceVO();				
					bkgReferenceVOs[i] = (BkgReferenceVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgReferenceVOs;
	}
	
	/**
	 * ALSP BKG  CM Po No   조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgRefDtlVO[] searchXterSIPoOtherCm(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRefDtlVO> list = null;
		BkgRefDtlVO[] bkgRefDtlVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOSearchXterSIPoOtherCmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRefDtlVO.class);
			
			bkgRefDtlVOs = new BkgRefDtlVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgRefDtlVOs[i] = new BkgRefDtlVO();				
					bkgRefDtlVOs[i] = (BkgRefDtlVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgRefDtlVOs;
	}
	
	/**
	 * ALSP BKG  CM 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return  List<BkgCntrMfDescVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCntrMfDescVO> searchXterSICntrMfDesc(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCntrMfDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSICntrMfDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntrMfDescVO.class);
			
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
	 * CMPB 산출된 Rate 정보 Add<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void addSiBkgChgRate(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("cre_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(sIWebServiceVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterSIBkgChgRateCSQL(), param, velParam);
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
	 * VGM 정보 Add<br>
	 *
	 * @param BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void addBkgXterVrfdWgtRqst(BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgXterVrfdWgtRqstVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String usrId = "SYSTEM";
			if(account != null){
				usrId = account.getUsr_id();
			}
			param.put("upd_usr_id", usrId);
			param.put("cre_usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(bkgXterVrfdWgtRqstVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterVrfdWgtRqstCSQL(), param, velParam);
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
	 * VGM Party 정보  Add<br>
	 *
	 * @param BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */			
	public void addBkgXterVrfdWgtPty(BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgXterVrfdWgtPtyVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String usrId = "SYSTEM";
			if(account != null){
				usrId = account.getUsr_id();
			}
			param.put("upd_usr_id", usrId);
			param.put("cre_usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(bkgXterVrfdWgtPtyVO != null){
				int result = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOaddBkgXterVrfdWgtPtyCSQL(), param, velParam);
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
	 * Xter Chg Rate 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return  List<BkgXterChgRtVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterChgRtVO> searchXterSIChgRt(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterChgRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSIChgRtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterChgRtVO.class);
			
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
	 * Contract Sale Rep, Loading Rep Email를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterSISrepEml(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		String srepEml = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterRqstViaCodeRSQL(), param, velParam);
			while (dbRowset.next()) {
				srepEml = dbRowset.getString("SREP_EML");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return srepEml;
	}
	
	/**
	 * Interface로 Auto Upload된 정보 Audit Flag Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */			
	public int modifySIAuditFlag(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt =0;
		try {
			Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("");
			if(sIWebServiceVO != null){
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifySIAuditFlagUSQL(), param, velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return updCnt;
	} 
	
	/**
	 * Interface로 Auto Upload된 정보Old Mk Desc Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return int
	 * @exception DAOException
	 */			
	public int modifySIOldMkDesc(SIWebServiceVO sIWebServiceVO)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt =0;
		try {
			Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(sIWebServiceVO != null){
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new EBookingReceiptDBDAOModifySIOldMkDescUSQL(), param, velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return updCnt;
	} 
	
	/**
	 * Bkg Chg Rate 조회<br>
	 *
	 * @param String bkgNo
	 * @return  List<BkgChgRateVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChgRateVO> searchBkgChgRt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChgRateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchBkgChgRtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterChgRtVO.class);
			
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
	 * Xter Chg Rate 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return  List<BkgXterChgRtVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterChgRtVO> searchCmpbChgRt(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterChgRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchCmpbChgRtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterChgRtVO.class);
			
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
	 * Max Xter Chg Rate 조회<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return  List<BkgXterChgRtVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgXterChgRtVO> searchXterChgRt(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgXterChgRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterChgRtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterChgRtVO.class);
			
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
	 * Customer의 Ratign 변경여부를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchXterSIChgModFlg(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		String chgModFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSIChgModFlgRSQL(), param, velParam);
			while (dbRowset.next()) {
				chgModFlg = dbRowset.getString("CHG_MOD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return chgModFlg;
	}
	
	/**
	 * BKG CONTAINER의 VGM WGT 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @param ContainerVO containerVO
	 * @return ContainerVO
	 * @exception DAOException
	 */
	public ContainerVO searchBkgCntrVgmWgt(String bkgNo, ContainerVO containerVO) throws DAOException {
		DBRowSet dbRowset = null;
		ContainerVO rsVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("cntr_no", containerVO.getCntrNo());
			velParam.put("cntr_no", containerVO.getCntrNo());
			param.put("cntr_wgt", containerVO.getCntrWgt());
			velParam.put("cntr_wgt", containerVO.getCntrWgt());
			param.put("vgm_wgt", containerVO.getVgmWgt());
			velParam.put("vgm_wgt", containerVO.getVgmWgt());
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EBookingReceiptDBDAOsearchBkgCntrVgmWgtRSQL(), param, velParam);
			List<ContainerVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContainerVO.class);
			if (list != null && list.size() != 0) {
				rsVO = list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsVO;
	}
	
	/**
	 * external request 정보 중 house b/l 정보를 조회한다.<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return List<HblDtlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HblDtlInfoVO> searchXterSIHbl1(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HblDtlInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSIHbl1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HblDtlInfoVO .class);
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
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgUsaCstmsFileNoVO[] 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgUsaCstmsFileNoVO[] searchXterSIHbl2(SIWebServiceVO sIWebServiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgUsaCstmsFileNoVO> list = null;
		BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs= null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sIWebServiceVO != null){
				Map<String, String> mapVO = sIWebServiceVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchXterSIHbl2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsaCstmsFileNoVO .class);
			
			bkgUsaCstmsFileNoVOs = new BkgUsaCstmsFileNoVO[list.size()];
			if (list != null && list.size() > 0) {
				for(int i = 0 ; i < list.size(); i++){	
					bkgUsaCstmsFileNoVOs[i] = new BkgUsaCstmsFileNoVO();				
					bkgUsaCstmsFileNoVOs[i] = (BkgUsaCstmsFileNoVO) list.get(i);
				}
			}				
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgUsaCstmsFileNoVOs;
	}
	
	/**
	  * 
	  * @param ctrtNo
	  * @return
	  * @throws DAOException
	  */
	 public String searchContractCustomerName(String ctrtNo) throws DAOException {
		String returnVal = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ctrt_no", ctrtNo);
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EBookingReceiptDBDAOsearchContractCustomerNameRSQL(), param, param);
			if(dbRowset.next()){ 											
	 			returnVal = dbRowset.getString("CUST_LGL_ENG_NM");
	 		} 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
}
