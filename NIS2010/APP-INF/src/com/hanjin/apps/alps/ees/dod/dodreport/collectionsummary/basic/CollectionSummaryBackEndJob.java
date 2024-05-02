/*========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryBackEndJob.java
*@FileTitle : CollectionSummaryBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : HongSeongPil
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration.CollectionSummaryDBDAO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author HongSeongPil
 * @see EventResponse 참조
 * @since J2EE 1.6 
 */
public class CollectionSummaryBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = 1L;

	private CollectionSummaryDBDAO dbDao = new CollectionSummaryDBDAO();
	
	private String jobType = null;
	
	private CollectionSummaryByCustomerDetailVO collectionSummaryByCustomerDetailVO;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public Object doStart() throws Exception {
		List list = null;
		try {
			if(getJobType().equals("DOD_COLLECTION_SUMMARY_DETAIL_LIST")){
				list = dbDao.searchCollectionSummaryDetailByCustomer(collectionSummaryByCustomerDetailVO);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return list;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public CollectionSummaryByCustomerDetailVO getCollectionSummaryByCustomerDetailVO() {
		return collectionSummaryByCustomerDetailVO;
	}

	public void setCollectionSummaryByCustomerDetailVO(
			CollectionSummaryByCustomerDetailVO collectionVO) {
		this.collectionSummaryByCustomerDetailVO = collectionVO;
	}
	
	
}
