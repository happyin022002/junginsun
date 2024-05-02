/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PlanMgtBCImpl.java
 *@FileTitle : Expense Plan Creation by HO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.basic;

import java.util.ArrayList;
import java.util.List;


import com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration.PlanMgtDBDAO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.clt.framework.component.message.ErrorHandler;	
import com.clt.framework.core.layer.event.EventException;		
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-PlanManage Business Logic Basic Command implementation<br>
 * - COM-PlanManage - disposing business logic<br>
 *
 * @author
 * @see EES_MNR_0112EventResponse,PlanMgtBC
 * @since J2EE 1.6
 * 
 */
public class PlanMgtBCImpl extends BasicCommandSupport implements PlanMgtBC {

	// Database Access Object
	private transient PlanMgtDBDAO dbDao = null;

	/**
	 * PlanMgtBCImpl creating object<br>
	 * PlanMgtDBDAO creating DAO object<br>
	 */
	public PlanMgtBCImpl() {
		dbDao = new PlanMgtDBDAO();
	}
	
  /**
   * [EES_MNR_0216]Retrieve "M&R Guideline & Information" data<br>
   *
   * @param GuidelineGRPVO guidelineGRPVO
   * @param SignOnUserAccount account
   * @return GuidelineGRPVO
   * @exception EventException
   */
	public GuidelineGRPVO searchGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomMnrGuidelineVO> customMnrGuidelineVO = new ArrayList<CustomMnrGuidelineVO>();
			
			guidelineGRPVO.getGuidelineINVO().setOfcCd(account.getOfc_cd());
			customMnrGuidelineVO = dbDao.searchGuidelineInfoListData(guidelineGRPVO.getGuidelineINVO());
			guidelineGRPVO.setCustomMnrGuidelineLst(customMnrGuidelineVO);
			return guidelineGRPVO;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] searchGuidelineInfoListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] searchGuidelineInfoListBasic"}).getMessage(),ex);
		}
	}  

	/**
	 * [EES_MNR_0216]Add, modify, delete "M&R Guideline & Information" data<br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			CustomMnrGuidelineVO[]  customMnrGuidelineVOs  = guidelineGRPVO.getCustomMnrGuidelineVOs();
			if(customMnrGuidelineVOs == null ) return;
			
			List<CustomMnrGuidelineVO> insertVoList   = new ArrayList<CustomMnrGuidelineVO>();
			List<CustomMnrGuidelineVO> updateVoList   = new ArrayList<CustomMnrGuidelineVO>();
			List<CustomMnrGuidelineVO> deleteVoList   = new ArrayList<CustomMnrGuidelineVO>();
			
		
			for ( int i=0; i< customMnrGuidelineVOs.length; i++ ) { 
				if(customMnrGuidelineVOs[i] == null)break;
				customMnrGuidelineVOs[i].setCreUsrId(account.getUsr_id());
				customMnrGuidelineVOs[i].setUpdUsrId(account.getUsr_id());				
				if ( customMnrGuidelineVOs[i].getIbflag().equals("I")){  
					insertVoList.add(customMnrGuidelineVOs[i]);  
				} else if ( customMnrGuidelineVOs[i].getIbflag().equals("U")){
					updateVoList.add(customMnrGuidelineVOs[i]);  
				} else if ( customMnrGuidelineVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrGuidelineVOs[i]);               
				}              
			}             
			    
			if ( insertVoList.size() > 0 ) {
				dbDao.addGuidelineInfoData(insertVoList);
			} 			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyGuidelineInfoData(updateVoList);
			}   			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGuidelineInfoData(deleteVoList);
			}  
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] manageGuidelineInfoListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] manageGuidelineInfoListBasic"}).getMessage(),de);
		}
		
	}
}