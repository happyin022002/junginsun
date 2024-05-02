/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0485Event.java
*@FileTitle : Special Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2009.09.07 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0485 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0485HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ilmin Lee
 * @see ESM_BKG_0485HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0485Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	public EsmBkg0485Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialCargoManifestInfoVO specialCargoManifestInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SpecialCargoManifestInfoVO[] specialCargoManifestInfoVOs = null;

	public SpecialCargoManifestInfoVO getSpecialCargoManifestInfoVO() {
		return specialCargoManifestInfoVO;
	}

	public void setSpecialCargoManifestInfoVO(
			SpecialCargoManifestInfoVO specialCargoManifestInfoVO) {
		this.specialCargoManifestInfoVO = specialCargoManifestInfoVO;
	}

	public SpecialCargoManifestInfoVO[] getSpecialCargoManifestInfoVOs() {
		SpecialCargoManifestInfoVO[] rtnVOs = null;
		if(this.specialCargoManifestInfoVOs != null){
			rtnVOs= Arrays.copyOf(specialCargoManifestInfoVOs, specialCargoManifestInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSpecialCargoManifestInfoVOs(
			SpecialCargoManifestInfoVO[] specialCargoManifestInfoVOs) {
		if(specialCargoManifestInfoVOs != null){
			SpecialCargoManifestInfoVO[] tmpVOs = Arrays.copyOf(specialCargoManifestInfoVOs, specialCargoManifestInfoVOs.length);
			this.specialCargoManifestInfoVOs = tmpVOs;
		}
	}

}
