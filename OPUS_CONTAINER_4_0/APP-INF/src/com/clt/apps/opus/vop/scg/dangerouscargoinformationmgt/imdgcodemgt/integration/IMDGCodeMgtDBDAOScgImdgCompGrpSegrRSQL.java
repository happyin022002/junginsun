/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOScgImdgCompGrpSegrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.28 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOScgImdgCompGrpSegrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgImdgCompGrpSegr 조회
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOScgImdgCompGrpSegrRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("'A' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'A'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'B' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'B'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'C' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'C'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'D' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'D'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'E' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'F' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'F'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'G' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'G'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'H' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'J' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'J'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'K' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'K'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'L' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'L'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'N' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'S' AS ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_A) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_B) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_C) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_D) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_E) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_F) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_G) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_H) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_J) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_K) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_L) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_N) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   MAX(SEGR_CD_S) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'A',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_A" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'B',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_B" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'C',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_C" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'D',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_D" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'E',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_E" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'F',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_F" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'G',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_G" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'H',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_H" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'J',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_J" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'K',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_K" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'L',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_L" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'N',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_N" ).append("\n"); 
		query.append(",   DECODE(COL_IMDG_COMP_GRP_CD,'S',IMDG_SEGR_CD||IMDG_SEGR_NTC_NO) AS SEGR_CD_S" ).append("\n"); 
		query.append("FROM SCG_IMDG_COMP_GRP_SEGR" ).append("\n"); 
		query.append("WHERE ROW_IMDG_COMP_GRP_CD = 'S'" ).append("\n"); 
		query.append(")" ).append("\n"); 
//		query.append("where IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration ").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOScgImdgCompGrpSegrRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}