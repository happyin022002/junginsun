/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoVskInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoVskInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoVskInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoVskInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoVskInfoRSQL").append("\n"); 
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
		query.append("SELECT MAX(VPS_ETD_DT) AS VPS_ETD_DT, " ).append("\n"); 
		query.append("       MAX(VPS_ETD_DT_GMT) AS VPS_ETD_DT_GMT," ).append("\n"); 
		query.append("       MAX(INIT_ETD_DT) AS INIT_ETD_DT," ).append("\n"); 
		query.append("       MAX(INIT_ETD_DT_GMT) AS INIT_ETD_DT_GMT," ).append("\n"); 
		query.append("       MAX(VPS_ETA_DT) AS VPS_ETA_DT," ).append("\n"); 
		query.append("       MAX(VPS_ETA_DT_GMT) AS VPS_ETA_DT_GMT," ).append("\n"); 
		query.append("       MAX(INIT_ETA_DT) AS INIT_ETA_DT," ).append("\n"); 
		query.append("       MAX(INIT_ETA_DT_GMT) AS INIT_ETA_DT_GMT," ).append("\n"); 
		query.append("       DECODE(@[pod_cd],@[del_cd],MAX(VPS_ETA_DT)," ).append("\n"); 
		query.append("              TO_CHAR(TO_DATE(MAX(VPS_ETA_DT),'YYYYMMDDHH24MI')+MAX(RAIL_HOUR),'YYYYMMDDHH24MI')) AS FINAL_ETA_DT," ).append("\n"); 
		query.append("       DECODE(@[pod_cd],@[del_cd],MAX(VPS_ETA_DT_GMT)," ).append("\n"); 
		query.append("              TO_CHAR(TO_DATE(MAX(VPS_ETA_DT_GMT),'YYYYMMDDHH24MI')+MAX(RAIL_HOUR),'YYYYMMDDHH24MI')) AS FINAL_ETA_DT_GMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (       " ).append("\n"); 
		query.append("        SELECT NVL(TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI'), ' ') VPS_ETD_DT," ).append("\n"); 
		query.append("               NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VPS_PORT_CD,VPS_ETD_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ')  VPS_ETD_DT_GMT," ).append("\n"); 
		query.append("               DECODE(SKD_CNG_STS_CD,'S',' ',NVL(TO_CHAR(INIT_ETD_DT, 'YYYYMMDDHH24MI'), ' ')) INIT_ETD_DT," ).append("\n"); 
		query.append("               DECODE(SKD_CNG_STS_CD,'S',' ',NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VPS_PORT_CD,INIT_ETD_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ')) INIT_ETD_DT_GMT," ).append("\n"); 
		query.append("               '' VPS_ETA_DT," ).append("\n"); 
		query.append("               '' VPS_ETA_DT_GMT," ).append("\n"); 
		query.append("               '' INIT_ETA_DT," ).append("\n"); 
		query.append("               '' INIT_ETA_DT_GMT," ).append("\n"); 
		query.append("               '' FINAL_ETA_DT," ).append("\n"); 
		query.append("               '' FINAL_ETA_DT_GMT," ).append("\n"); 
		query.append("               0  RAIL_HOUR" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO   = @[skd_voy_no] " ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]     " ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = '1'   " ).append("\n"); 
		query.append("           AND VPS_PORT_CD  = @[pol_cd]" ).append("\n"); 
		query.append("           AND ROWNUM       = 1" ).append("\n"); 
		query.append("        UNION ALL   " ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               NVL(TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ')," ).append("\n"); 
		query.append("               NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VPS_PORT_CD,VPS_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' ')," ).append("\n"); 
		query.append("               DECODE(SKD_CNG_STS_CD,'S',' ',NVL(TO_CHAR(INIT_ETA_DT, 'YYYYMMDDHH24MI'), ' '))," ).append("\n"); 
		query.append("               DECODE(SKD_CNG_STS_CD,'S',' ',NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(VPS_PORT_CD,INIT_ETA_DT,'GMT' ), 'YYYYMMDDHH24MI'), ' '))," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               0" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD       = @[vsl_cd] " ).append("\n"); 
		query.append("           AND SKD_VOY_NO   = @[skd_voy_no] " ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]    " ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = '1'   " ).append("\n"); 
		query.append("           AND VPS_PORT_CD  = @[pod_cd] " ).append("\n"); 
		query.append("           AND ROWNUM       = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               TO_CHAR(FINAL_ETA, 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("               NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(POD_CD,FINAL_ETA,'GMT' ), 'YYYYMMDDHH24MI'), ' ')," ).append("\n"); 
		query.append("               0" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT MAX(BK.POD_CD) POD_CD, " ).append("\n"); 
		query.append("                       NVL(MAX(DECODE(DTL.ACT_STS_MAPG_CD,'IC',DTL.ESTM_DT)),MAX(DECODE(DTL.ACT_STS_MAPG_CD,'ID',DTL.ESTM_DT))) FINAL_ETA" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("                       SCE_COP_HDR HDR," ).append("\n"); 
		query.append("                       SCE_COP_DTL DTL" ).append("\n"); 
		query.append("                 WHERE BK.BL_NO   = @[bl_no] " ).append("\n"); 
		query.append("                   AND BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("                   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               NVL(SUM(C.TZTM_HRS)/24,0)" ).append("\n"); 
		query.append("          FROM PRD_INLND_ROUT_MST A," ).append("\n"); 
		query.append("               PRD_INLND_ROUT_DTL B," ).append("\n"); 
		query.append("               PRD_INLND_EACH_LNK C" ).append("\n"); 
		query.append("         WHERE (A.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                A.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                A.ROUT_SEQ) = (" ).append("\n"); 
		query.append("                                SELECT B.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                                       B.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                                       B.ROUT_SEQ" ).append("\n"); 
		query.append("                                  FROM PRD_PROD_CTL_MST A," ).append("\n"); 
		query.append("                                       PRD_PROD_CTL_ROUT_DTL B" ).append("\n"); 
		query.append("                                 WHERE A.PCTL_NO = (SELECT PCTL_NO" ).append("\n"); 
		query.append("                                                      FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                                     WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("                                   AND A.PCTL_NO = B.PCTL_NO" ).append("\n"); 
		query.append("                                   AND B.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                   AND B.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("           AND A.ROUT_ORG_NOD_CD  = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND A.ROUT_SEQ         = B.ROUT_SEQ                  " ).append("\n"); 
		query.append("           AND B.LNK_ORG_NOD_CD   = C.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND B.LNK_DEST_NOD_CD  = C.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND B.TRSP_MOD_CD      = C.TRSP_MOD_CD" ).append("\n"); 
		query.append("           AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}