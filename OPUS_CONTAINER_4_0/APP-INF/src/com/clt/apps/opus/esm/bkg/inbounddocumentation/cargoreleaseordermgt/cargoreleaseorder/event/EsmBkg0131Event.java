/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0131Event.java
*@FileTitle : Cargo Release Order_Do List Check Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0131HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0131Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DoCheckListVO doCheckListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DoCheckListVO[] doCheckListVOs = null;
	
	/** 검색조건 */
	private DoCheckListSearchVO doCheckListSearchVO = null;
	
	public EsmBkg0131Event(){}

	public DoCheckListVO getDoCheckListVO() {
		return doCheckListVO;
	}

	/**
	 * 
	 *  @author
	 *  @param DoCheckListVO doCheckListVO
	 *  void
	 */
	public void setDoCheckListVO(DoCheckListVO doCheckListVO) {
		this.doCheckListVO = doCheckListVO;
	}

	/**
	 * 
	 *  @author
	 *  @param void
	 *  DoCheckListVO[]
	 */
//	public DoCheckListVO[] getDoCheckListVOs() {
//		return doCheckListVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public DoCheckListVO[] getDoCheckListVOs() {
		DoCheckListVO[] tmpVOs = null;
		if (this.doCheckListVOs != null) {
			tmpVOs = new DoCheckListVO[doCheckListVOs.length];
			System.arraycopy(doCheckListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 		

	/**
	 * 
	 *  @author
	 *  @param DoCheckListVO[] doCheckListVOs
	 *  void
	 */
//	public void setDoCheckListVOs(DoCheckListVO[] doCheckListVOs) {
//		this.doCheckListVOs = doCheckListVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setDoCheckListVOs(DoCheckListVO[] doCheckListVOs) {
		if (doCheckListVOs != null) {
			DoCheckListVO[] tmpVOs = new DoCheckListVO[doCheckListVOs.length];
			System.arraycopy(doCheckListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.doCheckListVOs = tmpVOs;
		}		
	} 	

	/**
	 * 
	 *  @author
	 *  @param void
	 *  DoCheckListSearchVO
	 */
	public DoCheckListSearchVO getDoCheckListSearchVO() {
		return doCheckListSearchVO;
	}

	/**
	 * 
	 *  @author
	 *  @param DoCheckListSearchVO doCheckListSearchVO
	 *  void
	 */
	public void setDoCheckListSearchVO(DoCheckListSearchVO doCheckListSearchVO) {
		this.doCheckListSearchVO = doCheckListSearchVO;
	}

	
}