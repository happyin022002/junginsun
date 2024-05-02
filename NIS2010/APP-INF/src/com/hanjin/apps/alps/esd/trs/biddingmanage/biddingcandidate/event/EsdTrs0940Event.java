/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0940Event.java
 *@FileTitle :Bidding Candidate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.01
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2015.06.01 SHIN DONG IL
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event;

import java.util.Arrays;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidVndrVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidSoVO;
/**
 * ESD_TRS_0940 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0940HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0940Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	private SpotBidVndrVO[] spotBidVndrVOs = null;
	private SpotBidSoVO[] spotBidSoVOs = null;
	private String usr_id = "";
	private String usr_ofc_cd = "";
	private String so_no = "";
	private String spot_bid_flg = "";
	private String spot_bid_due_dt = "";
	private String vndr_seq = "";
	private String sel_transmode = "";
	
	
	public String getSel_transmode() {
		return sel_transmode;
	}
	public void setSel_transmode(String sel_transmode) {
		this.sel_transmode = sel_transmode;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_ofc_cd() {
		return usr_ofc_cd;
	}
	public void setUsr_ofc_cd(String usr_ofc_cd) {
		this.usr_ofc_cd = usr_ofc_cd;
	}
	public String getSo_no() {
		return so_no;
	}
	public void setSo_no(String so_no) {
		this.so_no = so_no;
	}
	public String getSpot_bid_flg() {
		return spot_bid_flg;
	}
	public void setSpot_bid_flg(String spot_bid_flg) {
		this.spot_bid_flg = spot_bid_flg;
	}
	public String getSpot_bid_due_dt() {
		return spot_bid_due_dt;
	}
	public void setSpot_bid_due_dt(String spot_bid_due_dt) {
		this.spot_bid_due_dt = spot_bid_due_dt;
	}
	public String getVndr_seq() {
		return vndr_seq;
	}
	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}
	public SpotBidVndrVO[] getSpotBidVndrVOs() {
		SpotBidVndrVO[] rtnVOs = null;
		if(this.spotBidVndrVOs != null){
			rtnVOs = Arrays.copyOf(spotBidVndrVOs,spotBidVndrVOs.length);
		}
		return rtnVOs;
	}

	public void setSpotBidVndrVOs(SpotBidVndrVO[] spotBidVndrVOs) {
		if(spotBidVndrVOs != null){
			SpotBidVndrVO[] tmpVOs = Arrays.copyOf(spotBidVndrVOs,spotBidVndrVOs.length);
			this.spotBidVndrVOs = tmpVOs;
		}
	}
	
	public SpotBidSoVO[] getSpotBidSoVOs() {
		SpotBidSoVO[] rtnVOs = null;
		if(this.spotBidSoVOs != null){
			rtnVOs = Arrays.copyOf(spotBidSoVOs,spotBidSoVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSpotBidSoVOs(SpotBidSoVO[] spotBidSoVOs) {
		if(spotBidSoVOs != null){
			SpotBidSoVO[] tmpVOs = Arrays.copyOf(spotBidSoVOs,spotBidSoVOs.length);
			this.spotBidSoVOs = tmpVOs;
		}
	}
	
	
	
}