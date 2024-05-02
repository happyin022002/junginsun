/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorPntDchgLocVO.java
*@FileTitle : KorPntDchgLocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.25 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

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

public class KorPntDchgLocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorPntDchgLocVO> models = new ArrayList<KorPntDchgLocVO>();
	
	/* Column Info */
	private String cstmsClrLocCd = null;
	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String bondedTp = null;
	/* Column Info */
	private String mrnBlTsCd = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String bondedWh = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorPntDchgLocVO() {}

	public KorPntDchgLocVO(String ibflag, String pagerows, String mfSeqNo, String krCstmsBlTpCd, String mrnBlTsCd, String cstmsDchgLocWhCd, String cstmsClrLocCd, String bondedWh, String bondedTp) {
		this.cstmsClrLocCd = cstmsClrLocCd;
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.ibflag = ibflag;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.bondedTp = bondedTp;
		this.mrnBlTsCd = mrnBlTsCd;
		this.mfSeqNo = mfSeqNo;
		this.bondedWh = bondedWh;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("bonded_tp", getBondedTp());
		this.hashColumns.put("mrn_bl_ts_cd", getMrnBlTsCd());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("bonded_wh", getBondedWh());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("bonded_tp", "bondedTp");
		this.hashFields.put("mrn_bl_ts_cd", "mrnBlTsCd");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("bonded_wh", "bondedWh");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrLocCd
	 */
	public String getCstmsClrLocCd() {
		return this.cstmsClrLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
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
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return bondedTp
	 */
	public String getBondedTp() {
		return this.bondedTp;
	}
	
	/**
	 * Column Info
	 * @return mrnBlTsCd
	 */
	public String getMrnBlTsCd() {
		return this.mrnBlTsCd;
	}
	
	/**
	 * Column Info
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
	}
	
	/**
	 * Column Info
	 * @return bondedWh
	 */
	public String getBondedWh() {
		return this.bondedWh;
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
	 * @param cstmsClrLocCd
	 */
	public void setCstmsClrLocCd(String cstmsClrLocCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
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
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param bondedTp
	 */
	public void setBondedTp(String bondedTp) {
		this.bondedTp = bondedTp;
	}
	
	/**
	 * Column Info
	 * @param mrnBlTsCd
	 */
	public void setMrnBlTsCd(String mrnBlTsCd) {
		this.mrnBlTsCd = mrnBlTsCd;
	}
	
	/**
	 * Column Info
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
	}
	
	/**
	 * Column Info
	 * @param bondedWh
	 */
	public void setBondedWh(String bondedWh) {
		this.bondedWh = bondedWh;
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
		setCstmsClrLocCd(JSPUtil.getParameter(request, "cstms_clr_loc_cd", ""));
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, "cstms_dchg_loc_wh_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setBondedTp(JSPUtil.getParameter(request, "bonded_tp", ""));
		setMrnBlTsCd(JSPUtil.getParameter(request, "mrn_bl_ts_cd", ""));
		setMfSeqNo(JSPUtil.getParameter(request, "mf_seq_no", ""));
		setBondedWh(JSPUtil.getParameter(request, "bonded_wh", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorPntDchgLocVO[]
	 */
	public KorPntDchgLocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorPntDchgLocVO[]
	 */
	public KorPntDchgLocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorPntDchgLocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_loc_cd", length));
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] bondedTp = (JSPUtil.getParameter(request, prefix	+ "bonded_tp", length));
			String[] mrnBlTsCd = (JSPUtil.getParameter(request, prefix	+ "mrn_bl_ts_cd", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] bondedWh = (JSPUtil.getParameter(request, prefix	+ "bonded_wh", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorPntDchgLocVO();
				if (cstmsClrLocCd[i] != null)
					model.setCstmsClrLocCd(cstmsClrLocCd[i]);
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (bondedTp[i] != null)
					model.setBondedTp(bondedTp[i]);
				if (mrnBlTsCd[i] != null)
					model.setMrnBlTsCd(mrnBlTsCd[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (bondedWh[i] != null)
					model.setBondedWh(bondedWh[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorPntDchgLocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorPntDchgLocVO[]
	 */
	public KorPntDchgLocVO[] getKorPntDchgLocVOs(){
		KorPntDchgLocVO[] vos = (KorPntDchgLocVO[])models.toArray(new KorPntDchgLocVO[models.size()]);
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
		this.cstmsClrLocCd = this.cstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedTp = this.bondedTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnBlTsCd = this.mrnBlTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedWh = this.bondedWh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
