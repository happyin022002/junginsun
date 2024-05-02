/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DropOffInquiryBCImpl.java   
*@FileTitle : Drop Off Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration.DropOffInquiryDBDAO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryDetailListVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * DropOffInquiryBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.4 
 */
public class DropOffInquiryBCImpl extends BasicCommandSupport implements DropOffInquiryBC {
	
	// Database Access Object
	private transient DropOffInquiryDBDAO dbDao = null;
	
	/**
	 * DropOffInquiryBCImpl 객체 생성<br>
	 * DropOffInquiryDBDAO 생성한다.<br>
	 */
	public DropOffInquiryBCImpl() {
		dbDao = new DropOffInquiryDBDAO();
	}

	/**
	 * DOD Queue List 조회
	 * 
	 * @category EES_DOD_0003
	 * @param searchDodDrpOffChgVO SearchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @throws EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDropOffQueueListInquiryList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		List<SearchDodDrpOffChgVO> list = null;
		try {
			list = dbDao.searchDropOffQueueListInquiryList(searchDodDrpOffChgVO);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return list;
	}
	
	/**
	 * DropOff Invoice Inquiry List
	 * 
	 * @category EES_DOD_0004
	 * @param dropOffInvoiceInquiryINVO DropOffInvoiceInquiryINVO
	 * @return List<DropOffInvoiceInquiryINVO>
	 * @throws EventException
	 */
	public List<DropOffInvoiceInquiryListVO> searchDropOffInvoiceInquiryList(DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO) throws EventException {
		try {
			List<DropOffInvoiceInquiryListVO> list = dbDao.searchDropOffInvoiceInquiryList(dropOffInvoiceInquiryINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * DropOff Invoice Inquiry Detail List
	 * 
	 * @category EES_DOD_0011
	 * @param dropOffInvoiceInquiryDetailListVO DropOffInvoiceInquiryDetailListVO
	 * @return List<DropOffInvoiceInquiryDetailListVO>
	 * @throws EventException
	 */	public List<DropOffInvoiceInquiryDetailListVO> searchDropOffInvoiceInquiryDetailList(DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO) throws EventException {
			try {
				List<DropOffInvoiceInquiryDetailListVO> list = dbDao.searchDropOffInvoiceInquiryDetailList(dropOffInvoiceInquiryINVO);
				return list;
				
			} catch(DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
	}
	
}
