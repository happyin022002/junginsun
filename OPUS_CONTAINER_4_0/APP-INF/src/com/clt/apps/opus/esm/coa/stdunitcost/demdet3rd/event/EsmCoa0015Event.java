/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0015Event.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemDet3rdVO demDet3rdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemDet3rdVO[] demDet3rdVOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmCoa0015Event(){}
	
	public void setDemDet3rdVO(DemDet3rdVO demDet3rdVO){
		this. demDet3rdVO = demDet3rdVO;
	}
	//SJH.20150508.소스품질
	public void setDemDet3rdVOS(DemDet3rdVO[] demDet3rdVOs){
		if(demDet3rdVOs != null){
			DemDet3rdVO[] tmpVOs = Arrays.copyOf(demDet3rdVOs, demDet3rdVOs.length);
			this.demDet3rdVOs = tmpVOs;
		}
	}

	public DemDet3rdVO getDemDet3rdVO(){
		return demDet3rdVO;
	}
	//SJH.20150508.소스품질
	public DemDet3rdVO[] getDemDet3rdVOS(){
		DemDet3rdVO[] rtnVOs = null;
		if (this.demDet3rdVOs != null) {
			rtnVOs = Arrays.copyOf(demDet3rdVOs, demDet3rdVOs.length);
		}
		return rtnVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}