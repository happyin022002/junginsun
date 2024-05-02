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
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
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

public class FnsTot0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslVO vslVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslVO[] vslVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotVesselVO totVesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotVesselVO[] totVesselVOs = null;

	/** 최근 업데이트날짜 Data 처리 */
	private String recentDt = null;
	
	public FnsTot0003Event(){}
	

	public void setVslVO(VslVO vslVO){
		this. vslVO = vslVO;
	}

	public void setVslVOS(VslVO[] vslVOs){
		if (vslVOs != null) {
			VslVO[] tmpVOs = new VslVO[vslVOs.length];
			System.arraycopy(vslVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslVOs = tmpVOs;
		}
	}

	public void setTotVesselVO(TotVesselVO totVesselVO){
		this. totVesselVO = totVesselVO;
	}

	public void setTotVesselVOS(TotVesselVO[] totVesselVOs){
		if (totVesselVOs != null) {
			TotVesselVO[] tmpVOs = new TotVesselVO[totVesselVOs.length];
			System.arraycopy(totVesselVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totVesselVOs = tmpVOs;
		}
	}

	public void setRecentDt(String recentDt){

		this. recentDt = recentDt;
	}
	
	public VslVO getVslVO(){
		return vslVO;
	}


	public VslVO[] getVslVOS(){
		VslVO[] rtnVOs = null;
		if (this.vslVOs != null) {
			rtnVOs = new VslVO[vslVOs.length];
			System.arraycopy(vslVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public TotVesselVO getTotVesselVO(){
		return totVesselVO;
	}

	public TotVesselVO[] getTotVesselVOS(){
		TotVesselVO[] rtnVOs = null;
		if (this.totVesselVOs != null) {
			rtnVOs = new TotVesselVO[totVesselVOs.length];
			System.arraycopy(totVesselVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getRecentDt(){
		return recentDt;
	}
}