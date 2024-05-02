/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceInquiryBCImpl.java
*@FileTitle : PerformanceInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.integration.PerformanceInquiryDBDAO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -PerformanceInquiry Business Logic Basic Command implementation<br>
 * - -PerformanceInquiry business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_105EventResponse,PerformanceInquiryBC DAO class reference
 * @since J2EE 1.6
 */
public class PerformanceInquiryBCImpl extends BasicCommandSupport implements PerformanceInquiryBC {

	// Database Access Object
	private transient PerformanceInquiryDBDAO dbDao = null;

	/**
	 * PerformanceInquiryBCImpl object creation<br>
	 * PerformanceInquiryDBDAO object creation<br>
	 */
	public PerformanceInquiryBCImpl() {
		dbDao = new PerformanceInquiryDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchClosingTPBListVO searchClosingTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchClosingTPBListVO>
	 * @exception EventException
	 */
	public List<SearchClosingTPBListVO> searchClosingTPBList(SearchClosingTPBListVO searchClosingTPBListVO, SignOnUserAccount account) throws EventException {
		try {
			searchClosingTPBListVO.setUserOfcCd(account.getOfc_cd());
			
			String s_if_rhq_cd = JSPUtil.getNull((String)searchClosingTPBListVO.getSIfRhqCd()); //RHQ
			if ( s_if_rhq_cd.equals("all") ) {
				searchClosingTPBListVO.setSIfRhqCd("");
			}
			String s_if_ctrl_cd = JSPUtil.getNull((String)searchClosingTPBListVO.getSIfCtrlCd()); //RHQ
			if ( s_if_ctrl_cd.equals("all") ) {
				searchClosingTPBListVO.setSIfCtrlCd("");
			}		
			String s_if_ofc_cd = JSPUtil.getNull((String)searchClosingTPBListVO.getSIfOfcCd()); //General Office
			if ( s_if_ofc_cd.equals("all") ) {
				searchClosingTPBListVO.setSIfOfcCd("");
			}
			return dbDao.searchClosingTPBList(searchClosingTPBListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchNonTPBListVO searchNonTPBListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchNonTPBListVO>
	 * @exception EventException
	 */
	public List<SearchNonTPBListVO> searchNonTPBList(SearchNonTPBListVO searchNonTPBListVO, SignOnUserAccount account) throws EventException{
		try {
			searchNonTPBListVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchNonTPBList(searchNonTPBListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchEACIssuanceListVO searchEACIssuanceListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchEACIssuanceListVO>
	 * @exception EventException
	 */
	public List<SearchEACIssuanceListVO> searchEACIssuanceList(SearchEACIssuanceListVO searchEACIssuanceListVO, SignOnUserAccount account) throws EventException {
		try {
			searchEACIssuanceListVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchEACIssuanceList(searchEACIssuanceListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}