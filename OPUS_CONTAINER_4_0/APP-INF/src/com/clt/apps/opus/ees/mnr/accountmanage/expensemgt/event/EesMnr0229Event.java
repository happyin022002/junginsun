/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0229Event.java
*@FileTitle : M&R Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.16 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0229 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0229HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0229HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0229Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GLEstimateINVO gLEstimateINVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	private MnrAgmtRtVO[] mnrAgmtRtVOs = null;

	public EesMnr0229Event(){}
	
	public void setGLEstimateINVO(GLEstimateINVO gLEstimateINVO){
		this. gLEstimateINVO = gLEstimateINVO;
	}

//	public void setMnrAgmtRtVOS(MnrAgmtRtVO[] mnrAgmtRtVOs){
//		this. mnrAgmtRtVOs = mnrAgmtRtVOs;
//	}

	public GLEstimateINVO getGLEstimateINVO(){
		return gLEstimateINVO;
	}

//	public MnrAgmtRtVO[] getMnrAgmtRtVOS(){
//		return mnrAgmtRtVOs;
//	}

}