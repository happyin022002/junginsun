/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0006Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.04 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.syscommon.common.table.TotBsaVO;
import com.hanjin.syscommon.common.table.TotVesselVO;

/**
 * FNS_TOT_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaVO bsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaVO[] bsaVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotBsaVO totBsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotBsaVO[] totBsaVOs = null;

	/** 최근 업데이트날짜 Data 처리 */
	private String recentDt = null;
	
	
	public FnsTot0006Event(){}

	
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



	public TotBsaVO getTotBsaVO() {
		return totBsaVO;
	}



	public void setTotBsaVO(TotBsaVO totBsaVO) {
		this.totBsaVO = totBsaVO;
	}



	public TotBsaVO[] getTotBsaVOs() {
		TotBsaVO[] rtnVOs = null;
		if (this.totBsaVOs != null) {
			rtnVOs = new TotBsaVO[totBsaVOs.length];
			System.arraycopy(totBsaVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}



	public void setTotBsaVOs(TotBsaVO[] totBsaVOs) {
		if (totBsaVOs != null) {
			TotBsaVO[] tmpVOs = new TotBsaVO[totBsaVOs.length];
			System.arraycopy(totBsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totBsaVOs = tmpVOs;
		}
	}


	public String getRecentDt() {
		return recentDt; 
	}

	public void setRecentDt(String recentDt) {
		this.recentDt = recentDt;
	}

}