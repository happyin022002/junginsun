/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestCntrSealNoInfoVO.java
*@FileTitle : MalaysiaManifestCntrSealNoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.14  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
public class MalaysiaManifestCntrSealNoInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MalaysiaManifestCntrSealNoInfoVO> models = new ArrayList<MalaysiaManifestCntrSealNoInfoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sealnbr = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String sealPtyTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MalaysiaManifestCntrSealNoInfoVO() {
    }

    public MalaysiaManifestCntrSealNoInfoVO(String ibflag, String pagerows, String sealnbr, String sealPtyTpCd) {
        this.ibflag = ibflag;
        this.sealnbr = sealnbr;
        this.pagerows = pagerows;
        this.sealPtyTpCd = sealPtyTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("sealnbr", getSealnbr());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("seal_pty_tp_cd", getSealPtyTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("sealnbr", "sealnbr");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("seal_pty_tp_cd", "sealPtyTpCd");
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
	 * @return sealnbr
	 */
    public String getSealnbr() {
        return this.sealnbr;
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
	 * @param sealnbr
	 */
    public void setSealnbr(String sealnbr) {
        this.sealnbr = sealnbr;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setSealPtyTpCd(String sealPtyTpCd) {
        this.sealPtyTpCd = sealPtyTpCd;
    }

    public String getSealPtyTpCd() {
        return this.sealPtyTpCd;
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
        setSealnbr(JSPUtil.getParameter(request, prefix + "sealnbr", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSealPtyTpCd(JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
    public MalaysiaManifestCntrSealNoInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
    public MalaysiaManifestCntrSealNoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MalaysiaManifestCntrSealNoInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sealnbr = (JSPUtil.getParameter(request, prefix + "sealnbr", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sealPtyTpCd = (JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MalaysiaManifestCntrSealNoInfoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sealnbr[i] != null)
                    model.setSealnbr(sealnbr[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sealPtyTpCd[i] != null) 
		    		model.setSealPtyTpCd(sealPtyTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMalaysiaManifestCntrSealNoInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
    public MalaysiaManifestCntrSealNoInfoVO[] getMalaysiaManifestCntrSealNoInfoVOs() {
        MalaysiaManifestCntrSealNoInfoVO[] vos = (MalaysiaManifestCntrSealNoInfoVO[]) models.toArray(new MalaysiaManifestCntrSealNoInfoVO[models.size()]);
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
        this.sealnbr = this.sealnbr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealPtyTpCd = this.sealPtyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
