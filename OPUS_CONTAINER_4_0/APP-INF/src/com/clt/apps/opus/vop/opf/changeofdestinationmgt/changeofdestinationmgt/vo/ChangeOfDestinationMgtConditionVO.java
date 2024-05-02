/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ChangeOfDestinationMgtConditionVO.java
 *@FileTitle : ChangeOfDestinationMgtConditionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.17
 *@LastModifier : 장석현
 *@LastVersion : 1.0
 * 2010.03.17 장석현 
 * 1.0 Creation
 * =========================================================
 * History
 * 2010.07.26 LHJ [Ticket ID: ]- COD Approval 화면변경으로 인한 검색조건 추가 및 수정
 =========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChangeOfDestinationMgtConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChangeOfDestinationMgtConditionVO> models = new ArrayList<ChangeOfDestinationMgtConditionVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String rso = null;

    /* Column Info */
    private String cnt = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String oldPod = null;

    /* Column Info */
    private String cntrCgoTpCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vvd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String tpsz = null;

    /* Column Info */
    private String codRhndPortCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String codRqstSeq = null;

    /* Column Info */
    private String newPod = null;

    /* Column Info */
    private String cod = null;

    /* Column Info */
    private String cgoCateCd = null;

    /* Column Info 2010.07.23 추가 COD Reason*/
    private String codRqstRsnCd = null;

    /* Column Info 2010.07.23 추가 Auth Result*/
    private String codStsCd = null;

    /* Column Info */
    private String vslOprCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChangeOfDestinationMgtConditionVO() {
    }

    public ChangeOfDestinationMgtConditionVO(String ibflag, String pagerows, String rso, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String cod, String bkgNo, String blNo, String vvd, String codRqstSeq, String cnt, String oldPod, String codRhndPortCd, String tpsz, String cntrCgoTpCd, String newPod, String cgoCateCd, String codRqstRsnCd, String codStsCd, String vslOprCd) {
        this.vslCd = vslCd;
        this.rso = rso;
        this.cnt = cnt;
        this.skdVoyNo = skdVoyNo;
        this.oldPod = oldPod;
        this.cntrCgoTpCd = cntrCgoTpCd;
        this.blNo = blNo;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.vvd = vvd;
        this.ibflag = ibflag;
        this.bkgNo = bkgNo;
        this.tpsz = tpsz;
        this.codRhndPortCd = codRhndPortCd;
        this.slanCd = slanCd;
        this.codRqstSeq = codRqstSeq;
        this.newPod = newPod;
        this.cod = cod;
        this.cgoCateCd = cgoCateCd;
        this.codRqstRsnCd = codRqstRsnCd;
        this.codStsCd = codStsCd;
        this.vslOprCd = vslOprCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("rso", getRso());
        this.hashColumns.put("cnt", getCnt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("old_pod", getOldPod());
        this.hashColumns.put("cntr_cgo_tp_cd", getCntrCgoTpCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("tpsz", getTpsz());
        this.hashColumns.put("cod_rhnd_port_cd", getCodRhndPortCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
        this.hashColumns.put("new_pod", getNewPod());
        this.hashColumns.put("cod", getCod());
        this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
        this.hashColumns.put("cod_rqst_rsn_cd", getCodRqstRsnCd());
        this.hashColumns.put("cod_sts_cd", getCodStsCd());
        this.hashColumns.put("vsl_opr_cd", getVslOprCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("rso", "rso");
        this.hashFields.put("cnt", "cnt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("old_pod", "oldPod");
        this.hashFields.put("cntr_cgo_tp_cd", "cntrCgoTpCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("tpsz", "tpsz");
        this.hashFields.put("cod_rhnd_port_cd", "codRhndPortCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("cod_rqst_seq", "codRqstSeq");
        this.hashFields.put("new_pod", "newPod");
        this.hashFields.put("cod", "cod");
        this.hashFields.put("cgo_cate_cd", "cgoCateCd");
        this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
        this.hashFields.put("cod_sts_cd", "codStsCd");
        this.hashFields.put("vsl_opr_cd", "vslOprCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return rso
	 */
    public String getRso() {
        return this.rso;
    }

    /**
	 * Column Info
	 * @return cnt
	 */
    public String getCnt() {
        return this.cnt;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return oldPod
	 */
    public String getOldPod() {
        return this.oldPod;
    }

    /**
	 * Column Info
	 * @return cntrCgoTpCd
	 */
    public String getCntrCgoTpCd() {
        return this.cntrCgoTpCd;
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
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return tpsz
	 */
    public String getTpsz() {
        return this.tpsz;
    }

    /**
	 * Column Info
	 * @return codRhndPortCd
	 */
    public String getCodRhndPortCd() {
        return this.codRhndPortCd;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return codRqstSeq
	 */
    public String getCodRqstSeq() {
        return this.codRqstSeq;
    }

    /**
	 * Column Info
	 * @return newPod
	 */
    public String getNewPod() {
        return this.newPod;
    }

    /**
	 * Column Info
	 * @return cod
	 */
    public String getCod() {
        return this.cod;
    }

    /**
	 * Column Info
	 * @return cgoCateCd
	 */
    public String getCgoCateCd() {
        return this.cgoCateCd;
    }

    /**
	 * Column Info
	 * @return codRqstRsnCd
	 */
    public String getCodRqstRsnCd() {
        return this.codRqstRsnCd;
    }

    /**
	 * Column Info
	 * @return codStsCd
	 */
    public String getCodStsCd() {
        return this.codStsCd;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param rso
	 */
    public void setRso(String rso) {
        this.rso = rso;
    }

    /**
	 * Column Info
	 * @param cnt
	 */
    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param oldPod
	 */
    public void setOldPod(String oldPod) {
        this.oldPod = oldPod;
    }

    /**
	 * Column Info
	 * @param cntrCgoTpCd
	 */
    public void setCntrCgoTpCd(String cntrCgoTpCd) {
        this.cntrCgoTpCd = cntrCgoTpCd;
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
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param tpsz
	 */
    public void setTpsz(String tpsz) {
        this.tpsz = tpsz;
    }

    /**
	 * Column Info
	 * @param codRhndPortCd
	 */
    public void setCodRhndPortCd(String codRhndPortCd) {
        this.codRhndPortCd = codRhndPortCd;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param codRqstSeq
	 */
    public void setCodRqstSeq(String codRqstSeq) {
        this.codRqstSeq = codRqstSeq;
    }

    /**
	 * Column Info
	 * @param newPod
	 */
    public void setNewPod(String newPod) {
        this.newPod = newPod;
    }

    /**
	 * Column Info
	 * @param cod
	 */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
	 * Column Info
	 * @param cgoCateCd
	 */
    public void setCgoCateCd(String cgoCateCd) {
        this.cgoCateCd = cgoCateCd;
    }

    /**
	 * Column Info
	 * @return codRqstRsnCd
	 */
    public void setCodRqstRsnCd(String codRqstRsnCd) {
        this.codRqstRsnCd = codRqstRsnCd;
    }

    /**
	 * Column Info
	 * @return codStsCd
	 */
    public void setCodStsCd(String codStsCd) {
        this.codStsCd = codStsCd;
    }

    public void setVslOprCd(String vslOprCd) {
        this.vslOprCd = vslOprCd;
    }

    public String getVslOprCd() {
        return this.vslOprCd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setRso(JSPUtil.getParameter(request, prefix + "rso", ""));
        setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setOldPod(JSPUtil.getParameter(request, prefix + "old_pod", ""));
        setCntrCgoTpCd(JSPUtil.getParameter(request, prefix + "cntr_cgo_tp_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
        setCodRhndPortCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
        setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
        setCod(JSPUtil.getParameter(request, prefix + "cod", ""));
        setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
        setCodRqstRsnCd(JSPUtil.getParameter(request, prefix + "cod_rqst_rsn_cd", ""));
        setCodStsCd(JSPUtil.getParameter(request, prefix + "cod_sts_cd", ""));
        setVslOprCd(JSPUtil.getParameter(request, prefix + "vsl_opr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
    public ChangeOfDestinationMgtConditionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
    public ChangeOfDestinationMgtConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChangeOfDestinationMgtConditionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] rso = (JSPUtil.getParameter(request, prefix + "rso", length));
            String[] cnt = (JSPUtil.getParameter(request, prefix + "cnt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] oldPod = (JSPUtil.getParameter(request, prefix + "old_pod", length));
            String[] cntrCgoTpCd = (JSPUtil.getParameter(request, prefix + "cntr_cgo_tp_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] tpsz = (JSPUtil.getParameter(request, prefix + "tpsz", length));
            String[] codRhndPortCd = (JSPUtil.getParameter(request, prefix + "cod_rhnd_port_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] codRqstSeq = (JSPUtil.getParameter(request, prefix + "cod_rqst_seq", length));
            String[] newPod = (JSPUtil.getParameter(request, prefix + "new_pod", length));
            String[] cod = (JSPUtil.getParameter(request, prefix + "cod", length));
            String[] cgoCateCd = (JSPUtil.getParameter(request, prefix + "cgo_cate_cd", length));
            String[] codRqstRsnCd = (JSPUtil.getParameter(request, prefix + "cod_rqst_rsn_cd", length));
            String[] codStsCd = (JSPUtil.getParameter(request, prefix + "cod_sts_cd", length));
            String[] vslOprCd = (JSPUtil.getParameter(request, prefix + "vsl_opr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChangeOfDestinationMgtConditionVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (rso[i] != null)
                    model.setRso(rso[i]);
                if (cnt[i] != null)
                    model.setCnt(cnt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (oldPod[i] != null)
                    model.setOldPod(oldPod[i]);
                if (cntrCgoTpCd[i] != null)
                    model.setCntrCgoTpCd(cntrCgoTpCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (tpsz[i] != null)
                    model.setTpsz(tpsz[i]);
                if (codRhndPortCd[i] != null)
                    model.setCodRhndPortCd(codRhndPortCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (codRqstSeq[i] != null)
                    model.setCodRqstSeq(codRqstSeq[i]);
                if (newPod[i] != null)
                    model.setNewPod(newPod[i]);
                if (cod[i] != null)
                    model.setCod(cod[i]);
                if (cgoCateCd[i] != null)
                    model.setCgoCateCd(cgoCateCd[i]);
                if (codRqstRsnCd[i] != null)
                    model.setCodRqstRsnCd(codRqstRsnCd[i]);
                if (codStsCd[i] != null)
                    model.setCodStsCd(codStsCd[i]);
                if (vslOprCd[i] != null) 
		    		model.setVslOprCd(vslOprCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChangeOfDestinationMgtConditionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
    public ChangeOfDestinationMgtConditionVO[] getChangeOfDestinationMgtConditionVOs() {
        ChangeOfDestinationMgtConditionVO[] vos = (ChangeOfDestinationMgtConditionVO[]) models.toArray(new ChangeOfDestinationMgtConditionVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rso = this.rso.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnt = this.cnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldPod = this.oldPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoTpCd = this.cntrCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tpsz = this.tpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codRhndPortCd = this.codRhndPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codRqstSeq = this.codRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newPod = this.newPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cod = this.cod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoCateCd = this.cgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codRqstRsnCd = this.codRqstRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.codStsCd = this.codStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslOprCd = this.vslOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
