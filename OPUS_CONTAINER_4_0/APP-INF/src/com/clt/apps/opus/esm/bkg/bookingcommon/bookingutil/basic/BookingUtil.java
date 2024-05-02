/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtil.java
*@FileTitle : Booking Page
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.basic.BookingNumberGenarationBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.basic.BookingNumberGenarationBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
//import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOBkgFuncProcLogCSQL;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.AcssAlwInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgMdmCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgVvdRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgXterUsrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmChgTaxFlgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByCntrNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByHblNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByPoNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchPortCdByVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSrepCdListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.ToTBilAmtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.framework.table.ComUpldFileVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgHamoTrfVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRateVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.MdmStateVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.MdmZoneVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * -BookingUtil<br>
 * - -BookingCommon common business logic is processed.<br>
 *
 * @author 
 * @see UI_Booking_UtilEventResponse  DAO Reference
 * @since J2EE 1.4
 */ 
public class BookingUtil extends BasicCommandSupport{
    // Database Access Object
    private transient BookingUtilDBDAO dbDao = null;
    private transient BookingUtilEAIDAO eaoDao = null;

    /**
     * BookingUtil objects generate<br>
     * BookingUtilDBDAO is created.<br>
     */
    public BookingUtil() {

        dbDao = new BookingUtilDBDAO();
        eaoDao = new BookingUtilEAIDAO();        
    }
    
