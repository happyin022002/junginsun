/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrAudBCImpl.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration.MnrAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByBkgVO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByHistoryVO;
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

public class MnrAudBCImpl extends BasicCommandSupport implements MnrAudBC {

	// Database Access Object
	private transient MnrAudDBDAO dbDao = null;

	/**
	 * MnrAudBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public MnrAudBCImpl() {
		dbDao = new MnrAudDBDAO();
	}
	
	
	/**
	 * H/Bar Inquiry by BKG 조회한다.<br>
	 * 
	 * @param HbarInquiryByBkgVO hbarInquiryByBkgVO
	 * @return List<HbarInquiryByBkgVO>
	 * @exception EventException
	 */
	public List<HbarInquiryByBkgVO> searchBkgHngrList(HbarInquiryByBkgVO hbarInquiryByBkgVO) throws EventException {
		try {
			return dbDao.searchBkgHngrList(hbarInquiryByBkgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * HBar Inquiry by History 조회한다.<br>
	 * 
	 * @param HbarInquiryByHistoryVO hbarInquiryByHistoryVO
	 * @return List<HbarInquiryByHistoryVO>
	 * @exception EventException
	 */
	public List<HbarInquiryByHistoryVO> searchHngrHisList(HbarInquiryByHistoryVO hbarInquiryByHistoryVO) throws EventException {
		try {
			return dbDao.searchHngrHisList(hbarInquiryByHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
}