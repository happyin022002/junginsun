/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmMas0162Event.java
*@FileTitle : Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-22
*@LastModifier : Young-Heon Lee
*@LastVersion : 
*  2016-06-22 Young-Heon Lee
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.RevenueDetailCondVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.RevenueDetailVO;


/**
 * ESM_MAS_0162 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0162HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Young-Heon Lee
 * @see ESM_MAS_0162HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0162Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RevenueDetailVO revenueDetailVO = null;
	private RevenueDetailCondVO revenueDetailCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private RevenueDetailVO[] revenueDetailVOs = null;
	private RevenueDetailCondVO[] revenueDetailCondVOs = null;
	
	public EsmMas0162Event(){}

	public void setRevenueDetailVO(RevenueDetailVO revenueDetailVO){
		this. revenueDetailVO = revenueDetailVO;
	}

	public void setRevenueDetailVOS(RevenueDetailVO[] revenueDetailVOs){
		if(revenueDetailVOs != null){
			RevenueDetailVO[] tmpVOs = new RevenueDetailVO[revenueDetailVOs.length];
			System.arraycopy(revenueDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.revenueDetailVOs = tmpVOs;
		}
	}

	public RevenueDetailVO getRevenueDetailVO(){
		return revenueDetailVO;
	}

	public RevenueDetailVO[] getRevenueDetailVOS(){
		RevenueDetailVO[] rtnVOs = null;
		if (this.revenueDetailVOs != null) {
			rtnVOs = new RevenueDetailVO[revenueDetailVOs.length];
			System.arraycopy(revenueDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setRevenueDetailCondVO(RevenueDetailCondVO revenueDetailCondVO){
		this. revenueDetailCondVO = revenueDetailCondVO;
	}

	public void setRevenueDetailCondVOS(RevenueDetailCondVO[] revenueDetailCondVOs){
		if(revenueDetailCondVOs != null){
			RevenueDetailCondVO[] tmpVOs = new RevenueDetailCondVO[revenueDetailCondVOs.length];
			System.arraycopy(revenueDetailCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.revenueDetailCondVOs = tmpVOs;
		}
	}

	public RevenueDetailCondVO getRevenueDetailCondVO(){
		return revenueDetailCondVO;
	}

	public RevenueDetailCondVO[] getRevenueDetailCondVOS(){
		RevenueDetailCondVO[] rtnVOs = null;
		if (this.revenueDetailCondVOs != null) {
			rtnVOs = new RevenueDetailCondVO[revenueDetailCondVOs.length];
			System.arraycopy(revenueDetailCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
}