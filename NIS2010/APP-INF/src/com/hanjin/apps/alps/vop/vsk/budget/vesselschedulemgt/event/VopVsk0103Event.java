/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0103Event.java
*@FileTitle : Budget L/R SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;


/**
 * VOP_VSK-0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_VSK_0103HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PfSkdVO pfSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PfSkdVO[] pfSkdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LongRangeSkdGRPVO longRangeSkdGRPVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LongRangeSkdGRPVO[] longRangeSkdGRPVOs = null;
	
	private VskVslSkdHisVO vskVslSkdHisVO = null;
	
	public VopVsk0103Event(){}

	public PfSkdVO getPfSkdVO() {
		return pfSkdVO;
	}

	public void setPfSkdVO(PfSkdVO pfSkdVO) {
		this.pfSkdVO = pfSkdVO;
	}

	public PfSkdVO[] getPfSkdVOs() {
		PfSkdVO[] rtnVOs =  null;
		if(this.pfSkdVOs != null){
			rtnVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return pfSkdVOs;
	}

	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs) {
		if(pfSkdVOs != null){
			PfSkdVO[] tmpVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.pfSkdVOs = pfSkdVOs;
	}

	public LongRangeSkdGRPVO getLongRangeSkdGRPVO() {
		return longRangeSkdGRPVO;
	}

	public void setLongRangeSkdGRPVO(LongRangeSkdGRPVO longRangeSkdGRPVO) {
		this.longRangeSkdGRPVO = longRangeSkdGRPVO;
	}

	public LongRangeSkdGRPVO[] getLongRangeSkdGRPVOs() {
		LongRangeSkdGRPVO[] rtnVOs =  null;
		if(this.longRangeSkdGRPVOs != null){
			rtnVOs = new LongRangeSkdGRPVO[longRangeSkdGRPVOs.length];
			System.arraycopy(longRangeSkdGRPVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return longRangeSkdGRPVOs;
	}

	public void setLongRangeSkdGRPVOs(LongRangeSkdGRPVO[] longRangeSkdGRPVOs) {
		if(longRangeSkdGRPVOs != null){
			LongRangeSkdGRPVO[] tmpVOs = new LongRangeSkdGRPVO[longRangeSkdGRPVOs.length];
			System.arraycopy(longRangeSkdGRPVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.longRangeSkdGRPVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.longRangeSkdGRPVOs = longRangeSkdGRPVOs;
	}
	
	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO){
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}
	
	public VskVslSkdHisVO getVskVslSkdHisVO(){
		return this.vskVslSkdHisVO;
	}
	
}