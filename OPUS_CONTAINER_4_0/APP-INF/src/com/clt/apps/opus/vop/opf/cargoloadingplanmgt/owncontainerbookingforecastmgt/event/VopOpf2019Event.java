/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2019Event.java
*@FileTitle : CBF Summary Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.27 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * VOP_OPF_2019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see VOP_OPF_2019HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFSummaryVO cBFSummaryVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFSpecialStwgVO cbfSpecialStwgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFSummaryVO[] cBFSummaryVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CBFSpecialStwgVO[] cbfSpecialStwgVOs = null;

	public VopOpf2019Event(){}
	
	public void setCBFSummaryVO(CBFSummaryVO cBFSummaryVO){
		this. cBFSummaryVO = cBFSummaryVO;
	}

	public void setCBFSpecialStwgVO(CBFSpecialStwgVO cbfSpecialStwgVO){
		this. cbfSpecialStwgVO = cbfSpecialStwgVO;
	}

	public void setCBFSummaryVOS(CBFSummaryVO[] cBFSummaryVOs){
		if (cBFSummaryVOs != null) {
			CBFSummaryVO[] tmpVOs = Arrays.copyOf(cBFSummaryVOs, cBFSummaryVOs.length);
			this.cBFSummaryVOs = tmpVOs;
		} // end if
	}

	public void setCBFSpecialStwgVOS(CBFSpecialStwgVO[] cbfSpecialStwgVOs){
		if (cbfSpecialStwgVOs != null) {
			CBFSpecialStwgVO[] tmpVOs = Arrays.copyOf(cbfSpecialStwgVOs, cbfSpecialStwgVOs.length);
			this.cbfSpecialStwgVOs = tmpVOs;
		} // end if
	}

	public CBFSummaryVO getCBFSummaryVO(){
		return cBFSummaryVO;
	}

	public CBFSpecialStwgVO getCBFSpecialStwgVO(){
		return cbfSpecialStwgVO;
	}

	public CBFSummaryVO[] getCBFSummaryVOS(){
		CBFSummaryVO[] rtnVOs = null;
		if (this.cBFSummaryVOs != null) {
			rtnVOs = Arrays.copyOf(this.cBFSummaryVOs, this.cBFSummaryVOs.length);
		} // end if
		return rtnVOs;
	}

	public CBFSpecialStwgVO[] getCBFSpecialStwgVOS(){
		CBFSpecialStwgVO[] rtnVOs = null;
		if (this.cbfSpecialStwgVOs != null) {
			rtnVOs = Arrays.copyOf(this.cbfSpecialStwgVOs, this.cbfSpecialStwgVOs.length);
		} // end if
		return rtnVOs;
	}

}