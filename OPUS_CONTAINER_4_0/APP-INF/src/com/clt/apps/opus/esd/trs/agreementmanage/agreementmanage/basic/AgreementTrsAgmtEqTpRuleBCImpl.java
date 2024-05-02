/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleBCImpl.java
*@FileTitle : AgreementTrsAgmtEqTpRuleBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0801Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration.AgreementTrsAgmtEqTpRuleDBDAO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsAgmtEqTpRuleVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * 
 * @author
 * @see AgreementTrsAgmtEqTpRuleBC
 * @since J2EE 1.6
 */
public class AgreementTrsAgmtEqTpRuleBCImpl extends BasicCommandSupport implements AgreementTrsAgmtEqTpRuleBC {

	// Database Access Object
	private transient AgreementTrsAgmtEqTpRuleDBDAO dbDao = null;

	/**
	 * AgreementTrsAgmtEqTpRuleBCImpl Object create<br>
	 * AgreementTrsAgmtEqTpRuleDBDAO Object create<br>
	 */
	public AgreementTrsAgmtEqTpRuleBCImpl() {
		dbDao = new AgreementTrsAgmtEqTpRuleDBDAO();
	}

	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<TrsAgmtEqTpRuleVO> searchTrsAgmtEqTpRule(EsdTrs0801Event event) throws EventException {
		try {
			return dbDao.searchTrsAgmtEqTpRule(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param trsAgmtEqTpRuleVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageTrsAgmtEqTpRule(TrsAgmtEqTpRuleVO[] trsAgmtEqTpRuleVOs, SignOnUserAccount account) throws EventException {
		if(trsAgmtEqTpRuleVOs == null) return;
		
		try {
			List<TrsAgmtEqTpRuleVO> insertVoList = new ArrayList<TrsAgmtEqTpRuleVO>();
			List<TrsAgmtEqTpRuleVO> updateVoList = new ArrayList<TrsAgmtEqTpRuleVO>();
			List<TrsAgmtEqTpRuleVO> deleteVoList = new ArrayList<TrsAgmtEqTpRuleVO>();
			
			for(int i=0; i<trsAgmtEqTpRuleVOs.length; i++){
				if(trsAgmtEqTpRuleVOs[i].getIbflag().equals("I")){
					trsAgmtEqTpRuleVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(trsAgmtEqTpRuleVOs[i]);
				}else if(trsAgmtEqTpRuleVOs[i].getIbflag().equals("U")){
					trsAgmtEqTpRuleVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(trsAgmtEqTpRuleVOs[i]);
				}else if(trsAgmtEqTpRuleVOs[i].getIbflag().equals("D")){
					trsAgmtEqTpRuleVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(trsAgmtEqTpRuleVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				// EQ KND Code Check
				dbDao.addTrsAgmtEqTpRule(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyTrsAgmtEqTpRule(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeTrsAgmtEqTpRule(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(EsdTrs0801Event event) throws EventException {
		try {
			return dbDao.searchComIntgCdDtl(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}