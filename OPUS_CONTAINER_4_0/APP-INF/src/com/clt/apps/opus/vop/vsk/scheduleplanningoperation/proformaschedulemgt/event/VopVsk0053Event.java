/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0053Event.java
*@FileTitle : P/F SKD Creation (CCA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.01 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskPfSkdVO;


/**
 * VOP_VSK_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0053HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPfSkdVO vskPfSkdVO = null;
	private VskPfSkdDtlVO vskPfSkdDtlVO = null;
	private PfSkdRequestVO pfSkdRequestVO = null;
	private PfSkdGRPVO pfSkdGRPVO = null;
	private YardVO yardVO = null;
	private PfSkdVO pfSkdVO = null;
	private MdmVslSvcLaneVO mdmVslSvcLaneVO = null;
	private MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private VskPfSkdVO[] vskPfSkdVOs = null;
	private VskPfSkdDtlVO[] vskPfSkdDtlVOs = null;
	private PfSkdRequestVO[] pfSkdRequestVOs = null;
	private YardVO[] yardVOs = null;
	private PfSkdVO[] pfSkdVOs = null;
	private MdmVslSvcLaneVO[] mdmVslSvcLaneVOs = null;
	private MdmVslSvcLaneDirVO[] mdmVslSvcLaneDirVOs = null;

	public VopVsk0053Event(){}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this.vskPfSkdVO = vskPfSkdVO;
	}
	
	public void setVskPfSkdDtlVO(VskPfSkdDtlVO vskPfSkdDtlVO){
		this.vskPfSkdDtlVO = vskPfSkdDtlVO;
	}
	
	public void setPfSkdRequestVO(PfSkdRequestVO pfSkdRequestVO){
		this.pfSkdRequestVO = pfSkdRequestVO;
	}
	
	public void setPfSkdGRPVO(PfSkdGRPVO pfSkdGRPVO){
		this.pfSkdGRPVO = pfSkdGRPVO;
	}
	
	public void setYardVO(YardVO yardVO){
		this.yardVO = yardVO;
	}
	
	public void setPfSkdVO(PfSkdVO pfSkdVO) {
		this.pfSkdVO = pfSkdVO;
	}
	
	public void setMdmVslSvcLaneVO(MdmVslSvcLaneVO mdmVslSvcLaneVO) {
		this.mdmVslSvcLaneVO = mdmVslSvcLaneVO;
	}
	
	public void setMdmVslSvcLaneDirVO(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) {
		this.mdmVslSvcLaneDirVO = mdmVslSvcLaneDirVO;
	}

	public void setVskPfSkdVOS(VskPfSkdVO[] vskPfSkdVOs){
		if (vskPfSkdVOs != null) {
			VskPfSkdVO[] tmpVOs = Arrays.copyOf(vskPfSkdVOs, vskPfSkdVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		} // end if
	}
	
	public void setVskPfSkdDtlVOS(VskPfSkdDtlVO[] vskPfSkdDtlVOs){
		if (vskPfSkdDtlVOs != null) {
			VskPfSkdDtlVO[] tmpVOs = Arrays.copyOf(vskPfSkdDtlVOs, vskPfSkdDtlVOs.length);
			this.vskPfSkdDtlVOs = tmpVOs;
		} // end if
	}
	
	public void setPfSkdRequestVOS(PfSkdRequestVO[] pfSkdRequestVOs){
		if (pfSkdRequestVOs != null) {
			PfSkdRequestVO[] tmpVOs = Arrays.copyOf(pfSkdRequestVOs, pfSkdRequestVOs.length);
			this.pfSkdRequestVOs = tmpVOs;
		} // end if
	}
	
	public void setYardVOS(YardVO[] yardVOs){
		if (yardVOs != null) {
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		} // end if
	}
	
	public void setPfSkdVOs(PfSkdVO[] pfSkdVOs) {
		if (pfSkdVOs != null) {
			PfSkdVO[] tmpVOs = Arrays.copyOf(pfSkdVOs, pfSkdVOs.length);
			this.pfSkdVOs = tmpVOs;
		} // end if
	}
	
	public void setMdmVslSvcLaneVOs(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if (mdmVslSvcLaneVOs != null) {
			MdmVslSvcLaneVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneVOs, mdmVslSvcLaneVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		} // end if
	}
	
	public void setMdmVslSvcLaneDirVOs(MdmVslSvcLaneDirVO[] mdmVslSvcLaneDirVOs) {
		if (mdmVslSvcLaneDirVOs != null) {
			MdmVslSvcLaneDirVO[] tmpVOs = Arrays.copyOf(mdmVslSvcLaneDirVOs, mdmVslSvcLaneDirVOs.length);
			this.mdmVslSvcLaneDirVOs = tmpVOs;
		} // end if
	}

	public VskPfSkdVO getVskPfSkdVO(){
		return vskPfSkdVO;
	}
	
	public VskPfSkdDtlVO getVskPfSkdDtlVO(){
		return vskPfSkdDtlVO;
	}
	
	public PfSkdRequestVO getPfSkdRequestVO(){
		return pfSkdRequestVO;
	}
	
	public PfSkdGRPVO getPfSkdGRPVO(){
		return pfSkdGRPVO;
	}
	
	public YardVO getYardVO(){
		return yardVO;
	}
	
	public PfSkdVO getPfSkdVO() {
		return pfSkdVO;
	}
	
	public MdmVslSvcLaneVO getMdmVslSvcLaneVO() {
		return mdmVslSvcLaneVO;
	}
	
	public MdmVslSvcLaneDirVO getMdmVslSvcLaneDirVO() {
		return mdmVslSvcLaneDirVO;
	}

	public VskPfSkdVO[] getVskPfSkdVOS(){
		VskPfSkdVO[] rtnVOs = null;
		if (this.vskPfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPfSkdVOs, this.vskPfSkdVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public VskPfSkdDtlVO[] getVskPfSkdDtlVOS(){
		VskPfSkdDtlVO[] rtnVOs = null;
		if (this.vskPfSkdDtlVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPfSkdDtlVOs, this.vskPfSkdDtlVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public PfSkdRequestVO[] getPfSkdRequestVOS(){
		PfSkdRequestVO[] rtnVOs = null;
		if (this.pfSkdRequestVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdRequestVOs, this.pfSkdRequestVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public YardVO[] getYardVOS(){
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = Arrays.copyOf(this.yardVOs, this.yardVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public PfSkdVO[] getPfSkdVOs() {
		PfSkdVO[] rtnVOs = null;
		if (this.pfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdVOs, this.pfSkdVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOs() {
		MdmVslSvcLaneVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneVOs, this.mdmVslSvcLaneVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public MdmVslSvcLaneDirVO[] getMdmVslSvcLaneDirVOs() {
		MdmVslSvcLaneDirVO[] rtnVOs = null;
		if (this.mdmVslSvcLaneDirVOs != null) {
			rtnVOs = Arrays.copyOf(this.mdmVslSvcLaneDirVOs, this.mdmVslSvcLaneDirVOs.length);
		} // end if
		return rtnVOs;
	}

}