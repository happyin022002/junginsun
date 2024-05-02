/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCstmsBlContainerVO.java
 *@FileTitle : CndCstmsBlContainerVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.11 김민정 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 김민정
 * @since J2EE 1.5
 * @see ..
 */
public class CndCstmsBlContainerVO extends CstmsBlVO {


	private static final long serialVersionUID = 1L;

	//BL Main
	private CndCstmsBlMainVO cndCstmsBlMainVO;
	//BL Customer
	private CndCstmsBlCustVO cndCstmsBlCustVO;

	public CndCstmsBlContainerVO() {}

	public void setCndCstmsBlMainVO(CndCstmsBlMainVO cndCstmsBlMainVO) {
		this.cndCstmsBlMainVO = cndCstmsBlMainVO;
	}

	public void setCndCstmsBlCustVO(CndCstmsBlCustVO cndCstmsBlCustVO) {
		this.cndCstmsBlCustVO = cndCstmsBlCustVO;
	}

	public CndCstmsBlMainVO getCndCstmsBlMainVO() {
		return cndCstmsBlMainVO;
	}

	public CndCstmsBlCustVO getCndCstmsBlCustVO() {
		return cndCstmsBlCustVO;
	}
}