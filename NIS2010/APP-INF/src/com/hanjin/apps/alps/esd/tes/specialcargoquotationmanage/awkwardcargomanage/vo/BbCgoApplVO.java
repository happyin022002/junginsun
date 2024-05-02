/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BbCgoApplVO.java
*@FileTitle : BbCgoApplVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo;

import java.lang.reflect.Field;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이혜민
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class BbCgoApplVO {

    private static final long serialVersionUID = 1L;


    /* Column Info */
    private List<BkgBbCgoVO> bkgBbCgoVO = null;    
    /* Column Info */
    private List<CntrTypzQtyVO> cntrTypzQty = null;   
    /* Column Info */
    private List<BbCntrListVO> bbCntrListVO = null;
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
    private String ovrVoidSltQty = null;
    /* Column Info */
    private BkgBbCgoVO[] bkgBbCgoVOs = null; 
    /* Column Info */
    private BbCntrListVO[] bbCntrListVOs = null; 
    /* Column Info */
    private SignOnUserAccount account = null;

    public BbCgoApplVO() {}


	/**
	 * @return the bkgBbCgoVO
	 */
	public List<BkgBbCgoVO> getBkgBbCgoVO() {
		return bkgBbCgoVO;
	}

	/**
	 * @param bkgBbCgoVO the bkgBbCgoVO to set
	 */
	public void setBkgBbCgoVO(List<BkgBbCgoVO> bkgBbCgoVO) {
		this.bkgBbCgoVO = bkgBbCgoVO;
	}

	/**
	 * @return the cntrTypzQty
	 */
	public List<CntrTypzQtyVO> getCntrTypzQty() {
		return cntrTypzQty;
	}

	/**
	 * @param cntrTypzQty the cntrTypzQty to set
	 */
	public void setCntrTypzQty(List<CntrTypzQtyVO> cntrTypzQty) {
		this.cntrTypzQty = cntrTypzQty;
	}

	/**
	 * @return the bkgBlNo
	 */
	public BkgBlNoVO getBkgBlNo() {
		return bkgBlNo;
	}

	/**
	 * @param bkgBlNo the bkgBlNo to set
	 */
	public void setBkgBlNo(BkgBlNoVO bkgBlNo) {
		this.bkgBlNo = bkgBlNo;
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
	 * @return the bkgBbCgoVOs
	 */
	public BkgBbCgoVO[] getBkgBbCgoVOs() {
		return bkgBbCgoVOs;
	}

	/**
	 * @param bkgBbCgoVOs the bkgBbCgoVOs to set
	 */
	public void setBkgBbCgoVOs(BkgBbCgoVO[] bkgBbCgoVOs) {
		this.bkgBbCgoVOs = bkgBbCgoVOs;
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
	 * @return the ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return ovrVoidSltQty;
	}

	/**
	 * @param ovrVoidSltQty the ovrVoidSltQty to set
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}	
	
	/**
	 * @return the bbCntrListVO
	 */
	public List<BbCntrListVO> getBbCntrListVO() {
		return bbCntrListVO;
	}

	/**
	 * @param bbCntrListVO the bbCntrListVO to set
	 */
	public void setBbCntrListVO(List<BbCntrListVO> bbCntrListVO) {
		this.bbCntrListVO = bbCntrListVO;
	}
	
	/**
	 * @return the bbCntrListVOs
	 */
	public BbCntrListVO[] getBbCntrListVOs() {
		return bbCntrListVOs;
	}

	/**
	 * @param bbCntrListVOs the bbCntrListVOs to set
	 */
	public void setBbCntrListVOs(BbCntrListVO[] bbCntrListVOs) {
		this.bbCntrListVOs = bbCntrListVOs;
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
