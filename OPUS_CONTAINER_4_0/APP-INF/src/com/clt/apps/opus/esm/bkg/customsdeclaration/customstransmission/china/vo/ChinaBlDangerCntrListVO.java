/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaBlDangerCntrListVO.java
*@FileTitle : ChinaBlDangerCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier :
*@LastVersion : 1.1
* 2009.09.10
* 1.0 Creation
* 1.1 2014.06.17
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaBlDangerCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaBlDangerCntrListVO> models = new ArrayList<ChinaBlDangerCntrListVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String imdgPgNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String chnMfSndIndCd = null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonTelcmNo   =  null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaBlDangerCntrListVO() {}

	public ChinaBlDangerCntrListVO(String ibflag, String pagerows, String blNo, String chnMfSndIndCd, String cntrNo, String imdgClssCd, String imdgPgNo, String imdgUnNo, String imdgSubsRskLblCd, String cntcPsonNm, String cntcPsonTelcmNo) {
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.imdgPgNo = imdgPgNo;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.blNo = blNo;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.chnMfSndIndCd = chnMfSndIndCd;
		this.pagerows = pagerows;
		this.cntcPsonNm  = cntcPsonNm ;
		this.cntcPsonTelcmNo  = cntcPsonTelcmNo ;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("imdg_pg_no", getImdgPgNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("chn_mf_snd_ind_cd", getChnMfSndIndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("cntc_pson_telcm_no", getCntcPsonTelcmNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdg_pg_no", "imdgPgNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("chn_mf_snd_ind_cd", "chnMfSndIndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("cntc_pson_telcm_no", "cntcPsonTelcmNo");
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return imdgPgNo
	 */
	public String getImdgPgNo() {
		return this.imdgPgNo;
	}

	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}

	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}

	/**
	 * Column Info
	 * @return chnMfSndIndCd
	 */
	public String getChnMfSndIndCd() {
		return this.chnMfSndIndCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param imdgPgNo
	 */
	public void setImdgPgNo(String imdgPgNo) {
		this.imdgPgNo = imdgPgNo;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * @param chnMfSndIndCd
	 */
	public void setChnMfSndIndCd(String chnMfSndIndCd) {
		this.chnMfSndIndCd = chnMfSndIndCd;
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
	* @param  cntcPsonNm
	*/
	public void	setCntcPsonNm( String	cntcPsonNm ) {
		this.cntcPsonNm =	cntcPsonNm;
	}

	/**
	 * Column Info
	 * @return	cntcPsonNm
	 */
	 public	 String	getCntcPsonNm() {
		 return	this.cntcPsonNm;
	 }

 	/**
	* Column Info
	* @param  cntcPsonTelcmNo
	*/
	public void	setCntcPsonTelcmNo( String	cntcPsonTelcmNo ) {
		this.cntcPsonTelcmNo =	cntcPsonTelcmNo;
	}

	/**
	 * Column Info
	 * @return	cntcPsonTelcmNo
	 */
	 public	 String	getCntcPsonTelcmNo() {
		 return	this.cntcPsonTelcmNo;
	 }



	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setImdgPgNo(JSPUtil.getParameter(request, "imdg_pg_no", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setChnMfSndIndCd(JSPUtil.getParameter(request, "chn_mf_snd_ind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	"cntc_pson_nm", ""));
		setCntcPsonTelcmNo(JSPUtil.getParameter(request,"cntc_pson_telcm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlDangerCntrListVO[]
	 */
	public ChinaBlDangerCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaBlDangerCntrListVO[]
	 */
	public ChinaBlDangerCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaBlDangerCntrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] imdgPgNo = (JSPUtil.getParameter(request, prefix	+ "imdg_pg_no", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] chnMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "chn_mf_snd_ind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm",	length));
			String[] cntcPsonTelcmNo =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_telcm_no",	length));

			for (int i = 0; i < length; i++) {
				model = new ChinaBlDangerCntrListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (imdgPgNo[i] != null)
					model.setImdgPgNo(imdgPgNo[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (chnMfSndIndCd[i] != null)
					model.setChnMfSndIndCd(chnMfSndIndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if ( cntcPsonNm[i] !=	null)
					model.setCntcPsonNm( cntcPsonNm[i]);
				if ( cntcPsonTelcmNo[i] !=	null)
					model.setCntcPsonTelcmNo( cntcPsonTelcmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaBlDangerCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaBlDangerCntrListVO[]
	 */
	public ChinaBlDangerCntrListVO[] getChinaBlDangerCntrListVOs(){
		ChinaBlDangerCntrListVO[] vos = (ChinaBlDangerCntrListVO[])models.toArray(new ChinaBlDangerCntrListVO[models.size()]);
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
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPgNo = this.imdgPgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnMfSndIndCd = this.chnMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonTelcmNo =	this.cntcPsonTelcmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
