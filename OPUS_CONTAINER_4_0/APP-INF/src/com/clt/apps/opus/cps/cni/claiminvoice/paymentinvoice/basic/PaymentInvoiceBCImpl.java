/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PaymentInvoiceBCImpl.java
 *@FileTitle : 지불전표 리스트 조회 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.basic;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration.PaymentInvoiceDBDAO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.ArRevenueVVDVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListCondVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.VendorInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 *  지불전표 관련 Business Logic Basic Command implementation<br>
 *  지불전표 관련 비지니스 로직을 처리한다.<br>
 * 
 * @author cyo
 * @see DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PaymentInvoiceBCImpl extends BasicCommandSupport implements PaymentInvoiceBC {

    // Database Access Object
    private transient PaymentInvoiceDBDAO dbDao = null;

    /**
     * PaymentInvoiceBCImpl 객체 생성<br>
     * 
     */
    public PaymentInvoiceBCImpl() {
        dbDao = new PaymentInvoiceDBDAO();
    }


 
    
    // ===========================================================================
    // 진윤오
    // ===========================================================================    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0048] CSR Manager 
	// ---------------------------------------------------------------------------

	/**
	 * Payment Invoice 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0048
	 * @category searchCsrManagerList 
	 * @param CsrManagerListCondVO condVo	
     * @return List<CsrManagerListVO>
     * @throws EventException
     */
	public List<CsrManagerListVO> searchCsrManagerList(CsrManagerListCondVO condVo) throws EventException {
		try {			
			return dbDao.searchCsrManagerList(condVo);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0045] Invoice Creation
	// ---------------------------------------------------------------------------

	/**
	 * Payment Invoice 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceList 
	 * @param String cgoClmNo
	 * @param String hdlrUsrId
     * @return List<PaymentInvoiceVO>
     * @throws EventException
     */
	public List<PaymentInvoiceVO> searchPaymentInvoiceList(String cgoClmNo ,String hdlrUsrId) throws EventException {
		try {
			return dbDao.searchPaymentInvoiceList(cgoClmNo, hdlrUsrId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
    	
	/**
	 * Payment Invoice 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceInfo 
	 * @param String cgoClmPayNo
     * @return PaymentInvoiceInfoVO
     * @throws EventException
     */
	public PaymentInvoiceInfoVO searchPaymentInvoiceInfo(String cgoClmPayNo) throws EventException {
		try {
			return dbDao.searchPaymentInvoiceInfo(cgoClmPayNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 비용처리오피스 취득
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchCostOfcCd
	 * @param String ofcCd
     * @return String
     * @throws EventException
     */
	public String searchCostOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchCostOfcCd(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Vendor 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchVendorInfo
	 * @param String vndrSeq
     * @return VendorInfoVO
     * @throws EventException
     */
	public VendorInfoVO searchVendorInfo(String vndrSeq) throws EventException {
		try {
			return dbDao.searchVendorInfo(vndrSeq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
		
	/**
	 * RevenueVVD 재무항차 정보<br>
	 * 재무항차가 존재 하는경우는 재무항차로 설정
	 * 존재하지 않을경우에는 공통항차를 설정한다.
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchRevenueVVDInfo
	 * @param ArRevenueVVDVO vo
	 * @param String invIssDt 
	 * @param String costOfcCd
     * @return ArRevenueVVDVO
     * @throws EventException
     */
	 public ArRevenueVVDVO searchRevenueVVDInfo(ArRevenueVVDVO vo ,String invIssDt , String costOfcCd) throws EventException {
		try {
			
			
			// -----------------------------------------
			// 재무항차가 존재 하는경우는 공통항차로 설정 
			// -----------------------------------------
			
			ArRevenueVVDVO arVo = dbDao.searchArRevenueVVD(vo);
			
						
			if (arVo != null) {				
				return arVo;
			}
			
			// 존재하지 않을경우에는 공통항차를 설정한다.
			String voyNo = dbDao.searchApPeriodOnlineVoyNo(invIssDt, costOfcCd);
			
			arVo  = new ArRevenueVVDVO();
			arVo.setVslCd("CNTC");
			arVo.setSkdDirCd("M");
			arVo.setRlaneDirCd("M");
			// 공통항차의 경우 
			// 항차가 Online 상태인경우
			// Invoice issue Date의 YYMM설정
			if (!StringUtils.isEmpty(voyNo)) {
				arVo.setSkdVoyNo(voyNo);
				return arVo;
			} 
			
			 
			// Close된경우 
			// Invoice issue Date 보다 크거나 
			// 같은 EFF_DT중 가장 과거의 YYMM을 설정 한다.			
			voyNo = dbDao.searchApPeriodCloseVoyNo(invIssDt, costOfcCd);			
			if (!StringUtils.isEmpty(voyNo)) {
				arVo.setSkdVoyNo(voyNo);
				return arVo;
			}
			
			return null;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}		
	
}