/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0071Event.java
*@FileTitle : Vessel Not Operationally Ready Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;

/**
 *  VOP_OPF_0071에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이병훈
 * @see VOP_OPF_0071HTMLAction 참조 
 * @since J2EE 1.6
 */
public class VopOpf0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfVnorVO opfVnorVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComComboVO comComboVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfVnorItmVO opfVnorItmVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FmsVnorVO fmsVnorVO = null;

	/** Table Value Object Multi Data 처리 */
	private OpfVnorVO[] opfVnorVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComComboVO[] comComboVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfVnorItmVO[] opfVnorItmVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private FmsVnorItmVO[] fmsVnorItmVOs = null;
	
	private String ofcCd = null;
	

	public VopOpf0071Event(){}
	
	public OpfVnorVO getOpfVnorVO(){
		return opfVnorVO;
	}
	
	public ComComboVO getComComboVO(){
		return comComboVO;
	}
	
	public OpfVnorItmVO getOpfVnorItmVO(){
		return opfVnorItmVO;
	}
	
	public FmsVnorVO getFmsVnorVO(){
		return fmsVnorVO;
	}
	
	public OpfVnorVO[] getOpfVnorVOs() {
		OpfVnorVO[] rtnVOs = null;
		if (this.opfVnorVOs != null) {
			rtnVOs = new OpfVnorVO[opfVnorVOs.length];
			System.arraycopy(opfVnorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public ComComboVO[] getComComboVOs() {
		ComComboVO[] rtnVOs = null;
		if (this.comComboVOs != null) {
			rtnVOs = new ComComboVO[comComboVOs.length];
			System.arraycopy(comComboVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public OpfVnorItmVO[] getOpfVnorItmVOs() {
		OpfVnorItmVO[] rtnVOs = null;
		if (this.opfVnorItmVOs != null) {
			rtnVOs = new OpfVnorItmVO[opfVnorItmVOs.length];
			System.arraycopy(opfVnorItmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public FmsVnorItmVO[] getFmsVnorItmVOs() {
		FmsVnorItmVO[] rtnVOs = null;
		if (this.fmsVnorItmVOs != null) {
			rtnVOs = new FmsVnorItmVO[fmsVnorItmVOs.length];
			System.arraycopy(fmsVnorItmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}

	public void setFmsVnorVO(FmsVnorVO fmsVnorVO){
		this.fmsVnorVO = fmsVnorVO;
	}
	
	public void setOpfVnorVO(OpfVnorVO opfVnorVO){
		this.opfVnorVO = opfVnorVO;
	}
	
	public void setComComboVO(ComComboVO comComboVO){
		this.comComboVO = comComboVO;
	}
	
	public void setOpfVnorItmVO(OpfVnorItmVO opfVnorItmVO){
		this.opfVnorItmVO = opfVnorItmVO;
	}
	
	public void setOpfVnorVOs(OpfVnorVO[] opfVnorVOs) {
		if (opfVnorVOs != null) {
			OpfVnorVO[] tmpVOs = new OpfVnorVO[opfVnorVOs.length];
			System.arraycopy(opfVnorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfVnorVOs = tmpVOs;
		}
	}
	
	public void setComComboVOs(ComComboVO[] comComboVOs) {
		if (comComboVOs != null) {
			ComComboVO[] tmpVOs = new ComComboVO[comComboVOs.length];
			System.arraycopy(comComboVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comComboVOs = tmpVOs;
		}
	}
	
	public void setOpfVnorItmVOs(OpfVnorItmVO[] opfVnorItmVOs) {
		if (opfVnorItmVOs != null) {
			OpfVnorItmVO[] tmpVOs = new OpfVnorItmVO[opfVnorItmVOs.length];
			System.arraycopy(opfVnorItmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfVnorItmVOs = tmpVOs;
		}
	}
	
	public void setFmsVnorItmVOs(FmsVnorItmVO[] fmsVnorItmVOs) {
		if (fmsVnorItmVOs != null) {
			FmsVnorItmVO[] tmpVOs = new FmsVnorItmVO[fmsVnorItmVOs.length];
			System.arraycopy(fmsVnorItmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fmsVnorItmVOs = tmpVOs;
		}
	}
	
	public void setOfcCd(String ofcCd){
		this.ofcCd = ofcCd;
	}

}
