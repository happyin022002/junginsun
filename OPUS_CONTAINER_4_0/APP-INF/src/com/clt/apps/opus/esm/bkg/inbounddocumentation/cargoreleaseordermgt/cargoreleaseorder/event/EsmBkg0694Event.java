/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0694Event.java
*@FileTitle : DO LIST CHECK REPORT(JAPAN)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0694 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0694HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0694HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0694Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapDoHisListVO japDoHisListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JapDoHisListVO[] japDoHisListVOs = null;
	
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
//	public JapDoHisListVO[] getJapDoHisListVOs() {
//		return japDoHisListVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public JapDoHisListVO[] getJapDoHisListVOs() {
		JapDoHisListVO[] tmpVOs = null;
		if (this.japDoHisListVOs != null) {
			tmpVOs = new JapDoHisListVO[japDoHisListVOs.length];
			System.arraycopy(japDoHisListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
	/**
	 * @param JapDoHisListVOs the JapDoHisListVOs to set
	 */
//	public void setJapDoHisListVOs(
//			JapDoHisListVO[] japDoHisListVOs) {
//		this.japDoHisListVOs = japDoHisListVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setJapDoHisListVOs(JapDoHisListVO[] japDoHisListVOs) {
		if (japDoHisListVOs != null) {
			JapDoHisListVO[] tmpVOs = new JapDoHisListVO[japDoHisListVOs.length];
			System.arraycopy(japDoHisListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.japDoHisListVOs = tmpVOs;
		}		
	} 	
}