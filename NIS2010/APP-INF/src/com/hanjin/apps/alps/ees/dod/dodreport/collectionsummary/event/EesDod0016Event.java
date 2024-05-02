/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDod0016Event.java
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EesDod0016Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Hong Seong Pil
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EesDod0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CollectionSummaryByCustomerVO collectionSummaryByCustomerVO = null;

	public CollectionSummaryByCustomerVO getCollectionSummaryByCustomerVO() {
		return collectionSummaryByCustomerVO;
	}

	public void setCollectionSummaryByCustomerVO(
			CollectionSummaryByCustomerVO collectionSummaryByCustomerVO) {
		this.collectionSummaryByCustomerVO = collectionSummaryByCustomerVO;
	}
}
