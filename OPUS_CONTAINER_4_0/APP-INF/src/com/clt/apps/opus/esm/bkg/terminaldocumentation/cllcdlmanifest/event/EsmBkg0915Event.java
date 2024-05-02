/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0915Event.java
*@FileTitle : ESM_BKG_0915
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllSpclCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCstmsTmlCllDgCgoVO;


/**
 * ESM_BKG_0915 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0915HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0915HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0915Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CllSpclCondVO cllSpclCondVO = null;


	/** Table Value Object Multi Data 처리 */
	private BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs = null;

	public EsmBkg0915Event(){}

	public void setCllSpclCondVO(CllSpclCondVO cllSpclCondVO){
		this. cllSpclCondVO = cllSpclCondVO;
	}

	public CllSpclCondVO getCllSpclCondVO(){
		return cllSpclCondVO;
	}

	public BkgCstmsTmlCllDgCgoVO[] getBkgCstmsTmlCllDgCgoVOS() {
		BkgCstmsTmlCllDgCgoVO[] rtnVOs = null;
		if (this.bkgCstmsTmlCllDgCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCstmsTmlCllDgCgoVOs,
					bkgCstmsTmlCllDgCgoVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCstmsTmlCllDgCgoVOS(BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs) {
		if (bkgCstmsTmlCllDgCgoVOs != null) {
			BkgCstmsTmlCllDgCgoVO[] tmpVOs = Arrays.copyOf(bkgCstmsTmlCllDgCgoVOs,bkgCstmsTmlCllDgCgoVOs.length);
			this.bkgCstmsTmlCllDgCgoVOs = tmpVOs;
		}
	}


}