/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeFormVO.java
*@FileTitle : HoldNoticeFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.17 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgHldWdDtlVO;
import com.hanjin.syscommon.common.table.BkgHldWdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박미옥
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
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
