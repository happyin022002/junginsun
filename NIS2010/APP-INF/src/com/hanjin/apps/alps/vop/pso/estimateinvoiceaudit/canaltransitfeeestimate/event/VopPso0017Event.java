/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0017Event.java
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.29 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/**searchVendorList조회 사용 vo*/
	private MdmVendorVO mdmVendorVO = null;
	private VendorListVO vendorListVO = null;

	/**
	 * vendorListVO의 getter
	 * @return
	 */
	public VendorListVO getVendorListVO() {
		return vendorListVO;
	}
	
	/**
	 * vendorListVO의 setter
	 * @param vendorListVO
	 */
	public void setVendorListVO(VendorListVO vendorListVO) {
		// TODO Auto-generated method stub
		this.vendorListVO = vendorListVO;
	}

	/*canal invoice 조회 조건 사용 vo*/
	private CanalTzFeeSumVO canalTzFeeSumVO = null;

	

	public VopPso0017Event(){}
	
	public void setPsoMsaVO(PsoMsaVO psoMsaVO){
		this. psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs){
		if (psoMsaVOs != null) {
			PsoMsaVO[] tmpVOs = new PsoMsaVO[psoMsaVOs .length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. psoMsaVOs = tmpVOs;
		}
	}
	
	public PsoMsaVO getPsoMsaVO(){
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS(){
		PsoMsaVO[] tmpVOs = null;
		if (this. psoMsaVOs != null) {
			tmpVOs = new PsoMsaVO[psoMsaVOs .length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param vo
	 */
	public void setMdmVendorVO(MdmVendorVO vo) {
		// TODO Auto-generated method stub
		this.mdmVendorVO = vo;
	}
	/**
	 * @param vo
	 */
	public MdmVendorVO getMdmVendorVO() {
		// TODO Auto-generated method stub
		return this.mdmVendorVO;
	}

	/**
	 * Canal Invoice List를 조회하기 위한 조건 vo의 setter
	 * @param vo
	 */
	public void setCanalTzFeeSumVO(CanalTzFeeSumVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeSumVO = vo;
	}

	/**
	 * Canal Invoice List를 조회하기 위한 조건 vo의 getter
	 * @return
	 */
	public CanalTzFeeSumVO getCanalTzFeeSumVO() {
		// TODO Auto-generated method stub
		return this.canalTzFeeSumVO;
	}

	

	

}