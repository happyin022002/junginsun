/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0037Event.java
 *@FileTitle : Canada CCT Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-07-04
 *@LastModifier : 2007611
 *@LastVersion : 1.0
 * 1.0 최초 생성 JunKun Lee
 * CSR: CHM-201217726-01 Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JunKun Lee
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0037Event extends EventSupport{

	private CanadaCCTManageVO canadaCCTManageVO;
	private CanadaCCTManageVO[] canadaCCTManageVOs;

	private String frmCntCd;
	private String frmLocCd;
	
	/**
	 * getCanadaCCTManageVO
	 * @return CanadaCCTManageVO
	 */
	public CanadaCCTManageVO getCanadaCCTManageVO(){
		return canadaCCTManageVO;
	}

	/**
	 * setCanadaCCTManageVO
	 * @param canadaCCTManageVO
	 */
	public void setCanadaCCTManageVO(CanadaCCTManageVO canadaCCTManageVO){
		this.canadaCCTManageVO = canadaCCTManageVO;
	}

	/**
	 * getCanadaCCTManageVOs
	 * @return CanadaCCTManageVO[]
	 */
	public CanadaCCTManageVO[] getCanadaCCTManageVOs(){
		return canadaCCTManageVOs;
	}

	/**
	 * setCanadaCCTManageVOs
	 * @param canadaCCTManageVOs
	 */
	public void setCanadaCCTManageVOs(CanadaCCTManageVO[] canadaCCTManageVOs){
		this.canadaCCTManageVOs = canadaCCTManageVOs;
	}

	/**
	 * getFrmCntCd
	 * @return String
	 */
	public String getFrmCntCd() {
		return frmCntCd;
	}

	/**
	 * setFrmCntCd
	 * @param frmCntCd
	 */
	public void setFrmCntCd(String frmCntCd) {
		this.frmCntCd = frmCntCd;
	}

	/**
	 * getFrmLocCd
	 * @return String
	 */
	public String getFrmLocCd() {
		return frmLocCd;
	}

	/**
	 * setFrmLocCd
	 * @param frmLocCd
	 */
	public void setFrmLocCd(String frmLocCd) {
		this.frmLocCd = frmLocCd;
	}
}
