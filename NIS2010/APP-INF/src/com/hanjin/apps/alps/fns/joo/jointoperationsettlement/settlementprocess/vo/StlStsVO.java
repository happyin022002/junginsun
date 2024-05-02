/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StlStsVO.java
*@FileTitle : StlStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.02 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StlStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StlStsVO> models = new ArrayList<StlStsVO>();
	
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String voy = null;
	/* Column Info */
	private String other = null;
	/* Column Info */
	private String rmkTp = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String ind = null;
	/* Column Info */
	private String dir = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String ous = null;
	/* Column Info */
	private String tml = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String totPageCnt = null;	
	/* Column Info */
	private String dateCd = null;	
	/* Column Info */
	private String vvdCd = null;	
	/* Column Info */
	private String skdDirCd = null;	
	/* Column Info */
	private String joCrrCd = null;	
	/* Column Info */
	private String joStlItmCd = null;	
	/* Column Info */
	private String ofcCd = null;	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String etd = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StlStsVO() {}

	public StlStsVO(String ibflag, String pagerows, String seq, String revYrmon, String trdCd, String rlaneCd, String crrCd, String reDivrCd, String vsl, String voy, String dir, String port, String tml, String ind, String rmkTp, String rmk, String pic, String ous, String rf, String other, String gubun, String pageNo, String totPageCnt, String dateCd, String vvdCd, String skdDirCd, String joCrrCd, String joStlItmCd, String ofcCd, String updUsrId, String etd) {
		this.rmk = rmk;
		this.port = port;
		this.voy = voy;
		this.other = other;
		this.rmkTp = rmkTp;
		this.revYrmon = revYrmon;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.rf = rf;
		this.pic = pic;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vsl = vsl;
		this.ind = ind;
		this.dir = dir;
		this.reDivrCd = reDivrCd;
		this.seq = seq;
		this.ous = ous;
		this.tml = tml;
		this.gubun = gubun;
		this.pageNo = pageNo;
		this.totPageCnt = totPageCnt;
		this.dateCd = dateCd;
		this.vvdCd = vvdCd;
		this.skdDirCd = skdDirCd;
		this.joCrrCd = joCrrCd;		
		this.joStlItmCd = joStlItmCd;
		this.ofcCd = ofcCd;
		this.updUsrId = updUsrId;
		this.etd = etd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("voy", getVoy());
		this.hashColumns.put("other", getOther());
		this.hashColumns.put("rmk_tp", getRmkTp());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("ind", getInd());
		this.hashColumns.put("dir", getDir());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ous", getOus());
		this.hashColumns.put("tml", getTml());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("tot_page_cnt", getTotPageCnt());		
		this.hashColumns.put("date_cd", getDateCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());		
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("etd", getEtd());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("port", "port");
		this.hashFields.put("voy", "voy");
		this.hashFields.put("other", "other");
		this.hashFields.put("rmk_tp", "rmkTp");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("ind", "ind");
		this.hashFields.put("dir", "dir");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ous", "ous");
		this.hashFields.put("tml", "tml");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("tot_page_cnt", "totPageCnt");		
		this.hashFields.put("date_cd", "dateCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");		
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");		
		this.hashFields.put("etd", "etd");		
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return voy
	 */
	public String getVoy() {
		return this.voy;
	}
	
	/**
	 * Column Info
	 * @return other
	 */
	public String getOther() {
		return this.other;
	}
	
	/**
	 * Column Info
	 * @return rmkTp
	 */
	public String getRmkTp() {
		return this.rmkTp;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return ind
	 */
	public String getInd() {
		return this.ind;
	}
	
	/**
	 * Column Info
	 * @return dir
	 */
	public String getDir() {
		return this.dir;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return ous
	 */
	public String getOus() {
		return this.ous;
	}
	
	/**
	 * Column Info
	 * @return tml
	 */
	public String getTml() {
		return this.tml;
	}

	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}

	/**
	 * Column Info
	 * @return totPageCnt
	 */
	public String getTotPageCnt() {
		return this.totPageCnt;
	}
	
	/**
	 * Column Info
	 * @return dateCd
	 */
	public String getDateCd() {
		return this.dateCd;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}

	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}

	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param voy
	 */
	public void setVoy(String voy) {
		this.voy = voy;
	}
	
	/**
	 * Column Info
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}
	
	/**
	 * Column Info
	 * @param rmkTp
	 */
	public void setRmkTp(String rmkTp) {
		this.rmkTp = rmkTp;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param ind
	 */
	public void setInd(String ind) {
		this.ind = ind;
	}
	
	/**
	 * Column Info
	 * @param dir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param ous
	 */
	public void setOus(String ous) {
		this.ous = ous;
	}
	
	/**
	 * Column Info
	 * @param tml
	 */
	public void setTml(String tml) {
		this.tml = tml;
	}

	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * Column Info
	 * @param totPageCnt
	 */
	public void setTotPageCnt(String totPageCnt) {
		this.totPageCnt = totPageCnt;
	}

	/**
	 * Column Info
	 * @param dateCd
	 */
	public void setDateCd(String dateCd) {
		this.dateCd = dateCd;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}

	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setVoy(JSPUtil.getParameter(request, prefix + "voy", ""));
		setOther(JSPUtil.getParameter(request, prefix + "other", ""));
		setRmkTp(JSPUtil.getParameter(request, prefix + "rmk_tp", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
		setPic(JSPUtil.getParameter(request, prefix + "pic", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVsl(JSPUtil.getParameter(request, prefix + "vsl", ""));
		setInd(JSPUtil.getParameter(request, prefix + "ind", ""));
		setDir(JSPUtil.getParameter(request, prefix + "dir", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setOus(JSPUtil.getParameter(request, prefix + "ous", ""));
		setTml(JSPUtil.getParameter(request, prefix + "tml", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));		
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setTotPageCnt(JSPUtil.getParameter(request, prefix + "tot_page_cnt", ""));
		setDateCd(JSPUtil.getParameter(request, prefix + "date_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));		
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));		
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StlStsVO[]
	 */
	public StlStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StlStsVO[]
	 */
	public StlStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StlStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] voy = (JSPUtil.getParameter(request, prefix	+ "voy", length));
			String[] other = (JSPUtil.getParameter(request, prefix	+ "other", length));
			String[] rmkTp = (JSPUtil.getParameter(request, prefix	+ "rmk_tp", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl", length));
			String[] ind = (JSPUtil.getParameter(request, prefix	+ "ind", length));
			String[] dir = (JSPUtil.getParameter(request, prefix	+ "dir", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ous = (JSPUtil.getParameter(request, prefix	+ "ous", length));
			String[] tml = (JSPUtil.getParameter(request, prefix	+ "tml", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] totPageCnt = (JSPUtil.getParameter(request, prefix	+ "tot_page_cnt", length));
			String[] dateCd = (JSPUtil.getParameter(request, prefix	+ "date_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));			
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));			
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new StlStsVO();
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (voy[i] != null)
					model.setVoy(voy[i]);
				if (other[i] != null)
					model.setOther(other[i]);
				if (rmkTp[i] != null)
					model.setRmkTp(rmkTp[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (ind[i] != null)
					model.setInd(ind[i]);
				if (dir[i] != null)
					model.setDir(dir[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (ous[i] != null)
					model.setOus(ous[i]);
				if (tml[i] != null)
					model.setTml(tml[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (totPageCnt[i] != null)
					model.setTotPageCnt(totPageCnt[i]);
				if (dateCd[i] != null)
					model.setDateCd(dateCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStlStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StlStsVO[]
	 */
	public StlStsVO[] getStlStsVOs(){
		StlStsVO[] vos = (StlStsVO[])models.toArray(new StlStsVO[models.size()]);
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
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voy = this.voy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.other = this.other .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkTp = this.rmkTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ind = this.ind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir = this.dir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ous = this.ous .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml = this.tml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totPageCnt = this.totPageCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.dateCd = this.dateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
