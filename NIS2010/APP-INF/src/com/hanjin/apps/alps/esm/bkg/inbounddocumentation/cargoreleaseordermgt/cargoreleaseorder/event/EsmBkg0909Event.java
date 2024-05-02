/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0909Event.java
*@FileTitle : Arrival Notice Code Validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.06.03 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;

/**
 * esm_bkg_0909 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0909HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0909HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0909Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private List<UsCgoRlseListVO> vos = null;
	private DoRefVO[] doRefVOs = null;
	private BkgCgoRlseVO[] bkgCgoRlseVOs = null;
	private BkgBlIssVO[] blIssVOs = null;
	public BkgBlIssVO[] getBlIssVOs() {
		return blIssVOs;
	}
	public void setBlIssVOs(BkgBlIssVO[] blIssVOs) {
		this.blIssVOs = blIssVOs;
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
		return bkgCgoRlseVOs;
	}
	public void setBkgCgoRlseVOs(BkgCgoRlseVO[] bkgCgoRlseVOs) {
		this.bkgCgoRlseVOs = bkgCgoRlseVOs;
	}
	public DoRefVO[] getDoRefVOs() {
		return doRefVOs;
	}
	public void setDoRefVOs(DoRefVO[] doRefVOs) {
		this.doRefVOs = doRefVOs;
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