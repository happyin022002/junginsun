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
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
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

public class FnsJoo0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AuthorityOfficeVO authorityOfficeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AuthorityOfficeVO[] authorityOfficeVOs = null;

	public FnsJoo0079Event(){}
	
	public void setAuthorityOfficeVO(AuthorityOfficeVO authorityOfficeVO){
		this. authorityOfficeVO = authorityOfficeVO;
	}

	public void setAuthorityOfficeVOs(AuthorityOfficeVO[] authorityOfficeVOs){
		if (authorityOfficeVOs != null) {
			AuthorityOfficeVO[] tmpVOs = new AuthorityOfficeVO[authorityOfficeVOs.length];
			System.arraycopy(authorityOfficeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.authorityOfficeVOs = tmpVOs;
		}
	}

	public AuthorityOfficeVO getAuthorityOfficeVO(){
		return authorityOfficeVO;
	}

	public AuthorityOfficeVO[] getAuthorityOfficeVOs(){
		AuthorityOfficeVO[] tmpVOs = null;
		if (this.authorityOfficeVOs != null) {
			tmpVOs = new AuthorityOfficeVO[authorityOfficeVOs.length];
			System.arraycopy(authorityOfficeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}