/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VslSkdEmlSetUpVO.java
*@FileTitle : VslSkdEmlSetUpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.17
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.17 박준용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박준용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdEmlSetUpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdEmlSetUpVO> models = new ArrayList<VslSkdEmlSetUpVO>();
	
	/* Column Info */
	private String vskdDurIdHis = null;
	/* Column Info */
	private String emlSndHrHis = null;
	/* Column Info */
	private String emlSndDysCtntTue = null;
	/* Column Info */
	private String vslSlanCdHis = null;
	/* Column Info */
	private String subscEml = null;
	/* Column Info */
	private String emlSndDysCtntSatHis = null;
	/* Column Info */
	private String emlSndDysCtntThrHis = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlGrpId = null;
	/* Column Info */
	private String emlSndHr = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String emlSndDysCtntWeb = null;
	/* Column Info */
	private String emlSndDysCtntMon = null;
	/* Column Info */
	private String emlSndDysCtntSun = null;
	/* Column Info */
	private String emlSndDysCtntTueHis = null;
	/* Column Info */
	private String emlSndDysCtntWebHis = null;
	/* Column Info */
	private String emlJbId = null;
	/* Column Info */
	private String emlSndDysCtntFriHis = null;
	/* Column Info */
	private String emlSndDysCtntSunHis = null;
	/* Column Info */
	private String subscSeqHis = null;
	/* Column Info */
	private String emlGrpIdHis = null;
	/* Column Info */
	private String svcEndDt = null;
	/* Column Info */
	private String emlSndDysCtntSat = null;
	/* Column Info */
	private String emlSndDysCtntThr = null;
	/* Column Info */
	private String emlSndDysCtntMonHis = null;
	/* Column Info */
	private String vskdDurId = null;
	/* Column Info */
	private String subscEmlHis = null;
	/* Column Info */
	private String svcStDt = null;
	/* Column Info */
	private String emlSndDysCtntFri = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String toPortCdHis = null;
	/* Column Info */
	private String fmPortCdHis = null;
	/* Column Info */
	private String emlGrpCdDescHis = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdEmlSetUpVO() {}

	public VslSkdEmlSetUpVO(String pagerows, String emlGrpId, String vslSlanCd, String toPortCd, String vskdDurId, String emlSndHr, String emlSndDysCtntSun, String emlSndDysCtntMon, String emlSndDysCtntTue, String emlSndDysCtntWeb, String emlSndDysCtntThr, String emlSndDysCtntFri, String emlSndDysCtntSat, String subscEml, String ibFlag, String emlJbId, String svcStDt, String svcEndDt, String emlGrpIdHis, String emlSndHrHis, String emlSndDysCtntSunHis, String emlSndDysCtntMonHis, String emlSndDysCtntTueHis, String emlSndDysCtntWebHis, String emlSndDysCtntThrHis, String emlSndDysCtntFriHis, String emlSndDysCtntSatHis, String vslSlanCdHis, String toPortCdHis, String vskdDurIdHis, String subscSeqHis, String subscEmlHis, String fmPortCdHis, String emlGrpCdDescHis) {
		this.vskdDurIdHis = vskdDurIdHis;
		this.emlSndHrHis = emlSndHrHis;
		this.emlSndDysCtntTue = emlSndDysCtntTue;
		this.vslSlanCdHis = vslSlanCdHis;
		this.subscEml = subscEml;
		this.emlSndDysCtntSatHis = emlSndDysCtntSatHis;
		this.emlSndDysCtntThrHis = emlSndDysCtntThrHis;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.emlGrpId = emlGrpId;
		this.emlSndHr = emlSndHr;
		this.ibflag = ibFlag;
		this.emlSndDysCtntWeb = emlSndDysCtntWeb;
		this.emlSndDysCtntMon = emlSndDysCtntMon;
		this.emlSndDysCtntSun = emlSndDysCtntSun;
		this.emlSndDysCtntTueHis = emlSndDysCtntTueHis;
		this.emlSndDysCtntWebHis = emlSndDysCtntWebHis;
		this.emlJbId = emlJbId;
		this.emlSndDysCtntFriHis = emlSndDysCtntFriHis;
		this.emlSndDysCtntSunHis = emlSndDysCtntSunHis;
		this.subscSeqHis = subscSeqHis;
		this.emlGrpIdHis = emlGrpIdHis;
		this.svcEndDt = svcEndDt;
		this.emlSndDysCtntSat = emlSndDysCtntSat;
		this.emlSndDysCtntThr = emlSndDysCtntThr;
		this.emlSndDysCtntMonHis = emlSndDysCtntMonHis;
		this.vskdDurId = vskdDurId;
		this.subscEmlHis = subscEmlHis;
		this.svcStDt = svcStDt;
		this.emlSndDysCtntFri = emlSndDysCtntFri;
		this.toPortCd = toPortCd;
		this.toPortCdHis = toPortCdHis;
		this.fmPortCdHis = fmPortCdHis;
		this.emlGrpCdDescHis = emlGrpCdDescHis;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vskd_dur_id_his", getVskdDurIdHis());
		this.hashColumns.put("eml_snd_hr_his", getEmlSndHrHis());
		this.hashColumns.put("eml_snd_dys_ctnt_tue", getEmlSndDysCtntTue());
		this.hashColumns.put("vsl_slan_cd_his", getVslSlanCdHis());
		this.hashColumns.put("subsc_eml", getSubscEml());
		this.hashColumns.put("eml_snd_dys_ctnt_sat_his", getEmlSndDysCtntSatHis());
		this.hashColumns.put("eml_snd_dys_ctnt_thr_his", getEmlSndDysCtntThrHis());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_grp_id", getEmlGrpId());
		this.hashColumns.put("eml_snd_hr", getEmlSndHr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_snd_dys_ctnt_web", getEmlSndDysCtntWeb());
		this.hashColumns.put("eml_snd_dys_ctnt_mon", getEmlSndDysCtntMon());
		this.hashColumns.put("eml_snd_dys_ctnt_sun", getEmlSndDysCtntSun());
		this.hashColumns.put("eml_snd_dys_ctnt_tue_his", getEmlSndDysCtntTueHis());
		this.hashColumns.put("eml_snd_dys_ctnt_web_his", getEmlSndDysCtntWebHis());
		this.hashColumns.put("eml_jb_id", getEmlJbId());
		this.hashColumns.put("eml_snd_dys_ctnt_fri_his", getEmlSndDysCtntFriHis());
		this.hashColumns.put("eml_snd_dys_ctnt_sun_his", getEmlSndDysCtntSunHis());
		this.hashColumns.put("subsc_seq_his", getSubscSeqHis());
		this.hashColumns.put("eml_grp_id_his", getEmlGrpIdHis());
		this.hashColumns.put("svc_end_dt", getSvcEndDt());
		this.hashColumns.put("eml_snd_dys_ctnt_sat", getEmlSndDysCtntSat());
		this.hashColumns.put("eml_snd_dys_ctnt_thr", getEmlSndDysCtntThr());
		this.hashColumns.put("eml_snd_dys_ctnt_mon_his", getEmlSndDysCtntMonHis());
		this.hashColumns.put("vskd_dur_id", getVskdDurId());
		this.hashColumns.put("subsc_eml_his", getSubscEmlHis());
		this.hashColumns.put("svc_st_dt", getSvcStDt());
		this.hashColumns.put("eml_snd_dys_ctnt_fri", getEmlSndDysCtntFri());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("to_port_cd_his", getToPortCdHis());
		this.hashColumns.put("fm_port_cd_his", getFmPortCdHis());
		this.hashColumns.put("eml_grp_cd_desc_his", getEmlGrpCdDescHis());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vskd_dur_id_his", "vskdDurIdHis");
		this.hashFields.put("eml_snd_hr_his", "emlSndHrHis");
		this.hashFields.put("eml_snd_dys_ctnt_tue", "emlSndDysCtntTue");
		this.hashFields.put("vsl_slan_cd_his", "vslSlanCdHis");
		this.hashFields.put("subsc_eml", "subscEml");
		this.hashFields.put("eml_snd_dys_ctnt_sat_his", "emlSndDysCtntSatHis");
		this.hashFields.put("eml_snd_dys_ctnt_thr_his", "emlSndDysCtntThrHis");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_grp_id", "emlGrpId");
		this.hashFields.put("eml_snd_hr", "emlSndHr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_snd_dys_ctnt_web", "emlSndDysCtntWeb");
		this.hashFields.put("eml_snd_dys_ctnt_mon", "emlSndDysCtntMon");
		this.hashFields.put("eml_snd_dys_ctnt_sun", "emlSndDysCtntSun");
		this.hashFields.put("eml_snd_dys_ctnt_tue_his", "emlSndDysCtntTueHis");
		this.hashFields.put("eml_snd_dys_ctnt_web_his", "emlSndDysCtntWebHis");
		this.hashFields.put("eml_jb_id", "emlJbId");
		this.hashFields.put("eml_snd_dys_ctnt_fri_his", "emlSndDysCtntFriHis");
		this.hashFields.put("eml_snd_dys_ctnt_sun_his", "emlSndDysCtntSunHis");
		this.hashFields.put("subsc_seq_his", "subscSeqHis");
		this.hashFields.put("eml_grp_id_his", "emlGrpIdHis");
		this.hashFields.put("svc_end_dt", "svcEndDt");
		this.hashFields.put("eml_snd_dys_ctnt_sat", "emlSndDysCtntSat");
		this.hashFields.put("eml_snd_dys_ctnt_thr", "emlSndDysCtntThr");
		this.hashFields.put("eml_snd_dys_ctnt_mon_his", "emlSndDysCtntMonHis");
		this.hashFields.put("vskd_dur_id", "vskdDurId");
		this.hashFields.put("subsc_eml_his", "subscEmlHis");
		this.hashFields.put("svc_st_dt", "svcStDt");
		this.hashFields.put("eml_snd_dys_ctnt_fri", "emlSndDysCtntFri");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("to_port_cd_his", "toPortCdHis");
		this.hashFields.put("fm_port_cd_his", "fmPortCdHis");
		this.hashFields.put("eml_grp_cd_desc_his", "emlGrpCdDescHis");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vskdDurIdHis
	 */
	public String getVskdDurIdHis() {
		return this.vskdDurIdHis;
	}
	
	/**
	 * Column Info
	 * @return emlSndHrHis
	 */
	public String getEmlSndHrHis() {
		return this.emlSndHrHis;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntTue
	 */
	public String getEmlSndDysCtntTue() {
		return this.emlSndDysCtntTue;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCdHis
	 */
	public String getVslSlanCdHis() {
		return this.vslSlanCdHis;
	}
	
	/**
	 * Column Info
	 * @return subscEml
	 */
	public String getSubscEml() {
		return this.subscEml;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntSatHis
	 */
	public String getEmlSndDysCtntSatHis() {
		return this.emlSndDysCtntSatHis;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntThrHis
	 */
	public String getEmlSndDysCtntThrHis() {
		return this.emlSndDysCtntThrHis;
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
	 * @return emlGrpId
	 */
	public String getEmlGrpId() {
		return this.emlGrpId;
	}
	
	/**
	 * Column Info
	 * @return emlSndHr
	 */
	public String getEmlSndHr() {
		return this.emlSndHr;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntWeb
	 */
	public String getEmlSndDysCtntWeb() {
		return this.emlSndDysCtntWeb;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntMon
	 */
	public String getEmlSndDysCtntMon() {
		return this.emlSndDysCtntMon;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntSun
	 */
	public String getEmlSndDysCtntSun() {
		return this.emlSndDysCtntSun;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntTueHis
	 */
	public String getEmlSndDysCtntTueHis() {
		return this.emlSndDysCtntTueHis;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntWebHis
	 */
	public String getEmlSndDysCtntWebHis() {
		return this.emlSndDysCtntWebHis;
	}
	
	/**
	 * Column Info
	 * @return emlJbId
	 */
	public String getEmlJbId() {
		return this.emlJbId;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntFriHis
	 */
	public String getEmlSndDysCtntFriHis() {
		return this.emlSndDysCtntFriHis;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntSunHis
	 */
	public String getEmlSndDysCtntSunHis() {
		return this.emlSndDysCtntSunHis;
	}
	
	/**
	 * Column Info
	 * @return subscSeqHis
	 */
	public String getSubscSeqHis() {
		return this.subscSeqHis;
	}
	
	/**
	 * Column Info
	 * @return emlGrpIdHis
	 */
	public String getEmlGrpIdHis() {
		return this.emlGrpIdHis;
	}
	
	/**
	 * Column Info
	 * @return svcEndDt
	 */
	public String getSvcEndDt() {
		return this.svcEndDt;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntSat
	 */
	public String getEmlSndDysCtntSat() {
		return this.emlSndDysCtntSat;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntThr
	 */
	public String getEmlSndDysCtntThr() {
		return this.emlSndDysCtntThr;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntMonHis
	 */
	public String getEmlSndDysCtntMonHis() {
		return this.emlSndDysCtntMonHis;
	}
	
	/**
	 * Column Info
	 * @return vskdDurId
	 */
	public String getVskdDurId() {
		return this.vskdDurId;
	}
	
	/**
	 * Column Info
	 * @return subscEmlHis
	 */
	public String getSubscEmlHis() {
		return this.subscEmlHis;
	}
	
	/**
	 * Column Info
	 * @return svcStDt
	 */
	public String getSvcStDt() {
		return this.svcStDt;
	}
	
	/**
	 * Column Info
	 * @return emlSndDysCtntFri
	 */
	public String getEmlSndDysCtntFri() {
		return this.emlSndDysCtntFri;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	
	/**
	 * Column Info
	 * @return toPortCdHis
	 */
	public String getToPortCdHis() {
		return this.toPortCdHis;
	}

	/**
	 * Column Info
	 * @return fmPortCdHis
	 */
	public String getFmPortCdHis() {
		return fmPortCdHis;
	}

	/**
	 * Column Info
	 * @return emlGrpCdDescHis
	 */
	public String getEmlGrpCdDescHis() {
		return emlGrpCdDescHis;
	}

	/**
	 * Column Info
	 * @param vskdDurIdHis
	 */
	public void setVskdDurIdHis(String vskdDurIdHis) {
		this.vskdDurIdHis = vskdDurIdHis;
	}
	
	/**
	 * Column Info
	 * @param emlSndHrHis
	 */
	public void setEmlSndHrHis(String emlSndHrHis) {
		this.emlSndHrHis = emlSndHrHis;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntTue
	 */
	public void setEmlSndDysCtntTue(String emlSndDysCtntTue) {
		this.emlSndDysCtntTue = emlSndDysCtntTue;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCdHis
	 */
	public void setVslSlanCdHis(String vslSlanCdHis) {
		this.vslSlanCdHis = vslSlanCdHis;
	}
	
	/**
	 * Column Info
	 * @param subscEml
	 */
	public void setSubscEml(String subscEml) {
		this.subscEml = subscEml;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntSatHis
	 */
	public void setEmlSndDysCtntSatHis(String emlSndDysCtntSatHis) {
		this.emlSndDysCtntSatHis = emlSndDysCtntSatHis;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntThrHis
	 */
	public void setEmlSndDysCtntThrHis(String emlSndDysCtntThrHis) {
		this.emlSndDysCtntThrHis = emlSndDysCtntThrHis;
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
	 * @param emlGrpId
	 */
	public void setEmlGrpId(String emlGrpId) {
		this.emlGrpId = emlGrpId;
	}
	
	/**
	 * Column Info
	 * @param emlSndHr
	 */
	public void setEmlSndHr(String emlSndHr) {
		this.emlSndHr = emlSndHr;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntWeb
	 */
	public void setEmlSndDysCtntWeb(String emlSndDysCtntWeb) {
		this.emlSndDysCtntWeb = emlSndDysCtntWeb;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntMon
	 */
	public void setEmlSndDysCtntMon(String emlSndDysCtntMon) {
		this.emlSndDysCtntMon = emlSndDysCtntMon;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntSun
	 */
	public void setEmlSndDysCtntSun(String emlSndDysCtntSun) {
		this.emlSndDysCtntSun = emlSndDysCtntSun;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntTueHis
	 */
	public void setEmlSndDysCtntTueHis(String emlSndDysCtntTueHis) {
		this.emlSndDysCtntTueHis = emlSndDysCtntTueHis;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntWebHis
	 */
	public void setEmlSndDysCtntWebHis(String emlSndDysCtntWebHis) {
		this.emlSndDysCtntWebHis = emlSndDysCtntWebHis;
	}
	
	/**
	 * Column Info
	 * @param emlJbId
	 */
	public void setEmlJbId(String emlJbId) {
		this.emlJbId = emlJbId;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntFriHis
	 */
	public void setEmlSndDysCtntFriHis(String emlSndDysCtntFriHis) {
		this.emlSndDysCtntFriHis = emlSndDysCtntFriHis;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntSunHis
	 */
	public void setEmlSndDysCtntSunHis(String emlSndDysCtntSunHis) {
		this.emlSndDysCtntSunHis = emlSndDysCtntSunHis;
	}
	
	/**
	 * Column Info
	 * @param subscSeqHis
	 */
	public void setSubscSeqHis(String subscSeqHis) {
		this.subscSeqHis = subscSeqHis;
	}
	
	/**
	 * Column Info
	 * @param emlGrpIdHis
	 */
	public void setEmlGrpIdHis(String emlGrpIdHis) {
		this.emlGrpIdHis = emlGrpIdHis;
	}
	
	/**
	 * Column Info
	 * @param svcEndDt
	 */
	public void setSvcEndDt(String svcEndDt) {
		this.svcEndDt = svcEndDt;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntSat
	 */
	public void setEmlSndDysCtntSat(String emlSndDysCtntSat) {
		this.emlSndDysCtntSat = emlSndDysCtntSat;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntThr
	 */
	public void setEmlSndDysCtntThr(String emlSndDysCtntThr) {
		this.emlSndDysCtntThr = emlSndDysCtntThr;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntMonHis
	 */
	public void setEmlSndDysCtntMonHis(String emlSndDysCtntMonHis) {
		this.emlSndDysCtntMonHis = emlSndDysCtntMonHis;
	}
	
	/**
	 * Column Info
	 * @param vskdDurId
	 */
	public void setVskdDurId(String vskdDurId) {
		this.vskdDurId = vskdDurId;
	}
	
	/**
	 * Column Info
	 * @param subscEmlHis
	 */
	public void setSubscEmlHis(String subscEmlHis) {
		this.subscEmlHis = subscEmlHis;
	}
	
	/**
	 * Column Info
	 * @param svcStDt
	 */
	public void setSvcStDt(String svcStDt) {
		this.svcStDt = svcStDt;
	}
	
	/**
	 * Column Info
	 * @param emlSndDysCtntFri
	 */
	public void setEmlSndDysCtntFri(String emlSndDysCtntFri) {
		this.emlSndDysCtntFri = emlSndDysCtntFri;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	/**
	 * Column Info
	 * @param toPortCdHis
	 */
	public void setToPortCdHis(String toPortCdHis) {
		this.toPortCdHis = toPortCdHis;
	}
	
	/**
	 * Column Info
	 * @param fmPortCdHis
	 */
	public void setFmPortCdHis(String fmPortCdHis) {
		this.fmPortCdHis = fmPortCdHis;
	}

	/**
	 * Column Info
	 * @param emlGrpCdDescHis
	 */
	public void setEmlGrpCdDescHis(String emlGrpCdDescHis) {
		this.emlGrpCdDescHis = emlGrpCdDescHis;
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
		setVskdDurIdHis(JSPUtil.getParameter(request, prefix + "vskd_dur_id_his", ""));
		setEmlSndHrHis(JSPUtil.getParameter(request, prefix + "eml_snd_hr_his", ""));
		setEmlSndDysCtntTue(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_tue", ""));
		setVslSlanCdHis(JSPUtil.getParameter(request, prefix + "vsl_slan_cd_his", ""));
		setSubscEml(JSPUtil.getParameter(request, prefix + "subsc_eml", ""));
		setEmlSndDysCtntSatHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_sat_his", ""));
		setEmlSndDysCtntThrHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_thr_his", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEmlGrpId(JSPUtil.getParameter(request, prefix + "eml_grp_id", ""));
		setEmlSndHr(JSPUtil.getParameter(request, prefix + "eml_snd_hr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmlSndDysCtntWeb(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_web", ""));
		setEmlSndDysCtntMon(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_mon", ""));
		setEmlSndDysCtntSun(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_sun", ""));
		setEmlSndDysCtntTueHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_tue_his", ""));
		setEmlSndDysCtntWebHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_web_his", ""));
		setEmlJbId(JSPUtil.getParameter(request, prefix + "eml_jb_id", ""));
		setEmlSndDysCtntFriHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_fri_his", ""));
		setEmlSndDysCtntSunHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_sun_his", ""));
		setSubscSeqHis(JSPUtil.getParameter(request, prefix + "subsc_seq_his", ""));
		setEmlGrpIdHis(JSPUtil.getParameter(request, prefix + "eml_grp_id_his", ""));
		setSvcEndDt(JSPUtil.getParameter(request, prefix + "svc_end_dt", ""));
		setEmlSndDysCtntSat(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_sat", ""));
		setEmlSndDysCtntThr(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_thr", ""));
		setEmlSndDysCtntMonHis(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_mon_his", ""));
		setVskdDurId(JSPUtil.getParameter(request, prefix + "vskd_dur_id", ""));
		setSubscEmlHis(JSPUtil.getParameter(request, prefix + "subsc_eml_his", ""));
		setSvcStDt(JSPUtil.getParameter(request, prefix + "svc_st_dt", ""));
		setEmlSndDysCtntFri(JSPUtil.getParameter(request, prefix + "eml_snd_dys_ctnt_fri", ""));
		setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
		setToPortCdHis(JSPUtil.getParameter(request, prefix + "to_port_cd_his", ""));
		setFmPortCdHis(JSPUtil.getParameter(request, prefix + "fm_port_cd_his", ""));
		setEmlGrpCdDescHis(JSPUtil.getParameter(request, prefix + "eml_grp_cd_desc_his", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdEmlSetUpVO[]
	 */
	public VslSkdEmlSetUpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdEmlSetUpVO[]
	 */
	public VslSkdEmlSetUpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdEmlSetUpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vskdDurIdHis = (JSPUtil.getParameter(request, prefix	+ "vskd_dur_id_his", length));
			String[] emlSndHrHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_hr_his", length));
			String[] emlSndDysCtntTue = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_tue", length));
			String[] vslSlanCdHis = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd_his", length));
			String[] subscEml = (JSPUtil.getParameter(request, prefix	+ "subsc_eml", length));
			String[] emlSndDysCtntSatHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_sat_his", length));
			String[] emlSndDysCtntThrHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_thr_his", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlGrpId = (JSPUtil.getParameter(request, prefix	+ "eml_grp_id", length));
			String[] emlSndHr = (JSPUtil.getParameter(request, prefix	+ "eml_snd_hr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlSndDysCtntWeb = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_web", length));
			String[] emlSndDysCtntMon = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_mon", length));
			String[] emlSndDysCtntSun = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_sun", length));
			String[] emlSndDysCtntTueHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_tue_his", length));
			String[] emlSndDysCtntWebHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_web_his", length));
			String[] emlJbId = (JSPUtil.getParameter(request, prefix	+ "eml_jb_id", length));
			String[] emlSndDysCtntFriHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_fri_his", length));
			String[] emlSndDysCtntSunHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_sun_his", length));
			String[] subscSeqHis = (JSPUtil.getParameter(request, prefix	+ "subsc_seq_his", length));
			String[] emlGrpIdHis = (JSPUtil.getParameter(request, prefix	+ "eml_grp_id_his", length));
			String[] svcEndDt = (JSPUtil.getParameter(request, prefix	+ "svc_end_dt", length));
			String[] emlSndDysCtntSat = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_sat", length));
			String[] emlSndDysCtntThr = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_thr", length));
			String[] emlSndDysCtntMonHis = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_mon_his", length));
			String[] vskdDurId = (JSPUtil.getParameter(request, prefix	+ "vskd_dur_id", length));
			String[] subscEmlHis = (JSPUtil.getParameter(request, prefix	+ "subsc_eml_his", length));
			String[] svcStDt = (JSPUtil.getParameter(request, prefix	+ "svc_st_dt", length));
			String[] emlSndDysCtntFri = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dys_ctnt_fri", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] toPortCdHis = (JSPUtil.getParameter(request, prefix	+ "to_port_cd_his", length));
			String[] fmPortCdHis = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd_his", length));
			String[] emlGrpCdDescHis = (JSPUtil.getParameter(request, prefix	+ "eml_grp_cd_desc_his", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdEmlSetUpVO();
				if (vskdDurIdHis[i] != null)
					model.setVskdDurIdHis(vskdDurIdHis[i]);
				if (emlSndHrHis[i] != null)
					model.setEmlSndHrHis(emlSndHrHis[i]);
				if (emlSndDysCtntTue[i] != null)
					model.setEmlSndDysCtntTue(emlSndDysCtntTue[i]);
				if (vslSlanCdHis[i] != null)
					model.setVslSlanCdHis(vslSlanCdHis[i]);
				if (subscEml[i] != null)
					model.setSubscEml(subscEml[i]);
				if (emlSndDysCtntSatHis[i] != null)
					model.setEmlSndDysCtntSatHis(emlSndDysCtntSatHis[i]);
				if (emlSndDysCtntThrHis[i] != null)
					model.setEmlSndDysCtntThrHis(emlSndDysCtntThrHis[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlGrpId[i] != null)
					model.setEmlGrpId(emlGrpId[i]);
				if (emlSndHr[i] != null)
					model.setEmlSndHr(emlSndHr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlSndDysCtntWeb[i] != null)
					model.setEmlSndDysCtntWeb(emlSndDysCtntWeb[i]);
				if (emlSndDysCtntMon[i] != null)
					model.setEmlSndDysCtntMon(emlSndDysCtntMon[i]);
				if (emlSndDysCtntSun[i] != null)
					model.setEmlSndDysCtntSun(emlSndDysCtntSun[i]);
				if (emlSndDysCtntTueHis[i] != null)
					model.setEmlSndDysCtntTueHis(emlSndDysCtntTueHis[i]);
				if (emlSndDysCtntWebHis[i] != null)
					model.setEmlSndDysCtntWebHis(emlSndDysCtntWebHis[i]);
				if (emlJbId[i] != null)
					model.setEmlJbId(emlJbId[i]);
				if (emlSndDysCtntFriHis[i] != null)
					model.setEmlSndDysCtntFriHis(emlSndDysCtntFriHis[i]);
				if (emlSndDysCtntSunHis[i] != null)
					model.setEmlSndDysCtntSunHis(emlSndDysCtntSunHis[i]);
				if (subscSeqHis[i] != null)
					model.setSubscSeqHis(subscSeqHis[i]);
				if (emlGrpIdHis[i] != null)
					model.setEmlGrpIdHis(emlGrpIdHis[i]);
				if (svcEndDt[i] != null)
					model.setSvcEndDt(svcEndDt[i]);
				if (emlSndDysCtntSat[i] != null)
					model.setEmlSndDysCtntSat(emlSndDysCtntSat[i]);
				if (emlSndDysCtntThr[i] != null)
					model.setEmlSndDysCtntThr(emlSndDysCtntThr[i]);
				if (emlSndDysCtntMonHis[i] != null)
					model.setEmlSndDysCtntMonHis(emlSndDysCtntMonHis[i]);
				if (vskdDurId[i] != null)
					model.setVskdDurId(vskdDurId[i]);
				if (subscEmlHis[i] != null)
					model.setSubscEmlHis(subscEmlHis[i]);
				if (svcStDt[i] != null)
					model.setSvcStDt(svcStDt[i]);
				if (emlSndDysCtntFri[i] != null)
					model.setEmlSndDysCtntFri(emlSndDysCtntFri[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (toPortCdHis[i] != null)
					model.setToPortCdHis(toPortCdHis[i]);
				if (fmPortCdHis[i] != null)
					model.setFmPortCdHis(fmPortCdHis[i]);
				if (emlGrpCdDescHis[i] != null)
					model.setEmlGrpCdDescHis(emlGrpCdDescHis[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdEmlSetUpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdEmlSetUpVO[]
	 */
	public VslSkdEmlSetUpVO[] getVslSkdEmlSetUpVOs(){
		VslSkdEmlSetUpVO[] vos = (VslSkdEmlSetUpVO[])models.toArray(new VslSkdEmlSetUpVO[models.size()]);
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
		this.vskdDurIdHis = this.vskdDurIdHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndHrHis = this.emlSndHrHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntTue = this.emlSndDysCtntTue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCdHis = this.vslSlanCdHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscEml = this.subscEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntSatHis = this.emlSndDysCtntSatHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntThrHis = this.emlSndDysCtntThrHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlGrpId = this.emlGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndHr = this.emlSndHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntWeb = this.emlSndDysCtntWeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntMon = this.emlSndDysCtntMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntSun = this.emlSndDysCtntSun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntTueHis = this.emlSndDysCtntTueHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntWebHis = this.emlSndDysCtntWebHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlJbId = this.emlJbId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntFriHis = this.emlSndDysCtntFriHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntSunHis = this.emlSndDysCtntSunHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscSeqHis = this.subscSeqHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlGrpIdHis = this.emlGrpIdHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcEndDt = this.svcEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntSat = this.emlSndDysCtntSat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntThr = this.emlSndDysCtntThr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntMonHis = this.emlSndDysCtntMonHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdDurId = this.vskdDurId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscEmlHis = this.subscEmlHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcStDt = this.svcStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDysCtntFri = this.emlSndDysCtntFri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCdHis = this.toPortCdHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCdHis = this.fmPortCdHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlGrpCdDescHis = this.emlGrpCdDescHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
