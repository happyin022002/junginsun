/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0023Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-10-30 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApInvDtrbVO;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

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
	
	private com.clt.framework.component.rowset.DBRowSet[] autoRowSetArr01 = null;
//	private com.clt.framework.component.rowset.DBRowSet[] autoRowSetArr02 = null;
	private com.clt.framework.component.rowset.DBRowSet[] manualRowSetArr01 = null;
	private com.clt.framework.component.rowset.DBRowSet[] dtrbRowSetArr = null;
	
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
		TesTmlSoHdrVO[] rtnVOs = null;
		if (this.tesTmlSoHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		if(tesTmlSoHdrVOs != null){
			TesTmlSoHdrVO[] tmpVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
			this.tesTmlSoHdrVOs = tmpVOs;
		}
	}
	/**
	 * @return the autoRowSetArr01
	 */
	public com.clt.framework.component.rowset.DBRowSet[] getAutoRowSetArr01() {
		DBRowSet[] rtnVOs = null;
		if (this.autoRowSetArr01 != null) {
			rtnVOs = Arrays.copyOf(autoRowSetArr01, autoRowSetArr01.length);
		}
		return rtnVOs;
	}
	/**
	 * @param autoRowSetArr01 the autoRowSetArr01 to set
	 */
	public void setAutoRowSetArr01(com.clt.framework.component.rowset.DBRowSet[] autoRowSetArr01) {
		if(autoRowSetArr01 != null){
			DBRowSet[] tmpVOs = Arrays.copyOf(autoRowSetArr01, autoRowSetArr01.length);
			this.autoRowSetArr01 = tmpVOs;
		}
	}

	/**
	 * @return the manualRowSetArr01
	 */
	public com.clt.framework.component.rowset.DBRowSet[] getManualRowSetArr01() {
		DBRowSet[] rtnVOs = null;
		if (this.manualRowSetArr01 != null) {
			rtnVOs = Arrays.copyOf(manualRowSetArr01, manualRowSetArr01.length);
		}
		return rtnVOs;
	}
	/**
	 * @param manualRowSetArr01 the manualRowSetArr01 to set
	 */
	public void setManualRowSetArr01(com.clt.framework.component.rowset.DBRowSet[] manualRowSetArr01) {
		if(manualRowSetArr01 != null){
			DBRowSet[] tmpVOs = Arrays.copyOf(manualRowSetArr01, manualRowSetArr01.length);
			this.manualRowSetArr01 = tmpVOs;
		}
	}
	/**
	 * @return the dtrbRowSetArr
	 */
	public com.clt.framework.component.rowset.DBRowSet[] getDtrbRowSetArr() {
		DBRowSet[] rtnVOs = null;
		if (this.dtrbRowSetArr != null) {
			rtnVOs = Arrays.copyOf(dtrbRowSetArr, dtrbRowSetArr.length);
		}
		return rtnVOs;
	}
	/**
	 * @param dtrbRowSetArr the dtrbRowSetArr to set
	 */
	public void setDtrbRowSetArr(com.clt.framework.component.rowset.DBRowSet[] dtrbRowSetArr) {
		if(dtrbRowSetArr != null){
			DBRowSet[] tmpVOs = Arrays.copyOf(dtrbRowSetArr, dtrbRowSetArr.length);
			this.dtrbRowSetArr = tmpVOs;
		}
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
	
}
