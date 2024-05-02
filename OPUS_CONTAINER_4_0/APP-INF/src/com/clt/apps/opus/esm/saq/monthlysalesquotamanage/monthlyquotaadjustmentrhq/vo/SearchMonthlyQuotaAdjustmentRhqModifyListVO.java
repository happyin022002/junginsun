/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaAdjustmentRhqModifyListVO.java
*@FileTitle : SearchMonthlyQuotaAdjustmentRhqModifyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.10.06 최민철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaAdjustmentRhqModifyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaAdjustmentRhqModifyListVO> models = new ArrayList<SearchMonthlyQuotaAdjustmentRhqModifyListVO>();
	
	/* Column Info */
	private String grpSeq2 = null;
	/* Column Info */
	private String load1 = null;
	/* Column Info */
	private String grpSeq3 = null;
	/* Column Info */
	private String load2 = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String load3 = null;
	/* Column Info */
	private String gRpb1 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String gRpb2 = null;
	/* Column Info */
	private String ctrtRgnOfcCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String gRpb3 = null;
	/* Column Info */
	private String sprtGrpCd = null;
	/* Column Info */
	private String grpSeq1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String totBsa = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaAdjustmentRhqModifyListVO() {}

	public SearchMonthlyQuotaAdjustmentRhqModifyListVO(String ibflag, String pagerows, String subTrdCd, String laneGrp, String ofcCd, String grpSeq1, String load1, String gRpb1, String grpSeq2, String load2, String gRpb2, String grpSeq3, String load3, String gRpb3, String totBsa, String rlaneCd, String sprtGrpCd, String bsaGrpCd, String ctrtRgnOfcCd, String bseMon, String trdCd) {
		this.grpSeq2 = grpSeq2;
		this.load1 = load1;
		this.grpSeq3 = grpSeq3;
		this.load2 = load2;
		this.laneGrp = laneGrp;
		this.load3 = load3;
		this.gRpb1 = gRpb1;
		this.trdCd = trdCd;
		this.gRpb2 = gRpb2;
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
		this.rlaneCd = rlaneCd;
		this.gRpb3 = gRpb3;
		this.sprtGrpCd = sprtGrpCd;
		this.grpSeq1 = grpSeq1;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bsaGrpCd = bsaGrpCd;
		this.totBsa = totBsa;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_seq2", getGrpSeq2());
		this.hashColumns.put("load1", getLoad1());
		this.hashColumns.put("grp_seq3", getGrpSeq3());
		this.hashColumns.put("load2", getLoad2());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("load3", getLoad3());
		this.hashColumns.put("g_rpb1", getGRpb1());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("g_rpb2", getGRpb2());
		this.hashColumns.put("ctrt_rgn_ofc_cd", getCtrtRgnOfcCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("g_rpb3", getGRpb3());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("grp_seq1", getGrpSeq1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("tot_bsa", getTotBsa());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_seq2", "grpSeq2");
		this.hashFields.put("load1", "load1");
		this.hashFields.put("grp_seq3", "grpSeq3");
		this.hashFields.put("load2", "load2");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("load3", "load3");
		this.hashFields.put("g_rpb1", "gRpb1");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("g_rpb2", "gRpb2");
		this.hashFields.put("ctrt_rgn_ofc_cd", "ctrtRgnOfcCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("g_rpb3", "gRpb3");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("grp_seq1", "grpSeq1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("tot_bsa", "totBsa");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpSeq2
	 */
	public String getGrpSeq2() {
		return this.grpSeq2;
	}
	
	/**
	 * Column Info
	 * @return load1
	 */
	public String getLoad1() {
		return this.load1;
	}
	
	/**
	 * Column Info
	 * @return grpSeq3
	 */
	public String getGrpSeq3() {
		return this.grpSeq3;
	}
	
	/**
	 * Column Info
	 * @return load2
	 */
	public String getLoad2() {
		return this.load2;
	}
	
	/**
	 * Column Info
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return load3
	 */
	public String getLoad3() {
		return this.load3;
	}
	
	/**
	 * Column Info
	 * @return gRpb1
	 */
	public String getGRpb1() {
		return this.gRpb1;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return gRpb2
	 */
	public String getGRpb2() {
		return this.gRpb2;
	}
	
	/**
	 * Column Info
	 * @return ctrtRgnOfcCd
	 */
	public String getCtrtRgnOfcCd() {
		return this.ctrtRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return gRpb3
	 */
	public String getGRpb3() {
		return this.gRpb3;
	}
	
	/**
	 * Column Info
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return grpSeq1
	 */
	public String getGrpSeq1() {
		return this.grpSeq1;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bsaGrpCd
	 */
	public String getBsaGrpCd() {
		return this.bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @return totBsa
	 */
	public String getTotBsa() {
		return this.totBsa;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param grpSeq2
	 */
	public void setGrpSeq2(String grpSeq2) {
		this.grpSeq2 = grpSeq2;
	}
	
	/**
	 * Column Info
	 * @param load1
	 */
	public void setLoad1(String load1) {
		this.load1 = load1;
	}
	
	/**
	 * Column Info
	 * @param grpSeq3
	 */
	public void setGrpSeq3(String grpSeq3) {
		this.grpSeq3 = grpSeq3;
	}
	
	/**
	 * Column Info
	 * @param load2
	 */
	public void setLoad2(String load2) {
		this.load2 = load2;
	}
	
	/**
	 * Column Info
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param load3
	 */
	public void setLoad3(String load3) {
		this.load3 = load3;
	}
	
	/**
	 * Column Info
	 * @param gRpb1
	 */
	public void setGRpb1(String gRpb1) {
		this.gRpb1 = gRpb1;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param gRpb2
	 */
	public void setGRpb2(String gRpb2) {
		this.gRpb2 = gRpb2;
	}
	
	/**
	 * Column Info
	 * @param ctrtRgnOfcCd
	 */
	public void setCtrtRgnOfcCd(String ctrtRgnOfcCd) {
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param gRpb3
	 */
	public void setGRpb3(String gRpb3) {
		this.gRpb3 = gRpb3;
	}
	
	/**
	 * Column Info
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param grpSeq1
	 */
	public void setGrpSeq1(String grpSeq1) {
		this.grpSeq1 = grpSeq1;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bsaGrpCd
	 */
	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @param totBsa
	 */
	public void setTotBsa(String totBsa) {
		this.totBsa = totBsa;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGrpSeq2(JSPUtil.getParameter(request, "grp_seq2", ""));
		setLoad1(JSPUtil.getParameter(request, "load1", ""));
		setGrpSeq3(JSPUtil.getParameter(request, "grp_seq3", ""));
		setLoad2(JSPUtil.getParameter(request, "load2", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setLoad3(JSPUtil.getParameter(request, "load3", ""));
		setGRpb1(JSPUtil.getParameter(request, "g_rpb1", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setGRpb2(JSPUtil.getParameter(request, "g_rpb2", ""));
		setCtrtRgnOfcCd(JSPUtil.getParameter(request, "ctrt_rgn_ofc_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setGRpb3(JSPUtil.getParameter(request, "g_rpb3", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setGrpSeq1(JSPUtil.getParameter(request, "grp_seq1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setTotBsa(JSPUtil.getParameter(request, "tot_bsa", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaAdjustmentRhqModifyListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentRhqModifyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaAdjustmentRhqModifyListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentRhqModifyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaAdjustmentRhqModifyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpSeq2 = (JSPUtil.getParameter(request, prefix	+ "grp_seq2", length));
			String[] load1 = (JSPUtil.getParameter(request, prefix	+ "load1", length));
			String[] grpSeq3 = (JSPUtil.getParameter(request, prefix	+ "grp_seq3", length));
			String[] load2 = (JSPUtil.getParameter(request, prefix	+ "load2", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] load3 = (JSPUtil.getParameter(request, prefix	+ "load3", length));
			String[] gRpb1 = (JSPUtil.getParameter(request, prefix	+ "g_rpb1", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] gRpb2 = (JSPUtil.getParameter(request, prefix	+ "g_rpb2", length));
			String[] ctrtRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rgn_ofc_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] gRpb3 = (JSPUtil.getParameter(request, prefix	+ "g_rpb3", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] grpSeq1 = (JSPUtil.getParameter(request, prefix	+ "grp_seq1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] totBsa = (JSPUtil.getParameter(request, prefix	+ "tot_bsa", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaAdjustmentRhqModifyListVO();
				if (grpSeq2[i] != null)
					model.setGrpSeq2(grpSeq2[i]);
				if (load1[i] != null)
					model.setLoad1(load1[i]);
				if (grpSeq3[i] != null)
					model.setGrpSeq3(grpSeq3[i]);
				if (load2[i] != null)
					model.setLoad2(load2[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (load3[i] != null)
					model.setLoad3(load3[i]);
				if (gRpb1[i] != null)
					model.setGRpb1(gRpb1[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (gRpb2[i] != null)
					model.setGRpb2(gRpb2[i]);
				if (ctrtRgnOfcCd[i] != null)
					model.setCtrtRgnOfcCd(ctrtRgnOfcCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (gRpb3[i] != null)
					model.setGRpb3(gRpb3[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (grpSeq1[i] != null)
					model.setGrpSeq1(grpSeq1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (totBsa[i] != null)
					model.setTotBsa(totBsa[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaAdjustmentRhqModifyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaAdjustmentRhqModifyListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentRhqModifyListVO[] getSearchMonthlyQuotaAdjustmentRhqModifyListVOs(){
		SearchMonthlyQuotaAdjustmentRhqModifyListVO[] vos = (SearchMonthlyQuotaAdjustmentRhqModifyListVO[])models.toArray(new SearchMonthlyQuotaAdjustmentRhqModifyListVO[models.size()]);
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
		this.grpSeq2 = this.grpSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load1 = this.load1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq3 = this.grpSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load2 = this.load2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load3 = this.load3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb1 = this.gRpb1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb2 = this.gRpb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRgnOfcCd = this.ctrtRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb3 = this.gRpb3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq1 = this.grpSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsa = this.totBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
