/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecExptVolVO.java
*@FileTitle : KrWhfDecExptVolVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.12 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecExptVolVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecExptVolVO> models = new ArrayList<KrWhfDecExptVolVO>();
	
	/* Column Info */
	private String dongBuQty = null;
	/* Column Info */
	private String otrQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hyunDaiQty = null;
	/* Column Info */
	private String dongKukQty = null;
	/* Column Info */
	private String thruTsQty = null;
	/* Column Info */
	private String daeWooQty = null;
	/* Column Info */
	private String revMtQty = null;
	/* Column Info */
	private String custTsQty = null;
	/* Column Info */
	private String sizeId = null;
	/* Column Info */
	private String hyoSungQty = null;
	/* Page Number */
	private String pagerows = null;
	
	private String mtQty = null;
	private String blkQty = null;
	private String tsTotal     = null;
	private String mtyTotal    = null;
	private String exemptTotal = null;
	private String repoMt = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecExptVolVO() {}

	public KrWhfDecExptVolVO(String ibflag, String pagerows, String sizeId, String hyoSungQty, String daeWooQty, 
			String dongBuQty, String hyunDaiQty, String dongKukQty, String thruTsQty, String custTsQty, 
			String revMtQty, String otrQty, String mtQty, String blkQty, String tsTotal, String mtyTotal, String exemptTotal, String repoMt) {
		this.dongBuQty = dongBuQty;
		this.otrQty = otrQty;
		this.ibflag = ibflag;
		this.hyunDaiQty = hyunDaiQty;
		this.dongKukQty = dongKukQty;
		this.thruTsQty = thruTsQty;
		this.daeWooQty = daeWooQty;
		this.revMtQty = revMtQty;
		this.custTsQty = custTsQty;
		this.sizeId = sizeId;
		this.hyoSungQty = hyoSungQty;
		this.pagerows = pagerows;
		this.mtQty = mtQty;
		this.blkQty = blkQty;
		this.tsTotal = tsTotal;
		this.mtyTotal = mtyTotal;
		this.exemptTotal = exemptTotal;
		this.repoMt = repoMt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dong_bu_qty", getDongBuQty());
		this.hashColumns.put("otr_qty", getOtrQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hyun_dai_qty", getHyunDaiQty());
		this.hashColumns.put("dong_kuk_qty", getDongKukQty());
		this.hashColumns.put("thru_ts_qty", getThruTsQty());
		this.hashColumns.put("dae_woo_qty", getDaeWooQty());
		this.hashColumns.put("rev_mt_qty", getRevMtQty());
		this.hashColumns.put("cust_ts_qty", getCustTsQty());
		this.hashColumns.put("size_id", getSizeId());
		this.hashColumns.put("hyo_sung_qty", getHyoSungQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mt_qty", getMtQty());
		this.hashColumns.put("blk_qty", getBlkQty());
		this.hashColumns.put("ts_total", getTsTotal());
		this.hashColumns.put("mty_total", getMtyTotal());
		this.hashColumns.put("exempt_total", getExemptTotal());
		this.hashColumns.put("repo_mt", getRepoMt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dong_bu_qty", "dongBuQty");
		this.hashFields.put("otr_qty", "otrQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hyun_dai_qty", "hyunDaiQty");
		this.hashFields.put("dong_kuk_qty", "dongKukQty");
		this.hashFields.put("thru_ts_qty", "thruTsQty");
		this.hashFields.put("dae_woo_qty", "daeWooQty");
		this.hashFields.put("rev_mt_qty", "revMtQty");
		this.hashFields.put("cust_ts_qty", "custTsQty");
		this.hashFields.put("size_id", "sizeId");
		this.hashFields.put("hyo_sung_qty", "hyoSungQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mt_qty", "mtQty");
		this.hashFields.put("blk_qty", "blkQty");
		this.hashFields.put("ts_total", "tsTotal");
		this.hashFields.put("mty_total", "mtyTotal");
		this.hashFields.put("exempt_total", "exemptTotal");
		this.hashFields.put("repo_mt", "repoMt");
		return this.hashFields;
	}
	
	public String getRepoMt() {
		return repoMt;
	}

	public void setRepoMt(String repoMt) {
		this.repoMt = repoMt;
	}

	public String getExemptTotal() {
		return exemptTotal;
	}

	public void setExemptTotal(String exemptTotal) {
		this.exemptTotal = exemptTotal;
	}

	public String getMtyTotal() {
		return mtyTotal;
	}

	public void setMtyTotal(String mtyTotal) {
		this.mtyTotal = mtyTotal;
	}

	public String getTsTotal() {
		return tsTotal;
	}

	public void setTsTotal(String tsTotal) {
		this.tsTotal = tsTotal;
	}

	public String getBlkQty() {
		return blkQty;
	}

	public void setBlkQty(String blkQty) {
		this.blkQty = blkQty;
	}

	public String getMtQty() {
		return mtQty;
	}

	public void setMtQty(String mtQty) {
		this.mtQty = mtQty;
	}

	/**
	 * Column Info
	 * @return dongBuQty
	 */
	public String getDongBuQty() {
		return this.dongBuQty;
	}
	
	/**
	 * Column Info
	 * @return otrQty
	 */
	public String getOtrQty() {
		return this.otrQty;
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
	 * @return hyunDaiQty
	 */
	public String getHyunDaiQty() {
		return this.hyunDaiQty;
	}
	
	/**
	 * Column Info
	 * @return dongKukQty
	 */
	public String getDongKukQty() {
		return this.dongKukQty;
	}
	
	/**
	 * Column Info
	 * @return thruTsQty
	 */
	public String getThruTsQty() {
		return this.thruTsQty;
	}
	
	/**
	 * Column Info
	 * @return daeWooQty
	 */
	public String getDaeWooQty() {
		return this.daeWooQty;
	}
	
	/**
	 * Column Info
	 * @return revMtQty
	 */
	public String getRevMtQty() {
		return this.revMtQty;
	}
	
	/**
	 * Column Info
	 * @return custTsQty
	 */
	public String getCustTsQty() {
		return this.custTsQty;
	}
	
	/**
	 * Column Info
	 * @return sizeId
	 */
	public String getSizeId() {
		return this.sizeId;
	}
	
	/**
	 * Column Info
	 * @return hyoSungQty
	 */
	public String getHyoSungQty() {
		return this.hyoSungQty;
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
	 * @param dongBuQty
	 */
	public void setDongBuQty(String dongBuQty) {
		this.dongBuQty = dongBuQty;
	}
	
	/**
	 * Column Info
	 * @param otrQty
	 */
	public void setOtrQty(String otrQty) {
		this.otrQty = otrQty;
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
	 * @param hyunDaiQty
	 */
	public void setHyunDaiQty(String hyunDaiQty) {
		this.hyunDaiQty = hyunDaiQty;
	}
	
	/**
	 * Column Info
	 * @param dongKukQty
	 */
	public void setDongKukQty(String dongKukQty) {
		this.dongKukQty = dongKukQty;
	}
	
	/**
	 * Column Info
	 * @param thruTsQty
	 */
	public void setThruTsQty(String thruTsQty) {
		this.thruTsQty = thruTsQty;
	}
	
	/**
	 * Column Info
	 * @param daeWooQty
	 */
	public void setDaeWooQty(String daeWooQty) {
		this.daeWooQty = daeWooQty;
	}
	
	/**
	 * Column Info
	 * @param revMtQty
	 */
	public void setRevMtQty(String revMtQty) {
		this.revMtQty = revMtQty;
	}
	
	/**
	 * Column Info
	 * @param custTsQty
	 */
	public void setCustTsQty(String custTsQty) {
		this.custTsQty = custTsQty;
	}
	
	/**
	 * Column Info
	 * @param sizeId
	 */
	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}
	
	/**
	 * Column Info
	 * @param hyoSungQty
	 */
	public void setHyoSungQty(String hyoSungQty) {
		this.hyoSungQty = hyoSungQty;
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
		setDongBuQty(JSPUtil.getParameter(request, "dong_bu_qty", ""));
		setOtrQty(JSPUtil.getParameter(request, "otr_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHyunDaiQty(JSPUtil.getParameter(request, "hyun_dai_qty", ""));
		setDongKukQty(JSPUtil.getParameter(request, "dong_kuk_qty", ""));
		setThruTsQty(JSPUtil.getParameter(request, "thru_ts_qty", ""));
		setDaeWooQty(JSPUtil.getParameter(request, "dae_woo_qty", ""));
		setRevMtQty(JSPUtil.getParameter(request, "rev_mt_qty", ""));
		setCustTsQty(JSPUtil.getParameter(request, "cust_ts_qty", ""));
		setSizeId(JSPUtil.getParameter(request, "size_id", ""));
		setHyoSungQty(JSPUtil.getParameter(request, "hyo_sung_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMtQty(JSPUtil.getParameter(request, "mt_qty", ""));
		setBlkQty(JSPUtil.getParameter(request, "blk_qty", ""));
		setTsTotal(JSPUtil.getParameter(request, "ts_total", ""));
		setMtyTotal(JSPUtil.getParameter(request, "mty_total", ""));
		setExemptTotal(JSPUtil.getParameter(request, "exempt_total", ""));
		setRepoMt(JSPUtil.getParameter(request, "repo_mt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecExptVolVO[]
	 */
	public KrWhfDecExptVolVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecExptVolVO[]
	 */
	public KrWhfDecExptVolVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecExptVolVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dongBuQty = (JSPUtil.getParameter(request, prefix	+ "dong_bu_qty", length));
			String[] otrQty = (JSPUtil.getParameter(request, prefix	+ "otr_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hyunDaiQty = (JSPUtil.getParameter(request, prefix	+ "hyun_dai_qty", length));
			String[] dongKukQty = (JSPUtil.getParameter(request, prefix	+ "dong_kuk_qty", length));
			String[] thruTsQty = (JSPUtil.getParameter(request, prefix	+ "thru_ts_qty", length));
			String[] daeWooQty = (JSPUtil.getParameter(request, prefix	+ "dae_woo_qty", length));
			String[] revMtQty = (JSPUtil.getParameter(request, prefix	+ "rev_mt_qty", length));
			String[] custTsQty = (JSPUtil.getParameter(request, prefix	+ "cust_ts_qty", length));
			String[] sizeId = (JSPUtil.getParameter(request, prefix	+ "size_id", length));
			String[] hyoSungQty = (JSPUtil.getParameter(request, prefix	+ "hyo_sung_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtQty = (JSPUtil.getParameter(request, prefix	+ "mt_qty", length));
			String[] blkQty  = (JSPUtil.getParameter(request, prefix	+ "blk_qty", length));
			String[] tsTotal  = (JSPUtil.getParameter(request, prefix	+ "ts_total", length));
			String[] mtyTotal = (JSPUtil.getParameter(request, prefix	+ "mty_total", length));
			String[] exemptTotal = (JSPUtil.getParameter(request, prefix	+ "exempt_total", length));
			String[] repoMt = (JSPUtil.getParameter(request, prefix	+ "repo_mt", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecExptVolVO();
				if (dongBuQty[i] != null)
					model.setDongBuQty(dongBuQty[i]);
				if (otrQty[i] != null)
					model.setOtrQty(otrQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hyunDaiQty[i] != null)
					model.setHyunDaiQty(hyunDaiQty[i]);
				if (dongKukQty[i] != null)
					model.setDongKukQty(dongKukQty[i]);
				if (thruTsQty[i] != null)
					model.setThruTsQty(thruTsQty[i]);
				if (daeWooQty[i] != null)
					model.setDaeWooQty(daeWooQty[i]);
				if (revMtQty[i] != null)
					model.setRevMtQty(revMtQty[i]);
				if (custTsQty[i] != null)
					model.setCustTsQty(custTsQty[i]);
				if (sizeId[i] != null)
					model.setSizeId(sizeId[i]);
				if (hyoSungQty[i] != null)
					model.setHyoSungQty(hyoSungQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtQty[i] != null)
					model.setMtQty(mtQty[i]);
				if (blkQty[i] != null)
					model.setBlkQty(blkQty[i]);
				if (tsTotal[i] != null)
					model.setTsTotal(tsTotal[i]);
				if (mtyTotal[i] != null)
					model.setMtyTotal(mtyTotal[i]);
				if (exemptTotal[i] != null)
					model.setExemptTotal(exemptTotal[i]);
				if (repoMt[i] != null)
					model.setRepoMt(repoMt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecExptVolVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecExptVolVO[]
	 */
	public KrWhfDecExptVolVO[] getKrWhfDecExptVolVOs(){
		KrWhfDecExptVolVO[] vos = (KrWhfDecExptVolVO[])models.toArray(new KrWhfDecExptVolVO[models.size()]);
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
		this.dongBuQty = this.dongBuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrQty = this.otrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hyunDaiQty = this.hyunDaiQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dongKukQty = this.dongKukQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thruTsQty = this.thruTsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daeWooQty = this.daeWooQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMtQty = this.revMtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTsQty = this.custTsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sizeId = this.sizeId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hyoSungQty = this.hyoSungQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtQty    = this.mtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkQty   = this.blkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTotal  = this.tsTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTotal = this.mtyTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exemptTotal = this.exemptTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoMt = this.repoMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
