/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0411Event.java
*@FileTitle : Detail Form
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.17 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0411 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0411HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0411HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0411Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmVvdHistoryVO conINTCommonVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CtmVvdHistoryVO[] conINTCommonVOs = null;

	public EesCtm0411Event(){}
	
	public void setConINTCommonVO(CtmVvdHistoryVO conINTCommonVO){
		this. conINTCommonVO = conINTCommonVO;
	}

	public void setConINTCommonVOS(CtmVvdHistoryVO[] conINTCommonVOs){
		if (conINTCommonVOs != null) {
			CtmVvdHistoryVO[] tmpVOs = new CtmVvdHistoryVO[conINTCommonVOs.length];
			System.arraycopy(conINTCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.conINTCommonVOs = tmpVOs;
		}
	}

	public CtmVvdHistoryVO getConINTCommonVO(){
		return conINTCommonVO;
	}

	public CtmVvdHistoryVO[] getConINTCommonVOS(){
		CtmVvdHistoryVO[] tmpVOs = null;
		if (this.conINTCommonVOs != null) {
			tmpVOs = new CtmVvdHistoryVO[conINTCommonVOs.length];
			System.arraycopy(conINTCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}