/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPS, TAS TRADE GROUP 에 대해서 미주로 출발하는 마지막 PORT 일 경우, 미주 지역의 SKD를 조회한다.
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchPodArrVslSkdHisTgtRSQL").append("\n"); 
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
		query.append("SELECT BB.VSL_CD," ).append("\n"); 
		query.append("  BB.SKD_VOY_NO," ).append("\n"); 
		query.append("  BB.SKD_DIR_CD," ).append("\n"); 
		query.append("  BB.VPS_PORT_CD," ).append("\n"); 
		query.append("  BB.CLPT_IND_SEQ," ).append("\n"); 
		query.append("  C.TRD_CD," ).append("\n"); 
		query.append("  TO_CHAR(BB.VPS_ETA_DT, 'YYYY/MM/DD HH24:MI:SS') AS VPS_ETA_DT," ).append("\n"); 
		query.append("  TO_CHAR(BB.VPS_ETB_DT, 'YYYY/MM/DD HH24:MI:SS') AS VPS_ETB_DT," ).append("\n"); 
		query.append("  TO_CHAR(BB.VPS_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') AS VPS_ETD_DT," ).append("\n"); 
		query.append("  A.ACT_RCV_DT," ).append("\n"); 
		query.append("  A.ACT_RCV_NO," ).append("\n"); 
		query.append("  TO_CHAR(A.ACT_DT, 'YYYY/MM/DD HH24:MI:SS') AS ACT_DEP_DT," ).append("\n"); 
		query.append("  A.VPS_PORT_CD AS LST_POL_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT /*+ INDEX_DESC (SCE_ACT_RCV_IF XPKSCE_ACT_RCV_IF) */" ).append("\n"); 
		query.append("      ACT_RCV_DT," ).append("\n"); 
		query.append("      ACT_RCV_NO," ).append("\n"); 
		query.append("      BKG_NO," ).append("\n"); 
		query.append("      CNTR_NO," ).append("\n"); 
		query.append("      ACT_DT," ).append("\n"); 
		query.append("      ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("      NOD_CD," ).append("\n"); 
		query.append("      ACT_RCV_TP_CD," ).append("\n"); 
		query.append("      COP_RLT_FLG," ).append("\n"); 
		query.append("      ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("      UMCH_CHK_DT," ).append("\n"); 
		query.append("      VSL_CD," ).append("\n"); 
		query.append("      SKD_VOY_NO," ).append("\n"); 
		query.append("      SKD_DIR_CD," ).append("\n"); 
		query.append("      VPS_PORT_CD," ).append("\n"); 
		query.append("      CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM SCE_ACT_RCV_IF" ).append("\n"); 
		query.append("    WHERE ACT_RCV_TP_CD = '2'" ).append("\n"); 
		query.append("      AND ACT_RCV_DT = TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("      AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND ACT_STS_MAPG_CD = 'ATD'" ).append("\n"); 
		query.append("      AND NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("      AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) A," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT VSL_CD," ).append("\n"); 
		query.append("      SKD_VOY_NO," ).append("\n"); 
		query.append("      SKD_DIR_CD," ).append("\n"); 
		query.append("      VPS_PORT_CD," ).append("\n"); 
		query.append("      CLPT_IND_SEQ," ).append("\n"); 
		query.append("      CLPT_SEQ," ).append("\n"); 
		query.append("      SLAN_CD," ).append("\n"); 
		query.append("      YD_CD," ).append("\n"); 
		query.append("      LEAD(YD_CD) OVER (" ).append("\n"); 
		query.append("        ORDER BY CLPT_SEQ) AS NEXT_PORT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT VSL_CD," ).append("\n"); 
		query.append("              SKD_VOY_NO," ).append("\n"); 
		query.append("              SKD_DIR_CD," ).append("\n"); 
		query.append("              VPS_PORT_CD," ).append("\n"); 
		query.append("              CLPT_IND_SEQ," ).append("\n"); 
		query.append("              CLPT_SEQ," ).append("\n"); 
		query.append("              SLAN_CD," ).append("\n"); 
		query.append("              YD_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("            WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("              AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("              AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("                    SELECT '1'" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND SKD.VPS_PORT_CD IN (POL_CD, POD_CD)" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("	) VSK" ).append("\n"); 
		query.append("    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = @[skd_dir_cd] ) B," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD BB," ).append("\n"); 
		query.append("  MDM_DTL_REV_LANE C," ).append("\n"); 
		query.append("  MDM_LOCATION EVNT_LOC," ).append("\n"); 
		query.append("  MDM_LOCATION DEST_LOC," ).append("\n"); 
		query.append("  MDM_LOCATION CK_LOC" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.NOD_CD = B.YD_CD" ).append("\n"); 
		query.append("  AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND B.VSL_CD = BB.VSL_CD" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND B.CLPT_SEQ < BB.CLPT_SEQ" ).append("\n"); 
		query.append("  AND B.SLAN_CD = SUBSTR(C.RLANE_CD, 0, 3)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = C.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("  AND C.TO_CONTI_CD = 'M'" ).append("\n"); 
		query.append("  AND C.TRD_CD IN ('TPS', 'TAS')" ).append("\n"); 
		query.append("  AND A.VPS_PORT_CD = EVNT_LOC.LOC_CD" ).append("\n"); 
		query.append("  AND BB.VPS_PORT_CD = DEST_LOC.LOC_CD" ).append("\n"); 
		query.append("  AND CK_LOC.LOC_CD = SUBSTR(B.NEXT_PORT, 0, 5)" ).append("\n"); 
		query.append("  AND CK_LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("  AND EVNT_LOC.CONTI_CD != 'M'" ).append("\n"); 
		query.append("  AND DEST_LOC.CONTI_CD = 'M'" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT '1' FROM SCE_POD_ARR_VSL_SKD_HIS WHERE VSL_CD = BB.VSL_CD AND SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND SKD_DIR_CD = BB.SKD_DIR_CD AND VPS_PORT_CD = BB.VPS_PORT_CD AND CLPT_IND_SEQ = BB.CLPT_IND_SEQ)" ).append("\n"); 

	}
}