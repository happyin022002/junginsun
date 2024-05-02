/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0004Event.java
*@FileTitle : Entry and Inquiry of Basic Port Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.20 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.hanjin.syscommon.common.table.JooStlBssPortVO;


/**
 * FNS_JOO_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstComInputVO mstComInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MstComInputVO[] mstComInputVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooStlBssPortVO jooStlBssPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooStlBssPortVO[] jooStlBssPortVOs = null;

	/** ABBR*/
	private String joStlItmCd = null;
	
	/** Dir*/
	private String skdDirCd = null;

	public FnsJoo0004Event(){}
	
	public void setMstComInputVO(MstComInputVO mstComInputVO){
		this. mstComInputVO = mstComInputVO;
	}

	public void setMstComInputVOS(MstComInputVO[] mstComInputVOs){
		if (mstComInputVOs != null) {
			MstComInputVO[] tmpVOs = new MstComInputVO[mstComInputVOs.length];
			System.arraycopy(mstComInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mstComInputVOs = tmpVOs;
		}				
	}

	public void setJooStlBssPortVO(JooStlBssPortVO jooStlBssPortVO){
		this. jooStlBssPortVO = jooStlBssPortVO;
	}

	public void setJooStlBssPortVOS(JooStlBssPortVO[] jooStlBssPortVOs){
		if (jooStlBssPortVOs != null) {
			JooStlBssPortVO[] tmpVOs = new JooStlBssPortVO[jooStlBssPortVOs.length];
			System.arraycopy(jooStlBssPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooStlBssPortVOs = tmpVOs;
		}		
	}

	public MstComInputVO getMstComInputVO(){
		return mstComInputVO;
	}

	public MstComInputVO[] getMstComInputVOS(){
		MstComInputVO[] rtnVOs = null;
		if (this.mstComInputVOs != null) {
			rtnVOs = new MstComInputVO[mstComInputVOs.length];
			System.arraycopy(mstComInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public JooStlBssPortVO getJooStlBssPortVO(){
		return jooStlBssPortVO;
	}

	public JooStlBssPortVO[] getJooStlBssPortVOS(){
		JooStlBssPortVO[] rtnVOs = null;
		if (this.jooStlBssPortVOs != null) {
			rtnVOs = new JooStlBssPortVO[jooStlBssPortVOs.length];
			System.arraycopy(jooStlBssPortVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;				
	}

	public String getJoStlItmCd() {
		return joStlItmCd;
	}

	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
}