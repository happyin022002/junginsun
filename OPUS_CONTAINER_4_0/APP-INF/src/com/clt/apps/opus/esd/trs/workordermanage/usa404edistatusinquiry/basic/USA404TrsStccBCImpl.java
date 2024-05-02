/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404TrsStccBCImpl.java
*@FileTitle : USA404TrsStccBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0802Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404TrsStccDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
* ESD-TRS Business Logic Basic Command implementation<br>
*
* @author 
* @see USA404TrsStccBCImpl
* @since J2EE 1.4
*/
public class USA404TrsStccBCImpl extends BasicCommandSupport implements USA404TrsStccBC {

	// Database Access Object
	private transient USA404TrsStccDBDAO dbDao = null;

	/**
	 * USA404TrsStccBCImpl object create<br>
	 * AgreementTrsStccDBDAO object create<br>
	 */
	public USA404TrsStccBCImpl() {
		dbDao = new USA404TrsStccDBDAO();
	}

	/**
	 * retrieve Trs Stcc
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<TrsStccVO> searchTrsStcc(EsdTrs0802Event event) throws EventException {
		try {
			return dbDao.searchTrsStcc(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * manage Trs Stcc
	 * 
	 * @param trsStccVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageTrsStcc(TrsStccVO[] trsStccVOs, SignOnUserAccount account) throws EventException {
		if(trsStccVOs == null) return;
		
		try {
			List<TrsStccVO> insertVoList = new ArrayList<TrsStccVO>();
			List<TrsStccVO> updateVoList = new ArrayList<TrsStccVO>();
			List<TrsStccVO> deleteVoList = new ArrayList<TrsStccVO>();
			
			for(int i=0; i<trsStccVOs.length; i++){
				if(trsStccVOs[i].getIbflag().equals("I")){
					trsStccVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(trsStccVOs[i]);
				}else if(trsStccVOs[i].getIbflag().equals("U")){
					trsStccVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(trsStccVOs[i]);
				}else if(trsStccVOs[i].getIbflag().equals("D")){
					trsStccVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(trsStccVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addTrsStcc(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyTrsStcc(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeTrsStcc(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}