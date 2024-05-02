/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0221Event.java
*@FileTitle : Sold Creation File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.10.06 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0221HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0221Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0221Event(){}   

	/** Total Loss 조회 조건 및 단건 처리  */
	private SoldEQFileListGRPVO soldEQFileListGRPVO = null;

	public SoldEQFileListGRPVO getSoldEQFileListGRPVO() {
		return soldEQFileListGRPVO;
	}

	public void setSoldEQFileListGRPVO(SoldEQFileListGRPVO soldEQFileListGRPVO) {
		this.soldEQFileListGRPVO = soldEQFileListGRPVO;
	}
}