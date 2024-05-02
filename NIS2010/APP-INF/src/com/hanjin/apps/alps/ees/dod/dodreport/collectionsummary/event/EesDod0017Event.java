/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EesDod0017Event.java   
*@FileTitle : Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-20
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-20 Hong Seong Pil
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EesDod0017Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Hong Seong Pil
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EesDod0017Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private CollectionSummaryByCustomerDetailVO collectionSummaryByCustomerDetailVO = null;

	public CollectionSummaryByCustomerDetailVO getCollectionSummaryByCustomerDetailVO() {
		return collectionSummaryByCustomerDetailVO;
	}

	public void setCollectionSummaryByCustomerDetailVO(
			CollectionSummaryByCustomerDetailVO collectionSummaryByCustomerDetailVO) {
		this.collectionSummaryByCustomerDetailVO = collectionSummaryByCustomerDetailVO;
	}
}
