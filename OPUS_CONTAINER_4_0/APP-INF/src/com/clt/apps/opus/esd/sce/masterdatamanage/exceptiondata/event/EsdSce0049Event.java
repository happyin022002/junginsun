/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0049Event.java
*@FileTitle : Exception Type & Subscriber Group Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2007-03-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiSubGrpMappingVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdSce0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JeongSeon An
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0049Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 생성자1 */
	public EsdSce0049Event(){}

	private SearchExptTPListVO exptTpList = null;
	private SearchExptDTLTPListVO exptDtlTpList = null;
	private SearchExpInfoVO expInfo = null;
	private SearchToleranceInfoVO tolInfo = null;
	private SearchSubscriberGroupMappingVO subGrpMap = null;
	private SearchMultiSubGrpMappingVO[] multiMaps = null;

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
	public SearchSubscriberGroupMappingVO getSubGrpMap() {
		return subGrpMap;
	}
	public void setSubGrpMap(SearchSubscriberGroupMappingVO subGrpMap) {
		this.subGrpMap = subGrpMap;
	}
	public SearchMultiSubGrpMappingVO[] getMultiMaps() {
		SearchMultiSubGrpMappingVO[] rtnVOs = null;
		if (this.multiMaps != null) {
			rtnVOs = Arrays.copyOf(multiMaps, multiMaps.length);
		}
		return rtnVOs;
	}
	public void setMultiMaps(SearchMultiSubGrpMappingVO[] multiMaps) {
		if(multiMaps != null){
			SearchMultiSubGrpMappingVO[] tmpVOs = Arrays.copyOf(multiMaps, multiMaps.length);
			this.multiMaps = tmpVOs;
		}
	}
	
}
