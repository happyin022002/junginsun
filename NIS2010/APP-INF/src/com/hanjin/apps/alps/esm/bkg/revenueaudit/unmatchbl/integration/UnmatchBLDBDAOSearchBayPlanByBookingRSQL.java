/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchBayPlanByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchBayPlanByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG별 Bay Plan을 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchBayPlanByBookingRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchBayPlanByBookingRSQL").append("\n"); 
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
		query.append("SELECT VVD, POL_CD, POD_CD, CNTR_NO, POSITION," ).append("\n"); 
		query.append("       VSL_PRE_PST_CD, VSL_SEQ," ).append("\n"); 
		query.append("       SUM (CASE WHEN ACT_SLOT <> '' THEN TO_NUMBER(ACT_SLOT)" ).append("\n"); 
		query.append("                 WHEN x * y * z > 0  THEN (x + 1) * (y + 1) * (z + 1) - s" ).append("\n"); 
		query.append("                 WHEN x * y > 0      THEN (x + 1) * (y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN x * z > 0      THEN (x + 1) * (z + 1) - 1 + x * (s - 1)" ).append("\n"); 
		query.append("                 WHEN y * z > 0      THEN (y + 1) * (z + 1) - 1 + y * (s - 1)" ).append("\n"); 
		query.append("                 WHEN x + y > 0      THEN (x + y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN z > 0          THEN z" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("             END / 2" ).append("\n"); 
		query.append("             ) AS VOID_VOL," ).append("\n"); 
		query.append("      '' BKG_NO" ).append("\n"); 
		query.append("FROM (  SELECT BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("               BP.POL POL_CD, " ).append("\n"); 
		query.append("               BP.POD POD_CD, " ).append("\n"); 
		query.append("               BP.ID CNTR_NO, " ).append("\n"); 
		query.append("               BP.BAY||'-'||BP.ROWW||'-'||BP.TIER POSITION," ).append("\n"); 
		query.append("               NVL (OVP_SLOT, 0) + NVL (OVS_SLOT, 0) AS X," ).append("\n"); 
		query.append("               NVL (OVH_SLOT, 0) AS Y," ).append("\n"); 
		query.append("               NVL (OVA_SLOT, 0) + NVL (OVF_SLOT, 0) AS Z," ).append("\n"); 
		query.append("               (2 - MOD (BAY, 2)) AS S," ).append("\n"); 
		query.append("               ACT_SLOT," ).append("\n"); 
		query.append("               BV.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("               BV.VSL_SEQ" ).append("\n"); 
		query.append("        FROM BKG_VVD BV, BKG_CONTAINER BC, BAY_PLAN BP" ).append("\n"); 
		query.append("        WHERE BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND BV.VSL_CD = BP.VSL_CD" ).append("\n"); 
		query.append("        AND BV.SKD_VOY_NO = BP.VOY_NO" ).append("\n"); 
		query.append("        AND BV.SKD_DIR_CD = BP.DIR_CD" ).append("\n"); 
		query.append("        AND BV.POL_CD = BP.PORT_CD" ).append("\n"); 
		query.append("        AND BV.POL_CD = BP.POL" ).append("\n"); 
		query.append("        AND BV.POL_CLPT_IND_SEQ = BP.CALL_IND" ).append("\n"); 
		query.append("        AND BP.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("        AND BC.CNTR_NO = BP.ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VVD, POL_CD, POD_CD, CNTR_NO, POSITION," ).append("\n"); 
		query.append("         VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}