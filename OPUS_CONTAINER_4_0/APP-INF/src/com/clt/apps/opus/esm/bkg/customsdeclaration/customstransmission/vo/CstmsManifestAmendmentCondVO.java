/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CstmsManifestAmendmentCondVO.java
 *@FileTitle : CstmsManifestAmendmentCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.19 김민정
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class CstmsManifestAmendmentCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/**
	 * hashColumnInpo
	 *
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * hashFildInpo
	 *
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/* Column Info */
	private String pageNo = null;

	/**
	 * Column Info
	 *
	 * @return pgmNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}

	/**
	 * Column Info
	 *
	 * @param pgmNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/* Column Info */
	private String startNo = null;

	/**
	 * Column Info
	 *
	 * @return startNo
	 */
	public String getStartNo() {
		return this.startNo;
	}

	/**
	 * Column Info
	 *
	 * @param startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	/* Column Info */
	private String endNo = null;

	/**
	 * Column Info
	 *
	 * @return endNo
	 */
	public String getEndNo() {
		return this.endNo;
	}

	/**
	 * Column Info
	 *
	 * @param endNo
	 */
	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
}