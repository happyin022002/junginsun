/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiScg0033Event.java
*@FileTitle : Loading Port for RSO(Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.19 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgRgnShpOprPortVO;


/**
 * VOP_SCG_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see VOP_SCG_0033HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0033Event extends EventSupport {



	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
 
	private ScgRgnShpOprPortVO scgRgnShpOprPortVO = null;
	private ScgRgnShpOprPortVO[] scgRgnShpOprPortVOs = null;	
	private ScgRgnShpOprPortListVO[] scgRgnShpOprPortListVOs = null;	
	
	public ScgRgnShpOprPortListVO[] getScgRgnShpOprPortListVOs() {
		ScgRgnShpOprPortListVO[] rtnVOs = null;
		if (this.scgRgnShpOprPortListVOs != null) {
			rtnVOs = Arrays.copyOf(scgRgnShpOprPortListVOs, scgRgnShpOprPortListVOs.length);
		}
		return rtnVOs;
	}
	public void setScgRgnShpOprPortListVOs(
			ScgRgnShpOprPortListVO[] scgRgnShpOprPortListVOs) {
		if(scgRgnShpOprPortListVOs != null){
			ScgRgnShpOprPortListVO[] tmpVOs = Arrays.copyOf(scgRgnShpOprPortListVOs, scgRgnShpOprPortListVOs.length);
			this.scgRgnShpOprPortListVOs = tmpVOs;
		}
	}
	public ScgRgnShpOprPortVO getSearchLoadingPortRsoVO() {
		return scgRgnShpOprPortVO;
	}
	public void setSearchLoadingPortRsoVO(
			ScgRgnShpOprPortVO scgRgnShpOprPortVO) {
		this.scgRgnShpOprPortVO = scgRgnShpOprPortVO;
	}
	public ScgRgnShpOprPortVO[] getSearchLoadingPortRsoVOs() {
		ScgRgnShpOprPortVO[] rtnVOs = null;
		if (this.scgRgnShpOprPortVOs != null) {
			rtnVOs = Arrays.copyOf(scgRgnShpOprPortVOs, scgRgnShpOprPortVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchLoadingPortRsoVOs(
			ScgRgnShpOprPortVO[] scgRgnShpOprPortVOs) {
		if(scgRgnShpOprPortVOs != null){
			ScgRgnShpOprPortVO[] tmpVOs = Arrays.copyOf(scgRgnShpOprPortVOs, scgRgnShpOprPortVOs.length);
			this.scgRgnShpOprPortVOs = tmpVOs;
		}
	}
	public SearchRsoComboListVO getSearchRsoComboListVO() {
		return searchRsoComboListVO;
	}
	public void setSearchRsoComboListVO(SearchRsoComboListVO searchRsoComboListVO) {
		this.searchRsoComboListVO = searchRsoComboListVO;
	}
	public SearchRsoComboListVO[] getSearchRsoComboListVOs() {
		SearchRsoComboListVO[] rtnVOs = null;
		if (this.searchRsoComboListVOs != null) {
			rtnVOs = Arrays.copyOf(searchRsoComboListVOs, searchRsoComboListVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchRsoComboListVOs(
			SearchRsoComboListVO[] searchRsoComboListVOs) {
		if(searchRsoComboListVOs != null){
			SearchRsoComboListVO[] tmpVOs = Arrays.copyOf(searchRsoComboListVOs, searchRsoComboListVOs.length);
			this.searchRsoComboListVOs = tmpVOs;
		}
	}
	private SearchRsoComboListVO   searchRsoComboListVO = null;	
	private SearchRsoComboListVO[] searchRsoComboListVOs = null;	
 
}