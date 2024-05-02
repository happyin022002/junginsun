/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceControlInquiry021AllocPortViewListVO.java
*@FileTitle : SearchSpaceControlInquiry021AllocPortViewListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.31 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiry021AllocPortViewListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry021AllocPortViewListVO> models = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String t = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	
	
	
	private String vvd1 = null;
	private String vvd2 = null;
	private String vvd3 = null;
	private String vvd4 = null;
	private String vvd5 = null;
	
	private String bsa1 = null;
	private String bsa2 = null;
	private String bsa3 = null;
	private String bsa4 = null;
	private String bsa5 = null;
	
	private String qta11 = null;
	private String qta21 = null;
	private String qta31 = null;
	private String qta41 = null;
	private String qta51 = null;
	
	private String fct11 = null;
	private String fct21 = null;
	private String fct31 = null;
	private String fct41 = null;
	private String fct51 = null;
	
	private String alc11 = null;
	private String alc21 = null;
	private String alc31 = null;
	private String alc41 = null;
	private String alc51 = null;
	
	private String bkg11 = null;
	private String bkg21 = null;
	private String bkg31 = null;
	private String bkg41 = null;
	private String bkg51 = null;
	
	private String pref11 = null;
	private String pref21 = null;
	private String pref31 = null;
	private String pref41 = null;
	private String pref51 = null;
	
	
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiry021AllocPortViewListVO() {}

	public SearchSpaceControlInquiry021AllocPortViewListVO(String vvd1,String vvd2,String vvd3,String vvd4,String vvd5,String bsa1,String bsa2,String bsa3,String bsa4,String bsa5,String qta11,String qta21,String qta31,String qta41,String qta51,String fct11,String fct21,String fct31,String fct41,String fct51,String alc11,String alc21,String alc31,String alc41,String alc51,String bkg11,String bkg21,String bkg31,String bkg41,String bkg51,String pref11,String pref21,String pref31,String pref41,String pref51,String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String aqCd, String ofcCd, String cnt, String t) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.t = t;
		this.cnt = cnt;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.rlaneCd = rlaneCd;
		this.aqCd = aqCd;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
		
		this.vvd1 = vvd1;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.vvd4 = vvd4;
		this.vvd5 = vvd5;

		this.bsa1 = bsa1;
		this.bsa2 = bsa2;
		this.bsa3 = bsa3;
		this.bsa4 = bsa4;
		this.bsa5 = bsa5;

		this.qta11 = qta11;
		this.qta21 = qta21;
		this.qta31 = qta31;
		this.qta41 = qta41;
		this.qta51 = qta51;

		this.fct11 = fct11;
		this.fct21 = fct21;
		this.fct31 = fct31;
		this.fct41 = fct41;
		this.fct51 = fct51;

		this.alc11 = alc11;
		this.alc21 = alc21;
		this.alc31 = alc31;
		this.alc41 = alc41;
		this.alc51 = alc51;

		this.bkg11 = bkg11;
		this.bkg21 = bkg21;
		this.bkg31 = bkg31;
		this.bkg41 = bkg41;
		this.bkg51 = bkg51;

		this.pref11 = pref11;
		this.pref21 = pref21;
		this.pref31 = pref31;
		this.pref41 = pref41;
		this.pref51 = pref51;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t", getT());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		
		
		this.hashColumns.put("vvd1",getVvd1());
		this.hashColumns.put("vvd2",getVvd2());
		this.hashColumns.put("vvd3",getVvd3());
		this.hashColumns.put("vvd4",getVvd4());
		this.hashColumns.put("vvd5",getVvd5());

		this.hashColumns.put("bsa1",getBsa1());
		this.hashColumns.put("bsa2",getBsa2());
		this.hashColumns.put("bsa3",getBsa3());
		this.hashColumns.put("bsa4",getBsa4());
		this.hashColumns.put("bsa5",getBsa5());

		this.hashColumns.put("qta11",getQta11());
		this.hashColumns.put("qta21",getQta21());
		this.hashColumns.put("qta31",getQta31());
		this.hashColumns.put("qta41",getQta41());
		this.hashColumns.put("qta51",getQta51());

		this.hashColumns.put("fct11",getFct11());
		this.hashColumns.put("fct21",getFct21());
		this.hashColumns.put("fct31",getFct31());
		this.hashColumns.put("fct41",getFct41());
		this.hashColumns.put("fct51",getFct51());

		this.hashColumns.put("alc11",getAlc11());
		this.hashColumns.put("alc21",getAlc21());
		this.hashColumns.put("alc31",getAlc31());
		this.hashColumns.put("alc41",getAlc41());
		this.hashColumns.put("alc51",getAlc51());

		this.hashColumns.put("bkg11",getBkg11());
		this.hashColumns.put("bkg21",getBkg21());
		this.hashColumns.put("bkg31",getBkg31());
		this.hashColumns.put("bkg41",getBkg41());
		this.hashColumns.put("bkg51",getBkg51());

		this.hashColumns.put("pref11",getPref11());
		this.hashColumns.put("pref21",getPref21());
		this.hashColumns.put("pref31",getPref31());
		this.hashColumns.put("pref41",getPref41());
		this.hashColumns.put("pref51",getPref51());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t", "t");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		
		this.hashFields.put("vvd1","vvd1");
		this.hashFields.put("vvd2","vvd2");
		this.hashFields.put("vvd3","vvd3");
		this.hashFields.put("vvd4","vvd4");
		this.hashFields.put("vvd5","vvd5");

		this.hashFields.put("bsa1","bsa1");
		this.hashFields.put("bsa2","bsa2");
		this.hashFields.put("bsa3","bsa3");
		this.hashFields.put("bsa4","bsa4");
		this.hashFields.put("bsa5","bsa5");

		this.hashFields.put("qta11","qta11");
		this.hashFields.put("qta21","qta21");
		this.hashFields.put("qta31","qta31");
		this.hashFields.put("qta41","qta41");
		this.hashFields.put("qta51","qta51");

		this.hashFields.put("fct11","fct11");
		this.hashFields.put("fct21","fct21");
		this.hashFields.put("fct31","fct31");
		this.hashFields.put("fct41","fct41");
		this.hashFields.put("fct51","fct51");

		this.hashFields.put("alc11","alc11");
		this.hashFields.put("alc21","alc21");
		this.hashFields.put("alc31","alc31");
		this.hashFields.put("alc41","alc41");
		this.hashFields.put("alc51","alc51");

		this.hashFields.put("bkg11","bkg11");
		this.hashFields.put("bkg21","bkg21");
		this.hashFields.put("bkg31","bkg31");
		this.hashFields.put("bkg41","bkg41");
		this.hashFields.put("bkg51","bkg51");

		this.hashFields.put("pref11","pref11");
		this.hashFields.put("pref21","pref21");
		this.hashFields.put("pref31","pref31");
		this.hashFields.put("pref41","pref41");
		this.hashFields.put("pref51","pref51");
		
		return this.hashFields;
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
	 * @return t
	 */
	public String getT() {
		return this.t;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param t
	 */
	public void setT(String t) {
		this.t = t;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getVvd1() {
		return vvd1;
	}

	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}

	public String getVvd2() {
		return vvd2;
	}

	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}

	public String getVvd3() {
		return vvd3;
	}

	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}

	public String getVvd4() {
		return vvd4;
	}

	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}

	public String getVvd5() {
		return vvd5;
	}

	public void setVvd5(String vvd5) {
		this.vvd5 = vvd5;
	}

	public String getBsa1() {
		return bsa1;
	}

	public void setBsa1(String bsa1) {
		this.bsa1 = bsa1;
	}

	public String getBsa2() {
		return bsa2;
	}

	public void setBsa2(String bsa2) {
		this.bsa2 = bsa2;
	}

	public String getBsa3() {
		return bsa3;
	}

	public void setBsa3(String bsa3) {
		this.bsa3 = bsa3;
	}

	public String getBsa4() {
		return bsa4;
	}

	public void setBsa4(String bsa4) {
		this.bsa4 = bsa4;
	}

	public String getBsa5() {
		return bsa5;
	}

	public void setBsa5(String bsa5) {
		this.bsa5 = bsa5;
	}

	public String getQta11() {
		return qta11;
	}

	public void setQta11(String qta11) {
		this.qta11 = qta11;
	}

	public String getQta21() {
		return qta21;
	}

	public void setQta21(String qta21) {
		this.qta21 = qta21;
	}

	public String getQta31() {
		return qta31;
	}

	public void setQta31(String qta31) {
		this.qta31 = qta31;
	}

	public String getQta41() {
		return qta41;
	}

	public void setQta41(String qta41) {
		this.qta41 = qta41;
	}

	public String getQta51() {
		return qta51;
	}

	public void setQta51(String qta51) {
		this.qta51 = qta51;
	}

	public String getFct11() {
		return fct11;
	}

	public void setFct11(String fct11) {
		this.fct11 = fct11;
	}

	public String getFct21() {
		return fct21;
	}

	public void setFct21(String fct21) {
		this.fct21 = fct21;
	}

	public String getFct31() {
		return fct31;
	}

	public void setFct31(String fct31) {
		this.fct31 = fct31;
	}

	public String getFct41() {
		return fct41;
	}

	public void setFct41(String fct41) {
		this.fct41 = fct41;
	}

	public String getFct51() {
		return fct51;
	}

	public void setFct51(String fct51) {
		this.fct51 = fct51;
	}

	public String getAlc11() {
		return alc11;
	}

	public void setAlc11(String alc11) {
		this.alc11 = alc11;
	}

	public String getAlc21() {
		return alc21;
	}

	public void setAlc21(String alc21) {
		this.alc21 = alc21;
	}

	public String getAlc31() {
		return alc31;
	}

	public void setAlc31(String alc31) {
		this.alc31 = alc31;
	}

	public String getAlc41() {
		return alc41;
	}

	public void setAlc41(String alc41) {
		this.alc41 = alc41;
	}

	public String getAlc51() {
		return alc51;
	}

	public void setAlc51(String alc51) {
		this.alc51 = alc51;
	}

	public String getBkg11() {
		return bkg11;
	}

	public void setBkg11(String bkg11) {
		this.bkg11 = bkg11;
	}

	public String getBkg21() {
		return bkg21;
	}

	public void setBkg21(String bkg21) {
		this.bkg21 = bkg21;
	}

	public String getBkg31() {
		return bkg31;
	}

	public void setBkg31(String bkg31) {
		this.bkg31 = bkg31;
	}

	public String getBkg41() {
		return bkg41;
	}

	public void setBkg41(String bkg41) {
		this.bkg41 = bkg41;
	}

	public String getBkg51() {
		return bkg51;
	}

	public void setBkg51(String bkg51) {
		this.bkg51 = bkg51;
	}

	public String getPref11() {
		return pref11;
	}

	public void setPref11(String pref11) {
		this.pref11 = pref11;
	}

	public String getPref21() {
		return pref21;
	}

	public void setPref21(String pref21) {
		this.pref21 = pref21;
	}

	public String getPref31() {
		return pref31;
	}

	public void setPref31(String pref31) {
		this.pref31 = pref31;
	}

	public String getPref41() {
		return pref41;
	}

	public void setPref41(String pref41) {
		this.pref41 = pref41;
	}

	public String getPref51() {
		return pref51;
	}

	public void setPref51(String pref51) {
		this.pref51 = pref51;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setT(JSPUtil.getParameter(request, "t", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry021AllocPortViewListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] t = (JSPUtil.getParameter(request, prefix	+ "t", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry021AllocPortViewListVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (t[i] != null)
					model.setT(t[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiry021AllocPortViewListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry021AllocPortViewListVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewListVO[] getSearchSpaceControlInquiry021AllocPortViewListVOs(){
		SearchSpaceControlInquiry021AllocPortViewListVO[] vos = (SearchSpaceControlInquiry021AllocPortViewListVO[])models.toArray(new SearchSpaceControlInquiry021AllocPortViewListVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t = this.t .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
