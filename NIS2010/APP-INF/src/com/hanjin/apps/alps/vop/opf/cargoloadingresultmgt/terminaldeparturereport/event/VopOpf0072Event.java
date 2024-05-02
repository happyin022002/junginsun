/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0072Event.java
*@FileTitle : VNOR Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfAtchFileVO;

/**
 *  VOP_OPF_0072에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이병훈
 * @see VOP_OPF_0072HTMLAction 참조 
 * @since J2EE 1.6
 */
public class VopOpf0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfAtchFileVO opfAtchFileVO = null;

	/** Table Value Object Multi Data 처리 */
	private OpfAtchFileVO[] opfAtchFileVOs = null;
	
	private String vslCd = null;
	
	private String vnorSeq = null;
	
	private String vnorItmSeq = null;
	
	private String atchFileLnkId = null;

	public VopOpf0072Event(){}
	
	public OpfAtchFileVO getOpfAtchFileVO(){
		return opfAtchFileVO;
	}
	
	public OpfAtchFileVO[] getOpfAtchFileVOs() {
		OpfAtchFileVO[] rtnVOs = null;
		if (this.opfAtchFileVOs != null) {
			rtnVOs = new OpfAtchFileVO[opfAtchFileVOs.length];
			System.arraycopy(opfAtchFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public String getVslCd(){
		return vslCd;
	}
	
	public String getVnorSeq(){
		return vnorSeq;
	}
	
	public String getVnorItmSeq(){
		return vnorItmSeq;
	}
	
	public String getAtchFileLnkId(){
		return atchFileLnkId;
	}
	
	public void setOpfAtchFileVO(OpfAtchFileVO opfAtchFileVO){
		this.opfAtchFileVO = opfAtchFileVO;
	}
	
	public void setOpfAtchFileVOs(OpfAtchFileVO[] opfAtchFileVOs) {
		if (opfAtchFileVOs != null) {
			OpfAtchFileVO[] tmpVOs = new OpfAtchFileVO[opfAtchFileVOs.length];
			System.arraycopy(opfAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfAtchFileVOs = tmpVOs;
		}
	}
	
	public void setVslCd(String vslCd){
		this.vslCd = vslCd;
	}
	
	public void setVnorSeq(String vnorSeq){
		this.vnorSeq = vnorSeq;
	}
	
	public void setVnorItmSeq(String vnorItmSeq){
		this.vnorItmSeq = vnorItmSeq;
	}
	
	public void setAtchFileLnkId(String atchFileLnkId){
		this.atchFileLnkId = atchFileLnkId;
	}
	
}
