/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0548Event.java
 *@FileTitle : EsmBkg0548Event
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0548 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0548HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0548HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0548Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfVslInfoCondVO krWhfVslInfoCondVO    = null;
	/** 조회결과 단건 */
	private KrWhfVslInfoVO krWhfVslInfoVO   = null;
	/** 조회결과 복수 */
	private List<KrWhfVslInfoVO> krWhfVslInfoVOs  = null;
	private KrWhfVslInfoVO[]     krWhfVslInfoVOs2 = null;
	
	private KrWhfBerthCdCondVO whfBerthCdCondVO   = null;
	
	public KrWhfBerthCdCondVO getWhfBerthCdCondVO() {
		return whfBerthCdCondVO;
	}
	public void setWhfBerthCdCondVO(KrWhfBerthCdCondVO whfBerthCdCondVO) {
		this.whfBerthCdCondVO = whfBerthCdCondVO;
	}
	public KrWhfVslInfoCondVO getKrWhfVslInfoCondVO() {
		return krWhfVslInfoCondVO;
	}
	public void setKrWhfVslInfoCondVO(KrWhfVslInfoCondVO krWhfVslInfoCondVO) {
		this.krWhfVslInfoCondVO = krWhfVslInfoCondVO;
	}
	public KrWhfVslInfoVO getKrWhfVslInfoVO() {
		return krWhfVslInfoVO;
	}
	public void setKrWhfVslInfoVO(KrWhfVslInfoVO krWhfVslInfoVO) {
		this.krWhfVslInfoVO = krWhfVslInfoVO;
	}
	public List<KrWhfVslInfoVO> getKrWhfVslInfoVOs() {
		return krWhfVslInfoVOs;
	}
	public void setKrWhfVslInfoVOs(List<KrWhfVslInfoVO> krWhfVslInfoVOs) {
		this.krWhfVslInfoVOs = krWhfVslInfoVOs;
	}
	public KrWhfVslInfoVO[] getKrWhfVslInfoVOs2() {
		return krWhfVslInfoVOs2;
	}
	public void setKrWhfVslInfoVOs2(KrWhfVslInfoVO[] krWhfVslInfoVOs2) {
		this.krWhfVslInfoVOs2 = krWhfVslInfoVOs2;
	}
	
}