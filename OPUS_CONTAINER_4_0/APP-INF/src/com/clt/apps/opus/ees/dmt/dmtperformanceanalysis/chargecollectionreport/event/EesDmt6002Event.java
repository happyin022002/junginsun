/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6002Event.java
*@FileTitle : Current Collection Status by Office – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.22 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_6002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CollectionReportParmVO collectionReportParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CollectionReportParmVO[] collectionReportParmVOs = null;

	public EesDmt6002Event(){}
	
	public void setCollectionReportParmVO(CollectionReportParmVO collectionReportParmVO){
		this. collectionReportParmVO = collectionReportParmVO;
	}

	public void setCollectionReportParmVOS(CollectionReportParmVO[] collectionReportParmVOs){
		if (collectionReportParmVOs != null) {
			CollectionReportParmVO[] tmpVOs = new CollectionReportParmVO[collectionReportParmVOs.length];
			System.arraycopy(collectionReportParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.collectionReportParmVOs = tmpVOs;
		}
	}

	public CollectionReportParmVO getCollectionReportParmVO(){
		return collectionReportParmVO;
	}

	public CollectionReportParmVO[] getCollectionReportParmVOS(){
		CollectionReportParmVO[] tmpVOs = null;
		if (this.collectionReportParmVOs != null) {
			tmpVOs = new CollectionReportParmVO[collectionReportParmVOs.length];
			System.arraycopy(collectionReportParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}