/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtBCImpl.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration.SHATideInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
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
 * @see VOP_OPF_0013EventResponse,SHATideInformationMgtBC, DAO
 * @since J2EE 1.6
 */
public class SHATideInformationMgtBCImpl extends BasicCommandSupport implements SHATideInformationMgtBC {

	// Database Access Object
	private transient SHATideInformationMgtDBDAO dbDao = null;

	/**
	 * SHATideInformationMgtBCImpl object creation<br>
	 * Creating SHATideInformationMgtDBDAO<br>
	 */
	public SHATideInformationMgtBCImpl() {
		dbDao = new SHATideInformationMgtDBDAO();
	}
	/**
	 * Retrieving SHA Tide Information Creation
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return List<VskPortTideVO>
	 * @exception EventException
	 */
	public List<VskPortTideVO> searchTideInfoList(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchTideInfoList(sHATideInformationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SHA Tide Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SHA Tide Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Port Code<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return VskPortTideVO
	 * @exception EventException
	 */
	public VskPortTideVO searchPortCode(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchPortCode(sHATideInformationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving SHA Tide Information Creation
	 * 
	 * @param vskPortTideVOs VskPortTideVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageTideInfo(VskPortTideVO[] vskPortTideVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortTideVO> insertVoList = new ArrayList<VskPortTideVO>();
			List<VskPortTideVO> updateVoList = new ArrayList<VskPortTideVO>();
			List<VskPortTideVO> deleteVoList = new ArrayList<VskPortTideVO>();
			for ( int i=0; i<vskPortTideVOs .length; i++ ) {
				if ( vskPortTideVOs[i].getIbflag().equals("I")){
//					vskPortTideVOs[i].setUpdUsrId(account.getCre_usr_id());
					vskPortTideVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vskPortTideVOs[i]);
				} else if ( vskPortTideVOs[i].getIbflag().equals("U")){
					vskPortTideVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortTideVOs[i]);
				} else if ( vskPortTideVOs[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortTideVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addsearchTideInfoListS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifysearchTideInfoListS(updateVoList);
			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removesearchTideInfoListS(deleteVoList);
//			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SHA Tide Information Creation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SHA Tide Information Creation"}).getMessage(), ex);
		}
	}
	
}