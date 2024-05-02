/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AwkCgoApplVO.java
*@FileTitle : AwkCgoApplVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이병규
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class AwkCgoApplVO {

    private static final long serialVersionUID = 1L;

    private Collection<AwkCgoApplVO> models = new ArrayList<AwkCgoApplVO>();

    /* Column Info */
    private List<BkgAwkCgoVO> bkgAwkCgo = null;
    /* Column Info */
    private List<BkgAwkDimVO> bkgAwkDim = null;
    /* Column Info */
    private List<CntrTypzQtyVO> cntrTypzQty = null;
    /* Column Info */
    private List<AwkBkgInfoVO> awkBkgInfo = null;
    /* Column Info */
    private List<CntrComboVO> cntrCombo = null;    
    /* Column Info */
    private AwkAproInfoVO awkAproInfo = null;
    /* Column Info */
    private BkgBlNoVO bkgBlNo = null;
    /* Status */
    private String ibflag = null;
    /* Page Number */
    private String pagerows = null;
    /* Column Info */
    private String updUsrId = null;
    /* Column Info */
    private String creUsrId = null;
    /* Column Info */
    private String bkgNo = null;
    /* Column Info */
    private BkgAwkCgoVO[] bkgAwkCgoVOs = null;
    /* Column Info */
    private BkgAwkDimVO[] bkgAwkDimVOs = null;   
    /* Column Info */
    private SignOnUserAccount account = null;
    /* Column Info */
    private String uiId = null;
    
	public AwkCgoApplVO() {}

    /**
     * Status
     * @return ibflag
     */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
     * Page Number
     * @return pagerows
     */
    public String getPagerows() {
        return this.pagerows;
    }


    /**
     @param ibflag the ibflag to set
     */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
     * @param pagerows the pagerows to set
     */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
     *
     * @return updUsrId
     */
    public String getUpdUsrId() {
        return updUsrId;
    }

    /**
     *
     * @param updUsrId the updUsrId to set
     */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
     *
     * @return creUsrId
     */
    public String getCreUsrId() {
        return creUsrId;
    }

    /**
     *
     * @param creUsrId the creUsrId to set
     */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
     *
     * @return bkgAwkCgo
     */
    public List<BkgAwkCgoVO> getBkgAwkCgoVO() {
        return bkgAwkCgo;
    }

    /**
     *
     * @param bkgAwkCgo the bkgAwkCgo to set
     */
    public void setBkgAwkCgo(List<BkgAwkCgoVO> bkgAwkCgo) {
        this.bkgAwkCgo = bkgAwkCgo;
    }


    /**
     *
     * @return bkgBlNo
     */
    public BkgBlNoVO getBkgBlNo() {
        return bkgBlNo;
    }

    /**
     *
     * @param bkgBlNo the bkgBlNo to set
     */
    public void setBkgBlNo(BkgBlNoVO bkgBlNo) {
        this.bkgBlNo = bkgBlNo;
    }

    /**
     *
     * @return bkgAwkDim
     */
    public List<BkgAwkDimVO> getBkgAwkDim() {
        return bkgAwkDim;
    }

    /**
     *
     * @param bkgAwkDim the bkgAwkDim to set
     */
    public void setBkgAwkDim(List<BkgAwkDimVO> bkgAwkDim) {
        this.bkgAwkDim = bkgAwkDim;
    }

    /**
     *
     * @return cntrTypzQty
     */
    public List<CntrTypzQtyVO> getCntrTypzQty() {
        return cntrTypzQty;
    }

    /**
     *
     * @param cntrTypzQty the cntrTypzQty to set
     */
    public void setCntrTypzQty(List<CntrTypzQtyVO> cntrTypzQty) {
        this.cntrTypzQty = cntrTypzQty;
    }

    /**
	 * @return the awkBkgInfo
	 */
	public List<AwkBkgInfoVO> getAwkBkgInfo() {
		return awkBkgInfo;
	}

	/**
	 * @param awkBkgInfo the awkBkgInfo to set
	 */
	public void setAwkBkgInfo(List<AwkBkgInfoVO> awkBkgInfo) {
		this.awkBkgInfo = awkBkgInfo;
	}

	/**
	 * @return the awkAproInfo
	 */
	public AwkAproInfoVO getAwkAproInfo() {
		return awkAproInfo;
	}

	/**
	 * @param list the awkAproInfo to set
	 */
	public void setAwkAproInfo(AwkAproInfoVO awkAproInfo) {
		this.awkAproInfo = awkAproInfo;
	}

	/**
     * 여러 VO Calss를 배열화 한다
     * @return CntrInfoOutVO[]
     */
    public AwkCgoApplVO[] getCntrInfoOutVOs(){
    	AwkCgoApplVO[] vos = (AwkCgoApplVO[])models.toArray(new AwkCgoApplVO[models.size()]);
        return vos;
    }



    /**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}



	/**
	 * @return the bkgcombo
	 */
	public List<CntrComboVO> getCntrCombo() {
		return cntrCombo;
	}

	/**
	 * @param bkgcombo the bkgcombo to set
	 */
	public void setCntrCombo(List<CntrComboVO> cntrCombo) {
		this.cntrCombo = cntrCombo;
	}



	/**
	 * @return the bkgAwkCgoVOs
	 */
	public BkgAwkCgoVO[] getBkgAwkCgoVOs() {
		return bkgAwkCgoVOs;
	}

	/**
	 * @param bkgAwkCgoVOs the bkgAwkCgoVOs to set
	 */
	public void setBkgAwkCgoVOs(BkgAwkCgoVO[] bkgAwkCgoVOs) {
		this.bkgAwkCgoVOs = bkgAwkCgoVOs;
	}

	/**
	 * @return the bkgAwkDimVOs
	 */
	public BkgAwkDimVO[] getBkgAwkDimVOs() {
		return bkgAwkDimVOs;
	}

	/**
	 * @param bkgAwkDimVOs the bkgAwkDimVOs to set
	 */
	public void setBkgAwkDimVOs(BkgAwkDimVO[] bkgAwkDimVOs) {
		this.bkgAwkDimVOs = bkgAwkDimVOs;
	}


	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	/**
	 * @return the uiId
	 */
    public String getUiId() {
		return uiId;
	}

	/**
	 * @param uiId the uiId to set
	 */
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}

	/**
     * VO Class의 내용을 String으로 변환
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try{
            for(int i = 0; i < field.length; i++){
                String[] arr = null;
                arr = getField(field, i);
                if(arr != null){
                    for(int j = 0; j < arr.length; j++) {
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
     * 각 클래스 해당하는 필드 정보를 배열에 담는다
     * @param field
     * @param i
     * @return String[]
     */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try{
            arr = (String[]) field[i].get(this);
        }catch(Exception ex){
            arr = getFieldCatct(field, i, arr);
        }
        return arr;
    }

    /**
     * getField 에서 catch문에 대한 로직
     * @param field
     * @param i
     * @param arr
     * @return arr
     */
    private String[] getFieldCatct(Field[] field, int i, String[] arr) {
        try {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        } catch (IllegalAccessException e) {
            return null;
        }
        return arr;
    }

}
