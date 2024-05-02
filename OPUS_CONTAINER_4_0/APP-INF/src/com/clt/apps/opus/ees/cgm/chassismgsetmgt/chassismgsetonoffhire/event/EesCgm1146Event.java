/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1146Event.java
*@FileTitle : 자가 장비를 Creation 한후 자가 장비를 취득을 위하여 ERP FA로 Interface 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.09 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.FaErpListVO;


/**
 * EES_CGM_1146 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1146HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1146HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1146Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ErpFaInterfaceINVO erpFaInterfaceINVO = null;
	private ErpFaInterfaceINVO[] erpFaInterfaceINVOs = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private ErpFaInterfaceMGTVO erpFaInterfaceMGTVO = null;
	private ErpFaInterfaceMGTVO[] erpFaInterfaceMGTVOs = null;
	private FaErpListVO[] faErpListVOs = null; // chungpa 20090907 FNS026-0001

	public EesCgm1146Event(){}
	
	public void setErpFaInterfaceMGTVO(ErpFaInterfaceMGTVO erpFaInterfaceMGTVO){
		this. erpFaInterfaceMGTVO = erpFaInterfaceMGTVO;
	}

	public void setErpFaInterfaceMGTVOS(ErpFaInterfaceMGTVO[] erpFaInterfaceMGTVOs){
		if(erpFaInterfaceMGTVOs != null){
			ErpFaInterfaceMGTVO[] tmpVOs = java.util.Arrays.copyOf(erpFaInterfaceMGTVOs, erpFaInterfaceMGTVOs.length);
			this.erpFaInterfaceMGTVOs = tmpVOs;
		}
	}

	public ErpFaInterfaceMGTVO getErpFaInterfaceMGTVO(){
		return erpFaInterfaceMGTVO;
	}

	public ErpFaInterfaceMGTVO[] getErpFaInterfaceMGTVOS(){
		ErpFaInterfaceMGTVO[] rtnVOs = null;
		if (this.erpFaInterfaceMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(erpFaInterfaceMGTVOs, erpFaInterfaceMGTVOs.length);
		}
		return rtnVOs;
	}

	public ErpFaInterfaceINVO[] getErpFaInterfaceINVOs() {
		ErpFaInterfaceINVO[] rtnVOs = null;
		if (this.erpFaInterfaceINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(erpFaInterfaceINVOs, erpFaInterfaceINVOs.length);
		}
		return rtnVOs;
	}

	public void setErpFaInterfaceINVOs(ErpFaInterfaceINVO[] erpFaInterfaceINVOs){
		if(erpFaInterfaceINVOs != null){
			ErpFaInterfaceINVO[] tmpVOs = java.util.Arrays.copyOf(erpFaInterfaceINVOs, erpFaInterfaceINVOs.length);
			this.erpFaInterfaceINVOs = tmpVOs;
		}
	}

	public ErpFaInterfaceMGTVO[] getErpFaInterfaceMGTVOs() {
		ErpFaInterfaceMGTVO[] rtnVOs = null;
		if (this.erpFaInterfaceMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(erpFaInterfaceMGTVOs, erpFaInterfaceMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setErpFaInterfaceMGTVOs(ErpFaInterfaceMGTVO[] erpFaInterfaceMGTVOs){
		if(erpFaInterfaceMGTVOs != null){
			ErpFaInterfaceMGTVO[] tmpVOs = java.util.Arrays.copyOf(erpFaInterfaceMGTVOs, erpFaInterfaceMGTVOs.length);
			this.erpFaInterfaceMGTVOs = tmpVOs;
		}
	}

	public ErpFaInterfaceINVO getErpFaInterfaceINVO() {
		return erpFaInterfaceINVO;
	}

	public void setErpFaInterfaceINVO(ErpFaInterfaceINVO erpFaInterfaceINVO) {
		this.erpFaInterfaceINVO = erpFaInterfaceINVO;
	}

	public FaErpListVO[] getFaErpListVOs() {
		FaErpListVO[] rtnVOs = null;
		if (this.faErpListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(faErpListVOs, faErpListVOs.length);
		}
		return rtnVOs;
	}

	public void setFaErpListVOs(FaErpListVO[] faErpListVOs){
		if(faErpListVOs != null){
			FaErpListVO[] tmpVOs = java.util.Arrays.copyOf(faErpListVOs, faErpListVOs.length);
			this.faErpListVOs = tmpVOs;
		}
	}

	
}