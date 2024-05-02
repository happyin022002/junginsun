/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2004Event.java
*@FileTitle : Ref.No. Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TES_2004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2004HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes2004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private GuaranteeCommonVO		guaranteeCommonVO	= null;
	
	/** Table Value Object Multi Data 처리 */
	private GuaranteeCommonVO[]		guaranteeCommonVOs	= null;
	
	public EsdTes2004Event(){}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		GuaranteeCommonVO[] tempVOs = null;
		if (this.guaranteeCommonVOs != null) {
			tempVOs = Arrays.copyOf(this.guaranteeCommonVOs, this.guaranteeCommonVOs.length);
		}
		return tempVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs) {
		if (guaranteeCommonVOs != null) {
			GuaranteeCommonVO[] tempVo = Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
			this.guaranteeCommonVOs = tempVo;
		}		
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}