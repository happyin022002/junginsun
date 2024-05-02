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
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;



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

	private String pgmNo = "";
	private String rptInfoCtnt = "";
	
	private String costDiv = "";
	private String[] coldesc1;
	private String[] coldesc2;

	private String[] chk;
	private String[] chk2;
	
	public String[] getChk() {
		String[] rtnVOs = null;
		if (this.chk != null) {
			rtnVOs = Arrays.copyOf(chk, chk.length);
		}
		return rtnVOs;
	}
	public void setChk(String[] chk) {
		if(chk != null){
			String[] tmpVOs = Arrays.copyOf(chk, chk.length);
			this.chk = tmpVOs;
		}
	}
	public String[] getChk2() {
		String[] rtnVOs = null;
		if (this.chk2 != null) {
			rtnVOs = Arrays.copyOf(chk2, chk2.length);
		}
		return rtnVOs;
	}
	public void setChk2(String[] chk2) {
		if(chk2 != null){
			String[] tmpVOs = Arrays.copyOf(chk2, chk2.length);
			this.chk2 = tmpVOs;
		}
	}
	public String[] getColdesc1() {
		String[] rtnVOs = null;
		if (this.coldesc1 != null) {
			rtnVOs = Arrays.copyOf(coldesc1, coldesc1.length);
		}
		return rtnVOs;
	}
	public void setColdesc1(String[] coldesc1) {
		if(coldesc1 != null){
			String[] tmpVOs = Arrays.copyOf(coldesc1, coldesc1.length);
			this.coldesc1 = tmpVOs;
		}
	}
	public String[] getColdesc2() {
		String[] rtnVOs = null;
		if (this.coldesc2 != null) {
			rtnVOs = Arrays.copyOf(coldesc2, coldesc2.length);
		}
		return rtnVOs;
	}
	public void setColdesc2(String[] coldesc2) {
		if(coldesc2 != null){
			String[] tmpVOs = Arrays.copyOf(coldesc2, coldesc2.length);
			this.coldesc2 = tmpVOs;
		}
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
	
	/**
	 * @return the pgmNo
	 */
	public String getPgmNo() {
		return pgmNo;
	}
	/**
	 * @param pgmNo the pgmNo to set
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	/**
	 * @return the rptInfoCtnt
	 */
	public String getRptInfoCtnt() {
		return rptInfoCtnt;
	}
	/**
	 * @param rptInfoCtnt the rptInfoCtnt to set
	 */
	public void setRptInfoCtnt(String rptInfoCtnt) {
		this.rptInfoCtnt = rptInfoCtnt;
	}	
	
}
