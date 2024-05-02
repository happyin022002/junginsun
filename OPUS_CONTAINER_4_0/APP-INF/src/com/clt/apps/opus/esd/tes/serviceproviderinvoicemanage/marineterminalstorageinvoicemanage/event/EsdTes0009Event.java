/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_009Event.java
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0009Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO = null;
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoDtlVO[] tesTmlSoDtlVOs = null; 
	private TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null; 
	private ApPayInvVO ApPayInvVO = null;
	private CheckInvoiceNoVO		checkInvoiceNoVO = null;
	
	private TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
	private TesCommonVO 	tesCommonVO = null;
	
	public EsdTes0009Event(){}
	
	public CheckInvoiceNoVO getCheckInvoiceNoVO() {
		return checkInvoiceNoVO;
	}

	public void setCheckInvoiceNoVO(CheckInvoiceNoVO checkInvoiceNoVO) {
		this.checkInvoiceNoVO = checkInvoiceNoVO;
	}

	public MarineTerminalStorageInvoiceManageVO getMarineTerminalStorageInvoiceManageVO() {
		return marineTerminalStorageInvoiceManageVO;
	}

	public void setMarineTerminalStorageInvoiceManageVO(
			MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO) {
		this.marineTerminalStorageInvoiceManageVO = marineTerminalStorageInvoiceManageVO;
	}
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		TesTmlSoDtlVO[] rtnVOs = null;
		if (this.tesTmlSoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs){
		if(tesTmlSoDtlVOs != null){
			TesTmlSoDtlVO[] tmpVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
			this.tesTmlSoDtlVOs = tmpVOs;
		}
	}

    public ApPayInvVO getApPayInvVO() {
		return ApPayInvVO;
	}
    
	public void setApPayInvVO(ApPayInvVO apPayInvVO) {
		ApPayInvVO = apPayInvVO;
	}
	
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}

	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}
}
