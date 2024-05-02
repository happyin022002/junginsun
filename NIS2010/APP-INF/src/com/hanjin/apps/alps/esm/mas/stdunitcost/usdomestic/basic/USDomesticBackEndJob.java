/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USDomesticBackEndJob.java
*@FileTitle : US domestic cost/credit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.basic;

import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.vo.SearchUSDomesticVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-AgreementManage Business Logic Command Interface<br>
 * - ALPS-AgreementManage에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author BOBAE KIM
 * @see ESM_MAS_0014 EventResponse,USDomesticBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class USDomesticBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;
	private SearchUSDomesticVO searchUSDomesticVO = null;
	private SignOnUserAccount account = null;
	private String pgmNo = "";

	/**
	 * BackEndCommand Start
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {

		USDomesticBC command = new USDomesticBCImpl();

		if (pgmNo.equals("ESM_MAS_0014")){
			command.createUSDomesticCost(searchUSDomesticVO, account);
		}
		return null;	
	}



	public SearchUSDomesticVO getSearchUSDomesticVO() {
		return searchUSDomesticVO;
	}

	public void setSearchUSDomesticVO(SearchUSDomesticVO searchUSDomesticVO) {
		this.searchUSDomesticVO = searchUSDomesticVO;
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
