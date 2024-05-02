/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CpsGem0036Event.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;



/**
 * CPS_GEM_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_GEM_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see CPS_GEM_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsGem0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private SerachConsultaionVO serachConsultaionVO = null;
	
	private SerachConsultaionVO[] serachConsultaionVOs = null;
	
	private GemSubsCsulHdrVO gemSubsCsulHdrVO = null;
	
	private GemSubsCsulHdrVO[] gemSubsCsulHdrVOs = null;

	
	public CpsGem0036Event(){}
	
	
	
	
	public void setSerachConsultaionVOs(SerachConsultaionVO[] serachConsultaionVOs) {
		if (serachConsultaionVOs != null) {
			SerachConsultaionVO[] tmpVOs = Arrays.copyOf(serachConsultaionVOs, serachConsultaionVOs .length);
			this. serachConsultaionVOs = tmpVOs;
		}
	}

	public SerachConsultaionVO[] getSerachConsultaionVOs(){
		SerachConsultaionVO[] tmpVOs = null;
		if (this. serachConsultaionVOs != null) {
			tmpVOs = Arrays.copyOf(serachConsultaionVOs, serachConsultaionVOs .length);
		}
		return tmpVOs;
	}
	
	
	public SerachConsultaionVO getSerachConsultaionVO() {
		return serachConsultaionVO;
	}

	public void setSerachConsultaionVO(SerachConsultaionVO serachConsultaionVO) {
		this.serachConsultaionVO = serachConsultaionVO;
	}

	public GemSubsCsulHdrVO getGemSubsCsulHdrVO() {
		return gemSubsCsulHdrVO;
	}

	public void setGemSubsCsulHdrVO(GemSubsCsulHdrVO gemSubsCsulHdrVO) {
		this.gemSubsCsulHdrVO = gemSubsCsulHdrVO;
	}
	
	public GemSubsCsulHdrVO[] getGemSubsCsulHdrVOs() {
		GemSubsCsulHdrVO[] tmpVOs = null;
		if (this. gemSubsCsulHdrVOs != null) {
			tmpVOs = Arrays.copyOf(gemSubsCsulHdrVOs, gemSubsCsulHdrVOs .length);
		}
		return tmpVOs;
	}

	public void setGemSubsCsulHdrVOs(GemSubsCsulHdrVO[] gemSubsCsulHdrVOs) {
		if (gemSubsCsulHdrVOs != null) {
			GemSubsCsulHdrVO[] tmpVOs = Arrays.copyOf(gemSubsCsulHdrVOs, gemSubsCsulHdrVOs .length);
			this. gemSubsCsulHdrVOs = tmpVOs;
		}
	}
}