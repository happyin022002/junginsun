/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0019Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.10 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TotStlCfmVO;

/**
 * FNS_TOT_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotStlCfmVO totStlCfmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotStlCfmVO[] totStlCfmVOs = null;
	
	public FnsTot0019Event(){}

	public TotStlCfmVO getTotStlCfmVO() {
		return totStlCfmVO;
	}

	public void setTotStlCfmVO(TotStlCfmVO totStlCfmVO) {
		this.totStlCfmVO = totStlCfmVO;
	}

	public TotStlCfmVO[] getTotStlCfmVOs() {
		TotStlCfmVO[] rtnVOs = null;
		if (this.totStlCfmVOs != null) {
			rtnVOs = new TotStlCfmVO[totStlCfmVOs.length];
			System.arraycopy(totStlCfmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotStlCfmVOs(TotStlCfmVO[] totStlCfmVOs) {
		if (totStlCfmVOs != null) {
			TotStlCfmVO[] tmpVOs = new TotStlCfmVO[totStlCfmVOs.length];
			System.arraycopy(totStlCfmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totStlCfmVOs = tmpVOs;
		}
	}


}