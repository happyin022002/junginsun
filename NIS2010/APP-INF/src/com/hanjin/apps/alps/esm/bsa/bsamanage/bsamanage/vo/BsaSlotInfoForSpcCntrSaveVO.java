/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcJoBSAVO.java
*@FileTitle : SearchSpcJoBSAVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.11.06 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaSlotInfoForSpcCntrSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaSlotInfoForSpcCntrSaveVO> models = new ArrayList<BsaSlotInfoForSpcCntrSaveVO>();
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String bsaFmDt = null;
	/* Column Info */
	private String bsaToDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String ownrVslWgt = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String jheader = null;
	/* Column Info */
	private String sheader = null;
	/* Page Number */
	private String rdoopcd = null;
	/* Page Number */
	private String rdoopjbcd = null;
	/* Page Number */
	private String rdoopjbcd2 = null;
	/* Page Number */
	private String headerCapa = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaSlotInfoForSpcCntrSaveVO() {}

	public BsaSlotInfoForSpcCntrSaveVO(
			String ibflag,  	String pagerows, 	String bsaSeq,  	String bsaFmDt, 
			String bsaToDt, 	String trdCd, 	 	String rlaneCd, 	String dirCd, 
			String vopCd, 		String vvdCd, 	 	String vslCd,		String vslSeq,
			String vslCapa, 	String bsaCapa,		String ownrVslWgt, 	String fnlHjsBsaCapa,
			String jheader,		String sheader,		String rdoopcd,		String rdoopjbcd,
			String rdoopjbcd2,	String headerCapa
			) {
		this.bsaFmDt = bsaFmDt;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.vslCapa = vslCapa;
		this.bsaCapa = bsaCapa;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.bsaToDt = bsaToDt;
		this.bsaSeq = bsaSeq;
		this.dirCd = dirCd;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.ownrVslWgt = ownrVslWgt;
		this.vslCd = vslCd;
		this.vslSeq = vslSeq;
		this.jheader = jheader;
		this.sheader = sheader;
		this.rdoopcd = rdoopcd;
		this.rdoopjbcd = rdoopjbcd;
		this.rdoopjbcd2 = rdoopjbcd2;
		this.headerCapa=headerCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bsa_fm_dt", getBsaFmDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("bsa_to_dt", getBsaToDt());
		this.hashColumns.put("bsa_seq", getBsaSeq());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("ownr_vsl_wgt", getOwnrVslWgt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bsa_fm_dt", "bsaFmDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("bsa_to_dt", "bsaToDt");
		this.hashFields.put("bsa_seq", "bsaSeq");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("ownr_vsl_wgt", "ownrVslWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bsaFmDt
	 */
	public String getBsaFmDt() {
		return this.bsaFmDt;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaToDt
	 */
	public String getBsaToDt() {
		return this.bsaToDt;
	}
	
	/**
	 * Column Info
	 * @return bsaSeq
	 */
	public String getBsaSeq() {
		return this.bsaSeq;
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
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return ownrVslWgt
	 */
	public String getOwnrVslWgt() {
		return this.ownrVslWgt;
	}
	

	/**
	 * Column Info
	 * @param bsaFmDt
	 */
	public void setBsaFmDt(String bsaFmDt) {
		this.bsaFmDt = bsaFmDt;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaToDt
	 */
	public void setBsaToDt(String bsaToDt) {
		this.bsaToDt = bsaToDt;
	}
	
	/**
	 * Column Info
	 * @param bsaSeq
	 */
	public void setBsaSeq(String bsaSeq) {
		this.bsaSeq = bsaSeq;
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
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param ownrVslWgt
	 */
	public void setOwnrVslWgt(String ownrVslWgt) {
		this.ownrVslWgt = ownrVslWgt;
	}
	
	
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getVslSeq() {
		return vslSeq;
	}

	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	
	
	public String getJheader() {
		return jheader;
	}

	public void setJheader(String jheader) {
		this.jheader = jheader;
	}

	public String getSheader() {
		return sheader;
	}

	public void setSheader(String sheader) {
		this.sheader = sheader;
	}
	
	
	
	public String getRdoopcd() {
		return rdoopcd;
	}

	public void setRdoopcd(String rdoopcd) {
		this.rdoopcd = rdoopcd;
	}

	public String getRdoopjbcd() {
		return rdoopjbcd;
	}

	public void setRdoopjbcd(String rdoopjbcd) {
		this.rdoopjbcd = rdoopjbcd;
	}

	public String getRdoopjbcd2() {
		return rdoopjbcd2;
	}

	public void setRdoopjbcd2(String rdoopjbcd2) {
		this.rdoopjbcd2 = rdoopjbcd2;
	}

	public String getHeaderCapa() {
		return headerCapa;
	}

	public void setHeaderCapa(String headerCapa) {
		this.headerCapa = headerCapa;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setJheader(JSPUtil.getParameter(request, "jHeader", ""));
		setSheader(JSPUtil.getParameter(request, "sHeader", ""));
		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
		setRdoopjbcd(JSPUtil.getParameter(request, "rdoOp_jb_cd", ""));
		setRdoopjbcd2(JSPUtil.getParameter(request, "rdoOp_jb_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcJoBSAVO[]
	 */
	public BsaSlotInfoForSpcCntrSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcJoBSAVO[]
	 */
	public BsaSlotInfoForSpcCntrSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaSlotInfoForSpcCntrSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		String[] arrheader=null;
		
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		setJheader(JSPUtil.getParameter(request, "jHeader", ""));
		setSheader(JSPUtil.getParameter(request, "sHeader", ""));
		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
		setRdoopjbcd(JSPUtil.getParameter(request, "rdoOp_jb_cd", ""));
		setRdoopjbcd2(JSPUtil.getParameter(request, "rdoOp_jb_cd2", ""));
		
		if (rdoopcd.equals("J")){
			arrheader = jheader.split("[|]");
		}else{
			arrheader = sheader.split("[|]");
		}
		
		try {
			String[] pagerows 		= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag 		= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaSeq 		= (JSPUtil.getParameter(request, prefix	+ "bsa_seq", length));
			String[] bsaFmDt 		= (JSPUtil.getParameter(request, prefix	+ "bsa_fm_dt", length));
			String[] bsaToDt 		= (JSPUtil.getParameter(request, prefix	+ "bsa_to_dt", length));
			String[] trdCd 	 		= (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd 		= (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] dirCd 			= (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] vopCd 	 		= (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslCapa 		= (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] bsaCapa 		= (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] vvdCd 			= (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vslCd 			= (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslSeq 			= (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] ownrVslWgt 	= (JSPUtil.getParameter(request, prefix	+ "ownr_vsl_wgt", length));
			String[] fnlHjsBsaCapa 	= (JSPUtil.getParameter(request, prefix	+ "SML", length));
			String[] headerCapa		= null;
			
			for (int i = 0; i < length; i++) {
				model = new BsaSlotInfoForSpcCntrSaveVO();
				String sHeaderCapa = "";
				if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
				if (bsaSeq[i] != null)					model.setBsaSeq(bsaSeq[i]);
				if (bsaFmDt[i] != null)					model.setBsaFmDt(bsaFmDt[i]);
				if (bsaToDt[i] != null)					model.setBsaToDt(bsaToDt[i]);
				if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
				if (dirCd[i] != null)					model.setDirCd(dirCd[i]);
				if (vopCd[i] != null)					model.setVopCd(vopCd[i]);
				if (vslCapa[i] != null)					model.setVslCapa(vslCapa[i]);
				if (bsaCapa[i] != null)					model.setBsaCapa(bsaCapa[i]);
				if (vvdCd[i] != null)					model.setVvdCd(vvdCd[i]);
				if (vslCd[i] != null)					model.setVslCd(vslCd[i]);
				if (vslSeq[i] != null)					model.setVslSeq(vslSeq[i]);
				if (ownrVslWgt[i] != null)				model.setOwnrVslWgt(ownrVslWgt[i]);
				if (fnlHjsBsaCapa[i] != null)			model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				
				for (int j= 0; j <arrheader.length; j++ ){
					
					headerCapa = (JSPUtil.getParameter(request, prefix	+ arrheader[j], length));
					sHeaderCapa = sHeaderCapa +headerCapa[i]+ "|";
				}
				if (headerCapa != null)				model.setHeaderCapa(sHeaderCapa);
				
				if (jheader != null)				model.setJheader(jheader);
				if (sheader != null)				model.setSheader(sheader);
				if (rdoopcd != null)				model.setRdoopcd(rdoopcd);
				if (rdoopjbcd != null)				model.setRdoopjbcd(rdoopjbcd);
				if (rdoopjbcd2 != null)				model.setRdoopjbcd2(rdoopjbcd2);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcJoBSAVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcJoBSAVO[]
	 */
	public BsaSlotInfoForSpcCntrSaveVO[] getSearchSpcJoBSAVOs(){
		BsaSlotInfoForSpcCntrSaveVO[] vos = (BsaSlotInfoForSpcCntrSaveVO[])models.toArray(new BsaSlotInfoForSpcCntrSaveVO[models.size()]);
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
		this.bsaFmDt = this.bsaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToDt = this.bsaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrVslWgt = this.ownrVslWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
