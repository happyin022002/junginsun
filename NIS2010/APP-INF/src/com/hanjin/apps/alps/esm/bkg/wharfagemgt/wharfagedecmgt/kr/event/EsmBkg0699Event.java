/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0699Event.java
 *@FileTitle : EsmBkg0699Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCntrExpInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0699 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0699HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0699HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0699Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfExemptInfoCondVO krWhfExemptInfoCondVO   = null;
	
	/** 조회결과 단건 */
	private KrWhfBlExpInfoVO      krWhfBlExpInfoVO        = null;
	
	/** 조회결과 복수 */
	private List<KrWhfCntrExpInfoVO> krWhfVslInfoVOs    = null;
	
	/** 저장 단건 **/
	private BlKrWhfExptVO blKrWhfExptVO = null;
	
	/** 저장 복수 **/
	private BlKrWhfExptVO[] blKrWhfExptVOs = null;
	
	/** 저장 단건 **/
	private CntrKrWhfExptVO cntrKrWhfExptVO = null;
	
	/** 저장 복수 **/
	private CntrKrWhfExptVO[] cntrKrWhfExptVOs = null;

	public CntrKrWhfExptVO getCntrKrWhfExptVO() {
		return cntrKrWhfExptVO;
	}

	public void setCntrKrWhfExptVO(CntrKrWhfExptVO cntrKrWhfExptVO) {
		this.cntrKrWhfExptVO = cntrKrWhfExptVO;
	}

	public CntrKrWhfExptVO[] getCntrKrWhfExptVOs() {
		return cntrKrWhfExptVOs;
	}

	public void setCntrKrWhfExptVOs(CntrKrWhfExptVO[] cntrKrWhfExptVOs) {
		this.cntrKrWhfExptVOs = cntrKrWhfExptVOs;
	}

	public BlKrWhfExptVO[] getBlKrWhfExptVOs() {
		return blKrWhfExptVOs;
	}

	public void setBlKrWhfExptVOs(BlKrWhfExptVO[] blKrWhfExptVOs) {
		this.blKrWhfExptVOs = blKrWhfExptVOs;
	}

	public BlKrWhfExptVO getBlKrWhfExptVO() {
		return blKrWhfExptVO;
	}

	public void setBlKrWhfExptVO(BlKrWhfExptVO blKrWhfExptVO) {
		this.blKrWhfExptVO = blKrWhfExptVO;
	}

	public KrWhfExemptInfoCondVO getKrWhfExemptInfoCondVO() {
		return krWhfExemptInfoCondVO;
	}

	public void setKrWhfExemptInfoCondVO(KrWhfExemptInfoCondVO krWhfExemptInfoCondVO) {
		this.krWhfExemptInfoCondVO = krWhfExemptInfoCondVO;
	}

	public KrWhfBlExpInfoVO getKrWhfBlExpInfoVO() {
		return krWhfBlExpInfoVO;
	}

	public void setKrWhfBlExpInfoVO(KrWhfBlExpInfoVO krWhfBlExpInfoVO) {
		this.krWhfBlExpInfoVO = krWhfBlExpInfoVO;
	}

	public List<KrWhfCntrExpInfoVO> getKrWhfVslInfoVOs() {
		return krWhfVslInfoVOs;
	}

	public void setKrWhfVslInfoVOs(List<KrWhfCntrExpInfoVO> krWhfVslInfoVOs) {
		this.krWhfVslInfoVOs = krWhfVslInfoVOs;
	}
	
}