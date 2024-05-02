/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0117Event.java
*@FileTitle : Import Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05 
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.01.23 Arie
* 1.0 Creation
* * Cr반영용
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgInfoListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Arie
 * @see ESM_SPC_0117HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리 */
    private BkgInfoListVO      bkgVO     = null;
    private BkgInfoListVO[]    bkgVOs    = null;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;
	
	
	public EsmSpc0117Event(){}

	public BkgInfoListVO getBkgInfoListVO() {
		return bkgVO;
	}

	public void setBkgInfoListVO(BkgInfoListVO bkgVO) {
		this.bkgVO = bkgVO;
	}

	public BkgInfoListVO[] getBkgInfoListVOs() {
		return bkgVOs;
	}

	public void setBkgInfoListVOs(BkgInfoListVO[] bkgVOs) {
		this.bkgVOs = bkgVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}