/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0112Event.java
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiExpOfcInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdSce0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 2007811
 * @see HTMLAction 참조
 * @since J2EE 1.4
 * 
 */
public class EsdSce0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    
    /**
     * 생성자
     */
    public EsdSce0112Event(){}

    private SearchExpmasterOfcInfoVO expMastOfc = null;
    private SearchExpMasterOfcListVO expMastOfcList = null;
    private SearchExpMapgOfcListVO expMapgOfc = null;
    private SearchExpMapgOfcList3VO expMapgOfc3 = null;
    private SearchMultiExpOfcInfoVO[] multiInfos = null;

	public SearchExpmasterOfcInfoVO getExpMastOfc() {
		return expMastOfc;
	}

	public void setExpMastOfc(SearchExpmasterOfcInfoVO expMastOfc) {
		this.expMastOfc = expMastOfc;
	}

	public SearchExpMasterOfcListVO getExpMastOfcList() {
		return expMastOfcList;
	}

	public void setExpMastOfcList(SearchExpMasterOfcListVO expMastOfcList) {
		this.expMastOfcList = expMastOfcList;
	}

	public SearchExpMapgOfcListVO getExpMapgOfc() {
		return expMapgOfc;
	}

	public void setExpMapgOfc(SearchExpMapgOfcListVO expMapgOfc) {
		this.expMapgOfc = expMapgOfc;
	}

	public SearchExpMapgOfcList3VO getExpMapgOfc3() {
		return expMapgOfc3;
	}

	public void setExpMapgOfc3(SearchExpMapgOfcList3VO expMapgOfc3) {
		this.expMapgOfc3 = expMapgOfc3;
	}

	public SearchMultiExpOfcInfoVO[] getMultiInfos() {
		SearchMultiExpOfcInfoVO[] rtnVOs = null;
		if (this.multiInfos != null) {
			rtnVOs = Arrays.copyOf(multiInfos, multiInfos.length);
		}
		return rtnVOs;
	}

	public void setMultiInfos(SearchMultiExpOfcInfoVO[] multiInfos) {
		if(multiInfos != null){
			SearchMultiExpOfcInfoVO[] tmpVOs = Arrays.copyOf(multiInfos, multiInfos.length);
			this.multiInfos = tmpVOs;
		}
	}

}
