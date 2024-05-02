/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0560Event.java
 *@FileTitle : EsmBkg0560Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0560 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0560HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jae yoeb jeong
 * @see ESM_BKG_0560HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0560Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfPortRtListCondVO krWhfPortRtListCondVO = null;
	/** 조회결과 단건 */
	private KrWhfPortRtVO krWhfPortRtVO   = null;
	/** 조회결과 복수 */
	private List<KrWhfPortRtVO> krWhfPortRtVOs  = null;
	private KrWhfPortRtVO[]     krWhfPortRtVOs2 = null;

	public KrWhfPortRtListCondVO getKrWhfPortRtListCondVO() {
		return krWhfPortRtListCondVO;
	}

	public void setKrWhfPortRtListCondVO(KrWhfPortRtListCondVO krWhfPortRtListCondVO) {
		this.krWhfPortRtListCondVO = krWhfPortRtListCondVO;
	}

	public KrWhfPortRtVO getKrWhfPortRtVO() {
		return krWhfPortRtVO;
	}

	public void setKrWhfPortRtVO(KrWhfPortRtVO krWhfPortRtVO) {
		this.krWhfPortRtVO = krWhfPortRtVO;
	}

	public List<KrWhfPortRtVO> getKrWhfPortRtVOs() {
		return krWhfPortRtVOs;
	}

	public void setKrWhfPortRtVOs(List<KrWhfPortRtVO> krWhfPortRtVOs) {
		this.krWhfPortRtVOs = krWhfPortRtVOs;
	}

	public KrWhfPortRtVO[] getKrWhfPortRtVOs2() {
		KrWhfPortRtVO[] rtnVOs = null;
		if (this.krWhfPortRtVOs2 != null) {
			rtnVOs = Arrays.copyOf(krWhfPortRtVOs2, krWhfPortRtVOs2.length);
		}
		return rtnVOs;
	}

	public void setKrWhfPortRtVOs2(KrWhfPortRtVO[] krWhfPortRtVOs2) {
		if (krWhfPortRtVOs2 != null) {
			KrWhfPortRtVO[] tmpVOs = Arrays.copyOf(krWhfPortRtVOs2, krWhfPortRtVOs2.length);
			this.krWhfPortRtVOs2 = tmpVOs;
		}
	}

}