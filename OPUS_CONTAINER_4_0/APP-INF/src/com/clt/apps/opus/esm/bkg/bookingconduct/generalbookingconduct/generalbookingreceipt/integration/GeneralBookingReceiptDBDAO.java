/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAO.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOSearchBccEmailAddrRSQL;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForDstSvcRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDtlEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CopySplitBkgEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ExportReferencesVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ManualBookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.N1stEtaDelEtaVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldNewVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMrnUcrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PodDelForCodVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PrdRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchBkgContainerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchCutOffDateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ValidateOceanRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.XterCustOvflwFlgStatusVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCondVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
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
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRollOvrVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * OPUS GeneralBookingReceiptDBDAO <br>
 * - OPUS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimByungKyu
 * @see GeneralBookingReceiptBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralBookingReceiptDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2199149470102031994L;

	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 */
	public void modifyChgRateBkgBooking(RateMainInfoVO rateMainInfoVO, String caflag) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = rateMainInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("caflag", caflag);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BL TYPE 수정 처리<br>
	 * 해당 booking 의 BL TYPE  정보을 저장한다
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blTpCd
	 * @exception DAOException
	 */
	public void modifyBlType(String bkgNo, String blTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			param.put("bkg_no", bkgNo);
			param.put("blTpCd", blTpCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("blTpCd", blTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOmodifyBlTypeUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BL TYPE 수정 처리<br>
	 * 해당 booking 의 BL TYPE  정보을 저장한다
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blTpCd
	 * @exception DAOException
	 */
	public void modifyBlTypeHistory(String bkgNo, String blTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			param.put("bkg_no", bkgNo);
			param.put("blTpCd", blTpCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("blTpCd", blTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOmodifyBlTypeHistoryUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	    
	/**
	 * 다중데이타 모델에 해당되는 값을 불러온다.<br>
	 * Container 별 Purchase Other Number를 조회한다.
	 * @author LEE JIN SEO
	 * @param  PoOtherNoBkgVO poOtherNoBkgVO
	 * @return List
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoOtherCntrVO> searchPoNoByCntr(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoNoByCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherCntrVO.class);
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
	 * 다중데이타 모델에 해당되는 값을 불러온다.<br>
	 * CM 별 Purchase Other Number와 그외 number 정보를 조회한다.
	 * @author LEE JIN SEO
	 * @param  PoOtherNoBkgVO poOtherNoBkgVO
	 * @return List
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoOtherCmVO> searchPoNoByCm(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherCmVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoNoByCmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherCmVO.class);
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
	 * 다중데이타 모델에 해당되는 값을 불러온다.<br>
	 * Ship ID의 Purchase Other Number와 그외 number 정보를 조회한다.
	 * @author LEE JIN SEO
	 * @param  PoOtherNoBkgVO poOtherNoBkgVO
	 * @return List
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoOtherShipVO> searchPoNoByShip(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherShipVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoNoByShipRSQL(), param, velParam);
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
	 * Purchase Other Number와 그외 number 정보를 조회한다
	 * @author LEE JIN SEO
	 * @param poOtherNoBkgVO
	 * @return PoOtherNoBkgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PoOtherNoBkgVO> searchPoNoByBkg(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherNoBkgVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoNoByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherNoBkgVO.class);

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
	 * Purchase Other Number와 그외 number 정보를 조회한다
	 * @author LEE JIN SEO
	 * @param poOtherNoBkgVO
	 * @return PoOtherNoBkgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PoOtherCmVO> searchCmForPo(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherCmVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCmForPoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherCmVO.class);
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
	 * PO No.의 Mandatory Item을 조회한다.
	 * POB : P/O No (by BKG)
	 * POC : P/O Nl ( by CNTR)
	 * POM : P/O No (by ITEM)
	 * INV : Invoice No.
	 * DPT : Department No
	 * LCN : L/C No
	 * SHP : Ship ID
	 * PRT : Part No
     * INC : Incoterms
	 *
	 * @param PoOtherNoBkgVO poOtherNoBkgVO
	 * @return PoOtherMdtItmVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PoOtherMdtItmVO searchPoMdtItm(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherMdtItmVO> list = null;
		PoOtherMdtItmVO poOtherMdtItmVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPoMdtItmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherMdtItmVO .class);
			if(list != null && list.size() > 0){
				poOtherMdtItmVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return poOtherMdtItmVO;
	}
	 
	/**
	 * MRN No와 UCR No 정보를 조회한다
	 * @param PoOtherNoBkgVO poOtherNoBkgVO
	 * @return List<PoOtherMrnUcrVO>
	 * @exception DAOException
	 */
	public List<PoOtherMrnUcrVO> searchMRNNoUCRNoByBkg(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoOtherMrnUcrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMRNNoUCRNoByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoOtherMrnUcrVO.class);
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
     * 다건의 reference no에 해당하는 정보를 저장한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgReferenceVO> listVO
     * @param String caFlg
     * @exception DAOException
     */
    public void addBkgReference(List<BkgReferenceVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            //int cnt[] = null;
            int size = listVO.size();
            if(size > 0) {

        		//query parameter
        		Map<String, Object> param = new HashMap<String, Object>();
        		//velocity parameter
        		Map<String, Object> velParam = new HashMap<String, Object>();
            	Iterator<BkgReferenceVO> list = listVO.iterator();
            	while(list.hasNext()){
            		BkgReferenceVO bkgReferenceVO = (BkgReferenceVO)list.next();
    				Map<String, String> mapVO = bkgReferenceVO .getColumnValues();
    				param.putAll(mapVO);
    				param.put("ca_flg", caFlg);
    				velParam.putAll(mapVO);
    				velParam.put("ca_flg", caFlg);
        			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgRefernceCSQL(), param,velParam);
        			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
            	}

            	/*
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOAddBkgRefernceCSQL(), listVO, null);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }*/
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 reference no에 해당하는 정보를 수정한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgReferenceVO> listVO
     * @param String CaFlg
     * @exception DAOException
     */
    public void modifyBkgReference(List<BkgReferenceVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int cnt[] = null;
            
    		Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ca_flg", caFlg);
            
            int size = listVO.size();
            if(size > 0) {
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOModifyBkgReferenceUSQL(), listVO, velParam);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 reference no에 해당하는 정보를 삭제한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgReferenceVO> listVO
     * @param String caFlg
     * @exception DAOException
     */
    public void removeBkgReference(List<BkgReferenceVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int cnt[] = null;
            
    		Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ca_flg", caFlg);
			
			int size = listVO.size();
            if(size > 0) {
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAORemoveBkgReferenceDSQL(), listVO, velParam);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 다건의 bkg_ref_dtl no에 해당하는 정보를 저장한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgRefDtlVO> listVO
     * @param String caFlg
     * @exception DAOException
     */
    public void addBkgRefDtl(List<BkgRefDtlVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            //int cnt[] = null;
            int size = listVO.size();
            if(size > 0) {
        		//query parameter
        		Map<String, Object> param = new HashMap<String, Object>();
        		//velocity parameter
        		Map<String, Object> velParam = new HashMap<String, Object>();
            	Iterator<BkgRefDtlVO> list = listVO.iterator();
            	while(list.hasNext()){
            		BkgRefDtlVO bkgRefDtlVO = (BkgRefDtlVO)list.next();
    				Map<String, String> mapVO = bkgRefDtlVO .getColumnValues();
    				param.putAll(mapVO);
    				param.put("ca_flg", caFlg);
    				velParam.putAll(mapVO);
    				velParam.put("ca_flg", caFlg);
    				
        			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgRefDtlCSQL(), param,velParam);
        			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
            	}
            	/*
            	 * executeBatch : seq번호가 일괄적으로 증가하지 않는다.
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOAddBkgRefDtlCSQL(), listVO, null);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }*/
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 bkg_ref_dtl no에 해당하는 정보를 수정한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgRefDtlVO> listVO
     * @param String caFlg
     * @exception DAOException
     */
    public void modifyBkgRefDtl(List<BkgRefDtlVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int cnt[] = null;
            int size = listVO.size();

    		Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ca_flg", caFlg);
			
            if(size > 0) {
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOModifyBkgRefDtlUSQL(), listVO, velParam);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 bkg_ref_dtl no에 해당하는 정보를 삭제한다.<br>
     * @author LEE JIN SEO
     * @param List<BkgRefDtlVO> listVO
     * @param String caFlg
     * @exception DAOException
     */
    public void removeBkgRefDtl(List<BkgRefDtlVO> listVO, String caFlg) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int cnt[] = null;
            int size = listVO.size();
            
    		Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ca_flg", caFlg);
            
            if(size > 0) {
                cnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAORemoveBkgRefDtlDSQL(), listVO, velParam);
                for(int i = 0; i < size; i++) {
                    if(cnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


	/**
	 * Reference 데이터를 생성한다.<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgReferenceVO bkgReferenceVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void addBkgReference(BkgReferenceVO bkgReferenceVO, BkgBlNoVO bkgBlNoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgReferenceVO != null){
				Map<String, String> mapVO = bkgReferenceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOManageRefNoCSQL(), param,velParam);

			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Reference 데이터를 갱신한다.<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgReferenceVO bkgReferenceVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			int
	 * @exception 	DAOException
	 */
	public int modifyBkgReference(BkgReferenceVO bkgReferenceVO, BkgBlNoVO bkgBlNoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		try {
			if(bkgReferenceVO != null){
				Map<String, String> mapVO = bkgReferenceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOManageRefNoUSQL(), param,velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

    /**
     * 다건의 House B/L에 해당하는 SCAC No를 저장한다.<br>
     *
	 * @author 		KimByungKyu
     * @param 		List<BkgUsaCstmsFileNoVO> insModels
     * @param 		BkgBlNoVO bkgBlNoVO 
     * @exception 	DAOException
     */
    public void addNVOFileNo(List<BkgUsaCstmsFileNoVO> insModels, BkgBlNoVO bkgBlNoVO) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
    		Map<String, Object> velParam = new HashMap<String, Object>();
            int insCnt[] = null;
            if(insModels.size() > 0) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				velParam.putAll(mapVO);
            	
                insCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOManageNVOFileNumberCSQL(), insModels, velParam);
                for(int i = 0; i < insCnt.length; i++) {
                    if(insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     *  다건의 House B/L에 해당하는 SCAC No를 갱신한다.<br>
     *
	 * @author 		KimByungKyu
     * @param 		List<BkgUsaCstmsFileNoVO> updModels
     * @param 		BkgBlNoVO bkgBlNoVO 
     * @exception 	DAOException
     */
    public void modifyNVOFileNo(List<BkgUsaCstmsFileNoVO> updModels, BkgBlNoVO bkgBlNoVO) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
 		   // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
    		Map<String, Object> velParam = new HashMap<String, Object>();
            int result = 0;
            
            if(updModels.size() > 0) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
                for(int i=0;i<updModels.size();i++){
    	            Map<String, String> mapVO2 = updModels.get(i).getColumnValues();
                	
		            param.putAll(mapVO2);
					velParam.putAll(mapVO);
					result = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOManageNVOFileNumberUSQL(), param, velParam);
	                if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	/**
	 *다건의 House B/L에 해당하는 SCAC No를 삭제한다.<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		List<BkgUsaCstmsFileNoVO> delModels
     * @param 		BkgBlNoVO bkgBlNoVO 
	 * @exception 	DAOException
	 */
	public void removeNVOFileNo(List<BkgUsaCstmsFileNoVO> delModels, BkgBlNoVO bkgBlNoVO) throws DAOException, Exception {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
    		Map<String, Object> velParam = new HashMap<String, Object>();
	        int delCnt[] = null;
	        if(delModels.size() > 0) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				velParam.putAll(mapVO);
	            delCnt = sqlExe.executeBatch((ISQLTemplate) new GeneralBookingReceiptDBDAOManageNVOFileNumberDSQL(), delModels, velParam);
	            for(int i = 0; i < delCnt.length; i++) {
	                if(delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to remove No" + i + " SQL");
	            }
	        }
	    } catch(SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    } catch(Exception ex) {
	        log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}

	/**
	 * Booking 상태코드를 변경한다.(ESM_BKG_0102)<br>
	 * @param pendingFlag
	 * @param spclFlag
	 * @param bkgStsCd
	 * @param bkgBlNoVO
	 * @param account
	 * @throws DAOException
	 */
	public void modifyBookingStatus(String pendingFlag, String spclFlag, String bkgStsCd, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		modifyBookingStatus(pendingFlag, spclFlag, bkgStsCd, bkgBlNoVO, account, null);
	}
	
	/**
	 * Booking 상태코드를 변경한다.(ESM_BKG_0102)<br>
	 * @param pendingFlag
	 * @param spclFlag
	 * @param bkgStsCd
	 * @param bkgBlNoVO
	 * @param account
	 * @param oldBkgStsCd
	 * @throws DAOException
	 */
	public void modifyBookingStatus(String pendingFlag, String spclFlag, String bkgStsCd, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String oldBkgStsCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_sts_cd", bkgStsCd);
			param.put("wt_rsn_spcl_cgo_flg", spclFlag);
			param.put("wt_rsn_hld_flg", pendingFlag);
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("upd_usr_id", account.getUsr_id());
			
			
			if(oldBkgStsCd != null && (!bkgStsCd.equals(oldBkgStsCd) && bkgStsCd.equals("F") && !oldBkgStsCd.equals("F"))){
				velParam.put("bkg_sts_cd", bkgStsCd);
			}
			
			if(bkgBlNoVO.getCaFlg() != null)
				velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			
			if(bkgBlNoVO.getMessage() != null && !bkgBlNoVO.getMessage().equals("")){
				velParam.put("message", bkgBlNoVO.getMessage());
				param.put("message", bkgBlNoVO.getMessage());
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBookingStatusUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ETA of 1st VVD 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @param   String bkgNo
	 * @return 	VslSkdVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public N1stEtaDelEtaVO search1stVvdEta(PolPodVvdVO polPodVvdVO, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<N1stEtaDelEtaVO> list = null;
		N1stEtaDelEtaVO n1stEtaDelEtaVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(polPodVvdVO != null){
				Map<String, String> mapVO = polPodVvdVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgNo);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, N1stEtaDelEtaVO .class);
			if(list != null && list.size() > 0){
				n1stEtaDelEtaVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return n1stEtaDelEtaVO;
	}

	/**
	 * Ocean Route 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @return 	VslSkdVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public VslSkdVO searchLaneEtdEta(PolPodVvdVO polPodVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSkdVO> list = null;
		VslSkdVO vslSkdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(polPodVvdVO != null){
				Map<String, String> mapVO = polPodVvdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchLaneEtdEtaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);
			if(list != null && list.size() > 0){
				vslSkdVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vslSkdVO;
	}

	/**
	 * Ocean Route 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String podCd
	 * @param 	String polCd
	 * @return 	boolean
	 * @exception DAOException
	 */
	public boolean searchTSRouteForEqualPort(String podCd, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("pod_cd", podCd);
			param.put("pol_cd", polCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchTSRouteForEqualPortRSQL(), param, velParam);

			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isCount = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}


	/**
	 * Tro quantity 를 변경한다.(ESM_BKG_0079_02A)<br>
	 *
	 * @author Lee NamKyung
	 * @param BkgQuantityVO vo
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgQtyByTro(BkgQuantityVO vo, String boundCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			param.put("io_bnd_cd",  boundCd);
			param.put("upd_usr_id", account.getUsr_id());
			velParam.putAll(mapVO);
			velParam.put("io_bnd_cd",  boundCd);
			velParam.put("upd_usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgQtyByTroUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}

	/**
	 * BKG_BOOKING의 MTY_PKUP_YD_CD/FULL_RTN_YD_CD 를 변경한다.(ESM_BKG_0079_02C)<br>
	 *
	 * @author Shin Jayoung
	 * @param  BkgBlNoVO vo
	 * @exception DAOException
	 */
	public void modifyEurPkupRtnCy(BkgBlNoVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}

	/**
	 * BookingCreation 사용자 Default 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String userId
	 * @return 		BkgUsrDfltSetVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgUsrDfltSetVO searchUserBkgDefault(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgUsrDfltSetVO> list = null;
		BkgUsrDfltSetVO bkgUsrDfltSetVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("usr_id", userId);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchUserBkgDefaultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsrDfltSetVO .class);
			if(list != null && list.size() > 0){
				bkgUsrDfltSetVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgUsrDfltSetVO;
	}

	/**
	 * BookingCreation CmdtCd로 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String cmdtCd
	 * @return 		CmdtVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CmdtVO searchPrecaution(String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CmdtVO> list = null;
		CmdtVO cmdtVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cmdt_cd", cmdtCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPrecautionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CmdtVO .class);
			if(list != null && list.size() > 0){
				cmdtVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtVO;
	}

	 /**
	  * cargo closing time에 기본 row들을 넣는다.<br>
      * @param BkgBlNoVO bkgBlNoVO
	  * @param SignOnUserAccount account
	  * @exception DAOException
	  */
	 public void addCargoClosingTime(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);				
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOaddCargoClosingTimeCSQL(), param,velParam);

			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}

	 /**
	  * cc 테이블에 수정<br>
	  * 
	  * @param BkgClzTmVO bkgClzTmVO
	  * @return int
	  * @exception DAOException
	  */
	public int modifyCargoClosingTime(BkgClzTmVO bkgClzTmVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(bkgClzTmVO != null){
				Map<String, String> mapVO = bkgClzTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyCargoClosingTimeUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	  * cc 테이블에 SYSTEM TIME을 조회<br>
	  * 
	  * @param String bkgNo
	  * @param String clzTpCd
	  * @return String
	  * @exception DAOException
	  */
	public String ssearchSystemCargoClosingTime(String bkgNo, String clzTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("clz_tp_cd", clzTpCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSystemCargoClosingTimeRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("SYS_SET_DT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * Booking 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		BkgBookingInfoVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgBookingInfoVO searchBkgBookingInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		BkgBookingInfoVO bkgBookingInfoVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgBookingInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO .class);
			if(list != null && list.size() > 0){
				bkgBookingInfoVO = list.get(0);
			}
			
			if(bkgBookingInfoVO != null){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL(), param, velParam);
				while (dbRowset.next()) {
					bkgBookingInfoVO.setLstSavDt(dbRowset.getString("LST_SAV_DT"));
				}
			}
				
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBookingInfoVO;
	}

	/**
	 * Booking Vvd 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<BkgVvdVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslSkdVO> searchVvdSkdForTsRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSkdVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdVO .class);
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
	 * Booking Quantity 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<BkgQuantityVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgQuantityRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);
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
	 * Booking Qty Dtl 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<BkgQtyDtlVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQtyDtlVO> searchBkgQtyDtl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyDtlVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgQtyDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO .class);
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
	 * Booking Customer 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String tpCd
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		BlCustomerInfoVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BlCustomerInfoVO searchBkgCustomer(String tpCd, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlCustomerInfoVO> list = null;
		BlCustomerInfoVO blCustomerInfoVO = null;
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
			velParam.put("tp_cd", tpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCustomerInfoVO .class);
			if(list != null && list.size() > 0){
				blCustomerInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blCustomerInfoVO;
	}

	/**
	 * Booking CNTC PSON  정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<BkgCntcPsonVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCntcPsonVO> searchBkgCntcPson(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCntcPsonVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgCntcPsonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCntcPsonVO .class);
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
	 * Booking Route 유효성여부 확인.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchVslSkdAvailable(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean vvdFlag = false;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchVslSkdAvailableRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") <= 0){
					vvdFlag = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdFlag;
	}
	/**
	 * bkg에 승인되지 않은 special cargo 정보가 있는지 확인.(ESM_BKG_0079_01)<br>
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchSpclNotApprove(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "N";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSpclNotApproveRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("REJECT_FLAG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	/**
	 * bkg에 승인된 special cargo 정보가 있는지 확인.(ESM_BKG_0079_01)<br>
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchSpclApprove(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "N";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSpclApproveRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("RESULT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}	
	/**
	 * bkg에 승인되지 않은 special cargo 있는지 여부 조회.(ESM_BKG_0079_01)<br>
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchSpclWaitRsn(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "N";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSpclWaitRsnRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("WT_RSN_SPCL_CGO_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}	
	/**
	 * Block Stowage 순위 결정.(ESM_BKG_0079_01)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBookingInfoVO bkgBookingInfoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchBlockStowage(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBookingInfoVO != null){
				Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBlockStowageRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("BLCK_STWG_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}	
	
	/**
	 * User Hold 상태인지 조회한다..(ESM_BKG_0079_01)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchUserHold(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchUserHoldRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("WT_RSN_HLD_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * Container Type/Size 유효성 검사.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String cntrTpSz
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchCntrTpSz(String cntrTpSz) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("cntr_tpsz_cd", cntrTpSz);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCntrTpSzRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 * BL NO 중복여부 체크.(ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchBkgBlNoDup(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgBlNoDupRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	  * 생성된 BL NO 저장.(ESM_BKG_0079_01) -> createBooking
	  * 
	  * @author 		KimByungKyu
	  * @param 		BkgBlNoVO bkgBlNoVO
	  * @param 		String userId
	  * @exception	DAOException
	  */
	public void addBkgBlNoDup(BkgBlNoVO bkgBlNoVO, String userId) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("cre_usr_id", userId);
			param.put("upd_usr_id", userId);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgBlNoDupCSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ORG_TRNS_SVC_MOD_CD 조회.(ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String trnkLaneCd
	 * @param 		String skdDirCd
	 * @param 		String porCd
	 * @param 		String polCd
	 * @param 		String preRlyCd
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchOrgSvcRoute(String trnkLaneCd, String skdDirCd, String porCd, String polCd, String preRlyCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			param.put("pre_rly_port_cd", preRlyCd);
			param.put("por_cd", porCd);
			param.put("pol_cd", polCd);
			param.put("skd_dir_cd", skdDirCd);
			param.put("trunk_lane_cd", trnkLaneCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchOrgSvcRouteRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnValue = dbRowset.getString("ORG_SVC_MODE");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * DEST_TRNS_SVC_MOD_CD 조회.(ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String trnkLaneCd
	 * @param 		String skdDirCd
	 * @param 		String podCd
	 * @param 		String delCd
	 * @param 		String pstRlyCd
	 * @param 		String ocpCd
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchDstSvcRoute(String trnkLaneCd, String skdDirCd, String podCd, String delCd, String pstRlyCd, String ocpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			param.put("pst_rly_port_cd", pstRlyCd);
			param.put("pod_cd", podCd);
			param.put("del_cd", delCd);
			param.put("skd_dir_cd", skdDirCd);
			param.put("trunk_lane_cd", trnkLaneCd);
			param.put("ocp_cd", ocpCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchDstSvcRouteRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnValue = dbRowset.getString("DST_SVC_MODE");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * SVC_SCP_CD를 조회한다. (ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String trnkLaneCd
	 * @param 		String porCd
	 * @param 		String delCd
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchSvcScope(String trnkLaneCd, String porCd, String delCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			param.put("trnk_lane_cd", trnkLaneCd);
			param.put("por_cd", porCd);
			param.put("del_cd", delCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSvcScopeRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnValue = dbRowset.getString("SVC_SCP_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * Financial Direction을 찾는다. (ESM_BKG_0079_01) -> createBooking<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String trnkLaneCd
	 * @param 		String skdDirCd
	 * @param 		String polCd
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchFinDir(String trnkLaneCd, String skdDirCd, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			param.put("trnk_lane_cd", trnkLaneCd);
			param.put("skd_dir_cd", skdDirCd);
			param.put("pol_cd", polCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchFinDirRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnValue = dbRowset.getString("REV_DIR_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 *  BKG_BOOKING 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBookingInfoVO bkgBookingInfoVO
	 * @exception 	DAOException
	 */
	public void addBkgBooking(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBookingInfoVO != null){
				Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgBookingCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *  Booking 정보 수정.(ESM_BKG_0079_01) -> modifyBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBookingInfoVO bkgBookingInfoVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void modifyBkgBooking(BkgBookingInfoVO bkgBookingInfoVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgBookingInfoVO != null){
				Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("irr_bl_no_flg", bkgBlNoVO.getBkgTyFlg());
			
			String blNo = (String) param.get("bl_no");
			if(blNo != null && blNo.length() > 12) blNo = blNo.substring(0, 12);
			else if(blNo != null && blNo.length() == 11) blNo = blNo.substring(0, 10);
			
			param.put("bl_no", blNo);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgBookingUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *  BKG_CUSTOMER 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgCustomerVO bkgCustomerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void addBkgCustomer(BkgCustomerVO bkgCustomerVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgCustomerVO != null){
				Map<String, String> mapVO = bkgCustomerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			DBRowSet dbRowset = sqlExe.executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL(), param, velParam);
			int lengthCk = 35;
			if(dbRowset.next()){
				String custNm = "";
				String custAddr = "";
				custAddr = getStrEnterAppend(dbRowset.getString("ADDR"), lengthCk);
				if(velParam.get("cust_nm").equals("")){
					custNm = getStrEnterAppend(dbRowset.getString("CUST_LGL_ENG_NM"), lengthCk);
				}else{
					custNm = getStrEnterAppend(velParam.get("cust_nm").toString(), lengthCk);
				}
				param.put("cust_addr", custAddr);
				param.put("cust_nm", custNm);
			}
			
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgCustomerCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param str
	 * @param lengthCk
	 * @return
	 */
	private String getStrEnterAppend(String str, int lengthCk){
		StringBuffer sb = new StringBuffer();
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			if((num == lengthCk) || (str.getBytes()[i] == KeyEvent.VK_ENTER)){
				sb.append("\n");
				num = 0;
			}else{
				sb.append(str.charAt(i));
				num++;
			}
		}
		return sb.toString();
	}
	
	/**
	 *  BKG_CUSTOMER 정보 수정.(ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgCustomerVO bkgCustomerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String custSubstFlg
	 * @exception 	DAOException
	 */
	public void modifyBkgCustCode(BkgCustomerVO bkgCustomerVO, BkgBlNoVO bkgBlNoVO, String custSubstFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgCustomerVO != null){
				Map<String, String> mapVO = bkgCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("cust_subst_flg", custSubstFlg);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DBRowSet dbRowset = sqlExe.executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL(), param, velParam);
			int lengthCk = 35;
			if(dbRowset.next()){
				String custAddr = "";
				custAddr = getStrEnterAppend(dbRowset.getString("ADDR"), lengthCk);
				param.put("cust_addr", custAddr);
				param.put("fmc_no", dbRowset.getString("FMC_NO"));		
			}			
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgCustCodeUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *  BKG_QUANTITY 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgQuantityVO bkgQuantityVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void addBkgQuantity(BkgQuantityVO bkgQuantityVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgQuantityVO != null){
				Map<String, String> mapVO = bkgQuantityVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgQuantityCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_QUANTITY 정보 삭제.(ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		ArrayList<String> cntrTpSzList
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String sFlag
	 * @exception 	DAOException
	 */
	public void removeBkgQuantity(ArrayList<String> cntrTpSzList, BkgBlNoVO bkgBlNoVO,String sFlag) throws DAOException {
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
			velParam.put("mode_flag",sFlag);
			if(cntrTpSzList != null && cntrTpSzList.size() > 0) {
				velParam.put("cntr_tpsz_cd", cntrTpSzList);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgQuantityDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_QUANTITY 정보 수정.(ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgQuantityVO bkgQuantityVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		int
	 * @exception 	DAOException
	 */
	public int modifyBkgQuantity(BkgQuantityVO bkgQuantityVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgQuantityVO != null){
				Map<String, String> mapVO = bkgQuantityVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgQuantityUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

	/**
	 *  BKG_VVD 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgVvdVO bkgVvdVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void addBkgVvd(BkgVvdVO bkgVvdVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgVvdVO != null){
				Map<String, String> mapVO = bkgVvdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgVvdCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_VVD 정보 삭제.(ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void removeBkgVvd(BkgBlNoVO bkgBlNoVO) throws DAOException {
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

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgVvdDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
	/**
	 *  BKG_CNTC_PSON 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgCntcPsonVO bkgCntcPsonVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void addBkgCntcPson(BkgCntcPsonVO bkgCntcPsonVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgCntcPsonVO != null){
				Map<String, String> mapVO = bkgCntcPsonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgCntcPsonCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_CNTC_PSON 정보 수정.(ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgCntcPsonVO bkgCntcPsonVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		int
	 * @exception 	DAOException
	 */
	public int modifyBkgCntcPson(BkgCntcPsonVO bkgCntcPsonVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgCntcPsonVO != null){
				/* 메일주소 중간 공백 제거 */
				if(bkgCntcPsonVO.getCntcPsonEml() != null) bkgCntcPsonVO.setCntcPsonEml(bkgCntcPsonVO.getCntcPsonEml().replaceAll("\\s", ""));
				Map<String, String> mapVO = bkgCntcPsonVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgCntcPsonUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

	/**
	 *  CNTC_PSON_EML 수정(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @exception 	DAOException
	 */
	public void modifyCntcEmailFromAgent(String bkgNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCntcEmailFromAgentUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  BKG_ROLL_OVR 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */

	public void addBkgRollOvr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);

			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());			
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgRollOvrCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	

	/**
	 *  BKG_ROLL_OVR 정보 저장.(ESM_BKG_0079_01) -> createBooking<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBkgRollOvr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgRollOvrUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * Booking을 수정한다.(ESM_BKG_007901)<br>
     *
     * @author 		
     * @param 		bkgBookingVO BkgBookingVO
     * @param       caFlg
     * @exception 	DAOException
     */
    public void modifyBkgByCm(BkgBookingVO bkgBookingVO, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = bkgBookingVO .getColumnValues();
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAOModifyBkgByCmUSQL template = new GeneralBookingReceiptDBDAOModifyBkgByCmUSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

	/**
	 * Sc Type을 조회한다. (ESM_BKG_0079_01) -> createBooking<br>
	 *
	 * @author 		KimByungKyu 
	 * @param 		String scNo
	 * @param		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchScType(String scNo, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			param.put("sc_no", scNo);
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("ca_flg", bkgBlNoVO.getCaFlg());
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchScTypeRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnValue = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}


	/**
	 * F.A.K 여부 판단.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String cmdtCd
	 * @param 		String por
	 * @param 		String del
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchCmdtFak(String cmdtCd, String por, String del) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("cmdt_cd", cmdtCd);
			param.put("por_cd", por);
			param.put("del_cd", del);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCmdtFakRSQL(), param, velParam);
			if(dbRowset.next()){
				if("N".equals(dbRowset.getString("result"))){
					isOk = true;
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
	 * CHN Agent 여부 판단.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchChnAgent(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchChnAgentRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 * OCP를 입력했는데 US지역이 아닌 경우 / 등록되지 않은 location code인 경우.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String locCd
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchOcp(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String isOk = "";
		try{
			param.put("ocp_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchOcpRSQL(), param, velParam);
			if(dbRowset.next()){
				isOk = dbRowset.getString("BL_MOVE_TP_NM");
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
	 * RCV/DLV Term이 Yard 인데 POR/DEL에 속한 YARD가 없을 경우 확인.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String locCd
	 * @param 		String ydCd
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchYard(String locCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("loc_cd", locCd);
			param.put("yd_cd", ydCd);
			if(ydCd.length() < 7){
				velParam.put("yd_cd", "");
			}else{
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchYardRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 * RCV/DLV TERM이 DOOR인데 POR/DEL에 속한 ZONE이 없을 경우.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String locCd
	 * @param 		String znCd
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchZone(String locCd, String znCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("loc_cd", locCd);
			param.put("zn_cd", znCd);
			if(znCd.length() < 7){
				velParam.put("zn_cd", "");
			}else{
				velParam.put("zn_cd", znCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchZoneRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 * DEL이 EGALY, EGPSD인데 DLV TERM이 O가 아닐 경우.(ESM_BKG_0079_01)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		String delCd
	 * @param 		String deTermCd
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchLocVsTerm(String delCd, String deTermCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			param.put("del_cd", delCd);
			param.put("de_term_cd", deTermCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchLocVsTermRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 *  미 세관신고로 download 이후 VVD, POD, DEL을 변경한 경우.(ESM_BKG_0079_01) <br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		Boolean
	 * @exception 	DAOException
	 */
	public boolean searchUsaCstmsDownload(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchUsaCstmsDownloadRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 *  미주향 BOOKING인데 download되고 USA FILER CODE or CANADA FILER CODE가 1일 경우 HOUSE B/L 정보가 입력되어 있어야함.(ESM_BKG_0079_01) <br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String usFilerCd
	 * @param 		String caFilerCd
	 * @param 		String delCd
	 * @return 		Boolean
	 * @exception 	DAOException
	 */
	public boolean searchHblForCarrierFiling(BkgBlNoVO bkgBlNoVO, String usFilerCd, String caFilerCd, String delCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("us_filer_cd", usFilerCd);
			param.put("ca_filer_cd", caFilerCd);
			param.put("del_cd", delCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchHblForCarrierFilingRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getString("RESULT").equals("Y")){
					isOk = true;
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
	 *  RATING 이후에 route, TYPE/SIZE, Vol을 수정할 경우.(ESM_BKG_0079_01) <br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		Boolean
	 * @exception 	DAOException
	 */
	public boolean searchIsRated(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchIsRatedRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 *  POR, POL, POD, DEL, R/D TERM이 변경되어 TRO가 UNCONFIRM된 경우.(ESM_BKG_0079_01) <br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		Boolean
	 * @exception 	DAOException
	 */
	public boolean searchTroCfm(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchTroCfmRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					isOk = true;
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
	 * 수정전 Booking 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		OldBkgInfoVO
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public OldBkgInfoVO searchOldBkgInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OldBkgInfoVO> list = null;
		OldBkgInfoVO oldBkgInfoVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OldBkgInfoVO .class);
			if(list != null && list.size() > 0){
				oldBkgInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return oldBkgInfoVO;
	}

    /**
     * remove Bkg Ref By Cntr
     * 
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @exception DAOException
     */
    public void removeBkgRefByCntr(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefByCntrDSQL template = new GeneralBookingReceiptDBDAORefByCntrDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }  
    }
    
    /**
     * remove Bkg Ref Dtl By Cntr
     * 
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @exception DAOException
     */
    public void removeBkgRefDtlByCntr(String bkgNo, String cntrNo, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefDtlByCntrDSQL template = new GeneralBookingReceiptDBDAORefDtlByCntrDSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
	 * cntr 별 reference no를 변경한다.
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
	 * @param caFlg
     * @exception DAOException
     */
    public void changeReferenceByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_no_old", cntrNoOld);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);  
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefByCntrUSQL template = new GeneralBookingReceiptDBDAORefByCntrUSQL();
            int delCnt = sqlExe.executeUpdate(template, param,velParam);
            if(delCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to remove SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    /**
	 * cntr 별 reference detail 정보를 변경한다
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
	 * @param caFlg
     * @exception DAOException
     */
    public void changeReferenceDetailByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);
            mapVO.put("cntr_no_old", cntrNoOld);
            mapVO.put("ca_flg", caFlg);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);  

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefDtlByCntrUSQL template = new GeneralBookingReceiptDBDAORefDtlByCntrUSQL();
            int delCnt = sqlExe.executeUpdate(template, param,velParam);
            if(delCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to remove SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	/**
	 *  BKG_CLZ_TM 삭제.(ESM_BKG_0079_01)<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String modeCd
	 * @exception 	DAOException
	 */
	public void removeBkgClzTm(BkgBlNoVO bkgBlNoVO, String modeCd) throws DAOException {
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
			param.put("mode_cd", modeCd);
			velParam.put("mode_cd", modeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgClzTmDSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * split시 저장을 위해 bkg_booking 테이블을 조회한다. (ESM_BKG_0099)<br>
     * 
     * @param CopySplitBkgEtcVO copySplitBkgEtcVO
     * @param BkgBlNoVO sourceBkg
     * @param SignOnUserAccount account
     * @return	BkgBookingVO
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
    public BkgBookingVO searchBkgBookingForSplit(CopySplitBkgEtcVO copySplitBkgEtcVO,BkgBlNoVO sourceBkg,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;
		BkgBookingVO bkgBookingVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sourceBkg != null){
				Map<String, String> mapVO = copySplitBkgEtcVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchBkgBookingForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO .class);
			if(list != null && list.size() > 0){
				bkgBookingVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBookingVO;
	}

    /**
     * sourceBkg의 bkg_customer를 targetBkg로 복사한다. (ESM_BKG_0099)<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgCustomerByBkg(BkgBlNoVO sourceBkg,BkgBlNoVO targetBkg,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sourceBkg != null){

				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyBkgCustomerByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

    /**
     * Booking 테이블에 etd,eta,protclzdt 수정 (ESM_BKG_0099)<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @exception DAOException
     */
    public void modifyEtdEtaPortClzDt(BkgBlNoVO sourceBkg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sourceBkg != null){
				param.put("bkg_no", sourceBkg.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyEtdEtaPortClzDtUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

    /**
     * Booking Copy, Split 용으로 Booking Insert (ESM_BKG_0099)<br>
     * 
     * @param BkgBookingVO bkgBookingVO
     * @exception DAOException
     */
    public void addBkgBookingForCopySplit(BkgBookingVO bkgBookingVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBookingVO != null){
				Map<String, String> mapVO = bkgBookingVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOaddBkgBookingForCopySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    /**
     * VVD 정보 조회 (ESM_BKG_0099) <br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgVvdVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgVvdVO> searchBkgVvd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO .class);
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
     * 새로운 route가 적용되는 bkg에 대해 조회 (ESM_BKG_0099)<br>
     * 
     * @param String codRqstNo
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgVvdVO> searchCodNewVvdForSplit(String codRqstNo,BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("codRqstSeq",codRqstNo);
				velParam.put("codRqstSeq",codRqstNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchCodNewVvdForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO .class);
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
     * sourceBkg의 bkg_cntc_pson를 targetBkg로 복사한다. (ESM_BKG_0099)<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgCntcPsonByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){

				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyBkgCntcPsonByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_reference를 targetBkg로 복사한다.  (ESM_BKG_0099)<br>
	 * 전달받은 cntr에 해당하는 row만 복사한다. <br>
	 * 
     * @param String cntrNo
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgRefByBkg(String cntrNo,BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				velParam.put("cntr_no", cntrNo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyBkgRefByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_ref_dtl을 targetBkg로 복사한다. (ESM_BKG_0099)<br>
     * 전달받은 cntr에 해당하는 row만 복사한다.<br>
     * 
     * @param String cntrNo
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgRefDtlByBkg(String cntrNo,BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				velParam.put("cntr_no", cntrNo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyBkgRefDtlByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * bkg_reference에서 전달받은 cntrNo에 해당하는 row를 삭제한다. (ESM_BKG_0099)<br>
     * 
     * @param String cntrNo
     * @param BkgBlNoVO bkgBlNoVO
     * @exception DAOException
     */
    public void removeBkgRefAfterSplit(String cntrNo,BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOremoveBkgRefAfterSplitDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * bkg_ref_dtl에서 전달받은 cntrNo에 해당하는 row를 삭제한다. (ESM_BKG_0099)<br>
     * 
     * @param String cntrNo
     * @param BkgBlNoVO bkgBlNoVO
     * @exception DAOException
     */
    public void removeBkgRefDtlAfterSplit(String cntrNo,BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOremoveBkgRefDtlAfterSplitDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * Booking split이후 bkg_booking에 update할 항목을 처리한다. (ESM_BKG_0099)<br>
     * 
     * @param SplitBlInfoVO splitBlInfoVO
     * @param CopySplitBkgEtcVO copySplitBkgEtcVO
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyBkgbookingAfterSplit(SplitBlInfoVO splitBlInfoVO, CopySplitBkgEtcVO copySplitBkgEtcVO,BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("split_rsn_cd", copySplitBkgEtcVO.getSplitreason());
				param.put("localtime", JSPUtil.getKSTDate());
				param.put("splitCount", copySplitBkgEtcVO.getSplitcount());
				param.put("vsl_cd", splitBlInfoVO.getTvvd().substring(0,4));
				param.put("skd_voy_no", splitBlInfoVO.getTvvd().substring(4,8));
				param.put("skd_dir_cd", splitBlInfoVO.getTvvd().substring(8,9));
				param.put("usr_id", account.getUsr_id());
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgbookingAfterSplitUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    /**
     * Memo Split 경우 booking master update<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyMemoSplit(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("usr_id", account.getUsr_id());
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyMemoSplitUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    /**
	 * special cgo qty를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param SpclQtyVO spclQtyVO
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyAwkQty(SpclQtyVO spclQtyVO, String caFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			param.put("bkg_no", spclQtyVO.getBkgNo());
			param.put("cntr_tpsz_cd", spclQtyVO.getCntrTpszCd());
			velParam.put("ca_flg", caFlg);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyAwkQtyUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Booking 상태코드를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifyBkgSpclFlg(String bkgNo, String spclTp, String caFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			param.put("bkg_no", bkgNo);
			param.put("spcl_tp", spclTp);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("spcl_tp", spclTp);
			velParam.put("ca_flg", caFlg);
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgSpclFlgUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Booking 상태코드를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrTpszCd	
	 * @param String spclTp
	 * @param String cntrVolQty
	 * @param String caFlg
	 * @exception DAOException
	 */
	public void modifySpclQty(String bkgNo, String cntrTpszCd, String spclTp, String cntrVolQty, String caFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_cd", cntrTpszCd);	
			param.put("spcl_tp", spclTp);	
			param.put("cntr_vol_qty", cntrVolQty);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_tpsz_cd", cntrTpszCd);	
			velParam.put("spcl_tp", spclTp);	
			velParam.put("cntr_vol_qty", cntrVolQty);
			velParam.put("ca_flg", caFlg);
			
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyAwkQtyUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  Booking 정보 수정.(ESM_BKG_0029) -> modifyBkgBookingByXter<br>
	 *
	 * @author 	Jun Yong Jin
	 * @param 	BkgBookingInfoVO bkgBookingInfoVO
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void modifyBkgBookingByXter(BkgBookingInfoVO bkgBookingInfoVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBookingInfoVO != null){
				Map<String, String> mapVO = bkgBookingInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgBookingByXterUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Xter Reference 데이터를 생성한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String docTpCd
	 * @param int no
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addXterReference(XterRqstNoVO xterRqstNoVO, String docTpCd, int no, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("no", no);
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOaddXterRefenceCSQL(), param,velParam);

			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Xter Reference 데이터를 갱신한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String docTpCd
	 * @param int no
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
	public int modifyXterReference(XterRqstNoVO xterRqstNoVO, String docTpCd, int no, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt=0;
		try {
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("no", no);
			param.put("usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyXterRefernceUSQL(), param,velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	/**
	 *  BKG_CUSTOMER 정보 수정.(ESM_BKG_0229) -> createBooking<br>
	 *
	 * @author 	Jun Yong Jin
	 * @param 	BkgCustomerVO bkgCustomerVO
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void modifyBkgCustomerByXter(BkgCustomerVO bkgCustomerVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgCustomerVO != null){
				Map<String, String> mapVO = bkgCustomerVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgCustomerByXterUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  Empty Booking 정보를 저장한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		MtyBookingVO mtyBookingVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void addMtyBkgBooking(String bkgNo , MtyBookingVO mtyBookingVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(mtyBookingVO != null){
				Map<String, String> mapVO = mtyBookingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("bkg_no", bkgNo);
			param.put("bkg_ofc_cd", account.getOfc_cd());
			param.put("sls_rhq_cd", account.getOfc_cd());
			param.put("sls_rgn_ofc_cd", account.getOfc_cd());
			param.put("ob_sls_cd", account.getOfc_cd());
			param.put("doc_usr_id", account.getUsr_id());
			param.put("bl_no", bkgNo);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddMtyBkgBookingCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  Empty Booking 정보를 수정한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		RepoBkgVO repoBkgVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyMtyBkgBooking(RepoBkgVO repoBkgVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(repoBkgVO != null){
				Map<String, String> mapVO = repoBkgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("upd_usr_id", account.getUsr_id());			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyMtyBkgBookingUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  Empty Booking Customer 정보를 삭제한다.<br>
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception 	DAOException
	 */
	public void removeBkgCustomer(BkgBlNoVO bkgBlNoVO) throws DAOException {
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
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgCustomerDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  Empty Booking Customer 정보를 저장한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void addMtyBkgCust(String bkgNo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  Empty Booking Quantity 정보를 저장한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		MtyQtyVO mtyQtyVO
	 * @param 		String bkgNo
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void addMtyBkgQty(MtyQtyVO mtyQtyVO, String bkgNo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(mtyQtyVO != null){
				Map<String, String> mapVO = mtyQtyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			param.put("bkg_no", bkgNo);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddMtyBkgQtyCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 *  Trunk VVD 정보를 수정한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String vvd
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyTrunkVvd(String vvd, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("vvd", vvd);
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyTrunkVvdUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		


	/**
	 * Customer Information을 조회한다.(ESM_BKG_0079_05)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		BlDocCustVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BlDocCustVO searchBlDocCust(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlDocCustVO> list = null;
		BlDocCustVO blDocCustVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBlDocCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlDocCustVO .class);
			if(list != null && list.size() > 0){
				blDocCustVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blDocCustVO;
	}	


	/**
	 * Customer Information 이외의 정보를 조회한다.(ESM_BKG_0079_05)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		CustEtcVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustEtcVO searchBkgCustEtc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustEtcVO> list = null;
		CustEtcVO custEtcVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgCustEtcRSQL(), param, velParam);
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
	 * state가 입력되었을경우 country와 state를 맞게 입력했는지 확인.(ESM_BKG_0079_05)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String cntCd
	 * @param 		String stateCd
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchCntVsState(String cntCd, String stateCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			param.put("ste_cd", stateCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCntVsStateRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("cnt") > 0){
					isCount = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}		 

	/**
	 *  BKG_CUSTOMER 정보 수정.(ESM_BKG_0079_05) -> Customer Information<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgCustomerVO bkgCustomerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			int
	 * @exception 	DAOException
	 */
	public int modifyBkgCustomer(BkgCustomerVO bkgCustomerVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if(bkgCustomerVO != null){
				Map<String, String> mapVO = bkgCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgCustomerUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}		

	/**
	 *  CUSTOMER 화면에서 Booking 정보 수정.(ESM_BKG_0079_05) -> Customer Information<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		CustEtcVO custEtcVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBkgBookingByCust(CustEtcVO custEtcVO, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			param.put("upd_usr_id", account.getUsr_id());
			if(custEtcVO != null){
				Map<String, String> mapVO = custEtcVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgBookingByCustUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  E-Booking CUSTOMER 화면에서 Booking 정보 수정.(ESM_BKG_0229)<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		CustEtcVO custEtcVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyXterBkgBookingByCust(CustEtcVO custEtcVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("upd_usr_id", account.getUsr_id());
			if(custEtcVO != null){
				Map<String, String> mapVO = custEtcVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyXterBkgBookingByCustUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Cargo Detail 정보 조회시 Booking Flag를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		CargoDtlEtcVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CargoDtlEtcVO searchCargoDtlEtc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CargoDtlEtcVO> list = null;
		CargoDtlEtcVO cargoDtlEtcVO = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCargoDtlEtcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CargoDtlEtcVO .class);
			if(list != null && list.size() > 0){
				cargoDtlEtcVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cargoDtlEtcVO;
	}		

	/**
	 *  BkgQtyDtl 정보를 삭제한다.<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String cntrTpszCd
	 * @return 		int
	 * @exception 	DAOException
	 */
	public int removeBkgQtyDtl(BkgBlNoVO bkgBlNoVO, String cntrTpszCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("cntr_tpsz_cd", cntrTpszCd);
			velParam.put("cntr_tpsz_cd", cntrTpszCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			delCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgQtyDtlDSQL(), param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}	 

	/**
	 * BkgQtyDtl 정보를 저장한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgQtyDtlVO bkgQtyDtlVO
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @exception DAOException
	 */
	public void addBkgQtyDtl(BkgQtyDtlVO bkgQtyDtlVO, BkgBlNoVO bkgBlNoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgQtyDtlVO != null){
				Map<String, String> mapVO = bkgQtyDtlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			param.put("ca_no", bkgBlNoVO.getCaNo());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddBkgQtyDtlCSQL(), param,velParam);

			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * bkg_cod_vvd에서 bkg_vvd로 복사한다.
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgVvdFromCod(String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			 
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq",codRqstSeq);
				velParam.put("cod_rqst_seq",codRqstSeq);
				param.put("usr_id",account.getUsr_id());
				velParam.put("usr_id",account.getUsr_id());
				
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgVvdFromCodUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * bkg_cod에서 bkg_booking으로 t/vvd, pod, pod_node, del, del_node를 update한다.
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void modifyBkgBookingFromCod(String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			 
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq",codRqstSeq);
				velParam.put("cod_rqst_seq",codRqstSeq);
				param.put("usr_id",account.getUsr_id());
				velParam.put("usr_id",account.getUsr_id());
				
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgBookingFromCodUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * Combine을 위한 Booking Qty 정보를 조회한다.(ESM_BKG_0076)<br>
	 * @author 	Jun Yong Jin
	 * @param 	BkgBlNoVO[] sourceBkg
	 * @param 	BkgBlNoVO targetBkg
	 * @return 	List<BkgQuantityVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQuantityVO> combineBkgQty(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> bkgNoString = new ArrayList();

		try{
			if(sourceBkg != null){
				for(int i=0;i<sourceBkg.length;i++) {
					bkgNoString.add(sourceBkg[i].getBkgNo());
				}
			}
			if(targetBkg != null){
				bkgNoString.add(targetBkg.getBkgNo());
				param.put("mst_bkg_no", targetBkg.getBkgNo());
			}else{
				param.put("mst_bkg_no", "");
			}
			velParam.put("bkg_no_list", bkgNoString);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOcombineBkgQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);
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
	 * Combine을 위한 Booking Qty Dtl 정보를 조회한다.(ESM_BKG_0076)<br>
	 * @author 	Jun Yong Jin
	 * @param 	BkgBlNoVO[] sourceBkg
	 * @param 	BkgBlNoVO targetBkg
	 * @return 	List<BkgQtyDtlVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQtyDtlVO> combineBkgQtyDtl(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> bkgNoString = new ArrayList();

		try{
			if(sourceBkg != null){
				for(int i=0;i<sourceBkg.length;i++) {
					bkgNoString.add(sourceBkg[i].getBkgNo());
				}
			}
			if(targetBkg != null){
				bkgNoString.add(targetBkg.getBkgNo());
				param.put("mst_bkg_no", targetBkg.getBkgNo());
			}else{
				param.put("mst_bkg_no", "");				
			}
			velParam.put("bkg_no_list", bkgNoString);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOcombineBkgQtyDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO .class);
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
     * sourceBkg의 bkg_usa_cstms_file_no를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyNVOFileNoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyNVOFileNoByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
     * Cod에Pod와 Del에 대해 조회
     * @param String codRqstSeq
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<PodDelForCodVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<PodDelForCodVO> searchPodDelForCodSplit(String codRqstSeq,BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PodDelForCodVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("codRqstSeq",codRqstSeq);
				velParam.put("codRqstSeq",codRqstSeq); 
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchPodDelForCodSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PodDelForCodVO .class);
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
     * bkg_qty_dtl 테이블에 Split데이터를 저장
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String cntrTpszCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgQtyDtlForSplit(BkgBlNoVO sourceBkg,BkgBlNoVO targetBkg,String cntrTpszCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sourceBkg != null){
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("cntr_tpsz_cd", cntrTpszCd);
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopyBkgQtyDtlForSplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
    
    /**
	 * cntr 별 reference 정보를 복사한다.
     * @param CntrCopyVO vo
     * @exception DAOException 
     */
    public void copyBkgRefByCntr(CntrCopyVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefByCntrCSQL template = new GeneralBookingReceiptDBDAORefByCntrCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    /**
	 * cntr 별 reference detail 정보를 복사한다.
     * @param CntrCopyVO vo
     * @exception DAOException 
     */
    public void copyBkgRefDtlByCntr(CntrCopyVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            GeneralBookingReceiptDBDAORefDtlByCntrCSQL template = new GeneralBookingReceiptDBDAORefDtlByCntrCSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
            if(updCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * sourceBkg의 bkg_customer를 targetBkg로 복사한다. (ESM_BKG_0648)
     * @param BlCopyInVO blCopyInVo
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyCustByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCopyCustByBlCopyUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg일부 정보를 targetBkg로 복사한다. (ESM_BKG_0648)
     * @param BlCopyInVO blCopyInVo
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBkgByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCopyBkgByBlCopyUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_reference 정보를 targetBkg로 복사한다. (ESM_BKG_0648)
     * @param BlCopyInVO blCopyInVo
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyRefByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = blCopyInVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCopyRefByBlCopyUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 해당 Booking에 속한 Container가 다른 Booking에 속해있는지 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @return			List<String>
	 * @exception 	DAOException
	 */
	public List<String> searchPartialCntrBkgList(String bkgNo) throws DAOException {
		List<String> rtnList = new ArrayList<String>();		 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			velParam.put("bkg_no", bkgNo);
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPartialCntrBkgListRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnList.add(dbRowset.getString("bkg_no"));
			}				

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnList;
	}	
	/**
	 * 해당 Booking에 속한 Container가 속해있는 Booking의 Container를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		List<String> bkgNoList
	 * @return			List<String>
	 * @exception 	DAOException
	 */
	public List<String> searchPartialCntrListByBkgList(List<String> bkgNoList) throws DAOException {
		List<String> rtnList = new ArrayList<String>();		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgNoList != null && bkgNoList.size() > 0) {
				velParam.put("bkg_no", bkgNoList);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPartialCntrListByBkgListRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnList.add(dbRowset.getString("cntr_no"));
			}		

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnList;
	}		
	/**
	 * 해당 Booking에 속한 Container가 속해있는 Booking과 Container의 정보를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		List<String> bkgNoList
	 * @param 		List<String> cntrNoList
	 * @return			DBRowSet
	 * @exception 	DAOException
	 */
	public DBRowSet searchPartialRelatedBkgCntr(List<String> bkgNoList, List<String> cntrNoList) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgNoList != null && bkgNoList.size() > 0) {
				velParam.put("bkg_no", bkgNoList);
			}
			if(cntrNoList != null && cntrNoList.size() > 0) {
				velParam.put("cntr_no", cntrNoList);
			}			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPartialRelatedBkgCntrRSQL(), param, velParam);


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}			
	
	
	/**
	 * bkg_booking에 vvd와 slan_cd를 update한다.
	 * 
	 * @author 		KimByungKyu
	 * @param 		String trnkVvd
	 * @param 		String trnkLaneCd
	 * @param 		String preRlyPortCd
	 * @param 		String pstRlyPortCd
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyTrnkVvdLane(String trnkVvd, String trnkLaneCd, String preRlyPortCd, String pstRlyPortCd, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("trnk_lane_cd", trnkLaneCd);
			param.put("bkg_trunk_vvd", trnkVvd);
			param.put("pre_rly_port_cd", preRlyPortCd);
			param.put("pst_rly_port_cd", pstRlyPortCd);
			param.put("bkg_no", bkgBlNoVO.getBkgNo());			
			param.put("upd_usr_id", account.getUpd_usr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyTrnkVvdLaneUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * bkg_booking 의 o/b route를 update한다.
	 * 
	 * @author 		KimByungKyu
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyOrgRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
 
			param.put("por_cd", partialBkgInfoVO.getPorCd());                 
			param.put("por_nod_cd", partialBkgInfoVO.getPorNodCd());
			param.put("pol_cd", partialBkgInfoVO.getPolCd());
			param.put("pol_nod_cd", partialBkgInfoVO.getPolNodCd());
			param.put("rcv_term_cd", partialBkgInfoVO.getRcvTermCd());
			param.put("mty_pkup_yd_cd", partialBkgInfoVO.getMtyPkupYdCd());
			param.put("full_rtn_yd_cd", partialBkgInfoVO.getFullRtnYdCd());
			param.put("mty_pkup_dt", partialBkgInfoVO.getMtyPkupDt());			
			param.put("org_trns_svc_mod_cd", partialBkgInfoVO.getOrgTrnsSvcModCd());			
			param.put("org_trns_mod_cd", partialBkgInfoVO.getOrgTrnsModCd());			
			param.put("org_sconti_cd", "");			
			param.put("lodg_due_dt", partialBkgInfoVO.getLodgDueDt());			
			param.put("mty_dor_arr_dt", partialBkgInfoVO.getMtyDorArrDt());
			param.put("bkg_no", partialBkgInfoVO.getBkgNo());					
         
			param.put("upd_usr_id", account.getUpd_usr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyOrgRouteForPartialBkgUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * bkg_booking 의 i/b route를 update한다.
	 * @author 		KimByungKyu
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyDestRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{

			param.put("pod_cd", partialBkgInfoVO.getPodCd());                 
			param.put("pod_nod_cd", partialBkgInfoVO.getPodNodCd());
			param.put("del_cd", partialBkgInfoVO.getDelCd());
			param.put("del_nod_cd", partialBkgInfoVO.getDelNodCd());
			param.put("de_term_cd", partialBkgInfoVO.getDeTermCd());
			param.put("ocp_cd", partialBkgInfoVO.getOcpCd());
			param.put("full_pkup_yd_cd", partialBkgInfoVO.getFullPkupYdCd());
			param.put("mty_rtn_yd_cd", partialBkgInfoVO.getMtyRtnYdCd());			
			param.put("dest_trns_svc_mod_cd", partialBkgInfoVO.getDestTrnsSvcModCd());			
			param.put("dest_trns_mod_cd", partialBkgInfoVO.getDestTrnsModCd());			
			param.put("dest_sconti_cd", "");			
			param.put("de_due_dt", partialBkgInfoVO.getDeDueDt());			
			param.put("bkg_no", partialBkgInfoVO.getBkgNo());						                 
			                 
			param.put("upd_usr_id", account.getUpd_usr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyDestRouteForPartialBkgUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}			
	/**
	 * Partial Container의 Bkg 정보를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @return			PartialBkgInfoVO
	 * @exception 	DAOException
	 */	
	@SuppressWarnings("unchecked")
	public PartialBkgInfoVO searchPartialCntrBkgInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PartialBkgInfoVO> list = null;
		PartialBkgInfoVO partialBkgInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPartialCntrBkgInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartialBkgInfoVO .class);
			if(list != null && list.size() > 0){
				partialBkgInfoVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return partialBkgInfoVO;
	}
	
	
	/**
	 * Booking 테이블에서 searchDstSvcRoute 함수 호출관련 변수값 조회
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgForDstSvcRouteVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgForDstSvcRouteVO searchBkgForDstSvcRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgForDstSvcRouteVO> list = null;
		BkgForDstSvcRouteVO bkgForDstSvcRouteVO=null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchBkgForDstSvcRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgForDstSvcRouteVO .class);
			if(list != null && list.size() > 0){
				bkgForDstSvcRouteVO = list.get(0);
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgForDstSvcRouteVO;
	}
	
	/**
	 * Booking 테이블에 DEST_TRNS_SVC_MOD_CD필드값을 수정한다.
	 * @param String dstSvcRouteCd 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgBlNoVO codBkg
	 * @param String codRqstSeq
	 * @exception DAOException
	 */
	public void modifyDstSvcRoute(String dstSvcRouteCd, BkgBlNoVO bkgBlNoVO, BkgBlNoVO codBkg, String codRqstSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			 
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("dstSvcRouteCd",dstSvcRouteCd);
				param.put("cod_bkg_no", codBkg.getBkgNo());
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("dstSvcRouteCd",dstSvcRouteCd);
				velParam.put("cod_bkg_no", codBkg.getBkgNo());
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyDstSvcRouteUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_BOOKING/BKG_BKG_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createBkgCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateBkgCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_BKG_HIS를 BKG_BOOKING 에 update함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void modifyBkgCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgCAUSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd에 따라, BKG_CUSTOMER/BKG_CUST_HIS를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeCustCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveCustCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_QTY_DTL/BKG_QTY_DTL_HIS를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeQtyDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveQtyDtlCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_QUANTITY/BKG_QTY_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeQtyCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveQtyCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_REFERENCE/BKG_REF_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeRefCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveRefCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_REF_DTL/BKG_REF_DTL_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeRefDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveRefDtlCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_VVD/BKG_VVD_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeVvdCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveVvdCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd에 따라, BKG_CNTC_PSON/BKG_CNTC_PSON_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeCntcPsonCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveCntcPsonCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_USA_CSTMS_FILE_NO/BKG_USA_CSTMS_FILE_NO_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeNVOFilerCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveNVOFilerCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * copyTypeCd에 따라, BKG_BOOKING/BKG_BKG_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeBkgCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_CUSTOMER/BKG_CUST_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createCustCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateCustCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_QUANTITY/BKG_QTY_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createQtyCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateQtyCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * copyTypeCd 에 따라, BKG_QTY_DTL/BKG_QTY_DTL_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createQtyDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateQtyDtlCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_REFERENCE/BKG_REF_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createRefCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateRefCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * copyTypeCd 에 따라, BKG_REF_DTL/BKG_REF_DTL_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createRefDtlCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateRefDtlCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_VVD/BKG_VVD_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createVvdCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateVvdCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_CNTC_PSON/BKG_CNTC_PSON_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createCntcPsonCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateCntcPsonCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_USA_CSTMS_FILE_NO/BKG_USA_CSTMS_FILE_NO_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createNVOFileNoCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCreateNVOFileNoCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Copy를 위해 Booking 정보를 조회한다.(ESM_BKG_0077)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		BkgForCopyVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgForCopyVO searchBkgForCopy(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgForCopyVO> list = null;
		BkgForCopyVO bkgForCopyVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgForCopyVO .class);
			if(list != null && list.size() > 0){
				bkgForCopyVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgForCopyVO;
	}
	 
		/**
		 * Manual Copy를 위해 Booking 상태 정보를 조회한다.(ESM_BKG_0077)<br>
		 * 
		 * @author 		Moon Hwan Choi
		 * @param 		String bkgNo
		 * @param 		String orglBkgNo
		 * @return 		ManualBookingCopyVO manualBookingCopyVO
		 * @exception 	DAOException
		 */
		 @SuppressWarnings("unchecked")
		public ManualBookingCopyVO searchManualBookingStatus(String bkgNo, String orglBkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<ManualBookingCopyVO> list = null;
			ManualBookingCopyVO manualBookingCopyVO = new ManualBookingCopyVO();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(orglBkgNo != null && bkgNo != null){
					param.put("orgl_bkg_no", orglBkgNo);
					param.put("bkg_no", bkgNo);
					
					velParam.put("orgl_bkg_no", orglBkgNo);
					velParam.put("bkg_no", bkgNo);
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchManualBookingStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualBookingCopyVO .class);
				if(list != null && list.size() > 0){
					manualBookingCopyVO = list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return manualBookingCopyVO;
		}	

	/**
	 * 다른 Office의 Booking을 copy할 수 없음.(ESM_BKG_0077)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchOfcVsBkgOfc(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		boolean notCopy = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("bkg_ofc_cd", account.getOfc_cd());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchOfcVsBkgOfcRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					notCopy = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return notCopy;
	}	

	/**
	 * 다른 대륙의 Booking을 생성할 수 없음.(ESM_BKG_0079_01)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String porCd
	 * @param 		SignOnUserAccount account
	 * @return 		boolean
	 * @exception 	DAOException
	 */
	public boolean searchOfcVsPorConti(String porCd, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		boolean notCreate = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("por_cd", porCd);
			param.put("ofc_cd", account.getOfc_cd());
			param.put("usr_id", account.getUsr_id());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchOfcVsPorContiRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					notCreate = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return notCreate;
	}		

	/**
	 * 화면에서 받은 정보를 바탕으로 Copy할 정보를 조회한다.(ESM_BKG_0077)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgForCopyVO bkgForCopyVO
	 * @param 		SignOnUserAccount account
	 * @return 		BkgBookingVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgBookingVO searchBkgBookingForCopy(BkgForCopyVO bkgForCopyVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;
		BkgBookingVO bkgBookingVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgForCopyVO != null){
				Map<String, String> mapVO = bkgForCopyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("ofc_cd", account.getOfc_cd());
			param.put("usr_id", account.getUsr_id());
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgBookingForCopyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO .class);
			if(list != null && list.size() > 0){
				bkgBookingVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBookingVO;
	}	

	/**
	 * bkg_quantity 테이블에서 cntr_tpsz_cd, op_cntr_qty를 복사를 위해 조회한다.(ESM_BKG_0077)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgForCopyVO bkgForCopyVO
	 * @return 		List<BkgQuantityVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchBkgQuantityForCopy(BkgForCopyVO bkgForCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgForCopyVO != null){
				Map<String, String> mapVO = bkgForCopyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgQuantityForCopyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO .class);
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
	 * bkg_qty_dtl 테이블에서 cntr_tpsz_cd, op_cntr_qty, rcv_term, de_term를 복사를 위해 조회한다.(ESM_BKG_0077)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgForCopyVO bkgForCopyVO
	 * @return 		List<BkgQtyDtlVO>
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgQtyDtlVO> searchBkgQtyDtlForCopy(BkgForCopyVO bkgForCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgForCopyVO != null){
				Map<String, String> mapVO = bkgForCopyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgQtyDtlForCopyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyDtlVO .class);
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
	 * Empty Split 가능코드 조회<br>
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchMtyRepoBkgSts(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMtyRepoBkgStsRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("mty_split_aval_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}	 

	/**
	 *  Empty Split Booking 정보를 저장한다.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		MtyBookingVO mtyBookingVO
	 * @param 		String newBkgNo
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void addNewSplitMtyRepoBkg(BkgBlNoVO bkgBlNoVO, MtyBookingVO mtyBookingVO, String newBkgNo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(mtyBookingVO != null){
				Map<String, String> mapVO = mtyBookingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("new_bkg_no", newBkgNo);
			param.put("new_bl_no", newBkgNo);
			param.put("usr_id", account.getUsr_id());
		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddNewSplitMtyRepoBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  원본 Booking Split Flag 수정<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		String bkgNo
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyMtyRepoMstBkg(String bkgNo, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("usr_id", account.getUsr_id());		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyMtyRepoMstBkgUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  원본 Booking Cancel<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void cancelMtyBkg(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("usr_id", account.getUsr_id());		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOCancelMtyBkgUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		

	/**
	 *  Container 정보로 BKG Quantity 정보 저장.<br>
	 *  
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void addMtyBkgQtyFromCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("usr_id", account.getUsr_id());		
		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddMtyBkgQtyFromCntrCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *  VSK에서 PORT에 대한 clpt_ind_seq나 yard가 변경되었을 때 bkg_vvd에도 적용 <br>
	 * @author 	RyuDaeyoung
	 * @param 	VslSkdCngUpdateVO vslSkdCngUpdateVO
	 * @param 	SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyPolForVslSkdCng(VslSkdCngUpdateVO vslSkdCngUpdateVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vvd", vslSkdCngUpdateVO.getVvd());
			param.put("port_cd", vslSkdCngUpdateVO.getPortCd());
			param.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			param.put("new_clpt_ind_seq", vslSkdCngUpdateVO.getNewClptIndSeq());
			param.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			param.put("new_yd_cd", vslSkdCngUpdateVO.getNewYdCd());
			if(account==null){
				param.put("upd_usr_id", "ESVCUSER");
			} else {
				param.put("upd_usr_id", account.getUsr_id());
			}

			velParam.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			velParam.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
					
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 *  VSK에서 PORT에 대한 clpt_ind_seq나 yard가 변경되었을 때 bkg_vvd에도 적용 <br>
	 * @author 	RyuDaeyoung
	 * @param 	VslSkdCngUpdateVO vslSkdCngUpdateVO
	 * @param 	SignOnUserAccount account
	 * @exception 	DAOException
	 */	
	public void modifyPodForVslSkdCng(VslSkdCngUpdateVO vslSkdCngUpdateVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vvd", vslSkdCngUpdateVO.getVvd());
			param.put("port_cd", vslSkdCngUpdateVO.getPortCd());
			param.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			param.put("new_clpt_ind_seq", vslSkdCngUpdateVO.getNewClptIndSeq());
			param.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			param.put("new_yd_cd", vslSkdCngUpdateVO.getNewYdCd());
			if(account==null){
				param.put("upd_usr_id", "ESVCUSER");
			} else {
				param.put("upd_usr_id", account.getUsr_id());
			}

			velParam.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			velParam.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyPodForVslSkdCngUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 *  VSK에서 PORT에 대한 clpt_ind_seq나 yard가 변경되었을 때 bkg_booking에도 적용 <br>
	 * @author 	RyuDaeyoung
	 * @param 	VslSkdCngUpdateVO vslSkdCngUpdateVO
	 * @param 	SignOnUserAccount account
	 * @exception 	DAOException
	 */	
	public void modifyBkgRouteForVslSkdCng(VslSkdCngUpdateVO vslSkdCngUpdateVO, SignOnUserAccount account) throws DAOException {
		// //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vvd", vslSkdCngUpdateVO.getVvd());
			param.put("port_cd", vslSkdCngUpdateVO.getPortCd());
			param.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			param.put("new_clpt_ind_seq", vslSkdCngUpdateVO.getNewClptIndSeq());
			param.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			param.put("new_yd_cd", vslSkdCngUpdateVO.getNewYdCd());
			param.put("bkg_no", vslSkdCngUpdateVO.getBkgNo());
			if(account==null){
				param.put("upd_usr_id", "ESVCUSER");
			} else {
				param.put("upd_usr_id", account.getUsr_id());
			}

			velParam.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			velParam.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	/**
	 *  Bkg Ref로 Split Copy한다. <br>
	 * @author 	RyuDaeyoung
	 * @param 	BkgBlNoVO sourceBkg
	 * @param 	BkgBlNoVO targetBkg
	 * @param 	SignOnUserAccount account
	 * @exception 	DAOException
	 */		
	public void copySplitCopyRefByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException  {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcopySplitCopyRefByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}		

	/**
	 * Booking의 MY_FWRD_CD, MY_FWRD_VSL_DESC 정보 수정.(ESM_BKG_0616)<br>
	 *
	 * @author 	Jun Yong Jin
	 * @param 	FwrdRefVvdVO fwrdRefVvdVO
	*  @param 	SignOnUserAccount account	
	 * @exception 	DAOException
	 */
	public void modifyMyFwrdRefVvd(FwrdRefVvdVO fwrdRefVvdVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(fwrdRefVvdVO != null){
				Map<String, String> mapVO = fwrdRefVvdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyMyFwrdRefVvdUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * prd의 정보로 bkg의 route를 update한다.<br>
	 *
	 * @author 	Ryu Dae young 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   String cuModeCd
	 * @exception 	DAOException
	 */
	public void modifyBkgRouteFromPrd(BkgBlNoVO bkgBlNoVO, String cuModeCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("cu_mode", cuModeCd);
				velParam.putAll(mapVO);
				velParam.put("cu_mode", cuModeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		
	}
	
	/**
	 * bkg의 BLCK_STWG_CD를 update한다.<br>
	 *
	 * @author 	jung in sun
	 * @param 	BkgBookingInfoVO bkgBookingInfoVO
	 * @exception 	DAOException
	 */	
	public void modifyBookingBlckStwgCd(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBookingInfoVO != null){
				Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOBookingBlckStwgCdUSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * prd의 정보로 bkg의 route를 add한다.<br>
	 *
	 * @author 	Ryu Dae young 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String bkgTrunkVvd
	 * @param 	SignOnUserAccount account
	 * @exception 	DAOException
	 */	
	public void addBkgVvdFromPrd(BkgBlNoVO bkgBlNoVO, String bkgTrunkVvd,
			SignOnUserAccount account)  throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("tvvd", bkgTrunkVvd);
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOaddBkgVvdFromPrdCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		
	}

	/**
	 * split, combine 후 변경된 data로 bkg_booking의 spcl flag를 수정함<br>
	 * @author		Ryu Dae Young
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifySpclFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException {
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
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifySpclFlagUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
    /**
     *  Request Via Code를 수정한다.<br>
     *
	 * @author 		KimByungKyu
     * @param 		XterRqstNoVO xterRqstNoVO
     * @param 		String saveModeCd
     * @param		String autoNotification
     * @param 		String xterRqstViaCd
     * @param 		SignOnUserAccount account
     * @exception 	DAOException
     */
    public void modifyXterRqstInfo(XterRqstNoVO xterRqstNoVO , String saveModeCd , String autoNotification, String xterRqstViaCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();    	
        try {
			if(xterRqstNoVO != null){
				Map<String, String> mapVO = xterRqstNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("doc_tp_cd", xterRqstNoVO.getDocTpCd());
				velParam.put("doc_tp_cd", xterRqstNoVO.getDocTpCd());
			}else{
				param.put("doc_tp_cd", "");
				velParam.put("doc_tp_cd", "");				
			}
			param.put("auto_notification", autoNotification);
			param.put("xter_rqst_via_cd", xterRqstViaCd);
			param.put("save_mode_cd", saveModeCd);
			
			velParam.put("auto_notification", autoNotification);
			velParam.put("xter_rqst_via_cd", xterRqstViaCd);
			velParam.put("save_mode_cd", saveModeCd);	
			
			param.put("upd_usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyXterRqstInfoUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * bkg_vvd테이블를 갱신한다.<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param String oldVvd
     * @param String newVvd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyBkgVvdForAssign(BkgBlNoVO bkgBlNoVO, String oldVvd, String newVvd,
			SignOnUserAccount account)  throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("old_vvd", oldVvd);
			param.put("new_vvd", newVvd);
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgVvdForAssignUSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		
	}
    
    /**
     * booking 테이블에 T.VVD조회<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @exception DAOException
     */
    public String searchTrunkVvdByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sRtn = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchTrunkVvdByBkgRSQL(), param, velParam);
			if(dbRowset.next()){
				sRtn = dbRowset.getString("TVVD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sRtn;
	}
    
    /**
     * Specail Cgo 존재여부 조회<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return boolean
     * @exception DAOException
     */
    public boolean searchHasSpcl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean bRtn = false;
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

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchHasSpclRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("cnt") > 0){
					bRtn = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return bRtn;
	}

	/**
	 * 해당 snap_his_seq의 bkg_vvd_his의 row들을 지운다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeBkgVvdHis(BkgBlNoVO bkgBlNoVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("corr_no",bkgBlNoVO.getCaNo());
			velParam.put("corr_no",bkgBlNoVO.getCaNo());
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOremoveBkgVvdHisDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Remove SQL");
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * bkg_cod_vvd에서 bkg_vvd_his로 복사한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgVvdHisFromCod(BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("corr_no",bkgBlNoVO.getCaNo());
			velParam.put("corr_no",bkgBlNoVO.getCaNo());
			param.put("cod_rqst_seq",codRqstSeq);
			velParam.put("cod_rqst_seq",codRqstSeq);
			param.put("usr_id",account.getUsr_id());
			velParam.put("usr_id",account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOaddBkgVvdHisFromCodCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Insert SQL");
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	/**
	 * bkg_codt에서 bkg_bkg_his로 복사한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBkgBkgHisFromCod(BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("corr_no",bkgBlNoVO.getCaNo());
			velParam.put("corr_no",bkgBlNoVO.getCaNo());
			param.put("cod_rqst_seq",codRqstSeq);
			velParam.put("cod_rqst_seq",codRqstSeq);
			param.put("usr_id",account.getUsr_id());
			velParam.put("usr_id",account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgBkgHisUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	/**
	 * prd_prd_ctl_mst에서 trunk Vvd를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return PrdRouteVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PrdRouteVO searchBkgRouteFromPrd(BkgBlNoVO bkgBlNoVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdRouteVO> list = null;
		PrdRouteVO prdRouteVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchTrunkVvdFromPrdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrdRouteVO .class);
			if(list != null && list.size() > 0){
				prdRouteVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return prdRouteVO;		
	}
	
	/**
	 * combine 후 bkg_booking의 term과 status를 정리한다.
	 * @param BkgBlNoVO targetBkg
	 * @param BkgBlNoVO[] sourceBkg
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBkgBookingAfterCombine(BkgBlNoVO targetBkg, BkgBlNoVO[] sourceBkg, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> bkgNoList = new ArrayList<String>(); 
//	velParam.put("mode_flag",sFlag);
//	if(cntrTpSzList != null && cntrTpSzList.size() > 0) {
//		velParam.put("cntr_tpsz_cd", cntrTpSzList);
//	}
//	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//	int insCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveBkgQuantityDSQL(), param,velParam);
	
		try{
			Map<String, String> mapVO = targetBkg.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("mst_bkg_no", targetBkg.getBkgNo());
			bkgNoList.add(targetBkg.getBkgNo());
			for(int i=0;i<sourceBkg.length;i++){
				bkgNoList.add(sourceBkg[i].getBkgNo());
			}
			velParam.put("bkg_no", bkgNoList);
			param.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAObkgmodifyBkgBookingAfterCombineUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBlIssRSQL(), param, velParam);
			if(dbRowset.next()){
				blIss = dbRowset.getString("OBL_RLSE_FLG");
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
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String ovrVoidSltQty
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBbVoidQty (String bkgNo, String ovrVoidSltQty, String caFlg) throws DAOException {
		
		//DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		

			param.put("bkg_no", bkgNo); 
			param.put("ovr_void_slt_qty", ovrVoidSltQty); 
			velParam.put("ca_flg", caFlg);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOBbVoidQtyUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);	    	
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	  }

	/**
	 * UI-BKG-1054 Customer Validation을 통해 수정된 고객 정보들을 update 한다.<br>
	 * @author Park Mangeon
	 * @param List<CustCdEvaluationVO> custCdEvaluations
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public void modifyCustCdValInfo (List<CustCdEvaluationVO> custCdEvaluations) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			// execute batch는 velocity가 필요없다.
			insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyCustCdValInfoUSQL(), custCdEvaluations,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
	/**
	 * [672-2] Customer 정보 수정한다.<br>
	 * «» modifyArrNtcChgDpFlg ( [in] bkgNo : String , [in] custTpCd : String , [in] chgDpFlg : String )
	 * @param ArrNtcCustListVO arrNtcCustListVO
	 * @return int
	 * @exception DAOException
	 */
	
	public int  modifyArrNtcChgDpFlg (ArrNtcCustListVO arrNtcCustListVO) throws DAOException {
		//query parameter
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Map<String, String> mapVO = mrnRtnYdVO.getColumnValues();
			
			Map<String, String> mapVO = new HashMap<String,String>();
			
			mapVO.put("bkg_no",arrNtcCustListVO.getBkgNo());
			mapVO.put("chg_dp_flg",arrNtcCustListVO.getChgDpFlg());
			mapVO.put("bkg_cust_tp_cd",arrNtcCustListVO.getBkgCustTpCd());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyArrNtcChgDpFlgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	
	
	/**
	 * UI-BKG-1054 Customer Validation을 통해 수정된 고객 정보를 update 한다.<br>
	 * @author Park Mangeon
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @param String usrId
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public void removeCustCdValInfo (String bkgNo, String bkgCustTpCd, String usrId ) throws DAOException{
		//query parameter
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String,String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_cust_tp_cd",bkgCustTpCd);
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOremoveCustCdValInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
	
	
	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * Booking Customer와 MDM정보를 비교하여 일치하는 정보에 대하여 match되었다고 수정한다.<br>
	 * @param ArrNtcSearchVO arrNtcSearch 검색조회 조건
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public void modifyBkgCustValInfo(ArrNtcSearchVO arrNtcSearch) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			Map<String, String> mapVO = arrNtcSearch.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyBkgCustValInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BL Copy &amp; Customer Info Update시<br>
	 * Booking Customer의 정보중 Code Validation관련 정보를 삭제한다.<br>
	 * Outbound 고객 코드정보를 보관정보에 수정 저장한다 ORG_<br>
	 * Validation을 위한 VAL_CUST_NM, VAL_FAX_NO등을 저장한다.<br>
	 * @author Park Mangeon
	 * @param bkgNo
	 * @throws DAOException
	 */
	public void cancelCustCdVal(String bkgNo) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			

			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOcancelCustCdValUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Inbound - UI-BKG-0941 - Customer Code Error Report Confirm<br>
	 * Code Validation결과를 재평가 한다.<br>
	 * @author Park Mangeon
	 * @param ArrNtcCustCodeErrListVO[] custCodeErrLists
	 * @throws DAOException
	 */
	public void confirmCustCdErrReport(ArrNtcCustCodeErrListVO[] custCodeErrLists) throws DAOException {
		try {
			List<ArrNtcCustCodeErrListVO> arrNtcCustCodeErrList = new ArrayList<ArrNtcCustCodeErrListVO>();
//			String usrId = custCodeErrLists[0].getUsrId();
			for (int i= 0; i < custCodeErrLists.length; i ++) {
//				custCodeErrLists[i].setUsrId(usrId);
				arrNtcCustCodeErrList.add(custCodeErrLists[i]);
			}

			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralBookingReceiptDBDAOConfirmCustCdErrReportUSQL(), arrNtcCustCodeErrList ,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
     * ocean route Validation<br>
     * 변경하려는 route가 ocean route로 등록되어 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param 		PrdMainInfoVO prdMainInfoVO
	 * @return 		ValidateOceanRouteVO 
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	public ValidateOceanRouteVO validateOceanRoute(PrdMainInfoVO prdMainInfoVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ValidateOceanRouteVO> list = null;
		ValidateOceanRouteVO validateOceanRouteVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(prdMainInfoVO != null){
				Map<String, String> mapVO = prdMainInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new generalBookingReceiptDBDAOvalidateOceanRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ValidateOceanRouteVO .class);
			if(list != null && list.size() > 0){
				validateOceanRouteVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return validateOceanRouteVO;
	}
	
	 /**
	  * cargo closing time을 계산하여 넣는다.<br>
 	  * @param BkgBlNoVO bkgBlNoVO
	  * @param String fromDt
	  * @param String toDt
	  * @param SignOnUserAccount account
	  * @exception DAOException
	  */
	public void modifyCargoClosingTimeByReplan(BkgBlNoVO bkgBlNoVO, String fromDt, String toDt, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				param.put("from_dt", fromDt);
				param.put("to_dt", toDt);
				param.put("usr_id", account.getUsr_id());
				velParam.putAll(mapVO);				
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
	    }
		
	}

   /**
     * VVD ASSIGN시 OOP CODE를 UPDATE한다.<br>
     * 
     * @author Ryu DaeYoung     
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  OldNewVvdVO oldNewVvdVO
     * @param  SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyNewVvdOopCd(BkgBlNoVO bkgBlNoVO, OldNewVvdVO oldNewVvdVO, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			param.put("oop_cd", oldNewVvdVO.getOopCd());
			param.put("vvd", oldNewVvdVO.getNewvvd());
			param.put("usr_id", account.getUsr_id());
			velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOModityNewVvdOopCdUSQL(), param, velParam);
            
        } catch(SQLException se) {
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
        } catch(Exception ex) {
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
        }
	}
    /**
     * combine시 to_bkg_no를 UPDATE한다.<br>
     * 
     * @author Ryu DaeYoung     
     * @param  BkgBlNoVO targetBkg
     * @param  BkgBlNoVO sourceBkg
     * @param  String hitchmentYn
     * @param  SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyToBkgNo(BkgBlNoVO targetBkg, BkgBlNoVO sourceBkg, String hitchmentYn, SignOnUserAccount account) throws DAOException  {
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try {
	    	Map<String, String> mapVO = sourceBkg.getColumnValues();
			param.putAll(mapVO);
			param.put("to_bkg_no", targetBkg.getBkgNo());
			param.put("usr_id", account.getUsr_id());
			param.put("hitchmentYn" , hitchmentYn);
			velParam.putAll(mapVO);
	
	        SQLExecuter sqlExe = new SQLExecuter("");
	        sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOModifyToBkgNoUSQL(), param, velParam);
	        
	    } catch(SQLException ex) {
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    } catch(Exception ex) {
	    	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }	
	}
	/**
     * 입력한 vvd중 trunk vvd를 coa 항차 기준으로 계산한다.<br>
     * @author Ryu Daeyoung
     * @param PolPodVvdVO[] polPodVvdVOs
     * @return String
	 * @exception EventException
	 */
	public String searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs) throws DAOException {
		DBRowSet dbRowset = null;
		String trnkSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(polPodVvdVOs != null){
				for(int i=0;i<polPodVvdVOs.length;i++){
					param.put("n"+(i+1)+"_pol", polPodVvdVOs[i].getPolCd());
					param.put("n"+(i+1)+"_pod", polPodVvdVOs[i].getPodCd());
					param.put("n"+(i+1)+"_vvd", polPodVvdVOs[i].getBkgVvdCd());
					velParam.put("n"+(i+1)+"_pol", polPodVvdVOs[i].getPolCd());
					velParam.put("n"+(i+1)+"_pod", polPodVvdVOs[i].getPodCd());
					velParam.put("n"+(i+1)+"_vvd", polPodVvdVOs[i].getBkgVvdCd());
				}
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchTrnkVvdByRlaneRSQL(), param, velParam);
			if(dbRowset.next()){
				trnkSeq = dbRowset.getString("TRUNK_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return trnkSeq;
	}
	
	/**
     * 입력한 pctl no로 해당 route의 bdr여부를 조회한다..<br>
     * @author Ryu Daeyoung
     * @param pctlNo
     * @return String
	 * @exception EventException
	 */
	public String searchBdrLog(String pctlNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bdrFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBdrLogRSQL(), param, velParam);
			if(dbRowset.next()){
				bdrFlg= dbRowset.getString("BDR_VVD");
			} else {
				bdrFlg = null;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bdrFlg;
	}		 

	/**
	 *  ANCS, ROCS에서 저장된 Inbound Notify 정보를 수정한다.(ESM_BKG_0045, 0442)<br>
	 *
	 * @author 		Jang Jiyoung
	 * @param 		BkgCustomerVO bkgCustomerVO
	 * @return		int
	 * @exception 	DAOException
	 */
	public int modifyIbCustNmAddr(BkgCustomerVO bkgCustomerVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		try{
			if(bkgCustomerVO != null){
				Map<String, String> mapVO = bkgCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyIbCustNmAddrUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * Export Container Terminal Detail 정보 를 수정한다.
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @throws DAOException
	 */
	public void modifyCntrExportTmlGW(ExCntrTransmitCondVO exCntrTransmitCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = exCntrTransmitCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyCntrExportTmlGWUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * china bkg no가 기존에 생성되어 있는지 조회한다.<br>
	 * 
	 * @author		Ryu Daeyoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	DAOException
	 */
	public String searchChnBkgNoExist(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchChnBkgNoExistRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("BKG_NO_USE_FLG");
				
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}	
	
	/**
     * c/a tmp를 지워야하는 지 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchCaTmp(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCaTmpRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("CORR_USR_ID");				
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	/**
	 * Contract Info(ctrt ofc, ctrt srep)를 update한다.
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @throws DAOException
	 */
	public void modifyCtrtInfo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCtrtInfoUSQL(), param, velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * 말레이지아 forwarder code가 정상적인 것이 입력되었는지 조회한다. 
	 * 
	 * @param  FwrdRefVvdVO fwrdRefVvdVO
     * @return String
	 * @throws DAOException
	 */
	public String searchMyFwrdRefCd(FwrdRefVvdVO fwrdRefVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		try{
			param.put("my_fwrd_ref_cd", fwrdRefVvdVO.getMyFwrdRefCd());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMyFwrdRefCdRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("result");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Booking 저장시 오입력한 data를 찾는다
	 * 
	 * @param  BkgBookingInfoVO bkgBookingInfoVO
	 * @param  BookingSaveValidationVO saveValidationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMissingData(BkgBookingInfoVO bkgBookingInfoVO, BookingSaveValidationVO saveValidationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		try{
			Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			mapVO = saveValidationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMissingDataRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("MESSAGE");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * CBF Booking Status 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCBFBS(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrCbf = new String[5];
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("yd_cd", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralBookingReceiptDBDAOsearchCBFBSRSQL(), param, velParam);
			int k = 1;
			if (dbRowset.next()) {
				for (int i = 0; i < 4; i++) {
					arrCbf[i] = dbRowset.getString(k);
					k++;
				}
			}
			if (arrCbf == null) {
				throw new DAOException(new ErrorHandler("OPF00021").getUserMessage());
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrCbf;
	}
	
	/**
	 * Reference Type이 이미 존재하는지 확인한다.
	 * @param String bkgNo
	 * @param String bkgRefTpCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkRefTpCd(String bkgNo, String bkgRefTpCd) throws DAOException{ 
		boolean bRtn = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("bkg_ref_tp_cd", bkgRefTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchRefTpCdRSQL(), param, param);
			if (dbRowset.next()) {
				if( null != dbRowset.getString("BKG_REF_TP_CD") ) {
					bRtn = true;
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
		
		return bRtn;
	}
	
	
	/**delete quantity in case of OP_CNTR_QTY = 0
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeBkgQtyDtlZero(String bkgNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if(bkgNo != null){
				param.put("bkg_no",bkgNo);			
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOremoveBkgQtyDtlZeroDSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());		

		} catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
	
	/**delete quantity in case of OP_CNTR_QTY = 0
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeBkgQtyZero(String bkgNo) throws DAOException {

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if(bkgNo != null){
				param.put("bkg_no",bkgNo);			
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOremoveBkgQtyZeroDSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());		

		} catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	/**
     * 해당 Booking이 DRY Cargo 인지 아닌지를 체크한다.<br>
     * @param String bkgNo
     * @return String
	 * @exception EventException
	 */
	public String checkBkgQtyDtlSplit(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOCheckBkgQtyDtlSplitRSQL(), param, param);
			if (dbRowset.next()) {
				result = dbRowset.getString("SPLIT_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
     * Split 처리 후 BKG QTY DETAIL 정보를 업데이트 한다.<br>
     * @param BkgQuantityVO bkgQuantityVO
     * @param BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyBkgQtyDtl(BkgQuantityVO bkgQuantityVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgQuantityVO.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOModifyBkgQtyDtlUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * SI_FLG 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSiFlg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchSiFlgRSQL(), param, velParam);
			while (dbRowset.next()) {
				result =  dbRowset.getString("SI_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}	
	
	/**
	 * allocation validation을 위해 ETD가 지났는지 확인한다
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkEtdForAloc(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOcheckEtdForAlocRSQL(), param, velParam);
			while (dbRowset.next()) {
				result = true;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}	
	
	/**
	 * Trunk Lane의 Allocation Status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @return AllocStsVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public AllocStsVO searchAllocStsByTrunkLane(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocStsVO> list = null;
		AllocStsVO allocStsVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchAllocStsByTrunkLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocStsVO .class);
			if(list != null && list.size() > 0){
				allocStsVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return allocStsVO;
	}	
	
	/**
	 * Transshipment의 Allocation Status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @return AllocStsVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public AllocStsVO searchAllocStsByTransshipment(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocStsVO> list = null;
		AllocStsVO allocStsVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchAllocStsByTransshipmentRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocStsVO .class);
			if(list != null && list.size() > 0){
				allocStsVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return allocStsVO;
	}	
	
	/**
	 * Equipment의 Allocation Status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @return AllocStsVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public AllocStsVO searchAllocStsByEquipment(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocStsVO> list = null;
		AllocStsVO allocStsVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchAllocStsByEquipmentRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocStsVO .class);
			if(list != null && list.size() > 0){
				allocStsVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return allocStsVO;
	}	
	/**
	 * Commodity의 Allocation Status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @return AllocStsVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public AllocStsVO searchAllocStsByCommodity(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocStsVO> list = null;
		AllocStsVO allocStsVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchAllocStsByCommodityRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocStsVO .class);
			if(list != null && list.size() > 0){
				allocStsVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return allocStsVO;
	}	
	
	/**
	 * Customer Allocation Status를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @return AllocStsVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public AllocStsVO searchAllocStsByCustomer(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AllocStsVO> list = null;
		AllocStsVO allocStsVO = null;
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
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchAllocStsByCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AllocStsVO .class);
			if(list != null && list.size() > 0){
				allocStsVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return allocStsVO;
	}	
	/**
	 * ALOC_STS_CD 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchAlocStsCdByBkgNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchAlocStsCdByBkgNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				result =  dbRowset.getString("ALOC_STS_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}	
	
	/**
	 * Allocation Status를 update한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param AllocStsVO allocStsVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 */
	public int modifyAllocStatus(BkgBlNoVO bkgBlNoVO, AllocStsVO allocStsVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if(allocStsVO != null){
				Map<String, String> mapVO2 = allocStsVO .getColumnValues();
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			param.put("usr_id", account.getUsr_id());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyAllocStatusUSQL(), param,velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			
			return updCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * CUST_REF_NO_CTNT 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String bkgRefTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCustRefNoCtnt(BkgBlNoVO bkgBlNoVO, String bkgRefTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				param.put("bkg_ref_tp_cd", bkgRefTpCd);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCustRefNoCtntRSQL(), param, velParam);
			while (dbRowset.next()) {
				result =  dbRowset.getString("CUST_REF_NO_CTNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}
	
	/**
	 * EXPORT REFERENCES를 조회한다.
	 * @param  ExportReferencesVO exportReferencesVO
	 * @return List
	 * @exception DAOException
	 */
	public List<ExportReferencesVO> searchExportReferencesByBkg(ExportReferencesVO exportReferencesVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExportReferencesVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(exportReferencesVO != null){
				Map<String, String> mapVO = exportReferencesVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchExportReferencesByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExportReferencesVO.class);
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
	 * EXPORT REFERENCES를 조회한다.(BY CNTR)
	 * @param  ExportReferencesVO exportReferencesVO
	 * @return List
	 * @exception DAOException
	 */
	public List<ExportReferencesVO> searchExportReferencesByCntr(ExportReferencesVO exportReferencesVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExportReferencesVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(exportReferencesVO != null){
				Map<String, String> mapVO = exportReferencesVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchExportReferencesByCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExportReferencesVO.class);
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
	 * MRN 건수 를 조회한다.
	 * @param BkgRefDtlVO bkgRefDtlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMrnCnt(BkgRefDtlVO bkgRefDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRefDtlVO != null){
				Map<String, String> mapVO = bkgRefDtlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMrnUcrCntRSQL(), param, velParam);
			while (dbRowset.next()) {
				result =  dbRowset.getString("MRN_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}	
	
	/**
	 * UCR 건수 를 조회한다.
	 * @param BkgRefDtlVO bkgRefDtlVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchUcrCnt(BkgRefDtlVO bkgRefDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgRefDtlVO != null){
				Map<String, String> mapVO = bkgRefDtlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchMrnUcrCntRSQL(), param, velParam);
			while (dbRowset.next()) {
				result =  dbRowset.getString("UCR_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;		
	}		
	
	/**
	 *  roll over 정보를 update
	 * @param BkgRollOvrVO bkgRollOvrVO
	 * @exception DAOException
	 */
    public void modifyBkgRollOvrRsn(BkgRollOvrVO bkgRollOvrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgRollOvrVO != null){
				Map<String, String> mapVO = bkgRollOvrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgRollOvrRsnUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    

    /**
     * bkg의 cntr_no목록과 MRN, UCR의 CNTR_NO을 조회한다. <br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return BkgComboVO[]
     * @throws DAOException
     */
    public List<BkgComboVO> searchContainerMrnUcr(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = new ArrayList<BkgComboVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralBookingReceiptDBDAOSearchContainerMrnUcrRSQL(), param, velParam);
			BkgComboVO bkgComboVO = new BkgComboVO();
			while (dbRowset.next()) {
				bkgComboVO = new BkgComboVO();
				bkgComboVO.setComboCd("CNTRLIST01");
				bkgComboVO.setVal(dbRowset.getString("CNTR_NO"));
				bkgComboVO.setName(dbRowset.getString("CNTR_NO"));
				bkgComboVO.setDesc(dbRowset.getString("CHK"));
				list.add(bkgComboVO);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}    	 
	/**
	 * MRN, UCR NO를 delete한다.<br>
	 * @param  BkgRefDtlVO vo
	 * @exception DAOException
	 */
	public void removeMrnUcr(BkgRefDtlVO vo) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveMrnUcrDSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}    
	
    /**
	 * MRN NO/UCR NO를 insert한다.<br>
	 * 
	 * @param BkgRefDtlVO bkgRefDtlVO
	 * @param SignOnUserAccount account
	 * @throws EventException
     */
    public void addMrnUcrNo(BkgRefDtlVO bkgRefDtlVO, SignOnUserAccount account ) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			Map<String, String> mapVO = bkgRefDtlVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());

			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOAddMrnUcrNoCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");			
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
    
	/**
	 * MRN NO/UCR NO를 update한다.<br>
	 * 
	 * @param BkgRefDtlVO bkgRefDtlVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyMrnUcrNo(BkgRefDtlVO bkgRefDtlVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgRefDtlVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());

			int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyMrnUcrNoUSQL(), param,velParam);

			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}    
	
	/**
	 * VSL_SEQ를 조회한다. -- TRS INTERFACE 용 소스 서버 미반영 소스
	 * @param bkgNo
	 * @param vvdCd
	 * @return List<BkgVvdVO> 
	 * @throws DAOException
	 */
    public List<BkgVvdVO> searchVslSeqList(String bkgNo, String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("vvd_cd", vvdCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("vvd_cd", vvdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchVslSeqListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO .class);
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
	 * eBooking S/I에서 BKG으로 업로드된 Customer Name & Address의 Overlfow 여부를 조회한다.
	 *
	 * @param XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO
	 * @return XterCustOvflwFlgStatusVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public XterCustOvflwFlgStatusVO searchXterCustOvrLenFlgStatus(XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterCustOvflwFlgStatusVO> list = null;
		XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusResultVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(xterCustOvflwFlgStatusVO != null){
				Map<String, String> mapVO = xterCustOvflwFlgStatusVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchXterCustOvrLenFlgStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, XterCustOvflwFlgStatusVO .class);
			if(list != null && list.size() > 0){
				xterCustOvflwFlgStatusResultVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return xterCustOvflwFlgStatusResultVO;
	}
	 
	 	/**
		 * Booking cutomer tab에서 cleared한 customer 정보를 업데이트 한다.
		 *
		 * @param String xterRqstNo 
		 * @param String xterRqstSeq
		 * @param String xterCustTpCd
		 * @param String usrId
		 * @exception DAOException
		 */
		public void modifyXterCustOverFlowStatus(String xterRqstNo, String xterRqstSeq, String xterCustTpCd, String usrId) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;

			try {
				param.put("xter_rqst_no", xterRqstNo);
				param.put("xter_rqst_seq", xterRqstSeq);
				param.put("xter_cust_tp_cd", xterCustTpCd);
				param.put("usr_id", usrId);
				velParam.put("xter_rqst_no", xterRqstNo);
				velParam.put("xter_rqst_seq", xterRqstSeq);
				velParam.put("xter_cust_tp_cd", xterCustTpCd);
				velParam.put("usr_id", usrId);
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOmodifyXterCustOverFlowStatusUSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * 
		 * @param bkgNo
		 * @return
		 * @throws DAOException
		 */
		public List<SearchBkgContainerVO> searchBkgContainerNo(String bkgNo) throws DAOException {
			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
			DBRowSet dbRowSet = null;
			List<SearchBkgContainerVO> searchBkgContainerVOs = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
	        try {
	            param.put("bkg_no", bkgNo);

	            dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgContainerRSQL(), param, velParam);
	            searchBkgContainerVOs = (List)RowSetUtil.rowSetToVOs(dbRowSet, SearchBkgContainerVO .class);
	        } catch(SQLException ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        }
	        return searchBkgContainerVOs;
		 }
		
		/**
		 * 
		 * @param priRpHdrVO
		 * @return
		 * @throws DAOException
		 */
		public PriSpCtrtPtyVO searchBkgCustCntInfo(PriRpHdrVO priRpHdrVO) throws DAOException {
			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
			DBRowSet dbRowSet = null;
			PriSpCtrtPtyVO priSpCtrtPtyVO = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
	        try {
	            param.putAll(priRpHdrVO.getColumnValues());
	            velParam.putAll(priRpHdrVO.getColumnValues());
	            dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchBkgCustCntrInfoRSQL(), param, velParam);
	            List<PriSpCtrtPtyVO> list = (List)RowSetUtil.rowSetToVOs(dbRowSet, PriSpCtrtPtyVO .class);
	            if(list.size() > 0) priSpCtrtPtyVO = list.get(0);
	        } catch(SQLException ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        }
	        return priSpCtrtPtyVO;
		 }
		
		/**
	     * Change booking status 'F' when Reactivate
	     * 
	     * @author      KOUNGIL MOON
	     * @param       String bkgNo
	     * @exception   EventException
	     */
	    public void reactBkgStatus(String bkgNo) throws DAOException {
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	            param.put("bkg_no", bkgNo);
	            velParam.put("bkg_no", bkgNo);

	            SQLExecuter sqlExe = new SQLExecuter("");
				sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOReactBkgStatusUSQL(), param, velParam);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	    }
	    
	    /**
	     * Modify Booking MT pick up information.(ESM_BKG_0079_01) -> modifyBooking<br>
	     * @param bkgBlNoVO
	     * @param usrId
	     * @throws DAOException
	     */
		public void modifybkgMtPickUpYardDate(BkgBlNoVO bkgBlNoVO, String usrId) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{

				if(bkgBlNoVO != null){
					Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
					param.putAll(mapVO);
					param.put("usr_id", usrId);
					velParam.putAll(mapVO);
					velParam.put("usr_id", usrId);
				}
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifybkgMtPickUpYardDateUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		 /**
		 * Chekc Last temp VVD time.
		 * @param String bkgNo
		 * @return String
		 * @throws DAOException
		 */
		public String searchLastVVDHisCreTime(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String result = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocit y parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{

				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOsearchLastVVDHisCreTimeRSQL(), param, velParam);
				while (dbRowset.next()) {
					result =  dbRowset.getString("CRE_DT");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;		
		}
		
		/**
		 * Remove roll over information after CA issue<br>
		 * @param String bkgNo
		 * @param String vvdLstCreDt
		 * @exception DAOException
		 */
		public void removeCARollOvr(String bkgNo, String vvdLstCreDt) throws DAOException {
			Map<String, Object> param    = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {			
				param.put("cre_dt", vvdLstCreDt);
				param.put("bkg_no", bkgNo);
				velParam.put("cre_dt", vvdLstCreDt);
				velParam.put("bkg_no", bkgNo);
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAORemoveCARollOvrDSQL(), param, velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		

		/**
		 * Remove roll over information after CA issue<br>
		 * @param String bkgNo
		 * @param String vvdLstCreDt
		 * @exception DAOException
		 */
		public void modifyCARollOvr(String bkgNo, String vvdLstCreDt) throws DAOException {
			Map<String, Object> param    = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {			
				param.put("cre_dt", vvdLstCreDt);
				param.put("bkg_no", bkgNo);
				velParam.put("cre_dt", vvdLstCreDt);
				velParam.put("bkg_no", bkgNo);
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyCARollOvrUSQL(), param, velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * Check whether Port Cut-off date is updated or not.<br>
		 * 
		 * @author 		Maeda
		 * @param 		BkgClzTmVO bkgClzTmVO
		 * @return 		String
		 * @exception 	DAOException
		 */
		public String searchPortCutOffChange(BkgClzTmVO bkgClzTmVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = "Y";
			try{
				if(bkgClzTmVO != null){
					Map<String, String> mapVO = bkgClzTmVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchPortCutOffRSQL(), param, velParam);
				if(dbRowset.next()){
					rtnValue = "N";
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return rtnValue;
		}

		/**
		 * Keep Cut-off dates before update.<br>
		 * 
		 * @author 		Maeda
		 * @param 		String bkgNo
		 * @return 		List<SearchCutOffDateVO>
		 * @exception 	DAOException
		 */
		public List<SearchCutOffDateVO> searchCutOffDate(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchCutOffDateVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("bkg_no", bkgNo);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCutOffDateRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCutOffDateVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
		          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
		          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
			}
			return list;
		}
		
		/**
		 * Check whether Cut-off date is updated or not.<br>
		 * 
		 * @author 		Maeda
		 * @param 		SearchCutOffDateVO cutOffDateVO
		 * @return 		String
		 * @exception 	DAOException
		 */
		public String searchCutOffDateChange(SearchCutOffDateVO cutOffDateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = "";
			try{
				if(cutOffDateVO != null){
					Map<String, String> mapVO = cutOffDateVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCutOffDateChangeRSQL(), param, velParam);
				if(dbRowset.next()){
					rtnValue = dbRowset.getString("TRO_CD");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
		          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
		          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
			}
			return rtnValue;
		}
		
		/**
	     * Booking에 container 정보가 변경되었을때 BKG_REFERENCE 중에 UCR 이 존재하는지 체크함.<br>
	     * @param String bkgNo
	     * @return String
		 * @exception EventException
		 */
		public String checkUcrNo(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String result = null;
			Map<String, Object> param = new HashMap<String, Object>();
			try {
				param.put("bkg_no", bkgNo);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOCheckUcrNoByBkgRSQL(), param, param);
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
		/**
		 * Bkg에 해당하는 BKG_REFERENCE 중에 UCR 의 cntr_no를 업데이트함.<br>
		 * 
		 * @param BkgRefDtlVO bkgRefDtlVO
		 * @param SignOnUserAccount account
		 * @throws EventException
		 */
		public void modifyCntrNoUCR(BkgRefDtlVO bkgRefDtlVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = bkgRefDtlVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());

				int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCntrUCRByBkgUSQL(), param,velParam);

				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");			
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		} 		
	
		
		/**
		 * Bkg에 해당하는 BKG_REFERENCE 중에 UCR 의 cntr_no를 업데이트함.<br>
		 * 
		 * @param BkgRefDtlVO bkgRefDtlVO
		 * @param String usrId
		 * @throws EventException
		 */
		public void modifyCntrNoUcrByMvmt(BkgRefDtlVO bkgRefDtlVO, String usrId) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = bkgRefDtlVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usrId);

				int updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCntrUCRByBkgUSQL(), param,velParam);

				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");			
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
	     * Booking에 container 정보가 변경되었을때 BKG QTY 가 1개로 UCR 과 맵핑 가능한지 체크함.<br>
	     * @param String bkgNo
	     * @return String
		 * @exception EventException
		 */
		public String searchQtyForUcrMap(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String result = null;
			Map<String, Object> param = new HashMap<String, Object>();
			try {
				param.put("bkg_no", bkgNo);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchQtyForUcrMapRSQL(), param, param);
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
		/**
		 * 
		 * @param bkgBookingInfoVO
		 * @return
		 * @throws DAOException
		 */
		public String toyotaBlNoCheck(BkgBookingInfoVO bkgBookingInfoVO, BlCustomerInfoVO custVo) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String result = null;
			try {
				Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.putAll(custVo.getColumnValues());
				velParam.putAll(custVo.getColumnValues());
				if(param.get("rfa_no") != null &&  param.get("rfa_no").toString().indexOf("DUM") > -1){
					param.put("rfa_no", "DUM");
				}
				if(param.get("sc_no") != null &&  param.get("sc_no").toString().indexOf("DUM") > -1){
					param.put("sc_no", "DUM");
				}
				if(param.get("taa_no") != null &&  param.get("taa_no").toString().indexOf("DUM") > -1){
					param.put("taa_no", "DUM");
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOToyotaBlNoCheckRSQL(), param, param);
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
		/**
		 * 
		 * @param bkgDocProcSkdVO
		 * @throws DAOException
		 */
		public void addBkgDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO) throws DAOException {
	    	 // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	            Map<String, String> mapVO = bkgDocProcSkdVO.getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
	            int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOaddBkgDocProcSkdCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        } catch(SQLException ex) {
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	    }
		
		/**
	     * CNTR VL Flag 조회
	     *
	     * @author KimTaeKyoung
	     * @param String bkgNo
	     * @return String
	     * @exception DAOException
	     */
	    public String searchVlFlg(String bkgNo) throws DAOException {
	        DBRowSet dbRowset = null;
	        String vlFlg = "";
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        // velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {
	            Map<String, String> mapVO = new HashMap<String, String>();
	            mapVO.put("bkg_no", bkgNo);
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            GeneralBookingReceiptDBDAOSearchVlFlgRSQL template = new GeneralBookingReceiptDBDAOSearchVlFlgRSQL();
	            dbRowset = sqlExe.executeQuery(template, param, velParam);
	            if(dbRowset.next()){
	            	vlFlg = dbRowset.getString(1);
	            }else{
	            	vlFlg ="N";
	            }
	        } catch(SQLException ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(),ex);
	            throw new DAOException(ex.getMessage(), ex);
	        }
	        return vlFlg;
	    }   
	    
		/**
		 * BKG_INV_TAX_IF에 데이터 생성<br>
		 * 
		 * @param BkgChgRateVO bkgChgRateVO
		 * @param SignOnUserAccount account
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
	    public void addBkgInvTaxIF(BkgChgRateVO bkgChgRateVO, SignOnUserAccount account) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				Map<String, String> mapVO = bkgChgRateVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				velParam.put("cre_usr_id", account.getUsr_id());
				velParam.put("upd_usr_id", account.getUsr_id());
				
				sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingDBDAOAddBKgInvTaxIFCSQL(), param, velParam);
			} catch (SQLException ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				//log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * Modify vgm information. <br>
		 * 
		 * @param BkgVgmWgtVO bkgVgmWgtVO
		 * @param SignOnUserAccount account
		 * @throws DAOException
		 */
		public void modifyBkgVgmWgt(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws DAOException {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
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
				int updCnt = sqlExe.executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOmodifybkgVgmWgtUSQL(), param, velParam);
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
		 *  Check Out를 수정한다.<br>
		 *  
		 * @author 		Park Young Jin
		 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void modifyCheckOutBooking(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(repoBkgForUpdateVO != null){
					String strBkgNo = "";
					String FullCntrNo = "";
					String arrCntrNo = "";
					RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
					for(int i = 0 ; i < repoCntrVOs.length ; i++){
						FullCntrNo = repoCntrVOs[i].getFullCntrNo();
						if(i ==0) {
							arrCntrNo = FullCntrNo;
						}else{
							arrCntrNo = arrCntrNo + "," + FullCntrNo;
						}
					}
					
					List<String> arrFullCntrNo      = null;
					arrFullCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(arrCntrNo,",","|"));
			           
					strBkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
					
					param.put("bkg_no" , strBkgNo);
					param.put("cntr_cd", arrFullCntrNo);					
					velParam.put("bkg_no" , strBkgNo);
					velParam.put("cntr_cd", arrFullCntrNo);
				}	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCheckOutUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}	
		
		
		/**
		 *  Check In를 수정한다.<br>
		 *  
		 * @author 		Park Young Jin
		 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void modifyCheckInBooking(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(repoBkgForUpdateVO != null){
					String strBkgNo = "";
					String FullCntrNo = "";
					String arrCntrNo = "";
					RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
					for(int i = 0 ; i < repoCntrVOs.length ; i++){
						FullCntrNo = repoCntrVOs[i].getFullCntrNo();
						if(i ==0) {
							arrCntrNo = FullCntrNo;
						}else{
							arrCntrNo = arrCntrNo + "," + FullCntrNo;
						}
					}
					
					List<String> arrFullCntrNo      = null;
					arrFullCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(arrCntrNo,",","|"));
			           
					strBkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
					
					param.put("bkg_no" , strBkgNo);
					param.put("cntr_cd", arrFullCntrNo);					
					velParam.put("bkg_no" , strBkgNo);
					velParam.put("cntr_cd", arrFullCntrNo);
				}	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyCheckInUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		
		/**
		 *  Movement 내 Booking No를 Update한다..<br>
		 *  
		 * @author 		Park Young Jin
		 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void modifyMTBookingNoToMovement(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(repoBkgForUpdateVO != null){
					String strBkgNo = "";
					String FullCntrNo = "";
					String arrCntrNo = "";
					RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
					for(int i = 0 ; i < repoCntrVOs.length ; i++){
						FullCntrNo = repoCntrVOs[i].getFullCntrNo();
						if(i ==0) {
							arrCntrNo = FullCntrNo;
						}else{
							arrCntrNo = arrCntrNo + "," + FullCntrNo;
						}
					}
					
					List<String> arrFullCntrNo      = null;
					arrFullCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(arrCntrNo,",","|"));
			           
					strBkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
					param.put("upd_usr_id", account.getUpd_usr_id());
					param.put("bkg_no" , strBkgNo);
					param.put("cntr_cd", arrFullCntrNo);					
					velParam.put("bkg_no" , strBkgNo);
					velParam.put("upd_usr_id", account.getUpd_usr_id());
					velParam.put("cntr_cd", arrFullCntrNo);
				}	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyMTBookingNoToMovementUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}			
		
		/**
		 *  Movement 내 Booking No를 Update한다..<br>
		 *  
		 * @author 		Park Young Jin
		 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void modifyBkgContainerbyMovement(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(repoBkgForUpdateVO != null){
					String strBkgNo = "";
					String FullCntrNo = "";
					String arrCntrNo = "";
					RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
					for(int i = 0 ; i < repoCntrVOs.length ; i++){
						FullCntrNo = repoCntrVOs[i].getFullCntrNo();
						if(i ==0) {
							arrCntrNo = FullCntrNo;
						}else{
							arrCntrNo = arrCntrNo + "," + FullCntrNo;
						}
					}
					
					List<String> arrFullCntrNo      = null;
					arrFullCntrNo = JSPUtil.convertStringToArrayList(JSPUtil.replace(arrCntrNo,",","|"));
			           
					strBkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
					param.put("upd_usr_id", account.getUpd_usr_id());
					param.put("bkg_no" , strBkgNo);
					param.put("cntr_cd", arrFullCntrNo);					
					velParam.put("bkg_no" , strBkgNo);
					velParam.put("upd_usr_id", account.getUpd_usr_id());
					velParam.put("cntr_cd", arrFullCntrNo);
				}	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgContainerbyMovementUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}			
		
		
		
		/**
		 *  Movement 내 Booking No,VSL,VOY.. 를 Update한다..<br>
		 *  
		 * @author 		Park Young Jin
		 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
		 * @param 		SignOnUserAccount account
		 * @exception 	DAOException
		 */
		public void modifyMTBookingCtmbyMovement(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(repoBkgForUpdateVO != null){
					String strBkgNo = "";	           
					strBkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
					param.put("upd_usr_id", account.getUpd_usr_id());
					param.put("bkg_no" , strBkgNo);				
					velParam.put("bkg_no" , strBkgNo);
					velParam.put("upd_usr_id", account.getUpd_usr_id());
				}	
				
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOmodifyMTBookingCtmToMovementUSQL(), param,velParam);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * Vender301 EDI 대상 조회 <br>
		 * @param String bkgNo
		 * @return String output_text
		 * @exception DAOException 
		 * @author 
		 */
		public String searchVenderEdiBkg(String bkgNo) throws DAOException {
			// input_text
			String output_text = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no", bkgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL template = new GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				if (dbRowset.next()) {
					output_text = dbRowset.getString("OUTPUT_TEXT");
				} else {
					output_text = "N";
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return output_text; 
		}		
		
		/**
		 * 부킹 켄슬되었을때 Cust Rmk만 업데이트 한다.
		 * @param bkgBookingInfoVO
		 * @throws DAOException
		 */
		public void bkgCustremarkSave(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			try{
				if(bkgBookingInfoVO != null){
					Map<String, String> mapVO = bkgBookingInfoVO.getColumnValues();
					param.putAll(mapVO);
				}	
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int updCnt = sqlExe.executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOBkgCustRemarkCSQL(), param, param);
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
	/**
	 * 
	 * @param vslSkdCngUpdateVO
	 * @return
	 * @throws DAOException
	 */
	public List<BkgBlNoVO> searchBkgRouteForVslSkdCng(VslSkdCngUpdateVO vslSkdCngUpdateVO) throws DAOException {
		// //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		try{
			param.put("vvd", vslSkdCngUpdateVO.getVvd());
			param.put("port_cd", vslSkdCngUpdateVO.getPortCd());
			param.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			param.put("new_clpt_ind_seq", vslSkdCngUpdateVO.getNewClptIndSeq());
			param.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			param.put("new_yd_cd", vslSkdCngUpdateVO.getNewYdCd());
			velParam.put("old_yd_cd", vslSkdCngUpdateVO.getOldYdCd());
			velParam.put("old_clpt_ind_seq", vslSkdCngUpdateVO.getOldClptIndSeq());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);
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
	 * Return number of container(BKG_CONTAINER)<br>
	 * @param  PoOtherNoBkgVO poOtherNoBkgVO
	 * @return int
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int searchCntrCount(PoOtherNoBkgVO poOtherNoBkgVO) throws DAOException {
		int ret = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	//velocity parameter

		try{
			if(poOtherNoBkgVO != null){
				Map<String, String> mapVO = poOtherNoBkgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingReceiptDBDAOSearchCntrCountRSQL(), param, velParam);
				if (dbRowset.next()) {
					ret = dbRowset.getInt("CNTR_COUNT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return ret;
	}
	 
	 /**
	 * 
	 * @param bkgNo
	 * @param pcltNo
	 * @throws DAOException
	 */
	public void bkgPctlNoSync(String bkgNo, String pcltNo, String caFlg) throws DAOException {	
		Map<String, Object> param = new HashMap<String, Object>();	//query parameter
		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				param.put("pctl_no", pcltNo);
				param.put("ca_flg", caFlg);
				new SQLExecuter("").executeUpdate((ISQLTemplate)new GeneralBookingReceiptDBDAOModifyBkgBookingPctlNoUSQL(), param, param);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
	}
}