/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgXterAwkCgoVO.java
*@FileTitle : BkgXterAwkCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.29 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgXterAwkCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgXterAwkCgoVO> models = new ArrayList<BkgXterAwkCgoVO>();

	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd2 = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd1 = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String stwgRqstDesc = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgXterAwkCgoVO() {}

	public BkgXterAwkCgoVO(String ibflag, String pagerows, String awkCgoSeq, String cntrNo, String cntrTpszCd, String cmdtCd, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String grsWgt, String wgtUtCd1, String pckQty, String pckTpCd, String netWgt, String wgtUtCd2, String stwgRqstDesc) {
		this.ttlDimWdt = ttlDimWdt;
		this.netWgt = netWgt;
		this.awkCgoSeq = awkCgoSeq;
		this.ttlDimHgt = ttlDimHgt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.wgtUtCd2 = wgtUtCd2;
		this.cmdtCd = cmdtCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd1 = wgtUtCd1;
		this.pckQty = pckQty;
		this.ttlDimLen = ttlDimLen;
		this.stwgRqstDesc = stwgRqstDesc;
		this.pckTpCd = pckTpCd;
		this.grsWgt = grsWgt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd2", getWgtUtCd2());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd1", getWgtUtCd1());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("stwg_rqst_desc", getStwgRqstDesc());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd2", "wgtUtCd2");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd1", "wgtUtCd1");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("stwg_rqst_desc", "stwgRqstDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
	}

	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}

	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}

	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
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
	 * @return wgtUtCd2
	 */
	public String getWgtUtCd2() {
		return this.wgtUtCd2;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return wgtUtCd1
	 */
	public String getWgtUtCd1() {
		return this.wgtUtCd1;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}

	/**
	 * Column Info
	 * @return stwgRqstDesc
	 */
	public String getStwgRqstDesc() {
		return this.stwgRqstDesc;
	}

	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}


	/**
	 * Column Info
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
	}

	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}

	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}

	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
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
	 * @param wgtUtCd2
	 */
	public void setWgtUtCd2(String wgtUtCd2) {
		this.wgtUtCd2 = wgtUtCd2;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param wgtUtCd1
	 */
	public void setWgtUtCd1(String wgtUtCd1) {
		this.wgtUtCd1 = wgtUtCd1;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}

	/**
	 * Column Info
	 * @param stwgRqstDesc
	 */
	public void setStwgRqstDesc(String stwgRqstDesc) {
		this.stwgRqstDesc = stwgRqstDesc;
	}

	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTtlDimWdt(JSPUtil.getParameter(request, "ttl_dim_wdt", ""));
		setNetWgt(JSPUtil.getParameter(request, "net_wgt", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, "ttl_dim_hgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgtUtCd2(JSPUtil.getParameter(request, "wgt_ut_cd2", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd1(JSPUtil.getParameter(request, "wgt_ut_cd1", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setTtlDimLen(JSPUtil.getParameter(request, "ttl_dim_len", ""));
		setStwgRqstDesc(JSPUtil.getParameter(request, "stwg_rqst_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterAwkCgoVO[]
	 */
	public BkgXterAwkCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterAwkCgoVO[]
	 */
	public BkgXterAwkCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterAwkCgoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd2 = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd2", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd1 = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd1", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] stwgRqstDesc = (JSPUtil.getParameter(request, prefix	+ "stwg_rqst_desc", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));

			for (int i = 0; i < length; i++) {
				model = new BkgXterAwkCgoVO();
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd2[i] != null)
					model.setWgtUtCd2(wgtUtCd2[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd1[i] != null)
					model.setWgtUtCd1(wgtUtCd1[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (stwgRqstDesc[i] != null)
					model.setStwgRqstDesc(stwgRqstDesc[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterAwkCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterAwkCgoVO[]
	 */
	public BkgXterAwkCgoVO[] getBkgXterAwkCgoVOs(){
		BkgXterAwkCgoVO[] vos = (BkgXterAwkCgoVO[])models.toArray(new BkgXterAwkCgoVO[models.size()]);
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
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd2 = this.wgtUtCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd1 = this.wgtUtCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgRqstDesc = this.stwgRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
