/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmBkg1502Event.java
*@FileTitle : EsmBkg1502Event
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.05
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1502에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1502HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1502Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AdvJpBlVO advJpBlVO = null;
	private GetMdmCustomerVO getMdmCustomerVO = null;

	/** Table Value Object Multi Data 처리 */
	private AdvJpContainerVO[] advJpContainerVOs = null;
	private AdvJpMarkDescVO[] advJpMarkDescVOs = null;

	public EsmBkg1502Event() {}

	public AdvJpBlVO getAdvJpBlVO() {
		return advJpBlVO;
	}

	public void setAdvJpBlVO(AdvJpBlVO advJpBlVO) {
		this.advJpBlVO = advJpBlVO;
	}

	public GetMdmCustomerVO getGetMdmCustomerVO() {
		return getMdmCustomerVO;
	}

	public void setGetMdmCustomerVO(GetMdmCustomerVO getMdmCustomerVO) {
		this.getMdmCustomerVO = getMdmCustomerVO;
	}

	public AdvJpContainerVO[] getAdvJpContainerVOs() {
		AdvJpContainerVO[] rtnVOs = null;
		if (this.advJpContainerVOs != null) {
			rtnVOs = Arrays.copyOf(advJpContainerVOs, advJpContainerVOs.length);
		}
		return rtnVOs;
	}

	public void setAdvJpContainerVOs(AdvJpContainerVO[] advJpContainerVOs) {
		if (advJpContainerVOs != null) {
			AdvJpContainerVO[] tmpVOs = Arrays.copyOf(advJpContainerVOs, advJpContainerVOs.length);
			this.advJpContainerVOs = tmpVOs;
		}
	}

	public AdvJpMarkDescVO[] getAdvJpMarkDescVOs() {
		AdvJpMarkDescVO[] rtnVOs = null;
		if (this.advJpMarkDescVOs != null) {
			rtnVOs = Arrays.copyOf(advJpMarkDescVOs, advJpMarkDescVOs.length);
		}
		return rtnVOs;
	}

	public void setAdvJpMarkDescVOs(AdvJpMarkDescVO[] advJpMarkDescVOs) {
		if (advJpMarkDescVOs != null) {
			AdvJpMarkDescVO[] tmpVOs = Arrays.copyOf(advJpMarkDescVOs, advJpMarkDescVOs.length);
			this.advJpMarkDescVOs = tmpVOs;
		}
	}

}