/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SwapCstGRPVO.java
*@FileTitle : SwapCstGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.06.22 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadWgtGRPVO {

	private static final long serialVersionUID = 1L;
	
	private LoadWgtVO loadWgtVO = null;
	private LoadWgtVO[] loadWgtVOs = null;
	private List<LoadWgtVO> loadWgtVOList = null;
	
	private String vslClass = null;
	private String lightShip = null;
	private String fuelOil = null;
	private String dieselOil = null;
	private String freshWater = null;
	private String ballast = null;
	private String draft = null;
	private String tpc = null;
	private String displacement = null;
	private String constant = null;
	private String cargoWeight = null;
	
	private String[] vslClasss = null;
	private String[] lightShips = null;
	private String[] fuelOils = null;
	private String[] dieselOils = null;
	private String[] freshWaters = null;
	private String[] ballasts = null;
	private String[] drafts = null;
	private String[] tpcs = null;
	private String[] displacements = null;
	private String[] constants = null;
	private String[] cargoWeights = null;
	
	
	public LoadWgtGRPVO() {}

	/**
	 * @return the loadWgtVO
	 */
	public LoadWgtVO getLoadWgtVO() {
		return loadWgtVO;
	}

	/**
	 * @param loadWgtVO the loadWgtVO to set
	 */
	public void setLoadWgtVO(LoadWgtVO loadWgtVO) {
		this.loadWgtVO = loadWgtVO;
	}

	/**
	 * @return the vslClass
	 */
	public String getVslClass() {
		return vslClass;
	}

	/**
	 * @param vslClass the vslClass to set
	 */
	public void setVslClass(String vslClass) {
		this.vslClass = vslClass;
	}

	/**
	 * @return the lightShip
	 */
	public String getLightShip() {
		return lightShip;
	}

	/**
	 * @param lightShip the lightShip to set
	 */
	public void setLightShip(String lightShip) {
		this.lightShip = lightShip;
	}

	/**
	 * @return the loadWgtVOs
	 */
	public LoadWgtVO[] getLoadWgtVOs() {
		return loadWgtVOs;
	}

	/**
	 * @param loadWgtVOs the loadWgtVOs to set
	 */
	public void setLoadWgtVOs(LoadWgtVO[] loadWgtVOs) {
		this.loadWgtVOs = loadWgtVOs;
	}

	/**
	 * @return the vslClasss
	 */
	public String[] getVslClasss() {
		return vslClasss;
	}

	/**
	 * @param vslClasss the vslClasss to set
	 */
	public void setVslClasss(String[] vslClasss) {
		this.vslClasss = vslClasss;
	}

	/**
	 * @return the lightShips
	 */
	public String[] getLightShips() {
		return lightShips;
	}

	/**
	 * @param lightShips the lightShips to set
	 */
	public void setLightShips(String[] lightShips) {
		this.lightShips = lightShips;
	}

	/**
	 * @return the fuelOil
	 */
	public String getFuelOil() {
		return fuelOil;
	}

	/**
	 * @param fuelOil the fuelOil to set
	 */
	public void setFuelOil(String fuelOil) {
		this.fuelOil = fuelOil;
	}

	/**
	 * @return the dieselOil
	 */
	public String getDieselOil() {
		return dieselOil;
	}

	/**
	 * @param dieselOil the dieselOil to set
	 */
	public void setDieselOil(String dieselOil) {
		this.dieselOil = dieselOil;
	}

	/**
	 * @return the freshWater
	 */
	public String getFreshWater() {
		return freshWater;
	}

	/**
	 * @param freshWater the freshWater to set
	 */
	public void setFreshWater(String freshWater) {
		this.freshWater = freshWater;
	}

	/**
	 * @return the ballast
	 */
	public String getBallast() {
		return ballast;
	}

	/**
	 * @param ballast the ballast to set
	 */
	public void setBallast(String ballast) {
		this.ballast = ballast;
	}

	/**
	 * @return the fuelOils
	 */
	public String[] getFuelOils() {
		return fuelOils;
	}

	/**
	 * @param fuelOils the fuelOils to set
	 */
	public void setFuelOils(String[] fuelOils) {
		this.fuelOils = fuelOils;
	}

	/**
	 * @return the dieselOils
	 */
	public String[] getDieselOils() {
		return dieselOils;
	}

	/**
	 * @param dieselOils the dieselOils to set
	 */
	public void setDieselOils(String[] dieselOils) {
		this.dieselOils = dieselOils;
	}

	/**
	 * @return the freshWaters
	 */
	public String[] getFreshWaters() {
		return freshWaters;
	}

	/**
	 * @param freshWaters the freshWaters to set
	 */
	public void setFreshWaters(String[] freshWaters) {
		this.freshWaters = freshWaters;
	}

	/**
	 * @return the ballasts
	 */
	public String[] getBallasts() {
		return ballasts;
	}

	/**
	 * @param ballasts the ballasts to set
	 */
	public void setBallasts(String[] ballasts) {
		this.ballasts = ballasts;
	}

	/**
	 * @return the draft
	 */
	public String getDraft() {
		return draft;
	}

	/**
	 * @param draft the draft to set
	 */
	public void setDraft(String draft) {
		this.draft = draft;
	}

	/**
	 * @return the drafts
	 */
	public String[] getDrafts() {
		return drafts;
	}

	/**
	 * @param drafts the drafts to set
	 */
	public void setDrafts(String[] drafts) {
		this.drafts = drafts;
	}

	/**
	 * @return the tpc
	 */
	public String getTpc() {
		return tpc;
	}

	/**
	 * @param tpc the tpc to set
	 */
	public void setTpc(String tpc) {
		this.tpc = tpc;
	}

	/**
	 * @return the displacement
	 */
	public String getDisplacement() {
		return displacement;
	}

	/**
	 * @param displacement the displacement to set
	 */
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	/**
	 * @return the tpcs
	 */
	public String[] getTpcs() {
		return tpcs;
	}

	/**
	 * @param tpcs the tpcs to set
	 */
	public void setTpcs(String[] tpcs) {
		this.tpcs = tpcs;
	}

	/**
	 * @return the displacements
	 */
	public String[] getDisplacements() {
		return displacements;
	}

	/**
	 * @param displacements the displacements to set
	 */
	public void setDisplacements(String[] displacements) {
		this.displacements = displacements;
	}

	/**
	 * @return the loadWgtVOList
	 */
	public List<LoadWgtVO> getLoadWgtVOList() {
		return loadWgtVOList;
	}

	/**
	 * @param loadWgtVOList the loadWgtVOList to set
	 */
	public void setLoadWgtVOList(List<LoadWgtVO> loadWgtVOList) {
		this.loadWgtVOList = loadWgtVOList;
	}

	/**
	 * @return the constant
	 */
	public String getConstant() {
		return constant;
	}

	/**
	 * @param constant the constant to set
	 */
	public void setConstant(String constant) {
		this.constant = constant;
	}

	/**
	 * @return the constants
	 */
	public String[] getConstants() {
		return constants;
	}

	/**
	 * @param constants the constants to set
	 */
	public void setConstants(String[] constants) {
		this.constants = constants;
	}

	/**
	 * @return the cargoWeight
	 */
	public String getCargoWeight() {
		return cargoWeight;
	}

	/**
	 * @param cargoWeight the cargoWeight to set
	 */
	public void setCargoWeight(String cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	/**
	 * @return the cargoWeights
	 */
	public String[] getCargoWeights() {
		return cargoWeights;
	}

	/**
	 * @param cargoWeights the cargoWeights to set
	 */
	public void setCargoWeights(String[] cargoWeights) {
		this.cargoWeights = cargoWeights;
	}
	
}
