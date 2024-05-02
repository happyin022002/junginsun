/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrConversionAndOptionVO.java
*@FileTitle : CntrConversionAndOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class CntrConversionAndOptionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrConversionAndOptionVO> models = new ArrayList<CntrConversionAndOptionVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pptCd = null;

    /* Column Info */
    private String lineSeq = null;

    /* Column Info */
    private String srcTpsz = null;

    /* Column Info */
    private String tgtNormalTpsz = null;

    /* Column Info */
    private String tgtRadTpsz = null;

    /* Column Info */
    private String tgtEmptyTpsz = null;

    /* Column Info */
    private String lane = null;

    /* Column Info */
    private String teuCnt = null;

    /* Column Info */
    private String orYn = null;

    /* Column Info */
    private String olYn = null;

    /* Column Info */
    private String ohYn = null;

    /* Column Info */
    private String voidCnt = null;

    /* Column Info */
    private String optionA = null;

    /* Column Info */
    private String optionB = null;

    /* Column Info */
    private String delFlg = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String dftTpszGroup = null;

    /* Column Info */
    private String dftTpsz = null;

    /* Column Info */
    private String dftTeuCnt = null;

    /* Column Info */
    private String dftRfPlugFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CntrConversionAndOptionVO() {
    }

    public CntrConversionAndOptionVO(String ibflag, String pagerows, String pptCd, String lineSeq, String srcTpsz, String tgtNormalTpsz, String tgtRadTpsz, String tgtEmptyTpsz, String lane, String teuCnt, String orYn, String olYn, String ohYn, String voidCnt, String optionA, String optionB, String delFlg, String slanCd, String creUsrId, String dftTpszGroup, String dftTpsz, String dftTeuCnt, String dftRfPlugFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.pptCd = pptCd;
        this.lineSeq = lineSeq;
        this.srcTpsz = srcTpsz;
        this.tgtNormalTpsz = tgtNormalTpsz;
        this.tgtRadTpsz = tgtRadTpsz;
        this.tgtEmptyTpsz = tgtEmptyTpsz;
        this.lane = lane;
        this.teuCnt = teuCnt;
        this.orYn = orYn;
        this.olYn = olYn;
        this.ohYn = ohYn;
        this.voidCnt = voidCnt;
        this.optionA = optionA;
        this.optionB = optionB;
        this.delFlg = delFlg;
        this.slanCd = slanCd;
        this.creUsrId = creUsrId;
        this.dftTpszGroup = dftTpszGroup;
        this.dftTpsz = dftTpsz;
        this.dftTeuCnt = dftTeuCnt;
        this.dftRfPlugFlg = dftRfPlugFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ppt_cd", getPptCd());
        this.hashColumns.put("line_seq", getLineSeq());
        this.hashColumns.put("src_tpsz", getSrcTpsz());
        this.hashColumns.put("tgt_normal_tpsz", getTgtNormalTpsz());
        this.hashColumns.put("tgt_rad_tpsz", getTgtRadTpsz());
        this.hashColumns.put("tgt_empty_tpsz", getTgtEmptyTpsz());
        this.hashColumns.put("lane", getLane());
        this.hashColumns.put("teu_cnt", getTeuCnt());
        this.hashColumns.put("or_yn", getOrYn());
        this.hashColumns.put("ol_yn", getOlYn());
        this.hashColumns.put("oh_yn", getOhYn());
        this.hashColumns.put("void_cnt", getVoidCnt());
        this.hashColumns.put("option_a", getOptionA());
        this.hashColumns.put("option_b", getOptionB());
        this.hashColumns.put("del_flg", getDelFlg());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("dft_tpsz_group", getDftTpszGroup());
        this.hashColumns.put("dft_tpsz", getDftTpsz());
        this.hashColumns.put("dft_teu_cnt", getDftTeuCnt());
        this.hashColumns.put("dft_rf_plug_flg", getDftRfPlugFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ppt_cd", "pptCd");
        this.hashFields.put("line_seq", "lineSeq");
        this.hashFields.put("src_tpsz", "srcTpsz");
        this.hashFields.put("tgt_normal_tpsz", "tgtNormalTpsz");
        this.hashFields.put("tgt_rad_tpsz", "tgtRadTpsz");
        this.hashFields.put("tgt_empty_tpsz", "tgtEmptyTpsz");
        this.hashFields.put("lane", "lane");
        this.hashFields.put("teu_cnt", "teuCnt");
        this.hashFields.put("or_yn", "orYn");
        this.hashFields.put("ol_yn", "olYn");
        this.hashFields.put("oh_yn", "ohYn");
        this.hashFields.put("void_cnt", "voidCnt");
        this.hashFields.put("option_a", "optionA");
        this.hashFields.put("option_b", "optionB");
        this.hashFields.put("del_flg", "delFlg");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("dft_tpsz_group", "dftTpszGroup");
        this.hashFields.put("dft_tpsz", "dftTpsz");
        this.hashFields.put("dft_teu_cnt", "dftTeuCnt");
        this.hashFields.put("dft_rf_plug_flg", "dftRfPlugFlg");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String pptCd
	 */
    public void setPptCd(String pptCd) {
        this.pptCd = pptCd;
    }

    /**
	 * 
	 * @return String pptCd
	 */
    public String getPptCd() {
        return this.pptCd;
    }

    /**
	 *
	 * @param String lineSeq
	 */
    public void setLineSeq(String lineSeq) {
        this.lineSeq = lineSeq;
    }

    /**
	 * 
	 * @return String lineSeq
	 */
    public String getLineSeq() {
        return this.lineSeq;
    }

    /**
	 *
	 * @param String srcTpsz
	 */
    public void setSrcTpsz(String srcTpsz) {
        this.srcTpsz = srcTpsz;
    }

    /**
	 * 
	 * @return String srcTpsz
	 */
    public String getSrcTpsz() {
        return this.srcTpsz;
    }

    /**
	 *
	 * @param String tgtNormalTpsz
	 */
    public void setTgtNormalTpsz(String tgtNormalTpsz) {
        this.tgtNormalTpsz = tgtNormalTpsz;
    }

    /**
	 * 
	 * @return String tgtNormalTpsz
	 */
    public String getTgtNormalTpsz() {
        return this.tgtNormalTpsz;
    }

    /**
	 *
	 * @param String tgtRadTpsz
	 */
    public void setTgtRadTpsz(String tgtRadTpsz) {
        this.tgtRadTpsz = tgtRadTpsz;
    }

    /**
	 * 
	 * @return String tgtRadTpsz
	 */
    public String getTgtRadTpsz() {
        return this.tgtRadTpsz;
    }

    /**
	 *
	 * @param String tgtEmptyTpsz
	 */
    public void setTgtEmptyTpsz(String tgtEmptyTpsz) {
        this.tgtEmptyTpsz = tgtEmptyTpsz;
    }

    /**
	 * 
	 * @return String tgtEmptyTpsz
	 */
    public String getTgtEmptyTpsz() {
        return this.tgtEmptyTpsz;
    }

    /**
	 *
	 * @param String lane
	 */
    public void setLane(String lane) {
        this.lane = lane;
    }

    /**
	 * 
	 * @return String lane
	 */
    public String getLane() {
        return this.lane;
    }

    /**
	 *
	 * @param String teuCnt
	 */
    public void setTeuCnt(String teuCnt) {
        this.teuCnt = teuCnt;
    }

    /**
	 * 
	 * @return String teuCnt
	 */
    public String getTeuCnt() {
        return this.teuCnt;
    }

    /**
	 *
	 * @param String orYn
	 */
    public void setOrYn(String orYn) {
        this.orYn = orYn;
    }

    /**
	 * 
	 * @return String orYn
	 */
    public String getOrYn() {
        return this.orYn;
    }

    /**
	 *
	 * @param String olYn
	 */
    public void setOlYn(String olYn) {
        this.olYn = olYn;
    }

    /**
	 * 
	 * @return String olYn
	 */
    public String getOlYn() {
        return this.olYn;
    }

    /**
	 *
	 * @param String ohYn
	 */
    public void setOhYn(String ohYn) {
        this.ohYn = ohYn;
    }

    /**
	 * 
	 * @return String ohYn
	 */
    public String getOhYn() {
        return this.ohYn;
    }

    /**
	 *
	 * @param String voidCnt
	 */
    public void setVoidCnt(String voidCnt) {
        this.voidCnt = voidCnt;
    }

    /**
	 * 
	 * @return String voidCnt
	 */
    public String getVoidCnt() {
        return this.voidCnt;
    }

    /**
	 *
	 * @param String optionA
	 */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
	 * 
	 * @return String optionA
	 */
    public String getOptionA() {
        return this.optionA;
    }

    /**
	 *
	 * @param String optionB
	 */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
	 * 
	 * @return String optionB
	 */
    public String getOptionB() {
        return this.optionB;
    }

    /**
	 *
	 * @param String delFlg
	 */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    /**
	 * 
	 * @return String delFlg
	 */
    public String getDelFlg() {
        return this.delFlg;
    }

    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    public String getSlanCd() {
        return this.slanCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setDftTpszGroup(String dftTpszGroup) {
        this.dftTpszGroup = dftTpszGroup;
    }

    public String getDftTpszGroup() {
        return this.dftTpszGroup;
    }

    public void setDftTpsz(String dftTpsz) {
        this.dftTpsz = dftTpsz;
    }

    public String getDftTpsz() {
        return this.dftTpsz;
    }

    public void setDftTeuCnt(String dftTeuCnt) {
        this.dftTeuCnt = dftTeuCnt;
    }

    public String getDftTeuCnt() {
        return this.dftTeuCnt;
    }

    public void setDftRfPlugFlg(String dftRfPlugFlg) {
        this.dftRfPlugFlg = dftRfPlugFlg;
    }

    public String getDftRfPlugFlg() {
        return this.dftRfPlugFlg;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPptCd(JSPUtil.getParameter(request, prefix + "ppt_cd", ""));
        setLineSeq(JSPUtil.getParameter(request, prefix + "line_seq", ""));
        setSrcTpsz(JSPUtil.getParameter(request, prefix + "src_tpsz", ""));
        setTgtNormalTpsz(JSPUtil.getParameter(request, prefix + "tgt_normal_tpsz", ""));
        setTgtRadTpsz(JSPUtil.getParameter(request, prefix + "tgt_rad_tpsz", ""));
        setTgtEmptyTpsz(JSPUtil.getParameter(request, prefix + "tgt_empty_tpsz", ""));
        setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
        setTeuCnt(JSPUtil.getParameter(request, prefix + "teu_cnt", ""));
        setOrYn(JSPUtil.getParameter(request, prefix + "or_yn", ""));
        setOlYn(JSPUtil.getParameter(request, prefix + "ol_yn", ""));
        setOhYn(JSPUtil.getParameter(request, prefix + "oh_yn", ""));
        setVoidCnt(JSPUtil.getParameter(request, prefix + "void_cnt", ""));
        setOptionA(JSPUtil.getParameter(request, prefix + "option_a", ""));
        setOptionB(JSPUtil.getParameter(request, prefix + "option_b", ""));
        setDelFlg(JSPUtil.getParameter(request, prefix + "del_flg", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setDftTpszGroup(JSPUtil.getParameter(request, prefix + "dft_tpsz_group", ""));
        setDftTpsz(JSPUtil.getParameter(request, prefix + "dft_tpsz", ""));
        setDftTeuCnt(JSPUtil.getParameter(request, prefix + "dft_teu_cnt", ""));
        setDftRfPlugFlg(JSPUtil.getParameter(request, prefix + "dft_rf_plug_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrConversionAndOptionVO[]
	 */
    public CntrConversionAndOptionVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrConversionAndOptionVO[]
	 */
    public CntrConversionAndOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrConversionAndOptionVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pptCd = (JSPUtil.getParameter(request, prefix + "ppt_cd", length));
            String[] lineSeq = (JSPUtil.getParameter(request, prefix + "line_seq", length));
            String[] srcTpsz = (JSPUtil.getParameter(request, prefix + "src_tpsz", length));
            String[] tgtNormalTpsz = (JSPUtil.getParameter(request, prefix + "tgt_normal_tpsz", length));
            String[] tgtRadTpsz = (JSPUtil.getParameter(request, prefix + "tgt_rad_tpsz", length));
            String[] tgtEmptyTpsz = (JSPUtil.getParameter(request, prefix + "tgt_empty_tpsz", length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
            String[] teuCnt = (JSPUtil.getParameter(request, prefix + "teu_cnt", length));
            String[] orYn = (JSPUtil.getParameter(request, prefix + "or_yn", length));
            String[] olYn = (JSPUtil.getParameter(request, prefix + "ol_yn", length));
            String[] ohYn = (JSPUtil.getParameter(request, prefix + "oh_yn", length));
            String[] voidCnt = (JSPUtil.getParameter(request, prefix + "void_cnt", length));
            String[] optionA = (JSPUtil.getParameter(request, prefix + "option_a", length));
            String[] optionB = (JSPUtil.getParameter(request, prefix + "option_b", length));
            String[] delFlg = (JSPUtil.getParameter(request, prefix + "del_flg", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] dftTpszGroup = (JSPUtil.getParameter(request, prefix + "dft_tpsz_group", length));
	    	String[] dftTpsz = (JSPUtil.getParameter(request, prefix + "dft_tpsz", length));
	    	String[] dftTeuCnt = (JSPUtil.getParameter(request, prefix + "dft_teu_cnt", length));
	    	String[] dftRfPlugFlg = (JSPUtil.getParameter(request, prefix + "dft_rf_plug_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrConversionAndOptionVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pptCd[i] != null)
                    model.setPptCd(pptCd[i]);
                if (lineSeq[i] != null)
                    model.setLineSeq(lineSeq[i]);
                if (srcTpsz[i] != null)
                    model.setSrcTpsz(srcTpsz[i]);
                if (tgtNormalTpsz[i] != null)
                    model.setTgtNormalTpsz(tgtNormalTpsz[i]);
                if (tgtRadTpsz[i] != null)
                    model.setTgtRadTpsz(tgtRadTpsz[i]);
                if (tgtEmptyTpsz[i] != null)
                    model.setTgtEmptyTpsz(tgtEmptyTpsz[i]);
                if (lane[i] != null)
                    model.setLane(lane[i]);
                if (teuCnt[i] != null)
                    model.setTeuCnt(teuCnt[i]);
                if (orYn[i] != null)
                    model.setOrYn(orYn[i]);
                if (olYn[i] != null)
                    model.setOlYn(olYn[i]);
                if (ohYn[i] != null)
                    model.setOhYn(ohYn[i]);
                if (voidCnt[i] != null)
                    model.setVoidCnt(voidCnt[i]);
                if (optionA[i] != null)
                    model.setOptionA(optionA[i]);
                if (optionB[i] != null)
                    model.setOptionB(optionB[i]);
                if (delFlg[i] != null)
                    model.setDelFlg(delFlg[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (dftTpszGroup[i] != null) 
		    		model.setDftTpszGroup(dftTpszGroup[i]);
				if (dftTpsz[i] != null) 
		    		model.setDftTpsz(dftTpsz[i]);
				if (dftTeuCnt[i] != null) 
		    		model.setDftTeuCnt(dftTeuCnt[i]);
				if (dftRfPlugFlg[i] != null) 
		    		model.setDftRfPlugFlg(dftRfPlugFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrConversionAndOptionVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrConversionAndOptionVO[]
	 */
    public CntrConversionAndOptionVO[] getCntrConversionAndOptionVOs() {
        CntrConversionAndOptionVO[] vos = (CntrConversionAndOptionVO[]) models.toArray(new CntrConversionAndOptionVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pptCd = this.pptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lineSeq = this.lineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srcTpsz = this.srcTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tgtNormalTpsz = this.tgtNormalTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tgtRadTpsz = this.tgtRadTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tgtEmptyTpsz = this.tgtEmptyTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuCnt = this.teuCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orYn = this.orYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.olYn = this.olYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ohYn = this.ohYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voidCnt = this.voidCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.optionA = this.optionA.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.optionB = this.optionB.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delFlg = this.delFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dftTpszGroup = this.dftTpszGroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dftTpsz = this.dftTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dftTeuCnt = this.dftTeuCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dftRfPlugFlg = this.dftRfPlugFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
