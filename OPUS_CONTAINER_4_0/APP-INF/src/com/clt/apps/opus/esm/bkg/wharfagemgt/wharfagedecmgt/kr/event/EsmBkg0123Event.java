/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0123Event.java
 *@FileTitle : EsmBkg0123Event
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

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgKrWhfCntrVO;
import com.clt.syscommon.common.table.BkgKrWhfCustVO;


/**
 * ESM_BKG_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jae yoeb jeong
 * @see ESM_BKG_0123HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrBlCondVO krBlCondVO   = null;
	private KrWhfBkgInfoCondVO krWhfBkgInfoCondVO = null;

	private KrWhfBkgKrWhfBlVO[]     krWhfBkgKrWhfBlVOs = null ;
	private List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs2 = null ;

	private BkgKrWhfCustVO[]        bkgKrWhfCustVOs    = null ;
	private List<BkgKrWhfCustVO>    bkgKrWhfCustVOs2   = null ;

	private BkgKrWhfCntrVO[]        bkgKrWhfCntrVOs    = null ;
	private List<BkgKrWhfCntrVO>    bkgKrWhfCntrVOs2   = null ;

	private KrWhfBlContainerVO[] krWhfBlContainerVOs = null;
	private List<KrWhfBlContainerVO> krWhfBlContainerVOs2 = null;

	private KrWhfVslInfoCondVO krWhfVslInfoCondVO   = null;

	public KrWhfBkgInfoCondVO getKrWhfBkgInfoCondVO() {
		return krWhfBkgInfoCondVO;
	}

	public void setKrWhfBkgInfoCondVO(KrWhfBkgInfoCondVO krWhfBkgInfoCondVO) {
		this.krWhfBkgInfoCondVO = krWhfBkgInfoCondVO;
	}

	public KrWhfBkgKrWhfBlVO[] getKrWhfBkgKrWhfBlVOs() {
		KrWhfBkgKrWhfBlVO[] rtnVOs = null;
		if (this.krWhfBkgKrWhfBlVOs != null) {
			rtnVOs = Arrays.copyOf(krWhfBkgKrWhfBlVOs, krWhfBkgKrWhfBlVOs.length);
		}
		return rtnVOs;
	}

	public void setKrWhfBkgKrWhfBlVOs(KrWhfBkgKrWhfBlVO[] krWhfBkgKrWhfBlVOs) {
		if (krWhfBkgKrWhfBlVOs != null) {
			KrWhfBkgKrWhfBlVO[] tmpVOs = Arrays.copyOf(krWhfBkgKrWhfBlVOs, krWhfBkgKrWhfBlVOs.length);
			this.krWhfBkgKrWhfBlVOs = tmpVOs;
		}
	}

	public List<KrWhfBkgKrWhfBlVO> getKrWhfBkgKrWhfBlVOs2() {
		return krWhfBkgKrWhfBlVOs2;
	}

	public void setKrWhfBkgKrWhfBlVOs2(List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs2) {
		this.krWhfBkgKrWhfBlVOs2 = krWhfBkgKrWhfBlVOs2;
	}

	public BkgKrWhfCustVO[] getBkgKrWhfCustVOs() {
		BkgKrWhfCustVO[] rtnVOs = null;
		if (this.bkgKrWhfCustVOs != null) {
			rtnVOs = Arrays.copyOf(bkgKrWhfCustVOs, bkgKrWhfCustVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgKrWhfCustVOs(BkgKrWhfCustVO[] bkgKrWhfCustVOs) {
		if (bkgKrWhfCustVOs != null) {
			BkgKrWhfCustVO[] tmpVOs = Arrays.copyOf(bkgKrWhfCustVOs, bkgKrWhfCustVOs.length);
			this.bkgKrWhfCustVOs = tmpVOs;
		}
	}

	public List<BkgKrWhfCustVO> getBkgKrWhfCustVOs2() {
		return bkgKrWhfCustVOs2;
	}

	public void setBkgKrWhfCustVOs2(List<BkgKrWhfCustVO> bkgKrWhfCustVOs2) {
		this.bkgKrWhfCustVOs2 = bkgKrWhfCustVOs2;
	}

	public BkgKrWhfCntrVO[] getBkgKrWhfCntrVOs() {
		BkgKrWhfCntrVO[] rtnVOs = null;
		if (this.bkgKrWhfCntrVOs != null) {
			rtnVOs = Arrays.copyOf(bkgKrWhfCntrVOs, bkgKrWhfCntrVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgKrWhfCntrVOs(BkgKrWhfCntrVO[] bkgKrWhfCntrVOs) {
		if (bkgKrWhfCntrVOs != null) {
			BkgKrWhfCntrVO[] tmpVOs = Arrays.copyOf(bkgKrWhfCntrVOs, bkgKrWhfCntrVOs.length);
			this.bkgKrWhfCntrVOs = tmpVOs;
		}
	}

	public List<BkgKrWhfCntrVO> getBkgKrWhfCntrVOs2() {
		return bkgKrWhfCntrVOs2;
	}

	public void setBkgKrWhfCntrVOs2(List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs2) {
		this.bkgKrWhfCntrVOs2 = bkgKrWhfCntrVOs2;
	}

	public KrWhfBlContainerVO[] getKrWhfBlContainerVOs() {
		KrWhfBlContainerVO[] rtnVOs = null;
		if (this.krWhfBlContainerVOs != null) {
			rtnVOs = Arrays.copyOf(krWhfBlContainerVOs, krWhfBlContainerVOs.length);
		}
		return rtnVOs;
	}

	public void setKrWhfBlContainerVOs(KrWhfBlContainerVO[] krWhfBlContainerVOs) {
		if (krWhfBlContainerVOs != null) {
			KrWhfBlContainerVO[] tmpVOs = Arrays.copyOf(krWhfBlContainerVOs, krWhfBlContainerVOs.length);
			this.krWhfBlContainerVOs = tmpVOs;
		}
	}

	public List<KrWhfBlContainerVO> getKrWhfBlContainerVOs2() {
		return krWhfBlContainerVOs2;
	}

	public void setKrWhfBlContainerVOs2(List<KrWhfBlContainerVO> krWhfBlContainerVOs2) {
		this.krWhfBlContainerVOs2 = krWhfBlContainerVOs2;
	}

	public KrBlCondVO getKrBlCondVO() {
		return krBlCondVO;
	}

	public void setKrBlCondVO(KrBlCondVO krBlCondVO) {
		this.krBlCondVO = krBlCondVO;
	}

	public KrWhfVslInfoCondVO getKrWhfVslInfoCondVO() {
		return krWhfVslInfoCondVO;
	}

	public void setKrWhfVslInfoCondVO(KrWhfVslInfoCondVO krWhfVslInfoCondVO) {
		this.krWhfVslInfoCondVO = krWhfVslInfoCondVO;
	}

}