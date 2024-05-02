/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBSARateListVO.java
*@FileTitle : SearchBSARateListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.20 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaHighCubicRateSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaHighCubicRateSaveVO> models = new ArrayList<BsaHighCubicRateSaveVO>();
	
	/* Column Info */
	private String bsaFmDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String bsaSeqOrg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaToDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String maxseq = null;
	/* Column Info */
	private String header2 = null;
	/* Column Info */
	private String arrovrrate = null;
	/* Column Info */
	private String arrratetype = null;
	/* Column Info */
	private String arrwtnrate = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rdoType = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaHighCubicRateSaveVO() {}

	public BsaHighCubicRateSaveVO(
			String ibflag, String pagerows, String grp, String maxseq, String bsaSeq, 
			String bsaSeqOrg, String vvdCd, String bsaFmDt, String bsaToDt, String trdCd, 
			String rlaneCd, String dirCd, String vopCd, String cntrTpszCd,
			String header2, String arrovrrate, String arrratetype, String arrwtnrate, String updUsrId,
			String rdoType) {
		this.bsaFmDt = bsaFmDt;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.grp = grp;
		this.bsaSeqOrg = bsaSeqOrg;
		this.vvdCd = vvdCd;
		this.bsaToDt = bsaToDt;
		this.cntrTpszCd = cntrTpszCd;
		this.bsaSeq = bsaSeq;
		this.dirCd = dirCd;
		this.maxseq = maxseq;
		this.header2 = header2;
		this.arrovrrate = arrovrrate;
		this.arrratetype = arrratetype;
		this.arrwtnrate = arrwtnrate;
		this.updUsrId = updUsrId;
		this.rdoType = rdoType;
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
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("bsa_seq_org", getBsaSeqOrg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_to_dt", getBsaToDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bsa_seq", getBsaSeq());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("maxseq", getMaxseq());
		this.hashColumns.put("header2", getHeader2());
		this.hashColumns.put("arrovrrate", getArrovrrate());
		this.hashColumns.put("arrratetype", getArrratetype());
		this.hashColumns.put("arrwtnrate", getArrwtnrate());
		this.hashColumns.put("updUsrId", getUpdUsrId());
		this.hashColumns.put("cntr_tpsz_cd", getRdoType());
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
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("bsa_seq_org", "bsaSeqOrg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_to_dt", "bsaToDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bsa_seq", "bsaSeq");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("maxseq", "maxseq");
		this.hashFields.put("header2", "header2");
		this.hashFields.put("arrovrrate", "arrovrrate");
		this.hashFields.put("arrratetype", "arrratetype");
		this.hashFields.put("arrwtnrate", "arrwtnrate");
		this.hashFields.put("updUsrId", "updUsrId");
		this.hashFields.put("cntr_tpsz_cd", "rdoType");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return bsaSeqOrg
	 */
	public String getBsaSeqOrg() {
		return this.bsaSeqOrg;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return maxseq
	 */
	public String getMaxseq() {
		return this.maxseq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param bsaSeqOrg
	 */
	public void setBsaSeqOrg(String bsaSeqOrg) {
		this.bsaSeqOrg = bsaSeqOrg;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param maxseq
	 */
	public void setMaxseq(String maxseq) {
		this.maxseq = maxseq;
	}
	
	
	public String getHeader2() {
		return header2;
	}

	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	public String getArrovrrate() {
		return arrovrrate;
	}

	public void setArrovrrate(String arrovrrate) {
		this.arrovrrate = arrovrrate;
	}

	public String getArrratetype() {
		return arrratetype;
	}

	public void setArrratetype(String arrratetype) {
		this.arrratetype = arrratetype;
	}

	public String getArrwtnrate() {
		return arrwtnrate;
	}

	public void setArrwtnrate(String arrwtnrate) {
		this.arrwtnrate = arrwtnrate;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	

	public String getRdoType() {
		return rdoType;
	}

	public void setRdoType(String rdoType) {
		this.rdoType = rdoType;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBsaFmDt(JSPUtil.getParameter(request, "M_bsa_fm_dt", ""));
		setVopCd(JSPUtil.getParameter(request, "M_opr", ""));
		setTrdCd(JSPUtil.getParameter(request, "M_trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "M_rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "group", ""));
		setBsaSeqOrg(JSPUtil.getParameter(request, "M_seq_org", ""));
		setVvdCd(JSPUtil.getParameter(request, "M_vvd_cd", ""));
		setBsaToDt(JSPUtil.getParameter(request, "M_bsa_to_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setBsaSeq(JSPUtil.getParameter(request, "M_prc_seq", ""));
		setDirCd(JSPUtil.getParameter(request, "M_dir_cd", ""));
		setMaxseq(JSPUtil.getParameter(request, "maxseq", ""));
		setHeader2(JSPUtil.getParameter(request, "header2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBSARateListVO[]
	 */
	public BsaHighCubicRateSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBSARateListVO[]
	 */
	public BsaHighCubicRateSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaHighCubicRateSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		String[] arrcrr_cd =null;
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		setHeader2(JSPUtil.getParameter(request, "header2", ""));
  		setRdoType(JSPUtil.getParameter(request, "rdoType", ""));
  		
  		if (getHeader2().length()>0){ 
  			header2 = getHeader2(); 
		}
  		
  		arrcrr_cd = header2.split("[|]");		
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "group", length));
			String[] maxseq = (JSPUtil.getParameter(request, prefix	+ "maxseq", length));
			String[] bsaSeq = (JSPUtil.getParameter(request, prefix	+ "M_prc_seq", length));
			String[] bsaSeqOrg = (JSPUtil.getParameter(request, prefix	+ "M_seq_org", length));
			
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "M_vvd_cd", length));
			String[] bsaFmDt = (JSPUtil.getParameter(request, prefix	+ "M_bsa_fm_dt", length));
			String[] bsaToDt = (JSPUtil.getParameter(request, prefix	+ "M_bsa_to_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "M_opr", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "M_trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "M_rlane_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "M_dir_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "M_cntr_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaHighCubicRateSaveVO();
				String WtnRate ="";
				String OvrRate ="";
				String RateType ="";
				
				if (bsaFmDt[i] != null)					model.setBsaFmDt(bsaFmDt[i]);
				if (vopCd[i] != null)					model.setVopCd(vopCd[i]);
				if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
				if (grp[i] != null)						model.setGrp(grp[i]);
				if (bsaSeqOrg[i] != null)				model.setBsaSeqOrg(bsaSeqOrg[i]);
				if (vvdCd[i] != null)					model.setVvdCd(vvdCd[i]);
				if (bsaToDt[i] != null)					model.setBsaToDt(bsaToDt[i]);
				if (cntrTpszCd[i] != null)				model.setCntrTpszCd(cntrTpszCd[i]);
				if (bsaSeq[i] != null)					model.setBsaSeq(bsaSeq[i]);
				if (dirCd[i] != null)					model.setDirCd(dirCd[i]);
				if (maxseq[i] != null)					model.setMaxseq(maxseq[i]);				
				if (header2 != null)					model.setHeader2(header2);
				
				for (int j = 0; j < arrcrr_cd.length; j++) {
					String[] arrWtnRate =(JSPUtil.getParameter(request, "WtnRate"+ j, length));
					String[] arrOvrRate =(JSPUtil.getParameter(request, "OvrRate"+ j, length));
					String[] arrRateType =(JSPUtil.getParameter(request, "RateType"+ j, length));
					
					WtnRate 	= 	WtnRate + "|" + arrWtnRate[i];
					OvrRate 	= 	OvrRate + "|" + arrOvrRate[i];
					RateType 	= 	RateType + "|" + arrRateType[i];
					}
				if (WtnRate !=null) 					model.setArrwtnrate(WtnRate);
				if (OvrRate !=null) 					model.setArrovrrate(OvrRate);
				if (RateType !=null) 					model.setArrratetype(RateType);
				if (rdoType !=null) 					model.setRdoType(rdoType);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBSARateListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBSARateListVO[]
	 */
	public BsaHighCubicRateSaveVO[] getSearchBSARateListVOs(){
		BsaHighCubicRateSaveVO[] vos = (BsaHighCubicRateSaveVO[])models.toArray(new BsaHighCubicRateSaveVO[models.size()]);
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
		this.bsaFmDt = this.bsaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeqOrg = this.bsaSeqOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToDt = this.bsaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxseq = this.maxseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
