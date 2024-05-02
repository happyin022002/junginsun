/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0694Event.java
*@FileTitle : DO LIST CHECK REPORT(JAPAN)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.12 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0694 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0694HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0694HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0694Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;
	
	private String svcCd = null;

	private String key = "";
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapDoHisListVO japDoHisListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JapDoHisListVO[] japDoHisListVOs = null;
	
	private  JapDorEdiTransVO[] japDorEdiTransVOs = null; 
	/** 검색조건 */
	private JapDoHisSearchVO japDoHisSearchVO = null;
	

	public JapDoHisSearchVO getJapDoHisSearchVO() {
		return japDoHisSearchVO;
	}

	public void setJapDoHisSearchVO(JapDoHisSearchVO japDoHisSearchVO) {
		this.japDoHisSearchVO = japDoHisSearchVO;
	}

	public EsmBkg0694Event(){}

	/**
	 * @return the japDoHisListVO
	 */
	public JapDoHisListVO getjapDoHisListVO() {
		return japDoHisListVO;
	}

	/**
	 * @param JapDoHisListVO the JapDoHisListVO to set
	 */
	public void setjapDoHisListVO(JapDoHisListVO japDoHisListVO) {
		this.japDoHisListVO = japDoHisListVO;
	}

	/**
	 * @return the JapDoHisListVOs
	 */
	public JapDoHisListVO[] getJapDoHisListVOs() {
		return japDoHisListVOs;
	}

	/**
	 * @param JapDoHisListVOs the JapDoHisListVOs to set
	 */
	public void setJapDoHisListVOs(
			JapDoHisListVO[] japDoHisListVOs) {
		this.japDoHisListVOs = japDoHisListVOs;
	}

	public JapDorEdiTransVO[] getJapDorEdiTransVOs() {
		return japDorEdiTransVOs;
	}

	public void setJapDorEdiTransVOs(JapDorEdiTransVO[] japDorEdiTransVOs) {
		this.japDorEdiTransVOs = japDorEdiTransVOs;
	}

	public String getSvcCd() {
		return svcCd;
	}

	public void setSvcCd(String svcCd) {
		this.svcCd = svcCd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}