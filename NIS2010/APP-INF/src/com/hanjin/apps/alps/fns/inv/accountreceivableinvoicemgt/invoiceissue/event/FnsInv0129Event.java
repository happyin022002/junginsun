/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv003402Event.java
*@FileTitle : Invoice Issue (Email)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.06 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArEmlCustRgstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0129 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0129HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0129HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0129Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private InvArEmlCustRgstVO invArEmlCustRgstVO;
    
    private InvArEmlCustRgstVO invArEmlCustRgstVOs[];
    
    private String arOfcCd;

	/**
	 * @return the invArEmlCustRgstVO
	 */
	public InvArEmlCustRgstVO getInvArEmlCustRgstVO() {
		return invArEmlCustRgstVO;
	}

	/**
	 * @param invArEmlCustRgstVO the invArEmlCustRgstVO to set
	 */
	public void setInvArEmlCustRgstVO(InvArEmlCustRgstVO invArEmlCustRgstVO) {
		this.invArEmlCustRgstVO = invArEmlCustRgstVO;
	}

	/**
	 * @return the invArEmlCustRgstVOs
	 */
	public InvArEmlCustRgstVO[] getInvArEmlCustRgstVOs() {
		return invArEmlCustRgstVOs;
	}

	/**
	 * @param invArEmlCustRgstVOs the invArEmlCustRgstVOs to set
	 */
	public void setInvArEmlCustRgstVOs(InvArEmlCustRgstVO[] invArEmlCustRgstVOs) {
		this.invArEmlCustRgstVOs = invArEmlCustRgstVOs;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
    
}