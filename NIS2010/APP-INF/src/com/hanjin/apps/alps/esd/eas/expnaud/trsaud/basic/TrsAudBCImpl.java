/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsAudBCImpl.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration.TrsAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.CodeVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.DropOffChargeInquiryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SpecialSoOfTrsVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SurchargeReportVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.TrffCmprsnByTRSAgrmntVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.UnmatchRouteBkgVsSoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EventResponse,EacMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class TrsAudBCImpl extends BasicCommandSupport implements TrsAudBC {

	// Database Access Object
	private transient TrsAudDBDAO dbDao = null;

	/**
	 * TrsAudBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public TrsAudBCImpl() {
		dbDao = new TrsAudDBDAO();
	}
	
	/**
	 * Special S/O of Transport 을 조회한다.<br>
	 * 
	 * @param SpecialSoOfTrsVO specialSoOfTrsVO
	 * @return List<SpecialSoOfTrsVO>
	 * @exception EventException
	 */
	public List<SpecialSoOfTrsVO> searchSpecialSoOfTrs(SpecialSoOfTrsVO specialSoOfTrsVO) throws EventException {
		try {
			return dbDao.searchSpecialSoOfTrs(specialSoOfTrsVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * Surcharge Report를 조회한다.<br>
	 * 
	 * @param SurchargeReportVO surchargeReportVO
	 * @return List<SurchargeReportVO>
	 * @exception EventException
	 */
	public List<SurchargeReportVO> searchSurchargeReport(SurchargeReportVO surchargeReportVO) throws EventException {
		try {
			return dbDao.searchSurchargeReport(surchargeReportVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Surcharge Item Code 를 조회한다.<br>
	 * 
	 * @return List<CodeVO>
	 * @exception EventException
	 */
	public List<CodeVO> searchScgCd() throws EventException{
		
		try {
			return dbDao.searchScgCd();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Tariff Comparison by TRS Agreement 를 조회한다.<br>
	 * 
	 * @param TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO
	 * @return List<TrffCmprsnByTRSAgrmntVO>
	 * @exception EventException
	 */
	public List<TrffCmprsnByTRSAgrmntVO> searchInlandCostList(TrffCmprsnByTRSAgrmntVO trffCmprsnByTRSAgrmntVO) throws EventException {
		try {
			return dbDao.searchInlandCostList(trffCmprsnByTRSAgrmntVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	
	
	/**
	 * Tariff Comparison by TRS Agreement 를 조회한다.<br>
	 * 
	 * @param UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO
	 * @return List<UnmatchRouteBkgVsSoVO>
	 * @exception EventException
	 */
	public List<UnmatchRouteBkgVsSoVO> searchUmchList(UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO) throws EventException {
		try {
			return dbDao.searchUmchList(unmatchRouteBkgVsSoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	

	/**
	 * Container Type Size Code 를 조회한다.<br>
	 * 
	 * @return List<CodeVO>
	 * @exception EventException
	 */
	public List<CodeVO> searchCntrTpSz() throws EventException{
		
		try {
			return dbDao.searchCntrTpSz();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Code 를 조회한다.<br>
	 * 
	 * @param DropOffChargeInquiryVO dropOffChargeInquiryVO
	 * @return List<CodeVO>
	 * @exception EventException
	 */
	public List<CodeVO> searchCustCd(DropOffChargeInquiryVO dropOffChargeInquiryVO) throws EventException{
		
		try {
			return dbDao.searchCustCd(dropOffChargeInquiryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Drop-Off Charge Inquiry 조회한다.<br>
	 * 
	 * @param DropOffChargeInquiryVO dropOffChargeInquiryVO
	 * @return List<DropOffChargeInquiryVO>
	 * @exception EventException
	 */
	public List<DropOffChargeInquiryVO> searchDodList(DropOffChargeInquiryVO dropOffChargeInquiryVO) throws EventException {
		try {
			return dbDao.searchDodList(dropOffChargeInquiryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
}