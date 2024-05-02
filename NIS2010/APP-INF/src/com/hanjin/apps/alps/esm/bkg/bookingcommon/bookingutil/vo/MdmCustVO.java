/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MdmCustVO.java
*@FileTitle : MdmCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.23  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

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

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String excdCrFlg = null;

    /* Column Info */
    private String rlseCtrlRsn = null;

    /* Column Info */
    private String blockFlag = null;

    /* Column Info */
    private String address = null;

    /* Column Info */
    private String noUseRsn = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String custTpCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String coChnNo = null;

    /* Column Info */
    private String arOfc = null;

    /* Column Info */
    private String frtFwrdFmcNo = null;

    /* Column Info */
    private String nmdCustFlg = null;

    /* Column Info */
    private String idaGstRgstNo = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String name = null;

    /* Column Info */
    private String rvisCntrCustTpCd = null;

    /* Column Info */
    private String srepNm = null;

    /* Column Info */
    private String bklstFlg = null;

    /* Column Info */
    private String noUseFlg = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String custEml = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MdmCustVO() {
    }

    public MdmCustVO(String ibflag, String pagerows, String blockFlag, String custTpCd, String name, String address, String noUseFlg, String deltFlg, String custCntCd, String custSeq, String frtFwrdFmcNo, String rvisCntrCustTpCd, String nmdCustFlg, String noUseRsn, String bklstFlg, String rlseCtrlRsn, String arOfc, String srepNm, String excdCrFlg, String idaGstRgstNo, String coChnNo, String phnNo, String faxNo, String custEml) {
        this.pagerows = pagerows;
        this.excdCrFlg = excdCrFlg;
        this.rlseCtrlRsn = rlseCtrlRsn;
        this.blockFlag = blockFlag;
        this.address = address;
        this.noUseRsn = noUseRsn;
        this.ibflag = ibflag;
        this.custTpCd = custTpCd;
        this.deltFlg = deltFlg;
        this.coChnNo = coChnNo;
        this.arOfc = arOfc;
        this.frtFwrdFmcNo = frtFwrdFmcNo;
        this.nmdCustFlg = nmdCustFlg;
        this.idaGstRgstNo = idaGstRgstNo;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.name = name;
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
        this.srepNm = srepNm;
        this.bklstFlg = bklstFlg;
        this.noUseFlg = noUseFlg;
        this.phnNo = phnNo;
        this.faxNo = faxNo;
        this.custEml = custEml;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("excd_cr_flg", getExcdCrFlg());
        this.hashColumns.put("rlse_ctrl_rsn", getRlseCtrlRsn());
        this.hashColumns.put("block_flag", getBlockFlag());
        this.hashColumns.put("address", getAddress());
        this.hashColumns.put("no_use_rsn", getNoUseRsn());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cust_tp_cd", getCustTpCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("co_chn_no", getCoChnNo());
        this.hashColumns.put("ar_ofc", getArOfc());
        this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
        this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("name", getName());
        this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
        this.hashColumns.put("srep_nm", getSrepNm());
        this.hashColumns.put("bklst_flg", getBklstFlg());
        this.hashColumns.put("no_use_flg", getNoUseFlg());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("cust_eml", getCustEml());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("excd_cr_flg", "excdCrFlg");
        this.hashFields.put("rlse_ctrl_rsn", "rlseCtrlRsn");
        this.hashFields.put("block_flag", "blockFlag");
        this.hashFields.put("address", "address");
        this.hashFields.put("no_use_rsn", "noUseRsn");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cust_tp_cd", "custTpCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("co_chn_no", "coChnNo");
        this.hashFields.put("ar_ofc", "arOfc");
        this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
        this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("name", "name");
        this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
        this.hashFields.put("srep_nm", "srepNm");
        this.hashFields.put("bklst_flg", "bklstFlg");
        this.hashFields.put("no_use_flg", "noUseFlg");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("cust_eml", "custEml");
        return this.hashFields;
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
	 * @return excdCrFlg
	 */
    public String getExcdCrFlg() {
        return this.excdCrFlg;
    }

    /**
	 * Column Info
	 * @return rlseCtrlRsn
	 */
    public String getRlseCtrlRsn() {
        return this.rlseCtrlRsn;
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
	 * @return address
	 */
    public String getAddress() {
        return this.address;
    }

    /**
	 * Column Info
	 * @return noUseRsn
	 */
    public String getNoUseRsn() {
        return this.noUseRsn;
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
	 * @return custTpCd
	 */
    public String getCustTpCd() {
        return this.custTpCd;
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
	 * @return coChnNo
	 */
    public String getCoChnNo() {
        return this.coChnNo;
    }

    /**
	 * Column Info
	 * @return arOfc
	 */
    public String getArOfc() {
        return this.arOfc;
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
	 * @return nmdCustFlg
	 */
    public String getNmdCustFlg() {
        return this.nmdCustFlg;
    }

    /**
	 * Column Info
	 * @return idaGstRgstNo
	 */
    public String getIdaGstRgstNo() {
        return this.idaGstRgstNo;
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
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
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
	 * @return rvisCntrCustTpCd
	 */
    public String getRvisCntrCustTpCd() {
        return this.rvisCntrCustTpCd;
    }

    /**
	 * Column Info
	 * @return srepNm
	 */
    public String getSrepNm() {
        return this.srepNm;
    }

    /**
	 * Column Info
	 * @return bklstFlg
	 */
    public String getBklstFlg() {
        return this.bklstFlg;
    }

    /**
	 * Column Info
	 * @return noUseFlg
	 */
    public String getNoUseFlg() {
        return this.noUseFlg;
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
	 * @param excdCrFlg
	 */
    public void setExcdCrFlg(String excdCrFlg) {
        this.excdCrFlg = excdCrFlg;
    }

    /**
	 * Column Info
	 * @param rlseCtrlRsn
	 */
    public void setRlseCtrlRsn(String rlseCtrlRsn) {
        this.rlseCtrlRsn = rlseCtrlRsn;
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
	 * @param address
	 */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
	 * Column Info
	 * @param noUseRsn
	 */
    public void setNoUseRsn(String noUseRsn) {
        this.noUseRsn = noUseRsn;
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
	 * @param custTpCd
	 */
    public void setCustTpCd(String custTpCd) {
        this.custTpCd = custTpCd;
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
	 * @param coChnNo
	 */
    public void setCoChnNo(String coChnNo) {
        this.coChnNo = coChnNo;
    }

    /**
	 * Column Info
	 * @param arOfc
	 */
    public void setArOfc(String arOfc) {
        this.arOfc = arOfc;
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
	 * @param nmdCustFlg
	 */
    public void setNmdCustFlg(String nmdCustFlg) {
        this.nmdCustFlg = nmdCustFlg;
    }

    /**
	 * Column Info
	 * @param idaGstRgstNo
	 */
    public void setIdaGstRgstNo(String idaGstRgstNo) {
        this.idaGstRgstNo = idaGstRgstNo;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
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
	 * @param rvisCntrCustTpCd
	 */
    public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
    }

    /**
	 * Column Info
	 * @param srepNm
	 */
    public void setSrepNm(String srepNm) {
        this.srepNm = srepNm;
    }

    /**
	 * Column Info
	 * @param bklstFlg
	 */
    public void setBklstFlg(String bklstFlg) {
        this.bklstFlg = bklstFlg;
    }

    /**
	 * Column Info
	 * @param noUseFlg
	 */
    public void setNoUseFlg(String noUseFlg) {
        this.noUseFlg = noUseFlg;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getPhnNo() {
        return this.phnNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getFaxNo() {
        return this.faxNo;
    }

    public void setCustEml(String custEml) {
        this.custEml = custEml;
    }

    public String getCustEml() {
        return this.custEml;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setExcdCrFlg(JSPUtil.getParameter(request, prefix + "excd_cr_flg", ""));
        setRlseCtrlRsn(JSPUtil.getParameter(request, prefix + "rlse_ctrl_rsn", ""));
        setBlockFlag(JSPUtil.getParameter(request, prefix + "block_flag", ""));
        setAddress(JSPUtil.getParameter(request, prefix + "address", ""));
        setNoUseRsn(JSPUtil.getParameter(request, prefix + "no_use_rsn", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCoChnNo(JSPUtil.getParameter(request, prefix + "co_chn_no", ""));
        setArOfc(JSPUtil.getParameter(request, prefix + "ar_ofc", ""));
        setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
        setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setName(JSPUtil.getParameter(request, prefix + "name", ""));
        setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
        setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
        setBklstFlg(JSPUtil.getParameter(request, prefix + "bklst_flg", ""));
        setNoUseFlg(JSPUtil.getParameter(request, prefix + "no_use_flg", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
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
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] excdCrFlg = (JSPUtil.getParameter(request, prefix + "excd_cr_flg", length));
            String[] rlseCtrlRsn = (JSPUtil.getParameter(request, prefix + "rlse_ctrl_rsn", length));
            String[] blockFlag = (JSPUtil.getParameter(request, prefix + "block_flag", length));
            String[] address = (JSPUtil.getParameter(request, prefix + "address", length));
            String[] noUseRsn = (JSPUtil.getParameter(request, prefix + "no_use_rsn", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] custTpCd = (JSPUtil.getParameter(request, prefix + "cust_tp_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] coChnNo = (JSPUtil.getParameter(request, prefix + "co_chn_no", length));
            String[] arOfc = (JSPUtil.getParameter(request, prefix + "ar_ofc", length));
            String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", length));
            String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix + "nmd_cust_flg", length));
            String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] name = (JSPUtil.getParameter(request, prefix + "name", length));
            String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", length));
            String[] srepNm = (JSPUtil.getParameter(request, prefix + "srep_nm", length));
            String[] bklstFlg = (JSPUtil.getParameter(request, prefix + "bklst_flg", length));
            String[] noUseFlg = (JSPUtil.getParameter(request, prefix + "no_use_flg", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
	    	String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
	    	String[] custEml = (JSPUtil.getParameter(request, prefix + "cust_eml", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MdmCustVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (excdCrFlg[i] != null)
                    model.setExcdCrFlg(excdCrFlg[i]);
                if (rlseCtrlRsn[i] != null)
                    model.setRlseCtrlRsn(rlseCtrlRsn[i]);
                if (blockFlag[i] != null)
                    model.setBlockFlag(blockFlag[i]);
                if (address[i] != null)
                    model.setAddress(address[i]);
                if (noUseRsn[i] != null)
                    model.setNoUseRsn(noUseRsn[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (custTpCd[i] != null)
                    model.setCustTpCd(custTpCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (coChnNo[i] != null)
                    model.setCoChnNo(coChnNo[i]);
                if (arOfc[i] != null)
                    model.setArOfc(arOfc[i]);
                if (frtFwrdFmcNo[i] != null)
                    model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
                if (nmdCustFlg[i] != null)
                    model.setNmdCustFlg(nmdCustFlg[i]);
                if (idaGstRgstNo[i] != null)
                    model.setIdaGstRgstNo(idaGstRgstNo[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (name[i] != null)
                    model.setName(name[i]);
                if (rvisCntrCustTpCd[i] != null)
                    model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
                if (srepNm[i] != null)
                    model.setSrepNm(srepNm[i]);
                if (bklstFlg[i] != null)
                    model.setBklstFlg(bklstFlg[i]);
                if (noUseFlg[i] != null)
                    model.setNoUseFlg(noUseFlg[i]);
                if (phnNo[i] != null) 
		    		model.setPhnNo(phnNo[i]);
				if (faxNo[i] != null) 
		    		model.setFaxNo(faxNo[i]);
				if (custEml[i] != null) 
		    		model.setCustEml(custEml[i]);
				/* Add a Method line, do not delete */
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
    public MdmCustVO[] getMdmCustVOs() {
        MdmCustVO[] vos = (MdmCustVO[]) models.toArray(new MdmCustVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.excdCrFlg = this.excdCrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlseCtrlRsn = this.rlseCtrlRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blockFlag = this.blockFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.address = this.address.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noUseRsn = this.noUseRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custTpCd = this.custTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coChnNo = this.coChnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arOfc = this.arOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtFwrdFmcNo = this.frtFwrdFmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmdCustFlg = this.nmdCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.name = this.name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvisCntrCustTpCd = this.rvisCntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepNm = this.srepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bklstFlg = this.bklstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noUseFlg = this.noUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEml = this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
