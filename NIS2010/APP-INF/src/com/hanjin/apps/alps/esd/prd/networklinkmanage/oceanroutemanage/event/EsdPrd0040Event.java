/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0040Event.java
 *@FileTitle : OceanRoute Manual Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-25
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-25 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0040Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0040Event(){
	}
	private String row = null;
	private String col = null;

	/**
	 *
	 * @return
	 */
	public String getRow(){
		return row;
	}

	/**
	 *
	 * @param row
	 */
	public void setRow(String row){
		this.row = row;
	}

	/**
	 *
	 * @return
	 */
	public String getCol(){
		return col;
	}

	/**
	 *
	 * @param col
	 */
	public void setCol(String col){
		this.col = col;
	}

	/**
	 *
	 * @return
	 */
	public String getGubun(){
		return gubun;
	}

	/**
	 *
	 * @param gubun
	 */
	public void setGubun(String gubun){
		this.gubun = gubun;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanLaneVO getSearchOceanLaneVO(){
		return searchOceanLaneVO;
	}

	/**
	 *
	 * @param searchOceanLaneVO
	 */
	public void setSearchOceanLaneVO(SearchOceanLaneVO searchOceanLaneVO){
		this.searchOceanLaneVO = searchOceanLaneVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchOceanLaneVO[] getSearchOceanLaneVOs(){
		return searchOceanLaneVOs;
	}

	/**
	 *
	 * @param searchOceanLaneVOs
	 */
	public void setSearchOceanLaneVOs(SearchOceanLaneVO[] searchOceanLaneVOs){
		this.searchOceanLaneVOs = searchOceanLaneVOs;
	}
	private String gubun = null;
	private String sTsPort = null;
	private String isLastPod = null;

	/**
	 *
	 * @return
	 */
	public String getSTsPort(){
		return sTsPort;
	}

	/**
	 *
	 * @param tsPort
	 */
	public void setSTsPort(String tsPort){
		sTsPort = tsPort;
	}

	/**
	 *
	 * @return
	 */
	public String getIsLastPod(){
		return isLastPod;
	}

	/**
	 *
	 * @param isLastPod
	 */
	public void setIsLastPod(String isLastPod){
		this.isLastPod = isLastPod;
	}
	private SearchOceanLaneVO searchOceanLaneVO = null;
	private SearchOceanLaneVO[] searchOceanLaneVOs = null;

	/**
	 *
	 * @param arg1
	 * @return
	 */
	public String getString(String arg1){
		return "";
	}
}
