/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtBCImpl.java
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.07 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.integration.ExtraDisposalMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.CustomMnrXtraDispVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author WanGyu Kim    
 * @see EesMnr0093Event,ExtraDisposalMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4      
 */
public  class ExtraDisposalMgtBCImpl extends BasicCommandSupport implements ExtraDisposalMgtBC {
	// Database Access Object 
	private transient ExtraDisposalMgtDBDAO dbDao = null; 
		
	/** 	
	 * ExtraDisposalMgtBCImpl 객체 생성<br>
	 * ExtraDisposalMgtDBDAO 생성한다.<br>
	 */    
	public ExtraDisposalMgtBCImpl() {   
		dbDao = new ExtraDisposalMgtDBDAO(); 
	} 

	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO searchExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException {
		try { 
			List<CustomMnrXtraDispVO> listCustomMnrXtraDispVO = null; 
			
			listCustomMnrXtraDispVO = dbDao.searchExtraDisposalByEQData(extraDisposalMgtGRPVO.getExtraDisposalMgtINVO());
				
			extraDisposalMgtGRPVO.setListCustomMnrXtraDispVO(listCustomMnrXtraDispVO);   
			return extraDisposalMgtGRPVO;          
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] searchExtraDisposalByEQBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] searchExtraDisposalByEQBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 체크 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @return ExtraDisposalMgtGRPVO
	 * @exception EventException
	 */
	public ExtraDisposalMgtGRPVO checkExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws EventException {
		
		try { 
			String cnt = "";
			cnt = dbDao.checkExtraDisposalByEQData(extraDisposalMgtGRPVO);
			extraDisposalMgtGRPVO.setCnt(cnt);
			return extraDisposalMgtGRPVO;        
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] checkExtraDisposalByEQBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] checkExtraDisposalByEQBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageExtraDisposalByEQBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			CustomMnrXtraDispVO[]  arrayCustomMnrXtraDispVOs  = extraDisposalMgtGRPVO.getArrayCustomMnrXtraDispVOs();
			if(arrayCustomMnrXtraDispVOs == null ) return;
			
			List<CustomMnrXtraDispVO> insertVoList   = new ArrayList<CustomMnrXtraDispVO>();
			List<CustomMnrXtraDispVO> updateVoList   = new ArrayList<CustomMnrXtraDispVO>();
			List<CustomMnrXtraDispVO> deleteVoList   = new ArrayList<CustomMnrXtraDispVO>();
		
			for ( int i=0; i< arrayCustomMnrXtraDispVOs.length; i++ ) {
				if(arrayCustomMnrXtraDispVOs[i] == null)break;
				
				if ( arrayCustomMnrXtraDispVOs[i].getIbflag().equals("I")){
					String seq = dbDao.createExtraDisposalSequenceData();
					arrayCustomMnrXtraDispVOs[i].setXtraDispSeq(seq);
					arrayCustomMnrXtraDispVOs[i].setCreUsrId(account.getUsr_id());
					arrayCustomMnrXtraDispVOs[i].setUpdUsrId(account.getUsr_id());				
					insertVoList.add(arrayCustomMnrXtraDispVOs[i]);
				} else if ( arrayCustomMnrXtraDispVOs[i].getIbflag().equals("U")){
					arrayCustomMnrXtraDispVOs[i].setUpdUsrId(account.getUsr_id());				
					updateVoList.add(arrayCustomMnrXtraDispVOs[i]);  
				} else if ( arrayCustomMnrXtraDispVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(arrayCustomMnrXtraDispVOs[i]);  
				}
			}             
			    
			if ( insertVoList.size() > 0 ) {
				dbDao.addExtraDisposalByEQData(insertVoList);
			} 			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyExtraDisposalByEQData(updateVoList);
			}   	
			if ( deleteVoList.size() > 0 ) { 
				dbDao.removeExtraDisposalByEQData(deleteVoList);
			}   	
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] manageExtraDisposalByEQBasic"}).getMessage(),ex);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Creation] manageExtraDisposalByEQBasic"}).getMessage(),e);
		}
	}

	/**
	 * [EES_MNR_0094]Scrapping/Donation Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return ExtraDisposalMgtGRPVO  
	 * @exception EventException       
	 */ 
	public ExtraDisposalMgtGRPVO searchExtraDisposalListBasic(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO, SignOnUserAccount account) throws EventException {
		try { 
			List<CustomMnrXtraDispVO> listCustomMnrXtraDispVO = null; 
			
			listCustomMnrXtraDispVO = dbDao.searchExtraDisposalListData(extraDisposalMgtGRPVO.getExtraDisposalMgtINVO(), account);
				
			extraDisposalMgtGRPVO.setListCustomMnrXtraDispVO(listCustomMnrXtraDispVO);   
			return extraDisposalMgtGRPVO;          
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Inquiry] searchExtraDisposalListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Scrapping/Donation Inquiry] searchExtraDisposalListBasic"}).getMessage(),ex);
		}
	} 
	
}
