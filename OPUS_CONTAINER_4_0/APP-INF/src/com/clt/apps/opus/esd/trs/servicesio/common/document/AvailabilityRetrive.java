/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityRetrive.java
*@FileTitle	: Availability
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_004 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_004Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class AvailabilityRetrive { 
	
	/**	(Param 객체) */
	private String userID = "";
	private String vendorCode = "";

	private	String periodFlg = "";							//period_flg
	private	String fromDt = "";								//Dispatched Date
	private	String toDt = "";									//Dispatched Date                    
	private	String freightCollectFlg = "";             //F : Freight Collect 여부          
	private	String originalBlFlg = "";					//O : Original B/L 회수 여부     
	private	String customsFlg = "";						//C : 세관통관여부                  
	private	String cntrPkupNoFlg = "";            //Pickup Number                     
	private	String availableStsFlg = "";            //Pickup Number                     
	
	/**
	 * @return cntr_pkup_no_flg을 리턴합니다.
	 */
	public String getCntr_pkup_no_flg() {
		return cntrPkupNoFlg;
	}
	/**
	 * @param cntr_pkup_no_flg 설정하려는 cntr_pkup_no_flg입니다.
	 */
	public void setCntr_pkup_no_flg(String cntr_pkup_no_flg) {
		this.cntrPkupNoFlg = cntr_pkup_no_flg;
	}
	/**
	 * @return customs_flg을 리턴합니다.
	 */
	public String getCustoms_flg() {
		return customsFlg;
	}
	/**
	 * @param customs_flg 설정하려는 customs_flg입니다.
	 */
	public void setCustoms_flg(String customs_flg) {
		this.customsFlg = customs_flg;
	}
	/**
	 * @return freight_collect_flg을 리턴합니다.
	 */
	public String getFreight_collect_flg() {
		return freightCollectFlg;
	}
	/**
	 * @param freight_collect_flg 설정하려는 freight_collect_flg입니다.
	 */
	public void setFreight_collect_flg(String freight_collect_flg) {
		this.freightCollectFlg = freight_collect_flg;
	}
	/**
	 * @return from_dt을 리턴합니다.
	 */
	public String getFrom_dt() {
		return fromDt;
	}
	/**
	 * @param from_dt 설정하려는 from_dt입니다.
	 */
	public void setFrom_dt(String from_dt) {
		this.fromDt = from_dt;
	}
	/**
	 * @return original_bl_flg을 리턴합니다.
	 */
	public String getOriginal_bl_flg() {
		return originalBlFlg;
	}
	/**
	 * @param original_bl_flg 설정하려는 original_bl_flg입니다.
	 */
	public void setOriginal_bl_flg(String original_bl_flg) {
		this.originalBlFlg = original_bl_flg;
	}
	/**
	 * @return period_flg을 리턴합니다.
	 */
	public String getPeriod_flg() {
		return periodFlg;
	}
	/**
	 * @param period_flg 설정하려는 period_flg입니다.
	 */
	public void setPeriod_flg(String period_flg) {
		this.periodFlg = period_flg;
	}
	/**
	 * @return to_dt을 리턴합니다.
	 */
	public String getTo_dt() {
		return toDt;
	}
	/**
	 * @param to_dt 설정하려는 to_dt입니다.
	 */
	public void setTo_dt(String to_dt) {
		this.toDt = to_dt;
	}
	/**
	 * @return userID을 리턴합니다.
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID 설정하려는 userID입니다.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return vendorCode을 리턴합니다.
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * @param vendorCode 설정하려는 vendorCode입니다.
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	/**
	 * @return available_sts_flg 리턴합니다.
	 */
	public String getAvailable_sts_flg() {
		return availableStsFlg;
	}
	/**
	 * @param available_sts_flg 설정하려는 available_sts_flg입니다.
	 */
	public void setAvailable_sts_flg(String available_sts_flg) {
		this.availableStsFlg = available_sts_flg;
	}



}
