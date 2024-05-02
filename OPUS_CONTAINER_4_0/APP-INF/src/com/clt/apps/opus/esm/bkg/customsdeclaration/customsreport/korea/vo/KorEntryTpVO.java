/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorEntryTpVO.java
*@FileTitle : KorEntryTpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.09 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.EntryTpVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see EntryTpVO
 */

public class KorEntryTpVO extends EntryTpVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorEntryTpVO> models = new ArrayList<KorEntryTpVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String entrNm = null;
	/* Column Info */
	private String cstmsEntrCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorEntryTpVO() {}

	public KorEntryTpVO(String ibflag, String pagerows, String cntCd, String cstmsEntrCd, String entrNm) {
		this.ibflag = ibflag;
		this.entrNm = entrNm;
		this.cstmsEntrCd = cstmsEntrCd;
		this.cntCd = cntCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("entr_nm", getEntrNm());
		this.hashColumns.put("cstms_entr_cd", getCstmsEntrCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("entr_nm", "entrNm");
		this.hashFields.put("cstms_entr_cd", "cstmsEntrCd");
		this.hashFields.put("cnt_cd", "cntCd");
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
	 * @return entrNm
	 */
	public String getEntrNm() {
		return this.entrNm;
	}

	/**
	 * Column Info
	 * @return cstmsEntrCd
	 */
	public String getCstmsEntrCd() {
		return this.cstmsEntrCd;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @param entrNm
	 */
	public void setEntrNm(String entrNm) {
		this.entrNm = entrNm;
	}

	/**
	 * Column Info
	 * @param cstmsEntrCd
	 */
	public void setCstmsEntrCd(String cstmsEntrCd) {
		this.cstmsEntrCd = cstmsEntrCd;
	}

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
		setEntrNm(JSPUtil.getParameter(request, "entr_nm", ""));
		setCstmsEntrCd(JSPUtil.getParameter(request, "cstms_entr_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorEntryTpVO[]
	 */
	public KorEntryTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorEntryTpVO[]
	 */
	public KorEntryTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorEntryTpVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] entrNm = (JSPUtil.getParameter(request, prefix	+ "entr_nm", length));
			String[] cstmsEntrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_entr_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorEntryTpVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (entrNm[i] != null)
					model.setEntrNm(entrNm[i]);
				if (cstmsEntrCd[i] != null)
					model.setCstmsEntrCd(cstmsEntrCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorEntryTpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorEntryTpVO[]
	 */
	public KorEntryTpVO[] getKorEntryTpVOs(){
		KorEntryTpVO[] vos = (KorEntryTpVO[])models.toArray(new KorEntryTpVO[models.size()]);
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
		this.entrNm = this.entrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsEntrCd = this.cstmsEntrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
