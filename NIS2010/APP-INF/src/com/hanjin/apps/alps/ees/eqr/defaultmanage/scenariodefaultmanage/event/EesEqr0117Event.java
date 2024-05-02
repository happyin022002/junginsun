/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0117Event.java
*@FileTitle : ssss
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrEccSftStkVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;


/**
 * EES_EQR_0117 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0117HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0117HTMLAction 참조
 * @since J2EE 1.6
 */


public class EesEqr0117Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSafetyStockVO searchSafetyStockVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public SearchSafetyStockVO[] searchSafetyStockVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0117ConditionVO eesEqr0117ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0117ConditionVO[] eesEqr0117ConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrEccSftStkVO eqrEccSftStkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrEccSftStkVO[] eqrEccSftStkVOs = null;

	
	private String loc = null;
	private String loctype = null; 
	private String tpze = null;
	private String tpsztype = null; 
	private String lvlcd = null;
	private String tpsztypes = null; 
	private String maxInfoTable = null;
	private String maxInfoCondition =null;

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * @return the loctype
	 */
	public String getLoctype() {
		return loctype;
	}

	/**
	 * @param loctype the loctype to set
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}

	/**
	 * @return the tpze
	 */
	public String getTpze() {
		return tpze;
	}

	/**
	 * @param tpze the tpze to set
	 */
	public void setTpze(String tpze) {
		this.tpze = tpze;
	}

	/**
	 * @return the tpsztype
	 */
	public String getTpsztype() {
		return tpsztype;
	}

	/**
	 * @param tpsztype the tpsztype to set
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}

	/**
	 * @return the lvlcd
	 */
	public String getLvlcd() {
		return lvlcd;
	}

	/**
	 * @param lvlcd the lvlcd to set
	 */
	public void setLvlcd(String lvlcd) {
		this.lvlcd = lvlcd;
	}

	/**
	 * @return the tpsztypes
	 */
	public String getTpsztypes() {
		return tpsztypes;
	}

	/**
	 * @param tpsztypes the tpsztypes to set
	 */
	public void setTpsztypes(String tpsztypes) {
		this.tpsztypes = tpsztypes;
	}

	/**
	 * @return the maxInfoTable
	 */
	public String getMaxInfoTable() {
		return maxInfoTable;
	}

	/**
	 * @param maxInfoTable the maxInfoTable to set
	 */
	public void setMaxInfoTable(String maxInfoTable) {
		this.maxInfoTable = maxInfoTable;
	}

	/**
	 * @return the maxInfoCondition
	 */
	public String getMaxInfoCondition() {
		return maxInfoCondition;
	}

	/**
	 * @param maxInfoCondition the maxInfoCondition to set
	 */
	public void setMaxInfoCondition(String maxInfoCondition) {
		this.maxInfoCondition = maxInfoCondition;
	}

	public EesEqr0117Event(){}

	/**
	 * @return the searchSafetyStockVO
	 */
	public SearchSafetyStockVO getSearchSafetyStockVO() {
		return searchSafetyStockVO;
	}

	/**
	 * @param searchSafetyStockVO the searchSafetyStockVO to set
	 */
	public void setSearchSafetyStockVO(SearchSafetyStockVO searchSafetyStockVO) {
		this.searchSafetyStockVO = searchSafetyStockVO;
	}

	/**
	 * @return the searchSafetyStockVOs
	 */
	public SearchSafetyStockVO[] getSearchSafetyStockVOs() {
		return searchSafetyStockVOs;
	}

	/**
	 * @param searchSafetyStockVOs the searchSafetyStockVOs to set
	 */
	public void setSearchSafetyStockVOs(SearchSafetyStockVO[] searchSafetyStockVOs) {
		this.searchSafetyStockVOs = searchSafetyStockVOs;
	}

	/**
	 * @return the eesEqr0117ConditionVO
	 */
	public EesEqr0117ConditionVO getEesEqr0117ConditionVO() {
		return eesEqr0117ConditionVO;
	}

	/**
	 * @param eesEqr0117ConditionVO the eesEqr0117ConditionVO to set
	 */
	public void setEesEqr0117ConditionVO(EesEqr0117ConditionVO eesEqr0117ConditionVO) {
		this.eesEqr0117ConditionVO = eesEqr0117ConditionVO;
	}

	/**
	 * @return the eesEqr0117ConditionVOs
	 */
	public EesEqr0117ConditionVO[] getEesEqr0117ConditionVOs() {
		return eesEqr0117ConditionVOs;
	}

	/**
	 * @param eesEqr0117ConditionVOs the eesEqr0117ConditionVOs to set
	 */
	public void setEesEqr0117ConditionVOs(
			EesEqr0117ConditionVO[] eesEqr0117ConditionVOs) {
		this.eesEqr0117ConditionVOs = eesEqr0117ConditionVOs;
	}

	/**
	 * @return the eqrEccSftStkVO
	 */
	public EqrEccSftStkVO getEqrEccSftStkVO() {
		return eqrEccSftStkVO;
	}

	/**
	 * @param eqrEccSftStkVO the eqrEccSftStkVO to set
	 */
	public void setEqrEccSftStkVO(EqrEccSftStkVO eqrEccSftStkVO) {
		this.eqrEccSftStkVO = eqrEccSftStkVO;
	}

	/**
	 * @return the eqrEccSftStkVOs
	 */
	public EqrEccSftStkVO[] getEqrEccSftStkVOs() {
		return eqrEccSftStkVOs;
	}

	/**
	 * @param eqrEccSftStkVOs the eqrEccSftStkVOs to set
	 */
	public void setEqrEccSftStkVOs(EqrEccSftStkVO[] eqrEccSftStkVOs) {
		this.eqrEccSftStkVOs = eqrEccSftStkVOs;
	}
	

}
