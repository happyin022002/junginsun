/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0416Event.java
 *@FileTitle : EsmBkg0416Event
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
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0416 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0416HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0416HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0416Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfBerthCdCondVO whfBerthCdCondVO   = null;
	/** 조회결과 단건 */
	private KrWhfBerthCdVO krWhfBerthCdVO   = null;
	/** 조회결과 복수 */
	private List<KrWhfBerthCdVO> krWhfBerthCdVOs  = null;
	private KrWhfBerthCdVO[]     krWhfBerthCdVOs2 = null;
	
	
	public KrWhfBerthCdVO[] getKrWhfBerthCdVOs2() {
		return krWhfBerthCdVOs2;
	}
	public void setKrWhfBerthCdVOs2(KrWhfBerthCdVO[] krWhfBerthCdVOs2) {
		this.krWhfBerthCdVOs2 = krWhfBerthCdVOs2;
	}
	public KrWhfBerthCdCondVO getWhfBerthCdCondVO() {
		return whfBerthCdCondVO;
	}
	public void setWhfBerthCdCondVO(KrWhfBerthCdCondVO whfBerthCdCondVO) {
		this.whfBerthCdCondVO = whfBerthCdCondVO;
	}
	public KrWhfBerthCdVO getKrWhfBerthCdVO() {
		return krWhfBerthCdVO;
	}
	public void setKrWhfBerthCdVO(KrWhfBerthCdVO krWhfBerthCdVO) {
		this.krWhfBerthCdVO = krWhfBerthCdVO;
	}
	public List<KrWhfBerthCdVO> getKrWhfBerthCdVOs() {
		return krWhfBerthCdVOs;
	}
	public void setKrWhfBerthCdVOs(List<KrWhfBerthCdVO> krWhfBerthCdVOs) {
		this.krWhfBerthCdVOs = krWhfBerthCdVOs;
	}
	
}