/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorIftsaiVslPortVO.java
*@FileTitle : KorIftsaiVslPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.30 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorIftsaiVslPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorIftsaiVslPortVO> models = new ArrayList<KorIftsaiVslPortVO>();
	
	/* Column Info */
	private String vpsPlismVsl = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsCallSeq = null;
	/* Column Info */
	private String vpsCallInd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsPlismVoy = null;
	/* Column Info */
	private String vpsLaneCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorIftsaiVslPortVO() {}

	public KorIftsaiVslPortVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String vpsPortCd, String skdDirCd, String vpsCallInd, String vpsCallSeq, String vpsLaneCd, String vpsPlismVsl, String vpsPlismVoy) {
		this.vpsPlismVsl = vpsPlismVsl;
		this.vpsPortCd = vpsPortCd;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.vpsCallSeq = vpsCallSeq;
		this.vpsCallInd = vpsCallInd;
		this.skdVoyNo = skdVoyNo;
		this.vpsPlismVoy = vpsPlismVoy;
		this.vpsLaneCd = vpsLaneCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_plism_vsl", getVpsPlismVsl());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_call_seq", getVpsCallSeq());
		this.hashColumns.put("vps_call_ind", getVpsCallInd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_plism_voy", getVpsPlismVoy());
		this.hashColumns.put("vps_lane_cd", getVpsLaneCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_plism_vsl", "vpsPlismVsl");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_call_seq", "vpsCallSeq");
		this.hashFields.put("vps_call_ind", "vpsCallInd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_plism_voy", "vpsPlismVoy");
		this.hashFields.put("vps_lane_cd", "vpsLaneCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsPlismVsl
	 */
	public String getVpsPlismVsl() {
		return this.vpsPlismVsl;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return vpsCallSeq
	 */
	public String getVpsCallSeq() {
		return this.vpsCallSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsCallInd
	 */
	public String getVpsCallInd() {
		return this.vpsCallInd;
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
	 * @return vpsPlismVoy
	 */
	public String getVpsPlismVoy() {
		return this.vpsPlismVoy;
	}
	
	/**
	 * Column Info
	 * @return vpsLaneCd
	 */
	public String getVpsLaneCd() {
		return this.vpsLaneCd;
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
	 * Column Info
	 * @param vpsPlismVsl
	 */
	public void setVpsPlismVsl(String vpsPlismVsl) {
		this.vpsPlismVsl = vpsPlismVsl;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param vpsCallSeq
	 */
	public void setVpsCallSeq(String vpsCallSeq) {
		this.vpsCallSeq = vpsCallSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsCallInd
	 */
	public void setVpsCallInd(String vpsCallInd) {
		this.vpsCallInd = vpsCallInd;
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
	 * @param vpsPlismVoy
	 */
	public void setVpsPlismVoy(String vpsPlismVoy) {
		this.vpsPlismVoy = vpsPlismVoy;
	}
	
	/**
	 * Column Info
	 * @param vpsLaneCd
	 */
	public void setVpsLaneCd(String vpsLaneCd) {
		this.vpsLaneCd = vpsLaneCd;
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
		setVpsPlismVsl(JSPUtil.getParameter(request, prefix + "vps_plism_vsl", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVpsCallSeq(JSPUtil.getParameter(request, prefix + "vps_call_seq", ""));
		setVpsCallInd(JSPUtil.getParameter(request, prefix + "vps_call_ind", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVpsPlismVoy(JSPUtil.getParameter(request, prefix + "vps_plism_voy", ""));
		setVpsLaneCd(JSPUtil.getParameter(request, prefix + "vps_lane_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorIftsaiVslPortVO[]
	 */
	public KorIftsaiVslPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorIftsaiVslPortVO[]
	 */
	public KorIftsaiVslPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorIftsaiVslPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsPlismVsl = (JSPUtil.getParameter(request, prefix	+ "vps_plism_vsl", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsCallSeq = (JSPUtil.getParameter(request, prefix	+ "vps_call_seq", length));
			String[] vpsCallInd = (JSPUtil.getParameter(request, prefix	+ "vps_call_ind", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vpsPlismVoy = (JSPUtil.getParameter(request, prefix	+ "vps_plism_voy", length));
			String[] vpsLaneCd = (JSPUtil.getParameter(request, prefix	+ "vps_lane_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorIftsaiVslPortVO();
				if (vpsPlismVsl[i] != null)
					model.setVpsPlismVsl(vpsPlismVsl[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsCallSeq[i] != null)
					model.setVpsCallSeq(vpsCallSeq[i]);
				if (vpsCallInd[i] != null)
					model.setVpsCallInd(vpsCallInd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsPlismVoy[i] != null)
					model.setVpsPlismVoy(vpsPlismVoy[i]);
				if (vpsLaneCd[i] != null)
					model.setVpsLaneCd(vpsLaneCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorIftsaiVslPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorIftsaiVslPortVO[]
	 */
	public KorIftsaiVslPortVO[] getKorIftsaiVslPortVOs(){
		KorIftsaiVslPortVO[] vos = (KorIftsaiVslPortVO[])models.toArray(new KorIftsaiVslPortVO[models.size()]);
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
		this.vpsPlismVsl = this.vpsPlismVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCallSeq = this.vpsCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCallInd = this.vpsCallInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPlismVoy = this.vpsPlismVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsLaneCd = this.vpsLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
