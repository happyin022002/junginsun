/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgComInternalEvent.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.02 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchImdgAmdtMstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;


/**
 * SCG_COM_INTERNAL 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SCG_COM_INTERNALHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see SCG_COM_INTERNALHTMLAction 참조
 * @since J2EE 1.6
 */

public class ScgComInternalEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgUnNoVO scgImdgUnNoVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgClssCdVO scgImdgClssCdVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgImdgSpclProviVO scgImdgSpclProviVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgIrrTpCdVO scgIrrTpCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgIrrTpCdVO[] scgIrrTpCdVOs = null;
	
	private SearchImdgAmdtMstVO searchImdgAmdtMstVO = null;
	/**
	 * @return the searchUNNumberVO
	 */
	public SearchUNNumberVO getSearchUNNumberVO() {
		return searchUNNumberVO;
	}

	/**
	 * @param searchUNNumberVO the searchUNNumberVO to set
	 */
	public void setSearchUNNumberVO(SearchUNNumberVO searchUNNumberVO) {
		this.searchUNNumberVO = searchUNNumberVO;
	}

	/**
	 * @return the searchUNNumberVOs
	 */
	public SearchUNNumberVO[] getSearchUNNumberVOs() {
		SearchUNNumberVO[] rtnVOs = null;
		if (this.searchUNNumberVOs != null) {
			rtnVOs = Arrays.copyOf(searchUNNumberVOs, searchUNNumberVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param searchUNNumberVOs the searchUNNumberVOs to set
	 */
	public void setSearchUNNumberVOs(SearchUNNumberVO[] searchUNNumberVOs) {
		if(searchUNNumberVOs != null){
			SearchUNNumberVO[] tmpVOs = Arrays.copyOf(searchUNNumberVOs, searchUNNumberVOs.length);
			this.searchUNNumberVOs = tmpVOs;
		}
	}

	private SearchUNNumberVO   searchUNNumberVO = null;		
	private SearchUNNumberVO[] searchUNNumberVOs = null;	
	
	
	public ScgComInternalEvent(){}
	
	public void setScgImdgUnNoVO(ScgImdgUnNoVO scgImdgUnNoVO){
		this. scgImdgUnNoVO = scgImdgUnNoVO;
	}

	public void setScgImdgClssCdVO(ScgImdgClssCdVO scgImdgClssCdVO){
		this. scgImdgClssCdVO = scgImdgClssCdVO;
	}

	public void setScgImdgSpclProviVO(ScgImdgSpclProviVO scgImdgSpclProviVO){
		this. scgImdgSpclProviVO = scgImdgSpclProviVO;
	}
	
	public void setScgIrrTpCdVO(ScgIrrTpCdVO scgIrrTpCdVO){
		this. scgIrrTpCdVO = scgIrrTpCdVO;
	}

	public void setScgIrrTpCdVOS(ScgIrrTpCdVO[] scgIrrTpCdVOs){
		if(scgIrrTpCdVOs != null){
			ScgIrrTpCdVO[] tmpVOs = Arrays.copyOf(scgIrrTpCdVOs, scgIrrTpCdVOs.length);
			this.scgIrrTpCdVOs = tmpVOs;
		}
	}

	public ScgImdgUnNoVO getScgImdgUnNoVO(){
		return scgImdgUnNoVO;
	}

	public ScgImdgClssCdVO getScgImdgClssCdVO(){
		return scgImdgClssCdVO;
	}

	public ScgImdgSpclProviVO getScgImdgSpclProviVO(){
		return scgImdgSpclProviVO;
	}
	
	public ScgIrrTpCdVO getScgIrrTpCdVO(){
		return scgIrrTpCdVO;
	}

	public ScgIrrTpCdVO[] getScgIrrTpCdVOS(){
		ScgIrrTpCdVO[] rtnVOs = null;
		if (this.scgIrrTpCdVOs != null) {
			rtnVOs = Arrays.copyOf(scgIrrTpCdVOs, scgIrrTpCdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @return the searchUNNumberVO
	 */
	public SearchImdgAmdtMstVO getSearchImdgAmdtMstVO() {
		return searchImdgAmdtMstVO;
	}

	/**
	 * @param searchUNNumberVO the searchUNNumberVO to set
	 */
	public void setSearchImdgAmdtMstVO(SearchImdgAmdtMstVO searchImdgAmdtMstVO) {
		this.searchImdgAmdtMstVO = searchImdgAmdtMstVO;
	}

}