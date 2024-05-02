/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0016Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.29 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.FdrStlAmtVO;

/**
 * FNS_TOT_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FdrStlAmtVO fdrStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FdrStlAmtVO[] fdrStlAmtVOs = null;

	
	public FnsTot0016Event(){}


	public FdrStlAmtVO getFdrStlAmtVO() {
		return fdrStlAmtVO;
	}


	public void setFdrStlAmtVO(FdrStlAmtVO fdrStlAmtVO) {
		this.fdrStlAmtVO = fdrStlAmtVO;
	}


	public FdrStlAmtVO[] getFdrStlAmtVOs() {
		FdrStlAmtVO[] rtnVOs = null;
		if (this.fdrStlAmtVOs != null) {
			rtnVOs = new FdrStlAmtVO[fdrStlAmtVOs.length];
			System.arraycopy(fdrStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setFdrStlAmtVOs(FdrStlAmtVO[] fdrStlAmtVOs) {
		if (fdrStlAmtVOs != null) {
			FdrStlAmtVO[] tmpVOs = new FdrStlAmtVO[fdrStlAmtVOs.length];
			System.arraycopy(fdrStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fdrStlAmtVOs = tmpVOs;
		}
	}

	


}