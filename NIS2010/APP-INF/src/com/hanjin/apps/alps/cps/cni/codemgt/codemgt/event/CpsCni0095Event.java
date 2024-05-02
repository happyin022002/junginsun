/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0095Event.java
 *@FileTitle : Main Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2009.10.05 이준범 
 * 1.0 Creation
 * ----------------------------------------------------------
 * History
 * 2010.12.10 이준범 [CHM-201007236-01]
 * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
 * 2.처리내역
 *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
 *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
 *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완  
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0095] Main Code Creation
 * @author choijungmi
 * @see CPS_CNI_0095HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* CLAIM PARTY NUMBER */
    private String clmPtyNo;
    
    private String clmPtyAbbrNm;
    
    private String ptyNm;

	/* Party Container VO */
    private PartyCntVO partyCntVO;
    

	public PartyCntVO getPartyCntVO() {
		return partyCntVO;
	}

	public void setPartyCntVO(PartyCntVO partyCntVO) {
		this.partyCntVO = partyCntVO;
	}

	/**                                                                
     * CLAIM PARTY NUMBER 취득
     * @return CLAIM PARTY NUMBER
     */                                                                
    public String getClmPtyNo() {                    
        return clmPtyNo;                                        
    }                     
    
    /**                                                                
     * CLAIM PARTY NUMBER 설정
     * @param clmPtyNo CLAIM PARTY NUMBER
     */                                                                
    public void setClmPtyNo(String clmPtyNo) {
        this.clmPtyNo = clmPtyNo;                        
    }  
    
    public String getClmPtyAbbrNm() {
		return clmPtyAbbrNm;
	}

	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
	}    
	
	public String getPtyNm() {
		return ptyNm;
	}

	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}

}