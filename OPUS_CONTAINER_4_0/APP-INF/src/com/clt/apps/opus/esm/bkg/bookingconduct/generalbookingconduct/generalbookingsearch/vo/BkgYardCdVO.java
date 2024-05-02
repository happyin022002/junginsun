/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgYardCdVO.java
*@FileTitle : BkgYardCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.04 이도형 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgYardCdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgYardCdVO> models = new ArrayList<BkgYardCdVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ediRefCd = null;

    /* Column Info */
    private String ediRcvId = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ediRcvDesc = null;

    /* Column Info */
    private String port = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgYardCdVO() {
    }

    public BkgYardCdVO(String ibflag, String pagerows, String ediRefCd, String ediRcvId, String ediRcvDesc, String port) {
        this.ibflag = ibflag;
        this.ediRefCd = ediRefCd;
        this.ediRcvId = ediRcvId;
        this.pagerows = pagerows;
        this.ediRcvDesc = ediRcvDesc;
        this.port = port;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("edi_ref_cd", getEdiRefCd());
        this.hashColumns.put("edi_rcv_id", getEdiRcvId());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("edi_rcv_desc", getEdiRcvDesc());
        this.hashColumns.put("port", getPort());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("edi_ref_cd", "ediRefCd");
        this.hashFields.put("edi_rcv_id", "ediRcvId");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("edi_rcv_desc", "ediRcvDesc");
        this.hashFields.put("port", "port");
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
	 * @return ediRefCd
	 */
    public String getEdiRefCd() {
        return this.ediRefCd;
    }

    /**
	 * Column Info
	 * @return ediRcvId
	 */
    public String getEdiRcvId() {
        return this.ediRcvId;
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
	 * @param ediRefCd
	 */
    public void setEdiRefCd(String ediRefCd) {
        this.ediRefCd = ediRefCd;
    }

    /**
	 * Column Info
	 * @param ediRcvId
	 */
    public void setEdiRcvId(String ediRcvId) {
        this.ediRcvId = ediRcvId;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setEdiRcvDesc(String ediRcvDesc) {
        this.ediRcvDesc = ediRcvDesc;
    }

    public String getEdiRcvDesc() {
        return this.ediRcvDesc;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return this.port;
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
        setEdiRefCd(JSPUtil.getParameter(request, prefix + "edi_ref_cd", ""));
        setEdiRcvId(JSPUtil.getParameter(request, prefix + "edi_rcv_id", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setEdiRcvDesc(JSPUtil.getParameter(request, prefix + "edi_rcv_desc", ""));
        setPort(JSPUtil.getParameter(request, prefix + "port", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgYardCdVO[]
	 */
    public BkgYardCdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgYardCdVO[]
	 */
    public BkgYardCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgYardCdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ediRefCd = (JSPUtil.getParameter(request, prefix + "edi_ref_cd", length));
            String[] ediRcvId = (JSPUtil.getParameter(request, prefix + "edi_rcv_id", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ediRcvDesc = (JSPUtil.getParameter(request, prefix + "edi_rcv_desc", length));
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgYardCdVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ediRefCd[i] != null)
                    model.setEdiRefCd(ediRefCd[i]);
                if (ediRcvId[i] != null)
                    model.setEdiRcvId(ediRcvId[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ediRcvDesc[i] != null)
                    model.setEdiRcvDesc(ediRcvDesc[i]);
                if (port[i] != null) 
		    		model.setPort(port[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgYardCdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgYardCdVO[]
	 */
    public BkgYardCdVO[] getBkgYardCdVOs() {
        BkgYardCdVO[] vos = (BkgYardCdVO[]) models.toArray(new BkgYardCdVO[models.size()]);
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
        this.ediRefCd = this.ediRefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvId = this.ediRcvId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvDesc = this.ediRcvDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
