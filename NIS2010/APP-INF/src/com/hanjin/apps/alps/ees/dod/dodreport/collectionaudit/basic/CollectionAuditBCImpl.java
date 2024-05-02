/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CollectionAuditBCImple.java
*@FileTitle : Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.basic;

import java.sql.SQLException;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration.CollectionAuditDBDAO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * DropOffInquiryBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class CollectionAuditBCImpl extends BasicCommandSupport implements CollectionAuditBC {
	
	// Database Access Object
	private transient CollectionAuditDBDAO dbDao = null;
	
	/**
	 * DropOffInquiryBCImpl 객체 생성<br>
	 * DropOffInquiryDBDAO 생성한다.<br>
	 */
	public CollectionAuditBCImpl() {
		dbDao = new CollectionAuditDBDAO();
	}

	/**
	 * DOD Collection Audit List
	 * 
	 * @category EES_DOD_0008
	 * @param collectionAuditINVO CollectionAuditINVO
	 * @param account SignOnUserAccount 
	 * @return String
	 * @throws EventException
	 */
	public String searchCollectionAuditList(CollectionAuditINVO collectionAuditINVO, SignOnUserAccount account) throws EventException {
		try {
			
			DodCollectionAuditBackEndJob backEndJob = new DodCollectionAuditBackEndJob();
			backEndJob.setJobType("DOD_COLLECTION_AUDIT_LIST");
			backEndJob.setCollectionAuditINVO(collectionAuditINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "DOD_COLLECTION_AUDIT_LIST");
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

/*
		try {
			List<CollectionAuditListVO> list = dbDao.searchCollectionAuditList(collectionAuditINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
*/
	}

	
	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;
		
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch(BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch(SQLException e) {
			throw new EventException(e.getMessage());
		} catch(InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e) {
			throw new EventException(e.getMessage());
		}
	}
}
