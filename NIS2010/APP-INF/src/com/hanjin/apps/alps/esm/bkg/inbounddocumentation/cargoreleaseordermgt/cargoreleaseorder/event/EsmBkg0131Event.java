/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0131Event.java
*@FileTitle : Cargo Release Order_Do List Check Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.13 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
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
	 *  @author Park Mangeon
	 *  @param DoCheckListVO doCheckListVO
	 *  void
	 */
	public void setDoCheckListVO(DoCheckListVO doCheckListVO) {
		this.doCheckListVO = doCheckListVO;
	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param void
	 *  DoCheckListVO[]
	 */
	public DoCheckListVO[] getDoCheckListVOs() {
		return doCheckListVOs;
	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param DoCheckListVO[] doCheckListVOs
	 *  void
	 */
	public void setDoCheckListVOs(DoCheckListVO[] doCheckListVOs) {
		this.doCheckListVOs = doCheckListVOs;
	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param void
	 *  DoCheckListSearchVO
	 */
	public DoCheckListSearchVO getDoCheckListSearchVO() {
		return doCheckListSearchVO;
	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param DoCheckListSearchVO doCheckListSearchVO
	 *  void
	 */
	public void setDoCheckListSearchVO(DoCheckListSearchVO doCheckListSearchVO) {
		this.doCheckListSearchVO = doCheckListSearchVO;
	}

	
}