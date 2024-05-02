/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoList.java
*@FileTitle : FillInEquipmentNoList 
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
 * EXP_PAP_003Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_003EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class FillInEquipmentNoList {
	/** (Param 객체) */
	private int seq = 0;
	private	String eqNo			 = "";		//Eq No
	private	String eqTpszCd		 = "";		//Type/Size                  
	private	String eqTpszNm		 = "";		//Type/Size                  
	private	String bkgNo		 = "";		//Booking Number          
	private	String bkgNoSplit	 = "";		//Booking Number     
	private	String bkgStatusCd	 = "";		//Booking Status
	private	String bkgStatusNm	 = "";		//Booking Status
	private	String blNo			 = "";		//Bill of Lading Number   
	//2008.02.27 추가 by KJJ
	private String orgBkgNo 	 = "";		//Original Booking Number
	private String orgBkgNoSplit = "";		//Original Booking Number Split
	//2010.12.21 추가 by YKY
	private String soEqFlg       = "";      //Service Order Eq Attach Flag
	
	/**
	 * @return so_eq_flag을 리턴합니다.
	 */
	public String getSo_eq_flg() {
		return soEqFlg;
	}
	/**
	 * @param so_eq_flag 설정하려는so_eq_flag입니다.
	 */
	public void setSo_eq_flg(String so_eq_flag) {
		this.soEqFlg = so_eq_flag;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrg_bkg_no_split() {
		return orgBkgNoSplit;
	}
	/**
	 * 
	 * @param org_bkg_no_split
	 */
	public void setOrg_bkg_no_split(String org_bkg_no_split) {
		this.orgBkgNoSplit = org_bkg_no_split;
	}
	/**
	 * @return bkg_no을 리턴합니다.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no 설정하려는 bkg_no입니다.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return bkg_no_split을 리턴합니다.
	 */
	public String getBkg_no_split() {
		return bkgNoSplit;
	}
	/**
	 * @param bkg_no_split 설정하려는 bkg_no_split입니다.
	 */
	public void setBkg_no_split(String bkg_no_split) {
		this.bkgNoSplit = bkg_no_split;
	}
	/**
	 * @return bkg_status_cd을 리턴합니다.
	 */
	public String getBkg_status_cd() {
		return bkgStatusCd;
	}
	/**
	 * @param bkg_status_cd 설정하려는 bkg_status_cd입니다.
	 */
	public void setBkg_status_cd(String bkg_status_cd) {
		this.bkgStatusCd = bkg_status_cd;
	}
	/**
	 * @return bkg_status_nm을 리턴합니다.
	 */
	public String getBkg_status_nm() {
		return bkgStatusNm;
	}
	/**
	 * @param bkg_status_nm 설정하려는 bkg_status_nm입니다.
	 */
	public void setBkg_status_nm(String bkg_status_nm) {
		this.bkgStatusNm = bkg_status_nm;
	}
	/**
	 * @return bl_no을 리턴합니다.
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no 설정하려는 bl_no입니다.
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getEq_no() {
		return eqNo;
	}
	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}
	/**
	 * @return eq_tpsz_cd을 리턴합니다.
	 */
	public String getEq_tpsz_cd() {
		return eqTpszCd;
	}
	/**
	 * @param eq_tpsz_cd 설정하려는 eq_tpsz_cd입니다.
	 */
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eqTpszCd = eq_tpsz_cd;
	}
	/**
	 * @return eq_tpsz_nm을 리턴합니다.
	 */
	public String getEq_tpsz_nm() {
		return eqTpszNm;
	}
	/**
	 * @param eq_tpsz_nm 설정하려는 eq_tpsz_nm입니다.
	 */
	public void setEq_tpsz_nm(String eq_tpsz_nm) {
		this.eqTpszNm = eq_tpsz_nm;
	}
	/**
	 * @return seq을 리턴합니다.
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq 설정하려는 seq입니다.
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * 
	 * @return
	 */
	public String getOrg_bkg_no() {
		return orgBkgNo;
	}
	/**
	 * 
	 * @param org_bkg_no
	 */
	public void setOrg_bkg_no(String org_bkg_no) {
		this.orgBkgNo = org_bkg_no;
	}

}
