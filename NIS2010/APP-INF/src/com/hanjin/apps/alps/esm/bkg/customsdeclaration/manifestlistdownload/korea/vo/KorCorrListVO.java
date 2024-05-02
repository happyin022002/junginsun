/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCorrListVO.java
*@FileTitle : KorCorrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.18 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCorrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCorrListVO> models = new ArrayList<KorCorrListVO>();
	
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crntCtnt4 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String preCtnt1 = null;
	/* Column Info */
	private String preCtnt4 = null;
	/* Column Info */
	private String preCtnt3 = null;
	/* Column Info */
	private String preCtnt2 = null;
	/* Column Info */
	private String crntCtnt1 = null;
	/* Column Info */
	private String crntCtnt3 = null;
	/* Column Info */
	private String crntCtnt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCorrListVO() {}

	public KorCorrListVO(String ibflag, String pagerows, String smtAmdNo, String trnsSeq, String krCstmsCorrId, String corrRsn, String preCtnt1, String crntCtnt1, String preCtnt2, String crntCtnt2, String preCtnt3, String crntCtnt3, String preCtnt4, String crntCtnt4) {
		this.smtAmdNo = smtAmdNo;
		this.trnsSeq = trnsSeq;
		this.krCstmsCorrId = krCstmsCorrId;
		this.pagerows = pagerows;
		this.crntCtnt4 = crntCtnt4;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.preCtnt1 = preCtnt1;
		this.preCtnt4 = preCtnt4;
		this.preCtnt3 = preCtnt3;
		this.preCtnt2 = preCtnt2;
		this.crntCtnt1 = crntCtnt1;
		this.crntCtnt3 = crntCtnt3;
		this.crntCtnt2 = crntCtnt2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crnt_ctnt4", getCrntCtnt4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("pre_ctnt1", getPreCtnt1());
		this.hashColumns.put("pre_ctnt4", getPreCtnt4());
		this.hashColumns.put("pre_ctnt3", getPreCtnt3());
		this.hashColumns.put("pre_ctnt2", getPreCtnt2());
		this.hashColumns.put("crnt_ctnt1", getCrntCtnt1());
		this.hashColumns.put("crnt_ctnt3", getCrntCtnt3());
		this.hashColumns.put("crnt_ctnt2", getCrntCtnt2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crnt_ctnt4", "crntCtnt4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("pre_ctnt1", "preCtnt1");
		this.hashFields.put("pre_ctnt4", "preCtnt4");
		this.hashFields.put("pre_ctnt3", "preCtnt3");
		this.hashFields.put("pre_ctnt2", "preCtnt2");
		this.hashFields.put("crnt_ctnt1", "crntCtnt1");
		this.hashFields.put("crnt_ctnt3", "crntCtnt3");
		this.hashFields.put("crnt_ctnt2", "crntCtnt2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return krCstmsCorrId
	 */
	public String getKrCstmsCorrId() {
		return this.krCstmsCorrId;
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
	 * @return crntCtnt4
	 */
	public String getCrntCtnt4() {
		return this.crntCtnt4;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}
	
	/**
	 * Column Info
	 * @return preCtnt1
	 */
	public String getPreCtnt1() {
		return this.preCtnt1;
	}
	
	/**
	 * Column Info
	 * @return preCtnt4
	 */
	public String getPreCtnt4() {
		return this.preCtnt4;
	}
	
	/**
	 * Column Info
	 * @return preCtnt3
	 */
	public String getPreCtnt3() {
		return this.preCtnt3;
	}
	
	/**
	 * Column Info
	 * @return preCtnt2
	 */
	public String getPreCtnt2() {
		return this.preCtnt2;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt1
	 */
	public String getCrntCtnt1() {
		return this.crntCtnt1;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt3
	 */
	public String getCrntCtnt3() {
		return this.crntCtnt3;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt2
	 */
	public String getCrntCtnt2() {
		return this.crntCtnt2;
	}
	

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param krCstmsCorrId
	 */
	public void setKrCstmsCorrId(String krCstmsCorrId) {
		this.krCstmsCorrId = krCstmsCorrId;
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
	 * @param crntCtnt4
	 */
	public void setCrntCtnt4(String crntCtnt4) {
		this.crntCtnt4 = crntCtnt4;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}
	
	/**
	 * Column Info
	 * @param preCtnt1
	 */
	public void setPreCtnt1(String preCtnt1) {
		this.preCtnt1 = preCtnt1;
	}
	
	/**
	 * Column Info
	 * @param preCtnt4
	 */
	public void setPreCtnt4(String preCtnt4) {
		this.preCtnt4 = preCtnt4;
	}
	
	/**
	 * Column Info
	 * @param preCtnt3
	 */
	public void setPreCtnt3(String preCtnt3) {
		this.preCtnt3 = preCtnt3;
	}
	
	/**
	 * Column Info
	 * @param preCtnt2
	 */
	public void setPreCtnt2(String preCtnt2) {
		this.preCtnt2 = preCtnt2;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt1
	 */
	public void setCrntCtnt1(String crntCtnt1) {
		this.crntCtnt1 = crntCtnt1;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt3
	 */
	public void setCrntCtnt3(String crntCtnt3) {
		this.crntCtnt3 = crntCtnt3;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt2
	 */
	public void setCrntCtnt2(String crntCtnt2) {
		this.crntCtnt2 = crntCtnt2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, "kr_cstms_corr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrntCtnt4(JSPUtil.getParameter(request, "crnt_ctnt4", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, "corr_rsn", ""));
		setPreCtnt1(JSPUtil.getParameter(request, "pre_ctnt1", ""));
		setPreCtnt4(JSPUtil.getParameter(request, "pre_ctnt4", ""));
		setPreCtnt3(JSPUtil.getParameter(request, "pre_ctnt3", ""));
		setPreCtnt2(JSPUtil.getParameter(request, "pre_ctnt2", ""));
		setCrntCtnt1(JSPUtil.getParameter(request, "crnt_ctnt1", ""));
		setCrntCtnt3(JSPUtil.getParameter(request, "crnt_ctnt3", ""));
		setCrntCtnt2(JSPUtil.getParameter(request, "crnt_ctnt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCorrListVO[]
	 */
	public KorCorrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCorrListVO[]
	 */
	public KorCorrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCorrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crntCtnt4 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] preCtnt1 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt1", length));
			String[] preCtnt4 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt4", length));
			String[] preCtnt3 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt3", length));
			String[] preCtnt2 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt2", length));
			String[] crntCtnt1 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt1", length));
			String[] crntCtnt3 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt3", length));
			String[] crntCtnt2 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt2", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCorrListVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crntCtnt4[i] != null)
					model.setCrntCtnt4(crntCtnt4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (preCtnt1[i] != null)
					model.setPreCtnt1(preCtnt1[i]);
				if (preCtnt4[i] != null)
					model.setPreCtnt4(preCtnt4[i]);
				if (preCtnt3[i] != null)
					model.setPreCtnt3(preCtnt3[i]);
				if (preCtnt2[i] != null)
					model.setPreCtnt2(preCtnt2[i]);
				if (crntCtnt1[i] != null)
					model.setCrntCtnt1(crntCtnt1[i]);
				if (crntCtnt3[i] != null)
					model.setCrntCtnt3(crntCtnt3[i]);
				if (crntCtnt2[i] != null)
					model.setCrntCtnt2(crntCtnt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCorrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCorrListVO[]
	 */
	public KorCorrListVO[] getKorCorrListVOs(){
		KorCorrListVO[] vos = (KorCorrListVO[])models.toArray(new KorCorrListVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt4 = this.crntCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt1 = this.preCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt4 = this.preCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt3 = this.preCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt2 = this.preCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt1 = this.crntCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt3 = this.crntCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt2 = this.crntCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
