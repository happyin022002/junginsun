/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudEstSumByMonVO.java
*@FileTitle : BudEstSumByMonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.06 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BudEstSumByMonVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BudEstSumByMonVO> models = new ArrayList<BudEstSumByMonVO>();

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String budget = null;

    /* Column Info */
    private String accountCode = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String yyyyMm = null;

    /* Column Info */
    private String estimate = null;

    /* Column Info */
    private String lane = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String actual = null;

    /* Column Info */
    private String loc = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BudEstSumByMonVO() {
    }

    public BudEstSumByMonVO(String ibflag, String pagerows, String yyyyMm, String vvd, String lane, String accountCode, String budget, String estimate, String actual, String loc) {
        this.vvd = vvd;
        this.budget = budget;
        this.accountCode = accountCode;
        this.ibflag = ibflag;
        this.yyyyMm = yyyyMm;
        this.estimate = estimate;
        this.lane = lane;
        this.pagerows = pagerows;
        this.actual = actual;
        this.loc = loc;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("budget", getBudget());
        this.hashColumns.put("account_code", getAccountCode());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("yyyy_mm", getYyyyMm());
        this.hashColumns.put("estimate", getEstimate());
        this.hashColumns.put("lane", getLane());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("actual", getActual());
        this.hashColumns.put("loc", getLoc());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("budget", "budget");
        this.hashFields.put("account_code", "accountCode");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("yyyy_mm", "yyyyMm");
        this.hashFields.put("estimate", "estimate");
        this.hashFields.put("lane", "lane");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("actual", "actual");
        this.hashFields.put("loc", "loc");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return budget
	 */
    public String getBudget() {
        return this.budget;
    }

    /**
	 * Column Info
	 * @return accountCode
	 */
    public String getAccountCode() {
        return this.accountCode;
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
	 * @return yyyyMm
	 */
    public String getYyyyMm() {
        return this.yyyyMm;
    }

    /**
	 * Column Info
	 * @return estimate
	 */
    public String getEstimate() {
        return this.estimate;
    }

    /**
	 * Column Info
	 * @return lane
	 */
    public String getLane() {
        return this.lane;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param budget
	 */
    public void setBudget(String budget) {
        this.budget = budget;
    }

    /**
	 * Column Info
	 * @param accountCode
	 */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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
	 * @param yyyyMm
	 */
    public void setYyyyMm(String yyyyMm) {
        this.yyyyMm = yyyyMm;
    }

    /**
	 * Column Info
	 * @param estimate
	 */
    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    /**
	 * Column Info
	 * @param lane
	 */
    public void setLane(String lane) {
        this.lane = lane;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getActual() {
        return this.actual;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getLoc() {
        return this.loc;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setBudget(JSPUtil.getParameter(request, "budget", ""));
        setAccountCode(JSPUtil.getParameter(request, "account_code", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setYyyyMm(JSPUtil.getParameter(request, "yyyy_mm", ""));
        setEstimate(JSPUtil.getParameter(request, "estimate", ""));
        setLane(JSPUtil.getParameter(request, "lane", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setActual(JSPUtil.getParameter(request, "actual", ""));
        setLoc(JSPUtil.getParameter(request, "loc", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BudEstSumByMonVO[]
	 */
    public BudEstSumByMonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BudEstSumByMonVO[]
	 */
    public BudEstSumByMonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BudEstSumByMonVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] budget = (JSPUtil.getParameter(request, prefix + "budget", length));
            String[] accountCode = (JSPUtil.getParameter(request, prefix + "account_code", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] yyyyMm = (JSPUtil.getParameter(request, prefix + "yyyy_mm", length));
            String[] estimate = (JSPUtil.getParameter(request, prefix + "estimate", length));
            String[] lane = (JSPUtil.getParameter(request, prefix + "lane", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] actual = (JSPUtil.getParameter(request, prefix + "actual", length));
            String[] loc = (JSPUtil.getParameter(request, prefix + "loc", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BudEstSumByMonVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (budget[i] != null)
                    model.setBudget(budget[i]);
                if (accountCode[i] != null)
                    model.setAccountCode(accountCode[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (yyyyMm[i] != null)
                    model.setYyyyMm(yyyyMm[i]);
                if (estimate[i] != null)
                    model.setEstimate(estimate[i]);
                if (lane[i] != null)
                    model.setLane(lane[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (actual[i] != null)
                    model.setActual(actual[i]);
                if (loc[i] != null) 
		    		model.setLoc(loc[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBudEstSumByMonVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BudEstSumByMonVO[]
	 */
    public BudEstSumByMonVO[] getBudEstSumByMonVOs() {
        BudEstSumByMonVO[] vos = (BudEstSumByMonVO[]) models.toArray(new BudEstSumByMonVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
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
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.budget = this.budget.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.accountCode = this.accountCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yyyyMm = this.yyyyMm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estimate = this.estimate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actual = this.actual.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loc = this.loc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
