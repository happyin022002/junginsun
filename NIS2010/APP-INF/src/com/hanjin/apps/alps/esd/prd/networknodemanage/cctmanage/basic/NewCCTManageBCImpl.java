/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageBCImpl.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-02-17
 *@LastModifier : SUN YONG JEONG
 *@LastVersion : 1.0
 * 2009-06-08 SUN YONG JEONG
 * 1.0 최초 생성
 * CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.integration.NewCCTManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import java.util.List;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeongseon An
 * @see ESD_PRD_034EventResponse,CCTmanageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class NewCCTManageBCImpl extends BasicCommandSupport implements NewCCTManageBC{

	// Database Access Object
	private transient NewCCTManageDBDAO dbDao = null;

	/**
	 * CCTmanageBCImpl 객체 생성<br>
	 * CCTmanageDBDAO를 생성한다.<br>
	 */
	public NewCCTManageBCImpl(){
		dbDao = new NewCCTManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CCTmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return EventResponse ESD_PRD_034EventResponse
	 * @exception EventException
	 */
	public List<NewCCTManageVO> searchCCTManage(NewCCTManageVO vo) throws EventException{
		try{
			return dbDao.searchCCTManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_034 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param vos
	 * @param account
	 * @exception EventException
	 */
	public void multiCCTManage(NewCCTManageVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			for(int i = 0; i < vos.length; i++){
				vos[i].setUserId(account.getUsr_id());
				if(vos[i].getIbflag().equals("I")){
					//중복체크 
					DBRowSet dbR = dbDao.checkCct(vos[i]);
					if(dbR.getRowCount() > 0){
						throw new EventException(new ErrorHandler(vos[i].getYardCode() + ", " + vos[i].getLaneCode()
								//+ ", Bound:" + (vos[i].getLaneDirCode().equals("A") ? "All" : vos[i].getLaneDirCode())
								+ ", Cargo:" + (vos[i].getCargoType().equals("AL") ? "All" : vos[i].getCargoType())
								+ " is already registerd. Please check again.").getMessage());
					}
				}
				dbDao.updateMultiCCTManage(vos[i]);
			} // end for

		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * CCTmanage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
