/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0555Event.java
 *@FileTitle : EsmBkg0555Event
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgWhfCfmVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0555 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0555HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0555HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0555Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfChgListCondVO krWhfChgListCondVO = null;
	/** 조회결과 단건 */
	private KrWhfChgVO krWhfChgVO   = null;
	/** 조회결과 복수 */
	private List<KrWhfChgVO> krWhfChgVOs  = null;
	private KrWhfChgVO[]     krWhfChgVOs2 = null;
	
	private KrBkgWhfCfmVO krBkgWhfCfmVO = null;
	private VvdPortEtdEtaVO vvdPortEtdEtaVO = null;
	public KrWhfChgListCondVO getKrWhfChgListCondVO() {
		return krWhfChgListCondVO;
	}
	public void setKrWhfChgListCondVO(KrWhfChgListCondVO krWhfChgListCondVO) {
		this.krWhfChgListCondVO = krWhfChgListCondVO;
	}
	public KrWhfChgVO getKrWhfChgVO() {
		return krWhfChgVO;
	}
	public void setKrWhfChgVO(KrWhfChgVO krWhfChgVO) {
		this.krWhfChgVO = krWhfChgVO;
	}
	public List<KrWhfChgVO> getKrWhfChgVOs() {
		return krWhfChgVOs;
	}
	public void setKrWhfChgVOs(List<KrWhfChgVO> krWhfChgVOs) {
		this.krWhfChgVOs = krWhfChgVOs;
	}
	public KrWhfChgVO[] getKrWhfChgVOs2() {
		return krWhfChgVOs2;
	}
	public void setKrWhfChgVOs2(KrWhfChgVO[] krWhfChgVOs2) {
		this.krWhfChgVOs2 = krWhfChgVOs2;
	}
	public KrBkgWhfCfmVO getKrBkgWhfCfmVO() {
		return krBkgWhfCfmVO;
	}
	public void setKrBkgWhfCfmVO(KrBkgWhfCfmVO krBkgWhfCfmVO) {
		this.krBkgWhfCfmVO = krBkgWhfCfmVO;
	}
	public VvdPortEtdEtaVO getVvdPortEtdEtaVO() {
		return vvdPortEtdEtaVO;
	}
	public void setVvdPortEtdEtaVO(VvdPortEtdEtaVO vvdPortEtdEtaVO) {
		this.vvdPortEtdEtaVO = vvdPortEtdEtaVO;
	}
	
}