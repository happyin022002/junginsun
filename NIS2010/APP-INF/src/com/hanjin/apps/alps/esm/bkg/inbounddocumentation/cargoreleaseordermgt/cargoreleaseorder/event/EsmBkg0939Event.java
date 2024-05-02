/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0939Event.java
*@FileTitle : India_Cargo Release Order list inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.18 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0939 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0939HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mangeon
 * @see ESM_BKG_0939HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0939Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

//	/** Table Value Object 조회 조건 및 단건 처리  */
//	private DoCheckListVO doCheckListVO = null;
//	
//	/** Table Value Object Multi Data 처리 */
//	private DoCheckListVO[] doCheckListVOs = null;
	
	/** 검색조건 */
	private IdaDoRlseSearchVO idaDoRlseSearchVO = null;
	
	public EsmBkg0939Event(){}

//	public DoCheckListVO getDoCheckListVO() {
//		return doCheckListVO;
//	}
//
//	/**
//	 * 
//	 *  @author Park Mangeon
//	 *  @param DoCheckListVO doCheckListVO
//	 *  void
//	 */
//	public void setDoCheckListVO(DoCheckListVO doCheckListVO) {
//		this.doCheckListVO = doCheckListVO;
//	}
//
//	/**
//	 * 
//	 *  @author Park Mangeon
//	 *  @param void
//	 *  DoCheckListVO[]
//	 */
//	public DoCheckListVO[] getDoCheckListVOs() {
//		return doCheckListVOs;
//	}
//
//	/**
//	 * 
//	 *  @author Park Mangeon
//	 *  @param DoCheckListVO[] doCheckListVOs
//	 *  void
//	 */
//	public void setDoCheckListVOs(DoCheckListVO[] doCheckListVOs) {
//		this.doCheckListVOs = doCheckListVOs;
//	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param void
	 *  IdaDoRlseSearchVO
	 */
	public IdaDoRlseSearchVO getIdaDoRlseSearchVO() {
		return idaDoRlseSearchVO;
	}

	/**
	 * 
	 *  @author Park Mangeon
	 *  @param IdaDoRlseSearchVO idaDoRlseSearchVO
	 *  void
	 */
	public void setIdaDoRlseSearchVO(IdaDoRlseSearchVO idaDoRlseSearchVO) {
		this.idaDoRlseSearchVO = idaDoRlseSearchVO;
	}

	
}