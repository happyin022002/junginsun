/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0008Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.syscommon.common.table.TotPndlmPortVO;
import com.hanjin.syscommon.common.table.TotVesselVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.PndlmPortVO;
/**
 * FNS_TOT_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PndlmPortVO pndlmPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PndlmPortVO[]pndlmPortVOs = null;

	/** Table Value Object Multi Data 처리 */
	private PndlmPortVO[] otherPndlmPortVOs = null;

	/** Input parameter 처리 */
	private TotCodeParamVO totCodeParamVO = null;

	/** 최근 업데이트날짜 Data 처리 */
	private String recentDt = null;
	
	public FnsTot0008Event(){}

	
	public TotCodeParamVO getTotCodeParamVO() {
		return totCodeParamVO;
	}

	public void setTotCodeParamVO(TotCodeParamVO totCodeParamVO) {
		this.totCodeParamVO = totCodeParamVO;
	}

	public String getRecentDt() {
		return recentDt; 
	}

	public void setRecentDt(String recentDt) {
		this.recentDt = recentDt;
	}

	public PndlmPortVO getPndlmPortVO() {
		return pndlmPortVO;
	}


	public void setPndlmPortVO(PndlmPortVO pndlmPortVO) {
		this.pndlmPortVO = pndlmPortVO;
	}


	public PndlmPortVO[] getPndlmPortVOs() {
		PndlmPortVO[] rtnVOs = null;
		if (this.pndlmPortVOs != null) {
			rtnVOs = new PndlmPortVO[pndlmPortVOs.length];
			System.arraycopy(pndlmPortVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setPndlmPortVOs(PndlmPortVO[] pndlmPortVOs) {
		if (pndlmPortVOs != null) {
			PndlmPortVO[] tmpVOs = new PndlmPortVO[pndlmPortVOs.length];
			System.arraycopy(pndlmPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pndlmPortVOs = tmpVOs;
		}
	}

	public PndlmPortVO[] getOtherPndlmPortVOs() {
		PndlmPortVO[] rtnVOs = null;
		if (this.otherPndlmPortVOs != null) {
			rtnVOs = new PndlmPortVO[otherPndlmPortVOs.length];
			System.arraycopy(otherPndlmPortVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setOtherPndlmPortVOs(PndlmPortVO[] otherPndlmPortVOs) {
		if (otherPndlmPortVOs != null) {
			PndlmPortVO[] tmpVOs = new PndlmPortVO[otherPndlmPortVOs.length];
			System.arraycopy(otherPndlmPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.otherPndlmPortVOs = tmpVOs;
		}
	}
}