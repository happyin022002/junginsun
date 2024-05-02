/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderRejectList.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.event;

/**
 * WORejectEventResponse 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - WORejectEventResponse에서 변환하여 사용<br>
 *
 * @author Lee Sang-Woo
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderRejectList {

		/** (Param 객체) */
		private	String soNo  = "";
		private	String eqNo  = "";
		private	int woIssKnt  = 0;
		//private	String invoiced  = "";
		private	String appointmentTime  = "";
		private	String deliveryTime   = "";
		private	String rejectReason   = "";
		
		
		/**
		 * @return appointmentTime을 리턴합니다.
		 */
		public String getAppointmentTime() {
			return appointmentTime;
		}
		/**
		 * @param appointmentTime 설정하려는 appointmentTime입니다.
		 */
		public void setAppointmentTime(String appointmentTime) {
			appointmentTime = appointmentTime;
		}
		/**
		 * @return deliveryTime을 리턴합니다.
		 */
		public String getDeliveryTime() {
			return deliveryTime;
		}
		/**
		 * @param deliveryTime 설정하려는 deliveryTime입니다.
		 */
		public void setDeliveryTime(String deliveryTime) {
			deliveryTime = deliveryTime;
		}
		/**
		 * @return eq_no을 리턴합니다.
		 */
		public String getEq_no() {
			return eqNo;
		}
		/**
		 * @param eqNo 설정하려는 eq_no입니다.
		 */
		public void setEq_no(String eqNo) {
			this.eqNo = eqNo;
		}
		/**
		 * @return rejectReason을 리턴합니다.
		 */
		public String getRejectReason() {
			return rejectReason;
		}
		/**
		 * @param rejectReason 설정하려는 rejectReason입니다.
		 */
		public void setRejectReason(String rejectReason) {
			rejectReason = rejectReason;
		}
		/**
		 * @return so_no을 리턴합니다.
		 */
		public String getSo_no() {
			return soNo;
		}
		/**
		 * @param soNo 설정하려는 so_no입니다.
		 */
		public void setSo_no(String soNo) {
			this.soNo = soNo;
		}
		/**
		 * @return wo_iss_knt을 리턴합니다.
		 */
		public int getWo_iss_knt() {
			return woIssKnt;
		}
		/**
		 * @param woIssKnt 설정하려는 wo_iss_knt입니다.
		 */
		public void setWo_iss_knt(int woIssKnt) {
			this.woIssKnt = woIssKnt;
		}
}
