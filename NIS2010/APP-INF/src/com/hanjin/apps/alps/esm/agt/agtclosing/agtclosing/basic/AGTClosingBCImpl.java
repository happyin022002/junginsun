/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTClosingBCImpl.java
*@FileTitle : Monthly Target VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.07 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration.AGTClosingDBDAO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.EstmPerfRptListVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryDetailVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.GlEstmRevVvdVO;

/**
 * ALPS-AGTClosing Business Logic Basic Command implementation<br>
 * - ALPS-AGTClosing에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyung-won Chu
 * @see EsmAgt0019EventResponse,AGTClosingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGTClosingBCImpl extends BasicCommandSupport implements AGTClosingBC {

	// Database Access Object
	private transient AGTClosingDBDAO dbDao = null;

	/**
	 * AGTClosingBCImpl 객체 생성<br>
	 * AGTClosingDBDAO를 생성한다.<br>
	 */
	public AGTClosingBCImpl() {
		dbDao = new AGTClosingDBDAO();
	}
	/**
	 * ESM_AGT_0032 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @exception EventException
	 */
	public List<GlEstmRevVvdVO> searchCommTargetVVD(GlEstmRevVvdVO glEstmRevVvdVO) throws EventException {
		try {
			return dbDao.searchCommTargetVVD(glEstmRevVvdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0019 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @exception EventException
	 */
	public List<GlEstmRevVvdVO> searchAfterClosingList(GlEstmRevVvdVO glEstmRevVvdVO) throws EventException {
		try {
			return dbDao.searchAfterClosingList(glEstmRevVvdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESM_AGT_0052 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCSRInquiryVO searchCSRInquiryVO
	 * @return List<SearchCSRInquiryVO>
	 * @exception EventException
	 */
	public List<SearchCSRInquiryVO> searchCSRIquiry(SearchCSRInquiryVO searchCSRInquiryVO) throws EventException {
		try {
			if(searchCSRInquiryVO.getMultiCsrNo().isEmpty()){
				//agtCommListVO.setBlNos("'"+agtCommListVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
				searchCSRInquiryVO.setMultiCsrNo(searchCSRInquiryVO.getMultiCsrNo().replaceAll(" ", "").replaceAll(",", "','"));
			}
			else {
				//agtCommListVO.setBlNos("'"+agtCommListVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
				searchCSRInquiryVO.setMultiCsrNo("('"+searchCSRInquiryVO.getMultiCsrNo().replaceAll(" ", "").replaceAll(",", "','")+"')");
			}			
			
			return dbDao.searchCSRIquiry(searchCSRInquiryVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0053 : [이벤트]<br>
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCSRInquiryDetailVO searchCSRInquiryDetailVO
	 * @return List<SearchCSRInquiryDetailVO>
	 * @exception EventException
	 */
	public List<SearchCSRInquiryDetailVO> searchCSRIquiryDetail(SearchCSRInquiryDetailVO searchCSRInquiryDetailVO) throws EventException {
		try {
			return dbDao.searchCSRIquiryDetail(searchCSRInquiryDetailVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0055 : [Retrieve]<br>
	 * [AGT commission의 추정실적]을 [조회]합니다.<br>
	 * 
	 * @param EstmPerfRptListVO estmPerfRptListVO
	 * @return List<EstmPerfRptListVO>
	 * @exception EventException
	 */
	public List<EstmPerfRptListVO> searchEstmPerfRptByRvvd(EstmPerfRptListVO estmPerfRptListVO) throws EventException{
		try {
			return dbDao.searchEstmPerfRptByRvvd(estmPerfRptListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
}