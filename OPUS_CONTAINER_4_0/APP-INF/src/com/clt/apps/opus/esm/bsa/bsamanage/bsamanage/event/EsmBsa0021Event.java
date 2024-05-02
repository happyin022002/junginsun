/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0021Event.java
*@FileTitle : EsmBsa0021Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_BSA_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0021HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0021Event extends EventSupport {
	/** 조회 조건 단건처리 */
	private SearchBsaConditionVO searchBsaConditionVO = null;

	/** 단건처리 */
	private BsaTableSaveVO bsaTableSaveVO = null;
	
	/** 멀티처리 */
	private BsaTableSaveVO[] bsaTableSaveVOs= null;
	

	/** Constructor */
	public EsmBsa0021Event(){}	
	
	/** Search Condition Getter */
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	/** Search Condition Setter */
	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	/** Save Getter */	
	public BsaTableSaveVO getBsaTableSaveVO() {
		return bsaTableSaveVO;
	}
	/** Save Setter */
	public void setBsaTableSaveVO(BsaTableSaveVO bsaTableSaveVO) {
		this.bsaTableSaveVO = bsaTableSaveVO;
	}
		
	/** Save Getter : SJH.20150507.소스품질 */
	public BsaTableSaveVO[] getBsaTableSaveVOs() {
		BsaTableSaveVO[] rtnVOs = null;
		if (this.bsaTableSaveVOs != null) {
			rtnVOs = Arrays.copyOf(bsaTableSaveVOs, bsaTableSaveVOs.length);
		}
		return rtnVOs;
	}
	/** Save Setter : SJH.20150507.소스품질 */
	public void setBsaTableSaveVOs(BsaTableSaveVO[] bsaTableSaveVOs){
		if(bsaTableSaveVOs != null){
			BsaTableSaveVO[] tmpVOs = Arrays.copyOf(bsaTableSaveVOs, bsaTableSaveVOs.length);
			this.bsaTableSaveVOs = tmpVOs;
		}
	}

}
