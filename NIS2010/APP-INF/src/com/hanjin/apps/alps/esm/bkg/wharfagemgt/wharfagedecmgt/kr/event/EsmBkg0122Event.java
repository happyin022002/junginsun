/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0122Event.java
 *@FileTitle : EsmBkg0122Event
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

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCgoClassCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;

/**
 * ESM_BKG_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0122HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0122Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private KrWhfVslInfoCondVO krWhfVslInfoCondVO   = null;
	private KrWhfCgoClassCondVO krWhfCgoClassCondVO  = null;
	
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
	
	private BkgKrWhfVolVO bkgKrWhfVolVO = null;
	
	// BackEndJob을 위한 키
	private String key = "";
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
		return bkgKrWhfVolVos2;
	}
	public void setBkgKrWhfVolVos2(BkgKrWhfVolVO[] bkgKrWhfVolVos2) {
		this.bkgKrWhfVolVos2 = bkgKrWhfVolVos2;
	}
	public KrWhfCgoClassCondVO getKrWhfCgoClassCondVO() {
		return krWhfCgoClassCondVO;
	}
	public void setKrWhfCgoClassCondVO(KrWhfCgoClassCondVO krWhfCgoClassCondVO) {
		this.krWhfCgoClassCondVO = krWhfCgoClassCondVO;
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
		return krWhfBlInfoVOss;
	}
	public void setKrWhfBlInfoVOss(KrWhfBlInfoVO[] krWhfBlInfoVOss) {
		this.krWhfBlInfoVOss = krWhfBlInfoVOss;
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