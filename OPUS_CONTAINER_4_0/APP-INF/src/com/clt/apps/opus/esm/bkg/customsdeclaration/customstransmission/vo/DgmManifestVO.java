/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgmManifestVO.java
*@FileTitle : DgmManifestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.19 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVvdVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author SANGHUN PARK
 * @since J2EE 1.5
 * @see AbstractValueObject
 */
public class DgmManifestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = null;
	private BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO = null;
	private BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO = null;


	/**
	 * @return the bkgCstmsKrDgCgoVOs
	 */
	public BkgCstmsKrDgCgoVO[] getBkgCstmsKrDgCgoVOs() {
		return bkgCstmsKrDgCgoVOs;
	}

	/**
	 * @param bkgCstmsKrDgCgoVOs the bkgCstmsKrDgCgoVOs to set
	 */
	public void setBkgCstmsKrDgCgoVOs(BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs) {
		this.bkgCstmsKrDgCgoVOs = bkgCstmsKrDgCgoVOs;
	}

	/**
	 * @return the bkgCstmsKrDgCgoVvdVO
	 */
	public BkgCstmsKrDgCgoVvdVO getBkgCstmsKrDgCgoVvdVO() {
		return bkgCstmsKrDgCgoVvdVO;
	}

	/**
	 * @param bkgCstmsKrDgCgoVvdVO the bkgCstmsKrDgCgoVvdVO to set
	 */
	public void setBkgCstmsKrDgCgoVvdVO(BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO) {
		this.bkgCstmsKrDgCgoVvdVO = bkgCstmsKrDgCgoVvdVO;
	}

	/**
	 * @return the bkgCstmsKrDgCgoVO
	 */
	public BkgCstmsKrDgCgoVO getBkgCstmsKrDgCgoVO() {
		return bkgCstmsKrDgCgoVO;
	}

	/**
	 * @param bkgCstmsKrDgCgoVO the bkgCstmsKrDgCgoVO to set
	 */
	public void setBkgCstmsKrDgCgoVO(BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO) {
		this.bkgCstmsKrDgCgoVO = bkgCstmsKrDgCgoVO;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
