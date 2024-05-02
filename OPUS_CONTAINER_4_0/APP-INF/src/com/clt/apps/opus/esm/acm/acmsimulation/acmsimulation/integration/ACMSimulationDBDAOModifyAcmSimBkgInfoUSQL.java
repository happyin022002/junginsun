/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOModifyAcmSimBkgInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOModifyAcmSimBkgInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAcmSimBkgInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOModifyAcmSimBkgInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOModifyAcmSimBkgInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_SIM_BKG_INFO I1" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("        SELECT @[sim_no] AS SIM_NO" ).append("\n"); 
		query.append("        , B.BKG_NO" ).append("\n"); 
		query.append("        , B.BL_NO" ).append("\n"); 
		query.append("        , B.BL_NO_TP" ).append("\n"); 
		query.append("        , B.BL_TP_CD" ).append("\n"); 
		query.append("        , B.BKG_STS_CD" ).append("\n"); 
		query.append("        , B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        , D.BL_CVRD_TP_CD                  AS BL_CVRD_TP_CD" ).append("\n"); 
		query.append("        , B.CHN_AGN_CD                     AS CHN_BKG_AGN_CD" ).append("\n"); 
		query.append("        , B.BKG_OFC_CD" ).append("\n"); 
		query.append("        , C.CLT_OFC_CD" ).append("\n"); 
		query.append("        , B.BKG_CRE_DT" ).append("\n"); 
		query.append("        , D.BDR_FLG" ).append("\n"); 
		query.append("        , D.BDR_DT" ).append("\n"); 
		query.append("        , B.RCV_TERM_CD                   AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        , B.DE_TERM_CD                    AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("        , C.TRD_CD" ).append("\n"); 
		query.append("        , C.SLAN_CD" ).append("\n"); 
		query.append("        , C.RLANE_CD" ).append("\n"); 
		query.append("        , C.VSL_CD||C.SKD_VOY_NO||C.DIR_CD AS REV_VVD_CD" ).append("\n"); 
		query.append("        , V.SLAN_CD                        AS TRNK_SLAN_CD" ).append("\n"); 
		query.append("        , DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),N1ST_RLANE_CD" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),N2ND_RLANE_CD" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),N3RD_RLANE_CD" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),N4TH_RLANE_CD" ).append("\n"); 
		query.append("               ,'')                        AS TRNK_RLANE_CD" ).append("\n"); 
		query.append("        , V.VSL_CD                         AS TRNK_VSL_CD" ).append("\n"); 
		query.append("        , V.SKD_VOY_NO                     AS TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("        , V.SKD_DIR_CD                     AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("        , DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("               ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),10,1)" ).append("\n"); 
		query.append("               ,'')                        AS TRNK_REV_DIR_CD" ).append("\n"); 
		query.append("        , B.SVC_SCP_CD                     AS SVC_SCP_CD" ).append("\n"); 
		query.append("        , B.PRE_RLY_PORT_CD                AS PRE_PORT_CD" ).append("\n"); 
		query.append("        , B.PST_RLY_PORT_CD                AS PST_PORT_CD" ).append("\n"); 
		query.append("        , @[usr_id]                        AS UPD_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE                          AS UPD_DT" ).append("\n"); 
		query.append("        FROM BKG_BOOKING B, COA_RGST_BKG C , BKG_VVD V, BKG_BL_DOC D" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("        AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")I2 ON (I1.SIM_NO = I2.SIM_NO and I1.BKG_NO = I2.BKG_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("  I1.BL_NO             = I2.BL_NO" ).append("\n"); 
		query.append(", I1.BL_NO_TP          = I2.BL_NO_TP" ).append("\n"); 
		query.append(", I1.BL_TP_CD          = I2.BL_TP_CD" ).append("\n"); 
		query.append(", I1.BKG_STS_CD        = I2.BKG_STS_CD" ).append("\n"); 
		query.append(", I1.BKG_CGO_TP_CD     = I2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", I1.BL_CVRD_TP_CD     = I2.BL_CVRD_TP_CD" ).append("\n"); 
		query.append(", I1.CHN_BKG_AGN_CD    = I2.CHN_BKG_AGN_CD" ).append("\n"); 
		query.append(", I1.BKG_OFC_CD        = I2.BKG_OFC_CD" ).append("\n"); 
		query.append(", I1.CLT_OFC_CD        = I2.CLT_OFC_CD" ).append("\n"); 
		query.append(", I1.BKG_CRE_DT        = I2.BKG_CRE_DT" ).append("\n"); 
		query.append(", I1.BDR_FLG           = I2.BDR_FLG" ).append("\n"); 
		query.append(", I1.BDR_DT            = I2.BDR_DT" ).append("\n"); 
		query.append(", I1.BKG_RCV_TERM_CD   = I2.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", I1.BKG_DE_TERM_CD    = I2.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", I1.TRD_CD            = I2.TRD_CD" ).append("\n"); 
		query.append(", I1.SLAN_CD           = I2.SLAN_CD" ).append("\n"); 
		query.append(", I1.RLANE_CD          = I2.RLANE_CD" ).append("\n"); 
		query.append(", I1.REV_VVD_CD        = I2.REV_VVD_CD" ).append("\n"); 
		query.append(", I1.TRNK_SLAN_CD      = I2.TRNK_SLAN_CD" ).append("\n"); 
		query.append(", I1.TRNK_RLANE_CD     = I2.TRNK_RLANE_CD" ).append("\n"); 
		query.append(", I1.TRNK_VSL_CD       = I2.TRNK_VSL_CD" ).append("\n"); 
		query.append(", I1.TRNK_SKD_VOY_NO   = I2.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(", I1.TRNK_SKD_DIR_CD   = I2.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(", I1.TRNK_REV_DIR_CD   = I2.TRNK_REV_DIR_CD" ).append("\n"); 
		query.append(", I1.SVC_SCP_CD        = I2.SVC_SCP_CD" ).append("\n"); 
		query.append(", I1.PRE_PORT_CD       = I2.PRE_PORT_CD" ).append("\n"); 
		query.append(", I1.PST_PORT_CD       = I2.PST_PORT_CD" ).append("\n"); 
		query.append(", I1.UPD_USR_ID        = I2.UPD_USR_ID" ).append("\n"); 
		query.append(", I1.UPD_DT            = I2.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" I1.SIM_NO" ).append("\n"); 
		query.append(",I1.BKG_NO" ).append("\n"); 
		query.append(",I1.BL_NO" ).append("\n"); 
		query.append(",I1.BL_NO_TP" ).append("\n"); 
		query.append(",I1.BL_TP_CD" ).append("\n"); 
		query.append(",I1.BKG_STS_CD" ).append("\n"); 
		query.append(",I1.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",I1.BL_CVRD_TP_CD" ).append("\n"); 
		query.append(",I1.CHN_BKG_AGN_CD" ).append("\n"); 
		query.append(",I1.BKG_OFC_CD" ).append("\n"); 
		query.append(",I1.CLT_OFC_CD" ).append("\n"); 
		query.append(",I1.BKG_CRE_DT" ).append("\n"); 
		query.append(",I1.BDR_FLG" ).append("\n"); 
		query.append(",I1.BDR_DT" ).append("\n"); 
		query.append(",I1.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",I1.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",I1.TRD_CD" ).append("\n"); 
		query.append(",I1.SLAN_CD" ).append("\n"); 
		query.append(",I1.RLANE_CD" ).append("\n"); 
		query.append(",I1.REV_VVD_CD" ).append("\n"); 
		query.append(",I1.TRNK_SLAN_CD" ).append("\n"); 
		query.append(",I1.TRNK_RLANE_CD" ).append("\n"); 
		query.append(",I1.TRNK_VSL_CD" ).append("\n"); 
		query.append(",I1.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",I1.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",I1.TRNK_REV_DIR_CD" ).append("\n"); 
		query.append(",I1.SVC_SCP_CD" ).append("\n"); 
		query.append(",I1.PRE_PORT_CD" ).append("\n"); 
		query.append(",I1.PST_PORT_CD" ).append("\n"); 
		query.append(",I1.CRE_USR_ID" ).append("\n"); 
		query.append(",I1.CRE_DT" ).append("\n"); 
		query.append(",I1.UPD_USR_ID" ).append("\n"); 
		query.append(",I1.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[sim_no]" ).append("\n"); 
		query.append(",I2.BKG_NO" ).append("\n"); 
		query.append(",I2.BL_NO" ).append("\n"); 
		query.append(",I2.BL_NO_TP" ).append("\n"); 
		query.append(",I2.BL_TP_CD" ).append("\n"); 
		query.append(",I2.BKG_STS_CD" ).append("\n"); 
		query.append(",I2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",I2.BL_CVRD_TP_CD" ).append("\n"); 
		query.append(",I2.CHN_BKG_AGN_CD" ).append("\n"); 
		query.append(",I2.BKG_OFC_CD" ).append("\n"); 
		query.append(",I2.CLT_OFC_CD" ).append("\n"); 
		query.append(",I2.BKG_CRE_DT" ).append("\n"); 
		query.append(",I2.BDR_FLG" ).append("\n"); 
		query.append(",I2.BDR_DT" ).append("\n"); 
		query.append(",I2.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",I2.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",I2.TRD_CD" ).append("\n"); 
		query.append(",I2.SLAN_CD" ).append("\n"); 
		query.append(",I2.RLANE_CD" ).append("\n"); 
		query.append(",I2.REV_VVD_CD" ).append("\n"); 
		query.append(",I2.TRNK_SLAN_CD" ).append("\n"); 
		query.append(",I2.TRNK_RLANE_CD" ).append("\n"); 
		query.append(",I2.TRNK_VSL_CD" ).append("\n"); 
		query.append(",I2.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",I2.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",I2.TRNK_REV_DIR_CD" ).append("\n"); 
		query.append(",I2.SVC_SCP_CD" ).append("\n"); 
		query.append(",I2.PRE_PORT_CD" ).append("\n"); 
		query.append(",I2.PST_PORT_CD" ).append("\n"); 
		query.append(",I2.UPD_USR_ID" ).append("\n"); 
		query.append(",I2.UPD_DT" ).append("\n"); 
		query.append(",I2.UPD_USR_ID" ).append("\n"); 
		query.append(",I2.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}