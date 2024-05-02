/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmCoa4006Event.java
*@FileTitle : (CMTX)Route Cost Inqiury 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.vo.TrfChgVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_4006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_4006HTMLAction 참조
 * @since J2EE 1.6
 */


public class EsmCoa4006Event extends EventSupport { 

	private static final long serialVersionUID = 1L;
	
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrfChgVO[] trfChgVOs = null;	
	
	public EsmCoa4006Event(){}
	
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
	
	//20150616.ADD
	public void setTrfChgVOS(TrfChgVO[] trfChgVOs){
		if(trfChgVOs != null){
			TrfChgVO[] tmpVOs = Arrays.copyOf(trfChgVOs, trfChgVOs.length);
			this.trfChgVOs = tmpVOs;
		}
	}
	//20150616.ADD
	public TrfChgVO[] getTrfChgVOS(){
		TrfChgVO[] rtnVOs = null;
		if (this.trfChgVOs != null) {
			rtnVOs = Arrays.copyOf(trfChgVOs, trfChgVOs.length);
		}
		return rtnVOs;
	}		
}