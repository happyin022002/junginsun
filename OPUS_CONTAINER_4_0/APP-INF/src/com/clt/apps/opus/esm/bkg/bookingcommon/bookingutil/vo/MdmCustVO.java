/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MdmCustVO.java
*@FileTitle : MdmCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmCustVO> models = new ArrayList<MdmCustVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String noUseFlg = null;
	/* Column Info */
	private String address = null;
	/* Column Info */
	private String frtFwrdFmcNo = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String nmdCustFlg = null;
	/* Column Info */
	private String blockFlag = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cntrCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmCustVO() {}

	public MdmCustVO(String ibflag, String pagerows, String blockFlag, String custTpCd, String name, String address, String noUseFlg, String deltFlg, String custCntCd, String custSeq, String frtFwrdFmcNo, String rvisCntrCustTpCd, String nmdCustFlg, String cntrCustTpCd) {
		this.deltFlg = deltFlg;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.ibflag = ibflag;
		this.noUseFlg = noUseFlg;
		this.address = address;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.name = name;
		this.custTpCd = custTpCd;
		this.nmdCustFlg = nmdCustFlg;
		this.blockFlag = blockFlag;
		this.custCntCd = custCntCd;
		this.cntrCustTpCd = cntrCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("no_use_flg", getNoUseFlg());
		this.hashColumns.put("address", getAddress());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		this.hashColumns.put("block_flag", getBlockFlag());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("no_use_flg", "noUseFlg");
		this.hashFields.put("address", "address");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("name", "name");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		this.hashFields.put("block_flag", "blockFlag");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCustTpCd
	 */
	public String getCntrCustTpCd() {
		return this.cntrCustTpCd;
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
	 * @return noUseFlg
	 */
	public String getNoUseFlg() {
		return this.noUseFlg;
	}
	
	/**
	 * Column Info
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdFmcNo
	 */
	public String getFrtFwrdFmcNo() {
		return this.frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return nmdCustFlg
	 */
	public String getNmdCustFlg() {
		return this.nmdCustFlg;
	}
	
	/**
	 * Column Info
	 * @return blockFlag
	 */
	public String getBlockFlag() {
		return this.blockFlag;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCustTpCd
	 */
	public void setCntrCustTpCd(String cntrCustTpCd) {
		this.cntrCustTpCd = cntrCustTpCd;
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
	 * @param noUseFlg
	 */
	public void setNoUseFlg(String noUseFlg) {
		this.noUseFlg = noUseFlg;
	}
	
	/**
	 * Column Info
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdFmcNo
	 */
	public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
		this.frtFwrdFmcNo = frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param nmdCustFlg
	 */
	public void setNmdCustFlg(String nmdCustFlg) {
		this.nmdCustFlg = nmdCustFlg;
	}
	
	/**
	 * Column Info
	 * @param blockFlag
	 */
	public void setBlockFlag(String blockFlag) {
		this.blockFlag = blockFlag;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNoUseFlg(JSPUtil.getParameter(request, prefix + "no_use_flg", ""));
		setAddress(JSPUtil.getParameter(request, prefix + "address", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
		setBlockFlag(JSPUtil.getParameter(request, prefix + "block_flag", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cust_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] noUseFlg = (JSPUtil.getParameter(request, prefix	+ "no_use_flg", length));
			String[] address = (JSPUtil.getParameter(request, prefix	+ "address", length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg", length));
			String[] blockFlag = (JSPUtil.getParameter(request, prefix	+ "block_flag", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (cntrCustTpCd[i] != null)
					model.setCntrCustTpCd(cntrCustTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (noUseFlg[i] != null)
					model.setNoUseFlg(noUseFlg[i]);
				if (address[i] != null)
					model.setAddress(address[i]);
				if (frtFwrdFmcNo[i] != null)
					model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (nmdCustFlg[i] != null)
					model.setNmdCustFlg(nmdCustFlg[i]);
				if (blockFlag[i] != null)
					model.setBlockFlag(blockFlag[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmCustVO[]
	 */
	public MdmCustVO[] getMdmCustVOs(){
		MdmCustVO[] vos = (MdmCustVO[])models.toArray(new MdmCustVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCustTpCd = this.cntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUseFlg = this.noUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address = this.address .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blockFlag = this.blockFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
