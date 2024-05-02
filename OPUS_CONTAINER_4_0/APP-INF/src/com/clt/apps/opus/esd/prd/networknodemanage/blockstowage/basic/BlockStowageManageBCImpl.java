/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManageImpl.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration.BlockStowageManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse,BlockStowageManage 
 * @since J2EE 1.4
 */
public class BlockStowageManageBCImpl extends BasicCommandSupport implements BlockStowageManageBC{

	private transient BlockStowageManageDBDAO dbDao = null;

	/**
	 * creating BlockStowageManageImpl<br>
	 * creating YardManageDBDAO<br>
	 */
	public BlockStowageManageBCImpl(){
		dbDao = new BlockStowageManageDBDAO();
	}

	/**
	 * retrieve - YardManage
	 *
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	@Override
	public List<GroupCreationVO> searchGroupCreationList(GroupCreationVO vo) throws EventException{
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
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<GroupCreationVO> searchLaneCode(GroupCreationVO vo) throws EventException{
		try{
			return dbDao.searchLaneCode(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieve - YardManage
	 *
	 * @param vos
	 * @param account
	 * @exception EventException
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
					if(this.searchGroupCreationList(vo).size() == 0){ // 1 : to delete, 0 : not to delete
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
	 * retrieve - YardManage
	 *
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	@Override
	public List<CodeInquiryVO> searchCodeInquiryList(CodeInquiryVO vo) throws EventException{
		try{
			return dbDao.searchCodeInquiryList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
