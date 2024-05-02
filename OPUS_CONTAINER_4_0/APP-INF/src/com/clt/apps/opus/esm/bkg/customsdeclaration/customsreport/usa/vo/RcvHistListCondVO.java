/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RcvHistListCondVO.java
*@FileTitle : RcvHistListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
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

public class RcvHistListCondVO extends RcvHistCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RcvHistListCondVO> models = new ArrayList<RcvHistListCondVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tod = null;
	/* Column Info */
	private String endNo = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String fromd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String fromt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String startNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rcvDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cstmsBatNo = null;
	/* Column Info */
	private String rcvMsgTpId = null;
	/* Column Info */
	private String scacCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RcvHistListCondVO() {}

	public RcvHistListCondVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String podCd, String polCd, String gubun, String fromd, String fromt, String tod, String tot, String blNo, String cstmsBatNo, String rcvMsgTpId, String cntCd, String ioBndCd, String rcvDate, String rcvSeq, String startNo, String endNo, String pageNo, String scacCd) {
		this.vslCd = vslCd;
		this.tod = tod;
		this.endNo = endNo;
		this.gubun = gubun;
		this.fromd = fromd;
		this.skdVoyNo = skdVoyNo;
		this.rcvSeq = rcvSeq;
		this.fromt = fromt;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.startNo = startNo;
		this.vvd = vvd;
		this.podCd = podCd;
		this.rcvDate = rcvDate;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.tot = tot;
		this.pageNo = pageNo;
		this.cntCd = cntCd;
		this.cstmsBatNo = cstmsBatNo;
		this.rcvMsgTpId = rcvMsgTpId;
		this.scacCd = scacCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tod", getTod());
		this.hashColumns.put("end_no", getEndNo());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fromd", getFromd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("fromt", getFromt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("start_no", getStartNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rcv_date", getRcvDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cstms_bat_no", getCstmsBatNo());
		this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
		this.hashColumns.put("scac_cd", getScacCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tod", "tod");
		this.hashFields.put("end_no", "endNo");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fromd", "fromd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("fromt", "fromt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("start_no", "startNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rcv_date", "rcvDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cstms_bat_no", "cstmsBatNo");
		this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
		this.hashFields.put("scac_cd", "scacCd");
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
	 * @return tod
	 */
	public String getTod() {
		return this.tod;
	}
	
	/**
	 * Column Info
	 * @return endNo
	 */
	public String getEndNo() {
		return this.endNo;
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
	 * @return fromd
	 */
	public String getFromd() {
		return this.fromd;
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
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return fromt
	 */
	public String getFromt() {
		return this.fromt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return startNo
	 */
	public String getStartNo() {
		return this.startNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDate
	 */
	public String getRcvDate() {
		return this.rcvDate;
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
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsBatNo
	 */
	public String getCstmsBatNo() {
		return this.cstmsBatNo;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpId
	 */
	public String getRcvMsgTpId() {
		return this.rcvMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpId
	 */
	public String getScacCd() {
		return this.scacCd;
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
	 * @param tod
	 */
	public void setTod(String tod) {
		this.tod = tod;
	}
	
	/**
	 * Column Info
	 * @param endNo
	 */
	public void setEndNo(String endNo) {
		this.endNo = endNo;
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
	 * @param fromd
	 */
	public void setFromd(String fromd) {
		this.fromd = fromd;
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
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param fromt
	 */
	public void setFromt(String fromt) {
		this.fromt = fromt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDate
	 */
	public void setRcvDate(String rcvDate) {
		this.rcvDate = rcvDate;
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
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsBatNo
	 */
	public void setCstmsBatNo(String cstmsBatNo) {
		this.cstmsBatNo = cstmsBatNo;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgTpId
	 */
	public void setRcvMsgTpId(String rcvMsgTpId) {
		this.rcvMsgTpId = rcvMsgTpId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTod(JSPUtil.getParameter(request, "tod", ""));
		setEndNo(JSPUtil.getParameter(request, "end_no", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setFromd(JSPUtil.getParameter(request, "fromd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setFromt(JSPUtil.getParameter(request, "fromt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStartNo(JSPUtil.getParameter(request, "start_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setRcvDate(JSPUtil.getParameter(request, "rcv_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTot(JSPUtil.getParameter(request, "tot", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCstmsBatNo(JSPUtil.getParameter(request, "cstms_bat_no", ""));
		setRcvMsgTpId(JSPUtil.getParameter(request, "rcv_msg_tp_id", ""));
		setScacCd(JSPUtil.getParameter(request, "scac_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RcvHistListCondVO[]
	 */
	public RcvHistListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RcvHistListCondVO[]
	 */
	public RcvHistListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RcvHistListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tod = (JSPUtil.getParameter(request, prefix	+ "tod", length));
			String[] endNo = (JSPUtil.getParameter(request, prefix	+ "end_no", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] fromd = (JSPUtil.getParameter(request, prefix	+ "fromd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] fromt = (JSPUtil.getParameter(request, prefix	+ "fromt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] startNo = (JSPUtil.getParameter(request, prefix	+ "start_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rcvDate = (JSPUtil.getParameter(request, prefix	+ "rcv_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cstmsBatNo = (JSPUtil.getParameter(request, prefix	+ "cstms_bat_no", length));
			String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_id", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RcvHistListCondVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tod[i] != null)
					model.setTod(tod[i]);
				if (endNo[i] != null)
					model.setEndNo(endNo[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (fromd[i] != null)
					model.setFromd(fromd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (fromt[i] != null)
					model.setFromt(fromt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (startNo[i] != null)
					model.setStartNo(startNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rcvDate[i] != null)
					model.setRcvDate(rcvDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cstmsBatNo[i] != null)
					model.setCstmsBatNo(cstmsBatNo[i]);
				if (rcvMsgTpId[i] != null)
					model.setRcvMsgTpId(rcvMsgTpId[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRcvHistListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RcvHistListCondVO[]
	 */
	public RcvHistListCondVO[] getRcvHistListCondVOs(){
		RcvHistListCondVO[] vos = (RcvHistListCondVO[])models.toArray(new RcvHistListCondVO[models.size()]);
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
		this.tod = this.tod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNo = this.endNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromd = this.fromd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromt = this.fromt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNo = this.startNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDate = this.rcvDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsBatNo = this.cstmsBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpId = this.rcvMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
