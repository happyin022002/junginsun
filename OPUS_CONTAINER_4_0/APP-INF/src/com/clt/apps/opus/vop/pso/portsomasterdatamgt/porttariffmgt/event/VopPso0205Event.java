/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPso0205Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_PSO-0205 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PSO-0205HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0205HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0205Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	private VendorVO vendorVO = null;
	
	/** Table Value Object Multi Data 처리 */


	private VendorVO[] vendorVOs = null; // searchOfficeVendor메소드로 찾아온 Vendor리스트

	public VopPso0205Event(){}
	
	public void setVendorVOs(VendorVO[] vendorVOs) {
		if (vendorVOs != null) {
			VendorVO[] tmpVOs = new VendorVO[vendorVOs.length];
			System.arraycopy(vendorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vendorVOs = tmpVOs;
		}
	}

	public VendorVO[] getVendorVOs() {
		VendorVO[] tmpVOs = null;
		if (this.vendorVOs != null) {
			tmpVOs = new VendorVO[vendorVOs.length];
			System.arraycopy(vendorVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setVendorVO(VendorVO vendorVO) {
		this.vendorVO = vendorVO;
	}

	public VendorVO getVendorVO() {
		return vendorVO;
	}

}