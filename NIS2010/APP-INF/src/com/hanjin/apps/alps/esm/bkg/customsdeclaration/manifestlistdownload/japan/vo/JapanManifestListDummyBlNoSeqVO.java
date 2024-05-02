/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDummyBlNoSeqVO.java
*@FileTitle : JapanManifestListDummyBlNoSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.12 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListDummyBlNoSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListDummyBlNoSeqVO> models = new ArrayList<JapanManifestListDummyBlNoSeqVO>();
	
	/* Column Info */
	private String genSeq = null;
	/* Column Info */
	private String genSeqChar = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String noGenCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListDummyBlNoSeqVO() {}

	public JapanManifestListDummyBlNoSeqVO(String ibflag, String pagerows, String genSeq, String noGenCtnt, String genSeqChar) {
		this.genSeq = genSeq;
		this.genSeqChar = genSeqChar;
		this.ibflag = ibflag;
		this.noGenCtnt = noGenCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_seq", getGenSeq());
		this.hashColumns.put("gen_seq_char", getGenSeqChar());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("no_gen_ctnt", getNoGenCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_seq", "genSeq");
		this.hashFields.put("gen_seq_char", "genSeqChar");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("no_gen_ctnt", "noGenCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return genSeq
	 */
	public String getGenSeq() {
		return this.genSeq;
	}
	
	/**
	 * Column Info
	 * @return genSeqChar
	 */
	public String getGenSeqChar() {
		return this.genSeqChar;
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
	 * @return noGenCtnt
	 */
	public String getNoGenCtnt() {
		return this.noGenCtnt;
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
	 * @param genSeq
	 */
	public void setGenSeq(String genSeq) {
		this.genSeq = genSeq;
	}
	
	/**
	 * Column Info
	 * @param genSeqChar
	 */
	public void setGenSeqChar(String genSeqChar) {
		this.genSeqChar = genSeqChar;
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
	 * @param noGenCtnt
	 */
	public void setNoGenCtnt(String noGenCtnt) {
		this.noGenCtnt = noGenCtnt;
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
		setGenSeq(JSPUtil.getParameter(request, "gen_seq", ""));
		setGenSeqChar(JSPUtil.getParameter(request, "gen_seq_char", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNoGenCtnt(JSPUtil.getParameter(request, "no_gen_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListDummyBlNoSeqVO[]
	 */
	public JapanManifestListDummyBlNoSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListDummyBlNoSeqVO[]
	 */
	public JapanManifestListDummyBlNoSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListDummyBlNoSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genSeq = (JSPUtil.getParameter(request, prefix	+ "gen_seq", length));
			String[] genSeqChar = (JSPUtil.getParameter(request, prefix	+ "gen_seq_char", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] noGenCtnt = (JSPUtil.getParameter(request, prefix	+ "no_gen_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListDummyBlNoSeqVO();
				if (genSeq[i] != null)
					model.setGenSeq(genSeq[i]);
				if (genSeqChar[i] != null)
					model.setGenSeqChar(genSeqChar[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (noGenCtnt[i] != null)
					model.setNoGenCtnt(noGenCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListDummyBlNoSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListDummyBlNoSeqVO[]
	 */
	public JapanManifestListDummyBlNoSeqVO[] getJapanManifestListDummyBlNoSeqVOs(){
		JapanManifestListDummyBlNoSeqVO[] vos = (JapanManifestListDummyBlNoSeqVO[])models.toArray(new JapanManifestListDummyBlNoSeqVO[models.size()]);
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
		this.genSeq = this.genSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSeqChar = this.genSeqChar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noGenCtnt = this.noGenCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
