/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0056Event.java
*@FileTitle : Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
* 2012.02.22 채창호 [CHM-201115166-01]:Split 01-US Inland Operation Report 내, 324 EDI 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * EsdSce0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author Jeong-Seon An , Yoon-Jung Lee 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdSce0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String costDiv = "";
	private String[] coldesc1;
	private String[] coldesc2;

	private String[] chk;
	private String[] chk2;
	
	public String[] getChk() {
		return chk;
	}
	public void setChk(String[] chk) {
		this.chk = chk;
	}
	public String[] getChk2() {
		return chk2;
	}
	public void setChk2(String[] chk2) {
		this.chk2 = chk2;
	}
	public String[] getColdesc1() {
		return coldesc1;
	}
	public void setColdesc1(String[] coldesc1) {
		this.coldesc1 = coldesc1;
	}
	public String[] getColdesc2() {
		return coldesc2;
	}
	public void setColdesc2(String[] coldesc2) {
		this.coldesc2 = coldesc2;
	}

	/*
	 * 생성자
	 */
	public EsdSce0056Event(){}
	
	private SearchUSIORInfoVO searchUSIORInfo = null;
	private SearchUSIORListVO searchUSIORList = null;
	private SearchEdi324SendVO searchEdi324SendVO = null;
	
	public SearchUSIORInfoVO getSearchUSIORInfo() {
		return searchUSIORInfo;
	}
	public void setSearchUSIORInfo(SearchUSIORInfoVO searchUSIORInfo) {
		this.searchUSIORInfo = searchUSIORInfo;
	}
	public SearchUSIORListVO getSearchUSIORList() {
		return searchUSIORList;
	}
	public void setSearchUSIORList(SearchUSIORListVO searchUSIORList) {
		this.searchUSIORList = searchUSIORList;
	}
	/**
	 * @return the costDiv
	 */
	public String getCostDiv() {
		return costDiv;
	}
	/**
	 * @param costDiv the costDiv to set
	 */
	public void setCostDiv(String costDiv) {
		this.costDiv = costDiv;
	}
	/** SearchEdi324SendVO setter 함수
	 * @param edi324SendVO SearchEdi324SendVO 
	 * @return 
	 * @throws
	 */	
	public void setSearchEdi324SendVO(SearchEdi324SendVO searchEdi324SendVO){
		this.searchEdi324SendVO = searchEdi324SendVO;
	}
	/** SearchEdi324SendVO getter 함수
	 * @param 
	 * @return SearchEdi324SendVO
	 * @throws
	 */		
	public SearchEdi324SendVO getSearchEdi324SendVO(){
		return this.searchEdi324SendVO;
	}
	
	List<SearchEdi324SendVO> searchEdi324SendVOs = null;
	/** List<SearchEdi324SendVO>  getter 함수
	 * @param 
	 * @return List<SearchEdi324SendVO> 
	 * @throws
	 */		
	public List<SearchEdi324SendVO> getSearchEdi324SendVOs(){
		 return this.searchEdi324SendVOs;
	}
	/** List<SearchEdi324SendVO> edi324SendVOs  setter 함수
	 * @param edi324SendVOs List<SearchEdi324SendVO> 
	 * @return 
	 * @throws
	 */		
	public void setSearchEdi324SendVOs(List<SearchEdi324SendVO> searchEdi324SendVOs){
		this.searchEdi324SendVOs = searchEdi324SendVOs;
	}
}
