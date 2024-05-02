/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EesDod0008Event.java
*@FileTitle : DOD Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.event;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EesDod0008Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EesDod0008Event extends EventSupport {

	private static final long serialVersionUID = -1909705464706058031L;
	
	private CollectionAuditINVO collectionAuditINVO = null;

	
	public CollectionAuditINVO getCollectionAuditINVO() {
		return collectionAuditINVO;
	}

	
	public void setCollectionAuditINVO(CollectionAuditINVO collectionAuditINVO) {
		this.collectionAuditINVO = collectionAuditINVO;
	}
}
