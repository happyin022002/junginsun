/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0079Event.java
*@FileTitle : Authority Office Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.event;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.AuthorityCarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0079HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AuthorityCarrierVO authorityCarrierVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AuthorityCarrierVO[] authorityCarrierVOs = null;
	
	private MstConditionVO mstConditionVO = null;

	public FnsJoo0090Event(){}
	
	public void setAuthorityCarrierVO(AuthorityCarrierVO authorityCarrierVO){
		this. authorityCarrierVO = authorityCarrierVO;
	}

	public void setAuthorityCarrierVOS(AuthorityCarrierVO[] authorityCarrierVOs){
		if (authorityCarrierVOs != null) {
			AuthorityCarrierVO[] tmpVOs = new AuthorityCarrierVO[authorityCarrierVOs.length];
			System.arraycopy(authorityCarrierVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.authorityCarrierVOs = tmpVOs;
		}
	}

	public AuthorityCarrierVO getAuthorityCarrierVO(){
		return authorityCarrierVO;
	}

	public AuthorityCarrierVO[] getAuthorityCarrierVOS(){
		AuthorityCarrierVO[] tmpVOs = null;
		if (this.authorityCarrierVOs != null) {
			tmpVOs = new AuthorityCarrierVO[authorityCarrierVOs.length];
			System.arraycopy(authorityCarrierVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setMstConditionVO(MstConditionVO mstConditionVO){
		this.mstConditionVO = mstConditionVO;
	}
	
	public MstConditionVO getMstConditionVO(){
		return mstConditionVO;
	}

}