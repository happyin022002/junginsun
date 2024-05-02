/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0107Event.java
*@FileTitle : JO Settlement Status Information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;


/**
 * FNS_JOO_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private StlStsVO stlStsVO = null;

	/** Table Value Object Multi Data 처리 */
	private StlStsVO[] stlStsVOs = null;
	
//	private String rlaneCd = "";	
//	
//	private String in_vsl_cd = "";
//	private String in_skd_voy_no = "";
//	private String in_skd_dir_cd = "";
	
	public FnsJoo0107Event(){}
	
	public void setStlStsVO(StlStsVO stlStsVO){		
		this. stlStsVO = stlStsVO;
	}

	public StlStsVO getStlStsVO(){
		return stlStsVO;
	}

	public StlStsVO[] getStlStsVOs() {
		
		StlStsVO[] rtnVOs = null;
		if (this.stlStsVOs != null) {
			rtnVOs = new StlStsVO[stlStsVOs.length];
			System.arraycopy(stlStsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setStlStsVOs(StlStsVO[] stlStsVOs) {
		if (stlStsVOs != null) {
			StlStsVO[] tmpVOs = new StlStsVO[stlStsVOs.length];
			System.arraycopy(stlStsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlStsVOs = tmpVOs;
		}						
	}
	
//	public String getRlaneCd() {
//		return rlaneCd;
//	}
//
//	public void setRlaneCd(String rlaneCd) {
//		this.rlaneCd = rlaneCd;
//	}
//
//	public String getIn_vsl_cd() {
//		return in_vsl_cd;
//	}
//
//	public void setIn_vsl_cd(String in_vsl_cd) {
//		this.in_vsl_cd = in_vsl_cd;
//	}
//
//	public String getIn_skd_voy_no() {
//		return in_skd_voy_no;
//	}
//
//	public void setIn_skd_voy_no(String in_skd_voy_no) {
//		this.in_skd_voy_no = in_skd_voy_no;
//	}
//
//	public String getIn_skd_dir_cd() {
//		return in_skd_dir_cd;
//	}
//
//	public void setIn_skd_dir_cd(String in_skd_dir_cd) {
//		this.in_skd_dir_cd = in_skd_dir_cd;
//	}	
}