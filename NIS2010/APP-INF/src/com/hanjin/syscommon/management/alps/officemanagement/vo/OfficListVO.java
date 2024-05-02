/*=========================================================
*Copyright(c) 2011 CyberLogitec 
*@FileName : OfficListVO.java
*@FileTitle : OfficListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.21  
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.officemanagement.vo;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class OfficListVO extends AbstractValueObject
{
	private static final long serialVersionUID = 1L;
	
	private Collection<OfficListVO> models = new ArrayList<OfficListVO>();
	
	/* Column Info */
	private String checkVal = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String checkValRead = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String dummycol = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String ofcKrnNm = null;
	/* Column Info */
	private String locCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
    public OfficListVO() {}

    public OfficListVO(String ibflag, String pagerows, String checkVal, String level, String ofcCd, String ofcEngNm, String ofcKrnNm, 
            String prntOfcCd, String ofcKndCd, String repCustCntCd, String arOfcCd, String dummycol)
    {
      this.checkVal = checkVal;
		this.ofcKndCd = ofcKndCd;
		this.checkValRead = checkValRead;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.ofcEngNm = ofcEngNm;
		this.ofcTpCd = ofcTpCd;
		this.dummycol = dummycol;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.level = level;
		this.repCustCntCd = repCustCntCd;
		this.prntOfcCd = prntOfcCd;
		this.ofcKrnNm = ofcKrnNm;
		this.locCd = locCd;  
    }

