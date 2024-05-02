/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageBCImpl.java
*@FileTitle : S/P Category 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration.ServiceProviderCategoryManageDBDAO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchOfficeCodeAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeSvcProvSvcCateMtchVO;

/**
 * ALPS-MasterManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-MasterManage<br>
 *
 * @author 
 * @see ESD_SPE_002EventResponse,ServiceProviderCategoryManageBC
 * @since J2EE 1.6
 */
public class ServiceProviderCategoryManageBCImpl extends BasicCommandSupport implements ServiceProviderCategoryManageBC {

	// Database Access Object
	private transient ServiceProviderCategoryManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating ServiceProviderCategoryManageDBDAO class<br>
	 */
	public ServiceProviderCategoryManageBCImpl() {
		dbDao = new ServiceProviderCategoryManageDBDAO();
	}
	
	/**
	 * Retrieving the managing SP Category<br>
	 * 
	 * @param SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO
	 * @return List<SearchSPCategoryManageVO>
	 * @exception EventException
	 */
	public List<SearchSPCategoryManageVO> searchSPCategoryManage(SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO) throws EventException {
		try {
			String chkUnique ="";
			String vndrSeq ="";
			
			vndrSeq =searchSPCategoryManageConditionVO.getVndrSeq();
			
			chkUnique = dbDao.cofirmUnique(vndrSeq);
			
			searchSPCategoryManageConditionVO.setChkUnique(chkUnique);
			
			return dbDao.searchSPCategoryManage(searchSPCategoryManageConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Retrieving the list of all office code<br>
	 * 
	 * @return List<SearchOfficeCodeAllListVO>
	 * @exception EventException
	 */
	public List<SearchOfficeCodeAllListVO> searchOfficeCodeAllList() throws EventException {
		try {
			
			return dbDao.searchOfficeCodeAllList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Retrieving the vendor sequence
	 * 
	 * @param SearchVndrSeqVO searchVndrSeqVO
	 * @return List<SearchVndrSeqVO>
	 * @exception EventException
	 */
	public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO) throws EventException{
		try {
			return dbDao.searchVndrSeq(searchVndrSeqVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Saving the data of SP Category
	 * 
	 * @param SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCategoryManage(SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs, SignOnUserAccount account) throws EventException{
		String chkUnique="";
		String vndrSeq="";
		try {
			List<SpeSvcProvSvcCateMtchVO> insertVoList = new ArrayList<SpeSvcProvSvcCateMtchVO>();
			List<SpeSvcProvSvcCateMtchVO> updateVoList = new ArrayList<SpeSvcProvSvcCateMtchVO>();
			List<SpeSvcProvSvcCateMtchVO> deleteVoList = new ArrayList<SpeSvcProvSvcCateMtchVO>();
			for ( int i=0; i<speSvcProvSvcCateMtchVOs .length; i++ ) {
				
				vndrSeq =speSvcProvSvcCateMtchVOs[i].getVndrSeq();
				
				chkUnique = dbDao.cofirmUnique(vndrSeq);
												
				if ( speSvcProvSvcCateMtchVOs[i].getIbflag().equals("I")){
					speSvcProvSvcCateMtchVOs[i].setCreUsrId(account.getUsr_id());
					speSvcProvSvcCateMtchVOs[i].setUpdUsrId(account.getUsr_id());
					
					if (chkUnique =="N"){
						insertVoList.add(speSvcProvSvcCateMtchVOs[i]);
					}else{
						updateVoList.add(speSvcProvSvcCateMtchVOs[i]);
					}					
					
				} else if ( speSvcProvSvcCateMtchVOs[i].getIbflag().equals("U")){
					speSvcProvSvcCateMtchVOs[i].setCreUsrId(account.getUsr_id());
					speSvcProvSvcCateMtchVOs[i].setUpdUsrId(account.getUsr_id());
					if (chkUnique =="N"){
						insertVoList.add(speSvcProvSvcCateMtchVOs[i]);
					}else{
						updateVoList.add(speSvcProvSvcCateMtchVOs[i]);
					}			
					
				} else if ( speSvcProvSvcCateMtchVOs[i].getIbflag().equals("D")){
					speSvcProvSvcCateMtchVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(speSvcProvSvcCateMtchVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpeSvcProvSvcCateMtch(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpeSvcProvSvcCateMtch(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpeSvcProvSvcCateMtch(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}