/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmBCImpl.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration.LogisticsRevenueDBDAO;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.LogisticsRevenueInvoiceVO;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.TaxInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-JOCaseManage Business Logic Basic Command implementation<br>
 * - ALPS-JOCaseManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jong-Geon Byeon
 * @see ESD_TPB_0139EventResponse,LogisticsRevenueBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LogisticsRevenueBCImpl extends BasicCommandSupport implements LogisticsRevenueBC {

	// Database Access Object
	private transient LogisticsRevenueDBDAO dbDao = null;

	/**
	 * LogisticsRevenueBCImpl 객체 생성<br>
	 * LogisticsRevenueDBDAO를 생성한다.<br>
	 */
	public LogisticsRevenueBCImpl() {
		dbDao = new LogisticsRevenueDBDAO();
	}

	/**
	 * 해당 Office 의  TPB_INV_SH_SET.vat_xch_rt 값을 구함 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkInvVatXchRate(String ofcCd) throws EventException{
		try {
			return dbDao.checkInvVatXchRate(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * SAVE 오퍼레이션 수행 Return 값으로 TPB no를 받는다. <br>
	 * 
	 * @param SaveInvoiceVO saveInvoiceVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] createSingleInvoice(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO) throws EventException{
		try {
			
			logisticsRevenueInvoiceVO.setSDtlAmt( logisticsRevenueInvoiceVO.getSDtlAmt().replace(",","") );
			logisticsRevenueInvoiceVO.setSSdate( logisticsRevenueInvoiceVO.getSSdate().replace("-",""));
			logisticsRevenueInvoiceVO.setSEdate(logisticsRevenueInvoiceVO.getSEdate().replace("-",""));
			logisticsRevenueInvoiceVO.setSCfmTp("I");
			logisticsRevenueInvoiceVO.setGrpCfmSeq("0");
			
			return dbDao.createLogisticsRevenueInvoice(logisticsRevenueInvoiceVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Third Party Value 의 존재 유무 Check <br>
	 * 
	 * @param String trdPartyVal
	 * @return String
	 * @exception EventException
	 */
	public String checkTrdPartyVal(String trdPartyVal) throws EventException{
		try {
			return dbDao.checkTrdPartyVal(trdPartyVal);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * SAVE 오퍼레이션 수행 Return 값으로 HJS S/P No.를 받는다. <br>
	 * 
	 * @param MultiSaveInvoiceVO multiSaveInvoiceVO
	 * @return String[] 
	 * @exception EventException
	 */
	public String[] createMultiInvoice(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO) throws EventException{
		try {
			logisticsRevenueInvoiceVO.setSDtlAmt( logisticsRevenueInvoiceVO.getSDtlAmt().replace(",","") );
			logisticsRevenueInvoiceVO.setSSdate( logisticsRevenueInvoiceVO.getSSdate().replace("-",""));
			logisticsRevenueInvoiceVO.setSEdate(logisticsRevenueInvoiceVO.getSEdate().replace("-",""));
			logisticsRevenueInvoiceVO.setSCntrRtnDt(logisticsRevenueInvoiceVO.getSCntrRtnDt().replace("-",""));
			logisticsRevenueInvoiceVO.setSVndrCustDivCd("V");
			logisticsRevenueInvoiceVO.setSVndrSeq(logisticsRevenueInvoiceVO.getSTrdPartyVal());
			logisticsRevenueInvoiceVO.setSCfmTp("G");
			
			return dbDao.createLogisticsRevenueInvoice(logisticsRevenueInvoiceVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Office Code조회 처리<br>
	 * @return List<String> - Office Code
	 * @exception EventException
	 */
	public List<String> searchTPBCostOfcList(String ofcCd) throws EventException {
		try {
			return dbDao.searchTPBCostOfcList(ofcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * India Tax rate 정보 <br>
	 * 
	 * @param String ofcCd
	 * @return List<TaxInfoVO>
	 * @exception EventException
	 */
	public List<TaxInfoVO> searchTaxInfo(String ofcCd) throws EventException{
		try {
			List<TaxInfoVO> taxInfoVO = null;
			taxInfoVO =  dbDao.searchTaxInfo(ofcCd);
			return taxInfoVO;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
}