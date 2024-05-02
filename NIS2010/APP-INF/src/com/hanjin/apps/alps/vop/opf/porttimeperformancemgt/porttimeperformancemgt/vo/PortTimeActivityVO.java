/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimeActivityVO.java
*@FileTitle : PortTimeActivityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.10  
* 1.0 Creation
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
=========================================================*/

package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortTimeActivityVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortTimeActivityVO> models = new ArrayList<PortTimeActivityVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String portActCtnt = null;
	/* Column Info */
	private String actGenCdId = null;
	/* Column Info */
	private String portActDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrHndlKnt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portActGrpDesc = null;
	/* Column Info */
	private String wrkPerfDt = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String opStpgCtnt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String srcSvrNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortTimeActivityVO() {}

	public PortTimeActivityVO(String ibflag, String pagerows, String portActGrpDesc, String portActDesc, String wrkPerfDt, String cntrHndlKnt, String opStpgCtnt, String srcSvrNm, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String portActCtnt, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String actGenCdId) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.portActCtnt = portActCtnt;
		this.actGenCdId = actGenCdId;
		this.portActDesc = portActDesc;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.cntrHndlKnt = cntrHndlKnt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.portActGrpDesc = portActGrpDesc;
		this.wrkPerfDt = wrkPerfDt;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.opStpgCtnt = opStpgCtnt;
		this.clptIndSeq = clptIndSeq;
		this.srcSvrNm = srcSvrNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("port_act_ctnt", getPortActCtnt());
		this.hashColumns.put("act_gen_cd_id", getActGenCdId());
		this.hashColumns.put("port_act_desc", getPortActDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_hndl_knt", getCntrHndlKnt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_act_grp_desc", getPortActGrpDesc());
		this.hashColumns.put("wrk_perf_dt", getWrkPerfDt());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("op_stpg_ctnt", getOpStpgCtnt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("src_svr_nm", getSrcSvrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("port_act_ctnt", "portActCtnt");
		this.hashFields.put("act_gen_cd_id", "actGenCdId");
		this.hashFields.put("port_act_desc", "portActDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_hndl_knt", "cntrHndlKnt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_act_grp_desc", "portActGrpDesc");
		this.hashFields.put("wrk_perf_dt", "wrkPerfDt");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("op_stpg_ctnt", "opStpgCtnt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("src_svr_nm", "srcSvrNm");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return portActCtnt
	 */
	public String getPortActCtnt() {
		return this.portActCtnt;
	}
	
	/**
	 * Column Info
	 * @return actGenCdId
	 */
	public String getActGenCdId() {
		return this.actGenCdId;
	}
	
	/**
	 * Column Info
	 * @return portActDesc
	 */
	public String getPortActDesc() {
		return this.portActDesc;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHndlKnt
	 */
	public String getCntrHndlKnt() {
		return this.cntrHndlKnt;
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
	 * @return portActGrpDesc
	 */
	public String getPortActGrpDesc() {
		return this.portActGrpDesc;
	}
	
	/**
	 * Column Info
	 * @return wrkPerfDt
	 */
	public String getWrkPerfDt() {
		return this.wrkPerfDt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return opStpgCtnt
	 */
	public String getOpStpgCtnt() {
		return this.opStpgCtnt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return srcSvrNm
	 */
	public String getSrcSvrNm() {
		return this.srcSvrNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param portActCtnt
	 */
	public void setPortActCtnt(String portActCtnt) {
		this.portActCtnt = portActCtnt;
	}
	
	/**
	 * Column Info
	 * @param actGenCdId
	 */
	public void setActGenCdId(String actGenCdId) {
		this.actGenCdId = actGenCdId;
	}
	
	/**
	 * Column Info
	 * @param portActDesc
	 */
	public void setPortActDesc(String portActDesc) {
		this.portActDesc = portActDesc;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHndlKnt
	 */
	public void setCntrHndlKnt(String cntrHndlKnt) {
		this.cntrHndlKnt = cntrHndlKnt;
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
	 * @param portActGrpDesc
	 */
	public void setPortActGrpDesc(String portActGrpDesc) {
		this.portActGrpDesc = portActGrpDesc;
	}
	
	/**
	 * Column Info
	 * @param wrkPerfDt
	 */
	public void setWrkPerfDt(String wrkPerfDt) {
		this.wrkPerfDt = wrkPerfDt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param opStpgCtnt
	 */
	public void setOpStpgCtnt(String opStpgCtnt) {
		this.opStpgCtnt = opStpgCtnt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param srcSvrNm
	 */
	public void setSrcSvrNm(String srcSvrNm) {
		this.srcSvrNm = srcSvrNm;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPortActCtnt(JSPUtil.getParameter(request, prefix + "port_act_ctnt", ""));
		setActGenCdId(JSPUtil.getParameter(request, prefix + "act_gen_cd_id", ""));
		setPortActDesc(JSPUtil.getParameter(request, prefix + "port_act_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrHndlKnt(JSPUtil.getParameter(request, prefix + "cntr_hndl_knt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPortActGrpDesc(JSPUtil.getParameter(request, prefix + "port_act_grp_desc", ""));
		setWrkPerfDt(JSPUtil.getParameter(request, prefix + "wrk_perf_dt", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setOpStpgCtnt(JSPUtil.getParameter(request, prefix + "op_stpg_ctnt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setSrcSvrNm(JSPUtil.getParameter(request, prefix + "src_svr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTimeActivityVO[]
	 */
	public PortTimeActivityVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTimeActivityVO[]
	 */
	public PortTimeActivityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortTimeActivityVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] portActCtnt = (JSPUtil.getParameter(request, prefix	+ "port_act_ctnt", length));
			String[] actGenCdId = (JSPUtil.getParameter(request, prefix	+ "act_gen_cd_id", length));
			String[] portActDesc = (JSPUtil.getParameter(request, prefix	+ "port_act_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrHndlKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hndl_knt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portActGrpDesc = (JSPUtil.getParameter(request, prefix	+ "port_act_grp_desc", length));
			String[] wrkPerfDt = (JSPUtil.getParameter(request, prefix	+ "wrk_perf_dt", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] opStpgCtnt = (JSPUtil.getParameter(request, prefix	+ "op_stpg_ctnt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] srcSvrNm = (JSPUtil.getParameter(request, prefix	+ "src_svr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortTimeActivityVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (portActCtnt[i] != null)
					model.setPortActCtnt(portActCtnt[i]);
				if (actGenCdId[i] != null)
					model.setActGenCdId(actGenCdId[i]);
				if (portActDesc[i] != null)
					model.setPortActDesc(portActDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrHndlKnt[i] != null)
					model.setCntrHndlKnt(cntrHndlKnt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portActGrpDesc[i] != null)
					model.setPortActGrpDesc(portActGrpDesc[i]);
				if (wrkPerfDt[i] != null)
					model.setWrkPerfDt(wrkPerfDt[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (opStpgCtnt[i] != null)
					model.setOpStpgCtnt(opStpgCtnt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (srcSvrNm[i] != null)
					model.setSrcSvrNm(srcSvrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortTimeActivityVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortTimeActivityVO[]
	 */
	public PortTimeActivityVO[] getPortTimeActivityVOs(){
		PortTimeActivityVO[] vos = (PortTimeActivityVO[])models.toArray(new PortTimeActivityVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portActCtnt = this.portActCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGenCdId = this.actGenCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portActDesc = this.portActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHndlKnt = this.cntrHndlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portActGrpDesc = this.portActGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkPerfDt = this.wrkPerfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opStpgCtnt = this.opStpgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcSvrNm = this.srcSvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
