package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class VslSkdCngNotificationSetupVO extends AbstractValueObject {

		private static final long serialVersionUID = 1L;
		
		private Collection<VslSkdCngNotificationSetupVO> models = new ArrayList<VslSkdCngNotificationSetupVO>();
		
		/* Column Info */
		private String etbDlayFmHrs = null;
		/* Column Info */
		private String laneCd = null;
		/* Column Info */
		private String etdDlayFmMark = null;
		/* Column Info */
		private String dirPortDesc = null;
		/* Column Info */
		private String etaDlayFixmark = null;
		/* Column Info */
		private String creDt = null;
		/* Column Info */
		private String etbDlayFixmark = null;
		/* Column Info */
		private String etaDlayToMark = null;
		/* Column Info */
		private String vslSlanCd = null;
		/* Page Number */
		private String pagerows = null;
		/* Column Info */
		private String etaDlayToHrs = null;
		/* Column Info */
		private String vpsPortCd = null;
		/* VO Data Value( C:Creation, U:Update, D:Delete ) */
		private String ibflag = null;
		/* Column Info */
		private String etdDlayToHrs = null;
		/* Column Info */
		private String etdDlayFmHrs = null;
		/* Column Info */
		private String usrId = null;
		/* Column Info */
		private String skpClptTgtFlg = null;
		/* Column Info */
		private String portCd = null;
		/* Column Info */
		private String updUsrId = null;
		/* Column Info */
		private String etbDlayToMark = null;
		/* Column Info */
		private String updDt = null;
		/* Column Info */
		private String etbDlayToHrs = null;
		/* Column Info */
		private String etdDlayFixmark = null;
		/* Column Info */
		private String etaDlayFmHrs = null;
		/* Column Info */
		private String etdDlayToMark = null;
		/* Column Info */
		private String etbDlayFmMark = null;
		/* Column Info */
		private String skdDirCd = null;
		/* Column Info */
		private String loginUsrId = null;
		/* Column Info */
		private String creUsrId = null;
		/* Column Info */
		private String slanCd = null;
		/* Column Info */
		private String etaDlayFmMark = null;
		/* Column Info */
		private String rvsClptTgtFlg = null;
		/* Column Info */
		private String aplyFlg = null;
		
		/* Column Info */
		private String orgVslSlanCd = null;
		/* Column Info */
		private String orgVpsPortCd = null;
		/* Column Info */
		private String orgSkdDirCd = null;
		/* Column Info */
		private String pkModiFlg = null;
		
		
		/*	테이블 컬럼의 값을 저장하는 Hashtable */
		private HashMap<String, String> hashColumns = new HashMap<String, String>();

		/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
		private HashMap<String, String> hashFields = new HashMap<String, String>();
		
		public VslSkdCngNotificationSetupVO() {}

		public VslSkdCngNotificationSetupVO(String ibflag, String pagerows, String usrId, String vslSlanCd, String dirPortDesc, String vpsPortCd, String skdDirCd, String etaDlayFmHrs, String etaDlayToHrs, String etbDlayFmHrs, String etbDlayToHrs, String etdDlayFmHrs, String etdDlayToHrs, String skpClptTgtFlg, String rvsClptTgtFlg, String aplyFlg, String creUsrId, String creDt, String updUsrId, String updDt, String loginUsrId, String laneCd, String slanCd, String portCd, String etaDlayFmMark, String etaDlayFixmark, String etaDlayToMark, String etbDlayFmMark, String etbDlayFixmark, String etbDlayToMark, String etdDlayFmMark, String etdDlayFixmark, String etdDlayToMark, String orgVslSlanCd, String orgVpsPortCd, String orgSkdDirCd, String pkModiFlg) {
			this.etbDlayFmHrs = etbDlayFmHrs;
			this.laneCd = laneCd;
			this.etdDlayFmMark = etdDlayFmMark;
			this.dirPortDesc = dirPortDesc;
			this.etaDlayFixmark = etaDlayFixmark;
			this.creDt = creDt;
			this.etbDlayFixmark = etbDlayFixmark;
			this.etaDlayToMark = etaDlayToMark;
			this.vslSlanCd = vslSlanCd;
			this.pagerows = pagerows;
			this.etaDlayToHrs = etaDlayToHrs;
			this.vpsPortCd = vpsPortCd;
			this.ibflag = ibflag;
			this.etdDlayToHrs = etdDlayToHrs;
			this.etdDlayFmHrs = etdDlayFmHrs;
			this.usrId = usrId;
			this.skpClptTgtFlg = skpClptTgtFlg;
			this.portCd = portCd;
			this.updUsrId = updUsrId;
			this.etbDlayToMark = etbDlayToMark;
			this.updDt = updDt;
			this.etbDlayToHrs = etbDlayToHrs;
			this.etdDlayFixmark = etdDlayFixmark;
			this.etaDlayFmHrs = etaDlayFmHrs;
			this.etdDlayToMark = etdDlayToMark;
			this.etbDlayFmMark = etbDlayFmMark;
			this.skdDirCd = skdDirCd;
			this.loginUsrId = loginUsrId;
			this.creUsrId = creUsrId;
			this.slanCd = slanCd;
			this.etaDlayFmMark = etaDlayFmMark;
			this.rvsClptTgtFlg = rvsClptTgtFlg;
			this.aplyFlg = aplyFlg;
			
			this.orgVslSlanCd = orgVslSlanCd;
			this.orgVpsPortCd = orgVpsPortCd;
			this.orgSkdDirCd = orgSkdDirCd;
			this.pkModiFlg = pkModiFlg;
		}
		
		/**
		 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
		 * @return HashMap
		 */
		public HashMap<String, String> getColumnValues(){
			this.hashColumns.put("etb_dlay_fm_hrs", getEtbDlayFmHrs());
			this.hashColumns.put("lane_cd", getLaneCd());
			this.hashColumns.put("etd_dlay_fm_mark", getEtdDlayFmMark());
			this.hashColumns.put("dir_port_desc", getDirPortDesc());
			this.hashColumns.put("eta_dlay_fixmark", getEtaDlayFixmark());
			this.hashColumns.put("cre_dt", getCreDt());
			this.hashColumns.put("etb_dlay_fixmark", getEtbDlayFixmark());
			this.hashColumns.put("eta_dlay_to_mark", getEtaDlayToMark());
			this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
			this.hashColumns.put("pagerows", getPagerows());
			this.hashColumns.put("eta_dlay_to_hrs", getEtaDlayToHrs());
			this.hashColumns.put("vps_port_cd", getVpsPortCd());
			this.hashColumns.put("ibflag", getIbflag());
			this.hashColumns.put("etd_dlay_to_hrs", getEtdDlayToHrs());
			this.hashColumns.put("etd_dlay_fm_hrs", getEtdDlayFmHrs());
			this.hashColumns.put("usr_id", getUsrId());
			this.hashColumns.put("skp_clpt_tgt_flg", getSkpClptTgtFlg());
			this.hashColumns.put("port_cd", getPortCd());
			this.hashColumns.put("upd_usr_id", getUpdUsrId());
			this.hashColumns.put("etb_dlay_to_mark", getEtbDlayToMark());
			this.hashColumns.put("upd_dt", getUpdDt());
			this.hashColumns.put("etb_dlay_to_hrs", getEtbDlayToHrs());
			this.hashColumns.put("etd_dlay_fixmark", getEtdDlayFixmark());
			this.hashColumns.put("eta_dlay_fm_hrs", getEtaDlayFmHrs());
			this.hashColumns.put("etd_dlay_to_mark", getEtdDlayToMark());
			this.hashColumns.put("etb_dlay_fm_mark", getEtbDlayFmMark());
			this.hashColumns.put("skd_dir_cd", getSkdDirCd());
			this.hashColumns.put("login_usr_id", getLoginUsrId());
			this.hashColumns.put("cre_usr_id", getCreUsrId());
			this.hashColumns.put("slan_cd", getSlanCd());
			this.hashColumns.put("eta_dlay_fm_mark", getEtaDlayFmMark());
			this.hashColumns.put("rvs_clpt_tgt_flg", getRvsClptTgtFlg());
			this.hashColumns.put("aply_flg", getAplyFlg());
			
			this.hashColumns.put("org_vsl_slan_cd", getOrgVslSlanCd());
			this.hashColumns.put("org_vps_port_cd", getOrgVpsPortCd());
			this.hashColumns.put("org_skd_dir_cd", getOrgSkdDirCd());
			this.hashColumns.put("pk_modi_flg", getPkModiFlg());
			
			return this.hashColumns;
		}
		
		/**
		 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
		 * @return
		 */
		public HashMap<String, String> getFieldNames(){
			this.hashFields.put("etb_dlay_fm_hrs", "etbDlayFmHrs");
			this.hashFields.put("lane_cd", "laneCd");
			this.hashFields.put("etd_dlay_fm_mark", "etdDlayFmMark");
			this.hashFields.put("dir_port_desc", "dirPortDesc");
			this.hashFields.put("eta_dlay_fixmark", "etaDlayFixmark");
			this.hashFields.put("cre_dt", "creDt");
			this.hashFields.put("etb_dlay_fixmark", "etbDlayFixmark");
			this.hashFields.put("eta_dlay_to_mark", "etaDlayToMark");
			this.hashFields.put("vsl_slan_cd", "vslSlanCd");
			this.hashFields.put("pagerows", "pagerows");
			this.hashFields.put("eta_dlay_to_hrs", "etaDlayToHrs");
			this.hashFields.put("vps_port_cd", "vpsPortCd");
			this.hashFields.put("ibflag", "ibflag");
			this.hashFields.put("etd_dlay_to_hrs", "etdDlayToHrs");
			this.hashFields.put("etd_dlay_fm_hrs", "etdDlayFmHrs");
			this.hashFields.put("usr_id", "usrId");
			this.hashFields.put("skp_clpt_tgt_flg", "skpClptTgtFlg");
			this.hashFields.put("port_cd", "portCd");
			this.hashFields.put("upd_usr_id", "updUsrId");
			this.hashFields.put("etb_dlay_to_mark", "etbDlayToMark");
			this.hashFields.put("upd_dt", "updDt");
			this.hashFields.put("etb_dlay_to_hrs", "etbDlayToHrs");
			this.hashFields.put("etd_dlay_fixmark", "etdDlayFixmark");
			this.hashFields.put("eta_dlay_fm_hrs", "etaDlayFmHrs");
			this.hashFields.put("etd_dlay_to_mark", "etdDlayToMark");
			this.hashFields.put("etb_dlay_fm_mark", "etbDlayFmMark");
			this.hashFields.put("skd_dir_cd", "skdDirCd");
			this.hashFields.put("login_usr_id", "loginUsrId");
			this.hashFields.put("cre_usr_id", "creUsrId");
			this.hashFields.put("slan_cd", "slanCd");
			this.hashFields.put("eta_dlay_fm_mark", "etaDlayFmMark");
			this.hashFields.put("rvs_clpt_tgt_flg", "rvsClptTgtFlg");
			this.hashFields.put("aply_flg", "aplyFlg");
			
			this.hashFields.put("org_vsl_slan_cd", "orgVslSlanCd");
			this.hashFields.put("org_vps_port_cd", "orgVpsPortCd");
			this.hashFields.put("org_skd_dir_cd", "orgSkdDirCd");
			this.hashFields.put("pk_modi_flg", "pkModiFlg");
			
			return this.hashFields;
		}
		
		/**
		 * Column Info
		 * @return etbDlayFmHrs
		 */
		public String getEtbDlayFmHrs() {
			return this.etbDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @return laneCd
		 */
		public String getLaneCd() {
			return this.laneCd;
		}
		
		/**
		 * Column Info
		 * @return etdDlayFmMark
		 */
		public String getEtdDlayFmMark() {
			return this.etdDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @return dirPortDesc
		 */
		public String getDirPortDesc() {
			return this.dirPortDesc;
		}
		
		/**
		 * Column Info
		 * @return etaDlayFixmark
		 */
		public String getEtaDlayFixmark() {
			return this.etaDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @return creDt
		 */
		public String getCreDt() {
			return this.creDt;
		}
		
		/**
		 * Column Info
		 * @return etbDlayFixmark
		 */
		public String getEtbDlayFixmark() {
			return this.etbDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @return etaDlayToMark
		 */
		public String getEtaDlayToMark() {
			return this.etaDlayToMark;
		}
		
		/**
		 * Column Info
		 * @return vslSlanCd
		 */
		public String getVslSlanCd() {
			return this.vslSlanCd;
		}
		
		/**
		 * Page Number
		 * @return pagerows
		 */
		public String getPagerows() {
			return this.pagerows;
		}
		
		/**
		 * Column Info
		 * @return etaDlayToHrs
		 */
		public String getEtaDlayToHrs() {
			return this.etaDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @return vpsPortCd
		 */
		public String getVpsPortCd() {
			return this.vpsPortCd;
		}
		
		/**
		 * VO Data Value( C:Creation, U:Update, D:Delete )
		 * @return ibflag
		 */
		public String getIbflag() {
			return this.ibflag;
		}
		
		/**
		 * Column Info
		 * @return etdDlayToHrs
		 */
		public String getEtdDlayToHrs() {
			return this.etdDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @return etdDlayFmHrs
		 */
		public String getEtdDlayFmHrs() {
			return this.etdDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @return usrId
		 */
		public String getUsrId() {
			return this.usrId;
		}
		
		/**
		 * Column Info
		 * @return skpClptTgtFlg
		 */
		public String getSkpClptTgtFlg() {
			return this.skpClptTgtFlg;
		}
		
		/**
		 * Column Info
		 * @return portCd
		 */
		public String getPortCd() {
			return this.portCd;
		}
		
		/**
		 * Column Info
		 * @return updUsrId
		 */
		public String getUpdUsrId() {
			return this.updUsrId;
		}
		
		/**
		 * Column Info
		 * @return etbDlayToMark
		 */
		public String getEtbDlayToMark() {
			return this.etbDlayToMark;
		}
		
		/**
		 * Column Info
		 * @return updDt
		 */
		public String getUpdDt() {
			return this.updDt;
		}
		
		/**
		 * Column Info
		 * @return etbDlayToHrs
		 */
		public String getEtbDlayToHrs() {
			return this.etbDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @return etdDlayFixmark
		 */
		public String getEtdDlayFixmark() {
			return this.etdDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @return etaDlayFmHrs
		 */
		public String getEtaDlayFmHrs() {
			return this.etaDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @return etdDlayToMark
		 */
		public String getEtdDlayToMark() {
			return this.etdDlayToMark;
		}
		
		/**
		 * Column Info
		 * @return etbDlayFmMark
		 */
		public String getEtbDlayFmMark() {
			return this.etbDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @return skdDirCd
		 */
		public String getSkdDirCd() {
			return this.skdDirCd;
		}
		
		/**
		 * Column Info
		 * @return loginUsrId
		 */
		public String getLoginUsrId() {
			return this.loginUsrId;
		}
		
		/**
		 * Column Info
		 * @return creUsrId
		 */
		public String getCreUsrId() {
			return this.creUsrId;
		}
		
		/**
		 * Column Info
		 * @return slanCd
		 */
		public String getSlanCd() {
			return this.slanCd;
		}
		
		/**
		 * Column Info
		 * @return etaDlayFmMark
		 */
		public String getEtaDlayFmMark() {
			return this.etaDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @return rvsClptTgtFlg
		 */
		public String getRvsClptTgtFlg() {
			return this.rvsClptTgtFlg;
		}
		
		/**
		 * Column Info
		 * @return aplyFlg
		 */
		public String getAplyFlg() {
			return this.aplyFlg;
		}
		
		/**
		 * Column Info
		 * @return orgVslSlanCd
		 */
		public String getOrgVslSlanCd() {
			return this.orgVslSlanCd;
		}
		/**
		 * Column Info
		 * @return orgVpsPortCd
		 */
		public String getOrgVpsPortCd() {
			return this.orgVpsPortCd;
		}
		/**
		 * Column Info
		 * @return orgSkdDirCd
		 */
		public String getOrgSkdDirCd() {
			return this.orgSkdDirCd;
		}
		/**
		 * Column Info
		 * @return pkModiFlg
		 */
		public String getPkModiFlg() {
			return this.pkModiFlg;
		}
		

		/**
		 * Column Info
		 * @param etbDlayFmHrs
		 */
		public void setEtbDlayFmHrs(String etbDlayFmHrs) {
			this.etbDlayFmHrs = etbDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @param laneCd
		 */
		public void setLaneCd(String laneCd) {
			this.laneCd = laneCd;
		}
		
		/**
		 * Column Info
		 * @param etdDlayFmMark
		 */
		public void setEtdDlayFmMark(String etdDlayFmMark) {
			this.etdDlayFmMark = etdDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @param dirPortDesc
		 */
		public void setDirPortDesc(String dirPortDesc) {
			this.dirPortDesc = dirPortDesc;
		}
		
		/**
		 * Column Info
		 * @param etaDlayFixmark
		 */
		public void setEtaDlayFixmark(String etaDlayFixmark) {
			this.etaDlayFixmark = etaDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @param creDt
		 */
		public void setCreDt(String creDt) {
			this.creDt = creDt;
		}
		
		/**
		 * Column Info
		 * @param etbDlayFixmark
		 */
		public void setEtbDlayFixmark(String etbDlayFixmark) {
			this.etbDlayFixmark = etbDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @param etaDlayToMark
		 */
		public void setEtaDlayToMark(String etaDlayToMark) {
			this.etaDlayToMark = etaDlayToMark;
		}
		
		/**
		 * Column Info
		 * @param vslSlanCd
		 */
		public void setVslSlanCd(String vslSlanCd) {
			this.vslSlanCd = vslSlanCd;
		}
		
		/**
		 * Page Number
		 * @param pagerows
		 */
		public void setPagerows(String pagerows) {
			this.pagerows = pagerows;
		}
		
		/**
		 * Column Info
		 * @param etaDlayToHrs
		 */
		public void setEtaDlayToHrs(String etaDlayToHrs) {
			this.etaDlayToHrs = etaDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @param vpsPortCd
		 */
		public void setVpsPortCd(String vpsPortCd) {
			this.vpsPortCd = vpsPortCd;
		}
		
		/**
		 * VO Data Value( C:Creation, U:Update, D:Delete )
		 * @param ibflag
		 */
		public void setIbflag(String ibflag) {
			this.ibflag = ibflag;
		}
		
		/**
		 * Column Info
		 * @param etdDlayToHrs
		 */
		public void setEtdDlayToHrs(String etdDlayToHrs) {
			this.etdDlayToHrs = etdDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @param etdDlayFmHrs
		 */
		public void setEtdDlayFmHrs(String etdDlayFmHrs) {
			this.etdDlayFmHrs = etdDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @param usrId
		 */
		public void setUsrId(String usrId) {
			this.usrId = usrId;
		}
		
		/**
		 * Column Info
		 * @param skpClptTgtFlg
		 */
		public void setSkpClptTgtFlg(String skpClptTgtFlg) {
			this.skpClptTgtFlg = skpClptTgtFlg;
		}
		
		/**
		 * Column Info
		 * @param portCd
		 */
		public void setPortCd(String portCd) {
			this.portCd = portCd;
		}
		
		/**
		 * Column Info
		 * @param updUsrId
		 */
		public void setUpdUsrId(String updUsrId) {
			this.updUsrId = updUsrId;
		}
		
		/**
		 * Column Info
		 * @param etbDlayToMark
		 */
		public void setEtbDlayToMark(String etbDlayToMark) {
			this.etbDlayToMark = etbDlayToMark;
		}
		
		/**
		 * Column Info
		 * @param updDt
		 */
		public void setUpdDt(String updDt) {
			this.updDt = updDt;
		}
		
		/**
		 * Column Info
		 * @param etbDlayToHrs
		 */
		public void setEtbDlayToHrs(String etbDlayToHrs) {
			this.etbDlayToHrs = etbDlayToHrs;
		}
		
		/**
		 * Column Info
		 * @param etdDlayFixmark
		 */
		public void setEtdDlayFixmark(String etdDlayFixmark) {
			this.etdDlayFixmark = etdDlayFixmark;
		}
		
		/**
		 * Column Info
		 * @param etaDlayFmHrs
		 */
		public void setEtaDlayFmHrs(String etaDlayFmHrs) {
			this.etaDlayFmHrs = etaDlayFmHrs;
		}
		
		/**
		 * Column Info
		 * @param etdDlayToMark
		 */
		public void setEtdDlayToMark(String etdDlayToMark) {
			this.etdDlayToMark = etdDlayToMark;
		}
		
		/**
		 * Column Info
		 * @param etbDlayFmMark
		 */
		public void setEtbDlayFmMark(String etbDlayFmMark) {
			this.etbDlayFmMark = etbDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @param skdDirCd
		 */
		public void setSkdDirCd(String skdDirCd) {
			this.skdDirCd = skdDirCd;
		}
		
		/**
		 * Column Info
		 * @param loginUsrId
		 */
		public void setLoginUsrId(String loginUsrId) {
			this.loginUsrId = loginUsrId;
		}
		
		/**
		 * Column Info
		 * @param creUsrId
		 */
		public void setCreUsrId(String creUsrId) {
			this.creUsrId = creUsrId;
		}
		
		/**
		 * Column Info
		 * @param slanCd
		 */
		public void setSlanCd(String slanCd) {
			this.slanCd = slanCd;
		}
		
		/**
		 * Column Info
		 * @param etaDlayFmMark
		 */
		public void setEtaDlayFmMark(String etaDlayFmMark) {
			this.etaDlayFmMark = etaDlayFmMark;
		}
		
		/**
		 * Column Info
		 * @param rvsClptTgtFlg
		 */
		public void setRvsClptTgtFlg(String rvsClptTgtFlg) {
			this.rvsClptTgtFlg = rvsClptTgtFlg;
		}
		
		/**
		 * Column Info
		 * @param aplyFlg
		 */
		public void setAplyFlg(String aplyFlg) {
			this.aplyFlg = aplyFlg;
		}
		
		/**
		 * Column Info
		 * @param orgVslSlanCd
		 */
		public void setOrgVslSlanCd(String orgVslSlanCd) {
			this.orgVslSlanCd = orgVslSlanCd;
		}
		/**
		 * Column Info
		 * @param orgVpsPortCd
		 */
		public void setOrgVpsPortCd(String orgVpsPortCd) {
			this.orgVpsPortCd = orgVpsPortCd;
		}
		/**
		 * Column Info
		 * @param orgSkdDirCd
		 */
		public void setOrgSkdDirCd(String orgSkdDirCd) {
			this.orgSkdDirCd = orgSkdDirCd;
		}
		/**
		 * Column Info
		 * @param pkModiFlg
		 */
		public void setPkModiFlg(String pkModiFlg) {
			this.pkModiFlg = pkModiFlg;
		}
		
	/**
		 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
		 * @param request
		 */
		public void fromRequest(HttpServletRequest request) {
			fromRequest(request,"");
		}

		/**
		 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
		 * @param request
		 */
		public void fromRequest(HttpServletRequest request, String prefix) {
			setEtbDlayFmHrs(JSPUtil.getParameter(request, prefix + "etb_dlay_fm_hrs", ""));
			setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
			setEtdDlayFmMark(JSPUtil.getParameter(request, prefix + "etd_dlay_fm_mark", ""));
			setDirPortDesc(JSPUtil.getParameter(request, prefix + "dir_port_desc", ""));
			setEtaDlayFixmark(JSPUtil.getParameter(request, prefix + "eta_dlay_fixmark", ""));
			setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
			setEtbDlayFixmark(JSPUtil.getParameter(request, prefix + "etb_dlay_fixmark", ""));
			setEtaDlayToMark(JSPUtil.getParameter(request, prefix + "eta_dlay_to_mark", ""));
			setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
			setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
			setEtaDlayToHrs(JSPUtil.getParameter(request, prefix + "eta_dlay_to_hrs", ""));
			setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
			setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
			setEtdDlayToHrs(JSPUtil.getParameter(request, prefix + "etd_dlay_to_hrs", ""));
			setEtdDlayFmHrs(JSPUtil.getParameter(request, prefix + "etd_dlay_fm_hrs", ""));
			setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
			setSkpClptTgtFlg(JSPUtil.getParameter(request, prefix + "skp_clpt_tgt_flg", ""));
			setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
			setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
			setEtbDlayToMark(JSPUtil.getParameter(request, prefix + "etb_dlay_to_mark", ""));
			setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
			setEtbDlayToHrs(JSPUtil.getParameter(request, prefix + "etb_dlay_to_hrs", ""));
			setEtdDlayFixmark(JSPUtil.getParameter(request, prefix + "etd_dlay_fixmark", ""));
			setEtaDlayFmHrs(JSPUtil.getParameter(request, prefix + "eta_dlay_fm_hrs", ""));
			setEtdDlayToMark(JSPUtil.getParameter(request, prefix + "etd_dlay_to_mark", ""));
			setEtbDlayFmMark(JSPUtil.getParameter(request, prefix + "etb_dlay_fm_mark", ""));
			setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
			setLoginUsrId(JSPUtil.getParameter(request, prefix + "login_usr_id", ""));
			setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
			setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
			setEtaDlayFmMark(JSPUtil.getParameter(request, prefix + "eta_dlay_fm_mark", ""));
			setRvsClptTgtFlg(JSPUtil.getParameter(request, prefix + "rvs_clpt_tgt_flg", ""));
			setAplyFlg(JSPUtil.getParameter(request, prefix + "aply_flg", ""));
			
			setOrgVslSlanCd(JSPUtil.getParameter(request, prefix + "org_vsl_slan_cd", ""));
			setOrgVpsPortCd(JSPUtil.getParameter(request, prefix + "org_vps_port_cd", ""));
			setOrgSkdDirCd(JSPUtil.getParameter(request, prefix + "org_skd_dir_cd", ""));
			setPkModiFlg(JSPUtil.getParameter(request, prefix + "pk_modi_flg", ""));
			
		}

		/**
		 * Request 의 데이터를 VO 배열로 변환하여 반환.
		 * @param request
		 * @return VslSkdCngNotificationSetupVO[]
		 */
		public VslSkdCngNotificationSetupVO[] fromRequestGrid(HttpServletRequest request) {
			return fromRequestGrid(request, "");
		}

		/**
		 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
		 * @param request
		 * @param prefix
		 * @return VslSkdCngNotificationSetupVO[]
		 */
		public VslSkdCngNotificationSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
			VslSkdCngNotificationSetupVO model = null;
			
			String[] tmp = request.getParameterValues(prefix + "ibflag");
	  		if(tmp == null)
	   			return null;

	  		int length = request.getParameterValues(prefix + "ibflag").length;
	  
			try {
				String[] etbDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_fm_hrs", length));
				String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
				String[] etdDlayFmMark = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_fm_mark", length));
				String[] dirPortDesc = (JSPUtil.getParameter(request, prefix	+ "dir_port_desc", length));
				String[] etaDlayFixmark = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_fixmark", length));
				String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
				String[] etbDlayFixmark = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_fixmark", length));
				String[] etaDlayToMark = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_to_mark", length));
				String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
				String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
				String[] etaDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_to_hrs", length));
				String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
				String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
				String[] etdDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_to_hrs", length));
				String[] etdDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_fm_hrs", length));
				String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
				String[] skpClptTgtFlg = (JSPUtil.getParameter(request, prefix	+ "skp_clpt_tgt_flg", length));
				String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
				String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
				String[] etbDlayToMark = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_to_mark", length));
				String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
				String[] etbDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_to_hrs", length));
				String[] etdDlayFixmark = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_fixmark", length));
				String[] etaDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_fm_hrs", length));
				String[] etdDlayToMark = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_to_mark", length));
				String[] etbDlayFmMark = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_fm_mark", length));
				String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
				String[] loginUsrId = (JSPUtil.getParameter(request, prefix	+ "login_usr_id", length));
				String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
				String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
				String[] etaDlayFmMark = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_fm_mark", length));
				String[] rvsClptTgtFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_clpt_tgt_flg", length));
				String[] aplyFlg = (JSPUtil.getParameter(request, prefix	+ "aply_flg", length));
				
				String[] orgVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "org_vsl_slan_cd", length));
				String[] orgVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "org_vps_port_cd", length));
				String[] orgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "org_skd_dir_cd", length));
				String[] pkModiFlg = (JSPUtil.getParameter(request, prefix	+ "pk_modi_flg", length));
				
				for (int i = 0; i < length; i++) {
					model = new VslSkdCngNotificationSetupVO();
					if (etbDlayFmHrs[i] != null)
						model.setEtbDlayFmHrs(etbDlayFmHrs[i]);
					if (laneCd[i] != null)
						model.setLaneCd(laneCd[i]);
					if (etdDlayFmMark[i] != null)
						model.setEtdDlayFmMark(etdDlayFmMark[i]);
					if (dirPortDesc[i] != null)
						model.setDirPortDesc(dirPortDesc[i]);
					if (etaDlayFixmark[i] != null)
						model.setEtaDlayFixmark(etaDlayFixmark[i]);
					if (creDt[i] != null)
						model.setCreDt(creDt[i]);
					if (etbDlayFixmark[i] != null)
						model.setEtbDlayFixmark(etbDlayFixmark[i]);
					if (etaDlayToMark[i] != null)
						model.setEtaDlayToMark(etaDlayToMark[i]);
					if (vslSlanCd[i] != null)
						model.setVslSlanCd(vslSlanCd[i]);
					if (pagerows[i] != null)
						model.setPagerows(pagerows[i]);
					if (etaDlayToHrs[i] != null)
						model.setEtaDlayToHrs(etaDlayToHrs[i]);
					if (vpsPortCd[i] != null)
						model.setVpsPortCd(vpsPortCd[i]);
					if (ibflag[i] != null)
						model.setIbflag(ibflag[i]);
					if (etdDlayToHrs[i] != null)
						model.setEtdDlayToHrs(etdDlayToHrs[i]);
					if (etdDlayFmHrs[i] != null)
						model.setEtdDlayFmHrs(etdDlayFmHrs[i]);
					if (usrId[i] != null)
						model.setUsrId(usrId[i]);
					if (skpClptTgtFlg[i] != null)
						model.setSkpClptTgtFlg(skpClptTgtFlg[i]);
					if (portCd[i] != null)
						model.setPortCd(portCd[i]);
					if (updUsrId[i] != null)
						model.setUpdUsrId(updUsrId[i]);
					if (etbDlayToMark[i] != null)
						model.setEtbDlayToMark(etbDlayToMark[i]);
					if (updDt[i] != null)
						model.setUpdDt(updDt[i]);
					if (etbDlayToHrs[i] != null)
						model.setEtbDlayToHrs(etbDlayToHrs[i]);
					if (etdDlayFixmark[i] != null)
						model.setEtdDlayFixmark(etdDlayFixmark[i]);
					if (etaDlayFmHrs[i] != null)
						model.setEtaDlayFmHrs(etaDlayFmHrs[i]);
					if (etdDlayToMark[i] != null)
						model.setEtdDlayToMark(etdDlayToMark[i]);
					if (etbDlayFmMark[i] != null)
						model.setEtbDlayFmMark(etbDlayFmMark[i]);
					if (skdDirCd[i] != null)
						model.setSkdDirCd(skdDirCd[i]);
					if (loginUsrId[i] != null)
						model.setLoginUsrId(loginUsrId[i]);
					if (creUsrId[i] != null)
						model.setCreUsrId(creUsrId[i]);
					if (slanCd[i] != null)
						model.setSlanCd(slanCd[i]);
					if (etaDlayFmMark[i] != null)
						model.setEtaDlayFmMark(etaDlayFmMark[i]);
					if (rvsClptTgtFlg[i] != null)
						model.setRvsClptTgtFlg(rvsClptTgtFlg[i]);
					if (aplyFlg[i] != null)
						model.setAplyFlg(aplyFlg[i]);
					
					if (orgVslSlanCd[i] != null)
						model.setOrgVslSlanCd(orgVslSlanCd[i]);
					if (orgVpsPortCd[i] != null)
						model.setOrgVpsPortCd(orgVpsPortCd[i]);
					if (orgSkdDirCd[i] != null)
						model.setOrgSkdDirCd(orgSkdDirCd[i]);
					if (pkModiFlg[i] != null)
						model.setPkModiFlg(pkModiFlg[i]);
					
					models.add(model);
				}

			} catch (Exception e) {
				return null;
			}
			return getVslSkdCngNotificationSetupVOs();
		}

		/**
		 * VO 배열을 반환
		 * @return VslSkdCngNotificationSetupVO[]
		 */
		public VslSkdCngNotificationSetupVO[] getVslSkdCngNotificationSetupVOs(){
			VslSkdCngNotificationSetupVO[] vos = (VslSkdCngNotificationSetupVO[])models.toArray(new VslSkdCngNotificationSetupVO[models.size()]);
			return vos;
		}
		
		/**
		 * VO Class의 내용을 String으로 변환
		 */
		public String toString() {
			   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
		   }

		/**
		* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
		*/
		public void unDataFormat(){
			this.etbDlayFmHrs = this.etbDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etdDlayFmMark = this.etdDlayFmMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.dirPortDesc = this.dirPortDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etaDlayFixmark = this.etaDlayFixmark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etbDlayFixmark = this.etbDlayFixmark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etaDlayToMark = this.etaDlayToMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etaDlayToHrs = this.etaDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etdDlayToHrs = this.etdDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etdDlayFmHrs = this.etdDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.skpClptTgtFlg = this.skpClptTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etbDlayToMark = this.etbDlayToMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etbDlayToHrs = this.etbDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etdDlayFixmark = this.etdDlayFixmark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etaDlayFmHrs = this.etaDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etdDlayToMark = this.etdDlayToMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etbDlayFmMark = this.etbDlayFmMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.loginUsrId = this.loginUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.etaDlayFmMark = this.etaDlayFmMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.rvsClptTgtFlg = this.rvsClptTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.aplyFlg = this.aplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			
			this.orgVslSlanCd = this.orgVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.orgVpsPortCd = this.orgVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.orgSkdDirCd = this.orgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
			this.pkModiFlg = this.pkModiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		}
	}
