/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchPolPodPairSectorListVO.java
*@FileTitle : SearchPolPodPairSectorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2014.01.22 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPolPodPairSectorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPolPodPairSectorListVO> models = new ArrayList<SearchPolPodPairSectorListVO>();
	
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String pfGrpCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCallSeq = null;
	/* Column Info */
	private String polCallSeq = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String sqmActFlg = null;
	/* Column Info */
	private String sqmMnSctrFlg = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String sctrOfcCreFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPolPodPairSectorListVO() {}

	public SearchPolPodPairSectorListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String pfGrpCd, String iasRgnCd, String dirCd, String rlaneCd, String polCd, String podCd, String polCallSeq, String podCallSeq, String sqmActFlg, String sqmMnSctrFlg, String sctrOfcCreFlg) {
		this.trdCd = trdCd;
		this.pfGrpCd = pfGrpCd;
		this.iasRgnCd = iasRgnCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.podCallSeq = podCallSeq;
		this.polCallSeq = polCallSeq;
		this.dirCd = dirCd;
		this.sqmActFlg = sqmActFlg;
		this.sqmMnSctrFlg = sqmMnSctrFlg;
		this.subTrdCd = subTrdCd;
		this.sctrOfcCreFlg = sctrOfcCreFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pf_grp_cd", getPfGrpCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_call_seq", getPodCallSeq());
		this.hashColumns.put("pol_call_seq", getPolCallSeq());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sqm_act_flg", getSqmActFlg());
		this.hashColumns.put("sqm_mn_sctr_flg", getSqmMnSctrFlg());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sctr_ofc_cre_flg", getSctrOfcCreFlg());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pf_grp_cd", "pfGrpCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_call_seq", "podCallSeq");
		this.hashFields.put("pol_call_seq", "polCallSeq");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sqm_act_flg", "sqmActFlg");
		this.hashFields.put("sqm_mn_sctr_flg", "sqmMnSctrFlg");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sctr_ofc_cre_flg", "sctrOfcCreFlg");

		return this.hashFields;
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
	 * @return pfGrpCd
	 */
	public String getPfGrpCd() {
		return this.pfGrpCd;
	}
	
	/**
	 * Column Info
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podCallSeq
	 */
	public String getPodCallSeq() {
		return this.podCallSeq;
	}
	
	/**
	 * Column Info
	 * @return polCallSeq
	 */
	public String getPolCallSeq() {
		return this.polCallSeq;
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
	 * @return sqmActFlg
	 */
	public String getSqmActFlg() {
		return this.sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @return sqmMnSctrFlg
	 */
	public String getSqmMnSctrFlg() {
		return this.sqmMnSctrFlg;
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
	 * @return sctrOfcCreFlg
	 */
	public String getSctrOfcCreFlg() {
		return this.sctrOfcCreFlg;
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
	 * @param pfGrpCd
	 */
	public void setPfGrpCd(String pfGrpCd) {
		this.pfGrpCd = pfGrpCd;
	}
	
	/**
	 * Column Info
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podCallSeq
	 */
	public void setPodCallSeq(String podCallSeq) {
		this.podCallSeq = podCallSeq;
	}
	
	/**
	 * Column Info
	 * @param polCallSeq
	 */
	public void setPolCallSeq(String polCallSeq) {
		this.polCallSeq = polCallSeq;
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
	 * @param sqmActFlg
	 */
	public void setSqmActFlg(String sqmActFlg) {
		this.sqmActFlg = sqmActFlg;
	}
	
	/**
	 * Column Info
	 * @param sqmMnSctrFlg
	 */
	public void setSqmMnSctrFlg(String sqmMnSctrFlg) {
		this.sqmMnSctrFlg = sqmMnSctrFlg;
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
	 * @param sctrOfcCreFlg
	 */
	public void setSctrOfcCreFlg(String sctrOfcCreFlg) {
		this.sctrOfcCreFlg = sctrOfcCreFlg;
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
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPfGrpCd(JSPUtil.getParameter(request, prefix + "pf_grp_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCallSeq(JSPUtil.getParameter(request, prefix + "pod_call_seq", ""));
		setPolCallSeq(JSPUtil.getParameter(request, prefix + "pol_call_seq", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSqmActFlg(JSPUtil.getParameter(request, prefix + "sqm_act_flg", ""));
		setSqmMnSctrFlg(JSPUtil.getParameter(request, prefix + "sqm_mn_sctr_flg", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSctrOfcCreFlg(JSPUtil.getParameter(request, prefix + "sctr_ofc_cre_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPolPodPairSectorListVO[]
	 */
	public SearchPolPodPairSectorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPolPodPairSectorListVO[]
	 */
	public SearchPolPodPairSectorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPolPodPairSectorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pfGrpCd = (JSPUtil.getParameter(request, prefix	+ "pf_grp_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCallSeq = (JSPUtil.getParameter(request, prefix	+ "pod_call_seq", length));
			String[] polCallSeq = (JSPUtil.getParameter(request, prefix	+ "pol_call_seq", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] sqmActFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_act_flg", length));
			String[] sqmMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_mn_sctr_flg", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] sctrOfcCreFlg = (JSPUtil.getParameter(request, prefix	+ "sctr_ofc_cre_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchPolPodPairSectorListVO();
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pfGrpCd[i] != null)
					model.setPfGrpCd(pfGrpCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCallSeq[i] != null)
					model.setPodCallSeq(podCallSeq[i]);
				if (polCallSeq[i] != null)
					model.setPolCallSeq(polCallSeq[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (sqmActFlg[i] != null)
					model.setSqmActFlg(sqmActFlg[i]);
				if (sqmMnSctrFlg[i] != null)
					model.setSqmMnSctrFlg(sqmMnSctrFlg[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (sctrOfcCreFlg[i] != null)
					model.setSctrOfcCreFlg(sctrOfcCreFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPolPodPairSectorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPolPodPairSectorListVO[]
	 */
	public SearchPolPodPairSectorListVO[] getSearchPolPodPairSectorListVOs(){
		SearchPolPodPairSectorListVO[] vos = (SearchPolPodPairSectorListVO[])models.toArray(new SearchPolPodPairSectorListVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfGrpCd = this.pfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCallSeq = this.podCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCallSeq = this.polCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmActFlg = this.sqmActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmMnSctrFlg = this.sqmMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctrOfcCreFlg = this.sctrOfcCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
