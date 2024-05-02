/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManageImpl.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.integration.PickupReturnCyManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse,BlockStowageManage 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PickupReturnCyManageBCImpl extends BasicCommandSupport implements PickupReturnCyManageBC{

	// Database Access Object
	private transient PickupReturnCyManageDBDAO dbDao = null;

	/**
	 * BlockStowageManageImpl 객체 생성<br>
	 * YardManageDBDAO를 생성한다.<br>
	 */
	public PickupReturnCyManageBCImpl(){
		dbDao = new PickupReturnCyManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	public List searchPickupList(PickupReturnCYVO vo) throws EventException{
		try{
			return dbDao.searchPickupList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param vos
	 * @param account
	 * @exception EventException
	 */
	public void multiPickupReturnCY(PickupReturnCYVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			for(int i = 0; i < vos.length; i++){
				vos[i].setUserId(account.getUsr_id());
				if(vos[i].getIbflag().equals("I")){
					dbDao.insertPickupReturnCY(vos[i]);
				}else if(vos[i].getIbflag().equals("U") || vos[i].getIbflag().equals("D")){
					dbDao.updatePickupReturnCY(vos[i]);
					//}else if(vos[i].getIbflag().equals("D")){
					//	dbDao.deletePickupReturnCY(vos[i]);
				}
			} // end for
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * YardManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
