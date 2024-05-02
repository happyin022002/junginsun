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

public class SpclCgoAproApplVO {

    private static final long serialVersionUID = 1L;

    private Collection<SpclCgoAproApplVO> models = new ArrayList<SpclCgoAproApplVO>();

    
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
    private String spclCgoTp = null;    
    /* Column Info */
    private SpclReqInVO[] spclReqInVOs = null;
    /* Column Info */
    private SignOnUserAccount account = null;


    
    
	/**
	 * @return the models
	 */
	public Collection<SpclCgoAproApplVO> getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public void setModels(Collection<SpclCgoAproApplVO> models) {
		this.models = models;
	}

	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @return the spclCgoTp
	 */
	public String getSpclCgoTp() {
		return spclCgoTp;
	}

	/**
	 * @param spclCgoTp the spclCgoTp to set
	 */
	public void setSpclCgoTp(String spclCgoTp) {
		this.spclCgoTp = spclCgoTp;
	}

	/**
	 * @return the spclReqInVOs
	 */
	public SpclReqInVO[] getSpclReqInVOs() {
		return spclReqInVOs;
	}

	/**
	 * @param spclReqInVOs the spclReqInVOs to set
	 */
	public void setSpclReqInVOs(SpclReqInVO[] spclReqInVOs) {
		this.spclReqInVOs = spclReqInVOs;
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
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
