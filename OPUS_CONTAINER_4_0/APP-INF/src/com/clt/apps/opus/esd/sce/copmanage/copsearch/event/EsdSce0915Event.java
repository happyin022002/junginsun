/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0915Event.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.Collection;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BKG_BKG_VVD;
import com.clt.syscommon.common.table.SCE_COP_HDR;


/**
 *  1. 기능 : EsdSce0915 에 대한 PDTO(Data Transfer Object including Parameters) <p>
 *  2. 처리개요 : <p>
 *    - EsdSce0915HTMLAction에서 작성 <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 *  @author Se-Hoon PARK
 *  @version v1.0.0
 *  @see HTMLAction 참조
 *  @since J2EE 1.4
 **/
@SuppressWarnings("rawtypes")
public class EsdSce0915Event extends EventSupport {
	private static final long serialVersionUID = 1L;

    /** sce_cop_hdr Table  Value Object */
    private SCE_COP_HDR sceCopHdr = null;

    /** sceCopHdrs Multi Action을 위한 Collection */
    private Collection sceCopHdrs = null;
    
    COPInquiryVO copInquiryVO = null;
    
    BookingInfoVO[] bookingInfoVOs = null;
    BKG_BKG_VVD[] bkgVVDs = null;
    
    /** EsdSce0915Event operation 주석 */
    
    public EsdSce0915Event(){}

    
    /** EsdSce0915Event operation 주석 */
    /**
	 * 생성자
	 * @param sceCopHdr
	 */
    public EsdSce0915Event(SCE_COP_HDR sceCopHdr) {
    	this.sceCopHdr = sceCopHdr;
    }

    /** EsdSce0915Event operation 주석 */

    public SCE_COP_HDR getSCE_COP_HDR(){
        return sceCopHdr;
    }

    /** EsdSce0915Event operation 주석 */

    public Collection getSCE_COP_HDRS(){
        return sceCopHdrs;
    }

    /** EsdSce0915Event operation 주석 */

    public String getEventName() {
        return "EsdSce0915Event";
    }

    /** EsdSce0915Event operation 주석 */

    public String toString() {
        return "EsdSce0915Event";
    }
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setCopInquiryVO(COPInquiryVO copInquiryVO){
		this.copInquiryVO = copInquiryVO;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public COPInquiryVO getCopInquiryVO(){
		return copInquiryVO;
	} 
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setBookingInfoVOs(BookingInfoVO[] bookingInfoVOs){
		this.bookingInfoVOs = bookingInfoVOs;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public BookingInfoVO[] getBookingInfoVOs(){
		return bookingInfoVOs;
	} 	
	
	/**
	 * 조회조건 저장
	 * @param conditionVO
	 */
	public void setBkgVVDs(BKG_BKG_VVD[] bkgVVDs){
		this.bkgVVDs = bkgVVDs;
	}
	/**
	 * 조회조건 반환
	 * @return
	 */
	public BKG_BKG_VVD[] getBkgVVDs(){
		return bkgVVDs;
	} 	

}
