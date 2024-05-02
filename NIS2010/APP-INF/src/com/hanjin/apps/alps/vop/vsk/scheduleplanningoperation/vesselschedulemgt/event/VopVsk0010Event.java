/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0010Event.java
*@FileTitle : Long Range SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.21 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;


/**
 * VOP_VSK-0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0010HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0010Event extends EventSupport {

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
	
	public VopVsk0010Event(){}

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