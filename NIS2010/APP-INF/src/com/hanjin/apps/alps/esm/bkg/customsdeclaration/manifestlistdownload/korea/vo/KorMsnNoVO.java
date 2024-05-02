/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorMsnNoVO.java
*@FileTitle : KorMsnNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.08 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see MsnNoVO
 */

public class KorMsnNoVO extends MsnNoVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMsnNoVO> models = new ArrayList<KorMsnNoVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String msnStartNum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String hidden3 = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String fe = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMsnNoVO() {}

	public KorMsnNoVO(String ibflag, String pagerows, String msnStartNum, String inVvd, String inPod, String tp, String fe, String blNo, String bkgNo, String hidden3, String pod, String msn) {
		this.inVvd = inVvd;
		this.inPod = inPod;
		this.bkgNo = bkgNo;
		this.msnStartNum = msnStartNum;
		this.ibflag = ibflag;
		this.msn = msn;
		this.hidden3 = hidden3;
		this.tp = tp;
		this.blNo = blNo;
		this.fe = fe;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("msn_start_num", getMsnStartNum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fe", getFe());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("msn_start_num", "msnStartNum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fe", "fe");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
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
	 * @return msnStartNum
	 */
	public String getMsnStartNum() {
		return this.msnStartNum;
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
	 * @return msn
	 */
	public String getMsn() {
		return this.msn;
	}
	
	/**
	 * Column Info
	 * @return hidden3
	 */
	public String getHidden3() {
		return this.hidden3;
	}
	
	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return fe
	 */
	public String getFe() {
		return this.fe;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
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
	 * @param msnStartNum
	 */
	public void setMsnStartNum(String msnStartNum) {
		this.msnStartNum = msnStartNum;
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
	 * @param msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	/**
	 * Column Info
	 * @param hidden3
	 */
	public void setHidden3(String hidden3) {
		this.hidden3 = hidden3;
	}
	
	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param fe
	 */
	public void setFe(String fe) {
		this.fe = fe;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setInPod(JSPUtil.getParameter(request, prefix + "in_pod", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMsnStartNum(JSPUtil.getParameter(request, prefix + "msn_start_num", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMsn(JSPUtil.getParameter(request, prefix + "msn", ""));
		setHidden3(JSPUtil.getParameter(request, prefix + "hidden3", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMsnNoVO[]
	 */
	public KorMsnNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMsnNoVO[]
	 */
	public KorMsnNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMsnNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] msnStartNum = (JSPUtil.getParameter(request, prefix	+ "msn_start_num", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn", length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMsnNoVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (msnStartNum[i] != null)
					model.setMsnStartNum(msnStartNum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msn[i] != null)
					model.setMsn(msn[i]);
				if (hidden3[i] != null)
					model.setHidden3(hidden3[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMsnNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMsnNoVO[]
	 */
	public KorMsnNoVO[] getKorMsnNoVOs(){
		KorMsnNoVO[] vos = (KorMsnNoVO[])models.toArray(new KorMsnNoVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnStartNum = this.msnStartNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
