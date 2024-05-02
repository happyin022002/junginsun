/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1167Event.java
*@FileTitle : Canada Cargo Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.06.03 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgCgoRlseVO;
 
/**
 * esm_bkg_1167 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1167HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_1167HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1167Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private List<CaCgoRlseListVO> vos = null;
	private DoRefVO[] doRefVOs = null;
	private BkgCgoRlseVO[] bkgCgoRlseVOs = null;
	private BkgBlIssVO[] blIssVOs = null;
	public BkgBlIssVO[] getBlIssVOs() {
		BkgBlIssVO[] rtnVOs = null;
		if (this.blIssVOs != null) {
			rtnVOs = new BkgBlIssVO[blIssVOs.length];
			System.arraycopy(blIssVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setBlIssVOs(BkgBlIssVO[] blIssVOs){
		if(blIssVOs != null){
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
		BkgCgoRlseVO[] rtnVOs = null;
		if (this.bkgCgoRlseVOs != null) {
			rtnVOs = new BkgCgoRlseVO[bkgCgoRlseVOs.length];
			System.arraycopy(bkgCgoRlseVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setBkgCgoRlseVOs(BkgCgoRlseVO[] bkgCgoRlseVOs){
		if(bkgCgoRlseVOs != null){
			BkgCgoRlseVO[] tmpVOs = new BkgCgoRlseVO[bkgCgoRlseVOs.length];
			System.arraycopy(bkgCgoRlseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCgoRlseVOs = tmpVOs;
		}
	}
	public DoRefVO[] getDoRefVOs() {
		DoRefVO[] rtnVOs = null;
		if (this.doRefVOs != null) {
			rtnVOs = new DoRefVO[doRefVOs.length];
			System.arraycopy(doRefVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setDoRefVOs(DoRefVO[] doRefVOs){
		if(doRefVOs != null){
			DoRefVO[] tmpVOs = new DoRefVO[doRefVOs.length];
			System.arraycopy(doRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.doRefVOs = tmpVOs;
		}
	}
	public List<CaCgoRlseListVO> getVos() {
		return vos;
	}
	public void setVos(List<CaCgoRlseListVO> vos) {
		this.vos = vos;
	}
	private CaCgoRlseSearchVO searchVO = null;
	
	public CaCgoRlseSearchVO getSearchVO() {
		return searchVO;
	}
	public void setSearchVO(CaCgoRlseSearchVO searchVO) {
		this.searchVO = searchVO;
	}
	
}