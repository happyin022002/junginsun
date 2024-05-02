/**
 *
 */
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 및 관련 vo들을 모두 담는 역활을 수행하는 Value Object
 * SpclRiderOutVO
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SpclRiderOutVO {

	private List<SpclRiderVO> 		o_spclRiderVO		= null;//sheet0 = 결과값 List로 리턴받기
	private List<SpclCntrListVO> 	o_spclCntrListVO	= null;//sheet0 = 결과값 List로 리턴받기

	/**
	 * @return the o_spclRiderVO
	 */
	public List<SpclRiderVO> getO_spclRiderVO() {
		return o_spclRiderVO;
	}
	/**
	 * @param riderVO the o_spclRiderVO to set
	 */
	public void setO_spclRiderVO(List<SpclRiderVO> riderVO) {
		o_spclRiderVO = riderVO;
	}
	/**
	 * @return the o_spclCntrListVO
	 */
	public List<SpclCntrListVO> getO_spclCntrListVO() {
		return o_spclCntrListVO;
	}
	/**
	 * @param cntrListVO the o_spclCntrListVO to set
	 */
	public void setO_spclCntrListVO(List<SpclCntrListVO> cntrListVO) {
		o_spclCntrListVO = cntrListVO;
	}

}
