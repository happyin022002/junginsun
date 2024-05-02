/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SamKeyManInfoVO.java
*@FileTitle : SamKeyManInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo;

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

public class SamKeyManInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SamKeyManInfoVO> models = new ArrayList<SamKeyManInfoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String keymanSeq = null;

    /* Column Info */
    private String fstName = null;

    /* Column Info */
    private String lastName = null;

    /* Column Info */
    private String perTitle = null;

    /* Column Info */
    private String jobTitle = null;

    /* Column Info */
    private String pagerPin = null;

    /* Column Info */
    private String occupation = null;

    /* Column Info */
    private String eyeColor = null;

    /* Column Info */
    private String emailAddr = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String conManagerName = null;

    /* Column Info */
    private String workPhNum = null;

    /* Column Info */
    private String faxPhNum = null;

    /* Column Info */
    private String cellPhNum = null;

    /* Column Info */
    private String homePhNum = null;

    /* Column Info */
    private String hairColor = null;

    /* Column Info */
    private String spouseName = null;

    /* Column Info */
    private String birthDt = null;

    /* Column Info */
    private String wedAnvrsryDt = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String prmryChkFlg = null;
    
    /* Column Info */
    private String custLglEngNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SamKeyManInfoVO() {
    }

    public SamKeyManInfoVO(String ibflag, String pagerows, String custCntCd, String custSeq, String keymanSeq, String fstName, String lastName, String perTitle, String jobTitle, String pagerPin, String occupation, String eyeColor, String emailAddr, String srepCd, String conManagerName, String workPhNum, String faxPhNum, String cellPhNum, String homePhNum, String hairColor, String spouseName, String birthDt, String wedAnvrsryDt, String usrId, String creUsrId, String updUsrId, String prmryChkFlg, String custLglEngNm) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.keymanSeq = keymanSeq;
        this.fstName = fstName;
        this.lastName = lastName;
        this.perTitle = perTitle;
        this.jobTitle = jobTitle;
        this.pagerPin = pagerPin;
        this.occupation = occupation;
        this.eyeColor = eyeColor;
        this.emailAddr = emailAddr;
        this.srepCd = srepCd;
        this.conManagerName = conManagerName;
        this.workPhNum = workPhNum;
        this.faxPhNum = faxPhNum;
        this.cellPhNum = cellPhNum;
        this.homePhNum = homePhNum;
        this.hairColor = hairColor;
        this.spouseName = spouseName;
        this.birthDt = birthDt;
        this.wedAnvrsryDt = wedAnvrsryDt;
        this.usrId = usrId;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.prmryChkFlg = prmryChkFlg;
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("keyman_seq", getKeymanSeq());
        this.hashColumns.put("fst_name", getFstName());
        this.hashColumns.put("last_name", getLastName());
        this.hashColumns.put("per_title", getPerTitle());
        this.hashColumns.put("job_title", getJobTitle());
        this.hashColumns.put("pager_pin", getPagerPin());
        this.hashColumns.put("occupation", getOccupation());
        this.hashColumns.put("eye_color", getEyeColor());
        this.hashColumns.put("email_addr", getEmailAddr());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("con_manager_name", getConManagerName());
        this.hashColumns.put("work_ph_num", getWorkPhNum());
        this.hashColumns.put("fax_ph_num", getFaxPhNum());
        this.hashColumns.put("cell_ph_num", getCellPhNum());
        this.hashColumns.put("home_ph_num", getHomePhNum());
        this.hashColumns.put("hair_color", getHairColor());
        this.hashColumns.put("spouse_name", getSpouseName());
        this.hashColumns.put("birth_dt", getBirthDt());
        this.hashColumns.put("wed_anvrsry_dt", getWedAnvrsryDt());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("keyman_seq", "keymanSeq");
        this.hashFields.put("fst_name", "fstName");
        this.hashFields.put("last_name", "lastName");
        this.hashFields.put("per_title", "perTitle");
        this.hashFields.put("job_title", "jobTitle");
        this.hashFields.put("pager_pin", "pagerPin");
        this.hashFields.put("occupation", "occupation");
        this.hashFields.put("eye_color", "eyeColor");
        this.hashFields.put("email_addr", "emailAddr");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("con_manager_name", "conManagerName");
        this.hashFields.put("work_ph_num", "workPhNum");
        this.hashFields.put("fax_ph_num", "faxPhNum");
        this.hashFields.put("cell_ph_num", "cellPhNum");
        this.hashFields.put("home_ph_num", "homePhNum");
        this.hashFields.put("hair_color", "hairColor");
        this.hashFields.put("spouse_name", "spouseName");
        this.hashFields.put("birth_dt", "birthDt");
        this.hashFields.put("wed_anvrsry_dt", "wedAnvrsryDt");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
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
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 *
	 * @param String keymanSeq
	 */
    public void setKeymanSeq(String keymanSeq) {
        this.keymanSeq = keymanSeq;
    }

    /**
	 * 
	 * @return String keymanSeq
	 */
    public String getKeymanSeq() {
        return this.keymanSeq;
    }

    /**
	 *
	 * @param String fstName
	 */
    public void setFstName(String fstName) {
        this.fstName = fstName;
    }

    /**
	 * 
	 * @return String fstName
	 */
    public String getFstName() {
        return this.fstName;
    }

    /**
	 *
	 * @param String lastName
	 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
	 * 
	 * @return String lastName
	 */
    public String getLastName() {
        return this.lastName;
    }

    /**
	 *
	 * @param String perTitle
	 */
    public void setPerTitle(String perTitle) {
        this.perTitle = perTitle;
    }

    /**
	 * 
	 * @return String perTitle
	 */
    public String getPerTitle() {
        return this.perTitle;
    }

    /**
	 *
	 * @param String jobTitle
	 */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
	 * 
	 * @return String jobTitle
	 */
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
	 *
	 * @param String pagerPin
	 */
    public void setPagerPin(String pagerPin) {
        this.pagerPin = pagerPin;
    }

    /**
	 * 
	 * @return String pagerPin
	 */
    public String getPagerPin() {
        return this.pagerPin;
    }

    /**
	 *
	 * @param String occupation
	 */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
	 * 
	 * @return String occupation
	 */
    public String getOccupation() {
        return this.occupation;
    }

    /**
	 *
	 * @param String eyeColor
	 */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
	 * 
	 * @return String eyeColor
	 */
    public String getEyeColor() {
        return this.eyeColor;
    }

    /**
	 *
	 * @param String emailAddr
	 */
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    /**
	 * 
	 * @return String emailAddr
	 */
    public String getEmailAddr() {
        return this.emailAddr;
    }

    /**
	 *
	 * @param String srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * 
	 * @return String srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 *
	 * @param String conManagerName
	 */
    public void setConManagerName(String conManagerName) {
        this.conManagerName = conManagerName;
    }

    /**
	 * 
	 * @return String conManagerName
	 */
    public String getConManagerName() {
        return this.conManagerName;
    }

    /**
	 *
	 * @param String workPhNum
	 */
    public void setWorkPhNum(String workPhNum) {
        this.workPhNum = workPhNum;
    }

    /**
	 * 
	 * @return String workPhNum
	 */
    public String getWorkPhNum() {
        return this.workPhNum;
    }

    /**
	 *
	 * @param String faxPhNum
	 */
    public void setFaxPhNum(String faxPhNum) {
        this.faxPhNum = faxPhNum;
    }

    /**
	 * 
	 * @return String faxPhNum
	 */
    public String getFaxPhNum() {
        return this.faxPhNum;
    }

    /**
	 *
	 * @param String cellPhNum
	 */
    public void setCellPhNum(String cellPhNum) {
        this.cellPhNum = cellPhNum;
    }

    /**
	 * 
	 * @return String cellPhNum
	 */
    public String getCellPhNum() {
        return this.cellPhNum;
    }

    /**
	 *
	 * @param String homePhNum
	 */
    public void setHomePhNum(String homePhNum) {
        this.homePhNum = homePhNum;
    }

    /**
	 * 
	 * @return String homePhNum
	 */
    public String getHomePhNum() {
        return this.homePhNum;
    }

    /**
	 *
	 * @param String hairColor
	 */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
	 * 
	 * @return String hairColor
	 */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
	 *
	 * @param String spouseName
	 */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    /**
	 * 
	 * @return String spouseName
	 */
    public String getSpouseName() {
        return this.spouseName;
    }

    /**
	 *
	 * @param String birthDt
	 */
    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    /**
	 * 
	 * @return String birthDt
	 */
    public String getBirthDt() {
        return this.birthDt;
    }

    /**
	 *
	 * @param String wedAnvrsryDt
	 */
    public void setWedAnvrsryDt(String wedAnvrsryDt) {
        this.wedAnvrsryDt = wedAnvrsryDt;
    }

    /**
	 * 
	 * @return String wedAnvrsryDt
	 */
    public String getWedAnvrsryDt() {
        return this.wedAnvrsryDt;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
    }

    public String getCustLglEngNm() {
		return custLglEngNm;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setKeymanSeq(JSPUtil.getParameter(request, prefix + "keyman_seq", ""));
        setFstName(JSPUtil.getParameter(request, prefix + "fst_name", ""));
        setLastName(JSPUtil.getParameter(request, prefix + "last_name", ""));
        setPerTitle(JSPUtil.getParameter(request, prefix + "per_title", ""));
        setJobTitle(JSPUtil.getParameter(request, prefix + "job_title", ""));
        setPagerPin(JSPUtil.getParameter(request, prefix + "pager_pin", ""));
        setOccupation(JSPUtil.getParameter(request, prefix + "occupation", ""));
        setEyeColor(JSPUtil.getParameter(request, prefix + "eye_color", ""));
        setEmailAddr(JSPUtil.getParameter(request, prefix + "email_addr", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setConManagerName(JSPUtil.getParameter(request, prefix + "con_manager_name", ""));
        setWorkPhNum(JSPUtil.getParameter(request, prefix + "work_ph_num", ""));
        setFaxPhNum(JSPUtil.getParameter(request, prefix + "fax_ph_num", ""));
        setCellPhNum(JSPUtil.getParameter(request, prefix + "cell_ph_num", ""));
        setHomePhNum(JSPUtil.getParameter(request, prefix + "home_ph_num", ""));
        setHairColor(JSPUtil.getParameter(request, prefix + "hair_color", ""));
        setSpouseName(JSPUtil.getParameter(request, prefix + "spouse_name", ""));
        setBirthDt(JSPUtil.getParameter(request, prefix + "birth_dt", ""));
        setWedAnvrsryDt(JSPUtil.getParameter(request, prefix + "wed_anvrsry_dt", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        
        
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamKeyManInfoVO[]
	 */
    public SamKeyManInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamKeyManInfoVO[]
	 */
    public SamKeyManInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SamKeyManInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] keymanSeq = (JSPUtil.getParameter(request, prefix + "keyman_seq", length));
            String[] fstName = (JSPUtil.getParameter(request, prefix + "fst_name", length));
            String[] lastName = (JSPUtil.getParameter(request, prefix + "last_name", length));
            String[] perTitle = (JSPUtil.getParameter(request, prefix + "per_title", length));
            String[] jobTitle = (JSPUtil.getParameter(request, prefix + "job_title", length));
            String[] pagerPin = (JSPUtil.getParameter(request, prefix + "pager_pin", length));
            String[] occupation = (JSPUtil.getParameter(request, prefix + "occupation", length));
            String[] eyeColor = (JSPUtil.getParameter(request, prefix + "eye_color", length));
            String[] emailAddr = (JSPUtil.getParameter(request, prefix + "email_addr", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] conManagerName = (JSPUtil.getParameter(request, prefix + "con_manager_name", length));
            String[] workPhNum = (JSPUtil.getParameter(request, prefix + "work_ph_num", length));
            String[] faxPhNum = (JSPUtil.getParameter(request, prefix + "fax_ph_num", length));
            String[] cellPhNum = (JSPUtil.getParameter(request, prefix + "cell_ph_num", length));
            String[] homePhNum = (JSPUtil.getParameter(request, prefix + "home_ph_num", length));
            String[] hairColor = (JSPUtil.getParameter(request, prefix + "hair_color", length));
            String[] spouseName = (JSPUtil.getParameter(request, prefix + "spouse_name", length));
            String[] birthDt = (JSPUtil.getParameter(request, prefix + "birth_dt", length));
            String[] wedAnvrsryDt = (JSPUtil.getParameter(request, prefix + "wed_anvrsry_dt", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SamKeyManInfoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (keymanSeq[i] != null)
                    model.setKeymanSeq(keymanSeq[i]);
                if (fstName[i] != null)
                    model.setFstName(fstName[i]);
                if (lastName[i] != null)
                    model.setLastName(lastName[i]);
                if (perTitle[i] != null)
                    model.setPerTitle(perTitle[i]);
                if (jobTitle[i] != null)
                    model.setJobTitle(jobTitle[i]);
                if (pagerPin[i] != null)
                    model.setPagerPin(pagerPin[i]);
                if (occupation[i] != null)
                    model.setOccupation(occupation[i]);
                if (eyeColor[i] != null)
                    model.setEyeColor(eyeColor[i]);
                if (emailAddr[i] != null)
                    model.setEmailAddr(emailAddr[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (conManagerName[i] != null)
                    model.setConManagerName(conManagerName[i]);
                if (workPhNum[i] != null)
                    model.setWorkPhNum(workPhNum[i]);
                if (faxPhNum[i] != null)
                    model.setFaxPhNum(faxPhNum[i]);
                if (cellPhNum[i] != null)
                    model.setCellPhNum(cellPhNum[i]);
                if (homePhNum[i] != null)
                    model.setHomePhNum(homePhNum[i]);
                if (hairColor[i] != null)
                    model.setHairColor(hairColor[i]);
                if (spouseName[i] != null)
                    model.setSpouseName(spouseName[i]);
                if (birthDt[i] != null)
                    model.setBirthDt(birthDt[i]);
                if (wedAnvrsryDt[i] != null)
                    model.setWedAnvrsryDt(wedAnvrsryDt[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (prmryChkFlg[i] != null) 
		    		model.setPrmryChkFlg(prmryChkFlg[i]);
                if (custLglEngNm[i] != null) 
                	model.setCustLglEngNm(custLglEngNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSamKeyManInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SamKeyManInfoVO[]
	 */
    public SamKeyManInfoVO[] getSamKeyManInfoVOs() {
        SamKeyManInfoVO[] vos = (SamKeyManInfoVO[]) models.toArray(new SamKeyManInfoVO[models.size()]);
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
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keymanSeq = this.keymanSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fstName = this.fstName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastName = this.lastName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.perTitle = this.perTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jobTitle = this.jobTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerPin = this.pagerPin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.occupation = this.occupation.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eyeColor = this.eyeColor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emailAddr = this.emailAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.conManagerName = this.conManagerName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.workPhNum = this.workPhNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxPhNum = this.faxPhNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cellPhNum = this.cellPhNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.homePhNum = this.homePhNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hairColor = this.hairColor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spouseName = this.spouseName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.birthDt = this.birthDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wedAnvrsryDt = this.wedAnvrsryDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
