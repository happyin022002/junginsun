/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzVVDListVO.java
*@FileTitle : CanalTzVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.20 김성광 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

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
 * @author 김성광
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzVVDListVO> models = new ArrayList<CanalTzVVDListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String advPyRevMon = null;
	/* Column Info */
	private String transymd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String pyDueDt = null;
	/* Column Info */
	private String iseq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String advPySts = null;
	/* Column Info */
	private String revyrmon = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String trnsDt = null;
	/* Column Info */
	private String eseq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzVVDListVO() {}

	public CanalTzVVDListVO(String ibflag, String pagerows, String vslNm, String vslCd, String skdVoyNo, String skdDirCd, String lane, String ydCd, String trnsDt, String pyDueDt, String advPySts, String advPyRevMon, String eseq, String iseq, String revyrmon, String transymd, String vndrSeq) {
		this.vslCd = vslCd;
		this.advPyRevMon = advPyRevMon;
		this.transymd = transymd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.pyDueDt = pyDueDt;
		this.iseq = iseq;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ibflag = ibflag;
		this.advPySts = advPySts;
		this.revyrmon = revyrmon;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.trnsDt = trnsDt;
		this.eseq = eseq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("adv_py_rev_mon", getAdvPyRevMon());
		this.hashColumns.put("transymd", getTransymd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("py_due_dt", getPyDueDt());
		this.hashColumns.put("iseq", getIseq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adv_py_sts", getAdvPySts());
		this.hashColumns.put("revyrmon", getRevyrmon());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("trns_dt", getTrnsDt());
		this.hashColumns.put("eseq", getEseq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("adv_py_rev_mon", "advPyRevMon");
		this.hashFields.put("transymd", "transymd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("py_due_dt", "pyDueDt");
		this.hashFields.put("iseq", "iseq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adv_py_sts", "advPySts");
		this.hashFields.put("revyrmon", "revyrmon");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("trns_dt", "trnsDt");
		this.hashFields.put("eseq", "eseq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return advPyRevMon
	 */
	public String getAdvPyRevMon() {
		return this.advPyRevMon;
	}
	
	/**
	 * Column Info
	 * @return transymd
	 */
	public String getTransymd() {
		return this.transymd;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return pyDueDt
	 */
	public String getPyDueDt() {
		return this.pyDueDt;
	}
	
	/**
	 * Column Info
	 * @return iseq
	 */
	public String getIseq() {
		return this.iseq;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return advPySts
	 */
	public String getAdvPySts() {
		return this.advPySts;
	}
	
	/**
	 * Column Info
	 * @return revyrmon
	 */
	public String getRevyrmon() {
		return this.revyrmon;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trnsDt
	 */
	public String getTrnsDt() {
		return this.trnsDt;
	}
	
	/**
	 * Column Info
	 * @return eseq
	 */
	public String getEseq() {
		return this.eseq;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param advPyRevMon
	 */
	public void setAdvPyRevMon(String advPyRevMon) {
		this.advPyRevMon = advPyRevMon;
	}
	
	/**
	 * Column Info
	 * @param transymd
	 */
	public void setTransymd(String transymd) {
		this.transymd = transymd;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param pyDueDt
	 */
	public void setPyDueDt(String pyDueDt) {
		this.pyDueDt = pyDueDt;
	}
	
	/**
	 * Column Info
	 * @param iseq
	 */
	public void setIseq(String iseq) {
		this.iseq = iseq;
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
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param advPySts
	 */
	public void setAdvPySts(String advPySts) {
		this.advPySts = advPySts;
	}
	
	/**
	 * Column Info
	 * @param revyrmon
	 */
	public void setRevyrmon(String revyrmon) {
		this.revyrmon = revyrmon;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trnsDt
	 */
	public void setTrnsDt(String trnsDt) {
		this.trnsDt = trnsDt;
	}
	
	/**
	 * Column Info
	 * @param eseq
	 */
	public void setEseq(String eseq) {
		this.eseq = eseq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAdvPyRevMon(JSPUtil.getParameter(request, "adv_py_rev_mon", ""));
		setTransymd(JSPUtil.getParameter(request, "transymd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setPyDueDt(JSPUtil.getParameter(request, "py_due_dt", ""));
		setIseq(JSPUtil.getParameter(request, "iseq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAdvPySts(JSPUtil.getParameter(request, "adv_py_sts", ""));
		setRevyrmon(JSPUtil.getParameter(request, "revyrmon", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTrnsDt(JSPUtil.getParameter(request, "trns_dt", ""));
		setEseq(JSPUtil.getParameter(request, "eseq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzVVDListVO[]
	 */
	public CanalTzVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzVVDListVO[]
	 */
	public CanalTzVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] advPyRevMon = (JSPUtil.getParameter(request, prefix	+ "adv_py_rev_mon", length));
			String[] transymd = (JSPUtil.getParameter(request, prefix	+ "transymd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] pyDueDt = (JSPUtil.getParameter(request, prefix	+ "py_due_dt", length));
			String[] iseq = (JSPUtil.getParameter(request, prefix	+ "iseq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] advPySts = (JSPUtil.getParameter(request, prefix	+ "adv_py_sts", length));
			String[] revyrmon = (JSPUtil.getParameter(request, prefix	+ "revyrmon", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] trnsDt = (JSPUtil.getParameter(request, prefix	+ "trns_dt", length));
			String[] eseq = (JSPUtil.getParameter(request, prefix	+ "eseq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzVVDListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (advPyRevMon[i] != null)
					model.setAdvPyRevMon(advPyRevMon[i]);
				if (transymd[i] != null)
					model.setTransymd(transymd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (pyDueDt[i] != null)
					model.setPyDueDt(pyDueDt[i]);
				if (iseq[i] != null)
					model.setIseq(iseq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (advPySts[i] != null)
					model.setAdvPySts(advPySts[i]);
				if (revyrmon[i] != null)
					model.setRevyrmon(revyrmon[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (trnsDt[i] != null)
					model.setTrnsDt(trnsDt[i]);
				if (eseq[i] != null)
					model.setEseq(eseq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzVVDListVO[]
	 */
	public CanalTzVVDListVO[] getCanalTzVVDListVOs(){
		CanalTzVVDListVO[] vos = (CanalTzVVDListVO[])models.toArray(new CanalTzVVDListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPyRevMon = this.advPyRevMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transymd = this.transymd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pyDueDt = this.pyDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iseq = this.iseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPySts = this.advPySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revyrmon = this.revyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsDt = this.trnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eseq = this.eseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
