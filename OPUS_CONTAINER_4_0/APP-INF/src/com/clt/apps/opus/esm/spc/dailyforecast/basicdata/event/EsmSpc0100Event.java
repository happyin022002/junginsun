/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0100Event.java
*@FileTitle      : Lane-Office-POL
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.23
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.07.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO = null;
	
	private SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVOs = null;
	private SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVOs = null;
	
	private SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO = null;
	
	private SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO = null;

	public EsmSpc0100Event(){}
	
	public void setSpcFcastOfcPolMapgVO(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO){
		this.spcFcastOfcPolMapgVO = spcFcastOfcPolMapgVO;
	}

	public void setSpcFcastOfcPolMapgVOS(SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVOs){
		if(spcFcastOfcPolMapgVOs != null){
			SpcFcastOfcPolMapgVO[] tmpVOs = Arrays.copyOf(spcFcastOfcPolMapgVOs, spcFcastOfcPolMapgVOs.length);
			this.spcFcastOfcPolMapgVOs  = tmpVOs;
		}
	}
	
	public void setSpcIrrFcastOfcPolMapgVOS(SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVOs){
		if(spcIrrFcastOfcPolMapgVOs != null){
			SpcIrrFcastOfcPolMapgVO[] tmpVOs = Arrays.copyOf(spcIrrFcastOfcPolMapgVOs, spcIrrFcastOfcPolMapgVOs.length);
			this.spcIrrFcastOfcPolMapgVOs  = tmpVOs;
		}
	}

	public SpcFcastOfcPolMapgVO getSpcFcastOfcPolMapgVO(){
		return spcFcastOfcPolMapgVO;
	}

	public SpcFcastOfcPolMapgVO[] getSpcFcastOfcPolMapgVOS(){
		SpcFcastOfcPolMapgVO[] rtnVOs = null;
		if (this.spcFcastOfcPolMapgVOs != null) {
			rtnVOs = Arrays.copyOf(spcFcastOfcPolMapgVOs, spcFcastOfcPolMapgVOs.length);
		}
		return rtnVOs;
	}
	
	public SpcIrrFcastOfcPolMapgVO[] getSpcIrrFcastOfcPolMapgVOS(){
		SpcIrrFcastOfcPolMapgVO[] rtnVOs = null;
		if (this.spcIrrFcastOfcPolMapgVOs != null) {
			rtnVOs = Arrays.copyOf(spcIrrFcastOfcPolMapgVOs, spcIrrFcastOfcPolMapgVOs.length);
		}
		return rtnVOs;
	}

	public SpcFcastOfcPolMapgConditionVO getSpcFcastOfcPolMapgConditionVO() {
		return spcFcastOfcPolMapgConditionVO;
	}

	public void setSpcFcastOfcPolMapgConditionVO(SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO) {
		this.spcFcastOfcPolMapgConditionVO = spcFcastOfcPolMapgConditionVO;
	}

	public SearchDailyForcastManageByVvdListConditionVO getSearchDailyForcastManageByVvdListConditionVO() {
		return searchDailyForcastManageByVvdListConditionVO;
	}

	public void setSearchDailyForcastManageByVvdListConditionVO(SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO) {
		this.searchDailyForcastManageByVvdListConditionVO = searchDailyForcastManageByVvdListConditionVO;
	}

	public SpcIrrFcastOfcPolMapgVO getSpcIrrFcastOfcPolMapgVO() {
		return spcIrrFcastOfcPolMapgVO;
	}

	public void setSpcIrrFcastOfcPolMapgVO(SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO) {
		this.spcIrrFcastOfcPolMapgVO = spcIrrFcastOfcPolMapgVO;
	}

	public SpcIrrFcastOfcPolMapgVO[] getSpcIrrFcastOfcPolMapgVOs() {
		SpcIrrFcastOfcPolMapgVO[] rtnVOs = null;
		if (this.spcIrrFcastOfcPolMapgVOs != null) {
			rtnVOs = Arrays.copyOf(spcIrrFcastOfcPolMapgVOs, spcIrrFcastOfcPolMapgVOs.length);
		}
		return rtnVOs;
	}

	public void setSpcIrrFcastOfcPolMapgVOs(SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVOs) {
		if(spcIrrFcastOfcPolMapgVOs != null){
			SpcIrrFcastOfcPolMapgVO[] tmpVOs = Arrays.copyOf(spcIrrFcastOfcPolMapgVOs, spcIrrFcastOfcPolMapgVOs.length);
			this.spcIrrFcastOfcPolMapgVOs  = tmpVOs;
		}
	}

}