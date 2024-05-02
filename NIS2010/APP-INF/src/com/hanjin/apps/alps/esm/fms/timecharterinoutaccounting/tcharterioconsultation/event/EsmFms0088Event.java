/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0008Event.java
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.24 민정호
* 1.0 Creation
* -------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import java.util.Collection;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.component.rowset.DBRowSet;
import java.util.Arrays;


/**
 * COM_CSR_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JungHo Min
 * @see COM_CSR_0088HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0088Event extends EventSupport {

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
	
	public EsmFms0088Event(){}
	
	/**
	 * @param PayInvVO payInvVO
	 * @param Collection payInvs
	 * @param CsrParmVO csrParm
	 */
	public EsmFms0088Event(PayInvVO payInvVO, Collection payInvs, CsrParmVO csrParm) {
		this.payInvVO = payInvVO;
		this.payInvs = payInvs;
		this.csrParmVO = csrParm;
    }
	
	/**
	 * @param PayInvVO payInvVO
	 * @param Collection payInvs
	 * @param CsrParmVO csrParm
	 * @param ComCsrInfoVO comCsrInfoVO
	 */		
	public EsmFms0088Event(PayInvVO payInvVO, Collection payInvs, CsrParmVO csrParm, ComCsrInfoVO comCsrInfoVO) {
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
		ApPayInvListVO[] rtnVOs = null;
		if (this.apPayInvListVOs != null) {
			rtnVOs = new ApPayInvListVO[apPayInvListVOs.length];
			System.arraycopy(apPayInvListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
	public DBRowSet[] getAutoRowSetArr01() {
		DBRowSet[] rtnVOs = null;
		if (this.autoRowSetArr01 != null) {
			rtnVOs = Arrays.copyOf(autoRowSetArr01, autoRowSetArr01.length);
		}
		return rtnVOs;
	}

	/**
	 * @param autoRowSetArr01 the autoRowSetArr01 to set
	 */
	public void setAutoRowSetArr01(DBRowSet[] autoRowSetArr01) {
		if (autoRowSetArr01 != null) {
			DBRowSet[] tmpVOs = Arrays.copyOf(autoRowSetArr01, autoRowSetArr01.length);
			this.autoRowSetArr01 = tmpVOs;
		}
	}

	/**
	 * @return the autoRowSetArr02
	 */
	public DBRowSet[] getAutoRowSetArr02() {
		DBRowSet[] rtnVOs = null;
		if (this.autoRowSetArr01 != null) {
			rtnVOs = Arrays.copyOf(autoRowSetArr02, autoRowSetArr02.length);
		}
		return rtnVOs;
	}

	/**
	 * @param autoRowSetArr02 the autoRowSetArr02 to set
	 */
	public void setAutoRowSetArr02(
			com.hanjin.framework.component.rowset.DBRowSet[] autoRowSetArr02) {
		if (autoRowSetArr02 != null) {
			DBRowSet[] tmpVOs = Arrays.copyOf(autoRowSetArr02, autoRowSetArr02.length);
			this.autoRowSetArr02 = tmpVOs;
		}
	}

	/**
	 * @return the manualRowSetArr01
	 */
	public DBRowSet[] getManualRowSetArr01() {
		DBRowSet[] rtnVOs = null;
		if (this.manualRowSetArr01 != null) {
			rtnVOs = Arrays.copyOf(manualRowSetArr01, manualRowSetArr01.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manualRowSetArr01 the manualRowSetArr01 to set
	 */
	public void setManualRowSetArr01(
			com.hanjin.framework.component.rowset.DBRowSet[] manualRowSetArr01) {
		if (manualRowSetArr01 != null) {
			DBRowSet[] tmpVOs = Arrays.copyOf(manualRowSetArr01, manualRowSetArr01.length);
			this.manualRowSetArr01 = tmpVOs;
		}
	}

	/**
	 * @return the dtrbRowSetArr
	 */
	public com.hanjin.framework.component.rowset.DBRowSet[] getDtrbRowSetArr() {
		DBRowSet[] rtnVOs = null;
		if (this.dtrbRowSetArr != null) {
			rtnVOs = Arrays.copyOf(dtrbRowSetArr, dtrbRowSetArr.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dtrbRowSetArr the dtrbRowSetArr to set
	 */
	public void setDtrbRowSetArr(DBRowSet[] dtrbRowSetArr) {
		if (dtrbRowSetArr != null) {
			DBRowSet[] tmpVOs = Arrays.copyOf(dtrbRowSetArr, dtrbRowSetArr.length);
			this.dtrbRowSetArr = tmpVOs;
		}
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
		return "EsmFms0088Event";
	}

	public String toString() {
		return "EsmFms0088Event";
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
		IfCsrListInputVO[] rtnVOs = null;
		if (this.ifCsrListInputVOs != null) {
			rtnVOs = new IfCsrListInputVO[ifCsrListInputVOs.length];
			System.arraycopy(ifCsrListInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param ifCsrListInputVOs the ifCsrListInputVOs to set
	 */
	public void setIfCsrListInputVOs(IfCsrListInputVO[] ifCsrListInputVOs) {
		if (ifCsrListInputVOs != null) {
			IfCsrListInputVO[] tmpVOs = new IfCsrListInputVO[ifCsrListInputVOs.length];
			System.arraycopy(ifCsrListInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ifCsrListInputVOs = tmpVOs;
		}
	}
	
	public void setComCsrInfoVO(ComCsrInfoVO comCsrInfoVO){
		this.comCsrInfoVO = comCsrInfoVO;
	}
	
	public ComCsrInfoVO getComCsrInfoVO() {
		return comCsrInfoVO;
	}
	
}