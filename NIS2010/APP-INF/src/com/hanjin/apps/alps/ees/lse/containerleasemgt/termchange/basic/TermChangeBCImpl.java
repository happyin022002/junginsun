/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeBCImpl.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.integration.TermChangeDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;


/**
 * ALPS-ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0005EventResponse,TermChangeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TermChangeBCImpl extends BasicCommandSupport implements TermChangeBC {

	// Database Access Object
	private transient TermChangeDBDAO dbDao = null;

	/**
	 * TermChangeBCImpl 객체 생성<br>
	 * TermChangeDBDAO를 생성한다.<br>
	 */
	public TermChangeBCImpl() {
		dbDao = new TermChangeDBDAO();
	}

	/**
	 * 입력받은 Activity Date에 대한 유효성을 검증합니다.<br>
	 *
	 * @param searchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchAvailParamActivityDateBasic(SearchParamVO searchParamVO) throws EventException {
		boolean availFlag = false;

		try {
			availFlag = dbDao.isAvailActivityDateData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailParamActivityDate Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AvailParamActivityDate Search"}).getMessage(),ex);
		}

		return availFlag;
	}

	/**
	 * Term Change Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @exception EventException
	 */
	public List<TermChangeCreationVO> searchTermChangeCreationListBasic(SearchParamVO searchParamVO) throws EventException {
		List<TermChangeCreationVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchTermChangeCreationListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeCreationList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeCreationList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Term Change Creation 장비 처리이력을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeInquiryVO>
	 * @exception EventException
	 */
	public List<TermChangeInquiryVO> searchTermChangeInquiryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<TermChangeInquiryVO> resultVOs = null;

		try {
			//int cnt   = dbDao.searchTermChangeInquiryListCount(searchParamVO);
			resultVOs = dbDao.searchTermChangeInquiryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeInquiryList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeInquiryList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}
}