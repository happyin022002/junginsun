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
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchChassisCostVO;
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
public class CreateChassisUnitCostBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;
	private SearchChassisCostVO searchChassisCostVO = null;
	private SignOnUserAccount account = null;
	private String pgmNo = "";
    private WeeklyCMDBDAO dbDao = new WeeklyCMDBDAO();

	/**
	 * BackEndCommand Start
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {


        String[] arrSearch = searchChassisCostVO.getFEffFmYrmon().split("[-]");
        String year1 = arrSearch[0];
        String cost_mn1 = arrSearch[1];         
        searchChassisCostVO.setFEffFmYrmon(year1 + cost_mn1);
        
        String[] arrSearch2 = searchChassisCostVO.getFEffToYrmon().split("[-]");
        String year2 = arrSearch2[0];
        String cost_mn2 = arrSearch2[1];            
        searchChassisCostVO.setFEffToYrmon(year2 + cost_mn2);
                    
        String pErrorCode = dbDao.searchChassisStandardCostCreate(searchChassisCostVO, account);
 
 
		return null;	
	}



	public SearchChassisCostVO getSearchChassisCostVO() {
		return searchChassisCostVO;
	}

	public void setSearchChassisCostVO(SearchChassisCostVO searchChassisCostVO) {
		this.searchChassisCostVO = searchChassisCostVO;
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
