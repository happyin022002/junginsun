/*========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DodCollectionAuditBackEndJob.java
*@FileTitle : DodCollectionAuditBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 박정민
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.basic;

import java.util.List;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration.CollectionAuditDBDAO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class DodCollectionAuditBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -1075526635098614393L;

	private CollectionAuditDBDAO dbDao = new CollectionAuditDBDAO();

	private String jobType = null;

	private CollectionAuditINVO collectionAuditINVO;
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
			if(getJobType().equals("DOD_COLLECTION_AUDIT_LIST")){
				list = dbDao.searchCollectionAuditList(collectionAuditINVO);
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
	 * GETTER CollectionAuditINVO
	 * @return
	 */
	public CollectionAuditINVO getCollectionAuditINVO() {
		return collectionAuditINVO;
	}

	
	/**
	 * SETTER CollectionAuditINVO
	 * @param collectionAuditINVO
	 */
	public void setCollectionAuditINVO(CollectionAuditINVO collectionAuditINVO) {
		this.collectionAuditINVO = collectionAuditINVO;
	}
	
}
