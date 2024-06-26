/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0012Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.15 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
/**
 * FNS_TOT_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortStlAmtVO portStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortStlAmtVO[] portStlAmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotPortStlAmtVO totPortStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotPortStlAmtVO[] totPortStlAmtVOs = null;
	
	public FnsTot0012Event(){}

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

	public TotPortStlAmtVO getTotPortStlAmtVO() {
		return totPortStlAmtVO;
	}

	public void setTotPortStlAmtVO(TotPortStlAmtVO totPortStlAmtVO) {
		this.totPortStlAmtVO = totPortStlAmtVO;
	}

	public TotPortStlAmtVO[] getTotPortStlAmtVOs() {
		TotPortStlAmtVO[] rtnVOs = null;
		if (this.totPortStlAmtVOs != null) {
			rtnVOs = new TotPortStlAmtVO[totPortStlAmtVOs.length];
			System.arraycopy(totPortStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotPortStlAmtVOs(TotPortStlAmtVO[] totPortStlAmtVOs) {
		if (totPortStlAmtVOs != null) {
			TotPortStlAmtVO[] tmpVOs = new TotPortStlAmtVO[totPortStlAmtVOs.length];
			System.arraycopy(totPortStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totPortStlAmtVOs = tmpVOs;
		}
	}




}