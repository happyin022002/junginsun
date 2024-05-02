/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0017Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.30 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;

/**
 * FNS_TOT_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdStlAmtVO vvdStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdStlAmtVO[] vvdStlAmtVOs = null;

	
	public FnsTot0017Event(){}


	public VvdStlAmtVO getVvdStlAmtVO() {
		return vvdStlAmtVO;
	}


	public void setVvdStlAmtVO(VvdStlAmtVO vvdStlAmtVO) {
		this.vvdStlAmtVO = vvdStlAmtVO;
	}


	public VvdStlAmtVO[] getVvdStlAmtVOs() {
		VvdStlAmtVO[] rtnVOs = null;
		if (this.vvdStlAmtVOs != null) {
			rtnVOs = new VvdStlAmtVO[vvdStlAmtVOs.length];
			System.arraycopy(vvdStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setVvdStlAmtVOs(VvdStlAmtVO[] vvdStlAmtVOs) {
		if (vvdStlAmtVOs != null) {
			VvdStlAmtVO[] tmpVOs = new VvdStlAmtVO[vvdStlAmtVOs.length];
			System.arraycopy(vvdStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdStlAmtVOs = tmpVOs;
		}
	}


}