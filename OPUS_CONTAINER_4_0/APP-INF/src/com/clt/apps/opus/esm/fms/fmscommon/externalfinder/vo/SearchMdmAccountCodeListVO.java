/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMdmAccountCodeListVO.java
*@FileTitle : SearchMdmAccountCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.21 윤세영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see  ESM_FMS_0080HTMLAction
 */
public class SearchMdmAccountCodeListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchMdmAccountCodeListVO> models = new ArrayList<SearchMdmAccountCodeListVO>();

    /* 而щ읆 ?ㅻ챸 */
    private String acctCd = null;

    /* ?곹깭 */
    private String ibflag = null;

    /* 而щ읆 ?ㅻ챸 */
    private String acctEngNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String jnlCreFlg = null;

    /*	hashColumnInpo	*/
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /**
	 * 생성자
	 * @param
	 * @return 
	 */
    public SearchMdmAccountCodeListVO() {
    }

    /**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctCd, String acctEngNm
	 * @return 
	 */
    public SearchMdmAccountCodeListVO(String ibflag, String pagerows, String acctCd, String acctEngNm, String jnlCreFlg) {
        this.acctCd = acctCd;
        this.ibflag = ibflag;
        this.acctEngNm = acctEngNm;
        this.pagerows = pagerows;
        this.jnlCreFlg = jnlCreFlg;
    }

    /**
	 * hashColumnInpo
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("jnl_cre_flg", getJnlCreFlg());
        return this.hashColumns;
    }

    /**
	 * hashFildInpo
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("jnl_cre_flg", "jnlCreFlg");
        return this.hashFields;
    }

    public String getAcctCd() {
        return this.acctCd;
    }

    public String getIbflag() {
        return this.ibflag;
    }

    public String getAcctEngNm() {
        return this.acctEngNm;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setJnlCreFlg(String jnlCreFlg) {
        this.jnlCreFlg = jnlCreFlg;
    }

    public String getJnlCreFlg() {
        return this.jnlCreFlg;
    }

    public void fromRequest(HttpServletRequest request) {
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setJnlCreFlg(JSPUtil.getParameter(request, "jnl_cre_flg", ""));
    }

    public SearchMdmAccountCodeListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public SearchMdmAccountCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchMdmAccountCodeListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] jnlCreFlg = (JSPUtil.getParameter(request, prefix + "jnl_cre_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchMdmAccountCodeListVO();
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (jnlCreFlg[i] != null) 
		    		model.setJnlCreFlg(jnlCreFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
        }
        return getSearchMdmAccountCodeListVOs();
    }

    public SearchMdmAccountCodeListVO[] getSearchMdmAccountCodeListVOs() {
        SearchMdmAccountCodeListVO[] vos = (SearchMdmAccountCodeListVO[]) models.toArray(new SearchMdmAccountCodeListVO[models.size()]);
        return vos;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
        }
        return ret.toString();
    }

    /**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
    private String[] getField(Field[] field, int i) throws IllegalAccessException {
        String[] arr;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }

    /**
	* DataFormat 설정
	*/
    public void onDataFormat() {
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
