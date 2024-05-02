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
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BsaVvdMstVO;
import com.hanjin.syscommon.common.table.BsaVvdPortDwnVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;


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

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setSearchStepUpDownVvdMasterListVOS(SearchStepUpDownVvdMasterListVO[] searchStepUpDownVvdMasterListVOs){
		this.searchStepUpDownVvdMasterListVOs = new SearchStepUpDownVvdMasterListVO[searchStepUpDownVvdMasterListVOs.length];
		for(int i=0; i< searchStepUpDownVvdMasterListVOs.length; ++i){
			this.searchStepUpDownVvdMasterListVOs[i] = searchStepUpDownVvdMasterListVOs[i];
		}
	}

	public SearchStepUpDownVvdMasterListVO getSearchStepUpDownVvdMasterListVO(){
		return searchStepUpDownVvdMasterListVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public SearchStepUpDownVvdMasterListVO[] getSearchStepUpDownVvdMasterListVOS(){
		SearchStepUpDownVvdMasterListVO[] ret = null;
		if(this.searchStepUpDownVvdMasterListVOs != null){
			ret = new SearchStepUpDownVvdMasterListVO[searchStepUpDownVvdMasterListVOs.length];
			for(int i=0; i<searchStepUpDownVvdMasterListVOs.length; i++){
				ret[i] = this.searchStepUpDownVvdMasterListVOs[i];
			}
		}
		return ret;
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

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaVvdMstVO[] getBsaVvdMstVOs() {
		BsaVvdMstVO[] ret = null;
		if(this.bsaVvdMstVOs != null){
			ret = new BsaVvdMstVO[bsaVvdMstVOs.length];
			for(int i=0; i<bsaVvdMstVOs.length; i++){
				ret[i] = this.bsaVvdMstVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaVvdMstVOs(BsaVvdMstVO[] bsaVvdMstVOs) {
		this.bsaVvdMstVOs = new BsaVvdMstVO[bsaVvdMstVOs.length];
		for(int i=0; i< bsaVvdMstVOs.length; ++i){
			this.bsaVvdMstVOs[i] = bsaVvdMstVOs[i];
		}
	}

	public BsaVvdPortDwnVO getBsaVvdPortDwnVO() {
		return bsaVvdPortDwnVO;
	}

	public void setBsaVvdPortDwnVO(BsaVvdPortDwnVO bsaVvdPortDwnVO) {
		this.bsaVvdPortDwnVO = bsaVvdPortDwnVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public BsaVvdPortDwnVO[] getBsaVvdPortDwnVOs() {
		BsaVvdPortDwnVO[] ret = null;
		if(this.bsaVvdPortDwnVOs != null){
			ret = new BsaVvdPortDwnVO[bsaVvdPortDwnVOs.length];
			for(int i=0; i<bsaVvdPortDwnVOs.length; i++){
				ret[i] = this.bsaVvdPortDwnVOs[i];
			}
		}
		return ret;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setBsaVvdPortDwnVOs(BsaVvdPortDwnVO[] bsaVvdPortDwnVOs) {
		this.bsaVvdPortDwnVOs = new BsaVvdPortDwnVO[bsaVvdPortDwnVOs.length];
		for(int i=0; i< bsaVvdPortDwnVOs.length; ++i){
			this.bsaVvdPortDwnVOs[i] = bsaVvdPortDwnVOs[i];
		}
	}

}