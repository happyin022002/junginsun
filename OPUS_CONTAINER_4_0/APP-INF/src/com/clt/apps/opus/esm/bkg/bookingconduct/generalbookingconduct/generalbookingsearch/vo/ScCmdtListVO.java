/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScCmdtListVO.java
*@FileTitle : ScCmdtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.05 류대영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ScCmdtListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScCmdtListVO> models = new ArrayList<ScCmdtListVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String repCmdtCd = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String scopeName = null;

    /* Column Info */
    private String prcCmdtDefCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String grpCmdtDesc = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ScCmdtListVO() {
    }

    public ScCmdtListVO(String ibflag, String pagerows, String prcCmdtDefCd, String cmdtNm, String scopeName, String cmdtCd, String repCmdtCd, String svcScpCd, String grpCmdtDesc) {
        this.ibflag = ibflag;
        this.cmdtCd = cmdtCd;
        this.svcScpCd = svcScpCd;
        this.repCmdtCd = repCmdtCd;
        this.cmdtNm = cmdtNm;
        this.scopeName = scopeName;
        this.prcCmdtDefCd = prcCmdtDefCd;
        this.pagerows = pagerows;
        this.grpCmdtDesc = grpCmdtDesc;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("scope_name", getScopeName());
        this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("grp_cmdt_desc", getGrpCmdtDesc());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("scope_name", "scopeName");
        this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("grp_cmdt_desc", "grpCmdtDesc");
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return svcScpCd
	 */
    public String getSvcScpCd() {
        return this.svcScpCd;
    }

    /**
	 * Column Info
	 * @return repCmdtCd
	 */
    public String getRepCmdtCd() {
        return this.repCmdtCd;
    }

    /**
	 * Column Info
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
    }

    /**
	 * Column Info
	 * @return scopeName
	 */
    public String getScopeName() {
        return this.scopeName;
    }

    /**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
    public String getPrcCmdtDefCd() {
        return this.prcCmdtDefCd;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param svcScpCd
	 */
    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    /**
	 * Column Info
	 * @param repCmdtCd
	 */
    public void setRepCmdtCd(String repCmdtCd) {
        this.repCmdtCd = repCmdtCd;
    }

    /**
	 * Column Info
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    /**
	 * Column Info
	 * @param scopeName
	 */
    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    /**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
    public void setPrcCmdtDefCd(String prcCmdtDefCd) {
        this.prcCmdtDefCd = prcCmdtDefCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setGrpCmdtDesc(String grpCmdtDesc) {
        this.grpCmdtDesc = grpCmdtDesc;
    }

    public String getGrpCmdtDesc() {
        return this.grpCmdtDesc;
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
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setScopeName(JSPUtil.getParameter(request, prefix + "scope_name", ""));
        setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "grp_cmdt_desc", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScCmdtListVO[]
	 */
    public ScCmdtListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScCmdtListVO[]
	 */
    public ScCmdtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScCmdtListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] repCmdtCd = (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] scopeName = (JSPUtil.getParameter(request, prefix + "scope_name", length));
            String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] grpCmdtDesc = (JSPUtil.getParameter(request, prefix + "grp_cmdt_desc", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScCmdtListVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (repCmdtCd[i] != null)
                    model.setRepCmdtCd(repCmdtCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (scopeName[i] != null)
                    model.setScopeName(scopeName[i]);
                if (prcCmdtDefCd[i] != null)
                    model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (grpCmdtDesc[i] != null) 
		    		model.setGrpCmdtDesc(grpCmdtDesc[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScCmdtListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ScCmdtListVO[]
	 */
    public ScCmdtListVO[] getScCmdtListVOs() {
        ScCmdtListVO[] vos = (ScCmdtListVO[]) models.toArray(new ScCmdtListVO[models.size()]);
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
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdtCd = this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scopeName = this.scopeName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcCmdtDefCd = this.prcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpCmdtDesc = this.grpCmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
