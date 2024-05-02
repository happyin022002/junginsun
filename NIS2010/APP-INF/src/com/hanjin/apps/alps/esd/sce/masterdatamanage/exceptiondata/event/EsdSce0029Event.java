/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_EsdSce0029Event.java
*@FileTitle : Exception 식별 기준 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-04 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceMultiInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_EsdSce0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_EsdSce0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yongcheon_shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 *
 */
public class EsdSce0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    
    /**
     * 생성자<br>
     */
    public EsdSce0029Event() {
    	
    }
    
    private SearchExptTPListVO exptTpList = null;
    private SearchExptDTLTPListVO exptDtlTpList = null;
    private SearchExpInfoVO expInfo = null;
    private SearchToleranceInfoVO tolInfo = null;
    private SearchToleranceListVO tolList = null;
    private SearchToleranceMultiInfoVO[] multiInfos = null;

	public SearchExptTPListVO getExptTpList() {
		return exptTpList;
	}

	public void setExptTpList(SearchExptTPListVO exptTpList) {
		this.exptTpList = exptTpList;
	}

	public SearchExptDTLTPListVO getExptDtlTpList() {
		return exptDtlTpList;
	}

	public void setExptDtlTpList(SearchExptDTLTPListVO exptDtlTpList) {
		this.exptDtlTpList = exptDtlTpList;
	}

	public SearchExpInfoVO getExpInfo() {
		return expInfo;
	}

	public void setExpInfo(SearchExpInfoVO expInfo) {
		this.expInfo = expInfo;
	}

	public SearchToleranceInfoVO getTolInfo() {
		return tolInfo;
	}

	public void setTolInfo(SearchToleranceInfoVO tolInfo) {
		this.tolInfo = tolInfo;
	}

	public SearchToleranceListVO getTolList() {
		return tolList;
	}

	public void setTolList(SearchToleranceListVO tolList) {
		this.tolList = tolList;
	}

	public SearchToleranceMultiInfoVO[] getMultiInfos() {
		return multiInfos;
	}

	public void setMultiInfos(SearchToleranceMultiInfoVO[] multiInfos) {
		this.multiInfos = multiInfos;
	}

}
