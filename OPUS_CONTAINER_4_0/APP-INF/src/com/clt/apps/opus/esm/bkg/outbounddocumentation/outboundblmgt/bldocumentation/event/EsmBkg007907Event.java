/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007907Event.java
*@FileTitle : C/M by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0079_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_07HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg007907Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CmVO cmVO = null;
	private CmVO[] cmVOS = null;

    private String bkgNo = null;
    private String bkgNoSplit = null;
    private String blNo = null;
    private String blTpCd = null;
    private String cntrNo = null;
    private String pckTpCd = null;
    private String hsCd = null;
    private String hsAplyDt = null;
    private String hamoTpCd = null;

	public EsmBkg007907Event(){}


    /**
     *
     * @return
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     *
     * @return
     */
    public String getBlTpCd() {
        return blTpCd;
    }
    
    /**
    *
    * @return
    */
   public String getHsCd() {
       return hsCd;
   }
   
   /**
   *
   * @return
   */
  public String getHsAplyDt() {
      return hsAplyDt;
  }
  
  /**
  *
  * @return
  */
 public String getHamoTpCd() {
     return hamoTpCd;
 }

    /**
     *
     * @return
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     *
     * @return
     */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

    /**
     *
     * @return
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     *
     * @return
     */
    public String getBkgNoSplit() {
        return bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     *
     * @return
     */
    public void setBkgNoSplit(String bkgNoSplit) {
        this.bkgNoSplit = bkgNoSplit;
    }

    /**
     *
     * @return
     */
    public String getCntrNo(){
        return cntrNo;
    }

    /**
     *
     * @param cntrNo
     */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }
    
    /**
    *
    * @return
    */
   public String getPckTpCd(){
       return pckTpCd;
   }

   /**
    *
    * @param pckTpCd
    */
   public void setPckTpCd(String pckTpCd) {
       this.pckTpCd = pckTpCd;
   }
   
   /**
   *
   * @param hsCd
   */
  public void setHsCd(String hsCd) {
      this.hsCd = hsCd;
  }
  
  /**
  *
  * @param hsAplyDt
  */
 public void setHsAplyDt(String hsAplyDt) {
     this.hsAplyDt = hsAplyDt;
 }
 
 /**
 *
 * @param hamoTpCd
 */
public void setHamoTpCd(String hamoTpCd) {
    this.hamoTpCd = hamoTpCd;
}

    /**
     *
     * @param cmVO
     */
	public void setCmVO(CmVO cmVO){
		this. cmVO = cmVO;
	}

	/**
	 *
	 * @return
	 */
	public CmVO getCmVO(){
		return cmVO;
	}


	public CmVO[] getCmVOS() {
		CmVO[] rtnVOs = null;
		if (this.cmVOS != null) {
			rtnVOs = Arrays.copyOf(cmVOS, cmVOS.length);
		}
		return rtnVOs;
	}


	public void setCmVOS(CmVO[] cmVOS) {
		if (cmVOS != null) {
			CmVO[] tmpVOs = Arrays.copyOf(cmVOS, cmVOS.length);
			this.cmVOS = tmpVOs;
		}
	}


}