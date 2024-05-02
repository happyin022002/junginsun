/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostSetUpBackEndJob.java
*@FileTitle : MTY Reposition Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.13
*@LastModifier : 최성민
*@LastVersion : 1.0 
* 2012.12.13 최성민
* 1.0 Creation
* 2012.12.13 최성민 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.basic;

import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-AgreementManage Business Logic Command Interface<br>
 * - ALPS-AgreementManage에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author 
 * @see ESM_MAS_0022 EventResponse,CostSetUpBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CostSetUpBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;
	private MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs = null;
	private SignOnUserAccount account = null;
	private String pgmNo = "";

	/**
	 * BackEndCommand Start
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {

		CostSetUpBC command = new CostSetUpBCImpl();

		if (pgmNo.equals("ESM_MAS_0022")){
			command.createMtyRepoTESTRSCost(mtyRepoTESTRSCostVOs, account);
		}
		return null;	
	}

	public MtyRepoTESTRSCostVO[] getMtyRepoTESTRSCostVOs() {
		return mtyRepoTESTRSCostVOs;
	}

	public void setMtyRepoTESTRSCostVOs(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs) {
		this.mtyRepoTESTRSCostVOs = mtyRepoTESTRSCostVOs;
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}


	public String getPgmNo() {
		return pgmNo;
	}

	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
}
