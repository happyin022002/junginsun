/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CpsGem0033Event.java
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

import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsrHisVO;


/**
 * CPS_GEM_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_GEM_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see CPS_GEM_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsGem0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private GemCsrInfoVO gemCsrInfoVO = null;	//EAI 송수신용
	
	private SerachConsultaionVO serachConsultaionVO = null;
	
	private SerachConsultaionVO[] serachConsultaionVOs = null;
	
	private GemSubsCsulHdrVO gemSubsCsulHdrVO = null;
	
	private GemSubsCsulHdrVO[] gemSubsCsulHdrVOs = null;
	
	private GemSubsCsulDtlVO gemSubsCsulDtlVO = null;
	
	private GemSubsCsulDtlVO[] gemSubsCsulDtlVOs =null;
	
	private GemSubsCsrHisVO gemSubsCsrHisVO = null;
	
	private GemSubsCsrHisVO[] gemSubsCsrHisVOs = null;
	
	
	public CpsGem0033Event(){}
	
	public void setSerachConsultaionVO(SerachConsultaionVO[] serachConsultaionVOs){
		if (serachConsultaionVOs != null) {
			SerachConsultaionVO[] tmpVOs = Arrays.copyOf(serachConsultaionVOs, serachConsultaionVOs .length);
			this. serachConsultaionVOs = tmpVOs;
		}
	}

	public SerachConsultaionVO[] getSerachConsultaionVOS(){
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

	public void setGemCsrInfoVO(GemCsrInfoVO gemCsrInfoVO){
		this.gemCsrInfoVO = gemCsrInfoVO;
	}
	
	public GemCsrInfoVO getGemsrInfoVO() {
		return gemCsrInfoVO;
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

	public GemSubsCsulDtlVO getGemSubsCsulDtlVO() {
		return gemSubsCsulDtlVO;
	}

	public void setGemSubsCsulDtlVO(GemSubsCsulDtlVO gemSubsCsulDtlVO) {
		this.gemSubsCsulDtlVO = gemSubsCsulDtlVO;
	}

	public GemSubsCsulDtlVO[] getGemSubsCsulDtlVOs() {
		GemSubsCsulDtlVO[] tmpVOs = null;
		if (this. gemSubsCsulDtlVOs != null) {
			tmpVOs = Arrays.copyOf(gemSubsCsulDtlVOs, gemSubsCsulDtlVOs .length);
		}
		return tmpVOs;
	}

	public void setGemSubsCsulDtlVOs(GemSubsCsulDtlVO[] gemSubsCsulDtlVOs) {
		if (gemSubsCsulDtlVOs != null) {
			GemSubsCsulDtlVO[] tmpVOs = Arrays.copyOf(gemSubsCsulDtlVOs, gemSubsCsulDtlVOs .length);
			this. gemSubsCsulDtlVOs = tmpVOs;
		}
	}

	public GemSubsCsrHisVO getGemSubsCsrHisVO() {
		return gemSubsCsrHisVO;
	}

	public void setGemSubsCsrHisVO(GemSubsCsrHisVO gemSubsCsrHisVO) {
		this.gemSubsCsrHisVO = gemSubsCsrHisVO;
	}

	public GemSubsCsrHisVO[] getGemSubsCsrHisVOs() {
		GemSubsCsrHisVO[] tmpVOs = null;
		if (this. gemSubsCsrHisVOs != null) {
			tmpVOs = Arrays.copyOf(gemSubsCsrHisVOs, gemSubsCsrHisVOs .length);
		}
		return tmpVOs;
	}

	public void setGemSubsCsrHisVOs(GemSubsCsrHisVO[] gemSubsCsrHisVOs) {
		if (gemSubsCsrHisVOs != null) {
			GemSubsCsrHisVO[] tmpVOs = Arrays.copyOf(gemSubsCsrHisVOs, gemSubsCsrHisVOs .length);
			this. gemSubsCsrHisVOs = tmpVOs;
		}
	}

	
	
}