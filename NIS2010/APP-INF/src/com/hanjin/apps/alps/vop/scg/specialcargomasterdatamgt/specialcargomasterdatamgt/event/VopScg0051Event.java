/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0051Event.java
*@FileTitle : Loading Port for RSO (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.22 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgRgnShpOprPortVO;


/**
 * VOP_SCG_0051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0051HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0051Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRgnShpOprPortVO scgRgnShpOprPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgRgnShpOprPortVO[] scgRgnShpOprPortVOs = null;

	private SearchRsoComboListVO   searchRsoComboListVO = null;		
	public SearchRsoComboListVO getSearchRsoComboListVO() {
		return searchRsoComboListVO;
	}

	public void setSearchRsoComboListVO(SearchRsoComboListVO searchRsoComboListVO) {
		this.searchRsoComboListVO = searchRsoComboListVO;
	}

	public VopScg0051Event(){}
	
	public void setScgRgnShpOprPortVO(ScgRgnShpOprPortVO scgRgnShpOprPortVO){
		this. scgRgnShpOprPortVO = scgRgnShpOprPortVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgRgnShpOprPortVOS(ScgRgnShpOprPortVO[] scgRgnShpOprPortVOs){
		if (scgRgnShpOprPortVOs != null) {
			ScgRgnShpOprPortVO[] tmpVOs = new ScgRgnShpOprPortVO[scgRgnShpOprPortVOs.length];
			System.arraycopy(scgRgnShpOprPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgRgnShpOprPortVOs = tmpVOs;
		}
	}

	public ScgRgnShpOprPortVO getScgRgnShpOprPortVO(){
		return scgRgnShpOprPortVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgRgnShpOprPortVO[] getScgRgnShpOprPortVOS(){
		ScgRgnShpOprPortVO[] rtnVOs = null;
		if (this.scgRgnShpOprPortVOs != null) {
			rtnVOs = new ScgRgnShpOprPortVO[scgRgnShpOprPortVOs.length];
			System.arraycopy(scgRgnShpOprPortVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}