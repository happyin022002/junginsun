/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtBCImpl.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
* 
* History
* 2010.10.05 CHM-201006264-01 유혁 Session User ID 설정로직 변경
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration.SHATideInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.VskPortTideVO;

/**
 * NIS2010-VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - NIS2010-VesselOperationSupportMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0013EventResponse,SHATideInformationMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SHATideInformationMgtBCImpl extends BasicCommandSupport implements SHATideInformationMgtBC {

	// Database Access Object
	private transient SHATideInformationMgtDBDAO dbDao = null;

	/**
	 * SHATideInformationMgtBCImpl 객체 생성<br>
	 * SHATideInformationMgtDBDAO를 생성한다.<br>
	 */
	public SHATideInformationMgtBCImpl() {
		dbDao = new SHATideInformationMgtDBDAO();
	}
	/**
	 * SHA Tide Information Creation 을 조회 합니다.<br>
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
	 * Port Code 유효성(체크) 을 조회 합니다.<br>
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
	
	/*
	 * CHM-201006264-01 Session User ID 설정로직 변경 getCre_Usr_id() -> getUsr_id()
	 */
	/**
	 * SHA Tide Information Creation 을 저장 합니다.<br>
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
					// CHM-201006264-01
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