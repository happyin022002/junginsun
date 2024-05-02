/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeFormVO.java
*@FileTitle : HoldNoticeFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgHldWdDtlVO;
import com.clt.syscommon.common.table.BkgHldWdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HoldNoticeFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private BkgHldWdVO bkgHldWd;
	
	private List<BkgHldWdDtlVO> bkgHldWdDtls;
	

	/**
	 * @param bkgHldWdVO the bkgHldWdVO to set
	 */
	public void setBkgHldWd(BkgHldWdVO bkgHldWd) {
		this.bkgHldWd = bkgHldWd;
	}

	/**
	 * @return the bkgHldWdVO
	 */
	public BkgHldWdVO getBkgHldWd() {
		return bkgHldWd;
	}

	/**
	 * @param bkgHldWdDtls the bkgHldWdDtls to set
	 */
	public void setBkgHldWdDtls(List<BkgHldWdDtlVO> bkgHldWdDtls) {
		this.bkgHldWdDtls = bkgHldWdDtls;
	}

	/**
	 * @return the bkgHldWdDtls
	 */
	public List<BkgHldWdDtlVO> getBkgHldWdDtls() {
		return bkgHldWdDtls;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