/*	테이블 컬럼의 값을 저장하는 Hashtable */
    public HashMap getColumnValues()
    {
        hashColumns.put("ofc_knd_cd", getOfcKndCd());
        hashColumns.put("ofc_cd", getOfcCd());
        hashColumns.put("check_val", getCheckVal());
        hashColumns.put("ibflag", getIbflag());
        hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
        hashColumns.put("level", getLevel());
        hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
        hashColumns.put("ofc_eng_nm", getOfcEngNm());
        hashColumns.put("dummycol", getDummycol());
        hashColumns.put("ofc_krn_nm", getOfcKrnNm());
        hashColumns.put("ar_ofc_cd", getArOfcCd());
        hashColumns.put("pagerows", getPagerows());
        return hashColumns;
    }

    public HashMap getFieldNames()
    {
        hashFields.put("ofc_knd_cd", "ofcKndCd");
        hashFields.put("ofc_cd", "ofcCd");
        hashFields.put("check_val", "checkVal");
        hashFields.put("ibflag", "ibflag");
        hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
        hashFields.put("level", "level");
        hashFields.put("prnt_ofc_cd", "prntOfcCd");
        hashFields.put("ofc_eng_nm", "ofcEngNm");
        hashFields.put("dummycol", "dummycol");
        hashFields.put("ofc_krn_nm", "ofcKrnNm");
        hashFields.put("ar_ofc_cd", "arOfcCd");
        hashFields.put("pagerows", "pagerows");
        return hashFields;
    }

    public String getOfcKndCd()
    {
        return ofcKndCd;
    }

    public String getOfcCd()
    {
        return ofcCd;
    }

    public String getCheckVal()
    {
        return checkVal;
    }

    public String getIbflag()
    {
        return ibflag;
    }

    public String getRepCustCntCd()
    {
        return repCustCntCd;
    }

    public String getLevel()
    {
        return level;
    }

    public String getPrntOfcCd()
    {
        return prntOfcCd;
    }

    public String getOfcEngNm()
    {
        return ofcEngNm;
    }

    public String getDummycol()
    {
        return dummycol;
    }

    public String getOfcKrnNm()
    {
        return ofcKrnNm;
    }

    public String getArOfcCd()
    {
        return arOfcCd;
    }

    public String getPagerows()
    {
        return pagerows;
    }

    public void setOfcKndCd(String ofcKndCd)
    {
        this.ofcKndCd = ofcKndCd;
    }

    public void setOfcCd(String ofcCd)
    {
        this.ofcCd = ofcCd;
    }

    public void setCheckVal(String checkVal)
    {
        this.checkVal = checkVal;
    }

    public void setIbflag(String ibflag)
    {
        this.ibflag = ibflag;
    }

    public void setRepCustCntCd(String repCustCntCd)
    {
        this.repCustCntCd = repCustCntCd;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public void setPrntOfcCd(String prntOfcCd)
    {
        this.prntOfcCd = prntOfcCd;
    }

    public void setOfcEngNm(String ofcEngNm)
    {
        this.ofcEngNm = ofcEngNm;
    }

    public void setDummycol(String dummycol)
    {
        this.dummycol = dummycol;
    }

    public void setOfcKrnNm(String ofcKrnNm)
    {
        this.ofcKrnNm = ofcKrnNm;
    }

    public void setArOfcCd(String arOfcCd)
    {
        this.arOfcCd = arOfcCd;
    }

    public void setPagerows(String pagerows)
    {
        this.pagerows = pagerows;
    }

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	
    public void fromRequest(HttpServletRequest request)
    {
        fromRequest(request, "");
    }

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param HttpServletRequest request
	 * @param String prefix
	 */
	
    public void fromRequest(HttpServletRequest request, String prefix)
    {
        setOfcKndCd(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_knd_cd").toString(), ""));
        setOfcCd(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_cd").toString(), ""));
        setCheckVal(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("check_val").toString(), ""));
        setIbflag(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ibflag").toString(), ""));
        setRepCustCntCd(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("rep_cust_cnt_cd").toString(), ""));
        setLevel(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("level").toString(), ""));
        setPrntOfcCd(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("prnt_ofc_cd").toString(), ""));
        setOfcEngNm(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_eng_nm").toString(), ""));
        setDummycol(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("dummycol").toString(), ""));
        setOfcKrnNm(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_krn_nm").toString(), ""));
        setArOfcCd(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ar_ofc_cd").toString(), ""));
        setPagerows(JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("pagerows").toString(), ""));
    }

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficListVO[]
	 */
	
    public OfficListVO[] fromRequestGrid(HttpServletRequest request)
    {
        return fromRequestGrid(request, "");
    }

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficListVO[]
	 */
	
    public OfficListVO[] fromRequestGrid(HttpServletRequest request, String prefix)
    {
        OfficListVO model = null;
        String tmp[] = request.getParameterValues((new StringBuilder(String.valueOf(prefix))).append("ibflag").toString());
        if(tmp == null)
            return null;
        int length = request.getParameterValues((new StringBuilder(String.valueOf(prefix))).append("ibflag").toString()).length;
        try
        {
            String ofcKndCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_knd_cd").toString(), length);
            String ofcCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_cd").toString(), length);
            String checkVal[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("check_val").toString(), length);
            String ibflag[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ibflag").toString(), length);
            String repCustCntCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("rep_cust_cnt_cd").toString(), length);
            String level[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("level").toString(), length);
            String prntOfcCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("prnt_ofc_cd").toString(), length);
            String ofcEngNm[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_eng_nm").toString(), length);
            String dummycol[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("dummycol").toString(), length);
            String ofcKrnNm[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ofc_krn_nm").toString(), length);
            String arOfcCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ar_ofc_cd").toString(), length);
            String pagerows[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("pagerows").toString(), length);
            for(int i = 0; i < length; i++)
            {
                model = new OfficListVO();
                if(ofcKndCd[i] != null)
                    model.setOfcKndCd(ofcKndCd[i]);
                if(ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if(checkVal[i] != null)
                    model.setCheckVal(checkVal[i]);
                if(ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if(repCustCntCd[i] != null)
                    model.setRepCustCntCd(repCustCntCd[i]);
                if(level[i] != null)
                    model.setLevel(level[i]);
                if(prntOfcCd[i] != null)
                    model.setPrntOfcCd(prntOfcCd[i]);
                if(ofcEngNm[i] != null)
                    model.setOfcEngNm(ofcEngNm[i]);
                if(dummycol[i] != null)
                    model.setDummycol(dummycol[i]);
                if(ofcKrnNm[i] != null)
                    model.setOfcKrnNm(ofcKrnNm[i]);
                if(arOfcCd[i] != null)
                    model.setArOfcCd(arOfcCd[i]);
                if(pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                models.add(model);
            }

        }
        catch(Exception e)
        {
			return null;
        }
        return getOfficListVOs();
    }

	/**
	 * VO 배열을 반환
	 * @return OfficListVO[]
	 */
	
    public OfficListVO[] getOfficListVOs()
    {
        OfficListVO vos[] = (OfficListVO[])models.toArray(new OfficListVO[models.size()]);
        return vos;
    }

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
		
    public void unDataFormat()
    {
        ofcKndCd = ofcKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ofcCd = ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        checkVal = checkVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ibflag = ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        repCustCntCd = repCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        level = level.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        prntOfcCd = prntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ofcEngNm = ofcEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        dummycol = dummycol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ofcKrnNm = ofcKrnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        arOfcCd = arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        pagerows = pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
