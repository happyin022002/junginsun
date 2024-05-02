/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0064Event.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0064Event extends EventSupport {

	private TesTmlSoHdrVO 					tesTmlSoHdrVO 		= null;
	private OndockRailChargeInvoiceCommonVO ondockRailChargeInvoiceCommonVO = null;
	
	private ApPayInvVO			ApPayInvVO			= null;

	private TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs 	= null;
	private TesTmlSoDtlVO[] 		tesTmlSoDtlVOs			= null;
	private CheckInvoiceNoVO		checkInvoiceNoVO = null;
	
	private TesCommonVO 		tesCommonVO 		= null;
	private TesTmlSoCntrListVO 	tesTmlSoCntrListVO 	= null;
	
	public EsdTes0064Event(){}


	public CheckInvoiceNoVO getCheckInvoiceNoVO() {
		return checkInvoiceNoVO;
	}


	public void setCheckInvoiceNoVO(CheckInvoiceNoVO checkInvoiceNoVO) {
		this.checkInvoiceNoVO = checkInvoiceNoVO;
	}


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
	 * 
	 * @return
	 */
	public ApPayInvVO getApPayInvVO() {
		return ApPayInvVO;
	}

	/**
	 * 
	 * @param apPayInvVO
	 */
	public void setApPayInvVO(ApPayInvVO apPayInvVO) {
		ApPayInvVO = apPayInvVO;
	}

	
	/**
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoDtlVOs
	 */
	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		TesTmlSoDtlVO[] rtnVOs = null;
		if (this.tesTmlSoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoDtlVOs the tesTmlSoDtlVOs to set
	 */
	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs){
		if(tesTmlSoDtlVOs != null){
			TesTmlSoDtlVO[] tmpVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
			this.tesTmlSoDtlVOs = tmpVOs;
		}
	}

	/**
	 * @return the ondockRailChargeInvoiceCommonVO
	 */
	public OndockRailChargeInvoiceCommonVO getOndockRailChargeInvoiceCommonVO() {
		return ondockRailChargeInvoiceCommonVO;
	}

	/**
	 * @param ondockRailChargeInvoiceCommonVO the ondockRailChargeInvoiceCommonVO to set
	 */
	public void setOndockRailChargeInvoiceCommonVO(
			OndockRailChargeInvoiceCommonVO ondockRailChargeInvoiceCommonVO) {
		this.ondockRailChargeInvoiceCommonVO = ondockRailChargeInvoiceCommonVO;
	}


	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}


	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}


	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}


	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}


}
