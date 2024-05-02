/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0011Event.java
*@FileTitle : Constraints List Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.30 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqMdlCnstVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItemListVO;


/**
 * ESM_SPC_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMdlCnstVO saqMdlCnstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMdlCnstVO[] saqMdlCnstVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConstraintItemListVO searchConstraintItemListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchConstraintItemListVO[] searchConstraintItemListVOs = null;

	public EsmSpc0011Event(){}
	
	public void setSaqMdlCnstVO(SaqMdlCnstVO saqMdlCnstVO){
		this. saqMdlCnstVO = saqMdlCnstVO;
	}

	public void setSaqMdlCnstVOS(SaqMdlCnstVO[] saqMdlCnstVOs){
		this. saqMdlCnstVOs = saqMdlCnstVOs;
	}

	public void setSearchConstraintItemListVO(SearchConstraintItemListVO searchConstraintItemListVO){
		this. searchConstraintItemListVO = searchConstraintItemListVO;
	}

	public void setSearchConstraintItemListVOS(SearchConstraintItemListVO[] searchConstraintItemListVOs){
		this. searchConstraintItemListVOs = searchConstraintItemListVOs;
	}

	public SaqMdlCnstVO getSaqMdlCnstVO(){
		return saqMdlCnstVO;
	}

	public SaqMdlCnstVO[] getSaqMdlCnstVOS(){
		return saqMdlCnstVOs;
	}

	public SearchConstraintItemListVO getSearchConstraintItemListVO(){
		return searchConstraintItemListVO;
	}

	public SearchConstraintItemListVO[] getSearchConstraintItemListVOS(){
		return searchConstraintItemListVOs;
	}

}