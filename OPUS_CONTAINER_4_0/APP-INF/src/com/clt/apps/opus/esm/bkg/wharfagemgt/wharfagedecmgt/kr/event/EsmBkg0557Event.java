/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0557Event.java
 *@FileTitle : EsmBkg0557Event
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

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgKrWhfVolVO;


/**
 * ESM_BKG_0557 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0557HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jae yoeb jeong
 * @see ESM_BKG_0557HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0557Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfDecCondVO krWhfDecCondVO = null;

	/** 조회결과 단건 */
	private KrWhfVslInfoVO     krWhfVslInfoVO       = null;
	private KrWhfBlInfoVO      krWhfBlInfoVO        = null;

	/** 조회결과 복수 */
	private List<KrWhfVslInfoVO> krWhfVslInfoVOs    = null;
	private KrWhfVslInfoVO[]     krWhfVslInfoVOs2   = null;

	private List<KrWhfBlInfoVO>  krWhfBlInfoVOs    = null;
	private KrWhfBlInfoVO[]      krWhfBlInfoVOss   = null;

	private List<BkgKrWhfVolVO> bkgKrWhfVolVos = null;
	private BkgKrWhfVolVO[]     bkgKrWhfVolVos2 = null;

	private BkgKrWhfVolVO bkgKrWhfVolVO  = null;
	private KrWhfDecVO    krWhfDecVO     = null;
	private KrWhfVvdDtlVO krWhfVvdDtlVO  = null;
	private KrWhfPortRtVO krWhfPortRtVO  = null;
	private KrWhfVvdDtlVO[]     krWhfVvdDtlVOs      = null;
	private KrWhfDecExptVolVO[] krWhfDecExptVolVOs  = null;

	public KrWhfPortRtVO getKrWhfPortRtVO() {
		return krWhfPortRtVO;
	}

	public void setKrWhfPortRtVO(KrWhfPortRtVO krWhfPortRtVO) {
		this.krWhfPortRtVO = krWhfPortRtVO;
	}

	public KrWhfDecExptVolVO[] getKrWhfDecExptVolVOs() {
		KrWhfDecExptVolVO[] rtnVOs = null;
		if (this.krWhfDecExptVolVOs != null) {
			rtnVOs = Arrays.copyOf(krWhfDecExptVolVOs, krWhfDecExptVolVOs.length);
		}
		return rtnVOs;
	}

	public void setKrWhfDecExptVolVOs(KrWhfDecExptVolVO[] krWhfDecExptVolVOs) {
		if (krWhfDecExptVolVOs != null) {
			KrWhfDecExptVolVO[] tmpVOs = Arrays.copyOf(krWhfDecExptVolVOs, krWhfDecExptVolVOs.length);
			this.krWhfDecExptVolVOs = tmpVOs;
		}
	}

	public KrWhfDecVO getKrWhfDecVO() {
		return krWhfDecVO;
	}

	public KrWhfVvdDtlVO[] getKrWhfVvdDtlVOs() {
		KrWhfVvdDtlVO[] rtnVOs = null;
		if (this.krWhfVvdDtlVOs != null) {
			rtnVOs = Arrays.copyOf(krWhfVvdDtlVOs, krWhfVvdDtlVOs.length);
		}
		return rtnVOs;
	}

	public void setKrWhfVvdDtlVOs(KrWhfVvdDtlVO[] krWhfVvdDtlVOs) {
		if (krWhfVvdDtlVOs != null) {
			KrWhfVvdDtlVO[] tmpVOs = Arrays.copyOf(krWhfVvdDtlVOs, krWhfVvdDtlVOs.length);
			this.krWhfVvdDtlVOs = tmpVOs;
		}
	}

	public KrWhfVvdDtlVO getKrWhfVvdDtlVO() {
		return krWhfVvdDtlVO;
	}

	public void setKrWhfVvdDtlVO(KrWhfVvdDtlVO krWhfVvdDtlVO) {
		this.krWhfVvdDtlVO = krWhfVvdDtlVO;
	}

	public KrWhfDecVO getWhfDecVO() {
		return krWhfDecVO;
	}

	public void setKrWhfDecVO(KrWhfDecVO krWhfDecVO) {
		this.krWhfDecVO = krWhfDecVO;
	}

	public KrWhfDecCondVO getKrWhfDecCondVO() {
		return krWhfDecCondVO;
	}

	public void setKrWhfDecCondVO(KrWhfDecCondVO krWhfDecCondVO) {
		this.krWhfDecCondVO = krWhfDecCondVO;
	}

	public BkgKrWhfVolVO getBkgKrWhfVolVO() {
		return bkgKrWhfVolVO;
	}

	public void setBkgKrWhfVolVO(BkgKrWhfVolVO bkgKrWhfVolVO) {
		this.bkgKrWhfVolVO = bkgKrWhfVolVO;
	}

	public List<BkgKrWhfVolVO> getBkgKrWhfVolVos() {
		return bkgKrWhfVolVos;
	}

	public void setBkgKrWhfVolVos(List<BkgKrWhfVolVO> bkgKrWhfVolVos) {
		this.bkgKrWhfVolVos = bkgKrWhfVolVos;
	}

	public BkgKrWhfVolVO[] getBkgKrWhfVolVos2() {
		BkgKrWhfVolVO[] rtnVOs = null;
		if (this.bkgKrWhfVolVos2 != null) {
			rtnVOs = Arrays.copyOf(bkgKrWhfVolVos2, bkgKrWhfVolVos2.length);
		}
		return rtnVOs;
	}

	public void setBkgKrWhfVolVos2(BkgKrWhfVolVO[] bkgKrWhfVolVos2) {
		if (bkgKrWhfVolVos2 != null) {
			BkgKrWhfVolVO[] tmpVOs = Arrays.copyOf(bkgKrWhfVolVos2, bkgKrWhfVolVos2.length);
			this.bkgKrWhfVolVos2 = tmpVOs;
		}
	}

	public KrWhfBlInfoVO getKrWhfBlInfoVO() {
		return krWhfBlInfoVO;
	}

	public void setKrWhfBlInfoVO(KrWhfBlInfoVO krWhfBlInfoVO) {
		this.krWhfBlInfoVO = krWhfBlInfoVO;
	}

	public List<KrWhfBlInfoVO> getKrWhfBlInfoVOs() {
		return krWhfBlInfoVOs;
	}

	public void setKrWhfBlInfoVOs(List<KrWhfBlInfoVO> krWhfBlInfoVOs) {
		this.krWhfBlInfoVOs = krWhfBlInfoVOs;
	}

	public KrWhfBlInfoVO[] getKrWhfBlInfoVOss() {
		KrWhfBlInfoVO[] rtnVOs = null;
		if (this.krWhfBlInfoVOss != null) {
			rtnVOs = Arrays.copyOf(krWhfBlInfoVOss, krWhfBlInfoVOss.length);
		}
		return rtnVOs;
	}

	public void setKrWhfBlInfoVOss(KrWhfBlInfoVO[] krWhfBlInfoVOss) {
		if (krWhfBlInfoVOss != null) {
			KrWhfBlInfoVO[] tmpVOs = Arrays.copyOf(krWhfBlInfoVOss, krWhfBlInfoVOss.length);
			this.krWhfBlInfoVOss = tmpVOs;
		}
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
		KrWhfVslInfoVO[] rtnVOs = null;
		if (this.krWhfVslInfoVOs2 != null) {
			rtnVOs = Arrays.copyOf(krWhfVslInfoVOs2, krWhfVslInfoVOs2.length);
		}
		return rtnVOs;
	}

	public void setKrWhfVslInfoVOs2(KrWhfVslInfoVO[] krWhfVslInfoVOs2) {
		if (krWhfVslInfoVOs2 != null) {
			KrWhfVslInfoVO[] tmpVOs = Arrays.copyOf(krWhfVslInfoVOs2, krWhfVslInfoVOs2.length);
			this.krWhfVslInfoVOs2 = tmpVOs;
		}
	}

}