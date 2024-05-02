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
package com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.integration.BlockStowageManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
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
public class BlockStowageManageBCImpl extends BasicCommandSupport implements BlockStowageManageBC{

	// Database Access Object
	private transient BlockStowageManageDBDAO dbDao = null;

	/**
	 * BlockStowageManageImpl 객체 생성<br>
	 * YardManageDBDAO를 생성한다.<br>
	 */
	public BlockStowageManageBCImpl(){
		dbDao = new BlockStowageManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	@Override
	public List searchGroupCreationList(GroupCreationVO vo) throws EventException{
		try{
			return dbDao.searchGroupCreationList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchLaneCode(GroupCreationVO vo) throws EventException{
		try{
			return dbDao.searchLaneCode(vo);
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
	 * MERGE를 안쓴 이유, ON 절에 포함된 INTO 테이블 컬럼은 수정할 수 없다.
	 */
	@Override
	public void multiGroupCreation(GroupCreationVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			for(int i = 0; i < vos.length; i++){
				vos[i].setUserId(account.getUsr_id());
				if(vos[i].getIbflag().equals("I")){
					GroupCreationVO vo = vos[i];
					vo.setDelFlag("Y");
					String groupCode = vo.getGroupCode();
					vo.setGroupCode("");
					if(this.searchGroupCreationList(vo).size() == 0){ // 1은 삭제, 0은 안삭제
						vo.setGroupCode(groupCode);
						vo.setDelFlag("0");
						dbDao.insertGroupCreation(vo);
					}else{
						vo.setGroupCode(groupCode);
						dbDao.updateGroupCreation(vo);
					}
				}else if(vos[i].getIbflag().equals("U")){
					dbDao.updateGroupCreation(vos[i]);
				}
//				else if(vos[i].getIbflag().equals("D")){
//				}
			} // end for
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
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	@Override
	public List searchCodeInquiryList(CodeInquiryVO vo) throws EventException{
		try{
			return dbDao.searchCodeInquiryList(vo);
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
