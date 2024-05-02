/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendLogDetailVO.java
*@FileTitle : SendLogDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.17 김도완 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SendLogDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SendLogDetailVO> models = new ArrayList<SendLogDetailVO>();

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pos = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String tmp2 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String lastpol = null;

    /* Column Info */
    private String tmp1 = null;

    /* Column Info */
    private String tmp3 = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String pol = null;

    /* Column Info */
    private String seq = null;

    /* Column Info */
    private String del = null;

    /* Column Info */
    private String pod = null;

    /* Column Info */
    private String cvyRefNo = null;

    /* Column Info */
    private String hiddenVvd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SendLogDetailVO() {
    }

    public SendLogDetailVO(String ibflag, String pagerows, String seq, String vvd, String pol, String pod, String del, String pos, String cntrNo, String lastpol, String ofcCd, String usrId, String tmp1, String tmp2, String tmp3, String cvyRefNo, String hiddenVvd) {
        this.pagerows = pagerows;
        this.pos = pos;
        this.vvd = vvd;
        this.ofcCd = ofcCd;
        this.tmp2 = tmp2;
        this.ibflag = ibflag;
        this.lastpol = lastpol;
        this.tmp1 = tmp1;
        this.tmp3 = tmp3;
        this.usrId = usrId;
        this.cntrNo = cntrNo;
        this.pol = pol;
        this.seq = seq;
        this.del = del;
        this.pod = pod;
        this.cvyRefNo = cvyRefNo;
        this.hiddenVvd = hiddenVvd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pos", getPos());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("tmp2", getTmp2());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("lastpol", getLastpol());
        this.hashColumns.put("tmp1", getTmp1());
        this.hashColumns.put("tmp3", getTmp3());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("pol", getPol());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("del", getDel());
        this.hashColumns.put("pod", getPod());
        this.hashColumns.put("cvy_ref_no", getCvyRefNo());
        this.hashColumns.put("hidden_vvd", getHiddenVvd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pos", "pos");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("tmp2", "tmp2");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("lastpol", "lastpol");
        this.hashFields.put("tmp1", "tmp1");
        this.hashFields.put("tmp3", "tmp3");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("pol", "pol");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("del", "del");
        this.hashFields.put("pod", "pod");
        this.hashFields.put("cvy_ref_no", "cvyRefNo");
        this.hashFields.put("hidden_vvd", "hiddenVvd");
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
	 * @return pos
	 */
    public String getPos() {
        return this.pos;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return tmp2
	 */
    public String getTmp2() {
        return this.tmp2;
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
	 * @return lastpol
	 */
    public String getLastpol() {
        return this.lastpol;
    }

    /**
	 * Column Info
	 * @return tmp1
	 */
    public String getTmp1() {
        return this.tmp1;
    }

    /**
	 * Column Info
	 * @return tmp3
	 */
    public String getTmp3() {
        return this.tmp3;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return pol
	 */
    public String getPol() {
        return this.pol;
    }

    /**
	 * Column Info
	 * @return seq
	 */
    public String getSeq() {
        return this.seq;
    }

    /**
	 * Column Info
	 * @return del
	 */
    public String getDel() {
        return this.del;
    }

    /**
	 * Column Info
	 * @return pod
	 */
    public String getPod() {
        return this.pod;
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
	 * @param pos
	 */
    public void setPos(String pos) {
        this.pos = pos;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param tmp2
	 */
    public void setTmp2(String tmp2) {
        this.tmp2 = tmp2;
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
	 * @param lastpol
	 */
    public void setLastpol(String lastpol) {
        this.lastpol = lastpol;
    }

    /**
	 * Column Info
	 * @param tmp1
	 */
    public void setTmp1(String tmp1) {
        this.tmp1 = tmp1;
    }

    /**
	 * Column Info
	 * @param tmp3
	 */
    public void setTmp3(String tmp3) {
        this.tmp3 = tmp3;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param pol
	 */
    public void setPol(String pol) {
        this.pol = pol;
    }

    /**
	 * Column Info
	 * @param seq
	 */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
	 * Column Info
	 * @param del
	 */
    public void setDel(String del) {
        this.del = del;
    }

    /**
	 * Column Info
	 * @param pod
	 */
    public void setPod(String pod) {
        this.pod = pod;
    }

    public void setCvyRefNo(String cvyRefNo) {
        this.cvyRefNo = cvyRefNo;
    }

    public String getCvyRefNo() {
        return this.cvyRefNo;
    }

    public void setHiddenVvd(String hiddenVvd) {
        this.hiddenVvd = hiddenVvd;
    }

    public String getHiddenVvd() {
        return this.hiddenVvd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPos(JSPUtil.getParameter(request, "pos", ""));
        setVvd(JSPUtil.getParameter(request, "vvd", ""));
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setLastpol(JSPUtil.getParameter(request, "lastpol", ""));
        setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
        setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
        setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
        setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        setPol(JSPUtil.getParameter(request, "pol", ""));
        setSeq(JSPUtil.getParameter(request, "seq", ""));
        setDel(JSPUtil.getParameter(request, "del", ""));
        setPod(JSPUtil.getParameter(request, "pod", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendLogDetailVO[]
	 */
    public SendLogDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendLogDetailVO[]
	 */
    public SendLogDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SendLogDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pos = (JSPUtil.getParameter(request, prefix + "pos", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] tmp2 = (JSPUtil.getParameter(request, prefix + "tmp2", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] lastpol = (JSPUtil.getParameter(request, prefix + "lastpol", length));
            String[] tmp1 = (JSPUtil.getParameter(request, prefix + "tmp1", length));
            String[] tmp3 = (JSPUtil.getParameter(request, prefix + "tmp3", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] pol = (JSPUtil.getParameter(request, prefix + "pol", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
            String[] pod = (JSPUtil.getParameter(request, prefix + "pod", length));
            String[] cvyRefNo = (JSPUtil.getParameter(request, prefix + "cvy_ref_no", length));
	    	String[] hiddenVvd = (JSPUtil.getParameter(request, prefix + "hidden_vvd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SendLogDetailVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pos[i] != null)
                    model.setPos(pos[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (tmp2[i] != null)
                    model.setTmp2(tmp2[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (lastpol[i] != null)
                    model.setLastpol(lastpol[i]);
                if (tmp1[i] != null)
                    model.setTmp1(tmp1[i]);
                if (tmp3[i] != null)
                    model.setTmp3(tmp3[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (pol[i] != null)
                    model.setPol(pol[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (del[i] != null)
                    model.setDel(del[i]);
                if (pod[i] != null)
                    model.setPod(pod[i]);
                if (cvyRefNo[i] != null) 
		    		model.setCvyRefNo(cvyRefNo[i]);
				if (hiddenVvd[i] != null) 
		    		model.setHiddenVvd(hiddenVvd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSendLogDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SendLogDetailVO[]
	 */
    public SendLogDetailVO[] getSendLogDetailVOs() {
        SendLogDetailVO[] vos = (SendLogDetailVO[]) models.toArray(new SendLogDetailVO[models.size()]);
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
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pos = this.pos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmp2 = this.tmp2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastpol = this.lastpol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmp1 = this.tmp1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmp3 = this.tmp3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pol = this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pod = this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvyRefNo = this.cvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hiddenVvd = this.hiddenVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
