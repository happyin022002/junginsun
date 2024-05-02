/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0023Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.02.04 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;

/**
 * FNS_TOT_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortStlAmtVO portStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortStlAmtVO[] portStlAmtVOs = null;
	
	public FnsTot0023Event(){}

	public PortStlAmtVO getPortStlAmtVO() {
		return portStlAmtVO;
	}

	public void setPortStlAmtVO(PortStlAmtVO portStlAmtVO) {
		this.portStlAmtVO = portStlAmtVO;
	}

	public PortStlAmtVO[] getPortStlAmtVOs() {
		PortStlAmtVO[] rtnVOs = null;
		if (this.portStlAmtVOs != null) {
			rtnVOs = new PortStlAmtVO[portStlAmtVOs.length];
			System.arraycopy(portStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPortStlAmtVOs(PortStlAmtVO[] portStlAmtVOs) {
		if (portStlAmtVOs != null) {
			PortStlAmtVO[] tmpVOs = new PortStlAmtVO[portStlAmtVOs.length];
			System.arraycopy(portStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portStlAmtVOs = tmpVOs;
		}
	}

}