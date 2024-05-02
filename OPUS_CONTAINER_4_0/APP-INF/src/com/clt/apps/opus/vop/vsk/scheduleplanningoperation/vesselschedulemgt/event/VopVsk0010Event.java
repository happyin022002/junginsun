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
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;


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
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	
	public VopVsk0010Event(){}

	public PfSkdVO getPfSkdVO() {
		return pfSkdVO;
	}

	public void setPfSkdVO(PfSkdVO pfSkdVO) {
		this.pfSkdVO = pfSkdVO;
	}

	public PfSkdVO[] getPfSkdVOs() {
		PfSkdVO[] rtnVOs = null;
		if (this.pfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdVOs, this.pfSkdVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs) {
		if (pfSkdVOs != null) {
			PfSkdVO[] tmpVOs = Arrays.copyOf(pfSkdVOs, pfSkdVOs.length);
			this.pfSkdVOs = tmpVOs;
		} // end if
	}

	public LongRangeSkdGRPVO getLongRangeSkdGRPVO() {
		return longRangeSkdGRPVO;
	}

	public void setLongRangeSkdGRPVO(LongRangeSkdGRPVO longRangeSkdGRPVO) {
		this.longRangeSkdGRPVO = longRangeSkdGRPVO;
	}

	public LongRangeSkdGRPVO[] getLongRangeSkdGRPVOs() {
		LongRangeSkdGRPVO[] rtnVOs = null;
		if (this.longRangeSkdGRPVOs != null) {
			rtnVOs = Arrays.copyOf(this.longRangeSkdGRPVOs, this.longRangeSkdGRPVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setLongRangeSkdGRPVOs(LongRangeSkdGRPVO[] longRangeSkdGRPVOs) {
		if (longRangeSkdGRPVOs != null) {
			LongRangeSkdGRPVO[] tmpVOs = Arrays.copyOf(longRangeSkdGRPVOs, longRangeSkdGRPVOs.length);
			this.longRangeSkdGRPVOs = tmpVOs;
		} // end if
	}
	
	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO){
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}
	
	public VskVslSkdHisVO getVskVslSkdHisVO(){
		return this.vskVslSkdHisVO;
	}
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	public void setMdmVslSvcLaneVOs(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		} // end if
	}
	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOs() {
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneVOs, this.mdmVslSvcLaneVOs.length);
		} // end if
		return rtnVOs;
	}
	
}