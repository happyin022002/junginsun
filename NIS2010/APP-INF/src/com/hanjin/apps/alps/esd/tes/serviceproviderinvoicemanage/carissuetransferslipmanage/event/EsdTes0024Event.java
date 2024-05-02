/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_024Event.java
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0024Event extends EventSupport {

	private TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
	private TesTmlSoHdrVO[] tesTmlSoHdrVOs	= null;
	private ApInvHdrVO		apInvHdrVO		= null;
	private ApInvDtrbVO		apInvDtrbVO		= null;		
	private CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO = null;
	
	private com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr01 = null;
	private com.hanjin.framework.component.rowset.DBRowSet[] manualRowSetArr01 = null;
	private com.hanjin.framework.component.rowset.DBRowSet[] dtrbRowSetArr = null;
	
	private com.hanjin.framework.component.rowset.DBRowSet[] bkgRowSetArr01 = null;
	
	/**
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}
	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	/**
	 * @return the tesTmlSoHdrVOs
	 */
	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
		return tesTmlSoHdrVOs;
	}
	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs) {
		this.tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}
	/**
	 * @return the autoRowSetArr01
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getAutoRowSetArr01() {
		return autoRowSetArr01;
	}
	/**
	 * @param autoRowSetArr01 the autoRowSetArr01 to set
	 */
	public void setAutoRowSetArr01(
			com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr01) {
		this.autoRowSetArr01 = autoRowSetArr01;
	}
	/**
	 * @return the manualRowSetArr01
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getManualRowSetArr01() {
		return manualRowSetArr01;
	}
	/**
	 * @param manualRowSetArr01 the manualRowSetArr01 to set
	 */
	public void setManualRowSetArr01(
			com.hanjin.framework.component.rowset.DBRowSet[] manualRowSetArr01) {
		this.manualRowSetArr01 = manualRowSetArr01;
	}
	/**
	 * @return the dtrbRowSetArr
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getDtrbRowSetArr() {
		return dtrbRowSetArr;
	}
	/**
	 * @param dtrbRowSetArr the dtrbRowSetArr to set
	 */
	public void setDtrbRowSetArr(
			com.hanjin.framework.component.rowset.DBRowSet[] dtrbRowSetArr) {
		this.dtrbRowSetArr = dtrbRowSetArr;
	}
	/**
	 * @return the cARIssueTransferSlipManageCommonVO
	 */
	public CARIssueTransferSlipManageCommonVO getCARIssueTransferSlipManageCommonVO() {
		return cARIssueTransferSlipManageCommonVO;
	}
	/**
	 * @param issueTransferSlipManageCommonVO the cARIssueTransferSlipManageCommonVO to set
	 */
	public void setCARIssueTransferSlipManageCommonVO(
			CARIssueTransferSlipManageCommonVO issueTransferSlipManageCommonVO) {
		cARIssueTransferSlipManageCommonVO = issueTransferSlipManageCommonVO;
	}
	/**
	 * @return the apInvHdrVO
	 */
	public ApInvHdrVO getApInvHdrVO() {
		return apInvHdrVO;
	}
	/**
	 * @param apInvHdrVO the apInvHdrVO to set
	 */
	public void setApInvHdrVO(ApInvHdrVO apInvHdrVO) {
		this.apInvHdrVO = apInvHdrVO;
	}
	/**
	 * @return the apInvDtrbVO
	 */
	public ApInvDtrbVO getApInvDtrbVO() {
		return apInvDtrbVO;
	}
	/**
	 * @param apInvDtrbVO the apInvDtrbVO to set
	 */
	public void setApInvDtrbVO(ApInvDtrbVO apInvDtrbVO) {
		this.apInvDtrbVO = apInvDtrbVO;
	}
	/**
	 * @return the bkgRowSetArr01
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getBkgRowSetArr01() {
		return bkgRowSetArr01;
	}
	/**
	 * @param bkgRowSetArr01 the bkgRowSetArr01 to set
	 */
	public void setBkgRowSetArr01(
			com.hanjin.framework.component.rowset.DBRowSet[] bkgRowSetArr01) {
		this.bkgRowSetArr01 = bkgRowSetArr01;
	}

}
