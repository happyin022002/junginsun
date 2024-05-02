/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeGeneralInfoMgtBCImpl.java
*@FileTitle : M&R Colleague Tree
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration.OfficeGeneralInfoMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcCntcPsonVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcGenInfoVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoMgtINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PlanManage Business Logic Basic Command implementation<br>
 * - ALPS-PlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author chung young hun
 * @see EES_MNR_0217EventResponse,OfficeGeneralInfoMgtBC 각 DAO 클래스 참조
 *         EES_MNR_0010EventResponse,OfficeGeneralInfoMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 * 
 */
public class OfficeGeneralInfoMgtBCImpl extends BasicCommandSupport implements OfficeGeneralInfoMgtBC {

	// Database Access Object
	private transient OfficeGeneralInfoMgtDBDAO dbDao = null;

	
	/**
	 * [EES_MNR_0135]Repair Approval Authority의 정보를 조회 합니다. <br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @return OfficeGeneralInfoListGRPVO
	 * @exception EventException
	 */
	public OfficeGeneralInfoListGRPVO searchOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) throws EventException {
		try {
//			return dbDao.searchOfficeGeneralInfoListData(officeGeneralInfoListGRPVO);
			List<CustomMnrOfcGenInfoVO> keyVoLst   = new ArrayList<CustomMnrOfcGenInfoVO>();
			OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO = officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO();
			CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO=new CustomMnrOfcGenInfoVO();
			customMnrOfcGenInfoVO.setOfcCd(officeGeneralInfoMgtINVO.getOfcCd());
			customMnrOfcGenInfoVO.setCostCd(officeGeneralInfoMgtINVO.getCostCd());
			customMnrOfcGenInfoVO.setArHdQtrOfcCd(officeGeneralInfoMgtINVO.getArHdQtrOfcCd());
			customMnrOfcGenInfoVO.setEqKndCd(officeGeneralInfoMgtINVO.getEqKndCd());
			customMnrOfcGenInfoVO.setCurrOfcCd(officeGeneralInfoMgtINVO.getCurrOfcCd());
			customMnrOfcGenInfoVO.setMnrGrpTpCd(officeGeneralInfoMgtINVO.getMnrGrpTpCd());
			keyVoLst.add(customMnrOfcGenInfoVO);
	    	officeGeneralInfoListGRPVO.setCustomMnrOfcGenInfoVOS(dbDao.searchOfficeGeneralInfoListData(keyVoLst));
	    	return officeGeneralInfoListGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0135] searchOfficeGeneralInfoListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0135] searchOfficeGeneralInfoListBasic"}).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * [EES_MNR_0010]Repair Approval Authority의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO,SignOnUserAccount account) throws EventException{
		try {
		
			CustomMnrOfcGenInfoVO[] vos = officeGeneralInfoListGRPVO.getArrCustomMnrOfcGenInfoVO();
			if(vos == null) return;
			List<CustomMnrOfcGenInfoVO> checkVoLst   = new ArrayList<CustomMnrOfcGenInfoVO>();
			List<CustomMnrOfcGenInfoVO> insertVoLst   = new ArrayList<CustomMnrOfcGenInfoVO>();
			List<CustomMnrOfcGenInfoVO> updateVoLst   = new ArrayList<CustomMnrOfcGenInfoVO>();
			List<CustomMnrOfcGenInfoVO> deleteVoLst   = new ArrayList<CustomMnrOfcGenInfoVO>();
			
			
			for ( int i=0; i < vos.length; i++ ) {
				if(vos[i] == null)break;
				
		    	if ( vos[i].getIbflag().equals("D")){
		    		    CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO = vos[i]; 
						deleteVoLst.add(customMnrOfcGenInfoVO);
						
			    }else  if (vos[i].getIbflag().equals("I")) {
			    	    CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO = vos[i]; 
			    	    customMnrOfcGenInfoVO.setCreUsrId(account.getUsr_id());
           		    	insertVoLst.add(customMnrOfcGenInfoVO);
           		    	
           		    	checkVoLst	= dbDao.searchOfficeGeneralInfoListData(insertVoLst);
        				if(checkVoLst.size()>0) {
        					throw new EventException(new ErrorHandler("MNR00186",new String[]{"[EES_MNR_0010]Repair Approval Authority"}).getMessage());
        				}

			    }else  if (vos[i].getIbflag().equals("U")) { 	
			    	    CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO = vos[i]; 
			    	    customMnrOfcGenInfoVO.setCreUsrId(account.getUsr_id());
	       		    	updateVoLst.add(customMnrOfcGenInfoVO);
				}	 
			}//for
			
		   if(deleteVoLst.size() > 0){
			   for(int i = 0 ; i < deleteVoLst.size();i++)
				   dbDao.removeOfficeGeneralInfoData((CustomMnrOfcGenInfoVO)deleteVoLst.get(i));
		   }
		   if(insertVoLst.size() > 0){
			   for(int i = 0 ; i < insertVoLst.size();i++)
				   dbDao.addOfficeGeneralInfoData((CustomMnrOfcGenInfoVO)insertVoLst.get(i));
		   }
		   if(updateVoLst.size() > 0){
			   for(int i = 0 ; i < updateVoLst.size();i++){
				   dbDao.removeOfficeGeneralInfoData((CustomMnrOfcGenInfoVO)updateVoLst.get(i));
				   dbDao.addOfficeGeneralInfoData((CustomMnrOfcGenInfoVO)updateVoLst.get(i));
				  // dbDao.modifyOfficeGeneralInfoData((CustomMnrOfcGenInfoVO)updateVoLst.get(i));
			   }	   
			   
		   }
		   
		} catch (EventException e){ 
		    log.error("err " + e.toString(), e);
			throw e;   
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0010] manageOfficeGeneralInfoListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0010] manageOfficeGeneralInfoListBasic"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 조회 합니다. <br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @return ColleagueTreeGRPVO
	 * @exception EventException
	 */
	public ColleagueTreeGRPVO searchColleagueTreeListBasic(ColleagueTreeGRPVO colleagueTreeGRPVO) throws EventException {
		try {
			return dbDao.searchColleagueTreeListData(colleagueTreeGRPVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0217] searchColleagueTreeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0217] searchColleagueTreeListBasic"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageColleagueTreeBasic(ColleagueTreeGRPVO colleagueTreeGRPVO,SignOnUserAccount account) throws EventException{
		try {
		
			CustomMnrOfcCntcPsonVO[] vos = colleagueTreeGRPVO.getArrCustomMnrOfcCntcPsonVO();
			if(vos == null) return;
			
			List<CustomMnrOfcCntcPsonVO> insertVoLst   = new ArrayList<CustomMnrOfcCntcPsonVO>();
			List<CustomMnrOfcCntcPsonVO> updateVoLst   = new ArrayList<CustomMnrOfcCntcPsonVO>();
			List<CustomMnrOfcCntcPsonVO> deleteVoLst   = new ArrayList<CustomMnrOfcCntcPsonVO>();
			
			
			for ( int i=0; i < vos.length; i++ ) {
				if(vos[i] == null)break;
				
		    	if ( vos[i].getIbflag().equals("D")){
		    		    CustomMnrOfcCntcPsonVO vo = vos[i]; 
						deleteVoLst.add(vo);
						
			    }else  if (vos[i].getIbflag().equals("I")) {
			    	    CustomMnrOfcCntcPsonVO vo = vos[i]; 
           		    	vo.setCreUsrId(account.getUsr_id());
           		    	insertVoLst.add(vo);

			    }else  if (vos[i].getIbflag().equals("U")) { 	
			    		CustomMnrOfcCntcPsonVO vo = vos[i]; 
	       		    	vo.setCreUsrId(account.getUsr_id());
	       		    	updateVoLst.add(vo);
				}	 
			}//for
			
		   if(deleteVoLst.size() > 0){
			   for(int i = 0 ; i < deleteVoLst.size();i++)
				   dbDao.removeColleagueTreeData((CustomMnrOfcCntcPsonVO)deleteVoLst.get(i));
		   }
		   if(insertVoLst.size() > 0){
			   for(int i = 0 ; i < insertVoLst.size();i++)
				   dbDao.addColleagueTreeData((CustomMnrOfcCntcPsonVO)insertVoLst.get(i));
		   }
		   if(updateVoLst.size() > 0){
			   for(int i = 0 ; i < updateVoLst.size();i++){
				   dbDao.removeColleagueTreeData((CustomMnrOfcCntcPsonVO)updateVoLst.get(i));
				   dbDao.addColleagueTreeData((CustomMnrOfcCntcPsonVO)updateVoLst.get(i));
				   //dbDao.modifyColleagueTreeData((CustomMnrOfcCntcPsonVO)updateVoLst.get(i));
			   }	   
		   }
		   
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0217] manageColleagueTreeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0217] manageColleagueTreeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * 생성자
	 */
	public OfficeGeneralInfoMgtBCImpl() {
		dbDao = new OfficeGeneralInfoMgtDBDAO();
	}
	
	

	
}