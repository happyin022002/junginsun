/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoRlseListVO.java
*@FileTitle : IdaDoRlseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaDoRlseReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적에 대한  Summary 정보 관리  */
	private List<IdaDoWeeklyReportVO> idaDoWeeklyReportVO;
	
	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적 정보 관리 */ 
	private List<IdaDoRlseListVO> idaDoRlseListVO;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoRlseReportVO() {}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return this.hashFields;
	}

	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적에 대한  Summary 정보 관리  */
	public List<IdaDoWeeklyReportVO> getIdaDoWeeklyReportVO() {
		return idaDoWeeklyReportVO;
	}

	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적에 대한  Summary 정보 관리  */
	public void setIdaDoWeeklyReportVO(List<IdaDoWeeklyReportVO> idaDoWeeklyReportVO) {
		this.idaDoWeeklyReportVO = idaDoWeeklyReportVO;
	}

	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적 정보 관리 */
	public List<IdaDoRlseListVO> getIdaDoRlseListVO() {
		return idaDoRlseListVO;
	}

	/** Indian Office의 DMDT Payment Type별  D/O 발행 실적 정보 관리 */
	public void setIdaDoRlseListVO(List<IdaDoRlseListVO> idaDoRlseListVO) {
		this.idaDoRlseListVO = idaDoRlseListVO;
	}
	
}
