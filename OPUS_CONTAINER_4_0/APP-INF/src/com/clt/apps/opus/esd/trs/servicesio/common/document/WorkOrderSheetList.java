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

import org.apache.commons.lang.StringEscapeUtils;


/**
 * EXP_PAP_006Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_006EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetList {

	/** (Param 객체) */

	private	int seq								= 0;	          
	private	String equipmentNumber				= "";	          
	private	String typeSize						= "";	          
	private	String rate							= "";	          
	private	String specialCargo					= "";	          
	private	String weight						= "";	          
	private	String detain						= "";	          
	private	String commodityDescription			= "";	          
	private	String inbondTransitNumber			= "";	          
	private	String bNumberIssue					= "";	          
	private	String purchaseOrderNo				= "";	          
	private	String sealNo1						= "";	          
	private	String sealNo2						= "";	          
	private	String preDespatched				= "";	          
	private	String bookingNumber				= "";	          
	private	String billofLadingNumber			= "";	          
	private	String vesselVoyageCode				= "";	          
	private	String nextPort						= "";	          
	private	String shipperName					= "";	          
	private	String shipperTelephone				= "";	          
	private	String doorServiceType				= "";	          
	private	String pickupNo						= "";	          
	private	String availableDate				= "";	          
	private	String lastFreeDate					= "";	          
	private	String customsClearNumber			= "";	          
	private	String expDepTimeFromLocation		= "";	          
	private	String expArriTimeToLocation		= "";	          
	private	String doorArriAppTime				= "";	          
	private	String usaLastCity					= "";	          
	private	String multiStopLocAppTime			= "";	          
	private	String multiStopLocAppTime1			= "";	          
	private	String multiStopLocAppTime2			= "";	          
	private	String multiStopLocAppTime3			= "";	          
	private	String multiStopLocAppTime4			= "";	          
	private	String multiStopLocAppTime5			= "";	          
	private	String remark						= "";	          
	private	String quantity						= "";    //combined case II type3 : CY + CY MTY  
	private String blockStwg					= "";
	private String soDelCode					= "";

	private String railReceivingDateFM			= "";
	private String railReceivingDateTO			= "";
	private String troLodRefNo					= "";

	//sheet 2 page
	public int getSeq							() {		return seq							;	}
	public String getEquipmentNumber			() {		return equipmentNumber				;	}
	public String getTypeSize					() {		return typeSize						;	}
	public String getRate						() {		return rate							;	}
	public String getSpecialCargo				() {		return specialCargo					;	}
	public String getWeight						() {		return weight						;	}
	public String getDetain						() {		return detain						;	}
	public String getCommodityDescription		() {		return commodityDescription			;	}
	public String getInbondTransitNumber		() {		return inbondTransitNumber			;	}
	public String getBNumberIssue				() {		return bNumberIssue					;	}
	public String getPurchaseOrderNo			() {		return purchaseOrderNo				;	}
	public String getSealNo1						() {		return sealNo1						;	}
	public String getSealNo2						() {		return sealNo2						;	}
	public String getPreDespatched				() {		return preDespatched				;	}
	public String getBookingNumber				() {		return bookingNumber				;	}
	public String getBillofLadingNumber			() {		return billofLadingNumber			;	}
	public String getVesselVoyageCode			() {		return vesselVoyageCode				;	}
	public String getNextPort					() {		return nextPort						;	}
	public String getShipperName				() {		return shipperName					;	}
	public String getShipperTelephone			() {		return shipperTelephone				;	}
	public String getDoorServiceType			() {		return doorServiceType				;	}
	public String getPickupNo					() {		return pickupNo						;	}
	public String getAvailableDate				() {		return availableDate				;	}
	public String getLastFreeDate				() {		return lastFreeDate					;	}
	public String getCustomsClearNumber			() {		return customsClearNumber			;	}
	public String getExpDepTimeFromLocation		() {		return expDepTimeFromLocation		;	}
	public String getExpArriTimeToLocation		() {		return expArriTimeToLocation		;	}
	public String getDoorArriAppTime			() {		return doorArriAppTime				;	}
	public String getUsaLastCity				() {		return usaLastCity					;	}
	public String getMultiStopLocAppTime		() {		return multiStopLocAppTime			;	}
	public String getRemark						() {		return remark						;	}
	public String getQuantity					() {		return quantity						;	}
	public String getMultiStopLocAppTime1		() {		return multiStopLocAppTime1			;	}
	public String getMultiStopLocAppTime2		() {		return multiStopLocAppTime2			;	}
	public String getMultiStopLocAppTime3		() {		return multiStopLocAppTime3			;	}
	public String getMultiStopLocAppTime4		() {		return multiStopLocAppTime4			;	}
	public String getMultiStopLocAppTime5		() {		return multiStopLocAppTime5			;	}
	public String getBlockStwg					() {		return blockStwg					;	}
	public String getSoDelCode					() {		return soDelCode					;	}



	public void	setSeq							(int	Seq								) {		this.seq							= Seq						;	}                  
	public void	setEquipmentNumber				(String	EquipmentNumber					) {		this.equipmentNumber				= EquipmentNumber			;	}                  
	public void	setTypeSize						(String	TypeSize						) {		this.typeSize						= TypeSize					;	}                  
	public void	setRate							(String	Rate							) {		this.rate							= Rate						;	}                  
	public void	setSpecialCargo					(String	SpecialCargo					) {		this.specialCargo					= SpecialCargo				;	}                  
	public void	setWeight						(String	Weight							) {		this.weight							= Weight					;	}                  
	public void	setDetain						(String	Detain							) {		this.detain							= Detain					;	}                  
	public void	setCommodityDescription			(String	CommodityDescription			) {		this.commodityDescription			= CommodityDescription		;	}                  
	public void	setInbondTransitNumber			(String	InbondTransitNumber				) {		this.inbondTransitNumber			= InbondTransitNumber		;	}                  
	public void	setBNumberIssue					(String	BNumberIssue					) {		this.bNumberIssue					= BNumberIssue				;	}                  
	public void	setPurchaseOrderNo				(String	PurchaseOrderNo					) {		this.purchaseOrderNo				= PurchaseOrderNo			;	}                  
	public void	setSealNo1						(String	SealNo1							) {		this.sealNo1							= SealNo1					;	}                  
	public void	setSealNo2						(String	SealNo2							) {		this.sealNo2							= SealNo2					;	}                  
	public void	setPreDespatched				(String	PreDespatched					) {		this.preDespatched					= PreDespatched				;	}                  
	public void	setBookingNumber				(String	BookingNumber					) {		this.bookingNumber					= BookingNumber				;	}                  
	public void	setBillofLadingNumber			(String	BillofLadingNumber				) {		this.billofLadingNumber				= BillofLadingNumber		;	}                  
	public void	setVesselVoyageCode				(String	VesselVoyageCode				) {		this.vesselVoyageCode				= VesselVoyageCode			;	}                  
	public void	setNextPort						(String	NextPort						) {		this.nextPort						= NextPort					;	}                  
	public void	setShipperName					(String	ShipperName						) {		this.shipperName					= StringEscapeUtils.escapeXml(ShipperName)				;	}                  
	public void	setShipperTelephone				(String	ShipperTelephone				) {		this.shipperTelephone				= ShipperTelephone			;	}                  
	public void	setDoorServiceType				(String	DoorServiceType					) {		this.doorServiceType				= DoorServiceType			;	}                  
	public void	setPickupNo						(String	PickupNo						) {		this.pickupNo						= PickupNo					;	}                  
	public void	setAvailableDate				(String	AvailableDate					) {		this.availableDate					= AvailableDate				;	}                  
	public void	setLastFreeDate					(String	LastFreeDate					) {		this.lastFreeDate					= LastFreeDate				;	}                  
	public void	setCustomsClearNumber			(String	CustomsClearNumber				) {		this.customsClearNumber				= CustomsClearNumber		;	}                  
	public void	setExpDepTimeFromLocation		(String	ExpDepTimeFromLocation			) {		this.expDepTimeFromLocation			= ExpDepTimeFromLocation	;	}                  
	public void	setExpArriTimeToLocation		(String	ExpArriTimeToLocation			) {		this.expArriTimeToLocation			= ExpArriTimeToLocation		;	}                  
	public void	setDoorArriAppTime				(String	DoorArriAppTime					) {		this.doorArriAppTime				= DoorArriAppTime			;	}                  
	public void	setUsaLastCity					(String	UsaLastCity						) {		this.usaLastCity					= UsaLastCity				;	}                  
	public void	setMultiStopLocAppTime			(String	MultiStopLocAppTime				) {		this.multiStopLocAppTime			= MultiStopLocAppTime		;	}                  
	public void	setRemark						(String	Remark							) {		this.remark							= Remark					;	}                  
	public void	setQuantity						(String	Quantity						) {		this.quantity						= Quantity					;   }                 
	public void	setMultiStopLocAppTime1			(String	MultiStopLocAppTime1			) {		this.multiStopLocAppTime1			= MultiStopLocAppTime1		;	}                  
	public void	setMultiStopLocAppTime2			(String	MultiStopLocAppTime2			) {		this.multiStopLocAppTime2			= MultiStopLocAppTime2		;	}                  
	public void	setMultiStopLocAppTime3			(String	MultiStopLocAppTime3			) {		this.multiStopLocAppTime3			= MultiStopLocAppTime3		;	}                  
	public void	setMultiStopLocAppTime4			(String	MultiStopLocAppTime4			) {		this.multiStopLocAppTime4			= MultiStopLocAppTime4		;	}                  
	public void	setMultiStopLocAppTime5			(String	MultiStopLocAppTime5			) {		this.multiStopLocAppTime5			= MultiStopLocAppTime5		;	}                  
	public void	setBlockStwg					(String	BlockStwg						) {		this.blockStwg						= BlockStwg					;	}                  
	public void	setSoDelCode					(String	SoDelCode						) {		this.soDelCode						= SoDelCode					;	}
	
	public String getRailReceivingDateFM() {
		return railReceivingDateFM;
	}
	public void setRailReceivingDateFM(String railReceivingDateFM) {
		this.railReceivingDateFM = railReceivingDateFM;
	}
	public String getRailReceivingDateTO() {
		return railReceivingDateTO;
	}
	public void setRailReceivingDateTO(String railReceivingDateTO) {
		this.railReceivingDateTO = railReceivingDateTO;
	}
	public String getTroLodRefNo() {
		return troLodRefNo;
	}
	public void setTroLodRefNo(String troLodRefNo) {
		this.troLodRefNo = troLodRefNo;
	}                  
    	
}
