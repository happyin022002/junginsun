/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CollectionAuditBC.java   
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

import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * DropOffInquiryBC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface CollectionAuditBC {
	
	/**
	 * DOD Collection Audit List
	 * 
	 * @category EES_DOD_0008
	 * @param collectionAuditINVO CollectionAuditINVO
	 * @param account SignOnUserAccount 
	 * @return String
	 * @throws EventException
	 */
	public String searchCollectionAuditList(CollectionAuditINVO collectionAuditINVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
}
