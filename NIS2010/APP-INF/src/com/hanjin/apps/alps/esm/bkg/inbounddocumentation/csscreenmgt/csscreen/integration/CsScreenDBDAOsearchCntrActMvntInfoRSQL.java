/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrActMvntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.16
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.10.16 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrActMvntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inbound C/S Screen 화면의 Movement 탭에서 사용하는 SQL문이다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrActMvntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchCntrActMvntInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO        " ).append("\n"); 
		query.append("      ,CNTR_NO         " ).append("\n"); 
		query.append("      ,TPSZ_CD         " ).append("\n"); 
		query.append("      ,ACT_NM || DECODE(VVD,NULL,'','(' ||VVD|| ')' ) LST_EVENT " ).append("\n"); 
		query.append("      ,TO_CHAR(EVENT_DT, 'YYYY-MM-DD HH24:MI') EVENT_DT " ).append("\n"); 
		query.append("      ,NOD_NM || '(' ||NOD_CD|| ')' NOD_CD " ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("      SELECT CNTR.BKG_NO                                                   BKG_NO   -- 하단 상세 내역을 조회하기 위한 값      " ).append("\n"); 
		query.append("            ,CNTR.CNTR_NO                                                  CNTR_NO        " ).append("\n"); 
		query.append("            ,CNTR.CNTR_TPSZ_CD                                             TPSZ_CD       " ).append("\n"); 
		query.append("            ,STS.MVMT_STS_NM                                               ACT_NM       " ).append("\n"); 
		query.append("            ,MVNT.CRNT_VSL_CD||MVNT.CRNT_SKD_VOY_NO ||MVNT.CRNT_SKD_DIR_CD VVD       " ).append("\n"); 
		query.append("            ,MVNT.CNMV_EVNT_DT                                             EVENT_DT  " ).append("\n"); 
		query.append("            ,MVNT.INP_YD_CD                                                NOD_CD       " ).append("\n"); 
		query.append("            ,YD.YD_NM                                                      NOD_NM       " ).append("\n"); 
		query.append("			  ,TO_NUMBER(MVNT.CNMV_YR||LPAD(MVNT.CNMV_SEQ,4,0))              CNMV_STS               " ).append("\n"); 
		query.append("            ,MAX(TO_NUMBER(MVNT.CNMV_YR||LPAD(MVNT.CNMV_SEQ,4,0))) OVER (PARTITION BY CNTR.BKG_NO, CNTR.CNTR_NO ) MAX_CNMV_STS       " ).append("\n"); 
		query.append("      FROM BKG_CONTAINER CNTR       " ).append("\n"); 
		query.append("          ,CTM_MOVEMENT MVNT       " ).append("\n"); 
		query.append("          ,MDM_MVMT_STS  STS       " ).append("\n"); 
		query.append("          ,MDM_YARD YD       " ).append("\n"); 
		query.append("      WHERE CNTR.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND MVNT.CNTR_NO = CNTR.CNTR_NO       " ).append("\n"); 
		query.append("        AND MVNT.BKG_NO LIKE SUBSTR(CNTR.BKG_NO,1,10)||'%'" ).append("\n"); 
		query.append("        AND MVNT.MVMT_STS_CD = STS.MVMT_STS_CD        " ).append("\n"); 
		query.append("        AND YD.YD_CD(+) = MVNT.INP_YD_CD       " ).append("\n"); 
		query.append(") WHERE CNMV_STS= MAX_CNMV_STS" ).append("\n"); 

	}
}