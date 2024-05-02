/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteecommonEvent.java
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesIrrHdrVO;


/**
 * GuaranteeCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  GuaranteeCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see GuaranteeCommonHTMLAction 참조
 * @since J2EE 1.6
 */
public class GuaranteeCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TesIrrHdrVO 					tesIrrHdrVO			= null;
	private TesGnteHdrVO 					tesGnteHdrVO		= null;
	private TesGnteCntrListVO				tesGnteCntrListVO	= null;
	private GuaranteeCommonVO				guaranteeCommonVO	= null;

	
	/** Table Value Object Multi Data 처리 */
	private TesIrrHdrVO[] 					tesIrrHdrVOs		= null;
	private TesGnteHdrVO[] 					tesGnteHdrVOs		= null;
	private TesGnteCntrListVO[]				tesGnteCntrListVOs	= null;
	private GuaranteeCommonVO[]				guaranteeCommonVOs	= null;

	public GuaranteeCommonEvent(){}

	public TesIrrHdrVO getTesIrrHdrVO() {
		return tesIrrHdrVO;
	}

	public void setTesIrrHdrVO(TesIrrHdrVO tesIrrHdrVO) {
		this.tesIrrHdrVO = tesIrrHdrVO;
	}

	public TesGnteHdrVO getTesGnteHdrVO() {
		return tesGnteHdrVO;
	}

	public void setTesGnteHdrVO(TesGnteHdrVO tesGnteHdrVO) {
		this.tesGnteHdrVO = tesGnteHdrVO;
	}

	public TesGnteCntrListVO getTesGnteCntrListVO() {
		return tesGnteCntrListVO;
	}

	public void setTesGnteCntrListVO(TesGnteCntrListVO tesGnteCntrListVO) {
		this.tesGnteCntrListVO = tesGnteCntrListVO;
	}

	public GuaranteeCommonVO getGuaranteeCommonVO() {
		return guaranteeCommonVO;
	}

	public void setGuaranteeCommonVO(GuaranteeCommonVO guaranteeCommonVO) {
		this.guaranteeCommonVO = guaranteeCommonVO;
	}

	public TesIrrHdrVO[] getTesIrrHdrVOs() {
		TesIrrHdrVO[] tempVOs = null;
		
		if (this.tesIrrHdrVOs != null) {
			tempVOs = Arrays.copyOf(this.tesIrrHdrVOs, this.tesIrrHdrVOs.length);
		}
		return tempVOs;		
	}

	public void setTesIrrHdrVOs(TesIrrHdrVO[] tesIrrHdrVOs) {
		if (tesIrrHdrVOs != null) {
			TesIrrHdrVO[] tempVo = Arrays.copyOf(tesIrrHdrVOs, tesIrrHdrVOs.length);
			this.tesIrrHdrVOs = tempVo;
		}		
	}

	public TesGnteHdrVO[] getTesGnteHdrVOs() {
		TesGnteHdrVO[] tempVOs = null;
		
		if (this.tesGnteHdrVOs != null) {
			tempVOs = Arrays.copyOf(this.tesGnteHdrVOs, this.tesGnteHdrVOs.length);
		}
		return tempVOs;	
		
	}

	public void setTesGnteHdrVOs(TesGnteHdrVO[] tesGnteHdrVOs) {
		if (tesGnteHdrVOs != null) {
			TesGnteHdrVO[] tempVo = Arrays.copyOf(tesGnteHdrVOs, tesGnteHdrVOs.length);
			this.tesGnteHdrVOs = tempVo;
		}			
	}

	public TesGnteCntrListVO[] getTesGnteCntrListVOs() {
		TesGnteCntrListVO[] tempVOs = null;
		
		if (this.tesGnteCntrListVOs != null) {
			tempVOs = Arrays.copyOf(this.tesGnteCntrListVOs, this.tesGnteCntrListVOs.length);
		}
		return tempVOs;	
	}

	public void setTesGnteCntrListVOs(TesGnteCntrListVO[] tesGnteCntrListVOs) {
		if (tesGnteCntrListVOs != null) {
			TesGnteCntrListVO[] tempVo = Arrays.copyOf(tesGnteCntrListVOs, tesGnteCntrListVOs.length);
			this.tesGnteCntrListVOs = tempVo;
		}			
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