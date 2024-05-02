/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0915Event.java
*@FileTitle : ESM_BKG_0915
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllSpclCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllDgCgoVO;


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

	public void setBkgCstmsTmlCllDgCgoVOS(BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs){
		this. bkgCstmsTmlCllDgCgoVOs = bkgCstmsTmlCllDgCgoVOs;
	}

	public CllSpclCondVO getCllSpclCondVO(){
		return cllSpclCondVO;
	}

	public BkgCstmsTmlCllDgCgoVO[] getBkgCstmsTmlCllDgCgoVOS(){
		return bkgCstmsTmlCllDgCgoVOs;
	}

}