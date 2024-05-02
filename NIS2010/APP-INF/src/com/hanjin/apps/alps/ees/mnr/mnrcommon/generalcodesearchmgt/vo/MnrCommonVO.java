/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrCommonVO.java
*@FileTitle : MnrCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
public class MnrCommonVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MnrCommonVO> models = new ArrayList<MnrCommonVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String coid = null;

    /* Column Info */
    private String mode = null;

    /* Column Info */
    private String idx = null;

    /* Column Info */
    private String fCmd = null;

    /* Column Info */
    private String def = null;

    /* Column Info */
    private String functionname = null;

    /* Column Info */
    private String idaSacCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public MnrCommonVO() {
    }

    public MnrCommonVO(String ibflag, String pagerows, String coid, String mode, String idx, String fCmd, String def, String functionname, String idaSacCd, String ofcCd, String vndrSeq) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.coid = coid;
        this.mode = mode;
        this.idx = idx;
        this.fCmd = fCmd;
        this.def = def;
        this.functionname = functionname;
        this.idaSacCd = idaSacCd;
        this.ofcCd = ofcCd;
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("coid", getCoid());
        this.hashColumns.put("mode", getMode());
        this.hashColumns.put("idx", getIdx());
        this.hashColumns.put("f_cmd", getFCmd());
        this.hashColumns.put("def", getDef());
        this.hashColumns.put("functionname", getFunctionname());
        this.hashColumns.put("ida_sac_cd", getIdaSacCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("coid", "coid");
        this.hashFields.put("mode", "mode");
        this.hashFields.put("idx", "idx");
        this.hashFields.put("f_cmd", "fCmd");
        this.hashFields.put("def", "def");
        this.hashFields.put("functionname", "functionname");
        this.hashFields.put("ida_sac_cd", "idaSacCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
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
	 * @param String coid
	 */
    public void setCoid(String coid) {
        this.coid = coid;
    }

    /**
	 * 
	 * @return String coid
	 */
    public String getCoid() {
        return this.coid;
    }

    /**
	 *
	 * @param String mode
	 */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
	 * 
	 * @return String mode
	 */
    public String getMode() {
        return this.mode;
    }

    /**
	 *
	 * @param String idx
	 */
    public void setIdx(String idx) {
        this.idx = idx;
    }

    /**
	 * 
	 * @return String idx
	 */
    public String getIdx() {
        return this.idx;
    }

    /**
	 *
	 * @param String fCmd
	 */
    public void setFCmd(String fCmd) {
        this.fCmd = fCmd;
    }

    /**
	 * 
	 * @return String fCmd
	 */
    public String getFCmd() {
        return this.fCmd;
    }

    /**
	 *
	 * @param String def
	 */
    public void setDef(String def) {
        this.def = def;
    }

    /**
	 * 
	 * @return String def
	 */
    public String getDef() {
        return this.def;
    }

    /**
	 *
	 * @param String functionname
	 */
    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    /**
	 * 
	 * @return String functionname
	 */
    public String getFunctionname() {
        return this.functionname;
    }

    public void setIdaSacCd(String idaSacCd) {
        this.idaSacCd = idaSacCd;
    }

    public String getIdaSacCd() {
        return this.idaSacCd;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
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
        setCoid(JSPUtil.getParameter(request, prefix + "coid", ""));
        setMode(JSPUtil.getParameter(request, prefix + "mode", ""));
        setIdx(JSPUtil.getParameter(request, prefix + "idx", ""));
        setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
        setDef(JSPUtil.getParameter(request, prefix + "def", ""));
        setFunctionname(JSPUtil.getParameter(request, prefix + "functionname", ""));
        setIdaSacCd(JSPUtil.getParameter(request, prefix + "ida_sac_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrCommonVO[]
	 */
    public MnrCommonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrCommonVO[]
	 */
    public MnrCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MnrCommonVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] coid = (JSPUtil.getParameter(request, prefix + "coid", length));
            String[] mode = (JSPUtil.getParameter(request, prefix + "mode", length));
            String[] idx = (JSPUtil.getParameter(request, prefix + "idx", length));
            String[] fCmd = (JSPUtil.getParameter(request, prefix + "f_cmd", length));
            String[] def = (JSPUtil.getParameter(request, prefix + "def", length));
            String[] functionname = (JSPUtil.getParameter(request, prefix + "functionname", length));
            String[] idaSacCd = (JSPUtil.getParameter(request, prefix + "ida_sac_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MnrCommonVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (coid[i] != null)
                    model.setCoid(coid[i]);
                if (mode[i] != null)
                    model.setMode(mode[i]);
                if (idx[i] != null)
                    model.setIdx(idx[i]);
                if (fCmd[i] != null)
                    model.setFCmd(fCmd[i]);
                if (def[i] != null)
                    model.setDef(def[i]);
                if (functionname[i] != null)
                    model.setFunctionname(functionname[i]);
                if (idaSacCd[i] != null)
                    model.setIdaSacCd(idaSacCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMnrCommonVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MnrCommonVO[]
	 */
    public MnrCommonVO[] getMnrCommonVOs() {
        MnrCommonVO[] vos = (MnrCommonVO[]) models.toArray(new MnrCommonVO[models.size()]);
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
        this.coid = this.coid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mode = this.mode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idx = this.idx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCmd = this.fCmd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.def = this.def.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.functionname = this.functionname.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSacCd = this.idaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
