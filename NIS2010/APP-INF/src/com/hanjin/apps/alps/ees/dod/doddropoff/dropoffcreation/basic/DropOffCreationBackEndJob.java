/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationBackEndJob.java
*@FileTitle : DropOffCharge Save
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.11.10 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

public class DropOffCreationBackEndJob extends BackEndCommandSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5442512045400589789L;

	// Login User Information
	private SignOnUserAccount account = null;
	
	private SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;
	
	private DropOffCreationBC command = null;
	
	private String jobCommand = ""; 
	
	public DropOffCreationBackEndJob() {
		command = new DropOffCreationBCImpl();
	}

	@Override
	public Object doStart() throws Exception {
		
		List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList = null;
		
		try {
			//insert DOD_DRP_OFF_CHG
			searchDodDrpOffChgVOList = command.manageArInvList(searchDodDrpOffChgVOs, account.getUsr_id());
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		return searchDodDrpOffChgVOList;
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	public SearchDodDrpOffChgVO[] getSearchDodDrpOffChgVOs() {
		SearchDodDrpOffChgVO[] ret = null;
		
		if(this.searchDodDrpOffChgVOs != null) {
			ret = new SearchDodDrpOffChgVO[searchDodDrpOffChgVOs.length];
			
			for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
				ret[i] = this.searchDodDrpOffChgVOs[i];
			}
		}
		return ret;
	}

	public void setSearchDodDrpOffChgVOs(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs) {
		this.searchDodDrpOffChgVOs = new SearchDodDrpOffChgVO[searchDodDrpOffChgVOs.length];
		
		for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
			this.searchDodDrpOffChgVOs[i] = searchDodDrpOffChgVOs[i];
		}
	}

	public String getJobCommand() {
		return jobCommand;
	}

	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}

}
