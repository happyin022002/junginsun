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
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskCustEdiBlckVO;


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
		BlockLaneVO[] rtnVOs = null;
		if (this.blockLaneVOs != null) {
			rtnVOs = Arrays.copyOf(blockLaneVOs, blockLaneVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param blockLaneVOs the blockLaneVOs to set
	 */
	public void setBlockLaneVOs(BlockLaneVO[] blockLaneVOs) {
		if(blockLaneVOs != null){
			BlockLaneVO[] tmpVOs = Arrays.copyOf(blockLaneVOs, blockLaneVOs.length);
			this.blockLaneVOs = tmpVOs;
		}
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
		VskCustEdiBlckVO[] rtnVOs = null;
		if (this.vskCustEdiBlckVOs != null) {
			rtnVOs = Arrays.copyOf(vskCustEdiBlckVOs, vskCustEdiBlckVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param vskCustEdiBlckVOs the vskCustEdiBlckVOs to set
	 */
	public void setVskCustEdiBlckVOs(VskCustEdiBlckVO[] vskCustEdiBlckVOs) {
		if(vskCustEdiBlckVOs != null){
			VskCustEdiBlckVO[] tmpVOs = Arrays.copyOf(vskCustEdiBlckVOs, vskCustEdiBlckVOs.length);
			this.vskCustEdiBlckVOs = tmpVOs;
		}
	}
	 
}