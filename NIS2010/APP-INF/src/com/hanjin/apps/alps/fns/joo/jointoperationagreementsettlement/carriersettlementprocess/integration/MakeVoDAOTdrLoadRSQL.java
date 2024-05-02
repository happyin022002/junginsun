/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MakeVoDAOTdrLoadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.05.08 김창헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOTdrLoadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History --------------------------------------------------------
	  * 2010.12.07 김상수 [CHM-201007318-01] JOO - TDR Inquiry 기능 보완 요청 - i-stowage 연계
	  *                    1. 조회조건에 Carrier Code를 Multi Select 할 수 있는 멀티콤보 추가
	  *                    2. Sheet에 컬럼 추가
	  *                      (※ Data 조회 Logic 보완)
	  *                      - 기존처럼  해당 VVD 와 Port를 선정할때  Upload Status가  N (증빙 가)일 경우
	  *                         해당 정보(20’, 40’, 20HC, 40HC, 45, AK, RF, EMPTY)를 I-Stowage에서 조회
	  *                      - Source 컬럼 추가
	  *                         OPF : OPF 모듈에서  Data 조회
	  *                         IST : I-Stowage에서 Data 조회
	  * 2012.05.08 김창헌 [CHM-201217413-01]
	  *                    [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
	  *                    - Sum 기능 추가, 정렬순서 및 표시형식 변경
	  * </pre>
	  */
	public MakeVoDAOTdrLoadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOTdrLoadRSQL").append("\n"); 
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
		query.append("SELECT '' AS VVD," ).append("\n"); 
		query.append("       '' AS OPR_CD," ).append("\n"); 
		query.append("       '' AS VSL_CD," ).append("\n"); 
		query.append("       '' AS SKD_VOY_NO," ).append("\n"); 
		query.append("       '' AS SKD_DIR_CD," ).append("\n"); 
		query.append("       '' AS VPS_PORT_CD," ).append("\n"); 
		query.append("       '' AS SLAN_CD," ).append("\n"); 
		query.append("       '' AS VPS_ETD_DT," ).append("\n"); 
		query.append("       '' AS ALL_TEU," ).append("\n"); 
		query.append("       '' AS ALL_WGT," ).append("\n"); 
		query.append("       '' AS GRAND_TTL_SLOT," ).append("\n"); 
		query.append("       '' AS GRAND_TTL_WGT," ).append("\n"); 
		query.append("       '' AS OVER_SLOT," ).append("\n"); 
		query.append("       '' AS OVER_WGT," ).append("\n"); 
		query.append("       '' AS HC_LD_20," ).append("\n"); 
		query.append("       '' AS HC_LD_40," ).append("\n"); 
		query.append("       '' AS HC_LD_45," ).append("\n"); 
		query.append("       '' AS RF_20_QTY," ).append("\n"); 
		query.append("       '' AS RF_40_QTY," ).append("\n"); 
		query.append("       '' AS PRE_FR," ).append("\n"); 
		query.append("       '' AS PRE_TO," ).append("\n"); 
		query.append("       '' AS RLANE_CD," ).append("\n"); 
		query.append("       '' AS JO_RGN_CD," ).append("\n"); 
		query.append("       '' AS SUPER_CD1," ).append("\n"); 
		query.append("       '' AS MT_TEU," ).append("\n"); 
		query.append("       '' AS HC_BSA_20," ).append("\n"); 
		query.append("       '' AS HC_BSA_40," ).append("\n"); 
		query.append("       '' AS HC_BSA_45," ).append("\n"); 
		query.append("       '' AS FULL_20," ).append("\n"); 
		query.append("       '' AS MT_20," ).append("\n"); 
		query.append("       '' AS FULL_40," ).append("\n"); 
		query.append("       '' AS MT_40," ).append("\n"); 
		query.append("       '' AS MT_WT," ).append("\n"); 
		query.append("       '' AS AK_UNIT," ).append("\n"); 
		query.append("       '' AS AK_VOID," ).append("\n"); 
		query.append("       '' AS SOURCE," ).append("\n"); 
		query.append("       '' AS SUM_FLG" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}