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

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이병규
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class DgCgoApplVO {

    private static final long serialVersionUID = 1L;

    private Collection<AwkCgoApplVO> models = new ArrayList<AwkCgoApplVO>();

    /* Column Info */
    private List<BkgDgCgoInfoVO> bkgDgCgoInfo = null;
    /* Column Info */
    private List<DgCgoListVO> DgCgoList = null;
    /* Column Info */
    private List<CntrInfoListVO> cntrInfoList = null;
    /* Column Info */
    private List<CntrTypzQtyVO> cntrTypzQty = null;
    /* Column Info */    
    private List<DgBkgInfoVO> dgBkgInfo = null;
    /* Column Info */    
    private List<CntrComboVO> cntrCombo = null;
    /* Column Info */
    private DgAproInfoVO dgAproInfo = null;
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
    private List<DgPackageVO> dgPackage = null;
    /* Column Info */
    private List<ScgImdgUnNoVO> scgImdgUnNo = null;
    /* Column Info */
    private BkgAwkDimVO[] dgPackageVOs = null;
    /* Column Info */
    private BkgDgCgoInfoVO[] bkgDgCgoInfoVOs = null;
    /* Column Info */
    private DgCgoListVO[] dgCgoListVOs = null;
    /* Column Info */
    private CntrInfoListVO[] cntrInfoListVOs = null;
    /* Column Info */
    private SignOnUserAccount account = null;
	/* Column Info */
    private String uiId = null;



    public DgCgoApplVO() {}

    
    
	/**
	 * @return the models
	 */
	public Collection<AwkCgoApplVO> getModels() {
		return models;
	}



	/**
	 * @param models the models to set
	 */
	public void setModels(Collection<AwkCgoApplVO> models) {
		this.models = models;
	}



	/**
	 * @return the bkgDgCgoInfo
	 */
	public List<BkgDgCgoInfoVO> getBkgDgCgoInfo() {
		return bkgDgCgoInfo;
	}



	/**
	 * @param bkgDgCgoInfo the bkgDgCgoInfo to set
	 */
	public void setBkgDgCgoInfo(List<BkgDgCgoInfoVO> bkgDgCgoInfo) {
		this.bkgDgCgoInfo = bkgDgCgoInfo;
	}



	/**
	 * @return the cntrInfoList
	 */
	public List<CntrInfoListVO> getCntrInfoList() {
		return cntrInfoList;
	}



	/**
	 * @param cntrInfoList the cntrInfoList to set
	 */
	public void setCntrInfoList(List<CntrInfoListVO> cntrInfoList) {
		this.cntrInfoList = cntrInfoList;
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
	 * @return the dgBkgInfo
	 */
	public List<DgBkgInfoVO> getDgBkgInfo() {
		return dgBkgInfo;
	}



	/**
	 * @param dgBkgInfo the dgBkgInfo to set
	 */
	public void setDgBkgInfo(List<DgBkgInfoVO> dgBkgInfo) {
		this.dgBkgInfo = dgBkgInfo;
	}



	/**
	 * @return the cntrCombo
	 */
	public List<CntrComboVO> getCntrCombo() {
		return cntrCombo;
	}



	/**
	 * @param bkgcombo the cntrCombo to set
	 */
	public void setCntrCombo(List<CntrComboVO> cntrCombo) {
		this.cntrCombo = cntrCombo;
	}



	/**
	 * @return the dgAproInfo
	 */
	public DgAproInfoVO getDgAproInfo() {
		return dgAproInfo;
	}



	/**
	 * @param dgAproInfo the dgAproInfo to set
	 */
	public void setDgAproInfo(DgAproInfoVO dgAproInfo) {
		this.dgAproInfo = dgAproInfo;
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
	 * @return the bkgDgCgoInfoVOs
	 */
	public BkgDgCgoInfoVO[] getBkgDgCgoInfoVOs() {
		return bkgDgCgoInfoVOs;
	}



	/**
	 * @param bkgDgCgoInfoVOs the bkgDgCgoInfoVOs to set
	 */
	public void setBkgDgCgoInfoVOs(BkgDgCgoInfoVO[] bkgDgCgoInfoVOs) {
		this.bkgDgCgoInfoVOs = bkgDgCgoInfoVOs;
	}



	/**
	 * @return the cntrInfoListVOs
	 */
	public CntrInfoListVO[] getCntrInfoListVOs() {
		return cntrInfoListVOs;
	}



	/**
	 * @param cntrInfoListVOs the cntrInfoListVOs to set
	 */
	public void setCntrInfoListVOs(CntrInfoListVO[] cntrInfoListVOs) {
		this.cntrInfoListVOs = cntrInfoListVOs;
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
	
	

    public String getUiId() {
		return uiId;
	}



	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	/**
	 * @return the dgCgoList
	 */
	public List<DgCgoListVO> getDgCgoList() {
		return DgCgoList;
	}



	/**
	 * @param dgCgoList the dgCgoList to set
	 */
	public void setDgCgoList(List<DgCgoListVO> dgCgoList) {
		DgCgoList = dgCgoList;
	}



	/**
	 * @return the dgCgoListVOs
	 */
	public DgCgoListVO[] getDgCgoListVOs() {
		return dgCgoListVOs;
	}



	/**
	 * @param dgCgoListVOs the dgCgoListVOs to set
	 */
	public void setDgCgoListVOs(DgCgoListVO[] dgCgoListVOs) {
		this.dgCgoListVOs = dgCgoListVOs;
	}



	/**
     * 여러 VO Calss를 배열화 한다
     * @return CntrInfoOutVO[]
     */
    public DgCgoApplVO[] getCntrInfoOutVOs(){
    	DgCgoApplVO[] vos = (DgCgoApplVO[])models.toArray(new DgCgoApplVO[models.size()]);
        return vos;
    }
    
    

	/**
	 * @return the dgPackage
	 */
	public List<DgPackageVO> getDgPackage() {
		return dgPackage;
	}



	/**
	 * @param dgPackage the dgPackage to set
	 */
	public void setDgPackage(List<DgPackageVO> dgPackage) {
		this.dgPackage = dgPackage;
	}



	/**
	 * @return the dgPackageVOs
	 */
	public BkgAwkDimVO[] getDgPackageVOs() {
		return dgPackageVOs;
	}



	/**
	 * @param dgPackageVOs the dgPackageVOs to set
	 */
	public void setDgPackageVOs(BkgAwkDimVO[] dgPackageVOs) {
		this.dgPackageVOs = dgPackageVOs;
	}
	
	
	
	/**
	 * @return the scgImdgUnNo
	 */
	public List<ScgImdgUnNoVO> getScgImdgUnNo() {
		return scgImdgUnNo;
	}



	/**
	 * @param scgImdgUnNo the scgImdgUnNo to set
	 */
	public void setScgImdgUnNo(List<ScgImdgUnNoVO> scgImdgUnNo) {
		this.scgImdgUnNo = scgImdgUnNo;
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
