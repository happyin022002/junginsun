/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1140Event.java
*@FileTitle : Correction Change 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.10.14 김태경
* 1.0 Creation
* 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgCorrCngDpcsUsrVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김태경
 * @see ESM_BKG_1140HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO = null;
	private DocQueueDetailListVO docQueueDetailListVO = null;
	
	public BkgCorrCngDpcsUsrVO getBkgCorrCngDpcsUsrVO() {
		return bkgCorrCngDpcsUsrVO;
	}
	
	public DocQueueDetailListVO getDocQueueDetailListVO() {
		return docQueueDetailListVO;
	}

	public void setBkgCorrCngDpcsUsrVO(BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO) {
		this.bkgCorrCngDpcsUsrVO = bkgCorrCngDpcsUsrVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCorrCngDpcsUsrVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgCorrCngDpcsUsrVO[] infoVOs = null;

	public BkgCorrCngDpcsUsrVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BkgCorrCngDpcsUsrVO infoVO) {
		this.infoVO = infoVO;
	}

	public BkgCorrCngDpcsUsrVO[] getInfoVOs() {
		return infoVOs;
	}

	public void setInfoVOs(BkgCorrCngDpcsUsrVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}

	public void setDocQueueDetailListVO(DocQueueDetailListVO docQueueDetailListVO) {
		this.docQueueDetailListVO = docQueueDetailListVO;
	}

	public EsmBkg1140Event(){}
	

	
	
}