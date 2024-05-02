/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetTierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetTierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD의 해당 YARD의 SURCHARGE 계산을 위한 TIER 값을 조회
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetTierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetTierRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN RNK='Y' THEN" ).append("\n"); 
		query.append("            TIER_1ST" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            TIER_2ND" ).append("\n"); 
		query.append("       END SCG_CAR_TIER" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	ROW_NUMBER () OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS SEQ" ).append("\n"); 
		query.append("				--, VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND" ).append("\n"); 
		query.append("				, DECODE(SIGN(TEU - 11), -1, 'N', 'Y') AS RNK" ).append("\n"); 
		query.append("				, TIER_NO AS TIER_1ST				" ).append("\n"); 
		query.append("				, LEAD (TIER_NO) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TIER_2ND" ).append("\n"); 
		query.append("				, TEU AS TEU_1ST" ).append("\n"); 
		query.append("				, LEAD (TEU) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TEU_2ND				" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND" ).append("\n"); 
		query.append("						, TIER_NO AS TIER_NO" ).append("\n"); 
		query.append("						, MAX(MAX_TIER_BY_BAY) AS TIER_ORG" ).append("\n"); 
		query.append("						, SUM(CASE WHEN (TIER = MAX_TIER_BY_BAY) THEN TEU ELSE 0 END) AS TEU" ).append("\n"); 
		query.append("				FROM	(	" ).append("\n"); 
		query.append("							SELECT	T1.VSL_CD" ).append("\n"); 
		query.append("									, T1.VOY_NO" ).append("\n"); 
		query.append("									, T1.DIR_CD" ).append("\n"); 
		query.append("									, T1.PORT_CD" ).append("\n"); 
		query.append("									, T1.CALL_IND" ).append("\n"); 
		query.append("									, T1.PLAN_TYPE" ).append("\n"); 
		query.append("									, T1.BAY" ).append("\n"); 
		query.append("									, T1.TIER									" ).append("\n"); 
		query.append("									, MAX(T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS MAX_TIER_BY_BAY" ).append("\n"); 
		query.append("									, COUNT (DISTINCT T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS TIER_NO							" ).append("\n"); 
		query.append("									, SUM( CASE WHEN T1.SZTP LIKE 'D2%' THEN 1 ELSE 2 END ) AS TEU" ).append("\n"); 
		query.append("									, ROW_NUMBER () OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY, T1.TIER ORDER BY T1.TIER DESC, T1.PLAN_TYPE DESC) AS PLAN_TYPE_SEQ 						" ).append("\n"); 
		query.append("							FROM	BAY_PLAN T1" ).append("\n"); 
		query.append("							WHERE	1 = 1				" ).append("\n"); 
		query.append("							AND		(T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND) IN " ).append("\n"); 
		query.append("							        ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                                       select /*+ INDEX_DESC(T2 XAK12VSK_BUD_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("							            t2.vsl_cd, t2.skd_voy_no, t2.skd_dir_cd, t2.vps_port_cd, t2.clpt_ind_seq" ).append("\n"); 
		query.append("							            from vsk_bud_vsl_port_skd t1, vsk_bud_vsl_port_skd t2" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                                       select /*+ INDEX_DESC(T2 XAK12VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("							            t2.vsl_cd, t2.skd_voy_no, t2.skd_dir_cd, t2.vps_port_cd, t2.clpt_ind_seq" ).append("\n"); 
		query.append("							            from vsk_vsl_port_skd t1, vsk_vsl_port_skd t2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							           where t1.vsl_cd = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("							             and t1.skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("							             and t1.skd_dir_cd = substr(@[vvd], 9)" ).append("\n"); 
		query.append("							             and t1.vps_port_cd = substr(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("							             and t1.vsl_cd = t2.vsl_cd" ).append("\n"); 
		query.append("							             and t1.skd_voy_no = t2.skd_voy_no" ).append("\n"); 
		query.append("							             and t1.skd_dir_cd = t2.skd_dir_cd" ).append("\n"); 
		query.append("							             and t1.clpt_seq > t2.clpt_seq" ).append("\n"); 
		query.append("							             and nvl(t2.skd_cng_sts_cd, 'X') <> 'S'" ).append("\n"); 
		query.append("							             and rownum = 1 )" ).append("\n"); 
		query.append("							AND		T1.TIER		>= '50'" ).append("\n"); 
		query.append("							GROUP BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.PLAN_TYPE, T1.BAY, T1.TIER" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				WHERE	PLAN_TYPE_SEQ	= 1		" ).append("\n"); 
		query.append("				GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, TIER_NO	" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) T1, VSK_PORT_CNL_TR_SCG T2" ).append("\n"); 
		query.append("WHERE	T2.LOC_CD		= substr(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("AND		T2.TR_SEQ		= DECODE(RNK, 'Y', TIER_1ST, TIER_2ND) " ).append("\n"); 
		query.append("AND		T1.SEQ			= 1" ).append("\n"); 

	}
}