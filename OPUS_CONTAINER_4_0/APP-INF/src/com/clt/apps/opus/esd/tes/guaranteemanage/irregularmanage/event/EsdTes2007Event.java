/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes2007Event.java
*@FileTitle : Irregular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.29 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesIrrHdrVO;


/**
 * ESD_TES_2007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_2007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_2007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTes2007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesIrrHdrVO						tesIrrHdrVO				= null;
	private GuaranteeCommonVO			guaranteeCommonVO		= null;
	
	/** Table Value Object Multi Data 처리 */
	private TesIrrHdrVO[] 						tesIrrHdrVOs			= null;
	private GuaranteeCommonVO[]			guaranteeCommonVOs		= null;

	public EsdTes2007Event(){}

	public TesIrrHdrVO getTesIrrHdrVO() {
		return tesIrrHdrVO;
	}

	public void setTesIrrHdrVO(TesIrrHdrVO tesIrrHdrVO) {
		this.tesIrrHdrVO = tesIrrHdrVO;
	}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public TesIrrHdrVO[] getTesIrrHdrVOs() {
		TesIrrHdrVO[] rtnVOs = null;
		if (this.tesIrrHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesIrrHdrVOs, tesIrrHdrVOs.length);
		}
		return rtnVOs;
	}

	public void setTesIrrHdrVOs(TesIrrHdrVO[] tesIrrHdrVOs){
		if(tesIrrHdrVOs != null){
			TesIrrHdrVO[] tmpVOs = Arrays.copyOf(tesIrrHdrVOs, tesIrrHdrVOs.length);
			this.tesIrrHdrVOs = tmpVOs;
		}
	}

	public GuaranteeCommonVO[] getGuaranteeCommonVOs() {
		GuaranteeCommonVO[] rtnVOs = null;
		if (this.guaranteeCommonVOs != null) {
			rtnVOs = Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setGuaranteeCommonVOs(GuaranteeCommonVO[] guaranteeCommonVOs){
		if(guaranteeCommonVOs != null){
			GuaranteeCommonVO[] tmpVOs = Arrays.copyOf(guaranteeCommonVOs, guaranteeCommonVOs.length);
			this.guaranteeCommonVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}