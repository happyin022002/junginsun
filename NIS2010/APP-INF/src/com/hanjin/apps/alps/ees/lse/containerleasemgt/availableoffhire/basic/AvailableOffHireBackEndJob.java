/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireBackEndJob.java
*@FileTitle : Available Off Hire Q'ty
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.19 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration.AvailableOffHireDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public class AvailableOffHireBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;

	private AvailableOffHireDBDAO dbDao = new AvailableOffHireDBDAO();

	private String jobType = null;

	private SearchParamVO searchParamVO;
	
    private AvailableOffHireContainerListVO availableOffHireContainerListVO;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		List list = null;

		try {
			if(getJobType().equals("AvailableOffHireContainerSummary")) {
				list = dbDao.searchAvailableOffHireContainerSummaryData(this.searchParamVO);
			} else if(getJobType().equals("AvailableOffHireContainerDetail")) {
				list = dbDao.searchAvailableOffHireContainerDetailData(this.searchParamVO);
			} else if(getJobType().equals("AvailableOffHireContainerConfirm")) {
				list = dbDao.searchAvailableOffHireContainerConfirmData(this.searchParamVO);
			} else if(getJobType().equals("SearchAvailableOffHireContainerListService")) {
				 if (this.availableOffHireContainerListVO.getRadTp().equals("A")){
				     list = dbDao.searchAvailableOffHireOriginContainerListData(this.availableOffHireContainerListVO);
				 }else {
					 list = dbDao.searchAvailableOffHireContainerListData(this.availableOffHireContainerListVO); 
				 }
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return list;
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
	 * @return the searchParamVO
	 */
	public SearchParamVO getSearchParamVO() {
		return searchParamVO;
	}

	/**
	 * @param searchParamVO the searchParamVO to set
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO) {
		this.searchParamVO = searchParamVO;
	}

	/**
	 * @return the availableOffHireContainerListVO
	 */ 
	
	public AvailableOffHireContainerListVO getAvailableOffHireContainerListVO() {
		return availableOffHireContainerListVO;
	}

	/**
	 * @param searchParamVO the availableOffHireContainerListVO to set
	 */
	public void setAvailableOffHireContainerListVO(
			AvailableOffHireContainerListVO availableOffHireContainerListVO) {
		this.availableOffHireContainerListVO = availableOffHireContainerListVO;
	}
	
	
}
