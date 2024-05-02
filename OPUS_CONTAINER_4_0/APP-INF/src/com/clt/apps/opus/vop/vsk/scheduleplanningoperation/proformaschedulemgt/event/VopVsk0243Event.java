/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0243Event.java
*@FileTitle : EOTP 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.05 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPfSkdVO;


/**
 * VOP_VSK_0243 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0243HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0243HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0243Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPfSkdVO vskPfSkdVO = null;
	private VskPfSkdDtlVO vskPfSkdDtlVO = null;
	private PfSkdGRPVO pfSkdGRPVO = null;
	private PfSkdEotpDtlVO pfSkdEotpDetailVO = null;
	private PfSkdEotpSumVO pfSkdEotpSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPfSkdVO[] vskPfSkdVOs = null;
	private VskPfSkdDtlVO[] vskPfSkdDtlVOs = null;
	private PfSkdEotpDtlVO[] pfSkdEotpDetailVOs = null;
	private PfSkdEotpSumVO[] pfSkdEotpSummaryVOs = null;

	public VopVsk0243Event(){}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this. vskPfSkdVO = vskPfSkdVO;
	}

	public void setVskPfSkdVOs(VskPfSkdVO[] vskPfSkdVOs){
		if (vskPfSkdVOs != null) {
			VskPfSkdVO[] tmpVOs = Arrays.copyOf(vskPfSkdVOs, vskPfSkdVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		} // end if
	}
	
	public void setVskPfSkdDtlVO(VskPfSkdDtlVO vskPfSkdDtlVO){
		this. vskPfSkdDtlVO = vskPfSkdDtlVO;
	}

	public void setVskPfSkdDtlVOs(VskPfSkdDtlVO[] vskPfSkdDtlVOs){
		if (vskPfSkdDtlVOs != null) {
			VskPfSkdDtlVO[] tmpVOs = Arrays.copyOf(vskPfSkdDtlVOs, vskPfSkdDtlVOs.length);
			this.vskPfSkdDtlVOs = tmpVOs;
		} // end if
	}
	
	public void setPfSkdEotpDetailVO(PfSkdEotpDtlVO pfSkdEotpDetailVO){
		this. pfSkdEotpDetailVO = pfSkdEotpDetailVO;
	}

	public void setPfSkdEotpDetailVOs(PfSkdEotpDtlVO[] pfSkdEotpDetailVOs){
		if (pfSkdEotpDetailVOs != null) {
			PfSkdEotpDtlVO[] tmpVOs = Arrays.copyOf(pfSkdEotpDetailVOs, pfSkdEotpDetailVOs.length);
			this.pfSkdEotpDetailVOs = tmpVOs;
		} // end if
	}
	
	public void setPfSkdEotpSummaryVO(PfSkdEotpSumVO pfSkdEotpSummaryVO){
		this. pfSkdEotpSummaryVO = pfSkdEotpSummaryVO;
	}

	public void setPfSkdEotpSummaryVOs(PfSkdEotpSumVO[] pfSkdEotpSummaryVOs){
		if (pfSkdEotpSummaryVOs != null) {
			PfSkdEotpSumVO[] tmpVOs = Arrays.copyOf(pfSkdEotpSummaryVOs, pfSkdEotpSummaryVOs.length);
			this.pfSkdEotpSummaryVOs = tmpVOs;
		} // end if
	}
	
	public void setPfSkdGRPVO(PfSkdGRPVO pfSkdGRPVO){
		this.pfSkdGRPVO = pfSkdGRPVO;
	}

	public VskPfSkdVO getVskPfSkdVO(){
		return vskPfSkdVO;
	}

	public VskPfSkdVO[] getVskPfSkdVOs(){
		VskPfSkdVO[] rtnVOs = null;
		if (this.vskPfSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPfSkdVOs, this.vskPfSkdVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public VskPfSkdDtlVO getVskPfSkdDtlVO(){
		return vskPfSkdDtlVO;
	}

	public VskPfSkdDtlVO[] getVskPfSkdDtlVOs(){
		VskPfSkdDtlVO[] rtnVOs = null;
		if (this.vskPfSkdDtlVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPfSkdDtlVOs, this.vskPfSkdDtlVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public PfSkdEotpDtlVO getPfSkdEotpDetailVO(){
		return pfSkdEotpDetailVO;
	}

	public PfSkdEotpDtlVO[] getPfSkdEotpDetailVOs(){
		PfSkdEotpDtlVO[] rtnVOs = null;
		if (this.pfSkdEotpDetailVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdEotpDetailVOs, this.pfSkdEotpDetailVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public PfSkdEotpSumVO getPfSkdEotpSummaryVO(){
		return pfSkdEotpSummaryVO;
	}

	public PfSkdEotpSumVO[] getPfSkdEotpSummaryVOs(){
		PfSkdEotpSumVO[] rtnVOs = null;
		if (this.pfSkdEotpSummaryVOs != null) {
			rtnVOs = Arrays.copyOf(this.pfSkdEotpSummaryVOs, this.pfSkdEotpSummaryVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public PfSkdGRPVO getPfSkdGRPVO(){
		return pfSkdGRPVO;
	}

}