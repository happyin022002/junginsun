/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0001Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.LaneVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.syscommon.common.table.TotLaneVO;
import com.hanjin.syscommon.common.table.TotLaneTrdVO;
import com.hanjin.syscommon.common.table.TotVesselVO;
/**
 * FNS_TOT_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LaneVO laneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LaneVO[] laneVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotLaneVO totLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotLaneVO[] totLaneVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotLaneTrdVO totLaneTrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotLaneTrdVO[] totLaneTrdVOs = null;
	
	/** 최근 업데이트날짜 Data 처리 */
	private String recentDt = null;
	
	public FnsTot0004Event(){}

	public LaneVO getLaneVO() {
		return laneVO;
	}

	public void setLaneVO(LaneVO laneVO) {
		this.laneVO = laneVO;
	}

	public LaneVO[] getLaneVOs() {
		LaneVO[] rtnVOs = null;
		if (this.laneVOs != null) {
			rtnVOs = new LaneVO[laneVOs.length];
			System.arraycopy(laneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setLaneVOs(LaneVO[] laneVOs) {
		if (laneVOs != null) {
			LaneVO[] tmpVOs = new LaneVO[laneVOs.length];
			System.arraycopy(laneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.laneVOs = tmpVOs;
		}
	}

	public TotLaneVO getTotLaneVO() {
		return totLaneVO;
	}

	public void setTotLaneVO(TotLaneVO totLaneVO) {
		this.totLaneVO = totLaneVO;
	}

	public TotLaneVO[] getTotLaneVOs() {
		TotLaneVO[] rtnVOs = null;
		if (this.totLaneVOs != null) {
			rtnVOs = new TotLaneVO[totLaneVOs.length];
			System.arraycopy(totLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotLaneVOs(TotLaneVO[] totLaneVOs) {
		if (totLaneVOs != null) {
			TotLaneVO[] tmpVOs = new TotLaneVO[totLaneVOs.length];
			System.arraycopy(totLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totLaneVOs = tmpVOs;
		}
	}

	public TotLaneTrdVO getTotLaneTrdVO() {
		return totLaneTrdVO;
	}

	public void setTotLaneTrdVO(TotLaneTrdVO totLaneTrdVO) {
		this.totLaneTrdVO = totLaneTrdVO;
	}

	public TotLaneTrdVO[] getTotLaneTrdVOs() {
		TotLaneTrdVO[] rtnVOs = null;
		if (this.totLaneTrdVOs != null) {
			rtnVOs = new TotLaneTrdVO[totLaneTrdVOs.length];
			System.arraycopy(totLaneTrdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotLaneTrdVOs(TotLaneTrdVO[] totLaneTrdVOs) {
		if (totLaneTrdVOs != null) {
			TotLaneTrdVO[] tmpVOs = new TotLaneTrdVO[totLaneTrdVOs.length];
			System.arraycopy(totLaneTrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totLaneTrdVOs = tmpVOs;
		}
	}

	public String getRecentDt() {
		return recentDt;
	}

	public void setRecentDt(String recentDt) {
		this.recentDt = recentDt;
	}
	

}