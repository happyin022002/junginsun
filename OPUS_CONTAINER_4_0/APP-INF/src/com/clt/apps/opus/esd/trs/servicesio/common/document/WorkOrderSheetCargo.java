/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetList.java
*@FileTitle : WorkOrderSheetList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_006Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_006EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetCargo {
	/** (Param 객체) */

	private	String awkward					= "";	
	private	int awkwardSeq				= 0;	
	private	String awkwardEqNo			= "";	
	private	String awkwardLength			= "";	
	private	String awkwardWidth			= "";	
	private	String awkwardVoid			= "";	
	
	private	String reefer						= "";	
	private	int reeferSeq					= 0;	
	private	String reeferEqNo				= "";	
	private	String reeferTemperatureC	= "";	
	private	String reeferTemperatureF	= "";	
	private	String reeferVentilation		= "";	
	
	private	String dg							= "";	
	private	int dgSeq						= 0;	
	private	String dgEqNo					= "";	
	private	String dgHCDG					= "";	
	private	String dgUnNo					= "";	
	private	String dgIMOClass				= "";	
	private	String dgSubLabel				= "";	
	private	String dgFlashPoint				= "";	
	private	String dgPackageGroup		= "";	
	private	String dgPropShipName		= "";	
	private	String dgHAZContents			= "";	
	private	String dgOuterPkgQtyType	= "";	
	private	String dgInnerPkgQtyType	= "";	
	private	String dgGrossNetWeight		= "";
	/**
	 * @return awkward을 리턴합니다.
	 */
	public String getAwkward() {
		return awkward;
	}
	/**
	 * @param awkward 설정하려는 awkward입니다.
	 */
	public void setAwkward(String awkward) {
		this.awkward = awkward;
	}
	/**
	 * @return awkwardEqNo을 리턴합니다.
	 */
	public String getAwkwardEqNo() {
		return awkwardEqNo;
	}
	/**
	 * @param awkwardEqNo 설정하려는 awkwardEqNo입니다.
	 */
	public void setAwkwardEqNo(String awkwardEqNo) {
		this.awkwardEqNo = awkwardEqNo;
	}
	/**
	 * @return awkwardLength을 리턴합니다.
	 */
	public String getAwkwardLength() {
		return awkwardLength;
	}
	/**
	 * @param awkwardLength 설정하려는 awkwardLength입니다.
	 */
	public void setAwkwardLength(String awkwardLength) {
		this.awkwardLength = awkwardLength;
	}
	/**
	 * @return awkwardSeq을 리턴합니다.
	 */
	public int getAwkwardSeq() {
		return awkwardSeq;
	}
	/**
	 * @param awkwardSeq 설정하려는 awkwardSeq입니다.
	 */
	public void setAwkwardSeq(int awkwardSeq) {
		this.awkwardSeq = awkwardSeq;
	}
	/**
	 * @return awkwardVoid을 리턴합니다.
	 */
	public String getAwkwardVoid() {
		return awkwardVoid;
	}
	/**
	 * @param awkwardVoid 설정하려는 awkwardVoid입니다.
	 */
	public void setAwkwardVoid(String awkwardVoid) {
		this.awkwardVoid = awkwardVoid;
	}
	/**
	 * @return awkwardWidth을 리턴합니다.
	 */
	public String getAwkwardWidth() {
		return awkwardWidth;
	}
	/**
	 * @param awkwardWidth 설정하려는 awkwardWidth입니다.
	 */
	public void setAwkwardWidth(String awkwardWidth) {
		this.awkwardWidth = awkwardWidth;
	}
	/**
	 * @return dg을 리턴합니다.
	 */
	public String getDg() {
		return dg;
	}
	/**
	 * @param dg 설정하려는 dg입니다.
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	/**
	 * @return dgEqNo을 리턴합니다.
	 */
	public String getDgEqNo() {
		return dgEqNo;
	}
	/**
	 * @param dgEqNo 설정하려는 dgEqNo입니다.
	 */
	public void setDgEqNo(String dgEqNo) {
		this.dgEqNo = dgEqNo;
	}
	/**
	 * @return dgFlashPoint을 리턴합니다.
	 */
	public String getDgFlashPoint() {
		return dgFlashPoint;
	}
	/**
	 * @param dgFlashPoint 설정하려는 dgFlashPoint입니다.
	 */
	public void setDgFlashPoint(String dgFlashPoint) {
		this.dgFlashPoint = dgFlashPoint;
	}
	/**
	 * @return dgGrossNetWeight을 리턴합니다.
	 */
	public String getDgGrossNetWeight() {
		return dgGrossNetWeight;
	}
	/**
	 * @param dgGrossNetWeight 설정하려는 dgGrossNetWeight입니다.
	 */
	public void setDgGrossNetWeight(String dgGrossNetWeight) {
		this.dgGrossNetWeight = dgGrossNetWeight;
	}
	/**
	 * @return dgHAZContents을 리턴합니다.
	 */
	public String getDgHAZContents() {
		return dgHAZContents;
	}
	/**
	 * @param dgHAZContents 설정하려는 dgHAZContents입니다.
	 */
	public void setDgHAZContents(String dgHAZContents) {
		this.dgHAZContents = dgHAZContents;
	}
	/**
	 * @return dgHCDG을 리턴합니다.
	 */
	public String getDgHCDG() {
		return dgHCDG;
	}
	/**
	 * @param dgHCDG 설정하려는 dgHCDG입니다.
	 */
	public void setDgHCDG(String dgHCDG) {
		this.dgHCDG = dgHCDG;
	}
	/**
	 * @return dgIMOClass을 리턴합니다.
	 */
	public String getDgIMOClass() {
		return dgIMOClass;
	}
	/**
	 * @param dgIMOClass 설정하려는 dgIMOClass입니다.
	 */
	public void setDgIMOClass(String dgIMOClass) {
		this.dgIMOClass = dgIMOClass;
	}
	/**
	 * @return dgInnerPkgQtyType을 리턴합니다.
	 */
	public String getDgInnerPkgQtyType() {
		return dgInnerPkgQtyType;
	}
	/**
	 * @param dgInnerPkgQtyType 설정하려는 dgInnerPkgQtyType입니다.
	 */
	public void setDgInnerPkgQtyType(String dgInnerPkgQtyType) {
		this.dgInnerPkgQtyType = dgInnerPkgQtyType;
	}
	/**
	 * @return dgOuterPkgQtyType을 리턴합니다.
	 */
	public String getDgOuterPkgQtyType() {
		return dgOuterPkgQtyType;
	}
	/**
	 * @param dgOuterPkgQtyType 설정하려는 dgOuterPkgQtyType입니다.
	 */
	public void setDgOuterPkgQtyType(String dgOuterPkgQtyType) {
		this.dgOuterPkgQtyType = dgOuterPkgQtyType;
	}
	/**
	 * @return dgPackageGroup을 리턴합니다.
	 */
	public String getDgPackageGroup() {
		return dgPackageGroup;
	}
	/**
	 * @param dgPackageGroup 설정하려는 dgPackageGroup입니다.
	 */
	public void setDgPackageGroup(String dgPackageGroup) {
		this.dgPackageGroup = dgPackageGroup;
	}
	/**
	 * @return dgPropShipName을 리턴합니다.
	 */
	public String getDgPropShipName() {
		return dgPropShipName;
	}
	/**
	 * @param dgPropShipName 설정하려는 dgPropShipName입니다.
	 */
	public void setDgPropShipName(String dgPropShipName) {
		this.dgPropShipName = dgPropShipName;
	}
	/**
	 * @return dgSeq을 리턴합니다.
	 */
	public int getDgSeq() {
		return dgSeq;
	}
	/**
	 * @param dgSeq 설정하려는 dgSeq입니다.
	 */
	public void setDgSeq(int dgSeq) {
		this.dgSeq = dgSeq;
	}
	/**
	 * @return dgSubLabel을 리턴합니다.
	 */
	public String getDgSubLabel() {
		return dgSubLabel;
	}
	/**
	 * @param dgSubLabel 설정하려는 dgSubLabel입니다.
	 */
	public void setDgSubLabel(String dgSubLabel) {
		this.dgSubLabel = dgSubLabel;
	}
	/**
	 * @return dgUnNo을 리턴합니다.
	 */
	public String getDgUnNo() {
		return dgUnNo;
	}
	/**
	 * @param dgUnNo 설정하려는 dgUnNo입니다.
	 */
	public void setDgUnNo(String dgUnNo) {
		this.dgUnNo = dgUnNo;
	}
	/**
	 * @return reefer을 리턴합니다.
	 */
	public String getReefer() {
		return reefer;
	}
	/**
	 * @param reefer 설정하려는 reefer입니다.
	 */
	public void setReefer(String reefer) {
		this.reefer = reefer;
	}
	/**
	 * @return reeferEqNo을 리턴합니다.
	 */
	public String getReeferEqNo() {
		return reeferEqNo;
	}
	/**
	 * @param reeferEqNo 설정하려는 reeferEqNo입니다.
	 */
	public void setReeferEqNo(String reeferEqNo) {
		this.reeferEqNo = reeferEqNo;
	}
	/**
	 * @return reeferSeq을 리턴합니다.
	 */
	public int getReeferSeq() {
		return reeferSeq;
	}
	/**
	 * @param reeferSeq 설정하려는 reeferSeq입니다.
	 */
	public void setReeferSeq(int reeferSeq) {
		this.reeferSeq = reeferSeq;
	}
	/**
	 * @return reeferTemperatureC을 리턴합니다.
	 */
	public String getReeferTemperatureC() {
		return reeferTemperatureC;
	}
	/**
	 * @param reeferTemperatureC 설정하려는 reeferTemperatureC입니다.
	 */
	public void setReeferTemperatureC(String reeferTemperatureC) {
		this.reeferTemperatureC = reeferTemperatureC;
	}
	/**
	 * @return reeferTemperatureF을 리턴합니다.
	 */
	public String getReeferTemperatureF() {
		return reeferTemperatureF;
	}
	/**
	 * @param reeferTemperatureF 설정하려는 reeferTemperatureF입니다.
	 */
	public void setReeferTemperatureF(String reeferTemperatureF) {
		this.reeferTemperatureF = reeferTemperatureF;
	}
	/**
	 * @return reeferVentilation을 리턴합니다.
	 */
	public String getReeferVentilation() {
		return reeferVentilation;
	}
	/**
	 * @param reeferVentilation 설정하려는 reeferVentilation입니다.
	 */
	public void setReeferVentilation(String reeferVentilation) {
		this.reeferVentilation = reeferVentilation;
	}	


	

}
