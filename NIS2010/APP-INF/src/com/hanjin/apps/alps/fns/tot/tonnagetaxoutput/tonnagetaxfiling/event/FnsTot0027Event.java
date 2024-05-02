/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsTot0027Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2010.012.23
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.012.23 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.FnsTot0027ConditionVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_TOT_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byoung Hun
 * @see FNS_TOT_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FnsTot0027ConditionVO fnsTot0027ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FnsTot0027ConditionVO[] fnsTot0027ConditionVOs = null;
	
	public FnsTot0027Event(){}

	/**
	 * @return the fnsTot0027ConditionVO
	 */
	public FnsTot0027ConditionVO getFnsTot0027ConditionVO() {
		return fnsTot0027ConditionVO;
	}

	/**
	 * @param fnsTot0027ConditionVO the fnsTot0027ConditionVO to set
	 */
	public void setFnsTot0027ConditionVO(FnsTot0027ConditionVO fnsTot0027ConditionVO) {
		this.fnsTot0027ConditionVO = fnsTot0027ConditionVO;
	}

	/**
	 * @return the fnsTot0027ConditionVOs
	 */
	public FnsTot0027ConditionVO[] getFnsTot0027ConditionVOs() {
		FnsTot0027ConditionVO[] rtnVOs = null;
		if (this.fnsTot0027ConditionVOs != null) {
			rtnVOs = new FnsTot0027ConditionVO[fnsTot0027ConditionVOs.length];
			System.arraycopy(fnsTot0027ConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param fnsTot0027ConditionVOs the fnsTot0027ConditionVOs to set
	 */
	public void setFnsTot0027ConditionVOs(FnsTot0027ConditionVO[] fnsTot0027ConditionVOs) {
		if (fnsTot0027ConditionVOs != null) {
			FnsTot0027ConditionVO[] tmpVOs = new FnsTot0027ConditionVO[fnsTot0027ConditionVOs.length];
			System.arraycopy(fnsTot0027ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fnsTot0027ConditionVOs = tmpVOs;
		}
	}
	
}