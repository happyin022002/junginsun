/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzInvAllowanceTEUVO.java
*@FileTitle : CanalTzInvAllowanceTEUVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.20 김성광 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김성광
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzInvAllowanceTEUVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzInvAllowanceTEUVO> models = new ArrayList<CanalTzInvAllowanceTEUVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String cnlTzProcStsCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String cntrPnmCapa = null;
	/* Column Info */
	private String scgRtAmt = null;
	/* Column Info */
	private String trVolVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzInvAllowanceTEUVO() {}

	public CanalTzInvAllowanceTEUVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String revYrmon, String ttlAmt, String scgRtAmt, String suzNetTongWgt, String loclXchRt, String trVolVal, String cnlTzProcStsCd, String cntrPnmCapa) {
		this.vslCd = vslCd;
		this.loclXchRt = loclXchRt;
		this.revYrmon = revYrmon;
		this.skdVoyNo = skdVoyNo;
		this.ttlAmt = ttlAmt;
		this.cnlTzProcStsCd = cnlTzProcStsCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.suzNetTongWgt = suzNetTongWgt;
		this.cntrPnmCapa = cntrPnmCapa;
		this.scgRtAmt = scgRtAmt;
		this.trVolVal = trVolVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("cnl_tz_proc_sts_cd", getCnlTzProcStsCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
		this.hashColumns.put("scg_rt_amt", getScgRtAmt());
		this.hashColumns.put("tr_vol_val", getTrVolVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("cnl_tz_proc_sts_cd", "cnlTzProcStsCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
		this.hashFields.put("scg_rt_amt", "scgRtAmt");
		this.hashFields.put("tr_vol_val", "trVolVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return loclXchRt
	 */
	public String getLoclXchRt() {
		return this.loclXchRt;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return cnlTzProcStsCd
	 */
	public String getCnlTzProcStsCd() {
		return this.cnlTzProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return suzNetTongWgt
	 */
	public String getSuzNetTongWgt() {
		return this.suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrPnmCapa
	 */
	public String getCntrPnmCapa() {
		return this.cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @return scgRtAmt
	 */
	public String getScgRtAmt() {
		return this.scgRtAmt;
	}
	
	/**
	 * Column Info
	 * @return trVolVal
	 */
	public String getTrVolVal() {
		return this.trVolVal;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param loclXchRt
	 */
	public void setLoclXchRt(String loclXchRt) {
		this.loclXchRt = loclXchRt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param cnlTzProcStsCd
	 */
	public void setCnlTzProcStsCd(String cnlTzProcStsCd) {
		this.cnlTzProcStsCd = cnlTzProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param suzNetTongWgt
	 */
	public void setSuzNetTongWgt(String suzNetTongWgt) {
		this.suzNetTongWgt = suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrPnmCapa
	 */
	public void setCntrPnmCapa(String cntrPnmCapa) {
		this.cntrPnmCapa = cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @param scgRtAmt
	 */
	public void setScgRtAmt(String scgRtAmt) {
		this.scgRtAmt = scgRtAmt;
	}
	
	/**
	 * Column Info
	 * @param trVolVal
	 */
	public void setTrVolVal(String trVolVal) {
		this.trVolVal = trVolVal;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setLoclXchRt(JSPUtil.getParameter(request, "locl_xch_rt", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setCnlTzProcStsCd(JSPUtil.getParameter(request, "cnl_tz_proc_sts_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, "suz_net_tong_wgt", ""));
		setCntrPnmCapa(JSPUtil.getParameter(request, "cntr_pnm_capa", ""));
		setScgRtAmt(JSPUtil.getParameter(request, "scg_rt_amt", ""));
		setTrVolVal(JSPUtil.getParameter(request, "tr_vol_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzInvAllowanceTEUVO[]
	 */
	public CanalTzInvAllowanceTEUVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzInvAllowanceTEUVO[]
	 */
	public CanalTzInvAllowanceTEUVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzInvAllowanceTEUVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] cnlTzProcStsCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_proc_sts_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt", length));
			String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_pnm_capa", length));
			String[] scgRtAmt = (JSPUtil.getParameter(request, prefix	+ "scg_rt_amt", length));
			String[] trVolVal = (JSPUtil.getParameter(request, prefix	+ "tr_vol_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzInvAllowanceTEUVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (cnlTzProcStsCd[i] != null)
					model.setCnlTzProcStsCd(cnlTzProcStsCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (cntrPnmCapa[i] != null)
					model.setCntrPnmCapa(cntrPnmCapa[i]);
				if (scgRtAmt[i] != null)
					model.setScgRtAmt(scgRtAmt[i]);
				if (trVolVal[i] != null)
					model.setTrVolVal(trVolVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzInvAllowanceTEUVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzInvAllowanceTEUVO[]
	 */
	public CanalTzInvAllowanceTEUVO[] getCanalTzInvAllowanceTEUVOs(){
		CanalTzInvAllowanceTEUVO[] vos = (CanalTzInvAllowanceTEUVO[])models.toArray(new CanalTzInvAllowanceTEUVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzProcStsCd = this.cnlTzProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPnmCapa = this.cntrPnmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgRtAmt = this.scgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trVolVal = this.trVolVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
