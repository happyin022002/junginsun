/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EssMnr0137Event.java
*@FileTitle : M&R Other Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.09.02 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrReeferSparePartCodeVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtINVO;
import com.clt.framework.support.layer.event.EventSupport;
   

/**
 * ESS_MNR_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see EES_MNR_0137HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0137Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MnrReeferSparePartCodeVO[] mnrReeferSparePartCodeVOs = null;

	public EesMnr0137Event(){}
	
	public RFSparePartCodeMgtINVO getRFSparePartCodeMgtINVO() {
		return rfSparePartCodeMgtINVO;
	}
	public void setRFSparePartCodeMgtINVO(RFSparePartCodeMgtINVO rfSparePartCodeMgtINVO) {
		this.rfSparePartCodeMgtINVO = rfSparePartCodeMgtINVO;
	}

	public MnrReeferSparePartCodeVO[] getMnrReeferSparePartCodeVOs() {
		MnrReeferSparePartCodeVO[] rtnVOs = null;
		if (this.mnrReeferSparePartCodeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mnrReeferSparePartCodeVOs, mnrReeferSparePartCodeVOs.length);
		}
		return rtnVOs;
	}
	public void setMnrReeferSparePartCodeVOs(MnrReeferSparePartCodeVO[] mnrReeferSparePartCodeVOs){
		if(mnrReeferSparePartCodeVOs != null){
			MnrReeferSparePartCodeVO[] tmpVOs = java.util.Arrays.copyOf(mnrReeferSparePartCodeVOs, mnrReeferSparePartCodeVOs.length);
			this.mnrReeferSparePartCodeVOs = tmpVOs;
		}
	}
	
}