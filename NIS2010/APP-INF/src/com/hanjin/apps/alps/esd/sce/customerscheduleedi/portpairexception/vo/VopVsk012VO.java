/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopVsk012VO.java
*@FileTitle : VopVsk012VO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.02.10 함대성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VopVsk012VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VopVsk012VO> models = new ArrayList<VopVsk012VO>();
	
	/* Column Info */
	private String endTm = null;
	/* Column Info */
	private String logId = null;
	/* Column Info */
	private String batId = null;
	/* Column Info */
	private String jbId = null;
	/* Column Info */
	private String stTm = null;
	/* Column Info */
	private String machine = null;
	/* Column Info */
	private String skdTpCd = null;
	/* Column Info */
	private String elapsedTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String err = null;
	/* Column Info */
	private String stdErrFile = null;
	/* Column Info */
	private String stdOutFile = null;
	/* Column Info */
	private String out = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VopVsk012VO() {}

	public VopVsk012VO(String ibflag, String pagerows, String logId, String jbId, String skdTpCd, String batId, String stTm, String endTm, String elapsedTime, String stsCd, String out, String err, String stdOutFile, String stdErrFile, String machine) {
		this.endTm = endTm;
		this.logId = logId;
		this.batId = batId;
		this.jbId = jbId;
		this.stTm = stTm;
		this.machine = machine;
		this.skdTpCd = skdTpCd;
		this.elapsedTime = elapsedTime;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.ibflag = ibflag;
		this.err = err;
		this.stdErrFile = stdErrFile;
		this.stdOutFile = stdOutFile;
		this.out = out;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("end_tm", getEndTm());
		this.hashColumns.put("log_id", getLogId());
		this.hashColumns.put("bat_id", getBatId());
		this.hashColumns.put("jb_id", getJbId());
		this.hashColumns.put("st_tm", getStTm());
		this.hashColumns.put("machine", getMachine());
		this.hashColumns.put("skd_tp_cd", getSkdTpCd());
		this.hashColumns.put("elapsed_time", getElapsedTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err", getErr());
		this.hashColumns.put("std_err_file", getStdErrFile());
		this.hashColumns.put("std_out_file", getStdOutFile());
		this.hashColumns.put("out", getOut());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("end_tm", "endTm");
		this.hashFields.put("log_id", "logId");
		this.hashFields.put("bat_id", "batId");
		this.hashFields.put("jb_id", "jbId");
		this.hashFields.put("st_tm", "stTm");
		this.hashFields.put("machine", "machine");
		this.hashFields.put("skd_tp_cd", "skdTpCd");
		this.hashFields.put("elapsed_time", "elapsedTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err", "err");
		this.hashFields.put("std_err_file", "stdErrFile");
		this.hashFields.put("std_out_file", "stdOutFile");
		this.hashFields.put("out", "out");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return endTm
	 */
	public String getEndTm() {
		return this.endTm;
	}
	
	/**
	 * Column Info
	 * @return logId
	 */
	public String getLogId() {
		return this.logId;
	}
	
	/**
	 * Column Info
	 * @return batId
	 */
	public String getBatId() {
		return this.batId;
	}
	
	/**
	 * Column Info
	 * @return jbId
	 */
	public String getJbId() {
		return this.jbId;
	}
	
	/**
	 * Column Info
	 * @return stTm
	 */
	public String getStTm() {
		return this.stTm;
	}
	
	/**
	 * Column Info
	 * @return machine
	 */
	public String getMachine() {
		return this.machine;
	}
	
	/**
	 * Column Info
	 * @return skdTpCd
	 */
	public String getSkdTpCd() {
		return this.skdTpCd;
	}
	
	/**
	 * Column Info
	 * @return elapsedTime
	 */
	public String getElapsedTime() {
		return this.elapsedTime;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return err
	 */
	public String getErr() {
		return this.err;
	}
	
	/**
	 * Column Info
	 * @return stdErrFile
	 */
	public String getStdErrFile() {
		return this.stdErrFile;
	}
	
	/**
	 * Column Info
	 * @return stdOutFile
	 */
	public String getStdOutFile() {
		return this.stdOutFile;
	}
	
	/**
	 * Column Info
	 * @return out
	 */
	public String getOut() {
		return this.out;
	}
	

	/**
	 * Column Info
	 * @param endTm
	 */
	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}
	
	/**
	 * Column Info
	 * @param logId
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	
	/**
	 * Column Info
	 * @param batId
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}
	
	/**
	 * Column Info
	 * @param jbId
	 */
	public void setJbId(String jbId) {
		this.jbId = jbId;
	}
	
	/**
	 * Column Info
	 * @param stTm
	 */
	public void setStTm(String stTm) {
		this.stTm = stTm;
	}
	
	/**
	 * Column Info
	 * @param machine
	 */
	public void setMachine(String machine) {
		this.machine = machine;
	}
	
	/**
	 * Column Info
	 * @param skdTpCd
	 */
	public void setSkdTpCd(String skdTpCd) {
		this.skdTpCd = skdTpCd;
	}
	
	/**
	 * Column Info
	 * @param elapsedTime
	 */
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param err
	 */
	public void setErr(String err) {
		this.err = err;
	}
	
	/**
	 * Column Info
	 * @param stdErrFile
	 */
	public void setStdErrFile(String stdErrFile) {
		this.stdErrFile = stdErrFile;
	}
	
	/**
	 * Column Info
	 * @param stdOutFile
	 */
	public void setStdOutFile(String stdOutFile) {
		this.stdOutFile = stdOutFile;
	}
	
	/**
	 * Column Info
	 * @param out
	 */
	public void setOut(String out) {
		this.out = out;
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
		setEndTm(JSPUtil.getParameter(request, prefix + "end_tm", ""));
		setLogId(JSPUtil.getParameter(request, prefix + "log_id", ""));
		setBatId(JSPUtil.getParameter(request, prefix + "bat_id", ""));
		setJbId(JSPUtil.getParameter(request, prefix + "jb_id", ""));
		setStTm(JSPUtil.getParameter(request, prefix + "st_tm", ""));
		setMachine(JSPUtil.getParameter(request, prefix + "machine", ""));
		setSkdTpCd(JSPUtil.getParameter(request, prefix + "skd_tp_cd", ""));
		setElapsedTime(JSPUtil.getParameter(request, prefix + "elapsed_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErr(JSPUtil.getParameter(request, prefix + "err", ""));
		setStdErrFile(JSPUtil.getParameter(request, prefix + "std_err_file", ""));
		setStdOutFile(JSPUtil.getParameter(request, prefix + "std_out_file", ""));
		setOut(JSPUtil.getParameter(request, prefix + "out", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VopVsk012VO[]
	 */
	public VopVsk012VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VopVsk012VO[]
	 */
	public VopVsk012VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VopVsk012VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] endTm = (JSPUtil.getParameter(request, prefix	+ "end_tm", length));
			String[] logId = (JSPUtil.getParameter(request, prefix	+ "log_id", length));
			String[] batId = (JSPUtil.getParameter(request, prefix	+ "bat_id", length));
			String[] jbId = (JSPUtil.getParameter(request, prefix	+ "jb_id", length));
			String[] stTm = (JSPUtil.getParameter(request, prefix	+ "st_tm", length));
			String[] machine = (JSPUtil.getParameter(request, prefix	+ "machine", length));
			String[] skdTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_tp_cd", length));
			String[] elapsedTime = (JSPUtil.getParameter(request, prefix	+ "elapsed_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] err = (JSPUtil.getParameter(request, prefix	+ "err", length));
			String[] stdErrFile = (JSPUtil.getParameter(request, prefix	+ "std_err_file", length));
			String[] stdOutFile = (JSPUtil.getParameter(request, prefix	+ "std_out_file", length));
			String[] out = (JSPUtil.getParameter(request, prefix	+ "out", length));
			
			for (int i = 0; i < length; i++) {
				model = new VopVsk012VO();
				if (endTm[i] != null)
					model.setEndTm(endTm[i]);
				if (logId[i] != null)
					model.setLogId(logId[i]);
				if (batId[i] != null)
					model.setBatId(batId[i]);
				if (jbId[i] != null)
					model.setJbId(jbId[i]);
				if (stTm[i] != null)
					model.setStTm(stTm[i]);
				if (machine[i] != null)
					model.setMachine(machine[i]);
				if (skdTpCd[i] != null)
					model.setSkdTpCd(skdTpCd[i]);
				if (elapsedTime[i] != null)
					model.setElapsedTime(elapsedTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (err[i] != null)
					model.setErr(err[i]);
				if (stdErrFile[i] != null)
					model.setStdErrFile(stdErrFile[i]);
				if (stdOutFile[i] != null)
					model.setStdOutFile(stdOutFile[i]);
				if (out[i] != null)
					model.setOut(out[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVopVsk012VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VopVsk012VO[]
	 */
	public VopVsk012VO[] getVopVsk012VOs(){
		VopVsk012VO[] vos = (VopVsk012VO[])models.toArray(new VopVsk012VO[models.size()]);
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
		this.endTm = this.endTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logId = this.logId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batId = this.batId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbId = this.jbId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stTm = this.stTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.machine = this.machine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdTpCd = this.skdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedTime = this.elapsedTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err = this.err .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stdErrFile = this.stdErrFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stdOutFile = this.stdOutFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.out = this.out .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
