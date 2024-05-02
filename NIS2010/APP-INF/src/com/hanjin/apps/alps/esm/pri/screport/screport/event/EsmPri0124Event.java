/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri0124Event.java
*@FileTitle : Timely Rate Creation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.03.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTimelyRateListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_PRI_0124HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCTimelyRateListVO[] rsltSearchSCTimelyRateListVOs = null;
	

	public EsmPri0124Event(){}
	
	public void setRsltSearchSCTimelyRateListVO(RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO){
		this.rsltSearchSCTimelyRateListVO = rsltSearchSCTimelyRateListVO;
	}

	public void setRsltSearchSCTimelyRateListVOS(RsltSearchSCTimelyRateListVO[] rsltSearchSCTimelyRateListVOs){
		this. rsltSearchSCTimelyRateListVOs = rsltSearchSCTimelyRateListVOs;
	}

	public RsltSearchSCTimelyRateListVO getRsltSearchSCTimelyRateListVO(){
		return rsltSearchSCTimelyRateListVO;
	}

	public RsltSearchSCTimelyRateListVO[] getRsltSearchSCTimelyRateListVOS(){
		return rsltSearchSCTimelyRateListVOs;
	}


}