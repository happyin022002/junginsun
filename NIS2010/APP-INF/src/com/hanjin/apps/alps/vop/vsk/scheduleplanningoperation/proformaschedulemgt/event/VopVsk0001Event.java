/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0001Event.java
*@FileTitle : P/F SKD Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.06.09 서창열
* 1.0 Creation
* 
* History
* 2015.08.10 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdRequestVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskPfSkdVO;


/**
 * VOP_VSK_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0001HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPfSkdVO vskPfSkdVO = null;
	private VskPfSkdDtlVO vskPfSkdDtlVO = null;
	private PfSkdRequestVO pfSkdRequestVO = null;
	private PfSkdGRPVO pfSkdGRPVO = null;
	private YardVO yardVO = null;
	private PfSkdVO pfSkdVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private VskPfSkdVO[] vskPfSkdVOs = null;
	private VskPfSkdDtlVO[] vskPfSkdDtlVOs = null;
	private PfSkdRequestVO[] pfSkdRequestVOs = null;
	private YardVO[] yardVOs = null;
	private PfSkdVO[] pfSkdVOs = null;

	public VopVsk0001Event(){}
	
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
	
	public void setPfSkdVO(PfSkdVO pfSkdVO){
		this.pfSkdVO = pfSkdVO;
	}

	public void setVskPfSkdVOS(VskPfSkdVO[] vskPfSkdVOs){
//		this.vskPfSkdVOs = vskPfSkdVOs;
		if (vskPfSkdVOs != null) {
			VskPfSkdVO[] tmpVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdVOs = tmpVOs;
		}
	}
	
	public void setVskPfSkdDtlVOS(VskPfSkdDtlVO[] vskPfSkdDtlVOs){
//		this.vskPfSkdDtlVOs = vskPfSkdDtlVOs;
		if (vskPfSkdDtlVOs != null) {
			VskPfSkdDtlVO[] tmpVOs = new VskPfSkdDtlVO[vskPfSkdDtlVOs.length];
			System.arraycopy(vskPfSkdDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdDtlVOs = tmpVOs;
		}
	}
	
	public void setPfSkdRequestVOS(PfSkdRequestVO[] pfSkdRequestVOs){
//		this.pfSkdRequestVOs = pfSkdRequestVOs;
		if (pfSkdRequestVOs != null) {
			PfSkdRequestVO[] tmpVOs = new PfSkdRequestVO[pfSkdRequestVOs.length];
			System.arraycopy(pfSkdRequestVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdRequestVOs = tmpVOs;
		}
	}
	
	public void setYardVOS(YardVO[] yardVOs){
//		this.yardVOs = yardVOs;
		if (yardVOs != null) {
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
	}
	
	public void setPfSkdVOS(PfSkdVO[] pfSkdVOs){
//		this.pfSkdVOs = pfSkdVOs;
		if (pfSkdVOs != null) {
			PfSkdVO[] tmpVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfSkdVOs = tmpVOs;
		}
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
	
	public PfSkdVO getPfSkdVO(){
		return pfSkdVO;
	}

	public VskPfSkdVO[] getVskPfSkdVOS(){
//		return vskPfSkdVOs;
		VskPfSkdVO[] rtnVOs = null;
		if (this.vskPfSkdVOs != null) {
			rtnVOs = new VskPfSkdVO[vskPfSkdVOs.length];
			System.arraycopy(vskPfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public VskPfSkdDtlVO[] getVskPfSkdDtlVOS(){
//		return vskPfSkdDtlVOs;
		VskPfSkdDtlVO[] rtnVOs = null;
		if (this.vskPfSkdDtlVOs != null) {
			rtnVOs = new VskPfSkdDtlVO[vskPfSkdDtlVOs.length];
			System.arraycopy(vskPfSkdDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PfSkdRequestVO[] getPfSkdRequestVOS(){
//		return pfSkdRequestVOs;
		PfSkdRequestVO[] rtnVOs = null;
		if (this.pfSkdRequestVOs != null) {
			rtnVOs = new PfSkdRequestVO[pfSkdRequestVOs.length];
			System.arraycopy(pfSkdRequestVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public YardVO[] getYardVOS(){
//		return yardVOs;
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public PfSkdVO[] getPfSkdVOS(){
//		return pfSkdVOs;
		PfSkdVO[] rtnVOs = null;
		if (this.pfSkdVOs != null) {
			rtnVOs = new PfSkdVO[pfSkdVOs.length];
			System.arraycopy(pfSkdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}