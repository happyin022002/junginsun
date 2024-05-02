/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0909Event.java
*@FileTitle : Arrival Notice Code Validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgOutstandingVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgCgoRlseVO;

/**
 * esm_bkg_0909 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0909HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0909HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0909Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private List<UsCgoRlseListVO> vos = null;
	private DoRefVO[] doRefVOs = null;
	private BkgCgoRlseVO[] bkgCgoRlseVOs = null;
	private BkgOutstandingVO[] bkgOutstandingVOs = null;
	private BkgOutstandingVO bkgOutstandingVO = null;
	private BkgBlIssVO[] blIssVOs = null;

	public BkgBlIssVO[] getBlIssVOs() {
		BkgBlIssVO[] tmpVOs = null;
		if (this.blIssVOs != null) {
			tmpVOs = new BkgBlIssVO[blIssVOs.length];
			System.arraycopy(blIssVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setBlIssVOs(BkgBlIssVO[] blIssVOs) {
		if (blIssVOs != null) {
			BkgBlIssVO[] tmpVOs = new BkgBlIssVO[blIssVOs.length];
			System.arraycopy(blIssVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blIssVOs = tmpVOs;
		}
	}

	private String bkgNo = null;
	private String blNo = null;
	private String podCd = null;
	
	public String getPodCd() {
		return podCd;
	}
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	/**
     * Demurrage 타입
     */
    private String demurType = "";
    /**
     * Expect Delivery Date
     */
    private String expDelDt  = "";
	

	public String getExpDelDt() {
		return expDelDt;
	}
	public void setExpDelDt(String expDelDt) {
		this.expDelDt = expDelDt;
	}
	public String getDemurType() {
		return demurType;
	}
	public void setDemurType(String demurType) {
		this.demurType = demurType;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public BkgCgoRlseVO[] getBkgCgoRlseVOs() {
		BkgCgoRlseVO[] tmpVOs = null;
		if (this.bkgCgoRlseVOs != null) {
			tmpVOs = new BkgCgoRlseVO[bkgCgoRlseVOs.length];
			System.arraycopy(bkgCgoRlseVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setBkgCgoRlseVOs(BkgCgoRlseVO[] bkgCgoRlseVOs) {
		if (bkgCgoRlseVOs != null) {
			BkgCgoRlseVO[] tmpVOs = new BkgCgoRlseVO[bkgCgoRlseVOs.length];
			System.arraycopy(bkgCgoRlseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCgoRlseVOs = tmpVOs;
		}		
	}
	
	public BkgOutstandingVO[] getBkgOutstandingVOs() {
		BkgOutstandingVO[] tmpVOs = null;
		if (this.bkgOutstandingVOs != null) {
			tmpVOs = new BkgOutstandingVO[bkgOutstandingVOs.length];
			System.arraycopy(bkgOutstandingVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setBkgOutstandingVOs(BkgOutstandingVO[] bkgOutstandingVOs) {
		if (bkgOutstandingVOs != null) {
			BkgOutstandingVO[] tmpVOs = new BkgOutstandingVO[bkgOutstandingVOs.length];
			System.arraycopy(bkgOutstandingVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgOutstandingVOs = tmpVOs;
		}		
	}
	
	public BkgOutstandingVO getBkgOutstandingVO() {
		return bkgOutstandingVO;
	}
	public void setBkgOutstandingVO(BkgOutstandingVO bkgOutstandingVO) {
		this.bkgOutstandingVO = bkgOutstandingVO;
	}
	
	public DoRefVO[] getDoRefVOs() {
		DoRefVO[] tmpVOs = null;
		if (this.doRefVOs != null) {
			tmpVOs = new DoRefVO[doRefVOs.length];
			System.arraycopy(doRefVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setDoRefVOs(DoRefVO[] doRefVOs) {
		if (doRefVOs != null) {
			DoRefVO[] tmpVOs = new DoRefVO[doRefVOs.length];
			System.arraycopy(doRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.doRefVOs = tmpVOs;
		}		
	}
	public List<UsCgoRlseListVO> getVos() {
		return vos;
	}
	public void setVos(List<UsCgoRlseListVO> vos) {
		this.vos = vos;
	}
	private UsCgoRlseSearchVO searchVO = null;
	
	public UsCgoRlseSearchVO getSearchVO() {
		return searchVO;
	}
	public void setSearchVO(UsCgoRlseSearchVO searchVO) {
		this.searchVO = searchVO;
	}
	
}
