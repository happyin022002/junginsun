/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_001Event.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : juhyun
*@LastVersion : 1.0 
* 2006-10-18 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0001Event extends EventSupport {

	  private String hidFromDate = null;
	  private String hidToDate = null;	
	  private String hidCargo = null;
	  private String hidBound = null;
	  private String hidCost = null;
	  private String selTransmode = null;
	  private String hidRhq = null;	  
	  private String ofcCd = null;
	  private String trunkVvd = null;
	  private String trunkVvd1 = null;
	  private String trunkVvd2 = null;
	  private String trunkVvd3 = null;


		public String getHid_from_date() {
			return hidFromDate;
		}
		public void setHid_from_date(String hid_from_date) {
			this.hidFromDate = hid_from_date;
		}

		public String getHid_to_date() {
			return hidToDate;
		}
		public void setHid_to_date(String hid_to_date) {
			this.hidToDate = hid_to_date;
		}	  
	  
		public String getHid_cargo() {
			return hidCargo;
		}
		public void setHid_cargo(String hid_cargo) {
			this.hidCargo = hid_cargo;
		}		

		public String getHid_bound() {
			return hidBound;
		}
		public void setHid_bound(String hid_bound) {
			this.hidBound = hid_bound;
		}		  
	  
		public String getHid_cost() {
			return hidCost;
		}
		public void setHid_cost(String hid_cost) {
			this.hidCost = hid_cost;
		}	  
		
		public String getSel_transmode() {
			return selTransmode;
		}
		public void setSel_transmode(String sel_transmode) {
			this.selTransmode = sel_transmode;
		}			
	  
		public String getHid_rhq() {
			return hidRhq;
		}
		public void setHid_rhq(String hid_rhq) {
			this.hidRhq = hid_rhq;
		}
		
		public String getOfc_cd() {
			return ofcCd;
		}
		public void setOfc_cd(String ofc_cd) {
			this.ofcCd = ofc_cd;
		}

		public String getTrunk_vvd() {
			return trunkVvd;
		}
		public void setTrunk_vvd(String trunk_vvd) {
			this.trunkVvd = trunk_vvd;
		}
		
		public String getTrunk_vvd1() {
			return trunkVvd1;
		}
		public void setTrunk_vvd1(String trunk_vvd1) {
			this.trunkVvd1 = trunk_vvd1;
		}

		public String getTrunk_vvd2() {
			return trunkVvd2;
		}
		public void setTrunk_vvd2(String trunk_vvd2) {
			this.trunkVvd2 = trunk_vvd2;
		}
		
		public String getTrunk_vvd3() {
			return trunkVvd3;
		}
		public void setTrunk_vvd3(String trunk_vvd3) {
			this.trunkVvd3 = trunk_vvd3;
		}

		public EsdTrs0001Event(){}	
	
		public String getEventName() {
			return "EsdTrs0001Event";
		}
	
		public String toString() {
			return "EsdTrs0001Event";
		}



}
