/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName :CreditIncentiveStatusBCImpl.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.basic;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event.EsdEas0501Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.basic.CreditIncentiveStatusBC;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration.CreditIncentiveStatusDBDAO;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TotStatusMkrVO;

/**
 * CreditIncentiveStatusBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author SHIN DONG IL
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class CreditIncentiveStatusBCImpl extends BasicCommandSupport implements CreditIncentiveStatusBC {
	// Database Access Object
	private transient CreditIncentiveStatusDBDAO dbDao = null;
	
	/**
	 * DBDAO 객체 생성
	 */
	public CreditIncentiveStatusBCImpl() {
		dbDao = new CreditIncentiveStatusDBDAO();
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Terminal 조회한다. <br>
	 * @param e
	 * @return List<TesStatusIncntVO>
	 * @exception EventException
	 */
	public List<TesStatusIncntVO> searchTesIncentiveList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchTesIncentiveList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Save 기능
	 * @param tesStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiTesIncentive(TesStatusIncntVO[] tesStatusIncntVOs,Event e) throws EventException{
		try {
			TesStatusIncntVO tesStatusIncntVO = new TesStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<tesStatusIncntVOs.length; i++ ) {
				tesStatusIncntVO = tesStatusIncntVOs[i];
				dbDao.multiTesIncentive(tesStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTesFileAttach(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyTesFileAttach(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTesFileAttach2(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyTesFileAttach2(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TES Incentive Delete 기능
	 * @param tesStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeTesIncentive(TesStatusIncntVO[] tesStatusIncntVOs,Event e) throws EventException{
		try {
			TesStatusIncntVO tesStatusIncntVO = new TesStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<tesStatusIncntVOs.length; i++ ) {
				tesStatusIncntVO = tesStatusIncntVOs[i];
				dbDao.removeTesIncentive(tesStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Transportation 조회한다. <br>
	 * @param e
	 * @return List<TrsStatusIncntVO>
	 * @exception EventException
	 */
	public List<TrsStatusIncntVO> searchTrsIncentiveList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchTrsIncentiveList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Save 기능
	 * @param trsStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiTrsIncentive(TrsStatusIncntVO[] trsStatusIncntVOs,Event e) throws EventException{
		try {
			TrsStatusIncntVO trsStatusIncntVO = new TrsStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<trsStatusIncntVOs.length; i++ ) {
				trsStatusIncntVO = trsStatusIncntVOs[i];
				dbDao.multiTrsIncentive(trsStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive Delete 기능
	 * @param trsStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeTrsIncentive(TrsStatusIncntVO[] trsStatusIncntVOs,Event e) throws EventException{
		try {
			TrsStatusIncntVO trsStatusIncntVO = new TrsStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<trsStatusIncntVOs.length; i++ ) {
				trsStatusIncntVO = trsStatusIncntVOs[i];
				dbDao.removeTrsIncentive(trsStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTrsFileAttach(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyTrsFileAttach(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status TRS Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyTrsFileAttach2(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyTrsFileAttach2(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status VSL 운항 조회한다. <br>
	 * @param e
	 * @return List<VslStatusIncntVO>
	 * @exception EventException
	 */
	public List<VslStatusIncntVO> searchVslIncentiveList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchVslIncentiveList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Save 기능
	 * @param vslStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiVslIncentive(VslStatusIncntVO[] vslStatusIncntVOs,Event e) throws EventException{
		try {
			VslStatusIncntVO vslStatusIncntVO = new VslStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<vslStatusIncntVOs.length; i++ ) {
				vslStatusIncntVO = vslStatusIncntVOs[i];
				dbDao.multiVslIncentive(vslStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive Delete 기능
	 * @param vslStatusIncntVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeVslIncentive(VslStatusIncntVO[] vslStatusIncntVOs,Event e) throws EventException{
		try {
			VslStatusIncntVO vslStatusIncntVO = new VslStatusIncntVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<vslStatusIncntVOs.length; i++ ) {
				vslStatusIncntVO = vslStatusIncntVOs[i];
				dbDao.removeVslIncentive(vslStatusIncntVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}	
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyVslFileAttach(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyVslFileAttach(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status VSL Incentive File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyVslFileAttach2(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyVslFileAttach2(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status VSL 운항 조회한다. <br>
	 * @param e
	 * @return List<MnrStatusCrIssVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrIssVO> searchMnrCreditIssueList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchMnrCreditIssueList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Save 기능
	 * @param mnrStatusCrIssVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMnrCreditIssue(MnrStatusCrIssVO[] mnrStatusCrIssVOs,Event e) throws EventException{
		try {
			MnrStatusCrIssVO mnrStatusCrIssVO = new MnrStatusCrIssVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<mnrStatusCrIssVOs.length; i++ ) {
				mnrStatusCrIssVO = mnrStatusCrIssVOs[i];
				dbDao.multiMnrCreditIssue(mnrStatusCrIssVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Issue Delete 기능
	 * @param mnrStatusCrIssVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMnrCreditIssue(MnrStatusCrIssVO[] mnrStatusCrIssVOs,Event e) throws EventException{
		try {
			MnrStatusCrIssVO mnrStatusCrIssVO = new MnrStatusCrIssVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<mnrStatusCrIssVOs.length; i++ ) {
				mnrStatusCrIssVO = mnrStatusCrIssVOs[i];
				dbDao.removeMnrCreditIssue(mnrStatusCrIssVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMnrFileAttach(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyMnrFileAttach(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit File Attach 기능
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMnrFileAttach2(Event e) throws EventException{
		try {

			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyMnrFileAttach2(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status M&R Credit Used 조회한다. <br>
	 * @param e
	 * @return List<MnrStatusCrUsdVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrUsdVO> searchMnrCreditUsedList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchMnrCreditUsedList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Save 기능
	 * @param mnrStatusCrUsdVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMnrCreditUsed(MnrStatusCrUsdVO[] mnrStatusCrUsdVOs,Event e) throws EventException{
		try {
			MnrStatusCrUsdVO mnrStatusCrUsdVO = new MnrStatusCrUsdVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<mnrStatusCrUsdVOs.length; i++ ) {
				mnrStatusCrUsdVO = mnrStatusCrUsdVOs[i];
				dbDao.multiMnrCreditUsed(mnrStatusCrUsdVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credit & Incentive Status M&R Credit Used Delete 기능
	 * @param mnrStatusCrUsdVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMnrCreditUsed(MnrStatusCrUsdVO[] mnrStatusCrUsdVOs,Event e) throws EventException{
		try {
			MnrStatusCrUsdVO mnrStatusCrUsdVO = new MnrStatusCrUsdVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<mnrStatusCrUsdVOs.length; i++ ) {
				mnrStatusCrUsdVO = mnrStatusCrUsdVOs[i];
				dbDao.removeMnrCreditUsed(mnrStatusCrUsdVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Credit 조회한다. <br>
	 * @param e
	 * @return List<BnfStatusMlgVO>
	 * @exception EventException
	 */
	public List<BnfStatusMlgVO> searchMileageList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchMileageList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Save. <br>
	 * @param bnfStatusMlgVOs
	 * @param e 
	 * @throws EventException
	 */
	public void multiMileage(BnfStatusMlgVO[] bnfStatusMlgVOs,Event e) throws EventException{
		try {
			BnfStatusMlgVO bnfStatusMlgVO = new BnfStatusMlgVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<bnfStatusMlgVOs.length; i++ ) {
				bnfStatusMlgVO = bnfStatusMlgVOs[i];
				dbDao.multiMileage(bnfStatusMlgVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Delete. <br>
	 * @param bnfStatusMlgVOs
	 * @param e 
	 * @throws EventException
	 */
	public void removeMileage(BnfStatusMlgVO[] bnfStatusMlgVOs,Event e) throws EventException{
		try {
			BnfStatusMlgVO bnfStatusMlgVO = new BnfStatusMlgVO();
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			for ( int i=0; i<bnfStatusMlgVOs.length; i++ ) {
				bnfStatusMlgVO = bnfStatusMlgVOs[i];
				dbDao.removeMileage(bnfStatusMlgVO,event);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Delete. <br>
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMileageFileAttach(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyMileageFileAttach(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Credti & Invcentive Status Mileage Delete. <br>
	 * @param e 
	 * @throws EventException
	 */
	public void modifyMileageFileAttach2(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			dbDao.modifyMileageFileAttach2(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * Part Credit Total by Maker 조회한다. <br>
	 * @param e
	 * @return List<TotStatusMkrVO>
	 * @exception EventException
	 */
	public List<TotStatusMkrVO> searchTotalStatusByMakerList(Event e) throws EventException{
		try {
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			return dbDao.searchTotalStatusByMakerList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 RHQ CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRhqOfficeCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckRhqOfficeCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Office CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckOfficeCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckOfficeCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * EsdEas0501Event  <br>
	 * 유효한 Port CODE 조회한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckPortCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckPortCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 YARD CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTesYardCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckTesYardCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * TERMINAL의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTesCostCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckTesCostCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsdEas0501Event  <br>
	 * TRANSPORTATION의 유효한 COST CODE CHECK한다. <br>
	 * 
	 * @param  e
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTrsCostCode(Event e) throws EventException{
		try {	
			EsdEas0501Event event  = (EsdEas0501Event)e ;
			String rtn_val = "";
			rtn_val = dbDao.searchCheckTrsCostCode(event);
			return rtn_val;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}