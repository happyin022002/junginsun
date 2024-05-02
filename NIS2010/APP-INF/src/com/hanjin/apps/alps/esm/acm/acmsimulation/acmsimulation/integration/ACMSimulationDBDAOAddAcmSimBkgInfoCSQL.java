/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimBkgInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimBkgInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSimBkgInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimBkgInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_ar",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ar",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_finc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ar",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimBkgInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_BKG_INFO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SIM_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BL_NO_TP" ).append("\n"); 
		query.append(",BL_TP_CD" ).append("\n"); 
		query.append(",BKG_STS_CD" ).append("\n"); 
		query.append(",BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",BL_CVRD_TP_CD" ).append("\n"); 
		query.append(",CHN_BKG_AGN_CD" ).append("\n"); 
		query.append(",BKG_OFC_CD" ).append("\n"); 
		query.append(",CLT_OFC_CD" ).append("\n"); 
		query.append(",BKG_CRE_DT" ).append("\n"); 
		query.append(",BDR_FLG" ).append("\n"); 
		query.append(",BDR_DT" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",POR_AR_OFC_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",POL_AR_OFC_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",POD_AR_OFC_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",DEL_AR_OFC_CD" ).append("\n"); 
		query.append(",BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",REV_VVD_CD" ).append("\n"); 
		query.append(",TRNK_SLAN_CD" ).append("\n"); 
		query.append(",TRNK_RLANE_CD" ).append("\n"); 
		query.append(",TRNK_VSL_CD" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",TRNK_REV_DIR_CD" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",PRE_PORT_CD" ).append("\n"); 
		query.append(",PST_PORT_CD" ).append("\n"); 
		query.append(",COMM_PROC_RSLT_RSN" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  @[sim_no]" ).append("\n"); 
		query.append(", B.BKG_NO" ).append("\n"); 
		query.append(", B.BL_NO" ).append("\n"); 
		query.append(", B.BL_NO_TP" ).append("\n"); 
		query.append(", B.BL_TP_CD" ).append("\n"); 
		query.append(", B.BKG_STS_CD" ).append("\n"); 
		query.append(", B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", D.BL_CVRD_TP_CD                  AS BL_CVRD_TP_CD" ).append("\n"); 
		query.append(", B.CHN_AGN_CD                     AS CHN_BKG_AGN_CD" ).append("\n"); 
		query.append(", B.BKG_OFC_CD" ).append("\n"); 
		query.append(", C.CLT_OFC_CD" ).append("\n"); 
		query.append(", B.BKG_CRE_DT" ).append("\n"); 
		query.append(", D.BDR_FLG" ).append("\n"); 
		query.append(", D.BDR_DT" ).append("\n"); 
		query.append(", @[por_cd]           AS POR_CD" ).append("\n"); 
		query.append(", @[por_finc]         AS POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[por_ar]           AS POR_AR_OFC_CD" ).append("\n"); 
		query.append(", @[pol_cd]           AS POL_CD" ).append("\n"); 
		query.append(", @[pol_finc]         AS POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[pol_ar]           AS POL_AR_OFC_CD" ).append("\n"); 
		query.append(", @[pod_cd]           AS POD_CD" ).append("\n"); 
		query.append(", @[pod_finc]         AS POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[pod_ar]           AS POD_AR_OFC_CD" ).append("\n"); 
		query.append(", @[del_cd]           AS DEL_CD" ).append("\n"); 
		query.append(", @[del_finc]         AS DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(", @[del_ar]           AS DEL_AR_OFC_CD" ).append("\n"); 
		query.append(", B.RCV_TERM_CD                   AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", B.DE_TERM_CD                    AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", C.TRD_CD" ).append("\n"); 
		query.append(", C.SLAN_CD" ).append("\n"); 
		query.append(", C.RLANE_CD" ).append("\n"); 
		query.append(", C.VSL_CD||C.SKD_VOY_NO||C.DIR_CD AS REV_VVD_CD" ).append("\n"); 
		query.append(", V.SLAN_CD                        AS TRNK_SLAN_CD" ).append("\n"); 
		query.append(", DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),N1ST_RLANE_CD" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),N2ND_RLANE_CD" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),N3RD_RLANE_CD" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),N4TH_RLANE_CD" ).append("\n"); 
		query.append("       ,'')                        AS TRNK_RLANE_CD" ).append("\n"); 
		query.append(", V.VSL_CD                         AS TRNK_VSL_CD" ).append("\n"); 
		query.append(", V.SKD_VOY_NO                     AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(", V.SKD_DIR_CD                     AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(", DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("       ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("       ,'')                        AS TRNK_REV_DIR_CD" ).append("\n"); 
		query.append(", B.SVC_SCP_CD                     AS SVC_SCP_CD" ).append("\n"); 
		query.append(", B.PRE_RLY_PORT_CD                AS PRE_PORT_CD" ).append("\n"); 
		query.append(", B.PST_RLY_PORT_CD                AS PST_PORT_CD" ).append("\n"); 
		query.append(", @[comm_proc_rslt_rsn] AS COMM_PROC_RSLT_RSN" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, MAS_RGST_BKG C , BKG_VVD V, BKG_BL_DOC D" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND V.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("AND D.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}