/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ReplanManageDBDAOSearchActualSCETerminalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.23 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchActualSCETerminalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, yard, turn vvd 등의 정보를 받아 이를 바탕으로 COP Replan 을 수행할 COP 를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchActualSCETerminalRSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchActualSCETerminalRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("	A.COP_NO AS COP_NO, " ).append("\n"); 
		query.append("	BKG_NO, " ).append("\n"); 
		query.append("	CNTR_NO, " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	CNMV_YR, " ).append("\n"); 
		query.append("	COP_STS_CD, " ).append("\n"); 
		query.append("	PCTL_NO, " ).append("\n"); 
		query.append("	MST_COP_NO, " ).append("\n"); 
		query.append("	TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT, " ).append("\n"); 
		query.append("	TRNK_VSL_CD, " ).append("\n"); 
		query.append("	TRNK_SKD_VOY_NO, " ).append("\n"); 
		query.append("	TRNK_SKD_DIR_CD, " ).append("\n"); 
		query.append("	POR_NOD_CD, " ).append("\n"); 
		query.append("	POL_NOD_CD, " ).append("\n"); 
		query.append("	POD_NOD_CD, " ).append("\n"); 
		query.append("	DEL_NOD_CD, " ).append("\n"); 
		query.append("	COP_RAIL_CHK_CD, " ).append("\n"); 
		query.append("	IB_TRO_FLG, " ).append("\n"); 
		query.append("	OB_TRO_FLG, " ).append("\n"); 
		query.append("	UMCH_STS_CD, " ).append("\n"); 
		query.append("	PROV_CNTR_NO, " ).append("\n"); 
		query.append("	PROV_CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT, " ).append("\n"); 
		query.append("	TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A," ).append("\n"); 
		query.append("  SCE_COP_DTL B" ).append("\n"); 
		query.append("WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("  AND B.VSL_CD IN (@[vsl_cd], @[turn_vsl_cd])" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO IN (@[skd_voy_no], @[turn_skd_voy_no])" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD IN (@[skd_dir_cd], @[turn_skd_dir_cd])" ).append("\n"); 
		query.append("  AND B.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("  AND DECODE(B.CLPT_IND_SEQ, '', 1, B.CLPT_IND_SEQ) = @[clpt_ind_seq]" ).append("\n"); 
		query.append("  AND B.ACT_CD IN ('FLVMLO'," ).append("\n"); 
		query.append("      'FLWMLO'," ).append("\n"); 
		query.append("      'FUVMUD'," ).append("\n"); 
		query.append("      'FUWMUD'," ).append("\n"); 
		query.append("      'FTVMLO'," ).append("\n"); 
		query.append("      'FTWMLO'," ).append("\n"); 
		query.append("      'FTVMUD'," ).append("\n"); 
		query.append("      'FTWMUD')" ).append("\n"); 
		query.append("  AND A.COP_STS_CD IN ('C'," ).append("\n"); 
		query.append("      'T'," ).append("\n"); 
		query.append("      'F')" ).append("\n"); 
		query.append("  AND ( ( " ).append("\n"); 
		query.append("@[vps_port_cd] != 'NLRTM'" ).append("\n"); 
		query.append("	 AND" ).append("\n"); 
		query.append(" NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM PRD_PORT_TML_EXPT E," ).append("\n"); 
		query.append("      PRD_PROD_CTL_ROUT_DTL T," ).append("\n"); 
		query.append("      SCE_COP_HDR H" ).append("\n"); 
		query.append("    WHERE E.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND E.PORT_CD IN ('KRPUS'," ).append("\n"); 
		query.append("          'DEHAM'," ).append("\n"); 
		query.append("          'NLRTM'," ).append("\n"); 
		query.append("          'BEANR')" ).append("\n"); 
		query.append("      AND E.TML_CD = @[nod_cd]" ).append("\n"); 
		query.append("      AND E.SKD_DIR_CD IN (@[skd_dir_cd], @[turn_skd_dir_cd])" ).append("\n"); 
		query.append("      AND E.VSL_SLAN_CD = (CASE WHEN @[nod_cd] LIKE 'KRPUS%' THEN T.VSL_SLAN_CD ELSE (CASE WHEN (" ).append("\n"); 
		query.append("                SELECT VSL_SVC_TP_CD" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                WHERE VSL_SLAN_CD=T.VSL_SLAN_CD) = 'O' THEN 'FDR' ELSE T.VSL_SLAN_CD END)END)" ).append("\n"); 
		query.append("      AND H.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("      AND T.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("      AND T.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND T.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND H.PCTL_NO = T.PCTL_NO ) )" ).append("\n"); 
		query.append("		 or ( @[vps_port_cd] = 'NLRTM'" ).append("\n"); 
		query.append("          and not exists (" ).append("\n"); 
		query.append("            select '1'" ).append("\n"); 
		query.append("            from prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("            where pctl_no = a.pctl_no" ).append("\n"); 
		query.append("              and trsp_mod_cd = 'WD'" ).append("\n"); 
		query.append("              AND (ORG_NOD_CD LIKE @[vps_port_cd] || '%'" ).append("\n"); 
		query.append("                  or DEST_NOD_CD like @[vps_port_cd] || '%')" ).append("\n"); 
		query.append("              and NVL(vsl_cd, 'SMXX') != @[vsl_cd]" ).append("\n"); 
		query.append("              and NVL(SKD_VOY_NO, '0000') != @[skd_voy_no]) ) )" ).append("\n"); 

	}
}