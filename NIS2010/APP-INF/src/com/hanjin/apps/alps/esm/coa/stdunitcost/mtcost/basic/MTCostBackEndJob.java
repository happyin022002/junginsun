/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTCostBackEndJob.java
*@FileTitle : Monthly copy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 장준우
*@LastVersion : 1.0 
* 2010.09.24 장준우
* 1.0 Creation
* 
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.basic;

import java.util.HashMap;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration.MTCostDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-AgreementManage Business Logic Command Interface<br>
 * - ALPS-AgreementManage에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jang Jun-Woo
 * @see ESM_COA_0173 EventResponse,MTCostMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MTCostBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;

	private MTCostDBDAO dbDao = new MTCostDBDAO();

	private String jobType = null;

	private SearchConditionVO searchConditionVO = null;

	private SignOnUserAccount userAccount = null;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return Object result
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
//		Object result = null;
		HashMap<String, String> param = new HashMap<String, String>();
		try {
			if(getJobType().equals("MTCostMonthlyCopy")) {
			  param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			  param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
	          param.put("user_id"   	, userAccount.getUsr_id());

	            //1. EQ Repo 관련 TABLE들을 삭제 한다.
	            dbDao.removeEqRepoCost(param);

	            //2. Source월에서 Target 월로 데이터 인서트
	             dbDao.createCopyEqRepoCost(param);
	            //3. 복사 상태를 단가 관리 table에 insert 한다.
	             dbDao.modifyEqRepoCostCopyCreationStatus(param);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return null;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return searchConditionVO
	 */
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	/**
	 * @param SearchConditionVO searchConditionVO
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 * @return the userAccount
	 */
	public SignOnUserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(SignOnUserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
