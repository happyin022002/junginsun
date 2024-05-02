/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorTransCrossChkCondVO.java
*@FileTitle : KorTransCrossChkCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier :
*@LastVersion : 1.0
* 2011.02.17
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorTransCrossChkCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorTransCrossChkCondVO> models = new ArrayList<KorTransCrossChkCondVO>();

	/* Column Info */
	private String depType = null;
	/* Column Info */
	private String selType = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String oprType = null;
	/* Column Info */
	private String radDepType = null;
	/* Column Info */
	private String radVvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String radLaneType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String radTransType = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorTransCrossChkCondVO() {}

	public KorTransCrossChkCondVO(String ibflag, String pagerows, String radDepType, String radVvd, String depType, String startDt, String endDt, String pol, String pod, String vvd, String oprType, String radTransType, String selType, String radLaneType) {
		this.depType = depType;
		this.selType = selType;
		this.endDt = endDt;
		this.oprType = oprType;
		this.radDepType = radDepType;
		this.radVvd = radVvd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.radLaneType = radLaneType;
		this.ibflag = ibflag;
		this.startDt = startDt;
		this.pol = pol;
		this.radTransType = radTransType;
		this.pod = pod;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dep_type", getDepType());
		this.hashColumns.put("sel_type", getSelType());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("opr_type", getOprType());
		this.hashColumns.put("rad_dep_type", getRadDepType());
		this.hashColumns.put("rad_vvd", getRadVvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rad_lane_type", getRadLaneType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("rad_trans_type", getRadTransType());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dep_type", "depType");
		this.hashFields.put("sel_type", "selType");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("opr_type", "oprType");
		this.hashFields.put("rad_dep_type", "radDepType");
		this.hashFields.put("rad_vvd", "radVvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rad_lane_type", "radLaneType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("rad_trans_type", "radTransType");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return depType
	 */
	public String getDepType() {
		return this.depType;
	}

	/**
	 * Column Info
	 * @return selType
	 */
	public String getSelType() {
		return this.selType;
	}

	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}

	/**
	 * Column Info
	 * @return oprType
	 */
	public String getOprType() {
		return this.oprType;
	}

	/**
	 * Column Info
	 * @return radDepType
	 */
	public String getRadDepType() {
		return this.radDepType;
	}

	/**
	 * Column Info
	 * @return radVvd
	 */
	public String getRadVvd() {
		return this.radVvd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return radLaneType
	 */
	public String getRadLaneType() {
		return this.radLaneType;
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
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
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
	 * @return radTransType
	 */
	public String getRadTransType() {
		return this.radTransType;
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
	 * @param depType
	 */
	public void setDepType(String depType) {
		this.depType = depType;
	}

	/**
	 * Column Info
	 * @param selType
	 */
	public void setSelType(String selType) {
		this.selType = selType;
	}

	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	/**
	 * Column Info
	 * @param oprType
	 */
	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

	/**
	 * Column Info
	 * @param radDepType
	 */
	public void setRadDepType(String radDepType) {
		this.radDepType = radDepType;
	}

	/**
	 * Column Info
	 * @param radVvd
	 */
	public void setRadVvd(String radVvd) {
		this.radVvd = radVvd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param radLaneType
	 */
	public void setRadLaneType(String radLaneType) {
		this.radLaneType = radLaneType;
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
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
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
	 * @param radTransType
	 */
	public void setRadTransType(String radTransType) {
		this.radTransType = radTransType;
	}

	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setDepType(JSPUtil.getParameter(request, prefix + "dep_type", ""));
		setSelType(JSPUtil.getParameter(request, prefix + "sel_type", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setOprType(JSPUtil.getParameter(request, prefix + "opr_type", ""));
		setRadDepType(JSPUtil.getParameter(request, prefix + "rad_dep_type", ""));
		setRadVvd(JSPUtil.getParameter(request, prefix + "rad_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRadLaneType(JSPUtil.getParameter(request, prefix + "rad_lane_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStartDt(JSPUtil.getParameter(request, prefix + "start_dt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setRadTransType(JSPUtil.getParameter(request, prefix + "rad_trans_type", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransCrossChkCondVO[]
	 */
	public KorTransCrossChkCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorTransCrossChkCondVO[]
	 */
	public KorTransCrossChkCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorTransCrossChkCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] depType = (JSPUtil.getParameter(request, prefix	+ "dep_type", length));
			String[] selType = (JSPUtil.getParameter(request, prefix	+ "sel_type", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] oprType = (JSPUtil.getParameter(request, prefix	+ "opr_type", length));
			String[] radDepType = (JSPUtil.getParameter(request, prefix	+ "rad_dep_type", length));
			String[] radVvd = (JSPUtil.getParameter(request, prefix	+ "rad_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] radLaneType = (JSPUtil.getParameter(request, prefix	+ "rad_lane_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] radTransType = (JSPUtil.getParameter(request, prefix	+ "rad_trans_type", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));

			for (int i = 0; i < length; i++) {
				model = new KorTransCrossChkCondVO();
				if (depType[i] != null)
					model.setDepType(depType[i]);
				if (selType[i] != null)
					model.setSelType(selType[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (oprType[i] != null)
					model.setOprType(oprType[i]);
				if (radDepType[i] != null)
					model.setRadDepType(radDepType[i]);
				if (radVvd[i] != null)
					model.setRadVvd(radVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (radLaneType[i] != null)
					model.setRadLaneType(radLaneType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (radTransType[i] != null)
					model.setRadTransType(radTransType[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorTransCrossChkCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransCrossChkCondVO[]
	 */
	public KorTransCrossChkCondVO[] getKorTransCrossChkCondVOs(){
		KorTransCrossChkCondVO[] vos = (KorTransCrossChkCondVO[])models.toArray(new KorTransCrossChkCondVO[models.size()]);
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
		this.depType = this.depType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selType = this.selType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprType = this.oprType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radDepType = this.radDepType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radVvd = this.radVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radLaneType = this.radLaneType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radTransType = this.radTransType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
