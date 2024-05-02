/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaTableSaveVO.java
*@FileTitle : BsaTableSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.11.18 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaTableSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaTableSaveVO> models = new ArrayList<BsaTableSaveVO>();
	
	/* Column Info */
	private String rdoopcd = null;
	/* Column Info */
	private String crrbsacapa = null;
	/* Column Info */
	private String vslseq = null;
	/* Column Info */
	private String schtdesc = null;
	/* Column Info */
	private String dircd = null;
	/* Column Info */
	private String fnlcobsacapa = null;
	/* Column Info */
	private String subtrdcd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslcd = null;
	/* Column Info */
	private String cofnlbsacapa = null;
	/* Column Info */
	private String vslcapa = null;
	/* Column Info */
	private String bsatodt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spcotrswapflg = null;
	/* Column Info */
	private String updusrid = null;
	/* Column Info */
	private String jodesc = null;
	/* Column Info */
	private String bsaopjbcd2 = null;
	/* Column Info */
	private String vopcd = null;
	/* Column Info */
	private String vslmltinpflg = null;
	/* Column Info */
	private String trdcd = null;
	/* Column Info */
	private String rlanecd = null;
	/* Column Info */
	private String rdotype = null;
	/* Column Info */
	private String bsaopjbcd = null;
	/* Column Info */
	private String bsacapa = null;
	/* Column Info */
	private String bsafmdt = null;
	/* Column Info */
	private String bsaseq = null;
	/* Column Info */
	private String vslbsachkflg = null;
	/* Column Info */
	private String cobsabfrsubcapa = null;
	/* Column Info */
	private String jheader = null;
	/* Column Info */
	private String ownrvslwgt = null;
	/* Column Info */
	private String vvdcd = null;
	/* Column Info */
	private String sheader = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaTableSaveVO() {}

	public BsaTableSaveVO(String ibflag, String pagerows, String bsaseq, String vvdcd, String bsafmdt, String bsatodt, String trdcd, String subtrdcd, String rlanecd, String dircd, String vopcd, String vslcapa, String bsacapa, String fnlcobsacapa, String cobsabfrsubcapa, String spcotrswapflg, String ownrvslwgt, String updusrid, String crrbsacapa, String jodesc, String vslbsachkflg, String vslseq, String vslcd, String cofnlbsacapa, String vslmltinpflg, String schtdesc, String bsaopjbcd, String bsaopjbcd2, String jheader, String sheader, String rdoopcd, String rdotype) {
		this.rdoopcd = rdoopcd;
		this.crrbsacapa = crrbsacapa;
		this.vslseq = vslseq;
		this.schtdesc = schtdesc;
		this.dircd = dircd;
		this.fnlcobsacapa = fnlcobsacapa;
		this.subtrdcd = subtrdcd;
		this.pagerows = pagerows;
		this.vslcd = vslcd;
		this.cofnlbsacapa = cofnlbsacapa;
		this.vslcapa = vslcapa;
		this.bsatodt = bsatodt;
		this.ibflag = ibflag;
		this.spcotrswapflg = spcotrswapflg;
		this.updusrid = updusrid;
		this.jodesc = jodesc;
		this.bsaopjbcd2 = bsaopjbcd2;
		this.vopcd = vopcd;
		this.vslmltinpflg = vslmltinpflg;
		this.trdcd = trdcd;
		this.rlanecd = rlanecd;
		this.rdotype = rdotype;
		this.bsaopjbcd = bsaopjbcd;
		this.bsacapa = bsacapa;
		this.bsafmdt = bsafmdt;
		this.bsaseq = bsaseq;
		this.vslbsachkflg = vslbsachkflg;
		this.cobsabfrsubcapa = cobsabfrsubcapa;
		this.jheader = jheader;
		this.ownrvslwgt = ownrvslwgt;
		this.vvdcd = vvdcd;
		this.sheader = sheader;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rdoopcd", getRdoopcd());
		this.hashColumns.put("crrbsacapa", getCrrbsacapa());
		this.hashColumns.put("vslseq", getVslseq());
		this.hashColumns.put("schtdesc", getSchtdesc());
		this.hashColumns.put("dircd", getDircd());
		this.hashColumns.put("fnlcobsacapa", getFnlcobsacapa());
		this.hashColumns.put("subtrdcd", getSubtrdcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vslcd", getVslcd());
		this.hashColumns.put("cofnlbsacapa", getCofnlbsacapa());
		this.hashColumns.put("vslcapa", getVslcapa());
		this.hashColumns.put("bsatodt", getBsatodt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcotrswapflg", getSpcotrswapflg());
		this.hashColumns.put("updusrid", getUpdusrid());
		this.hashColumns.put("jodesc", getJodesc());
		this.hashColumns.put("bsaopjbcd2", getBsaopjbcd2());
		this.hashColumns.put("vopcd", getVopcd());
		this.hashColumns.put("vslmltinpflg", getVslmltinpflg());
		this.hashColumns.put("trdcd", getTrdcd());
		this.hashColumns.put("rlanecd", getRlanecd());
		this.hashColumns.put("rdotype", getRdotype());
		this.hashColumns.put("bsaopjbcd", getBsaopjbcd());
		this.hashColumns.put("bsacapa", getBsacapa());
		this.hashColumns.put("bsafmdt", getBsafmdt());
		this.hashColumns.put("bsaseq", getBsaseq());
		this.hashColumns.put("vslbsachkflg", getVslbsachkflg());
		this.hashColumns.put("cobsabfrsubcapa", getCobsabfrsubcapa());
		this.hashColumns.put("jheader", getJheader());
		this.hashColumns.put("ownrvslwgt", getOwnrvslwgt());
		this.hashColumns.put("vvdcd", getVvdcd());
		this.hashColumns.put("sheader", getSheader());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rdoopcd", "rdoopcd");
		this.hashFields.put("crr_bsa_capa", "crrbsacapa");
		this.hashFields.put("vsl_seq", "vslseq");
		this.hashFields.put("scht_desc", "schtdesc");
		this.hashFields.put("dir_cd", "dircd");
		this.hashFields.put("fnl_co_bsa_capa", "fnlcobsacapa");
		this.hashFields.put("sub_trd_cd", "subtrdcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslcd");
		this.hashFields.put("co_fnl_bsa_capa", "cofnlbsacapa");
		this.hashFields.put("vsl_capa", "vslcapa");
		this.hashFields.put("bsa_to_dt", "bsatodt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spc_otr_swap_flg", "spcotrswapflg");
		this.hashFields.put("upd_usr_id", "updusrid");
		this.hashFields.put("jo_desc", "jodesc");
		this.hashFields.put("bsa_op_jb_cd2", "bsaopjbcd2");
		this.hashFields.put("vop_cd", "vopcd");
		this.hashFields.put("vsl_mlt_inp_flg", "vslmltinpflg");
		this.hashFields.put("trd_cd", "trdcd");
		this.hashFields.put("rlane_cd", "rlanecd");
		this.hashFields.put("rdotype", "rdotype");
		this.hashFields.put("bsa_op_jb_cd", "bsaopjbcd");
		this.hashFields.put("bsa_capa", "bsacapa");
		this.hashFields.put("bsa_fm_dt", "bsafmdt");
		this.hashFields.put("bsa_seq", "bsaseq");
		this.hashFields.put("vsl_bsa_chk_flg", "vslbsachkflg");
		this.hashFields.put("co_bsa_bfr_sub_capa", "cobsabfrsubcapa");
		this.hashFields.put("jheader", "jheader");
		this.hashFields.put("ownr_vsl_wgt", "ownrvslwgt");
		this.hashFields.put("vvd_cd", "vvdcd");
		this.hashFields.put("sheader", "sheader");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdoopcd
	 */
	public String getRdoopcd() {
		return this.rdoopcd;
	}
	
	/**
	 * Column Info
	 * @return crrbsacapa
	 */
	public String getCrrbsacapa() {
		return this.crrbsacapa;
	}
	
	/**
	 * Column Info
	 * @return vslseq
	 */
	public String getVslseq() {
		return this.vslseq;
	}
	
	/**
	 * Column Info
	 * @return schtdesc
	 */
	public String getSchtdesc() {
		return this.schtdesc;
	}
	
	/**
	 * Column Info
	 * @return dircd
	 */
	public String getDircd() {
		return this.dircd;
	}
	
	/**
	 * Column Info
	 * @return fnlcobsacapa
	 */
	public String getFnlcobsacapa() {
		return this.fnlcobsacapa;
	}
	
	/**
	 * Column Info
	 * @return subtrdcd
	 */
	public String getSubtrdcd() {
		return this.subtrdcd;
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
	 * @return vslcd
	 */
	public String getVslcd() {
		return this.vslcd;
	}
	
	/**
	 * Column Info
	 * @return cofnlbsacapa
	 */
	public String getCofnlbsacapa() {
		return this.cofnlbsacapa;
	}
	
	/**
	 * Column Info
	 * @return vslcapa
	 */
	public String getVslcapa() {
		return this.vslcapa;
	}
	
	/**
	 * Column Info
	 * @return bsatodt
	 */
	public String getBsatodt() {
		return this.bsatodt;
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
	 * @return spcotrswapflg
	 */
	public String getSpcotrswapflg() {
		return this.spcotrswapflg;
	}
	
	/**
	 * Column Info
	 * @return updusrid
	 */
	public String getUpdusrid() {
		return this.updusrid;
	}
	
	/**
	 * Column Info
	 * @return jodesc
	 */
	public String getJodesc() {
		return this.jodesc;
	}
	
	/**
	 * Column Info
	 * @return bsaopjbcd2
	 */
	public String getBsaopjbcd2() {
		return this.bsaopjbcd2;
	}
	
	/**
	 * Column Info
	 * @return vopcd
	 */
	public String getVopcd() {
		return this.vopcd;
	}
	
	/**
	 * Column Info
	 * @return vslmltinpflg
	 */
	public String getVslmltinpflg() {
		return this.vslmltinpflg;
	}
	
	/**
	 * Column Info
	 * @return trdcd
	 */
	public String getTrdcd() {
		return this.trdcd;
	}
	
	/**
	 * Column Info
	 * @return rlanecd
	 */
	public String getRlanecd() {
		return this.rlanecd;
	}
	
	/**
	 * Column Info
	 * @return rdotype
	 */
	public String getRdotype() {
		return this.rdotype;
	}
	
	/**
	 * Column Info
	 * @return bsaopjbcd
	 */
	public String getBsaopjbcd() {
		return this.bsaopjbcd;
	}
	
	/**
	 * Column Info
	 * @return bsacapa
	 */
	public String getBsacapa() {
		return this.bsacapa;
	}
	
	/**
	 * Column Info
	 * @return bsafmdt
	 */
	public String getBsafmdt() {
		return this.bsafmdt;
	}
	
	/**
	 * Column Info
	 * @return bsaseq
	 */
	public String getBsaseq() {
		return this.bsaseq;
	}
	
	/**
	 * Column Info
	 * @return vslbsachkflg
	 */
	public String getVslbsachkflg() {
		return this.vslbsachkflg;
	}
	
	/**
	 * Column Info
	 * @return cobsabfrsubcapa
	 */
	public String getCobsabfrsubcapa() {
		return this.cobsabfrsubcapa;
	}
	
	/**
	 * Column Info
	 * @return jheader
	 */
	public String getJheader() {
		return this.jheader;
	}
	
	/**
	 * Column Info
	 * @return ownrvslwgt
	 */
	public String getOwnrvslwgt() {
		return this.ownrvslwgt;
	}
	
	/**
	 * Column Info
	 * @return vvdcd
	 */
	public String getVvdcd() {
		return this.vvdcd;
	}
	
	/**
	 * Column Info
	 * @return sheader
	 */
	public String getSheader() {
		return this.sheader;
	}
	

	/**
	 * Column Info
	 * @param rdoopcd
	 */
	public void setRdoopcd(String rdoopcd) {
		this.rdoopcd = rdoopcd;
	}
	
	/**
	 * Column Info
	 * @param crrbsacapa
	 */
	public void setCrrbsacapa(String crrbsacapa) {
		this.crrbsacapa = crrbsacapa;
	}
	
	/**
	 * Column Info
	 * @param vslseq
	 */
	public void setVslseq(String vslseq) {
		this.vslseq = vslseq;
	}
	
	/**
	 * Column Info
	 * @param schtdesc
	 */
	public void setSchtdesc(String schtdesc) {
		this.schtdesc = schtdesc;
	}
	
	/**
	 * Column Info
	 * @param dircd
	 */
	public void setDircd(String dircd) {
		this.dircd = dircd;
	}
	
	/**
	 * Column Info
	 * @param fnlcobsacapa
	 */
	public void setFnlcobsacapa(String fnlcobsacapa) {
		this.fnlcobsacapa = fnlcobsacapa;
	}
	
	/**
	 * Column Info
	 * @param subtrdcd
	 */
	public void setSubtrdcd(String subtrdcd) {
		this.subtrdcd = subtrdcd;
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
	 * @param vslcd
	 */
	public void setVslcd(String vslcd) {
		this.vslcd = vslcd;
	}
	
	/**
	 * Column Info
	 * @param cofnlbsacapa
	 */
	public void setCofnlbsacapa(String cofnlbsacapa) {
		this.cofnlbsacapa = cofnlbsacapa;
	}
	
	/**
	 * Column Info
	 * @param vslcapa
	 */
	public void setVslcapa(String vslcapa) {
		this.vslcapa = vslcapa;
	}
	
	/**
	 * Column Info
	 * @param bsatodt
	 */
	public void setBsatodt(String bsatodt) {
		this.bsatodt = bsatodt;
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
	 * @param spcotrswapflg
	 */
	public void setSpcotrswapflg(String spcotrswapflg) {
		this.spcotrswapflg = spcotrswapflg;
	}
	
	/**
	 * Column Info
	 * @param updusrid
	 */
	public void setUpdusrid(String updusrid) {
		this.updusrid = updusrid;
	}
	
	/**
	 * Column Info
	 * @param jodesc
	 */
	public void setJodesc(String jodesc) {
		this.jodesc = jodesc;
	}
	
	/**
	 * Column Info
	 * @param bsaopjbcd2
	 */
	public void setBsaopjbcd2(String bsaopjbcd2) {
		this.bsaopjbcd2 = bsaopjbcd2;
	}
	
	/**
	 * Column Info
	 * @param vopcd
	 */
	public void setVopcd(String vopcd) {
		this.vopcd = vopcd;
	}
	
	/**
	 * Column Info
	 * @param vslmltinpflg
	 */
	public void setVslmltinpflg(String vslmltinpflg) {
		this.vslmltinpflg = vslmltinpflg;
	}
	
	/**
	 * Column Info
	 * @param trdcd
	 */
	public void setTrdcd(String trdcd) {
		this.trdcd = trdcd;
	}
	
	/**
	 * Column Info
	 * @param rlanecd
	 */
	public void setRlanecd(String rlanecd) {
		this.rlanecd = rlanecd;
	}
	
	/**
	 * Column Info
	 * @param rdotype
	 */
	public void setRdotype(String rdotype) {
		this.rdotype = rdotype;
	}
	
	/**
	 * Column Info
	 * @param bsaopjbcd
	 */
	public void setBsaopjbcd(String bsaopjbcd) {
		this.bsaopjbcd = bsaopjbcd;
	}
	
	/**
	 * Column Info
	 * @param bsacapa
	 */
	public void setBsacapa(String bsacapa) {
		this.bsacapa = bsacapa;
	}
	
	/**
	 * Column Info
	 * @param bsafmdt
	 */
	public void setBsafmdt(String bsafmdt) {
		this.bsafmdt = bsafmdt;
	}
	
	/**
	 * Column Info
	 * @param bsaseq
	 */
	public void setBsaseq(String bsaseq) {
		this.bsaseq = bsaseq;
	}
	
	/**
	 * Column Info
	 * @param vslbsachkflg
	 */
	public void setVslbsachkflg(String vslbsachkflg) {
		this.vslbsachkflg = vslbsachkflg;
	}
	
	/**
	 * Column Info
	 * @param cobsabfrsubcapa
	 */
	public void setCobsabfrsubcapa(String cobsabfrsubcapa) {
		this.cobsabfrsubcapa = cobsabfrsubcapa;
	}
	
	/**
	 * Column Info
	 * @param jheader
	 */
	public void setJheader(String jheader) {
		this.jheader = jheader;
	}
	
	/**
	 * Column Info
	 * @param ownrvslwgt
	 */
	public void setOwnrvslwgt(String ownrvslwgt) {
		this.ownrvslwgt = ownrvslwgt;
	}
	
	/**
	 * Column Info
	 * @param vvdcd
	 */
	public void setVvdcd(String vvdcd) {
		this.vvdcd = vvdcd;
	}
	
	/**
	 * Column Info
	 * @param sheader
	 */
	public void setSheader(String sheader) {
		this.sheader = sheader;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
		setBsaopjbcd2(JSPUtil.getParameter(request, "bsa_op_jb_cd2", ""));
		setBsaopjbcd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setJheader(JSPUtil.getParameter(request, "jHeader", ""));
		setSheader(JSPUtil.getParameter(request, "sHeader", ""));
		setRdotype(JSPUtil.getParameter(request, "rdoType", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaTableSaveVO[]
	 */
	public BsaTableSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaTableSaveVO[]
	 */
	public BsaTableSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaTableSaveVO model = null;
		
		String[] tmp = request.getParameterValues("ibflag");
		String[] arrHeader = null;
		
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues( "ibflag").length;
  		
  		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
  		setBsaopjbcd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
  		setBsaopjbcd2(JSPUtil.getParameter(request, "bsa_op_jb_cd2", ""));
  		setJheader(JSPUtil.getParameter(request, "jHeader", ""));
		setSheader(JSPUtil.getParameter(request, "sHeader", ""));
		
		if (getRdoopcd().length()>0) { 
			rdoopcd = getRdoopcd();  
		}
		
		if (getBsaopjbcd().length()>0) { 
			bsaopjbcd = getBsaopjbcd().substring(1);  
		}
		
		if (getBsaopjbcd2().length()>0) { 
			bsaopjbcd2 = getBsaopjbcd2().substring(1);  
		}
		
		if (getJheader().length()>0) { 
			jheader = getJheader().substring(1);  
		}
		if (getSheader().length()>0){ 
			sheader = getSheader().substring(1); 
		}
		
		if (rdoopcd.equals("J")){
			arrHeader = jheader.split("[|]");	
		}else{
			arrHeader = sheader.split("[|]");	
		}
			
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, 		"pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, 		"ibflag", length));
			String[] vslseq = (JSPUtil.getParameter(request, 		prefix	+ "vsl_seq", length));
			String[] schtdesc = (JSPUtil.getParameter(request, 		prefix	+ "scht_desc", length));
			String[] dircd = (JSPUtil.getParameter(request, 		prefix	+ "dir_cd", length));
			String[] fnlcobsacapa = (JSPUtil.getParameter(request, prefix	+ "fnl_co_bsa_capa", length));
			String[] subtrdcd = (JSPUtil.getParameter(request, 		prefix	+ "sub_trd_cd", length));
			String[] vslcd = (JSPUtil.getParameter(request, 		prefix	+ "vsl_cd", length));
			String[] cofnlbsacapa = (JSPUtil.getParameter(request, prefix	+ "co_fnl_bsa_capa", length));
			String[] vslcapa = (JSPUtil.getParameter(request, 		prefix	+ "vsl_capa", length));
			String[] bsatodt = (JSPUtil.getParameter(request, 		prefix	+ "bsa_to_dt", length));
			String[] spcotrswapflg = (JSPUtil.getParameter(request, prefix	+ "spc_otr_swap_flg", length));
			String[] updusrid = (JSPUtil.getParameter(request, 		prefix	+ "upd_usr_id", length));
			String[] jodesc = (JSPUtil.getParameter(request, 		prefix	+ "jo_desc", length));
			String[] vopcd = (JSPUtil.getParameter(request, 		prefix	+ "vop_cd", length));
			String[] vslmltinpflg = (JSPUtil.getParameter(request, 	prefix	+ "vsl_mlt_inp_flg", length));
			String[] trdcd = (JSPUtil.getParameter(request, 		prefix	+ "trd_cd", length));
			String[] rlanecd = (JSPUtil.getParameter(request, 		prefix	+ "rlane_cd", length));
			String[] bsacapa = (JSPUtil.getParameter(request, 		prefix	+ "bsa_capa", length));
			String[] bsafmdt = (JSPUtil.getParameter(request, 		prefix	+ "bsa_fm_dt", length));
			String[] bsaseq = (JSPUtil.getParameter(request, 		prefix	+ "bsa_seq", length));
			String[] vslbsachkflg = (JSPUtil.getParameter(request, 	prefix	+ "vsl_bsa_chk_flg", length));
			String[] cobsabfrsubcapa = (JSPUtil.getParameter(request, prefix	+ "co_bsa_bfr_sub_capa", length));
			String[] ownrvslwgt = (JSPUtil.getParameter(request, 	prefix	+ "ownr_vsl_wgt", length));
			String[] vvdcd = (JSPUtil.getParameter(request, 		prefix	+ "vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaTableSaveVO();
				String crrBsaCapa="";
				
				if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
				if (bsaseq[i] != null)					model.setBsaseq(bsaseq[i]);
				if (vvdcd[i] != null)					model.setVvdcd(vvdcd[i]);
				if (bsafmdt[i] != null)					model.setBsafmdt(bsafmdt[i]);
				if (bsatodt[i] != null)					model.setBsatodt(bsatodt[i]);

				if (trdcd[i] != null)					model.setTrdcd(trdcd[i]);
				if (subtrdcd[i] != null)				model.setSubtrdcd(subtrdcd[i]);
				if (rlanecd[i] != null)					model.setRlanecd(rlanecd[i]);
				if (dircd[i] != null)					model.setDircd(dircd[i]);
				if (vopcd[i] != null)					model.setVopcd(vopcd[i]);
				if (vslbsachkflg[i] != null)			model.setVslbsachkflg(vslbsachkflg[i]);
				if (vslseq[i] != null)					model.setVslseq(vslseq[i]);

				if (vslcapa[i] != null)					model.setVslcapa(vslcapa[i]);
				if (vslcd[i] != null)					model.setVslcd(vslcd[i]);
				if (bsacapa[i] != null)					model.setBsacapa(bsacapa[i]);
				if (fnlcobsacapa[i] != null)			model.setFnlcobsacapa(fnlcobsacapa[i]);
				if (cofnlbsacapa[i] != null)			model.setCofnlbsacapa(cofnlbsacapa[i]);
				if (cobsabfrsubcapa[i] != null)		model.setCobsabfrsubcapa(cobsabfrsubcapa[i]);
				if (vslmltinpflg[i] != null)			model.setVslmltinpflg(vslmltinpflg[i]);
				
				if (spcotrswapflg[i] != null)			model.setSpcotrswapflg(spcotrswapflg[i]);
				if (ownrvslwgt[i] != null)				model.setOwnrvslwgt(ownrvslwgt[i]);
				if (updusrid[i] != null)				model.setUpdusrid(updusrid[i]);
				if (jodesc[i] != null)					model.setJodesc(jodesc[i]);
				if (schtdesc[i] != null)				model.setSchtdesc(schtdesc[i]);
				if (rdoopcd != null)					model.setRdoopcd(rdoopcd);
				if (bsaopjbcd !=null)					model.setBsaopjbcd(bsaopjbcd);
				if (bsaopjbcd2 !=null)					model.setBsaopjbcd2(bsaopjbcd2);
				if (jheader != null)					model.setJheader(jheader);
				if (sheader != null)					model.setSheader(sheader);
				
				for (int j = 0; j < arrHeader.length; j++) {
					String[] crrbsacapa_tmp = (JSPUtil.getParameter(request,  "D_crr_bsa_capa"+j, length));
					crrBsaCapa = crrBsaCapa + crrbsacapa_tmp[i] +"|";
				}
				if (crrBsaCapa != null)				model.setCrrbsacapa(crrBsaCapa);
					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaTableSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaTableSaveVO[]
	 */
	public BsaTableSaveVO[] getBsaTableSaveVOs(){
		BsaTableSaveVO[] vos = (BsaTableSaveVO[])models.toArray(new BsaTableSaveVO[models.size()]);
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
		this.rdoopcd = this.rdoopcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrbsacapa = this.crrbsacapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslseq = this.vslseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schtdesc = this.schtdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dircd = this.dircd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlcobsacapa = this.fnlcobsacapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrdcd = this.subtrdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslcd = this.vslcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cofnlbsacapa = this.cofnlbsacapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslcapa = this.vslcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsatodt = this.bsatodt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcotrswapflg = this.spcotrswapflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updusrid = this.updusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jodesc = this.jodesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaopjbcd2 = this.bsaopjbcd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopcd = this.vopcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslmltinpflg = this.vslmltinpflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdcd = this.trdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlanecd = this.rlanecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdotype = this.rdotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaopjbcd = this.bsaopjbcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsacapa = this.bsacapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsafmdt = this.bsafmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaseq = this.bsaseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslbsachkflg = this.vslbsachkflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobsabfrsubcapa = this.cobsabfrsubcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jheader = this.jheader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrvslwgt = this.ownrvslwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcd = this.vvdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheader = this.sheader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
