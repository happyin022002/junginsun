/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeQECreVO.java
*@FileTitle : SpeQECreVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.10 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpeQECreVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeQECreVO> models = new ArrayList<SpeQECreVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n1stEvGrdCtnt = null;
	/* Column Info */
	private String evFctrCtnt = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String evAreaCtnt = null;
	/* Column Info */
	private String evWgtRt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String qualEvSeq = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String n2ndEvGrdCtnt = null;
	/* Column Info */
	private String n3rdEvGrdCtnt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeQECreVO() {}

	public SpeQECreVO(String ibflag, String pagerows, String updDt, String n1stEvGrdCtnt, String evFctrCtnt, String totWgt, String creDt, String evAreaCtnt, String evWgtRt, String creUsrId, String qualEvSeq, String evYr, String n2ndEvGrdCtnt, String updUsrId, String n3rdEvGrdCtnt, String evSvcCateCd) {
		this.updDt = updDt;
		this.n1stEvGrdCtnt = n1stEvGrdCtnt;
		this.evFctrCtnt = evFctrCtnt;
		this.totWgt = totWgt;
		this.creDt = creDt;
		this.evAreaCtnt = evAreaCtnt;
		this.evWgtRt = evWgtRt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.qualEvSeq = qualEvSeq;
		this.evSvcCateCd = evSvcCateCd;
		this.evYr = evYr;
		this.n2ndEvGrdCtnt = n2ndEvGrdCtnt;
		this.n3rdEvGrdCtnt = n3rdEvGrdCtnt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_ev_grd_ctnt", getN1stEvGrdCtnt());
		this.hashColumns.put("ev_fctr_ctnt", getEvFctrCtnt());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ev_area_ctnt", getEvAreaCtnt());
		this.hashColumns.put("ev_wgt_rt", getEvWgtRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("qual_ev_seq", getQualEvSeq());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("n2nd_ev_grd_ctnt", getN2ndEvGrdCtnt());
		this.hashColumns.put("n3rd_ev_grd_ctnt", getN3rdEvGrdCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_ev_grd_ctnt", "n1stEvGrdCtnt");
		this.hashFields.put("ev_fctr_ctnt", "evFctrCtnt");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ev_area_ctnt", "evAreaCtnt");
		this.hashFields.put("ev_wgt_rt", "evWgtRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("qual_ev_seq", "qualEvSeq");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("n2nd_ev_grd_ctnt", "n2ndEvGrdCtnt");
		this.hashFields.put("n3rd_ev_grd_ctnt", "n3rdEvGrdCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return n1stEvGrdCtnt
	 */
	public String getN1stEvGrdCtnt() {
		return this.n1stEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return evFctrCtnt
	 */
	public String getEvFctrCtnt() {
		return this.evFctrCtnt;
	}
	
	/**
	 * Column Info
	 * @return totWgt
	 */
	public String getTotWgt() {
		return this.totWgt;
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
	 * @return evAreaCtnt
	 */
	public String getEvAreaCtnt() {
		return this.evAreaCtnt;
	}
	
	/**
	 * Column Info
	 * @return evWgtRt
	 */
	public String getEvWgtRt() {
		return this.evWgtRt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return qualEvSeq
	 */
	public String getQualEvSeq() {
		return this.qualEvSeq;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
	}
	
	/**
	 * Column Info
	 * @return n2ndEvGrdCtnt
	 */
	public String getN2ndEvGrdCtnt() {
		return this.n2ndEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return n3rdEvGrdCtnt
	 */
	public String getN3rdEvGrdCtnt() {
		return this.n3rdEvGrdCtnt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param n1stEvGrdCtnt
	 */
	public void setN1stEvGrdCtnt(String n1stEvGrdCtnt) {
		this.n1stEvGrdCtnt = n1stEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param evFctrCtnt
	 */
	public void setEvFctrCtnt(String evFctrCtnt) {
		this.evFctrCtnt = evFctrCtnt;
	}
	
	/**
	 * Column Info
	 * @param totWgt
	 */
	public void setTotWgt(String totWgt) {
		this.totWgt = totWgt;
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
	 * @param evAreaCtnt
	 */
	public void setEvAreaCtnt(String evAreaCtnt) {
		this.evAreaCtnt = evAreaCtnt;
	}
	
	/**
	 * Column Info
	 * @param evWgtRt
	 */
	public void setEvWgtRt(String evWgtRt) {
		this.evWgtRt = evWgtRt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param qualEvSeq
	 */
	public void setQualEvSeq(String qualEvSeq) {
		this.qualEvSeq = qualEvSeq;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
	}
	
	/**
	 * Column Info
	 * @param n2ndEvGrdCtnt
	 */
	public void setN2ndEvGrdCtnt(String n2ndEvGrdCtnt) {
		this.n2ndEvGrdCtnt = n2ndEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param n3rdEvGrdCtnt
	 */
	public void setN3rdEvGrdCtnt(String n3rdEvGrdCtnt) {
		this.n3rdEvGrdCtnt = n3rdEvGrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN1stEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n1st_ev_grd_ctnt", ""));
		setEvFctrCtnt(JSPUtil.getParameter(request, prefix + "ev_fctr_ctnt", ""));
		setTotWgt(JSPUtil.getParameter(request, prefix + "tot_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEvAreaCtnt(JSPUtil.getParameter(request, prefix + "ev_area_ctnt", ""));
		setEvWgtRt(JSPUtil.getParameter(request, prefix + "ev_wgt_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setQualEvSeq(JSPUtil.getParameter(request, prefix + "qual_ev_seq", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setN2ndEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n2nd_ev_grd_ctnt", ""));
		setN3rdEvGrdCtnt(JSPUtil.getParameter(request, prefix + "n3rd_ev_grd_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeQECreVO[]
	 */
	public SpeQECreVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeQECreVO[]
	 */
	public SpeQECreVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeQECreVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_ev_grd_ctnt", length));
			String[] evFctrCtnt = (JSPUtil.getParameter(request, prefix	+ "ev_fctr_ctnt", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] evAreaCtnt = (JSPUtil.getParameter(request, prefix	+ "ev_area_ctnt", length));
			String[] evWgtRt = (JSPUtil.getParameter(request, prefix	+ "ev_wgt_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] qualEvSeq = (JSPUtil.getParameter(request, prefix	+ "qual_ev_seq", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] n2ndEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_ev_grd_ctnt", length));
			String[] n3rdEvGrdCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_ev_grd_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeQECreVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n1stEvGrdCtnt[i] != null)
					model.setN1stEvGrdCtnt(n1stEvGrdCtnt[i]);
				if (evFctrCtnt[i] != null)
					model.setEvFctrCtnt(evFctrCtnt[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (evAreaCtnt[i] != null)
					model.setEvAreaCtnt(evAreaCtnt[i]);
				if (evWgtRt[i] != null)
					model.setEvWgtRt(evWgtRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (qualEvSeq[i] != null)
					model.setQualEvSeq(qualEvSeq[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (n2ndEvGrdCtnt[i] != null)
					model.setN2ndEvGrdCtnt(n2ndEvGrdCtnt[i]);
				if (n3rdEvGrdCtnt[i] != null)
					model.setN3rdEvGrdCtnt(n3rdEvGrdCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeQECreVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeQECreVO[]
	 */
	public SpeQECreVO[] getSpeQECreVOs(){
		SpeQECreVO[] vos = (SpeQECreVO[])models.toArray(new SpeQECreVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEvGrdCtnt = this.n1stEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evFctrCtnt = this.evFctrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evAreaCtnt = this.evAreaCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evWgtRt = this.evWgtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qualEvSeq = this.qualEvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndEvGrdCtnt = this.n2ndEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdEvGrdCtnt = this.n3rdEvGrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
