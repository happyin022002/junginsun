/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOStatusInquiryBCImpl.java
*@FileTitle : JOStatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration.JOStatusInquiryDBDAO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-JOStatusInquiryManage Business Logic Basic Command implementation<br>
 * - ALPS-JOStatusInquiryManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_105EventResponse,JOStatusInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JOStatusInquiryBCImpl extends BasicCommandSupport implements JOStatusInquiryBC {

	// Database Access Object
	private transient JOStatusInquiryDBDAO dbDao = null;

	/**
	 * JOStatusInquiryBCImpl 객체 생성<br>
	 * JOStatusInquiryDBDAO를 생성한다.<br>
	 */
	public JOStatusInquiryBCImpl() {
		dbDao = new JOStatusInquiryDBDAO();
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO
	 * @return List<SearchJOTPBDetailInfoVO>
	 * @exception EventException
	 */
	public List<SearchJOTPBDetailInfoVO> searchTPBDetailInfo(SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO) throws EventException {
		try {
			return dbDao.searchTPBDetailInfo(searchJOTpbDetailInfoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOTPBDetailListVO searchJOTpbDetailListVO
	 * @return List<SearchJOTPBDetailListVO>
	 * @exception EventException
	 */
	public List<SearchJOTPBDetailListVO> searchTPBDetailList(SearchJOTPBDetailListVO searchJOTpbDetailListVO) throws EventException {
		try {
			return dbDao.searchTPBDetailList(searchJOTpbDetailListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOInvoiceListVO searchJOInvoiceListVO
	 * @return List<SearchJOInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchJOInvoiceListVO> searchInvoiceList(SearchJOInvoiceListVO searchJOInvoiceListVO) throws EventException {
		try {
			return dbDao.searchInvoiceList(searchJOInvoiceListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchProcessListVO searchProcessListVO
	 * @return List<SearchProcessListVO>
	 * @exception EventException
	 */
	public List<SearchProcessListVO> searchProcessList(SearchProcessListVO searchProcessListVO) throws EventException {
		try {
			if (searchProcessListVO.getSIfRhqCd().length() < 5) searchProcessListVO.setSIfRhqCd("");
			if (searchProcessListVO.getSIfOfcCd().length() < 5) searchProcessListVO.setSIfOfcCd("");
			return dbDao.searchJOStatusInquiry(searchProcessListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}