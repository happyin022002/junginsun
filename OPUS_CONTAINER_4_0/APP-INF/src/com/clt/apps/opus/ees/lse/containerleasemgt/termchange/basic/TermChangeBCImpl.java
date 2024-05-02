/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeBCImpl.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration.TermChangeDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * Handling Biz Logic of ContainerLeaseMgt<br>
 *
 * @author
 * @see EES_LSE_0005EventResponse,TermChangeBC 
 * @since J2EE 1.6
 */
public class TermChangeBCImpl extends BasicCommandSupport implements TermChangeBC {

	// Database Access Object
	private transient TermChangeDBDAO dbDao = null;

	/**
	 * Generating TermChangeBCImpl Object<br>
	 * Generating TermChangeDBDAO<br>
	 */
	public TermChangeBCImpl() {
		dbDao = new TermChangeDBDAO();
	}

	/**
	 * Verifying Effectiveness about inserted Activity Date<br>
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
	 * Retrieving Equipment List targeting to Term Change Creation<br>
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
	 * Retrieving Equipment List targeting to Term Change Creation<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @exception EventException
	 */
	public List<TermChangeCreationVO> searchBigDataTermChangeCreationListBasic(SearchParamVO searchParamVO) throws EventException {
		List<TermChangeCreationVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchBigDataTermChangeCreationListData(searchParamVO);
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
	 * Retrieving Term Change Creation Equipment handling record<br>
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
	
	
	/**
	 *
	 * @param SearchParamVO[] searchParamVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */ 
	public String createLseTempBasic(SearchParamVO[] searchParamVOs,SignOnUserAccount account) throws EventException {
		String seqValue  = "";
		try {  
			List<SearchParamVO> insertVoList = new ArrayList<SearchParamVO>();
			           
			seqValue = dbDao.addLseTempSequenceData();
			for(int i=0;i<searchParamVOs.length;i++) {
				searchParamVOs[i].setTmpSeq(seqValue); 
				searchParamVOs[i].setCreUsrId(account.getUsr_id());
				searchParamVOs[i].setUpdUsrId(account.getUsr_id());
				searchParamVOs[i].setCntrNo(searchParamVOs[i].getCntrNo());
				
				searchParamVOs[i].setCntrPkupPsvAmt(searchParamVOs[i].getCntrPkupPsvAmt());
				searchParamVOs[i].setCntrPkupNgvAmt(searchParamVOs[i].getCntrPkupNgvAmt());
				searchParamVOs[i].setCntrMinOnhDys(searchParamVOs[i].getCntrMinOnhDys());
				searchParamVOs[i].setRntlChgFreeDys(searchParamVOs[i].getRntlChgFreeDys());
				searchParamVOs[i].setDiiFee(searchParamVOs[i].getDiiFee());
				searchParamVOs[i].setTmpDtlSeq((i + 1) + "");
				insertVoList.add(searchParamVOs[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addLseTempData(insertVoList);   
			} 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} 
		return seqValue;
	}
	
}