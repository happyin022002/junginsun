/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchMonthlyQuotaInfoList0077VO.java
*@FileTitle : SearchMonthlyQuotaInfoList0077VO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.08 김종호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo;

import java.lang.reflect.Field;
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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaInfoList0077VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaInfoList0077VO> models = new ArrayList<SearchMonthlyQuotaInfoList0077VO>();
	
	/* Column Info */
	private String mdlOp = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String mdlCm = null;
	/* Column Info */
	private String yqtCapa = null;
	/* Column Info */
	private String mdlCapa = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String mdlGrossRevenue = null;
	/* Column Info */
	private String yqtOp = null;
	/* Column Info */
	private String yqtGrossRevenue = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String accMdlRev = null;
	/* Column Info */
	private String accYqtRev = null;
	/* Column Info */
	private String accYqtLoad = null;
	/* Column Info */
	private String yqtLoad = null;
	/* Column Info */
	private String accMdlLoad = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mdlLoad = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String yqtCm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaInfoList0077VO() {}

	public SearchMonthlyQuotaInfoList0077VO(String ibflag, String pagerows, String key, String slevel, String trdCd, String dirCd, String subTrdCd, String yqtLoad, String mdlLoad, String yqtGrossRevenue, String mdlGrossRevenue, String yqtCm, String mdlCm, String yqtOp, String mdlOp, String accYqtLoad, String accYqtRev, String accMdlLoad, String accMdlRev, String mdlCapa, String yqtCapa) {
		this.mdlOp = mdlOp;
		this.slevel = slevel;
		this.mdlCm = mdlCm;
		this.yqtCapa = yqtCapa;
		this.mdlCapa = mdlCapa;
		this.trdCd = trdCd;
		this.mdlGrossRevenue = mdlGrossRevenue;
		this.yqtOp = yqtOp;
		this.yqtGrossRevenue = yqtGrossRevenue;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.accMdlRev = accMdlRev;
		this.accYqtRev = accYqtRev;
		this.accYqtLoad = accYqtLoad;
		this.yqtLoad = yqtLoad;
		this.accMdlLoad = accMdlLoad;
		this.dirCd = dirCd;
		this.mdlLoad = mdlLoad;
		this.key = key;
		this.subTrdCd = subTrdCd;
		this.yqtCm = yqtCm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mdl_op", getMdlOp());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("mdl_cm", getMdlCm());
		this.hashColumns.put("yqt_capa", getYqtCapa());
		this.hashColumns.put("mdl_capa", getMdlCapa());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("mdl_gross_revenue", getMdlGrossRevenue());
		this.hashColumns.put("yqt_op", getYqtOp());
		this.hashColumns.put("yqt_gross_revenue", getYqtGrossRevenue());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acc_mdl_rev", getAccMdlRev());
		this.hashColumns.put("acc_yqt_rev", getAccYqtRev());
		this.hashColumns.put("acc_yqt_load", getAccYqtLoad());
		this.hashColumns.put("yqt_load", getYqtLoad());
		this.hashColumns.put("acc_mdl_load", getAccMdlLoad());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mdl_load", getMdlLoad());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("yqt_cm", getYqtCm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mdl_op", "mdlOp");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("mdl_cm", "mdlCm");
		this.hashFields.put("yqt_capa", "yqtCapa");
		this.hashFields.put("mdl_capa", "mdlCapa");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mdl_gross_revenue", "mdlGrossRevenue");
		this.hashFields.put("yqt_op", "yqtOp");
		this.hashFields.put("yqt_gross_revenue", "yqtGrossRevenue");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acc_mdl_rev", "accMdlRev");
		this.hashFields.put("acc_yqt_rev", "accYqtRev");
		this.hashFields.put("acc_yqt_load", "accYqtLoad");
		this.hashFields.put("yqt_load", "yqtLoad");
		this.hashFields.put("acc_mdl_load", "accMdlLoad");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mdl_load", "mdlLoad");
		this.hashFields.put("key", "key");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("yqt_cm", "yqtCm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mdlOp
	 */
	public String getMdlOp() {
		return this.mdlOp;
	}
	
	/**
	 * Column Info
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
	}
	
	/**
	 * Column Info
	 * @return mdlCm
	 */
	public String getMdlCm() {
		return this.mdlCm;
	}
	
	/**
	 * Column Info
	 * @return yqtCapa
	 */
	public String getYqtCapa() {
		return this.yqtCapa;
	}
	
	/**
	 * Column Info
	 * @return mdlCapa
	 */
	public String getMdlCapa() {
		return this.mdlCapa;
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
	 * @return mdlGrossRevenue
	 */
	public String getMdlGrossRevenue() {
		return this.mdlGrossRevenue;
	}
	
	/**
	 * Column Info
	 * @return yqtOp
	 */
	public String getYqtOp() {
		return this.yqtOp;
	}
	
	/**
	 * Column Info
	 * @return yqtGrossRevenue
	 */
	public String getYqtGrossRevenue() {
		return this.yqtGrossRevenue;
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
	 * @return accMdlRev
	 */
	public String getAccMdlRev() {
		return this.accMdlRev;
	}
	
	/**
	 * Column Info
	 * @return accYqtRev
	 */
	public String getAccYqtRev() {
		return this.accYqtRev;
	}
	
	/**
	 * Column Info
	 * @return accYqtLoad
	 */
	public String getAccYqtLoad() {
		return this.accYqtLoad;
	}
	
	/**
	 * Column Info
	 * @return yqtLoad
	 */
	public String getYqtLoad() {
		return this.yqtLoad;
	}
	
	/**
	 * Column Info
	 * @return accMdlLoad
	 */
	public String getAccMdlLoad() {
		return this.accMdlLoad;
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
	 * @return mdlLoad
	 */
	public String getMdlLoad() {
		return this.mdlLoad;
	}
	
	/**
	 * Column Info
	 * @return key
	 */
	public String getKey() {
		return this.key;
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
	 * @return yqtCm
	 */
	public String getYqtCm() {
		return this.yqtCm;
	}
	

	/**
	 * Column Info
	 * @param mdlOp
	 */
	public void setMdlOp(String mdlOp) {
		this.mdlOp = mdlOp;
	}
	
	/**
	 * Column Info
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}
	
	/**
	 * Column Info
	 * @param mdlCm
	 */
	public void setMdlCm(String mdlCm) {
		this.mdlCm = mdlCm;
	}
	
	/**
	 * Column Info
	 * @param yqtCapa
	 */
	public void setYqtCapa(String yqtCapa) {
		this.yqtCapa = yqtCapa;
	}
	
	/**
	 * Column Info
	 * @param mdlCapa
	 */
	public void setMdlCapa(String mdlCapa) {
		this.mdlCapa = mdlCapa;
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
	 * @param mdlGrossRevenue
	 */
	public void setMdlGrossRevenue(String mdlGrossRevenue) {
		this.mdlGrossRevenue = mdlGrossRevenue;
	}
	
	/**
	 * Column Info
	 * @param yqtOp
	 */
	public void setYqtOp(String yqtOp) {
		this.yqtOp = yqtOp;
	}
	
	/**
	 * Column Info
	 * @param yqtGrossRevenue
	 */
	public void setYqtGrossRevenue(String yqtGrossRevenue) {
		this.yqtGrossRevenue = yqtGrossRevenue;
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
	 * @param accMdlRev
	 */
	public void setAccMdlRev(String accMdlRev) {
		this.accMdlRev = accMdlRev;
	}
	
	/**
	 * Column Info
	 * @param accYqtRev
	 */
	public void setAccYqtRev(String accYqtRev) {
		this.accYqtRev = accYqtRev;
	}
	
	/**
	 * Column Info
	 * @param accYqtLoad
	 */
	public void setAccYqtLoad(String accYqtLoad) {
		this.accYqtLoad = accYqtLoad;
	}
	
	/**
	 * Column Info
	 * @param yqtLoad
	 */
	public void setYqtLoad(String yqtLoad) {
		this.yqtLoad = yqtLoad;
	}
	
	/**
	 * Column Info
	 * @param accMdlLoad
	 */
	public void setAccMdlLoad(String accMdlLoad) {
		this.accMdlLoad = accMdlLoad;
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
	 * @param mdlLoad
	 */
	public void setMdlLoad(String mdlLoad) {
		this.mdlLoad = mdlLoad;
	}
	
	/**
	 * Column Info
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param yqtCm
	 */
	public void setYqtCm(String yqtCm) {
		this.yqtCm = yqtCm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMdlOp(JSPUtil.getParameter(request, "mdl_op", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setMdlCm(JSPUtil.getParameter(request, "mdl_cm", ""));
		setYqtCapa(JSPUtil.getParameter(request, "yqt_capa", ""));
		setMdlCapa(JSPUtil.getParameter(request, "mdl_capa", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setMdlGrossRevenue(JSPUtil.getParameter(request, "mdl_gross_revenue", ""));
		setYqtOp(JSPUtil.getParameter(request, "yqt_op", ""));
		setYqtGrossRevenue(JSPUtil.getParameter(request, "yqt_gross_revenue", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAccMdlRev(JSPUtil.getParameter(request, "acc_mdl_rev", ""));
		setAccYqtRev(JSPUtil.getParameter(request, "acc_yqt_rev", ""));
		setAccYqtLoad(JSPUtil.getParameter(request, "acc_yqt_load", ""));
		setYqtLoad(JSPUtil.getParameter(request, "yqt_load", ""));
		setAccMdlLoad(JSPUtil.getParameter(request, "acc_mdl_load", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setMdlLoad(JSPUtil.getParameter(request, "mdl_load", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setYqtCm(JSPUtil.getParameter(request, "yqt_cm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaInfoList0077VO[]
	 */
	public SearchMonthlyQuotaInfoList0077VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaInfoList0077VO[]
	 */
	public SearchMonthlyQuotaInfoList0077VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaInfoList0077VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mdlOp = (JSPUtil.getParameter(request, prefix	+ "mdl_op", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] mdlCm = (JSPUtil.getParameter(request, prefix	+ "mdl_cm", length));
			String[] yqtCapa = (JSPUtil.getParameter(request, prefix	+ "yqt_capa", length));
			String[] mdlCapa = (JSPUtil.getParameter(request, prefix	+ "mdl_capa", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] mdlGrossRevenue = (JSPUtil.getParameter(request, prefix	+ "mdl_gross_revenue", length));
			String[] yqtOp = (JSPUtil.getParameter(request, prefix	+ "yqt_op", length));
			String[] yqtGrossRevenue = (JSPUtil.getParameter(request, prefix	+ "yqt_gross_revenue", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] accMdlRev = (JSPUtil.getParameter(request, prefix	+ "acc_mdl_rev", length));
			String[] accYqtRev = (JSPUtil.getParameter(request, prefix	+ "acc_yqt_rev", length));
			String[] accYqtLoad = (JSPUtil.getParameter(request, prefix	+ "acc_yqt_load", length));
			String[] yqtLoad = (JSPUtil.getParameter(request, prefix	+ "yqt_load", length));
			String[] accMdlLoad = (JSPUtil.getParameter(request, prefix	+ "acc_mdl_load", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mdlLoad = (JSPUtil.getParameter(request, prefix	+ "mdl_load", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] yqtCm = (JSPUtil.getParameter(request, prefix	+ "yqt_cm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaInfoList0077VO();
				if (mdlOp[i] != null)
					model.setMdlOp(mdlOp[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (mdlCm[i] != null)
					model.setMdlCm(mdlCm[i]);
				if (yqtCapa[i] != null)
					model.setYqtCapa(yqtCapa[i]);
				if (mdlCapa[i] != null)
					model.setMdlCapa(mdlCapa[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (mdlGrossRevenue[i] != null)
					model.setMdlGrossRevenue(mdlGrossRevenue[i]);
				if (yqtOp[i] != null)
					model.setYqtOp(yqtOp[i]);
				if (yqtGrossRevenue[i] != null)
					model.setYqtGrossRevenue(yqtGrossRevenue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (accMdlRev[i] != null)
					model.setAccMdlRev(accMdlRev[i]);
				if (accYqtRev[i] != null)
					model.setAccYqtRev(accYqtRev[i]);
				if (accYqtLoad[i] != null)
					model.setAccYqtLoad(accYqtLoad[i]);
				if (yqtLoad[i] != null)
					model.setYqtLoad(yqtLoad[i]);
				if (accMdlLoad[i] != null)
					model.setAccMdlLoad(accMdlLoad[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mdlLoad[i] != null)
					model.setMdlLoad(mdlLoad[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (yqtCm[i] != null)
					model.setYqtCm(yqtCm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaInfoList0077VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaInfoList0077VO[]
	 */
	public SearchMonthlyQuotaInfoList0077VO[] getSearchMonthlyQuotaInfoList0077VOs(){
		SearchMonthlyQuotaInfoList0077VO[] vos = (SearchMonthlyQuotaInfoList0077VO[])models.toArray(new SearchMonthlyQuotaInfoList0077VO[models.size()]);
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
		this.mdlOp = this.mdlOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlCm = this.mdlCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtCapa = this.yqtCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlCapa = this.mdlCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlGrossRevenue = this.mdlGrossRevenue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtOp = this.yqtOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtGrossRevenue = this.yqtGrossRevenue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accMdlRev = this.accMdlRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accYqtRev = this.accYqtRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accYqtLoad = this.accYqtLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtLoad = this.yqtLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accMdlLoad = this.accMdlLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlLoad = this.mdlLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtCm = this.yqtCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