	/**
	 * oblIssFlgCheck  Event Handling<br>
	 * @param String bkgNo
	 * @param String ca_flg
	 * @return String
	 * @exception EventException
	 */
	public String oblIssFlgCheck(String bkgNo, String ca_flg) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.oblIssFlgCheck(bkgNo, ca_flg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	
	
	/**
	 * searchRtAplyDateCheck  Event Handling<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchRtAplyDateCheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchRtAplyDateCheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	  
	/**
	 * autoRatingRFACheck  Event Handling<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String autoRatingRFACheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoRatingRFACheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	/**
	 *  searchBkgVvd  Event Handling<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgVvdCheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchBkgVvdCheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
    /**
	 * searchScNoValidationCheck search Event Handling<br>
	 * 79-08 Check event <br>
	 * ScNumber Validation  <br>
	 * @author 
	 * @param String scNo
	 * @return String 
	 * @throws EventException
	 */
	public String searchScNoValidationCheck(String scNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchScNoValidationCheck(scNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
    /**
	 * searchCountryName search Event Handling<br>
	 * 79-02C Check event <br>
	 * MDM_COUNTRY Name Search <br>
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String searchCountryName(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchCountryName(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
	/**
	 * BkgTroVO retrieve.<br>
	 * @author 
	 * @param BkgTroVO vo
	 * @return BkgTroVO
	 * @throws EventException
	 */
	public BkgTroVO searchPcNoforTro(BkgTroVO vo) throws EventException {
		try {
			return dbDao.searchPcNoforTro(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
    /**
	 * repCustomer retrieve  Event Handling<br>
	 * 79-08 Check event <br>
	 * 
	 * @author 
	 * @param String bkg_no
	 * @return String 
	 * @throws EventException
	 */
	public String repCustomer(String bkg_no) throws EventException{
		String resultExist = "";
		try {
			resultExist = dbDao.repCustomer(bkg_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	/**
	 * BkgRate retrieve -> 'Mater/Cover' Return.<br>
	 * 
	 * @param String bl_no
	 * @return BkgRateVO
	 * @throws EventException
	 */
	public BkgRateVO searchBkgRate(String bl_no) throws EventException {
		BkgRateVO bkgRateVO = null;
		try {
			bkgRateVO = dbDao.searchBkgRate(bl_no);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return bkgRateVO;
	}
    /**
	 * vesselVoyageDirectionEqual search Event Handling<br>
	 * 79-09 Check event <br>
	 * 
	 * @author 
	 * @param String bkg_no
	 * @return String 
	 * @throws EventException
	 */
	public String vesselVoyageDirectionEqual(String bkg_no) throws EventException{
		String resultExist = "";
		try {
			resultExist = dbDao.vesselVoyageDirectionEqual(bkg_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
    /**
	 * manualSurcharge Function <br>
	 *1. Manual Insert  Charge : Items that are registered during the PRI 'Scope' and 'CHG CODE'  <br>
	 *- Charge Code match, Cur match, Per ='PC' Term  match Applied in case of<br>
	 * @author 
	 * @param String application_date
	 * @param String svc_scp_cd
	 * @param List<String> taxChgs
	 * @return List<ManualSurchargeVO>
	 * @throws EventException
	 */
	public List<ManualSurchargeVO> manualSurcharge(String application_date, String svc_scp_cd, List<String> taxChgs) throws EventException{
		try {
			return dbDao.manualSurcharge(application_date,svc_scp_cd,taxChgs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}   
	
    /**
	 * manualSurcharge Function <br>
	 *1. Manual Insert  Charge : Items that are registered during the PRI 'Scope' and 'CHG CODE'  <br>
	 *- Charge Code match, Cur match, Per ='PC' Term  match Applied in case of<br>
	 * @author 
	 * @param String application_date
	 * @param String svc_scp_cd
	 * @param List<String> taxChgs
	 * @param List<String> chgCds
	 * @return List<ManualSurchargeVO>
	 * @throws EventException
	 */
	public List<ManualSurchargeVO> manualSurcharge(String application_date, String svc_scp_cd, List<String> taxChgs, List<String> chgCds) throws EventException{
		try {
			return dbDao.manualSurcharge(application_date,svc_scp_cd,taxChgs,chgCds);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
    /**
	 * manualSurcharge Function <br>
	 *1. Manual Insert  Charge : Items that are registered during the PRI 'Scope' and 'CHG CODE'  <br>
	 *- Charge Code match, Cur match, Per ='PC' Term  match Applied in case of
	 *- Old source --- Stage server error <br>
	 * @author 
	 * @param String application_date
	 * @param String svc_scp_cd
	 * @return List<ManualSurchargeVO>
	 * @throws EventException
	 */
	public List<ManualSurchargeVO> manualSurcharge(String application_date, String svc_scp_cd) throws EventException{
		try {
			return dbDao.manualSurcharge(application_date,svc_scp_cd,null);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	} 	
	
    /**
	 * manualTaxCountrySurcharge Function <br>
	 *1. Manual Insert  Charge : Items that are registered during the PRI 'Scope' and 'CHG CODE'  <br>
	 *- Charge Code match, Cur match, Per ='PC' Term  match Applied in case of
	 *- Old source --- Stage server error <br>
	 * @author 
	 * @param String application_date
	 * @param String svc_scp_cd
	 * @param String tax_cnt_cd
	 * @return List<ManualSurchargeVO>
	 * @throws EventException
	 */
	public List<ManualSurchargeVO> manualTaxCountrySurcharge(String application_date, String svc_scp_cd, String tax_cnt_cd) throws EventException{
		try {
			return dbDao.manualTaxCountrySurcharge(application_date,svc_scp_cd,tax_cnt_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	} 	
	
    /**
	 * autoratingRfaAvailable search Event Handling<br>
	 * 79-08 Check event <br>
	 * AutoratingRfaAvailable Validation  <br>
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingRfaAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoratingRfaAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
	 /**
	 * autoratingScAvailable search Event Handling<br>
	 * 79-08 Check event <br>
	 * AutoratingScAvailable Validation   <br>
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingScAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoratingScAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   	
	 /**
	 * autoratingTaaAvailable search Event Handling<br>
	 * 79-08 Check event <br>
	 * AutoratingTaaAvailable Validation   <br>
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingTaaAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try{
			resultExist = dbDao.autoratingTaaAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return resultExist;
	}
	  
    /**
	 * existNoteButtonColor search Event Handling<br>
	 * 79-08 Check event <br>
	 * Change the color of the button <br>
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existNoteButtonColor(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.existNoteButtonColor(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}    
    /**
	 * existBlackListedCustomer search Event Handling<br>
	 * 79-08 Check event <br>
	 * Third (Offce cd) Validation <br>
	 * 
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existBlackListedCustomer(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.existBlackListedCustomer(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
    /**
	 * existCountryCode search Event Handling<br>
	 * 79-08 Check event <br>
	 * Third (Offce cd) Validation <br>
	 * 
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existCountryCode(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			
			MdmCountryVO mvo = dbDao.searchCountryCode(cntCd);
			if(mvo != null){
				resultExist = "Y"; 
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
    /**
	 * existPerCode search Event Handling<br>
	 * 79-08 Check event <br>
	 * Per (per cd) Validation <br>
	 * 
	 * @author 
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existPerCode(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			
			resultExist = dbDao.existPerCode(cntCd);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	
    /**
	 * existThirdCode search Event Handling<br>
	 * 79-08 Check event <br>
	 * Third (Offce cd) Validation <br>
	 * 
	 * @author 
	 * @param String offce_cd
	 * @return String
	 * @throws EventException
	 */
	public String existThirdCode(String offce_cd) throws EventException{
		String resultExist = "N";
		try {
			
			MdmOrganizationVO mvo = dbDao.searchMdmOrzByOfcCd(offce_cd);
			if(mvo != null){
				resultExist = "Y"; 
			}
	     
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	/**
	 * existPayerCode search Event Handling<br>
	 * 79-08 Check event <br>
	 * Payer (custCntCd, custSeq) Validation <br>
	 * 
	 * @author 
	 * @param String input_text
	 * @return String OUTPUT_TEXT
	 * @throws EventException
	 */
	public String existPayerCode(String input_text) throws EventException{
		String resultExist = "N";
		
		try {
			String[] cust = input_text.split("\\|");
			String custCntCd = cust[0];
			String custSeq = cust[1];
			resultExist = dbDao.existPayerCode(custCntCd, custSeq);	
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		 return resultExist ;
	}

    /**
	 * searchMdmLocName<br>
	 * LOC_CD  -> LOC_NM <br>
	 * @author 
	 * @param String input_text
	 * @return String OUTPUT_TEXT
	 * @throws EventException
	 */
	public String searchMdmLocName(String input_text) throws EventException{
		try {
			String[] locCd = splitByToken(input_text, "|");
			if(locCd.length>1){
				String locNmList = "";
				for(int i = 0; i<locCd.length; i++){
					
					if(locCd[i] == null || locCd[i].length() < 1){
						continue;
					}
					
					if(i==0){
						locNmList = dbDao.searchMdmLocName(locCd[i]);
					} else {
						locNmList = locNmList + "|" + dbDao.searchMdmLocName(locCd[i]);
					}
				}
				return locNmList;
			} else {
				return dbDao.searchMdmLocName(input_text);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
    /**
     * searchBkgNoListByBkgNo<br>
     * Search conditions:BKG_NO, result: OLD BKG_NO or NEW  BKG_NO  a function that retrieve Number delimiter($)<br>
     * @author 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
        public String searchBkgNoListByBkgNo(String input_text)throws EventException {
            try {
                return dbDao.searchBkgNoListByBkgNo(input_text);
            } catch (DAOException de) {
    			log.error("err " + de.toString(), de);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    		} catch (Exception ex) {
    			log.error("err " + ex.toString(), ex);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    		}
        }
    /**
     * searchBlListByBl<br>
     * Search conditions:BL_NO, result: OLD BL_NO or NEW  BL_NO  a function that retrieve Number delimiter($) <br>
     * @author 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String searchBlNoListByBlNo(String input_text)throws EventException {
        try {
            return dbDao.searchBlNoListByBlNo(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    /**
     * existChargeCode<br>
     * ChargeCode Code number, a function that determines the presence or absence <br>
     * @author 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String existChargeCode(String input_text)throws EventException {
        try {
            return dbDao.existChargeCode(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    /**
     * existCurrencyCode<br>
     * CurrencyCode Code number, a function that determines the presence or absence  <br>
     * @author 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String existCurrencyCode(String input_text)throws EventException {
        try {
            return dbDao.existCurrencyCode(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }        
    /**
     * Common lookup combo list<br>
     * 
     * @param String comCode
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchCombo(String comCode) throws EventException {
        try {
            return dbDao.searchCombo(comCode);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
    /**
     * Search conditions:BL_NO, result: BKG NO <br>
     * 
     * @param String blNo
     * @return String
     * @exception EventException
     */
    public String searchBkgNoByBlNo(String blNo) throws EventException {
        try {
            return dbDao.searchBkgNoByBlNo(blNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

    /**
     * Booking state retrieve <br>
     *
     * @param     bkgBlNoVO BkgBlNoVO
     * @return    String
     * @exception EventException
     */ 
    public String searchBkgStatusByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchBkgStatusByBkg(bkgBlNoVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

   
    /**
     * Search conditions:bkg_no, result:bkg_split_no search Event Handling<br>
     *
     * @param String bkgNo
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchBkgNoSplitByBkg(String bkgNo) throws EventException {
        try {
            return dbDao.searchBkgNoSplitByBkg(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Booking Creation 1_Container Type/Size retrieve <br>
     * 
     * @param MdmCntrTpSzVO MdmCntrTpSzVO
     * @return List<MdmCntrTpSzVO>
     * @throws EventException
	 * 
     */
    public List<MdmCntrTpSzVO> searchTypeSize(MdmCntrTpSzVO mdmCntrTpSzVO) throws EventException {
        try {
            return dbDao.searchTypeSize(mdmCntrTpSzVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * container TypeSize retrieve <br>
     * 
     * @param String cntrNo
     * @return List<MstContainerVO>
     * @throws EventException
     */
    public List<MstContainerVO> searchTypeSizeByCntr(String cntrNo) throws EventException {
        try {
            return dbDao.searchTypeSizeByCntr(cntrNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
  /**
   * 
   * @param bkgNo
   * @param cntrNo
   * @return
   * @throws EventException
   */
    public String cntrPrtFlgCountCheck(String bkgNo, String cntrNo) throws EventException {
        try {
            return dbDao.cntrPrtFlgCountCheck(bkgNo, cntrNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    
	/**
	 * Mdm Customer retrieve <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String validFlag
	 * @return MdmCustVO
	 * @throws EventException
	 */
	public MdmCustVO searchMdmCust(String custCntCd,String custSeq, String validFlag) throws EventException {
		MdmCustVO mdmCustVO = null;
		try {
			mdmCustVO = dbDao.searchMdmCust(custCntCd, custSeq);			
			if(mdmCustVO != null){
				// validFlag = "Y"
				if("Y".equals(validFlag)){
					// deltFlag = 'Y'
					if("Y".equals(mdmCustVO.getDeltFlg())){
						throw new EventException((String)new ErrorHandler("BKG00353",new String[]{mdmCustVO.getCustCntCd(),mdmCustVO.getCustSeq()}).getMessage());
					}
					// blockFlag = 'Y'
					if("Y".equals(mdmCustVO.getBlockFlag())){
						throw new EventException((String)new ErrorHandler("BKG00354",new String[]{mdmCustVO.getCustCntCd(),mdmCustVO.getCustSeq()}).getMessage());
					}		
				}
			}else{
				throw new EventException(new ErrorHandler("BKG00458").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return mdmCustVO;
	}	  
	
	/**
     * search Event Handling<br>
     * SVC Lane List Search.(Combo)<br>
     * 
     * @return List<MdmVslSvcLaneVO>
     * @throws EventException
     */
	public List<MdmVslSvcLaneVO> searchSvcLaneCd() throws EventException{
        try {
            return dbDao.searchSvcLaneCd();
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	
	/**
	 * mdm yard code retrieve <br>
	 * 
	 * @param MdmYardVO vo
	 * @return List<MdmYardVO>
	 * @throws EventException
	 */
	public List<MdmYardVO> searchYardCode(MdmYardVO vo) throws EventException {
		try {
			return dbDao.searchYardCode(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Location Code Validation<br>
	 * Location Code exist :true, not exist Location Code : false<br>
	 * 
	 * @param locCd Location Code
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateLoc(String locCd) throws EventException {
		try {
			return dbDao.validateLoc(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Search conditions:Office cd, result: Organization Information.<br>
	 * @author Park Mangeon
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @throws EventException
	 */
	public MdmOrganizationVO searchMdmOrzByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchMdmOrzByOfcCd(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * MDM Code 餓λ쵎�궗 筌ｋ똾寃�
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public int checkMdmOrzByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.checkMdmOrzByOfcCd(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Search conditions:Office cd, result: Loc Cd.<br>
	 * @param String ofcCd
	 * @return String loc_cd
	 * @throws EventException
	 */
	public String searchLocCdByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocCdByOfcCd(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 *  Search conditions: Location Code,search Event Handling<br>
	 * @param String locCd
	 * @return SearchLocationCodeVO
	 * @throws EventException
	 */
	public SearchLocationCodeVO searchLocationCode(String locCd) throws EventException {
		try {
			return dbDao.searchLocationCode(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 * Search conditions:com_user, result: user_nm<br>
	 * @param String userId
	 * @return String usrNm
	 * @throws EventException
	 */
	
	public String searchUserName(String userId) throws EventException {
		try {
			return dbDao.searchUserName(userId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 *  Search conditions:Container No, result: B/L List <br>
	 * @param String cntrNo
	 * @return List<SearchBlListByCntrNoVO>
	 * @throws EventException
	 */
	
	public List<SearchBlListByCntrNoVO> searchBlListByCntrNo(String cntrNo)  throws EventException {
		try {
			return dbDao.searchBlListByCntrNo(cntrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 *  vsk vessel schedule retrieve<br>
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vps_port_cd     
	 * @param String clpt_ind_seq      
	 * @return VskVslPortSkdVO
	 * @throws EventException
	 */
	
	public VskVslPortSkdVO searchEtbEtdEta (String vsl_cd,String skd_voy_no,String skd_dir_cd,String vps_port_cd,String clpt_ind_seq)   throws EventException {
		try {
			return dbDao.searchEtbEtdEta(vsl_cd,skd_voy_no,skd_dir_cd,vps_port_cd,clpt_ind_seq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 *  mdm zone retrieve. <br>
	 * @param String locationCd
	 * @return List<MdmZoneVO>
	 * @throws EventException
	 */
	
	public List<MdmZoneVO> searchZoneCode (String locationCd)   throws EventException {
		try {
			return dbDao.searchZoneCode(locationCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 * Booking Split no retrieve<br>
	 * @param String bkgno
	 * @return List<BkgBooking>
	 * @throws EventException
	 */
	
	public List<BkgBookingVO> searchBookingSplitNo (String bkgno)  throws EventException {
		try {
			return dbDao.searchBookingSplitNo(bkgno);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 * Search conditions:Bkg No, result:BDR Flag <br>
	 * @param BkgBlNoVO vo
	 * @return String bdr_flag
	 * @throws EventException
	 */
	
	public String searchBdrFlgByBkg(BkgBlNoVO vo)  throws EventException {
		try {
			return dbDao.searchBdrFlgByBkg(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BKG common  UTIL <br>
	 *  B / L data retrieve   <br>
	 * @param String poNo
	 * @return List<SearchBlListByPoNoVO>
	 * @throws EventException
	 */
	
	public List<SearchBlListByPoNoVO> searchBlListByPoNo (String poNo) throws EventException {
		try {
			return dbDao.searchBlListByPoNo(poNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * search Event Handling<br>
	 * Search conditions:HB/L_No, result: BKG_NO retrieve. <br>
	 * @param String hbl_no
	 * @return List<SearchBlListByHblNoVO>
	 * @throws EventException
	 */
	
	public  List<SearchBlListByHblNoVO> searchBlListByHblNo (String hbl_no) throws EventException {
		try {
			return dbDao.searchBlListByHblNo(hbl_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 *  Check used in BKG_PFX_ROUT table as BKG_No. <br>
	 *  BKG NO PREFIX<br>
	 *  => OFFICE PREFIX 3DIGIT<br>
	 *  => booking_no PreFix  previous three-digit<br>
	 * @param BkgBlNoVO vo
	 * @return String svr_id_cd
	 * @throws EventException
	 */
	public String searchSvrByBkgNo (BkgBlNoVO vo) throws  EventException {
		try {
			return dbDao.searchSvrByBkgNo(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 *  bkg -> BDR, C/A state retrieve<br>
	 * @param BkgBlNoVO vo
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchBkgBlNoVO (BkgBlNoVO vo) throws EventException {
		try {
			return dbDao.searchBkgBlNoVO(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * Specific Country Code retrieve.<br>
	 * @param String cntCd
	 * @return MdmCountryVO
	 * @throws EventException
	 */
	public MdmCountryVO searchCountryCode (String cntCd ) throws EventException {
		try {
			return dbDao.searchCountryCode(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * HTS Code Check.<br>
	 * @param String htsCd
	 * @return BkgHamoTrfVO
	 * @throws EventException
	 */
	public BkgHamoTrfVO searchHtsCodeDesc (String htsCd ) throws EventException {
		try {
			return dbDao.searchHtsCodeDesc(htsCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
		
	
	/**
	 * Package Code Check.<br>
	 * @param String searchPkgType
	 * @return MdmPckTpVO
	 * @throws EventException
	 */
	public MdmPckTpVO searchPkgType (String searchPkgType )throws EventException {
		try {
			return dbDao.searchPkgType(searchPkgType);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
		
	/**
	 * vvd, pol-> BDR retrieve availability.<br>
	 * @param BkgVvdVO bkgVvdVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchVvdBdr(BkgVvdVO bkgVvdVO) throws EventException {
		try {
			return dbDao.searchVvdBdr(bkgVvdVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Check imdg_pck_cd value.<br>
	 * @param String dgPkgTpCd
	 * @return String
	 * @throws EventException
	 */
	public String searchPkgTypeForDg(String dgPkgTpCd) throws EventException {
		try {
			return dbDao.searchPkgTypeForDg(dgPkgTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Vessel(VVD) Check the presence.<br>
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateVvd (String vslCd ,String voyNo ,String dirCd ) throws EventException {
		try {
			return dbDao.validateVvd(vslCd,voyNo,dirCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessel(VVD)->check locationdp calling whether .<br>
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String locCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateVvdLoc (String vslCd ,String voyNo ,String dirCd,String locCd  ) throws EventException {
		try {
			return dbDao.validateVvdLoc(vslCd,voyNo,dirCd,locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Retrieve hard-coded  <br>
	 * Search conditions:hrd_cdg_id, result :bkg_hrd_cdg_desc, bkg_hrd_cdg_desc retrieve. <br>
	 * 
	 * @param bkgHrdCdgCtntListCondVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchHardCoding(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) throws EventException {
		try {
			return dbDao.searchHardCoding(bkgHrdCdgCtntListCondVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
     * C/A STATUS retrieve <br>
     * 
     * @param bkgBlNoVO
     * @return String
     * @throws EventException
     */
    public String searchBkgCaStatus(BkgBlNoVO bkgBlNoVO)throws EventException {
        try {
            return dbDao.searchBkgCaStatus(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	/**
	 * Bkg_No, Bl_no generation, etc..<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
		
	public BkgBlNoVO manageBkgNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			BookingNumberGenarationBC bc = new BookingNumberGenarationBCImpl();	
			return bc.manageBkgNumberGeneration(divCd,officeCd,usrId);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * RPT, JPD, D / O, CAD, UIT, C / A, KOR NO generation, etc. ReferenceNumber.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgReferenceNoGenerationVO
	 * @throws EventException
	 */
		
	public BkgReferenceNoGenerationVO manageBkgReferenceNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			BookingNumberGenarationBC bc = new BookingNumberGenarationBCImpl();
			return bc.manageBkgReferenceNumberGeneration(divCd,officeCd,usrId);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	

	/**
	 * China generates Bl_no CheckDigit.<br>
	 * @param String blNo 
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
		
	public BkgBlNoVO chnBlNoCheckDigit (String blNo )throws EventException {
		try {
			return dbDao.chnBlNoCheckDigit(blNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve the code that exists in MDM TABLE <br>
	 * 
	 * @param  comboParam
	 * @param String comboCd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet seacrhMDMCombo (Map<String, Object> comboParam ,String comboCd ) throws EventException {
		try {
			if (comboCd.equals("MDM0001")){
				return dbDao.searchSvcLaneBound();
			}else{
				return new DBRowSet();
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * SlanCd, PodCd check existence.<br>
	 * @param String slanCd 
	 * @param String podCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchSvcLaneByLoc (String slanCd ,String podCd) throws EventException {
		try {
			return dbDao.searchSvcLaneByLoc(slanCd,podCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Vendor code Check<br>
	 * @param String vendorCntCc 
	 * @param String vendorSeq
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkVenodrCode (String vendorCntCc ,String vendorSeq) throws EventException {
		try {
			return dbDao.checkVenodrCode(vendorCntCc,vendorSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Report Item retrieve .<br>
	 * @param String rptId 
	 * @param String bkgRptKndCd 
	 * @return boolean
	 * @throws EventException
	 */
	public List <ReportItemVO> searchReportItemList (String rptId ,String bkgRptKndCd) throws EventException{
		
		try {
			return dbDao.searchReportItemList(rptId,bkgRptKndCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Only report -> Table,column retrieve .<br>
	 * 
	 * @param String rptId 
	 * @param String bkgRptKndCd 
	 * @return List <ReportItemVO>
	 * @throws EventException
	 */
	public List <ReportItemVO> searchTblColList (String rptId ,String bkgRptKndCd) throws EventException{
		
		try {
			return dbDao.searchTblColList(rptId, bkgRptKndCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  Search conditions: VVD,POL, POD. result :American customs check whether the target<br>
	 * 	1. searchCanadaFROB()-> True -> "CA" return<br>
	 *	2. searchUsaFROB()-> True -> "US"  retun<br>
	 *	3. All true -> 'AL' return<br>
	 *	4. For other -> "XX"  return<br>
	 * @param String bkgNo 
	 * @param String bkgTrunkVvd 
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @throws EventException
	 */
	public String searchFrob (String bkgNo, String bkgTrunkVvd ,String polCd, String podCd) throws EventException {
		String rtnValue = "XX";
		try {
			boolean isCanada = dbDao.searchCanadaFrob(bkgNo, bkgTrunkVvd, polCd, podCd);
			boolean isUsa = dbDao.searchUsaFrob(bkgNo, bkgTrunkVvd, polCd, podCd);
			boolean isPuetoRico = dbDao.searchPuetoRicoFrob(bkgNo, bkgTrunkVvd, polCd, podCd);
			if(isCanada && (isUsa || isPuetoRico)){
				rtnValue = "AL";
			}else{
				if(isCanada){
					rtnValue = "CA";	
				}else if(isUsa){
					rtnValue = "US";
				}else if(isPuetoRico){
					rtnValue = "US";
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return rtnValue;
	}

    /**
     * Search conditions: bkg tro, cntr -> result :s/o  issue  check whether<br>
     * 
     * @param String troSeq
     * @param String cntrNo
     * @param BkgBlNoVO bkgBlNoVO
     * @param String boundCd
     * @return String
     * @throws EventException
     */
    public String searchSoStatus(String troSeq, String cntrNo, BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
        // TODO Auto-generated method stub
    	String rtn;
    	try {
	        rtn = dbDao.searchSoStatus(bkgBlNoVO.getBkgNo(), cntrNo, boundCd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
    }	
    
    /**
	 * Search conditions: SVC_LANE,SKD_DIR_CD -> result Port cd List retrieve<br>
	 * @param String vsl_slan_cd
	 * @param String skd_dir_cd
	 * @param String port_cd
	 * @return List<SearchSvcLaneBoundVO> 
	 * @throws EventException
	 */
	public List<SearchSvcLaneBoundVO> searchPortCdListByLane (String vsl_slan_cd,String skd_dir_cd, String port_cd) throws EventException {
		try {
			return dbDao.searchPortCdListByLane(vsl_slan_cd,skd_dir_cd,port_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * Ensure the availability of RFA.<br>
	 * @param String rfaNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchRfaAvailable (String rfaNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchRfaAvailable(rfaNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    

	/**
	 * Ensure the availability of SC_NO.<br>
	 * @param String scNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchScAvailable (String scNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchScAvailable(scNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    		

	/**
	 * Ensure the availability of Taa_NO.<br>
	 * @param String taaNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchTaaAvailable (String taaNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchTaaAvailable(taaNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    	


    /**
	 * Booking Split number retrieve. <br>
	 * 
	 * @param String bkgNo
	 * @return List<SplitNoVO> 
	 * @throws EventException
	 */
	public List<SplitNoVO> searchBkgSplitNo (String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgSplitNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
	 * Booking Split number retrieve. <br>
	 * @param String bkgNo
	 * @param String size
	 * @return String 
	 * @throws EventException
	 */
	public String searchBkgSplitNoByOptional (String bkgNo, String size) throws EventException {
		StringBuffer html = new StringBuffer("");		
		try {
	        if(size == null || size.length() < 1 ){
	        	size = "5";
	        }
	        
	        html.append("<select name='bkg_split_no_list' size="+ size +" multiple onChange='javascript:bkgSplitNoList(this);' >\n");
	        List<SplitNoVO> bkgList = dbDao.searchBkgSplitNo(bkgNo);
	        SplitNoVO splitNoVO = null;
	        for(int i=0;i<bkgList.size();i++){
	        	splitNoVO = bkgList.get(i);
	            html.append("<option value='"+splitNoVO.getBkgNo()+"'>"+splitNoVO.getBkgNo()+"</option>\n");
	        }
	        html.append("</select>\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return html.toString();
	}

	
    /**
	 * BL_No retrieve <br>
	 * @param String bkgNo
	 * @return SplitMstBlNoVO 
	 * @throws EventException
	 */
	public SplitMstBlNoVO searchSplitMstBlNo (String bkgNo) throws EventException {
		try {
			return dbDao.searchSplitMstBlNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_hrd_cdg table modify.<br>
	 * @param bkgHrdCdgCtntVOs
	 * @throws EventException
	 */
	public void manageHardCoding(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) throws EventException {
		try {
			List<BkgHrdCdgCtntVO> addList = new ArrayList<BkgHrdCdgCtntVO>();
			List<BkgHrdCdgCtntVO> modList = new ArrayList<BkgHrdCdgCtntVO>();
			List<BkgHrdCdgCtntVO> delList = new ArrayList<BkgHrdCdgCtntVO>();

			for (int i=0; i<bkgHrdCdgCtntVOs.length; i++) {
				if ("I".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					addList.add(bkgHrdCdgCtntVOs[i]);
				} else if ("U".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					modList.add(bkgHrdCdgCtntVOs[i]);
				} else if ("D".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					delList.add(bkgHrdCdgCtntVOs[i]);
				}
			}
			if (addList.size() > 0) {
				dbDao.addHardCoding(addList);
			}
			if (modList.size() > 0) {
				dbDao.modifyHardCoding(modList);
			}
			if (delList.size() > 0) {
				dbDao.removeHardCoding(delList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
     * PKG TYPE VALIDATION CHECK  <br>
     * @param  String pckTpCd
     * @return boolean 
     * @throws EventException
     */
    public boolean validatePkgType(String pckTpCd) throws EventException {
        try {
            return dbDao.validatePkgType(pckTpCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * check HtsCode By Cm<br>
     * 
     * @param hamoTpCd
     * @param hamoTrfCd
     * @return String
     * @exception EventException
     */
    public String checkHtsCodeByCm(String hamoTpCd, String hamoTrfCd) throws EventException {
        try {
            return dbDao.checkHtsCodeByCm(hamoTpCd, hamoTrfCd);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
        }
    }
    
    /**
     * NCM Code Desc. retrieve .<br>
     * 
     * @param ncmNo
     * @return String 
     * @exception EventException
     */
    public String searchNcmCodeDesc(String ncmNo) throws EventException {
        try {
            return dbDao.searchNcmCodeDesc(ncmNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
        }
    }
    
    /**
     * ESM_BKG_0079_02B : receive header String generate <br>
     * @param String sndrId
     * @param String rcvId
     * @param String msgId
     * @return String 
     * @throws EventException
     */
    public String searchEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
        try {
            return dbDao.searchEdiHeader(sndrId, rcvId, msgId);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    

    
    /**
     * ESM_BKG_0079_01 : Search conditions: VVD. result :Lane retrieve <br>
     * @author 	
     * @param  	String vvd
     * @return 	String 
     * @throws EventException
     */
    public String searchSvcLaneByVvd(String vvd)throws EventException {
        try {
            return dbDao.searchSvcLaneByVvd(vvd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }       

    /**
     *  Save for VVD after change,special cargo application requested approval<br>
     * @author 	  
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return		Boolean
     * @throws EventException
     */
    public boolean searchSpclApplForChange(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchSpclApplForChange(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    

    /**
     * P/O No Validation<br>
     *  BOOKING USA and the case of a particular Shippers -> , P / O_No necessarily input<br>
     * @author 	  
     * @param 	String custCntCd
     * @param 	String custSeq
     * @param 	String scNo
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return	Boolean
     * @throws EventException
     */
    public boolean searchPoNoLengthByDtl(String custCntCd, String custSeq, String scNo, BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchPoNoLengthByDtl(bkgBlNoVO,custCntCd, custSeq, scNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }  
    
    /**
     *  Manifest Transmit Common Functions<br>
     * @author 	  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO flatFileAckVO
     * @throws EventException
     */    
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO) throws EventException {
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		try {
			flatFileAckVO = eaoDao.sendFlatFile(sendFlatFileVO);
		}catch(EventException ex){
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

		return flatFileAckVO;
	}    


	/**
     *  MDM CMDT DESC retrieve <br>
     * @param 	String cmdtCd
     * @return	String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchMdmCmdtDesc(String cmdtCd) throws EventException {
        try {
            return dbDao.searchMdmCmdtDesc(cmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }
    
    /**
     *  MDM CMDT DESC retrieve <br>
     * @param 	String cmdtCd
     * @return	String repcmdtCd
	 * @throws Exception
	 * @throws EventException
     */
    public String searchMdmCmdt(String cmdtCd) throws EventException {
        try {
            return dbDao.searchMdmCmdt(cmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     *  MDM REP CMDT NAME retrieve <br>
     * @param 	String repCmdtCd
     * @return	String repCmdtNm
	 * @throws Exception
	 * @throws EventException
     */
    public String searchRepCmdtNm(String repCmdtCd) throws EventException {
        try {
            return dbDao.searchRepCmdtNm(repCmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    
    /**
     *  P/O check digit<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @throws EventException
     */
    public String searchPoNoLength(BkgBlNoVO bkgBlNoVO) throws EventException{
    	try {
            return dbDao.searchPoNoLength(bkgBlNoVO);
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     *  Security control within the screen<BR>
     *  at the screen Open -> user user ID or  by user country code  <br>
     *  enable /disable whether the judgment button.<BR> 
     * @param AcssAlwInfoVO vo
     * @return boolean
     * @throws EventException
     */
    public boolean checkIfAccsIsAlw (AcssAlwInfoVO vo) throws EventException {
    	try {
            return dbDao.checkIfAccsIsAlw(vo);
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    
    /**
	 * Search conditions: VSK_VSL_PORT_SKD table VVD, result :Port cd List retrieve<br>
	 * @param String vvd
	 * @return List<SearchPortCdByVvdVO> 
	 * @throws EventException
	 */
	public List<SearchPortCdByVvdVO> searchPortCdListByVvd (String vvd) throws EventException {
		try {
            return dbDao.searchPortCdListByVvd(vvd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	



    /**
     *  Search conditions: bkg_no, cntr_no, result :mvmt container movement status retrieve.<br>
     *  
     * @author 	  
     * @param 	BkgBlNoVO bkgBlNoVO
     * @param 	String cntrNo
     * @return		String[]
     * @throws EventException
     */
    public String[] searchMVMTStatus(BkgBlNoVO bkgBlNoVO, String cntrNo) throws EventException {
        try {
            return dbDao.searchMVMTStatus(bkgBlNoVO,cntrNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 *  Search conditions: COM_USER ofc_cd, result :STAFF retrieve .<br>
	 * @param String ofc_cd
	 * @return List<StaffListByOfcCdVO> 
	 * @throws EventException
	 */
	public List<StaffListByOfcCdVO> searchStaffListByOfcCd (String ofc_cd) throws EventException {
		try {
            return dbDao.searchStaffListByOfcCd(ofc_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieve BookingComboUtilDBDAO <br>
	 * DMT_OFC_LVL_V  REGION Combo List retrieve -ESM_BKG_0226 <br>
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchRgnOfficeCd() throws EventException {
		try {
            return dbDao.searchRgnOfficeCd();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Memo Split BKG ->Generated in the first place and retrieve BKG. <br>
	 * @author Lee NameKyung
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @return MemoSplitMasterBkgVO
	 * @exception EventException
	 */
	public MemoSplitMasterBkgVO searchMemoSplitMstBkg(BkgBlNoVO bkgBlNoVo) throws EventException {
		try {
			return dbDao.searchMemoSplitMstBkg(bkgBlNoVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * mdm currency code retrieve  <br>
	 * @author Lee NameKyung
	 * @param  String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmCurr(String currCd) throws EventException {
		try {
			return dbDao.searchMdmCurr(currCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 *  BKG  CGO_TYPE retrieve<br>
     * @author 	KymByungKyu 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return		String
	 * @throws EventException
	 */
	public String searchBkgCgoTp(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgCgoTp(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

    /**
     * Search conditions: Office_Code, result:Server_ID retrieve.<br>
     * @author 	
     * @param  	String ofcCd
     * @return 	String
	 * @throws EventException
	 */
	public String searchSvrByOfc(String ofcCd) throws EventException {
		try {
			return dbDao.searchSvrByOfc(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * Search conditions: Sender Id, Sender Tp Code(CUST). result : Host Id retrieve<br>
     * 
     * @author 	
     * @param  	String rcvId
     * @param  	String sndrTpCd
     * @return 	String
	 * @throws EventException
	 */
	public String searchEdi301HostId(String rcvId, String sndrTpCd) throws EventException {
		try {
			return dbDao.searchEdi301HostId(rcvId, sndrTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * Search conditions: Sender Id, Sender Tp Code(CUST). result : Host Id retrieve<br>
     * 
     * @author 	
     * @param  	TmnlRcvIdVO tmnlRcvIdVO
     * @param  	String msgCd
     * @param  	String sndrTpCd
     * @return 	String
	 * @throws EventException
	 */
	public String searchEdi301HostId(TmnlRcvIdVO tmnlRcvIdVO, String msgCd, String sndrTpCd) throws EventException {
		try {
			return dbDao.searchEdi301HostId(tmnlRcvIdVO, msgCd, sndrTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

	/**
     * Customer Alert message retrieve<br>
     * 
     * @author 	
     * @param  	String custCntCd
     * @param  	String custSeq
     * @return 	String
	 * @throws EventException
	 */
	public String searchAlertCust(String custCntCd, String custSeq) throws EventException {
		try {
			return dbDao.searchAlertCust(custCntCd, custSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * Search conditions: VVD , result : VSL_NM retrieve.<br>
     * @author 	
     * @param  	String vvd
     * @return 	String
     * @throws EventException
     */
    public String searchVslNm(String vvd) throws EventException {
        try {
            return dbDao.searchVslNm(vvd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * bkg  cntr_no list retrieve<br>
     * @author 	
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return	String[]
     * @throws EventException
     */
    public String[] searchCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchCntrListByBkg(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * [Tro] Prd for send parameter retrieve<br>
     * 
     * @author 	 Lee NamKyung 
     * @param 	 PrdParameterVO prdParameterVO
     * @return   PrdParameterVO
     * @exception EventException
     */
    public PrdParameterVO searchPrdParmForInlandRoute(PrdParameterVO prdParameterVO) throws EventException {
    	
    	PrdParameterVO rtnPrdParameterVO = new PrdParameterVO();
    	
        try {   
 
        	// 04. Booking information: Change
        	rtnPrdParameterVO.setPrdMainInfoVO(dbDao.searchPrdBkg(prdParameterVO.getPrdMainInfoVO(), prdParameterVO.getBkgBlNoVO()));
        	rtnPrdParameterVO.getPrdMainInfoVO().setPcMode(prdParameterVO.getPrdMainInfoVO().getPcMode());
        	// 05. Quantity information: Change
        	if(prdParameterVO.getPrdQtyInfo() == null || prdParameterVO.getPrdQtyInfo().size() < 1){
        		rtnPrdParameterVO.setPrdQtyInfo(dbDao.searchPrdQty(prdParameterVO.getBkgBlNoVO()));
        	}else{
        		rtnPrdParameterVO.setPrdQtyInfo(prdParameterVO.getPrdQtyInfo());
        	}
        	
        	// BkgBlNo Information: maintenance
        	rtnPrdParameterVO.setBkgBlNoVO(prdParameterVO.getBkgBlNoVO());
        	
        	// TroInfo Information: maintenance
        	rtnPrdParameterVO.setPrdTroInfoVO(prdParameterVO.getPrdTroInfoVO()); 
        	
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        
        return rtnPrdParameterVO;
    }	
    
	/**
	 * The basic validation processing.<br>
	 * parameter retrieve.<br>
	 * 
     * @author 	
	 * @param PrdParameterVO prdParameterVO
	 * @return PrdParameterVO
	 * @throws EventException
	 */
	public PrdParameterVO searchPrdParmForFullRoute(PrdParameterVO prdParameterVO) throws EventException {
    	PrdParameterVO rtnPrdParameterVO = new PrdParameterVO();
		try {
			PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();

			if(prdMainInfoVO != null){
				// 01-01. POR LocationCode Validation
				String porCd = prdMainInfoVO.getPor();
				if(porCd != null && porCd.length() > 0){
					if(dbDao.searchLocationCode(porCd) == null){
						throw new EventException((String)new ErrorHandler("BKG00068",new String[]{porCd}).getMessage());
					}
				}
				// 01-02. POL LocationCode Validation
				String polCd = prdMainInfoVO.getPol();
				if(polCd != null && polCd.length() > 0){
					if(!polCd.equals(porCd)){
						if(dbDao.searchLocationCode(polCd) == null){
							throw new EventException((String)new ErrorHandler("BKG00065",new String[]{polCd}).getMessage());
						}
					}
				}
				// 01-03. POD LocationCode Validation
				String podCd = prdMainInfoVO.getPod();
				if(podCd != null && podCd.length() > 0){
					if(dbDao.searchLocationCode(podCd) == null){
						throw new EventException((String)new ErrorHandler("BKG00067",new String[]{podCd}).getMessage());
					}
				}

				// 01-04. DEL LocationCode Validation
				String delCd = prdMainInfoVO.getDel();
				if(delCd != null && delCd.length() > 0){				
					if(!delCd.equals(podCd)){
						if(dbDao.searchLocationCode(delCd) == null){
							throw new EventException((String)new ErrorHandler("BKG00066",new String[]{delCd}).getMessage());
						}
					}
				}				
				// 02-01. POR Node Code Validation
				String porNodeCd = "";
				if(prdMainInfoVO.getPorN() != null){
					porNodeCd = prdMainInfoVO.getPorN();
				}
				if(porCd != null && porCd.length() > 0){
					if(!dbDao.searchNodeCode(porCd, porNodeCd)){
						throw new EventException((String)new ErrorHandler("BKG01041",new String[]{porNodeCd}).getMessage());
					}
				}

				// 02-01. DEL Node Code Validation
				String delNodCd = "";
				if(prdMainInfoVO.getDelN() != null){
					delNodCd = prdMainInfoVO.getDelN();
				}
				if(delCd != null && delCd.length() > 0){	
					if(!dbDao.searchNodeCode(delCd, delNodCd)){
						throw new EventException((String)new ErrorHandler("BKG01041",new String[]{delNodCd}).getMessage());
					}
				}
				// 03-01. Check POL Marine Terminal
				String polYdCd = "";
				if(prdMainInfoVO.getPolN() != null){
					polYdCd = prdMainInfoVO.getPolN();
				}
				if(polCd != null && polCd.length() > 0){
					if(!dbDao.searchMarineYard(polCd, polYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00272",new String[]{polYdCd}).getMessage());
					}
				}
				// 03-02. Check POD Marine Terminal(POD check)
				String podYdCd = "";
				if(prdMainInfoVO.getPodN() != null){
					podYdCd = prdMainInfoVO.getPodN();
				}				
				if(podCd != null && podCd.length() > 0){
					if(!dbDao.searchMarineYard(podCd, podYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00272",new String[]{podYdCd}).getMessage());
					}
				}
				// 04. Trunk VVD  Lane Validation
				String trunkVvd = prdMainInfoVO.getTVvd();
				String laneCd = "";
				if(isCheckVvdCd(trunkVvd)){
					laneCd = dbDao.searchSvcLaneByVvd(trunkVvd);
					if(laneCd == null || laneCd.length() < 1){
						throw new EventException((String)new ErrorHandler("BKG01004").getMessage());
					}
				}

				VslSkdVO vslSkdVO = new VslSkdVO();
				
				// 06.  Ocean Route  VVD -> ETD, ETA Check if the order of ,(2 > row)
				String vvd1 = prdMainInfoVO.getVvd1();
				String vvd2 = prdMainInfoVO.getVvd2();	
				if(isCheckVvdCd(vvd1) && isCheckVvdCd(vvd2)){
					String vslPodCd1      = prdMainInfoVO.getPod1();
					String vslPolCd2      = prdMainInfoVO.getPol2();
					String podClptIndSeq1 = prdMainInfoVO.getPod1C();	
					String polClptIndSeq2 = prdMainInfoVO.getPol2C();
					vslSkdVO.setBefVvd       (vvd1);
					vslSkdVO.setBefPodCd     (vslPodCd1);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq1);
					vslSkdVO.setCurVvd       (vvd2);
					vslSkdVO.setCurPolCd     (vslPolCd2);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq2);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd2, vvd1}).getMessage());
					}					
				}
				
				// 06.  Ocean Route  VVD -> ETD, ETA Check if the order of ,(2 > row)
				String vvd3 = prdMainInfoVO.getVvd3();	
				if(isCheckVvdCd(vvd2) && isCheckVvdCd(vvd3)){
					String vslPodCd2      = prdMainInfoVO.getPod2();	
					String vslPolCd3      = prdMainInfoVO.getPol3();	
					String podClptIndSeq2 = prdMainInfoVO.getPod2C();	
					String polClptIndSeq3 = prdMainInfoVO.getPol3C();
					vslSkdVO.setBefVvd       (vvd2);
					vslSkdVO.setBefPodCd     (vslPodCd2);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq2);
					vslSkdVO.setCurVvd       (vvd3);
					vslSkdVO.setCurPolCd     (vslPolCd3);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq3);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd2, vvd3}).getMessage());
					}					
				}	
				
				// 06.  Ocean Route  VVD -> ETD, ETA Check if the order of ,(2 > row)
				String vvd4 = prdMainInfoVO.getVvd4();	
				if(isCheckVvdCd(vvd3) && isCheckVvdCd(vvd4)){	
					String vslPodCd3      = prdMainInfoVO.getPod3();
					String vslPolCd4      = prdMainInfoVO.getPol4();
					String podClptIndSeq3 = prdMainInfoVO.getPod3C();
					String polClptIndSeq4 = prdMainInfoVO.getPol4C();
					vslSkdVO.setBefVvd       (vvd3);
					vslSkdVO.setBefPodCd     (vslPodCd3);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq3);
					vslSkdVO.setCurVvd       (vvd4);
					vslSkdVO.setCurPolCd     (vslPolCd4);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq4);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd3, vvd4}).getMessage());
					}					
				}				
				
				// 08.PrdParameter retrieve 
	        	// Booking Information
	        	rtnPrdParameterVO.setPrdMainInfoVO(dbDao.searchPrdBkg(prdParameterVO.getPrdMainInfoVO(), prdParameterVO.getBkgBlNoVO(), prdParameterVO.getUiNo()));
	        	rtnPrdParameterVO.getPrdMainInfoVO().setPcMode(prdParameterVO.getPrdMainInfoVO().getPcMode());
	        	
	        	// Quantity Information
	        	if(prdParameterVO.getPrdQtyInfo() == null || prdParameterVO.getPrdQtyInfo().size() < 1){
	        		rtnPrdParameterVO.setPrdQtyInfo(dbDao.searchPrdQty(prdParameterVO.getBkgBlNoVO()));
	        	}else{
	        		rtnPrdParameterVO.setPrdQtyInfo(prdParameterVO.getPrdQtyInfo());
	        	}
	        	// BkgBlNo Information
	        	rtnPrdParameterVO.setBkgBlNoVO(prdParameterVO.getBkgBlNoVO());				
			}else{
				// Failed to save data
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);       
		}			
				
		return rtnPrdParameterVO; 
	}
	
	/**
	 * 'Pseudo VVD' check whether<br>
	 *
	 * @param String vvd
	 * @return  boolean
	 * @exception EventException
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		if(vvd != null && vvd.length() > 0){
			if(!vvd.startsWith("COXX") && !vvd.startsWith("COYY") && !vvd.startsWith("COZZ")){
				isOk = true;
			}
		}
		return isOk;
	}
	
    /**
	 *  BKG_SLS_REP table SREP_CD retrieve.<br>
	 * @param String ofc_cd
	 * @return List<SearchSrepCdListVO> 
	 * @throws EventException
	 */
	public List<SearchSrepCdListVO> searchSrepCdList (String ofc_cd) throws EventException {
		try {
            return dbDao.searchSrepCdList(ofc_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Customs package (customsdeclaration) uses the Flat File Header Generation <br>
	 * 
	 * @author 
	 * @param  String sndrId
	 * @param  String rcvId
	 * @param  String msgId
	 * @return String 
	 * @throws EventException
	 */
	public String searchCstmsEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
	    try {
	        return dbDao.searchCstmsEdiHeader(sndrId, rcvId, msgId);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	 
	/**
	 *  return  Booking table  ofc_cd <br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String 
	 * @throws EventException
	 */
	public String searchBkgOfcByBkg(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
            return dbDao.searchBkgOfcByBkg(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
	 * EDI transmission <- BKG customer retrieve.<br>
	 * 
	 * @author 	
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String tpCd
	 * @param 	String autoManualFlg
	 * @return 	List<CustTpIdVO>
	 * @throws EventException
	 */
	public List<CustTpIdVO> searchEdiCustTpId(BkgBlNoVO bkgBlNoVO, String tpCd, String autoManualFlg) throws EventException {
		try {
			return dbDao.searchEdiCustTpId(bkgBlNoVO, tpCd, autoManualFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Retrieve the first 'mty bkg' <br>
	 * @author	
	 * @param 	String bkgNo
	 * @return 	String
	 * @throws EventException
	 */
	public String searchSplitMstBkgNo(String bkgNo) throws EventException{
		try {
            return dbDao.searchSplitMstBkgNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(String OfficeCd)call method<br>
	 * Local Time in 'Office Cd' : return(YYYY-MM-DD HH24: MI: SS format)<br>
	 * 
	 * @author	
	 * @param 	String ofcCd
	 * @return 	String
	 * @throws EventException
	 */
	public String searchTimeLocalOfcFnc(String ofcCd) throws EventException{
		try {
            return dbDao.searchTimeLocalOfcFnc(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * GLOBALDATE_PKG.TIME_CONV_FNC call method<br>
	 * Local Time in 'Office Cd' : return(YYYY-MM-DD HH24: MI: SS format)<br>
	 * 
	 * @author	Jang, JiYoung
	 * @param 	String usrLocCd
	 * @return 	String
	 * @throws EventException
	 */
	public String searchLocalTime(String usrLocCd) throws EventException{
		try {
            return dbDao.searchLocalTime(usrLocCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Search conditions: bkg_no , result : bkg_bl_iss OBL_RLSE_FLG & BL_NO retrieve <br>
	 * @author Lee NameKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return OblIssVO
	 * @exception EventException
	 */
	public OblIssVO searchOblIssue(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchOblIssue(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 *  Array sort(compareName) rearrange by.<br>
	 * <br>
	 * example) <br>
	 * ConfirmHldNtcSendListVO[] hldNtcSendLists = new ConfirmHldNtcSendListVO[];<br> 
	 * sortArray(hldNtcSendLists, "ntcEml");<br>
	 *  
	 * @param Object[] objects destination objects
	 * @param String compareName Sort Conditions name
	 * @return Object[]
	 * @throws Exception
	 */
	public Object[] sortArray(Object[] objects, String compareName) throws Exception {
		
		Object temp = null;
		Object[] results = null;
		String str1, str2;
		int i, j, cnt = 0;
		
		if (objects == null || objects.length <= 1) return objects;
		
		String funcName = "get" + compareName.substring(0,1).toUpperCase() + compareName.substring(1);
		
		Method meth = objects[0].getClass().getMethod(funcName);
		
		for (i=0; i<objects.length; i++) 
		{
			str1 = (String) meth.invoke(objects[i]);
			
			for(cnt=0, j=i+1; j<objects.length; j++) 
			{
				str2 = (String) meth.invoke(objects[j]);
				
			    if(str1.compareTo(str2) == 0)
			    {
			    	cnt++;
			    				    	
				    temp = objects[i+cnt];
				    objects[i+cnt] = objects[j];
				    objects[j] = temp;
			    }
			}
			
			i = i + cnt;
		}
		
		results = objects;
		
		return results;
    }
	
   	/**
	 * return the first 'sep' split<br>
	 *
	 * @param String   str
	 * @param String   sep
	 * @return String[]
	 */
	public String[] splitByToken(String str, String sep){
		List<String> retList = new ArrayList<String>();
		String[] retStr = null;
		int idx = 0;
		if(str.indexOf(sep)>0){
			while(str.indexOf(sep)>-1){
				idx++;
		        int splitNo = str.indexOf(sep);
		        retList.add(str.substring(0, splitNo));
		        str = str.substring(splitNo+1, str.length());
		        if(str.length()==0) break;
		        if(idx>100) break;
			} 
		}
		if(str.length()>0){
			retList.add(str);
		}		
		if(retList.size()==1){
			retList.add("");
		}
		retStr = new String[retList.size()];
        for(int i = 0;i<retList.size();i++){
        	retStr[i] = retList.get(i);
        }
        return retStr;
    }
	
   	/**
	 * PRD send -> paramater  log<br>
	 *  
	 * @param PrdMainInfoVO prdMainInfoVO
	 */
	public void prdParameterLog(PrdMainInfoVO prdMainInfoVO){
		String prdLog = "";
		prdLog = "\n***** to PRD -> "  
			+ "bkg_no:"+prdMainInfoVO.getBkgNo() + ","
			+ "pcMode:"+prdMainInfoVO.getPcMode() + ","
			+ "Tvvd:"+prdMainInfoVO.getTVvd()     + ","
			+ "R/D:"+prdMainInfoVO.getRcvT() + "/"+prdMainInfoVO.getDelT() + "\n"
			+ "por:"+prdMainInfoVO.getPor()  + "["+prdMainInfoVO.getPorN() + "],"
			+ "pol:"+prdMainInfoVO.getPol()  + "["+prdMainInfoVO.getPolN() + "],"
			+ "pod:"+prdMainInfoVO.getPod()  + "["+prdMainInfoVO.getPodN() + "],"
			+ "del:"+prdMainInfoVO.getDel()  + "["+prdMainInfoVO.getDelN() + "]";
		if((prdMainInfoVO.getOrgTrnsMode().trim() + prdMainInfoVO.getDestTrnsMode()).trim().length()>0){
			prdLog = prdLog + "\ntrns:["+prdMainInfoVO.getOrgTrnsMode() + "/"+prdMainInfoVO.getDestTrnsMode()+ "]";
		}

		if((prdMainInfoVO.getMtPkupDt().trim() + prdMainInfoVO.getMPu().trim() + prdMainInfoVO.getFRt().trim()).length()>0){
			prdLog = prdLog + "\npkDt:["+prdMainInfoVO.getMtPkupDt()    + "],m_up:["+prdMainInfoVO.getMPu()  + "],f_rt:["+prdMainInfoVO.getFRt()  + "]";
		}
		
		if(prdMainInfoVO.getPol1()!=null && prdMainInfoVO.getPod1()!=null && prdMainInfoVO.getVvd1()!=null &&
			(prdMainInfoVO.getPol1().trim() + prdMainInfoVO.getPod1().trim() + prdMainInfoVO.getVvd1().trim()).length()>0){
			prdLog = prdLog + "\n"
							+ "pol1:"+prdMainInfoVO.getPol1() + "["+prdMainInfoVO.getPol1N() + "]["+prdMainInfoVO.getPol1C() + "],"  
							+ "pod1:"+prdMainInfoVO.getPod1() + "["+prdMainInfoVO.getPod1N() + "]["+prdMainInfoVO.getPod1C() + "],"
							+ "vvd1:"+prdMainInfoVO.getVvd1() + "["+prdMainInfoVO.getLane1() + "]";
		}
		if(prdMainInfoVO.getPol2()!=null && prdMainInfoVO.getPod2()!=null && prdMainInfoVO.getVvd2()!=null &&
				(prdMainInfoVO.getPol2().trim() + prdMainInfoVO.getPod2().trim() + prdMainInfoVO.getVvd2().trim()).length()>0){			
			prdLog = prdLog + "\n"
							+ "pol2:"+prdMainInfoVO.getPol2() + "["+prdMainInfoVO.getPol2N() + "]["+prdMainInfoVO.getPol2C() + "],"
							+ "pod2:"+prdMainInfoVO.getPod2() + "["+prdMainInfoVO.getPod2N() + "]["+prdMainInfoVO.getPod2C() + "],"
							+ "vvd2:"+prdMainInfoVO.getVvd2() + "["+prdMainInfoVO.getLane2() + "]";
		}
		if(prdMainInfoVO.getPol3()!=null && prdMainInfoVO.getPod3()!=null && prdMainInfoVO.getVvd3()!=null &&
				(prdMainInfoVO.getPol3().trim() + prdMainInfoVO.getPod3().trim() + prdMainInfoVO.getVvd3().trim()).length()>0){	
			prdLog = prdLog + "\n"
							+ "pol3:"+prdMainInfoVO.getPol3() + "["+prdMainInfoVO.getPol3N() + "]["+prdMainInfoVO.getPol3C() + "],"
							+ "pod3:"+prdMainInfoVO.getPod3() + "["+prdMainInfoVO.getPod3N() + "]["+prdMainInfoVO.getPod3C() + "],"
							+ "vvd3:"+prdMainInfoVO.getVvd3() + "["+prdMainInfoVO.getLane3() + "]";
		}
		if(prdMainInfoVO.getPol4()!=null && prdMainInfoVO.getPod4()!=null && prdMainInfoVO.getVvd4()!=null &&
				(prdMainInfoVO.getPol4().trim() + prdMainInfoVO.getPod4().trim() + prdMainInfoVO.getVvd4().trim()).length()>0){	
			prdLog = prdLog + "\n"
							+ "pol4:"+prdMainInfoVO.getPol4() + "["+prdMainInfoVO.getPol4N() + "]["+prdMainInfoVO.getPol4C() + "],"
							+ "pod4:"+prdMainInfoVO.getPod4() + "["+prdMainInfoVO.getPod4N() + "]["+prdMainInfoVO.getPod4C() + "],"
							+ "vvd4:"+prdMainInfoVO.getVvd4() + "["+prdMainInfoVO.getLane4() + "]";
		}
		if(prdMainInfoVO.getFlexHgtFlg() != null) {
			prdLog = prdLog + "\n"
			                + "flexHgtFlg:"+prdMainInfoVO.getFlexHgtFlg();
		}

		log.error(prdLog);
	}
	
   	/**
	 * bkg -> vvd, port results ->close <br>
	 * close: retrieve to information to be included in the notice.<br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ofcCd
	 * @return BkgCloseVO
	 * @exception EventException
	 */	
	public BkgCloseVO searchBkgClose(BkgBlNoVO bkgBlNoVO, String ofcCd) throws EventException{
		try {
            return dbDao.searchBkgClose(bkgBlNoVO, ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Run hard Query and verify the results by performing(ESM_BKG_0000.do).<br>
	 * 
	 * @param  String  sql
	 * @return String
	 * @throws EventException
	 */
	public String  executeQuery(String sql)  throws EventException{
		try {
			return dbDao.executeQuery(sql);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
			//throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
			//throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * user :Verify that the office of bkg <br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchOfcVsBkgOfc(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		try{
			if(dbDao.searchOfcVsBkgOfc(bkgBlNoVO, account)){
				throw new EventException((String)new ErrorHandler("BKG02009").getMessage());
			} else {
				return true;
			}
		} catch(EventException se) {
			throw se;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * bkg  pol service group id retrieve( server id)<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPolSvcByBkgNo(BkgBlNoVO bkgBlNoVO)  throws EventException{
		try{
			return dbDao.searchPolSvrByBkgNo(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
    
	/**
     * DEM.DET modules and I / F is a combination of information
     * @param chargeByBookingCustomerGrpVO
     * @return dmtChargeVO
     * @throws EventException
     */
	@SuppressWarnings("unchecked")
	public DmtChargeVO searchChargeByCustomer(ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO)throws EventException {

		List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
		DmtChargeVO dmtChargeVO = new DmtChargeVO();
         //Sum of the left(
        List<ChargeByBookingCustomerCntrVO> cntrVOList = new ArrayList<ChargeByBookingCustomerCntrVO>();
        
        //Sum of the right
        List<ChargeByBookingCustomerInvVO> invVOList = new ArrayList<ChargeByBookingCustomerInvVO>();

        Iterator iterator  = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().iterator();
        Iterator iterator2 = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().iterator();


        Map map  = new HashMap();
        Map map2 = new HashMap();

        while (iterator.hasNext()) {
            ChargeByBookingCustomerCntrVO cntrVO = (ChargeByBookingCustomerCntrVO) iterator.next();

            log.debug("------------------------- cntrVO1   "+cntrVO.getColumnValues());

            cntrVO.setCurrCd(cntrVO.getBzcTrfCurrCd());

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map.containsKey(cntrVO.getCurrCd())){
                map.put(cntrVO.getCurrCd(),0);
            }

            map.put(cntrVO.getCurrCd(),Float.parseFloat(cntrVO.getBilAmt()) + Float.parseFloat(map.get(cntrVO.getCurrCd()).toString()));
            cntrVOList.add(cntrVO);
        }
        dmtChargeVO.setChargeByBookingCustomerCntrVOS(cntrVOList);

        while (iterator2.hasNext()) {
            ChargeByBookingCustomerInvVO cntrVO = (ChargeByBookingCustomerInvVO) iterator2.next();

			log.debug("------------------------- cntrVO2   "+cntrVO.getColumnValues());

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map2.containsKey(cntrVO.getInvCurrCd())){
                map2.put(cntrVO.getInvCurrCd(),0);
            }
            if(cntrVO.getDmdtArIfCd() != null && cntrVO.getDmdtArIfCd().equals("Y")){
                map2.put(cntrVO.getInvCurrCd(),Float.parseFloat(cntrVO.getBilAmt()) + Float.parseFloat(map2.get(cntrVO.getInvCurrCd()).toString()));
                invVOList.add(cntrVO);
            }
        }
        
		dmtChargeVO.setChargeByBookingCustomerInvVOS(invVOList);

		log.debug("-------------------------- left " + map);
        log.debug("-------------------------- right " + map2);

        Set a = map.keySet();
        Iterator b = a.iterator();
        while(b.hasNext()){
            String currCd = (String) b.next();

            ToTBilAmtVO bilAmtVo = new ToTBilAmtVO();
            log.debug("-------------------- currCd "+ currCd);
            if(currCd == null || currCd.equals("")){
            	bilAmtVo.setCurrCd("");
            }else{
            	bilAmtVo.setCurrCd(currCd);
            }
            
            float leftSum = 0;
            float rightSum = 0;
            if(map.containsKey(currCd) && map.get(currCd) != null){
                leftSum = Float.parseFloat(map.get(currCd).toString());
            }
            if(map2.containsKey(currCd) && map2.get(currCd) != null){
                rightSum = Float.parseFloat(map2.get(currCd).toString());
            }
            bilAmtVo.setTotBilAmt("" + (leftSum - rightSum));
            log.debug("---------- bilAmtVo "+ bilAmtVo.getColumnValues());
            bilAmtVOList.add(bilAmtVo);

        }
        //BILL AMT add
        dmtChargeVO.setBilAmtVOList(bilAmtVOList);

        //DemType
        log.debug("------------ setDemurType " + chargeByBookingCustomerGrpVO.getDemurType());
        dmtChargeVO.setDemurType(chargeByBookingCustomerGrpVO.getDemurType());
        return dmtChargeVO;
    }
	

	/**
	 * Route change Route information retrieve.(ESM_BKG_0079_01)<br>
	 *
	 * @author 	
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException
	 */
	public PrdParameterVO findFullRoute(BookingCreationVO bookingCreationVO) throws EventException {
		PrdParameterVO schPrdParameterVO = null;
		try{			
			// PrdMainInfoVO Set
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
			VslSkdVO[] vslSkdVOs = bookingCreationVO.getVslSkdVOs();
			PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
			
			// bkg route
			prdMainInfoVO.setRcvT(bkgBookingInfoVO.getRcvTermCd());
			prdMainInfoVO.setDelT(bkgBookingInfoVO.getDeTermCd());
			prdMainInfoVO.setPor(bkgBookingInfoVO.getBkgPorCd());
			if(bkgBookingInfoVO.getBkgPorYdCd() != null && bkgBookingInfoVO.getBkgPorYdCd().length() > 0){
				prdMainInfoVO.setPorN(bkgBookingInfoVO.getBkgPorCd()+bkgBookingInfoVO.getBkgPorYdCd());
			}else{
				prdMainInfoVO.setPorN(null);
			}
			
			prdMainInfoVO.setPol(bkgBookingInfoVO.getBkgPolCd());
			if(bkgBookingInfoVO.getBkgPolYdCd() != null && bkgBookingInfoVO.getBkgPolYdCd().length() > 0){
				prdMainInfoVO.setPolN(bkgBookingInfoVO.getBkgPolCd()+bkgBookingInfoVO.getBkgPolYdCd());
			}else{
				prdMainInfoVO.setPolN(null);
			}			
			prdMainInfoVO.setPod(bkgBookingInfoVO.getBkgPodCd());
			if(bkgBookingInfoVO.getBkgPodYdCd() != null && bkgBookingInfoVO.getBkgPodYdCd().length() > 0){
				prdMainInfoVO.setPodN(bkgBookingInfoVO.getBkgPodCd()+bkgBookingInfoVO.getBkgPodYdCd());
			}else{
				prdMainInfoVO.setPodN(null);
			}						
			prdMainInfoVO.setDel(bkgBookingInfoVO.getBkgDelCd());
			if(bkgBookingInfoVO.getBkgDelYdCd() != null && bkgBookingInfoVO.getBkgDelYdCd().length() > 0){
				prdMainInfoVO.setDelN(bkgBookingInfoVO.getBkgDelCd()+bkgBookingInfoVO.getBkgDelYdCd());
			}else{
				prdMainInfoVO.setDelN(null);
			}							
			prdMainInfoVO.setTVvd(bkgBookingInfoVO.getBkgTrunkVvd());

			//t/s route
			if(vslSkdVOs != null && vslSkdVOs.length > 0){
				prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());				
				prdMainInfoVO.setLane1(null);				
				prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
				prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
				if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
				}else{
					prdMainInfoVO.setPol1N(null);
				}
				prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
				prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
				if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
				}else{
					prdMainInfoVO.setPod1N(null);
				}						
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 1);					
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 1){
				prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
				prdMainInfoVO.setLane2(null);				
				prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
				prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
				if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
				}else{
					prdMainInfoVO.setPol2N(null);
				}					
				prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
				prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
				if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
				}else{
					prdMainInfoVO.setPod2N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 2);				
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 2){
				prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
				prdMainInfoVO.setLane3(null);				
				prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
				prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
				if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
				}else{
					prdMainInfoVO.setPol3N(null);
				}					
				prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
				prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
				if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
				}else{
					prdMainInfoVO.setPod3N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 3);			
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 3){
				prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
				prdMainInfoVO.setLane4(null);				
				prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
				prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
				if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
				}else{
					prdMainInfoVO.setPol4N(null);
				}				
				prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
				prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
				if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
				}else{
					prdMainInfoVO.setPod4N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 4);				
			}		
		
			if(bkgBookingInfoVO.getLodgDueDt() != null){
				prdMainInfoVO.setLdDt(bkgBookingInfoVO.getLodgDueDt().replaceAll("-", ""));
			}		
			if(bkgBookingInfoVO.getMtyDorArrDt() != null){
				prdMainInfoVO.setDrDt(bkgBookingInfoVO.getMtyDorArrDt().replaceAll("-", ""));
			}		
			if(bkgBookingInfoVO.getMtyPkupDt() != null){
				prdMainInfoVO.setMtPkupDt(bkgBookingInfoVO.getMtyPkupDt().replaceAll("-", ""));
			}					
			prdMainInfoVO.setMPu(bkgBookingInfoVO.getMtyPkupYdCd());
			prdMainInfoVO.setFRt(bkgBookingInfoVO.getFullRtnYdCd());
			
			if(bkgBookingInfoVO.getOrgTrnsModCd()==null||bkgBookingInfoVO.getOrgTrnsModCd().length()<1){
				prdMainInfoVO.setOrgTrnsMode("X");
			} else {
				prdMainInfoVO.setOrgTrnsMode(bkgBookingInfoVO.getOrgTrnsModCd());
			}
			if(bkgBookingInfoVO.getDestTrnsModCd()==null||bkgBookingInfoVO.getDestTrnsModCd().length()<1){
				prdMainInfoVO.setDestTrnsMode("X");
			} else {
				prdMainInfoVO.setDestTrnsMode(bkgBookingInfoVO.getDestTrnsModCd());
			}
			if(bkgBookingInfoVO.getBkgCgoTpCd() != null){
				prdMainInfoVO.setCgoTp(bkgBookingInfoVO.getBkgCgoTpCd());
			}else{
				prdMainInfoVO.setCgoTp("N");
			}
			if(bkgBookingInfoVO.getHotDeFlg() != null){
				prdMainInfoVO.setPmF(bkgBookingInfoVO.getHotDeFlg());
			}else{
				prdMainInfoVO.setPmF("N");
			}			
			if(bkgBookingInfoVO.getDcgoFlg() != null){
				prdMainInfoVO.setDgF(bkgBookingInfoVO.getDcgoFlg());
			}else{
				prdMainInfoVO.setDgF("N");
			}					
			if(bkgBookingInfoVO.getRcFlg() != null){
				prdMainInfoVO.setRfF(bkgBookingInfoVO.getRcFlg());
			}else{
				prdMainInfoVO.setRfF("N");
			}					
			if(bkgBookingInfoVO.getAwkCgoFlg() != null){
				prdMainInfoVO.setAkF(bkgBookingInfoVO.getAwkCgoFlg());
			}else{
				prdMainInfoVO.setAkF("N");
			}					
			if(bkgBookingInfoVO.getBbCgoFlg() != null){
				prdMainInfoVO.setBbF(bkgBookingInfoVO.getBbCgoFlg());
			}else{
				prdMainInfoVO.setBbF("N");
			}					
			prdMainInfoVO.setRdF(bkgBookingInfoVO.getRdCgoFlg());
			prdMainInfoVO.setSocF(bkgBookingInfoVO.getSocFlg());
			prdMainInfoVO.setCom(bkgBookingInfoVO.getCmdtCd());
			prdMainInfoVO.setRepCom(bkgBookingInfoVO.getRepCmdtCd());
			prdMainInfoVO.setBkgOfc(bkgBookingInfoVO.getBkgOfcCd());
			prdMainInfoVO.setOrgSalOfc(bkgBookingInfoVO.getObSlsOfcCd());
			prdMainInfoVO.setRfa(bkgBookingInfoVO.getRfaNo());
			prdMainInfoVO.setSc(bkgBookingInfoVO.getScNo());
			prdMainInfoVO.setShpr(blCustomerInfoVO.getSCustCntCd()+blCustomerInfoVO.getSCustSeq());
			prdMainInfoVO.setCngn(blCustomerInfoVO.getCCustCntCd()+blCustomerInfoVO.getCCustSeq());
			prdMainInfoVO.setWgt(bkgBookingInfoVO.getActWgt());
			prdMainInfoVO.setWgtUn(bkgBookingInfoVO.getWgtUtCd());
			prdMainInfoVO.setHgF(bkgBookingInfoVO.getHngrFlg());
			prdMainInfoVO.setSubF(bkgBookingInfoVO.getEqSubstFlg());
			prdMainInfoVO.setFlexHgtFlg("Y".equals(bkgBookingInfoVO.getFlexHgtFlg())?"Y":"N");

			if(bookingCreationVO.getBkgBlNoVO().getBkgNo()==null||bookingCreationVO.getBkgBlNoVO().getBkgNo().length()==0){
				prdMainInfoVO.setBkgNo("");				
			} else {
				BkgBlNoVO schBkg = searchBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
				if(schBkg!=null){
					prdMainInfoVO.setBkgNo(bkgBookingInfoVO.getBkgNo());					
				} else {				
					prdMainInfoVO.setBkgNo("");
				}
			}
			
			// PrdQuantityVO Set
			List<PrdQtyInfoVO> prdQtyInfo 	= new ArrayList<PrdQtyInfoVO>();
			
			BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
			for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
				PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
				
				prdQtyInfoVO.setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
				prdQtyInfoVO.setCQty(bkgQuantityVOs[i].getOpCntrQty());
				
				prdQtyInfo.add(prdQtyInfoVO);
			}
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();			
			prdParameterVO.setPrdQtyInfo(prdQtyInfo);
			prdParameterVO.setBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			
			// f_cmd,pc_mode Set
			prdParameterVO.getPrdMainInfoVO().setFCmd("3");

			// 01. searchPrdParameter
			schPrdParameterVO = searchPrdParmForFullRoute(prdParameterVO);

//			schPrdParameterVO.getPrdMainInfoVO().setBkgNo(bkgBookingInfoVO.getBkgNo());
			if(schPrdParameterVO.getPrdMainInfoVO().getBkgNo() != null && schPrdParameterVO.getPrdMainInfoVO().getBkgNo().length() > 0){
				// split, tro, copy need separator
				schPrdParameterVO.getPrdMainInfoVO().setPcMode("R");
			}else{
				schPrdParameterVO.getPrdMainInfoVO().setPcMode("B");
			}
			
			// retrieve  
			if(vslSkdVOs != null && vslSkdVOs.length > 0){
				schPrdParameterVO.getPrdMainInfoVO().setVvd1(vslSkdVOs[0].getBkgVvdCd());				
				schPrdParameterVO.getPrdMainInfoVO().setLane1(null);				
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 1));				
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 1){
				schPrdParameterVO.getPrdMainInfoVO().setVvd2(vslSkdVOs[1].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane2(null);				
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 2));					
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 2){
				schPrdParameterVO.getPrdMainInfoVO().setVvd3(vslSkdVOs[2].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane3(null);				
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 3));						
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 3){
				schPrdParameterVO.getPrdMainInfoVO().setVvd4(vslSkdVOs[3].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane4(null);				
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 4));					
			}		
			
			if(bkgBookingInfoVO.getBkgPorYdCd() == null || bkgBookingInfoVO.getBkgPorYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPorN(null);
			}
			if(bkgBookingInfoVO.getBkgPolYdCd() == null || bkgBookingInfoVO.getBkgPolYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPolN(null);				
			}
			if(bkgBookingInfoVO.getBkgPodYdCd() == null || bkgBookingInfoVO.getBkgPodYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPodN(null);
			}
			if(bkgBookingInfoVO.getBkgDelYdCd() == null || bkgBookingInfoVO.getBkgDelYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setDelN(null);
			}
			if(bkgBookingInfoVO.getBkgTrunkVvd() == null || bkgBookingInfoVO.getBkgTrunkVvd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setTVvd(null);
			}
//			schPrdParameterVO.getPrdMainInfoVO().setOrgTrnsMode(null);
//			schPrdParameterVO.getPrdMainInfoVO().setDestTrnsMode(null);
			
			
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return schPrdParameterVO;
	}
	/**
	 * Route initialization process<br>
	 * @param 	PrdMainInfoVO prdMainInfoVO
	 * @param 	int i
	 * @return 	PrdMainInfoVO
	 */
	public PrdMainInfoVO resetNthRoute(PrdMainInfoVO prdMainInfoVO, int i){
		if(i==1){
			prdMainInfoVO.setPod1(null);
			prdMainInfoVO.setPod1N(null);
			prdMainInfoVO.setPod1C(null);
			prdMainInfoVO.setPol1(null);
			prdMainInfoVO.setPol1N(null);
			prdMainInfoVO.setPol1C(null);
			prdMainInfoVO.setVvd1(null);
			prdMainInfoVO.setLane1(null);			
		} else if(i==2){
			prdMainInfoVO.setPod2(null);
			prdMainInfoVO.setPod2N(null);
			prdMainInfoVO.setPod2C(null);
			prdMainInfoVO.setPol2(null);
			prdMainInfoVO.setPol2N(null);
			prdMainInfoVO.setPol2C(null);
			prdMainInfoVO.setVvd2(null);
			prdMainInfoVO.setLane2(null);			
		} else if(i==3){
			prdMainInfoVO.setPod3(null);
			prdMainInfoVO.setPod3N(null);
			prdMainInfoVO.setPod3C(null);
			prdMainInfoVO.setPol3(null);
			prdMainInfoVO.setPol3N(null);
			prdMainInfoVO.setPol3C(null);
			prdMainInfoVO.setVvd3(null);
			prdMainInfoVO.setLane3(null);
			
		} else if(i==4){
			prdMainInfoVO.setPod4(null);
			prdMainInfoVO.setPod4N(null);
			prdMainInfoVO.setPod4C(null);
			prdMainInfoVO.setPol4(null);
			prdMainInfoVO.setPol4N(null);
			prdMainInfoVO.setPol4C(null);
			prdMainInfoVO.setVvd4(null);
			prdMainInfoVO.setLane4(null);
		}
		return prdMainInfoVO;
	}
	
	/**
	 * Bkg Close -> output-mail message body<br>
	 *
	 * @author 	
	 * @param 	String[] strParam
	 * @param 	String msgType
	 * @return 	String
	 * @exception Exception
	 */
	public String makeBkgCloseMsg(String[] strParam, String msgType) throws Exception {
/*		
 		1. strParam
 		   1) msgType : B
 		    - strParam[0] : BkgNo
 		    - strParam[1] : PreVvd
 		    - strParam[2] : PrePolCd
 		    - strParam[3] : PrePodCd
 		    - strParam[4] : PreQtyVol
 		    - strParam[5] : PreCntrList
 		    - strParam[6] : NewVvd
 		    - strParam[7] : NewPolCd
 		    - strParam[8] : NewPodCd
 		    - strParam[9] : NewQtyVol
 		    - strParam[10] : NewCntrList
		2. msgType
		    - 'B' : Booking Create,Modify,Cancel
		 	- 'S' : Split
		 	- 'C' : Container
*/		 
		String closeBkgMsg = "";
		try{			
			if("B".equals(msgType)){
//				closeBkgMsg = "Below booking has been created(canceled or changed) after booking closing.<br>";	
				
//				closeBkgMsg = closeBkgMsg + "Please check the change and DO NOT FORGET TO UPDATE STOWAGE PLAN.<br><br>";
				closeBkgMsg = closeBkgMsg + "BKG No : ";
				if(strParam[0] != null && strParam[0].length() > 0){
					String[] bkgArr = splitByToken(strParam[0], ",");
					if(bkgArr.length < 5){
						closeBkgMsg = closeBkgMsg + strParam[0];
					}else{
						for(int i = 0 ; i < bkgArr.length ; i++){
							if(i < 1){
								closeBkgMsg = closeBkgMsg + bkgArr[i];
							}else{
								if(i%4 < 1){
									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + bkgArr[i];
								}else{
									closeBkgMsg = closeBkgMsg + "," + bkgArr[i];
								}
							}
						}
					}					
				}				
				//20100222 mail body modify
//				closeBkgMsg = closeBkgMsg + "<br><br>";
//				closeBkgMsg = closeBkgMsg + "[Previous]<br>";
//				closeBkgMsg = closeBkgMsg + "1st VVD : " + strParam[1] + "<br>";
//				closeBkgMsg = closeBkgMsg + "1st VVD POL / POD : " + strParam[2] + " / " + strParam[3] + "<br>";
//				closeBkgMsg = closeBkgMsg + "BKG Vol : " + strParam[4] + "<br>";
//				closeBkgMsg = closeBkgMsg + "CNTR No : ";
//				if(strParam[5] != null && strParam[5].length() > 0){
//					String[] preCntrArr = splitByToken(strParam[5], ",");
//					if(preCntrArr.length < 6){
//						closeBkgMsg = closeBkgMsg + strParam[5];
//					}else{
//						for(int i = 0 ; i < preCntrArr.length ; i++){
//							if(i < 1){
//								closeBkgMsg = closeBkgMsg + preCntrArr[i];
//							}else{
//								if(i%5 < 1){
//									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + preCntrArr[i];
//								}else{
//									closeBkgMsg = closeBkgMsg + "," + preCntrArr[i];
//								}
//							}
//						}
//					}
//				}
				closeBkgMsg = closeBkgMsg + "<BR>";			
//				closeBkgMsg = closeBkgMsg + "[Current]<br>";
				closeBkgMsg = closeBkgMsg + "Current VVD : " + strParam[6] + "<BR>";
				closeBkgMsg = closeBkgMsg + "Current ROUTE : " + strParam[7] + "<BR>";
//				closeBkgMsg = closeBkgMsg + "Current Vol : " + strParam[9] + "<br>";
				closeBkgMsg = closeBkgMsg + "Current CNTR No : ";
				if(strParam[10] != null && strParam[10].length() > 0){
					String[] newCntrArr = splitByToken(strParam[10], ",");
					if(newCntrArr.length < 6){
						closeBkgMsg = closeBkgMsg + strParam[10];
					}else{
						for(int i = 0 ; i < newCntrArr.length ; i++){
							if(i < 1){
								closeBkgMsg = closeBkgMsg + newCntrArr[i];
							}else{
								if(i%5 < 1){
									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + newCntrArr[i];
								}else{
									closeBkgMsg = closeBkgMsg + "," + newCntrArr[i];
								}
							}
						}
					}
				} else {
					closeBkgMsg = closeBkgMsg + "<BR>";
				}
				
				closeBkgMsg = closeBkgMsg + "Changes : <br><br><br>";	
				closeBkgMsg = closeBkgMsg + "Above booking has been changed. Please DO NOT FORGET TO UPDATE STOWAGE PLAN ACCORDINGLY.<BR>";
				closeBkgMsg = closeBkgMsg + "<br><br>";						
			}			
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw ex;			
		}
		return closeBkgMsg;
	}	
	
	/**
	 * Determine whether there has been a change in Quantity<br>
	 *
	 * @author 	
	 * @param 	List<BkgQuantityVO> oldBkgQuantity
	 * @param 	BkgQuantityVO[] newBkgQuantity
	 * @return 	boolean
	 * @exception Exception
	 */
	public boolean isChangeQty(List<BkgQuantityVO> oldBkgQuantity, BkgQuantityVO[] newBkgQuantity) throws Exception {
		boolean isQtyChange = false;
		try{			
			// Quantity retrieve before the change
			int oldQtyCnt = oldBkgQuantity.size();
			if(oldQtyCnt != newBkgQuantity.length){
				isQtyChange = true;
			}else{
				boolean isQtyUp = false;
				for(int j = 0 ; j < newBkgQuantity.length ; j++){
					int newCntrCnt = 0;
					for(int k = 0 ; k < oldQtyCnt ; k++){
						if(newBkgQuantity[j].getCntrTpszCd().equals(oldBkgQuantity.get(k).getCntrTpszCd()) ){									
							if(Float.compare(Float.parseFloat(newBkgQuantity[j].getOpCntrQty()), Float.parseFloat(oldBkgQuantity.get(k).getOpCntrQty())) != 0){
								// Same Cntr  Qty is changed 
								isQtyUp = true;
								break;
							}
						}else{
							newCntrCnt = newCntrCnt + 1;
						}
					}
					// New Cntr
					if(oldQtyCnt == newCntrCnt){
						isQtyUp = true;
					}
					if(isQtyUp){
						break;
					}
				}
				if(isQtyUp){
					isQtyChange = true;
				}											
			}		
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw ex;			
		}
		return isQtyChange;
	}		

    /**
     *  Since U.S.Customs download VVD, POD, DEL change.(ESM_BKG_0079_01) <br>
     *
     * @author      
     * @param       BkgBlNoVO bkgBlNoVO
     * @return      boolean
     * @exception   EventException
     */
    public boolean searchUsaCstmsDownload(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchUsaCstmsDownload(bkgBlNoVO);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
    }
    
    /**
	 * BKG_CHN_AGN table CHN_AGN_CD retrieve  <br>
	 * 
	 * @param String chnAgnCd
	 * @param String delIncFlag
	 * @return String
	 * @exception EventException
	 */
	public String checkChnAgnCd(String chnAgnCd,String delIncFlag) throws EventException {
		try {
            return dbDao.checkChnAgnCd(chnAgnCd,delIncFlag);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
	}    

    
	/**
	 * Using  local agent in China  Area  retrieve.(ESM_BKG_0079, 0229)<br>
	 *
	 * @author 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchChnAgtUse(String usrId) throws EventException {
		try {
			return dbDao.searchChnAgtUse(usrId);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Booking route information retrieve.(ESM_BKG_0079_07, 0178)<br>
	 *
	 * @author Jeon Sungjin
	 * @param String bkgNo
	 * @return BkgRouteVO
	 * @exception EventException
	 */
	public BkgRouteVO searchBkgRoute(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgRoute(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Cc email address function<br>
	 * @param String ntc_knd_cd
	 * @param String usr_id
	 * @return String output_text
	 * @exception EventException
	 */
	public String searchCcEmailAddrRSQL(String ntc_knd_cd, String usr_id) throws EventException {
		try {
			return dbDao.searchCcEmailAddrRSQL( ntc_knd_cd,  usr_id);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
    /**
     *Search conditions: VVD , result :VSL_NM retrieve.<br>
     * @author 	
     * @param  	String bkgNo
     * @return 	String
     * @throws EventException
     */
    public String searchFrtTerm(String bkgNo) throws EventException {
        try {
            return dbDao.searchFrtTerm(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * 
     * @param bkgNo
     * @return
     * @throws EventException
     */
    public String searchBlPrfShprFlg(String bkgNo) throws EventException {
        try {
            return dbDao.searchBlPrfShprFlg(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * European tro-> search whether issue is s /o.<br>
     * @author 	
     * @param  	BkgBlNoVO bkgBlNoVO
     * @return 	String
     * @throws EventException
     */
	public String searchCtmSoStatus(BkgBlNoVO bkgBlNoVO) throws EventException {
    	String rtn;
    	// carrier haulage  unconfirm handling
    	try {
	        rtn = dbDao.searchCtmSoStatus(bkgBlNoVO.getBkgNo());
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}
	
    /**
     * VVD  service type code retrieve (cca feeder).<br>
     * @author 	
     * @param  	String vvd
     * @return 	String
     * @throws EventException
     */
	public String searchVslSvcTpCd(String vvd) throws EventException {
    	String rtn;
    	try {
	        rtn = dbDao.searchVslSvcTpCd(vvd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}
	
    /**
     * word wrap feature.<br>
     * @author 	
     * @param  	String word
     * @param   int length
     * @return 	String
     */
	@SuppressWarnings("unused")
	public String makeWordWrap(String word, int length){
		String rtn = "";
		String orgWord = word;
		try{
			int stopIdx = 0;
			int position = 0;
			String line = "";
			while(true){
				stopIdx++;
				if(stopIdx > 10000){
					break;
				}
				if(word.length() <= length){
					rtn = rtn + word;
					break;
				} else {
					position = 0;
					line = "";
					for(int i = 1; i < length; i++){
						if("\n".equals(word.substring(i-1, i))){
							position = i;
						}
					}
					if(position == 0){
						line = word.substring(0, length + 1);
						for(int i = length + 1; i>0; i--){						
							if(" ".equals(word.substring(i-1, i)) || "\n".equals(word.substring(i-1, i))){
								position = i;
								i = 0;
							}
						}
					}
					if(position == 0){
						rtn = rtn + word.substring(0, length) + "\n";
						word = word.substring(length);
					} else {
						rtn = rtn + word.substring(0, position - 1) + "\n";
						word = word.substring(position);
					}
				}				
			}
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			return orgWord;
		}
		return rtn;
	}
		
    /**
     * VVD  service type code retrieve(cca feeder).<br>
     * @author 	Jeon Sung Jin
     * @param  	String cnt_cd
     * @param  	String ste_cd
     * @return 	List<String>
     * @throws EventException
     */
	public List<String> searchStateByCountry(String cnt_cd, String ste_cd) throws EventException {
    	List<String> rtn;
    	try {
	        rtn = dbDao.searchStateByCountry(cnt_cd, ste_cd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}

    /**
     * searchDocProcSkd<br>
     * @param BkgDocProcSkdVO bkgDocProcSkdVO
     * @param String caFlg
     * @return BkgDocProcSkdVO
     * @throws EventException
     */
    public BkgDocProcSkdVO searchDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO,String caFlg) throws EventException {
        try {
            return dbDao.searchDocProcSkd(bkgDocProcSkdVO,caFlg);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * bkg: going to the NL area whether search <br>
     * @param BkgBlNoVO BkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchNlFlagByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
            return dbDao.searchNlFlagByBkg(bkgBlNoVO);
        } catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * LloydNo VSL_CD retrieve <br>
	 * @param lloydNo String
	 * @param skdVoyNo String
	 * @param skdDirCd String
	 * @return String
	 * @throws EventException
	 */
	public String searchVslCdByLloydNo(String lloydNo, String skdVoyNo, String skdDirCd) throws EventException {
		try {
            return dbDao.searchVslCdByLloydNo(lloydNo, skdVoyNo, skdDirCd);
        } catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * searchMdmVslSvcLane  Event Handling<br>
	 * @param String slanCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmVslSvcLane(String slanCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchMdmVslSvcLane(slanCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 

	
	/**
	 * searchMdmLocPortName  Event Handling<br>
	 * @param String portCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmLocPortName(String portCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchMdmLocPortName(portCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 

	/**
	 * searchComUserInfo  Event Handling<br>
	 * @param String usrID
	 * @return String
	 * @exception EventException
	 */
	public ComUserVO searchComUserInfo(String usrID) throws EventException{
		ComUserVO comUserVo = null;
		try {
			comUserVo = dbDao.searchComUserInfo(usrID);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return comUserVo ;
	}

   	/**
	 * If CBF, the bkg retrieve in the information to be included  notice .<br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgCloseVO
	 * @exception EventException
	 */	
	public BkgCloseVO searchBkgCbf(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
            return dbDao.searchBkgCbf(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * Common combo list retrieve<br>
	 *
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchMdmCntrTpSz() throws EventException {
        try {
            return dbDao.searchMdmCntrTpSz();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

   	/**
	 * searchOfcChgProc<br>
	 * 
	 * @param OfcChgProcVO ofcChgProcVO
	 * @return OfcChgProcVO
	 * @exception EventException
	 */	
	public OfcChgProcVO searchOfcChgProc(OfcChgProcVO ofcChgProcVO) throws EventException{
		try {
            return dbDao.searchOfcChgProc(ofcChgProcVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * seacrhDocPerformanceUserCheck  Event Handling<br>
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String seacrhDocPerformanceUserCheck(String usrId) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.seacrhDocPerformanceUserCheck(usrId);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	
	/**
     * MDM Country code combo list retrieve<br>
	 *
     * @return List<MdmCountryVO>
     * @exception EventException
     */
    public List<MdmCountryVO> searchMdmCnt() throws EventException {
        try {
            return dbDao.searchMdmCnt();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

	/**
	 * Black Customer Check<br>
	 * @param String custNm
	 * @return String
	 * @throws EventException
	 */
	public String checkIranBlackCustomer (String custNm )throws EventException {
		try {
			return dbDao.checkIranBlackCustomer(custNm);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Package Code retrieve .<br>
	 * @param String pkgNm
	 * @return MdmPckTpVO
	 * @throws EventException
	 */
	public MdmPckTpVO searchPkgTypeByName(String pkgNm)throws EventException {
		try {
			return dbDao.searchPkgTypeByName(pkgNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * State Code retrieve .<br>
	 * @param String steNm
	 * @return MdmStateVO
	 * @throws EventException
	 */
	public MdmStateVO searchSteCodeByName(String steNm)throws EventException {
		try {
			return dbDao.searchSteCodeByName(steNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Customs BKG_CSTMS_CD_CONV_CTNT retrieve.
	 * 
	 * @param BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws DAOException
	 */
	public List<BkgCstmsCdConvCtntVO> searchCstmsCdConv(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) throws EventException {
		try {
			return dbDao.searchCstmsCdConv(bkgCstmsCdConvCtntVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Customs BKG_CSTMS_CD_CONV_CTNT combo list retrieve
	 * 
	 * @param String tagName
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @param String cstmsDivIdSeq
	 * @param String sOptionalSelectTag
	 * @return String
	 * @throws DAOException
	 */
	public String getCstmsCodeCombo(String tagName, String cntCd, String cstmsDivId, String cstmsDivIdSeq) throws EventException {
		return getCstmsCodeCombo(tagName, cntCd, cstmsDivId, cstmsDivIdSeq,"","");
	}
	
	/**
	 * Customs BKG_CSTMS_CD_CONV_CTNT combo list retrieve - Option to add tags
	 * 
	 * @param String tagName
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @param String cstmsDivIdSeq
	 * @param String sOptionalSelectTag
	 * @return String
	 * @throws DAOException
	 */
	public String getCstmsCodeCombo(String tagName, String cntCd, String cstmsDivId, String cstmsDivIdSeq,String sOptionalSelectTag) throws EventException {
		return getCstmsCodeCombo(tagName, cntCd, cstmsDivId, cstmsDivIdSeq,sOptionalSelectTag,"");
	}
	
	/**
	 * Customs BKG_CSTMS_CD_CONV_CTNT combo Generation.
	 * 
	 * @param String tagName
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @param String cstmsDivIdSeq
	 * @param String sOptionalSelectTag
	 * @param String sSelectedCode
	 * @return String
	 * @throws DAOException
	 */
    public String getCstmsCodeCombo(String tagName, String cntCd, String cstmsDivId, String cstmsDivIdSeq, String sOptionalSelectTag, String sSelectedCode) throws EventException {
    	
        BkgCstmsCdConvCtntVO vo = new BkgCstmsCdConvCtntVO();
    	vo.setCntCd(cntCd);
    	vo.setCstmsDivId(cstmsDivId);
    	vo.setCstmsDivIdSeq(cstmsDivIdSeq);
    	List<BkgCstmsCdConvCtntVO> list = searchCstmsCdConv(vo);
    	
	   	StringBuffer sb = new StringBuffer("");
	    sb.append("<SELECT name = \"").append(tagName).append("\" ").append(sOptionalSelectTag).append(">").append("\n");
	
	    for(int i=0; i < list.size(); i++){
	        sb.append("\t<option value='").append(list.get(i).getAttrCtnt1()).append("'");
	        if(sSelectedCode != null){
	        	if(!sSelectedCode.equals(""))
	        		sb.append(sSelectedCode.equals(list.get(i).getAttrCtnt1()) ? " selected " : " ");
	        }
	        
//	        if(sSelectedCode != null && sSelectedCode != "")
//	        	sb.append(sSelectedCode.equals(list.get(i).getAttrCtnt1()) ? " selected " : " ");
	        sb.append(">").append(list.get(i).getAttrCtnt2()).append("</OPTION>\n");
	    }
	    sb.append("</SELECT>");
	    return sb.toString();
    }	
    
    
    
	/**
	 *  Customs BKG_CSTMS_CD_CONV_CTNT combo retrieve : (Multi combo Generation Function)- Use the default delimiter.
	 * 
	 * @param String tagName
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @param String cstmsDivIdSeq
	 * @return String
	 * @throws DAOException
	 */
    public String getCstmsCodeForMultiCombo(String tagName,String cntCd, String cstmsDivId, String cstmsDivIdSeq) throws EventException {
		return getCstmsCodeForMultiCombo(tagName,cntCd, cstmsDivId, cstmsDivIdSeq, "|");
	}
	    
    /**
     * Customs BKG_CSTMS_CD_CONV_CTNT combo retrieve : a value, code  for the Multi combo Generate
     * 
     * @param String tagName
     * @param String cntCd
     * @param String cstmsDivId
     * @param String cstmsDivIdSeq
     * @return String
     * @throws DAOException
     */
    public String getCstmsCodeForMultiCombo(String tagName,String cntCd, String cstmsDivId, String cstmsDivIdSeq, String separator) throws EventException {
    	
    	BkgCstmsCdConvCtntVO vo = new BkgCstmsCdConvCtntVO();
    	vo.setCntCd(cntCd);
    	vo.setCstmsDivId(cstmsDivId);
    	vo.setCstmsDivIdSeq(cstmsDivIdSeq);
    	List<BkgCstmsCdConvCtntVO> list = searchCstmsCdConv(vo);
    	
    	if(list.size() < 1) return "";
    	
    	separator = JSPUtil.getNull(separator,"|");
    	
    	StringBuffer text = new StringBuffer("");
    	text.append("var ").append(tagName).append("Text ='");
    	
    	StringBuffer code =  new StringBuffer("");
    	code.append("var ").append(tagName).append("Code ='");
    	
    	for(int i=0; i < list.size(); i++){
    		if(i > 0){
    			code.append(separator);
    			text.append(separator);
    		}
			code.append(list.get(i).getAttrCtnt1());
			text.append(list.get(i).getAttrCtnt2());
    	}
    	code.append("';\n").append(text.toString()).append("';"); 
    	return code.toString();
    }	
    /**
     * 占쎄텊筌욑옙 揶쏉옙揶쏉옙 疫꿸퀡�뮟.<br>
     * @param  	String StrDate
     * @param   int addDt
     * @return 	String
     */
	public String addDate(String StrDate, int addDt){
		
		int yy = 0;
		int mm = 0;
		int dd = 0;
		String tmData = "";
		String rtn = "";
		try{
			Calendar cal = Calendar.getInstance();
			yy = Integer.parseInt(StrDate.substring(0,4));
			mm = Integer.parseInt(StrDate.substring(4,6));
			dd = Integer.parseInt(StrDate.substring(6,8));	
			tmData = StrDate.substring(8);
			
			cal.set(yy, mm-1, dd);
			cal.add(Calendar.DATE, addDt); 

			yy = cal.get(Calendar.YEAR);
			mm = cal.get(Calendar.MONTH)+1;
			dd = cal.get(Calendar.DATE);
		
			rtn = "" + yy + (mm < 10 ? "0" + mm : mm) + (dd < 10 ? "0" + dd : dd) + tmData;

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
		}
		return rtn;
	}
	
	/**
	 *  ANCS Main Menu �꽴占쏙옙�졃 ESM_BKG_0044,0494,0965,0970 占쎌넅筌롫똻�벥 POD鈺곌퀬�돳<br>
	 *
	 * @author Kim Gyoung-Sub
	 * @param BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO
	 * @return List<BkgCstmsHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgCstmsHrdCdgCtntVO> searchCstmsHardCodingList(BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO)throws EventException{
		
		try {
			return dbDao.searchCstmsHardCodingList(bkgCstmsHrdCdgCtntVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Customs package (customsdeclaration) uses the Flat File Header Generation <br>
	 * 
	 * @author 
	 * @param  String ediNm
	 * @return String 
	 * @throws EventException
	 */
	public String searchCstmsEdiHeaderNew(String ediNm) throws EventException {
	    try {
	    	String strEdiHeader = dbDao.searchCstmsEdiHeaderNew(ediNm);

	    	if ("".equals(strEdiHeader))
	    	{
	    		// 占쎌궎�몴占�
	    		throw new EventException();
	    	}
			log.debug("占쎄쉭�꽴占� EDI HEADER\n" + strEdiHeader);
			
	        return strEdiHeader;
	        
	    } catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG95062", new String[] {}).getMessage());
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 *  return the indicated tag part of e-mail template<br>
	 * 
	 * @author	
	 * @param 	String content, String part
	 * @return  String
	 * @exception 	
	 */
	public String getTemplatePart(String content, String part){
		String retStr = "";
		String startTag = "<" + part + ">";
		String endTag = "</" + part + ">";
		if ((content.indexOf(startTag) != -1) && (content.indexOf(endTag) != -1)) {
			  retStr= content.substring(content.indexOf(startTag) + startTag.length(), content.indexOf(endTag));
			}
		return retStr;
	}

	/**
	 * parseTemplate<br>
	 * retrieving TemplateMail class for preview template email.<br>
	 * 
	 * @author
     * @param String s
     * @param Hashtable<String,String> args
     * @return String
     * @exception Exception
	 */
	public String parseTemplate(String s,Hashtable<String,String> args) throws Exception {
        StringBuffer content = new StringBuffer();
        String remainder;
        int markEndPos;
        for(; s.length() > 0; s = remainder.substring(markEndPos + 1)) {
            int position = s.indexOf("<@");
            if(position == -1) {
                content.append(s);
                break;
            }
            if(position != 0) {
                content.append(s.substring(0, position));
            }
            if (s.length() == position + 2) {
                break;
            }
            remainder = s.substring(position + 2);
            markEndPos = remainder.indexOf(">");
            if(markEndPos == -1) {
                break;
            }
            String argname = remainder.substring(0, markEndPos).trim();
            String value = null;
            value = (String)args.get(argname);
            if (value != null) {
                content.append(value);
            }
            if (remainder.length() == markEndPos + 1) {
                break;
            }
        }
        return content.toString();
    }	
	
	/**
	 * BKG Cancel 占쎄땀占쎌뒠 筌롫뗄�뵬 癰귣�沅→묾占�
	 * @param account
	 * @param recipient ex) addr;addr1;addr2
	 * @param subject
	 * @param templateId
	 * @param args
	 * @param filePath
	 * @throws Exception
	 */
	public void bkgSendMail(SignOnUserAccount account, String recipient, String subject, String templateId, Map<String, String> args, String[] filePath) throws Exception {
		TemplateMail template = null;
		try {
			template = new TemplateMail();
			template.setBatFlg("N");
			/* 癰귣�沅� 占쎄텢占쎌뿺 */
			template.setFrom(account.getUsr_eml(), account.getUsr_nm());
			/* 獄쏆룆�뮉 占쎄텢占쎌뿺 */
			template.setRecipient(recipient);
			/* 筌롫뗄�뵬 占쎌젫筌륅옙 */
			template.setSubject(subject); 
			/* 占쎈�ο옙逾녺뵳占� ID */
			template.setHtmlTemplate(templateId + ".html");
			/* 占쎈솁占쎌뵬沃섎챸苑� 占쎄퐬占쎌젟 */
			if(args != null){
				String[] keys = args.keySet().toArray(new String[0]);
				for (int i = 0; i < keys.length; i++) {
					template.setArg(keys[i], args.get(keys[i]));
				}
			}
			/* 占쎈솁占쎌뵬 筌ｂ뫀占� */
			if(filePath != null){
				List<SingleMailAttachedFile> attachedFileList = new ArrayList<SingleMailAttachedFile>();
				for (int i = 0; i < filePath.length; i++) {
					SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
					attachedFile.setFileLocation(filePath[i]);
					attachedFileList.add(attachedFile);
				}
				template.setAttachedFile(attachedFileList);
			}
			/* 筌롫뗄�뵬 癰귣�沅→묾占� */
			template.send();
		}catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param ofcCd
	 * @return
	 * @throws Exception
	 */
	public MdmOrganizationVO searchMdmOrganization(String ofcCd) throws Exception {
		return dbDao.searchMdmOrganization(ofcCd);
	}
	
	/**
	 * 
	 * @param paramVo
	 * @return
	 * @throws Exception
	 */
	public BkgMdmCustomerVO searchMdmCustomerCode(BkgMdmCustomerVO paramVo)  throws Exception {
		return dbDao.searchMdmCustomerCode(paramVo);
	}
	
    /**
     * MDM Carrier retrieve <br>
     * 
     * @param MdmCarrierVO MdmCarrierVO
     * @return List<MdmCarrierVO>
     * @throws EventException
     * @author SJH.20150114.ADD
	 * 
     */
    public List<MdmCarrierVO> searchCarrier(MdmCarrierVO mdmCarrierVO) throws EventException {
        try {
            return dbDao.searchCarrier(mdmCarrierVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * Japan Stamp Check<br>
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String checkJapanStamp (String bkgNo )throws EventException {
		try {
			return dbDao.checkJapanStamp(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  
	
	/**
	 * E-signature flag search<br>
	 * @param String bkgNo 
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchEsigAgent (String bkgNo )throws EventException {
		try {
			return dbDao.searchEsigAgent(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * CHECKING MDM_CHARGE.CO_CHG_ACCT_CD NULL<br>
	 * @param chgCdList
	 * @return
	 * @throws EventException
	 */
	public List<String> searchChgAcctNull(List<String> chgCdList)throws EventException {
		try {
			return dbDao.searchChgAcctNull(chgCdList);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * AR Batch execute <br>
	 * 
	 * @param String pgmNo
	 * @param String params
	 * @return String
	 * @exception EventException
	 */
	public String executeBatch(String pgmNo, String params) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		try {
			return su.directExecuteJob(pgmNo, params);	
			
		} catch (IOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
		
	}
//	/**
//	 * 獄쏄퀣�뒄 占쎈뼄占쎈뻬 占쎄맒占쎄묶 揶쏉옙占쎌죬占쎌궎疫뀐옙 <br>
//	 * 
//	 * @param String jobId
//	 * @param String pgmNo
//	 * @return String
//	 * @exception EventException
//	 */
//	public String getBatchStatus(String jobId, String pgmNo) throws EventException {
//	ScheduleUtil su = new ScheduleUtil();
//	
//	try {
//		
//		int jobStatus = su.getJobStatus(jobId, pgmNo);
//		
//		return Integer.toString(jobStatus);
//		
//	} catch (DAOException ex) {
//		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//	}			
//}
	
    /**
     * Bkg_DOC_PROC_SKD 'BKGSTF'�뜝�럩踰� �뜝�럡臾멨뜝�럡�뎽�뜝�럥由썲뜝�럥堉�.(GeneralBookingReceiptBCImpl changeBkgStatus)<br>
     * 
     * @param  newStsCd String
     * @param  bkgNo String
     * @param  account SignOnUserAccount
     * @exception DAOException
     */
	public void manageBkgStateFirm(String newStsCd, String bkgNo, SignOnUserAccount account) throws EventException {
		try {
			dbDao.cancelBkgStateFirm(bkgNo, account);
			dbDao.addBkgStateFirm(bkgNo, account);
			
			if(!"F".equals(newStsCd)){
				dbDao.cancelBkgStateFirm(bkgNo, account);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String searchMdmEurFlg(String ofcCd) throws EventException {
		try {
			return dbDao.searchMdmEurFlg(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	
	/**
	 * 
	 * @param eventResponse
	 * @param account
	 * @param bkgNo
	 * @param qtyModifyFlag
	 * @param hisUiNm
	 * @throws EventException
	 */
	public void executeBkgReceiptEdi(GeneralEventResponse eventResponse, SignOnUserAccount account, String bkgNo, String qtyModifyFlag, String hisUiNm) throws EventException {
		try {
			String eurFlg = dbDao.searchMdmEurFlgBkgNo(bkgNo);
			log.info("\n hisUiNm = " + hisUiNm + " , eurFlg = " + eurFlg);
			
//			if(hisUiNm.equalsIgnoreCase("SCG") && !eurFlg.equals("Y"))
			if(!eurFlg.equals("Y"))
				dbDao.modifyBkgReceiptEdiHldFlg(bkgNo, account);
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setHisUiNm(hisUiNm);
			
			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
			vender301ParamVO.setOldMtyPkupYdCd(null);
//			vender301ParamVO.setBracCd("N");
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("Y");	
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl(); 
			
			List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);
			for(int i=0;i<bkgNtcHisVOs.size();i++){
				bkgNtcHisVOs.get(i).setHisUiNm(hisUiNm);
			}
			historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
			
			List<BkgNtcHisVO> bkgNtcCustHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, null, "Y", account);
			for(int i=0;i<bkgNtcCustHisVOs.size();i++){
				bkgNtcCustHisVOs.get(i).setHisUiNm(hisUiNm);
			}
			historyBC.createBkgNtcHis(bkgNtcCustHisVOs, "");
			
			BkgRouteVO route = 	dbDao.searchBkgRoute(bkgBlNoVO.getBkgNo());
			
			if("SGSIN".equals(route.getPolCd())){
				if(qtyModifyFlag == null) qtyModifyFlag = "Y";
				eventResponse.setETCData("psaValCode", managePSABKGAuto(bkgBlNoVO.getBkgNo(), qtyModifyFlag, account));
			}
			
			String emlAddr = dbDao.searchBkgCntcPsonEml(bkgBlNoVO.getBkgNo());
			
			int contentType = 0;
			if(hisUiNm.equalsIgnoreCase("SCG")) contentType = 1;
			
			if(emlAddr != null && !"".equals(emlAddr))
				sendXterReceiptByEmail(bkgNo, emlAddr, account, 0, contentType, hisUiNm);			
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param qtyModifyFlag
	 * @param account
	 * @return
	 */
	private String managePSABKGAuto(String bkgNo, String qtyModifyFlag, SignOnUserAccount account) {
		String returnVal = "";
		try{
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
			PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
			psaBkgVOs[0] = new PsaBkgVO();
			psaBkgVOs[0].setBkgNo(bkgNo);
			psaBkgVOs[0].setSndUsrId(account.getUsr_id());
			psaBkgVOs[0].setQtyModifyFlag(qtyModifyFlag);
			
			psaBC.managePSABKG(psaBkgVOs);

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("PS");
			bkgNtcHisVO.setEdiId("PSACBI");
			bkgNtcHisVO.setEsvcGrpCd("");
			bkgNtcHisVO.setBkgNtcSndRsltCd("A");
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
			bkgNtcHisVOs.add(bkgNtcHisVO);
			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
				}
			}
			returnVal = "Y";
		} catch(Exception ex){
			returnVal = ex.getMessage();
			log.error("err " + ex.toString(), ex);
		}
		return  returnVal;
	}	
	
	/**
	 * 
	 * @param bkgNo
	 * @param account
	 * @throws EventException
	 */
	public void internetBookingRequestAcceptedEmail(String bkgNo, SignOnUserAccount account) throws EventException {
		StringBuilder titleSb = new StringBuilder();
		StringBuilder content = new StringBuilder();
		BkgBookingInfoVO bkgBookingInfoVO = null;
		try{
			bkgBookingInfoVO = dbDao.internetBookingRequestEmailInfo(bkgNo);
			if(bkgBookingInfoVO == null) return;
			// 占쎈뻿域뱄옙
			log.debug("<<<<< RqstSeq : " + bkgBookingInfoVO.getXterRqstSeq() + " >>>>>>");
			if(bkgBookingInfoVO.getXterRqstSeq().equals("0")){
				getBookingRequestConfirmedMailContent(bkgBookingInfoVO, titleSb, content);
				String mrdNm = "";
				if(account.getCnt_cd().equalsIgnoreCase("CN") || account.getCnt_cd().equalsIgnoreCase("HK") || account.getCnt_cd().equalsIgnoreCase("TW")){
					mrdNm = "ESM_BKG_5005C";
				}else{
					BkgRouteVO bkgRouteVO = searchBkgRoute(bkgNo);
					if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
						mrdNm ="ESM_BKG_5005G_LETTER";
					}else{
						mrdNm = "ESM_BKG_5005G";
					}
				}
				BkgNtcHisVO bkgNtcHisVO = dbDao.internetBookingRequestAcceptedEmail(bkgNo, titleSb.toString(), content.toString(), bkgBookingInfoVO.getBkgCntcPsonEml(), bkgBookingInfoVO.getXterRmk(), mrdNm, account);
				dbDao.addBkgNtcHis(bkgNtcHisVO);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param bkgBookingInfoVO
	 * @param content
	 * @param titleSb
	 * @throws EventException
	 */
	public void getBookingRequestConfirmedMailContent(BkgBookingInfoVO bkgBookingInfoVO, StringBuilder titleSb, StringBuilder content) throws EventException {
		titleSb.append("Internet Booking Request Accepted - ( ").append(bkgBookingInfoVO.getBkgNo()).append(" )");
		content.append("<br>").append("Thank you for shipping with NYK Line!").append("<br>").append("<br>");
		/* Special CaGo 筌ｋ똾寃� 嚥≪뮇彛낉옙�몵嚥∽옙 筌롫뗄�뵬 占쎄땀占쎌뒠 癰귨옙野껓옙*/
		if(bkgBookingInfoVO.getRcFlg().equals("Y") || bkgBookingInfoVO.getDcgoFlg().equals("Y") || bkgBookingInfoVO.getAwkCgoFlg().equals("Y")){
			content.append("Your booking request has been confirmed for space and equipment; however, special cargo (hazardous/awkward/ reefer) approval has not yet been received. ").append("<br>");
			content.append("Please follow this link <a href='http://www.nykline.com'>http://www.nykline.com.</a> to review the details of your booking.").append("<br>");
			content.append("To check status of approval, please navigate as follows - > Outbound > Special Cargo Authority Search.").append("<br>");
			content.append("").append("<br>");
			
			content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
			content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
			content.append("have any further questions regarding this booking, please contact your").append("<br>");
			content.append("NYK Customer Service Representative.").append("<br>");
			content.append("").append("<br>");
			
			content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>");
			content.append("").append("<br>");
			
			content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
			content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
			
		}else{
			content.append("Your booking request for the following shipment has been confirmed and").append("<br>");
			content.append("is available on the NYK Line Web site at <a href='http://www.nykline.com'>http://www.nykline.com.</a> Please").append("<br>");
			content.append("follow this link to review the details of your booking.").append("<br>").append("<br>");
			
			content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
			content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
			content.append("have any further questions regarding this booking, please contact your").append("<br>");
			content.append("NYK Customer Service Representative.").append("<br>").append("<br>");
			
			content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>").append("<br>");
			
			content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
			content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
		}
		
		content.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
		content.append("*** NOTE - Please do not respond to this email.***").append("<br>");
	}
	
	/**
	 * 
	 * @param bkgBookingInfoVO
	 * @param titleSb
	 * @param content
	 * @throws EventException
	 */
	public void getBookingChangeRequestConfirmedMailContent(BkgBookingInfoVO bkgBookingInfoVO, StringBuilder titleSb, StringBuilder content) throws EventException {
		titleSb.append("Internet Booking Change Request Accepted - ( ").append(bkgBookingInfoVO.getBkgNo()).append(" )");
		content.append("<br>").append("Thank you for shipping with NYK Line!").append("<br>").append("<br>");
		/* Special CaGo 筌ｋ똾寃� 嚥≪뮇彛낉옙�몵嚥∽옙 筌롫뗄�뵬 占쎄땀占쎌뒠 癰귨옙野껓옙*/
		if(bkgBookingInfoVO.getRcFlg().equals("Y") || bkgBookingInfoVO.getDcgoFlg().equals("Y") || bkgBookingInfoVO.getAwkCgoFlg().equals("Y")){
			content.append("Your booking change request for the following shipment has been confirmed. Some details of your request may have been changed, or special cargo (hazardous/awkward/ reefer) details may need to be re-approved.").append("<br>");
			content.append("").append("<br>");
			
			content.append("Please follow this link <a href='http://www.nykline.com'>http://www.nykline.com.</a> to review the details of your booking.").append("<br>");
			content.append("To check status of approval, please navigate as follows -<a href='http://www.nykline.com'>http://www.nykline.com.</a>> Outbound > Special Cargo Authority Search. ").append("<br>");
			content.append("").append("<br>");
			
			content.append("If you want to change or cancel this booking, please submit your change ").append("<br>");
			content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
			content.append("have any further questions regarding this booking, please contact your").append("<br>");
			content.append("NYK Customer Service Representative.").append("<br>");
			content.append("").append("<br>");
			
			content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>");
			content.append("").append("<br>");
			
			content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
			content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
		}else{
			content.append("Your booking change request for the following shipment has been").append("<br>");
			content.append("confirmed. Some details of your request may have been changed, and are").append("<br>");
			content.append("available for review on the NYK Line Web site at <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
			content.append("Please follow this link to review the details of your booking.").append("<br>").append("<br>");

			content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
			content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
			content.append("have any further questions regarding this booking, please contact your").append("<br>");
			content.append("NYK Customer Service Representative.").append("<br>").append("<br>");
			
			content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>").append("<br>");
			
			content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
			content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
			
		}
		
		content.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
		content.append("*** NOTE - Please do not respond to this email.***").append("<br>");
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param emlAddr
	 * @param account
	 * @param mailType
	 * @param contentType
	 * @param hisUiNm
	 * @throws Exception
	 */
	public void sendXterReceiptByEmail(String bkgNo, String emlAddr, SignOnUserAccount account, int mailType, int contentType, String hisUiNm) throws Exception{
		String sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = new ArrayList<ComRptDsgnXptInfoVO>();
		TemplateMail template = null;
		String mrdNm = null;
		try {
			
			StringBuilder title = new StringBuilder();
			StringBuilder content = new StringBuilder();
			content.append("<br>").append("Thank you for shipping with NYK Line!").append("<br>").append("<br>");
			/* 占쎈뻿域뱄옙 筌롫뗄�뵬 */
			if(mailType == 0){
				
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setDocPerfDeltFlg("N");
				bkgDocProcSkdVO.setBkgDocProcTpCd("EBKNTC");
				/* 占쎈뻿域뱀뮆�뮉 筌ㅼ뮇�겧 占쎈립甕곕뜄彛� 癰귣�沅�占쎈뼄. 筌롫뗄�뵬占쎌뱽 癰귣�源됵옙�뮉筌욑옙 筌ｋ똾寃� 揶쏅�れ뵠 占쎌뿳占쎌몵筌롳옙 筌롫뗄�뵬占쎌뱽 癰귣�沅∽쭪占� 占쎈륫占쎈뮉占쎈뼄. */
				BkgDocProcSkdVO skdVo = searchDocProcSkd(bkgDocProcSkdVO, "N");
				if(skdVo == null && (hisUiNm==null || !hisUiNm.equals("ESM_BKG_0229"))) return;
				
				title.append("Internet Booking Request Accepted - ( ").append(bkgNo).append(" )");
				/* Special CaGo 筌ｋ똾寃� 嚥≪뮇彛낉옙�몵嚥∽옙 筌롫뗄�뵬 占쎄땀占쎌뒠 癰귨옙野껓옙*/
				if(contentType == 1){
					//SCG , E-Booking 占쎌넅筌롳옙 占쏙옙占쎌뿯
					content.append("Your booking request has been confirmed for space and equipment; however, special cargo (hazardous/awkward/ reefer) approval has not yet been received. ").append("<br>");
					content.append("Please follow this link <a href='http://www.nykline.com'>http://www.nykline.com.</a> to review the details of your booking.").append("<br>");
					content.append("To check status of approval, please navigate as follows - > Outbound > Special Cargo Authority Search.").append("<br>");
					content.append("").append("<br>");
					
					content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
					content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
					content.append("have any further questions regarding this booking, please contact your").append("<br>");
					content.append("NYK Customer Service Representative.").append("<br>");
					content.append("").append("<br>");
					
					content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>");
					content.append("").append("<br>");
					
					content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
					content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
					
				}else{
					content.append("Your booking request for the following shipment has been confirmed and").append("<br>");
					content.append("is available on the NYK Line Web site at <a href='http://www.nykline.com'>http://www.nykline.com.</a> Please").append("<br>");
					content.append("follow this link to review the details of your booking.").append("<br>").append("<br>");
					
					content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
					content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
					content.append("have any further questions regarding this booking, please contact your").append("<br>");
					content.append("NYK Customer Service Representative.").append("<br>").append("<br>");
					
					content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>").append("<br>");
					
					content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
					content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
				}
			}else{
				title.append("Internet Booking Change Request Accepted - ( ").append(bkgNo).append(" )");
				/* Special CaGo 筌ｋ똾寃� 嚥≪뮇彛낉옙�몵嚥∽옙 筌롫뗄�뵬 占쎄땀占쎌뒠 癰귨옙野껓옙*/
				if(contentType == 1){
					content.append("Your booking change request for the following shipment has been confirmed. Some details of your request may have been changed, or special cargo (hazardous/awkward/ reefer) details may need to be re-approved.").append("<br>");
					content.append("").append("<br>");
					
					content.append("Please follow this link <a href='http://www.nykline.com'>http://www.nykline.com.</a> to review the details of your booking.").append("<br>");
					content.append("To check status of approval, please navigate as follows -<a href='http://www.nykline.com'>http://www.nykline.com.</a>> Outbound > Special Cargo Authority Search. ").append("<br>");
					content.append("").append("<br>");
					
					content.append("If you want to change or cancel this booking, please submit your change ").append("<br>");
					content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
					content.append("have any further questions regarding this booking, please contact your").append("<br>");
					content.append("NYK Customer Service Representative.").append("<br>");
					content.append("").append("<br>");
					
					content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>");
					content.append("").append("<br>");
					
					content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
					content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
				}else{
					content.append("Your booking change request for the following shipment has been").append("<br>");
					content.append("confirmed. Some details of your request may have been changed, and are").append("<br>");
					content.append("available for review on the NYK Line Web site at <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
					content.append("Please follow this link to review the details of your booking.").append("<br>").append("<br>");

					content.append("If you want to change or cancel this booking, please submit your change").append("<br>");
					content.append("or cancellation request through the Internet Booking application. If you").append("<br>");
					content.append("have any further questions regarding this booking, please contact your").append("<br>");
					content.append("NYK Customer Service Representative.").append("<br>").append("<br>");
					
					content.append("<u>For your cargo information, refer to the attached file</u>").append("<br>").append("<br>");
					
					content.append("To access NYK Group on-line, please go to <a href='http://www.nykline.com'>http://www.nykline.com.</a>").append("<br>");
					content.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
					
				}
			}
			
			content.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
			content.append("*** NOTE - Please do not respond to this email.***").append("<br>");
			
			if(account.getCnt_cd().equalsIgnoreCase("CN") || account.getCnt_cd().equalsIgnoreCase("HK") || account.getCnt_cd().equalsIgnoreCase("TW")){
				mrdNm = "ESM_BKG_5005C";
			}else{
				BkgRouteVO bkgRouteVO = searchBkgRoute(bkgNo);
				if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
					mrdNm ="ESM_BKG_5005G_LETTER";
				}else{
					mrdNm = "ESM_BKG_5005G";
				}
			}
			
			log.debug("['" + bkgNo + "'][" + account.getUsr_id() + "][][][][Y][][][][]");
			ComRptDsgnXptInfoVO vo = new ComRptDsgnXptInfoVO();
				
			if(null != mrdNm){
				vo.setRdTmpltNm(mrdNm+".mrd");
				vo.setRdParaCtnt("/rp ['" + bkgNo + "'][" + account.getUsr_id() + "][][][][Y][][][][]");
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm(ConstantMgr.getScacCode() + bkgNo + ".pdf");
			}
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos.add(vo);
			
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setFrom("noreply@nykline.com");
			template.setRecipient(emlAddr);
			template.setSubject(title.toString()); 
			template.setHtmlContent(content.toString());
			if(!"".equals(mrdNm)){
				template.setComRptDsgnXptInfoVOs(vos);
			}
			template.setArg("bkgNoBody", bkgNo);
			
			String bccRcvrEml = searchBccEmailAddrRSQL("BK");     
			if (!StringUtils.isBlank(bccRcvrEml)) {
				template.setBccRcvrEml(bccRcvrEml);
			}
			
			sndIds = template.send();
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			
			/* 占쎈뻿域뱄옙 筌롫뗄�뵬 獄쏆뮇�꽊 FLG 筌ｌ꼶�봺 */
			if(mailType == 0){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setDocProcSeq("0");
				bkgDocProcSkdVO.setBkgDocProcTpCd("EBKNTC");
				bkgDocProcSkdVO.setDocPerfDeltFlg("Y");
				addBkgDocProcSkd(bkgDocProcSkdVO);
			}
			
			if(!sndIds.equals("")){
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgNo);
				bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(emlAddr);
				bkgNtcHisVO.setSndId(sndIds);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndUsrId("SYSTEM");
				bkgNtcHisVOs.add(bkgNtcHisVO);
				new BookingHistoryMgtBCImpl().createBkgNtcHis(bkgNtcHisVOs, hisUiNm);
			}
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param bkgDocProcSkdVO
	 * @throws DAOException 
	 */
	public void addBkgDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO) throws DAOException{
		dbDao.addBkgDocProcSkd(bkgDocProcSkdVO);
	}
	
	/**
	 * 
	 * @param cntrTpszCd
	 * @return
	 * @throws DAOException
	 */
	public String checkCntrTpszCd(String cntrTpszCd) throws DAOException{
		return dbDao.checkCntrTpszCd(cntrTpszCd);
	}
	
	/**
	 * 
	 * @param divCd
	 * @param officeCd
	 * @param usrId
	 * @return
	 * @throws EventException
	 */
	public BkgBlNoVO manageToyotaBlNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			BookingNumberGenarationBC bc = new BookingNumberGenarationBCImpl();	
			return bc.manageToyotaBlNumberGeneration(divCd,officeCd,usrId);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param bkgBlNoVO
	 * @return
	 * @throws EventException
	 */
	public String validationToyotaBlNo(BkgBlNoVO bkgBlNoVO)throws EventException {
		try {
			return new BookingNumberGenarationBCImpl().validationToyotaBlNo(bkgBlNoVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	

	/**
	 * Check whether yard exists in specified VVD and return cltp_ind_seq .<br>
	 * @param String vvd 
	 * @param String ydCd  
	 * @param String cltpIndSeq 
	 * @return String
	 * @throws EventException
	 */
	public String searchCltpIndSeq (String vvd ,String ydCd, String cltpIndSeq) throws EventException {
		try {
			return dbDao.searchCltpIndSeq(vvd,ydCd,cltpIndSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Check whether yard exists or not.<br>
	 * @param String ydCd  
	 * @return Boolean
	 * @throws EventException
	 */
	public Boolean validateYardCode(String ydCd) throws EventException {
		try {
			return dbDao.validateYardCode(ydCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * Retrieve all exchange information information regarding BKG
	 * 
	 * @param String bkgNo
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchAllXchRate(String bkgNo) throws EventException {
		try {
			return dbDao.searchAllXchRate(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * Retrieve all exchange information information regarding BKG
	 * 
	 * @param String bkgNo
	 * @param List<String> chgCurrs
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchAllXchRate(String bkgNo, List<String> chgCurrs) throws EventException {
		try {
			return dbDao.searchAllXchRate(bkgNo, chgCurrs);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}	
	/**
	 * Retrieve prepaid Curr, collect Curr information regarding BKG, tax charge<br>
	 * 
	 * @param String bkgNo
	 * @param List<String> chgCds
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchArCurByTaxChg(String bkgNo, List<String> chgCds) throws EventException {
		try {
			return dbDao.searchArCurByTaxChg(bkgNo,chgCds);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * Retrieve MDM_CHAGRE TAX_FLG<br>
	 * 
	 * @param String chgCd
	 * @return MdmChgTaxFlgVO
	 * @exception EventException
	 */
	public MdmChgTaxFlgVO searchChgTaxFlg(String chgCd) throws EventException {
		try {
			return dbDao.searchChgTaxFlg(chgCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Bcc email address function<br>
	 * @param String bkg_eml_knd_cd
	 * @return String output_text
	 * @exception EventException
	 * @author SJH.20160324.ADD
	 */
	public String searchBccEmailAddrRSQL(String bkg_eml_knd_cd) throws EventException {
		try {
			return dbDao.searchBccEmailAddrRSQL(bkg_eml_knd_cd);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	
    /**
     * Check S/O is already created or not<br>
     * 
     * @param String bkgNo
     * @param String boundCd
     * @param String nodCd
     * @return Boolean
     * @throws EventException
     */
    public Boolean searchSoExist(String bkgNo, String boundCd, String nodCd) throws EventException {
    	try {
    		return dbDao.searchSoExist(bkgNo, boundCd, nodCd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }	
    
   /**
    * 
    * @param pgmNo
    * @param usrId
    * @return
    * @throws EventException
    */
    public int searchUserPgmRoleMach(String pgmNo, String usrId) throws EventException {
    	try {
    		return dbDao.searchUserPgmRoleMach(pgmNo, usrId);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }	
    
    /**
     * Return EDI_HLD_FLG value of BKG_BOOKING<br>
     * 
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String searchEdiHldFlg(String bkgNo) throws EventException {
    	try {
    		return dbDao.searchEdiHldFlg(bkgNo);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * currency占쎈퓠 占쏙옙占쎈립 占쎈꺖占쎈떭占쎌젎 占쎌쁽�뵳�슦�땾�몴占� 鈺곌퀬�돳占쎈립占쎈뼄.<br>
	 * 
	 * @param String currCd
	 * @return MdmCurrencyVO
	 */
    public MdmCurrencyVO searchDpPrcsKntByCur(String currCd) throws EventException {
		try {
			return dbDao.searchDpPrcsKntByCur(currCd);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
    
    /**
     * PRD 占쎈퓠占쎄퐣 Route 癰귨옙野껓옙 占쎈�占쎌뒠�굜遺얜굡�몴占� 鈺곌퀬�돳 占쎈립占쎈뼄.<br>
     * 
     * @param bkgBookingInfoVO
     * @return String
     * @throws EventException
     */
    public String searchPrdReplanCode(BkgBookingInfoVO bkgBookingInfoVO) throws EventException {
        // TODO Auto-generated method stub
    	String rtn;
    	try {
	        rtn = dbDao.searchPrdReplanCode(bkgBookingInfoVO);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
    }
    
    /**
     * 
     * @param bkgNo
     * @return
     * @throws EventException
     */
     public String searchVslEngNmCssmVoyNo(String bkgNo) throws EventException {
     	try {
     		return dbDao.searchVslEngNmCssmVoyNo(bkgNo);
 	    } catch (DAOException de) {
 			log.error("err " + de.toString(), de);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
 		}
     }
     
     /**
      * Return all VVD information of specified booking<br>
      * 
      * @param String bkgNo
      * @return String
      * @throws EventException
      */
      public String searchBkgVvd(String bkgNo) throws EventException {
      	try {
      		return dbDao.searchBkgVvd(bkgNo);
  	    } catch (DAOException de) {
  			log.error("err " + de.toString(), de);
  			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
  		} catch (Exception ex) {
  			log.error("err " + ex.toString(), ex);
  			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
  		}
      }
      
     /**
      * 
      * @param xterRqstNoVO
      * @return
      * @throws EventException
      */
      public BkgXterUsrInfoVO searchBkgPtyXterUsrInfo(XterRqstNoVO xterRqstNoVO) throws EventException {
        	try {
        		return dbDao.searchBkgPtyXterUsrInfo(xterRqstNoVO);
    	    } catch (DAOException de) {
    			log.error("err " + de.toString(), de);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    		} catch (Exception ex) {
    			log.error("err " + ex.toString(), ex);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    		}
        }
      
	/**
	 * 
	 * @param modName
	 * @param applInfo
	 * @param log
	 * @throws EventException
	 */
	public void addErrorBkgLog(String modName, String applInfo, String log) throws EventException {
		try {
			dbDao.addErrorBkgLog(modName, applInfo, log);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addBkgLog(String modName, String applInfo, String logDesc) throws EventException{
        try {
            	dbDao.addBkgLog(modName,applInfo,logDesc);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	/**
	 * 
	 * @param fileKey
	 * @return
	 * @throws EventException
	 */
	public ComUpldFileVO comUpldFileInfo(String fileKey) throws EventException{
		ComUpldFileVO vo = null;
		try{
			vo = dbDao.selectComUpldFile(fileKey);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return vo;
	}
	
    /**
     * Obl Print 예외 사용자, 오피스 처리
     * @param SignOnUserAccount account
     * @return
     * @throws EventException
     */
	public String checkOblAuthPass(SignOnUserAccount account) throws EventException {
		try {
            return dbDao.checkOblAuthPass(account);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
	}	
	
	/**
	 * 부킹메인화면에서 수정가능지 체크
	 * @param bkgBookingInfoVO
	 * @return
	 * @throws EventException
	 */
	public String bkgBookingSaveCheck(BkgBookingInfoVO bkgBookingInfoVO) throws EventException {
		try {
            return dbDao.bkgBookingSaveCheck(bkgBookingInfoVO);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
	}
	
    /**
     * HTML5 RD 사용자, 오피스 정보 조회
     * @param SignOnUserAccount account
     * @param String reCheck
     * @throws EventException
     */
	public String checkHtml5RDPass(SignOnUserAccount account) throws EventException {
		String reCheck = "N";
		try {
			int cnt = Integer.parseInt(dbDao.checkHtml5RDPass(account));
			if(cnt>0){
				reCheck = "Y";
			}
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
		return reCheck;
	}
	
	/**
	 * Vender301 EDI 대상 조회 <br>
	 * @param String bkgNo
	 * @return String output_text
	 * @exception EventException
	 * @author 
	 */
	public String searchVenderEdiBkg(String bkgNo) throws EventException {
		try {
			return dbDao.searchVenderEdiBkg(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_02A Save(Update), Save All(Update), Cancel All, Cancel, Row Delete
	 * to be recalculation is updated in TRS<br>
	 *
	 * @param 		String category
	 * @param 		String bkgNo
	 * @param 		String boundCd
	 * @param 		String troSeq
	 * @param 		String troSubSeq
	 * @param 		String troSubSeq
	 * @param 		String deltFlg
	 * @param       SignOnUserAccount account
	 * @param       String rtnPrdFlg
	 * @param       String vslSeq
	 * @return 		void
	 * @exception 	EventException
	 */
	public void interfaceToTrs(String category, String bkgNo, String boundCd, String troSeq, String troSubSeq, String deltFlg, SignOnUserAccount account, String rtnPrdFlg, String vslSeq)throws EventException{
		WorkOrderIssueBC workOrdBC  = new WorkOrderIssueBCImpl();
		try {
			TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();
			
			trsChgMgmtBkgVO.setCateSepCd(category);
			trsChgMgmtBkgVO.setChageFlg("Y");
			trsChgMgmtBkgVO.setBkNo(bkgNo);
			trsChgMgmtBkgVO.setBndCd(boundCd);
			trsChgMgmtBkgVO.setRtnPrdFlg(rtnPrdFlg);
			trsChgMgmtBkgVO.setTroSeq(troSeq);
			trsChgMgmtBkgVO.setTroSubSeq(troSubSeq);
			trsChgMgmtBkgVO.setSpclSeq("0");
			trsChgMgmtBkgVO.setVslSeq(vslSeq);
			trsChgMgmtBkgVO.setDeltFlg(deltFlg);
			trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
			trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());
			log.debug("#### interfaceToTrs "+category+":"+ bkgNo+":"+ boundCd+":"+ troSeq+":"+ troSubSeq+":"+ deltFlg);
			workOrdBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
			
		} catch(EventException ex) {
			log.error("TO TRS error bkg no : " + bkgNo);
			throw ex;
		} catch(Exception ex) { 
			log.error("TO TRS error bkg no : " + bkgNo);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}

	/**
	 * Get basic VVD and route information of BKG_BOOKING<br>
	 *
	 * @param String bkgNo
	 * @return BkgVvdRouteVO
	 * @exception EventException
	 */
	public BkgVvdRouteVO searchBkgVvdRoute(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgVvdRoute(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}

    /**
     * Check S/O is already created or not<br>
     * 
     * @param String bkgNo
     * @param String boundCd 'O' or 'I'
     * @param String troSeq
     * @return Boolean
     * @throws EventException
     */
    public Boolean searchSoExistByTro(String bkgNo, String boundCd, String troSeq) throws EventException {
    	try {
    		return dbDao.searchSoExistByTro(bkgNo, boundCd, troSeq);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }	
    
   /**
    * 
    * @param bkgNo
    * @throws EventException
    */
    public void bkgBookingLstSavDtSave(String bkgNo) throws EventException{
    	try {
			dbDao.bkgBookingLstSavDtSave(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Return BL value of BKG_BL_ISS<br>
     * 
     * @param BkgUsrDfltSetVO vo
     * @return String
     * @throws EventException
     */
    public String searchBlPrnFlg(BkgUsrDfltSetVO vo) throws EventException {
    	try {
    		return dbDao.searchBlPrnFlg(vo);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * 
     * @param locCd
     * @return
     * @throws EventException
     */
    public String searchLocationNm(String locCd) throws EventException {
    	try {
    		return dbDao.searchLocationNm(locCd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }	
    
    /**
     * 
     * @param chgCd
     * @return
     * @throws EventException
     */
    public String searchVietnamTaxCharge(String chgCd) throws EventException {
    	try {
    		return dbDao.searchVietnamTaxCharge(chgCd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);		
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    
    
    /**
     * 
     * @param param
     * @param checkList
     * @return
     * @throws EventException
     */
    public Boolean getParameterNullCheck(Map<String, String> param, String[] checkList) throws EventException {
    	if(checkList == null) return false;
    	if(param == null) return false;
    	
    	for (int i = 0; i < checkList.length; i++) {
    		if(param.containsKey(checkList[i])){
    			if(!param.get(checkList[i]).isEmpty()) return true;
    		}
		}
    	
    	log.error("\n=========== getParameterNullCheck [ " + param.toString() + " ]");
    	return false;
    }
} 
