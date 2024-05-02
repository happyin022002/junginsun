/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0124Event.java
*@FileTitle : Bottleneck Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.10.21 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskCustEdiBlckVO;


/**
 * ESM_SAQ_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SAQ_0034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSce0124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlockLaneVO blockLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BlockLaneVO[] blockLaneVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskCustEdiBlckVO vskCustEdiBlckVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskCustEdiBlckVO[] vskCustEdiBlckVOs = null;

	public EsdSce0124Event(){}

	/**
	 * @return the blockLaneVO
	 */
	public BlockLaneVO getBlockLaneVO() {
		return blockLaneVO;
	}

	/**
	 * @param blockLaneVO the blockLaneVO to set
	 */
	public void setBlockLaneVO(BlockLaneVO blockLaneVO) {
		this.blockLaneVO = blockLaneVO;
	}

	/**
	 * @return the blockLaneVOs
	 */
	public BlockLaneVO[] getBlockLaneVOs() {
		return blockLaneVOs;
	}

	/**
	 * @param blockLaneVOs the blockLaneVOs to set
	 */
	public void setBlockLaneVOs(
			BlockLaneVO[] blockLaneVOs) {
		this.blockLaneVOs = blockLaneVOs;
	}

	/**
	 * @return the vskCustEdiBlckVO
	 */
	public VskCustEdiBlckVO getVskCustEdiBlckVO() {
		return vskCustEdiBlckVO;
	}

	/**
	 * @param vskCustEdiBlckVO the vskCustEdiBlckVO to set
	 */
	public void setVskCustEdiBlckVO(VskCustEdiBlckVO vskCustEdiBlckVO) {
		this.vskCustEdiBlckVO = vskCustEdiBlckVO;
	}

	/**
	 * @return the vskCustEdiBlckVOs
	 */
	public VskCustEdiBlckVO[] getVskCustEdiBlckVOs() {
		return vskCustEdiBlckVOs;
	}

	/**
	 * @param vskCustEdiBlckVOs the vskCustEdiBlckVOs to set
	 */
	public void setVskCustEdiBlckVOs(VskCustEdiBlckVO[] vskCustEdiBlckVOs) {
		this.vskCustEdiBlckVOs = vskCustEdiBlckVOs;
	}
	 
}