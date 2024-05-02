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
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;


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
		if(vskPfSkdVOs != null){
			VskPfSkdVO[] tmpVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vskPfSkdVOs = vskPfSkdVOs;
	}
	
	public void setVskPfSkdDtlVOS(VskPfSkdDtlVO[] vskPfSkdDtlVOs){
		if(vskPfSkdDtlVOs != null){
			VskPfSkdDtlVO[] tmpVOs = new VskPfSkdDtlVO[vskPfSkdDtlVOs.length];
			System.arraycopy(vskPfSkdDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdDtlVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vskPfSkdDtlVOs = vskPfSkdDtlVOs;
	}
	
	public void setPfSkdRequestVOS(PfSkdRequestVO[] pfSkdRequestVOs){
		if(pfSkdRequestVOs != null){
			PfSkdRequestVO[] tmpVOs = new PfSkdRequestVO[pfSkdRequestVOs.length];
			System.arraycopy(pfSkdRequestVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdRequestVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.pfSkdRequestVOs = pfSkdRequestVOs;
	}
	
	public void setYardVOS(YardVO[] yardVOs){
		if(yardVOs != null){
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.yardVOs = yardVOs;
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
	
	public void setMdmVslSvcLaneVOs(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs) {
		if(mdmVslSvcLaneVOs != null){
			MdmVslSvcLaneVO[] tmpVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.mdmVslSvcLaneVOs = mdmVslSvcLaneVOs;
	}
	
	public void setMdmVslSvcLaneDirVOs(MdmVslSvcLaneDirVO[] mdmVslSvcLaneDirVOs) {
		if(mdmVslSvcLaneDirVOs != null){
			MdmVslSvcLaneDirVO[] tmpVOs = new MdmVslSvcLaneDirVO[mdmVslSvcLaneDirVOs.length];
			System.arraycopy(mdmVslSvcLaneDirVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmVslSvcLaneDirVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.mdmVslSvcLaneDirVOs = mdmVslSvcLaneDirVOs;
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
		VskPfSkdVO[] rtnVOs =  null;
		if(this.vskPfSkdVOs != null){
			rtnVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskPfSkdVOs;
	}
	
	public VskPfSkdDtlVO[] getVskPfSkdDtlVOS(){
		VskPfSkdDtlVO[] rtnVOs =  null;
		if(this.vskPfSkdDtlVOs != null){
			rtnVOs = new VskPfSkdDtlVO[vskPfSkdDtlVOs.length];
			System.arraycopy(vskPfSkdDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskPfSkdDtlVOs;
	}
	
	public PfSkdRequestVO[] getPfSkdRequestVOS(){
		PfSkdRequestVO[] rtnVOs =  null;
		if(this.pfSkdRequestVOs != null){
			rtnVOs = new PfSkdRequestVO[pfSkdRequestVOs.length];
			System.arraycopy(pfSkdRequestVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return pfSkdRequestVOs;
	}
	
	public YardVO[] getYardVOS(){
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return yardVOs;
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
	
	public MdmVslSvcLaneVO[] getMdmVslSvcLaneVOs() {
		MdmVslSvcLaneVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneVOs != null){
			rtnVOs = new MdmVslSvcLaneVO[mdmVslSvcLaneVOs.length];
			System.arraycopy(mdmVslSvcLaneVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return mdmVslSvcLaneVOs;
	}
	
	public MdmVslSvcLaneDirVO[] getMdmVslSvcLaneDirVOs() {
		MdmVslSvcLaneDirVO[] rtnVOs =  null;
		if(this.mdmVslSvcLaneDirVOs != null){
			rtnVOs = new MdmVslSvcLaneDirVO[mdmVslSvcLaneDirVOs.length];
			System.arraycopy(mdmVslSvcLaneDirVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return mdmVslSvcLaneDirVOs;
	}

}