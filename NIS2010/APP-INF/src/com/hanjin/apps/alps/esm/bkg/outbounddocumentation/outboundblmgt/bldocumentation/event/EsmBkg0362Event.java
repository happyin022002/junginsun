/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0362Event.java
*@FileTitle : VIN no input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 조정민
*@LastVersion : 1.0

* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0362 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0362HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0362HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0362Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */

    private String bkgNo = null;
    private String vinNoList = null;


	public EsmBkg0362Event(){}

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
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }


    /**
     *
     * @return
     */
    public String getVinNoList() {
        return vinNoList;
    }

    /**
     *
     * @return
     */
    public void setVinNoList(String vinNoList) {
        this.vinNoList = vinNoList;
    }



}