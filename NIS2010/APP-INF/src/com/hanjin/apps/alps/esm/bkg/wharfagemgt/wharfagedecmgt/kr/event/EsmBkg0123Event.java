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
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgKrWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCustVO;

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
		return krWhfBkgKrWhfBlVOs;
	}

	public void setKrWhfBkgKrWhfBlVOs(KrWhfBkgKrWhfBlVO[] krWhfBkgKrWhfBlVOs) {
		this.krWhfBkgKrWhfBlVOs = krWhfBkgKrWhfBlVOs;
	}

	public List<KrWhfBkgKrWhfBlVO> getKrWhfBkgKrWhfBlVOs2() {
		return krWhfBkgKrWhfBlVOs2;
	}

	public void setKrWhfBkgKrWhfBlVOs2(List<KrWhfBkgKrWhfBlVO> krWhfBkgKrWhfBlVOs2) {
		this.krWhfBkgKrWhfBlVOs2 = krWhfBkgKrWhfBlVOs2;
	}

	public BkgKrWhfCustVO[] getBkgKrWhfCustVOs() {
		return bkgKrWhfCustVOs;
	}

	public void setBkgKrWhfCustVOs(BkgKrWhfCustVO[] bkgKrWhfCustVOs) {
		this.bkgKrWhfCustVOs = bkgKrWhfCustVOs;
	}

	public List<BkgKrWhfCustVO> getBkgKrWhfCustVOs2() {
		return bkgKrWhfCustVOs2;
	}

	public void setBkgKrWhfCustVOs2(List<BkgKrWhfCustVO> bkgKrWhfCustVOs2) {
		this.bkgKrWhfCustVOs2 = bkgKrWhfCustVOs2;
	}

	public BkgKrWhfCntrVO[] getBkgKrWhfCntrVOs() {
		return bkgKrWhfCntrVOs;
	}

	public void setBkgKrWhfCntrVOs(BkgKrWhfCntrVO[] bkgKrWhfCntrVOs) {
		this.bkgKrWhfCntrVOs = bkgKrWhfCntrVOs;
	}

	public List<BkgKrWhfCntrVO> getBkgKrWhfCntrVOs2() {
		return bkgKrWhfCntrVOs2;
	}

	public void setBkgKrWhfCntrVOs2(List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs2) {
		this.bkgKrWhfCntrVOs2 = bkgKrWhfCntrVOs2;
	}

	public KrWhfBlContainerVO[] getKrWhfBlContainerVOs() {
		return krWhfBlContainerVOs;
	}

	public void setKrWhfBlContainerVOs(KrWhfBlContainerVO[] krWhfBlContainerVOs) {
		this.krWhfBlContainerVOs = krWhfBlContainerVOs;
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