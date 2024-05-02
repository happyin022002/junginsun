/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MakeVODAORdrLoadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAORdrLoadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
	  *                   1. 보완 대상
	  *                      가. 조회  Option
	  *                         - Region Multi 선택
	  *                         - Carrier 추가 - Multi 선택
	  *                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
	  *                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
	  *                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
	  *                      마. 기타 : 컬럼별 계산 Logic 수정
	  * </pre>
	  */
	public MakeVODAORdrLoadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVODAORdrLoadRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT '' AS ACT_SLOT," ).append("\n"); 
		query.append("       '' AS ACT_WGT," ).append("\n"); 
		query.append("       '' AS ADJUST_TEU," ).append("\n"); 
		query.append("       '' AS ADJUST_WT," ).append("\n"); 
		query.append("       '' AS ALC_ALLOC," ).append("\n"); 
		query.append("       '' AS ALC_WGT," ).append("\n"); 
		query.append("       '' AS BSA_45," ).append("\n"); 
		query.append("       '' AS BSA_HC20," ).append("\n"); 
		query.append("       '' AS BSA_HC40," ).append("\n"); 
		query.append("       '' AS DIR_CD," ).append("\n"); 
		query.append("       '' AS EMPTY_TEU," ).append("\n"); 
		query.append("       '' AS EMPTY_WT," ).append("\n"); 
		query.append("       '' AS JO_RF_IPT_QTY," ).append("\n"); 
		query.append("       '' AS JO_RF_OCN_QTY," ).append("\n"); 
		query.append("       '' AS JO_SHRT_LEG_RMK_DIFF_QTY," ).append("\n"); 
		query.append("       '' AS JO_SHRT_LEG_RMK_TEU_QTY," ).append("\n"); 
		query.append("       '' AS JO_SHRT_LEG_RMK_WGT," ).append("\n"); 
		query.append("       '' AS JO_SLT_RLSE_CD," ).append("\n"); 
		query.append("       '' AS JO_VOID_TEU_QTY," ).append("\n"); 
		query.append("       '' AS LOAD_20," ).append("\n"); 
		query.append("       '' AS LOAD_40," ).append("\n"); 
		query.append("       '' AS LOAD_45," ).append("\n"); 
		query.append("       '' AS OPR_CD," ).append("\n"); 
		query.append("       '' AS OVER_SLOT," ).append("\n"); 
		query.append("       '' AS OVER_WGT," ).append("\n"); 
		query.append("       '' AS PORT_CD," ).append("\n"); 
		query.append("       '' AS PRE_FR," ).append("\n"); 
		query.append("       '' AS PRE_TO," ).append("\n"); 
		query.append("       '' AS REGION," ).append("\n"); 
		query.append("       '' AS REMARK," ).append("\n"); 
		query.append("       '' AS REMARK_CONT," ).append("\n"); 
		query.append("       '' AS RLANE_CD," ).append("\n"); 
		query.append("       '' AS R_I," ).append("\n"); 
		query.append("       '' AS R_O," ).append("\n"); 
		query.append("       '' AS SUPER_CD1," ).append("\n"); 
		query.append("       '' AS SWAP_SLOT," ).append("\n"); 
		query.append("       '' AS SWAP_WGT," ).append("\n"); 
		query.append("       '' AS USR_ID," ).append("\n"); 
		query.append("       '' AS VOY_NO," ).append("\n"); 
		query.append("       '' AS VPS_ETD_DT," ).append("\n"); 
		query.append("       '' AS VSL_CD," ).append("\n"); 
		query.append("       '' AS VVD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}