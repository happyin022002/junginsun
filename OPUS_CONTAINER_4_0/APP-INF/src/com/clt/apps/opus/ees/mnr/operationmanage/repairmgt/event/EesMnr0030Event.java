/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0030Event.java
*@FileTitle : W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.08.03 김완규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0030HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0030Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0030Event(){}   

	/** Estimate 조회 조건 및 단건 처리  */
	private ESTWOMainGRPVO eSTWOMainGRPVO = null;

	public ESTWOMainGRPVO getESTWOMainGRPVO() {
		return eSTWOMainGRPVO;
	}

	public void setESTWOMainGRPVO(ESTWOMainGRPVO mainGRPVO) {
		eSTWOMainGRPVO = mainGRPVO;
	}

}