/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6001Event.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;


/**
 * EES_DMT_6001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CollectionReportParmVO collectionReportParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CollectionReportParmVO[] collectionReportParmVOs = null;

	public EesDmt6001Event(){}
	
	public void setCollectionReportParmVO(CollectionReportParmVO collectionReportParmVO){
		this. collectionReportParmVO = collectionReportParmVO;
	}

	public void setCollectionReportParmVOS(CollectionReportParmVO[] collectionReportParmVOs){
		this. collectionReportParmVOs = collectionReportParmVOs;
	}

	public CollectionReportParmVO getCollectionReportParmVO(){
		return collectionReportParmVO;
	}

	public CollectionReportParmVO[] getCollectionReportParmVOS(){
		return collectionReportParmVOs;
	}

}