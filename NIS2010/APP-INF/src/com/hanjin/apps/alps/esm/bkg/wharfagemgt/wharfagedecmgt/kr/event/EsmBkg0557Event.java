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
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;

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
	
	private String hisSeq = null;
	private String returnValues = null;
	// BackEndJob을 위한 키
	private String key = "";
	
	public KrWhfPortRtVO getKrWhfPortRtVO() {
		return krWhfPortRtVO;
	}
	public void setKrWhfPortRtVO(KrWhfPortRtVO krWhfPortRtVO) {
		this.krWhfPortRtVO = krWhfPortRtVO;
	}
	public KrWhfDecExptVolVO[] getKrWhfDecExptVolVOs() {
		return krWhfDecExptVolVOs;
	}
	public void setKrWhfDecExptVolVOs(KrWhfDecExptVolVO[] krWhfDecExptVolVOs) {
		this.krWhfDecExptVolVOs = krWhfDecExptVolVOs;
	}
	public KrWhfDecVO getKrWhfDecVO() {
		return krWhfDecVO;
	}
	public KrWhfVvdDtlVO[] getKrWhfVvdDtlVOs() {
		return krWhfVvdDtlVOs;
	}
	public void setKrWhfVvdDtlVOs(KrWhfVvdDtlVO[] krWhfVvdDtlVOs) {
		this.krWhfVvdDtlVOs = krWhfVvdDtlVOs;
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
		return bkgKrWhfVolVos2;
	}
	public void setBkgKrWhfVolVos2(BkgKrWhfVolVO[] bkgKrWhfVolVos2) {
		this.bkgKrWhfVolVos2 = bkgKrWhfVolVos2;
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
	public String getHisSeq() {
		return hisSeq;
	}
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	public String getReturnValues() {
		return returnValues;
	}
	public void setReturnValues(String returnValues) {
		this.returnValues = returnValues;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}