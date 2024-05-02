/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9450Event.java
*@FileTitle : Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.16 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9450 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9450HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_9450HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9450Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrInfoForEmptyVO cntrInfoForEmptyVO = null;
	private BkgBlNoVO bkgBlNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrInfoForEmptyVO[] cntrInfoForEmptyVOs = null;

	public EsmBkg9450Event(){}
	
	public void setCntrInfoForEmptyVO(CntrInfoForEmptyVO cntrInfoForEmptyVO){
		this. cntrInfoForEmptyVO = cntrInfoForEmptyVO;
	}

	public void setCntrInfoForEmptyVOS(CntrInfoForEmptyVO[] cntrInfoForEmptyVOs){
		if (cntrInfoForEmptyVOs != null) {
			CntrInfoForEmptyVO[] tmpVOs = Arrays.copyOf(cntrInfoForEmptyVOs, cntrInfoForEmptyVOs .length);
			this. cntrInfoForEmptyVOs = tmpVOs;
		}
	}

	public CntrInfoForEmptyVO getCntrInfoForEmptyVO(){
		return cntrInfoForEmptyVO;
	}

	public CntrInfoForEmptyVO[] getCntrInfoForEmptyVOS(){
		CntrInfoForEmptyVO[] tmpVOs = null;
		if (this. cntrInfoForEmptyVOs != null) {
			tmpVOs = Arrays.copyOf(cntrInfoForEmptyVOs, cntrInfoForEmptyVOs .length);
		}
		return tmpVOs;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this.bkgBlNoVO = bkgBlNoVO;
	}	

}