/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0032Event.java
*@FileTitle : Step Up/Down by VVD 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.28 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BsaVvdMstVO;
import com.clt.syscommon.common.table.BsaVvdPortDwnVO;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchStepUpDownVvdMasterListVO searchStepUpDownVvdMasterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchStepUpDownVvdMasterListVO[] searchStepUpDownVvdMasterListVOs = null;
	
	/** Table Value Object 조회 조건 처리 */
	private SearchSpcConditionVO searchSpcConditionVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaVvdMstVO bsaVvdMstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaVvdMstVO[] bsaVvdMstVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BsaVvdPortDwnVO bsaVvdPortDwnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BsaVvdPortDwnVO[] bsaVvdPortDwnVOs = null;
	
	public EsmBsa0032Event(){}
	
	public void setSearchStepUpDownVvdMasterListVO(SearchStepUpDownVvdMasterListVO searchStepUpDownVvdMasterListVO){
		this. searchStepUpDownVvdMasterListVO = searchStepUpDownVvdMasterListVO;
	}
	
	//SJH.20150507.소스품질
	public void setSearchStepUpDownVvdMasterListVOS(SearchStepUpDownVvdMasterListVO[] searchStepUpDownVvdMasterListVOs){
		if(searchStepUpDownVvdMasterListVOs != null){
			SearchStepUpDownVvdMasterListVO[] tmpVOs = Arrays.copyOf(searchStepUpDownVvdMasterListVOs, searchStepUpDownVvdMasterListVOs.length);
			this.searchStepUpDownVvdMasterListVOs = tmpVOs;
		}
	}

	public SearchStepUpDownVvdMasterListVO getSearchStepUpDownVvdMasterListVO(){
		return searchStepUpDownVvdMasterListVO;
	}
	
	//SJH.20150507.소스품질
	public SearchStepUpDownVvdMasterListVO[] getSearchStepUpDownVvdMasterListVOS(){
		SearchStepUpDownVvdMasterListVO[] rtnVOs = null;
		if (this.searchStepUpDownVvdMasterListVOs != null) {
			rtnVOs = Arrays.copyOf(searchStepUpDownVvdMasterListVOs, searchStepUpDownVvdMasterListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpcConditionVO getSearchSpcConditionVO() {
		return searchSpcConditionVO;
	}

	public void setSearchSpcConditionVO(SearchSpcConditionVO searchSpcConditionVO) {
		this.searchSpcConditionVO = searchSpcConditionVO;
	}

	public BsaVvdMstVO getBsaVvdMstVO() {
		return bsaVvdMstVO;
	}

	public void setBsaVvdMstVO(BsaVvdMstVO bsaVvdMstVO) {
		this.bsaVvdMstVO = bsaVvdMstVO;
	}
	
	//SJH.20150507.소스품질
	public BsaVvdMstVO[] getBsaVvdMstVOs() {
		BsaVvdMstVO[] rtnVOs = null;
		if (this.bsaVvdMstVOs != null) {
			rtnVOs = Arrays.copyOf(bsaVvdMstVOs, bsaVvdMstVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setBsaVvdMstVOs(BsaVvdMstVO[] bsaVvdMstVOs){
		if(bsaVvdMstVOs != null){
			BsaVvdMstVO[] tmpVOs = Arrays.copyOf(bsaVvdMstVOs, bsaVvdMstVOs.length);
			this.bsaVvdMstVOs = tmpVOs;
		}
	}

	public BsaVvdPortDwnVO getBsaVvdPortDwnVO() {
		return bsaVvdPortDwnVO;
	}

	public void setBsaVvdPortDwnVO(BsaVvdPortDwnVO bsaVvdPortDwnVO) {
		this.bsaVvdPortDwnVO = bsaVvdPortDwnVO;
	}
	
	//SJH.20150507.소스품질
	public BsaVvdPortDwnVO[] getBsaVvdPortDwnVOs() {
		BsaVvdPortDwnVO[] rtnVOs = null;
		if (this.bsaVvdPortDwnVOs != null) {
			rtnVOs = Arrays.copyOf(bsaVvdPortDwnVOs, bsaVvdPortDwnVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setBsaVvdPortDwnVOs(BsaVvdPortDwnVO[] bsaVvdPortDwnVOs){
		if(bsaVvdPortDwnVOs != null){
			BsaVvdPortDwnVO[] tmpVOs = Arrays.copyOf(bsaVvdPortDwnVOs, bsaVvdPortDwnVOs.length);
			this.bsaVvdPortDwnVOs = tmpVOs;
		}
	}

}