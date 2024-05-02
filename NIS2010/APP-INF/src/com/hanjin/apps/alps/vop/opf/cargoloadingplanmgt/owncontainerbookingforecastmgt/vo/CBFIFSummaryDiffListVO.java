/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CBFIFSummaryDiffListVO.java
*@FileTitle : CBFIFSummaryDiffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CBFIFSummaryDiffListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFIFSummaryDiffListVO> models = new ArrayList<CBFIFSummaryDiffListVO>();
	
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String bnFlg2 = null;
	/* Column Info */
	private String podCd2 = null;
	/* Column Info */
	private String mtyBkgCd2 = null;
	/* Column Info */
	private String mtyBkgCd = null;
	/* Column Info */
	private String awkFlg2 = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String blckStwgCd2 = null;
	/* Column Info */
	private String bnFlg = null;
	/* Column Info */
	private String dgFlg2 = null;
	/* Column Info */
	private String bbFlg2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String awkFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bbFlg = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String bkgNo2 = null;
	/* Column Info */
	private String cntrTpszCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CBFIFSummaryDiffListVO() {}

	public CBFIFSummaryDiffListVO(String ibflag, String pagerows, String seq, String cntrNo, String bkgNo, String podCd, String blckStwgCd, String cntrTpszCd, String mtyBkgCd, String dgFlg, String awkFlg, String bbFlg, String bnFlg, String cntrNo2, String bkgNo2, String podCd2, String blckStwgCd2, String cntrTpszCd2, String mtyBkgCd2, String dgFlg2, String awkFlg2, String bbFlg2, String bnFlg2) {
		this.cntrNo2 = cntrNo2;
		this.bnFlg2 = bnFlg2;
		this.podCd2 = podCd2;
		this.mtyBkgCd2 = mtyBkgCd2;
		this.mtyBkgCd = mtyBkgCd;
		this.awkFlg2 = awkFlg2;
		this.blckStwgCd = blckStwgCd;
		this.blckStwgCd2 = blckStwgCd2;
		this.bnFlg = bnFlg;
		this.dgFlg2 = dgFlg2;
		this.bbFlg2 = bbFlg2;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dgFlg = dgFlg;
		this.cntrNo = cntrNo;
		this.awkFlg = awkFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.bbFlg = bbFlg;
		this.seq = seq;
		this.bkgNo2 = bkgNo2;
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("bn_flg2", getBnFlg2());
		this.hashColumns.put("pod_cd2", getPodCd2());
		this.hashColumns.put("mty_bkg_cd2", getMtyBkgCd2());
		this.hashColumns.put("mty_bkg_cd", getMtyBkgCd());
		this.hashColumns.put("awk_flg2", getAwkFlg2());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("blck_stwg_cd2", getBlckStwgCd2());
		this.hashColumns.put("bn_flg", getBnFlg());
		this.hashColumns.put("dg_flg2", getDgFlg2());
		this.hashColumns.put("bb_flg2", getBbFlg2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("awk_flg", getAwkFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bb_flg", getBbFlg());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("bkg_no2", getBkgNo2());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("bn_flg2", "bnFlg2");
		this.hashFields.put("pod_cd2", "podCd2");
		this.hashFields.put("mty_bkg_cd2", "mtyBkgCd2");
		this.hashFields.put("mty_bkg_cd", "mtyBkgCd");
		this.hashFields.put("awk_flg2", "awkFlg2");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("blck_stwg_cd2", "blckStwgCd2");
		this.hashFields.put("bn_flg", "bnFlg");
		this.hashFields.put("dg_flg2", "dgFlg2");
		this.hashFields.put("bb_flg2", "bbFlg2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("awk_flg", "awkFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bb_flg", "bbFlg");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return bnFlg2
	 */
	public String getBnFlg2() {
		return this.bnFlg2;
	}
	
	/**
	 * Column Info
	 * @return podCd2
	 */
	public String getPodCd2() {
		return this.podCd2;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgCd2
	 */
	public String getMtyBkgCd2() {
		return this.mtyBkgCd2;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgCd
	 */
	public String getMtyBkgCd() {
		return this.mtyBkgCd;
	}
	
	/**
	 * Column Info
	 * @return awkFlg2
	 */
	public String getAwkFlg2() {
		return this.awkFlg2;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd2
	 */
	public String getBlckStwgCd2() {
		return this.blckStwgCd2;
	}
	
	/**
	 * Column Info
	 * @return bnFlg
	 */
	public String getBnFlg() {
		return this.bnFlg;
	}
	
	/**
	 * Column Info
	 * @return dgFlg2
	 */
	public String getDgFlg2() {
		return this.dgFlg2;
	}
	
	/**
	 * Column Info
	 * @return bbFlg2
	 */
	public String getBbFlg2() {
		return this.bbFlg2;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dgFlg
	 */
	public String getDgFlg() {
		return this.dgFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return awkFlg
	 */
	public String getAwkFlg() {
		return this.awkFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return bbFlg
	 */
	public String getBbFlg() {
		return this.bbFlg;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return bkgNo2
	 */
	public String getBkgNo2() {
		return this.bkgNo2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}
	

	/**
	 * Column Info
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param bnFlg2
	 */
	public void setBnFlg2(String bnFlg2) {
		this.bnFlg2 = bnFlg2;
	}
	
	/**
	 * Column Info
	 * @param podCd2
	 */
	public void setPodCd2(String podCd2) {
		this.podCd2 = podCd2;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgCd2
	 */
	public void setMtyBkgCd2(String mtyBkgCd2) {
		this.mtyBkgCd2 = mtyBkgCd2;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgCd
	 */
	public void setMtyBkgCd(String mtyBkgCd) {
		this.mtyBkgCd = mtyBkgCd;
	}
	
	/**
	 * Column Info
	 * @param awkFlg2
	 */
	public void setAwkFlg2(String awkFlg2) {
		this.awkFlg2 = awkFlg2;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd2
	 */
	public void setBlckStwgCd2(String blckStwgCd2) {
		this.blckStwgCd2 = blckStwgCd2;
	}
	
	/**
	 * Column Info
	 * @param bnFlg
	 */
	public void setBnFlg(String bnFlg) {
		this.bnFlg = bnFlg;
	}
	
	/**
	 * Column Info
	 * @param dgFlg2
	 */
	public void setDgFlg2(String dgFlg2) {
		this.dgFlg2 = dgFlg2;
	}
	
	/**
	 * Column Info
	 * @param bbFlg2
	 */
	public void setBbFlg2(String bbFlg2) {
		this.bbFlg2 = bbFlg2;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dgFlg
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param awkFlg
	 */
	public void setAwkFlg(String awkFlg) {
		this.awkFlg = awkFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param bbFlg
	 */
	public void setBbFlg(String bbFlg) {
		this.bbFlg = bbFlg;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param bkgNo2
	 */
	public void setBkgNo2(String bkgNo2) {
		this.bkgNo2 = bkgNo2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
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
		setCntrNo2(JSPUtil.getParameter(request, prefix + "cntr_no2", ""));
		setBnFlg2(JSPUtil.getParameter(request, prefix + "bn_flg2", ""));
		setPodCd2(JSPUtil.getParameter(request, prefix + "pod_cd2", ""));
		setMtyBkgCd2(JSPUtil.getParameter(request, prefix + "mty_bkg_cd2", ""));
		setMtyBkgCd(JSPUtil.getParameter(request, prefix + "mty_bkg_cd", ""));
		setAwkFlg2(JSPUtil.getParameter(request, prefix + "awk_flg2", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setBlckStwgCd2(JSPUtil.getParameter(request, prefix + "blck_stwg_cd2", ""));
		setBnFlg(JSPUtil.getParameter(request, prefix + "bn_flg", ""));
		setDgFlg2(JSPUtil.getParameter(request, prefix + "dg_flg2", ""));
		setBbFlg2(JSPUtil.getParameter(request, prefix + "bb_flg2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBbFlg(JSPUtil.getParameter(request, prefix + "bb_flg", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setBkgNo2(JSPUtil.getParameter(request, prefix + "bkg_no2", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFIFSummaryDiffListVO[]
	 */
	public CBFIFSummaryDiffListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFIFSummaryDiffListVO[]
	 */
	public CBFIFSummaryDiffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFIFSummaryDiffListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] bnFlg2 = (JSPUtil.getParameter(request, prefix	+ "bn_flg2", length));
			String[] podCd2 = (JSPUtil.getParameter(request, prefix	+ "pod_cd2", length));
			String[] mtyBkgCd2 = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd2", length));
			String[] mtyBkgCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd", length));
			String[] awkFlg2 = (JSPUtil.getParameter(request, prefix	+ "awk_flg2", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] blckStwgCd2 = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd2", length));
			String[] bnFlg = (JSPUtil.getParameter(request, prefix	+ "bn_flg", length));
			String[] dgFlg2 = (JSPUtil.getParameter(request, prefix	+ "dg_flg2", length));
			String[] bbFlg2 = (JSPUtil.getParameter(request, prefix	+ "bb_flg2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] awkFlg = (JSPUtil.getParameter(request, prefix	+ "awk_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bbFlg = (JSPUtil.getParameter(request, prefix	+ "bb_flg", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] bkgNo2 = (JSPUtil.getParameter(request, prefix	+ "bkg_no2", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFIFSummaryDiffListVO();
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (bnFlg2[i] != null)
					model.setBnFlg2(bnFlg2[i]);
				if (podCd2[i] != null)
					model.setPodCd2(podCd2[i]);
				if (mtyBkgCd2[i] != null)
					model.setMtyBkgCd2(mtyBkgCd2[i]);
				if (mtyBkgCd[i] != null)
					model.setMtyBkgCd(mtyBkgCd[i]);
				if (awkFlg2[i] != null)
					model.setAwkFlg2(awkFlg2[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (blckStwgCd2[i] != null)
					model.setBlckStwgCd2(blckStwgCd2[i]);
				if (bnFlg[i] != null)
					model.setBnFlg(bnFlg[i]);
				if (dgFlg2[i] != null)
					model.setDgFlg2(dgFlg2[i]);
				if (bbFlg2[i] != null)
					model.setBbFlg2(bbFlg2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (awkFlg[i] != null)
					model.setAwkFlg(awkFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bbFlg[i] != null)
					model.setBbFlg(bbFlg[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (bkgNo2[i] != null)
					model.setBkgNo2(bkgNo2[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFIFSummaryDiffListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFIFSummaryDiffListVO[]
	 */
	public CBFIFSummaryDiffListVO[] getCBFIFSummaryDiffListVOs(){
		CBFIFSummaryDiffListVO[] vos = (CBFIFSummaryDiffListVO[])models.toArray(new CBFIFSummaryDiffListVO[models.size()]);
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
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnFlg2 = this.bnFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd2 = this.podCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd2 = this.mtyBkgCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd = this.mtyBkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFlg2 = this.awkFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd2 = this.blckStwgCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnFlg = this.bnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg2 = this.dgFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbFlg2 = this.bbFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFlg = this.awkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbFlg = this.bbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 = this.bkgNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
