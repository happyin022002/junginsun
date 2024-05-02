/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtBCImpl.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration.VesselInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.MdmVslCntrExcelVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DraftWeightListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - Handling business logic of VesselOperationSupportMgt<br>
 *
 * @author 
 * @see VOP_VSK_0503EventResponse,VesselInformationMgtBC, DAO
 * @since J2EE 1.6
 */
public class VesselInformationMgtBCImpl extends BasicCommandSupport implements VesselInformationMgtBC {

	// Database Access Object
	private transient VesselInformationMgtDBDAO dbDao = null;

	/**
	 * VesselInformationMgtBCImpl object creation<br>
	 * Creating VesselInformationMgtDBDAO<br>
	 */
	public VesselInformationMgtBCImpl() {
		dbDao = new VesselInformationMgtDBDAO();
	}
	
	/**
	 * Retrieving Particular I, Particular II<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPartIVO searchVSLPartI(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			//return dbDao.searchVSLPartI(vesselInformationMgtConditionVO);
			VSLPartIVO vSLPartIVO = dbDao.searchVSLPartI(vesselInformationMgtConditionVO);
			List<MdmVslCntrExcelVO> mdmVslCntrExcelVO = dbDao.searchVSLPartIList(vesselInformationMgtConditionVO);
			vSLPartIVO.setMdmVslCntrExcelVOL(mdmVslCntrExcelVO);
			
			return vSLPartIVO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Dock Plan<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<DockPlanListVO>
	 * @exception EventException
	 */
	public List<DockPlanListVO> searchDockPlanList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchDockPlanList(vesselInformationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve Draft & Weight <br>
	 * 
	 * @return List<DraftWeightVO>
	 * @exception EventException
	 */
	public List<DraftWeightListVO> searchDraftWeightList() throws EventException {
		try {
			return dbDao.searchDraftWeightList();
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Draft & Weight"}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12203", new String[]{"Draft & Weight"}).getMessage(), ex);
		}
	}

	/**
	 * Save Draft & Weight<br>
	 * 
	 * @param DraftWeightListVO[] draftWeightListVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageDraftWeightList(DraftWeightListVO[] draftWeightListVOs, SignOnUserAccount account) throws EventException {
		
		try {
//			dbDao.removeDraftWeightList();
			
			List<String> vslCdList = new ArrayList<String>();
			List<String> errorVslCdList = new ArrayList<String>();
			List<DraftWeightListVO> subDraftWeightVOs = null;
			
			for(int i=0; i<draftWeightListVOs.length; i++){
				if(!vslCdList.contains(draftWeightListVOs[i].getVslCd())){
					if(subDraftWeightVOs!=null && subDraftWeightVOs.size() > 0){
						if(!addSubList(subDraftWeightVOs, account)){
							errorVslCdList.add(subDraftWeightVOs.get(0).getVslCd());
						}
					}
					
				vslCdList.add(draftWeightListVOs[i].getVslCd()); //If VslCod doesn't exist in List, add Code
				subDraftWeightVOs = new ArrayList<DraftWeightListVO>();
				subDraftWeightVOs.add(draftWeightListVOs[i]);
					
				}else{ //If VslCode exists in List, add Vo
					if(subDraftWeightVOs!=null){
						subDraftWeightVOs.add(draftWeightListVOs[i]);	
					}
				}
			}
			
			if(subDraftWeightVOs!=null && subDraftWeightVOs.size() > 0){
				if(!addSubList(subDraftWeightVOs, account)){
					errorVslCdList.add(subDraftWeightVOs.get(0).getVslCd());
				}
			}
			
			return errorVslCdList;
//		} catch(DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft&Weight"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft&Weight"}).getMessage(), ex);
		}
	}

	/**
	 * Save Draft & Weight<br>
	 * 
	 * @param List<DraftWeightListVO> subDraftWeightVOs
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception EventException
	 */
	private boolean addSubList (List<DraftWeightListVO> subDraftWeightVOs, SignOnUserAccount account) throws EventException {
		try{
			String vslCd = dbDao.searchVslCode(subDraftWeightVOs.get(0).getVslCd());
			if(!"".equals(vslCd)){
				for(int i = 0; i < subDraftWeightVOs.size(); i++){
					subDraftWeightVOs.get(i).setCreUsrId(account.getUsr_id());
				}
				dbDao.removeDraftWeightList(subDraftWeightVOs);
				dbDao.addDraftWeightList(subDraftWeightVOs);
				return true;
			}else{
				return false;
			}
		}catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft&Weight"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft&Weight"}).getMessage(), ex);
		}
	}

}