/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingDataForTaxVO.java
*@FileTitle : BookingDataForTaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.09 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BKGForTaxByDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGForTaxByDateVO> models = new ArrayList<BKGForTaxByDateVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String both = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String trkVvd = null;
	/* Column Info */
	private String fstVvd = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String br2 = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String br5 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String br4 = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String bd2 = null;
	/* Column Info */
	private String bd5 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String bd4 = null;
	/* Column Info */
	private String sChg = null;
	/* Column Info */
	private String custENm = null;
	/* Column Info */
	private String oft = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pre = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String r5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGForTaxByDateVO() {}

	public BKGForTaxByDateVO(String ibflag, String pagerows, String bkgOfc, String trkVvd, String fstVvd, String blNo, String bkgNo, String sailDt, String por, String pol, String pod, String del, String pre, String custNm, String custCd, String custENm, String oft, String sChg, String bd2, String bd4, String bd5, String br2, String br4, String br5, String both, String d2, String d4, String d5, String r2, String r4, String r5, String oth) {
		this.custNm = custNm;
		this.both = both;
		this.por = por;
		this.trkVvd = trkVvd;
		this.fstVvd = fstVvd;
		this.d5 = d5;
		this.d4 = d4;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.br2 = br2;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.oth = oth;
		this.br5 = br5;
		this.pol = pol;
		this.br4 = br4;
		this.del = del;
		this.bd2 = bd2;
		this.bd5 = bd5;
		this.pod = pod;
		this.bd4 = bd4;
		this.sChg = sChg;
		this.custENm = custENm;
		this.oft = oft;
		this.sailDt = sailDt;
		this.bkgNo = bkgNo;
		this.pre = pre;
		this.custCd = custCd;
		this.r2 = r2;
		this.r4 = r4;
		this.r5 = r5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("both", getBoth());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("trk_vvd", getTrkVvd());
		this.hashColumns.put("fst_vvd", getFstVvd());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("br2", getBr2());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("br5", getBr5());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("br4", getBr4());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("bd2", getBd2());
		this.hashColumns.put("bd5", getBd5());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bd4", getBd4());
		this.hashColumns.put("s_chg", getSChg());
		this.hashColumns.put("cust_e_nm", getCustENm());
		this.hashColumns.put("oft", getOft());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pre", getPre());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r5", getR5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("both", "both");
		this.hashFields.put("por", "por");
		this.hashFields.put("trk_vvd", "trkVvd");
		this.hashFields.put("fst_vvd", "fstVvd");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("br2", "br2");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("br5", "br5");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("br4", "br4");
		this.hashFields.put("del", "del");
		this.hashFields.put("bd2", "bd2");
		this.hashFields.put("bd5", "bd5");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bd4", "bd4");
		this.hashFields.put("s_chg", "sChg");
		this.hashFields.put("cust_e_nm", "custENm");
		this.hashFields.put("oft", "oft");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pre", "pre");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r5", "r5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return both
	 */
	public String getBoth() {
		return this.both;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return trkVvd
	 */
	public String getTrkVvd() {
		return this.trkVvd;
	}
	
	/**
	 * Column Info
	 * @return fstVvd
	 */
	public String getFstVvd() {
		return this.fstVvd;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return br2
	 */
	public String getBr2() {
		return this.br2;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return oth
	 */
	public String getOth() {
		return this.oth;
	}
	
	/**
	 * Column Info
	 * @return br5
	 */
	public String getBr5() {
		return this.br5;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return br4
	 */
	public String getBr4() {
		return this.br4;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return bd2
	 */
	public String getBd2() {
		return this.bd2;
	}
	
	/**
	 * Column Info
	 * @return bd5
	 */
	public String getBd5() {
		return this.bd5;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return bd4
	 */
	public String getBd4() {
		return this.bd4;
	}
	
	/**
	 * Column Info
	 * @return sChg
	 */
	public String getSChg() {
		return this.sChg;
	}
	
	/**
	 * Column Info
	 * @return custENm
	 */
	public String getCustENm() {
		return this.custENm;
	}
	
	/**
	 * Column Info
	 * @return oft
	 */
	public String getOft() {
		return this.oft;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return pre
	 */
	public String getPre() {
		return this.pre;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param both
	 */
	public void setBoth(String both) {
		this.both = both;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param trkVvd
	 */
	public void setTrkVvd(String trkVvd) {
		this.trkVvd = trkVvd;
	}
	
	/**
	 * Column Info
	 * @param fstVvd
	 */
	public void setFstVvd(String fstVvd) {
		this.fstVvd = fstVvd;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param br2
	 */
	public void setBr2(String br2) {
		this.br2 = br2;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
	}
	
	/**
	 * Column Info
	 * @param br5
	 */
	public void setBr5(String br5) {
		this.br5 = br5;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param br4
	 */
	public void setBr4(String br4) {
		this.br4 = br4;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param bd2
	 */
	public void setBd2(String bd2) {
		this.bd2 = bd2;
	}
	
	/**
	 * Column Info
	 * @param bd5
	 */
	public void setBd5(String bd5) {
		this.bd5 = bd5;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param bd4
	 */
	public void setBd4(String bd4) {
		this.bd4 = bd4;
	}
	
	/**
	 * Column Info
	 * @param sChg
	 */
	public void setSChg(String sChg) {
		this.sChg = sChg;
	}
	
	/**
	 * Column Info
	 * @param custENm
	 */
	public void setCustENm(String custENm) {
		this.custENm = custENm;
	}
	
	/**
	 * Column Info
	 * @param oft
	 */
	public void setOft(String oft) {
		this.oft = oft;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param pre
	 */
	public void setPre(String pre) {
		this.pre = pre;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBoth(JSPUtil.getParameter(request, "both", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setTrkVvd(JSPUtil.getParameter(request, "trk_vvd", ""));
		setFstVvd(JSPUtil.getParameter(request, "fst_vvd", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBr2(JSPUtil.getParameter(request, "br2", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setOth(JSPUtil.getParameter(request, "oth", ""));
		setBr5(JSPUtil.getParameter(request, "br5", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setBr4(JSPUtil.getParameter(request, "br4", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setBd2(JSPUtil.getParameter(request, "bd2", ""));
		setBd5(JSPUtil.getParameter(request, "bd5", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setBd4(JSPUtil.getParameter(request, "bd4", ""));
		setSChg(JSPUtil.getParameter(request, "s_chg", ""));
		setCustENm(JSPUtil.getParameter(request, "cust_e_nm", ""));
		setOft(JSPUtil.getParameter(request, "oft", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPre(JSPUtil.getParameter(request, "pre", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingDataForTaxVO[]
	 */
	public BKGForTaxByDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingDataForTaxVO[]
	 */
	public BKGForTaxByDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGForTaxByDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] both = (JSPUtil.getParameter(request, prefix	+ "both".trim(), length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por".trim(), length));
			String[] trkVvd = (JSPUtil.getParameter(request, prefix	+ "trk_vvd".trim(), length));
			String[] fstVvd = (JSPUtil.getParameter(request, prefix	+ "fst_vvd".trim(), length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5".trim(), length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] br2 = (JSPUtil.getParameter(request, prefix	+ "br2".trim(), length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc".trim(), length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth".trim(), length));
			String[] br5 = (JSPUtil.getParameter(request, prefix	+ "br5".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] br4 = (JSPUtil.getParameter(request, prefix	+ "br4".trim(), length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del".trim(), length));
			String[] bd2 = (JSPUtil.getParameter(request, prefix	+ "bd2".trim(), length));
			String[] bd5 = (JSPUtil.getParameter(request, prefix	+ "bd5".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] bd4 = (JSPUtil.getParameter(request, prefix	+ "bd4".trim(), length));
			String[] sChg = (JSPUtil.getParameter(request, prefix	+ "s_chg".trim(), length));
			String[] custENm = (JSPUtil.getParameter(request, prefix	+ "cust_e_nm".trim(), length));
			String[] oft = (JSPUtil.getParameter(request, prefix	+ "oft".trim(), length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] pre = (JSPUtil.getParameter(request, prefix	+ "pre".trim(), length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2".trim(), length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4".trim(), length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGForTaxByDateVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (both[i] != null)
					model.setBoth(both[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (trkVvd[i] != null)
					model.setTrkVvd(trkVvd[i]);
				if (fstVvd[i] != null)
					model.setFstVvd(fstVvd[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (br2[i] != null)
					model.setBr2(br2[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (br5[i] != null)
					model.setBr5(br5[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (br4[i] != null)
					model.setBr4(br4[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (bd2[i] != null)
					model.setBd2(bd2[i]);
				if (bd5[i] != null)
					model.setBd5(bd5[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bd4[i] != null)
					model.setBd4(bd4[i]);
				if (sChg[i] != null)
					model.setSChg(sChg[i]);
				if (custENm[i] != null)
					model.setCustENm(custENm[i]);
				if (oft[i] != null)
					model.setOft(oft[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pre[i] != null)
					model.setPre(pre[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingDataForTaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BookingDataForTaxVO[]
	 */
	public BKGForTaxByDateVO[] getBookingDataForTaxVOs(){
		BKGForTaxByDateVO[] vos = (BKGForTaxByDateVO[])models.toArray(new BKGForTaxByDateVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.both = this.both .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVvd = this.trkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstVvd = this.fstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br2 = this.br2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br5 = this.br5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.br4 = this.br4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd2 = this.bd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd5 = this.bd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd4 = this.bd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChg = this.sChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custENm = this.custENm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oft = this.oft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre = this.pre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
