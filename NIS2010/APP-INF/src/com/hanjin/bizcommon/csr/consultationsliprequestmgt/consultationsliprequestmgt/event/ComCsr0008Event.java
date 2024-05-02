/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComCsr0008Event.java
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.16 함대성
* 1.0 Creation
* -------------------------------------------------------
* History
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import java.util.Collection;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_CSR_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see COM_CSR_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private IfCsrListInputVO ifCsrListInputVO = null;
	
	private IfCsrListInputVO[] ifCsrListInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ApPayInvListVO apPayInvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ApPayInvListVO[] apPayInvListVOs = null;
	
	private CsrListInputVO csrListInputVO  = null;
	
	private AsaNoVO asaNoVO = null;
	
	private PayInvVO payInvVO  = null;
	
	private Collection payInvs = null;
	
	private CsrParmVO csrParmVO = null;
	
	private com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr01 = null;
	private com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr02 = null;
	private com.hanjin.framework.component.rowset.DBRowSet[] manualRowSetArr01 = null;
	private com.hanjin.framework.component.rowset.DBRowSet[] dtrbRowSetArr = null;
	
	private ComCsrInfoVO comCsrInfoVO = null;	//EAI 송수신용
	
	public ComCsr0008Event(){}
	
	/**
	 * @param PayInvVO payInvVO
	 * @param Collection payInvs
	 * @param CsrParmVO csrParm
	 */
	public ComCsr0008Event(PayInvVO payInvVO, Collection payInvs, CsrParmVO csrParm) {
		this.payInvVO = payInvVO;
		this.payInvs = payInvs;
		this.csrParmVO = csrParm;
    }
	
	public ComCsr0008Event(PayInvVO payInvVO, Collection payInvs, CsrParmVO csrParm, ComCsrInfoVO comCsrInfoVO) {
		this.payInvVO = payInvVO;
		this.payInvs = payInvs;
		this.csrParmVO = csrParm;
		this.comCsrInfoVO = comCsrInfoVO;
    }
	
	/**
	 * @param ApPayInvListVO apPayInvListVO
	 */
	public void setApPayInvListVO(ApPayInvListVO apPayInvListVO){
		this. apPayInvListVO = apPayInvListVO;
	}

	public ApPayInvListVO getApPayInvListVO(){
		return apPayInvListVO;
	}

	public ApPayInvListVO[] getApPayInvListVOS(){
		return apPayInvListVOs;
	}

	/**
	 * @return the csrListInputVO
	 */
	public CsrListInputVO getCsrListInputVO() {
		return csrListInputVO;
	}

	/**
	 * @param csrListInputVO the csrListInputVO to set
	 */
	public void setCsrListInputVO(CsrListInputVO csrListInputVO) {
		this.csrListInputVO = csrListInputVO;
	}
	
	/**
	 * @return the asaNo
	 */
	public AsaNoVO getAsaNoVO() {
		return asaNoVO;
	}

	/**
	 * @param asaNo the asaNo to set
	 */
	public void setAsaNoVO(AsaNoVO asaNoVO) {
		this.asaNoVO = asaNoVO;
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
	 * @return the autoRowSetArr02
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getAutoRowSetArr02() {
		return autoRowSetArr02;
	}

	/**
	 * @param autoRowSetArr02 the autoRowSetArr02 to set
	 */
	public void setAutoRowSetArr02(
			com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr02) {
		this.autoRowSetArr02 = autoRowSetArr02;
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
	 * @return the csrParmVO
	 */
	public CsrParmVO getCsrParmVO() {
		return csrParmVO;
	}

	/**
	 * @param csrParmVO the csrParmVO to set
	 */
	public void setCsrParmVO(CsrParmVO csrParmVO) {
		this.csrParmVO = csrParmVO;
	}

	/**
	 * @return the payInvVO
	 */
	public PayInvVO getPayInvVO() {
		return payInvVO;
	}
 
	/**
	 * @return the payInvs
	 */
	public Collection getPayInvs() {
		return payInvs;
	} 
	
	public String getEventName() {
		return "ComCsr0008Event";
	}

	public String toString() {
		return "ComCsr0008Event";
	}
	
	/**
	 * @return the ifCsrListInputVO
	 */
	public IfCsrListInputVO getIfCsrListInputVO() {
		return ifCsrListInputVO;
	}

	/**
	 * @param ifCsrListInputVO the ifCsrListInputVO to set
	 */
	public void setIfCsrListInputVO(IfCsrListInputVO ifCsrListInputVO) {
		this.ifCsrListInputVO = ifCsrListInputVO;
	}

	/**
	 * @return the ifCsrListInputVOs
	 */
	public IfCsrListInputVO[] getIfCsrListInputVOs() {
		return ifCsrListInputVOs;
	}

	/**
	 * @param ifCsrListInputVOs the ifCsrListInputVOs to set
	 */
	public void setIfCsrListInputVOs(IfCsrListInputVO[] ifCsrListInputVOs) {
		this.ifCsrListInputVOs = ifCsrListInputVOs;
	}
	
	public void setComCsrInfoVO(ComCsrInfoVO comCsrInfoVO){
		this.comCsrInfoVO = comCsrInfoVO;
	}
	
	public ComCsrInfoVO getComCsrInfoVO() {
		return comCsrInfoVO;
	}
	
}