/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaTransmitHistFileDetailVO.java
*@FileTitle : UsaTransmitHistFileDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
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

public class UsaTransmitHistFileDetailVO extends TransmitHistFileDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaTransmitHistFileDetailVO> models = new ArrayList<UsaTransmitHistFileDetailVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String logCtnt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaTransmitHistFileDetailVO() {}

	public UsaTransmitHistFileDetailVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String sndDt, String hisSeq, String seqNo, String logCtnt) {
		this.ibflag = ibflag;
		this.seqNo = seqNo;
		this.logCtnt = logCtnt;
		this.cntCd = cntCd;
		this.hisSeq = hisSeq;
		this.sndDt = sndDt;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("log_ctnt", getLogCtnt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("log_ctnt", "logCtnt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return logCtnt
	 */
	public String getLogCtnt() {
		return this.logCtnt;
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
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param logCtnt
	 */
	public void setLogCtnt(String logCtnt) {
		this.logCtnt = logCtnt;
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
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setLogCtnt(JSPUtil.getParameter(request, "log_ctnt", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaTransmitHistFileDetailVO[]
	 */
	public UsaTransmitHistFileDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaTransmitHistFileDetailVO[]
	 */
	public UsaTransmitHistFileDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaTransmitHistFileDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] logCtnt = (JSPUtil.getParameter(request, prefix	+ "log_ctnt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaTransmitHistFileDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (logCtnt[i] != null)
					model.setLogCtnt(logCtnt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaTransmitHistFileDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaTransmitHistFileDetailVO[]
	 */
	public UsaTransmitHistFileDetailVO[] getUsaTransmitHistFileDetailVOs(){
		UsaTransmitHistFileDetailVO[] vos = (UsaTransmitHistFileDetailVO[])models.toArray(new UsaTransmitHistFileDetailVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logCtnt = this.logCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
