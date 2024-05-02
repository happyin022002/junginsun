/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0020Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.05 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;

/**
 * FNS_TOT_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ErpIfVO erpIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ErpIfVO[] erpIfVOs = null;
	
	
	public FnsTot0020Event(){}


	public ErpIfVO getErpIfVO() {
		return erpIfVO;
	}


	public void setErpIfVO(ErpIfVO erpIfVO) {
		this.erpIfVO = erpIfVO;
	}


	public ErpIfVO[] getErpIfVOs() {
		ErpIfVO[] rtnVOs = null;
		if (this.erpIfVOs != null) {
			rtnVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setErpIfVOs(ErpIfVO[] erpIfVOs) {
		if (erpIfVOs != null) {
			ErpIfVO[] tmpVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.erpIfVOs = tmpVOs;
		}
	}


}