/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Qta Edit for IAS Sector]을 [저장] 합니다.
	  * CSQ_CFM_QTA Insert (overall report에서 조회되도록)
	  * </pre>
	  */
	public QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_CFM_QTA " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                  ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,A1.BSE_YR" ).append("\n"); 
		query.append("                  ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("                  ,A1.TRD_CD" ).append("\n"); 
		query.append("                  ,A1.RLANE_CD" ).append("\n"); 
		query.append("                  ,A1.DIR_CD" ).append("\n"); 
		query.append("                  ,A1.VSL_CD" ).append("\n"); 
		query.append("                  ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("                  ,A1.RHQ_CD" ).append("\n"); 
		query.append("                  ,A1.AQ_CD" ).append("\n"); 
		query.append("                  ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("                  ,A1.LOD_QTY" ).append("\n"); 
		query.append("                  ,DECODE(A1.LOD_QTY, 0, 0, A1.GRS_RPB_REV/A1.LOD_QTY)" ).append("\n"); 
		query.append("                  ,DECODE(A1.LOD_QTY, 0, 0, A1.PA_CM_UC_AMT/A1.LOD_QTY)" ).append("\n"); 
		query.append("                  ,DECODE(A1.LOD_QTY, 0, 0, A1.RA_CM_UC_AMT/A1.LOD_QTY)" ).append("\n"); 
		query.append("                  ,'M' CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                  ,@[cre_usr_id]" ).append("\n"); 
		query.append("                  ,SYSDATE" ).append("\n"); 
		query.append("                  ,@[upd_usr_id]" ).append("\n"); 
		query.append("                  ,SYSDATE" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                          ,BSE_TP_CD" ).append("\n"); 
		query.append("                          ,BSE_YR" ).append("\n"); 
		query.append("                          ,BSE_QTR_CD" ).append("\n"); 
		query.append("                          ,OFC_VW_CD" ).append("\n"); 
		query.append("                          ,TRD_CD" ).append("\n"); 
		query.append("                          ,RLANE_CD" ).append("\n"); 
		query.append("                          ,DIR_CD" ).append("\n"); 
		query.append("                          ,VSL_CD" ).append("\n"); 
		query.append("                          ,SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,RGN_OFC_CD" ).append("\n"); 
		query.append("                          ,RHQ_CD" ).append("\n"); 
		query.append("                          ,AQ_CD" ).append("\n"); 
		query.append("                          ,DIR_CD AS CONV_DIR_CD" ).append("\n"); 
		query.append("                          ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("                          ,SUM(GRS_RPB_REV*LOD_QTY)   AS GRS_RPB_REV" ).append("\n"); 
		query.append("                          ,SUM(PA_CM_UC_AMT*LOD_QTY)  AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("                          ,SUM(RA_CM_UC_AMT*LOD_QTY)  AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("                    FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("                    WHERE BSE_TP_CD                = 'Q'" ).append("\n"); 
		query.append("                    AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("                    AND BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("                    AND BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                    AND OFC_VW_CD                  = SUBSTR(@[ofc_vw_cd], 0 ,1)" ).append("\n"); 
		query.append("					AND TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("                    AND RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("                    AND DIR_CD                     = @[dir_cd]" ).append("\n"); 
		query.append("                    AND RHQ_CD                     = @[rhq_cd]" ).append("\n"); 
		query.append("                    AND RGN_OFC_CD                 = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("                    AND VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO                 = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD                 = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    GROUP BY QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                          ,BSE_TP_CD" ).append("\n"); 
		query.append("                          ,BSE_YR" ).append("\n"); 
		query.append("                          ,BSE_QTR_CD" ).append("\n"); 
		query.append("                          ,OFC_VW_CD" ).append("\n"); 
		query.append("                          ,TRD_CD" ).append("\n"); 
		query.append("                          ,RLANE_CD" ).append("\n"); 
		query.append("                          ,DIR_CD" ).append("\n"); 
		query.append("                          ,VSL_CD" ).append("\n"); 
		query.append("                          ,SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,RGN_OFC_CD" ).append("\n"); 
		query.append("                          ,RHQ_CD" ).append("\n"); 
		query.append("                          ,AQ_CD" ).append("\n"); 
		query.append("                  ) A1" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}