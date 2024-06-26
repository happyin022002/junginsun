/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0001Event.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 2009.02.26 - 안정선 - CSR NO. N200902030014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
* 2009.09.03 - 오현경  - NIS2010 Construction
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import java.util.Collection;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdSce0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0001Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
	private Collection sceCopHdrs = null;
	private SearchCOPMainListVO[] mainListVOs = null;

	private String vvd = "";
	private String nod = "";
	private String port = "";
    COPInquiryVO conditionVO = null;
	/**
	 * EsdSce0001Event에서 SCE_COP_HDR 데이터 타입의 매개변수
	 */
	public void setSCECOPHDRS(Collection sceCopHdrs) {
		this.sceCopHdrs = sceCopHdrs;
	}

	/**
	 * @return Returns sceCopHdrs.
	 */

	public Collection getSCECOPHDRS() {
		return sceCopHdrs;
	}
	/**
	 * EsdSce0001Event에서 SCE_COP_HDR 데이터 타입의 매개변수
	 */
	public void setMainListVOs(SearchCOPMainListVO[] mainListVOs) {
		this.mainListVOs = mainListVOs;
	}
	public void setMainListVOs(SearchCOPMainListVO[] mainListVOs, String usrId){
		this.mainListVOs = mainListVOs;
		if(mainListVOs != null){
			for(int i=0; i<mainListVOs.length; i++){
				mainListVOs[i].setCreUsrId(usrId);
				mainListVOs[i].setUpdUsrId(usrId);	
			}
		}
	}	
	
	/**
	 * @return Returns sceCopHdrs.
	 */

	public SearchCOPMainListVO[] getMainListVOs() {
		return mainListVOs;
	}	
	/**
	 * @return Returns the port.
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port The port to set.
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return Returns the nod.
	 */
	public String getNod() {
		return nod;
	}

	/**
	 * @param nod The nod to set.
	 */
	public void setNod(String nod) {
		this.nod = nod;
	}

	/**
	 * @return Returns the vvd.
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd The vvd to set.
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
     * 생성자<br>
     */
    public EsdSce0001Event() {

    }

    /**
     * 이벤트 명(EsdSce0001Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdSce0001Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0001Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdSce0001Event";
    }

	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setConditionVO(COPInquiryVO conditionVO){
		this.conditionVO = conditionVO;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public COPInquiryVO getConditionVO(){
		return conditionVO;
	}    
}
