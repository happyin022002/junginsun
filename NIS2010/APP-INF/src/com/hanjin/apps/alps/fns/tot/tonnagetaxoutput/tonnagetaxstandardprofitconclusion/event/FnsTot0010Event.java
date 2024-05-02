/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0010Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.08 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TotVesselVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;

/**
 * FNS_TOT_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaVO bsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaVO[] bsaVOs = null;
	
	public FnsTot0010Event(){}

	public BsaVO getBsaVO() {
		return bsaVO;
	}

	public void setBsaVO(BsaVO bsaVO) {
		this.bsaVO = bsaVO;
	}

	public BsaVO[] getBsaVOs() {
		BsaVO[] rtnVOs = null;
		if (this.bsaVOs != null) {
			rtnVOs = new BsaVO[bsaVOs.length];
			System.arraycopy(bsaVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBsaVOs(BsaVO[] bsaVOs) {
		if (bsaVOs != null) {
			BsaVO[] tmpVOs = new BsaVO[bsaVOs.length];
			System.arraycopy(bsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bsaVOs = tmpVOs;
		}
	}
}