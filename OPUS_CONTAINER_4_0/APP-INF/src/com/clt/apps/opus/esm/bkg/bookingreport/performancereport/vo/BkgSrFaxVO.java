/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgSrFaxVO.java
*@FileTitle : BkgSrFaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.12 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgSrFaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgSrFaxVO> models = new ArrayList<BkgSrFaxVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rcvRmk = null;
	/* Column Info */
	private String rcvNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String wrkTmNo = null;
	/* Column Info */
	private String srFaxRsltCd = null;
	/* Column Info */
	private String rcvOfcCd = null;
	/* Column Info */
	private String mtchUsrId = null;
	/* Column Info */
	private String imgFileIp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imgFilePathCtnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String sndrFaxNo = null;
	/* Column Info */
	private String ttlPgKnt = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String srMtchStsCd = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String imgFileNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgSrFaxVO() {}

	public BkgSrFaxVO(String ibflag, String pagerows, String srNo, String faxLogRefNo, String srKndCd, String sndrFaxNo, String rcvDt, String rcvOfcCd, String rcvNm, String rcvRmk, String imgFileIp, String imgFilePathCtnt, String imgFileNm, String ttlPgKnt, String srFaxRsltCd, String srMtchStsCd, String mtchUsrId, String wrkTmNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rcvRmk = rcvRmk;
		this.rcvNm = rcvNm;
		this.creDt = creDt;
		this.wrkTmNo = wrkTmNo;
		this.srFaxRsltCd = srFaxRsltCd;
		this.rcvOfcCd = rcvOfcCd;
		this.mtchUsrId = mtchUsrId;
		this.imgFileIp = imgFileIp;
		this.pagerows = pagerows;
		this.imgFilePathCtnt = imgFilePathCtnt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.sndrFaxNo = sndrFaxNo;
		this.ttlPgKnt = ttlPgKnt;
		this.rcvDt = rcvDt;
		this.faxLogRefNo = faxLogRefNo;
		this.updUsrId = updUsrId;
		this.srMtchStsCd = srMtchStsCd;
		this.srNo = srNo;
		this.imgFileNm = imgFileNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rcv_rmk", getRcvRmk());
		this.hashColumns.put("rcv_nm", getRcvNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("wrk_tm_no", getWrkTmNo());
		this.hashColumns.put("sr_fax_rslt_cd", getSrFaxRsltCd());
		this.hashColumns.put("rcv_ofc_cd", getRcvOfcCd());
		this.hashColumns.put("mtch_usr_id", getMtchUsrId());
		this.hashColumns.put("img_file_ip", getImgFileIp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("img_file_path_ctnt", getImgFilePathCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("sndr_fax_no", getSndrFaxNo());
		this.hashColumns.put("ttl_pg_knt", getTtlPgKnt());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sr_mtch_sts_cd", getSrMtchStsCd());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("img_file_nm", getImgFileNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rcv_rmk", "rcvRmk");
		this.hashFields.put("rcv_nm", "rcvNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("wrk_tm_no", "wrkTmNo");
		this.hashFields.put("sr_fax_rslt_cd", "srFaxRsltCd");
		this.hashFields.put("rcv_ofc_cd", "rcvOfcCd");
		this.hashFields.put("mtch_usr_id", "mtchUsrId");
		this.hashFields.put("img_file_ip", "imgFileIp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("img_file_path_ctnt", "imgFilePathCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("sndr_fax_no", "sndrFaxNo");
		this.hashFields.put("ttl_pg_knt", "ttlPgKnt");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sr_mtch_sts_cd", "srMtchStsCd");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("img_file_nm", "imgFileNm");
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
	 * @return rcvRmk
	 */
	public String getRcvRmk() {
		return this.rcvRmk;
	}
	
	/**
	 * Column Info
	 * @return rcvNm
	 */
	public String getRcvNm() {
		return this.rcvNm;
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
	 * @return wrkTmNo
	 */
	public String getWrkTmNo() {
		return this.wrkTmNo;
	}
	
	/**
	 * Column Info
	 * @return srFaxRsltCd
	 */
	public String getSrFaxRsltCd() {
		return this.srFaxRsltCd;
	}
	
	/**
	 * Column Info
	 * @return rcvOfcCd
	 */
	public String getRcvOfcCd() {
		return this.rcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mtchUsrId
	 */
	public String getMtchUsrId() {
		return this.mtchUsrId;
	}
	
	/**
	 * Column Info
	 * @return imgFileIp
	 */
	public String getImgFileIp() {
		return this.imgFileIp;
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
	 * @return imgFilePathCtnt
	 */
	public String getImgFilePathCtnt() {
		return this.imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return sndrFaxNo
	 */
	public String getSndrFaxNo() {
		return this.sndrFaxNo;
	}
	
	/**
	 * Column Info
	 * @return ttlPgKnt
	 */
	public String getTtlPgKnt() {
		return this.ttlPgKnt;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
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
	 * @return srMtchStsCd
	 */
	public String getSrMtchStsCd() {
		return this.srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return imgFileNm
	 */
	public String getImgFileNm() {
		return this.imgFileNm;
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
	 * @param rcvRmk
	 */
	public void setRcvRmk(String rcvRmk) {
		this.rcvRmk = rcvRmk;
	}
	
	/**
	 * Column Info
	 * @param rcvNm
	 */
	public void setRcvNm(String rcvNm) {
		this.rcvNm = rcvNm;
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
	 * @param wrkTmNo
	 */
	public void setWrkTmNo(String wrkTmNo) {
		this.wrkTmNo = wrkTmNo;
	}
	
	/**
	 * Column Info
	 * @param srFaxRsltCd
	 */
	public void setSrFaxRsltCd(String srFaxRsltCd) {
		this.srFaxRsltCd = srFaxRsltCd;
	}
	
	/**
	 * Column Info
	 * @param rcvOfcCd
	 */
	public void setRcvOfcCd(String rcvOfcCd) {
		this.rcvOfcCd = rcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mtchUsrId
	 */
	public void setMtchUsrId(String mtchUsrId) {
		this.mtchUsrId = mtchUsrId;
	}
	
	/**
	 * Column Info
	 * @param imgFileIp
	 */
	public void setImgFileIp(String imgFileIp) {
		this.imgFileIp = imgFileIp;
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
	 * @param imgFilePathCtnt
	 */
	public void setImgFilePathCtnt(String imgFilePathCtnt) {
		this.imgFilePathCtnt = imgFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param sndrFaxNo
	 */
	public void setSndrFaxNo(String sndrFaxNo) {
		this.sndrFaxNo = sndrFaxNo;
	}
	
	/**
	 * Column Info
	 * @param ttlPgKnt
	 */
	public void setTtlPgKnt(String ttlPgKnt) {
		this.ttlPgKnt = ttlPgKnt;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param srMtchStsCd
	 */
	public void setSrMtchStsCd(String srMtchStsCd) {
		this.srMtchStsCd = srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param imgFileNm
	 */
	public void setImgFileNm(String imgFileNm) {
		this.imgFileNm = imgFileNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRcvRmk(JSPUtil.getParameter(request, "rcv_rmk", ""));
		setRcvNm(JSPUtil.getParameter(request, "rcv_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setWrkTmNo(JSPUtil.getParameter(request, "wrk_tm_no", ""));
		setSrFaxRsltCd(JSPUtil.getParameter(request, "sr_fax_rslt_cd", ""));
		setRcvOfcCd(JSPUtil.getParameter(request, "rcv_ofc_cd", ""));
		setMtchUsrId(JSPUtil.getParameter(request, "mtch_usr_id", ""));
		setImgFileIp(JSPUtil.getParameter(request, "img_file_ip", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setImgFilePathCtnt(JSPUtil.getParameter(request, "img_file_path_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setSndrFaxNo(JSPUtil.getParameter(request, "sndr_fax_no", ""));
		setTtlPgKnt(JSPUtil.getParameter(request, "ttl_pg_knt", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, "fax_log_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSrMtchStsCd(JSPUtil.getParameter(request, "sr_mtch_sts_cd", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setImgFileNm(JSPUtil.getParameter(request, "img_file_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgSrFaxVO[]
	 */
	public BkgSrFaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgSrFaxVO[]
	 */
	public BkgSrFaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgSrFaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] rcvRmk = (JSPUtil.getParameter(request, prefix	+ "rcv_rmk".trim(), length));
			String[] rcvNm = (JSPUtil.getParameter(request, prefix	+ "rcv_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] wrkTmNo = (JSPUtil.getParameter(request, prefix	+ "wrk_tm_no".trim(), length));
			String[] srFaxRsltCd = (JSPUtil.getParameter(request, prefix	+ "sr_fax_rslt_cd".trim(), length));
			String[] rcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rcv_ofc_cd".trim(), length));
			String[] mtchUsrId = (JSPUtil.getParameter(request, prefix	+ "mtch_usr_id".trim(), length));
			String[] imgFileIp = (JSPUtil.getParameter(request, prefix	+ "img_file_ip".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] imgFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "img_file_path_ctnt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd".trim(), length));
			String[] sndrFaxNo = (JSPUtil.getParameter(request, prefix	+ "sndr_fax_no".trim(), length));
			String[] ttlPgKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_pg_knt".trim(), length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt".trim(), length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] srMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_cd".trim(), length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no".trim(), length));
			String[] imgFileNm = (JSPUtil.getParameter(request, prefix	+ "img_file_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgSrFaxVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rcvRmk[i] != null)
					model.setRcvRmk(rcvRmk[i]);
				if (rcvNm[i] != null)
					model.setRcvNm(rcvNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (wrkTmNo[i] != null)
					model.setWrkTmNo(wrkTmNo[i]);
				if (srFaxRsltCd[i] != null)
					model.setSrFaxRsltCd(srFaxRsltCd[i]);
				if (rcvOfcCd[i] != null)
					model.setRcvOfcCd(rcvOfcCd[i]);
				if (mtchUsrId[i] != null)
					model.setMtchUsrId(mtchUsrId[i]);
				if (imgFileIp[i] != null)
					model.setImgFileIp(imgFileIp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imgFilePathCtnt[i] != null)
					model.setImgFilePathCtnt(imgFilePathCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (sndrFaxNo[i] != null)
					model.setSndrFaxNo(sndrFaxNo[i]);
				if (ttlPgKnt[i] != null)
					model.setTtlPgKnt(ttlPgKnt[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (srMtchStsCd[i] != null)
					model.setSrMtchStsCd(srMtchStsCd[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (imgFileNm[i] != null)
					model.setImgFileNm(imgFileNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgSrFaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgSrFaxVO[]
	 */
	public BkgSrFaxVO[] getBkgSrFaxVOs(){
		BkgSrFaxVO[] vos = (BkgSrFaxVO[])models.toArray(new BkgSrFaxVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRmk = this.rcvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvNm = this.rcvNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkTmNo = this.wrkTmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srFaxRsltCd = this.srFaxRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvOfcCd = this.rcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUsrId = this.mtchUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileIp = this.imgFileIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFilePathCtnt = this.imgFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrFaxNo = this.sndrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPgKnt = this.ttlPgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsCd = this.srMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNm = this.imgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
